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
package org.eclipse.m2m.qvt.oml.project.wizards;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardSelectionPage;
import org.eclipse.m2m.internal.qvt.oml.common.nature.TransformationNature;
import org.eclipse.m2m.qvt.oml.common.project.NatureUtils;
import org.eclipse.m2m.qvt.oml.project.INewTransformationWizard;
import org.eclipse.m2m.qvt.oml.project.MDAProjectPlugin;
import org.eclipse.m2m.qvt.oml.project.MDAProjectPluginImages;
import org.eclipse.pde.internal.ui.wizards.IProjectProvider;
import org.eclipse.pde.internal.ui.wizards.plugin.NewProjectCreationOperation;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;


public class NewMDAProjectWizard extends Wizard implements INewWizard, IExecutableExtension {
	
	private MDAProjectFieldData myMDAProjectFieldData;
	private NewMDAProjectCreationPage myMainPage;
	private NewMDAProjectContentPage myContentPage;
	private IConfigurationElement myConfig;
	private WizardSelectionPage myWizardSelectionPage;
	private IProjectProvider myProjectProvider;	
	protected IWorkbench myWorkbench;	

	public NewMDAProjectWizard() {
	    setDefaultPageImageDescriptor(MDAProjectPluginImages.getInstance().getImageDescriptor(MDAProjectPluginImages.NEW_WIZARD));
		setWindowTitle(MDAProjectPlugin.getResourceString("NewTransformationProjectWizard.Title")); //$NON-NLS-1$
	    setNeedsProgressMonitor(true);
		myMDAProjectFieldData = MDAProjectFieldData.Factory.INSTANCE.create();
	}
	
    public void init(IWorkbench workbench, IStructuredSelection selection) {
		myWorkbench = workbench;
    }
	
    @Override
	public void addPages() {
        
        super.addPages();
        
		myMainPage = new NewMDAProjectCreationPage("main", myMDAProjectFieldData); //$NON-NLS-1$
		myMainPage.setTitle(MDAProjectPlugin.getResourceString("NewTransformationProject.Title"));//$NON-NLS-1$
		myMainPage.setDescription(MDAProjectPlugin.getResourceString("NewTransformationProject.Description"));//$NON-NLS-1$
		addPage(myMainPage);

		myProjectProvider = new IProjectProvider() {
			public String getProjectName() {
				return myMainPage.getProjectName();
			}
			public IProject getProject() {
				return myMainPage.getProjectHandle();
			}
			public IPath getLocationPath() {
				return myMainPage.getLocationPath();
			}
		};
		
		myContentPage = new NewMDAProjectContentPage("page2", myMainPage, myMDAProjectFieldData); //$NON-NLS-1$
		myWizardSelectionPage = new MDAWizardListSelectionPage(myMDAProjectFieldData);
		addPage(myContentPage);
		addPage(myWizardSelectionPage);
	}
	
    @Override
    public IWizardPage getNextPage(IWizardPage page) {
        IWizardPage nextPage = super.getNextPage(page);
        if (nextPage == myContentPage) {
            if (!myMainPage.getCreatePlugin()) {
                nextPage = myWizardSelectionPage;
            }
        }
        return nextPage;
    }
    
    @Override
    public IWizardPage getPreviousPage(IWizardPage page) {
        IWizardPage prevPage = super.getPreviousPage(page);
        if (prevPage == myContentPage) {
            if (!myMainPage.getCreatePlugin()) {
                prevPage = myMainPage;
            }
        }
        return prevPage;
    }
    
	@Override
	public boolean canFinish() {
		IWizardPage page = getContainer().getCurrentPage();
		return super.canFinish() && page != myMainPage;
	}

	public void setInitializationData(IConfigurationElement config, 
			String propertyName, Object data) {
		myConfig = config;
	}
	
    /*
     * Copied from BasicNewProjectResourceWizard (modified)
     */
    private WorkspaceModifyOperation createNewSimpleProjectOperation() {
        final IProject newProjectHandle = myMainPage.getProjectHandle();
        URI location = null;
        if (!myMainPage.useDefaults()) {
            location = myMainPage.getLocationURI();
        }

        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        final IProjectDescription description = workspace
                .newProjectDescription(newProjectHandle.getName());
        description.setLocationURI(location);

        WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
            @Override
			protected void execute(IProgressMonitor monitor)
                    throws CoreException {
                createProject(description, newProjectHandle, monitor);
                doPostCreateAction(monitor);
            }
        };
        return op;
    }

    /*
     * Copied from BasicNewProjectResourceWizard (not modified)
     */
    void createProject(IProjectDescription description, IProject projectHandle,
            IProgressMonitor monitor) throws CoreException,
            OperationCanceledException {
        try {
            monitor.beginTask("", 2000);//$NON-NLS-1$

            projectHandle.create(description, new SubProgressMonitor(monitor,
                    1000));

            if (monitor.isCanceled()) {
                throw new OperationCanceledException();
            }

            projectHandle.open(IResource.BACKGROUND_REFRESH, new SubProgressMonitor(monitor, 1000));

        } finally {
            monitor.done();
        }
    }

	@Override
	public boolean performFinish() {

		try {
			myMainPage.updateData();
			myContentPage.updateData();
			BasicNewProjectResourceWizard.updatePerspective(myConfig);
            final WorkspaceModifyOperation operation;
            if (myMainPage.getCreatePlugin()) {
                operation = new NewProjectCreationOperation(myMDAProjectFieldData, myProjectProvider, null) {
                    @Override
                    protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
                        super.execute(monitor);
                        doPostCreateAction(monitor);
                    }
                };
            } else {
                operation = createNewSimpleProjectOperation();
            }
			getContainer().run(false, true, operation);
		} 
        catch (InterruptedException e) {
            MDAProjectPlugin.log(e);
        }
        catch(Exception e) {
            MDAProjectPlugin.log(e);
            String title = MDAProjectPlugin.getResourceString("NewMDAProjectWizard.Error"); //$NON-NLS-1$
            String message = MDAProjectPlugin.getResourceString("NewMDAProjectWizard.ErrorSeeLog"); //$NON-NLS-1$
            Status status = new Status(IStatus.ERROR, MDAProjectPlugin.ID, IStatus.ERROR, message, e);
            ErrorDialog.openError(getShell(), title, e.getMessage(), status);
        }
		
        return true;
	}

    private void doPostCreateAction(IProgressMonitor monitor) throws CoreException {
        NatureUtils.addNature(myProjectProvider.getProject(), TransformationNature.ID);
        monitor.worked(1);
        if (myWizardSelectionPage.getSelectedNode() != null) {
            INewTransformationWizard wizard = (INewTransformationWizard)myWizardSelectionPage.getSelectedNode().getWizard();
            if (wizard != null) {
                wizard.performSoftFinish(monitor);
            }
        }
    }
}
