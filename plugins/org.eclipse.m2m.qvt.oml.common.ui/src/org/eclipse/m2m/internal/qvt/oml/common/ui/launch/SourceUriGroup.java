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
package org.eclipse.m2m.internal.qvt.oml.common.ui.launch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IChooser;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IMetamodelHandler;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.MetamodelHandlerManager;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class SourceUriGroup implements ISourceUriGroup {
    public SourceUriGroup(Composite parent, String name) {
        myListeners = new ArrayList<IModifyListener>();

    	TransformationControls.createLabel(parent, name, 2);
        
        myUriText = TransformationControls.createText(parent, 1);
        myUriText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				fireModified();
			}
        });
        
        myActiveListener = null;
        
        myBrowseButton = TransformationControls.createButton(parent, Messages.BrowseButtonLabel);
        myBrowseButton.setEnabled(false);
        myBrowseButton.addSelectionListener(new SelectionAdapter() {
            @Override
			public void widgetSelected(SelectionEvent e) {
                if(myActiveListener != null) {
                    myActiveListener.widgetSelected(e);
                }
            }
        });
    }
    
	public void addModifyListener(IModifyListener listener) {
		myListeners.add(listener);
	}

	public void removeModifyListener(IModifyListener listener) {
		myListeners.remove(listener);
	}
	
	private void fireModified() {
		for(IModifyListener listener: Collections.unmodifiableList(myListeners)) {
			try {
				listener.modified();
			}
			catch(Exception ignore) {
			}
		}
	}
    
    public Button getBrowseButton() {
        return myBrowseButton;
    }

    public String getText() {
        return myUriText.getText();
    }
    
    public void initializeFrom(String uri) {
        myUriText.setText(uri);
    }

    public void update(String uri, Shell shell) {
        if(uri == null) {
            myBrowseButton.setEnabled(false);
            myUriText.setEnabled(false);
            myActiveListener = null;
        }
        else {
            IMetamodelHandler handler = MetamodelHandlerManager.getInstance().getHandler(uri);
            if(handler == null) {
                throw new RuntimeException("No handler for URI " + uri); //$NON-NLS-1$
            }
            else {
                IChooser chooser = handler.getSourceChooser();
                
                myActiveListener = new UriChooserListener(myUriText, chooser, shell);
                myBrowseButton.setEnabled(true);
                myUriText.setEnabled(true);
            }
        }
    }
    
    private final Text myUriText;
    private final Button myBrowseButton;
    private SelectionListener myActiveListener;
    private final List<IModifyListener> myListeners;
}
