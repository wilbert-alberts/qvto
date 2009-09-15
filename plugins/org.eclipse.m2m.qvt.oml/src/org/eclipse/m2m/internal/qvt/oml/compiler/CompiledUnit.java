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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QVTOTypeResolver;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.ExecutableXMIHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory;
import org.eclipse.m2m.internal.qvt.oml.cst.UnitCS;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport;

public class CompiledUnit {
	
	private List<String> fQname;
	private URI fUri;	
	private List<QvtMessage> fAllProblems;
	private List<CompiledUnit> fImports;	
	private List<QvtOperationalModuleEnv> moduleEnvs;

	// FIXME - add compilationUnit CST element
	UnitCS fUnitCST;	
	
	CompiledUnit(List<String> qualifiedName, URI uri, List<? extends QvtOperationalModuleEnv> modules) {
		if(qualifiedName == null || modules == null || uri == null) {
			throw new IllegalArgumentException();
		}
		
		this.fUri = uri;
		this.fQname = qualifiedName;		
		this.moduleEnvs = new ArrayList<QvtOperationalModuleEnv>(modules);
		
		ArrayList<QvtMessage> problems = new ArrayList<QvtMessage>();
		this.fAllProblems = problems;
		
		for (QvtOperationalModuleEnv next : modules) {
			fAllProblems.addAll(next.getAllProblemMessages());
		}

		if(!problems.isEmpty()) {
			problems.trimToSize();			
		}
	}
	
	
	public static ResourceSetImpl createResourceSet() {
		return createResourceSet(null);
	}
	
	static ResourceSetImpl createResourceSet(EPackage.Registry registry) {		
		ResourceSetImpl rs = new ResourceSetImpl() {			
			@Override
			protected void demandLoad(Resource resource) throws java.io.IOException {
				super.demandLoad(resource);
				if(ExeXMISerializer.COMPILED_XMI_FILE_EXTENSION.equals(resource.getURI().fileExtension())) {
					ExecutableXMIHelper.fixResourceOnLoad(resource);
				}
			}
		};
		
		if(registry != null) {
			rs.setPackageRegistry(registry);
		}
		return rs;
	}

	public CompiledUnit(URI xmiURI, ResourceSet resourceSet) {
		this(resourceSet.getResource(xmiURI, true), new HashMap<URI, CompiledUnit>());
	}

	CompiledUnit(Resource unitXMIResource, Map<URI, CompiledUnit> unitMap) {
		this.fUri = unitXMIResource.getURI();
		this.moduleEnvs = new LinkedList<QvtOperationalModuleEnv>();
						
		this.fAllProblems = Collections.emptyList();
		this.fImports = new UniqueEList<CompiledUnit>();		

		unitMap.put(fUri, this);

		computeImports(unitXMIResource, unitMap);
		
		// Note: Environment initialization should be optional as it make sense to be used
		// only in case this unit is to be a compilation dependency to parsed CST Unit  
		for(EObject rootElement : new ArrayList<EObject>(unitXMIResource.getContents())) {
			if(rootElement instanceof Module) {
				Module nextModule = (Module) rootElement;
				QvtOperationalModuleEnv nextModuleEnv = QvtOperationalEnvFactory.INSTANCE.createModuleEnvironment(nextModule);
				QVTOTypeResolver typeResolver = nextModuleEnv.getTypeResolver();
 
				// FIXME - 
				// 1) workaround to make Environment available with the module for
				// non-transformation execution context
				// 2) move this initialization code to QVTEnvironment related classes
				ASTBindingHelper.createCST2ASTBinding(CSTFactory.eINSTANCE.createLibraryCS(), nextModule, nextModuleEnv);				
				for (EOperation nextOper : nextModule.getEOperations()) {
					if(nextOper instanceof ImperativeOperation) {
						ImperativeOperation imperativeOper = (ImperativeOperation) nextOper;
						EClassifier ctxType = QvtOperationalParserUtil.getContextualType(imperativeOper);
						if(ctxType != null) {
							typeResolver.resolveAdditionalOperation(ctxType, imperativeOper);
						}
					}
				}
				
//				for (EClassifier nextClassifier : nextModule.getEClassifiers()) {
//					if(nextClassifier instanceof Typedef) {
//						Typedef typedef = (Typedef) nextClassifier;
//						if(typedef.getBase() != null) {
//							for (EOperation next : typedef.getEOperations()) {
//								typeResolver.resolveAdditionalOperation(typedef.getBase(), next);
//							}
//						}
//					}
//				}

				this.moduleEnvs.add(nextModuleEnv);
			}
		}

	}

