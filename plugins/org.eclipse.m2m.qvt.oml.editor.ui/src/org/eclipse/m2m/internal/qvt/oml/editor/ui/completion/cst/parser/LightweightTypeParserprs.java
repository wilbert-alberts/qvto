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
* $Id: LightweightTypeParserprs.java,v 1.63.4.7 2009/11/12 08:58:59 sboyko Exp $
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
* $Id: LightweightTypeParserprs.java,v 1.63.4.7 2009/11/12 08:58:59 sboyko Exp $
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
* $Id: LightweightTypeParserprs.java,v 1.63.4.7 2009/11/12 08:58:59 sboyko Exp $
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
* $Id: LightweightTypeParserprs.java,v 1.63.4.7 2009/11/12 08:58:59 sboyko Exp $
*/

package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.cst.parser;

public class LightweightTypeParserprs implements lpg.lpgjavaruntime.ParseTable, LightweightTypeParsersym {

    public interface IsKeyword {
        public final static byte isKeyword[] = {0,
            0,0,0,1,1,0,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            0,0,0,1,1,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,1,0,1,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            1,0,0,0,1,0,0,0,0,0,
            0,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,3,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,4,4,0,1,1,
            3,1,3,3,5,1,1,1,1,1,
            1,1,1,1,1,1,1,4,0,1,
            1,3,1,1,3,1,1,1,1,1,
            1,1,4,1,3,1,1,1,2,1,
            1,1,1,1,1,1,1,1,1,1,
            1,8,10,10,8,10,1,1,1,5,
            6,8,8,7,7,5,6,9,1,4,
            6,4,0,0,1,1,3,1,1,1,
            1,1,1,1,1,1,3,1,3,1,
            1,1,3,1,3,1,1,1,3,1,
            3,1,1,1,3,1,3,1,1,1,
            3,3,1,3,3,1,1,1,3,3,
            3,3,1,3,3,3,3,1,1,1,
            3,3,1,3,3,1,1,1,3,3,
            1,3,3,1,1,1,2,2,1,2,
            2,1,1,1,1,1,1,3,4,1,
            3,0,2,1,1,1,0,2,2,0,
            1,3,0,1,3,3,1,1,4,2,
            0,1,1,1,1,1,1,3,5,5,
            3,1,3,1,1,1,3,3,1,1,
            1,3,3,1,3,2,1,0,0,1,
            2,1,1,3,2,3,2,2,2,1,
            3,3,2,1,0,1,3,4,4,2,
            2,1,3,5,1,1,3,3,1,4,
            4,1,6,4,1,1,1,3,1,0,
            1,3,2,1,2,1,2,4,4,1,
            2,4,4,2,3,3,5,5,3,3,
            3,3,1,1,1,1,3,3,3,3,
            1,7,7,5,3,1,1,1,3,0,
            2,2,6,2,1,1,1,7,5,7,
            6,5,4,3,2,1,2,1,1,3,
            7,2,4,4,2,1,2,5,5,0,
            1,2,2,1,1,2,1,0,5,1,
            1,1,0,2,1,0,6,5,1,3,
            1,1,1,1,1,1,1,1,4,4,
            2,1,3,5,5,1,3,0,1,2,
            0,1,6,3,1,5,1,3,1,1,
            6,4,2,4,4,1,1,3,2,1,
            2,0,1,1,1,1,1,1,1,1,
            1,2,1,1,1,2,5,1,1,2,
            5,5,0,1,1,1,1,2,4,2,
            0,1,1,1,2,0,1,1,1,3,
            3,0,1,1,1,1,3,2,2,2,
            0,1,1,1,1,1,1,2,1,7,
            2,0,1,2,1,3,2,1,4,1,
            0,1,1,1,8,0,2,1,3,2,
            0,2,1,3,2,9,1,0,2,0,
            3,1,3,2,0,2,2,1,1,1,
            1,1,0,3,1,1,3,3,3,3,
            1,0,0,4,1,0,6,6,7,5,
            6,8,1,1,1,3,2,2,1,1,
            2,2,4,3,1,1,4,2,2,3,
            1,1,2,2,2,3,4,0,2,1,
            1,2,5,3,2,6,5,3,2,0,
            1,2,1,1,1,1,0,5,2,3,
            0,1,2,2,0,1,1,2,2,0,
            1,2,2,0,1,1,1,1,1,3,
            3,3,5,5,7,7,5,5,0,2,
            2,0,2,0,1,3,1,1,1,1,
            0,1,5,5,3,2,1,1,1,1,
            7,5,7,5,4,3,1,1,3,3,
            1,3,3,1,1,1,1,4,3,1,
            7,1,-1,0,0,0,0,0,0,0,
            0,0,-2,0,-3,-4,-5,-6,-7,0,
            -9,0,0,0,0,0,0,0,0,0,
            -10,0,0,0,0,0,0,0,0,0,
            -12,0,0,0,0,0,0,0,0,0,
            -21,0,0,0,0,0,0,0,0,0,
            -22,0,0,0,0,0,0,0,0,0,
            -13,0,0,0,-8,-11,0,-23,0,-14,
            -15,-16,0,0,0,0,-17,0,-18,-19,
            0,0,-20,-24,0
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            11,19,19,19,19,19,19,19,19,19,
            19,19,19,19,19,19,20,21,21,21,
            21,21,21,21,21,21,21,21,12,22,
            13,13,13,23,1,14,14,4,4,3,
            3,3,3,3,3,3,3,2,2,2,
            2,2,5,5,5,5,6,7,15,15,
            16,16,24,10,25,27,28,28,29,29,
            30,30,30,30,31,31,31,31,32,36,
            36,37,37,38,38,39,34,34,34,34,
            34,34,34,33,47,47,40,41,42,42,
            43,43,44,45,46,35,35,35,48,48,
            50,50,51,51,51,52,52,49,49,49,
            54,54,54,54,54,54,54,54,54,56,
            55,55,61,59,60,60,58,58,26,26,
            63,62,57,57,66,66,64,64,65,65,
            68,68,67,67,69,69,71,71,70,70,
            72,72,74,74,73,73,75,75,77,77,
            76,76,76,78,78,78,80,80,79,79,
            79,79,79,81,81,81,81,81,83,83,
            82,82,82,84,84,84,86,86,85,85,
            85,87,87,87,89,89,88,88,88,90,
            90,90,53,53,91,91,91,91,91,92,
            94,94,95,95,96,96,96,97,97,99,
            101,101,100,102,102,98,98,98,98,103,
            103,105,105,106,106,106,107,107,108,108,
            108,109,17,17,110,110,110,111,111,111,
            112,112,112,112,113,113,113,114,114,115,
            115,116,118,117,117,117,119,119,120,120,
            121,121,121,121,123,123,124,124,92,92,
            48,48,58,58,51,122,104,76,78,5,
            8,125,5,9,126,128,31,31,129,127,
            127,130,130,130,26,131,118,132,132,132,
            26,134,134,134,134,133,133,135,135,135,
            135,135,135,136,136,136,26,137,137,137,
            137,138,139,139,139,51,141,141,142,142,
            143,143,143,140,140,91,144,144,93,93,
            93,93,93,93,93,93,91,145,147,147,
            147,52,145,146,146,146,148,148,150,150,
            149,149,151,151,26,152,154,155,155,153,
            152,157,158,158,159,160,160,156,161,91,
            52,163,163,163,163,164,164,165,165,162,
            162,162,166,166,166,167,168,168,169,169,
            170,171,171,52,52,91,172,173,173,91,
            91,150,150,150,151,151,174,176,177,177,
            178,175,175,176,176,176,176,176,176,176,
            176,176,176,176,179,179,189,190,180,180,
            193,194,191,197,197,198,198,196,200,195,
            195,202,202,204,199,199,203,203,205,205,
            206,207,208,208,210,210,209,209,209,201,
            192,192,211,211,211,211,211,211,211,211,
            181,181,214,214,215,213,213,213,216,216,
            216,212,212,217,182,218,219,219,221,221,
            221,220,220,222,222,222,223,223,229,229,
            224,224,230,230,230,225,225,225,231,231,
            231,231,231,226,226,232,232,232,232,232,
            232,227,227,228,228,233,233,183,183,183,
            183,183,183,184,184,184,237,237,238,239,
            239,234,234,235,236,185,185,242,240,240,
            241,186,186,245,245,243,244,188,246,246,
            187,187,247,248,248,249,251,251,251,253,
            253,254,255,256,256,256,252,252,257,257,
            250,258,258,261,261,259,259,262,262,262,
            260,260,263,263,264,264,265,266,266,266,
            265,267,267,268,268,268,268,269,269,270,
            270,270,271,271,272,272,273,274,274,274,
            274,275,275,276,276,276,276,277,277,277,
            277,278,278,278,278,278,278,279,279,54,
            54,91,54,54,91,91,1,1,177,191,
            176,280,11,1,37,698,52,699,755,54,
            55,299,302,3,693,52,53,56,57,60,
            682,1,37,698,52,699,761,54,55,299,
            302,1,37,698,52,699,762,54,55,299,
            302,1,37,698,52,699,773,54,55,299,
            302,1,37,698,52,699,774,54,55,299,
            302,1,37,698,52,699,63,54,55,299,
            302,23,35,30,31,61,44,769,46,769,
            62,64,4,32,36,38,60,65,61,66,
            67,767,770,69,71,777,0
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static char termCheck[] = {0,
            0,1,0,0,4,5,3,7,8,9,
            10,11,12,13,14,15,16,17,18,19,
            20,0,0,1,24,25,4,5,26,7,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,0,1,0,1,4,5,4,
            5,0,0,2,2,0,0,2,2,0,
            0,0,1,0,0,0,0,3,0,6,
            0,3,6,3,0,0,0,0,0,0,
            0,22,0,23,0,0,21,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0
        };
    };
    public final static char termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            777,811,777,777,1454,1453,1077,825,827,828,
            826,824,697,816,817,818,819,820,821,822,
            823,777,777,811,696,695,1454,1453,776,825,
            827,828,826,824,805,816,817,818,819,820,
            821,822,823,58,811,777,811,1454,1453,1454,
            1453,777,777,701,711,777,777,756,721,53,
            252,777,1030,777,777,777,59,834,777,731,
            777,833,758,1080,777,777,777,777,777,777,
            777,751,777,760,777,777,741
        };
    };
    public final static char termAction[] = TermAction.termAction;
    public final int termAction(int index) { return termAction[index]; }

    public interface Asb {
        public final static byte asb[] = {0,
            1,30,21,21,21,21,23,29,1,1,
            32,1,3,19,37,27,27,39,26,27,
            1,1,17,27
        };
    };
    public final static byte asb[] = Asb.asb;
    public final int asb(int index) { return asb[index]; }

    public interface Asr {
        public final static char asr[] = {0,
            24,25,12,13,14,15,16,17,18,19,
            20,11,7,10,8,9,5,4,1,0,
            2,0,23,26,22,6,3,0,23,26,
            0,3,1,5,4,0,6,0,21,0
        };
    };
    public final static char asr[] = Asr.asr;
    public final int asr(int index) { return asr[index]; }

    public interface Nasb {
        public final static byte nasb[] = {0,
            1,11,11,11,11,11,11,11,1,1,
            6,1,4,11,11,11,11,11,11,11,
            1,1,9,11
        };
    };
    public final static byte nasb[] = Nasb.nasb;
    public final int nasb(int index) { return nasb[index]; }

    public interface Nasr {
        public final static char nasr[] = {0,
            4,2,0,14,0,16,1,0,1,10,
            0
        };
    };
    public final static char nasr[] = Nasr.nasr;
    public final int nasr(int index) { return nasr[index]; }

    public interface TerminalIndex {
        public final static char terminalIndex[] = {0,
            158,11,12,151,153,19,78,79,80,81,
            82,83,84,85,86,87,88,89,90,91,
            20,21,27,112,113,161,33,34,35,1,
            2,3,4,5,6,7,8,9,10,13,
            14,15,16,17,18,22,23,24,25,26,
            28,29,36,37,38,39,40,41,42,43,
            44,45,46,47,48,49,50,51,52,53,
            54,55,56,57,58,30,31,59,60,61,
            62,63,64,65,66,67,68,69,70,71,
            72,73,74,75,76,77,92,93,94,95,
            96,97,98,99,100,101,102,103,104,105,
            106,107,108,109,110,111,114,115,116,117,
            118,119,120,121,122,123,124,125,126,127,
            128,129,130,131,132,133,134,135,136,137,
            138,139,140,141,142,143,144,145,146,147,
            148,149,150,152,154,155,156,157,159,160
        };
    };
    public final static char terminalIndex[] = TerminalIndex.terminalIndex;
    public final int terminalIndex(int index) { return terminalIndex[index]; }

    public interface NonterminalIndex {
        public final static char nonterminalIndex[] = {0,
            164,163,0,166,167,0,0,0,0,169,
            162,0,0,165,0,168,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0
        };
    };
    public final static char nonterminalIndex[] = NonterminalIndex.nonterminalIndex;
    public final int nonterminalIndex(int index) { return nonterminalIndex[index]; }

    public interface ScopePrefix {
        public final static byte scopePrefix[] = {
            1,17,21,25,9
        };
    };
    public final static byte scopePrefix[] = ScopePrefix.scopePrefix;
    public final int scopePrefix(int index) { return scopePrefix[index]; }

    public interface ScopeSuffix {
        public final static byte scopeSuffix[] = {
            7,7,7,7,13
        };
    };
    public final static byte scopeSuffix[] = ScopeSuffix.scopeSuffix;
    public final int scopeSuffix(int index) { return scopeSuffix[index]; }

    public interface ScopeLhs {
        public final static char scopeLhs[] = {
            9,8,7,6,9
        };
    };
    public final static char scopeLhs[] = ScopeLhs.scopeLhs;
    public final int scopeLhs(int index) { return scopeLhs[index]; }

    public interface ScopeLa {
        public final static char scopeLa[] = {
            3,3,3,3,6
        };
    };
    public final static char scopeLa[] = ScopeLa.scopeLa;
    public final int scopeLa(int index) { return scopeLa[index]; }

    public interface ScopeStateSet {
        public final static byte scopeStateSet[] = {
            1,1,1,1,1
        };
    };
    public final static byte scopeStateSet[] = ScopeStateSet.scopeStateSet;
    public final int scopeStateSet(int index) { return scopeStateSet[index]; }

    public interface ScopeRhs {
        public final static char scopeRhs[] = {0,
            165,6,165,2,25,0,12,0,165,2,
            25,0,19,167,12,0,165,2,24,0,
            175,2,12,0,165,2,162,0
        };
    };
    public final static char scopeRhs[] = ScopeRhs.scopeRhs;
    public final int scopeRhs(int index) { return scopeRhs[index]; }

    public interface ScopeState {
        public final static char scopeState[] = {0,
            741,731,721,711,701,683,0
        };
    };
    public final static char scopeState[] = ScopeState.scopeState;
    public final int scopeState(int index) { return scopeState[index]; }

    public interface InSymb {
        public final static char inSymb[] = {0,
            0,171,25,24,12,162,164,165,2,2,
            2,2,22,23,165,165,175,161,176,165,
            6,21,6,165
        };
    };
    public final static char inSymb[] = InSymb.inSymb;
    public final int inSymb(int index) { return inSymb[index]; }

    public interface Name {
        public final static String name[] = {
            "", //$NON-NLS-1$
            "+", //$NON-NLS-1$
            "-", //$NON-NLS-1$
            "*", //$NON-NLS-1$
            "/", //$NON-NLS-1$
            ">", //$NON-NLS-1$
            "<", //$NON-NLS-1$
            "=", //$NON-NLS-1$
            ">=", //$NON-NLS-1$
            "<=", //$NON-NLS-1$
            "<>", //$NON-NLS-1$
            "(", //$NON-NLS-1$
            ")", //$NON-NLS-1$
            "{", //$NON-NLS-1$
            "}", //$NON-NLS-1$
            "[", //$NON-NLS-1$
            "]", //$NON-NLS-1$
            "->", //$NON-NLS-1$
            "|", //$NON-NLS-1$
            ",", //$NON-NLS-1$
            ":", //$NON-NLS-1$
            "::", //$NON-NLS-1$
            ";", //$NON-NLS-1$
            ".", //$NON-NLS-1$
            "..", //$NON-NLS-1$
            "+=", //$NON-NLS-1$
            ":=", //$NON-NLS-1$
            "@", //$NON-NLS-1$
            "!", //$NON-NLS-1$
            "!=", //$NON-NLS-1$
            "::=", //$NON-NLS-1$
            "?", //$NON-NLS-1$
            "$empty", //$NON-NLS-1$
            "INTEGER_LITERAL", //$NON-NLS-1$
            "REAL_LITERAL", //$NON-NLS-1$
            "STRING_LITERAL", //$NON-NLS-1$
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
            "self", //$NON-NLS-1$
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
            "end", //$NON-NLS-1$
            "while", //$NON-NLS-1$
            "when", //$NON-NLS-1$
            "var", //$NON-NLS-1$
            "log", //$NON-NLS-1$
            "assert", //$NON-NLS-1$
            "with", //$NON-NLS-1$
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
            "compute", //$NON-NLS-1$
            "new", //$NON-NLS-1$
            "List", //$NON-NLS-1$
            "Dict", //$NON-NLS-1$
            "break", //$NON-NLS-1$
            "continue", //$NON-NLS-1$
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
            "configuration", //$NON-NLS-1$
            "intermediate", //$NON-NLS-1$
            "property", //$NON-NLS-1$
            "opposites", //$NON-NLS-1$
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
            "static", //$NON-NLS-1$
            "result", //$NON-NLS-1$
            "main", //$NON-NLS-1$
            "this", //$NON-NLS-1$
            "rename", //$NON-NLS-1$
            "inherits", //$NON-NLS-1$
            "merges", //$NON-NLS-1$
            "disjuncts", //$NON-NLS-1$
            "IDENTIFIER", //$NON-NLS-1$
            "init", //$NON-NLS-1$
            "ERROR_TOKEN", //$NON-NLS-1$
            "EOF_TOKEN", //$NON-NLS-1$
            "QvtLwGoal", //$NON-NLS-1$
            "CollectionTypeIdentifierCS", //$NON-NLS-1$
            "simpleNameCS", //$NON-NLS-1$
            "unreservedSimpleNameCS", //$NON-NLS-1$
            "pathNameCS", //$NON-NLS-1$
            "typeCS", //$NON-NLS-1$
            "tupleTypePartsCS", //$NON-NLS-1$
            "typedUninitializedVariableCS" //$NON-NLS-1$
        };
    };
    public final static String name[] = Name.name;
    public final String name(int index) { return name[index]; }

    public final static int
           ERROR_SYMBOL      = 160,
           SCOPE_UBOUND      = 4,
           SCOPE_SIZE        = 5,
           MAX_NAME_LENGTH   = 28;

    public final int getErrorSymbol() { return ERROR_SYMBOL; }
    public final int getScopeUbound() { return SCOPE_UBOUND; }
    public final int getScopeSize() { return SCOPE_SIZE; }
    public final int getMaxNameLength() { return MAX_NAME_LENGTH; }

    public final static int
           NUM_STATES        = 24,
           NT_OFFSET         = 160,
           LA_STATE_OFFSET   = 1459,
           MAX_LA            = 1,
           NUM_RULES         = 682,
           NUM_NONTERMINALS  = 280,
           NUM_SYMBOLS       = 440,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 683,
           IDENTIFIER_SYMBOL = 1,
           EOFT_SYMBOL       = 26,
           EOLT_SYMBOL       = 26,
           ACCEPT_ACTION     = 776,
           ERROR_ACTION      = 777;

    public final static boolean BACKTRACK = true;

    public final int getNumStates() { return NUM_STATES; }
    public final int getNtOffset() { return NT_OFFSET; }
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }
    public final int getMaxLa() { return MAX_LA; }
    public final int getNumRules() { return NUM_RULES; }
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }
    public final int getNumSymbols() { return NUM_SYMBOLS; }
    public final int getSegmentSize() { return SEGMENT_SIZE; }
    public final int getStartState() { return START_STATE; }
    public final int getStartSymbol() { return lhs[0]; }
    public final int getIdentifierSymbol() { return IDENTIFIER_SYMBOL; }
    public final int getEoftSymbol() { return EOFT_SYMBOL; }
    public final int getEoltSymbol() { return EOLT_SYMBOL; }
    public final int getAcceptAction() { return ACCEPT_ACTION; }
    public final int getErrorAction() { return ERROR_ACTION; }
    public final boolean isValidForParser() { return isValidForParser; }
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int originalState(int state) {
        return -baseCheck[state];
    }
    public final int asi(int state) {
        return asb[originalState(state)];
    }
    public final int nasi(int state) {
        return nasb[originalState(state)];
    }
    public final int inSymbol(int state) {
        return inSymb[originalState(state)];
    }

    public final int ntAction(int state, int sym) {
        return baseAction[state + sym];
    }

    public final int tAction(int state, int sym) {
        int i = baseAction[state],
            k = i + sym;
        return termAction[termCheck[k] == sym ? k : i];
    }
    public final int lookAhead(int la_state, int sym) {
        int k = la_state + sym;
        return termAction[termCheck[k] == sym ? k : la_state];
    }
}
