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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion;

import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLexer;

/**
 * @author Aleksandr Igdalov
 * Created on Oct 23, 2007
 */
public class CFileData {
    private final CFile myCFile;
    private final QvtCompletionData myData;

    private QvtOpLexer myLexer;
    private MappingModuleCS myMappingModuleCS;
    private String myLightweightScript;
 
    public CFileData(CFile cFile, QvtCompletionData data) {
        myCFile = cFile;
        myData = data;
    }
    
    public CFile getCFile() {
        return myCFile;
    }
    
    
    public QvtOpLexer getLexer() {
        return myLexer;
    }

    public void setLexer(QvtOpLexer lexer) {
        myLexer = lexer;
    }
    
    public MappingModuleCS getMappingModuleCS() {
        return myMappingModuleCS;
    }

    public void setMappingModuleCS(MappingModuleCS mappingModuleCS) {
        myMappingModuleCS = mappingModuleCS;
    }

    public String getLightweightScript() {
        return myLightweightScript;
    }

    public void setLightweightScript(String lightweightScript) {
        myLightweightScript = lightweightScript;
    }
}