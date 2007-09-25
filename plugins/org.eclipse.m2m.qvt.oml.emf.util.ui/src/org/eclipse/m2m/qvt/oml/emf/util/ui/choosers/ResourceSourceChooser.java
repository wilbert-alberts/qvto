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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.m2m.qvt.oml.emf.util.ui.controls.SelectUriControl;
import org.eclipse.m2m.qvt.oml.emf.util.ui.provider.EmfModelContentProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;

import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;

public class ResourceSourceChooser extends ChooserAdapter implements ISourceChooser {
    public ResourceSourceChooser(boolean isConsiderAdapters) {
    	myIsConsiderAdaptes = isConsiderAdapters;
    }
    
    public Control createControl(Composite parent) {
        myControl = new SelectUriControl(parent, getDefaultFileName(), myIsConsiderAdaptes);
        myControl.addSelectionListener(new SelectUriControl.ISelectionListener() {
            public void selectionChanged(URI uri) {
                if(uri == null) {
                    myObject = null;
                    myUri = null;
                }
                else {
                    myUri = uri;
                    myObject = EmfUtil.safeLoadModel(myUri);
                }
                
                fireChangedEvent();
            }
        });
        
        if(myInitialSelection != null) {
            myControl.setSelection(myInitialSelection);
        }
        PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, 
			"org.eclipse.m2m.qvt.oml.resource_source_chooser"); //$NON-NLS-1$
        return myControl;
    }
    
	protected String getDefaultFileName() {
		return null;
	}

	public void setInitialSelection(String uriString) {
    	URI uri = URI.createURI(uriString);
        if(uri == null) {
            return;
        }

        IFile file = org.eclipse.m2m.qvt.oml.emf.util.URIUtils.getFile(uri);
        if (file != null) {
            myInitialSelection = createSelectionForUri(uri, file);
            return;
        }

        EObject obj = EmfUtil.safeLoadModel(uri);
        if (obj != null) {
            myInitialSelection = new StructuredSelection(EmfModelContentProvider.makeEObjectNode(obj, null));
            return;
        }
    }

	public static IStructuredSelection createSelectionForUri(URI uri, IFile file) {
		StructuredSelection initialSelection;
		if(!uri.hasFragment()) {
            initialSelection = new StructuredSelection(file);
        }
        else {
	        EObject obj = EmfUtil.loadModel(uri);
	        if(obj == null) {
	        	initialSelection = new StructuredSelection(file);        	
	        }
	        else {
	        	initialSelection = new StructuredSelection(EmfModelContentProvider.makeEObjectNode(obj, file));
	        }
        }
		return initialSelection;
	}
    
    
    public String getTitle() {
        return Messages.EObjectResourceChooser_0;
    }
    
    public EObject getObject() {
        return myObject;
    }
    
    public URI getUri() {
        return myUri;
    }
    
    public String getUriString() {
        return myUri == null ? null : myUri.toString();
    }
    
    private SelectUriControl myControl;
    protected IStructuredSelection myInitialSelection;
    private EObject myObject;
    private URI myUri;
    private final boolean myIsConsiderAdaptes;
}
