/**
* <copyright>
*
* Copyright (c) 2005, 2008 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - 225493 Need ability to set CSTNode offsets
*
* </copyright>
*
* $Id: LightweightTypeParsersym.java,v 1.63 2009/05/16 12:59:24 sboyko Exp $
*/
/**
* <copyright>
*
* Copyright (c) 2006, 2007 Borland Inc.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   Borland - Initial API and implementation
*
* </copyright>
*
* $Id: LightweightTypeParsersym.java,v 1.63 2009/05/16 12:59:24 sboyko Exp $
*/
/**
* <copyright>
*
* Copyright (c) 2006, 2007 Borland Inc.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   Borland - Initial API and implementation
*
* </copyright>
*
* $Id: LightweightTypeParsersym.java,v 1.63 2009/05/16 12:59:24 sboyko Exp $
*/
/**
* <copyright>
*
* Copyright (c) 2006, 2007 Borland Inc.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   Borland - Initial API and implementation
*
* </copyright>
*
* $Id: LightweightTypeParsersym.java,v 1.63 2009/05/16 12:59:24 sboyko Exp $
*/

package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.cst.parser;

public interface LightweightTypeParsersym {
    public final static int
      TK_NUMERIC_OPERATION = 71,
      TK_STRING_LITERAL = 39,
      TK_INTEGER_LITERAL = 55,
      TK_REAL_LITERAL = 56,
      TK_PLUS = 35,
      TK_MINUS = 36,
      TK_MULTIPLY = 15,
      TK_DIVIDE = 26,
      TK_GREATER = 21,
      TK_LESS = 22,
      TK_EQUAL = 4,
      TK_GREATER_EQUAL = 23,
      TK_LESS_EQUAL = 24,
      TK_NOT_EQUAL = 25,
      TK_LPAREN = 1,
      TK_RPAREN = 2,
      TK_LBRACE = 94,
      TK_RBRACE = 96,
      TK_LBRACKET = 100,
      TK_RBRACKET = 104,
      TK_ARROW = 107,
      TK_BAR = 97,
      TK_COMMA = 93,
      TK_COLON = 98,
      TK_COLONCOLON = 95,
      TK_SEMICOLON = 99,
      TK_DOT = 108,
      TK_DOTDOT = 115,
      TK_ATPRE = 102,
      TK_CARET = 109,
      TK_CARETCARET = 110,
      TK_QUESTIONMARK = 105,
      TK_ADD_ASSIGN = 116,
      TK_RESET_ASSIGN = 101,
      TK_AT_SIGN = 121,
      TK_EXCLAMATION_MARK = 106,
      TK_NOT_EQUAL_EXEQ = 103,
      TK_INTEGER_RANGE_START = 111,
      TK_class = 134,
      TK_composes = 135,
      TK_constructor = 136,
      TK_datatype = 137,
      TK_default = 138,
      TK_derived = 139,
      TK_do = 140,
      TK_elif = 141,
      TK_enum = 142,
      TK_except = 143,
      TK_exception = 144,
      TK_from = 145,
      TK_literal = 146,
      TK_ordered = 147,
      TK_primitive = 148,
      TK_raise = 149,
      TK_readonly = 150,
      TK_references = 151,
      TK_tag = 152,
      TK_try = 153,
      TK_typedef = 154,
      TK_unlimited = 155,
      TK_invalid = 156,
      TK_COLONCOLONEQUAL = 117,
      TK_STEREOTYPE_QUALIFIER_OPEN = 157,
      TK_STEREOTYPE_QUALIFIER_CLOSE = 158,
      TK_MULTIPLICITY_RANGE = 159,
      TK_TILDE_SIGN = 160,
      TK_self = 27,
      TK_inv = 161,
      TK_pre = 162,
      TK_post = 163,
      TK_endpackage = 164,
      TK_def = 165,
      TK_if = 72,
      TK_then = 118,
      TK_else = 112,
      TK_endif = 113,
      TK_and = 29,
      TK_or = 30,
      TK_xor = 31,
      TK_not = 57,
      TK_implies = 119,
      TK_let = 80,
      TK_in = 114,
      TK_true = 58,
      TK_false = 59,
      TK_body = 40,
      TK_derive = 41,
      TK_init = 166,
      TK_null = 32,
      TK_Set = 16,
      TK_Bag = 17,
      TK_Sequence = 18,
      TK_Collection = 19,
      TK_OrderedSet = 20,
      TK_iterate = 42,
      TK_forAll = 43,
      TK_exists = 44,
      TK_isUnique = 45,
      TK_any = 46,
      TK_one = 47,
      TK_collect = 48,
      TK_select = 49,
      TK_reject = 50,
      TK_collectNested = 51,
      TK_sortedBy = 52,
      TK_closure = 53,
      TK_oclIsKindOf = 60,
      TK_oclIsTypeOf = 61,
      TK_oclAsType = 62,
      TK_oclIsNew = 63,
      TK_oclIsUndefined = 64,
      TK_oclIsInvalid = 65,
      TK_oclIsInState = 66,
      TK_allInstances = 54,
      TK_String = 5,
      TK_Integer = 6,
      TK_UnlimitedNatural = 7,
      TK_Real = 8,
      TK_Boolean = 9,
      TK_Tuple = 33,
      TK_OclAny = 10,
      TK_OclVoid = 11,
      TK_Invalid = 12,
      TK_OclMessage = 13,
      TK_OclInvalid = 73,
      TK_end = 167,
      TK_while = 74,
      TK_when = 122,
      TK_var = 82,
      TK_log = 81,
      TK_assert = 83,
      TK_with = 123,
      TK_switch = 69,
      TK_case = 120,
      TK_xselect = 124,
      TK_xcollect = 125,
      TK_selectOne = 126,
      TK_collectOne = 127,
      TK_collectselect = 128,
      TK_collectselectOne = 129,
      TK_return = 84,
      TK_forEach = 130,
      TK_forOne = 131,
      TK_compute = 75,
      TK_new = 76,
      TK_List = 37,
      TK_Dict = 38,
      TK_break = 77,
      TK_continue = 78,
      TK_out = 168,
      TK_object = 79,
      TK_transformation = 169,
      TK_import = 170,
      TK_library = 171,
      TK_metamodel = 172,
      TK_mapping = 173,
      TK_query = 174,
      TK_helper = 175,
      TK_inout = 176,
      TK_configuration = 177,
      TK_intermediate = 178,
      TK_property = 179,
      TK_opposites = 180,
      TK_population = 181,
      TK_map = 67,
      TK_xmap = 68,
      TK_late = 70,
      TK_resolve = 85,
      TK_resolveone = 86,
      TK_resolveIn = 87,
      TK_resolveoneIn = 88,
      TK_invresolve = 89,
      TK_invresolveone = 90,
      TK_invresolveIn = 91,
      TK_invresolveoneIn = 92,
      TK_modeltype = 182,
      TK_uses = 183,
      TK_where = 184,
      TK_refines = 185,
      TK_access = 186,
      TK_extends = 187,
      TK_blackbox = 188,
      TK_abstract = 189,
      TK_static = 190,
      TK_result = 28,
      TK_main = 132,
      TK_this = 34,
      TK_rename = 191,
      TK_inherits = 192,
      TK_merges = 193,
      TK_disjuncts = 194,
      TK_IDENTIFIER = 3,
      TK_ERROR_TOKEN = 14,
      TK_EOF_TOKEN = 133;

