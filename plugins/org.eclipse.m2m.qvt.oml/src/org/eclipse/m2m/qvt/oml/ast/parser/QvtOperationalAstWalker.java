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
package org.eclipse.m2m.qvt.oml.ast.parser;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.qvt.oml.expressions.AssignExp;
import org.eclipse.m2m.qvt.oml.expressions.BlockExp;
import org.eclipse.m2m.qvt.oml.expressions.ConfigProperty;
import org.eclipse.m2m.qvt.oml.expressions.ExtendedVisitor;
import org.eclipse.m2m.qvt.oml.expressions.Helper;
import org.eclipse.m2m.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.expressions.Library;
import org.eclipse.m2m.qvt.oml.expressions.LocalProperty;
import org.eclipse.m2m.qvt.oml.expressions.MappingBody;
import org.eclipse.m2m.qvt.oml.expressions.MappingCallExp;
import org.eclipse.m2m.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.qvt.oml.expressions.ObjectExp;
import org.eclipse.m2m.qvt.oml.expressions.OperationBody;
import org.eclipse.m2m.qvt.oml.expressions.Property;
import org.eclipse.m2m.qvt.oml.expressions.Rename;
import org.eclipse.m2m.qvt.oml.expressions.ResolveExp;
import org.eclipse.m2m.qvt.oml.expressions.ResolveInExp;
import org.eclipse.m2m.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.qvt.oml.expressions.VariableInitExp;
import org.eclipse.m2m.qvt.oml.expressions.WhileExp;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionLiteralPart;
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
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.Visitable;

public class QvtOperationalAstWalker implements ExtendedVisitor<Object, EObject, CallOperationAction, SendSignalAction, Constraint> {
    public static class StopException extends RuntimeException {
        private static final long serialVersionUID = -1386908042373844768L;

        public static final StopException INSTANCE = new StopException();

        private StopException() {}
    }

    public interface NodeProcessor {
        void process(Visitable e, Visitable parent) throws StopException;
    }

    public QvtOperationalAstWalker(final NodeProcessor processor) {
        myNodeProcessor = processor;
        myProcessed = new HashSet<Visitable>();
    }

    public Object visitAssignExp(AssignExp assignExp) {
        doProcess(assignExp.getLeft(), assignExp);
        for (OCLExpression<EClassifier> exp : assignExp.getValue()) {
            doProcess(exp, assignExp);
        }
        return null;
    }


    public Object visitConfigProperty(ConfigProperty configProperty) {
        return null;
    }


    public Object visitHelper(Helper helper) {
        visitImperativeOperation(helper);
        return null;
    }


    public Object visitImperativeOperation(ImperativeOperation imperativeOperation) {
        doProcess(imperativeOperation.getBody(), imperativeOperation);
        return null;
    }


    public Object visitLibrary(Library library) {
        return null;
    }


    public Object visitLocalProperty(LocalProperty localProperty) {
        doProcess(localProperty.getExpression(), localProperty);
        return null;
    }


    public Object visitMappingBody(MappingBody mappingBody) {
        for (OCLExpression<EClassifier> exp : mappingBody.getInitSection()) {
            doProcess(exp, mappingBody);
        }
        for (OCLExpression<EClassifier> exp : mappingBody.getContent()) {
            doProcess(exp, mappingBody);
        }
        for (OCLExpression<EClassifier> exp : mappingBody.getEndSection()) {
            doProcess(exp, mappingBody);
        }
        return null;
    }


    public Object visitMappingCallExp(MappingCallExp mappingCallExp) {
        visitOperationCallExp(mappingCallExp);
        return null;
    }


    public Object visitMappingOperation(MappingOperation mappingOperation) {
        doProcess(mappingOperation.getBody(), mappingOperation);
        for (OCLExpression<EClassifier> exp : mappingOperation.getWhen()) {
            doProcess(exp, mappingOperation);
        }
        return null;
    }


