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

import java.util.Arrays;
import java.util.List;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTSyntheticNode;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTSyntheticNodeAccess;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.ConstructorOperationAdapter;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.InstantiationExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLPGParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.InstantiationExp;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.EnumLiteralExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.ecore.EnumLiteralExp;


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
			CSTNode cstNode = ASTBindingHelper.resolveCSTNode(element, CSTNode.class);
			if(cstNode == null) {
				ASTSyntheticNode referencedDefinitionAST = ASTSyntheticNodeAccess.getASTNode(element);
				if(referencedDefinitionAST != null) {
					cstNode = ASTSyntheticNodeAccess.getCST(referencedDefinitionAST, CSTNode.class);
				}
			}
			if(cstNode != null) {
				URI sourceURI = CSTHelper.getSourceFile(cstNode);
				if(sourceURI != null) {
					if(cstNode instanceof ModelTypeCS) {
						// TODO - use QVT model Switch to get destination region specific to various CST							
						cstNode = ((ModelTypeCS) cstNode).getIdentifierCS();  
					} else if(cstNode instanceof MappingModuleCS) {
						MappingModuleCS moduleCS = (MappingModuleCS) cstNode;
						if(moduleCS.getHeaderCS() != null) {
							cstNode = moduleCS.getHeaderCS(); 
						}
					} else if(cstNode instanceof ClassifierDefCS) {
						cstNode = ((ClassifierDefCS) cstNode).getSimpleNameCS();
					}
					IRegion destReg = HyperlinkUtil.createRegion(cstNode);
					return new QvtFileHyperlink(elementRef.sourceLinkRegion, sourceURI, destReg, destReg);
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
		Object astObj = syntaxElement.getAst();
		
		if(astObj instanceof EClassifier) {
			if (syntaxElement instanceof SimpleNameCS) {			
				if(astObj instanceof EModelElement) {
					return new EModelElementRef((EModelElement)astObj, HyperlinkUtil.createRegion(syntaxElement));
				}
			} else if (syntaxElement instanceof PathNameCS && !isConstructorCS(syntaxElement)) {						
				if(astObj instanceof ENamedElement) {
					PathNameCS pathNameCS  = (PathNameCS) syntaxElement;	

					int[] selectedNamePos = new int[1];
					//IRegion resultRegion = refineRegion(pathNameCS, region, selectedNamePos);
					IRegion resultRegion = getPathRegion(pathNameCS, region, selectedNamePos);					
					if(resultRegion != null) {
						ENamedElement ast = (ENamedElement) pathNameCS.getAst();
						int pos = selectedNamePos[0];
						final EList<String> csNames = pathNameCS.getSequenceOfNames();
						
						if(pos >= 0 && pos < csNames.size() - 1) {
							QvtOperationalEnv env = getEnv(pathNameCS);

							final List<String> selectedNames = csNames.subList(0, pos + 1);
							
							ast = env.lookupClassifier(selectedNames);
							if(ast == null) {
								ast = env.lookupPackage(selectedNames);
							}
						}
						
						if(ast != null) {
							return new EModelElementRef(ast, resultRegion);
						}
					}
				}
			}
		} else if(syntaxElement instanceof EnumLiteralExpCS) {
			if(astObj instanceof EnumLiteralExp == false) {
				return null;
			}

			EnumLiteralExpCS enumExpCS = (EnumLiteralExpCS) syntaxElement;
			EnumLiteralExp enumExpAST = (EnumLiteralExp) enumExpCS.getAst();
			EEnumLiteral enumLit = enumExpAST.getReferredEnumLiteral();			
			if(enumLit != null) {
				CSTNode linkCS = enumExpCS.getSimpleNameCS();
				if(linkCS == null) {
					linkCS = enumExpCS;
				}

				return new EModelElementRef(enumLit, HyperlinkUtil.createRegion(linkCS));
			}
		}
		
		return null;
	}	
	
	private static boolean isConstructorCS(CSTNode syntaxElement) {
		if (false == syntaxElement.eContainer() instanceof InstantiationExpCS) {
			return false;
		}
		InstantiationExpCS constructorCS = (InstantiationExpCS) syntaxElement.eContainer();
		if (false == constructorCS.getAst() instanceof InstantiationExp) {
			return false;
		}
		InstantiationExp instExp = (InstantiationExp) constructorCS.getAst();
		Adapter adapter = EcoreUtil.getAdapter(instExp.eAdapters(), ConstructorOperationAdapter.class);
		return adapter != null && ((ConstructorOperationAdapter) adapter).getReferredConstructor() != null;
	}

	
	private static IRegion getPathRegion(PathNameCS pathNameCS, IRegion selection, int[] selectedPos) {
		int[] positions = getPathPos(pathNameCS);		
		if(positions == null) {
			return HyperlinkUtil.createRegion(pathNameCS); 
		}
			
		int nameOffset = pathNameCS.getStartOffset();
		int i = 0;
		for (String name : pathNameCS.getSequenceOfNames()) {
			int offset = selection.getOffset();
			if(nameOffset <= offset && offset <= nameOffset + name.length()) {
				selectedPos[0] = i;				
				return new Region(nameOffset, name.length());
			}

			if(i == positions.length) {
				break;
			}
			
			nameOffset = positions[i++];			
		}
		
		return HyperlinkUtil.createRegion(pathNameCS);
	}
	
	private static int[] getPathPos(PathNameCS pathNameCS) {		
		EList<String> sequenceOfNames = pathNameCS.getSequenceOfNames();
		if(sequenceOfNames.size() == 1) {
			return null;
		}
		
		int size = sequenceOfNames.size() - 1;
		int[] positions = new int[size];
		Arrays.fill(positions, -1);
		
		IToken startToken = pathNameCS.getStartToken();
		IToken endToken = pathNameCS.getEndToken();
		
		PrsStream prsStream = startToken.getPrsStream();
		IToken nextToken = startToken;
		
		int tokenIndex = 1;
		int i = 0;		
		while(nextToken != endToken) {
			nextToken = prsStream.getIToken(startToken.getTokenIndex() + tokenIndex++);
			if(nextToken.getKind() == QvtOpLPGParsersym.TK_IDENTIFIER) {
				positions[i++] = nextToken.getStartOffset();
				if(i == positions.length) {
					// safety exit in case we have inconsistent start end token
					break;
				}
			}
		}

		return positions;
	}
	
	private static QvtOperationalEnv getEnv(CSTNode node) {
		return (QvtOperationalEnv)CSTHelper.getEnvironment(node);
	}	
}
