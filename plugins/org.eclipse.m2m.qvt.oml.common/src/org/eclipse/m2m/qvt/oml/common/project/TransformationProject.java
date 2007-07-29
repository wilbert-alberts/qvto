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
package org.eclipse.m2m.qvt.oml.common.project;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.project.PluginUtil.ModelHelper;
import org.eclipse.m2m.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.IMetamodelDesc;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IExtensionsModelFactory;
import org.eclipse.pde.core.plugin.IPlugin;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginImport;
import org.eclipse.pde.core.plugin.IPluginModel;
import org.eclipse.pde.core.plugin.IPluginModelFactory;


public abstract class TransformationProject {
    public TransformationProject(String point) {
        myPoint = point;
    }
    
    protected abstract IPluginElement createExtensionElements(CompiledTransformation transformation, IPluginExtension extension, IExtensionsModelFactory factory) throws CoreException;
    
    protected void createExtension(IProject project, CompiledTransformation transformation) throws MdaException {
        try {
        	ModelHelper<IPluginModel> model = PluginUtil.getModel(project);
            IExtensionsModelFactory factory = model.model().getFactory(); 
            
            IPluginExtension extension = factory.createExtension();
            extension.setPoint(myPoint);
            
            IPluginElement transformationElement = createExtensionElements(transformation, extension, factory);
            extension.add(transformationElement);
            
            model.model().getPlugin().add(extension);
            model.save();
        }
        catch(Exception e) {
            throw new MdaException(NLS.bind(Messages.TransformationProject_CreateExtensionError, transformation), e);
        }
    }
    
    protected void addMetamodelImport(IProject project, EPackage metamodel) throws MdaException {
    	ModelHelper<IPluginModel> model = PluginUtil.getModel(project);
        try {
            addMetamodelImport(model.model(), metamodel);
            model.save();
        }
        catch(Exception e) {
            throw new MdaException(Messages.TransformationProject_AddImportFailed, e); 
        }
    }

    private void addMetamodelImport(IPluginModel model, EPackage pack) throws MdaException {
        IPluginModelFactory factory = model.getPluginFactory();
        String metamodelId = getMetamodelId(pack);
        IMetamodelDesc desc;
		try {
			desc = MetamodelRegistry.getInstance().getMetamodelDesc(metamodelId);
		} 
		catch (EmfException e) {
			throw new MdaException(e);
		}
        String namespace = desc.getNamespace();
        if(namespace != null) {
        	addPluginImport(model.getPlugin(), factory, namespace);
        }
    }
    
    public static void addPluginImport(IProject project, String namespace) throws MdaException {
    	ModelHelper<IPluginModel> model = PluginUtil.getModel(project);
        IPluginModelFactory factory = model.model().getPluginFactory();
        addPluginImport(model.model().getPlugin(), factory, namespace);
        model.save();
    }
    
    private static void addPluginImport(IPlugin plugin, IPluginModelFactory factory, String namespace) throws MdaException {
        try {
            IPluginImport[] existingImports = plugin.getImports();
            for (int i = 0; i < existingImports.length; i++) {
                IPluginImport existingImport = existingImports[i];
                if(namespace.equals(existingImport.getId())) {
                    return;
                }
            }
            
            IPluginImport imp = factory.createImport();
            imp.setId(namespace);
            imp.setOptional(false);
            plugin.add(imp);
        }
        catch(Exception e) {
            throw new MdaException(Messages.TransformationProject_CreateImportFailed, e); //$NON-NLS-1$
        }
    }

    public static IPluginElement createEClassElement(IExtensionsModelFactory factory, IPluginElement transformationElement, String name, EClass cls) throws CoreException {
        IPluginElement parameterElement = factory.createElement(transformationElement);
        parameterElement.setName(name);
        parameterElement.setAttribute(IRegistryConstants.METAMODEL, getMetamodelId(cls.getEPackage()));
        parameterElement.setAttribute(IRegistryConstants.METACLASS, getFullName(cls, IRegistryConstants.DELIM));
        transformationElement.add(parameterElement);
        return parameterElement;
    }
    
    public static IPluginElement createMetamodelElement(IExtensionsModelFactory factory, IPluginElement transformationElement, String name, EPackage pack) throws CoreException {
        IPluginElement parameterElement = factory.createElement(transformationElement);
        parameterElement.setName(name);
        parameterElement.setAttribute(IRegistryConstants.METAMODEL, getMetamodelId(pack));
        transformationElement.add(parameterElement);
        return parameterElement;
    }
    
    public static String getMetamodelId(EClass cls) {
        return getMetamodelId(cls.getEPackage());
    }

    public static String getMetamodelId(EPackage pack) {
        return EmfUtil.getRootPackage(pack).getNsURI();
    }
    
    public static String getFullName(EClass cls, String delim) {
        String type = EmfUtil.getFullName(cls.getEPackage(), delim);
        type += delim + cls.getName();
        return type;
    }
    
    private final String  myPoint;
}
