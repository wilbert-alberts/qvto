/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsFactory
 * @model kind="package"
 * @generated
 */
public interface QvtoperationalcsPackage extends EPackage
{
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
  QvtoperationalcsPackage eINSTANCE = org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TopLevelCSImpl
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getTopLevelCS()
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
  int TOP_LEVEL_CS__LOGICAL_PARENT = EssentialOCLCSTPackage.EXP_CS__LOGICAL_PARENT;

  /**
   * The feature id for the '<em><b>Pivot</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOP_LEVEL_CS__PIVOT = EssentialOCLCSTPackage.EXP_CS__PIVOT;

  /**
   * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOP_LEVEL_CS__OWNED_ANNOTATION = EssentialOCLCSTPackage.EXP_CS__OWNED_ANNOTATION;

  /**
   * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOP_LEVEL_CS__ORIGINAL_XMI_ID = EssentialOCLCSTPackage.EXP_CS__ORIGINAL_XMI_ID;

  /**
   * The feature id for the '<em><b>Csi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOP_LEVEL_CS__CSI = EssentialOCLCSTPackage.EXP_CS__CSI;

  /**
   * The feature id for the '<em><b>Parent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOP_LEVEL_CS__PARENT = EssentialOCLCSTPackage.EXP_CS__PARENT;

  /**
   * The feature id for the '<em><b>Import</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOP_LEVEL_CS__IMPORT = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOP_LEVEL_CS__UNIT = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Top Level CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOP_LEVEL_CS_FEATURE_COUNT = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ImportCSImpl <em>Import CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ImportCSImpl
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getImportCS()
   * @generated
   */
  int IMPORT_CS = 1;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_CS__UNIT = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_CS__NAME = 1;

  /**
   * The feature id for the '<em><b>All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_CS__ALL = 2;

  /**
   * The number of structural features of the '<em>Import CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_CS_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.UnitCSImpl <em>Unit CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.UnitCSImpl
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getUnitCS()
   * @generated
   */
  int UNIT_CS = 2;

  /**
   * The feature id for the '<em><b>Segment</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_CS__SEGMENT = 0;

  /**
   * The number of structural features of the '<em>Unit CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_CS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.UnitElementCSImpl <em>Unit Element CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.UnitElementCSImpl
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getUnitElementCS()
   * @generated
   */
  int UNIT_ELEMENT_CS = 3;

  /**
   * The number of structural features of the '<em>Unit Element CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_ELEMENT_CS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.CompleteSignatureCSImpl <em>Complete Signature CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.CompleteSignatureCSImpl
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getCompleteSignatureCS()
   * @generated
   */
  int COMPLETE_SIGNATURE_CS = 4;

  /**
   * The number of structural features of the '<em>Complete Signature CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLETE_SIGNATURE_CS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.SimpleSignatureCSImpl <em>Simple Signature CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.SimpleSignatureCSImpl
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getSimpleSignatureCS()
   * @generated
   */
  int SIMPLE_SIGNATURE_CS = 5;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_SIGNATURE_CS__PARAM = COMPLETE_SIGNATURE_CS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Simple Signature CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_SIGNATURE_CS_FEATURE_COUNT = COMPLETE_SIGNATURE_CS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ParamCSImpl <em>Param CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ParamCSImpl
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getParamCS()
   * @generated
   */
  int PARAM_CS = 6;

  /**
   * The feature id for the '<em><b>Direction</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_CS__DIRECTION = 0;

  /**
   * The feature id for the '<em><b>Path Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_CS__PATH_NAME = 1;

  /**
   * The feature id for the '<em><b>Typespec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_CS__TYPESPEC = 2;

  /**
   * The feature id for the '<em><b>Init Part</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_CS__INIT_PART = 3;

  /**
   * The number of structural features of the '<em>Param CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_CS_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.InitPartCSImpl <em>Init Part CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.InitPartCSImpl
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getInitPartCS()
   * @generated
   */
  int INIT_PART_CS = 7;

  /**
   * The feature id for the '<em><b>Init Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_PART_CS__INIT_OP = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_PART_CS__EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Init Part CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_PART_CS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MetamodelCSImpl <em>Metamodel CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MetamodelCSImpl
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getMetamodelCS()
   * @generated
   */
  int METAMODEL_CS = 8;

