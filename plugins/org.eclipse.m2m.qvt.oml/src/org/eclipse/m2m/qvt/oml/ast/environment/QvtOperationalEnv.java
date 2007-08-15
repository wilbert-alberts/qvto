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
package org.eclipse.m2m.qvt.oml.ast.environment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.qvt.oml.QvtMessage;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.IMetamodelDesc;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.expressions.Property;
import org.eclipse.m2m.qvt.oml.expressions.ResolveInExp;
import org.eclipse.m2m.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.qvt.oml.expressions.VariableInitExp;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.MappingsMapKey;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.ValidationMessages;
import org.eclipse.m2m.qvt.oml.internal.cst.adapters.ModelTypeMetamodelsAdapter;
import org.eclipse.m2m.qvt.oml.ocl.emf.transformations.Library;
import org.eclipse.m2m.qvt.oml.ocl.emf.transformations.LibraryCreationException;
import org.eclipse.m2m.qvt.oml.ocl.emf.transformations.LibraryOperation;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.internal.cst.CSTNode;
import org.eclipse.ocl.internal.cst.SimpleNameCS;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.osgi.util.NLS;


public class QvtOperationalEnv extends EcoreEnvironment {

	public static final String MAPPING_OPERATION_STEREOTYPE = "mapping_operation"; //$NON-NLS-1$
	public static final String IMPERATIVE_OPERATION_STEREOTYPE = "imperative_operation"; //$NON-NLS-1$
	public static final String RENAMED_PROPERTY_STEREOTYPE = "renamed_property"; //$NON-NLS-1$
	
	public static final String METAMODEL_COMPLIANCE_KIND_STRICT = "strict"; //$NON-NLS-1$
	
	
	protected QvtOperationalEnv(QvtOperationalEnv parent, QvtCompiler compiler) {
		// Set our own package registry to be populated by imported metamodels
		super(parent != null ? parent.getEPackageRegistry() : new EPackageRegistryImpl());
		setParent(parent);
		myRootEnvironment = parent != null ? parent.myRootEnvironment : null;

		myPreferredModelTypes = new LinkedHashSet<ModelType>();
		myCompiler = compiler;
		myWarningsList = new ArrayList<QvtMessage>(2);
		myErrorsList = new ArrayList<QvtMessage>(2);
		myErrorRecordFlag = true;

		defineStandartOperations();
		// Remark: the only way how to retrieve the package registry in use is from the factory
		ePackageRegistry = parent != null ? parent.getEPackageRegistry() : ((EcoreEnvironmentFactory)super.getFactory()).getEPackageRegistry();		
		myModelTypeRegistry = parent != null ? parent.myModelTypeRegistry : new LinkedHashMap<String, ModelType>(1);
	}

	/**
	* Gets the package registry used in this environment EClassifier lookup.
	*/
	public EPackage.Registry getEPackageRegistry() {
		return ePackageRegistry;
	}
	
	public MetamodelRegistry getMetamodelRegistry() {
		if(getParent() instanceof QvtOperationalEnv) {
			return ((QvtOperationalEnv)getParent()).getMetamodelRegistry();
		}
		return MetamodelRegistry.getInstance();
	}

	public QvtOperationalStdLibrary getQVTStandartLibrary() {
		return QvtOperationalStdLibrary.INSTANCE;
	}
	
    /**
     * Registers metamodel for use with this environment.
     * 
     * @return the metamodel package denoted by the given <code>URI</code> or <code>null</code>
     * 	if no package was resolved 
     */
	public List<EPackage> registerMetamodel(String metamodelUri, List<String> path) {
        List<EPackage> metamodels = new ArrayList<EPackage>(1);
		try {
			MetamodelRegistry registry = getMetamodelRegistry();
			IMetamodelDesc desc;
			if (path.isEmpty()) {
				desc = registry.getMetamodelDesc(metamodelUri);
			}
			else {
				desc = registry.getMetamodelDesc(path);
			}
	        EPackage[] models = (EPackage[])desc.getModels();
	        Collections.addAll(metamodels, models);
	        for (EPackage model : models) {
	            // register metamodel for EClassifier lookup
	        	if (model.getNsURI() == null) {
					while (true) {
						if (model.getESuperPackage() == null) {
							break;
						}
						model = model.getESuperPackage();
					}
	        	}
	            getEPackageRegistry().put(model.getNsURI(), model);
	            break;
/*
	            EPackage[] all = EmfMmUtil.getRegisterableModels(model, true);            
	            for (EPackage pack : all) {
//		            getEPackageRegistry().put(pack.getNsURI(), pack);
	            }
*/
	        }			
		} catch (EmfException e) {
			// It's legal situation of unresolved metamodels
		}
		return metamodels;
	}
	
