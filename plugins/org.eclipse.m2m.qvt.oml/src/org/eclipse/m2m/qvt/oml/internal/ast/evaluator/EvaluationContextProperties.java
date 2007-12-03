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

import org.eclipse.m2m.qvt.oml.library.IContext;

/**
 * This interface defines properties supported by QVT script evaluation and are passed
 * in {@link IContext context} object.
 * <p>
 * FIXME - move all known props here, for instance logger, spread around in qvtstdlib class etc.
 */
public interface EvaluationContextProperties {
	/**
	 * This property is expected to have {@link EvaluationMonitor evaluation monitor} as its value.
	 */
	String MONITOR = "org.eclipse.m2m.qvt.oml.internal.ast.evaluator.EvaluationMonitor"; //$NON-NLS-1N$
}
