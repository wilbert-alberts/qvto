package org.eclipse.m2m.qvt.oml.debug.core.vm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitorImpl;
import org.eclipse.m2m.internal.qvt.oml.evaluator.TransformationInstance;
import org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.ocl.types.OCLStandardLibrary;

public class UnitLocationExecutionContext implements VMFrameExecutionContext {

	private UnitLocation fLocation;
	private QvtOperationalEvaluationVisitorImpl fEvaluator;

	UnitLocationExecutionContext(QvtOperationalEvaluationVisitorImpl evaluator, UnitLocation location) {
		if(evaluator == null || location == null) {
			throw new IllegalArgumentException();
		}
		
		fLocation = location;
		fEvaluator = evaluator;
	}
	
	public EClassifier getOCLType(EStructuralFeature feature) {
		return fEvaluator.getEnvironment().getUMLReflection().getOCLType(feature);
	}
	
	public OCLStandardLibrary<EClassifier> getStandardLibrary() {	
		return fEvaluator.getEnvironment().getOCLStandardLibrary();
	}
	
	public List<EStructuralFeature> getAllFeatures(EClass eClass) {
		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		features.addAll(eClass.getEAllStructuralFeatures());
		
		if(eClass instanceof Module) {
			for (Iterator<EStructuralFeature> it = features.iterator(); it.hasNext();) {
				EStructuralFeature feature = it.next();
				if(feature instanceof ContextualProperty) {
					it.remove();
				}
			}
		}
		
		collectIntermediateProperties(features, eClass);
		return features;
	}

	public QvtOperationalEvaluationEnv getEvalEnv() {
		return fLocation.getEvalEnv();
	}

	public Object getValue(EStructuralFeature feature, EObject target) {
		return fLocation.getEvalEnv().navigateProperty(feature, null, target);
	}

	private void collectIntermediateProperties(List<EStructuralFeature> properties, EClass targetClass) {
		QvtOperationalEvaluationEnv evalEnv = fLocation.getEvalEnv();		
		InternalEvaluationEnv internEvalEnv = evalEnv.getAdapter(InternalEvaluationEnv.class);
		
		ModuleInstance currentModule = internEvalEnv.getCurrentModule();
		// check if we are in transformation execution context
		if(currentModule instanceof TransformationInstance) {
			collectIntermediateProperties(properties, targetClass, (TransformationInstance) currentModule);
		}
	}
	
	// TODO - build a cache for all target types to avoid repeated lookups
	private void collectIntermediateProperties(List<EStructuralFeature> properties, EClass targetClass, TransformationInstance scopeModule) {
		OperationalTransformation operationalTransformation = scopeModule.getTransformation();
		for (EStructuralFeature nextProperty : operationalTransformation.getIntermediateProperty()) {
			if(nextProperty instanceof ContextualProperty) {
				ContextualProperty ctxProperty = (ContextualProperty) nextProperty;
				if(ctxProperty.getContext().isSuperTypeOf(targetClass)) {            
		        	properties.add(ctxProperty);
				}
			}
		}

		for (ModuleInstance importedModule : scopeModule.getImportedModules()) {
			if(importedModule instanceof TransformationInstance) {
				// Note: only transformation imported by <extends> have implicit module instances
				collectIntermediateProperties(properties, targetClass, (TransformationInstance) importedModule);
			}
		}
	}	
}