      public final static String orderedTerminalSymbols[] = {
                 "", //$NON-NLS-1$
                 "LPAREN", //$NON-NLS-1$
                 "RPAREN", //$NON-NLS-1$
                 "IDENTIFIER", //$NON-NLS-1$
                 "EQUAL", //$NON-NLS-1$
                 "String", //$NON-NLS-1$
                 "Integer", //$NON-NLS-1$
                 "UnlimitedNatural", //$NON-NLS-1$
                 "Real", //$NON-NLS-1$
                 "Boolean", //$NON-NLS-1$
                 "OclAny", //$NON-NLS-1$
                 "OclVoid", //$NON-NLS-1$
                 "Invalid", //$NON-NLS-1$
                 "OclMessage", //$NON-NLS-1$
                 "ERROR_TOKEN", //$NON-NLS-1$
                 "MULTIPLY", //$NON-NLS-1$
                 "Set", //$NON-NLS-1$
                 "Bag", //$NON-NLS-1$
                 "Sequence", //$NON-NLS-1$
                 "Collection", //$NON-NLS-1$
                 "OrderedSet", //$NON-NLS-1$
                 "GREATER", //$NON-NLS-1$
                 "LESS", //$NON-NLS-1$
                 "GREATER_EQUAL", //$NON-NLS-1$
                 "LESS_EQUAL", //$NON-NLS-1$
                 "NOT_EQUAL", //$NON-NLS-1$
                 "DIVIDE", //$NON-NLS-1$
                 "self", //$NON-NLS-1$
                 "result", //$NON-NLS-1$
                 "and", //$NON-NLS-1$
                 "or", //$NON-NLS-1$
                 "xor", //$NON-NLS-1$
                 "null", //$NON-NLS-1$
                 "Tuple", //$NON-NLS-1$
                 "this", //$NON-NLS-1$
                 "PLUS", //$NON-NLS-1$
                 "MINUS", //$NON-NLS-1$
                 "List", //$NON-NLS-1$
                 "Dict", //$NON-NLS-1$
                 "STRING_LITERAL", //$NON-NLS-1$
                 "body", //$NON-NLS-1$
                 "derive", //$NON-NLS-1$
                 "iterate", //$NON-NLS-1$
                 "forAll", //$NON-NLS-1$
                 "exists", //$NON-NLS-1$
                 "isUnique", //$NON-NLS-1$
                 "any", //$NON-NLS-1$
                 "one", //$NON-NLS-1$
                 "collect", //$NON-NLS-1$
                 "select", //$NON-NLS-1$
                 "reject", //$NON-NLS-1$
                 "collectNested", //$NON-NLS-1$
                 "sortedBy", //$NON-NLS-1$
                 "closure", //$NON-NLS-1$
                 "allInstances", //$NON-NLS-1$
                 "INTEGER_LITERAL", //$NON-NLS-1$
                 "REAL_LITERAL", //$NON-NLS-1$
                 "not", //$NON-NLS-1$
                 "true", //$NON-NLS-1$
                 "false", //$NON-NLS-1$
                 "oclIsKindOf", //$NON-NLS-1$
                 "oclIsTypeOf", //$NON-NLS-1$
                 "oclAsType", //$NON-NLS-1$
                 "oclIsNew", //$NON-NLS-1$
                 "oclIsUndefined", //$NON-NLS-1$
                 "oclIsInvalid", //$NON-NLS-1$
                 "oclIsInState", //$NON-NLS-1$
                 "map", //$NON-NLS-1$
                 "xmap", //$NON-NLS-1$
                 "switch", //$NON-NLS-1$
                 "late", //$NON-NLS-1$
                 "NUMERIC_OPERATION", //$NON-NLS-1$
                 "if", //$NON-NLS-1$
                 "OclInvalid", //$NON-NLS-1$
                 "while", //$NON-NLS-1$
                 "compute", //$NON-NLS-1$
                 "new", //$NON-NLS-1$
                 "break", //$NON-NLS-1$
                 "continue", //$NON-NLS-1$
                 "object", //$NON-NLS-1$
                 "let", //$NON-NLS-1$
                 "log", //$NON-NLS-1$
                 "var", //$NON-NLS-1$
                 "assert", //$NON-NLS-1$
                 "return", //$NON-NLS-1$
                 "resolve", //$NON-NLS-1$
                 "resolveone", //$NON-NLS-1$
                 "resolveIn", //$NON-NLS-1$
                 "resolveoneIn", //$NON-NLS-1$
                 "invresolve", //$NON-NLS-1$
                 "invresolveone", //$NON-NLS-1$
                 "invresolveIn", //$NON-NLS-1$
                 "invresolveoneIn", //$NON-NLS-1$
                 "COMMA", //$NON-NLS-1$
                 "LBRACE", //$NON-NLS-1$
                 "COLONCOLON", //$NON-NLS-1$
                 "RBRACE", //$NON-NLS-1$
                 "BAR", //$NON-NLS-1$
                 "COLON", //$NON-NLS-1$
                 "SEMICOLON", //$NON-NLS-1$
                 "LBRACKET", //$NON-NLS-1$
                 "RESET_ASSIGN", //$NON-NLS-1$
                 "ATPRE", //$NON-NLS-1$
                 "NOT_EQUAL_EXEQ", //$NON-NLS-1$
                 "RBRACKET", //$NON-NLS-1$
                 "QUESTIONMARK", //$NON-NLS-1$
                 "EXCLAMATION_MARK", //$NON-NLS-1$
                 "ARROW", //$NON-NLS-1$
                 "DOT", //$NON-NLS-1$
                 "CARET", //$NON-NLS-1$
                 "CARETCARET", //$NON-NLS-1$
                 "INTEGER_RANGE_START", //$NON-NLS-1$
                 "else", //$NON-NLS-1$
                 "endif", //$NON-NLS-1$
                 "in", //$NON-NLS-1$
                 "DOTDOT", //$NON-NLS-1$
                 "ADD_ASSIGN", //$NON-NLS-1$
                 "COLONCOLONEQUAL", //$NON-NLS-1$
                 "then", //$NON-NLS-1$
                 "implies", //$NON-NLS-1$
                 "case", //$NON-NLS-1$
                 "AT_SIGN", //$NON-NLS-1$
                 "when", //$NON-NLS-1$
                 "with", //$NON-NLS-1$
                 "xselect", //$NON-NLS-1$
                 "xcollect", //$NON-NLS-1$
                 "selectOne", //$NON-NLS-1$
                 "collectOne", //$NON-NLS-1$
                 "collectselect", //$NON-NLS-1$
                 "collectselectOne", //$NON-NLS-1$
                 "forEach", //$NON-NLS-1$
                 "forOne", //$NON-NLS-1$
                 "main", //$NON-NLS-1$
                 "EOF_TOKEN", //$NON-NLS-1$
                 "class", //$NON-NLS-1$
                 "composes", //$NON-NLS-1$
                 "constructor", //$NON-NLS-1$
                 "datatype", //$NON-NLS-1$
                 "default", //$NON-NLS-1$
                 "derived", //$NON-NLS-1$
                 "do", //$NON-NLS-1$
                 "elif", //$NON-NLS-1$
                 "enum", //$NON-NLS-1$
                 "except", //$NON-NLS-1$
                 "exception", //$NON-NLS-1$
                 "from", //$NON-NLS-1$
                 "literal", //$NON-NLS-1$
                 "ordered", //$NON-NLS-1$
                 "primitive", //$NON-NLS-1$
                 "raise", //$NON-NLS-1$
                 "readonly", //$NON-NLS-1$
                 "references", //$NON-NLS-1$
                 "tag", //$NON-NLS-1$
                 "try", //$NON-NLS-1$
                 "typedef", //$NON-NLS-1$
                 "unlimited", //$NON-NLS-1$
                 "invalid", //$NON-NLS-1$
                 "STEREOTYPE_QUALIFIER_OPEN", //$NON-NLS-1$
                 "STEREOTYPE_QUALIFIER_CLOSE", //$NON-NLS-1$
                 "MULTIPLICITY_RANGE", //$NON-NLS-1$
                 "TILDE_SIGN", //$NON-NLS-1$
                 "inv", //$NON-NLS-1$
                 "pre", //$NON-NLS-1$
                 "post", //$NON-NLS-1$
                 "endpackage", //$NON-NLS-1$
                 "def", //$NON-NLS-1$
                 "init", //$NON-NLS-1$
                 "end", //$NON-NLS-1$
                 "out", //$NON-NLS-1$
                 "transformation", //$NON-NLS-1$
                 "import", //$NON-NLS-1$
                 "library", //$NON-NLS-1$
                 "metamodel", //$NON-NLS-1$
                 "mapping", //$NON-NLS-1$
                 "query", //$NON-NLS-1$
                 "helper", //$NON-NLS-1$
                 "inout", //$NON-NLS-1$
                 "configuration", //$NON-NLS-1$
                 "intermediate", //$NON-NLS-1$
                 "property", //$NON-NLS-1$
                 "opposites", //$NON-NLS-1$
                 "population", //$NON-NLS-1$
                 "modeltype", //$NON-NLS-1$
                 "uses", //$NON-NLS-1$
                 "where", //$NON-NLS-1$
                 "refines", //$NON-NLS-1$
                 "access", //$NON-NLS-1$
                 "extends", //$NON-NLS-1$
                 "blackbox", //$NON-NLS-1$
                 "abstract", //$NON-NLS-1$
                 "static", //$NON-NLS-1$
                 "rename", //$NON-NLS-1$
                 "inherits", //$NON-NLS-1$
                 "merges", //$NON-NLS-1$
                 "disjuncts" //$NON-NLS-1$
             };

    public final static boolean isValidForParser = true;
}
