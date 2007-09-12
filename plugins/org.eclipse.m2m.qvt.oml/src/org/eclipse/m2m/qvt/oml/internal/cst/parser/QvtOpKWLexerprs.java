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
* $Id: QvtOpKWLexerprs.java,v 1.11 2007/09/12 12:58:30 sboyko Exp $
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
* $Id: QvtOpKWLexerprs.java,v 1.11 2007/09/12 12:58:30 sboyko Exp $
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
            4,7,4,2,4,4,5,3,2,3,
            3,7,3,2,4,5,3,3,8,10,
            10,7,6,6,8,3,3,7,6,6,
            13,8,7,11,11,9,8,14,12,12,
            12,6,7,16,4,7,5,6,7,7,
            10,4,10,1,3,5,3,6,14,6,
            7,9,6,7,5,5,4,3,13,8,
            3,4,4,7,10,9,12,10,13,12,
            15,9,4,5,7,9,6,7,8,8,
            6,6,4
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
            2,2,2,2,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,97,54,31,12,168,
            127,87,73,147,170,173,169,178,184,98,
            32,61,104,100,107,76,18,110,37,65,
            84,113,41,115,90,186,187,189,192,194,
            116,195,118,196,199,202,126,53,200,131,
            208,203,209,211,215,216,134,217,219,226,
            201,227,231,233,234,220,222,237,238,243,
            241,245,247,125,138,139,248,46,253,246,
            258,249,89,260,256,264,262,261,268,271,
            273,275,277,272,282,146,284,285,290,291,
            293,295,299,149,301,302,283,300,304,56,
            309,307,312,314,315,317,319,321,318,325,
            323,330,143,332,333,336,338,341,342,345,
            343,346,353,355,356,359,153,360,361,362,
            363,347,366,371,162,364,370,372,375,379,
            382,386,388,380,390,384,391,392,399,400,
            402,404,405,406,408,413,415,417,420,423,
            425,427,430,432,433,435,437,439,441,438,
            442,443,452,453,449,455,458,459,461,462,
            463,471,473,474,477,478,479,481,444,483,
            485,488,490,492,493,499,501,489,502,506,
            497,507,510,511,512,513,514,515,517,518,
            522,526,531,525,534,532,36,536,538,540,
            542,543,544,545,546,548,557,555,561,563,
            562,564,565,566,568,572,573,577,578,580,
            584,585,582,595,409,586,593,597,599,600,
            601,603,602,607,608,613,614,617,609,619,
            620,626,627,628,631,621,639,632,635,643,
            644,637,647,648,649,651,151,653,24,654,
            655,656,657,664,659,164,666,667,671,672,
            675,676,684,679,688,690,668,680,691,693,
            696,698,701,704,705,702,710,711,713,714,
            716,717,723,725,718,728,721,731,732,733,
            734,736,737,741,742,744,748,740,754,753,
            755,756,759,760,761,763,767,764,771,772,
            773,776,777,778,784,786,165,792,794,793,
            787,797,799,801,802,806,805,813,804,817,
            809,821,818,823,826,827,828,829,831,833,
            837,473,473
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
            20,21,22,0,7,25,26,27,28,12,
            0,0,32,33,34,0,0,37,2,8,
            0,10,2,3,8,0,10,24,12,9,
            5,16,0,13,2,0,20,12,18,24,
            0,9,27,28,0,13,2,7,4,39,
            35,16,0,1,10,0,1,5,23,7,
            5,6,30,0,20,2,0,4,0,0,
            1,36,3,38,6,7,7,0,12,0,
            1,4,3,0,7,22,0,19,5,0,
            7,5,0,7,0,0,7,0,1,5,
            8,6,8,6,0,0,0,18,3,14,
            0,5,2,0,4,11,3,0,0,15,
            3,29,0,6,19,0,0,2,0,11,
            0,13,0,8,21,7,4,7,16,7,
            12,0,1,0,0,23,16,0,0,0,
            2,7,0,1,13,29,9,0,0,2,
            16,12,19,0,1,0,0,1,0,26,
            5,0,1,0,0,0,8,3,0,0,
            0,0,0,5,11,4,7,0,0,14,
            0,4,4,11,0,0,0,7,0,0,
            20,0,4,8,8,0,0,8,3,3,
            0,17,0,0,4,3,0,0,5,3,
            0,4,0,1,0,0,0,0,0,9,
            4,30,0,1,10,0,9,0,1,0,
            0,0,14,0,4,10,7,0,5,8,
            0,0,0,28,0,1,0,10,2,9,
            8,0,0,0,0,14,5,4,4,0,
            0,9,0,4,0,1,6,5,0,0,
            0,0,1,0,6,5,0,4,0,1,
            4,0,13,0,0,4,0,0,0,6,
            0,1,0,0,0,8,12,9,4,0,
            1,0,0,1,3,0,14,0,1,23,
            0,0,0,1,0,0,0,2,7,9,
            6,16,0,1,0,0,2,2,0,0,
            0,0,0,0,3,0,8,8,3,0,
            0,0,12,3,0,4,14,31,0,0,
            6,0,1,0,15,0,1,0,1,0,
            0,0,2,4,31,4,18,18,0,0,
            17,0,4,0,0,0,1,0,0,2,
            6,10,0,1,0,12,0,18,2,0,
            12,7,0,1,0,1,0,8,2,0,
            1,0,0,1,0,4,0,0,0,5,
            0,0,0,0,2,8,10,9,0,9,
            9,0,0,2,0,3,8,0,0,0,
            0,0,0,20,6,5,9,13,6,8,
            0,1,0,0,1,3,0,0,0,1,
            0,5,0,6,0,3,2,0,0,0,
            10,0,0,1,7,6,0,6,0,1,
            0,0,1,3,8,0,0,19,3,0,
            0,0,0,0,0,1,0,0,6,10,
            9,0,5,17,0,0,10,2,15,19,
            0,0,8,0,4,0,3,0,17,0,
            5,0,0,0,0,0,9,0,9,0,
            3,9,11,10,0,1,0,13,27,3,
            0,0,0,0,0,0,21,0,3,9,
            8,0,0,10,7,11,0,0,17,0,
            3,0,1,0,0,0,15,11,3,17,
            11,8,0,9,0,1,0,5,0,0,
            0,0,0,3,2,9,0,0,0,11,
            11,10,0,0,2,2,0,1,0,0,
            0,15,15,15,6,0,0,0,3,10,
            0,0,12,6,0,9,0,7,0,1,
            9,7,0,0,1,3,0,0,0,1,
            0,1,0,0,0,0,0,4,0,5,
            8,14,6,0,1,0,0,0,22,33,
            0,0,14,2,0,0,11,3,0,0,
            5,26,15,0,14,2,8,0,1,0,
            0,1,0,4,15,0,4,0,32,2,
            0,0,2,0,0,1,11,6,5,0,
            0,1,0,0,1,0,0,0,3,7,
            0,5,0,1,0,1,17,0,11,2,
            0,0,0,0,1,0,0,17,3,0,
            0,0,1,0,5,9,3,0,18,2,
            19,11,0,0,0,0,24,4,0,0,
            0,1,0,0,5,13,0,5,10,6,
            0,0,0,3,3,0,0,0,6,25,
            25,6,16,0,1,0,0,1,3,13,
            13,0,0,0,3,2,0,1,0,7,
            0,0,2,0,0,0,2,0,0,11,
            9,6,0,0,2,12,0,0,2,11,
            0,1,0,1,7,0,0,0,0,2,
            0,0,0,8,2,5,0,11,0,0,
            4,0,0,0,16,0,0,0,0,0,
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
            473,120,116,121,115,119,122,118,108,124,
            109,473,99,114,123,125,107,473,102,100,
            98,101,117,28,153,110,113,104,106,152,
            473,473,103,112,111,473,473,105,159,141,
            473,140,172,170,482,473,158,404,157,169,
            221,355,473,477,194,473,156,222,171,357,
            473,193,358,356,473,192,163,142,162,472,
            359,254,473,131,161,473,151,130,257,129,
            149,150,195,473,160,165,473,166,14,473,
            177,255,175,256,229,228,176,473,128,473,
            146,138,145,473,139,164,473,227,144,473,
            143,148,473,147,473,473,155,473,185,174,
            167,182,173,186,473,473,473,154,191,183,
            473,127,197,473,198,481,490,473,473,499,
            216,168,473,217,190,473,473,540,473,219,
            74,218,473,240,204,248,280,402,268,279,
            247,473,287,473,78,267,401,473,473,473,
            135,457,473,134,474,132,126,473,473,136,
            456,133,411,473,137,473,473,179,473,410,
            178,473,180,473,473,473,541,184,473,473,
            473,473,473,188,181,189,196,473,473,187,
            473,199,201,200,473,473,473,202,473,473,
            208,473,206,203,205,473,473,483,207,486,
            473,491,473,473,209,484,473,473,210,530,
            473,212,473,500,473,473,473,473,473,213,
            215,211,473,223,214,473,220,473,225,473,
            473,473,226,473,234,231,230,473,232,233,
            473,71,473,224,473,237,473,235,566,556,
            236,473,473,473,473,238,239,241,242,473,
            473,251,473,518,473,245,243,244,473,473,
            473,473,250,473,246,249,473,253,473,258,
            259,473,252,473,473,260,473,473,473,261,
            473,546,473,473,473,265,262,264,525,473,
            266,473,473,270,269,473,545,473,272,263,
            473,473,473,479,55,473,473,276,274,273,
            275,271,473,488,473,473,478,277,473,473,
            473,473,473,473,476,473,278,281,285,473,
            473,473,282,286,473,289,283,284,473,473,
            290,473,557,473,538,473,529,473,520,473,
            473,473,295,293,288,296,291,292,473,473,
            294,473,297,473,473,473,302,473,473,303,
            301,299,473,304,473,300,473,298,306,473,
            377,305,473,308,473,309,473,307,310,473,
            311,473,473,489,473,312,473,473,473,313,
            473,473,473,473,319,317,314,315,473,316,
            318,473,473,320,473,321,322,473,473,473,
            473,473,473,334,324,325,323,480,327,326,
            473,328,473,473,329,539,473,473,473,332,
            473,330,473,331,473,335,336,473,473,473,
            333,473,473,340,337,338,473,339,473,341,
            473,473,536,565,343,473,473,342,503,473,
            473,473,473,473,473,349,473,473,348,345,
            347,473,351,344,473,473,350,352,521,346,
            473,473,353,473,496,473,531,473,515,473,
            360,473,473,473,473,473,560,473,361,473,
            366,497,362,363,473,367,473,364,354,533,
            473,473,473,473,473,473,365,473,502,368,
            369,473,473,564,372,371,473,473,370,473,
            375,473,376,473,473,473,373,374,378,537,
            523,516,473,558,473,506,473,379,473,473,
            473,473,473,382,519,380,473,473,473,522,
            381,383,473,473,385,386,473,387,473,473,
            473,534,384,388,389,473,473,473,391,390,
            473,473,394,392,473,561,473,393,473,495,
            485,395,473,473,475,396,473,473,473,399,
            473,400,473,473,473,473,473,405,473,406,
            403,398,408,473,492,473,473,473,562,397,
            473,473,409,414,473,473,412,563,473,473,
            415,407,543,473,413,416,417,473,498,473,
            473,555,473,418,505,473,535,473,510,549,
            473,473,420,473,473,422,419,423,421,473,
            473,425,473,473,509,473,473,473,427,426,
            473,428,473,429,473,430,424,473,431,432,
            473,473,473,473,436,473,473,559,437,473,
            473,473,524,473,439,438,494,473,433,493,
            434,526,473,473,473,473,435,440,473,473,
            473,446,473,473,445,441,75,447,444,449,
            473,473,473,450,451,473,473,473,452,442,
            443,453,448,473,454,473,473,460,455,508,
            507,473,473,473,458,550,473,513,473,459,
            473,473,461,473,473,473,553,473,473,512,
            514,462,473,473,463,464,473,473,542,504,
            473,465,473,467,466,473,473,473,79,532,
            473,473,473,468,554,470,473,511,473,473,
            517,473,473,473,469
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
           NUM_STATES        = 375,
           NT_OFFSET         = 54,
           LA_STATE_OFFSET   = 566,
           MAX_LA            = 1,
           NUM_RULES         = 93,
           NUM_NONTERMINALS  = 3,
           NUM_SYMBOLS       = 57,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 94,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 39,
           EOLT_SYMBOL       = 55,
           ACCEPT_ACTION     = 472,
           ERROR_ACTION      = 473;

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
