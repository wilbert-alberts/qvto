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
package org.eclipse.m2m.qvt.oml.generator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.compiler.CompiledModule;


/**
 * @author pfeldman
 */
public class QvtGeneratorUtil {
    public static String getClassName(final String mappingModuleName) {
        return mappingModuleName + GeneratorConstants.CLASS_NAME_SUFFIX;
    }
	
    public static String getModuleName(String className) {
        int pos = className.lastIndexOf(GeneratorConstants.CLASS_NAME_SUFFIX);
		if(pos != -1) {
			return className.substring(0, pos);
		}
		else {
			throw new IllegalArgumentException("Not a valid name for a module class (missing suffix): " + className); //$NON-NLS-1$
		}
    }

    public static String getInterfaceName(final String mappingModuleName) {
        return getClassName(mappingModuleName) + GeneratorConstants.INTERFACE_NAME_SUFFIX;
    }
    
    public static String getImplementationName(final String mappingModuleName) {
        return getClassName(mappingModuleName) + GeneratorConstants.IMPLEMENTATION_NAME_SUFFIX;
    }
    
    public static String getMetainfoName(final String mappingModuleName) {
        return getClassName(mappingModuleName) + GeneratorConstants.METAINFO_NAME_SUFFIX;
    }
    
	public static String getClassName(final CompiledModule module) {
	    return getClassName(module.getModule().getName());
	}
    
    public static String getQualifiedClassName(final CompiledModule module) {
        String packageName = QvtUtil.getPackageName(module);
        return QvtUtil.getQualifiedName(packageName, getClassName(module));
    }
    
	public static List<String> getMatchingJavaFileNames(final IResource resource) throws CoreException {
	    final List<String> result = new ArrayList<String>();
	    
	    resource.accept(new IResourceVisitor() {
	        public boolean visit(final IResource resource) throws CoreException {
	            if (resource instanceof IFile && MDAConstants.QVTO_FILE_EXTENSION.equals(resource.getFileExtension())) {
	                String name = resource.getName();
	                name = name.substring(0, name.length() - MDAConstants.QVTO_FILE_EXTENSION.length() - 1);
	                result.add(getClassName(name) + ".java");//$NON-NLS-1$
	            }
	            return true;
	        }
	    });
	    
	    return result;
	}

}
