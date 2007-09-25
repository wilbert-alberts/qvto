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
package org.eclipse.m2m.qvt.oml.emf.util.ui.choosers;


public class DefaultMetamodelHandler implements IMetamodelHandler {
    public IResultSaver getSaver() {
        return new ResourceSaver();
    }

    public ISourceChooser getSourceChooser() {
        return new ResourceSourceChooser(false);
    }

    public ISourceChooser getSourceAdaptableChooser() {
        return new ResourceSourceChooser(true);
    }

    public IDestinationChooser getSourceDestChooser() {
        return new ResourceSourceDestChooser();
    }

    public IDestinationChooser getDestinationChooser() {
        return new ResourceDestinationChooser();
    }

    public String[] getRequiredNamespaces() {
        return new String[0];
    }
    
    public String getTitle() {
    	return Messages.emfModel;
    }
}
