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
package org.eclipse.m2m.qvt.oml.ast.environment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.expressions.MappingParameter;
import org.eclipse.m2m.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.ValidationMessages;
import org.eclipse.m2m.qvt.oml.internal.cst.adapters.ModelTypeMetamodelsAdapter;
import org.eclipse.m2m.qvt.oml.library.IContext;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.osgi.util.NLS;


public class QvtOperationalEvaluationEnv extends EcoreEvaluationEnvironment {
	
	protected QvtOperationalEvaluationEnv(IContext context,
			EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
		super(parent);
	    myBindings = new HashMap<String, Object>();
		myObjectExpOwnerStack = new Stack<Object>();
		myOperationArgs = new ArrayList<Object>();
		myContext = context;
		
		if (parent instanceof QvtOperationalEvaluationEnv) {
			setModelParameterExtents(((QvtOperationalEvaluationEnv) parent).myModelExtents);
		}
		else {
			myModelExtents = Collections.emptyMap();
		}
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
		if (getQVTStandartLibrary().overrides(operation, opcode)) {
			return true;
		}
		return super.overrides(operation, opcode);
	}

	@Override
	public Object callOperation(EOperation operation, int opcode, Object source, Object[] args)
			throws IllegalArgumentException {
		if (getQVTStandartLibrary().overrides(operation, opcode)) {
			return getQVTStandartLibrary().callOperation(this, myContext, operation, opcode, source, args);
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
		}
		//
		
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
        return myBindings.get(name);
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
     * Removes the supplied name and binding from the environment (if it exists)
     * and returns it.
     * 
     * @param name
     *            the name to remove
     * @return the value associated with the removed name
     */
	@Override
    public Object remove(String name) {
        return myBindings.remove(name);
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

    public void createModuleParameterExtents(Module module) {        
        Map<ModelParameter, ModelParameterExtent> modelExtents = new LinkedHashMap<ModelParameter, ModelParameterExtent>(module.getModelParameter().size());
        modelExtents.put(null, new ModelParameterExtent());
        int argIndex = 0;
        for (ModelParameter modelParam : module.getModelParameter()) {
        	if (modelParam.getKind() == DirectionKind.OUT) {
        		modelExtents.put(modelParam, new ModelParameterExtent());
        		continue;
        	}
        	if (argIndex >= getOperationArgs().size()
        			|| false == getOperationArgs().get(argIndex) instanceof EObject) {
                throw new IllegalArgumentException("Missed argument for model parameter: " + modelParam.getName()); //$NON-NLS-1$
        	}

        	List<EPackage> metamodels = ModelTypeMetamodelsAdapter.getMetamodels(modelParam.getEType());
        	if (metamodels.isEmpty()) {
        		modelExtents.put(modelParam, new ModelParameterExtent());
        	}
        	else {        	
	        	EPackage expMetamodel = metamodels.get(0);
	        	EObject argument = (EObject) getOperationArgs().get(argIndex);
	        	
	        	while (true) {
	        		if (argument.eClass().eContainer() == expMetamodel) {
	        			modelExtents.put(modelParam, new ModelParameterExtent(argument));
	        			break;
	        		}
	        		if (argument.eContainer() == null) {
	        			modelExtents.put(modelParam, new ModelParameterExtent());
	        			break;
	        		}
	        		argument = argument.eContainer();
	        	}	        	
        	}
        	
        	argIndex++;
        }
		
        setModelParameterExtents(modelExtents);
	}

    private void setModelParameterExtents(Map<ModelParameter, ModelParameterExtent> modelExtents) {
		myModelExtents = modelExtents;
		for (Map.Entry<ModelParameter, ModelParameterExtent> entry : modelExtents.entrySet()) {
			if (entry.getKey() != null && entry.getKey().getName().length() > 0) {
				add(entry.getKey().getName(), entry.getValue());
			}
		}
	}

	/**
	 * - Creates list of output resources (model extents) for each 'inout' and 'out' parameters of
	 *   transformation. For non-changed 'inout' model parameter corresponding resource is empty.
	 * @return ordered list of model extents
	 */
	public QvtEvaluationResult createEvaluationResult(ImperativeOperation entryPoint, ResourceSet outResourceSet) {
		List<Resource> extents = new ArrayList<Resource>();
		for (Map.Entry<ModelParameter, ModelParameterExtent> entry : myModelExtents.entrySet()) {
			if (entry.getKey() != null 
					&& entry.getKey().getKind() != DirectionKind.IN) {
	        	extents.add(entry.getValue().getModelExtent(outResourceSet));
			}
		}
		
		List<EObject> unboundedObjects = Collections.emptyList();
		if (myModelExtents.containsKey(null)) {
			unboundedObjects = myModelExtents.get(null).getEObjectsInExtent();
		}

        List<Object> outParamValues = makeOutParamValues(entryPoint);
		
		return new QvtEvaluationResult(extents, unboundedObjects, outParamValues);
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
		else {
			String extentName = extent != null ? extent.getName() : String.valueOf((Object) null) ;
            throw new RuntimeException("Unknown model extent '" + extentName + "' for the type " + impl.getName()); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return newObject;
	}

	@SuppressWarnings("unchecked")
	public void callSetter(EObject owner, EStructuralFeature eStructuralFeature, Object exprValue,
			boolean valueIsUndefined, boolean isReset) {
        Class<?> expectedType = eStructuralFeature.getEType().getInstanceClass();

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

	public Object createFromString(final EClassifier type, final String stringValue) {
        if (!QvtOperationalUtil.isCreateFromStringSupported(type) || stringValue == null) {
            return QvtOperationalUtil.getOclInvalid();
        }
        // QVT primitive type
        if (type instanceof PrimitiveType && PrimitiveType.INTEGER_NAME.equals(((PrimitiveType) type).getName())) {
            return new Integer(stringValue);
        } 
        if (type instanceof PrimitiveType && PrimitiveType.STRING_NAME.equals(((PrimitiveType) type).getName())) {
            return new String(stringValue);
        } 
        if (type instanceof PrimitiveType && PrimitiveType.REAL_NAME.equals(((PrimitiveType) type).getName())) {
            return new Double(stringValue);
        } 
        if (type instanceof PrimitiveType && PrimitiveType.BOOLEAN_NAME.equals(((PrimitiveType) type).getName())) {
            return new Boolean(stringValue);
        } 
        // Enumeration
        if (type instanceof EDataType) {
            Object value = type.getEPackage().getEFactoryInstance().createFromString((EDataType) type, stringValue);
            if (value == null) {
                throw new IllegalArgumentException(NLS.bind(ValidationMessages.Evaluation_CannotCreateFromString,
                		type.getName(), stringValue));
            }
            return value;
        }
        throw new IllegalStateException("Class + " + type.getClass().getName() + //$NON-NLS-1$
        		" is not handled and not excluded in isCreateFromStringSupported"); //$NON-NLS-1$
	}

    private QvtOperationalStdLibrary getQVTStandartLibrary() {
		return QvtOperationalStdLibrary.INSTANCE;
	}
    
    public QvtOperationalEvaluationEnv cloneEvaluationEnv() {
        QvtOperationalEvaluationEnv env = new QvtOperationalEvaluationEnv(getContext(), getParent());
        env.myObjectExpOwnerStack.addAll(myObjectExpOwnerStack);
        env.myOperationArgs.addAll(myOperationArgs);
        env.myOperationSelf = myOperationSelf;
        env.myBindings.putAll(myBindings);
        return env;
    }
    
    
	private final Stack<Object> myObjectExpOwnerStack;
	private final List<Object> myOperationArgs;
	private Object myOperationSelf;
	private final IContext myContext;
    private final Map<String, Object> myBindings;
	private Map<ModelParameter, ModelParameterExtent> myModelExtents;
	
}
