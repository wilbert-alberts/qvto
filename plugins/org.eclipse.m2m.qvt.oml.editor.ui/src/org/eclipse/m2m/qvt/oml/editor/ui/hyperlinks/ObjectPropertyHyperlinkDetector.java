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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.qvt.oml.expressions.AssignExp;
import org.eclipse.m2m.qvt.oml.expressions.Property;
import org.eclipse.m2m.qvt.oml.internal.cst.ModulePropertyCS;
import org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.internal.cst.CSTNode;
import org.eclipse.ocl.internal.cst.FeatureCallExpCS;
import org.eclipse.ocl.internal.cst.SimpleNameCS;
import org.eclipse.ocl.internal.cst.VariableExpCS;
import org.eclipse.ocl.utilities.ASTNode;


@SuppressWarnings("restriction")
public class ObjectPropertyHyperlinkDetector implements IHyperlinkDetectorHelper {
	
	public IHyperlink detectHyperlink(IDetectionContext context) {

		CSTNode syntaxElement = context.getSyntaxElement();
		if (syntaxElement instanceof SimpleNameCS) {
			SimpleNameCS nameCS = (SimpleNameCS)context.getSyntaxElement();			
			
			if(syntaxElement.eContainer() instanceof PatternPropertyExpCS) {
				ASTNode astNode = ASTBindingHelper.resolveASTNode((PatternPropertyExpCS)syntaxElement.eContainer());			
				if(astNode instanceof AssignExp) {
					AssignExp assignExp  = (AssignExp) astNode;
					PropertyCallExp<EClassifier, EParameter> pcall = (PropertyCallExp<EClassifier, EParameter>)assignExp.getLeft();
					return new MetamodelElementHyperlink(HyperlinkUtil.createRegion(nameCS), (EStructuralFeature)pcall.getReferredProperty());				
				}
			} 
			else if(syntaxElement.eContainer() instanceof FeatureCallExpCS) {				
				FeatureCallExpCS featureCallExpCS = (FeatureCallExpCS) syntaxElement.eContainer();
				ASTNode featureASTNode = ASTBindingHelper.resolveASTNode(featureCallExpCS);
				
				if(featureASTNode instanceof PropertyCallExp) {
					PropertyCallExp<EClassifier, EStructuralFeature> propertyCallExp = (PropertyCallExp<EClassifier, EStructuralFeature>)featureASTNode;
					EStructuralFeature feature = propertyCallExp.getReferredProperty();
					return new MetamodelElementHyperlink(HyperlinkUtil.createRegion(nameCS), feature);		
					
				}
			} 
			else if(syntaxElement.eContainer() instanceof VariableExpCS) {
				ASTNode astVarExpNode = ASTBindingHelper.resolveASTNode(nameCS);
				if(astVarExpNode != null) {
					// property call
					if(astVarExpNode instanceof PropertyCallExp) {
						PropertyCallExp<EClassifier, EStructuralFeature> pcall = (PropertyCallExp<EClassifier, EStructuralFeature>) astVarExpNode;
						return new MetamodelElementHyperlink(HyperlinkUtil.createRegion(nameCS), (EStructuralFeature)pcall.getReferredProperty());
					}
					
					if(astVarExpNode instanceof VariableExp) {
						VariableExp variableExp = (VariableExp) astVarExpNode;
						Variable<EClassifier, EParameter> var = variableExp.getReferredVariable();

						if(var == null || var.getRepresentedParameter() == null) {
							return null;
						}

						EParameter param = var.getRepresentedParameter();
						// resolve module owned property
						if(param instanceof Property) {
							Property moduleProperty = (Property) param;
							CSTNode propertNodeCS = ASTBindingHelper.resolveCSTNode(moduleProperty);
							if(propertNodeCS instanceof ModulePropertyCS) {
								ModulePropertyCS modulePropertyCS = (ModulePropertyCS) propertNodeCS;
								CSTNode destNodeCST = modulePropertyCS.getSimpleNameCS() != null ? modulePropertyCS.getSimpleNameCS() : propertNodeCS; 
								IRegion declRegion = HyperlinkUtil.createRegion(destNodeCST);
								return new QvtFileHyperlink(HyperlinkUtil.createRegion(nameCS), 
										context.getModule().getSource(), declRegion, declRegion);
								
							}
						}
					}
				}				
			}			
		}
		
		return null;		
	}
}
