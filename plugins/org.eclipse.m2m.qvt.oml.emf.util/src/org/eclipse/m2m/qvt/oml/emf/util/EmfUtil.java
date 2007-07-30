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
package org.eclipse.m2m.qvt.oml.emf.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.IMetamodelDesc;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.osgi.util.NLS;


/**
 * @author pkobiakov
 */
@SuppressWarnings("unchecked")
public class EmfUtil {
    private EmfUtil() {}
        
    public static EObject loadModel(URI uri) {
    	return loadModel(uri, getDefaultLoadOptions());
    }
    
    public static EObject loadModel(URI uri, ResourceSet rs) {
    	return loadModel(uri, getDefaultLoadOptions(), rs);
    }    
    
    public static EObject loadModel(URI uri, Map options) {
    	return loadModel(uri, options, null);
    }
    
    public static EObject loadModel(URI uri, Map options, ResourceSet rs) {
        if(uri == null) {
            return null;
        }
        ResourceSet resourceSet = (rs != null) ? rs : createResourceSet(options);
        String fragment = uri.fragment();
        if (fragment != null && fragment.length() > 0) {
            return resourceSet.getEObject(uri, true);
        }
        Resource resource = resourceSet.getResource(uri.trimFragment(), true);
        if (resource == null || resource.getContents().isEmpty()) {
        	return null;
        }
		return (EObject) resource.getContents().get(0);
    }
    
    public static EObject getEObject(Resource res, URI uri) {
		String fragment = uri.fragment();
        if(fragment != null && fragment.length() > 0) {
            return res.getEObject(fragment);
        }
        else {
            List contents = res.getContents();
            if(contents.isEmpty()) {
                return null;
            }
            else {
                return (EObject)contents.get(0);
            }
        }
    }
    
    public static EObject safeLoadModel(URI uri) {
    	return safeLoadModel(uri, getDefaultLoadOptions());
    }
    
    public static EObject safeLoadModel(URI uri, Map options) {
        try {
            return loadModel(uri, options);
        }
        catch(Exception e){
            return null;
        }
    }
    
    public static Resource loadResource(URI uri) {
    	return loadResource(uri, getDefaultLoadOptions());
    }
    
    public static Resource loadResource(URI uri, Map options) {
        return createResourceSet(options).getResource(uri, true);
    }

	private static ResourceSet createResourceSet(Map options) {
		ResourceSet resourceSet = new ResourceSetImpl() {
			
			@Override
			protected Resource delegatedGetResource(URI uri, boolean loadOnDemand) {
				Resource resource = super.delegatedGetResource(uri, loadOnDemand);
				if (resource == null) {
					URI trimmedURI = uri.trimFragment();
					try {
						IMetamodelDesc descriptor = MetamodelRegistry.getInstance().getMetamodelDesc(trimmedURI.toString());
						Object model = descriptor.getModels()[0];
						if (model instanceof EPackage) {
							EPackage ePackage = (EPackage) model;
							resource = ePackage.eResource();
							if (resource == null) {
								resource = new ResourceImpl(trimmedURI);
								resource.getContents().add(ePackage);
							}
						}
					} catch (EmfException e) {
						// ignore
					}
				}
				return resource;
			}
			
		};
        resourceSet.getLoadOptions().putAll(options);
		return resourceSet;
	}
    
	public static EObject resolveSource(EObject in, EClassifier inputType) {
        if (EmfUtil.isDynamic(in) && inputType.eResource().getResourceSet() != in.eResource().getResourceSet()) {
       		return inputType.eResource().getResourceSet().getEObject(EcoreUtil.getURI(in), true);
        }
        return in;
    }
	
	private static boolean isDynamic(EObject eObject) {
		return eObject instanceof EStructuralFeature.Internal.DynamicValueHolder;
	}
	
    @SuppressWarnings("unchecked")
	public static void saveModel(EObject eObject, URI uri, Map opts) throws EmfException {    
        ResourceSet resourceSet = new ResourceSetImpl();

        Resource resource = resourceSet.createResource(uri);
        resource.getContents().add(eObject);

        Map options = new HashMap(opts);
        options.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
        
        if(isDynamic(eObject)) {
        	options.put("SCHEMA_LOCATION", Boolean.TRUE);
        }
        
        try {
            resource.save(options);
        } catch (Exception e) {
            throw new EmfException(NLS.bind(Messages.EmfUtil_1, uri), e);
        }
    }
    
