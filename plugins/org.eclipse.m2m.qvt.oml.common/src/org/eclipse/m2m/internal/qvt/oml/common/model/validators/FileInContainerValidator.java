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
package org.eclipse.m2m.internal.qvt.oml.common.model.validators;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.internal.qvt.oml.common.model.ObjectFeature;
import org.eclipse.m2m.internal.qvt.oml.common.nature.TransformationNature;
import org.eclipse.osgi.util.NLS;


public class FileInContainerValidator extends Validator {

    private ObjectFeature<IPath> myContainerPath;
    private ObjectFeature<String> myFileName;
    private String myExtension;

    public FileInContainerValidator(ObjectFeature<IPath> containerPath, ObjectFeature<String> fileName, String extension) {
        super(containerPath, fileName);
        myContainerPath = containerPath;
        myFileName = fileName;
        myExtension = extension;
    } 
    
    public ObjectFeature<String> getFileName() {
        return myFileName;
    }
    
    public ObjectFeature<IPath> getContainerPath() {
        return myContainerPath;
    }
    
    public String getExtension() {
        return myExtension;
    }
    
    @Override
    protected boolean doValidate() {
        String fileName = new Path(myFileName.getValue()).lastSegment();
        
        String enteredExt = new Path(myFileName.getValue()).getFileExtension();
        if (enteredExt == null || !enteredExt.equals(myExtension)) {
            setErrorMessage(NLS.bind(Messages.FileInContainerValidator_WrongExtension, myExtension));
            return false;
        }
        
        String name = fileName.substring(0, fileName.length() - enteredExt.length() - 1);
        
        /* Check file name to be a valid identifier */
        if (name.length() <= 0) {
            setErrorMessage(NLS.bind(Messages.FileInContainerValidator_InvalidName, name));
            return false;
        }
        if (!(Character.isLetter(name.charAt(0)) || (name.charAt(0) == '_'))) {
            setErrorMessage(NLS.bind(Messages.FileInContainerValidator_InvalidName, name));
            return false;
        }
        for (int i = 1; i < name.length(); i++) {
            if (!(Character.isLetterOrDigit(name.charAt(i)) || (name.charAt(i) == '_'))) {
                setErrorMessage(NLS.bind(Messages.FileInContainerValidator_InvalidName, name));
                return false;
            }
        }
        
        try {
            if (myContainerPath.getValue() != null) {
                IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
                        myContainerPath.getValue().append(myFileName.getValue()));
                if(!file.getProject().hasNature(TransformationNature.ID)) {
                    setErrorMessage(Messages.FileInContainerValidator_NotATransformationProject);
                    return false;
                }
            }
        }
        catch(CoreException e) {
            setErrorMessage(e.getMessage());
            return false;
        }
        
        return true;
    }
    
}
