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
package org.eclipse.m2m.internal.qvt.oml.ast.env;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerKernel;

public class QvtOperationalFileEnv extends QvtOperationalModuleEnv {

    private final QvtCompilerKernel myKernel;
	private final URI myFile;    
	
	protected QvtOperationalFileEnv(final URI file, final QvtCompilerKernel kernel) {
		super(new EPackageRegistryImpl(), null);

		myFile = file;
        myKernel = kernel;
        
    	QvtOperationalStdLibrary.INSTANCE.importTo(this);        
	}
		
    public QvtCompilerKernel getKernel() {
        return myKernel;
    }
	
	public URI getFile() {
        return myFile;
    }
	    	    
    @Override
    public String toString() {    
    	return  "QVTOEnv:" + myFile.toString(); //$NON-NLS-1$
    }
    
}
