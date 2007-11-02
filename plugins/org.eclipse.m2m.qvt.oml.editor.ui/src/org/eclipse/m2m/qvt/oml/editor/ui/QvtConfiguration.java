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
package org.eclipse.m2m.qvt.oml.editor.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.m2m.qvt.oml.editor.ui.completion.QvtCompletionProcessor;
import org.eclipse.m2m.qvt.oml.editor.ui.hovers.QvtTextHover;
import org.eclipse.m2m.qvt.oml.editor.ui.hyperlinks.QvtHyperlinkDetector;


public class QvtConfiguration extends SourceViewerConfiguration {

	public QvtConfiguration(QvtEditor editor, ColorManager colorManager) {
        myColorManager = colorManager;
        myEditor = editor;
    }
    
    @Override
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
        return new String[] {
            IDocument.DEFAULT_CONTENT_TYPE,
            QvtPartitionScanner.QVT_COMMENT,
            QvtPartitionScanner.QVT_STRING };
    }
    
    @Override
	public ITextDoubleClickStrategy getDoubleClickStrategy(ISourceViewer sourceViewer, 
    		String contentType) {
        if (doubleClickStrategy == null)
            doubleClickStrategy = new QvtDoubleClickStrategy();
        return doubleClickStrategy;
    }

    protected QvtScanner getQvtScanner() {
        if (scanner == null) {
            scanner = new QvtScanner(myColorManager);
            scanner.setDefaultReturnToken(
                new Token(
                    new TextAttribute(
                        myColorManager.getColor(IQvtColorConstants.DEFAULT))));
        }
        return scanner;
    }

    @Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
        PresentationReconciler reconciler = new PresentationReconciler();
        reconciler.setDocumentPartitioning(QvtPartitionScanner.QVT_PARTITIONING);
        
        DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getQvtScanner());
        reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
        reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

        NonRuleBasedDamagerRepairer ndr =
            new NonRuleBasedDamagerRepairer(
                new TextAttribute(
                    myColorManager.getColor(IQvtColorConstants.QVT_COMMENT)));
        reconciler.setDamager(ndr, QvtPartitionScanner.QVT_COMMENT);
        reconciler.setRepairer(ndr, QvtPartitionScanner.QVT_COMMENT);

        ndr =
            new NonRuleBasedDamagerRepairer(
                new TextAttribute(
                    myColorManager.getColor(IQvtColorConstants.STRING)));
        reconciler.setDamager(ndr, QvtPartitionScanner.QVT_STRING);
        reconciler.setRepairer(ndr, QvtPartitionScanner.QVT_STRING);        
        return reconciler;
    }
    
    @Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
        myContentAssistant = new ContentAssistant();
        
        QvtCompletionProcessor processor = new QvtCompletionProcessor(myEditor, sourceViewer, myContentAssistant);
//        QvtTemplateCompletionProcessor processor = new QvtTemplateCompletionProcessor(); 
        myContentAssistant.setContentAssistProcessor(processor, IDocument.DEFAULT_CONTENT_TYPE);
        myContentAssistant.setContentAssistProcessor(processor, QvtPartitionScanner.QVT_STRING);
        myContentAssistant.setDocumentPartitioning(QvtPartitionScanner.QVT_PARTITIONING);
        myContentAssistant.enableAutoInsert(true);
        myContentAssistant.enableAutoActivation(true);
        myContentAssistant.setAutoActivationDelay(ASSIST_AUTO_ACTIVATION_DELAY);
        myContentAssistant.setProposalPopupOrientation(IContentAssistant.PROPOSAL_OVERLAY);
        myContentAssistant.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_ABOVE);
        myContentAssistant.setInformationControlCreator(getInformationControlCreator(sourceViewer));
        myContentAssistant.setProposalSelectorBackground(myColorManager.getColor(IQvtColorConstants.PROPOSAL_BACKGROUND));
        return myContentAssistant;
    }
    
  
    @Override
	public IReconciler getReconciler(final ISourceViewer sourceViewer) {
        QvtReconcilingStrategy strategy = new QvtReconcilingStrategy(myEditor);

		QvtReconciler reconciler = new QvtReconciler(myEditor, strategy, false);
        reconciler.setDelay(RECONCILER_DELAY);
		
        return reconciler;
    }
    
//    public IInformationControlCreator getInformationControlCreator(ISourceViewer sourceViewer) {
//        return new IInformationControlCreator() {
//            public IInformationControl createInformationControl(Shell parent) {
//                return new DefaultInformationControl(parent, SWT.NONE, new HTMLTextPresenter(true));
//            }
//        };
//    }
    
    @Override
    public IAutoEditStrategy[] getAutoEditStrategies(ISourceViewer sourceViewer, String contentType) {
    	return new IAutoEditStrategy[] { new QvtIndentAutoEditStrategy() };
    }
    
    @Override
	public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
    	return new QvtAnnotationHover();
    }
    
    @Override
	public ITextHover getTextHover(final ISourceViewer sourceViewer, final String contentType) {
        return new QvtTextHover((QvtDocumentProvider) myEditor.getDocumentProvider());
    }

    @Override
    public IHyperlinkDetector[] getHyperlinkDetectors(ISourceViewer sourceViewer) {
    	List<IHyperlinkDetector> detectors = new ArrayList<IHyperlinkDetector>();
    	detectors.add(new QvtHyperlinkDetector(myEditor));
    	return detectors.toArray(new IHyperlinkDetector[detectors.size()]);
    }
    
    private QvtDoubleClickStrategy doubleClickStrategy;
    private QvtScanner scanner;
    private ColorManager myColorManager;
    private ContentAssistant myContentAssistant;
    private QvtEditor myEditor;
	
	private static final int ASSIST_AUTO_ACTIVATION_DELAY = 200;
	private static final int RECONCILER_DELAY = 500;
}