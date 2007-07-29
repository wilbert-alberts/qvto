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

package org.eclipse.m2m.internal.qvt.oml.runtime.ui.launch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.IUriGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TransformationControls;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.ui.IModelParameterInfo;
import org.eclipse.m2m.qvt.oml.emf.util.StatusUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * @author sboyko
 *
 */
public class TransformationSignatureLaunchControl extends ScrolledComposite {

	public TransformationSignatureLaunchControl(Composite parent, int style) {
		super(parent, style|SWT.V_SCROLL);
		
		setExpandHorizontal(true);
		setExpandVertical(true);
		setAlwaysShowScrollBars(true);
		
		setCompositeLayout(this);
		
		setTransformation(null, Collections.<IUriGroup.IModifyListener>emptyList());
	}
	
	public void setTransformation(QvtTransformation transformation, List<IUriGroup.IModifyListener> listeners) {
		myTransformation = transformation;

		Control content = getContent();
		if (content != null) {
			content.dispose();
		}
		final Composite area = new Composite(this, SWT.NONE);
		setContent(area);
		setCompositeLayout(area);
		
		createContents(area, listeners);
		setMinSize(area.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}

	public IStatus validate(Shell shell) {
		for (Map.Entry<IModelParameterInfo, IUriGroup> entry : myParamGroups.entrySet()) {
			entry.getValue().getValidator().update(entry.getKey(), shell);
		}
		
		IStatus result = StatusUtil.makeOkStatus();
		for (Map.Entry<IModelParameterInfo, IUriGroup> entry : myParamGroups.entrySet()) {
			try {
				IStatus status = entry.getValue().getValidator().validate(entry.getKey());
		        if (StatusUtil.isError(status)) {
		        	return status;
		        }
		        if (status.getSeverity() > result.getSeverity()) {
		    		result = status;
		    	}
			}
			catch (Exception e) {
		        return StatusUtil.makeErrorStatus(e.getMessage(), e);
			}
		}
		return result;
	}

	private void createContents(Composite parent, List<IUriGroup.IModifyListener> listeners) {
        try {
        	myParamGroups = new LinkedHashMap<IModelParameterInfo, IUriGroup>();
			for (IModelParameterInfo paramInfo : getTransfParameters()) {
				IUriGroup uriGroup = TransformationControls.createUriGroup(parent, paramInfo);
				myParamGroups.put(paramInfo, uriGroup);
				for (IUriGroup.IModifyListener listener : listeners) {
					uriGroup.addModifyListener(listener);
				}
			}
		} catch (MdaException e) {
			myParamGroups = Collections.emptyMap();
		}
	}
	
	private void setCompositeLayout(Composite cm) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		cm.setLayout(layout);
		
    	GridData data = new GridData(GridData.FILL_BOTH);
        data.horizontalSpan = TransformationControls.GRID;
        cm.setLayoutData(data);		
	}
	
	private List<IModelParameterInfo> getTransfParameters() throws MdaException {
		if (myTransformation == null) {
			return Collections.emptyList();
		}
		
		List<IModelParameterInfo> modelParams = new ArrayList<IModelParameterInfo>();
		for (TransformationParameter param : myTransformation.getParameters()) {			
		}
		
		modelParams.add(DUMMY_PARAM_IN);
		modelParams.add(DUMMY_PARAM_OUT);
		return modelParams;
	}
	
	private static class ModelParameter implements IModelParameterInfo {
		
		ModelParameter(TransformationParameter transfParam) {
			
		}

		public Direction getDirection() {
			// TODO Auto-generated method stub
			return null;
		}

		public EClassifier getEntryParamType() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getEntryParamTypeName() {
			// TODO Auto-generated method stub
			return null;
		}

		public EPackage getMetamodel() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getModelTypeName() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean isInOutParameter() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isInParameter() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isOutParameter() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}

	private static final IModelParameterInfo DUMMY_PARAM_IN = new IModelParameterInfo() {

		public Direction getDirection() {
			return Direction.in;
		}

		public EClassifier getEntryParamType() {
			return null;
		}

		public String getEntryParamTypeName() {
			return null;
		}

		public EPackage getMetamodel() {
			return EcorePackage.eINSTANCE;
		}

		public String getModelTypeName() {
			return EcorePackage.eINSTANCE.getName();
		}

		public String getName() {
			return "model1"; //$NON-NLS-1$
		}

		public boolean isInOutParameter() {
			return false;
		}

		public boolean isInParameter() {
			return true;
		}

		public boolean isOutParameter() {
			return false;
		}
	};
	
	private static final IModelParameterInfo DUMMY_PARAM_OUT = new IModelParameterInfo() {

		public Direction getDirection() {
			return Direction.out;
		}

		public EClassifier getEntryParamType() {
			return null;
		}

		public String getEntryParamTypeName() {
			return null;
		}

		public EPackage getMetamodel() {
			return EcorePackage.eINSTANCE;
		}

		public String getModelTypeName() {
			return EcorePackage.eINSTANCE.getName();
		}

		public String getName() {
			return ""; //$NON-NLS-1$
		}

		public boolean isInOutParameter() {
			return true;
		}

		public boolean isInParameter() {
			return false;
		}

		public boolean isOutParameter() {
			return false;
		}
	};
	
	private QvtTransformation myTransformation;
	private Map<IModelParameterInfo, IUriGroup> myParamGroups = Collections.emptyMap();

}
