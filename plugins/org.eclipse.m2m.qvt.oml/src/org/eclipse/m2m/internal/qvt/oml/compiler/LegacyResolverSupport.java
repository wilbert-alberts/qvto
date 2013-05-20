/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.compiler;

/**
 * The purpose of this interface is solely to realize the 
 * legacy support for imports from deployed transformations
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=240192
 */
public interface LegacyResolverSupport extends UnitResolver {
	
	@Deprecated
	UnitProxy resolveUnit(UnitProxy fromUnit, String qualifiedName);
	
}
