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
 * $Id: CSTPackage.java,v 1.8 2008/02/01 10:56:00 aigdalov Exp $
 */
package org.eclipse.m2m.qvt.oml.internal.cst;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory
 * @model kind="package"
 * @generated
 */
public interface CSTPackage extends EPackage {
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
    String eNAME = "cst"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.eclipse.org/QVT2/1.0.0/Operational/cst"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "qvtoperational.cst"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    CSTPackage eINSTANCE = org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingModuleCSImpl <em>Mapping Module CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingModuleCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingModuleCS()
     * @generated
     */
    int MAPPING_MODULE_CS = 0;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_MODULE_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_MODULE_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

    /**
     * The feature id for the '<em><b>Header CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAPPING_MODULE_CS__HEADER_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Imports</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_MODULE_CS__IMPORTS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Metamodels</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_MODULE_CS__METAMODELS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Renamings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_MODULE_CS__RENAMINGS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_MODULE_CS__PROPERTIES = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Methods</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_MODULE_CS__METHODS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Mapping Module CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_MODULE_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.LibraryCSImpl <em>Library CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.LibraryCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getLibraryCS()
     * @generated
     */
    int LIBRARY_CS = 1;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIBRARY_CS__START_OFFSET = MAPPING_MODULE_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIBRARY_CS__END_OFFSET = MAPPING_MODULE_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Header CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LIBRARY_CS__HEADER_CS = MAPPING_MODULE_CS__HEADER_CS;

				/**
     * The feature id for the '<em><b>Imports</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIBRARY_CS__IMPORTS = MAPPING_MODULE_CS__IMPORTS;

    /**
     * The feature id for the '<em><b>Metamodels</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIBRARY_CS__METAMODELS = MAPPING_MODULE_CS__METAMODELS;

    /**
     * The feature id for the '<em><b>Renamings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIBRARY_CS__RENAMINGS = MAPPING_MODULE_CS__RENAMINGS;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIBRARY_CS__PROPERTIES = MAPPING_MODULE_CS__PROPERTIES;

    /**
     * The feature id for the '<em><b>Methods</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIBRARY_CS__METHODS = MAPPING_MODULE_CS__METHODS;

    /**
     * The number of structural features of the '<em>Library CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIBRARY_CS_FEATURE_COUNT = MAPPING_MODULE_CS_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ImportCSImpl <em>Import CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ImportCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getImportCS()
     * @generated
     */
    int IMPORT_CS = 2;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPORT_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPORT_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

    /**
     * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPORT_CS__PATH_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Import CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPORT_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ModuleImportCSImpl <em>Module Import CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ModuleImportCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getModuleImportCS()
     * @generated
     */
    int MODULE_IMPORT_CS = 3;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODULE_IMPORT_CS__START_OFFSET = IMPORT_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODULE_IMPORT_CS__END_OFFSET = IMPORT_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODULE_IMPORT_CS__PATH_NAME_CS = IMPORT_CS__PATH_NAME_CS;

    /**
     * The number of structural features of the '<em>Module Import CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODULE_IMPORT_CS_FEATURE_COUNT = IMPORT_CS_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.LibraryImportCSImpl <em>Library Import CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.LibraryImportCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getLibraryImportCS()
     * @generated
     */
    int LIBRARY_IMPORT_CS = 4;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIBRARY_IMPORT_CS__START_OFFSET = IMPORT_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIBRARY_IMPORT_CS__END_OFFSET = IMPORT_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIBRARY_IMPORT_CS__PATH_NAME_CS = IMPORT_CS__PATH_NAME_CS;

    /**
     * The number of structural features of the '<em>Library Import CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIBRARY_IMPORT_CS_FEATURE_COUNT = IMPORT_CS_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.RenameCSImpl <em>Rename CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.RenameCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getRenameCS()
     * @generated
     */
    int RENAME_CS = 5;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RENAME_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RENAME_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

    /**
     * The feature id for the '<em><b>Type CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RENAME_CS__TYPE_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RENAME_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Original Name</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RENAME_CS__ORIGINAL_NAME = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Rename CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RENAME_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ModulePropertyCSImpl <em>Module Property CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ModulePropertyCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getModulePropertyCS()
     * @generated
     */
    int MODULE_PROPERTY_CS = 6;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODULE_PROPERTY_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODULE_PROPERTY_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

    /**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODULE_PROPERTY_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Module Property CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODULE_PROPERTY_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ConfigPropertyCSImpl <em>Config Property CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ConfigPropertyCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getConfigPropertyCS()
     * @generated
     */
    int CONFIG_PROPERTY_CS = 7;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIG_PROPERTY_CS__START_OFFSET = MODULE_PROPERTY_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIG_PROPERTY_CS__END_OFFSET = MODULE_PROPERTY_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIG_PROPERTY_CS__SIMPLE_NAME_CS = MODULE_PROPERTY_CS__SIMPLE_NAME_CS;

    /**
     * The feature id for the '<em><b>Type CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIG_PROPERTY_CS__TYPE_CS = MODULE_PROPERTY_CS_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Config Property CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIG_PROPERTY_CS_FEATURE_COUNT = MODULE_PROPERTY_CS_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.LocalPropertyCSImpl <em>Local Property CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.LocalPropertyCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getLocalPropertyCS()
     * @generated
     */
    int LOCAL_PROPERTY_CS = 8;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL_PROPERTY_CS__START_OFFSET = MODULE_PROPERTY_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL_PROPERTY_CS__END_OFFSET = MODULE_PROPERTY_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL_PROPERTY_CS__SIMPLE_NAME_CS = MODULE_PROPERTY_CS__SIMPLE_NAME_CS;

    /**
     * The feature id for the '<em><b>Type CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL_PROPERTY_CS__TYPE_CS = MODULE_PROPERTY_CS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Ocl Expression CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL_PROPERTY_CS__OCL_EXPRESSION_CS = MODULE_PROPERTY_CS_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Local Property CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL_PROPERTY_CS_FEATURE_COUNT = MODULE_PROPERTY_CS_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingDeclarationCSImpl <em>Mapping Declaration CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingDeclarationCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingDeclarationCS()
     * @generated
     */
    int MAPPING_DECLARATION_CS = 9;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_DECLARATION_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_DECLARATION_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

    /**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_DECLARATION_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Context Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_DECLARATION_CS__CONTEXT_TYPE = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Context Type And Name</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_DECLARATION_CS__CONTEXT_TYPE_AND_NAME = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_DECLARATION_CS__PARAMETERS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Return Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_DECLARATION_CS__RETURN_TYPE = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Black Box</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_DECLARATION_CS__BLACK_BOX = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Direction Kind CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAPPING_DECLARATION_CS__DIRECTION_KIND_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 6;

				/**
     * The number of structural features of the '<em>Mapping Declaration CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_DECLARATION_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 7;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ParameterDeclarationCSImpl <em>Parameter Declaration CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ParameterDeclarationCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getParameterDeclarationCS()
     * @generated
     */
    int PARAMETER_DECLARATION_CS = 10;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMETER_DECLARATION_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMETER_DECLARATION_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

    /**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Type Spec CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETER_DECLARATION_CS__TYPE_SPEC_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

				/**
     * The feature id for the '<em><b>Direction Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMETER_DECLARATION_CS__DIRECTION_KIND = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Parameter Declaration CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAMETER_DECLARATION_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingMethodCSImpl <em>Mapping Method CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingMethodCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingMethodCS()
     * @generated
     */
    int MAPPING_METHOD_CS = 11;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_METHOD_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_METHOD_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

    /**
     * The feature id for the '<em><b>Mapping Declaration CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_METHOD_CS__MAPPING_DECLARATION_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Mapping Method CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_METHOD_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingRuleCSImpl <em>Mapping Rule CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingRuleCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingRuleCS()
     * @generated
     */
    int MAPPING_RULE_CS = 12;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_RULE_CS__START_OFFSET = MAPPING_METHOD_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_RULE_CS__END_OFFSET = MAPPING_METHOD_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Mapping Declaration CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_RULE_CS__MAPPING_DECLARATION_CS = MAPPING_METHOD_CS__MAPPING_DECLARATION_CS;

    /**
     * The feature id for the '<em><b>Guard</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_RULE_CS__GUARD = MAPPING_METHOD_CS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Mapping Init CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_RULE_CS__MAPPING_INIT_CS = MAPPING_METHOD_CS_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Mapping Body CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_RULE_CS__MAPPING_BODY_CS = MAPPING_METHOD_CS_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Mapping End CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_RULE_CS__MAPPING_END_CS = MAPPING_METHOD_CS_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Mapping Rule CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_RULE_CS_FEATURE_COUNT = MAPPING_METHOD_CS_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingQueryCSImpl <em>Mapping Query CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingQueryCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingQueryCS()
     * @generated
     */
    int MAPPING_QUERY_CS = 13;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_QUERY_CS__START_OFFSET = MAPPING_METHOD_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_QUERY_CS__END_OFFSET = MAPPING_METHOD_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Mapping Declaration CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_QUERY_CS__MAPPING_DECLARATION_CS = MAPPING_METHOD_CS__MAPPING_DECLARATION_CS;

    /**
     * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_QUERY_CS__EXPRESSIONS = MAPPING_METHOD_CS_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Mapping Query CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_QUERY_CS_FEATURE_COUNT = MAPPING_METHOD_CS_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingSectionCSImpl <em>Mapping Section CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingSectionCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingSectionCS()
     * @generated
     */
    int MAPPING_SECTION_CS = 14;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_SECTION_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_SECTION_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

    /**
     * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_SECTION_CS__BODY_START_LOCATION = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Body End Location</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_SECTION_CS__BODY_END_LOCATION = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Statements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_SECTION_CS__STATEMENTS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Mapping Rule CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_SECTION_CS__MAPPING_RULE_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Mapping Section CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_SECTION_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingInitCSImpl <em>Mapping Init CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingInitCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingInitCS()
     * @generated
     */
    int MAPPING_INIT_CS = 15;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_INIT_CS__START_OFFSET = MAPPING_SECTION_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_INIT_CS__END_OFFSET = MAPPING_SECTION_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_INIT_CS__BODY_START_LOCATION = MAPPING_SECTION_CS__BODY_START_LOCATION;

    /**
     * The feature id for the '<em><b>Body End Location</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_INIT_CS__BODY_END_LOCATION = MAPPING_SECTION_CS__BODY_END_LOCATION;

    /**
     * The feature id for the '<em><b>Statements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_INIT_CS__STATEMENTS = MAPPING_SECTION_CS__STATEMENTS;

    /**
     * The feature id for the '<em><b>Mapping Rule CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_INIT_CS__MAPPING_RULE_CS = MAPPING_SECTION_CS__MAPPING_RULE_CS;

    /**
     * The number of structural features of the '<em>Mapping Init CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_INIT_CS_FEATURE_COUNT = MAPPING_SECTION_CS_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingEndCSImpl <em>Mapping End CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingEndCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingEndCS()
     * @generated
     */
    int MAPPING_END_CS = 16;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_END_CS__START_OFFSET = MAPPING_SECTION_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_END_CS__END_OFFSET = MAPPING_SECTION_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_END_CS__BODY_START_LOCATION = MAPPING_SECTION_CS__BODY_START_LOCATION;

