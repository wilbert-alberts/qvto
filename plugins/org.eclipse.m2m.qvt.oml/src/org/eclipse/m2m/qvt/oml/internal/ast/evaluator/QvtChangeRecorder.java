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
package org.eclipse.m2m.qvt.oml.internal.ast.evaluator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalTypesUtil;
import org.eclipse.m2m.qvt.oml.expressions.ModelParameter;
import org.eclipse.osgi.util.NLS;

/**
 * @author sboyko
 */
public class QvtChangeRecorder extends ChangeRecorder {
	
	public QvtChangeRecorder(ModelParameter modelParam) {
		myModelParam = modelParam;
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
					myModelParam.getName() + " : " + QvtOperationalTypesUtil.getTypeFullName(myModelParam.getEType()))); //$NON-NLS-1$
			}
		}
		//super.notifyChanged(notification);
	}

	private final ModelParameter myModelParam;
}
