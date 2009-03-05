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

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.UnitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLexer;

/**
 * @author Aleksandr Igdalov
 * Created on Oct 23, 2007
 */
public class CFileData {
    private final URI myCFile;
    private final QvtCompletionData myData;

    private QvtOpLexer myLexer;
    private UnitCS myUnitCS;
    private CompiledUnit myCompiledUnit;    
    private String myLightweightScript;
 
    public CFileData(URI unitURI, QvtCompletionData data) {
        myCFile = unitURI;
        myData = data;
    }
    
    public URI getCFile() {
        return myCFile;
    }
    
    
    public QvtOpLexer getLexer() {
        return myLexer;
    }

    public void setLexer(QvtOpLexer lexer) {
        myLexer = lexer;
    }
    
    public MappingModuleCS getMappingModuleCS() {
    	if(myUnitCS == null || myUnitCS.getModules().isEmpty()) {
    		return null;
    	}
    	// FIXME - we just follow the contract need to be adjusted to 
    	// the fact that UnitCS is the root CST
    	return myUnitCS.getModules().get(0);
    }
    
    public UnitCS getUnitCS() {
        return myUnitCS;
    }

    public void setUnitCS(UnitCS unitCS) {
        myUnitCS = unitCS;
    }
    
    public void setCompiledUnit(CompiledUnit compiledUnit) {
        myCompiledUnit = compiledUnit;
    }    

    public String getLightweightScript() {
        return myLightweightScript;
    }

    public void setLightweightScript(String lightweightScript) {
        myLightweightScript = lightweightScript;
    }
}