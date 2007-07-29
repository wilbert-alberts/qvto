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
package org.eclipse.m2m.internal.qvt.oml.common.ui.controls;

import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.m2m.qvt.oml.common.project.CompiledTransformation;
import org.eclipse.m2m.qvt.oml.common.project.TransformationRegistry;
import org.eclipse.m2m.qvt.oml.common.project.TransformationRegistry.Filter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;


public class SelectCompiledTransfomationControl extends Composite {

    public SelectCompiledTransfomationControl(Composite parent, ILabelProvider labelProvider, TransformationRegistry registry, String selectedTransId, TransformationRegistry.Filter filter){
        super(parent, SWT.NULL);
        myFilter = filter;
        myRegistry = registry;
        myLabelProvider = labelProvider;
        
        setLayout(new GridLayout());
        setLayoutData(new GridData(GridData.FILL_BOTH));
        
        myViewer = new TableViewer(this, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        
        myViewer.setContentProvider(CONTENT_PROVIDER);
        myViewer.setSorter(VIEWER_SORTER);
        myViewer.setLabelProvider(myLabelProvider);
        
        GridData data = new GridData(GridData.FILL_BOTH);
        data.widthHint = 350;
        data.heightHint = 200;
        myViewer.getControl().setLayoutData(data);
        
        List transformations = myRegistry.getTransformations(myFilter);
        myViewer.setInput(transformations);

        selectTransformationById(selectedTransId);
    }
    
    public SelectCompiledTransfomationControl(Composite parent, ILabelProvider labelProvider, TransformationRegistry registry, String selectedTransId) {
        this(parent, labelProvider, registry, selectedTransId, TransformationRegistry.EMPTY_FILTER);
    }
    
    
    public Viewer getViewer(){
        return myViewer;
    }
    
    public IStructuredSelection getSelection() {
        if(myViewer == null) {
            return null;
        }
        
        ISelection selection = myViewer.getSelection();
        if(selection instanceof IStructuredSelection == false) {
            return null;
        }
        
        return (IStructuredSelection)selection;
    }
    
    private TableViewer myViewer;
    private final TransformationRegistry myRegistry;
    private final ILabelProvider myLabelProvider;
    
    private static final ITreeContentProvider CONTENT_PROVIDER = new ITreeContentProvider() {
        public Object[] getChildren(Object parentElement) {
            return getElements(parentElement);
        }

        public Object getParent(Object element) {
            return null;
        }

        public boolean hasChildren(Object element) {
            Object[] children = getChildren(element);
            return children.length > 0;
        }

        public Object[] getElements(Object inputElement) {
            if(inputElement instanceof List) {
                return ((List)inputElement).toArray();
            }
            else {
                return new Object[0];
            }
        }

        public void dispose() {
        }

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }
    };
    
    private static final ViewerSorter VIEWER_SORTER = new ViewerSorter() {
        @Override
		public int compare(Viewer viewer, Object o1, Object o2) {
            CompiledTransformation t1 = (CompiledTransformation)o1;
            CompiledTransformation t2 = (CompiledTransformation)o2;

            String id1 = t1.getId();
            String id2 = t2.getId();
            
            if(id1 == null) {
                return id2 != null ? -1 : 0;
            }

            if(id2 == null) {
                return 1;
            }
            
            return id1.compareTo(id2);
        }
    };
    
    public void selectTransformationById(String transfId) {
    	CompiledTransformation ct = myRegistry.getSingleTransformationById(transfId);
    	if(ct != null) {
    		myViewer.setSelection(new StructuredSelection(ct));
    	}
    }

    private Filter myFilter;
}
