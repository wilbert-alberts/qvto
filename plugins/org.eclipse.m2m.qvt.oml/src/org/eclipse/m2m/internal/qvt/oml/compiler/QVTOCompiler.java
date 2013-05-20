/*******************************************************************************
 * Copyright (c) 2009, 2013 Borland Software Corporation and others.
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
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.NLS;
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QVTParsingOptions;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalFileEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.ExternalUnitElementsProvider;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParser;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalValidationVisitor;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalVisitorCS;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.WorkspaceMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerUtils.Eclipse;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitContents.ModelContents;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.UnitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.AbstractQVTParser;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.EmfStandaloneMetamodelProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.lpg.AbstractLexer;


public class QVTOCompiler {

	private static final String NAMESPACE_SEP = String.valueOf(UnitProxy.NAMESPACE_SEP);
	
    private final Map<URI, CompiledUnit> fSource2Compiled = new HashMap<URI, CompiledUnit>();
    private final Stack<DependencyPathElement> fDependencyWalkPath = new Stack<DependencyPathElement>();    
    private final IMetamodelRegistryProvider fMetamodelRegistryProvider;
    private final UnitResolver fUnitResolver;
    private final ResourceSet resourceSet;
    private ResourceSetImpl fExeXMIResourceSet;
    private boolean fUseCompiledXMI = false;

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
    	return new QVTOCompiler(importResolver, createMetamodelRegistryProvider(metamodelResourceSet)) {
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
    
	public static QVTOCompiler createCompiler(UnitResolver unitResolver, EPackage.Registry registry) {		
		ResourceSetImpl rs = new ResourceSetImpl();
		if(registry != null) {
			rs.setPackageRegistry(registry);
			
			Map<URI, Resource> uriResourceMap = new HashMap<URI, Resource>();			
			for(Object nextEntry : registry.values()) {				
				if(nextEntry instanceof EPackage) {
					EPackage ePackage = (EPackage) nextEntry;
					Resource resource = ePackage.eResource();
					if(resource != null) {
						uriResourceMap.put(resource.getURI(), resource);
					}
				}				
			}
			
			if(!uriResourceMap.isEmpty()) {
				rs.setURIResourceMap(uriResourceMap);
			}
		}
		
		final EPackageRegistryImpl packageRegistryImpl = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
		packageRegistryImpl.putAll(registry);
		
		IMetamodelRegistryProvider metamodelRegistryProvider = createMetamodelRegistryProvider(packageRegistryImpl, rs);

		return new QVTOCompiler(unitResolver, metamodelRegistryProvider);
	}
	
	public static CompiledUnit[] compile(Set<URI> unitURIs, EPackage.Registry registry) throws MdaException {
		EList<UnitProxy> unitProxies = new BasicEList<UnitProxy>();
		for (URI importURI : unitURIs) {
			UnitProxy unit = UnitResolverFactory.Registry.INSTANCE.getUnit(importURI);
			if (unit != null) {
				unitProxies.add(unit);
			}
		}

		if(!unitProxies.isEmpty()) {
			// TODO - take resolver that resolved any unit proxy, we need to refactor the resolver out of 
			// the compiler constructor; the creator of unit proxies should decide which one to use and
			// resolvers of importing units should be used to resolver imports in its scope
			UnitResolver resolver = unitProxies.get(0).getResolver();
			QVTOCompiler compiler = createCompiler(resolver, registry);
			
			QvtCompilerOptions options = new QvtCompilerOptions();
			options.setGenerateCompletionData(true);
			return compiler.compile(unitProxies.toArray(new UnitProxy[unitProxies.size()]), options, null);
		}
		
		return new CompiledUnit[0];
	}
        
    public QVTOCompiler(UnitResolver unitResolver, IMetamodelRegistryProvider metamodelRegistryProvider) {
	    fUnitResolver = unitResolver;	    
        fMetamodelRegistryProvider = metamodelRegistryProvider;
        
        this.resourceSet = (metamodelRegistryProvider instanceof WorkspaceMetamodelRegistryProvider) ?
        		((WorkspaceMetamodelRegistryProvider) metamodelRegistryProvider).getResolutionResourceSet() : 
        			new ResourceSetImpl();
        
		fExeXMIResourceSet = CompiledUnit.createResourceSet();
		if(getResourceSet() instanceof ResourceSetImpl) {
			Map<URI, Resource> uriResourceMap = ((ResourceSetImpl) getResourceSet()).getURIResourceMap();
			if(uriResourceMap != null) {
				fExeXMIResourceSet.setURIResourceMap(new HashMap<URI, Resource>(uriResourceMap));	
			}
		}			
    }

	public void setUseCompiledXMI(boolean flag) {
		fUseCompiledXMI = flag;
	}
				
	public CompiledUnit[] compile(UnitProxy[] sources, QvtCompilerOptions options, Monitor monitor) throws MdaException {
		if(options == null) {
			options = getDefaultOptions();			
		}
		
		if(monitor == null) {
			monitor = CompilerUtils.createNullMonitor();
		}
		
		CompiledUnit[] result = new CompiledUnit[sources.length];

		try {
			monitor.beginTask("", sources.length); //$NON-NLS-1$
			
			int i = 0;
			for (UnitProxy nextSource : sources) {
	            if(monitor.isCanceled()) {
	            	CompilerUtils.throwOperationCanceled();
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
	public CompiledUnit compile(String qualifiedName, QvtCompilerOptions options, Monitor monitor) throws MdaException {
		UnitProxy unit = getImportResolver().resolveUnit(qualifiedName);
		if(unit == null) {
			throw new MdaException("Unresolved unit: " + qualifiedName); //$NON-NLS-1$
		}
		
		return compile(unit, options, monitor);
	}
	
	public CompiledUnit compile(UnitProxy source, QvtCompilerOptions options, Monitor monitor) throws MdaException {
		if(monitor == null) {
			monitor = CompilerUtils.createNullMonitor();
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
	    	
    		Registry ePackageRegistry = getEPackageRegistry(source.getURI());
			QvtOperationalFileEnv env = new QvtOperationalEnvFactory(ePackageRegistry).createEnvironment(source.getURI());
    		
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
    	this.fExeXMIResourceSet.getResources().clear();
    }
	
    /**
     * The main compilation method - the common entry point to the compilation 
     */
	private CompiledUnit compileSingleFile(UnitProxy source, QvtCompilerOptions options, Monitor monitor) throws MdaException {
        		
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
		
    private CompiledUnit doCompile(final UnitProxy source, QvtCompilerOptions options, Monitor monitor) throws ParserException, IOException {
    	if(fSource2Compiled.containsKey(source.getURI())) {
    		return fSource2Compiled.get(source.getURI());
    	}

    	monitor = CompilerUtils.createMonitor(monitor, 1); //new SubProgressMonitor(monitor, 1);
    	monitor.beginTask(source.getURI().toString(), 3);
    	
		List<CompiledUnit> compiledImports = null;
		DependencyPathElement dependencyElement = new DependencyPathElement(source);
    	try {
        	fDependencyWalkPath.push(dependencyElement);

        	if(fUseCompiledXMI) {
	        	CompiledUnit binXMIUnit = getCompiledExeXMIUnit(source);
	        	if(binXMIUnit != null) {
					fSource2Compiled.put(source.getURI(), binXMIUnit);
					return binXMIUnit;
	        	}
        	}
        	
        	if(source.getContentType() != UnitProxy.TYPE_CST_STREAM) {
        		CompiledUnit loadBlackboxUnit = loadBlackboxUnit(source);        		
        		fSource2Compiled.put(source.getURI(), loadBlackboxUnit);

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

            	List<String> importedUnitQName = QvtOperationalParserUtil.getSequenceOfNames(nextImportCS.getPathNameCS().getSimpleNames());
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
			
			// load black-box implementation bindings
	    	//AST2BlackboxImplBinder.ensureImplementationBinding(source, analysisResult.modules);
							    	
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
	    	fSource2Compiled.put(source.getURI(), result);

	    	monitor.worked(1);	    	
	    	return result;
	    	
    	} finally {
    		fDependencyWalkPath.pop();
    		
	    	monitor.done();    		
    	}
    }

	private CompiledUnit getCompiledExeXMIUnit(final UnitProxy source) {		
		URI xmiURI = ExeXMISerializer.toXMIUnitURI(source.getURI());
		if(URIConverter.INSTANCE.exists(xmiURI, null)) {
			// check if the bin XMI is up-to-date with the QVT source file
	        Long srcTStamp = (Long)URIConverter.INSTANCE.getAttributes(source.getURI(), null).get(URIConverter.ATTRIBUTE_TIME_STAMP);
			Long binTStamp = (Long)URIConverter.INSTANCE.getAttributes(xmiURI, null).get(URIConverter.ATTRIBUTE_TIME_STAMP);
			if(binTStamp == null || (srcTStamp != null && binTStamp.equals(srcTStamp))) {
				return new CompiledUnit(fExeXMIResourceSet.getResource(xmiURI, true), fSource2Compiled);        		
			}
		}
		
		return null;
	}
    

	private CompiledUnit createCompiledUnit(UnitProxy unit, QvtOperationalFileEnv env) {
		// adjust QVT environment resource to point to executable XMI
		Resource resource = env.getTypeResolver().getResource();
		resource.setURI(ExeXMISerializer.toXMIUnitURI(unit.getURI()));
		fExeXMIResourceSet.getResources().add(resource);

		List<String> qualifiedName = getQualifiedNameSegments(unit);
		return new CompiledUnit(qualifiedName, unit.getURI(), Collections.singletonList(env));
	}

	private static List<String> getQualifiedNameSegments(UnitProxy unit) {
		List<String> qualifiedName = null;		
		String namespace = unit.getNamespace();		
		if(namespace != null) {
			String[] segments = ResolverUtils.getNameSegments(namespace);
			qualifiedName = new ArrayList<String>(segments.length + 1);
			qualifiedName.addAll(Arrays.asList(segments));
			
			qualifiedName.add(unit.getName());
		} else {
			qualifiedName = Collections.singletonList(unit.getName()); 
		}
		return qualifiedName;
	}
		
	protected final EPackage.Registry getEPackageRegistry(URI context) {
		return CompilerUtils.getEPackageRegistry(context, fMetamodelRegistryProvider);
	}
	
	public ResourceSet getResourceSet() {
		return resourceSet;
	}
	
	public void cleanup() {
		EmfUtil.cleanupResourceSet(getResourceSet());
	}
	
	private void addSourceLineNumberInfo(AbstractQVTParser parser, CSTAnalysisResult analysisResult, UnitProxy source) {
		AbstractLexer lexer = parser.getLexer();
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
			return QvtOperationalParserUtil.getStringRepresentation(importCS.getPathNameCS(), NAMESPACE_SEP);
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
		UnitResolver resolver = importingUnit.getResolver();
		UnitProxy unit = resolver.resolveUnit(unitQualifiedName);
		
		if(unit == null) {
			String namespace = importingUnit.getNamespace();
			if(namespace != null && unitQualifiedName.contains(NAMESPACE_SEP) == false) {
				unit = resolver.resolveUnit(namespace + NAMESPACE_SEP + unitQualifiedName);
			}
		}
		
		// Handle legacy imports from deployed transformations
    	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=240192
    	if(unit == null && resolver instanceof LegacyResolverSupport) {
    		LegacyResolverSupport legacyResolver = (LegacyResolverSupport)resolver;
			unit = legacyResolver.resolveUnit(importingUnit, unitQualifiedName);
    	}
    	
    	return unit;
	}
    
    private List<String> getImportQName(ImportCS importCS) {
		PathNameCS pathNameCS = importCS.getPathNameCS();
		if(pathNameCS != null && !pathNameCS.getSimpleNames().isEmpty()) {
			return QvtOperationalParserUtil.getSequenceOfNames(pathNameCS.getSimpleNames());
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
	
	private static IMetamodelRegistryProvider createMetamodelRegistryProvider(ResourceSet metamodelResourceSet) {
		if(EMFPlugin.IS_ECLIPSE_RUNNING && EMFPlugin.IS_RESOURCES_BUNDLE_AVAILABLE) {
			return Eclipse.createMetamodelRegistryProvider(metamodelResourceSet);
		}
		
		return new IMetamodelRegistryProvider() {
			public MetamodelRegistry getRegistry(IRepositoryContext context) {
				return new MetamodelRegistry(new EmfStandaloneMetamodelProvider());
			}
		};
	}

	private static IMetamodelRegistryProvider createMetamodelRegistryProvider(final EPackage.Registry packageRegistry, ResourceSet metamodelResourceSet) {
		if(EMFPlugin.IS_ECLIPSE_RUNNING && EMFPlugin.IS_RESOURCES_BUNDLE_AVAILABLE) {
			return Eclipse.createMetamodelRegistryProvider(packageRegistry, metamodelResourceSet);
		}
		
		return new IMetamodelRegistryProvider() {
			public MetamodelRegistry getRegistry(IRepositoryContext context) {
				return new MetamodelRegistry(new EmfStandaloneMetamodelProvider(packageRegistry));
			}
		};
	}
}