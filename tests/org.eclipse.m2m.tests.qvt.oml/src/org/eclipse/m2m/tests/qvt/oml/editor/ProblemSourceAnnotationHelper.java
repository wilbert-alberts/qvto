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
package org.eclipse.m2m.tests.qvt.oml.editor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.m2m.qvt.oml.QvtMessage;
import org.eclipse.m2m.tests.qvt.oml.util.SourceAnnotationReader.AnnotationData;


public class ProblemSourceAnnotationHelper {
	
	private static final String ERROR_TAG = "error"; //$NON-NLS-1$
	private static final String WARN_TAG = "warn"; //$NON-NLS-1$
	
	Map<Position, AnnotationData> fPositionedMap = new HashMap<Position, AnnotationData>();
	
	ProblemSourceAnnotationHelper(List<AnnotationData> annotations) {
		for (AnnotationData nextAnnotation : annotations) {
			IRegion region = nextAnnotation.getAnnotatedRegion();
			fPositionedMap.put(new Position(region.getOffset(), region.getLength()), nextAnnotation);
		}
	}
		
	public static boolean isTheSameSeverity(AnnotationData sourceAnnotation, QvtMessage message) {
		return (message.getSeverity() == QvtMessage.SEVERITY_ERROR && isError(sourceAnnotation)) ||
		(message.getSeverity() == QvtMessage.SEVERITY_WARNING && isWarning(sourceAnnotation));
	}
	
	public AnnotationData findAnnotationByPosition(QvtMessage message) {		
		return fPositionedMap.get(new Position(message.getOffset(), message.getLength()));
	}
	
	public static boolean isError(AnnotationData sourceAnnotation) {
		return ERROR_TAG.equals(sourceAnnotation.getName());
	}

	public static boolean isWarning(AnnotationData sourceAnnotation) {
		return WARN_TAG.equals(sourceAnnotation.getName());
	}
}
