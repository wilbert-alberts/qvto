/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation
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
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.osgi.util.NLS;

public class QvtValidator {

	private QvtValidator() {		
	}

	public static IStatus validateTransformation(QvtTransformation transformation, List<TargetUriData> targetUris, String traceFilePath,
			boolean useTrace) throws MdaException {
        IStatus result = StatusUtil.makeOkStatus();
        
        if (!transformation.hasEntryOperation()) {
            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_TransformaionMissedEntryOp,
            		transformation.getModuleName()));
        }
        
        Iterator<TargetUriData> itrTargetData = targetUris.iterator();
		for (TransformationParameter transfParam : transformation.getParameters()) {
			if (!itrTargetData.hasNext()) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_EmptyInputTransfParam,
	            		transfParam.getName()));
			}
			IStatus nextStatus = validateTransformationParameter(transfParam, itrTargetData.next(), transformation.getResourceSet());
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
	
	public static IStatus validateTransformation(QvtTransformation transformation, List<ModelContent> inModels,
			String traceFileName) throws MdaException {
        IStatus result = StatusUtil.makeOkStatus();

        if (!transformation.hasEntryOperation()) {
            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_TransformaionMissedEntryOp,
            		transformation.getModuleName()));
        }
        
        Iterator<ModelContent> itrInObjs = inModels.iterator();
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
			ModelContent obj = itrInObjs.next();
			if (obj != null && !obj.getContent().isEmpty()) {
				superfluousParams.append(EmfUtil.getFullName(obj.getContent().get(0).eClass()));
			}
		}
		if (superfluousParams.length() > 0) {
			return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_SuperfluousInputTransfParam, superfluousParams.toString()));
		}

    	IStatus traceStatus = validateTrace(traceFileName, traceFileName != null); 
        if (StatusUtil.isError(traceStatus)) {
        	return traceStatus;
        }
        if (traceStatus.getSeverity() > result.getSeverity()) {
    		result = traceStatus;
    	}
		
        return result;
	}
	
	private static IStatus validateTransformationParameter(TransformationParameter transfParam, TargetUriData targetData, ResourceSet validationRS) {
		if (transfParam.getDirectionKind() == DirectionKind.IN) {
			return validateTransformationParameterIn(transfParam, targetData, validationRS);
		}
		if (transfParam.getDirectionKind() == DirectionKind.INOUT) {
			return validateTransformationParameterInOut(transfParam, targetData, validationRS);
		}
		return validateTransformationParameterOut(transfParam, targetData, validationRS);
	}
	
	private static IStatus validateTrace(String traceFilePath, boolean useTrace) {
	    try {
	        IStatus result = StatusUtil.makeOkStatus();
	        if (useTrace) {
	            if (traceFilePath == null || traceFilePath.length() == 0) {
	                return StatusUtil.makeErrorStatus(Messages.QvtValidator_NoTraceFile);
	            }
	            else {
	            	IFile workspaceFile = null;
	            	try {
	            		URI traceUri = URI.createURI(traceFilePath);
	            		workspaceFile = WorkspaceUtils.getWorkspaceFile(traceUri);
	            	} catch (RuntimeException ex) {
                        IStatus status = StatusUtil.makeErrorStatus("internal_error", ex); //$NON-NLS-1$
                        return status;
	            	}
	            	if (workspaceFile == null) {
	            	    IStatus status = StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_TraceNotInWorkspace, traceFilePath));
	            	    return status;
	            	} else {
	            	    IProject project = workspaceFile.getProject();
	            	    if ((project == null) || !project.isOpen()) {
	                        String name = (project == null) ? "" : project.getName(); //$NON-NLS-1$
	                        IStatus status = StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_TraceProjectNotOpen, name));
	                        return status;
	            	    }
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

	private static IStatus validateTransformationParameterIn(TransformationParameter transfParam, TargetUriData targetData, ResourceSet validationRS) {
		if (transfParam.getMetamodels().isEmpty()) {
            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_EmptyInputTransfParam,
            		transfParam.getName()));
		}

		if (transfParam.getEntryType() != null) {
			EClassifier classifier = transfParam.getEntryType();

			URI sourceUri = EmfUtil.makeUri(targetData.getUriString());
	        EObject in = null;
	        ResourceSet rs = (classifier.eResource() != null && classifier.eResource().getResourceSet() != null ? classifier.eResource().getResourceSet() : validationRS);
	        try {
	        	ModelContent loadModel = EmfUtil.loadModel(sourceUri, rs);
	        	in = (loadModel != null && !loadModel.getContent().isEmpty() ? loadModel.getContent().get(0) : null);
	        }
	        catch (Exception e) {
	        }
	        if (in == null) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidSourceUri, targetData.getUriString(), transfParam.getName()));
	        }
	        ResourceSet inputRs = (rs == null ? in.eResource().getResourceSet() : null);
	        try {
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
	        finally {
	        	if (inputRs != null) {
	        		for (Resource res : inputRs.getResources()) {
	        			res.unload();
	        		}
	        	}
	        }
		}
		else {
			EPackage metamodel = transfParam.getMetamodels().get(0);

			URI sourceUri = EmfUtil.makeUri(targetData.getUriString());
	        ModelContent in = null;
	        ResourceSet rs = (metamodel.eResource() != null && metamodel.eResource().getResourceSet() != null ? metamodel.eResource().getResourceSet() : validationRS);
	        try {
	        	in = EmfUtil.loadModel(sourceUri, rs);
	        }
	        catch (Exception e) {
	        }
	        if (in == null) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidSourceUri, targetData.getUriString(), transfParam.getName()));
	        }
	        ResourceSet inputRs = (rs == null ? in.getResourceSet() : null);
	        try {
	        	in = in.getResolvedContent(metamodel);
	        }
	        catch (WrappedException e) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidSourceUri, targetData.getUriString(), transfParam.getName()));
	        }
	        finally {
	        	if (inputRs != null) {
	        		for (Resource res : inputRs.getResources()) {
	        			res.unload();
	        		}
	        	}
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

	private static IStatus validateTransformationParameterIn(TransformationParameter transfParam, ModelContent in) {
		if (transfParam.getMetamodels().isEmpty()) {
            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_EmptyInputTransfParam,
            		transfParam.getName()));
		}

		if (transfParam.getEntryType() != null) {
			EClassifier classifier = transfParam.getEntryType();
			EObject inObj = (in != null && !in.getContent().isEmpty() ? in.getContent().get(0) : null);

	    	if (inObj == null) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputTypes, 
	            		"<null>", //$NON-NLS-1$
	            		EmfUtil.getFullName(classifier)
	            		));
	    	}
	    	else if (!EmfUtil.isAssignableFrom(classifier, inObj.eClass()) || !classifier.isInstance(inObj)) {
	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputTypes, 
	            		EmfUtil.getFullName(inObj.eClass()),
	            		EmfUtil.getFullName(classifier)
	            		));
	    	}
		}
		else {
//			EPackage metamodel = transfParam.getMetamodels().get(0);
//
//	        if (EcoreUtil.getRootContainer(in.eClass()) != metamodel) {
//	            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_IncompatibleInputMetamodels, 
//	            		EmfUtil.getFullName(in.eClass()),
//	            		EmfUtil.getMetamodelName(metamodel)
//	            		));
//	        }
		}
		
		return StatusUtil.makeOkStatus();
	}

	private static IStatus validateTransformationParameterInOut(TransformationParameter transfParam, TargetUriData targetData, ResourceSet validationRS) {
		IStatus result = validateTransformationParameterIn(transfParam, targetData, validationRS);
		if (result.getSeverity() >= IStatus.WARNING) {
			return result;
		}

		URI sourceUri = URI.createURI(targetData.getUriString());
    	IFile file = WorkspaceUtils.getWorkspaceFile(sourceUri);
    	if (file != null && file.exists() && file.isReadOnly()) {
            if (result.getSeverity() < IStatus.WARNING) {
            	result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationReadonly, sourceUri));
            }
    	}
		
		EClassifier classifier = transfParam.getEntryType();
		if (classifier == null) {
			classifier = transfParam.getMetamodels().get(0).eClass();
		}

        IStatus canSave = canSave(classifier, sourceUri); 
        if (StatusUtil.isError(canSave)) {
        	return canSave;
        }
    	
		return result;
	}

	private static IStatus validateTransformationParameterOut(TransformationParameter transfParam, TargetUriData targetData, ResourceSet validationRS) {
		if (transfParam.getMetamodels().isEmpty()) {
            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_EmptyInputTransfParam,
            		transfParam.getName()));
		}

		EClassifier classifier = transfParam.getEntryType();
		if (classifier == null) {
			classifier = transfParam.getMetamodels().get(0).eClass();
		}

        URI destUri = EmfUtil.makeUri(targetData.getUriString());
        if (destUri == null) {
            return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidTargetUri, targetData.getUriString()));
        }
        
        IStatus result = StatusUtil.makeOkStatus();
        switch(targetData.getTargetType()) {
        case NEW_MODEL: {
            IFile file = WorkspaceUtils.getWorkspaceFile(destUri);
            if (file != null && file.exists()) {
                if (result.getSeverity() < IStatus.WARNING) {
                	if (EmfUtil.isUriExisted(targetData.getUriString(), validationRS)) {
                		result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationExists, destUri));
                	}
                	else {
                		result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationExistsNonEObject, destUri));
                	}
                }
            }
            
        	IStatus canSave = canSave(classifier, destUri); 
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
        	ModelContent loadModel = EmfUtil.loadModel(destUri);
        	EObject eContainer = (loadModel != null && !loadModel.getContent().isEmpty() ? loadModel.getContent().get(0) : null);
        	if (eContainer == null) {
                return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_InvalidTargetUri, destUri));
        	}
        	
        	IFile file = WorkspaceUtils.getWorkspaceFile(destUri);
        	if (file != null && file.exists() && file.isReadOnly()) {
                if (result.getSeverity() < IStatus.WARNING) {
                	result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationReadonly, destUri));
                }
        	}
        	
        	IStatus canSave = canSave(classifier, destUri); 
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
	        	EStructuralFeature eFeature = eContainer.eClass().getEStructuralFeature(feature);
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

    private static IStatus canSave(EClassifier cls, URI destUri) {
        ResourceSet outputRS = EmfUtil.getOutputResourceSet();
		URI converted = outputRS.getURIConverter().normalize(destUri);
		
		IStatus okStatus = StatusUtil.makeOkStatus();
		String scheme = converted.scheme();
		if (converted.isFile()) {
			if (!"file".equals(scheme) && !"platform".equals(scheme)) { //$NON-NLS-1$ //$NON-NLS-2$
				return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_UriNotFile, new Object[] {destUri, scheme}));
			}
		}
		return okStatus;
		/*
		else {
			if ("archive".equals(scheme)) { //$NON-NLS-1$
				return okStatus;  
			}
			else if (converted.isPlatformResource()) {
				return okStatus;
			}
//			else if (isEFSScheme(scheme)) {
//				return true;
//			}
			else {
				try	{
					URL url = new URL(destUri.toString());
					url.openConnection();
					return okStatus;
				}
				catch (MalformedURLException e) {
				}
				catch (IOException e) {
				}
			}
		}
		return StatusUtil.makeErrorStatus(NLS.bind(Messages.QvtValidator_UriCorrupted, destUri));
		*/
    }
	
}
