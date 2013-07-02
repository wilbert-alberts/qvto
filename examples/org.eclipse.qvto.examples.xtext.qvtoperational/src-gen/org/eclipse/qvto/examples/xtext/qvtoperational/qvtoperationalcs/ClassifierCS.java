/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Classifier CS</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#isIntermediate
 * <em>Intermediate</em>}</li>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#getQualifier
 * <em>Qualifier</em>}</li>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#getKeyword
 * <em>Keyword</em>}</li>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#getPathName
 * <em>Path Name</em>}</li>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#getExtends
 * <em>Extends</em>}</li>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#getFeature
 * <em>Feature</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getClassifierCS()
 * @model
 * @generated
 */
public interface ClassifierCS
		extends MetamodelElementCS {

	/**
	 * Returns the value of the '<em><b>Intermediate</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intermediate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Intermediate</em>' attribute.
	 * @see #setIntermediate(boolean)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getClassifierCS_Intermediate()
	 * @model
	 * @generated
	 */
	boolean isIntermediate();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#isIntermediate
	 * <em>Intermediate</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Intermediate</em>' attribute.
	 * @see #isIntermediate()
	 * @generated
	 */
	void setIntermediate(boolean value);

	/**
	 * Returns the value of the '<em><b>Qualifier</b></em>' attribute list. The
	 * list contents are of type
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.Qualifier}
	 * . The literals are from the enumeration
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.Qualifier}
	 * . <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualifier</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Qualifier</em>' attribute list.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.Qualifier
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getClassifierCS_Qualifier()
	 * @model unique="false"
	 * @generated
	 */
	EList<Qualifier> getQualifier();

	/**
	 * Returns the value of the '<em><b>Keyword</b></em>' attribute. The
	 * literals are from the enumeration
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierKind}
	 * . <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keyword</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Keyword</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierKind
	 * @see #setKeyword(ClassifierKind)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getClassifierCS_Keyword()
	 * @model
	 * @generated
	 */
	ClassifierKind getKeyword();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#getKeyword
	 * <em>Keyword</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Keyword</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierKind
	 * @see #getKeyword()
	 * @generated
	 */
	void setKeyword(ClassifierKind value);

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
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getClassifierCS_PathName()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getPathName();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS#getPathName
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
	 * Returns the value of the '<em><b>Extends</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Extends</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getClassifierCS_Extends()
	 * @model containment="true"
	 * @generated
	 */
	EList<PathNameCS> getExtends();

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierFeatureCS}
	 * . <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Feature</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getClassifierCS_Feature()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClassifierFeatureCS> getFeature();

} // ClassifierCS
