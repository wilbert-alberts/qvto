package org.eclipse.m2m.internal.qvt.oml.library;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * @author aigdalov
 */

public class EObjectEStructuralFeaturePair {
    private EObject myEObject;
    private EStructuralFeature myEStructuralFeature;
 
    public EObjectEStructuralFeaturePair(EObject object, EStructuralFeature structuralFeature) {
        myEObject = object;
        myEStructuralFeature = structuralFeature;
    }
    
    public EObject getEObject() {
        return myEObject;
    }
    
    public void setEObject(EObject object) {
        myEObject = object;
    }
    
    public EStructuralFeature getEStructuralFeature() {
        return myEStructuralFeature;
    }
    
    public void setEStructuralFeature(EStructuralFeature structuralFeature) {
        myEStructuralFeature = structuralFeature;
    }
}