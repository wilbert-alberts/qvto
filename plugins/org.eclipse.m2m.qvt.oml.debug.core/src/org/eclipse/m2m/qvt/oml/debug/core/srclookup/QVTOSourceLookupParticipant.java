/*******************************************************************************
 * Copyright (c) 2009 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core.srclookup;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugUtil;
import org.eclipse.m2m.qvt.oml.debug.core.QVTOStackFrame;


public class QVTOSourceLookupParticipant extends AbstractSourceLookupParticipant {
		
	private Map<URI, URI> fPlatformPluginMap;
	
	public QVTOSourceLookupParticipant() {
		super();
	}
	
    public String getSourceName(Object object) throws CoreException {    	
    	if (object instanceof QVTOStackFrame) {
			QVTOStackFrame frame = (QVTOStackFrame) object;
			URI unitURI = frame.getUnitURI();

			IFile sourceFile = findSourceFile(unitURI);
			if(sourceFile != null) {
				return sourceFile.getProjectRelativePath().toString();
			}
        } 
        
        return null;
    }
    
    @Override
    public void dispose() {
    	super.dispose();
    	fPlatformPluginMap = null;
    }

	private IFile findSourceFile(URI unitURI) {
		IFile sourceFile = QVTODebugUtil.toFile(unitURI);
		
		if(sourceFile == null && unitURI.isPlatformPlugin() && unitURI.segmentCount() > 2) {
			URI baseURI = unitURI.trimSegments(unitURI.segmentCount() - 2);

			// key requires trailing slash
			URI key = baseURI.appendSegment(""); //$NON-NLS-1$
			URI mappedBaseURI = getPlatformPluginMap().get(key);
			if(mappedBaseURI == null) {
				mappedBaseURI = getPlatformPluginMap().get(baseURI);
			}

			if(mappedBaseURI != null) {
				List<String> segmentsList = unitURI.segmentsList();				
				segmentsList = segmentsList.subList(2, segmentsList.size());
				URI mappedURI = mappedBaseURI.appendSegments(segmentsList.toArray(new String[segmentsList.size()]));			
				sourceFile = QVTODebugUtil.toFile(mappedURI);
			}
		}
		
		return sourceFile;
	}

	private Map<URI, URI> getPlatformPluginMap() {
		if(fPlatformPluginMap == null) {
			fPlatformPluginMap = EcorePlugin.computePlatformPluginToPlatformResourceMap();
		}
		return fPlatformPluginMap;
	}
}