    /**
     * The feature id for the '<em><b>Body End Location</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_END_CS__BODY_END_LOCATION = MAPPING_SECTION_CS__BODY_END_LOCATION;

    /**
     * The feature id for the '<em><b>Statements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_END_CS__STATEMENTS = MAPPING_SECTION_CS__STATEMENTS;

    /**
     * The feature id for the '<em><b>Mapping Rule CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_END_CS__MAPPING_RULE_CS = MAPPING_SECTION_CS__MAPPING_RULE_CS;

    /**
     * The number of structural features of the '<em>Mapping End CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_END_CS_FEATURE_COUNT = MAPPING_SECTION_CS_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.StatementCSImpl <em>Statement CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.StatementCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getStatementCS()
     * @generated
     */
    int STATEMENT_CS = 17;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATEMENT_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATEMENT_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__END_OFFSET;

    /**
     * The number of structural features of the '<em>Statement CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATEMENT_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.AssignStatementCSImpl <em>Assign Statement CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.AssignStatementCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getAssignStatementCS()
     * @generated
     */
    int ASSIGN_STATEMENT_CS = 18;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSIGN_STATEMENT_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSIGN_STATEMENT_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>LValue CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSIGN_STATEMENT_CS__LVALUE_CS = STATEMENT_CS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Ocl Expression CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS = STATEMENT_CS_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Incremental</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSIGN_STATEMENT_CS__INCREMENTAL = STATEMENT_CS_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Assign Statement CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASSIGN_STATEMENT_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ExpressionStatementCSImpl <em>Expression Statement CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ExpressionStatementCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getExpressionStatementCS()
     * @generated
     */
    int EXPRESSION_STATEMENT_CS = 19;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_STATEMENT_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_STATEMENT_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Ocl Expression CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_STATEMENT_CS__OCL_EXPRESSION_CS = STATEMENT_CS_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Expression Statement CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_STATEMENT_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.VariableInitializationCSImpl <em>Variable Initialization CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.VariableInitializationCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getVariableInitializationCS()
     * @generated
     */
    int VARIABLE_INITIALIZATION_CS = 20;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIABLE_INITIALIZATION_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIABLE_INITIALIZATION_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Ocl Expression CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIABLE_INITIALIZATION_CS__OCL_EXPRESSION_CS = STATEMENT_CS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIABLE_INITIALIZATION_CS__SIMPLE_NAME_CS = STATEMENT_CS_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Type CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIABLE_INITIALIZATION_CS__TYPE_CS = STATEMENT_CS_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Variable Initialization CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIABLE_INITIALIZATION_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingBodyCSImpl <em>Mapping Body CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingBodyCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingBodyCS()
     * @generated
     */
    int MAPPING_BODY_CS = 21;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_BODY_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_BODY_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Out Exp CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_BODY_CS__OUT_EXP_CS = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Short</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_BODY_CS__SHORT = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Mapping Body CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_BODY_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.OutExpCSImpl <em>Out Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.OutExpCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getOutExpCS()
     * @generated
     */
    int OUT_EXP_CS = 22;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUT_EXP_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUT_EXP_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUT_EXP_CS__BODY_START_LOCATION = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Body End Location</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUT_EXP_CS__BODY_END_LOCATION = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUT_EXP_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Type Spec CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OUT_EXP_CS__TYPE_SPEC_CS = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 3;

				/**
     * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUT_EXP_CS__EXPRESSIONS = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Out Exp CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUT_EXP_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.PatternPropertyExpCSImpl <em>Pattern Property Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.PatternPropertyExpCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getPatternPropertyExpCS()
     * @generated
     */
    int PATTERN_PROPERTY_EXP_CS = 23;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_PROPERTY_EXP_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_PROPERTY_EXP_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_PROPERTY_EXP_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Ocl Expression CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_PROPERTY_EXP_CS__OCL_EXPRESSION_CS = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Incremental</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_PROPERTY_EXP_CS__INCREMENTAL = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Pattern Property Exp CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_PROPERTY_EXP_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingCallExpCSImpl <em>Mapping Call Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingCallExpCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingCallExpCS()
     * @generated
     */
    int MAPPING_CALL_EXP_CS = 24;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_CALL_EXP_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_CALL_EXP_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_CALL_EXP_CS__SOURCE = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__SOURCE;

    /**
     * The feature id for the '<em><b>Accessor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_CALL_EXP_CS__ACCESSOR = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__ACCESSOR;

    /**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_CALL_EXP_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__SIMPLE_NAME_CS;

    /**
     * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_CALL_EXP_CS__ARGUMENTS = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__ARGUMENTS;

    /**
     * The feature id for the '<em><b>Is Marked Pre CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_CALL_EXP_CS__IS_MARKED_PRE_CS = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__IS_MARKED_PRE_CS;

    /**
     * The feature id for the '<em><b>Strict</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_CALL_EXP_CS__STRICT = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Mapping Call Exp CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPING_CALL_EXP_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.WhileExpCSImpl <em>While Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.WhileExpCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getWhileExpCS()
     * @generated
     */
    int WHILE_EXP_CS = 25;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WHILE_EXP_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WHILE_EXP_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Body</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int WHILE_EXP_CS__BODY = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WHILE_EXP_CS__CONDITION = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Result</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WHILE_EXP_CS__RESULT = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Result Var</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int WHILE_EXP_CS__RESULT_VAR = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 3;

				/**
     * The number of structural features of the '<em>While Exp CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WHILE_EXP_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.SwitchExpCSImpl <em>Switch Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.SwitchExpCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getSwitchExpCS()
     * @generated
     */
    int SWITCH_EXP_CS = 26;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SWITCH_EXP_CS__START_OFFSET = STATEMENT_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SWITCH_EXP_CS__END_OFFSET = STATEMENT_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Alternative Part</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SWITCH_EXP_CS__ALTERNATIVE_PART = STATEMENT_CS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Else Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SWITCH_EXP_CS__ELSE_PART = STATEMENT_CS_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Switch Exp CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SWITCH_EXP_CS_FEATURE_COUNT = STATEMENT_CS_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.SwitchAltExpCSImpl <em>Switch Alt Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.SwitchAltExpCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getSwitchAltExpCS()
     * @generated
     */
    int SWITCH_ALT_EXP_CS = 27;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SWITCH_ALT_EXP_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SWITCH_ALT_EXP_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

    /**
     * The feature id for the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SWITCH_ALT_EXP_CS__CONDITION = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Body</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SWITCH_ALT_EXP_CS__BODY = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Switch Alt Exp CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SWITCH_ALT_EXP_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.BlockExpCSImpl <em>Block Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.BlockExpCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getBlockExpCS()
     * @generated
     */
	int BLOCK_EXP_CS = 28;

				/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BLOCK_EXP_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__START_OFFSET;

				/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BLOCK_EXP_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__END_OFFSET;

				/**
     * The feature id for the '<em><b>Body Expressions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BLOCK_EXP_CS__BODY_EXPRESSIONS = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>Block Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BLOCK_EXP_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

				/**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.DirectionKindCSImpl <em>Direction Kind CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.DirectionKindCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getDirectionKindCS()
     * @generated
     */
    int DIRECTION_KIND_CS = 29;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIRECTION_KIND_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIRECTION_KIND_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

    /**
     * The feature id for the '<em><b>Direction Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIRECTION_KIND_CS__DIRECTION_KIND = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Direction Kind CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIRECTION_KIND_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ElementWithBodyImpl <em>Element With Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ElementWithBodyImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getElementWithBody()
     * @generated
     */
    int ELEMENT_WITH_BODY = 30;

    /**
     * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_WITH_BODY__BODY_START_LOCATION = 0;

    /**
     * The feature id for the '<em><b>Body End Location</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_WITH_BODY__BODY_END_LOCATION = 1;

    /**
     * The number of structural features of the '<em>Element With Body</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_WITH_BODY_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ResolveExpCSImpl <em>Resolve Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ResolveExpCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getResolveExpCS()
     * @generated
     */
    int RESOLVE_EXP_CS = 31;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_EXP_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_EXP_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_EXP_CS__SOURCE = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS__SOURCE;

    /**
     * The feature id for the '<em><b>Accessor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_EXP_CS__ACCESSOR = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS__ACCESSOR;

    /**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_EXP_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS__SIMPLE_NAME_CS;

    /**
     * The feature id for the '<em><b>One</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_EXP_CS__ONE = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Is Inverse</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_EXP_CS__IS_INVERSE = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Is Deferred</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_EXP_CS__IS_DEFERRED = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Target</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_EXP_CS__TARGET = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_EXP_CS__CONDITION = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Resolve Exp CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_EXP_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CALL_EXP_CS_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ResolveInExpCSImpl <em>Resolve In Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ResolveInExpCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getResolveInExpCS()
     * @generated
     */
    int RESOLVE_IN_EXP_CS = 32;

    /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_IN_EXP_CS__START_OFFSET = RESOLVE_EXP_CS__START_OFFSET;

    /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_IN_EXP_CS__END_OFFSET = RESOLVE_EXP_CS__END_OFFSET;

    /**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_IN_EXP_CS__SOURCE = RESOLVE_EXP_CS__SOURCE;

    /**
     * The feature id for the '<em><b>Accessor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_IN_EXP_CS__ACCESSOR = RESOLVE_EXP_CS__ACCESSOR;

    /**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_IN_EXP_CS__SIMPLE_NAME_CS = RESOLVE_EXP_CS__SIMPLE_NAME_CS;

    /**
     * The feature id for the '<em><b>One</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_IN_EXP_CS__ONE = RESOLVE_EXP_CS__ONE;

    /**
     * The feature id for the '<em><b>Is Inverse</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_IN_EXP_CS__IS_INVERSE = RESOLVE_EXP_CS__IS_INVERSE;

    /**
     * The feature id for the '<em><b>Is Deferred</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_IN_EXP_CS__IS_DEFERRED = RESOLVE_EXP_CS__IS_DEFERRED;

    /**
     * The feature id for the '<em><b>Target</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_IN_EXP_CS__TARGET = RESOLVE_EXP_CS__TARGET;

    /**
     * The feature id for the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_IN_EXP_CS__CONDITION = RESOLVE_EXP_CS__CONDITION;

    /**
     * The feature id for the '<em><b>In Mapping Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_IN_EXP_CS__IN_MAPPING_TYPE = RESOLVE_EXP_CS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>In Mapping Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_IN_EXP_CS__IN_MAPPING_NAME = RESOLVE_EXP_CS_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Resolve In Exp CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESOLVE_IN_EXP_CS_FEATURE_COUNT = RESOLVE_EXP_CS_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ModelTypeCSImpl <em>Model Type CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ModelTypeCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getModelTypeCS()
     * @generated
     */
	int MODEL_TYPE_CS = 33;

