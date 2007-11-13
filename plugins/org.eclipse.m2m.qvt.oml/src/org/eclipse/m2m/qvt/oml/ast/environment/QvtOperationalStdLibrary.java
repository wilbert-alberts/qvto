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
package org.eclipse.m2m.qvt.oml.ast.environment;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalTypesUtil;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.qvt.oml.library.IContext;
import org.eclipse.m2m.qvt.oml.ocl.transformations.LibraryOperation;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedElement;


public class QvtOperationalStdLibrary {
	
	public static final String OUT_PRINT_WRITER = "@out_print_writer"; //$NON-NLS-1$
	public static final String QVT_STDLIB_DUMP_OPERATION = "dump"; //$NON-NLS-1$
	public static final String QVT_STDLIB_TOSTRING_OPERATION = "toString"; //$NON-NLS-1$

	public static final String QVT_STDLIB_OBJECTS_OPERATION = "objects"; //$NON-NLS-1$
	public static final String QVT_STDLIB_ROOTOBJECTS_OPERATION = "rootObjects"; //$NON-NLS-1$
	public static final String QVT_STDLIB_OBJECTSOFTYPE_OPERATION = "objectsOfType"; //$NON-NLS-1$
	
	public static final QvtOperationalStdLibrary INSTANCE = new QvtOperationalStdLibrary(); 
	
	private QvtOperationalStdLibrary() {
		myDefinedOperations = new HashMap<EOperation, LibraryOperation>();
	}
	
	public EClassifier getModelType() {
		return ExpressionsPackage.Literals.MODEL_TYPE;
	}
	
	public void defineStandartOperations(QvtOperationalEnv env) {
		OCLStandardLibrary<EClassifier> oclStdLib = env.getOCLStandardLibrary();
		
		// Spec 8.4.3 : shorthand for 'concat' operation
		defineOperation(env, oclStdLib.getString(), oclStdLib.getString(),
				PredefinedType.PLUS_NAME, oclStdLib.getString());

//		defineOperation(env, oclStdLib.getOclAny(), oclStdLib.getSet(),
//				PredefinedType.ALL_INSTANCES_NAME, oclStdLib.getOclType());

		defineOperation(env, oclStdLib.getOclVoid(), oclStdLib.getOclVoid(),
				QVT_STDLIB_DUMP_OPERATION, oclStdLib.getOclAny());
		defineOperation(env, oclStdLib.getOclAny(), oclStdLib.getOclVoid(),
				QVT_STDLIB_DUMP_OPERATION);

		EClassifier genericCollectionType = TypeUtil.resolveType(env,
				(EClassifier) env.getOCLFactory().createCollectionType(oclStdLib.getT2()));
		defineOperation(env, oclStdLib.getOclVoid(), oclStdLib.getOclVoid(),
				QVT_STDLIB_DUMP_OPERATION, genericCollectionType);

		defineOperation(env, oclStdLib.getInteger(), oclStdLib.getString(),
				QVT_STDLIB_TOSTRING_OPERATION);
		defineOperation(env, oclStdLib.getReal(), oclStdLib.getString(),
				QVT_STDLIB_TOSTRING_OPERATION);
		
		// Operations on models (spec 8.3.5)
		defineOperation(env, getModelType(), oclStdLib.getSet(),
				QVT_STDLIB_OBJECTS_OPERATION);
		defineOperation(env, getModelType(), oclStdLib.getSet(),
				QVT_STDLIB_ROOTOBJECTS_OPERATION);
//		defineOperation(env, getModelType(), oclStdLib.getSet(),
//				QVT_STDLIB_OBJECTSOFTYPE_OPERATION, oclStdLib.getOclType());
	}

	public EOperation defineOperation(QvtOperationalEnv env, LibraryOperation libraryOp, EClassifier contextType,
			EClassifier returnType, String opName, EClassifier... paramTypes) {
		EOperation operation = buildOperation(env, contextType, returnType, opName, paramTypes);
        synchronized (myDefinedOperations) {
            if ((operation != null) && (resolveOperation(operation) == null)) {
                myDefinedOperations.put(operation, libraryOp);
            }
        }
		return operation;
	}
	
