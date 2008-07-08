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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam.ResourceEObject;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.EmfUtilUiPlugin;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.IGotoMarker;


public class ResourceSaver implements IResultSaver{
    public IStatus canSave(EClassifier cls, URI destUri) {
        ResourceSet outputRS = EmfUtil.getOutputResourceSet();
		URI converted = outputRS.getURIConverter().normalize(destUri);
		
		IStatus okStatus = new Status(IStatus.OK, EmfUtilUiPlugin.ID, IStatus.OK, "", null);//$NON-NLS-1$
		String scheme = converted.scheme();
		if (converted.isFile()) {
			if (!"file".equals(scheme) && !"platform".equals(scheme)) { //$NON-NLS-1$ //$NON-NLS-2$
				return new Status(IStatus.ERROR, EmfUtilUiPlugin.ID, IStatus.ERROR, Messages.format(Messages.ResourceSaver_UriNotFile, new Object[] {destUri, scheme}), null);
			}
		}
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
    	return new Status(IStatus.ERROR, EmfUtilUiPlugin.ID, IStatus.ERROR, NLS.bind(Messages.ResourceSaver_UriCorrupted, destUri), null);
    }
    	
    public void clean(URI destUri) throws Exception {
        IFile file = org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils.getFile(destUri);
        if(file == null) {
            return;
        }
        
        file.delete(true, true, null);
    }
    
    public boolean select(EObject obj, IWorkbenchPage page) {
        Resource resource = obj.eResource();
        if(resource == null) {
            return false;
        }
        
        IFile file = getFile(resource);
        if(file == null || !file.exists()) {
            return false;
        }
        
        IEditorPart part = null;
        
        IEditorDescriptor defaultEditorDescriptor = IDE.getDefaultEditor(file);
        if (defaultEditorDescriptor == null) {
        	return false;
        }
        String defaultID = defaultEditorDescriptor.getId();
		if (EditorsUI.DEFAULT_TEXT_EDITOR_ID.equals(defaultID)) {
			part = openEditor(page, file, "org.eclipse.emf.ecore.presentation.ReflectiveEditorID"); //$NON-NLS-1$
        }
		if (part == null) {
			part = openEditor(page, file, defaultID);
		}
		if (part == null) {
			return false;
		}
        if(part instanceof IGotoMarker == false) {
            return true;
        }
        
        if (obj instanceof ResourceEObject && !((ResourceEObject) obj).getChildren().isEmpty()) {
        	obj = ((ResourceEObject) obj).getChildren().get(0);
        }
        IGotoMarker gotoMarker = (IGotoMarker) part;
        gotoMarker.gotoMarker(makeMarker(obj));

        return true;
    }

	private IEditorPart openEditor(IWorkbenchPage page, IFile file, String id) {
		try {
			return IDE.openEditor(page, file, id, true);
		} 
		catch (PartInitException e) {
			// ignore
		}
		return null;
	}
    
    public URI getUri(EObject obj) {
        return obj == null ? null : EcoreUtil.getURI(obj);
    }
    
    public static IFile getFile(EObject obj) {
        URI uri = EcoreUtil.getURI(obj);
        return org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils.getFile(uri);
    }
    
    public static IFile getFile(Resource resource) {
        ResourceSet set = resource.getResourceSet();
        URI uri;
        if(set != null) {
            uri = set.getURIConverter().normalize(resource.getURI());
        }
        else {
            uri = resource.getURI();
        }
         
        return org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils.getFile(uri);
    }

    private IMarker makeMarker(EObject obj) {
        ShallowMarker marker = new ShallowMarker(EValidator.MARKER);
        URI uri = EcoreUtil.getURI(obj);
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put(EValidator.URI_ATTRIBUTE, String.valueOf(uri));
        marker.setAttributes(attributes);
        
        return marker;
    }

}
