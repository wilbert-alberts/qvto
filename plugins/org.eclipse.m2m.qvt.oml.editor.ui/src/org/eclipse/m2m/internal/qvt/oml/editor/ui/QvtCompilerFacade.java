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

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.project.builder.QVTOBuilderConfig;
import org.eclipse.m2m.internal.qvt.oml.project.builder.WorkspaceUnitResolver;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * @author vrepeshko
 */
public class QvtCompilerFacade {
	
	private QvtCompilerFacade() {}
	
	public CompiledUnit compile(final ITextEditor editor, final IDocument document, 
			QvtCompilerOptions options, IProgressMonitor monitor) {
		if (!checkEditor(editor)) {
			return null;
		}
		
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }
        monitor.beginTask(Messages.QvtCompilerFacade_compilingDoc , 4);
        CompiledUnit result = null;
		
		try {
			monitor.subTask(Messages.QvtCompilerFacade_acquiringDoc);
			IFile file = ((FileEditorInput) editor.getEditorInput()).getFile();
			QvtDocumentProvider documentProvider = (QvtDocumentProvider) editor.getDocumentProvider();
			
			monitor.worked(1);

			final String contents = document.get();			
			try {				
				final UnitProxy unit = WorkspaceUnitResolver.getUnit(file);			
				QVTOCompiler compiler = new QVTOCompiler(unit.getResolver()) {
					@Override
					protected Reader createReader(UnitProxy source) throws IOException {
						if(source.equals(unit)) {
							return new StringReader(contents);
						}
						
						return super.createReader(source);
					}
				};								
				
                result = compiler.compile(unit, options, new BasicMonitor.EclipseSubProgress(monitor, 2));
                
                if (result != null) {
                    documentProvider.setMappingModule(result);
                }
            } catch (MdaException e) {
                documentProvider.setMappingModule(result);
                Activator.log(e);
            }
            
            if (options.isReportErrors() && options.isShowAnnotations()) {
            	//reportProblems(result, editor.getAnnotationModel());
            }
        } finally {
            monitor.done();
        }
        return result;
	}	
	
	public static QvtCompilerFacade getInstance() {
		if (ourInstance == null) {
			ourInstance = new QvtCompilerFacade();
		}
		return ourInstance;
	}
	
	private boolean checkEditor(final ITextEditor editor) {
		return editor != null 
			&& editor.getEditorInput() instanceof FileEditorInput
			&& editor.getDocumentProvider() != null;
	}
	
	static boolean isEditingInQvtSourceContainer(ITextEditor editor) {
		IEditorInput editorInput = editor.getEditorInput();
		if(editorInput instanceof IFileEditorInput == false) {
			return false;
		}

		IFile file = ((FileEditorInput) editorInput).getFile();
		if(file != null && file.exists()) {
			try {
				IContainer srcContainer = QVTOBuilderConfig.getConfig(file.getProject()).getSourceContainer();
				if(srcContainer.exists()) {
					IPath editedPath = file.getFullPath();
					IPath srcPath = srcContainer.getFullPath();
					return srcPath.isPrefixOf(editedPath);
				}
			} catch (CoreException e) {
				QvtPlugin.getDefault().log(e.getStatus());
			}
		}
		return false;
	}
	
	private static QvtCompilerFacade ourInstance;
}
