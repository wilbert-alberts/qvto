/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.ast.parser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalFileEnv;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.internal.qvt.oml.common.resourcesetprovider.ResourceSetProviderRegistry;
import org.eclipse.m2m.internal.qvt.oml.common.resourcesetprovider.ResourceSetProviderRegistry.ResourceSetResourceSetProviderPair;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelDesc;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.ocl.Environment.Internal;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;

/**
 * FIXME - this class extracts the logic of resolving workspace located metamodels, 
 * formerly injected into QVT Environments implementation.
 * A temporary workaround, to be revisited.
 */
class MetamodelResolutionHelper {

	/**
	 * Registers metamodel for use with this environment.
	 * 
	 * @return the metamodel package denoted by the given <code>URI</code> or
	 *         <code>null</code> if no package was resolved
	 */
	static List<EPackage> registerMetamodel(QvtOperationalEnv qvtEnv, 
			String metamodelUri, List<String> path, ResourceSet resolutionRS, 
			MetamodelRegistry metamodelRegistry, QvtCompilerOptions options) {
        List<EPackage> metamodels = new ArrayList<EPackage>(1);
		try {
		    IMetamodelDesc[] desc = null;
		    Internal<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env = qvtEnv;
		    while (env != null && metamodelUri != null) {
		        if (env instanceof QvtOperationalFileEnv) {
		            QvtOperationalFileEnv fileEnv = (QvtOperationalFileEnv) env;
		            ResourceSet resourceSet = fileEnv.getKernel().getMetamodelResourceSet();
		            ResourceSetResourceSetProviderPair pair = null;
		            if (resourceSet == null) {
	                    URI uri = fileEnv.getFile();
	                    // FIXME - refactore CFile out of here
						IFile iFileURI = URIUtils.getFile(uri);
						if(iFileURI != null) {
							CFile cFile = new EclipseFile(iFileURI);
		                    pair = ResourceSetProviderRegistry.getResourceSetResourceSetProviderPair(cFile);
		                    if (pair != null) {
		                        ResourceSet providedResourceSet = pair.getResourceSet();
		                        URI mmURI = URI.createURI(metamodelUri);
	                            if (EmfUtil.isUriMapped(providedResourceSet, mmURI)) {
	                                resourceSet = providedResourceSet;
		                        }
		                    }
						}
		            }
		            if (resourceSet != null) {
		                IMetamodelDesc metamodelDesc = MetamodelRegistry.createUndeclaredMetamodel(metamodelUri, resourceSet);
		                if (metamodelDesc != null) {
	                        desc = new IMetamodelDesc[] { metamodelDesc };
		                }
		                if (pair != null) {
		                    pair.getResourceSetProvider().dispose(resourceSet);
		                }
		            }
                    break;
		        }
                env = env.getInternalParent();
		    }
		    
		    if (desc == null) {
	            MetamodelRegistry registry = metamodelRegistry;
	            
	            if (path.isEmpty()) {
	                desc = new IMetamodelDesc[] { registry.getMetamodelDesc(metamodelUri, 
	                		options != null && options.getMetamodelResourceSet() != null ? options.getMetamodelResourceSet() : resolutionRS) };
	            }
	            else {
	                desc = registry.getMetamodelDesc(path);
	            }
		    }

			for(IMetamodelDesc nextDesc : desc) {
				if(nextDesc.getModel() == null) {
					continue;
				}
				
	        	EPackage model = nextDesc.getModel();
	            // register metamodel for EClassifier lookup
	        	if (model.getNsURI() == null) {
					while (true) {
						if (model.getESuperPackage() == null) {
							break;
						}
						model = model.getESuperPackage();
					}
	        	}
	        	
	        	if(nextDesc.getLoadStatus().getSeverity() < IStatus.ERROR) {
	        		metamodels.add(model);	        	
	        		qvtEnv.getEPackageRegistry().put(model.getNsURI(), model);
	        	}
	            break;
/*
	            EPackage[] all = EmfMmUtil.getRegisterableModels(model, true);            
	            for (EPackage pack : all) {
//		            getEPackageRegistry().put(pack.getNsURI(), pack);
	            }
*/
	        }			
		} catch (EmfException e) {
			// It's legal situation of unresolved metamodels
		}
		return metamodels;
	}	
}
