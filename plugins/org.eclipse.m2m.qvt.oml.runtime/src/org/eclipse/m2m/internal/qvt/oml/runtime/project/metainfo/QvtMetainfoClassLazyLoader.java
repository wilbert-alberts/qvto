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

import java.lang.reflect.Field;
import java.util.List;

import org.eclipse.m2m.internal.qvt.oml.runtime.QvtRuntimePlugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil;
import org.eclipse.m2m.qvt.oml.ocl.metainfo.OclMetainfo;
import org.eclipse.m2m.qvt.oml.ocl.metainfo.OclMetainfoClassLazyLoader;

public class QvtMetainfoClassLazyLoader extends OclMetainfoClassLazyLoader implements QvtMetainfo.LazyLoader {
    
    public QvtMetainfoClassLazyLoader(Class executableClass) {
        super(executableClass);
    }

    protected QvtMetainfoClassLazyLoader(Class executableClass, Class metainfoClass) {
        super(executableClass, metainfoClass);
    }

    @Override
    protected OclMetainfo buildImportedMetainfo(Class metainfoClass) {
        return new QvtMetainfo(new QvtMetainfoClassLazyLoader(getExecutableClass(metainfoClass), metainfoClass));
    }
    
    public void loadConfigurationProperties(List<OclMetainfoProperty> configurationProperties) {
        Class cpClass = getInnerClassByName(getMetainfoClass(), QvtReflectiveMetainfoConstants.CONFIGURATION_PROPERTIES_CLASS_NAME);
        if (cpClass != null) {
            Field[] fields = cpClass.getFields();
            for (int i = 0; i < fields.length; i++) {
                String[] values;
                try {
                    values = (String[]) fields[i].get(null);
                    if (values.length < 2) {
                        QvtRuntimePlugin.getDefault().getLog().log(MiscUtil.makeWarningStatus(
                                "Field must declare property's name and type: '" + fields[i].getName() + "'", new IllegalArgumentException())); //$NON-NLS-1$//$NON-NLS-2$
                    }
                    configurationProperties.add(new OclMetainfoProperty(values[0], values[1]));
                } catch (IllegalArgumentException e) {
                    QvtRuntimePlugin.getDefault().getLog().log(MiscUtil.makeWarningStatus(
                            "Unable to retrieve field value: '" + fields[i].getName() + "'", e)); //$NON-NLS-1$//$NON-NLS-2$
                } catch (IllegalAccessException e) {
                    QvtRuntimePlugin.getDefault().getLog().log(MiscUtil.makeWarningStatus(
                            "Unable to retrieve field value: '" + fields[i].getName() + "'", e)); //$NON-NLS-1$//$NON-NLS-2$
                } catch (ClassCastException e) {
                    QvtRuntimePlugin.getDefault().getLog().log(MiscUtil.makeWarningStatus(
                            "Field must be of type 'String[]': '" + fields[i].getName() + "'",  //$NON-NLS-1$//$NON-NLS-2$
                            e));
                }
            }
        }
    }

}
