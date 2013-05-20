/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - bug 388329 
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.ui.controls;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.m2m.internal.qvt.oml.common.project.IRegistryConstants;
import org.eclipse.m2m.internal.qvt.oml.common.project.TransformationRegistry;
import org.eclipse.m2m.internal.qvt.oml.common.project.TransformationRegistry.Filter;
import org.eclipse.m2m.internal.qvt.oml.common.ui.dialogs.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

/**
 * @author sboyko
 */
public class BrowseInterpretedTransformationDialog extends SelectionStatusDialog {

	public static interface ISelectionListener {
        IStatus selectionChanged(URI selectedUri);
    }

    public BrowseInterpretedTransformationDialog(Shell shell, UniSelectTransformationControl.IResourceFilter resourceFilter,
    		ILabelProvider labelProvider, TransformationRegistry registry, String selectedTransId, ISelectionListener selectionListener) {
        super(shell);

		setTitle(Messages.BrowseInterpretedTransformationDialog_Title);
		setMessage(Messages.BrowseInterpretedTransformationDialog_Description);

		setShellStyle(getShellStyle() | SWT.RESIZE);
		setStatusLineAboveButtons(true);
		
        myResourceFilter = resourceFilter;
        myRegistry = registry;
        myLabelProvider = labelProvider;
        myInitialTransId = selectedTransId;
        mySelectionListener = selectionListener;
    }
    
    public URI getSelectedUri(){
        return mySelectedUri;
    }
    
    @Override
	protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);        
		composite.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL));

		createMessageArea(composite);
        
        myControl = new UniSelectTransformationControl(parent, myResourceFilter,
        		myLabelProvider, myRegistry, new Filter() {
					
        			public boolean accept(IConfigurationElement element) {
        				
        				// bug 388329: accept only transformations
        				return IRegistryConstants.TRANSFORMATION.equals(element.getName());
            	
        			}
				});
        myControl.addSelectionListener(new UniSelectTransformationControl.ISelectionListener() {
            public void selectionChanged(URI uri) {
            	IStatus selStatus = mySelectionListener.selectionChanged(uri);
            	mySelectedUri = selStatus.isOK() ? uri : null;
            	updateStatus(selStatus);
            }
        });
        myControl.selectTransformationByUri(myInitialTransId);
        
        return myControl;
    }
    
	@Override
	protected void computeResult() {
	}

    private final String myInitialTransId;
    private final TransformationRegistry myRegistry;
    private final ILabelProvider myLabelProvider;
    private final UniSelectTransformationControl.IResourceFilter myResourceFilter;
    private final ISelectionListener mySelectionListener;
    
    private URI mySelectedUri;
    private UniSelectTransformationControl myControl;
}
