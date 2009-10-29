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
* $Id: QvtOpKWLexersym.java,v 1.79.4.4 2009/10/29 21:38:32 sboyko Exp $
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
* $Id: QvtOpKWLexersym.java,v 1.79.4.4 2009/10/29 21:38:32 sboyko Exp $
*/

package org.eclipse.m2m.internal.qvt.oml.cst.parser;

public interface QvtOpKWLexersym {
    public final static int
      Char_DollarSign = 42,
      Char_a = 8,
      Char_b = 21,
      Char_c = 10,
      Char_d = 11,
      Char_e = 1,
      Char_f = 16,
      Char_g = 17,
      Char_h = 18,
      Char_i = 4,
      Char_j = 23,
      Char_k = 27,
      Char_l = 6,
      Char_m = 14,
      Char_n = 3,
      Char_o = 9,
      Char_p = 13,
      Char_q = 24,
      Char_r = 7,
      Char_s = 5,
      Char_t = 2,
      Char_u = 12,
      Char_v = 19,
      Char_w = 25,
      Char_x = 26,
      Char_y = 15,
      Char_z = 43,
      Char_A = 28,
      Char_B = 29,
      Char_C = 33,
      Char_D = 34,
      Char_E = 35,
      Char_F = 44,
      Char_G = 45,
      Char_H = 46,
      Char_I = 20,
      Char_J = 47,
      Char_K = 48,
      Char_L = 36,
      Char_M = 37,
      Char_N = 30,
      Char_O = 22,
      Char_P = 49,
      Char_Q = 50,
      Char_R = 38,
      Char_S = 31,
      Char_T = 39,
      Char_U = 32,
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
                 "s", //$NON-NLS-1$
                 "l", //$NON-NLS-1$
                 "r", //$NON-NLS-1$
                 "a", //$NON-NLS-1$
                 "o", //$NON-NLS-1$
                 "c", //$NON-NLS-1$
                 "d", //$NON-NLS-1$
                 "u", //$NON-NLS-1$
                 "p", //$NON-NLS-1$
                 "m", //$NON-NLS-1$
                 "y", //$NON-NLS-1$
                 "f", //$NON-NLS-1$
                 "g", //$NON-NLS-1$
                 "h", //$NON-NLS-1$
                 "v", //$NON-NLS-1$
                 "I", //$NON-NLS-1$
                 "b", //$NON-NLS-1$
                 "O", //$NON-NLS-1$
                 "j", //$NON-NLS-1$
                 "q", //$NON-NLS-1$
                 "w", //$NON-NLS-1$
                 "x", //$NON-NLS-1$
                 "k", //$NON-NLS-1$
                 "A", //$NON-NLS-1$
                 "B", //$NON-NLS-1$
                 "N", //$NON-NLS-1$
                 "S", //$NON-NLS-1$
                 "U", //$NON-NLS-1$
                 "C", //$NON-NLS-1$
                 "D", //$NON-NLS-1$
                 "E", //$NON-NLS-1$
                 "L", //$NON-NLS-1$
                 "M", //$NON-NLS-1$
                 "R", //$NON-NLS-1$
                 "T", //$NON-NLS-1$
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
