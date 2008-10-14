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
package org.eclipse.m2m.internal.qvt.oml.ast.parser;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.InstantiationExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingCallExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.expressions.PackageRef;
import org.eclipse.m2m.internal.qvt.oml.expressions.ReturnExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.internal.qvt.oml.stdlib.QVTUMLReflection;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.lpg.FormattingHelper;
import org.eclipse.ocl.parser.ValidationVisitor;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.ocl.utilities.Visitable;
import org.eclipse.ocl.utilities.Visitor;
import org.eclipse.osgi.util.NLS;

/**
 * 
 * @author sboyko
 * 
 * Ill-based validation visitor for OCL expressions only. 
 * Presented till 'https://bugs.eclipse.org/bugs/show_bug.cgi?id=215544'
 * is not resolved.
 *
 */
public class QvtOperationalValidationVisitor extends QvtOperationalAstWalker {
	private QvtOperationalEnv fEnv;
	
	public QvtOperationalValidationVisitor(QvtOperationalEnv environment) {
		super (new ValidationNodeProcessor(environment));
		fEnv = environment;
	}
	
	private static class ValidationNodeProcessor implements NodeProcessor {
			
		ValidationNodeProcessor(QvtOperationalEnv environment) {
			myOclValidationVisitor = ValidationVisitor.getInstance(environment);
		}

		public void process(Visitable e, Visitable parent) throws StopException {
			try {
				e.accept(myOclValidationVisitor);
			}
			catch (Throwable throwable) {
				// FIXME - eliminate this !!!! 
			}
		}
		
		final Visitor<Boolean, EClassifier, EOperation, EStructuralFeature, EEnumLiteral,
			EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> myOclValidationVisitor;
		
	}
	
	@Override
	public Object visitInstantiationExp(InstantiationExp instantiationExp) {
		Boolean result = Boolean.TRUE;
		EClass instantiatedClass = instantiationExp.getInstantiatedClass();
		if(instantiatedClass == null || QvtOperationalStdLibrary.INSTANCE.getTransformationClass().isSuperTypeOf(instantiatedClass) == false) {
			fEnv.reportError(ValidationMessages.bind(
					ValidationMessages.QvtOperationalValidationVisitor_invalidInstantiatedType, 
					fEnv.getFormatter().formatType(instantiatedClass)), 
					instantiationExp.getStartPosition(), 
					instantiationExp.getEndPosition());
			result = Boolean.FALSE;
		}
		
		if(instantiatedClass instanceof OperationalTransformation) {
			OperationalTransformation transf = (OperationalTransformation) instantiatedClass;
			List<OCLExpression<EClassifier>> actualArgs = instantiationExp.getArgument();
			EList<ModelParameter> formalArgs = transf.getModelParameter();
			
			if(actualArgs.size() == formalArgs.size()) {
				int i = 0;
				for (ModelParameter modelParameter : formalArgs) {
					EClassifier paramType = modelParameter.getType();
					OCLExpression<EClassifier> nextActualArg = actualArgs.get(i++);
					EClassifier expectedType = nextActualArg.getType();
					
					boolean compatible = paramType instanceof ModelType && expectedType instanceof ModelType &&
										checkCompatibleModelType((ModelType)paramType, (ModelType)expectedType);
					if(!compatible) {
						fEnv.reportError(ValidationMessages.bind(
								ValidationMessages.QvtOperationalValidationVisitor_incompatibleArgumentModelType,
								fEnv.getFormatter().formatType(nextActualArg.getType()),								
								fEnv.getFormatter().formatType(modelParameter.getEType())),								
								nextActualArg.getStartPosition(), 
								nextActualArg.getEndPosition());
						result = Boolean.FALSE;						
					}
					// check for compatible direction kind 
					
				}
			} else {
				fEnv.reportError(ValidationMessages.bind(
						ValidationMessages.QvtOperationalValidationVisitor_unresolvedTransformationSignature,
						new Object [] {
							fEnv.getFormatter().formatName(transf),
							formatArgumentList(actualArgs, fEnv.getFormatter()), 
							formatArgumentList(formalArgs, fEnv.getFormatter())
						}),
						instantiationExp.getStartPosition(), 
						instantiationExp.getEndPosition());
				result = Boolean.FALSE;				
			}
		}	
		
		return result;		
	}
		
	private String formatArgumentList(List<?> args, FormattingHelper helper) {
		StringBuilder buf = new StringBuilder();
		buf.append('(');
		int i = 0;
		for (Object nextArg : args) {
			if(i++ > 0) {
				buf.append(',').append(' ');
			}
			if(nextArg instanceof TypedElement) {
				@SuppressWarnings("unchecked")
				TypedElement<EClassifier> typedElement = (TypedElement<EClassifier>) nextArg;
				buf.append(helper.formatType(typedElement.getType()));
			} 
			else if(nextArg instanceof ETypedElement) {
				buf.append(helper.formatType(((ETypedElement) nextArg).getEType()));
			} else if(nextArg instanceof EClassifier) {
				buf.append(helper.formatType(nextArg));
			}
		}
		
		buf.append(')');		
		return buf.toString();
	}

