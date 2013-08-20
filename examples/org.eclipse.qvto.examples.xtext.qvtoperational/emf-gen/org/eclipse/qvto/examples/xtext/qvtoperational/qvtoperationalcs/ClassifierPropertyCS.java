/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Classifier Property CS</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getOpposite <em>Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getClassifierPropertyCS()
 * @model
 * @generated
 */
public interface ClassifierPropertyCS
		extends StructuralFeatureCS {

	/**
	 * Returns the value of the '<em><b>Stereotypes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotypes</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotypes</em>' containment reference.
	 * @see #setStereotypes(ElementCS)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getClassifierPropertyCS_Stereotypes()
	 * @model containment="true"
	 * @generated
	 */
	ElementCS getStereotypes();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getStereotypes <em>Stereotypes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotypes</em>' containment reference.
	 * @see #getStereotypes()
	 * @generated
	 */
	void setStereotypes(ElementCS value);

	/**
	 * Returns the value of the '<em><b>Opposite</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Opposite</em>' attribute.
	 * @see #setOpposite(String)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getClassifierPropertyCS_Opposite()
	 * @model
	 * @generated
	 */
	String getOpposite();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS#getOpposite
	 * <em>Opposite</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Opposite</em>' attribute.
	 * @see #getOpposite()
	 * @generated
	 */
	void setOpposite(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='ocl::Property {\n\t\t\t\tname = name\n\t\t\t\t-- isComposite = qualifier->exists(\'composite\')\n\t\t\t\t-- type = TODO\n\t\t\t}'"
	 * @generated
	 */
	Property ast();

} // ClassifierPropertyCS
