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
package org.eclipse.m2m.internal.qvt.oml.evaluator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalTypesUtil;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.osgi.util.NLS;

/**
 * @author sboyko
 */
class QvtChangeRecorder extends ChangeRecorder {

	private final String fModelParamName;
	private final String fModelTypeName;
	
	QvtChangeRecorder(ModelParameter modelParam) {
		if(modelParam == null) {
			throw new IllegalArgumentException();
		}
		
		fModelParamName = modelParam.getName();
		fModelTypeName = QvtOperationalTypesUtil.getTypeFullName(modelParam.getEType());		
	}
	
	@Override
	public void notifyChanged(Notification notification) {
		if (notification.getOldValue() != this) {
			switch(notification.getEventType()) {
			case Notification.SET:
			case Notification.UNSET:
			case Notification.ADD:
			case Notification.REMOVE:
			case Notification.ADD_MANY:
			case Notification.REMOVE_MANY:
			case Notification.MOVE:				
				throw new RuntimeException(NLS.bind(EvaluationMessages.ExtendedOclEvaluatorVisitorImpl_ReadOnlyInputModel,
					fModelParamName + " : " + fModelTypeName)); //$NON-NLS-1$
			}
		}
		//super.notifyChanged(notification);
	}
}
