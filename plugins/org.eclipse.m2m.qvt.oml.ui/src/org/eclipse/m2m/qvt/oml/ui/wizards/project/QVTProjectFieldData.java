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
package org.eclipse.m2m.qvt.oml.ui.wizards.project;

import org.eclipse.pde.internal.core.TargetPlatformHelper;
import org.eclipse.pde.ui.IPluginFieldData;

public interface QVTProjectFieldData extends IPluginFieldData {
	interface Factory {
		Factory INSTANCE = new Factory() {
			public QVTProjectFieldData create() {
				return new MDAProjectFieldDataImpl();
			}
		};
		
		QVTProjectFieldData create();
	}
	
	boolean isPlugin();
	String getProjectName();
	
	void setProjectName(String projectName);	
	void setPlugin(boolean plugin);	
	void setVersion(String version);	
	void setSourceFolderName(String name);
	void setOutputFolderName(String name);
	void setName(String name);
	void setProvider(String provider);
	void setDoGenerateClass(boolean doGenerate);
	void setClassname(String classname);
	void setLibraryName(String name);
	void setId(String id);	
	void setSimple(boolean simple);
}


class MDAProjectFieldDataImpl extends org.eclipse.pde.internal.ui.wizards.plugin.PluginFieldData implements QVTProjectFieldData {
	private String myProjectName;
    private boolean myPlugin = true;


	public MDAProjectFieldDataImpl() {
		((QVTProjectFieldData)this).setDoGenerateClass(false);
		setTargetVersion(TargetPlatformHelper.getTargetVersionString());
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