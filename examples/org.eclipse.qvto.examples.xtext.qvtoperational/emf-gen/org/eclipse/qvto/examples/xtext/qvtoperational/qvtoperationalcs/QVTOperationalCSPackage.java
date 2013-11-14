/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeOCLCSPackage;

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
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import baseCST='/resource/org.eclipse.ocl.examples.xtext.base/model/BaseCS.ecore#/' ecore='http://www.eclipse.org/emf/2002/Ecore#/' essentialOCLCST='/resource/org.eclipse.ocl.examples.xtext.essentialocl/model/EssentialOCLCS.ecore#/' imperativeocl='/resource/org.eclipse.qvto.examples.pivot.imperativeocl/model/ImperativeOCL.ecore#ImperativeOCL' imperativeoclcs='/resource/org.eclipse.qvto.examples.xtext.imperativeocl/model/ImperativeOCLCS.ecore#/' qvtoperational='/resource/org.eclipse.qvto.examples.pivot.qvtoperational/model/QVTOperational.ecore#QVTOperational'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface QVTOperationalCSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qvtoperationalcs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/pivot/1.0/QVTOperationalCS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtoperationalcs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTOperationalCSPackage eINSTANCE = org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TopLevelCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTopLevelCS()
	 * @generated
	 */
	int TOP_LEVEL_CS = 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__LOGICAL_PARENT = BaseCSPackage.ROOT_PACKAGE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__PIVOT = BaseCSPackage.ROOT_PACKAGE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_ANNOTATION = BaseCSPackage.ROOT_PACKAGE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__ORIGINAL_XMI_ID = BaseCSPackage.ROOT_PACKAGE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__CSI = BaseCSPackage.ROOT_PACKAGE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Owned Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_NESTED_PACKAGE = BaseCSPackage.ROOT_PACKAGE_CS__OWNED_NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Owned Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_IMPORT = BaseCSPackage.ROOT_PACKAGE_CS__OWNED_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Library</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_LIBRARY = BaseCSPackage.ROOT_PACKAGE_CS__OWNED_LIBRARY;

	/**
	 * The feature id for the '<em><b>Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__IMPORT = BaseCSPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__UNIT = BaseCSPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_TYPE = BaseCSPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Top Level CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS_FEATURE_COUNT = BaseCSPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToClassCSImpl <em>QV To Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToClassCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQVToClassCS()
	 * @generated
	 */
	int QV_TO_CLASS_CS = 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__LOGICAL_PARENT = BaseCSPackage.CLASS_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__PIVOT = BaseCSPackage.CLASS_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__OWNED_ANNOTATION = BaseCSPackage.CLASS_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__ORIGINAL_XMI_ID = BaseCSPackage.CLASS_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__CSI = BaseCSPackage.CLASS_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__NAME = BaseCSPackage.CLASS_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__OWNED_TEMPLATE_SIGNATURE = BaseCSPackage.CLASS_CS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__OWNER = BaseCSPackage.CLASS_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__INSTANCE_CLASS_NAME = BaseCSPackage.CLASS_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__OWNED_CONSTRAINT = BaseCSPackage.CLASS_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__QUALIFIER = BaseCSPackage.CLASS_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owned Super Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__OWNED_SUPER_TYPE = BaseCSPackage.CLASS_CS__OWNED_SUPER_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__OWNED_OPERATION = BaseCSPackage.CLASS_CS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Owned Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__OWNED_PROPERTY = BaseCSPackage.CLASS_CS__OWNED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Owned Meta Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__OWNED_META_TYPE = BaseCSPackage.CLASS_CS__OWNED_META_TYPE;

	/**
	 * The feature id for the '<em><b>Intermediate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS__INTERMEDIATE = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>QV To Class CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_CLASS_CS_FEATURE_COUNT = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToImportCSImpl <em>QV To Import CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToImportCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQVToImportCS()
	 * @generated
	 */
	int QV_TO_IMPORT_CS = 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_IMPORT_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_IMPORT_CS__UNIT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Imported Unit Element</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_IMPORT_CS__IMPORTED_UNIT_ELEMENT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_IMPORT_CS__ALL = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>QV To Import CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_IMPORT_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingModuleCSImpl <em>Mapping Module CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingModuleCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingModuleCS()
	 * @generated
	 */
	int MAPPING_MODULE_CS = 31;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Header CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__HEADER_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__IMPORTS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Metamodels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__METAMODELS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Renamings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__RENAMINGS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__PROPERTIES = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__METHODS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Classifier Def CS</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__CLASSIFIER_DEF_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS__TAGS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Mapping Module CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODULE_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToLibraryCSImpl <em>QV To Library CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToLibraryCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQVToLibraryCS()
	 * @generated
	 */
	int QV_TO_LIBRARY_CS = 3;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__LOGICAL_PARENT = MAPPING_MODULE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Header CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__HEADER_CS = MAPPING_MODULE_CS__HEADER_CS;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__IMPORTS = MAPPING_MODULE_CS__IMPORTS;

	/**
	 * The feature id for the '<em><b>Metamodels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__METAMODELS = MAPPING_MODULE_CS__METAMODELS;

	/**
	 * The feature id for the '<em><b>Renamings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__RENAMINGS = MAPPING_MODULE_CS__RENAMINGS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__PROPERTIES = MAPPING_MODULE_CS__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__METHODS = MAPPING_MODULE_CS__METHODS;

	/**
	 * The feature id for the '<em><b>Classifier Def CS</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__CLASSIFIER_DEF_CS = MAPPING_MODULE_CS__CLASSIFIER_DEF_CS;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS__TAGS = MAPPING_MODULE_CS__TAGS;

	/**
	 * The number of structural features of the '<em>QV To Library CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_LIBRARY_CS_FEATURE_COUNT = MAPPING_MODULE_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToOperationCSImpl <em>QV To Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToOperationCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQVToOperationCS()
	 * @generated
	 */
	int QV_TO_OPERATION_CS = 4;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__LOGICAL_PARENT = BaseCSPackage.OPERATION_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__PIVOT = BaseCSPackage.OPERATION_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OWNED_ANNOTATION = BaseCSPackage.OPERATION_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__ORIGINAL_XMI_ID = BaseCSPackage.OPERATION_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__CSI = BaseCSPackage.OPERATION_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__NAME = BaseCSPackage.OPERATION_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OWNED_TYPE = BaseCSPackage.OPERATION_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__QUALIFIER = BaseCSPackage.OPERATION_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OPTIONAL = BaseCSPackage.OPERATION_CS__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OWNED_TEMPLATE_SIGNATURE = BaseCSPackage.OPERATION_CS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OWNING_CLASS = BaseCSPackage.OPERATION_CS__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OWNED_PARAMETER = BaseCSPackage.OPERATION_CS__OWNED_PARAMETER;

	/**
	 * The feature id for the '<em><b>Owned Exception</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OWNED_EXCEPTION = BaseCSPackage.OPERATION_CS__OWNED_EXCEPTION;

	/**
	 * The feature id for the '<em><b>Owned Precondition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OWNED_PRECONDITION = BaseCSPackage.OPERATION_CS__OWNED_PRECONDITION;

	/**
	 * The feature id for the '<em><b>Owned Postcondition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OWNED_POSTCONDITION = BaseCSPackage.OPERATION_CS__OWNED_POSTCONDITION;

	/**
	 * The feature id for the '<em><b>Owned Body Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__OWNED_BODY_EXPRESSION = BaseCSPackage.OPERATION_CS__OWNED_BODY_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS__STEREOTYPES = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>QV To Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QV_TO_OPERATION_CS_FEATURE_COUNT = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.OperationParameterDeclarationCSImpl <em>Operation Parameter Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.OperationParameterDeclarationCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getOperationParameterDeclarationCS()
	 * @generated
	 */
	int OPERATION_PARAMETER_DECLARATION_CS = 5;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_DECLARATION_CS__LOGICAL_PARENT = BaseCSPackage.PARAMETER_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_DECLARATION_CS__PIVOT = BaseCSPackage.PARAMETER_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_DECLARATION_CS__OWNED_ANNOTATION = BaseCSPackage.PARAMETER_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_DECLARATION_CS__ORIGINAL_XMI_ID = BaseCSPackage.PARAMETER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_DECLARATION_CS__CSI = BaseCSPackage.PARAMETER_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_DECLARATION_CS__NAME = BaseCSPackage.PARAMETER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_DECLARATION_CS__OWNED_TYPE = BaseCSPackage.PARAMETER_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_DECLARATION_CS__QUALIFIER = BaseCSPackage.PARAMETER_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_DECLARATION_CS__OPTIONAL = BaseCSPackage.PARAMETER_CS__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_DECLARATION_CS__OWNER = BaseCSPackage.PARAMETER_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_DECLARATION_CS__DIRECTION = BaseCSPackage.PARAMETER_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Init Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_DECLARATION_CS__INIT_PART = BaseCSPackage.PARAMETER_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation Parameter Declaration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_DECLARATION_CS_FEATURE_COUNT = BaseCSPackage.PARAMETER_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.OperationSimpleSignatureCSImpl <em>Operation Simple Signature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.OperationSimpleSignatureCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getOperationSimpleSignatureCS()
	 * @generated
	 */
	int OPERATION_SIMPLE_SIGNATURE_CS = 6;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SIMPLE_SIGNATURE_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SIMPLE_SIGNATURE_CS__PARAMETER = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation Simple Signature CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SIMPLE_SIGNATURE_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.InitPartCSImpl <em>Init Part CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.InitPartCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getInitPartCS()
	 * @generated
	 */
	int INIT_PART_CS = 7;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_PART_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Init Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_PART_CS__INIT_OP = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_PART_CS__EXPRESSION = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Init Part CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_PART_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MetamodelCSImpl <em>Metamodel CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MetamodelCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMetamodelCS()
	 * @generated
	 */
	int METAMODEL_CS = 8;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__LOGICAL_PARENT = BaseCSPackage.PACKAGE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__PIVOT = BaseCSPackage.PACKAGE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__OWNED_ANNOTATION = BaseCSPackage.PACKAGE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__ORIGINAL_XMI_ID = BaseCSPackage.PACKAGE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__CSI = BaseCSPackage.PACKAGE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Owned Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__OWNED_NESTED_PACKAGE = BaseCSPackage.PACKAGE_CS__OWNED_NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__NAME = BaseCSPackage.PACKAGE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__OWNED_TYPE = BaseCSPackage.PACKAGE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__NS_PREFIX = BaseCSPackage.PACKAGE_CS__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__NS_URI = BaseCSPackage.PACKAGE_CS__NS_URI;

	/**
	 * The feature id for the '<em><b>Metamodel Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS__METAMODEL_KIND = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Metamodel CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_CS_FEATURE_COUNT = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.PrimitiveTypeCSImpl <em>Primitive Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.PrimitiveTypeCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getPrimitiveTypeCS()
	 * @generated
	 */
	int PRIMITIVE_TYPE_CS = 9;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__LOGICAL_PARENT = BaseCSPackage.DATA_TYPE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__PIVOT = BaseCSPackage.DATA_TYPE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__OWNED_ANNOTATION = BaseCSPackage.DATA_TYPE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__ORIGINAL_XMI_ID = BaseCSPackage.DATA_TYPE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__CSI = BaseCSPackage.DATA_TYPE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__NAME = BaseCSPackage.DATA_TYPE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__OWNED_TEMPLATE_SIGNATURE = BaseCSPackage.DATA_TYPE_CS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__OWNER = BaseCSPackage.DATA_TYPE_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__INSTANCE_CLASS_NAME = BaseCSPackage.DATA_TYPE_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__OWNED_CONSTRAINT = BaseCSPackage.DATA_TYPE_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__QUALIFIER = BaseCSPackage.DATA_TYPE_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__LITERALS = BaseCSPackage.DATA_TYPE_CS__LITERALS;

	/**
	 * The number of structural features of the '<em>Primitive Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS_FEATURE_COUNT = BaseCSPackage.DATA_TYPE_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierPropertyCSImpl <em>Classifier Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierPropertyCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getClassifierPropertyCS()
	 * @generated
	 */
	int CLASSIFIER_PROPERTY_CS = 10;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__LOGICAL_PARENT = BaseCSPackage.STRUCTURAL_FEATURE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__PIVOT = BaseCSPackage.STRUCTURAL_FEATURE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__OWNED_ANNOTATION = BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__ORIGINAL_XMI_ID = BaseCSPackage.STRUCTURAL_FEATURE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__CSI = BaseCSPackage.STRUCTURAL_FEATURE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__NAME = BaseCSPackage.STRUCTURAL_FEATURE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__OWNED_TYPE = BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__QUALIFIER = BaseCSPackage.STRUCTURAL_FEATURE_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__OPTIONAL = BaseCSPackage.STRUCTURAL_FEATURE_CS__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__OWNER = BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__DEFAULT = BaseCSPackage.STRUCTURAL_FEATURE_CS__DEFAULT;

	/**
	 * The feature id for the '<em><b>Owned Default Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__OWNED_DEFAULT_EXPRESSION = BaseCSPackage.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__STEREOTYPES = BaseCSPackage.STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS__OPPOSITE = BaseCSPackage.STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Classifier Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY_CS_FEATURE_COUNT = BaseCSPackage.STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.StereotypeQualifierCSImpl <em>Stereotype Qualifier CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.StereotypeQualifierCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getStereotypeQualifierCS()
	 * @generated
	 */
	int STEREOTYPE_QUALIFIER_CS = 11;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_QUALIFIER_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_QUALIFIER_CS__STEREOTYPE = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stereotype Qualifier CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_QUALIFIER_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TagCSImpl <em>Tag CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TagCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTagCS()
	 * @generated
	 */
	int TAG_CS = 12;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__LOGICAL_PARENT = BaseCSPackage.ANNOTATION_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__PIVOT = BaseCSPackage.ANNOTATION_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__OWNED_ANNOTATION = BaseCSPackage.ANNOTATION_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__ORIGINAL_XMI_ID = BaseCSPackage.ANNOTATION_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__CSI = BaseCSPackage.ANNOTATION_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__NAME = BaseCSPackage.ANNOTATION_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Detail</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__OWNED_DETAIL = BaseCSPackage.ANNOTATION_CS__OWNED_DETAIL;

	/**
	 * The feature id for the '<em><b>Owned Content</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__OWNED_CONTENT = BaseCSPackage.ANNOTATION_CS__OWNED_CONTENT;

	/**
	 * The feature id for the '<em><b>Owned Reference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__OWNED_REFERENCE = BaseCSPackage.ANNOTATION_CS__OWNED_REFERENCE;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__PATH_NAME = BaseCSPackage.ANNOTATION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS__EXPRESSION = BaseCSPackage.ANNOTATION_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tag CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_CS_FEATURE_COUNT = BaseCSPackage.ANNOTATION_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ExceptionCSImpl <em>Exception CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ExceptionCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getExceptionCS()
	 * @generated
	 */
	int EXCEPTION_CS = 13;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__LOGICAL_PARENT = BaseCSPackage.CLASS_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__PIVOT = BaseCSPackage.CLASS_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__OWNED_ANNOTATION = BaseCSPackage.CLASS_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__ORIGINAL_XMI_ID = BaseCSPackage.CLASS_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__CSI = BaseCSPackage.CLASS_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__NAME = BaseCSPackage.CLASS_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__OWNED_TEMPLATE_SIGNATURE = BaseCSPackage.CLASS_CS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__OWNER = BaseCSPackage.CLASS_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__INSTANCE_CLASS_NAME = BaseCSPackage.CLASS_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__OWNED_CONSTRAINT = BaseCSPackage.CLASS_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__QUALIFIER = BaseCSPackage.CLASS_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owned Super Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__OWNED_SUPER_TYPE = BaseCSPackage.CLASS_CS__OWNED_SUPER_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__OWNED_OPERATION = BaseCSPackage.CLASS_CS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Owned Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__OWNED_PROPERTY = BaseCSPackage.CLASS_CS__OWNED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Owned Meta Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS__OWNED_META_TYPE = BaseCSPackage.CLASS_CS__OWNED_META_TYPE;

	/**
	 * The number of structural features of the '<em>Exception CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CS_FEATURE_COUNT = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierDefCSImpl <em>Classifier Def CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierDefCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getClassifierDefCS()
	 * @generated
	 */
	int CLASSIFIER_DEF_CS = 14;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__SIMPLE_NAME_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__EXTENDS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__PROPERTIES = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS__TAGS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Classifier Def CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_DEF_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModulePropertyCSImpl <em>Module Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModulePropertyCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModulePropertyCS()
	 * @generated
	 */
	int MODULE_PROPERTY_CS = 39;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_PROPERTY_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_PROPERTY_CS__SIMPLE_NAME_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Module Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_PROPERTY_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.LocalPropertyCSImpl <em>Local Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.LocalPropertyCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getLocalPropertyCS()
	 * @generated
	 */
	int LOCAL_PROPERTY_CS = 23;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_PROPERTY_CS__LOGICAL_PARENT = MODULE_PROPERTY_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierProperty2CSImpl <em>Classifier Property2 CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierProperty2CSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getClassifierProperty2CS()
	 * @generated
	 */
	int CLASSIFIER_PROPERTY2_CS = 15;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__LOGICAL_PARENT = LOCAL_PROPERTY_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__SIMPLE_NAME_CS = LOCAL_PROPERTY_CS__SIMPLE_NAME_CS;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__TYPE_CS = LOCAL_PROPERTY_CS__TYPE_CS;

	/**
	 * The feature id for the '<em><b>Ocl Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__OCL_EXPRESSION_CS = LOCAL_PROPERTY_CS__OCL_EXPRESSION_CS;

	/**
	 * The feature id for the '<em><b>Stereotype Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__STEREOTYPE_QUALIFIERS = LOCAL_PROPERTY_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Feature Keys</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__FEATURE_KEYS = LOCAL_PROPERTY_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__MULTIPLICITY = LOCAL_PROPERTY_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__OPPOSITE = LOCAL_PROPERTY_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS__IS_ORDERED = LOCAL_PROPERTY_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Classifier Property2 CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_PROPERTY2_CS_FEATURE_COUNT = LOCAL_PROPERTY_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.CompleteSignatureCSImpl <em>Complete Signature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.CompleteSignatureCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getCompleteSignatureCS()
	 * @generated
	 */
	int COMPLETE_SIGNATURE_CS = 16;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SIGNATURE_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Simple Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Result Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SIGNATURE_CS__RESULT_PARAMS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Complete Signature CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SIGNATURE_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ConfigPropertyCSImpl <em>Config Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ConfigPropertyCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getConfigPropertyCS()
	 * @generated
	 */
	int CONFIG_PROPERTY_CS = 17;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY_CS__LOGICAL_PARENT = MODULE_PROPERTY_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingMethodCSImpl <em>Mapping Method CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingMethodCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingMethodCS()
	 * @generated
	 */
	int MAPPING_METHOD_CS = 30;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_METHOD_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Black Box</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_METHOD_CS__BLACK_BOX = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping Declaration CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_METHOD_CS__MAPPING_DECLARATION_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping Method CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_METHOD_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ConstructorCSImpl <em>Constructor CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ConstructorCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getConstructorCS()
	 * @generated
	 */
	int CONSTRUCTOR_CS = 18;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CS__LOGICAL_PARENT = MAPPING_METHOD_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Black Box</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CS__BLACK_BOX = MAPPING_METHOD_CS__BLACK_BOX;

	/**
	 * The feature id for the '<em><b>Mapping Declaration CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CS__MAPPING_DECLARATION_CS = MAPPING_METHOD_CS__MAPPING_DECLARATION_CS;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CS__EXPRESSIONS = MAPPING_METHOD_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constructor CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CS_FEATURE_COUNT = MAPPING_METHOD_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ContextualPropertyCSImpl <em>Contextual Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ContextualPropertyCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getContextualPropertyCS()
	 * @generated
	 */
	int CONTEXTUAL_PROPERTY_CS = 19;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_CS__LOGICAL_PARENT = MODULE_PROPERTY_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_CS__SIMPLE_NAME_CS = MODULE_PROPERTY_CS__SIMPLE_NAME_CS;

	/**
	 * The feature id for the '<em><b>Scoped Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_CS__SCOPED_NAME_CS = MODULE_PROPERTY_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_CS__TYPE_CS = MODULE_PROPERTY_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ocl Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_CS__OCL_EXPRESSION_CS = MODULE_PROPERTY_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Contextual Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_PROPERTY_CS_FEATURE_COUNT = MODULE_PROPERTY_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindCS <em>Direction Kind CS</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindCS
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getDirectionKindCS()
	 * @generated
	 */
	int DIRECTION_KIND_CS = 60;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ElementWithBodyImpl <em>Element With Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ElementWithBodyImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getElementWithBody()
	 * @generated
	 */
	int ELEMENT_WITH_BODY = 20;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_WITH_BODY__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_WITH_BODY__BODY_START_LOCATION = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body End Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_WITH_BODY__BODY_END_LOCATION = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Element With Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_WITH_BODY_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ImperativeOperationCallExpCSImpl <em>Imperative Operation Call Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ImperativeOperationCallExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getImperativeOperationCallExpCS()
	 * @generated
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS = 21;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__LOGICAL_PARENT = EssentialOCLCSPackage.INVOCATION_EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__PIVOT = EssentialOCLCSPackage.INVOCATION_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__OWNED_ANNOTATION = EssentialOCLCSPackage.INVOCATION_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__ORIGINAL_XMI_ID = EssentialOCLCSPackage.INVOCATION_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__CSI = EssentialOCLCSPackage.INVOCATION_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__PARENT = EssentialOCLCSPackage.INVOCATION_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Name Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__NAME_EXP = EssentialOCLCSPackage.INVOCATION_EXP_CS__NAME_EXP;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__ARGUMENT = EssentialOCLCSPackage.INVOCATION_EXP_CS__ARGUMENT;

	/**
	 * The feature id for the '<em><b>Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS__MODULE = EssentialOCLCSPackage.INVOCATION_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Imperative Operation Call Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OPERATION_CALL_EXP_CS_FEATURE_COUNT = EssentialOCLCSPackage.INVOCATION_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.LibraryImportCSImpl <em>Library Import CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.LibraryImportCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getLibraryImportCS()
	 * @generated
	 */
	int LIBRARY_IMPORT_CS = 22;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__LOGICAL_PARENT = QV_TO_IMPORT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__UNIT = QV_TO_IMPORT_CS__UNIT;

	/**
	 * The feature id for the '<em><b>Imported Unit Element</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__IMPORTED_UNIT_ELEMENT = QV_TO_IMPORT_CS__IMPORTED_UNIT_ELEMENT;

	/**
	 * The feature id for the '<em><b>All</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS__ALL = QV_TO_IMPORT_CS__ALL;

	/**
	 * The number of structural features of the '<em>Library Import CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_IMPORT_CS_FEATURE_COUNT = QV_TO_IMPORT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingSectionCSImpl <em>Mapping Section CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingSectionCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingSectionCS()
	 * @generated
	 */
	int MAPPING_SECTION_CS = 34;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__BODY_START_LOCATION = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body End Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__BODY_END_LOCATION = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__STATEMENTS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mapping Rule CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS__MAPPING_RULE_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mapping Section CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTION_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingBodyCSImpl <em>Mapping Body CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingBodyCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingBodyCS()
	 * @generated
	 */
	int MAPPING_BODY_CS = 24;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS__LOGICAL_PARENT = MAPPING_SECTION_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS__BODY_START_LOCATION = MAPPING_SECTION_CS__BODY_START_LOCATION;

	/**
	 * The feature id for the '<em><b>Body End Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS__BODY_END_LOCATION = MAPPING_SECTION_CS__BODY_END_LOCATION;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS__STATEMENTS = MAPPING_SECTION_CS__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Mapping Rule CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS__MAPPING_RULE_CS = MAPPING_SECTION_CS__MAPPING_RULE_CS;

	/**
	 * The feature id for the '<em><b>Has Population Keyword</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS__HAS_POPULATION_KEYWORD = MAPPING_SECTION_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapping Body CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_CS_FEATURE_COUNT = MAPPING_SECTION_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingCallExpCSImpl <em>Mapping Call Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingCallExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingCallExpCS()
	 * @generated
	 */
	int MAPPING_CALL_EXP_CS = 25;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__LOGICAL_PARENT = IMPERATIVE_OPERATION_CALL_EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__PIVOT = IMPERATIVE_OPERATION_CALL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__OWNED_ANNOTATION = IMPERATIVE_OPERATION_CALL_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__ORIGINAL_XMI_ID = IMPERATIVE_OPERATION_CALL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__CSI = IMPERATIVE_OPERATION_CALL_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__PARENT = IMPERATIVE_OPERATION_CALL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Name Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__NAME_EXP = IMPERATIVE_OPERATION_CALL_EXP_CS__NAME_EXP;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__ARGUMENT = IMPERATIVE_OPERATION_CALL_EXP_CS__ARGUMENT;

	/**
	 * The feature id for the '<em><b>Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__MODULE = IMPERATIVE_OPERATION_CALL_EXP_CS__MODULE;

	/**
	 * The feature id for the '<em><b>Strict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS__STRICT = IMPERATIVE_OPERATION_CALL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapping Call Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_EXP_CS_FEATURE_COUNT = IMPERATIVE_OPERATION_CALL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingOperationCSImpl <em>Mapping Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingOperationCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingOperationCS()
	 * @generated
	 */
	int MAPPING_OPERATION_CS = 26;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__LOGICAL_PARENT = BaseCSPackage.OPERATION_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__PIVOT = BaseCSPackage.OPERATION_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OWNED_ANNOTATION = BaseCSPackage.OPERATION_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__ORIGINAL_XMI_ID = BaseCSPackage.OPERATION_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__CSI = BaseCSPackage.OPERATION_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__NAME = BaseCSPackage.OPERATION_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OWNED_TYPE = BaseCSPackage.OPERATION_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__QUALIFIER = BaseCSPackage.OPERATION_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OPTIONAL = BaseCSPackage.OPERATION_CS__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OWNED_TEMPLATE_SIGNATURE = BaseCSPackage.OPERATION_CS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OWNING_CLASS = BaseCSPackage.OPERATION_CS__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OWNED_PARAMETER = BaseCSPackage.OPERATION_CS__OWNED_PARAMETER;

	/**
	 * The feature id for the '<em><b>Owned Exception</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OWNED_EXCEPTION = BaseCSPackage.OPERATION_CS__OWNED_EXCEPTION;

	/**
	 * The feature id for the '<em><b>Owned Precondition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OWNED_PRECONDITION = BaseCSPackage.OPERATION_CS__OWNED_PRECONDITION;

	/**
	 * The feature id for the '<em><b>Owned Postcondition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OWNED_POSTCONDITION = BaseCSPackage.OPERATION_CS__OWNED_POSTCONDITION;

	/**
	 * The feature id for the '<em><b>Owned Body Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__OWNED_BODY_EXPRESSION = BaseCSPackage.OPERATION_CS__OWNED_BODY_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Context Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__CONTEXT_TYPE = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__RESULT = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Direction Kind CS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__DIRECTION_KIND_CS = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mapping Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__MAPPING_EXTENSION = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS__IS_QUERY = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Mapping Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_CS_FEATURE_COUNT = BaseCSPackage.OPERATION_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingEndCSImpl <em>Mapping End CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingEndCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingEndCS()
	 * @generated
	 */
	int MAPPING_END_CS = 27;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_END_CS__LOGICAL_PARENT = MAPPING_SECTION_CS__LOGICAL_PARENT;

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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingExtensionCSImpl <em>Mapping Extension CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingExtensionCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingExtensionCS()
	 * @generated
	 */
	int MAPPING_EXTENSION_CS = 28;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_EXTENSION_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_REF_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_EXTENSION_CS__PIVOT = BaseCSPackage.ELEMENT_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_EXTENSION_CS__KIND = BaseCSPackage.ELEMENT_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping Identifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_EXTENSION_CS__MAPPING_IDENTIFIERS = BaseCSPackage.ELEMENT_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping Extension CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_EXTENSION_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingInitCSImpl <em>Mapping Init CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingInitCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingInitCS()
	 * @generated
	 */
	int MAPPING_INIT_CS = 29;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INIT_CS__LOGICAL_PARENT = MAPPING_SECTION_CS__LOGICAL_PARENT;

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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingQueryCSImpl <em>Mapping Query CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingQueryCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingQueryCS()
	 * @generated
	 */
	int MAPPING_QUERY_CS = 32;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS__LOGICAL_PARENT = MAPPING_METHOD_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Black Box</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS__BLACK_BOX = MAPPING_METHOD_CS__BLACK_BOX;

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
	 * The feature id for the '<em><b>Is Simple Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS__IS_SIMPLE_DEFINITION = MAPPING_METHOD_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping Query CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_QUERY_CS_FEATURE_COUNT = MAPPING_METHOD_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingRuleCSImpl <em>Mapping Rule CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingRuleCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingRuleCS()
	 * @generated
	 */
	int MAPPING_RULE_CS = 33;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS__LOGICAL_PARENT = MAPPING_METHOD_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Black Box</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS__BLACK_BOX = MAPPING_METHOD_CS__BLACK_BOX;

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
	 * The feature id for the '<em><b>Mapping Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS__MAPPING_BODY = MAPPING_METHOD_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping Rule CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_CS_FEATURE_COUNT = MAPPING_METHOD_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingSectionsCSImpl <em>Mapping Sections CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingSectionsCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingSectionsCS()
	 * @generated
	 */
	int MAPPING_SECTIONS_CS = 35;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Mapping Init CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS__MAPPING_INIT_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping Body CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS__MAPPING_BODY_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mapping End CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS__MAPPING_END_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mapping Sections CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SECTIONS_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModuleKindCSImpl <em>Module Kind CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModuleKindCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModuleKindCS()
	 * @generated
	 */
	int MODULE_KIND_CS = 36;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_KIND_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Module Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_KIND_CS__MODULE_KIND = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Module Kind CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_KIND_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModuleRefCSImpl <em>Module Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModuleRefCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModuleRefCS()
	 * @generated
	 */
	int MODULE_REF_CS = 37;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_REF_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_REF_CS__PATH_NAME_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_REF_CS__PARAMETERS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Module Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_REF_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModelTypeCSImpl <em>Model Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModelTypeCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModelTypeCS()
	 * @generated
	 */
	int MODEL_TYPE_CS = 38;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__LOGICAL_PARENT = BaseCSPackage.CLASS_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__PIVOT = BaseCSPackage.CLASS_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__OWNED_ANNOTATION = BaseCSPackage.CLASS_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__ORIGINAL_XMI_ID = BaseCSPackage.CLASS_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__CSI = BaseCSPackage.CLASS_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__NAME = BaseCSPackage.CLASS_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__OWNED_TEMPLATE_SIGNATURE = BaseCSPackage.CLASS_CS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__OWNER = BaseCSPackage.CLASS_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__INSTANCE_CLASS_NAME = BaseCSPackage.CLASS_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__OWNED_CONSTRAINT = BaseCSPackage.CLASS_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__QUALIFIER = BaseCSPackage.CLASS_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Owned Super Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__OWNED_SUPER_TYPE = BaseCSPackage.CLASS_CS__OWNED_SUPER_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__OWNED_OPERATION = BaseCSPackage.CLASS_CS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Owned Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__OWNED_PROPERTY = BaseCSPackage.CLASS_CS__OWNED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Owned Meta Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__OWNED_META_TYPE = BaseCSPackage.CLASS_CS__OWNED_META_TYPE;

	/**
	 * The feature id for the '<em><b>Body Start Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__BODY_START_LOCATION = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body End Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__BODY_END_LOCATION = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Identifier CS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__IDENTIFIER_CS = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Compliance Kind CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__COMPLIANCE_KIND_CS = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Package Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__PACKAGE_REFS = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Where Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS__WHERE_STATEMENTS = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Model Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_CS_FEATURE_COUNT = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModuleUsageCSImpl <em>Module Usage CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModuleUsageCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModuleUsageCS()
	 * @generated
	 */
	int MODULE_USAGE_CS = 40;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Import Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS__IMPORT_KIND = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Module Kind CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS__MODULE_KIND_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Module Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS__MODULE_REFS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Module Usage CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_USAGE_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MultiplicityDefCSImpl <em>Multiplicity Def CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MultiplicityDefCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMultiplicityDefCS()
	 * @generated
	 */
	int MULTIPLICITY_DEF_CS = 41;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_DEF_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_DEF_CS__LOWER_BOUND = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_DEF_CS__UPPER_BOUND = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Multiplicity Def CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_DEF_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ObjectExpCSImpl <em>Object Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ObjectExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getObjectExpCS()
	 * @generated
	 */
	int OBJECT_EXP_CS = 42;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__LOGICAL_PARENT = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__PIVOT = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__OWNED_ANNOTATION = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__ORIGINAL_XMI_ID = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__CSI = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__PARENT = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__BODY = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS__BODY;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__SIMPLE_NAME_CS = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS__IS_IMPLICIT = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EXP_CS_FEATURE_COUNT = ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.OppositePropertyCSImpl <em>Opposite Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.OppositePropertyCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getOppositePropertyCS()
	 * @generated
	 */
	int OPPOSITE_PROPERTY_CS = 43;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Is Navigable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS__IS_NAVIGABLE = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS__SIMPLE_NAME_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS__MULTIPLICITY = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Opposite Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ParameterDeclarationCSImpl <em>Parameter Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ParameterDeclarationCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getParameterDeclarationCS()
	 * @generated
	 */
	int PARAMETER_DECLARATION_CS = 44;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__LOGICAL_PARENT = BaseCSPackage.TYPED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__PIVOT = BaseCSPackage.TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__OWNED_ANNOTATION = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__ORIGINAL_XMI_ID = BaseCSPackage.TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__CSI = BaseCSPackage.TYPED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__NAME = BaseCSPackage.TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__OWNED_TYPE = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__QUALIFIER = BaseCSPackage.TYPED_ELEMENT_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__OPTIONAL = BaseCSPackage.TYPED_ELEMENT_CS__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__DIRECTION = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Init Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS__INIT_PART = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameter Declaration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_CS_FEATURE_COUNT = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.RenameCSImpl <em>Rename CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.RenameCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getRenameCS()
	 * @generated
	 */
	int RENAME_CS = 45;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS__TYPE_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS__SIMPLE_NAME_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Original Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS__ORIGINAL_NAME = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Rename CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAME_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ResolveOpArgsExpCSImpl <em>Resolve Op Args Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ResolveOpArgsExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getResolveOpArgsExpCS()
	 * @generated
	 */
	int RESOLVE_OP_ARGS_EXP_CS = 46;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS__TARGET = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS__CONDITION = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resolve Op Args Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_OP_ARGS_EXP_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.PackageRefCSImpl <em>Package Ref CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.PackageRefCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getPackageRefCS()
	 * @generated
	 */
	int PACKAGE_REF_CS = 47;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS__PATH_NAME_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uri CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS__URI_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Package Ref CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REF_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ScopedNameCSImpl <em>Scoped Name CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ScopedNameCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getScopedNameCS()
	 * @generated
	 */
	int SCOPED_NAME_CS = 48;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS__TYPE_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS__NAME = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Scoped Name CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPED_NAME_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.SimpleSignatureCSImpl <em>Simple Signature CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.SimpleSignatureCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getSimpleSignatureCS()
	 * @generated
	 */
	int SIMPLE_SIGNATURE_CS = 49;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SIGNATURE_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SIGNATURE_CS__PARAMETER = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Signature CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SIGNATURE_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTransformationCS()
	 * @generated
	 */
	int TRANSFORMATION_CS = 50;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__LOGICAL_PARENT = BaseCSPackage.PACKAGE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__PIVOT = BaseCSPackage.PACKAGE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_ANNOTATION = BaseCSPackage.PACKAGE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__ORIGINAL_XMI_ID = BaseCSPackage.PACKAGE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__CSI = BaseCSPackage.PACKAGE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Owned Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_NESTED_PACKAGE = BaseCSPackage.PACKAGE_CS__OWNED_NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__NAME = BaseCSPackage.PACKAGE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_TYPE = BaseCSPackage.PACKAGE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__NS_PREFIX = BaseCSPackage.PACKAGE_CS__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__NS_URI = BaseCSPackage.PACKAGE_CS__NS_URI;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_TEMPLATE_SIGNATURE = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNER = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__INSTANCE_CLASS_NAME = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_CONSTRAINT = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__QUALIFIER = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owned Super Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_SUPER_TYPE = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_OPERATION = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Owned Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_PROPERTY = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Owned Meta Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_META_TYPE = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__QUALIFIERS = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Path Name CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__PATH_NAME_CS = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__PARAMETERS = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Module Usages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__MODULE_USAGES = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Transformation Refine CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__TRANSFORMATION_REFINE_CS = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Transformation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS_FEATURE_COUNT = BaseCSPackage.PACKAGE_CS_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationRefineCSImpl <em>Transformation Refine CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationRefineCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTransformationRefineCS()
	 * @generated
	 */
	int TRANSFORMATION_REFINE_CS = 51;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_REFINE_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Module Ref CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_REFINE_CS__MODULE_REF_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Name CS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Transformation Refine CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_REFINE_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TypeSpecCSImpl <em>Type Spec CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TypeSpecCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTypeSpecCS()
	 * @generated
	 */
	int TYPE_SPEC_CS = 52;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS__LOGICAL_PARENT = BaseCSPackage.TYPED_REF_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS__PIVOT = BaseCSPackage.TYPED_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS__MULTIPLICITY = BaseCSPackage.TYPED_REF_CS__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS__OWNED_TYPE = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extent Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS__EXTENT_LOCATION = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Spec CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPEC_CS_FEATURE_COUNT = BaseCSPackage.TYPED_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.UnitCSImpl <em>Unit CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.UnitCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getUnitCS()
	 * @generated
	 */
	int UNIT_CS = 53;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__LOGICAL_PARENT = BaseCSPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Segment</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__SEGMENT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Top Level Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__TOP_LEVEL_ELEMENTS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__MODULES = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Model Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__MODEL_TYPES = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__IMPORTS = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Unit CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS_FEATURE_COUNT = BaseCSPackage.ELEMENT_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ResolveExpCSImpl <em>Resolve Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ResolveExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getResolveExpCS()
	 * @generated
	 */
	int RESOLVE_EXP_CS = 54;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__LOGICAL_PARENT = EssentialOCLCSPackage.INVOCATION_EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__PIVOT = EssentialOCLCSPackage.INVOCATION_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__OWNED_ANNOTATION = EssentialOCLCSPackage.INVOCATION_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__ORIGINAL_XMI_ID = EssentialOCLCSPackage.INVOCATION_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__CSI = EssentialOCLCSPackage.INVOCATION_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__PARENT = EssentialOCLCSPackage.INVOCATION_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Name Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__NAME_EXP = EssentialOCLCSPackage.INVOCATION_EXP_CS__NAME_EXP;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__ARGUMENT = EssentialOCLCSPackage.INVOCATION_EXP_CS__ARGUMENT;

	/**
	 * The feature id for the '<em><b>One</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__ONE = EssentialOCLCSPackage.INVOCATION_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Inverse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__IS_INVERSE = EssentialOCLCSPackage.INVOCATION_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Deferred</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__IS_DEFERRED = EssentialOCLCSPackage.INVOCATION_EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__TARGET = EssentialOCLCSPackage.INVOCATION_EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS__CONDITION = EssentialOCLCSPackage.INVOCATION_EXP_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Resolve Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_EXP_CS_FEATURE_COUNT = EssentialOCLCSPackage.INVOCATION_EXP_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ResolveInExpCSImpl <em>Resolve In Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ResolveInExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getResolveInExpCS()
	 * @generated
	 */
	int RESOLVE_IN_EXP_CS = 55;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__LOGICAL_PARENT = RESOLVE_EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__PIVOT = RESOLVE_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__OWNED_ANNOTATION = RESOLVE_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__ORIGINAL_XMI_ID = RESOLVE_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__CSI = RESOLVE_EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__PARENT = RESOLVE_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Name Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__NAME_EXP = RESOLVE_EXP_CS__NAME_EXP;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_IN_EXP_CS__ARGUMENT = RESOLVE_EXP_CS__ARGUMENT;

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
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierKind <em>Classifier Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierKind
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getClassifierKind()
	 * @generated
	 */
	int CLASSIFIER_KIND = 56;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.FeatureKey <em>Feature Key</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.FeatureKey
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getFeatureKey()
	 * @generated
	 */
	int FEATURE_KEY = 57;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitOp <em>Init Op</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitOp
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getInitOp()
	 * @generated
	 */
	int INIT_OP = 58;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind <em>Metamodel Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMetamodelKind()
	 * @generated
	 */
	int METAMODEL_KIND = 59;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportKindEnum <em>Import Kind Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportKindEnum
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getImportKindEnum()
	 * @generated
	 */
	int IMPORT_KIND_ENUM = 61;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionKindCS <em>Mapping Extension Kind CS</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionKindCS
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingExtensionKindCS()
	 * @generated
	 */
	int MAPPING_EXTENSION_KIND_CS = 62;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindEnum <em>Module Kind Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindEnum
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModuleKindEnum()
	 * @generated
	 */
	int MODULE_KIND_ENUM = 63;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QualifierKindCS <em>Qualifier Kind CS</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QualifierKindCS
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQualifierKindCS()
	 * @generated
	 */
	int QUALIFIER_KIND_CS = 64;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS <em>Top Level CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Level CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS
	 * @generated
	 */
	EClass getTopLevelCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS#getImport()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_Import();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unit</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS#getUnit()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_Unit();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Type</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS#getOwnedType()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_OwnedType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToClassCS <em>QV To Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QV To Class CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToClassCS
	 * @generated
	 */
	EClass getQVToClassCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToClassCS#isIntermediate <em>Intermediate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Intermediate</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToClassCS#isIntermediate()
	 * @see #getQVToClassCS()
	 * @generated
	 */
	EAttribute getQVToClassCS_Intermediate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToImportCS <em>QV To Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QV To Import CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToImportCS
	 * @generated
	 */
	EClass getQVToImportCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToImportCS#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToImportCS#getUnit()
	 * @see #getQVToImportCS()
	 * @generated
	 */
	EReference getQVToImportCS_Unit();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToImportCS#getImportedUnitElement <em>Imported Unit Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Imported Unit Element</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToImportCS#getImportedUnitElement()
	 * @see #getQVToImportCS()
	 * @generated
	 */
	EAttribute getQVToImportCS_ImportedUnitElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToImportCS#isAll <em>All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>All</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToImportCS#isAll()
	 * @see #getQVToImportCS()
	 * @generated
	 */
	EAttribute getQVToImportCS_All();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToLibraryCS <em>QV To Library CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QV To Library CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToLibraryCS
	 * @generated
	 */
	EClass getQVToLibraryCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToOperationCS <em>QV To Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QV To Operation CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToOperationCS
	 * @generated
	 */
	EClass getQVToOperationCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToOperationCS#getStereotypes <em>Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stereotypes</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToOperationCS#getStereotypes()
	 * @see #getQVToOperationCS()
	 * @generated
	 */
	EReference getQVToOperationCS_Stereotypes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS <em>Operation Parameter Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Parameter Declaration CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS
	 * @generated
	 */
	EClass getOperationParameterDeclarationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS#getDirection()
	 * @see #getOperationParameterDeclarationCS()
	 * @generated
	 */
	EAttribute getOperationParameterDeclarationCS_Direction();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS#getInitPart <em>Init Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Part</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS#getInitPart()
	 * @see #getOperationParameterDeclarationCS()
	 * @generated
	 */
	EReference getOperationParameterDeclarationCS_InitPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationSimpleSignatureCS <em>Operation Simple Signature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Simple Signature CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationSimpleSignatureCS
	 * @generated
	 */
	EClass getOperationSimpleSignatureCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationSimpleSignatureCS#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationSimpleSignatureCS#getParameter()
	 * @see #getOperationSimpleSignatureCS()
	 * @generated
	 */
	EReference getOperationSimpleSignatureCS_Parameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS <em>Init Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Init Part CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS
	 * @generated
	 */
	EClass getInitPartCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS#getInitOp <em>Init Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Init Op</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS#getInitOp()
	 * @see #getInitPartCS()
	 * @generated
	 */
	EAttribute getInitPartCS_InitOp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS#getExpression()
	 * @see #getInitPartCS()
	 * @generated
	 */
	EReference getInitPartCS_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS <em>Metamodel CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metamodel CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS
	 * @generated
	 */
	EClass getMetamodelCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS#getMetamodelKind <em>Metamodel Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metamodel Kind</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS#getMetamodelKind()
	 * @see #getMetamodelCS()
	 * @generated
	 */
	EAttribute getMetamodelCS_MetamodelKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PrimitiveTypeCS <em>Primitive Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PrimitiveTypeCS
	 * @generated
	 */
	EClass getPrimitiveTypeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS <em>Classifier Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier Property CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS
	 * @generated
	 */
	EClass getClassifierPropertyCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getStereotypes <em>Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stereotypes</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getStereotypes()
	 * @see #getClassifierPropertyCS()
	 * @generated
	 */
	EReference getClassifierPropertyCS_Stereotypes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Opposite</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getOpposite()
	 * @see #getClassifierPropertyCS()
	 * @generated
	 */
	EAttribute getClassifierPropertyCS_Opposite();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.StereotypeQualifierCS <em>Stereotype Qualifier CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype Qualifier CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.StereotypeQualifierCS
	 * @generated
	 */
	EClass getStereotypeQualifierCS();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.StereotypeQualifierCS#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Stereotype</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.StereotypeQualifierCS#getStereotype()
	 * @see #getStereotypeQualifierCS()
	 * @generated
	 */
	EAttribute getStereotypeQualifierCS_Stereotype();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS <em>Tag CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS
	 * @generated
	 */
	EClass getTagCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS#getPathName()
	 * @see #getTagCS()
	 * @generated
	 */
	EReference getTagCS_PathName();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS#getExpression()
	 * @see #getTagCS()
	 * @generated
	 */
	EReference getTagCS_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ExceptionCS <em>Exception CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exception CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ExceptionCS
	 * @generated
	 */
	EClass getExceptionCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS <em>Classifier Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier Def CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS
	 * @generated
	 */
	EClass getClassifierDefCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS#getSimpleNameCS()
	 * @see #getClassifierDefCS()
	 * @generated
	 */
	EAttribute getClassifierDefCS_SimpleNameCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extends</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS#getExtends()
	 * @see #getClassifierDefCS()
	 * @generated
	 */
	EReference getClassifierDefCS_Extends();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS#getProperties()
	 * @see #getClassifierDefCS()
	 * @generated
	 */
	EReference getClassifierDefCS_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tags</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS#getTags()
	 * @see #getClassifierDefCS()
	 * @generated
	 */
	EReference getClassifierDefCS_Tags();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS <em>Classifier Property2 CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier Property2 CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS
	 * @generated
	 */
	EClass getClassifierProperty2CS();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS#getStereotypeQualifiers <em>Stereotype Qualifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Stereotype Qualifiers</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS#getStereotypeQualifiers()
	 * @see #getClassifierProperty2CS()
	 * @generated
	 */
	EAttribute getClassifierProperty2CS_StereotypeQualifiers();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS#getFeatureKeys <em>Feature Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Feature Keys</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS#getFeatureKeys()
	 * @see #getClassifierProperty2CS()
	 * @generated
	 */
	EAttribute getClassifierProperty2CS_FeatureKeys();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Multiplicity</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS#getMultiplicity()
	 * @see #getClassifierProperty2CS()
	 * @generated
	 */
	EReference getClassifierProperty2CS_Multiplicity();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Opposite</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS#getOpposite()
	 * @see #getClassifierProperty2CS()
	 * @generated
	 */
	EReference getClassifierProperty2CS_Opposite();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS#isIsOrdered <em>Is Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Ordered</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS#isIsOrdered()
	 * @see #getClassifierProperty2CS()
	 * @generated
	 */
	EAttribute getClassifierProperty2CS_IsOrdered();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS <em>Complete Signature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Signature CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS
	 * @generated
	 */
	EClass getCompleteSignatureCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS#getSimpleSignature <em>Simple Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple Signature</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS#getSimpleSignature()
	 * @see #getCompleteSignatureCS()
	 * @generated
	 */
	EReference getCompleteSignatureCS_SimpleSignature();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS#getResultParams <em>Result Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Result Params</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS#getResultParams()
	 * @see #getCompleteSignatureCS()
	 * @generated
	 */
	EReference getCompleteSignatureCS_ResultParams();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConfigPropertyCS <em>Config Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config Property CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConfigPropertyCS
	 * @generated
	 */
	EClass getConfigPropertyCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConfigPropertyCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConfigPropertyCS#getTypeCS()
	 * @see #getConfigPropertyCS()
	 * @generated
	 */
	EReference getConfigPropertyCS_TypeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConstructorCS <em>Constructor CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constructor CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConstructorCS
	 * @generated
	 */
	EClass getConstructorCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConstructorCS#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConstructorCS#getExpressions()
	 * @see #getConstructorCS()
	 * @generated
	 */
	EReference getConstructorCS_Expressions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ContextualPropertyCS <em>Contextual Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contextual Property CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ContextualPropertyCS
	 * @generated
	 */
	EClass getContextualPropertyCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ContextualPropertyCS#getScopedNameCS <em>Scoped Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scoped Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ContextualPropertyCS#getScopedNameCS()
	 * @see #getContextualPropertyCS()
	 * @generated
	 */
	EReference getContextualPropertyCS_ScopedNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ContextualPropertyCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ContextualPropertyCS#getTypeCS()
	 * @see #getContextualPropertyCS()
	 * @generated
	 */
	EReference getContextualPropertyCS_TypeCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ContextualPropertyCS#getOclExpressionCS <em>Ocl Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ContextualPropertyCS#getOclExpressionCS()
	 * @see #getContextualPropertyCS()
	 * @generated
	 */
	EReference getContextualPropertyCS_OclExpressionCS();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindCS <em>Direction Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Direction Kind CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindCS
	 * @generated
	 */
	EEnum getDirectionKindCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody <em>Element With Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element With Body</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody
	 * @generated
	 */
	EClass getElementWithBody();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody#getBodyStartLocation <em>Body Start Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body Start Location</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody#getBodyStartLocation()
	 * @see #getElementWithBody()
	 * @generated
	 */
	EAttribute getElementWithBody_BodyStartLocation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody#getBodyEndLocation <em>Body End Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body End Location</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody#getBodyEndLocation()
	 * @see #getElementWithBody()
	 * @generated
	 */
	EAttribute getElementWithBody_BodyEndLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImperativeOperationCallExpCS <em>Imperative Operation Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Operation Call Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImperativeOperationCallExpCS
	 * @generated
	 */
	EClass getImperativeOperationCallExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImperativeOperationCallExpCS#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImperativeOperationCallExpCS#getModule()
	 * @see #getImperativeOperationCallExpCS()
	 * @generated
	 */
	EAttribute getImperativeOperationCallExpCS_Module();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LibraryImportCS <em>Library Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library Import CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LibraryImportCS
	 * @generated
	 */
	EClass getLibraryImportCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LocalPropertyCS <em>Local Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Property CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LocalPropertyCS
	 * @generated
	 */
	EClass getLocalPropertyCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LocalPropertyCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LocalPropertyCS#getTypeCS()
	 * @see #getLocalPropertyCS()
	 * @generated
	 */
	EReference getLocalPropertyCS_TypeCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LocalPropertyCS#getOclExpressionCS <em>Ocl Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LocalPropertyCS#getOclExpressionCS()
	 * @see #getLocalPropertyCS()
	 * @generated
	 */
	EReference getLocalPropertyCS_OclExpressionCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingBodyCS <em>Mapping Body CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Body CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingBodyCS
	 * @generated
	 */
	EClass getMappingBodyCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingBodyCS#isHasPopulationKeyword <em>Has Population Keyword</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Population Keyword</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingBodyCS#isHasPopulationKeyword()
	 * @see #getMappingBodyCS()
	 * @generated
	 */
	EAttribute getMappingBodyCS_HasPopulationKeyword();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingCallExpCS <em>Mapping Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Call Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingCallExpCS
	 * @generated
	 */
	EClass getMappingCallExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingCallExpCS#isStrict <em>Strict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strict</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingCallExpCS#isStrict()
	 * @see #getMappingCallExpCS()
	 * @generated
	 */
	EAttribute getMappingCallExpCS_Strict();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS <em>Mapping Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Operation CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS
	 * @generated
	 */
	EClass getMappingOperationCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS#getContextType <em>Context Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context Type</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS#getContextType()
	 * @see #getMappingOperationCS()
	 * @generated
	 */
	EReference getMappingOperationCS_ContextType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Result</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS#getResult()
	 * @see #getMappingOperationCS()
	 * @generated
	 */
	EReference getMappingOperationCS_Result();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS#getDirectionKindCS <em>Direction Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction Kind CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS#getDirectionKindCS()
	 * @see #getMappingOperationCS()
	 * @generated
	 */
	EAttribute getMappingOperationCS_DirectionKindCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS#getMappingExtension <em>Mapping Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping Extension</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS#getMappingExtension()
	 * @see #getMappingOperationCS()
	 * @generated
	 */
	EReference getMappingOperationCS_MappingExtension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS#isIsQuery <em>Is Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Query</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS#isIsQuery()
	 * @see #getMappingOperationCS()
	 * @generated
	 */
	EAttribute getMappingOperationCS_IsQuery();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingEndCS <em>Mapping End CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping End CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingEndCS
	 * @generated
	 */
	EClass getMappingEndCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionCS <em>Mapping Extension CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Extension CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionCS
	 * @generated
	 */
	EClass getMappingExtensionCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionCS#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionCS#getKind()
	 * @see #getMappingExtensionCS()
	 * @generated
	 */
	EAttribute getMappingExtensionCS_Kind();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionCS#getMappingIdentifiers <em>Mapping Identifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping Identifiers</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionCS#getMappingIdentifiers()
	 * @see #getMappingExtensionCS()
	 * @generated
	 */
	EReference getMappingExtensionCS_MappingIdentifiers();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingInitCS <em>Mapping Init CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Init CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingInitCS
	 * @generated
	 */
	EClass getMappingInitCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingMethodCS <em>Mapping Method CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Method CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingMethodCS
	 * @generated
	 */
	EClass getMappingMethodCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingMethodCS#isBlackBox <em>Black Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Black Box</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingMethodCS#isBlackBox()
	 * @see #getMappingMethodCS()
	 * @generated
	 */
	EAttribute getMappingMethodCS_BlackBox();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingMethodCS#getMappingDeclarationCS <em>Mapping Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Declaration CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingMethodCS#getMappingDeclarationCS()
	 * @see #getMappingMethodCS()
	 * @generated
	 */
	EReference getMappingMethodCS_MappingDeclarationCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS <em>Mapping Module CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Module CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS
	 * @generated
	 */
	EClass getMappingModuleCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS#getHeaderCS <em>Header CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Header CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS#getHeaderCS()
	 * @see #getMappingModuleCS()
	 * @generated
	 */
	EReference getMappingModuleCS_HeaderCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS#getImports()
	 * @see #getMappingModuleCS()
	 * @generated
	 */
	EReference getMappingModuleCS_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS#getMetamodels <em>Metamodels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metamodels</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS#getMetamodels()
	 * @see #getMappingModuleCS()
	 * @generated
	 */
	EReference getMappingModuleCS_Metamodels();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS#getRenamings <em>Renamings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Renamings</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS#getRenamings()
	 * @see #getMappingModuleCS()
	 * @generated
	 */
	EReference getMappingModuleCS_Renamings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS#getProperties()
	 * @see #getMappingModuleCS()
	 * @generated
	 */
	EReference getMappingModuleCS_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methods</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS#getMethods()
	 * @see #getMappingModuleCS()
	 * @generated
	 */
	EReference getMappingModuleCS_Methods();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS#getClassifierDefCS <em>Classifier Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classifier Def CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS#getClassifierDefCS()
	 * @see #getMappingModuleCS()
	 * @generated
	 */
	EReference getMappingModuleCS_ClassifierDefCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tags</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS#getTags()
	 * @see #getMappingModuleCS()
	 * @generated
	 */
	EReference getMappingModuleCS_Tags();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingQueryCS <em>Mapping Query CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Query CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingQueryCS
	 * @generated
	 */
	EClass getMappingQueryCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingQueryCS#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingQueryCS#getExpressions()
	 * @see #getMappingQueryCS()
	 * @generated
	 */
	EReference getMappingQueryCS_Expressions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingQueryCS#isIsSimpleDefinition <em>Is Simple Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Simple Definition</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingQueryCS#isIsSimpleDefinition()
	 * @see #getMappingQueryCS()
	 * @generated
	 */
	EAttribute getMappingQueryCS_IsSimpleDefinition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingRuleCS <em>Mapping Rule CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Rule CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingRuleCS
	 * @generated
	 */
	EClass getMappingRuleCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingRuleCS#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingRuleCS#getGuard()
	 * @see #getMappingRuleCS()
	 * @generated
	 */
	EReference getMappingRuleCS_Guard();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingRuleCS#getMappingBody <em>Mapping Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Body</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingRuleCS#getMappingBody()
	 * @see #getMappingRuleCS()
	 * @generated
	 */
	EReference getMappingRuleCS_MappingBody();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionCS <em>Mapping Section CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Section CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionCS
	 * @generated
	 */
	EClass getMappingSectionCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionCS#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionCS#getStatements()
	 * @see #getMappingSectionCS()
	 * @generated
	 */
	EReference getMappingSectionCS_Statements();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionCS#getMappingRuleCS <em>Mapping Rule CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Rule CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionCS#getMappingRuleCS()
	 * @see #getMappingSectionCS()
	 * @generated
	 */
	EReference getMappingSectionCS_MappingRuleCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionsCS <em>Mapping Sections CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Sections CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionsCS
	 * @generated
	 */
	EClass getMappingSectionsCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionsCS#getMappingInitCS <em>Mapping Init CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Init CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionsCS#getMappingInitCS()
	 * @see #getMappingSectionsCS()
	 * @generated
	 */
	EReference getMappingSectionsCS_MappingInitCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionsCS#getMappingBodyCS <em>Mapping Body CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Body CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionsCS#getMappingBodyCS()
	 * @see #getMappingSectionsCS()
	 * @generated
	 */
	EReference getMappingSectionsCS_MappingBodyCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionsCS#getMappingEndCS <em>Mapping End CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping End CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionsCS#getMappingEndCS()
	 * @see #getMappingSectionsCS()
	 * @generated
	 */
	EReference getMappingSectionsCS_MappingEndCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindCS <em>Module Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Kind CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindCS
	 * @generated
	 */
	EClass getModuleKindCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindCS#getModuleKind <em>Module Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module Kind</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindCS#getModuleKind()
	 * @see #getModuleKindCS()
	 * @generated
	 */
	EAttribute getModuleKindCS_ModuleKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleRefCS <em>Module Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Ref CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleRefCS
	 * @generated
	 */
	EClass getModuleRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleRefCS#getPathNameCS <em>Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleRefCS#getPathNameCS()
	 * @see #getModuleRefCS()
	 * @generated
	 */
	EReference getModuleRefCS_PathNameCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleRefCS#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleRefCS#getParameters()
	 * @see #getModuleRefCS()
	 * @generated
	 */
	EReference getModuleRefCS_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS <em>Model Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS
	 * @generated
	 */
	EClass getModelTypeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS#getIdentifierCS <em>Identifier CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS#getIdentifierCS()
	 * @see #getModelTypeCS()
	 * @generated
	 */
	EAttribute getModelTypeCS_IdentifierCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS#getComplianceKindCS <em>Compliance Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compliance Kind CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS#getComplianceKindCS()
	 * @see #getModelTypeCS()
	 * @generated
	 */
	EReference getModelTypeCS_ComplianceKindCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS#getPackageRefs <em>Package Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Package Refs</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS#getPackageRefs()
	 * @see #getModelTypeCS()
	 * @generated
	 */
	EReference getModelTypeCS_PackageRefs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS#getWhereStatements <em>Where Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Where Statements</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS#getWhereStatements()
	 * @see #getModelTypeCS()
	 * @generated
	 */
	EReference getModelTypeCS_WhereStatements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModulePropertyCS <em>Module Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Property CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModulePropertyCS
	 * @generated
	 */
	EClass getModulePropertyCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModulePropertyCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModulePropertyCS#getSimpleNameCS()
	 * @see #getModulePropertyCS()
	 * @generated
	 */
	EAttribute getModulePropertyCS_SimpleNameCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS <em>Module Usage CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Usage CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS
	 * @generated
	 */
	EClass getModuleUsageCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS#getImportKind <em>Import Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import Kind</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS#getImportKind()
	 * @see #getModuleUsageCS()
	 * @generated
	 */
	EAttribute getModuleUsageCS_ImportKind();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS#getModuleKindCS <em>Module Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Module Kind CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS#getModuleKindCS()
	 * @see #getModuleUsageCS()
	 * @generated
	 */
	EReference getModuleUsageCS_ModuleKindCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS#getModuleRefs <em>Module Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Module Refs</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS#getModuleRefs()
	 * @see #getModuleUsageCS()
	 * @generated
	 */
	EReference getModuleUsageCS_ModuleRefs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityDefCS <em>Multiplicity Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity Def CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityDefCS
	 * @generated
	 */
	EClass getMultiplicityDefCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityDefCS#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lower Bound</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityDefCS#getLowerBound()
	 * @see #getMultiplicityDefCS()
	 * @generated
	 */
	EReference getMultiplicityDefCS_LowerBound();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityDefCS#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Upper Bound</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityDefCS#getUpperBound()
	 * @see #getMultiplicityDefCS()
	 * @generated
	 */
	EReference getMultiplicityDefCS_UpperBound();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ObjectExpCS <em>Object Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ObjectExpCS
	 * @generated
	 */
	EClass getObjectExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ObjectExpCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ObjectExpCS#getSimpleNameCS()
	 * @see #getObjectExpCS()
	 * @generated
	 */
	EAttribute getObjectExpCS_SimpleNameCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ObjectExpCS#isIsImplicit <em>Is Implicit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Implicit</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ObjectExpCS#isIsImplicit()
	 * @see #getObjectExpCS()
	 * @generated
	 */
	EAttribute getObjectExpCS_IsImplicit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OppositePropertyCS <em>Opposite Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opposite Property CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OppositePropertyCS
	 * @generated
	 */
	EClass getOppositePropertyCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OppositePropertyCS#isIsNavigable <em>Is Navigable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Navigable</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OppositePropertyCS#isIsNavigable()
	 * @see #getOppositePropertyCS()
	 * @generated
	 */
	EAttribute getOppositePropertyCS_IsNavigable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OppositePropertyCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OppositePropertyCS#getSimpleNameCS()
	 * @see #getOppositePropertyCS()
	 * @generated
	 */
	EAttribute getOppositePropertyCS_SimpleNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OppositePropertyCS#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Multiplicity</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OppositePropertyCS#getMultiplicity()
	 * @see #getOppositePropertyCS()
	 * @generated
	 */
	EReference getOppositePropertyCS_Multiplicity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS <em>Parameter Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Declaration CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS
	 * @generated
	 */
	EClass getParameterDeclarationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS#getDirection()
	 * @see #getParameterDeclarationCS()
	 * @generated
	 */
	EAttribute getParameterDeclarationCS_Direction();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS#getInitPart <em>Init Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Part</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS#getInitPart()
	 * @see #getParameterDeclarationCS()
	 * @generated
	 */
	EReference getParameterDeclarationCS_InitPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.RenameCS <em>Rename CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rename CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.RenameCS
	 * @generated
	 */
	EClass getRenameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.RenameCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.RenameCS#getTypeCS()
	 * @see #getRenameCS()
	 * @generated
	 */
	EReference getRenameCS_TypeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.RenameCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.RenameCS#getSimpleNameCS()
	 * @see #getRenameCS()
	 * @generated
	 */
	EAttribute getRenameCS_SimpleNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.RenameCS#getOriginalName <em>Original Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Original Name</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.RenameCS#getOriginalName()
	 * @see #getRenameCS()
	 * @generated
	 */
	EReference getRenameCS_OriginalName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveOpArgsExpCS <em>Resolve Op Args Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolve Op Args Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveOpArgsExpCS
	 * @generated
	 */
	EClass getResolveOpArgsExpCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveOpArgsExpCS#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveOpArgsExpCS#getTarget()
	 * @see #getResolveOpArgsExpCS()
	 * @generated
	 */
	EReference getResolveOpArgsExpCS_Target();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveOpArgsExpCS#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveOpArgsExpCS#getCondition()
	 * @see #getResolveOpArgsExpCS()
	 * @generated
	 */
	EReference getResolveOpArgsExpCS_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PackageRefCS <em>Package Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Ref CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PackageRefCS
	 * @generated
	 */
	EClass getPackageRefCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PackageRefCS#getPathNameCS <em>Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PackageRefCS#getPathNameCS()
	 * @see #getPackageRefCS()
	 * @generated
	 */
	EReference getPackageRefCS_PathNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PackageRefCS#getUriCS <em>Uri CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Uri CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PackageRefCS#getUriCS()
	 * @see #getPackageRefCS()
	 * @generated
	 */
	EReference getPackageRefCS_UriCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ScopedNameCS <em>Scoped Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scoped Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ScopedNameCS
	 * @generated
	 */
	EClass getScopedNameCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ScopedNameCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ScopedNameCS#getTypeCS()
	 * @see #getScopedNameCS()
	 * @generated
	 */
	EReference getScopedNameCS_TypeCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ScopedNameCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ScopedNameCS#getName()
	 * @see #getScopedNameCS()
	 * @generated
	 */
	EAttribute getScopedNameCS_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS <em>Simple Signature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Signature CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS
	 * @generated
	 */
	EClass getSimpleSignatureCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS#getParameter()
	 * @see #getSimpleSignatureCS()
	 * @generated
	 */
	EReference getSimpleSignatureCS_Parameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS <em>Transformation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS
	 * @generated
	 */
	EClass getTransformationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS#getQualifiers <em>Qualifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Qualifiers</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS#getQualifiers()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Qualifiers();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS#getPathNameCS <em>Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS#getPathNameCS()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_PathNameCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS#getParameters()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS#getModuleUsages <em>Module Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Module Usages</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS#getModuleUsages()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_ModuleUsages();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS#getTransformationRefineCS <em>Transformation Refine CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Transformation Refine CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS#getTransformationRefineCS()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_TransformationRefineCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationRefineCS <em>Transformation Refine CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation Refine CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationRefineCS
	 * @generated
	 */
	EClass getTransformationRefineCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationRefineCS#getModuleRefCS <em>Module Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Module Ref CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationRefineCS#getModuleRefCS()
	 * @see #getTransformationRefineCS()
	 * @generated
	 */
	EReference getTransformationRefineCS_ModuleRefCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationRefineCS#getSimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationRefineCS#getSimpleNameCS()
	 * @see #getTransformationRefineCS()
	 * @generated
	 */
	EAttribute getTransformationRefineCS_SimpleNameCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS <em>Type Spec CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Spec CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS
	 * @generated
	 */
	EClass getTypeSpecCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS#getOwnedType()
	 * @see #getTypeSpecCS()
	 * @generated
	 */
	EReference getTypeSpecCS_OwnedType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS#getExtentLocation <em>Extent Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extent Location</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS#getExtentLocation()
	 * @see #getTypeSpecCS()
	 * @generated
	 */
	EAttribute getTypeSpecCS_ExtentLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS <em>Unit CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS
	 * @generated
	 */
	EClass getUnitCS();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS#getSegment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Segment</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS#getSegment()
	 * @see #getUnitCS()
	 * @generated
	 */
	EAttribute getUnitCS_Segment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS#getTopLevelElements <em>Top Level Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Top Level Elements</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS#getTopLevelElements()
	 * @see #getUnitCS()
	 * @generated
	 */
	EReference getUnitCS_TopLevelElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS#getModules <em>Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Modules</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS#getModules()
	 * @see #getUnitCS()
	 * @generated
	 */
	EReference getUnitCS_Modules();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS#getModelTypes <em>Model Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Model Types</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS#getModelTypes()
	 * @see #getUnitCS()
	 * @generated
	 */
	EReference getUnitCS_ModelTypes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imports</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS#getImports()
	 * @see #getUnitCS()
	 * @generated
	 */
	EReference getUnitCS_Imports();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS <em>Resolve Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolve Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS
	 * @generated
	 */
	EClass getResolveExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS#isOne <em>One</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>One</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS#isOne()
	 * @see #getResolveExpCS()
	 * @generated
	 */
	EAttribute getResolveExpCS_One();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS#isIsInverse <em>Is Inverse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Inverse</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS#isIsInverse()
	 * @see #getResolveExpCS()
	 * @generated
	 */
	EAttribute getResolveExpCS_IsInverse();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS#isIsDeferred <em>Is Deferred</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Deferred</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS#isIsDeferred()
	 * @see #getResolveExpCS()
	 * @generated
	 */
	EAttribute getResolveExpCS_IsDeferred();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS#getTarget()
	 * @see #getResolveExpCS()
	 * @generated
	 */
	EReference getResolveExpCS_Target();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS#getCondition()
	 * @see #getResolveExpCS()
	 * @generated
	 */
	EReference getResolveExpCS_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS <em>Resolve In Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolve In Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS
	 * @generated
	 */
	EClass getResolveInExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS#getInMappingType <em>In Mapping Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In Mapping Type</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS#getInMappingType()
	 * @see #getResolveInExpCS()
	 * @generated
	 */
	EReference getResolveInExpCS_InMappingType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS#getInMappingName <em>In Mapping Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>In Mapping Name</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS#getInMappingName()
	 * @see #getResolveInExpCS()
	 * @generated
	 */
	EAttribute getResolveInExpCS_InMappingName();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierKind <em>Classifier Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Classifier Kind</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierKind
	 * @generated
	 */
	EEnum getClassifierKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.FeatureKey <em>Feature Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Feature Key</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.FeatureKey
	 * @generated
	 */
	EEnum getFeatureKey();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitOp <em>Init Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Init Op</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitOp
	 * @generated
	 */
	EEnum getInitOp();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind <em>Metamodel Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Metamodel Kind</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind
	 * @generated
	 */
	EEnum getMetamodelKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportKindEnum <em>Import Kind Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Import Kind Enum</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportKindEnum
	 * @generated
	 */
	EEnum getImportKindEnum();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionKindCS <em>Mapping Extension Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Mapping Extension Kind CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionKindCS
	 * @generated
	 */
	EEnum getMappingExtensionKindCS();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindEnum <em>Module Kind Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Module Kind Enum</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindEnum
	 * @generated
	 */
	EEnum getModuleKindEnum();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QualifierKindCS <em>Qualifier Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Qualifier Kind CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QualifierKindCS
	 * @generated
	 */
	EEnum getQualifierKindCS();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTOperationalCSFactory getQVTOperationalCSFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TopLevelCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTopLevelCS()
		 * @generated
		 */
		EClass TOP_LEVEL_CS = eINSTANCE.getTopLevelCS();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__IMPORT = eINSTANCE.getTopLevelCS_Import();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__UNIT = eINSTANCE.getTopLevelCS_Unit();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__OWNED_TYPE = eINSTANCE.getTopLevelCS_OwnedType();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToClassCSImpl <em>QV To Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToClassCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQVToClassCS()
		 * @generated
		 */
		EClass QV_TO_CLASS_CS = eINSTANCE.getQVToClassCS();

		/**
		 * The meta object literal for the '<em><b>Intermediate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QV_TO_CLASS_CS__INTERMEDIATE = eINSTANCE.getQVToClassCS_Intermediate();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToImportCSImpl <em>QV To Import CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToImportCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQVToImportCS()
		 * @generated
		 */
		EClass QV_TO_IMPORT_CS = eINSTANCE.getQVToImportCS();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QV_TO_IMPORT_CS__UNIT = eINSTANCE.getQVToImportCS_Unit();

		/**
		 * The meta object literal for the '<em><b>Imported Unit Element</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QV_TO_IMPORT_CS__IMPORTED_UNIT_ELEMENT = eINSTANCE.getQVToImportCS_ImportedUnitElement();

		/**
		 * The meta object literal for the '<em><b>All</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QV_TO_IMPORT_CS__ALL = eINSTANCE.getQVToImportCS_All();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToLibraryCSImpl <em>QV To Library CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToLibraryCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQVToLibraryCS()
		 * @generated
		 */
		EClass QV_TO_LIBRARY_CS = eINSTANCE.getQVToLibraryCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToOperationCSImpl <em>QV To Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToOperationCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQVToOperationCS()
		 * @generated
		 */
		EClass QV_TO_OPERATION_CS = eINSTANCE.getQVToOperationCS();

		/**
		 * The meta object literal for the '<em><b>Stereotypes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QV_TO_OPERATION_CS__STEREOTYPES = eINSTANCE.getQVToOperationCS_Stereotypes();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.OperationParameterDeclarationCSImpl <em>Operation Parameter Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.OperationParameterDeclarationCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getOperationParameterDeclarationCS()
		 * @generated
		 */
		EClass OPERATION_PARAMETER_DECLARATION_CS = eINSTANCE.getOperationParameterDeclarationCS();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_PARAMETER_DECLARATION_CS__DIRECTION = eINSTANCE.getOperationParameterDeclarationCS_Direction();

		/**
		 * The meta object literal for the '<em><b>Init Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_PARAMETER_DECLARATION_CS__INIT_PART = eINSTANCE.getOperationParameterDeclarationCS_InitPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.OperationSimpleSignatureCSImpl <em>Operation Simple Signature CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.OperationSimpleSignatureCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getOperationSimpleSignatureCS()
		 * @generated
		 */
		EClass OPERATION_SIMPLE_SIGNATURE_CS = eINSTANCE.getOperationSimpleSignatureCS();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_SIMPLE_SIGNATURE_CS__PARAMETER = eINSTANCE.getOperationSimpleSignatureCS_Parameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.InitPartCSImpl <em>Init Part CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.InitPartCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getInitPartCS()
		 * @generated
		 */
		EClass INIT_PART_CS = eINSTANCE.getInitPartCS();

		/**
		 * The meta object literal for the '<em><b>Init Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INIT_PART_CS__INIT_OP = eINSTANCE.getInitPartCS_InitOp();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INIT_PART_CS__EXPRESSION = eINSTANCE.getInitPartCS_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MetamodelCSImpl <em>Metamodel CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MetamodelCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMetamodelCS()
		 * @generated
		 */
		EClass METAMODEL_CS = eINSTANCE.getMetamodelCS();

		/**
		 * The meta object literal for the '<em><b>Metamodel Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METAMODEL_CS__METAMODEL_KIND = eINSTANCE.getMetamodelCS_MetamodelKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.PrimitiveTypeCSImpl <em>Primitive Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.PrimitiveTypeCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getPrimitiveTypeCS()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE_CS = eINSTANCE.getPrimitiveTypeCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierPropertyCSImpl <em>Classifier Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierPropertyCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getClassifierPropertyCS()
		 * @generated
		 */
		EClass CLASSIFIER_PROPERTY_CS = eINSTANCE.getClassifierPropertyCS();

		/**
		 * The meta object literal for the '<em><b>Stereotypes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_PROPERTY_CS__STEREOTYPES = eINSTANCE.getClassifierPropertyCS_Stereotypes();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_PROPERTY_CS__OPPOSITE = eINSTANCE.getClassifierPropertyCS_Opposite();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.StereotypeQualifierCSImpl <em>Stereotype Qualifier CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.StereotypeQualifierCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getStereotypeQualifierCS()
		 * @generated
		 */
		EClass STEREOTYPE_QUALIFIER_CS = eINSTANCE.getStereotypeQualifierCS();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE_QUALIFIER_CS__STEREOTYPE = eINSTANCE.getStereotypeQualifierCS_Stereotype();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TagCSImpl <em>Tag CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TagCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTagCS()
		 * @generated
		 */
		EClass TAG_CS = eINSTANCE.getTagCS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG_CS__PATH_NAME = eINSTANCE.getTagCS_PathName();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG_CS__EXPRESSION = eINSTANCE.getTagCS_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ExceptionCSImpl <em>Exception CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ExceptionCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getExceptionCS()
		 * @generated
		 */
		EClass EXCEPTION_CS = eINSTANCE.getExceptionCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierDefCSImpl <em>Classifier Def CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierDefCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getClassifierDefCS()
		 * @generated
		 */
		EClass CLASSIFIER_DEF_CS = eINSTANCE.getClassifierDefCS();

		/**
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_DEF_CS__SIMPLE_NAME_CS = eINSTANCE.getClassifierDefCS_SimpleNameCS();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_DEF_CS__EXTENDS = eINSTANCE.getClassifierDefCS_Extends();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_DEF_CS__PROPERTIES = eINSTANCE.getClassifierDefCS_Properties();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_DEF_CS__TAGS = eINSTANCE.getClassifierDefCS_Tags();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierProperty2CSImpl <em>Classifier Property2 CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierProperty2CSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getClassifierProperty2CS()
		 * @generated
		 */
		EClass CLASSIFIER_PROPERTY2_CS = eINSTANCE.getClassifierProperty2CS();

		/**
		 * The meta object literal for the '<em><b>Stereotype Qualifiers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_PROPERTY2_CS__STEREOTYPE_QUALIFIERS = eINSTANCE.getClassifierProperty2CS_StereotypeQualifiers();

		/**
		 * The meta object literal for the '<em><b>Feature Keys</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_PROPERTY2_CS__FEATURE_KEYS = eINSTANCE.getClassifierProperty2CS_FeatureKeys();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_PROPERTY2_CS__MULTIPLICITY = eINSTANCE.getClassifierProperty2CS_Multiplicity();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER_PROPERTY2_CS__OPPOSITE = eINSTANCE.getClassifierProperty2CS_Opposite();

		/**
		 * The meta object literal for the '<em><b>Is Ordered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSIFIER_PROPERTY2_CS__IS_ORDERED = eINSTANCE.getClassifierProperty2CS_IsOrdered();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.CompleteSignatureCSImpl <em>Complete Signature CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.CompleteSignatureCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getCompleteSignatureCS()
		 * @generated
		 */
		EClass COMPLETE_SIGNATURE_CS = eINSTANCE.getCompleteSignatureCS();

		/**
		 * The meta object literal for the '<em><b>Simple Signature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE = eINSTANCE.getCompleteSignatureCS_SimpleSignature();

		/**
		 * The meta object literal for the '<em><b>Result Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_SIGNATURE_CS__RESULT_PARAMS = eINSTANCE.getCompleteSignatureCS_ResultParams();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ConfigPropertyCSImpl <em>Config Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ConfigPropertyCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getConfigPropertyCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ConstructorCSImpl <em>Constructor CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ConstructorCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getConstructorCS()
		 * @generated
		 */
		EClass CONSTRUCTOR_CS = eINSTANCE.getConstructorCS();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRUCTOR_CS__EXPRESSIONS = eINSTANCE.getConstructorCS_Expressions();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ContextualPropertyCSImpl <em>Contextual Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ContextualPropertyCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getContextualPropertyCS()
		 * @generated
		 */
		EClass CONTEXTUAL_PROPERTY_CS = eINSTANCE.getContextualPropertyCS();

		/**
		 * The meta object literal for the '<em><b>Scoped Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXTUAL_PROPERTY_CS__SCOPED_NAME_CS = eINSTANCE.getContextualPropertyCS_ScopedNameCS();

		/**
		 * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXTUAL_PROPERTY_CS__TYPE_CS = eINSTANCE.getContextualPropertyCS_TypeCS();

		/**
		 * The meta object literal for the '<em><b>Ocl Expression CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXTUAL_PROPERTY_CS__OCL_EXPRESSION_CS = eINSTANCE.getContextualPropertyCS_OclExpressionCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindCS <em>Direction Kind CS</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindCS
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getDirectionKindCS()
		 * @generated
		 */
		EEnum DIRECTION_KIND_CS = eINSTANCE.getDirectionKindCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ElementWithBodyImpl <em>Element With Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ElementWithBodyImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getElementWithBody()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ImperativeOperationCallExpCSImpl <em>Imperative Operation Call Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ImperativeOperationCallExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getImperativeOperationCallExpCS()
		 * @generated
		 */
		EClass IMPERATIVE_OPERATION_CALL_EXP_CS = eINSTANCE.getImperativeOperationCallExpCS();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPERATIVE_OPERATION_CALL_EXP_CS__MODULE = eINSTANCE.getImperativeOperationCallExpCS_Module();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.LibraryImportCSImpl <em>Library Import CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.LibraryImportCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getLibraryImportCS()
		 * @generated
		 */
		EClass LIBRARY_IMPORT_CS = eINSTANCE.getLibraryImportCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.LocalPropertyCSImpl <em>Local Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.LocalPropertyCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getLocalPropertyCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingBodyCSImpl <em>Mapping Body CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingBodyCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingBodyCS()
		 * @generated
		 */
		EClass MAPPING_BODY_CS = eINSTANCE.getMappingBodyCS();

		/**
		 * The meta object literal for the '<em><b>Has Population Keyword</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_BODY_CS__HAS_POPULATION_KEYWORD = eINSTANCE.getMappingBodyCS_HasPopulationKeyword();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingCallExpCSImpl <em>Mapping Call Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingCallExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingCallExpCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingOperationCSImpl <em>Mapping Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingOperationCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingOperationCS()
		 * @generated
		 */
		EClass MAPPING_OPERATION_CS = eINSTANCE.getMappingOperationCS();

		/**
		 * The meta object literal for the '<em><b>Context Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_OPERATION_CS__CONTEXT_TYPE = eINSTANCE.getMappingOperationCS_ContextType();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_OPERATION_CS__RESULT = eINSTANCE.getMappingOperationCS_Result();

		/**
		 * The meta object literal for the '<em><b>Direction Kind CS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_OPERATION_CS__DIRECTION_KIND_CS = eINSTANCE.getMappingOperationCS_DirectionKindCS();

		/**
		 * The meta object literal for the '<em><b>Mapping Extension</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_OPERATION_CS__MAPPING_EXTENSION = eINSTANCE.getMappingOperationCS_MappingExtension();

		/**
		 * The meta object literal for the '<em><b>Is Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_OPERATION_CS__IS_QUERY = eINSTANCE.getMappingOperationCS_IsQuery();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingEndCSImpl <em>Mapping End CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingEndCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingEndCS()
		 * @generated
		 */
		EClass MAPPING_END_CS = eINSTANCE.getMappingEndCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingExtensionCSImpl <em>Mapping Extension CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingExtensionCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingExtensionCS()
		 * @generated
		 */
		EClass MAPPING_EXTENSION_CS = eINSTANCE.getMappingExtensionCS();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_EXTENSION_CS__KIND = eINSTANCE.getMappingExtensionCS_Kind();

		/**
		 * The meta object literal for the '<em><b>Mapping Identifiers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_EXTENSION_CS__MAPPING_IDENTIFIERS = eINSTANCE.getMappingExtensionCS_MappingIdentifiers();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingInitCSImpl <em>Mapping Init CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingInitCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingInitCS()
		 * @generated
		 */
		EClass MAPPING_INIT_CS = eINSTANCE.getMappingInitCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingMethodCSImpl <em>Mapping Method CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingMethodCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingMethodCS()
		 * @generated
		 */
		EClass MAPPING_METHOD_CS = eINSTANCE.getMappingMethodCS();

		/**
		 * The meta object literal for the '<em><b>Black Box</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_METHOD_CS__BLACK_BOX = eINSTANCE.getMappingMethodCS_BlackBox();

		/**
		 * The meta object literal for the '<em><b>Mapping Declaration CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_METHOD_CS__MAPPING_DECLARATION_CS = eINSTANCE.getMappingMethodCS_MappingDeclarationCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingModuleCSImpl <em>Mapping Module CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingModuleCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingModuleCS()
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
		 * The meta object literal for the '<em><b>Classifier Def CS</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODULE_CS__CLASSIFIER_DEF_CS = eINSTANCE.getMappingModuleCS_ClassifierDefCS();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODULE_CS__TAGS = eINSTANCE.getMappingModuleCS_Tags();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingQueryCSImpl <em>Mapping Query CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingQueryCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingQueryCS()
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
		 * The meta object literal for the '<em><b>Is Simple Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_QUERY_CS__IS_SIMPLE_DEFINITION = eINSTANCE.getMappingQueryCS_IsSimpleDefinition();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingRuleCSImpl <em>Mapping Rule CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingRuleCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingRuleCS()
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
		 * The meta object literal for the '<em><b>Mapping Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_RULE_CS__MAPPING_BODY = eINSTANCE.getMappingRuleCS_MappingBody();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingSectionCSImpl <em>Mapping Section CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingSectionCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingSectionCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingSectionsCSImpl <em>Mapping Sections CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingSectionsCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingSectionsCS()
		 * @generated
		 */
		EClass MAPPING_SECTIONS_CS = eINSTANCE.getMappingSectionsCS();

		/**
		 * The meta object literal for the '<em><b>Mapping Init CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_SECTIONS_CS__MAPPING_INIT_CS = eINSTANCE.getMappingSectionsCS_MappingInitCS();

		/**
		 * The meta object literal for the '<em><b>Mapping Body CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_SECTIONS_CS__MAPPING_BODY_CS = eINSTANCE.getMappingSectionsCS_MappingBodyCS();

		/**
		 * The meta object literal for the '<em><b>Mapping End CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_SECTIONS_CS__MAPPING_END_CS = eINSTANCE.getMappingSectionsCS_MappingEndCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModuleKindCSImpl <em>Module Kind CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModuleKindCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModuleKindCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModuleRefCSImpl <em>Module Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModuleRefCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModuleRefCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModelTypeCSImpl <em>Model Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModelTypeCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModelTypeCS()
		 * @generated
		 */
		EClass MODEL_TYPE_CS = eINSTANCE.getModelTypeCS();

		/**
		 * The meta object literal for the '<em><b>Identifier CS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_TYPE_CS__IDENTIFIER_CS = eINSTANCE.getModelTypeCS_IdentifierCS();

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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModulePropertyCSImpl <em>Module Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModulePropertyCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModulePropertyCS()
		 * @generated
		 */
		EClass MODULE_PROPERTY_CS = eINSTANCE.getModulePropertyCS();

		/**
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE_PROPERTY_CS__SIMPLE_NAME_CS = eINSTANCE.getModulePropertyCS_SimpleNameCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModuleUsageCSImpl <em>Module Usage CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModuleUsageCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModuleUsageCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MultiplicityDefCSImpl <em>Multiplicity Def CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MultiplicityDefCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMultiplicityDefCS()
		 * @generated
		 */
		EClass MULTIPLICITY_DEF_CS = eINSTANCE.getMultiplicityDefCS();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLICITY_DEF_CS__LOWER_BOUND = eINSTANCE.getMultiplicityDefCS_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLICITY_DEF_CS__UPPER_BOUND = eINSTANCE.getMultiplicityDefCS_UpperBound();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ObjectExpCSImpl <em>Object Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ObjectExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getObjectExpCS()
		 * @generated
		 */
		EClass OBJECT_EXP_CS = eINSTANCE.getObjectExpCS();

		/**
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_EXP_CS__SIMPLE_NAME_CS = eINSTANCE.getObjectExpCS_SimpleNameCS();

		/**
		 * The meta object literal for the '<em><b>Is Implicit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_EXP_CS__IS_IMPLICIT = eINSTANCE.getObjectExpCS_IsImplicit();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.OppositePropertyCSImpl <em>Opposite Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.OppositePropertyCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getOppositePropertyCS()
		 * @generated
		 */
		EClass OPPOSITE_PROPERTY_CS = eINSTANCE.getOppositePropertyCS();

		/**
		 * The meta object literal for the '<em><b>Is Navigable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPPOSITE_PROPERTY_CS__IS_NAVIGABLE = eINSTANCE.getOppositePropertyCS_IsNavigable();

		/**
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPPOSITE_PROPERTY_CS__SIMPLE_NAME_CS = eINSTANCE.getOppositePropertyCS_SimpleNameCS();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPPOSITE_PROPERTY_CS__MULTIPLICITY = eINSTANCE.getOppositePropertyCS_Multiplicity();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ParameterDeclarationCSImpl <em>Parameter Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ParameterDeclarationCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getParameterDeclarationCS()
		 * @generated
		 */
		EClass PARAMETER_DECLARATION_CS = eINSTANCE.getParameterDeclarationCS();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_DECLARATION_CS__DIRECTION = eINSTANCE.getParameterDeclarationCS_Direction();

		/**
		 * The meta object literal for the '<em><b>Init Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_DECLARATION_CS__INIT_PART = eINSTANCE.getParameterDeclarationCS_InitPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.RenameCSImpl <em>Rename CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.RenameCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getRenameCS()
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
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RENAME_CS__SIMPLE_NAME_CS = eINSTANCE.getRenameCS_SimpleNameCS();

		/**
		 * The meta object literal for the '<em><b>Original Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENAME_CS__ORIGINAL_NAME = eINSTANCE.getRenameCS_OriginalName();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ResolveOpArgsExpCSImpl <em>Resolve Op Args Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ResolveOpArgsExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getResolveOpArgsExpCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.PackageRefCSImpl <em>Package Ref CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.PackageRefCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getPackageRefCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ScopedNameCSImpl <em>Scoped Name CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ScopedNameCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getScopedNameCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.SimpleSignatureCSImpl <em>Simple Signature CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.SimpleSignatureCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getSimpleSignatureCS()
		 * @generated
		 */
		EClass SIMPLE_SIGNATURE_CS = eINSTANCE.getSimpleSignatureCS();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_SIGNATURE_CS__PARAMETER = eINSTANCE.getSimpleSignatureCS_Parameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTransformationCS()
		 * @generated
		 */
		EClass TRANSFORMATION_CS = eINSTANCE.getTransformationCS();

		/**
		 * The meta object literal for the '<em><b>Qualifiers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__QUALIFIERS = eINSTANCE.getTransformationCS_Qualifiers();

		/**
		 * The meta object literal for the '<em><b>Path Name CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__PATH_NAME_CS = eINSTANCE.getTransformationCS_PathNameCS();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__PARAMETERS = eINSTANCE.getTransformationCS_Parameters();

		/**
		 * The meta object literal for the '<em><b>Module Usages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__MODULE_USAGES = eINSTANCE.getTransformationCS_ModuleUsages();

		/**
		 * The meta object literal for the '<em><b>Transformation Refine CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__TRANSFORMATION_REFINE_CS = eINSTANCE.getTransformationCS_TransformationRefineCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationRefineCSImpl <em>Transformation Refine CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationRefineCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTransformationRefineCS()
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
		 * The meta object literal for the '<em><b>Simple Name CS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS = eINSTANCE.getTransformationRefineCS_SimpleNameCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TypeSpecCSImpl <em>Type Spec CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TypeSpecCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getTypeSpecCS()
		 * @generated
		 */
		EClass TYPE_SPEC_CS = eINSTANCE.getTypeSpecCS();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_SPEC_CS__OWNED_TYPE = eINSTANCE.getTypeSpecCS_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Extent Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_SPEC_CS__EXTENT_LOCATION = eINSTANCE.getTypeSpecCS_ExtentLocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.UnitCSImpl <em>Unit CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.UnitCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getUnitCS()
		 * @generated
		 */
		EClass UNIT_CS = eINSTANCE.getUnitCS();

		/**
		 * The meta object literal for the '<em><b>Segment</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_CS__SEGMENT = eINSTANCE.getUnitCS_Segment();

		/**
		 * The meta object literal for the '<em><b>Top Level Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_CS__TOP_LEVEL_ELEMENTS = eINSTANCE.getUnitCS_TopLevelElements();

		/**
		 * The meta object literal for the '<em><b>Modules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_CS__MODULES = eINSTANCE.getUnitCS_Modules();

		/**
		 * The meta object literal for the '<em><b>Model Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_CS__MODEL_TYPES = eINSTANCE.getUnitCS_ModelTypes();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_CS__IMPORTS = eINSTANCE.getUnitCS_Imports();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ResolveExpCSImpl <em>Resolve Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ResolveExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getResolveExpCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ResolveInExpCSImpl <em>Resolve In Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ResolveInExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getResolveInExpCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierKind <em>Classifier Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierKind
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getClassifierKind()
		 * @generated
		 */
		EEnum CLASSIFIER_KIND = eINSTANCE.getClassifierKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.FeatureKey <em>Feature Key</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.FeatureKey
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getFeatureKey()
		 * @generated
		 */
		EEnum FEATURE_KEY = eINSTANCE.getFeatureKey();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitOp <em>Init Op</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitOp
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getInitOp()
		 * @generated
		 */
		EEnum INIT_OP = eINSTANCE.getInitOp();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind <em>Metamodel Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMetamodelKind()
		 * @generated
		 */
		EEnum METAMODEL_KIND = eINSTANCE.getMetamodelKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportKindEnum <em>Import Kind Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportKindEnum
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getImportKindEnum()
		 * @generated
		 */
		EEnum IMPORT_KIND_ENUM = eINSTANCE.getImportKindEnum();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionKindCS <em>Mapping Extension Kind CS</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionKindCS
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getMappingExtensionKindCS()
		 * @generated
		 */
		EEnum MAPPING_EXTENSION_KIND_CS = eINSTANCE.getMappingExtensionKindCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindEnum <em>Module Kind Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindEnum
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getModuleKindEnum()
		 * @generated
		 */
		EEnum MODULE_KIND_ENUM = eINSTANCE.getModuleKindEnum();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QualifierKindCS <em>Qualifier Kind CS</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QualifierKindCS
		 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVTOperationalCSPackageImpl#getQualifierKindCS()
		 * @generated
		 */
		EEnum QUALIFIER_KIND_CS = eINSTANCE.getQualifierKindCS();

	}

} //QVTOperationalCSPackage
