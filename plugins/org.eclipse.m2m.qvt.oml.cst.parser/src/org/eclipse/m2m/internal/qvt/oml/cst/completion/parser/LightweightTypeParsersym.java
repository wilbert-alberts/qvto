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
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias):
*        - 242153: LPG v 2.0.17 adoption.
*        - 299396: Introducing new LPG templates
*        - 300534: Removing the use of deprecated macros.
* </copyright>
*
* $Id: LightweightTypeParsersym.java,v 1.10 2010/02/03 18:18:50 sboyko Exp $
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
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (297966)
*
* </copyright>
*
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
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (297966)
*
* </copyright>
*
*/

package org.eclipse.m2m.internal.qvt.oml.cst.completion.parser;

public interface LightweightTypeParsersym {
    public final static int
      TK_INTEGER_LITERAL = 27,
      TK_REAL_LITERAL = 28,
      TK_STRING_LITERAL = 29,
      TK_PLUS = 30,
      TK_MINUS = 31,
      TK_MULTIPLY = 32,
      TK_DIVIDE = 33,
      TK_GREATER = 34,
      TK_LESS = 35,
      TK_EQUAL = 36,
      TK_GREATER_EQUAL = 37,
      TK_LESS_EQUAL = 38,
      TK_NOT_EQUAL = 39,
      TK_LPAREN = 2,
      TK_RPAREN = 3,
      TK_LBRACE = 40,
      TK_RBRACE = 41,
      TK_LBRACKET = 42,
      TK_RBRACKET = 43,
      TK_ARROW = 44,
      TK_BAR = 45,
      TK_COMMA = 6,
      TK_COLON = 21,
      TK_COLONCOLON = 22,
      TK_SEMICOLON = 46,
      TK_DOT = 47,
      TK_DOTDOT = 48,
      TK_RESET_ASSIGN = 49,
      TK_ADD_ASSIGN = 50,
      TK_EXCLAMATION_MARK = 51,
      TK_COLONCOLONEQUAL = 52,
      TK_QUESTIONMARK = 53,
      TK_SINGLE_LINE_COMMENT = 54,
      TK_MULTI_LINE_COMMENT = 55,
      TK_STEREOTYPE_QUALIFIER_OPEN = 56,
      TK_STEREOTYPE_QUALIFIER_CLOSE = 57,
      TK_MULTIPLICITY_RANGE = 58,
      TK_TILDE_SIGN = 59,
      TK_NOT_EQUAL_EXEQ = 60,
      TK_AT_SIGN = 23,
      TK_and = 61,
      TK_implies = 62,
      TK_not = 63,
      TK_or = 64,
      TK_xor = 65,
      TK_if = 66,
      TK_then = 67,
      TK_else = 68,
      TK_endif = 69,
      TK_let = 70,
      TK_in = 71,
      TK_false = 72,
      TK_true = 73,
      TK_null = 74,
      TK_invalid = 75,
      TK_self = 76,
      TK_Bag = 7,
      TK_Collection = 8,
      TK_OrderedSet = 9,
      TK_Sequence = 10,
      TK_Set = 11,
      TK_Tuple = 12,
      TK_Boolean = 13,
      TK_Integer = 14,
      TK_Real = 15,
      TK_String = 16,
      TK_UnlimitedNatural = 17,
      TK_OclAny = 18,
      TK_OclInvalid = 19,
      TK_OclVoid = 20,
      TK_Dict = 24,
      TK_List = 25,
      TK_break = 77,
      TK_switch = 78,
      TK_case = 79,
      TK_xselect = 80,
      TK_xcollect = 81,
      TK_selectOne = 82,
      TK_collectOne = 83,
      TK_collectselect = 84,
      TK_collectselectOne = 85,
      TK_return = 86,
      TK_forEach = 87,
      TK_forOne = 88,
      TK_var = 89,
      TK_while = 90,
      TK_continue = 91,
      TK_log = 92,
      TK_assert = 93,
      TK_with = 94,
      TK_compute = 95,
      TK_new = 96,
      TK_init = 97,
      TK_static = 98,
      TK_end = 99,
      TK_out = 100,
      TK_object = 101,
      TK_transformation = 102,
      TK_import = 103,
      TK_library = 104,
      TK_metamodel = 105,
      TK_mapping = 106,
      TK_query = 107,
      TK_helper = 108,
      TK_inout = 109,
      TK_when = 110,
      TK_configuration = 111,
      TK_intermediate = 112,
      TK_property = 113,
      TK_opposites = 114,
      TK_class = 115,
      TK_population = 116,
      TK_map = 117,
      TK_xmap = 118,
      TK_late = 119,
      TK_resolve = 120,
      TK_resolveone = 121,
      TK_resolveIn = 122,
      TK_resolveoneIn = 123,
      TK_invresolve = 124,
      TK_invresolveone = 125,
      TK_invresolveIn = 126,
      TK_invresolveoneIn = 127,
      TK_modeltype = 128,
      TK_uses = 129,
      TK_where = 130,
      TK_refines = 131,
      TK_access = 132,
      TK_extends = 133,
      TK_blackbox = 134,
      TK_abstract = 135,
      TK_result = 4,
      TK_main = 136,
      TK_this = 5,
      TK_rename = 137,
      TK_disjuncts = 138,
      TK_merges = 139,
      TK_inherits = 140,
      TK_composes = 141,
      TK_constructor = 142,
      TK_datatype = 143,
      TK_default = 144,
      TK_derived = 145,
      TK_do = 146,
      TK_elif = 147,
      TK_enum = 148,
      TK_except = 149,
      TK_exception = 150,
      TK_from = 151,
      TK_literal = 152,
      TK_ordered = 153,
      TK_primitive = 154,
      TK_raise = 155,
      TK_readonly = 156,
      TK_references = 157,
      TK_tag = 158,
      TK_try = 159,
      TK_typedef = 160,
      TK_unlimited = 161,
      TK_ERROR_TOKEN = 162,
      TK_IDENTIFIER = 1,
      TK_EOF_TOKEN = 26;

