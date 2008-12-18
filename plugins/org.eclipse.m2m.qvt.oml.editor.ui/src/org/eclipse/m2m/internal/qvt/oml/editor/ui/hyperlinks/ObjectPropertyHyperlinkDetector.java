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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTSyntheticNode;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTSyntheticNodeAccess;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.LocalPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.temp.ScopedNameCS;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.FeatureCallExpCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.VariableExpCS;
import org.eclipse.ocl.ecore.TupleType;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.utilities.ASTNode;


public class ObjectPropertyHyperlinkDetector implements IHyperlinkDetectorHelper {
	
	public IHyperlink detectHyperlink(IDetectionContext context) {
		CSTNode syntaxElement = context.getSyntaxElement();
		EStructuralFeature referredFeature = findDefinition(syntaxElement);
			
		if(referredFeature != null) {
			ModulePropertyCS propertyCS = findDefinitionCS(referredFeature);
			if(propertyCS != null) {
				CFile sourceFile = CSTHelper.getSourceFile(propertyCS);
				CSTNode destNodeCS = (propertyCS.getSimpleNameCS() != null) ? propertyCS.getSimpleNameCS() : propertyCS;
				IRegion destRegion = HyperlinkUtil.createRegion(destNodeCS);						
				return new QvtFileHyperlink(HyperlinkUtil.createRegion(syntaxElement), sourceFile, destRegion, destRegion);	
			}
			
			return new MetamodelElementHyperlink(HyperlinkUtil.createRegion(syntaxElement), referredFeature);
		}
		
		return null;
	}
	
	public static ModulePropertyCS findDefinitionCS(EStructuralFeature referencedFeature) {
		ModulePropertyCS referencedDefinitionCS;
		ASTSyntheticNode referencedDefinitionAST = ASTSyntheticNodeAccess.getASTNode(referencedFeature);
		if(referencedDefinitionAST != null) {
			referencedDefinitionCS = ASTSyntheticNodeAccess.getCST(referencedDefinitionAST, ModulePropertyCS.class);
		} else {
			referencedDefinitionCS = ASTBindingHelper.resolveCSTNode(referencedFeature, ModulePropertyCS.class);
		}
		return referencedDefinitionCS;
	}
	
	public static EStructuralFeature findDefinition(CSTNode syntaxElement) {
		if (syntaxElement instanceof SimpleNameCS) {
			EStructuralFeature result = findDefinition((SimpleNameCS) syntaxElement);
			if(result instanceof TupleType) {
				return null;
			}
			
			return result;
		} else if(syntaxElement instanceof ScopedNameCS) {
			if(syntaxElement.eContainingFeature() == CSTPackage.eINSTANCE.getContextualPropertyCS_ScopedNameCS()) {
				return ASTBindingHelper.resolveASTNode((CSTNode)syntaxElement.eContainer(), ContextualProperty.class);
			}			
		}
		
		return null;
	}
		
	@SuppressWarnings("unchecked")
	private static EStructuralFeature findDefinition(SimpleNameCS nameCS) {
		if(nameCS.eContainingFeature() == CSTPackage.eINSTANCE.getModulePropertyCS_SimpleNameCS()) {
			return (EStructuralFeature)((CSTNode)nameCS.eContainer()).getAst();
		} 
		
		if(nameCS.eContainer() instanceof FeatureCallExpCS) {
			ASTNode featureASTNode = directGetASTNode(nameCS);			
			if(featureASTNode instanceof PropertyCallExp) {
				PropertyCallExp<EClassifier, EStructuralFeature> propertyCallExp = (PropertyCallExp<EClassifier, EStructuralFeature>)featureASTNode;
				return propertyCallExp.getReferredProperty();												
			}
		} 
		else if(nameCS.eContainer() instanceof VariableExpCS) {
			ASTNode astVarExpNode = ASTBindingHelper.resolveASTNode(nameCS);
			if(astVarExpNode != null) {
				// property call
				if(astVarExpNode instanceof PropertyCallExp) {
					PropertyCallExp<EClassifier, EStructuralFeature> pcall = (PropertyCallExp<EClassifier, EStructuralFeature>) astVarExpNode;
					return pcall.getReferredProperty();
				}
			}
		} else if(nameCS.eContainer() instanceof LocalPropertyCS) {
			LocalPropertyCS localPropertyCS = (LocalPropertyCS) nameCS.eContainer(); 
			if(localPropertyCS.getAst() instanceof EStructuralFeature) {
				return (EStructuralFeature) localPropertyCS.getAst();
			}
		}
				
		return null;	
	}
	
	private static ASTNode directGetASTNode(CSTNode cstNode) {
		Object ast = cstNode.getAst();		
		return ast instanceof ASTNode ? (ASTNode) ast : null;
	}
}