				/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODEL_TYPE_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

				/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODEL_TYPE_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

				/**
     * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODEL_TYPE_CS__BODY_START_LOCATION = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Body End Location</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODEL_TYPE_CS__BODY_END_LOCATION = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

				/**
     * The feature id for the '<em><b>Identifier CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODEL_TYPE_CS__IDENTIFIER_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

				/**
     * The feature id for the '<em><b>Compliance Kind CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODEL_TYPE_CS__COMPLIANCE_KIND_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

				/**
     * The feature id for the '<em><b>Package Refs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODEL_TYPE_CS__PACKAGE_REFS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 4;

				/**
     * The feature id for the '<em><b>Where Statements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODEL_TYPE_CS__WHERE_STATEMENTS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 5;

				/**
     * The number of structural features of the '<em>Model Type CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODEL_TYPE_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 6;

				/**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.PackageRefCSImpl <em>Package Ref CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.PackageRefCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getPackageRefCS()
     * @generated
     */
	int PACKAGE_REF_CS = 34;

				/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_REF_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

				/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_REF_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

				/**
     * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_REF_CS__PATH_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Uri CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_REF_CS__URI_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

				/**
     * The number of structural features of the '<em>Package Ref CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_REF_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

				/**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.TransformationHeaderCSImpl <em>Transformation Header CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.TransformationHeaderCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getTransformationHeaderCS()
     * @generated
     */
	int TRANSFORMATION_HEADER_CS = 35;

				/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSFORMATION_HEADER_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

				/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSFORMATION_HEADER_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

				/**
     * The feature id for the '<em><b>Qualifiers</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSFORMATION_HEADER_CS__QUALIFIERS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSFORMATION_HEADER_CS__PATH_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

				/**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSFORMATION_HEADER_CS__PARAMETERS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

				/**
     * The feature id for the '<em><b>Module Usages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSFORMATION_HEADER_CS__MODULE_USAGES = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

				/**
     * The feature id for the '<em><b>Transformation Refine CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 4;

				/**
     * The number of structural features of the '<em>Transformation Header CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSFORMATION_HEADER_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 5;

				/**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ModuleKindCSImpl <em>Module Kind CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ModuleKindCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getModuleKindCS()
     * @generated
     */
	int MODULE_KIND_CS = 36;

				/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODULE_KIND_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

				/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODULE_KIND_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

				/**
     * The feature id for the '<em><b>Module Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODULE_KIND_CS__MODULE_KIND = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>Module Kind CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODULE_KIND_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

				/**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ModuleRefCSImpl <em>Module Ref CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ModuleRefCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getModuleRefCS()
     * @generated
     */
	int MODULE_REF_CS = 37;

				/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODULE_REF_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

				/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODULE_REF_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

				/**
     * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODULE_REF_CS__PATH_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODULE_REF_CS__PARAMETERS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

				/**
     * The number of structural features of the '<em>Module Ref CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODULE_REF_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

				/**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ModuleUsageCSImpl <em>Module Usage CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ModuleUsageCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getModuleUsageCS()
     * @generated
     */
	int MODULE_USAGE_CS = 38;

				/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODULE_USAGE_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

				/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODULE_USAGE_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

				/**
     * The feature id for the '<em><b>Import Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODULE_USAGE_CS__IMPORT_KIND = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Module Kind CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODULE_USAGE_CS__MODULE_KIND_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

				/**
     * The feature id for the '<em><b>Module Refs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODULE_USAGE_CS__MODULE_REFS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

				/**
     * The number of structural features of the '<em>Module Usage CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODULE_USAGE_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 3;

				/**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.TransformationRefineCSImpl <em>Transformation Refine CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.TransformationRefineCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getTransformationRefineCS()
     * @generated
     */
	int TRANSFORMATION_REFINE_CS = 39;

				/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSFORMATION_REFINE_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

				/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSFORMATION_REFINE_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

				/**
     * The feature id for the '<em><b>Module Ref CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSFORMATION_REFINE_CS__MODULE_REF_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

				/**
     * The number of structural features of the '<em>Transformation Refine CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSFORMATION_REFINE_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

				/**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.TypeSpecCSImpl <em>Type Spec CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.TypeSpecCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getTypeSpecCS()
     * @generated
     */
	int TYPE_SPEC_CS = 40;

				/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_SPEC_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__START_OFFSET;

				/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_SPEC_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.CST_NODE__END_OFFSET;

				/**
     * The feature id for the '<em><b>Type CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_SPEC_CS__TYPE_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_SPEC_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 1;

				/**
     * The number of structural features of the '<em>Type Spec CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_SPEC_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.CST_NODE_FEATURE_COUNT + 2;

				/**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.LogExpCSImpl <em>Log Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.LogExpCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getLogExpCS()
     * @generated
     */
	int LOG_EXP_CS = 41;

				/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOG_EXP_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__START_OFFSET;

				/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOG_EXP_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__END_OFFSET;

				/**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOG_EXP_CS__SOURCE = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__SOURCE;

				/**
     * The feature id for the '<em><b>Accessor</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOG_EXP_CS__ACCESSOR = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__ACCESSOR;

				/**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOG_EXP_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__SIMPLE_NAME_CS;

				/**
     * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOG_EXP_CS__ARGUMENTS = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__ARGUMENTS;

				/**
     * The feature id for the '<em><b>Is Marked Pre CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOG_EXP_CS__IS_MARKED_PRE_CS = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS__IS_MARKED_PRE_CS;

				/**
     * The feature id for the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOG_EXP_CS__CONDITION = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>Log Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOG_EXP_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.OPERATION_CALL_EXP_CS_FEATURE_COUNT + 1;

				/**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.AssertExpCSImpl <em>Assert Exp CS</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.AssertExpCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getAssertExpCS()
     * @generated
     */
	int ASSERT_EXP_CS = 42;

				/**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSERT_EXP_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__START_OFFSET;

				/**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSERT_EXP_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS__END_OFFSET;

				/**
     * The feature id for the '<em><b>Assertion</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSERT_EXP_CS__ASSERTION = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

				/**
     * The feature id for the '<em><b>Log</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSERT_EXP_CS__LOG = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

				/**
     * The feature id for the '<em><b>Severity</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSERT_EXP_CS__SEVERITY = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

				/**
     * The number of structural features of the '<em>Assert Exp CS</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSERT_EXP_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.OCL_EXPRESSION_CS_FEATURE_COUNT + 3;

				/**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ImperativeLoopExpCSImpl <em>Imperative Loop Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ImperativeLoopExpCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getImperativeLoopExpCS()
     * @generated
     */
    int IMPERATIVE_LOOP_EXP_CS = 43;

                /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPERATIVE_LOOP_EXP_CS__START_OFFSET = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__START_OFFSET;

                /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPERATIVE_LOOP_EXP_CS__END_OFFSET = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__END_OFFSET;

                /**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPERATIVE_LOOP_EXP_CS__SOURCE = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__SOURCE;

                /**
     * The feature id for the '<em><b>Accessor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPERATIVE_LOOP_EXP_CS__ACCESSOR = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__ACCESSOR;

                /**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPERATIVE_LOOP_EXP_CS__SIMPLE_NAME_CS = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__SIMPLE_NAME_CS;

                /**
     * The feature id for the '<em><b>Variable1</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPERATIVE_LOOP_EXP_CS__VARIABLE1 = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__VARIABLE1;

                /**
     * The feature id for the '<em><b>Variable2</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPERATIVE_LOOP_EXP_CS__VARIABLE2 = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__VARIABLE2;

                /**
     * The feature id for the '<em><b>Body</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPERATIVE_LOOP_EXP_CS__BODY = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS__BODY;

                /**
     * The number of structural features of the '<em>Imperative Loop Exp CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPERATIVE_LOOP_EXP_CS_FEATURE_COUNT = org.eclipse.ocl.cst.CSTPackage.LOOP_EXP_CS_FEATURE_COUNT + 0;

                /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ImperativeIterateExpCSImpl <em>Imperative Iterate Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ImperativeIterateExpCSImpl
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getImperativeIterateExpCS()
     * @generated
     */
    int IMPERATIVE_ITERATE_EXP_CS = 44;

                /**
     * The feature id for the '<em><b>Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPERATIVE_ITERATE_EXP_CS__START_OFFSET = IMPERATIVE_LOOP_EXP_CS__START_OFFSET;

                /**
     * The feature id for the '<em><b>End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPERATIVE_ITERATE_EXP_CS__END_OFFSET = IMPERATIVE_LOOP_EXP_CS__END_OFFSET;

                /**
     * The feature id for the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPERATIVE_ITERATE_EXP_CS__SOURCE = IMPERATIVE_LOOP_EXP_CS__SOURCE;

                /**
     * The feature id for the '<em><b>Accessor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPERATIVE_ITERATE_EXP_CS__ACCESSOR = IMPERATIVE_LOOP_EXP_CS__ACCESSOR;

                /**
     * The feature id for the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPERATIVE_ITERATE_EXP_CS__SIMPLE_NAME_CS = IMPERATIVE_LOOP_EXP_CS__SIMPLE_NAME_CS;

                /**
     * The feature id for the '<em><b>Variable1</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPERATIVE_ITERATE_EXP_CS__VARIABLE1 = IMPERATIVE_LOOP_EXP_CS__VARIABLE1;

                /**
     * The feature id for the '<em><b>Variable2</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPERATIVE_ITERATE_EXP_CS__VARIABLE2 = IMPERATIVE_LOOP_EXP_CS__VARIABLE2;

                /**
     * The feature id for the '<em><b>Body</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPERATIVE_ITERATE_EXP_CS__BODY = IMPERATIVE_LOOP_EXP_CS__BODY;

                /**
     * The number of structural features of the '<em>Imperative Iterate Exp CS</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPERATIVE_ITERATE_EXP_CS_FEATURE_COUNT = IMPERATIVE_LOOP_EXP_CS_FEATURE_COUNT + 0;

                /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindEnum <em>Direction Kind Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindEnum
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getDirectionKindEnum()
     * @generated
     */
    int DIRECTION_KIND_ENUM = 45;


    /**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModuleKindEnum <em>Module Kind Enum</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModuleKindEnum
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getModuleKindEnum()
     * @generated
     */
	int MODULE_KIND_ENUM = 46;

				/**
     * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.ImportKindEnum <em>Import Kind Enum</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ImportKindEnum
     * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getImportKindEnum()
     * @generated
     */
	int IMPORT_KIND_ENUM = 47;


