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

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.m2m.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.qvt.oml.editor.ui.hyperlinks.PathNameHyperlinkDetector;
import org.eclipse.m2m.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.qvt.oml.expressions.PackageRef;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.EcoreEnvironment;


public class PathNameInfoProvider implements IElementInfoProvider {

	public String getElementInfo(final Object element, ITextViewer textViewer, IRegion region) {
		if (element instanceof CSTNode) {
			CSTNode syntaxElement = (CSTNode) element;
			EModelElement referencedElement = PathNameHyperlinkDetector.findReferencedElementDefinition(syntaxElement, region);
			if(referencedElement instanceof ModelType) {
				StringBuilder buf = new StringBuilder();
				int counter = 0;
				ModelType modelType = (ModelType) referencedElement;
				for (PackageRef nextPackRef : modelType.getMetamodel()) {
					if(counter > 0) {						
						buf.append('\n');
					}
					
					if(nextPackRef.getName() != null) {
						buf.append(nextPackRef.getName());
					}
					
					if(nextPackRef.getUri() != null) {
						buf.append(" - ").append(nextPackRef.getUri()); //$NON-NLS-1$
					}
					
					counter++;
				}
				
				return buf.toString();
			} 

			EcoreEnvironment env = CSTHelper.getEnvironment(syntaxElement);
			if(env != null) {
				return env.getUMLReflection().getQualifiedName(referencedElement);
			}
		}
		
		return null;
	}	
}
