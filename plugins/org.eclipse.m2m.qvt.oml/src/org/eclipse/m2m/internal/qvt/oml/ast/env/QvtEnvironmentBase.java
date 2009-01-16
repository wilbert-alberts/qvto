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

import static org.eclipse.ocl.utilities.UMLReflection.SAME_TYPE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOCLPackage;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.internal.qvt.oml.stdlib.QVTUMLReflection;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;


abstract class QvtEnvironmentBase extends EcoreEnvironment implements QVTOEnvironment {
	
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
	
    private static final String TEMPORARY_NAME_GENERATOR_UNIQUE_PREFIX = "@@@temp_"; //$NON-NLS-1$
    private int myTemporaryNameGeneratorInt = 0;
    /*
     * List of declared variables and implicit variables, including "self".
     * Implicit variables are generated when there is an iterator without any
     * iteration variable specified.
     */
    private List<org.eclipse.ocl.ecore.Variable> myImplicitVars = new LinkedList<org.eclipse.ocl.ecore.Variable>();

    private QVTUMLReflection fQVUMLReflection;
	private List<QvtEnvironmentBase> siblings;
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
	
	public abstract Module getModuleContextType();	
	
	public void addImplicitVariableForProperties(String name, Variable<EClassifier, EParameter> elem) {
        getUMLReflection().setName(elem, name);
	    addedVariable(name, elem, false);
	}
	
    @Override
    protected void addedVariable(String name, Variable<EClassifier, EParameter> elem, boolean isExplicit) {
    	org.eclipse.ocl.ecore.Variable elemVar = (org.eclipse.ocl.ecore.Variable) elem;    	
        if(!isExplicit) {
            myImplicitVars.add(elemVar);
        }
        
        if(elemVar instanceof VarParameter == false) {
            if(getContextOperation() instanceof ImperativeOperation) {
                ImperativeOperation imperativeOperation = (ImperativeOperation) getContextOperation();
                if(elemVar.eContainer() == null) {
                    if (imperativeOperation.getBody() != null) {
                        imperativeOperation.getBody().getVariable().add((org.eclipse.ocl.ecore.Variable)elemVar);
                    } else {
                        super.addedVariable(name, elemVar, isExplicit);
                    }
                }
            } else {
                super.addedVariable(name, elemVar, isExplicit);
            }
        } 
    }
    
    @Override
    protected void removedVariable(String name, Variable<EClassifier, EParameter> variable, boolean isExplicit) {
        if(!isExplicit) {
            myImplicitVars.remove(variable);
        }

        super.removedVariable(name, variable, isExplicit);
    }
    
    public Collection<org.eclipse.ocl.ecore.Variable> getImplicitVariables() {
        return Collections.unmodifiableCollection(myImplicitVars);
    }

	@Override
	public Variable<EClassifier, EParameter> lookupImplicitSourceForOperation(String name, List<? extends TypedElement<EClassifier>> args) {
		Variable<EClassifier, EParameter> result = super.lookupImplicitSourceForOperation(name, args);
		
		if(result == null) {
			QvtEnvironmentBase rootEnv = getRootEnv();
			if(rootEnv != this) {
				return this.getInternalParent().lookupImplicitSourceForOperation(name, args);
			}
			
			for (QvtEnvironmentBase nextSiblingEnv : rootEnv.getSiblings()) {
				result = nextSiblingEnv.lookupImplicitSourceForOperation(name, args);
				if(result != null) {
					break;
				}
			}
		}
		return result;
	}
	
    // implements the interface method
    public Variable<EClassifier, EParameter> lookupImplicitSourceForPropertyInternal(String name) {
        Variable<EClassifier, EParameter> vdcl;
        
        for (int i = myImplicitVars.size() - 1; i >= 0; i--) {
            vdcl = myImplicitVars.get(i);
            EClassifier owner = vdcl.getType();
            
            if (owner != null) {
                EStructuralFeature property = safeTryLookupPropertyInternal(owner, name);
                if (property != null) {
                    return vdcl;
                }
            }

        }
        
        // try the "self" variable, last
        vdcl = getSelfVariable();
        if (vdcl != null) {
            EClassifier owner = vdcl.getType();
            if (owner != null) {
                EStructuralFeature property = safeTryLookupPropertyInternal(owner, name);
                if (property != null) {
                    return vdcl;
                }
            }
        }
        
        return null;

    }
    
