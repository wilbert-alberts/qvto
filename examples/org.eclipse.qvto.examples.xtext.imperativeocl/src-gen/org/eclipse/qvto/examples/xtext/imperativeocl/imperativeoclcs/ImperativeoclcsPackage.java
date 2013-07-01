/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs;

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

  }

} //ImperativeoclcsPackage
