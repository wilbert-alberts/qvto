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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData.TargetType;
import org.eclipse.m2m.qvt.oml.common.ui.IModelParameterInfo;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IChooser;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IDestinationChooser;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IMetamodelHandler;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.MetamodelHandlerManager;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * @author sboyko
 *
 */
public class UriGroupOut extends BaseUriGroup {
	
	public UriGroupOut(Composite parent, String name) {
		super(parent, SWT.NONE);
		
		myData = new TargetUriData(""); //$NON-NLS-1$
		myUpdating = false;
		
		setLayout(new GridLayout(3, false));
		
		{
			createLabel(name, 1);
			
			myUriText = TransformationControls.createText(this, 1);
			myUriText.addModifyListener(MODIFY_LISTENER);

			myUriButton = TransformationControls.createButton(this, Messages.TargetUriSelector_Browse);
			myUriButton.addSelectionListener(new SelectionAdapter(){
	            @Override
				public void widgetSelected(SelectionEvent e) {
	                if (myActiveListener != null) {
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
					if (myObject == null) {
						throw new RuntimeException("No object"); //$NON-NLS-1$
					}

					EStructuralFeature feature = myObject.eClass().getEStructuralFeature(myData.getFeature());
					EReference initRef = feature instanceof EReference ? (EReference)feature : null;
					ReferenceSelectionDialog dialog = new ReferenceSelectionDialog(myObject.eClass(), initRef, getShell(), refFilter);
					if (dialog.open() == Window.OK) {
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
			myUriText.setText(targetData.getUriString() == null ? "" : targetData.getUriString()); //$NON-NLS-1$
			myFeatureText.setText(targetData.getFeature() == null ? "" : targetData.getFeature()); //$NON-NLS-1$
			myClearContentsCheckbox.setSelection(targetData.isClearContents());
		}
		finally {
			myUpdating = false;
		}
		
		updateData();
	}
	
	public TargetUriData getUriData() {
		return new TargetUriData(
				myData.getFeature().trim().length() == 0 ? TargetType.NEW_MODEL : myData.getTargetType(),
				myData.getUriString(), myData.getFeature(), myData.isClearContents());
	}
	
    public String getText() {
        return myUriText.getText();
    }
    
	public void update(String uri, String baseName, String extension, Shell shell) {
        if (uri == null) {
        	myUriText.setEnabled(false);
        	myUriButton.setEnabled(false);
            myActiveListener = null;
        }
        else {
            IMetamodelHandler handler = MetamodelHandlerManager.getInstance().getHandler(uri);
            if (handler == null) {
                throw new RuntimeException("No handler for URI " + uri); //$NON-NLS-1$
            }
            else {
                IChooser chooser = handler.getDestinationChooser();
                ((IDestinationChooser) chooser).initNewName(baseName, extension);
                
                myActiveListener = new UriChooserListener(myUriText, chooser, shell);
            	myUriText.setEnabled(true);
            	myUriButton.setEnabled(true);
            }
        }
    }
	
	public IValidator getValidator() {
		return myValidator;
	}

	private void updateData() {
		if (myUpdating) {
			return;
		}
		
		try {
            TargetUriData oldData = new TargetUriData(myData);
			EObject oldObject = myObject;
			
			myObject = null;
			
			TargetType targetType = isUriExisted(getText()) ? TargetType.EXISTING_CONTAINER : TargetType.NEW_MODEL;
			myData = new TargetUriData(targetType,
					myUriText.getText().trim(),
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
				
				case EXISTING_CONTAINER: {
					try {
						myObject = getEObject(oldData.getUriString(), oldObject);
					}
					finally {
						myFeatureText.setEnabled(myObject != null);
						myFeatureButton.setEnabled(myObject != null);

						if (myObject != null) {
				        	EStructuralFeature feature = myObject.eClass().getEStructuralFeature(myFeatureText.getText());
							myClearContentsCheckbox.setEnabled(feature instanceof EReference);
			        	}
			        	else {
			        		myClearContentsCheckbox.setEnabled(false);
			        	}
					}
					break;
				}
			}
		}
		finally {
			fireModified();
		}
	}
	
	private boolean isUriExisted(String textUri) {
        URI destUri = EmfUtil.makeUri(textUri);
        if (destUri != null) {
        	EObject loadModel = null;
        	try {
        		loadModel = EmfUtil.loadModel(destUri);
        	}
        	catch (Exception e) {
        	}
            if (loadModel != null) {
            	return true;
            }
        }
        return false;
	}
	
	private EObject getEObject(String oldUri, EObject oldObject) {
		boolean sameUri = oldUri == null ? myData.getUriString() == null : oldUri.equals(myData.getUriString());
		EObject  obj;
		if (sameUri && oldObject != null) {
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

	        IMetamodelHandler handler = MetamodelHandlerManager.getInstance().getHandler(classifier);
	        if (handler == null) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_UnsupportedDestination, getText()));
	        }
			
            URI destUri = EmfUtil.makeUri(getText());
            if (destUri == null) {
                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidTargetUri, getText()));
            }
            
	        IStatus result = StatusUtil.makeOkStatus();
	        switch(myData.getTargetType()) {
	        case NEW_MODEL: {
	            IFile file = org.eclipse.m2m.qvt.oml.emf.util.URIUtils.getFile(destUri);
	            if (file != null && file.exists()) {
	                if (result.getSeverity() < IStatus.WARNING) {
	                	if (isUriExisted(getText())) {
	                		result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationExists, destUri));
	                	}
	                	else {
	                		result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationExistsNonEObject, destUri));
	                	}
	                }
	            }
	            
