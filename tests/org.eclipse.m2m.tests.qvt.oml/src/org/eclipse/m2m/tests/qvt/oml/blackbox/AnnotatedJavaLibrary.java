package org.eclipse.m2m.tests.qvt.oml.blackbox;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Parameter;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.ocl.util.Bag;
import org.eclipse.ocl.util.CollectionUtil;

import simpleuml.Model;

public class AnnotatedJavaLibrary {
		
	@Operation (kind=Kind.HELPER, contextual = false)
	public ArrayList<Object> primitiveTypeArgumentsHelper(String strArg, Integer intArg, Double realArg, Boolean boolArg) {
		ArrayList<Object> result = new ArrayList<Object>();
		result.add(strArg);
		result.add(intArg);
		result.add(realArg);
		result.add(boolArg);		
		return result;
	}
	
	@Operation (kind=Kind.QUERY, contextual = false)
	public ArrayList<Object> primitiveTypeArgumentsQuery(String strArg, Integer intArg, Double realArg, Boolean boolArg) {
		ArrayList<Object> result = new ArrayList<Object>();
		result.add(strArg);
		result.add(intArg);
		result.add(realArg);
		result.add(boolArg);		
		return result;
	}
	
	@Operation(contextual = false)
	public ArrayList<Object> primitiveTypeArgumentsOperation(String strArg, Integer intArg, Double realArg, Boolean boolArg) {
		ArrayList<Object> result = new ArrayList<Object>();
		result.add(strArg);
		result.add(intArg);
		result.add(realArg);
		result.add(boolArg);		
		return result;
	}

	public ArrayList<Object> primitiveTypeArgumentsDefault(String strArg, Integer intArg, Double realArg, Boolean boolArg) {
		ArrayList<Object> result = new ArrayList<Object>();
		result.add(strArg);
		result.add(intArg);
		result.add(realArg);
		result.add(boolArg);		
		return result;
	}
	
	
	// contextual operations
	
	@Operation (kind=Kind.HELPER, contextual = true)
	public static ArrayList<Object> primitiveTypeArgumentsHelperContextual(EAnnotation self, String strArg, Integer intArg, Double realArg, Boolean boolArg) {
		ArrayList<Object> result = new ArrayList<Object>();
		result.add(strArg);
		result.add(intArg);
		result.add(realArg);
		result.add(boolArg);		
		return result;
	}
	
	@Operation (kind=Kind.QUERY, contextual = true)
	public static ArrayList<Object> primitiveTypeArgumentsQueryContextual(EAnnotation self, String strArg, Integer intArg, Double realArg, Boolean boolArg) {
		ArrayList<Object> result = new ArrayList<Object>();
		result.add(strArg);
		result.add(intArg);
		result.add(realArg);
		result.add(boolArg);		
		return result;
	}
	
	@Operation (contextual = true)
	public static ArrayList<Object> primitiveTypeArgumentsOperationContextual(EAnnotation self, String strArg, Integer intArg, Double realArg, Boolean boolArg) {
		ArrayList<Object> result = new ArrayList<Object>();
		result.add(strArg);
		result.add(intArg);
		result.add(realArg);
		result.add(boolArg);		
		return result;
	}

	
	@Operation (kind=Kind.HELPER, contextual = true)
	public static String testContextualSuffixedName(
			@Parameter(name="eNamedElement") ENamedElement eNamedElement, 
			@Parameter(name="suffix") String suffix) {
		return eNamedElement.getName() + suffix;
	}
	
	@Operation (kind=Kind.HELPER)
	public String testEchoArgument(String param) {
		return param;
	}

	@Operation (kind=Kind.QUERY)
	public String staticTestEchoArgument(String param) {
		return param;
	}	
	
	@Operation(contextual=true)
	public static Set<ArrayList<String>> wrapInSet(ArrayList<String> sequence) {
		Set<ArrayList<String>> result = CollectionUtil.createNewSet();
		result.add(sequence);
		return result;
	}	
	@Operation(contextual=true)
	public static Set<ArrayList<Object>> commonCollectionInSet(Collection<Object> sequence) {
		Set<ArrayList<Object>> result = CollectionUtil.createNewSet();
		result.add(new ArrayList<Object>(sequence));
		return result;
	}		

	public Set<LinkedHashSet<List<Bag<String>>>> testComplexTypeCopy(Set<LinkedHashSet<ArrayList<Bag<String>>>> complexType) {
		String element = complexType.iterator().next().iterator()
			.next().iterator().next().iterator().next();
				
		final Bag<String> createNewBag = CollectionUtil.createNewBag();
		createNewBag.add(element);
		final List<Bag<String>> createNewSequence = CollectionUtil.createNewSequence();
		createNewSequence.add(createNewBag);
		final LinkedHashSet<List<Bag<String>>> createNewOrderedSet = CollectionUtil.createNewOrderedSet();
		createNewOrderedSet.add(createNewSequence);
		final Set<LinkedHashSet<List<Bag<String>>>> result = CollectionUtil.createNewSet();
		result.add(createNewOrderedSet);
		return result; 
	}
	
	public void noReturnType(String str) {
		
	}
	
	public Model testUsedSimpleUMLModelPackage(Model model) {
		return model;
	}
	 
}
