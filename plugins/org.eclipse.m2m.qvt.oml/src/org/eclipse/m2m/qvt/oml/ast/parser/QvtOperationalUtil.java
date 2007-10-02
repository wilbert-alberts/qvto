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
package org.eclipse.m2m.qvt.oml.ast.parser;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnvFactory;
import org.eclipse.m2m.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.qvt.oml.internal.cst.adapters.ModelTypeMetamodelsAdapter;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.internal.cst.PathNameCS;
import org.eclipse.ocl.internal.cst.TypeCS;
import org.eclipse.ocl.types.PrimitiveType;

public class QvtOperationalUtil {

	private QvtOperationalUtil() {
	}

	public static String getStringRepresentation(PathNameCS pathName, String pathSeparator) {
		return QvtOperationalParserUtil.getStringRepresentation(pathName, pathSeparator);
	}

	public static String getStringRepresentation(TypeCS typeCS) {
		return QvtOperationalParserUtil.getStringRepresentation(typeCS);
	}
	
    public static boolean isAssignableToFrom(EClassifier to, EClassifier from) {
        QvtOperationalEnv env = new QvtOperationalEnvFactory().createEnvironment(null, null);
        return isAssignableToFrom(env, to, from);
    }
    
    public static boolean isAssignableToFrom(QvtOperationalEnv env, EClassifier to, EClassifier from) {
        return QvtOperationalParserUtil.isAssignableToFrom(env, to, from);
    }
    
	public static boolean isUndefined(Object value) {
		return value == null || value == getOclInvalid();
	}

	public static boolean isCreateFromStringSupported(EClassifier type) {
		return isPrimitiveType(type) || type instanceof EDataType;
	}

	public static Object getOclInvalid() {
		return ourOclInvalid;
	}
	
	public static EClassifier getOclVoid() {
		return ourOclVoid;
	}
	
	public static boolean isPrimitiveType(Object type) {
		return type instanceof PrimitiveType;
	}

	public static boolean isInstantiable(EClass cls) {
		return !cls.isAbstract() && !cls.isInterface();
	}

    public static boolean isMappingOperation(EOperation operation) {
    	if(operation instanceof MappingOperation) { 
    		return true;
    	}
        EAnnotation ann = operation != null ? operation.getEAnnotation(Environment.OCL_NAMESPACE_URI) : null;
        if (ann != null && !ann.getContents().isEmpty()) {
            for (EObject o : ann.getContents()) {
                if (false == o instanceof Constraint) {
                    continue;
                }
                if (QvtOperationalEnv.MAPPING_OPERATION_STEREOTYPE.equals(((Constraint) o).getStereotype())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isImperativeOperation(EOperation operation) {
    	if(operation instanceof ImperativeOperation) {
    		return true;
    	}    	
        EAnnotation ann = operation.getEAnnotation(Environment.OCL_NAMESPACE_URI);
        if ((ann != null) && !ann.getContents().isEmpty()) {
            for (EObject o : ann.getContents()) {
                if (false == o instanceof Constraint) {
                    continue;
                }
                if (QvtOperationalEnv.MAPPING_OPERATION_STEREOTYPE.equals(((Constraint) o).getStereotype())
                        || QvtOperationalEnv.IMPERATIVE_OPERATION_STEREOTYPE.equals(((Constraint) o).getStereotype())) {
                    return true;
                }
            }
        }
        return false;
    }

	public static boolean isModelParamEqual(ModelParameter param, ModelParameter importedParam, boolean isStrictCompare) {
		if (param.getKind() == DirectionKind.IN) {
			if (importedParam.getKind() != DirectionKind.IN) {
				return false;
			}
		}
		if (!isStrictCompare) {
			return true;
		}
		return ModelTypeMetamodelsAdapter.getMetamodels(param.getEType()).equals(
				ModelTypeMetamodelsAdapter.getMetamodels(importedParam.getEType()));
	}

    
	private static final Object ourOclInvalid = new QvtOperationalEnvFactory().createEnvironment(null, null).getOCLStandardLibrary().getOclInvalid();
	private static final EClassifier ourOclVoid = new QvtOperationalEnvFactory().createEnvironment(null, null).getOCLStandardLibrary().getOclVoid();

}
