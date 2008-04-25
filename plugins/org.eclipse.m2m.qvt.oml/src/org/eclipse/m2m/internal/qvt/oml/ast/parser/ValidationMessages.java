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
package org.eclipse.m2m.internal.qvt.oml.ast.parser;

import org.eclipse.osgi.util.NLS;

public final class ValidationMessages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.ast.parser.ValidationMessages";//$NON-NLS-1$

	private ValidationMessages() {
		// Do not instantiate
	}

    public static String BooleanTypeAssertConditionError;
	public static String DeprecatedImplicitSourceCall_contextualImplicitCall;
	public static String DeprecatedImplicitSourceCall_moduleScopeImplicitCall;
	public static String lateResolveNotUsedInDeferredAssignment;
	public static String LogExpBooleanTypeConditionError;
	public static String LogLevelNumberArgumentError;
	public static String MappingExtension_disjunctingMappingBodyNotExecuted;
	public static String MappingExtension_illegalExtensionKindOnDisjunctingMapping;
	public static String MappingExtension_nonConformantSignatureForMappingExtension;
	public static String mappingOperationExpected;
	public static String MissingMessageLogExpArgumentError;
	public static String QvtOperationalParserUtil_inoutParamAssignmentError;
    public static String QvtOperationalValidationVisitor_invalidContextualType;
	public static String QvtOperationalValidationVisitor_parameterNamedRequired;
	public static String QvtOperationalValidationVisitor_resultParamDirectionMustBeOut;
	public static String QvtOperationalVisitorCS_AbstractTypesNotInitialized;
	public static String QvtOperationalVisitorCS_ambiguousMappingOperationReference;
	public static String QvtOperationalVisitorCS_booleanTypeExpressionExpected;
	public static String QvtOperationalVisitorCS_canNotInstantiateAbstractType;
	public static String QvtOperationalVisitorCS_canNotModifyINParameter;
	public static String QvtOperationalVisitorCS_deprecatedWhileExp;
	public static String QvtOperationalVisitorCS_duplicateMappingRereferenceInExtensionKind;
	public static String QvtOperationalVisitorCS_duplicateQualifierOnOperation;
	public static String QvtOperationalVisitorCS_instatiatedTypeDoesNotConformToReferredType;
	public static String QvtOperationalVisitorCS_missingObjectExpInPopulationSection;
    public static String QvtOperationalVisitorCS_ResolveInMappingNotFound;
    public static String QvtOperationalVisitorCS_ResolveInSeveralMappingsFound;
	public static String QvtOperationalVisitorCS_unresolvedMappingOperationReference;
    public static String QvtOperationalVisitorCS_unsupportedMetamodelComplianceKind;
    public static String QvtOperationalVisitorCS_metamodelPackageRefInconsistent;
    public static String QvtOperationalVisitorCS_metamodelConditionsNotSupported;
    public static String QvtOperationalVisitorCS_metamodelSinglePackageRefSupported;
    public static String QvtOperationalVisitorCS_metamodelNameAmbiguous;
    public static String QvtOperationalVisitorCS_metamodelAlreadyUsed;
    public static String QvtOperationalVisitorCS_modeltypeDeprecatedSyntax;
    public static String QvtOperationalVisitorCS_modeltypeAlreadyDefined;
    public static String QvtOperationalVisitorCS_transfQualifiersNotSupported;
    public static String QvtOperationalVisitorCS_transfRefineNotSupported;
    public static String QvtOperationalVisitorCS_transfUsagesNotSupported;
    public static String QvtOperationalVisitorCS_transfParamWrongType;
    public static String QvtOperationalVisitorCS_extentWrongName;
    public static String QvtOperationalVisitorCS_extentDuplicateUse;
    public static String QvtOperationalVisitorCS_extentDirectionMismatch;
    public static String QvtOperationalVisitorCS_extentFailToInfer;
    public static String QvtOperationalVisitorCS_oclParseNPE;
    public static String QvtOperationalVisitorCS_entryPointReturnDeprecated;
    public static String QvtOperationalVisitorCS_entryPointShouldBeDeclOnce;
    public static String QvtOperationalVisitorCS_FeatureNotFoundForType;
    public static String QvtOperationalVisitorCS_ifExpWithoutElseAssignment;
    public static String QvtOperationalVisitorCS_incompatibleTransfSignature;
    public static String QvtOperationalVisitorCS_mapKeywordNotUsed;
	public static String QvtOperationalVisitorCS_resultParamNameDirectionNotAllowed;
	public static String QvtOperationalVisitorCS_resultParamNameNotAllowed;
	public static String QvtOperationalVisitorCS_unsupportedQualifierOnOperation;
	public static String QvtOperationalVisitorCS_useImplicitObjectExpOrPopulationSection;
	public static String QvtOperationalVisitorCS_userVariableForReferredObject;
    public static String QvtOperationalVisitorCS_WrongImperativeIteratorConditionType;
    
	public static String readOnlyPropertyModificationError;
	public static String StringTypeMessageLogArgumentError;
	public static String UknownSeverityKindError;
	public static String UnsupportedLogExpArgumentError;
	
	public static String incorrectCastWarning;
	
	
	public static String nonModelTypeError;
	
	public static String propertyAssignmentExpectedError;
	public static String noPropertyInTypeError;
	public static String ContextParamMustBeInOrInout;
	public static String ContextParamMustBeIn;
	public static String SameParamName;
	public static String ReadOnlyProperty;
	public static String NoLibrary;
	public static String FailedToLoadLibrary;
	
	public static String ReturnTypeMismatch;
	public static String DuplicateLibraryImport;
	public static String DuplicateMetamodelImport;
	public static String moduleNameMustMatchFileName;
	public static String moduleNameMustBeSimpleIdentifierError;	
	
	public static String failedToResolveMetamodelError;
	public static String propertyAlreadyExistsInTypeError;
	public static String bodyTypeNotCompatibleWithReturnTypeError;
    public static String notAnLValueError;
    public static String cannotModifyNestedPropertiesError;
	public static String CantAssignToSelf;
	public static String CantAssignToThis;	
	public static String unresolvedNameError;
	public static String inputParameterModificationError;
	public static String UnknownClassifierType;
	public static String invalidPropertyReferenceError;
	public static String objectExpressionExpectedError;
	public static String ConfigPropertyMustHaveType;
	public static String ConfigPropertyTypeUnsupported;

	public static String OutParamsNotSupported;
	public static String OutParamWithoutExtent;
	public static String mappingGuardNotBooleanError;

	public static String SemanticUtil_0;
	public static String SemanticUtil_3;
	public static String SemanticUtil_5;
	public static String SemanticUtil_8;
	
	public static String SemanticUtil_13;
	public static String SemanticUtil_15;
	public static String SemanticUtil_17;

    public static String LibOperationAnalyser_ParametersOsReturnTypeNotFound;
    public static String LibOperationAnalyser_OperationParsingError;
    public static String ResolveExpMustHaveASource;
    public static String directCallToAbstractMappingDisallowed;
    public static String returnUsedOutsideOperationBody;
    public static String useReturnExpForOperationResult;
    public static String typeMismatchError;
    public static String missingReturnValueError;
    public static String returnNotAllowedInMappingYet;
    
	static {
		NLS.initializeMessages(BUNDLE_NAME, ValidationMessages.class);
	}
	
}