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
package org.eclipse.m2m.internal.qvt.oml;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolverFactory;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;


/**
 * @author pfeldman
 */
public class QvtEngine {
	public static QvtEngine getInstance(IResource resource) {
		IProject project = resource.getProject();
		QvtEngine engine = (QvtEngine) ourEnginesMap.get(project);
		if(engine == null) {
			engine = new QvtEngine(project);
			//ourEnginesMap.put(project, engine);
		}
		return engine;
	}
	
	private QvtEngine(IProject project) {
		myProject = project;
		IImportResolverFactory resolverFactory = IImportResolverFactory.Registry.INSTANCE.getFactory(myProject);		
        myImportResolver = resolverFactory.createResolver(myProject);
		reset(null);
	}
	

    public CompiledUnit compileUnit(CFile source, QvtCompilerOptions options, IProgressMonitor monitor) throws MdaException {
		reset(options);
		return myCompiler.compile(source, options, monitor);
	}

    public CompiledUnit compileUnit(IFile source, IProgressMonitor monitor) throws MdaException {
    	return myCompiler.compile(new EclipseFile(source), /*default*/null, monitor);
    }
    		    			
	public QVTOCompiler getQVTOCompiler() {
		return myCompiler;
	}	
    
	private void reset(QvtCompilerOptions options) { // TODO: QvtException
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		resourceSet.setURIResourceMap(new EPackageRegistryBasedURIResourceMap(resourceSet.getURIConverter()));
	    
	    myCompiler = new QVTOCompiler(myImportResolver, resourceSet);
	    if (options != null) {
	        myCompiler.getKernel().setMetamodelResourceSet(options.getMetamodelResourceSet());
	    }	    
	}
	
	private static Map<IProject, QvtEngine> ourEnginesMap = new HashMap<IProject, QvtEngine>();
	private QVTOCompiler myCompiler;	
	private IProject myProject;
    private final IImportResolver myImportResolver;
}