	public static void saveModel(Resource modelExtent, URI uri, Map opts) throws EmfException {    
        ResourceSet resourceSet = new ResourceSetImpl();

        Resource resource = resourceSet.createResource(uri);
        resource.getContents().addAll(modelExtent.getContents());

        Map options = new HashMap(opts);
        options.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
        
        for (EObject eObject : resource.getContents()) {
	        if(isDynamic(eObject)) {
	        	options.put("SCHEMA_LOCATION", Boolean.TRUE);
	        	break;
	        }
        }
        
        try {
            resource.save(options);
        } catch (Exception e) {
            throw new EmfException(NLS.bind(Messages.EmfUtil_1, uri), e);
        }
    }
    
    public static EPackage getRootPackage(EPackage pack) {
        EPackage parent = pack.getESuperPackage();
        if(parent == null) {
            return pack;
        }
        else {
            return getRootPackage(parent);
        }
    }
    
    public static String getFullName(EClassifier cls) {
        return getFullName(cls, "::"); //$NON-NLS-1$
    }

    public static String getFullName(EClassifier cls, String delim) {
    	if(cls.getEPackage() == null) {
    		return cls.getName();
    	}
        return getFullName(cls.getEPackage(), delim) + delim + cls.getName();
    }

    public static String getFullName(EPackage pack, String delim) {
        if(pack.getESuperPackage() != null) {
            return getFullName(pack.getESuperPackage(), delim) + delim + pack.getName();
        } else {
            return pack.getName();
        }
    }
    
    public static EClass getEClass(EPackage root, String[] fullName) throws EmfException {
        EClassifier classifier = getEClassifier(root, fullName);
        if(classifier instanceof EClass == false) {
            throw new EmfException(NLS.bind(Messages.EmfUtil_6, fullName[fullName.length-1]));
        }
        
        return (EClass)classifier;
     }

    public static EClassifier getEClassifier(EPackage root, String[] fullName) throws EmfException {
        if(fullName.length < 2) {
            throw new EmfException(NLS.bind(Messages.EmfUtil_2, Arrays.asList(fullName)));
        }
        
        String rootPackName = fullName[0];
        if(!rootPackName.equals(root.getName())) {
            throw new EmfException(NLS.bind(Messages.EmfUtil_3, rootPackName, root.getName()));
        }
        
        MAIN: 
        for(int i = 1; i < fullName.length-1; i++) {
            List subPackages = root.getESubpackages();
            for (Iterator it = subPackages.iterator(); it.hasNext();) {
                EPackage pack = (EPackage) it.next();
                if(fullName[i].equals(pack.getName())) {
                    root = pack;
                    continue MAIN;
                }
            }
            
            throw new EmfException(NLS.bind(Messages.EmfUtil_5, fullName[i]));
        }
        
        EClassifier classifier = root.getEClassifier(fullName[fullName.length-1]);
        return classifier;
    }
    
    public static URI makeUri(String uriString) {
        if(uriString == null || uriString.length() == 0) {
            return null;
        }
        
        URI uri = URI.createURI(uriString);
        if(uri == null) {
            return null;
        }
        
        return uri;
    }
    
    public static String getRootPackageUri(EClassifier cls) {
        String uri = cls == null ? null : getRootPackage(cls.getEPackage()).getNsURI();
        return uri;
    }
    
    public static boolean isAssignableFrom(EClassifier type, EClassifier from) {
    	if (type == from) {
    		return true;
    	}
    	if (false == from instanceof EClass) {
    		return false;
    	}
    	return ((EClass) from).getEAllSuperTypes().contains(type);
    }

    public static Map getDefaultLoadOptions() {
    	Map options = new HashMap();
    	// create new session to avoid problems with parallel filling of containments lists (#31662, etc.) 
    	return options;
    }
    
    public static String getFileNameForResult(String moduleName, EClass cls) {
        return moduleName + "." + getExtensionForResult(cls); //$NON-NLS-1$
    }
    
    public static String getExtensionForResult(final EClassifier cls) {
        if(cls == null) {
            return XMIResource.XMI_NS;
        }
        
        EPackage root = EmfUtil.getRootPackage(cls.getEPackage());
        return root.getName();
    }
    
    public static final Map DEFAULT_SAVE_OPTIONS = new HashMap();
    static {
    	DEFAULT_SAVE_OPTIONS.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
    }
}
