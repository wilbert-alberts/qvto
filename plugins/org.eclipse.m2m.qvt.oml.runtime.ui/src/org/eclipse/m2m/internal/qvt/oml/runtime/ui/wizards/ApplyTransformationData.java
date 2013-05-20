/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;



public class ApplyTransformationData {
    public ApplyTransformationData() {
        myTransformation = null;
        mySource = null;
        mySourceUri = null;
        myTargetData = null;
        myTraceFile = null;
        myOpenEditor = false;
        myUseTraceFile = false;
        myConfiguration = null;
    }
    
    public boolean isOpenEditor() {
        return myOpenEditor;
    }
    
    public ApplyTransformationData setOpenEditor(boolean openEditor) {
        myOpenEditor = openEditor;
        return this;
    }

    public EObject getSource() {
        return mySource;
    }

    public URI getSourceUri() {
        return mySourceUri;
    }
    
    public ApplyTransformationData setSourceAndUri(EObject source, URI sourceUri) {
        mySource = source;
        mySourceUri = sourceUri;
        return this;
    }
    
    public TargetUriData getTargetData() {
        return myTargetData;
    }
    
    public ApplyTransformationData setTargetData(TargetUriData targetData) {
        myTargetData = targetData;
        return this;
    }
    
    public IPath getTraceFilePath() {
        return myTraceFile;
    }
    
    public ApplyTransformationData setTraceFilePath(IPath traceFile) {
        myTraceFile = traceFile;
        return this;
    }
    
    public QvtTransformation getTransformation() {
        return myTransformation;
    }
    
    public ApplyTransformationData setTransformation(QvtTransformation transformation) {
        myTransformation = transformation;
        return this;
    }
    
    public boolean isUseTraceFile() {
        return myUseTraceFile;
    }

    public void setUseTraceFile(boolean myUseTraceFile) {
        this.myUseTraceFile = myUseTraceFile;
    }
    
    public Map<String, String> getConfiguration() {
        if (myConfiguration == null) {
            myConfiguration = new HashMap<String, String>();
        }
        return myConfiguration;
    }
    
    public boolean isConfigurationSet() {
        return myConfiguration != null;
    }
    
    private QvtTransformation myTransformation;
    private EObject mySource; // both obj and uri for source as myuml fails to provide correct uri via EcoreUtil::getUri()
    private URI mySourceUri;
    private TargetUriData myTargetData;
    private IPath myTraceFile;
    private boolean myOpenEditor;
    private boolean myUseTraceFile;
    private Map<String, String> myConfiguration;
}
