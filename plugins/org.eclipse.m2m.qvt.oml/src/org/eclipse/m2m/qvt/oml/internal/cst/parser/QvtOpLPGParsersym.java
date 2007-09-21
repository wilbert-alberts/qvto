/**
* <copyright>
*
* Copyright (c) 2007 Borland Software Corporation
* 
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     Borland Software Corporation - initial API and implementation
*
* </copyright>
*
* $Id: QvtOpLPGParsersym.java,v 1.19 2007/09/21 13:19:08 aigdalov Exp $
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
* $Id: QvtOpLPGParsersym.java,v 1.19 2007/09/21 13:19:08 aigdalov Exp $
*/

package org.eclipse.m2m.qvt.oml.internal.cst.parser;

public interface QvtOpLPGParsersym {
    public final static int
      TK_NUMERIC_OPERATION = 66,
      TK_STRING_LITERAL = 44,
      TK_INTEGER_LITERAL = 67,
      TK_REAL_LITERAL = 68,
      TK_PLUS = 48,
      TK_MINUS = 49,
      TK_MULTIPLY = 23,
      TK_DIVIDE = 24,
      TK_GREATER = 25,
      TK_LESS = 26,
      TK_EQUAL = 5,
      TK_GREATER_EQUAL = 27,
      TK_LESS_EQUAL = 28,
      TK_NOT_EQUAL = 20,
      TK_LPAREN = 1,
      TK_RPAREN = 4,
      TK_LBRACE = 82,
      TK_RBRACE = 80,
      TK_LBRACKET = 114,
      TK_RBRACKET = 104,
      TK_ARROW = 124,
      TK_BAR = 93,
      TK_COMMA = 83,
      TK_COLON = 85,
      TK_COLONCOLON = 84,
      TK_SEMICOLON = 81,
      TK_DOT = 94,
      TK_DOTDOT = 125,
      TK_ATPRE = 96,
      TK_CARET = 126,
      TK_CARETCARET = 127,
      TK_QUESTIONMARK = 105,
      TK_QUOTE_STRING_LITERAL = 128,
      TK_ADD_ASSIGN = 115,
      TK_RESET_ASSIGN = 100,
      TK_AT_SIGN = 131,
      TK_self = 50,
      TK_inv = 136,
      TK_pre = 137,
      TK_post = 138,
      TK_context = 139,
      TK_package = 140,
      TK_endpackage = 141,
      TK_def = 142,
      TK_if = 69,
      TK_then = 129,
      TK_else = 116,
      TK_endif = 117,
      TK_and = 45,
      TK_or = 46,
      TK_xor = 47,
      TK_not = 54,
      TK_implies = 130,
      TK_let = 75,
      TK_in = 87,
      TK_true = 70,
      TK_false = 71,
      TK_body = 29,
      TK_derive = 30,
      TK_init = 21,
      TK_null = 53,
      TK_attr = 143,
      TK_oper = 144,
      TK_Set = 6,
      TK_Bag = 7,
      TK_Sequence = 8,
      TK_Collection = 9,
      TK_OrderedSet = 10,
      TK_iterate = 31,
      TK_forAll = 32,
      TK_exists = 33,
      TK_isUnique = 34,
      TK_any = 35,
      TK_one = 36,
      TK_collect = 37,
      TK_select = 38,
      TK_reject = 39,
      TK_collectNested = 40,
      TK_sortedBy = 41,
      TK_closure = 42,
      TK_oclIsKindOf = 55,
      TK_oclIsTypeOf = 56,
      TK_oclAsType = 57,
      TK_oclIsNew = 58,
      TK_oclIsUndefined = 59,
      TK_oclIsInvalid = 60,
      TK_oclIsInState = 61,
      TK_allInstances = 43,
      TK_String = 11,
      TK_Integer = 12,
      TK_UnlimitedNatural = 13,
      TK_Real = 14,
      TK_Boolean = 15,
      TK_Tuple = 22,
      TK_OclAny = 16,
      TK_OclVoid = 17,
      TK_Invalid = 18,
      TK_OclMessage = 19,
      TK_OclInvalid = 72,
      TK_end = 106,
      TK_while = 73,
      TK_out = 97,
      TK_object = 64,
      TK_transformation = 107,
      TK_import = 108,
      TK_library = 101,
      TK_metamodel = 102,
      TK_mapping = 89,
      TK_query = 90,
      TK_inout = 98,
      TK_when = 132,
      TK_var = 91,
      TK_configuration = 95,
      TK_property = 92,
      TK_map = 62,
      TK_xmap = 63,
      TK_late = 65,
      TK_resolve = 118,
      TK_resolveone = 119,
      TK_resolveIn = 76,
      TK_resolveoneIn = 77,
      TK_invresolve = 120,
      TK_invresolveone = 121,
      TK_invresolveIn = 78,
      TK_invresolveoneIn = 79,
      TK_modeltype = 103,
      TK_uses = 133,
      TK_where = 134,
      TK_refines = 122,
      TK_enforcing = 135,
      TK_access = 109,
      TK_extends = 110,
      TK_blackbox = 111,
      TK_abstract = 112,
      TK_static = 113,
      TK_result = 51,
      TK_main = 86,
      TK_this = 52,
      TK_switch = 74,
      TK_rename = 99,
      TK_EOF_TOKEN = 88,
      TK_IDENTIFIER = 3,
      TK_INTEGER_RANGE_START = 123,
      TK_ERROR_TOKEN = 2;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "LPAREN",
                 "ERROR_TOKEN",
                 "IDENTIFIER",
                 "RPAREN",
                 "EQUAL",
                 "Set",
                 "Bag",
                 "Sequence",
                 "Collection",
                 "OrderedSet",
                 "String",
                 "Integer",
                 "UnlimitedNatural",
                 "Real",
                 "Boolean",
                 "OclAny",
                 "OclVoid",
                 "Invalid",
                 "OclMessage",
                 "NOT_EQUAL",
                 "init",
                 "Tuple",
                 "MULTIPLY",
                 "DIVIDE",
                 "GREATER",
                 "LESS",
                 "GREATER_EQUAL",
                 "LESS_EQUAL",
                 "body",
                 "derive",
                 "iterate",
                 "forAll",
                 "exists",
                 "isUnique",
                 "any",
                 "one",
                 "collect",
                 "select",
                 "reject",
                 "collectNested",
                 "sortedBy",
                 "closure",
                 "allInstances",
                 "STRING_LITERAL",
                 "and",
                 "or",
                 "xor",
                 "PLUS",
                 "MINUS",
                 "self",
                 "result",
                 "this",
                 "null",
                 "not",
                 "oclIsKindOf",
                 "oclIsTypeOf",
                 "oclAsType",
                 "oclIsNew",
                 "oclIsUndefined",
                 "oclIsInvalid",
                 "oclIsInState",
                 "map",
                 "xmap",
                 "object",
                 "late",
                 "NUMERIC_OPERATION",
                 "INTEGER_LITERAL",
                 "REAL_LITERAL",
                 "if",
                 "true",
                 "false",
                 "OclInvalid",
                 "while",
                 "switch",
                 "let",
                 "resolveIn",
                 "resolveoneIn",
                 "invresolveIn",
                 "invresolveoneIn",
                 "RBRACE",
                 "SEMICOLON",
                 "LBRACE",
                 "COMMA",
                 "COLONCOLON",
                 "COLON",
                 "main",
                 "in",
                 "EOF_TOKEN",
                 "mapping",
                 "query",
                 "var",
                 "property",
                 "BAR",
                 "DOT",
                 "configuration",
                 "ATPRE",
                 "out",
                 "inout",
                 "rename",
                 "RESET_ASSIGN",
                 "library",
                 "metamodel",
                 "modeltype",
                 "RBRACKET",
                 "QUESTIONMARK",
                 "end",
                 "transformation",
                 "import",
                 "access",
                 "extends",
                 "blackbox",
                 "abstract",
                 "static",
                 "LBRACKET",
                 "ADD_ASSIGN",
                 "else",
                 "endif",
                 "resolve",
                 "resolveone",
                 "invresolve",
                 "invresolveone",
                 "refines",
                 "INTEGER_RANGE_START",
                 "ARROW",
                 "DOTDOT",
                 "CARET",
                 "CARETCARET",
                 "QUOTE_STRING_LITERAL",
                 "then",
                 "implies",
                 "AT_SIGN",
                 "when",
                 "uses",
                 "where",
                 "enforcing",
                 "inv",
                 "pre",
                 "post",
                 "context",
                 "package",
                 "endpackage",
                 "def",
                 "attr",
                 "oper"
             };

    public final static boolean isValidForParser = true;
}
