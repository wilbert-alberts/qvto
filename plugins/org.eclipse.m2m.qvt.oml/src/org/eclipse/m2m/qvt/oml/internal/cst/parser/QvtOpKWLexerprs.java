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
* $Id: QvtOpKWLexerprs.java,v 1.23 2007/11/29 15:28:16 radvorak Exp $
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
* $Id: QvtOpKWLexerprs.java,v 1.23 2007/11/29 15:28:16 radvorak Exp $
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
            6,4,4,6
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
            1,1,1,1,1,1,98,53,12,166,
            167,18,168,172,84,117,175,185,189,190,
            194,104,45,181,57,39,82,92,103,106,
            34,66,96,114,47,71,177,196,198,199,
            200,202,22,204,118,203,208,211,125,74,
            209,126,218,210,219,220,212,224,131,225,
            226,234,75,235,238,239,240,243,228,245,
            244,249,252,253,254,101,132,128,255,136,
            145,256,265,257,102,262,268,269,272,260,
            273,275,279,280,285,278,284,149,291,293,
            294,296,299,302,304,147,300,307,310,311,
            312,43,313,317,318,315,323,325,327,328,
            326,333,330,331,140,338,341,339,345,343,
            347,348,356,358,359,362,363,364,365,151,
            368,369,349,370,375,378,160,374,382,379,
            384,385,386,391,395,397,387,389,399,400,
            402,408,401,410,409,413,414,422,423,426,
            427,428,431,434,437,438,441,442,411,444,
            446,447,449,450,448,458,460,463,452,464,
            467,468,469,470,478,480,466,481,483,485,
            487,488,489,490,492,497,498,500,504,506,
            494,509,512,511,515,516,517,518,520,522,
            523,521,528,529,530,535,540,541,538,32,
            544,542,545,547,552,549,553,555,560,563,
            556,564,568,569,570,572,571,580,575,576,
            583,584,585,587,588,591,598,600,601,602,
            604,605,606,607,611,610,615,618,619,621,
            625,623,627,629,634,628,635,641,631,644,
            642,646,647,429,649,652,654,656,162,650,
            659,661,662,52,667,669,660,163,671,663,
            673,675,681,684,677,688,691,689,694,697,
            695,700,701,702,706,707,710,703,713,716,
            717,719,722,724,726,729,730,731,732,734,
            735,736,739,738,743,744,749,752,756,742,
            757,758,759,763,760,764,768,767,771,775,
            778,779,782,781,788,789,791,164,795,769,
            792,802,804,796,806,808,810,811,813,800,
            818,819,822,820,824,826,828,829,831,835,
            833,838,474,474
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,0,12,13,14,0,16,0,18,19,
            20,0,22,23,24,8,5,27,28,29,
            30,0,32,0,34,14,3,37,0,1,
            2,8,0,10,0,12,0,16,2,3,
            39,0,8,20,10,9,0,26,16,13,
            29,30,6,7,18,0,35,25,3,4,
            0,1,2,0,0,10,3,7,36,28,
            38,0,9,0,1,20,13,6,7,6,
            7,0,1,23,20,0,5,6,3,4,
            0,0,0,0,31,0,5,4,7,7,
            7,11,7,0,12,15,0,0,1,24,
            19,8,5,18,0,0,2,0,3,4,
            0,0,2,2,21,0,5,21,11,0,
            13,6,0,19,0,1,0,12,0,5,
            0,3,22,7,4,16,8,7,12,0,
            1,0,0,0,25,0,0,0,7,4,
            7,0,13,6,0,9,0,16,0,16,
            0,19,6,12,0,1,12,7,0,0,
            28,3,3,0,1,0,1,0,0,0,
            1,0,0,0,7,2,8,0,0,0,
            0,0,11,6,4,7,14,0,0,0,
            11,4,4,0,0,0,7,0,17,4,
            0,8,8,0,0,2,2,0,0,0,
            2,4,0,0,0,6,2,4,0,1,
            8,0,0,0,0,0,0,4,31,0,
            9,0,10,9,0,1,5,0,0,10,
            14,0,0,6,0,4,8,0,0,0,
            1,9,0,0,0,30,8,3,14,6,
            0,14,0,0,4,0,4,4,0,0,
            5,0,1,0,6,6,0,1,5,0,
            0,0,0,1,0,4,0,0,9,5,
            4,4,0,13,0,0,0,0,1,0,
            0,1,0,8,12,9,4,0,0,2,
            0,1,0,14,0,1,0,0,0,25,
            2,9,5,7,16,0,1,0,0,1,
            3,0,0,0,0,3,3,0,0,0,
            9,2,8,0,0,8,2,0,0,2,
            12,0,1,0,0,0,0,4,0,5,
            0,1,4,15,0,1,0,1,0,0,
            0,0,3,18,18,4,33,0,0,0,
            0,4,0,0,1,17,6,5,18,10,
            12,0,0,1,3,0,0,0,0,3,
            0,1,7,0,1,8,0,0,1,3,
            0,0,1,0,4,0,0,0,0,0,
            3,0,24,10,9,9,8,0,9,0,
            3,2,0,0,13,0,0,0,0,0,
            8,5,9,6,5,10,8,0,1,0,
            0,2,0,1,0,5,0,0,0,0,
            2,0,3,0,10,8,0,0,7,0,
            1,5,5,0,1,0,20,2,0,1,
            0,0,19,2,0,0,0,0,8,0,
            0,0,0,1,5,10,9,0,0,0,
            10,17,3,6,0,19,15,0,4,0,
            0,0,2,0,0,17,0,8,0,6,
            9,0,0,9,0,0,1,11,10,0,
            9,2,0,0,2,13,29,0,0,0,
            0,0,9,2,0,0,22,7,10,0,
            11,2,0,0,0,2,0,0,21,15,
            0,1,17,11,8,11,9,0,1,0,
            0,0,2,0,0,0,0,6,2,0,
            0,12,9,3,0,11,11,0,0,10,
            0,3,0,3,0,1,0,0,0,15,
            0,5,15,0,0,2,9,15,10,5,
            0,0,12,0,1,0,0,7,0,0,
            9,0,7,0,1,0,1,8,0,0,
            0,0,0,15,4,14,0,6,0,1,
            0,5,0,14,0,0,0,3,32,3,
            0,11,2,0,26,23,14,0,0,6,
            0,1,4,0,0,8,0,1,4,0,
            0,0,0,3,3,0,0,1,15,0,
            11,6,0,1,5,0,0,1,0,17,
            2,0,7,0,1,0,1,6,0,0,
            0,0,3,0,0,0,1,0,0,11,
            2,0,0,0,1,4,9,17,0,18,
            2,0,19,11,3,0,0,0,0,0,
            26,6,0,0,1,6,0,0,0,13,
            0,3,10,6,0,5,2,0,0,2,
            0,0,16,5,27,27,5,0,0,1,
            0,0,2,13,0,0,2,0,7,0,
            13,0,1,0,1,0,11,0,3,0,
            0,12,0,3,5,3,9,0,0,0,
            3,0,1,0,1,0,7,0,0,11,
            0,3,0,8,0,3,0,0,11,0,
            6,4,0,0,0,0,16,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            474,122,123,118,117,124,121,120,110,125,
            111,474,100,116,101,474,109,474,104,102,
            99,474,103,105,119,128,184,112,115,106,
            108,474,114,474,113,185,161,107,474,148,
            147,482,474,160,474,159,474,358,172,174,
            473,474,143,158,142,171,474,360,257,477,
            361,359,146,145,173,474,362,260,165,164,
            474,178,176,474,474,163,196,177,258,408,
            259,474,195,474,133,162,194,150,149,132,
            131,474,153,175,210,474,152,151,167,168,
            474,13,474,474,197,474,232,140,231,155,
            141,481,157,474,154,499,474,474,187,166,
            230,169,188,156,474,474,193,474,199,200,
            474,474,490,218,170,474,219,134,221,474,
            220,223,474,192,474,226,474,224,474,225,
            474,540,206,251,283,271,243,282,250,474,
            289,73,474,77,270,474,474,474,403,126,
            458,474,475,129,474,127,474,402,474,457,
            474,412,179,130,474,136,135,144,474,474,
            411,137,138,474,139,474,180,474,474,474,
            182,474,474,474,181,186,541,474,474,474,
            474,474,183,190,191,198,189,474,474,474,
            202,201,203,474,474,474,204,474,491,208,
            474,205,207,474,474,209,486,474,474,474,
            484,211,474,474,474,212,530,214,474,500,
            483,474,474,474,474,474,474,217,213,474,
            215,474,216,222,474,228,233,474,474,237,
            229,474,474,234,474,236,235,70,474,474,
            240,556,474,474,474,227,239,566,238,242,
            474,241,474,474,244,474,245,518,474,474,
            246,474,248,474,247,252,474,253,249,474,
            474,474,474,261,474,256,474,474,254,264,
            262,263,474,255,474,474,474,474,546,474,
            474,269,474,268,265,267,525,474,474,272,
            474,273,474,545,474,275,474,54,474,266,
            476,276,278,277,274,474,479,474,474,488,
            279,474,474,474,474,478,280,474,474,474,
            567,286,281,474,474,284,287,474,474,288,
            285,474,291,474,474,474,474,292,474,293,
            474,557,296,538,474,529,474,520,474,474,
            474,474,298,294,295,299,290,474,474,474,
            474,300,474,474,305,297,316,304,301,302,
            303,474,474,307,306,474,474,474,474,309,
            474,311,308,474,312,310,474,474,314,313,
            474,474,489,474,315,474,474,474,474,474,
            322,474,562,317,318,319,320,474,321,474,
            323,324,474,474,480,474,474,474,474,474,
            325,327,326,328,330,332,329,474,331,474,
            474,539,474,334,474,333,474,474,474,474,
            338,474,339,474,335,337,474,474,340,474,
            343,341,342,474,344,474,336,565,474,536,
            474,474,345,503,474,474,474,474,346,474,
            474,474,474,352,351,348,350,474,474,474,
            353,347,355,354,474,349,521,474,496,474,
            474,474,531,474,474,515,474,356,474,363,
            560,474,474,364,474,474,370,365,366,474,
            497,369,474,474,533,367,357,474,474,474,
            474,474,371,502,474,474,368,373,564,474,
            372,374,474,474,474,377,474,474,568,375,
            474,378,537,376,516,523,558,474,506,474,
            474,474,380,474,474,474,474,381,384,474,
            474,379,382,519,474,522,383,474,474,385,
            474,387,474,388,474,389,474,474,474,534,
            474,391,386,474,474,393,561,390,392,394,
            474,474,396,474,495,474,474,395,474,474,
            485,474,397,474,400,474,401,404,27,474,
            474,474,474,543,406,399,474,407,474,492,
            474,409,474,410,474,474,474,415,398,417,
            474,413,563,474,405,510,414,474,474,416,
            474,498,419,474,474,418,474,555,535,474,
            474,474,474,549,421,474,474,423,505,474,
            420,422,474,426,424,474,474,509,474,425,
            428,474,427,474,430,474,431,429,474,474,
            474,474,433,474,474,474,437,474,474,432,
            438,474,474,474,524,441,439,559,474,434,
            494,474,435,526,493,474,474,474,474,474,
            436,440,474,474,447,446,74,474,474,442,
            474,550,445,448,474,450,451,474,474,452,
            474,474,449,453,443,444,454,474,474,455,
            474,474,456,508,474,474,459,474,460,474,
            507,474,461,474,513,474,512,474,462,474,
            474,465,474,553,463,464,514,474,474,474,
            542,474,466,474,468,474,467,474,474,504,
            78,532,474,469,474,554,474,474,511,474,
            471,517,474,474,474,474,470
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
           LA_STATE_OFFSET   = 568,
           MAX_LA            = 1,
           NUM_RULES         = 94,
           NUM_NONTERMINALS  = 3,
           NUM_SYMBOLS       = 57,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 95,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 39,
           EOLT_SYMBOL       = 55,
           ACCEPT_ACTION     = 473,
           ERROR_ACTION      = 474;

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
