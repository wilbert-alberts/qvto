/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 * 
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage
 * @generated
 */
public class QvtoperationalcsAdapterFactory
		extends AdapterFactoryImpl {

	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static QvtoperationalcsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public QvtoperationalcsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = QvtoperationalcsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc --> This implementation returns <code>true</code> if
	 * the object is either the model's package or is an instance object of the
	 * model. <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected QvtoperationalcsSwitch<Adapter> modelSwitch = new QvtoperationalcsSwitch<Adapter>() {

		@Override
		public Adapter caseTopLevelCS(TopLevelCS object) {
			return createTopLevelCSAdapter();
		}

		@Override
		public Adapter caseImportCS(ImportCS object) {
			return createImportCSAdapter();
		}

		@Override
		public Adapter caseUnitCS(UnitCS object) {
			return createUnitCSAdapter();
		}

		@Override
		public Adapter caseUnitElementCS(UnitElementCS object) {
			return createUnitElementCSAdapter();
		}

		@Override
		public Adapter caseCompleteSignatureCS(CompleteSignatureCS object) {
			return createCompleteSignatureCSAdapter();
		}

		@Override
		public Adapter caseSimpleSignatureCS(SimpleSignatureCS object) {
			return createSimpleSignatureCSAdapter();
		}

		@Override
		public Adapter caseParamCS(ParamCS object) {
			return createParamCSAdapter();
		}

		@Override
		public Adapter caseInitPartCS(InitPartCS object) {
			return createInitPartCSAdapter();
		}

		@Override
		public Adapter caseMetamodelCS(MetamodelCS object) {
			return createMetamodelCSAdapter();
		}

		@Override
		public Adapter caseMetamodelElementCS(MetamodelElementCS object) {
			return createMetamodelElementCSAdapter();
		}

		@Override
		public Adapter caseClassifierCS(ClassifierCS object) {
			return createClassifierCSAdapter();
		}

		@Override
		public Adapter caseClassifierFeatureCS(ClassifierFeatureCS object) {
			return createClassifierFeatureCSAdapter();
		}

		@Override
		public Adapter caseClassifierPropertyCS(ClassifierPropertyCS object) {
			return createClassifierPropertyCSAdapter();
		}

		@Override
		public Adapter caseMultiplicityCS(MultiplicityCS object) {
			return createMultiplicityCSAdapter();
		}

		@Override
		public Adapter caseClassifierOperationCS(ClassifierOperationCS object) {
			return createClassifierOperationCSAdapter();
		}

		@Override
		public Adapter caseEnumerationCS(EnumerationCS object) {
			return createEnumerationCSAdapter();
		}

		@Override
		public Adapter caseTagCS(TagCS object) {
			return createTagCSAdapter();
		}

		@Override
		public Adapter caseTypedefCS(TypedefCS object) {
			return createTypedefCSAdapter();
		}

		@Override
		public Adapter caseVisitableCS(VisitableCS object) {
			return createVisitableCSAdapter();
		}

		@Override
		public Adapter caseElementCS(ElementCS object) {
			return createElementCSAdapter();
		}

		@Override
		public Adapter caseBaseCST_MultiplicityCS(
				org.eclipse.ocl.examples.xtext.base.baseCST.MultiplicityCS object) {
			return createBaseCST_MultiplicityCSAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param target
	 *            the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS
	 * <em>Top Level CS</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS
	 * @generated
	 */
	public Adapter createTopLevelCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS
	 * <em>Import CS</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a
	 * case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS
	 * @generated
	 */
	public Adapter createImportCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS
	 * <em>Unit CS</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a
	 * case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS
	 * @generated
	 */
	public Adapter createUnitCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitElementCS
	 * <em>Unit Element CS</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitElementCS
	 * @generated
	 */
	public Adapter createUnitElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS
	 * <em>Complete Signature CS</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS
	 * @generated
	 */
	public Adapter createCompleteSignatureCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS
	 * <em>Simple Signature CS</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS
	 * @generated
	 */
	public Adapter createSimpleSignatureCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS
	 * <em>Param CS</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a
	 * case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS
	 * @generated
	 */
	public Adapter createParamCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS
	 * <em>Init Part CS</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS
	 * @generated
	 */
	public Adapter createInitPartCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS
	 * <em>Metamodel CS</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS
	 * @generated
	 */
	public Adapter createMetamodelCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelElementCS
	 * <em>Metamodel Element CS</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelElementCS
	 * @generated
	 */
	public Adapter createMetamodelElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS
	 * <em>Classifier CS</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS
	 * @generated
	 */
	public Adapter createClassifierCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierFeatureCS
	 * <em>Classifier Feature CS</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierFeatureCS
	 * @generated
	 */
	public Adapter createClassifierFeatureCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS
	 * <em>Classifier Property CS</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS
	 * @generated
	 */
	public Adapter createClassifierPropertyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityCS
	 * <em>Multiplicity CS</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityCS
	 * @generated
	 */
	public Adapter createMultiplicityCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS
	 * <em>Classifier Operation CS</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS
	 * @generated
	 */
	public Adapter createClassifierOperationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.EnumerationCS
	 * <em>Enumeration CS</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.EnumerationCS
	 * @generated
	 */
	public Adapter createEnumerationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS
	 * <em>Tag CS</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a
	 * case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS
	 * @generated
	 */
	public Adapter createTagCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS
	 * <em>Typedef CS</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS
	 * @generated
	 */
	public Adapter createTypedefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.ocl.examples.xtext.base.util.VisitableCS
	 * <em>Visitable CS</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.util.VisitableCS
	 * @generated
	 */
	public Adapter createVisitableCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS
	 * <em>Element CS</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS
	 * @generated
	 */
	public Adapter createElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.ocl.examples.xtext.base.baseCST.MultiplicityCS
	 * <em>Multiplicity CS</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.MultiplicityCS
	 * @generated
	 */
	public Adapter createBaseCST_MultiplicityCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case. <!-- begin-user-doc --> This
	 * default implementation returns null. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // QvtoperationalcsAdapterFactory
