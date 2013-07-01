/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;

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
 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsFactory
 * @model kind="package"
 * @generated
 */
public interface ImperativeoclcsPackage extends EPackage
{
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "imperativeoclcs";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://www.eclipse.org/qvt/pivot/1.0/ImperativeOCLCS";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "imperativeoclcs";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  ImperativeoclcsPackage eINSTANCE = org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl.init();

  /**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ListTypeCSImpl <em>List Type CS</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ListTypeCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getListTypeCS()
	 * @generated
	 */
  int LIST_TYPE_CS = 0;

  /**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LIST_TYPE_CS__LOGICAL_PARENT = BaseCSTPackage.TYPED_REF_CS__LOGICAL_PARENT;

  /**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LIST_TYPE_CS__PIVOT = BaseCSTPackage.TYPED_REF_CS__PIVOT;

  /**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LIST_TYPE_CS__MULTIPLICITY = BaseCSTPackage.TYPED_REF_CS__MULTIPLICITY;

  /**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LIST_TYPE_CS__TYPE = BaseCSTPackage.TYPED_REF_CS_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>List Type CS</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LIST_TYPE_CS_FEATURE_COUNT = BaseCSTPackage.TYPED_REF_CS_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.DictTypeCSImpl <em>Dict Type CS</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.DictTypeCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getDictTypeCS()
	 * @generated
	 */
  int DICT_TYPE_CS = 1;

  /**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DICT_TYPE_CS__LOGICAL_PARENT = BaseCSTPackage.TYPED_REF_CS__LOGICAL_PARENT;

  /**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DICT_TYPE_CS__PIVOT = BaseCSTPackage.TYPED_REF_CS__PIVOT;

  /**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DICT_TYPE_CS__MULTIPLICITY = BaseCSTPackage.TYPED_REF_CS__MULTIPLICITY;

  /**
	 * The feature id for the '<em><b>Key Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DICT_TYPE_CS__KEY_TYPE = BaseCSTPackage.TYPED_REF_CS_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Value Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DICT_TYPE_CS__VALUE_TYPE = BaseCSTPackage.TYPED_REF_CS_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Dict Type CS</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DICT_TYPE_CS_FEATURE_COUNT = BaseCSTPackage.TYPED_REF_CS_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ListLiteralExpCSImpl <em>List Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ListLiteralExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getListLiteralExpCS()
	 * @generated
	 */
  int LIST_LITERAL_EXP_CS = 2;

  /**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LIST_LITERAL_EXP_CS__LOGICAL_PARENT = EssentialOCLCSTPackage.EXP_CS__LOGICAL_PARENT;

  /**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LIST_LITERAL_EXP_CS__PIVOT = EssentialOCLCSTPackage.EXP_CS__PIVOT;

  /**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LIST_LITERAL_EXP_CS__OWNED_ANNOTATION = EssentialOCLCSTPackage.EXP_CS__OWNED_ANNOTATION;

  /**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LIST_LITERAL_EXP_CS__ORIGINAL_XMI_ID = EssentialOCLCSTPackage.EXP_CS__ORIGINAL_XMI_ID;

  /**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LIST_LITERAL_EXP_CS__CSI = EssentialOCLCSTPackage.EXP_CS__CSI;

  /**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LIST_LITERAL_EXP_CS__PARENT = EssentialOCLCSTPackage.EXP_CS__PARENT;

  /**
	 * The feature id for the '<em><b>Owned Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LIST_LITERAL_EXP_CS__OWNED_PARTS = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>List Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LIST_LITERAL_EXP_CS_FEATURE_COUNT = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.DictLiteralExpCSImpl <em>Dict Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.DictLiteralExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getDictLiteralExpCS()
	 * @generated
	 */
  int DICT_LITERAL_EXP_CS = 3;

  /**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DICT_LITERAL_EXP_CS__LOGICAL_PARENT = EssentialOCLCSTPackage.EXP_CS__LOGICAL_PARENT;

  /**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DICT_LITERAL_EXP_CS__PIVOT = EssentialOCLCSTPackage.EXP_CS__PIVOT;

  /**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DICT_LITERAL_EXP_CS__OWNED_ANNOTATION = EssentialOCLCSTPackage.EXP_CS__OWNED_ANNOTATION;

  /**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DICT_LITERAL_EXP_CS__ORIGINAL_XMI_ID = EssentialOCLCSTPackage.EXP_CS__ORIGINAL_XMI_ID;

  /**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DICT_LITERAL_EXP_CS__CSI = EssentialOCLCSTPackage.EXP_CS__CSI;

  /**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DICT_LITERAL_EXP_CS__PARENT = EssentialOCLCSTPackage.EXP_CS__PARENT;

  /**
	 * The feature id for the '<em><b>Owned Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DICT_LITERAL_EXP_CS__OWNED_PARTS = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Dict Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DICT_LITERAL_EXP_CS_FEATURE_COUNT = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.DictLiteralPartCSImpl <em>Dict Literal Part CS</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.DictLiteralPartCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getDictLiteralPartCS()
	 * @generated
	 */
  int DICT_LITERAL_PART_CS = 4;

