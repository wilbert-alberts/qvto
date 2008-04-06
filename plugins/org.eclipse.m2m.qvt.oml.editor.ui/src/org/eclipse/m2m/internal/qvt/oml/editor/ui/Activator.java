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
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import java.io.IOException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.ui.editors.text.templates.ContributionContextTypeRegistry;
import org.eclipse.ui.editors.text.templates.ContributionTemplateStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {
	public static final String CUSTOM_TEMPLATES_KEY = "QVTTemplates"; //$NON-NLS-1$
	
	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.m2m.qvt.oml.editor.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
    private TemplateStore myTemplateStore;
    private ContributionContextTypeRegistry myContextTypeRegistry;
        
	
	/**
	 * The constructor
	 */
	public Activator() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	public ContextTypeRegistry getContextTypeRegistry() {
		if (myContextTypeRegistry == null) {
			myContextTypeRegistry = new ContributionContextTypeRegistry();
			myContextTypeRegistry.addContextType(QvtTemplateContextType.ID);
		}
		return myContextTypeRegistry;
	}
	
	public TemplateStore getTemplateStore() {
		if (myTemplateStore == null) {
			myTemplateStore = new ContributionTemplateStore(getContextTypeRegistry(),
					getPreferenceStore(), CUSTOM_TEMPLATES_KEY);
			try {
				myTemplateStore.load();
			} catch (IOException e) {
				log(e);
				throw new RuntimeException(e);
			}
		}
		return myTemplateStore;
	}
	
	public static void log(IStatus status) {
        getDefault().getLog().log(status);
    }
    
    public static void log(Throwable e) {
        log(new Status(IStatus.ERROR, PLUGIN_ID, 0, "internal_error", e)); //$NON-NLS-1$
    }	
}
