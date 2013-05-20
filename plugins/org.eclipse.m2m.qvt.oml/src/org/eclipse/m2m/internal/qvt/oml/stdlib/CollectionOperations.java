/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.stdlib;

import java.util.Collection;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QVTOEnvironment;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance;


public class CollectionOperations extends AbstractContextualOperations {

	public static final String AS_LIST_NAME = "asList"; //$NON-NLS-1$
	
	private static final CallHandler AS_LIST = new CallHandler() {
		
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			if(source instanceof Collection<?>) {
				if(source instanceof Collection<?>) {
					@SuppressWarnings("unchecked")					
					Collection<Object> collection = (Collection<Object>) source;
					return new MutableListImpl<Object>(collection);
				}
				return CallHandlerAdapter.getInvalidResult(evalEnv);
			}
			
			return String.valueOf(source);
		}
	};	
			
	private CollectionOperations(AbstractQVTStdlib library, EClassifier targetType) {
		super(library, targetType);		
	}

	public static AbstractContextualOperations[] getAllOperations(AbstractQVTStdlib library) {
		QVTOEnvironment environment = library.getEnvironment();
		return new AbstractContextualOperations[] {
			new CollectionOperations(library, environment.getOCLStandardLibrary().getBag()),
			new CollectionOperations(library, environment.getOCLStandardLibrary().getSequence()),
			new CollectionOperations(library, environment.getOCLStandardLibrary().getSet()),
			// Note: skip this as OrderSet is taken as Set sub-type, is asList() operation is 
			// intherited. 
			// Watch the http://www.omg.org/issues/issue12947.txt
			//new CollectionOperations(library, environment.getOCLStandardLibrary().getOrderedSet())			
		};		
	}	
	
	@Override
	protected OperationProvider[] getOperations() {
		return new OperationProvider[] {
			new OperationProvider(AS_LIST, AS_LIST_NAME, getStdlib().getList())
		};
	}
}
