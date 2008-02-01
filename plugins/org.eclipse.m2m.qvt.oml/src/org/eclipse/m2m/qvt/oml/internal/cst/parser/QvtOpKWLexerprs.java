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
* $Id: QvtOpKWLexerprs.java,v 1.29 2008/02/01 10:56:07 aigdalov Exp $
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
* $Id: QvtOpKWLexerprs.java,v 1.29 2008/02/01 10:56:07 aigdalov Exp $
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
            8,8,6,6,4,4,6,7,8,9,
            10,13,16
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
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,107,53,150,12,85,
            53,184,161,93,107,188,105,191,198,136,
            117,18,196,108,125,123,65,128,79,34,
            47,95,23,56,80,197,206,202,204,210,
            208,132,212,215,133,216,218,220,141,36,
            221,144,223,222,225,231,232,234,40,235,
            236,237,239,242,245,246,251,248,256,252,
            258,88,259,262,264,268,60,269,271,142,
            149,145,272,154,163,270,278,276,103,280,
            281,282,283,284,288,285,292,295,302,297,
            298,303,165,304,309,310,312,307,316,320,
            170,319,321,323,324,329,76,330,332,334,
            335,339,340,342,343,345,346,348,349,355,
            356,159,358,361,363,359,367,365,371,373,
            376,380,381,384,385,387,386,172,391,392,
            372,394,397,401,180,393,405,398,407,402,
            409,414,416,418,410,420,412,422,430,431,
            421,423,432,436,437,440,445,441,447,449,
            451,453,456,460,462,463,457,467,468,470,
            472,473,474,476,475,479,485,487,486,490,
            491,492,493,497,494,504,507,502,508,510,
            513,499,515,516,519,521,525,526,529,533,
            535,517,538,540,541,527,543,545,546,548,
            547,555,549,552,557,558,563,566,568,570,
            571,565,48,576,572,579,578,582,585,586,
            587,588,589,595,598,601,592,602,604,603,
            609,608,607,613,617,618,621,624,626,634,
            636,627,623,638,640,641,642,647,648,619,
            643,644,655,650,656,660,661,664,666,667,
            668,669,675,671,673,682,684,680,676,686,
            688,690,693,691,694,171,700,91,697,696,
            698,710,702,712,711,167,717,699,715,718,
            720,719,730,731,734,732,724,738,742,744,
            745,746,747,751,752,754,760,758,755,762,
            766,767,769,770,774,776,779,780,765,781,
            784,785,787,788,791,792,794,797,798,800,
            804,805,807,812,810,811,813,817,818,819,
            821,822,824,834,837,840,841,843,832,844,
            850,846,183,852,825,853,855,858,861,856,
            863,864,868,870,872,871,876,878,877,881,
            884,885,887,889,890,892,894,897,899,900,
            904,906,514,514
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
            20,21,0,23,24,25,9,10,28,29,
            30,9,32,0,34,0,3,37,3,0,
            5,2,9,10,22,12,0,0,13,3,
            4,5,0,0,21,0,10,2,3,0,
            5,9,23,16,0,1,31,21,13,10,
            6,7,8,18,27,0,29,30,0,0,
            1,2,35,5,0,7,7,0,10,5,
            0,16,0,1,0,5,18,3,4,7,
            8,26,0,24,0,1,0,0,6,7,
            20,36,6,38,7,8,0,27,31,25,
            4,19,0,7,0,1,2,0,22,7,
            8,0,0,1,7,0,1,6,6,12,
            0,0,2,0,0,14,3,4,0,0,
            2,0,11,0,6,11,15,13,0,19,
            0,8,0,1,0,12,0,3,6,0,
            0,0,12,9,16,4,7,7,7,0,
            1,12,0,0,26,19,16,0,39,7,
            0,8,13,3,28,0,0,0,16,12,
            3,0,7,0,8,0,1,0,7,0,
            1,0,9,2,0,0,2,0,11,0,
            0,0,0,4,0,8,4,7,4,14,
            0,0,11,0,0,0,0,7,0,4,
            2,0,9,9,0,0,2,0,17,4,
            0,0,2,17,7,0,1,0,0,8,
            2,0,21,0,1,4,9,0,0,0,
            0,0,5,5,4,0,5,0,1,0,
            0,0,0,0,0,6,4,0,8,14,
            9,0,5,10,0,1,0,0,14,30,
            9,0,0,0,3,8,0,4,0,0,
            14,0,4,4,8,0,1,6,0,0,
            0,1,0,0,22,6,8,5,0,0,
            1,0,4,0,0,4,13,4,0,0,
            6,0,0,1,0,0,5,0,0,4,
            12,4,4,9,0,0,1,0,0,2,
            0,1,0,1,0,26,0,1,14,5,
            0,0,0,2,16,0,1,7,6,0,
            0,1,3,0,0,0,0,3,5,3,
            0,0,0,0,9,2,0,0,2,9,
            0,0,2,12,0,1,0,6,0,0,
            4,0,15,0,1,0,1,0,1,0,
            0,0,0,4,3,33,18,18,17,0,
            0,0,10,4,4,0,0,1,18,0,
            0,6,3,12,0,1,0,7,0,3,
            0,1,0,1,0,0,0,9,3,0,
            1,0,0,1,8,4,0,0,1,0,
            4,0,0,0,0,0,5,5,0,10,
            5,3,9,9,0,0,0,3,2,0,
            0,0,0,0,9,5,0,6,0,6,
            8,0,13,0,1,9,0,0,2,0,
            1,10,0,6,0,0,0,2,0,21,
            0,3,10,9,0,0,0,7,0,1,
            6,6,0,1,0,19,2,0,1,0,
            0,2,0,17,0,0,0,0,0,9,
            5,0,10,6,0,1,0,0,10,8,
            3,15,0,19,0,0,4,0,1,0,
            0,0,2,17,9,0,5,0,0,10,
            2,0,5,8,0,0,0,0,0,5,
            2,0,11,29,0,10,2,0,1,13,
            0,0,0,0,2,5,0,0,0,2,
            23,10,0,22,11,7,0,0,0,2,
            0,15,0,0,2,0,0,11,10,17,
            5,11,9,0,1,0,1,0,12,0,
            0,0,0,0,5,8,0,0,2,0,
            3,11,11,10,0,0,2,15,3,0,
            0,1,3,0,15,0,0,0,0,2,
            0,6,0,5,0,0,10,7,15,0,
            6,0,1,0,12,0,7,0,5,0,
            0,1,0,0,1,0,0,0,0,0,
            4,0,1,8,15,20,14,32,9,0,
            0,0,25,2,0,6,0,0,0,0,
            3,2,24,0,14,28,8,11,14,0,
            0,0,3,0,1,4,0,0,15,9,
            3,0,1,0,0,0,0,4,3,3,
            0,0,1,0,0,11,3,0,8,0,
            1,0,1,6,0,0,0,1,0,0,
            2,17,7,0,1,0,1,8,0,0,
            0,17,3,0,0,1,0,0,1,11,
            0,0,2,0,1,4,0,0,18,0,
            1,5,19,0,0,2,0,3,11,0,
            0,0,0,27,8,4,0,0,0,1,
            0,0,13,0,0,8,10,3,8,6,
            20,0,20,0,1,0,0,16,2,0,
            0,2,0,0,13,0,6,2,6,0,
            1,0,0,2,0,0,13,0,1,7,
            0,1,0,0,10,3,11,0,5,0,
            0,0,3,6,3,0,0,0,3,2,
            0,1,12,0,0,1,0,11,0,0,
            7,0,0,0,3,9,0,0,0,0,
            11,3,3,0,8,0,1,4,20,16,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            514,131,132,127,126,134,133,129,130,119,
            120,514,109,125,110,135,118,514,113,111,
            121,108,514,112,114,128,153,152,124,115,
            117,183,123,514,122,514,174,116,211,514,
            210,530,522,173,184,172,514,514,209,179,
            178,177,514,514,171,514,176,186,188,514,
            185,137,221,384,514,164,212,175,517,233,
            163,161,162,187,386,514,387,385,514,514,
            192,190,388,168,514,170,191,514,167,136,
            27,275,514,142,514,434,169,181,182,140,
            141,278,13,189,514,146,514,514,250,249,
            435,276,143,277,155,156,514,436,230,180,
            150,248,514,151,514,158,157,514,144,159,
            160,514,514,202,166,514,149,198,203,165,
            514,514,208,514,514,199,214,215,514,514,
            236,514,521,514,237,239,539,238,514,207,
            514,241,514,244,514,242,514,580,243,514,
            76,514,139,261,291,304,269,432,303,514,
            310,268,80,514,290,443,431,514,513,494,
            514,138,515,147,442,514,514,514,493,145,
            148,514,154,514,193,514,194,514,195,514,
            196,514,581,200,514,514,201,514,197,514,
            514,514,514,206,514,205,216,213,218,204,
            514,514,217,514,514,514,514,219,514,223,
            224,514,220,222,514,514,526,514,531,226,
            514,514,524,587,227,514,228,514,514,229,
            570,514,225,514,540,231,523,514,514,514,
            514,514,232,234,235,514,240,514,246,514,
            514,514,514,514,514,251,254,514,252,247,
            253,514,599,255,514,258,70,514,256,245,
            257,514,514,514,609,260,514,262,514,514,
            259,514,263,558,265,514,266,264,514,514,
            514,271,514,514,589,267,270,272,514,514,
            279,514,274,514,514,280,273,281,514,514,
            282,514,514,586,514,514,285,514,514,565,
            283,287,288,286,514,514,289,514,514,292,
            514,293,514,294,514,284,514,296,585,297,
            514,514,54,516,295,514,519,298,299,514,
            514,528,300,514,514,514,514,518,610,301,
            514,514,514,514,302,307,514,514,308,305,
            514,514,309,306,514,312,514,314,514,514,
            313,514,578,514,600,514,569,514,560,514,
            514,514,514,317,319,311,315,316,318,514,
            514,514,323,320,321,514,514,326,322,514,
            514,325,327,324,514,328,514,329,514,330,
            514,332,514,333,514,514,514,331,334,514,
            335,514,514,529,337,336,514,514,339,514,
            338,514,514,514,514,514,341,342,514,340,
            344,346,343,345,514,514,514,347,348,514,
            514,514,514,514,349,350,514,351,514,354,
            352,514,520,514,355,353,514,514,579,514,
            358,356,514,357,514,514,514,362,514,360,
            514,363,359,361,514,514,514,364,514,367,
            365,366,514,368,514,369,608,514,576,514,
            514,543,514,371,514,514,514,514,514,370,
            374,514,372,375,514,376,514,514,377,378,
            379,561,514,373,514,514,536,514,381,514,
            514,514,571,555,380,514,603,514,514,382,
            588,514,390,389,514,514,514,514,514,537,
            395,514,391,383,514,392,573,514,396,393,
            514,514,514,514,399,397,514,514,514,401,
            394,607,514,611,398,400,514,514,514,404,
            514,402,514,514,407,514,514,403,412,577,
            601,563,556,514,405,514,546,514,406,514,
            514,514,514,514,409,408,514,514,411,514,
            559,562,410,413,514,514,612,574,415,514,
            514,417,416,514,414,514,514,514,514,421,
            514,419,514,604,514,514,420,423,418,514,
            422,514,535,514,424,28,425,514,525,514,
            514,429,514,514,430,514,514,514,514,514,
            437,514,532,438,583,427,428,426,433,514,
            514,514,605,613,514,440,514,514,514,514,
            446,606,550,514,441,439,447,444,445,514,
            514,514,448,514,538,450,514,514,545,449,
            451,514,598,514,514,514,514,575,592,453,
            514,514,455,514,514,452,456,514,454,514,
            457,514,460,458,514,514,514,549,514,514,
            462,459,461,514,464,514,465,463,514,514,
            514,602,467,514,514,614,514,514,471,466,
            514,514,472,514,615,473,514,514,468,514,
            564,474,469,514,514,534,514,533,566,514,
            514,514,514,470,475,476,514,514,514,482,
            514,77,477,514,514,481,480,593,483,485,
            478,514,479,514,486,514,514,484,487,514,
            514,488,514,514,548,514,489,492,490,514,
            491,514,514,495,514,514,547,514,498,496,
            514,553,514,514,497,499,552,514,554,514,
            514,514,596,500,501,514,514,514,582,503,
            514,504,502,514,514,506,514,544,102,514,
            505,514,514,81,572,507,514,514,514,514,
            551,511,597,514,510,514,617,557,508,509
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
           NUM_STATES        = 406,
           NT_OFFSET         = 54,
           LA_STATE_OFFSET   = 617,
           MAX_LA            = 1,
           NUM_RULES         = 103,
           NUM_NONTERMINALS  = 3,
           NUM_SYMBOLS       = 57,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 104,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 39,
           EOLT_SYMBOL       = 55,
           ACCEPT_ACTION     = 513,
           ERROR_ACTION      = 514;

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