    public final static String orderedTerminalSymbols[] = {
                 "", //$NON-NLS-1$
                 "IDENTIFIER", //$NON-NLS-1$
                 "LPAREN", //$NON-NLS-1$
                 "RPAREN", //$NON-NLS-1$
                 "result", //$NON-NLS-1$
                 "this", //$NON-NLS-1$
                 "COMMA", //$NON-NLS-1$
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
                 "COLON", //$NON-NLS-1$
                 "COLONCOLON", //$NON-NLS-1$
                 "AT_SIGN", //$NON-NLS-1$
                 "Dict", //$NON-NLS-1$
                 "List", //$NON-NLS-1$
                 "EOF_TOKEN", //$NON-NLS-1$
                 "INTEGER_LITERAL", //$NON-NLS-1$
                 "REAL_LITERAL", //$NON-NLS-1$
                 "STRING_LITERAL", //$NON-NLS-1$
                 "PLUS", //$NON-NLS-1$
                 "MINUS", //$NON-NLS-1$
                 "MULTIPLY", //$NON-NLS-1$
                 "DIVIDE", //$NON-NLS-1$
                 "GREATER", //$NON-NLS-1$
                 "LESS", //$NON-NLS-1$
                 "EQUAL", //$NON-NLS-1$
                 "GREATER_EQUAL", //$NON-NLS-1$
                 "LESS_EQUAL", //$NON-NLS-1$
                 "NOT_EQUAL", //$NON-NLS-1$
                 "LBRACE", //$NON-NLS-1$
                 "RBRACE", //$NON-NLS-1$
                 "LBRACKET", //$NON-NLS-1$
                 "RBRACKET", //$NON-NLS-1$
                 "ARROW", //$NON-NLS-1$
                 "BAR", //$NON-NLS-1$
                 "SEMICOLON", //$NON-NLS-1$
                 "DOT", //$NON-NLS-1$
                 "DOTDOT", //$NON-NLS-1$
                 "RESET_ASSIGN", //$NON-NLS-1$
                 "ADD_ASSIGN", //$NON-NLS-1$
                 "EXCLAMATION_MARK", //$NON-NLS-1$
                 "COLONCOLONEQUAL", //$NON-NLS-1$
                 "QUESTIONMARK", //$NON-NLS-1$
                 "SINGLE_LINE_COMMENT", //$NON-NLS-1$
                 "MULTI_LINE_COMMENT", //$NON-NLS-1$
                 "STEREOTYPE_QUALIFIER_OPEN", //$NON-NLS-1$
                 "STEREOTYPE_QUALIFIER_CLOSE", //$NON-NLS-1$
                 "MULTIPLICITY_RANGE", //$NON-NLS-1$
                 "TILDE_SIGN", //$NON-NLS-1$
                 "NOT_EQUAL_EXEQ", //$NON-NLS-1$
                 "and", //$NON-NLS-1$
                 "implies", //$NON-NLS-1$
                 "not", //$NON-NLS-1$
                 "or", //$NON-NLS-1$
                 "xor", //$NON-NLS-1$
                 "if", //$NON-NLS-1$
                 "then", //$NON-NLS-1$
                 "else", //$NON-NLS-1$
                 "endif", //$NON-NLS-1$
                 "let", //$NON-NLS-1$
                 "in", //$NON-NLS-1$
                 "false", //$NON-NLS-1$
                 "true", //$NON-NLS-1$
                 "null", //$NON-NLS-1$
                 "invalid", //$NON-NLS-1$
                 "self", //$NON-NLS-1$
                 "break", //$NON-NLS-1$
                 "switch", //$NON-NLS-1$
                 "case", //$NON-NLS-1$
                 "xselect", //$NON-NLS-1$
                 "xcollect", //$NON-NLS-1$
                 "selectOne", //$NON-NLS-1$
                 "collectOne", //$NON-NLS-1$
                 "collectselect", //$NON-NLS-1$
                 "collectselectOne", //$NON-NLS-1$
                 "return", //$NON-NLS-1$
                 "forEach", //$NON-NLS-1$
                 "forOne", //$NON-NLS-1$
                 "var", //$NON-NLS-1$
                 "while", //$NON-NLS-1$
                 "continue", //$NON-NLS-1$
                 "log", //$NON-NLS-1$
                 "assert", //$NON-NLS-1$
                 "with", //$NON-NLS-1$
                 "compute", //$NON-NLS-1$
                 "new", //$NON-NLS-1$
                 "init", //$NON-NLS-1$
                 "static", //$NON-NLS-1$
                 "end", //$NON-NLS-1$
                 "out", //$NON-NLS-1$
                 "object", //$NON-NLS-1$
                 "transformation", //$NON-NLS-1$
                 "import", //$NON-NLS-1$
                 "library", //$NON-NLS-1$
                 "metamodel", //$NON-NLS-1$
                 "mapping", //$NON-NLS-1$
                 "query", //$NON-NLS-1$
                 "helper", //$NON-NLS-1$
                 "inout", //$NON-NLS-1$
                 "when", //$NON-NLS-1$
                 "configuration", //$NON-NLS-1$
                 "intermediate", //$NON-NLS-1$
                 "property", //$NON-NLS-1$
                 "opposites", //$NON-NLS-1$
                 "class", //$NON-NLS-1$
                 "population", //$NON-NLS-1$
                 "map", //$NON-NLS-1$
                 "xmap", //$NON-NLS-1$
                 "late", //$NON-NLS-1$
                 "resolve", //$NON-NLS-1$
                 "resolveone", //$NON-NLS-1$
                 "resolveIn", //$NON-NLS-1$
                 "resolveoneIn", //$NON-NLS-1$
                 "invresolve", //$NON-NLS-1$
                 "invresolveone", //$NON-NLS-1$
                 "invresolveIn", //$NON-NLS-1$
                 "invresolveoneIn", //$NON-NLS-1$
                 "modeltype", //$NON-NLS-1$
                 "uses", //$NON-NLS-1$
                 "where", //$NON-NLS-1$
                 "refines", //$NON-NLS-1$
                 "access", //$NON-NLS-1$
                 "extends", //$NON-NLS-1$
                 "blackbox", //$NON-NLS-1$
                 "abstract", //$NON-NLS-1$
                 "main", //$NON-NLS-1$
                 "rename", //$NON-NLS-1$
                 "disjuncts", //$NON-NLS-1$
                 "merges", //$NON-NLS-1$
                 "inherits", //$NON-NLS-1$
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
                 "ERROR_TOKEN" //$NON-NLS-1$
             };

    public final static int numTokenKinds = orderedTerminalSymbols.length;
    public final static boolean isValidForParser = true;
}
