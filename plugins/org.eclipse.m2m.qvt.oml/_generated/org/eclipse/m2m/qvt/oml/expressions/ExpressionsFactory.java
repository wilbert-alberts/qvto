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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage
 * @generated
 */
public interface ExpressionsFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation"; //$NON-NLS-1$
    /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionsFactory eINSTANCE = org.eclipse.m2m.qvt.oml.expressions.impl.ExpressionsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module</em>'.
	 * @generated
	 */
	Module createModule();

	/**
	 * Returns a new object of class '<em>Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Library</em>'.
	 * @generated
	 */
	Library createLibrary();

	/**
	 * Returns a new object of class '<em>Rename</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rename</em>'.
	 * @generated
	 */
	Rename createRename();

	/**
	 * Returns a new object of class '<em>Module Import</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module Import</em>'.
	 * @generated
	 */
	ModuleImport createModuleImport();

	/**
	 * Returns a new object of class '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property</em>'.
	 * @generated
	 */
	Property createProperty();

	/**
	 * Returns a new object of class '<em>Local Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Property</em>'.
	 * @generated
	 */
	LocalProperty createLocalProperty();

	/**
	 * Returns a new object of class '<em>Config Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Config Property</em>'.
	 * @generated
	 */
	ConfigProperty createConfigProperty();

	/**
	 * Returns a new object of class '<em>Imperative Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Operation</em>'.
	 * @generated
	 */
	ImperativeOperation createImperativeOperation();

	/**
	 * Returns a new object of class '<em>Model Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Parameter</em>'.
	 * @generated
	 */
	ModelParameter createModelParameter();

	/**
	 * Returns a new object of class '<em>Var Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Var Parameter</em>'.
	 * @generated
	 */
	VarParameter createVarParameter();

	/**
	 * Returns a new object of class '<em>Operation Body</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Body</em>'.
	 * @generated
	 */
	OperationBody createOperationBody();

	/**
	 * Returns a new object of class '<em>Mapping Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Operation</em>'.
	 * @generated
	 */
	MappingOperation createMappingOperation();

	/**
	 * Returns a new object of class '<em>Helper</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Helper</em>'.
	 * @generated
	 */
	Helper createHelper();

	/**
	 * Returns a new object of class '<em>Mapping Body</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Body</em>'.
	 * @generated
	 */
	MappingBody createMappingBody();

	/**
	 * Returns a new object of class '<em>Assign Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assign Exp</em>'.
	 * @generated
	 */
	AssignExp createAssignExp();

	/**
	 * Returns a new object of class '<em>Variable Init Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Init Exp</em>'.
	 * @generated
	 */
	VariableInitExp createVariableInitExp();

	/**
	 * Returns a new object of class '<em>Mapping Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Call Exp</em>'.
	 * @generated
	 */
	MappingCallExp createMappingCallExp();

	/**
	 * Returns a new object of class '<em>Block Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Exp</em>'.
	 * @generated
	 */
	BlockExp createBlockExp();

	/**
	 * Returns a new object of class '<em>Object Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Exp</em>'.
	 * @generated
	 */
	ObjectExp createObjectExp();

	/**
	 * Returns a new object of class '<em>While Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>While Exp</em>'.
	 * @generated
	 */
	WhileExp createWhileExp();

	/**
	 * Returns a new object of class '<em>Resolve Exp</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resolve Exp</em>'.
	 * @generated
	 */
    ResolveExp createResolveExp();

    /**
	 * Returns a new object of class '<em>Resolve In Exp</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resolve In Exp</em>'.
	 * @generated
	 */
    ResolveInExp createResolveInExp();

    /**
	 * Returns a new object of class '<em>Model Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Type</em>'.
	 * @generated
	 */
	ModelType createModelType();

				/**
	 * Returns a new object of class '<em>Package Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package Ref</em>'.
	 * @generated
	 */
	PackageRef createPackageRef();

				/**
	 * Returns a new object of class '<em>Mapping Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Parameter</em>'.
	 * @generated
	 */
	MappingParameter createMappingParameter();

				/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExpressionsPackage getExpressionsPackage();

} //ExpressionsFactory
