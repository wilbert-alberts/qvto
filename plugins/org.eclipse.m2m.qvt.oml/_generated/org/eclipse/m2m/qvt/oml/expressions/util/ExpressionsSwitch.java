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
package org.eclipse.m2m.qvt.oml.expressions.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.ETypedElement;

import org.eclipse.m2m.qvt.oml.expressions.*;

import org.eclipse.ocl.expressions.CallExp;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;

import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.CallingASTNode;
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
 * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage
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
            case ExpressionsPackage.PROPERTY: {
                Property property = (Property)theEObject;
                T1 result = caseProperty(property);
                if (result == null) result = caseEParameter(property);
                if (result == null) result = caseVisitableASTNode(property);
                if (result == null) result = caseETypedElement(property);
                if (result == null) result = caseVisitable(property);
                if (result == null) result = caseASTNode(property);
                if (result == null) result = caseENamedElement(property);
                if (result == null) result = caseEModelElement(property);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.LOCAL_PROPERTY: {
                LocalProperty localProperty = (LocalProperty)theEObject;
                T1 result = caseLocalProperty(localProperty);
                if (result == null) result = caseProperty(localProperty);
                if (result == null) result = caseEParameter(localProperty);
                if (result == null) result = caseVisitableASTNode(localProperty);
                if (result == null) result = caseETypedElement(localProperty);
                if (result == null) result = caseVisitable(localProperty);
                if (result == null) result = caseASTNode(localProperty);
                if (result == null) result = caseENamedElement(localProperty);
                if (result == null) result = caseEModelElement(localProperty);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.CONFIG_PROPERTY: {
                ConfigProperty configProperty = (ConfigProperty)theEObject;
                T1 result = caseConfigProperty(configProperty);
                if (result == null) result = caseProperty(configProperty);
                if (result == null) result = caseEParameter(configProperty);
                if (result == null) result = caseVisitableASTNode(configProperty);
                if (result == null) result = caseETypedElement(configProperty);
                if (result == null) result = caseVisitable(configProperty);
                if (result == null) result = caseASTNode(configProperty);
                if (result == null) result = caseENamedElement(configProperty);
                if (result == null) result = caseEModelElement(configProperty);
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
                if (result == null) result = caseEParameter(modelParameter);
                if (result == null) result = caseVisitableASTNode(modelParameter);
                if (result == null) result = caseETypedElement(modelParameter);
                if (result == null) result = caseVisitable(modelParameter);
                if (result == null) result = caseASTNode(modelParameter);
                if (result == null) result = caseENamedElement(modelParameter);
                if (result == null) result = caseEModelElement(modelParameter);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.VAR_PARAMETER: {
                VarParameter varParameter = (VarParameter)theEObject;
                T1 result = caseVarParameter(varParameter);
                if (result == null) result = caseEParameter(varParameter);
                if (result == null) result = caseVisitableASTNode(varParameter);
                if (result == null) result = caseETypedElement(varParameter);
                if (result == null) result = caseVisitable(varParameter);
                if (result == null) result = caseASTNode(varParameter);
                if (result == null) result = caseENamedElement(varParameter);
                if (result == null) result = caseEModelElement(varParameter);
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
            case ExpressionsPackage.OBJECT_EXP: {
                ObjectExp objectExp = (ObjectExp)theEObject;
                T1 result = caseObjectExp(objectExp);
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
            case ExpressionsPackage.EXTENDED_VISITOR: {
                @SuppressWarnings("unchecked") ExtendedVisitor<?, ?, ?, ?, ?> extendedVisitor = (ExtendedVisitor<?, ?, ?, ?, ?>)theEObject;
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
            case ExpressionsPackage.PACKAGE_REF: {
                PackageRef packageRef = (PackageRef)theEObject;
                T1 result = casePackageRef(packageRef);
                if (result == null) result = caseASTNode(packageRef);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.MAPPING_PARAMETER: {
                MappingParameter mappingParameter = (MappingParameter)theEObject;
                T1 result = caseMappingParameter(mappingParameter);
                if (result == null) result = caseVarParameter(mappingParameter);
                if (result == null) result = caseEParameter(mappingParameter);
                if (result == null) result = caseVisitableASTNode(mappingParameter);
                if (result == null) result = caseETypedElement(mappingParameter);
                if (result == null) result = caseVisitable(mappingParameter);
                if (result == null) result = caseASTNode(mappingParameter);
                if (result == null) result = caseENamedElement(mappingParameter);
                if (result == null) result = caseEModelElement(mappingParameter);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
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
     * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T1 caseProperty(Property object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Local Property</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Local Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T1 caseLocalProperty(LocalProperty object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Config Property</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Config Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T1 caseConfigProperty(ConfigProperty object) {
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
	public <T, S, COA, SSA, CT> T1 caseExtendedVisitor(ExtendedVisitor<T, S, COA, SSA, CT> object) {
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
     * Returns the result of interpreting the object as an instance of '<em>Package Ref</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Package Ref</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T1 casePackageRef(PackageRef object) {
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
