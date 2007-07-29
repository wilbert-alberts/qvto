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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.osgi.util.NLS;

import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IMetamodelHandler;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.MetamodelHandlerManager;

public class QvtValidator {

	private QvtValidator() {		
	}

	public static IStatus validateTransformation(QvtTransformation transformation, String sourceModelUri, TargetUriData targetData, String traceFilePath, boolean useTrace) {
	    EClass inCls = null;
	    EClass outCls = null;
	    try {
	        inCls = transformation.getIn();
	        outCls = transformation.getOut();
	        IStatus result = StatusUtil.makeOkStatus();
	        
	        if(inCls == null || outCls == null) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_EmptyInput, transformation.getModuleName()));
	        }
	
	        URI sourceUri = EmfUtil.makeUri(sourceModelUri);
	        EObject in = EmfUtil.loadModel(sourceUri, inCls.eResource().getResourceSet());
	        if(in == null) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidSourceUri, sourceModelUri));
	        }
	        
	    	if(!EmfUtil.isAssignableFrom(inCls, in.eClass())) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputTypes, 
	            		EmfUtil.getFullName(in.eClass(), "::"), //$NON-NLS-1$
	            		EmfUtil.getFullName(inCls, "::") //$NON-NLS-1$                		
	            		));
	    	}
	        
	        IStatus canRun = transformation.canRun(in);
	        if (StatusUtil.isError(canRun)) {
	        	return canRun;
	        }
	        if (canRun.getSeverity() > result.getSeverity()) {
	    		result = canRun;
	    	}
	        
	        IMetamodelHandler handler = MetamodelHandlerManager.getInstance().getHandler(transformation.getOut());
	        if(handler == null) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_UnsupportedDestination, targetData.getUriString()));
	        }
	        
	        switch(targetData.getTargetType()) {
	        case NEW_MODEL: {
	            URI destUri = EmfUtil.makeUri(targetData.getUriString());
	            if(destUri == null) {
	                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidTargetUri, targetData.getUriString()));
	            }
	            
	            IFile file = org.eclipse.m2m.qvt.oml.emf.util.URIUtils.getFile(destUri);
	            if(file != null && file.exists()) {
	                if(result.getSeverity() < IStatus.WARNING) {
	                    result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationExists, destUri));
	                }
	            }
	            
	        	IStatus canSave = handler.getSaver().canSave(in, transformation.getOut(), destUri); 
	            if(StatusUtil.isError(canSave)) {
	            	return canSave;
	            }
	            if (canSave.getSeverity() > result.getSeverity()) {
	        		result = canSave;
	        	}
	            
	            if(destUri.hasFragment()) {
	                if(result.getSeverity() < IStatus.WARNING) {
	                    result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_NewDestinationHasFragment, destUri.fragment()));
	                }
	            }
	
	            break;
	        }
	        
	        case EXISTING_CONTAINER: {
	            URI destUri = EmfUtil.makeUri(targetData.getUriString());
	            if(destUri == null) {
	                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidTargetUri, targetData.getUriString()));
	            }
	        	
	        	EObject cont = EmfUtil.loadModel(destUri);
	        	if(cont == null) {
	                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidTargetUri, destUri));
	        	}
	        	
	        	if(targetData.getFeature() == null) {
	                return StatusUtil.makeErrorStatus(Messages.QvtValidator_NoFeature);
	        	}
	        	
	        	EStructuralFeature feature = cont.eClass().getEStructuralFeature(targetData.getFeature());
	        	if(feature instanceof EReference == false) {
	                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidFeature, targetData.getFeature()));
	        	}
	        	
	        	EReference ref = (EReference)feature;
	        	if(!ref.isChangeable()) {
	                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidFeature, ref.getName())); 
	        	}
	        	
	        	EClass transformationType = transformation.getOut();
	        	EClassifier refType = ref.getEType();
	        	if(!EmfUtil.isAssignableFrom(refType, transformationType)) {
	                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputTypes, EmfUtil.getFullName(transformationType, "::"), EmfUtil.getFullName(refType, "::"))); //$NON-NLS-1$ //$NON-NLS-2$
	        	}
	        	 
	            break;
	        }
	        
	        case INPLACE: {
	        	EClass transformationType = transformation.getOut();
	        	if(!EmfUtil.isAssignableFrom(inCls, transformationType)) {
	                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputTypes, EmfUtil.getFullName(transformationType, "::"), EmfUtil.getFullName(inCls, "::"))); //$NON-NLS-1$ //$NON-NLS-2$ 
	        	}
	        		            	        	
	        	break;
	        }
	        }
	
	        if (useTrace) {
	            if (traceFilePath == null || traceFilePath.length() == 0) {
	                return StatusUtil.makeErrorStatus(Messages.QvtValidator_NoTraceFile);
	            }
	            else {
	                IWorkspace workspace = ResourcesPlugin.getWorkspace();
	                IStatus status = workspace.validatePath(traceFilePath, IResource.FILE);
	                if(StatusUtil.isError(status)) {
	                    return status;
	                }
	                
	                if (!traceFilePath.endsWith(".oqvttrace")) { //$NON-NLS-1$
	                    if(result.getSeverity() < IStatus.WARNING) {
	                        result = StatusUtil.makeWarningStatus(Messages.QvtValidator_NoTraceFileExtension);
	                    }
	                }
	            }
	        }
	        
	        return result;
	    }
	    catch(Exception e) {
	        return StatusUtil.makeErrorStatus(e.getMessage(), e);
	    }
	}
}
