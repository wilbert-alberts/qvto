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
 *     Alan McMorran - bug 316793
 *******************************************************************************/

package org.eclipse.m2m.internal.qvt.oml.ast.env;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;
import org.eclipse.m2m.internal.qvt.oml.cst.adapters.AbstractGenericAdapter;
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;

/**
 * @author sboyko
 *
 */
public class ModelParameterExtent {
		
	public ModelParameterExtent() {
		this((ResourceSet) null);
	}
	
	public ModelParameterExtent(ResourceSet rs) {
		this(Collections.<EObject>emptyList(), rs, null);
	}	
	
	public ModelParameterExtent(ModelParameterExtent extentToCopy) {
		this(new ArrayList<EObject>(EcoreUtil.copyAll(extentToCopy.getRootObjects())),
			extentToCopy.getResourceSet(), 
			extentToCopy.getModelParameter());
	}

	public ModelParameterExtent(List<EObject> initialEObjs, ResourceSet rs, ModelParameter modelParameter) {
		myResourceSet = rs;
		myInitialEObjects = new ArrayList<EObject>(initialEObjs);
		myAdditionalEObjects = new ArrayList<EObject>(INITIAL_EXTENT_SIZE);
		myModelParameter = modelParameter;
		
		if (isReadonly()) {
			for (EObject eObj : myInitialEObjects) {
				eObj.eAdapters().add(new ReadonlyExtentAdapter());
			}			
		}
		
		// Remark: 
		// As initial objects may have non-null containers, so can be in the middle of an object tree,
		// we need to track its original container as in [inout] extents the container my change during 
		// transformation execution. If the container of an initial object changes, it's not a root object
		Map<EObject, EObject> containerMap = null;
		for (EObject nextInitialRoot : myInitialEObjects) {
			if(nextInitialRoot.eContainer() != null) {
				if(containerMap == null) {
					containerMap = new HashMap<EObject, EObject>();
				}
				containerMap.put(nextInitialRoot, nextInitialRoot.eContainer());
			}
		}
		
		myInitialObj2ContainerMap = (containerMap != null) ? containerMap : Collections.<EObject, EObject>emptyMap();
	}

	private Resource getInMemoryResource(boolean createOnDemand) {
		if (myInMemoryResource == null) {
			if (!createOnDemand) {
				return null;
			}
			
			myInMemoryResource = new ExtentResource();

			if (myResourceSet == null) {
				for (EObject obj : myInitialEObjects) {
					if (obj.eResource() != null && obj.eResource().getResourceSet() != null) {
						myResourceSet = obj.eResource().getResourceSet();
						break;
					}
				}
			}
			if (myResourceSet != null) {
				myResourceSet.getResources().add(myInMemoryResource);
			}
		}
		
		return myInMemoryResource;
	}
			
	private ResourceSet getResourceSet() {
		return myResourceSet;
	}
	
	private ModelParameter getModelParameter() {
		return myModelParameter;
	}

	public static ModelParameter getReadonlyModelParameter(EObject eObj) {
		EObject auxParent = eObj;
		while (auxParent != null) {
			Adapter adapter = EcoreUtil.getAdapter(auxParent.eAdapters(), ReadonlyExtentAdapter.class);
			if (adapter != null) {				
				return ((ReadonlyExtentAdapter) adapter).getModelParameterExtent().myModelParameter;
			}
			auxParent = auxParent.eContainer();
		}
		return null;
	}
	
	public void addObject(EObject eObject) {
		if (eObject != null) {
			myAdditionalEObjects.add(eObject);
			getInMemoryResource(true).getContents().add(eObject);
			
			if(++myCountAddedAfterPurge >= myPurgeLimitSize) {
				purgeContents(myAdditionalEObjects, true);
				myCountAddedAfterPurge = 0;
				myPurgeLimitSize = Math.max(myAdditionalEObjects.size(), INITIAL_EXTENT_SIZE);
			}
		}
	}
	
	public List<EObject> getInitialObjects() {
		return myInitialEObjects;
	}
	
	public List<EObject> getRootObjects() {
		List<EObject> objects = new ArrayList<EObject>();

		for (EObject eObj : myInitialEObjects) {
			// Remark: we allow the initial object to have eContainer != null
			// See https://bugs.eclipse.org/bugs/show_bug.cgi?id=287711
			EObject eContainer = eObj.eContainer();
			if(eContainer == null || eContainer == myInitialObj2ContainerMap.get(eObj)) {
				// if the initial objects retains its original container, IOW it still 
				// represents a root object in the extent
				objects.add(eObj);	
			}			
		}
		
		for (EObject eObj : myAdditionalEObjects) {
			if (eObj.eContainer() == null) {
				objects.add(eObj);
			}
		}
		return objects;
	}

