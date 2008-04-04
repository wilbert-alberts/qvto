/*******************************************************************************
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtChangeRecorder;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandler;
import org.eclipse.m2m.qvt.oml.emf.util.modelparam.ResourceEObject;
import org.eclipse.m2m.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.expressions.MappingParameter;
import org.eclipse.m2m.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.qvt.oml.expressions.VarParameter;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.types.AnyType;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.ocl.util.Tuple;


public class QvtOperationalEvaluationEnv extends EcoreEvaluationEnvironment {
	
	protected QvtOperationalEvaluationEnv(IContext context,
			EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
		super(parent);
	    myBindings = new HashMap<String, Object>();
		myObjectExpOwnerStack = new Stack<Object>();
		myOperationArgs = new ArrayList<Object>();
		myContext = context;
		
		if (parent instanceof QvtOperationalEvaluationEnv) {
			setModelParameterExtents(((QvtOperationalEvaluationEnv) parent).myModelExtents, ((QvtOperationalEvaluationEnv) parent).myMapImportedExtents);
		}
		else {
			myModelExtents = Collections.emptyMap();
			myMapImportedExtents = Collections.emptyMap();
		}
	}
	
	public Object getInvalid() {
		return getInvalidResult();
	}
	
	@Override
	public Map<EClass, Set<EObject>> createExtentMap(Object object) {
    	return new HashMap<EClass, Set<EObject>>() {    		
    		private static final long serialVersionUID = -4634238504663823715L;

    		@Override
    		public Set<EObject> get(Object key) {
    			if(key instanceof EClass) {
    				return collectInstances((EClass) key);
    			}
    			return Collections.emptySet();
    		}
    		
			Set<EObject> collectInstances(EClass context) {
    			HashSet<EObject> result = new HashSet<EObject>();    			
    			Map<ModelParameter, ModelParameterExtent> modelExtents = QvtOperationalEvaluationEnv.this.myModelExtents;
    			if(modelExtents == null) {
    				return result;
    			}
    			
				Collection<ModelParameterExtent> extents = modelExtents.values();
    			for (ModelParameterExtent nextExtent : extents) {
					for (Object nextObj : nextExtent.getAllObjects()) {
						if(nextObj instanceof EObject && isKindOf(nextObj, context)) {
							result.add((EObject)nextObj);
						}
					}
				}
    			return result;
    		}
    	};
	}
	
	public void popObjectExpOwner() {
		myObjectExpOwnerStack.pop();
	}

	public Object peekObjectExpOwner() {
		return myObjectExpOwnerStack.peek();
	}

	public void pushObjectExpOwner(Object owner) {
		myObjectExpOwnerStack.push(owner);
	}

	public List<Object> getOperationArgs() {
		return myOperationArgs;
	}

	public void setOperationSelf(Object source) {
		myOperationSelf = source;
	}
	
	public Object getOperationSelf() {
		return myOperationSelf;
	}
	
	public IContext getContext() {
		return myContext;
	}
	
	public String getConfigurationProperty(String name) {
		return myContext.getConfiguration().getProperty(name);
	}
	
	@Override
	public boolean overrides(EOperation operation, int opcode) {
		if (CallHandler.Access.hasHandler(operation)) {
			return true;
		} 
		return super.overrides(operation, opcode);
	}

	@Override
	public Object callOperation(EOperation operation, int opcode, Object source, Object[] args) throws IllegalArgumentException {
		CallHandler callHandler = CallHandler.Access.getHandler(operation);
		if(callHandler != null) {
			if(source == null || source == getInvalidResult()) {
				return getInvalidResult();
			}
			return callHandler.invoke(source, args, this, getContext());
		}
			
		return super.callOperation(operation, opcode, source, args);
	}

	@Override
	public Object navigateProperty(EStructuralFeature property, List<?> qualifiers, Object target) throws IllegalArgumentException {
		EStructuralFeature resolvedProperty = property;		
		
		// Remark: workaround for a issue of multiple typle type instances, possibly coming from 
		// imported modules. The super impl. looks for the property by feature instance, do it
		// by name here to avoid lookup failure, IllegalArgExc...
		if(target instanceof Tuple && target instanceof EObject) {
            EObject etarget = (EObject) target;
            resolvedProperty = etarget.eClass().getEStructuralFeature(property.getName());
            if(resolvedProperty == null) { 
            	return null;
            }
		} else if(property.getEType() instanceof CollectionType && target instanceof EObject) {
			// module property of direct OCL collection type => override the super impl which coerce the result value 
			// and takes only the first element and returns from navigate call
            EObject eTarget = (EObject) target;
            if (eTarget.eClass().getEAllStructuralFeatures().contains(property)) {
                return eTarget.eGet(property, true);
            }
		}
		
		return super.navigateProperty(resolvedProperty, qualifiers, target);
	}
	
	@Override
	public QvtOperationalEvaluationEnv getParent() {
		return (QvtOperationalEvaluationEnv) super.getParent();
	}

    /**
     * Returns the value associated with the supplied name
     * 
     * @param name
     *            the name whose value is to be returned
     * @return the value associated with the name
     */
	@Override
    public Object getValueOf(String name) {
        Object result = myBindings.get(name);
        if(result == null && name != null && !myBindings.containsKey(name)) {
        	if(getParent() != null && (name.endsWith(QvtOperationalFileEnv.THIS_VAR_QNAME_SUFFIX))) {
        		return getParent().getValueOf(name);
        	}
        }
        
        if(result instanceof TypedBinding) {
        	return ((TypedBinding)result).value;
        }

        return result;
    }

	/**
	 * Gets the type bound to the variable of the given name.
	 * 
	 * @param the
	 *            name of the variable
	 * @return the type the referenced variable previously bound by
	 *         {@link #add(String, Object, EClassifier)} or <code>null</code>
	 *         if none is available.
	 * @see #add(String, Object, EClassifier)
	 */
    public EClassifier getTypeOf(String name) {
        Object result = myBindings.get(name);
        
        if(result instanceof TypedBinding) {
        	return ((TypedBinding)result).type;
        }
        
        return null;
    }	
	
    /**
	 * Test whether the give object is OclInvalid retrieved from this
	 * environment.
	 * 
	 * @param value
	 *            the object to test
	 * @return <code>true</code> if the passed object is
	 *         <code>OclInvalid</code> from this environment;
	 *         <code>false</code> otherwise
	 */
    public boolean isOclInvalid(Object value) {
    	return getInvalidResult() == value;
    }

    /**
     * Replaces the current value of the supplied name with the supplied value.
     * 
     * @param name
     *            the name
     * @param value
     *            the new value
     */
	@Override
    public void replace(String name, Object value) {
    	myBindings.put(name, value);
    }

    /**
	 * Replaces the current value of the supplied name with the supplied value
	 * and type.
	 * 
	 * @param name
	 *            the name
	 * @param declaredType
	 *            the type of the value known at declaration time
	 * @param value
	 *            the new value
	 */
    public void replace(String name, Object value, EClassifier declaredType) {
    	if(declaredType != null) {
    		replace(name, new TypedBinding(value, declaredType));
    	} else {
			replace(name, value);
		}
    }

    /**
     * Adds the supplied name and value binding to the environment
     * 
     * @param name
     *            the name to add
     * @param value
     *            the associated binding
     */
	@Override
    public void add(String name, Object value) {
        if (myBindings.containsKey(name)) {
            String message = OCLMessages.bind(
            		OCLMessages.BindingExist_ERROR_,
                    name,
                    myBindings.get(name));
            throw new IllegalArgumentException(message);
        }
        myBindings.put(name, value);
    }
	
    /**
     * Adds the supplied name and typed value binding to the environment
     * 
     * @param name
     *            the name to add
	 * @param declaredType
	 *            the type of the value known at declaration time            
     * @param value
     *            the associated binding
     */	
    public void add(String name, Object value, EClassifier declaredType) {
    	if(declaredType != null) {
    		add(name, new TypedBinding(value, declaredType));
    	} else {
    		add(name, value);
    	}
    }

    /**
     * Removes the supplied name and binding from the environment (if it exists)
     * and returns it.
     * 
     * @param name
     *            the name to remove
     * @return the value associated with the removed name
     */
	@Override
    public Object remove(String name) {
        Object result = myBindings.remove(name);
        if(result instanceof TypedBinding) {
        	return ((TypedBinding)result).value;
        }

        return result;
    }

    /**
     * Clears the environment of variables.
     */
	@Override
    public void clear() {
    	myBindings.clear();
    }

    /**
     * Returns a string representation of the bindings
     */
	@Override
    public String toString() {
        return myBindings.toString();
    }
	
	public Set<String> getKeys() {
		return myBindings.keySet();
	}
	
	@Override
	public boolean isKindOf(Object object, EClassifier classifier) {
		if (classifier instanceof AnyType) {
			// [Spec 11.2.1] All types in the UML model and the primitive types in the OCL standard library
			// comply with the type OclAny.
			// OclAny behaves as a supertype for all the types except for the OCL pre-defined collection types.
			// OclAny is itself an instance of the metatype AnyType.
			return false == object instanceof Collection;
		} 
		else if(classifier == QvtOperationalStdLibrary.INSTANCE.getElementType()) {
			return classifier instanceof EClass;
		}
		return super.isKindOf(object, classifier);
	}
	
	public void dispose() {
		for (QvtChangeRecorder qvtChangeRecorder : myChangeRecorders) {
			qvtChangeRecorder.dispose();
		}
		myChangeRecorders.clear();
	}

    public void createModuleParameterExtents(Module module) {        
        Map<ModelParameter, ModelParameterExtent> modelExtents = new LinkedHashMap<ModelParameter, ModelParameterExtent>(module.getModelParameter().size());
        modelExtents.put(UNBOUND_MODEL_EXTENT, new ModelParameterExtent());
        int argIndex = 0;
        for (ModelParameter modelParam : module.getModelParameter()) {
        	if (modelParam.getKind() == DirectionKind.OUT) {
        		ModelParameterExtent outExtent = new ModelParameterExtent();
        		outExtent.setModelParameter(modelParam);
				modelExtents.put(modelParam, outExtent);
        		continue;
        	}
        	if (argIndex >= getOperationArgs().size()
        			|| false == getOperationArgs().get(argIndex) instanceof EObject) {
                throw new IllegalArgumentException("Missed argument for model parameter: " + modelParam.getName()); //$NON-NLS-1$
        	}

        	/*
        	 * See: https://bugs.eclipse.org/bugs/show_bug.cgi?id=216903 (QVT run configuration should consider all objects in selected model)
        	 * 
        	if (metamodels.isEmpty()) {
        		modelExtents.put(modelParam, new ModelParameterExtent(metamodels));
        	}
        	else {        	
	        	EPackage expMetamodel = metamodels.get(0);
	        	EObject argument = (EObject) getOperationArgs().get(argIndex);
	        	
	        	while (true) {
	        		if (EcoreUtil.getRootContainer(argument.eClass()) == expMetamodel) {
	        			modelExtents.put(modelParam, new ModelParameterExtent(argument, metamodels));
	                	if (modelParam.getKind() == DirectionKind.IN) {
	                		QvtChangeRecorder qvtChangeRecorder = new QvtChangeRecorder(modelParam);
	                		qvtChangeRecorder.beginRecording(Collections.singletonList(argument));
	                		myChangeRecorders.add(qvtChangeRecorder);
	                	}
	        			break;
	        		}
	        		if (argument.eContainer() == null) {
	        			modelExtents.put(modelParam, new ModelParameterExtent(metamodels));
	        			break;
	        		}
	        		argument = argument.eContainer();
	        	}	        	
        	}
        	*/

        	Object argument = getOperationArgs().get(argIndex);
        	List<EObject> argValues = argument instanceof ResourceEObject ? ((ResourceEObject) argument).getChildren() 
        			: Collections.singletonList((EObject) argument);
			ModelParameterExtent inOrInoutExtent = new ModelParameterExtent(argValues);
			inOrInoutExtent.setModelParameter(modelParam);
			modelExtents.put(modelParam, inOrInoutExtent);
        	if (modelParam.getKind() == DirectionKind.IN) {
        		QvtChangeRecorder qvtChangeRecorder = new QvtChangeRecorder(modelParam);
        		qvtChangeRecorder.beginRecording(argValues);
        		myChangeRecorders.add(qvtChangeRecorder);
        	}
        	
        	argIndex++;
        }
		
        Map<ModelParameter, ModelParameter> mapImportedExtents = createImportedExtentMap(module, module);
        setModelParameterExtents(modelExtents, mapImportedExtents);
	}
    
	private Map<ModelParameter, ModelParameter> createImportedExtentMap(Module rootModule, Module importedModule) {
		Map<ModelParameter, ModelParameter> mapImportedExtents = new HashMap<ModelParameter, ModelParameter>();
		for (ModuleImport moduleImport : importedModule.getModuleImport()) {
			if(moduleImport.getModule() != null) {
				Module nextModule = moduleImport.getImportedModule();
				mapImportedExtents.putAll(getExtentMap(rootModule, nextModule));
				mapImportedExtents.putAll(createImportedExtentMap(rootModule, nextModule));
			}
		}
		return mapImportedExtents;
	}

	private Map<ModelParameter, ModelParameter> getExtentMap(Module rootModule, Module importedModule) {
		Map<ModelParameter, ModelParameter> mapImportedModelParams = new HashMap<ModelParameter, ModelParameter>();
		Set<ModelParameter> consideredParams = new HashSet<ModelParameter>();
		for (ModelParameter importedParam : importedModule.getModelParameter()) {
			for (ModelParameter param : rootModule.getModelParameter()) {
				if (consideredParams.contains(param)) {
					continue;
				}
				if (QvtOperationalUtil.isModelParamEqual(param, importedParam, true)) {
					consideredParams.add(param);
					mapImportedModelParams.put(importedParam, param);
					break;
				}
			}
		}

		for (ModelParameter importedParam : importedModule.getModelParameter()) {
			if (mapImportedModelParams.containsKey(importedParam)) {
				continue;
			}
			for (ModelParameter param : rootModule.getModelParameter()) {
				if (consideredParams.contains(param)) {
					continue;
				}
				if (QvtOperationalUtil.isModelParamEqual(param, importedParam, false)) {
					consideredParams.add(param);
					mapImportedModelParams.put(importedParam, param);
					break;
				}
			}
		}
		return mapImportedModelParams;
	}

    private void setModelParameterExtents(Map<ModelParameter, ModelParameterExtent> modelExtents, Map<ModelParameter, ModelParameter> mapImportedExtents) {
		myModelExtents = modelExtents;
		myMapImportedExtents = mapImportedExtents;
		for (Map.Entry<ModelParameter, ModelParameterExtent> entry : modelExtents.entrySet()) {
			if (entry.getKey() != UNBOUND_MODEL_EXTENT && entry.getKey().getName().length() > 0) {
				add(entry.getKey().getName(), entry.getValue());
			}
		}
	}

	/**
	 * - Creates list of output resources (model extents) for each 'inout' and 'out' parameters of
	 *   transformation. For non-changed 'inout' model parameter corresponding resource is empty.
	 * @return ordered list of model extents
	 */
	public QvtEvaluationResult createEvaluationResult(ImperativeOperation entryPoint) {
		List<ModelExtentContents> extents = new ArrayList<ModelExtentContents>();
		for (Map.Entry<ModelParameter, ModelParameterExtent> entry : myModelExtents.entrySet()) {
			if (entry.getKey() != UNBOUND_MODEL_EXTENT 
					&& entry.getKey().getKind() != DirectionKind.IN) {
	        	extents.add(entry.getValue().getContents());
			}
		}
		
        List<Object> outParamValues = makeOutParamValues(entryPoint);
		
		return new QvtEvaluationResult(extents,
				myModelExtents.get(UNBOUND_MODEL_EXTENT).getRootObjects(), outParamValues);
	}
	
	private List<Object> makeOutParamValues(ImperativeOperation entryPoint) {
		List<Object> outParamValues = new ArrayList<Object>();
		for (EParameter param : entryPoint.getEParameters()) {
			MappingParameter mappingParam  = (MappingParameter) param;
			if (mappingParam.getKind() == DirectionKind.IN) {
				continue;
			}
			Object valueOf = getValueOf(mappingParam.getName());
			if (valueOf != null) {
				outParamValues.add(valueOf);
			}
		}
		for (VarParameter param : entryPoint.getResult()) {
			MappingParameter mappingParam  = (MappingParameter) param;
			if (mappingParam.getKind() == DirectionKind.IN) {
				continue;
			}
			Object valueOf = getValueOf(mappingParam.getName());
			if (valueOf != null) {
				outParamValues.add(valueOf);
			}
		}
		return outParamValues;
	}

	public EObject createInstance(EClassifier type, ModelParameter extent) {
        if (type instanceof EClass == false) {
            throw new IllegalArgumentException("Expected EClass, got " + type); //$NON-NLS-1$
        }
		EClass impl = (EClass) type;
		if (!QvtOperationalUtil.isInstantiable(impl)) {
            throw new IllegalArgumentException("Cannot instantiate type " + impl.getName()); //$NON-NLS-1$
		}
		
		EObject newObject = impl.getEPackage().getEFactoryInstance().create(impl);
		if (myModelExtents.containsKey(extent)) {
			myModelExtents.get(extent).addObject(newObject);
		}
		else if (myMapImportedExtents.containsKey(extent)) {
			ModelParameter mappedExtent = myMapImportedExtents.get(extent);
			if (myModelExtents.containsKey(mappedExtent)) {
				myModelExtents.get(mappedExtent).addObject(newObject);
			}
			else {
				myModelExtents.get(UNBOUND_MODEL_EXTENT).addObject(newObject);
			}
		}
		else {
			myModelExtents.get(UNBOUND_MODEL_EXTENT).addObject(newObject);
		}
		return newObject;
	}
	
	public ModelParameterExtent getDefaultInstantiationExtent(EClassifier type) {
		List<ModelParameter> params = new ArrayList<ModelParameter>(myModelExtents.keySet().size());
		for (ModelParameter modelParameter : myModelExtents.keySet()) {
			if(modelParameter != UNBOUND_MODEL_EXTENT) {
				params.add(modelParameter);
			}
		}
		ModelParameter modelParameter = QvtOperationalEnv.findModelParameter(type, DirectionKind.OUT, params);
		if(modelParameter != null) {
			return myModelExtents.get(modelParameter);
		}
		return myModelExtents.get(UNBOUND_MODEL_EXTENT);
	}

	@SuppressWarnings("unchecked")
	public void callSetter(EObject owner, EStructuralFeature eStructuralFeature, Object exprValue,
			boolean valueIsUndefined, boolean isReset) {
		if(getInvalidResult() == owner) {
			// call performed on OclInvalid, can not continue
			return;
		}
        Class<?> expectedType = eStructuralFeature.getEType().getInstanceClass();

        if(eStructuralFeature.getEType() instanceof CollectionType) {
        	// OCL collection type used directly, set in module properties
        	Collection<Object> currentValues = (Collection<Object>) owner.eGet(eStructuralFeature);        	
    		if(currentValues == null) {
            	CollectionType<EClassifier, EOperation> collectionType = (CollectionType<EClassifier, EOperation>) eStructuralFeature.getEType();    			
    			currentValues = CollectionUtil.createNewCollection(collectionType.getKind());
    			owner.eSet(eStructuralFeature, currentValues);        			
    		}

        	if(isReset) {
        		currentValues.clear();
        	}
        	if(exprValue instanceof Collection) {
        		Collection<Object> newVal = (Collection<Object>) exprValue;
        		for (Object nextElement : newVal) {
        			if(nextElement != getInvalidResult() && nextElement != null) {
        				currentValues.add(nextElement);
        			}
				}
        	} else if(exprValue != getInvalidResult() && exprValue != null) {
        		currentValues.add(exprValue);
        	}
        	
        	return;
        }
        
        if (isMany(owner, eStructuralFeature))  {
			List<Object> featureValues = (List<Object>) owner.eGet(eStructuralFeature);
			if (isReset) {
				featureValues.clear();
			}
			if (exprValue instanceof Collection) {
                for (Object element : (Collection<Object>) exprValue) {
                    if (element != null) {
                        featureValues.add(ensureTypeCompatibility(element, expectedType));
                    }
                }
			} else if (!valueIsUndefined) {
				featureValues.add(ensureTypeCompatibility(exprValue, expectedType));
			}
        } else if (!valueIsUndefined || acceptsNullValue(expectedType)) {
			owner.eSet(eStructuralFeature, ensureTypeCompatibility(exprValue, expectedType));
        } else {
        	owner.eUnset(eStructuralFeature);
        }
	}

	private boolean isMany(EObject ownerObj, EStructuralFeature eStructuralFeature) {
		if (eStructuralFeature.isMany()) {
			return true;
		}
		if (eStructuralFeature.getLowerBound() == 0 && eStructuralFeature.getUpperBound() == ETypedElement.UNSPECIFIED_MULTIPLICITY) {
			return ownerObj.eGet(eStructuralFeature) instanceof List;
		}
		return false;
	}
	
	/**
	 * Ensures that the value has a type compatible with then expected type
	 * converting it if necessary.
	 * 
	 * @param value
	 *            the value (may be <code>null</code>)
	 * @param expectedType
	 *            the expected type (may be <code>null</code>)
	 * @return the converted value
	 */
	private Object ensureTypeCompatibility(Object value, Class<?> expectedType) {
		if ((expectedType == Double.class || expectedType == double.class) && value instanceof Integer) {
			// In OCL Integer conforms to Real, in Java Integer doesn't conform to Double.
			return Double.valueOf(((Integer) value).doubleValue());
		}
		if (value == QvtOperationalUtil.getOclInvalid()) {
			return null;
		}
		return value;
	}

	/**
	 * Returns <code>true</code> if <code>null</code> is a valid value of
	 * the type.
	 * 
	 * @param type
	 *            the type (may be <code>null</code>)
	 * @return <code>true</code> if <code>null</code> is a valid value of
	 *         the type
	 */
	private boolean acceptsNullValue(Class<?> type) {
		if (type == null) {
			return true;
		}
		return !type.isPrimitive();
	}

    public QvtOperationalEvaluationEnv cloneEvaluationEnv() {
        QvtOperationalEvaluationEnv env = new QvtOperationalEvaluationEnv(getContext(), getParent());
        env.myObjectExpOwnerStack.addAll(myObjectExpOwnerStack);
        env.myOperationArgs.addAll(myOperationArgs);
        env.myOperationSelf = myOperationSelf;
        env.myBindings.putAll(myBindings);
        return env;
    }
    
    public int setCurrentASTOffset(int currentASTOffset) {
    	int prevValue = this.myCurrentASTOffset;
    	this.myCurrentASTOffset = currentASTOffset;
    	return prevValue;
	}
    
    public int getCurrentASTOffset() {
		return myCurrentASTOffset;
	}
    
    /**
     * Sets the operation being currently executed.
     */
    public void setOperation(EOperation myOperation) {
		this.myOperation = myOperation;
	}

    /**
	 * Gets the operation being currently executed.
	 * 
	 * @return the operation of <code>null</code> if no operation context is
	 *         available
	 */    
    public EOperation getOperation() {
		return myOperation;
	}
    
    private EOperation myOperation;
    private int myCurrentASTOffset = -1;
    
	private final Stack<Object> myObjectExpOwnerStack;
	private final List<Object> myOperationArgs;
	private Object myOperationSelf;
	private final IContext myContext;
    private final Map<String, Object> myBindings;
    private final List<QvtChangeRecorder> myChangeRecorders = new ArrayList<QvtChangeRecorder>(2);
	private Map<ModelParameter, ModelParameterExtent> myModelExtents;
	private Map<ModelParameter, ModelParameter> myMapImportedExtents;
	private static final ModelParameter UNBOUND_MODEL_EXTENT = null;
	
	
	private static class TypedBinding {
		final Object value;
		final EClassifier type;
		
		private TypedBinding(Object value, EClassifier type) {
			this.value = value;
			this.type = type;
		}
	}
}
