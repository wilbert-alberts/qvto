/**
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *
 * $Id: ImperativeOCLVisitor.java,v 1.1 2009/01/11 23:22:03 radvorak Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.expressions;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOCLPackage#getImperativeOCLVisitor()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ImperativeOCLVisitor<T> extends Visitor<T, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model assignExpRequired="true"
	 * @generated
	 */
	T visitAssignExp(AssignExp assignExp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model variableInitExpRequired="true"
	 * @generated
	 */
	T visitVariableInitExp(VariableInitExp variableInitExp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model blockExpRequired="true"
	 * @generated
	 */
	T visitBlockExp(BlockExp blockExp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model computeExpRequired="true"
	 * @generated
	 */
	T visitComputeExp(ComputeExp computeExp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model instantiationExpRequired="true"
	 * @generated
	 */
	T visitInstantiationExp(InstantiationExp instantiationExp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model whileExpRequired="true"
	 * @generated
	 */
	T visitWhileExp(WhileExp whileExp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model switchExpRequired="true"
	 * @generated
	 */
	T visitSwitchExp(SwitchExp switchExp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model switchAltExpRequired="true"
	 * @generated
	 */
	T visitSwitchAltExp(AltExp switchAltExp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model logExpRequired="true"
	 * @generated
	 */
	T visitLogExp(LogExp logExp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model assertExpRequired="true"
	 * @generated
	 */
	T visitAssertExp(AssertExp assertExp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model imperativeLoopExpRequired="true"
	 * @generated
	 */
	T visitImperativeLoopExp(ImperativeLoopExp imperativeLoopExp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model forExpRequired="true"
	 * @generated
	 */
	T visitForExp(ForExp forExp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model imperativeIterateExpRequired="true"
	 * @generated
	 */
	T visitImperativeIterateExp(ImperativeIterateExp imperativeIterateExp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model returnExpRequired="true"
	 * @generated
	 */
	T visitReturnExp(ReturnExp returnExp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dictLiteralExpRequired="true"
	 * @generated
	 */
	T visitDictLiteralExp(DictLiteralExp dictLiteralExp);

} // ImperativeOCLVisitor
