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

package org.eclipse.m2m.internal.qvt.oml.compiler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.cst.adapters.AbstractGenericAdapter;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitor;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.ocl.expressions.OCLExpression;

/**
 * @author sboyko
 *
 */
public class IntermediateClassFactory extends EFactoryImpl {
	
	public static IntermediateClassFactory getFactory(Module module) {
		IntermediateClassFactory usedFactory = null;
		
		IntermediateClassAdapter adapter = (IntermediateClassAdapter) EcoreUtil.getAdapter(module.eAdapters(),
				IntermediateClassAdapter.class);
    	if (adapter == null) {
    		usedFactory = new IntermediateClassFactory(module);
    		adapter = new IntermediateClassAdapter(usedFactory);
    		module.eAdapters().add(adapter);
    	}
    	else {
    		usedFactory = adapter.getOwnedFactory();
    	}

		return usedFactory;
	}
	
	
	private IntermediateClassFactory(Module module) {
		super();
		myModule = module;
		
		/*
		 * 8.2.1.3 Module
		 *   The model type package is also named '_INTERMEDIATE'. This package is nested by the 
		 * transformation (by means of the inherited Package::nestedPackage property).
		 */
		myIntermediatePackage = new IntermediatePackage(this);
		myIntermediatePackage.setName(INTERMEDIATE_MODELTYPE_NAME);
		myIntermediatePackage.setNsPrefix(INTERMEDIATE_MODELTYPE_NAME.toLowerCase());
		myIntermediatePackage.setNsURI(ExpressionsPackage.eNS_URI + "/" + INTERMEDIATE_MODELTYPE_NAME);
		module.getESubpackages().add(myIntermediatePackage);

		/*
		 * 8.2.1.3 Module
		 *   If the module contains the declaration of intermediate classes (see 
		 * OperationalTransformation::intermediateClass	definition) a model type named '_INTERMEDIATE' 
		 * is automatically defined and inserted in the list of owned types.
		 */
		myIntermediateModelType = ExpressionsFactory.eINSTANCE.createModelType();
		myIntermediateModelType.setName(INTERMEDIATE_MODELTYPE_NAME);
		myIntermediateModelType.getMetamodel().add(myIntermediatePackage); // metamodel: Package [1..*] {ordered}
		module.getUsedModelType().add(myIntermediateModelType); // usedModelType : ModelType [0..*] {ordered}
		module.getEClassifiers().add(myIntermediateModelType);  // /ownedType : Type [0..*] (from Package) {composes,ordered}
		
		myIntermediateModelType.getMetamodel().add(myIntermediatePackage);
		// No need to use a metamodel adapter, the package is referenced by the modeltype directly
		//ModelTypeMetamodelsAdapter.addMetamodel(myIntermediateModelType, myIntermediatePackage);
	}

	@Override
	public EObject create(EClass class_) {
		if (myIsInitInProgress > 0) {
			if (myInstantiatedClasses.contains(class_)) {
				return null;
			}
			myInstantiatedClasses.add(class_);
		}
		//return super.create(class_);
		return new IntermediateClassInstance(class_);
	}
	
	@Override
	protected EObject basicCreate(EClass class_) {
		return super.basicCreate(class_);
	}
	
	public org.eclipse.m2m.internal.qvt.oml.expressions.Class createIntermediateClassifier() {
		org.eclipse.m2m.internal.qvt.oml.expressions.Class eClassifier = ExpressionsFactory.eINSTANCE.createClass();
		
		/*
		 * 8.2.1.3 Module
		 * Associations
		 *   /ownedType : Type [0..*] (from Package) {composes,ordered}
		 *   
		 *   All the types being defined by this module. Specifically this includes the model types, 
		 * locally defined classes, and any composite type used to define the type of a variable or a 
		 * parameter - for instance a 'Set(MyMetaclass)' user-defined datatype.
		 */
		//myModule.getEClassifiers().add(eClassifier);
		myIntermediatePackage.getEClassifiers().add(eClassifier);

		/*
		 * 8.2.1.1 OperationalTransformation
		 * Associations
		 *   intermediateClass : Class [*] {ordered}
		 *   
		 *   The classes that are defined explicitly by the transformation writer to contain structured 
		 * intermediate data used for the purpose of the transformation. These intermediate classes are
		 * to be distinguished from the trace classes that are implicitly and automatically derived from
		 * the relations. Instances of intermediate classes do not survive the execution of the 
		 * transformation, except for ensuring trace persistence.
		 */
		if (myModule instanceof OperationalTransformation) {
			((OperationalTransformation) myModule).getIntermediateClass().add(eClassifier);
		}
		
		return eClassifier;
	}
	
