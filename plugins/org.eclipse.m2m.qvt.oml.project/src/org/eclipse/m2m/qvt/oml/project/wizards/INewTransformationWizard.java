package org.eclipse.m2m.qvt.oml.project.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbenchWizard;

public interface INewTransformationWizard extends INewWizard {
	void setHostProject(IProject project);
	boolean isContentCreated();
	boolean performSoftFinish(IProgressMonitor monitor);
}
