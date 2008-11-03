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
package org.eclipse.m2m.internal.qvt.oml.evaluator;

import java.math.BigDecimal;
import java.math.BigInteger;


public class NumberConversions {
	
	private NumberConversions() {
		super();
	}

	/**
	 * Converts the given value to a compatible value for assignment to the
	 * target type.
	 * 
	 * @param value
	 *            the value to be converted
	 * @param targetClass
	 *            the target type as a potential left side of assignment
	 * @return A new value compatible to the required type if the conversion is
	 *         possible. Otherwise, the original passed value is returned.
	 *         Note: Non-compatible value for a conversion to the target type is returned
	 *         as is
	 */
	public static Object convertNumber(Object value, Class<?> targetClass) {
		if(targetClass == null) {
			throw new IllegalArgumentException();
		}
		
		if(value == null) {
			return value;
		}
		
		Class<?> valueClass = value.getClass();
		if(valueClass == targetClass || (value instanceof Number == false)) {
			return value;
		}

		Number numVal = (Number) value;
		if(targetClass == BigInteger.class) {
			return new BigInteger(String.valueOf(numVal.longValue()));			
		}
		else if(targetClass == Long.class) {
			return new Long(numVal.longValue()); 
		} 
		else if(targetClass == Integer.class) {
			return new Integer(numVal.intValue()); 
		}
		else if(targetClass == Short.class) {
			return new Short(numVal.shortValue()); 
		}
		else if(targetClass == Byte.class) {
			return new Byte(numVal.byteValue()); 
		}
		else if(targetClass == BigDecimal.class) {
			return new BigDecimal(String.valueOf(numVal.doubleValue())); 
		}
		else if(targetClass == Double.class) {
			return new Double(numVal.doubleValue()); 
		}
		else if(targetClass == Float.class) {
			return new Float(numVal.floatValue()); 
		}

		return value; // NFE fill be raised in further processing
	}
}
