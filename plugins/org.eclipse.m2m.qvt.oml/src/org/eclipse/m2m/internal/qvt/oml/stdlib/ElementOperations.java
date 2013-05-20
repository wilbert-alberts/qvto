/*******************************************************************************
 * Copyright (c) 2008, 2013 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - bug 254962
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.stdlib;

import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelParameterExtent;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance;
import org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImportKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.TypeUtil;



public class ElementOperations extends AbstractContextualOperations {
	
	static final String DEEP_CLONE_NAME = "deepclone"; //$NON-NLS-1$	
	static final String CLONE_NAME = "clone"; //$NON-NLS-1$
	
	static final int FILTER_ALL = 0;
	static final int FILTER_OF_TYPE = 1;
	static final int FILTER_OF_KIND = 2;	
	
	public ElementOperations(AbstractQVTStdlib library) {
		super(library, library.getElementType());
	}
	
	@Override
	protected OperationProvider[] getOperations() {
		EClassifier elementSet = TypeUtil.resolveSetType(getStdlib().getEnvironment(), getStdlib().getElementType());
		EClassifier oclType = getStdlib().getOCLStdLib().getOclType();
		return new OwnedOperationProvider[] {
			new OwnedOperationProvider(UNSUPPORTED_OPER, "_localId", getOclStdlib().getString()), //$NON-NLS-1$
			new OwnedOperationProvider(UNSUPPORTED_OPER, "_globalId", getOclStdlib().getString()), //$NON-NLS-1$
			
			new OwnedOperationProvider(ALL_SUBOBJECTS, ALL_SUBOBJECTS_NAME, elementSet),
			new OwnedOperationProvider(ALL_SUBOBJECTS_OF_TYPE, ALL_SUBOBJECTS_OF_TYPE_NAME, 
					new String[] { "type" }, elementSet, oclType), //$NON-NLS-1$
					
			new OwnedOperationProvider(ALL_SUBOBJECTS_OF_KIND, ALL_SUBOBJECTS_OF_KIND_NAME, 
					new String[] { "type" }, elementSet, oclType), //$NON-NLS-1$
			new OwnedOperationProvider(CLONE, CLONE_NAME, getStdlib().getElementType()),
			new OwnedOperationProvider(CONTAINER, CONTAINER_NAME, getStdlib().getElementType()),				
			new OwnedOperationProvider(DEEP_CLONE, DEEP_CLONE_NAME, getStdlib().getElementType()),
			
			new OwnedOperationProvider(UNSUPPORTED_OPER, "markedAs", //$NON-NLS-1$
					new String[] { "value" }, getOclStdlib().getBoolean(), getOclStdlib().getString()), //$NON-NLS-1$			
			new OwnedOperationProvider(UNSUPPORTED_OPER, "markValue", getStdlib().getObject()), //$NON-NLS-1$			
					
			new OwnedOperationProvider(METACLASS, METACLASS_NAME, getOclStdlib().getString()),
			
			new OwnedOperationProvider(UNSUPPORTED_OPER, "stereotypedBy", //$NON-NLS-1$
					new String[] { "value" }, getOclStdlib().getBoolean(), getOclStdlib().getString()), //$NON-NLS-1$
			
			new OwnedOperationProvider(UNSUPPORTED_OPER, "stereotypedStrictBy", //$NON-NLS-1$
							new String[] { "value" }, getOclStdlib().getBoolean(), getOclStdlib().getString()), //$NON-NLS-1$			
			
			new OwnedOperationProvider(SUBOBJECTS, SUBOBJECTS_NAME, elementSet),
			new OwnedOperationProvider(SUBOBJECTS_OF_TYPE, SUBOBJECTS_OF_TYPE_NAME, 
					new String[] { "type" }, elementSet, oclType), //$NON-NLS-1$
			new OwnedOperationProvider(SUBOBJECTS_OF_KIND, SUBOBJECTS_OF_KIND_NAME, 
					new String[] { "type" }, elementSet, oclType), //$NON-NLS-1$
		};
	}

	private OCLStandardLibrary<EClassifier> getOclStdlib() {
		return getStdlib().getEnvironment().getOCLStandardLibrary();
	}

	private static final CallHandler DEEP_CLONE = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, final QvtOperationalEvaluationEnv evalEnv) {
			if(source instanceof EObject) {
				EObject eObject = (EObject) source;
				EcoreUtil.Copier copier = new IntermediatePropertyCopier(evalEnv);
			    
			    EObject result = copier.copy(eObject);
			    copier.copyReferences();

				ModelParameterExtent extent = evalEnv.getDefaultInstantiationExtent(eObject.eClass());
				if(extent != null) {
					//269245: Deep clone causes breaking containment hierarchy if used with resource bound extent
					//https://bugs.eclipse.org/bugs/show_bug.cgi?id=269245
					// add only the top level container object
					extent.addObject(result);
					
				}
				
				return result;
			}
	        return CallHandlerAdapter.getInvalidResult(evalEnv);
		}
	};
		
	private static final CallHandler CLONE = new CallHandler() {
		@SuppressWarnings("serial")
		public Object invoke(ModuleInstance module, Object source, Object[] args, final QvtOperationalEvaluationEnv evalEnv) {
			if(source instanceof EObject) {
				EObject eObject = (EObject) source;
			    EcoreUtil.Copier copier = new IntermediatePropertyCopier(evalEnv) {			    	
			    	@Override
					protected void copyContainment(org.eclipse.emf.ecore.EReference arg0, EObject arg1, EObject arg2) {
			    		// make a shallow copy
			    	}			    	
			    };
			    
			    EObject result = copier.copy(eObject);
			    copier.copyReferences();
			    
				ModelParameterExtent extent = evalEnv.getDefaultInstantiationExtent(eObject.eClass());
				if(extent != null) {
					TreeIterator<EObject> contentIter = EcoreUtil.getAllProperContents(result, false);				
					while (contentIter.hasNext()) {
						extent.addObject(contentIter.next());
					}
					extent.addObject(result);
				}				
				
				return result;
			}
	        return CallHandlerAdapter.getInvalidResult(evalEnv);
		}
	};
	
	private static class IntermediatePropertyCopier extends EcoreUtil.Copier {
		
		private QvtOperationalEvaluationEnv evalEnv;
		
		public IntermediatePropertyCopier(QvtOperationalEvaluationEnv evalEnv) {
			this.evalEnv = evalEnv;
		}
		
		@Override
    	public void copyReferences() {
    		
    		super.copyReferences();
    		
    		Module rootModule = evalEnv.getRoot().getAdapter(InternalEvaluationEnv.class).getCurrentModule().getModule();
    		
    		// bug 254962: clone intermediate properties
    		for (Map.Entry<EObject, EObject> entry  : entrySet()) {
    			EObject eObject = entry.getKey();
    	        EObject copyEObject = entry.getValue();
    	        										    	        
    	        cloneIntermediateProperties(eObject, copyEObject, rootModule);
    		}
    	}
		
		private void cloneIntermediateProperties(EObject source, EObject target, Module module) {
			
			for (EStructuralFeature feature : module.getEAllStructuralFeatures()) {
				
				if (feature instanceof ContextualProperty) {
					
					ContextualProperty property = (ContextualProperty) feature;
					
					if (property.getContext().isSuperTypeOf(source.eClass())) {
									
						Object value = evalEnv.navigateProperty(property, null, source);
						Object result = get(value);
						
						if (useOriginalReferences && result == null) {
							result = value;
						}
										
						evalEnv.callSetter(target, property, result, QvtOperationalUtil.isUndefined(result, evalEnv), true);
					
					}
					
				}	
				
			}
			
			for (ModuleImport moduleImport : module.getModuleImport()) {
				
				Module importedModule = moduleImport.getImportedModule();
				
				if (moduleImport.getKind() == ImportKind.EXTENSION || importedModule instanceof Library) {
					
					cloneIntermediateProperties(source, target, importedModule);
					
				}
				
			}
			
		}
		
	}

	private static final String CONTAINER_NAME = "container"; //$NON-NLS-1$  
	private static final CallHandler CONTAINER = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			if(source instanceof EObject) {
				EObject eObject = (EObject) source;
				return eObject.eContainer();
			}
	        return CallHandlerAdapter.getInvalidResult(evalEnv);
		}
	};

	private static final String METACLASS_NAME = "metaClassName"; //$NON-NLS-1$  
	private static final CallHandler METACLASS = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			if(source instanceof EObject) {
				EObject eObject = (EObject) source;
				return eObject.eClass().getName();
			}
	        return CallHandlerAdapter.getInvalidResult(evalEnv);
		}
	};

	private static final String SUBOBJECTS_NAME = "subobjects"; //$NON-NLS-1$  
	private static final CallHandler SUBOBJECTS = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			if(source instanceof EObject) {
				EObject eObject = (EObject) source;
				return getSubObjects(eObject, null, FILTER_ALL, evalEnv);
			}
	        return CallHandlerAdapter.getInvalidResult(evalEnv);
		}
	};
	
	private static final String SUBOBJECTS_OF_TYPE_NAME = "subobjectsOfType"; //$NON-NLS-1$  
	private static final CallHandler SUBOBJECTS_OF_TYPE = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			if(source instanceof EObject) {
				EObject eObject = (EObject) source;
				return getSubObjects(eObject, getTypeFilterArg(args), FILTER_OF_TYPE, evalEnv);
			}
	        return CallHandlerAdapter.getInvalidResult(evalEnv);
		}
	};	

	private static final String SUBOBJECTS_OF_KIND_NAME = "subobjectsOfKind"; //$NON-NLS-1$  
	private static final CallHandler SUBOBJECTS_OF_KIND = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			if(source instanceof EObject) {
				EObject eObject = (EObject) source;
				return getSubObjects(eObject, getTypeFilterArg(args), FILTER_OF_KIND, evalEnv);
			}
	        return CallHandlerAdapter.getInvalidResult(evalEnv);
		}
	};	

	
	private static final String ALL_SUBOBJECTS_NAME = "allSubobjects"; //$NON-NLS-1$  
	private static final CallHandler ALL_SUBOBJECTS = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			if(source instanceof EObject) {
				EObject eObject = (EObject) source;				
				return getAllSubObjects(eObject, null, FILTER_ALL, evalEnv);
			}
	        return CallHandlerAdapter.getInvalidResult(evalEnv);
		}
	};
	
	private static final String ALL_SUBOBJECTS_OF_TYPE_NAME = "allSubobjectsOfType"; //$NON-NLS-1$  
	private static final CallHandler ALL_SUBOBJECTS_OF_TYPE = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			if(source instanceof EObject) {
				EObject eObject = (EObject) source;
				EClassifier type = getTypeFilterArg(args);				
				return getAllSubObjects(eObject, type, FILTER_OF_TYPE, evalEnv);
			}
	        return CallHandlerAdapter.getInvalidResult(evalEnv);
		}
	};	

	private static final String ALL_SUBOBJECTS_OF_KIND_NAME = "allSubobjectsOfKind"; //$NON-NLS-1$  
	private static final CallHandler ALL_SUBOBJECTS_OF_KIND = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			if(source instanceof EObject) {
				EObject eObject = (EObject) source;
				EClassifier type = getTypeFilterArg(args);				
				return getAllSubObjects(eObject, type, FILTER_OF_KIND, evalEnv);
			}
	        return CallHandlerAdapter.getInvalidResult(evalEnv);
		}
	};	
	
	
	private static EClassifier getTypeFilterArg(Object[] args) {
		if(args.length != 1) {
			throw new IllegalArgumentException();
		}
		Object typeObj = args[0];
		if(typeObj instanceof EClassifier == false) {
			throw new IllegalArgumentException();					
		}
		return (EClassifier) typeObj;
	}

	private static Object getAllSubObjects(EObject eObject, EClassifier type, final int filterFlag, QvtOperationalEvaluationEnv evalEnv) {
		HashSet<EObject> result = new HashSet<EObject>();				
		for(TreeIterator<EObject> iter = EcoreUtil.getAllContents(eObject, false); iter.hasNext(); ) {
			EObject subObject = iter.next();
			boolean accept = filterFlag == FILTER_ALL;
			if(FILTER_OF_KIND == filterFlag) {
				accept = evalEnv.isKindOf(subObject, type);
			} else if(FILTER_OF_TYPE == filterFlag) {
				accept = subObject.eClass() == type;					
			}
			if(accept) {
				result.add(subObject);
			}
		}
		return result;
	}
	
	private static Object getSubObjects(EObject eObject, EClassifier type, final int filterFlag, QvtOperationalEvaluationEnv evalEnv) {
		HashSet<EObject> result = new HashSet<EObject>();				
		for(EObject subObject : eObject.eContents()) {
			boolean accept = filterFlag == FILTER_ALL;
			if(FILTER_OF_KIND == filterFlag) {
				accept = evalEnv.isKindOf(subObject, type);
			} else if(FILTER_OF_TYPE == filterFlag) {
				accept = subObject.eClass() == type;					
			}
			if(accept) {
				result.add(subObject);
			}
		}
		return result;
	}	
}
