/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation and others.
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

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtCompiledTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtRuntimePluginImages;
import org.eclipse.swt.graphics.Image;


public class QvtCompiledTransformationLabelProvider extends LabelProvider {
    @Override
	public Image getImage(Object element) {
        if(element instanceof QvtCompiledTransformation) {
            return QvtRuntimePluginImages.getInstance().getImage(QvtRuntimePluginImages.QVT_COMPILED_TRANSFORMATION);
        }
        
        return super.getImage(element);
    }
}