	        	IStatus canSave = handler.getSaver().canSave(classifier, destUri); 
	            if (StatusUtil.isError(canSave)) {
	            	return canSave;
	            }
	            if (canSave.getSeverity() > result.getSeverity()) {
	        		result = canSave;
	        	}
	            
	            if (destUri.hasFragment()) {
	                if (result.getSeverity() < IStatus.WARNING) {
	                    result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_NewDestinationHasFragment, destUri.fragment()));
	                }
	            }
	            break;
	        }

	        case EXISTING_CONTAINER: {
	        	EObject cont = EmfUtil.loadModel(destUri);
	        	if (cont == null) {
	                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidTargetUri, destUri));
	        	}
	        	
            	String uriPath = destUri.isFile() ? destUri.toFileString() :
        			(destUri.isPlatform() ? destUri.toPlatformString(true) : destUri.toString());
            	IFile file = WorkspaceUtils.getWorkspaceFile(uriPath);
            	if (file != null && file.exists() && file.isReadOnly()) {
	                if (result.getSeverity() < IStatus.WARNING) {
	                	result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationReadonly, destUri));
	                }
            	}
	        	
	        	String feature = myFeatureText.getText();
	        	if (feature == null || feature.trim().length() == 0) {
	                if (result.getSeverity() < IStatus.WARNING) {
	                	result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationExists, destUri));
	                }
	        	}
	        	else {
		        	EStructuralFeature eFeature = cont.eClass().getEStructuralFeature(feature);
		        	if (eFeature instanceof EReference == false) {
		                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidFeature, feature));
		        	}
		        	
		        	EReference ref = (EReference)eFeature;
		        	if (!ref.isChangeable()) {
		                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidFeature, ref.getName())); 
		        	}
		        	
		        	EClassifier refType = ref.getEType();
		        	if (!EmfUtil.isAssignableFrom(refType, classifier)) {
		                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputTypes,
		                		EmfUtil.getFullName(classifier), EmfUtil.getFullName(refType)));
		        	}
	        	}
	        	
	            break;
	        }
	        }
	        
			return result;
		}

		public void update(String moduleName, IModelParameterInfo paramInfo, Shell shell) {
			EClassifier classifier = paramInfo.getEntryParamType();
			if (classifier == null) {
				classifier = paramInfo.getMetamodel().eClass();
			}
	        String extension = paramInfo.getMetamodel().getName();//EmfUtil.getExtensionForResult(classifier);
			UriGroupOut.this.update(EmfUtil.getRootPackageUri(classifier),
					moduleName, extension, shell);
			
			final EClassifier paramType = classifier; 
			refFilter = new ReferenceSelectionDialog.IRefFilter() {
				public boolean accept(EReference ref) {
					return ref.isChangeable() && EmfUtil.isAssignableFrom(ref.getEType(), paramType);
				}
			};
		}
		
	}
    
	private TargetUriData myData;
	private boolean myUpdating;
	private EObject myObject;
    private final IValidator myValidator = new Validator();

	private final Text myUriText;
	private final Button myUriButton;
    private SelectionListener myActiveListener;
	private final Text myFeatureText;
	private final Button myFeatureButton;
	private final Button myClearContentsCheckbox;
	
	private final ModifyListener MODIFY_LISTENER = new ModifyListener() {
		public void modifyText(ModifyEvent e) {
			updateData();
		}
	};

	private ReferenceSelectionDialog.IRefFilter refFilter = ReferenceSelectionDialog.IRefFilter.DEFAULT;

}
