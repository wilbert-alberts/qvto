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
package org.eclipse.m2m.internal.qvt.oml.runtime.launch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.runtime.QvtRuntimePlugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData.TargetType;
import org.eclipse.m2m.qvt.oml.library.IConfiguration;
import org.eclipse.m2m.qvt.oml.library.QvtConfiguration;


public class QvtLaunchUtil {
	private QvtLaunchUtil() {}

	public static List<TargetUriData> getTargetUris(ILaunchConfiguration configuration) throws CoreException {
    	int elemCount = configuration.getAttribute(IQvtLaunchConstants.ELEM_COUNT, 0);
		List<TargetUriData> targetUris = new ArrayList<TargetUriData>(elemCount);
    	for (int i = 0; i < elemCount; ++i) {
    		TargetUriData targetData = QvtLaunchUtil.getTargetUriData(configuration, i+1);
    		targetUris.add(targetData);
    	}
    	return targetUris;
	}
	
    public static TargetUriData getTargetUriData(ILaunchConfiguration configuration) throws CoreException {
    	return getTargetUriData(configuration, 0);
    }
    
    public static TargetUriData getTargetUriData(ILaunchConfiguration configuration, int index) throws CoreException {
    	TargetUriData.TargetType targetType = TargetUriData.TargetType.NEW_MODEL;
    	try {
   	        targetType = TargetType.valueOf(configuration.getAttribute(getIndexedName(IQvtLaunchConstants.TARGET_TYPE, index), "NEW_MODEL")); //$NON-NLS-1$
    	}
    	catch (Exception e) {
    		targetType = TargetUriData.TargetType.NEW_MODEL;
    	}
    	
        String uri = configuration.getAttribute(getIndexedName(IQvtLaunchConstants.TARGET_MODEL, index), ""); //$NON-NLS-1$
    	String feature = configuration.getAttribute(getIndexedName(IQvtLaunchConstants.FEATURE_NAME, index), ""); //$NON-NLS-1$
    	boolean clearContents = configuration.getAttribute(getIndexedName(IQvtLaunchConstants.CLEAR_CONTENTS, index), true); 
    	
    	return new TargetUriData(targetType, uri, feature, clearContents);
    }
    
	public static void saveTargetUriData(ILaunchConfigurationWorkingCopy configuration, TargetUriData targetData) {
		saveTargetUriData(configuration, targetData, 0);
	}
    
    public static void saveTargetUriData(ILaunchConfigurationWorkingCopy configuration, TargetUriData targetData, int index) {
    	configuration.setAttribute(getIndexedName(IQvtLaunchConstants.TARGET_TYPE, index), targetData.getTargetType().toString()); 
		configuration.setAttribute(getIndexedName(IQvtLaunchConstants.TARGET_MODEL, index), targetData.getUriString()); 
    	configuration.setAttribute(getIndexedName(IQvtLaunchConstants.FEATURE_NAME, index), targetData.getFeature()); 
    	configuration.setAttribute(getIndexedName(IQvtLaunchConstants.CLEAR_CONTENTS, index), targetData.isClearContents()); 
    }
    
    public static String getTraceFileName(URI uri) {
        IFile file = org.eclipse.m2m.qvt.oml.emf.util.URIUtils.getFile(uri);
        if(file == null) {
            return null;
        }
        
        IPath traceFilePath = new Path(file.getParent().getFullPath() + "/" + file.getName() + MDAConstants.QVTO_TRACEFILE_EXTENSION_WITH_DOT);  //$NON-NLS-1$
        return traceFilePath.toString();
    }
    
    public static IConfiguration getConfiguration(ILaunchConfiguration configuration) {
        Map<String, String> map = loadConfigurationProperties(configuration);
        return new QvtConfiguration(map);
    }

    @SuppressWarnings("unchecked")
    public static Map<String, String> loadConfigurationProperties(ILaunchConfiguration configuration) {
        Map<String, String> map;
        try {
            map = configuration.getAttribute(IQvtLaunchConstants.CONFIGURATION_PROPERTIES, Collections.<String, String>emptyMap());            
        } catch (CoreException e) {
            map = Collections.<String, String>emptyMap();
           QvtRuntimePlugin.getDefault().getLog().log(MiscUtil.makeErrorStatus(e)); 
        }
        return map;
    }
    
    private static String getIndexedName(String name, int index){
    	if (index == 0) {
    		return name;
    	}
    	return name + index;
    }
    
}

