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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.internal.qvt.oml.common.CommonPlugin;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ISetMessage;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ISetMessageEx;
import org.eclipse.m2m.internal.qvt.oml.common.ui.IModelParameterInfo;
import org.eclipse.m2m.internal.qvt.oml.common.ui.IModelParameterInfo.Direction;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;


public class TransformationControls {
    private TransformationControls() {}
    
    public static IUriGroup createUriGroup(Composite parent, IModelParameterInfo paramInfo) {
    	Group group = new Group(parent, SWT.NONE);
    	group.setText(getParameterName(paramInfo));
    	group.setLayout(new FillLayout());

    	GridData data = new GridData(GridData.FILL_HORIZONTAL);
        data.horizontalSpan = GRID;
        group.setLayoutData(data);
    	
        if (paramInfo.isInParameter()) {
	        UriGroupIn uriGroup = new UriGroupIn(group, Messages.TargetUriSelector_Uri);
	        return uriGroup;
        }
        else if (paramInfo.isInOutParameter()) {
        	UriGroupInOut uriGroup = new UriGroupInOut(group, Messages.TargetUriSelector_Uri);
            return uriGroup;
        }
        else {
        	UriGroupOut uriGroup = new UriGroupOut(group, Messages.TargetUriSelector_Uri);
            return uriGroup;
        }
    }
    
    private static String getParameterName(IModelParameterInfo paramInfo) {
    	String typeName;
    	if (paramInfo.getDirection() == Direction.out
    			|| paramInfo.getEntryParamType() == null) {
    		typeName = paramInfo.getModelTypeName();
    		if (paramInfo.getMetamodel() != null
    				&& paramInfo.getMetamodel().getNsURI().length() > 0) {
    			typeName += " (" + paramInfo.getMetamodel().getNsURI() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
    		}
    	}
    	else {
    		typeName = EmfUtil.getFullName(paramInfo.getEntryParamType()); 
    		typeName += '@';
	    	typeName += paramInfo.getModelTypeName();
    	}
    	return paramInfo.getDirection().name().toUpperCase() + "  " + paramInfo.getName() //$NON-NLS-1$ 
    			+ " : " + typeName; //$NON-NLS-1$
    }
    
    public static Button createButton(Composite parent,String text){
        return createButton(parent, text, SWT.PUSH, GridData.BEGINNING);
    }
    
    public static Button createButton(Composite parent,String text,int style,int gridData){
        Button button = new Button(parent,style);
        button.setText(text);
        GridData data = new GridData(gridData);
        button.setLayoutData(data);
        return button;
    }
    
    public static Button createCheckBox(Composite parent,String text){
        Button button = new Button(parent,SWT.CHECK);
        button.setText(text);
        GridData data = new GridData(GridData.FILL_HORIZONTAL);
        data.horizontalSpan = GRID;
        button.setLayoutData(data);
        return button;
    }
    
    public static Label createLabel(Composite parent, String text, int span){
        Label label = new Label(parent, SWT.NONE);
        label.setText(text);
        GridData data = new GridData(GridData.FILL_HORIZONTAL);
        data.horizontalSpan = span;
        label.setLayoutData(data);
        return label;
    }
    
    public static Text createText(Composite parent, int span) {
        return createText(parent, SWT.BORDER, span);
    }
    
    public static Text createText(Composite parent, int style, int span) {
        final Text text = new Text(parent, style);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = span;
        text.setLayoutData(gd);     
        
        return text;
    }
    
    public static IResource browseWorkspace(Object input, Object initialSelection, ViewerFilter filter, ISelectionStatusValidator validator, Shell shell, String title, String helpId) {
        ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
                        shell,
                        new WorkbenchLabelProvider(), new WorkbenchContentProvider());
        dialog.setInput(input);
        if (initialSelection!=null){
                dialog.setInitialSelection(initialSelection);
        }
        
        if(filter != null){
            dialog.addFilter(filter);
        }
        
        dialog.setComparator(FileViewerSorter.INSTANCE);
        
        dialog.setAllowMultiple(false);
        dialog.setTitle(title);

        if(validator != null){
            dialog.setValidator(validator);
        }
        
        dialog.create();
        PlatformUI.getWorkbench().getHelpSystem().setHelp(dialog.getShell(), helpId);
        if(dialog.open() == Window.OK) {
                return (IResource) dialog.getFirstResult();
        }
        
        return null;
    }
    
    public static IStatus makeStatus(int code,String message){
        return new Status(code,CommonPlugin.ID,code,message,null);
    }
    
    public static boolean statusToTab(IStatus status, ISetMessage tab) {
        tab.setMessage(null);
        tab.setErrorMessage(null);
        
        if(status == null) {
            return true;
        }
        
        switch(status.getSeverity()) {
            case IStatus.ERROR: {
                tab.setErrorMessage(status.getMessage());
                return false;
            }
            
            case IStatus.WARNING: {
            	if (tab instanceof ISetMessageEx) {
                    ((ISetMessageEx) tab).setWarningMessage(status.getMessage());
            	}
            	else {
                    tab.setMessage(status.getMessage());
            	}
                return true;
            }
            
            default: {
            	if (tab instanceof ISetMessageEx) {
                    tab.setMessage(status.getMessage());
            	}
                return true;
            }
        }
    }

    public static final int GRID = 2;
    public static final int TEXT_GRID = 1;
}

class FileViewerSorter extends ViewerComparator {
    @Override
	public int category(Object element) {
        if (element instanceof IFile) {
            return 1;
        }
        
        return 0;
    }
    
    static FileViewerSorter INSTANCE = new FileViewerSorter();
}
