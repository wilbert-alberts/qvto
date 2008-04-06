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
import org.eclipse.ocl.ecore.internal.EcoreForeignMethods;

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
		if (path.isEmpty()) {
			return null;
		}
		if (!EcoreForeignMethods.isNamed(path.get(0), rootPackage)) {
			return null;
		}
        
		EPackage pkg = rootPackage;
		for (int i = 1, n = path.size(); i < n; ++i) {
			pkg = EcoreForeignMethods.getESubpackage(pkg, path.get(i));
			if (pkg == null) {
				break;
			}
		}
		return pkg;
	}	
	
}
