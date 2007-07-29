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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.FileTransformationMaker;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.ITransformationMaker;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;


/** @author pkobiakov */
public class QvtLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
        ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
                new QvtLauncherTab(TRANSFORMATION_MAKER),
                new QvtTransformationConfigurationTab(TRANSFORMATION_MAKER),
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
				try {
					String id = config.getAttribute(IJavaLaunchConfigurationConstants.ATTR_SOURCE_PATH_PROVIDER, (String) null);
					if (id == null && config instanceof ILaunchConfigurationWorkingCopy) {
						ILaunchConfigurationWorkingCopy wc = (ILaunchConfigurationWorkingCopy) config;
						wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_SOURCE_PATH_PROVIDER,
							"org.eclipse.m2m.qvt.oml.launch.QvtSourcePathProvider"); //$NON-NLS-1$
					}
				} catch (CoreException e) {
				}
				for (int i = 0; i < tabs.length; i++) {
					tabs[i].initializeFrom(config);
				}
			}
		});
	}
	
    private final ITransformationMaker TRANSFORMATION_MAKER = new FileTransformationMaker() {
        @Override
        protected QvtTransformation doCreateTransformation(IFile qvtFile) {
            return new QvtInterpretedTransformation(qvtFile);
        }
    };
}