	public List<Object> getAllObjects() {
		purgeContents();
		
		List<Object> objects = new ArrayList<Object>();
		getAllObjects(myInitialEObjects, objects);
		getAllObjects(myAdditionalEObjects, objects);
		return objects;
	}
	
	private static void getAllObjects(Collection<EObject> rootObjs, Collection<Object> result) {
		for (EObject nextRoot : rootObjs) {
			result.add(nextRoot);
			TreeIterator<EObject> iterContents = EcoreUtil.getAllProperContents(nextRoot, false);
			while (iterContents.hasNext()) {
				result.add(iterContents.next());
			}
		}		
	}
	
	public ModelExtentContents getContents() {
		purgeContents();		
		Set<EObject> initialObjects = new LinkedHashSet<EObject>(myInitialEObjects);		
		Set<EObject> allRootObjects = new LinkedHashSet<EObject>(myAdditionalEObjects);
		allRootObjects.addAll(initialObjects);
		
		Resource inMemoryResource = getInMemoryResource(false);
		if (inMemoryResource != null) {
			for (EObject obj : inMemoryResource.getContents()) {
				// don't forget about UML stereotype applications which are the root objects
				if (obj.eContainer() == null) {
					allRootObjects.add(obj);
				}
			}
		}
		
		for (EObject obj : allRootObjects) {
			if (((InternalEObject) obj).eDirectResource() instanceof ExtentResource) {
				((InternalEObject) obj).eSetResource(null, null);
			}
		}
		
		if (myInMemoryResource != null && myInMemoryResource.getResourceSet() != null) {
			myInMemoryResource.getResourceSet().getResources().remove(myInMemoryResource);
		}
		
		return new ExtentContents(new ArrayList<EObject>(initialObjects), new ArrayList<EObject>(allRootObjects));
	}
		
	public boolean removeElement(EObject element) {
		purgeContents();
		
		delete(getRootObjects(), element);
		if(!myInitialEObjects.remove(element)) {
			myAdditionalEObjects.remove(element);
			myPurgeLimitSize = Math.max(myAdditionalEObjects.size(), INITIAL_EXTENT_SIZE);
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return myInitialEObjects.isEmpty() ? super.toString() : myInitialEObjects.toString();
	}

	public void dispose() {
		if (isReadonly()) {
			for (EObject eObj : myInitialEObjects) {
				Adapter adapter = EcoreUtil.getAdapter(eObj.eAdapters(), ReadonlyExtentAdapter.class);
				if (adapter != null) {
					eObj.eAdapters().remove(adapter);
				}
			}			
		}
	}
	
	public boolean isReadonly() {
		return myModelParameter != null && myModelParameter.getKind() == DirectionKind.IN;
	}

	private void purgeContents() {
		purgeContents(myInitialEObjects, false);
		purgeContents(myAdditionalEObjects, true);		
	}
	
	private void purgeContents(List<EObject> elements, boolean isResetResource) {
		ArrayList<EObject> result = null;		
		for (EObject nextElement : elements) {
			EObject eContainer = nextElement.eContainer();			
			if(eContainer == null || 
				(elements == myInitialEObjects && eContainer == myInitialObj2ContainerMap.get(nextElement))) {
				if(result == null) {
					result = new ArrayList<EObject>(elements.size());			
				}
				result.add(nextElement);
			} else {		
				InternalEObject internElement = (InternalEObject) nextElement;
				if (isResetResource && internElement.eDirectResource() instanceof ExtentResource) {		
					internElement.eSetResource(null, null);
				}
			}
		}

		elements.clear();
		if(result != null) {
			elements.addAll(result);
		}
	}

	  public static void delete(List<EObject> rootEObjects, EObject eObject) {
		Set<EObject> eObjects = new HashSet<EObject>();
		Set<EObject> crossResourceEObjects = new HashSet<EObject>();
		eObjects.add(eObject);
		for (@SuppressWarnings("unchecked")
		TreeIterator<InternalEObject> j = (TreeIterator<InternalEObject>) (TreeIterator<?>) eObject
				.eAllContents(); j.hasNext();) {
			InternalEObject childEObject = j.next();
			if (childEObject.eDirectResource() != null) {
				crossResourceEObjects.add(childEObject);
			} else {
				eObjects.add(childEObject);
			}
		}

		Map<EObject, Collection<EStructuralFeature.Setting>> usages;
		usages = UsageCrossReferencer.findAll(eObjects, rootEObjects);

		for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : usages
				.entrySet()) {
			EObject deletedEObject = entry.getKey();
			Collection<EStructuralFeature.Setting> settings = entry.getValue();
			for (EStructuralFeature.Setting setting : settings) {
				if (!eObjects.contains(setting.getEObject())
						&& setting.getEStructuralFeature().isChangeable()) {
					EcoreUtil.remove(setting, deletedEObject);
				}
			}
		}

		EcoreUtil.remove(eObject);

		for (EObject crossResourceEObject : crossResourceEObjects) {
			EcoreUtil.remove(crossResourceEObject.eContainer(),
					crossResourceEObject.eContainmentFeature(),
					crossResourceEObject);
		}
	}
	
	
	private static final int INITIAL_EXTENT_SIZE = 150;
	private int myCountAddedAfterPurge = 0;
	private int myPurgeLimitSize = INITIAL_EXTENT_SIZE;
	
	
	private final List<EObject> myInitialEObjects;
	private final List<EObject> myAdditionalEObjects;
	private final ModelParameter myModelParameter;
	private final Map<EObject, EObject> myInitialObj2ContainerMap;

	
	private static class ExtentContents implements ModelExtentContents {
		