				/**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS <em>Mapping Module CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Mapping Module CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS
     * @generated
     */
    EClass getMappingModuleCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS#getHeaderCS <em>Header CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Header CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS#getHeaderCS()
     * @see #getMappingModuleCS()
     * @generated
     */
	EReference getMappingModuleCS_HeaderCS();

				/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS#getImports <em>Imports</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Imports</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS#getImports()
     * @see #getMappingModuleCS()
     * @generated
     */
    EReference getMappingModuleCS_Imports();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS#getMetamodels <em>Metamodels</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Metamodels</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS#getMetamodels()
     * @see #getMappingModuleCS()
     * @generated
     */
    EReference getMappingModuleCS_Metamodels();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS#getRenamings <em>Renamings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Renamings</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS#getRenamings()
     * @see #getMappingModuleCS()
     * @generated
     */
    EReference getMappingModuleCS_Renamings();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Properties</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS#getProperties()
     * @see #getMappingModuleCS()
     * @generated
     */
    EReference getMappingModuleCS_Properties();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS#getMethods <em>Methods</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Methods</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS#getMethods()
     * @see #getMappingModuleCS()
     * @generated
     */
    EReference getMappingModuleCS_Methods();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.LibraryCS <em>Library CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Library CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.LibraryCS
     * @generated
     */
    EClass getLibraryCS();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ImportCS <em>Import CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Import CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ImportCS
     * @generated
     */
    EClass getImportCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.ImportCS#getPathNameCS <em>Path Name CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Path Name CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ImportCS#getPathNameCS()
     * @see #getImportCS()
     * @generated
     */
    EReference getImportCS_PathNameCS();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModuleImportCS <em>Module Import CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Module Import CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModuleImportCS
     * @generated
     */
    EClass getModuleImportCS();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.LibraryImportCS <em>Library Import CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Library Import CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.LibraryImportCS
     * @generated
     */
    EClass getLibraryImportCS();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.RenameCS <em>Rename CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Rename CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.RenameCS
     * @generated
     */
    EClass getRenameCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.RenameCS#getTypeCS <em>Type CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.RenameCS#getTypeCS()
     * @see #getRenameCS()
     * @generated
     */
    EReference getRenameCS_TypeCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.RenameCS#getSimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.RenameCS#getSimpleNameCS()
     * @see #getRenameCS()
     * @generated
     */
    EReference getRenameCS_SimpleNameCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.RenameCS#getOriginalName <em>Original Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Original Name</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.RenameCS#getOriginalName()
     * @see #getRenameCS()
     * @generated
     */
    EReference getRenameCS_OriginalName();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModulePropertyCS <em>Module Property CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Module Property CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModulePropertyCS
     * @generated
     */
    EClass getModulePropertyCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModulePropertyCS#getSimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModulePropertyCS#getSimpleNameCS()
     * @see #getModulePropertyCS()
     * @generated
     */
    EReference getModulePropertyCS_SimpleNameCS();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ConfigPropertyCS <em>Config Property CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Config Property CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ConfigPropertyCS
     * @generated
     */
    EClass getConfigPropertyCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.ConfigPropertyCS#getTypeCS <em>Type CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ConfigPropertyCS#getTypeCS()
     * @see #getConfigPropertyCS()
     * @generated
     */
    EReference getConfigPropertyCS_TypeCS();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.LocalPropertyCS <em>Local Property CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Local Property CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.LocalPropertyCS
     * @generated
     */
    EClass getLocalPropertyCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.LocalPropertyCS#getTypeCS <em>Type CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.LocalPropertyCS#getTypeCS()
     * @see #getLocalPropertyCS()
     * @generated
     */
    EReference getLocalPropertyCS_TypeCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.LocalPropertyCS#getOclExpressionCS <em>Ocl Expression CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Ocl Expression CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.LocalPropertyCS#getOclExpressionCS()
     * @see #getLocalPropertyCS()
     * @generated
     */
    EReference getLocalPropertyCS_OclExpressionCS();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS <em>Mapping Declaration CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Mapping Declaration CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS
     * @generated
     */
    EClass getMappingDeclarationCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getSimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getSimpleNameCS()
     * @see #getMappingDeclarationCS()
     * @generated
     */
    EReference getMappingDeclarationCS_SimpleNameCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getContextType <em>Context Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Context Type</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getContextType()
     * @see #getMappingDeclarationCS()
     * @generated
     */
    EReference getMappingDeclarationCS_ContextType();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getContextTypeAndName <em>Context Type And Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Context Type And Name</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getContextTypeAndName()
     * @see #getMappingDeclarationCS()
     * @generated
     */
    EReference getMappingDeclarationCS_ContextTypeAndName();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getParameters <em>Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parameters</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getParameters()
     * @see #getMappingDeclarationCS()
     * @generated
     */
    EReference getMappingDeclarationCS_Parameters();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getReturnType <em>Return Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Return Type</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getReturnType()
     * @see #getMappingDeclarationCS()
     * @generated
     */
    EReference getMappingDeclarationCS_ReturnType();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#isBlackBox <em>Black Box</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Black Box</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#isBlackBox()
     * @see #getMappingDeclarationCS()
     * @generated
     */
    EAttribute getMappingDeclarationCS_BlackBox();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getDirectionKindCS <em>Direction Kind CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Direction Kind CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getDirectionKindCS()
     * @see #getMappingDeclarationCS()
     * @generated
     */
	EReference getMappingDeclarationCS_DirectionKindCS();

				/**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ParameterDeclarationCS <em>Parameter Declaration CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Parameter Declaration CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ParameterDeclarationCS
     * @generated
     */
    EClass getParameterDeclarationCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.ParameterDeclarationCS#getSimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ParameterDeclarationCS#getSimpleNameCS()
     * @see #getParameterDeclarationCS()
     * @generated
     */
    EReference getParameterDeclarationCS_SimpleNameCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.ParameterDeclarationCS#getTypeSpecCS <em>Type Spec CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type Spec CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ParameterDeclarationCS#getTypeSpecCS()
     * @see #getParameterDeclarationCS()
     * @generated
     */
	EReference getParameterDeclarationCS_TypeSpecCS();

				/**
     * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.internal.cst.ParameterDeclarationCS#getDirectionKind <em>Direction Kind</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Direction Kind</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ParameterDeclarationCS#getDirectionKind()
     * @see #getParameterDeclarationCS()
     * @generated
     */
    EAttribute getParameterDeclarationCS_DirectionKind();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingMethodCS <em>Mapping Method CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Mapping Method CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingMethodCS
     * @generated
     */
    EClass getMappingMethodCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingMethodCS#getMappingDeclarationCS <em>Mapping Declaration CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Mapping Declaration CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingMethodCS#getMappingDeclarationCS()
     * @see #getMappingMethodCS()
     * @generated
     */
    EReference getMappingMethodCS_MappingDeclarationCS();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingRuleCS <em>Mapping Rule CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Mapping Rule CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingRuleCS
     * @generated
     */
    EClass getMappingRuleCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingRuleCS#getGuard <em>Guard</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Guard</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingRuleCS#getGuard()
     * @see #getMappingRuleCS()
     * @generated
     */
    EReference getMappingRuleCS_Guard();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingRuleCS#getMappingInitCS <em>Mapping Init CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Mapping Init CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingRuleCS#getMappingInitCS()
     * @see #getMappingRuleCS()
     * @generated
     */
    EReference getMappingRuleCS_MappingInitCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingRuleCS#getMappingBodyCS <em>Mapping Body CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Mapping Body CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingRuleCS#getMappingBodyCS()
     * @see #getMappingRuleCS()
     * @generated
     */
    EReference getMappingRuleCS_MappingBodyCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingRuleCS#getMappingEndCS <em>Mapping End CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Mapping End CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingRuleCS#getMappingEndCS()
     * @see #getMappingRuleCS()
     * @generated
     */
    EReference getMappingRuleCS_MappingEndCS();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingQueryCS <em>Mapping Query CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Mapping Query CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingQueryCS
     * @generated
     */
    EClass getMappingQueryCS();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingQueryCS#getExpressions <em>Expressions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Expressions</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingQueryCS#getExpressions()
     * @see #getMappingQueryCS()
     * @generated
     */
    EReference getMappingQueryCS_Expressions();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingSectionCS <em>Mapping Section CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Mapping Section CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingSectionCS
     * @generated
     */
    EClass getMappingSectionCS();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingSectionCS#getStatements <em>Statements</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Statements</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingSectionCS#getStatements()
     * @see #getMappingSectionCS()
     * @generated
     */
    EReference getMappingSectionCS_Statements();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingSectionCS#getMappingRuleCS <em>Mapping Rule CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Mapping Rule CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingSectionCS#getMappingRuleCS()
     * @see #getMappingSectionCS()
     * @generated
     */
    EReference getMappingSectionCS_MappingRuleCS();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingInitCS <em>Mapping Init CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Mapping Init CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingInitCS
     * @generated
     */
    EClass getMappingInitCS();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingEndCS <em>Mapping End CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Mapping End CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingEndCS
     * @generated
     */
    EClass getMappingEndCS();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.StatementCS <em>Statement CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Statement CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.StatementCS
     * @generated
     */
    EClass getStatementCS();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.AssignStatementCS <em>Assign Statement CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Assign Statement CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.AssignStatementCS
     * @generated
     */
    EClass getAssignStatementCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.AssignStatementCS#getLValueCS <em>LValue CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>LValue CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.AssignStatementCS#getLValueCS()
     * @see #getAssignStatementCS()
     * @generated
     */
    EReference getAssignStatementCS_LValueCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.AssignStatementCS#getOclExpressionCS <em>Ocl Expression CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Ocl Expression CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.AssignStatementCS#getOclExpressionCS()
     * @see #getAssignStatementCS()
     * @generated
     */
    EReference getAssignStatementCS_OclExpressionCS();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.internal.cst.AssignStatementCS#isIncremental <em>Incremental</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Incremental</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.AssignStatementCS#isIncremental()
     * @see #getAssignStatementCS()
     * @generated
     */
    EAttribute getAssignStatementCS_Incremental();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ExpressionStatementCS <em>Expression Statement CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Expression Statement CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ExpressionStatementCS
     * @generated
     */
    EClass getExpressionStatementCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.ExpressionStatementCS#getOclExpressionCS <em>Ocl Expression CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Ocl Expression CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ExpressionStatementCS#getOclExpressionCS()
     * @see #getExpressionStatementCS()
     * @generated
     */
    EReference getExpressionStatementCS_OclExpressionCS();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.VariableInitializationCS <em>Variable Initialization CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Variable Initialization CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.VariableInitializationCS
     * @generated
     */
    EClass getVariableInitializationCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.VariableInitializationCS#getOclExpressionCS <em>Ocl Expression CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Ocl Expression CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.VariableInitializationCS#getOclExpressionCS()
     * @see #getVariableInitializationCS()
     * @generated
     */
    EReference getVariableInitializationCS_OclExpressionCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.VariableInitializationCS#getSimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.VariableInitializationCS#getSimpleNameCS()
     * @see #getVariableInitializationCS()
     * @generated
     */
    EReference getVariableInitializationCS_SimpleNameCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.VariableInitializationCS#getTypeCS <em>Type CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.VariableInitializationCS#getTypeCS()
     * @see #getVariableInitializationCS()
     * @generated
     */
    EReference getVariableInitializationCS_TypeCS();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS <em>Mapping Body CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Mapping Body CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS
     * @generated
     */
    EClass getMappingBodyCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS#getOutExpCS <em>Out Exp CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Out Exp CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS#getOutExpCS()
     * @see #getMappingBodyCS()
     * @generated
     */
    EReference getMappingBodyCS_OutExpCS();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS#isShort <em>Short</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Short</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS#isShort()
     * @see #getMappingBodyCS()
     * @generated
     */
    EAttribute getMappingBodyCS_Short();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.OutExpCS <em>Out Exp CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Out Exp CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.OutExpCS
     * @generated
     */
    EClass getOutExpCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.OutExpCS#getSimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.OutExpCS#getSimpleNameCS()
     * @see #getOutExpCS()
     * @generated
     */
    EReference getOutExpCS_SimpleNameCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.OutExpCS#getTypeSpecCS <em>Type Spec CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type Spec CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.OutExpCS#getTypeSpecCS()
     * @see #getOutExpCS()
     * @generated
     */
	EReference getOutExpCS_TypeSpecCS();

