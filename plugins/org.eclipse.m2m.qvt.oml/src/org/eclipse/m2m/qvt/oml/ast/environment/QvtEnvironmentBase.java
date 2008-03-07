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
package org.eclipse.m2m.qvt.oml.ast.environment;

import static org.eclipse.ocl.utilities.UMLReflection.SAME_TYPE;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;


abstract class QvtEnvironmentBase extends EcoreEnvironment {

	public static class CollisionStatus {
		public static final int ALREADY_DEFINED = 1;		
		public static final int VIRTUAL_METHOD_RETURNTYPE = 2;
		
		private int fKind;
		private EOperation fOperation;		
		
		CollisionStatus(EOperation operation, int kind) {
			if(kind != ALREADY_DEFINED && kind != VIRTUAL_METHOD_RETURNTYPE) {
				throw new IllegalArgumentException("illegal collision kind"); //$NON-NLS-1$
			}
			
			fKind = kind;
			fOperation = operation;			
		}
		
		public int getCollisionKind() {
			return fKind;
		}
		
		public EOperation getOperation() {
			return fOperation;
		}
	}	
	
	private List<QvtEnvironmentBase> siblings;
	private QvtTypeResolverImpl typeResolver;
	private Set<EOperation> fOperationsHolder;	

	protected QvtEnvironmentBase(QvtEnvironmentBase parent) {
		super(parent);
	}

	protected QvtEnvironmentBase(EPackage.Registry reg, Resource resource) {
		super(reg, resource);
	}

	protected QvtEnvironmentBase(EPackage.Registry reg) {
		super(reg);
	}
	
	public abstract EClass getModuleContextType();	
	
	@Override
	public Variable<EClassifier, EParameter> lookupImplicitSourceForOperation(String name, List<? extends TypedElement<EClassifier>> args) {
		Variable<EClassifier, EParameter> result = super.lookupImplicitSourceForOperation(name, args);
		if(result == null) {
			for (QvtEnvironmentBase nextSiblingEnv : getSiblings()) {
				result = nextSiblingEnv.lookupImplicitSourceForOperation(name, args);
				if(result != null) {
					break;
				}
			}
		}
		return result;
	}
	
	@Override
	public Variable<EClassifier, EParameter> lookupImplicitSourceForProperty(String name) {
		Variable<EClassifier, EParameter> result = super.lookupImplicitSourceForProperty(name);
		if(result == null) {
			for (QvtEnvironmentBase nextSiblingEnv : getSiblings()) {
				result = nextSiblingEnv.lookupImplicitSourceForProperty(name);
				if(result != null) {
					break;
				}
			}
		}
		return result;
		
	}

	@Override
	public final TypeResolver<EClassifier, EOperation, EStructuralFeature> getTypeResolver() {
		if(typeResolver == null) {
			typeResolver = new QvtTypeResolverImpl(this, super.getTypeResolver());
		}
		return typeResolver;
	}

	public final QvtTypeResolverImpl getQVTTypeResolver() {
		return (QvtTypeResolverImpl)getTypeResolver();
	} 
	
	public final void addSibling(QvtEnvironmentBase env) {
		if(env == null || env == this || isOneOfParents(env)) {
			throw new IllegalArgumentException("Illegal sibling environemnt"); //$NON-NLS-1$
		}

		if(siblings == null) {
			siblings = new LinkedList<QvtEnvironmentBase>();
		}
		
		assert !siblings.contains(env);
		
		siblings.add(env);
	}
	
	public final List<QvtEnvironmentBase> getSiblings() {
		if(siblings == null) {
			return Collections.emptyList();
		}
		
		return Collections.unmodifiableList(siblings);
	}

	protected final CollisionStatus findCollidingOperation(EClassifier ownerType, EOperation operation) {
		try {
			return doFindCollidingOperation(ownerType, operation);
		} finally {
			if(fOperationsHolder != null) {
				fOperationsHolder.clear();
			}
		}
	}
	
