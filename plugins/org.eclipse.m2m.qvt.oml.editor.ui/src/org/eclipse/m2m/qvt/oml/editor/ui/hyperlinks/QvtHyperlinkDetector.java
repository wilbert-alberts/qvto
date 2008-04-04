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

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.qvt.oml.editor.ui.Activator;
import org.eclipse.m2m.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.qvt.oml.editor.ui.QvtDocumentProvider;
import org.eclipse.m2m.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.m2m.qvt.oml.editor.ui.hyperlinks.IHyperlinkDetectorHelper.IDetectionContext;
import org.eclipse.ocl.cst.CSTNode;


/**
 * @author vrepeshko
 */
public class QvtHyperlinkDetector implements IHyperlinkDetector {

	public QvtHyperlinkDetector(QvtEditor editor) {
		myEditor = editor;
		myHelpers = new IHyperlinkDetectorHelper[] {
				new ImportHyperlinkDetector(),
				new ModelTypeHyperlinkDetector(),
				new PathNameHyperlinkDetector(),
				new ObjectPropertyHyperlinkDetector(),
				new VariableHyperlinkDetector(),
				new ScopedIdentifierHyperLinkDetector(),
				new OperationHyperlinkDetector(),
				new ResolveInHyperlinkDetector()
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

		List<CSTNode> elements = CSTHelper.selectTargetedElements(compiledModule.getSyntaxElement().getModuleCS(), region);
		
		Context context = new Context(documentProvider.getCompiledModule(), region, textViewer);		
		
		for (CSTNode element : elements) {
			for (IHyperlinkDetectorHelper helper : myHelpers) {
				context.syntaxElement = element;
				try {
					IHyperlink hyperlink = helper.detectHyperlink(context);
					if (hyperlink != null) {
						return new IHyperlink[] { hyperlink };
					}
				} catch (Exception e) {
					Activator.log(e);
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
		final IRegion region;
		final ITextViewer textViewer;
		CSTNode syntaxElement;
		
		public Context(CompiledModule module, IRegion region, ITextViewer textViewer) {
			this.compiledModule = module;
			this.region = region;
			this.textViewer = textViewer;
		}		

		public CompiledModule getModule() {
			return compiledModule;
		}
		
		public IRegion getRegion() {			
			return region;
		}
		
		public CSTNode getSyntaxElement() {			
			return syntaxElement;
		}
		
		public ITextViewer geTextViewer() {		
			return textViewer;
		}
	};
}
