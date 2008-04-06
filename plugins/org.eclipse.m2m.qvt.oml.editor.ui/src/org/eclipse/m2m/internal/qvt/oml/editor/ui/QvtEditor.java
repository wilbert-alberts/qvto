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
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.text.ITextViewerExtension;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.m2m.internal.qvt.oml.builder.QvtBuilder;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.actions.OpenDeclarationAction;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.outline.QvtOutlineContentProvider;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.outline.QvtOutlineInput;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.outline.QvtOutlineLabelProvider;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.outline.QvtOutlineNodeSelector;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.outline.QvtOutlineSelectionListener;
import org.eclipse.m2m.qvt.oml.emf.util.Logger;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.part.IShowInTargetList;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

public class QvtEditor extends TextEditor {
	private static final String QVT_EDITOR_UI_CONTEXT = "org.eclipse.m2m.qvt.oml.editor.ui.context";
	public final static String ID = "org.eclipse.m2m.qvt.oml.editor.ui.QvtEditor"; //$NON-NLS-1$
    protected final static String MATCHING_BRACKETS = "matchingBrackets"; //$NON-NLS-1$
    protected final static String MATCHING_BRACKETS_COLOR = "matchingBracketsColor"; //$NON-NLS-1$
    
    public QvtEditor() {
        myColorManager = new ColorManager();
        setSourceViewerConfiguration(new QvtConfiguration(this, myColorManager));
        setDocumentProvider(new QvtDocumentProvider());
        
        setRulerContextMenuId("#QvtEditorRulerContext"); //$NON-NLS-1$
        setEditorContextMenuId("#QvtEditorContext");   //$NON-NLS-1$
        
        QvtBuilder.addBuildListener(myBuildListener);
    }
    
    @Override
    protected void initializeKeyBindingScopes() {
    	setKeyBindingScopes(new String[] { QVT_EDITOR_UI_CONTEXT });    
    }
    
    @Override
	public void dispose() {
        if(myBracketMatcher != null) {
            myBracketMatcher.dispose();
            myBracketMatcher = null;
        }
        
        if(myColorManager != null) {
            myColorManager.dispose();
            myColorManager = null;
        }
        
        if (mySelectionChangedListener != null) {
        	mySelectionChangedListener.uninstall();
        	mySelectionChangedListener = null;
        }
        
        if(myBuildListener != null) {
            QvtBuilder.removeBuildListener(myBuildListener);
            myBuildListener = null;
        }
        
        super.dispose();
    }
    
    @Override
	public void doSave(IProgressMonitor progress) {
        super.doSave(progress);
        refresh();
    }
    
    public void selectionChanged(final TextSelection selection) {
        if (myTreeViewer != null && !myTreeViewer.getControl().isDisposed()) {
            myTreeViewer.removeSelectionChangedListener(myOutlineSelectionListener);
            
            myOutlineSelector.selectCorrespondingNode(selection);
            
            myTreeViewer.addSelectionChangedListener(myOutlineSelectionListener);
        }
    }
    
