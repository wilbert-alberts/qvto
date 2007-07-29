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
package org.eclipse.m2m.qvt.oml.common.ui.action;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.m2m.qvt.oml.common.Logger;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate2;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;


public abstract class ObjectActionDelegate implements IObjectActionDelegate, IActionDelegate2 {

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		myPart = targetPart;
    }
	
    public void selectionChanged(IAction action, ISelection selection) {
        mySelection = selection;
    }
    
    public ISelection getSelection() {
    	return mySelection;
    }
    
    public IWorkbenchPart getPart(){
        return myPart;
    }

    protected abstract void runImpl(IAction action) throws Exception;
    
    public void run(IAction action) {
        try {
        	runImpl(action);
        }
        catch (InterruptedException canceled) {
        }
        catch(Exception e) {
        	showError(action, e.getMessage(), e);
        }
    }
    
	public void dispose() {
		myPart = null;
		mySelection = null;
	}

	public void init(IAction action) {
	}
	
	public void runWithEvent(IAction action, Event event) {
		run(action);
	}
	
    public void showError(IAction action, String message, Exception e) {
        String exMessage = e.getMessage();
        if(exMessage == null){
            exMessage = ""; //$NON-NLS-1$
        }
        if(message == null) {
            message = exMessage;
        }
        Logger.getLogger().log(Logger.SEVERE, message, e);
        Status status = new Status(IStatus.ERROR, "org.eclipse.m2m.qvt.oml", IStatus.ERROR, exMessage, e); //$NON-NLS-1$
        ErrorDialog.openError(getShell(), Messages.ActionDelegate_Failed, action.getText(), status); //$NON-NLS-1$
    }
    
	public Shell getShell(){
	    return myPart!=null ? myPart.getSite().getShell() : null; 
	}
	
    private ISelection mySelection;
    private IWorkbenchPart myPart;
}
