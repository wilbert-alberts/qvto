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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.hyperlinks;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;


/**
 * @author vrepeshko
 */
public class QvtFileHyperlink extends AbstractHyperlink implements IHyperlink {
	
	private final CFile myDestinationFile;
	
	private final IRegion myDestinationRevealRegion;
	
	private final IRegion myDestinationSelectRegion;
	
	
	public QvtFileHyperlink(IRegion hyperlinkRegion, CFile destinationFile, 
			IRegion destinationRevealRegion, IRegion destinationSelectRegion) {
		super(hyperlinkRegion);
		if (destinationFile == null) {
			throw new IllegalArgumentException();
		}
		
		
		
		myDestinationFile = destinationFile;
		myDestinationRevealRegion = destinationRevealRegion;
		myDestinationSelectRegion = destinationSelectRegion;
	}

	public void open() {
		try {
			IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			if (activeWorkbenchWindow == null) {
				return;
			}
			IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
			if (activePage == null) {
				return;
			}
            
            // If you want to be able to return to the intial location, uncomment the line below
            activePage.getNavigationHistory().markLocation(activePage.getActiveEditor());

			IFile file = getEclipseFile();
			if(file == null) {
				return;
			}
			
            FileEditorInput fileEditorInput = new FileEditorInput(file);
			QvtEditor newEditor = (QvtEditor) activePage.openEditor(fileEditorInput, QvtEditor.ID, true);
			ISourceViewer viewer = newEditor.getSourceViewerOpened();
			if (viewer == null || viewer.getTextWidget().isDisposed()) {
				return;
			}
			if (myDestinationRevealRegion != null) {
				viewer.revealRange(myDestinationRevealRegion.getOffset(), myDestinationRevealRegion.getLength());
			}
			if (myDestinationSelectRegion != null) {
				viewer.setSelectedRange(myDestinationSelectRegion.getOffset(), myDestinationSelectRegion.getLength());
			}

            activePage.getNavigationHistory().markLocation(activePage.getActiveEditor());
		} catch (PartInitException e) {
			// ignored
		}
	}
	
	private IFile getEclipseFile() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IPath location = new Path(myDestinationFile.getFullPath());
		IFile ifile = workspace.getRoot().getFileForLocation(location);
		return ifile;
	}
}
