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
package org.eclipse.m2m.internal.qvt.oml.ast.env;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModelInstance;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstanceFactory;
import org.eclipse.m2m.internal.qvt.oml.evaluator.TransformationInstance;
import org.eclipse.m2m.internal.qvt.oml.expressions.DictionaryType;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;
import org.eclipse.m2m.internal.qvt.oml.expressions.ListType;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl;
import org.eclipse.m2m.internal.qvt.oml.stdlib.AbstractContextualOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.AbstractQVTStdlib;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CollectionOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.DictionaryOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.ElementOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.IntegerOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.ListOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.ModelOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.OclAnyOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.RealOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.StatusOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.StdlibModuleOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.StringOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.TransformationOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.model.StdlibFactory;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.TypedElement;


public class QvtOperationalStdLibrary extends AbstractQVTStdlib {
	
	public static final String QVT_STDLIB_MODULE_NAME = "Stdlib"; //$NON-NLS-1$
	
	public static final QvtOperationalStdLibrary INSTANCE = createLibrary();
	static {
		INSTANCE.defineStandardOperations();		
	}
	
	private EClassifier ELEMENT;	
	private EClass MODEL;
	private EClass TRANSFORMATION;
	private EOperation TRANSFORM;
	private EClass STATUS;
	private EClass EXCEPTION;
	private EClassifier LIST;
	private EClassifier KEY_T;
	private DictionaryType DICTIONARY;	
	
	private final Library fStdlibModule;
	private StdlibFactory fFactory;
	
	private final QvtOperationalModuleEnv fEnv;
	private final Map<String, EClassifier> fTypeAliasMap;
	private final ModelOperations modelOperations;
	private final OclAnyOperations anyOperations;
	

	private QvtOperationalStdLibrary() {
		fStdlibModule = createLibrary(QVT_STDLIB_MODULE_NAME);
		
		fEnv = new QvtOperationalModuleEnv(new EPackageRegistryImpl());
		fEnv.setContextModule(fStdlibModule);
		
		assert fStdlibModule.eResource() != null;
		fStdlibModule.eResource().setURI(URI.createURI("qvto:/Stdlib.ecore")); //$NON-NLS-1$		

		ELEMENT = createClass("Element", true); //$NON-NLS-1$
		MODEL = createClass("Model", true); //$NON-NLS-1$
		TRANSFORMATION = createClass("Transformation", true); //$NON-NLS-1$ 
		STATUS = createClass("Status", false); //$NON-NLS-1$
		EXCEPTION = createClass("Exception", false); //$NON-NLS-1$		
		
		ListType listType = ExpressionsFactory.eINSTANCE.createListType();
		listType.setElementType(fEnv.getOCLStandardLibrary().getT());
		fStdlibModule.getEClassifiers().add(listType);
		LIST = listType;
		
		KEY_T = ExpressionsFactory.eINSTANCE.createTemplateParameterType();
		KEY_T.setName("KeyT"); //$NON-NLS-1$
		fStdlibModule.getEClassifiers().add(KEY_T);

		fFactory = new StdlibFactory(this);		
		DICTIONARY = fFactory.createDictionary(KEY_T, fEnv.getOCLStandardLibrary().getT());
		fStdlibModule.getEClassifiers().add(DICTIONARY);
				
		fTypeAliasMap = createTypeAliasMap(fEnv);		
		
		modelOperations = new ModelOperations(this);
		anyOperations = new OclAnyOperations(this);		
	}	
	
	private void defineStandardOperations() {
		define(new StringOperations(this));
		define(modelOperations);
		define(anyOperations);
		define(new ElementOperations(this));
		define(new StdlibModuleOperations(this));
		define(new IntegerOperations(this));		
		define(new RealOperations(this));
		define(new TransformationOperations(this));		
		TRANSFORM = fEnv.lookupOperation(TRANSFORMATION, "transform", //$NON-NLS-1$ 
				Collections.<TypedElement<EClassifier>>emptyList());
		assert TRANSFORM != null : "transform() operation mus be defined";
		
		define(new StatusOperations(this));
		define(new ListOperations(this));
		define(new DictionaryOperations(this));

		define(CollectionOperations.getAllOperations(this));		
		
		((ModuleImpl)fStdlibModule).freeze();		
	}
		
	@Override
	public QVTOEnvironment getEnvironment() {
		return fEnv;
	}
	
	@Override
	public StdlibFactory getStdlibFactory() {
		return fFactory;
	}
		
