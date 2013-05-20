/*******************************************************************************
 * Copyright (c) 2007, 2012 Borland Software Corporation and others.
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtilPlugin;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.osgi.util.NLS;


/** @author pkobiakov */
public class MetamodelRegistry {

    private static class Desc implements EPackage.Descriptor {
    	private final IMetamodelDesc fDesc;
    	
    	public Desc(IMetamodelDesc desc) {			
			this.fDesc = desc;
		}
    	
		public EFactory getEFactory() {
			return fDesc.getModel().getEFactoryInstance();
		}

		public EPackage getEPackage() {
			return fDesc.getModel();
		}
    }
	
	
    public static final String MM_POINT_ID = "metamodelProvider"; //$NON-NLS-1$
    
    private static final MetamodelRegistry ourInstance = new MetamodelRegistry();
	
	private final Map<String, IMetamodelDesc> myMetamodelDescs;
	
	
	private MetamodelRegistry() {
		List<IMetamodelProvider> providers = new ArrayList<IMetamodelProvider>();
		providers.add(new EmfStandaloneMetamodelProvider(EPackage.Registry.INSTANCE));
		
		if(EMFPlugin.IS_ECLIPSE_RUNNING) {
			providers.addAll(Eclipse.getMetamodelProviders());
		}

		myMetamodelDescs = getMetamodelDescs(providers);		
    }
	
	public MetamodelRegistry(IMetamodelProvider metamodelProvider) {
		myMetamodelDescs = new HashMap<String, IMetamodelDesc>(ourInstance.myMetamodelDescs);
		myMetamodelDescs.putAll(getMetamodelDescs(Collections.singletonList(metamodelProvider)));
	}
	
    public EPackage.Registry toEPackageRegistry() {
    	EPackage.Registry packageRegistry = new EPackageRegistryImpl();
		for(String nsURI : getMetamodelIds()) {
			try {
				IMetamodelDesc metamodelDesc = getMetamodelDesc(nsURI);
				if(metamodelDesc.getLoadStatus().getSeverity() < IStatus.ERROR) {
					packageRegistry.put(nsURI, new Desc(metamodelDesc));
	        	}				
			} catch (EmfException e) {
				// FIXME stupid but normal ;)
			}
		}

    	return packageRegistry;
    }
	
    
    public static MetamodelRegistry getInstance() {
        return ourInstance;
    }
    
    public void merge(MetamodelRegistry mergedRegistry) {
    	for(String id : mergedRegistry.myMetamodelDescs.keySet()) {
    		if(!this.myMetamodelDescs.containsKey(id)) {
    			this.myMetamodelDescs.put(id, mergedRegistry.myMetamodelDescs.get(id));
    		}
    	}
    }
    
	public String[] getMetamodelIds() {
		List<String> ids = new ArrayList<String>(myMetamodelDescs.size());
		ids.addAll(myMetamodelDescs.keySet());
		return ids.toArray(new String[ids.size()]);
	}

	public static EPackage tryLookupEmptyRootPackage(String nsURI, EPackage.Registry registry) {
		URI rootURI = URI.createURI(nsURI);
		if(rootURI.segmentCount() == 0) {
			return null;
		}
		
		String base = rootURI.segment(0);
		String commonBaseURI = rootURI.trimSegments(rootURI.segmentCount()).appendSegment(base).toString();
		
		LinkedList<String> candidates = new LinkedList<String>();
		for (String nextURI : registry.keySet()) {
			if(nextURI.startsWith(commonBaseURI)) {
				candidates.add(nextURI);
			}
		}
				
		// first attemp to select few packages which are likely
		// to be child packages to avoid initialization of all packages
		// in the registry
        for(String nextNsURI : candidates) {
        	EPackage pack = registry.getEPackage(nextNsURI);

        	while (pack.getESuperPackage() != null) {
    			pack = pack.getESuperPackage();
    		}
        	
        	if (nsURI.equals(pack.getNsURI())) {
        		return pack;
        	}
        }
        // check all packages in the registry
        for(String nextNsURI : registry.keySet()) {
        	EPackage pack = registry.getEPackage(nextNsURI);

        	while (pack.getESuperPackage() != null) {
    			pack = pack.getESuperPackage();
    		}
        	
        	if (nsURI.equals(pack.getNsURI())) {
        		return pack;
        	}
        }
        
		
		return null;
	}
	
