/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;

import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsFactory;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.InvocationExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListLiteralExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.NameExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImperativeoclcsPackageImpl extends EPackageImpl implements ImperativeoclcsPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass listTypeCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dictTypeCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass listLiteralExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dictLiteralExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dictLiteralPartCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nameExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass indexExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constructorExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass invocationExpCSEClass = null;

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
   * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ImperativeoclcsPackageImpl()
  {
    super(eNS_URI, ImperativeoclcsFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ImperativeoclcsPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ImperativeoclcsPackage init()
  {
    if (isInited) return (ImperativeoclcsPackage)EPackage.Registry.INSTANCE.getEPackage(ImperativeoclcsPackage.eNS_URI);

    // Obtain or create and register package
    ImperativeoclcsPackageImpl theImperativeoclcsPackage = (ImperativeoclcsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ImperativeoclcsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ImperativeoclcsPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EssentialOCLCSTPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theImperativeoclcsPackage.createPackageContents();

    // Initialize created meta-data
    theImperativeoclcsPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theImperativeoclcsPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ImperativeoclcsPackage.eNS_URI, theImperativeoclcsPackage);
    return theImperativeoclcsPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getListTypeCS()
  {
    return listTypeCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getListTypeCS_OwnedType()
  {
    return (EReference)listTypeCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDictTypeCS()
  {
    return dictTypeCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDictTypeCS_OwnedKeyTypeCS()
  {
    return (EReference)dictTypeCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDictTypeCS_OwnedElementTypeCS()
  {
    return (EReference)dictTypeCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getListLiteralExpCS()
  {
    return listLiteralExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getListLiteralExpCS_OwnedParts()
  {
    return (EReference)listLiteralExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDictLiteralExpCS()
  {
    return dictLiteralExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDictLiteralExpCS_OwnedParts()
  {
    return (EReference)dictLiteralExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDictLiteralPartCS()
  {
    return dictLiteralPartCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDictLiteralPartCS_KeyExpCS()
  {
    return (EReference)dictLiteralPartCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDictLiteralPartCS_ValueExpCS()
  {
    return (EReference)dictLiteralPartCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNameExpCS()
  {
    return nameExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameExpCS_PathName()
  {
    return (EReference)nameExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNameExpCS_AtPre()
  {
    return (EAttribute)nameExpCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIndexExpCS()
  {
    return indexExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIndexExpCS_NameExp()
  {
    return (EReference)indexExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIndexExpCS_FirstIndexes()
  {
    return (EReference)indexExpCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIndexExpCS_SecondIndexes()
  {
    return (EReference)indexExpCSEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIndexExpCS_AtPre()
  {
    return (EAttribute)indexExpCSEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstructorExpCS()
  {
    return constructorExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstructorExpCS_NameExp()
  {
    return (EReference)constructorExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstructorExpCS_OwnedParts()
  {
    return (EReference)constructorExpCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstructorExpCS_Value()
  {
    return (EAttribute)constructorExpCSEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInvocationExpCS()
  {
    return invocationExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocationExpCS_NameExp()
  {
    return (EReference)invocationExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocationExpCS_Argument()
  {
    return (EReference)invocationExpCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImperativeoclcsFactory getImperativeoclcsFactory()
  {
    return (ImperativeoclcsFactory)getEFactoryInstance();
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    listTypeCSEClass = createEClass(LIST_TYPE_CS);
    createEReference(listTypeCSEClass, LIST_TYPE_CS__OWNED_TYPE);

    dictTypeCSEClass = createEClass(DICT_TYPE_CS);
    createEReference(dictTypeCSEClass, DICT_TYPE_CS__OWNED_KEY_TYPE_CS);
    createEReference(dictTypeCSEClass, DICT_TYPE_CS__OWNED_ELEMENT_TYPE_CS);

    listLiteralExpCSEClass = createEClass(LIST_LITERAL_EXP_CS);
    createEReference(listLiteralExpCSEClass, LIST_LITERAL_EXP_CS__OWNED_PARTS);

    dictLiteralExpCSEClass = createEClass(DICT_LITERAL_EXP_CS);
    createEReference(dictLiteralExpCSEClass, DICT_LITERAL_EXP_CS__OWNED_PARTS);

    dictLiteralPartCSEClass = createEClass(DICT_LITERAL_PART_CS);
    createEReference(dictLiteralPartCSEClass, DICT_LITERAL_PART_CS__KEY_EXP_CS);
    createEReference(dictLiteralPartCSEClass, DICT_LITERAL_PART_CS__VALUE_EXP_CS);

    nameExpCSEClass = createEClass(NAME_EXP_CS);
    createEReference(nameExpCSEClass, NAME_EXP_CS__PATH_NAME);
    createEAttribute(nameExpCSEClass, NAME_EXP_CS__AT_PRE);

    indexExpCSEClass = createEClass(INDEX_EXP_CS);
    createEReference(indexExpCSEClass, INDEX_EXP_CS__NAME_EXP);
    createEReference(indexExpCSEClass, INDEX_EXP_CS__FIRST_INDEXES);
    createEReference(indexExpCSEClass, INDEX_EXP_CS__SECOND_INDEXES);
    createEAttribute(indexExpCSEClass, INDEX_EXP_CS__AT_PRE);

    constructorExpCSEClass = createEClass(CONSTRUCTOR_EXP_CS);
    createEReference(constructorExpCSEClass, CONSTRUCTOR_EXP_CS__NAME_EXP);
    createEReference(constructorExpCSEClass, CONSTRUCTOR_EXP_CS__OWNED_PARTS);
    createEAttribute(constructorExpCSEClass, CONSTRUCTOR_EXP_CS__VALUE);

    invocationExpCSEClass = createEClass(INVOCATION_EXP_CS);
    createEReference(invocationExpCSEClass, INVOCATION_EXP_CS__NAME_EXP);
    createEReference(invocationExpCSEClass, INVOCATION_EXP_CS__ARGUMENT);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    BaseCSTPackage theBaseCSTPackage = (BaseCSTPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSTPackage.eNS_URI);
    EssentialOCLCSTPackage theEssentialOCLCSTPackage = (EssentialOCLCSTPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLCSTPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    listTypeCSEClass.getESuperTypes().add(theBaseCSTPackage.getTypedRefCS());
    dictTypeCSEClass.getESuperTypes().add(theBaseCSTPackage.getTypedRefCS());
    listLiteralExpCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getExpCS());
    dictLiteralExpCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getExpCS());
    nameExpCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getExpCS());
    indexExpCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getExpCS());
    constructorExpCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getExpCS());
    invocationExpCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getExpCS());

    // Initialize classes and features; add operations and parameters
    initEClass(listTypeCSEClass, ListTypeCS.class, "ListTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getListTypeCS_OwnedType(), theBaseCSTPackage.getTypedRefCS(), null, "ownedType", null, 0, 1, ListTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dictTypeCSEClass, DictTypeCS.class, "DictTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDictTypeCS_OwnedKeyTypeCS(), theBaseCSTPackage.getTypedRefCS(), null, "ownedKeyTypeCS", null, 0, 1, DictTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDictTypeCS_OwnedElementTypeCS(), theBaseCSTPackage.getTypedRefCS(), null, "ownedElementTypeCS", null, 0, 1, DictTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(listLiteralExpCSEClass, ListLiteralExpCS.class, "ListLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getListLiteralExpCS_OwnedParts(), theBaseCSTPackage.getModelElementCS(), null, "ownedParts", null, 0, -1, ListLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dictLiteralExpCSEClass, DictLiteralExpCS.class, "DictLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDictLiteralExpCS_OwnedParts(), this.getDictLiteralPartCS(), null, "ownedParts", null, 0, -1, DictLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dictLiteralPartCSEClass, DictLiteralPartCS.class, "DictLiteralPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDictLiteralPartCS_KeyExpCS(), theEssentialOCLCSTPackage.getPrimitiveLiteralExpCS(), null, "keyExpCS", null, 0, 1, DictLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDictLiteralPartCS_ValueExpCS(), theEssentialOCLCSTPackage.getExpCS(), null, "valueExpCS", null, 0, 1, DictLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nameExpCSEClass, NameExpCS.class, "NameExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNameExpCS_PathName(), theBaseCSTPackage.getPathNameCS(), null, "pathName", null, 0, 1, NameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNameExpCS_AtPre(), ecorePackage.getEBoolean(), "atPre", null, 0, 1, NameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(indexExpCSEClass, IndexExpCS.class, "IndexExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIndexExpCS_NameExp(), this.getNameExpCS(), null, "nameExp", null, 0, 1, IndexExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIndexExpCS_FirstIndexes(), theEssentialOCLCSTPackage.getExpCS(), null, "firstIndexes", null, 0, -1, IndexExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIndexExpCS_SecondIndexes(), theEssentialOCLCSTPackage.getExpCS(), null, "secondIndexes", null, 0, -1, IndexExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndexExpCS_AtPre(), ecorePackage.getEBoolean(), "atPre", null, 0, 1, IndexExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(constructorExpCSEClass, ConstructorExpCS.class, "ConstructorExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConstructorExpCS_NameExp(), this.getNameExpCS(), null, "nameExp", null, 0, 1, ConstructorExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConstructorExpCS_OwnedParts(), theEssentialOCLCSTPackage.getConstructorPartCS(), null, "ownedParts", null, 0, -1, ConstructorExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getConstructorExpCS_Value(), ecorePackage.getEString(), "value", null, 0, 1, ConstructorExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(invocationExpCSEClass, InvocationExpCS.class, "InvocationExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInvocationExpCS_NameExp(), this.getNameExpCS(), null, "nameExp", null, 0, 1, InvocationExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInvocationExpCS_Argument(), theEssentialOCLCSTPackage.getNavigatingArgCS(), null, "argument", null, 0, -1, InvocationExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ImperativeoclcsPackageImpl
