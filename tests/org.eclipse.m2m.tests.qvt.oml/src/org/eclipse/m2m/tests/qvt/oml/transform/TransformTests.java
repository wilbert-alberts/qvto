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
package org.eclipse.m2m.tests.qvt.oml.transform;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.m2m.tests.qvt.oml.transform.javaless.JavalessFileToFileData;
import org.eclipse.m2m.tests.qvt.oml.transform.javaless.JavalessMetamodelProvider;
import org.eclipse.m2m.tests.qvt.oml.transform.javaless.JavalessUtil;


/**
 * @author pkobiakov
 */
public class TransformTests {
	public static Test suite() {
		return interpreterSuite();
	}
	
    public static TestSuite interpreterSuite() {
    	TestSuite suite = new TestSuite("QVT interpreter"); //$NON-NLS-1$

    	ModelTestData[] datas = createTestData();
    	
    	for (ModelTestData data : datas) {
            suite.addTest(new TestQvtInterpreter(data));
        }

        return suite;
    }
    
    public static TestSuite javalessSuite() {
    	JavalessMetamodelProvider.registerMetamodel();
        
    	TestSuite suite = new TestSuite("QVT javaless"); //$NON-NLS-1$

    	ModelTestData[] datas = createTestData();
    	
    	for (ModelTestData data : datas) {
            if(!JAVALESS_EXCLUDES.contains(data.getName()) && JavalessUtil.isValidJavalessData(data)) {
            	JavalessFileToFileData javaless = new JavalessFileToFileData(data);
            	TestQvtInterpreter test = new TestQvtInterpreter(javaless);
            	test.setName("javaless_" + test.getName()); //$NON-NLS-1$
            	suite.addTest(test);
            }
        }

        return suite;
    }
    
    public static TestSuite walkerSuite() {
        TestSuite suite = new TestSuite("QVT walker"); //$NON-NLS-1$

        ModelTestData[] datas = createTestData();
        
        for (ModelTestData data : datas) {
            suite.addTest(new TestQvtWalker(data));
        }
        
        return suite;
    }
    
