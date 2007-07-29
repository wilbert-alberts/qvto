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
package org.eclipse.m2m.internal.qvt.oml.runtime.project.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2m.internal.qvt.oml.runtime.QvtRuntimePlugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil;
import org.eclipse.m2m.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.DependencyHelper;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.IMetamodelDesc;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.qvt.oml.ocl.metainfo.OclMetainfoMetamodel;

public class QvtConfigurationPropertyTypeFactory {
    
    public static QvtConfigurationPropertyType buildType(String fqn, Collection<OclMetainfoMetamodel> metamodels) {
        String[] names = fqn.split(SEPARATOR);
        if (names.length == 1) {
            return buildPrimitiveType(fqn);
        } else if (names.length > 1) {
            return buildEMFType(fqn, names, metamodels);
        }
        return new ErrorType(fqn);
    }
    
    public static QvtConfigurationPropertyType buildEMFType(String fqn, String[] names, Collection<OclMetainfoMetamodel> metamodels) {
        for (OclMetainfoMetamodel metamodel : metamodels) {
                IMetamodelDesc metamodelDesc;
                try {
                    metamodelDesc = MetamodelRegistry.getInstance().getMetamodelDesc(metamodel.getName());
                } catch (EmfException e) {
                    QvtRuntimePlugin.getDefault().getLog().log(MiscUtil.makeErrorStatus(e));
                    continue;
                }
            
                Object[] models = metamodelDesc.getModels();

                if (models instanceof EPackage[] == false) {
                    return new ErrorType(fqn);
                }
                
                Collection<? extends EPackage> modelList = Arrays.asList((EPackage[])models);
                Queue<EPackage> queue = new LinkedList<EPackage>();
                queue.addAll(modelList);
                // see: #32266 [configProps]:properties of ecore types cannot be used in compiled transformations if ecore metamodel is not imported explicitely  
                // ProjectDependencyHelper filters out EcorePackage for some reason
                queue.add(EcorePackage.eINSTANCE); 
                Set<EPackage> added = new HashSet<EPackage>();
                added.addAll(queue);
                while (!queue.isEmpty()) {
                    EPackage ePackage = queue.poll();
                    try {
                        EClassifier eClassifier = EmfUtil.getEClassifier(ePackage, names);                    
                        if (eClassifier instanceof EDataType) {
                            return new EMFType((EDataType) eClassifier);
                        }
                    } catch (EmfException e) {
                        // Not found, let's look in the rest of metamodels
                    }
                    EPackage[] referencedPackages = DependencyHelper.getReferencedPackages(ePackage);
                    for (int j = 0; j < referencedPackages.length; j++) {
                        if (!added.contains(referencedPackages[j])) {
                            queue.offer(referencedPackages[j]);
                            added.add(referencedPackages[j]);
                        }
                    }
                }
        }
        return new ErrorType(fqn);
    }  

    public static QvtConfigurationPropertyType buildPrimitiveType(String fqn) {
        if ("Integer".equals(fqn)) { //$NON-NLS-1$
            return new PrimitiveType(Integer.class);
        } else if ("Real".equals(fqn)) { //$NON-NLS-1$
            return new PrimitiveType(Double.class);
        } else if ("Boolean".equals(fqn)) { //$NON-NLS-1$
            return new PrimitiveType(Boolean.class);
        } else if ("String".equals(fqn)) { //$NON-NLS-1$
            return new PrimitiveType(String.class);
        } 
        return new ErrorType(fqn);
    }  

    private static final String SEPARATOR = "::"; //$NON-NLS-1$
}
