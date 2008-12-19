package org.eclipse.m2m.internal.qvt.oml.emf.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class ModelContent {
	
	public ModelContent(List<EObject> content) {
		myContent = new ArrayList<EObject>(content);
	}
	
	public List<EObject> getContent() {
		return Collections.unmodifiableList(myContent);
	}
	
	public ModelContent getResolvedContent(EObject metamodel) {
		List<EObject> resolvedObjs = new ArrayList<EObject>(myContent.size());
		for (EObject obj : myContent) {
			resolvedObjs.add(EmfUtil.resolveSource(obj, metamodel));
		}
		return new ModelContent(resolvedObjs);
	}
	
	public ResourceSet getResourceSet() {
		for (EObject obj : myContent) {
			if (obj.eResource() != null && obj.eResource().getResourceSet() != null) {
				return obj.eResource().getResourceSet();
			}
		}
		return null;
	}

	private final List<EObject> myContent;
}
