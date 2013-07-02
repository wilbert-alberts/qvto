/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierFeatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.EnumerationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelElementCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitElementCS;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * 
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage
 * @generated
 */
public class QvtoperationalcsSwitch<T>
		extends Switch<T> {

	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static QvtoperationalcsPackage modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public QvtoperationalcsSwitch() {
		if (modelPackage == null) {
			modelPackage = QvtoperationalcsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns
	 * a non null result; it yields that result. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code>
	 *         call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case QvtoperationalcsPackage.TOP_LEVEL_CS : {
				TopLevelCS topLevelCS = (TopLevelCS) theEObject;
				T result = caseTopLevelCS(topLevelCS);
				if (result == null)
					result = caseElementCS(topLevelCS);
				if (result == null)
					result = caseVisitableCS(topLevelCS);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case QvtoperationalcsPackage.IMPORT_CS : {
				ImportCS importCS = (ImportCS) theEObject;
				T result = caseImportCS(importCS);
				if (result == null)
					result = caseElementCS(importCS);
				if (result == null)
					result = caseVisitableCS(importCS);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case QvtoperationalcsPackage.UNIT_CS : {
				UnitCS unitCS = (UnitCS) theEObject;
				T result = caseUnitCS(unitCS);
				if (result == null)
					result = caseElementCS(unitCS);
				if (result == null)
					result = caseVisitableCS(unitCS);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case QvtoperationalcsPackage.UNIT_ELEMENT_CS : {
				UnitElementCS unitElementCS = (UnitElementCS) theEObject;
				T result = caseUnitElementCS(unitElementCS);
				if (result == null)
					result = caseElementCS(unitElementCS);
				if (result == null)
					result = caseVisitableCS(unitElementCS);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case QvtoperationalcsPackage.COMPLETE_SIGNATURE_CS : {
				CompleteSignatureCS completeSignatureCS = (CompleteSignatureCS) theEObject;
				T result = caseCompleteSignatureCS(completeSignatureCS);
				if (result == null)
					result = caseElementCS(completeSignatureCS);
				if (result == null)
					result = caseVisitableCS(completeSignatureCS);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case QvtoperationalcsPackage.SIMPLE_SIGNATURE_CS : {
				SimpleSignatureCS simpleSignatureCS = (SimpleSignatureCS) theEObject;
				T result = caseSimpleSignatureCS(simpleSignatureCS);
				if (result == null)
					result = caseCompleteSignatureCS(simpleSignatureCS);
				if (result == null)
					result = caseElementCS(simpleSignatureCS);
				if (result == null)
					result = caseVisitableCS(simpleSignatureCS);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case QvtoperationalcsPackage.PARAM_CS : {
				ParamCS paramCS = (ParamCS) theEObject;
				T result = caseParamCS(paramCS);
				if (result == null)
					result = caseElementCS(paramCS);
				if (result == null)
					result = caseVisitableCS(paramCS);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case QvtoperationalcsPackage.INIT_PART_CS : {
				InitPartCS initPartCS = (InitPartCS) theEObject;
				T result = caseInitPartCS(initPartCS);
				if (result == null)
					result = caseElementCS(initPartCS);
				if (result == null)
					result = caseVisitableCS(initPartCS);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case QvtoperationalcsPackage.METAMODEL_CS : {
				MetamodelCS metamodelCS = (MetamodelCS) theEObject;
				T result = caseMetamodelCS(metamodelCS);
				if (result == null)
					result = caseUnitElementCS(metamodelCS);
				if (result == null)
					result = caseElementCS(metamodelCS);
				if (result == null)
					result = caseVisitableCS(metamodelCS);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case QvtoperationalcsPackage.METAMODEL_ELEMENT_CS : {
				MetamodelElementCS metamodelElementCS = (MetamodelElementCS) theEObject;
				T result = caseMetamodelElementCS(metamodelElementCS);
				if (result == null)
					result = caseElementCS(metamodelElementCS);
				if (result == null)
					result = caseVisitableCS(metamodelElementCS);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case QvtoperationalcsPackage.CLASSIFIER_CS : {
				ClassifierCS classifierCS = (ClassifierCS) theEObject;
				T result = caseClassifierCS(classifierCS);
				if (result == null)
					result = caseMetamodelElementCS(classifierCS);
				if (result == null)
					result = caseElementCS(classifierCS);
				if (result == null)
					result = caseVisitableCS(classifierCS);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case QvtoperationalcsPackage.CLASSIFIER_FEATURE_CS : {
				ClassifierFeatureCS classifierFeatureCS = (ClassifierFeatureCS) theEObject;
				T result = caseClassifierFeatureCS(classifierFeatureCS);
				if (result == null)
					result = caseElementCS(classifierFeatureCS);
				if (result == null)
					result = caseVisitableCS(classifierFeatureCS);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS : {
				ClassifierPropertyCS classifierPropertyCS = (ClassifierPropertyCS) theEObject;
				T result = caseClassifierPropertyCS(classifierPropertyCS);
				if (result == null)
					result = caseClassifierFeatureCS(classifierPropertyCS);
				if (result == null)
					result = caseElementCS(classifierPropertyCS);
				if (result == null)
					result = caseVisitableCS(classifierPropertyCS);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case QvtoperationalcsPackage.MULTIPLICITY_CS : {
				MultiplicityCS multiplicityCS = (MultiplicityCS) theEObject;
				T result = caseMultiplicityCS(multiplicityCS);
				if (result == null)
					result = caseBaseCST_MultiplicityCS(multiplicityCS);
				if (result == null)
					result = caseElementCS(multiplicityCS);
				if (result == null)
					result = caseVisitableCS(multiplicityCS);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS : {
				ClassifierOperationCS classifierOperationCS = (ClassifierOperationCS) theEObject;
				T result = caseClassifierOperationCS(classifierOperationCS);
				if (result == null)
					result = caseClassifierFeatureCS(classifierOperationCS);
				if (result == null)
					result = caseElementCS(classifierOperationCS);
				if (result == null)
					result = caseVisitableCS(classifierOperationCS);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case QvtoperationalcsPackage.ENUMERATION_CS : {
				EnumerationCS enumerationCS = (EnumerationCS) theEObject;
				T result = caseEnumerationCS(enumerationCS);
				if (result == null)
					result = caseMetamodelElementCS(enumerationCS);
				if (result == null)
					result = caseElementCS(enumerationCS);
				if (result == null)
					result = caseVisitableCS(enumerationCS);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case QvtoperationalcsPackage.TAG_CS : {
				TagCS tagCS = (TagCS) theEObject;
				T result = caseTagCS(tagCS);
				if (result == null)
					result = caseMetamodelElementCS(tagCS);
				if (result == null)
					result = caseClassifierFeatureCS(tagCS);
				if (result == null)
					result = caseElementCS(tagCS);
				if (result == null)
					result = caseVisitableCS(tagCS);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case QvtoperationalcsPackage.TYPEDEF_CS : {
				TypedefCS typedefCS = (TypedefCS) theEObject;
				T result = caseTypedefCS(typedefCS);
				if (result == null)
					result = caseElementCS(typedefCS);
				if (result == null)
					result = caseVisitableCS(typedefCS);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			default :
				return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Top Level CS</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Top Level CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTopLevelCS(TopLevelCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Import CS</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Import CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImportCS(ImportCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Unit CS</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Unit CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitCS(UnitCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Unit Element CS</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Unit Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitElementCS(UnitElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Complete Signature CS</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate
	 * the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Complete Signature CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompleteSignatureCS(CompleteSignatureCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Simple Signature CS</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate
	 * the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Simple Signature CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleSignatureCS(SimpleSignatureCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Param CS</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Param CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParamCS(ParamCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Init Part CS</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Init Part CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInitPartCS(InitPartCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Metamodel CS</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Metamodel CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetamodelCS(MetamodelCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Metamodel Element CS</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate
	 * the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Metamodel Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetamodelElementCS(MetamodelElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Classifier CS</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Classifier CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierCS(ClassifierCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Classifier Feature CS</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate
	 * the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Classifier Feature CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierFeatureCS(ClassifierFeatureCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Classifier Property CS</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate
	 * the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Classifier Property CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierPropertyCS(ClassifierPropertyCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Multiplicity CS</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Multiplicity CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplicityCS(MultiplicityCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Classifier Operation CS</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate
	 * the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Classifier Operation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierOperationCS(ClassifierOperationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Enumeration CS</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Enumeration CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationCS(EnumerationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Tag CS</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Tag CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTagCS(TagCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Typedef CS</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Typedef CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedefCS(TypedefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Visitable CS</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Visitable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitableCS(VisitableCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Element CS</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementCS(ElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Multiplicity CS</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Multiplicity CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseCST_MultiplicityCS(
			org.eclipse.ocl.examples.xtext.base.baseCST.MultiplicityCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>EObject</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch, but this is
	 * the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // QvtoperationalcsSwitch
