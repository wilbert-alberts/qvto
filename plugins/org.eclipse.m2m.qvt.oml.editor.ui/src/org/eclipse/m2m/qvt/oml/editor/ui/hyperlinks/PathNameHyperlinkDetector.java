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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.qvt.oml.expressions.PackageRef;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ModuleImportCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TypeCS;


/**
 * @author vrepeshko
 */
@SuppressWarnings("restriction")
public class PathNameHyperlinkDetector implements IHyperlinkDetectorHelper {

	public IHyperlink detectHyperlink(IDetectionContext context) {		
		PathNameCS pathNameCS = null;
				
		if (context.getSyntaxElement() instanceof ModelTypeCS && context.getSyntaxElement().eContainer() instanceof MappingModuleCS) {
			MappingModuleCS moduleCS = (MappingModuleCS) context.getSyntaxElement().eContainer();
			for (ModelTypeCS modelTypeCS : moduleCS.getMetamodels()) {
				if(modelTypeCS != context.getSyntaxElement() || modelTypeCS.getPackageRefs().isEmpty()) {
					continue;
				}
				// we have detected metamodel import
				QvtOperationalEnv env = getEnv(context.getSyntaxElement());
				if(env != null) {
					try {
						StringLiteralExpCS uriLiteral = modelTypeCS.getPackageRefs().get(0).getUriCS();
						if(uriLiteral == null) {
							return null;
						}
						String id = uriLiteral.getStringSymbol();
						// strip quotations
						id = id.substring(1, id.length() - 1);
						EPackage ePackage = env.getMetamodelRegistry().getMetamodelDesc(id).getModel();
						return new MetamodelElementHyperlink(HyperlinkUtil.createRegion(modelTypeCS), ePackage);
					} catch (EmfException e) {
						// do nothing, a metamodel may not have been resolved
					}
				}
			}
		}		
		
		if (context.getSyntaxElement() instanceof PathNameCS) {
			pathNameCS = (PathNameCS) context.getSyntaxElement();
			return findHyperLink(pathNameCS, context);

		} else if (context.getSyntaxElement() instanceof ModuleImportCS) {			
			ModuleImportCS importCS = (ModuleImportCS) context.getSyntaxElement(); 
			if(importCS.getPathNameCS() != null) {
				return findHyperLink(pathNameCS, context);
			}
			
//		} else if (element instanceof PathNameExpCS) {
//			pathNameAS = ((PathNameExpCS) element).getPathName();
		} else if (context.getSyntaxElement() instanceof MappingDeclarationCS) {
			TypeCS contextType = ((MappingDeclarationCS) context.getSyntaxElement()).getContextType();
			if (contextType instanceof PathNameCS) {
				pathNameCS = (PathNameCS) contextType;
			}
		}
		if (!HyperlinkUtil.isValidElement(pathNameCS)) {
			return null;
		}
//		Environment environment = (Environment) data.getSyntaxToEnvironmentMap().get(analyzer.getSyntaxRoot());
//		if (environment == null) {
//			return null;
//		}
//		ModelElement modelElement = environment.lookupPathName(pathNameAS);
//		EModelElement metamodelElement = null;
//		if (modelElement instanceof OclModelElementTypeImpl) {
//			metamodelElement = ((OclModelElementTypeImpl) modelElement).getEClassifier();
//		} else if (modelElement instanceof EnumerationImpl) {
//			metamodelElement = ((EnumerationImpl) modelElement).getEEnum();
//		} else if (modelElement instanceof EnumLiteralImpl) {
//			metamodelElement = ((EnumLiteralImpl) modelElement).getEEnumLiteral();
//		}
//		if (metamodelElement == null) {
//			return null;
//		}
//		return new MetamodelElementHyperlink(HyperlinkUtil.createRegion(pathNameAS), metamodelElement);
		return null;
	}

	private IHyperlink findHyperLink(PathNameCS pathName, IDetectionContext context) {
		QvtOperationalEnv env = getEnv(pathName);
		if(env != null) {
			List<String> names = new ArrayList<String>(5);
			IRegion linkRegion = findElementInPathName(pathName, context.getRegion(), names);
			boolean isPackageReferred = names.size() < pathName.getSequenceOfNames().size();
			
			EModelElement element = (isPackageReferred) ? env.lookupPackage(names) : env.lookupClassifier(names);
			if(element == null) {
				ModelType modelType = env.getModelType(names);
				if(modelType != null) {
					EList<PackageRef> metamodels = modelType.getMetamodel();
					if(!metamodels.isEmpty()) {
						String uri = metamodels.get(0).getUri();
						element = env.getEPackageRegistry().getEPackage(uri);
					}
				}
			}
			if(element != null) {
				return new MetamodelElementHyperlink(linkRegion, element);
			}
		}
		
		return null;
	}
	
	private IRegion findElementInPathName(PathNameCS pathNameCS, IRegion region, List<String> pathToLookup) {
		int startOffset = pathNameCS.getStartOffset();
		int endOffset = startOffset;		
		
		int index = 0;
		for (String segment : pathNameCS.getSequenceOfNames()) {
			pathToLookup.add(segment);
			
			if(index > 0) {
				startOffset = endOffset + "::".length(); //$NON-NLS-1$
			}
			endOffset = startOffset + segment.length();

			if(region.getOffset() >= startOffset && region.getOffset() <= endOffset && 
				region.getLength() <= endOffset - startOffset) {
				return new Region(startOffset, endOffset - startOffset);
			}
			
			index++;
		}
		return HyperlinkUtil.createRegion(pathNameCS);
	}
	
	private QvtOperationalEnv getEnv(CSTNode node) {
		return (QvtOperationalEnv)CSTHelper.getEnvironment(node);
	}	
}