  /**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART_CS__LOGICAL_PARENT = BaseCSTPackage.ELEMENT_CS__LOGICAL_PARENT;

		/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DICT_LITERAL_PART_CS__KEY = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DICT_LITERAL_PART_CS__VALUE = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Dict Literal Part CS</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DICT_LITERAL_PART_CS_FEATURE_COUNT = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ReturnExpCSImpl <em>Return Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ReturnExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getReturnExpCS()
	 * @generated
	 */
  int RETURN_EXP_CS = 5;

  /**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RETURN_EXP_CS__LOGICAL_PARENT = EssentialOCLCSTPackage.EXP_CS__LOGICAL_PARENT;

  /**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RETURN_EXP_CS__PIVOT = EssentialOCLCSTPackage.EXP_CS__PIVOT;

  /**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RETURN_EXP_CS__OWNED_ANNOTATION = EssentialOCLCSTPackage.EXP_CS__OWNED_ANNOTATION;

  /**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RETURN_EXP_CS__ORIGINAL_XMI_ID = EssentialOCLCSTPackage.EXP_CS__ORIGINAL_XMI_ID;

  /**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RETURN_EXP_CS__CSI = EssentialOCLCSTPackage.EXP_CS__CSI;

  /**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RETURN_EXP_CS__PARENT = EssentialOCLCSTPackage.EXP_CS__PARENT;

  /**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RETURN_EXP_CS__VALUE = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Return Exp CS</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RETURN_EXP_CS_FEATURE_COUNT = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.NameExpCSImpl <em>Name Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.NameExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getNameExpCS()
	 * @generated
	 */
  int NAME_EXP_CS = 6;

  /**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NAME_EXP_CS__LOGICAL_PARENT = EssentialOCLCSTPackage.EXP_CS__LOGICAL_PARENT;

  /**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NAME_EXP_CS__PIVOT = EssentialOCLCSTPackage.EXP_CS__PIVOT;

  /**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NAME_EXP_CS__OWNED_ANNOTATION = EssentialOCLCSTPackage.EXP_CS__OWNED_ANNOTATION;

  /**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NAME_EXP_CS__ORIGINAL_XMI_ID = EssentialOCLCSTPackage.EXP_CS__ORIGINAL_XMI_ID;

  /**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NAME_EXP_CS__CSI = EssentialOCLCSTPackage.EXP_CS__CSI;

  /**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NAME_EXP_CS__PARENT = EssentialOCLCSTPackage.EXP_CS__PARENT;

  /**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NAME_EXP_CS__PATH_NAME = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>At Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NAME_EXP_CS__AT_PRE = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Name Exp CS</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NAME_EXP_CS_FEATURE_COUNT = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 2;

  /**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.IndexExpCSImpl <em>Index Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.IndexExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getIndexExpCS()
	 * @generated
	 */
  int INDEX_EXP_CS = 7;

  /**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INDEX_EXP_CS__LOGICAL_PARENT = EssentialOCLCSTPackage.EXP_CS__LOGICAL_PARENT;

  /**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INDEX_EXP_CS__PIVOT = EssentialOCLCSTPackage.EXP_CS__PIVOT;

  /**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INDEX_EXP_CS__OWNED_ANNOTATION = EssentialOCLCSTPackage.EXP_CS__OWNED_ANNOTATION;

  /**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INDEX_EXP_CS__ORIGINAL_XMI_ID = EssentialOCLCSTPackage.EXP_CS__ORIGINAL_XMI_ID;

  /**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INDEX_EXP_CS__CSI = EssentialOCLCSTPackage.EXP_CS__CSI;

  /**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INDEX_EXP_CS__PARENT = EssentialOCLCSTPackage.EXP_CS__PARENT;

  /**
	 * The feature id for the '<em><b>Name Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INDEX_EXP_CS__NAME_EXP = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>First Indexes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INDEX_EXP_CS__FIRST_INDEXES = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Second Indexes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INDEX_EXP_CS__SECOND_INDEXES = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>At Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INDEX_EXP_CS__AT_PRE = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 3;

  /**
	 * The number of structural features of the '<em>Index Exp CS</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INDEX_EXP_CS_FEATURE_COUNT = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 4;

  /**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ConstructorExpCSImpl <em>Constructor Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ConstructorExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getConstructorExpCS()
	 * @generated
	 */
  int CONSTRUCTOR_EXP_CS = 8;

