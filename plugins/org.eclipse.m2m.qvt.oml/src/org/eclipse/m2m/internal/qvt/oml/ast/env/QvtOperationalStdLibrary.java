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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.m2m.internal.qvt.oml.stdlib.AbstractContextualOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.AbstractQVTStdlib;
import org.eclipse.m2m.internal.qvt.oml.stdlib.ElementOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.IntegerOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.ModelOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.OclAnyOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.RealOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.StdlibModuleOperations;
import org.eclipse.m2m.internal.qvt.oml.stdlib.StringOperations;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedElement;


public class QvtOperationalStdLibrary extends AbstractQVTStdlib {
	// FIXME - replace this hack by a reasonable solution
	public static final String OUT_PRINT_WRITER = "@out_print_writer"; //$NON-NLS-1$
	
	public static final String QVT_STDLIB_MODULE_NAME = "Stdlib"; //$NON-NLS-1$
	
	public static final QvtOperationalStdLibrary INSTANCE = createLibrary(); 
	
	private EClassifier ELEMENT;	
	private EClass MODEL;
	
	private final Module fStdlibModule;
	private final QvtOperationalEnv fEnv;
	private final Map<String, EClassifier> fTypeAliasMap;
	private final ModelOperations modelOperations;
	private final OclAnyOperations anyOperations;
	

	private QvtOperationalStdLibrary() {		
		fStdlibModule = org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createModule();
		fStdlibModule.setName(QVT_STDLIB_MODULE_NAME);

		fEnv = new QvtOperationalEnv(null) {
			@Override
			public EClass getModuleContextType() {			
				return fStdlibModule;
			}
		};

		if(fEnv.getInternalParent() == null) {
	        Variable<EClassifier, EParameter> variable = org.eclipse.ocl.expressions.ExpressionsFactory.eINSTANCE.createVariable();
	        variable.setName(fStdlibModule.getName() + QvtOperationalFileEnv.THIS_VAR_QNAME_SUFFIX); 
	        variable.setType(fStdlibModule);
	        fEnv.addElement(variable.getName(), variable, false);
		}

		ELEMENT = createClass("Element", true); //$NON-NLS-1$
		MODEL = createClass("Model", true); //$NON-NLS-1$
		
		fTypeAliasMap = createTypeAliasMap(fEnv);		
		
		((ModuleImpl)fStdlibModule).freeze();

		modelOperations = new ModelOperations(this);
		anyOperations = new OclAnyOperations(this);		
	}	
	
	protected void defineStandardOperations() {
		define(new StringOperations(this));
		define(modelOperations);
		define(anyOperations);
		define(new ElementOperations(this));
		define(new StdlibModuleOperations(this));
		define(new IntegerOperations(this));		
		define(new RealOperations(this));
	}
		
	@Override
	public EcoreEnvironment getEnvironment() {
		return fEnv;
	}
		
	public List<EOperation> getOperations(EClassifier classifier) {
		List<EOperation> result = fEnv.getAdditionalOperations(classifier);
		return (result != null) ? result : Collections.<EOperation>emptyList();
	}

	public void importTo(QvtOperationalEnv env) {
		env.addSibling(fEnv);
	}
	
    public Module getStdLibModule() {
		return fStdlibModule;
	}
    
    public boolean isStdLibClassifier(EClassifier classifier) {
    	return classifier == getElementType() || classifier == fStdlibModule.getEClassifier(classifier.getName());
    }
    

	public ModelType createModel(String name) {
		ModelType modelType = ExpressionsFactory.eINSTANCE.createModelType();
		modelType.setName(name);		
		modelType.getESuperTypes().add(MODEL);
		return modelType;		
	}
	
	@Override
	public EClass getModelClass() {	
		return MODEL;
	}
	
	@Override
	public EClass getModuleType() {
		return ExpressionsPackage.eINSTANCE.getModule();
	}
	
	@Override
	public EClassifier getElementType() {
		return ELEMENT;
	}
	
	@Override
	public Module getLibaryModule() {
		return fStdlibModule;
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
		result.isAbstract();
		fStdlibModule.getEClassifiers().add(result);

		return result;
	}
		
	private static QvtOperationalStdLibrary createLibrary() {
		QvtOperationalStdLibrary lib = new QvtOperationalStdLibrary();
		lib.defineStandardOperations();
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