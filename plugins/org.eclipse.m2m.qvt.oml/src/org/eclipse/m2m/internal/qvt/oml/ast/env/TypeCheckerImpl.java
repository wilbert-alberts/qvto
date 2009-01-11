/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.ast.env;

import static org.eclipse.ocl.utilities.UMLReflection.SUBTYPE;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.expressions.DictionaryType;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOCLPackage;
import org.eclipse.m2m.internal.qvt.oml.expressions.ListType;
import org.eclipse.m2m.internal.qvt.oml.expressions.TemplateParameterType;
import org.eclipse.ocl.AbstractTypeChecker;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.ecore.TypeType;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.MessageType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.ObjectUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.osgi.util.NLS;

class TypeCheckerImpl extends AbstractTypeChecker<EClassifier, EOperation, EStructuralFeature, EParameter> {
	
	private final GenericsResolver fGenericResolver;
	private final OCLStandardLibrary<EClassifier> fOCLStdlib;
	
	TypeCheckerImpl(QVTOEnvironment env) {
		super(env);
		fGenericResolver = new GenericsResolver(env);
		fOCLStdlib = getEnvironment().getOCLStandardLibrary();
	}
		
	@Override
	public boolean isStandardLibraryFeature(EClassifier owner, Object feature) {
		if(feature instanceof EOperation && isQVTOperation((EOperation) feature)) {
			return false;
		}
		
		return super.isStandardLibraryFeature(owner, feature);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected CollectionType<EClassifier, EOperation> resolveCollectionType(CollectionKind kind,
			EClassifier elementType) {
		return (CollectionType<EClassifier, EOperation>) TypeUtil.resolveCollectionType(
			getEnvironment(), kind, elementType);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected TupleType<EOperation, EStructuralFeature> resolveTupleType(
			EList<? extends TypedElement<EClassifier>> parts) {
		return (TupleType<EOperation, EStructuralFeature>) TypeUtil.resolveTupleType(getEnvironment(), parts);
	}
	
	@Override
	protected EClassifier resolve(EClassifier type) {		
		return TypeUtil.resolveType(getEnvironment(), type);
	}
	
	@Override
	protected EClassifier resolveGenericType(EClassifier owner, EClassifier paramType, EClassifier argType) {		
		if(paramType instanceof TemplateParameterType) {
			if(owner.eClass() == ImperativeOCLPackage.eINSTANCE.getDictionaryType()) {
				DictionaryType dictionaryType = (DictionaryType) owner;
				if(getQVTEnvironment().getQVTStandardLibrary().getKeyT() == paramType) {
					return dictionaryType.getKeyType();
				}
			}

			return argType;
		}
		
		EClassifier result = super.resolveGenericType(owner, paramType, argType);

		// MDT OCL takes OclVoid element type as applicable for any type, which causes
		// problems to QVT mutable collection types. Consequently, List(OclVoid) should 
		// allow successful parsing of list->append('foo') 
		EClassifier listMetaType = ImperativeOCLPackage.eINSTANCE.getListType();		
		if(owner.eClass() == listMetaType) { 
			if(fOCLStdlib.getT() == result) {
				// super implementation resolved OclVoid to oclstdlib::T				
				org.eclipse.ocl.ecore.CollectionType collectionType = (org.eclipse.ocl.ecore.CollectionType) owner;
				if(collectionType.getElementType() == fOCLStdlib.getOclVoid()) {				
					return fOCLStdlib.getOclVoid(); 
				}
			}
		}
		
		return result;
	}

	@Override
	public EClassifier getResultType(Object problemObject,
			EClassifier owner, EOperation operation,
			List<? extends TypedElement<EClassifier>> args) {

		if(isQVTOperation(operation)) { 
			return fGenericResolver.resolveOperationReturnType(owner, operation, args);				
		}
		
		return super.getResultType(problemObject, owner, operation, args);
	}

	//@Override
	public boolean _matchArgs(EClassifier owner, List<?> paramsOrProperties, List<? extends TypedElement<EClassifier>> args) {
		int argsize;

		if (args == null) {
			argsize = 0;
		} else {
			argsize = args.size();
		}

		if (paramsOrProperties.size() != argsize) {
			return false;
		}
		
		boolean isQVTOperation = false;
		if(argsize > 0) {
			Object paramOfProp = paramsOrProperties.get(0);
			if(paramOfProp instanceof EParameter) {
				EParameter eParameter = (EParameter) paramOfProp;
				isQVTOperation = QvtOperationalParserUtil.getOwningModule(eParameter.getEOperation()) != null;
			}
		}

		int i = 0;
		for (Object paramOrProperty : paramsOrProperties) {
			TypedElement<EClassifier> arg = args.get(i++);
			EClassifier argType = arg.getType();
			EClassifier popType = resolve(getUMLReflection().getOCLType(paramOrProperty));

			// handle parameters of type OclType
			if (popType instanceof TypeType) {
				if (arg instanceof TypeExp) {
					continue;
				}
				return false;
			}

			popType = resolveGenericType(owner, popType, argType);
			
			if(getEnvironment().getOCLStandardLibrary().getT() == popType) {
				continue;
			} else {
				popType = resolveGenericType(owner, popType, argType);
			}

			if (popType == getEnvironment().getOCLStandardLibrary().getT()) {
				// this is a collection operation, and the collection is empty
				// (element type is OclVoid). Any argument matches in this
				// case, because any kind of element can be considered to not
				// be in an empty collection
			//	continue;
			}

			if ((getRelationship(argType, popType) & SUBTYPE) == 0) {
				return false;
			}
		}
		return true;
	}
		
	@Override
	public int getRelationship(EClassifier type1, EClassifier type2) {
		// check for identity before any further analysis
		if(type1 == type2) {
			return UMLReflection.SAME_TYPE;
		}
		
		boolean isList1 = type1 instanceof ListType;
		boolean isList2 = type2 instanceof ListType;
		
		if(isList1 || isList2) {
			// handle list types
			if(isList1 && isList2) {
				ListType list1 = (ListType) type1;
				ListType list2 = (ListType) type2;
				return getRelationship(list1.getElementType(), list2.getElementType());
			} else if(!isList1 && type1 instanceof CollectionType) {
				@SuppressWarnings("unchecked")
				CollectionType<EClassifier, EOperation> col1 = (CollectionType<EClassifier, EOperation>) type1;

				if(col1.eClass() == EcorePackage.eINSTANCE.getCollectionType() &&
					TypeUtil.compatibleTypeMatch(getEnvironment(), 
						((ListType)type2).getElementType(), col1.getElementType())) {
					return UMLReflection.STRICT_SUPERTYPE;
				}				
			} else if(!isList2 && type2 instanceof CollectionType) {
				@SuppressWarnings("unchecked")
				CollectionType<EClassifier, EOperation> col2 = (CollectionType<EClassifier, EOperation>) type2;

				if(col2.eClass() == EcorePackage.eINSTANCE.getCollectionType() &&
					TypeUtil.compatibleTypeMatch(getEnvironment(), 
						((ListType)type1).getElementType(), col2.getElementType())) {
					return UMLReflection.STRICT_SUBTYPE	;
				}				
			}
			
			if(isVoidOrInvalid(type1) || isVoidOrInvalid(type2)) {
				return super.getRelationship(type1, type2);
			}
			
			return UMLReflection.UNRELATED_TYPE;
		}

		boolean isDict1 = type1 instanceof DictionaryType;
		boolean isDict2 = type2 instanceof DictionaryType;
		if(isDict1 || isDict2) {		
			if(isDict1 && isDict2) {
				DictionaryType dict1 = (DictionaryType) type1;
				DictionaryType dict2 = (DictionaryType) type2;			
				int elementRelShip = getRelationship(dict1.getElementType(), dict2.getElementType());
				int keyRelShip = getRelationship(dict1.getKeyType(), dict2.getKeyType());
				
				if(elementRelShip != keyRelShip) {
					if((keyRelShip & UMLReflection.SUBTYPE) != 0 && 
						(elementRelShip & UMLReflection.SUBTYPE) != 0) {						
						return UMLReflection.STRICT_SUBTYPE;
					} 
					else if((keyRelShip & UMLReflection.SUPERTYPE) != 0 && 
							(elementRelShip & UMLReflection.SUPERTYPE) != 0) {
						return UMLReflection.STRICT_SUPERTYPE;						
					}
					
					return elementRelShip;
				} 
					
				return elementRelShip;
				
			} else if(!isDict1) {
				if(type1.eClass() == EcorePackage.eINSTANCE.getCollectionType()) {
					@SuppressWarnings("unchecked")
					CollectionType<EClassifier, EOperation> col1 = (CollectionType<EClassifier, EOperation>) type1;
					if(TypeUtil.compatibleTypeMatch(getEnvironment(), ((DictionaryType)type2).getElementType(), col1.getElementType())) {
						return UMLReflection.STRICT_SUPERTYPE;
					}
				} 
				
				if(isVoidOrInvalid(type1)) {
					return super.getRelationship(type1, type2);
				}			
				// Note: Object can be super the super type not, which is not supported yet
				return UMLReflection.UNRELATED_TYPE;
				
			} else if(!isDict2) {
				if(type2.eClass() == EcorePackage.eINSTANCE.getCollectionType()) {
					@SuppressWarnings("unchecked")
					CollectionType<EClassifier, EOperation> col2 = (CollectionType<EClassifier, EOperation>) type1;
					if(TypeUtil.compatibleTypeMatch(getEnvironment(), ((DictionaryType)type1).getElementType(), col2.getElementType())) {
						return UMLReflection.STRICT_SUBTYPE;
					}
				}
				
				if(isVoidOrInvalid(type2)) {
					return super.getRelationship(type1, type2);
				}				
				// Note: Object can be super the super type not, which is not supported yet
				return UMLReflection.UNRELATED_TYPE;				
			}			
		}		
		
		return super.getRelationship(type1, type2);
	}
	
	/*
	 * FIXME 
	 * We need a custom implementation of commonSuperType due to https://bugs.eclipse.org/bugs/show_bug.cgi?id=260403
	 * Ask MDT OCL for better extensibility in case no supertype of predefined type is found, as we need to have the 
	 * chance to contribute one, the  "Object" type. 
	 */
	@Override
	public EClassifier commonSuperType(Object problemObject, EClassifier type1, EClassifier type2) {

		if (type1 != null) {
			type1 = getEnvironment().getUMLReflection().asOCLType(type1);
		}
		if (type2 != null) {
			type2 = getEnvironment().getUMLReflection().asOCLType(type2);
		}

		if (ObjectUtil.equal(type1, type2)) {
			return type2;
		}

		// the generic type T represents the dynamic type against which we
		// are comparing
		if (type1 == fOCLStdlib.getT()) {
			return type2;
		} else if (type2 == fOCLStdlib.getT()) {
			return type1;
		}

		if ((type1 == fOCLStdlib.getOclVoid()) || (type1 == fOCLStdlib.getInvalid())) {
			return type2;
		}
		if ((type2 == fOCLStdlib.getOclVoid()) || (type2 == fOCLStdlib.getInvalid())) {
			return type1;
		}

		if (type1 == fOCLStdlib.getOclAny() && !(type2 instanceof CollectionType)) {
			return type1;
		}
		if (type2 == fOCLStdlib.getOclAny() && !(type1 instanceof CollectionType)) {
			return type2;
		}

		if ((type1 == fOCLStdlib.getInteger() || type1 == fOCLStdlib
			.getUnlimitedNatural())
			&& type2 == fOCLStdlib.getReal()) {
			return type2;
		}
		if ((type2 == fOCLStdlib.getInteger() || type2 == fOCLStdlib
			.getUnlimitedNatural())
			&& type1 == fOCLStdlib.getReal()) {
			return type1;
		}

		if (type1 instanceof CollectionType && type2 instanceof CollectionType) {
			@SuppressWarnings("unchecked")
			CollectionType<EClassifier, EOperation> ct1 = (CollectionType<EClassifier, EOperation>) type1;
			@SuppressWarnings("unchecked")
			CollectionType<EClassifier, EOperation> ct2 = (CollectionType<EClassifier, EOperation>) type2;

			CollectionKind commonKind = commonSuperType(ct1.getKind(), ct2.getKind());

			EClassifier resultElementType = commonSuperType(problemObject, ct1.getElementType(), ct2.getElementType());

			return (EClassifier) resolveCollectionType(commonKind, resultElementType);
		}

		if (type1 instanceof MessageType && type2 instanceof MessageType) {
			return fOCLStdlib.getOclMessage();
		}

		if (type1 instanceof TypeType && type2 instanceof TypeType) {
			return fOCLStdlib.getOclType();
		}

		if (type1 instanceof TupleType || type2 instanceof TupleType) {
			if (!((type1 instanceof TupleType) && (type2 instanceof TupleType))) {
				String message = NLS.bind(
						OCLMessages.TupleTypeMismatch_ERROR_, getName(type1),
					getName(type2));
				error(message, "commonSuperType", problemObject); //$NON-NLS-1$
				return null;
			}

			List<EStructuralFeature> props1 = getUMLReflection().getAttributes(type1);
			List<EStructuralFeature> props2 = getUMLReflection().getAttributes(type2);

			if (props1.size() != props2.size()) {
				String message = NLS.bind(
						OCLMessages.TupleFieldNumMismatch_ERROR_, getName(type1),
					getName(type2));
				error(message, "commonSuperType", problemObject); //$NON-NLS-1$
				return null;
			}

			EList<Variable<EClassifier, EParameter>> tupleParts = new BasicEList<Variable<EClassifier, EParameter>>();

			for (EStructuralFeature prop1 : props1) {
				boolean found = false;

				for (EStructuralFeature prop2 : props2) {
					if (getUMLReflection().getName(prop1).equals(getUMLReflection().getName(prop2))) {
						EClassifier resultElementType = commonSuperType(problemObject,
							resolve(getUMLReflection().getOCLType(prop1)), resolve(getUMLReflection()
								.getOCLType(prop2)));

						found = true;

						Variable<EClassifier, EParameter> var = getEnvironment().getOCLFactory().createVariable();
						getUMLReflection().setName(var, getName(prop1));
						getUMLReflection().setType(var, resultElementType);

						tupleParts.add(var);
						break;
					}
				}
				if (!found) {
					String message = NLS.bind(
							OCLMessages.TupleFieldNotFound_ERROR_, new Object[]{
							getName(type1), getName(prop1), getName(type2)});
					error(message, "commonSuperType", problemObject); //$NON-NLS-1$
					return null;
				}
			}

			return (EClassifier) resolveTupleType(tupleParts);
		}

		// exhausted the possibilities for pre-defined types
		if (type1 instanceof PredefinedType || type2 instanceof PredefinedType) {
			if(type1 instanceof CollectionType == false && type2 instanceof CollectionType == false) {
				return getEnvironment().getOCLStandardLibrary().getOclAny();
			}
			
			String message = NLS.bind(OCLMessages.TypeMismatch_ERROR_,
				getName(type1), getName(type2));
			error(message, "commonSuperType", problemObject); //$NON-NLS-1$
			return null;
		}

		// remaining case is pure model element types. The environment must
		// handle this

		EClassifier result = getUMLReflection().getCommonSuperType(type1, type2);

		if (result == null) {
			EClassifier implictBaseClassifier = getImplicitRootClass();
			if ((implictBaseClassifier != null) && getUMLReflection().isClass(type1)
				&& getUMLReflection().isClass(type2)) {
				result = implictBaseClassifier;
			}
		}

		if (result == null) {
			String message = NLS.bind(OCLMessages.TypeMismatch_ERROR_,
				getName(type1), getName(type2));
			error(message, "commonSuperType", problemObject); //$NON-NLS-1$
			return null;
		}

		return result;
	}	

	private boolean isQVTOperation(EOperation operation) {
		return QvtOperationalParserUtil.getOwningModule(operation) != null;
	}
	
	private boolean isVoidOrInvalid(EClassifier type1) {
		return type1 == fOCLStdlib.getOclVoid() || type1 == fOCLStdlib.getInvalid();
	}
	
	private QVTOEnvironment getQVTEnvironment() {
		return (QVTOEnvironment) getEnvironment();
	}

	private void error(String problemMessage, String problemContext,
			Object problemObject) {
		OCLUtil.getAdapter(getEnvironment(), BasicEnvironment.class).utilityError(
			problemMessage, problemContext, problemObject);
	}
	
	private String getName(Object element) {
		return (element == null)
			? null
			: getUMLReflection().getName(element);
	}
	
	private EClassifier getImplicitRootClass() {
		EClassifier result = ParsingOptions.getValue(getEnvironment(), ParsingOptions
			.implicitRootClass(getEnvironment()));

		// check that, if there is a value for this option, it is a class
		if ((result != null) && !getEnvironment().getUMLReflection().isClass(result)) {
			result = null;
		}

		return result;
	}	
}