  /**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONSTRUCTOR_EXP_CS__LOGICAL_PARENT = EssentialOCLCSTPackage.EXP_CS__LOGICAL_PARENT;

  /**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONSTRUCTOR_EXP_CS__PIVOT = EssentialOCLCSTPackage.EXP_CS__PIVOT;

  /**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONSTRUCTOR_EXP_CS__OWNED_ANNOTATION = EssentialOCLCSTPackage.EXP_CS__OWNED_ANNOTATION;

  /**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONSTRUCTOR_EXP_CS__ORIGINAL_XMI_ID = EssentialOCLCSTPackage.EXP_CS__ORIGINAL_XMI_ID;

  /**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONSTRUCTOR_EXP_CS__CSI = EssentialOCLCSTPackage.EXP_CS__CSI;

  /**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONSTRUCTOR_EXP_CS__PARENT = EssentialOCLCSTPackage.EXP_CS__PARENT;

  /**
	 * The feature id for the '<em><b>Name Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONSTRUCTOR_EXP_CS__NAME_EXP = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Owned Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONSTRUCTOR_EXP_CS__OWNED_PARTS = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONSTRUCTOR_EXP_CS__VALUE = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>Constructor Exp CS</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONSTRUCTOR_EXP_CS_FEATURE_COUNT = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 3;

  /**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.InvocationExpCSImpl <em>Invocation Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.InvocationExpCSImpl
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getInvocationExpCS()
	 * @generated
	 */
  int INVOCATION_EXP_CS = 9;

  /**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOCATION_EXP_CS__LOGICAL_PARENT = EssentialOCLCSTPackage.EXP_CS__LOGICAL_PARENT;

  /**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOCATION_EXP_CS__PIVOT = EssentialOCLCSTPackage.EXP_CS__PIVOT;

  /**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOCATION_EXP_CS__OWNED_ANNOTATION = EssentialOCLCSTPackage.EXP_CS__OWNED_ANNOTATION;

  /**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOCATION_EXP_CS__ORIGINAL_XMI_ID = EssentialOCLCSTPackage.EXP_CS__ORIGINAL_XMI_ID;

  /**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOCATION_EXP_CS__CSI = EssentialOCLCSTPackage.EXP_CS__CSI;

  /**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOCATION_EXP_CS__PARENT = EssentialOCLCSTPackage.EXP_CS__PARENT;

  /**
	 * The feature id for the '<em><b>Name Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOCATION_EXP_CS__NAME_EXP = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOCATION_EXP_CS__ARGUMENT = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 1;

  /**
	 * The number of structural features of the '<em>Invocation Exp CS</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int INVOCATION_EXP_CS_FEATURE_COUNT = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 2;


  /**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS <em>List Type CS</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS
	 * @generated
	 */
  EClass getListTypeCS();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS#getType()
	 * @see #getListTypeCS()
	 * @generated
	 */
  EReference getListTypeCS_Type();

  /**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS <em>Dict Type CS</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dict Type CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS
	 * @generated
	 */
  EClass getDictTypeCS();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS#getKeyType <em>Key Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key Type</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS#getKeyType()
	 * @see #getDictTypeCS()
	 * @generated
	 */
  EReference getDictTypeCS_KeyType();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS#getValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Type</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS#getValueType()
	 * @see #getDictTypeCS()
	 * @generated
	 */
  EReference getDictTypeCS_ValueType();

  /**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListLiteralExpCS <em>List Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Literal Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListLiteralExpCS
	 * @generated
	 */
  EClass getListLiteralExpCS();

  /**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListLiteralExpCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListLiteralExpCS#getOwnedParts()
	 * @see #getListLiteralExpCS()
	 * @generated
	 */
  EReference getListLiteralExpCS_OwnedParts();

  /**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralExpCS <em>Dict Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dict Literal Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralExpCS
	 * @generated
	 */
  EClass getDictLiteralExpCS();

