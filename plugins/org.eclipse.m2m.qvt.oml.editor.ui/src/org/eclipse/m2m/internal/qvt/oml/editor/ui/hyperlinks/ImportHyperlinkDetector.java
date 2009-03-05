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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.hyperlinks;


import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportCS;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;

/**
 * @author vrepeshko
 */
public class ImportHyperlinkDetector implements IHyperlinkDetectorHelper {

	public IHyperlink detectHyperlink(IDetectionContext context) {
		CSTNode syntaxElement = context.getSyntaxElement();
		
		URI sourceFileURI = findDefinition(syntaxElement);
		if(sourceFileURI != null) {			
			IRegion destRegion = new Region(0, 0); // point to the beginning

			ImportCS importCS = getImport(syntaxElement);
			CSTNode linkNodeCS = (importCS != null) ? importCS.getPathNameCS() : null;
			if(linkNodeCS == null) {
				linkNodeCS = syntaxElement;
			}
			
			IRegion hlinkReg = HyperlinkUtil.createRegion(linkNodeCS);						
			return new QvtFileHyperlink(hlinkReg, sourceFileURI, destRegion, destRegion);
		}
		
		return null;
	}
	
	public static URI findDefinition(CSTNode syntaxElement) {		
		ImportCS ImportCS = getImport(syntaxElement);
		
		if ((syntaxElement instanceof ImportCS)) {
			ImportCS = (ImportCS) syntaxElement;
		} else if(syntaxElement instanceof PathNameCS && syntaxElement.eContainer() instanceof ImportCS) {
			ImportCS = (ImportCS) syntaxElement.eContainer();
		}

		if(ImportCS != null) {
			ModuleImport moduleImportAST = ASTBindingHelper.resolveASTNode(ImportCS, ModuleImport.class);
			if(moduleImportAST != null && moduleImportAST.getImportedModule() != null) {
				return ASTBindingHelper.resolveModuleFile(moduleImportAST.getImportedModule());
			}
		}
		
		return null;
	}

	private static ImportCS getImport(CSTNode syntaxElement) {
		ImportCS importCS = null;		
		if ((syntaxElement instanceof ImportCS)) {
			importCS = (ImportCS) syntaxElement;
		} else if(syntaxElement instanceof PathNameCS && syntaxElement.eContainer() instanceof ImportCS) {
			importCS = (ImportCS) syntaxElement.eContainer();
		}
		return importCS;
	}
	
}
