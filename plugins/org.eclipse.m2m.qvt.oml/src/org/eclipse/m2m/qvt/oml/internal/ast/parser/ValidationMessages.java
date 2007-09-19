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
package org.eclipse.m2m.qvt.oml.internal.ast.parser;

import org.eclipse.osgi.util.NLS;

public final class ValidationMessages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.m2m.qvt.oml.internal.ast.parser.messages";//$NON-NLS-1$

	private ValidationMessages() {
		// Do not instantiate
	}

    public static String mappingOperationExpected;
	public static String QvtOperationalParserUtil_inoutParamAssignmentError;
    public static String QvtOperationalVisitorCS_AbstractTypesNotInitialized;
    public static String QvtOperationalVisitorCS_ResolveInMappingNotFound;
    public static String QvtOperationalVisitorCS_ResolveInSeveralMappingsFound;
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
    public static String QvtOperationalVisitorCS_ifExpWithoutElseAssignment;
	public static String readOnlyPropertyModificationError;
	public static String useMapKeywordWarning;
	public static String incorrectCastWarning;
	public static String lateResolveWarning;
	public static String missingTypeError;
	public static String nonModelTypeError;
	public static String abstractTypeError;
	public static String propertyAssignmentExpectedError;
	public static String noPropertyInTypeError;
	public static String ContextParamMustBeInOrInout;
	public static String ContextParamMustBeIn;
	public static String SameParamName;
	public static String ReadOnlyProperty;
	public static String NoLibrary;
	public static String FailedToLoadLibrary;
	public static String MissingMetamodelsRequiredByLibrary;
	public static String ReturnTypeMismatch;
	public static String DuplicateLibraryImport;
	public static String DuplicateMetamodelImport;
	public static String moduleNameMustMatchFileNameError;
	public static String moduleNameMustBeSimpleIdentifierError;	
	public static String wrongPackageError;
	public static String failedToResolveMetamodelError;
	public static String propertyAlreadyExistsInTypeError;
	public static String bodyTypeNotCompatibleWithReturnTypeError;
    public static String notAnLValueError;
    public static String cannotModifyNestedPropertiesError;
	public static String CantAssignToSelf;
	public static String unresolvedNameError;
	public static String inputParameterModificationError;
	public static String UnknownClassifierType;
	public static String invalidPropertyReferenceError;
	public static String objectExpressionExpectedError;
	public static String ConfigPropertyMustHaveType;
	public static String ConfigPropertyTypeUnsupported;
	public static String MappingWithoutResultMustNotHaveBody;
	public static String OutParamsNotSupported;
	public static String mappingGuardNotBooleanError;

	public static String SemanticUtil_0;
	public static String SemanticUtil_3;
	public static String SemanticUtil_5;
	public static String SemanticUtil_8;
	public static String SemanticUtil_11;
	public static String SemanticUtil_13;
	public static String SemanticUtil_15;
	public static String SemanticUtil_17;
	
	public static String Local_properties_are_not_allowed_in_libraries;
	public static String Evaluation_CannotCreateFromString;

    public static String LibOperationAnalyser_ParametersOsReturnTypeNotFound;
    public static String LibOperationAnalyser_OperationParsingError;
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, ValidationMessages.class);
	}
	
}