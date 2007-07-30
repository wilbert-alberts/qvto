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
package org.eclipse.m2m.internal.qvt.oml.common.ui.wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TransformationControls;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class SelectFolderPage extends WizardPage {
   public SelectFolderPage(String pageName, IContainer initialContainer) {
       super(pageName);
       myInitialContainer = initialContainer;
       setPageComplete(false);
   }
   
   public IContainer getSelectedContainer() {
       return myContainer;
   }

   public void createControl(Composite parent) {
       Composite composite = new Composite(parent, SWT.NULL);
       composite.setFont(parent.getFont());

       initializeDialogUnits(parent);

       composite.setLayout(new GridLayout());
       composite.setLayoutData(new GridData(GridData.FILL_BOTH));

       createFolderLocationGroup(composite);

       setErrorMessage(null);
       setMessage(null);
       setControl(composite);
       
       setPageComplete(validatePage());
   }

   private final void createFolderLocationGroup(Composite parent) {
       Font font = parent.getFont();

       Composite locationGroup = new Composite(parent, SWT.NONE);
       GridLayout layout = new GridLayout();
       layout.numColumns = 3;
       locationGroup.setLayout(layout);
       locationGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
       locationGroup.setFont(font);

       Label locationLabel = new Label(locationGroup, SWT.NONE);
       locationLabel.setText(Messages.SelectFolderPage_LocationFolder);
       locationLabel.setEnabled(true);
       locationLabel.setFont(font);

       myContainerText = new Text(locationGroup, SWT.BORDER);
       GridData data = new GridData(GridData.FILL_HORIZONTAL);
       data.widthHint = 250;
       myContainerText.setLayoutData(data);
       myContainerText.setEnabled(true);
       myContainerText.setFont(font);

       Button browseButton = new Button(locationGroup, SWT.PUSH);
       browseButton.setText(Messages.SelectFolderPage_BrowseButtonLabel);
       browseButton.addSelectionListener(new SelectionAdapter() {
           @Override
		public void widgetSelected(SelectionEvent event) {
               handleLocationBrowseButtonPressed();
           }
       });

       browseButton.setEnabled(true);
       browseButton.setFont(font);
       setButtonLayoutData(browseButton);

       if(myInitialContainer != null) {
           myContainerText.setText(myInitialContainer.getFullPath().toString());
       } 
       
       myContainerText.addModifyListener(new ModifyListener() {
           public void modifyText(ModifyEvent e) {
               setPageComplete(validatePage());
               setModified(true);
           }
       });
   }

   void handleLocationBrowseButtonPressed() {
       IContainer cont = (IContainer)TransformationControls.browseWorkspace(
               ResourcesPlugin.getWorkspace().getRoot(),
               myContainer,
               new ViewerFilter(){
                   @Override
				public boolean select(Viewer viewer, Object parentElement, Object element) {
                       return element instanceof IContainer;
                   }
               },
               null, 
               getShell(),
               Messages.SelectFolderPage_BrowseFolder,
               MDAConstants.QVTO_TRANSFORMATION_CONTEXTID);
       
       if(cont != null){
           myContainer = cont;
           myContainerText.setText(cont.getFullPath().toString());
       }
   }

   protected boolean validatePage() {
       setMessage(null);
       setErrorMessage(null);
       
       if(myContainerText.getCharCount() == 0) { 
           setMessage(Messages.SelectFolderPage_MissingDestFolderMessage);
           return false;
       }

       IContainer cont = WorkspaceUtils.getWorkspaceContainer(myContainerText.getText());
       if(cont == null || !cont.exists()) {
           setErrorMessage(NLS.bind(Messages.SelectFolderPage_ContainerNotInWorkspaceMessage, myContainerText.getText()));
           return false;
       }
       
       myContainer = cont;
       
       return true;
   }

   @Override
public void setVisible(boolean visible) {
       super.setVisible(visible);
       if (visible) {
           myContainerText.setFocus();
       }
   }
   
   public String getFolderPath() {
       return myContainerText.getText();
   }
   
   public void setFolderPath(String path) {
       myContainerText.setText(path);
   }
   
   public boolean isModified() {
       return myModified;
   }

   public void setModified(boolean modified) {
       this.myModified = modified;
   }

   public void loadValues(String path) {
       setFolderPath(""); //$NON-NLS-1$
       if (path != null) {
           setFolderPath(path);
       }
       setModified(false);
   }
   
   private boolean myModified;
   private final IContainer myInitialContainer;
   
   private Text myContainerText;
   private IContainer myContainer;
}
