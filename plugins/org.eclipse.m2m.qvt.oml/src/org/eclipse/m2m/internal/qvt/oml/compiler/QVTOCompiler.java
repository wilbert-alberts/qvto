/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.compiler;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QVTParsingOptions;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalFileEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParser;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalValidationVisitor;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalVisitorCS;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.ValidationMessages;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFileUtil;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.BundleFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.WorkspaceMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.AbstractQVTParser;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLexer;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.blackbox.LoadContext;
import org.eclipse.m2m.qvt.oml.blackbox.ResolutionContextImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.osgi.util.NLS;


public class QVTOCompiler {

	private static final String NAMESPACE_SEP = ".";

	public static final String PROBLEM_MARKER = "org.eclipse.m2m.qvt.oml.qvtProblem"; //$NON-NLS-1$    	
	
    private final Map<CFile, CompiledUnit> fSource2Compiled = new HashMap<CFile, CompiledUnit>();
    private final Stack<DependencyPathElement> fDependencyWalkPath = new Stack<DependencyPathElement>();    
    
    private final IImportResolver fImportResolver;
    private final BlackboxModuleHelper fBlackBoxProvider;
    private final QvtCompilerKernel myKernel;
    private final ResourceSet resourceSet;

    /**
	 * Creates compiler that caches already compiled modules until
	 * <code>cleanup</code> is explicitly called.
	 * <p>
	 * This enables to compile individual modules separately ensuring
	 * cross-referencing among already compiled modules.
	 * 
	 * @param importResolver
	 *            resolver for other moduleAST imports
	 * @param metamodelResourceSet
	 *            the resource set into which meta-model nsURI mapped to a resource location
	 *            are to be loaded. If it is <code>null</code>, a default resource set is created
	 *            automatically.
	 *            <p>
	 *            Note: The meta-models already loaded in the resource set are
	 *            reused                        
	 * @return the compiler instance
	 */
    public static QVTOCompiler createCompilerWithHistory(IImportResolver importResolver, ResourceSet metamodelResourceSet) { 
    	return new QVTOCompiler(importResolver, metamodelResourceSet) {
    		@Override
    		protected void afterCompileCleanup() {
    			// do nothing as we need to cross-reference cached modules on 
    			// next compilation requests
    		}
    		
    		@Override
    		public void cleanup() {    		
    			super.cleanup();
    			afterCompileCleanup();
    		}
    	};
    }
    
    public QVTOCompiler(IImportResolver importResolver, IMetamodelRegistryProvider metamodelRegistryProvider) {
	    fBlackBoxProvider = new BlackboxModuleHelper();
	    fImportResolver = importResolver;
	    
        myKernel = new QvtCompilerKernel(metamodelRegistryProvider);
        this.resourceSet = (metamodelRegistryProvider instanceof WorkspaceMetamodelRegistryProvider) ?
        		((WorkspaceMetamodelRegistryProvider) metamodelRegistryProvider).getResolutionResourceSet() : 
        			new ResourceSetImpl();
    }
	
	public QVTOCompiler(IImportResolver importResolver) {
		this(importResolver, new WorkspaceMetamodelRegistryProvider());
    }	

	/**
	 * Constructs QVT compiler using the given resolver and meta-model resource set.
	 * 
	 * @param importResolver
	 *            resolver of compilation unit imports
	 * @param metamodelResourceSet
	 *            the resource set into which meta-model nsURI mapped to a resource location
	 *            are to be loaded. If it is <code>null</code>, a default resource set is created
	 *            automatically.
	 *            <p>
	 *            Note: The meta-models already loaded in the resource set are
	 *            reused
	 */
	public QVTOCompiler(IImportResolver importResolver, ResourceSet metamodelResourceSet) {		
		this(importResolver, 
			metamodelResourceSet != null ?
					new WorkspaceMetamodelRegistryProvider(metamodelResourceSet) :
						new WorkspaceMetamodelRegistryProvider());
    }
				
