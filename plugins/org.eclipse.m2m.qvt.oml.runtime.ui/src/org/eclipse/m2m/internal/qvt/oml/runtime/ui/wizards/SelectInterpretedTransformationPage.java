/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
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

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.project.TransformationRegistry;
import org.eclipse.m2m.internal.qvt.oml.common.ui.controls.UniSelectTransformationControl;
import org.eclipse.m2m.internal.qvt.oml.common.ui.wizards.ITransformationSelector;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformationRegistry;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;

/**
 * @author sboyko
 */
public class SelectInterpretedTransformationPage extends WizardPage implements ITransformationSelector {

	public SelectInterpretedTransformationPage(String pageId) {
        super(pageId);
        myResourceFilter = new UniSelectTransformationControl.IResourceFilter() {
            public boolean accept(IResource resource) {
                return resource instanceof IFile && MDAConstants.QVTO_FILE_EXTENSION.equalsIgnoreCase(resource.getFileExtension());
            }
        };
        setDescription(Messages.SelectWorkspaceTransformationPage_Description);
    }
	
	public void createControl(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new GridLayout(1, true));
        doCreateControl(composite);
        setControl(composite);
        
        setPageComplete(validatePage());

		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, MDAConstants.QVTO_TRANSFORMATION_CONTEXTID);
    }
    
    protected void doCreateControl(Composite parent) {
        myControl = new UniSelectTransformationControl(parent, myResourceFilter,
        		new QvtCompiledTransformationLabelProvider(), QvtTransformationRegistry.getInstance(), 
        		TransformationRegistry.EMPTY_FILTER);//new TransformationRegistry.InputFilter(input));
        myControl.addSelectionListener(new UniSelectTransformationControl.ISelectionListener() {
            public void selectionChanged(URI uri) {
                setPageComplete(validatePage());
            }
        });
    }
    
	protected boolean validatePage() {
        setMessage(null);
        setErrorMessage(null);
        myTransformation = null;
        
        QvtTransformation transformation;
        String transfName = null;
        try {
            URI uri = getSelectedUri();
            if (uri == null) {
            	return false;
            }
            transformation = new QvtInterpretedTransformation(TransformationUtil.getQvtModule(uri));
            
            List<TransformationParameter> parameters = transformation.getParameters();
            if (parameters.isEmpty()) {
                setErrorMessage(NLS.bind(Messages.SelectWorkspaceTransformationPage_emptyTransformation, null));
                return false;
            }
            transfName = transformation.getModuleName();
        }
        catch (Exception e) {
            setErrorMessage(e.getMessage());
            return false;
        }

        setMessage(NLS.bind(Messages.SelectWorkspaceTransformationPage_transformationSelected, transfName));
        myTransformation = transformation;
        return true;
    }
        
	public QvtTransformation getTransformation() {
		return myTransformation;
	}

    public void setSelectedTransformationId(String id) {
        myControl.selectTransformationByUri(id);
    }

	public String getSelectedTransformationId() {
		URI selectedUri = getSelectedUri();
		if (selectedUri == null) {
			return null;
		}
		return selectedUri.path();
	}
    
    private URI getSelectedUri() {
        return myControl != null ? myControl.getSelectedUri() : null;
    }
    
    private QvtTransformation myTransformation;
    private final UniSelectTransformationControl.IResourceFilter myResourceFilter;
    private UniSelectTransformationControl myControl;
}