  /**
   * The feature id for the '<em><b>Keyword</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL_CS__KEYWORD = UNIT_ELEMENT_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Path Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL_CS__PATH_NAME = UNIT_ELEMENT_CS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL_CS__ELEMENT = UNIT_ELEMENT_CS_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Metamodel CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL_CS_FEATURE_COUNT = UNIT_ELEMENT_CS_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MetamodelElementCSImpl <em>Metamodel Element CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MetamodelElementCSImpl
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getMetamodelElementCS()
   * @generated
   */
  int METAMODEL_ELEMENT_CS = 9;

  /**
   * The number of structural features of the '<em>Metamodel Element CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL_ELEMENT_CS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierCSImpl <em>Classifier CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierCSImpl
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getClassifierCS()
   * @generated
   */
  int CLASSIFIER_CS = 10;

  /**
   * The feature id for the '<em><b>Intermediate</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_CS__INTERMEDIATE = METAMODEL_ELEMENT_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_CS__QUALIFIER = METAMODEL_ELEMENT_CS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Keyword</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_CS__KEYWORD = METAMODEL_ELEMENT_CS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Path Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_CS__PATH_NAME = METAMODEL_ELEMENT_CS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Extends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_CS__EXTENDS = METAMODEL_ELEMENT_CS_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Feature</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_CS__FEATURE = METAMODEL_ELEMENT_CS_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Classifier CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_CS_FEATURE_COUNT = METAMODEL_ELEMENT_CS_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierFeatureCSImpl <em>Classifier Feature CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierFeatureCSImpl
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getClassifierFeatureCS()
   * @generated
   */
  int CLASSIFIER_FEATURE_CS = 11;

  /**
   * The number of structural features of the '<em>Classifier Feature CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_FEATURE_CS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierPropertyCSImpl <em>Classifier Property CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierPropertyCSImpl
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getClassifierPropertyCS()
   * @generated
   */
  int CLASSIFIER_PROPERTY_CS = 12;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_PROPERTY_CS__STEREOTYPE = CLASSIFIER_FEATURE_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Feature Key</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_PROPERTY_CS__FEATURE_KEY = CLASSIFIER_FEATURE_CS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_PROPERTY_CS__NAME = CLASSIFIER_FEATURE_CS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Typespec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_PROPERTY_CS__TYPESPEC = CLASSIFIER_FEATURE_CS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Init Part</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_PROPERTY_CS__INIT_PART = CLASSIFIER_FEATURE_CS_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_PROPERTY_CS__MULTIPLICITY = CLASSIFIER_FEATURE_CS_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Tilde</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_PROPERTY_CS__TILDE = CLASSIFIER_FEATURE_CS_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Opposite Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_PROPERTY_CS__OPPOSITE_IDENTIFIER = CLASSIFIER_FEATURE_CS_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Opposite Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_PROPERTY_CS__OPPOSITE_MULTIPLICITY = CLASSIFIER_FEATURE_CS_FEATURE_COUNT + 8;

  /**
   * The number of structural features of the '<em>Classifier Property CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_PROPERTY_CS_FEATURE_COUNT = CLASSIFIER_FEATURE_CS_FEATURE_COUNT + 9;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MultiplicityCSImpl <em>Multiplicity CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MultiplicityCSImpl
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getMultiplicityCS()
   * @generated
   */
  int MULTIPLICITY_CS = 13;

