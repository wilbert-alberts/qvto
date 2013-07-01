/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Qualifier</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getQualifier()
 * @model
 * @generated
 */
public enum Qualifier implements Enumerator
{
  /**
   * The '<em><b>BLACKBOX</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BLACKBOX_VALUE
   * @generated
   * @ordered
   */
  BLACKBOX(0, "BLACKBOX", "blackbox"),

  /**
   * The '<em><b>ABSTRACT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ABSTRACT_VALUE
   * @generated
   * @ordered
   */
  ABSTRACT(1, "ABSTRACT", "abstract"),

  /**
   * The '<em><b>STATIC</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #STATIC_VALUE
   * @generated
   * @ordered
   */
  STATIC(2, "STATIC", "static");

  /**
   * The '<em><b>BLACKBOX</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BLACKBOX</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BLACKBOX
   * @model literal="blackbox"
   * @generated
   * @ordered
   */
  public static final int BLACKBOX_VALUE = 0;

  /**
   * The '<em><b>ABSTRACT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ABSTRACT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ABSTRACT
   * @model literal="abstract"
   * @generated
   * @ordered
   */
  public static final int ABSTRACT_VALUE = 1;

  /**
   * The '<em><b>STATIC</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>STATIC</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #STATIC
   * @model literal="static"
   * @generated
   * @ordered
   */
  public static final int STATIC_VALUE = 2;

  /**
   * An array of all the '<em><b>Qualifier</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final Qualifier[] VALUES_ARRAY =
    new Qualifier[]
    {
      BLACKBOX,
      ABSTRACT,
      STATIC,
    };

  /**
   * A public read-only list of all the '<em><b>Qualifier</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<Qualifier> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Qualifier</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Qualifier get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      Qualifier result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Qualifier</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Qualifier getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      Qualifier result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Qualifier</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Qualifier get(int value)
  {
    switch (value)
    {
      case BLACKBOX_VALUE: return BLACKBOX;
      case ABSTRACT_VALUE: return ABSTRACT;
      case STATIC_VALUE: return STATIC;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private Qualifier(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //Qualifier
