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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.qvt.oml.expressions.PackageRef;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.GraphWalker.NodeProvider;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.GraphWalker.VertexProcessor;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.QvtOperationalParserUtil;


public class InheritanceTree {
	public static interface IClassifierProvider {
		EClassifier[] getAllClasses(PackageRef packageRef) throws EmfException;
	}
	
    public InheritanceTree(QvtOperationalEnv env, IClassifierProvider provider, PackageRef[] metamodels) {
    	myProvider = provider;
        myMetamodels = metamodels;
        myEnv = env;
        
        myClass2Derived = null;
    }
    
    public boolean hasClass(EClassifier cls) throws EmfException {
        init();
        return myClass2Derived.keySet().contains(new ClassifierEx(myEnv, cls));
    }
    
    public EClassifier[] getSortedDerivedClasses(EClassifier base) throws EmfException {
        init();
        
        final List<EClassifier> result = new ArrayList<EClassifier>();

		VertexProcessor vertexProcessor = new VertexProcessor() {
                public boolean process(Object node) {
                    result.add(((ClassifierEx)node).cls());
                    return false;
		        }
		};
		                
		new GraphWalker(DERIVED_NODE_PROVIDER).walkDepthFirst(new ClassifierEx(myEnv, base), vertexProcessor);

        //System.err.println("base=" + base + "\n    derived=" + assignableClasses + "\n    result=" + result);
        return result.toArray(new EClassifier[result.size()]);
    }
    
    public int getMinimumDistance(EClassifier base, EClassifier derived, int weight) throws EmfException {
        if (QvtOperationalParserUtil.isTypeEquals(myEnv, base, derived)) {
            return 0;
        }

        init();
        
        int distance = new GraphWalker(BASE_NODE_PROVIDER).getMinimumDistance(derived, base, weight);
        if (distance == GraphWalker.MAX_WEIGHT) {
    		throw new RuntimeException("derived " + derived + " not in tree for base " + base); //$NON-NLS-1$ //$NON-NLS-2$
    	}
        
        return distance;
    }
    
    private void init() throws EmfException {
        if (myClass2Derived != null) {
            return;
        }
        
        myClass2Derived = new HashMap<ClassifierEx, Set<ClassifierEx>>();
        for (PackageRef packageRef : myMetamodels) {
            EClassifier[] classes = myProvider.getAllClasses(packageRef);
            for (int j = 0; j < classes.length; j++) {
                EClassifier cls = classes[j];
                myClass2Derived.put(new ClassifierEx(myEnv, cls), new HashSet<ClassifierEx>());
            }
        }
        
        for (ClassifierEx ti: myClass2Derived.keySet()) {
        	if (false == ti.cls() instanceof EClass) {
        		continue;
        	}
        	for (EClass base : ((EClass) ti.cls()).getESuperTypes()) {
                Set<ClassifierEx> derived = myClass2Derived.get(new ClassifierEx(myEnv, base));
                // ignore non-model types
                if (derived != null) {
                	derived.add(ti);
                }
        	}
        }
    }
    
    private final IClassifierProvider myProvider;
    private final PackageRef[] myMetamodels;  
    private final QvtOperationalEnv myEnv;

    private Map<ClassifierEx, Set<ClassifierEx>> myClass2Derived;
    
    private NodeProvider DERIVED_NODE_PROVIDER = new NodeProvider() {
        public Object[] getLinkedNodes(Object node) {
            Set<ClassifierEx> links = myClass2Derived.get(node);
            return links == null ? new Object[0] : links.toArray(); 
        }
    };
    
    private NodeProvider BASE_NODE_PROVIDER = new NodeProvider() {
        public Object[] getLinkedNodes(Object node) {
        	if (false == node instanceof EClass) {
        		return Collections.emptyList().toArray();
        	}
            return ((EClass) node).getESuperTypes().toArray();
        }
    };
    
}
