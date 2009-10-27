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
* $Id: QvtOpLPGParsersym.java,v 1.79.4.1 2009/10/27 09:18:34 sboyko Exp $
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
* $Id: QvtOpLPGParsersym.java,v 1.79.4.1 2009/10/27 09:18:34 sboyko Exp $
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
* $Id: QvtOpLPGParsersym.java,v 1.79.4.1 2009/10/27 09:18:34 sboyko Exp $
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
* $Id: QvtOpLPGParsersym.java,v 1.79.4.1 2009/10/27 09:18:34 sboyko Exp $
*/

package org.eclipse.m2m.internal.qvt.oml.cst.parser;

public interface QvtOpLPGParsersym {
    public final static int
      TK_STRING_LITERAL = 38,
      TK_INTEGER_LITERAL = 47,
      TK_REAL_LITERAL = 48,
      TK_PLUS = 90,
      TK_MINUS = 42,
      TK_MULTIPLY = 41,
      TK_DIVIDE = 107,
      TK_GREATER = 94,
      TK_LESS = 95,
      TK_EQUAL = 78,
      TK_GREATER_EQUAL = 96,
      TK_LESS_EQUAL = 97,
      TK_NOT_EQUAL = 111,
      TK_LPAREN = 1,
      TK_RPAREN = 4,
      TK_LBRACE = 74,
      TK_RBRACE = 77,
      TK_LBRACKET = 108,
      TK_RBRACKET = 117,
      TK_ARROW = 49,
      TK_BAR = 79,
      TK_COMMA = 73,
      TK_COLON = 75,
      TK_COLONCOLON = 76,
      TK_SEMICOLON = 64,
      TK_DOT = 43,
      TK_DOTDOT = 118,
      TK_ADD_ASSIGN = 131,
      TK_RESET_ASSIGN = 91,
      TK_AT = 119,
      TK_EXCLAMATION_MARK = 120,
      TK_NOT_EQUAL_EXEQ = 121,
      TK_class = 132,
      TK_composes = 133,
      TK_constructor = 98,
      TK_datatype = 158,
      TK_default = 159,
      TK_derived = 134,
      TK_do = 160,
      TK_elif = 161,
      TK_enum = 162,
      TK_except = 163,
      TK_exception = 164,
      TK_from = 165,
      TK_literal = 166,
      TK_ordered = 135,
      TK_primitive = 167,
      TK_raise = 168,
      TK_readonly = 136,
      TK_references = 137,
      TK_tag = 99,
      TK_try = 169,
      TK_typedef = 170,
      TK_unlimited = 171,
      TK_invalid = 21,
      TK_COLONCOLONEQUAL = 122,
      TK_QUESTIONMARK = 123,
      TK_STEREOTYPE_QUALIFIER_OPEN = 124,
      TK_STEREOTYPE_QUALIFIER_CLOSE = 138,
      TK_MULTIPLICITY_RANGE = 139,
      TK_TILDE_SIGN = 140,
      TK_self = 22,
      TK_if = 45,
      TK_then = 92,
      TK_else = 85,
      TK_endif = 86,
      TK_and = 81,
      TK_or = 82,
      TK_xor = 83,
      TK_not = 44,
      TK_implies = 87,
      TK_let = 46,
      TK_in = 80,
      TK_true = 18,
      TK_false = 19,
      TK_null = 20,
      TK_Set = 5,
      TK_Bag = 6,
      TK_Sequence = 7,
      TK_Collection = 8,
      TK_OrderedSet = 9,
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
      TK_String = 10,
      TK_Integer = 11,
      TK_UnlimitedNatural = 12,
      TK_Real = 13,
      TK_Boolean = 14,
      TK_Tuple = 37,
      TK_OclAny = 15,
      TK_OclVoid = 16,
      TK_OclInvalid = 17,
      TK_inv = 172,
      TK_pre = 173,
      TK_post = 174,
      TK_context = 175,
      TK_package = 176,
      TK_endpackage = 177,
      TK_def = 178,
      TK_body = 179,
      TK_derive = 180,
      TK_init = 141,
      TK_static = 93,
      TK_OclMessage = 181,
      TK_end = 100,
      TK_while = 53,
      TK_out = 109,
      TK_object = 54,
      TK_transformation = 112,
      TK_import = 142,
      TK_library = 113,
      TK_metamodel = 182,
      TK_mapping = 101,
      TK_query = 102,
      TK_helper = 103,
      TK_inout = 110,
      TK_when = 114,
      TK_var = 61,
      TK_configuration = 115,
      TK_intermediate = 116,
      TK_property = 104,
      TK_opposites = 143,
      TK_population = 125,
      TK_map = 50,
      TK_new = 55,
      TK_xmap = 51,
      TK_late = 52,
      TK_log = 56,
      TK_assert = 62,
      TK_with = 144,
      TK_resolve = 65,
      TK_resolveone = 66,
      TK_resolveIn = 67,
      TK_resolveoneIn = 68,
      TK_invresolve = 69,
      TK_invresolveone = 70,
      TK_invresolveIn = 71,
      TK_invresolveoneIn = 72,
      TK_modeltype = 145,
      TK_uses = 146,
      TK_where = 147,
      TK_refines = 148,
      TK_access = 88,
      TK_extends = 84,
      TK_blackbox = 105,
      TK_abstract = 106,
      TK_result = 35,
      TK_main = 89,
      TK_this = 36,
      TK_switch = 57,
      TK_case = 126,
      TK_xselect = 149,
      TK_xcollect = 150,
      TK_selectOne = 151,
      TK_collectOne = 152,
      TK_collectselect = 153,
      TK_collectselectOne = 154,
      TK_return = 63,
      TK_rename = 155,
      TK_disjuncts = 127,
      TK_merges = 128,
      TK_inherits = 129,
      TK_forEach = 156,
      TK_forOne = 157,
      TK_compute = 58,
      TK_Dict = 39,
      TK_List = 40,
      TK_break = 59,
      TK_continue = 60,
      TK_EOF_TOKEN = 130,
      TK_IDENTIFIER = 3,
      TK_SINGLE_LINE_COMMENT = 183,
      TK_MULTI_LINE_COMMENT = 184,
      TK_CARET = 185,
      TK_CARETCARET = 186,
      TK_ERROR_TOKEN = 2;

