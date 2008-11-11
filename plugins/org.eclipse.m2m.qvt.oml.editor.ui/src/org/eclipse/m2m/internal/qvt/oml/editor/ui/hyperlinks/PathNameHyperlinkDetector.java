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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.EnumLiteralExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.ecore.EnumLiteralExp;
import org.eclipse.ocl.utilities.ASTNode;


/**
 * @author vrepeshko
 */
public class PathNameHyperlinkDetector implements IHyperlinkDetectorHelper {

	private static class EModelElementRef {
		final EModelElement element;
		final IRegion sourceLinkRegion;
		
		private EModelElementRef(EModelElement element, IRegion sourceLinkRegion) {
			this.element = element;
			this.sourceLinkRegion = sourceLinkRegion;
		}		
	}
	
	public IHyperlink detectHyperlink(IDetectionContext context) {		
		CSTNode syntaxElement = context.getSyntaxElement();		
		EModelElementRef elementRef = findReferencedMetamodelElement(syntaxElement, context.getRegion());
		
		if(elementRef != null) {
			EModelElement element = elementRef.element;
			if(element instanceof ASTNode) {
				ASTNode elementAST = (ASTNode) element;
				CSTNode cstNode = ASTBindingHelper.resolveCSTNode(elementAST, CSTNode.class);
				if(cstNode != null) {
					CFile file = CSTHelper.getSourceFile(cstNode);
					if(file != null) {
						if(cstNode instanceof ModelTypeCS) {
							// TODO - use QVT model Switch to get destination region specific to various CST							
							cstNode = ((ModelTypeCS) cstNode).getIdentifierCS();  
						} else if(cstNode instanceof MappingModuleCS) {
							MappingModuleCS moduleCS = (MappingModuleCS) cstNode;
							if(moduleCS.getHeaderCS() != null) {
								cstNode = moduleCS.getHeaderCS(); 
							}
						}
						IRegion destReg = HyperlinkUtil.createRegion(cstNode);
						return new QvtFileHyperlink(elementRef.sourceLinkRegion, file, destReg, destReg);
					}
				}
			} 
			
			return new MetamodelElementHyperlink(elementRef.sourceLinkRegion, elementRef.element);			
		}

		return null;
	}
	
	public static EModelElement findReferencedElementDefinition(CSTNode syntaxElement, IRegion region) {
		EModelElementRef ref = findReferencedMetamodelElement(syntaxElement, region);
		return (ref != null) ? ref.element : null;
	}
	
	private static EModelElementRef findReferencedMetamodelElement(CSTNode syntaxElement, IRegion region) {
		PathNameCS pathNameCS = null;
		if (syntaxElement instanceof PathNameCS) {
			pathNameCS = (PathNameCS) syntaxElement;
			
			if(pathNameCS.getSequenceOfNames().size() > 0) {
				int startOffset = pathNameCS.getStartOffset();
				int firstElementLength = pathNameCS.getSequenceOfNames().get(0).length();
				
				if(HyperlinkUtil.isOffsetInRange(region.getOffset(), startOffset, startOffset + firstElementLength)) {				
					QvtOperationalEnv env = getEnv(pathNameCS);
					if(env != null) {
						ModelType modeltype = env.getModelType(pathNameCS.getSequenceOfNames());						
						if(modeltype != null) {
							IRegion linkReg = new Region(pathNameCS.getStartOffset(), firstElementLength);
							return new EModelElementRef(modeltype, linkReg);
						}
					}
				}
			}
			
			return findPathNameReferencedElement(pathNameCS, region);
		} 
		else if(syntaxElement instanceof EnumLiteralExpCS) {
			EnumLiteralExpCS enumExpCS = (EnumLiteralExpCS) syntaxElement;
			EnumLiteralExp enumExpAST = ASTBindingHelper.resolveASTNode(enumExpCS, EnumLiteralExp.class);
			if(enumExpAST != null && enumExpAST.getReferredEnumLiteral() != null) {
				EEnumLiteral enumLit = enumExpAST.getReferredEnumLiteral();
				CSTNode linkCS = enumExpCS.getSimpleNameCS();
				if(linkCS == null) {
					linkCS = enumExpCS;
				}

				return new EModelElementRef(enumLit, HyperlinkUtil.createRegion(linkCS));
			}
		}
		
		return null;
	}
	
	private static EModelElementRef findPathNameReferencedElement(PathNameCS pathName, IRegion region) {
		if(pathName.getSequenceOfNames().isEmpty()) {
			return null;
		}
		
		QvtOperationalEnv env = getEnv(pathName);
		if(env != null) {
			List<String> namesToLookup = new LinkedList<String>();
			IRegion linkRegion = findElementInPathName(pathName, region, namesToLookup);
			
			boolean isPackageReferred = namesToLookup.size() < pathName.getSequenceOfNames().size();			
			EModelElement element = (isPackageReferred) ? env.lookupPackage(namesToLookup) : env.lookupClassifier(namesToLookup);
// ? Not needed as the env lookup should resolve names qualified with modeltypes as well 
//			if(element == null) {
//				ModelType modelType = env.getModelType(namesToLookup);
//				if(modelType != null) {
//					EList<EPackage> metamodels = modelType.getMetamodel();
//					if(!metamodels.isEmpty()) {
//						for (EPackage nextPackage : metamodels) {
//							String uri = nextPackage.getNsURI();
//							element = env.getEPackageRegistry().getEPackage(uri);							
//						}
//					}
//				}
//			}

			if(element != null) {
				return new EModelElementRef(element, linkRegion);
			}
		}
		
		return null;
	}
	
	
	private static IRegion findElementInPathName(PathNameCS pathNameCS, IRegion selectedRegion, List<String> pathToLookup) {
		int startOffset = pathNameCS.getStartOffset();
		int endOffset = startOffset;		
		
		int index = 0;
		for (String segment : pathNameCS.getSequenceOfNames()) {
			pathToLookup.add(segment);
			
			if(index > 0) {
				startOffset = endOffset + "::".length(); //$NON-NLS-1$
			}
			endOffset = startOffset + segment.length();

			if(selectedRegion.getOffset() >= startOffset && selectedRegion.getOffset() <= endOffset && 
				selectedRegion.getLength() <= endOffset - startOffset) {
				return new Region(startOffset, endOffset - startOffset);
			}
			
			index++;
		}
		return HyperlinkUtil.createRegion(pathNameCS);
	}
	
	private static QvtOperationalEnv getEnv(CSTNode node) {
		return (QvtOperationalEnv)CSTHelper.getEnvironment(node);
	}	
}