	private void computeImports(Resource unitResource, Map<URI, CompiledUnit> unitMap) {
		for (EObject next : unitResource.getContents()) {
			if(next instanceof Module) {
				computeImports((Module) next, unitMap);
			}
		}
	}
	
	private void computeImports(Module module, Map<URI, CompiledUnit> unitMap) {
		EList<ModuleImport> imports = module.getModuleImport();		
		for (ModuleImport nextImport : imports) {
			Module importedModule = nextImport.getImportedModule();
			
			if(importedModule != null && importedModule.eResource() != null) {
				Resource importedResource = importedModule.eResource();
				URI importedResourceURI = importedResource.getURI();
				// Note: skip QVT Standard Library as it's imported implicitly
				if(!importedResourceURI.equals(QvtOperationalStdLibrary.NS_URI)) {
					CompiledUnit importedUnit = unitMap.get(importedResourceURI);
					if(importedUnit == null) {
						importedUnit = new CompiledUnit(importedResource, unitMap);
						unitMap.put(importedResourceURI, importedUnit);
					} 

					fImports.add(new CompiledUnit(importedResource, unitMap));					
				}
			} else {
				throw new IllegalArgumentException("imported module must be in a resource"); //$NON-NLS-1$ 
			}
		}
	}
	
	void addProblem(QvtMessage problem) {
		if(problem == null) {
			throw new IllegalArgumentException();
		}
		
		fAllProblems.add(problem);
	}
				
	void setImports(List<CompiledUnit> imports) {
		this.fImports = imports; 
	}
	
	List<String> getQualifiedName() {
		return fQname;
	}	
	
	public String getName() {
		return fQname.get(fQname.size() - 1);
	}
	
	public List<QvtOperationalModuleEnv> getModuleEnvironments() {
		return moduleEnvs;
	}
	
	public List<QvtMessage> getErrors() {
		List<QvtMessage> errors = new ArrayList<QvtMessage>();			
		for (QvtMessage nextMessage : fAllProblems) {
			if(nextMessage.getSeverity() == QvtMessage.SEVERITY_ERROR) {
				errors.add(nextMessage);
			}
		}			
		return errors;
	}
	
	public List<QvtMessage> getWarnings() {
		List<QvtMessage> warnings = new ArrayList<QvtMessage>();			
		for (QvtMessage nextMessage : fAllProblems) {
			if(nextMessage.getSeverity() == QvtMessage.SEVERITY_WARNING) {
				warnings.add(nextMessage);
			}
		}			
		return warnings;
	}
	
	
	public List<CompiledUnit> getCompiledImports() { 
		return fImports != null ? fImports : Collections.<CompiledUnit>emptyList();
	}
	
	public List<Module> getModules() {
		List<Module> modules = new ArrayList<Module>(moduleEnvs.size());
		for (QvtOperationalModuleEnv next : moduleEnvs) {
			if(next.getModuleContextType() != null) {
				modules.add(next.getModuleContextType());
			}
		}
		
		return modules;
	}
	
	public URI getURI() {
		return fUri;
	}
		
	public UnitCS getUnitCST() {
		return fUnitCST;
	}
		
	public List<QvtMessage> getProblems() {
		return fAllProblems;
	}		

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CompiledUnit) {
			CompiledUnit another = (CompiledUnit) obj;
			return fUri.equals(another.fUri);
		}
		
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {	
		return fUri.hashCode();
	}
	
	@Override
	public String toString() {		
		return fUri.toString();
	}
}