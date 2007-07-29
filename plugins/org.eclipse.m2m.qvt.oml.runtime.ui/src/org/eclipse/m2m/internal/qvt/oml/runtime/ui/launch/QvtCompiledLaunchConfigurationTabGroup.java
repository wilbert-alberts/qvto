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

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.RefreshTab;
import org.eclipse.ui.externaltools.internal.launchConfigurations.ExternalToolsBuilderTab;

public class QvtCompiledLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {
    public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
        QvtCompiledLaunchTab qvtCompiledLaunchTab = new QvtCompiledLaunchTab();
        ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
                qvtCompiledLaunchTab,
                new QvtTransformationConfigurationTab(qvtCompiledLaunchTab.TRANSFORMATION_MAKER),
                new ExternalToolsBuilderTab(false),                
                new CommonTab(),
                new RefreshTab(),
            };
        setTabs(tabs);
    }

}
