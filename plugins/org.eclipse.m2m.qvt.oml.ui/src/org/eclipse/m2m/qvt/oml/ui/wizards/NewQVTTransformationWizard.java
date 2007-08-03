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
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.m2m.qvt.oml.QvtNamesChecker;
import org.eclipse.m2m.qvt.oml.project.wizards.INewTransformationWizard;
import org.eclipse.m2m.qvt.oml.ui.QVTUIPlugin;
import org.eclipse.m2m.qvt.oml.ui.QvtPluginImages;
import org.eclipse.ui.IWorkbench;


public class NewQVTTransformationWizard extends Wizard implements INewTransformationWizard {
 
	private NewQvtTransformationCreationPage myNewQvtModulePage;
    private IProject fDestProject;
    private boolean fContentsCreated;
    private IWorkbench fWorkbench;
    private IStructuredSelection fSelection;
        
    public NewQVTTransformationWizard() {
    	setWindowTitle(Messages.NewQVTTransformationWizard_Title);//$NON-NLS-1$
    	
        ImageDescriptor desc = QvtPluginImages.getInstance().getImageDescriptor(QvtPluginImages.NEW_WIZARD);
        setDefaultPageImageDescriptor(desc);        
        setHelpAvailable(false);
    }
    
    protected IStructuredSelection getSelection() {
		return fSelection;
	}
    
    protected IWorkbench getWorkbench() {
		return fWorkbench;
	}

    protected NewQvtTransformationCreationPage createQvtTransformationCreationPage() {
    	return new NewQvtTransformationCreationPage(fDestProject != null ? fDestProject.getFullPath() : null);
    }
    
    protected final NewQvtTransformationCreationPage getQvtTransformationCreationPage() {
    	return myNewQvtModulePage;
    }
    
    protected IProject getDestinationProject() {
		return fDestProject;
	}
    
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		fWorkbench = workbench;
		fSelection = selection;
	}    

	public void setHostProject(IProject project) {		
		fDestProject = project;			
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
            
	public boolean performSoftFinish(IProgressMonitor monitor) {
        if (fDestProject != null && !fDestProject.exists()) {
            return true;
        }

        try {
        	String moduleName = myNewQvtModulePage.getModuleName(); 
        	assert QvtNamesChecker.validateQvtModuleIdentifier(moduleName).isOK();
        	
        	String contents = createTransformationContents(moduleName);
        	IFile transformationFile = myNewQvtModulePage.createNewFile(contents);            		
            
        	NewQvtModuleCreationPage.openInEditor(getShell(), transformationFile);
            return true;
        } catch (Exception exception) {
            QVTUIPlugin.log(exception);
            return false;
        }
	}
	
    protected String createTransformationContents(String moduleName) {
    	StringBuffer contents = new StringBuffer();
    	contents.append("transformation ").append(moduleName).append("();"); //$NON-NLS-1$ //$NON-NLS-2$
    	contents.append("\n\n"); //$NON-NLS-1$
    	contents.append("mapping main() {\n\n}\n"); //$NON-NLS-1$    	    	

    	return contents.toString();
    }


	@Override
	public boolean performFinish() {
		return performSoftFinish(new NullProgressMonitor());
    }
	
	@Override
	public void addPages() {
		doAddPages();
	}

	protected void doAddPages() {
        myNewQvtModulePage = createQvtTransformationCreationPage();        
        myNewQvtModulePage.setTitle(Messages.NewQVTTransformationWizard_NewModuleFilePageTitle);//$NON-NLS-1$
        myNewQvtModulePage.setDescription(Messages.NewQVTTransformationWizard_NewModulePageDescription);//$NON-NLS-1$
        addPage(myNewQvtModulePage);

        fContentsCreated = true;        
    }
    
	
	public boolean isContentCreated() {
		return fContentsCreated;
	}
}
