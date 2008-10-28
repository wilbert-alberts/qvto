/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.blackbox.java;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Library operation
 */
@Retention(RetentionPolicy.RUNTIME)	
@Target(ElementType.METHOD)
public @interface Operation {
	
	public enum Kind {
		HELPER,
		QUERY,
		OPERATION
	};

	/**
	 * Indicates whether this operation is contextual
	 * @return 
	 */
	boolean contextual() default false;		
	
	Kind kind() default Kind.HELPER;

	String description() default "";		
}