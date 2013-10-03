/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS;
import org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Parameter Declaration CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS#getInitPart <em>Init Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getOperationParameterDeclarationCS()
 * @model
 * @generated
 */
public interface OperationParameterDeclarationCS extends ParameterCS {
	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindCS
	 * @see #isSetDirection()
	 * @see #unsetDirection()
	 * @see #setDirection(DirectionKindCS)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getOperationParameterDeclarationCS_Direction()
	 * @model unsettable="true"
	 * @generated
	 */
	DirectionKindCS getDirection();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindCS
	 * @see #isSetDirection()
	 * @see #unsetDirection()
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(DirectionKindCS value);

	/**
	 * Unsets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDirection()
	 * @see #getDirection()
	 * @see #setDirection(DirectionKindCS)
	 * @generated
	 */
	void unsetDirection();

	/**
	 * Returns whether the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS#getDirection <em>Direction</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Direction</em>' attribute is set.
	 * @see #unsetDirection()
	 * @see #getDirection()
	 * @see #setDirection(DirectionKindCS)
	 * @generated
	 */
	boolean isSetDirection();

	/**
	 * Returns the value of the '<em><b>Init Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Part</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Part</em>' containment reference.
	 * @see #setInitPart(InitPartCS)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getOperationParameterDeclarationCS_InitPart()
	 * @model containment="true"
	 * @generated
	 */
	InitPartCS getInitPart();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS#getInitPart <em>Init Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Part</em>' containment reference.
	 * @see #getInitPart()
	 * @generated
	 */
	void setInitPart(InitPartCS value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='qvtoperational::VarParameter {\n\t\t\t\tname = name\n\t\t\t\t--kind = if direction = DirectionKindCS::inout then\n\t\t\t\t--\t\t\tqvtoperational::DirectionKind::inout\n\t\t\t\t--\t   else if direction = DirectionKindCS::out then\n\t\t\t\t--\t   \t\tqvtoperational::DirectionKind::out\n\t\t\t\t--\t   else \n\t\t\t\t--\t   \t\tqvtoperational::DirectionKind::_in\n\t\t\t\t--\t   endif endif\n\t\t\t\t--initExpression = if (initPart.oclIsUndefined()) then\n\t\t\t\t--\t\t\t\t\tnull\n\t\t\t\t--\t\t\t\telse\n\t\t\t\t--\t\t\t\t\tinitPart.expression -- FIXME todo .ast()\n\t\t\t\t--\t\t\t\tendif\n\t\t\t}'"
	 * @generated
	 */
	VarParameter ast();

} // OperationParameterDeclarationCS
