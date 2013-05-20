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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.launch;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.ITransformationMaker;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtModule;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;


/** @author pkobiakov */
public class QvtLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {
	
	public QvtLaunchConfigurationTabGroup() {
        myValidationRS = new ResourceSetImpl();
	}
	
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
        ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
                new QvtLauncherTab(TRANSFORMATION_MAKER, myValidationRS),
                new QvtTransformationConfigurationTab(TRANSFORMATION_MAKER),
                new CommonTab()
		};
		
		setTabs(tabs);
	}
	
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		final ILaunchConfiguration config = configuration;
		final ILaunchConfigurationTab[] tabs = getTabs();
		BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
			public void run() {
				for (int i = 0; i < tabs.length; i++) {
					tabs[i].initializeFrom(config);
				}
			}
		});
	}
	
    protected final ITransformationMaker TRANSFORMATION_MAKER = new ITransformationMaker() {
		public QvtTransformation makeTransformation(String name) throws MdaException {
			QvtModule qvtModule = TransformationUtil.getQvtModule(EmfUtil.makeUri(name));
            return new QvtInterpretedTransformation(qvtModule);
		}
    };
    
    private final ResourceSet myValidationRS;
}
