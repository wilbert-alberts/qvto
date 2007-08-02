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
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalFileEnv;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalTypesUtil;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.qvt.oml.compiler.ParsedModuleCS;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.EmfMmUtil;
import org.eclipse.m2m.qvt.oml.expressions.AssignExp;
import org.eclipse.m2m.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.qvt.oml.expressions.ExpressionsFactory;
import org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.qvt.oml.expressions.Helper;
import org.eclipse.m2m.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.expressions.Library;
import org.eclipse.m2m.qvt.oml.expressions.LocalProperty;
import org.eclipse.m2m.qvt.oml.expressions.MappingBody;
import org.eclipse.m2m.qvt.oml.expressions.MappingCallExp;
import org.eclipse.m2m.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.qvt.oml.expressions.MappingParameter;
import org.eclipse.m2m.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.qvt.oml.expressions.ObjectExp;
import org.eclipse.m2m.qvt.oml.expressions.PackageRef;
import org.eclipse.m2m.qvt.oml.expressions.Property;
import org.eclipse.m2m.qvt.oml.expressions.Rename;
import org.eclipse.m2m.qvt.oml.expressions.ResolveExp;
import org.eclipse.m2m.qvt.oml.expressions.ResolveInExp;
import org.eclipse.m2m.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.qvt.oml.expressions.VariableInitExp;
import org.eclipse.m2m.qvt.oml.expressions.WhileExp;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.GraphWalker;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.GraphWalker.NodeProvider;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.GraphWalker.VertexProcessor;
import org.eclipse.m2m.qvt.oml.internal.cst.AssignStatementCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ConfigPropertyCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ExpressionStatementCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ImportCS;
import org.eclipse.m2m.qvt.oml.internal.cst.LibraryCS;
import org.eclipse.m2m.qvt.oml.internal.cst.LibraryImportCS;
import org.eclipse.m2m.qvt.oml.internal.cst.LocalPropertyCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingCallExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingInitCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingMethodCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingQueryCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingRuleCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingSectionCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ModulePropertyCS;
import org.eclipse.m2m.qvt.oml.internal.cst.OutExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.PackageRefCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ParameterDeclarationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.RenameCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ResolveExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ResolveInExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.StatementCS;
import org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS;
import org.eclipse.m2m.qvt.oml.internal.cst.VariableInitializationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.WhileExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.adapters.CSTBindingUtil;
import org.eclipse.m2m.qvt.oml.internal.cst.adapters.ModelTypeMetamodelsAdapter;
import org.eclipse.m2m.qvt.oml.internal.cst.temp.ErrorCallExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.temp.ErrorVariableInitializationCS;
import org.eclipse.m2m.qvt.oml.library.QvtLibraryRegistry;
import org.eclipse.m2m.qvt.oml.ocl.emf.OclEmfPlugin;
import org.eclipse.m2m.qvt.oml.ocl.emf.transformations.LibraryCreationException;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.internal.cst.CSTNode;
import org.eclipse.ocl.internal.cst.CallExpCS;
import org.eclipse.ocl.internal.cst.DotOrArrowEnum;
import org.eclipse.ocl.internal.cst.OCLExpressionCS;
import org.eclipse.ocl.internal.cst.OperationCallExpCS;
import org.eclipse.ocl.internal.cst.PathNameCS;
import org.eclipse.ocl.internal.cst.SimpleNameCS;
import org.eclipse.ocl.internal.cst.StringLiteralExpCS;
import org.eclipse.ocl.internal.cst.TypeCS;
import org.eclipse.ocl.internal.cst.VariableCS;
import org.eclipse.ocl.internal.cst.VariableExpCS;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.internal.parser.OCLLexer;
import org.eclipse.ocl.internal.parser.OCLParser;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.osgi.util.NLS;

