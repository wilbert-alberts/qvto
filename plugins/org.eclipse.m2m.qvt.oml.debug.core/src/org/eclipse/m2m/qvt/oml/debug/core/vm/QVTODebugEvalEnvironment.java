package org.eclipse.m2m.qvt.oml.debug.core.vm;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.EvaluationEnvironment;

interface QVTODebugEvalEnvironment extends EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> {

	long getID();

}