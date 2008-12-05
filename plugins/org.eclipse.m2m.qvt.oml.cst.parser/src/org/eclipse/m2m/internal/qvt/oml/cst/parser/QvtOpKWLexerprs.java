/**
* <copyright>
*
* Copyright (c) 2005, 2007 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
*
* </copyright>
*
* $Id: QvtOpKWLexerprs.java,v 1.31 2008/12/05 12:43:33 aigdalov Exp $
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
* $Id: QvtOpKWLexerprs.java,v 1.31 2008/12/05 12:43:33 aigdalov Exp $
*/

package org.eclipse.m2m.internal.qvt.oml.cst.parser;

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
            9,9,6,8,6,6,7,5,6,5,
            4,3,13,10,12,8,5,3,4,3,
            4,3,6,4,7,10,9,12,10,13,
            12,15,9,4,5,7,6,7,8,8,
            6,6,4,4,6,4,7,8,9,10,
            13,16,7,6,7,4,4,5,8,11,
            8,8,7,7,2,4,4,6,9,4,
            7,7,9,5,8,10,3,3,7,9,
            7
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
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,145,53,18,76,172,161,167,
            29,249,247,257,85,114,171,258,265,268,
            272,180,122,174,267,188,198,126,101,140,
            81,45,56,142,104,68,49,190,63,273,
            277,278,279,185,281,282,286,287,193,259,
            289,285,202,130,297,204,292,293,298,160,
            302,40,301,203,113,304,308,310,311,119,
            313,209,314,316,312,318,325,214,326,322,
            329,330,331,336,339,333,220,342,338,347,
            349,350,351,352,354,17,144,213,103,353,
            355,143,217,357,362,364,75,365,367,368,
            370,371,378,379,381,383,384,382,385,389,
            392,394,395,393,396,404,406,408,409,410,
            412,413,219,415,416,418,425,417,430,426,
            434,228,226,435,436,437,439,441,443,444,
            151,446,98,452,450,454,456,458,461,156,
            462,463,465,467,469,472,473,471,479,25,
            481,483,486,488,490,491,493,495,496,498,
            499,503,505,497,507,510,512,514,518,237,
            223,519,521,522,525,528,529,532,239,524,
            535,536,537,538,540,542,544,546,547,548,
            549,552,554,562,553,565,569,571,573,574,
            575,576,578,581,580,585,586,582,593,584,
            596,595,243,599,598,604,605,609,610,613,
            614,615,618,620,624,625,628,629,630,632,
            634,637,638,639,641,646,647,648,649,654,
            650,659,655,661,663,666,667,669,670,672,
            673,682,671,683,677,687,688,690,691,692,
            694,697,698,699,703,705,706,707,710,709,
            713,718,721,717,722,726,728,733,735,736,
            739,727,741,742,744,746,745,749,750,751,
            756,757,758,760,761,762,763,769,765,773,
            771,781,776,772,785,786,783,794,787,796,
            789,69,799,801,803,802,805,810,806,807,
            814,816,818,820,821,824,827,826,829,833,
            828,835,836,838,841,849,842,852,853,856,
            857,858,860,861,862,863,864,865,872,834,
            875,881,868,882,884,888,886,890,891,892,
            893,895,896,897,904,909,905,899,911,910,
            913,918,914,921,922,927,917,931,929,932,
            934,937,938,939,943,945,946,948,949,950,
            955,961,951,958,962,964,967,966,968,969,
            971,974,975,977,980,981,241,983,992,990,
            986,158,997,998,616,995,1003,1006,1001,233,
            1007,1009,1010,1012,1011,1017,1016,1019,1020,1026,
            1022,1028,1029,1035,1030,1036,1039,1040,1042,1044,
            1047,1050,1052,1053,1057,1054,1062,1064,1065,1068,
            1060,1069,1071,1073,1076,1075,1083,1085,1079,1088,
            1089,1081,1087,1093,1094,1098,1099,1100,1102,1104,
            1107,1110,1111,1108,1117,1118,1120,1121,1116,1125,
            1126,1129,1131,1132,1134,1135,1137,1138,1139,1143,
            1149,1146,1154,1155,1159,1160,1148,1161,1165,1167,
            245,1168,1171,1174,1172,1176,1178,1182,1180,1184,
            1188,1185,1190,1192,1196,1198,1199,1201,1200,1204,
            1206,1207,1209,1212,1213,1216,1218,1214,1220,1222,
            1226,1227,694,694
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,14,15,0,0,18,19,
            20,21,22,23,0,25,26,11,0,29,
            30,31,16,33,34,35,8,9,38,0,
            40,2,3,19,0,6,7,3,0,1,
            2,27,8,14,10,0,12,9,3,42,
            5,6,0,24,0,10,22,0,0,2,
            3,23,10,6,0,0,2,22,4,4,
            0,14,15,9,0,1,6,19,4,9,
            10,7,18,9,20,15,28,0,30,31,
            0,1,0,0,4,37,4,7,6,9,
            7,8,0,0,1,3,19,5,0,16,
            7,0,9,20,27,0,5,15,7,0,
            9,2,7,8,9,17,39,8,41,0,
            1,0,0,0,3,2,5,4,9,7,
            0,12,2,10,12,0,6,0,16,0,
            0,2,0,6,14,5,0,26,8,3,
            0,0,6,0,4,4,21,18,21,0,
            1,8,27,10,0,28,7,0,4,0,
            20,36,0,9,7,6,9,0,1,2,
            8,0,0,0,1,4,14,4,0,7,
            2,9,0,0,13,2,0,1,0,0,
            4,3,0,11,12,0,8,0,1,7,
            8,4,0,25,9,22,0,12,0,1,
            0,5,0,24,0,9,0,1,0,9,
            18,9,14,9,12,7,0,0,0,19,
            2,29,0,19,0,1,0,0,12,12,
            3,0,0,1,3,9,0,0,0,1,
            0,0,5,7,0,0,0,1,0,8,
            5,0,0,13,6,11,0,0,2,7,
            0,0,5,0,13,4,6,0,5,0,
            0,0,0,0,5,0,5,0,11,9,
            8,0,9,8,0,0,2,2,0,0,
            0,2,0,5,17,0,1,0,0,9,
            8,0,5,2,23,7,0,1,0,0,
            0,0,0,0,0,6,0,6,5,11,
            10,0,1,0,0,13,0,0,4,0,
            0,17,2,7,5,8,13,0,0,2,
            0,0,0,0,0,7,4,31,0,6,
            10,0,0,0,0,0,15,13,4,7,
            12,8,7,0,13,0,1,0,0,0,
            3,0,0,0,0,0,0,0,7,5,
            5,13,5,7,0,0,17,24,4,0,
            1,6,20,0,0,0,0,1,0,1,
            0,7,0,0,11,0,6,12,6,0,
            5,0,1,0,5,0,13,0,5,4,
            0,0,0,1,0,1,0,6,0,12,
            0,0,0,5,8,15,5,5,0,1,
            0,1,0,13,2,0,1,0,1,0,
            0,1,0,1,0,0,0,0,0,3,
            6,4,0,1,0,1,0,1,19,0,
            15,0,14,0,3,6,3,0,0,1,
            0,0,1,0,0,8,2,0,0,2,
            2,0,12,2,0,0,0,0,1,0,
            4,0,1,0,5,0,0,0,0,2,
            15,0,0,0,0,32,5,4,12,16,
            12,0,1,18,0,1,32,15,0,1,
            0,1,0,0,0,0,1,0,5,0,
            0,0,3,0,0,0,9,15,8,5,
            5,17,0,10,0,0,15,0,0,2,
            8,6,4,0,0,1,12,4,0,0,
            1,3,0,0,0,0,3,0,1,0,
            1,9,8,0,0,1,3,0,0,0,
            3,0,1,0,5,7,0,0,0,1,
            0,8,5,7,29,0,0,0,0,0,
            10,6,6,0,0,8,8,8,0,6,
            0,3,0,3,2,0,0,13,0,0,
            0,0,0,4,6,5,0,11,7,14,
            8,0,0,1,8,4,0,0,2,0,
            0,0,1,0,4,8,0,0,0,10,
            2,4,0,10,0,0,0,1,0,0,
            8,7,0,8,5,3,0,0,22,2,
            0,0,6,3,16,0,0,0,2,4,
            9,4,0,1,0,0,1,3,0,1,
            0,0,1,0,0,0,3,2,0,0,
            0,2,8,3,6,0,0,0,18,0,
            0,0,0,8,0,4,6,10,0,1,
            0,0,0,17,10,0,1,18,16,7,
            0,10,0,3,0,0,0,17,0,5,
            8,0,7,0,1,0,10,2,0,1,
            0,0,0,2,0,0,0,7,6,0,
            6,2,6,0,1,0,11,0,30,0,
            0,2,2,0,1,0,0,0,0,14,
            4,6,0,0,0,0,4,0,5,2,
            0,0,25,15,10,4,11,20,0,9,
            2,0,0,2,2,0,0,0,2,0,
            0,0,0,0,0,2,11,0,1,10,
            13,0,0,11,0,11,16,3,17,8,
            0,0,1,0,1,0,6,0,1,0,
            0,0,0,2,0,0,0,12,0,7,
            6,12,12,0,0,2,11,11,0,0,
            0,3,0,0,10,5,0,0,20,2,
            0,0,10,3,3,16,0,1,0,16,
            0,0,16,0,4,2,0,0,0,11,
            4,10,0,6,0,0,1,0,0,0,
            0,9,14,6,0,1,12,0,9,11,
            0,0,2,0,1,0,0,0,0,1,
            0,4,2,0,0,1,0,1,21,0,
            0,16,0,33,18,0,13,26,6,0,
            10,0,1,8,0,16,0,0,4,10,
            0,5,0,1,7,0,0,2,0,0,
            0,0,2,13,3,0,0,11,0,0,
            1,0,13,7,9,0,8,0,0,0,
            5,23,11,6,0,0,1,3,0,0,
            11,0,1,0,16,6,0,9,5,0,
            1,0,0,0,3,3,0,11,2,0,
            7,0,1,0,0,1,3,0,0,1,
            0,4,0,1,0,0,17,2,0,9,
            0,7,0,1,0,1,0,0,0,11,
            3,3,0,0,1,15,4,0,0,0,
            3,0,1,0,18,6,0,0,2,0,
            0,1,9,6,5,0,0,0,1,0,
            0,2,7,3,0,0,28,11,0,5,
            0,0,0,0,0,1,0,0,0,14,
            7,10,0,7,7,0,1,0,0,21,
            8,21,4,0,0,2,2,19,0,0,
            0,14,4,4,0,1,0,0,2,2,
            0,0,2,0,14,0,3,0,1,0,
            9,0,1,0,0,10,3,0,4,0,
            11,0,3,6,3,0,1,0,0,0,
            0,3,2,0,1,0,0,1,0,12,
            11,0,0,0,9,0,8,0,3,0,
            7,0,3,11,3,0,0,1,0,0,
            5,0,21,0,0,0,19,0,0,0,
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
            694,173,174,169,175,168,176,172,161,171,
            162,154,149,150,167,155,694,694,151,160,
            152,163,148,156,694,153,170,701,694,166,
            157,159,719,165,164,147,183,184,146,694,
            158,284,283,396,694,282,280,229,694,250,
            248,395,230,281,228,694,227,249,235,693,
            234,233,694,285,694,232,226,694,694,244,
            246,247,252,243,13,694,331,231,334,177,
            694,697,245,332,694,188,223,533,190,225,
            222,189,330,819,333,224,535,694,536,534,
            694,218,694,694,217,537,320,216,321,215,
            240,241,694,694,193,290,377,291,694,239,
            192,694,191,242,380,694,203,289,202,694,
            204,270,214,212,213,711,378,269,379,694,
            219,694,694,694,237,316,238,317,221,323,
            694,220,373,315,324,694,374,27,832,694,
            694,278,694,606,375,180,694,236,179,181,
            694,694,182,694,194,178,386,277,607,694,
            201,206,388,205,694,608,200,694,257,694,
            195,387,694,258,209,251,208,694,211,210,
            262,694,694,694,272,267,263,273,694,287,
            710,288,694,694,268,302,694,326,694,694,
            325,765,694,319,318,694,355,694,363,412,
            413,364,694,297,366,303,694,365,694,420,
            85,411,694,308,89,410,694,186,694,603,
            615,447,695,673,448,185,694,694,694,602,
            264,614,694,672,694,197,694,694,187,196,
            198,694,694,253,199,207,694,694,694,256,
            694,694,255,254,694,694,694,261,694,766,
            260,694,694,259,265,266,694,694,271,275,
            694,694,276,694,274,279,286,694,292,694,
            694,694,694,694,294,694,300,694,293,295,
            296,694,298,299,694,694,301,706,694,694,
            694,704,694,304,776,694,306,694,694,305,
            703,694,309,750,774,307,694,720,8,694,
            694,694,694,694,694,311,694,313,314,310,
            312,694,328,694,694,322,694,694,335,694,
            694,831,811,336,338,337,329,694,694,810,
            694,694,694,694,694,339,341,327,694,788,
            340,694,694,694,694,694,342,343,347,348,
            344,346,349,694,345,694,351,694,78,694,
            797,694,694,694,694,694,694,694,354,356,
            357,352,738,359,694,694,353,350,358,694,
            360,361,778,694,694,694,694,369,694,800,
            694,367,694,694,362,694,370,368,371,694,
            376,694,381,694,382,694,372,694,383,384,
            694,694,694,775,694,390,694,389,694,385,
            694,694,694,745,391,824,392,393,694,394,
            694,397,694,773,398,694,399,694,400,694,
            694,402,694,403,694,694,694,54,694,407,
            404,405,694,699,694,406,694,708,401,694,
            821,694,820,694,698,798,408,694,694,414,
            694,694,416,694,694,409,696,694,694,417,
            418,694,415,419,694,694,694,694,424,694,
            423,694,426,694,425,694,694,694,694,429,
            422,694,694,694,694,812,431,432,428,762,
            430,694,433,427,694,789,421,434,694,749,
            694,740,694,694,694,694,828,694,436,694,
            694,694,440,694,694,694,438,435,439,441,
            442,437,694,445,694,694,443,694,694,450,
            444,771,449,694,694,452,446,451,694,694,
            454,453,694,694,694,694,456,694,458,694,
            459,455,457,694,694,461,460,694,694,694,
            462,694,709,694,464,463,694,694,694,468,
            694,465,467,466,611,694,694,694,694,694,
            469,470,471,694,694,472,473,475,694,474,
            694,476,694,478,479,694,694,477,694,694,
            694,694,694,482,481,486,694,480,483,700,
            484,694,694,487,488,485,694,694,764,694,
            694,694,492,694,491,489,694,694,694,490,
            496,495,694,493,694,694,694,499,694,694,
            497,498,694,763,500,502,694,694,494,503,
            694,694,757,504,501,694,694,694,796,506,
            505,507,694,508,694,694,510,509,694,511,
            694,694,760,694,694,694,759,723,694,694,
            694,515,513,516,514,694,694,694,512,694,
            694,694,694,517,694,522,521,519,694,523,
            694,694,694,518,524,694,808,520,741,525,
            694,527,694,526,694,694,694,735,694,716,
            529,694,528,694,530,694,531,751,694,538,
            694,694,694,777,694,694,694,539,791,694,
            540,541,717,694,543,694,542,694,532,694,
            694,546,753,694,547,694,694,694,694,544,
            548,549,694,694,694,694,551,694,564,553,
            694,694,545,550,795,556,552,799,694,554,
            555,694,694,557,558,694,694,694,817,694,
            694,694,694,694,694,563,818,694,566,560,
            559,694,694,562,694,743,561,565,761,736,
            694,694,726,694,567,694,790,694,809,694,
            694,694,694,571,694,694,694,568,694,572,
            573,569,570,694,694,575,742,574,694,694,
            694,739,694,694,576,825,694,694,807,801,
            694,694,577,579,580,754,694,581,694,578,
            694,694,582,694,583,585,128,694,694,826,
            586,584,694,792,694,694,715,694,694,694,
            694,587,833,705,694,590,588,28,589,835,
            694,694,591,694,594,694,694,694,694,816,
            694,596,597,694,694,599,694,600,593,694,
            694,770,694,592,595,694,598,793,813,694,
            601,694,815,605,694,829,694,694,612,604,
            694,609,694,712,610,694,694,802,694,694,
            694,694,794,613,618,694,694,616,694,694,
            718,694,617,619,620,694,621,694,694,694,
            622,730,623,758,694,694,827,624,694,694,
            834,694,787,694,725,756,694,625,755,694,
            627,694,694,694,781,628,694,626,629,694,
            630,694,631,694,694,633,632,694,694,636,
            694,634,694,729,694,694,635,638,694,637,
            694,639,694,640,694,641,694,694,694,642,
            643,823,694,694,803,644,646,694,694,694,
            768,694,648,694,645,830,694,694,650,694,
            694,804,649,652,651,694,694,694,744,694,
            694,714,653,713,694,694,647,746,694,654,
            694,694,694,694,694,660,694,694,86,655,
            659,658,694,661,662,694,665,694,694,656,
            814,657,664,694,694,666,667,663,694,694,
            694,728,668,669,694,670,694,694,671,674,
            694,694,675,694,727,694,782,694,678,694,
            676,694,733,694,694,677,679,694,680,694,
            732,694,785,734,681,694,769,694,694,694,
            694,767,683,694,684,694,694,686,694,682,
            724,111,694,694,685,694,687,90,752,694,
            690,694,691,731,786,694,694,806,694,694,
            737,694,688,694,694,694,689
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
           NUM_STATES        = 548,
           NT_OFFSET         = 54,
           LA_STATE_OFFSET   = 835,
           MAX_LA            = 1,
           NUM_RULES         = 141,
           NUM_NONTERMINALS  = 3,
           NUM_SYMBOLS       = 57,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 142,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 42,
           EOLT_SYMBOL       = 55,
           ACCEPT_ACTION     = 693,
           ERROR_ACTION      = 694;

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
