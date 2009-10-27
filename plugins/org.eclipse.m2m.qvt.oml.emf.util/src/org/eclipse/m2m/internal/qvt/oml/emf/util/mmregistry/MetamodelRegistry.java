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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtilPlugin;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.osgi.util.NLS;


/** @author pkobiakov */
public class MetamodelRegistry {

    public static final String MM_POINT_ID = "metamodelProvider"; //$NON-NLS-1$
    
    private static final MetamodelRegistry ourInstance = new MetamodelRegistry();
	
    private List<? extends IMetamodelProvider> myMetamodelProviders;	
	private final Map<String, IMetamodelDesc> myMetamodelDescs;
	
	private MetamodelRegistry() {
		myMetamodelProviders = getMetamodelProviders();
		if(!myMetamodelProviders.isEmpty()) {
			myMetamodelProviders = Collections.singletonList(new EmfStandaloneMetamodelProvider(EPackage.Registry.INSTANCE));    				
		} 
		
		myMetamodelDescs = getMetamodelDescs(myMetamodelProviders);		
    }
	
	public MetamodelRegistry(IMetamodelProvider metamodelProvider) {
		myMetamodelProviders = Collections.singletonList(metamodelProvider);
		
		myMetamodelDescs = new HashMap<String, IMetamodelDesc>(ourInstance.myMetamodelDescs);
		myMetamodelDescs.putAll(getMetamodelDescs(Collections.singletonList(metamodelProvider)));
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

//    public static final IMetamodelDesc createUndeclaredMetamodel(String id, ResourceSet rs) throws EmfException {
//        URI uri = URI.createURI(id);  
//        return createUndeclaredMetamodel(uri, id, rs);
//    }
	
//    public static final IMetamodelDesc createUndeclaredMetamodel(URI uri, String id, ResourceSet rs) throws EmfException {
//        try {
//        	int initialResourceCount = rs.getResources().size();
//            Resource resource = rs.getResource(uri, true);
//            if (resource != null) {
//                EObject metamodel = resource.getContents().get(0);
//                if (metamodel instanceof EPackage) {
//                    return new EmfMetamodelDesc((EPackage) metamodel, id);
////                      TODO: registration in the map must be done
////                      in case the changes of resource are listened out for  
////                        myMetamodelDescs.put(id, desc);
//                }
//                for (int i = rs.getResources().size()-1; i >= initialResourceCount; --i) {
//                	Resource loadedResource = rs.getResources().get(i);
//                	loadedResource.unload();
//                	//rs.getResources().remove(i);
//                }
//            }
//        } catch (Exception e) {
//            throw new EmfException(e);
//        }
//        return null;
//    }

    public IMetamodelDesc[] getMetamodelDesc(List<String> packageName) throws EmfException {
		final List<EPackage> metamodels = new UniqueEList<EPackage>(1);
		
        for (IMetamodelDesc d: myMetamodelDescs.values()) {
        	EPackage pack = d.getModel();
        	if (pack == null || pack.getESuperPackage() != null) {
        		continue;
        	}
        	EPackage lookupPackage = lookupPackage(pack, packageName);
        	if (lookupPackage != null) {
        		metamodels.add(lookupPackage);
        	}
        }
        
        if (metamodels.isEmpty()) {
        	throw new EmfException(NLS.bind(Messages.MetamodelRegistry_0,
        			packageName, myMetamodelDescs.values()));
        }
        
        IMetamodelDesc[] result = new IMetamodelDesc[metamodels.size()];
        int pos = 0;
        for (final EPackage nextMetamodel : metamodels) {
        	result[pos++] = new IMetamodelDesc() {

			public String getId() {
				return nextMetamodel.getNsURI();
			}

			public IStatus getLoadStatus() {
				return Status.OK_STATUS;
			}

			public EPackage getModel() {
				return nextMetamodel;
			}

			public boolean isLoaded() {
				return true;
			}
        	
        };
        }
        
        return result;
	}
	
	public static EPackage lookupPackage(EPackage rootPackage, List<String> path) {
		EPackage.Registry registry = new EPackageRegistryImpl();
		registry.put(rootPackage.getNsURI(), rootPackage);
		
		return EcoreEnvironment.findPackage(path, registry);
	}	

	private static List<IMetamodelProvider> getMetamodelProviders() {
		List<IMetamodelProvider> metamodelProviders = new ArrayList<IMetamodelProvider>();
		if(EMFPlugin.IS_ECLIPSE_RUNNING) {
			IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(EmfUtilPlugin.getDefault().getBundle().getSymbolicName(), MM_POINT_ID);
			
			for (int i = 0; i < extensions.length; i++) {
				IConfigurationElement extension = extensions[i];
				try {
					Object provider = extension.createExecutableExtension("class"); //$NON-NLS-1$
					if(provider instanceof IMetamodelProvider) {
						metamodelProviders.add((IMetamodelProvider)provider);
					}
				}
				catch(Exception e) {
					Logger.getLogger().log(Logger.WARNING, "Failed to instantiate " + extension.getAttribute("class") +  //$NON-NLS-1$ //$NON-NLS-2$
							" from " + extension.getNamespaceIdentifier(), e); //$NON-NLS-1$
				}
			}
		}
		
		return metamodelProviders;
	}
	
	private static Map<String, IMetamodelDesc> getMetamodelDescs(List<? extends IMetamodelProvider> providers) {
		Map<String, IMetamodelDesc> metamodelDescs = new HashMap<String, IMetamodelDesc>();		
		
        for(IMetamodelProvider provider: providers) {
        	IMetamodelDesc[] models;
        	try {
	        	models = provider.getMetamodels();
        	}
        	catch(Exception e) {
        		Logger.getLogger().log(Logger.SEVERE, "Failed to get metamodels from " + provider, e); //$NON-NLS-1$
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

}
