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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalAstWalker;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.internal.parser.ValidationVisitor;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.Visitable;
import org.eclipse.ocl.utilities.Visitor;

/**
 * @author sboyko
 *
 */
public class QvtOperationalValidationVisitor extends QvtOperationalAstWalker {
	
	public QvtOperationalValidationVisitor(final QvtOperationalEnv environment) {
		super(new NodeProcessor() {
			public void process(Visitable e, Visitable parent) throws StopException {
				try {
					Visitor<Boolean, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
							EObject, CallOperationAction, SendSignalAction, Constraint>  oclValidationVisitor = myOclValidationVisitor;
					if (e instanceof ASTNode) {
						EcoreEnvironment resolveEnvironment = ASTBindingHelper.resolveEnvironment((ASTNode) e);
						if (resolveEnvironment != null) {
							oclValidationVisitor = myOclValidators.get(resolveEnvironment);
							if (oclValidationVisitor == null) {
								oclValidationVisitor = ValidationVisitor.getInstance(resolveEnvironment);
								myOclValidators.put(resolveEnvironment, oclValidationVisitor);
							}
						}
					}
					e.accept(oclValidationVisitor);
				}
				catch (IllegalArgumentException ex) {
					int startPos = e instanceof ASTNode ? ((ASTNode) e).getStartPosition() : -1;
					int endPos = e instanceof ASTNode ? ((ASTNode) e).getEndPosition() : -1;
					
					if (startPos != -1 && endPos != -1) {
						environment.reportError(ex.getMessage(), startPos, endPos);
					}
				}
				catch (Throwable ex) {
				}
			}
			
			private final Visitor<Boolean, EClassifier, EOperation, EStructuralFeature, EEnumLiteral,
					EParameter, EObject, CallOperationAction, SendSignalAction, Constraint>  myOclValidationVisitor 
							= ValidationVisitor.getInstance(environment);
			private final Map<EcoreEnvironment, Visitor<Boolean, EClassifier, EOperation, EStructuralFeature,
					EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint>> myOclValidators 
							= new HashMap<EcoreEnvironment,
									Visitor<Boolean, EClassifier, EOperation, EStructuralFeature, EEnumLiteral,
									EParameter, EObject, CallOperationAction, SendSignalAction, Constraint>>();
		});
		
	}
	
}
