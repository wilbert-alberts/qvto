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
package org.eclipse.m2m.qvt.oml.expressions;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extended Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getExtendedVisitor()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ExtendedVisitor<T, S, COA, SSA, CT> extends Visitor<T, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, S, COA, SSA, CT> {
	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation"; //$NON-NLS-1$

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model moduleRequired="true"
     * @generated
     */
	T visitModule(Module module);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model libraryRequired="true"
     * @generated
     */
	T visitLibrary(Library library);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model renameRequired="true"
     * @generated
     */
	T visitRename(Rename rename);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model moduleImportRequired="true"
     * @generated
     */
	T visitModuleImport(ModuleImport moduleImport);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model propertyRequired="true"
     * @generated
     */
	T visitProperty(Property property);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model localPropertyRequired="true"
     * @generated
     */
	T visitLocalProperty(LocalProperty localProperty);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model configPropertyRequired="true"
     * @generated
     */
	T visitConfigProperty(ConfigProperty configProperty);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model imperativeOperationRequired="true"
     * @generated
     */
	T visitImperativeOperation(ImperativeOperation imperativeOperation);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model varParameterRequired="true"
     * @generated
     */
	T visitVarParameter(VarParameter varParameter);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model operationBodyRequired="true"
     * @generated
     */
	T visitOperationBody(OperationBody operationBody);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model mappingOperationRequired="true"
     * @generated
     */
	T visitMappingOperation(MappingOperation mappingOperation);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model helperRequired="true"
     * @generated
     */
	T visitHelper(Helper helper);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model mappingBodyRequired="true"
     * @generated
     */
	T visitMappingBody(MappingBody mappingBody);

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
     * @model mappingCallExpRequired="true"
     * @generated
     */
	T visitMappingCallExp(MappingCallExp mappingCallExp);

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model resolveExpRequired="true"
     * @generated
     */
    T visitResolveExp(ResolveExp resolveExp);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model resolveInExpRequired="true"
     * @generated
     */
    T visitResolveInExp(ResolveInExp resolveInExp);

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
     * @model objectExpRequired="true"
     * @generated
     */
	T visitObjectExp(ObjectExp objectExp);

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
     * @model modelTypeRequired="true"
     * @generated
     */
	T visitModelType(ModelType modelType);

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
     * @model imperativeIterateExpRequired="true"
     * @generated
     */
    T visitImperativeIterateExp(ImperativeIterateExp imperativeIterateExp);

} // ExtendedVisitor
