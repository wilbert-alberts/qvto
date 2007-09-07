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
package org.eclipse.m2m.internal.qvt.oml.runtime.launch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TraceSerializer;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil;
import org.eclipse.m2m.qvt.oml.common.Logger;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.qvt.oml.common.launch.BaseProcess;
import org.eclipse.m2m.qvt.oml.common.launch.SafeRunner;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.qvt.oml.common.launch.BaseProcess.IRunnable;
import org.eclipse.m2m.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.m2m.qvt.oml.library.Context;
import org.eclipse.m2m.qvt.oml.library.IConfiguration;
import org.eclipse.m2m.qvt.oml.library.IContext;
import org.eclipse.osgi.util.NLS;

public abstract class QvtLaunchConfigurationDelegateBase extends LaunchConfigurationDelegate {
    @Override
	protected IProject[] getProjectsForProblemSearch(ILaunchConfiguration configuration, String mode) throws CoreException {
        return new IProject[] { getModuleFile(configuration).getProject() };
    }
 
    protected static IFile getModuleFile(ILaunchConfiguration configuration) throws CoreException {
        String moduleFileName = configuration.getAttribute(IQvtLaunchConstants.MODULE, ""); //$NON-NLS-1$
        IFile moduleFile = WorkspaceUtils.getWorkspaceFile(moduleFileName);
        if(moduleFile == null) {
        	IStatus errorStatus = MiscUtil.makeErrorStatus( 
        			NLS.bind(Messages.QvtLaunchConfigurationDelegate_transformationFileNotFound, moduleFileName));
        	throw new CoreException(errorStatus);
        }
        
        return moduleFile;
    }

    public static IStatus validate(QvtTransformation transformation, ILaunchConfiguration configuration) throws CoreException {
    	List<TargetUriData> targetUris = QvtLaunchUtil.getTargetUris(configuration);
        String traceFile = configuration.getAttribute(IQvtLaunchConstants.TRACE_FILE, ""); //$NON-NLS-1$
        boolean useTraceFile = configuration.getAttribute(IQvtLaunchConstants.USE_TRACE_FILE, false); 
        
        try {
        	return QvtValidator.validateTransformation(transformation, targetUris, traceFile, useTraceFile);
        }
        catch (MdaException ex) {
        	throw new CoreException(StatusUtil.makeErrorStatus(ex.getMessage(), ex));
        }
    }
    
    public static BaseProcess.IRunnable getSafeRunnable(QvtTransformation transformation, IRunnable r) throws CoreException {
        try {
            return SafeRunner.getSafeRunnable(new EClass[] {transformation.getIn(), transformation.getOut()}, r);
        } 
        catch (MdaException e) {
            throw new CoreException(MiscUtil.makeErrorStatus(e));
        }
    }
    
    public static void doLaunch(QvtTransformation transformation, ILaunchConfiguration configuration, IContext context) throws Exception {
    	List<EObject> inObjects = new ArrayList<EObject>();
    	List<TargetUriData> targetData = new ArrayList<TargetUriData>();
		List<TargetUriData> targetUris = QvtLaunchUtil.getTargetUris(configuration);
		
		Iterator<TargetUriData> itrTargetData = targetUris.iterator();
		for (TransformationParameter transfParam : transformation.getParameters()) {
			if (!itrTargetData.hasNext()) {
	            throw new MdaException(NLS.bind(Messages.QvtValidator_EmptyInputTransfParam,
	            		transfParam.getName()));
			}
			TargetUriData nextUri = itrTargetData.next();
			if (transfParam.getDirectionKind() == DirectionKind.IN || transfParam.getDirectionKind() == DirectionKind.INOUT) {
		        URI inUri = toUri(nextUri.getUriString());
		        EObject inObj = transformation.loadInput(inUri);
		        inObjects.add(inObj);
			}
			if (transfParam.getDirectionKind() == DirectionKind.OUT || transfParam.getDirectionKind() == DirectionKind.INOUT) {
				targetData.add(nextUri);
			}
		}

        IConfiguration qvtConfiguration = QvtLaunchUtil.getConfiguration(configuration);
        boolean saveTrace = configuration.getAttribute(IQvtLaunchConstants.USE_TRACE_FILE, false);
        String traceFileName = saveTrace ? configuration.getAttribute(IQvtLaunchConstants.TRACE_FILE, "") : null; //$NON-NLS-1$
        
        doLaunch(transformation, inObjects, targetData, qvtConfiguration, traceFileName, context);
    }
    
