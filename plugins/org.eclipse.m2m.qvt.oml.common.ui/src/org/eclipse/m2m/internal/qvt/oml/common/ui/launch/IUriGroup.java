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
import org.eclipse.m2m.qvt.oml.common.ui.IModelParameterInfo;
import org.eclipse.swt.widgets.Shell;

/**
 * @author sboyko
 *
 */
public interface IUriGroup {
    String getText();
    void update(String uri, String baseName, String extension, Shell shell);

    public interface IModifyListener {
        void modified();
    }
    
    void addModifyListener(IModifyListener listener);
    void removeModifyListener(IModifyListener listener);
    
    public interface IValidator {
    	IStatus validate(IModelParameterInfo paramInfo);
    	void update(IModelParameterInfo paramInfo, Shell shell);
    }
    
    IValidator getValidator();
}
