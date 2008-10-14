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

import java.io.PrintWriter;
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
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstanceFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.m2m.internal.qvt.oml.stdlib.AbstractContextualOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.AbstractQVTStdlib;
import org.eclipse.m2m.internal.qvt.oml.stdlib.ElementOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.IntegerOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.ModelOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.OclAnyOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.RealOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.StatusOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.StdlibModuleOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.StringOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.TransformationOperations;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedElement;


public class QvtOperationalStdLibrary extends AbstractQVTStdlib {
	// FIXME - replace this hack by a reasonable solution
	public static final String OUT_PRINT_WRITER = "@out_print_writer"; //$NON-NLS-1$
	
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
	
	private final Library fStdlibModule;
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
		STATUS = createClass("Status", false);
		
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
		
		((ModuleImpl)fStdlibModule).freeze();		
	}
		
	@Override
	public EcoreEnvironment getEnvironment() {
		return fEnv;
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
        		
	@Override
	public EClass getModelClass() {	
		return MODEL;
	}
	
	@Override
	public EClass getStatusClass() {
		return STATUS;
	}
	
	@Override
	public EClass getExceptionClass() {
		return EXCEPTION;
	}	
	
	@Override
	public EClass getTransformationClass() {	
		return TRANSFORMATION;
	}	
	
	public EOperation getTransformOperation() {	
		return TRANSFORM;
	}	
	
	@Override
	public EClass getModuleType() {
		return ExpressionsPackage.eINSTANCE.getModule();
	}
	
	@Override
	public EClassifier getElementType() {
		return ELEMENT;
	}
	
	public ModelType createModel(String name) {
		ModelType modelType = ExpressionsFactory.eINSTANCE.createModelType();
		modelType.setName(name);
		modelType.getESuperTypes().add(QvtOperationalStdLibrary.INSTANCE.getModelClass());		
		return modelType;
	}

	public static Library createLibrary(String name) {	
		Library transf = ExpressionsFactory.eINSTANCE.createLibrary();
		transf.setEFactoryInstance(new ModuleInstanceFactory());
		transf.setName(name);		
		return transf;
	}
	
	public OperationalTransformation createTransformation(String name) {	
		OperationalTransformation transf = ExpressionsFactory.eINSTANCE.createOperationalTransformation();
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
					
	/**
	 * Note: Necessary until MDT OCL solves custom generic operations [#192907]  
	 */
	@SuppressWarnings("unchecked")
	public EOperation resolveGenericOperationsIfNeeded(QvtOperationalEnv env, EClassifier owner, String name,
			List<? extends TypedElement<EClassifier>> args) {
		
		// TODO waiting for resolution of OCL bug [#192907]
		if (PredefinedType.ALL_INSTANCES_NAME.equals(name) && args.size() == 1) {
			EClassifier resultType = args.get(0).getType();
			if (resultType instanceof TypeType) {
				TypeType<EClassifier, EOperation> typeType = (TypeType<EClassifier, EOperation>) resultType;
				resultType = typeType.getReferredType();
			}
			if(resultType != null) {
				return env.getTypeResolver().resolveAdditionalOperation(
						owner, this.anyOperations.defineNonStdAllInstances(env, resultType));
			}
		} else if (ModelOperations.OBJECTS_OF_TYPE_NAME.equals(name) && args.size() == 1) {
			EClassifier resultType = args.get(0).getType();
			if (resultType instanceof TypeType) {
				TypeType<EClassifier, EOperation> typeType = (TypeType<EClassifier, EOperation>) resultType;				
				resultType = typeType.getReferredType();
			}
			if(resultType != null) {
				return env.getTypeResolver().resolveAdditionalOperation(
						owner, this.modelOperations.defineGenericObjectsOfType(env, resultType));
			}
		}
		
		return null;
	}
		
	/**
	 * Gets the print writer for a logger associated with the given context.
	 * 
	 * @return the print writer object or <code>null</code> if no logger is
	 *         available.
	 */
	public static PrintWriter getLogger(IContext context) {
		Object loggerObject = context.get(QvtOperationalStdLibrary.OUT_PRINT_WRITER);
		if(loggerObject instanceof PrintWriter == false) {
			return null;
		}
		
		return (PrintWriter) loggerObject;
	}
 
	private void define(AbstractContextualOperations typeOperations) {
		typeOperations.define(fEnv);
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