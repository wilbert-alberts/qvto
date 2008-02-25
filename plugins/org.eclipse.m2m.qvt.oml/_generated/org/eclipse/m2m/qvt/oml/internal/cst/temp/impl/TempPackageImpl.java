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
 * $Id: TempPackageImpl.java,v 1.10 2008/02/25 09:54:42 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.internal.cst.temp.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl;
import org.eclipse.m2m.qvt.oml.internal.cst.temp.ErrorCSTNode;
import org.eclipse.m2m.qvt.oml.internal.cst.temp.ErrorCallExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.temp.ErrorOutExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.temp.ErrorVariableInitializationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.temp.ResolveOpArgsExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.temp.ScopedNameCS;
import org.eclipse.m2m.qvt.oml.internal.cst.temp.TempFactory;
import org.eclipse.m2m.qvt.oml.internal.cst.temp.TempPackage;
import org.eclipse.ocl.cst.CSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TempPackageImpl extends EPackageImpl implements TempPackage {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass errorCallExpCSEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass resolveOpArgsExpCSEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass scopedNameCSEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass errorVariableInitializationCSEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass errorOutExpCSEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass errorCSTNodeEClass = null;

    /**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.temp.TempPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
    private TempPackageImpl() {
		super(eNS_URI, TempFactory.eINSTANCE);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private static boolean isInited = false;

    /**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
    public static TempPackage init() {
		if (isInited) return (TempPackage)EPackage.Registry.INSTANCE.getEPackage(TempPackage.eNS_URI);

		// Obtain or create and register package
		TempPackageImpl theTempPackage = (TempPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof TempPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new TempPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CSTPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CSTPackageImpl theCSTPackage_1 = (CSTPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage.eNS_URI) instanceof CSTPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage.eNS_URI) : org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage.eINSTANCE);

		// Create package meta-data objects
		theTempPackage.createPackageContents();
		theCSTPackage_1.createPackageContents();

		// Initialize created meta-data
		theTempPackage.initializePackageContents();
		theCSTPackage_1.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTempPackage.freeze();

		return theTempPackage;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getErrorCallExpCS() {
		return errorCallExpCSEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getResolveOpArgsExpCS() {
		return resolveOpArgsExpCSEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getResolveOpArgsExpCS_Target() {
		return (EReference)resolveOpArgsExpCSEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getResolveOpArgsExpCS_Condition() {
		return (EReference)resolveOpArgsExpCSEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getScopedNameCS() {
		return scopedNameCSEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getScopedNameCS_TypeCS() {
		return (EReference)scopedNameCSEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getScopedNameCS_Name() {
		return (EAttribute)scopedNameCSEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getErrorVariableInitializationCS() {
		return errorVariableInitializationCSEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getErrorOutExpCS() {
		return errorOutExpCSEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getErrorCSTNode() {
		return errorCSTNodeEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getErrorCSTNode_FullStartOffset() {
		return (EAttribute)errorCSTNodeEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getErrorCSTNode_FullEndOffset() {
		return (EAttribute)errorCSTNodeEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public TempFactory getTempFactory() {
		return (TempFactory)getEFactoryInstance();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private boolean isCreated = false;

    /**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		errorCallExpCSEClass = createEClass(ERROR_CALL_EXP_CS);

		resolveOpArgsExpCSEClass = createEClass(RESOLVE_OP_ARGS_EXP_CS);
		createEReference(resolveOpArgsExpCSEClass, RESOLVE_OP_ARGS_EXP_CS__TARGET);
		createEReference(resolveOpArgsExpCSEClass, RESOLVE_OP_ARGS_EXP_CS__CONDITION);

		scopedNameCSEClass = createEClass(SCOPED_NAME_CS);
		createEReference(scopedNameCSEClass, SCOPED_NAME_CS__TYPE_CS);
		createEAttribute(scopedNameCSEClass, SCOPED_NAME_CS__NAME);

		errorVariableInitializationCSEClass = createEClass(ERROR_VARIABLE_INITIALIZATION_CS);

		errorOutExpCSEClass = createEClass(ERROR_OUT_EXP_CS);

		errorCSTNodeEClass = createEClass(ERROR_CST_NODE);
		createEAttribute(errorCSTNodeEClass, ERROR_CST_NODE__FULL_START_OFFSET);
		createEAttribute(errorCSTNodeEClass, ERROR_CST_NODE__FULL_END_OFFSET);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private boolean isInitialized = false;

    /**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CSTPackage theCSTPackage = (CSTPackage)EPackage.Registry.INSTANCE.getEPackage(CSTPackage.eNS_URI);
		org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage theCSTPackage_1 = (org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		errorCallExpCSEClass.getESuperTypes().add(theCSTPackage.getCallExpCS());
		resolveOpArgsExpCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		scopedNameCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		errorVariableInitializationCSEClass.getESuperTypes().add(theCSTPackage_1.getVariableInitializationCS());
		errorOutExpCSEClass.getESuperTypes().add(theCSTPackage_1.getOutExpCS());
		errorOutExpCSEClass.getESuperTypes().add(this.getErrorCSTNode());

		// Initialize classes and features; add operations and parameters
		initEClass(errorCallExpCSEClass, ErrorCallExpCS.class, "ErrorCallExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(resolveOpArgsExpCSEClass, ResolveOpArgsExpCS.class, "ResolveOpArgsExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getResolveOpArgsExpCS_Target(), theCSTPackage.getVariableCS(), null, "target", null, 0, 1, ResolveOpArgsExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getResolveOpArgsExpCS_Condition(), theCSTPackage.getOCLExpressionCS(), null, "condition", null, 0, 1, ResolveOpArgsExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scopedNameCSEClass, ScopedNameCS.class, "ScopedNameCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getScopedNameCS_TypeCS(), theCSTPackage.getTypeCS(), null, "typeCS", null, 0, 1, ScopedNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getScopedNameCS_Name(), ecorePackage.getEString(), "name", null, 1, 1, ScopedNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(errorVariableInitializationCSEClass, ErrorVariableInitializationCS.class, "ErrorVariableInitializationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(errorOutExpCSEClass, ErrorOutExpCS.class, "ErrorOutExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(errorCSTNodeEClass, ErrorCSTNode.class, "ErrorCSTNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getErrorCSTNode_FullStartOffset(), ecorePackage.getEInt(), "fullStartOffset", null, 0, 1, ErrorCSTNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getErrorCSTNode_FullEndOffset(), ecorePackage.getEInt(), "fullEndOffset", null, 0, 1, ErrorCSTNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
	}

} //TempPackageImpl
