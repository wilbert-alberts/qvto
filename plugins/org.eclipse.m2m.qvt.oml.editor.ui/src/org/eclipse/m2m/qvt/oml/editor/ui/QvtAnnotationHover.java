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
import java.util.Iterator;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.ISourceViewerExtension2;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.AnnotationPreference;

import org.eclipse.m2m.qvt.oml.common.Logger;

public class QvtAnnotationHover implements IAnnotationHover {

	public String getHoverInfo(final ISourceViewer sourceViewer, final int lineNumber) {
        IDocument document = sourceViewer.getDocument();
        IAnnotationModel model = getAnnotationModel(sourceViewer);
        
		if (model == null) {
			return null;
		}
			
		ArrayList<String> lines = new ArrayList<String>();
		for (Iterator<?> iter = model.getAnnotationIterator(); iter.hasNext();) {
			Annotation annotation = (Annotation) iter.next();
			if (includeAnnotation(annotation, model, document, lineNumber)) {
				lines.add(annotation.getText());
			}
		}
		
		if (lines.isEmpty()) {
			return ""; //$NON-NLS-1$
		} else if (lines.size() == 1) {
			return lines.get(0);
		} 
		
		StringBuffer result = new StringBuffer();
		result.append(Messages.QvtAnnotationHover_multipleMarkers);
		for (Iterator<String> iter = lines.iterator(); iter.hasNext();) {
			String line = iter.next();
			result.append("\n\t"); //$NON-NLS-1$
			result.append(line);
		}
		return result.toString();
	}
	
	protected boolean includeAnnotation(final Annotation annotation, final IAnnotationModel model,
			final IDocument document, final int lineNumber) {
		AnnotationPreference preference = EditorsUI.getAnnotationPreferenceLookup().getAnnotationPreference(annotation);
		Position position = model.getPosition(annotation);
		if (preference != null 
				&& preference.getVerticalRulerPreferenceValue()
				&& position != null) {
			try {
                int annotationLine = document.getLineOfOffset(position.getOffset());
                if (annotationLine == lineNumber
                        || (annotationLine <= lineNumber && document.getLineOfOffset(position.getOffset()
                                        + position.getLength()) >= lineNumber)) {
                	return annotation.getText() != null;
                }
            } catch (BadLocationException ex) {
                Logger.getLogger().log(Logger.WARNING, "Exception during getting annotation info", ex); //$NON-NLS-1$
            }
		}
		return false;
	}

	protected IAnnotationModel getAnnotationModel(final ISourceViewer sourceViewer) {
		if (sourceViewer instanceof ISourceViewerExtension2) {
			return ((ISourceViewerExtension2) sourceViewer).getVisualAnnotationModel();
		}
		return sourceViewer.getAnnotationModel();
	}
	
}
