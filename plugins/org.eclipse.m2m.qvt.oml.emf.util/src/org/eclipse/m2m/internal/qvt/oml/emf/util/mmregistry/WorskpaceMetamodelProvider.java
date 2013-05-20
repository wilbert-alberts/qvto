/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - Bug 376274
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtilPlugin;
import org.eclipse.osgi.util.NLS;

public class WorskpaceMetamodelProvider implements IMetamodelProvider {

	private ResourceSet resSet;
	private List<IMetamodelDesc> metamodels;
	
	public WorskpaceMetamodelProvider(ResourceSet resolutionRSet) {
		if(resolutionRSet == null) {
			throw new IllegalArgumentException("Null resolution resource set"); //$NON-NLS-1$
		}
		
		this.resSet = resolutionRSet;
		this.metamodels = new ArrayList<IMetamodelDesc>();
	}
		
	public IMetamodelDesc addMetamodel(String metamodelID, URI metamodelResourceURI) {
		if(metamodelID == null) {
			throw new IllegalArgumentException("Null metamodel ID"); //$NON-NLS-1$			
		}
				
		if(metamodelResourceURI == null) {
			throw new IllegalArgumentException("Null metamodel resource URI"); //$NON-NLS-1$
		}
				
		EPackage.Descriptor ePackageDesc = new DescImpl(metamodelResourceURI, resSet);
		IMetamodelDesc desc = new EmfMetamodelDesc(ePackageDesc, metamodelID);
		metamodels.add(desc);
		return desc;
	}
		
	public IMetamodelDesc[] getMetamodels() {
		return metamodels.toArray(new IMetamodelDesc[metamodels.size()]);
	}

    public static List<IResource> collectWorkspaceMetamodels() {
    	final List<IResource> result = new ArrayList<IResource>();
    
    	try {
			ResourcesPlugin.getWorkspace().getRoot().accept(new IResourceProxyVisitor() {
				public boolean visit(IResourceProxy proxy) throws CoreException {
					if(proxy.getType() == IResource.FILE && proxy.getName().endsWith(".ecore")) { //$NON-NLS-1$
						result.add(proxy.requestResource());
					}
					return true;
				}
			}, IResource.NONE);
		} catch (CoreException e) {
			EmfUtilPlugin.log(e);
		}
		
		return result;
    }	
	
	/**
	 * Loads a metamodel from resource denoted by the given URI.
	 * 
	 * @throws RuntimeException if an EPackage instance can't be obtained from the given resource
	 * @throws IllegalArgumentException if <code>uriStr</code> is not a valid URI
	 */
	public static EPackage loadResourceMetamodel(String uriStr) {
		return new DescImpl(URI.createURI(uriStr), new ResourceSetImpl()).getEPackage();
	}
		
	private static class DescImpl implements EPackage.Descriptor {
		private final URI uri;
		private final ResourceSet rs;		
		
		public DescImpl(URI modelResourceUri, ResourceSet resSet) {
			assert modelResourceUri != null;
			assert resSet != null;
			
			uri = modelResourceUri;
			rs = resSet;
		}
		
		public EFactory getEFactory() {
			return getEPackage().getEFactoryInstance();
		}

		public EPackage getEPackage() {
			return loadPackage();
		}
		
		private EPackage loadPackage() {
			
			// bug 376274: support URI fragments that refer to nested packages
			
			EObject eObject = null;
			if (uri.hasFragment()) {
				eObject = rs.getEObject(uri, true);
			}
			if (eObject == null) {
				Resource res = rs.getResource(uri, true);
				if(!res.getContents().isEmpty()) {
									
					eObject = res.getContents().get(0);
				
				}
			}	
					
			if(eObject instanceof EPackage) {
				return (EPackage)eObject;
			}			
			throw new WrappedException(new RuntimeException(NLS.bind(Messages.WorskpaceMetamodelProvider_URINotReferringMetamodel, uri)));
		}
	}
}