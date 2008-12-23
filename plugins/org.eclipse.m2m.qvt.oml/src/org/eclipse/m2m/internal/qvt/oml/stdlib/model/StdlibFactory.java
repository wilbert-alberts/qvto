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
package org.eclipse.m2m.internal.qvt.oml.stdlib.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QVTStackTraceElement;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.ListType;

public class StdlibFactory {

	private StdlibPackage fStdlibPackage;
	
	public StdlibFactory(StdlibPackage stdlibPackage) {
		if(stdlibPackage == null) {
			throw new IllegalArgumentException("null stdlib package"); //$NON-NLS-1$
		}
		
		fStdlibPackage = stdlibPackage;
	}
	
	public ListType createList(EClassifier elementType) {
		ListType listType = ExpressionsFactory.eINSTANCE.createListType();
		listType.setElementType(elementType);
		return listType;
	}
	
	public StatusInstance createSuccess() {
		Status status = new Status(true, null);
		status.eSetClass(fStdlibPackage.getStatusClass());
		return status;
	}
	
	public StatusInstance createFailure(ExceptionInstance exception) {
		Status status = new Status(false, exception);
		status.eSetClass(fStdlibPackage.getStatusClass());
		return status;
	}
	
	public ExceptionInstance createException(String argument, List<QVTStackTraceElement> stackElements) {
		ExceptionImpl exception = new ExceptionImpl(argument, stackElements);
		exception.eSetClass(fStdlibPackage.getExceptionClass());
		return exception;
	}	
	
	private static class ExceptionImpl extends DynamicEObjectImpl implements ExceptionInstance {
		
		private final String fArgument;
		private final List<QVTStackTraceElement> fStackElements;		
		
		public ExceptionImpl(String argument, List<QVTStackTraceElement> stackElements) {
			fArgument = argument;
			fStackElements = Collections.unmodifiableList(new ArrayList<QVTStackTraceElement>(stackElements));
		}
		
		public String getArgument() {		
			return fArgument;
		}
		
		public List<QVTStackTraceElement> getStackElements() {
			return (fStackElements != null) ? fStackElements : Collections.<QVTStackTraceElement>emptyList();
		}
		
		@Override
		public String toString() {
			StringBuilder buf = new StringBuilder();
			buf.append(eClass.getName());
			if(getArgument() != null) {
				buf.append(" : ").append(fArgument); //$NON-NLS-1$
			}
			
			return buf.toString();
		}
	}

	private static class Status extends EObjectImpl implements StatusInstance {
		private boolean fIsSuccess;
		private ExceptionInstance fException;
		
		private Status(boolean isSuccess, ExceptionInstance exception) {
			fIsSuccess = isSuccess;
			fException = exception;
		}
		
		public boolean succeeded() {		
			return fIsSuccess;
		}

		public boolean failed() {		
			return !succeeded();
		}
		
		public ExceptionInstance raisedException() {
			return fException;
		}
		
		@Override
		public String toString() {
			StringBuilder buf = new StringBuilder(); 
			buf.append(fIsSuccess ? "SUCCESS" : "FAILED"); //$NON-NLS-1$ //$NON-NLS-1$
			if(fException != null) {
				buf.append(" raised: (").append(fException).append(')'); //$NON-NLS-1$
			}
			return buf.toString();
		}
	}	
}