	public CompiledUnit[] compile(CFile[] sources, QvtCompilerOptions options, IProgressMonitor monitor) throws MdaException {
		if(options == null) {
			options = getDefaultOptions();			
		}
		
		if(monitor == null) {
			monitor = new NullProgressMonitor();
		}
		
		CompiledUnit[] result = new CompiledUnit[sources.length];

		try {
			monitor.beginTask("", sources.length); //$NON-NLS-1$
			
			int i = 0;
			for (CFile nextSource : sources) {
	            if(monitor.isCanceled()) {
	            	throw new OperationCanceledException();
	            }
				
				monitor.setTaskName(nextSource.getFullPath());
				
				result[i++] = compileSingleFile(nextSource, options, monitor);
				
				monitor.worked(1);
			}
		} finally {
			fDependencyWalkPath.clear();
			afterCompileCleanup();
			
			monitor.done();
		}
		
		return result;
	}
	
	public CompiledUnit compile(CFile source, QvtCompilerOptions options, IProgressMonitor monitor) throws MdaException {
		if(monitor == null) {
			monitor = new NullProgressMonitor();
		}
		
		if(options == null) {
			options = getDefaultOptions();			
		}		
		
		try {
			return compileSingleFile(source, options, monitor);
		} finally {
			fDependencyWalkPath.clear();
			afterCompileCleanup();
		}
	}
	
    protected CSTParseResult parse(CFile source, QvtCompilerOptions options) throws ParserException {
    	Reader is = null;
    	MappingModuleCS moduleCS = null;
    	try {
    		is = CFileUtil.getReader(source);    		
	    	QvtOperationalFileEnv env = new QvtOperationalEnvFactory().createEnvironment(source, myKernel);
        	if(options.isEnableCSTModelToken()) {
        		env.setOption(QVTParsingOptions.ENABLE_CSTMODEL_TOKENS, true);
        	}
	    	
	    	QvtOperationalParser qvtParser = new QvtOperationalParser();
	    	moduleCS = qvtParser.parse(is, source.getName(), env);
	    	
	    	CSTParseResult result = new CSTParseResult();
	    	result.moduleCS = moduleCS;
	    	result.env = env;
	    	result.parser = qvtParser.getParser();
	    	return result;
	    	
    	} catch(IOException e) {
    		String ioErrorMessage = NLS.bind(CompilerMessages.sourceReadingIOError, source.getFullPath());
    		throw new ParserException(ioErrorMessage, e);
    	} finally {
            if(is != null) {            	
            	try {
					is.close();
				} catch (IOException e) {
					// ignore
				} 
            }
    	}
    	
    }
    
	protected Module analyze(CSTParseResult parseResult, UnitImportResolver unitImportResolver, QvtCompilerOptions options) {
		QvtOperationalFileEnv env = parseResult.env;
		env.setQvtCompilerOptions(options);

		Module module = null;
		try { 
			QvtOperationalVisitorCS visitor = createAnalyzer(parseResult.parser, options);			
			module = visitor.visitMappingModule(parseResult.moduleCS, unitImportResolver.getImporter(), env, unitImportResolver, getResourceSet());
		} catch (SemanticException e) {
			env.reportError(e.getLocalizedMessage(), 0, 0);
		}
		
		if (module != null && options.isReportErrors()) {
			env.setCheckForDuplicateErrors(true);
			QvtOperationalValidationVisitor validation = new QvtOperationalValidationVisitor(env);
			validation.visitModule(module);
			env.setCheckForDuplicateErrors(false);
		}
		
		return module;
	}
    
    protected QvtOperationalVisitorCS createAnalyzer(AbstractQVTParser parser, QvtCompilerOptions options) {
    	return new QvtOperationalVisitorCS(parser, options);
    }    
    
	protected IImportResolver getImportResolver() {
		return fImportResolver;
	}

    protected void afterCompileCleanup() {
    	this.fSource2Compiled.clear();
    	this.fDependencyWalkPath.clear();    	
    }
	
    /**
     * The main compilation method - the common entry point to the compilation 
     */
	private CompiledUnit compileSingleFile(CFile source, QvtCompilerOptions options, IProgressMonitor monitor) throws MdaException {
        		
        CompiledUnit nextResult = null;
        try {        	
        	nextResult = doCompile(source, options, monitor); 
		} 
		catch (ParserException e) {
			Throwable cause = e.getCause() != null ? e.getCause() : e;
			throw new MdaException(cause.getMessage(), cause);
		}
                
        return nextResult;        
    }
	
