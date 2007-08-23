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
package org.eclipse.m2m.qvt.oml.emf.util.ui.choosers;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.StructuredSelection;

public class ResourceSourceDestChooser extends ResourceSourceChooser implements IDestinationChooser {
    public ResourceSourceDestChooser() {
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

        IFile file = org.eclipse.m2m.qvt.oml.emf.util.URIUtils.getFile(uri);
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

	@Override
	public void initNewName(String baseName, String extension) {
        myDefaultFileName = baseName;
        if(extension.length() > 0) {
            myDefaultFileName += "." + extension; //$NON-NLS-1$
        }
	}
    
    private String myFileName;
    private String myDefaultFileName;
}
