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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalAstWalker;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.parser.ValidationVisitor;
import org.eclipse.ocl.utilities.Visitable;
import org.eclipse.ocl.utilities.Visitor;

/**
 * 
 * @author sboyko
 * 
 * Ill-based validation visitor for OCL expressions only. 
 * Presented till 'https://bugs.eclipse.org/bugs/show_bug.cgi?id=215544'
 * is not resolved.
 *
 */
public class QvtOperationalValidationVisitor extends QvtOperationalAstWalker {

	public QvtOperationalValidationVisitor(QvtOperationalEnv environment) {
		super (new ValidationNodeProcessor(environment));
	}
	
	private static class ValidationNodeProcessor implements NodeProcessor {
		
		ValidationNodeProcessor(QvtOperationalEnv environment) {
			myOclValidationVisitor = ValidationVisitor.getInstance(environment);
		}

		public void process(Visitable e, Visitable parent) throws StopException {
			try {
				e.accept(myOclValidationVisitor);
			}
			catch (Throwable throwable) {
			}
		}
		
		final Visitor<Boolean, EClassifier, EOperation, EStructuralFeature, EEnumLiteral,
			EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> myOclValidationVisitor;
		
	}

}
