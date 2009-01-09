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
package org.eclipse.m2m.internal.qvt.oml.expressions.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.m2m.internal.qvt.oml.expressions.AltExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.AssertExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.AssignExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.BlockExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ComputeExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ConstructorBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty;
import org.eclipse.m2m.internal.qvt.oml.expressions.DictLiteralExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.DictLiteralPart;
import org.eclipse.m2m.internal.qvt.oml.expressions.DictionaryType;
import org.eclipse.m2m.internal.qvt.oml.expressions.EntryOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExtendedVisitor;
import org.eclipse.m2m.internal.qvt.oml.expressions.ForExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.Helper;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeExpression;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeIterateExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeLoopExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.InstantiationExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;
import org.eclipse.m2m.internal.qvt.oml.expressions.ListType;
import org.eclipse.m2m.internal.qvt.oml.expressions.LogExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingCallExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.internal.qvt.oml.expressions.ObjectExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Rename;
import org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ResolveInExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ReturnExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.SwitchExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.TemplateParameterType;
import org.eclipse.m2m.internal.qvt.oml.expressions.Typedef;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.VariableInitExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.VisitableASTNode;
import org.eclipse.m2m.internal.qvt.oml.expressions.WhileExp;
import org.eclipse.ocl.expressions.CallExp;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.LiteralExp;
import org.eclipse.ocl.expressions.LoopExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.Visitable;
import org.eclipse.ocl.utilities.Visitor;

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
 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsSwitch<T1> {
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation"; //$NON-NLS-1$
    /**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExpressionsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsSwitch() {
		if (modelPackage == null) {
			modelPackage = ExpressionsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T1 doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T1 doSwitch(EClass theEClass, EObject theEObject) {
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
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ExpressionsPackage.LIST_TYPE: {
				ListType listType = (ListType)theEObject;
				T1 result = caseListType(listType);
				if (result == null) result = caseEcore_CollectionType(listType);
				if (result == null) result = caseEDataType(listType);
				if (result == null) result = caseCollectionType(listType);
				if (result == null) result = caseEClassifier(listType);
				if (result == null) result = casePredefinedType(listType);
				if (result == null) result = caseTypedASTNode(listType);
				if (result == null) result = caseENamedElement(listType);
				if (result == null) result = caseASTNode(listType);
				if (result == null) result = caseEModelElement(listType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.DICT_LITERAL_EXP: {
				DictLiteralExp dictLiteralExp = (DictLiteralExp)theEObject;
				T1 result = caseDictLiteralExp(dictLiteralExp);
				if (result == null) result = caseEcore_LiteralExp(dictLiteralExp);
				if (result == null) result = caseEcore_OCLExpression(dictLiteralExp);
				if (result == null) result = caseLiteralExp(dictLiteralExp);
				if (result == null) result = caseETypedElement(dictLiteralExp);
				if (result == null) result = caseOCLExpression(dictLiteralExp);
				if (result == null) result = caseENamedElement(dictLiteralExp);
				if (result == null) result = caseTypedElement(dictLiteralExp);
				if (result == null) result = caseVisitable(dictLiteralExp);
				if (result == null) result = caseASTNode(dictLiteralExp);
				if (result == null) result = caseEModelElement(dictLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.DICT_LITERAL_PART: {
				DictLiteralPart dictLiteralPart = (DictLiteralPart)theEObject;
				T1 result = caseDictLiteralPart(dictLiteralPart);
				if (result == null) result = caseEModelElement(dictLiteralPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.TEMPLATE_PARAMETER_TYPE: {
				TemplateParameterType templateParameterType = (TemplateParameterType)theEObject;
				T1 result = caseTemplateParameterType(templateParameterType);
				if (result == null) result = caseEClassifier(templateParameterType);
				if (result == null) result = caseENamedElement(templateParameterType);
				if (result == null) result = caseEModelElement(templateParameterType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.DICTIONARY_TYPE: {
				DictionaryType dictionaryType = (DictionaryType)theEObject;
				T1 result = caseDictionaryType(dictionaryType);
				if (result == null) result = caseEcore_CollectionType(dictionaryType);
				if (result == null) result = caseEDataType(dictionaryType);
				if (result == null) result = caseCollectionType(dictionaryType);
				if (result == null) result = caseEClassifier(dictionaryType);
				if (result == null) result = casePredefinedType(dictionaryType);
				if (result == null) result = caseTypedASTNode(dictionaryType);
				if (result == null) result = caseENamedElement(dictionaryType);
				if (result == null) result = caseASTNode(dictionaryType);
				if (result == null) result = caseEModelElement(dictionaryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.TYPEDEF: {
				Typedef typedef = (Typedef)theEObject;
				T1 result = caseTypedef(typedef);
				if (result == null) result = caseEClass(typedef);
				if (result == null) result = caseEClassifier(typedef);
				if (result == null) result = caseENamedElement(typedef);
				if (result == null) result = caseEModelElement(typedef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.MODULE: {
				Module module = (Module)theEObject;
				T1 result = caseModule(module);
				if (result == null) result = caseEClass(module);
				if (result == null) result = caseEPackage(module);
				if (result == null) result = caseVisitableASTNode(module);
				if (result == null) result = caseEClassifier(module);
				if (result == null) result = caseENamedElement(module);
				if (result == null) result = caseVisitable(module);
				if (result == null) result = caseASTNode(module);
				if (result == null) result = caseEModelElement(module);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.LIBRARY: {
				Library library = (Library)theEObject;
				T1 result = caseLibrary(library);
				if (result == null) result = caseModule(library);
				if (result == null) result = caseEClass(library);
				if (result == null) result = caseEPackage(library);
				if (result == null) result = caseVisitableASTNode(library);
				if (result == null) result = caseEClassifier(library);
				if (result == null) result = caseENamedElement(library);
				if (result == null) result = caseVisitable(library);
				if (result == null) result = caseASTNode(library);
				if (result == null) result = caseEModelElement(library);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.RENAME: {
				Rename rename = (Rename)theEObject;
				T1 result = caseRename(rename);
				if (result == null) result = caseETypedElement(rename);
				if (result == null) result = caseVisitableASTNode(rename);
				if (result == null) result = caseENamedElement(rename);
				if (result == null) result = caseVisitable(rename);
				if (result == null) result = caseASTNode(rename);
				if (result == null) result = caseEModelElement(rename);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.MODULE_IMPORT: {
				ModuleImport moduleImport = (ModuleImport)theEObject;
				T1 result = caseModuleImport(moduleImport);
				if (result == null) result = caseVisitableASTNode(moduleImport);
				if (result == null) result = caseVisitable(moduleImport);
				if (result == null) result = caseASTNode(moduleImport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.CLASS: {
				org.eclipse.m2m.internal.qvt.oml.expressions.Class class_ = (org.eclipse.m2m.internal.qvt.oml.expressions.Class)theEObject;
				T1 result = caseClass(class_);
				if (result == null) result = caseEClass(class_);
				if (result == null) result = caseVisitableASTNode(class_);
				if (result == null) result = caseEClassifier(class_);
				if (result == null) result = caseVisitable(class_);
				if (result == null) result = caseASTNode(class_);
				if (result == null) result = caseENamedElement(class_);
				if (result == null) result = caseEModelElement(class_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.CONTEXTUAL_PROPERTY: {
				ContextualProperty contextualProperty = (ContextualProperty)theEObject;
				T1 result = caseContextualProperty(contextualProperty);
				if (result == null) result = caseEStructuralFeature(contextualProperty);
				if (result == null) result = caseVisitableASTNode(contextualProperty);
				if (result == null) result = caseETypedElement(contextualProperty);
				if (result == null) result = caseVisitable(contextualProperty);
				if (result == null) result = caseASTNode(contextualProperty);
				if (result == null) result = caseENamedElement(contextualProperty);
				if (result == null) result = caseEModelElement(contextualProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.IMPERATIVE_OPERATION: {
				ImperativeOperation imperativeOperation = (ImperativeOperation)theEObject;
				T1 result = caseImperativeOperation(imperativeOperation);
				if (result == null) result = caseEOperation(imperativeOperation);
				if (result == null) result = caseVisitableASTNode(imperativeOperation);
				if (result == null) result = caseETypedElement(imperativeOperation);
				if (result == null) result = caseVisitable(imperativeOperation);
				if (result == null) result = caseASTNode(imperativeOperation);
				if (result == null) result = caseENamedElement(imperativeOperation);
				if (result == null) result = caseEModelElement(imperativeOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.MODEL_PARAMETER: {
				ModelParameter modelParameter = (ModelParameter)theEObject;
				T1 result = caseModelParameter(modelParameter);
				if (result == null) result = caseVarParameter(modelParameter);
				if (result == null) result = caseEcore_Variable(modelParameter);
				if (result == null) result = caseEParameter(modelParameter);
				if (result == null) result = caseETypedElement(modelParameter);
				if (result == null) result = caseVariable(modelParameter);
				if (result == null) result = caseENamedElement(modelParameter);
				if (result == null) result = caseTypedElement(modelParameter);
				if (result == null) result = caseVisitable(modelParameter);
				if (result == null) result = caseTypedASTNode(modelParameter);
				if (result == null) result = caseEModelElement(modelParameter);
				if (result == null) result = caseASTNode(modelParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.VAR_PARAMETER: {
				VarParameter varParameter = (VarParameter)theEObject;
				T1 result = caseVarParameter(varParameter);
				if (result == null) result = caseEcore_Variable(varParameter);
				if (result == null) result = caseEParameter(varParameter);
				if (result == null) result = caseETypedElement(varParameter);
				if (result == null) result = caseVariable(varParameter);
				if (result == null) result = caseENamedElement(varParameter);
				if (result == null) result = caseTypedElement(varParameter);
				if (result == null) result = caseVisitable(varParameter);
				if (result == null) result = caseTypedASTNode(varParameter);
				if (result == null) result = caseEModelElement(varParameter);
				if (result == null) result = caseASTNode(varParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OPERATION_BODY: {
				OperationBody operationBody = (OperationBody)theEObject;
				T1 result = caseOperationBody(operationBody);
				if (result == null) result = caseVisitableASTNode(operationBody);
				if (result == null) result = caseVisitable(operationBody);
				if (result == null) result = caseASTNode(operationBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.CONSTRUCTOR_BODY: {
				ConstructorBody constructorBody = (ConstructorBody)theEObject;
				T1 result = caseConstructorBody(constructorBody);
				if (result == null) result = caseOperationBody(constructorBody);
				if (result == null) result = caseVisitableASTNode(constructorBody);
				if (result == null) result = caseVisitable(constructorBody);
				if (result == null) result = caseASTNode(constructorBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.MAPPING_OPERATION: {
				MappingOperation mappingOperation = (MappingOperation)theEObject;
				T1 result = caseMappingOperation(mappingOperation);
				if (result == null) result = caseImperativeOperation(mappingOperation);
				if (result == null) result = caseEOperation(mappingOperation);
				if (result == null) result = caseVisitableASTNode(mappingOperation);
				if (result == null) result = caseETypedElement(mappingOperation);
				if (result == null) result = caseVisitable(mappingOperation);
				if (result == null) result = caseASTNode(mappingOperation);
				if (result == null) result = caseENamedElement(mappingOperation);
				if (result == null) result = caseEModelElement(mappingOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.HELPER: {
				Helper helper = (Helper)theEObject;
				T1 result = caseHelper(helper);
				if (result == null) result = caseImperativeOperation(helper);
				if (result == null) result = caseEOperation(helper);
				if (result == null) result = caseVisitableASTNode(helper);
				if (result == null) result = caseETypedElement(helper);
				if (result == null) result = caseVisitable(helper);
				if (result == null) result = caseASTNode(helper);
				if (result == null) result = caseENamedElement(helper);
				if (result == null) result = caseEModelElement(helper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.MAPPING_BODY: {
				MappingBody mappingBody = (MappingBody)theEObject;
				T1 result = caseMappingBody(mappingBody);
				if (result == null) result = caseOperationBody(mappingBody);
				if (result == null) result = caseVisitableASTNode(mappingBody);
				if (result == null) result = caseVisitable(mappingBody);
				if (result == null) result = caseASTNode(mappingBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.IMPERATIVE_EXPRESSION: {
				ImperativeExpression imperativeExpression = (ImperativeExpression)theEObject;
				T1 result = caseImperativeExpression(imperativeExpression);
				if (result == null) result = caseOCLExpression(imperativeExpression);
				if (result == null) result = caseTypedElement(imperativeExpression);
				if (result == null) result = caseVisitable(imperativeExpression);
				if (result == null) result = caseASTNode(imperativeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ASSIGN_EXP: {
				AssignExp assignExp = (AssignExp)theEObject;
				T1 result = caseAssignExp(assignExp);
				if (result == null) result = caseImperativeExpression(assignExp);
				if (result == null) result = caseOCLExpression(assignExp);
				if (result == null) result = caseTypedElement(assignExp);
				if (result == null) result = caseVisitable(assignExp);
				if (result == null) result = caseASTNode(assignExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.VARIABLE_INIT_EXP: {
				VariableInitExp variableInitExp = (VariableInitExp)theEObject;
				T1 result = caseVariableInitExp(variableInitExp);
				if (result == null) result = caseImperativeExpression(variableInitExp);
				if (result == null) result = caseOCLExpression(variableInitExp);
				if (result == null) result = caseTypedElement(variableInitExp);
				if (result == null) result = caseVisitable(variableInitExp);
				if (result == null) result = caseASTNode(variableInitExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.MAPPING_CALL_EXP: {
				MappingCallExp mappingCallExp = (MappingCallExp)theEObject;
				T1 result = caseMappingCallExp(mappingCallExp);
				if (result == null) result = caseOperationCallExp(mappingCallExp);
				if (result == null) result = caseFeatureCallExp(mappingCallExp);
				if (result == null) result = caseCallExp(mappingCallExp);
				if (result == null) result = caseOCLExpression(mappingCallExp);
				if (result == null) result = caseCallingASTNode(mappingCallExp);
				if (result == null) result = caseTypedElement(mappingCallExp);
				if (result == null) result = caseVisitable(mappingCallExp);
				if (result == null) result = caseASTNode(mappingCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.BLOCK_EXP: {
				BlockExp blockExp = (BlockExp)theEObject;
				T1 result = caseBlockExp(blockExp);
				if (result == null) result = caseImperativeExpression(blockExp);
				if (result == null) result = caseOCLExpression(blockExp);
				if (result == null) result = caseTypedElement(blockExp);
				if (result == null) result = caseVisitable(blockExp);
				if (result == null) result = caseASTNode(blockExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.COMPUTE_EXP: {
				ComputeExp computeExp = (ComputeExp)theEObject;
				T1 result = caseComputeExp(computeExp);
				if (result == null) result = caseImperativeExpression(computeExp);
				if (result == null) result = caseOCLExpression(computeExp);
				if (result == null) result = caseTypedElement(computeExp);
				if (result == null) result = caseVisitable(computeExp);
				if (result == null) result = caseASTNode(computeExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OBJECT_EXP: {
				ObjectExp objectExp = (ObjectExp)theEObject;
				T1 result = caseObjectExp(objectExp);
				if (result == null) result = caseInstantiationExp(objectExp);
				if (result == null) result = caseImperativeExpression(objectExp);
				if (result == null) result = caseOCLExpression(objectExp);
				if (result == null) result = caseTypedElement(objectExp);
				if (result == null) result = caseVisitable(objectExp);
				if (result == null) result = caseASTNode(objectExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.WHILE_EXP: {
				WhileExp whileExp = (WhileExp)theEObject;
				T1 result = caseWhileExp(whileExp);
				if (result == null) result = caseImperativeExpression(whileExp);
				if (result == null) result = caseOCLExpression(whileExp);
				if (result == null) result = caseTypedElement(whileExp);
				if (result == null) result = caseVisitable(whileExp);
				if (result == null) result = caseASTNode(whileExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.SWITCH_EXP: {
				SwitchExp switchExp = (SwitchExp)theEObject;
				T1 result = caseSwitchExp(switchExp);
				if (result == null) result = caseImperativeExpression(switchExp);
				if (result == null) result = caseOCLExpression(switchExp);
				if (result == null) result = caseTypedElement(switchExp);
				if (result == null) result = caseVisitable(switchExp);
				if (result == null) result = caseASTNode(switchExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ALT_EXP: {
				AltExp altExp = (AltExp)theEObject;
				T1 result = caseAltExp(altExp);
				if (result == null) result = caseImperativeExpression(altExp);
				if (result == null) result = caseOCLExpression(altExp);
				if (result == null) result = caseTypedElement(altExp);
				if (result == null) result = caseVisitable(altExp);
				if (result == null) result = caseASTNode(altExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.EXTENDED_VISITOR: {
				ExtendedVisitor<?> extendedVisitor = (ExtendedVisitor<?>)theEObject;
				T1 result = caseExtendedVisitor(extendedVisitor);
				if (result == null) result = caseVisitor(extendedVisitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.VISITABLE_AST_NODE: {
				VisitableASTNode visitableASTNode = (VisitableASTNode)theEObject;
				T1 result = caseVisitableASTNode(visitableASTNode);
				if (result == null) result = caseVisitable(visitableASTNode);
				if (result == null) result = caseASTNode(visitableASTNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.RESOLVE_EXP: {
				ResolveExp resolveExp = (ResolveExp)theEObject;
				T1 result = caseResolveExp(resolveExp);
				if (result == null) result = caseCallExp(resolveExp);
				if (result == null) result = caseOCLExpression(resolveExp);
				if (result == null) result = caseCallingASTNode(resolveExp);
				if (result == null) result = caseTypedElement(resolveExp);
				if (result == null) result = caseVisitable(resolveExp);
				if (result == null) result = caseASTNode(resolveExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.RESOLVE_IN_EXP: {
				ResolveInExp resolveInExp = (ResolveInExp)theEObject;
				T1 result = caseResolveInExp(resolveInExp);
				if (result == null) result = caseResolveExp(resolveInExp);
				if (result == null) result = caseCallExp(resolveInExp);
				if (result == null) result = caseOCLExpression(resolveInExp);
				if (result == null) result = caseCallingASTNode(resolveInExp);
				if (result == null) result = caseTypedElement(resolveInExp);
				if (result == null) result = caseVisitable(resolveInExp);
				if (result == null) result = caseASTNode(resolveInExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.MODEL_TYPE: {
				ModelType modelType = (ModelType)theEObject;
				T1 result = caseModelType(modelType);
				if (result == null) result = caseEClass(modelType);
				if (result == null) result = caseVisitableASTNode(modelType);
				if (result == null) result = caseEClassifier(modelType);
				if (result == null) result = caseVisitable(modelType);
				if (result == null) result = caseASTNode(modelType);
				if (result == null) result = caseENamedElement(modelType);
				if (result == null) result = caseEModelElement(modelType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.MAPPING_PARAMETER: {
				MappingParameter mappingParameter = (MappingParameter)theEObject;
				T1 result = caseMappingParameter(mappingParameter);
				if (result == null) result = caseVarParameter(mappingParameter);
				if (result == null) result = caseEcore_Variable(mappingParameter);
				if (result == null) result = caseEParameter(mappingParameter);
				if (result == null) result = caseETypedElement(mappingParameter);
				if (result == null) result = caseVariable(mappingParameter);
				if (result == null) result = caseENamedElement(mappingParameter);
				if (result == null) result = caseTypedElement(mappingParameter);
				if (result == null) result = caseVisitable(mappingParameter);
				if (result == null) result = caseTypedASTNode(mappingParameter);
				if (result == null) result = caseEModelElement(mappingParameter);
				if (result == null) result = caseASTNode(mappingParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.LOG_EXP: {
				LogExp logExp = (LogExp)theEObject;
				T1 result = caseLogExp(logExp);
				if (result == null) result = caseOperationCallExp(logExp);
				if (result == null) result = caseFeatureCallExp(logExp);
				if (result == null) result = caseCallExp(logExp);
				if (result == null) result = caseOCLExpression(logExp);
				if (result == null) result = caseCallingASTNode(logExp);
				if (result == null) result = caseTypedElement(logExp);
				if (result == null) result = caseVisitable(logExp);
				if (result == null) result = caseASTNode(logExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ASSERT_EXP: {
				AssertExp assertExp = (AssertExp)theEObject;
				T1 result = caseAssertExp(assertExp);
				if (result == null) result = caseImperativeExpression(assertExp);
				if (result == null) result = caseOCLExpression(assertExp);
				if (result == null) result = caseTypedElement(assertExp);
				if (result == null) result = caseVisitable(assertExp);
				if (result == null) result = caseASTNode(assertExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.IMPERATIVE_LOOP_EXP: {
				ImperativeLoopExp imperativeLoopExp = (ImperativeLoopExp)theEObject;
				T1 result = caseImperativeLoopExp(imperativeLoopExp);
				if (result == null) result = caseLoopExp(imperativeLoopExp);
				if (result == null) result = caseImperativeExpression(imperativeLoopExp);
				if (result == null) result = caseCallExp(imperativeLoopExp);
				if (result == null) result = caseOCLExpression(imperativeLoopExp);
				if (result == null) result = caseCallingASTNode(imperativeLoopExp);
				if (result == null) result = caseTypedElement(imperativeLoopExp);
				if (result == null) result = caseVisitable(imperativeLoopExp);
				if (result == null) result = caseASTNode(imperativeLoopExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.FOR_EXP: {
				ForExp forExp = (ForExp)theEObject;
				T1 result = caseForExp(forExp);
				if (result == null) result = caseImperativeLoopExp(forExp);
				if (result == null) result = caseLoopExp(forExp);
				if (result == null) result = caseImperativeExpression(forExp);
				if (result == null) result = caseCallExp(forExp);
				if (result == null) result = caseOCLExpression(forExp);
				if (result == null) result = caseCallingASTNode(forExp);
				if (result == null) result = caseTypedElement(forExp);
				if (result == null) result = caseVisitable(forExp);
				if (result == null) result = caseASTNode(forExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.IMPERATIVE_ITERATE_EXP: {
				ImperativeIterateExp imperativeIterateExp = (ImperativeIterateExp)theEObject;
				T1 result = caseImperativeIterateExp(imperativeIterateExp);
				if (result == null) result = caseImperativeLoopExp(imperativeIterateExp);
				if (result == null) result = caseLoopExp(imperativeIterateExp);
				if (result == null) result = caseImperativeExpression(imperativeIterateExp);
				if (result == null) result = caseCallExp(imperativeIterateExp);
				if (result == null) result = caseOCLExpression(imperativeIterateExp);
				if (result == null) result = caseCallingASTNode(imperativeIterateExp);
				if (result == null) result = caseTypedElement(imperativeIterateExp);
				if (result == null) result = caseVisitable(imperativeIterateExp);
				if (result == null) result = caseASTNode(imperativeIterateExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.INSTANTIATION_EXP: {
				InstantiationExp instantiationExp = (InstantiationExp)theEObject;
				T1 result = caseInstantiationExp(instantiationExp);
				if (result == null) result = caseImperativeExpression(instantiationExp);
				if (result == null) result = caseOCLExpression(instantiationExp);
				if (result == null) result = caseTypedElement(instantiationExp);
				if (result == null) result = caseVisitable(instantiationExp);
				if (result == null) result = caseASTNode(instantiationExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.RETURN_EXP: {
				ReturnExp returnExp = (ReturnExp)theEObject;
				T1 result = caseReturnExp(returnExp);
				if (result == null) result = caseImperativeExpression(returnExp);
				if (result == null) result = caseOCLExpression(returnExp);
				if (result == null) result = caseTypedElement(returnExp);
				if (result == null) result = caseVisitable(returnExp);
				if (result == null) result = caseASTNode(returnExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OPERATIONAL_TRANSFORMATION: {
				OperationalTransformation operationalTransformation = (OperationalTransformation)theEObject;
				T1 result = caseOperationalTransformation(operationalTransformation);
				if (result == null) result = caseModule(operationalTransformation);
				if (result == null) result = caseEClass(operationalTransformation);
				if (result == null) result = caseEPackage(operationalTransformation);
				if (result == null) result = caseVisitableASTNode(operationalTransformation);
				if (result == null) result = caseEClassifier(operationalTransformation);
				if (result == null) result = caseENamedElement(operationalTransformation);
				if (result == null) result = caseVisitable(operationalTransformation);
				if (result == null) result = caseASTNode(operationalTransformation);
				if (result == null) result = caseEModelElement(operationalTransformation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ENTRY_OPERATION: {
				EntryOperation entryOperation = (EntryOperation)theEObject;
				T1 result = caseEntryOperation(entryOperation);
				if (result == null) result = caseImperativeOperation(entryOperation);
				if (result == null) result = caseEOperation(entryOperation);
				if (result == null) result = caseVisitableASTNode(entryOperation);
				if (result == null) result = caseETypedElement(entryOperation);
				if (result == null) result = caseVisitable(entryOperation);
				if (result == null) result = caseASTNode(entryOperation);
				if (result == null) result = caseENamedElement(entryOperation);
				if (result == null) result = caseEModelElement(entryOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseListType(ListType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dict Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dict Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDictLiteralExp(DictLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dict Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dict Literal Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDictLiteralPart(DictLiteralPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Parameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Parameter Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTemplateParameterType(TemplateParameterType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dictionary Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dictionary Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDictionaryType(DictionaryType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typedef</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typedef</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTypedef(Typedef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseModule(Module object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLibrary(Library object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rename</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rename</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRename(Rename object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseModuleImport(ModuleImport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseClass(org.eclipse.m2m.internal.qvt.oml.expressions.Class object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contextual Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contextual Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseContextualProperty(ContextualProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseImperativeOperation(ImperativeOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseModelParameter(ModelParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVarParameter(VarParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOperationBody(OperationBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constructor Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constructor Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseConstructorBody(ConstructorBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMappingOperation(MappingOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseHelper(Helper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMappingBody(MappingBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseImperativeExpression(ImperativeExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assign Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assign Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAssignExp(AssignExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Init Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Init Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVariableInitExp(VariableInitExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMappingCallExp(MappingCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBlockExp(BlockExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compute Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compute Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseComputeExp(ComputeExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseObjectExp(ObjectExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseWhileExp(WhileExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Exp</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T1 caseSwitchExp(SwitchExp object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Alt Exp</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alt Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T1 caseAltExp(AltExp object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Extended Visitor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extended Visitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseExtendedVisitor(ExtendedVisitor<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable AST Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable AST Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVisitableASTNode(VisitableASTNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resolve Exp</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resolve Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T1 caseResolveExp(ResolveExp object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Resolve In Exp</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resolve In Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T1 caseResolveInExp(ResolveInExp object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Model Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseModelType(ModelType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMappingParameter(MappingParameter object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Log Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Log Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLogExp(LogExp object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Assert Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assert Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAssertExp(AssertExp object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Loop Exp</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Loop Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T1 caseImperativeLoopExp(ImperativeLoopExp object) {
		return null;
	}

                /**
	 * Returns the result of interpreting the object as an instance of '<em>For Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseForExp(ForExp object) {
		return null;
	}

																/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Iterate Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T1 caseImperativeIterateExp(ImperativeIterateExp object) {
		return null;
	}

                /**
	 * Returns the result of interpreting the object as an instance of '<em>Instantiation Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instantiation Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInstantiationExp(InstantiationExp object) {
		return null;
	}

																/**
	 * Returns the result of interpreting the object as an instance of '<em>Return Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseReturnExp(ReturnExp object) {
		return null;
	}

																/**
	 * Returns the result of interpreting the object as an instance of '<em>Operational Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operational Transformation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOperationalTransformation(OperationalTransformation object) {
		return null;
	}

																/**
	 * Returns the result of interpreting the object as an instance of '<em>Entry Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entry Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEntryOperation(EntryOperation object) {
		return null;
	}

																/**
	 * Returns the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEModelElement(EModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ENamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ENamed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseENamedElement(ENamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EClassifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EClassifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEClassifier(EClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EData Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EData Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEDataType(EDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Predefined Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predefined Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <O> T1 casePredefinedType(PredefinedType<O> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EClass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EClass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEClass(EClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EPackage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EPackage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEPackage(EPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVisitable(Visitable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AST Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AST Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseASTNode(ASTNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ETyped Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ETyped Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseETypedElement(ETypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EStructural Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EStructural Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEStructuralFeature(EStructuralFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EParameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EParameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEParameter(EParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EOperation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EOperation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEOperation(EOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C> T1 caseTypedElement(TypedElement<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed AST Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed AST Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTypedASTNode(TypedASTNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C, O> T1 caseCollectionType(CollectionType<C, O> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEcore_CollectionType(org.eclipse.ocl.ecore.CollectionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C, PM> T1 caseVariable(Variable<C, PM> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEcore_Variable(org.eclipse.ocl.ecore.Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C> T1 caseOCLExpression(OCLExpression<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEcore_OCLExpression(org.eclipse.ocl.ecore.OCLExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C> T1 caseLiteralExp(LiteralExp<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEcore_LiteralExp(org.eclipse.ocl.ecore.LiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Calling AST Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Calling AST Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCallingASTNode(CallingASTNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C> T1 caseCallExp(CallExp<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C> T1 caseFeatureCallExp(FeatureCallExp<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C, O> T1 caseOperationCallExp(OperationCallExp<C, O> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T, C, O, P, EL, PM, S, COA, SSA, CT> T1 caseVisitor(Visitor<T, C, O, P, EL, PM, S, COA, SSA, CT> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public <C, PM> T1 caseLoopExp(LoopExp<C, PM> object) {
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
	public T1 defaultCase(EObject object) {
		return null;
	}

} //ExpressionsSwitch
