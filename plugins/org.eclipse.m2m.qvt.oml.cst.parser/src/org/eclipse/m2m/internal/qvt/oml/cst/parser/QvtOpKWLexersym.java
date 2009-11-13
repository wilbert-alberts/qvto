/**
* Essential OCL Keyword Lexer
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
*   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
*   E.D.Willink - Bug 285633, 292112
* </copyright>
*
* $Id: QvtOpKWLexersym.java,v 1.80 2009/11/13 13:51:07 radvorak Exp $
*/
/**
* Complete OCL Keyword Lexer
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
*   E.D.Willink - Bug 292112
* </copyright>
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
* $Id: QvtOpKWLexersym.java,v 1.80 2009/11/13 13:51:07 radvorak Exp $
*/

package org.eclipse.m2m.internal.qvt.oml.cst.parser;

public interface QvtOpKWLexersym {
    public final static int
      Char_DollarSign = 42,
      Char_a = 6,
      Char_b = 21,
      Char_c = 10,
      Char_d = 11,
      Char_e = 1,
      Char_f = 15,
      Char_g = 16,
      Char_h = 18,
      Char_i = 4,
      Char_j = 25,
      Char_k = 26,
      Char_l = 5,
      Char_m = 14,
      Char_n = 3,
      Char_o = 9,
      Char_p = 13,
      Char_q = 27,
      Char_r = 7,
      Char_s = 8,
      Char_t = 2,
      Char_u = 12,
      Char_v = 19,
      Char_w = 23,
      Char_x = 24,
      Char_y = 17,
      Char_z = 43,
      Char_A = 29,
      Char_B = 30,
      Char_C = 31,
      Char_D = 32,
      Char_E = 33,
      Char_F = 44,
      Char_G = 45,
      Char_H = 46,
      Char_I = 20,
      Char_J = 47,
      Char_K = 48,
      Char_L = 34,
      Char_M = 35,
      Char_N = 36,
      Char_O = 22,
      Char_P = 49,
      Char_Q = 50,
      Char_R = 37,
      Char_S = 28,
      Char_T = 38,
      Char_U = 39,
      Char_V = 40,
      Char_W = 51,
      Char_X = 52,
      Char_Y = 53,
      Char_Z = 54,
      Char_EOF = 41;

      public final static String orderedTerminalSymbols[] = {
                 "", //$NON-NLS-1$
                 "e", //$NON-NLS-1$
                 "t", //$NON-NLS-1$
                 "n", //$NON-NLS-1$
                 "i", //$NON-NLS-1$
                 "l", //$NON-NLS-1$
                 "a", //$NON-NLS-1$
                 "r", //$NON-NLS-1$
                 "s", //$NON-NLS-1$
                 "o", //$NON-NLS-1$
                 "c", //$NON-NLS-1$
                 "d", //$NON-NLS-1$
                 "u", //$NON-NLS-1$
                 "p", //$NON-NLS-1$
                 "m", //$NON-NLS-1$
                 "f", //$NON-NLS-1$
                 "g", //$NON-NLS-1$
                 "y", //$NON-NLS-1$
                 "h", //$NON-NLS-1$
                 "v", //$NON-NLS-1$
                 "I", //$NON-NLS-1$
                 "b", //$NON-NLS-1$
                 "O", //$NON-NLS-1$
                 "w", //$NON-NLS-1$
                 "x", //$NON-NLS-1$
                 "j", //$NON-NLS-1$
                 "k", //$NON-NLS-1$
                 "q", //$NON-NLS-1$
                 "S", //$NON-NLS-1$
                 "A", //$NON-NLS-1$
                 "B", //$NON-NLS-1$
                 "C", //$NON-NLS-1$
                 "D", //$NON-NLS-1$
                 "E", //$NON-NLS-1$
                 "L", //$NON-NLS-1$
                 "M", //$NON-NLS-1$
                 "N", //$NON-NLS-1$
                 "R", //$NON-NLS-1$
                 "T", //$NON-NLS-1$
                 "U", //$NON-NLS-1$
                 "V", //$NON-NLS-1$
                 "EOF", //$NON-NLS-1$
                 "DollarSign", //$NON-NLS-1$
                 "z", //$NON-NLS-1$
                 "F", //$NON-NLS-1$
                 "G", //$NON-NLS-1$
                 "H", //$NON-NLS-1$
                 "J", //$NON-NLS-1$
                 "K", //$NON-NLS-1$
                 "P", //$NON-NLS-1$
                 "Q", //$NON-NLS-1$
                 "W", //$NON-NLS-1$
                 "X", //$NON-NLS-1$
                 "Y", //$NON-NLS-1$
                 "Z" //$NON-NLS-1$
             };

    public final static boolean isValidForParser = true;
}
