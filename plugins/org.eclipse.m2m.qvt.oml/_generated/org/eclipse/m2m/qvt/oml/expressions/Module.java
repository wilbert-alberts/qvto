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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.Module#getModuleImport <em>Module Import</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.Module#getUsedModelType <em>Used Model Type</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.Module#getConfigProperty <em>Config Property</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.Module#getOwnedRenaming <em>Owned Renaming</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.Module#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.Module#getModelParameter <em>Model Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getModule()
 * @model
 * @generated
 */
public interface Module extends EClass, EPackage, VisitableASTNode {
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation"; //$NON-NLS-1$

    /**
	 * Returns the value of the '<em><b>Owned Renaming</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.qvt.oml.expressions.Rename}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Renaming</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Renaming</em>' containment reference list.
	 * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getModule_OwnedRenaming()
	 * @model containment="true"
	 * @generated
	 */
	EList<Rename> getOwnedRenaming();

	/**
	 * Returns the value of the '<em><b>Entry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry</em>' reference.
	 * @see #setEntry(EOperation)
	 * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getModule_Entry()
	 * @model
	 * @generated
	 */
	EOperation getEntry();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.expressions.Module#getEntry <em>Entry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry</em>' reference.
	 * @see #getEntry()
	 * @generated
	 */
	void setEntry(EOperation value);

	/**
	 * Returns the value of the '<em><b>Model Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.qvt.oml.expressions.ModelParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Parameter</em>' containment reference list.
	 * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getModule_ModelParameter()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelParameter> getModelParameter();

	/**
	 * Returns the value of the '<em><b>Config Property</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.qvt.oml.expressions.Property}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.qvt.oml.expressions.Property#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config Property</em>' containment reference list.
	 * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getModule_ConfigProperty()
	 * @see org.eclipse.m2m.qvt.oml.expressions.Property#getModule
	 * @model opposite="module" containment="true"
	 * @generated
	 */
	EList<Property> getConfigProperty();

	/**
	 * Returns the value of the '<em><b>Module Import</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.qvt.oml.expressions.ModuleImport}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.qvt.oml.expressions.ModuleImport#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module Import</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module Import</em>' containment reference list.
	 * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getModule_ModuleImport()
	 * @see org.eclipse.m2m.qvt.oml.expressions.ModuleImport#getModule
	 * @model opposite="module" containment="true"
	 * @generated
	 */
	EList<ModuleImport> getModuleImport();

	/**
	 * Returns the value of the '<em><b>Used Model Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.qvt.oml.expressions.ModelType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Model Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Model Type</em>' containment reference list.
	 * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getModule_UsedModelType()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelType> getUsedModelType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((<%org.eclipse.m2m.qvt.oml.expressions.ExtendedVisitor%><T, ?, ?, ?, ?>) v).visitModule(this);'"
	 * @generated
	 */
	<T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v);

} // Module