  /**
   * The feature id for the '<em><b>Logical Parent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_CS__LOGICAL_PARENT = BaseCSTPackage.MULTIPLICITY_CS__LOGICAL_PARENT;

  /**
   * The feature id for the '<em><b>Lower</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_CS__LOWER = BaseCSTPackage.MULTIPLICITY_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Upper</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_CS__UPPER = BaseCSTPackage.MULTIPLICITY_CS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Multiplicity CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_CS_FEATURE_COUNT = BaseCSTPackage.MULTIPLICITY_CS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierOperationCSImpl <em>Classifier Operation CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierOperationCSImpl
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getClassifierOperationCS()
   * @generated
   */
  int CLASSIFIER_OPERATION_CS = 14;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_OPERATION_CS__STEREOTYPE = CLASSIFIER_FEATURE_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Feature Key</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_OPERATION_CS__FEATURE_KEY = CLASSIFIER_FEATURE_CS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_OPERATION_CS__NAME = CLASSIFIER_FEATURE_CS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Typespec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_OPERATION_CS__TYPESPEC = CLASSIFIER_FEATURE_CS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Signature</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_OPERATION_CS__SIGNATURE = CLASSIFIER_FEATURE_CS_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Classifier Operation CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_OPERATION_CS_FEATURE_COUNT = CLASSIFIER_FEATURE_CS_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.EnumerationCSImpl <em>Enumeration CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.EnumerationCSImpl
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getEnumerationCS()
   * @generated
   */
  int ENUMERATION_CS = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION_CS__NAME = METAMODEL_ELEMENT_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Literal</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION_CS__LITERAL = METAMODEL_ELEMENT_CS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Enumeration CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION_CS_FEATURE_COUNT = METAMODEL_ELEMENT_CS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TagCSImpl <em>Tag CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TagCSImpl
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getTagCS()
   * @generated
   */
  int TAG_CS = 16;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAG_CS__ID = METAMODEL_ELEMENT_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Path Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAG_CS__PATH_NAME = METAMODEL_ELEMENT_CS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAG_CS__EXPRESSION = METAMODEL_ELEMENT_CS_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Tag CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAG_CS_FEATURE_COUNT = METAMODEL_ELEMENT_CS_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TypedefCSImpl <em>Typedef CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TypedefCSImpl
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getTypedefCS()
   * @generated
   */
  int TYPEDEF_CS = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_CS__NAME = 0;

  /**
   * The feature id for the '<em><b>Typespec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_CS__TYPESPEC = 1;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_CS__CONDITION = 2;

  /**
   * The number of structural features of the '<em>Typedef CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPEDEF_CS_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierKind <em>Classifier Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierKind
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getClassifierKind()
   * @generated
   */
  int CLASSIFIER_KIND = 18;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.FeatureKey <em>Feature Key</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.FeatureKey
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getFeatureKey()
   * @generated
   */
  int FEATURE_KEY = 19;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitOp <em>Init Op</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitOp
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getInitOp()
   * @generated
   */
  int INIT_OP = 20;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind <em>Metamodel Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getMetamodelKind()
   * @generated
   */
  int METAMODEL_KIND = 21;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamDirection <em>Param Direction</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamDirection
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getParamDirection()
   * @generated
   */
  int PARAM_DIRECTION = 22;

  /**
   * The meta object id for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.Qualifier <em>Qualifier</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.Qualifier
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getQualifier()
   * @generated
   */
  int QUALIFIER = 23;


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
   * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS <em>Import CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import CS</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS
   * @generated
   */
  EClass getImportCS();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Unit</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS#getUnit()
   * @see #getImportCS()
   * @generated
   */
  EReference getImportCS_Unit();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Name</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS#getName()
   * @see #getImportCS()
   * @generated
   */
  EAttribute getImportCS_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS#isAll <em>All</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>All</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS#isAll()
   * @see #getImportCS()
   * @generated
   */
  EAttribute getImportCS_All();

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
   * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitElementCS <em>Unit Element CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Element CS</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitElementCS
   * @generated
   */
  EClass getUnitElementCS();

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
   * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS <em>Simple Signature CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Signature CS</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS
   * @generated
   */
  EClass getSimpleSignatureCS();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Param</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS#getParam()
   * @see #getSimpleSignatureCS()
   * @generated
   */
  EReference getSimpleSignatureCS_Param();

  /**
   * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS <em>Param CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Param CS</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS
   * @generated
   */
  EClass getParamCS();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS#getDirection <em>Direction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Direction</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS#getDirection()
   * @see #getParamCS()
   * @generated
   */
  EAttribute getParamCS_Direction();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS#getPathName <em>Path Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path Name</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS#getPathName()
   * @see #getParamCS()
   * @generated
   */
  EReference getParamCS_PathName();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS#getTypespec <em>Typespec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Typespec</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS#getTypespec()
   * @see #getParamCS()
   * @generated
   */
  EReference getParamCS_Typespec();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS#getInitPart <em>Init Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init Part</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS#getInitPart()
   * @see #getParamCS()
   * @generated
   */
  EReference getParamCS_InitPart();

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
   * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS#getKeyword <em>Keyword</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Keyword</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS#getKeyword()
   * @see #getMetamodelCS()
   * @generated
   */
  EAttribute getMetamodelCS_Keyword();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS#getPathName <em>Path Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path Name</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS#getPathName()
   * @see #getMetamodelCS()
   * @generated
   */
  EReference getMetamodelCS_PathName();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Element</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS#getElement()
   * @see #getMetamodelCS()
   * @generated
   */
  EReference getMetamodelCS_Element();

