/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.internal.cst.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.m2m.qvt.oml.internal.cst.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CSTFactoryImpl extends EFactoryImpl implements CSTFactory {
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

    /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CSTFactory init() {
		try {
			CSTFactory theCSTFactory = (CSTFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/QVT2/1.0.0/Operational/cst"); //$NON-NLS-1$ 
			if (theCSTFactory != null) {
				return theCSTFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CSTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSTFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CSTPackage.MAPPING_MODULE_CS: return createMappingModuleCS();
			case CSTPackage.LIBRARY_CS: return createLibraryCS();
			case CSTPackage.MODULE_IMPORT_CS: return createModuleImportCS();
			case CSTPackage.LIBRARY_IMPORT_CS: return createLibraryImportCS();
			case CSTPackage.RENAME_CS: return createRenameCS();
			case CSTPackage.CONFIG_PROPERTY_CS: return createConfigPropertyCS();
			case CSTPackage.LOCAL_PROPERTY_CS: return createLocalPropertyCS();
			case CSTPackage.MAPPING_DECLARATION_CS: return createMappingDeclarationCS();
			case CSTPackage.PARAMETER_DECLARATION_CS: return createParameterDeclarationCS();
			case CSTPackage.MAPPING_RULE_CS: return createMappingRuleCS();
			case CSTPackage.MAPPING_QUERY_CS: return createMappingQueryCS();
			case CSTPackage.MAPPING_INIT_CS: return createMappingInitCS();
			case CSTPackage.MAPPING_END_CS: return createMappingEndCS();
			case CSTPackage.ASSIGN_STATEMENT_CS: return createAssignStatementCS();
			case CSTPackage.EXPRESSION_STATEMENT_CS: return createExpressionStatementCS();
			case CSTPackage.VARIABLE_INITIALIZATION_CS: return createVariableInitializationCS();
			case CSTPackage.MAPPING_BODY_CS: return createMappingBodyCS();
			case CSTPackage.OUT_EXP_CS: return createOutExpCS();
			case CSTPackage.PATTERN_PROPERTY_EXP_CS: return createPatternPropertyExpCS();
			case CSTPackage.MAPPING_CALL_EXP_CS: return createMappingCallExpCS();
			case CSTPackage.WHILE_EXP_CS: return createWhileExpCS();
			case CSTPackage.DIRECTION_KIND_CS: return createDirectionKindCS();
			case CSTPackage.RESOLVE_EXP_CS: return createResolveExpCS();
			case CSTPackage.RESOLVE_IN_EXP_CS: return createResolveInExpCS();
			case CSTPackage.MODEL_TYPE_CS: return createModelTypeCS();
			case CSTPackage.PACKAGE_REF_CS: return createPackageRefCS();
			case CSTPackage.TRANSFORMATION_HEADER_CS: return createTransformationHeaderCS();
			case CSTPackage.MODULE_KIND_CS: return createModuleKindCS();
			case CSTPackage.MODULE_REF_CS: return createModuleRefCS();
			case CSTPackage.MODULE_USAGE_CS: return createModuleUsageCS();
			case CSTPackage.TRANSFORMATION_REFINE_CS: return createTransformationRefineCS();
			case CSTPackage.TYPE_SPEC_CS: return createTypeSpecCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CSTPackage.DIRECTION_KIND_ENUM:
				return createDirectionKindEnumFromString(eDataType, initialValue);
			case CSTPackage.MODULE_KIND_ENUM:
				return createModuleKindEnumFromString(eDataType, initialValue);
			case CSTPackage.IMPORT_KIND_ENUM:
				return createImportKindEnumFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CSTPackage.DIRECTION_KIND_ENUM:
				return convertDirectionKindEnumToString(eDataType, instanceValue);
			case CSTPackage.MODULE_KIND_ENUM:
				return convertModuleKindEnumToString(eDataType, instanceValue);
			case CSTPackage.IMPORT_KIND_ENUM:
				return convertImportKindEnumToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingModuleCS createMappingModuleCS() {
		MappingModuleCSImpl mappingModuleCS = new MappingModuleCSImpl();
		return mappingModuleCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryCS createLibraryCS() {
		LibraryCSImpl libraryCS = new LibraryCSImpl();
		return libraryCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleImportCS createModuleImportCS() {
		ModuleImportCSImpl moduleImportCS = new ModuleImportCSImpl();
		return moduleImportCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryImportCS createLibraryImportCS() {
		LibraryImportCSImpl libraryImportCS = new LibraryImportCSImpl();
		return libraryImportCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RenameCS createRenameCS() {
		RenameCSImpl renameCS = new RenameCSImpl();
		return renameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigPropertyCS createConfigPropertyCS() {
		ConfigPropertyCSImpl configPropertyCS = new ConfigPropertyCSImpl();
		return configPropertyCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalPropertyCS createLocalPropertyCS() {
		LocalPropertyCSImpl localPropertyCS = new LocalPropertyCSImpl();
		return localPropertyCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingDeclarationCS createMappingDeclarationCS() {
		MappingDeclarationCSImpl mappingDeclarationCS = new MappingDeclarationCSImpl();
		return mappingDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDeclarationCS createParameterDeclarationCS() {
		ParameterDeclarationCSImpl parameterDeclarationCS = new ParameterDeclarationCSImpl();
		return parameterDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingRuleCS createMappingRuleCS() {
		MappingRuleCSImpl mappingRuleCS = new MappingRuleCSImpl();
		return mappingRuleCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingQueryCS createMappingQueryCS() {
		MappingQueryCSImpl mappingQueryCS = new MappingQueryCSImpl();
		return mappingQueryCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingInitCS createMappingInitCS() {
		MappingInitCSImpl mappingInitCS = new MappingInitCSImpl();
		return mappingInitCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingEndCS createMappingEndCS() {
		MappingEndCSImpl mappingEndCS = new MappingEndCSImpl();
		return mappingEndCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignStatementCS createAssignStatementCS() {
		AssignStatementCSImpl assignStatementCS = new AssignStatementCSImpl();
		return assignStatementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionStatementCS createExpressionStatementCS() {
		ExpressionStatementCSImpl expressionStatementCS = new ExpressionStatementCSImpl();
		return expressionStatementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableInitializationCS createVariableInitializationCS() {
		VariableInitializationCSImpl variableInitializationCS = new VariableInitializationCSImpl();
		return variableInitializationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingBodyCS createMappingBodyCS() {
		MappingBodyCSImpl mappingBodyCS = new MappingBodyCSImpl();
		return mappingBodyCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutExpCS createOutExpCS() {
		OutExpCSImpl outExpCS = new OutExpCSImpl();
		return outExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternPropertyExpCS createPatternPropertyExpCS() {
		PatternPropertyExpCSImpl patternPropertyExpCS = new PatternPropertyExpCSImpl();
		return patternPropertyExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingCallExpCS createMappingCallExpCS() {
		MappingCallExpCSImpl mappingCallExpCS = new MappingCallExpCSImpl();
		return mappingCallExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhileExpCS createWhileExpCS() {
		WhileExpCSImpl whileExpCS = new WhileExpCSImpl();
		return whileExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionKindCS createDirectionKindCS() {
		DirectionKindCSImpl directionKindCS = new DirectionKindCSImpl();
		return directionKindCS;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ResolveExpCS createResolveExpCS() {
		ResolveExpCSImpl resolveExpCS = new ResolveExpCSImpl();
		return resolveExpCS;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ResolveInExpCS createResolveInExpCS() {
		ResolveInExpCSImpl resolveInExpCS = new ResolveInExpCSImpl();
		return resolveInExpCS;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelTypeCS createModelTypeCS() {
		ModelTypeCSImpl modelTypeCS = new ModelTypeCSImpl();
		return modelTypeCS;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageRefCS createPackageRefCS() {
		PackageRefCSImpl packageRefCS = new PackageRefCSImpl();
		return packageRefCS;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationHeaderCS createTransformationHeaderCS() {
		TransformationHeaderCSImpl transformationHeaderCS = new TransformationHeaderCSImpl();
		return transformationHeaderCS;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleKindCS createModuleKindCS() {
		ModuleKindCSImpl moduleKindCS = new ModuleKindCSImpl();
		return moduleKindCS;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleRefCS createModuleRefCS() {
		ModuleRefCSImpl moduleRefCS = new ModuleRefCSImpl();
		return moduleRefCS;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleUsageCS createModuleUsageCS() {
		ModuleUsageCSImpl moduleUsageCS = new ModuleUsageCSImpl();
		return moduleUsageCS;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationRefineCS createTransformationRefineCS() {
		TransformationRefineCSImpl transformationRefineCS = new TransformationRefineCSImpl();
		return transformationRefineCS;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSpecCS createTypeSpecCS() {
		TypeSpecCSImpl typeSpecCS = new TypeSpecCSImpl();
		return typeSpecCS;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionKindEnum createDirectionKindEnumFromString(EDataType eDataType, String initialValue) {
		DirectionKindEnum result = DirectionKindEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDirectionKindEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleKindEnum createModuleKindEnumFromString(EDataType eDataType, String initialValue) {
		ModuleKindEnum result = ModuleKindEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertModuleKindEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportKindEnum createImportKindEnumFromString(EDataType eDataType, String initialValue) {
		ImportKindEnum result = ImportKindEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertImportKindEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSTPackage getCSTPackage() {
		return (CSTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CSTPackage getPackage() {
		return CSTPackage.eINSTANCE;
	}

} //CSTFactoryImpl
