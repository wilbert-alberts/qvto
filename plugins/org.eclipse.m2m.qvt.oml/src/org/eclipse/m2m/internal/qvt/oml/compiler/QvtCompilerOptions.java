/*******************************************************************************
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.compiler;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalVisitorCS;

/**
 * @author aigdalov
 * Created on Aug 10, 2007
 */

public class QvtCompilerOptions {
    private boolean isReportErrors = true;
    private boolean isShowAnnotations = true;
    private boolean isGenerateCompletionData = true;
    private boolean isSourceLineNumbersEnabled = true;    
    private QvtOperationalVisitorCS myQvtOperationalVisitorCS = null;
    private ResourceSet myMetamodelResourceSet = null;
    
    public boolean isReportErrors() {
        return isReportErrors;
    }
    
    public void setReportErrors(boolean reportErrors) {
        isReportErrors = reportErrors;
    }
    
    public boolean isGenerateCompletionData() {
        return isGenerateCompletionData;
    }
    
    public void setGenerateCompletionData(boolean generateCompletionData) {
        isGenerateCompletionData = generateCompletionData;
    }

    public boolean isShowAnnotations() {
        return isShowAnnotations;
    }

    public void setShowAnnotations(boolean showAnnotations) {
        isShowAnnotations = showAnnotations;
    }

    public QvtOperationalVisitorCS getQvtOperationalVisitorCS() {
        return myQvtOperationalVisitorCS;
    }

    public void setQvtOperationalVisitorCS(QvtOperationalVisitorCS qvtOperationalVisitorCS) {
        myQvtOperationalVisitorCS = qvtOperationalVisitorCS;
    }

    /**
	* Sets a flag, whether the line numbers from the source should be available in runtime.
	*/    
    public void setSourceLineNumbersEnabled(boolean isEnableSourceLineNumbers) {
		this.isSourceLineNumbersEnabled = isEnableSourceLineNumbers;
	}
    
    /**
	* Inidicates whether line numbers from the source should be available in runtime.
	*/
    public boolean isSourceLineNumbersEnabled() {
		return isSourceLineNumbersEnabled;
	}

    public ResourceSet getMetamodelResourceSet() {
        return myMetamodelResourceSet;
    }

    public void setMetamodelResourceSet(ResourceSet metamodelResourceSet) {
        myMetamodelResourceSet = metamodelResourceSet;
    }
}