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

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingMethodCS;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.utilities.ASTNode;


public class OperationHyperlinkDetector implements IHyperlinkDetectorHelper {
	
	public IHyperlink detectHyperlink(IDetectionContext context) {
		CSTNode syntaxElement = context.getSyntaxElement();
		
		if (syntaxElement instanceof SimpleNameCS) {
			SimpleNameCS nameCS = (SimpleNameCS)context.getSyntaxElement();						
			EOperation operation = resolveOperationDecl(nameCS);
			if(operation != null) {
				// handle specially operations defined in a QVT module
				MappingMethodCS methodCS = resolveMappingOperationDecl(nameCS);
				if(methodCS != null) {
					IRegion destRegion = getGoToOperationRegion(methodCS);
					CFile source = ASTBindingHelper.resolveModuleFile(CSTHelper.getModule(methodCS));
					return new QvtFileHyperlink(HyperlinkUtil.createRegion(nameCS), source, 
									destRegion, destRegion);
				}
				// proceed as with ordinary ecore metamodel operation
				return new MetamodelElementHyperlink(HyperlinkUtil.createRegion(nameCS), operation);						
			}
		}
		
		return null;		
	}
	

	public static EOperation resolveOperationDecl(SimpleNameCS nameCS) {
		if(nameCS.eContainer() instanceof OperationCallExpCS) {				
			OperationCallExpCS featureCallExpCS = (OperationCallExpCS)nameCS.eContainer();
			ASTNode featureASTNode = ASTBindingHelper.resolveASTNode(featureCallExpCS);
			
			if(featureASTNode instanceof OperationCallExp) {
				OperationCallExp operationCallExp = (OperationCallExp) featureASTNode;
				return operationCallExp.getReferredOperation();
			}
		} 
		return null;
	}
	
	
	public static MappingMethodCS resolveMappingOperationDecl(SimpleNameCS nameCS) {
		EOperation operation = resolveOperationDecl(nameCS);
		if(operation instanceof ImperativeOperation) {
			CSTNode resultCS = ASTBindingHelper.resolveCSTNode((ImperativeOperation) operation);
			return (resultCS instanceof MappingMethodCS) ? (MappingMethodCS) resultCS : null;
		}
		return null;
	}
	
	private IRegion getGoToOperationRegion(MappingMethodCS mappingMethodCS) {
		int startOffset = mappingMethodCS.getStartOffset();
		int length = 0;

		MappingDeclarationCS decl = mappingMethodCS.getMappingDeclarationCS();
		if(decl != null) { 
			SimpleNameCS simpleName = decl.getSimpleNameCS();
			length = simpleName != null ? simpleName.getValue().length() : length;

			TypeCS context = decl.getContextType();
			if(context != null) {
				startOffset = mappingMethodCS.getMappingDeclarationCS().getContextType().getEndOffset();
				startOffset += 3; // skip '::' qualified name delimiter
			} else {
				startOffset = simpleName.getStartOffset();
			}
		}
 
		return new Region(startOffset, length);
	}
}