	public void registerLibrary(Library lib) throws LibraryCreationException {
		for (LibraryOperation libOp : lib.getLibraryOperations()) {
	        QvtLibraryOperation qvtLibOp = new QvtLibraryOperation(this, libOp);

	        getQVTStandartLibrary().defineOperation(this, libOp,
	        		qvtLibOp.getContextType(), qvtLibOp.getReturnType(),
	        		libOp.getName(), qvtLibOp.getParamTypes());	        
		}
	}

	@Override
	public QvtOperationalEnvFactory getFactory() {
		return myFactory;
	}
	
	@Override
	protected void setFactory(EnvironmentFactory<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral,
			EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> factory) {
		super.setFactory(factory);
	}
	
//	@Override
//	public List<EOperation> getAdditionalOperations(EClassifier classifier) {
//		List<EOperation> result = super.getAdditionalOperations(classifier);
//		if (getParent() == null
//				&& false == classifier instanceof CollectionType
//				&& false == classifier instanceof TupleType) {
//			result = new ArrayList<EOperation>(result == null ? Collections.<EOperation>emptyList() : result);
//			result.addAll(getTypeResolver().getAdditionalOperations(getOCLStandardLibrary().getOclAny()));
//		}
//		return result;
//	}

	@Override
	public EOperation lookupOperation(EClassifier owner, String name,
			List<? extends TypedElement<EClassifier>> args) {
		getQVTStandartLibrary().lookupOperation(this, owner, name, args);
		
		// first try to lookup imperative operation with param's exact matching  
        UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> uml = getUMLReflection();
		List<EOperation> lookupMappingOperations = lookupMappingOperations(owner, name);
		nextOpLabel:for (EOperation op : lookupMappingOperations) {
	        List<EParameter> params = op.getEParameters();
	        if (params.size() != args.size()) {
	            continue;
	        }
	        
	        for (int i = 0, n = params.size(); i < n; ++i) {
				EClassifier argType = args.get(i).getType();
				EClassifier popType = uml.getOCLType(params.get(i));
	            
	            if (!QvtOperationalParserUtil.isTypeEquals(this, argType, popType)) {
	                continue nextOpLabel;
	            }
	        }
	        return op;
		}
		// pass to super in case exact imperative operation wasn't found
		return super.lookupOperation(owner, name, args);
	}
	
    public List<EOperation> lookupMappingOperations(EClassifier owner, String name) {
        if (owner == null) {
            owner = getOCLStandardLibrary().getOclVoid();
        }

        UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> uml = getUMLReflection();
        List<EOperation> operations = TypeUtil.getOperations(this, owner);
        List<EOperation> result = new ArrayList<EOperation>();
        for (EOperation operation : operations) {
            if (uml.getName(operation).equals(name) && QvtOperationalUtil.isMappingOperation(operation)) {
                result.add(operation);
            }
        }

        return result;
    } 
    
	public void reportError(String message, int startOffset, int endOffset) {
		if (!myErrorRecordFlag) {
			return;
		}
		QvtOperationalEnv parent = this;
		while (parent.getParent() != null) {
			parent = (QvtOperationalEnv) parent.getParent();
		}
		parent.myErrorsList.add(new QvtMessage(message, QvtMessage.SEVERITY_ERROR, startOffset, endOffset-startOffset+1));
		System.err.println("Error: " + message + ", Pos: " + startOffset + "-" + endOffset);
	}

	public void reportWarning(String message, int startOffset, int endOffset) {
		if (!myErrorRecordFlag) {
			return;
		}
		QvtOperationalEnv parent = this;
		while (parent.getParent() != null) {
			parent = (QvtOperationalEnv) parent.getParent();
		}
		parent.myWarningsList.add(new QvtMessage(message, QvtMessage.SEVERITY_WARNING, startOffset, endOffset-startOffset+1));
		System.err.println("Warning: " + message + ", Pos: " + startOffset + "-" + endOffset);
	}

