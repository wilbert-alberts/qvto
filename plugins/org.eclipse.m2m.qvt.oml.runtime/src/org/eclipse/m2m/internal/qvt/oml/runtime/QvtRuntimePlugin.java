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
package org.eclipse.m2m.internal.qvt.oml.runtime;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.DeleteBuilderMarkersListener;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class QvtRuntimePlugin extends Plugin {
	//The shared instance.
	private static QvtRuntimePlugin plugin;
	
	/**
	 * The constructor.
	 */
	public QvtRuntimePlugin() {
		super();
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);

        ResourcesPlugin.getWorkspace().addResourceChangeListener(new DeleteBuilderMarkersListener(), IResourceChangeEvent.PRE_BUILD);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static QvtRuntimePlugin getDefault() {
		return plugin;
	}
        
    public static final String ID = "org.eclipse.m2m.qvt.oml.runtime"; //$NON-NLS-1$
    
}