    /**
     * Wrapper for the "try" operation that doesn't throw, but just returns the
     * first ambiguous match in case of ambiguity.
     */
    private EStructuralFeature safeTryLookupPropertyInternal(EClassifier owner, String name) {
        EStructuralFeature result = null;
        
        try {
            result = tryLookupProperty(owner, name);
        } catch (LookupException e) {
            if (!e.getAmbiguousMatches().isEmpty()) {
                result = (EStructuralFeature) e.getAmbiguousMatches().get(0);
            }
        }
        
        return result;
    }
    
	@Override
	public Variable<EClassifier, EParameter> lookupImplicitSourceForProperty(String name) {
		Variable<EClassifier, EParameter> result = lookupImplicitSourceForPropertyInternal(name);
		if(result == null) {
			QvtEnvironmentBase rootEnv = getRootEnv();
			if(rootEnv != this) {
				return this.getInternalParent().lookupImplicitSourceForProperty(name);
			}
			
			for (QvtEnvironmentBase nextSiblingEnv : rootEnv.getSiblings()) {
				result = nextSiblingEnv.lookupImplicitSourceForProperty(name);
				if(result != null) {
					break;
				}
			}
		}
		return result;
		
	}

	// FIXME - refactore this out
	final QvtTypeResolverImpl getQVTTypeResolver() {
		return (QvtTypeResolverImpl)getTypeResolver();
	}
	
	@Override
	public QVTOTypeResolver getTypeResolver() {
		return (QVTOTypeResolver)super.getTypeResolver();
	}
	
	public QvtOperationalStdLibrary getQVTStandardLibrary() {
		return QvtOperationalStdLibrary.INSTANCE;
	}
		
	@Override
	public List<EOperation> getAdditionalOperations(EClassifier classifier) {
		if(classifier instanceof org.eclipse.ocl.ecore.CollectionType) {
			org.eclipse.ocl.ecore.CollectionType collectionType = (org.eclipse.ocl.ecore.CollectionType) classifier;			
			List<EOperation> result = new ArrayList<EOperation>();
			getLocalAdditionalCollectionOperations(collectionType, result);
			
			// look for imported collection operations
			for (QvtEnvironmentBase nextImportedEnv : getSiblings()) {
				nextImportedEnv.getLocalAdditionalCollectionOperations(collectionType, result);
			}
			
			return result;
		}
		
		return super.getAdditionalOperations(classifier);
	}
	
