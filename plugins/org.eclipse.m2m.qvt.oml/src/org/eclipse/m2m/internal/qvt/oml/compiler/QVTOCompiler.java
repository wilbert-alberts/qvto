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
import java.util.Arrays;
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
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
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
import org.eclipse.m2m.internal.qvt.oml.ast.parser.ExternalUnitElementsProvider;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.WorkspaceMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitContents.ModelContents;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.UnitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.AbstractQVTParser;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLexer;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.osgi.util.NLS;


public class QVTOCompiler {

	private static final String NAMESPACE_SEP = UnitProxy.NAMESPACE_SEP;
	
    private final Map<UnitProxy, CompiledUnit> fSource2Compiled = new HashMap<UnitProxy, CompiledUnit>();
    private final Stack<DependencyPathElement> fDependencyWalkPath = new Stack<DependencyPathElement>();    
    
    private final UnitResolver fUnitResolver;
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
    public static QVTOCompiler createCompilerWithHistory(UnitResolver importResolver, ResourceSet metamodelResourceSet) { 
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
    
    
    public static ResourceSet createResourceSet() {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		resourceSet.setURIResourceMap(new EPackageRegistryBasedURIResourceMap(resourceSet.getURIConverter()));
		return resourceSet;
    }
    
    public QVTOCompiler(UnitResolver unitResolver, IMetamodelRegistryProvider metamodelRegistryProvider) {
	    fUnitResolver = unitResolver;
	    
        myKernel = new QvtCompilerKernel(metamodelRegistryProvider);
        this.resourceSet = (metamodelRegistryProvider instanceof WorkspaceMetamodelRegistryProvider) ?
        		((WorkspaceMetamodelRegistryProvider) metamodelRegistryProvider).getResolutionResourceSet() : 
        			new ResourceSetImpl();
    }
	
	public QVTOCompiler(UnitResolver importResolver) {
		this(importResolver, new WorkspaceMetamodelRegistryProvider(createResourceSet()));
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
	public QVTOCompiler(UnitResolver importResolver, ResourceSet metamodelResourceSet) {		
		this(importResolver, 
			metamodelResourceSet != null ?
					new WorkspaceMetamodelRegistryProvider(metamodelResourceSet) :
						new WorkspaceMetamodelRegistryProvider());
    }	
				
	public CompiledUnit[] compile(UnitProxy[] sources, QvtCompilerOptions options, IProgressMonitor monitor) throws MdaException {
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
			for (UnitProxy nextSource : sources) {
	            if(monitor.isCanceled()) {
	            	throw new OperationCanceledException();
	            }
				
				monitor.setTaskName(nextSource.getURI().toString());
				
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
	
	/**
	 * 
	 * @param qualifiedName the qualified name referring to a compilation unit
	 * @param options compiler options
	 * @param monitor monitor
	 * @return compiled unit
	 * @throws MdaException
	 */
	public CompiledUnit compile(String qualifiedName, QvtCompilerOptions options, IProgressMonitor monitor) throws MdaException {
		UnitProxy unit = getImportResolver().resolveUnit(qualifiedName);
		if(unit == null) {
			throw new MdaException("Unresolved unit: " + qualifiedName);
		}
		
		return compile(unit, options, monitor);
	}
	
	public CompiledUnit compile(UnitProxy source, QvtCompilerOptions options, IProgressMonitor monitor) throws MdaException {
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
	
    protected CSTParseResult parse(UnitProxy source, QvtCompilerOptions options) throws ParserException {
    	Reader reader = null;
    	UnitCS unitCS = null;
    	try {
    		reader = createReader(source);
	    	
    		QvtOperationalFileEnv env = new QvtOperationalEnvFactory().createEnvironment(source.getURI(), myKernel);
        	if(options.isEnableCSTModelToken()) {
        		env.setOption(QVTParsingOptions.ENABLE_CSTMODEL_TOKENS, true);
        	}
	    	
	    	QvtOperationalParser qvtParser = new QvtOperationalParser();
	    	unitCS = qvtParser.parse(reader, source.getName(), env);
	    	
	    	CSTParseResult result = new CSTParseResult();
	    	result.unitCS = unitCS;
	    	result.env = env;
	    	result.parser = qvtParser.getParser();
	    	return result;
	    	
    	} catch(IOException e) {
    		String ioErrorMessage = NLS.bind(CompilerMessages.sourceReadingIOError, source.getURI());
    		throw new ParserException(ioErrorMessage, e);
    	} finally {
            if(reader != null) {            	
            	try {
					reader.close();
				} catch (IOException e) {
					// ignore
				} 
            }
    	}
    	
    }

    public static Reader getContentReader(UnitProxy unit) throws IOException {
		UnitContents contents = unit.getContents();
		if(contents instanceof UnitContents.CSTContents == false) {
			throw new IllegalArgumentException("unit has no CST stream"); //$NON-NLS-1$
		}
		
		UnitContents.CSTContents cst = (UnitContents.CSTContents) contents;
		return cst.getContents();    	
    }
    
	protected Reader createReader(UnitProxy unit) throws IOException {
		return getContentReader(unit);
	}
    
	protected CSTAnalysisResult analyze(CSTParseResult parseResult, ExternalUnitElementsProvider externalUnitElementsProvider, QvtCompilerOptions options) {
		QvtOperationalFileEnv env = parseResult.env;
		env.setQvtCompilerOptions(options);

		CSTAnalysisResult result = new CSTAnalysisResult();
		try {
			QvtOperationalVisitorCS visitor = createAnalyzer(parseResult.parser, options);
			UnitCS unitCS = parseResult.unitCS;
			if(!unitCS.getModules().isEmpty()) {
				// FIXME - need to handle multiple modules			
				MappingModuleCS topModuleCS = unitCS.getModules().get(0);
				Module module = visitor.visitMappingModule(topModuleCS, 
							externalUnitElementsProvider.getImporter(), 
							env, externalUnitElementsProvider, getResourceSet());
				
				result.modules = Collections.singletonList(module);
			}
		} catch (SemanticException e) {
			env.reportError(e.getLocalizedMessage(), 0, 0);
		}

		if(result.modules != null) {
			for(Module nextModule : result.modules) {
				if (options.isReportErrors()) {
					env.setCheckForDuplicateErrors(true);
					QvtOperationalValidationVisitor validation = new QvtOperationalValidationVisitor(env);
					validation.visitModule(nextModule);
					env.setCheckForDuplicateErrors(false);
				}
			}
		}
		
		return result;
	}
    
    protected QvtOperationalVisitorCS createAnalyzer(AbstractQVTParser parser, QvtCompilerOptions options) {
    	return new QvtOperationalVisitorCS(parser, options);
    }    
    
	protected UnitResolver getImportResolver() {
		return fUnitResolver;
	}

    protected void afterCompileCleanup() {
    	this.fSource2Compiled.clear();
    	this.fDependencyWalkPath.clear();    	
    }
	
	/**
	 * Notification operation which is called when a compilation unit and its
	 * imported units has been compiled.
	 * <p>
	 * Subclasses may override this operation
	 * 
	 * @param unit
	 *            the unit the compilation of which was finished
	 */
    protected void onCompilationUnitFinished(CompiledUnit unit) {
    	// do nothing, clients will override
    }
    
    /**
     * The main compilation method - the common entry point to the compilation 
     */
	private CompiledUnit compileSingleFile(UnitProxy source, QvtCompilerOptions options, IProgressMonitor monitor) throws MdaException {
        		
        CompiledUnit nextResult = null;
        try {        	
        	nextResult = doCompile(source, options, monitor); 
		} 
		catch (ParserException e) {
			Throwable cause = e.getCause() != null ? e.getCause() : e;
			throw new MdaException(cause.getMessage(), cause);
		}
		catch (IOException e) {
			throw new MdaException(e.getMessage(), e);			
		}
                
        return nextResult;        
    }
		
    private CompiledUnit doCompile(final UnitProxy source, QvtCompilerOptions options, IProgressMonitor monitor) throws ParserException, IOException {
    	if(fSource2Compiled.containsKey(source)) {
    		return fSource2Compiled.get(source);
    	}

    	monitor = new SubProgressMonitor(monitor, 1);
    	monitor.beginTask(source.getURI().toString(), 3);
    	
		List<CompiledUnit> compiledImports = null;
		DependencyPathElement dependencyElement = new DependencyPathElement(source);
    	try {
        	fDependencyWalkPath.push(dependencyElement);
        	
        	if(source.getContentType() != UnitProxy.TYPE_CST_STREAM) {
        		CompiledUnit loadBlackboxUnit = loadBlackboxUnit(source);        		
        		fSource2Compiled.put(source, loadBlackboxUnit);

        		monitor.worked(1);        		
				return loadBlackboxUnit;
        	}
        	
        	// perform to syntax parsing
	    	CSTParseResult parseResult = parse(source, options);
	    	monitor.worked(1);

			QvtOperationalFileEnv env = parseResult.env;
    		dependencyElement.importerEnv = env;
			
	    	UnitCS unitCS = parseResult.unitCS;
			UnitResolverImpl unitResolver = new UnitResolverImpl(source);
	    	List<ImportCS> allUnitImportsCS = parseResult.getImports();
	    	
			for (ImportCS nextImportCS : allUnitImportsCS) {
	            String importQNameStr = getQualifiedName(nextImportCS);
	            if(importQNameStr == null || importQNameStr.length() == 0) {
	            	// nothing reasonable to look for, syntax error should have been reported
	            	continue;
	            }

            	List<String> importedUnitQName = nextImportCS.getPathNameCS().getSequenceOfNames();		            	            	
            	UnitProxy importedUnit = resolveImportedUnit(source, importQNameStr);
            	CompiledUnit compiledImport = null;	            	

            	if(importedUnit != null) {
            		// check for cyclic import error condition
            		dependencyElement.currentProcessedImport = nextImportCS;
            		
            		DependencyPathElement importerDependencyElement = findDependencyElement(importedUnit);
            		if(importerDependencyElement != null) {
		            	ImportCS importedCS = importerDependencyElement.currentProcessedImport;
            			// not cached compiled unit yet, but we got here into a cycle 
		            	if(env != importerDependencyElement.importerEnv) {
		            		reportCyclicImportError(nextImportCS, importedCS, importerDependencyElement.importerEnv);
		            	}
		            	
		            	// report the cyclic problem in the opposite direction
		            	reportCyclicImportError(importedCS, nextImportCS, env);
		            	// skip addition to the list of imports
		            	continue;			            		
            		}
            		
            		compiledImport = doCompile(importedUnit, options, monitor);
            		
            	} else {
            		// report that unit was not resolved
        			String notFoundMessage = NLS.bind(CompilerMessages.importedCompilationUnitNotFound, 
        					QvtOperationalParserUtil.getStringRepresentation(nextImportCS.getPathNameCS(), NAMESPACE_SEP));
	        		env.reportError(notFoundMessage, nextImportCS.getPathNameCS());
            	}

        		if(compiledImport != null) {
        			if(!compiledImport.getErrors().isEmpty()) {
        				if(importedUnit.getContentType() == UnitProxy.TYPE_CST_STREAM) {
	        				String errorInImportMessage = NLS.bind(CompilerMessages.importHasCompilationError, 
	        						QvtOperationalParserUtil.getStringRepresentation(nextImportCS.getPathNameCS()));	        				
	        				env.reportError(errorInImportMessage, nextImportCS.getPathNameCS());
        				} else {
        					String rootMessage = compiledImport.getErrors().get(0).getMessage();
							env.reportError(rootMessage, nextImportCS.getPathNameCS());
        				}
        			}
        				        				        			
        			if(compiledImports == null) {
        				// Note: Must be uniques as we process import duplicates to report problems
        				compiledImports = new UniqueEList<CompiledUnit>();
        			}

        			compiledImports.add(compiledImport);

        			unitResolver.addUnit(importedUnitQName, compiledImport);
        		}
        		
	    	} // end of imports processing
			    	
	    	// announce CST and imports done
	    	monitor.worked(1); 
	
	    	// perform CST analysis
	    	CSTAnalysisResult analysisResult = analyze(parseResult, unitResolver, options);
			if(options.isSourceLineNumbersEnabled()) {
	        	addSourceLineNumberInfo(parseResult.parser, analysisResult, source);
	    	}
	    	
	    	// report possible duplicate imports
	    	checkForDupImports(allUnitImportsCS, env);
	    	
			// get rid of parser allocated data 
	    	env.close(); // TODO - check whether we can use dispose()	    	
	    	// FIXME - construct proper qualified name
	    	CompiledUnit result = createCompiledUnit(source, env);
	    	// TODO - make this optional as we not always want to carry the whole CST
	    	result.fUnitCST = unitCS;
	    
	    	if(compiledImports != null) {
	    		result.setImports(compiledImports);
	    	}
	    
	    	// put to central compilation result cache
	    	// TODO - better to use this one as unit resolver 
	    	fSource2Compiled.put(source, result);

	    	// FIXME - temp solution check for being a CST parsed
	    	if(result.getURI().isPlatformResource()) {
	    		onCompilationUnitFinished(result);
	    	}
	    	
	    	monitor.worked(1);	    	
	    	return result;
	    	
    	} finally {
    		fDependencyWalkPath.pop();
    		
	    	monitor.done();    		
    	}
    }

    private static String[] getNameSegments(String qualifiedName) {
		return qualifiedName.split("\\."); //$NON-NLS-1$    	
    }
    
	private static CompiledUnit createCompiledUnit(UnitProxy unit, QvtOperationalFileEnv env) {
		List<String> qualifiedName = getQualifiedNameSegments(unit);		
		return new CompiledUnit(qualifiedName, unit.getURI(), Collections.singletonList(env));
	}

	private static List<String> getQualifiedNameSegments(UnitProxy unit) {
		List<String> qualifiedName = null;		
		String namespace = unit.getNamespace();		
		if(namespace != null) {
			String[] segments = getNameSegments(namespace);
			qualifiedName = new ArrayList<String>(segments.length + 1);
			qualifiedName.addAll(Arrays.asList(segments));
			
			qualifiedName.add(unit.getName());
		} else {
			qualifiedName = Collections.singletonList(unit.getName()); 
		}
		return qualifiedName;
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
	
	private void addSourceLineNumberInfo(AbstractQVTParser parser, CSTAnalysisResult analysisResult, UnitProxy source) {
		QvtOpLexer lexer = parser.getLexer();
		if (lexer != null) {
			URI sourceURI = source.getURI();
			if(sourceURI != null && analysisResult.modules != null) {
				for (Module module : analysisResult.modules) {
					ASTBindingHelper.createModuleSourceBinding(module, sourceURI, new BasicLineNumberProvider(lexer));					
				}
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
    
//    private UnitProxy getImportedFile(final UnitProxy source, final String qualifiedName) {
//    	UnitProxy importSource = getImportResolver().resolveUnit(qualifiedName);
// FIXME -
// This used to be introduced as part of a bug fix, ask Sergey    	
//    	if (importSource == null) {
//    		importSource = getImportResolver().resolveImport(source, qualifiedName);
//    	}
//    	return importSource;
//    }

    private CompiledUnit loadBlackboxUnit(UnitProxy unit) throws IOException {
    	ModelContents contents = (ModelContents) unit.getContents();

    	List<EObject> topElements = contents.loadElements(getResourceSet().getPackageRegistry());
    	List<QvtOperationalModuleEnv> modelEnvs = new ArrayList<QvtOperationalModuleEnv>(topElements.size());
    	
    	for (EObject nextElement : topElements) {
    		QvtOperationalModuleEnv nextEnv = ASTBindingHelper.getEnvironment(nextElement, QvtOperationalModuleEnv.class);
    		if(nextEnv != null) {
    			// FIXME -
    			// clear the environment problems, for now we do not consider errors
    			// like duplicate operation definitions to cause the importing unit to fail
    			nextEnv.clearProblems();
    			
    			modelEnvs.add(nextEnv);
    		}
		}

    	
    	CompiledUnit compiledUnit = new CompiledUnit(getQualifiedNameSegments(unit), unit.getURI(), modelEnvs);
    	Diagnostic loadProblems = contents.getProblems();
		if(loadProblems != null) {
    		compiledUnit.addProblem(new QvtMessage(loadProblems.getMessage()));
    	}
    	
		return compiledUnit;
    }    
    
    private QvtCompilerOptions getDefaultOptions() {
    	QvtCompilerOptions options = new QvtCompilerOptions();
    	options.setGenerateCompletionData(false);
		return options;
    }

	@SuppressWarnings("deprecation")
	private UnitProxy resolveImportedUnit(UnitProxy importingUnit, String unitQualifiedName) {
		UnitProxy unit = importingUnit.getResolver().resolveUnit(unitQualifiedName);
		// Handle legacy imports from deployed transformations
    	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=240192
    	if(unit == null && importingUnit.getResolver() instanceof LegacyResolverSupport) {
    		LegacyResolverSupport legacyResolver = (LegacyResolverSupport)importingUnit.getResolver();
			unit = legacyResolver.resolveUnit(importingUnit, unitQualifiedName);
    	}
    	
    	return unit;
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
    
    private static class UnitResolverImpl implements ExternalUnitElementsProvider {
		private final Map<List<String>, CompiledUnit> qName2CU;
		private final UnitProxy source;

		private UnitResolverImpl(UnitProxy importer) {
			this.qName2CU = new HashMap<List<String>, CompiledUnit>(5);			
			this.source = importer;
		}		

		void addUnit(List<String> qualifiedName, CompiledUnit unit) {
			qName2CU.put(qualifiedName, unit);
		}
		
		public URI getImporter() {
			return source.getURI();
		}

		public List<QvtOperationalModuleEnv> getModules(List<String> importedUnitQualifiedName) {
			if(importedUnitQualifiedName == null) {
				return null;
			}
			
			CompiledUnit compiledUnit = qName2CU.get(importedUnitQualifiedName);
			if(compiledUnit != null) {
				return compiledUnit.getModuleEnvironments();				
			}
			
			return null;
		}
	}

	protected static class CSTParseResult {    	
    	public UnitCS unitCS;
    	public QvtOperationalFileEnv env;
    	public AbstractQVTParser parser;
    	
    	public CSTParseResult() {}
    	
    	List<ImportCS> getImports() {
    		if(unitCS != null) {    		
    			return QvtOperationalParserUtil.getImports(unitCS);
    		}
    		return Collections.emptyList();
    	}
    }
    
	protected static class CSTAnalysisResult {
		List<Module> modules;
		List<ModelType> modelTypes;
	}

	private DependencyPathElement findDependencyElement(UnitProxy source) {
		for (DependencyPathElement element : fDependencyWalkPath) {
			if(source.equals(element.importer)) {
				return element;
			}
		}
		
		return null;
	}
	
	private static class DependencyPathElement {
		final UnitProxy importer;
		ImportCS currentProcessedImport;
		QvtOperationalEnv importerEnv;;		

		public DependencyPathElement(UnitProxy importer) {
			this.importer = importer;
		}
	}
}