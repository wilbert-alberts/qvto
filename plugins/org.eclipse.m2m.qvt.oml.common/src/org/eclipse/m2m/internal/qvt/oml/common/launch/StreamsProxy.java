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
package org.eclipse.m2m.internal.qvt.oml.common.launch;

import java.io.IOException;
import java.io.Writer;

import org.eclipse.debug.core.model.IStreamMonitor;
import org.eclipse.debug.core.model.IStreamsProxy;

/**
 * @author vrepeshko
 */
public class StreamsProxy implements IStreamsProxy {

	public StreamsProxy() {
		myOutputStreamMonitor = new WriterMonitor();
	}
	
	public IStreamMonitor getErrorStreamMonitor() {
		return null;
	}

	public IStreamMonitor getOutputStreamMonitor() {
		return myOutputStreamMonitor;
	}
	
	public Writer getOutputWriter() {
		return myOutputStreamMonitor;
	}

	public void write(String input) throws IOException {
	}
	
	private final WriterMonitor myOutputStreamMonitor;

}
