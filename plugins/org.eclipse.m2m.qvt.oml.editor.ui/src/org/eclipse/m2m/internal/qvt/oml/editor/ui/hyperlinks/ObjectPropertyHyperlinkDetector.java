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
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.PatternPropertyExpCS;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.qvt.oml.expressions.AssignExp;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.expressions.Property;
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
			Property prop = getASTProperty(referredFeature);
			if(prop != null) {
				ModulePropertyCS propertyCS = ASTBindingHelper.resolveCSTNode(prop, ModulePropertyCS.class);
				if(propertyCS != null) {
					CFile sourceFile = CSTHelper.getSourceFile(propertyCS);
					CSTNode destNodeCS = (propertyCS.getSimpleNameCS() != null) ? propertyCS.getSimpleNameCS() : propertyCS;
					IRegion destRegion = HyperlinkUtil.createRegion(destNodeCS);						
					return new QvtFileHyperlink(HyperlinkUtil.createRegion(syntaxElement), sourceFile, destRegion, destRegion);	
				}
			}
			
			return new MetamodelElementHyperlink(HyperlinkUtil.createRegion(syntaxElement), referredFeature);
		}
		
		return null;
	}	
	
	public static EStructuralFeature findDefinition(CSTNode syntaxElement) {
		if (syntaxElement instanceof SimpleNameCS) {
			EStructuralFeature result = findDefinition((SimpleNameCS) syntaxElement);
			if(result instanceof TupleType) {
				return null;
			}				
			
			return result;
		}
		
		return null;
	}

	
	private static Property getASTProperty(EStructuralFeature feature) {
		if(feature.eContainer() instanceof Module) {
			Module module = (Module)feature.eContainer();
			for (Property prop : module.getConfigProperty()) {
				String featureName = feature.getName(); 				
				if(featureName != null && featureName.equals(prop.getName())) {
					return prop;
				}
			}
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private static EStructuralFeature findDefinition(SimpleNameCS nameCS) {
		if(nameCS.eContainer() instanceof PatternPropertyExpCS) {
			ASTNode astNode = ASTBindingHelper.resolveASTNode((PatternPropertyExpCS)nameCS.eContainer());			
			if(astNode instanceof AssignExp) {
				AssignExp assignExp  = (AssignExp) astNode;
				PropertyCallExp<EClassifier, EStructuralFeature> pcall = (PropertyCallExp<EClassifier, EStructuralFeature>)assignExp.getLeft();
				if(pcall instanceof PropertyCallExp) {
					return pcall.getReferredProperty();
				}				
			}
		} 
		else if(nameCS.eContainer() instanceof FeatureCallExpCS) {				
			FeatureCallExpCS featureCallExpCS = (FeatureCallExpCS) nameCS.eContainer();
			ASTNode featureASTNode = ASTBindingHelper.resolveASTNode(featureCallExpCS);
			
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
		} 			
		
		return null;	
	}
}
