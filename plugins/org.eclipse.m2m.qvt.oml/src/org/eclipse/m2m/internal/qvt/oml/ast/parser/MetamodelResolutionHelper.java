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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelDesc;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;

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
		    IMetamodelDesc[] desc;
            MetamodelRegistry registry = metamodelRegistry;
            
            if (path.isEmpty()) {
                desc = new IMetamodelDesc[] { registry.getMetamodelDesc(metamodelUri) };
            }
            else {
                desc = registry.getMetamodelDesc(path);
            }
                        
            if(desc != null) {
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
		        }
            }
		} catch (EmfException e) {
			// It's legal situation of unresolved metamodels
		}
		return metamodels;
	}	
}
