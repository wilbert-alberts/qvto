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
* $Id: QvtOpKWLexerprs.java,v 1.4 2007/08/24 11:30:55 sboyko Exp $
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
* $Id: QvtOpKWLexerprs.java,v 1.4 2007/08/24 11:30:55 sboyko Exp $
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
            6,6
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
            1,1,1,1,96,54,163,165,32,134,
            164,77,166,167,90,171,177,183,12,47,
            112,25,101,105,84,107,81,36,59,71,
            108,42,109,94,181,187,185,189,193,191,
            170,120,194,196,199,122,67,200,123,207,
            198,210,212,213,215,129,216,217,224,219,
            225,228,229,233,234,220,235,236,242,40,
            244,245,125,130,133,246,142,247,251,252,
            256,98,257,258,259,260,261,262,266,269,
            273,271,277,145,280,283,286,281,288,291,
            294,143,295,296,298,299,301,50,303,306,
            309,308,311,314,315,317,319,321,320,327,
            135,329,332,322,335,330,340,341,342,344,
            350,345,352,353,153,354,356,357,358,362,
            363,364,160,367,369,370,371,373,375,377,
            380,382,383,385,386,388,390,395,396,397,
            399,403,405,410,412,414,415,419,423,425,
            426,429,430,416,432,434,435,438,437,436,
            447,449,441,440,452,454,455,456,457,458,
            464,467,469,470,471,473,475,477,481,476,
            480,485,486,489,492,491,496,498,499,501,
            502,503,504,507,505,508,511,514,516,523,
            524,525,527,517,37,530,531,534,536,537,
            538,539,541,549,553,556,545,558,542,550,
            561,564,563,567,568,570,571,575,576,578,
            579,588,584,590,593,591,594,595,597,574,
            601,602,603,604,609,613,608,616,610,619,
            622,625,626,615,628,630,634,635,641,636,
            638,643,644,646,52,648,649,650,651,652,
            653,658,662,156,663,664,665,667,666,672,
            680,675,684,686,687,688,691,689,694,695,
            697,699,706,701,708,710,712,713,715,716,
            719,722,724,726,727,728,730,731,732,734,
            738,737,739,741,742,751,750,752,753,757,
            671,758,759,761,764,762,767,771,768,775,
            772,774,788,777,162,784,790,791,794,798,
            781,800,796,801,804,808,802,810,806,815,
            812,819,821,822,823,824,825,829,827,471,
            471
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
            20,21,22,0,0,25,26,27,28,5,
            6,0,32,33,34,0,0,37,3,0,
            9,0,7,2,3,10,0,12,9,0,
            9,0,16,7,13,20,10,6,0,18,
            24,3,4,27,28,16,0,16,10,3,
            0,35,23,3,4,9,0,1,20,13,
            0,5,6,0,1,36,6,38,5,0,
            1,8,22,0,1,2,30,0,18,6,
            0,1,2,6,0,8,0,0,0,5,
            6,0,6,5,7,7,19,6,12,0,
            1,0,0,2,0,3,4,8,0,0,
            2,2,0,0,0,11,29,8,5,15,
            19,0,0,11,0,13,5,3,6,21,
            16,7,0,12,12,0,4,23,6,0,
            1,0,0,0,0,0,0,6,4,0,
            0,2,13,3,19,12,0,16,12,3,
            0,26,0,1,0,5,0,1,0,1,
            0,7,0,0,29,0,0,0,0,0,
            5,39,4,11,14,6,0,14,11,0,
            4,0,0,4,0,0,0,6,0,0,
            4,7,7,0,0,2,2,0,0,17,
            2,4,0,0,0,0,2,5,20,4,
            7,0,1,0,0,0,0,1,4,30,
            0,0,1,10,9,0,0,0,0,0,
            0,0,6,5,4,0,7,10,0,14,
            0,10,0,1,9,7,0,0,28,0,
            0,5,0,4,14,0,4,0,8,4,
            0,1,5,0,0,0,1,0,0,5,
            0,8,0,1,4,0,9,0,0,4,
            0,13,4,0,0,8,0,1,0,0,
            0,0,12,9,4,7,0,1,0,0,
            2,0,1,14,0,1,23,16,9,0,
            0,0,1,0,0,6,3,3,8,0,
            1,0,0,0,3,0,0,0,2,7,
            7,0,0,0,2,2,0,12,0,0,
            0,14,0,4,0,1,0,1,8,0,
            1,0,0,15,0,0,4,0,3,0,
            18,4,31,4,0,0,0,31,0,18,
            0,17,0,1,0,10,8,3,12,0,
            1,0,18,0,0,0,3,6,0,1,
            5,7,0,1,0,0,1,3,0,0,
            1,0,4,0,0,0,0,0,3,0,
            0,10,9,9,7,9,0,7,0,3,
            2,0,13,0,0,0,0,0,1,5,
            9,8,7,0,8,2,0,1,0,0,
            0,1,0,5,0,0,0,8,2,0,
            0,6,10,3,0,0,1,8,0,1,
            0,0,8,2,20,0,1,0,0,2,
            0,0,0,0,0,7,0,0,1,19,
            0,10,9,0,8,0,0,17,5,15,
            10,19,0,0,0,3,0,4,2,0,
            0,7,17,0,5,0,0,0,0,9,
            0,0,9,27,0,9,11,10,0,0,
            2,13,0,9,2,0,1,0,17,10,
            0,21,0,0,7,2,0,0,6,0,
            0,11,2,0,0,0,3,0,0,1,
            11,15,7,0,17,11,9,0,1,0,
            0,2,0,0,0,12,0,5,2,9,
            0,0,0,0,11,11,3,0,0,0,
            10,3,0,1,0,0,15,15,0,10,
            2,0,15,8,0,0,12,0,1,0,
            9,6,8,0,0,0,2,0,9,6,
            0,1,0,0,1,0,1,0,0,0,
            0,0,0,4,7,5,14,0,1,22,
            8,0,0,0,0,0,0,2,33,3,
            0,0,24,11,0,14,5,26,14,0,
            10,7,3,0,1,0,0,0,0,4,
            0,1,4,0,0,32,0,3,0,3,
            0,15,15,5,11,0,1,0,8,0,
            1,0,0,1,0,0,2,6,0,1,
            5,0,1,0,17,0,0,0,3,0,
            0,0,1,0,11,2,0,0,0,1,
            0,0,2,17,3,18,9,11,19,0,
            0,0,0,4,24,5,0,0,0,1,
            0,0,5,0,13,5,0,0,2,8,
            0,0,2,0,0,8,0,25,2,16,
            0,25,8,0,13,2,13,0,1,0,
            0,11,3,0,1,0,6,0,1,0,
            0,0,3,0,9,0,3,0,8,0,
            3,0,3,12,0,1,11,6,0,1,
            0,0,0,0,0,3,0,7,0,5,
            4,3,11,0,0,0,0,0,0,16,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            471,119,120,115,114,118,117,107,121,123,
            108,471,98,113,122,137,106,138,101,99,
            97,100,116,471,471,109,112,103,105,143,
            142,471,102,111,110,471,471,104,158,471,
            125,471,480,169,171,157,471,156,211,471,
            168,74,353,140,475,155,139,400,471,170,
            355,162,161,356,354,252,471,399,160,192,
            471,357,255,164,165,191,471,130,159,190,
            471,129,128,471,150,253,154,254,148,471,
            133,149,163,471,176,174,193,14,153,175,
            471,145,144,226,471,227,471,471,471,147,
            146,471,152,173,166,172,225,141,151,471,
            183,471,471,189,471,195,196,184,471,471,
            488,214,471,471,471,479,167,215,126,497,
            188,471,471,217,471,216,219,538,246,202,
            266,238,471,220,245,471,278,265,277,471,
            285,78,471,471,471,471,471,455,124,471,
            471,182,472,134,409,127,471,454,132,135,
            471,408,471,136,471,177,471,178,471,179,
            471,539,471,471,131,471,471,471,471,471,
            186,470,187,180,181,194,471,185,198,471,
            197,471,471,199,471,471,471,200,471,471,
            204,201,203,471,471,205,484,471,471,489,
            482,207,471,471,471,471,528,208,206,210,
            481,471,498,471,471,471,471,221,213,209,
            471,471,223,212,218,471,471,471,471,471,
            471,471,228,230,232,471,231,229,471,224,
            71,233,471,235,554,234,471,471,222,471,
            471,237,471,239,236,471,240,471,241,516,
            471,243,242,471,471,471,248,471,471,247,
            471,244,471,256,251,471,249,471,471,257,
            471,250,258,471,471,259,471,544,471,471,
            471,471,260,262,523,263,471,264,471,471,
            267,471,268,543,471,270,261,269,271,471,
            55,471,477,471,471,272,274,476,273,471,
            486,471,471,471,275,471,471,471,474,276,
            279,471,471,471,283,284,471,280,471,471,
            471,281,471,287,471,555,471,527,288,471,
            518,471,471,536,471,471,291,471,293,471,
            289,294,282,295,471,471,471,286,471,290,
            471,292,471,300,471,297,299,301,298,471,
            302,471,296,471,471,471,304,303,471,306,
            311,305,471,307,471,471,309,308,471,471,
            487,471,310,471,471,471,471,471,317,471,
            471,312,313,314,315,316,471,320,471,318,
            319,471,478,471,471,471,471,471,326,323,
            321,322,324,471,325,537,471,327,471,471,
            471,330,471,328,471,471,471,329,333,471,
            471,335,331,334,471,471,338,336,471,339,
            471,471,337,563,332,471,534,471,471,501,
            471,471,471,471,471,341,471,471,347,340,
            471,343,345,471,346,471,471,342,349,519,
            348,344,471,471,471,350,471,494,529,471,
            471,351,513,471,358,471,471,471,471,558,
            471,471,359,352,471,495,360,361,471,471,
            364,362,471,366,531,471,365,471,368,562,
            471,363,471,471,367,500,471,471,370,471,
            471,369,373,471,471,471,517,471,471,374,
            372,371,514,471,535,521,556,471,504,471,
            471,376,471,471,471,375,471,377,380,378,
            471,471,471,471,520,379,383,471,471,471,
            381,384,471,385,471,471,532,382,471,388,
            389,471,386,387,471,471,392,471,493,471,
            559,391,390,471,471,471,394,471,483,393,
            471,473,471,471,397,471,398,471,28,471,
            471,471,471,403,401,404,396,471,490,560,
            406,471,471,471,471,471,471,561,395,412,
            471,471,402,410,471,407,413,405,411,471,
            442,415,414,471,496,471,471,471,471,416,
            471,553,533,471,471,508,471,547,471,418,
            471,541,503,419,417,471,420,471,421,471,
            423,471,471,507,471,471,425,424,471,427,
            426,471,428,471,422,471,471,471,430,471,
            471,471,434,471,429,435,471,471,471,522,
            471,471,492,557,491,431,436,524,432,471,
            471,471,471,438,433,437,471,471,471,444,
            471,471,443,75,439,445,471,471,448,447,
            471,471,449,471,471,450,471,440,453,446,
            471,441,451,471,506,456,505,471,452,471,
            471,510,548,471,458,471,457,471,511,471,
            471,471,459,471,512,471,551,471,460,471,
            461,471,540,462,471,463,502,464,471,465,
            471,471,471,79,471,530,471,466,471,468,
            515,552,509,471,471,471,471,471,471,467
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
           NUM_STATES        = 374,
           NT_OFFSET         = 54,
           LA_STATE_OFFSET   = 563,
           MAX_LA            = 1,
           NUM_RULES         = 92,
           NUM_NONTERMINALS  = 3,
           NUM_SYMBOLS       = 57,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 93,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 39,
           EOLT_SYMBOL       = 55,
           ACCEPT_ACTION     = 470,
           ERROR_ACTION      = 471;

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
