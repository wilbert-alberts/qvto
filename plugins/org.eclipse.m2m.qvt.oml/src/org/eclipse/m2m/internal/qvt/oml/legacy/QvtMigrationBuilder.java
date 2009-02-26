/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.legacy;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;


public class QvtMigrationBuilder extends IncrementalProjectBuilder {
    	
	private String QVTO_NATURE_ID = "org.eclipse.m2m.qvt.oml.project.QVTONature";//$NON-NLS-1$    	
	
	public static final String LEGACY_PROBLEM_MARKER = "org.eclipse.m2m.qvt.oml.qvtProblem"; //$NON-NLS-1$
	
    public QvtMigrationBuilder() {
    }
        
    @SuppressWarnings("unchecked")
	@Override
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
    	if(monitor == null) {
    		monitor = new NullProgressMonitor();
    	}

    	IProjectDescription description = getProject().getDescription();

    	LinkedHashSet<String> natures = new LinkedHashSet<String>(Arrays.asList(description.getNatureIds()));
    	natures.add(QVTO_NATURE_ID);
    	description.setNatureIds(natures.toArray(new String[natures.size()]));

    	getProject().setDescription(description, monitor);

		return null;
    }
}
