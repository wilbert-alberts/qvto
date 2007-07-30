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
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnvFactory;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.QvtOperationalParserUtil;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.internal.cst.PathNameCS;
import org.eclipse.ocl.internal.cst.TypeCS;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.types.VoidType;

public class QvtOperationalUtil {

	public static final String TYPE_NAME_SEPARATOR = "::"; //$NON-NLS-1$
	
	private QvtOperationalUtil() {
	}

	public static String getTypeFullName(EClassifier type) {
		if (type == null) {
			return UNKNOWN_TYPE_NAME;
		}
		String fullName = getTypeName(type);
		EObject parent = type.eContainer();
		while (parent != null) {
			if (parent instanceof ENamedElement) {
				fullName = ((ENamedElement) parent).getName() + TYPE_NAME_SEPARATOR + fullName;
			}
			parent = parent.eContainer();
		}
		return fullName;
	}
	
	// Workaround for CollectionType.getName
    public static final String getTypeName(EClassifier type) {
        if (type instanceof CollectionType) {
            return getCollectionTypeName((CollectionType) type);
        }
        return type.getName();
    }
    
    // Workaround for CollectionType.getName
    public static final String getCollectionTypeName(CollectionType collectionType) {
        StringBuffer sbName = new StringBuffer();

        switch (collectionType.getKind()) {
        case SET_LITERAL:
            sbName.append(SetType.SINGLETON_NAME);
            break;
        case ORDERED_SET_LITERAL:
            sbName.append(OrderedSetType.SINGLETON_NAME);
            break;
        case BAG_LITERAL:
            sbName.append(BagType.SINGLETON_NAME);
            break;
        case SEQUENCE_LITERAL:
            sbName.append(SequenceType.SINGLETON_NAME);
            break;
        default:
            sbName.append(org.eclipse.ocl.types.CollectionType.SINGLETON_NAME);
        break;
        }

        sbName.append('(');

        EClassifier elementType = collectionType.getElementType();
        String elementTypeName;
        if (elementType == null) { // Here is the workaround
            elementTypeName = UNKNOWN_TYPE_NAME;
        } else if (elementType instanceof VoidType) {
                elementTypeName = "T"; //$NON-NLS-1$
        } else {
            elementTypeName = getTypeName(elementType);
        }

        sbName.append(elementTypeName);
        sbName.append(')');

        return sbName.toString();
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
        EAnnotation ann = operation.getEAnnotation(Environment.OCL_NAMESPACE_URI);
        if ((ann != null) && !ann.getContents().isEmpty()) {
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
	
	private static final String UNKNOWN_TYPE_NAME = "unknown"; //$NON-NLS-1$
	private static final Object ourOclInvalid = new QvtOperationalEnvFactory().createEnvironment(null, null).getOCLStandardLibrary().getOclInvalid();
	private static final EClassifier ourOclVoid = new QvtOperationalEnvFactory().createEnvironment(null, null).getOCLStandardLibrary().getOclVoid();

}
