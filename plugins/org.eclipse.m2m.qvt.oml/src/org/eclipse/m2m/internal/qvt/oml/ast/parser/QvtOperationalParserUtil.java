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
package org.eclipse.m2m.internal.qvt.oml.ast.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalFileEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.GraphWalker;
import org.eclipse.m2m.internal.qvt.oml.evaluator.GraphWalker.NodeProvider;
import org.eclipse.m2m.internal.qvt.oml.evaluator.GraphWalker.VertexProcessor;
import org.eclipse.m2m.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.expressions.LocalProperty;
import org.eclipse.m2m.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.qvt.oml.expressions.PackageRef;
import org.eclipse.m2m.qvt.oml.expressions.Property;
import org.eclipse.m2m.qvt.oml.expressions.ReturnExp;
import org.eclipse.m2m.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.qvt.oml.expressions.VariableInitExp;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingMethodCS;
import org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS;
import org.eclipse.m2m.qvt.oml.internal.cst.temp.ScopedNameCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.cst.TupleTypeCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.osgi.util.NLS;


public class QvtOperationalParserUtil {
	
	private static final String NAMESPACE_SEPARATOR = "."; //$NON-NLS-1$
	
	private static final String QVT_NAMESPACE_URI = "http://www.eclipse.org/m2m/1.0.0/QVT"; //$NON-NLS-1$
	private static final String QVT_IS_ABSTACT = "isAbstract"; //$NON-NLS-1$
	private static final String OPERATION_OWNING_MODULE_URI = QVT_NAMESPACE_URI + "/module"; //$NON-NLS-1$
	private static final String MODULE_OWNED_OPERATION_URI =	QVT_NAMESPACE_URI + "/operation"; //$NON-NLS-1$;	

	private QvtOperationalParserUtil() {
	}

	public static EClassifier getContextualType(ImperativeOperation operation) {
		VarParameter context = operation.getContext();
		return context != null ? context.getEType() : null;		
	}
	
	public static boolean isContextual(ImperativeOperation operation) {
		return getContextualType(operation) != null;
	}

	public static String getMappingStringRepresentation(MappingMethodCS operationCS) {
		MappingDeclarationCS mappingDeclarationCS = operationCS.getMappingDeclarationCS();
		if(mappingDeclarationCS != null) {
			StringBuilder buf = new StringBuilder();
			if(mappingDeclarationCS.getContextType() != null) {
				buf.append(QvtOperationalParserUtil.getStringRepresentation(mappingDeclarationCS.getContextType()));
				buf.append(QvtOperationalTypesUtil.TYPE_NAME_SEPARATOR);
			}
			if(mappingDeclarationCS.getSimpleNameCS() != null) {				
				buf.append(mappingDeclarationCS.getSimpleNameCS().getValue());
			}
			return buf.toString();
		}
		
		return ""; //$NON-NLS-1$
	}
	
	public static String getStringRepresentation(PathNameCS pathName, String pathSeparator) {
		StringBuffer buffer = null;
		for (Iterator<String> it = pathName.getSequenceOfNames().iterator(); it.hasNext();) {
			String element = it.next();
			if (buffer != null) {
				buffer.append(pathSeparator);
			} else {
				buffer = new StringBuffer();
			}
			buffer.append(element);
		}
		return buffer == null ? "" : buffer.toString(); //$NON-NLS-1$
	}

	public static String getStringRepresentation(ScopedNameCS scopedNameCS) {
		StringBuilder buf = new StringBuilder();
		if(scopedNameCS.getTypeCS() != null) {
			buf.append(getStringRepresentation(scopedNameCS.getTypeCS()));
			buf.append(QvtOperationalTypesUtil.TYPE_NAME_SEPARATOR);
		}
		
		if(scopedNameCS.getName() != null) {			
			buf.append(scopedNameCS.getName());			
		}
		return buf.toString();
	}
	