	public void registerModelType(QvtOperationalEnv env) {
		env.registerModelType(myIntermediateModelType);
	}

	public static boolean isIntermediateModelType(ModelType modelType) { 
		return modelType.eContainer() instanceof OperationalTransformation &&
				INTERMEDIATE_MODELTYPE_NAME.equals(modelType.getName());
	}

	public static boolean isIntermediateClass(EClassifier class_) {
		if (class_ == null) {
			return false;
		}
		EPackage ePackage = class_.getEPackage();
		if (ePackage != null && INTERMEDIATE_MODELTYPE_NAME.equals(ePackage.getName())) {
			return true;
		}
		return false;
	}

	public void addClassifierPropertyInit(EClass classifier, EStructuralFeature feature, OCLExpression<EClassifier> expression) {
		Map<EStructuralFeature, OCLExpression<EClassifier>> clsFeatures = myClassifierInitializations.get(classifier);
		if (clsFeatures == null) {
			clsFeatures = new LinkedHashMap<EStructuralFeature, OCLExpression<EClassifier>>(2);
			myClassifierInitializations.put(classifier, clsFeatures);
		}
		clsFeatures.put(feature, expression);
	}

	public void doInstancePropertyInit(Object instance, QvtOperationalEvaluationVisitor evalEnv) {
		if (false == instance instanceof EObject) {
			return;
		}
		EObject eInstance = (EObject) instance;
		
		try {
			myIsInitInProgress++;
			
			List<EClass> allSuperClasses = new ArrayList<EClass>(2);
			allSuperClasses.add(eInstance.eClass());
			allSuperClasses.addAll(eInstance.eClass().getEAllSuperTypes());
			
			for (EClass nextClass : allSuperClasses) {
				Map<EStructuralFeature, OCLExpression<EClassifier>> clsFeatures = myClassifierInitializations.get(nextClass);
				if (clsFeatures == null) {
					continue;
				}
				for (EStructuralFeature eFeature : clsFeatures.keySet()) {
					OCLExpression<EClassifier> expression = clsFeatures.get(eFeature);
					Object evalResult = evalEnv.visitExpression(expression);
					eInstance.eSet(eFeature, evalResult);
				}
			}
		}
		finally {
			myIsInitInProgress--;
			if (myIsInitInProgress == 0) {
				myInstantiatedClasses.clear();
			}
		}
	}	
	
	private static class IntermediatePackage extends EPackageImpl {
		IntermediatePackage(EFactoryImpl factory) {
			super(factory);
		}
	}
	
	
	private static class IntermediateClassInstance extends DynamicEObjectImpl {
		IntermediateClassInstance(EClass eClass) {
			super(eClass);
		}
		
		@Override
		public String toString() {
			return eClass().getName();
		}
	}
	

	private static class IntermediateClassAdapter extends AbstractGenericAdapter<IntermediateClassAdapter> {
		
		IntermediateClassAdapter(IntermediateClassFactory ownedFactory) {
			myOwnedFactory = ownedFactory;
		}
		
		IntermediateClassFactory getOwnedFactory() {
			return myOwnedFactory;
		}
		
		public boolean isAdapterForType(Object type) {	
			return IntermediateClassAdapter.class == type;
		}

	    @Override
	    public boolean equals(Object obj) {
	        return obj instanceof IntermediateClassAdapter;
	    }

	    @Override
	    public int hashCode() {
	        return IntermediateClassAdapter.class.hashCode();
	    }
	    
	    private final IntermediateClassFactory myOwnedFactory;

	}
	
	
	private final EPackage myIntermediatePackage;
	
	private final Module myModule;
	
	private final ModelType myIntermediateModelType;
	
	private final Map<EClass, Map<EStructuralFeature, OCLExpression<EClassifier>>> myClassifierInitializations 
			= new LinkedHashMap<EClass, Map<EStructuralFeature,OCLExpression<EClassifier>>>(2);
	private int myIsInitInProgress = 0;
	private final Set<EClass> myInstantiatedClasses = new HashSet<EClass>(2);

	private static final String INTERMEDIATE_MODELTYPE_NAME = "_INTERMEDIATE";

}
