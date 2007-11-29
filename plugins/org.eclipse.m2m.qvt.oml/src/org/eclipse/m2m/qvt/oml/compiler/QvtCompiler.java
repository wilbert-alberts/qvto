/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.compiler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.qvt.oml.QvtMessage;
import org.eclipse.m2m.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnvFactory;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalFileEnv;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalParser;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.common.io.CFileUtil;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.WorkspaceMetamodelRegistryProvider;
import org.eclipse.m2m.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory;
import org.eclipse.m2m.qvt.oml.internal.cst.ImportCS;
import org.eclipse.m2m.qvt.oml.internal.cst.LibraryImportCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.m2m.qvt.oml.internal.cst.parser.QvtOpLexer;
import org.eclipse.ocl.internal.cst.PathNameCS;
import org.eclipse.osgi.util.NLS;


/**
 * @author pkobiakov
 */
public class QvtCompiler {

    public static final String PROBLEM_MARKER = "org.eclipse.m2m.qvt.oml.qvtProblem"; //$NON-NLS-1$

    private final Map<CFile, ParsedModuleCS> mySyntaxModules;
    private final Map<ParsedModuleCS, QvtCompilationResult> myCompilationResults;
    private Map<ParsedModuleCS, QvtOperationalEnv> myModule2EnvMap = new HashMap<ParsedModuleCS, QvtOperationalEnv>(5);
    private ImportCompiler importCompiler;
    
    private final QvtCompilerKernel myKernel;
    private final ResourceSet resourceSet;    

    public QvtCompiler(IImportResolver importResolver, IMetamodelRegistryProvider metamodelRegistryProvider) {
	    mySyntaxModules = new LinkedHashMap<CFile, ParsedModuleCS>();
	    myCompilationResults = new IdentityHashMap<ParsedModuleCS, QvtCompilationResult>();
        myKernel = new QvtCompilerKernel(importResolver, metamodelRegistryProvider);
        this.resourceSet = (metamodelRegistryProvider instanceof WorkspaceMetamodelRegistryProvider) ?
        		((WorkspaceMetamodelRegistryProvider) metamodelRegistryProvider).getResolutionResourceSet() : 
        			new ResourceSetImpl();
    }
	
	public QvtCompiler(IImportResolver importResolver) {
		this(importResolver, new WorkspaceMetamodelRegistryProvider());
    }	
	
	public QvtCompilerKernel getKernel() {
		return myKernel;
	}
	
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * Convenience method for compile(CFile[] sources, QvtCompilerOptions options, IProgressMonitor monitor)
	 */
    public QvtCompilationResult compile(CFile source, QvtCompilerOptions options, IProgressMonitor monitor) throws MdaException {
        return compile(new CFile[] {source}, options, monitor)[0];
    }

    /**
     * The main compilation method - the common entry point to the compilation 
     */
	public QvtCompilationResult[] compile(CFile[] sources, QvtCompilerOptions options, IProgressMonitor monitor) throws MdaException {
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }
             
        List<ParsedModuleCS> mmaList = new ArrayList<ParsedModuleCS>(sources.length);
        for (CFile source : sources) {
        	try {
				mmaList.add(parse(source));
			} 
			catch (IOException e) {
				Throwable cause = e.getCause() != null ? e.getCause() : e;
				throw new MdaException(cause.getMessage(), cause);
			}
        }
        
        Map<ParsedModuleCS, List<ParsedModuleCS>> removedImportCycles =
        	new IdentityHashMap<ParsedModuleCS, List<ParsedModuleCS>>();
        for (ParsedModuleCS parsed : mmaList) {
            checkRemoveCycles(parsed, removedImportCycles);
        }

        this.importCompiler = new ImportCompiler(removedImportCycles, options);
        List<QvtCompilationResult> resultList = new ArrayList<QvtCompilationResult>(); 
        for (ParsedModuleCS parsed : mmaList) {        	
        	QvtCompilationResult qvtCompilationResult = analyse(parsed, options);
            resultList.add(qvtCompilationResult);
        }
        
        afterCompileCleanup();
        
