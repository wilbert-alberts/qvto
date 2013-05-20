/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
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

import org.eclipse.m2m.internal.qvt.oml.NLS;

public final class ValidationMessages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.ast.parser.ValidationMessages";//$NON-NLS-1$

	private ValidationMessages() {
		// Do not instantiate
	}

    public static String AmbiguousModuleReference;
	public static String AmbiguousOperationLookup;
	public static String AmbiguousOperationReference;
	public static String BooleanTypeAssertConditionError;
	public static String DefaultConstructorNotDefinedImplicitUsed;
	public static String DeprecatedElement;
	public static String DeprecatedElementBy;
	public static String DeprecatedImplicitSourceCall_contextualImplicitCall;
	public static String DeprecatedImplicitSourceCall_moduleScopeImplicitCall;
	public static String DeprecatedLibraryImportStatement;
	public static String DeprecatedRenameStatement;
	public static String lateResolveNotUsedInDeferredAssignment;
	public static String LogExpBooleanTypeConditionError;
	public static String LogLevelNumberArgumentError;
	public static String MappingExtension_disjunctingMappingBodyNotExecuted;
	public static String MappingExtension_illegalExtensionKindOnDisjunctingMapping;
	public static String MappingExtension_nonConformantSignatureForMappingExtension;
	public static String mappingOperationExpected;
	public static String MissingMessageLogExpArgumentError;
	public static String QvtOperationalParserUtil_inoutParamAssignmentError;
    public static String QvtOperationalValidationVisitor_CannotDeclareVariables;
	public static String QvtOperationalValidationVisitor_incompatibleArgumentModelType;
	public static String QvtOperationalValidationVisitor_invalidContextualType;
	public static String QvtOperationalValidationVisitor_invalidInstantiatedType;
	public static String QvtOperationalValidationVisitor_MainInLibraryError;
	public static String QvtOperationalValidationVisitor_ParameterlessMainExpected;
	public static String QvtOperationalValidationVisitor_parameterNamedRequired;
	public static String QvtOperationalValidationVisitor_resultParamDirectionMustBeOut;
	public static String QvtOperationalValidationVisitor_unresolvedTransformationSignature;
	public static String QvtOperationalVisitorCS_AbstractTypesNotInitialized;
	public static String QvtOperationalVisitorCS_ambiguousMappingOperationReference;
	public static String QvtOperationalVisitorCS_BadArg_ERROR_;
	public static String QvtOperationalVisitorCS_booleanTypeExpressionExpected;
	public static String QvtOperationalVisitorCS_canNotInstantiateAbstractType;
	public static String QvtOperationalVisitorCS_canNotModifyINParameter;
	public static String QvtOperationalVisitorCS_ContextualPropertyTypeIsNotClass;
	public static String QvtOperationalVisitorCS_ContextualPropertyTypeIsMissed;
	public static String QvtOperationalVisitorCS_duplicateMappingRereferenceInExtensionKind;
	public static String QvtOperationalVisitorCS_duplicateQualifierOnOperation;
	public static String QvtOperationalVisitorCS_instatiatedTypeDoesNotConformToReferredType;
    public static String QvtOperationalVisitorCS_ResolveInMappingNotFound;    
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
    public static String QvtOperationalVisitorCS_entryPointShouldBeDeclOnce;
    public static String QvtOperationalVisitorCS_FeatureNotFoundForType;
    public static String QvtOperationalVisitorCS_ifExpWithoutElseAssignment;
    public static String QvtOperationalVisitorCS_ifExpIncomplete;
    public static String QvtOperationalVisitorCS_ifExpNonBooleanCond;
    public static String QvtOperationalVisitorCS_incompatibleTransfSignature;
    public static String QvtOperationalVisitorCS_LibrarySignatureErrorDirectionKindSpecified;
    public static String QvtOperationalVisitorCS_LibrarySignatureErrorDuplicateModelType;
    public static String QvtOperationalVisitorCS_LibrarySignatureErrorModelExtentSpecified;
    public static String QvtOperationalVisitorCS_LibrarySignatureErrorParameterNameSpecified;
    public static String QvtOperationalVisitorCS_mapKeywordNotUsed;
	public static String QvtOperationalVisitorCS_OperationNotFound_ERROR_;
	public static String QvtOperationalVisitorCS_OperationNotFoundForCollectionAndItsElement;
	public static String QvtOperationalVisitorCS_resultParamNameDirectionNotAllowed;
	public static String QvtOperationalVisitorCS_resultParamNameNotAllowed;
	public static String QvtOperationalVisitorCS_SeeErrorLogForDetails;
	public static String QvtOperationalVisitorCS_unsupportedQualifierOnOperation;
    public static String QvtOperationalVisitorCS_WrongImperativeIteratorConditionType;
    public static String QvtOperationalVisitorCS_incrementalAssignmentResultNotAllowed;
    public static String QvtOperationalVisitorCS_assignmentResultNotAllowed;
    
	public static String readOnlyPropertyModificationError;
	public static String StringTypeMessageLogArgumentError;
	public static String UknownSeverityKindError;
	public static String UnresolvedConstructor;
	public static String UnsupportedElement;
	public static String UnsupportedLogExpArgumentError;
	
	public static String incorrectCastWarning;
	
	
	public static String nonModelTypeError;
	
	public static String noPropertyInTypeError;
	public static String ContextParamMustBeInOrInout;
	public static String ContextParamMustBeIn;
	public static String SameParamName;
	public static String ReadOnlyProperty;
	public static String NoImplicitSourceForQualifiedCall;
	public static String NoLibrary;
	public static String FailedToLoadUnit;
	
	public static String ReturnTypeMismatch;
	public static String DuplicateMetamodelImport;
	public static String moduleNameMustBeSimpleIdentifierError;	
	
	public static String failedToResolveMetamodelError;
	public static String propertyAlreadyExistsInTypeError;
	public static String bodyTypeNotCompatibleWithReturnTypeError;
    public static String notAnLValueError;
	public static String CantAssignToSelf;
	public static String CantAssignToThis;	
	public static String unresolvedNameError;
	public static String inputParameterModificationError;
	public static String UnknownClassifierType;
	public static String UnresolvedModuleReference;
	public static String invalidPropertyReferenceError;
	public static String ConfigPropertyMustHaveType;
	public static String ConfigPropertyTypeUnsupported;

	public static String OutParamsNotSupported;
	public static String OutParamWithoutExtent;
	public static String mappingGuardNotBooleanError;
	
	public static String ContextlessConstructor;
	public static String ConstructorNameMismatch;

	public static String SemanticUtil_0;
	public static String SemanticUtil_3;
	public static String SemanticUtil_5;
	public static String SemanticUtil_8;
	
	public static String NameAlreadyDefinedError;
	public static String TypeMismatchError;
	
	public static String ModulePropertyAlreadyDefined;
	public static String IntermediatePropertiesInitNotSupported;
	public static String IntermediatePropertyAlreadyDefined;
	public static String IntermediatePropertyNotAllowed;
	public static String IntermediateClassifierNotAllowed;
	public static String DuplicateProperty;
	public static String DuplicateClassifier;
	public static String InvalidClassifierForExtend;
	public static String CycleInIntermHierarchy;
	public static String HidingProperty;
	public static String HidingStdlibOperationDiscouraged;

    public static String LibOperationAnalyser_ParametersOsReturnTypeNotFound;
    public static String LibOperationAnalyser_OperationParsingError;
    public static String ResolveExpMustHaveASource;
    public static String directCallToAbstractMappingDisallowed;
    public static String returnUsedOutsideOperationBody;
    public static String useReturnExpForOperationResult;
    public static String typeMismatchError;
    public static String missingReturnValueError;
    public static String returnNotAllowedInMappingYet;
    
    public static String IntermClassifier_duplicatedStereotypeQualifier;
    public static String IntermClassifier_unapplicableStereotypeQualifier;
    public static String IntermClassifier_unknownStereotypeQualifier;
    public static String IntermClassifier_referenceOnlyFeatureKey;
    public static String IntermClassifier_duplicatedFeatureKey;
    public static String IntermClassifier_unsupportedFeatureKey;
    public static String IntermClassifier_multiplicityInvalidLowerBound;
    public static String IntermClassifier_multiplicityInvalidRange;
    public static String IntermClassifier_multiplicityEmptyRange;
    public static String IntermClassifier_oppositeOnlyForReferences;
    public static String IntermClassifier_invalideOppositeType;
    public static String IntermClassifier_invalideOppositeName;
    public static String IntermClassifier_incompatibleFeatureKeys;
    
    public static String OperationIsUndefined;
	public static String OperationOverrideWithInvalidReturnType;
    
    public static String BreakContinue_InvalidExpressionOwner;
    public static String BreakContinue_InvalidExpressionUsage;
    public static String EntryOp_DepricatedParamDecl;
    public static String EntryOp_DisallowedDeclAsMapping;
    
    public static String TupleTypeMismatch;
    public static String TupleFieldNumMismatch;
    public static String TupleFieldNotFound;
    public static String TypeMismatchNoCommonType;
    
	public static String AtPreInPostcondition_ERROR_;
	public static String NonStaticOperation_ERROR_;
	public static String NonStaticAttribute_ERROR_;
	public static String NullOperation_ERROR_;
	public static String NullSourceOperation_ERROR_;
	public static String OCLIsNewInPostcondition_ERROR_;
	public static String NonQueryOperation_ERROR_;
	public static String IllegalOpcode_ERROR_;
	public static String TypeConformanceOperation_ERROR_;
	public static String NonStd_Operation_;
    
	static {
		NLS.initializeMessages(BUNDLE_NAME, ValidationMessages.class);
	}
	
}