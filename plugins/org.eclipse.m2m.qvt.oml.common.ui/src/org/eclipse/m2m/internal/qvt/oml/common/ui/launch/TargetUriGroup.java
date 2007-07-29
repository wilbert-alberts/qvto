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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData.TargetType;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IChooser;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IDestinationChooser;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IMetamodelHandler;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.MetamodelHandlerManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class TargetUriGroup extends Composite implements ITargetUriGroup {
	public static interface IModifyListener {
		void modified();
	}
	
	public TargetUriGroup(Composite parent, ISourceUriGroup sourceUri) {
		super(parent, SWT.NONE);
		
		myData = new TargetUriData(""); //$NON-NLS-1$
		myUpdating = false;
		
		mySourceUri = sourceUri;
		mySourceUri.addModifyListener(SOURCE_URI_LISTENER);
		
		myListeners = new ArrayList<IModifyListener>();
		
		
		setLayout(new GridLayout(3, false));
		
		{
			createLabel(Messages.TargetUriSelector_Model, 1);

			myTargetTypeCombo = new Combo(this, SWT.DROP_DOWN | SWT.READ_ONLY);
			GridData gridData = new GridData();
			gridData.horizontalSpan = 1;
			myTargetTypeCombo.setLayoutData(gridData);
			
			myTargetTypeCombo.add(Messages.TargetUriSelector_NewModel);
			myTargetTypeCombo.add(Messages.TargetUriSelector_ExistingModel);
			myTargetTypeCombo.add(Messages.TargetUriSelector_Inplace);
			myTargetTypeCombo.addSelectionListener(new SelectionAdapter(){
				@Override
				public void widgetSelected(SelectionEvent e) {
					updateData();
				}
			});
			
			createLabel("", 1); //$NON-NLS-1$
		}
		
		{
			createLabel(Messages.TargetUriSelector_Uri, 1);
			
			myUriText = TransformationControls.createText(this, 1);
			myUriText.addModifyListener(MODIFY_LISTENER);

			myUriButton = TransformationControls.createButton(this, Messages.TargetUriSelector_Browse);
			myUriButton.addSelectionListener(new SelectionAdapter(){
	            @Override
				public void widgetSelected(SelectionEvent e) {
	                if(myActiveListener != null) {
	                    myActiveListener.widgetSelected(e);
	                }
	            }
			});
		}
		
		{
			createLabel(Messages.TargetUriSelector_Feature, 1);
		
			myFeatureText = TransformationControls.createText(this, 1);
			myFeatureText.addModifyListener(MODIFY_LISTENER);
			
			myFeatureButton = TransformationControls.createButton(this, Messages.TargetUriSelector_Select);
			myFeatureButton.addSelectionListener(new SelectionAdapter(){
				@Override
				public void widgetSelected(SelectionEvent e) {
					if(myObject == null) {
						throw new RuntimeException("No object"); //$NON-NLS-1$
					}

					EStructuralFeature feature = myObject.eClass().getEStructuralFeature(myData.getFeature());
					EReference initRef = feature instanceof EReference ? (EReference)feature : null;
					ReferenceSelectionDialog dialog = new ReferenceSelectionDialog(myObject.eClass(), initRef, getShell());
					if(dialog.open() == Window.OK) {
						EReference ref = dialog.getReference();
						myFeatureText.setText(ref.getName());
					}
				}
			});
		}
		
		{
			createLabel("", 1); //$NON-NLS-1$

			myClearContentsCheckbox = new Button(this, SWT.CHECK);
			myClearContentsCheckbox.setText(Messages.TargetUriSelector_ClearContents);
			myClearContentsCheckbox.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					updateData();
				}
			});
			
			GridData gridData = new GridData();
			gridData.horizontalSpan = 1;
			myClearContentsCheckbox.setLayoutData(gridData);
		}
		
		initializeFrom(myData);
	}
	
	public void initializeFrom(TargetUriData targetData) {
		myUpdating = true;
		try {
		myTargetTypeCombo.select(TARGET_TYPES.indexOf(targetData.getTargetType()));
		myUriText.setText(targetData.getUriString() == null ? "" : targetData.getUriString()); //$NON-NLS-1$
		myFeatureText.setText(targetData.getFeature() == null ? "" : targetData.getFeature()); //$NON-NLS-1$
		myClearContentsCheckbox.setSelection(targetData.isClearContents());
	}
		finally {
			myUpdating = false;
		}
		
		updateData();
	}
	
	public void addModifyListener(IModifyListener listener) {
		myListeners.add(listener);
	}
	
	public boolean removeModifyListener(IModifyListener listener) {
		return myListeners.remove(listener);
	}
	
	@Override
	public TargetUriData getData() {
		return myData;
	}
	
	private void updateData() {
		if(myUpdating) {
			return;
		}
		
		try {
			TargetUriData oldData = new TargetUriData(myData);
			EObject oldObject = myObject;
			
			myObject = null;
			
			TargetType targetType = TARGET_TYPES.get(myTargetTypeCombo.getSelectionIndex());
			myData = new TargetUriData(targetType,
					targetType == TargetType.INPLACE ? mySourceUri.getText() : myUriText.getText().trim(),
					myFeatureText.getText(),
					myClearContentsCheckbox.getSelection());
			
			switch(myData.getTargetType()) {
				case NEW_MODEL: { 
					myFeatureText.setEnabled(false);
					myFeatureButton.setEnabled(false);
					myClearContentsCheckbox.setEnabled(false);
					myUriText.setEnabled(true);
					myUriButton.setEnabled(true);
					break;
				}
				
				case INPLACE: {
					myObject = null;
					
					myUriText.setEnabled(false);
					myUriButton.setEnabled(false);
					myUriText.removeModifyListener(MODIFY_LISTENER);
					try {
						myUriText.setText(mySourceUri.getText());
					}
					finally {
						myUriText.addModifyListener(MODIFY_LISTENER);
					}
					
					myFeatureText.setEnabled(false);
					myFeatureButton.setEnabled(false);
					myClearContentsCheckbox.setEnabled(false);

					break;
				}			
	
				case EXISTING_CONTAINER: {
					try {
						myObject = getEObject(oldData.getUriString(), oldObject);
					}
					finally {
						myFeatureText.setEnabled(myObject != null);
						myFeatureButton.setEnabled(myObject != null);
						myClearContentsCheckbox.setEnabled(myObject != null);
					}
					break;
				}
			}
		}
		finally {
			fireModified();
		}
	}
	
	private EObject getEObject(String oldUri, EObject oldObject) {
		boolean sameUri = oldUri == null ? myData.getUriString() == null : oldUri.equals(myData.getUriString());
		EObject  obj;
		if(sameUri && oldObject != null) {
			obj = oldObject;
		}
		else {
			URI uri = null;
            try {
                uri = URI.createURI(myData.getUriString());
            } catch (IllegalArgumentException e) {                
            }
            
			if(uri == null) {
				return null;
			}
			
			try {
				obj = EmfUtil.loadModel(uri);
			}
			catch(Exception e) {
				obj = null;
			}
		}
		
		return obj;
	}
	
    public String getText() {
        return myUriText.getText();
    }
    
    public Text getUriText() {
    	return myUriText;
    }

	public void update(String uri, String baseName, String extension, Shell shell) {
        if(uri == null) {
        	myUriText.setEnabled(false);
        	myUriButton.setEnabled(false);
            myActiveListener = null;
        }
        else {
            IMetamodelHandler handler = MetamodelHandlerManager.getInstance().getHandler(uri);
            if(handler == null) {
                throw new RuntimeException("No handler for URI " + uri); //$NON-NLS-1$
            }
            else {
                IChooser chooser;
                switch(myData.getTargetType()) {
	                case NEW_MODEL: {
	                	chooser = handler.getDestinationChooser();
	                    ((IDestinationChooser)chooser).initNewName(baseName, extension);
	                    break;
	                }
	                	
	                case EXISTING_CONTAINER:
	                case INPLACE: {
	                	chooser = handler.getSourceChooser();
	                	break;
	                }
	                
	                default: {
	                	throw new RuntimeException("Invalid type " + myData.getTargetType()); //$NON-NLS-1$
	                }
                }
                
                myActiveListener = new UriChooserListener(myUriText, chooser, shell);
                if(myData.getTargetType() != TargetType.INPLACE) { // TODO hack
                	myUriText.setEnabled(true);
                	myUriButton.setEnabled(true);
                }
            }
        }
    }
	
    private void fireModified() {
        for (Iterator<IModifyListener> it = new ArrayList<IModifyListener>(myListeners).iterator(); it.hasNext();) {
            IModifyListener listener = it.next();
            try {
                listener.modified();
            }
            catch(Exception e) {
            }
        }
    }
	
    private Label createLabel(String text, int span){
        Label label = new Label(this, SWT.NONE);
        label.setText(text);
        GridData data = new GridData();
        data.horizontalSpan = span;
        label.setLayoutData(data);
        return label;
    }
    
    @Override
	public void dispose() {
    	if(mySourceUri != null) {
    		mySourceUri.removeModifyListener(SOURCE_URI_LISTENER);
    	}
    }
	
	private TargetUriData myData;
	private boolean myUpdating;
	private final ISourceUriGroup mySourceUri;
	private final ISourceUriGroup.IModifyListener SOURCE_URI_LISTENER = new ISourceUriGroup.IModifyListener() {
		public void modified() {
			if(myData.getTargetType() == TargetType.INPLACE) {
				myUriText.setText(mySourceUri.getText());
			}
		}
	};
	
	private EObject myObject;

	private final Combo myTargetTypeCombo;
	private final List<TargetType> TARGET_TYPES = Arrays.asList(new TargetType[] {
			TargetType.NEW_MODEL,
			TargetType.EXISTING_CONTAINER,
			TargetType.INPLACE,
	});
	
	private final Text myUriText;
	private final Button myUriButton;
    private SelectionListener myActiveListener;
	
	private final Text myFeatureText;
	private final Button myFeatureButton;
	
	private final Button myClearContentsCheckbox;
	
	private final List<IModifyListener> myListeners;
	
	private final ModifyListener MODIFY_LISTENER = new ModifyListener() {
		public void modifyText(ModifyEvent e) {
			updateData();
		}
	};
}
