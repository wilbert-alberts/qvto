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
package org.eclipse.m2m.qvt.oml.editor.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.m2m.qvt.oml.compiler.CompiledModule;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;


public class QvtDocumentProvider extends TextFileDocumentProvider {
	
    public void setMappingModule(final CompiledModule compiledModule) {
        myCompiledModule = compiledModule;
    }
    
    public CompiledModule getCompiledModule() {
        return myCompiledModule;
    }

    @Override
	protected IAnnotationModel createAnnotationModel(IFile file) {
    	return new ResourceMarkerAnnotationModel(file);
    }
    
    private CompiledModule myCompiledModule;
}