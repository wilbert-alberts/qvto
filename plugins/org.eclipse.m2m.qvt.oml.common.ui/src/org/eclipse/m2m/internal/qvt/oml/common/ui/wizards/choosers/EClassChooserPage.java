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
package org.eclipse.m2m.internal.qvt.oml.common.ui.wizards.choosers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.m2m.internal.qvt.oml.common.model.ObjectFeature;
import org.eclipse.m2m.internal.qvt.oml.common.ui.views.MetamodelBrowser;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.metamodel.ChooserNode;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.metamodel.IEPackageNodeFactory;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.metamodel.MetamodelsNode;
import org.eclipse.swt.widgets.Composite;


public class EClassChooserPage extends TreeChooserPage {

    private final MetamodelsNode metamodelsNode; 
    
    private final ObjectFeature<EClass> myFeature;
    
    private MetamodelBrowser browser;    
	
	
    public EClassChooserPage(ObjectFeature<EClass> feature, String pageId, String title, String helpId, MetamodelRegistry metamodelRegistry) {
        super(pageId, title, false, helpId);
        myFeature = feature;
        metamodelsNode = new MetamodelsNode(IEPackageNodeFactory.FACTORY, metamodelRegistry);        
    }
    
    public EClassChooserPage(ObjectFeature<EClass> feature, String pageId, String title, String helpId) {
        this(feature, pageId, title, helpId, MetamodelRegistry.getInstance());
    }    

    @Override
	protected boolean validatePage() {
        setMessage(null);
        setErrorMessage(null);
        
        ISelection selection = getSelection();
        if(selection instanceof IStructuredSelection == false) {
            setMessage(Messages.EObjectChooserPage_SelectEClass);
            return false;
        }
        
        final Object obj = ((IStructuredSelection)selection).getFirstElement();
        myFeature.setUntypedValue(obj); 
        boolean validate = myFeature.validate();
        setErrorMessage(myFeature.getErrorMessage());
        setMessage(myFeature.getMessage(), WARNING);
        return validate;
    }

    @Override
    public ISelection getSelection() {
    	return new StructuredSelection(browser.getModelElementSelection().toArray());
    }
    
    @Override
	protected ChooserNode[] getTreeRoots() {
        return new ChooserNode[] {
                metamodelsNode
        };
    }
    
    @Override
	protected AbstractTreeViewer createViewer(Composite parent, int style) {
        this.browser = new MetamodelBrowser(parent, MetamodelBrowser.SHOW_PACKAGE_CONTENTS);
        return browser.getViewer();
    }
        
    @Override
	protected void setupViewer(AbstractTreeViewer viewer) {
        super.setupViewer(viewer);
        //viewer.expandToLevel(metamodelsNode, 1);
    }    
}
