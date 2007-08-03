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

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;


public class NewQVTProjectCreationPage extends WizardNewProjectCreationPage {

    private QVTProjectFieldData myCreationData;
    private Text mySourceText;
    private Text myOutputText;
    private Button mySimpleProject;
    private Button mySimplePlugin;
    private Button myJavaPlugin = null;    
    private Group myJavaProjectSettings;
    private Label mySourceLabel;
    private Label myOutputLabel;	
	
	public NewQVTProjectCreationPage(String pageName, QVTProjectFieldData data){
		super(pageName);
		myCreationData = data;
	}
	
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		Composite control = (Composite)getControl();
		GridLayout layout = new GridLayout();
		layout.verticalSpacing = 10;
		control.setLayout(layout);

		createProjectTypeGroup(control);
		mySimpleProject.setSelection(true);
		myCreationData.setSimple(true);

		//new SourceContainer
		
		Dialog.applyDialogFont(control);
		setControl(control);
        PlatformUI.getWorkbench().getHelpSystem().setHelp(control, 
			"org.eclipse.m2m.qvt.oml.transformation_project"); //$NON-NLS-1$
	}	
	
	private void createProjectTypeGroup(Composite container) {
		Group projectTypeGroup = new Group(container, SWT.RADIO);
		projectTypeGroup.setText(Messages.ProjectStructurePage_createProjectType);
		GridLayout layout2 = new GridLayout();
		layout2.numColumns = 1;
		projectTypeGroup.setLayout(layout2);
		projectTypeGroup.setLayoutData(new GridData(GridData.FILL_VERTICAL));

		mySimpleProject = new Button(projectTypeGroup, SWT.RADIO);
		mySimpleProject.setText(Messages.ProjectStructurePage_createSimpleProject);
		
		mySimplePlugin = new Button(projectTypeGroup, SWT.RADIO);
		mySimplePlugin.setText(Messages.ProjectStructurePage_createSimplePluginProject);
		
		myJavaPlugin = new Button(projectTypeGroup, SWT.RADIO);		
        myJavaPlugin.setText(Messages.ProjectStructurePage_createJavaPluginProject);
        myJavaPlugin.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                toggleCreatePlugin();
            }
        });
        
        myJavaProjectSettings = new Group(projectTypeGroup, SWT.NONE);
        myJavaProjectSettings.setText(Messages.ProjectStructurePage_settings); 
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		myJavaProjectSettings.setLayout(layout);
		myJavaProjectSettings.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        mySourceLabel = createLabel(myJavaProjectSettings, Messages.ProjectStructurePage_source);
        mySourceText = createText(myJavaProjectSettings);
		mySourceText.setText("src_generated"); //$NON-NLS-1$
		
		myOutputLabel = createLabel(myJavaProjectSettings, Messages.ProjectStructurePage_output);
        myOutputText = createText(myJavaProjectSettings);		
		myOutputText.setText("bin"); //$NON-NLS-1$
        toggleCreatePlugin();        
	}
	
    private void toggleCreatePlugin() {
        myCreationData.setPlugin(myJavaPlugin.getSelection());
        myCreationData.setSimple(!myJavaPlugin.getSelection());
        
        myJavaProjectSettings.setEnabled(myJavaPlugin.getSelection());
        mySourceLabel.setEnabled(myJavaPlugin.getSelection());
        mySourceText.setEnabled(myJavaPlugin.getSelection());
        myOutputLabel.setEnabled(myJavaPlugin.getSelection());
        myOutputText.setEnabled(myJavaPlugin.getSelection());        
    }

    private Label createLabel(Composite container, String text) {
		Label label = new Label(container, SWT.NONE);
		label.setText(text);
		GridData gd = new GridData();
		label.setLayoutData(gd);
		return label;
	}
	
	private Text createText(Composite container) {
		Text text = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.widthHint = 300;
		text.setLayoutData(gd);
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				validatePage();
			}
		});
		return text;
	}

	@Override
	public IWizardPage getNextPage() {
		updateData();
		return super.getNextPage();
	}
	
	public void updateData() {
		myCreationData.setPlugin(!mySimpleProject.getSelection());		
		myCreationData.setProjectName(getProjectName());
		if(myJavaPlugin.getSelection()) {
			myCreationData.setSourceFolderName(mySourceText.getText().trim());
			myCreationData.setOutputFolderName(myOutputText.getText().trim());
		} else {
			myCreationData.setSourceFolderName(null);
			myCreationData.setOutputFolderName(null);			
		}
	}
    
	/**
	 * Indicates whether the project to be created is a plugin project.
	 */
    public boolean getCreatePlugin() {
        return !mySimpleProject.getSelection();
    }
}
