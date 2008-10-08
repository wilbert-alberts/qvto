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
package org.eclipse.m2m.internal.qvt.oml.evaluator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.internal.qvt.oml.expressions.AltExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.AssertExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.AssignExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.BlockExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ConfigProperty;
import org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty;
import org.eclipse.m2m.internal.qvt.oml.expressions.EntryOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ForExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.Helper;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeIterateExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeLoopExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.InstantiationExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;
import org.eclipse.m2m.internal.qvt.oml.expressions.LocalProperty;
import org.eclipse.m2m.internal.qvt.oml.expressions.LogExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingCallExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.internal.qvt.oml.expressions.ObjectExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.Property;
import org.eclipse.m2m.internal.qvt.oml.expressions.Rename;
import org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ResolveInExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ReturnExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.SwitchExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.VariableInitExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.WhileExp;
import org.eclipse.ocl.EvaluationVisitorDecorator;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StateExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.Visitable;

abstract class QvtGenericEvaluationVisitor 
	extends EvaluationVisitorDecorator<EPackage, EClassifier, EOperation, 
				EStructuralFeature, EEnumLiteral, EParameter, EObject, 
				CallOperationAction, SendSignalAction, Constraint, EClass, EObject> 
	implements QvtOperationalEvaluationVisitor {

	static abstract class Any extends QvtGenericEvaluationVisitor {
				
		protected Any(QvtOperationalEvaluationVisitor qvtExtVisitor) {
			super(qvtExtVisitor);
		}

		protected abstract void genericVisitAny(Object object);

		@Override
		protected void genericVisitAST(ASTNode visited) {
			genericVisitAny(visited);			
		}
		
		@Override
		protected void genericVisitVisitable(Visitable visited) {
			genericVisitAny(visited);
		}	
			
		@Override
		protected void genericVisitEObject(EObject visited) {
			genericVisitAny(visited);			
		}
	}
	
	protected QvtGenericEvaluationVisitor(QvtOperationalEvaluationVisitor qvtExtVisitor) {
		super(qvtExtVisitor);
	}
			
	private QvtOperationalEvaluationVisitor getQVTDelegate() {
		return (QvtOperationalEvaluationVisitor) getDelegate();
	}	
	
	protected void genericVisitAST(ASTNode visited) {
	}
	
	protected void genericVisitVisitable(Visitable visited) {
	}	
		
	protected void genericVisitEObject(EObject visited) {
	}
		
	@Override
	public Object visitAssociationClassCallExp(AssociationClassCallExp<EClassifier, EStructuralFeature> callExp) {
		genericVisitAST(callExp);
		return super.visitAssociationClassCallExp(callExp);
	}

	@Override
	public Object visitBooleanLiteralExp(BooleanLiteralExp<EClassifier> literalExp) {
		genericVisitAST(literalExp);
		return super.visitBooleanLiteralExp(literalExp);
	}

	@Override
	public Object visitCollectionItem(CollectionItem<EClassifier> item) {
		genericVisitVisitable(item);
		return super.visitCollectionItem(item);
	}

	@Override
	public Object visitCollectionLiteralExp(CollectionLiteralExp<EClassifier> literalExp) {
		genericVisitAST(literalExp);
		return super.visitCollectionLiteralExp(literalExp);
	}

	@Override
	public Object visitCollectionRange(CollectionRange<EClassifier> range) {
		genericVisitVisitable(range);
		return super.visitCollectionRange(range);
	}

	@Override
	public Object visitConstraint(Constraint constraint) {
		genericVisitEObject(constraint);
		return super.visitConstraint(constraint);
	}

	@Override
	public Object visitEnumLiteralExp(EnumLiteralExp<EClassifier, EEnumLiteral> literalExp) {
		genericVisitAST(literalExp);
		return super.visitEnumLiteralExp(literalExp);
	}

	@Override
	public Object visitExpression(OCLExpression<EClassifier> expression) {
		genericVisitAST(expression);
		return super.visitExpression(expression);
	}

	@Override
	public Object visitExpressionInOCL(ExpressionInOCL<EClassifier, EParameter> expression) {
		genericVisitVisitable(expression);
		return super.visitExpressionInOCL(expression);
	}

	@Override
	public Object visitIfExp(IfExp<EClassifier> ifExp) {
		genericVisitAST(ifExp);
		return super.visitIfExp(ifExp);
	}

	@Override
	public Object visitIntegerLiteralExp(IntegerLiteralExp<EClassifier> literalExp) {
		genericVisitAST(literalExp);
		return super.visitIntegerLiteralExp(literalExp);
	}

	@Override
	public Object visitInvalidLiteralExp(InvalidLiteralExp<EClassifier> literalExp) {
		genericVisitAST(literalExp);
		return super.visitInvalidLiteralExp(literalExp);
	}

	@Override
	public Object visitIterateExp(IterateExp<EClassifier, EParameter> callExp) {
		genericVisitAST(callExp);
		return super.visitIterateExp(callExp);
	}

	@Override
	public Object visitIteratorExp(IteratorExp<EClassifier, EParameter> callExp) {
		genericVisitAST(callExp);
		return super.visitIteratorExp(callExp);
	}

	@Override
	public Object visitLetExp(LetExp<EClassifier, EParameter> letExp) {
		genericVisitAST(letExp);
		return super.visitLetExp(letExp);
	}

	@Override
	public Object visitMessageExp(MessageExp<EClassifier, CallOperationAction, SendSignalAction> messageExp) {
		genericVisitVisitable(messageExp);
		return super.visitMessageExp(messageExp);
	}

	@Override
	public Object visitNullLiteralExp(NullLiteralExp<EClassifier> literalExp) {
		genericVisitAST(literalExp);
		return super.visitNullLiteralExp(literalExp);
	}

	@Override
	public Object visitOperationCallExp(
			OperationCallExp<EClassifier, EOperation> callExp) {
		genericVisitAST(callExp);
		return super.visitOperationCallExp(callExp);
	}

	@Override
	public Object visitPropertyCallExp(PropertyCallExp<EClassifier, EStructuralFeature> callExp) {
		genericVisitAST(callExp);
		return super.visitPropertyCallExp(callExp);
	}

	@Override
	public Object visitRealLiteralExp(RealLiteralExp<EClassifier> literalExp) {
		genericVisitAST(literalExp);
		return super.visitRealLiteralExp(literalExp);
	}

	@Override
	public Object visitStateExp(StateExp<EClassifier, EObject> stateExp) {
		genericVisitAST(stateExp);
		return super.visitStateExp(stateExp);
	}

	@Override
	public Object visitStringLiteralExp(StringLiteralExp<EClassifier> literalExp) {
		genericVisitAST(literalExp);
		return super.visitStringLiteralExp(literalExp);
	}

	@Override
	public Object visitTupleLiteralExp(TupleLiteralExp<EClassifier, EStructuralFeature> literalExp) {
		genericVisitAST(literalExp);
		return super.visitTupleLiteralExp(literalExp);
	}

	@Override
	public Object visitTupleLiteralPart(TupleLiteralPart<EClassifier, EStructuralFeature> part) {
		genericVisitAST(part);
		return super.visitTupleLiteralPart(part);
	}

	@Override
	public Object visitTypeExp(TypeExp<EClassifier> typeExp) {
		genericVisitAST(typeExp);
		return super.visitTypeExp(typeExp);
	}

	@Override
	public Object visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp<EClassifier> literalExp) {
		genericVisitAST(literalExp);
		return super.visitUnlimitedNaturalLiteralExp(literalExp);
	}

	@Override
	public Object visitUnspecifiedValueExp(UnspecifiedValueExp<EClassifier> unspecExp) {
		genericVisitAST(unspecExp);
		return super.visitUnspecifiedValueExp(unspecExp);
	}

	@Override
	public Object visitVariable(Variable<EClassifier, EParameter> variable) {
		genericVisitAST(variable);
		return super.visitVariable(variable);
	}

	@Override
	public Object visitVariableExp(VariableExp<EClassifier, EParameter> variableExp) {
		genericVisitAST(variableExp);
		return super.visitVariableExp(variableExp);
	}

	
	/////////////////////////////////////////////////////////////////////////
	// QVT specific visitors
	/////////////////////////////////////////////////////////////////////////	
	
	public Object visitAssignExp(AssignExp assignExp) {
		return getQVTDelegate().visitAssignExp(assignExp);
	}

	public Object visitBlockExp(BlockExp blockExp) {
		return getQVTDelegate().visitBlockExp(blockExp);
	}

	public Object visitConfigProperty(ConfigProperty configProperty) {		// 
		return getQVTDelegate().visitConfigProperty(configProperty);
	}

	public Object visitHelper(Helper helper) {
		return getQVTDelegate().visitHelper(helper);
	}

	public Object visitImperativeOperation(ImperativeOperation imperativeOperation) {
		return getQVTDelegate().visitImperativeOperation(imperativeOperation);
	}

	public Object visitLibrary(Library library) {
		return getQVTDelegate().visitLibrary(library);
	}

	public Object visitLocalProperty(LocalProperty localProperty) {
		return getQVTDelegate().visitLocalProperty(localProperty);
	}

	public Object visitContextualProperty(ContextualProperty contextualProperty) {
		return getQVTDelegate().visitContextualProperty(contextualProperty);
	}

	public Object visitMappingBody(MappingBody mappingBody) {
		return getQVTDelegate().visitMappingBody(mappingBody);
	}

	public Object visitMappingCallExp(MappingCallExp mappingCallExp) {		
		return getQVTDelegate().visitMappingCallExp(mappingCallExp);
	}

	public Object visitMappingOperation(MappingOperation mappingOperation) {
		return getQVTDelegate().visitMappingOperation(mappingOperation);
	}

	public Object visitModelType(ModelType modelType) {
		return getQVTDelegate().visitModelType(modelType);
	}

	public Object visitModule(Module module) {
		return getQVTDelegate().visitModule(module);
	}

	public Object visitModuleImport(ModuleImport moduleImport) {
		return getQVTDelegate().visitModuleImport(moduleImport);
	}

	public Object visitObjectExp(ObjectExp objectExp) {
		return getQVTDelegate().visitObjectExp(objectExp);
	}
		
	public Object visitInstantiationExp(InstantiationExp instatiationExp) {
		return getQVTDelegate().visitInstantiationExp(instatiationExp);
	}

	public Object visitOperationBody(OperationBody operationBody) {
		return getQVTDelegate().visitOperationBody(operationBody);
	}

	public Object visitProperty(Property property) {
		return getQVTDelegate().visitProperty(property);
	}

	public Object visitRename(Rename rename) {
		return getQVTDelegate().visitRename(rename);
	}

	public Object visitResolveExp(ResolveExp resolveExp) {
		return getQVTDelegate().visitResolveExp(resolveExp);
	}

	public Object visitResolveInExp(ResolveInExp resolveInExp) {
		return getQVTDelegate().visitResolveInExp(resolveInExp);
	}

	public Object visitSwitchAltExp(AltExp switchAltExp) {
		return getQVTDelegate().visitSwitchAltExp(switchAltExp);
	}

	public Object visitSwitchExp(SwitchExp switchExp) {
		return getQVTDelegate().visitSwitchExp(switchExp);
	}

	public Object visitVariableInitExp(VariableInitExp variableInitExp) {
		return getQVTDelegate().visitVariableInitExp(variableInitExp);
	}

	public Object visitVarParameter(VarParameter varParameter) {
		return getQVTDelegate().visitVarParameter(varParameter);
	}

	public Object visitWhileExp(WhileExp whileExp) {
		return getQVTDelegate().visitWhileExp(whileExp);
	}			
	
	public Object visitAssertExp(AssertExp assertExp) {
		return getQVTDelegate().visitAssertExp(assertExp);
	}
	
	public Object visitLogExp(LogExp logExp) {
		return getQVTDelegate().visitLogExp(logExp);
	}
	
    public Object visitImperativeLoopExp(ImperativeLoopExp imperativeLoopExp) {
        return getQVTDelegate().visitImperativeLoopExp(imperativeLoopExp);
    }

    public Object visitForExp(ForExp forExp) {
        return getQVTDelegate().visitForExp(forExp);
    }

    public Object visitImperativeIterateExp(ImperativeIterateExp imperativeIterateExp) {
        return getQVTDelegate().visitImperativeIterateExp(imperativeIterateExp);
    }
    
    public Object visitReturnExp(ReturnExp returnExp) {
        return getQVTDelegate().visitReturnExp(returnExp);
    }
    
    public Object visitEntryOperation(EntryOperation entryOperation) {    
    	return getQVTDelegate().visitEntryOperation(entryOperation);
    }
}