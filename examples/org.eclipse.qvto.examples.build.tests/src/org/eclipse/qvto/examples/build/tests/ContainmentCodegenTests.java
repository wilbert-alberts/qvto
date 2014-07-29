package org.eclipse.qvto.examples.build.tests;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.codegen.oclinjunit.JUnitCodeGenerator;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCLStandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ContainmentCodegenTests {

	ResourceSet resourceSet;
	MetaModelManager mManager;
	OCL ocl;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		EssentialOCLStandaloneSetup.doSetup();
		OCLstdlib.install();
	}
	
	@Before
	public void setUp()
			throws Exception {
		resourceSet = new ResourceSetImpl();
		StandaloneProjectMap projectMap = ProjectMap.getAdapter(resourceSet);		
		projectMap.initializeResourceSet(resourceSet);
		mManager = MetaModelManager.getAdapter(resourceSet);		
		ocl = OCL.newInstance();		
	}

	@After
	public void tearDown()
			throws Exception {
	}

	@Test
	public void test() throws Exception {
		Operation myOp = createTestOperation();

		ExpressionInOCL opBody = createOperationBody("2 + 3", myOp);
		
		// TODO use the containtment code generator when implemented
		String genCode = JUnitCodeGenerator.generateClassFile(mManager, opBody, getJavaPacakgeName(), myOp.getName());
		int i = 0;
		
		// TODO test something
	}
	
	@Test
	public void test2() throws Exception {
		Operation myOp = createTestOperation();
		
		ExpressionInOCL opBody = createOperationBody(
			"MyClass{"
			+ " myProp1 = 2,"
			+ " myProp2 = 'foo'"
			+ "}", myOp);		
		
		// TODO use the containtment code generator when implemented
		String genCode = JUnitCodeGenerator.generateClassFile(mManager, opBody, getJavaPacakgeName(), myOp.getName());

		int i = 0;
		
		// TODO test something
		
		
	}
	
	@Test
	public void test3() throws Exception {
		Operation myOp = createTestOperation();
		
		ExpressionInOCL opBody = createOperationBody(
			"Tuple{"
			+ " p1 = 2,"
			+ " p2 = 'foo'"
			+ "}", myOp);
		
		// TODO use the containtment code generator when implemented
		String genCode = JUnitCodeGenerator.generateClassFile(mManager, opBody,  getJavaPacakgeName(), myOp.getName());

		int i = 0;
		
		// TODO test something
	}
	
	protected Operation createTestOperation() {		

		Class myClass = PivotFactory.eINSTANCE.createClass();
		myClass.setName("MyClass");
		Property p1 = PivotFactory.eINSTANCE.createProperty();
		p1.setName("myProp1");
		p1.setType(mManager.getIntegerType());
		Property p2 = PivotFactory.eINSTANCE.createProperty();
		p2.setName("myProp2");
		p2.setType(mManager.getStringType());		
		Operation myOp = PivotFactory.eINSTANCE.createOperation();		
		myOp.setName("myOp");
		myOp.setType(mManager.getIntegerType());
		
		
		mManager.addOrphanClass(myClass);
		myClass.getOwnedAttribute().add(p1);
		myClass.getOwnedAttribute().add(p2);
		myClass.getOwnedOperation().add(myOp);
		return myOp;
	}
	
	protected ExpressionInOCL createQuery(String query, Type context) throws Exception {
		OCLHelper helper = ocl.createOCLHelper();		
		helper.setContext(context);		
		return helper.createQuery(query);		
	}
	
	protected ExpressionInOCL createOperationBody(String bodyExpression, Operation operation) throws Exception {
		OCLHelper helper = ocl.createOCLHelper();
		helper.setOperationContext(operation.getOwningType(), operation);

		return helper.createBodyCondition(bodyExpression);
	}
	
	protected String getJavaPacakgeName() {
		return "tests_package";
	}
//	protected CodeGenHelper getCodeGenHelper(@NonNull MetaModelManager metaModelManager) throws Exception {
//		URI genModelURI = URI.createPlatformResourceURI(
//				"/org.eclipse.ocl.examples.pivot/model/Pivot.merged.genmodel",
//				true);
//		Resource genModelResource = resourceSet.getResource(genModelURI, true);
//		String errorsString = PivotUtil.formatResourceDiagnostics(
//				genModelResource.getErrors(), "Loading " + genModelURI, "\n");
//		if (errorsString != null) {
//			throw new IllegalStateException("Errors in pivot.merged.genmodel");
//		}
//		GenModel genModel = (GenModel) genModelResource.getContents().get(0);
//		return new JavaGenModelCodeGenHelper(genModel, metaModelManager);
//	}
	
	
}