    private CompiledUnit doCompile(final CFile source, QvtCompilerOptions options, IProgressMonitor monitor) throws ParserException {
    	if(fSource2Compiled.containsKey(source)) {
    		return fSource2Compiled.get(source);
    	}

    	monitor = new SubProgressMonitor(monitor, 1);
    	monitor.beginTask(source.getFullPath(), 3);
    	
		List<CompiledUnit> compiledImports = null;
		DependencyPathElement dependencyElement = new DependencyPathElement(source);
    	try {
        	fDependencyWalkPath.push(dependencyElement);
        	// perform to syntax parsing
	    	CSTParseResult parseResult = parse(source, options);
	    	monitor.worked(1);

			QvtOperationalFileEnv env = parseResult.env;
    		dependencyElement.importerEnv = env;
			
	    	MappingModuleCS moduleCS = parseResult.moduleCS;
			if(moduleCS != null) {
				UnitResolverImpl unitResolver = new UnitResolverImpl(source);
		    	
		    	for (ImportCS nextImportCS : moduleCS.getImports()) {
		            String importQNameStr = getQualifiedName(nextImportCS);
		            if(importQNameStr == null || importQNameStr.length() == 0) {
		            	// nothing reasonable to look for, syntax error
		            	continue;
		            }

	            	List<String> importedUnitQName = nextImportCS.getPathNameCS().getSequenceOfNames();		            	            	
	            	CFile importedFile = getImportedFile(source, importQNameStr);	            	
	            	CompiledUnit compiledImport = null;	            	

	            	if(importedFile != null) {
	            		// check for cyclic import error condition
	            		dependencyElement.currentProcessedImport = nextImportCS;
	            		
	            		DependencyPathElement importerDependencyElement = findDependencyElement(importedFile);
	            		if(importerDependencyElement != null) {
			            	ImportCS importedCS = importerDependencyElement.currentProcessedImport;
	            			// not cached compiled unit yet, but we got here into a cycle 
			            	if(env != importerDependencyElement.importerEnv ) {
			            		reportCyclicImportError(nextImportCS, importedCS, env);
			            	}
			            	
			            	// report the cyclic problem in the opposite direction
			            	reportCyclicImportError(importedCS, nextImportCS, env);
			            	
			            	continue;			            		
	            		}
	            		
	            		compiledImport = doCompile(importedFile, options, monitor); 
	            	} else {
	            		List<QvtOperationalModuleEnv> bboxModules = loadBlackbox(env, nextImportCS);
	            		if(bboxModules == null) {
	            			String notFoundMessage = NLS.bind(CompilerMessages.importedCompilationUnitNotFound, 
	            					QvtOperationalParserUtil.getStringRepresentation(nextImportCS.getPathNameCS(), NAMESPACE_SEP));
	    	        		env.reportError(notFoundMessage, nextImportCS.getPathNameCS());
	            		} 
	            		else if(!bboxModules.isEmpty()) {
	            			// found but failed to load,  errors reported in loadBlackbox()
	            			compiledImport = new CompiledUnit(importedUnitQName, bboxModules);
	            		}
	            	}
	            
	        		if(compiledImport != null) {	        			
	        			if(compiledImport.getSource() != null && !compiledImport.getErrors().isEmpty()) {
	        				// TODO - source =null indicates blackbox lib now 
	        				String errorInImportMessage = NLS.bind(CompilerMessages.importHasCompilationError, 
	        						QvtOperationalParserUtil.getStringRepresentation(nextImportCS.getPathNameCS()));	        				
	        				env.reportError(errorInImportMessage, nextImportCS.getPathNameCS());
	        			}
	        				        				        			
	        			if(compiledImports == null) {
	        				compiledImports = new ArrayList<CompiledUnit>();		        				
	        			}

	        			if(compiledImport.getSource() != null) {
	        				compiledImports.add(compiledImport);
	        			}

	        			unitResolver.addUnit(importedUnitQName, compiledImport);
	        		}
		    	}
				    	
		    	// announce CST and imports done
		    	monitor.worked(1); 
		
		    	// perform CST analysis
		    	Module analysisResult = analyze(parseResult, unitResolver, options);
		    	if(analysisResult != null) {
		            if(options.isSourceLineNumbersEnabled()) {
		            	addSourceLineNumberInfo(parseResult.parser, analysisResult, source);        	
		            }		    		
		    	}
		    	
		    	// report possible duplicate imports
		    	checkForDupImports(moduleCS.getImports(), env);
	    	}
	    	
			// get rid of parser allocated data 
	    	env.close(); // TODO - check whether we can use dispose()	    	
	    	// FIXME - construct proper qualified name
	    	CompiledUnit result = new CompiledUnit(Collections.singletonList(source.getUnitName()), source, env);
	    	// TODO - make this optional as we not always want to carry the whole CST
	    	result.fModuleCST = moduleCS;
	    
	    	if(compiledImports != null) {
	    		result.setImports(compiledImports);
	    	}
	    
	    	// put to central compilation result cache
	    	// TODO - better to use this one as unit resolver 
	    	fSource2Compiled.put(source, result);
	    	
	    	monitor.worked(1);	    	
	    	return result;
	    	
    	} finally {
    		fDependencyWalkPath.pop();
    		
	    	monitor.done();    		
    	}
    }
	
