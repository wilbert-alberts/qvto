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
package org.eclipse.m2m.qvt.oml.editor.ui.hovers;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.m2m.qvt.oml.expressions.AssignExp;
import org.eclipse.ocl.expressions.PropertyCallExp;


/**
 * @author vrepeshko
 */
public class PatternPropertyExpressionInfoProvider implements
		IElementInfoProvider {

	public String getElementInfo(final Object element, ITextViewer textViewer) {
		if (element instanceof AssignExp) {
			AssignExp patternPropertyExp = (AssignExp) element;
			if (patternPropertyExp.getLeft() instanceof PropertyCallExp) {
				//return NameUtil.buildPropertyName(((PropertyCallExp<EClassifier, EParameter>) patternPropertyExp.getLeft()).getReferredProperty(), null);
			}
		}
		return null;
	}

}