	public void reportError(String message, CSTNode node) {
		reportError(message, node.getStartOffset(), node.getEndOffset());
	}

	public void reportWarning(String bind, CSTNode node) {
		reportWarning(bind, node.getStartOffset(), node.getEndOffset());
	}

	public List<QvtMessage> getErrorsList() {
		return myErrorsList;
	}

	public List<QvtMessage> getWarningsList() {
		return myWarningsList;
	}
	
	public QvtCompiler getCompiler() {
		return myCompiler;
	}

	public void registerModelParameters(Module module) {
		List<Variable<EClassifier, EParameter>> modelParameters = new ArrayList<Variable<EClassifier,EParameter>>(module.getModelParameter().size());
		for (ModelParameter modelParam : module.getModelParameter()) {
	        if (lookupLocal(modelParam.getName()) != null) {
	            reportError(NLS.bind(ValidationMessages.SemanticUtil_15,
	                    new Object[] { modelParam.getName() }),
	                    modelParam.getStartPosition(), modelParam.getEndPosition());
	        } else {
                Variable<EClassifier, EParameter> var = ExpressionsFactory.eINSTANCE.createVariable();
                var.setName(modelParam.getName());
                var.setType(getQVTStandartLibrary().getModelType());
                var.setRepresentedParameter(modelParam);
                modelParameters.add(var);
	        }
		}
		registerModelParametersImpl(modelParameters);
	}
	
	private void registerModelParametersImpl(List<Variable<EClassifier, EParameter>> modelParameters) {
		myModelParameters = modelParameters;
		for (Variable<EClassifier, EParameter> var : modelParameters) {
            addElement(var.getName(), var, true);
		}
	}
	
