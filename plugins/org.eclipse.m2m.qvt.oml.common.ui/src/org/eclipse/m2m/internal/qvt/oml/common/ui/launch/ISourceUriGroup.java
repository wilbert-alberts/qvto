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

import org.eclipse.swt.widgets.Shell;

public interface ISourceUriGroup {
    String getText();
    void update(String uri, Shell shell);

    public static interface IModifyListener {
        void modified();
    }
    
    void addModifyListener(IModifyListener listener);
    void removeModifyListener(IModifyListener listener);
}
