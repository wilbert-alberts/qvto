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
package org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtilPlugin;
import org.eclipse.osgi.util.NLS;


/**
 * @author strizhkin
 */
public class EmfMetamodelDesc implements IMetamodelDesc {
	
    private final String myNsURI;
    
    private final EPackage.Descriptor myPackageDescriptor;
    
    private EPackage myPackage;
    
    private IStatus status = Status.OK_STATUS;
	
	
	public EmfMetamodelDesc(EPackage.Descriptor packageDescriptor, String nsURI) {
		if (packageDescriptor == null) {
			throw new IllegalArgumentException();
		}
		myPackageDescriptor = packageDescriptor;
		myNsURI = nsURI;
	}
	
	public EmfMetamodelDesc(EPackage pack, String nsURI) {
		if (pack == null) {
			throw new IllegalArgumentException();
		}
		myPackageDescriptor = null;
		myPackage = pack;
		myNsURI = nsURI;
	}
	
	public String getId() {
		return myNsURI;
	}
	
    public EPackage getModel() {
    	if (myPackage == null) {
    		try {
    			myPackage = myPackageDescriptor.getEPackage();
    		}
    		catch (Throwable ex) {
    			String errMessage = NLS.bind(Messages.MetamodelRegistry_LoadError, getId(), ex.getClass().getName());    			
    			this.status = new Status(IStatus.ERROR, EmfUtilPlugin.ID, errMessage, ex);
    			EmfUtilPlugin.getDefault().getLog().log(status);
    			
    			// create empty package representation
    			myPackage = EcoreFactory.eINSTANCE.createEPackage();
    			myPackage.setNsURI(getId());
    			myPackage.setName(""); //$NON-NLS-1$
    			// confine in a resource
    			new XMIResourceImpl(URI.createURI("http://unresolvedEPackage")).getContents().add(myPackage); //$NON-NLS-1$
    		}
    	}
        return myPackage;
    }
    
    public IStatus getLoadStatus() {
    	if(myPackage == null) {
    		// cause metamodel packages to load
    		getModel();
    	}
		return status;
	}
    
    public boolean isLoaded() {
    	return myPackage != null;
	}
    
    @Override
	public String toString() {
    	return getId();
    }    
}
