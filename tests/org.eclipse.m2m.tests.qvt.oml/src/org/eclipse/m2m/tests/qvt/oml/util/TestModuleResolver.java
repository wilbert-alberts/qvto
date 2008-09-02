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
package org.eclipse.m2m.tests.qvt.oml.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFolder;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.BundleFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.BundleModuleRegistry;
import org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolver;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.DeployedImportResolver;
import org.osgi.framework.Bundle;

public class TestModuleResolver implements IImportResolver {
	
	private DeployedImportResolver fResolver;
	private IPath fBasePath;
			
	/**
	 * Creates import resolver for this test plug-in.
	 * 
	 * @param sourceContainerPath
	 *            a path relative to the given bundle
	 * @return the resolver instance
	 */
	public static TestModuleResolver createdTestPluginResolver(String sourceContainerPath) {
		return new TestModuleResolver(TestUtil.BUNDLE, sourceContainerPath);
	}
	
	public TestModuleResolver(String bundleSymbolicName, String sourceContainerPath) {
		if(bundleSymbolicName == null || sourceContainerPath == null) {
			throw new IllegalArgumentException();
		}
		
		Bundle bundle =  Platform.getBundle(bundleSymbolicName);
		if(bundle == null) {
			throw new IllegalArgumentException("Not existinging bundle" + bundleSymbolicName); //$NON-NLS-1$
		}

		@SuppressWarnings("unchecked")
		Enumeration<java.net.URL> qvtFiles = bundle.findEntries(sourceContainerPath, "*" + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT, true); //$NON-NLS-1$
		
		List<IPath> pathList = new ArrayList<IPath>();
		while(qvtFiles.hasMoreElements()) {
			pathList.add(new Path(qvtFiles.nextElement().getPath()));
		}
		
		BundleModuleRegistry registry = new BundleModuleRegistry(bundleSymbolicName, pathList);
		fResolver = new DeployedImportResolver(Arrays.asList(registry)) {
			@Override
			public CFile resolveImport(String importedUnitName) {
				IPath fullPath = fBasePath.append(importedUnitName.replace('.', '/') + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT);
				for (BundleModuleRegistry nextRegistry : getBundleModules()) {
					if (nextRegistry.fileExists(fullPath)) {
						return new BundleFile(fullPath, nextRegistry);
					}
				}
				
				return null;
			}
		};
		fBasePath = new Path(sourceContainerPath).makeAbsolute();
	}
	
	public String getPackageName(CFolder folder) {
		return fResolver.getPackageName(folder);
	}

	public CFile resolveImport(String importedUnitName) {
		return fResolver.resolveImport(importedUnitName);
	}
	
	public CFile resolveImport(CFile parentFile, String importedUnitName) {		
		return fResolver.resolveImport(parentFile, importedUnitName);
	}
}