				/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.internal.cst.OutExpCS#getExpressions <em>Expressions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Expressions</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.OutExpCS#getExpressions()
     * @see #getOutExpCS()
     * @generated
     */
    EReference getOutExpCS_Expressions();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS <em>Pattern Property Exp CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Pattern Property Exp CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS
     * @generated
     */
    EClass getPatternPropertyExpCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS#getSimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS#getSimpleNameCS()
     * @see #getPatternPropertyExpCS()
     * @generated
     */
    EReference getPatternPropertyExpCS_SimpleNameCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS#getOclExpressionCS <em>Ocl Expression CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Ocl Expression CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS#getOclExpressionCS()
     * @see #getPatternPropertyExpCS()
     * @generated
     */
    EReference getPatternPropertyExpCS_OclExpressionCS();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS#isIncremental <em>Incremental</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Incremental</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS#isIncremental()
     * @see #getPatternPropertyExpCS()
     * @generated
     */
    EAttribute getPatternPropertyExpCS_Incremental();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingCallExpCS <em>Mapping Call Exp CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Mapping Call Exp CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingCallExpCS
     * @generated
     */
    EClass getMappingCallExpCS();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingCallExpCS#isStrict <em>Strict</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Strict</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingCallExpCS#isStrict()
     * @see #getMappingCallExpCS()
     * @generated
     */
    EAttribute getMappingCallExpCS_Strict();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.WhileExpCS <em>While Exp CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>While Exp CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.WhileExpCS
     * @generated
     */
    EClass getWhileExpCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.WhileExpCS#getBody <em>Body</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Body</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.WhileExpCS#getBody()
     * @see #getWhileExpCS()
     * @generated
     */
	EReference getWhileExpCS_Body();

				/**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.WhileExpCS#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Condition</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.WhileExpCS#getCondition()
     * @see #getWhileExpCS()
     * @generated
     */
    EReference getWhileExpCS_Condition();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.WhileExpCS#getResult <em>Result</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Result</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.WhileExpCS#getResult()
     * @see #getWhileExpCS()
     * @generated
     */
    EReference getWhileExpCS_Result();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.WhileExpCS#getResultVar <em>Result Var</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Result Var</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.WhileExpCS#getResultVar()
     * @see #getWhileExpCS()
     * @generated
     */
	EReference getWhileExpCS_ResultVar();

				/**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.SwitchExpCS <em>Switch Exp CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Switch Exp CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.SwitchExpCS
     * @generated
     */
    EClass getSwitchExpCS();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.internal.cst.SwitchExpCS#getAlternativePart <em>Alternative Part</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Alternative Part</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.SwitchExpCS#getAlternativePart()
     * @see #getSwitchExpCS()
     * @generated
     */
    EReference getSwitchExpCS_AlternativePart();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.SwitchExpCS#getElsePart <em>Else Part</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Else Part</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.SwitchExpCS#getElsePart()
     * @see #getSwitchExpCS()
     * @generated
     */
    EReference getSwitchExpCS_ElsePart();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.SwitchAltExpCS <em>Switch Alt Exp CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Switch Alt Exp CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.SwitchAltExpCS
     * @generated
     */
    EClass getSwitchAltExpCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.SwitchAltExpCS#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Condition</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.SwitchAltExpCS#getCondition()
     * @see #getSwitchAltExpCS()
     * @generated
     */
    EReference getSwitchAltExpCS_Condition();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.SwitchAltExpCS#getBody <em>Body</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Body</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.SwitchAltExpCS#getBody()
     * @see #getSwitchAltExpCS()
     * @generated
     */
    EReference getSwitchAltExpCS_Body();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.BlockExpCS <em>Block Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Block Exp CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.BlockExpCS
     * @generated
     */
	EClass getBlockExpCS();

				/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.internal.cst.BlockExpCS#getBodyExpressions <em>Body Expressions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Body Expressions</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.BlockExpCS#getBodyExpressions()
     * @see #getBlockExpCS()
     * @generated
     */
	EReference getBlockExpCS_BodyExpressions();

				/**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindCS <em>Direction Kind CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Direction Kind CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindCS
     * @generated
     */
    EClass getDirectionKindCS();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindCS#getDirectionKind <em>Direction Kind</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Direction Kind</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindCS#getDirectionKind()
     * @see #getDirectionKindCS()
     * @generated
     */
    EAttribute getDirectionKindCS_DirectionKind();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ElementWithBody <em>Element With Body</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Element With Body</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ElementWithBody
     * @generated
     */
    EClass getElementWithBody();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.internal.cst.ElementWithBody#getBodyStartLocation <em>Body Start Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Body Start Location</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ElementWithBody#getBodyStartLocation()
     * @see #getElementWithBody()
     * @generated
     */
    EAttribute getElementWithBody_BodyStartLocation();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.internal.cst.ElementWithBody#getBodyEndLocation <em>Body End Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Body End Location</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ElementWithBody#getBodyEndLocation()
     * @see #getElementWithBody()
     * @generated
     */
    EAttribute getElementWithBody_BodyEndLocation();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ResolveExpCS <em>Resolve Exp CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Resolve Exp CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ResolveExpCS
     * @generated
     */
    EClass getResolveExpCS();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.internal.cst.ResolveExpCS#isOne <em>One</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>One</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ResolveExpCS#isOne()
     * @see #getResolveExpCS()
     * @generated
     */
    EAttribute getResolveExpCS_One();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.internal.cst.ResolveExpCS#isIsInverse <em>Is Inverse</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Inverse</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ResolveExpCS#isIsInverse()
     * @see #getResolveExpCS()
     * @generated
     */
    EAttribute getResolveExpCS_IsInverse();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.internal.cst.ResolveExpCS#isIsDeferred <em>Is Deferred</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Deferred</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ResolveExpCS#isIsDeferred()
     * @see #getResolveExpCS()
     * @generated
     */
    EAttribute getResolveExpCS_IsDeferred();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.ResolveExpCS#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Target</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ResolveExpCS#getTarget()
     * @see #getResolveExpCS()
     * @generated
     */
    EReference getResolveExpCS_Target();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.ResolveExpCS#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Condition</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ResolveExpCS#getCondition()
     * @see #getResolveExpCS()
     * @generated
     */
    EReference getResolveExpCS_Condition();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ResolveInExpCS <em>Resolve In Exp CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Resolve In Exp CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ResolveInExpCS
     * @generated
     */
    EClass getResolveInExpCS();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.ResolveInExpCS#getInMappingType <em>In Mapping Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>In Mapping Type</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ResolveInExpCS#getInMappingType()
     * @see #getResolveInExpCS()
     * @generated
     */
    EReference getResolveInExpCS_InMappingType();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.internal.cst.ResolveInExpCS#getInMappingName <em>In Mapping Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>In Mapping Name</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ResolveInExpCS#getInMappingName()
     * @see #getResolveInExpCS()
     * @generated
     */
    EAttribute getResolveInExpCS_InMappingName();

    /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS <em>Model Type CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Model Type CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS
     * @generated
     */
	EClass getModelTypeCS();

				/**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS#getIdentifierCS <em>Identifier CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Identifier CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS#getIdentifierCS()
     * @see #getModelTypeCS()
     * @generated
     */
	EReference getModelTypeCS_IdentifierCS();

				/**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS#getComplianceKindCS <em>Compliance Kind CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Compliance Kind CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS#getComplianceKindCS()
     * @see #getModelTypeCS()
     * @generated
     */
	EReference getModelTypeCS_ComplianceKindCS();

				/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS#getPackageRefs <em>Package Refs</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Package Refs</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS#getPackageRefs()
     * @see #getModelTypeCS()
     * @generated
     */
	EReference getModelTypeCS_PackageRefs();

				/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS#getWhereStatements <em>Where Statements</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Where Statements</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS#getWhereStatements()
     * @see #getModelTypeCS()
     * @generated
     */
	EReference getModelTypeCS_WhereStatements();

				/**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.PackageRefCS <em>Package Ref CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Package Ref CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.PackageRefCS
     * @generated
     */
	EClass getPackageRefCS();

				/**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.PackageRefCS#getPathNameCS <em>Path Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Path Name CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.PackageRefCS#getPathNameCS()
     * @see #getPackageRefCS()
     * @generated
     */
	EReference getPackageRefCS_PathNameCS();

				/**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.PackageRefCS#getUriCS <em>Uri CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Uri CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.PackageRefCS#getUriCS()
     * @see #getPackageRefCS()
     * @generated
     */
	EReference getPackageRefCS_UriCS();

				/**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS <em>Transformation Header CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Transformation Header CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS
     * @generated
     */
	EClass getTransformationHeaderCS();

				/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS#getQualifiers <em>Qualifiers</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Qualifiers</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS#getQualifiers()
     * @see #getTransformationHeaderCS()
     * @generated
     */
	EReference getTransformationHeaderCS_Qualifiers();

				/**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS#getPathNameCS <em>Path Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Path Name CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS#getPathNameCS()
     * @see #getTransformationHeaderCS()
     * @generated
     */
	EReference getTransformationHeaderCS_PathNameCS();

