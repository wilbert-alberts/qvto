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
package org.eclipse.m2m.internal.qvt.oml.runtime.ant;

import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;


/**
 * @author abreslav
 *
 *  Applies the given interpreted transformation 
 */
public class ApplyInterpretedTransformationTask extends AbstractApplyTransformationTask {
    
    @Override
	protected QvtTransformation getTransformationObject() {
        return new QvtInterpretedTransformation(resolveFile(getTransformation()));
    }
}
