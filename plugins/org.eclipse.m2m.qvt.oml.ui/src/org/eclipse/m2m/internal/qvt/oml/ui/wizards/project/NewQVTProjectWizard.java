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

import java.lang.reflect.InvocationTargetException;
import java.net.URI;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
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
import org.eclipse.m2m.internal.qvt.oml.builder.QvtBuilderConfig;
import org.eclipse.m2m.internal.qvt.oml.common.nature.TransformationNature;
import org.eclipse.m2m.internal.qvt.oml.common.project.NatureUtils;
import org.eclipse.m2m.internal.qvt.oml.ui.QVTUIPlugin;
import org.eclipse.m2m.internal.qvt.oml.ui.QvtPluginImages;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;



public class NewQVTProjectWizard extends Wizard implements INewWizard, IExecutableExtension {
		
	private QVTProjectFieldData fMDAProjectFieldData;
	private NewQVTProjectCreationPage fMainPage;
	private NewQVTProjectContentPage fContentPage;
	private IConfigurationElement fConfig;
	private WizardSelectionPage fWizardSelectionPage;
	private boolean fIsFinishPerformed;
	protected IWorkbench fWorkbench;

	
	public NewQVTProjectWizard() {
	    setDefaultPageImageDescriptor(QvtPluginImages.getInstance().getImageDescriptor(QvtPluginImages.NEW_PROJECT_WIZARD));
		setWindowTitle(Messages.NewTransformationProjectWizard_Title);
	    setNeedsProgressMonitor(true);
		
	    fMDAProjectFieldData = QVTProjectFieldData.Factory.INSTANCE.create();
		fIsFinishPerformed = false;
	}
	
    public void init(IWorkbench workbench, IStructuredSelection selection) {
		fWorkbench = workbench;
    }
	
    @Override
	public void addPages() {
        
        super.addPages();
        
		fMainPage = new NewQVTProjectCreationPage("main", fMDAProjectFieldData); //$NON-NLS-1$
		fMainPage.setTitle(Messages.NewTransformationProject_Title);
		fMainPage.setDescription(Messages.NewTransformationProject_Description);
		addPage(fMainPage);

		fContentPage = new NewQVTProjectContentPage("page2", fMainPage, fMDAProjectFieldData); //$NON-NLS-1$
		fWizardSelectionPage = new QVTWizardListSelectionPage(getDestinationProvider());
		addPage(fContentPage);
		addPage(fWizardSelectionPage);
	}
	
    @Override
    public IWizardPage getNextPage(IWizardPage page) {
        IWizardPage nextPage = super.getNextPage(page);
        if (nextPage == fContentPage) {
            if (!fMainPage.isCreatePlugin()) {
                nextPage = fWizardSelectionPage;
            }
        }
        return nextPage;
    }
    
    @Override
    public IWizardPage getPreviousPage(IWizardPage page) {
        IWizardPage prevPage = super.getPreviousPage(page);
        if (prevPage == fContentPage) {
            if (!fMainPage.isCreatePlugin()) {
                prevPage = fMainPage;
            }
        }
        return prevPage;
    }
    
	@Override
	public boolean canFinish() {
		IWizardPage page = getContainer().getCurrentPage();
		return super.canFinish() && page != fMainPage ;
	}

	public void setInitializationData(IConfigurationElement config, 
			String propertyName, Object data) {
		fConfig = config;
	}
	
