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
package org.eclipse.m2m.internal.qvt.oml;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;


/**
 * The main plugin class to be used in the desktop.
 */
public class QvtPlugin extends Plugin {
	
	public static final String ID = "org.eclipse.m2m.qvt.oml"; //$NON-NLS-1$
    
	//The shared instance.
	private static QvtPlugin plugin;
    
	/**
	 * The constructor.
	 */
	public QvtPlugin() {
		super();
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 */
	public static QvtPlugin getDefault() {
		return plugin;
	}

	public static void log(IStatus status) {
        getDefault().getLog().log(status);
    }
    
    public static void log(Throwable e) {
        log(new Status(IStatus.ERROR, ID, 100001, "internal_error", e)); //$NON-NLS-1$
    }
    
	public static IStatus createErrorStatus(String message, Exception e) {
		return new Status(IStatus.ERROR, QvtPlugin.ID, IStatus.ERROR, message, e);
	}
	
	public static IStatus createErrorStatus(Exception e) {
		return new Status(IStatus.ERROR, QvtPlugin.ID, IStatus.ERROR, "internal error", e); //$NON-NLS-1$
	}    
	
}