  /**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralExpCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralExpCS#getOwnedParts()
	 * @see #getDictLiteralExpCS()
	 * @generated
	 */
  EReference getDictLiteralExpCS_OwnedParts();

  /**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS <em>Dict Literal Part CS</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dict Literal Part CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS
	 * @generated
	 */
  EClass getDictLiteralPartCS();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS#getKey()
	 * @see #getDictLiteralPartCS()
	 * @generated
	 */
  EReference getDictLiteralPartCS_Key();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS#getValue()
	 * @see #getDictLiteralPartCS()
	 * @generated
	 */
  EReference getDictLiteralPartCS_Value();

  /**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ReturnExpCS <em>Return Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ReturnExpCS
	 * @generated
	 */
  EClass getReturnExpCS();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ReturnExpCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ReturnExpCS#getValue()
	 * @see #getReturnExpCS()
	 * @generated
	 */
  EReference getReturnExpCS_Value();

  /**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.NameExpCS <em>Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Name Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.NameExpCS
	 * @generated
	 */
  EClass getNameExpCS();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.NameExpCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.NameExpCS#getPathName()
	 * @see #getNameExpCS()
	 * @generated
	 */
  EReference getNameExpCS_PathName();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.NameExpCS#isAtPre <em>At Pre</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>At Pre</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.NameExpCS#isAtPre()
	 * @see #getNameExpCS()
	 * @generated
	 */
  EAttribute getNameExpCS_AtPre();

  /**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS <em>Index Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS
	 * @generated
	 */
  EClass getIndexExpCS();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS#getNameExp <em>Name Exp</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name Exp</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS#getNameExp()
	 * @see #getIndexExpCS()
	 * @generated
	 */
  EReference getIndexExpCS_NameExp();

  /**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS#getFirstIndexes <em>First Indexes</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>First Indexes</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS#getFirstIndexes()
	 * @see #getIndexExpCS()
	 * @generated
	 */
  EReference getIndexExpCS_FirstIndexes();

  /**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS#getSecondIndexes <em>Second Indexes</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Second Indexes</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS#getSecondIndexes()
	 * @see #getIndexExpCS()
	 * @generated
	 */
  EReference getIndexExpCS_SecondIndexes();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS#isAtPre <em>At Pre</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>At Pre</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS#isAtPre()
	 * @see #getIndexExpCS()
	 * @generated
	 */
  EAttribute getIndexExpCS_AtPre();

  /**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS <em>Constructor Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constructor Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS
	 * @generated
	 */
  EClass getConstructorExpCS();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS#getNameExp <em>Name Exp</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name Exp</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS#getNameExp()
	 * @see #getConstructorExpCS()
	 * @generated
	 */
  EReference getConstructorExpCS_NameExp();

  /**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS#getOwnedParts()
	 * @see #getConstructorExpCS()
	 * @generated
	 */
  EReference getConstructorExpCS_OwnedParts();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS#getValue()
	 * @see #getConstructorExpCS()
	 * @generated
	 */
  EAttribute getConstructorExpCS_Value();

  /**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.InvocationExpCS <em>Invocation Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invocation Exp CS</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.InvocationExpCS
	 * @generated
	 */
  EClass getInvocationExpCS();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.InvocationExpCS#getNameExp <em>Name Exp</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name Exp</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.InvocationExpCS#getNameExp()
	 * @see #getInvocationExpCS()
	 * @generated
	 */
  EReference getInvocationExpCS_NameExp();

  /**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.InvocationExpCS#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Argument</em>'.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.InvocationExpCS#getArgument()
	 * @see #getInvocationExpCS()
	 * @generated
	 */
  EReference getInvocationExpCS_Argument();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  ImperativeoclcsFactory getImperativeoclcsFactory();

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
  interface Literals
  {
    /**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ListTypeCSImpl <em>List Type CS</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ListTypeCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getListTypeCS()
		 * @generated
		 */
    EClass LIST_TYPE_CS = eINSTANCE.getListTypeCS();

    /**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference LIST_TYPE_CS__TYPE = eINSTANCE.getListTypeCS_Type();

    /**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.DictTypeCSImpl <em>Dict Type CS</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.DictTypeCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getDictTypeCS()
		 * @generated
		 */
    EClass DICT_TYPE_CS = eINSTANCE.getDictTypeCS();

