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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingCallExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.ReturnExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.internal.qvt.oml.stdlib.QVTUMLReflection;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.parser.ValidationVisitor;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.ASTNode;
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
			}
		}
		
		final Visitor<Boolean, EClassifier, EOperation, EStructuralFeature, EEnumLiteral,
			EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> myOclValidationVisitor;
		
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
		return Boolean.TRUE.equals(super.visitImperativeOperation(imperativeOperation)) && result;
	}
	
	@Override
	public Object visitOperationBody(OperationBody operationBody) {
		if(operationBody instanceof MappingBody == false) {
			ImperativeOperation operation = operationBody.getOperation();
			if(operation.getEType() == null || operation.getEType() == fEnv.getOCLStandardLibrary().getOclVoid()) {
				return Boolean.TRUE;
			}
			EList<OCLExpression<EClassifier>> content = operationBody.getContent();
			if(content.isEmpty() || content.get(content.size() - 1) instanceof ReturnExp == false) {
				ASTNode problemTarget = operation;
				String message = ValidationMessages.useReturnExpForOperationResult;
				fEnv.reportWarning(message, problemTarget.getStartPosition(), operationBody.getStartPosition());
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
}
