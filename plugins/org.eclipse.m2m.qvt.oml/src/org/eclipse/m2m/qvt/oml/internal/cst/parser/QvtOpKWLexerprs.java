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
* $Id: QvtOpKWLexerprs.java,v 1.14 2007/09/13 13:58:15 sboyko Exp $
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
* $Id: QvtOpKWLexerprs.java,v 1.14 2007/09/13 13:58:15 sboyko Exp $
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
            4,4,7,10,9,12,10,13,12,15,
            9,4,5,7,9,6,7,8,8,6,
            6,4,4
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
            1,1,1,1,1,97,53,30,163,161,
            171,173,162,75,164,176,180,112,183,186,
            37,96,182,11,102,108,66,109,110,34,
            53,77,89,47,83,190,191,194,196,197,
            58,25,199,119,200,203,205,92,61,206,
            122,207,210,212,215,217,218,127,219,221,
            228,223,229,233,235,236,239,224,242,240,
            248,246,250,252,123,129,131,251,134,136,
            230,262,253,87,259,257,266,268,269,271,
            272,273,275,276,281,143,283,284,289,291,
            294,295,292,140,300,301,303,88,304,62,
            306,309,310,311,315,316,319,320,318,325,
            322,323,149,330,331,334,337,335,340,342,
            345,341,351,349,353,354,357,150,359,360,
            361,363,368,155,362,369,373,374,375,376,
            379,382,384,386,387,389,390,393,396,398,
            399,401,402,411,403,414,417,407,418,419,
            421,423,427,429,430,432,434,435,438,440,
            441,449,452,436,453,442,456,457,459,458,
            462,469,443,467,471,474,460,475,476,482,
            481,486,487,477,489,491,495,496,498,499,
            500,502,503,506,504,505,508,512,511,518,
            519,524,525,526,527,24,531,530,532,534,
            537,538,540,542,545,547,551,555,556,558,
            557,559,562,561,569,570,571,572,573,575,
            577,587,579,589,585,593,594,595,596,598,
            597,601,603,607,610,613,606,611,615,619,
            620,624,625,623,627,631,634,633,636,637,
            639,642,644,153,638,647,650,651,648,649,
            659,661,158,657,662,663,664,669,668,676,
            679,680,682,670,683,688,689,694,695,698,
            690,700,701,704,702,707,710,711,714,719,
            712,721,717,724,725,726,727,729,730,731,
            735,737,743,733,747,746,748,749,752,753,
            754,756,760,762,764,766,765,772,757,775,
            779,781,159,782,787,783,791,793,786,795,
            798,799,800,801,804,806,809,810,813,814,
            817,812,821,818,824,826,827,469,469
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            0,11,12,13,14,5,16,7,18,19,
            20,21,22,0,0,25,26,27,28,0,
            6,31,32,0,34,2,0,37,14,16,
            4,8,0,7,11,12,0,24,2,3,
            27,28,0,20,2,9,4,0,35,13,
            0,0,2,11,18,0,1,10,39,9,
            5,6,20,13,0,1,0,16,2,5,
            4,7,0,1,23,3,0,0,0,7,
            30,0,6,7,3,0,8,36,22,38,
            13,0,1,8,3,19,11,0,0,0,
            19,0,5,2,7,7,7,29,0,1,
            12,0,0,2,6,4,0,18,0,3,
            0,3,10,0,6,0,1,15,5,0,
            10,6,0,13,2,12,7,21,0,0,
            8,12,0,4,0,1,7,0,0,7,
            0,0,0,0,16,7,4,13,16,9,
            0,23,0,12,16,0,19,5,8,0,
            1,0,0,26,2,0,1,12,7,0,
            0,1,29,0,5,0,0,1,0,0,
            7,3,0,8,0,0,0,5,4,0,
            4,0,7,14,0,4,0,0,0,10,
            0,7,0,0,4,8,8,0,0,0,
            3,3,0,17,0,0,4,3,0,0,
            5,0,20,4,3,0,8,0,1,0,
            0,0,0,30,9,4,0,28,0,9,
            11,0,1,5,8,0,14,0,0,4,
            0,0,0,1,0,0,2,9,11,8,
            0,0,0,0,14,5,4,4,0,14,
            0,0,4,0,0,1,6,6,5,0,
            0,1,0,0,5,0,1,4,0,0,
            0,9,4,4,0,0,6,0,0,0,
            1,0,0,1,0,8,12,9,4,0,
            0,1,3,0,0,14,0,1,23,0,
            0,0,2,9,0,1,7,6,0,16,
            0,1,0,0,2,2,0,9,0,0,
            0,0,0,3,8,3,8,0,0,1,
            3,12,0,0,0,0,0,4,0,1,
            6,0,1,0,1,0,0,15,0,0,
            4,2,0,18,33,0,4,0,0,4,
            0,0,0,18,2,17,0,6,2,11,
            0,1,12,0,1,18,0,0,0,1,
            0,1,0,7,2,8,0,1,0,0,
            1,0,4,0,0,0,5,0,3,0,
            0,0,0,9,11,3,9,8,0,9,
            2,0,0,2,13,0,0,0,0,0,
            8,0,6,5,9,8,0,6,0,1,
            0,1,6,0,0,0,0,1,3,20,
            0,0,8,2,11,0,0,7,0,1,
            0,6,6,3,0,0,1,0,0,0,
            3,0,0,0,0,0,8,0,1,6,
            0,0,11,19,9,5,17,0,0,15,
            2,19,11,0,0,0,0,4,3,0,
            0,0,8,0,17,5,0,0,9,0,
            9,0,0,10,0,9,0,3,11,3,
            0,1,13,27,0,0,0,0,0,3,
            0,0,21,9,3,7,11,10,0,0,
            0,0,0,3,0,15,0,1,0,10,
            8,10,0,9,0,17,0,1,0,5,
            12,3,0,0,0,0,0,0,3,2,
            0,9,0,10,10,0,0,11,2,0,
            0,2,0,1,0,15,6,15,0,0,
            15,3,0,0,0,11,0,1,9,6,
            0,7,0,0,12,0,0,0,0,9,
            7,0,1,0,1,8,0,0,0,0,
            0,15,14,4,6,5,0,22,0,1,
            0,0,0,0,32,2,10,0,0,0,
            24,3,5,26,14,0,14,2,0,0,
            1,0,0,1,15,4,8,0,0,0,
            1,4,31,0,0,2,2,0,10,0,
            0,0,5,0,1,6,0,1,7,0,
            0,0,3,0,1,5,0,17,0,1,
            0,10,2,0,0,0,0,1,0,0,
            0,3,0,17,0,1,0,5,9,3,
            10,18,0,19,2,0,0,0,0,24,
            4,0,0,0,1,0,0,5,13,0,
            5,0,11,0,0,0,3,6,3,13,
            6,0,25,25,0,16,0,6,0,1,
            0,0,0,3,3,0,0,13,2,7,
            0,1,0,1,0,10,2,0,0,0,
            0,2,2,0,6,0,9,2,0,0,
            1,0,0,0,1,12,0,0,10,7,
            0,10,2,0,8,0,0,2,5,0,
            4,0,0,16,0,0,0,0,0,0,
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
            469,121,117,122,116,120,123,119,109,124,
            469,110,99,115,100,145,108,144,103,101,
            98,102,118,469,469,111,114,105,107,469,
            182,104,113,469,112,160,469,106,183,353,
            139,477,469,140,159,158,469,355,173,171,
            356,354,469,157,164,170,163,469,357,472,
            469,469,194,162,172,469,152,181,468,193,
            150,151,161,192,469,132,469,254,166,131,
            167,130,469,176,257,174,13,469,469,175,
            195,469,230,229,191,469,168,255,165,256,
            252,469,147,142,146,228,141,469,469,469,
            190,469,149,136,148,154,156,169,469,185,
            153,469,469,197,186,198,469,155,469,485,
            469,216,476,469,217,469,224,494,221,469,
            219,223,469,218,535,222,248,204,469,469,
            240,247,73,280,469,285,279,469,77,398,
            469,469,469,469,268,453,125,470,397,126,
            469,267,469,129,452,469,407,128,127,469,
            135,469,469,406,137,469,138,134,143,469,
            469,178,133,469,177,469,469,180,469,469,
            179,184,469,536,469,469,469,188,189,469,
            199,469,196,187,469,201,469,469,469,200,
            469,202,469,469,206,203,205,469,469,469,
            207,481,469,486,469,469,209,479,469,469,
            210,469,208,212,525,469,478,469,495,469,
            469,469,469,211,213,215,469,225,469,220,
            214,469,226,231,232,469,227,469,469,233,
            469,469,469,237,469,70,561,551,234,236,
            469,469,469,469,235,239,241,242,469,238,
            469,469,513,469,469,245,243,246,244,469,
            469,250,469,469,249,469,258,253,469,469,
            469,251,259,260,469,469,261,469,469,469,
            541,469,469,266,469,265,262,264,520,469,
            469,270,269,469,469,540,469,272,263,469,
            469,54,276,273,469,474,274,275,469,271,
            469,483,469,469,473,277,469,562,469,469,
            469,469,469,471,278,283,281,469,469,287,
            284,282,469,469,469,469,469,288,469,552,
            289,469,524,469,515,469,469,533,469,469,
            292,294,469,290,286,469,295,469,469,296,
            469,469,469,291,302,293,469,300,305,298,
            469,301,299,469,303,297,469,469,469,307,
            469,308,469,304,309,306,469,310,469,469,
            484,469,311,469,469,469,312,469,320,469,
            469,469,469,314,313,534,315,316,469,317,
            318,469,469,319,475,469,469,469,469,469,
            321,469,323,324,322,325,469,326,469,327,
            469,329,328,469,469,469,469,338,333,331,
            469,469,332,334,330,469,469,335,469,339,
            469,336,337,560,469,469,531,469,469,469,
            498,469,469,469,469,469,341,469,347,346,
            469,469,343,340,345,349,342,469,469,516,
            350,344,348,469,469,469,469,491,526,469,
            469,469,351,469,510,358,469,469,555,469,
            359,469,469,360,469,492,469,364,361,528,
            469,365,362,352,469,469,469,469,469,497,
            469,469,363,366,369,368,559,367,469,469,
            469,469,469,372,469,370,469,373,469,371,
            511,518,469,553,469,532,469,501,469,376,
            374,375,469,469,469,469,469,469,379,514,
            469,377,469,517,378,469,469,380,382,469,
            469,383,469,384,469,529,386,381,469,469,
            385,388,469,469,469,387,469,490,556,389,
            469,390,469,469,391,469,469,469,469,480,
            392,469,395,469,396,399,27,469,469,469,
            469,538,394,401,404,402,469,557,469,487,
            469,469,469,469,393,410,408,469,469,469,
            400,558,411,403,405,469,409,412,469,469,
            493,469,469,550,500,414,413,469,469,469,
            418,530,505,469,469,544,416,469,415,469,
            469,469,417,469,421,419,469,504,422,469,
            469,469,423,469,425,424,469,420,469,426,
            469,427,428,469,469,469,469,432,469,469,
            469,433,469,554,469,519,469,435,434,489,
            521,429,469,430,488,469,469,469,469,431,
            436,469,469,469,442,469,469,441,437,74,
            443,469,440,469,469,469,446,445,447,503,
            448,469,438,439,469,444,469,449,469,450,
            469,469,469,451,454,469,469,502,545,455,
            469,456,469,508,469,507,457,469,469,469,
            469,548,459,469,458,469,509,537,469,469,
            461,469,469,469,463,460,469,78,499,462,
            469,506,527,469,464,469,469,549,466,469,
            512,469,469,465
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
           NUM_STATES        = 371,
           NT_OFFSET         = 54,
           LA_STATE_OFFSET   = 562,
           MAX_LA            = 1,
           NUM_RULES         = 93,
           NUM_NONTERMINALS  = 3,
           NUM_SYMBOLS       = 57,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 94,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 39,
           EOLT_SYMBOL       = 55,
           ACCEPT_ACTION     = 468,
           ERROR_ACTION      = 469;

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
