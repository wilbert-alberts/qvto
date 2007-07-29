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

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.internal.cst.CSTNode;
import org.eclipse.ocl.internal.cst.OCLExpressionCS;
import org.eclipse.ocl.internal.cst.OperationCallExpCS;




/**
 * @author vrepeshko
 */
public class ImperativeOperationHyperlinkDetector implements IHyperlinkDetectorHelper {

	public IHyperlink detectHyperlink(IDetectionContext context) {
		if (!(context.getSyntaxElement() instanceof OperationCallExpCS)) {
			return null;
		}
		OperationCallExpCS callExpCS = (OperationCallExpCS) context.getSyntaxElement();
		CSTNode operationName = getSourceOperationName(callExpCS.getSource());
		if (!HyperlinkUtil.isValidElement(operationName)) {
			return null;
		}
		Object callSemanticObject = context.getCompletionData().getSyntaxToSemanticMap().get(callExpCS);
		EOperation operation = null;
		if (callSemanticObject instanceof OperationCallExp) {
			operation = ((OperationCallExp) callSemanticObject).getReferredOperation();
		} else if (callSemanticObject instanceof IteratorExp) {
			IteratorExp itExp = (IteratorExp)callSemanticObject;
			if (itExp.getBody() instanceof OperationCallExp) {
				operation =  ((OperationCallExp) itExp.getBody()).getReferredOperation();
			}
		}
//		if (!(operation instanceof OperationInContextImpl)) {
//			return null;
//		}
//		OperationInContextImpl contextualOperation = (OperationInContextImpl) operation;
//		Object moduleSemanticObject = data.getSyntaxToSemanticMap().get(analyzer.getSyntaxRoot());
//		if (!(moduleSemanticObject instanceof MappingModule)) {
//			return null;
//		}
//		Module module = (Module) moduleSemanticObject;
//		Module definingModule = QvtUtil.getInnermostDefiningModule(module, contextualOperation);
//		if (definingModule == null || !(definingModule.getSource() instanceof EclipseFile) || definingModule.getSyntaxElement() == null) {
//			return null;
//		}
//		MappingModuleCS definingModuleCS = definingModule.getSyntaxElement();
//		ImperativeOperation imperativeOperation = QvtUtil.findMappingMethod(definingModule, contextualOperation);
//		if (imperativeOperation == null) {
//			return null;
//		}
//		MappingMethodCS operationCS = null;
//		for (Iterator iter = definingModuleCS.getMethods().iterator(); iter.hasNext();) {
//			MappingMethodCS methodCS = (MappingMethodCS) iter.next();
//			if (methodCS.getStartOffset() == imperativeOperation.getStartPosition()) {
//				operationCS = methodCS;
//			}
//		}
//		if (operationCS == null || !HyperlinkUtil.isValidElement(operationCS) || operationCS.getDeclaration() == null) {
//			return null;
//		}
//		SimpleNameCS name = operationCS.getMappingDeclarationCS().getSimpleNameCS();
//		if (!HyperlinkUtil.isValidElement(name)) {
//			return null;
//		}
//		return new QvtFileHyperlink(HyperlinkUtil.createRegion(operationName), ((EclipseFile) definingModule.getSource()).getFile(), 
//				HyperlinkUtil.createRegion(operationCS), HyperlinkUtil.createRegion(name));
		return null;
	}

	private CSTNode getSourceOperationName(OCLExpressionCS source) {
//		if (source instanceof SelectionExpCS) {
//			return ((SelectionExpAS) source).getName();
//		} else if (source instanceof PathNameExpAS) {
//			PathNameCS pathName = ((PathNameExpAS) source).getPathName();
//			return (pathName != null && pathName.size() > 0) ? pathName.get(pathName.size() - 1) : null;
//		}
		return null;
	}
	
}
