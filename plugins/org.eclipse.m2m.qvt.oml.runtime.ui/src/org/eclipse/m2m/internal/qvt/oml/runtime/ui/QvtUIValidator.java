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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ISetMessage;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.ISourceUriGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.ITargetUriGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.OptionalFileGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TargetUriGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TransformationControls;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtValidator;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.swt.widgets.Shell;

public class QvtUIValidator {
    private QvtUIValidator() {}
    
    public static boolean validateTransformation(ISetMessage tab, QvtTransformation transformation, ISourceUriGroup sourceModelUri, TargetUriGroup targetModelUri, OptionalFileGroup traceFile, Shell shell) {
        IStatus status = QvtValidator.validateTransformation(transformation, sourceModelUri.getText(), targetModelUri.getData(), traceFile.getText(), traceFile.getUseFileFlag());
        boolean isValid = TransformationControls.statusToTab(status, tab);
        updateControls(transformation, sourceModelUri, targetModelUri, traceFile, shell);
        return isValid;
    }
    
    public static void updateControls(QvtTransformation transformation, ISourceUriGroup sourceModelUri, ITargetUriGroup targetModelUri, OptionalFileGroup traceFile, Shell shell) {
        EClass inCls = null;
        EClass outCls = null;
        try {
            inCls = transformation.getIn();
            outCls = transformation.getOut();
        }            
        catch(Exception e) {
        }
        
        sourceModelUri.update(EmfUtil.getRootPackageUri(inCls), shell);
       
        String baseName;
        try {
        	baseName = transformation.getModuleName();
        }
        catch(MdaException e) {
        	baseName = ""; //$NON-NLS-1$
        }
        String extension = NameUtil.getExtensionForResult(outCls);
        targetModelUri.update(EmfUtil.getRootPackageUri(outCls), baseName, extension, shell);
        
        traceFile.update(baseName, "trace"); //$NON-NLS-1$
    }
}
