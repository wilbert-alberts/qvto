/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage
 * @generated
 */
public interface QvtoperationalcsFactory
		extends EFactory {

	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	QvtoperationalcsFactory eINSTANCE = org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QvtoperationalcsFactoryImpl
		.init();

	/**
	 * Returns a new object of class '<em>Top Level CS</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Top Level CS</em>'.
	 * @generated
	 */
	TopLevelCS createTopLevelCS();

	/**
	 * Returns a new object of class '<em>Import CS</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Import CS</em>'.
	 * @generated
	 */
	ImportCS createImportCS();

	/**
	 * Returns a new object of class '<em>Unit CS</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Unit CS</em>'.
	 * @generated
	 */
	UnitCS createUnitCS();

	/**
	 * Returns a new object of class '<em>Unit Element CS</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Unit Element CS</em>'.
	 * @generated
	 */
	UnitElementCS createUnitElementCS();

	/**
	 * Returns a new object of class '<em>Complete Signature CS</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Complete Signature CS</em>'.
	 * @generated
	 */
	CompleteSignatureCS createCompleteSignatureCS();

	/**
	 * Returns a new object of class '<em>Simple Signature CS</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Simple Signature CS</em>'.
	 * @generated
	 */
	SimpleSignatureCS createSimpleSignatureCS();

	/**
	 * Returns a new object of class '<em>Param CS</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Param CS</em>'.
	 * @generated
	 */
	ParamCS createParamCS();

	/**
	 * Returns a new object of class '<em>Init Part CS</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Init Part CS</em>'.
	 * @generated
	 */
	InitPartCS createInitPartCS();

	/**
	 * Returns a new object of class '<em>Metamodel CS</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Metamodel CS</em>'.
	 * @generated
	 */
	MetamodelCS createMetamodelCS();

	/**
	 * Returns a new object of class '<em>Metamodel Element CS</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Metamodel Element CS</em>'.
	 * @generated
	 */
	MetamodelElementCS createMetamodelElementCS();

	/**
	 * Returns a new object of class '<em>Classifier CS</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Classifier CS</em>'.
	 * @generated
	 */
	ClassifierCS createClassifierCS();

	/**
	 * Returns a new object of class '<em>Classifier Feature CS</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Classifier Feature CS</em>'.
	 * @generated
	 */
	ClassifierFeatureCS createClassifierFeatureCS();

	/**
	 * Returns a new object of class '<em>Classifier Property CS</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Classifier Property CS</em>'.
	 * @generated
	 */
	ClassifierPropertyCS createClassifierPropertyCS();

	/**
	 * Returns a new object of class '<em>Multiplicity CS</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Multiplicity CS</em>'.
	 * @generated
	 */
	MultiplicityCS createMultiplicityCS();

	/**
	 * Returns a new object of class '<em>Classifier Operation CS</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Classifier Operation CS</em>'.
	 * @generated
	 */
	ClassifierOperationCS createClassifierOperationCS();

	/**
	 * Returns a new object of class '<em>Enumeration CS</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Enumeration CS</em>'.
	 * @generated
	 */
	EnumerationCS createEnumerationCS();

	/**
	 * Returns a new object of class '<em>Tag CS</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Tag CS</em>'.
	 * @generated
	 */
	TagCS createTagCS();

	/**
	 * Returns a new object of class '<em>Typedef CS</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Typedef CS</em>'.
	 * @generated
	 */
	TypedefCS createTypedefCS();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	QvtoperationalcsPackage getQvtoperationalcsPackage();

} // QvtoperationalcsFactory
