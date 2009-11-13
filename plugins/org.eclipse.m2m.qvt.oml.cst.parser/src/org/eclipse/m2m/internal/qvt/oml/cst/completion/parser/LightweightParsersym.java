/**
* Essential OCL Grammar
* <copyright>
*
* Copyright (c) 2005, 2009 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - Bugs 184048, 225493, 243976, 259818, 282882, 287993, 288040, 292112
*   Borland - Bug 242880
*
* </copyright>
*
* $Id: LightweightParsersym.java,v 1.1 2009/11/13 22:09:02 sboyko Exp $
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
* $Id: LightweightParsersym.java,v 1.1 2009/11/13 22:09:02 sboyko Exp $
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
* $Id: LightweightParsersym.java,v 1.1 2009/11/13 22:09:02 sboyko Exp $
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
* $Id: LightweightParsersym.java,v 1.1 2009/11/13 22:09:02 sboyko Exp $
*/

package org.eclipse.m2m.internal.qvt.oml.cst.completion.parser;

public interface LightweightParsersym {
    public final static int
      TK_INTEGER_LITERAL = 28,
      TK_REAL_LITERAL = 29,
      TK_STRING_LITERAL = 25,
      TK_PLUS = 68,
      TK_MINUS = 9,
      TK_MULTIPLY = 8,
      TK_DIVIDE = 69,
      TK_GREATER = 72,
      TK_LESS = 73,
      TK_EQUAL = 63,
      TK_GREATER_EQUAL = 74,
      TK_LESS_EQUAL = 75,
      TK_NOT_EQUAL = 76,
      TK_LPAREN = 2,
      TK_RPAREN = 4,
      TK_LBRACE = 62,
      TK_RBRACE = 65,
      TK_LBRACKET = 70,
      TK_RBRACKET = 105,
      TK_ARROW = 24,
      TK_BAR = 67,
      TK_COMMA = 61,
      TK_COLON = 64,
      TK_COLONCOLON = 66,
      TK_SEMICOLON = 52,
      TK_DOT = 7,
      TK_DOTDOT = 106,
      TK_ADD_ASSIGN = 99,
      TK_RESET_ASSIGN = 77,
      TK_AT = 107,
      TK_EXCLAMATION_MARK = 71,
      TK_NOT_EQUAL_EXEQ = 79,
      TK_class = 119,
      TK_composes = 120,
      TK_constructor = 86,
      TK_datatype = 146,
      TK_default = 147,
      TK_derived = 121,
      TK_do = 148,
      TK_elif = 149,
      TK_enum = 150,
      TK_except = 151,
      TK_exception = 152,
      TK_from = 153,
      TK_literal = 154,
      TK_ordered = 122,
      TK_primitive = 155,
      TK_raise = 156,
      TK_readonly = 123,
      TK_references = 124,
      TK_tag = 87,
      TK_try = 157,
      TK_typedef = 158,
      TK_unlimited = 159,
      TK_invalid = 30,
      TK_COLONCOLONEQUAL = 108,
      TK_QUESTIONMARK = 109,
      TK_STEREOTYPE_QUALIFIER_OPEN = 110,
      TK_STEREOTYPE_QUALIFIER_CLOSE = 125,
      TK_MULTIPLICITY_RANGE = 126,
      TK_TILDE_SIGN = 127,
      TK_and = 80,
      TK_implies = 96,
      TK_not = 37,
      TK_or = 83,
      TK_xor = 88,
      TK_if = 40,
      TK_then = 128,
      TK_else = 111,
      TK_endif = 112,
      TK_let = 41,
      TK_in = 84,
      TK_false = 31,
      TK_true = 32,
      TK_null = 33,
      TK_self = 38,
      TK_Bag = 10,
      TK_Collection = 11,
      TK_OrderedSet = 12,
      TK_Sequence = 13,
      TK_Set = 14,
      TK_Tuple = 15,
      TK_Boolean = 16,
      TK_Integer = 17,
      TK_Real = 18,
      TK_String = 19,
      TK_UnlimitedNatural = 20,
      TK_OclAny = 21,
      TK_OclInvalid = 22,
      TK_OclVoid = 23,
      TK_end = 89,
      TK_while = 42,
      TK_when = 100,
      TK_var = 49,
      TK_log = 43,
      TK_assert = 50,
      TK_with = 129,
      TK_switch = 39,
      TK_case = 113,
      TK_xselect = 130,
      TK_xcollect = 131,
      TK_selectOne = 132,
      TK_collectOne = 133,
      TK_collectselect = 134,
      TK_collectselectOne = 135,
      TK_return = 51,
      TK_forEach = 136,
      TK_forOne = 137,
      TK_compute = 44,
      TK_new = 45,
      TK_List = 26,
      TK_Dict = 27,
      TK_break = 46,
      TK_continue = 47,
      TK_out = 97,
      TK_object = 48,
      TK_transformation = 101,
      TK_import = 138,
      TK_library = 102,
      TK_metamodel = 160,
      TK_mapping = 90,
      TK_query = 91,
      TK_helper = 92,
      TK_inout = 98,
      TK_configuration = 103,
      TK_intermediate = 104,
      TK_property = 93,
      TK_opposites = 139,
      TK_population = 114,
      TK_map = 34,
      TK_xmap = 35,
      TK_late = 36,
      TK_resolve = 53,
      TK_resolveone = 54,
      TK_resolveIn = 55,
      TK_resolveoneIn = 56,
      TK_invresolve = 57,
      TK_invresolveone = 58,
      TK_invresolveIn = 59,
      TK_invresolveoneIn = 60,
      TK_modeltype = 140,
      TK_uses = 141,
      TK_where = 142,
      TK_refines = 143,
      TK_access = 81,
      TK_extends = 78,
      TK_blackbox = 94,
      TK_abstract = 95,
      TK_static = 85,
      TK_result = 5,
      TK_main = 82,
      TK_this = 6,
      TK_rename = 144,
      TK_inherits = 115,
      TK_merges = 116,
      TK_disjuncts = 117,
      TK_IDENTIFIER = 3,
      TK_init = 145,
      TK_ERROR_TOKEN = 1,
      TK_EOF_TOKEN = 118;

