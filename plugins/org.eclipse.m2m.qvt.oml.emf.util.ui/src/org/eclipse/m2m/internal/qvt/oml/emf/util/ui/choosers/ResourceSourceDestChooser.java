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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;

public class ResourceSourceDestChooser extends ResourceSourceChooser implements IDestinationChooser {
    public ResourceSourceDestChooser(ResourceSet rs) {
    	super(false, rs);
    }
    
    protected String getDefaultFileName() {
		return myFileName;
	}
    
    public void setInitialSelection(String uriString) {
    	myFileName = myDefaultFileName;
    	
    	URI uri = URI.createURI(uriString);
        if(uri == null) {
            return;
        }

        IFile file = WorkspaceUtils.getWorkspaceFile(uri);
        if(file == null) {
            return;
        }

        if (file.exists()) {
        	myInitialSelection = createSelectionForUri(uri, file);
        }
        else {
            myInitialSelection = new StructuredSelection(file.getParent());
            myFileName = file.getName();
        }
    }

	public void initNewName(String baseName, String extension) {
        myDefaultFileName = baseName;
        if(extension.length() > 0) {
            myDefaultFileName += "." + extension; //$NON-NLS-1$
        }
	}
    
    private String myFileName;
    private String myDefaultFileName;
}
