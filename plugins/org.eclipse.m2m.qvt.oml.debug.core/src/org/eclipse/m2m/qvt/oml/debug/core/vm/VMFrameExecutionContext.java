package org.eclipse.m2m.qvt.oml.debug.core.vm;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.ocl.types.OCLStandardLibrary;

interface VMFrameExecutionContext {
	
	EClassifier getOCLType(EStructuralFeature feature);
	
	List<EStructuralFeature> getAllFeatures(EClass eClass);
	/**
	 * TODO - 
	 * Note: with derived properties may execute QVTO engine, throw QVTRuntimeException!!!
	 * Should be evaluated at separate thread and QVTO Evaluator, to be interruptible
	 */
	Object getValue(EStructuralFeature feature, EObject target);
	
	QvtOperationalEvaluationEnv getEvalEnv();
	
	OCLStandardLibrary<EClassifier> getStandardLibrary();
}