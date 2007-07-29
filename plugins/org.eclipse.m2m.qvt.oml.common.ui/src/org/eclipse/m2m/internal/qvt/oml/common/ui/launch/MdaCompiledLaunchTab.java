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

import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.internal.qvt.oml.common.ui.dialogs.BrowseCompiledTransfomationDialog;
import org.eclipse.m2m.qvt.oml.common.project.CompiledTransformation;
import org.eclipse.m2m.qvt.oml.common.project.TransformationRegistry;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.externaltools.internal.model.IExternalToolConstants;


public abstract class MdaCompiledLaunchTab extends MdaLaunchTab{
    protected abstract TransformationRegistry getRegistry();
    protected abstract ILabelProvider getLabelProvider();
    protected abstract String getBrowseDialogTitle(); 
    
    protected Text createTransfomationGroup(Composite parent){
        TransformationControls.createLabel(parent, Messages.MdaCompiledLaunchTab_TransformationId, TransformationControls.GRID);
        final Text text = TransformationControls.createText(parent, TransformationControls.TEXT_GRID);
        Button button = TransformationControls.createButton(parent, Messages.BrowseButtonLabel); //$NON-NLS-1$

        button.addSelectionListener(new SelectionAdapter(){
            @Override
			public void widgetSelected(SelectionEvent e) {
                BrowseCompiledTransfomationDialog dialog = new BrowseCompiledTransfomationDialog(getShell(), getBrowseDialogTitle(), getLabelProvider(), getRegistry(), text.getText());
                dialog.open();
                if(dialog.getReturnCode()==Window.OK){
                    CompiledTransformation transf = dialog.getSelectedTransfomation();
                    if(transf!=null){
                        text.setText(transf.getId());
                    }
                }
            }
        });
        return text;
    }
    
    public void performApply(ILaunchConfigurationWorkingCopy configuration) {
        setBuildTypes(configuration, new String[] {
                IExternalToolConstants.BUILD_TYPE_FULL,
                IExternalToolConstants.BUILD_TYPE_INCREMENTAL,
                IExternalToolConstants.BUILD_TYPE_AUTO,
        });
    }
    
    protected void setBuildTypes(ILaunchConfigurationWorkingCopy configuration, String [] buildTypes) {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < buildTypes.length; i++) {
            String buildType = buildTypes[i];
            if(s.length() > 0) {
                s.append(","); //$NON-NLS-1$
            }
            
            s.append(buildType);
        }
        
        configuration.setAttribute(IExternalToolConstants.ATTR_RUN_BUILD_KINDS, s.toString());
    }
}
