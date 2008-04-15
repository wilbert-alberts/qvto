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
package org.eclipse.m2m.internal.qvt.oml.stdlib;

import java.util.HashMap;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.utilities.PredefinedType;


public class StringOperations extends AbstractContextualOperations {
	
	public StringOperations(AbstractQVTStdlib library) {
		super(library, library.getEnvironment().getOCLStandardLibrary().getString());
	}
	
	@Override
	protected OperationProvider[] getOperations() {
		OCLStandardLibrary<EClassifier> oclStdLib = getStdlib().getEnvironment().getOCLStandardLibrary();		
		return new OperationProvider[] {
			new OperationProvider(STRING_CONCAT, PredefinedType.PLUS_NAME, oclStdLib.getString(), oclStdLib.getString()),			
			new OperationProvider(LENGTH, LENGTH_NAME, oclStdLib.getInteger()),
			new OperationProvider(SUBSTRING_BEFORE, SUBSTRING_BEFORE_NAME, oclStdLib.getString(), oclStdLib.getString()),			
			new OperationProvider(SUBSTRING_AFTER, SUBSTRING_AFTER_NAME, oclStdLib.getString(), oclStdLib.getString()),			
			new OperationProvider(FIRST_TO_UPPER, FIRST_TO_UPPER_NAME, oclStdLib.getString()),			
			new OperationProvider(LAST_TO_UPPER, LAST_TO_UPPER_NAME, oclStdLib.getString()),			
			new OperationProvider(INDEX_OF, INDEX_OF_NAME, oclStdLib.getInteger(), oclStdLib.getString()),			
			new OperationProvider(STARTS_WITH, STARTS_WITH_NAME, oclStdLib.getBoolean(), oclStdLib.getString()),			
			new OperationProvider(ENDS_WITH, ENDS_WITH_NAME, oclStdLib.getBoolean(), oclStdLib.getString()),			
			new OperationProvider(TRIM, TRIME_NAME, oclStdLib.getString()),
			new OperationProvider(NORMALIZE, NORMALIZE_SPACE_NAME, oclStdLib.getString()),
			new OperationProvider(REPLACE, REPLACE_NAME, oclStdLib.getString(), oclStdLib.getString(), oclStdLib.getString()),
			new OperationProvider(MATCH, MATCH_NAME, oclStdLib.getBoolean(), oclStdLib.getString()),			
			new OperationProvider(EQUALS_IGNORE_CASE, EQUALS_IGNORE_CASE_NAME, oclStdLib.getBoolean(), oclStdLib.getString()),
			new OperationProvider(FIND, FIND_NAME, oclStdLib.getInteger(), oclStdLib.getString()),			
			new OperationProvider(RFIND, RFIND_NAME, oclStdLib.getInteger(), oclStdLib.getString()),
			new OperationProvider(IS_QUOTED, IS_QUOTED_NAME, oclStdLib.getBoolean(), oclStdLib.getString()),			
			new OperationProvider(QUOTIFY, QUOTIFY_NAME, oclStdLib.getString(), oclStdLib.getString()),			
			new OperationProvider(UNQUOTIFY, UNQUOTIFY_NAME, oclStdLib.getString(), oclStdLib.getString()),			
			
			new OperationProvider(MATCH_BOOLEAN, MATCH_BOOLEAN_NAME, oclStdLib.getBoolean(), oclStdLib.getBoolean()),			
			new OperationProvider(MATCH_INTEGER, MATCH_INTEGER_NAME, oclStdLib.getBoolean(), oclStdLib.getInteger()),			
			new OperationProvider(MATCH_FLOAT, MATCH_FLOAT_NAME, oclStdLib.getBoolean(), oclStdLib.getReal()),
			new OperationProvider(MATCH_IDENTIFIER, MATCH_IDENTIFIER_NAME, oclStdLib.getBoolean(), oclStdLib.getString()),
			
			new OperationProvider(AS_BOOLEAN, AS_BOOLEAN_NAME, oclStdLib.getBoolean()),
			new OperationProvider(AS_INTEGER, AS_INTEGER_NAME, oclStdLib.getInteger()),
			new OperationProvider(AS_FLOAT, AS_FLOAT_NAME, oclStdLib.getReal()),
			
			createStaticOperationProvider(START_STR_COUNTER, START_STR_COUNTER_NAME, oclStdLib.getOclVoid(), oclStdLib.getString()),
			createStaticOperationProvider(GET_STR_COUNTER, GET_STR_COUNTER_NAME, oclStdLib.getInteger(), oclStdLib.getString()),			
			createStaticOperationProvider(INCR_STR_COUNTER, INCR_STR_COUNTER_NAME, oclStdLib.getInteger(), oclStdLib.getString()),						
			createStaticOperationProvider(RESTART_ALL_STR_COUNTER, RESTART_ALL_STR_COUNTER_NAME, oclStdLib.getOclVoid()),
			new OperationProvider(ADD_SUFFIX_NUMBER, ADD_SUFFIX_NUMBER_NAME, oclStdLib.getString()),					
			
		};
	}
	
