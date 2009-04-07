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
package org.eclipse.m2m.internal.qvt.oml.ui.wizards.project;


class MDAProjectFieldDataImpl extends org.eclipse.pde.internal.ui.wizards.plugin.PluginFieldData {
	private String myProjectName;
    private boolean myPlugin = true;


	public MDAProjectFieldDataImpl() {
		setDoGenerateClass(false);
		//setTargetVersion(TargetPlatformHelper.getTargetVersionString());
	}

	@Override
	public boolean isUIPlugin() {
		return false;
	}

	@Override
	public boolean isLegacy() {
		return false;
	}

	@Override
	public boolean hasBundleStructure() {
		return true;
	}
		
	public void setProjectName(String projectName) {
		myProjectName = projectName;
	}
	
	public String getProjectName() {
		return myProjectName;
	}
        
    public boolean isPlugin() {
        return myPlugin;
    }
    
    public void setPlugin(boolean plugin) {
        myPlugin = plugin;
    }    
}