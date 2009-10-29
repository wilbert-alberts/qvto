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
* $Id: LightweightTypeParsersym.java,v 1.63.4.4 2009/10/29 21:37:16 sboyko Exp $
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
* $Id: LightweightTypeParsersym.java,v 1.63.4.4 2009/10/29 21:37:16 sboyko Exp $
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
* $Id: LightweightTypeParsersym.java,v 1.63.4.4 2009/10/29 21:37:16 sboyko Exp $
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
* $Id: LightweightTypeParsersym.java,v 1.63.4.4 2009/10/29 21:37:16 sboyko Exp $
*/

package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.cst.parser;

public interface LightweightTypeParsersym {
    public final static int
      TK_STRING_LITERAL = 42,
      TK_INTEGER_LITERAL = 44,
      TK_REAL_LITERAL = 45,
      TK_PLUS = 80,
      TK_MINUS = 37,
      TK_MULTIPLY = 38,
      TK_DIVIDE = 89,
      TK_GREATER = 82,
      TK_LESS = 83,
      TK_EQUAL = 76,
      TK_GREATER_EQUAL = 84,
      TK_LESS_EQUAL = 85,
      TK_NOT_EQUAL = 94,
      TK_LPAREN = 1,
      TK_RPAREN = 3,
      TK_LBRACE = 77,
      TK_RBRACE = 78,
      TK_LBRACKET = 95,
      TK_RBRACKET = 103,
      TK_ARROW = 46,
      TK_BAR = 75,
      TK_COMMA = 72,
      TK_COLON = 74,
      TK_COLONCOLON = 73,
      TK_SEMICOLON = 79,
      TK_DOT = 47,
      TK_DOTDOT = 104,
      TK_ADD_ASSIGN = 105,
      TK_RESET_ASSIGN = 81,
      TK_AT = 97,
      TK_EXCLAMATION_MARK = 98,
      TK_NOT_EQUAL_EXEQ = 99,
      TK_class = 118,
      TK_composes = 119,
      TK_constructor = 120,
      TK_datatype = 121,
      TK_default = 122,
      TK_derived = 123,
      TK_do = 124,
      TK_elif = 125,
      TK_enum = 126,
      TK_except = 127,
      TK_exception = 128,
      TK_from = 129,
      TK_literal = 130,
      TK_ordered = 131,
      TK_primitive = 132,
      TK_raise = 133,
      TK_readonly = 134,
      TK_references = 135,
      TK_tag = 136,
      TK_try = 137,
      TK_typedef = 138,
      TK_unlimited = 139,
      TK_invalid = 21,
      TK_COLONCOLONEQUAL = 100,
      TK_QUESTIONMARK = 101,
      TK_STEREOTYPE_QUALIFIER_OPEN = 140,
      TK_STEREOTYPE_QUALIFIER_CLOSE = 141,
      TK_MULTIPLICITY_RANGE = 142,
      TK_TILDE_SIGN = 143,
      TK_and = 86,
      TK_else = 90,
      TK_endif = 91,
      TK_if = 48,
      TK_implies = 92,
      TK_in = 93,
      TK_let = 49,
      TK_not = 43,
      TK_or = 87,
      TK_then = 96,
      TK_xor = 88,
      TK_false = 5,
      TK_null = 6,
      TK_self = 22,
      TK_true = 7,
      TK_Set = 8,
      TK_Bag = 9,
      TK_Sequence = 10,
      TK_Collection = 11,
      TK_OrderedSet = 12,
      TK_String = 13,
      TK_Integer = 14,
      TK_UnlimitedNatural = 15,
      TK_Real = 16,
      TK_Boolean = 17,
      TK_Tuple = 39,
      TK_OclAny = 18,
      TK_OclVoid = 19,
      TK_OclInvalid = 20,
      TK_iterate = 23,
      TK_forAll = 24,
      TK_exists = 25,
      TK_isUnique = 26,
      TK_any = 27,
      TK_one = 28,
      TK_collect = 29,
      TK_select = 30,
      TK_reject = 31,
      TK_collectNested = 32,
      TK_sortedBy = 33,
      TK_closure = 34,
      TK_end = 144,
      TK_while = 54,
      TK_when = 106,
      TK_var = 61,
      TK_log = 55,
      TK_assert = 62,
      TK_with = 107,
      TK_switch = 53,
      TK_case = 102,
      TK_xselect = 108,
      TK_xcollect = 109,
      TK_selectOne = 110,
      TK_collectOne = 111,
      TK_collectselect = 112,
      TK_collectselectOne = 113,
      TK_return = 63,
      TK_forEach = 114,
      TK_forOne = 115,
      TK_compute = 56,
      TK_new = 57,
      TK_List = 40,
      TK_Dict = 41,
      TK_break = 58,
      TK_continue = 59,
      TK_out = 145,
      TK_object = 60,
      TK_transformation = 146,
      TK_import = 147,
      TK_library = 148,
      TK_metamodel = 149,
      TK_mapping = 150,
      TK_query = 151,
      TK_helper = 152,
      TK_inout = 153,
      TK_configuration = 154,
      TK_intermediate = 155,
      TK_property = 156,
      TK_opposites = 157,
      TK_population = 158,
      TK_map = 50,
      TK_xmap = 51,
      TK_late = 52,
      TK_resolve = 64,
      TK_resolveone = 65,
      TK_resolveIn = 66,
      TK_resolveoneIn = 67,
      TK_invresolve = 68,
      TK_invresolveone = 69,
      TK_invresolveIn = 70,
      TK_invresolveoneIn = 71,
      TK_modeltype = 159,
      TK_uses = 160,
      TK_where = 161,
      TK_refines = 162,
      TK_access = 163,
      TK_extends = 164,
      TK_blackbox = 165,
      TK_abstract = 166,
      TK_static = 167,
      TK_result = 35,
      TK_main = 116,
      TK_this = 36,
      TK_rename = 168,
      TK_inherits = 169,
      TK_merges = 170,
      TK_disjuncts = 171,
      TK_IDENTIFIER = 2,
      TK_init = 172,
      TK_ERROR_TOKEN = 4,
      TK_EOF_TOKEN = 117;

