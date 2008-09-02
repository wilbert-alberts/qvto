/**
 * <copyright>
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     A. Sanchez-Barbudo  - initial API and implementation
 * </copyright>
 *
 * $Id: TemplateParameterType.java,v 1.1 2008/09/02 20:01:44 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL;

import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Parameter Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.TemplateParameterType#getSpecification <em>Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage#getTemplateParameterType()
 * @model
 * @generated
 */
public interface TemplateParameterType extends EClassifier {
	/**
	 * Returns the value of the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' attribute.
	 * @see #setSpecification(String)
	 * @see org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage#getTemplateParameterType_Specification()
	 * @model
	 * @generated
	 */
	String getSpecification();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.TemplateParameterType#getSpecification <em>Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' attribute.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(String value);

} // TemplateParameterType
