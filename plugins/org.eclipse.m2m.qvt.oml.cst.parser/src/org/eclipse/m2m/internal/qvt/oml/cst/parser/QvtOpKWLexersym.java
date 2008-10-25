/**
* <copyright>
*
* Copyright (c) 2005, 2007 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
*
* </copyright>
*
* $Id: QvtOpKWLexersym.java,v 1.14 2008/10/25 10:07:05 aigdalov Exp $
*/
/**
* <copyright>
*
* Copyright (c) 2006-2008 Borland Inc.
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
* $Id: QvtOpKWLexersym.java,v 1.14 2008/10/25 10:07:05 aigdalov Exp $
*/

package org.eclipse.m2m.internal.qvt.oml.cst.parser;

public interface QvtOpKWLexersym {
    public final static int
      Char_DollarSign = 41,
      Char_a = 8,
      Char_b = 22,
      Char_c = 10,
      Char_d = 11,
      Char_e = 1,
      Char_f = 14,
      Char_g = 15,
      Char_h = 19,
      Char_i = 6,
      Char_j = 24,
      Char_k = 33,
      Char_l = 4,
      Char_m = 16,
      Char_n = 3,
      Char_o = 9,
      Char_p = 13,
      Char_q = 25,
      Char_r = 7,
      Char_s = 5,
      Char_t = 2,
      Char_u = 12,
      Char_v = 20,
      Char_w = 23,
      Char_x = 26,
      Char_y = 17,
      Char_z = 42,
      Char_A = 27,
      Char_B = 32,
      Char_C = 34,
      Char_D = 43,
      Char_E = 35,
      Char_F = 44,
      Char_G = 45,
      Char_H = 46,
      Char_I = 18,
      Char_J = 47,
      Char_K = 36,
      Char_L = 48,
      Char_M = 37,
      Char_N = 28,
      Char_O = 21,
      Char_P = 49,
      Char_Q = 50,
      Char_R = 38,
      Char_S = 29,
      Char_T = 30,
      Char_U = 31,
      Char_V = 39,
      Char_W = 51,
      Char_X = 52,
      Char_Y = 53,
      Char_Z = 54,
      Char_EOF = 40;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "e",
                 "t",
                 "n",
                 "l",
                 "s",
                 "i",
                 "r",
                 "a",
                 "o",
                 "c",
                 "d",
                 "u",
                 "p",
                 "f",
                 "g",
                 "m",
                 "y",
                 "I",
                 "h",
                 "v",
                 "O",
                 "b",
                 "w",
                 "j",
                 "q",
                 "x",
                 "A",
                 "N",
                 "S",
                 "T",
                 "U",
                 "B",
                 "k",
                 "C",
                 "E",
                 "K",
                 "M",
                 "R",
                 "V",
                 "EOF",
                 "DollarSign",
                 "z",
                 "D",
                 "F",
                 "G",
                 "H",
                 "J",
                 "L",
                 "P",
                 "Q",
                 "W",
                 "X",
                 "Y",
                 "Z"
             };

    public final static boolean isValidForParser = true;
}
