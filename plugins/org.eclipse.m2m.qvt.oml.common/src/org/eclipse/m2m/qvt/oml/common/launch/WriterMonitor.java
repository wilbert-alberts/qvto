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
package org.eclipse.m2m.qvt.oml.common.launch;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.IStreamListener;
import org.eclipse.debug.core.model.IStreamMonitor;

/**
 * @author vrepeshko
 */
public class WriterMonitor extends Writer implements IStreamMonitor {

	@Override
	public void close() throws IOException {
	}

	@Override
	public void flush() throws IOException {
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		String newText = new String(cbuf, off, len);
		myContents.append(newText);
		notifyListeners(newText);
	}
	
	public String getContents() {
		return myContents.toString();
	}
	
	private void notifyListeners(String newText) {
		if (myListeners == null) {
			return;
		}
		IStreamListener[] listeners = myListeners.toArray(new IStreamListener[myListeners.size()]);
		for (IStreamListener listener : listeners) {
			listener.streamAppended(newText, this);
		}
	}
	
	public void addListener(IStreamListener listener) {
		if (myListeners == null) {
			myListeners = new ArrayList<IStreamListener>(1);
		}
		if (!myListeners.contains(listener)) {
			myListeners.add(listener);
		}
	}

	public void removeListener(IStreamListener listener) {
		if (myListeners == null) {
			return;
		}
		myListeners.remove(listener);
	}
	
	private List<IStreamListener> myListeners;
	
	private final StringBuffer myContents = new StringBuffer();
	
}