	private boolean checkCompatibleModelType(ModelType modelType1, ModelType modelType2) {
		EList<PackageRef> metamodel1 = modelType1.getMetamodel();
		EList<PackageRef> metamodel2 = modelType2.getMetamodel();
		if(metamodel1.size() < metamodel2.size()) {
			return false;
		}		

		LinkedList<String> uris1 = new LinkedList<String>();
		for (PackageRef pRef : metamodel1) {
			if(pRef.getUri() != null) {
				uris1.add(pRef.getUri());
			} else {
				return false;
			}
		};
		
		LinkedList<String> uris2 = new LinkedList<String>();
		for (PackageRef pRef : metamodel1) {
			if(pRef.getUri() != null) {
				uris2.add(pRef.getUri());
			} else {
				return false;
			}
		};
		
		return uris1.containsAll(uris2);
	}
	
	@Override
	public Object visitMappingCallExp(MappingCallExp mappingCallExp) {
		if(mappingCallExp.getReferredOperation() instanceof MappingOperation) {
			MappingOperation mappingOperation = (MappingOperation) mappingCallExp.getReferredOperation();
			
			if(QvtOperationalUtil.hasAbstractOutputParamerter(mappingOperation) && 
					QvtOperationalParserUtil.isAbstractMappingOperation(mappingOperation) &&
					mappingOperation.getDisjunct().isEmpty()) {
				String errMessage = NLS.bind(ValidationMessages.directCallToAbstractMappingDisallowed,
						QvtOperationalParserUtil.safeGetMappingQualifiedName(fEnv, mappingOperation));
				
				fEnv.reportError(errMessage,  mappingCallExp.getStartPosition(), mappingCallExp.getEndPosition());
			}
		}
		return super.visitMappingCallExp(mappingCallExp);
	}

	
	@Override
	public Object visitReturnExp(ReturnExp returnExp) {
		OperationBody body = QvtOperationalParserUtil.findParentElement(returnExp, OperationBody.class);
		
		if(body != null && body.getOperation() != null) {
			EClassifier actualType = returnExp.getType();			
			EClassifier declaredType = body.getOperation().getEType();
			
			if(actualType != null && declaredType != null) {
				int rel = TypeUtil.getRelationship(fEnv, actualType, declaredType);
				if((rel & UMLReflection.SUBTYPE) == 0) {
					String typeName = QvtOperationalParserUtil.safeGetQualifiedName(fEnv, declaredType);
					fEnv.reportError(NLS.bind(ValidationMessages.typeMismatchError, typeName),  //$NON-NLS-1$
							returnExp.getStartPosition(), returnExp.getEndPosition());
				}
				
				if(returnExp.getValue() == null && !body.getOperation().getResult().isEmpty()) {
					fEnv.reportError(ValidationMessages.missingReturnValueError, returnExp.getStartPosition(), returnExp.getEndPosition());					 //$NON-NLS-1$
				}
				
			} else {
				if(actualType != null && returnExp.getValue() == null && declaredType == fEnv.getOCLStandardLibrary().getOclVoid()) {
					return Boolean.TRUE;
				}
				String typeName = QvtOperationalParserUtil.safeGetQualifiedName(fEnv, declaredType);
				fEnv.reportError(NLS.bind(ValidationMessages.typeMismatchError, typeName),  //$NON-NLS-1$
						returnExp.getStartPosition(), returnExp.getEndPosition());
			}
						
			if(body instanceof MappingBody) {
				// do not support explicit return from mapping operation yet
				fEnv.reportError(ValidationMessages.returnNotAllowedInMappingYet, returnExp.getStartPosition(), returnExp.getEndPosition()); //$NON-NLS-1$
			}
		} else {
			fEnv.reportError(ValidationMessages.returnUsedOutsideOperationBody, returnExp.getStartPosition(), returnExp.getEndPosition());
		}
		
		return super.visitReturnExp(returnExp);
	}
		
	@Override
	public Object visitMappingOperation(MappingOperation operation) {
		boolean result = MappingExtensionHelper.validate(operation, fEnv);
				
		for (VarParameter resultParam : operation.getResult()) {
			result &= validateOutParamType(resultParam);			
		}
		
		for (EParameter nextEParam : operation.getEParameters()) {
			if(nextEParam instanceof VarParameter) {
				VarParameter varParameter = (VarParameter) nextEParam;
				if(varParameter.getKind() == DirectionKind.OUT) {
					result &= validateOutParamType(varParameter);
				}
			}
		}

		return Boolean.TRUE.equals(super.visitMappingOperation(operation)) && result;
	}
	