	private CollisionStatus doFindCollidingOperation(EClassifier ownerType, EOperation operation) {
        String operationName = getUMLReflection().getName(operation);
        List<EOperation> ownedOperations = TypeUtil.getOperations(this, ownerType);        
        
        Set<EOperation> operations = operationHolder(); 
        operations.addAll(ownedOperations);
        
        if(ownerType instanceof Module) {
        	// collect all imported (extended) modules fOperationsHolder to check for clashes with this env's module
        	collectImportedModuleOwnedOperations(operations);
        } else {
        
        // collect fOperationsHolder additional fOperationsHolder defined for sub-types of the checked owner type,
        // Note: those from super-types are included by MDT OCL TypeUtil.getOperations(...);
        // => union forms the whole scope for potentially virtually called fOperationsHolder;
        // all fOperationsHolder ever defined goes through this check, so all applicable get into VTABLEs
	        getQVTTypeResolver().collectAdditionalOperationsInTypeHierarchy(ownerType, true, operations);
	    }
        
		for (EOperation next : operations) {
			if ((next != operation) && 
					(getUMLReflection().getName(next).equals(operationName) && matchParameters(next, operation))) {
				
				EClassifier nextOwner = getUMLReflection().getOwningClassifier(next);
				if(nextOwner != null) {
					int rel = TypeUtil.getRelationship(this, ownerType, nextOwner); 
					if((rel != UMLReflection.SAME_TYPE) && (UMLReflection.RELATED_TYPE | rel) != 0) {
						EClassifier ret1 = next.getEType(); 
						EClassifier ret2 = operation.getEType();
						if(ret1 != null && ret2 != null && TypeUtil.getRelationship(this, ret1, ret2) != SAME_TYPE) {
							if(QvtOperationalEnv.MAIN.equals(operationName)) {
								// clashes with main(..) are handled separately
								return null;
							}
							return new CollisionStatus(next, CollisionStatus.VIRTUAL_METHOD_RETURNTYPE);
						}

						// assemble virtual table info
						if(QvtOperationalUtil.isImperativeOperation(operation) && QvtOperationalUtil.isImperativeOperation(next)) {
							VirtualTable sourceOperVtable = getVirtualTable(operation);
							sourceOperVtable.addOperation(next);
							VirtualTable targetOperVtable = getVirtualTable(next);
							targetOperVtable.addOperation(operation);
						}
						///

						continue;
					}

					if(ownerType == nextOwner) {
						return new CollisionStatus(next, CollisionStatus.ALREADY_DEFINED);
					}
				}
			}
		}
				
		return null;
	}

	private VirtualTable getVirtualTable(EOperation operation) {
		return VirtualTableAdapter.getAdapter(operation, true).getVirtualTable();
	}
	
	/**
	 * Performs name ignoring match on given parameters.
	 */
	private boolean matchParameters(EOperation a, EOperation b) {
		List<EParameter> aparms = getUMLReflection().getParameters(a);
		List<EParameter> bparms = getUMLReflection().getParameters(b);
		
		if (aparms.size() == bparms.size()) {
			int count = aparms.size();
			
			for (int i = 0; i < count; i++) {
				EParameter aparm = aparms.get(i);
				EParameter bparm = bparms.get(i);
				
				if (TypeUtil.getRelationship(
								this,
								getUMLReflection().getOCLType(aparm),
								getUMLReflection().getOCLType(bparm))
							!= UMLReflection.SAME_TYPE) {
					
					return false;
				}
			}
			
			return true;
		}
		
		return false;
	}	
	
	
	private boolean isOneOfParents(EcoreEnvironment env) {
		for (EcoreEnvironment parent = (EcoreEnvironment)env.getInternalParent(); parent != null; 
			parent = (EcoreEnvironment)parent.getInternalParent()) {
			if(parent == env) {
				return true;
			}
		}
		return false;
	}
	
	private Collection<EOperation> collectImportedModuleOwnedOperations(Collection<EOperation> result) {
		for (QvtEnvironmentBase nextEnv : getSiblings()) {
			List<EOperation> nextModuleOpers = nextEnv.getModuleContextType().getEOperations();
			if(nextModuleOpers != null) {
				result.addAll(nextModuleOpers);
			}
		}
		
		return result;
	}	
	
	private Set<EOperation> operationHolder() {
		if(fOperationsHolder == null) {
			fOperationsHolder  = new LinkedHashSet<EOperation>();
		}
		return fOperationsHolder;
	}
}