	public EOperation defineOperation(QvtOperationalEnv env, EClassifier contextType, EClassifier returnType,
			String opName, EClassifier... paramTypes) {
		return defineOperation(env, null, contextType, returnType, opName, paramTypes);
	}
	
	public EOperation lookupOperation(QvtOperationalEnv env, EClassifier owner, String name,
			List<? extends TypedElement<EClassifier>> args) {
		
		// TODO waiting for resolution of OCL bug [#192907]
		if (PredefinedType.ALL_INSTANCES_NAME.equals(name) && args.size() == 1) {
			EClassifier resultType = args.get(0).getType();
			if (resultType instanceof TypeType) {
				resultType = ((TypeType<EClassifier, EOperation>) resultType).getReferredType();
			}

			return defineOperation(env, owner, createReturnType(env, resultType, true), name,
					args.get(0).getType());
		}
		if (QVT_STDLIB_OBJECTSOFTYPE_OPERATION.equals(name) && args.size() == 1) {
			EClassifier resultType = args.get(0).getType();
			if (resultType instanceof TypeType) {
				resultType = ((TypeType<EClassifier, EOperation>) resultType).getReferredType();
			}

			return defineOperation(env, owner, createReturnType(env, resultType, true), name,
					args.get(0).getType());
		}
		
		return null;
	}
	
	private EClassifier createReturnType(QvtOperationalEnv env, EClassifier resultType, boolean isMany) {
		if (isMany) {
			EReference realResult = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEReference();
			realResult.setEType(resultType);
			realResult.setUnique(true);
			realResult.setOrdered(false);
			realResult.setLowerBound(0);
			realResult.setUpperBound(-1);
			return env.getUMLReflection().getOCLType(realResult);
		}
		else {
			return env.getUMLReflection().getOCLType(resultType);
		}
	}
	
	public boolean overrides(EOperation operation, int opcode) {
		return resolveOperation(operation) != null;
	}

