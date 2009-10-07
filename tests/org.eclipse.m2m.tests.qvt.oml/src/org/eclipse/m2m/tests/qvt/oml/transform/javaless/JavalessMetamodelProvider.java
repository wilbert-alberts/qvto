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
package org.eclipse.m2m.tests.qvt.oml.transform.javaless;

import java.io.IOException;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.EmfMetamodelDesc;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelDesc;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelProvider;
import org.eclipse.m2m.tests.qvt.oml.TestProject;


public class JavalessMetamodelProvider implements IMetamodelProvider {
	public IMetamodelDesc[] getMetamodels() {
		EPackage metamodel = registerMetamodel();
		return new IMetamodelDesc[] {
			new EmfMetamodelDesc(metamodel, metamodel.getNsURI()),
		};
	}
	
	
	public static EPackage registerMetamodel() {
		EPackage pack = EPackage.Registry.INSTANCE.getEPackage(JAVALESS_METAMODEL_ID);
		if(pack == null) {
			pack = loadJavalessMetamodel();
			//EPackage.Registry.INSTANCE.put(pack.getNsURI(), pack);
		}
		
		return pack;
	}
	
    public static EPackage loadJavalessMetamodel() {
		Path javalessPath;
		try {
			javalessPath = TestProject.findFileInPlugin("org.eclipse.m2m.tests.qvt.oml", "models/javaless.ecore"); //$NON-NLS-1$//$NON-NLS-2$
		} 
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return loadMetamodel(javalessPath.toOSString());
    }

    private static EPackage loadMetamodel(String fname) {
    	URI uri = URI.createFileURI(fname);
    	ResourceSet resourceSet = new ResourceSetImpl();
    	Resource resource = resourceSet.getResource(uri, true);
    	if(resource == null ||  resource.getContents().isEmpty()) {
    		throw new IllegalArgumentException("Invalid model " + fname); //$NON-NLS-1$
    	}
    	EObject model = (EObject) resource.getContents().get(0);
    	if(model instanceof EPackage == false) {
    		throw new IllegalArgumentException("Invalid model " + fname); //$NON-NLS-1$
    	}
    	
    	EPackage pack = (EPackage)model;
    	return pack;
    }
    
    public static final String JAVALESS_METAMODEL_ID = "http://www.example.com/javaless/2006";  //$NON-NLS-1$
}
