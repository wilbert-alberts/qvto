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

package org.eclipse.m2m.qvt.oml.ast.environment;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author sboyko
 *
 */
public class QvtEvaluationResult {
	
	public QvtEvaluationResult(List<Resource> modelExtents) {
		myModelExtents = modelExtents;
	}
	
	public List<Resource> getModelExtents() {
		return myModelExtents;
	}
	
	private final List<Resource> myModelExtents;

}