				/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS#getParameters <em>Parameters</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parameters</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS#getParameters()
     * @see #getTransformationHeaderCS()
     * @generated
     */
	EReference getTransformationHeaderCS_Parameters();

				/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS#getModuleUsages <em>Module Usages</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Module Usages</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS#getModuleUsages()
     * @see #getTransformationHeaderCS()
     * @generated
     */
	EReference getTransformationHeaderCS_ModuleUsages();

				/**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS#getTransformationRefineCS <em>Transformation Refine CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Transformation Refine CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS#getTransformationRefineCS()
     * @see #getTransformationHeaderCS()
     * @generated
     */
	EReference getTransformationHeaderCS_TransformationRefineCS();

				/**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModuleKindCS <em>Module Kind CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Module Kind CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModuleKindCS
     * @generated
     */
	EClass getModuleKindCS();

				/**
     * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModuleKindCS#getModuleKind <em>Module Kind</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Module Kind</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModuleKindCS#getModuleKind()
     * @see #getModuleKindCS()
     * @generated
     */
	EAttribute getModuleKindCS_ModuleKind();

				/**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModuleRefCS <em>Module Ref CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Module Ref CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModuleRefCS
     * @generated
     */
	EClass getModuleRefCS();

				/**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModuleRefCS#getPathNameCS <em>Path Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Path Name CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModuleRefCS#getPathNameCS()
     * @see #getModuleRefCS()
     * @generated
     */
	EReference getModuleRefCS_PathNameCS();

				/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModuleRefCS#getParameters <em>Parameters</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parameters</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModuleRefCS#getParameters()
     * @see #getModuleRefCS()
     * @generated
     */
	EReference getModuleRefCS_Parameters();

				/**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModuleUsageCS <em>Module Usage CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Module Usage CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModuleUsageCS
     * @generated
     */
	EClass getModuleUsageCS();

				/**
     * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModuleUsageCS#getImportKind <em>Import Kind</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Import Kind</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModuleUsageCS#getImportKind()
     * @see #getModuleUsageCS()
     * @generated
     */
	EAttribute getModuleUsageCS_ImportKind();

				/**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModuleUsageCS#getModuleKindCS <em>Module Kind CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Module Kind CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModuleUsageCS#getModuleKindCS()
     * @see #getModuleUsageCS()
     * @generated
     */
	EReference getModuleUsageCS_ModuleKindCS();

				/**
     * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModuleUsageCS#getModuleRefs <em>Module Refs</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Module Refs</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModuleUsageCS#getModuleRefs()
     * @see #getModuleUsageCS()
     * @generated
     */
	EReference getModuleUsageCS_ModuleRefs();

				/**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.TransformationRefineCS <em>Transformation Refine CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Transformation Refine CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.TransformationRefineCS
     * @generated
     */
	EClass getTransformationRefineCS();

				/**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.TransformationRefineCS#getModuleRefCS <em>Module Ref CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Module Ref CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.TransformationRefineCS#getModuleRefCS()
     * @see #getTransformationRefineCS()
     * @generated
     */
	EReference getTransformationRefineCS_ModuleRefCS();

				/**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.TransformationRefineCS#getSimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.TransformationRefineCS#getSimpleNameCS()
     * @see #getTransformationRefineCS()
     * @generated
     */
	EReference getTransformationRefineCS_SimpleNameCS();

				/**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.TypeSpecCS <em>Type Spec CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Spec CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.TypeSpecCS
     * @generated
     */
	EClass getTypeSpecCS();

				/**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.TypeSpecCS#getTypeCS <em>Type CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.TypeSpecCS#getTypeCS()
     * @see #getTypeSpecCS()
     * @generated
     */
	EReference getTypeSpecCS_TypeCS();

				/**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.TypeSpecCS#getSimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Simple Name CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.TypeSpecCS#getSimpleNameCS()
     * @see #getTypeSpecCS()
     * @generated
     */
	EReference getTypeSpecCS_SimpleNameCS();

				/**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.LogExpCS <em>Log Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Log Exp CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.LogExpCS
     * @generated
     */
	EClass getLogExpCS();

				/**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.LogExpCS#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Condition</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.LogExpCS#getCondition()
     * @see #getLogExpCS()
     * @generated
     */
	EReference getLogExpCS_Condition();

				/**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.AssertExpCS <em>Assert Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Assert Exp CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.AssertExpCS
     * @generated
     */
	EClass getAssertExpCS();

				/**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.AssertExpCS#getAssertion <em>Assertion</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Assertion</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.AssertExpCS#getAssertion()
     * @see #getAssertExpCS()
     * @generated
     */
	EReference getAssertExpCS_Assertion();

				/**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.AssertExpCS#getLog <em>Log</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Log</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.AssertExpCS#getLog()
     * @see #getAssertExpCS()
     * @generated
     */
	EReference getAssertExpCS_Log();

				/**
     * Returns the meta object for the containment reference '{@link org.eclipse.m2m.qvt.oml.internal.cst.AssertExpCS#getSeverity <em>Severity</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Severity</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.AssertExpCS#getSeverity()
     * @see #getAssertExpCS()
     * @generated
     */
	EReference getAssertExpCS_Severity();

				/**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ImperativeLoopExpCS <em>Imperative Loop Exp CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Imperative Loop Exp CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ImperativeLoopExpCS
     * @generated
     */
    EClass getImperativeLoopExpCS();

                /**
     * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ImperativeIterateExpCS <em>Imperative Iterate Exp CS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Imperative Iterate Exp CS</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ImperativeIterateExpCS
     * @generated
     */
    EClass getImperativeIterateExpCS();

                /**
     * Returns the meta object for enum '{@link org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindEnum <em>Direction Kind Enum</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Direction Kind Enum</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindEnum
     * @generated
     */
    EEnum getDirectionKindEnum();

    /**
     * Returns the meta object for enum '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModuleKindEnum <em>Module Kind Enum</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Module Kind Enum</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ModuleKindEnum
     * @generated
     */
	EEnum getModuleKindEnum();

				/**
     * Returns the meta object for enum '{@link org.eclipse.m2m.qvt.oml.internal.cst.ImportKindEnum <em>Import Kind Enum</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Import Kind Enum</em>'.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.ImportKindEnum
     * @generated
     */
	EEnum getImportKindEnum();

				/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    CSTFactory getCSTFactory();

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
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingModuleCSImpl <em>Mapping Module CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingModuleCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingModuleCS()
         * @generated
         */
        EClass MAPPING_MODULE_CS = eINSTANCE.getMappingModuleCS();

        /**
         * The meta object literal for the '<em><b>Header CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MAPPING_MODULE_CS__HEADER_CS = eINSTANCE.getMappingModuleCS_HeaderCS();

								/**
         * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_MODULE_CS__IMPORTS = eINSTANCE.getMappingModuleCS_Imports();

        /**
         * The meta object literal for the '<em><b>Metamodels</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_MODULE_CS__METAMODELS = eINSTANCE.getMappingModuleCS_Metamodels();

        /**
         * The meta object literal for the '<em><b>Renamings</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_MODULE_CS__RENAMINGS = eINSTANCE.getMappingModuleCS_Renamings();

        /**
         * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_MODULE_CS__PROPERTIES = eINSTANCE.getMappingModuleCS_Properties();

        /**
         * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_MODULE_CS__METHODS = eINSTANCE.getMappingModuleCS_Methods();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.LibraryCSImpl <em>Library CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.LibraryCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getLibraryCS()
         * @generated
         */
        EClass LIBRARY_CS = eINSTANCE.getLibraryCS();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ImportCSImpl <em>Import CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ImportCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getImportCS()
         * @generated
         */
        EClass IMPORT_CS = eINSTANCE.getImportCS();

        /**
         * The meta object literal for the '<em><b>Path Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference IMPORT_CS__PATH_NAME_CS = eINSTANCE.getImportCS_PathNameCS();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ModuleImportCSImpl <em>Module Import CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ModuleImportCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getModuleImportCS()
         * @generated
         */
        EClass MODULE_IMPORT_CS = eINSTANCE.getModuleImportCS();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.LibraryImportCSImpl <em>Library Import CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.LibraryImportCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getLibraryImportCS()
         * @generated
         */
        EClass LIBRARY_IMPORT_CS = eINSTANCE.getLibraryImportCS();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.RenameCSImpl <em>Rename CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.RenameCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getRenameCS()
         * @generated
         */
        EClass RENAME_CS = eINSTANCE.getRenameCS();

        /**
         * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RENAME_CS__TYPE_CS = eINSTANCE.getRenameCS_TypeCS();

        /**
         * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RENAME_CS__SIMPLE_NAME_CS = eINSTANCE.getRenameCS_SimpleNameCS();

        /**
         * The meta object literal for the '<em><b>Original Name</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RENAME_CS__ORIGINAL_NAME = eINSTANCE.getRenameCS_OriginalName();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ModulePropertyCSImpl <em>Module Property CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ModulePropertyCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getModulePropertyCS()
         * @generated
         */
        EClass MODULE_PROPERTY_CS = eINSTANCE.getModulePropertyCS();

        /**
         * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MODULE_PROPERTY_CS__SIMPLE_NAME_CS = eINSTANCE.getModulePropertyCS_SimpleNameCS();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ConfigPropertyCSImpl <em>Config Property CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ConfigPropertyCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getConfigPropertyCS()
         * @generated
         */
        EClass CONFIG_PROPERTY_CS = eINSTANCE.getConfigPropertyCS();

        /**
         * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONFIG_PROPERTY_CS__TYPE_CS = eINSTANCE.getConfigPropertyCS_TypeCS();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.LocalPropertyCSImpl <em>Local Property CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.LocalPropertyCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getLocalPropertyCS()
         * @generated
         */
        EClass LOCAL_PROPERTY_CS = eINSTANCE.getLocalPropertyCS();

        /**
         * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LOCAL_PROPERTY_CS__TYPE_CS = eINSTANCE.getLocalPropertyCS_TypeCS();

        /**
         * The meta object literal for the '<em><b>Ocl Expression CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LOCAL_PROPERTY_CS__OCL_EXPRESSION_CS = eINSTANCE.getLocalPropertyCS_OclExpressionCS();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingDeclarationCSImpl <em>Mapping Declaration CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingDeclarationCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingDeclarationCS()
         * @generated
         */
        EClass MAPPING_DECLARATION_CS = eINSTANCE.getMappingDeclarationCS();

