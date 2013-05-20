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
package org.eclipse.m2m.qvt.oml.util;

import java.util.Collection;
import java.util.List;

/**
 * A hash-map based dictionary representing the <code>Stdlib::DictionaryType</code>.
 * 
 * @author dvorak
 * 
 * @since 2.0
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface Dictionary<KeyT, T> extends Collection<T> {

	T get(KeyT k);

	void put(KeyT k, T v);

	boolean hasKey(KeyT k);

	T defaultget(KeyT k, T v);

	List<KeyT> keys();

	List<T> values();
	
    void clear();	
}