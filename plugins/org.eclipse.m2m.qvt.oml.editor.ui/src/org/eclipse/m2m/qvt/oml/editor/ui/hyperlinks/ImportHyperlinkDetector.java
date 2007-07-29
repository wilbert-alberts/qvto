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


import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.qvt.oml.internal.cst.ModuleImportCS;
import org.eclipse.ocl.internal.cst.PathNameCS;

/**
 * @author vrepeshko
 */
public class ImportHyperlinkDetector implements IHyperlinkDetectorHelper {

	public IHyperlink detectHyperlink(IDetectionContext context) {
		if (!(context.getSyntaxElement() instanceof ModuleImportCS)) {
			return null;
		}
		ModuleImportCS moduleImportCS = (ModuleImportCS) context.getSyntaxElement();
		PathNameCS pathAS = moduleImportCS.getPathNameCS();
		if (!HyperlinkUtil.isValidElement(pathAS)) {
			return null;
		}
//		MappingModuleCS targetModuleCS = moduleImportCS.getParsedModule();
//		if (targetModuleCS == null || !(targetModuleCS.getSource() instanceof EclipseFile)) {
//			return null;
//		}
//		IFile targetFile = ((EclipseFile) targetModuleCS.getSource()).getFile();
//		if (targetFile == null || !targetFile.exists()) {
//			return null;
//		}
//		return new QvtFileHyperlink(HyperlinkUtil.createRegion(pathAS), targetFile, null, null);
		return null;
	}

}
