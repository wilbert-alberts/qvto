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

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.FileTransformationMaker;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.ITransformationMaker;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtProjectTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;


/** @author pkobiakov */
public class NonInterpretedQvtLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
        ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
                new QvtLauncherTab(TRANSFORMATION_MAKER),
                new QvtTransformationConfigurationTab(TRANSFORMATION_MAKER),
                new CommonTab()
			};
		
		setTabs(tabs);
	}
	
	private final ITransformationMaker TRANSFORMATION_MAKER = new FileTransformationMaker() {
        @Override
        protected QvtTransformation doCreateTransformation(IFile qvtFile) {
            return new QvtProjectTransformation(qvtFile);
        }
	};
}