    @SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class required) {
        if (IContentOutlinePage.class.equals(required)) {
            return myOutlinePage;
        }
        if (IShowInTargetList.class.equals(required)) {
            return new IShowInTargetList() {

                public String[] getShowInTargetIds() {
                    return new String[] {
                            IPageLayout.ID_RES_NAV,
                            JavaUI.ID_PACKAGES
                    };
                }
                
            };
        }
        return super.getAdapter(required);
    }
    
    public ISourceViewer getSourceViewerOpened() {
        return getSourceViewer();
    }
    
    @Override
	public void createPartControl(Composite parent) {
    	/*
        if(!LicenseClient.isViewAvailable(parent, Messages.QvtEditor_title)) { 
            return;
        }
        */
		setHelpContextId("org.eclipse.m2m.qvt.oml._editor"); //$NON-NLS-1$
        super.createPartControl(parent);
        getPreferenceStore().setValue(MATCHING_BRACKETS, true);
        getPreferenceStore().setValue(MATCHING_BRACKETS_COLOR, StringConverter.asString(new RGB(196, 196, 196)));
        myOutlinePage = new ContentOutlinePage() {
            @Override
			public void createControl(Composite parent) {
                super.createControl(parent);
                myTreeViewer = getTreeViewer();
                myTreeViewer.setContentProvider(new QvtOutlineContentProvider());
                myTreeViewer.setLabelProvider(new QvtOutlineLabelProvider());
                myOutlineSelectionListener = new QvtOutlineSelectionListener(QvtEditor.this.getSourceViewerOpened());
                myTreeViewer.addSelectionChangedListener(myOutlineSelectionListener);
                myTreeViewer.addDoubleClickListener(myOutlineSelectionListener);
                myOutlineSelector = new QvtOutlineNodeSelector(myTreeViewer);
                myTreeViewer.setInput(new QvtOutlineInput());
                myTreeViewer.getControl().addDisposeListener(new DisposeListener() {
				
					public void widgetDisposed(DisposeEvent e) {
						myTreeViewer.removeSelectionChangedListener(myOutlineSelectionListener);
						myTreeViewer.removeDoubleClickListener(myOutlineSelectionListener);
						myTreeViewer = null;
						myOutlineSelectionListener = null;
						myOutlineSelector = null;
					}
				
				});
                refresh();
            }                   
        };
        
        mySelectionChangedListener = new QvtEditorSelectionChangedListener(this);
        mySelectionChangedListener.install();
        
        myProjectionSupport = new ProjectionSupport(getProjectionSourceViewer(), getAnnotationAccess(), getSharedColors());
//		myProjectionSupport.addSummarizableAnnotationType("org.eclipse.ui.workbench.texteditor.error"); //$NON-NLS-1$
//		myProjectionSupport.addSummarizableAnnotationType("org.eclipse.ui.workbench.texteditor.warning"); //$NON-NLS-1$
//		myProjectionSupport.setHoverControlCreator(new IInformationControlCreator() {
//			public IInformationControl createInformationControl(Shell shell) {
//				return new CustomSourceInformationControl(shell, IDocument.DEFAULT_CONTENT_TYPE);
//			}
//		});
		myProjectionSupport.install();

		getProjectionSourceViewer().doOperation(ProjectionViewer.TOGGLE);
		
		ISourceViewer sourceViewer = getSourceViewer();
        if (sourceViewer instanceof ITextViewerExtension) {
            if (myBracketInserter == null) {
            	myBracketInserter = new BracketInserter(getSourceViewer());
            }
            ((ITextViewerExtension) sourceViewer).prependVerifyKeyListener(myBracketInserter);
        }
    }
    
    public void updateFoldingStructure(final List<Position> positions) {
    	if (getProjectionSourceViewer() == null 
    			|| getProjectionSourceViewer().getProjectionAnnotationModel() == null) {
    		return;
    	}
    	
        Annotation[] annotations = new Annotation[positions.size()];

        ProjectionAnnotationModel model = getProjectionSourceViewer().getProjectionAnnotationModel();
        
        ArrayList<Annotation> annotationsToRemove = new ArrayList<Annotation>(Arrays.asList(myOldAnnotations));
        HashMap<Position, Annotation> oldPositions = new HashMap<Position, Annotation>();
    	for (int i = 0; i < myOldAnnotations.length; i++) {
			Annotation annotation = myOldAnnotations[i];
			oldPositions.put(model.getPosition(annotation), annotation);
		}
        
        HashMap<ProjectionAnnotation, Position> newAnnotations = new HashMap<ProjectionAnnotation, Position>();
        for (int i = 0; i < positions.size(); i++) {
        	Position position = positions.get(i);
        	ProjectionAnnotation annotation = (ProjectionAnnotation) oldPositions.get(position);
        	if (annotation == null) {
        		annotation = new ProjectionAnnotation();
        		newAnnotations.put(annotation, position);
        	} else {
        		annotationsToRemove.remove(annotation);
        	}
        	annotations[i] = annotation;
        }
        
        model.replaceAnnotations((Annotation[]) annotationsToRemove.toArray(new Annotation[annotationsToRemove.size()]), 
        		newAnnotations);

        myOldAnnotations = annotations;
    }
    
    private ProjectionViewer getProjectionSourceViewer() {
    	return (ProjectionViewer) getSourceViewer();
    }
    
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		try {
			super.init(site, input);
		}
		catch(PartInitException e) {
			Logger.getLogger().log(Logger.SEVERE, "Failed to initialize QVT editor", e); //$NON-NLS-1$
			throw e;
		}
	}
    
    public int getTabWidth() {
        return getSourceViewerConfiguration().getTabWidth(getSourceViewer());
    }
    
    @Override
	protected void configureSourceViewerDecorationSupport(SourceViewerDecorationSupport support) {
        support.setCharacterPairMatcher(myBracketMatcher);
        support.setMatchingCharacterPainterPreferenceKeys(MATCHING_BRACKETS, MATCHING_BRACKETS_COLOR);        
        super.configureSourceViewerDecorationSupport(support);
    }
    
    @Override
	protected void createActions() {
        super.createActions();
        IAction action = new ContentAssistAction(ActionMessages.getResourceBundle(), "ContentAssistProposal.", this); //$NON-NLS-1$
        action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
        setAction("ContentAssistProposal", action); //$NON-NLS-1$
		markAsStateDependentAction("ContentAssistProposal", true); //$NON-NLS-1$
		
		action = new OpenDeclarationAction(ActionMessages.getResourceBundle(), "OpenDeclaration", this); //$NON-NLS-1$
 
		setAction(action.getActionDefinitionId(), action);

    }
    
    
    public void refresh() {
        IWorkbenchPartSite s = getSite();
        if (s == null) {
            return;
        }
        if(s.getShell() == null || s.getShell().isDisposed() || s.getShell().getDisplay() == null ||
        	s.getShell().getDisplay().isDisposed()) {
        	// NPE and disposed status check
        	return;
        }
        s.getShell().getDisplay().syncExec(new Runnable() {
            public void run() {
            	if (myTreeViewer != null && !myTreeViewer.getControl().isDisposed()) {
                    CompiledModule mm = ((QvtDocumentProvider)getDocumentProvider()).getCompiledModule();
                    if (mm != null) {
                    	QvtOutlineInput input = (QvtOutlineInput) myTreeViewer.getInput();
                    	input.mappingModuleUpdated(mm.getSyntaxElement());
                        myTreeViewer.refresh();
                        selectionChanged((TextSelection)getSelectionProvider().getSelection());
                    }
                }
            }
        });
    }
    
    /**
	 * Returns the annotation model to be used for problem reporting or
	 * <code>null</code> in case the editor's part has not been created or
	 * has been disposed.
	 * 
	 * @return the annotation model to be used for problem reporting or
	 *         <code>null</code>
	 */
    public IAnnotationModel getAnnotationModel() {
    	ISourceViewer sourceViewer = getSourceViewer();
		return (sourceViewer != null) ? sourceViewer.getAnnotationModel() : null;
    }
    
    @Override
	protected ISourceViewer createSourceViewer(final Composite parent,
            final IVerticalRuler ruler, final int styles) {
        ProjectionViewer viewer = new ProjectionViewer(parent, ruler, getOverviewRuler(), isOverviewRulerVisible(), styles);
        
        // ensure decoration support has been created and configured.
        getSourceViewerDecorationSupport(viewer);
        
        return viewer;
    }
    
    private ProjectionSupport myProjectionSupport;
    private Annotation[] myOldAnnotations = new Annotation[0];
    
    private ContentOutlinePage myOutlinePage;
    private TreeViewer myTreeViewer;
    private ColorManager myColorManager;
    protected final static char[] BRACKETS= { '{', '}', '(', ')', '[', ']' };
    private QvtPairMatcher myBracketMatcher = new QvtPairMatcher(BRACKETS);
    private QvtEditorSelectionChangedListener mySelectionChangedListener;
    private QvtOutlineSelectionListener myOutlineSelectionListener;
    private QvtOutlineNodeSelector myOutlineSelector;
    private BracketInserter myBracketInserter;
    
    private QvtBuilder.BuildListener myBuildListener = new QvtBuilder.BuildListener() {
        public void buildPerformed() {
            //refresh();
        }
    };
    
    /* *** For testing purposes *** */
    public QvtConfiguration getQvtConfiguration() {
    	return (QvtConfiguration) getSourceViewerConfiguration();
    }

    public ISourceViewer getEditorSourceViewer() {
    	return getSourceViewer();
    }
}