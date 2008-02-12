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
 * $Id: CSTPackageImpl.java,v 1.9 2008/02/12 14:59:47 aigdalov Exp $
 */
package org.eclipse.m2m.qvt.oml.internal.cst.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.m2m.qvt.oml.internal.cst.AssertExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.AssignStatementCS;
import org.eclipse.m2m.qvt.oml.internal.cst.BlockExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory;
import org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage;
import org.eclipse.m2m.qvt.oml.internal.cst.ConfigPropertyCS;
import org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindCS;
import org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindEnum;
import org.eclipse.m2m.qvt.oml.internal.cst.ElementWithBody;
import org.eclipse.m2m.qvt.oml.internal.cst.ExpressionStatementCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ImperativeIterateExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ImperativeLoopExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ImportCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ImportKindEnum;
import org.eclipse.m2m.qvt.oml.internal.cst.LibraryCS;
import org.eclipse.m2m.qvt.oml.internal.cst.LibraryImportCS;
import org.eclipse.m2m.qvt.oml.internal.cst.LocalPropertyCS;
import org.eclipse.m2m.qvt.oml.internal.cst.LogExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingCallExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingEndCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingInitCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingMethodCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingQueryCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingRuleCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingSectionCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ModuleImportCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ModuleKindCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ModuleKindEnum;
import org.eclipse.m2m.qvt.oml.internal.cst.ModulePropertyCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ModuleRefCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ModuleUsageCS;
import org.eclipse.m2m.qvt.oml.internal.cst.OutExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.PackageRefCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ParameterDeclarationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.RenameCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ResolveExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ResolveInExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.StatementCS;
import org.eclipse.m2m.qvt.oml.internal.cst.SwitchAltExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.SwitchExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS;
import org.eclipse.m2m.qvt.oml.internal.cst.TransformationRefineCS;
import org.eclipse.m2m.qvt.oml.internal.cst.TypeSpecCS;
import org.eclipse.m2m.qvt.oml.internal.cst.VariableInitializationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.WhileExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.temp.TempPackage;
import org.eclipse.m2m.qvt.oml.internal.cst.temp.impl.TempPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CSTPackageImpl extends EPackageImpl implements CSTPackage {
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
    private EClass mappingModuleCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass libraryCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass importCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass moduleImportCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass libraryImportCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass renameCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modulePropertyCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass configPropertyCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass localPropertyCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mappingDeclarationCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass parameterDeclarationCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mappingMethodCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mappingRuleCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mappingQueryCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mappingSectionCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mappingInitCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mappingEndCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass statementCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass assignStatementCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass expressionStatementCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass variableInitializationCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mappingBodyCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass outExpCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass patternPropertyExpCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mappingCallExpCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass whileExpCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass switchExpCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass switchAltExpCSEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass blockExpCSEClass = null;

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass directionKindCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass elementWithBodyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass resolveExpCSEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass resolveInExpCSEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass modelTypeCSEClass = null;

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass packageRefCSEClass = null;

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass transformationHeaderCSEClass = null;

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass moduleKindCSEClass = null;

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass moduleRefCSEClass = null;

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass moduleUsageCSEClass = null;

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass transformationRefineCSEClass = null;

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass typeSpecCSEClass = null;

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass logExpCSEClass = null;

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass assertExpCSEClass = null;

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass imperativeLoopExpCSEClass = null;

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass imperativeIterateExpCSEClass = null;

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum directionKindEnumEEnum = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum moduleKindEnumEEnum = null;

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum importKindEnumEEnum = null;

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
     * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private CSTPackageImpl() {
        super(eNS_URI, CSTFactory.eINSTANCE);
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
    public static CSTPackage init() {
        if (isInited) return (CSTPackage)EPackage.Registry.INSTANCE.getEPackage(CSTPackage.eNS_URI);

        // Obtain or create and register package
        CSTPackageImpl theCSTPackage = (CSTPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof CSTPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new CSTPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        org.eclipse.ocl.cst.CSTPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        TempPackageImpl theTempPackage = (TempPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TempPackage.eNS_URI) instanceof TempPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TempPackage.eNS_URI) : TempPackage.eINSTANCE);

        // Create package meta-data objects
        theCSTPackage.createPackageContents();
        theTempPackage.createPackageContents();

        // Initialize created meta-data
        theCSTPackage.initializePackageContents();
        theTempPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theCSTPackage.freeze();

        return theCSTPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMappingModuleCS() {
        return mappingModuleCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMappingModuleCS_HeaderCS() {
        return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingModuleCS_Imports() {
        return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingModuleCS_Metamodels() {
        return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingModuleCS_Renamings() {
        return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingModuleCS_Properties() {
        return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingModuleCS_Methods() {
        return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLibraryCS() {
        return libraryCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getImportCS() {
        return importCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getImportCS_PathNameCS() {
        return (EReference)importCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModuleImportCS() {
        return moduleImportCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLibraryImportCS() {
        return libraryImportCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRenameCS() {
        return renameCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRenameCS_TypeCS() {
        return (EReference)renameCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRenameCS_SimpleNameCS() {
        return (EReference)renameCSEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRenameCS_OriginalName() {
        return (EReference)renameCSEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModulePropertyCS() {
        return modulePropertyCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModulePropertyCS_SimpleNameCS() {
        return (EReference)modulePropertyCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getConfigPropertyCS() {
        return configPropertyCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConfigPropertyCS_TypeCS() {
        return (EReference)configPropertyCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLocalPropertyCS() {
        return localPropertyCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLocalPropertyCS_TypeCS() {
        return (EReference)localPropertyCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLocalPropertyCS_OclExpressionCS() {
        return (EReference)localPropertyCSEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMappingDeclarationCS() {
        return mappingDeclarationCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingDeclarationCS_SimpleNameCS() {
        return (EReference)mappingDeclarationCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingDeclarationCS_ContextType() {
        return (EReference)mappingDeclarationCSEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingDeclarationCS_ContextTypeAndName() {
        return (EReference)mappingDeclarationCSEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingDeclarationCS_Parameters() {
        return (EReference)mappingDeclarationCSEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingDeclarationCS_ReturnType() {
        return (EReference)mappingDeclarationCSEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMappingDeclarationCS_BlackBox() {
        return (EAttribute)mappingDeclarationCSEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMappingDeclarationCS_DirectionKindCS() {
        return (EReference)mappingDeclarationCSEClass.getEStructuralFeatures().get(6);
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getParameterDeclarationCS() {
        return parameterDeclarationCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getParameterDeclarationCS_SimpleNameCS() {
        return (EReference)parameterDeclarationCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getParameterDeclarationCS_TypeSpecCS() {
        return (EReference)parameterDeclarationCSEClass.getEStructuralFeatures().get(1);
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParameterDeclarationCS_DirectionKind() {
        return (EAttribute)parameterDeclarationCSEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMappingMethodCS() {
        return mappingMethodCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingMethodCS_MappingDeclarationCS() {
        return (EReference)mappingMethodCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMappingRuleCS() {
        return mappingRuleCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingRuleCS_Guard() {
        return (EReference)mappingRuleCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingRuleCS_MappingInitCS() {
        return (EReference)mappingRuleCSEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingRuleCS_MappingBodyCS() {
        return (EReference)mappingRuleCSEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingRuleCS_MappingEndCS() {
        return (EReference)mappingRuleCSEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMappingQueryCS() {
        return mappingQueryCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingQueryCS_Expressions() {
        return (EReference)mappingQueryCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMappingSectionCS() {
        return mappingSectionCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingSectionCS_Statements() {
        return (EReference)mappingSectionCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingSectionCS_MappingRuleCS() {
        return (EReference)mappingSectionCSEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMappingInitCS() {
        return mappingInitCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMappingEndCS() {
        return mappingEndCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStatementCS() {
        return statementCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAssignStatementCS() {
        return assignStatementCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAssignStatementCS_LValueCS() {
        return (EReference)assignStatementCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAssignStatementCS_OclExpressionCS() {
        return (EReference)assignStatementCSEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAssignStatementCS_Incremental() {
        return (EAttribute)assignStatementCSEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExpressionStatementCS() {
        return expressionStatementCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExpressionStatementCS_OclExpressionCS() {
        return (EReference)expressionStatementCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getVariableInitializationCS() {
        return variableInitializationCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getVariableInitializationCS_OclExpressionCS() {
        return (EReference)variableInitializationCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getVariableInitializationCS_SimpleNameCS() {
        return (EReference)variableInitializationCSEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getVariableInitializationCS_TypeCS() {
        return (EReference)variableInitializationCSEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMappingBodyCS() {
        return mappingBodyCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappingBodyCS_OutExpCS() {
        return (EReference)mappingBodyCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMappingBodyCS_Short() {
        return (EAttribute)mappingBodyCSEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOutExpCS() {
        return outExpCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOutExpCS_SimpleNameCS() {
        return (EReference)outExpCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getOutExpCS_TypeSpecCS() {
        return (EReference)outExpCSEClass.getEStructuralFeatures().get(1);
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOutExpCS_Expressions() {
        return (EReference)outExpCSEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPatternPropertyExpCS() {
        return patternPropertyExpCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPatternPropertyExpCS_SimpleNameCS() {
        return (EReference)patternPropertyExpCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPatternPropertyExpCS_OclExpressionCS() {
        return (EReference)patternPropertyExpCSEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPatternPropertyExpCS_Incremental() {
        return (EAttribute)patternPropertyExpCSEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMappingCallExpCS() {
        return mappingCallExpCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMappingCallExpCS_Strict() {
        return (EAttribute)mappingCallExpCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWhileExpCS() {
        return whileExpCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getWhileExpCS_Body() {
        return (EReference)whileExpCSEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWhileExpCS_Condition() {
        return (EReference)whileExpCSEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWhileExpCS_Result() {
        return (EReference)whileExpCSEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getWhileExpCS_ResultVar() {
        return (EReference)whileExpCSEClass.getEStructuralFeatures().get(3);
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSwitchExpCS() {
        return switchExpCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSwitchExpCS_AlternativePart() {
        return (EReference)switchExpCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSwitchExpCS_ElsePart() {
        return (EReference)switchExpCSEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSwitchAltExpCS() {
        return switchAltExpCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSwitchAltExpCS_Condition() {
        return (EReference)switchAltExpCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSwitchAltExpCS_Body() {
        return (EReference)switchAltExpCSEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getBlockExpCS() {
        return blockExpCSEClass;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getBlockExpCS_BodyExpressions() {
        return (EReference)blockExpCSEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDirectionKindCS() {
        return directionKindCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDirectionKindCS_DirectionKind() {
        return (EAttribute)directionKindCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getElementWithBody() {
        return elementWithBodyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getElementWithBody_BodyStartLocation() {
        return (EAttribute)elementWithBodyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getElementWithBody_BodyEndLocation() {
        return (EAttribute)elementWithBodyEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getResolveExpCS() {
        return resolveExpCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getResolveExpCS_One() {
        return (EAttribute)resolveExpCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getResolveExpCS_IsInverse() {
        return (EAttribute)resolveExpCSEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getResolveExpCS_IsDeferred() {
        return (EAttribute)resolveExpCSEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getResolveExpCS_Target() {
        return (EReference)resolveExpCSEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getResolveExpCS_Condition() {
        return (EReference)resolveExpCSEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getResolveInExpCS() {
        return resolveInExpCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getResolveInExpCS_InMappingType() {
        return (EReference)resolveInExpCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getResolveInExpCS_InMappingName() {
        return (EAttribute)resolveInExpCSEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getModelTypeCS() {
        return modelTypeCSEClass;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getModelTypeCS_IdentifierCS() {
        return (EReference)modelTypeCSEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getModelTypeCS_ComplianceKindCS() {
        return (EReference)modelTypeCSEClass.getEStructuralFeatures().get(1);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getModelTypeCS_PackageRefs() {
        return (EReference)modelTypeCSEClass.getEStructuralFeatures().get(2);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getModelTypeCS_WhereStatements() {
        return (EReference)modelTypeCSEClass.getEStructuralFeatures().get(3);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPackageRefCS() {
        return packageRefCSEClass;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPackageRefCS_PathNameCS() {
        return (EReference)packageRefCSEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPackageRefCS_UriCS() {
        return (EReference)packageRefCSEClass.getEStructuralFeatures().get(1);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTransformationHeaderCS() {
        return transformationHeaderCSEClass;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTransformationHeaderCS_Qualifiers() {
        return (EReference)transformationHeaderCSEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTransformationHeaderCS_PathNameCS() {
        return (EReference)transformationHeaderCSEClass.getEStructuralFeatures().get(1);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTransformationHeaderCS_Parameters() {
        return (EReference)transformationHeaderCSEClass.getEStructuralFeatures().get(2);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTransformationHeaderCS_ModuleUsages() {
        return (EReference)transformationHeaderCSEClass.getEStructuralFeatures().get(3);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTransformationHeaderCS_TransformationRefineCS() {
        return (EReference)transformationHeaderCSEClass.getEStructuralFeatures().get(4);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getModuleKindCS() {
        return moduleKindCSEClass;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getModuleKindCS_ModuleKind() {
        return (EAttribute)moduleKindCSEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getModuleRefCS() {
        return moduleRefCSEClass;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getModuleRefCS_PathNameCS() {
        return (EReference)moduleRefCSEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getModuleRefCS_Parameters() {
        return (EReference)moduleRefCSEClass.getEStructuralFeatures().get(1);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getModuleUsageCS() {
        return moduleUsageCSEClass;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getModuleUsageCS_ImportKind() {
        return (EAttribute)moduleUsageCSEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getModuleUsageCS_ModuleKindCS() {
        return (EReference)moduleUsageCSEClass.getEStructuralFeatures().get(1);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getModuleUsageCS_ModuleRefs() {
        return (EReference)moduleUsageCSEClass.getEStructuralFeatures().get(2);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTransformationRefineCS() {
        return transformationRefineCSEClass;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTransformationRefineCS_ModuleRefCS() {
        return (EReference)transformationRefineCSEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTransformationRefineCS_SimpleNameCS() {
        return (EReference)transformationRefineCSEClass.getEStructuralFeatures().get(1);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTypeSpecCS() {
        return typeSpecCSEClass;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTypeSpecCS_TypeCS() {
        return (EReference)typeSpecCSEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTypeSpecCS_SimpleNameCS() {
        return (EReference)typeSpecCSEClass.getEStructuralFeatures().get(1);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLogExpCS() {
        return logExpCSEClass;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getLogExpCS_Condition() {
        return (EReference)logExpCSEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getAssertExpCS() {
        return assertExpCSEClass;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAssertExpCS_Assertion() {
        return (EReference)assertExpCSEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAssertExpCS_Log() {
        return (EReference)assertExpCSEClass.getEStructuralFeatures().get(1);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAssertExpCS_Severity() {
        return (EReference)assertExpCSEClass.getEStructuralFeatures().get(2);
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getImperativeLoopExpCS() {
        return imperativeLoopExpCSEClass;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getImperativeLoopExpCS_Condition() {
        return (EReference)imperativeLoopExpCSEClass.getEStructuralFeatures().get(0);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getImperativeIterateExpCS() {
        return imperativeIterateExpCSEClass;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getImperativeIterateExpCS_Target() {
        return (EReference)imperativeIterateExpCSEClass.getEStructuralFeatures().get(0);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getDirectionKindEnum() {
        return directionKindEnumEEnum;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getModuleKindEnum() {
        return moduleKindEnumEEnum;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getImportKindEnum() {
        return importKindEnumEEnum;
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CSTFactory getCSTFactory() {
        return (CSTFactory)getEFactoryInstance();
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
        mappingModuleCSEClass = createEClass(MAPPING_MODULE_CS);
        createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__HEADER_CS);
        createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__IMPORTS);
        createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__METAMODELS);
        createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__RENAMINGS);
        createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__PROPERTIES);
        createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__METHODS);

        libraryCSEClass = createEClass(LIBRARY_CS);

        importCSEClass = createEClass(IMPORT_CS);
        createEReference(importCSEClass, IMPORT_CS__PATH_NAME_CS);

        moduleImportCSEClass = createEClass(MODULE_IMPORT_CS);

        libraryImportCSEClass = createEClass(LIBRARY_IMPORT_CS);

        renameCSEClass = createEClass(RENAME_CS);
        createEReference(renameCSEClass, RENAME_CS__TYPE_CS);
        createEReference(renameCSEClass, RENAME_CS__SIMPLE_NAME_CS);
        createEReference(renameCSEClass, RENAME_CS__ORIGINAL_NAME);

        modulePropertyCSEClass = createEClass(MODULE_PROPERTY_CS);
        createEReference(modulePropertyCSEClass, MODULE_PROPERTY_CS__SIMPLE_NAME_CS);

        configPropertyCSEClass = createEClass(CONFIG_PROPERTY_CS);
        createEReference(configPropertyCSEClass, CONFIG_PROPERTY_CS__TYPE_CS);

        localPropertyCSEClass = createEClass(LOCAL_PROPERTY_CS);
        createEReference(localPropertyCSEClass, LOCAL_PROPERTY_CS__TYPE_CS);
        createEReference(localPropertyCSEClass, LOCAL_PROPERTY_CS__OCL_EXPRESSION_CS);

        mappingDeclarationCSEClass = createEClass(MAPPING_DECLARATION_CS);
        createEReference(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__SIMPLE_NAME_CS);
        createEReference(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__CONTEXT_TYPE);
        createEReference(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__CONTEXT_TYPE_AND_NAME);
        createEReference(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__PARAMETERS);
        createEReference(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__RETURN_TYPE);
        createEAttribute(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__BLACK_BOX);
        createEReference(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__DIRECTION_KIND_CS);

        parameterDeclarationCSEClass = createEClass(PARAMETER_DECLARATION_CS);
        createEReference(parameterDeclarationCSEClass, PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS);
        createEReference(parameterDeclarationCSEClass, PARAMETER_DECLARATION_CS__TYPE_SPEC_CS);
        createEAttribute(parameterDeclarationCSEClass, PARAMETER_DECLARATION_CS__DIRECTION_KIND);

        mappingMethodCSEClass = createEClass(MAPPING_METHOD_CS);
        createEReference(mappingMethodCSEClass, MAPPING_METHOD_CS__MAPPING_DECLARATION_CS);

        mappingRuleCSEClass = createEClass(MAPPING_RULE_CS);
        createEReference(mappingRuleCSEClass, MAPPING_RULE_CS__GUARD);
        createEReference(mappingRuleCSEClass, MAPPING_RULE_CS__MAPPING_INIT_CS);
        createEReference(mappingRuleCSEClass, MAPPING_RULE_CS__MAPPING_BODY_CS);
        createEReference(mappingRuleCSEClass, MAPPING_RULE_CS__MAPPING_END_CS);

        mappingQueryCSEClass = createEClass(MAPPING_QUERY_CS);
        createEReference(mappingQueryCSEClass, MAPPING_QUERY_CS__EXPRESSIONS);

        mappingSectionCSEClass = createEClass(MAPPING_SECTION_CS);
        createEReference(mappingSectionCSEClass, MAPPING_SECTION_CS__STATEMENTS);
        createEReference(mappingSectionCSEClass, MAPPING_SECTION_CS__MAPPING_RULE_CS);

        mappingInitCSEClass = createEClass(MAPPING_INIT_CS);

        mappingEndCSEClass = createEClass(MAPPING_END_CS);

        statementCSEClass = createEClass(STATEMENT_CS);

        assignStatementCSEClass = createEClass(ASSIGN_STATEMENT_CS);
        createEReference(assignStatementCSEClass, ASSIGN_STATEMENT_CS__LVALUE_CS);
        createEReference(assignStatementCSEClass, ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS);
        createEAttribute(assignStatementCSEClass, ASSIGN_STATEMENT_CS__INCREMENTAL);

        expressionStatementCSEClass = createEClass(EXPRESSION_STATEMENT_CS);
        createEReference(expressionStatementCSEClass, EXPRESSION_STATEMENT_CS__OCL_EXPRESSION_CS);

        variableInitializationCSEClass = createEClass(VARIABLE_INITIALIZATION_CS);
        createEReference(variableInitializationCSEClass, VARIABLE_INITIALIZATION_CS__OCL_EXPRESSION_CS);
        createEReference(variableInitializationCSEClass, VARIABLE_INITIALIZATION_CS__SIMPLE_NAME_CS);
        createEReference(variableInitializationCSEClass, VARIABLE_INITIALIZATION_CS__TYPE_CS);

        mappingBodyCSEClass = createEClass(MAPPING_BODY_CS);
        createEReference(mappingBodyCSEClass, MAPPING_BODY_CS__OUT_EXP_CS);
        createEAttribute(mappingBodyCSEClass, MAPPING_BODY_CS__SHORT);

        outExpCSEClass = createEClass(OUT_EXP_CS);
        createEReference(outExpCSEClass, OUT_EXP_CS__SIMPLE_NAME_CS);
        createEReference(outExpCSEClass, OUT_EXP_CS__TYPE_SPEC_CS);
        createEReference(outExpCSEClass, OUT_EXP_CS__EXPRESSIONS);

        patternPropertyExpCSEClass = createEClass(PATTERN_PROPERTY_EXP_CS);
        createEReference(patternPropertyExpCSEClass, PATTERN_PROPERTY_EXP_CS__SIMPLE_NAME_CS);
        createEReference(patternPropertyExpCSEClass, PATTERN_PROPERTY_EXP_CS__OCL_EXPRESSION_CS);
        createEAttribute(patternPropertyExpCSEClass, PATTERN_PROPERTY_EXP_CS__INCREMENTAL);

        mappingCallExpCSEClass = createEClass(MAPPING_CALL_EXP_CS);
        createEAttribute(mappingCallExpCSEClass, MAPPING_CALL_EXP_CS__STRICT);

        whileExpCSEClass = createEClass(WHILE_EXP_CS);
        createEReference(whileExpCSEClass, WHILE_EXP_CS__BODY);
        createEReference(whileExpCSEClass, WHILE_EXP_CS__CONDITION);
        createEReference(whileExpCSEClass, WHILE_EXP_CS__RESULT);
        createEReference(whileExpCSEClass, WHILE_EXP_CS__RESULT_VAR);

        switchExpCSEClass = createEClass(SWITCH_EXP_CS);
        createEReference(switchExpCSEClass, SWITCH_EXP_CS__ALTERNATIVE_PART);
        createEReference(switchExpCSEClass, SWITCH_EXP_CS__ELSE_PART);

        switchAltExpCSEClass = createEClass(SWITCH_ALT_EXP_CS);
        createEReference(switchAltExpCSEClass, SWITCH_ALT_EXP_CS__CONDITION);
        createEReference(switchAltExpCSEClass, SWITCH_ALT_EXP_CS__BODY);

        blockExpCSEClass = createEClass(BLOCK_EXP_CS);
        createEReference(blockExpCSEClass, BLOCK_EXP_CS__BODY_EXPRESSIONS);

        directionKindCSEClass = createEClass(DIRECTION_KIND_CS);
        createEAttribute(directionKindCSEClass, DIRECTION_KIND_CS__DIRECTION_KIND);

        elementWithBodyEClass = createEClass(ELEMENT_WITH_BODY);
        createEAttribute(elementWithBodyEClass, ELEMENT_WITH_BODY__BODY_START_LOCATION);
        createEAttribute(elementWithBodyEClass, ELEMENT_WITH_BODY__BODY_END_LOCATION);

        resolveExpCSEClass = createEClass(RESOLVE_EXP_CS);
        createEAttribute(resolveExpCSEClass, RESOLVE_EXP_CS__ONE);
        createEAttribute(resolveExpCSEClass, RESOLVE_EXP_CS__IS_INVERSE);
        createEAttribute(resolveExpCSEClass, RESOLVE_EXP_CS__IS_DEFERRED);
        createEReference(resolveExpCSEClass, RESOLVE_EXP_CS__TARGET);
        createEReference(resolveExpCSEClass, RESOLVE_EXP_CS__CONDITION);

        resolveInExpCSEClass = createEClass(RESOLVE_IN_EXP_CS);
        createEReference(resolveInExpCSEClass, RESOLVE_IN_EXP_CS__IN_MAPPING_TYPE);
        createEAttribute(resolveInExpCSEClass, RESOLVE_IN_EXP_CS__IN_MAPPING_NAME);

        modelTypeCSEClass = createEClass(MODEL_TYPE_CS);
        createEReference(modelTypeCSEClass, MODEL_TYPE_CS__IDENTIFIER_CS);
        createEReference(modelTypeCSEClass, MODEL_TYPE_CS__COMPLIANCE_KIND_CS);
        createEReference(modelTypeCSEClass, MODEL_TYPE_CS__PACKAGE_REFS);
        createEReference(modelTypeCSEClass, MODEL_TYPE_CS__WHERE_STATEMENTS);

        packageRefCSEClass = createEClass(PACKAGE_REF_CS);
        createEReference(packageRefCSEClass, PACKAGE_REF_CS__PATH_NAME_CS);
        createEReference(packageRefCSEClass, PACKAGE_REF_CS__URI_CS);

        transformationHeaderCSEClass = createEClass(TRANSFORMATION_HEADER_CS);
        createEReference(transformationHeaderCSEClass, TRANSFORMATION_HEADER_CS__QUALIFIERS);
        createEReference(transformationHeaderCSEClass, TRANSFORMATION_HEADER_CS__PATH_NAME_CS);
        createEReference(transformationHeaderCSEClass, TRANSFORMATION_HEADER_CS__PARAMETERS);
        createEReference(transformationHeaderCSEClass, TRANSFORMATION_HEADER_CS__MODULE_USAGES);
        createEReference(transformationHeaderCSEClass, TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS);

        moduleKindCSEClass = createEClass(MODULE_KIND_CS);
        createEAttribute(moduleKindCSEClass, MODULE_KIND_CS__MODULE_KIND);

        moduleRefCSEClass = createEClass(MODULE_REF_CS);
        createEReference(moduleRefCSEClass, MODULE_REF_CS__PATH_NAME_CS);
        createEReference(moduleRefCSEClass, MODULE_REF_CS__PARAMETERS);

        moduleUsageCSEClass = createEClass(MODULE_USAGE_CS);
        createEAttribute(moduleUsageCSEClass, MODULE_USAGE_CS__IMPORT_KIND);
        createEReference(moduleUsageCSEClass, MODULE_USAGE_CS__MODULE_KIND_CS);
        createEReference(moduleUsageCSEClass, MODULE_USAGE_CS__MODULE_REFS);

        transformationRefineCSEClass = createEClass(TRANSFORMATION_REFINE_CS);
        createEReference(transformationRefineCSEClass, TRANSFORMATION_REFINE_CS__MODULE_REF_CS);
        createEReference(transformationRefineCSEClass, TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS);

        typeSpecCSEClass = createEClass(TYPE_SPEC_CS);
        createEReference(typeSpecCSEClass, TYPE_SPEC_CS__TYPE_CS);
        createEReference(typeSpecCSEClass, TYPE_SPEC_CS__SIMPLE_NAME_CS);

        logExpCSEClass = createEClass(LOG_EXP_CS);
        createEReference(logExpCSEClass, LOG_EXP_CS__CONDITION);

        assertExpCSEClass = createEClass(ASSERT_EXP_CS);
        createEReference(assertExpCSEClass, ASSERT_EXP_CS__ASSERTION);
        createEReference(assertExpCSEClass, ASSERT_EXP_CS__LOG);
        createEReference(assertExpCSEClass, ASSERT_EXP_CS__SEVERITY);

        imperativeLoopExpCSEClass = createEClass(IMPERATIVE_LOOP_EXP_CS);
        createEReference(imperativeLoopExpCSEClass, IMPERATIVE_LOOP_EXP_CS__CONDITION);

        imperativeIterateExpCSEClass = createEClass(IMPERATIVE_ITERATE_EXP_CS);
        createEReference(imperativeIterateExpCSEClass, IMPERATIVE_ITERATE_EXP_CS__TARGET);

        // Create enums
        directionKindEnumEEnum = createEEnum(DIRECTION_KIND_ENUM);
        moduleKindEnumEEnum = createEEnum(MODULE_KIND_ENUM);
        importKindEnumEEnum = createEEnum(IMPORT_KIND_ENUM);
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
        TempPackage theTempPackage = (TempPackage)EPackage.Registry.INSTANCE.getEPackage(TempPackage.eNS_URI);
        org.eclipse.ocl.cst.CSTPackage theCSTPackage_1 = (org.eclipse.ocl.cst.CSTPackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.ocl.cst.CSTPackage.eNS_URI);

        // Add subpackages
        getESubpackages().add(theTempPackage);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        mappingModuleCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
        libraryCSEClass.getESuperTypes().add(this.getMappingModuleCS());
        importCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
        moduleImportCSEClass.getESuperTypes().add(this.getImportCS());
        libraryImportCSEClass.getESuperTypes().add(this.getImportCS());
        renameCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
        modulePropertyCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
        configPropertyCSEClass.getESuperTypes().add(this.getModulePropertyCS());
        localPropertyCSEClass.getESuperTypes().add(this.getModulePropertyCS());
        mappingDeclarationCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
        parameterDeclarationCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
        mappingMethodCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
        mappingRuleCSEClass.getESuperTypes().add(this.getMappingMethodCS());
        mappingQueryCSEClass.getESuperTypes().add(this.getMappingMethodCS());
        mappingSectionCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
        mappingSectionCSEClass.getESuperTypes().add(this.getElementWithBody());
        mappingInitCSEClass.getESuperTypes().add(this.getMappingSectionCS());
        mappingEndCSEClass.getESuperTypes().add(this.getMappingSectionCS());
        statementCSEClass.getESuperTypes().add(theCSTPackage_1.getOCLExpressionCS());
        assignStatementCSEClass.getESuperTypes().add(this.getStatementCS());
        expressionStatementCSEClass.getESuperTypes().add(this.getStatementCS());
        variableInitializationCSEClass.getESuperTypes().add(this.getStatementCS());
        mappingBodyCSEClass.getESuperTypes().add(theCSTPackage_1.getOCLExpressionCS());
        outExpCSEClass.getESuperTypes().add(theCSTPackage_1.getOCLExpressionCS());
        outExpCSEClass.getESuperTypes().add(this.getElementWithBody());
        patternPropertyExpCSEClass.getESuperTypes().add(theCSTPackage_1.getOCLExpressionCS());
        mappingCallExpCSEClass.getESuperTypes().add(theCSTPackage_1.getOperationCallExpCS());
        whileExpCSEClass.getESuperTypes().add(theCSTPackage_1.getOCLExpressionCS());
        switchExpCSEClass.getESuperTypes().add(this.getStatementCS());
        switchAltExpCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
        blockExpCSEClass.getESuperTypes().add(theCSTPackage_1.getOCLExpressionCS());
        directionKindCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
        resolveExpCSEClass.getESuperTypes().add(theCSTPackage_1.getCallExpCS());
        resolveInExpCSEClass.getESuperTypes().add(this.getResolveExpCS());
        modelTypeCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
        modelTypeCSEClass.getESuperTypes().add(this.getElementWithBody());
        packageRefCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
        transformationHeaderCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
        moduleKindCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
        moduleRefCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
        moduleUsageCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
        transformationRefineCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
        typeSpecCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
        logExpCSEClass.getESuperTypes().add(theCSTPackage_1.getOperationCallExpCS());
        assertExpCSEClass.getESuperTypes().add(theCSTPackage_1.getOCLExpressionCS());
        imperativeLoopExpCSEClass.getESuperTypes().add(theCSTPackage_1.getLoopExpCS());
        imperativeLoopExpCSEClass.getESuperTypes().add(this.getStatementCS());
        imperativeIterateExpCSEClass.getESuperTypes().add(this.getImperativeLoopExpCS());

        // Initialize classes and features; add operations and parameters
        initEClass(mappingModuleCSEClass, MappingModuleCS.class, "MappingModuleCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getMappingModuleCS_HeaderCS(), this.getTransformationHeaderCS(), null, "headerCS", null, 1, 1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMappingModuleCS_Imports(), this.getImportCS(), null, "imports", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMappingModuleCS_Metamodels(), this.getModelTypeCS(), null, "metamodels", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMappingModuleCS_Renamings(), this.getRenameCS(), null, "renamings", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMappingModuleCS_Properties(), this.getModulePropertyCS(), null, "properties", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMappingModuleCS_Methods(), this.getMappingMethodCS(), null, "methods", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(libraryCSEClass, LibraryCS.class, "LibraryCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(importCSEClass, ImportCS.class, "ImportCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getImportCS_PathNameCS(), theCSTPackage_1.getPathNameCS(), null, "pathNameCS", null, 0, 1, ImportCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(moduleImportCSEClass, ModuleImportCS.class, "ModuleImportCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(libraryImportCSEClass, LibraryImportCS.class, "LibraryImportCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(renameCSEClass, RenameCS.class, "RenameCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getRenameCS_TypeCS(), theCSTPackage_1.getTypeCS(), null, "typeCS", null, 0, 1, RenameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getRenameCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, RenameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getRenameCS_OriginalName(), theCSTPackage_1.getStringLiteralExpCS(), null, "originalName", null, 0, 1, RenameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(modulePropertyCSEClass, ModulePropertyCS.class, "ModulePropertyCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getModulePropertyCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, ModulePropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(configPropertyCSEClass, ConfigPropertyCS.class, "ConfigPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getConfigPropertyCS_TypeCS(), theCSTPackage_1.getTypeCS(), null, "typeCS", null, 0, 1, ConfigPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(localPropertyCSEClass, LocalPropertyCS.class, "LocalPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getLocalPropertyCS_TypeCS(), theCSTPackage_1.getTypeCS(), null, "typeCS", null, 0, 1, LocalPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getLocalPropertyCS_OclExpressionCS(), theCSTPackage_1.getOCLExpressionCS(), null, "oclExpressionCS", null, 0, 1, LocalPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(mappingDeclarationCSEClass, MappingDeclarationCS.class, "MappingDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getMappingDeclarationCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMappingDeclarationCS_ContextType(), theCSTPackage_1.getTypeCS(), null, "contextType", null, 0, 1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMappingDeclarationCS_ContextTypeAndName(), theCSTPackage_1.getTypeCS(), null, "contextTypeAndName", null, 0, 1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMappingDeclarationCS_Parameters(), this.getParameterDeclarationCS(), null, "parameters", null, 0, -1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMappingDeclarationCS_ReturnType(), this.getTypeSpecCS(), null, "returnType", null, 0, 1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getMappingDeclarationCS_BlackBox(), ecorePackage.getEBoolean(), "blackBox", null, 0, 1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMappingDeclarationCS_DirectionKindCS(), this.getDirectionKindCS(), null, "directionKindCS", null, 0, 1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(parameterDeclarationCSEClass, ParameterDeclarationCS.class, "ParameterDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getParameterDeclarationCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, ParameterDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getParameterDeclarationCS_TypeSpecCS(), this.getTypeSpecCS(), null, "typeSpecCS", null, 0, 1, ParameterDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getParameterDeclarationCS_DirectionKind(), this.getDirectionKindEnum(), "directionKind", null, 0, 1, ParameterDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(mappingMethodCSEClass, MappingMethodCS.class, "MappingMethodCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getMappingMethodCS_MappingDeclarationCS(), this.getMappingDeclarationCS(), null, "mappingDeclarationCS", null, 0, 1, MappingMethodCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(mappingRuleCSEClass, MappingRuleCS.class, "MappingRuleCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getMappingRuleCS_Guard(), theCSTPackage_1.getOCLExpressionCS(), null, "guard", null, 0, 1, MappingRuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMappingRuleCS_MappingInitCS(), this.getMappingInitCS(), null, "mappingInitCS", null, 0, 1, MappingRuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMappingRuleCS_MappingBodyCS(), this.getMappingBodyCS(), null, "mappingBodyCS", null, 0, 1, MappingRuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMappingRuleCS_MappingEndCS(), this.getMappingEndCS(), null, "mappingEndCS", null, 0, 1, MappingRuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(mappingQueryCSEClass, MappingQueryCS.class, "MappingQueryCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getMappingQueryCS_Expressions(), theCSTPackage_1.getOCLExpressionCS(), null, "expressions", null, 0, -1, MappingQueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(mappingSectionCSEClass, MappingSectionCS.class, "MappingSectionCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getMappingSectionCS_Statements(), this.getStatementCS(), null, "statements", null, 0, -1, MappingSectionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMappingSectionCS_MappingRuleCS(), this.getMappingRuleCS(), null, "mappingRuleCS", null, 0, 1, MappingSectionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(mappingInitCSEClass, MappingInitCS.class, "MappingInitCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(mappingEndCSEClass, MappingEndCS.class, "MappingEndCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(statementCSEClass, StatementCS.class, "StatementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(assignStatementCSEClass, AssignStatementCS.class, "AssignStatementCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getAssignStatementCS_LValueCS(), theCSTPackage_1.getOCLExpressionCS(), null, "lValueCS", null, 0, 1, AssignStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getAssignStatementCS_OclExpressionCS(), theCSTPackage_1.getOCLExpressionCS(), null, "oclExpressionCS", null, 0, 1, AssignStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getAssignStatementCS_Incremental(), ecorePackage.getEBoolean(), "incremental", null, 0, 1, AssignStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(expressionStatementCSEClass, ExpressionStatementCS.class, "ExpressionStatementCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getExpressionStatementCS_OclExpressionCS(), theCSTPackage_1.getOCLExpressionCS(), null, "oclExpressionCS", null, 0, 1, ExpressionStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(variableInitializationCSEClass, VariableInitializationCS.class, "VariableInitializationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getVariableInitializationCS_OclExpressionCS(), theCSTPackage_1.getOCLExpressionCS(), null, "oclExpressionCS", null, 0, 1, VariableInitializationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getVariableInitializationCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, VariableInitializationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getVariableInitializationCS_TypeCS(), theCSTPackage_1.getTypeCS(), null, "typeCS", null, 0, 1, VariableInitializationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(mappingBodyCSEClass, MappingBodyCS.class, "MappingBodyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getMappingBodyCS_OutExpCS(), this.getOutExpCS(), null, "outExpCS", null, 0, 1, MappingBodyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getMappingBodyCS_Short(), ecorePackage.getEBoolean(), "short", null, 0, 1, MappingBodyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(outExpCSEClass, OutExpCS.class, "OutExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getOutExpCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, OutExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getOutExpCS_TypeSpecCS(), this.getTypeSpecCS(), null, "typeSpecCS", null, 0, 1, OutExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getOutExpCS_Expressions(), theCSTPackage_1.getOCLExpressionCS(), null, "expressions", null, 0, -1, OutExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(patternPropertyExpCSEClass, PatternPropertyExpCS.class, "PatternPropertyExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getPatternPropertyExpCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, PatternPropertyExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPatternPropertyExpCS_OclExpressionCS(), theCSTPackage_1.getOCLExpressionCS(), null, "oclExpressionCS", null, 0, 1, PatternPropertyExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getPatternPropertyExpCS_Incremental(), ecorePackage.getEBoolean(), "incremental", null, 0, 1, PatternPropertyExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(mappingCallExpCSEClass, MappingCallExpCS.class, "MappingCallExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getMappingCallExpCS_Strict(), ecorePackage.getEBoolean(), "strict", null, 0, 1, MappingCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(whileExpCSEClass, WhileExpCS.class, "WhileExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getWhileExpCS_Body(), theCSTPackage_1.getOCLExpressionCS(), null, "body", null, 1, 1, WhileExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getWhileExpCS_Condition(), theCSTPackage_1.getOCLExpressionCS(), null, "condition", null, 0, 1, WhileExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getWhileExpCS_Result(), theCSTPackage_1.getOCLExpressionCS(), null, "result", null, 0, 1, WhileExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getWhileExpCS_ResultVar(), theCSTPackage_1.getVariableCS(), null, "resultVar", null, 0, 1, WhileExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(switchExpCSEClass, SwitchExpCS.class, "SwitchExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getSwitchExpCS_AlternativePart(), this.getSwitchAltExpCS(), null, "alternativePart", null, 1, -1, SwitchExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSwitchExpCS_ElsePart(), theCSTPackage_1.getOCLExpressionCS(), null, "elsePart", null, 0, 1, SwitchExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(switchAltExpCSEClass, SwitchAltExpCS.class, "SwitchAltExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getSwitchAltExpCS_Condition(), theCSTPackage_1.getOCLExpressionCS(), null, "condition", null, 1, 1, SwitchAltExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSwitchAltExpCS_Body(), theCSTPackage_1.getOCLExpressionCS(), null, "body", null, 1, 1, SwitchAltExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(blockExpCSEClass, BlockExpCS.class, "BlockExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getBlockExpCS_BodyExpressions(), theCSTPackage_1.getOCLExpressionCS(), null, "bodyExpressions", null, 0, -1, BlockExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(directionKindCSEClass, DirectionKindCS.class, "DirectionKindCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getDirectionKindCS_DirectionKind(), this.getDirectionKindEnum(), "directionKind", null, 0, 1, DirectionKindCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(elementWithBodyEClass, ElementWithBody.class, "ElementWithBody", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getElementWithBody_BodyStartLocation(), ecorePackage.getEInt(), "bodyStartLocation", "0", 0, 1, ElementWithBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getElementWithBody_BodyEndLocation(), ecorePackage.getEInt(), "bodyEndLocation", "0", 0, 1, ElementWithBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(resolveExpCSEClass, ResolveExpCS.class, "ResolveExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getResolveExpCS_One(), ecorePackage.getEBoolean(), "one", null, 1, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getResolveExpCS_IsInverse(), ecorePackage.getEBoolean(), "isInverse", null, 1, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getResolveExpCS_IsDeferred(), ecorePackage.getEBoolean(), "isDeferred", null, 1, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getResolveExpCS_Target(), theCSTPackage_1.getVariableCS(), null, "target", null, 0, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getResolveExpCS_Condition(), theCSTPackage_1.getOCLExpressionCS(), null, "condition", null, 0, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(resolveInExpCSEClass, ResolveInExpCS.class, "ResolveInExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getResolveInExpCS_InMappingType(), theCSTPackage_1.getTypeCS(), null, "inMappingType", null, 1, 1, ResolveInExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getResolveInExpCS_InMappingName(), ecorePackage.getEString(), "inMappingName", "", 1, 1, ResolveInExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(modelTypeCSEClass, ModelTypeCS.class, "ModelTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getModelTypeCS_IdentifierCS(), theCSTPackage_1.getSimpleNameCS(), null, "identifierCS", null, 1, 1, ModelTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getModelTypeCS_ComplianceKindCS(), theCSTPackage_1.getStringLiteralExpCS(), null, "complianceKindCS", null, 0, 1, ModelTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getModelTypeCS_PackageRefs(), this.getPackageRefCS(), null, "packageRefs", null, 1, -1, ModelTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getModelTypeCS_WhereStatements(), this.getStatementCS(), null, "whereStatements", null, 0, -1, ModelTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(packageRefCSEClass, PackageRefCS.class, "PackageRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getPackageRefCS_PathNameCS(), theCSTPackage_1.getPathNameCS(), null, "pathNameCS", null, 0, 1, PackageRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPackageRefCS_UriCS(), theCSTPackage_1.getStringLiteralExpCS(), null, "uriCS", null, 0, 1, PackageRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(transformationHeaderCSEClass, TransformationHeaderCS.class, "TransformationHeaderCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getTransformationHeaderCS_Qualifiers(), theCSTPackage_1.getStringLiteralExpCS(), null, "qualifiers", null, 0, -1, TransformationHeaderCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getTransformationHeaderCS_PathNameCS(), theCSTPackage_1.getPathNameCS(), null, "pathNameCS", null, 1, 1, TransformationHeaderCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getTransformationHeaderCS_Parameters(), this.getParameterDeclarationCS(), null, "parameters", null, 0, -1, TransformationHeaderCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getTransformationHeaderCS_ModuleUsages(), this.getModuleUsageCS(), null, "moduleUsages", null, 0, -1, TransformationHeaderCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getTransformationHeaderCS_TransformationRefineCS(), this.getTransformationRefineCS(), null, "transformationRefineCS", null, 0, 1, TransformationHeaderCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(moduleKindCSEClass, ModuleKindCS.class, "ModuleKindCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getModuleKindCS_ModuleKind(), this.getModuleKindEnum(), "moduleKind", null, 0, 1, ModuleKindCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(moduleRefCSEClass, ModuleRefCS.class, "ModuleRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getModuleRefCS_PathNameCS(), theCSTPackage_1.getPathNameCS(), null, "pathNameCS", null, 1, 1, ModuleRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getModuleRefCS_Parameters(), this.getParameterDeclarationCS(), null, "parameters", null, 0, -1, ModuleRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(moduleUsageCSEClass, ModuleUsageCS.class, "ModuleUsageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getModuleUsageCS_ImportKind(), this.getImportKindEnum(), "importKind", null, 0, 1, ModuleUsageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getModuleUsageCS_ModuleKindCS(), this.getModuleKindCS(), null, "moduleKindCS", null, 0, 1, ModuleUsageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getModuleUsageCS_ModuleRefs(), this.getModuleRefCS(), null, "moduleRefs", null, 1, -1, ModuleUsageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(transformationRefineCSEClass, TransformationRefineCS.class, "TransformationRefineCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getTransformationRefineCS_ModuleRefCS(), this.getModuleRefCS(), null, "moduleRefCS", null, 1, 1, TransformationRefineCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getTransformationRefineCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 1, 1, TransformationRefineCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeSpecCSEClass, TypeSpecCS.class, "TypeSpecCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getTypeSpecCS_TypeCS(), theCSTPackage_1.getTypeCS(), null, "typeCS", null, 1, 1, TypeSpecCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getTypeSpecCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, TypeSpecCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(logExpCSEClass, LogExpCS.class, "LogExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getLogExpCS_Condition(), theCSTPackage_1.getOCLExpressionCS(), null, "condition", null, 0, 1, LogExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(assertExpCSEClass, AssertExpCS.class, "AssertExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getAssertExpCS_Assertion(), theCSTPackage_1.getOCLExpressionCS(), null, "assertion", null, 1, 1, AssertExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getAssertExpCS_Log(), this.getLogExpCS(), null, "log", null, 0, 1, AssertExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getAssertExpCS_Severity(), theCSTPackage_1.getSimpleNameCS(), null, "severity", null, 0, 1, AssertExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(imperativeLoopExpCSEClass, ImperativeLoopExpCS.class, "ImperativeLoopExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getImperativeLoopExpCS_Condition(), theCSTPackage_1.getOCLExpressionCS(), null, "condition", null, 1, 1, ImperativeLoopExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(imperativeIterateExpCSEClass, ImperativeIterateExpCS.class, "ImperativeIterateExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getImperativeIterateExpCS_Target(), theCSTPackage_1.getVariableCS(), null, "target", null, 0, 1, ImperativeIterateExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum(directionKindEnumEEnum, DirectionKindEnum.class, "DirectionKindEnum"); //$NON-NLS-1$
        addEEnumLiteral(directionKindEnumEEnum, DirectionKindEnum.IN);
        addEEnumLiteral(directionKindEnumEEnum, DirectionKindEnum.OUT);
        addEEnumLiteral(directionKindEnumEEnum, DirectionKindEnum.INOUT);

        initEEnum(moduleKindEnumEEnum, ModuleKindEnum.class, "ModuleKindEnum"); //$NON-NLS-1$
        addEEnumLiteral(moduleKindEnumEEnum, ModuleKindEnum.TRANSFORMATION);
        addEEnumLiteral(moduleKindEnumEEnum, ModuleKindEnum.LIBRARY);

        initEEnum(importKindEnumEEnum, ImportKindEnum.class, "ImportKindEnum"); //$NON-NLS-1$
        addEEnumLiteral(importKindEnumEEnum, ImportKindEnum.EXTENSION);
        addEEnumLiteral(importKindEnumEEnum, ImportKindEnum.ACCESS);

        // Create resource
        createResource(eNS_URI);
    }

} //CSTPackageImpl