    /*
     * Copied from BasicNewProjectResourceWizard (modified)
     */
    private WorkspaceModifyOperation createNewSimpleProjectOperation() {
        final IProject newProjectHandle = fMainPage.getProjectHandle();
        URI location = null;
        if (!fMainPage.useDefaults()) {
            location = fMainPage.getLocationURI();
        }

        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        final IProjectDescription description = workspace.newProjectDescription(newProjectHandle.getName());
        description.setLocationURI(location);

        WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
            @Override
			protected void execute(IProgressMonitor monitor) throws CoreException {
                createProject(description, newProjectHandle, monitor);
                doPostCreateProjectAction(newProjectHandle, monitor);
            }
        };
        return op;
    }
    
	private WorkspaceModifyOperation createNewPluginProjectOperation() {
		final org.eclipse.pde.internal.ui.wizards.IProjectProvider projectProvider = new org.eclipse.pde.internal.ui.wizards.IProjectProvider() {
			public String getProjectName() {
				return fMainPage.getProjectName();
			}
			public IProject getProject() {
				return fMainPage.getProjectHandle();
			}
			public IPath getLocationPath() {
				return fMainPage.getLocationPath();
			}
		};
		
		return new org.eclipse.pde.internal.ui.wizards.plugin.NewProjectCreationOperation(fMDAProjectFieldData, projectProvider, null) {
		    @Override
		    protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
		        super.execute(monitor);
		        doPostCreateProjectAction(projectProvider.getProject(), monitor);
		    }
		};
	}    

    /*
     * Copied from BasicNewProjectResourceWizard (not modified)
     */
    void createProject(IProjectDescription description, IProject projectHandle,
            IProgressMonitor monitor) throws CoreException, OperationCanceledException {
        
    	try {
            monitor.beginTask("", 2000);//$NON-NLS-1$

            projectHandle.create(description, new SubProgressMonitor(monitor, 1000));

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
		if(fIsFinishPerformed) {
			return true;
		}
		
		try {
			fMainPage.updateData();
			fContentPage.updateData();			
			
			if(fConfig != null) {
				BasicNewProjectResourceWizard.updatePerspective(fConfig);
			}
			
			if(fMDAProjectFieldData.isSimple()) {
				// ensure no Activator class is requested to generate, in case 				
				// it has been previously selected in the new content page
				fMDAProjectFieldData.setDoGenerateClass(false);
			}
			
            final WorkspaceModifyOperation operation;
            if (fMainPage.isCreatePlugin()) {
                operation = createNewPluginProjectOperation();
            } else {
                operation = createNewSimpleProjectOperation();
            }
            
			getContainer().run(false, true, operation);
		} 
        catch (InterruptedException e) {
        	// operation canceled
        }
        catch(Exception e) {
        	QVTUIPlugin.log(e);
            String title = Messages.NewQVTProjectWizard_Error;
            String message = Messages.NewQVTProjectWizard_ErrorSeeLog;
            Throwable exc = (e instanceof InvocationTargetException) ? ((InvocationTargetException)e).getTargetException() : e;
            Status status = new Status(IStatus.ERROR, QVTUIPlugin.PLUGIN_ID, IStatus.ERROR, message, exc);
            ErrorDialog.openError(getShell(), title, e.getMessage(), status);
            return false;
        }
		
        fIsFinishPerformed = true;
        return true;
	}


    private void doPostCreateProjectAction(IProject createdProject, IProgressMonitor monitor) throws CoreException {
		// Create QVT source container
    	IContainer srcContainer = fMainPage.getQVTSourceContainerHandle();
    	if(srcContainer instanceof IFolder) {
        	SourceContainerUpdater.ensureDestinationExists((IFolder)srcContainer, monitor);    		
    	}
    	
    	QvtBuilderConfig qvtConfig = QvtBuilderConfig.getConfig(createdProject);
    	qvtConfig.setSourceContainer(srcContainer);
    	qvtConfig.addTransformationNature();

        monitor.worked(1);
    }
    
    private INewQVTElementDestinationWizardDelegate getDestinationProvider() {
    	assert fMainPage != null;
    	
    	return new INewQVTElementDestinationWizardDelegate() {
			public IProject getProjectHandle() {
				return fMainPage.getProjectHandle();
			}					
			
			public IContainer getSourceContainer() {
				return fMainPage.getQVTSourceContainerHandle();
			}
			
			public boolean createDestination() {
				return performFinish();
			}
		};
    }
}
