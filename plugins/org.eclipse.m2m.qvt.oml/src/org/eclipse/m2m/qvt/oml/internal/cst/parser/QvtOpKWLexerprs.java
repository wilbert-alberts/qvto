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
* $Id: QvtOpKWLexerprs.java,v 1.20.2.7 2008/01/09 21:50:04 radvorak Exp $
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
* $Id: QvtOpKWLexerprs.java,v 1.20.2.7 2008/01/09 21:50:04 radvorak Exp $
*/

package org.eclipse.m2m.qvt.oml.internal.cst.parser;

public class QvtOpKWLexerprs implements lpg.lpgjavaruntime.ParseTable, QvtOpKWLexersym {

    public interface IsKeyword {
        public final static byte isKeyword[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            4,4,2,4,4,5,3,2,3,3,
            7,3,2,4,5,3,3,8,10,10,
            7,6,6,8,3,3,7,6,6,13,
            8,7,11,11,9,8,14,12,12,12,
            6,7,16,4,7,5,6,7,7,10,
            4,10,1,3,5,3,6,14,6,7,
            9,6,7,5,5,4,3,13,8,3,
            4,4,3,6,4,7,10,9,12,10,
            13,12,15,9,4,5,7,9,6,7,
            8,8,6,6,4,4,6
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            1,2,2,2,2,2,2,2,2,2,
            2,2,2,2,2,2,2,2,2,2,
            2,2,2,2,2,2,2,2,2,2,
            2,2,2,2,2,2,2,2,2,2,
            2,2,2,2,2,2,2,2,2,2,
            2,2,2,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,101,
            53,36,12,103,138,184,74,83,89,168,
            185,61,189,193,18,92,195,32,114,112,
            72,121,122,34,45,93,123,50,58,200,
            201,196,199,209,205,131,211,212,134,169,
            215,217,106,82,218,124,219,220,224,225,
            227,229,141,230,232,234,235,27,240,241,
            246,243,247,249,252,253,258,105,255,260,
            263,137,149,142,262,150,159,261,269,264,
            99,271,272,273,277,274,283,285,286,287,
            290,292,294,275,158,298,300,303,305,308,
            311,309,165,313,316,318,319,321,62,322,
            326,327,328,329,334,336,337,335,339,340,
            345,156,347,350,352,348,355,357,358,360,
            361,367,368,371,372,373,374,166,378,379,
            380,384,388,392,175,381,395,385,389,397,
            398,403,405,407,399,409,401,412,419,420,
            410,411,422,425,426,429,435,431,437,433,
            443,445,438,447,449,450,452,454,455,456,
            457,463,458,465,470,472,471,475,476,478,
            477,481,486,492,485,479,494,495,497,126,
            500,501,502,498,508,510,511,516,518,504,
            521,524,519,514,525,527,530,529,532,537,
            533,541,539,542,540,549,550,551,41,553,
            555,557,562,554,563,564,566,567,570,571,
            575,577,578,581,582,584,587,588,585,592,
            594,596,597,601,606,602,613,604,615,611,
            619,620,621,622,623,627,628,629,630,635,
            639,634,636,642,645,648,646,650,653,655,
            657,659,660,661,662,664,668,670,171,666,
            672,676,674,673,679,682,686,178,688,687,
            689,690,694,695,704,697,708,711,705,712,
            714,716,719,721,723,725,728,717,731,729,
            735,738,739,741,743,745,747,748,749,751,
            752,753,755,758,760,761,766,769,773,759,
            774,42,775,776,777,781,783,779,788,789,
            792,796,798,797,799,804,806,182,807,811,
            813,815,817,819,820,822,824,831,832,825,
            833,827,839,841,842,844,845,847,846,848,
            851,857,484,484
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,0,12,13,14,4,16,0,18,19,
            20,4,22,23,24,8,0,27,28,29,
            30,0,32,0,34,0,3,37,7,8,
            0,0,9,10,0,12,20,3,4,0,
            6,2,3,20,10,6,16,0,1,2,
            0,0,13,3,20,8,26,18,27,29,
            30,0,1,0,39,35,5,16,7,8,
            23,0,0,1,3,12,25,6,0,7,
            8,0,0,5,13,3,4,36,0,38,
            9,10,0,5,0,0,8,2,6,21,
            6,0,31,0,1,2,24,19,7,8,
            0,0,0,0,19,0,3,4,8,8,
            0,9,12,0,1,5,0,0,5,18,
            0,0,2,21,14,20,9,11,0,0,
            2,15,11,5,13,0,7,0,0,1,
            3,12,22,5,0,0,9,0,0,4,
            0,16,8,8,0,1,12,0,8,12,
            25,0,14,0,0,1,16,13,0,8,
            7,3,0,1,0,0,19,16,0,0,
            0,1,8,8,0,28,7,9,0,1,
            0,0,2,2,0,11,0,0,0,0,
            4,7,4,0,0,8,0,4,0,0,
            11,0,8,0,0,4,2,9,9,0,
            0,2,0,17,4,0,0,2,0,7,
            17,0,0,2,0,9,4,0,1,0,
            0,0,0,0,10,6,4,6,0,1,
            0,0,0,0,0,5,0,14,7,31,
            4,9,0,10,0,0,0,1,6,0,
            30,0,3,0,9,21,0,0,14,0,
            7,4,0,4,0,14,4,0,0,5,
            0,1,0,5,7,0,1,0,0,7,
            0,0,1,6,4,0,0,0,0,4,
            4,13,5,0,0,0,0,1,0,0,
            12,6,4,9,0,1,0,0,2,0,
            1,0,1,14,0,1,0,0,25,0,
            0,1,6,16,5,8,0,0,1,3,
            0,0,0,0,3,3,6,0,0,0,
            0,2,9,0,0,2,9,0,0,2,
            12,0,4,2,0,1,0,0,0,15,
            0,5,0,1,0,1,0,1,0,0,
            0,0,4,33,3,18,18,17,0,0,
            10,0,4,4,0,0,1,18,0,5,
            0,3,0,12,0,1,0,0,8,3,
            3,9,0,1,0,1,0,1,0,0,
            1,0,4,0,0,0,0,0,7,0,
            6,6,0,10,0,9,9,3,6,0,
            0,0,3,2,0,0,0,0,0,9,
            0,6,5,7,0,0,2,13,10,9,
            5,0,1,0,0,1,0,0,5,0,
            0,0,2,0,3,8,10,0,9,0,
            0,1,5,0,5,0,1,0,0,2,
            0,1,19,0,0,2,0,9,0,0,
            17,0,0,5,10,6,0,1,0,0,
            0,0,10,4,3,19,15,7,0,0,
            0,2,0,0,0,17,0,9,2,7,
            6,0,0,0,11,0,0,6,6,0,
            0,2,2,10,0,1,0,0,13,29,
            0,0,6,0,0,2,0,0,22,2,
            10,0,11,0,8,0,0,2,21,15,
            0,0,1,0,11,0,0,11,17,9,
            0,6,0,1,0,12,2,7,0,0,
            0,0,0,2,6,3,0,0,0,0,
            11,11,3,0,0,0,10,3,0,1,
            5,0,15,15,0,0,2,0,15,0,
            5,10,0,6,0,1,0,8,0,0,
            0,0,6,0,12,0,8,0,1,0,
            1,0,0,0,9,0,15,14,0,4,
            7,0,1,5,24,0,0,0,0,0,
            0,32,3,0,0,2,0,26,11,14,
            28,7,14,0,0,9,3,0,1,23,
            0,0,1,0,4,0,0,4,0,15,
            0,3,0,3,0,1,11,0,0,7,
            0,1,5,17,0,1,8,0,0,2,
            0,1,0,1,0,7,0,0,0,3,
            0,0,0,1,0,11,2,0,0,0,
            0,1,4,6,17,0,18,2,0,19,
            11,3,0,0,0,0,0,26,0,7,
            0,1,0,7,0,10,13,0,0,7,
            2,0,5,2,16,0,0,0,0,0,
            5,27,5,0,1,0,0,2,2,13,
            0,13,0,3,0,1,0,1,0,0,
            8,0,3,0,0,0,0,6,5,11,
            0,0,0,3,3,3,12,11,0,1,
            0,0,1,0,0,0,0,0,8,3,
            0,0,9,3,7,11,0,0,0,0,
            4,16,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            484,125,126,121,120,127,128,124,123,113,
            114,484,103,119,104,129,112,484,107,105,
            102,144,106,108,122,145,484,115,118,109,
            111,484,117,484,116,484,166,110,150,149,
            484,484,492,165,484,164,217,171,170,484,
            169,178,180,163,168,177,368,484,184,182,
            484,484,487,141,167,183,370,179,453,371,
            369,484,158,484,483,372,157,265,156,155,
            181,484,484,136,203,133,268,202,484,135,
            134,484,484,137,201,173,174,266,13,267,
            147,146,484,240,484,484,239,200,130,138,
            222,484,204,484,152,151,172,238,154,153,
            484,484,484,484,199,484,206,207,160,162,
            484,175,159,484,194,190,484,484,195,161,
            484,484,500,176,191,346,131,491,484,484,
            226,509,229,227,228,484,231,484,484,234,
            550,232,213,233,484,484,251,484,484,292,
            76,279,259,291,484,298,258,484,413,139,
            278,80,196,484,484,140,412,485,484,468,
            132,142,484,143,484,484,422,467,484,484,
            484,186,148,187,484,421,185,551,484,188,
            484,484,192,193,484,189,484,484,484,484,
            198,197,208,484,484,205,484,210,484,484,
            209,484,211,484,484,215,216,212,214,484,
            484,496,484,501,218,484,484,494,484,219,
            557,484,484,540,484,493,221,484,510,484,
            484,484,484,484,223,224,225,230,484,236,
            484,484,484,484,484,241,484,237,242,220,
            244,243,484,245,484,484,484,248,569,484,
            235,70,579,484,247,559,484,484,246,484,
            250,252,484,253,484,249,528,484,484,254,
            484,256,484,257,255,484,261,484,484,260,
            484,484,269,262,264,484,484,484,484,270,
            271,263,272,484,484,484,484,556,484,484,
            273,275,535,276,484,277,484,484,280,484,
            281,484,282,555,484,284,484,484,274,54,
            484,489,285,283,287,286,484,484,498,288,
            484,484,484,484,488,289,580,484,484,484,
            484,486,290,484,484,295,293,484,484,296,
            294,484,301,297,484,300,484,484,484,548,
            484,302,484,570,484,539,484,530,484,484,
            484,484,305,299,307,303,304,306,484,484,
            311,484,308,309,484,484,314,310,484,313,
            484,315,484,312,484,316,484,484,317,318,
            322,319,484,320,484,321,484,323,484,484,
            499,484,324,484,484,484,484,484,325,484,
            327,328,484,326,484,329,331,332,330,484,
            484,484,333,334,484,484,484,484,484,335,
            484,336,337,338,484,484,549,490,342,339,
            340,484,341,484,484,344,484,484,343,484,
            484,484,348,484,349,350,345,484,347,484,
            484,353,351,484,352,484,354,484,484,578,
            484,546,355,484,484,513,484,356,484,484,
            357,484,484,361,358,360,484,362,484,484,
            484,484,363,506,365,359,531,364,484,484,
            484,541,484,484,484,525,484,366,558,373,
            573,484,484,484,375,484,484,374,507,484,
            484,379,543,376,484,380,484,484,377,367,
            484,484,381,484,484,512,484,484,378,384,
            577,484,382,484,383,484,484,387,581,385,
            484,484,388,484,386,484,484,533,547,526,
            484,571,484,516,484,389,390,391,484,484,
            484,484,484,394,392,529,484,484,484,484,
            532,393,397,484,484,484,395,398,484,399,
            401,484,544,396,484,484,403,484,400,484,
            404,402,484,574,484,505,484,405,484,484,
            484,484,495,484,406,484,407,484,410,484,
            411,27,484,484,414,484,553,409,484,416,
            417,484,502,419,575,484,484,484,484,484,
            484,408,425,484,484,576,484,415,423,420,
            418,426,424,484,484,428,427,484,508,520,
            484,484,568,484,429,484,484,545,484,515,
            484,562,484,431,484,433,430,484,484,432,
            484,436,434,435,484,519,437,484,484,438,
            484,440,484,441,484,439,484,484,484,443,
            484,484,484,447,484,442,448,484,484,484,
            484,534,451,449,572,484,444,504,484,445,
            536,503,484,484,484,484,484,446,77,450,
            484,457,484,456,484,455,452,484,484,458,
            461,484,460,462,459,484,484,484,484,484,
            463,454,464,484,465,484,484,466,469,518,
            484,517,484,563,484,471,484,523,484,484,
            470,484,472,484,484,484,484,524,473,522,
            484,484,484,566,474,552,475,514,484,476,
            484,484,478,484,484,81,484,484,477,542,
            484,484,479,567,481,521,484,484,484,484,
            527,480
        };
    };
    public final static char termAction[] = TermAction.termAction;
    public final int termAction(int index) { return termAction[index]; }
    public final int asb(int index) { return 0; }
    public final int asr(int index) { return 0; }
    public final int nasb(int index) { return 0; }
    public final int nasr(int index) { return 0; }
    public final int terminalIndex(int index) { return 0; }
    public final int nonterminalIndex(int index) { return 0; }
    public final int scopePrefix(int index) { return 0;}
    public final int scopeSuffix(int index) { return 0;}
    public final int scopeLhs(int index) { return 0;}
    public final int scopeLa(int index) { return 0;}
    public final int scopeStateSet(int index) { return 0;}
    public final int scopeRhs(int index) { return 0;}
    public final int scopeState(int index) { return 0;}
    public final int inSymb(int index) { return 0;}
    public final String name(int index) { return null; }
    public final int getErrorSymbol() { return 0; }
    public final int getScopeUbound() { return 0; }
    public final int getScopeSize() { return 0; }
    public final int getMaxNameLength() { return 0; }

    public final static int
           NUM_STATES        = 382,
           NT_OFFSET         = 54,
           LA_STATE_OFFSET   = 581,
           MAX_LA            = 1,
           NUM_RULES         = 97,
           NUM_NONTERMINALS  = 3,
           NUM_SYMBOLS       = 57,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 98,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 39,
           EOLT_SYMBOL       = 55,
           ACCEPT_ACTION     = 483,
           ERROR_ACTION      = 484;

    public final static boolean BACKTRACK = false;

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

    public final int originalState(int state) { return 0; }
    public final int asi(int state) { return 0; }
    public final int nasi(int state) { return 0; }
    public final int inSymbol(int state) { return 0; }

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