        /**
         * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_DECLARATION_CS__SIMPLE_NAME_CS = eINSTANCE.getMappingDeclarationCS_SimpleNameCS();

        /**
         * The meta object literal for the '<em><b>Context Type</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_DECLARATION_CS__CONTEXT_TYPE = eINSTANCE.getMappingDeclarationCS_ContextType();

        /**
         * The meta object literal for the '<em><b>Context Type And Name</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_DECLARATION_CS__CONTEXT_TYPE_AND_NAME = eINSTANCE.getMappingDeclarationCS_ContextTypeAndName();

        /**
         * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_DECLARATION_CS__PARAMETERS = eINSTANCE.getMappingDeclarationCS_Parameters();

        /**
         * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_DECLARATION_CS__RETURN_TYPE = eINSTANCE.getMappingDeclarationCS_ReturnType();

        /**
         * The meta object literal for the '<em><b>Black Box</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MAPPING_DECLARATION_CS__BLACK_BOX = eINSTANCE.getMappingDeclarationCS_BlackBox();

        /**
         * The meta object literal for the '<em><b>Direction Kind CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MAPPING_DECLARATION_CS__DIRECTION_KIND_CS = eINSTANCE.getMappingDeclarationCS_DirectionKindCS();

								/**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ParameterDeclarationCSImpl <em>Parameter Declaration CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ParameterDeclarationCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getParameterDeclarationCS()
         * @generated
         */
        EClass PARAMETER_DECLARATION_CS = eINSTANCE.getParameterDeclarationCS();

        /**
         * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS = eINSTANCE.getParameterDeclarationCS_SimpleNameCS();

        /**
         * The meta object literal for the '<em><b>Type Spec CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PARAMETER_DECLARATION_CS__TYPE_SPEC_CS = eINSTANCE.getParameterDeclarationCS_TypeSpecCS();

								/**
         * The meta object literal for the '<em><b>Direction Kind</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PARAMETER_DECLARATION_CS__DIRECTION_KIND = eINSTANCE.getParameterDeclarationCS_DirectionKind();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingMethodCSImpl <em>Mapping Method CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingMethodCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingMethodCS()
         * @generated
         */
        EClass MAPPING_METHOD_CS = eINSTANCE.getMappingMethodCS();

        /**
         * The meta object literal for the '<em><b>Mapping Declaration CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_METHOD_CS__MAPPING_DECLARATION_CS = eINSTANCE.getMappingMethodCS_MappingDeclarationCS();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingRuleCSImpl <em>Mapping Rule CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingRuleCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingRuleCS()
         * @generated
         */
        EClass MAPPING_RULE_CS = eINSTANCE.getMappingRuleCS();

        /**
         * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_RULE_CS__GUARD = eINSTANCE.getMappingRuleCS_Guard();

        /**
         * The meta object literal for the '<em><b>Mapping Init CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_RULE_CS__MAPPING_INIT_CS = eINSTANCE.getMappingRuleCS_MappingInitCS();

        /**
         * The meta object literal for the '<em><b>Mapping Body CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_RULE_CS__MAPPING_BODY_CS = eINSTANCE.getMappingRuleCS_MappingBodyCS();

        /**
         * The meta object literal for the '<em><b>Mapping End CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_RULE_CS__MAPPING_END_CS = eINSTANCE.getMappingRuleCS_MappingEndCS();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingQueryCSImpl <em>Mapping Query CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingQueryCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingQueryCS()
         * @generated
         */
        EClass MAPPING_QUERY_CS = eINSTANCE.getMappingQueryCS();

        /**
         * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_QUERY_CS__EXPRESSIONS = eINSTANCE.getMappingQueryCS_Expressions();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingSectionCSImpl <em>Mapping Section CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingSectionCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingSectionCS()
         * @generated
         */
        EClass MAPPING_SECTION_CS = eINSTANCE.getMappingSectionCS();

        /**
         * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_SECTION_CS__STATEMENTS = eINSTANCE.getMappingSectionCS_Statements();

        /**
         * The meta object literal for the '<em><b>Mapping Rule CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_SECTION_CS__MAPPING_RULE_CS = eINSTANCE.getMappingSectionCS_MappingRuleCS();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingInitCSImpl <em>Mapping Init CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingInitCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingInitCS()
         * @generated
         */
        EClass MAPPING_INIT_CS = eINSTANCE.getMappingInitCS();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingEndCSImpl <em>Mapping End CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingEndCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingEndCS()
         * @generated
         */
        EClass MAPPING_END_CS = eINSTANCE.getMappingEndCS();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.StatementCSImpl <em>Statement CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.StatementCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getStatementCS()
         * @generated
         */
        EClass STATEMENT_CS = eINSTANCE.getStatementCS();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.AssignStatementCSImpl <em>Assign Statement CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.AssignStatementCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getAssignStatementCS()
         * @generated
         */
        EClass ASSIGN_STATEMENT_CS = eINSTANCE.getAssignStatementCS();

        /**
         * The meta object literal for the '<em><b>LValue CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ASSIGN_STATEMENT_CS__LVALUE_CS = eINSTANCE.getAssignStatementCS_LValueCS();

        /**
         * The meta object literal for the '<em><b>Ocl Expression CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS = eINSTANCE.getAssignStatementCS_OclExpressionCS();

        /**
         * The meta object literal for the '<em><b>Incremental</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ASSIGN_STATEMENT_CS__INCREMENTAL = eINSTANCE.getAssignStatementCS_Incremental();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ExpressionStatementCSImpl <em>Expression Statement CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ExpressionStatementCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getExpressionStatementCS()
         * @generated
         */
        EClass EXPRESSION_STATEMENT_CS = eINSTANCE.getExpressionStatementCS();

        /**
         * The meta object literal for the '<em><b>Ocl Expression CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXPRESSION_STATEMENT_CS__OCL_EXPRESSION_CS = eINSTANCE.getExpressionStatementCS_OclExpressionCS();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.VariableInitializationCSImpl <em>Variable Initialization CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.VariableInitializationCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getVariableInitializationCS()
         * @generated
         */
        EClass VARIABLE_INITIALIZATION_CS = eINSTANCE.getVariableInitializationCS();

        /**
         * The meta object literal for the '<em><b>Ocl Expression CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VARIABLE_INITIALIZATION_CS__OCL_EXPRESSION_CS = eINSTANCE.getVariableInitializationCS_OclExpressionCS();

        /**
         * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VARIABLE_INITIALIZATION_CS__SIMPLE_NAME_CS = eINSTANCE.getVariableInitializationCS_SimpleNameCS();

        /**
         * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VARIABLE_INITIALIZATION_CS__TYPE_CS = eINSTANCE.getVariableInitializationCS_TypeCS();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingBodyCSImpl <em>Mapping Body CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingBodyCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingBodyCS()
         * @generated
         */
        EClass MAPPING_BODY_CS = eINSTANCE.getMappingBodyCS();

        /**
         * The meta object literal for the '<em><b>Out Exp CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPING_BODY_CS__OUT_EXP_CS = eINSTANCE.getMappingBodyCS_OutExpCS();

        /**
         * The meta object literal for the '<em><b>Short</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MAPPING_BODY_CS__SHORT = eINSTANCE.getMappingBodyCS_Short();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.OutExpCSImpl <em>Out Exp CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.OutExpCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getOutExpCS()
         * @generated
         */
        EClass OUT_EXP_CS = eINSTANCE.getOutExpCS();

        /**
         * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OUT_EXP_CS__SIMPLE_NAME_CS = eINSTANCE.getOutExpCS_SimpleNameCS();

        /**
         * The meta object literal for the '<em><b>Type Spec CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OUT_EXP_CS__TYPE_SPEC_CS = eINSTANCE.getOutExpCS_TypeSpecCS();

								/**
         * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OUT_EXP_CS__EXPRESSIONS = eINSTANCE.getOutExpCS_Expressions();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.PatternPropertyExpCSImpl <em>Pattern Property Exp CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.PatternPropertyExpCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getPatternPropertyExpCS()
         * @generated
         */
        EClass PATTERN_PROPERTY_EXP_CS = eINSTANCE.getPatternPropertyExpCS();

        /**
         * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN_PROPERTY_EXP_CS__SIMPLE_NAME_CS = eINSTANCE.getPatternPropertyExpCS_SimpleNameCS();

        /**
         * The meta object literal for the '<em><b>Ocl Expression CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PATTERN_PROPERTY_EXP_CS__OCL_EXPRESSION_CS = eINSTANCE.getPatternPropertyExpCS_OclExpressionCS();

        /**
         * The meta object literal for the '<em><b>Incremental</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PATTERN_PROPERTY_EXP_CS__INCREMENTAL = eINSTANCE.getPatternPropertyExpCS_Incremental();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingCallExpCSImpl <em>Mapping Call Exp CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingCallExpCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getMappingCallExpCS()
         * @generated
         */
        EClass MAPPING_CALL_EXP_CS = eINSTANCE.getMappingCallExpCS();

        /**
         * The meta object literal for the '<em><b>Strict</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MAPPING_CALL_EXP_CS__STRICT = eINSTANCE.getMappingCallExpCS_Strict();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.WhileExpCSImpl <em>While Exp CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.WhileExpCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getWhileExpCS()
         * @generated
         */
        EClass WHILE_EXP_CS = eINSTANCE.getWhileExpCS();

        /**
         * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference WHILE_EXP_CS__BODY = eINSTANCE.getWhileExpCS_Body();

								/**
         * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WHILE_EXP_CS__CONDITION = eINSTANCE.getWhileExpCS_Condition();

        /**
         * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WHILE_EXP_CS__RESULT = eINSTANCE.getWhileExpCS_Result();

        /**
         * The meta object literal for the '<em><b>Result Var</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference WHILE_EXP_CS__RESULT_VAR = eINSTANCE.getWhileExpCS_ResultVar();

								/**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.SwitchExpCSImpl <em>Switch Exp CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.SwitchExpCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getSwitchExpCS()
         * @generated
         */
        EClass SWITCH_EXP_CS = eINSTANCE.getSwitchExpCS();

        /**
         * The meta object literal for the '<em><b>Alternative Part</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SWITCH_EXP_CS__ALTERNATIVE_PART = eINSTANCE.getSwitchExpCS_AlternativePart();

        /**
         * The meta object literal for the '<em><b>Else Part</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SWITCH_EXP_CS__ELSE_PART = eINSTANCE.getSwitchExpCS_ElsePart();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.SwitchAltExpCSImpl <em>Switch Alt Exp CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.SwitchAltExpCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getSwitchAltExpCS()
         * @generated
         */
        EClass SWITCH_ALT_EXP_CS = eINSTANCE.getSwitchAltExpCS();

        /**
         * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SWITCH_ALT_EXP_CS__CONDITION = eINSTANCE.getSwitchAltExpCS_Condition();

        /**
         * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SWITCH_ALT_EXP_CS__BODY = eINSTANCE.getSwitchAltExpCS_Body();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.BlockExpCSImpl <em>Block Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.BlockExpCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getBlockExpCS()
         * @generated
         */
		EClass BLOCK_EXP_CS = eINSTANCE.getBlockExpCS();