        return resultList.toArray(new QvtCompilationResult[resultList.size()]);
    }
	
	private void addSourceLineNumberInfo(ParsedModuleCS parsedModuleCS, Module moduleAST) {
		QvtOpLexer lexer = parsedModuleCS.getLexer();
		if (lexer != null) {
			String fileName = parsedModuleCS.getSource().getName();
			ASTBindingHelper.createModuleSourceBinding(moduleAST, fileName, new String(lexer.getInputChars()));
		}
	}
    
    private void checkRemoveCycles(ParsedModuleCS module, Map<ParsedModuleCS, List<ParsedModuleCS>> removedCycles) {
    	for (;;) {
        	Object[] cycle = SyntaxUtil.findFirstImportCycle(module);
        	if (cycle == null) {
        		break;
        	}
        	
        	ParsedModuleCS from = (ParsedModuleCS) cycle[0];
        	ParsedModuleCS to = (ParsedModuleCS) cycle[1];
    		
    		String fromIdentifier = from.getStringName(); 
    		String toIdentifier = to.getStringName(); 
    		from.addMessage(new QvtMessage(NLS.bind(CompilerMessages.cyclicImportError, toIdentifier,
    				fromIdentifier), from.getModuleCS().getHeaderCS().getPathNameCS()));
    		if (to != from) {
    			to.addMessage(new QvtMessage(NLS.bind(CompilerMessages.cyclicImportError, fromIdentifier,
    					toIdentifier), to.getModuleCS().getHeaderCS().getPathNameCS()));
    		}
    		
    		boolean removed = false;
    		for (Iterator<ParsedModuleCS> impIt = from.getParsedImports().iterator(); impIt.hasNext(); ) {
    			ParsedModuleCS imported = impIt.next();
    			if (imported == to) {
    				impIt.remove();
    				removed = true;
    				
    				if (!removedCycles.containsKey(from)) {
    					removedCycles.put(from, new ArrayList<ParsedModuleCS>(3));
    				}
    				removedCycles.get(from).add(imported);
    			}
    		}
    		assert removed : "False cycle: " + Arrays.asList(cycle); //$NON-NLS-1$    		
        }
    }

    private ParsedModuleCS parse(final CFile source) throws IOException {
    	ParsedModuleCS result = mySyntaxModules.get(source);        
    	if (result != null) {
        	return result;
        }

        QvtOperationalParser qvtParser = new QvtOperationalParser();
        MappingModuleCS moduleCS = parseInternal(source, qvtParser);

        if (moduleCS == null) {
        	moduleCS = CSTFactory.eINSTANCE.createMappingModuleCS();
        }

        result = new ParsedModuleCS(moduleCS, source, qvtParser.getLexer());
        result.addMessages(qvtParser.getErrorsList());
        result.addMessages(qvtParser.getWarningsList());
        
        mySyntaxModules.put(source, result);
    	parseImportedModules(result);

        return result;
    }

    protected MappingModuleCS parseInternal(CFile source, QvtOperationalParser qvtParser) throws IOException {
        Reader is = CFileUtil.getReader(source);
        try {
            return qvtParser.parse(is, source.getName());
        } finally {
            try { 
                is.close(); 
            } catch (IOException e) {
                Logger.getLogger().log(Logger.SEVERE, "Failed to close " + source, e); //$NON-NLS-1$
            }
        }
    }
    
    private void parseImportedModules(ParsedModuleCS module) {
    	Set<String> importedModules = new HashSet<String>();
    	for (ImportCS importCS : module.getModuleCS().getImports()) {
			if (importCS instanceof LibraryImportCS) {
				continue;
			}
			PathNameCS importQName = importCS.getPathNameCS();
            if (importQName == null) {
                module.addMessage(new QvtMessage(CompilerMessages.emptyImport));
                continue;
            }

            String importString = QvtOperationalParserUtil.getStringRepresentation(importQName, "."); //$NON-NLS-1$
        	if (importedModules.contains(importString)) {
        		module.addMessage(new QvtMessage(NLS.bind(CompilerMessages.moduleAlreadyImported, importString),
        				QvtMessage.SEVERITY_WARNING, importQName));
        	} else {
            	ParsedModuleCS impResult = getImportedModule(module.getSource(), importString);
                if (impResult == null) {
                	module.addMessage(new QvtMessage(NLS.bind(CompilerMessages.importedModuleNotFound,
                			importString), importQName)); //$NON-NLS-1$
                } else {                	
//                	if (importCS instanceof ModuleImportCS) {
//                		((ModuleImportCS) importCS).setParsedModule(impResult);
//                	}
                    module.addParsedImport(impResult, importQName);
                    importedModules.add(importString);
                }
        	}
        }    	
    }    

    public QvtCompilationResult analyse(final ParsedModuleCS mma, QvtCompilerOptions options) {
        QvtCompilationResult result = myCompilationResults.get(mma);
        if (result != null && result.getModule() != null) {
            return result;
        }

        List<CompiledModule> compiledImports = importCompiler.compileImports(mma);            	
        
    	QvtOperationalFileEnv moduleEnv = new QvtOperationalEnvFactory().createEnvironment(null, mma.getSource(), myKernel);
    	// setup import environments
    	for (ParsedModuleCS parsedImport : mma.getParsedImports()) {
    		if(myModule2EnvMap.containsKey(parsedImport)) {
    			QvtOperationalEnv importEnv = myModule2EnvMap.get(parsedImport);    			
    			moduleEnv.addSibling(importEnv);
    		}    		
    	}
    	
    	result = analyse(mma, options, moduleEnv);
    	result.getModule().getCompiledImports().addAll(compiledImports);

    	myCompilationResults.put(mma, result);    	

    	for (ParsedModuleCS parsedImport : mma.getParsedImports()) {
			QvtCompilationResult importCompilationResult = myCompilationResults.get(parsedImport);
        	if (importCompilationResult != null && importCompilationResult.getErrors().length > 0) {
	    		String importedModuleId = parsedImport.getStringName();
	    		if(importedModuleId == null) {	    			
	    			// this case is covered by syntax error report, 
	    			continue;
	    		}
        		
        		// find moduleImport syntax element
        		ImportCS targetImportCS = null;
        		for (ImportCS importCS : mma.getModuleCS().getImports()) {
        			if (importedModuleId.equals(QvtOperationalParserUtil.getStringRepresentation(importCS.getPathNameCS(), "."))) { //$NON-NLS-1$
        				targetImportCS = importCS;
        				break;
        			}
				}
        		if (targetImportCS != null) {
        			result.getModule().addMessage(new QvtMessage(NLS.bind(CompilerMessages.importHasCompilationError, importedModuleId), targetImportCS));
        		}
        	}    		
    	}
    	
    	return result;
    }
    
    private QvtCompilationResult analyse(final ParsedModuleCS mma, QvtCompilerOptions options,
    		QvtOperationalFileEnv env) {
        QvtCompilationResult result = null;
        
        Module module = null;
        List<QvtMessage> allMessages = new ArrayList<QvtMessage>();
        Collections.addAll(allMessages, mma.getMessages());
        
        if (mma.getStringName() != null) {
            PrintStream out = System.out;
            System.setOut(new PrintStream(new OutputStream() { @Override
			public void write(int b) {} }));
            try {
                QvtOperationalParser parser = new QvtOperationalParser();
                module = parser.analyze(mma, this, env, options);
                myModule2EnvMap.put(mma, parser.getEnvironment());                
                
                allMessages.addAll(parser.getWarningsList());
                allMessages.addAll(parser.getErrorsList());
                
            } finally {
                System.setOut(out);
            }
        }
        
        if (module == null) {
            module = myKernel.createModule(mma.getModuleCS(), options, env, mma.getSource());
            module.setName(""); //$NON-NLS-1$
        }
        
        if(options.isSourceLineNumbersEnabled()) {
        	addSourceLineNumberInfo(mma, module);        	
        }
        
        CompiledModule compModule = new CompiledModule(module, mma, mma.getSource(), allMessages);

        result = new QvtCompilationResult(compModule);
                
        return result;
    }    
    
    private ParsedModuleCS getImportedModule(final CFile source, final String qualifiedName) {
    	CFile importSource = myKernel.getImportResolver().resolveImport(qualifiedName);
//    	if (importSource == null) {
//    		importSource = new IOImportResolver(source).resolveImport(qualifiedName);
//    	}
    	if (importSource == null) {
    		return null;
    	}
        try {
            ParsedModuleCS parsed = parse(importSource);
            return parsed;
        } catch(IOException e) {
        	Logger.getLogger().log(Logger.SEVERE, "Failed to get module for " + source, e); //$NON-NLS-1$
            return null;
        }
    }
    
    public boolean isClass(EClassifier oclType) {
		return oclType instanceof EClass;
	}
		
    private class ImportCompiler {
    	private final Map<ParsedModuleCS, List<ParsedModuleCS>> myRemovedCycles;    	
    	private final QvtCompilerOptions myCompilerOptions;    	
    	
		ImportCompiler(Map<ParsedModuleCS, List<ParsedModuleCS>> removedCycles, QvtCompilerOptions options) {
			this.myRemovedCycles = removedCycles;
			this.myCompilerOptions = options;
		}
    	
		List<CompiledModule> compileImports(final ParsedModuleCS importingModule) {			
        	if(myCompilationResults.containsKey(importingModule)) {
        		return myCompilationResults.get(importingModule).getModule().getCompiledImports(); 
	    	}
        	
	    	Collection<ParsedModuleCS> importedModules = importingModule.getParsedImports();
	    	List<ParsedModuleCS> removedImports = myRemovedCycles.containsKey(importingModule) ?
	    			myRemovedCycles.get(importingModule) : Collections.<ParsedModuleCS>emptyList();    	
	    	if(myRemovedCycles.containsKey(importingModule)) {
	    		importedModules = new ArrayList<ParsedModuleCS>(importedModules.size() + removedImports.size());
	    		importedModules.addAll(importingModule.getParsedImports());
	    		importedModules.addAll(removedImports);
	    	}
	
			List<CompiledModule> directImportsCompiled = new LinkedList<CompiledModule>();        		    	
	    	for (ParsedModuleCS importedModule : importedModules) {	
	    		String importedModuleId = importedModule.getStringName();
	    		if(importedModuleId == null) {	    			
	    			// this case is covered by syntax error report, 
	    			continue;
	    		}
	    		CompiledModule analyzedModule = null;
	        	if (!importingModule.getStringName().equals(importedModuleId)) {
	        		if (removedImports.contains(importedModule)) {
	        			continue;
	        		}
	        		
	        		List<CompiledModule> nextCompiledImports = compileImports(importedModule);
	        		
	            	analyzedModule = analyse(importedModule, myCompilerOptions).getModule();
	            	analyzedModule.getCompiledImports().addAll(nextCompiledImports);
	            		            	
	            	directImportsCompiled.add(analyzedModule);
	            	
/*	            	if (analyzedModule.getErrors().length > 0 && importedModule != importingModule) { 
		        		// find moduleImport syntax element
		        		ImportCS targetImportCS = null;
		        		for (ImportCS importCS : importingModule.getModuleCS().getImports()) {
		        			if (importedModuleId.equals(QvtOperationalParserUtil.getStringRepresentation(importCS.getPathNameCS(), "."))) { //$NON-NLS-1$
		        				targetImportCS = importCS;
		        				break;
		        			}
						}
		        		if (targetImportCS != null) {
		        			analyzedModule.addMessage(new QvtMessage(NLS.bind(CompilerMessages.importHasCompilationError, importedModuleId), targetImportCS));

		        			//analyse(importingModule, myCompilerOptions).getModule().addMessage(
		        				//new QvtMessage(NLS.bind(CompilerMessages.importHasCompilationError, importedModuleId), targetImportCS));
		        		}
	            	} */
	            	
	        	}	        	
	    	}
	    	
	    	return directImportsCompiled; 
	    }
    }

    private void afterCompileCleanup() {
        this.importCompiler = null;
        
    	myModule2EnvMap.clear();
    	myCompilationResults.clear();
    	mySyntaxModules.clear();
    }
}