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

import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.m2m.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.qvt.oml.editor.ui.QvtDocumentProvider;
import org.eclipse.m2m.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.m2m.qvt.oml.editor.ui.hyperlinks.IHyperlinkDetectorHelper.IDetectionContext;
import org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage;
import org.eclipse.m2m.qvt.oml.ocl.completion.CompletionData;
import org.eclipse.ocl.internal.cst.CSTNode;
import org.eclipse.ocl.internal.cst.OCLExpressionCS;


/**
 * @author vrepeshko
 */
@SuppressWarnings("restriction")
public class QvtHyperlinkDetector implements IHyperlinkDetector {

	public QvtHyperlinkDetector(QvtEditor editor) {
		myEditor = editor;
		myHelpers = new IHyperlinkDetectorHelper[] {
				new ImportHyperlinkDetector(),
				new ImperativeOperationHyperlinkDetector(),
				new PathNameHyperlinkDetector(),
				new ObjectPropertyHyperlinkDetector(),
				new VariableHyperlinkDetector(),
				new OperationHyperlinkDetector()				
		};
	}

	public IHyperlink[] detectHyperlinks(ITextViewer textViewer, final IRegion region, boolean canShowMultipleHyperlinks) {
		QvtDocumentProvider documentProvider = getDocumentProvider();
		if (documentProvider == null) {
			return null;
		}
		CompiledModule compiledModule = documentProvider.getCompiledModule();
		if (compiledModule == null) {
			return null;
		}
		final CompletionData completionData = documentProvider.getCompletionData();
		if (completionData == null) {
			return null;
		}

		List<CSTNode> elements = CSTHelper.selectTargetedElements(compiledModule.getSyntaxElement().getModuleCS(), region);
		
		//
		if(!elements.isEmpty()) {
			CSTNode node = elements.get(0);
			try {
				CSTNode parent = node;
				while(parent instanceof OCLExpressionCS && parent instanceof CSTNode) {
					if(parent.eClass().getEPackage() == CSTPackage.eINSTANCE) {
						//System.err.println("NO OCL");						
						break;
					} else {
						node = parent; 
					}
					
					parent = (CSTNode)parent.eContainer();
				}
				String text = textViewer.getDocument().get(node.getStartOffset(), node.getEndOffset() - node.getStartOffset() + 1);
				System.err.println(text); 
				
				//return null;
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Context context = new Context(documentProvider.getCompiledModule(), completionData, region);		
		
		for (CSTNode element : elements) {
			for (IHyperlinkDetectorHelper helper : myHelpers) {
				context.syntaxElement = element;
				
				IHyperlink hyperlink = helper.detectHyperlink(context);
				if (hyperlink != null) {
					return new IHyperlink[] { hyperlink };
				}
			}
		}
		return null;
	}
	

	
	private QvtDocumentProvider getDocumentProvider() {
		return (QvtDocumentProvider) myEditor.getDocumentProvider();
	}
	
	private final QvtEditor myEditor;
	
	private final IHyperlinkDetectorHelper[] myHelpers;
	
	/**
	 * Context reusable for different elements.
	 */
	private static class Context implements IDetectionContext {

		final CompiledModule compiledModule;
		final CompletionData completionData;
		final IRegion region;
		CSTNode syntaxElement;
		
		public Context(CompiledModule module, CompletionData completionData, IRegion region) {
			this.compiledModule = module;
			this.completionData = completionData;
			this.region = region;
		}		

		public CompiledModule getModule() {
			return compiledModule;
		}
		
		
		public CompletionData getCompletionData() {			
			return completionData;
		}
		
		public IRegion getRegion() {			
			return region;
		}
		
		public CSTNode getSyntaxElement() {			
			return syntaxElement;
		}
	};
}
