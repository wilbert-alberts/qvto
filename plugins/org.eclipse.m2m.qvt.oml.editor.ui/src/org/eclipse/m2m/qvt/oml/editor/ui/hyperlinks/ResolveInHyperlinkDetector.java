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
import org.eclipse.m2m.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.qvt.oml.expressions.ResolveInExp;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingRuleCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ResolveInExpCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.TypeCS;


/**
 * @author vrepeshko
 */
public class ResolveInHyperlinkDetector implements IHyperlinkDetectorHelper {

	public IHyperlink detectHyperlink(IDetectionContext context) {		
		CSTNode element = context.getSyntaxElement();
		
		if (element instanceof ResolveInExpCS) {
			ResolveInExpCS resolveInExpCS = (ResolveInExpCS) element;

			TypeCS type = resolveInExpCS.getInMappingType();		
			if(type != null && resolveInExpCS.getInMappingName() != null) {
				int mappingNameStartOffset = type.getEndOffset() + 3;
				int length = resolveInExpCS.getInMappingName().length();
				
				if(HyperlinkUtil.isOffsetInRange(context.getRegion().getOffset(), 
						mappingNameStartOffset, 
						mappingNameStartOffset + resolveInExpCS.getInMappingName().length())) {
					
					MappingDeclarationCS mappingDeclCS = findReferencedDefinitionCS(resolveInExpCS);
					if(mappingDeclCS != null) {
						CFile sourceFile = CSTHelper.getSourceFile(mappingDeclCS);
						if(sourceFile == null) {
							return null;
						}
						
						IRegion destReg = HyperlinkUtil.createRegion(getLinkDestinationNode(mappingDeclCS));
						return new QvtFileHyperlink(new Region(mappingNameStartOffset, length), sourceFile, destReg, destReg);
					}
				}
			}
		}
		
		return null;
	}
		
	public static MappingOperation findReferencedDefinition(ResolveInExpCS resolveInExpCS) {
		ResolveInExp resolveInAST = ASTBindingHelper.resolveASTNode(resolveInExpCS, ResolveInExp.class);
		if(resolveInAST != null && !resolveInAST.getInMappings().isEmpty()) {
			return resolveInAST.getInMappings().get(0);
		}
		
		return null;
	}
	
	private static MappingDeclarationCS findReferencedDefinitionCS(ResolveInExpCS resolveInExpCS) {
		MappingOperation mappingOperation = findReferencedDefinition(resolveInExpCS);
		if(mappingOperation != null) {
			MappingRuleCS mappingRuleCS = ASTBindingHelper.resolveCSTNode(mappingOperation, MappingRuleCS.class);
			if(mappingRuleCS != null) {
				return mappingRuleCS.getMappingDeclarationCS();
			}
		}
		
		return null;
	}	
	
	private static CSTNode getLinkDestinationNode(MappingDeclarationCS mappingDeclCS) {
		CSTNode linkDestCS = mappingDeclCS.getSimpleNameCS();
		if(linkDestCS == null) {
			linkDestCS = mappingDeclCS;
		}
		
		return linkDestCS;
	}
}