    public Object visitModule(Module module) {
        myNodeProcessor.process(module, null);
        for (Rename rename : module.getOwnedRenaming()) {
            doProcess(rename, module);
        }
        for (EOperation op : module.getEOperations()) {
            doProcess((ImperativeOperation) op, module);
        }
        for (Property prop : module.getConfigProperty()) {
            doProcess(prop, module);
        }
        return null;
    }


    public Object visitModuleImport(ModuleImport moduleImport) {
        return null;
    }


    public Object visitObjectExp(ObjectExp objectExp) {
        for (OCLExpression<EClassifier> exp : objectExp.getContent()) {
            doProcess(exp, objectExp);
        }
        return null;
    }


    public Object visitOperationBody(OperationBody operationBody) {
        for (OCLExpression<EClassifier> exp : operationBody.getContent()) {
            doProcess(exp, operationBody);
        }
        return null;
    }


    public Object visitProperty(Property property) {
        return null;
    }


    public Object visitRename(Rename rename) {
        return null;
    }


    public Object visitVarParameter(VarParameter varParameter) {
        return null;
    }


    public Object visitVariableInitExp(VariableInitExp variableInitExp) {
        doProcess(variableInitExp.getValue(), variableInitExp);
        return null;
    }

    
    public Object visitBlockExp(BlockExp blockExp) {
        for (OCLExpression<EClassifier> exp : blockExp.getBody()) {
            doProcess(exp, blockExp);
        }
        return null;
    }


    public Object visitWhileExp(WhileExp whileExp) {
        for (OCLExpression<EClassifier> exp : whileExp.getBody()) {
            doProcess(exp, whileExp);
        }
        if (whileExp.getCondition() != null) {
            doProcess(whileExp.getCondition(), whileExp);
        }
        if (whileExp.getResult() != null) {
            doProcess(whileExp.getResult(), whileExp);
        }
        return null;
    }


    public Object visitAssociationClassCallExp(AssociationClassCallExp<EClassifier, EStructuralFeature> callExp) {
        for (OCLExpression<EClassifier> exp : callExp.getQualifier()) {
            doProcess(exp, callExp);
        }
        doProcess(callExp.getSource(), callExp);
        return null;
    }


    public Object visitBooleanLiteralExp(BooleanLiteralExp<EClassifier> literalExp) {
        return null;
    }


    public Object visitCollectionItem(CollectionItem<EClassifier> item) {
        doProcess(item.getItem(), item);
        return null;
    }


    public Object visitCollectionLiteralExp(CollectionLiteralExp<EClassifier> literalExp) {
        for (CollectionLiteralPart<EClassifier> part : literalExp.getPart()) {
            doProcess(part, literalExp);
        }
        return null;
    }


    public Object visitCollectionRange(CollectionRange<EClassifier> range) {
        doProcess(range.getFirst(), range);
        doProcess(range.getLast(), range);
        return null;
    }


    public Object visitConstraint(Constraint constraint) {
        doProcess(constraint.getSpecification().getBodyExpression(), constraint.getSpecification());
        return null;
    }


    public Object visitEnumLiteralExp(EnumLiteralExp<EClassifier, EEnumLiteral> literalExp) {
        return null;
    }


    public Object visitExpressionInOCL(ExpressionInOCL<EClassifier, EParameter> expression) {
        return null;
    }


    public Object visitIfExp(IfExp<EClassifier> ifExp) {
        doProcess(ifExp.getCondition(), ifExp);
        doProcess(ifExp.getThenExpression(), ifExp);
        doProcess(ifExp.getElseExpression(), ifExp);
        return null;
    }


    public Object visitIntegerLiteralExp(IntegerLiteralExp<EClassifier> literalExp) {
        return null;
    }


    public Object visitInvalidLiteralExp(InvalidLiteralExp<EClassifier> literalExp) {
        return null;
    }


