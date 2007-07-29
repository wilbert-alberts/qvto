/**
 * <copyright>
 * </copyright>
 *
 * $Id: Class.java,v 1.1 2007/07/29 21:25:31 radvorak Exp $
 */
package simpleuml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link simpleuml.Class#getGeneralizations <em>Generalizations</em>}</li>
 *   <li>{@link simpleuml.Class#isAbstract <em>Abstract</em>}</li>
 * </ul>
 * </p>
 *
 * @see simpleuml.SimpleumlPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends DataType{
    /**
     * Returns the value of the '<em><b>Generalizations</b></em>' containment reference list.
     * The list contents are of type {@link simpleuml.Generalization}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generalizations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Generalizations</em>' containment reference list.
     * @see simpleuml.SimpleumlPackage#getClass_Generalizations()
     * @model type="simpleuml.Generalization" containment="true"
     * @generated
     */
	EList getGeneralizations();

    /**
     * Returns the value of the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Abstract</em>' attribute.
     * @see #setAbstract(boolean)
     * @see simpleuml.SimpleumlPackage#getClass_Abstract()
     * @model
     * @generated
     */
	boolean isAbstract();

    /**
     * Sets the value of the '{@link simpleuml.Class#isAbstract <em>Abstract</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Abstract</em>' attribute.
     * @see #isAbstract()
     * @generated
     */
	void setAbstract(boolean value);

} // Class
