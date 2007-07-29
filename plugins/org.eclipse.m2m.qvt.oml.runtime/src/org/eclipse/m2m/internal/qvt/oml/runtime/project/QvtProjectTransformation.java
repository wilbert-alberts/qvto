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

import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.m2m.internal.qvt.oml.runtime.QvtRuntimePlugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner.In;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner.Out;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.config.QvtConfigurationProperty;
import org.eclipse.m2m.qvt.oml.builder.QvtBuilderConfig;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.cp.ClasspathUtil;
import org.eclipse.m2m.qvt.oml.common.project.ProjectTransformation;
import org.eclipse.m2m.qvt.oml.common.util.CompositeClassLoader;
import org.eclipse.m2m.qvt.oml.common.util.ProjectUtil;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.qvt.oml.generator.QvtGeneratorUtil;
import org.eclipse.osgi.util.NLS;

public class QvtProjectTransformation implements QvtTransformation, ProjectTransformation {
    
	public QvtProjectTransformation(IFile transformationFile) {
    	this.project = transformationFile.getProject();
    	myModule = new WorkspaceQvtModule(transformationFile);
        myImpl = new QvtOnJava(new QvtOnJava.IClInfo() {
            public String getClassName() throws MdaException {
                return QvtGeneratorUtil.getQualifiedClassName(myModule.getModule());
            }
            
            public ClassLoader getClassLoader(ClassLoader parent) throws MdaException {
                CompositeClassLoader cl = new CompositeClassLoader(new ClassLoader[] {
                        parent,
                        QvtRuntimePlugin.class.getClassLoader(),
                        ClasspathUtil.getProjectClassLoader(getProject(), null),
                });

                return cl;
            }
        });
    }
    
    public IStatus canRun (EObject in) throws MdaException {
    	IStatus status = validateProject();
    	if(status.getSeverity() == IStatus.ERROR) {
    		return status;
    	}
    	
		return myImpl.canRun(in);
    }
    
    public EObject loadInput(URI inputObjectURI) throws MdaException {
    	 return EmfUtil.loadModel(inputObjectURI, myModule.getCompiler().getResourceSet());    	
    }
    
    public IStatus validateProject() throws MdaException {
    	IProject proj = getProject();
    	if (proj == null) {
    		return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtProjectTransformation_NoProject, myModule.getModuleName()));
    	}
    	IJavaProject javaProject = JavaCore.create(proj.getProject());
    	if (javaProject == null) {
    		return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtProjectTransformation_NotAJavaProject, proj.getName()));
        }
    	
    	try {
            if (!QvtBuilderConfig.getConfig(proj).getGenerateJava()) {
                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtProjectTransformation_NoJavaGenerated, proj.getName()));
            }            
			if (ProjectUtil.isBuilt(javaProject) == false){
				return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtProjectTransformation_ProjectNotBuilt, proj.getName()));
			}
		}
    	catch (CoreException e) {
			throw new MdaException (e.getStatus().getMessage(), e);
		}
        
    	return new Status(IStatus.OK, QvtRuntimePlugin.ID, 0, "", null); //$NON-NLS-1$
    }
    
    public Set<QvtConfigurationProperty> getConfigurationProperties() throws MdaException {
        return myModule.getConfigurationProperties();
    }

    public Out run(In in) throws MdaException {
		return myImpl.run(in);
	}
	
	public String getModuleName() throws MdaException {
		return myModule.getModuleName();
	}

	public EClass getIn() throws MdaException {
		return myModule.getIn();
	}

	public EClass getOut() throws MdaException {
		return myModule.getOut();
	}
	
	public List<TransformationParameter> getParameters() throws MdaException {
		return myModule.getParameters();
	}

	public IProject getProject() {
		return project;
	}

	private final QvtModule myModule;
    private final QvtOnJava myImpl;
    private final IProject project;
}