public class QvtOperationalVisitorCS
		extends
		OCLParser<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> {

    private final Set<String> myLoadedLibraries = new HashSet<String>(1);
    
    private boolean createASTBinding = false;

	public QvtOperationalVisitorCS(
			OCLLexer lexStream,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> environment) {
		super(lexStream, environment);
	}

	private EClassifier visitTypeCS(TypeCS typeCS, QvtOperationalEnv env) throws SemanticException {
		EClassifier type = typeCS(typeCS, env);
		if (type == null) {
			env.reportError(NLS.bind(ValidationMessages.UnknownClassifierType, new Object[] {
					QvtOperationalParserUtil.getStringRepresentation(typeCS)}),
					typeCS);
		}
		return type;
	}

	private String visitLiteralExpCS(StringLiteralExpCS stringLiteralExpCS, QvtOperationalEnv env)
			throws SemanticException {
		return stringLiteralExpCS(stringLiteralExpCS, env).getStringSymbol();
	}

	@Override
	protected OCLExpression<EClassifier> oclExpressionCS(
			OCLExpressionCS oclExpressionCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env)
			throws SemanticException {
		if (oclExpressionCS instanceof WhileExpCS) {
			return visitWhileExpCS((WhileExpCS) oclExpressionCS, (QvtOperationalEnv) env);
		}
		if (oclExpressionCS instanceof OutExpCS) {
			return visitOutExpCS((OutExpCS) oclExpressionCS, (QvtOperationalEnv) env);
		}
		if (oclExpressionCS instanceof PatternPropertyExpCS) {
			return visitPatternPropertyExpCS((PatternPropertyExpCS) oclExpressionCS, (QvtOperationalEnv) env);
		}
		if (oclExpressionCS instanceof AssignStatementCS) {
			return visitAssignStatementCS((AssignStatementCS) oclExpressionCS, (QvtOperationalEnv) env);
		}
		if (oclExpressionCS instanceof VariableInitializationCS) {
			return visitVariableInitializationCS((VariableInitializationCS) oclExpressionCS, (QvtOperationalEnv) env);
		}
		if (oclExpressionCS instanceof ExpressionStatementCS) {
			return visitExpressionStatementCS((ExpressionStatementCS) oclExpressionCS, (QvtOperationalEnv) env);
		}
        if (oclExpressionCS instanceof ResolveInExpCS) {
            return visitResolveInExpCS((ResolveInExpCS) oclExpressionCS, (QvtOperationalEnv) env);
        }
        if (oclExpressionCS instanceof ResolveExpCS) {
            return visitResolveExpCS((ResolveExpCS) oclExpressionCS, (QvtOperationalEnv) env);
        }

		OCLExpression<EClassifier> expr = null;
		try {
			if (oclExpressionCS instanceof TypeCS) {
				EClassifier type = typeCS((TypeCS) oclExpressionCS, env);
                if (type == null) {
                	((QvtOperationalEnv) env).reportError(OCLMessages.bind(
                            OCLMessages.UnrecognizedType_ERROR_,
                            QvtOperationalTypesUtil.getTypeFullName(type)), oclExpressionCS);
                }
                else {
					TypeExp<EClassifier> typeExp = env.getOCLFactory().createTypeExp();
					typeExp.setReferredType(type);
					typeExp.setType(TypeUtil.resolveTypeType(env, type));
					expr = typeExp;
                }
			}
			else {
				expr = super.oclExpressionCS(oclExpressionCS, env);
			}
		}
		catch (SemanticException ex) {
			((QvtOperationalEnv) env).reportError(ex.getLocalizedMessage(), oclExpressionCS);
		}
		catch (NullPointerException ex) {
			((QvtOperationalEnv) env).reportError(ex.getLocalizedMessage(), oclExpressionCS);
		}
		return expr;
	}
	
    @Override
    protected Variable<EClassifier, EParameter> variableDeclarationCS(VariableCS variableDeclarationCS,
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            boolean addToEnvironment) throws SemanticException {
        Variable<EClassifier, EParameter> varDecl = super.variableDeclarationCS(variableDeclarationCS, env, addToEnvironment);
        if ((varDecl.getType() == null) && (varDecl.getInitExpression() != null)) {
            varDecl.setType(varDecl.getInitExpression().getType());
        }
        
        // AST binding 
        if(createASTBinding) {
        	ASTBindingHelper.createCST2ASTBinding(variableDeclarationCS, varDecl);
        }
        //
        return varDecl;
    }
	
    @Override
    protected OCLExpression<EClassifier> propertyCallExpCS(CallExpCS propertyCallExpCS, 
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env)
            throws SemanticException {
        if (propertyCallExpCS instanceof ErrorCallExpCS) {
            OCLExpressionCS sourceExpCS = propertyCallExpCS.getSource();
            if (sourceExpCS != null) {
                if (propertyCallExpCS.getAccessor() == DotOrArrowEnum.ARROW_LITERAL) {
                    getCollectionSourceExpression(sourceExpCS, env);
                } else {
                    oclExpressionCS(sourceExpCS, env);
                }
            }
            return null;
        }
        OCLExpression<EClassifier> result = super.propertyCallExpCS(propertyCallExpCS, env);
        if(result != null) {
            // AST binding    
            if(createASTBinding) {          
                ASTBindingHelper.createCST2ASTBinding(propertyCallExpCS, result, env);
            }
        }
        return result;
    }

    @Override
    protected OCLExpression<EClassifier> simpleNameCS(
    		SimpleNameCS simpleNameCS,
    		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
    		OCLExpression<EClassifier> source) throws SemanticException {
    	
    	OCLExpression<EClassifier> result = super.simpleNameCS(simpleNameCS, env, source);

        // AST binding    	
        if(createASTBinding) {    	
	    	if(result instanceof VariableExp || result instanceof PropertyCallExp) { 
	    		ASTBindingHelper.createCST2ASTBinding(simpleNameCS, result);
	    	}
        }
    	//
    	
    	return result;
    }
    
    @Override
    protected OCLExpression<EClassifier> variableExpCS(
            VariableExpCS variableExpCS,
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env)
            throws SemanticException {
        OCLExpression<EClassifier> result = super.variableExpCS(variableExpCS, env);

        // AST binding      
        if(createASTBinding) {      
            if(result instanceof VariableExp || result instanceof PropertyCallExp) { 
                ASTBindingHelper.createCST2ASTBinding(variableExpCS, result);
            }
        }
        //
        return result;
    }

    private OCLExpression<EClassifier> visitOclExpressionCS(OCLExpressionCS expressionCS, QvtOperationalEnv env)
			throws SemanticException {
		OCLExpression<EClassifier> result = oclExpressionCS(expressionCS, env);
		if (expressionCS instanceof OperationCallExpCS && result instanceof OperationCallExp) {
			validateOperationCall((OperationCallExpCS) expressionCS,
					(OperationCallExp<EClassifier, EOperation>) result, env);
		}
		if (expressionCS instanceof MappingCallExpCS) {
			if (result instanceof OperationCallExp) {
				MappingCallExp mappingCallExp = createMappingCallExp((MappingCallExpCS) expressionCS, result);
				if (mappingCallExp != null) {
					return mappingCallExp;
				}
			} else if (result instanceof IteratorExp) {
				IteratorExp<EClassifier, EParameter> iteratorExp = (IteratorExp<EClassifier, EParameter>) result;
				MappingCallExp mappingCallExp = createMappingCallExp((MappingCallExpCS) expressionCS, iteratorExp
						.getBody());
				if (mappingCallExp != null) {
					iteratorExp.setBody(mappingCallExp);
					return iteratorExp;
				}
			}
			env.reportError(ValidationMessages.mappingOperationExpected, expressionCS);
			return null;
		}

		return result;
	}

	private OCLExpression<EClassifier> visitWhileExpCS(WhileExpCS expressionCS, QvtOperationalEnv env)
			throws SemanticException {
		WhileExp result = ExpressionsFactory.eINSTANCE.createWhileExp();
		result.setStartPosition(expressionCS.getStartOffset());
		result.setEndPosition(expressionCS.getEndOffset());

		OCLExpression<EClassifier> resExp = visitOclExpressionCS(expressionCS.getResult(), env);
		result.setType(resExp.getType());
		result.setResult(resExp);

		OCLExpression<EClassifier> condExp = visitOclExpressionCS(expressionCS.getCondition(), env);
		result.setCondition(condExp);

		for (OCLExpressionCS oclExpCS : expressionCS.getBodyExpressions()) {
			OCLExpression<EClassifier> bodyExp = visitOclExpressionCS(oclExpCS, env);
			if (bodyExp != null) {
    				result.getBody().add(bodyExp);
			}
		}

		return result;
	}

	private ObjectExp visitOutExpCS(OutExpCS outExpCS, QvtOperationalEnv env) throws SemanticException {
		TypeCS typeCS = getOutExpCSType(outExpCS);
		if (typeCS == null) {
			env.reportError(ValidationMessages.missingTypeError, outExpCS);
			return null;
		}

		EClassifier objectType = visitTypeCS(typeCS, env);
		if (false == objectType instanceof EClass) {
			env.reportError(NLS.bind(ValidationMessages.nonModelTypeError,
					new Object[] { QvtOperationalUtil.getStringRepresentation(typeCS) }), typeCS);
			return null;
		}

		ObjectExp objectExp = ExpressionsFactory.eINSTANCE.createObjectExp();
		objectExp.setStartPosition(outExpCS.getStartOffset());
		objectExp.setEndPosition(outExpCS.getEndOffset());
		if (outExpCS.getSimpleNameCS() != null) {
			objectExp.setName(outExpCS.getSimpleNameCS().getValue());
		}
		objectExp.setType(objectType);
		if (outExpCS.getTypeSpecCS() != null && outExpCS.getTypeSpecCS().getSimpleNameCS() != null) {
			ModelParameter modelParam = env.lookupModelParameter(
					outExpCS.getTypeSpecCS().getSimpleNameCS(), DirectionKind.OUT);
			objectExp.setReferredObject(modelParam);
		}
		if (objectExp.getReferredObject() == null) {
			objectExp.setReferredObject(env.resolveModelParameter(objectType, DirectionKind.OUT));
		}

		for (OCLExpressionCS expCS : outExpCS.getExpressions()) {
			OCLExpression<EClassifier> exp = visitOclExpressionCS(expCS, env);
			if (exp == null) {
				continue;
			}

			if (exp instanceof AssignExp == false) {
				env.reportError(ValidationMessages.propertyAssignmentExpectedError, expCS);
			} else {
				objectExp.getContent().add(exp);
			}
		}

        if(createASTBinding) {          
            ASTBindingHelper.createCST2ASTBinding(outExpCS, objectExp, env);
        }
		
		return objectExp;
	}

	private AssignExp visitPatternPropertyExpCS(PatternPropertyExpCS propCS, QvtOperationalEnv env)
			throws SemanticException {
		OCLExpression<EClassifier> propertyValue = visitOclExpressionCS(propCS.getOclExpressionCS(), env);
		if (propertyValue == null) {
			return null;
		}

		AssignExp result = ExpressionsFactory.eINSTANCE.createAssignExp();
		result.setStartPosition(propCS.getStartOffset());
		result.setEndPosition(propCS.getEndOffset());

		result.getValue().add(propertyValue);
		result.setType(propertyValue.getType());
		result.setIsReset(!propCS.isIncremental());

		EClassifier outType = null;
		EObject eParent = propCS.eContainer();
		if (eParent instanceof OutExpCS) {
			OutExpCS outExpCS = (OutExpCS) eParent;
			TypeCS typeCS = getOutExpCSType(outExpCS);
			outType = visitTypeCS(typeCS, env);
		}

		SimpleNameCS variableName = propCS.getSimpleNameCS();
		String name = variableName.getValue();
		EStructuralFeature property = env.lookupProperty(outType, name);
		if (property == null) {
			env.reportError(NLS.bind(ValidationMessages.noPropertyInTypeError, name, QvtOperationalTypesUtil
					.getTypeFullName(outType)), variableName);
		} else if (!property.isChangeable()) {
			env.reportError(NLS.bind(ValidationMessages.ReadOnlyProperty, name), variableName);
		} else {
			QvtOperationalParserUtil.validateAssignment(property.getName(),
					env.getUMLReflection().getOCLType(property), propertyValue, propCS.isIncremental(),
					propCS.getSimpleNameCS(), env);
		}

		PropertyCallExp<EClassifier, EStructuralFeature> sourceExp =
			org.eclipse.ocl.expressions.ExpressionsFactory.eINSTANCE.createPropertyCallExp();
		sourceExp.setReferredProperty(property);
		result.setLeft(sourceExp);

        // AST binding
        if(createASTBinding) {		
        	ASTBindingHelper.createCST2ASTBinding(propCS, result);
        }
		//		
		
		return result;
	}

	public Module visitMappingModule(ParsedModuleCS parsedModuleCS, QvtOperationalFileEnv env) throws SemanticException {
		MappingModuleCS moduleCS = parsedModuleCS.getModuleCS();
        CSTBindingUtil.bindQvtOperationalEnv(moduleCS, env);
        Module module = env.getModule(moduleCS);
        if (module != null) {
            return module;
        }        
		module = env.createModule(moduleCS, createASTBinding, env, parsedModuleCS);
		module.setStartPosition(moduleCS.getStartOffset());
		module.setEndPosition(moduleCS.getEndOffset());

		for (ModelTypeCS modelTypeCS : moduleCS.getMetamodels()) {
			ModelType modelType = visitModelTypeCS(modelTypeCS, env, module);
			if (modelType == null) {
				continue;
			}
			module.getUsedModelType().add(modelType);
			if (modelType.getName().length() > 0) {
				env.registerModelType(modelType, true);
			}
			else {
				env.registerModelType(modelType, false);
				env.reportWarning(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_modeltypeDeprecatedSyntax, new Object[] { }),
						modelTypeCS);
			}
		}

		visitTransformationHeaderCS(moduleCS.getHeaderCS(), env, module);
		
		for (ImportCS libImport : moduleCS.getImports()) {
			if (false == libImport instanceof LibraryImportCS) {
				continue;
			}
			PathNameCS impPath = libImport.getPathNameCS();
			String libId = QvtOperationalParserUtil.getStringRepresentation(impPath, "."); //$NON-NLS-1$

			org.eclipse.m2m.qvt.oml.ocl.emf.transformations.Library lib = OclEmfPlugin.getDefault().getLibrariesRegistry().getLibrary(libId);
			if (lib == null) {
				lib = QvtLibraryRegistry.getInstance().getQvtLibrary(libId);
			}
			            
			if (lib == null) {
				env.reportError(NLS.bind(ValidationMessages.NoLibrary, new Object[] {libId}),
						impPath);
				continue;
			}

			for (ModuleImport moduleImp : module.getModuleImport()) {
				if (false == moduleImp.getImportedModule() instanceof Library) {
					continue;
				}
				if (((Library) moduleImp.getImportedModule()).getLibrary() == lib) {
					env.reportWarning(NLS.bind(ValidationMessages.DuplicateLibraryImport, new Object[] { libId }),
							impPath);
					continue;
				}
			}

			Set<String> libMetamodels = QvtOperationalParserUtil.getLibMetamodels(lib);
			Set<EPackage> usedMetamodels = getUsedMetamodels(module);
			Set<String> usedMetamodelUri = new HashSet<String>(usedMetamodels.size());
			for (EPackage usedMetamodel : usedMetamodels) {
				usedMetamodelUri.add(usedMetamodel.getNsURI());
			}
			if (!usedMetamodelUri.containsAll(libMetamodels)) {
				LinkedHashSet<String> missingMetamodels = new LinkedHashSet<String>(libMetamodels);
				missingMetamodels.removeAll(usedMetamodelUri);
				env.reportError(NLS.bind(ValidationMessages.MissingMetamodelsRequiredByLibrary, new Object[] {
						libId, missingMetamodels }), impPath);
				continue;
			}

			if (!myLoadedLibraries.contains(libId)) {
				try {
					lib.loadOperations();
					env.registerLibrary(lib);
				} catch (LibraryCreationException e) {
					env.reportError(NLS.bind(ValidationMessages.FailedToLoadLibrary, new Object[] { libId,
							e.getMessage() }), impPath);
				}
				myLoadedLibraries.add(libId);
			}

			ModuleImport imp = ExpressionsFactory.eINSTANCE.createModuleImport();
			Library newLib = ExpressionsFactory.eINSTANCE.createLibrary();
			newLib.setName(libId);
			newLib.setLibrary(lib);
			newLib.setStartPosition(impPath.getStartOffset());
			newLib.setEndPosition(impPath.getEndOffset());
			imp.setStartPosition(libImport.getStartOffset());
			imp.setEndPosition(libImport.getEndOffset());
			imp.setImportedModule(newLib);
			module.getModuleImport().add(imp);
		}

		for (ParsedModuleCS importedModuleCS : parsedModuleCS.getParsedImports()) {
			// Check for duplicate imports is handled by QvtCompiler
			Module importedModule = env.getCompiler().analyse(importedModuleCS, createASTBinding, env).getModule().getModule();
			if (importedModule == null) {
				continue;
			}

			ModuleImport imp = ExpressionsFactory.eINSTANCE.createModuleImport();
			// imp.setStartPosition(libImport.getStartOffset());
			// imp.setEndPosition(libImport.getEndOffset());
			imp.setImportedModule(importedModule);
			module.getModuleImport().add(imp);
		}

		for (RenameCS renameCS : moduleCS.getRenamings()) {
			Rename rename = visitRenameCS(renameCS, env);
			if (rename != null) {
				module.getOwnedRenaming().add(rename);
			}
		}
		QvtOperationalParserUtil.defineImportedConfigProperties(module, env);

		for (ModulePropertyCS propCS : moduleCS.getProperties()) {
			if (moduleCS instanceof LibraryCS && propCS instanceof LocalPropertyCS) {
				env.reportError(ValidationMessages.Local_properties_are_not_allowed_in_libraries, propCS);
				continue;
			}
			Property prop = visitModulePropertyCS(propCS, env);
			if (prop != null) {
				module.getConfigProperty().add(prop);
			}
		}

		// define local and imported operations as they are required to analyze rules' contents
		env.setErrorRecordFlag(false);
		for (MappingMethodCS methodCS : moduleCS.getMethods()) {
			ImperativeOperation operation = ExpressionsFactory.eINSTANCE.createImperativeOperation();
			if (visitMappingDeclarationCS(methodCS.getMappingDeclarationCS(), env, operation)) {
				env.setErrorRecordFlag(true);
				EOperation envOperation = env.defineImperativeOperation(operation, methodCS instanceof MappingRuleCS, true);
				env.setErrorRecordFlag(false);
				
	            // AST binding
		        if(createASTBinding && envOperation != null) {
					ASTBindingHelper.createEnvDefined2ImperativeOperationBinding(methodCS, operation, envOperation, env);
				} 
				//				
			}
		}
		env.setErrorRecordFlag(true);
		
		QvtOperationalParserUtil.defineImportedOperations(module, env);

		for (MappingMethodCS methodCS : moduleCS.getMethods()) {
			ImperativeOperation operation = visitMappingMethodCS(methodCS, env);
			if (operation != null) {
				module.getEOperations().add(operation);
				checkReturnTypeConformance(operation, 
						(methodCS.getMappingDeclarationCS().getReturnType() != null) ?
								methodCS.getMappingDeclarationCS().getReturnType() : 
									methodCS.getMappingDeclarationCS(), env);
			}
		}
		
		env.resolveResolveInExpInMappings();
		
		module.setEntry(QvtOperationalParserUtil.getMainMethod(module));

		return module;
	}

	private void visitTransformationHeaderCS(TransformationHeaderCS headerCS,
			QvtOperationalFileEnv env, Module module) {
		if (!headerCS.getQualifiers().isEmpty()) {
			env.reportWarning(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_transfQualifiersNotSupported,
					new Object[] { }), 
					headerCS.getQualifiers().get(0).getStartOffset(),
					headerCS.getQualifiers().get(headerCS.getQualifiers().size()-1).getEndOffset());
		}
		
		String unitSimpleName = QvtOperationalParserUtil.getMappingModuleSimpleName(headerCS);
		String unitNamespace = env.getExpectedPackageName();
		
		if (!unitSimpleName.equals(env.getUnitName())) {
			env.reportError(NLS.bind(ValidationMessages.moduleNameMustMatchFileNameError, new Object[] { env
					.getUnitName() }), headerCS.getPathNameCS());
		}
		if(!QvtOperationalParserUtil.hasSimpleName(headerCS)) {
			env.reportError(NLS.bind(ValidationMessages.moduleNameMustBeSimpleIdentifierError, new Object[] { 
					QvtOperationalParserUtil.getMappingModuleQualifiedName(headerCS) }), headerCS.getPathNameCS());
		}		
		
		module.setName(unitSimpleName);
		module.setNsPrefix(unitNamespace);
		
		Set<String> paramNames = new LinkedHashSet<String>();
		for (ParameterDeclarationCS paramCS : headerCS.getParameters()) {
			EClassifier type = null;
			if (paramCS.getTypeSpecCS().getTypeCS() instanceof PathNameCS) {
				type = env.getModelType(((PathNameCS) paramCS.getTypeSpecCS().getTypeCS()).getSequenceOfNames());
			}
			if (type == null) {
				env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_transfParamWrongType,
						new Object[] { }), paramCS.getTypeSpecCS().getTypeCS());
				type = env.getOCLStandardLibrary().getOclVoid();
			}

			ModelParameter varParam = ExpressionsFactory.eINSTANCE.createModelParameter();
			varParam.setStartPosition(paramCS.getStartOffset());
			varParam.setEndPosition(paramCS.getEndOffset());
			varParam.setName(paramCS.getSimpleNameCS().getValue());
			varParam.setEType(type);
			varParam.setKind((DirectionKind) ExpressionsFactory.eINSTANCE.createFromString(
					ExpressionsPackage.eINSTANCE.getDirectionKind(), paramCS.getDirectionKind().getLiteral()));

			if (paramNames.contains(varParam.getName())) {
				env.reportError(NLS.bind(ValidationMessages.SameParamName, new Object[] { varParam.getName() }),
						paramCS.getSimpleNameCS());
			}
			paramNames.add(varParam.getName());
			
	        module.getModelParameter().add(varParam);
		}
		env.registerModelParameters(module);
		
		if (headerCS.getTransformationRefineCS() != null) {
			env.reportWarning(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_transfRefineNotSupported,
					new Object[] { }), headerCS.getTransformationRefineCS());
		}
		if (!headerCS.getModuleUsages().isEmpty()) {
			env.reportWarning(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_transfUsagesNotSupported,
					new Object[] { }), 
					headerCS.getModuleUsages().get(0).getStartOffset(),
					headerCS.getModuleUsages().get(headerCS.getModuleUsages().size()-1).getEndOffset());
		}
	}

	private ModelType visitModelTypeCS(ModelTypeCS modelTypeCS, QvtOperationalFileEnv env,
			Module module) throws SemanticException {
		if (modelTypeCS == null) {
			return null;
		}
		ModelType modelType = ExpressionsFactory.eINSTANCE.createModelType();
		modelType.setStartPosition(modelTypeCS.getStartOffset());
		modelType.setEndPosition(modelTypeCS.getEndOffset());
		modelType.setName(modelTypeCS.getIdentifierCS().getValue());
		
		if (modelTypeCS.getComplianceKindCS() != null) {
			String complianceKind = visitLiteralExpCS(modelTypeCS.getComplianceKindCS(), env);
			if (complianceKind.length() > 0 && !QvtOperationalEnv.METAMODEL_COMPLIANCE_KIND_STRICT.equals(complianceKind)) {
				env.reportWarning(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_unsupportedMetamodelComplianceKind,
						new Object[] { complianceKind }), modelTypeCS.getComplianceKindCS());
			}
			modelType.setConformanceKind(complianceKind);
		}
		
		for (int i = 0, n = modelTypeCS.getPackageRefs().size(); i < n; ++i) {
			PackageRefCS packageRefCS = modelTypeCS.getPackageRefs().get(i);
			PackageRef packageRef = ExpressionsFactory.eINSTANCE.createPackageRef();
			packageRef.setStartPosition(packageRefCS.getStartOffset());
			packageRef.setEndPosition(packageRefCS.getEndOffset());

			EPackage resolvedMetamodel = null;

			if (packageRefCS.getUriCS() != null) {
				String metamodelUri = visitLiteralExpCS(packageRefCS.getUriCS(), env);
				packageRef.setUri(metamodelUri);
				resolvedMetamodel = resolveMetamodel(env, metamodelUri, Collections.<String>emptyList(), packageRefCS.getUriCS());
			}
			
			PathNameCS pathNameCS = packageRefCS.getPathNameCS();
			if (pathNameCS != null && !pathNameCS.getSequenceOfNames().isEmpty()) {
				String metamodelName = QvtOperationalParserUtil.getStringRepresentation(
						pathNameCS, QvtOperationalTypesUtil.TYPE_NAME_SEPARATOR); 
				packageRef.setName(metamodelName);

				if (resolvedMetamodel == null) {
					resolvedMetamodel = resolveMetamodel(env, null, pathNameCS.getSequenceOfNames(), pathNameCS);
				}
				else {
					resolvedMetamodel = checkMetamodelPath(env, resolvedMetamodel, pathNameCS, metamodelName);
				}
			}
			
			if (resolvedMetamodel != null) {
				validateMetamodel(env, resolvedMetamodel, modelType, module, packageRefCS);				
				modelType.getMetamodel().add(packageRef);
				
				for (++i; i < n; ++i) {
					packageRefCS = modelTypeCS.getPackageRefs().get(i);
					env.reportWarning(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_metamodelSinglePackageRefSupported,
							new Object[] { }), packageRefCS);
				}
				break;
			}
		}
		
		if (!modelTypeCS.getWhereStatements().isEmpty()) {
			int startOffset = modelTypeCS.getWhereStatements().get(0).getStartOffset();
			int endOffset = modelTypeCS.getWhereStatements().get(modelTypeCS.getWhereStatements().size()-1).getEndOffset();
			env.reportWarning(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_metamodelConditionsNotSupported,
					new Object[] { }), startOffset, endOffset);
		}
		
		if (modelType.getMetamodel().isEmpty()) {
			return null;
		}
		return modelType;
	}

	private EPackage checkMetamodelPath(QvtOperationalFileEnv env, EPackage resolvedMetamodel,
			PathNameCS pathNameCS, String metamodelName) {

		EList<String> path = pathNameCS.getSequenceOfNames();
		// lookup nested package started from package specified by URI
		EPackage localPackage = EmfMmUtil.lookupPackage(resolvedMetamodel, path);
		if (localPackage != null) {
			return localPackage;			
		}
		
		// lookup nested package started from root package of package specified by URI
		EPackage rootMetamodel = resolvedMetamodel;
		while (true) {
			if (rootMetamodel.getESuperPackage() == null) {
				break;
			}
			rootMetamodel = rootMetamodel.getESuperPackage();
		}
		
		if (rootMetamodel != resolvedMetamodel) {
			localPackage = EmfMmUtil.lookupPackage(rootMetamodel, path);
			
			boolean isContainedBy = false;
			EPackage curPkg = localPackage;
			while (curPkg != null) {
				if (curPkg == resolvedMetamodel) {
					isContainedBy = true;
					break;
				}
				curPkg = curPkg.getESuperPackage();
			}

			if (localPackage != null && isContainedBy) {
				return localPackage;			
			}
		}

		env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_metamodelPackageRefInconsistent,
				new Object[] { metamodelName }), pathNameCS);
		
		return null;		
	}

	private void validateMetamodel(QvtOperationalFileEnv env, EPackage resolvedMetamodel,
			ModelType modelType, Module module, CSTNode cstNode) throws SemanticException {

		String metamodelName = (resolvedMetamodel.getNsURI() == null ? resolvedMetamodel.getName() : resolvedMetamodel.getNsURI());
		if (ModelTypeMetamodelsAdapter.getMetamodels(modelType).contains(resolvedMetamodel)) {
			env.reportWarning(NLS.bind(ValidationMessages.DuplicateMetamodelImport,
					new Object[] { metamodelName }), cstNode);
		}
		if (getUsedMetamodels(module).contains(resolvedMetamodel)) {
			env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_metamodelAlreadyUsed,
					new Object[] { metamodelName }), cstNode);
		}
		
		ModelTypeMetamodelsAdapter.addMetamodel(modelType, resolvedMetamodel);
	}
	
	private EPackage resolveMetamodel(QvtOperationalFileEnv env, String metamodelUri, List<String> packagePath,
			CSTNode cstNode) throws SemanticException {
		EPackage resolvedMetamodel = null;
		String metamodelName = (packagePath.isEmpty() ? metamodelUri : packagePath.toString());
		try {
			List<EPackage> registerMetamodels = env.registerMetamodel(metamodelUri, packagePath);
			if (registerMetamodels.isEmpty()) {
				env.reportError(NLS.bind(ValidationMessages.failedToResolveMetamodelError,
						new Object[] { metamodelName }), cstNode);
			}
			else {
				resolvedMetamodel = registerMetamodels.get(0);
			}
			
			if (registerMetamodels.size() > 1) {
				List<String> uriList = new ArrayList<String>(registerMetamodels.size());
				for (EPackage pack : registerMetamodels) {
					uriList.add(pack.getNsURI());					
				}
				env.reportWarning(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_metamodelNameAmbiguous,
						new Object[] { metamodelName, uriList }), cstNode);
			}
		} catch (RuntimeException e) {
			env.reportError(NLS.bind(ValidationMessages.failedToResolveMetamodelError,
					new Object[] { metamodelName }), cstNode);
		}
		
		return resolvedMetamodel;
	}
	
	private Set<EPackage> getUsedMetamodels(Module module) {
		Set<EPackage> metamodels = new LinkedHashSet<EPackage>();		
		for (ModelType modelType : module.getUsedModelType()) {
			metamodels.addAll(ModelTypeMetamodelsAdapter.getMetamodels(modelType));
		}
		return metamodels;		
	}

	private Rename visitRenameCS(RenameCS renameCS, QvtOperationalFileEnv env) throws SemanticException {
		EClassifier type = visitTypeCS(renameCS.getTypeCS(), env);
		if (type == null) {
			return null;
		}
		String originalName = visitLiteralExpCS(renameCS.getOriginalName(), env);
		String newName = renameCS.getSimpleNameCS().getValue();

		EStructuralFeature originalProperty = env.lookupProperty(type, originalName);
		if (originalProperty == null) {
			env.reportError(NLS.bind(ValidationMessages.noPropertyInTypeError, originalName, QvtOperationalTypesUtil
					.getTypeFullName(type)), renameCS);
			return null;
		}

		EStructuralFeature newProperty = env.lookupProperty(type, newName);
		if (newProperty != null) {
			env.reportError(NLS.bind(ValidationMessages.propertyAlreadyExistsInTypeError, newName,
			        QvtOperationalTypesUtil.getTypeFullName(type)), renameCS);
			return null;
		}

		Variable<EClassifier, EParameter> var = org.eclipse.ocl.expressions.ExpressionsFactory.eINSTANCE.createVariable();
		var.setName(newName);
		var.setType(originalProperty.getEType());
		Constraint constraint = EcoreFactory.eINSTANCE.createConstraint();
		constraint.setStereotype(QvtOperationalEnv.RENAMED_PROPERTY_STEREOTYPE);
		constraint.getConstrainedElements().add(originalProperty);
		EStructuralFeature feature = env.defineAttribute(type, var, constraint);
		feature.setLowerBound(originalProperty.getLowerBound());
		feature.setUpperBound(originalProperty.getUpperBound());

		Rename rename = ExpressionsFactory.eINSTANCE.createRename();
		rename.setStartPosition(renameCS.getStartOffset());
		rename.setEndPosition(renameCS.getEndOffset());
		rename.setName(originalName);
		rename.setNewName(newName);
		rename.setEType(type);

		return rename;
	}

	private List<OCLExpression<EClassifier>> visitMappingSectionCS(MappingSectionCS mappingSectionCS,
			QvtOperationalEnv env) throws SemanticException {
		List<OCLExpression<EClassifier>> statements = new ArrayList<OCLExpression<EClassifier>>(mappingSectionCS
				.getStatements().size());
		for (StatementCS statementCS : mappingSectionCS.getStatements()) {
			if (statementCS == null) {
				continue;
			}
			OCLExpression<EClassifier> statement = visitOclExpressionCS(statementCS, env);
			if (statement != null) {
				statements.add(statement);
			}
		}
		return statements;
	}

	private ImperativeOperation visitMappingMethodCS(MappingMethodCS methodCS, QvtOperationalEnv env)
			throws SemanticException {
		if (methodCS instanceof MappingRuleCS) {
			return visitMappingRuleCS((MappingRuleCS) methodCS, env);
		}
		return visitMappingQueryCS((MappingQueryCS) methodCS, env);
	}

	private ImperativeOperation visitMappingRuleCS(MappingRuleCS methodCS, QvtOperationalEnv env)
			throws SemanticException {
		MappingOperation operation = ExpressionsFactory.eINSTANCE.createMappingOperation();
		if (!visitMappingDeclarationCS(methodCS.getMappingDeclarationCS(), env, operation)) {
			return null;
		}
		env.registerMappingOperation(operation);
		operation.setEndPosition(methodCS.getEndOffset());

		if (operation.getContext().getKind() == DirectionKind.OUT) {
			env.reportError(ValidationMessages.ContextParamMustBeInOrInout, methodCS.getMappingDeclarationCS()
					.getDirectionKindCS());
		}

		VarParameter operationResult = (operation.getResult().isEmpty() ? null : operation.getResult().get(0));
		QvtOperationalEnv newEnv = env.createOperationEnvironment(operation.getContext());
		CSTBindingUtil.bindQvtOperationalEnv(methodCS, newEnv);
		if (operationResult != null && !(operationResult instanceof VoidType)) {
			Variable<EClassifier, EParameter> var = org.eclipse.ocl.expressions.ExpressionsFactory.eINSTANCE.createVariable();
			var.setName(Environment.RESULT_VARIABLE_NAME);
			var.setType(operationResult.getEType());
			var.setRepresentedParameter(operationResult);
			newEnv.addElement(var.getName(), var, true);
		}
		newEnv.defineOperationParameters(operation);

		OCLExpression<EClassifier> guard;
		if (methodCS.getGuard() != null) {
			guard = visitOclExpressionCS(methodCS.getGuard(), newEnv);
			if (guard != null) {
				EClassifier guardType = guard.getType();
				if (guardType != newEnv.getOCLStandardLibrary().getBoolean()) {
					newEnv.reportError(NLS.bind(ValidationMessages.mappingGuardNotBooleanError,
							new Object[] { QvtOperationalTypesUtil.getTypeFullName(guardType) }), methodCS.getGuard());
					guard = null;
				}
			}
		} else {
			guard = null;
		}

		List<OCLExpression<EClassifier>> inits = Collections.emptyList();
		if (methodCS.getMappingInitCS() != null) {
			inits = visitMappingSectionCS(methodCS.getMappingInitCS(), newEnv);
		}

		MappingBody body = null;
		if (operationResult.getEType() instanceof VoidType) {
			MappingBodyCS mappingBodyCS = methodCS.getMappingBodyCS();
			if (!isEmptyBodyCS(mappingBodyCS)) {
				newEnv.reportError(ValidationMessages.MappingWithoutResultMustNotHaveBody, mappingBodyCS);
			}
			else {
				body = ExpressionsFactory.eINSTANCE.createMappingBody();
				body.setStartPosition(mappingBodyCS == null ? methodCS.getStartOffset() : mappingBodyCS.getStartOffset());
				body.setEndPosition(mappingBodyCS == null ? methodCS.getEndOffset() : mappingBodyCS.getEndOffset());
			}
		} else if (methodCS.getMappingBodyCS() != null) {
			body = visitMappingBodyCS(methodCS.getMappingBodyCS(), newEnv);
			if (body != null) {
				EClassifier returnType = operationResult.getEType();
				EClassifier bodyType = (body.getContent().size() == 1
						&& body.getContent().get(0) instanceof ObjectExp ? body.getContent().get(0).getType()
						: null);
                // TODO : Rewrite this when reimplementing ObjectExp
				if (bodyType != null && methodCS.getMappingInitCS() == null && !QvtOperationalParserUtil.isAssignableToFrom(env, bodyType, returnType)) {
					newEnv.reportError(NLS.bind(ValidationMessages.bodyTypeNotCompatibleWithReturnTypeError,
							new Object[] { QvtOperationalTypesUtil.getTypeFullName(bodyType), QvtOperationalTypesUtil.getTypeFullName(returnType) }),
							methodCS.getMappingDeclarationCS());
				}
			}
		}

		List<OCLExpression<EClassifier>> ends = Collections.emptyList();
		if (methodCS.getMappingEndCS() != null) {
			ends = visitMappingSectionCS(methodCS.getMappingEndCS(), newEnv);
		}

		if (guard != null) {
			operation.getWhen().add(guard);
		}
		operation.setBody(body);
		if (body != null) {
			body.getInitSection().addAll(inits);
			body.getEndSection().addAll(ends);
		}

		checkAbstractOutParamsInitialized(operation.getResult(), methodCS, env);

		return operation;
	}

	private ImperativeOperation visitMappingQueryCS(MappingQueryCS methodCS, QvtOperationalEnv env)
			throws SemanticException {
		Helper helper = ExpressionsFactory.eINSTANCE.createHelper();
		if (!visitMappingDeclarationCS(methodCS.getMappingDeclarationCS(), env, helper)) {
			return null;
		}
		helper.setEndPosition(methodCS.getEndOffset());

		if (helper.getContext().getKind() != DirectionKind.IN) {
			env.reportError(ValidationMessages.ContextParamMustBeIn, methodCS.getMappingDeclarationCS()
					.getSimpleNameCS());
		}

		QvtOperationalEnv newEnv = env.createOperationEnvironment(helper.getContext());
        CSTBindingUtil.bindQvtOperationalEnv(methodCS, newEnv);
		newEnv.defineOperationParameters(helper);

		List<OCLExpression<EClassifier>> expressions = new ArrayList<OCLExpression<EClassifier>>();
		for (OCLExpressionCS exprCS : methodCS.getExpressions()) {
			if (exprCS == null) {
				continue;
			}
			OCLExpression<EClassifier> expr = visitOclExpressionCS(exprCS, newEnv);
			if (expr != null) {
				expressions.add(expr);
			}
		}

		MappingBody body = ExpressionsFactory.eINSTANCE.createMappingBody();
		body.setStartPosition(methodCS.getMappingDeclarationCS().getEndOffset());
		body.setEndPosition(methodCS.getEndOffset());
		body.getContent().addAll(expressions);

		helper.setIsQuery(true);
		helper.setBody(body);

		EClassifier returnType = (helper.getResult().isEmpty() ? null : helper.getResult().get(0).getEType());
		EClassifier helperType = (body.getContent().size() == 1 ? body.getContent().get(0).getType() : null);
		if (helperType != null && !QvtOperationalParserUtil.isAssignableToFrom(env, returnType, helperType)) {
			env.reportError(NLS.bind(ValidationMessages.bodyTypeNotCompatibleWithReturnTypeError, new Object[] {
			        QvtOperationalTypesUtil.getTypeFullName(helperType), QvtOperationalTypesUtil.getTypeFullName(returnType) }),
					methodCS.getMappingDeclarationCS());
		}

		return helper;
	}

	private boolean visitMappingDeclarationCS(MappingDeclarationCS mappingDeclarationCS, QvtOperationalEnv env,
			ImperativeOperation operation) throws SemanticException {
		if (mappingDeclarationCS == null) {
			return false;
		}
		EClassifier contextType;
		if (mappingDeclarationCS.getContextType() != null) {
			contextType = visitTypeCS(mappingDeclarationCS.getContextType(), env);
			if (contextType == null) {
				contextType = env.getOCLStandardLibrary().getOclVoid();
			}
		} else {
			contextType = env.getOCLStandardLibrary().getOclVoid();
		}

		EClassifier returnType;
		if (mappingDeclarationCS.getReturnType() != null) {
			returnType = visitTypeCS(mappingDeclarationCS.getReturnType().getTypeCS(), env);
			if (returnType == null) {
				env.reportError(NLS.bind(ValidationMessages.UnknownClassifierType, new Object[] {
						QvtOperationalParserUtil.getStringRepresentation(mappingDeclarationCS.getReturnType().getTypeCS())}),
						mappingDeclarationCS.getReturnType());
				returnType = env.getOCLStandardLibrary().getOclVoid();
			}
		} else {
			returnType = env.getOCLStandardLibrary().getOclVoid();
		}

		List<VarParameter> params = new ArrayList<VarParameter>();
		for (ParameterDeclarationCS paramCS : mappingDeclarationCS.getParameters()) {
			VarParameter param = visitParameterDeclarationCS(paramCS, env);
			if (param == null) {
				return false;
			}

			QvtOperationalParserUtil.validateNameClashing(param.getName(), returnType, contextType, env,
					mappingDeclarationCS);

			params.add(param);
		}

		MappingParameter varContext = ExpressionsFactory.eINSTANCE.createMappingParameter();
		if (mappingDeclarationCS.getContextType() != null) {
			varContext.setStartPosition(mappingDeclarationCS.getContextType().getStartOffset());
			varContext.setEndPosition(mappingDeclarationCS.getContextType().getEndOffset());
		}
		varContext.setEType(contextType);
		if (mappingDeclarationCS.getDirectionKindCS() != null) {
			varContext.setKind((DirectionKind) ExpressionsFactory.eINSTANCE.createFromString(
					ExpressionsPackage.eINSTANCE.getDirectionKind(), mappingDeclarationCS.getDirectionKindCS()
							.getDirectionKind().getLiteral()));
		}
		else {
			varContext.setKind(DirectionKind.IN);
		}
		// TODO check explicit extent specified (using '@')
		if (varContext.getExtent() == null) {
			varContext.setExtent(env.resolveModelParameter(contextType, varContext.getKind()));
		}

		MappingParameter varResult = ExpressionsFactory.eINSTANCE.createMappingParameter();
		varResult.setEType(returnType);
		varResult.setKind(DirectionKind.OUT);
		if (mappingDeclarationCS.getReturnType() != null) {
			varResult.setStartPosition(mappingDeclarationCS.getReturnType().getStartOffset());
			varResult.setEndPosition(mappingDeclarationCS.getReturnType().getEndOffset());

			if (mappingDeclarationCS.getReturnType().getSimpleNameCS() != null) {
				ModelParameter modelParam = env.lookupModelParameter(
						mappingDeclarationCS.getReturnType().getSimpleNameCS(), varResult.getKind());
				varResult.setExtent(modelParam);
			}
		}
		if (varResult.getExtent() == null) {
			varResult.setExtent(env.resolveModelParameter(returnType, varResult.getKind()));
		}

		operation.setStartPosition(mappingDeclarationCS.getStartOffset());
		operation.setEndPosition(mappingDeclarationCS.getEndOffset());
		operation.setName(mappingDeclarationCS.getSimpleNameCS().getValue());
		operation.setContext(varContext);
		operation.getEParameters().addAll(params);
		operation.getResult().add(varResult);
		operation.setIsBlackbox(mappingDeclarationCS.isBlackBox());
		
		if (operation.getResult().size() == 1) {
			operation.setEType(returnType);
		}
		else {
			// TODO : create TupleType
			assert false;
		}

		return true;
	}

	private OCLExpression<EClassifier> visitAssignStatementCS(AssignStatementCS expressionCS, QvtOperationalEnv env)
			throws SemanticException {
		if (expressionCS.getPathNameCS() == null) {
			return null;
		}
		EList<String> qualifiedName = expressionCS.getPathNameCS().getSequenceOfNames();
		if (qualifiedName.size() > 2) {
			env.reportError(ValidationMessages.cannotModifyNestedPropertiesError, expressionCS);
			return null;
		}

		String lvalueName = qualifiedName.get(0);
		if (qualifiedName.size() == 1 && Environment.SELF_VARIABLE_NAME.equals(lvalueName)) {
			env.reportError(ValidationMessages.CantAssignToSelf, expressionCS.getPathNameCS());
			return null;
		}

		Variable<EClassifier, EParameter> variable = env.lookup(lvalueName);
		if (variable != null) {
			QvtOperationalParserUtil.validateVariableModification(variable, expressionCS.getPathNameCS(), env);
		} else {
			env.reportError(NLS.bind(ValidationMessages.unresolvedNameError, new Object[] { lvalueName }),
					expressionCS.getPathNameCS());
			return null;
		}

		OCLExpression<EClassifier> rightExpr = visitOclExpressionCS(expressionCS.getOclExpressionCS(), env);
		if (rightExpr == null) {
			return null;
		}

		EStructuralFeature leftProp = null;
		if (qualifiedName.size() > 1) {
			leftProp = env.lookupProperty(variable.getType(), qualifiedName.get(1));
			if (leftProp == null) {
				String fullName = QvtOperationalParserUtil.getStringRepresentation(expressionCS.getPathNameCS(), "."); //$NON-NLS-1$ 
				env.reportError(NLS.bind(ValidationMessages.invalidPropertyReferenceError,
						new Object[] { fullName }), expressionCS.getPathNameCS());
				return null;
			} else if (!leftProp.isChangeable()) {
				env.reportError(NLS.bind(ValidationMessages.ReadOnlyProperty, leftProp.getName()), expressionCS
						.getPathNameCS());
			}
		}

		EClassifier type = leftProp == null ? variable.getType() : env.getUMLReflection().getOCLType(leftProp);
		QvtOperationalParserUtil.validateAssignment(variable.getName(), type, rightExpr, expressionCS.isIncremental(),
				expressionCS.getPathNameCS(), env);

		AssignExp result = ExpressionsFactory.eINSTANCE.createAssignExp();
		result.setStartPosition(expressionCS.getStartOffset());
		result.setEndPosition(expressionCS.getEndOffset());
		result.getValue().add(rightExpr);
		result.setIsReset(!expressionCS.isIncremental());

		OCLExpression<EClassifier> sourceExp;
		if (leftProp == null) {
			sourceExp = org.eclipse.ocl.expressions.ExpressionsFactory.eINSTANCE.createVariableExp();
			sourceExp.setType(type);
			sourceExp.setName(variable.getName());
		}
		else {
			sourceExp = org.eclipse.ocl.expressions.ExpressionsFactory.eINSTANCE.createPropertyCallExp();
			sourceExp.setName(variable.getName());
			((PropertyCallExp<EClassifier, EStructuralFeature>) sourceExp).setReferredProperty(leftProp);
		}
		result.setLeft(sourceExp);

		return result;
	}

	private VarParameter visitParameterDeclarationCS(ParameterDeclarationCS paramCS, QvtOperationalEnv env)
			throws SemanticException {
		EClassifier type = visitTypeCS(paramCS.getTypeSpecCS().getTypeCS(), env);
		if (type == null) {
			type = env.getOCLStandardLibrary().getOclVoid();
		}

		MappingParameter varParam = ExpressionsFactory.eINSTANCE.createMappingParameter();
		varParam.setStartPosition(paramCS.getStartOffset());
		varParam.setEndPosition(paramCS.getEndOffset());
		varParam.setName(paramCS.getSimpleNameCS().getValue());
		varParam.setEType(type);
		varParam.setKind((DirectionKind) ExpressionsFactory.eINSTANCE.createFromString(
				ExpressionsPackage.eINSTANCE.getDirectionKind(), paramCS.getDirectionKind().getLiteral()));
		if (paramCS.getTypeSpecCS().getSimpleNameCS() != null) {
			ModelParameter modelParam = env.lookupModelParameter(paramCS.getTypeSpecCS().getSimpleNameCS(), varParam.getKind());
			varParam.setExtent(modelParam);
		}
		if (varParam.getExtent() == null) {
			varParam.setExtent(env.resolveModelParameter(type, varParam.getKind()));
		}

		if (varParam.getKind() == DirectionKind.OUT) {
			env.reportError(ValidationMessages.OutParamsNotSupported, paramCS);
		}

        // AST binding
        if(createASTBinding) {		
			ASTBindingHelper.createCST2ASTBinding(paramCS, varParam);
        }
		//
		
		return varParam;
	}

	private OCLExpression<EClassifier> visitVariableInitializationCS(VariableInitializationCS varInitCS,
			QvtOperationalEnv env) throws SemanticException {
        if (varInitCS instanceof ErrorVariableInitializationCS) {
            VariableInitExp result = ExpressionsFactory.eINSTANCE.createVariableInitExp();
            result.setStartPosition(varInitCS.getStartOffset());
            result.setEndPosition(varInitCS.getEndOffset());
            return result;
        }
		MappingDeclarationCS mappingDeclCS = ((MappingMethodCS) varInitCS.eContainer().eContainer())
				.getMappingDeclarationCS();
		EClassifier contextType = mappingDeclCS.getContextType() != null ? visitTypeCS(
				mappingDeclCS.getContextType(), env) : env.getOCLStandardLibrary().getOclVoid();
		EClassifier returnType = mappingDeclCS.getReturnType() != null ? visitTypeCS(
				mappingDeclCS.getReturnType().getTypeCS(), env) : env.getOCLStandardLibrary().getOclVoid();
		if (!QvtOperationalParserUtil.validateNameClashing(varInitCS.getSimpleNameCS().getValue(), returnType,
				contextType, env, varInitCS)) {
			return null;
		}

		VariableInitExp result = ExpressionsFactory.eINSTANCE.createVariableInitExp();
		result.setStartPosition(varInitCS.getStartOffset());
		result.setEndPosition(varInitCS.getEndOffset());
		if (validateInitializedValueCS(varInitCS, result, env)) {
			if (QvtOperationalParserUtil.validateInitVariable(result, env)) {
				env.addInitVariable(result);
			}
		}

        // AST binding
        if(createASTBinding) {
			if(result.getName() != null) {
				Variable<EClassifier, EParameter> envVar = env.lookupLocal(result.getName());
				if(envVar != null) {
					ASTBindingHelper.createCST2ASTBinding(varInitCS, envVar);
				}	        
			}
        }
		//		
		
		return result;
	}

	private MappingBody visitMappingBodyCS(MappingBodyCS mappingBodyCS, QvtOperationalEnv env)
			throws SemanticException {
		OutExpCS outExpCS = mappingBodyCS.getOutExpCS();
		if (outExpCS == null) {
			env.reportError(ValidationMessages.objectExpressionExpectedError, mappingBodyCS);
			return null;
		}

//      [aigdalov]: Since the returnType feature is contained in the MappingDeclarationCS
//		type the operations below set the MappingDeclarationCS.returnType to null
//		Cloning the TypeCS object is also unwanted since we'll get problems with
//		defining offsets of the copy.
//		if (outExpCS.getTypeCS() == null) {
//			MappingRuleCS methodCS = (MappingRuleCS) mappingBodyCS.eContainer();
//			outExpCS.setTypeCS(methodCS.getMappingDeclarationCS().getReturnType());
//		}

		ObjectExp objectExp = visitOutExpCS(outExpCS, env);
		if (objectExp == null) {
			return null;
		}
		objectExp.setName(Environment.RESULT_VARIABLE_NAME);

		MappingBody body = ExpressionsFactory.eINSTANCE.createMappingBody();
		body.setStartPosition(mappingBodyCS.getStartOffset());
		body.setEndPosition(mappingBodyCS.getEndOffset());
		body.getContent().add(objectExp);

		return body;
	}

	private OCLExpression<EClassifier> visitExpressionStatementCS(ExpressionStatementCS expressionCS,
			QvtOperationalEnv env) throws SemanticException {
		return visitOclExpressionCS(expressionCS.getOclExpressionCS(), env);
	}

	private Property visitConfigPropertyCS(ConfigPropertyCS propCS, QvtOperationalFileEnv env)
			throws SemanticException {
		Property property = ExpressionsFactory.eINSTANCE.createConfigProperty();
		property.setStartPosition(propCS.getStartOffset());
		property.setEndPosition(propCS.getEndOffset());
		property.setName(propCS.getSimpleNameCS().getValue());

		EClassifier type;
		if (propCS.getTypeCS() != null) {
			type = visitTypeCS(propCS.getTypeCS(), env);
			if (type != null) {
				property.setEType(type);
				if (!QvtOperationalUtil.isCreateFromStringSupported(type)) {
					env.reportError(NLS.bind(ValidationMessages.ConfigPropertyTypeUnsupported, new Object[] { type
							.getName() }), propCS.getTypeCS());
				}
			}
		} else {
			type = env.getOCLStandardLibrary().getOclVoid();
			env.reportError(NLS.bind(ValidationMessages.ConfigPropertyMustHaveType,
					new Object[] { property.getName() }), propCS);
		}

		env.addPropertyVariable(property);

		return property;
	}

	private Property visitLocalPropertyCS(LocalPropertyCS propCS, QvtOperationalFileEnv env)
			throws SemanticException {
		LocalProperty prop = ExpressionsFactory.eINSTANCE.createLocalProperty();
		prop.setStartPosition(propCS.getStartOffset());
		prop.setEndPosition(propCS.getEndOffset());

		if (validateLocalPropertyCS(propCS, prop, env)) {
			if (QvtOperationalParserUtil.validateLocalProperty(prop, env)) {
				if (prop.getName() != null) {
					env.addPropertyVariable(prop);
				}
			}
		}

		return prop;
	}

	private Property visitModulePropertyCS(ModulePropertyCS propCS, QvtOperationalFileEnv env)
			throws SemanticException {
		
		Property result = null;		
		if (propCS instanceof ConfigPropertyCS) {
			result = visitConfigPropertyCS((ConfigPropertyCS) propCS, env);
		} else {
			result = visitLocalPropertyCS((LocalPropertyCS) propCS, env);
		}
		
        // AST binding
        if(createASTBinding) {		
        	ASTBindingHelper.createCST2ASTBinding(propCS, result, env);
        }
		//
		return result;
	}

    private OCLExpression<EClassifier> visitResolveExpCS(ResolveExpCS resolveExpCS, QvtOperationalEnv env)
            throws SemanticException {
        return populateResolveExp(resolveExpCS, env, ExpressionsFactory.eINSTANCE.createResolveExp());
    }
    
    private OCLExpression<EClassifier> visitResolveInExpCS(
            ResolveInExpCS resolveInExpCS, QvtOperationalEnv env) throws SemanticException {
        ResolveInExp resolveInExp = ExpressionsFactory.eINSTANCE.createResolveInExp();
        TypeCS contextTypeCS = resolveInExpCS.getInMappingType();
        EClassifier eClassifier = (contextTypeCS == null) ? null : visitTypeCS(contextTypeCS, env); // mapping context type
        List<EOperation> mappingOperations = env.lookupMappingOperations(eClassifier, resolveInExpCS.getInMappingName());
        if (mappingOperations.size() == 1) {
            env.registerResolveInExp(resolveInExp, eClassifier, resolveInExpCS.getInMappingName());
        } else {
            String mappingFQName = (eClassifier == null) ? "" : eClassifier.getName() + QvtOperationalTypesUtil.TYPE_NAME_SEPARATOR; //$NON-NLS-1$
            mappingFQName += resolveInExpCS.getInMappingName();
            if (mappingOperations.size() == 0) {
                env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_ResolveInMappingNotFound, new Object[] {
                        mappingFQName}), resolveInExpCS);
            } else if (mappingOperations.size() > 1) {
                env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_ResolveInSeveralMappingsFound, new Object[] {
                        mappingFQName}), resolveInExpCS);
            }
        }
        return populateResolveExp(resolveInExpCS, env, resolveInExp);
    }
    
    private OCLExpression<EClassifier> populateResolveExp(ResolveExpCS resolveExpCS, QvtOperationalEnv env, ResolveExp resolveExp) throws SemanticException {
        // AST binding
        if(createASTBinding) {      
            ASTBindingHelper.createCST2ASTBinding(resolveExpCS, resolveExp, env);
        }
        //
        if (resolveExpCS.getSource() != null) {
            OCLExpression<EClassifier> sourceExp = visitOclExpressionCS(resolveExpCS.getSource(), env);
            resolveExp.setSource(sourceExp);
        }
        resolveExp.setOne(resolveExpCS.isOne());
        resolveExp.setIsInverse(resolveExpCS.isIsInverse());
        resolveExp.setIsDeferred(resolveExpCS.isIsDeferred());
        if (resolveExpCS.getTarget() != null) { // at least type is defined
            Variable<EClassifier, EParameter> variable = org.eclipse.ocl.expressions.ExpressionsFactory.eINSTANCE.createVariable();
            EClassifier type = visitTypeCS(resolveExpCS.getTarget().getTypeCS(), env);
            variable.setType(type);
            
            String targetVarName = resolveExpCS.getTarget().getName();
            if (targetVarName != null) {
        		if (env.lookupLocal(targetVarName) != null) {
        			env.reportError(NLS.bind(ValidationMessages.SemanticUtil_15, new Object[] { targetVarName }),
        					resolveExpCS.getTarget().getStartOffset(), resolveExpCS.getTarget().getEndOffset());
        		}
    			variable.setName(targetVarName);
            }
            resolveExp.setTarget(variable);
            
            // AST binding
            if(createASTBinding) {      
                ASTBindingHelper.createCST2ASTBinding(resolveExpCS.getTarget(), variable, env);
            }
            //
            
            if (resolveExp.isOne()) {
                resolveExp.setType(type);
            } else {
        		EClassifier resolveType = (EClassifier) env.getOCLFactory().createSequenceType(type);
                resolveExp.setType(TypeUtil.resolveType(env, resolveType));
            }
            if (resolveExpCS.getCondition() != null) {
                if (variable.getName() != null) {
                    env.createVariable(variable, resolveExpCS.getTarget(), createASTBinding);
                }
                OCLExpression<EClassifier> condExp = visitOclExpressionCS(resolveExpCS.getCondition(), env);
                resolveExp.setCondition(condExp);
                if (variable.getName() != null) {
                    env.deleteElement(variable.getName());
                }
            }
        } else {
            if (resolveExp.isOne()) {
                resolveExp.setType(env.getOCLStandardLibrary().getOclAny());
            } else {
        		EClassifier resolveType = (EClassifier) env.getOCLFactory().createSequenceType(env.getOCLStandardLibrary().getOclAny());
                resolveExp.setType(TypeUtil.resolveType(env, resolveType));
            }
        }
        resolveExp.setStartPosition(resolveExpCS.getStartOffset());
        resolveExp.setEndPosition(resolveExpCS.getEndOffset());
        
        return resolveExp;
    }
    
	private MappingCallExp createMappingCallExp(MappingCallExpCS expressionCS, OCLExpression<EClassifier> result) {
		if (result instanceof OperationCallExp) {
			OperationCallExp<EClassifier, EOperation> operationCallExp = (OperationCallExp<EClassifier, EOperation>) result;
			EOperation operation = operationCallExp.getReferredOperation();
			if (QvtOperationalUtil.isMappingOperation(operation)) {
				MappingCallExp mappingCallExp = ExpressionsFactory.eINSTANCE.createMappingCallExp();
				mappingCallExp.setStartPosition(operationCallExp.getStartPosition());
				mappingCallExp.setEndPosition(operationCallExp.getEndPosition());
				mappingCallExp.getArgument().addAll(operationCallExp.getArgument());
				mappingCallExp.setReferredOperation(operation);
				mappingCallExp.setSource(operationCallExp.getSource());
				mappingCallExp.setType(operationCallExp.getType());
				mappingCallExp.setIsStrict(expressionCS.isStrict());
				return mappingCallExp;
			}
		}
		return null;
	}

	private void validateOperationCall(OperationCallExpCS opCallCS,
			OperationCallExp<EClassifier, EOperation> operationCallExp, QvtOperationalEnv env)
			throws SemanticException {
		if (QvtOperationalParserUtil.isTypeCast(operationCallExp.getReferredOperation())) {
			if (operationCallExp.getSource() != null && operationCallExp.getArgument().size() == 1) {
				EClassifier sourceType = operationCallExp.getSource().getType();
				EClassifier argumentType = ((OCLExpression<EClassifier>) operationCallExp.getArgument().get(0))
						.getType();
				if (argumentType instanceof TypeType
						&& QvtOperationalParserUtil.isIncorrectCast(sourceType,
								((TypeType<EClassifier, EOperation>) argumentType).getReferredType())) {
					env.reportWarning(ValidationMessages.incorrectCastWarning, opCallCS);
				}
			}
		}
	}

	private void checkReturnTypeConformance(final ImperativeOperation operation, final CSTNode cstNode,
			final QvtOperationalEnv env) {
        final EOperation op = env.defineImperativeOperation(operation, operation instanceof MappingOperation, false);
        if (!QvtOperationalParserUtil.isOverloadableMapping(op, env)) {
            return;
        }
        
        NodeProvider provider = new NodeProvider() {
            public Object[] getLinkedNodes(Object node) {
                EClassifier classifier = (EClassifier) node;
                List<EClass> types = null;
                if (node instanceof EClass) {
                	types = ((EClass) classifier).getEAllSuperTypes();
                }
                return types == null ? new Object[0] : types.toArray();
            }
        };
        
        VertexProcessor processor = new VertexProcessor() {
            public boolean process(Object node) {
                if (node instanceof EClassifier == false) {
                    return false;
                }
                
                EClassifier context = (EClassifier) node;
                Module baseModule = QvtOperationalParserUtil.getOutermostDefiningModule((Module) operation.eContainer(), op, context, env);
                if (baseModule == null) {
                    return false;
                }
                
                ImperativeOperation baseMethod = QvtOperationalParserUtil.findMappingMethod(baseModule, op, context, env);
                if (baseMethod == null) {
                    throw new RuntimeException("Failed to find " + op + " in " + baseModule); //$NON-NLS-1$ //$NON-NLS-2$
                }
                
                EClassifier returnType = op.getEType();
                EClassifier expectedReturnType = baseMethod.getResult().isEmpty() ? null :
                		baseMethod.getResult().get(0).getEType(); 
                if (!QvtOperationalParserUtil.isTypeEquals(env, expectedReturnType, returnType)) {
                    env.reportError(NLS.bind(ValidationMessages.ReturnTypeMismatch,  
                                        op.getName(), QvtOperationalTypesUtil.getTypeFullName(expectedReturnType)), 
                                        cstNode);
                    return true;
                }
                
                return false;
            }
        };

	    EClassifier opOwner = env.getUMLReflection().getOwningClassifier(op);
        new GraphWalker(provider).walkDepthFirst(opOwner, processor);
	}
	
    private void checkAbstractOutParamsInitialized(EList<VarParameter> result, MappingRuleCS methodCS, QvtOperationalEnv env) {
        for (VarParameter varParameter : result) {
            EClassifier type = varParameter.getEType();
            if (type instanceof EClass) {
                EClass eClass = (EClass) type;
                if (!QvtOperationalUtil.isInstantiable(eClass)) {
                    MappingInitCS init = methodCS.getMappingInitCS();
                    if (init != null) {
                        // TODO: The check could be more accurate
                        return;
                    }
                    env.reportError(ValidationMessages.QvtOperationalVisitorCS_AbstractTypesNotInitialized, methodCS);
                }
            }
        }
    }
    
	private boolean isEmptyBodyCS(MappingBodyCS mappingBodyCS) {
		if (mappingBodyCS == null) {
			return true;
		}
		OutExpCS outExpression = mappingBodyCS.getOutExpCS();
		if (outExpression == null) {
			return true;
		}
		if (outExpression.getTypeSpecCS() == null && outExpression.getExpressions().isEmpty()
				&& outExpression.getStartOffset() == outExpression.getBodyStartLocation()) {
			return true;
		}
		return false;
	}

	private boolean validateLocalPropertyCS(LocalPropertyCS propCS, LocalProperty prop, QvtOperationalFileEnv env)
			throws SemanticException {
		prop.setName(propCS.getSimpleNameCS().getValue());

		EClassifier type;
		if (propCS.getTypeCS() != null) {
			type = visitTypeCS(propCS.getTypeCS(), env);
			if (type == null) {
				return false;
			}
		} else {
			type = null;
		}

		if (propCS.getOclExpressionCS() == null) {
			return false;
		}
		OCLExpression<EClassifier> exp = visitOclExpressionCS(propCS.getOclExpressionCS(), env);
		if (exp == null) {
			return false;
		}

		prop.setEType(type);
		prop.setExpression(exp);
		return true;
	}

	private boolean validateInitializedValueCS(VariableInitializationCS varInitCS, VariableInitExp result,
			QvtOperationalEnv env) throws SemanticException {
		result.setName(varInitCS.getSimpleNameCS().getValue());

		EClassifier type;
		if (varInitCS.getTypeCS() != null) {
			type = visitTypeCS(varInitCS.getTypeCS(), env);
			if (type == null) {
				return false;
			}
		} else {
			type = null;
		}

		if (varInitCS.getOclExpressionCS() == null) {
			return false;
		}
		OCLExpression<EClassifier> exp = visitOclExpressionCS(varInitCS.getOclExpressionCS(), env);
		if (exp == null) {
			return false;
		}

		result.setType(type);
		result.setValue(exp);
		return true;
	}
	
	private static TypeCS getOutExpCSType(OutExpCS outExpCS) {
		if (outExpCS.getTypeSpecCS() != null) {
			return outExpCS.getTypeSpecCS().getTypeCS();
		}
		if ((outExpCS.eContainer() instanceof MappingBodyCS)
				&& (outExpCS.eContainer().eContainer() instanceof MappingRuleCS)) {
			MappingRuleCS mappingRuleCS = (MappingRuleCS) outExpCS.eContainer().eContainer();
			return mappingRuleCS.getMappingDeclarationCS().getReturnType().getTypeCS();
		}
		return null;
	}
	
	public void setCreateASTBinding(boolean createASTBinding) {
		this.createASTBinding = createASTBinding;
	}
}