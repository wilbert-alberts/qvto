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
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.runtime.QvtRuntimePlugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.config.QvtConfigurationProperty;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.project.CompiledTransformation;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.osgi.util.NLS;

public class QvtCompiledTransformation implements QvtTransformation, CompiledTransformation {
   
	public static QvtCompiledTransformation createLibraryModule(String namespace, String id, String file) {
		QvtCompiledTransformation result = new QvtCompiledTransformation(namespace, id, null, null, file);
		result.isLibrary = true;
		return result;
	}
	
	public QvtCompiledTransformation(String namespace, String id, EClass in, EClass out, String file) {
        myIn = in;
        myOut = out;
        myNamespace = namespace;
        myId = id;
        this.isLibrary = false; 
        this.transformationFilePath = file != null ? new Path(file) :
        	new Path(id.replace('.', '/') + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT); //$NON-NLS-1$
    }
	
	protected QvtTransformation getImpl() throws MdaException {
		if(qvtTransformationImpl == null) {
			qvtTransformationImpl = getInterpreterFactory().create(myId);
		}
		return qvtTransformationImpl;
	}

	/**
	 * Indicates that this compiled transformation represents QVT library
	 * module.
	 * 
	 * @return <code>true</code> if this transformation represents library
	 *         module, <code>false</code> otherwise
	 */
	public boolean isLibrary() {
		return isLibrary;
	}
	
    public String getModuleName() {
    	return transformationFilePath.removeFileExtension().lastSegment();
    }

    public IStatus canRun(EObject in) throws MdaException {
		EClass inClass = getIn();
        if (inClass == null || !inClass.isInstance(in)) {
        	return new Status(IStatus.ERROR, QvtRuntimePlugin.ID, 0, 
                NLS.bind(org.eclipse.m2m.internal.qvt.oml.runtime.launch.Messages.QvtValidator_IncompatibleInputTypes, 
                        EmfUtil.getFullName(in.eClass()),
                        EmfUtil.getFullName(inClass)                        
                        ), 
                null);
        }
        return Status.OK_STATUS;        
    }

    public TransformationRunner.Out run(TransformationRunner.In in) throws MdaException {
        return getImpl().run(in);
    }
    
    public String getId() {
        return myId;
    }

    public String getNamespace() {
        return myNamespace;
    }

    public EClass getIn() {
        return myIn;
    }

    public EClass getOut() {
        return myOut;
    }
    
    public List<TransformationParameter> getParameters() throws MdaException {
    	return Collections.emptyList();
    }

    public EPackage[] getModels() {
    	ArrayList<EPackage> modelList = new ArrayList<EPackage>(2);
    	if(getIn() != null) {
    		modelList.add(EmfUtil.getRootPackage(getIn().getEPackage()));
    	}
    	if(getOut() != null) {
    		modelList.add(EmfUtil.getRootPackage(getOut().getEPackage()));
    	}
        return modelList.toArray(new EPackage[modelList.size()]);
    }

    @Override
	public String toString() {
        return myId + "(" + toString(getIn()) + "->" + toString(getOut()) + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

    private static String toString(EClass cls) {
        return EmfUtil.getFullName(cls.getEPackage(), ".") + "." + cls.getName(); //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
	public boolean equals(Object obj) {
        if (obj instanceof QvtCompiledTransformation == false) {
            return false;
        }
        QvtCompiledTransformation trans = (QvtCompiledTransformation) obj;
        return trans.getId().equals(getId());
    }

    @Override
	public int hashCode() {
        return myId.hashCode();
    }

    public Set<QvtConfigurationProperty> getConfigurationProperties() throws MdaException {
    	return getImpl().getConfigurationProperties();
    }
    
    public IPath getTransformationFilePath() {
		return transformationFilePath;
	}
    
    public EObject loadInput(URI inputObjectURI) throws MdaException {
    	return qvtTransformationImpl.loadInput(inputObjectURI);
    }    
    
    public static String[] getUsedMetamodelsNsURIs(QvtCompiledTransformation transformation) {
	    EPackage[] packs = transformation.getModels();
	    List<String> ids = new ArrayList<String>();
	    for (int i = 0; i < packs.length; i++) {
	        EPackage pack = packs[i];
	        ids.add(pack.getNsURI());
	    }
	    
	    return ids.toArray(new String[ids.size()]);
	}

	private static QvtTransformationInterpreterFactory getInterpreterFactory() throws MdaException {
    	if(implFactory != null) {
    		return implFactory;
    	}
		IExtensionRegistry pluginRegistry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = pluginRegistry.getExtensionPoint(QvtTransformationInterpreterFactory.Descriptor.FACTORY_POINT_ID);
		if(extensionPoint != null) {
			IExtension[] allExtensions = extensionPoint.getExtensions();
			if(allExtensions.length == 0) {
				throw new MdaException(Messages.NoQvtImplementorFactoryRegistered);
			}
			// take only first;			
			IConfigurationElement[] elements = allExtensions[0].getConfigurationElements();
			Object factoryObj = null;
			try {
				factoryObj = elements[0].createExecutableExtension(QvtTransformationInterpreterFactory.Descriptor.CLASS_ATTR);
			} catch (CoreException e) {
				throw new MdaException(e);
			}
			return implFactory = (QvtTransformationInterpreterFactory)factoryObj;
		}
		return null;
    }
    
    private static QvtTransformationInterpreterFactory implFactory;
    
    private final EClass myIn;

    private final EClass myOut;

    private final String myNamespace;

    private final String myId;
    
    private QvtTransformation qvtTransformationImpl;

    private IPath transformationFilePath;
    
    private boolean isLibrary;
}
