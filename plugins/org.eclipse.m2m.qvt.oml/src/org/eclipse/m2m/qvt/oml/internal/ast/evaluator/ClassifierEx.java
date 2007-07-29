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
package org.eclipse.m2m.qvt.oml.internal.ast.evaluator;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.QvtOperationalParserUtil;


class ClassifierEx {

	public ClassifierEx(QvtOperationalEnv env, EClassifier classifier) {
    	myEnv = env;
        myClassifier = classifier;
    }
    
    public EClassifier cls() {
        return myClassifier;
    }
    
    @Override
	public boolean equals(Object o) {
        if(o instanceof ClassifierEx == false) {
            return false;
        }
        
        ClassifierEx other = (ClassifierEx)o;
        return QvtOperationalParserUtil.isTypeEquals(myEnv, myClassifier, other.myClassifier);
    }
    
    @Override
	public int hashCode() {
        int hash = 17;
        if(myClassifier.getName() != null) {
            hash = hash*37 + myClassifier.getName().hashCode();
        }
        
        return hash;
    }
    
    @Override
	public String toString() {
        return String.valueOf(myClassifier);
    }
    
    private final QvtOperationalEnv myEnv;
    private final EClassifier myClassifier;
    
}
