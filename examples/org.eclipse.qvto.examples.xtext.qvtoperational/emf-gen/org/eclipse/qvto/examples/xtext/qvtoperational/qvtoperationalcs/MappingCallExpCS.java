/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Mapping Call Exp CS</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingCallExpCS#isStrict <em>Strict</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getMappingCallExpCS()
 * @model
 * @generated
 */
public interface MappingCallExpCS
		extends ImperativeOperationCallExpCS {

	/**
	 * Returns the value of the '<em><b>Strict</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strict</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Strict</em>' attribute.
	 * @see #setStrict(boolean)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getMappingCallExpCS_Strict()
	 * @model
	 * @generated
	 */
	boolean isStrict();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingCallExpCS#isStrict
	 * <em>Strict</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Strict</em>' attribute.
	 * @see #isStrict()
	 * @generated
	 */
	void setStrict(boolean value);

} // MappingCallExpCS
