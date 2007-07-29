package org.eclipse.m2m.qvt.oml.ui.wizards;

import org.eclipse.core.runtime.IPath;
import org.eclipse.m2m.internal.qvt.oml.common.model.ObjectFeature;
import org.eclipse.pde.ui.IPluginFieldData;

interface INewQVTModuleData {

	public boolean isPluginProject();

	public ObjectFeature<String> getModuleName();

	public ObjectFeature<String> getId();

	public ObjectFeature<IPath> getContainerPath();

	public IPluginFieldData getProjectFieldData();

}