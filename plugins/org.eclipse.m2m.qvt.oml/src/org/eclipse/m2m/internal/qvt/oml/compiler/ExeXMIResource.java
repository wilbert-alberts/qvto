/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.compiler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;

public class ExeXMIResource extends XMIResourceImpl implements Resource {

   public static class Factory implements Resource.Factory {
    	
    	public Factory() {
    		super();
    	}

		public Resource createResource(URI uri) {
			return new ExeXMIResource(uri);
		}
    }
	
	private class ExeXMIHelper extends XMIHelperImpl {

		ExeXMIHelper(XMLResource resource) {
			super(resource);
		}
					
		@Override
		public String getHREF(EObject obj) {
			Resource objResource = obj.eResource();
			if(objResource != null && this.resource != objResource) {
				URI savedURI = getPackage2HREFMap().get(objResource.getURI());
				if(savedURI != null) {
					URI href = savedURI.appendFragment(objResource.getURIFragment(obj));
					return href.toString();
				}
			}
			
			return super.getHREF(obj);
		}			
	}
		
	private Map<URI, URI> fPackage2HREF;
	
	public ExeXMIResource(URI uri) {
		super(uri);
		// init stlib -> register package
        QvtOperationalStdLibrary.INSTANCE.getStdLibModule();
		
	    setEncoding("UTF-8"); //$NON-NLS-1$

	    getDefaultSaveOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
	    getDefaultSaveOptions().put(XMLResource.OPTION_LINE_WIDTH, 80);
	    getDefaultSaveOptions().put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware());
	}
	
    @Override
    protected boolean useIDs()
    {
      return eObjectToIDMap != null || idToEObjectMap != null;
    }

    @Override
    protected XMLLoad createXMLLoad() {
//        	URI resourceURI = getURI();
//        	if(resourceURI.isPlatformResource()) {
//        		IFile file = URIUtils.getFile(resourceURI);
//        		if(file != null && file.exists()) {
//        			ResourceSet resSet = this.resourceSet == null ? new ResourceSetImpl() : this.resourceSet;
//        			Registry packageRegistry = MetamodelURIMappingHelper.mappingsToEPackageRegistry(file.getProject(), resSet);
//        			if(packageRegistry != null) {
//        				BinXMIHelper binXMIHelper = new BinXMIHelper();
//        				binXMIHelper.setPackageRegistry(new EPackageRegistryImpl(packageRegistry));
//        				return new XMILoadImpl(binXMIHelper);
//        			}
//        		}
//        	}

    	return super.createXMLLoad();
    }
	
	protected XMLHelper createXMLHelper() {
		return new ExeXMIHelper(this);
	}
	
	private Map<URI, URI> getPackage2HREFMap() {
		if(fPackage2HREF == null) {
			if(resourceSet != null && resourceSet.getPackageRegistry() != null) {
				Registry packageRegistry = resourceSet.getPackageRegistry();
				for (Map.Entry<String, Object> entry : packageRegistry.entrySet()) {
					Object value = entry.getValue();
					if(value instanceof EPackage) {
						EPackage ePackage = (EPackage) value;
						String nsURI = ePackage.getNsURI();    						
						Resource ePackageResource = ePackage.eResource();
						// be defensive, anyone can put anything into the package registry
						if(nsURI != null && ePackageResource != null) {								
							URI packageResourceURI = ePackageResource.getURI();								
							if(packageResourceURI != null && 
								(packageResourceURI.isPlatform() || packageResourceURI.isFile()) ) {
								if(fPackage2HREF == null) {
									fPackage2HREF = new HashMap<URI, URI>();
								}
							
								URI registeredURI = URI.createURI(nsURI, false);
								fPackage2HREF.put(packageResourceURI, registeredURI);
							}
						}
					}
				}
			}
		}

		if(fPackage2HREF == null) {
			// mark as already initialized
			fPackage2HREF = Collections.emptyMap();
		}

		return fPackage2HREF;
	}
}