  /**
   * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelElementCS <em>Metamodel Element CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Metamodel Element CS</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelElementCS
   * @generated
   */
  EClass getMetamodelElementCS();

  /**
   * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS <em>Classifier CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Classifier CS</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS
   * @generated
   */
  EClass getClassifierCS();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#isIntermediate <em>Intermediate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Intermediate</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#isIntermediate()
   * @see #getClassifierCS()
   * @generated
   */
  EAttribute getClassifierCS_Intermediate();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#getQualifier <em>Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Qualifier</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#getQualifier()
   * @see #getClassifierCS()
   * @generated
   */
  EAttribute getClassifierCS_Qualifier();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#getKeyword <em>Keyword</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Keyword</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#getKeyword()
   * @see #getClassifierCS()
   * @generated
   */
  EAttribute getClassifierCS_Keyword();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#getPathName <em>Path Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path Name</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#getPathName()
   * @see #getClassifierCS()
   * @generated
   */
  EReference getClassifierCS_PathName();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Extends</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#getExtends()
   * @see #getClassifierCS()
   * @generated
   */
  EReference getClassifierCS_Extends();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Feature</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#getFeature()
   * @see #getClassifierCS()
   * @generated
   */
  EReference getClassifierCS_Feature();

  /**
   * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierFeatureCS <em>Classifier Feature CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Classifier Feature CS</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierFeatureCS
   * @generated
   */
  EClass getClassifierFeatureCS();

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
   * Returns the meta object for the attribute list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getStereotype <em>Stereotype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Stereotype</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getStereotype()
   * @see #getClassifierPropertyCS()
   * @generated
   */
  EAttribute getClassifierPropertyCS_Stereotype();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getFeatureKey <em>Feature Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Feature Key</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getFeatureKey()
   * @see #getClassifierPropertyCS()
   * @generated
   */
  EAttribute getClassifierPropertyCS_FeatureKey();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getName()
   * @see #getClassifierPropertyCS()
   * @generated
   */
  EAttribute getClassifierPropertyCS_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getTypespec <em>Typespec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Typespec</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getTypespec()
   * @see #getClassifierPropertyCS()
   * @generated
   */
  EReference getClassifierPropertyCS_Typespec();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getInitPart <em>Init Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init Part</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getInitPart()
   * @see #getClassifierPropertyCS()
   * @generated
   */
  EReference getClassifierPropertyCS_InitPart();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multiplicity</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getMultiplicity()
   * @see #getClassifierPropertyCS()
   * @generated
   */
  EReference getClassifierPropertyCS_Multiplicity();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#isTilde <em>Tilde</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tilde</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#isTilde()
   * @see #getClassifierPropertyCS()
   * @generated
   */
  EAttribute getClassifierPropertyCS_Tilde();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getOppositeIdentifier <em>Opposite Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Opposite Identifier</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getOppositeIdentifier()
   * @see #getClassifierPropertyCS()
   * @generated
   */
  EAttribute getClassifierPropertyCS_OppositeIdentifier();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getOppositeMultiplicity <em>Opposite Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Opposite Multiplicity</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getOppositeMultiplicity()
   * @see #getClassifierPropertyCS()
   * @generated
   */
  EReference getClassifierPropertyCS_OppositeMultiplicity();

  /**
   * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityCS <em>Multiplicity CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicity CS</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityCS
   * @generated
   */
  EClass getMultiplicityCS();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityCS#getLower <em>Lower</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityCS#getLower()
   * @see #getMultiplicityCS()
   * @generated
   */
  EAttribute getMultiplicityCS_Lower();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityCS#getUpper <em>Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityCS#getUpper()
   * @see #getMultiplicityCS()
   * @generated
   */
  EAttribute getMultiplicityCS_Upper();