      public final static String orderedTerminalSymbols[] = {
                 "", //$NON-NLS-1$
                 "LPAREN", //$NON-NLS-1$
                 "ERROR_TOKEN", //$NON-NLS-1$
                 "IDENTIFIER", //$NON-NLS-1$
                 "RPAREN", //$NON-NLS-1$
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
                 "true", //$NON-NLS-1$
                 "false", //$NON-NLS-1$
                 "null", //$NON-NLS-1$
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
                 "Tuple", //$NON-NLS-1$
                 "STRING_LITERAL", //$NON-NLS-1$
                 "Dict", //$NON-NLS-1$
                 "List", //$NON-NLS-1$
                 "MULTIPLY", //$NON-NLS-1$
                 "MINUS", //$NON-NLS-1$
                 "DOT", //$NON-NLS-1$
                 "not", //$NON-NLS-1$
                 "if", //$NON-NLS-1$
                 "let", //$NON-NLS-1$
                 "INTEGER_LITERAL", //$NON-NLS-1$
                 "REAL_LITERAL", //$NON-NLS-1$
                 "ARROW", //$NON-NLS-1$
                 "map", //$NON-NLS-1$
                 "xmap", //$NON-NLS-1$
                 "late", //$NON-NLS-1$
                 "while", //$NON-NLS-1$
                 "object", //$NON-NLS-1$
                 "new", //$NON-NLS-1$
                 "log", //$NON-NLS-1$
                 "switch", //$NON-NLS-1$
                 "compute", //$NON-NLS-1$
                 "break", //$NON-NLS-1$
                 "continue", //$NON-NLS-1$
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
                 "COLON", //$NON-NLS-1$
                 "COLONCOLON", //$NON-NLS-1$
                 "RBRACE", //$NON-NLS-1$
                 "EQUAL", //$NON-NLS-1$
                 "BAR", //$NON-NLS-1$
                 "in", //$NON-NLS-1$
                 "and", //$NON-NLS-1$
                 "or", //$NON-NLS-1$
                 "xor", //$NON-NLS-1$
                 "extends", //$NON-NLS-1$
                 "else", //$NON-NLS-1$
                 "endif", //$NON-NLS-1$
                 "implies", //$NON-NLS-1$
                 "access", //$NON-NLS-1$
                 "main", //$NON-NLS-1$
                 "PLUS", //$NON-NLS-1$
                 "RESET_ASSIGN", //$NON-NLS-1$
                 "then", //$NON-NLS-1$
                 "static", //$NON-NLS-1$
                 "GREATER", //$NON-NLS-1$
                 "LESS", //$NON-NLS-1$
                 "GREATER_EQUAL", //$NON-NLS-1$
                 "LESS_EQUAL", //$NON-NLS-1$
                 "constructor", //$NON-NLS-1$
                 "tag", //$NON-NLS-1$
                 "end", //$NON-NLS-1$
                 "mapping", //$NON-NLS-1$
                 "query", //$NON-NLS-1$
                 "helper", //$NON-NLS-1$
                 "property", //$NON-NLS-1$
                 "blackbox", //$NON-NLS-1$
                 "abstract", //$NON-NLS-1$
                 "DIVIDE", //$NON-NLS-1$
                 "LBRACKET", //$NON-NLS-1$
                 "out", //$NON-NLS-1$
                 "inout", //$NON-NLS-1$
                 "NOT_EQUAL", //$NON-NLS-1$
                 "transformation", //$NON-NLS-1$
                 "library", //$NON-NLS-1$
                 "when", //$NON-NLS-1$
                 "configuration", //$NON-NLS-1$
                 "intermediate", //$NON-NLS-1$
                 "RBRACKET", //$NON-NLS-1$
                 "DOTDOT", //$NON-NLS-1$
                 "AT", //$NON-NLS-1$
                 "EXCLAMATION_MARK", //$NON-NLS-1$
                 "NOT_EQUAL_EXEQ", //$NON-NLS-1$
                 "COLONCOLONEQUAL", //$NON-NLS-1$
                 "QUESTIONMARK", //$NON-NLS-1$
                 "STEREOTYPE_QUALIFIER_OPEN", //$NON-NLS-1$
                 "population", //$NON-NLS-1$
                 "case", //$NON-NLS-1$
                 "disjuncts", //$NON-NLS-1$
                 "merges", //$NON-NLS-1$
                 "inherits", //$NON-NLS-1$
                 "EOF_TOKEN", //$NON-NLS-1$
                 "ADD_ASSIGN", //$NON-NLS-1$
                 "class", //$NON-NLS-1$
                 "composes", //$NON-NLS-1$
                 "derived", //$NON-NLS-1$
                 "ordered", //$NON-NLS-1$
                 "readonly", //$NON-NLS-1$
                 "references", //$NON-NLS-1$
                 "STEREOTYPE_QUALIFIER_CLOSE", //$NON-NLS-1$
                 "MULTIPLICITY_RANGE", //$NON-NLS-1$
                 "TILDE_SIGN", //$NON-NLS-1$
                 "init", //$NON-NLS-1$
                 "import", //$NON-NLS-1$
                 "opposites", //$NON-NLS-1$
                 "with", //$NON-NLS-1$
                 "modeltype", //$NON-NLS-1$
                 "uses", //$NON-NLS-1$
                 "where", //$NON-NLS-1$
                 "refines", //$NON-NLS-1$
                 "xselect", //$NON-NLS-1$
                 "xcollect", //$NON-NLS-1$
                 "selectOne", //$NON-NLS-1$
                 "collectOne", //$NON-NLS-1$
                 "collectselect", //$NON-NLS-1$
                 "collectselectOne", //$NON-NLS-1$
                 "rename", //$NON-NLS-1$
                 "forEach", //$NON-NLS-1$
                 "forOne", //$NON-NLS-1$
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
                 "inv", //$NON-NLS-1$
                 "pre", //$NON-NLS-1$
                 "post", //$NON-NLS-1$
                 "context", //$NON-NLS-1$
                 "package", //$NON-NLS-1$
                 "endpackage", //$NON-NLS-1$
                 "def", //$NON-NLS-1$
                 "body", //$NON-NLS-1$
                 "derive", //$NON-NLS-1$
                 "OclMessage", //$NON-NLS-1$
                 "metamodel", //$NON-NLS-1$
                 "SINGLE_LINE_COMMENT", //$NON-NLS-1$
                 "MULTI_LINE_COMMENT", //$NON-NLS-1$
                 "CARET", //$NON-NLS-1$
                 "CARETCARET" //$NON-NLS-1$
             };

    public final static boolean isValidForParser = true;
}
