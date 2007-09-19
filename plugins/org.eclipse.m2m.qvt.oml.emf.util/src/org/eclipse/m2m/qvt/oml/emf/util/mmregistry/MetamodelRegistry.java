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
package org.eclipse.m2m.qvt.oml.emf.util.mmregistry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtilPlugin;
import org.eclipse.m2m.qvt.oml.emf.util.Logger;
import org.eclipse.osgi.util.NLS;


/** @author pkobiakov */
public class MetamodelRegistry {

    public static final String MM_POINT_ID = "metamodelProvider"; //$NON-NLS-1$
    
    private static final MetamodelRegistry ourInstance = new MetamodelRegistry();
	
    private List<IMetamodelProvider> myMetamodelProviders;	
	private final Map<String, IMetamodelDesc> myMetamodelDescs;
	
	private MetamodelRegistry() {
		myMetamodelProviders = getMetamodelProviders();
		if(myMetamodelProviders.isEmpty()) {
    		Logger.getLogger().log(Logger.SEVERE, "No metamodel provider extensions, point=" + EmfUtilPlugin.ID + "." + MM_POINT_ID); //$NON-NLS-1$			
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
    
	public String[] getMetamodelIds() {
		List<String> ids = new ArrayList<String>(myMetamodelDescs.size());
		ids.addAll(myMetamodelDescs.keySet());
		return ids.toArray(new String[ids.size()]);
	}
	
	public IMetamodelDesc getMetamodelDesc(String id) throws EmfException {
		IMetamodelDesc desc = myMetamodelDescs.get(id);

		// hack for #35157 
		if(desc == null && id != null) {
            for(IMetamodelDesc d: myMetamodelDescs.values()) {
            	EPackage pack = (EPackage) d.getModels()[0];
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
            		desc = new EmfMetamodelDesc(pack, pack.getNsURI(), d.getNamespace());
            		myMetamodelDescs.put(id, desc);
            		break;
            	}
            }
        }
        
        if (desc == null) {
        	throw new EmfException(NLS.bind(Messages.MetamodelRegistry_0, id, myMetamodelDescs.values()));
        }
        
        return desc;
	}
	
	public IMetamodelDesc getMetamodelDesc(List<String> packageName) throws EmfException {
		final List<EPackage> metamodels = new UniqueEList<EPackage>(1);
		
        for (IMetamodelDesc d: myMetamodelDescs.values()) {
        	EPackage pack = (EPackage) d.getModels()[0];
        	if (pack.getESuperPackage() != null) {
        		continue;
        	}
        	EPackage lookupPackage = EmfMmUtil.lookupPackage(pack, packageName);
        	if (lookupPackage != null) {
        		metamodels.add(lookupPackage);
        	}
        }
        
        if (metamodels.isEmpty()) {
        	throw new EmfException(NLS.bind(Messages.MetamodelRegistry_0,
        			packageName, myMetamodelDescs.values()));
        }
        
        return new IMetamodelDesc() {

			public String getId() {
				return null;
			}

			public IStatus getLoadStatus() {
				return null;
			}

			public Object[] getModels() {
				return metamodels.toArray(new EPackage[metamodels.size()]);
			}

			public String getNamespace() {
				return null;
			}

			public boolean isLoaded() {
				return true;
			}
        	
        };
	}
	
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
			catch(Exception e) {
				Logger.getLogger().log(Logger.WARNING, "Failed to instantiate " + extension.getAttribute("class") +  //$NON-NLS-1$ //$NON-NLS-2$
						" from " + extension.getNamespaceIdentifier(), e); //$NON-NLS-1$
			}
		}
		
		return metamodelProviders;
	}
	
	private static Map<String, IMetamodelDesc> getMetamodelDescs(List<IMetamodelProvider> providers) {
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
	            metamodelDescs.put(models[i].getId(), models[i]);
	        }
        }
		
		return metamodelDescs;
	}
}