	private void getLocalAdditionalCollectionOperations(org.eclipse.ocl.ecore.CollectionType collectionType, List<EOperation> result) {
		OCLStandardLibrary<EClassifier> oclstdlib = getOCLStandardLibrary();
		
		EcorePackage typePackage = EcorePackage.eINSTANCE;

		EClass metaType = collectionType.eClass();
		EClassifier genericBaseType = null;
		
		if(metaType == typePackage.getCollectionType() && collectionType != oclstdlib.getCollection()) {
			genericBaseType = oclstdlib.getCollection();
		} else if(metaType == typePackage.getBagType() && collectionType != oclstdlib.getBag()) {
			genericBaseType = oclstdlib.getBag();
		} else if(metaType == typePackage.getSequenceType() && collectionType != oclstdlib.getSequence()) {
			genericBaseType = oclstdlib.getSequence();
		} else if(metaType == typePackage.getSetType() && collectionType != oclstdlib.getSet()) {
			genericBaseType = oclstdlib.getSet();
		} else if(metaType == typePackage.getOrderedSetType() && collectionType != oclstdlib.getOrderedSet()) {
			genericBaseType = oclstdlib.getOrderedSet();
		} else if(metaType == ImperativeOCLPackage.eINSTANCE.getListType() && collectionType != getQVTStandardLibrary().getList()) {
			genericBaseType = getQVTStandardLibrary().getList();
		} else if(metaType == ImperativeOCLPackage.eINSTANCE.getDictionaryType() && collectionType != getQVTStandardLibrary().getDictionary()) {
			genericBaseType = getQVTStandardLibrary().getDictionary();
		}
		
		QvtTypeResolverImpl thisResolver = getQVTTypeResolver();
		if(genericBaseType != null) {
			thisResolver.getLocalCollectionAdditionalOperations((CollectionType)genericBaseType, result, false);
		}

		thisResolver.getLocalCollectionAdditionalOperations(collectionType, result, true);
		
		Collection<EClassifier> allParents = OCLStandardLibraryUtil.getAllSupertypes(this, collectionType);
		for (EClassifier general : allParents) {
			org.eclipse.ocl.ecore.CollectionType generalCollection = (org.eclipse.ocl.ecore.CollectionType) general; 
			thisResolver.getLocalCollectionAdditionalOperations(generalCollection, result, false);
		}
		
		if(metaType == ImperativeOCLPackage.eINSTANCE.getListType()) {
			// process the CollectionType super type
			// TODO - better to have MDT OCL to support #getAllSupertypes(...) operation in TypeChecker
			thisResolver.getLocalCollectionAdditionalOperations((CollectionType)oclstdlib.getCollection(), result, false);			
		}
	}
	
	@Override
	public UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> getUMLReflection() {
		Internal<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent = getInternalParent();
		if(parent != null) {
			return parent.getUMLReflection();
		}
		
		if(fQVUMLReflection == null) {
			fQVUMLReflection = new QVTUMLReflection(super.getUMLReflection());
		}
		
		return fQVUMLReflection;
	}	
	
	public final void addSibling(QvtEnvironmentBase env) {
		QvtEnvironmentBase rootEnv = getRootEnv();
		if(rootEnv != this) {
			// propagate to the top level parent
			rootEnv.addSibling(env);
			return;
		}
		
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
		QvtEnvironmentBase rootEnv = getRootEnv();
		if(rootEnv != this) {
			// propagate request to the top level parent, as being a leaf env, 
			// I'm disallowed to own siblings
			return rootEnv.getSiblings();
		}
		
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
        	// collect all imported (extended) modules fOperationsHolder to check for clashes with this fEnv's module
        	//collectImportedModuleOwnedOperations(operations);
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
	
	/*
	private Collection<EOperation> collectImportedModuleOwnedOperations(Collection<EOperation> result) {
		for (QvtEnvironmentBase nextEnv : getSiblings()) {
			List<EOperation> nextModuleOpers = nextEnv.getModuleContextType().getEOperations();
			if(nextModuleOpers != null) {
				result.addAll(nextModuleOpers);
			}
		}
		
		return result;
	}
	*/
	
	private Set<EOperation> operationHolder() {
		if(fOperationsHolder == null) {
			fOperationsHolder  = new LinkedHashSet<EOperation>();
		}
		return fOperationsHolder;
	}

	protected QvtEnvironmentBase getRootEnv() {
		QvtEnvironmentBase root = this;
		while(root.getInternalParent() instanceof QvtEnvironmentBase) {
			root = (QvtEnvironmentBase) root.getInternalParent();			
		}
		return root;
	}
	
    public String generateTemporaryName() {
        QvtEnvironmentBase rootEnv = getRootEnv();
        String name;
        do {
            name = rootEnv.generateTemporaryNameInternal();
        } while (lookup(name) != null);
        return name;
    }

    
    public boolean isTemporaryElement(String name) {
        return (name != null) && name.startsWith(TEMPORARY_NAME_GENERATOR_UNIQUE_PREFIX);
    }
    
    private String generateTemporaryNameInternal() {
        myTemporaryNameGeneratorInt++;
        return TEMPORARY_NAME_GENERATOR_UNIQUE_PREFIX + myTemporaryNameGeneratorInt;
    }
}
