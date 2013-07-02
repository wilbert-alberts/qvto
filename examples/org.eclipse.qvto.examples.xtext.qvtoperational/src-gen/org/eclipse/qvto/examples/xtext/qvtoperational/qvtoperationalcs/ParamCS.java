/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Param CS</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS#getDirection
 * <em>Direction</em>}</li>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS#getPathName
 * <em>Path Name</em>}</li>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS#getTypespec
 * <em>Typespec</em>}</li>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS#getInitPart
 * <em>Init Part</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getParamCS()
 * @model
 * @generated
 */
public interface ParamCS
		extends ElementCS {

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute. The
	 * literals are from the enumeration
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamDirection}
	 * . <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamDirection
	 * @see #setDirection(ParamDirection)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getParamCS_Direction()
	 * @model
	 * @generated
	 */
	ParamDirection getDirection();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS#getDirection
	 * <em>Direction</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Direction</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamDirection
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(ParamDirection value);

	/**
	 * Returns the value of the '<em><b>Path Name</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Name</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Path Name</em>' containment reference.
	 * @see #setPathName(PathNameCS)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getParamCS_PathName()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getPathName();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS#getPathName
	 * <em>Path Name</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Path Name</em>' containment
	 *            reference.
	 * @see #getPathName()
	 * @generated
	 */
	void setPathName(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Typespec</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typespec</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Typespec</em>' containment reference.
	 * @see #setTypespec(TypedRefCS)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getParamCS_Typespec()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getTypespec();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS#getTypespec
	 * <em>Typespec</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Typespec</em>' containment
	 *            reference.
	 * @see #getTypespec()
	 * @generated
	 */
	void setTypespec(TypedRefCS value);

	/**
	 * Returns the value of the '<em><b>Init Part</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Part</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Init Part</em>' containment reference.
	 * @see #setInitPart(InitPartCS)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getParamCS_InitPart()
	 * @model containment="true"
	 * @generated
	 */
	InitPartCS getInitPart();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS#getInitPart
	 * <em>Init Part</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Init Part</em>' containment
	 *            reference.
	 * @see #getInitPart()
	 * @generated
	 */
	void setInitPart(InitPartCS value);

} // ParamCS
