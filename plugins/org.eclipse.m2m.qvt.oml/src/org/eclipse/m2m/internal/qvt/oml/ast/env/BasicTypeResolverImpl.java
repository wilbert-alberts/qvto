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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.Typedef;
import org.eclipse.ocl.AbstractTypeResolver;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.internal.TupleFactory;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.util.TypeUtil;


/**
 * Type resolver defining non-imperative operations in QVT style 
 */
class BasicTypeResolverImpl
	extends AbstractTypeResolver<EPackage, EClassifier, EOperation, EStructuralFeature, EParameter> {

	BasicTypeResolverImpl(EcoreEnvironment env) {
		super(env);
	}
	
	BasicTypeResolverImpl(EcoreEnvironment env, Resource resource) {
		super(env, resource);
	}
    
    @Override
	protected Resource createResource() {
		return new XMIResourceImpl(URI.createURI("ocl:///qvto.env.ecore")); //$NON-NLS-1$
	}
    
    @Override
    protected EPackage createTuplePackage() {
        EPackage result = super.createTuplePackage();  
        // FIXME - raise MDT OCL bug for access to tuple factory
        result.setEFactoryInstance(new TupleFactory());        
        return result;
    }
    
    @Override
    protected EPackage createPackage(String name) {
        EPackage result = EcoreFactory.eINSTANCE.createEPackage();
        
        result.setName(name);
        getResource().getContents().add(result);
        
        return result;
    }
    
    @Override
	protected EPackage findPackage(String name) {
		EPackage result = null;
		
		for (EObject o : getResource().getContents()) {
			if (o instanceof EPackage) {
				EPackage epkg = (EPackage) o;				
				if (name.equals(epkg.getName())) {
					if(epkg instanceof Module) {
						// go on looking up, as this was 
						continue;
					}
										
					result = epkg;
					break;
				}
			}
		}
		
		return result;
	}
    
    @Override
    protected void addClassifier(EPackage pkg, EClassifier classifier) {
        pkg.getEClassifiers().add(classifier);
    }
    
    @Override
    protected void addOperation(EClassifier owner, EOperation operation) {
        ((EClass) owner).getEOperations().add(operation);
    }
    
    @Override
    protected void addProperty(EClassifier owner, EStructuralFeature property) {
        ((EClass) owner).getEStructuralFeatures().add(property);
    }
	
    @Override
	protected EClass createShadowClass(EClassifier type) {
		Typedef typeDef = ExpressionsFactory.eINSTANCE.createTypedef();
		typeDef.setName(type.getName());
		typeDef.setBase(type);
		return typeDef;
	}
    
    @Override
    protected EClassifier getShadowedClassifier(EClassifier shadow) {
        if (shadow instanceof Typedef) {
        	Typedef typedef = (Typedef) shadow;        	
            return typedef.getBase(); 
        }
        
        return null;
	}
    
	protected EClassifier findShadowClass(EClassifier type) {
        EPackage pkg = hasAdditionalFeatures()? getAdditionalFeaturesPackage() : null;
        
        if (pkg != null) {
    		for (EClassifier next : getEnvironment().getUMLReflection().getClassifiers(pkg)) {
    			EClassifier shadowedClassifier = getShadowedClassifier(next);
				if (shadowedClassifier == type) {
    				return next;
    			}
    			
    			if(type instanceof TupleType) {
    				if(TypeUtil.exactTypeMatch(getEnvironment(), type, shadowedClassifier)) {
    					return next;
    				}
    			}
    		}
        }
        
		return null;
	}    
}