								/**
         * The meta object literal for the '<em><b>Body Expressions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference BLOCK_EXP_CS__BODY_EXPRESSIONS = eINSTANCE.getBlockExpCS_BodyExpressions();

								/**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.DirectionKindCSImpl <em>Direction Kind CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.DirectionKindCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getDirectionKindCS()
         * @generated
         */
        EClass DIRECTION_KIND_CS = eINSTANCE.getDirectionKindCS();

        /**
         * The meta object literal for the '<em><b>Direction Kind</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DIRECTION_KIND_CS__DIRECTION_KIND = eINSTANCE.getDirectionKindCS_DirectionKind();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ElementWithBodyImpl <em>Element With Body</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ElementWithBodyImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getElementWithBody()
         * @generated
         */
        EClass ELEMENT_WITH_BODY = eINSTANCE.getElementWithBody();

        /**
         * The meta object literal for the '<em><b>Body Start Location</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ELEMENT_WITH_BODY__BODY_START_LOCATION = eINSTANCE.getElementWithBody_BodyStartLocation();

        /**
         * The meta object literal for the '<em><b>Body End Location</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ELEMENT_WITH_BODY__BODY_END_LOCATION = eINSTANCE.getElementWithBody_BodyEndLocation();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ResolveExpCSImpl <em>Resolve Exp CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ResolveExpCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getResolveExpCS()
         * @generated
         */
        EClass RESOLVE_EXP_CS = eINSTANCE.getResolveExpCS();

        /**
         * The meta object literal for the '<em><b>One</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RESOLVE_EXP_CS__ONE = eINSTANCE.getResolveExpCS_One();

        /**
         * The meta object literal for the '<em><b>Is Inverse</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RESOLVE_EXP_CS__IS_INVERSE = eINSTANCE.getResolveExpCS_IsInverse();

        /**
         * The meta object literal for the '<em><b>Is Deferred</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RESOLVE_EXP_CS__IS_DEFERRED = eINSTANCE.getResolveExpCS_IsDeferred();

        /**
         * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RESOLVE_EXP_CS__TARGET = eINSTANCE.getResolveExpCS_Target();

        /**
         * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RESOLVE_EXP_CS__CONDITION = eINSTANCE.getResolveExpCS_Condition();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ResolveInExpCSImpl <em>Resolve In Exp CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ResolveInExpCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getResolveInExpCS()
         * @generated
         */
        EClass RESOLVE_IN_EXP_CS = eINSTANCE.getResolveInExpCS();

        /**
         * The meta object literal for the '<em><b>In Mapping Type</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RESOLVE_IN_EXP_CS__IN_MAPPING_TYPE = eINSTANCE.getResolveInExpCS_InMappingType();

        /**
         * The meta object literal for the '<em><b>In Mapping Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RESOLVE_IN_EXP_CS__IN_MAPPING_NAME = eINSTANCE.getResolveInExpCS_InMappingName();

        /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ModelTypeCSImpl <em>Model Type CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ModelTypeCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getModelTypeCS()
         * @generated
         */
		EClass MODEL_TYPE_CS = eINSTANCE.getModelTypeCS();

								/**
         * The meta object literal for the '<em><b>Identifier CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MODEL_TYPE_CS__IDENTIFIER_CS = eINSTANCE.getModelTypeCS_IdentifierCS();

								/**
         * The meta object literal for the '<em><b>Compliance Kind CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MODEL_TYPE_CS__COMPLIANCE_KIND_CS = eINSTANCE.getModelTypeCS_ComplianceKindCS();

								/**
         * The meta object literal for the '<em><b>Package Refs</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MODEL_TYPE_CS__PACKAGE_REFS = eINSTANCE.getModelTypeCS_PackageRefs();

								/**
         * The meta object literal for the '<em><b>Where Statements</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MODEL_TYPE_CS__WHERE_STATEMENTS = eINSTANCE.getModelTypeCS_WhereStatements();

								/**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.PackageRefCSImpl <em>Package Ref CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.PackageRefCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getPackageRefCS()
         * @generated
         */
		EClass PACKAGE_REF_CS = eINSTANCE.getPackageRefCS();

								/**
         * The meta object literal for the '<em><b>Path Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PACKAGE_REF_CS__PATH_NAME_CS = eINSTANCE.getPackageRefCS_PathNameCS();

								/**
         * The meta object literal for the '<em><b>Uri CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PACKAGE_REF_CS__URI_CS = eINSTANCE.getPackageRefCS_UriCS();

								/**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.TransformationHeaderCSImpl <em>Transformation Header CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.TransformationHeaderCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getTransformationHeaderCS()
         * @generated
         */
		EClass TRANSFORMATION_HEADER_CS = eINSTANCE.getTransformationHeaderCS();

								/**
         * The meta object literal for the '<em><b>Qualifiers</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TRANSFORMATION_HEADER_CS__QUALIFIERS = eINSTANCE.getTransformationHeaderCS_Qualifiers();

								/**
         * The meta object literal for the '<em><b>Path Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TRANSFORMATION_HEADER_CS__PATH_NAME_CS = eINSTANCE.getTransformationHeaderCS_PathNameCS();

								/**
         * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TRANSFORMATION_HEADER_CS__PARAMETERS = eINSTANCE.getTransformationHeaderCS_Parameters();

								/**
         * The meta object literal for the '<em><b>Module Usages</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TRANSFORMATION_HEADER_CS__MODULE_USAGES = eINSTANCE.getTransformationHeaderCS_ModuleUsages();

								/**
         * The meta object literal for the '<em><b>Transformation Refine CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS = eINSTANCE.getTransformationHeaderCS_TransformationRefineCS();

								/**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ModuleKindCSImpl <em>Module Kind CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ModuleKindCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getModuleKindCS()
         * @generated
         */
		EClass MODULE_KIND_CS = eINSTANCE.getModuleKindCS();

								/**
         * The meta object literal for the '<em><b>Module Kind</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MODULE_KIND_CS__MODULE_KIND = eINSTANCE.getModuleKindCS_ModuleKind();

								/**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ModuleRefCSImpl <em>Module Ref CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ModuleRefCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getModuleRefCS()
         * @generated
         */
		EClass MODULE_REF_CS = eINSTANCE.getModuleRefCS();

								/**
         * The meta object literal for the '<em><b>Path Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MODULE_REF_CS__PATH_NAME_CS = eINSTANCE.getModuleRefCS_PathNameCS();

								/**
         * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MODULE_REF_CS__PARAMETERS = eINSTANCE.getModuleRefCS_Parameters();

								/**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ModuleUsageCSImpl <em>Module Usage CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ModuleUsageCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getModuleUsageCS()
         * @generated
         */
		EClass MODULE_USAGE_CS = eINSTANCE.getModuleUsageCS();

								/**
         * The meta object literal for the '<em><b>Import Kind</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MODULE_USAGE_CS__IMPORT_KIND = eINSTANCE.getModuleUsageCS_ImportKind();

								/**
         * The meta object literal for the '<em><b>Module Kind CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MODULE_USAGE_CS__MODULE_KIND_CS = eINSTANCE.getModuleUsageCS_ModuleKindCS();

								/**
         * The meta object literal for the '<em><b>Module Refs</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MODULE_USAGE_CS__MODULE_REFS = eINSTANCE.getModuleUsageCS_ModuleRefs();

								/**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.TransformationRefineCSImpl <em>Transformation Refine CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.TransformationRefineCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getTransformationRefineCS()
         * @generated
         */
		EClass TRANSFORMATION_REFINE_CS = eINSTANCE.getTransformationRefineCS();

								/**
         * The meta object literal for the '<em><b>Module Ref CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TRANSFORMATION_REFINE_CS__MODULE_REF_CS = eINSTANCE.getTransformationRefineCS_ModuleRefCS();

								/**
         * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS = eINSTANCE.getTransformationRefineCS_SimpleNameCS();

								/**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.TypeSpecCSImpl <em>Type Spec CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.TypeSpecCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getTypeSpecCS()
         * @generated
         */
		EClass TYPE_SPEC_CS = eINSTANCE.getTypeSpecCS();

								/**
         * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TYPE_SPEC_CS__TYPE_CS = eINSTANCE.getTypeSpecCS_TypeCS();

								/**
         * The meta object literal for the '<em><b>Simple Name CS</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TYPE_SPEC_CS__SIMPLE_NAME_CS = eINSTANCE.getTypeSpecCS_SimpleNameCS();

								/**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.LogExpCSImpl <em>Log Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.LogExpCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getLogExpCS()
         * @generated
         */
		EClass LOG_EXP_CS = eINSTANCE.getLogExpCS();

								/**
         * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LOG_EXP_CS__CONDITION = eINSTANCE.getLogExpCS_Condition();

								/**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.AssertExpCSImpl <em>Assert Exp CS</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.AssertExpCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getAssertExpCS()
         * @generated
         */
		EClass ASSERT_EXP_CS = eINSTANCE.getAssertExpCS();

								/**
         * The meta object literal for the '<em><b>Assertion</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ASSERT_EXP_CS__ASSERTION = eINSTANCE.getAssertExpCS_Assertion();

								/**
         * The meta object literal for the '<em><b>Log</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ASSERT_EXP_CS__LOG = eINSTANCE.getAssertExpCS_Log();

								/**
         * The meta object literal for the '<em><b>Severity</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ASSERT_EXP_CS__SEVERITY = eINSTANCE.getAssertExpCS_Severity();

								/**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ImperativeLoopExpCSImpl <em>Imperative Loop Exp CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ImperativeLoopExpCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getImperativeLoopExpCS()
         * @generated
         */
        EClass IMPERATIVE_LOOP_EXP_CS = eINSTANCE.getImperativeLoopExpCS();

                                /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.ImperativeIterateExpCSImpl <em>Imperative Iterate Exp CS</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.ImperativeIterateExpCSImpl
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getImperativeIterateExpCS()
         * @generated
         */
        EClass IMPERATIVE_ITERATE_EXP_CS = eINSTANCE.getImperativeIterateExpCS();

                                /**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindEnum <em>Direction Kind Enum</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindEnum
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getDirectionKindEnum()
         * @generated
         */
        EEnum DIRECTION_KIND_ENUM = eINSTANCE.getDirectionKindEnum();

								/**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModuleKindEnum <em>Module Kind Enum</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.ModuleKindEnum
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getModuleKindEnum()
         * @generated
         */
		EEnum MODULE_KIND_ENUM = eINSTANCE.getModuleKindEnum();

								/**
         * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.internal.cst.ImportKindEnum <em>Import Kind Enum</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.m2m.qvt.oml.internal.cst.ImportKindEnum
         * @see org.eclipse.m2m.qvt.oml.internal.cst.impl.CSTPackageImpl#getImportKindEnum()
         * @generated
         */
		EEnum IMPORT_KIND_ENUM = eINSTANCE.getImportKindEnum();

    }

} //CSTPackage