	public IMetamodelDesc getMetamodelDesc(String id) throws EmfException {
		IMetamodelDesc desc = myMetamodelDescs.get(id);

		// FIXME - hack for #35157 
		if(desc == null && id != null) {
            for(IMetamodelDesc d: myMetamodelDescs.values()) {
            	EPackage pack = d.getModel();
            	if (pack == null) {
            		continue;
            	}
            	if (id.equals(pack.getNsURI())) {
            		desc = d;
            		break;
            	}
        		while (pack.getESuperPackage() != null) {
        			pack = pack.getESuperPackage();
        		}
            	if (id.equals(pack.getNsURI())) {
            		desc = new EmfMetamodelDesc(pack, pack.getNsURI());
            		myMetamodelDescs.put(id, desc);
            		break;
            	}
            }
        }
        				
//        if (desc == null && id != null) {
//            // Unregistered platform metamodels, e.g. available via "platform:/resource" or "platform:/plugin"
//            URI uri = URI.createURI(id);
//            if (uri.isPlatform()) {
//                desc = MetamodelRegistry.createUndeclaredMetamodel(uri, id, resolutionRS != null ? resolutionRS : new ResourceSetImpl());
//            }
//        }
        
        if (desc == null) {
        	throw new EmfException(NLS.bind(Messages.MetamodelRegistry_0, id, myMetamodelDescs.values()));
        }
        
        return desc;
	}

    public static List<EPackage> resolveMetamodels(EPackage.Registry registry, List<String> packageName) throws EmfException {
		final List<EPackage> metamodels = new UniqueEList<EPackage>(1);
		
        for (String nsURI: registry.keySet()) {
        	EPackage pack = registry.getEPackage(nsURI);
        	if (pack == null || pack.getESuperPackage() != null) {
        		continue;
        	}
        	EPackage lookupPackage = lookupPackage(pack, packageName);
        	if (lookupPackage != null) {
        		metamodels.add(lookupPackage);
        	}
        }
                
        return metamodels;
	}	
	
	public static EPackage lookupPackage(EPackage rootPackage, List<String> path) {
		EPackage.Registry registry = new EPackageRegistryImpl();
		registry.put(rootPackage.getNsURI(), rootPackage);
		
		return EcoreEnvironment.findPackage(path, registry);
	}	
	
	private static Map<String, IMetamodelDesc> getMetamodelDescs(List<? extends IMetamodelProvider> providers) {
		Map<String, IMetamodelDesc> metamodelDescs = new HashMap<String, IMetamodelDesc>();		
		
        for(IMetamodelProvider provider: providers) {
        	IMetamodelDesc[] models;
        	try {
	        	models = provider.getMetamodels();
        	}
        	catch(Throwable e) { // should be more generic here as since for example NoSuchMethodError isn't an Exception
        		//Logger.getLogger().log(Logger.SEVERE, "Failed to get metamodels from " + provider, e); //$NON-NLS-1$
        		continue;
        	}
        	
	        for(int i = 0; i < models.length; i++) {
	        	if (models[i].getId() != null) {
	        		metamodelDescs.put(models[i].getId(), models[i]);
	        	}
	        }
        }
		
		return metamodelDescs;
	}	

	private static class Eclipse {
		
		private static List<IMetamodelProvider> getMetamodelProviders() {
			List<IMetamodelProvider> metamodelProviders = new ArrayList<IMetamodelProvider>();

				IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(EmfUtilPlugin.getDefault().getBundle().getSymbolicName(), MM_POINT_ID);
				
				for (int i = 0; i < extensions.length; i++) {
					IConfigurationElement extension = extensions[i];
					try {
						Object provider = extension.createExecutableExtension("class"); //$NON-NLS-1$
						if(provider instanceof IMetamodelProvider) {
							metamodelProviders.add((IMetamodelProvider)provider);
						}
					}
					catch(CoreException e) {
						EmfUtilPlugin.getDefault().getLog().log(e.getStatus());
					}					
					catch(Exception e) {
						EmfUtilPlugin.log(e);
					}
				}

			
			return metamodelProviders;
		}		
	}
}
