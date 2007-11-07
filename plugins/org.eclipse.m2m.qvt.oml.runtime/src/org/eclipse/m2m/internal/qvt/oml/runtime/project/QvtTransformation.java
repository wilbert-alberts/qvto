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
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.config.QvtConfigurationProperty;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.project.Transformation;

public interface QvtTransformation extends Transformation {

	public interface TransformationParameter {
		public enum DirectionKind {
			IN,
			INOUT,
			OUT;
		}

		DirectionKind getDirectionKind();
		
		/**
		 * 
		 * @return name of transformation parameter, may be empty
		 */
		String getName();

		/**
		 * 
		 * @return list of model type's metamodels
		 */
		List<EPackage> getMetamodels();
		
		/**
		 * 
		 * @return model type name
		 */
		String getModelTypeName();
		
		/**
		 * 
		 * @return type of appropriate parameter declaration in main(), may be <b>null</b>
		 */
		EClassifier getEntryType();
		
		/**
		 * 
		 * @return name of appropriate parameter declaration in main()
		 */
		String getEntryName();
	}
	
    String getModuleName() throws MdaException;

    Set<QvtConfigurationProperty> getConfigurationProperties() throws MdaException;
	
    EClass getIn()  throws MdaException;
    EClass getOut() throws MdaException;    
    List<TransformationParameter> getParameters() throws MdaException;

    TransformationRunner.Out run(TransformationRunner.In in) throws MdaException;
    
    EObject loadInput(URI inputObjectURI) throws MdaException;
}