	public ModelParameter lookupModelParameter(SimpleNameCS nameCS, DirectionKind directionKind) {
		List<String> validExtents = new ArrayList<String>(1);
		for (Variable<EClassifier, EParameter> var : myModelParameters) {
			ModelParameter modelParam = (ModelParameter) var.getRepresentedParameter();
			if (directionKind == DirectionKind.IN) {
				if (modelParam.getKind() == DirectionKind.OUT) {
					continue;
				}
			}
			if (directionKind == DirectionKind.OUT) {
				if (modelParam.getKind() == DirectionKind.IN) {
					continue;
				}
			}
			if (modelParam.getName().length() == 0) {
				continue;
			}
			if (modelParam.getName().equals(nameCS.getValue())) {
				return modelParam;
			}
			else {
				validExtents.add(modelParam.getName());
			}
		}
        reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_extentWrongName,
                new Object[] { nameCS.getValue(), validExtents }), nameCS);
		return null;
	}    
	
	public ModelParameter resolveModelParameter(EClassifier type, DirectionKind directionKind) {
		EObject rootContainer = EcoreUtil.getRootContainer(type);
		if (rootContainer == null) {
			return null;
		}
		for (Variable<EClassifier, EParameter> var : myModelParameters) {
			ModelParameter modelParam = (ModelParameter) var.getRepresentedParameter();
			if (directionKind == DirectionKind.IN) {
				if (modelParam.getKind() == DirectionKind.OUT) {
					continue;
				}
			}
			if (directionKind == DirectionKind.OUT) {
				if (modelParam.getKind() == DirectionKind.IN) {
					continue;
				}
			}
			List<EPackage> metamodels = ModelTypeMetamodelsAdapter.getMetamodels(modelParam.getEType());
			if (!metamodels.isEmpty() && rootContainer == metamodels.get(0)) {
				return modelParam;
			}
		}
		return null;
	}    
	
	/**
	 * Register given modeltype in the Environment. Modeltype's registry is used in
	 * override {@link #lookupPackage(List)} and {@link #lookupClassifier(List)}
	 *  
	 */
	public void registerModelType(ModelType modelType, boolean isCheckDuplicates) {
		if (myModelTypeRegistry.containsKey(modelType.getName())) {
			if (isCheckDuplicates) {
				reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_modeltypeAlreadyDefined,
						new Object[] { modelType.getName() }),
						modelType.getStartPosition(), modelType.getEndPosition());
			}
		}
		else {
			myModelTypeRegistry.put(modelType.getName(), modelType);
		}
	}

	public ModelType getModelType(List<String> path) {
		if (path.isEmpty()) {
			return null;
		}
		return myModelTypeRegistry.get(path.get(0));
	}
	
	// TODO This stub fixes stack overflow in recurrent calls. Should be fixed in OCL
	private final Set<String> myLookupPropertyNames = new HashSet<String>(1);
	@Override
	public Variable<EClassifier, EParameter> lookupImplicitSourceForProperty(
			String name) {
		if (myLookupPropertyNames.contains(name)) {
			return null;
		}
		Variable<EClassifier, EParameter> implicitSource = null;
		try {
			myLookupPropertyNames.add(name);
			implicitSource = super.lookupImplicitSourceForProperty(name);
		}
		finally {
			myLookupPropertyNames.remove(name);
		}
		return implicitSource;
	}
	
	// TODO This stub fixes stack overflow in recurrent calls. Should be fixed in OCL
	private final Set<String> myLookupAssocClassNames = new HashSet<String>(1);
	@Override
	public Variable<EClassifier, EParameter> lookupImplicitSourceForAssociationClass(
			String name) {
		if (myLookupAssocClassNames.contains(name)) {
			return null;
		}
		Variable<EClassifier, EParameter> implicitSource = null;
		try {
			myLookupAssocClassNames.add(name);
			implicitSource = super.lookupImplicitSourceForAssociationClass(name);
		}
		finally {
			myLookupAssocClassNames.remove(name);
		}
		return implicitSource;
	}
	
	@Override
	public EClassifier lookupClassifier(List<String> names) {

		if (names.size() == 1) {
			// Unqualified type. lookup rules:
			// - Firstly a type definition existing at the level of the current module (a transformation or a library) is searched.
			// - If not found, all the packages of the model types declared in the module are recursively visited to found a type with the same name.  
			
			// TODO support intermediate classes (hosted in implicit '_INTERMEDIATE' package)
			
			if (myModelTypeRegistry.containsKey(names.get(0))) {
				return myModelTypeRegistry.get(names.get(0));
			}

			for (ModelType modelType : myModelTypeRegistry.values()) {
				EClassifier lookupClassifier = doLookupModeltypeClassifier(modelType, names);
				if (lookupClassifier != null) {
					return lookupClassifier;
				}
			}
		}
		
		if (names.size() > 1) {
			// Qualified type 
			// It is possible to either qualify the type name with a model type or a package name

			if (myModelTypeRegistry.containsKey(names.get(0))) {
				EClassifier lookupClassifier = doLookupModeltypeClassifier(
						myModelTypeRegistry.get(names.get(0)), names.subList(1, names.size()));
				if (lookupClassifier != null) {
					return lookupClassifier;
				}
			}
		}
		
		if (!myPreferredModelTypes.isEmpty()) {
			EClassifier lookupClassifier = null;
			for (ModelType modelType : myPreferredModelTypes) {
				lookupClassifier = doLookupModeltypeClassifier(modelType, names);
				if (lookupClassifier != null) {
					return lookupClassifier;
				}
			}
			return lookupClassifier;
		}
		
		return super.lookupClassifier(names);
	}
	
	@Override
	public EPackage lookupPackage(List<String> path) {
		return super.lookupPackage(path);
	}


	private EClassifier doLookupModeltypeClassifier(ModelType modelType, List<String> path) {
		if (!myPreferredModelTypes.isEmpty() && !myPreferredModelTypes.contains(modelType)) {
			return null;
		}
		EPackage oldContext = super.getContextPackage();
		EClassifier lookupClassifier = null;
		List<EPackage> metamodels = ModelTypeMetamodelsAdapter.getMetamodels(modelType);
		for (EPackage pkg : metamodels) {
			super.setContextPackage(pkg);
			lookupClassifier = super.lookupClassifier(path);
			if (EcoreUtil.getRootContainer(lookupClassifier) != pkg) {
				lookupClassifier = null;
			}
			if (lookupClassifier != null) {
				break;
			}
		}
		super.setContextPackage(oldContext);
		
		return lookupClassifier;
	}
	
	/**
	 * Preferred model types influence overrode {@link #lookupPackage(List)} and {@link #lookupClassifier(List)}
	 * methods
	 * @param modelType
	 */
	public void setPreferredModelType(ModelType modelType) {
		myPreferredModelTypes.add(modelType);
	}

	/**
	 * Preferred model types influence overrode {@link #lookupPackage(List)} and {@link #lookupClassifier(List)}
	 * methods
	 * @param directionKind
	 */
	public void setPreferredExtentDir(DirectionKind directionKind) {
		for (Variable<EClassifier, EParameter> var : myModelParameters) {
			ModelParameter modelParam = (ModelParameter) var.getRepresentedParameter();
//			if (directionKind == DirectionKind.IN) {
//				if (modelParam.getKind() == DirectionKind.OUT) {
//					continue;
//				}
//			}
			if (directionKind == DirectionKind.OUT) {
				if (modelParam.getKind() == DirectionKind.IN) {
					continue;
				}
			}
			if (modelParam.getEType() instanceof ModelType) {
				myPreferredModelTypes.add((ModelType) modelParam.getEType());
			}
		}
	}

	/**
	 * Preferred model types influence overrode {@link #lookupPackage(List)} and {@link #lookupClassifier(List)}
	 * methods
	 * @param modelType
	 */
	public void unsetPreferredModelType() {
		myPreferredModelTypes.clear();
	}

	public EOperation defineImperativeOperation(ImperativeOperation operation, boolean isMappingOperation,
			boolean isCheckDuplicates) {
		EClassifier contextType = operation.getContext().getEType();
		if (contextType == null) {
			contextType = getOCLStandardLibrary().getOclVoid();
		}
		
		Constraint constraint = EcoreFactory.eINSTANCE.createConstraint();
		constraint.setStereotype(isMappingOperation ?
				QvtOperationalEnv.MAPPING_OPERATION_STEREOTYPE : QvtOperationalEnv.IMPERATIVE_OPERATION_STEREOTYPE);

		EOperation newOperation = createOperation(operation.getName(), operation.getEType(), operation.getEParameters(), constraint);		
		EOperation addOperation = addOperation(contextType, newOperation, isCheckDuplicates);
		
		if (isCheckDuplicates && addOperation != newOperation) {
			reportError(
					NLS.bind(ValidationMessages.SemanticUtil_0, new Object[] {
							operation.getName(), contextType.getName() }),
							operation.getStartPosition(), operation.getEndPosition());
			return null;
		}
		return addOperation;
	}
	
	public void defineOperationParameters(ImperativeOperation operation) {
		for (EParameter parameter : operation.getEParameters()) {
	        if (lookupLocal(parameter.getName()) != null) {
	            reportError(NLS.bind(ValidationMessages.SemanticUtil_15,
	                    new Object[] { parameter.getName() }),
	                    ((VarParameter) parameter).getStartPosition(), ((VarParameter) parameter).getEndPosition());
	        } else {
				Variable<EClassifier, EParameter> var = ExpressionsFactory.eINSTANCE.createVariable();
				var.setName(parameter.getName());
				var.setType(parameter.getEType());
				var.setRepresentedParameter(parameter);
				addElement(parameter.getName(), var, true);
	        }
		}
	}
	
	public QvtOperationalEnv createOperationEnvironment(VarParameter context) {
		QvtOperationalEnv newEnvironment = new QvtOperationalEnv(this, myCompiler);
		Variable<EClassifier, EParameter> var = ExpressionsFactory.eINSTANCE.createVariable();
		var.setName(Environment.SELF_VARIABLE_NAME);
		var.setType(context.getEType());
		var.setRepresentedParameter(context);
		newEnvironment.addElement(var.getName(), var, false);
		if (context != getOCLStandardLibrary().getOclVoid()) {
			Variable<EClassifier, EParameter> mainVar = ExpressionsFactory.eINSTANCE.createVariable();
			mainVar.setName(getOCLStandardLibrary().getOclVoid().getName());
			mainVar.setType(getOCLStandardLibrary().getOclVoid());
			newEnvironment.addElement(mainVar.getName(), mainVar, false);
		}
		newEnvironment.registerModelParametersImpl(myModelParameters);
		return newEnvironment;
	}

    public void addPropertyVariable(Property prop) {
        if (lookupLocal(prop.getName()) != null) {
            reportError(NLS.bind(ValidationMessages.SemanticUtil_15,
                    new Object[] { prop.getName() }), prop.getStartPosition(), prop.getEndPosition());
        } else {
            if (prop.getName() != null && prop.getEType() != null) {
                Variable<EClassifier, EParameter> var = ExpressionsFactory.eINSTANCE.createVariable();
                var.setName(prop.getName());
                var.setType(prop.getEType());
                var.setRepresentedParameter(prop);
                addElement(prop.getName(), var, true);
            }
        }
    }
    
	public void addInitVariable(VariableInitExp varInit) {
		if (varInit.getName() != null) {
			Variable<EClassifier, EParameter> var = ExpressionsFactory.eINSTANCE.createVariable();
			var.setName(varInit.getName());
			var.setType(varInit.getType());
			addElement(varInit.getName(), var, true);
		}
	}

	public void setErrorRecordFlag(boolean isRecordError) {
		myErrorRecordFlag = isRecordError;
	}
	
	public void registerMappingOperation(MappingOperation operation) {
	    if (getParent() != null) {
	        ((QvtOperationalEnv) getParent()).registerMappingOperation(operation);
	    } else {
	        myMappingsMap.put(new MappingsMapKey(operation.getContext().getEType(), operation.getName()), operation);
	    }
	}
	
	public void registerResolveInExp(ResolveInExp resolveInExp, EClassifier referredMappingContextType, String mappingName) {
        if (getParent() != null) {
            ((QvtOperationalEnv) getParent()).registerResolveInExp(resolveInExp, referredMappingContextType, mappingName);
        } else {
            myResolveInExps.put(resolveInExp, new MappingsMapKey(referredMappingContextType, mappingName));
        }
	}
	
	public void resolveResolveInExpInMappings() {
	    if (getParent() == null) {
	        for (Map.Entry<ResolveInExp, MappingsMapKey> entry : myResolveInExps.entrySet()) {
	            MappingsMapKey mappingsMapKey = entry.getValue();
	            MappingOperation mappingOperation = myMappingsMap.get(mappingsMapKey);
	            ResolveInExp resolveInExp = entry.getKey();
	            resolveInExp.setInMapping(mappingOperation);
	        }
	    }
	}

	private void defineStandartOperations() {
		getQVTStandartLibrary().defineStandartOperations(this);
	}

	private EOperation createOperation(String name, EClassifier type, EList<EParameter> params,
			Constraint constraint) {
		EOperation result = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEOperation();
		
		result.setName(name);
		result.setEType((type == null) ? getOCLStandardLibrary().getOclVoid() : type);
		
		for (EParameter next : params) {
			EParameter param = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEParameter();
			param.setName(next.getName());
			param.setEType((next.getEType() == null) ?
					getOCLStandardLibrary().getOclVoid() : next.getEType());
			
			result.getEParameters().add(param);
		}
		
		EAnnotation ann = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAnnotation();
		ann.setSource(Environment.OCL_NAMESPACE_URI);
		result.getEAnnotations().add(ann);
		ann.getContents().add(constraint);
		
		return result;
	}

	private EOperation addOperation(EClassifier owner, EOperation operation, boolean fake) {
		if (getParent() instanceof QvtOperationalEnv) {
			// propagate additional operations as high as possible so that they
			//    will be accessible to all child environments of the root
			return ((QvtOperationalEnv) getParent()).addOperation(owner, operation, fake);
		} else {
			return getTypeResolver().resolveAdditionalOperation(owner, operation);
		}
	}	

	
	protected final QvtOperationalEnv myRootEnvironment;
	
	private final QvtCompiler myCompiler;
	private final List<QvtMessage> myWarningsList;
	private final List<QvtMessage> myErrorsList;
	private boolean myErrorRecordFlag;

	private final Map<String, ModelType> myModelTypeRegistry;
	private final Set<ModelType> myPreferredModelTypes;
	private List<Variable<EClassifier, EParameter>> myModelParameters = Collections.emptyList();
	
	private final EPackage.Registry ePackageRegistry;
    private final Map<MappingsMapKey, MappingOperation> myMappingsMap = new HashMap<MappingsMapKey, MappingOperation>();
    private final Map<ResolveInExp, MappingsMapKey> myResolveInExps = new HashMap<ResolveInExp, MappingsMapKey>();
	
    private static final QvtOperationalEnvFactory myFactory = new QvtOperationalEnvFactory();

}
