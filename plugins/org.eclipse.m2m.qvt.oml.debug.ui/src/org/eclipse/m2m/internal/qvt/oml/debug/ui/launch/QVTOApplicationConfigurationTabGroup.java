/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.debug.ui.launch;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.EnvironmentTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaArgumentsTab;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.ITransformationMaker;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtModule;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.launch.QvtLauncherTab;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.launch.QvtTransformationConfigurationTab;
import org.eclipse.pde.ui.launcher.ConfigurationTab;
import org.eclipse.pde.ui.launcher.PluginsTab;
import org.eclipse.pde.ui.launcher.TracingTab;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;


public class QVTOApplicationConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {
	
	public QVTOApplicationConfigurationTabGroup() {
    	super();
	}

	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		// FIXME - eliminate this crazy thing 
        ITransformationMaker transformation = new ITransformationMaker() {
			public QvtTransformation makeTransformation(String name) throws MdaException {
				QvtModule qvtModule = TransformationUtil.getQvtModule(EmfUtil.makeUri(name));
		        return new QvtInterpretedTransformation(qvtModule);
			}
		};
		
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
                new QvtLauncherTab(transformation, new ResourceSetImpl()),
                new QvtTransformationConfigurationTab(transformation),
                new QVTOMainTab(),
                new JavaArgumentsTab(), 
                new PluginsTab(), 
                new ConfigurationTab(), 
                new TracingTab(), 
                new EnvironmentTab(), 
                new CommonTab()
        };
        
		setTabs(tabs);
	}
	
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		final ILaunchConfiguration config = configuration;
		final ILaunchConfigurationTab[] tabs = getTabs();
		BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
			public void run() {
				for (int i = 0; i < tabs.length; i++) {
					tabs[i].initializeFrom(config);
				}
			}
		});
	}
}
