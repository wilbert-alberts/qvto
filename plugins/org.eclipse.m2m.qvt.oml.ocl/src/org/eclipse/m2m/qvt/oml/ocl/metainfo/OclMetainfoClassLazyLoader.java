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

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.m2m.qvt.oml.ocl.Logger;


public class OclMetainfoClassLazyLoader implements OclMetainfo.LazyLoader {

    public OclMetainfoClassLazyLoader(Class executableClass) {
        this(executableClass, getInnerClassByName(executableClass,
                OclReflectiveMetainfoConstants.METAINFO_NAME));
    }
    
    protected OclMetainfoClassLazyLoader(Class executableClass, Class metainfoClass) {
        myExecutableClass = executableClass;
        myMetainfoClass = metainfoClass;
    }
    
    public void loadImportedMetainfos(List<OclMetainfo> metainfos) {
        Set<Class> importedMetainfoClasses = getImportedMetainfoClasses(myMetainfoClass);
        for (Class metainfoClass : importedMetainfoClasses) {
            metainfos.add(buildImportedMetainfo(metainfoClass));
        }
    }

    public void loadMetamodels(List<OclMetainfoMetamodel> metamodels) {
        try {
            Field metamodelsField = myMetainfoClass.getField(OclReflectiveMetainfoConstants.METAMODELS_NAME);
            if (!Modifier.isStatic(metamodelsField.getModifiers())) {
                Logger.logError("Field '" + OclReflectiveMetainfoConstants.METAMODELS_NAME + "' must be static");  //$NON-NLS-1$//$NON-NLS-2$
                return;
            }
            if (metamodelsField.getType() != String[].class) {
                Logger.logError("Field '" + OclReflectiveMetainfoConstants.METAMODELS_NAME + "' must be of type 'String[]'");  //$NON-NLS-1$//$NON-NLS-2$
                return;
            }
            
            String[] names;
            try {
                names = (String[]) metamodelsField.get(null);
            } catch (Exception e) {
                Logger.logError("Failed to retrieve field value '" + OclReflectiveMetainfoConstants.METAMODELS_NAME + "'", e);  //$NON-NLS-1$//$NON-NLS-2$
                return;
            }
            for (int i = 0; i < names.length; i++) {
                metamodels.add(new OclMetainfoMetamodel(names[i]));
            }
        } catch (NoSuchFieldException e) {
            Logger.logWarning("Field '" + OclReflectiveMetainfoConstants.METAMODELS_NAME + "' not found - no metamodels imported", e);  //$NON-NLS-1$//$NON-NLS-2$
        }            
    }

    public void loadOperations(List<OclMetainfoOperation> operations) {
        Method[] methods = myMetainfoClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (isObjectMethod(methods[i])) {
                Logger.logInfo("Skipping method: " + methods[i].getName() //$NON-NLS-1$
                        + " since belongs to Object"); //$NON-NLS-1$
                continue;
            }
            if (!Modifier.isPublic(methods[i].getModifiers())) {
                Logger.logInfo("Skipping method: " + methods[i].getName() //$NON-NLS-1$
                        + " since it is not public"); //$NON-NLS-1$
                continue;
            }
            Method execMethod = null;
            Exception ex = null;
            try {
                execMethod = myExecutableClass.getMethod(methods[i].getName(), methods[i].getParameterTypes());
            } catch (SecurityException e) {
                ex = e;
            } catch (NoSuchMethodException e) {
                ex = e;
            }
            if (execMethod == null) {                
                Logger.logError("No executable found for " + methods[i].getName(), ex); //$NON-NLS-1$
                continue;
            }
            OclMetainfoOperation operation = buildOperation(methods[i], execMethod);
            if (operation != null) {
                operations.add(operation);
            }
        }
    }

    protected OclMetainfo buildImportedMetainfo(Class metainfoClass) {
        Class executableClass = getExecutableClass(metainfoClass);
        return new OclMetainfo(new OclMetainfoClassLazyLoader(executableClass, metainfoClass));
    }

    protected static Class getExecutableClass(Class metainfoClass) {
        Class executableClass = metainfoClass.getDeclaringClass();
        if (executableClass == null) {
            Logger.logError("Class '" + metainfoClass.getName() + "' is not inner");  //$NON-NLS-1$//$NON-NLS-2$
            return null;
        }
        return executableClass;
    }

    public Class getMetainfoClass() {
        return myMetainfoClass;        
    }
    
    private static OclMetainfoOperation buildOperation(Method declMethod, Method execMethod) {
        String[] value;
        if (!Modifier.isStatic(declMethod.getModifiers())) {
            Logger.logError("Method '" + declMethod.getName() + "' must be static");  //$NON-NLS-1$//$NON-NLS-2$
            return null;
        }
        if (declMethod.getReturnType() != String[].class) {
            Logger.logError("Method '" + declMethod.getName() + "' must return 'String[]'");  //$NON-NLS-1$//$NON-NLS-2$
            return null;
        }
        try {
            value = (String[]) declMethod.invoke(null, new Object[declMethod.getParameterTypes().length]);
        } catch (Exception e) {
            Logger.logError("Unable to run method '" + declMethod.getName() + "'", e);  //$NON-NLS-1$//$NON-NLS-2$
            return null;            
        } 
        if (value.length < 2) {
            Logger.logError("An array returned by '" + declMethod.getName() + "' must have at leat two elements: context type and result type");  //$NON-NLS-1$//$NON-NLS-2$
            return null;            
        }
        OclMetainfoOperation operation = new OclMetainfoOperation(value[0],
                value[value.length - 1], declMethod.getName(), execMethod);
        for (int i = 1; i < value.length - 1; i++) {
            operation.getParameterTypes().add(value[i]);
        }
        return operation;
    }

    private static Set<Class> getImportedMetainfoClasses(Class cl) {
        Class importedMetainfos = getInnerClassByName(cl,
                OclReflectiveMetainfoConstants.METAINFO_IMPORT_CLASS_NAME);
        if (importedMetainfos == null) {
            return Collections.emptySet();
        }
        Field[] fields = importedMetainfos.getFields();
        Set<Class> result = new HashSet<Class>();
        for (int i = 0; i < fields.length; i++) {
            result.add(fields[i].getType());
        }
        return result;
    }

    protected static Class getInnerClassByName(Class cl, String name) {
        Class[] innerClasses = cl.getClasses();
        Class result = null;
        for (int i = 0; i < innerClasses.length; i++) {
            if (name.equals(innerClasses[i].getSimpleName())) {
                result = innerClasses[i];
                break;
            }
        }
        return result;
    }

    private static boolean isObjectMethod(Method method) {
        try {
            Method objectMethod = Object.class.getMethod(method.getName(),
                    method.getParameterTypes());
            return objectMethod != null;
        } catch (SecurityException e) {
        } catch (NoSuchMethodException e) {
        }
        return false;
    }

    private final Class myMetainfoClass;
    private final Class<?> myExecutableClass;
}