	// TODO - used in GMF/Xpand, consider refactoring to avoid exposing this internals
    public BlackboxModuleHelper getBlackboxUnitHelper() {
    	return fBlackBoxProvider;
    }	

	public QvtCompilerKernel getKernel() {
		return myKernel;
	}
	
	public ResourceSet getResourceSet() {
		return resourceSet;
	}
	
	public void cleanup() {
		for (Resource res : getResourceSet().getResources()) {
			res.unload();
		}
	}
	
	private void addSourceLineNumberInfo(AbstractQVTParser parser, Module moduleAST, CFile source) {
		QvtOpLexer lexer = parser.getLexer();
		if (lexer != null) {
			URI sourceURI = null;
			try {
				try {
					if (source instanceof BundleFile) {
						sourceURI = URI.createURI(source.getFullPath());
					}
					else {
						sourceURI = URI.createURI(source.getFileStore().toURI().toString());
					}
				} catch (IOException e) {
					QvtPlugin.logError("Can't get QVT source URI", e); //$NON-NLS-1$
				} catch (UnsupportedOperationException ex) {
					sourceURI = URI.createURI(source.getFullPath());
				}
			} catch (IllegalArgumentException e) {
				// there is no contract on the path being a URI, 
				// catch if not a valid URI, should not affect normal RUN model QVT execution
			}

			if(sourceURI != null) {
				//final String s = new String(lexer.getInputChars());
				//ASTBindingHelper.createModuleSourceBinding(moduleAST, sourceURI, new StringLineNumberProvider(s));
				ASTBindingHelper.createModuleSourceBinding(moduleAST, sourceURI, new BasicLineNumberProvider(lexer));				
			}
		}
	}
    
    private static String getQualifiedName(ImportCS importCS) {
    	if(importCS.getPathNameCS() != null) {
    		EList	<String> sequenceOfNames = importCS.getPathNameCS().getSequenceOfNames();
    		 return QvtOperationalParserUtil.getStringRepresentation(sequenceOfNames, NAMESPACE_SEP); //$NON-NLS-1$
    	}
    	return null;
    }
    
    private CFile getImportedFile(final CFile source, final String qualifiedName) {
    	CFile importSource = getImportResolver().resolveImport(qualifiedName);
    	if (importSource == null) {
    		importSource = getImportResolver().resolveImport(source, qualifiedName);
    	}
    	return importSource;
    }
    
	private List<QvtOperationalModuleEnv> loadBlackbox(QvtOperationalFileEnv loadingEnv, ImportCS nextImportCS) {
		BlackboxModuleHelper blackboxUnitHelper = getBlackboxUnitHelper();
		blackboxUnitHelper.setContext(new ResolutionContextImpl(
				loadingEnv.getFile()), new LoadContext(loadingEnv.getEPackageRegistry()));
		
		EList<String> sequenceOfNames = nextImportCS.getPathNameCS().getSequenceOfNames();
		List<Module> bboxModules = blackboxUnitHelper.getModules(sequenceOfNames);
		
		if(bboxModules != null) {
			List<QvtOperationalModuleEnv> moduleEnvs = new ArrayList<QvtOperationalModuleEnv>(bboxModules.size());
			for (Module module : bboxModules) {
				moduleEnvs.add(blackboxUnitHelper.getModuleEnvironment(module));
			}

			return moduleEnvs;
			
		} else if(blackboxUnitHelper.loadFailed(sequenceOfNames)) {
			PathNameCS pathNameCS = nextImportCS.getPathNameCS();
			loadingEnv.reportError(QvtOperationalParserUtil.wrappInSeeErrorLogMessage(NLS.bind(ValidationMessages.FailedToLoadLibrary, 
					new Object[] { QvtOperationalParserUtil.getStringRepresentation(pathNameCS, NAMESPACE_SEP) })), pathNameCS); //$NON-NLS-1$
			return Collections.emptyList();
		}
		
		return null;
	}
    