	@Override
	public Object visitImperativeOperation(ImperativeOperation imperativeOperation) {
		boolean result = true;
		VarParameter context = imperativeOperation.getContext();
		if(context != null) {
			EClassifier eType = context.getEType();
			if(!isValidContextualType(eType)) {
				result = false;
				String errMessage = NLS.bind(ValidationMessages.QvtOperationalValidationVisitor_invalidContextualType, 
						QvtOperationalParserUtil.safeGetQualifiedName(fEnv, eType));
				fEnv.reportError(errMessage, context.getStartPosition(), context.getEndPosition());
			}
		}

		validateUniqueParamNames(imperativeOperation);
		// TODO - 1. validate no param name for single result param, for no explicit but default out direction kind
		
		
		for (EParameter nextEParam : imperativeOperation.getEParameters()) {
			VarParameter varParameter = (VarParameter) nextEParam;
			validateParamNameRequired(varParameter);
		}		
		
		for (VarParameter nextResultParam : imperativeOperation.getResult()) {
			validateParamNameRequired(nextResultParam);
			if(nextResultParam.getKind() != DirectionKind.OUT) {
				fEnv.reportError(ValidationMessages.QvtOperationalValidationVisitor_resultParamDirectionMustBeOut, nextResultParam.getStartPosition(), nextResultParam.getEndPosition());
			}
		}
		
		return Boolean.TRUE.equals(super.visitImperativeOperation(imperativeOperation)) && result;
	}
	
	@Override
	public Object visitOperationBody(OperationBody operationBody) {
		if(operationBody instanceof MappingBody == false) {
			ImperativeOperation operation = operationBody.getOperation();
			if(operation.getEType() == null || operation.getEType() == fEnv.getOCLStandardLibrary().getOclVoid()) {
				//return Boolean.TRUE; // continue to super type visit
			} else {
				EList<OCLExpression<EClassifier>> content = operationBody.getContent();
				if(operation.getResult().size() == 1 && 
					(content.isEmpty() || content.get(content.size() - 1) instanceof ReturnExp == false)) {
					ASTNode problemTarget = operation;
					String message = ValidationMessages.useReturnExpForOperationResult;
					fEnv.reportWarning(message, problemTarget.getStartPosition(), operationBody.getStartPosition());
				}
			}
		}
		return super.visitOperationBody(operationBody);
	}
	
	private static boolean isValidContextualType(EClassifier type) {
		return type != null && !QVTUMLReflection.isModuleInstance(type);
	}

	private boolean validateOutParamType(VarParameter resultParam) {
		boolean result = true;
		EClassifier paramType = resultParam.getEType();
		if(paramType != null) {
			if(QVTUMLReflection.isModelTypeInstance(paramType) ||
				QVTUMLReflection.isModuleInstance(paramType)) {
				result = false;
				fEnv.reportError(NLS.bind(ValidationMessages.nonModelTypeError, 
									QvtOperationalParserUtil.safeGetQualifiedName(fEnv, paramType)), 
									resultParam.getStartPosition(), resultParam.getEndPosition());
			}
		}
		return result;
	}
	
	private void validateUniqueParamNames(ImperativeOperation operation) {
		List<? extends VarParameter> modelParams = getModelParamsInScope(operation);
		@SuppressWarnings("unchecked")
		List<? extends VarParameter> regularParams = (List<? extends VarParameter>)operation.getEParameters();
		List<? extends VarParameter> resultParams = operation.getResult();
		validateUniqueParamNames(regularParams, modelParams);
		validateUniqueParamNames(regularParams, regularParams);
		
		validateUniqueParamNames(resultParams, modelParams);		
		validateUniqueParamNames(resultParams, regularParams);
		validateUniqueParamNames(resultParams, resultParams);	
	}
	
	private static List<ModelParameter> getModelParamsInScope(ImperativeOperation mappingOperation) {
		Module module = QvtOperationalParserUtil.getOwningModule(mappingOperation);
		return (module instanceof OperationalTransformation) ? ((OperationalTransformation)module).getModelParameter() : Collections.<ModelParameter>emptyList();
	}
		
	
	private boolean validateParamNameRequired(VarParameter param) {
		boolean result = true;
		String name = param.getName();
		if(name == null || name.trim().length() == 0) {
			result = false;
            fEnv.reportError(ValidationMessages.QvtOperationalValidationVisitor_parameterNamedRequired,
                     ((VarParameter) param).getStartPosition(), 
                     ((VarParameter) param).getEndPosition());								
		}
		return result;
	}
	
	private <T extends VarParameter> boolean validateUniqueParamNames(List<? extends T> params, List<? extends T> scopeParameters) {
		boolean result = true;		
		for (T nextParam : params) {
			if(nextParam.getName() == null) {
				// this case is handled by 
				continue; 
			}
			T sameNameParam = findParamByName(nextParam.getName(), scopeParameters);
			if(sameNameParam != null && sameNameParam != nextParam) {
				result = false;
	            fEnv.reportError(NLS.bind(ValidationMessages.SemanticUtil_15,	            		 
	                     new Object[] { nextParam.getName() }),
	                     ((VarParameter) nextParam).getStartPosition(), 
	                     ((VarParameter) nextParam).getEndPosition());				
			}
		}
		return result;
	}
	
	private static <T extends EParameter> T findParamByName(String name, List<T> parameters) {
		for (T nextParam : parameters) {
			String paramName = nextParam.getName();
			if((name != null) ? name.equals(paramName) : name == paramName) {
				return nextParam;
			}
		}
		return null;
	}
}
