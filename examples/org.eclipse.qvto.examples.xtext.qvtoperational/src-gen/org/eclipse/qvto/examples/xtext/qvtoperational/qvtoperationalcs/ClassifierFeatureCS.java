/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier Feature CS</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getClassifierFeatureCS()
 * @model
 * @generated
 */
public interface ClassifierFeatureCS extends EObject
{

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model vType="org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSVisitor<R>"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return v.visitClassifierFeatureCS(this);'"
	 * @generated
	 */
	<R> R accept(QVTOperationalCSVisitor<R> v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model vType="org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSVisitor<R>"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((QVTOperationalCSVisitor<R>)v).visitClassifierFeatureCS(this);'"
	 * @generated
	 */
	<R> R accept(BaseCSVisitor<R> v);
} // ClassifierFeatureCS
