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
package org.eclipse.m2m.qvt.oml.internal.cst.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.m2m.qvt.oml.internal.cst.*;

import org.eclipse.ocl.internal.cst.CSTNode;
import org.eclipse.ocl.internal.cst.CallExpCS;
import org.eclipse.ocl.internal.cst.FeatureCallExpCS;
import org.eclipse.ocl.internal.cst.OCLExpressionCS;
import org.eclipse.ocl.internal.cst.OperationCallExpCS;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage
 * @generated
 */
public class CSTSwitch<T> {
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$
    /**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CSTPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSTSwitch() {
		if (modelPackage == null) {
			modelPackage = CSTPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CSTPackage.MAPPING_MODULE_CS: {
				MappingModuleCS mappingModuleCS = (MappingModuleCS)theEObject;
				T result = caseMappingModuleCS(mappingModuleCS);
				if (result == null) result = caseCSTNode(mappingModuleCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.LIBRARY_CS: {
				LibraryCS libraryCS = (LibraryCS)theEObject;
				T result = caseLibraryCS(libraryCS);
				if (result == null) result = caseMappingModuleCS(libraryCS);
				if (result == null) result = caseCSTNode(libraryCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.IMPORT_CS: {
				ImportCS importCS = (ImportCS)theEObject;
				T result = caseImportCS(importCS);
				if (result == null) result = caseCSTNode(importCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MODULE_IMPORT_CS: {
				ModuleImportCS moduleImportCS = (ModuleImportCS)theEObject;
				T result = caseModuleImportCS(moduleImportCS);
				if (result == null) result = caseImportCS(moduleImportCS);
				if (result == null) result = caseCSTNode(moduleImportCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.LIBRARY_IMPORT_CS: {
				LibraryImportCS libraryImportCS = (LibraryImportCS)theEObject;
				T result = caseLibraryImportCS(libraryImportCS);
				if (result == null) result = caseImportCS(libraryImportCS);
				if (result == null) result = caseCSTNode(libraryImportCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.RENAME_CS: {
				RenameCS renameCS = (RenameCS)theEObject;
				T result = caseRenameCS(renameCS);
				if (result == null) result = caseCSTNode(renameCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MODULE_PROPERTY_CS: {
				ModulePropertyCS modulePropertyCS = (ModulePropertyCS)theEObject;
				T result = caseModulePropertyCS(modulePropertyCS);
				if (result == null) result = caseCSTNode(modulePropertyCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.CONFIG_PROPERTY_CS: {
				ConfigPropertyCS configPropertyCS = (ConfigPropertyCS)theEObject;
				T result = caseConfigPropertyCS(configPropertyCS);
				if (result == null) result = caseModulePropertyCS(configPropertyCS);
				if (result == null) result = caseCSTNode(configPropertyCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.LOCAL_PROPERTY_CS: {
				LocalPropertyCS localPropertyCS = (LocalPropertyCS)theEObject;
				T result = caseLocalPropertyCS(localPropertyCS);
				if (result == null) result = caseModulePropertyCS(localPropertyCS);
				if (result == null) result = caseCSTNode(localPropertyCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_DECLARATION_CS: {
				MappingDeclarationCS mappingDeclarationCS = (MappingDeclarationCS)theEObject;
				T result = caseMappingDeclarationCS(mappingDeclarationCS);
				if (result == null) result = caseCSTNode(mappingDeclarationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.PARAMETER_DECLARATION_CS: {
				ParameterDeclarationCS parameterDeclarationCS = (ParameterDeclarationCS)theEObject;
				T result = caseParameterDeclarationCS(parameterDeclarationCS);
				if (result == null) result = caseCSTNode(parameterDeclarationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_METHOD_CS: {
				MappingMethodCS mappingMethodCS = (MappingMethodCS)theEObject;
				T result = caseMappingMethodCS(mappingMethodCS);
				if (result == null) result = caseCSTNode(mappingMethodCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_RULE_CS: {
				MappingRuleCS mappingRuleCS = (MappingRuleCS)theEObject;
				T result = caseMappingRuleCS(mappingRuleCS);
				if (result == null) result = caseMappingMethodCS(mappingRuleCS);
				if (result == null) result = caseCSTNode(mappingRuleCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_QUERY_CS: {
				MappingQueryCS mappingQueryCS = (MappingQueryCS)theEObject;
				T result = caseMappingQueryCS(mappingQueryCS);
				if (result == null) result = caseMappingMethodCS(mappingQueryCS);
				if (result == null) result = caseCSTNode(mappingQueryCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_SECTION_CS: {
				MappingSectionCS mappingSectionCS = (MappingSectionCS)theEObject;
				T result = caseMappingSectionCS(mappingSectionCS);
				if (result == null) result = caseCSTNode(mappingSectionCS);
				if (result == null) result = caseElementWithBody(mappingSectionCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_INIT_CS: {
				MappingInitCS mappingInitCS = (MappingInitCS)theEObject;
				T result = caseMappingInitCS(mappingInitCS);
				if (result == null) result = caseMappingSectionCS(mappingInitCS);
				if (result == null) result = caseCSTNode(mappingInitCS);
				if (result == null) result = caseElementWithBody(mappingInitCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_END_CS: {
				MappingEndCS mappingEndCS = (MappingEndCS)theEObject;
				T result = caseMappingEndCS(mappingEndCS);
				if (result == null) result = caseMappingSectionCS(mappingEndCS);
				if (result == null) result = caseCSTNode(mappingEndCS);
				if (result == null) result = caseElementWithBody(mappingEndCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.STATEMENT_CS: {
				StatementCS statementCS = (StatementCS)theEObject;
				T result = caseStatementCS(statementCS);
				if (result == null) result = caseOCLExpressionCS(statementCS);
				if (result == null) result = caseCSTNode(statementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.ASSIGN_STATEMENT_CS: {
				AssignStatementCS assignStatementCS = (AssignStatementCS)theEObject;
				T result = caseAssignStatementCS(assignStatementCS);
				if (result == null) result = caseStatementCS(assignStatementCS);
				if (result == null) result = caseOCLExpressionCS(assignStatementCS);
				if (result == null) result = caseCSTNode(assignStatementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.EXPRESSION_STATEMENT_CS: {
				ExpressionStatementCS expressionStatementCS = (ExpressionStatementCS)theEObject;
				T result = caseExpressionStatementCS(expressionStatementCS);
				if (result == null) result = caseStatementCS(expressionStatementCS);
				if (result == null) result = caseOCLExpressionCS(expressionStatementCS);
				if (result == null) result = caseCSTNode(expressionStatementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.VARIABLE_INITIALIZATION_CS: {
				VariableInitializationCS variableInitializationCS = (VariableInitializationCS)theEObject;
				T result = caseVariableInitializationCS(variableInitializationCS);
				if (result == null) result = caseStatementCS(variableInitializationCS);
				if (result == null) result = caseOCLExpressionCS(variableInitializationCS);
				if (result == null) result = caseCSTNode(variableInitializationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_BODY_CS: {
				MappingBodyCS mappingBodyCS = (MappingBodyCS)theEObject;
				T result = caseMappingBodyCS(mappingBodyCS);
				if (result == null) result = caseOCLExpressionCS(mappingBodyCS);
				if (result == null) result = caseCSTNode(mappingBodyCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.OUT_EXP_CS: {
				OutExpCS outExpCS = (OutExpCS)theEObject;
				T result = caseOutExpCS(outExpCS);
				if (result == null) result = caseOCLExpressionCS(outExpCS);
				if (result == null) result = caseElementWithBody(outExpCS);
				if (result == null) result = caseCSTNode(outExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.PATTERN_PROPERTY_EXP_CS: {
				PatternPropertyExpCS patternPropertyExpCS = (PatternPropertyExpCS)theEObject;
				T result = casePatternPropertyExpCS(patternPropertyExpCS);
				if (result == null) result = caseOCLExpressionCS(patternPropertyExpCS);
				if (result == null) result = caseCSTNode(patternPropertyExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MAPPING_CALL_EXP_CS: {
				MappingCallExpCS mappingCallExpCS = (MappingCallExpCS)theEObject;
				T result = caseMappingCallExpCS(mappingCallExpCS);
				if (result == null) result = caseOperationCallExpCS(mappingCallExpCS);
				if (result == null) result = caseFeatureCallExpCS(mappingCallExpCS);
				if (result == null) result = caseCallExpCS(mappingCallExpCS);
				if (result == null) result = caseOCLExpressionCS(mappingCallExpCS);
				if (result == null) result = caseCSTNode(mappingCallExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.WHILE_EXP_CS: {
				WhileExpCS whileExpCS = (WhileExpCS)theEObject;
				T result = caseWhileExpCS(whileExpCS);
				if (result == null) result = caseOCLExpressionCS(whileExpCS);
				if (result == null) result = caseCSTNode(whileExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.SWITCH_EXP_CS: {
				SwitchExpCS switchExpCS = (SwitchExpCS)theEObject;
				T result = caseSwitchExpCS(switchExpCS);
				if (result == null) result = caseStatementCS(switchExpCS);
				if (result == null) result = caseOCLExpressionCS(switchExpCS);
				if (result == null) result = caseCSTNode(switchExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.SWITCH_ALT_EXP_CS: {
				SwitchAltExpCS switchAltExpCS = (SwitchAltExpCS)theEObject;
				T result = caseSwitchAltExpCS(switchAltExpCS);
				if (result == null) result = caseCSTNode(switchAltExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.BLOCK_EXP_CS: {
				BlockExpCS blockExpCS = (BlockExpCS)theEObject;
				T result = caseBlockExpCS(blockExpCS);
				if (result == null) result = caseOCLExpressionCS(blockExpCS);
				if (result == null) result = caseCSTNode(blockExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.DIRECTION_KIND_CS: {
				DirectionKindCS directionKindCS = (DirectionKindCS)theEObject;
				T result = caseDirectionKindCS(directionKindCS);
				if (result == null) result = caseCSTNode(directionKindCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.ELEMENT_WITH_BODY: {
				ElementWithBody elementWithBody = (ElementWithBody)theEObject;
				T result = caseElementWithBody(elementWithBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.RESOLVE_EXP_CS: {
				ResolveExpCS resolveExpCS = (ResolveExpCS)theEObject;
				T result = caseResolveExpCS(resolveExpCS);
				if (result == null) result = caseCallExpCS(resolveExpCS);
				if (result == null) result = caseOCLExpressionCS(resolveExpCS);
				if (result == null) result = caseCSTNode(resolveExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.RESOLVE_IN_EXP_CS: {
				ResolveInExpCS resolveInExpCS = (ResolveInExpCS)theEObject;
				T result = caseResolveInExpCS(resolveInExpCS);
				if (result == null) result = caseResolveExpCS(resolveInExpCS);
				if (result == null) result = caseCallExpCS(resolveInExpCS);
				if (result == null) result = caseOCLExpressionCS(resolveInExpCS);
				if (result == null) result = caseCSTNode(resolveInExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MODEL_TYPE_CS: {
				ModelTypeCS modelTypeCS = (ModelTypeCS)theEObject;
				T result = caseModelTypeCS(modelTypeCS);
				if (result == null) result = caseCSTNode(modelTypeCS);
				if (result == null) result = caseElementWithBody(modelTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.PACKAGE_REF_CS: {
				PackageRefCS packageRefCS = (PackageRefCS)theEObject;
				T result = casePackageRefCS(packageRefCS);
				if (result == null) result = caseCSTNode(packageRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.TRANSFORMATION_HEADER_CS: {
				TransformationHeaderCS transformationHeaderCS = (TransformationHeaderCS)theEObject;
				T result = caseTransformationHeaderCS(transformationHeaderCS);
				if (result == null) result = caseCSTNode(transformationHeaderCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MODULE_KIND_CS: {
				ModuleKindCS moduleKindCS = (ModuleKindCS)theEObject;
				T result = caseModuleKindCS(moduleKindCS);
				if (result == null) result = caseCSTNode(moduleKindCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MODULE_REF_CS: {
				ModuleRefCS moduleRefCS = (ModuleRefCS)theEObject;
				T result = caseModuleRefCS(moduleRefCS);
				if (result == null) result = caseCSTNode(moduleRefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.MODULE_USAGE_CS: {
				ModuleUsageCS moduleUsageCS = (ModuleUsageCS)theEObject;
				T result = caseModuleUsageCS(moduleUsageCS);
				if (result == null) result = caseCSTNode(moduleUsageCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.TRANSFORMATION_REFINE_CS: {
				TransformationRefineCS transformationRefineCS = (TransformationRefineCS)theEObject;
				T result = caseTransformationRefineCS(transformationRefineCS);
				if (result == null) result = caseCSTNode(transformationRefineCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.TYPE_SPEC_CS: {
				TypeSpecCS typeSpecCS = (TypeSpecCS)theEObject;
				T result = caseTypeSpecCS(typeSpecCS);
				if (result == null) result = caseCSTNode(typeSpecCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.LOG_EXP_CS: {
				LogExpCS logExpCS = (LogExpCS)theEObject;
				T result = caseLogExpCS(logExpCS);
				if (result == null) result = caseOperationCallExpCS(logExpCS);
				if (result == null) result = caseFeatureCallExpCS(logExpCS);
				if (result == null) result = caseCallExpCS(logExpCS);
				if (result == null) result = caseOCLExpressionCS(logExpCS);
				if (result == null) result = caseCSTNode(logExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CSTPackage.ASSERT_EXP_CS: {
				AssertExpCS assertExpCS = (AssertExpCS)theEObject;
				T result = caseAssertExpCS(assertExpCS);
				if (result == null) result = caseOCLExpressionCS(assertExpCS);
				if (result == null) result = caseCSTNode(assertExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Module CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Module CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingModuleCS(MappingModuleCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Library CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Library CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibraryCS(LibraryCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImportCS(ImportCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Import CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Import CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleImportCS(ModuleImportCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Library Import CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Library Import CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibraryImportCS(LibraryImportCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rename CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rename CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRenameCS(RenameCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Property CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModulePropertyCS(ModulePropertyCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Config Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Config Property CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfigPropertyCS(ConfigPropertyCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Property CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalPropertyCS(LocalPropertyCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Declaration CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Declaration CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingDeclarationCS(MappingDeclarationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Declaration CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Declaration CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterDeclarationCS(ParameterDeclarationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Method CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Method CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingMethodCS(MappingMethodCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Rule CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Rule CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingRuleCS(MappingRuleCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Query CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Query CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingQueryCS(MappingQueryCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Section CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Section CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingSectionCS(MappingSectionCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Init CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Init CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingInitCS(MappingInitCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping End CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping End CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingEndCS(MappingEndCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatementCS(StatementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assign Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assign Statement CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignStatementCS(AssignStatementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Statement CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionStatementCS(ExpressionStatementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Initialization CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Initialization CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableInitializationCS(VariableInitializationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Body CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Body CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingBodyCS(MappingBodyCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Out Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Out Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutExpCS(OutExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Property Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Property Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternPropertyExpCS(PatternPropertyExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingCallExpCS(MappingCallExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhileExpCS(WhileExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Exp CS</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseSwitchExpCS(SwitchExpCS object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Alt Exp CS</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Alt Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseSwitchAltExpCS(SwitchAltExpCS object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Block Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockExpCS(BlockExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Direction Kind CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Direction Kind CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectionKindCS(DirectionKindCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element With Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element With Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementWithBody(ElementWithBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resolve Exp CS</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resolve Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseResolveExpCS(ResolveExpCS object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Resolve In Exp CS</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resolve In Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseResolveInExpCS(ResolveInExpCS object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Model Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelTypeCS(ModelTypeCS object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageRefCS(PackageRefCS object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Transformation Header CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transformation Header CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransformationHeaderCS(TransformationHeaderCS object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Kind CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Kind CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleKindCS(ModuleKindCS object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleRefCS(ModuleRefCS object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Usage CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Usage CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleUsageCS(ModuleUsageCS object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Transformation Refine CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transformation Refine CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransformationRefineCS(TransformationRefineCS object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Spec CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Spec CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeSpecCS(TypeSpecCS object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Log Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Log Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogExpCS(LogExpCS object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Assert Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assert Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssertExpCS(AssertExpCS object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCSTNode(CSTNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Expression CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Expression CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLExpressionCS(OCLExpressionCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallExpCS(CallExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureCallExpCS(FeatureCallExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationCallExpCS(OperationCallExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //CSTSwitch
