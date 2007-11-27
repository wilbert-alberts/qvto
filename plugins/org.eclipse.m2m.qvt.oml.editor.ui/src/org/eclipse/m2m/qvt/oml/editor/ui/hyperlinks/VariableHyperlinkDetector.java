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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.qvt.oml.internal.cst.ParameterDeclarationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.VariableInitializationCS;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.cst.VariableExpCS;
import org.eclipse.ocl.utilities.ASTNode;


@SuppressWarnings("restriction")
public class VariableHyperlinkDetector implements IHyperlinkDetectorHelper {
	
	@SuppressWarnings("unchecked")
	public IHyperlink detectHyperlink(IDetectionContext context) {

		CSTNode syntaxElement = context.getSyntaxElement();
		if (syntaxElement instanceof SimpleNameCS) {
			SimpleNameCS nameCS = (SimpleNameCS)context.getSyntaxElement();			
			CSTNode varDeclElement = resolveVariableDeclaration(nameCS);
			
			CSTNode targetCS = null;			
			
			if(varDeclElement instanceof ParameterDeclarationCS) {
				ParameterDeclarationCS paramDeclCS = (ParameterDeclarationCS) varDeclElement;
				SimpleNameCS paramNameCS = paramDeclCS.getSimpleNameCS();
				if(paramNameCS != null && paramNameCS.getValue() != null) {
					targetCS = paramNameCS;
				}
			} else if(varDeclElement instanceof VariableInitializationCS) {
				// resolve declared variable
				VariableInitializationCS varDecl = (VariableInitializationCS)varDeclElement;
				SimpleNameCS varName = varDecl.getSimpleNameCS();
				if(varName != null && varName.getValue() != null) {
					targetCS = varName;
				}
			} else if(varDeclElement instanceof VariableCS) {
				targetCS = varDeclElement;
			}
			
			if(targetCS != null) {
				IRegion linkRegion = HyperlinkUtil.createRegion(nameCS);
				IRegion targetRegion = HyperlinkUtil.createRegion(targetCS);
				return new QvtFileHyperlink(linkRegion, context.getModule().getSource(), targetRegion, targetRegion); 
			}
		}
		
		return null;		
	}
	
	/**
	 * @return <code>VariableInitializationCS</code> or <code>ParameterDeclarationCS</code> if successfully
	 * 	resolve, <code>null</code> otherwise.
	 */
	public static CSTNode resolveVariableDeclaration(SimpleNameCS nameCS) {
		if(nameCS.eContainer() instanceof VariableExpCS) {
			ASTNode varExpNodeAS = ASTBindingHelper.resolveASTNode(nameCS);
			
			if(varExpNodeAS instanceof VariableExp) {
				VariableExp variableExp = (VariableExp) varExpNodeAS;
				Variable<EClassifier, EParameter> var = variableExp.getReferredVariable();

				if(var != null) {
					if(var.getRepresentedParameter() != null) {
						EParameter param = var.getRepresentedParameter();
						
						if(param instanceof VarParameter) {
							// resolve operation parameter reference
							VarParameter varParam = (VarParameter) param;
							CSTNode paramCS = ASTBindingHelper.resolveCSTNode(varParam);
							if(paramCS instanceof ParameterDeclarationCS) {
								ParameterDeclarationCS paramDeclCS = (ParameterDeclarationCS) paramCS;
								return paramDeclCS;
							}
						}
					}
					
					CSTNode cstVarNode = ASTBindingHelper.resolveCSTNode(var);
					if(cstVarNode instanceof VariableInitializationCS) {
						// resolve declared variable
						VariableInitializationCS varDecl = (VariableInitializationCS) cstVarNode;
						return varDecl;						
						
					} else if(cstVarNode instanceof VariableCS) {					
						return cstVarNode;
					}
				}
			}
		}			
		
		return null;
	}	
}
