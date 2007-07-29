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
package org.eclipse.m2m.qvt.oml.generator;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;


public class Uml2GenAdapter implements IGenAdapter {

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
	}

	public boolean isApplicable(EStructuralFeature eStructuralFeature) {
		return isUml2Model(eStructuralFeature);
	}
	
	public String getFeatureGenName(EStructuralFeature eStructuralFeature, String genName) {
		if (!eStructuralFeature.isMany()) {
			return genName;
		}
		if (!isUml2Model(eStructuralFeature)) {
			return genName;
		}
		for (int i = 0; i < EXCLUDED_PLURALS.size(); i++) {
			if (EXCLUDED_PLURALS.get(i).equals(genName)) {
				return genName;
			}
		}
		if (!genName.endsWith("s")) { //$NON-NLS-1$
			if (genName.endsWith("y") && !isLetterYConsonant(genName)) { //$NON-NLS-1$
				genName = removeRedundantEnd(genName, "y"); //$NON-NLS-1$
				genName = genName.concat("ie"); //$NON-NLS-1$
			}
			genName = genName.concat("s"); //$NON-NLS-1$
		}
		return genName;
	}

	private boolean isUml2Model(EObject eObj) {
		EObject rootContainer = EcoreUtil.getRootContainer(eObj);
		if (false == rootContainer instanceof EPackage) {
			return false;
		}
		return ((EPackage) rootContainer).getNsURI().indexOf("uml2") != -1; //$NON-NLS-1$
	}

	private String removeRedundantEnd(String name, String redundant) {
		if (name.endsWith(redundant) && name.length() > redundant.length()) {
			name = name.substring(0, name.length() - redundant.length());
		}
		return name;
	}
	
	private boolean isLetterYConsonant(String name) {
		if (name.length() == 1) {
			return true;
		}
		char lastButOne = name.charAt(name.length() - 2);
		return "aeiouy".indexOf(lastButOne) >= 0; //$NON-NLS-1$
	}

	private static final List<String> EXCLUDED_PLURALS = Arrays.asList(new String[] {
			"children", //$NON-NLS-1$
			});

}
