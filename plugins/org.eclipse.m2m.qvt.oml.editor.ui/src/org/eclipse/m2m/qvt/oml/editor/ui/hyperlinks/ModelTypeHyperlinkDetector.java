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

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.qvt.oml.internal.cst.PackageRefCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.StringLiteralExpCS;


/**
 * @author vrepeshko
 */
public class ModelTypeHyperlinkDetector implements IHyperlinkDetectorHelper {

	public IHyperlink detectHyperlink(IDetectionContext context) {
		CSTNode syntaxElement = context.getSyntaxElement();
		
		EPackage ePackage = findReferencedPackageDefinition(syntaxElement);		
		if(ePackage != null) {
			return new MetamodelElementHyperlink(HyperlinkUtil.createRegion(syntaxElement), ePackage);
		}
		
		return null;
	}

	public static EPackage findReferencedPackageDefinition(CSTNode syntaxElement) {
		PackageRefCS packageRefCS = null;		
		if(syntaxElement instanceof PathNameCS && syntaxElement.eContainer() instanceof PackageRefCS) {
			packageRefCS = (PackageRefCS) syntaxElement.eContainer();
		}
		else if (syntaxElement instanceof StringLiteralExpCS && syntaxElement.eContainer() instanceof PackageRefCS) {
			packageRefCS = (PackageRefCS) syntaxElement.eContainer();
			if(packageRefCS.getUriCS() != syntaxElement) {
				return null;
			}
		}
		
		if(packageRefCS != null) {
			StringLiteralExpCS uriCS = packageRefCS.getUriCS();
			if(uriCS != null) {
				return findReferencedEPackage(uriCS);
			}			
		}
		
		return null;
	}	
	
	private static EPackage findReferencedEPackage(StringLiteralExpCS uriLiteral) {
		QvtOperationalEnv env = getEnv(uriLiteral);
		if(env == null) {
			return null;
		}
		
		String id = uriLiteral.getStringSymbol();
		if(id == null || id.length() < 2) {
			return null;
		}
		
		// strip quotations
		id = id.substring(1, id.length() - 1);
		try {
			return env.getMetamodelRegistry().getMetamodelDesc(id).getModel();
		} catch (EmfException e) {
			// do nothing, a metamodel may not have been resolved
		}
		
		return null;
	}
	
	private static QvtOperationalEnv getEnv(CSTNode node) {
		return (QvtOperationalEnv)CSTHelper.getEnvironment(node);
	}	
}
