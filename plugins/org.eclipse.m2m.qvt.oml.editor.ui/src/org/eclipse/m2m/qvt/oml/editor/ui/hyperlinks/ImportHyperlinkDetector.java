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
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.qvt.oml.internal.cst.ModuleImportCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;

/**
 * @author vrepeshko
 */
public class ImportHyperlinkDetector implements IHyperlinkDetectorHelper {

	public IHyperlink detectHyperlink(IDetectionContext context) {
		CSTNode syntaxElement = context.getSyntaxElement();
		
		CFile sourceFile = findDefinition(syntaxElement);
		if(sourceFile != null) {			
			IRegion destRegion = new Region(0, 0); // point to the beginning

			ModuleImportCS importCS = getModuleImport(syntaxElement);
			CSTNode linkNodeCS = (importCS != null) ? importCS.getPathNameCS() : null;
			if(linkNodeCS == null) {
				linkNodeCS = syntaxElement;
			}
			
			IRegion hlinkReg = HyperlinkUtil.createRegion(linkNodeCS);			
			
			return new QvtFileHyperlink(hlinkReg, sourceFile, destRegion, destRegion);
		}
		
		return null;
	}
	
	public static CFile findDefinition(CSTNode syntaxElement) {		
		ModuleImportCS moduleImportCS = getModuleImport(syntaxElement);
		
		if ((syntaxElement instanceof ModuleImportCS)) {
			moduleImportCS = (ModuleImportCS) syntaxElement;
		} else if(syntaxElement instanceof PathNameCS && syntaxElement.eContainer() instanceof ModuleImportCS) {
			moduleImportCS = (ModuleImportCS) syntaxElement.eContainer();
		}

		if(moduleImportCS != null) {
			ModuleImport moduleImportAST = ASTBindingHelper.resolveASTNode(moduleImportCS, ModuleImport.class);
			if(moduleImportAST != null && moduleImportAST.getImportedModule() != null) {
				return ASTBindingHelper.resolveModuleFile(moduleImportAST.getImportedModule());
			}
		}
		
		return null;
	}

	private static ModuleImportCS getModuleImport(CSTNode syntaxElement) {
		ModuleImportCS importCS = null;		
		if ((syntaxElement instanceof ModuleImportCS)) {
			importCS = (ModuleImportCS) syntaxElement;
		} else if(syntaxElement instanceof PathNameCS && syntaxElement.eContainer() instanceof ModuleImportCS) {
			importCS = (ModuleImportCS) syntaxElement.eContainer();
		}
		return importCS;
	}
	
}
