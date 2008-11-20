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

import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerKernel;

public class QvtOperationalFileEnv extends QvtOperationalModuleEnv {

	/**
	 * Name mangling of <code>this</code> variables by name of module types 
	 * is not longer used, <code>this</code> variable is directly defined instead in each module 
	 * environment 
	 */
	@Deprecated
    public static final String THIS_VAR_QNAME_SUFFIX = "." + THIS; //$NON-NLS-1$
	
    private final QvtCompilerKernel myKernel;
	private final CFile myFile;    
	
	protected QvtOperationalFileEnv(final CFile file, final QvtCompilerKernel kernel) {
		super(new EPackageRegistryImpl());

		myFile = file;
        myKernel = kernel;
        
    	QvtOperationalStdLibrary.INSTANCE.importTo(this);        
	}
		
    public QvtCompilerKernel getKernel() {
        return myKernel;
    }
	
	public CFile getFile() {
        return myFile;
    }

    public String getUnitName() {
        return myFile.getUnitName();
	}
	    	    
    @Override
    public String toString() {    
    	return  "Env:" + myFile.getFullPath(); //$NON-NLS-1$
    }
    
}
