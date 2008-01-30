/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResourceEObject.java,v 1.1 2008/01/30 10:31:35 sboyko Exp $
 */
package org.eclipse.m2m.qvt.oml.emf.util.modelparam;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource EObject</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emf.util.modelparam.ResourceEObject#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.emf.util.modelparam.ModelparamPackage#getResourceEObject()
 * @model
 * @generated
 */
public interface ResourceEObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.eclipse.m2m.qvt.oml.emf.util.modelparam.ModelparamPackage#getResourceEObject_Children()
	 * @model
	 * @generated
	 */
	EList<EObject> getChildren();

} // ResourceEObject
