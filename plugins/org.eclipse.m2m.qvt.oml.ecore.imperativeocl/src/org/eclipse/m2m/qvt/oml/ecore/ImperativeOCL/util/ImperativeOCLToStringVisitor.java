/**
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 * 
 * $Id: ImperativeOCLToStringVisitor.java,v 1.1 2009/01/25 23:10:43 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.util;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AltExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssertExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.BlockExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.BreakExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.CatchExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ComputeExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ContinueExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictLiteralExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictLiteralPart;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ForExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeExpression;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeIterateExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.InstantiationExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.LogExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.OrderedTupleLiteralExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.OrderedTupleLiteralPart;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.RaiseExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ReturnExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.SwitchExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.TryExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.UnlinkExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.UnpackExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.VariableInitExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.WhileExp;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.util.ToStringVisitor;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.qvt.declarative.ecore.utils.ClassUtils;

/**
 * Implementation of {@link ImperativeOCLVisitor} to have the String representation of a {@link ImperativeExpression ImperativeOCL expression} 
 *  
 * @author Adolfo Sánchez-Barbudo Herrera (adolfosbh)
 *
 */
public class ImperativeOCLToStringVisitor extends  ToStringVisitor<EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint>
				implements ImperativeOCLVisitor<String>{

	
	public static ImperativeOCLToStringVisitor getInstance(TypedElement<EClassifier> element) {
		Environment<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, ?, ?> env = ClassUtils.asClassUnchecked(Environment.Registry.INSTANCE.getEnvironmentFor(element));
		return new ImperativeOCLToStringVisitor(env);
	}
	protected ImperativeOCLToStringVisitor(
			Environment<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, ?, ?> env) {
		super(env);		
	}
	public String visitAltExp(AltExp astNode) {		
		return "<not-implemented-in-string-visitor>";
	}
	public String visitAssertExp(AssertExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitAssignExp(AssignExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitBlockExp(BlockExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitBreakExp(BreakExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitCatchtExp(CatchExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitComputeExp(ComputeExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitContinueExp(ContinueExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitDictLiteralExp(DictLiteralExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitDictLiteralPart(DictLiteralPart astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitForExp(ForExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitImperativeIterateExp(DictLiteralExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitInstantiationExp(InstantiationExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitLogExp(LogExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitOrderedTupleLiteralExp(OrderedTupleLiteralExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitOrderedTupleLiteralPart(OrderedTupleLiteralPart astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitRaiseExp(RaiseExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitReturnExp(ReturnExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitSwitchExp(SwitchExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitTryExp(LogExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitUnlinkExp(UnlinkExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitUnpackExp(LogExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitVariableInitExp(LogExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitImperativeIterateExp(ImperativeIterateExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitTryExp(TryExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitUnpackExp(UnpackExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitVariableInitExp(VariableInitExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	public String visitWhileExp(WhileExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
}
