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
import java.io.PrintWriter;
import java.io.StringWriter;
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelExtentContents;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.internal.qvt.oml.common.launch.BaseProcess;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.SafeRunner;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.common.launch.BaseProcess.IRunnable;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.internal.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.library.IConfiguration;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TraceSerializer;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtModule;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.osgi.util.NLS;

public abstract class QvtLaunchConfigurationDelegateBase extends LaunchConfigurationDelegate {
    @Override
	protected IProject[] getProjectsForProblemSearch(ILaunchConfiguration configuration, String mode) throws CoreException {
    	IFile moduleFile = getModuleFile(configuration);
    	if (moduleFile == null || !moduleFile.exists()) {
    		return new IProject[0];
    	}
        return new IProject[] { moduleFile.getProject() };
    }
 
    protected static QvtModule getQvtModule(ILaunchConfiguration configuration) throws CoreException {
        String moduleName = configuration.getAttribute(IQvtLaunchConstants.MODULE, ""); //$NON-NLS-1$
		try {
			return TransformationUtil.getQvtModule(EmfUtil.makeUri(moduleName));
		} catch (MdaException e) {
        	IStatus errorStatus = MiscUtil.makeErrorStatus(e.getMessage());
        	throw new CoreException(errorStatus);
		}
    }

    protected static IFile getModuleFile(ILaunchConfiguration configuration) throws CoreException {
        String moduleFileName = configuration.getAttribute(IQvtLaunchConstants.MODULE, ""); //$NON-NLS-1$
        URI moduleUri = URI.createURI(moduleFileName);
        IFile moduleFile = WorkspaceUtils.getWorkspaceFile(moduleUri);
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
        return SafeRunner.getSafeRunnable(r);
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
    
    public static List<URI> doLaunch(final QvtTransformation transformation, final List<EObject> inObjs,
    		List<TargetUriData> targetData, IConfiguration configuration, final String traceFileName) throws Exception {
    	return doLaunch(transformation, inObjs, targetData, configuration, traceFileName, new Context(configuration));
    }

    public static void doLaunch(QvtTransformation transformation, List<EObject> inObjs, IConfiguration configuration,
    		List<ModelExtentContents> outExtents, List<EObject> outMainParams, List<Trace> outTraces, List<String> outConsole) throws MdaException {

        IStatus status = QvtValidator.validateTransformation(transformation, inObjs);                    
        if (status.getSeverity() > IStatus.WARNING) {
        	throw new MdaException(status.getMessage());
        }      	
    	
    	Context context = new Context(configuration);    	
    	try {
    		final StringWriter consoleLogger = new StringWriter();
            context.put(QvtOperationalStdLibrary.OUT_PRINT_WRITER, new PrintWriter(consoleLogger));
	        context.launch();
	    	
	        TransformationRunner.In in = new TransformationRunner.In(inObjs.toArray(new EObject[inObjs.size()]), context);
	        TransformationRunner.Out out = transformation.run(in);
	
	        outExtents.addAll(out.getExtents());
	
	        for (Object outValue : out.getOutParamValues()) {
	        	if (outValue instanceof EObject) {
	        		outMainParams.add((EObject) outValue);
	        	}
	        	else {
	        		outMainParams.add(null);
	        	}
	        }
	        
	        if (out.getTrace() != null) {
	        	outTraces.add(out.getTrace());
	        }
	        outConsole.add(consoleLogger.getBuffer().toString());
    	}
    	finally {
    		context.release();
    	}
    }
        
    private static List<URI> doLaunch(final QvtTransformation transformation, final List<EObject> inObjs,
    		List<TargetUriData> targetData, IConfiguration configuration, final String traceFileName, IContext context) throws Exception {
        context.launch();
    	
        TransformationRunner.In in = new TransformationRunner.In(inObjs.toArray(new EObject[inObjs.size()]), context);
        TransformationRunner.Out out = transformation.run(in);
        
        ResourceSet resSet = null;
        for (EObject inEObject : inObjs) {
			if(inEObject.eResource() != null) {
				resSet = inEObject.eResource().getResourceSet();
				if(resSet != null) {
					break;
				}
			}
		}
        
        if(resSet == null) {
        	resSet = EmfUtil.getOutputResourceSet();
        }
        
        Iterator<ModelExtentContents> itrExtent = out.getExtents().iterator();
        for (TargetUriData outData : targetData) {
        	if (itrExtent.hasNext()) {
        		confineInResource(itrExtent.next(), outData, resSet);
        	}
        }
        
        itrExtent = out.getExtents().iterator();
        for (TargetUriData outUriData : targetData) {
        	if (!itrExtent.hasNext()) {
        		throw new MdaException("Imcomplete transformation results"); //$NON-NLS-1$
        	}
        	saveTransformationResult(itrExtent.next(), outUriData, resSet);
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
        	URI traceUri = EmfUtil.makeUri(traceFileName);
            IFile traceFile = traceUri != null ? WorkspaceUtils.getWorkspaceFile(traceUri) : null;
            if(traceFile != null) {
            	TraceSerializer traceSerializer = new TraceSerializer(out.getTrace());
            	traceSerializer.saveTraceModel(new EclipseFile(traceFile));
            	traceSerializer.markUnboundObjects(traceFile);
            }
        }
        
        context.release();
        
        return result;
    }
    
    @SuppressWarnings("unchecked")
	private static void saveTransformationResult(ModelExtentContents extent, TargetUriData targetData, ResourceSet resSet) throws MdaException {    	
    	URI outUri = toUri(targetData.getUriString());
    	
        switch(targetData.getTargetType()) {
        	case NEW_MODEL: {
        		try {
        	    	Resource outExtent = resSet.getResource(outUri, false);
        			//outExtent.getContents().addAll(extent.getAllRootElements());
        			EmfUtil.saveModel(outExtent, outUri, EmfUtil.DEFAULT_SAVE_OPTIONS);
        		}
        		catch(EmfException e) {
        			throw new MdaException(e);
        		}
        		break;
        	}
        	
        	case EXISTING_CONTAINER: {
	        	EObject container = EmfUtil.loadModel(outUri, resSet);
	            if(container == null) {
	                throw new MdaException("No object at " + outUri); //$NON-NLS-1$
	            }
	            
		        EStructuralFeature feature = container.eClass().getEStructuralFeature(targetData.getFeature());
		        if(feature instanceof EReference == false) {
	                throw new MdaException("Reference " + targetData.getFeature() + " not found in " + container); //$NON-NLS-1$ //$NON-NLS-2$
		        }

        		for (EObject out : extent.getAllRootElements()) {
			        EReference ref = (EReference)feature;
			        if(!ref.isMany()) {
			        	container.eSet(ref, out);
			        }
			        else {
			        	EList<EObject> value = (EList<EObject>) container.eGet(feature);
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
        		
		        try {
		        	saveResource(container);
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
        
        org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils.refresh(outUri);
    }

	private static void confineInResource(ModelExtentContents extent, TargetUriData targetData, ResourceSet resSet) throws MdaException {    	
    	URI outUri = toUri(targetData.getUriString());
    	
        switch(targetData.getTargetType()) {
        	case NEW_MODEL: {
       	    	Resource outExtent = resSet.getResource(outUri, false);
       	    	if(outExtent == null) {
       	    		outExtent = EmfUtil.createResource(outUri, resSet);       	    	
       	    	} else {
       	    		outExtent.getContents().clear();
       	    	}
       			outExtent.getContents().addAll(extent.getAllRootElements());
       			resSet.getResources().add(outExtent);
        		break;
        	}
        }
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
