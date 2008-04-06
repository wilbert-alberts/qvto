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

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.IMetamodelHandler;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.MetamodelHandlerManager;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.osgi.util.NLS;

public class QvtValidator {

	private QvtValidator() {		
	}

	public static IStatus validateTransformation(QvtTransformation transformation, List<TargetUriData> targetUris, String traceFilePath, boolean useTrace) throws MdaException {
        IStatus result = StatusUtil.makeOkStatus();
        Iterator<TargetUriData> itrTargetData = targetUris.iterator();
		for (TransformationParameter transfParam : transformation.getParameters()) {
			if (!itrTargetData.hasNext()) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_EmptyInputTransfParam,
	            		transfParam.getName()));
			}
			IStatus nextStatus = validateTransformationParameter(transfParam, itrTargetData.next());
            if (nextStatus.getSeverity() > result.getSeverity()) {
        		result = nextStatus;
        	}
		}

    	IStatus traceStatus = validateTrace(traceFilePath, useTrace); 
        if (StatusUtil.isError(traceStatus)) {
        	return traceStatus;
        }
        if (traceStatus.getSeverity() > result.getSeverity()) {
    		result = traceStatus;
    	}

        return result;
	}
	
	public static IStatus validateTransformation(QvtTransformation transformation, List<EObject> inObjs) throws MdaException {
        IStatus result = StatusUtil.makeOkStatus();
        Iterator<EObject> itrInObjs = inObjs.iterator();
		for (TransformationParameter transfParam : transformation.getParameters()) {
			if (transfParam.getDirectionKind() == DirectionKind.IN
					|| transfParam.getDirectionKind() == DirectionKind.INOUT) {
				if (!itrInObjs.hasNext()) {
		            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_MissedInputTransfParam,
		            		transfParam.getName()));
				}

				IStatus nextStatus = validateTransformationParameterIn(transfParam, itrInObjs.next());
	            if (nextStatus.getSeverity() > result.getSeverity()) {
	        		result = nextStatus;
	        	}
			}
		}

		StringBuffer superfluousParams = new StringBuffer();
		while (itrInObjs.hasNext()) {
			if (superfluousParams.length() > 0) {
				superfluousParams.append(", "); //$NON-NLS-1$
			}
			superfluousParams.append(EmfUtil.getFullName(itrInObjs.next().eClass()));
		}
		if (superfluousParams.length() > 0) {
			return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_SuperfluousInputTransfParam, superfluousParams.toString()));
		}

        return result;
	}
	
	public static IStatus validateTransformationParameter(TransformationParameter transfParam, TargetUriData targetData) {
		if (transfParam.getDirectionKind() == DirectionKind.IN) {
			return validateTransformationParameterIn(transfParam, targetData);
		}
		if (transfParam.getDirectionKind() == DirectionKind.INOUT) {
			return validateTransformationParameterInOut(transfParam, targetData);
		}
		return validateTransformationParameterOut(transfParam, targetData);
	}
	
	public static IStatus validateTrace(String traceFilePath, boolean useTrace) {
	    try {
	        IStatus result = StatusUtil.makeOkStatus();
	        if (useTrace) {
	            if (traceFilePath == null || traceFilePath.length() == 0) {
	                return StatusUtil.makeErrorStatus(Messages.QvtValidator_NoTraceFile);
	            }
	            else {
	                IWorkspace workspace = ResourcesPlugin.getWorkspace();
	                IStatus status = workspace.validatePath(traceFilePath, IResource.FILE);
	                if (StatusUtil.isError(status)) {
	                    return status;
	                }
	                
	                if (!traceFilePath.endsWith(MDAConstants.QVTO_TRACEFILE_EXTENSION_WITH_DOT)) {
	                    if (result.getSeverity() < IStatus.WARNING) {
	                        result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_NoTraceFileExtension, MDAConstants.QVTO_TRACEFILE_EXTENSION_WITH_DOT));
	                    }
	                }
	            }
	        }
	        return result;
	    }
	    catch (Exception e) {
	        return StatusUtil.makeErrorStatus(e.getMessage(), e);
	    }
	}

	private static IStatus validateTransformationParameterIn(TransformationParameter transfParam, TargetUriData targetData) {
		if (transfParam.getMetamodels().isEmpty()) {
            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_EmptyInputTransfParam,
            		transfParam.getName()));
		}

		if (transfParam.getEntryType() != null) {
			EClassifier classifier = transfParam.getEntryType();

			URI sourceUri = EmfUtil.makeUri(targetData.getUriString());
	        EObject in = null;
	        try {
	        	in = EmfUtil.loadModel(sourceUri, classifier.eResource() != null ? classifier.eResource().getResourceSet() : null);
	        }
	        catch (Exception e) {
	        }
	        if (in == null) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidSourceUri, targetData.getUriString(), transfParam.getName()));
	        }
	        try {
	        	in = EmfUtil.resolveSource(in, classifier);
	        }
	        catch (WrappedException e) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidSourceUri, targetData.getUriString(), transfParam.getName()));
	        }
			
	    	if (!EmfUtil.isAssignableFrom(classifier, in.eClass()) || !classifier.isInstance(in)) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputTypes, 
	            		EmfUtil.getFullName(in.eClass()),
	            		EmfUtil.getFullName(classifier)
	            		));
	    	}
		}
		else {
			EPackage metamodel = transfParam.getMetamodels().get(0);

			URI sourceUri = EmfUtil.makeUri(targetData.getUriString());
	        EObject in = null;
	        try {
	        	in = EmfUtil.loadModel(sourceUri, metamodel.eResource() != null ? metamodel.eResource().getResourceSet() : null);
	        }
	        catch (Exception e) {
	        }
	        if (in == null) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidSourceUri, targetData.getUriString(), transfParam.getName()));
	        }
	        try {
	        	in = EmfUtil.resolveSource(in, metamodel);
	        }
	        catch (WrappedException e) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidSourceUri, targetData.getUriString(), transfParam.getName()));
	        }
	        
        	/*
        	 * See: https://bugs.eclipse.org/bugs/show_bug.cgi?id=216903 (QVT run configuration should consider all objects in selected model)
        	 * 
	        if (EcoreUtil.getRootContainer(in.eClass()) != metamodel) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputMetamodels, 
	            		EmfUtil.getFullName(in.eClass()),
	            		EmfUtil.getMetamodelName(metamodel)
	            		));
	        }
	        */
		}
		
		return StatusUtil.makeOkStatus();
	}

	private static IStatus validateTransformationParameterIn(TransformationParameter transfParam, EObject in) {
		if (transfParam.getMetamodels().isEmpty()) {
            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_EmptyInputTransfParam,
            		transfParam.getName()));
		}

		if (transfParam.getEntryType() != null) {
			EClassifier classifier = transfParam.getEntryType();

	    	if (!EmfUtil.isAssignableFrom(classifier, in.eClass()) || !classifier.isInstance(in)) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputTypes, 
	            		EmfUtil.getFullName(in.eClass()),
	            		EmfUtil.getFullName(classifier)
	            		));
	    	}
		}
		else {
			EPackage metamodel = transfParam.getMetamodels().get(0);

	        if (EcoreUtil.getRootContainer(in.eClass()) != metamodel) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputMetamodels, 
	            		EmfUtil.getFullName(in.eClass()),
	            		EmfUtil.getMetamodelName(metamodel)
	            		));
	        }
		}
		
		return StatusUtil.makeOkStatus();
	}

	private static IStatus validateTransformationParameterInOut(TransformationParameter transfParam, TargetUriData targetData) {
		IStatus result = validateTransformationParameterIn(transfParam, targetData);
		if (result.getSeverity() >= IStatus.WARNING) {
			return result;
		}

		URI sourceUri = EmfUtil.makeUri(targetData.getUriString());
    	String uriPath = sourceUri.isFile() ? sourceUri.toFileString() :
			(sourceUri.isPlatform() ? sourceUri.toPlatformString(true) : sourceUri.toString());
    	IFile file = WorkspaceUtils.getWorkspaceFile(uriPath);
    	if (file != null && file.exists() && file.isReadOnly()) {
            if (result.getSeverity() < IStatus.WARNING) {
            	result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationReadonly, sourceUri));
            }
    	}
		
		EClassifier classifier = transfParam.getEntryType();
		if (classifier == null) {
			classifier = transfParam.getMetamodels().get(0).eClass();
		}

		IMetamodelHandler handler = MetamodelHandlerManager.getInstance().getHandler(classifier);
        if (handler == null) {
            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_UnsupportedDestination, targetData.getUriString()));
        }

        IStatus canSave = handler.getSaver().canSave(classifier, sourceUri); 
        if (StatusUtil.isError(canSave)) {
        	return canSave;
        }
    	
		return result;
	}

	private static IStatus validateTransformationParameterOut(TransformationParameter transfParam, TargetUriData targetData) {
		if (transfParam.getMetamodels().isEmpty()) {
            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_EmptyInputTransfParam,
            		transfParam.getName()));
		}

		EClassifier classifier = transfParam.getEntryType();
		if (classifier == null) {
			classifier = transfParam.getMetamodels().get(0).eClass();
		}

        IMetamodelHandler handler = MetamodelHandlerManager.getInstance().getHandler(classifier);
        if (handler == null) {
            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_UnsupportedDestination, targetData.getUriString()));
        }
		
        URI destUri = EmfUtil.makeUri(targetData.getUriString());
        if (destUri == null) {
            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidTargetUri, targetData.getUriString()));
        }
        
        IStatus result = StatusUtil.makeOkStatus();
        switch(targetData.getTargetType()) {
        case NEW_MODEL: {
            IFile file = org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils.getFile(destUri);
            if (file != null && file.exists()) {
                if (result.getSeverity() < IStatus.WARNING) {
                	if (EmfUtil.isUriExisted(targetData.getUriString())) {
                		result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationExists, destUri));
                	}
                	else {
                		result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationExistsNonEObject, destUri));
                	}
                }
            }
            
        	IStatus canSave = handler.getSaver().canSave(classifier, destUri); 
            if (StatusUtil.isError(canSave)) {
            	return canSave;
            }
            if (canSave.getSeverity() > result.getSeverity()) {
        		result = canSave;
        	}
            
            if (destUri.hasFragment()) {
                if (result.getSeverity() < IStatus.WARNING) {
                    result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_NewDestinationHasFragment, destUri.fragment()));
                }
            }
            break;
        }

        case EXISTING_CONTAINER: {
        	EObject cont = EmfUtil.loadModel(destUri);
        	if (cont == null) {
                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidTargetUri, destUri));
        	}
        	
        	String uriPath = destUri.isFile() ? destUri.toFileString() :
    			(destUri.isPlatform() ? destUri.toPlatformString(true) : destUri.toString());
        	IFile file = WorkspaceUtils.getWorkspaceFile(uriPath);
        	if (file != null && file.exists() && file.isReadOnly()) {
                if (result.getSeverity() < IStatus.WARNING) {
                	result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationReadonly, destUri));
                }
        	}
        	
        	IStatus canSave = handler.getSaver().canSave(classifier, destUri); 
            if (StatusUtil.isError(canSave)) {
            	return canSave;
            }
        	
        	String feature = targetData.getFeature();
        	if (feature == null || feature.trim().length() == 0) {
                if (result.getSeverity() < IStatus.WARNING) {
                	result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationExists, destUri));
                }
        	}
        	else {
	        	EStructuralFeature eFeature = cont.eClass().getEStructuralFeature(feature);
	        	if (eFeature instanceof EReference == false) {
	                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidFeature, feature));
	        	}
	        	
	        	EReference ref = (EReference)eFeature;
	        	if (!ref.isChangeable()) {
	                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidFeature, ref.getName())); 
	        	}
	        	
	        	// no need for the check since always whole model extent is saved
//	        	EClassifier refType = ref.getEType();
//	        	if (!EmfUtil.isAssignableFrom(refType, classifier)) {
//	                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputTypes,
//	                		EmfUtil.getFullName(classifier), EmfUtil.getFullName(refType)));
//	        	}
        	}
        	
            break;
        }
        }
        
		return result;
	}

}