	public Object callOperation(QvtOperationalEvaluationEnv evalEnv, IContext context, EOperation operation,
			int opcode, Object source, Object[] args) {
		
		if (PredefinedType.PLUS_NAME.equals(operation.getName())
				&& source instanceof String
				&& args.length == 1
				) {
			return ((String) source).concat(String.valueOf(args[0]));
		}
		
		if (PredefinedType.ALL_INSTANCES_NAME.equals(operation.getName())
				&& source instanceof EObject
				&& args.length == 1
				) {
	        Set<Object> instances = new LinkedHashSet<Object>();	        
	        for (Iterator<EObject> it = ((EObject) source).eAllContents(); it.hasNext(); ) {
	            EObject contained = it.next();
	            
	            if (clsFilter.matches(contained, args[0])) {
	                instances.add(contained);
	            }
	        }	        
	        return instances;
		}
		
		if (QVT_STDLIB_DUMP_OPERATION.equals(operation.getName())) {
			PrintWriter printWriter = (PrintWriter) context.get(OUT_PRINT_WRITER);
			Object toPrint = source;
			if (args.length == 1) {
				toPrint = args[0];
			}
			
	        if (printWriter != null) {
	        	printWriter.println(toPrint);
	        } else {
	        	System.out.println(toPrint);
	        	System.out.flush();
	        }
	        return null;
		}
		
		if (QVT_STDLIB_TOSTRING_OPERATION.equals(operation.getName())
				&& (source instanceof Integer || source instanceof Double)
				&& args.length == 0
				) {
			return String.valueOf(source);
		}

		if (QVT_STDLIB_OBJECTS_OPERATION.equals(operation.getName())
				&& source instanceof ModelParameterExtent
				&& args.length == 0
				) {			
			Set<Object> instances = new LinkedHashSet<Object>();
	        List<Object> objects = ((ModelParameterExtent) source).getAllObjects();
			for (Object obj : objects) {
				instances.add(obj);
			}
			return instances;
		}

		if (QVT_STDLIB_ROOTOBJECTS_OPERATION.equals(operation.getName())
				&& source instanceof ModelParameterExtent
				&& args.length == 0
				) {			
			Set<Object> instances = new LinkedHashSet<Object>();
	        List<Object> objects = ((ModelParameterExtent) source).getAllObjects();
			for (Object obj : objects) {
				if (obj instanceof EObject &&
						false == ((EObject) obj).eContainer() instanceof EObject) {
					instances.add(obj);
				}
			}
			return instances;
		}

		if (QVT_STDLIB_OBJECTSOFTYPE_OPERATION.equals(operation.getName())
				&& source instanceof ModelParameterExtent
				&& args.length == 1
				) {			
	        Set<Object> instances = new LinkedHashSet<Object>();
	        List<Object> objects = ((ModelParameterExtent) source).getAllObjects();
			for (Object obj : objects) {
	            if (clsFilter.matches(obj, args[0])) {
	                instances.add(obj);
	            }
	        }	        
	        return instances;
		}
		
		LibraryOperation libOp = null;
        synchronized (myDefinedOperations) {
            EOperation resolvedOperation = resolveOperation(operation);
            if (resolvedOperation != null) {
               libOp = myDefinedOperations.get(resolvedOperation);
            }
        }
        if (libOp != null) {
            Class returnClass = operation.getEType() != null ? operation.getEType().getInstanceClass() : null;
            if (returnClass == null) {
                Logger.getLogger().log(Logger.SEVERE,
                "Return type class was not resolved"); //$NON-NLS-1$
                return null;
            }

            Object result = libOp.run(source, args, new Object[0], returnClass);
            if (result == null) {
                return QvtOperationalUtil.getOclInvalid();
            }
            return result;
        }

		return null;
	}
	
	
	private EOperation buildOperation(QvtOperationalEnv env, EClassifier contextType, EClassifier returnType,
			String opName, EClassifier... paramTypes) {
		List<Variable<EClassifier, EParameter>> stringArgList = new ArrayList<Variable<EClassifier, EParameter>>();
		for (EClassifier cls : paramTypes) {
			Variable<EClassifier, EParameter> stringVariable = ExpressionsFactory.eINSTANCE.createVariable();
			stringVariable.setName(cls.getName());
			stringVariable.setType(cls);
			stringArgList.add(stringVariable);
		}
		if (TypeUtil.findOperationMatching(env, contextType, opName, stringArgList) == null) {
			return env.defineOperation(contextType, opName, returnType, stringArgList,
					EcoreFactory.eINSTANCE.createConstraint());
		}
		return null;
	}

    private EOperation resolveOperation(EOperation operation) {
        synchronized (myDefinedOperations) {
            for (EOperation definedOperation : myDefinedOperations.keySet()) {
                if (areEqual(definedOperation, operation)) {
                    return definedOperation;
                }
            }
            return null;
        }
    }
    
    private static boolean areEqual(EOperation op1, EOperation op2) {
        if (!op1.getName().equals(op2.getName())) {
            return false;
        }
        List<EParameter> parameters1 = op1.getEParameters();
        List<EParameter> parameters2 = op2.getEParameters();
        if (parameters1.size() != parameters2.size()) {
            return false;
        }
        
        for (int i = 0; i < parameters1.size(); i++) {
            EClassifier type = parameters1.get(i).getEType();
            EClassifier otherType = parameters2.get(i).getEType();
            if (!areEqualTypes(type, otherType)) {
                return false;
            }
        }
        
        return areEqualTypes(op1.getEContainingClass(), op2.getEContainingClass());
    }
    
    private static boolean areEqualTypes(EClassifier cl1, EClassifier cl2) {
        String op1CtxtType = QvtOperationalTypesUtil.getTypeFullName(cl1);
        String op2CtxtType = QvtOperationalTypesUtil.getTypeFullName(cl2);
        return op1CtxtType.equals(op2CtxtType);
    }
    
	
    private static interface IFilter {
    	boolean matches(Object obj, Object type);
    }

    private static final IFilter clsFilter = new IFilter() {
		public boolean matches(Object obj, Object type) {
	    	if (type instanceof EClassifier) {
	    		EClassifier classifier = (EClassifier) type;
	    		return classifier.isInstance(obj);
	    	}
	    	else {
	    		return false;
	    	}
		}			
	};
	
	
	private final Map<EOperation, LibraryOperation> myDefinedOperations;
}