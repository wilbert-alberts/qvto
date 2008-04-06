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
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFolder;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.BundleFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.BundleModuleRegistry;
import org.eclipse.m2m.internal.qvt.oml.common.project.IRegistryConstants;
import org.eclipse.m2m.internal.qvt.oml.common.project.TransformationRegistry;
import org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolver;

public class DeployedImportResolver implements IImportResolver {
	
	private static List<BundleModuleRegistry> bundleModules;

	public DeployedImportResolver() {
	}
	
	public String getPackageName(CFolder folder) {
		if(folder == null) {
			return ""; //$NON-NLS-1$
		}
		return folder.getFullPath().replace('\\', '/').replace('/', '.');
	}
	
	public CFile resolveImport(String importedUnitName) {
		if(importedUnitName == null || importedUnitName.length() == 0) {
			return null;
		}
		
		if(bundleModules == null) {
			bundleModules = createModulesRegistry();
		}
		
		IPath fullPath = new Path(importedUnitName.replace('.', '/') + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT);
		
		for (BundleModuleRegistry nextRegistry : bundleModules) {
			if (importedUnitName.indexOf(nextRegistry.getBundleSymbolicName()) == 1) {
				fullPath = new Path(importedUnitName.substring(nextRegistry.getBundleSymbolicName().length()+2));
			}
			else if (importedUnitName.startsWith("/")) { //$NON-NLS-1$
				fullPath = new Path(importedUnitName.substring(1).replace('.', '/') + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT);
			}
			if (nextRegistry.fileExists(fullPath)) {
				return new BundleFile(fullPath, nextRegistry);
			}
		}

		return resolveResourcePluginPath(importedUnitName);
	}

	private CFile resolveResourcePluginPath(String importedUnitName) {
		try {
			URI uri = URI.createURI(importedUnitName);
			String[] segments = uri.segments();
			if (segments.length > 0 
					&& Platform.getBundle(segments[0]) != null 
					&& MDAConstants.QVTO_FILE_EXTENSION.equals(uri.fileExtension())) {
				URI pathUri = URI.createURI(""); //$NON-NLS-1$
				for (int i = 1; i < segments.length; ++i) {
					pathUri = pathUri.appendSegment(segments[i]);
				}
				IPath ipath = new Path(pathUri.toFileString());
				BundleModuleRegistry newBundle = new BundleModuleRegistry(segments[0], Collections.singletonList(ipath));
				bundleModules.add(newBundle);
				return new BundleFile(ipath, newBundle);
			}
		}
		catch (Exception e) {
		}
		return null;
	}

	private static List<BundleModuleRegistry> createModulesRegistry() {
		// collect transformation plugins
	    final Map<String, List<IPath>> allQvtFilesMap = new HashMap<String, List<IPath>>();
	    
	    QvtTransformationRegistry.getInstance().getTransformations(
	    	new TransformationRegistry.Filter() {
	    		public boolean accept(IConfigurationElement element) {
	    			String namespaceID = element.getNamespaceIdentifier();
	    			List<IPath> filesValue = allQvtFilesMap.get(namespaceID);
	    			if(filesValue == null) {
	    				filesValue = new ArrayList<IPath>();
	    				allQvtFilesMap.put(namespaceID, filesValue);
	    			}
	    			String qvtFilePath = element.getAttribute(IRegistryConstants.FILE);
	    			if(qvtFilePath != null) {
	    				filesValue.add(new Path(qvtFilePath));
	    			}
	    			
	    			return false;
	    		}
	    	}
	    );
		
	    List<BundleModuleRegistry> registryEntries = new ArrayList<BundleModuleRegistry>();
	    for (String nextID : allQvtFilesMap.keySet()) {
			List<IPath> qvtFiles = allQvtFilesMap.get(nextID);
			registryEntries.add(new BundleModuleRegistry(nextID, qvtFiles));
		}
	    return registryEntries;
	}
}
