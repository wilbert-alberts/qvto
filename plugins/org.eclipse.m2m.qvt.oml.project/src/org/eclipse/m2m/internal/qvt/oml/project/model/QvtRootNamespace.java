package org.eclipse.m2m.internal.qvt.oml.project.model;


public class QvtRootNamespace extends QvtNamespace {

	private IQvtProject fProject;
	
	protected QvtRootNamespace(IQvtProject project, String name) throws QvtModelException {
		super(project.getQvtSourceContainerPath(), name);

		this.fProject = project;
	}

	@Override
	public IQvtProject getQvtProject() {
		return fProject;
	}
}
