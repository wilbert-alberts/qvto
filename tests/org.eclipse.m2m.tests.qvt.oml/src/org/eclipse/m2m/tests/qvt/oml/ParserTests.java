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
package org.eclipse.m2m.tests.qvt.oml;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ParserTests {
    public static Test suite() {
        TestSuite suite = new TestSuite("QVT parser"); //$NON-NLS-1$
        
        for (int i = 0; i < ourData.length; i++) {
            TestData data = ourData[i];
            suite.addTest(new TestQvtParser(data));
        }
        
        return suite;
    }
    
    public static class TestData {
        public TestData(String dir, int errCount) { this(dir, errCount, new String[0]); } 
        public TestData(String dir, int errCount, String... warnings) { 
            myDir = dir; 
            myErrCount = errCount; 
            myWarnings = warnings; 
        } 
        
        public String getDir() { return myDir; }
        public int getErrCount() { return myErrCount; }
        public String[] getWarnings() { return myWarnings; }
        
        private final String myDir;
        private final int myErrCount;
        private final String[] myWarnings;
    }
    
    static TestData[] ourData = new TestData[] {
        //new TestData("orderedsetdoesnotconformtoset", 1), //$NON-NLS-1$
        new TestData("opersignatureparamclash", 1), //$NON-NLS-1$    	
        new TestData("collectreturntype", 0), //$NON-NLS-1$
        new TestData("nocollectoncollection", 0), //$NON-NLS-1$
        new TestData("nonstaticcallinstaticcontext", 1), //$NON-NLS-1$
        new TestData("virtrettypemismatch", 1), //$NON-NLS-1$
        new TestData("missinglibmmimport", 1), //$NON-NLS-1$
        new TestData("noglobalallinstances", 0), //$NON-NLS-1$ 
        new TestData("imp", 0), //$NON-NLS-1$ // TODO: independent parsing for imports
        new TestData("imp2", 0), //$NON-NLS-1$
        new TestData("imp3", 0), //$NON-NLS-1$
        new TestData("impError", 2), //$NON-NLS-1$        
        new TestData("assignereadonlyprop", 1), //$NON-NLS-1$
        new TestData("nonbooleanguard", 1), //$NON-NLS-1$
        new TestData("sameparamname", 2), //$NON-NLS-1$
        new TestData("badtype", 1), //$NON-NLS-1$
        new TestData("simple", 0),   //$NON-NLS-1$
        new TestData("selfimport", 1), //$NON-NLS-1$
        new TestData("normalimport", 0), //$NON-NLS-1$
        new TestData("missingmappingcall", 1), //$NON-NLS-1$
        new TestData("missingfeature", 1), //$NON-NLS-1$
        new TestData("featuretypemismatch", 1), //$NON-NLS-1$
        new TestData("initvariable", 1), //$NON-NLS-1$
        new TestData("missingvariablereference", 1), //$NON-NLS-1$
        new TestData("optionalout", 0), //$NON-NLS-1$
        new TestData("abstractout", 1), //$NON-NLS-1$
        new TestData("nonassignableout", 1), //$NON-NLS-1$
        new TestData("wrongout", 2), //$NON-NLS-1$
        new TestData("outininitvar", 0), //$NON-NLS-1$
        new TestData("modifyfeature", 0), //$NON-NLS-1$
        new TestData("missingout", 1), //$NON-NLS-1$
        new TestData("modifyfeatureerror", 2), //$NON-NLS-1$
        new TestData("bodywithsemicolon", 0), //$NON-NLS-1$
        new TestData("modifyparam", 0), //$NON-NLS-1$
        new TestData("wrongparamnameinout", 4), //$NON-NLS-1$
        new TestData("modifyfeatureininiterror", 4), //$NON-NLS-1$
        new TestData("voidout", 1), //$NON-NLS-1$
        new TestData("modifyinparam", 1), //$NON-NLS-1$
        new TestData("modifyresult", 0), //$NON-NLS-1$
        new TestData("wrongorderininit", 1), //$NON-NLS-1$
        new TestData("duplicateinitvariable", 1), //$NON-NLS-1$
        new TestData("nestedouterror", 1), //$NON-NLS-1$
        new TestData("emptyinit", 0), //$NON-NLS-1$
        new TestData("assignresultininit", 0), //$NON-NLS-1$
        new TestData("errorinexpressionlist", 1), //$NON-NLS-1$
        new TestData("largefile", 0), //$NON-NLS-1$
        new TestData("calldump", 0), //$NON-NLS-1$
        new TestData("missingparamname", 2), //$NON-NLS-1$
        new TestData("nameclash", 1), //$NON-NLS-1$
        new TestData("emptymodule", 0), //$NON-NLS-1$
        new TestData("props", 0), //$NON-NLS-1$
        new TestData("duplicatelocalproperty", 1), //$NON-NLS-1$
        new TestData("wrongorderinproperty", 1), //$NON-NLS-1$
        new TestData("implicitpopulation", 0), //$NON-NLS-1$
        new TestData("implicitpopulationwithinit", 0), //$NON-NLS-1$
        new TestData("mapkeyword", 0), //$NON-NLS-1$
        new TestData("endsectfull", 0), //$NON-NLS-1$
        new TestData("endsectimplicitpopulation", 0), //$NON-NLS-1$
        new TestData("endsectimplicitpopulationnoinit", 0), //$NON-NLS-1$
        new TestData("endsectinitnopopulation", 0), //$NON-NLS-1$
        new TestData("endsectonly", 0), //$NON-NLS-1$
        new TestData("endsectpopulationnoinit", 0), //$NON-NLS-1$
        new TestData("configpropstype", 0), //$NON-NLS-1$

        new TestData("mm_header1", 1), //$NON-NLS-1$
        new TestData("mm_header2", 1), //$NON-NLS-1$
        new TestData("mm_header3", 1), //$NON-NLS-1$
        new TestData("mm_header4", 1), //$NON-NLS-1$
        new TestData("mm_header5", 2), //$NON-NLS-1$
        new TestData("mm_header6", 2), //$NON-NLS-1$
        new TestData("mm_header7", 1), //$NON-NLS-1$
        new TestData("entryOpDupl", 1), //$NON-NLS-1$
        new TestData("resolveIn_ambiguity", 0, "Mappings referred in resolveIn must not be overloaded! Several 'ENamedElement::createEClass' mappings found. All of them will participate in the resolution."), //$NON-NLS-1$ //$NON-NLS-2$
    };
}