		private final List<EObject> myInitialObjects;
		private final List<EObject> myRootObjects;

		private ExtentContents(List<EObject> initialObjects, List<EObject> allRootObjects) {
			this.myInitialObjects = Collections.unmodifiableList(initialObjects);
			this.myRootObjects = Collections.unmodifiableList(allRootObjects);
		}

		public List<EObject> getInitialElements() {		
			return myInitialObjects;
		}

		public List<EObject> getAllRootElements() {
			return myRootObjects;
		}
	}	
	
	private Resource myInMemoryResource;// = new ExtentResource();
	private ResourceSet myResourceSet;
		
//	/*
//	 * Ensures consistency of associated model extents of the given element
//	 * and its container.
//	 * <p>
//	 * Remark: Intended to be used after assignment to containment reference which
//	 * may result in move of the element between extents
//	 * 
//	 * @param element the element to check for model extent consistency with its container
//	 * 
//	 * @return <code>true</code> if extent move occurred, <code>false</code> otherwise
//	 */
//	static boolean handlePossibleExtentSwitch(EObject element) {
//		EObject container = element.eContainer();
//		if(container == null) {
//			return false;
//		}
//		
//		if(element.eResource() != container.eResource()) {
//			InternalEObject internalEObject = (InternalEObject)element;
//			if(internalEObject.eDirectResource() != null) {
//				internalEObject.eSetResource(null, null);
//			} else {
//				
//			}
//			return true;
//		}
//		return false;
//	}
	
	
//	private void _purgeContents() {
//		for (Iterator<EObject> it = myAdditionalEObjects.iterator(); it.hasNext();) {
//			EObject nextElement = (EObject) it.next();
//			if(nextElement.eResource() != myInMemoryResource) {
//				// already unbound from this extent by assignment to a container from another extent
//				it.remove();
//			}
//		}
//	}
	
	
	private static class ExtentResource extends ResourceImpl {
		
		private static int ourExtentId = 0;
		
		ExtentResource() {
			setURI(URI.createURI("extent:/" + (++ourExtentId))); //$NON-NLS-1$
			setTrackingModification(false);
		}
		
		@Override
		public boolean eNotificationRequired() {		
			return false;
		}
		
		@Override
		public EList<EObject> getContents() {
			if (contents == null) {
				contents = new ContentsImpl();
			}
			return contents;
		}
		
		private class ContentsImpl extends ContentsEList<EObject> {
			private static final long serialVersionUID = 2958909849409879855L;
			
			@Override
			protected boolean isUnique() {
				// avoiding the check before elements being added is already contained
				// we have it under our control, so make sure adding it just once
				// when instantiated
				return false;
			}
		}
	}

	private class ReadonlyExtentAdapter extends AbstractGenericAdapter<ReadonlyExtentAdapter> {

		public ReadonlyExtentAdapter() {
		}
		
		public ModelParameterExtent getModelParameterExtent() {
			return ModelParameterExtent.this;
		}
		
		public boolean isAdapterForType(Object type) {	
			return ReadonlyExtentAdapter.class == type;
		}

	    @Override
	    public boolean equals(Object obj) {
	        return obj instanceof ReadonlyExtentAdapter;
	    }

	    @Override
	    public int hashCode() {
	        return ReadonlyExtentAdapter.class.hashCode();
	    }
	    
	}

}