  /**
   * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS <em>Classifier Operation CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Classifier Operation CS</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS
   * @generated
   */
  EClass getClassifierOperationCS();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS#getStereotype <em>Stereotype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Stereotype</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS#getStereotype()
   * @see #getClassifierOperationCS()
   * @generated
   */
  EAttribute getClassifierOperationCS_Stereotype();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS#getFeatureKey <em>Feature Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Feature Key</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS#getFeatureKey()
   * @see #getClassifierOperationCS()
   * @generated
   */
  EAttribute getClassifierOperationCS_FeatureKey();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS#getName()
   * @see #getClassifierOperationCS()
   * @generated
   */
  EAttribute getClassifierOperationCS_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS#getTypespec <em>Typespec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Typespec</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS#getTypespec()
   * @see #getClassifierOperationCS()
   * @generated
   */
  EReference getClassifierOperationCS_Typespec();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS#getSignature <em>Signature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Signature</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS#getSignature()
   * @see #getClassifierOperationCS()
   * @generated
   */
  EReference getClassifierOperationCS_Signature();

  /**
   * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.EnumerationCS <em>Enumeration CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enumeration CS</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.EnumerationCS
   * @generated
   */
  EClass getEnumerationCS();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.EnumerationCS#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.EnumerationCS#getName()
   * @see #getEnumerationCS()
   * @generated
   */
  EAttribute getEnumerationCS_Name();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.EnumerationCS#getLiteral <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Literal</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.EnumerationCS#getLiteral()
   * @see #getEnumerationCS()
   * @generated
   */
  EAttribute getEnumerationCS_Literal();

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
   * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS#getId()
   * @see #getTagCS()
   * @generated
   */
  EAttribute getTagCS_Id();

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
   * Returns the meta object for class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS <em>Typedef CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typedef CS</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS
   * @generated
   */
  EClass getTypedefCS();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS#getName()
   * @see #getTypedefCS()
   * @generated
   */
  EAttribute getTypedefCS_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS#getTypespec <em>Typespec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Typespec</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS#getTypespec()
   * @see #getTypedefCS()
   * @generated
   */
  EReference getTypedefCS_Typespec();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS#getCondition()
   * @see #getTypedefCS()
   * @generated
   */
  EReference getTypedefCS_Condition();

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
   * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamDirection <em>Param Direction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Param Direction</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamDirection
   * @generated
   */
  EEnum getParamDirection();

  /**
   * Returns the meta object for enum '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.Qualifier <em>Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Qualifier</em>'.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.Qualifier
   * @generated
   */
  EEnum getQualifier();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  QvtoperationalcsFactory getQvtoperationalcsFactory();

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
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TopLevelCSImpl
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getTopLevelCS()
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
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ImportCSImpl <em>Import CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ImportCSImpl
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getImportCS()
     * @generated
     */
    EClass IMPORT_CS = eINSTANCE.getImportCS();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPORT_CS__UNIT = eINSTANCE.getImportCS_Unit();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT_CS__NAME = eINSTANCE.getImportCS_Name();

    /**
     * The meta object literal for the '<em><b>All</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT_CS__ALL = eINSTANCE.getImportCS_All();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.UnitCSImpl <em>Unit CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.UnitCSImpl
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getUnitCS()
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
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.UnitElementCSImpl <em>Unit Element CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.UnitElementCSImpl
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getUnitElementCS()
     * @generated
     */
    EClass UNIT_ELEMENT_CS = eINSTANCE.getUnitElementCS();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.CompleteSignatureCSImpl <em>Complete Signature CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.CompleteSignatureCSImpl
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getCompleteSignatureCS()
     * @generated
     */
    EClass COMPLETE_SIGNATURE_CS = eINSTANCE.getCompleteSignatureCS();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.SimpleSignatureCSImpl <em>Simple Signature CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.SimpleSignatureCSImpl
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getSimpleSignatureCS()
     * @generated
     */
    EClass SIMPLE_SIGNATURE_CS = eINSTANCE.getSimpleSignatureCS();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIMPLE_SIGNATURE_CS__PARAM = eINSTANCE.getSimpleSignatureCS_Param();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ParamCSImpl <em>Param CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ParamCSImpl
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getParamCS()
     * @generated
     */
    EClass PARAM_CS = eINSTANCE.getParamCS();

