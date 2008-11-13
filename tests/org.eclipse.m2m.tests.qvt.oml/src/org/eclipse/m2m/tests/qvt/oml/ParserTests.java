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
        
        suite.addTest(new QvtLibraryASTTest());
        
        for (int i = 0; i < ourData.length; i++) {
            TestData data = ourData[i];
            suite.addTest(new TestQvtParser(data));
        }
        
        return suite;
    }
    
    public static class TestData {
        public TestData(String dir, int errCount) { this(dir, errCount, new String[0]); }
        
        public TestData(String dir, int errCount, int warnCount) {
        	this(dir, errCount, new String[0]);
        	this.myWarnCount = warnCount; 
        }
        public TestData(String dir, int errCount, String... warnings) { 
            myDir = dir; 
            myErrCount = errCount; 
            myWarnings = warnings;
            myWarnCount = warnings.length;
            usesSourceAnnotations = false;
        } 
        
        public String getDir() { return myDir; }
        public int getErrCount() { return myErrCount; }
        public String[] getWarnings() { return myWarnings; }
        
        public int getAllProblemsCount() {
			return myErrCount + myWarnCount;
		}
        
        public boolean usesSourceAnnotations() {
        	return usesSourceAnnotations;
		}
        
        private final String myDir;
        private final int myErrCount;
        private final String[] myWarnings;
        private int myWarnCount;
        private boolean usesSourceAnnotations;

        /**
         * Creates that should be check for match of compilation problems with expected problem 
         * annotation in the test QVT sources 
         */
        public static TestData createSourceChecked(String dir, int errCount, int warnCount) {
        	TestData data = new TestData(dir, errCount, warnCount);
        	data.usesSourceAnnotations = true; 
        	return data;
        }
    }
    
    
    static TestData getTestData(String name) {
    	for (TestData data : ourData) {
			if(name.equals(data.getDir())) {
				return data;
			}
		}
    	
    	throw new IllegalArgumentException("No such testdata: " + name); //$NON-NLS-1$
    }
    
    private static TestData[] ourData = new TestData[] {
        //new TestData("orderedsetdoesnotconformtoset", 1), //$NON-NLS-1$
    	new TestData("implicitsource_ocl_234354", 6, 0),
    	TestData.createSourceChecked("duplicateModelTypeDef", 1, 0),    	
    	TestData.createSourceChecked("blackboxlib_annotation_java", 1, 1),
    	TestData.createSourceChecked("dupImportFileUnit", 0, 1),    	
    	TestData.createSourceChecked("dupImportLibrary", 0, 1),    	
    	TestData.createSourceChecked("testmodelparamtype", 3, 0),    	
    	TestData.createSourceChecked("resolvecond", 1, 0),
    	TestData.createSourceChecked("intermPropClash", 9, 0),    	    	
    	TestData.createSourceChecked("noClassInImplicitPopulate", 3, 0),    	
    	TestData.createSourceChecked("parmnamesclash", 22, 0),
    	TestData.createSourceChecked("stdlibElementAsOut", 7, 0),    	
        TestData.createSourceChecked("bug2732_wrongcondition", 1, 1), //$NON-NLS-1$      
        TestData.createSourceChecked("varscope", 10, 0), //$NON-NLS-1$      
    	TestData.createSourceChecked("_while", 10, 1), //$NON-NLS-1$
    	TestData.createSourceChecked("implicitCallSrc", 20, 4), //$NON-NLS-1$    	
    	new TestData("assert_log", 0), //$NON-NLS-1$    	
        new TestData("opersignatureparamclash", 1), //$NON-NLS-1$    	
        new TestData("collectreturntype", 0), //$NON-NLS-1$
        new TestData("nocollectoncollection", 0), //$NON-NLS-1$
        	///Commented out, due to migration to OCL 1.2, TODO - clarify the current error reporting with MDT, seems to be incorrect
        	// new TestData("nonstaticcallinstaticcontext", 1), //$NON-NLS-1$ 
        new TestData("virtrettypemismatch", 1), //$NON-NLS-1$
        new TestData("missinglibmmimport", 1), //$NON-NLS-1$
        new TestData("noglobalallinstances", 0), //$NON-NLS-1$ 
        new TestData("imp", 0), //$NON-NLS-1$ // TODO: independent parsing for imports
        new TestData("imp2", 0), //$NON-NLS-1$
        new TestData("imp3", 0), //$NON-NLS-1$
        TestData.createSourceChecked("impError", 3, 0), //$NON-NLS-1$        
        new TestData("assignereadonlyprop", 1), //$NON-NLS-1$
        new TestData("nonbooleanguard", 1), //$NON-NLS-1$
        TestData.createSourceChecked("sameparamname", 2, 0), //$NON-NLS-1$
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
        TestData.createSourceChecked("wrongout", 3, 0), //$NON-NLS-1$
        new TestData("outininitvar", 0), //$NON-NLS-1$
        new TestData("modifyfeature", 0), //$NON-NLS-1$
        new TestData("missingout", 2), //$NON-NLS-1$
        new TestData("modifyfeatureerror", 2), //$NON-NLS-1$
        new TestData("bodywithsemicolon", 0), //$NON-NLS-1$
        new TestData("modifyparam", 0), //$NON-NLS-1$
        new TestData("wrongparamnameinout", 4), //$NON-NLS-1$
        new TestData("modifyfeatureininiterror", 3), //$NON-NLS-1$
        TestData.createSourceChecked("voidout", 2, 0), //$NON-NLS-1$
        new TestData("modifyinparam", 1), //$NON-NLS-1$
        new TestData("modifyresult", 0), //$NON-NLS-1$
        new TestData("wrongorderininit", 1), //$NON-NLS-1$
        new TestData("duplicateinitvariable", 1), //$NON-NLS-1$
        TestData.createSourceChecked("missingObjectType", 2, 0), // replaced former 'nestedouterror'
        new TestData("emptyinit", 0), //$NON-NLS-1$
        new TestData("assignresultininit", 0), //$NON-NLS-1$
        new TestData("assign_inoutParam", 2), //$NON-NLS-1$
        new TestData("assign_inParam", 2), //$NON-NLS-1$
        new TestData("assign_varThis", 1), //$NON-NLS-1$                        
        
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
        new TestData("mm_header6", 1), //$NON-NLS-1$
        new TestData("mm_header7", 1), //$NON-NLS-1$
        new TestData("entryOpDupl", 1), //$NON-NLS-1$
        new TestData("resolveIn_ambiguity", 0, "Mappings referred in resolveIn must not be overloaded! Several 'ENamedElement::createEClass' mappings found. All of them will participate in the resolution."), //$NON-NLS-1$ //$NON-NLS-2$
        new TestData("bug205303_2", 3), //$NON-NLS-1$
    };
}
