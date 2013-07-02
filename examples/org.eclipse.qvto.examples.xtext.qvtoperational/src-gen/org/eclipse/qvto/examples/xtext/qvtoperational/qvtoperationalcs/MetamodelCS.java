/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Metamodel CS</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS#getKeyword
 * <em>Keyword</em>}</li>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS#getPathName
 * <em>Path Name</em>}</li>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS#getElement
 * <em>Element</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getMetamodelCS()
 * @model
 * @generated
 */
public interface MetamodelCS
		extends UnitElementCS {

	/**
	 * Returns the value of the '<em><b>Keyword</b></em>' attribute. The
	 * literals are from the enumeration
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind}
	 * . <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keyword</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Keyword</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind
	 * @see #setKeyword(MetamodelKind)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getMetamodelCS_Keyword()
	 * @model
	 * @generated
	 */
	MetamodelKind getKeyword();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS#getKeyword
	 * <em>Keyword</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Keyword</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind
	 * @see #getKeyword()
	 * @generated
	 */
	void setKeyword(MetamodelKind value);

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
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getMetamodelCS_PathName()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getPathName();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS#getPathName
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
	 * Returns the value of the '<em><b>Element</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelElementCS}
	 * . <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Element</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getMetamodelCS_Element()
	 * @model containment="true"
	 * @generated
	 */
	EList<MetamodelElementCS> getElement();

} // MetamodelCS
