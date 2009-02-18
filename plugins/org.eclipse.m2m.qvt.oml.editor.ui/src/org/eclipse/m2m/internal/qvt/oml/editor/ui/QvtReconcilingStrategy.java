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
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.swt.widgets.Display;


public class QvtReconcilingStrategy implements IReconcilingStrategy, IReconcilingStrategyExtension {
    private static final int MAX_LOGGED_COMPILATION_EXCEPTIONS = 5;
    private IProgressMonitor myMonitor;
    private IDocument myDocument;
    private final QvtEditor myEditor;
    private int loggedCompilationExceptionsCount = 0;

    public QvtReconcilingStrategy(final QvtEditor editor) {
        myEditor = editor;
    }
    
    public void setDocument(final IDocument document) {
        myDocument = document;
    }
    
    public void reconcile(final DirtyRegion dirtyRegion, 
            final IRegion subRegion) {
        reconcileInternal();
    }
    
    public void reconcile(final IRegion partition) {
        reconcileInternal();
    }
    
    public void setProgressMonitor(final IProgressMonitor monitor) {
        myMonitor = monitor;
    }
    
    public void initialReconcile() {
        reconcileInternal();
    }
    
    private void reconcileInternal() {
        final ArrayList<Position> positions = new ArrayList<Position>();
        QvtCompilerOptions options = new QvtCompilerOptions();
        options.setShowAnnotations(QvtCompilerFacade.isEditingInQvtSourceContainer(myEditor));
        options.setSourceLineNumbersEnabled(false);
        options.enableCSTModelToken(true);
        
        IQVTReconcilingListener reconcilingListener = myEditor.getReconcilingListener();        
        CompiledUnit compilationResult = null;
        try {
			reconcilingListener.aboutToBeReconciled();
			
            compilationResult = QvtCompilerFacade.getInstance().compile(myEditor, myDocument, options, myMonitor);
        } catch (Exception ex) {
            if (loggedCompilationExceptionsCount < MAX_LOGGED_COMPILATION_EXCEPTIONS) {
                loggedCompilationExceptionsCount ++;
                Activator.log(ex);
                if (loggedCompilationExceptionsCount == MAX_LOGGED_COMPILATION_EXCEPTIONS) {
                    Activator.log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, Messages.QvtReconcilingStrategy_TooManyExceptions));
                }
            }
        } finally {
        reconcilingListener.reconciled(compilationResult);
        
        if (compilationResult != null) {
            MappingModuleCS mappingModuleCS = compilationResult.getPrimaryModuleCS();
            if(mappingModuleCS != null) {
	            addListPosition(mappingModuleCS.getImports(), positions);
	            addListPosition(mappingModuleCS.getImports(), positions);
	            addListPosition(mappingModuleCS.getMetamodels(), positions);
	            addListPosition(mappingModuleCS.getProperties(), positions);
	            addListPosition(mappingModuleCS.getRenamings(), positions);
            
	            for (MappingMethodCS method : mappingModuleCS.getMethods()) {
	                positions.add(createPosition(method.getStartOffset(), method.getEndOffset()));
	            }
            }
        }
        }
        
        myEditor.refresh();
        
        Display.getDefault().asyncExec(new Runnable(){
            public void run() {
                myEditor.updateFoldingStructure(positions);
            }
        });
    }
    
    private void addListPosition(final List<? extends CSTNode> list, final List<Position> positionList) {
        if (!list.isEmpty()) {
            int start = getStart(list);
            int end = getEnd(list);
            if (start >= 0 && end >= start) {
                positionList.add(createPosition(start, end));
            }
        }
    }
    
    private int getStart(final List<? extends CSTNode> list) {
        int start = Integer.MAX_VALUE;
        for (CSTNode element : list) {
            if (element != null) {
                start = Math.min(start, element.getStartOffset());
            }
        }
        return start;
    }
    
    private int getEnd(final List<? extends CSTNode> list) {
        int end = -1;
        for (CSTNode element : list) {
            if (element != null) {
                end = Math.max(end, element.getEndOffset());
            }
        }
        return end;
    }
    
    private QvtPosition createPosition(int start, int end) {
    	IRegion region = new Region(start, end - start);
		IRegion normalized = alignRegion(region);
		if (normalized != null) {
			region = normalized;
		}
    	return new QvtPosition(region.getOffset(), region.getLength());
    }
    
	/**
	 * Aligns <code>region</code> to start and end at a line offset. The
	 * region's start is decreased to the next line offset, and the end offset
	 * increased to the next line start or the end of the document.
	 * <code>null</code> is returned if <code>region</code> is
	 * <code>null</code> itself or does not comprise at least one line
	 * delimiter, as a single line cannot be folded.
	 * 
	 * @param region
	 *            the region to align, may be <code>null</code>
	 * @return a region equal or greater than <code>region</code> that is
	 *         aligned with line offsets, <code>null</code> if the region is
	 *         too small to be foldable (e.g. covers only one line)
	 */
	protected final IRegion alignRegion(IRegion region) {
		if (region == null) {
			return null;
		}

		try {
			int start = myDocument.getLineOfOffset(region.getOffset());
			int end = myDocument.getLineOfOffset(region.getOffset() + region.getLength());
			if (start >= end) {
				return null;
			}

			int offset = myDocument.getLineOffset(start);
			int endOffset;
			if (myDocument.getNumberOfLines() > end + 1) {
				endOffset = myDocument.getLineOffset(end + 1);
			} else {
				endOffset = myDocument.getLineOffset(end) + myDocument.getLineLength(end);
			}

			return new Region(offset, endOffset - offset);
		} catch (BadLocationException x) {
			// concurrent modification
			return null;
		}
	}
}