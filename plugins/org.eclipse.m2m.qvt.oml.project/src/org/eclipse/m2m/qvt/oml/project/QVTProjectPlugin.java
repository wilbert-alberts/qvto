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
package org.eclipse.m2m.qvt.oml.project;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class QVTProjectPlugin extends AbstractUIPlugin {
	//The shared instance.
	private static QVTProjectPlugin plugin;
	//Resource bundle.
	private ResourceBundle resourceBundle;
	/**
	 * The constructor.
	 */
	public QVTProjectPlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("org.eclipse.m2m.qvt.oml.project.project");//$NON-NLS-1$
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
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
	public static QVTProjectPlugin getDefault() {
		return plugin;
	}

	public static String getResourceString(String key,Object[] parameters) {
	    return MessageFormat.format(getResourceString(key),parameters);
	}
	
	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = QVTProjectPlugin.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	 * Returns the plugin's resource bundle,
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	
	public static void log(IStatus status) {
        getDefault().getLog().log(status);
    }
	
	public static void log(Throwable t){
	    log(new Status(IStatus.ERROR, ID, 100001, getResourceString("QVTProjectPlugin.StatusMessage"), t));//$NON-NLS-1$ 
	}

    public static final String ID = "org.eclipse.m2m.qvt.oml.project"; //$NON-NLS-1$
}