	public static String getStringRepresentation(TypeCS typeCS) {
		if (typeCS instanceof PrimitiveTypeCS) {
			return ((PrimitiveTypeCS) typeCS).getValue();
		}
		else if (typeCS instanceof PathNameCS) {
			return getStringRepresentation((PathNameCS) typeCS, QvtOperationalTypesUtil.TYPE_NAME_SEPARATOR);
		}
		else if (typeCS instanceof CollectionTypeCS) {
			return ((CollectionTypeCS) typeCS).getCollectionTypeIdentifier().getName() 
					+ "(" + getStringRepresentation(((CollectionTypeCS) typeCS).getTypeCS()) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		else if (typeCS instanceof TupleTypeCS) {
			String name = TupleType.SINGLETON_NAME + "("; //$NON-NLS-1$
			for (VariableCS var : ((TupleTypeCS) typeCS).getVariables()) {
				name += var.getName();
				name += ","; //$NON-NLS-1$
			}
			name += ")"; //$NON-NLS-1$
			return name;
		}
		
		return ""; //$NON-NLS-1$
	}

	public static Set<String> getLibMetamodels(org.eclipse.m2m.qvt.oml.ocl.transformations.Library lib) {
        LinkedHashSet<String> metamodels = new LinkedHashSet<String>();
        metamodels.addAll(Arrays.asList(lib.getInMetamodels()));
        metamodels.addAll(Arrays.asList(lib.getOutMetamodels()));
        
        return metamodels;
	}

	public static void setOwningModule(ImperativeOperation operation, Module module) {
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource(OPERATION_OWNING_MODULE_URI);
		annotation.getReferences().add(module);
	
		operation.getEAnnotations().add(annotation);
	}
	
	public static Module getOwningModule(ImperativeOperation operation) {
		if(operation.getEContainingClass() instanceof Module) {
			return (Module) operation.getEContainingClass();
		}
		EAnnotation annotation = operation.getEAnnotation(OPERATION_OWNING_MODULE_URI);		
		if(annotation != null) {
			for (EObject referredObj : annotation.getReferences()) {
				if(referredObj instanceof Module) {
					return (Module)referredObj;
				}
			}
		}
		return null; 
	}
	
	
	public static List<EOperation> getOwnedOperations(Module module) {
		EAnnotation annotation = module.getEAnnotation(MODULE_OWNED_OPERATION_URI);
		if(annotation == null) {
			return module.getEOperations();
		}
		
		List<EOperation> result = new ArrayList<EOperation>(annotation.getReferences().size());
		result.addAll(module.getEOperations());
		
		for (EObject referredObj : annotation.getReferences()) {
			if(referredObj instanceof EOperation) {
				result.add((EOperation) referredObj);
			}
		}
		
		return result;
	}
	
	
	public static void addOwnedOperations(Module module, ImperativeOperation operation) {
		EAnnotation annotation = module.getEAnnotation(MODULE_OWNED_OPERATION_URI);
		if(annotation == null) {
			annotation = EcoreFactory.eINSTANCE.createEAnnotation();
			annotation.setSource(MODULE_OWNED_OPERATION_URI);
			module.getEAnnotations().add(annotation);
		}
		
		annotation.getReferences().add(operation);
		setOwningModule(operation, module);
	}
	

	public static void collectAllImports(Module module, Set<Module> result) {
		for (ModuleImport imp : module.getModuleImport()) {
			if (imp == null || imp.getImportedModule() == null) {
				continue;
			}
			if (!result.contains(imp.getImportedModule())) {
				collectAllImports(imp.getImportedModule(), result);
			}
			result.add(imp.getImportedModule());
		}
	}


	public static boolean validateNameClashing(String name, EClassifier returnType, EClassifier contextType,
			QvtOperationalEnv env, CSTNode cstNode) {
		if (env.lookupProperty(returnType, name) != null) {
			// should report a warning
			// env.reportError(ValidationMessages.getString("SemanticUtil.11",
			// new Object[] {name, returnType}), cstNode); //$NON-NLS-1$
			// return false;
		}

		if (contextType != null) {
			if (env.lookupProperty(contextType, name) != null) {
				env.reportError(NLS.bind(ValidationMessages.SemanticUtil_13,
						new Object[] { name, QvtOperationalTypesUtil.getTypeFullName(contextType) }),
						cstNode);
				return false;
			}
		}

		return true;
	}

	public static boolean validateLocalProperty(LocalProperty prop, QvtOperationalFileEnv env) {
		if (env.lookupLocal(prop.getName()) != null) {
			env.reportError(NLS.bind(ValidationMessages.SemanticUtil_15, new Object[] { prop.getName() }), prop
					.getStartPosition(), prop.getEndPosition());
			return false;
		}

		if (prop.getEType() == null) {
			prop.setEType(prop.getExpression().getType());
		}

		// TODO
		// if (!validateNameClashing(prop.getName(),
		// mapping.getDeclaration().getContextType(),
		// mapping.getDeclaration().getReturnType(), log, pos)) {
		// return;
		// }

		EClassifier realType = prop.getExpression().getType();
		EClassifier declaredType = prop.getEType();
		if (!isAssignableToFrom(env, declaredType, realType)) {
			env.reportError(NLS.bind(ValidationMessages.SemanticUtil_17,
					new Object[] { QvtOperationalTypesUtil.getTypeFullName(declaredType), QvtOperationalTypesUtil.getTypeFullName(realType) }),
					prop.getStartPosition(), prop.getEndPosition());
		}

		return true;
	}

	public static boolean validateInitVariable(VariableInitExp varInit, QvtOperationalEnv env) {
		if (env.lookupLocal(varInit.getName()) != null) {
			env.reportError(NLS.bind(ValidationMessages.SemanticUtil_15, new Object[] { varInit.getName() }),
					varInit.getStartPosition(), varInit.getEndPosition());
			return false;
		}

		if (varInit.getType() == null) {
			varInit.setType(varInit.getValue().getType());
		}

		// TODO
		// if (!validateNameClashing(varInit.getName(),
		// mapping.getDeclaration().getContextType(),
		// mapping.getDeclaration().getReturnType(), log, pos)) {
		// return;
		// }

		EClassifier realType = varInit.getValue().getType();
		EClassifier declaredType = varInit.getType();
		if (!isAssignableToFrom(env, declaredType, realType)) {
			env.reportError(NLS.bind(ValidationMessages.SemanticUtil_17,
					new Object[] { QvtOperationalTypesUtil.getTypeFullName(declaredType), QvtOperationalTypesUtil.getTypeFullName(realType) }),
					varInit.getStartPosition(), varInit.getEndPosition());
		}

		return true;
	}

	public static boolean isAssignableToFrom(QvtOperationalEnv env, EClassifier variableType,
			EClassifier initialiserType) {
		if (variableType == null)
			return false;
		if (initialiserType == null)
			return false;
		
		// handle primitive types
		if (variableType == env.getOCLStandardLibrary().getUnlimitedNatural()) {
			if (initialiserType == env.getOCLStandardLibrary().getInteger()) {
				return true;
			}
		}
		
		return (TypeUtil.getRelationship(env, variableType, initialiserType) & UMLReflection.SUPERTYPE) != 0;
	}

	public static boolean isAssignableElementToFrom(EClassifier variableType, EClassifier initialiserType) {
		if (variableType == null)
			return false;
		if (initialiserType == null)
			return false;
		if (variableType == initialiserType)
			return true;
		if ((initialiserType instanceof EClass) && (variableType instanceof EClass)
				&& ((EClass) variableType).isSuperTypeOf((EClass) initialiserType))
			return true;
		return false;
	}

	/**
	 * Get the module simple name as the last element of possible qualified
	 * name.
	 * 
	 * @return the name string or empty string, of the module name sequence is
	 *         empty
	 */
	public static String getMappingModuleSimpleName(TransformationHeaderCS headerCS) {
		EList<String> moduleName = headerCS.getPathNameCS().getSequenceOfNames();
		if (moduleName.isEmpty()) {
			return ""; //$NON-NLS-1$
		}
		return moduleName.get(moduleName.size() - 1);
	}
	
	public static boolean hasSimpleName(TransformationHeaderCS headerCS) {
		if(headerCS.getPathNameCS() != null) {
			return headerCS.getPathNameCS().getSequenceOfNames().size() <= 1;
		}
		return false;
	}	
	
	public static String getMappingModuleQualifiedName(TransformationHeaderCS headerCS) {
		String namespace = getMappingModuleNamespace(headerCS);
		if(namespace == null || namespace.length() == 0) {
			return getMappingModuleSimpleName(headerCS);
		}
		return namespace + NAMESPACE_SEPARATOR + getMappingModuleSimpleName(headerCS);
	}
	
	/**
	 * @return dot separated namespace or empty string.
	 */
	public static String getMappingModuleNamespace(TransformationHeaderCS headerCS) {
		StringBuilder unitNamespace = new StringBuilder();
		EList<String> moduleName = headerCS.getPathNameCS().getSequenceOfNames();
		if (moduleName.size() > 1) {
			for (int i = 0, sz = moduleName.size(); i < sz - 1; i++) {
				if (i > 0) {
					unitNamespace.append(NAMESPACE_SEPARATOR);
				}
				unitNamespace.append(moduleName.get(i));
			}
		}
		return unitNamespace.toString();
	}

	public static boolean isTypeCast(final EOperation operation) {
		if (operation != null) {
			return PredefinedType.OCL_AS_TYPE_NAME.equals(operation.getName());
		}
		return false;
	}

	public static boolean isIncorrectCast(final EClassifier sourceType, final EClassifier targetType) {
		if (sourceType == null || targetType == null) {
			return false; // error should be reported in this case, not
			// warning
		}
		if (sourceType instanceof PrimitiveType
				&& PrimitiveType.REAL_NAME.equals(((PrimitiveType) sourceType).getName())) {
			return targetType instanceof PrimitiveType
					&& PrimitiveType.INTEGER_NAME.equals(((PrimitiveType) targetType).getName());
		}
		if (sourceType instanceof SetType) {
			return !(targetType instanceof SetType);
		}
		if (sourceType instanceof BagType) {
			return !(targetType instanceof BagType);
		}
		if (sourceType instanceof SequenceType) {
			return !(targetType instanceof SequenceType);
		}
		if (sourceType instanceof OrderedSetType) {
			return !(targetType instanceof OrderedSetType || targetType instanceof SetType);
		}
		return false;
	}

	public static boolean validateAssignment(String leftName, EClassifier leftType,
			OCLExpression<EClassifier> right, boolean isIncremental, CSTNode cstNode, QvtOperationalEnv env) {
		if (isIncremental) {
			if (leftType instanceof CollectionType == false) {
				env.reportError(NLS.bind(ValidationMessages.SemanticUtil_3, new Object[] { leftName }), cstNode);
				return false;
			}

			EClassifier baseType = ((CollectionType) leftType).getElementType();
			EClassifier actualType = right.getType();
			if (actualType instanceof CollectionType) {
				actualType = ((CollectionType) actualType).getElementType();
			}

			if (!QvtOperationalParserUtil.isAssignableToFrom(env, baseType, actualType)) {
				env.reportError(NLS.bind(ValidationMessages.SemanticUtil_5, 
						new Object[] { leftName, QvtOperationalTypesUtil.getTypeFullName(baseType),
							QvtOperationalTypesUtil.getTypeFullName(actualType) }), cstNode);
				return false;
			}
		} else {
			EClassifier actualType = right.getType();
			if (!QvtOperationalParserUtil.isAssignableToFrom(env, leftType, actualType)) {
				env.reportError(NLS.bind(ValidationMessages.SemanticUtil_8, new Object[] { leftName,
				        QvtOperationalTypesUtil.getTypeFullName(leftType),
				        QvtOperationalTypesUtil.getTypeFullName(actualType) }), cstNode);
				return false;
			}
		}

		return true;
	}

	/**
	 * Checks if the given variable is allowed to be modified, reports an error in
	 * case it is not.
	 * 
	 * @param variable
	 *            the variable to be assigned a value or indirectly modified through
	 *            an owned property
	 * @param varPathNameNodeCS
	 *            the pathname representing the left side of an assignment. It can be a simple name
	 *            representing a variable direct access or a path navigating to owned property.
	 *             
	 * @return <code>true</code> if it can be modified, <code>false</code>
	 *         otherwise.
	 */
	public static boolean validateVariableModification(Variable<EClassifier, EParameter> variable,
			PathNameCS varPathNameNodeCS, QvtOperationalEnv env) {
		EParameter representedParameter = variable.getRepresentedParameter();
		if (representedParameter instanceof VarParameter) {
			VarParameter parameter = (VarParameter) representedParameter;
			// detect whether an [inout] parameter variable is to be assigned a new value 
			boolean isDirectInoutModification = parameter.getKind() == DirectionKind.INOUT && varPathNameNodeCS.getSequenceOfNames().size() == 1;				
			if(isDirectInoutModification) {
				env.reportError(NLS.bind(ValidationMessages.QvtOperationalParserUtil_inoutParamAssignmentError, parameter.getName()),
						varPathNameNodeCS);
				return false;
			}
			
			if (parameter.getKind() != DirectionKind.OUT && parameter.getKind() != DirectionKind.INOUT) {
				env.reportError(NLS.bind(ValidationMessages.inputParameterModificationError, parameter.getName()),
						varPathNameNodeCS);
				return false;
			}
		}
		if (representedParameter instanceof Property) {
			env.reportError(NLS.bind(ValidationMessages.readOnlyPropertyModificationError, variable.getName()),
					varPathNameNodeCS);
			return false;
		}
		return true;
	}

	public static EOperation getMainMethod(Module module) {
		MAIN:
		for (Iterator<EOperation> ruleIt = module.getEOperations().iterator(); ruleIt.hasNext();) {
			ImperativeOperation method = (ImperativeOperation) ruleIt.next();

			if (!QvtOperationalEnv.MAIN.equals(method.getName())) {
				continue;
			}

			for (EParameter param : method.getEParameters()) {
				if (param.getEType() == null) {
					continue MAIN;
				}
			}

			if (method.getContext() != null && method.getContext().getEType() == null) {
				continue;
			}

			return method;
		}

		return null;
	}

	public static PackageRef[] getRequiredMetamodelIds(Module module) {
		class Traverser {
			void getMetamodelIds(Module module, Set<PackageRef> ids) {
				for (ModelType modelType : module.getUsedModelType()) {
					ids.addAll(modelType.getMetamodel());
				}

				for (ModuleImport importedModule : module.getModuleImport()) {
					getMetamodelIds(importedModule.getImportedModule(), ids);
				}
			}
		}

		final Set<PackageRef> ids = new LinkedHashSet<PackageRef>();
		new Traverser().getMetamodelIds(module, ids);
		return ids.toArray(new PackageRef[ids.size()]);
	}

	public static boolean isOverloadableMapping(final EOperation op, final QvtOperationalEnv env) {
		EObject context = op.eContainer();
		if (env.getUMLReflection().getOwningClassifier(op) instanceof Module) {
			// no context to overload
			return false;
		}
		return context instanceof EClass;
	}
	
	public static boolean isTypeEquals(QvtOperationalEnv env, EClassifier type, EClassifier otherType) {
		return isAssignableToFrom(env, type, otherType) && isAssignableToFrom(env, otherType, type);
	}

	private static boolean isOperationEquals(final ImperativeOperation imperativeOp, final EOperation otherOp,
			final EClassifier context, final QvtOperationalEnv env) {
        if (!imperativeOp.getName().equals(otherOp.getName())) {
            return false;
        }
        List<EParameter> parameters1 = imperativeOp.getEParameters();
        List<EParameter> parameters2 = otherOp.getEParameters();
        if (parameters1.size() != parameters2.size()) {
            return false;
        }
        
        for (int i = 0; i < parameters1.size(); i++) {
        	EClassifier type = parameters1.get(i).getEType();
            EClassifier otherType = parameters2.get(i).getEType();
            if (!isTypeEquals(env, type, otherType)) {
                return false;
            }
        }
        
        EClassifier contextType = getContextualType(imperativeOp);
        if(contextType == null) {
        	return contextType == context;
        }
        return isTypeEquals(env, contextType, context);
	}

	public static Module getOutermostDefiningModule(final Module module, final EOperation ctxOp,
			final EClassifier context, final QvtOperationalEnv env) {
		final Module[] result = { null };
		VertexProcessor processor = new VertexProcessor() {
			public boolean process(Object node) {
				Module module = (Module) node;
				if (findMappingMethod(module, ctxOp, context, env) != null) {
					result[0] = module;
					return true;
				}
				return false;
			}
		};
		new GraphWalker(IMPORT_NODE_PROVIDER).walkBreadthFirst(module, processor);
		return result[0];
	}

	public static Module getInnermostDefiningModule(final Module module, final EOperation ctxOp,
			final EClassifier context, final QvtOperationalEnv env) {
		final Module[] result = { null };
		VertexProcessor processor = new VertexProcessor() {
			public boolean process(Object node) {
				Module mod = (Module) node;
				if (findMappingMethod(mod, ctxOp, context, env) != null) {
					result[0] = mod;
				}
				return false;
			}
		};
		new GraphWalker(IMPORT_NODE_PROVIDER).walkBreadthFirst(module, processor);
		return result[0];
	}

	public static ImperativeOperation findMappingMethod(final Module module, final EOperation signature,
			final EClassifier context, final QvtOperationalEnv env) {
		for (EOperation op : QvtOperationalParserUtil.getOwnedOperations(module)) {
			if(op instanceof ImperativeOperation == false) {
				continue;
			}
			ImperativeOperation cur = (ImperativeOperation) op;
			if (isOperationEquals(cur, signature, context, env)) {
				return cur;
			}
		}
		return null;
	}

	private static final NodeProvider IMPORT_NODE_PROVIDER = new NodeProvider() {
		public Object[] getLinkedNodes(Object node) {
			Module module = (Module) node;
			if (module.getModuleImport().isEmpty()) {
				return new Module[0];
			}

			List<Module> importedModules = new ArrayList<Module>();
			for (ListIterator<ModuleImport> impIt = module.getModuleImport().listIterator(
					module.getModuleImport().size()); impIt.hasPrevious();) {
				ModuleImport importedModule = impIt.previous();
				importedModules.add(importedModule.getImportedModule());
			}

			return importedModules.toArray(new Module[0]);
		}
	};

	public static String safeGetMappingQualifiedName(QvtOperationalEnv env, MappingOperation mappingOperation) {
		if(mappingOperation != null) {
			StringBuilder buf = new StringBuilder();			
			EClassifier ctxType = getContextualType(mappingOperation);
			
			if(ctxType != null) {
				buf.append(safeGetQualifiedName(env, ctxType));
				buf.append(QvtOperationalTypesUtil.TYPE_NAME_SEPARATOR);
			}
			
			if(mappingOperation.getName() != null) {
				buf.append(mappingOperation.getName());
			}
			
			return buf.toString();			
		}
		return ""; //$NON-NLS-1$
	}
	
	/**
	 * Null-safe variant of {@link UMLReflection#getQualifiedName(Object)}
	 * operation.
	 * 
	 * @param type
	 *            a classifier that may be <code>null</code>
	 * @param defaultValue
	 *            the default value if a non-null can not be derived
	 * @return the name, or <code>defaultValue</code> if a non-null name can not be
	 *         derived
	 */	
	public static String safeGetQualifiedName(QvtOperationalEnv env, EClassifier type, String defaultValue) {
		if(type == null) {
			return defaultValue;
		}
		
		String result = defaultValue;
		if(type.getEPackage() == null) {
			result = env.getUMLReflection().getName(type);
		}
		else {
			try {
				result = env.getUMLReflection().getQualifiedName(type);
			} catch(RuntimeException e) {
				result = env.getUMLReflection().getName(type);
			}
		}

		return result != null ? result : defaultValue;
	}
	
	/**
	 * Null-safe variant of {@link UMLReflection#getQualifiedName(Object)}
	 * operation.
	 * 
	 * @param type
	 *            a classifier that may be <code>null</code>
	 * @return the name, or empty string if a non-null name can not be derived
	 */		
	public static String safeGetQualifiedName(QvtOperationalEnv env, EClassifier type) {
		return safeGetQualifiedName(env, type, ""); //$NON-NLS-1$
	}
	
	public static <T> T findParentElement(ReturnExp returnExp, Class<T> type) {
		T result = null;
		EObject parent = returnExp.eContainer();
		while(parent != null) {			
			if(type.isInstance(parent)) {
				result = (T) type.cast(parent);
				break;
			}
			parent = parent.eContainer();
		}
		return result;
	}
	
	public static void markAsAbstractMappingOperation(MappingOperation mappingOperation) {
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource(QVT_NAMESPACE_URI);
		annotation.getDetails().put(QVT_IS_ABSTACT, Boolean.toString(true));
		mappingOperation.getEAnnotations().add(annotation);
	}
	
	public static boolean isAbstractMappingOperation(MappingOperation mappingOperation) {
		EAnnotation annotation = mappingOperation.getEAnnotation(QVT_NAMESPACE_URI);
		if(annotation != null) {
			String value = annotation.getDetails().get(QVT_IS_ABSTACT);
			return Boolean.valueOf(value);
		}
		return false;
	}
	
	public static CSTNode getImperativeOperationProblemNode(MappingMethodCS methodCS) {
		MappingDeclarationCS mappingDeclCS = methodCS.getMappingDeclarationCS();
		if(mappingDeclCS != null) {
			if(mappingDeclCS.getSimpleNameCS() != null) {
				return mappingDeclCS.getSimpleNameCS();
			}
			
			if(mappingDeclCS.getContextType() != null) {
				return mappingDeclCS.getContextType();
			}
		}
		return methodCS;
	}
	
	public static <T> Collection<T> selectDuplicateQualifiers(List<T> elements) {
		Set<T> result = null;
		for (T nextQualifier : elements) {
			if(Collections.frequency(elements, nextQualifier) > 1) {
				if(result == null) {
					result = new HashSet<T>(2);   
				}
				
				result.add(nextQualifier);
			}
		} 
		return (result != null) ? result : Collections.<T>emptySet();
	}
}