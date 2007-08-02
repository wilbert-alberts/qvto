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
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.m2m.qvt.oml.QvtNamesChecker;
import org.eclipse.m2m.qvt.oml.project.AbstractNewTransformationWizard;
import org.eclipse.m2m.qvt.oml.project.wizards.MDAProjectFieldData;
import org.eclipse.m2m.qvt.oml.ui.QVTUIPlugin;
import org.eclipse.m2m.qvt.oml.ui.QvtPluginImages;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ISetSelectionTarget;


public class NewQVTTransformationWizard extends AbstractNewTransformationWizard {
	
	private NewQvtTransformationCreationPage myNewQvtModulePage;
    private IProject fDestProject;
        
    public NewQVTTransformationWizard() {
        ImageDescriptor desc = QvtPluginImages.getInstance().getImageDescriptor(QvtPluginImages.NEW_WIZARD);
        setDefaultPageImageDescriptor(desc);
        
        setHelpAvailable(false);
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
    	
    @Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
    	super.init(workbench, selection);
    	setWindowTitle(Messages.NewQVTTransformationWizard_Title);//$NON-NLS-1$
    }

	public void setProjectFieldData(MDAProjectFieldData projectData) {
		if(projectData == null) {
			return;
		}
		
		String projectName = projectData.getProjectName(); 
		if(projectName != null) {
			fDestProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);			
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
            
	public boolean performSoftFinish(IProgressMonitor monitor) {
        if (fDestProject != null && !fDestProject.exists()) {
            return true;
        }

        try {
        	String moduleName = myNewQvtModulePage.getModuleName(); 
        	assert QvtNamesChecker.validateQvtModuleIdentifier(moduleName).isOK();
        	
        	String contents = createTransformationContents(moduleName);
        	IFile transformationFile = myNewQvtModulePage.createNewFile(contents);            		
            
            openEditor(getWorkbench(), getShell(), transformationFile);
            return true;
        } catch (Exception exception) {
            QVTUIPlugin.log(exception);
            MessageDialog.openError(getWorkbench().getActiveWorkbenchWindow().getShell(), Messages.NewQVTTransformationWizard_WizardError, exception.getMessage());//$NON-NLS-1$
            return true;
        }
	}
	
    protected String createTransformationContents(String moduleName) {
    	StringBuffer contents = new StringBuffer();
    	contents.append("transformation ").append(moduleName).append("();"); //$NON-NLS-1$ //$NON-NLS-2$
    	contents.append("\n\n"); //$NON-NLS-1$
    	contents.append("mapping main() {\n\n}\n"); //$NON-NLS-1$    	    	

    	return contents.toString();
    }

        
    public static void openEditor(IWorkbench workbench, Shell shell, IFile file) {
        // Select the new file resource in the current view.
        //
        IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
        IWorkbenchPage page = workbenchWindow.getActivePage();
        final IWorkbenchPart activePart = page.getActivePart();
        if (activePart instanceof ISetSelectionTarget) {
            final ISelection targetSelection = new StructuredSelection(file);
            shell.getDisplay().asyncExec(new Runnable() {
                public void run() {
                    ((ISetSelectionTarget) activePart).selectReveal(targetSelection);
                }
            });
        }

        // Open an editor on the new file.
        //
        try {
            IDE.openEditor(page, file);
        } catch (PartInitException exception) {
            MessageDialog.openError(workbenchWindow.getShell(), Messages.NewQVTTransformationWizard_OpenEditorError, exception.getMessage());//$NON-NLS-1$
        }
    }
	
    @Override
	public boolean performFinish() {
		return performSoftFinish(new NullProgressMonitor());
    }

    @Override
	protected void doAddPages() {
        myNewQvtModulePage = createQvtTransformationCreationPage();        
        myNewQvtModulePage.setTitle(Messages.NewQVTTransformationWizard_NewModuleFilePageTitle);//$NON-NLS-1$
        myNewQvtModulePage.setDescription(Messages.NewQVTTransformationWizard_NewModulePageDescription);//$NON-NLS-1$
        addPage(myNewQvtModulePage);
    }
    
    public boolean isJavaRequired() {
        return false;
    }
}
