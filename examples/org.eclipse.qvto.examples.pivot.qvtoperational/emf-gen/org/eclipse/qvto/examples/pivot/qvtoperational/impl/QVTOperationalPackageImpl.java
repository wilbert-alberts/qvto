/**
 * <copyright>
 * Copyright (c) 2013 Willink Transformations, University of York, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo (University of York) - Bug397429
 * </copyright>
 */
package org.eclipse.qvto.examples.pivot.qvtoperational.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.examples.pivot.PivotPackage;

import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage;

import org.eclipse.qvto.examples.pivot.qvtoperational.Constructor;
import org.eclipse.qvto.examples.pivot.qvtoperational.ConstructorBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty;
import org.eclipse.qvto.examples.pivot.qvtoperational.DirectionKind;
import org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelation;
import org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationDomain;
import org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationalTransformation;
import org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.Helper;
import org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeCallExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.ImportKind;
import org.eclipse.qvto.examples.pivot.qvtoperational.Library;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingCallExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelType;
import org.eclipse.qvto.examples.pivot.qvtoperational.Module;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport;
import org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalFactory;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.pivot.qvtoperational.ResolveExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.Tag;
import org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.QVTOperationalVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTOperationalPackageImpl extends EPackageImpl implements QVTOperationalPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constructorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constructorBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextualPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dummyRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dummyRelationDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dummyRelationalTransformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entryOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass helperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleImportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationalTransformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolveExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolveInExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qvtOperationalVisitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum directionKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum importKindEEnum = null;

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
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTOperationalPackageImpl() {
		super(eNS_URI, QVTOperationalFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link QVTOperationalPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTOperationalPackage init() {
		if (isInited) return (QVTOperationalPackage)EPackage.Registry.INSTANCE.getEPackage(QVTOperationalPackage.eNS_URI);

		// Obtain or create and register package
		QVTOperationalPackageImpl theQVTOperationalPackage = (QVTOperationalPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QVTOperationalPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QVTOperationalPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ImperativeOCLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTOperationalPackage.createPackageContents();

		// Initialize created meta-data
		theQVTOperationalPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQVTOperationalPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTOperationalPackage.eNS_URI, theQVTOperationalPackage);
		return theQVTOperationalPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstructor() {
		return constructorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConstructor__Accept__QVTOperationalVisitor() {
		return constructorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConstructor__Accept__Visitor() {
		return constructorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstructorBody() {
		return constructorBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConstructorBody__Accept__QVTOperationalVisitor() {
		return constructorBodyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConstructorBody__Accept__Visitor() {
		return constructorBodyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContextualProperty() {
		return contextualPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextualProperty_Context() {
		return (EReference)contextualPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextualProperty_InitExpression() {
		return (EReference)contextualPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextualProperty_Overridden() {
		return (EReference)contextualPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContextualProperty__Accept__QVTOperationalVisitor() {
		return contextualPropertyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContextualProperty__Accept__Visitor() {
		return contextualPropertyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDummyRelation() {
		return dummyRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDummyRelation__Accept__QVTOperationalVisitor() {
		return dummyRelationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDummyRelation__Accept__Visitor() {
		return dummyRelationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDummyRelationDomain() {
		return dummyRelationDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDummyRelationDomain__Accept__QVTOperationalVisitor() {
		return dummyRelationDomainEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDummyRelationDomain__Accept__Visitor() {
		return dummyRelationDomainEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDummyRelationalTransformation() {
		return dummyRelationalTransformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDummyRelationalTransformation__Accept__QVTOperationalVisitor() {
		return dummyRelationalTransformationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDummyRelationalTransformation__Accept__Visitor() {
		return dummyRelationalTransformationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntryOperation() {
		return entryOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntryOperation__Accept__QVTOperationalVisitor() {
		return entryOperationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntryOperation__Accept__Visitor() {
		return entryOperationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHelper() {
		return helperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHelper_IsQuery() {
		return (EAttribute)helperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getHelper__Accept__QVTOperationalVisitor() {
		return helperEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getHelper__Accept__Visitor() {
		return helperEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImperativeCallExp() {
		return imperativeCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImperativeCallExp_IsVirtual() {
		return (EAttribute)imperativeCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getImperativeCallExp__Accept__QVTOperationalVisitor() {
		return imperativeCallExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getImperativeCallExp__Accept__Visitor() {
		return imperativeCallExpEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImperativeOperation() {
		return imperativeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImperativeOperation_Body() {
		return (EReference)imperativeOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImperativeOperation_Context() {
		return (EReference)imperativeOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImperativeOperation_IsBlackbox() {
		return (EAttribute)imperativeOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImperativeOperation_Overridden() {
		return (EReference)imperativeOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImperativeOperation_Result() {
		return (EReference)imperativeOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getImperativeOperation__Accept__QVTOperationalVisitor() {
		return imperativeOperationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getImperativeOperation__Accept__Visitor() {
		return imperativeOperationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibrary() {
		return libraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLibrary__Accept__QVTOperationalVisitor() {
		return libraryEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLibrary__Accept__Visitor() {
		return libraryEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingBody() {
		return mappingBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingBody_EndSection() {
		return (EReference)mappingBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingBody_InitSection() {
		return (EReference)mappingBodyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingBody__Accept__QVTOperationalVisitor() {
		return mappingBodyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingBody__Accept__Visitor() {
		return mappingBodyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingCallExp() {
		return mappingCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingCallExp_IsStrict() {
		return (EAttribute)mappingCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingCallExp__Accept__QVTOperationalVisitor() {
		return mappingCallExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingCallExp__Accept__Visitor() {
		return mappingCallExpEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingOperation() {
		return mappingOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperation_Disjunct() {
		return (EReference)mappingOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperation_Inherited() {
		return (EReference)mappingOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperation_Merged() {
		return (EReference)mappingOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperation_RefinedRelation() {
		return (EReference)mappingOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperation_When() {
		return (EReference)mappingOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperation_Where() {
		return (EReference)mappingOperationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingOperation__Accept__QVTOperationalVisitor() {
		return mappingOperationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingOperation__Accept__Visitor() {
		return mappingOperationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingParameter() {
		return mappingParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingParameter_Extent() {
		return (EReference)mappingParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingParameter_ReferredDomain() {
		return (EReference)mappingParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingParameter__Accept__QVTOperationalVisitor() {
		return mappingParameterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingParameter__Accept__Visitor() {
		return mappingParameterEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelParameter() {
		return modelParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelParameter__Accept__QVTOperationalVisitor() {
		return modelParameterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelParameter__Accept__Visitor() {
		return modelParameterEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelType() {
		return modelTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelType_AdditionalCondition() {
		return (EReference)modelTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelType_ConformanceKind() {
		return (EAttribute)modelTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelType_Metamodel() {
		return (EReference)modelTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelType__Accept__QVTOperationalVisitor() {
		return modelTypeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelType__Accept__Visitor() {
		return modelTypeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModule() {
		return moduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_ConfigProperty() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_Entry() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModule_IsBlackbox() {
		return (EAttribute)moduleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_ModuleImport() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_OwnedTag() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_OwnedVariable() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_UsedModelType() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModule__Accept__QVTOperationalVisitor() {
		return moduleEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModule__Accept__Visitor() {
		return moduleEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleImport() {
		return moduleImportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleImport_Binding() {
		return (EReference)moduleImportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleImport_ImportedModule() {
		return (EReference)moduleImportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModuleImport_Kind() {
		return (EAttribute)moduleImportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleImport_Module() {
		return (EReference)moduleImportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModuleImport__Accept__QVTOperationalVisitor() {
		return moduleImportEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModuleImport__Accept__Visitor() {
		return moduleImportEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectExp() {
		return objectExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectExp_Body() {
		return (EReference)objectExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectExp_ReferredObject() {
		return (EReference)objectExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getObjectExp__Accept__QVTOperationalVisitor() {
		return objectExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getObjectExp__Accept__Visitor() {
		return objectExpEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationBody() {
		return operationBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationBody_Content() {
		return (EReference)operationBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationBody_Operation() {
		return (EReference)operationBodyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationBody_Variable() {
		return (EReference)operationBodyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationBody__Accept__QVTOperationalVisitor() {
		return operationBodyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationBody__Accept__Visitor() {
		return operationBodyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationalTransformation() {
		return operationalTransformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationalTransformation_IntermediateClass() {
		return (EReference)operationalTransformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationalTransformation_IntermediateProperty() {
		return (EReference)operationalTransformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationalTransformation_ModelParameter() {
		return (EReference)operationalTransformationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationalTransformation_Refined() {
		return (EReference)operationalTransformationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationalTransformation_Relation() {
		return (EReference)operationalTransformationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationalTransformation__Accept__QVTOperationalVisitor() {
		return operationalTransformationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationalTransformation__Accept__Visitor() {
		return operationalTransformationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolveExp() {
		return resolveExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveExp_Condition() {
		return (EReference)resolveExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolveExp_IsDeferred() {
		return (EAttribute)resolveExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolveExp_IsInverse() {
		return (EAttribute)resolveExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolveExp_One() {
		return (EAttribute)resolveExpEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveExp_Target() {
		return (EReference)resolveExpEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getResolveExp__Accept__QVTOperationalVisitor() {
		return resolveExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getResolveExp__Accept__Visitor() {
		return resolveExpEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolveInExp() {
		return resolveInExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveInExp_InMapping() {
		return (EReference)resolveInExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getResolveInExp__Accept__QVTOperationalVisitor() {
		return resolveInExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getResolveInExp__Accept__Visitor() {
		return resolveInExpEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVarParameter() {
		return varParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVarParameter_CtxOwner() {
		return (EReference)varParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVarParameter_Kind() {
		return (EAttribute)varParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVarParameter_ResOwner() {
		return (EReference)varParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getVarParameter__Accept__QVTOperationalVisitor() {
		return varParameterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getVarParameter__Accept__Visitor() {
		return varParameterEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTag() {
		return tagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTag_Name() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTag_Value() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTag_Elements() {
		return (EReference)tagEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTag__Accept__QVTOperationalVisitor() {
		return tagEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTag__Accept__Visitor() {
		return tagEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQVTOperationalVisitor() {
		return qvtOperationalVisitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDirectionKind() {
		return directionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getImportKind() {
		return importKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTOperationalFactory getQVTOperationalFactory() {
		return (QVTOperationalFactory)getEFactoryInstance();
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
		constructorEClass = createEClass(CONSTRUCTOR);
		createEOperation(constructorEClass, CONSTRUCTOR___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(constructorEClass, CONSTRUCTOR___ACCEPT__VISITOR);

		constructorBodyEClass = createEClass(CONSTRUCTOR_BODY);
		createEOperation(constructorBodyEClass, CONSTRUCTOR_BODY___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(constructorBodyEClass, CONSTRUCTOR_BODY___ACCEPT__VISITOR);

		contextualPropertyEClass = createEClass(CONTEXTUAL_PROPERTY);
		createEReference(contextualPropertyEClass, CONTEXTUAL_PROPERTY__CONTEXT);
		createEReference(contextualPropertyEClass, CONTEXTUAL_PROPERTY__INIT_EXPRESSION);
		createEReference(contextualPropertyEClass, CONTEXTUAL_PROPERTY__OVERRIDDEN);
		createEOperation(contextualPropertyEClass, CONTEXTUAL_PROPERTY___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(contextualPropertyEClass, CONTEXTUAL_PROPERTY___ACCEPT__VISITOR);

		dummyRelationEClass = createEClass(DUMMY_RELATION);
		createEOperation(dummyRelationEClass, DUMMY_RELATION___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(dummyRelationEClass, DUMMY_RELATION___ACCEPT__VISITOR);

		dummyRelationDomainEClass = createEClass(DUMMY_RELATION_DOMAIN);
		createEOperation(dummyRelationDomainEClass, DUMMY_RELATION_DOMAIN___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(dummyRelationDomainEClass, DUMMY_RELATION_DOMAIN___ACCEPT__VISITOR);

		dummyRelationalTransformationEClass = createEClass(DUMMY_RELATIONAL_TRANSFORMATION);
		createEOperation(dummyRelationalTransformationEClass, DUMMY_RELATIONAL_TRANSFORMATION___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(dummyRelationalTransformationEClass, DUMMY_RELATIONAL_TRANSFORMATION___ACCEPT__VISITOR);

		entryOperationEClass = createEClass(ENTRY_OPERATION);
		createEOperation(entryOperationEClass, ENTRY_OPERATION___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(entryOperationEClass, ENTRY_OPERATION___ACCEPT__VISITOR);

		helperEClass = createEClass(HELPER);
		createEAttribute(helperEClass, HELPER__IS_QUERY);
		createEOperation(helperEClass, HELPER___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(helperEClass, HELPER___ACCEPT__VISITOR);

		imperativeCallExpEClass = createEClass(IMPERATIVE_CALL_EXP);
		createEAttribute(imperativeCallExpEClass, IMPERATIVE_CALL_EXP__IS_VIRTUAL);
		createEOperation(imperativeCallExpEClass, IMPERATIVE_CALL_EXP___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(imperativeCallExpEClass, IMPERATIVE_CALL_EXP___ACCEPT__VISITOR);

		imperativeOperationEClass = createEClass(IMPERATIVE_OPERATION);
		createEReference(imperativeOperationEClass, IMPERATIVE_OPERATION__BODY);
		createEReference(imperativeOperationEClass, IMPERATIVE_OPERATION__CONTEXT);
		createEAttribute(imperativeOperationEClass, IMPERATIVE_OPERATION__IS_BLACKBOX);
		createEReference(imperativeOperationEClass, IMPERATIVE_OPERATION__OVERRIDDEN);
		createEReference(imperativeOperationEClass, IMPERATIVE_OPERATION__RESULT);
		createEOperation(imperativeOperationEClass, IMPERATIVE_OPERATION___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(imperativeOperationEClass, IMPERATIVE_OPERATION___ACCEPT__VISITOR);

		libraryEClass = createEClass(LIBRARY);
		createEOperation(libraryEClass, LIBRARY___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(libraryEClass, LIBRARY___ACCEPT__VISITOR);

		mappingBodyEClass = createEClass(MAPPING_BODY);
		createEReference(mappingBodyEClass, MAPPING_BODY__END_SECTION);
		createEReference(mappingBodyEClass, MAPPING_BODY__INIT_SECTION);
		createEOperation(mappingBodyEClass, MAPPING_BODY___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(mappingBodyEClass, MAPPING_BODY___ACCEPT__VISITOR);

		mappingCallExpEClass = createEClass(MAPPING_CALL_EXP);
		createEAttribute(mappingCallExpEClass, MAPPING_CALL_EXP__IS_STRICT);
		createEOperation(mappingCallExpEClass, MAPPING_CALL_EXP___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(mappingCallExpEClass, MAPPING_CALL_EXP___ACCEPT__VISITOR);

		mappingOperationEClass = createEClass(MAPPING_OPERATION);
		createEReference(mappingOperationEClass, MAPPING_OPERATION__DISJUNCT);
		createEReference(mappingOperationEClass, MAPPING_OPERATION__INHERITED);
		createEReference(mappingOperationEClass, MAPPING_OPERATION__MERGED);
		createEReference(mappingOperationEClass, MAPPING_OPERATION__REFINED_RELATION);
		createEReference(mappingOperationEClass, MAPPING_OPERATION__WHEN);
		createEReference(mappingOperationEClass, MAPPING_OPERATION__WHERE);
		createEOperation(mappingOperationEClass, MAPPING_OPERATION___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(mappingOperationEClass, MAPPING_OPERATION___ACCEPT__VISITOR);

		mappingParameterEClass = createEClass(MAPPING_PARAMETER);
		createEReference(mappingParameterEClass, MAPPING_PARAMETER__EXTENT);
		createEReference(mappingParameterEClass, MAPPING_PARAMETER__REFERRED_DOMAIN);
		createEOperation(mappingParameterEClass, MAPPING_PARAMETER___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(mappingParameterEClass, MAPPING_PARAMETER___ACCEPT__VISITOR);

		modelParameterEClass = createEClass(MODEL_PARAMETER);
		createEOperation(modelParameterEClass, MODEL_PARAMETER___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(modelParameterEClass, MODEL_PARAMETER___ACCEPT__VISITOR);

		modelTypeEClass = createEClass(MODEL_TYPE);
		createEReference(modelTypeEClass, MODEL_TYPE__ADDITIONAL_CONDITION);
		createEAttribute(modelTypeEClass, MODEL_TYPE__CONFORMANCE_KIND);
		createEReference(modelTypeEClass, MODEL_TYPE__METAMODEL);
		createEOperation(modelTypeEClass, MODEL_TYPE___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(modelTypeEClass, MODEL_TYPE___ACCEPT__VISITOR);

		moduleEClass = createEClass(MODULE);
		createEReference(moduleEClass, MODULE__CONFIG_PROPERTY);
		createEReference(moduleEClass, MODULE__ENTRY);
		createEAttribute(moduleEClass, MODULE__IS_BLACKBOX);
		createEReference(moduleEClass, MODULE__MODULE_IMPORT);
		createEReference(moduleEClass, MODULE__OWNED_TAG);
		createEReference(moduleEClass, MODULE__OWNED_VARIABLE);
		createEReference(moduleEClass, MODULE__USED_MODEL_TYPE);
		createEOperation(moduleEClass, MODULE___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(moduleEClass, MODULE___ACCEPT__VISITOR);

		moduleImportEClass = createEClass(MODULE_IMPORT);
		createEReference(moduleImportEClass, MODULE_IMPORT__BINDING);
		createEReference(moduleImportEClass, MODULE_IMPORT__IMPORTED_MODULE);
		createEAttribute(moduleImportEClass, MODULE_IMPORT__KIND);
		createEReference(moduleImportEClass, MODULE_IMPORT__MODULE);
		createEOperation(moduleImportEClass, MODULE_IMPORT___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(moduleImportEClass, MODULE_IMPORT___ACCEPT__VISITOR);

		objectExpEClass = createEClass(OBJECT_EXP);
		createEReference(objectExpEClass, OBJECT_EXP__BODY);
		createEReference(objectExpEClass, OBJECT_EXP__REFERRED_OBJECT);
		createEOperation(objectExpEClass, OBJECT_EXP___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(objectExpEClass, OBJECT_EXP___ACCEPT__VISITOR);

		operationBodyEClass = createEClass(OPERATION_BODY);
		createEReference(operationBodyEClass, OPERATION_BODY__CONTENT);
		createEReference(operationBodyEClass, OPERATION_BODY__OPERATION);
		createEReference(operationBodyEClass, OPERATION_BODY__VARIABLE);
		createEOperation(operationBodyEClass, OPERATION_BODY___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(operationBodyEClass, OPERATION_BODY___ACCEPT__VISITOR);

		operationalTransformationEClass = createEClass(OPERATIONAL_TRANSFORMATION);
		createEReference(operationalTransformationEClass, OPERATIONAL_TRANSFORMATION__INTERMEDIATE_CLASS);
		createEReference(operationalTransformationEClass, OPERATIONAL_TRANSFORMATION__INTERMEDIATE_PROPERTY);
		createEReference(operationalTransformationEClass, OPERATIONAL_TRANSFORMATION__MODEL_PARAMETER);
		createEReference(operationalTransformationEClass, OPERATIONAL_TRANSFORMATION__REFINED);
		createEReference(operationalTransformationEClass, OPERATIONAL_TRANSFORMATION__RELATION);
		createEOperation(operationalTransformationEClass, OPERATIONAL_TRANSFORMATION___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(operationalTransformationEClass, OPERATIONAL_TRANSFORMATION___ACCEPT__VISITOR);

		resolveExpEClass = createEClass(RESOLVE_EXP);
		createEReference(resolveExpEClass, RESOLVE_EXP__CONDITION);
		createEAttribute(resolveExpEClass, RESOLVE_EXP__IS_DEFERRED);
		createEAttribute(resolveExpEClass, RESOLVE_EXP__IS_INVERSE);
		createEAttribute(resolveExpEClass, RESOLVE_EXP__ONE);
		createEReference(resolveExpEClass, RESOLVE_EXP__TARGET);
		createEOperation(resolveExpEClass, RESOLVE_EXP___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(resolveExpEClass, RESOLVE_EXP___ACCEPT__VISITOR);

		resolveInExpEClass = createEClass(RESOLVE_IN_EXP);
		createEReference(resolveInExpEClass, RESOLVE_IN_EXP__IN_MAPPING);
		createEOperation(resolveInExpEClass, RESOLVE_IN_EXP___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(resolveInExpEClass, RESOLVE_IN_EXP___ACCEPT__VISITOR);

		varParameterEClass = createEClass(VAR_PARAMETER);
		createEReference(varParameterEClass, VAR_PARAMETER__CTX_OWNER);
		createEAttribute(varParameterEClass, VAR_PARAMETER__KIND);
		createEReference(varParameterEClass, VAR_PARAMETER__RES_OWNER);
		createEOperation(varParameterEClass, VAR_PARAMETER___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(varParameterEClass, VAR_PARAMETER___ACCEPT__VISITOR);

		tagEClass = createEClass(TAG);
		createEAttribute(tagEClass, TAG__NAME);
		createEAttribute(tagEClass, TAG__VALUE);
		createEReference(tagEClass, TAG__ELEMENTS);
		createEOperation(tagEClass, TAG___ACCEPT__QVTOPERATIONALVISITOR);
		createEOperation(tagEClass, TAG___ACCEPT__VISITOR);

		qvtOperationalVisitorEClass = createEClass(QVT_OPERATIONAL_VISITOR);

		// Create enums
		directionKindEEnum = createEEnum(DIRECTION_KIND);
		importKindEEnum = createEEnum(IMPORT_KIND);
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
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		ImperativeOCLPackage theImperativeOCLPackage = (ImperativeOCLPackage)EPackage.Registry.INSTANCE.getEPackage(ImperativeOCLPackage.eNS_URI);

		// Create type parameters
		ETypeParameter qvtOperationalVisitorEClass_R = addETypeParameter(qvtOperationalVisitorEClass, "R");

		// Set bounds for type parameters

		// Add supertypes to classes
		constructorEClass.getESuperTypes().add(this.getImperativeOperation());
		constructorBodyEClass.getESuperTypes().add(this.getOperationBody());
		contextualPropertyEClass.getESuperTypes().add(thePivotPackage.getProperty());
		dummyRelationEClass.getESuperTypes().add(thePivotPackage.getElement());
		dummyRelationDomainEClass.getESuperTypes().add(thePivotPackage.getElement());
		dummyRelationalTransformationEClass.getESuperTypes().add(thePivotPackage.getElement());
		entryOperationEClass.getESuperTypes().add(this.getImperativeOperation());
		helperEClass.getESuperTypes().add(this.getImperativeOperation());
		imperativeCallExpEClass.getESuperTypes().add(thePivotPackage.getOperationCallExp());
		imperativeCallExpEClass.getESuperTypes().add(theImperativeOCLPackage.getImperativeExpression());
		imperativeOperationEClass.getESuperTypes().add(thePivotPackage.getOperation());
		libraryEClass.getESuperTypes().add(this.getModule());
		mappingBodyEClass.getESuperTypes().add(this.getOperationBody());
		mappingCallExpEClass.getESuperTypes().add(this.getImperativeCallExp());
		mappingOperationEClass.getESuperTypes().add(this.getImperativeOperation());
		mappingParameterEClass.getESuperTypes().add(this.getVarParameter());
		modelParameterEClass.getESuperTypes().add(this.getVarParameter());
		modelTypeEClass.getESuperTypes().add(thePivotPackage.getClass_());
		moduleEClass.getESuperTypes().add(thePivotPackage.getClass_());
		moduleEClass.getESuperTypes().add(thePivotPackage.getPackage());
		moduleImportEClass.getESuperTypes().add(thePivotPackage.getElement());
		objectExpEClass.getESuperTypes().add(theImperativeOCLPackage.getInstantiationExp());
		operationBodyEClass.getESuperTypes().add(thePivotPackage.getElement());
		operationalTransformationEClass.getESuperTypes().add(this.getModule());
		resolveExpEClass.getESuperTypes().add(thePivotPackage.getCallExp());
		resolveExpEClass.getESuperTypes().add(theImperativeOCLPackage.getImperativeExpression());
		resolveInExpEClass.getESuperTypes().add(this.getResolveExp());
		varParameterEClass.getESuperTypes().add(thePivotPackage.getVariable());
		varParameterEClass.getESuperTypes().add(thePivotPackage.getParameter());
		tagEClass.getESuperTypes().add(thePivotPackage.getElement());
		EGenericType g1 = createEGenericType(theImperativeOCLPackage.getImperativeOCLVisitor());
		EGenericType g2 = createEGenericType(qvtOperationalVisitorEClass_R);
		g1.getETypeArguments().add(g2);
		qvtOperationalVisitorEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(constructorEClass, Constructor.class, "Constructor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getConstructor__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getConstructor__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(constructorBodyEClass, ConstructorBody.class, "ConstructorBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getConstructorBody__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getConstructorBody__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(contextualPropertyEClass, ContextualProperty.class, "ContextualProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContextualProperty_Context(), thePivotPackage.getClass_(), null, "context", null, 1, 1, ContextualProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContextualProperty_InitExpression(), thePivotPackage.getOCLExpression(), null, "initExpression", null, 0, 1, ContextualProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContextualProperty_Overridden(), thePivotPackage.getProperty(), null, "overridden", null, 0, 1, ContextualProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getContextualProperty__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getContextualProperty__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(dummyRelationEClass, DummyRelation.class, "DummyRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getDummyRelation__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getDummyRelation__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(dummyRelationDomainEClass, DummyRelationDomain.class, "DummyRelationDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getDummyRelationDomain__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getDummyRelationDomain__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(dummyRelationalTransformationEClass, DummyRelationalTransformation.class, "DummyRelationalTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getDummyRelationalTransformation__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getDummyRelationalTransformation__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(entryOperationEClass, EntryOperation.class, "EntryOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getEntryOperation__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getEntryOperation__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(helperEClass, Helper.class, "Helper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHelper_IsQuery(), thePivotPackage.getBoolean(), "isQuery", null, 0, 1, Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getHelper__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getHelper__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(imperativeCallExpEClass, ImperativeCallExp.class, "ImperativeCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImperativeCallExp_IsVirtual(), thePivotPackage.getBoolean(), "isVirtual", "true", 0, 1, ImperativeCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getImperativeCallExp__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getImperativeCallExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(imperativeOperationEClass, ImperativeOperation.class, "ImperativeOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImperativeOperation_Body(), this.getOperationBody(), this.getOperationBody_Operation(), "body", null, 0, 1, ImperativeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImperativeOperation_Context(), this.getVarParameter(), this.getVarParameter_CtxOwner(), "context", null, 0, 1, ImperativeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImperativeOperation_IsBlackbox(), thePivotPackage.getBoolean(), "isBlackbox", null, 0, 1, ImperativeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImperativeOperation_Overridden(), this.getImperativeOperation(), null, "overridden", null, 0, 1, ImperativeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImperativeOperation_Result(), this.getVarParameter(), this.getVarParameter_ResOwner(), "result", null, 0, -1, ImperativeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getImperativeOperation__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getImperativeOperation__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(libraryEClass, Library.class, "Library", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getLibrary__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getLibrary__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(mappingBodyEClass, MappingBody.class, "MappingBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingBody_EndSection(), thePivotPackage.getOCLExpression(), null, "endSection", null, 0, -1, MappingBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingBody_InitSection(), thePivotPackage.getOCLExpression(), null, "initSection", null, 0, -1, MappingBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getMappingBody__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getMappingBody__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(mappingCallExpEClass, MappingCallExp.class, "MappingCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingCallExp_IsStrict(), thePivotPackage.getBoolean(), "isStrict", null, 0, 1, MappingCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getMappingCallExp__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getMappingCallExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(mappingOperationEClass, MappingOperation.class, "MappingOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingOperation_Disjunct(), this.getMappingOperation(), null, "disjunct", null, 0, -1, MappingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingOperation_Inherited(), this.getMappingOperation(), null, "inherited", null, 0, -1, MappingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingOperation_Merged(), this.getMappingOperation(), null, "merged", null, 0, -1, MappingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingOperation_RefinedRelation(), this.getDummyRelation(), null, "refinedRelation", null, 0, 1, MappingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingOperation_When(), thePivotPackage.getOCLExpression(), null, "when", null, 0, 1, MappingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingOperation_Where(), thePivotPackage.getOCLExpression(), null, "where", null, 0, 1, MappingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getMappingOperation__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getMappingOperation__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(mappingParameterEClass, MappingParameter.class, "MappingParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingParameter_Extent(), this.getModelParameter(), null, "extent", null, 0, 1, MappingParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingParameter_ReferredDomain(), this.getDummyRelationDomain(), null, "referredDomain", null, 0, 1, MappingParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getMappingParameter__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getMappingParameter__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(modelParameterEClass, ModelParameter.class, "ModelParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getModelParameter__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getModelParameter__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(modelTypeEClass, ModelType.class, "ModelType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelType_AdditionalCondition(), thePivotPackage.getOCLExpression(), null, "additionalCondition", null, 0, -1, ModelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelType_ConformanceKind(), thePivotPackage.getString(), "conformanceKind", "effective", 0, 1, ModelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelType_Metamodel(), thePivotPackage.getPackage(), null, "metamodel", null, 1, -1, ModelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getModelType__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getModelType__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModule_ConfigProperty(), thePivotPackage.getProperty(), null, "configProperty", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_Entry(), this.getEntryOperation(), null, "entry", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModule_IsBlackbox(), thePivotPackage.getBoolean(), "isBlackbox", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_ModuleImport(), this.getModuleImport(), this.getModuleImport_Module(), "moduleImport", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_OwnedTag(), thePivotPackage.getTemplateableElement(), null, "ownedTag", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_OwnedVariable(), thePivotPackage.getVariable(), null, "ownedVariable", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getModule_UsedModelType(), this.getModelType(), null, "usedModelType", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getModule__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getModule__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(moduleImportEClass, ModuleImport.class, "ModuleImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModuleImport_Binding(), this.getModelType(), null, "binding", null, 0, -1, ModuleImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModuleImport_ImportedModule(), this.getModule(), null, "importedModule", null, 1, 1, ModuleImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModuleImport_Kind(), this.getImportKind(), "kind", null, 0, 1, ModuleImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModuleImport_Module(), this.getModule(), this.getModule_ModuleImport(), "module", null, 0, 1, ModuleImport.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getModuleImport__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getModuleImport__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(objectExpEClass, ObjectExp.class, "ObjectExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectExp_Body(), this.getConstructorBody(), null, "body", null, 1, 1, ObjectExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectExp_ReferredObject(), thePivotPackage.getVariable(), null, "referredObject", null, 1, 1, ObjectExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getObjectExp__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getObjectExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(operationBodyEClass, OperationBody.class, "OperationBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationBody_Content(), thePivotPackage.getOCLExpression(), null, "content", null, 0, -1, OperationBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationBody_Operation(), this.getImperativeOperation(), this.getImperativeOperation_Body(), "operation", null, 0, 1, OperationBody.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationBody_Variable(), thePivotPackage.getVariable(), null, "variable", null, 0, -1, OperationBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getOperationBody__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getOperationBody__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(operationalTransformationEClass, OperationalTransformation.class, "OperationalTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationalTransformation_IntermediateClass(), thePivotPackage.getClass_(), null, "intermediateClass", null, 0, -1, OperationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationalTransformation_IntermediateProperty(), thePivotPackage.getProperty(), null, "intermediateProperty", null, 0, -1, OperationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationalTransformation_ModelParameter(), this.getModelParameter(), null, "modelParameter", null, 0, -1, OperationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationalTransformation_Refined(), this.getDummyRelationalTransformation(), null, "refined", null, 0, 1, OperationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationalTransformation_Relation(), this.getDummyRelation(), null, "relation", null, 0, -1, OperationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getOperationalTransformation__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getOperationalTransformation__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(resolveExpEClass, ResolveExp.class, "ResolveExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResolveExp_Condition(), thePivotPackage.getOCLExpression(), null, "condition", null, 0, 1, ResolveExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResolveExp_IsDeferred(), thePivotPackage.getBoolean(), "isDeferred", null, 0, 1, ResolveExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResolveExp_IsInverse(), thePivotPackage.getBoolean(), "isInverse", null, 0, 1, ResolveExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResolveExp_One(), thePivotPackage.getBoolean(), "one", null, 0, 1, ResolveExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResolveExp_Target(), thePivotPackage.getVariable(), null, "target", null, 0, 1, ResolveExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getResolveExp__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getResolveExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(resolveInExpEClass, ResolveInExp.class, "ResolveInExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResolveInExp_InMapping(), this.getMappingOperation(), null, "inMapping", null, 0, 1, ResolveInExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getResolveInExp__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getResolveInExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(varParameterEClass, VarParameter.class, "VarParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVarParameter_CtxOwner(), this.getImperativeOperation(), this.getImperativeOperation_Context(), "ctxOwner", null, 0, 1, VarParameter.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVarParameter_Kind(), this.getDirectionKind(), "kind", null, 0, 1, VarParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVarParameter_ResOwner(), this.getImperativeOperation(), this.getImperativeOperation_Result(), "resOwner", null, 0, 1, VarParameter.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getVarParameter__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getVarParameter__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(tagEClass, Tag.class, "Tag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTag_Name(), thePivotPackage.getString(), "name", null, 0, 1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_Value(), thePivotPackage.getString(), "value", null, 0, 1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTag_Elements(), thePivotPackage.getElement(), null, "elements", null, 0, -1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getTag__Accept__QVTOperationalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getQVTOperationalVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getTag__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(qvtOperationalVisitorEClass, QVTOperationalVisitor.class, "QVTOperationalVisitor", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(directionKindEEnum, DirectionKind.class, "DirectionKind");
		addEEnumLiteral(directionKindEEnum, DirectionKind.IN);
		addEEnumLiteral(directionKindEEnum, DirectionKind.INOUT);
		addEEnumLiteral(directionKindEEnum, DirectionKind.OUT);

		initEEnum(importKindEEnum, ImportKind.class, "ImportKind");
		addEEnumLiteral(importKindEEnum, ImportKind.EXTENSION);
		addEEnumLiteral(importKindEEnum, ImportKind.ACCESS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName
		createEmofAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEmofAnnotations() {
		String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName";								
		addAnnotation
		  (getContextualProperty_InitExpression(), 
		   source, 
		   new String[] {
			 "body", "ownerProperty"
		   });		
		addAnnotation
		  (getContextualProperty_Overridden(), 
		   source, 
		   new String[] {
			 "body", "overriding"
		   });																
		addAnnotation
		  (getImperativeOperation_Overridden(), 
		   source, 
		   new String[] {
			 "body", "overriding"
		   });						
		addAnnotation
		  (getMappingBody_EndSection(), 
		   source, 
		   new String[] {
			 "body", "endOwner"
		   });		
		addAnnotation
		  (getMappingBody_InitSection(), 
		   source, 
		   new String[] {
			 "body", "initOwner"
		   });						
		addAnnotation
		  (getMappingOperation_Disjunct(), 
		   source, 
		   new String[] {
			 "body", "disjuncter"
		   });		
		addAnnotation
		  (getMappingOperation_Inherited(), 
		   source, 
		   new String[] {
			 "body", "inheriting"
		   });		
		addAnnotation
		  (getMappingOperation_Merged(), 
		   source, 
		   new String[] {
			 "body", "merging"
		   });		
		addAnnotation
		  (getMappingOperation_RefinedRelation(), 
		   source, 
		   new String[] {
			 "body", "refiningOperation"
		   });		
		addAnnotation
		  (getMappingOperation_When(), 
		   source, 
		   new String[] {
			 "body", "whenOwner"
		   });		
		addAnnotation
		  (getMappingOperation_Where(), 
		   source, 
		   new String[] {
			 "body", "whereOwner"
		   });				
		addAnnotation
		  (getMappingParameter_ReferredDomain(), 
		   source, 
		   new String[] {
			 "body", "referringParameter"
		   });						
		addAnnotation
		  (getModelType_AdditionalCondition(), 
		   source, 
		   new String[] {
			 "body", "condOwner"
		   });				
		addAnnotation
		  (getModule_Entry(), 
		   source, 
		   new String[] {
			 "body", "entryContext"
		   });		
		addAnnotation
		  (getModule_OwnedTag(), 
		   source, 
		   new String[] {
			 "body", "owner"
		   });		
		addAnnotation
		  (getModule_OwnedVariable(), 
		   source, 
		   new String[] {
			 "body", "variableOwner"
		   });				
		addAnnotation
		  (getModuleImport_ImportedModule(), 
		   source, 
		   new String[] {
			 "body", "importingElement"
		   });				
		addAnnotation
		  (getObjectExp_ReferredObject(), 
		   source, 
		   new String[] {
			 "body", "objectExpression"
		   });				
		addAnnotation
		  (getOperationBody_Content(), 
		   source, 
		   new String[] {
			 "body", "contentOwner"
		   });		
		addAnnotation
		  (getOperationBody_Variable(), 
		   source, 
		   new String[] {
			 "body", "opBody"
		   });				
		addAnnotation
		  (getOperationalTransformation_IntermediateClass(), 
		   source, 
		   new String[] {
			 "body", "transfClient"
		   });		
		addAnnotation
		  (getOperationalTransformation_IntermediateProperty(), 
		   source, 
		   new String[] {
			 "body", "tranfClient"
		   });		
		addAnnotation
		  (getOperationalTransformation_ModelParameter(), 
		   source, 
		   new String[] {
			 "body", "module"
		   });		
		addAnnotation
		  (getOperationalTransformation_Refined(), 
		   source, 
		   new String[] {
			 "body", "refinement"
		   });		
		addAnnotation
		  (getOperationalTransformation_Relation(), 
		   source, 
		   new String[] {
			 "body", "owner"
		   });						
		addAnnotation
		  (getResolveInExp_InMapping(), 
		   source, 
		   new String[] {
			 "body", "resolveExpression"
		   });				
	}

} //QVTOperationalPackageImpl
