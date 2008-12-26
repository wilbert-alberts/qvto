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
package org.eclipse.m2m.internal.qvt.oml.ast.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTSyntheticNode;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTSyntheticNodeAccess;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalFileEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFolder;
import org.eclipse.m2m.internal.qvt.oml.compiler.BlackboxModuleHelper;
import org.eclipse.m2m.internal.qvt.oml.compiler.IntermediateClassFactory;
import org.eclipse.m2m.internal.qvt.oml.compiler.ParsedModuleCS;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerKernel;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ComputeExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ConfigPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.ExpressionStatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ForExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeIterateExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LibraryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LibraryImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LocalPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LogExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingCallExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingInitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.NewRuleCallExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.OutExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.PackageRefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.RenameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveInExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ReturnExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SwitchExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS;
import org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.AbstractQVTParser;
import org.eclipse.m2m.internal.qvt.oml.cst.temp.ErrorCallExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.temp.ScopedNameCS;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.EmfMmUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.internal.qvt.oml.expressions.AltExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.AssertExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.AssignExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.BlockExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ComputeExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ConstructorBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty;
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.EntryOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.internal.qvt.oml.expressions.ForExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeIterateExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.InstantiationExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;
import org.eclipse.m2m.internal.qvt.oml.expressions.LogExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingCallExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.internal.qvt.oml.expressions.ObjectExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Rename;
import org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ResolveInExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ReturnExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.SeverityKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.SwitchExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.VariableInitExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.WhileExp;
import org.eclipse.m2m.internal.qvt.oml.library.QvtResolveUtil;
import org.eclipse.m2m.internal.qvt.oml.stdlib.QVTUMLReflection;
import org.eclipse.m2m.qvt.oml.blackbox.LoadContext;
import org.eclipse.m2m.qvt.oml.blackbox.ResolutionContextImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.Environment.Internal;
import org.eclipse.ocl.cst.CSTFactory;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.DotOrArrowEnum;
import org.eclipse.ocl.cst.FeatureCallExpCS;
import org.eclipse.ocl.cst.IfExpCS;
import org.eclipse.ocl.cst.IteratorExpCS;
import org.eclipse.ocl.cst.LiteralExpCS;
import org.eclipse.ocl.cst.NullLiteralExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TupleTypeCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.cst.VariableExpCS;
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.StringLiteralExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.parser.AbstractOCLAnalyzer;
import org.eclipse.ocl.parser.OCLLexer;
import org.eclipse.ocl.parser.OCLParser;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.osgi.util.NLS;


