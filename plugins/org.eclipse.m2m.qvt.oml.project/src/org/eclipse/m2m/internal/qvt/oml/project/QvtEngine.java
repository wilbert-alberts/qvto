/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.project;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerUtils;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolverFactory;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;


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
		UnitResolverFactory resolverFactory = UnitResolverFactory.Registry.INSTANCE.getFactory(myProject);		
        myImportResolver = resolverFactory.getResolver(URIUtils.getResourceURI(myProject));
		reset(null);
	}
	

    public CompiledUnit compileUnit(UnitProxy source,  QvtCompilerOptions options, Monitor monitor) throws MdaException {
		return myCompiler.compile(source, options, monitor);
	}
	
	
    public CompiledUnit compileUnit(UnitProxy source, Monitor monitor) throws MdaException {
		return myCompiler.compile(source, /*default*/null, monitor);
	}

//    public CompiledUnit compileUnit(IFile source, IProgressMonitor monitor) throws MdaException {
//    	return myCompiler.compile(new EclipseFile(source), /*default*/null, monitor);
//    }
    		    			
	public QVTOCompiler getQVTOCompiler() {
		return myCompiler;
	}	
    
	private void reset(QvtCompilerOptions options) { // TODO: QvtException
	    myCompiler = CompilerUtils.createCompiler(myImportResolver);
	}
	
	private static Map<IProject, QvtEngine> ourEnginesMap = new HashMap<IProject, QvtEngine>();
	private QVTOCompiler myCompiler;	
	private IProject myProject;
    private final UnitResolver myImportResolver;
}