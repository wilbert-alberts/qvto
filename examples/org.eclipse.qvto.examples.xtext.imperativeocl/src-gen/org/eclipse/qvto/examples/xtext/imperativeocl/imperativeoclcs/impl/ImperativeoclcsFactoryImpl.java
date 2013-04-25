/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImperativeoclcsFactoryImpl extends EFactoryImpl implements ImperativeoclcsFactory
{
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ImperativeoclcsFactory init()
  {
		try {
			ImperativeoclcsFactory theImperativeoclcsFactory = (ImperativeoclcsFactory)EPackage.Registry.INSTANCE.getEFactory(ImperativeoclcsPackage.eNS_URI);
			if (theImperativeoclcsFactory != null) {
				return theImperativeoclcsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ImperativeoclcsFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ImperativeoclcsFactoryImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EObject create(EClass eClass)
  {
		switch (eClass.getClassifierID()) {
			case ImperativeoclcsPackage.LIST_TYPE_CS: return createListTypeCS();
			case ImperativeoclcsPackage.DICT_TYPE_CS: return createDictTypeCS();
			case ImperativeoclcsPackage.LIST_LITERAL_EXP_CS: return createListLiteralExpCS();
			case ImperativeoclcsPackage.DICT_LITERAL_EXP_CS: return createDictLiteralExpCS();
			case ImperativeoclcsPackage.DICT_LITERAL_PART_CS: return createDictLiteralPartCS();
			case ImperativeoclcsPackage.RETURN_EXP_CS: return createReturnExpCS();
			case ImperativeoclcsPackage.NAME_EXP_CS: return createNameExpCS();
			case ImperativeoclcsPackage.INDEX_EXP_CS: return createIndexExpCS();
			case ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS: return createConstructorExpCS();
			case ImperativeoclcsPackage.INVOCATION_EXP_CS: return createInvocationExpCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ListTypeCS createListTypeCS()
  {
		ListTypeCSImpl listTypeCS = new ListTypeCSImpl();
		return listTypeCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DictTypeCS createDictTypeCS()
  {
		DictTypeCSImpl dictTypeCS = new DictTypeCSImpl();
		return dictTypeCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ListLiteralExpCS createListLiteralExpCS()
  {
		ListLiteralExpCSImpl listLiteralExpCS = new ListLiteralExpCSImpl();
		return listLiteralExpCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DictLiteralExpCS createDictLiteralExpCS()
  {
		DictLiteralExpCSImpl dictLiteralExpCS = new DictLiteralExpCSImpl();
		return dictLiteralExpCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DictLiteralPartCS createDictLiteralPartCS()
  {
		DictLiteralPartCSImpl dictLiteralPartCS = new DictLiteralPartCSImpl();
		return dictLiteralPartCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ReturnExpCS createReturnExpCS()
  {
		ReturnExpCSImpl returnExpCS = new ReturnExpCSImpl();
		return returnExpCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NameExpCS createNameExpCS()
  {
		NameExpCSImpl nameExpCS = new NameExpCSImpl();
		return nameExpCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IndexExpCS createIndexExpCS()
  {
		IndexExpCSImpl indexExpCS = new IndexExpCSImpl();
		return indexExpCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ConstructorExpCS createConstructorExpCS()
  {
		ConstructorExpCSImpl constructorExpCS = new ConstructorExpCSImpl();
		return constructorExpCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public InvocationExpCS createInvocationExpCS()
  {
		InvocationExpCSImpl invocationExpCS = new InvocationExpCSImpl();
		return invocationExpCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ImperativeoclcsPackage getImperativeoclcsPackage()
  {
		return (ImperativeoclcsPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static ImperativeoclcsPackage getPackage()
  {
		return ImperativeoclcsPackage.eINSTANCE;
	}

} //ImperativeoclcsFactoryImpl
