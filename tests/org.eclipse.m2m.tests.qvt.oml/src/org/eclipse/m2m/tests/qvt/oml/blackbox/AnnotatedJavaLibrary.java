package org.eclipse.m2m.tests.qvt.oml.blackbox;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Parameter;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.ocl.util.Bag;
import org.eclipse.ocl.util.CollectionUtil;

import simpleuml.Model;

public class AnnotatedJavaLibrary {
	
	public AnnotatedJavaLibrary() {
		 super();
	}

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
		// do nothing, testing void return type
	}
	
	public Model testUsedSimpleUMLModelPackage(Model model) {
		return model;
	}
	
	public String getEnumLiteralName(DirectionKind directionKind) {
		return directionKind.getName();
	}
	
	// TODO - add support for java big numbers
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Numeric types operation
	////////////////////////////////////////////////////////////////////////////////////////////////////////////	
/*	public BigInteger bigInteger(BigInteger bigInteger) {
		return bigInteger == null ? new BigInteger("0") : bigInteger.add(new BigInteger("10"));
	}
	
	public BigDecimal bigDecimal(BigDecimal bigDecimal) {
		return bigDecimal == null ? new BigDecimal(0) : bigDecimal.add(new BigDecimal(10));
	}
*/
	// TODO - MDT OCL does not support the type-checker extensibility fully yet to
	// realize collection operations  
	@Operation (kind=Kind.HELPER, contextual = true)
	public static <T> int countIgnoreUndefined(Collection<T> self) {
		int count = 0;
		if(self != null) {
			for (T element : self) {
				if(element != null) {
					count++;
				}
			}
		}

		return count;
	}
	
	// tests T, T2 parameterized types together
	@Operation (contextual = true)
	public static <T, T2> Collection<T2> shrinkAnotherCollectionToMySize(Collection<T> self, Collection<T2> another) {
		return new ArrayList<T2>(another).subList(0, self.size());
	}	
}
