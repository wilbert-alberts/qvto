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
package org.eclipse.m2m.internal.qvt.oml.runtime.project.metainfo;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.m2m.qvt.oml.ocl.metainfo.OclMetainfo;

public class QvtMetainfo extends OclMetainfo {

    public QvtMetainfo(LazyLoader loader) {
        super(loader);
        myLazyLoader = loader;
    }

    public List<OclMetainfoProperty> getConfigurationProperties() {
        if (myConfigurationProperties == null) {
            myConfigurationProperties = new ArrayList<OclMetainfoProperty>();
            if (myLazyLoader != null) {
                myLazyLoader.loadConfigurationProperties(myConfigurationProperties);
            }
        }
        return myConfigurationProperties;
    }
    
    public List<OclMetainfoProperty> getAllConfigurationProperties() {
        final List<OclMetainfoProperty> result = new ArrayList<OclMetainfoProperty>();
        accept(new Visitor() {
            @Override
            public void visit(OclMetainfo node) {
                if (node instanceof QvtMetainfo) {
                    result.addAll(((QvtMetainfo) node).getConfigurationProperties());
                }
            }
        });
        return result;
    }
    
    public interface LazyLoader extends OclMetainfo.LazyLoader {
        void loadConfigurationProperties(List<OclMetainfoProperty> configurationProperties);
    }
    
    private List<OclMetainfoProperty> myConfigurationProperties;
    private final LazyLoader myLazyLoader;
}
