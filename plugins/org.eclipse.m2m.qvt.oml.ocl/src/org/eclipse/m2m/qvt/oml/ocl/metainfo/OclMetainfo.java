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
package org.eclipse.m2m.qvt.oml.ocl.metainfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OclMetainfo {

    /**
     * @param loader - null for no loader
     */
    public OclMetainfo(LazyLoader loader) {
        myLazyLoader = loader;
    }
    
    public List<OclMetainfoMetamodel> getMetamodels() {
        if (myMetamodels == null) {
            myMetamodels = new ArrayList<OclMetainfoMetamodel>();
            if (myLazyLoader != null) {
                myLazyLoader.loadMetamodels(myMetamodels);
            }
        }
        return myMetamodels;
    }

    public List<OclMetainfoOperation> getOperations() {
        if (myOperations == null) {
            myOperations = new ArrayList<OclMetainfoOperation>();
            if (myLazyLoader != null) {
                myLazyLoader.loadOperations(myOperations);
            }
        }
        return myOperations;
    }
    
    public List<OclMetainfo> getImportedMetainfos() {
        if (myImportedMetainfos == null) {
            myImportedMetainfos = new ArrayList<OclMetainfo>();
            if (myLazyLoader != null) {
                myLazyLoader.loadImportedMetainfos(myImportedMetainfos);
            }
        }
        return myImportedMetainfos;
    }
    
    public List<OclMetainfoMetamodel> getAllMetamodels() {
        final List<OclMetainfoMetamodel> result = new ArrayList<OclMetainfoMetamodel>();
        accept(new Visitor() {
            @Override
            public void visit(OclMetainfo node) {
                result.addAll(node.getMetamodels());
            }
        });
        return result;
    }

    public List<OclMetainfoOperation> getAllOperations() {
        final List<OclMetainfoOperation> result = new ArrayList<OclMetainfoOperation>();
        accept(new Visitor() {
            @Override
            public void visit(OclMetainfo node) {
                result.addAll(node.getOperations());
            }
        });
        return result;
    }
    
    protected abstract class Visitor {        
        public abstract void visit(OclMetainfo node);       
    }
    
    protected void accept(Visitor visitor) {
        Set<OclMetainfo> visited = new HashSet<OclMetainfo>();
        Queue<OclMetainfo> queue = new LinkedList<OclMetainfo>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            OclMetainfo metainfo = queue.poll();
            visitor.visit(metainfo);
            List<OclMetainfo> importedMetainfos = metainfo.getImportedMetainfos();
            for (OclMetainfo m : importedMetainfos) {
                if (!visited.contains(m)) {
                    queue.offer(m);
                }
            }
        }
    }
    
    public interface LazyLoader {
        void loadImportedMetainfos(List<OclMetainfo> metainfos);
        void loadMetamodels(List<OclMetainfoMetamodel> metamodels);
        void loadOperations(List<OclMetainfoOperation> operations);
    }
    
    private List<OclMetainfoMetamodel> myMetamodels;
    private List<OclMetainfoOperation> myOperations;
    private List<OclMetainfo> myImportedMetainfos;
    private final LazyLoader myLazyLoader;
}
