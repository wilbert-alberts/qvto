package org.eclipse.qvto.examples.xtext.qvtoperational.tests;


public class QVToXtextTestCase extends AbstractQVToXtextTestCase {

	
	
	public void testSimpleLoadAsString() throws Exception {
				
		String testFile =			
			"metamodel mm1 {\n" +
			"	class c1 {\n" +
			"		prop1 : String ;\n"+	
			"	};\n" +
			"	class c2 extends c1 {\n"+
			"		prop2 : c1;\n"+
			"	};\n"+
			"}";
		doLoadFromString("loadAsString.qvto", testFile);
	}
}