    private QvtCompilerOptions getDefaultOptions() {
    	QvtCompilerOptions options = new QvtCompilerOptions();
    	options.setGenerateCompletionData(false);
		return options;
    }
    
    private List<String> getImportQName(ImportCS importCS) {
		PathNameCS pathNameCS = importCS.getPathNameCS();
		if(pathNameCS != null && !pathNameCS.getSequenceOfNames().isEmpty()) {
			return pathNameCS.getSequenceOfNames();
		}
		return null;
    }
    
    private void checkForDupImports(List<ImportCS> imports, QvtOperationalEnv env) {
    	List<List<String>> checkedImports = new ArrayList<List<String>>(imports.size());
    	List<ImportCS> dupImports = new LinkedList<ImportCS>();
    	
    	for(ListIterator<ImportCS> it = imports.listIterator(); it.hasNext();) {
    		ImportCS nextImportCS = it.next();			
    		List<String> checkedQName = getImportQName(nextImportCS);

    		if(checkedQName != null) {
    			if(checkedImports.contains(checkedQName)) {
    				dupImports.add(nextImportCS);
    			} else {
    				checkedImports.add(checkedQName);
    			}
    		}
		}
    	
    	for (ImportCS nextDupImport : dupImports) {
			PathNameCS problemCS = nextDupImport.getPathNameCS();
			env.reportWarning(NLS.bind(CompilerMessages.compilationUnitAlreadyImported,
					QvtOperationalParserUtil.getStringRepresentation(problemCS, NAMESPACE_SEP)), problemCS);
		}
    }
    
    private static void reportCyclicImportError(ImportCS from, ImportCS to, QvtOperationalEnv env) {
    	// Remark: we are safe to access pathNameCS as they must have been used to detect the cycle
    	PathNameCS fromQNameCS = from.getPathNameCS();
		PathNameCS toQNameCS = to.getPathNameCS();
		String message = NLS.bind(CompilerMessages.cyclicImportError, 
				QvtOperationalParserUtil.getStringRepresentation(fromQNameCS, NAMESPACE_SEP), 
				QvtOperationalParserUtil.getStringRepresentation(toQNameCS, NAMESPACE_SEP));
		
    	env.reportError(message, toQNameCS);
    }
    
    static void clearITokens(CSTNode node) {    	
    	node.setStartToken(null);    			
    	node.setEndToken(null);
		
    	TreeIterator<EObject> it = node.eAllContents();
    	while(it.hasNext()) {
    		EObject next = it.next();
    		if(next instanceof CSTNode) {
    			CSTNode nextCST = (CSTNode) next;
    			nextCST.setStartToken(null);    			
    			nextCST.setEndToken(null);
    		}
    	}
    }    
    
    private static class UnitResolverImpl implements UnitImportResolver {
		private final Map<List<String>, CompiledUnit> qName2CU;
		private final CFile source;

		private UnitResolverImpl(CFile importer) {
			this.qName2CU = new HashMap<List<String>, CompiledUnit>(5);			
			this.source = importer;
		}		

		void addUnit(List<String> qualifiedName, CompiledUnit unit) {
			qName2CU.put(qualifiedName, unit);
		}
		
		public CFile getImporter() {        		
			return source;
		}

		public CompiledUnit resolve(List<String> unitQName) {
			if(unitQName == null) {
				throw new IllegalArgumentException();
			}
			
			return qName2CU.get(unitQName);
		}
	}

	protected static class CSTParseResult {    	
    	public MappingModuleCS moduleCS;
    	public QvtOperationalFileEnv env;
    	public AbstractQVTParser parser;
    	
    	public CSTParseResult() {}    	
    }
	
	private DependencyPathElement findDependencyElement(CFile source) {
		for (DependencyPathElement element : fDependencyWalkPath) {
			if(source.equals(element.importer)) {
				return element;
			}
		}
		
		return null;
	}
	
	private static class DependencyPathElement {
		final CFile importer;
		ImportCS currentProcessedImport;
		QvtOperationalEnv importerEnv;;		

		public DependencyPathElement(CFile importer) {
			this.importer = importer;
		}
	}
}