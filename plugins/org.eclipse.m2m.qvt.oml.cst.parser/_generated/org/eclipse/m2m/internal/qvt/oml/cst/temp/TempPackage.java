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
 * 
 *
 * $Id: TempPackage.java,v 1.4 2008/11/20 17:41:15 aigdalov Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.temp;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.ocl.cst.CSTPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.TempFactory
 * @model kind="package"
 * @generated
 */
public interface TempPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "temp"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/QVT2/1.0.0/Operational/cst/temp"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtoperational.cst.temp"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TempPackage eINSTANCE = org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.TempPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.ErrorCallExpCSImpl <em>Error Call Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.ErrorCallExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.TempPackageImpl#getErrorCallExpCS()
	 * @generated
	 */
	int ERROR_CALL_EXP_CS = 0;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_CALL_EXP_CS__START_OFFSET = CSTPackage.CALL_EXP_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_CALL_EXP_CS__END_OFFSET = CSTPackage.CALL_EXP_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_CALL_EXP_CS__SOURCE = CSTPackage.CALL_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Accessor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_CALL_EXP_CS__ACCESSOR = CSTPackage.CALL_EXP_CS__ACCESSOR;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_CALL_EXP_CS__SIMPLE_NAME_CS = CSTPackage.CALL_EXP_CS__SIMPLE_NAME_CS;

	/**
	 * The number of structural features of the '<em>Error Call Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_CALL_EXP_CS_FEATURE_COUNT = CSTPackage.CALL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.ResolveOpArgsExpCSImpl <em>Resolve Op Args Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.ResolveOpArgsExpCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.TempPackageImpl#getResolveOpArgsExpCS()
	 * @generated
	 */
	int RESOLVE_OP_ARGS_EXP_CS = 1;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS__TARGET = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS__CONDITION = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resolve Op Args Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.ScopedNameCSImpl <em>Scoped Name CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.ScopedNameCSImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.TempPackageImpl#getScopedNameCS()
	 * @generated
	 */
	int SCOPED_NAME_CS = 2;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS__TYPE_CS = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS__NAME = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Scoped Name CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.ErrorCSTNodeImpl <em>Error CST Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.ErrorCSTNodeImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.TempPackageImpl#getErrorCSTNode()
	 * @generated
	 */
	int ERROR_CST_NODE = 3;

	/**
	 * The feature id for the '<em><b>Full Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_CST_NODE__FULL_START_OFFSET = 0;

	/**
	 * The feature id for the '<em><b>Full End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_CST_NODE__FULL_END_OFFSET = 1;

	/**
	 * The number of structural features of the '<em>Error CST Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_CST_NODE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.temp.ErrorCallExpCS <em>Error Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Call Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.ErrorCallExpCS
	 * @generated
	 */
	EClass getErrorCallExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.temp.ResolveOpArgsExpCS <em>Resolve Op Args Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolve Op Args Exp CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.ResolveOpArgsExpCS
	 * @generated
	 */
	EClass getResolveOpArgsExpCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.temp.ResolveOpArgsExpCS#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.ResolveOpArgsExpCS#getTarget()
	 * @see #getResolveOpArgsExpCS()
	 * @generated
	 */
	EReference getResolveOpArgsExpCS_Target();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.temp.ResolveOpArgsExpCS#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.ResolveOpArgsExpCS#getCondition()
	 * @see #getResolveOpArgsExpCS()
	 * @generated
	 */
	EReference getResolveOpArgsExpCS_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.temp.ScopedNameCS <em>Scoped Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scoped Name CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.ScopedNameCS
	 * @generated
	 */
	EClass getScopedNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.cst.temp.ScopedNameCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.ScopedNameCS#getTypeCS()
	 * @see #getScopedNameCS()
	 * @generated
	 */
	EReference getScopedNameCS_TypeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.temp.ScopedNameCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.ScopedNameCS#getName()
	 * @see #getScopedNameCS()
	 * @generated
	 */
	EAttribute getScopedNameCS_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.cst.temp.ErrorCSTNode <em>Error CST Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error CST Node</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.ErrorCSTNode
	 * @generated
	 */
	EClass getErrorCSTNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.temp.ErrorCSTNode#getFullStartOffset <em>Full Start Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full Start Offset</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.ErrorCSTNode#getFullStartOffset()
	 * @see #getErrorCSTNode()
	 * @generated
	 */
	EAttribute getErrorCSTNode_FullStartOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.cst.temp.ErrorCSTNode#getFullEndOffset <em>Full End Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full End Offset</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.ErrorCSTNode#getFullEndOffset()
	 * @see #getErrorCSTNode()
	 * @generated
	 */
	EAttribute getErrorCSTNode_FullEndOffset();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TempFactory getTempFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.ErrorCallExpCSImpl <em>Error Call Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.ErrorCallExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.TempPackageImpl#getErrorCallExpCS()
		 * @generated
		 */
		EClass ERROR_CALL_EXP_CS = eINSTANCE.getErrorCallExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.ResolveOpArgsExpCSImpl <em>Resolve Op Args Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.ResolveOpArgsExpCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.TempPackageImpl#getResolveOpArgsExpCS()
		 * @generated
		 */
		EClass RESOLVE_OP_ARGS_EXP_CS = eINSTANCE.getResolveOpArgsExpCS();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLVE_OP_ARGS_EXP_CS__TARGET = eINSTANCE.getResolveOpArgsExpCS_Target();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLVE_OP_ARGS_EXP_CS__CONDITION = eINSTANCE.getResolveOpArgsExpCS_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.ScopedNameCSImpl <em>Scoped Name CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.ScopedNameCSImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.TempPackageImpl#getScopedNameCS()
		 * @generated
		 */
		EClass SCOPED_NAME_CS = eINSTANCE.getScopedNameCS();

		/**
		 * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOPED_NAME_CS__TYPE_CS = eINSTANCE.getScopedNameCS_TypeCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCOPED_NAME_CS__NAME = eINSTANCE.getScopedNameCS_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.ErrorCSTNodeImpl <em>Error CST Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.ErrorCSTNodeImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.cst.temp.impl.TempPackageImpl#getErrorCSTNode()
		 * @generated
		 */
		EClass ERROR_CST_NODE = eINSTANCE.getErrorCSTNode();

		/**
		 * The meta object literal for the '<em><b>Full Start Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_CST_NODE__FULL_START_OFFSET = eINSTANCE.getErrorCSTNode_FullStartOffset();

		/**
		 * The meta object literal for the '<em><b>Full End Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_CST_NODE__FULL_END_OFFSET = eINSTANCE.getErrorCSTNode_FullEndOffset();

	}

} //TempPackage
