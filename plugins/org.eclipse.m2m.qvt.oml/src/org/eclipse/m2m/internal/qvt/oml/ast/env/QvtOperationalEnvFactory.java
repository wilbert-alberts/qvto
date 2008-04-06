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
package org.eclipse.m2m.internal.qvt.oml.ast.env;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerKernel;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitorImpl;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.SendSignalAction;

public class QvtOperationalEnvFactory extends EcoreEnvironmentFactory {

	public QvtOperationalFileEnv createEnvironment(final QvtOperationalEnv parent, final CFile file, final QvtCompilerKernel kernel) {
		QvtOperationalFileEnv env = new QvtOperationalFileEnv(parent, file, kernel);
		env.setFactory(this);
		return env;
	}
	
	public QvtOperationalEnv createEnvironment(final QvtOperationalEnv parent) {
		QvtOperationalEnv env = new QvtOperationalEnv(parent);
		env.setFactory(this);
		return env;
	}
	
	@Override
	public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment(
			EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {

		if(parent instanceof QvtOperationalEvaluationEnv) {
			QvtOperationalEvaluationEnv qvtParentEnv = (QvtOperationalEvaluationEnv) parent;
			return new QvtOperationalEvaluationEnv(qvtParentEnv.getContext(), qvtParentEnv);
		}

		return super.createEvaluationEnvironment(parent);
	}
	
	public QvtOperationalEvaluationEnv createEvaluationEnvironment(IContext context, QvtOperationalEvaluationEnv parent) {
		return new QvtOperationalEvaluationEnv(context, parent);
	}
	
	@Override
	public EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEvaluationVisitor(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
			Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {
		
		if((env instanceof QvtOperationalEnv == false) || (evalEnv instanceof QvtOperationalEvaluationEnv == false)) {
			return super.createEvaluationVisitor(env, evalEnv, extentMap);
		}
		
		return QvtOperationalEvaluationVisitorImpl.createVisitor((QvtOperationalEnv)env, (QvtOperationalEvaluationEnv)evalEnv);
	}
}
