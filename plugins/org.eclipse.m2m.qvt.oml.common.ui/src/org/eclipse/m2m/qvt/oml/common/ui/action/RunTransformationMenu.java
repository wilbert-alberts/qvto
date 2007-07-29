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
package org.eclipse.m2m.qvt.oml.common.ui.action;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.qvt.oml.common.project.CompiledTransformation;
import org.eclipse.m2m.qvt.oml.common.project.TransformationRegistry;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;


public abstract class RunTransformationMenu implements IObjectActionDelegate, IMenuCreator {
    public RunTransformationMenu(TransformationRegistry transformationRegistry, IActionFactory factory) {
        myRegistry = transformationRegistry;
        myFactory = factory;
    }
    
    public static interface IActionFactory {
        IAction makeRunCompiledAction(CompiledTransformation transformation);
        ILabelProvider getLabelProvider();
    }
    
    public void dispose() {
    }

    public Menu getMenu(Control parent) {
        return null;
    }
    
    public Menu getMenu(Menu parent) {
        Menu menu = new Menu(parent);
        menu.addMenuListener(new MenuAdapter() {
            @Override
			public void menuShown(MenuEvent e) {
                if (myFillMenu) {
                    Menu m = (Menu)e.widget;
                    MenuItem[] items = m.getItems();
                    for (int i=0; i < items.length; i++) {
                        items[i].dispose();
                    }
                    fillMenu(m);
                    myFillMenu = false;
                }
            }
        });
        return menu;
    }

    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
    }
    
    public void run(IAction action) {
        // Never called because we become a menu.
    }
    
    public void selectionChanged(IAction action, ISelection selection) {
        if (selection instanceof IStructuredSelection) {
            myFillMenu = true;
            if (myDelegateAction != action) {
                myDelegateAction = action;
                myDelegateAction.setMenuCreator(this);
            }
            // save selection and enable our menu
            mySelection = (IStructuredSelection) selection;
            action.setEnabled(true);
            return;
        }
        
        action.setEnabled(false);
    }

    protected void fillMenu(Menu menu) {
        if (mySelection == null) {
            return;
        }
        
        List transformations = myRegistry.getTransformations();
        int count = 0;
        for(Iterator it = transformations.iterator(); it.hasNext(); ) {
            CompiledTransformation transformation = (CompiledTransformation) it.next();
            addMenuItem(transformation, menu, ++count);
        }
    }
    
    private void addMenuItem(CompiledTransformation transformation, Menu menu, int accelerator) {
        IAction action = myFactory.makeRunCompiledAction(transformation);
        action.setActionDefinitionId(transformation.getId()); 

        StringBuffer label = new StringBuffer();
        if (accelerator >= 0 && accelerator < 10) {
            //add the numerical accelerator
            label.append('&');
            label.append(accelerator);
            label.append(' ');
        }
        
        String contextLabel = myFactory.getLabelProvider().getText(transformation);
        label.append((contextLabel != null) ? contextLabel : action.getText());
        action.setText(label.toString());
        ActionContributionItem item = new ActionContributionItem(action);
        item.fill(menu, -1);
    }

    private final TransformationRegistry myRegistry;
    private final IActionFactory myFactory;

    private IStructuredSelection mySelection;
    private IAction myDelegateAction;
    private boolean myFillMenu = true;
}