      public final static String orderedTerminalSymbols[] = {
                 "", //$NON-NLS-1$
                 "ERROR_TOKEN", //$NON-NLS-1$
                 "LPAREN", //$NON-NLS-1$
                 "IDENTIFIER", //$NON-NLS-1$
                 "RPAREN", //$NON-NLS-1$
                 "result", //$NON-NLS-1$
                 "this", //$NON-NLS-1$
                 "DOT", //$NON-NLS-1$
                 "MULTIPLY", //$NON-NLS-1$
                 "MINUS", //$NON-NLS-1$
                 "Bag", //$NON-NLS-1$
                 "Collection", //$NON-NLS-1$
                 "OrderedSet", //$NON-NLS-1$
                 "Sequence", //$NON-NLS-1$
                 "Set", //$NON-NLS-1$
                 "Tuple", //$NON-NLS-1$
                 "Boolean", //$NON-NLS-1$
                 "Integer", //$NON-NLS-1$
                 "Real", //$NON-NLS-1$
                 "String", //$NON-NLS-1$
                 "UnlimitedNatural", //$NON-NLS-1$
                 "OclAny", //$NON-NLS-1$
                 "OclInvalid", //$NON-NLS-1$
                 "OclVoid", //$NON-NLS-1$
                 "ARROW", //$NON-NLS-1$
                 "STRING_LITERAL", //$NON-NLS-1$
                 "List", //$NON-NLS-1$
                 "Dict", //$NON-NLS-1$
                 "INTEGER_LITERAL", //$NON-NLS-1$
                 "REAL_LITERAL", //$NON-NLS-1$
                 "invalid", //$NON-NLS-1$
                 "false", //$NON-NLS-1$
                 "true", //$NON-NLS-1$
                 "null", //$NON-NLS-1$
                 "map", //$NON-NLS-1$
                 "xmap", //$NON-NLS-1$
                 "late", //$NON-NLS-1$
                 "not", //$NON-NLS-1$
                 "self", //$NON-NLS-1$
                 "switch", //$NON-NLS-1$
                 "if", //$NON-NLS-1$
                 "let", //$NON-NLS-1$
                 "while", //$NON-NLS-1$
                 "log", //$NON-NLS-1$
                 "compute", //$NON-NLS-1$
                 "new", //$NON-NLS-1$
                 "break", //$NON-NLS-1$
                 "continue", //$NON-NLS-1$
                 "object", //$NON-NLS-1$
                 "var", //$NON-NLS-1$
                 "assert", //$NON-NLS-1$
                 "return", //$NON-NLS-1$
                 "SEMICOLON", //$NON-NLS-1$
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
                 "EQUAL", //$NON-NLS-1$
                 "COLON", //$NON-NLS-1$
                 "RBRACE", //$NON-NLS-1$
                 "COLONCOLON", //$NON-NLS-1$
                 "BAR", //$NON-NLS-1$
                 "PLUS", //$NON-NLS-1$
                 "DIVIDE", //$NON-NLS-1$
                 "LBRACKET", //$NON-NLS-1$
                 "EXCLAMATION_MARK", //$NON-NLS-1$
                 "GREATER", //$NON-NLS-1$
                 "LESS", //$NON-NLS-1$
                 "GREATER_EQUAL", //$NON-NLS-1$
                 "LESS_EQUAL", //$NON-NLS-1$
                 "NOT_EQUAL", //$NON-NLS-1$
                 "RESET_ASSIGN", //$NON-NLS-1$
                 "extends", //$NON-NLS-1$
                 "NOT_EQUAL_EXEQ", //$NON-NLS-1$
                 "and", //$NON-NLS-1$
                 "access", //$NON-NLS-1$
                 "main", //$NON-NLS-1$
                 "or", //$NON-NLS-1$
                 "in", //$NON-NLS-1$
                 "static", //$NON-NLS-1$
                 "constructor", //$NON-NLS-1$
                 "tag", //$NON-NLS-1$
                 "xor", //$NON-NLS-1$
                 "end", //$NON-NLS-1$
                 "mapping", //$NON-NLS-1$
                 "query", //$NON-NLS-1$
                 "helper", //$NON-NLS-1$
                 "property", //$NON-NLS-1$
                 "blackbox", //$NON-NLS-1$
                 "abstract", //$NON-NLS-1$
                 "implies", //$NON-NLS-1$
                 "out", //$NON-NLS-1$
                 "inout", //$NON-NLS-1$
                 "ADD_ASSIGN", //$NON-NLS-1$
                 "when", //$NON-NLS-1$
                 "transformation", //$NON-NLS-1$
                 "library", //$NON-NLS-1$
                 "configuration", //$NON-NLS-1$
                 "intermediate", //$NON-NLS-1$
                 "RBRACKET", //$NON-NLS-1$
                 "DOTDOT", //$NON-NLS-1$
                 "AT", //$NON-NLS-1$
                 "COLONCOLONEQUAL", //$NON-NLS-1$
                 "QUESTIONMARK", //$NON-NLS-1$
                 "STEREOTYPE_QUALIFIER_OPEN", //$NON-NLS-1$
                 "else", //$NON-NLS-1$
                 "endif", //$NON-NLS-1$
                 "case", //$NON-NLS-1$
                 "population", //$NON-NLS-1$
                 "inherits", //$NON-NLS-1$
                 "merges", //$NON-NLS-1$
                 "disjuncts", //$NON-NLS-1$
                 "EOF_TOKEN", //$NON-NLS-1$
                 "class", //$NON-NLS-1$
                 "composes", //$NON-NLS-1$
                 "derived", //$NON-NLS-1$
                 "ordered", //$NON-NLS-1$
                 "readonly", //$NON-NLS-1$
                 "references", //$NON-NLS-1$
                 "STEREOTYPE_QUALIFIER_CLOSE", //$NON-NLS-1$
                 "MULTIPLICITY_RANGE", //$NON-NLS-1$
                 "TILDE_SIGN", //$NON-NLS-1$
                 "then", //$NON-NLS-1$
                 "with", //$NON-NLS-1$
                 "xselect", //$NON-NLS-1$
                 "xcollect", //$NON-NLS-1$
                 "selectOne", //$NON-NLS-1$
                 "collectOne", //$NON-NLS-1$
                 "collectselect", //$NON-NLS-1$
                 "collectselectOne", //$NON-NLS-1$
                 "forEach", //$NON-NLS-1$
                 "forOne", //$NON-NLS-1$
                 "import", //$NON-NLS-1$
                 "opposites", //$NON-NLS-1$
                 "modeltype", //$NON-NLS-1$
                 "uses", //$NON-NLS-1$
                 "where", //$NON-NLS-1$
                 "refines", //$NON-NLS-1$
                 "rename", //$NON-NLS-1$
                 "init", //$NON-NLS-1$
                 "datatype", //$NON-NLS-1$
                 "default", //$NON-NLS-1$
                 "do", //$NON-NLS-1$
                 "elif", //$NON-NLS-1$
                 "enum", //$NON-NLS-1$
                 "except", //$NON-NLS-1$
                 "exception", //$NON-NLS-1$
                 "from", //$NON-NLS-1$
                 "literal", //$NON-NLS-1$
                 "primitive", //$NON-NLS-1$
                 "raise", //$NON-NLS-1$
                 "try", //$NON-NLS-1$
                 "typedef", //$NON-NLS-1$
                 "unlimited", //$NON-NLS-1$
                 "metamodel" //$NON-NLS-1$
             };

    public final static boolean isValidForParser = true;
}
