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
package org.eclipse.m2m.internal.qvt.oml.runtime.project;


import org.eclipse.core.resources.IFile;
import org.eclipse.m2m.internal.qvt.oml.QvtEngine;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.qvt.oml.common.MdaException;

public class WorkspaceQvtModule extends QvtModule {
    
	public WorkspaceQvtModule(IFile transformationFile) {
        myTransformationFile = transformationFile;
        myModule = null;
        myCompiler = null;
    }
	
	@Override
	public String toString() {
        return myTransformationFile.getFullPath().toString();
    }
    
    @Override
	public CompiledModule getModule() throws MdaException {
        if(myModule == null) {
            QvtEngine engine = QvtEngine.getInstance(myTransformationFile); 
            CompiledModule module = engine.compile(myTransformationFile, null, getQvtCompilerOptions());
            
            checkModuleErrors(module);
            
            myModule = module;
            myCompiler = engine.getCompiler();
        }
        
        return myModule;
    }
    
	@Override
	public QvtCompiler getCompiler() throws MdaException {
		getModule();
		return myCompiler;
	}
    
    private final IFile myTransformationFile;
    private CompiledModule myModule;
    private QvtCompiler myCompiler;
}