    public Object visitIterateExp(IterateExp<EClassifier, EParameter> callExp) {
        doProcess(callExp.getResult(), callExp);
        doProcess(callExp.getBody(), callExp);
        return null;
    }


    public Object visitIteratorExp(IteratorExp<EClassifier, EParameter> callExp) {
        doProcess(callExp.getBody(), callExp);
        return null;
    }


    public Object visitLetExp(LetExp<EClassifier, EParameter> letExp) {
        doProcess(letExp.getVariable(), letExp);
        doProcess(letExp.getIn(), letExp);
        return null;
    }


    public Object visitMessageExp(MessageExp<EClassifier, CallOperationAction, SendSignalAction> messageExp) {
        doProcess(messageExp.getTarget(), messageExp);
        return null;
    }


    public Object visitNullLiteralExp(NullLiteralExp<EClassifier> literalExp) {
        return null;
    }


    public Object visitOperationCallExp(OperationCallExp<EClassifier, EOperation> callExp) {
        OCLExpression<EClassifier> source = callExp.getSource();
        if (source != null) {
            doProcess(source, callExp);
        }

        for (OCLExpression<EClassifier> exp : callExp.getArgument()) {
            doProcess(exp, callExp);
        }
        EOperation referredOperation = callExp.getReferredOperation();
        if (referredOperation instanceof Visitable) {
            doProcess((Visitable) referredOperation, callExp);
        }
        return null;
    }


    public Object visitPropertyCallExp(PropertyCallExp<EClassifier, EStructuralFeature> callExp) {
        return null;
    }


    public Object visitRealLiteralExp(RealLiteralExp<EClassifier> literalExp) {
        return null;
    }


    public Object visitStateExp(StateExp<EClassifier, EObject> stateExp) {
        return null;
    }


    public Object visitStringLiteralExp(StringLiteralExp<EClassifier> literalExp) {
        return null;
    }


    public Object visitTupleLiteralExp(TupleLiteralExp<EClassifier, EStructuralFeature> literalExp) {
        return null;
    }


    public Object visitTupleLiteralPart(TupleLiteralPart<EClassifier, EStructuralFeature> part) {
        return null;
    }


    public Object visitTypeExp(TypeExp<EClassifier> typeExp) {
        return null;
    }


    public Object visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp<EClassifier> literalExp) {
        return null;
    }


    public Object visitUnspecifiedValueExp(UnspecifiedValueExp<EClassifier> unspecExp) {
        return null;
    }


    public Object visitVariable(Variable<EClassifier, EParameter> variable) {
        return null;
    }
    

    public Object visitVariableExp(VariableExp<EClassifier, EParameter> variableExp) {
        Variable<EClassifier, EParameter> referredVariable = variableExp.getReferredVariable();
        if (referredVariable instanceof Visitable) {
            doProcess((Visitable) referredVariable, variableExp);
        }
        return null;
    }

    public Object visitResolveExp(ResolveExp resolveExp) {
        if (resolveExp.getSource() != null) {
            doProcess(resolveExp.getSource(), resolveExp);
        }
        if (resolveExp.getCondition() != null) {
            doProcess(resolveExp.getCondition(), resolveExp);
        }
        return null;
    }

    public Object visitResolveInExp(ResolveInExp resolveInExp) {
        for (MappingOperation mappingOperation : resolveInExp.getInMappings()) {
            doProcess(mappingOperation, resolveInExp);
        }
        return visitResolveExp(resolveInExp);
    }

	public Object visitModelType(ModelType modelType) {
        for (OCLExpression<EClassifier> exp : modelType.getAdditionalCondition()) {
            doProcess(exp, modelType);
        }
		return null;
	}
    
    private void doProcess(Visitable e, Visitable parent) {
        if(e != null && !myProcessed.contains(e)) {
            myNodeProcessor.process(e, parent);
            myProcessed.add(e);
            e.accept(this);
        }
    }

    private final NodeProcessor myNodeProcessor;
    private final Set<Visitable> myProcessed;

}