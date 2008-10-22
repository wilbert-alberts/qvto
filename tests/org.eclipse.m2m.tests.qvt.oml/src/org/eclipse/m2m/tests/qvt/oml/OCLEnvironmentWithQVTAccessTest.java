package org.eclipse.m2m.tests.qvt.oml;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.blackbox.AbstractCompilationUnitDescriptor;
import org.eclipse.m2m.qvt.oml.blackbox.BlackboxRegistry;
import org.eclipse.m2m.qvt.oml.blackbox.LoadContext;
import org.eclipse.m2m.qvt.oml.blackbox.ResolutionContext;
import org.eclipse.m2m.qvt.oml.blackbox.ResolutionContextImpl;
import org.eclipse.m2m.qvt.oml.blackbox.AbstractBlackboxProvider.CompilationUnit;
import org.eclipse.m2m.qvt.oml.runtime.util.OCLEnvironmentWithQVTAccessFactory;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.helper.OCLHelper;

public class OCLEnvironmentWithQVTAccessTest extends TestCase {

	private static final String SRC_CONTAINER = "parserTestData/externlib"; //$NON-NLS-1$
	
	private OCL fOCL;
	private Set<Module> fImportedModules;

	@Override
	protected void setUp() {
		final Set<CompiledModule> compileModules = TestUtil.compileModules(SRC_CONTAINER,
			new String[] {
				"org.q1",
				"org.q2"
			}
		);
		
		fImportedModules = new HashSet<Module>();
		for (CompiledModule compiledModule : compileModules) {
			fImportedModules.add(compiledModule.getModule());
		}
		
		try {
			ResolutionContext resolutionContext = new ResolutionContextImpl(compileModules.iterator().next().getSource());
			// import "Strings" black-box library
			AbstractCompilationUnitDescriptor abstractCompilationUnitDescriptor = BlackboxRegistry.INSTANCE.getCompilationUnitDescriptor("Strings", resolutionContext);
			
			LoadContext loadContext = new LoadContext(EPackage.Registry.INSTANCE);
			CompilationUnit loadCompilationUnit = BlackboxRegistry.INSTANCE.loadCompilationUnit(abstractCompilationUnitDescriptor, loadContext);
			fImportedModules.add(loadCompilationUnit.getElements().get(0).getModuleContextType());

		} catch (Exception e) {
			throw new RuntimeException("Failed to setup test", e);
		}
		
		fOCL = OCL.newInstance(new OCLEnvironmentWithQVTAccessFactory(fImportedModules, EPackage.Registry.INSTANCE));
	}
		
	
	public void testImportedOperationAccessingModuleProperty() throws Exception {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		
		try {
			helper.setValidating(true);
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> q = helper.createQuery("getModulePropertyValue()");

			assertNull(helper.getProblems());
						
			Object result = fOCL.createQuery(q).evaluate();			
			assertEquals("moduleProperty_suffix_suffix", result);
			
		} catch (ParserException e) {
			e.printStackTrace();			
			fail("Additional operation should come from super type"); //$NON-NLS-1$
		}		
	}
		
	public void testImportedModulePropertyAccess() throws ParserException {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		
		try {
			helper.setValidating(true);
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> q = 
				helper.createQuery("moduleProperty");

			assertNull(helper.getProblems());
						
			Object result = fOCL.createQuery(q).evaluate();			
			assertEquals("moduleProperty_suffix", result);
			
		} catch (ParserException e) {
			e.printStackTrace();			
			fail("Additional operation should come from super type"); //$NON-NLS-1$
		}
	}
	
	public void testImportedOperations() throws ParserException {		
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		
		try {
			helper.setValidating(true);
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> q = helper.createQuery(
					"let c : Sequence(String) = Sequence {} in " +
					"q1(c).concat(q2(Bag{'aString'})).concat('ab'.firstToUpper()).concat('xx'.lastIndexOf('x').repr())");

			assertNull(helper.getProblems());
						
			Object result = fOCL.createQuery(q).evaluate();			
			assertEquals("name = xxxAb1", result);
			
		} catch (ParserException e) {
			e.printStackTrace();			
			fail(e.getLocalizedMessage());
		}
	}
		
	public void testComplextTypeInSignatures() throws Exception {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		
		try {
			helper.setValidating(true);
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> q = helper.createQuery(
					"let t : Tuple(name : String, size : Integer) = Tuple { name = 'bob', size = 10} " +
					"in let result : Tuple(name1 : String, name2 : String) = callOnTupleType(t) " +
					"in result.name1.concat(result.name2) = 'bob10'");

			assertNull(helper.getProblems());
						
			Object result = fOCL.createQuery(q).evaluate();			
			assertEquals(Boolean.TRUE, result);
			
		} catch (ParserException e) {
			e.printStackTrace();			
			fail(e.getLocalizedMessage());
		}		
	}

	public void testImportedContextualOperation() throws ParserException {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		try {
			helper.setValidating(true);
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> q = helper.createQuery(
					"self.getUpperName()");

			assertNull(helper.getProblems());

			EClass eClass = EcoreFactory.eINSTANCE.createEClass();
			eClass.setName("foo");

			Object result = fOCL.createQuery(q).evaluate(eClass);
			assertEquals("EClass-FOO", result);
			
			EParameter eParam = EcoreFactory.eINSTANCE.createEParameter();
			eParam.setName("foo");

			result = fOCL.createQuery(q).evaluate(eParam);
			assertEquals("FOO", result);
			
			
		} catch (ParserException e) {
			e.printStackTrace();			
			fail(e.getLocalizedMessage());
		}
	}
	
	
	public void testImportedOperationOnCollection() throws ParserException {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		helper.setContext(EcorePackage.eINSTANCE.getENamedElement());
		
		try {
			helper.setValidating(true);
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> q = helper.createQuery(
					"let c : Sequence(String) = Sequence { 'foo' } in " +
					"c->callOnCollection()->includes('foo')");

			assertNull(helper.getProblems());
						
			Object result = fOCL.createQuery(q).evaluate();			
			assertEquals(Boolean.TRUE, result);
			
		} catch (ParserException e) {
			e.printStackTrace();			
			fail(e.getLocalizedMessage());
		}
	}
	
	
	public void testValidationProblems() throws Exception {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		try {		
			helper.setContext(EcorePackage.eINSTANCE.getENamedElement());		
			helper.setValidating(true);
			
			helper.createQuery("let s : String = 1 in true");
			fail("Parser error was expected");			
		} catch (ParserException e) {
			assertNotNull(helper.getProblems());			
		}
	}
	
	public void testParsingProblems() throws Exception {
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = fOCL.createOCLHelper();		
		try {					
			helper.setContext(EcorePackage.eINSTANCE.getENamedElement());			
			helper.setValidating(true);
			
			helper.createQuery("1>++2");
			fail("Parser error was expected");			
		} catch (ParserException e) {
			assertNotNull(helper.getProblems() != null);			
		}
	}		
			
}
