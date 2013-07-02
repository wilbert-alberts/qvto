/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierFeatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierKind;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.EnumerationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.FeatureKey;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitOp;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelElementCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamDirection;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.Qualifier;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsFactory;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitElementCS;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class QvtoperationalcsFactoryImpl
		extends EFactoryImpl
		implements QvtoperationalcsFactory {

	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static QvtoperationalcsFactory init() {
		try {
			QvtoperationalcsFactory theQvtoperationalcsFactory = (QvtoperationalcsFactory) EPackage.Registry.INSTANCE
				.getEFactory(QvtoperationalcsPackage.eNS_URI);
			if (theQvtoperationalcsFactory != null) {
				return theQvtoperationalcsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QvtoperationalcsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public QvtoperationalcsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case QvtoperationalcsPackage.TOP_LEVEL_CS :
				return createTopLevelCS();
			case QvtoperationalcsPackage.IMPORT_CS :
				return createImportCS();
			case QvtoperationalcsPackage.UNIT_CS :
				return createUnitCS();
			case QvtoperationalcsPackage.UNIT_ELEMENT_CS :
				return createUnitElementCS();
			case QvtoperationalcsPackage.COMPLETE_SIGNATURE_CS :
				return createCompleteSignatureCS();
			case QvtoperationalcsPackage.SIMPLE_SIGNATURE_CS :
				return createSimpleSignatureCS();
			case QvtoperationalcsPackage.PARAM_CS :
				return createParamCS();
			case QvtoperationalcsPackage.INIT_PART_CS :
				return createInitPartCS();
			case QvtoperationalcsPackage.METAMODEL_CS :
				return createMetamodelCS();
			case QvtoperationalcsPackage.METAMODEL_ELEMENT_CS :
				return createMetamodelElementCS();
			case QvtoperationalcsPackage.CLASSIFIER_CS :
				return createClassifierCS();
			case QvtoperationalcsPackage.CLASSIFIER_FEATURE_CS :
				return createClassifierFeatureCS();
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS :
				return createClassifierPropertyCS();
			case QvtoperationalcsPackage.MULTIPLICITY_CS :
				return createMultiplicityCS();
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS :
				return createClassifierOperationCS();
			case QvtoperationalcsPackage.ENUMERATION_CS :
				return createEnumerationCS();
			case QvtoperationalcsPackage.TAG_CS :
				return createTagCS();
			case QvtoperationalcsPackage.TYPEDEF_CS :
				return createTypedefCS();
			default :
				throw new IllegalArgumentException("The class '"
					+ eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case QvtoperationalcsPackage.CLASSIFIER_KIND :
				return createClassifierKindFromString(eDataType, initialValue);
			case QvtoperationalcsPackage.FEATURE_KEY :
				return createFeatureKeyFromString(eDataType, initialValue);
			case QvtoperationalcsPackage.INIT_OP :
				return createInitOpFromString(eDataType, initialValue);
			case QvtoperationalcsPackage.METAMODEL_KIND :
				return createMetamodelKindFromString(eDataType, initialValue);
			case QvtoperationalcsPackage.PARAM_DIRECTION :
				return createParamDirectionFromString(eDataType, initialValue);
			case QvtoperationalcsPackage.QUALIFIER :
				return createQualifierFromString(eDataType, initialValue);
			default :
				throw new IllegalArgumentException("The datatype '"
					+ eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case QvtoperationalcsPackage.CLASSIFIER_KIND :
				return convertClassifierKindToString(eDataType, instanceValue);
			case QvtoperationalcsPackage.FEATURE_KEY :
				return convertFeatureKeyToString(eDataType, instanceValue);
			case QvtoperationalcsPackage.INIT_OP :
				return convertInitOpToString(eDataType, instanceValue);
			case QvtoperationalcsPackage.METAMODEL_KIND :
				return convertMetamodelKindToString(eDataType, instanceValue);
			case QvtoperationalcsPackage.PARAM_DIRECTION :
				return convertParamDirectionToString(eDataType, instanceValue);
			case QvtoperationalcsPackage.QUALIFIER :
				return convertQualifierToString(eDataType, instanceValue);
			default :
				throw new IllegalArgumentException("The datatype '"
					+ eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TopLevelCS createTopLevelCS() {
		TopLevelCSImpl topLevelCS = new TopLevelCSImpl();
		return topLevelCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ImportCS createImportCS() {
		ImportCSImpl importCS = new ImportCSImpl();
		return importCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UnitCS createUnitCS() {
		UnitCSImpl unitCS = new UnitCSImpl();
		return unitCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UnitElementCS createUnitElementCS() {
		UnitElementCSImpl unitElementCS = new UnitElementCSImpl();
		return unitElementCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CompleteSignatureCS createCompleteSignatureCS() {
		CompleteSignatureCSImpl completeSignatureCS = new CompleteSignatureCSImpl();
		return completeSignatureCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SimpleSignatureCS createSimpleSignatureCS() {
		SimpleSignatureCSImpl simpleSignatureCS = new SimpleSignatureCSImpl();
		return simpleSignatureCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ParamCS createParamCS() {
		ParamCSImpl paramCS = new ParamCSImpl();
		return paramCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InitPartCS createInitPartCS() {
		InitPartCSImpl initPartCS = new InitPartCSImpl();
		return initPartCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MetamodelCS createMetamodelCS() {
		MetamodelCSImpl metamodelCS = new MetamodelCSImpl();
		return metamodelCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MetamodelElementCS createMetamodelElementCS() {
		MetamodelElementCSImpl metamodelElementCS = new MetamodelElementCSImpl();
		return metamodelElementCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ClassifierCS createClassifierCS() {
		ClassifierCSImpl classifierCS = new ClassifierCSImpl();
		return classifierCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ClassifierFeatureCS createClassifierFeatureCS() {
		ClassifierFeatureCSImpl classifierFeatureCS = new ClassifierFeatureCSImpl();
		return classifierFeatureCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ClassifierPropertyCS createClassifierPropertyCS() {
		ClassifierPropertyCSImpl classifierPropertyCS = new ClassifierPropertyCSImpl();
		return classifierPropertyCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultiplicityCS createMultiplicityCS() {
		MultiplicityCSImpl multiplicityCS = new MultiplicityCSImpl();
		return multiplicityCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ClassifierOperationCS createClassifierOperationCS() {
		ClassifierOperationCSImpl classifierOperationCS = new ClassifierOperationCSImpl();
		return classifierOperationCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EnumerationCS createEnumerationCS() {
		EnumerationCSImpl enumerationCS = new EnumerationCSImpl();
		return enumerationCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TagCS createTagCS() {
		TagCSImpl tagCS = new TagCSImpl();
		return tagCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TypedefCS createTypedefCS() {
		TypedefCSImpl typedefCS = new TypedefCSImpl();
		return typedefCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ClassifierKind createClassifierKindFromString(EDataType eDataType,
			String initialValue) {
		ClassifierKind result = ClassifierKind.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue
				+ "' is not a valid enumerator of '" + eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertClassifierKindToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null
			? null
			: instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureKey createFeatureKeyFromString(EDataType eDataType,
			String initialValue) {
		FeatureKey result = FeatureKey.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue
				+ "' is not a valid enumerator of '" + eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertFeatureKeyToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null
			? null
			: instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InitOp createInitOpFromString(EDataType eDataType,
			String initialValue) {
		InitOp result = InitOp.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue
				+ "' is not a valid enumerator of '" + eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertInitOpToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null
			? null
			: instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MetamodelKind createMetamodelKindFromString(EDataType eDataType,
			String initialValue) {
		MetamodelKind result = MetamodelKind.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue
				+ "' is not a valid enumerator of '" + eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertMetamodelKindToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null
			? null
			: instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ParamDirection createParamDirectionFromString(EDataType eDataType,
			String initialValue) {
		ParamDirection result = ParamDirection.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue
				+ "' is not a valid enumerator of '" + eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertParamDirectionToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null
			? null
			: instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Qualifier createQualifierFromString(EDataType eDataType,
			String initialValue) {
		Qualifier result = Qualifier.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue
				+ "' is not a valid enumerator of '" + eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertQualifierToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null
			? null
			: instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public QvtoperationalcsPackage getQvtoperationalcsPackage() {
		return (QvtoperationalcsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QvtoperationalcsPackage getPackage() {
		return QvtoperationalcsPackage.eINSTANCE;
	}

} // QvtoperationalcsFactoryImpl
