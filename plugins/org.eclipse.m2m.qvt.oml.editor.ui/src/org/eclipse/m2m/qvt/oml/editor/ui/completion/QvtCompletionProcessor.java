package org.eclipse.m2m.qvt.oml.editor.ui.completion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.bindings.TriggerSequence;
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContentAssistEvent;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.qvt.oml.compiler.ParsedModuleCS;
import org.eclipse.m2m.qvt.oml.editor.ui.Activator;
import org.eclipse.m2m.qvt.oml.editor.ui.QvtCompilerFacade;
import org.eclipse.m2m.qvt.oml.editor.ui.QvtDocumentProvider;
import org.eclipse.m2m.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.m2m.qvt.oml.editor.ui.completion.collectorregistry.CategoryDescriptor;
import org.eclipse.m2m.qvt.oml.editor.ui.completion.collectorregistry.CollectorDescriptor;
import org.eclipse.m2m.qvt.oml.editor.ui.completion.collectorregistry.CollectorRegistry;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.m2m.qvt.oml.internal.cst.adapters.CSTBindingUtil;
import org.eclipse.m2m.qvt.oml.internal.cst.parser.QvtOpLexer;
import org.eclipse.ocl.internal.cst.CSTNode;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.keys.IBindingService;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;

/**
 * @author aigdalov
 */

public class QvtCompletionProcessor implements IContentAssistProcessor {
    private final static char[] ACTIVATION = {
        '.', '>' /* -> */};
    private final int INITIAL_CATEGORY_INDEX = -1;
    private final int NO_CATEGORY_INDEX = -1;

	private final ContentAssistant myContentAssistant;

	private List<CategoryDescriptor> myCategories;
    private int myCategoryIndex = INITIAL_CATEGORY_INDEX;

    private final QvtEditor myEditor;
    private String myError;
    private boolean isDocumentChanged = true;
    private int myOffset = -1;
    
    private final IDocumentListener myDocumentListener = new IDocumentListener() {
		public void documentAboutToBeChanged(DocumentEvent event) {
		}

		public void documentChanged(DocumentEvent event) {
			isDocumentChanged = true;
		}
    };
    
