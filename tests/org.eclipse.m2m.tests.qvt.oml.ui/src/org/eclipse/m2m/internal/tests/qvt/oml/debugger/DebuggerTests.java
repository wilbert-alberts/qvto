/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - bugs 302594, 309762, 377882, 388325, 392080, 392153
 *                         397215, 397959, 358709, 388801, 254962
 *******************************************************************************/
package org.eclipse.m2m.internal.tests.qvt.oml.debugger;

import junit.framework.TestSuite;

import org.eclipse.m2m.tests.qvt.oml.transform.FileToFileData;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;


/**
 * @author sboyko
 */
public class DebuggerTests {

	public static TestSuite transformSuite() {
        TestSuite suite = new TestSuite("QVT debugger"); //$NON-NLS-1$

        ModelTestData[] datas = createTestData();

        for (ModelTestData data : datas) {
            suite.addTest(new DebuggerTransformation(data));
        }
        
        return suite;
    }
    
    public static ModelTestData[] createTestData() {
        return new ModelTestData[] {        		
                new DebugFileToFileData("numconversion", "in.xmi", "expected.pack").includeMetamodelFile("mm.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                new DebugFileToFileData("oclannotation", "in.ecore", "expected.xmi").includeMetamodelFile("metamodel.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$    			
                new DebugFileToFileData("FamilyXForm", "Family.xmi", "FamilyXForm.family").includeMetamodelFile("Family.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        };
    }
    
    private static class DebugFileToFileData extends FileToFileData {

		public DebugFileToFileData(String name, String fromFile, String expectedFile) {
			super(name, fromFile, expectedFile);
		}
		
		@Override
		public String getTestDataFolder() {
			return "debuggerTestData"; //$NON-NLS-1$
		}
		
		@Override
		public String getBundle() {
			return super.getBundle() + ".ui";  //$NON-NLS-1$
		}
    	
    }

}
