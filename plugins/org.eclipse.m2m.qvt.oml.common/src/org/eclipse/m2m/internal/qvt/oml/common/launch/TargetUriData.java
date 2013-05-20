/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
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

import org.eclipse.emf.common.util.URI;

public class TargetUriData {
	public TargetUriData(String uri) {
		this(TargetType.NEW_MODEL, uri, "", true); //$NON-NLS-1$
	}
	
	public static enum TargetType {
		NEW_MODEL,
		EXISTING_CONTAINER,
		INPLACE;
	}
	
	public TargetUriData(TargetType newModel, String uri, String feature, boolean clearContents) {
		myTargetType = newModel;
		myUriString = uri;
		myFeature = feature;
		myClearContents = clearContents;
	}
	
	public TargetUriData(TargetUriData d) {
		this(d.myTargetType, d.myUriString, d.myFeature, d.myClearContents);
	}
	
	public boolean isClearContents() {
		return myClearContents;
	}

	public String getFeature() {
		return myFeature;
	}

	public TargetType getTargetType() {
		return myTargetType;
	}

	public String getUriString() {
		return myUriString;
	}
	
	public URI getUri() {
		if(myUriString == null) {
			return null;
		}
		
		return URI.createURI(myUriString);
	}		
	
	private final TargetType myTargetType;
	private final String myUriString;
	private final String myFeature;
	private final boolean myClearContents;
}