    /**
     * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAM_CS__DIRECTION = eINSTANCE.getParamCS_Direction();

    /**
     * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAM_CS__PATH_NAME = eINSTANCE.getParamCS_PathName();

    /**
     * The meta object literal for the '<em><b>Typespec</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAM_CS__TYPESPEC = eINSTANCE.getParamCS_Typespec();

    /**
     * The meta object literal for the '<em><b>Init Part</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAM_CS__INIT_PART = eINSTANCE.getParamCS_InitPart();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.InitPartCSImpl <em>Init Part CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.InitPartCSImpl
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getInitPartCS()
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
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getMetamodelCS()
     * @generated
     */
    EClass METAMODEL_CS = eINSTANCE.getMetamodelCS();

    /**
     * The meta object literal for the '<em><b>Keyword</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METAMODEL_CS__KEYWORD = eINSTANCE.getMetamodelCS_Keyword();

    /**
     * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METAMODEL_CS__PATH_NAME = eINSTANCE.getMetamodelCS_PathName();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METAMODEL_CS__ELEMENT = eINSTANCE.getMetamodelCS_Element();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MetamodelElementCSImpl <em>Metamodel Element CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MetamodelElementCSImpl
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getMetamodelElementCS()
     * @generated
     */
    EClass METAMODEL_ELEMENT_CS = eINSTANCE.getMetamodelElementCS();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierCSImpl <em>Classifier CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierCSImpl
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getClassifierCS()
     * @generated
     */
    EClass CLASSIFIER_CS = eINSTANCE.getClassifierCS();

    /**
     * The meta object literal for the '<em><b>Intermediate</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFIER_CS__INTERMEDIATE = eINSTANCE.getClassifierCS_Intermediate();

    /**
     * The meta object literal for the '<em><b>Qualifier</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFIER_CS__QUALIFIER = eINSTANCE.getClassifierCS_Qualifier();

    /**
     * The meta object literal for the '<em><b>Keyword</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFIER_CS__KEYWORD = eINSTANCE.getClassifierCS_Keyword();

    /**
     * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER_CS__PATH_NAME = eINSTANCE.getClassifierCS_PathName();

    /**
     * The meta object literal for the '<em><b>Extends</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER_CS__EXTENDS = eINSTANCE.getClassifierCS_Extends();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER_CS__FEATURE = eINSTANCE.getClassifierCS_Feature();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierFeatureCSImpl <em>Classifier Feature CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierFeatureCSImpl
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getClassifierFeatureCS()
     * @generated
     */
    EClass CLASSIFIER_FEATURE_CS = eINSTANCE.getClassifierFeatureCS();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierPropertyCSImpl <em>Classifier Property CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierPropertyCSImpl
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getClassifierPropertyCS()
     * @generated
     */
    EClass CLASSIFIER_PROPERTY_CS = eINSTANCE.getClassifierPropertyCS();

    /**
     * The meta object literal for the '<em><b>Stereotype</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFIER_PROPERTY_CS__STEREOTYPE = eINSTANCE.getClassifierPropertyCS_Stereotype();

    /**
     * The meta object literal for the '<em><b>Feature Key</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFIER_PROPERTY_CS__FEATURE_KEY = eINSTANCE.getClassifierPropertyCS_FeatureKey();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFIER_PROPERTY_CS__NAME = eINSTANCE.getClassifierPropertyCS_Name();

    /**
     * The meta object literal for the '<em><b>Typespec</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER_PROPERTY_CS__TYPESPEC = eINSTANCE.getClassifierPropertyCS_Typespec();

    /**
     * The meta object literal for the '<em><b>Init Part</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER_PROPERTY_CS__INIT_PART = eINSTANCE.getClassifierPropertyCS_InitPart();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER_PROPERTY_CS__MULTIPLICITY = eINSTANCE.getClassifierPropertyCS_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Tilde</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFIER_PROPERTY_CS__TILDE = eINSTANCE.getClassifierPropertyCS_Tilde();

    /**
     * The meta object literal for the '<em><b>Opposite Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFIER_PROPERTY_CS__OPPOSITE_IDENTIFIER = eINSTANCE.getClassifierPropertyCS_OppositeIdentifier();

    /**
     * The meta object literal for the '<em><b>Opposite Multiplicity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER_PROPERTY_CS__OPPOSITE_MULTIPLICITY = eINSTANCE.getClassifierPropertyCS_OppositeMultiplicity();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MultiplicityCSImpl <em>Multiplicity CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MultiplicityCSImpl
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getMultiplicityCS()
     * @generated
     */
    EClass MULTIPLICITY_CS = eINSTANCE.getMultiplicityCS();

