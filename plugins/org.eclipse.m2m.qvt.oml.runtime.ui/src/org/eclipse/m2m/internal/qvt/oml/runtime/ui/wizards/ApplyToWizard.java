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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ISetMessage;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TransformationControls;
import org.eclipse.m2m.internal.qvt.oml.common.ui.wizards.ITransformationSelector;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.ChooserPageAdapter;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IMetamodelHandler;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.ISourceChooser;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.MetamodelHandlerManager;
import org.eclipse.osgi.util.NLS;

public class ApplyToWizard extends ApplyWizard {
    public ApplyToWizard(final QvtTransformation qvtTransformation){
        super(new ApplyTransformationData().setTransformation(qvtTransformation));

        final ISourceChooser chooser = getChooser(qvtTransformation);
        myTransfomationSourcePage = new ChooserPageAdapter(chooser) {
            @Override
			protected boolean validatePage() {
                setMessage(null);
                setErrorMessage(null);
                
                if(chooser.getObject() == null) {
                    setMessage(Messages.ApplyToWizard_NoSource);
                    return false;
                }
                
                try {
                	IStatus status = qvtTransformation.canRun(chooser.getObject());
                	boolean isOk = TransformationControls.statusToTab(status, SET_MESSAGE);
                    if(!isOk) {
                        return false;
                    }
                }
                catch(MdaException e) {
                    setErrorMessage(e.getMessage());
                    return false;
                }
                
                return true;
            }
        };
    }
    
    private ISourceChooser getChooser(final QvtTransformation qvtTransformation) {
        EClass in;
        try {
            in = qvtTransformation.getIn();
        }
        catch (MdaException e) {
            MessageDialog.openError(getShell(), NLS.bind(Messages.ApplyToWizard_FailedToGetTransformationOutput, qvtTransformation), e.getLocalizedMessage());
            return null;
        }
        
        String packageUri = EmfUtil.getRootPackage(in.getEPackage()).getNsURI();
        
        final IMetamodelHandler handler = MetamodelHandlerManager.getInstance().getHandler(packageUri);
        if(handler == null) {
            throw new RuntimeException(Messages.ApplyToWizard_InputNotSupported);
        }
        
        ISourceChooser chooser = handler.getSourceChooser();
        return chooser;
    }
    
    @Override
	public void addPages() {
        addPage(myTransfomationSourcePage);
        super.addPages();
    }
    
    private final ISetMessage SET_MESSAGE = new ISetMessage() {
        public void setErrorMessage(String message){
        	myTransfomationSourcePage.setErrorMessage(message);
        }

        public void setMessage(String message) {
        	myTransfomationSourcePage.setMessage(message);
        }
    };

    @Override
	protected ITransformationSelector getTransformationSelectorPage() {
        return null;
    }

    private ChooserPageAdapter myTransfomationSourcePage;    
}
