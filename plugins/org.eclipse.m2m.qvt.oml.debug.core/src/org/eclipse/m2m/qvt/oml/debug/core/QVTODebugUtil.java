package org.eclipse.m2m.qvt.oml.debug.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

public class QVTODebugUtil {
	
	private QVTODebugUtil() {
		super();
	}

	public static List<IFile> toFile(URI uri) {
		if(uri.isPlatformResource()) {
			String platformString = uri.toPlatformString(true);
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformString));
			if(file.exists()) {
				return Collections.singletonList(file);
			}
		} else if(uri.isFile()) {
			java.net.URI javaURI;
			try {
				javaURI = java.net.URI.create(uri.toString());
			} catch(IllegalArgumentException e) {
				// not a valid EMF uri, can't look for IFile
				QVTODebugCore.log(e);
				return Collections.emptyList();
			}
			
			IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(javaURI);
			List<IFile> result = new ArrayList<IFile>(files.length);
			
			for (IFile nextFile : files) {
				if(nextFile.exists()) {
					result.add(nextFile);
				}
			}
		}
		return Collections.emptyList();
	}
	
	public static void refreshInWorkspace(List<URI> uris) {
		Set<IContainer> containers = new HashSet<IContainer>();
		for (URI nextURI : uris) {
			List<IFile> files = toFile(nextURI);
			for (IFile iFile : files) {
				containers.add(iFile.getParent());
			}
		}

		for (IContainer iContainer : containers) {
			try {
				iContainer.refreshLocal(IResource.DEPTH_ONE, null);		
			} catch (CoreException e) {
				QVTODebugCore.log(e.getStatus());
			}			
		}
	}
	
	public static URI toFileURI(String uriStr) {
		URI uri = URI.createURI(uriStr);
		if(uri.isPlatformResource()) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
			uri = URI.createURI(file.getLocationURI().toString());
		}
 		return uri;
	}
	
	public static URI toPlatformPluginURI(String uriStr) {
		URI result = URI.createURI(uriStr);
		if(result.isPlatformResource()) {
			result = URI.createPlatformPluginURI(result.toPlatformString(true), true);
		}
		return result;
	}
	
	public static URI toPlatformResourceURI(String uriStr) {
		URI result = URI.createURI(uriStr);
		if(result.isPlatformPlugin()) {
			result = URI.createPlatformResourceURI(result.toPlatformString(true), true);
		}
		return result;	
	}
	
	public static IStatus createDebugError(String message, Throwable throwable) {
		return QVTODebugCore.createStatus(IStatus.ERROR, message, throwable);
	}
	
	public static IStatus createDebugError(String message) {
		return QVTODebugCore.createStatus(IStatus.ERROR, message, null);
	}	
}
