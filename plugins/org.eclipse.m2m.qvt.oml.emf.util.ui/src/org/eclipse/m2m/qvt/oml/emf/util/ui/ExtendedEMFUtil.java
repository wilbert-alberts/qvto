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
package org.eclipse.m2m.qvt.oml.emf.util.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.codegen.ecore.genmodel.provider.GenModelItemProviderAdapterFactory;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;


/**
 * @author vrepeshko
 */
public class ExtendedEMFUtil {
	
	public static Collection<AdapterFactory> getAdapterFactories(EPackage ePackage, Class[] requiredClasses) {
		Set<AdapterFactory> adapterFactories = new LinkedHashSet<AdapterFactory>();
		for (int i = 0; i < requiredClasses.length; i++) {
			List<Object> types = new ArrayList<Object>();
			types.add(ePackage);
		    types.add(requiredClasses[i]);
			Descriptor descriptor = ComposedAdapterFactory.Descriptor.Registry.INSTANCE.getDescriptor(types);
			if (descriptor == null) {
				continue;
			}
			AdapterFactory adapterFactory = descriptor.createAdapterFactory();
			if (adapterFactory == null) {
				continue;
			}
			adapterFactories.add(adapterFactory);
		}
		return Collections.unmodifiableSet(adapterFactories);
	}
	
	public static EObject getEObject(Object object) {
		if (object instanceof EObject) {
			return (EObject) object;
		}
		if (object instanceof Resource) {
			EList contents = ((Resource) object).getContents();
			return contents.isEmpty() ? null : (EObject) contents.get(0);
		}
		if (object instanceof IAdaptable) {
			return (EObject) ((IAdaptable) object).getAdapter(EObject.class);
		}
		return null;
	}
	
    public static Resource loadModelResource(String pathName) {
        // TODO use Resource.Factory.Registry?
        ResourceSet set = new ResourceSetImpl();
        return getResource(set, pathName);
    }
    
    private static Resource getResource(ResourceSet set, String pathName) {
        URI uri = URI.createPlatformResourceURI(pathName, false);
        Resource res = set.getResource(uri, true);
        if (res == null) {
            throw new RuntimeException("resource not found " + pathName);  //$NON-NLS-1$
        }
        return res;
    }
    
    public static EObject loadModel(String pathName) {
        return (EObject)loadModelResource(pathName).getContents().get(0);
    }
    
    /**
     * Returns the {@link ComposedAdapterFactory composed adapter factory} built using specified adapter factories 
     * and {@link ReflectiveItemProviderAdapterFactory reflective adapter factory}.
     * 
     * @param adapterFactories the list of adapter factories
     * @return the {@link ComposedAdapterFactory composed adapter factory} built using specified adapter factories 
     * and {@link ReflectiveItemProviderAdapterFactory reflective adapter factory}
     */
    public static ComposedAdapterFactory createComposedAdapterFactory(Collection<AdapterFactory> adapterFactories) {
    	List<AdapterFactory> factories = new ArrayList<AdapterFactory>(adapterFactories);
    	factories.add(new ReflectiveItemProviderAdapterFactory());
    	return new ComposedAdapterFactory(factories);
    }
    
    public static ILabelProvider createValueLabelProvider() {
    	List<AdapterFactory> adapterFactories = new ArrayList<AdapterFactory>();
    	adapterFactories.add(new ResourceItemProviderAdapterFactory());
    	adapterFactories.add(new GenModelItemProviderAdapterFactory());
    	adapterFactories.add(new EcoreItemProviderAdapterFactory());
    	adapterFactories.add(new ReflectiveItemProviderAdapterFactory());
    	ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(adapterFactories);
    	return new AdapterFactoryLabelProvider(composedAdapterFactory);
    }
    
    public static String getEAttributeValue(EObject eObject, EAttribute eAttribute) {
    	Object value = eObject.eGet(eAttribute);
    	if (value == null) {
    		return null;
    	}
    	EDataType attributeType = eAttribute.getEAttributeType();
    	return attributeType.getEPackage().getEFactoryInstance().convertToString(attributeType, value);
    		
    }
    
    public static EAttribute getIdentifyingAttribute(EClass eClass) {
		EAttribute idAttribute = null;
		for (Iterator iter = eClass.getEAttributes().iterator(); iter.hasNext();) {
			EAttribute eAttribute = (EAttribute) iter.next();
			if (eAttribute.isID()) {
				idAttribute = eAttribute;
				break;
			}
		}
    	if (idAttribute == null) {
    		idAttribute = getNameAttribute(eClass);
    	}
		return idAttribute;
    }
    
    public static EAttribute getIdentifyingAttributeExtended(EClass eClass) {
		EAttribute idAttribute = eClass.getEIDAttribute();
    	if (idAttribute == null) {
    		idAttribute = getNameAttributeExtended(eClass);
    	}
		return idAttribute;
    }
    
    public static EAttribute getNameAttribute(EClass eClass) {
		return getNameAttributeHelper(eClass.getEAttributes());
	}
    
    public static EAttribute getNameAttributeExtended(EClass eClass) {
		return getNameAttributeHelper(eClass.getEAllAttributes());
	}
    
    private static EAttribute getNameAttributeHelper(Collection attributes) {
    	EAttribute result = null;
		for (Iterator i = attributes.iterator(); i.hasNext();) {
			EAttribute eAttribute = (EAttribute) i.next();
			if (!eAttribute.isMany()
					&& eAttribute.getEType().getInstanceClass() != FeatureMap.Entry.class) {
				if (NAME.equalsIgnoreCase(eAttribute.getName())) {
					result = eAttribute;
					break;
				} /*else if (result == null) {
					result = eAttribute; 
				}*/ else if (eAttribute.getName().toLowerCase().indexOf(NAME) != -1
						&& eAttribute.getEAttributeType().getInstanceClass() == String.class) {
					result = eAttribute; 
				} /*else if (eAttribute.getEAttributeType().getInstanceClass() == String.class
						&& result.getEAttributeType().getInstanceClass() != String.class) {
					result = eAttribute;
				}*/
			}
		}
		return result;
    }
    
    public static String getURIFragment(EObject eObject) {
    	return eObject.eResource().getURIFragment(eObject);
    }
    
    public static int getIndex(EObject eObject) {
    	EObject container = eObject.eContainer();
    	if (container == null) {
    		return -1;
    	}
    	EReference eReference = eObject.eContainmentFeature();
    	if (eReference.isMany()) {
    		return ((List) container.eGet(eReference)).indexOf(eObject);
    	}
    	return 0;
    }
    
    private static final String NAME = "name"; //$NON-NLS-1$
    
}
