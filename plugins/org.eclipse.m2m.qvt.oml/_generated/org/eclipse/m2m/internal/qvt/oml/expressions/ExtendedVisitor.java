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
package org.eclipse.m2m.internal.qvt.oml.expressions;





/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extended Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsPackage#getExtendedVisitor()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ExtendedVisitor<T> extends ImperativeOCLVisitor<T> {
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation"; //$NON-NLS-1$

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model moduleRequired="true"
	 * @generated
	 */
	T visitModule(Module module);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model libraryRequired="true"
	 * @generated
	 */
	T visitLibrary(Library library);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model renameRequired="true"
	 * @generated
	 */
	T visitRename(Rename rename);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model moduleImportRequired="true"
	 * @generated
	 */
	T visitModuleImport(ModuleImport moduleImport);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model class_Required="true"
	 * @generated
	 */
	T visitClass(org.eclipse.m2m.internal.qvt.oml.expressions.Class class_);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model contextualPropertyRequired="true"
	 * @generated
	 */
	T visitContextualProperty(ContextualProperty contextualProperty);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model imperativeOperationRequired="true"
	 * @generated
	 */
	T visitImperativeOperation(ImperativeOperation imperativeOperation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model varParameterRequired="true"
	 * @generated
	 */
	T visitVarParameter(VarParameter varParameter);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model operationBodyRequired="true"
	 * @generated
	 */
	T visitOperationBody(OperationBody operationBody);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model mappingOperationRequired="true"
	 * @generated
	 */
	T visitMappingOperation(MappingOperation mappingOperation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model helperRequired="true"
	 * @generated
	 */
	T visitHelper(Helper helper);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model mappingBodyRequired="true"
	 * @generated
	 */
	T visitMappingBody(MappingBody mappingBody);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model mappingCallExpRequired="true"
	 * @generated
	 */
	T visitMappingCallExp(MappingCallExp mappingCallExp);

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @model resolveExpRequired="true"
	 * @generated
	 */
    T visitResolveExp(ResolveExp resolveExp);

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @model resolveInExpRequired="true"
	 * @generated
	 */
    T visitResolveInExp(ResolveInExp resolveInExp);

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model objectExpRequired="true"
	 * @generated
	 */
	T visitObjectExp(ObjectExp objectExp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model modelTypeRequired="true"
	 * @generated
	 */
	T visitModelType(ModelType modelType);

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model entryOperationRequired="true"
	 * @generated
	 */
	T visitEntryOperation(EntryOperation entryOperation);

} // ExtendedVisitor
