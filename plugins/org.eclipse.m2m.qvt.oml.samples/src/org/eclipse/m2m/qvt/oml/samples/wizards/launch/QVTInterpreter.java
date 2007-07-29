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
package org.eclipse.m2m.qvt.oml.samples.wizards.launch;

import java.util.HashMap;
import java.util.Map;

public class QVTInterpreter implements ILaunchData{
	
	private static final String TRANSFORMATION_TYPE = "org.eclipse.m2m.qvt.oml.QvtTransformation"; //$NON-NLS-1$
	
	public final static String NEW_MODEL = "NEW_MODEL"; //$NON-NLS-1$
	public final static String EXISTING_CONTAINER = "EXISTING_CONTAINER"; //$NON-NLS-1$
	public final static String INPLACE = "INPLACE"; //$NON-NLS-1$

	public QVTInterpreter(String format, Data self, Data source, Data target) {
		myFormat = format;
		mySource = source;
		myTarget = target;
		mySelf = self;
	}
	
	public void addParameter(String key, String value){
		if(key == null || value == null){
			throw new IllegalArgumentException();
		}
		myMap.put(key, value);
	}
	
	public Map<String, Object> getAttributesMap() {
		Map<String, Object> atrMap = new HashMap<String, Object>();
		atrMap.put(TARGET_TYPE, myFormat);
		atrMap.put(MODULE, mySelf.getURI());
		atrMap.put(CONFIGURATION_PROPERTIES, myMap);
		atrMap.put(SOURCE_MODEL, mySource.getURI());
		atrMap.put(TARGET_MODEL, myTarget.getURI());
		return atrMap;
	}
	
	public String getTransformationType() {
		return TRANSFORMATION_TYPE;
	}
	
	private final String myFormat;
	private final Data mySelf;
	private final Data mySource;
	private final Data myTarget;
	
	private final Map<String, String> myMap = new HashMap<String, String>(); 
	
	private static final String PREFIX = "org.eclipse.m2m.qvt.oml.interpreter."; //$NON-NLS-1$
	private static final String TARGET_TYPE = PREFIX + "targetType"; //$NON-NLS-1$
	private static final String MODULE = PREFIX + "module"; //$NON-NLS-1$
	private static final String CONFIGURATION_PROPERTIES = PREFIX + "configurationProperties";  //$NON-NLS-1$
	private static final String SOURCE_MODEL = PREFIX + "sourceModel";  //$NON-NLS-1$
	private static final String TARGET_MODEL = PREFIX + "targetModel"; //$NON-NLS-1$
	
	public final static String TARGET_TYPE_TEMPLATE = "{0}"; //$NON-NLS-1$
	public final static String MODULE_TEMPLATE = "/{0}/{1}"; //$NON-NLS-1$
}
