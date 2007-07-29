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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.internal.qvt.oml.common.model.ObjectFeature;
import org.eclipse.m2m.internal.qvt.oml.common.model.ValidatableFeature;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;


public class NewFileCreationPage extends WizardNewFileCreationPage implements ValidatableFeature.ChangeListener {
    
    public NewFileCreationPage(ObjectFeature<String> fileName, ObjectFeature<IPath> containerPath, String pageId, IStructuredSelection selection) {
        super(pageId, selection);
        myFileName = fileName;
        myFileName.addChangeListener(this);
        myContainerFullPath = containerPath;
        containerPath.addChangeListener(this);
        changePerformed(myFileName);
    }

    @Override
	protected boolean validatePage() {
        boolean result = super.validatePage();

        myContainerFullPath.silentSetValue(getContainerFullPath());
        
        inValidate = true;
        myFileName.setValue(getFileName());
        inValidate = false;
        
        if (!result) {
            return false;
        }
        
        result = myFileName.validate();
        setErrorMessage(myFileName.getErrorMessage());
        return result;
    }

    public void changePerformed(ValidatableFeature feature) {
        if (inValidate) {
            return;
        }
        if (feature == myFileName) {
            if (myFileName.getValue() != null) {
                if (!myFileName.getValue().equals(getFileName())) {
                    setFileName(myFileName.getValue());
                }
            }
        }
    }
    
    protected ValidatableFeature getFileNameFeature() {
        return myFileName;
    }
    
    protected ValidatableFeature getContainerFullPathFeature() {
        return myContainerFullPath;
    }
    
    private final ObjectFeature<String> myFileName;
    private final ObjectFeature<IPath> myContainerFullPath; 
    protected IFile modelFile;
    private boolean inValidate;
}
