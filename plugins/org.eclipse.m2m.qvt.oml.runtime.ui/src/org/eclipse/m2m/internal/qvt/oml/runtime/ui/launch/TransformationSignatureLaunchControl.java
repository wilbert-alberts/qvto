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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.IUriGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TransformationControls;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.qvt.oml.common.ui.IModelParameterInfo;
import org.eclipse.m2m.qvt.oml.emf.util.StatusUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
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

		Point computeSize = area.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		setMinSize(computeSize);
		setSize(getSize().x, computeSize.y);
		getParent().layout();
	}

	public IStatus validate(String moduleName, Shell shell) {
		for (Map.Entry<IModelParameterInfo, IUriGroup> entry : myParamGroups.entrySet()) {
			entry.getValue().getValidator().update(moduleName, entry.getKey(), shell);
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

	public void initializeFrom(ILaunchConfiguration configuration) throws CoreException {
		List<TargetUriData> targetUris = QvtLaunchUtil.getTargetUris(configuration);
    	int i = 0;
		for (Map.Entry<IModelParameterInfo, IUriGroup> entry : myParamGroups.entrySet()) {
			if (i >= targetUris.size()) {
				break;
			}
    		entry.getValue().initializeFrom(targetUris.get(i));
    		i++;
    	}
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
    	configuration.setAttribute(IQvtLaunchConstants.ELEM_COUNT, myParamGroups.size());
    	int i = 0;
		for (Map.Entry<IModelParameterInfo, IUriGroup> entry : myParamGroups.entrySet()) {
    		QvtLaunchUtil.saveTargetUriData(configuration, entry.getValue().getUriData(), i+1);
    		i++;
    	}
	}
	
	public String getTraceName() {
		for (Map.Entry<IModelParameterInfo, IUriGroup> entry : myParamGroups.entrySet()) {
			if (entry.getKey().isInOutParameter() || entry.getKey().isOutParameter()) {
				return entry.getValue().getUriData().getUriString();
			}
    	}
		return ""; //$NON-NLS-1$
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
			modelParams.add(createModelParamInfo(param));
		}		
		return modelParams;
	}
	
	private IModelParameterInfo createModelParamInfo(final TransformationParameter param) {
		return new IModelParameterInfo() {

			public Direction getDirection() {
				if (param.getDirectionKind() == DirectionKind.IN) {
					return Direction.in;
				}
				if (param.getDirectionKind() == DirectionKind.OUT) {
					return Direction.out;
				}
				return Direction.inout;
			}

			public EClassifier getEntryParamType() {
				return param.getEntryType();
			}

			public String getEntryParamTypeName() {
				return param.getEntryName();
			}

			public EPackage getMetamodel() {
				List<EPackage> metamodels = param.getMetamodels();
				return metamodels.isEmpty()? null : metamodels.get(0);
			}

			public String getModelTypeName() {
				List<String> modelTypeNames = param.getModelTypeNames();
				return modelTypeNames.isEmpty() ? "" : modelTypeNames.get(0); //$NON-NLS-1$
			}

			public String getName() {
				return param.getName();
			}

			public boolean isInOutParameter() {
				return getDirection() == Direction.inout;
			}

			public boolean isInParameter() {
				return getDirection() == Direction.in;
			}

			public boolean isOutParameter() {
				return getDirection() == Direction.out;
			}
			
		};
	}

	private QvtTransformation myTransformation;
	private Map<IModelParameterInfo, IUriGroup> myParamGroups = Collections.emptyMap();

}