      public final static String orderedTerminalSymbols[] = {
                 "", //$NON-NLS-1$
                 "LPAREN", //$NON-NLS-1$
                 "IDENTIFIER", //$NON-NLS-1$
                 "RPAREN", //$NON-NLS-1$
                 "ERROR_TOKEN", //$NON-NLS-1$
                 "false", //$NON-NLS-1$
                 "null", //$NON-NLS-1$
                 "true", //$NON-NLS-1$
                 "Set", //$NON-NLS-1$
                 "Bag", //$NON-NLS-1$
                 "Sequence", //$NON-NLS-1$
                 "Collection", //$NON-NLS-1$
                 "OrderedSet", //$NON-NLS-1$
                 "String", //$NON-NLS-1$
                 "Integer", //$NON-NLS-1$
                 "UnlimitedNatural", //$NON-NLS-1$
                 "Real", //$NON-NLS-1$
                 "Boolean", //$NON-NLS-1$
                 "OclAny", //$NON-NLS-1$
                 "OclVoid", //$NON-NLS-1$
                 "OclInvalid", //$NON-NLS-1$
                 "invalid", //$NON-NLS-1$
                 "self", //$NON-NLS-1$
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
                 "result", //$NON-NLS-1$
                 "this", //$NON-NLS-1$
                 "MINUS", //$NON-NLS-1$
                 "MULTIPLY", //$NON-NLS-1$
                 "Tuple", //$NON-NLS-1$
                 "List", //$NON-NLS-1$
                 "Dict", //$NON-NLS-1$
                 "STRING_LITERAL", //$NON-NLS-1$
                 "not", //$NON-NLS-1$
                 "INTEGER_LITERAL", //$NON-NLS-1$
                 "REAL_LITERAL", //$NON-NLS-1$
                 "ARROW", //$NON-NLS-1$
                 "DOT", //$NON-NLS-1$
                 "if", //$NON-NLS-1$
                 "let", //$NON-NLS-1$
                 "map", //$NON-NLS-1$
                 "xmap", //$NON-NLS-1$
                 "late", //$NON-NLS-1$
                 "switch", //$NON-NLS-1$
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
                 "resolve", //$NON-NLS-1$
                 "resolveone", //$NON-NLS-1$
                 "resolveIn", //$NON-NLS-1$
                 "resolveoneIn", //$NON-NLS-1$
                 "invresolve", //$NON-NLS-1$
                 "invresolveone", //$NON-NLS-1$
                 "invresolveIn", //$NON-NLS-1$
                 "invresolveoneIn", //$NON-NLS-1$
                 "COMMA", //$NON-NLS-1$
                 "COLONCOLON", //$NON-NLS-1$
                 "COLON", //$NON-NLS-1$
                 "BAR", //$NON-NLS-1$
                 "EQUAL", //$NON-NLS-1$
                 "LBRACE", //$NON-NLS-1$
                 "RBRACE", //$NON-NLS-1$
                 "SEMICOLON", //$NON-NLS-1$
                 "PLUS", //$NON-NLS-1$
                 "RESET_ASSIGN", //$NON-NLS-1$
                 "GREATER", //$NON-NLS-1$
                 "LESS", //$NON-NLS-1$
                 "GREATER_EQUAL", //$NON-NLS-1$
                 "LESS_EQUAL", //$NON-NLS-1$
                 "and", //$NON-NLS-1$
                 "or", //$NON-NLS-1$
                 "xor", //$NON-NLS-1$
                 "DIVIDE", //$NON-NLS-1$
                 "else", //$NON-NLS-1$
                 "endif", //$NON-NLS-1$
                 "implies", //$NON-NLS-1$
                 "in", //$NON-NLS-1$
                 "NOT_EQUAL", //$NON-NLS-1$
                 "LBRACKET", //$NON-NLS-1$
                 "then", //$NON-NLS-1$
                 "AT", //$NON-NLS-1$
                 "EXCLAMATION_MARK", //$NON-NLS-1$
                 "NOT_EQUAL_EXEQ", //$NON-NLS-1$
                 "COLONCOLONEQUAL", //$NON-NLS-1$
                 "QUESTIONMARK", //$NON-NLS-1$
                 "case", //$NON-NLS-1$
                 "RBRACKET", //$NON-NLS-1$
                 "DOTDOT", //$NON-NLS-1$
                 "ADD_ASSIGN", //$NON-NLS-1$
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
                 "STEREOTYPE_QUALIFIER_OPEN", //$NON-NLS-1$
                 "STEREOTYPE_QUALIFIER_CLOSE", //$NON-NLS-1$
                 "MULTIPLICITY_RANGE", //$NON-NLS-1$
                 "TILDE_SIGN", //$NON-NLS-1$
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
                 "disjuncts", //$NON-NLS-1$
                 "init" //$NON-NLS-1$
             };

    public final static boolean isValidForParser = true;
}