	static CallHandler STRING_CONCAT = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			// TODO - return OCLInvalid if arg is null of invalid
			return ((String) source).concat(String.valueOf(args[0]));
		}
	};
	
	static final String LENGTH_NAME = "length"; //$NON-NLS-1$
	
	static final CallHandler LENGTH = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			return ((String) source).length();
		}
	};	
	
	static final String SUBSTRING_BEFORE_NAME = "substringBefore"; //$NON-NLS-1$
	
	static final CallHandler SUBSTRING_BEFORE = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return evalEnv.getInvalid();
			}
			String self = (String) source;
			String arg = (String) leftVal;
			int pos = self.indexOf(arg);
			if(pos < 0) {
				return null;
			}
			
			return self.substring(0, pos);
		}
	};
	
	static final String SUBSTRING_AFTER_NAME = "substringAfter"; //$NON-NLS-1$	
	static final CallHandler SUBSTRING_AFTER = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return evalEnv.getInvalid();
			}
			String self = (String) source;
			String arg = (String) leftVal;
			int pos = self.indexOf(arg);
			if(pos < 0) {
				return null;
			}
			
			return self.substring(pos + arg.length());
		}
	};	

	static final String FIRST_TO_UPPER_NAME = "firstToUpper"; //$NON-NLS-1$
	static final CallHandler FIRST_TO_UPPER = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			String self = (String) source;
			if(self.length() == 0) {
				return self;
			}
			StringBuilder buf = new StringBuilder(self);
			buf.setCharAt(0, Character.toUpperCase(self.charAt(0)));
			return buf.toString();
		}
	};
	
	static final String LAST_TO_UPPER_NAME = "lastToUpper"; //$NON-NLS-1$
	static final CallHandler LAST_TO_UPPER = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			String self = (String) source;
			if(self.length() == 0) {
				return self;
			}
			StringBuilder buf = new StringBuilder(self);
			int lastPos = self.length() - 1;
			buf.setCharAt(lastPos, Character.toUpperCase(self.charAt(lastPos)));
			return buf.toString();
		}
	};
	
	static final String INDEX_OF_NAME = "indexOf"; //$NON-NLS-1$
	static final CallHandler INDEX_OF = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			String self = (String) source;
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return -1;
			}
			
			return self.indexOf((String)leftVal) + 1;
		}
	};

	static final String ENDS_WITH_NAME = "endsWith"; //$NON-NLS-1$
	static final CallHandler ENDS_WITH = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			String self = (String) source;
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return false;
			}

			return Boolean.valueOf(self.endsWith((String)leftVal));
		}
	};

	static final String STARTS_WITH_NAME = "startsWith"; //$NON-NLS-1$
	static final CallHandler STARTS_WITH = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			String self = (String) source;
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return false;
			}

			return Boolean.valueOf(self.startsWith((String)leftVal));
		}
	};

	static final String TRIME_NAME = "trim"; //$NON-NLS-1$
	static final CallHandler TRIM = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			String self = (String) source;
			return self.trim();
		}
	};

	static final String NORMALIZE_SPACE_NAME = "normalizeSpace"; //$NON-NLS-1$
	static final CallHandler NORMALIZE = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			String self = (String) source;
			self = self.trim();
			StringBuilder buf = new StringBuilder(self.length());
			boolean isWhiteArea = false;
			for (int i = 0; i < self.length(); i++) {
				char c = self.charAt(i);
				if(Character.isWhitespace(c)) {
					if(isWhiteArea) {
						continue;
					} else {
						isWhiteArea = true;
						buf.append(c);
					}
				} else {
					isWhiteArea = false;
					buf.append(c);
				}
			}
			return buf.toString();
		}
	};

	
	static final String REPLACE_NAME = "replace"; //$NON-NLS-1$
	static final CallHandler REPLACE = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			String self = (String) source;
			Object arg0 = args[0];
			if(arg0 == null && arg0 == evalEnv.getInvalid()) {
				return self;
			}
			
			Object arg1 = args[1];
			if(arg1 == null && arg1 == evalEnv.getInvalid()) {
				return evalEnv.getInvalid();
			}

			return self.replace((String)arg0, (String)arg1);
		}
	};

	static final String MATCH_NAME = "match"; //$NON-NLS-1$
	static final CallHandler MATCH = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			String self = (String) source;
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return false;
			}

			return Boolean.valueOf(Pattern.matches((String)leftVal, self));
		}
	};
	
	static final String EQUALS_IGNORE_CASE_NAME = "equalsIgnoreCase"; //$NON-NLS-1$
	static final CallHandler EQUALS_IGNORE_CASE = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			String self = (String) source;
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return false;
			}

			return Boolean.valueOf(self.equalsIgnoreCase((String)leftVal));
		}
	};

	static final String FIND_NAME = "find"; //$NON-NLS-1$
	static final CallHandler FIND = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			String self = (String) source;
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return -1;
			}
			
			return self.indexOf((String)leftVal) + 1;
		}
	};
	
	static final String RFIND_NAME = "rfind"; //$NON-NLS-1$
	static final CallHandler RFIND = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			String self = (String) source;
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return -1;
			}
			
			return self.lastIndexOf((String)leftVal) + 1;
		}
	};
	
	static final String IS_QUOTED_NAME = "isQuoted"; //$NON-NLS-1$
	static final CallHandler IS_QUOTED = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {			
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return false;
			}
			String quoteStr = (String) leftVal;		
			String self = (String) source;			
			return Boolean.valueOf(self.length() >= (quoteStr.length()*2) && self.startsWith(quoteStr) && self.endsWith(quoteStr));
		}
	};
	
	static final String QUOTIFY_NAME = "quotify"; //$NON-NLS-1$
	static final CallHandler QUOTIFY = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return source;
			}
			String quoteStr = (String) leftVal;
			String self = (String) source;
			return quoteStr + self + quoteStr;
		}
	};
	
	static final String UNQUOTIFY_NAME = "unquotify"; //$NON-NLS-1$
	static final CallHandler UNQUOTIFY = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			if(!Boolean.TRUE.equals(IS_QUOTED.invoke(source, args, evalEnv, context))) {
				return source;
			}
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return false;
			}
			String quoteStr = (String) leftVal;
			String self = (String) source;
			return self.substring(quoteStr.length(), self.length() - quoteStr.length());
		}
	};	

	static final String MATCH_BOOLEAN_NAME = "matchBoolean"; //$NON-NLS-1$
	static final CallHandler MATCH_BOOLEAN = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return false;
			}		

			Boolean arg = (Boolean) leftVal;
			Object self = AS_BOOLEAN.invoke(source, args, evalEnv, context);  
			return Boolean.valueOf(arg.equals(self));
		}
	};
	
	static final String MATCH_INTEGER_NAME = "matchInteger"; //$NON-NLS-1$
	static final CallHandler MATCH_INTEGER = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return false;
			}		

			Integer arg = (Integer) leftVal;
			Object self = AS_INTEGER.invoke(source, args, evalEnv, context);  
			return Boolean.valueOf(arg.equals(self));
		}
	};
	
	static final String MATCH_FLOAT_NAME = "matchFloat"; //$NON-NLS-1$
	static final CallHandler MATCH_FLOAT = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return false;
			}		

			Number arg = (Number) leftVal;
			Object self = AS_FLOAT.invoke(source, args, evalEnv, context);
			if(self != null) {
				return arg.doubleValue() == ((Number)self).doubleValue();
			}
			return Boolean.valueOf(false);
		}
	};
	
	static final String MATCH_IDENTIFIER_NAME = "matchIdentifier"; //$NON-NLS-1$
	static final CallHandler MATCH_IDENTIFIER = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return false;
			}

			String self = (String) source;
			for (int i = 0; i < self.length(); i++) {
				char c = self.charAt(i);
				if( (i == 0 && !Character.isLetter(c)) ||
					!Character.isLetterOrDigit(c) ) {
					return Boolean.FALSE;
				}				
			}
			return Boolean.TRUE;
		}
	};

	
	static final String AS_BOOLEAN_NAME = "asBoolean"; //$NON-NLS-1$
	static final CallHandler AS_BOOLEAN = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {			
			String self = (String) source;
			if(self.equals("1") || self.equals("true")) { //$NON-NLS-1$ //$NON-NLS-2$
				return Boolean.TRUE;
			} else if(self.equals("0") || self.equals("false")) { //$NON-NLS-1$ //$NON-NLS-2$
				return Boolean.FALSE;
			}

			return null;
		}
	};

	static final String AS_INTEGER_NAME = "asInteger"; //$NON-NLS-1$
	static final CallHandler AS_INTEGER = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {			
			String self = (String) source;
			Integer result = null;
			try {
				result = Integer.valueOf(self);
			} catch (NumberFormatException e) {
				// result will be null
			}
			return result;
		}
	};
	
	static final String AS_FLOAT_NAME = "asFloat"; //$NON-NLS-1$
	static final CallHandler AS_FLOAT = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {			
			String self = (String) source;
			Double result = null;
			try {
				result = Double.valueOf(self);
			} catch (NumberFormatException e) {
				// result will be null
			}
			return result;
		}
	};
	
	
	static final String START_STR_COUNTER_NAME = "startStrCounter"; //$NON-NLS-1$
	static final CallHandler START_STR_COUNTER = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {			
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return false;
			}
			
			String counterName = (String) leftVal;
			StringCounter.getInstance(evalEnv).start(counterName);
			return null;
		}
	};
		
	static final String GET_STR_COUNTER_NAME = "getStrCounter"; //$NON-NLS-1$
	static final CallHandler GET_STR_COUNTER = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {			
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return false;
			}
			
			String counterName = (String) leftVal;
			return StringCounter.getInstance(evalEnv).value(counterName);
		}
	};
	
	static final String INCR_STR_COUNTER_NAME = "incrStrCounter"; //$NON-NLS-1$
	static final CallHandler INCR_STR_COUNTER = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {			
			Object leftVal = args[0];
			if(leftVal == null && leftVal == evalEnv.getInvalid()) {
				return false;
			}
			
			String counterName = (String) leftVal;
			return StringCounter.getInstance(evalEnv).increment(counterName);
		}
	};	

	static final String RESTART_ALL_STR_COUNTER_NAME = "restartAllStrCounter"; //$NON-NLS-1$
	static final CallHandler RESTART_ALL_STR_COUNTER = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {			
			StringCounter.getInstance(evalEnv).restartAll();
			return null;
		}
	};
	
	static final String ADD_SUFFIX_NUMBER_NAME = "addSuffixNumber"; //$NON-NLS-1$
	static final CallHandler ADD_SUFFIX_NUMBER = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {			
			String self = (String) source;			
			StringCounter counters = StringCounter.getInstance(evalEnv);
			Integer currentValue = counters.value(self);
			
			if(currentValue == null) {
				counters.start(self);
				return self;
			}
			
			counters.increment(self);
			return self + currentValue.toString();
		}
	};

	
	private static class StringCounter {
		
		static final String DATA_KEY = StringCounter.class.getName(); 
		
		HashMap<String, CounterValue> counters = new HashMap<String, CounterValue>();
		
		static StringCounter getInstance(QvtOperationalEvaluationEnv env) {			
			StringCounter counters = (StringCounter)env.getContext().get(DATA_KEY);
			if(counters == null) {
				counters = new StringCounter() ;
				env.getContext().put(DATA_KEY, counters);
			}
			
			return counters;
		}		

		void restartAll() {
			for (CounterValue nextCounter : counters.values()) {
				nextCounter.reset();
			}
		}
		
		CounterValue get(String key, boolean onDemandCreate) {
			CounterValue value = counters.get(key);
			if(value == null && onDemandCreate) {
				value = new CounterValue();
				counters.put(key, value);
			}
			return value;
		}
		
		void start(String key) {
			get(key, true).reset();
		}
		
		int increment(String key) {
			return get(key, true).increment();
		}
		
		Integer value(String key) {
			CounterValue counterValue = get(key, false);
			if(counterValue != null) {
				return counterValue.value;
			}
			return null;
		}
	}
		
	private static class CounterValue {
		int value;
		Integer cachedIntObj;

		CounterValue() {
			reset();
		}
		
		int increment() {
			return ++value;
		}
				
		void reset() {
			value = 0;
		}		
	}
}