    public static List<URI> doLaunch(final QvtTransformation transformation, final List<EObject> inObjs, List<TargetUriData> targetData, IConfiguration configuration, final String traceFileName) throws Exception {
    	return doLaunch(transformation, inObjs, targetData, configuration, traceFileName, new Context(configuration));
    }
    
    private static List<URI> doLaunch(final QvtTransformation transformation, final List<EObject> inObjs, List<TargetUriData> targetData, IConfiguration configuration, final String traceFileName, IContext context) throws Exception {
        context.launch();
    	
        TransformationRunner.In in = new TransformationRunner.In(inObjs.toArray(new EObject[inObjs.size()]), context);
        TransformationRunner.Out out = transformation.run(in);
        
        Iterator<Resource> itrExtent = out.getExtents().iterator();
        for (TargetUriData outData : targetData) {
        	if (!itrExtent.hasNext()) {
        		throw new MdaException("Imcomplete transformation results"); //$NON-NLS-1$
        	}
        	saveTransformationResult(itrExtent.next(), outData);
        }

        List<URI> result = new ArrayList<URI>(out.getOutParamValues().size());
        for (Object outValue : out.getOutParamValues()) {
        	if (outValue instanceof EObject) {
        		result.add(EcoreUtil.getURI((EObject) outValue));
        	}
        	else {
        		result.add(null);
        	}
        }
        
        if(traceFileName != null && out.getTrace() != null) {
            IFile traceFile = WorkspaceUtils.getWorkspaceFile(traceFileName);
            if(traceFile != null) {
                TraceSerializer.saveTraceModel(out.getTrace(), new EclipseFile(traceFile));
            }
        }
        
        context.release();
        
        return result;
    }
    
    @SuppressWarnings("unchecked")
	private static void saveTransformationResult(Resource outExtent, TargetUriData targetData) throws MdaException {
    	URI outUri = toUri(targetData.getUriString());
        switch(targetData.getTargetType()) {
        	case NEW_MODEL: {
        		try {
        			EmfUtil.saveModel(outExtent, outUri, EmfUtil.DEFAULT_SAVE_OPTIONS);
        		}
        		catch(EmfException e) {
        			throw new MdaException(e);
        		}
        		break;
        	}
        	
        	case EXISTING_CONTAINER: {
	        	EObject cont = EmfUtil.loadModel(outUri);
	            if(cont == null) {
	                throw new MdaException("No object at " + outUri); //$NON-NLS-1$
	            }
	            
		        EStructuralFeature feature = cont.eClass().getEStructuralFeature(targetData.getFeature());
		        if(feature instanceof EReference == false) {
	                throw new MdaException("Reference " + targetData.getFeature() + " not found in " + cont); //$NON-NLS-1$ //$NON-NLS-2$
		        }

        		for (EObject out : outExtent.getContents()) {
			        EReference ref = (EReference)feature;
			        if(!ref.isMany()) {
			        	cont.eSet(ref, out);
			        }
			        else {
			        	EList<EObject> value = (EList<EObject>) cont.eGet(feature);
			        	if(targetData.isClearContents()) {
			        		value.clear();
			        	}

			        	try {
			        		value.add(out);
			        	}
			        	catch (RuntimeException ex) {
			        		throw new MdaException(NLS.bind(Messages.QvtLaunchConfigurationDelegateBase_FeatureSetFailure,
			        				EmfUtil.getFullName(out.eClass()), targetData.getFeature()));
			        	}
			        }
        		}
        		outExtent.getContents().clear();
        		
		        try {
		        	saveResource(cont);
		        }
		        catch(IOException e) {
		        	throw new MdaException(e.getMessage(), e);
		        }
		        
		        break;
        	}
        	
        	case INPLACE: {
       			throw new MdaException("Inplace run configuration type is not supported"); //$NON-NLS-1$
        	}
        }
        
        org.eclipse.m2m.qvt.oml.emf.util.URIUtils.refresh(outUri);
    }
    
    private static void saveResource(EObject obj) throws IOException {
    	Resource resource = obj.eResource();
    	if(resource == null) {
    		Logger.getLogger().warning("Object has no resource: " + obj); //$NON-NLS-1$
    		return;
    	}

		resource.save(EmfUtil.DEFAULT_SAVE_OPTIONS);
	}

    private static URI toUri(String uriString) throws MdaException {
        URI uri = URI.createURI(uriString);  
        if(uri == null) {
            throw new MdaException(NLS.bind(Messages.QvtLauncherTab_InvalidUri, uriString));
        }
        
        return uri;
    }
}
