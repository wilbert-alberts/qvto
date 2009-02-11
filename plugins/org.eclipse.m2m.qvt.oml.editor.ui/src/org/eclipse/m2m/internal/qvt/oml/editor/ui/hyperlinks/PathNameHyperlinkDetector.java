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

import java.util.List;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.compiler.ConstructorOperationAdapter;
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
					} else if(cstNode instanceof ClassifierDefCS) {
						cstNode = ((ClassifierDefCS) cstNode).getSimpleNameCS();
					}
					IRegion destReg = HyperlinkUtil.createRegion(cstNode);
					return new QvtFileHyperlink(elementRef.sourceLinkRegion, file, destReg, destReg);
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
					IRegion resultRegion = refineRegion(pathNameCS, region, selectedNamePos);
					if(resultRegion != null) {
						ENamedElement ast = (ENamedElement) pathNameCS.getAst();
						if(selectedNamePos[0] >= 0) {
							QvtOperationalEnv env = getEnv(pathNameCS);
							final EList<String> csNames = pathNameCS.getSequenceOfNames();
							final List<String> selectedNames = csNames.subList(0, selectedNamePos[0] + 1);
							
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

	private static IRegion refineRegion(PathNameCS pathNameCS, IRegion selection, int[] selectedNamePos) {
		if(pathNameCS.getSequenceOfNames().size() == 1) {
			return HyperlinkUtil.createRegion(pathNameCS);
		}
		selectedNamePos[0] = -1;
		IToken startToken = pathNameCS.getStartToken();
		IToken endToken = pathNameCS.getEndToken();
		
		if(startToken == null || endToken == null) {
			return null;
		}
		
		int size = pathNameCS.getSequenceOfNames().size();
		if(size == 1) {
			return null;
		} else if(size == 1) {
			return HyperlinkUtil.createRegion(pathNameCS);
		}
		
		PrsStream prsStream = startToken.getPrsStream();		
		IToken nextToken = startToken;

		int namePos = 0;
		int offset = selection.getOffset();
		IToken result = null;		
		while(true) {			
			if(nextToken.getStartOffset() <= offset && nextToken.getEndOffset() >= offset) {
				result = nextToken;
				break;
			}
			 
			if(nextToken == endToken) {
				break;
			}
			
			if(nextToken.getKind() == QvtOpLPGParsersym.TK_IDENTIFIER) {
				namePos++;
			}
			nextToken = prsStream.getIToken(nextToken.getTokenIndex() + 1);
		}
		
		if(result != null) {
			int kind = result.getKind();
			if(kind == QvtOpLPGParsersym.TK_COLONCOLON) {				
				return HyperlinkUtil.createRegion(pathNameCS);
			} else if(kind == QvtOpLPGParsersym.TK_IDENTIFIER) {
				selectedNamePos[0] = namePos;
				return new Region(result.getStartOffset(), 
						result.getEndOffset() - result.getStartOffset() + 1);
			}
		}
		
		return null;
	}

	private static QvtOperationalEnv getEnv(CSTNode node) {
		return (QvtOperationalEnv)CSTHelper.getEnvironment(node);
	}	
}
