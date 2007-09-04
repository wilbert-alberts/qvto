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
package org.eclipse.m2m.qvt.oml.editor.ui.hyperlinks;


import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.qvt.oml.internal.cst.ModuleImportCS;
import org.eclipse.ocl.internal.cst.CSTNode;
import org.eclipse.ocl.internal.cst.PathNameCS;

/**
 * @author vrepeshko
 */
public class ImportHyperlinkDetector implements IHyperlinkDetectorHelper {

	public IHyperlink detectHyperlink(IDetectionContext context) {
		CSTNode syntaxElement = context.getSyntaxElement();
		ModuleImportCS moduleImportCS = null;
		
		if ((syntaxElement instanceof ModuleImportCS)) {
			moduleImportCS = (ModuleImportCS) syntaxElement;
		} else if(syntaxElement instanceof PathNameCS && syntaxElement.eContainer() instanceof ModuleImportCS) {
			moduleImportCS = (ModuleImportCS) syntaxElement.eContainer();
		}

		if(moduleImportCS != null) {
			ModuleImport moduleImportAST = ASTBindingHelper.resolveASTNode(moduleImportCS, ModuleImport.class);
			if(moduleImportAST != null && moduleImportAST.getImportedModule() != null) {
				CFile sourceFile = ASTBindingHelper.resolveModuleFile(moduleImportAST.getImportedModule());
				if(sourceFile != null) {
					IRegion destRegion = new Region(0, 0);
					return new QvtFileHyperlink(HyperlinkUtil.createRegion(moduleImportCS.getPathNameCS()), sourceFile, destRegion, destRegion);
				}
			}
		}
		
		return null;
	}
}
