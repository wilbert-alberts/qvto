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
package org.eclipse.m2m.internal.qvt.oml.common.ui.views;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.services.IServiceLocator;


/**
 * @author vrepeshko
 */
public class MetamodelBrowserView extends ViewPart {
	
	public static final String ID = "org.eclipse.m2m.internal.qvt.oml.common.views.MetamodelBrowserView"; //$NON-NLS-1$
	
    private MetamodelBrowser browser;
    
    /**
     * Default constructor.
     */
    public MetamodelBrowserView() {
    	super();
    }
    
	public EObject navigate(EModelElement eModelElement) {
		if(browser != null) {
			return browser.navigate(eModelElement);
		}
		return null;
	}
		
    @Override
	public void createPartControl(final Composite parent) {

		browser = new MetamodelBrowser(parent) {
			@Override
			protected IServiceLocator getServiceLocator() {			
				//return org.eclipse.ui.PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getSite();
				return MetamodelBrowserView.this.getSite();
			}
			
			@Override
			protected IToolBarManager getToolBarManager() {
				return MetamodelBrowserView.super.getViewSite().getActionBars().getToolBarManager();
			}
		};

		getSite().setSelectionProvider(browser.getViewer());
	} 
            	
    @Override
	public void setFocus() {
        if(browser != null) {
            browser.setFocus();
        }
    }

    @SuppressWarnings("unchecked") //$NON-NLS-1$
	@Override
	public Object getAdapter(Class key) {
        Object adaptedObject = browser != null ? browser.getAdapter(key) : null;
        if(adaptedObject == null) {
            adaptedObject = super.getAdapter(key);
        }
        
        return adaptedObject;
    }
}