public class QvtOperationalVisitorCS
		extends AbstractOCLAnalyzer<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, 
							CallOperationAction, SendSignalAction, Constraint, EClass, EObject> { 	// FIXME - changed in M3.4 migration

    private final QvtCompilerOptions myCompilerOptions;    
	/* TODO - 
	 * Groups all late resolve expression encountered during CST analysis for later validation.
	 * At the moment when resolve expression is visited it has not its container connect yet, which
	 * required for validation. Should be replaced by introducing a validation visitor.
	 */
    private List<ResolveExp> myLateResolveExps;
    
	public QvtOperationalVisitorCS(
			OCLLexer lexStream,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> environment, QvtCompilerOptions options) {
		super(new OCLParser(lexStream));
        myCompilerOptions = options;
	}
	
	public QvtOperationalVisitorCS(AbstractQVTParser parser, QvtCompilerOptions options) {
		super(parser);		
		myCompilerOptions = options;
	}
	
	public QvtCompilerOptions getCompilerOptions() {
        return myCompilerOptions;
    }
	
    @Override
    protected void initStartEndPositions(ASTNode astNode, CSTNode cstNode) {
        // FIXME - temp workaround after OCL 1.2 migration    	
    	astNode.setStartPosition(cstNode.getStartOffset());
    	astNode.setEndPosition(cstNode.getEndOffset());
    }
    
    protected InstantiationExp instantiationExpCS(NewRuleCallExpCS newCallExp, 
    		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
    		EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		InstantiationExp instantiationExp = ExpressionsFactory.eINSTANCE.createInstantiationExp();
		initStartEndPositions(instantiationExp, newCallExp);

		PathNameCS scopedIdentifierCS = newCallExp.getScopedIdentifier();
		EClassifier instantiatedClass = typeCS(scopedIdentifierCS, env);
		instantiationExp.setType(instantiatedClass);

		if(instantiatedClass instanceof EClass) {			
			instantiationExp.setInstantiatedClass((EClass)instantiatedClass);
			instantiationExp.setName(instantiatedClass.getName());
		}

		for (OCLExpressionCS nextArgCS : newCallExp.getArguments()) {
			OCLExpression<EClassifier> nextArgAST = oclExpressionCS(nextArgCS, env);
			if(nextArgAST != null) {
				instantiationExp.getArgument().add(nextArgAST);
			}
		}
		return instantiationExp;
    }
	
	@Override
	protected EClassifier tupleTypeCS(TupleTypeCS tupleTypeCS, Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		EClassifier type = null;
		try {			
			type = super.tupleTypeCS(tupleTypeCS, env);
		} catch (Exception e) {
			// catch MDT OCL exception related to unresolved types used in Tuples, and report error
			String message = NLS.bind(ValidationMessages.UnknownClassifierType, QvtOperationalParserUtil.getStringRepresentation(tupleTypeCS), tupleTypeCS);
			QvtOperationalUtil.reportError(env, message, tupleTypeCS);
		}
		
		return type;
	}
	
	@Override
	protected EClassifier typeCS(TypeCS typeCS, Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		EClassifier type = super.typeCS(typeCS, env);
		if(type == getOclVoid() && typeCS instanceof PrimitiveTypeCS == false) { 
			if(typeCS instanceof PathNameCS) {
				// check whether Void synonym was used
				PathNameCS pathNameCS = (PathNameCS) typeCS;
				if(QvtOperationalStdLibrary.INSTANCE.lookupClassifier(pathNameCS.getSequenceOfNames()) == getOclVoid()) {
					return type;
				}
			}
			// FIXME - workaround for migration to OCL 1.2 => non primitive type but
			// resolved as OclVoid in super impl. indicates actually a type unresolved by the fEnv.
			return null;
		}
		
		// MDT OCL does not check for nested type whether they are resolved
		// do it here if element type is null
		if(type instanceof CollectionType && typeCS instanceof CollectionTypeCS) {
			CollectionType<?, ?> collectionType = (CollectionType<?, ?>)type;			
			
			if(collectionType.getElementType() == null) {
				
				CollectionTypeCS collectionTypeCS = (CollectionTypeCS)typeCS;				
				QvtOperationalUtil.reportError(env, NLS.bind(ValidationMessages.UnknownClassifierType, new Object[] {
						QvtOperationalParserUtil.getStringRepresentation(collectionTypeCS.getTypeCS())}),
						collectionTypeCS.getTypeCS());
			}
		}
		
		if(type != null) {
			if(myCompilerOptions.isGenerateCompletionData()) {
				// bind Module type only, for now  
				if(type instanceof Module) {				
					ASTBindingHelper.createCST2ASTBindingUnidirectional(typeCS, type);
				}
	        }
		}
		return type;
	}
	
	private EClassifier visitTypeCS(TypeCS typeCS, DirectionKind directionKind, 
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		EClassifier type = typeCS(typeCS, env);
		if (type == null) {
			// FIXME - M3.4 not needed, already reported above in #typeCS(typeCS, fEnv); 
			/*fEnv.reportError(NLS.bind(ValidationMessages.UnknownClassifierType, new Object[] {
					QvtOperationalParserUtil.getStringRepresentation(typeCS)}),
					typeCS); */	
		}
		return type;
	}
	

	
	@Override
	protected Variable<EClassifier, EParameter> lookupImplicitSourceForOperation(
			CSTNode cstNode,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			List<OCLExpression<EClassifier>> args, String operationName) {

		 Variable<EClassifier, EParameter> source = super.lookupImplicitSourceForOperation(cstNode, env, args, operationName);
		 if(source == null) {
			 	// FIXME - why is this done?, looks like a workaround for MDT OCL, 
			 	// it's a legal contract for the lookupXXX operation to return null
				source = EcoreFactory.eINSTANCE.createVariable();
				initASTMapping(env, source, cstNode);
		 }
		 return source;
	}

	private EClassifier visitTypeCSInModelType(TypeSpecCS typeSpecCS, ModelType modelType,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		EClassifier type = typeCS(typeSpecCS.getTypeCS(), env);
		if (type == null) {
			// FIXME - M3.4 not needed, already reported above in #typeCS(typeCS, fEnv); 
			/*fEnv.reportError(NLS.bind(ValidationMessages.UnknownClassifierType, new Object[] {
					QvtOperationalParserUtil.getStringRepresentation(typeSpecCS.getTypeCS())}),
					typeSpecCS.getTypeCS());*/
		}
		return type;
	}

    private static class TypeSpecPair {
        public EClassifier myType;
        public ModelParameter myExtent;
    }

	private ModelParameter lookupModelParameter(SimpleNameCS nameCS, DirectionKind directionKind, QvtOperationalEnv env) {
		QvtOperationalModuleEnv moduleEnv = getModuleContextEnv(env);
		ModelParameter modelParam = moduleEnv.lookupModelParameter(nameCS.getValue(), directionKind);
		if(modelParam == null) {		
			env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_extentWrongName,
					new Object[] { nameCS.getValue(), moduleEnv.getAllExtentNames(directionKind) }), nameCS);
		}
		
		return modelParam;
	}	
	
	private TypeSpecPair visitTypeSpecCS(TypeSpecCS typeSpecCS, DirectionKind directionKind,
			QvtOperationalEnv env)  {
		TypeSpecPair result = new TypeSpecPair();
		
		if (typeSpecCS.getSimpleNameCS() != null) {
			result.myExtent = lookupModelParameter(typeSpecCS.getSimpleNameCS(), directionKind, env);
			if (result.myExtent != null && result.myExtent.getEType() instanceof ModelType) {
				result.myType = visitTypeCSInModelType(typeSpecCS, (ModelType) result.myExtent.getEType(), env);
				return result;
			}
		}

		result.myType = visitTypeCS(typeSpecCS.getTypeCS(), directionKind, env);

		return result;
	}

	private String visitLiteralExpCS(StringLiteralExpCS stringLiteralExpCS, 
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env)
			throws SemanticException {
	    // stringLiteralExpCS() is not called directly for AST-CST binding creation done in literalExpCS()
		OCLExpression<EClassifier> literalExpCS = literalExpCS(stringLiteralExpCS, env);
		StringLiteralExp stringLiteralExp = (StringLiteralExp) literalExpCS;
        return stringLiteralExp.getStringSymbol();
	}
	
	@Override
	protected IfExp<EClassifier> ifExpCS(
			IfExpCS ifExpCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		boolean isElseMissed = false;
		if (ifExpCS.getElseExpression() == null) {
			isElseMissed = true;
			// FIXME - !!!!! What a strange hack found during migration to OCL 1.2
			NullLiteralExpCS nullCS = CSTFactory.eINSTANCE.createNullLiteralExpCS();
			nullCS.setSymbol("null"); //$NON-NLS-1$
			//
			ifExpCS.setElseExpression(nullCS); //$NON-NLS-1$
		}
		IfExp<EClassifier> ifExp = super.ifExpCS(ifExpCS, env);
		
		EObject container = ifExpCS.eContainer();
		if (container instanceof VariableInitializationCS) {
			if (isElseMissed) {
				QvtOperationalUtil.reportWarning(env, NLS.bind(ValidationMessages.QvtOperationalVisitorCS_ifExpWithoutElseAssignment,
						new Object[] { }), ifExpCS);
			}
		}
		
		return ifExp;
	}
	
	/**
	 * Produces AST Node from the given CST and performs validation on it.
	 */
	public OCLExpression<EClassifier> analyzeExpressionCS(OCLExpressionCS oclExpressionCS, 
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) throws SemanticException {
		OCLExpression<EClassifier> result = oclExpressionCS(oclExpressionCS, env);	
		validate(env);		
		return result;
	}

	@Override
	protected OCLExpression<EClassifier> oclExpressionCS(OCLExpressionCS oclExpressionCS,
	        Environment<EPackage, EClassifier, EOperation, EStructuralFeature, 
	        EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction,
	        Constraint, EClass, EObject> env) {
	    try {
            if (oclExpressionCS instanceof BlockExpCS) {
                return visitBlockExpCS((BlockExpCS) oclExpressionCS, env);
            }
            if (oclExpressionCS instanceof ComputeExpCS) {
                return visitComputeExpCS((ComputeExpCS) oclExpressionCS, env);
            }
	        if (oclExpressionCS instanceof WhileExpCS) {
	            return visitWhileExpCS((WhileExpCS) oclExpressionCS, env);
	        }
	        if (oclExpressionCS instanceof SwitchExpCS) {
	            return visitSwitchExpCS((SwitchExpCS) oclExpressionCS, env);
	        }
	        if (oclExpressionCS instanceof OutExpCS) {
                return visitOutExpCS((OutExpCS) oclExpressionCS, toQVTOperationalEnv(env), true);
	        }
	        if (oclExpressionCS instanceof AssignStatementCS) {
	            return visitAssignStatementCS((AssignStatementCS) oclExpressionCS, env);
	        }
	        if (oclExpressionCS instanceof VariableInitializationCS) {
	            return visitVariableInitializationCS((VariableInitializationCS) oclExpressionCS, env);
	        }
	        if (oclExpressionCS instanceof ExpressionStatementCS) {
	            return visitExpressionStatementCS((ExpressionStatementCS) oclExpressionCS, env);
	        }
	        if (oclExpressionCS instanceof ResolveInExpCS) {
	            return visitResolveInExpCS((ResolveInExpCS) oclExpressionCS, toQVTOperationalEnv(env));
	        }
	        if (oclExpressionCS instanceof ResolveExpCS) {
	            return visitResolveExpCS((ResolveExpCS) oclExpressionCS, toQVTOperationalEnv(env));
	        }
	        if(oclExpressionCS instanceof LogExpCS) {
	            return logExp((LogExpCS) oclExpressionCS, env);
	        }
	        if(oclExpressionCS instanceof AssertExpCS) {
	            return assertExp((AssertExpCS) oclExpressionCS, env);
	        }

            if (oclExpressionCS instanceof ForExpCS) {
                return visitForExp((ForExpCS) oclExpressionCS, env);
            }

            if (oclExpressionCS instanceof ImperativeIterateExpCS) {
	            return visitImperativeIterateExp((ImperativeIterateExpCS) oclExpressionCS, env);
	        }

	        if (oclExpressionCS instanceof ReturnExpCS) {
	            return visitReturnExpCS((ReturnExpCS) oclExpressionCS, env);
	        }
	        
	        if(oclExpressionCS instanceof NewRuleCallExpCS) {
	        	return instantiationExpCS((NewRuleCallExpCS)oclExpressionCS, env);
	        }
	        	
	        if (oclExpressionCS instanceof TypeCS) {
	            EClassifier type = typeCS((TypeCS) oclExpressionCS, env);
	            if (type == null) {
	                QvtOperationalUtil.reportError(env, OCLMessages.bind(
	                        OCLMessages.UnrecognizedType_ERROR_,
	                        QvtOperationalUtil.getStringRepresentation((TypeCS) oclExpressionCS)), oclExpressionCS);
	            }
	            else {
	                TypeExp<EClassifier> typeExp = env.getOCLFactory().createTypeExp();
	                typeExp.setReferredType(type);
	                typeExp.setType(TypeUtil.resolveTypeType(env, type));
	                return typeExp;
	            }
	        }
	        else {
	        	OCLExpression<EClassifier> result = super.oclExpressionCS(oclExpressionCS, env);

	    		if (oclExpressionCS instanceof OperationCallExpCS) {
	    			if (result instanceof OperationCallExp) {
		    			validateOperationCall((OperationCallExpCS) oclExpressionCS,
		    					(OperationCallExp<EClassifier, EOperation>) result, env);
	    			}
	    			if (result instanceof IteratorExp 
	    					&& ((IteratorExp<EClassifier, EOperation>) result).getBody() instanceof OperationCallExp) {
		    			validateOperationCall((OperationCallExpCS) oclExpressionCS,
		    					(OperationCallExp<EClassifier, EOperation>) ((IteratorExp<EClassifier, EOperation>) result).getBody(), 
		    					env);
	    			}
	    		}
	    		return result;
	        }
	    }
	    catch (NullPointerException ex) {
	        QvtPlugin.log(ex);
	        QvtOperationalUtil.reportError(env, ValidationMessages.QvtOperationalVisitorCS_oclParseNPE, oclExpressionCS);
	    }
	    catch (RuntimeException ex) {
	        //QvtPlugin.log(ex);
	    	QvtOperationalUtil.reportError(env, ValidationMessages.QvtOperationalVisitorCS_oclParseNPE, oclExpressionCS);
	    }
	    return null;
	}
	
    @Override
    protected OCLExpression<EClassifier> literalExpCS(
            LiteralExpCS literalExpCS,
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
        OCLExpression<EClassifier> literalExp = super.literalExpCS(literalExpCS, env);
        // AST binding 
        if(myCompilerOptions.isGenerateCompletionData()) {
            ASTBindingHelper.createCST2ASTBinding(literalExpCS, literalExp);
        }
        //
        return literalExp;
    }
        
    protected AssertExp assertExp(AssertExpCS assertExpCS, 
    		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
    	AssertExp assertAST = ExpressionsFactory.eINSTANCE.createAssertExp();
    	assertAST.setStartPosition(assertExpCS.getStartOffset());
    	assertAST.setEndPosition(assertExpCS.getEndOffset());
    	
    	if(getCompilerOptions().isSourceLineNumbersEnabled()) {
 			int startOffset = assertAST.getStartPosition();
 			if(startOffset < getLexer().getInputChars().length) {
     			assertAST.setLine(getLexer().getLineNumberOfCharAt(assertAST.getStartPosition()));    				
 			}
     	}
    	
    	if(assertExpCS.getAssertion() != null) {
    		assertAST.setAssertion(oclExpressionCS(assertExpCS.getAssertion(), env));
    	}
    	
    	if(assertExpCS.getSeverity() != null) {
    		String severityCSVal = assertExpCS.getSeverity().getValue();
    		if(severityCSVal != null) {
    			SeverityKind actualSeverity = SeverityKind.get(severityCSVal);
    			if(actualSeverity != null) {
    				assertAST.setSeverity(actualSeverity);
    			} else {
    				CSTNode errorNode = assertExpCS.getSeverity();
    				QvtOperationalUtil.reportError(env, NLS.bind(ValidationMessages.UknownSeverityKindError, severityCSVal), errorNode);
    			}
    		}
    	}
    	
    	if(assertExpCS.getLog() != null) {
    		assertAST.setLog(logExp(assertExpCS.getLog(), env));
    	}    	    	

    	validateAssertExp(assertAST, env);    	
    	return assertAST;
    }
    
    private void validateAssertExp(AssertExp assertExp, 
    		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
    	EClassifier boolType = env.getOCLStandardLibrary().getBoolean();
    	if(assertExp.getAssertion() == null || assertExp.getAssertion().getType() != boolType) {
    		ASTNode errNode = assertExp.getAssertion() != null ? assertExp.getAssertion() : assertExp;
    		QvtOperationalUtil.reportError(env, ValidationMessages.BooleanTypeAssertConditionError, 
    				errNode.getStartPosition(), errNode.getEndPosition());
    	}
    	
    	LogExp logExp = assertExp.getLog();
    	if(logExp != null) {
    		validateLogExp(logExp, env);    		
    	}
    }        
    
    private void validateLogExp(LogExp logExp, 
    		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
    	EList<OCLExpression<EClassifier>> allArgs = logExp.getArgument();
    	if(allArgs.isEmpty()) {
    		QvtOperationalUtil.reportError(env, ValidationMessages.MissingMessageLogExpArgumentError, logExp.getStartPosition(), logExp.getEndPosition());
    	}
    	
    	int pos = 1;
    	for (OCLExpression<EClassifier> arg : allArgs) {
    		switch (pos) {
			case 1:
				EClassifier stringType = env.getOCLStandardLibrary().getString();
				if(stringType != arg.getType()) {
					QvtOperationalUtil.reportError(env, ValidationMessages.StringTypeMessageLogArgumentError, arg.getStartPosition(), arg.getEndPosition());
				}
				break;
			case 2:
				// anything accepted here
				break;				
			case 3:
				EClassifier intType = env.getOCLStandardLibrary().getInteger();
				if(intType != arg.getType()) {
					QvtOperationalUtil.reportError(env, ValidationMessages.LogLevelNumberArgumentError, arg.getStartPosition(), arg.getEndPosition());
				}
				
				break;				

			default:
				QvtOperationalUtil.reportError(env, NLS.bind(ValidationMessages.UnsupportedLogExpArgumentError, pos), arg.getStartPosition(), arg.getEndPosition());				
			}
    		pos++;
		}
    	
    	OCLExpression<EClassifier> condition = logExp.getCondition();
    	if(condition != null && condition.getType() != env.getOCLStandardLibrary().getBoolean()) {    		
    		QvtOperationalUtil.reportError(env, ValidationMessages.LogExpBooleanTypeConditionError, 
    				condition.getStartPosition(), condition.getEndPosition());
    	}
    }
        
    protected LogExp logExp(LogExpCS logExpCS, Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
    	
    	LogExp logAST = ExpressionsFactory.eINSTANCE.createLogExp();
    	logAST.setStartPosition(logExpCS.getStartOffset());
    	logAST.setEndPosition(logExpCS.getEndOffset());
    	
    	logAST.setName("log"); //$NON-NLS-1$
    	for (OCLExpressionCS argCS : logExpCS.getArguments() ) {
			OCLExpression<EClassifier> arg = this.oclExpressionCS(argCS, env);
			if(arg != null) {
				logAST.getArgument().add(arg);
			}
		}
    	
    	if(logExpCS.getCondition() != null) {
    		logAST.setCondition(oclExpressionCS(logExpCS.getCondition(), env));
    	}
    	
    	validateLogExp(logAST, env);   	
    	return logAST;
	}

    @Override
    protected Variable<EClassifier, EParameter> variableDeclarationCS(VariableCS variableDeclarationCS,
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            boolean addToEnvironment) {
        Variable<EClassifier, EParameter> varDecl = super.variableDeclarationCS(variableDeclarationCS, env, addToEnvironment);
        if ((varDecl.getType() == null) && (varDecl.getInitExpression() != null)) {
            varDecl.setType(varDecl.getInitExpression().getType());
        }
        
        // AST binding 
        if(myCompilerOptions.isGenerateCompletionData()) {
        	ASTBindingHelper.createCST2ASTBinding(variableDeclarationCS, varDecl);
        }
        //
        return varDecl;
    }
	
    @Override
    protected OCLExpression<EClassifier> propertyCallExpCS(CallExpCS propertyCallExpCS, 
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env)
             {
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
            if(myCompilerOptions.isGenerateCompletionData()) {          
            	createPropertyCallASTBinding(propertyCallExpCS, result, env);
            }
        }
        return result;
    }
    
    @Override
    protected OCLExpression<EClassifier> simpleNameCS(
    		SimpleNameCS simpleNameCS,
    		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
    		OCLExpression<EClassifier> source) {
    	
    	OCLExpression<EClassifier> result = customSimpleNameCS(simpleNameCS, env, source);

        // AST binding    	
        if(myCompilerOptions.isGenerateCompletionData()) {    	
            ASTBindingHelper.createCST2ASTBinding(simpleNameCS, result);
        }
    	//
    	
    	return result;
    }
    
    @Override
    protected OCLExpression<EClassifier> operationCallExpCS(
    		OperationCallExpCS operationCallExpCS,
    		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
    	OCLExpression<EClassifier> result = super.operationCallExpCS(operationCallExpCS, env);
    	
    	if(result instanceof OperationCallExp) {
    	    OperationCallExp<EClassifier, EOperation> opCallExp = (OperationCallExp<EClassifier, EOperation>) result;
    	    OCLExpression<EClassifier> source = opCallExp.getSource();
            if (source != null) {
                if (isArrowAccessToCollection(operationCallExpCS, source)) {
                	// FIXME - use OCL TypeChecker::isStdLibOperation()
                    // Is it a standard operation like "select"?
                    // In other words, did lookupOperation() in genOperationCallExp() return something?
                    List<EOperation> operations = TypeUtil.getOperations(env, source.getType());
                    boolean isStdOperation = (operations != null) 
                            && (opCallExp.getReferredOperation() != null) 
                            && operations.contains(opCallExp.getReferredOperation());
                    if (!isStdOperation) {
                        result = createImplicitXCollect(source, opCallExp, env, operationCallExpCS);
                    }
                }
    	    }
            DeprecatedImplicitSourceCallHelper.validateCallExp(operationCallExpCS, opCallExp, env);
    	}
    	
    	return result;
    }
    
    @Override
    protected OperationCallExp<EClassifier, EOperation> genOperationCallExp(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            OperationCallExpCS operationCallExpCS, String rule,
            String operName, OCLExpression<EClassifier> source,
            EClassifier ownerType, List<OCLExpression<EClassifier>> args) {
        EClassifier operationSourceType = ownerType;
        if (isArrowAccessToCollection(operationCallExpCS, source)
                && (lookupOperation(operationCallExpCS, env, ownerType, operName, args) == null)) {
            @SuppressWarnings("unchecked") //$NON-NLS-1$
            CollectionType<EClassifier, EOperation> sourceType = (CollectionType<EClassifier, EOperation>) ownerType;
            operationSourceType = sourceType.getElementType();
        }
        return super.genOperationCallExp(env, operationCallExpCS, rule, operName,
                source, operationSourceType, args);
    }

    /**
     * Creates an implicit <code>xcollect</code> iterator expression for a
     * property call on a collection-type source expression.
     * 
     * @param source the property call source expression
     * @param propertyCall the property call expression
     * @param fEnv the current environment
     * 
     * @return the xcollect expression
     * @throws TerminateException 
     */
    protected ImperativeIterateExp createImplicitXCollect(OCLExpression<EClassifier> source,
            FeatureCallExp<EClassifier> propertyCall,
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env,
            CSTNode cstNode) {
        
        @SuppressWarnings("unchecked") //$NON-NLS-1$
        EClassifier sourceElementType = ((CollectionType<EClassifier, EOperation>) source.getType())
            .getElementType();
        
        ImperativeIterateExp result = ExpressionsFactory.eINSTANCE.createImperativeIterateExp();
        initASTMapping(env, result, cstNode);       
        Variable<EClassifier, EParameter> itervar =
            genVariableDeclaration(cstNode, "modelPropertyCallCS", env,//$NON-NLS-1$
                        null, sourceElementType, null, false, true, false);

        List<Variable<EClassifier, EParameter>> iters = result.getIterator();
        iters.add(itervar);
        result.setBody(propertyCall);
        result.setName("xcollect");//$NON-NLS-1$
        VariableExp<EClassifier, EParameter> vexp = oclFactory.createVariableExp();
        initASTMapping(env, vexp, cstNode);
        vexp.setType(itervar.getType());
        vexp.setReferredVariable(itervar);
        vexp.setName(itervar.getName());
        
        /* adjust the source variable for the body expression to be the
           newly generated implicit iterator variable */
        propertyCall.setSource(vexp);
        
        if (!(propertyCall instanceof OperationCallExp)) {
            // the overall start and end positions are the property positions
            propertyCall.setStartPosition(propertyCall.getPropertyStartPosition());
            propertyCall.setEndPosition(propertyCall.getPropertyEndPosition());
        }
        
        result.setSource(source);
        
        EClassifier bodyType = propertyCall.getType();
        
        if (source.getType() instanceof SequenceType ||
                source.getType() instanceof OrderedSetType) {
            EClassifier c = getCollectionType(
                    env,
                    CollectionKind.SEQUENCE_LITERAL,
                    bodyType);
            result.setType(c);
        } else {
            EClassifier c = getCollectionType(
                    env,
                    CollectionKind.BAG_LITERAL,
                    bodyType);
            result.setType(c);
        }
        
        env.deleteElement(itervar.getName());
        
        return result;
    }
    
    private boolean isArrowAccessToCollection(CallExpCS callExpCS, OCLExpression<EClassifier> source) {
        if (source == null) {
            return false;
        }
        return (callExpCS.getAccessor().getValue() == DotOrArrowEnum.ARROW) 
                && (source.getType() instanceof CollectionType);
    }
    
	@Override
    protected OCLExpression<EClassifier> variableExpCS(
            VariableExpCS variableExpCS,
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
        OCLExpression<EClassifier> result = super.variableExpCS(variableExpCS, env);
        
        if(result instanceof PropertyCallExp) {
        	DeprecatedImplicitSourceCallHelper.validateCallExp(variableExpCS, (PropertyCallExp<EClassifier, ?>)result, env);
        }
        
        // AST binding      
        if(myCompilerOptions.isGenerateCompletionData()) {      
            ASTBindingHelper.createCST2ASTBinding(variableExpCS, result);
        }
        //
        return result;
    }

    private OCLExpression<EClassifier> visitOclExpressionCS(OCLExpressionCS expressionCS, 
    		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
    	
		OCLExpression<EClassifier> result = oclExpressionCS(expressionCS, env);
		if (expressionCS instanceof MappingCallExpCS) {
		    if (result instanceof OperationCallExp) {
		        MappingCallExp mappingCallExp = createMappingCallExp((MappingCallExpCS) expressionCS, result);
		        if (mappingCallExp != null) {
		            return mappingCallExp;
		        }
		    } else if (result instanceof IteratorExp) {
		        IteratorExp<EClassifier, EParameter> iteratorExp = (IteratorExp<EClassifier, EParameter>) result;
		        MappingCallExp mappingCallExp = createMappingCallExp((MappingCallExpCS) expressionCS, iteratorExp.getBody());
		        if (mappingCallExp != null) {
		            iteratorExp.setBody(mappingCallExp);
		            return iteratorExp;
		        }
		    } else if (result instanceof ImperativeIterateExp) {
		        ImperativeIterateExp imperativeIterateExp = (ImperativeIterateExp) result;
		        MappingCallExp mappingCallExp = createMappingCallExp((MappingCallExpCS) expressionCS, imperativeIterateExp.getBody());
		        if (mappingCallExp != null) {
		            imperativeIterateExp.setBody(mappingCallExp);
		            return imperativeIterateExp;
		        }
		    }
		    QvtOperationalUtil.reportError(env, ValidationMessages.mappingOperationExpected, expressionCS);
			return null;
		}

		return result;
	}

    private OCLExpression<EClassifier> visitBlockExpCS(BlockExpCS expressionCS, 
    		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
    	
    	Collection<Variable<EClassifier, EParameter>> beginScopeVars = null;
    	if(expressionCS.eContainer() instanceof ImperativeOperation == false) {  
    		// variables defined in the scope of operation handled by environment scope		
    		beginScopeVars = env.getVariables();
    	}
    	
    	try {
    		return doVisitBlockExpCS(expressionCS, env);
    	} 
    	finally {
    		if(beginScopeVars != null) {
    			// remove variables of this scope when leaving it, only successfully added variables into fEnv
    			// in this block scope will be removed, so we can not remove outer scope 
    			// existing variables. 
    			// Note: nested block scopes have done their clean-up already so we remove
    			// only our stuff
    			Collection<Variable<EClassifier, EParameter>> endScopeVars = env.getVariables();
    			for (Variable<EClassifier, EParameter> nextVar : endScopeVars) {
    				// remove those new in the scope
    				if(!beginScopeVars.contains(nextVar)) {
    					env.deleteElement(nextVar.getName());
    				}
    			}
    		}
    	}
    }
    
    private OCLExpression<EClassifier> doVisitBlockExpCS(BlockExpCS expressionCS, 
    		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
    	
		BlockExp result = ExpressionsFactory.eINSTANCE.createBlockExp();
		result.setStartPosition(expressionCS.getStartOffset());
		result.setEndPosition(expressionCS.getEndOffset());
		result.setType(env.getOCLStandardLibrary().getOclVoid());

		for (OCLExpressionCS oclExpCS : expressionCS.getBodyExpressions()) {
			OCLExpression<EClassifier> bodyExp = visitOclExpressionCS(oclExpCS, env);
			if (bodyExp != null) {
    				result.getBody().add(bodyExp);
			}
		}
		
		return result;
    }
    
    private OCLExpression<EClassifier> visitComputeExpCS(ComputeExpCS computeExpCS, 
    		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
    	
        ComputeExp result = ExpressionsFactory.eINSTANCE.createComputeExp();
        result.setStartPosition(computeExpCS.getStartOffset());
        result.setEndPosition(computeExpCS.getEndOffset());
        
        Variable<EClassifier, EParameter> returnedElementExp = variableDeclarationCS(computeExpCS.getReturnedElement(), env, true);
        result.setReturnedElement(returnedElementExp);
        result.setType(returnedElementExp.getType());
        
        OCLExpression<EClassifier> bodyExp = visitOclExpressionCS(computeExpCS.getBody(), env);
        result.setBody(bodyExp);
        
        if (returnedElementExp != null) {
            env.deleteElement(returnedElementExp.getName());
        }
        return result;
    }
    
    private OCLExpression<EClassifier> visitSwitchExpCS(SwitchExpCS switchExpCS, 
    		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
    	
		SwitchExp switchExp = ExpressionsFactory.eINSTANCE.createSwitchExp();
		switchExp.setStartPosition(switchExpCS.getStartOffset());
		switchExp.setEndPosition(switchExpCS.getEndOffset());
		
		List<EClassifier> allPartTypes = new ArrayList<EClassifier>();
		if (switchExpCS.getAlternativePart() != null) {
		    for (SwitchAltExpCS altExpCS : switchExpCS.getAlternativePart()) {
		    	AltExp altExp = visitSwitchAltExpCS(altExpCS, env);
		        switchExp.getAlternativePart().add((AltExp) altExp);
		        allPartTypes.add(altExp.getBody() != null ? altExp.getBody().getType() : null);
		    }
		}
		if (switchExpCS.getElsePart() != null) {
		    OCLExpression<EClassifier> elsePart = visitOclExpressionCS(switchExpCS.getElsePart(), env);
		    switchExp.setElsePart(elsePart);
		    allPartTypes.add(elsePart.getType());
		}
		
		if (allPartTypes.isEmpty()) {
		    switchExp.setType(getOclVoid());
		}
		else if (allPartTypes.size() == 1) {
		    switchExp.setType(allPartTypes.get(0));
		}
		else {
			EClassifier type = null;
			for (int i = 0; i+1 < allPartTypes.size(); ++i) {
				type = TypeUtil.commonSuperType(switchExpCS, env,
						allPartTypes.get(i), allPartTypes.get(i+1));
				if (type == null) {
					break;
				}
			}
			switchExp.setType(type == null ? getOclVoid() : type);
		}
		
		return switchExp;
    }

	private AltExp visitSwitchAltExpCS(SwitchAltExpCS altExpCS, 
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		
	    AltExp altExp = ExpressionsFactory.eINSTANCE.createAltExp();
	    altExp.setStartPosition(altExpCS.getStartOffset());
	    altExp.setEndPosition(altExpCS.getEndOffset());
        
	    OCLExpression<EClassifier> condition = visitOclExpressionCS(altExpCS.getCondition(), env);
	    altExp.setCondition(condition);
	    OCLExpression<EClassifier> body = visitOclExpressionCS(altExpCS.getBody(), env);
	    altExp.setBody(body);
	    return altExp;
    }

    private OCLExpression<EClassifier> visitWhileExpCS(WhileExpCS expressionCS, 
    		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		WhileExp result = ExpressionsFactory.eINSTANCE.createWhileExp();
		result.setStartPosition(expressionCS.getStartOffset());
		result.setEndPosition(expressionCS.getEndOffset());
		
		String resultVarName = null;
		if(expressionCS.getResultVar() != null) {
			VariableCS varCS = expressionCS.getResultVar();
			Variable<EClassifier, EParameter> var = null;

			Variable<EClassifier, EParameter> prevVar = env.lookup(varCS.getName());			
			var = variableDeclarationCS(varCS, env, true);
			if(prevVar != null) {
				env.addElement(varCS.getName(), prevVar, true);
			} else {
				resultVarName = varCS.getName();				
			}
			
			
			result.setResultVar(var);
			result.setType(var.getType());							
		} else if(expressionCS.getResult() != null) {
			// report usage of legacy while
			QvtOperationalUtil.reportWarning(env, ValidationMessages.QvtOperationalVisitorCS_deprecatedWhileExp, expressionCS);
			OCLExpression<EClassifier> resExp = visitOclExpressionCS(expressionCS.getResult(), env);
			result.setType(resExp.getType());
			result.setResult(resExp);
		} else {
			result.setType(env.getOCLStandardLibrary().getOclVoid());
		}

		OCLExpression<EClassifier> condExp = visitOclExpressionCS(expressionCS.getCondition(), env);
		result.setCondition(condExp);		
		if(condExp != null) {
			EClassifier condType = condExp.getType();
			if(env.getOCLStandardLibrary().getBoolean() != condExp.getType()) {
				if(condType == null) {
					condType = env.getOCLStandardLibrary().getOclVoid();
				}
				String message = NLS.bind(ValidationMessages.QvtOperationalVisitorCS_booleanTypeExpressionExpected, env.getUMLReflection().getName(condType));
				if(expressionCS.getResult() == null) {
					QvtOperationalUtil.reportError(env, message, expressionCS.getCondition());
				} else {
					// warn for legacy code to keep compilable, as it was not reported at all
					QvtOperationalUtil.reportWarning(env, message, expressionCS.getCondition());
				}
			}
		}
		
		List<OCLExpressionCS> bodyCS = result.getBody() instanceof BlockExpCS ? ((BlockExpCS)result.getBody()).getBodyExpressions() : Collections.<OCLExpressionCS>singletonList(expressionCS.getBody());
		BlockExp body = ExpressionsFactory.eINSTANCE.createBlockExp();
		for (OCLExpressionCS oclExpCS : bodyCS) {
			OCLExpression<EClassifier> bodyExp = visitOclExpressionCS(oclExpCS, env);
			if (bodyExp != null) {
    				body.getBody().add(bodyExp);
			}
		}
		
		result.setBody(body);

		if(resultVarName != null) {
			env.deleteElement(resultVarName);
		}
		
		return result;
	}
    
    private static MappingDeclarationCS findOwningMappingDeclarationCS(OutExpCS outExpCS) {
    	EObject eContainer = outExpCS.eContainer();
    	if (eContainer instanceof MappingBodyCS) {
    	    eContainer = eContainer.eContainer();
            if (eContainer instanceof MappingSectionsCS) {
                eContainer = eContainer.eContainer();
                if (eContainer instanceof MappingRuleCS) {
                    MappingRuleCS mappingCS = (MappingRuleCS) eContainer;
                    return mappingCS.getMappingDeclarationCS();
                }
            }
    	}
    	return null;
    }

    private ObjectExp visitOutExpCS(OutExpCS outExpCS, QvtOperationalEnv env, boolean isValidationChecked) {
		MappingDeclarationCS topLevelInMapping = findOwningMappingDeclarationCS(outExpCS);		
		if(topLevelInMapping != null && topLevelInMapping.getResult().isEmpty() && topLevelInMapping.getContextType() == null) {
			//return null; FIXME - review this, ommitted to get better error reporting for AST
		}
		
		TypeSpecCS typeSpecCS = null;
		if (outExpCS.getTypeSpecCS() != null) {
			typeSpecCS = outExpCS.getTypeSpecCS();
		}

		ObjectExp objectExp = ExpressionsFactory.eINSTANCE.createObjectExp();
		objectExp.setStartPosition(outExpCS.getStartOffset());
		objectExp.setEndPosition(outExpCS.getEndOffset());
		
		if(typeSpecCS != null) {
			TypeSpecPair objectTypeSpec = visitTypeSpecCS(typeSpecCS, DirectionKind.OUT, env);
			
			objectExp.setType(objectTypeSpec.myType);
			if(objectTypeSpec.myType instanceof EClass) {
				// skip DataTypes as the instantiatedClass property expects Class
				// let's make AST validation to complain on missing class.
				// Note: Still can be derived from the referred object if specified explicitly
				objectExp.setInstantiatedClass((EClass)objectTypeSpec.myType);
			}
			objectExp.setExtent(objectTypeSpec.myExtent);
			
		} else if(topLevelInMapping != null) {
			// TODO - support multiple result parameters, for now take the first as the grammar does not allow this yet
			boolean isContextInOut = topLevelInMapping.getDirectionKindCS() != null ? 
					topLevelInMapping.getDirectionKindCS().getDirectionKind() == DirectionKindEnum.INOUT : false;
			
			assert env.getContextOperation() instanceof ImperativeOperation; 
			ImperativeOperation owningOperation = (ImperativeOperation)env.getContextOperation();

			if(owningOperation.getResult().isEmpty()) {
				if(isContextInOut && owningOperation.getContext() != null) {
					objectExp.setType(owningOperation.getContext().getEType());
				}
			}
		}

		if(outExpCS.getSimpleNameCS() != null) {
			// a referred object has been explicitly specified
			String varName = outExpCS.getSimpleNameCS().getValue();
			Variable<EClassifier, EParameter> referredObject  = varName != null ? env.lookup(varName) : null;
			if(referredObject == null) {
				// variable not resolved
				env.reportError(NLS.bind(ValidationMessages.unresolvedNameError, varName), outExpCS.getSimpleNameCS());
			} else {
				// TODO - implicit variables should follow multiplicity [1] referredObject and should always be created
				// for now, only explicit variables are recorded
				objectExp.setName(varName);
				objectExp.setReferredObject(referredObject);
			}
		}
		
		if(objectExp.getReferredObject() != null && objectExp.getType() == null) {
			objectExp.setType(objectExp.getReferredObject().getType());
		}
		
		if(objectExp.getType() instanceof EClass) {				
			objectExp.setInstantiatedClass((EClass)objectExp.getType());
		}		
		
		// try to derive extent from referred variable, if not retrieved from explicit TypeSpec yet
		if (objectExp.getExtent() == null) {
			Variable<EClassifier, EParameter> referredObject  = objectExp.getReferredObject();
			if(referredObject != null) {
				if(referredObject.getRepresentedParameter() instanceof MappingParameter) {			
					MappingParameter mappingPar = (MappingParameter) referredObject.getRepresentedParameter();
					objectExp.setExtent(mappingPar.getExtent());
				} 
			} 
			if (objectExp.getExtent() == null && objectExp.getType() != null) {
				QvtOperationalModuleEnv moduleEnv = getModuleContextEnv(env);				
				objectExp.setExtent(moduleEnv.resolveModelParameter(objectExp.getType(), DirectionKind.OUT));								
			}
		}
						
		EObject rootEObj = EcoreUtil.getRootContainer(outExpCS);
		Module module = null;
		if (env.getInternalParent() instanceof QvtOperationalFileEnv && rootEObj instanceof MappingModuleCS) {
			// FIXME - revisit this hack bellow
			module = ((QvtOperationalFileEnv) env.getInternalParent()).getKernel().getModule((MappingModuleCS) rootEObj);			
		}
		
		if (objectExp.getExtent() == null && module != null && !getModelParameter(module).isEmpty()) {
			QvtOperationalModuleEnv moduleEnv = getModuleContextEnv(env);				
			boolean isInvalidForExtentResolve = false;
			if (objectExp.getReferredObject() == null) { 
				isInvalidForExtentResolve = (objectExp.getType() == null || !moduleEnv.isMayBelongToExtent(objectExp.getType()));
			}
			else {
				if (IntermediateClassFactory.isIntermediateClass(objectExp.getReferredObject().getType())) {
					isInvalidForExtentResolve = true;
				}
				else {
					isInvalidForExtentResolve = !QVTUMLReflection.isUserModelElement(objectExp.getReferredObject().getType());
				}
			}
			if(!isInvalidForExtentResolve) {
				env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_extentFailToInfer,
						QvtOperationalTypesUtil.getTypeFullName(objectExp.getType())),
						typeSpecCS != null ? typeSpecCS : outExpCS);
			}
		}
		
        ConstructorBody body = ExpressionsFactory.eINSTANCE.createConstructorBody();
        body.setStartPosition(outExpCS.getStartOffset());
        body.setEndPosition(outExpCS.getEndOffset());
        objectExp.setBody(body);

        QvtOperationalEnv tempEnv = env.getFactory().createEnvironment(env);
        Variable<EClassifier, EParameter> elem = objectExp.getReferredObject();
        if (elem == null) { // new object creation
            elem = EcoreFactory.eINSTANCE.createVariable();
            elem.setType(objectExp.getType());
            objectExp.setReferredObject(elem);
			}
        String varName = (objectExp.getName() == null) ? env.generateTemporaryName() : objectExp.getName();
        objectExp.setName(varName);
        tempEnv.addImplicitVariableForProperties(varName, elem);
			
		for (OCLExpressionCS expCS : outExpCS.getExpressions()) {
            OCLExpression<EClassifier> exp = visitOclExpressionCS(expCS, tempEnv);
            if (exp != null) {
                body.getContent().add(exp);
            }
			}
			
        if(myCompilerOptions.isGenerateCompletionData()) {
            ASTBindingHelper.createCST2ASTBinding(outExpCS, objectExp, env);
			}

        if (isValidationChecked) {
            validateObjectExp(objectExp, outExpCS, env);
        }
        
        return objectExp;
        }
		
	public Module visitMappingModule(ParsedModuleCS parsedModuleCS, QvtOperationalFileEnv env, QvtCompiler compiler) throws SemanticException {
		MappingModuleCS moduleCS = parsedModuleCS.getModuleCS();
        Module module = env.getKernel().getModule(moduleCS);
        if (module != null) {
            return module;
        }      
        
        module = QvtOperationalParserUtil.createModule(moduleCS);
        env.getKernel().setModule(module, moduleCS);        
		module.setStartPosition(moduleCS.getStartOffset());
		module.setEndPosition(moduleCS.getEndOffset());
        // AST binding
        if(myCompilerOptions.isGenerateCompletionData()) {
            ASTBindingHelper.createModuleBinding(moduleCS, module, env, parsedModuleCS.getSource());
        }
        //
		
		for (ModelTypeCS modelTypeCS : moduleCS.getMetamodels()) {
			ModelType modelType = visitModelTypeCS(modelTypeCS, env, module, compiler.getResourceSet());
			if (modelType == null) {
				continue;
			}
			module.getEClassifiers().add(modelType);
			module.getUsedModelType().add(modelType);
			if (modelType.getName().length() > 0) {
				ModelType existingModelType = env.getModelType(Collections.singletonList(modelType.getName()));
				if(existingModelType == null) {
					env.registerModelType(modelType);
				} else {
					env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_modeltypeAlreadyDefined,
								new Object[] { modelType.getName() }),
								modelTypeCS.getIdentifierCS());
				}
			}
			else {
				env.registerModelType(modelType);
				env.reportWarning(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_modeltypeDeprecatedSyntax, new Object[] { }),
						modelTypeCS);
			}
		}
		
		visitTransformationHeaderCS(moduleCS.getHeaderCS(), env, module, parsedModuleCS.getSource());
		
        env.setContextModule(module);
        
		visitIntermediateClassesCS(env, moduleCS, module);		

		importsCS(parsedModuleCS, module, env, compiler);

		for (RenameCS renameCS : moduleCS.getRenamings()) {
			Rename rename = visitRenameCS(renameCS, env);
			if (rename != null) {
				module.getOwnedRenaming().add(rename);
			}
		}
		
		createModuleProperties(module, moduleCS, env);
		
		HashMap<MappingMethodCS, ImperativeOperation> methodMap = new LinkedHashMap<MappingMethodCS, ImperativeOperation>(moduleCS.getMethods().size());
		
		// declare module operations as they are required to analyze rules' contents
		for (MappingMethodCS methodCS : moduleCS.getMethods()) {
			String name = ""; //$NON-NLS-1$			
			if(methodCS.getMappingDeclarationCS() != null) {
				SimpleNameCS methodNameCS = methodCS.getMappingDeclarationCS().getSimpleNameCS();
				if(methodNameCS != null) {
					name = methodNameCS.getValue(); //$NON-NLS-1$
				}
			}
					
			boolean isMapping = methodCS instanceof MappingRuleCS;
			ImperativeOperation operation = isMapping ? ExpressionsFactory.eINSTANCE.createMappingOperation() : 
					(QvtOperationalEnv.MAIN.equals(name) ? ExpressionsFactory.eINSTANCE.createEntryOperation() : ExpressionsFactory.eINSTANCE.createHelper());
			
			if (visitMappingDeclarationCS(methodCS, env, operation)) {
				EOperation imperativeOp = env.defineImperativeOperation(operation, methodCS instanceof MappingRuleCS, true);
				if(imperativeOp != null) {
					methodMap.put(methodCS, (ImperativeOperation)imperativeOp);
				}
			}
		}
		
		// Handle the case of legacy constructs which allows for signature-less 
		// transformation definition
		DeprecatedSignaturelessTransf.patchModule(module);			
		
		boolean moduleEntryFound = false;
		for (MappingMethodCS methodCS : methodMap.keySet()) {
			ImperativeOperation imperativeOp = methodMap.get(methodCS);
			if(imperativeOp == null) {
				continue;
			}
			
			visitMappingMethodCS(methodCS, env, imperativeOp);				
	        if(myCompilerOptions.isGenerateCompletionData()) {
				//ASTBindingHelper.createCST2ASTBinding(methodCS, imperativeOp, env);
			} 
			
			if ((!QvtOperationalEnv.MAIN.equals(imperativeOp.getName()) || 
					getModelParameter(env.getModuleContextType()).isEmpty()) == false) {
				checkMainMappingConformance(env, imperativeOp);
			}
			
			if (false == moduleCS instanceof LibraryCS
					&& QvtOperationalEnv.MAIN.equals(imperativeOp.getName())) {
				if (moduleEntryFound) {
					env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_entryPointShouldBeDeclOnce,
							QvtOperationalEnv.MAIN), methodCS);
				}
				moduleEntryFound = true;
			}
		}
		
		for (ModuleImport moduleImport : module.getModuleImport()) {
			for (EOperation operation : QvtOperationalParserUtil.getOwnedOperations(moduleImport.getImportedModule())) {
				if(operation instanceof MappingOperation) {
					MappingOperation mappingOperation = (MappingOperation) operation;
					env.registerMappingOperation(mappingOperation);
				}
			}
		}
		
		env.resolveResolveInExpInMappings();
		
		ImperativeOperation mainMethod = QvtOperationalParserUtil.getMainOperation(module);
		if(mainMethod instanceof EntryOperation) {
			module.setEntry((EntryOperation)mainMethod);
		}

		validate(env);

		return module;
	}

	private void visitIntermediateClassesCS(QvtOperationalEnv env, MappingModuleCS moduleCS, Module module) throws SemanticException {
		
		Map<String, EClass> createdIntermClasses = new LinkedHashMap<String, EClass>(moduleCS.getClassifierDefCS().size());
		final Map<EClass, CSTNode> cstIntermClassesMap = new LinkedHashMap<EClass, CSTNode>();
		for (ClassifierDefCS classifierDefCS : moduleCS.getClassifierDefCS()) {
			if (createdIntermClasses.containsKey(classifierDefCS.getSimpleNameCS().getValue())) {
	            env.reportError(NLS.bind(ValidationMessages.DuplicateClassifier,
	            		new Object[] { classifierDefCS.getSimpleNameCS().getValue() }), classifierDefCS.getSimpleNameCS());
				continue;
			}

			org.eclipse.m2m.internal.qvt.oml.expressions.Class eClassifier = IntermediateClassFactory.getFactory(module).createIntermediateClassifier();
			eClassifier.setStartPosition(classifierDefCS.getStartOffset());
			eClassifier.setEndPosition(classifierDefCS.getEndOffset());
			
			eClassifier.setName(classifierDefCS.getSimpleNameCS().getValue());
			
			createdIntermClasses.put(eClassifier.getName(), eClassifier);
			cstIntermClassesMap.put(eClassifier, classifierDefCS.getSimpleNameCS());
		}

		if (!createdIntermClasses.isEmpty()) {
			IntermediateClassFactory.getFactory(module).registerModelType(env);
		}

		for (ClassifierDefCS classifierDefCS : moduleCS.getClassifierDefCS()) {
			String className = classifierDefCS.getSimpleNameCS().getValue();
			EClass rootClass = createdIntermClasses.get(className);			
			for (TypeCS typeCS : classifierDefCS.getExtends()) {
				
				if (typeCS instanceof PathNameCS && ((PathNameCS) typeCS).getSequenceOfNames().size() == 1) {
					EClass extClass = createdIntermClasses.get(((PathNameCS) typeCS).getSequenceOfNames().get(0));
					if (extClass != null) {
						rootClass.getESuperTypes().add(extClass);
						continue;
					}
				}
				
				EClassifier extendType = visitTypeCS(typeCS, null, env);
				if (extendType == null) {
					// error reported by visitTypeCS(..)
					continue;
				}
				else if (!QVTUMLReflection.isUserModelElement(extendType)) {
					env.reportError(NLS.bind(ValidationMessages.InvalidClassifierForExtend,
							QvtOperationalTypesUtil.getTypeFullName(extendType)),
							typeCS);
				}
				else {
					rootClass.getESuperTypes().add((EClass) extendType);
				}
			}
		}

		for (ClassifierDefCS classifierDefCS : moduleCS.getClassifierDefCS()) {
			String className = classifierDefCS.getSimpleNameCS().getValue();
			if (!createdIntermClasses.containsKey(className)) {
				continue;
			}
			visitClassifierDefCS(classifierDefCS, createdIntermClasses.get(className), module, env);
		}
		
		class CycleChecker {
			boolean checkClass(EClass cls) {
				myVisitedClasses.clear();
				return checkClassImpl(cls);
			}
			
			private boolean checkClassImpl(EClass cls) {
				myVisitedClasses.add(cls);
				for (EClass superCls : cls.getESuperTypes()) {
					// check only intermediate hierarchy
					if (!cstIntermClassesMap.containsKey(superCls)) {
						continue;
					}
					if (myVisitedClasses.contains(superCls)) {
						return false;
					}
					if (!checkClassImpl(superCls)) {
						return false;
					}
				}
				return true;
			}
			
			final Set<EClass> myVisitedClasses = new HashSet<EClass>(2);
		}
		
		CycleChecker cycleChecker = new CycleChecker();
		for (EClass nextClass : cstIntermClassesMap.keySet()) {
			if (!cycleChecker.checkClass(nextClass)) {
				env.reportError(NLS.bind(ValidationMessages.CycleInIntermHierarchy,
						QvtOperationalTypesUtil.getTypeFullName(nextClass)),
						cstIntermClassesMap.get(nextClass));
			}

			//nextClass.getESuperTypes().add(EcorePackage.Literals.ECLASS);
			
			Map<String, EStructuralFeature> ownFeatures = new HashMap<String, EStructuralFeature>(nextClass.getEStructuralFeatures().size());
			for (EStructuralFeature nextFeature : nextClass.getEStructuralFeatures()) {
				ownFeatures.put(nextFeature.getName(), nextFeature);
			}
			for (EStructuralFeature nextFeature : nextClass.getEAllStructuralFeatures()) {
				EStructuralFeature ownFeature = ownFeatures.get(nextFeature.getName());
				if (ownFeature != null && ownFeature != nextFeature) {
					env.reportError(NLS.bind(ValidationMessages.HidingProperty,
							nextFeature.getName()),
							cstIntermClassesMap.get(nextClass));
				}
			}
			
//			org.eclipse.emf.common.util.Diagnostic validate = new org.eclipse.emf.ecore.util.Diagnostician().validate(nextClass);
//			if (validate.getSeverity() != org.eclipse.emf.common.util.Diagnostic.OK) {
//				System.err.println(validate.getMessage());
//			}
		}
		
	}
	
	private EClass visitClassifierDefCS(ClassifierDefCS classifierDefCS, EClass eClassifier, Module module, QvtOperationalEnv env) throws SemanticException {

		class PropertyPair {
			final EStructuralFeature myEFeature;
			final ClassifierPropertyCS myPropCS;
			
			PropertyPair(EStructuralFeature eFeature, ClassifierPropertyCS propCS) {
				myEFeature = eFeature;
				myPropCS = propCS;
			}
		}

		Map<String, List<PropertyPair>> classifierProperties = new LinkedHashMap<String, List<PropertyPair>>(classifierDefCS.getProperties().size());
		
		for (ClassifierPropertyCS propCS : classifierDefCS.getProperties()) {
			EStructuralFeature eFeature = visitClassifierPropertyCS(propCS, env);
			if (eFeature == null) {
				continue;
			}
			
			eClassifier.getEStructuralFeatures().add(eFeature);
			OCLExpression<EClassifier> initExp = QvtOperationalParserUtil.getInitExpression(eFeature);
			if (initExp != null) {
				IntermediateClassFactory.getFactory(module).addClassifierPropertyInit(eClassifier, eFeature, initExp);
			}

			List<PropertyPair> properties = classifierProperties.get(eFeature.getName());
			if (properties == null) {
				properties = new ArrayList<PropertyPair>(2);
				classifierProperties.put(eFeature.getName(), properties);
			}
			properties.add(new PropertyPair(eFeature, propCS));
		}
		
		for (String propName : classifierProperties.keySet()) {
			List<PropertyPair> properties = classifierProperties.get(propName);
			if (properties.size() == 1) {
				continue;
			}
			for (PropertyPair propPair : properties) {
				HiddenElementAdapter.markAsHidden(propPair.myEFeature);
	            env.reportError(NLS.bind(ValidationMessages.DuplicateProperty,
	            		new Object[] { eClassifier.getName() + '.' + propPair.myEFeature.getName() }), propPair.myPropCS.getSimpleNameCS());
			}
		}
		
		return eClassifier;
	}

	private EStructuralFeature visitClassifierPropertyCS(ClassifierPropertyCS propCS, QvtOperationalEnv env) {
		EClassifier propertyEType = null;
		if (propCS.getTypeCS() != null) {
			propertyEType = visitTypeCS(propCS.getTypeCS(), null, env);
		}

		EStructuralFeature eFeature = createESFeature(propertyEType);
		eFeature.setName(propCS.getSimpleNameCS().getValue());		
		eFeature.setEType(propertyEType);

		ASTSyntheticNode astNode = ASTSyntheticNodeAccess.createASTNode(eFeature);
		astNode.setStartPosition(propCS.getStartOffset());
		astNode.setEndPosition(propCS.getEndOffset());
		
		// handle stereotype qualifiers
		Set<String> handledStereotypes = new HashSet<String>(2);
		for (SimpleNameCS nameCS : propCS.getStereotypeQualifiers()) {
			String qualifName = nameCS.getValue();
			if ("id".equals(qualifName)) { //$NON-NLS-1$
				if (eFeature instanceof EAttribute) {
					((EAttribute) eFeature).setID(true);
				}
				else {
		            env.reportError(NLS.bind(ValidationMessages.IntermClassifier_unapplicableStereotypeQualifier,
		            		new Object[] { qualifName }), nameCS);
				}
			}
			else {
	            env.reportWarning(NLS.bind(ValidationMessages.IntermClassifier_unknownStereotypeQualifier,
	            		new Object[] { qualifName }), nameCS);
			}

			if (handledStereotypes.contains(qualifName)) {
	            env.reportWarning(NLS.bind(ValidationMessages.IntermClassifier_duplicatedStereotypeQualifier,
	            		new Object[] { qualifName }), nameCS);
			}
			handledStereotypes.add(qualifName);
		}
		
		// handle feature keys
		Set<String> handledFeatureKeys = new HashSet<String>(2);
		for (SimpleNameCS nameCS : propCS.getFeatureKeys()) {
			String keyName = nameCS.getValue();
			if ("composes".equals(keyName)) { //$NON-NLS-1$
				if (eFeature instanceof EReference) {
					((EReference) eFeature).setContainment(true);
				}
				else {
		            env.reportError(NLS.bind(ValidationMessages.IntermClassifier_referenceOnlyFeatureKey,
		            		new Object[] { keyName }), nameCS);
				}
			}
			else if ("references".equals(keyName)) { //$NON-NLS-1$
				if (eFeature instanceof EReference) {
					((EReference) eFeature).setContainment(false);
				}
				else {
		            env.reportError(NLS.bind(ValidationMessages.IntermClassifier_referenceOnlyFeatureKey,
		            		new Object[] { keyName }), nameCS);
				}
			}
			else if ("readonly".equals(keyName)) { //$NON-NLS-1$
				eFeature.setChangeable(false);
			}
			else if ("derived".equals(keyName)) { //$NON-NLS-1$
				
			}
			else if ("static".equals(keyName)) { //$NON-NLS-1$
	            env.reportWarning(NLS.bind(ValidationMessages.IntermClassifier_unsupportedFeatureKey,
	            		new Object[] { keyName }), nameCS);
			}

			if (handledFeatureKeys.contains(keyName)) {
	            env.reportWarning(NLS.bind(ValidationMessages.IntermClassifier_duplicatedFeatureKey,
	            		new Object[] { keyName }), nameCS);
			}
			handledFeatureKeys.add(keyName);
		}
		
		if (propCS.getMultiplicity() != null) {
			MultiplicityDef multiplcityDef = visitMultiplicityDefCS(propCS.getMultiplicity(), env);
			eFeature.setLowerBound(multiplcityDef.lower);
			eFeature.setUpperBound(multiplcityDef.upper);
		}
		
		eFeature.setOrdered(propCS.isIsOrdered());

		// handle initialization expression
		OCLExpression<EClassifier> initExpression = null;
		if (propCS.getOclExpressionCS() != null) {
			initExpression = visitOclExpressionCS(propCS.getOclExpressionCS(), env);
			QvtOperationalParserUtil.setInitExpression(eFeature, initExpression);			
		}
		
		if (eFeature.getEType() == null && initExpression != null) {
			eFeature.setEType(initExpression.getType());
		}
		
		if (initExpression != null) {
			EClassifier realType = initExpression.getType();
			EClassifier declaredType = env.getUMLReflection().getOCLType(eFeature);
			if (!QvtOperationalParserUtil.isAssignableToFrom(env, declaredType, realType)) {
				env.reportError(NLS.bind(ValidationMessages.SemanticUtil_17,
						new Object[] { QvtOperationalTypesUtil.getTypeFullName(declaredType), QvtOperationalTypesUtil.getTypeFullName(realType) }),
						astNode.getStartPosition(), astNode.getEndPosition());
			}
		}

		return eFeature;
	}
	
	private static class MultiplicityDef {
		public int lower = 0;
		public int upper = 1;
	}
	
	private MultiplicityDef visitMultiplicityDefCS(MultiplicityDefCS multiplicityCS, QvtOperationalEnv env) {
		MultiplicityDef multiplicityDef = new MultiplicityDef();

		try {
			multiplicityDef.lower = Integer.valueOf(multiplicityCS.getLowerBound().getSymbol());
			if ("*".equals(multiplicityCS.getUpperBound().getSymbol())) {
				multiplicityDef.upper = -1;
			}
			else {
				multiplicityDef.upper = Integer.valueOf(multiplicityCS.getUpperBound().getSymbol());
			}
			
			// check UML constraints [7.3.32]
			if (multiplicityDef.lower < 0) {
				throw new NumberFormatException(ValidationMessages.IntermClassifier_multiplicityInvalidLowerBound);
			}
			if (multiplicityDef.upper >= 0 && multiplicityDef.lower > multiplicityDef.upper) {
				throw new NumberFormatException(ValidationMessages.IntermClassifier_multiplicityInvalidRange);
			}
			if (multiplicityDef.upper == 0 && multiplicityDef.lower == 0) {
				throw new NumberFormatException(ValidationMessages.IntermClassifier_multiplicityEmptyRange);
			}
		}
		catch (NumberFormatException ex) {
            env.reportError(ex.getLocalizedMessage(), multiplicityCS);
			// default multiplicity from specification [8.4.6]
            multiplicityDef = new MultiplicityDef();
		}
		
		return multiplicityDef;
	}
	
	private void importsCS(ParsedModuleCS parsedModuleCS, Module module, QvtOperationalFileEnv env, QvtCompiler compiler) {
		List<ImportCS> importsToProcessCopy = new ArrayList<ImportCS>(parsedModuleCS.getModuleCS().getImports());
		for (ParsedModuleCS importedModuleCS : parsedModuleCS.getParsedImports()) {
			// Check for duplicate imports is handled by QvtCompiler
			Module importedModule = compiler.analyse(importedModuleCS, myCompilerOptions).getModule().getModule();
			if (importedModule == null) {
				continue;
			}

			ModuleImport moduleImport = ExpressionsFactory.eINSTANCE.createModuleImport();
			moduleImport.setImportedModule(importedModule);
			module.getModuleImport().add(moduleImport);

			ImportCS cstImport = null;
			for (ImportCS nextImport : parsedModuleCS.getModuleCS().getImports()) {
				if(nextImport.getPathNameCS() != null && parsedModuleCS.getParsedImport(nextImport.getPathNameCS()) == importedModuleCS) {
					cstImport = nextImport;
					if(myCompilerOptions.isGenerateCompletionData()) {
						ASTBindingHelper.createCST2ASTBinding(nextImport, moduleImport);
					}
				}
			}

			if (cstImport != null) {
				importsToProcessCopy.remove(cstImport);				
				moduleImport.setStartPosition(cstImport.getStartOffset());
				moduleImport.setEndPosition(cstImport.getEndOffset());
			}
			 
			if(module instanceof OperationalTransformation && importedModule  instanceof OperationalTransformation) {
				validateImportedSignature(env, (OperationalTransformation) module, (OperationalTransformation) importedModule, moduleImport);
			}
		}
		// - handle the unparsed modules - either not found or black-box
		// - ignore those not found, as this is handled by the compiler and report only 
		//   black-box loading failures.
		BlackboxModuleHelper blackboxUnitHelper = compiler.getBlackboxUnitHelper();
		blackboxUnitHelper.setContext(
				new ResolutionContextImpl(env.getFile()),
				new LoadContext(env.getEPackageRegistry()));
		
		for (ImportCS importCS : importsToProcessCopy) {
			if(importCS instanceof LibraryImportCS) {
				continue;
			}
			PathNameCS pathNameCS = importCS.getPathNameCS();
			if(pathNameCS != null) {
				List<Module> bboxModules = blackboxUnitHelper.getModules(pathNameCS.getSequenceOfNames());
				if(bboxModules != null) {
					for (Module nextBboxModule : bboxModules) {						
						QvtOperationalModuleEnv bboxModuleEnv = blackboxUnitHelper.getModuleEnvironment(nextBboxModule);
						assert bboxModuleEnv != null;
						if(!env.getSiblings().contains(bboxModuleEnv)) {							
							env.addSibling(bboxModuleEnv);
						}
						// FIXME - module import bellow should not represent the CST import statement
						// but rather module_access_decl (access, extends), which is not yet supported
						ModuleImport moduleImport = ExpressionsFactory.eINSTANCE.createModuleImport();
						moduleImport.setImportedModule(nextBboxModule);
						module.getModuleImport().add(moduleImport);
						module.setStartPosition(pathNameCS.getStartOffset());
						module.setEndPosition(pathNameCS.getEndOffset());						
					}
				} else if(blackboxUnitHelper.loadFailed(pathNameCS.getSequenceOfNames())) {
					env.reportError(wrappInSeeErrorLogMessage(NLS.bind(ValidationMessages.FailedToLoadLibrary, 
							new Object[] { QvtOperationalParserUtil.getStringRepresentation(pathNameCS, ".") })), pathNameCS); //$NON-NLS-1$				
				}
			}
		}
		
		if(parsedModuleCS.getModuleCS() != null) {
			DeprecatedLibraryImportSupport deprecatedLibraryImportSupport = new DeprecatedLibraryImportSupport(
					env, parsedModuleCS.getModuleCS(), compiler.getBlackboxUnitHelper());
			module.getModuleImport().addAll(deprecatedLibraryImportSupport.analyzeLibraryImports());
		}
	}

	private void createModuleProperties(Module module, MappingModuleCS moduleCS, QvtOperationalFileEnv env) throws SemanticException {
		
		for (ModulePropertyCS propCS : moduleCS.getProperties()) {
			EStructuralFeature prop = visitModulePropertyCS(propCS, env);
			if (prop == null) {
				continue;
			}

			EStructuralFeature eFeature = null;
			if (propCS instanceof ContextualPropertyCS) {
				EClass ctxType = ((ContextualProperty) prop).getContext();
				if (ctxType != null && env.lookupProperty(ctxType, prop.getName()) != null) {
					// need to check now for duplicates, as MDT OCL lookup now returns the most specific 
					// redefinition [244886], so further checking lookup might not reach the original valid feature
					// being redefined (thus no collision would be detectable)
					HiddenElementAdapter.markAsHidden(prop);
				}
				if (module instanceof OperationalTransformation) {
					((OperationalTransformation) module).getIntermediateProperty().add(prop);
				}
				eFeature = prop;
				// using AST-CST map as this mapping is not optional but always required
				env.getASTNodeToCSTNodeMap().put(prop, propCS); 
			} else {
				//eFeature = env.getUMLReflection().createProperty(prop.getName(), prop.getEType());
				eFeature = prop;				
				//QvtOperationalParserUtil.addLocalPropertyAST(eFeature, prop);				
		        if (env.lookupProperty(module, prop.getName()) != null) {
		        	HiddenElementAdapter.markAsHidden(eFeature);
		            env.reportError(NLS.bind(ValidationMessages.ModulePropertyAlreadyDefined, new Object[] { prop.getName() }), propCS.getSimpleNameCS());
		        }
				
				if (propCS instanceof ConfigPropertyCS) {
					module.getConfigProperty().add(eFeature);
				} 
			}
			
			module.getEStructuralFeatures().add(eFeature);						
		}

		if (module instanceof OperationalTransformation) {
			IntermediatePropertyHierarchy intermPropDefHierarchy = ((OperationalTransformation) module).getIntermediateProperty().isEmpty() ? null : new IntermediatePropertyHierarchy(module, env);				
			for (EStructuralFeature prop : ((OperationalTransformation) module).getIntermediateProperty()) {			
				if (prop instanceof ContextualProperty) {
					ContextualProperty ctxProperty = (ContextualProperty) prop;				
					EClass ctxType = ctxProperty.getContext();
					EStructuralFeature lookupProperty = ctxType != null ? env.lookupProperty(ctxType, prop.getName()) : null;
					
					boolean isAlreadyDefined = (lookupProperty != null && lookupProperty != ctxProperty) |
											HiddenElementAdapter.isMarkedAsHidden(ctxProperty);				
					if(isAlreadyDefined || intermPropDefHierarchy.hasHierarchyClashes(ctxProperty)) {
						HiddenElementAdapter.markAsHidden(ctxProperty);											
						String message = NLS.bind(ValidationMessages.IntermediatePropertyAlreadyDefined, prop.getName());
						
						int startPos = ctxProperty.getStartPosition();
						int endPos = ctxProperty.getEndPosition();
						CSTNode cstNode = QvtOperationalParserUtil.getPropertyProblemNode(prop, env);
						if(cstNode != null) {
							startPos = cstNode.getStartOffset();
							endPos = cstNode.getEndOffset();
						}
						env.reportError(message, startPos, endPos);
					}				
				}
			}
		}
	}

	/** FIXME */
	private static String getExpectedPackageName(QvtCompilerKernel kernel, CFile sourceFile) {		
		CFolder parent = sourceFile.getParent();
		if(parent == null) {
			// the default namespace
			return ""; //$NON-NLS-1$
		}
		return kernel.getExpectedPackageName(parent);
	} 
 
	protected void visitTransformationHeaderCS(TransformationHeaderCS headerCS,
			QvtOperationalFileEnv env, Module module, CFile sourceFile) {
		if (!headerCS.getQualifiers().isEmpty()) {
			env.reportWarning(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_transfQualifiersNotSupported,
					new Object[] { }), 
					headerCS.getQualifiers().get(0).getStartOffset(),
					headerCS.getQualifiers().get(headerCS.getQualifiers().size()-1).getEndOffset());
		}
		
		if(!QvtOperationalParserUtil.hasSimpleName(headerCS)) {
			env.reportError(NLS.bind(ValidationMessages.moduleNameMustBeSimpleIdentifierError, new Object[] { 
					QvtOperationalParserUtil.getMappingModuleQualifiedName(headerCS) }), headerCS.getPathNameCS());
		}		
		
        String unitSimpleName = QvtOperationalParserUtil.getMappingModuleSimpleName(headerCS);
        String unitNamespace = getExpectedPackageName(env.getKernel(), sourceFile);
        
		module.setName(unitSimpleName);
		module.setNsPrefix(unitNamespace);
		
		if (module instanceof OperationalTransformation) {
		    visitOperationalTransformationSignature(headerCS, env, (OperationalTransformation) module);
		} else if (module instanceof Library) {
            visitLibrarySignature(headerCS, env, (Library) module);
		} else {
		    throw new RuntimeException("Unknown module type: " + module); //$NON-NLS-1$
		}
		
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

    protected void visitOperationalTransformationSignature(TransformationHeaderCS headerCS,
            QvtOperationalFileEnv env, OperationalTransformation module) {
        Set<String> paramNames = new LinkedHashSet<String>();
        for (ParameterDeclarationCS paramCS : headerCS.getParameters()) {
            EClassifier type = null;
            TypeCS paramTypeCS = (paramCS.getTypeSpecCS() != null) ? paramCS.getTypeSpecCS().getTypeCS() : null;
            boolean isSimpleName = false;
            if (paramTypeCS instanceof PathNameCS) {
                PathNameCS typePathNameCS = (PathNameCS) paramTypeCS;
                isSimpleName = typePathNameCS.getSequenceOfNames().size() == 1;
                type = env.getModelType(typePathNameCS.getSequenceOfNames());
            }
            if (type == null || !isSimpleName) {
                env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_transfParamWrongType,
                        new Object[] { }), paramTypeCS);
            }

            ModelParameter varParam = ExpressionsFactory.eINSTANCE.createModelParameter();
            varParam.setRepresentedParameter(varParam);
            varParam.setStartPosition(paramCS.getStartOffset());
            varParam.setEndPosition(paramCS.getEndOffset());
            if(paramCS.getSimpleNameCS() != null) {
                varParam.setName(paramCS.getSimpleNameCS().getValue());
            } else {
                varParam.setName(""); //$NON-NLS-1$
            }
            varParam.setEType(type);
            DirectionKindEnum directionKind = paramCS.getDirectionKind();
            if (directionKind == DirectionKindEnum.DEFAULT) {
                directionKind = DirectionKindEnum.IN;
            }
            varParam.setKind((DirectionKind) ExpressionsFactory.eINSTANCE.createFromString(
                    ExpressionsPackage.eINSTANCE.getDirectionKind(), directionKind.getLiteral()));

            if (paramNames.contains(varParam.getName())) {
                env.reportError(NLS.bind(ValidationMessages.SameParamName, new Object[] { varParam.getName() }),
                        (paramCS.getSimpleNameCS() == null || paramCS.getSimpleNameCS().getValue().length() == 0) ? paramCS : paramCS.getSimpleNameCS());
            }
            paramNames.add(varParam.getName());
            
            module.getModelParameter().add(varParam);
            
            if(myCompilerOptions.isGenerateCompletionData()) {
                ASTBindingHelper.createCST2ASTBinding(paramCS, varParam);
            }           
        }
    }

    private void visitLibrarySignature(TransformationHeaderCS headerCS,
            QvtOperationalFileEnv env, Library module) {
        Set<ModelType> usedModelTypes = new HashSet<ModelType>(); 
        for (ParameterDeclarationCS paramCS : headerCS.getParameters()) {
            TypeCS paramTypeCS = (paramCS.getTypeSpecCS() != null) ? paramCS.getTypeSpecCS().getTypeCS() : null;
            if ((paramCS.getTypeSpecCS() != null) && (paramCS.getTypeSpecCS().getSimpleNameCS() != null)) {
                env.reportError(ValidationMessages.QvtOperationalVisitorCS_LibrarySignatureErrorModelExtentSpecified, paramCS.getTypeSpecCS().getSimpleNameCS());
            }
            if ((paramCS.getDirectionKind() != null) && (paramCS.getDirectionKind() != DirectionKindEnum.DEFAULT)) {
                env.reportError(ValidationMessages.QvtOperationalVisitorCS_LibrarySignatureErrorDirectionKindSpecified, paramCS);
            }
            if (paramCS.getSimpleNameCS() != null) {
                env.reportError(ValidationMessages.QvtOperationalVisitorCS_LibrarySignatureErrorParameterNameSpecified, paramCS);
            }
            ModelType modelType = null;
            if (paramTypeCS instanceof PathNameCS) {
                PathNameCS typePathNameCS = (PathNameCS) paramTypeCS;
                if (typePathNameCS.getSequenceOfNames().size() == 1) {
                    modelType = env.getModelType(typePathNameCS.getSequenceOfNames());
                    if (!usedModelTypes.add(modelType)) {
                        env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_LibrarySignatureErrorDuplicateModelType, 
                                new Object[] { typePathNameCS.getSequenceOfNames().get(0) }), paramCS);
                    }
                }
            }
            if (modelType == null) {
                env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_transfParamWrongType,
                        new Object[] { }), paramCS);
            } else if (!module.getUsedModelType().contains(modelType)) {
                module.getUsedModelType().add(modelType); // Normally, all used model types are
                                                          // already present in the Library AST node
            }
        }
    }
    protected ModelType visitModelTypeCS(ModelTypeCS modelTypeCS, QvtOperationalFileEnv env,
			Module module, ResourceSet resolutionRS) throws SemanticException {
		if (modelTypeCS == null) {
			return null;
		}

		SimpleNameCS identifierCS = modelTypeCS.getIdentifierCS();
		ModelType modelType = QvtOperationalStdLibrary.INSTANCE.createModel(identifierCS != null ? identifierCS.getValue() : null);
		module.getEClassifiers().add(modelType);
		if(myCompilerOptions.isGenerateCompletionData()) {
			ASTBindingHelper.createCST2ASTBinding(modelTypeCS, modelType);
		}
		
		modelType.setStartPosition(modelTypeCS.getStartOffset());
		modelType.setEndPosition(modelTypeCS.getEndOffset());
		
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

			EPackage resolvedMetamodel = null;

			if (packageRefCS.getUriCS() != null) {
				String metamodelUri = visitLiteralExpCS(packageRefCS.getUriCS(), env);
				resolvedMetamodel = resolveMetamodel(env, metamodelUri, Collections.<String>emptyList(), packageRefCS.getUriCS(), resolutionRS);
			}
			
			PathNameCS pathNameCS = packageRefCS.getPathNameCS();
			if (pathNameCS != null && !pathNameCS.getSequenceOfNames().isEmpty()) {
				String metamodelName = QvtOperationalParserUtil.getStringRepresentation(
						pathNameCS, QvtOperationalTypesUtil.TYPE_NAME_SEPARATOR); 

				if (resolvedMetamodel == null) {
					resolvedMetamodel = resolveMetamodel(env, null, pathNameCS.getSequenceOfNames(), pathNameCS, resolutionRS);
				}
				else {
					resolvedMetamodel = checkMetamodelPath(env, resolvedMetamodel, pathNameCS, metamodelName);
				}
			}
			
			if (resolvedMetamodel != null) {
				validateMetamodel(env, resolvedMetamodel, modelType, module, packageRefCS);				
				modelType.getMetamodel().add(resolvedMetamodel);
				
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
		List<EPackage> metamodels = modelType.getMetamodel();
		if (metamodels.contains(resolvedMetamodel)) {
			env.reportWarning(NLS.bind(ValidationMessages.DuplicateMetamodelImport,
					new Object[] { metamodelName }), cstNode);
		}
		if (module.getUsedModelType().contains(resolvedMetamodel)) {
			env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_metamodelAlreadyUsed,
					new Object[] { metamodelName }), cstNode);
		}		
	}
	
	private EPackage resolveMetamodel(QvtOperationalFileEnv env, String metamodelUri, List<String> packagePath,
			CSTNode cstNode, ResourceSet resolutionRS) throws SemanticException {
		EPackage resolvedMetamodel = null;
		String metamodelName = (packagePath.isEmpty() ? metamodelUri : packagePath.toString());
		try {
			MetamodelRegistry metamodelRegistry = env.getKernel().getMetamodelRegistry(env.getFile());
			
			List<EPackage> registerMetamodels = MetamodelResolutionHelper.registerMetamodel(
					env, metamodelUri, packagePath, resolutionRS, 
					metamodelRegistry, myCompilerOptions);
			
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
	
	protected Rename visitRenameCS(RenameCS renameCS, 
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) throws SemanticException {
		
		EClassifier type = visitTypeCS(renameCS.getTypeCS(), null, env);
		if (type == null) {
			return null;
		}
		String originalName = visitLiteralExpCS(renameCS.getOriginalName(), env);
		String newName = renameCS.getSimpleNameCS().getValue();

		EStructuralFeature originalProperty = env.lookupProperty(type, originalName);
		if (originalProperty == null) {
			QvtOperationalUtil.reportError(env, NLS.bind(ValidationMessages.noPropertyInTypeError, originalName, QvtOperationalTypesUtil
					.getTypeFullName(type)), renameCS);
			return null;
		}

		EStructuralFeature newProperty = env.lookupProperty(type, newName);
		if (newProperty != null) {
			QvtOperationalUtil.reportError(env, NLS.bind(ValidationMessages.propertyAlreadyExistsInTypeError, newName,
			        QvtOperationalTypesUtil.getTypeFullName(type)), renameCS);
			return null;
		}

		Variable<EClassifier, EParameter> var = EcoreFactory.eINSTANCE.createVariable();
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
		for (OCLExpressionCS statementCS : mappingSectionCS.getStatements()) {
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

	protected void visitMappingMethodCS(MappingMethodCS methodCS, QvtOperationalEnv env, ImperativeOperation declaredOperation)
			throws SemanticException {
		if (methodCS instanceof MappingRuleCS) {
			visitMappingRuleCS((MappingRuleCS) methodCS, env, (MappingOperation)declaredOperation);
		}
		else {
			visitMappingQueryCS((MappingQueryCS) methodCS, env, declaredOperation);
		}

		// process operation qualifiers
		EList<QualifierKindCS> qualifiersCS = (methodCS.getMappingDeclarationCS() == null) ? null 
		        : methodCS.getMappingDeclarationCS().getQualifiers();
		
		if(declaredOperation instanceof MappingOperation) {
		    if (qualifiersCS != null) {
	            for (QualifierKindCS nextQualifierCS : qualifiersCS) {
	                if(nextQualifierCS != QualifierKindCS.ABSTRACT) {
	                    // only 'abstract' qualifier for mapping is currently supported 
	                    String errMessage = NLS.bind(ValidationMessages.QvtOperationalVisitorCS_unsupportedQualifierOnOperation, 
	                            nextQualifierCS.getName(), QvtOperationalParserUtil.getMappingStringRepresentation(methodCS));
	                    env.reportError(errMessage, QvtOperationalParserUtil.getImperativeOperationProblemNode(methodCS));
	                } else {
	                    QvtOperationalParserUtil.markAsAbstractMappingOperation((MappingOperation) declaredOperation);
	                }
	            }
		    }
		}
		
		Collection<QualifierKindCS> qualifierDups = QvtOperationalParserUtil.selectDuplicateQualifiers(qualifiersCS);
		for(QualifierKindCS duplicate : qualifierDups) {
			String errMessage = NLS.bind(ValidationMessages.QvtOperationalVisitorCS_duplicateQualifierOnOperation, 
					duplicate.getName(), QvtOperationalParserUtil.getMappingStringRepresentation(methodCS));			
			env.reportError(errMessage, QvtOperationalParserUtil.getImperativeOperationProblemNode(methodCS));
		}
	}

	private ImperativeOperation visitMappingRuleCS(MappingRuleCS methodCS, QvtOperationalEnv env, final MappingOperation operation)
			throws SemanticException {
		env.registerMappingOperation(operation);
		operation.setEndPosition(methodCS.getEndOffset());

		if (QvtOperationalParserUtil.isContextual(operation) && operation.getContext().getKind() == DirectionKind.OUT) {
			env.reportError(ValidationMessages.ContextParamMustBeInOrInout, methodCS.getMappingDeclarationCS()
					.getDirectionKindCS());
		}

		QvtOperationalEnv newEnv = env.getFactory().createOperationContext(env, operation);		
        if(myCompilerOptions.isGenerateCompletionData()) {          
            ASTBindingHelper.createCST2ASTBinding(methodCS, operation, newEnv);
        }        

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
		if ((methodCS.getMappingBody() != null) && (methodCS.getMappingBody().getMappingInitCS() != null)) {
			inits = visitMappingSectionCS(methodCS.getMappingBody().getMappingInitCS(), newEnv);
		}

		MappingBody body = null;
		MappingBodyCS mappingBodyCS = (methodCS.getMappingBody() == null) ? null : methodCS.getMappingBody().getMappingBodyCS();
		if (mappingBodyCS != null) {
            body = visitMappingBodyCS(mappingBodyCS, newEnv, methodCS);
			if (body != null) {
				EClassifier returnType = operation.getEType();
				EClassifier bodyType = (body.getContent().size() == 1
						&& body.getContent().get(0) instanceof ObjectExp ? body.getContent().get(0).getType()
						: null);
                // TODO : Rewrite this when re-implementing ObjectExp
				if (bodyType != null && !QvtOperationalParserUtil.isAssignableToFrom(env, bodyType, returnType)) {
					/* checked by validation
					newEnv.reportError(NLS.bind(ValidationMessages.bodyTypeNotCompatibleWithReturnTypeError,
							new Object[] { QvtOperationalTypesUtil.getTypeFullName(bodyType), QvtOperationalTypesUtil.getTypeFullName(returnType) }),
						methodCS.getMappingDeclarationCS());
						*/
				}
			}
		} else {
			body = ExpressionsFactory.eINSTANCE.createMappingBody();
			body.setStartPosition(mappingBodyCS == null ? methodCS.getStartOffset() : mappingBodyCS.getStartOffset());			
			body.setEndPosition(mappingBodyCS == null ? methodCS.getEndOffset() : mappingBodyCS.getEndOffset());			
		}

		List<OCLExpression<EClassifier>> ends = Collections.emptyList();
		if ((methodCS.getMappingBody() != null) && (methodCS.getMappingBody().getMappingEndCS() != null)) {
			ends = visitMappingSectionCS(methodCS.getMappingBody().getMappingEndCS(), newEnv);
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

		processMappingExtensions(methodCS, operation, env);
		
		// adjust implicit variables for serialization
		consolidateImplicitVariables(newEnv);
		//		
		return operation;
	}

	private static void consolidateImplicitVariables(QvtOperationalEnv newEnv) {
		EOperation eOperation = newEnv.getContextOperation();
		OperationBody body = null;
		if(eOperation instanceof ImperativeOperation) {
			body = ((ImperativeOperation)eOperation).getBody();
		}
		
		if(body == null) {
			return;
		}
		for (Variable<EClassifier, EParameter> var : newEnv.getImplicitVariables()) {
			if(var.eContainer() == null) {
				body.getVariable().add((org.eclipse.ocl.ecore.Variable)var);
			}			
		}
		for (Variable<EClassifier, EParameter> var : newEnv.getVariables()) {
			if(var.eContainer() == null) {
				body.getVariable().add((org.eclipse.ocl.ecore.Variable)var);
			}			
		}		
	}

	private void visitMappingQueryCS(MappingQueryCS methodCS, QvtOperationalEnv env, ImperativeOperation helper)
			throws SemanticException {
		helper.setEndPosition(methodCS.getEndOffset());

		if (QvtOperationalParserUtil.isContextual(helper) && helper.getContext().getKind() != DirectionKind.IN) {
			env.reportError(ValidationMessages.ContextParamMustBeIn, methodCS.getMappingDeclarationCS()
					.getSimpleNameCS());
		}

		QvtOperationalEnv newEnv = env.getFactory().createOperationContext(env, helper);
		//newEnv.defineOperationParameters(helper);

        if(myCompilerOptions.isGenerateCompletionData()) {          
            ASTBindingHelper.createCST2ASTBinding(methodCS, helper, newEnv);
        }

		OperationBody body = ExpressionsFactory.eINSTANCE.createOperationBody();
		helper.setBody(body);
		// FIXME - use CST info to set the flag
		//helper.setIsQuery(true);				
		body.setStartPosition(methodCS.getMappingDeclarationCS().getEndOffset());
		body.setEndPosition(methodCS.getEndOffset());
        
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

		body.getContent().addAll(expressions);

		EClassifier returnType = (helper.getResult().isEmpty() ? helper.getEType() : helper.getResult().get(0).getEType());
		EClassifier helperType = body.getContent().isEmpty() == false ? body.getContent().get(body.getContent().size() - 1).getType() : null;
		if (QvtOperationalEnv.MAIN.equals(helper.getName()) 
				&& (returnType == null || returnType == env.getOCLStandardLibrary().getOclVoid())) {
			// OK
		}
		else  if (helperType != null && !QvtOperationalParserUtil.isAssignableToFrom(env, returnType, helperType)) {
			env.reportError(NLS.bind(ValidationMessages.bodyTypeNotCompatibleWithReturnTypeError, new Object[] {
			        QvtOperationalTypesUtil.getTypeFullName(helperType), 
			        QvtOperationalTypesUtil.getTypeFullName(returnType) 
				}), 
				methodCS.getMappingDeclarationCS());
		}
		
		// adjust implicit variables for serialization
		consolidateImplicitVariables(newEnv);
		//
	}
	
	/**
	 * TODO - make a common resolution operation, reusable in for ResolveExp too. 
	 */
	private List<EOperation> resolveMappingOperationReference(ScopedNameCS identifierCS, QvtOperationalEnv env) {
		List<EOperation> result = Collections.emptyList();
		
		TypeCS typeCS = identifierCS.getTypeCS();
		EClassifier owningType = null;		
		if(typeCS != null) {
			owningType = visitTypeCS(typeCS, null, env);
			if(owningType != null && identifierCS.getName() != null) {
				result = env.lookupMappingOperations(TypeUtil.resolveType(env, owningType), identifierCS.getName());				
			}
		} else if(identifierCS.getName() != null) {	
			// TODO - review why lookup does not return MappingOperation type collection
			owningType = env.getModuleContextType();
			result = env.lookupMappingOperations(owningType, identifierCS.getName());
		}
		// filter out inherited mappings
		if(!result.isEmpty()) {
			List<EOperation> ownerLocalOpers = new ArrayList<EOperation>(result.size());
	        for (EOperation operation : result) {
	            EClassifier owner = env.getUMLReflection().getOwningClassifier(operation);
	            if ((typeCS == null && owner == null) || (TypeUtil.resolveType(env, owner) == owningType)) {
	                ownerLocalOpers.add(operation);
	            }	            
	        }
	        result = ownerLocalOpers;
		} 
		// validate the result
		if(result.isEmpty()) {
			if(owningType != null) {
				// unresolved type reported above by visiTypeCS(...)
				String errMessage = NLS.bind(ValidationMessages.QvtOperationalVisitorCS_unresolvedMappingOperationReference,
						QvtOperationalParserUtil.getStringRepresentation(identifierCS));
				env.reportError(errMessage, identifierCS);
			}
		} else if(result.size() > 1) {
			String errMessage = NLS.bind(ValidationMessages.QvtOperationalVisitorCS_ambiguousMappingOperationReference, 
					QvtOperationalParserUtil.getStringRepresentation(identifierCS));
			env.reportError(errMessage, identifierCS);			
		}
		
		return result;
	}
	
	private void processMappingExtensions(MappingRuleCS mappingCS, MappingOperation operation, QvtOperationalEnv env) {
		if((mappingCS.getMappingDeclarationCS() != null) && !mappingCS.getMappingDeclarationCS().getMappingExtension().isEmpty()) {
			for (MappingExtensionCS extensionCS : mappingCS.getMappingDeclarationCS().getMappingExtension()) {
				MappingExtensionKindCS kind = extensionCS.getKind();
				
				for (ScopedNameCS identifierCS : extensionCS.getMappingIdentifiers()) {
					List<EOperation> mappings = resolveMappingOperationReference(identifierCS, env);
					if(mappings.size() == 1) {
						boolean isAdded = false;
						MappingOperation extendedMapping = (MappingOperation)mappings.get(0);
						if(kind == MappingExtensionKindCS.INHERITS) {
							isAdded = operation.getInherited().add(extendedMapping);
							MappingExtensionHelper.bind2SourceElement(operation, identifierCS, kind);
						} 
						else if(kind == MappingExtensionKindCS.MERGES) {
							isAdded = operation.getMerged().add(extendedMapping);
							MappingExtensionHelper.bind2SourceElement(operation, identifierCS, kind);							
						} 
						else if(kind == MappingExtensionKindCS.DISJUNCTS) {
							isAdded = operation.getDisjunct().add(extendedMapping);
							MappingExtensionHelper.bind2SourceElement(operation, identifierCS, kind);							
						}

						if(!isAdded) {
							// Note: duplicates checked here as the mapping AST is {unique, ordered}
							env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_duplicateMappingRereferenceInExtensionKind, 
								kind.getName(), QvtOperationalParserUtil.getStringRepresentation(identifierCS)), 
								identifierCS);
						}

						if(getCompilerOptions().isGenerateCompletionData()) {
							ASTBindingHelper.createCST2ASTBinding(identifierCS, extendedMapping, false, null);
						}
					}
				}
			}
		}
	}
	
	protected boolean visitMappingDeclarationCS(MappingMethodCS mappingMethodCS, QvtOperationalModuleEnv env, ImperativeOperation operation) throws SemanticException {
	    MappingDeclarationCS mappingDeclarationCS = mappingMethodCS.getMappingDeclarationCS();
		if (mappingDeclarationCS == null) {
			return false;
		}
		
		operation.setIsBlackbox(mappingMethodCS.isBlackBox());
		operation.setStartPosition(mappingDeclarationCS.getStartOffset());
		operation.setEndPosition(mappingDeclarationCS.getEndOffset());
		operation.setName(mappingDeclarationCS.getSimpleNameCS().getValue());		

		DirectionKind contextDirection = DirectionKind.IN;
		if ((mappingDeclarationCS.getDirectionKindCS() != null) && (mappingDeclarationCS.getDirectionKindCS().getDirectionKind() != DirectionKindEnum.DEFAULT)) {
			contextDirection = (DirectionKind) ExpressionsFactory.eINSTANCE.createFromString(
					ExpressionsPackage.eINSTANCE.getDirectionKind(), mappingDeclarationCS.getDirectionKindCS()
							.getDirectionKind().getLiteral());
		}

		EClassifier contextType;
		if (mappingDeclarationCS.getContextType() != null) {
			contextType = visitTypeCS(mappingDeclarationCS.getContextType(), contextDirection, env);
			if (contextType == null) {
				contextType = env.getModuleContextType();
			}
		} else {
			contextType = env.getModuleContextType();
		}

		boolean isEntryPoint = QvtOperationalEnv.MAIN.equals(mappingDeclarationCS.getSimpleNameCS().getValue());
		boolean isMapping = ExpressionsPackage.eINSTANCE.getMappingOperation().getClassifierID() == 
							operation.eClass().getClassifierID();
		boolean createMappingParams = isEntryPoint || isMapping;
		
		List<EParameter> params = operation.getEParameters();
		for (ParameterDeclarationCS paramCS : mappingDeclarationCS.getParameters()) {
			VarParameter param = visitParameterDeclarationCS(paramCS, createMappingParams, env, isEntryPoint);
			if (param == null) {
				return false;
			}

			params.add(param);
		}
				
		if (mappingDeclarationCS.getContextType() != null) {
			MappingParameter mappingParam = createMappingParams ? ExpressionsFactory.eINSTANCE.createMappingParameter() : null;
			VarParameter varContext = createMappingParams ? mappingParam : ExpressionsFactory.eINSTANCE.createVarParameter();
			
			varContext.setRepresentedParameter(varContext);
			varContext.setName(Environment.SELF_VARIABLE_NAME);
			varContext.setStartPosition(mappingDeclarationCS.getContextType().getStartOffset());
			varContext.setEndPosition(mappingDeclarationCS.getContextType().getEndOffset());
			
			varContext.setEType(contextType);
			varContext.setKind(contextDirection);
			if(mappingParam != null) {
				if (mappingParam.getExtent() == null) {
					mappingParam.setExtent(env.resolveModelParameter(contextType, varContext.getKind()));
				}
			}
		
			operation.setContext(varContext);
		}		
		
		EList<ParameterDeclarationCS> resultParams = mappingDeclarationCS.getResult();
		for(ParameterDeclarationCS nextResultParamCS : resultParams) {
			TypeSpecPair nextResultTypeSpec = visitTypeSpecCS(nextResultParamCS.getTypeSpecCS(), DirectionKind.OUT, env);
			if (nextResultTypeSpec.myType == null) {
				nextResultTypeSpec.myType = env.getOCLStandardLibrary().getOclVoid();
			}
			
			VarParameter varResult = createMappingResultParam(nextResultParamCS, createMappingParams, nextResultTypeSpec, env);
			if(resultParams.size() == 1) {
				varResult.setName(Environment.RESULT_VARIABLE_NAME);
				if(nextResultParamCS.getSimpleNameCS() != null) {
					String message = NLS.bind(ValidationMessages.QvtOperationalVisitorCS_resultParamNameNotAllowed, nextResultParamCS.getSimpleNameCS().getValue());
					env.reportError(message, nextResultParamCS.getSimpleNameCS());
				}
				
				if(nextResultParamCS.isSetDirectionKind()) {
					env.reportError(ValidationMessages.QvtOperationalVisitorCS_resultParamNameDirectionNotAllowed, nextResultParamCS);
				}
			}
			operation.getResult().add(varResult);
			
			if (isEntryPoint) {
				env.reportWarning(ValidationMessages.QvtOperationalVisitorCS_entryPointReturnDeprecated,
						nextResultParamCS.getTypeSpecCS());
			}
	
		}
		
		// set operation return type
		if(resultParams.isEmpty()) {
			// no result parameter should exist
			operation.setEType(env.getOCLStandardLibrary().getOclVoid());
		} else if(resultParams.size() > 1) {
			// create extra tuple-type the result type
			operation.setEType(createResultTupleType(operation, env));
		} else {
			operation.setEType(operation.getResult().get(0).getEType());
		}

		return true;
	}

	private EClassifier createResultTupleType(ImperativeOperation operation, QvtOperationalEnv env) {
		EList<VarParameter> resultParams = operation.getResult();
		assert resultParams.size() > 1;
		
		List<Variable<EClassifier, EParameter>> parts = new ArrayList<Variable<EClassifier,EParameter>>(resultParams.size());		
		for(VarParameter resultParam : resultParams) {
			Variable<EClassifier, EParameter> var = oclFactory.createVariable();
			uml.setName(var, resultParam.getName());
			uml.setType(var, resultParam.getEType());
			
			parts.add(var);
		}		
		return env.getTypeResolver().resolve((EClassifier)env.getOCLFactory().createTupleType(parts));
	}
		
	private VarParameter createMappingResultParam(ParameterDeclarationCS paramCS, boolean createMappingParam, TypeSpecPair typeSpec, QvtOperationalEnv env) {
		MappingParameter mappingParam = createMappingParam ? ExpressionsFactory.eINSTANCE.createMappingParameter() : null;
		VarParameter varResult = createMappingParam ? mappingParam : ExpressionsFactory.eINSTANCE.createVarParameter();
		varResult.setStartPosition(paramCS.getStartOffset());
		varResult.setEndPosition(paramCS.getEndOffset());
		
		if(paramCS.getSimpleNameCS() != null) {
			varResult.setName(paramCS.getSimpleNameCS().getValue());
		} 
		
		if(varResult.getName() == null){
			varResult.setName(""); //$NON-NLS-1$
		}
		
		varResult.setEType(typeSpec.myType);
		varResult.setKind(DirectionKind.OUT);		
		
		if(mappingParam != null) {
			mappingParam.setExtent(typeSpec.myExtent);
			if (mappingParam.getExtent() == null) {
				QvtOperationalModuleEnv moduleEnv = getModuleContextEnv(env);
				mappingParam.setExtent(moduleEnv.resolveModelParameter(typeSpec.myType, varResult.getKind()));
			}
		}
		
		if(getCompilerOptions().isGenerateCompletionData()) {
			ASTBindingHelper.createCST2ASTBinding(paramCS, varResult);
		}
		
		varResult.setRepresentedParameter(varResult);
		return varResult;
	}

	private OCLExpression<EClassifier> visitAssignStatementCS(AssignStatementCS expressionCS, 
	        Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
	        EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {

	    OCLExpressionCS lValueCS = expressionCS.getLValueCS();
	    OCLExpression<EClassifier> lValue = oclExpressionCS(lValueCS, env);
	    PathNameCS pathNameCS = extractQualifiedName(lValueCS);
	    if (pathNameCS == null) {
	        QvtOperationalUtil.reportError(env, ValidationMessages.notAnLValueError, lValueCS);
	        return null;
	    }
	    EList<String> qualifiedName = pathNameCS.getSequenceOfNames();
	    if (qualifiedName.size() > 2) {
	        QvtOperationalUtil.reportError(env, ValidationMessages.cannotModifyNestedPropertiesError, lValueCS);
	        return null;
	    }

	    String lvalueName = qualifiedName.get(0);
	    if (qualifiedName.size() == 1 && Environment.SELF_VARIABLE_NAME.equals(lvalueName)) {
	        QvtOperationalUtil.reportError(env, ValidationMessages.CantAssignToSelf, lValueCS);
	        return null;
	    }


	    if (qualifiedName.size() == 1 && QvtOperationalEnv.THIS.equals(lvalueName)) {
	        QvtOperationalUtil.reportError(env, ValidationMessages.CantAssignToThis, lValueCS);
	        return null;
	    }

	    OCLExpression<EClassifier> rightExpr = visitOclExpressionCS(expressionCS.getOclExpressionCS(), env);
	    if (rightExpr == null) {
	        return null;
	    }

	    if (lValue instanceof VariableExp) {
	        Variable<EClassifier, EParameter> variable = env.lookup(lvalueName);
	        if (variable == null) { // We mustn't be here. Must have been detected by OCL
	            QvtOperationalUtil.reportError(env, NLS.bind(ValidationMessages.unresolvedNameError, new Object[] { lvalueName }),
	                    lValueCS);
	            return null;
	        }
	        QvtOperationalParserUtil.validateVariableModification(variable, pathNameCS, null, env, true);         
	        QvtOperationalParserUtil.validateAssignment(variable.getName(), variable.getType(), rightExpr, expressionCS.isIncremental(),
	                pathNameCS, env);
	    } else if (lValue instanceof PropertyCallExp) {
	        @SuppressWarnings("unchecked")
	        PropertyCallExp<EClassifier, EStructuralFeature> propertyCallExp = (PropertyCallExp<EClassifier, EStructuralFeature>) lValue;
	        EStructuralFeature property = propertyCallExp.getReferredProperty();
	        if (property == null) { // We mustn't be here. This case is to be handled below
	            String fullName = QvtOperationalParserUtil.getStringRepresentation(pathNameCS, "."); //$NON-NLS-1$ 
	            QvtOperationalUtil.reportError(env, NLS.bind(ValidationMessages.invalidPropertyReferenceError,
	                    new Object[] { fullName }), lValueCS);
	            return null;
	        } else {
	            if (!property.isChangeable()) {
	                QvtOperationalUtil.reportError(env, NLS.bind(ValidationMessages.ReadOnlyProperty, property.getName()), lValueCS);
	            } else {
	                OCLExpression<EClassifier> source = propertyCallExp.getSource();
	                if (source instanceof VariableExp) {
	                    @SuppressWarnings("unchecked")
	                    VariableExp<EClassifier, EParameter> sourceExp = (VariableExp<EClassifier, EParameter>) source;
	                    Variable<EClassifier, EParameter> sourceVariable = sourceExp.getReferredVariable();
	                    QvtOperationalParserUtil.validateVariableModification(sourceVariable, pathNameCS, property, env, false);
	                }
	                QvtOperationalParserUtil.validateAssignment(property.getName(),
	                        env.getUMLReflection().getOCLType(property), rightExpr, expressionCS.isIncremental(),
	                        lValueCS, env);
	            }
	        }
	    } else {
	        EStructuralFeature leftProp = null;
	        if (qualifiedName.size() > 1) {
	            Variable<EClassifier, EParameter> variable = env.lookup(lvalueName);
	            if (variable == null) {
	                QvtOperationalUtil.reportError(env, NLS.bind(ValidationMessages.unresolvedNameError, new Object[] { lvalueName }),
	                        lValueCS);
	                return null;
	            }
	            leftProp = env.lookupProperty(variable.getType(), qualifiedName.get(qualifiedName.size() - 1));
	            if (leftProp == null) {
	                String fullName = QvtOperationalParserUtil.getStringRepresentation(pathNameCS, "."); //$NON-NLS-1$ 
	                QvtOperationalUtil.reportError(env, NLS.bind(ValidationMessages.invalidPropertyReferenceError,
	                        new Object[] { fullName }), lValueCS);
	                return null;
	            }
	        }
	        // TODO: This code is to be transferred to the AST validator
	        if ((lValue != null) && !(lValue instanceof InvalidLiteralExp)) { // to avoid induced errors on unresolved variables
	            QvtOperationalUtil.reportError(env, ValidationMessages.notAnLValueError, lValueCS);
	            return null;
	        }
	    }

	    AssignExp result = ExpressionsFactory.eINSTANCE.createAssignExp();
	    result.setStartPosition(expressionCS.getStartOffset());
	    result.setEndPosition(expressionCS.getEndOffset());
	    result.getValue().add(rightExpr);
	    result.setIsReset(!expressionCS.isIncremental());
	    result.setLeft(lValue);
	    return result;
	}
	
    private PathNameCS extractQualifiedName(OCLExpressionCS qualified) {
        if (qualified instanceof PathNameCS) {
            return (PathNameCS) qualified;
        }
        else if (qualified instanceof VariableExpCS) {
            PathNameCS result = CSTFactory.eINSTANCE.createPathNameCS();
            result.getSequenceOfNames().add(((VariableExpCS) qualified).getSimpleNameCS().getValue());
            result.setStartOffset(qualified.getStartOffset());
            result.setEndOffset(qualified.getEndOffset());
            return result;
        }
        else if (qualified instanceof FeatureCallExpCS) {
            FeatureCallExpCS callExp = (FeatureCallExpCS) qualified;
            if (callExp.getSource() == null) {
                return null;
            }
            PathNameCS prefix = extractQualifiedName(callExp.getSource());
            if (prefix == null) {
                return null;
            }
            PathNameCS result = CSTFactory.eINSTANCE.createPathNameCS();
            result.getSequenceOfNames().addAll(prefix.getSequenceOfNames());
            result.getSequenceOfNames().add(callExp.getSimpleNameCS().getValue());
            result.setStartOffset(qualified.getStartOffset());
            result.setEndOffset(qualified.getEndOffset());
            return result;
        }
        return null;
    }
	
	private VarParameter visitParameterDeclarationCS(ParameterDeclarationCS paramCS, boolean createMappingParam, 
			QvtOperationalModuleEnv env, boolean isOutAllowed) throws SemanticException {
		DirectionKindEnum directionKindEnum = paramCS.getDirectionKind();
		if (directionKindEnum == DirectionKindEnum.DEFAULT) {
		    directionKindEnum = DirectionKindEnum.IN;
		}
        DirectionKind directionKind = (DirectionKind) ExpressionsFactory.eINSTANCE.createFromString(
				ExpressionsPackage.eINSTANCE.getDirectionKind(), directionKindEnum.getLiteral());
		TypeSpecPair typeSpec = visitTypeSpecCS(paramCS.getTypeSpecCS(), directionKind, env);
		if (typeSpec.myType == null) {
			typeSpec.myType = env.getOCLStandardLibrary().getOclVoid();
		}

		MappingParameter mappingParam = createMappingParam ? ExpressionsFactory.eINSTANCE.createMappingParameter() : null;
		VarParameter varParam = createMappingParam ? mappingParam : ExpressionsFactory.eINSTANCE.createVarParameter();
		varParam.setRepresentedParameter(varParam);
		varParam.setStartPosition(paramCS.getStartOffset());
		varParam.setEndPosition(paramCS.getEndOffset());
		if(paramCS.getSimpleNameCS() != null) {
			varParam.setName(paramCS.getSimpleNameCS().getValue());
		} else {
			varParam.setName(""); //$NON-NLS-1$
		}
		varParam.setEType(typeSpec.myType);
		varParam.setKind(directionKind);		

		if(mappingParam != null) {
			mappingParam.setExtent(typeSpec.myExtent);
			if (mappingParam.getExtent() == null) {
				mappingParam.setExtent(env.resolveModelParameter(typeSpec.myType, directionKind));
				if (mappingParam.getExtent() == null && directionKind == DirectionKind.OUT) {
					env.reportError(ValidationMessages.OutParamWithoutExtent, paramCS);
				}
			}
		}
		
		if (!isOutAllowed && varParam.getKind() == DirectionKind.OUT) {
			env.reportError(ValidationMessages.OutParamsNotSupported, paramCS);
		}

        // AST binding
        if(myCompilerOptions.isGenerateCompletionData()) {		
			ASTBindingHelper.createCST2ASTBinding(paramCS, varParam);
        }
		//
		
		return varParam;
	}

	private OCLExpression<EClassifier> visitVariableInitializationCS(VariableInitializationCS varInitCS, 
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
        MappingMethodCS mappingMethod = null;
        EObject tempContainer = varInitCS;
        do {
            tempContainer = tempContainer.eContainer();
            if (tempContainer instanceof MappingMethodCS) {
                mappingMethod = (MappingMethodCS) tempContainer;
                break;
        }
        } while (tempContainer != null);

		VariableInitExp result = ExpressionsFactory.eINSTANCE.createVariableInitExp();
		result.setStartPosition(varInitCS.getStartOffset());
		result.setEndPosition(varInitCS.getEndOffset());
		if (validateInitializedValueCS(varInitCS, result, env)) {
			if (QvtOperationalParserUtil.validateInitVariable(result, env)) {
				addInitVariable(env, result);
			}
		}

        // AST binding
        if(myCompilerOptions.isGenerateCompletionData()) {
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
			
	private ReturnExp visitReturnExpCS(ReturnExpCS returnExpCS, 
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		
		ReturnExp result = ExpressionsFactory.eINSTANCE.createReturnExp();
		initStartEndPositions(result, returnExpCS);
		if(returnExpCS.getValue() != null) {
			OCLExpression<EClassifier> value = oclExpressionCS(returnExpCS.getValue(), env);
			result.setValue(value);
			if(value != null) {
				result.setType(value.getType());
			}
		}
		
		if(result.getType() == null) {
			result.setType(env.getOCLStandardLibrary().getOclVoid());
		}
		
		return result;
	}
	
    private MappingBody visitMappingBodyCS(MappingBodyCS mappingBodyCS, QvtOperationalEnv env, MappingMethodCS mappingRuleCS)
			throws SemanticException {

		MappingBody body = ExpressionsFactory.eINSTANCE.createMappingBody();
		body.setStartPosition(mappingBodyCS.getStartOffset());
		body.setEndPosition(mappingBodyCS.getEndOffset());
		
        //Spec 07-07-07: 8.2.1.19 MappingBody
        //The rule for interpreting a body in which there is no population keyword is as follows:
        //(1) If the mapping operation defines a unique result, the list of expressions in the body is the list of expressions of the -
        //unique - implicit object expression (see ObjectExp) contained by the population section.
        //(2) If the mapping operation defines more than one result, the list of expressions in the body is the list of expressions of
        //the population section.
        if (!mappingBodyCS.isHasPopulationKeyword()) {
            MappingDeclarationCS mappingDeclarationCS = mappingRuleCS.getMappingDeclarationCS();
            if (mappingDeclarationCS != null) {
                boolean isUniqueResult = mappingDeclarationCS.getResult().size() == 1; 
                boolean isImplicitContext = mappingDeclarationCS.getResult().isEmpty() 
                && (mappingDeclarationCS.getContextType() != null)
                && (mappingDeclarationCS.getDirectionKindCS() != null)
                && (mappingDeclarationCS.getDirectionKindCS().getDirectionKind() == DirectionKindEnum.INOUT);
                if (isUniqueResult || isImplicitContext) {
                    OutExpCS implicitObjectExpCS = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createOutExpCS();
                    implicitObjectExpCS.setIsImplicit(true);

                    SimpleNameCS resultVar = CSTFactory.eINSTANCE.createSimpleNameCS();
                    String implicitVarName = isUniqueResult ? Environment.RESULT_VARIABLE_NAME : Environment.SELF_VARIABLE_NAME; 
                    resultVar.setValue(implicitVarName);

                    implicitObjectExpCS.setSimpleNameCS(resultVar);
                    implicitObjectExpCS.setStartOffset(mappingBodyCS.getStartOffset());
                    implicitObjectExpCS.setEndOffset(mappingBodyCS.getEndOffset());

                    implicitObjectExpCS.getExpressions().addAll(mappingBodyCS.getStatements());
                    mappingBodyCS.getStatements().add(implicitObjectExpCS);

                    ObjectExp objectExp = visitOutExpCS(implicitObjectExpCS, env, false);
                    body.getContent().add(objectExp);
                    return body;
				}
			}
		}
        List<OCLExpression<EClassifier>> expressions = visitMappingSectionCS(mappingBodyCS, env);
        body.getContent().addAll(expressions);
		
		return body;
	}

	private int getStartOffset(ASTNode astNode, CSTNode cstNodeOpt) {
		if(cstNodeOpt != null) {
			return cstNodeOpt.getStartOffset();
		}
		return astNode.getStartPosition();
	}
	
	private int getEndOffset(ASTNode astNode, CSTNode cstNodeOpt) {
		if(cstNodeOpt != null) {
			return cstNodeOpt.getEndOffset();
		}
		return astNode.getEndPosition();
	}	
	
	private void validateObjectExp(ObjectExp objectExp, OutExpCS objectExpCS, QvtOperationalEnv env) {
		EClass derivedInstantiatedClass = objectExp.getInstantiatedClass();		
		Variable<EClassifier, EParameter> referredObject  = objectExp.getReferredObject();
		if(derivedInstantiatedClass == null && (referredObject != null && QVTUMLReflection.isUserModelElement(referredObject.getType()))) {
			derivedInstantiatedClass = (EClass)referredObject.getType();
		}
		
        if((derivedInstantiatedClass == null) || !QVTUMLReflection.isUserModelElement(derivedInstantiatedClass)) {
			CSTNode problemCS = null;
			if(objectExpCS != null) {
                problemCS = objectExpCS.getTypeSpecCS();
                if(problemCS == null) {
                    problemCS = objectExpCS.getSimpleNameCS();
				}
				if(problemCS == null) {
                    problemCS = objectExpCS;
				}
			}

			int startOffs = getStartOffset(objectExp, problemCS);
			int endOffs = getEndOffset(objectExp, problemCS);
			if(referredObject != null)	{ 
				if(referredObject.getType() != null && (referredObject.getType() instanceof CollectionType == false)) { 
					// we failed to figure out the class but type is available, let's report it's classifier only 
					env.reportError(NLS.bind(ValidationMessages.nonModelTypeError,
							QvtOperationalParserUtil.safeGetQualifiedName(env, referredObject.getType())), startOffs, endOffs);
				}
			}
		}
				 
		// check for the type conformance only if instantiatedClass class was explicitly set
		if(referredObject != null) {
			if(objectExp.getType() != null) {				
				CSTNode problemCS = null;
				if(objectExpCS != null) {
					problemCS = objectExpCS.getSimpleNameCS();
					if(problemCS == null) {
						problemCS = objectExpCS.getTypeSpecCS() != null ? objectExpCS.getTypeSpecCS() : objectExpCS;						
					}
				}
				
				EClassifier referredType = referredObject.getType();
				EClassifier actualType = objectExp.getType();
				// Note : invalid AST might have type node missing, so just check, a problem would be reported by variable validation
				if(referredType != null && (TypeUtil.getRelationship(env, actualType, referredType) & UMLReflection.SAME_TYPE) == 0) {				
					String actualTypeName = QvtOperationalParserUtil.safeGetQualifiedName(env, actualType);
					String referredTypeName = QvtOperationalParserUtil.safeGetQualifiedName(env, referredType);
					String errorMessage = NLS.bind(ValidationMessages.QvtOperationalVisitorCS_instatiatedTypeDoesNotConformToReferredType,  
							actualTypeName, referredTypeName);
	
					env.reportError(errorMessage, getStartOffset(objectExp, problemCS), getEndOffset(objectExp, problemCS));
				}
				
				if(referredObject.getRepresentedParameter() instanceof MappingParameter) {
					MappingParameter mappingPar = (MappingParameter) referredObject.getRepresentedParameter();
					if(mappingPar.getKind() == DirectionKind.IN) {
						env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_canNotModifyINParameter, referredObject.getName()), problemCS);
					}
				}
			}
		} else if(derivedInstantiatedClass != null && (derivedInstantiatedClass.isAbstract() || derivedInstantiatedClass.isInterface())) {			
			// always creates a new instance, ensure non-abstract type. 
			String typeName = QvtOperationalParserUtil.safeGetQualifiedName(env, derivedInstantiatedClass);
			env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_canNotInstantiateAbstractType, typeName), objectExpCS);
		}
	}

	private OCLExpression<EClassifier> visitExpressionStatementCS(ExpressionStatementCS expressionCS, 
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		
		return visitOclExpressionCS(expressionCS.getOclExpressionCS(), env);
	}

	private static EStructuralFeature createESFeature(EClassifier type) {
		if(type instanceof EClass) {
			return org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEReference();
		}
		return org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	}
	
	private EStructuralFeature visitConfigPropertyCS(ConfigPropertyCS propCS, QvtOperationalFileEnv env) {
		SimpleNameCS simpleNameCS = propCS.getSimpleNameCS();
		String name = simpleNameCS != null ? simpleNameCS.getValue() : ""; //$NON-NLS-1$

		EClassifier type = null;
		if (propCS.getTypeCS() != null) {
			type = visitTypeCS(propCS.getTypeCS(), null, env);
			if (type != null) {
				if (!QvtOperationalUtil.isCreateFromStringSupported(type)) {
					env.reportError(NLS.bind(ValidationMessages.ConfigPropertyTypeUnsupported, new Object[] { type
							.getName() }), propCS.getTypeCS());
				}
			}
		} else {
			env.reportError(NLS.bind(ValidationMessages.ConfigPropertyMustHaveType,
					new Object[] { name }), simpleNameCS != null ? simpleNameCS : propCS);
		}

		EStructuralFeature feature = createESFeature(type);
		feature.setName(name);
		feature.setEType(type);

		ASTSyntheticNode astNode = ASTSyntheticNodeAccess.createASTNode(feature);
		astNode.setStartPosition(propCS.getStartOffset());
		astNode.setEndPosition(propCS.getEndOffset());

		return feature;
	}

	private EStructuralFeature visitLocalPropertyCS(LocalPropertyCS propCS, QvtOperationalEnv env) {
		EClassifier type = null;
		if (propCS.getTypeCS() != null) {
			type = visitTypeCS(propCS.getTypeCS(), null, env);
		}

		EStructuralFeature prop = createESFeature(type);
		SimpleNameCS simpleNameCS = propCS.getSimpleNameCS();
		prop.setName(simpleNameCS.getValue());		
		prop.setEType(type);

		ASTSyntheticNode astNode = ASTSyntheticNodeAccess.createASTNode(prop);
		astNode.setStartPosition(propCS.getStartOffset());
		astNode.setEndPosition(propCS.getEndOffset());
		
		OCLExpression<EClassifier> exp = null;
		if (propCS.getOclExpressionCS() != null) {
			exp = visitOclExpressionCS(propCS.getOclExpressionCS(), env);
			QvtOperationalParserUtil.setInitExpression(prop, exp);			
		}
		
		if (prop.getEType() == null && exp != null) {
			prop.setEType(exp.getType());
		}
		
		if(exp != null) {
			EClassifier realType = exp.getType();
			EClassifier declaredType = prop.getEType();
			if (!QvtOperationalParserUtil.isAssignableToFrom(env, declaredType, realType)) {
				env.reportError(NLS.bind(ValidationMessages.SemanticUtil_17,
						new Object[] { QvtOperationalTypesUtil.getTypeFullName(declaredType), QvtOperationalTypesUtil.getTypeFullName(realType) }),
						astNode.getStartPosition(), astNode.getEndPosition());
			}
		}

		return prop;
	}

	private ContextualProperty visitContextualPropertyCS(ContextualPropertyCS propCS, QvtOperationalFileEnv env) {
		ContextualProperty prop = ExpressionsFactory.eINSTANCE.createContextualProperty();
		prop.setStartPosition(propCS.getStartOffset());
		prop.setEndPosition(propCS.getEndOffset());
		
		prop.setName(propCS.getScopedNameCS().getName());

		EClassifier type = null;
		if (propCS.getTypeCS() != null) {
			type = visitTypeCS(propCS.getTypeCS(), null, env);
			if (type == null) {
				return null;
			}
		}		

		OCLExpression<EClassifier> exp = null;
		if (propCS.getOclExpressionCS() != null) {
			env.reportWarning(NLS.bind(ValidationMessages.IntermediatePropertiesInitNotSupported,
						new Object[] { }), propCS.getOclExpressionCS());			
			exp = visitOclExpressionCS(propCS.getOclExpressionCS(), env);
		}
		
		if (type == null && exp != null) {
			type = exp.getType();
		}
		if (type == null) {
			return null;
		}
		
		prop.setEType(type);
		prop.setInitExpression(exp);
		
		if (exp != null) {
			EClassifier realType = exp.getType();
			EClassifier declaredType = prop.getEType();
			if (!QvtOperationalParserUtil.isAssignableToFrom(env, declaredType, realType)) {
				env.reportError(NLS.bind(ValidationMessages.SemanticUtil_17,
						new Object[] { QvtOperationalTypesUtil.getTypeFullName(declaredType), QvtOperationalTypesUtil.getTypeFullName(realType) }),
						prop.getStartPosition(), prop.getEndPosition());
			}
		}
		
		EClassifier contextType = visitTypeCS(propCS.getScopedNameCS().getTypeCS(), null, env);
		if (contextType != null) {
			if(contextType instanceof EClass) {
				prop.setContext((EClass)contextType);
			} else {
				env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_ContextualPropertyTypeIsNotClass, 
								new Object[] { prop.getName() }), propCS.getScopedNameCS().getTypeCS());
			}
		}
		
		return prop;
	}
		
	protected EStructuralFeature visitModulePropertyCS(ModulePropertyCS propCS, QvtOperationalFileEnv env) {
		EStructuralFeature result = null;		
		if (propCS instanceof ConfigPropertyCS) {
			result = visitConfigPropertyCS((ConfigPropertyCS) propCS, env);
		}
		else if (propCS instanceof LocalPropertyCS) {
			result = visitLocalPropertyCS((LocalPropertyCS) propCS, env);
		}
		else if (propCS instanceof ContextualPropertyCS) {
			result = visitContextualPropertyCS((ContextualPropertyCS) propCS, env);
		}
		else {
			assert false : "Unexpected CS class: " + propCS;
		}
		
        // AST binding
        if (myCompilerOptions.isGenerateCompletionData()) {
        	propCS.setAst(result);

        	if(result instanceof ASTNode) {
        		ASTBindingHelper.createCST2ASTBinding(propCS, (ASTNode)result, env);
        	} else {
        		ASTSyntheticNode astNode = ASTSyntheticNodeAccess.getASTNode(result); 
        		ASTSyntheticNodeAccess.setCST(astNode, propCS);
        	}
        }
		//
		return result;
	}

    private OCLExpression<EClassifier> visitResolveExpCS(ResolveExpCS resolveExpCS, QvtOperationalEnv env) {
        ResolveExp resolveExp = populateResolveExp(resolveExpCS, env, ExpressionsFactory.eINSTANCE.createResolveExp());
        if (resolveExp.getSource() == null) {
            env.reportError(NLS.bind(ValidationMessages.ResolveExpMustHaveASource, new Object[] { }), resolveExpCS);
        }
        
        DeprecatedImplicitSourceCallHelper.validateCallExp(resolveExpCS, resolveExp, env);
        
        return resolveExp;
    }
    
    private void validateResolveExp(ResolveExp  resolveExp, 
    		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
    	if(resolveExp.isIsDeferred()) {    	
    		if(!QvtResolveUtil.isSuppportedAsDeferredAssigned(resolveExp)) {
    			int startPos = (resolveExp.getSource() != null) ? resolveExp.getSource().getEndPosition() : resolveExp.getStartPosition(); 
    			QvtOperationalUtil.reportWarning(env, ValidationMessages.lateResolveNotUsedInDeferredAssignment, startPos, resolveExp.getEndPosition());
    		}
		}
    }
        
    private OCLExpression<EClassifier> visitResolveInExpCS(ResolveInExpCS resolveInExpCS, QvtOperationalEnv env) {
        ResolveInExp resolveInExp = ExpressionsFactory.eINSTANCE.createResolveInExp();
        TypeCS contextTypeCS = resolveInExpCS.getInMappingType();
        EClassifier eClassifier = (contextTypeCS == null) ? null : visitTypeCS(contextTypeCS, null, env); // mapping context type
        eClassifier = eClassifier != null ? eClassifier : env.getModuleContextType();
        String mappingName = resolveInExpCS.getInMappingName().getValue();
        List<EOperation> rawMappingOperations = env.lookupMappingOperations(eClassifier, mappingName);
        List<EOperation> mappingOperations = new ArrayList<EOperation>();
        
        for (EOperation operation : rawMappingOperations) {
            EClassifier owner = env.getUMLReflection().getOwningClassifier(operation);
            if (((contextTypeCS == null) && (owner == null))
                    || (TypeUtil.resolveType(env, owner) == eClassifier)) {
                mappingOperations.add(operation);
            }
        }
        if (mappingOperations.size() == 1) {
            env.registerResolveInExp(resolveInExp, eClassifier, mappingName);
        } else {
            String mappingFQName = (eClassifier == null) ? "" : eClassifier.getName() + QvtOperationalTypesUtil.TYPE_NAME_SEPARATOR; //$NON-NLS-1$
            mappingFQName += mappingName;
            if (mappingOperations.size() == 0) {
                env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_ResolveInMappingNotFound, new Object[] {
                        mappingFQName}), resolveInExpCS.getInMappingName() != null ? resolveInExpCS.getInMappingName() : resolveInExpCS);
            } else if (mappingOperations.size() > 1) {
                env.reportWarning(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_ResolveInSeveralMappingsFound, new Object[] {
                        mappingFQName}), resolveInExpCS);
                env.registerResolveInExp(resolveInExp, eClassifier, mappingName);
            }
        }
        
        ResolveExp result = populateResolveExp(resolveInExpCS, env, resolveInExp);
        //        DeprecatedImplicitSourceCallHelper.validateCallExp(resolveInExpCS, result, env);
        return result;
    }
    
    private ResolveExp populateResolveExp(ResolveExpCS resolveExpCS, QvtOperationalEnv env, ResolveExp resolveExp) {
        // AST binding
        if(myCompilerOptions.isGenerateCompletionData()) {      
            ASTBindingHelper.createCST2ASTBinding(resolveExpCS, resolveExp, env);
        }
        //
        if (resolveExpCS.getSource() != null) {
            OCLExpression<EClassifier> sourceExp = visitOclExpressionCS(resolveExpCS.getSource(), env);
            resolveExp.setSource(sourceExp);
        } else {
            //            // lookup for implicit source
            //            Variable<EClassifier,EParameter> implicitSource = env.lookupImplicitSourceForResolveExp();
            //            if (implicitSource != null) {
            //                VariableExp<EClassifier,EParameter> vexp = org.eclipse.ocl.expressions.ExpressionsFactory.eINSTANCE.createVariableExp();
            //                
            //                vexp.setType(implicitSource.getType());
            //                vexp.setReferredVariable(implicitSource);
            //                vexp.setName(implicitSource.getName());
            //                
            //                resolveExp.setSource(vexp);
            //            }
        }
        resolveExp.setOne(resolveExpCS.isOne());
        resolveExp.setIsInverse(resolveExpCS.isIsInverse());
        resolveExp.setIsDeferred(resolveExpCS.isIsDeferred());
        
        if (resolveExpCS.getTarget() != null) { // at least type is defined
            Variable<EClassifier, EParameter> variable = EcoreFactory.eINSTANCE.createVariable();
            EClassifier type = visitTypeCS(resolveExpCS.getTarget().getTypeCS(), null, env);
            variable.setType(type);
            
            boolean isTargetVarClashing = false;
            String targetVarName = resolveExpCS.getTarget().getName();
            if (targetVarName != null) {
        		if (env.lookupLocal(targetVarName) != null) {
        			isTargetVarClashing = true;
        			
        			env.reportError(NLS.bind(ValidationMessages.SemanticUtil_15, new Object[] { targetVarName }),
        					resolveExpCS.getTarget().getStartOffset(), resolveExpCS.getTarget().getEndOffset());
        		}
    			variable.setName(targetVarName);
            }
            resolveExp.setTarget(variable);
            
            // AST binding
            if(myCompilerOptions.isGenerateCompletionData()) {      
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
                if (!isTargetVarClashing && variable.getName() != null) {                	
                	env.addElement(variable.getName(), variable, true);
                }
                OCLExpression<EClassifier> condExp = visitOclExpressionCS(resolveExpCS.getCondition(), env);
                resolveExp.setCondition(condExp);                
                
                if (!isTargetVarClashing && variable.getName() != null) {
                    env.deleteElement(variable.getName());
                    // ensure to bind back to the ResolveExp container
                    resolveExp.setTarget(variable);
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
        
    	if(resolveExpCS.isIsDeferred()) {
    		addLateResolve(resolveExp);
    	}
        
		OCLExpression<EClassifier> condition = resolveExp.getCondition();
		if(condition != null) {
			EClassifier condType = condition.getType();
			if(env.getOCLStandardLibrary().getBoolean() != condType) {
				env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_booleanTypeExpressionExpected, 
						env.getUMLReflection().getName(condType)), condition.getStartPosition(), condition.getEndPosition());
			}
		}    	
    	
        return resolveExp;
    }

    private OCLExpression<EClassifier> visitForExp(ForExpCS forExpCS, 
    		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
    	
        OCLExpression<EClassifier> source =
            getCollectionSourceExpression(forExpCS.getSource(), env);
        if (!(source.getType() instanceof CollectionType)) {
            return createDummyInvalidLiteralExp();
        }
        String name = forExpCS.getSimpleNameCS().getValue();

        ForExp astNode = ExpressionsFactory.eINSTANCE.createForExp();
        initASTMapping(env, astNode, forExpCS);
        astNode.setName(name);
        astNode.setStartPosition(forExpCS.getStartOffset());
        astNode.setEndPosition(forExpCS.getEndOffset());
        astNode.setType(env.getOCLStandardLibrary().getOclVoid());

        EList<Variable<EClassifier, EParameter>> iterators = astNode.getIterator();
        @SuppressWarnings("unchecked")
        CollectionType<EClassifier, EOperation> sourceCollectionType = (CollectionType<EClassifier, EOperation>) source.getType();
        Variable<EClassifier, EParameter> vdcl = null;
        if (forExpCS.getVariable1() != null) {
            vdcl = variableDeclarationCS(forExpCS.getVariable1(), env, true);
            vdcl.setType(sourceCollectionType.getElementType());
            iterators.add(vdcl);
        }
        
        Variable<EClassifier, EParameter> vdcl1 = null;
        if (forExpCS.getVariable2() != null) {
            vdcl1 = variableDeclarationCS(forExpCS.getVariable2(), env, true);
            vdcl1.setType(sourceCollectionType.getElementType());
            iterators.add(vdcl1);
        }
        
        if (forExpCS.getCondition() != null) { 
            OCLExpression<EClassifier> conditionExp = oclExpressionCS(forExpCS.getCondition(), env);
            astNode.setCondition(conditionExp);
        }
        
        if (forExpCS.getBody() != null) {
            OCLExpression<EClassifier> bodyExp = oclExpressionCS(forExpCS.getBody(), env);
            astNode.setBody(bodyExp);
        }
        
        astNode.setSource(source);
        
        if (vdcl != null) {
            env.deleteElement(vdcl.getName());
        }
        if (vdcl1 != null) {
            env.deleteElement(vdcl1.getName());
        }

        return astNode;
    }
    
    private OCLExpression<EClassifier> visitImperativeIterateExp(ImperativeIterateExpCS imperativeIterateExpCS, 
    		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
    	
        OCLExpression<EClassifier> source =
            getCollectionSourceExpression(imperativeIterateExpCS.getSource(), env);
        if (!(source.getType() instanceof CollectionType)) {
            return createDummyInvalidLiteralExp();
        }
        String name = imperativeIterateExpCS.getSimpleNameCS().getValue();

        Variable<EClassifier, EParameter> vdcl = null;
        Variable<EClassifier, EParameter> vdcl1 = null;
        List<Variable<EClassifier, EParameter>> iterators = null;
    
        ImperativeIterateExp astNode;
        @SuppressWarnings("unchecked")
        CollectionType<EClassifier, EOperation> sourceCollectionType = (CollectionType<EClassifier, EOperation>) source.getType();
        
        if (imperativeIterateExpCS.getVariable1() != null) {
            vdcl = variableDeclarationCS(imperativeIterateExpCS.getVariable1(), env, true);
                
            astNode = ExpressionsFactory.eINSTANCE.createImperativeIterateExp();
            initASTMapping(env, astNode, imperativeIterateExpCS);
            astNode.setName(name);
            iterators = astNode.getIterator();  
            if (vdcl.getType() == null) {
                vdcl.setType(sourceCollectionType.getElementType());
            }
            iterators.add(vdcl);
            
            if (imperativeIterateExpCS.getVariable2() != null) {
                vdcl1 = variableDeclarationCS(imperativeIterateExpCS.getVariable2(), env, true);
                
                if (vdcl1.getType() == null) {
                    vdcl1.setType(sourceCollectionType.getElementType());
                }
                iterators.add(vdcl1);
            }
        } else  {
            astNode = ExpressionsFactory.eINSTANCE.createImperativeIterateExp();
            initASTMapping(env, astNode, imperativeIterateExpCS);
            astNode.setName(name);
            iterators = astNode.getIterator();  
            // Synthesize the iterator expression.
            vdcl = genVariableDeclaration(imperativeIterateExpCS, "visitImperativeIterateExp", env, null, //$NON-NLS-1$
                sourceCollectionType.getElementType(), null, false, true, false);
            iterators.add(vdcl);
        }
        
        TRACE("visitImperativeIterateExp: ", name);//$NON-NLS-1$
        
        EClassifier resultElementType = null;

        if (name.equals("xselect") || name.equals("selectOne")) {//$NON-NLS-1$ //$NON-NLS-2$
            resultElementType = sourceCollectionType.getElementType();
        } else {
            // Body may be defined explicitly - then it is the collectselect(One) shorthand or xcollect/collectOne.
            // It may be contained it the target variable - then it is the full notation of collectselect(One).
            if (imperativeIterateExpCS.getBody() != null) {
                OCLExpression<EClassifier> bodyExp = oclExpressionCS(imperativeIterateExpCS.getBody(), env);
                astNode.setBody(bodyExp);
                if (((imperativeIterateExpCS.getTarget() == null) || (imperativeIterateExpCS.getTarget().getInitExpression() == null))
                        && (name.equals("collectselect") || name.equals("collectselectOne"))) { //$NON-NLS-1$ //$NON-NLS-2$
                    // This is the case with collectselect(One) shorthand
                    // list->prop[res| res.startswith("_")];
                    // equivalent to
                    // list->collectselect(i;res = i.prop | res.startswith("_"))
                    if (!isInnermostIteratorRelated(vdcl, bodyExp)) {
                    	QvtOperationalUtil.reportError(env, NLS.bind(ValidationMessages.QvtOperationalVisitorCS_FeatureNotFoundForType,
                                new Object[] {QvtOperationalTypesUtil.getTypeFullName(vdcl.getType())}),
                                imperativeIterateExpCS.getBody());
                    }
                    if (imperativeIterateExpCS.getTarget() == null) {
                        Variable<EClassifier, EParameter> targetVdcl = genVariableDeclaration(imperativeIterateExpCS, "visitImperativeIterateExp", env, null, //$NON-NLS-1$
                                bodyExp.getType(), null, false, true, false);
                        astNode.setTarget(targetVdcl);
                    }
                }
            } 
            if (imperativeIterateExpCS.getTarget() != null) {
                Variable<EClassifier, EParameter> targetVdcl = variableDeclarationCS(imperativeIterateExpCS.getTarget(), env, true);
                if (targetVdcl.getInitExpression() != null) {
                    astNode.setBody(targetVdcl.getInitExpression()); // the body is transferred from the target variable due to containment
                }
                astNode.setTarget(targetVdcl);
            }
            if (astNode.getBody() != null) {
                resultElementType = astNode.getBody().getType();
                if ((astNode.getTarget() != null) && (astNode.getTarget().getType() == null)) {
                    astNode.getTarget().setType(resultElementType);
                }
            }
        }
        
        if (imperativeIterateExpCS.getCondition() != null) { 
            OCLExpression<EClassifier> conditionExp = oclExpressionCS(imperativeIterateExpCS.getCondition(), env);
            astNode.setCondition(conditionExp);
            if (conditionExp instanceof TypeExp<?>) {
                TypeExp<EClassifier> typedCondition = (TypeExp<EClassifier>) conditionExp;
                EClassifier rawTypeType = TypeUtil.resolveType(env, typedCondition.getType());
                if (rawTypeType instanceof TypeType) {
                    @SuppressWarnings("unchecked")
                    TypeType<EClassifier, EOperation> typeType = (TypeType<EClassifier, EOperation>) rawTypeType;
                    resultElementType = typeType.getReferredType();
                }
            } else if ((conditionExp != null) && (conditionExp.getType() != getBoolean())) {
            	QvtOperationalUtil.reportError(env, ValidationMessages.QvtOperationalVisitorCS_WrongImperativeIteratorConditionType, 
                        conditionExp.getStartPosition(), conditionExp.getEndPosition());
            }
        }
        
        if (astNode.getTarget() != null) {
            env.deleteElement(astNode.getTarget().getName());
        }

        if (name.equals("selectOne") || name.equals("collectOne") || name.equals("collectselectOne")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            astNode.setType(resultElementType);        
        } else if (name.equals("xselect")) { //$NON-NLS-1$
            EClassifier resultCollectionType = getCollectionType(env, sourceCollectionType.getKind(), resultElementType);
            astNode.setType(resultCollectionType);        
        } else { // xcollect and collectselect
            EClassifier resultCollectionType = ((sourceCollectionType instanceof SetType) || (sourceCollectionType instanceof BagType)) ?
                    getCollectionType(env, CollectionKind.BAG_LITERAL, resultElementType)
                    : getCollectionType(env, CollectionKind.SEQUENCE_LITERAL, resultElementType);
            astNode.setType(resultCollectionType);        
        }

        astNode.setSource(source);
        
        env.deleteElement(vdcl.getName());
        if (vdcl1 != null) {
            env.deleteElement(vdcl1.getName());
        }
		// ensure AST containment tree
        astNode.getIterator().addAll(iterators);
        return astNode;
    }
    
    private boolean isInnermostIteratorRelated(Variable<EClassifier, EParameter> vdcl, OCLExpression<EClassifier> bodyExp) {
        if (bodyExp instanceof CallExp) {
            CallExp bodyCallExp = (CallExp) bodyExp;
            if (bodyCallExp.getSource() instanceof VariableExp) {
                VariableExp<EClassifier, EParameter> sourceExp = (VariableExp<EClassifier, EParameter>) bodyCallExp.getSource();
                return sourceExp.getReferredVariable() == vdcl;
            }
            return false;
        }
        return true; // might be switch exp, for example
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
				
				mappingCallExp.setPropertyStartPosition(operationCallExp.getPropertyStartPosition());
				mappingCallExp.setPropertyEndPosition(operationCallExp.getPropertyEndPosition());				
				
				return mappingCallExp;
			}
		}
		return null;
	}

	private void validateOperationCall(OperationCallExpCS opCallCS, OperationCallExp<EClassifier, EOperation> operationCallExp, 
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		
		if (QvtOperationalParserUtil.isTypeCast(operationCallExp.getReferredOperation())) {
			if (operationCallExp.getSource() != null && operationCallExp.getArgument().size() == 1) {
				EClassifier sourceType = operationCallExp.getSource().getType();
				EClassifier argumentType = ((OCLExpression<EClassifier>) operationCallExp.getArgument().get(0))
						.getType();
				if (argumentType instanceof TypeType
						&& QvtOperationalParserUtil.isIncorrectCast(sourceType,
								((TypeType<EClassifier, EOperation>) argumentType).getReferredType())) {
					QvtOperationalUtil.reportWarning(env, ValidationMessages.incorrectCastWarning, opCallCS);
				}
			}
		}
		if (QvtOperationalUtil.isMappingOperation(operationCallExp.getReferredOperation())) {
			if (false == opCallCS instanceof MappingCallExpCS) {
				QvtOperationalUtil.reportWarning(env, NLS.bind(ValidationMessages.QvtOperationalVisitorCS_mapKeywordNotUsed,
						operationCallExp.getReferredOperation().getName()), opCallCS);
			}
		}
	}

	
	private void validateImportedSignature(QvtOperationalEnv env, OperationalTransformation module, OperationalTransformation importedModule, ASTNode astNode) {
		Set<ModelParameter> processedParams = new HashSet<ModelParameter>();
		Set<ModelParameter> consideredParams = new HashSet<ModelParameter>();
		for (ModelParameter importedParam : importedModule.getModelParameter()) {
			for (ModelParameter param : module.getModelParameter()) {
				if (consideredParams.contains(param)) {
					continue;
				}
				if (QvtOperationalUtil.isModelParamEqual(param, importedParam, true)) {
					consideredParams.add(param);
					processedParams.add(importedParam);
					break;
				}
			}
		}

		for (ModelParameter importedParam : importedModule.getModelParameter()) {
			if (processedParams.contains(importedParam)) {
				continue;
			}
			boolean isCorrespondanceFound = false;
			for (ModelParameter param : module.getModelParameter()) {
				if (consideredParams.contains(param)) {
					continue;
				}
				if (QvtOperationalUtil.isModelParamEqual(param, importedParam, false)) {
					consideredParams.add(param);
					isCorrespondanceFound = true;
					break;
				}
			}
			if (!isCorrespondanceFound) {
				env.reportWarning(
						NLS.bind(ValidationMessages.QvtOperationalVisitorCS_incompatibleTransfSignature, importedModule.getName()),
						astNode.getStartPosition(), astNode.getEndPosition());
				return;
			}
		}
	}

	private void checkMainMappingConformance(QvtOperationalEnv env, ImperativeOperation operation) {
		Set<ModelParameter> usedExtent = new HashSet<ModelParameter>(operation.getEParameters().size());
		for (EParameter param : operation.getEParameters()) {
			MappingParameter varParam = (MappingParameter) param;
			if (usedExtent.contains(varParam.getExtent())) {
                env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_extentDuplicateUse, null),  
                		varParam.getStartPosition(), varParam.getEndPosition());
			}
			if (varParam.getKind() != DirectionKind.OUT) {
				usedExtent.add(varParam.getExtent());
			}
			
			if (varParam.getExtent() == null) {
				if(varParam.getKind() != DirectionKind.IN) {
					env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_extentFailToInfer,
							QvtOperationalTypesUtil.getTypeFullName(varParam.getEType())),  
							varParam.getStartPosition(), varParam.getEndPosition());
				}
			}
			else if (varParam.getExtent().getKind() == DirectionKind.IN) {
				if (varParam.getKind() != DirectionKind.IN) {
	                env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_extentDirectionMismatch, null),  
	                		varParam.getStartPosition(), varParam.getEndPosition());
				}
			}
			else if (varParam.getExtent().getKind() == DirectionKind.OUT) {
				if (varParam.getKind() != DirectionKind.OUT) {
	                env.reportError(NLS.bind(ValidationMessages.QvtOperationalVisitorCS_extentDirectionMismatch, null),  
	                		varParam.getStartPosition(), varParam.getEndPosition());
				}
			}
		}
	}

    private void checkAbstractOutParamsInitialized(EList<VarParameter> result, MappingRuleCS methodCS, QvtOperationalEnv env) {
        for (VarParameter varParameter : result) {
            EClassifier type = varParameter.getEType();
            if (type instanceof EClass) {
                EClass eClass = (EClass) type;
                if (!QvtOperationalUtil.isInstantiable(eClass)) {
                    MappingInitCS init = (methodCS.getMappingBody() == null) ? null : methodCS.getMappingBody().getMappingInitCS();
                    if (init != null) {
                        // TODO: The check could be more accurate
                        return;
                    }
                    if((methodCS.getMappingDeclarationCS() != null) && !(methodCS.getMappingDeclarationCS().getQualifiers().contains(QualifierKindCS.ABSTRACT))) {
                    	boolean hasDisjunct = false;
                    	for (MappingExtensionCS extensionCS : methodCS.getMappingDeclarationCS().getMappingExtension()) {
							if(extensionCS.getKind() == MappingExtensionKindCS.DISJUNCTS) {
								hasDisjunct = true;
								break;
							}
						}
                    	if(!hasDisjunct) {
                    		env.reportError(ValidationMessages.QvtOperationalVisitorCS_AbstractTypesNotInitialized, methodCS);
                    	}
                    }
                }
            }
        }
    }
    
	private boolean validateInitializedValueCS(VariableInitializationCS varInitCS, VariableInitExp result, 
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		
		result.setName(varInitCS.getSimpleNameCS().getValue());

		EClassifier type;
		if (varInitCS.getTypeCS() != null) {
			type = visitTypeCS(varInitCS.getTypeCS(), null, env);
			if (type == null) {
				return false;
			}
		} else {
			type = null;
		}

		if (varInitCS.getOclExpressionCS() == null) {
		    if (type == null) {
		        return false;
		    } else {
		        OCLExpression<EClassifier> defaultInitializationValue = createDefaultInitializationValue(type, env);
		        if (defaultInitializationValue == null) {
		            NullLiteralExp<EClassifier> nullLiteralExp = oclFactory.createNullLiteralExp();
		            nullLiteralExp.setType(getOclVoid());
		            defaultInitializationValue = nullLiteralExp;
		        }
		        result.setValue(defaultInitializationValue);
		    }
		} else {
	        OCLExpression<EClassifier> exp = visitOclExpressionCS(varInitCS.getOclExpressionCS(), env);
	        if (exp == null) {
	            return false;
	        }
	        result.setValue(exp);
		}
		result.setType(type);
		return true;
	}

	private OCLExpression<EClassifier> createDefaultInitializationValue(EClassifier type, 
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
        // 8.2.2.10 VariableInitExp
        // A variable may not declare an initialization value. In this case a default value is assumed (an empty collection for a collection,
        // zero for any numeric type, the empty string for a string and null for all other elements.
        // A. Igdalov: Spec says nothing about Booleans and OclInvalid. Abstract collections (Collection, opposed to Bags, OrderedSets, etc.) are also neglected.
        // Thus, this implementation assigns false to Booleans, Invalid to OclInvalids and nulls to abstract collections.
	    if (type instanceof org.eclipse.ocl.ecore.CollectionType) {
            org.eclipse.ocl.ecore.CollectionType collectionType = (org.eclipse.ocl.ecore.CollectionType) type;
            CollectionKind kind = collectionType.getKind();
            if (CollectionKind.COLLECTION_LITERAL == kind) {
                return null;
            }
            CollectionLiteralExp<EClassifier> collectionLiteralExp = oclFactory.createCollectionLiteralExp();
            collectionLiteralExp.setKind(kind);
            EClassifier resultType = getCollectionType(env, kind, collectionType.getElementType());
            collectionLiteralExp.setType(resultType);
            return collectionLiteralExp;
        } else {
            EClassifier resolvedType = env.getTypeResolver().resolve(type);
            OCLStandardLibrary<EClassifier> oclStdLib = getStandardLibrary();
            if (resolvedType == oclStdLib.getBoolean()) {
                BooleanLiteralExp<EClassifier> booleanLiteralExp = oclFactory.createBooleanLiteralExp();
                booleanLiteralExp.setBooleanSymbol(Boolean.FALSE);
                booleanLiteralExp.setType(oclStdLib.getBoolean());
                return booleanLiteralExp;
            } else if (resolvedType == oclStdLib.getInteger()) {
                IntegerLiteralExp<EClassifier> integerLiteralExp = oclFactory.createIntegerLiteralExp();
                integerLiteralExp.setIntegerSymbol(0);
                integerLiteralExp.setType(oclStdLib.getInteger());
                return integerLiteralExp;
            } else if (resolvedType == oclStdLib.getReal()) {
                RealLiteralExp<EClassifier> realLiteralExp = oclFactory.createRealLiteralExp();
                realLiteralExp.setRealSymbol(0.0);
                realLiteralExp.setType(oclStdLib.getReal());
                return realLiteralExp;
            } else if (resolvedType == oclStdLib.getUnlimitedNatural()) {
                UnlimitedNaturalLiteralExp<EClassifier> unlimitedNaturalLiteralExp = oclFactory.createUnlimitedNaturalLiteralExp();
                unlimitedNaturalLiteralExp.setIntegerSymbol(0);
                unlimitedNaturalLiteralExp.setType(oclStdLib.getUnlimitedNatural());
                return unlimitedNaturalLiteralExp;
            } else if (resolvedType == oclStdLib.getInvalid()) {
                InvalidLiteralExp<EClassifier> invalidLiteralExp = oclFactory.createInvalidLiteralExp();
                invalidLiteralExp.setType(oclStdLib.getInvalid());
                return invalidLiteralExp;
            } else if (resolvedType == oclStdLib.getString()) {
                org.eclipse.ocl.expressions.StringLiteralExp<EClassifier> stringLiteralExp = oclFactory.createStringLiteralExp();
                stringLiteralExp.setStringSymbol(""); //$NON-NLS-1$
                stringLiteralExp.setType(oclStdLib.getString());
                return stringLiteralExp;
            }
        }
	    return null;
	}
		
	private void addLateResolve(ResolveExp resolve) {
		assert resolve.isIsDeferred();
		if(myLateResolveExps == null) {
			myLateResolveExps = new LinkedList<ResolveExp>();
		}
		myLateResolveExps.add(resolve);
	}
	
	private List<ResolveExp> getAllLateResolves() {
		return myLateResolveExps != null ? myLateResolveExps : Collections.<ResolveExp>emptyList();
	}

	private void validate(Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		for (ResolveExp lateResolve : getAllLateResolves()) {
			validateResolveExp(lateResolve, env);
		}
	}
	
	/**
	 * SimpleNameCS
	 * @param simpleNameCS the <code>SimpleNameCS</code> <code>CSTNode</code>
	 * @param fEnv the OCL environment
	 * @param source the source of the <code>SimpleNameCS</code>
	 * @return the parsed <code>OCLExpression</code> 
	 */
	private OCLExpression<EClassifier> customSimpleNameCS(
    		SimpleNameCS simpleNameCS,
    		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
    		OCLExpression<EClassifier> source) {

		if ((source != null) && isErrorNode(source)) {
			// don't attempt to parse navigation from an unparseable source
			return source; // return the same unparseable token
		}
		
		String simpleName = null;		
		EClassifier classifier = null;

		/* A name can be a variable defined by a Variable declaration, the special
		  variable "self", an attribute or a reference to another object.
		  If the source is not null, then the last token was a "." or "->"
		  The source is used to establish the navigation.
		  If no type is provided, then either the name is a the use of a variable,
		  or there is an implicit variable declaration (self or an iterator)
		  that is the source.		  		   
		 */
		switch (simpleNameCS.getType().getValue()) {
			case SimpleTypeEnum.SELF:
			case SimpleTypeEnum.KEYWORD:
			case SimpleTypeEnum.IDENTIFIER:
				simpleName = simpleNameCS.getValue();
				break;
			case SimpleTypeEnum.INTEGER:
			case SimpleTypeEnum.STRING:
			case SimpleTypeEnum.REAL:
			case SimpleTypeEnum.BOOLEAN:
			case SimpleTypeEnum.OCL_ANY:
			case SimpleTypeEnum.OCL_VOID:
			case SimpleTypeEnum.INVALID:
			case SimpleTypeEnum.OCL_MESSAGE:
				// if we have a source, then this is a feature call
				if (source == null) {
					classifier = primitiveTypeCS(simpleNameCS.getType(), env);
					simpleName = uml.getName(classifier);
				}
				break;
		}

					
		/*
		 * The source may be a collection type (for example, in self.children.name, children
		 * may be a set.)_  In this case, we have to get the element type of children, so
		 * that the attribute name can be found.
		 * The source type can also be a tuple type. In this case, we need to get the 
		 * EClass of the tuple.
		 * 
		 */ 
		EClassifier sourceElementType = null;
		if (source != null) {
			sourceElementType = source.getType();
			if (sourceElementType instanceof CollectionType) {
				@SuppressWarnings("unchecked")
				CollectionType<EClassifier, EOperation> ct = (CollectionType<EClassifier, EOperation>) sourceElementType;
				
				sourceElementType = ct.getElementType();
			} 
		}
		
		// cascaded alternatives for a simpleNameCS
		OCLExpression<EClassifier> astNode = simpleTypeName(simpleNameCS, env, source,
			classifier, simpleName);
		if (astNode == null) {
			astNode = simpleVariableName(simpleNameCS, env, source, simpleName);
		}
		if (astNode == null) {
			astNode = simplePropertyName(simpleNameCS, env, source,
				sourceElementType, simpleName);
		}
		if (astNode == null) {
			astNode = simpleAssociationClassName(simpleNameCS, env, source,
				sourceElementType, simpleName);
		}
		if (astNode == null) {
			astNode = simpleUndefinedName(simpleNameCS, env, source, simpleName);
		}
		
		// FIXME - we should ask MDT OCL for a support to handle this in a better way
		/*
		 * If the source type is a collection, then need there is an implicit COLLECT 
		 * or imperative COLLECT operator.
		 */
		if ((source != null) && (source.getType() instanceof CollectionType)
				&& (astNode instanceof FeatureCallExp)) {
		    CallExpCS callExpCS = (CallExpCS) simpleNameCS.eContainer();
		    FeatureCallExp<EClassifier> featureCallExp = (FeatureCallExp<EClassifier>) astNode;
		    astNode = isArrowAccessToCollection(callExpCS, source) ?
		            createImplicitXCollect(source, featureCallExp, env, simpleNameCS)
		            : createImplicitCollect(source, featureCallExp, env, simpleNameCS);
		}

		return astNode;
	}	

	private static void createPropertyCallASTBinding(
			CallExpCS propertyCallExpCS,
			OCLExpression<EClassifier> result,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		ASTNode boundAST = result;
		CSTNode boundCST = propertyCallExpCS;            	
		if(result instanceof IteratorExp) {
			IteratorExp<EClassifier, EParameter> itExpAST = (IteratorExp<EClassifier, EParameter>) result;
			if(propertyCallExpCS instanceof IteratorExpCS) {
				IteratorExpCS itExpCST = (IteratorExpCS) propertyCallExpCS;
				if(itExpCST.getBody() != null) {
					boundCST = itExpCST.getBody();
				}
			}            		
			if(itExpAST.getBody() instanceof FeatureCallExp) {
				boundAST = (FeatureCallExp<EClassifier>) itExpAST.getBody();
			}
		} else if(result instanceof ImperativeIterateExp) {
			ImperativeIterateExp impIterExpAST = (ImperativeIterateExp) result;
			if(propertyCallExpCS instanceof ImperativeIterateExpCS) {
				ImperativeIterateExpCS itExpCST = (ImperativeIterateExpCS) propertyCallExpCS;
				if(itExpCST.getBody() != null) {
					boundCST = itExpCST.getBody();
				}
			}
			if(impIterExpAST.getBody() instanceof FeatureCallExp) {
				boundAST = (FeatureCallExp<EClassifier>) impIterExpAST.getBody();
			}			
		}
		ASTBindingHelper.createCST2ASTBinding(boundCST, boundAST, env);
	}

	private static List<ModelParameter> getModelParameter(Module module) {
		if(module instanceof OperationalTransformation) {
			OperationalTransformation operationalTransformation = (OperationalTransformation) module;
			return operationalTransformation.getModelParameter();
		}
		return Collections.emptyList();
	}
	
	private static void addInitVariable(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env, 
			VariableInitExp varInit) {
		if (varInit.getName() != null) {
			Variable<EClassifier, EParameter> var = EcoreFactory.eINSTANCE.createVariable();
			var.setName(varInit.getName());
			var.setType(varInit.getType());
			env.addElement(varInit.getName(), var, true);
		}
	}
	
	private static QvtOperationalModuleEnv getModuleContextEnv(QvtOperationalEnv env) {
		Internal<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> 
			nextParent = env;
		while(nextParent != null) {
			if(nextParent instanceof QvtOperationalModuleEnv) {
				return (QvtOperationalModuleEnv) nextParent;
			}
			nextParent = nextParent.getInternalParent();
		}
		
		return null;
	}

	private static String wrappInSeeErrorLogMessage(String message) {
		return NLS.bind(ValidationMessages.QvtOperationalVisitorCS_SeeErrorLogForDetails, message);
	}
	
	private static QvtOperationalEnv toQVTOperationalEnv(Environment<EPackage, EClassifier, 
			EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, 
			CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) throws IllegalArgumentException {
		
		QvtOperationalEnv adapter = OCLUtil.getAdapter(env, QvtOperationalEnv.class);
		if(adapter == null) {
			throw new IllegalArgumentException("QVTOperationalEnv is required"); //$NON-NLS-1$
		}
		
		return adapter;
	}
}