    public QvtCompletionProcessor(final QvtEditor editor, final ISourceViewer sourceViewer, ContentAssistant contentAssistant) {
        myEditor = editor;
		myContentAssistant = contentAssistant;
		
		// See corresponding snippet in org.eclipse.jdt.internal.ui.text.java.ContentAssistProcessor
		myContentAssistant.addCompletionListener(new ICompletionListener() {
			
			/*
			 * @see org.eclipse.jface.text.contentassist.ICompletionListener#assistSessionStarted(org.eclipse.jface.text.contentassist.ContentAssistEvent)
			 */
			public void assistSessionStarted(ContentAssistEvent event) {
				if (event.processor != QvtCompletionProcessor.this)
					return;
				
				myCategoryIndex = INITIAL_CATEGORY_INDEX;

				if (event.assistant instanceof ContentAssistant) {
					ContentAssistant contentAssistant = (ContentAssistant) event.assistant;
					contentAssistant.setRepeatedInvocationMode(true);
					contentAssistant.setStatusLineVisible(true);
					KeySequence binding = getIterationBinding();
					contentAssistant.setRepeatedInvocationTrigger(binding);
					contentAssistant.setShowEmptyList(true);
				}
			}
			
			/*
			 * @see org.eclipse.jface.text.contentassist.ICompletionListener#assistSessionEnded(org.eclipse.jface.text.contentassist.ContentAssistEvent)
			 */
			public void assistSessionEnded(ContentAssistEvent event) {
				myOffset = -1;
			}

			/*
			 * @see org.eclipse.jface.text.contentassist.ICompletionListener#selectionChanged(org.eclipse.jface.text.contentassist.ICompletionProposal, boolean)
			 */
			public void selectionChanged(ICompletionProposal proposal, boolean smartToggle) {
			}
			
			private KeySequence getIterationBinding() {
			    final IBindingService bindingSvc= (IBindingService) PlatformUI.getWorkbench().getAdapter(IBindingService.class);
				TriggerSequence binding= bindingSvc.getBestActiveBindingFor(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
				if (binding instanceof KeySequence)
					return (KeySequence) binding;
				return null;
		    }
		});
    }

    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
            int offset) {
        myError = null;
        try {
            IDocument document = viewer.getDocument();
            document.addDocumentListener(myDocumentListener);
            if (isDocumentChanged) {
                QvtCompilerFacade.getInstance().compile(myEditor, document, false, null);
            	isDocumentChanged = false;
            }
            QvtDocumentProvider documentProvider = (QvtDocumentProvider) myEditor.getDocumentProvider();
            CompiledModule compiledModule = documentProvider.getCompiledModule();
            ParsedModuleCS syntaxElement = compiledModule.getSyntaxElement();
            MappingModuleCS moduleCS = syntaxElement.getModuleCS();
            CSTNode cstNode = CSTTraverseUtil.findCSTNode(moduleCS, offset);
            QvtOpLexer qvtOpLexer = CSTTraverseUtil.getQvtOpLexer(cstNode);
            PrsStream prsStream = qvtOpLexer.getPrsStream();
            IToken[] tokens = getLeftTokenAndCurrentToken(document, prsStream, offset);
            QvtOperationalEnv env = CSTBindingUtil.getQvtOperationalEnv(cstNode);
            QvtCompletionData data = new QvtCompletionData(myEditor, viewer, offset, tokens[0],
            		tokens[1], cstNode, env, moduleCS, qvtOpLexer, prsStream, compiledModule);
            if (!data.isValid()) {
            	return disableNextCodeCompletionPage();
            }
            if ((myCategoryIndex == INITIAL_CATEGORY_INDEX) 
            		|| (myOffset == offset)) { // Ctrl + Space pressed again
                int categoryIndex = updateCategoryIndex(data);
                if (categoryIndex == NO_CATEGORY_INDEX) {
                	return disableNextCodeCompletionPage();
                }
                CategoryDescriptor nextCategory = getNextCategory();
                if (nextCategory == null) {
                	disableNextCodeCompletionPage();
                } else {
                	myContentAssistant.setStatusLineVisible(true);
                	myContentAssistant.setStatusMessage(NLS.bind(Messages.QvtCompletionProcessor_PressCtrlSpace,
                			nextCategory.getLabel()));
                }
            }
            Collection<ICompletionProposal> proposals = new LinkedHashSet<ICompletionProposal>();
            for (CollectorDescriptor collectorDescriptor : CollectorRegistry.getCollectors(getCurrentCategory().getId())) {
            	ICollector collector = collectorDescriptor.getCollector();
            	if (collector.isApplicable(data)) {
                    collector.addPropoposals(proposals, data);
            	}
            }
            return proposals.toArray(new ICompletionProposal[proposals.size()]);
        } catch (BadLocationException e) {
            myError = NLS.bind(Messages.QvtCompletionProcessor_ErrorMessage, e.getLocalizedMessage());
            Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.getDefault().getBundle().getSymbolicName(), myError, e));
            return disableNextCodeCompletionPage();
        } finally {
        	myOffset = offset;
        }
    }

    private ICompletionProposal[] disableNextCodeCompletionPage() {
    	myContentAssistant.setStatusLineVisible(false);
    	return null;
	}

	private IToken[] getLeftTokenAndCurrentToken(IDocument document, PrsStream prsStream, int offset) throws BadLocationException {
        IToken left = null;
        IToken current = null;

        if ((offset == 0) || (prsStream.getTokens().isEmpty())) {
            return new IToken[] {left, current};
        }

        // We might be at the end of some identifier
        char previousChar = document.getChar(offset - 1);
        if (Character.isJavaIdentifierPart(previousChar)) { 
            int tokenIndex = prsStream.getTokenIndexAtCharacter(offset - 1);
            // getTokenIndexAtCharacter() may produce wrong results on first tokens
            left = (tokenIndex == 1) ? null : prsStream.getTokenAt(tokenIndex - 1);
            current = prsStream.getTokenAt(tokenIndex);
        } else {
            int tokenIndex = prsStream.getTokenIndexAtCharacter(offset);
            int leftTokenIndex = (tokenIndex < 0)  ? -tokenIndex : tokenIndex - 1;
            if (leftTokenIndex != 0) {
                left = prsStream.getTokenAt(leftTokenIndex);
            }
            if (prsStream.getTokens().size() >= leftTokenIndex + 2) {
                IToken next = prsStream.getTokenAt(leftTokenIndex + 1);
                current = (next.getStartOffset() < offset) ? next : null;
            }
        }
        return new IToken[] {left, current};
    }
    
    private int updateCategoryIndex(QvtCompletionData data) {
    	if (myCategoryIndex == INITIAL_CATEGORY_INDEX) { /* -1 */
    		myCategories = new ArrayList<CategoryDescriptor>();
    		CategoryDescriptor[] allCategories = CollectorRegistry.getCategories();
    		for (CategoryDescriptor categoryDescriptor : allCategories) {
    			List<CollectorDescriptor> collectorDescriptors = 
    				CollectorRegistry.getCollectors(categoryDescriptor.getId());
    			boolean isApplicable = false;
    			if (collectorDescriptors != null) {
    				for (CollectorDescriptor collectorDescriptor : collectorDescriptors) {
    					ICollector collector = collectorDescriptor.getCollector();
    					if (collector.isApplicable(data)) {
    						isApplicable = true;
    						break;
    					}
    				}
    			}
				if (isApplicable) {
					myCategories.add(categoryDescriptor);
				}
			}
    	}
    	if (myCategories.isEmpty()) {
    		return NO_CATEGORY_INDEX;
    	}
    	myCategoryIndex ++;
    	if (myCategoryIndex == myCategories.size()) {
    		myCategoryIndex = 0;
    	}
    	return myCategoryIndex;
    }
    
    public CategoryDescriptor getCurrentCategory() {
    	if (myCategories.isEmpty()) {
    		return null;
    	}
    	return myCategories.get(myCategoryIndex);
    }
    
    public CategoryDescriptor getNextCategory() {
    	if (myCategories.size() == 1) {
    		return null;
    	}
    	int index = myCategoryIndex + 1;
    	if (index == myCategories.size()) {
    		index = 0;
    	}
    	return myCategories.get(index);
    }
    
    public CategoryDescriptor getLastCategory() {
    	if (myCategories.isEmpty()) {
    		return null;
    	}
    	return myCategories.get(myCategories.size() - 1);
    }
    
    public static final CSTNode findLeftmostCSTNode(CSTNode root, int offset) {
        CSTNode result = null;
        for (TreeIterator<EObject> iterator = root.eAllContents(); iterator.hasNext(); ) {
            EObject next = iterator.next();
            if (next instanceof CSTNode) {
                CSTNode child = (CSTNode) next;
                if (child.getEndOffset() < offset) {
                    if ((result == null)
                            || (child.getEndOffset() > result.getEndOffset())
                            || ((child.getEndOffset() == result.getEndOffset()) 
                                    && (child.getStartOffset() < result.getStartOffset()))) {
                        result = child;
                    }
                }
            }
        }
        return result;
    }

    public IContextInformation[] computeContextInformation(ITextViewer viewer,
            int offset) {
        return null;
    }

    public char[] getCompletionProposalAutoActivationCharacters() {
        return ACTIVATION;
    }

    public char[] getContextInformationAutoActivationCharacters() {
        return null;
    }

    public IContextInformationValidator getContextInformationValidator() {
        return null;
    }

    public String getErrorMessage() {
        return myError;
    }
}