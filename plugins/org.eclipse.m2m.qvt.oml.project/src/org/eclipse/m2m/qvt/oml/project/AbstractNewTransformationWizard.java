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
package org.eclipse.m2m.qvt.oml.project;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.WorkspaceMetamodelRegistryProvider;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginReference;
import org.eclipse.pde.ui.IFieldData;
import org.eclipse.ui.IWorkbench;

public abstract class AbstractNewTransformationWizard extends Wizard implements INewTransformationWizard {
	
    private IStructuredSelection mySelection;
    private IWorkbench myWorkbench;
    private MetamodelRegistry perSelectionMetamodelRegistry;
    private boolean myContentCreated;    
	
	protected AbstractNewTransformationWizard() {
		super();		
	}

    protected abstract void doAddPages();	
    
    protected IStructuredSelection getSelection() {
		return mySelection;
	}
    
    protected IWorkbench getWorkbench() {
		return myWorkbench;
	}
    
    protected MetamodelRegistry getMetamodelRegistry() {
    	if(perSelectionMetamodelRegistry != null) {
    		return perSelectionMetamodelRegistry;
    	}
    	
    	IResource selectedResource = null;
    	if(!mySelection.isEmpty() && mySelection.getFirstElement() instanceof IResource) {
			selectedResource = (IResource) mySelection.getFirstElement();
    	}
    	
    	if(selectedResource != null && selectedResource.exists()) {
			final IResource resource = (IResource) mySelection.getFirstElement();
			IMetamodelRegistryProvider.IRepositoryContext ctx = new IMetamodelRegistryProvider.IRepositoryContext() {
				public URI getURI() {    				
					return URI.createFileURI(resource.getLocation().toString());
				}
			};
			
			perSelectionMetamodelRegistry = new WorkspaceMetamodelRegistryProvider().getRegistry(ctx);    			
    	} else {
    		perSelectionMetamodelRegistry = MetamodelRegistry.getInstance();      		
    	}
    	
    	return perSelectionMetamodelRegistry;
    }    
    
    /**
     * The implementation method records the given workbench and
     * selection. Subclasses may extend but are required to call the
     * super-implementation first.
     */    
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        myWorkbench = workbench;
        mySelection = selection;    	
    }
		
    public IPluginReference[] getDependencies(String schemaVersion) {
        return new IPluginReference[0];
    }

    public String[] getNewFiles() {
        return new String[0];
    }

    public void init(IFieldData data) {

    }
    
    public boolean performFinish(IProject project, IPluginModelBase model, IProgressMonitor monitor) {
        return false;
    }
    
    @Override
    public final void addPages() {
        myContentCreated = true;
        doAddPages();
    }
    
    public boolean isContentCreated() {
        return myContentCreated;
    }
}
