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
* $Id: QvtOpKWLexerprs.java,v 1.1 2007/07/29 19:50:55 radvorak Exp $
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
* $Id: QvtOpKWLexerprs.java,v 1.1 2007/07/29 19:50:55 radvorak Exp $
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
            6
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
            1,1,1,95,54,125,128,160,99,166,
            48,141,167,24,171,172,176,12,98,180,
            96,106,110,77,111,112,30,60,69,113,
            43,81,94,182,183,181,189,185,191,41,
            121,192,193,195,124,63,194,131,197,202,
            203,204,208,209,36,211,215,214,212,220,
            222,221,228,227,229,235,236,230,237,239,
            241,68,136,134,242,114,243,247,252,248,
            84,250,254,255,258,257,263,267,270,268,
            266,274,146,278,281,283,284,286,271,288,
            289,293,299,294,297,301,51,306,304,309,
            311,290,312,314,315,317,318,320,325,138,
            327,328,321,331,333,338,339,340,343,348,
            350,351,354,151,355,346,356,357,336,360,
            365,149,364,366,369,370,372,374,376,379,
            382,383,384,386,385,391,392,393,396,397,
            406,410,407,412,415,416,418,421,424,399,
            426,428,420,429,431,432,434,435,442,445,
            446,436,441,447,451,452,454,457,460,464,
            461,467,468,470,471,473,472,477,478,479,
            481,484,488,489,492,493,494,496,497,499,
            501,498,502,504,505,512,515,518,519,520,
            521,31,525,524,527,528,531,532,534,535,
            538,543,544,549,550,537,551,552,559,560,
            553,555,564,567,565,571,573,579,583,569,
            574,585,586,587,588,589,591,594,596,597,
            600,601,605,607,608,609,610,614,617,615,
            618,626,620,628,632,636,624,631,633,638,
            640,152,642,643,644,645,646,651,654,652,
            137,658,656,660,661,662,668,675,664,678,
            676,670,681,682,686,684,687,691,692,698,
            694,700,703,701,705,708,709,712,715,710,
            718,719,722,723,724,725,727,728,732,733,
            735,729,739,741,746,747,749,750,751,752,
            757,754,755,758,764,765,768,766,769,777,
            780,159,781,785,786,788,790,793,794,797,
            795,798,799,802,805,808,809,811,812,815,
            816,818,821,823,824,771,468,468
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,0,12,13,14,4,16,6,18,19,
            20,21,22,0,1,25,26,27,28,0,
            0,2,32,33,34,0,7,37,3,10,
            0,12,0,3,2,3,16,0,1,20,
            0,9,5,6,24,13,21,27,28,0,
            18,2,0,4,2,35,16,0,0,10,
            2,9,4,23,0,13,0,1,11,20,
            0,5,15,0,8,5,36,7,38,6,
            22,8,30,0,1,0,3,0,0,6,
            5,6,19,5,7,0,1,10,3,0,
            0,0,0,0,5,6,6,6,5,7,
            0,1,12,0,0,12,3,0,8,18,
            0,4,2,0,4,0,0,0,3,0,
            0,29,19,8,11,0,13,2,0,1,
            0,0,7,16,4,19,6,6,0,0,
            23,13,26,39,6,0,0,16,9,29,
            0,0,2,2,16,0,1,12,12,0,
            0,0,0,1,0,6,5,7,0,1,
            0,0,0,0,0,11,0,5,4,6,
            4,0,0,0,14,14,4,0,0,6,
            0,0,11,0,0,7,3,7,4,0,
            0,0,3,3,17,4,0,0,0,0,
            1,20,5,7,0,0,0,3,0,4,
            0,0,0,1,4,9,0,0,10,0,
            9,0,1,0,0,6,0,0,30,5,
            4,14,0,10,7,0,0,0,1,0,
            0,1,10,0,28,9,7,0,5,14,
            0,4,0,0,4,0,4,0,0,0,
            5,8,0,0,6,8,0,5,0,1,
            0,12,9,0,4,0,1,4,0,13,
            0,0,4,0,0,1,0,0,8,0,
            0,4,9,7,0,1,0,0,1,3,
            0,1,0,14,23,0,16,0,0,0,
            1,9,0,6,2,0,8,0,1,0,
            0,2,2,0,0,0,0,12,3,0,
            7,7,3,0,0,0,31,3,0,0,
            14,0,4,0,1,0,1,8,0,1,
            15,0,0,0,0,0,4,2,4,18,
            0,0,0,0,31,0,0,1,0,18,
            17,10,4,8,12,0,0,2,18,0,
            1,0,6,2,0,0,1,0,1,0,
            0,7,2,0,1,0,1,0,0,10,
            0,0,5,0,0,0,2,9,7,9,
            0,0,9,2,0,0,0,3,13,9,
            0,0,7,0,8,5,0,1,7,0,
            0,8,3,0,1,5,0,0,1,0,
            0,0,0,2,8,3,0,0,0,10,
            0,1,6,0,1,8,8,0,0,1,
            20,0,0,0,3,0,0,0,0,7,
            0,0,1,0,0,10,19,9,8,5,
            17,0,15,10,0,19,2,0,0,0,
            0,4,3,0,0,7,0,0,17,5,
            0,0,9,0,0,9,0,0,11,9,
            3,10,0,0,1,3,13,27,0,0,
            0,0,0,17,0,21,7,9,0,0,
            10,3,11,0,0,6,0,15,0,3,
            0,17,0,0,11,11,3,7,0,1,
            12,9,0,1,0,0,0,0,0,5,
            0,3,2,0,9,0,0,11,11,0,
            0,2,2,10,0,1,0,0,0,0,
            15,15,3,0,0,8,0,0,10,0,
            6,15,9,0,8,0,1,0,9,12,
            0,0,0,6,3,0,1,0,1,0,
            1,0,0,0,0,0,14,4,7,5,
            0,0,22,0,1,0,33,0,8,0,
            0,0,2,0,3,14,24,0,11,0,
            7,26,5,14,0,0,2,0,1,4,
            0,0,1,0,15,0,0,32,2,4,
            0,0,2,0,11,15,5,0,1,0,
            0,8,0,1,0,1,6,0,0,0,
            3,0,1,5,0,1,17,0,0,2,
            11,0,0,0,0,1,0,0,0,3,
            2,0,0,1,0,17,9,3,0,18,
            0,19,11,5,4,0,0,24,0,0,
            0,0,1,0,0,5,0,0,13,10,
            3,5,8,0,0,0,3,0,0,16,
            0,25,8,25,4,8,0,1,13,0,
            0,13,3,3,0,0,2,0,1,0,
            1,6,0,0,0,2,0,0,0,2,
            2,0,8,11,0,9,2,0,0,1,
            0,0,1,12,0,0,6,0,11,2,
            0,7,0,0,0,2,11,5,0,0,
            0,0,0,0,0,0,16,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            468,118,114,119,113,117,116,106,120,122,
            107,468,97,112,121,136,105,137,100,98,
            96,99,115,468,132,108,111,102,104,468,
            468,157,101,110,109,468,477,103,485,156,
            468,155,468,181,170,168,350,468,129,154,
            468,167,128,127,352,472,201,353,351,468,
            169,161,468,160,191,354,250,468,468,159,
            163,190,164,253,468,189,468,149,476,158,
            468,147,494,14,148,172,251,171,252,225,
            162,226,192,468,175,468,173,468,468,174,
            142,141,224,125,139,468,144,138,143,468,
            468,468,468,468,146,145,151,153,218,165,
            468,182,150,468,468,219,188,468,183,152,
            468,123,194,468,195,468,468,468,213,468,
            468,166,187,214,216,468,215,535,468,283,
            468,74,237,264,276,406,275,397,78,468,
            263,469,405,467,452,468,468,396,124,130,
            468,468,133,134,451,468,135,126,131,468,
            468,468,468,177,468,140,176,536,468,178,
            468,468,468,468,468,179,468,185,186,193,
            196,468,468,468,180,184,198,468,468,199,
            468,468,197,468,468,200,204,202,203,468,
            468,468,481,479,486,206,468,468,468,468,
            495,205,207,478,468,468,468,525,468,209,
            468,468,468,220,212,210,468,468,211,468,
            217,468,222,468,468,227,468,468,208,229,
            231,223,468,228,230,71,468,468,234,468,
            468,242,232,468,221,551,233,468,236,235,
            468,238,468,468,239,468,513,468,468,468,
            241,240,468,468,244,243,468,245,468,246,
            468,258,247,468,249,468,254,255,468,248,
            468,468,256,468,468,541,468,468,257,468,
            468,520,260,261,468,262,468,468,266,265,
            468,268,468,540,259,468,267,468,55,468,
            474,269,468,270,272,468,271,468,483,468,
            468,473,273,468,468,468,468,278,471,468,
            274,277,281,468,468,468,280,282,468,468,
            279,468,285,468,552,468,524,286,468,515,
            533,468,468,468,468,468,289,291,292,287,
            468,468,468,468,284,468,468,297,468,288,
            290,294,307,296,295,468,468,298,293,468,
            299,468,300,301,468,468,303,468,304,468,
            468,302,305,468,306,468,484,468,468,309,
            468,468,308,468,468,468,314,310,312,311,
            468,468,313,315,468,468,468,316,475,318,
            468,468,317,468,319,320,468,323,321,468,
            468,322,534,468,324,325,468,468,327,468,
            468,468,468,331,326,330,468,468,468,328,
            468,335,332,468,336,333,334,468,468,531,
            329,468,468,468,498,468,468,468,468,338,
            468,468,344,468,468,340,337,342,343,346,
            339,468,516,345,468,341,347,468,468,468,
            468,491,526,468,468,348,468,468,510,355,
            468,468,555,468,468,356,468,468,357,492,
            361,358,468,468,362,528,359,349,468,468,
            468,468,468,365,468,360,364,363,468,468,
            559,497,366,468,468,367,468,368,468,370,
            468,532,468,468,369,518,373,511,468,371,
            372,553,468,501,468,468,468,468,468,374,
            468,377,514,468,375,468,468,517,376,468,
            468,380,381,378,468,382,468,468,468,468,
            529,379,386,468,468,384,468,468,385,468,
            388,383,556,468,387,468,490,468,480,389,
            468,468,468,390,391,468,470,468,394,468,
            395,468,28,468,468,468,393,400,398,401,
            468,468,557,468,487,468,392,468,403,468,
            468,468,409,468,558,404,399,468,407,468,
            412,402,410,408,468,468,411,468,493,413,
            468,468,550,468,538,468,468,505,544,530,
            468,468,415,468,414,500,416,468,417,468,
            468,418,468,420,468,504,421,468,468,468,
            422,468,424,423,468,425,419,468,468,427,
            426,468,468,468,468,431,468,468,468,432,
            488,468,468,519,468,554,433,489,468,428,
            468,429,521,434,435,468,468,430,468,468,
            468,468,441,75,468,440,468,468,436,439,
            445,442,444,468,468,468,446,468,468,443,
            468,437,447,438,512,448,468,449,503,468,
            468,502,450,453,468,468,545,468,455,468,
            508,454,468,468,468,456,468,468,468,548,
            458,468,457,507,468,509,537,468,468,460,
            468,468,462,459,468,468,461,468,499,527,
            79,463,468,468,468,549,506,465,468,468,
            468,468,468,468,468,468,464
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
           NUM_STATES        = 372,
           NT_OFFSET         = 54,
           LA_STATE_OFFSET   = 559,
           MAX_LA            = 1,
           NUM_RULES         = 91,
           NUM_NONTERMINALS  = 3,
           NUM_SYMBOLS       = 57,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 92,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 39,
           EOLT_SYMBOL       = 55,
           ACCEPT_ACTION     = 467,
           ERROR_ACTION      = 468;

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
