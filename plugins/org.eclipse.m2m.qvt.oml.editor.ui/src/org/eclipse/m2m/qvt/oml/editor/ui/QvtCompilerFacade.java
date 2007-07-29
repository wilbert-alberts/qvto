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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.m2m.qvt.oml.QvtEngine;
import org.eclipse.m2m.qvt.oml.QvtMessage;
import org.eclipse.m2m.qvt.oml.QvtPlugin;
import org.eclipse.m2m.qvt.oml.builder.QvtBuilderConfig;
import org.eclipse.m2m.qvt.oml.common.Logger;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompilationResult;
import org.eclipse.m2m.qvt.oml.ocl.completion.CompletionData;
import org.eclipse.ui.part.FileEditorInput;

/**
 * @author vrepeshko
 */
public class QvtCompilerFacade {
	
	private QvtCompilerFacade() {}
	
	public QvtCompilationResult compile(final QvtEditor editor, final IDocument document, 
			final boolean reportProblems, IProgressMonitor monitor) {
		return compile(editor, document, true, reportProblems, monitor);
	}
	
	public QvtCompilationResult compile(final QvtEditor editor, final IDocument document, 
			final boolean generateCompletionData, final boolean reportProblems, IProgressMonitor monitor) {
		if (!checkEditor(editor)) {
			return null;
		}
		
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }
        monitor.beginTask(Messages.QvtCompilerFacade_compilingDoc , 4);
        QvtCompilationResult result = null;
		
		try {
			monitor.subTask(Messages.QvtCompilerFacade_acquiringDoc);
			IFile file = ((FileEditorInput) editor.getEditorInput()).getFile();
			QvtDocumentProvider documentProvider = (QvtDocumentProvider) editor.getDocumentProvider();
			
			final String contents = document.get();
			final long timeStamp = System.currentTimeMillis();
			monitor.worked(1);
			
			try {
				EclipseFile source = new EclipseFile(file) {
					@Override
					public InputStream getContents() {
						try {
							return new ByteArrayInputStream(contents.getBytes(getCharset()));
						} 
						catch(IOException e) {
							throw new RuntimeException(e);
						}  
					}
					
					@Override
					public String getCharset() throws IOException {
						return "UTF-8"; //$NON-NLS-1$
					}
					
					@Override
					public long getTimeStamp() {
//						return ((IDocumentExtension4) document).getModificationStamp();
						return timeStamp;
					}
				};
				
				QvtEngine engine = QvtEngine.getInstance(file);
				
                result = engine.compile(source, generateCompletionData, new SubProgressMonitor(monitor, 2));
                
                if (result != null) {
                    documentProvider.setMappingModule(result.getModule());
                    documentProvider.setCompletionData(result.getCompletionData());
                }
            } catch (MdaException e) {
                documentProvider.setMappingModule(result != null ? result.getModule() : null);
                documentProvider.setCompletionData(CompletionData.EMPTY);
                Logger.getLogger().log(Logger.SEVERE, "Error during compiling document", e); //$NON-NLS-1$
            }
            
            if (reportProblems) {
            	reportProblems(result, editor.getAnnotationModel());
            }
        } finally {
            monitor.done();
        }
        return result;
	}
	
	private void reportProblems(QvtCompilationResult compilationResult, IAnnotationModel model) {
		if (compilationResult == null || model == null || model.getAnnotationIterator() == null) {
			return;
		}
		
		List<Annotation> annotationsToRemove = new ArrayList<Annotation>();
		for (Iterator<?> iter = model.getAnnotationIterator(); iter.hasNext();) {
			Annotation annotation = (Annotation) iter.next();
			if (IQvtAnnotationTypes.ERROR.equals(annotation.getType())
					|| IQvtAnnotationTypes.WARNING.equals(annotation.getType())) {
				annotationsToRemove.add(annotation);
			}
		}
		
		Map<Annotation, Position> annotationsToAdd = new HashMap<Annotation, Position>();
		for (QvtMessage problem : compilationResult.getMessages()) {
			if (checkProblem(problem)) {
				annotationsToAdd.put(createProblemAnnotation(problem), createProblemPosition(problem));
			}
		}
		
		if (model instanceof IAnnotationModelExtension) {
			IAnnotationModelExtension modelExtension = ((IAnnotationModelExtension) model);
			modelExtension.replaceAnnotations(annotationsToRemove.toArray(new Annotation[annotationsToRemove.size()]), annotationsToAdd);
		} else {
			for (Annotation annotation : annotationsToRemove) {
				model.removeAnnotation(annotation);
			}
			for (Map.Entry<Annotation, Position> entry : annotationsToAdd.entrySet()) {
				model.addAnnotation(entry.getKey(), entry.getValue());
			}
		}
	}

	private boolean checkProblem(QvtMessage problem) {
		return problem != null && problem.getOffset() >= 0 && problem.getLength() >= 0;
	}
	
	private Annotation createProblemAnnotation(QvtMessage problem) {
		return new Annotation(getAnnotationType(problem.getSeverity()), true, problem.getMessage());
	}
	
	private String getAnnotationType(int severity) {
		switch (severity) {
		case IMarker.SEVERITY_ERROR:
			return IQvtAnnotationTypes.ERROR;
		case IMarker.SEVERITY_WARNING:
			return IQvtAnnotationTypes.WARNING;
		}
		throw new IllegalArgumentException();
	}
	
	private Position createProblemPosition(QvtMessage problem) {
		return new Position(problem.getOffset(), problem.getLength());
	}
	
	public static QvtCompilerFacade getInstance() {
		if (ourInstance == null) {
			ourInstance = new QvtCompilerFacade();
		}
		return ourInstance;
	}
	
	private boolean checkEditor(final QvtEditor editor) {
		return editor != null 
			&& editor.getEditorInput() instanceof FileEditorInput
			&& editor.getDocumentProvider() != null;
	}
	
	static boolean isEditingInQvtSourceContainer(QvtEditor editor) {
		if(editor.getEditorInput() == null) {
			return false;
		}
		IFile file = ((FileEditorInput) editor.getEditorInput()).getFile();
		if(file != null && file.exists()) {
			try {
				IContainer srcContainer = QvtBuilderConfig.getConfig(file.getProject()).getSourceContainer();
				if(srcContainer.exists()) {
					IPath editedPath = file.getFullPath();
					IPath srcPath = srcContainer.getFullPath();
					return srcPath.isPrefixOf(editedPath);
				}
			} catch (CoreException e) {
				QvtPlugin.log(e);
			}
		}
		return false;
	}
	
	private static QvtCompilerFacade ourInstance;
}
