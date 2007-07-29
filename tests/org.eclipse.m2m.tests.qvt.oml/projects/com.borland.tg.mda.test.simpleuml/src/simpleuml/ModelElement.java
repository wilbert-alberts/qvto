/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelElement.java,v 1.1 2007/07/29 21:25:31 radvorak Exp $
 */
package simpleuml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link simpleuml.ModelElement#getName <em>Name</em>}</li>
 *   <li>{@link simpleuml.ModelElement#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link simpleuml.ModelElement#getTaggedValue <em>Tagged Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see simpleuml.SimpleumlPackage#getModelElement()
 * @model abstract="true"
 * @generated
 */
public interface ModelElement extends EObject{
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see simpleuml.SimpleumlPackage#getModelElement_Name()
     * @model
     * @generated
     */
	String getName();

    /**
     * Sets the value of the '{@link simpleuml.ModelElement#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
	void setName(String value);

    /**
     * Returns the value of the '<em><b>Stereotype</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Stereotype</em>' attribute list.
     * @see simpleuml.SimpleumlPackage#getModelElement_Stereotype()
     * @model type="java.lang.String"
     * @generated
     */
	EList getStereotype();

    /**
     * Returns the value of the '<em><b>Tagged Value</b></em>' containment reference list.
     * The list contents are of type {@link simpleuml.TaggedValue}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tagged Value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Tagged Value</em>' containment reference list.
     * @see simpleuml.SimpleumlPackage#getModelElement_TaggedValue()
     * @model type="simpleuml.TaggedValue" containment="true"
     * @generated
     */
	EList getTaggedValue();

} // ModelElement
