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
package org.eclipse.m2m.qvt.oml.internal.ast.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalFileEnv;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalTypesUtil;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.expressions.LocalProperty;
import org.eclipse.m2m.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.qvt.oml.expressions.PackageRef;
import org.eclipse.m2m.qvt.oml.expressions.Property;
import org.eclipse.m2m.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.qvt.oml.expressions.VariableInitExp;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.GraphWalker;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.GraphWalker.NodeProvider;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.GraphWalker.VertexProcessor;
import org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.internal.cst.CSTNode;
import org.eclipse.ocl.internal.cst.CollectionTypeCS;
import org.eclipse.ocl.internal.cst.PathNameCS;
import org.eclipse.ocl.internal.cst.PrimitiveTypeCS;
import org.eclipse.ocl.internal.cst.TupleTypeCS;
import org.eclipse.ocl.internal.cst.TypeCS;
import org.eclipse.ocl.internal.cst.VariableCS;
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

	private QvtOperationalParserUtil() {
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

	public static Set<String> getLibMetamodels(org.eclipse.m2m.qvt.oml.ocl.emf.transformations.Library lib) {
        LinkedHashSet<String> metamodels = new LinkedHashSet<String>();
        metamodels.addAll(Arrays.asList(lib.getInMetamodels()));
        metamodels.addAll(Arrays.asList(lib.getOutMetamodels()));
        
        return metamodels;
	}

	public static void defineImportedConfigProperties(Module module, QvtOperationalFileEnv env) {
		Set<Module> imports = new LinkedHashSet<Module>();
		collectAllImports(module, imports);
		for (Module imported : imports) {
			List<Property> properties = imported.getConfigProperty();
			for (Iterator<Property> iter = properties.iterator(); iter.hasNext();) {
				Property property = iter.next();
				env.addPropertyVariable(property);
			}
		}
	}

	private static void collectAllImports(Module module, Set<Module> result) {
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

	public static void defineImportedOperations(Module module, QvtOperationalFileEnv env) {
		Set<Module> imports = new LinkedHashSet<Module>();
		collectAllImports(module, imports);
		for (Module imported : imports) {
			defineLocalOperations(imported, env);
		}
	}

	private static void defineLocalOperations(Module module, QvtOperationalFileEnv env) {
		for (Iterator<EOperation> iter = module.getEOperations().iterator(); iter.hasNext();) {
			ImperativeOperation operation = (ImperativeOperation) iter.next();
			env.defineImperativeOperation(operation, operation instanceof MappingOperation, false);
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
		return getMappingModuleNamespace(headerCS) + NAMESPACE_SEPARATOR + getMappingModuleSimpleName(headerCS);
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
				env.reportError(NLS.bind(ValidationMessages.SemanticUtil_5, new Object[] { leftName, baseType,
						actualType }), cstNode);
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

	public static boolean validateVariableModification(Variable<EClassifier, EParameter> variable,
			CSTNode cstNode, QvtOperationalEnv env) {
		EParameter representedParameter = variable.getRepresentedParameter();
		if (representedParameter instanceof VarParameter) {
			VarParameter parameter = (VarParameter) representedParameter;
			if (parameter.getKind() != DirectionKind.OUT && parameter.getKind() != DirectionKind.INOUT) {
				env.reportError(NLS.bind(ValidationMessages.inputParameterModificationError, parameter.getName()),
						cstNode);
				return false;
			}
		}
		if (representedParameter instanceof Property) {
			env.reportError(NLS.bind(ValidationMessages.readOnlyPropertyModificationError, variable.getName()),
					cstNode);
			return false;
		}
		return true;
	}

	public static EOperation getMainMethod(Module module) {
		MAIN:
		for (Iterator<EOperation> ruleIt = module.getEOperations().iterator(); ruleIt.hasNext();) {
			ImperativeOperation method = (ImperativeOperation) ruleIt.next();

			if (!QvtOperationalUtil.MAIN_METHOD_NAME.equals(method.getName())) {
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
	
	private static boolean isOclVoid(final EModelElement context, final QvtOperationalEnv env) {
		QvtOperationalEnv realEnv = (env == null ? env.getFactory().createEnvironment(null, null) : env);
		if (context == realEnv.getOCLStandardLibrary().getOclVoid()) {
			return true;
		}
		EAnnotation ann = context.getEAnnotation(Environment.OCL_NAMESPACE_URI);
		if (ann != null && ann.getReferences().contains(realEnv.getOCLStandardLibrary().getOclVoid())) {
			return true;
		}
		return false;
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
        
        return isTypeEquals(env, imperativeOp.getContext().getEType(), context);
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
		for (EOperation op : module.getEOperations()) {
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

}