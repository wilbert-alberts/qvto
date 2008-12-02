/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.bbox;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
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
	private Map<String, Integer> fCounters = new HashMap<String, Integer>();
	
	@Operation (contextual = true)
	public int getStrCounterX(String self) {
		Integer val = fCounters.get(self);
		if(val == null) {
			return 0;
		}
		return fCounters.get(self);
	}

	@Operation (contextual = true)
	public int incStrCounterX(String self) {
		Integer val = fCounters.get(self);
		if(val == null) {
			fCounters.put(self, 1);
		} else {
			fCounters.put(self, ++val);
		}
		return fCounters.get(self);
	}	
	
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
	public BigInteger createBigInteger(String value) {
		return new BigInteger(value);
	}
		
	public BigInteger addBigInteger(BigInteger self, BigInteger big2) {
		return self.add(big2);
	}
	
	public BigDecimal createBigDecimal(String value) {
		return new BigDecimal(value);
	}
	
	public BigDecimal addBigDecimal(BigDecimal big1, BigDecimal big2) {
		return big1.add(big2);
	}

	// test lower precision types 
	public Long sumLowerPrecisions(Short s, Integer i, Long l) {
		// Byte b,
		return /*b.byteValue() + */ s.shortValue() + i.intValue() + l.longValue();		
	}

	// TODO - byte not mapped by MDT OCL, raise bugzilla 
	public long sumLowerPrecisionWithoutWrappers(/*byte b, */short s, int i, long l) {
		return /*b + */ s + i + l;
	}
	
	public Double sumLowerPrecisionDoubles(Float f, Double d) {
		return f.floatValue() + d.doubleValue();
	}

	public double sumLowerPrecisionDoublesWithoutWrappers(float f, double d) {
		return f + d;
	}
	
	@Operation(contextual=true)
	public static boolean theSameJavaBigIntegerInstance(BigInteger self, BigInteger another) {
		return self == another;
	}
	
	@Operation(contextual=true)
	public static String stringContextualEcho(String self) {
		return self;
	}

	@Operation(contextual=true)
	public static boolean nonObjectBoolContextualEcho(boolean self) {
		return self;
	}	
	
	@Operation(contextual=true)
	public static int nonObjectIntContextualEcho(int self) {
		return self;
	}
	
	@Operation(contextual=true)
	public static double nonObjectDoubleContextualEcho(double self) {
		return self;
	}
	
	@Operation(contextual=true)
	public static boolean boolContextualEcho(boolean self) {
		return self;
	}	
	
	@Operation(contextual=true)
	public static int intContextualEcho(int self) {
		return self;
	}
	
	@Operation(contextual=true)
	public static double doubleContextualEcho(double self) {
		return self;
	}

	// test data type not mapped by MDT OCL 
	public Date createDate(String dateStr) {
		return (Date)EcoreFactory.eINSTANCE.createFromString(EcorePackage.eINSTANCE.getEDate(), dateStr);
	}
	
	@Operation(contextual=true)
	public static boolean before(Date self, Date when) {
		return self.before(when);
	}		
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	// Collection type operation
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
	
	public String foo() {
		return null;
	}
	
	
	@Operation (kind=Kind.HELPER, contextual = true)
	public static <T> T anyElement(Collection<T> self) {
		return self.iterator().next();
	}
	
	@Operation (kind=Kind.OPERATION, contextual = true)
	public static <T> Set<T> echoAsSet(Collection<T> self) {
		return new HashSet<T>(self);
	}
}
