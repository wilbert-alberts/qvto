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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.qvt.oml.common.ui.IModelParameterInfo;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IChooser;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IMetamodelHandler;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.MetamodelHandlerManager;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * @author sboyko
 *
 */
public class UriGroupIn extends BaseUriGroup {
	
    public UriGroupIn(Composite parent, String name) {
    	super(parent, SWT.NONE);
    	
		setLayout(new GridLayout(3, false));
        
		createLabel(name, 1);
        
        myUriText = TransformationControls.createText(this, 1);
        myUriText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				fireModified();
			}
        });
        
        myBrowseButton = TransformationControls.createButton(this, Messages.BrowseButtonLabel);
        myBrowseButton.setEnabled(false);
        myBrowseButton.addSelectionListener(new SelectionAdapter() {
            @Override
			public void widgetSelected(SelectionEvent e) {
                if (myActiveListener != null) {
                    myActiveListener.widgetSelected(e);
                }
            }
        });
    }
    
    public void initializeFrom(TargetUriData uriData) {
        myUriText.setText(uriData.getUriString());
    }

	public TargetUriData getUriData() {
		return new TargetUriData(getText());
	}
    
    public String getText() {
        return myUriText.getText();
    }
    
    public void update(String uri, Shell shell) {
        if(uri == null) {
            myUriText.setEnabled(false);
            myBrowseButton.setEnabled(false);
            myActiveListener = null;
        }
        else {
            IMetamodelHandler handler = MetamodelHandlerManager.getInstance().getHandler(uri);
            if (handler == null) {
                throw new RuntimeException("No handler for URI " + uri); //$NON-NLS-1$
            }
            else {
                IChooser chooser = handler.getSourceChooser();
                
                myActiveListener = new UriChooserListener(myUriText, chooser, shell);
                myUriText.setEnabled(true);
                myBrowseButton.setEnabled(true);
            }
        }
    }

	public IValidator getValidator() {
		return myValidator;
	}
	
	private class Validator implements IValidator {

		public IStatus validate(IModelParameterInfo paramInfo) {
			if (paramInfo.getMetamodel() == null) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_EmptyInputTransfParam,
	            		paramInfo.getName()));
			}

			EClassifier classifier = paramInfo.getEntryParamType();
			if (classifier == null) {
				classifier = paramInfo.getMetamodel().eClass();
			}
			
			URI sourceUri = EmfUtil.makeUri(getText());
	        EObject in = EmfUtil.loadModel(sourceUri, classifier.eResource() != null ? classifier.eResource().getResourceSet() : null);
	        if (in == null) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidSourceUri, getText()));
	        }
	        try {
	        	in = EmfUtil.resolveSource(in, classifier);
	        }
	        catch (WrappedException e) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidSourceUri, getText()));
	        }
			
	    	if (!EmfUtil.isAssignableFrom(classifier, in.eClass()) || !classifier.isInstance(in)) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputTypes, 
	            		EmfUtil.getFullName(in.eClass()),
	            		EmfUtil.getFullName(classifier)                		
	            		));
	    	}
	        
			return StatusUtil.makeOkStatus();
		}

		public void update(String moduleName, IModelParameterInfo paramInfo, Shell shell) {
			EClassifier classifier = paramInfo.getEntryParamType();
			if (classifier == null) {
				classifier = paramInfo.getMetamodel().eClass();
			}
			UriGroupIn.this.update(EmfUtil.getRootPackageUri(classifier), shell);
		}

	}
    
    private final Text myUriText;
    private final Button myBrowseButton;
    private SelectionListener myActiveListener;
    private final IValidator myValidator = new Validator();
}
