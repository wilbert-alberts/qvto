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

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;

/**
* Represents a runtime (unchecked) exception possibly thrown during QVT code execution.
*/
public class QvtRuntimeException extends RuntimeException {

	/**
	 * A helper interface providing stack trace details.
	 */
	public interface StackInfoProvider {
		List<StackTraceElement> getStackTraceElements();
	}
	
	private static final long serialVersionUID = -8903219155434276631L;	
	
	private List<StackTraceElement> fStackTrace;
	

	public QvtRuntimeException() {
		super();
	}
	
	
	public QvtRuntimeException(String message) {
		super(message);
	}
		
	public QvtRuntimeException(Throwable cause) {
		super(cause);
	}

	public QvtRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}	
	
	/**
	 * Throws the given instance of QVT exception.
	 * 
	 * @param exception
	 *            the exception to be thrown
	 * @param stackInfoProvider
	 *            helper providing stack details
	 * @throws QvtRuntimeException
	 *             the instance passed in <code>exception</code>
	 */
	public static void doThrow(QvtRuntimeException exception, StackInfoProvider stackInfoProvider) throws QvtRuntimeException {
		try {
			exception.setStackQvtTrace(stackInfoProvider.getStackTraceElements());
		} catch (Exception e) {
			QvtPlugin.log(QvtPlugin.createErrorStatus("Failed to build QVT stack trace", e)); //$NON-NLS-1$
		}
		
		throw exception;
	}	
	
    public void printQvtStackTrace(PrintWriter pw) {
       synchronized (pw) {
            pw.println(this);
            int counter = 0;
            for(StackTraceElement trace : getQvtStackTrace()) {
            	if(counter++ > 0) {
            		pw.println();
            	}
            	pw.print("\tat " + trace); //$NON-NLS-1$
            }
       }
    }	
	
	public List<StackTraceElement> getQvtStackTrace() {		
		if(fStackTrace != null) {
			return Collections.unmodifiableList(fStackTrace);
		}
		return Collections.emptyList();
	}
	
	void setStackQvtTrace(List<StackTraceElement> stackTrace) {
		fStackTrace = null;
		if(stackTrace != null) {
			fStackTrace = new ArrayList<StackTraceElement>(stackTrace);
		}
	}		
}
