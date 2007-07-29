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

import java.util.Collections;
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
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData.TargetType;
import org.eclipse.m2m.qvt.oml.library.IConfiguration;
import org.eclipse.m2m.qvt.oml.library.QvtConfiguration;


public class QvtLaunchUtil {
	private QvtLaunchUtil() {}
	
    public static TargetUriData getTargetUriData(ILaunchConfiguration configuration) throws CoreException {
    	TargetUriData.TargetType targetType = null;        
    	try {
    	    if (configuration.getAttributes().containsKey(IQvtLaunchConstants.TARGET_TYPE)) {
    	        targetType = TargetType.valueOf(configuration.getAttribute(IQvtLaunchConstants.TARGET_TYPE, "NEW_MODEL")); //$NON-NLS-1$
            }
    	}
    	catch(Exception e) {
    		targetType = null;
    	}
    	
        String uri = configuration.getAttribute(IQvtLaunchConstants.TARGET_MODEL, ""); //$NON-NLS-1$
    	String feature = configuration.getAttribute(IQvtLaunchConstants.FEATURE_NAME, ""); //$NON-NLS-1$
    	boolean clearContents = configuration.getAttribute(IQvtLaunchConstants.CLEAR_CONTENTS, true); 
    	
        // Support for old LCs
        if(targetType == null) {
            String source = configuration.getAttribute(IQvtLaunchConstants.SOURCE_MODEL, ""); //$NON-NLS-1$
            URI sourceUri = URI.createURI(source);
            URI targetUri = URI.createURI(uri);
            if (sourceUri.equals(targetUri)) {
                if (sourceUri.segmentCount() == 0) {
                    targetType = TargetType.NEW_MODEL;
                } else {
                    targetType = TargetType.INPLACE;
                }
            } else {
                if (targetUri.hasFragment()) {
                    targetType = TargetType.EXISTING_CONTAINER;
                } else {
                    targetType = TargetType.NEW_MODEL;
                }
            }
        }            
            
    	return new TargetUriData(targetType, uri, feature, clearContents);
    }
    
    public static void saveTargetUriData(ILaunchConfigurationWorkingCopy configuration, TargetUriData targetData) {
    	configuration.setAttribute(IQvtLaunchConstants.TARGET_TYPE, targetData.getTargetType().toString()); 
		configuration.setAttribute(IQvtLaunchConstants.TARGET_MODEL, targetData.getUriString()); 
    	configuration.setAttribute(IQvtLaunchConstants.FEATURE_NAME, targetData.getFeature()); 
    	configuration.setAttribute(IQvtLaunchConstants.CLEAR_CONTENTS, targetData.isClearContents()); 
    }
    
    public static String getTraceFileName(URI uri) {
        IFile file = org.eclipse.m2m.qvt.oml.emf.util.URIUtils.getFile(uri);
        if(file == null) {
            return null;
        }
        
        IPath traceFilePath = new Path(file.getParent().getFullPath() + "/" + file.getName() + ".oqvttrace");  //$NON-NLS-1$//$NON-NLS-2$
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
}

