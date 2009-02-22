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
package org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.ocl.ecore.EcoreEnvironment;

public class EmfMmUtil {
    private EmfMmUtil() {}

    public static EPackage[] getRegisterableModels(EPackage rootPack, boolean includeDeps) {
        Set<EPackage> allRootPackages = new LinkedHashSet<EPackage>();
        allRootPackages.add(rootPack);
        
        if(includeDeps) {
            allRootPackages.addAll(Arrays.asList(getReferencedPackages(rootPack)));
        }
        
        return (EPackage[])allRootPackages.toArray(new EPackage[allRootPackages.size()]);
    }
    
    public static EPackage[] getReferencedPackages(EPackage rootPack) {
        return DependencyHelper.getReferencedPackages(rootPack);
    }

	public static EPackage lookupPackage(EPackage rootPackage, List<String> path) {
		EPackage.Registry registry = new EPackageRegistryImpl();
		registry.put(rootPackage.getNsURI(), rootPackage);
		
		return EcoreEnvironment.findPackage(path, registry);
	}	
	
}
