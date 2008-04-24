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
package org.eclipse.m2m.internal.qvt.oml.expressions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.utilities.UtilitiesPackage;

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
 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionsPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation"; //$NON-NLS-1$

    /**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "expressions"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/1.0.0/Operational/Expressions"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtoperational.expr"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionsPackage eINSTANCE = org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl <em>Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getModule()
	 * @generated
	 */
	int MODULE = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EANNOTATIONS = EcorePackage.ECLASS__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__NAME = EcorePackage.ECLASS__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__INSTANCE_CLASS_NAME = EcorePackage.ECLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__INSTANCE_CLASS = EcorePackage.ECLASS__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__DEFAULT_VALUE = EcorePackage.ECLASS__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__INSTANCE_TYPE_NAME = EcorePackage.ECLASS__INSTANCE_TYPE_NAME;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EPACKAGE = EcorePackage.ECLASS__EPACKAGE;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__ETYPE_PARAMETERS = EcorePackage.ECLASS__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__ABSTRACT = EcorePackage.ECLASS__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__INTERFACE = EcorePackage.ECLASS__INTERFACE;

	/**
	 * The feature id for the '<em><b>ESuper Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__ESUPER_TYPES = EcorePackage.ECLASS__ESUPER_TYPES;

	/**
	 * The feature id for the '<em><b>EOperations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EOPERATIONS = EcorePackage.ECLASS__EOPERATIONS;

	/**
	 * The feature id for the '<em><b>EAll Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EALL_ATTRIBUTES = EcorePackage.ECLASS__EALL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>EAll References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EALL_REFERENCES = EcorePackage.ECLASS__EALL_REFERENCES;

	/**
	 * The feature id for the '<em><b>EReferences</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EREFERENCES = EcorePackage.ECLASS__EREFERENCES;

	/**
	 * The feature id for the '<em><b>EAttributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EATTRIBUTES = EcorePackage.ECLASS__EATTRIBUTES;

	/**
	 * The feature id for the '<em><b>EAll Containments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EALL_CONTAINMENTS = EcorePackage.ECLASS__EALL_CONTAINMENTS;

	/**
	 * The feature id for the '<em><b>EAll Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EALL_OPERATIONS = EcorePackage.ECLASS__EALL_OPERATIONS;

	/**
	 * The feature id for the '<em><b>EAll Structural Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EALL_STRUCTURAL_FEATURES = EcorePackage.ECLASS__EALL_STRUCTURAL_FEATURES;

	/**
	 * The feature id for the '<em><b>EAll Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EALL_SUPER_TYPES = EcorePackage.ECLASS__EALL_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>EID Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EID_ATTRIBUTE = EcorePackage.ECLASS__EID_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>EStructural Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__ESTRUCTURAL_FEATURES = EcorePackage.ECLASS__ESTRUCTURAL_FEATURES;

	/**
	 * The feature id for the '<em><b>EGeneric Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EGENERIC_SUPER_TYPES = EcorePackage.ECLASS__EGENERIC_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>EAll Generic Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EALL_GENERIC_SUPER_TYPES = EcorePackage.ECLASS__EALL_GENERIC_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__NS_URI = EcorePackage.ECLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__NS_PREFIX = EcorePackage.ECLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>EFactory Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EFACTORY_INSTANCE = EcorePackage.ECLASS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>EClassifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__ECLASSIFIERS = EcorePackage.ECLASS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>ESubpackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__ESUBPACKAGES = EcorePackage.ECLASS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>ESuper Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__ESUPER_PACKAGE = EcorePackage.ECLASS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__START_POSITION = EcorePackage.ECLASS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__END_POSITION = EcorePackage.ECLASS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Module Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__MODULE_IMPORT = EcorePackage.ECLASS_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Used Model Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__USED_MODEL_TYPE = EcorePackage.ECLASS_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Config Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__CONFIG_PROPERTY = EcorePackage.ECLASS_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Owned Renaming</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__OWNED_RENAMING = EcorePackage.ECLASS_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__ENTRY = EcorePackage.ECLASS_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Model Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__MODEL_PARAMETER = EcorePackage.ECLASS_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Intermediate Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__INTERMEDIATE_PROPERTY = EcorePackage.ECLASS_FEATURE_COUNT + 14;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_FEATURE_COUNT = EcorePackage.ECLASS_FEATURE_COUNT + 15;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.LibraryImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getLibrary()
	 * @generated
	 */
	int LIBRARY = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EANNOTATIONS = MODULE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NAME = MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__INSTANCE_CLASS_NAME = MODULE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__INSTANCE_CLASS = MODULE__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__DEFAULT_VALUE = MODULE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__INSTANCE_TYPE_NAME = MODULE__INSTANCE_TYPE_NAME;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EPACKAGE = MODULE__EPACKAGE;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__ETYPE_PARAMETERS = MODULE__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__ABSTRACT = MODULE__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__INTERFACE = MODULE__INTERFACE;

	/**
	 * The feature id for the '<em><b>ESuper Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__ESUPER_TYPES = MODULE__ESUPER_TYPES;

	/**
	 * The feature id for the '<em><b>EOperations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EOPERATIONS = MODULE__EOPERATIONS;

	/**
	 * The feature id for the '<em><b>EAll Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EALL_ATTRIBUTES = MODULE__EALL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>EAll References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EALL_REFERENCES = MODULE__EALL_REFERENCES;

	/**
	 * The feature id for the '<em><b>EReferences</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EREFERENCES = MODULE__EREFERENCES;

	/**
	 * The feature id for the '<em><b>EAttributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EATTRIBUTES = MODULE__EATTRIBUTES;

	/**
	 * The feature id for the '<em><b>EAll Containments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EALL_CONTAINMENTS = MODULE__EALL_CONTAINMENTS;

	/**
	 * The feature id for the '<em><b>EAll Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EALL_OPERATIONS = MODULE__EALL_OPERATIONS;

	/**
	 * The feature id for the '<em><b>EAll Structural Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EALL_STRUCTURAL_FEATURES = MODULE__EALL_STRUCTURAL_FEATURES;

	/**
	 * The feature id for the '<em><b>EAll Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EALL_SUPER_TYPES = MODULE__EALL_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>EID Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EID_ATTRIBUTE = MODULE__EID_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>EStructural Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__ESTRUCTURAL_FEATURES = MODULE__ESTRUCTURAL_FEATURES;

	/**
	 * The feature id for the '<em><b>EGeneric Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EGENERIC_SUPER_TYPES = MODULE__EGENERIC_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>EAll Generic Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EALL_GENERIC_SUPER_TYPES = MODULE__EALL_GENERIC_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NS_URI = MODULE__NS_URI;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NS_PREFIX = MODULE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>EFactory Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EFACTORY_INSTANCE = MODULE__EFACTORY_INSTANCE;

	/**
	 * The feature id for the '<em><b>EClassifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__ECLASSIFIERS = MODULE__ECLASSIFIERS;

	/**
	 * The feature id for the '<em><b>ESubpackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__ESUBPACKAGES = MODULE__ESUBPACKAGES;

	/**
	 * The feature id for the '<em><b>ESuper Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__ESUPER_PACKAGE = MODULE__ESUPER_PACKAGE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__START_POSITION = MODULE__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__END_POSITION = MODULE__END_POSITION;

	/**
	 * The feature id for the '<em><b>Module Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__MODULE_IMPORT = MODULE__MODULE_IMPORT;

	/**
	 * The feature id for the '<em><b>Used Model Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__USED_MODEL_TYPE = MODULE__USED_MODEL_TYPE;

	/**
	 * The feature id for the '<em><b>Config Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__CONFIG_PROPERTY = MODULE__CONFIG_PROPERTY;

	/**
	 * The feature id for the '<em><b>Owned Renaming</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__OWNED_RENAMING = MODULE__OWNED_RENAMING;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__ENTRY = MODULE__ENTRY;

	/**
	 * The feature id for the '<em><b>Model Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__MODEL_PARAMETER = MODULE__MODEL_PARAMETER;

	/**
	 * The feature id for the '<em><b>Intermediate Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__INTERMEDIATE_PROPERTY = MODULE__INTERMEDIATE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Library</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__LIBRARY = MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = MODULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.RenameImpl <em>Rename</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.RenameImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getRename()
	 * @generated
	 */
	int RENAME = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME__EANNOTATIONS = EcorePackage.ETYPED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME__NAME = EcorePackage.ETYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME__ORDERED = EcorePackage.ETYPED_ELEMENT__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME__UNIQUE = EcorePackage.ETYPED_ELEMENT__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME__LOWER_BOUND = EcorePackage.ETYPED_ELEMENT__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME__UPPER_BOUND = EcorePackage.ETYPED_ELEMENT__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME__MANY = EcorePackage.ETYPED_ELEMENT__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME__REQUIRED = EcorePackage.ETYPED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME__ETYPE = EcorePackage.ETYPED_ELEMENT__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME__EGENERIC_TYPE = EcorePackage.ETYPED_ELEMENT__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME__START_POSITION = EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME__END_POSITION = EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>New Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME__NEW_NAME = EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Rename</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_FEATURE_COUNT = EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.VisitableASTNode <em>Visitable AST Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.VisitableASTNode
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getVisitableASTNode()
	 * @generated
	 */
	int VISITABLE_AST_NODE = 26;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITABLE_AST_NODE__START_POSITION = UtilitiesPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITABLE_AST_NODE__END_POSITION = UtilitiesPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Visitable AST Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITABLE_AST_NODE_FEATURE_COUNT = UtilitiesPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImportImpl <em>Module Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImportImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getModuleImport()
	 * @generated
	 */
	int MODULE_IMPORT = 3;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_IMPORT__START_POSITION = VISITABLE_AST_NODE__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_IMPORT__END_POSITION = VISITABLE_AST_NODE__END_POSITION;

	/**
	 * The feature id for the '<em><b>Module</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_IMPORT__MODULE = VISITABLE_AST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Imported Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_IMPORT__IMPORTED_MODULE = VISITABLE_AST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Module Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_IMPORT_FEATURE_COUNT = VISITABLE_AST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.PropertyImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__EANNOTATIONS = EcorePackage.ESTRUCTURAL_FEATURE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = EcorePackage.ESTRUCTURAL_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__ORDERED = EcorePackage.ESTRUCTURAL_FEATURE__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__UNIQUE = EcorePackage.ESTRUCTURAL_FEATURE__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__LOWER_BOUND = EcorePackage.ESTRUCTURAL_FEATURE__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__UPPER_BOUND = EcorePackage.ESTRUCTURAL_FEATURE__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__MANY = EcorePackage.ESTRUCTURAL_FEATURE__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__REQUIRED = EcorePackage.ESTRUCTURAL_FEATURE__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__ETYPE = EcorePackage.ESTRUCTURAL_FEATURE__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__EGENERIC_TYPE = EcorePackage.ESTRUCTURAL_FEATURE__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__CHANGEABLE = EcorePackage.ESTRUCTURAL_FEATURE__CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VOLATILE = EcorePackage.ESTRUCTURAL_FEATURE__VOLATILE;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TRANSIENT = EcorePackage.ESTRUCTURAL_FEATURE__TRANSIENT;

	/**
	 * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DEFAULT_VALUE_LITERAL = EcorePackage.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DEFAULT_VALUE = EcorePackage.ESTRUCTURAL_FEATURE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Unsettable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__UNSETTABLE = EcorePackage.ESTRUCTURAL_FEATURE__UNSETTABLE;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DERIVED = EcorePackage.ESTRUCTURAL_FEATURE__DERIVED;

	/**
	 * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__ECONTAINING_CLASS = EcorePackage.ESTRUCTURAL_FEATURE__ECONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__START_POSITION = EcorePackage.ESTRUCTURAL_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__END_POSITION = EcorePackage.ESTRUCTURAL_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = EcorePackage.ESTRUCTURAL_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.LocalPropertyImpl <em>Local Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.LocalPropertyImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getLocalProperty()
	 * @generated
	 */
	int LOCAL_PROPERTY = 5;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__EANNOTATIONS = PROPERTY__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__NAME = PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__ORDERED = PROPERTY__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__UNIQUE = PROPERTY__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__LOWER_BOUND = PROPERTY__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__UPPER_BOUND = PROPERTY__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__MANY = PROPERTY__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__REQUIRED = PROPERTY__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__ETYPE = PROPERTY__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__EGENERIC_TYPE = PROPERTY__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__CHANGEABLE = PROPERTY__CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__VOLATILE = PROPERTY__VOLATILE;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__TRANSIENT = PROPERTY__TRANSIENT;

	/**
	 * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__DEFAULT_VALUE_LITERAL = PROPERTY__DEFAULT_VALUE_LITERAL;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__DEFAULT_VALUE = PROPERTY__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Unsettable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__UNSETTABLE = PROPERTY__UNSETTABLE;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__DERIVED = PROPERTY__DERIVED;

	/**
	 * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__ECONTAINING_CLASS = PROPERTY__ECONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__START_POSITION = PROPERTY__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__END_POSITION = PROPERTY__END_POSITION;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY__EXPRESSION = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Local Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ConfigPropertyImpl <em>Config Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ConfigPropertyImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getConfigProperty()
	 * @generated
	 */
	int CONFIG_PROPERTY = 6;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__EANNOTATIONS = PROPERTY__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__NAME = PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__ORDERED = PROPERTY__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__UNIQUE = PROPERTY__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__LOWER_BOUND = PROPERTY__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__UPPER_BOUND = PROPERTY__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__MANY = PROPERTY__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__REQUIRED = PROPERTY__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__ETYPE = PROPERTY__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__EGENERIC_TYPE = PROPERTY__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__CHANGEABLE = PROPERTY__CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__VOLATILE = PROPERTY__VOLATILE;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__TRANSIENT = PROPERTY__TRANSIENT;

	/**
	 * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__DEFAULT_VALUE_LITERAL = PROPERTY__DEFAULT_VALUE_LITERAL;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__DEFAULT_VALUE = PROPERTY__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Unsettable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__UNSETTABLE = PROPERTY__UNSETTABLE;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__DERIVED = PROPERTY__DERIVED;

	/**
	 * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__ECONTAINING_CLASS = PROPERTY__ECONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__START_POSITION = PROPERTY__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__END_POSITION = PROPERTY__END_POSITION;

	/**
	 * The number of structural features of the '<em>Config Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ContextualPropertyImpl <em>Contextual Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ContextualPropertyImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getContextualProperty()
	 * @generated
	 */
	int CONTEXTUAL_PROPERTY = 7;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__EANNOTATIONS = PROPERTY__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__NAME = PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__ORDERED = PROPERTY__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__UNIQUE = PROPERTY__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__LOWER_BOUND = PROPERTY__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__UPPER_BOUND = PROPERTY__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__MANY = PROPERTY__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__REQUIRED = PROPERTY__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__ETYPE = PROPERTY__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__EGENERIC_TYPE = PROPERTY__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__CHANGEABLE = PROPERTY__CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__VOLATILE = PROPERTY__VOLATILE;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__TRANSIENT = PROPERTY__TRANSIENT;

	/**
	 * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__DEFAULT_VALUE_LITERAL = PROPERTY__DEFAULT_VALUE_LITERAL;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__DEFAULT_VALUE = PROPERTY__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Unsettable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__UNSETTABLE = PROPERTY__UNSETTABLE;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__DERIVED = PROPERTY__DERIVED;

	/**
	 * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__ECONTAINING_CLASS = PROPERTY__ECONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__START_POSITION = PROPERTY__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__END_POSITION = PROPERTY__END_POSITION;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__CONTEXT = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__OVERRIDDEN = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY__INIT_EXPRESSION = PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Contextual Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeOperationImpl <em>Imperative Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeOperationImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getImperativeOperation()
	 * @generated
	 */
	int IMPERATIVE_OPERATION = 8;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__EANNOTATIONS = EcorePackage.EOPERATION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__NAME = EcorePackage.EOPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__ORDERED = EcorePackage.EOPERATION__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__UNIQUE = EcorePackage.EOPERATION__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__LOWER_BOUND = EcorePackage.EOPERATION__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__UPPER_BOUND = EcorePackage.EOPERATION__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__MANY = EcorePackage.EOPERATION__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__REQUIRED = EcorePackage.EOPERATION__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__ETYPE = EcorePackage.EOPERATION__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__EGENERIC_TYPE = EcorePackage.EOPERATION__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__ECONTAINING_CLASS = EcorePackage.EOPERATION__ECONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__ETYPE_PARAMETERS = EcorePackage.EOPERATION__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>EParameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__EPARAMETERS = EcorePackage.EOPERATION__EPARAMETERS;

	/**
	 * The feature id for the '<em><b>EExceptions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__EEXCEPTIONS = EcorePackage.EOPERATION__EEXCEPTIONS;

	/**
	 * The feature id for the '<em><b>EGeneric Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__EGENERIC_EXCEPTIONS = EcorePackage.EOPERATION__EGENERIC_EXCEPTIONS;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__START_POSITION = EcorePackage.EOPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__END_POSITION = EcorePackage.EOPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__CONTEXT = EcorePackage.EOPERATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__RESULT = EcorePackage.EOPERATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__BODY = EcorePackage.EOPERATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Is Blackbox</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION__IS_BLACKBOX = EcorePackage.EOPERATION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Imperative Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_FEATURE_COUNT = EcorePackage.EOPERATION_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.VarParameterImpl <em>Var Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.VarParameterImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getVarParameter()
	 * @generated
	 */
	int VAR_PARAMETER = 10;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_PARAMETER__EANNOTATIONS = EcorePackage.EPARAMETER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_PARAMETER__NAME = EcorePackage.EPARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_PARAMETER__ORDERED = EcorePackage.EPARAMETER__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_PARAMETER__UNIQUE = EcorePackage.EPARAMETER__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_PARAMETER__LOWER_BOUND = EcorePackage.EPARAMETER__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_PARAMETER__UPPER_BOUND = EcorePackage.EPARAMETER__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_PARAMETER__MANY = EcorePackage.EPARAMETER__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_PARAMETER__REQUIRED = EcorePackage.EPARAMETER__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_PARAMETER__ETYPE = EcorePackage.EPARAMETER__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_PARAMETER__EGENERIC_TYPE = EcorePackage.EPARAMETER__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>EOperation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_PARAMETER__EOPERATION = EcorePackage.EPARAMETER__EOPERATION;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_PARAMETER__START_POSITION = EcorePackage.EPARAMETER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_PARAMETER__END_POSITION = EcorePackage.EPARAMETER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ctx Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_PARAMETER__CTX_OWNER = EcorePackage.EPARAMETER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Res Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_PARAMETER__RES_OWNER = EcorePackage.EPARAMETER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_PARAMETER__KIND = EcorePackage.EPARAMETER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Var Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_PARAMETER_FEATURE_COUNT = EcorePackage.EPARAMETER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModelParameterImpl <em>Model Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModelParameterImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getModelParameter()
	 * @generated
	 */
	int MODEL_PARAMETER = 9;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PARAMETER__EANNOTATIONS = VAR_PARAMETER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PARAMETER__NAME = VAR_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PARAMETER__ORDERED = VAR_PARAMETER__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PARAMETER__UNIQUE = VAR_PARAMETER__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PARAMETER__LOWER_BOUND = VAR_PARAMETER__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PARAMETER__UPPER_BOUND = VAR_PARAMETER__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PARAMETER__MANY = VAR_PARAMETER__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PARAMETER__REQUIRED = VAR_PARAMETER__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PARAMETER__ETYPE = VAR_PARAMETER__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PARAMETER__EGENERIC_TYPE = VAR_PARAMETER__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>EOperation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PARAMETER__EOPERATION = VAR_PARAMETER__EOPERATION;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PARAMETER__START_POSITION = VAR_PARAMETER__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PARAMETER__END_POSITION = VAR_PARAMETER__END_POSITION;

	/**
	 * The feature id for the '<em><b>Ctx Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PARAMETER__CTX_OWNER = VAR_PARAMETER__CTX_OWNER;

	/**
	 * The feature id for the '<em><b>Res Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PARAMETER__RES_OWNER = VAR_PARAMETER__RES_OWNER;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PARAMETER__KIND = VAR_PARAMETER__KIND;

	/**
	 * The number of structural features of the '<em>Model Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PARAMETER_FEATURE_COUNT = VAR_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.OperationBodyImpl <em>Operation Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.OperationBodyImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getOperationBody()
	 * @generated
	 */
	int OPERATION_BODY = 11;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_BODY__START_POSITION = VISITABLE_AST_NODE__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_BODY__END_POSITION = VISITABLE_AST_NODE__END_POSITION;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_BODY__OPERATION = VISITABLE_AST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_BODY__CONTENT = VISITABLE_AST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_BODY__VARIABLE = VISITABLE_AST_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Operation Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_BODY_FEATURE_COUNT = VISITABLE_AST_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ConstructorBodyImpl <em>Constructor Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ConstructorBodyImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getConstructorBody()
	 * @generated
	 */
	int CONSTRUCTOR_BODY = 12;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_BODY__START_POSITION = OPERATION_BODY__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_BODY__END_POSITION = OPERATION_BODY__END_POSITION;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_BODY__OPERATION = OPERATION_BODY__OPERATION;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_BODY__CONTENT = OPERATION_BODY__CONTENT;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_BODY__VARIABLE = OPERATION_BODY__VARIABLE;

	/**
	 * The number of structural features of the '<em>Constructor Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_BODY_FEATURE_COUNT = OPERATION_BODY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.MappingOperationImpl <em>Mapping Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.MappingOperationImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getMappingOperation()
	 * @generated
	 */
	int MAPPING_OPERATION = 13;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__EANNOTATIONS = IMPERATIVE_OPERATION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__NAME = IMPERATIVE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__ORDERED = IMPERATIVE_OPERATION__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__UNIQUE = IMPERATIVE_OPERATION__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__LOWER_BOUND = IMPERATIVE_OPERATION__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__UPPER_BOUND = IMPERATIVE_OPERATION__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__MANY = IMPERATIVE_OPERATION__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__REQUIRED = IMPERATIVE_OPERATION__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__ETYPE = IMPERATIVE_OPERATION__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__EGENERIC_TYPE = IMPERATIVE_OPERATION__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__ECONTAINING_CLASS = IMPERATIVE_OPERATION__ECONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__ETYPE_PARAMETERS = IMPERATIVE_OPERATION__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>EParameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__EPARAMETERS = IMPERATIVE_OPERATION__EPARAMETERS;

	/**
	 * The feature id for the '<em><b>EExceptions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__EEXCEPTIONS = IMPERATIVE_OPERATION__EEXCEPTIONS;

	/**
	 * The feature id for the '<em><b>EGeneric Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__EGENERIC_EXCEPTIONS = IMPERATIVE_OPERATION__EGENERIC_EXCEPTIONS;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__START_POSITION = IMPERATIVE_OPERATION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__END_POSITION = IMPERATIVE_OPERATION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__CONTEXT = IMPERATIVE_OPERATION__CONTEXT;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__RESULT = IMPERATIVE_OPERATION__RESULT;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__BODY = IMPERATIVE_OPERATION__BODY;

	/**
	 * The feature id for the '<em><b>Is Blackbox</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__IS_BLACKBOX = IMPERATIVE_OPERATION__IS_BLACKBOX;

	/**
	 * The feature id for the '<em><b>When</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__WHEN = IMPERATIVE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inherited</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__INHERITED = IMPERATIVE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Merged</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__MERGED = IMPERATIVE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Disjunct</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION__DISJUNCT = IMPERATIVE_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mapping Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_FEATURE_COUNT = IMPERATIVE_OPERATION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.HelperImpl <em>Helper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.HelperImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getHelper()
	 * @generated
	 */
	int HELPER = 14;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__EANNOTATIONS = IMPERATIVE_OPERATION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__NAME = IMPERATIVE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__ORDERED = IMPERATIVE_OPERATION__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__UNIQUE = IMPERATIVE_OPERATION__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__LOWER_BOUND = IMPERATIVE_OPERATION__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__UPPER_BOUND = IMPERATIVE_OPERATION__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__MANY = IMPERATIVE_OPERATION__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__REQUIRED = IMPERATIVE_OPERATION__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__ETYPE = IMPERATIVE_OPERATION__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__EGENERIC_TYPE = IMPERATIVE_OPERATION__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__ECONTAINING_CLASS = IMPERATIVE_OPERATION__ECONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__ETYPE_PARAMETERS = IMPERATIVE_OPERATION__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>EParameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__EPARAMETERS = IMPERATIVE_OPERATION__EPARAMETERS;

	/**
	 * The feature id for the '<em><b>EExceptions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__EEXCEPTIONS = IMPERATIVE_OPERATION__EEXCEPTIONS;

	/**
	 * The feature id for the '<em><b>EGeneric Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__EGENERIC_EXCEPTIONS = IMPERATIVE_OPERATION__EGENERIC_EXCEPTIONS;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__START_POSITION = IMPERATIVE_OPERATION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__END_POSITION = IMPERATIVE_OPERATION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__CONTEXT = IMPERATIVE_OPERATION__CONTEXT;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__RESULT = IMPERATIVE_OPERATION__RESULT;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__BODY = IMPERATIVE_OPERATION__BODY;

	/**
	 * The feature id for the '<em><b>Is Blackbox</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__IS_BLACKBOX = IMPERATIVE_OPERATION__IS_BLACKBOX;

	/**
	 * The feature id for the '<em><b>Is Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER__IS_QUERY = IMPERATIVE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELPER_FEATURE_COUNT = IMPERATIVE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.MappingBodyImpl <em>Mapping Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.MappingBodyImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getMappingBody()
	 * @generated
	 */
	int MAPPING_BODY = 15;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY__START_POSITION = OPERATION_BODY__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY__END_POSITION = OPERATION_BODY__END_POSITION;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY__OPERATION = OPERATION_BODY__OPERATION;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY__CONTENT = OPERATION_BODY__CONTENT;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY__VARIABLE = OPERATION_BODY__VARIABLE;

	/**
	 * The feature id for the '<em><b>Init Section</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY__INIT_SECTION = OPERATION_BODY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Section</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY__END_SECTION = OPERATION_BODY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_FEATURE_COUNT = OPERATION_BODY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeExpressionImpl <em>Imperative Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeExpressionImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getImperativeExpression()
	 * @generated
	 */
	int IMPERATIVE_EXPRESSION = 16;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION__START_POSITION = org.eclipse.ocl.expressions.ExpressionsPackage.OCL_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION__END_POSITION = org.eclipse.ocl.expressions.ExpressionsPackage.OCL_EXPRESSION__END_POSITION;

	/**
	 * The number of structural features of the '<em>Imperative Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION_FEATURE_COUNT = org.eclipse.ocl.expressions.ExpressionsPackage.OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.AssignExpImpl <em>Assign Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.AssignExpImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getAssignExp()
	 * @generated
	 */
	int ASSIGN_EXP = 17;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__START_POSITION = IMPERATIVE_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__END_POSITION = IMPERATIVE_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__VALUE = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__LEFT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Reset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__IS_RESET = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assign Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.VariableInitExpImpl <em>Variable Init Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.VariableInitExpImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getVariableInitExp()
	 * @generated
	 */
	int VARIABLE_INIT_EXP = 18;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP__START_POSITION = IMPERATIVE_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP__END_POSITION = IMPERATIVE_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP__VALUE = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Init Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.MappingCallExpImpl <em>Mapping Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.MappingCallExpImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getMappingCallExp()
	 * @generated
	 */
	int MAPPING_CALL_EXP = 19;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP__START_POSITION = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP__END_POSITION = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP__PROPERTY_START_POSITION = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP__PROPERTY_START_POSITION;

	/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP__PROPERTY_END_POSITION = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP__PROPERTY_END_POSITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP__SOURCE = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP__MARKED_PRE = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP__MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP__ARGUMENT = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENT;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP__REFERRED_OPERATION = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION;

	/**
	 * The feature id for the '<em><b>Operation Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP__OPERATION_CODE = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP__OPERATION_CODE;

	/**
	 * The feature id for the '<em><b>Is Strict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP__IS_STRICT = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapping Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_FEATURE_COUNT = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.BlockExpImpl <em>Block Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.BlockExpImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getBlockExp()
	 * @generated
	 */
	int BLOCK_EXP = 20;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP__START_POSITION = IMPERATIVE_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP__END_POSITION = IMPERATIVE_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP__BODY = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.InstantiationExpImpl <em>Instantiation Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.InstantiationExpImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getInstantiationExp()
	 * @generated
	 */
	int INSTANTIATION_EXP = 36;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__START_POSITION = IMPERATIVE_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__END_POSITION = IMPERATIVE_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__ARGUMENT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__EXTENT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instantiated Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__INSTANTIATED_CLASS = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Instantiation Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ObjectExpImpl <em>Object Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ObjectExpImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getObjectExp()
	 * @generated
	 */
	int OBJECT_EXP = 21;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP__START_POSITION = INSTANTIATION_EXP__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP__END_POSITION = INSTANTIATION_EXP__END_POSITION;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP__ARGUMENT = INSTANTIATION_EXP__ARGUMENT;

	/**
	 * The feature id for the '<em><b>Extent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP__EXTENT = INSTANTIATION_EXP__EXTENT;

	/**
	 * The feature id for the '<em><b>Instantiated Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP__INSTANTIATED_CLASS = INSTANTIATION_EXP__INSTANTIATED_CLASS;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP__BODY = INSTANTIATION_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP__REFERRED_OBJECT = INSTANTIATION_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_FEATURE_COUNT = INSTANTIATION_EXP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.WhileExpImpl <em>While Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.WhileExpImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getWhileExp()
	 * @generated
	 */
	int WHILE_EXP = 22;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__START_POSITION = IMPERATIVE_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__END_POSITION = IMPERATIVE_EXPRESSION__END_POSITION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__CONDITION = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__BODY = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__RESULT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Result Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__RESULT_VAR = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>While Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.SwitchExpImpl <em>Switch Exp</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.SwitchExpImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getSwitchExp()
	 * @generated
	 */
    int SWITCH_EXP = 23;

    /**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int SWITCH_EXP__START_POSITION = IMPERATIVE_EXPRESSION__START_POSITION;

    /**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int SWITCH_EXP__END_POSITION = IMPERATIVE_EXPRESSION__END_POSITION;

    /**
	 * The feature id for the '<em><b>Alternative Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int SWITCH_EXP__ALTERNATIVE_PART = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

    /**
	 * The feature id for the '<em><b>Else Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int SWITCH_EXP__ELSE_PART = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

    /**
	 * The number of structural features of the '<em>Switch Exp</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int SWITCH_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

    /**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.AltExpImpl <em>Alt Exp</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.AltExpImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getAltExp()
	 * @generated
	 */
    int ALT_EXP = 24;

    /**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ALT_EXP__START_POSITION = IMPERATIVE_EXPRESSION__START_POSITION;

    /**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ALT_EXP__END_POSITION = IMPERATIVE_EXPRESSION__END_POSITION;

    /**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ALT_EXP__CONDITION = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

    /**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ALT_EXP__BODY = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

    /**
	 * The number of structural features of the '<em>Alt Exp</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ALT_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

    /**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ExtendedVisitor <em>Extended Visitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ExtendedVisitor
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getExtendedVisitor()
	 * @generated
	 */
	int EXTENDED_VISITOR = 25;

	/**
	 * The number of structural features of the '<em>Extended Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_VISITOR_FEATURE_COUNT = UtilitiesPackage.VISITOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ResolveExpImpl <em>Resolve Exp</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ResolveExpImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getResolveExp()
	 * @generated
	 */
    int RESOLVE_EXP = 27;

    /**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_EXP__START_POSITION = org.eclipse.ocl.expressions.ExpressionsPackage.CALL_EXP__START_POSITION;

    /**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_EXP__END_POSITION = org.eclipse.ocl.expressions.ExpressionsPackage.CALL_EXP__END_POSITION;

    /**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_EXP__PROPERTY_START_POSITION = org.eclipse.ocl.expressions.ExpressionsPackage.CALL_EXP__PROPERTY_START_POSITION;

    /**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_EXP__PROPERTY_END_POSITION = org.eclipse.ocl.expressions.ExpressionsPackage.CALL_EXP__PROPERTY_END_POSITION;

    /**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_EXP__SOURCE = org.eclipse.ocl.expressions.ExpressionsPackage.CALL_EXP__SOURCE;

    /**
	 * The feature id for the '<em><b>One</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_EXP__ONE = org.eclipse.ocl.expressions.ExpressionsPackage.CALL_EXP_FEATURE_COUNT + 0;

    /**
	 * The feature id for the '<em><b>Is Inverse</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_EXP__IS_INVERSE = org.eclipse.ocl.expressions.ExpressionsPackage.CALL_EXP_FEATURE_COUNT + 1;

    /**
	 * The feature id for the '<em><b>Is Deferred</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_EXP__IS_DEFERRED = org.eclipse.ocl.expressions.ExpressionsPackage.CALL_EXP_FEATURE_COUNT + 2;

    /**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_EXP__TARGET = org.eclipse.ocl.expressions.ExpressionsPackage.CALL_EXP_FEATURE_COUNT + 3;

    /**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_EXP__CONDITION = org.eclipse.ocl.expressions.ExpressionsPackage.CALL_EXP_FEATURE_COUNT + 4;

    /**
	 * The number of structural features of the '<em>Resolve Exp</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_EXP_FEATURE_COUNT = org.eclipse.ocl.expressions.ExpressionsPackage.CALL_EXP_FEATURE_COUNT + 5;

    /**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ResolveInExpImpl <em>Resolve In Exp</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ResolveInExpImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getResolveInExp()
	 * @generated
	 */
    int RESOLVE_IN_EXP = 28;

    /**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_IN_EXP__START_POSITION = RESOLVE_EXP__START_POSITION;

    /**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_IN_EXP__END_POSITION = RESOLVE_EXP__END_POSITION;

    /**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_IN_EXP__PROPERTY_START_POSITION = RESOLVE_EXP__PROPERTY_START_POSITION;

    /**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_IN_EXP__PROPERTY_END_POSITION = RESOLVE_EXP__PROPERTY_END_POSITION;

    /**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_IN_EXP__SOURCE = RESOLVE_EXP__SOURCE;

    /**
	 * The feature id for the '<em><b>One</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_IN_EXP__ONE = RESOLVE_EXP__ONE;

    /**
	 * The feature id for the '<em><b>Is Inverse</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_IN_EXP__IS_INVERSE = RESOLVE_EXP__IS_INVERSE;

    /**
	 * The feature id for the '<em><b>Is Deferred</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_IN_EXP__IS_DEFERRED = RESOLVE_EXP__IS_DEFERRED;

    /**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_IN_EXP__TARGET = RESOLVE_EXP__TARGET;

    /**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_IN_EXP__CONDITION = RESOLVE_EXP__CONDITION;

    /**
	 * The feature id for the '<em><b>In Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_IN_EXP__IN_MAPPINGS = RESOLVE_EXP_FEATURE_COUNT + 0;

    /**
	 * The number of structural features of the '<em>Resolve In Exp</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOLVE_IN_EXP_FEATURE_COUNT = RESOLVE_EXP_FEATURE_COUNT + 1;

    /**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModelTypeImpl <em>Model Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModelTypeImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getModelType()
	 * @generated
	 */
	int MODEL_TYPE = 29;

				/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__EANNOTATIONS = EcorePackage.ECLASS__EANNOTATIONS;

				/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__NAME = EcorePackage.ECLASS__NAME;

				/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__INSTANCE_CLASS_NAME = EcorePackage.ECLASS__INSTANCE_CLASS_NAME;

				/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__INSTANCE_CLASS = EcorePackage.ECLASS__INSTANCE_CLASS;

				/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__DEFAULT_VALUE = EcorePackage.ECLASS__DEFAULT_VALUE;

				/**
	 * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__INSTANCE_TYPE_NAME = EcorePackage.ECLASS__INSTANCE_TYPE_NAME;

				/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__EPACKAGE = EcorePackage.ECLASS__EPACKAGE;

				/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__ETYPE_PARAMETERS = EcorePackage.ECLASS__ETYPE_PARAMETERS;

				/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__ABSTRACT = EcorePackage.ECLASS__ABSTRACT;

				/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__INTERFACE = EcorePackage.ECLASS__INTERFACE;

				/**
	 * The feature id for the '<em><b>ESuper Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__ESUPER_TYPES = EcorePackage.ECLASS__ESUPER_TYPES;

				/**
	 * The feature id for the '<em><b>EOperations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__EOPERATIONS = EcorePackage.ECLASS__EOPERATIONS;

				/**
	 * The feature id for the '<em><b>EAll Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__EALL_ATTRIBUTES = EcorePackage.ECLASS__EALL_ATTRIBUTES;

				/**
	 * The feature id for the '<em><b>EAll References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__EALL_REFERENCES = EcorePackage.ECLASS__EALL_REFERENCES;

				/**
	 * The feature id for the '<em><b>EReferences</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__EREFERENCES = EcorePackage.ECLASS__EREFERENCES;

				/**
	 * The feature id for the '<em><b>EAttributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__EATTRIBUTES = EcorePackage.ECLASS__EATTRIBUTES;

				/**
	 * The feature id for the '<em><b>EAll Containments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__EALL_CONTAINMENTS = EcorePackage.ECLASS__EALL_CONTAINMENTS;

				/**
	 * The feature id for the '<em><b>EAll Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__EALL_OPERATIONS = EcorePackage.ECLASS__EALL_OPERATIONS;

				/**
	 * The feature id for the '<em><b>EAll Structural Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__EALL_STRUCTURAL_FEATURES = EcorePackage.ECLASS__EALL_STRUCTURAL_FEATURES;

				/**
	 * The feature id for the '<em><b>EAll Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__EALL_SUPER_TYPES = EcorePackage.ECLASS__EALL_SUPER_TYPES;

				/**
	 * The feature id for the '<em><b>EID Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__EID_ATTRIBUTE = EcorePackage.ECLASS__EID_ATTRIBUTE;

				/**
	 * The feature id for the '<em><b>EStructural Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__ESTRUCTURAL_FEATURES = EcorePackage.ECLASS__ESTRUCTURAL_FEATURES;

				/**
	 * The feature id for the '<em><b>EGeneric Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__EGENERIC_SUPER_TYPES = EcorePackage.ECLASS__EGENERIC_SUPER_TYPES;

				/**
	 * The feature id for the '<em><b>EAll Generic Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__EALL_GENERIC_SUPER_TYPES = EcorePackage.ECLASS__EALL_GENERIC_SUPER_TYPES;

				/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__START_POSITION = EcorePackage.ECLASS_FEATURE_COUNT + 0;

				/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__END_POSITION = EcorePackage.ECLASS_FEATURE_COUNT + 1;

				/**
	 * The feature id for the '<em><b>Metamodel</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__METAMODEL = EcorePackage.ECLASS_FEATURE_COUNT + 2;

				/**
	 * The feature id for the '<em><b>Additional Condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__ADDITIONAL_CONDITION = EcorePackage.ECLASS_FEATURE_COUNT + 3;

				/**
	 * The feature id for the '<em><b>Conformance Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__CONFORMANCE_KIND = EcorePackage.ECLASS_FEATURE_COUNT + 4;

				/**
	 * The number of structural features of the '<em>Model Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_FEATURE_COUNT = EcorePackage.ECLASS_FEATURE_COUNT + 5;

				/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.PackageRefImpl <em>Package Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.PackageRefImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getPackageRef()
	 * @generated
	 */
	int PACKAGE_REF = 30;

				/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF__START_POSITION = UtilitiesPackage.AST_NODE__START_POSITION;

				/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF__END_POSITION = UtilitiesPackage.AST_NODE__END_POSITION;

				/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF__URI = UtilitiesPackage.AST_NODE_FEATURE_COUNT + 0;

				/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF__NAME = UtilitiesPackage.AST_NODE_FEATURE_COUNT + 1;

				/**
	 * The number of structural features of the '<em>Package Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_FEATURE_COUNT = UtilitiesPackage.AST_NODE_FEATURE_COUNT + 2;

				/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.MappingParameterImpl <em>Mapping Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.MappingParameterImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getMappingParameter()
	 * @generated
	 */
	int MAPPING_PARAMETER = 31;

				/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__EANNOTATIONS = VAR_PARAMETER__EANNOTATIONS;

				/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__NAME = VAR_PARAMETER__NAME;

				/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__ORDERED = VAR_PARAMETER__ORDERED;

				/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__UNIQUE = VAR_PARAMETER__UNIQUE;

				/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__LOWER_BOUND = VAR_PARAMETER__LOWER_BOUND;

				/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__UPPER_BOUND = VAR_PARAMETER__UPPER_BOUND;

				/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__MANY = VAR_PARAMETER__MANY;

				/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__REQUIRED = VAR_PARAMETER__REQUIRED;

				/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__ETYPE = VAR_PARAMETER__ETYPE;

				/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__EGENERIC_TYPE = VAR_PARAMETER__EGENERIC_TYPE;

				/**
	 * The feature id for the '<em><b>EOperation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__EOPERATION = VAR_PARAMETER__EOPERATION;

				/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__START_POSITION = VAR_PARAMETER__START_POSITION;

				/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__END_POSITION = VAR_PARAMETER__END_POSITION;

				/**
	 * The feature id for the '<em><b>Ctx Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__CTX_OWNER = VAR_PARAMETER__CTX_OWNER;

				/**
	 * The feature id for the '<em><b>Res Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__RES_OWNER = VAR_PARAMETER__RES_OWNER;

				/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__KIND = VAR_PARAMETER__KIND;

				/**
	 * The feature id for the '<em><b>Extent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__EXTENT = VAR_PARAMETER_FEATURE_COUNT + 0;

				/**
	 * The number of structural features of the '<em>Mapping Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER_FEATURE_COUNT = VAR_PARAMETER_FEATURE_COUNT + 1;

				/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.LogExpImpl <em>Log Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.LogExpImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getLogExp()
	 * @generated
	 */
	int LOG_EXP = 32;

				/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__START_POSITION = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP__START_POSITION;

				/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__END_POSITION = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP__END_POSITION;

				/**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__PROPERTY_START_POSITION = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP__PROPERTY_START_POSITION;

				/**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__PROPERTY_END_POSITION = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP__PROPERTY_END_POSITION;

				/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__SOURCE = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP__SOURCE;

				/**
	 * The feature id for the '<em><b>Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__MARKED_PRE = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP__MARKED_PRE;

				/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__ARGUMENT = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENT;

				/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__REFERRED_OPERATION = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION;

				/**
	 * The feature id for the '<em><b>Operation Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__OPERATION_CODE = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP__OPERATION_CODE;

				/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__CONDITION = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP_FEATURE_COUNT + 0;

				/**
	 * The number of structural features of the '<em>Log Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_FEATURE_COUNT = org.eclipse.ocl.expressions.ExpressionsPackage.OPERATION_CALL_EXP_FEATURE_COUNT + 1;

				/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.AssertExpImpl <em>Assert Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.AssertExpImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getAssertExp()
	 * @generated
	 */
	int ASSERT_EXP = 33;

				/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__START_POSITION = IMPERATIVE_EXPRESSION__START_POSITION;

				/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__END_POSITION = IMPERATIVE_EXPRESSION__END_POSITION;

				/**
	 * The feature id for the '<em><b>Assertion</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__ASSERTION = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

				/**
	 * The feature id for the '<em><b>Log</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__LOG = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

				/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__SEVERITY = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

				/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__LINE = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 3;

				/**
	 * The number of structural features of the '<em>Assert Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 4;

				/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeLoopExpImpl <em>Imperative Loop Exp</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeLoopExpImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getImperativeLoopExp()
	 * @generated
	 */
    int IMPERATIVE_LOOP_EXP = 34;

                /**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_LOOP_EXP__START_POSITION = org.eclipse.ocl.expressions.ExpressionsPackage.LOOP_EXP__START_POSITION;

                /**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_LOOP_EXP__END_POSITION = org.eclipse.ocl.expressions.ExpressionsPackage.LOOP_EXP__END_POSITION;

                /**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_LOOP_EXP__PROPERTY_START_POSITION = org.eclipse.ocl.expressions.ExpressionsPackage.LOOP_EXP__PROPERTY_START_POSITION;

                /**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_LOOP_EXP__PROPERTY_END_POSITION = org.eclipse.ocl.expressions.ExpressionsPackage.LOOP_EXP__PROPERTY_END_POSITION;

                /**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_LOOP_EXP__SOURCE = org.eclipse.ocl.expressions.ExpressionsPackage.LOOP_EXP__SOURCE;

                /**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_LOOP_EXP__BODY = org.eclipse.ocl.expressions.ExpressionsPackage.LOOP_EXP__BODY;

                /**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_LOOP_EXP__ITERATOR = org.eclipse.ocl.expressions.ExpressionsPackage.LOOP_EXP__ITERATOR;

                /**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_LOOP_EXP__CONDITION = org.eclipse.ocl.expressions.ExpressionsPackage.LOOP_EXP_FEATURE_COUNT + 0;

                /**
	 * The number of structural features of the '<em>Imperative Loop Exp</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_LOOP_EXP_FEATURE_COUNT = org.eclipse.ocl.expressions.ExpressionsPackage.LOOP_EXP_FEATURE_COUNT + 1;

                /**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeIterateExpImpl <em>Imperative Iterate Exp</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeIterateExpImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getImperativeIterateExp()
	 * @generated
	 */
    int IMPERATIVE_ITERATE_EXP = 35;

                /**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_ITERATE_EXP__START_POSITION = IMPERATIVE_LOOP_EXP__START_POSITION;

                /**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_ITERATE_EXP__END_POSITION = IMPERATIVE_LOOP_EXP__END_POSITION;

                /**
	 * The feature id for the '<em><b>Property Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_ITERATE_EXP__PROPERTY_START_POSITION = IMPERATIVE_LOOP_EXP__PROPERTY_START_POSITION;

                /**
	 * The feature id for the '<em><b>Property End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_ITERATE_EXP__PROPERTY_END_POSITION = IMPERATIVE_LOOP_EXP__PROPERTY_END_POSITION;

                /**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_ITERATE_EXP__SOURCE = IMPERATIVE_LOOP_EXP__SOURCE;

                /**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_ITERATE_EXP__BODY = IMPERATIVE_LOOP_EXP__BODY;

                /**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_ITERATE_EXP__ITERATOR = IMPERATIVE_LOOP_EXP__ITERATOR;

                /**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_ITERATE_EXP__CONDITION = IMPERATIVE_LOOP_EXP__CONDITION;

                /**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_ITERATE_EXP__TARGET = IMPERATIVE_LOOP_EXP_FEATURE_COUNT + 0;

                /**
	 * The number of structural features of the '<em>Imperative Iterate Exp</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int IMPERATIVE_ITERATE_EXP_FEATURE_COUNT = IMPERATIVE_LOOP_EXP_FEATURE_COUNT + 1;

                /**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ReturnExpImpl <em>Return Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ReturnExpImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getReturnExp()
	 * @generated
	 */
	int RETURN_EXP = 37;

																/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP__START_POSITION = IMPERATIVE_EXPRESSION__START_POSITION;

																/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP__END_POSITION = IMPERATIVE_EXPRESSION__END_POSITION;

																/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP__VALUE = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

																/**
	 * The number of structural features of the '<em>Return Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

																/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind <em>Direction Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getDirectionKind()
	 * @generated
	 */
	int DIRECTION_KIND = 38;


	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.SeverityKind <em>Severity Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.SeverityKind
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getSeverityKind()
	 * @generated
	 */
	int SEVERITY_KIND = 39;


	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.Module
	 * @generated
	 */
	EClass getModule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.Module#getOwnedRenaming <em>Owned Renaming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Renaming</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.Module#getOwnedRenaming()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_OwnedRenaming();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.Module#getEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entry</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.Module#getEntry()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Entry();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.Module#getModelParameter <em>Model Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Parameter</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.Module#getModelParameter()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_ModelParameter();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.Module#getIntermediateProperty <em>Intermediate Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Intermediate Property</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.Module#getIntermediateProperty()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_IntermediateProperty();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.Module#getConfigProperty <em>Config Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Config Property</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.Module#getConfigProperty()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_ConfigProperty();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.Module#getModuleImport <em>Module Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Module Import</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.Module#getModuleImport()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_ModuleImport();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.Module#getUsedModelType <em>Used Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Used Model Type</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.Module#getUsedModelType()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_UsedModelType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.Library#getLibrary <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Library</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.Library#getLibrary()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Library();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.Rename <em>Rename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rename</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.Rename
	 * @generated
	 */
	EClass getRename();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.expressions.Rename#getNewName <em>New Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Name</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.Rename#getNewName()
	 * @see #getRename()
	 * @generated
	 */
	EAttribute getRename_NewName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport <em>Module Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Import</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport
	 * @generated
	 */
	EClass getModuleImport();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Module</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport#getModule()
	 * @see #getModuleImport()
	 * @generated
	 */
	EReference getModuleImport_Module();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport#getImportedModule <em>Imported Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Imported Module</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport#getImportedModule()
	 * @see #getModuleImport()
	 * @generated
	 */
	EReference getModuleImport_ImportedModule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.LocalProperty <em>Local Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Property</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.LocalProperty
	 * @generated
	 */
	EClass getLocalProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.LocalProperty#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.LocalProperty#getExpression()
	 * @see #getLocalProperty()
	 * @generated
	 */
	EReference getLocalProperty_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ConfigProperty <em>Config Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config Property</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ConfigProperty
	 * @generated
	 */
	EClass getConfigProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty <em>Contextual Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contextual Property</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty
	 * @generated
	 */
	EClass getContextualProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty#getContext()
	 * @see #getContextualProperty()
	 * @generated
	 */
	EReference getContextualProperty_Context();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty#getOverridden <em>Overridden</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Overridden</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty#getOverridden()
	 * @see #getContextualProperty()
	 * @generated
	 */
	EReference getContextualProperty_Overridden();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty#getInitExpression <em>Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Expression</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty#getInitExpression()
	 * @see #getContextualProperty()
	 * @generated
	 */
	EReference getContextualProperty_InitExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation <em>Imperative Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Operation</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation
	 * @generated
	 */
	EClass getImperativeOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation#getContext()
	 * @see #getImperativeOperation()
	 * @generated
	 */
	EReference getImperativeOperation_Context();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Result</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation#getResult()
	 * @see #getImperativeOperation()
	 * @generated
	 */
	EReference getImperativeOperation_Result();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation#getBody()
	 * @see #getImperativeOperation()
	 * @generated
	 */
	EReference getImperativeOperation_Body();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation#isIsBlackbox <em>Is Blackbox</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Blackbox</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation#isIsBlackbox()
	 * @see #getImperativeOperation()
	 * @generated
	 */
	EAttribute getImperativeOperation_IsBlackbox();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter <em>Model Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Parameter</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter
	 * @generated
	 */
	EClass getModelParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter <em>Var Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Parameter</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter
	 * @generated
	 */
	EClass getVarParameter();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter#getCtxOwner <em>Ctx Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Ctx Owner</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter#getCtxOwner()
	 * @see #getVarParameter()
	 * @generated
	 */
	EReference getVarParameter_CtxOwner();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter#getResOwner <em>Res Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Res Owner</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter#getResOwner()
	 * @see #getVarParameter()
	 * @generated
	 */
	EReference getVarParameter_ResOwner();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter#getKind()
	 * @see #getVarParameter()
	 * @generated
	 */
	EAttribute getVarParameter_Kind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.OperationBody <em>Operation Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Body</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.OperationBody
	 * @generated
	 */
	EClass getOperationBody();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.OperationBody#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.OperationBody#getOperation()
	 * @see #getOperationBody()
	 * @generated
	 */
	EReference getOperationBody_Operation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.OperationBody#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Content</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.OperationBody#getContent()
	 * @see #getOperationBody()
	 * @generated
	 */
	EReference getOperationBody_Content();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.OperationBody#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.OperationBody#getVariable()
	 * @see #getOperationBody()
	 * @generated
	 */
	EReference getOperationBody_Variable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ConstructorBody <em>Constructor Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constructor Body</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ConstructorBody
	 * @generated
	 */
	EClass getConstructorBody();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation <em>Mapping Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Operation</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation
	 * @generated
	 */
	EClass getMappingOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation#getWhen <em>When</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>When</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation#getWhen()
	 * @see #getMappingOperation()
	 * @generated
	 */
	EReference getMappingOperation_When();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation#getInherited <em>Inherited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inherited</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation#getInherited()
	 * @see #getMappingOperation()
	 * @generated
	 */
	EReference getMappingOperation_Inherited();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation#getMerged <em>Merged</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Merged</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation#getMerged()
	 * @see #getMappingOperation()
	 * @generated
	 */
	EReference getMappingOperation_Merged();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation#getDisjunct <em>Disjunct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Disjunct</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation#getDisjunct()
	 * @see #getMappingOperation()
	 * @generated
	 */
	EReference getMappingOperation_Disjunct();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.Helper <em>Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Helper</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.Helper
	 * @generated
	 */
	EClass getHelper();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.expressions.Helper#isIsQuery <em>Is Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Query</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.Helper#isIsQuery()
	 * @see #getHelper()
	 * @generated
	 */
	EAttribute getHelper_IsQuery();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.MappingBody <em>Mapping Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Body</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.MappingBody
	 * @generated
	 */
	EClass getMappingBody();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.MappingBody#getInitSection <em>Init Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Init Section</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.MappingBody#getInitSection()
	 * @see #getMappingBody()
	 * @generated
	 */
	EReference getMappingBody_InitSection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.MappingBody#getEndSection <em>End Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>End Section</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.MappingBody#getEndSection()
	 * @see #getMappingBody()
	 * @generated
	 */
	EReference getMappingBody_EndSection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeExpression <em>Imperative Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Expression</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeExpression
	 * @generated
	 */
	EClass getImperativeExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.AssignExp <em>Assign Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assign Exp</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.AssignExp
	 * @generated
	 */
	EClass getAssignExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.AssignExp#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.AssignExp#getValue()
	 * @see #getAssignExp()
	 * @generated
	 */
	EReference getAssignExp_Value();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.AssignExp#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.AssignExp#getLeft()
	 * @see #getAssignExp()
	 * @generated
	 */
	EReference getAssignExp_Left();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.expressions.AssignExp#isIsReset <em>Is Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Reset</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.AssignExp#isIsReset()
	 * @see #getAssignExp()
	 * @generated
	 */
	EAttribute getAssignExp_IsReset();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.VariableInitExp <em>Variable Init Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Init Exp</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.VariableInitExp
	 * @generated
	 */
	EClass getVariableInitExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.VariableInitExp#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.VariableInitExp#getValue()
	 * @see #getVariableInitExp()
	 * @generated
	 */
	EReference getVariableInitExp_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.MappingCallExp <em>Mapping Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Call Exp</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.MappingCallExp
	 * @generated
	 */
	EClass getMappingCallExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.expressions.MappingCallExp#isIsStrict <em>Is Strict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Strict</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.MappingCallExp#isIsStrict()
	 * @see #getMappingCallExp()
	 * @generated
	 */
	EAttribute getMappingCallExp_IsStrict();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.BlockExp <em>Block Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Exp</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.BlockExp
	 * @generated
	 */
	EClass getBlockExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.BlockExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Body</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.BlockExp#getBody()
	 * @see #getBlockExp()
	 * @generated
	 */
	EReference getBlockExp_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ObjectExp <em>Object Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Exp</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ObjectExp
	 * @generated
	 */
	EClass getObjectExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ObjectExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ObjectExp#getBody()
	 * @see #getObjectExp()
	 * @generated
	 */
	EReference getObjectExp_Body();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ObjectExp#getReferredObject <em>Referred Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Object</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ObjectExp#getReferredObject()
	 * @see #getObjectExp()
	 * @generated
	 */
	EReference getObjectExp_ReferredObject();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.WhileExp <em>While Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While Exp</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.WhileExp
	 * @generated
	 */
	EClass getWhileExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.WhileExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.WhileExp#getCondition()
	 * @see #getWhileExp()
	 * @generated
	 */
	EReference getWhileExp_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.WhileExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.WhileExp#getBody()
	 * @see #getWhileExp()
	 * @generated
	 */
	EReference getWhileExp_Body();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.WhileExp#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.WhileExp#getResult()
	 * @see #getWhileExp()
	 * @generated
	 */
	EReference getWhileExp_Result();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.WhileExp#getResultVar <em>Result Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result Var</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.WhileExp#getResultVar()
	 * @see #getWhileExp()
	 * @generated
	 */
	EReference getWhileExp_ResultVar();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.SwitchExp <em>Switch Exp</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Exp</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.SwitchExp
	 * @generated
	 */
    EClass getSwitchExp();

    /**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.SwitchExp#getAlternativePart <em>Alternative Part</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Alternative Part</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.SwitchExp#getAlternativePart()
	 * @see #getSwitchExp()
	 * @generated
	 */
    EReference getSwitchExp_AlternativePart();

    /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.SwitchExp#getElsePart <em>Else Part</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Part</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.SwitchExp#getElsePart()
	 * @see #getSwitchExp()
	 * @generated
	 */
    EReference getSwitchExp_ElsePart();

    /**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.AltExp <em>Alt Exp</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alt Exp</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.AltExp
	 * @generated
	 */
    EClass getAltExp();

    /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.AltExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.AltExp#getCondition()
	 * @see #getAltExp()
	 * @generated
	 */
    EReference getAltExp_Condition();

    /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.AltExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.AltExp#getBody()
	 * @see #getAltExp()
	 * @generated
	 */
    EReference getAltExp_Body();

    /**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ExtendedVisitor <em>Extended Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extended Visitor</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ExtendedVisitor
	 * @generated
	 */
	EClass getExtendedVisitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.VisitableASTNode <em>Visitable AST Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitable AST Node</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.VisitableASTNode
	 * @generated
	 */
	EClass getVisitableASTNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp <em>Resolve Exp</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolve Exp</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp
	 * @generated
	 */
    EClass getResolveExp();

    /**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp#isOne <em>One</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>One</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp#isOne()
	 * @see #getResolveExp()
	 * @generated
	 */
    EAttribute getResolveExp_One();

    /**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp#isIsInverse <em>Is Inverse</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Inverse</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp#isIsInverse()
	 * @see #getResolveExp()
	 * @generated
	 */
    EAttribute getResolveExp_IsInverse();

    /**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp#isIsDeferred <em>Is Deferred</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Deferred</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp#isIsDeferred()
	 * @see #getResolveExp()
	 * @generated
	 */
    EAttribute getResolveExp_IsDeferred();

    /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp#getTarget()
	 * @see #getResolveExp()
	 * @generated
	 */
    EReference getResolveExp_Target();

    /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp#getCondition()
	 * @see #getResolveExp()
	 * @generated
	 */
    EReference getResolveExp_Condition();

    /**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ResolveInExp <em>Resolve In Exp</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolve In Exp</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ResolveInExp
	 * @generated
	 */
    EClass getResolveInExp();

    /**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ResolveInExp#getInMappings <em>In Mappings</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Mappings</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ResolveInExp#getInMappings()
	 * @see #getResolveInExp()
	 * @generated
	 */
    EReference getResolveInExp_InMappings();

    /**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ModelType <em>Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Type</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ModelType
	 * @generated
	 */
	EClass getModelType();

				/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ModelType#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metamodel</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ModelType#getMetamodel()
	 * @see #getModelType()
	 * @generated
	 */
	EReference getModelType_Metamodel();

				/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ModelType#getAdditionalCondition <em>Additional Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Additional Condition</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ModelType#getAdditionalCondition()
	 * @see #getModelType()
	 * @generated
	 */
	EReference getModelType_AdditionalCondition();

				/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ModelType#getConformanceKind <em>Conformance Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Conformance Kind</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ModelType#getConformanceKind()
	 * @see #getModelType()
	 * @generated
	 */
	EAttribute getModelType_ConformanceKind();

				/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.PackageRef <em>Package Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Ref</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.PackageRef
	 * @generated
	 */
	EClass getPackageRef();

				/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.expressions.PackageRef#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.PackageRef#getUri()
	 * @see #getPackageRef()
	 * @generated
	 */
	EAttribute getPackageRef_Uri();

				/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.expressions.PackageRef#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.PackageRef#getName()
	 * @see #getPackageRef()
	 * @generated
	 */
	EAttribute getPackageRef_Name();

				/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.MappingParameter <em>Mapping Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Parameter</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.MappingParameter
	 * @generated
	 */
	EClass getMappingParameter();

				/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.MappingParameter#getExtent <em>Extent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extent</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.MappingParameter#getExtent()
	 * @see #getMappingParameter()
	 * @generated
	 */
	EReference getMappingParameter_Extent();

				/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.LogExp <em>Log Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Log Exp</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.LogExp
	 * @generated
	 */
	EClass getLogExp();

				/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.LogExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.LogExp#getCondition()
	 * @see #getLogExp()
	 * @generated
	 */
	EReference getLogExp_Condition();

				/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.AssertExp <em>Assert Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assert Exp</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.AssertExp
	 * @generated
	 */
	EClass getAssertExp();

				/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.AssertExp#getAssertion <em>Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assertion</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.AssertExp#getAssertion()
	 * @see #getAssertExp()
	 * @generated
	 */
	EReference getAssertExp_Assertion();

				/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.AssertExp#getLog <em>Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Log</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.AssertExp#getLog()
	 * @see #getAssertExp()
	 * @generated
	 */
	EReference getAssertExp_Log();

				/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.expressions.AssertExp#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.AssertExp#getSeverity()
	 * @see #getAssertExp()
	 * @generated
	 */
	EAttribute getAssertExp_Severity();

				/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.expressions.AssertExp#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.AssertExp#getLine()
	 * @see #getAssertExp()
	 * @generated
	 */
	EAttribute getAssertExp_Line();

				/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeLoopExp <em>Imperative Loop Exp</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Loop Exp</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeLoopExp
	 * @generated
	 */
    EClass getImperativeLoopExp();

                /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeLoopExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeLoopExp#getCondition()
	 * @see #getImperativeLoopExp()
	 * @generated
	 */
    EReference getImperativeLoopExp_Condition();

                /**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeIterateExp <em>Imperative Iterate Exp</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Iterate Exp</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeIterateExp
	 * @generated
	 */
    EClass getImperativeIterateExp();

                /**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeIterateExp#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeIterateExp#getTarget()
	 * @see #getImperativeIterateExp()
	 * @generated
	 */
    EReference getImperativeIterateExp_Target();

                /**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.InstantiationExp <em>Instantiation Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instantiation Exp</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.InstantiationExp
	 * @generated
	 */
	EClass getInstantiationExp();

																/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.internal.qvt.oml.expressions.InstantiationExp#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Argument</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.InstantiationExp#getArgument()
	 * @see #getInstantiationExp()
	 * @generated
	 */
	EReference getInstantiationExp_Argument();

																/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.InstantiationExp#getExtent <em>Extent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extent</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.InstantiationExp#getExtent()
	 * @see #getInstantiationExp()
	 * @generated
	 */
	EReference getInstantiationExp_Extent();

																/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.InstantiationExp#getInstantiatedClass <em>Instantiated Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instantiated Class</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.InstantiationExp#getInstantiatedClass()
	 * @see #getInstantiationExp()
	 * @generated
	 */
	EReference getInstantiationExp_InstantiatedClass();

																/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ReturnExp <em>Return Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return Exp</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ReturnExp
	 * @generated
	 */
	EClass getReturnExp();

																/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ReturnExp#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ReturnExp#getValue()
	 * @see #getReturnExp()
	 * @generated
	 */
	EReference getReturnExp_Value();

																/**
	 * Returns the meta object for enum '{@link org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind <em>Direction Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Direction Kind</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind
	 * @generated
	 */
	EEnum getDirectionKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.m2m.internal.qvt.oml.expressions.SeverityKind <em>Severity Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Severity Kind</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.SeverityKind
	 * @generated
	 */
	EEnum getSeverityKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExpressionsFactory getExpressionsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl <em>Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getModule()
		 * @generated
		 */
		EClass MODULE = eINSTANCE.getModule();

		/**
		 * The meta object literal for the '<em><b>Owned Renaming</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__OWNED_RENAMING = eINSTANCE.getModule_OwnedRenaming();

		/**
		 * The meta object literal for the '<em><b>Entry</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__ENTRY = eINSTANCE.getModule_Entry();

		/**
		 * The meta object literal for the '<em><b>Model Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__MODEL_PARAMETER = eINSTANCE.getModule_ModelParameter();

		/**
		 * The meta object literal for the '<em><b>Intermediate Property</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__INTERMEDIATE_PROPERTY = eINSTANCE.getModule_IntermediateProperty();

		/**
		 * The meta object literal for the '<em><b>Config Property</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__CONFIG_PROPERTY = eINSTANCE.getModule_ConfigProperty();

		/**
		 * The meta object literal for the '<em><b>Module Import</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__MODULE_IMPORT = eINSTANCE.getModule_ModuleImport();

		/**
		 * The meta object literal for the '<em><b>Used Model Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__USED_MODEL_TYPE = eINSTANCE.getModule_UsedModelType();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.LibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.LibraryImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '<em><b>Library</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__LIBRARY = eINSTANCE.getLibrary_Library();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.RenameImpl <em>Rename</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.RenameImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getRename()
		 * @generated
		 */
		EClass RENAME = eINSTANCE.getRename();

		/**
		 * The meta object literal for the '<em><b>New Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RENAME__NEW_NAME = eINSTANCE.getRename_NewName();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImportImpl <em>Module Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImportImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getModuleImport()
		 * @generated
		 */
		EClass MODULE_IMPORT = eINSTANCE.getModuleImport();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE_IMPORT__MODULE = eINSTANCE.getModuleImport_Module();

		/**
		 * The meta object literal for the '<em><b>Imported Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE_IMPORT__IMPORTED_MODULE = eINSTANCE.getModuleImport_ImportedModule();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.PropertyImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.LocalPropertyImpl <em>Local Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.LocalPropertyImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getLocalProperty()
		 * @generated
		 */
		EClass LOCAL_PROPERTY = eINSTANCE.getLocalProperty();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCAL_PROPERTY__EXPRESSION = eINSTANCE.getLocalProperty_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ConfigPropertyImpl <em>Config Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ConfigPropertyImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getConfigProperty()
		 * @generated
		 */
		EClass CONFIG_PROPERTY = eINSTANCE.getConfigProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ContextualPropertyImpl <em>Contextual Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ContextualPropertyImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getContextualProperty()
		 * @generated
		 */
		EClass CONTEXTUAL_PROPERTY = eINSTANCE.getContextualProperty();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXTUAL_PROPERTY__CONTEXT = eINSTANCE.getContextualProperty_Context();

		/**
		 * The meta object literal for the '<em><b>Overridden</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXTUAL_PROPERTY__OVERRIDDEN = eINSTANCE.getContextualProperty_Overridden();

		/**
		 * The meta object literal for the '<em><b>Init Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXTUAL_PROPERTY__INIT_EXPRESSION = eINSTANCE.getContextualProperty_InitExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeOperationImpl <em>Imperative Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeOperationImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getImperativeOperation()
		 * @generated
		 */
		EClass IMPERATIVE_OPERATION = eINSTANCE.getImperativeOperation();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPERATIVE_OPERATION__CONTEXT = eINSTANCE.getImperativeOperation_Context();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPERATIVE_OPERATION__RESULT = eINSTANCE.getImperativeOperation_Result();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPERATIVE_OPERATION__BODY = eINSTANCE.getImperativeOperation_Body();

		/**
		 * The meta object literal for the '<em><b>Is Blackbox</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPERATIVE_OPERATION__IS_BLACKBOX = eINSTANCE.getImperativeOperation_IsBlackbox();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModelParameterImpl <em>Model Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModelParameterImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getModelParameter()
		 * @generated
		 */
		EClass MODEL_PARAMETER = eINSTANCE.getModelParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.VarParameterImpl <em>Var Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.VarParameterImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getVarParameter()
		 * @generated
		 */
		EClass VAR_PARAMETER = eINSTANCE.getVarParameter();

		/**
		 * The meta object literal for the '<em><b>Ctx Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_PARAMETER__CTX_OWNER = eINSTANCE.getVarParameter_CtxOwner();

		/**
		 * The meta object literal for the '<em><b>Res Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_PARAMETER__RES_OWNER = eINSTANCE.getVarParameter_ResOwner();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR_PARAMETER__KIND = eINSTANCE.getVarParameter_Kind();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.OperationBodyImpl <em>Operation Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.OperationBodyImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getOperationBody()
		 * @generated
		 */
		EClass OPERATION_BODY = eINSTANCE.getOperationBody();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_BODY__OPERATION = eINSTANCE.getOperationBody_Operation();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_BODY__CONTENT = eINSTANCE.getOperationBody_Content();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_BODY__VARIABLE = eINSTANCE.getOperationBody_Variable();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ConstructorBodyImpl <em>Constructor Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ConstructorBodyImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getConstructorBody()
		 * @generated
		 */
		EClass CONSTRUCTOR_BODY = eINSTANCE.getConstructorBody();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.MappingOperationImpl <em>Mapping Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.MappingOperationImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getMappingOperation()
		 * @generated
		 */
		EClass MAPPING_OPERATION = eINSTANCE.getMappingOperation();

		/**
		 * The meta object literal for the '<em><b>When</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_OPERATION__WHEN = eINSTANCE.getMappingOperation_When();

		/**
		 * The meta object literal for the '<em><b>Inherited</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_OPERATION__INHERITED = eINSTANCE.getMappingOperation_Inherited();

		/**
		 * The meta object literal for the '<em><b>Merged</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_OPERATION__MERGED = eINSTANCE.getMappingOperation_Merged();

		/**
		 * The meta object literal for the '<em><b>Disjunct</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_OPERATION__DISJUNCT = eINSTANCE.getMappingOperation_Disjunct();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.HelperImpl <em>Helper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.HelperImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getHelper()
		 * @generated
		 */
		EClass HELPER = eINSTANCE.getHelper();

		/**
		 * The meta object literal for the '<em><b>Is Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HELPER__IS_QUERY = eINSTANCE.getHelper_IsQuery();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.MappingBodyImpl <em>Mapping Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.MappingBodyImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getMappingBody()
		 * @generated
		 */
		EClass MAPPING_BODY = eINSTANCE.getMappingBody();

		/**
		 * The meta object literal for the '<em><b>Init Section</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_BODY__INIT_SECTION = eINSTANCE.getMappingBody_InitSection();

		/**
		 * The meta object literal for the '<em><b>End Section</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_BODY__END_SECTION = eINSTANCE.getMappingBody_EndSection();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeExpressionImpl <em>Imperative Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeExpressionImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getImperativeExpression()
		 * @generated
		 */
		EClass IMPERATIVE_EXPRESSION = eINSTANCE.getImperativeExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.AssignExpImpl <em>Assign Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.AssignExpImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getAssignExp()
		 * @generated
		 */
		EClass ASSIGN_EXP = eINSTANCE.getAssignExp();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_EXP__VALUE = eINSTANCE.getAssignExp_Value();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_EXP__LEFT = eINSTANCE.getAssignExp_Left();

		/**
		 * The meta object literal for the '<em><b>Is Reset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGN_EXP__IS_RESET = eINSTANCE.getAssignExp_IsReset();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.VariableInitExpImpl <em>Variable Init Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.VariableInitExpImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getVariableInitExp()
		 * @generated
		 */
		EClass VARIABLE_INIT_EXP = eINSTANCE.getVariableInitExp();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_INIT_EXP__VALUE = eINSTANCE.getVariableInitExp_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.MappingCallExpImpl <em>Mapping Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.MappingCallExpImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getMappingCallExp()
		 * @generated
		 */
		EClass MAPPING_CALL_EXP = eINSTANCE.getMappingCallExp();

		/**
		 * The meta object literal for the '<em><b>Is Strict</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_CALL_EXP__IS_STRICT = eINSTANCE.getMappingCallExp_IsStrict();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.BlockExpImpl <em>Block Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.BlockExpImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getBlockExp()
		 * @generated
		 */
		EClass BLOCK_EXP = eINSTANCE.getBlockExp();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_EXP__BODY = eINSTANCE.getBlockExp_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ObjectExpImpl <em>Object Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ObjectExpImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getObjectExp()
		 * @generated
		 */
		EClass OBJECT_EXP = eINSTANCE.getObjectExp();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_EXP__BODY = eINSTANCE.getObjectExp_Body();

		/**
		 * The meta object literal for the '<em><b>Referred Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_EXP__REFERRED_OBJECT = eINSTANCE.getObjectExp_ReferredObject();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.WhileExpImpl <em>While Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.WhileExpImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getWhileExp()
		 * @generated
		 */
		EClass WHILE_EXP = eINSTANCE.getWhileExp();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_EXP__CONDITION = eINSTANCE.getWhileExp_Condition();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_EXP__BODY = eINSTANCE.getWhileExp_Body();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_EXP__RESULT = eINSTANCE.getWhileExp_Result();

		/**
		 * The meta object literal for the '<em><b>Result Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_EXP__RESULT_VAR = eINSTANCE.getWhileExp_ResultVar();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.SwitchExpImpl <em>Switch Exp</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.SwitchExpImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getSwitchExp()
		 * @generated
		 */
        EClass SWITCH_EXP = eINSTANCE.getSwitchExp();

        /**
		 * The meta object literal for the '<em><b>Alternative Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference SWITCH_EXP__ALTERNATIVE_PART = eINSTANCE.getSwitchExp_AlternativePart();

        /**
		 * The meta object literal for the '<em><b>Else Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference SWITCH_EXP__ELSE_PART = eINSTANCE.getSwitchExp_ElsePart();

        /**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.AltExpImpl <em>Alt Exp</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.AltExpImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getAltExp()
		 * @generated
		 */
        EClass ALT_EXP = eINSTANCE.getAltExp();

        /**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference ALT_EXP__CONDITION = eINSTANCE.getAltExp_Condition();

        /**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference ALT_EXP__BODY = eINSTANCE.getAltExp_Body();

        /**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ExtendedVisitor <em>Extended Visitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ExtendedVisitor
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getExtendedVisitor()
		 * @generated
		 */
		EClass EXTENDED_VISITOR = eINSTANCE.getExtendedVisitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.VisitableASTNode <em>Visitable AST Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.VisitableASTNode
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getVisitableASTNode()
		 * @generated
		 */
		EClass VISITABLE_AST_NODE = eINSTANCE.getVisitableASTNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ResolveExpImpl <em>Resolve Exp</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ResolveExpImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getResolveExp()
		 * @generated
		 */
        EClass RESOLVE_EXP = eINSTANCE.getResolveExp();

        /**
		 * The meta object literal for the '<em><b>One</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute RESOLVE_EXP__ONE = eINSTANCE.getResolveExp_One();

        /**
		 * The meta object literal for the '<em><b>Is Inverse</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute RESOLVE_EXP__IS_INVERSE = eINSTANCE.getResolveExp_IsInverse();

        /**
		 * The meta object literal for the '<em><b>Is Deferred</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute RESOLVE_EXP__IS_DEFERRED = eINSTANCE.getResolveExp_IsDeferred();

        /**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference RESOLVE_EXP__TARGET = eINSTANCE.getResolveExp_Target();

        /**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference RESOLVE_EXP__CONDITION = eINSTANCE.getResolveExp_Condition();

        /**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ResolveInExpImpl <em>Resolve In Exp</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ResolveInExpImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getResolveInExp()
		 * @generated
		 */
        EClass RESOLVE_IN_EXP = eINSTANCE.getResolveInExp();

        /**
		 * The meta object literal for the '<em><b>In Mappings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference RESOLVE_IN_EXP__IN_MAPPINGS = eINSTANCE.getResolveInExp_InMappings();

        /**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModelTypeImpl <em>Model Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModelTypeImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getModelType()
		 * @generated
		 */
		EClass MODEL_TYPE = eINSTANCE.getModelType();

								/**
		 * The meta object literal for the '<em><b>Metamodel</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE__METAMODEL = eINSTANCE.getModelType_Metamodel();

								/**
		 * The meta object literal for the '<em><b>Additional Condition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE__ADDITIONAL_CONDITION = eINSTANCE.getModelType_AdditionalCondition();

								/**
		 * The meta object literal for the '<em><b>Conformance Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_TYPE__CONFORMANCE_KIND = eINSTANCE.getModelType_ConformanceKind();

								/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.PackageRefImpl <em>Package Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.PackageRefImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getPackageRef()
		 * @generated
		 */
		EClass PACKAGE_REF = eINSTANCE.getPackageRef();

								/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_REF__URI = eINSTANCE.getPackageRef_Uri();

								/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_REF__NAME = eINSTANCE.getPackageRef_Name();

								/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.MappingParameterImpl <em>Mapping Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.MappingParameterImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getMappingParameter()
		 * @generated
		 */
		EClass MAPPING_PARAMETER = eINSTANCE.getMappingParameter();

								/**
		 * The meta object literal for the '<em><b>Extent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_PARAMETER__EXTENT = eINSTANCE.getMappingParameter_Extent();

								/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.LogExpImpl <em>Log Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.LogExpImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getLogExp()
		 * @generated
		 */
		EClass LOG_EXP = eINSTANCE.getLogExp();

								/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOG_EXP__CONDITION = eINSTANCE.getLogExp_Condition();

								/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.AssertExpImpl <em>Assert Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.AssertExpImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getAssertExp()
		 * @generated
		 */
		EClass ASSERT_EXP = eINSTANCE.getAssertExp();

								/**
		 * The meta object literal for the '<em><b>Assertion</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSERT_EXP__ASSERTION = eINSTANCE.getAssertExp_Assertion();

								/**
		 * The meta object literal for the '<em><b>Log</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSERT_EXP__LOG = eINSTANCE.getAssertExp_Log();

								/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT_EXP__SEVERITY = eINSTANCE.getAssertExp_Severity();

								/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT_EXP__LINE = eINSTANCE.getAssertExp_Line();

								/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeLoopExpImpl <em>Imperative Loop Exp</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeLoopExpImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getImperativeLoopExp()
		 * @generated
		 */
        EClass IMPERATIVE_LOOP_EXP = eINSTANCE.getImperativeLoopExp();

                                /**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference IMPERATIVE_LOOP_EXP__CONDITION = eINSTANCE.getImperativeLoopExp_Condition();

                                /**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeIterateExpImpl <em>Imperative Iterate Exp</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeIterateExpImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getImperativeIterateExp()
		 * @generated
		 */
        EClass IMPERATIVE_ITERATE_EXP = eINSTANCE.getImperativeIterateExp();

                                /**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference IMPERATIVE_ITERATE_EXP__TARGET = eINSTANCE.getImperativeIterateExp_Target();

                                /**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.InstantiationExpImpl <em>Instantiation Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.InstantiationExpImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getInstantiationExp()
		 * @generated
		 */
		EClass INSTANTIATION_EXP = eINSTANCE.getInstantiationExp();

																																/**
		 * The meta object literal for the '<em><b>Argument</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATION_EXP__ARGUMENT = eINSTANCE.getInstantiationExp_Argument();

																																/**
		 * The meta object literal for the '<em><b>Extent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATION_EXP__EXTENT = eINSTANCE.getInstantiationExp_Extent();

																																/**
		 * The meta object literal for the '<em><b>Instantiated Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATION_EXP__INSTANTIATED_CLASS = eINSTANCE.getInstantiationExp_InstantiatedClass();

																																/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ReturnExpImpl <em>Return Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ReturnExpImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getReturnExp()
		 * @generated
		 */
		EClass RETURN_EXP = eINSTANCE.getReturnExp();

																																/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETURN_EXP__VALUE = eINSTANCE.getReturnExp_Value();

																																/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind <em>Direction Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getDirectionKind()
		 * @generated
		 */
		EEnum DIRECTION_KIND = eINSTANCE.getDirectionKind();

								/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.SeverityKind <em>Severity Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.SeverityKind
		 * @see org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsPackageImpl#getSeverityKind()
		 * @generated
		 */
		EEnum SEVERITY_KIND = eINSTANCE.getSeverityKind();

	}

} //ExpressionsPackage
