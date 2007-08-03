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
package org.eclipse.m2m.qvt.oml.ui.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.m2m.qvt.oml.project.wizards.INewTransformationWizard;
import org.eclipse.m2m.qvt.oml.project.wizards.QVTProjectFieldData;
import org.eclipse.m2m.qvt.oml.ui.QVTUIPlugin;
import org.eclipse.m2m.qvt.oml.ui.QvtPluginImages;
import org.eclipse.ui.IWorkbench;


public class NewQvtLibraryWizard extends Wizard implements INewTransformationWizard {

	private boolean fContentsCreated;
	private QVTProjectFieldData fProjectFieldData;
    private NewQvtModuleCreationPage fNewQvtModuleCreationPage;
    private IProject fDestProject;    
    private IWorkbench fWorkbench;
    private IStructuredSelection fSelection;

    
    public NewQvtLibraryWizard() {
    	setWindowTitle(Messages.NewQVTLibraryWizard_Title);    	
        ImageDescriptor desc = QvtPluginImages.getInstance().getImageDescriptor(QvtPluginImages.NEW_WIZARD);
        setDefaultPageImageDescriptor(desc);        
    }
    
	public boolean isContentCreated() {
		return fContentsCreated;
	}

	public void setHostProject(IProject project) {
		fDestProject = project;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		fWorkbench = workbench;
		fSelection = selection;
	}
	
    protected IStructuredSelection getSelection() {
		return fSelection;
	}
    
    protected IWorkbench getWorkbench() {
		return fWorkbench;
	}	
    
    protected NewQvtModuleCreationPage createNewQvtLibraryCreationPage() {
    	return new NewQvtModuleCreationPage(fDestProject != null ? fDestProject.getFullPath() : null) {
            @Override
            protected String getNewModuleNameProposal() {    
            	return Messages.NewQvtLibraryWizard_newLibraryNameProposal;
            }
        };
    }
    
    protected IProject getDestinationProject() {
		return fDestProject;
	}    
    
    protected final NewQvtModuleCreationPage getNewQvtLibraryCreationPage() {    	
		return fNewQvtModuleCreationPage;
	}
    
	public void setProjectFieldData(QVTProjectFieldData projectData) {
		if(projectData == null) {
			return;
		}
		
		String projectName = projectData.getProjectName(); 
		if(projectName != null) {
			fDestProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);			
		}
	}
	
	public boolean performSoftFinish(IProgressMonitor monitor) {
        if (fDestProject != null && !fDestProject.exists()) {
        	// project not yet created from the parent wizard
            return true;
        }

        try {
            IFile transformationFile = fNewQvtModuleCreationPage.createNewFile(createModuleContents());            
            NewQvtModuleCreationPage.openInEditor(getShell(), transformationFile);
            return true;
        } 
        catch (Exception exception) {
            QVTUIPlugin.log(exception);
            return false;
        }
	}
	
    @Override
    public boolean canFinish() {
        IWizardPage[] pages = getPages();
        for (int i = 0; i < pages.length; i++) {
            if (!pages[i].isPageComplete()) {
                return false;
            }
        }
        return true;
    }

    @Override
	public boolean performFinish() {
		if (fProjectFieldData != null) {
			return true;
		}
		return performSoftFinish(null);
    }

    @Override
    public void addPages() {    
    	doAddPages();
    }
    
    protected String createModuleContents() {
        String moduleName = fNewQvtModuleCreationPage.getModuleName(); 
        String contents = "library " + moduleName + ";\n";  //$NON-NLS-1$//$NON-NLS-2$        

        return contents.toString();
    }
    
	protected void doAddPages() {
        fNewQvtModuleCreationPage = createNewQvtLibraryCreationPage();
        
        fNewQvtModuleCreationPage.setTitle(Messages.NewQvtLibraryWizard_NewModulePageTitle);
        fNewQvtModuleCreationPage.setDescription(Messages.NewQvtLibraryWizard_NewModulePageDescription);
        addPage(fNewQvtModuleCreationPage);
        
        fContentsCreated = true;
    }
}