    /**
     * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICITY_CS__LOWER = eINSTANCE.getMultiplicityCS_Lower();

    /**
     * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICITY_CS__UPPER = eINSTANCE.getMultiplicityCS_Upper();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierOperationCSImpl <em>Classifier Operation CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierOperationCSImpl
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getClassifierOperationCS()
     * @generated
     */
    EClass CLASSIFIER_OPERATION_CS = eINSTANCE.getClassifierOperationCS();

    /**
     * The meta object literal for the '<em><b>Stereotype</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFIER_OPERATION_CS__STEREOTYPE = eINSTANCE.getClassifierOperationCS_Stereotype();

    /**
     * The meta object literal for the '<em><b>Feature Key</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFIER_OPERATION_CS__FEATURE_KEY = eINSTANCE.getClassifierOperationCS_FeatureKey();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFIER_OPERATION_CS__NAME = eINSTANCE.getClassifierOperationCS_Name();

    /**
     * The meta object literal for the '<em><b>Typespec</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER_OPERATION_CS__TYPESPEC = eINSTANCE.getClassifierOperationCS_Typespec();

    /**
     * The meta object literal for the '<em><b>Signature</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER_OPERATION_CS__SIGNATURE = eINSTANCE.getClassifierOperationCS_Signature();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.EnumerationCSImpl <em>Enumeration CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.EnumerationCSImpl
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getEnumerationCS()
     * @generated
     */
    EClass ENUMERATION_CS = eINSTANCE.getEnumerationCS();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUMERATION_CS__NAME = eINSTANCE.getEnumerationCS_Name();

    /**
     * The meta object literal for the '<em><b>Literal</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUMERATION_CS__LITERAL = eINSTANCE.getEnumerationCS_Literal();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TagCSImpl <em>Tag CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TagCSImpl
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getTagCS()
     * @generated
     */
    EClass TAG_CS = eINSTANCE.getTagCS();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TAG_CS__ID = eINSTANCE.getTagCS_Id();

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
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TypedefCSImpl <em>Typedef CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TypedefCSImpl
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getTypedefCS()
     * @generated
     */
    EClass TYPEDEF_CS = eINSTANCE.getTypedefCS();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPEDEF_CS__NAME = eINSTANCE.getTypedefCS_Name();

    /**
     * The meta object literal for the '<em><b>Typespec</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPEDEF_CS__TYPESPEC = eINSTANCE.getTypedefCS_Typespec();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPEDEF_CS__CONDITION = eINSTANCE.getTypedefCS_Condition();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierKind <em>Classifier Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierKind
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getClassifierKind()
     * @generated
     */
    EEnum CLASSIFIER_KIND = eINSTANCE.getClassifierKind();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.FeatureKey <em>Feature Key</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.FeatureKey
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getFeatureKey()
     * @generated
     */
    EEnum FEATURE_KEY = eINSTANCE.getFeatureKey();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitOp <em>Init Op</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitOp
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getInitOp()
     * @generated
     */
    EEnum INIT_OP = eINSTANCE.getInitOp();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind <em>Metamodel Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getMetamodelKind()
     * @generated
     */
    EEnum METAMODEL_KIND = eINSTANCE.getMetamodelKind();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamDirection <em>Param Direction</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamDirection
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getParamDirection()
     * @generated
     */
    EEnum PARAM_DIRECTION = eINSTANCE.getParamDirection();

    /**
     * The meta object literal for the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.Qualifier <em>Qualifier</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.Qualifier
     * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsPackageImpl#getQualifier()
     * @generated
     */
    EEnum QUALIFIER = eINSTANCE.getQualifier();

  }

} //QvtoperationalcsPackage