    /**
		 * The meta object literal for the '<em><b>Key Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DICT_TYPE_CS__KEY_TYPE = eINSTANCE.getDictTypeCS_KeyType();

    /**
		 * The meta object literal for the '<em><b>Value Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DICT_TYPE_CS__VALUE_TYPE = eINSTANCE.getDictTypeCS_ValueType();

    /**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ListLiteralExpCSImpl <em>List Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ListLiteralExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getListLiteralExpCS()
		 * @generated
		 */
    EClass LIST_LITERAL_EXP_CS = eINSTANCE.getListLiteralExpCS();

    /**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference LIST_LITERAL_EXP_CS__OWNED_PARTS = eINSTANCE.getListLiteralExpCS_OwnedParts();

    /**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.DictLiteralExpCSImpl <em>Dict Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.DictLiteralExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getDictLiteralExpCS()
		 * @generated
		 */
    EClass DICT_LITERAL_EXP_CS = eINSTANCE.getDictLiteralExpCS();

    /**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DICT_LITERAL_EXP_CS__OWNED_PARTS = eINSTANCE.getDictLiteralExpCS_OwnedParts();

    /**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.DictLiteralPartCSImpl <em>Dict Literal Part CS</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.DictLiteralPartCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getDictLiteralPartCS()
		 * @generated
		 */
    EClass DICT_LITERAL_PART_CS = eINSTANCE.getDictLiteralPartCS();

    /**
		 * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DICT_LITERAL_PART_CS__KEY = eINSTANCE.getDictLiteralPartCS_Key();

    /**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DICT_LITERAL_PART_CS__VALUE = eINSTANCE.getDictLiteralPartCS_Value();

    /**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ReturnExpCSImpl <em>Return Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ReturnExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getReturnExpCS()
		 * @generated
		 */
    EClass RETURN_EXP_CS = eINSTANCE.getReturnExpCS();

    /**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference RETURN_EXP_CS__VALUE = eINSTANCE.getReturnExpCS_Value();

    /**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.NameExpCSImpl <em>Name Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.NameExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getNameExpCS()
		 * @generated
		 */
    EClass NAME_EXP_CS = eINSTANCE.getNameExpCS();

    /**
		 * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference NAME_EXP_CS__PATH_NAME = eINSTANCE.getNameExpCS_PathName();

    /**
		 * The meta object literal for the '<em><b>At Pre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute NAME_EXP_CS__AT_PRE = eINSTANCE.getNameExpCS_AtPre();

    /**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.IndexExpCSImpl <em>Index Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.IndexExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getIndexExpCS()
		 * @generated
		 */
    EClass INDEX_EXP_CS = eINSTANCE.getIndexExpCS();

    /**
		 * The meta object literal for the '<em><b>Name Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference INDEX_EXP_CS__NAME_EXP = eINSTANCE.getIndexExpCS_NameExp();

    /**
		 * The meta object literal for the '<em><b>First Indexes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference INDEX_EXP_CS__FIRST_INDEXES = eINSTANCE.getIndexExpCS_FirstIndexes();

    /**
		 * The meta object literal for the '<em><b>Second Indexes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference INDEX_EXP_CS__SECOND_INDEXES = eINSTANCE.getIndexExpCS_SecondIndexes();

    /**
		 * The meta object literal for the '<em><b>At Pre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute INDEX_EXP_CS__AT_PRE = eINSTANCE.getIndexExpCS_AtPre();

    /**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ConstructorExpCSImpl <em>Constructor Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ConstructorExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getConstructorExpCS()
		 * @generated
		 */
    EClass CONSTRUCTOR_EXP_CS = eINSTANCE.getConstructorExpCS();

    /**
		 * The meta object literal for the '<em><b>Name Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference CONSTRUCTOR_EXP_CS__NAME_EXP = eINSTANCE.getConstructorExpCS_NameExp();

    /**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference CONSTRUCTOR_EXP_CS__OWNED_PARTS = eINSTANCE.getConstructorExpCS_OwnedParts();

    /**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CONSTRUCTOR_EXP_CS__VALUE = eINSTANCE.getConstructorExpCS_Value();

    /**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.InvocationExpCSImpl <em>Invocation Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.InvocationExpCSImpl
		 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsPackageImpl#getInvocationExpCS()
		 * @generated
		 */
    EClass INVOCATION_EXP_CS = eINSTANCE.getInvocationExpCS();

    /**
		 * The meta object literal for the '<em><b>Name Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference INVOCATION_EXP_CS__NAME_EXP = eINSTANCE.getInvocationExpCS_NameExp();

    /**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference INVOCATION_EXP_CS__ARGUMENT = eINSTANCE.getInvocationExpCS_Argument();

  }

} //ImperativeoclcsPackage
