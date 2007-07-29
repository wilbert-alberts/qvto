package org.eclipse.m2m.internal.qvt.oml.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class QvtKeywords {
		
	public static final Set<String> KEYWORDS = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(new String[] {
		"Bag", "Collection", "Dict", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"OrderedSet", "Sequence", "Set", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"Tuple", "abstract", "access", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"and", "any", "assert", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"blackbox", "break", "case", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"class", "collect", "collectNested", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"collectOne", "collectselect", "collectselectOne",//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"composes", "compute", "configuration",//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"constructor", "continue", "datatype",//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"default", "derived", "disjuncts", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"do", "elif", "else", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"end", "endif", "enum", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"except", "exists", "extends", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"extends", "false", "forAll", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"forEach ", "forOne", "from", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"helper", "if", "implies", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"import ", "in", "inherits", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"init", "inout", "intermediate",//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"invresolve", "invresolveIn", "invresolveone",//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"invresolveoneIn ", "isUnique", "iterate",//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"late", "let", "library", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"literal", "log", "main", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"map", "mapping", "merges", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"metamodel", "modeltype", "new", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"not", "null", "object", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"one", "or", "ordered", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"out", "package", "population", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"primitive", "property", "query", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"raise", "readonly", "references", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"refines", "reject", "resolve", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"resolveIn", "resolveone", "resolveoneIn", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"return", "select", "selectOne", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"sortedBy", "static", "switch", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"tag", "then", "transformation", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"true", "try", "typedef", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"unlimited", "uses", "var", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"when", "where", "while", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"with", "xcollect ", "xmap", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		"xor", "xselect" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	})));	
	
	private QvtKeywords() {
		super();
	}

	public static boolean isKeyword(String aString) {
		return KEYWORDS.contains(aString);
	}
}