    public static ModelTestData[] createTestData() {
    	return new ModelTestData[] {
    	new FileToFileData("oclannotation", "in.ecore", "expected.xmi").includeMetamodelFile("metamodel.ecore"), //$NON-NLS-1$    			
    	new FileToFileData("importedvirtuals"), //$NON-NLS-1$    	
    	new FileToFileData("ocl_test"), //$NON-NLS-1$    			
    	new FileToFileData("tuples"), //$NON-NLS-1$    			
    	new FileToFileData("oclany"), //$NON-NLS-1$    			
    	new FileToFileData("modifyvar"), //$NON-NLS-1$
    	new FileToFileData("abstractresult"), //$NON-NLS-1$
		new FileToFileData("bagorderedsetintersection"), //$NON-NLS-1$
        new FileToFileData("nullsource"), //$NON-NLS-1$ 		
        new FileToFileData("isunique"), //$NON-NLS-1$ 		
		new FileToFileData("fqntraces"), //$NON-NLS-1$ 
        
        new FileToFileData("equndefined"), //$NON-NLS-1$
        new FileToFileData("propertycollect"), //$NON-NLS-1$
        new FileToFileData("resolvenoinput"), //$NON-NLS-1$
        new FileToFileData("addundefined"), //$NON-NLS-1$
        new FileToFileData("propuseprop"), //$NON-NLS-1$
        new FileToFileData("importedprops", new String[][] { //$NON-NLS-1$
                {"t1", "some"}//$NON-NLS-1$ //$NON-NLS-2$
        }), 
        new FileToFileData("resolveall"), //$NON-NLS-1$
        new FileToFileData("egetcodegen"), //$NON-NLS-1$
        new FileToFileData("imports"), //$NON-NLS-1$
        new FileToFileData("imports_transformations"), //$NON-NLS-1$        
//        new MyUmlToFileData("libop", "manylinks", "expected.ecore"),  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    	new FileToFileData("assigntoprimfeature"), //$NON-NLS-1$    	
    	new FileToFileData("assigntonullowner"), //$NON-NLS-1$
    	new FileToFileData("firstlast"), //$NON-NLS-1$
    	new FileToFileData("accessbooleans", "testqvt.testqvt", "expected.ecore"),   //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
    	new FileToFileData("localstrings"), //$NON-NLS-1$
		new FileToFileData("castinttodouble"), //$NON-NLS-1$
		new FileToFileData("stringescaping"), //$NON-NLS-1$
        new FileToFileData("exists"), //$NON-NLS-1$
        new FileToFileData("nestednativeops"), //$NON-NLS-1$
        new FileToFileData("scr23070"), //$NON-NLS-1$
        new FileToFileData("iterateoverintset"), //$NON-NLS-1$
        new FileToFileData("addrealtostring"), //$NON-NLS-1$
        new FileToFileData("invalidcollectioncast"), //$NON-NLS-1$
        new FileToFileData("virtscr20707"), //$NON-NLS-1$
        new FileToFileData("calloclIsUndefinedforundefined"), //$NON-NLS-1$
        new FileToFileData("callvirtforundefined"),  //$NON-NLS-1$
//        new MyUmlToMyUmlData("mmlibimport", "myumlsource", "myumlsourceexp"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        new FileToFileData("omittedobject"), //$NON-NLS-1$
        new FileToFileData("omittedobjectwithinit"), //$NON-NLS-1$
        new FileToFileData("primtypesecore"), //$NON-NLS-1$
//        new FileToMyUmlData("primtypes", "in.ecore", "primtypes"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        new FileToFileData("scr21329"), //$NON-NLS-1$
        new FileToFileData("scr21121"), //$NON-NLS-1$
        new FileToFileData("scr20811"), //$NON-NLS-1$
        new FileToFileData("scr20041"), //$NON-NLS-1$
        new FileToFileData("scr20038"), //$NON-NLS-1$
        new FileToFileData("scr20667"), //$NON-NLS-1$
        new FileToFileData("scr20469"), //$NON-NLS-1$
        new FileToFileData("scr20471"), //$NON-NLS-1$
        new FileToFileData("scr19364"), //$NON-NLS-1$
        new FileToFileData("scr18739"), //$NON-NLS-1$
        new FileToFileData("scr18514", "pim.simpleuml", "expected.simpleuml"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//        new MyUmlToFileData("implicitcollect", "uml20_1", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        new FileToFileData("oclastype"),  //$NON-NLS-1$
//        new MyUmlToFileData("Uml_To_Xhtml", "uml20_1", "1.xhtml"),  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        new FileToFileData("usebooleanprop", "in.simpleuml", "expected.ecore"),  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        new FileToFileData("getpropfromundefined"), //$NON-NLS-1$ 
        new FileToFileData("javakeywords"),  //$NON-NLS-1$
        new FileToFileData("scr17812"),  //$NON-NLS-1$
        new FileToFileData("scr18783"), //$NON-NLS-1$
        new FileToFileData("boxing"), //$NON-NLS-1$
        new FileToFileData("scr18572"), //$NON-NLS-1$
//        new FileToMyUmlData("myumlnestedpacks", "in.ecore", "myumldest14", "myumlnestedpacksexp"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        new FileToFileData("propinit"),  //$NON-NLS-1$
        new FileToFileData("allinstances"),  //$NON-NLS-1$
        new FileToFileData("customop", "in.simpleuml", "expected.ecore"),  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//        new MyUmlToFileData("scr15971", "singlepack", "expected.ecore"),  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        new FileToFileData("returnundefinedfromquery"), //$NON-NLS-1$ 
        new FileToFileData("addclass"), //$NON-NLS-1$ 
        new FileToFileData("addclassviamodificationininit"), //$NON-NLS-1$ 
        new FileToFileData("addclassviaoutinocl"), //$NON-NLS-1$ 
        new FileToFileData("addclassviasequence"), //$NON-NLS-1$ 
        new FileToFileData("assignresultininit"), //$NON-NLS-1$ 
        new FileToFileData("copynameviacontextmapping"), //$NON-NLS-1$ 
        new FileToFileData("emptyout"), //$NON-NLS-1$ 
        new FileToFileData("full"), //$NON-NLS-1$ 
        new FileToFileData("invresolve_"), //$NON-NLS-1$ 
        new FileToFileData("invresolvebyrule"), //$NON-NLS-1$ 
        new FileToFileData("removeclassesinwhile"), //$NON-NLS-1$ 
        new FileToFileData("resolvebeforeoutcompletion"), //$NON-NLS-1$ 
        new FileToFileData("resolvebyrule"), //$NON-NLS-1$ 
        new FileToFileData("simple"), //$NON-NLS-1$ 
        new FileToFileData("simpleconfigproperty",  //$NON-NLS-1$ 
                new String[][] {
                {"FOO", "foo"},  //$NON-NLS-1$ //$NON-NLS-2$
        }), 
        new FileToFileData("simpleproperty"), //$NON-NLS-1$ 
        new FileToFileData("simplerename"), //$NON-NLS-1$ 
        new FileToFileData("simpleresolve"), //$NON-NLS-1$ 
        new FileToFileData("useresultinsameout"), //$NON-NLS-1$ 
        new FileToFileData("virt"), //$NON-NLS-1$ 
        new FileToFileData("overload"), //$NON-NLS-1$ 
        new FileToFileData("voidreturn"), //$NON-NLS-1$ 
        
        new FileToFileData("lateresolve", "in.simpleuml", "expected.simpleuml"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        new FileToFileData("lateresolvebyrule", "in.simpleuml", "expected.simpleuml"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        new FileToFileData("skippopulation", "in.ecore", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        new FileToFileData("iteratetest", "in.ecore", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        new FileToFileData("mapkeyword", "in.ecore", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        
        new FileToFileData("initsectresultpatch"), //$NON-NLS-1$
        new FileToFileData("endsectresultpatch"), //$NON-NLS-1$
        
//        new MyUmlToMyUmlData("uml14to20", "uml14", "uml14exp"),  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//        new MyUmlToMyUmlData("myuml", "myumlsource", "myumlsourceexp"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

        new FileToFileData("inoutcontextparam", "in.ecore", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        new FileToFileData("inoutcontextparamnoresult", "in.ecore", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        
        new FileToFileData("contextlesscall", "in.ecore", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        new FileToFileData("setundefinedtoprimitive", "in.ecore", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        new FileToFileData("varassign", "in.ecore", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        new FileToFileData("bugzilla443", "in.ecore", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        new FileToFileData("resolve_notype"), //$NON-NLS-1$        
        new FileToFileData("resolve_type"), //$NON-NLS-1$        
        new FileToFileData("resolve_vardecl"), //$NON-NLS-1$        
        new FileToFileData("resolve_vardeclcond"), //$NON-NLS-1$        
        new FileToFileData("resolve_vardeclcondwithvar"), //$NON-NLS-1$        
        new FileToFileData("resolve_resolveone"), //$NON-NLS-1$        
        new FileToFileData("resolve_resolveIn"), //$NON-NLS-1$        
        new FileToFileData("resolve_resolveoneIn"), //$NON-NLS-1$        
        new FileToFileData("resolve_invresolveoneIn"), //$NON-NLS-1$        
        new FileToFileData("resolve_lateresolveoneIn"), //$NON-NLS-1$        
        new FileToFileData("resolve_lateresolveoneInaccess"), //$NON-NLS-1$        
        new FileToFileData("resolveIn_ambiguity"), //$NON-NLS-1$        
        new FileToFileData("bug204126_1"), //$NON-NLS-1$        
        new FileToFileData("bug204126_2"), //$NON-NLS-1$        
        new FileToFileData("bug204126_3"), //$NON-NLS-1$        
        new FileToFileData("bug204126_4"), //$NON-NLS-1$        
        new FileToFileData("bug204126_5"), //$NON-NLS-1$        
        new FileToFileData("bug204126_6"), //$NON-NLS-1$        
        new FileToFileData("bug204126_7"), //$NON-NLS-1$        
        new FileToFileData("bug205303_1"), //$NON-NLS-1$        
//        new MyUmlToMyUmlData("eobjectmodelopcall", "eobjectmodelopcallsource", "eobjectmodelopcalldest"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
// */        
    	};
    }
    
    private static final Set<String> JAVALESS_EXCLUDES = new HashSet<String>(Arrays.asList(new String[] {
    	"primtypesecore", // uses getDataTypeInstance() defined on ecore //$NON-NLS-1$
    	"importedvirtuals", "imports_transformations", "imports", "virt", "full", "fqntraces", // TODO import other files //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
    	"assigntonullowner", "resolveall", // reference not in required format: eSuperTypes = "#//NEW_Class1" insteand of "//@eClassifiers.0" //$NON-NLS-1$ //$NON-NLS-2$
    	"egetcodegen", // java method can't be called//$NON-NLS-1$
    }));
}