	public List<EOperation> getOperations(EClassifier classifier) {
		List<EOperation> result = TypeUtil.getOperations(fEnv, classifier);
		return (result != null) ? result : Collections.<EOperation>emptyList();
	}

	public void importTo(QvtOperationalEnv env) {
		env.addSibling(fEnv);
	}
	    
    public boolean isStdLibClassifier(EClassifier classifier) {
    	return classifier == getElementType() || classifier == fStdlibModule.getEClassifier(classifier.getName());
    }
    
	@Override
    public Library getStdLibModule() {
		return fStdlibModule;
	}
	
	public EClassifier getList() {
		return LIST;
	}
		
	public EClassifier getDictionary() {
		return DICTIONARY;
	}
	
	public EClassifier getKeyT() {		
		return KEY_T;
	};
		
	public EClass getModelClass() {	
		return MODEL;
	}
	
	public EClass getStatusClass() {
		return STATUS;
	}
	
	public EClass getExceptionClass() {
		return EXCEPTION;
	}	
	
	public EClass getTransformationClass() {	
		return TRANSFORMATION;
	}	
	
	public EOperation getTransformOperation() {	
		return TRANSFORM;
	}	
	
	public EClass getModuleType() {
		return ExpressionsPackage.eINSTANCE.getModule();
	}
	
	public EClassifier getElementType() {
		return ELEMENT;
	}
	
	public ModelType createModel(String name) {
		ModelType modelType = ExpressionsFactory.eINSTANCE.createModelType();
		modelType.setName(name);
		modelType.setInstanceClass(ModelInstance.class);		
		modelType.getESuperTypes().add(QvtOperationalStdLibrary.INSTANCE.getModelClass());		
		return modelType;
	}

	public static Library createLibrary(String name) {
		Library lib = ExpressionsFactory.eINSTANCE.createLibrary();
		lib.setInstanceClass(ModuleInstance.class);
		lib.setEFactoryInstance(new ModuleInstanceFactory());
		lib.setName(name);
		return lib;
	}
	
	public OperationalTransformation createTransformation(String name) {	
		OperationalTransformation transf = ExpressionsFactory.eINSTANCE.createOperationalTransformation();
		transf.setInstanceClass(TransformationInstance.class);
		transf.setEFactoryInstance(new ModuleInstanceFactory());
		transf.setName(name);
		
		EClass transformationBase = getTransformationClass();		
		transf.getESuperTypes().add(transformationBase);
		
		return transf;
	}
		
	public EClassifier lookupClassifier(List<String> nameElements) {	
		int size = nameElements.size();
		if(size == 0 || size > 2) {
			return null;
		}
		
		if(size == 2 && !QVT_STDLIB_MODULE_NAME.equals(nameElements.get(0))) {
			return null;
		}
		
		String typeName = nameElements.get(size - 1);
		EClassifier aliasedType = getTypeAlias(typeName);
		return (aliasedType != null) ? aliasedType : fStdlibModule.getEClassifier(typeName);
	}
	
	public EClassifier lookupPackage(List<String> nameElements) {	 
		if(nameElements.size() == 1 && QVT_STDLIB_MODULE_NAME.equals(nameElements.get(0))) {
			return fStdlibModule;
		}
		return null;
	}
					

		 
	private void define(AbstractContextualOperations... typeOperations) {
		for (AbstractContextualOperations nextOperations : typeOperations) {
			nextOperations.define(fEnv);	
		}		
	}
		
	private EClass createClass(String name, boolean isAbstract) {
		assert fStdlibModule != null;
		assert name != null;
		
		EClass result = EcoreFactory.eINSTANCE.createEClass();
		result.setName(name);
		result.setAbstract(true);
		fStdlibModule.getEClassifiers().add(result);

		return result;
	}
		
	private static QvtOperationalStdLibrary createLibrary() {
		QvtOperationalStdLibrary lib = new QvtOperationalStdLibrary();
		return lib;
	}
	
	private EClassifier getTypeAlias(String typeName) {
		return fTypeAliasMap.get(typeName);
	}

	private static Map<String, EClassifier> createTypeAliasMap(QvtOperationalEnv env) {
		Map<String, EClassifier> result = new HashMap<String, EClassifier>();
		result.put("Any", env.getOCLStandardLibrary().getOclAny()); //$NON-NLS-1$
		result.put("Void", env.getOCLStandardLibrary().getOclVoid()); //$NON-NLS-1$
		return result;
	}
}