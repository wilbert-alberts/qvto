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
package org.eclipse.m2m.internal.qvt.oml.emf.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.impl.NotificationChainImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelDesc;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam.ModelparamFactory;
import org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam.ResourceEObject;
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
        if (resource.getContents().size() == 1) {
        	return resource.getContents().get(0);
        }
        ResourceEObject resourceEObj = ModelparamFactory.eINSTANCE.createResourceEObject();
        ((InternalEObject) resourceEObj).eSetResource((Resource.Internal) resource, new NotificationChainImpl());
    	((InternalEObject) resourceEObj).eSetProxyURI(uri);
        resourceEObj.getChildren().addAll(resource.getContents());
		return resourceEObj;
    }
    
    public static EObject safeLoadModel(URI uri, ResourceSet rs) {
    	return safeLoadModel(uri, getDefaultLoadOptions(), rs);
    }
    
    public static EObject safeLoadModel(URI uri, Map options, ResourceSet rs) {
        try {
            return loadModel(uri, options, rs);
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
						EPackage ePackage = descriptor.getModel();
						resource = ePackage.eResource();
						if (resource == null) {
							resource = new ResourceImpl(trimmedURI);
							resource.getContents().add(ePackage);
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
    
	public static EObject resolveSource(ResourceEObject in, EObject inputType) {
		List<EObject> resolved = new ArrayList<EObject>(in.getChildren().size());
		for (EObject eObj : in.getChildren()) {
			resolved.add(resolveSource(eObj, inputType));
		}
		in.getChildren().clear();
		in.getChildren().addAll(resolved);
		return in;
    }

	public static EObject resolveSource(EObject in, EObject inputType) {
		if (in instanceof ResourceEObject) {
			return resolveSource((ResourceEObject) in, inputType);
		}
		
		if (inputType == null) {
			return in;
		}
        if (EmfUtil.isDynamic(in) 
        		&& inputType.eResource().getResourceSet() != in.eResource().getResourceSet()
        		&& inputType.eResource().getResourceSet() != null) {
       		return inputType.eResource().getResourceSet().getEObject(EcoreUtil.getURI(in), true);
        }
        return in;
    }
	
	public static boolean isUriExisted(String textUri, ResourceSet rs) {
        URI destUri = makeUri(textUri);
        if (destUri != null) {
        	EObject loadModel = null;
        	try {
        		loadModel = loadModel(destUri, rs);
        	}
        	catch (Exception e) {
        	}
            if (loadModel != null) {
            	return true;
            }
        }
        return false;
	}

	private static boolean isDynamic(EObject eObject) {
		return eObject instanceof EStructuralFeature.Internal.DynamicValueHolder;
	}
	

	public static void saveModel(EObject eObject, URI uri, Map opts) throws EmfException {    
        ResourceSet resourceSet = getOutputResourceSet();

        Resource resource = resourceSet.createResource(uri);
        resource.getContents().add(eObject);

        Map options = new HashMap(opts);
        options.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
        
        if(isDynamic(eObject)) {
        	options.put("SCHEMA_LOCATION", Boolean.TRUE); //$NON-NLS-1$
        }
        
        try {
            resource.save(options);
        } catch (Exception e) {
            throw new EmfException(NLS.bind(Messages.EmfUtil_1, uri), e);
        }
    }
    
	public static void saveModel(Resource modelExtent, URI uri, Map opts) throws EmfException {    
		modelExtent.setURI(uri);

        Map options = new HashMap(opts);
        options.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
        options.put(XMIResource.OPTION_PROCESS_DANGLING_HREF, XMIResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);       
        for (EObject eObject : modelExtent.getContents()) {
	        if(isDynamic(eObject)) {
	        	options.put("SCHEMA_LOCATION", Boolean.TRUE); //$NON-NLS-1$
	        	break;
	        }
        }
        
        try {
        	modelExtent.save(options);
        } catch (Exception e) {
            throw new EmfException(NLS.bind(Messages.EmfUtil_1, uri), e);
        }
    }
	
	public static ResourceSet getOutputResourceSet() {
		return new ResourceSetImpl();
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

    public static String getFullName(EPackage pack) {
        return getFullName(pack, "::"); //$NON-NLS-1$
    }    
    
    public static String getFullName(EPackage pack, String delim) {
        if(pack.getESuperPackage() != null) {
            return getFullName(pack.getESuperPackage(), delim) + delim + pack.getName();
        } else {
            return pack.getName();
        }
    }
    
    /**
	 * Get the given package full name relative to the specified owning package
	 * 
	 * @param ePackage
	 *            the package of which to retrieve the full name
	 * @param baseOwningPackage
	 *            the package representing the root context for relative name
	 *            resolution.
	 *            <p>
	 *            This package and its possible super-packages will be excluded
	 *            from the full-name. If it is the immediate owning package of
	 *            the <code>ePackage</code>, the local name of <code>ePackage</code> is
	 *            returned.
	 */    
    public static String getFullNameRelativeToPackage(EPackage ePackage, EPackage baseQwningPackage) {
    	String delim = "::"; //$NON-NLS-1$
        if(ePackage.getESuperPackage() != null && ePackage.getESuperPackage() != baseQwningPackage) {
        	StringBuilder buf = new StringBuilder();        	
        	
        	EPackage nextPackage = ePackage;        	
        	for(int i = 0; nextPackage != null && nextPackage != baseQwningPackage ; i++) {
        		if(i > 0) {
        			buf.insert(0, delim);
        		}
        		buf.insert(0, nextPackage.getName());        		
        		
        		nextPackage = nextPackage.getESuperPackage(); 
        	}
        	
            return getFullNameRelativeToPackage(ePackage.getESuperPackage(), baseQwningPackage) + delim + ePackage.getName();
        } else {
            return ePackage.getName();
        }
    }
    
    /**
	 * Get the given classifier's full name relative to the specified owning package
	 * 
	 * @param eClassifier
	 *            the classifier of which to retrieve name
	 * @param baseOwningPackage
	 *            the package representing the root context for relative name
	 *            resolution.
	 *            <p>
	 *            This package and its possible super-packages will be excluded
	 *            from the full-name. If it is the immediate owning package of
	 *            the given classifier, the local name of the classifier is
	 *            returned.
	 */
    public static String getFullNameRelativeToPackage(EClassifier eClassifier, EPackage baseOwningPackage) {
		EPackage immediateOwner = eClassifier.getEPackage();		
		if(baseOwningPackage != null && immediateOwner != null && baseOwningPackage != immediateOwner) {
			String parentName = EmfUtil.getFullNameRelativeToPackage(immediateOwner, baseOwningPackage);
			return parentName + "::" + eClassifier.getName(); //$NON-NLS-1$ 
		}
		return eClassifier.getName();		
	}

    public static String getMetamodelName(EPackage pack) {
    	String name = pack.getName();
    	String nsURI = pack.getNsURI();
    	if (nsURI != null && nsURI.length() > 0) {
    		name += " (" + nsURI + ")";  //$NON-NLS-1$//$NON-NLS-2$
    	}
    	return name;
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
        
        URI uri = null;
        try {
	        uri = URI.createURI(uriString);
        }
        catch (Exception e) {
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

	public static Resource createResource(URI uri, ResourceSet outResourceSet) {
		Resource resource = outResourceSet.createResource(uri); //$NON-NLS-1$
		if(resource != null) {
			return resource;
		}
		
		Object possibleFactory = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(uri.fileExtension());
		Resource.Factory factory = null;
		if (possibleFactory instanceof Resource.Factory) {
			factory = (Resource.Factory) possibleFactory;
		}
		if (possibleFactory instanceof Resource.Factory.Descriptor) {
			factory = ((Resource.Factory.Descriptor) possibleFactory).createFactory();
		}
		
		if(factory == null) {
			factory = new XMIResourceFactoryImpl();			
		}
		
		return factory.createResource(uri);
	}    
    
	public static boolean isContainmentReference(EStructuralFeature feature) {
		if (feature.eClass() == EcorePackage.eINSTANCE.getEReference()) {
			EReference ref = (EReference) feature;
			return ref.isContainment();			
		}
		
		return false;
	}
	
	public static final boolean isUriMapped(ResourceSet resourceSet, URI uri) {
	    if (uri != null) {
	        URIConverter converter = resourceSet.getURIConverter();
	        if (converter != null) {
	            Map<URI, URI> uriMap = converter.getURIMap();
	            if (uriMap != null) {
	                return uriMap.containsKey(uri);
	            }
	        }
	    }
	    return false;
	}
	
    public static final Map DEFAULT_SAVE_OPTIONS = new HashMap();
    static {
    	DEFAULT_SAVE_OPTIONS.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
    }
}
