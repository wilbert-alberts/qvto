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
* $Id: QvtOpKWLexer.java,v 1.79.4.4 2009/10/29 21:38:32 sboyko Exp $
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
* $Id: QvtOpKWLexer.java,v 1.79.4.4 2009/10/29 21:38:32 sboyko Exp $
*/

package org.eclipse.m2m.internal.qvt.oml.cst.parser;




public class QvtOpKWLexer extends QvtOpKWLexerprs implements QvtOpLPGParsersym
{
    private char[] inputChars;
    private final int keywordKind[] = new int[133 + 1];

    public int[] getKeywordKinds() { return keywordKind; }

    public int lexer(int curtok, int lasttok)
    {
        int current_kind = getKind(inputChars[curtok]),
            act;

        for (act = tAction(START_STATE, current_kind);
             act > NUM_RULES && act < ACCEPT_ACTION;
             act = tAction(act, current_kind))
        {
            curtok++;
            current_kind = (curtok > lasttok
                                   ? Char_EOF
                                   : getKind(inputChars[curtok]));
        }

        if (act > ERROR_ACTION)
        {
            curtok++;
            act -= ERROR_ACTION;
        }

        return keywordKind[act == ERROR_ACTION  || curtok <= lasttok ? 0 : act];
    }

    public void setInputChars(char[] inputChars) { this.inputChars = inputChars; }


    final static int tokenKind[] = new int[128];
    static
    {
        tokenKind['$'] = Char_DollarSign;

        tokenKind['a'] = Char_a;
        tokenKind['b'] = Char_b;
        tokenKind['c'] = Char_c;
        tokenKind['d'] = Char_d;
        tokenKind['e'] = Char_e;
        tokenKind['f'] = Char_f;
        tokenKind['g'] = Char_g;
        tokenKind['h'] = Char_h;
        tokenKind['i'] = Char_i;
        tokenKind['j'] = Char_j;
        tokenKind['k'] = Char_k;
        tokenKind['l'] = Char_l;
        tokenKind['m'] = Char_m;
        tokenKind['n'] = Char_n;
        tokenKind['o'] = Char_o;
        tokenKind['p'] = Char_p;
        tokenKind['q'] = Char_q;
        tokenKind['r'] = Char_r;
        tokenKind['s'] = Char_s;
        tokenKind['t'] = Char_t;
        tokenKind['u'] = Char_u;
        tokenKind['v'] = Char_v;
        tokenKind['w'] = Char_w;
        tokenKind['x'] = Char_x;
        tokenKind['y'] = Char_y;
        tokenKind['z'] = Char_z;

        tokenKind['A'] = Char_A;
        tokenKind['B'] = Char_B;
        tokenKind['C'] = Char_C;
        tokenKind['D'] = Char_D;
        tokenKind['E'] = Char_E;
        tokenKind['F'] = Char_F;
        tokenKind['G'] = Char_G;
        tokenKind['H'] = Char_H;
        tokenKind['I'] = Char_I;
        tokenKind['J'] = Char_J;
        tokenKind['K'] = Char_K;
        tokenKind['L'] = Char_L;
        tokenKind['M'] = Char_M;
        tokenKind['N'] = Char_N;
        tokenKind['O'] = Char_O;
        tokenKind['P'] = Char_P;
        tokenKind['Q'] = Char_Q;
        tokenKind['R'] = Char_R;
        tokenKind['S'] = Char_S;
        tokenKind['T'] = Char_T;
        tokenKind['U'] = Char_U;
        tokenKind['V'] = Char_V;
        tokenKind['W'] = Char_W;
        tokenKind['X'] = Char_X;
        tokenKind['Y'] = Char_Y;
        tokenKind['Z'] = Char_Z;
    };

    final int getKind(char c)
    {
        return (c < 128 ? tokenKind[c] : 0);
    }


    public QvtOpKWLexer(char[] inputChars, int identifierKind)
    {
        this.inputChars = inputChars;
        keywordKind[0] = identifierKind;

        //
        // Rule 1:  KeyWord ::= s e l f
        //
		keywordKind[1] = (TK_self);
	  
	
        //
        // Rule 2:  KeyWord ::= i f
        //
		keywordKind[2] = (TK_if);
	  
	
        //
        // Rule 3:  KeyWord ::= t h e n
        //
		keywordKind[3] = (TK_then);
	  
	
        //
        // Rule 4:  KeyWord ::= e l s e
        //
		keywordKind[4] = (TK_else);
	  
	
        //
        // Rule 5:  KeyWord ::= e n d i f
        //
		keywordKind[5] = (TK_endif);
	  
	
        //
        // Rule 6:  KeyWord ::= a n d
        //
		keywordKind[6] = (TK_and);
	  
	
        //
        // Rule 7:  KeyWord ::= o r
        //
		keywordKind[7] = (TK_or);
	  
	
        //
        // Rule 8:  KeyWord ::= x o r
        //
		keywordKind[8] = (TK_xor);
	  
	
        //
        // Rule 9:  KeyWord ::= n o t
        //
		keywordKind[9] = (TK_not);
	  
	
        //
        // Rule 10:  KeyWord ::= i m p l i e s
        //
		keywordKind[10] = (TK_implies);
	  
	
        //
        // Rule 11:  KeyWord ::= l e t
        //
		keywordKind[11] = (TK_let);
	  
	
        //
        // Rule 12:  KeyWord ::= i n
        //
		keywordKind[12] = (TK_in);
	  
	
        //
        // Rule 13:  KeyWord ::= t r u e
        //
		keywordKind[13] = (TK_true);
	  
	
        //
        // Rule 14:  KeyWord ::= f a l s e
        //
		keywordKind[14] = (TK_false);
	  
	
        //
        // Rule 15:  KeyWord ::= S e t
        //
		keywordKind[15] = (TK_Set);
	  
	
        //
        // Rule 16:  KeyWord ::= B a g
        //
		keywordKind[16] = (TK_Bag);
	  
	
        //
        // Rule 17:  KeyWord ::= S e q u e n c e
        //
		keywordKind[17] = (TK_Sequence);
	  
	
        //
        // Rule 18:  KeyWord ::= C o l l e c t i o n
        //
		keywordKind[18] = (TK_Collection);
	  
	
        //
        // Rule 19:  KeyWord ::= O r d e r e d S e t
        //
		keywordKind[19] = (TK_OrderedSet);
	  
	
        //
        // Rule 20:  KeyWord ::= i t e r a t e
        //
		keywordKind[20] = (TK_iterate);
	  
	
        //
        // Rule 21:  KeyWord ::= f o r A l l
        //
		keywordKind[21] = (TK_forAll);
	  
	
        //
        // Rule 22:  KeyWord ::= e x i s t s
        //
		keywordKind[22] = (TK_exists);
	  
	
        //
        // Rule 23:  KeyWord ::= i s U n i q u e
        //
		keywordKind[23] = (TK_isUnique);
	  
	
        //
        // Rule 24:  KeyWord ::= a n y
        //
		keywordKind[24] = (TK_any);
	  
	
        //
        // Rule 25:  KeyWord ::= o n e
        //
		keywordKind[25] = (TK_one);
	  
	
        //
        // Rule 26:  KeyWord ::= c o l l e c t
        //
		keywordKind[26] = (TK_collect);
	  
	
        //
        // Rule 27:  KeyWord ::= s e l e c t
        //
		keywordKind[27] = (TK_select);
	  
	
        //
        // Rule 28:  KeyWord ::= r e j e c t
        //
		keywordKind[28] = (TK_reject);
	  
	
        //
        // Rule 29:  KeyWord ::= c o l l e c t N e s t e d
        //
		keywordKind[29] = (TK_collectNested);
	  
	
        //
        // Rule 30:  KeyWord ::= s o r t e d B y
        //
		keywordKind[30] = (TK_sortedBy);
	  
	
        //
        // Rule 31:  KeyWord ::= c l o s u r e
        //
		keywordKind[31] = (TK_closure);
	  
	
        //
        // Rule 32:  KeyWord ::= S t r i n g
        //
		keywordKind[32] = (TK_String);
	  
	
        //
        // Rule 33:  KeyWord ::= I n t e g e r
        //
		keywordKind[33] = (TK_Integer);
	  
	
        //
        // Rule 34:  KeyWord ::= U n l i m i t e d N a t u r a l
        //
		keywordKind[34] = (TK_UnlimitedNatural);
	  
	
        //
        // Rule 35:  KeyWord ::= R e a l
        //
		keywordKind[35] = (TK_Real);
	  
	
        //
        // Rule 36:  KeyWord ::= B o o l e a n
        //
		keywordKind[36] = (TK_Boolean);
	  
	
        //
        // Rule 37:  KeyWord ::= T u p l e
        //
		keywordKind[37] = (TK_Tuple);
	  
	
        //
        // Rule 38:  KeyWord ::= O c l A n y
        //
		keywordKind[38] = (TK_OclAny);
	  
	
        //
        // Rule 39:  KeyWord ::= O c l V o i d
        //
		keywordKind[39] = (TK_OclVoid);
	  
	
        //
        // Rule 40:  KeyWord ::= O c l I n v a l i d
        //
		keywordKind[40] = (TK_OclInvalid);
	  
	
        //
        // Rule 41:  KeyWord ::= n u l l
        //
		keywordKind[41] = (TK_null);
	  
	
        //
        // Rule 42:  KeyWord ::= i n v a l i d
        //
		keywordKind[42] = (TK_invalid);
	  
	
        //
        // Rule 43:  KeyWord ::= i n i t
        //
		keywordKind[43] = (TK_init);
	  
	
        //
        // Rule 44:  KeyWord ::= O c l M e s s a g e
        //
		keywordKind[44] = (TK_OclMessage);
	  
	
        //
        // Rule 45:  KeyWord ::= s t a t i c
        //
		keywordKind[45] = (TK_static);
	  
	
        //
        // Rule 47:  QVTKeyWord ::= e n d
        //
		keywordKind[47] = (TK_end);
	  
	
        //
        // Rule 48:  QVTKeyWord ::= w h i l e
        //
		keywordKind[48] = (TK_while);
	  
	
        //
        // Rule 49:  QVTKeyWord ::= o u t
        //
		keywordKind[49] = (TK_out);
	  
	
        //
        // Rule 50:  QVTKeyWord ::= o b j e c t
        //
		keywordKind[50] = (TK_object);
	  
	
        //
        // Rule 51:  QVTKeyWord ::= t r a n s f o r m a t i o n
        //
		keywordKind[51] = (TK_transformation);
	  
	
        //
        // Rule 52:  QVTKeyWord ::= i m p o r t
        //
		keywordKind[52] = (TK_import);
	  
	
        //
        // Rule 53:  QVTKeyWord ::= l i b r a r y
        //
		keywordKind[53] = (TK_library);
	  
	
        //
        // Rule 54:  QVTKeyWord ::= m e t a m o d e l
        //
		keywordKind[54] = (TK_metamodel);
	  
	
        //
        // Rule 55:  QVTKeyWord ::= d i s j u n c t s
        //
		keywordKind[55] = (TK_disjuncts);
	  
	
        //
        // Rule 56:  QVTKeyWord ::= m e r g e s
        //
		keywordKind[56] = (TK_merges);
	  
	
        //
        // Rule 57:  QVTKeyWord ::= i n h e r i t s
        //
		keywordKind[57] = (TK_inherits);
	  
	
        //
        // Rule 58:  QVTKeyWord ::= r e t u r n
        //
		keywordKind[58] = (TK_return);
	  
	
        //
        // Rule 59:  QVTKeyWord ::= r e n a m e
        //
		keywordKind[59] = (TK_rename);
	  
	
        //
        // Rule 60:  QVTKeyWord ::= m a p p i n g
        //
		keywordKind[60] = (TK_mapping);
	  
	
        //
        // Rule 61:  QVTKeyWord ::= q u e r y
        //
		keywordKind[61] = (TK_query);
	  
	
        //
        // Rule 62:  QVTKeyWord ::= h e l p e r
        //
		keywordKind[62] = (TK_helper);
	  
	
        //
        // Rule 63:  QVTKeyWord ::= i n o u t
        //
		keywordKind[63] = (TK_inout);
	  
	
        //
        // Rule 64:  QVTKeyWord ::= w h e n
        //
		keywordKind[64] = (TK_when);
	  
	
        //
        // Rule 65:  QVTKeyWord ::= v a r
        //
		keywordKind[65] = (TK_var);
	  
	
        //
        // Rule 66:  QVTKeyWord ::= c o n f i g u r a t i o n
        //
		keywordKind[66] = (TK_configuration);
	  
	
        //
        // Rule 67:  QVTKeyWord ::= p o p u l a t i o n
        //
		keywordKind[67] = (TK_population);
	  
	
        //
        // Rule 68:  QVTKeyWord ::= i n t e r m e d i a t e
        //
		keywordKind[68] = (TK_intermediate);
	  
	
        //
        // Rule 69:  QVTKeyWord ::= p r o p e r t y
        //
		keywordKind[69] = (TK_property);
	  
	
        //
        // Rule 70:  QVTKeyWord ::= o p p o s i t e s
        //
		keywordKind[70] = (TK_opposites);
	  
	
        //
        // Rule 71:  QVTKeyWord ::= c l a s s
        //
		keywordKind[71] = (TK_class);
	  
	
        //
        // Rule 72:  QVTKeyWord ::= m a p
        //
		keywordKind[72] = (TK_map);
	  
	
        //
        // Rule 73:  QVTKeyWord ::= x m a p
        //
		keywordKind[73] = (TK_xmap);
	  
	
        //
        // Rule 74:  QVTKeyWord ::= n e w
        //
		keywordKind[74] = (TK_new);
	  
	
        //
        // Rule 75:  QVTKeyWord ::= l a t e
        //
		keywordKind[75] = (TK_late);
	  
	
        //
        // Rule 76:  QVTKeyWord ::= l o g
        //
		keywordKind[76] = (TK_log);
	  
	
        //
        // Rule 77:  QVTKeyWord ::= a s s e r t
        //
		keywordKind[77] = (TK_assert);
	  
	
        //
        // Rule 78:  QVTKeyWord ::= w i t h
        //
		keywordKind[78] = (TK_with);
	  
	
        //
        // Rule 79:  QVTKeyWord ::= r e s o l v e
        //
		keywordKind[79] = (TK_resolve);
	  
	
        //
        // Rule 80:  QVTKeyWord ::= r e s o l v e o n e
        //
		keywordKind[80] = (TK_resolveone);
	  
	
        //
        // Rule 81:  QVTKeyWord ::= r e s o l v e I n
        //
		keywordKind[81] = (TK_resolveIn);
	  
	
        //
        // Rule 82:  QVTKeyWord ::= r e s o l v e o n e I n
        //
		keywordKind[82] = (TK_resolveoneIn);
	  
	
        //
        // Rule 83:  QVTKeyWord ::= i n v r e s o l v e
        //
		keywordKind[83] = (TK_invresolve);
	  
	
        //
        // Rule 84:  QVTKeyWord ::= i n v r e s o l v e o n e
        //
		keywordKind[84] = (TK_invresolveone);
	  
	
        //
        // Rule 85:  QVTKeyWord ::= i n v r e s o l v e I n
        //
		keywordKind[85] = (TK_invresolveIn);
	  
	
        //
        // Rule 86:  QVTKeyWord ::= i n v r e s o l v e o n e I n
        //
		keywordKind[86] = (TK_invresolveoneIn);
	  
	
        //
        // Rule 87:  QVTKeyWord ::= m o d e l t y p e
        //
		keywordKind[87] = (TK_modeltype);
	  
	
        //
        // Rule 88:  QVTKeyWord ::= u s e s
        //
		keywordKind[88] = (TK_uses);
	  
	
        //
        // Rule 89:  QVTKeyWord ::= w h e r e
        //
		keywordKind[89] = (TK_where);
	  
	
        //
        // Rule 90:  QVTKeyWord ::= r e f i n e s
        //
		keywordKind[90] = (TK_refines);
	  
	
        //
        // Rule 91:  QVTKeyWord ::= a c c e s s
        //
		keywordKind[91] = (TK_access);
	  
	
        //
        // Rule 92:  QVTKeyWord ::= e x t e n d s
        //
		keywordKind[92] = (TK_extends);
	  
	
        //
        // Rule 93:  QVTKeyWord ::= b l a c k b o x
        //
		keywordKind[93] = (TK_blackbox);
	  
	
        //
        // Rule 94:  QVTKeyWord ::= a b s t r a c t
        //
		keywordKind[94] = (TK_abstract);
	  
	
        //
        // Rule 95:  QVTKeyWord ::= r e s u l t
        //
		keywordKind[95] = (TK_result);
	  
	
        //
        // Rule 96:  QVTKeyWord ::= m a i n
        //
		keywordKind[96] = (TK_main);
	  
	
        //
        // Rule 97:  QVTKeyWord ::= t h i s
        //
		keywordKind[97] = (TK_this);
	  
	
        //
        // Rule 98:  QVTKeyWord ::= s w i t c h
        //
		keywordKind[98] = (TK_switch);
	  
	
        //
        // Rule 99:  QVTKeyWord ::= c a s e
        //
		keywordKind[99] = (TK_case);
	  
	
        //
        // Rule 100:  QVTKeyWord ::= x s e l e c t
        //
		keywordKind[100] = (TK_xselect);
	  
	
        //
        // Rule 101:  QVTKeyWord ::= x c o l l e c t
        //
		keywordKind[101] = (TK_xcollect);
	  
	
        //
        // Rule 102:  QVTKeyWord ::= s e l e c t O n e
        //
		keywordKind[102] = (TK_selectOne);
	  
	
        //
        // Rule 103:  QVTKeyWord ::= c o l l e c t O n e
        //
		keywordKind[103] = (TK_collectOne);
	  
	
        //
        // Rule 104:  QVTKeyWord ::= c o l l e c t s e l e c t
        //
		keywordKind[104] = (TK_collectselect);
	  
	
        //
        // Rule 105:  QVTKeyWord ::= c o l l e c t s e l e c t O n e
        //
		keywordKind[105] = (TK_collectselectOne);
	  
	
        //
        // Rule 106:  QVTKeyWord ::= f o r E a c h
        //
		keywordKind[106] = (TK_forEach);
	  
	
        //
        // Rule 107:  QVTKeyWord ::= f o r O n e
        //
		keywordKind[107] = (TK_forOne);
	  
	
        //
        // Rule 108:  QVTKeyWord ::= c o m p u t e
        //
		keywordKind[108] = (TK_compute);
	  
	
        //
        // Rule 109:  QVTKeyWord ::= D i c t
        //
		keywordKind[109] = (TK_Dict);
	  
	
        //
        // Rule 110:  QVTKeyWord ::= L i s t
        //
		keywordKind[110] = (TK_List);
	  
	
        //
        // Rule 111:  QVTKeyWord ::= b r e a k
        //
		keywordKind[111] = (TK_break);
	  
	
        //
        // Rule 112:  QVTKeyWord ::= c o m p o s e s
        //
		keywordKind[112] = (TK_composes);
	  
	
        //
        // Rule 113:  QVTKeyWord ::= c o n s t r u c t o r
        //
		keywordKind[113] = (TK_constructor);
	  
	
        //
        // Rule 114:  QVTKeyWord ::= c o n t i n u e
        //
		keywordKind[114] = (TK_continue);
	  
	
        //
        // Rule 115:  QVTKeyWord ::= d a t a t y p e
        //
		keywordKind[115] = (TK_datatype);
	  
	
        //
        // Rule 116:  QVTKeyWord ::= d e f a u l t
        //
		keywordKind[116] = (TK_default);
	  
	
        //
        // Rule 117:  QVTKeyWord ::= d e r i v e d
        //
		keywordKind[117] = (TK_derived);
	  
	
        //
        // Rule 118:  QVTKeyWord ::= d o
        //
		keywordKind[118] = (TK_do);
	  
	
        //
        // Rule 119:  QVTKeyWord ::= e l i f
        //
		keywordKind[119] = (TK_elif);
	  
	
        //
        // Rule 120:  QVTKeyWord ::= e n u m
        //
		keywordKind[120] = (TK_enum);
	  
	
        //
        // Rule 121:  QVTKeyWord ::= e x c e p t
        //
		keywordKind[121] = (TK_except);
	  
	
        //
        // Rule 122:  QVTKeyWord ::= e x c e p t i o n
        //
		keywordKind[122] = (TK_exception);
	  
	
        //
        // Rule 123:  QVTKeyWord ::= f r o m
        //
		keywordKind[123] = (TK_from);
	  
	
        //
        // Rule 124:  QVTKeyWord ::= l i t e r a l
        //
		keywordKind[124] = (TK_literal);
	  
	
        //
        // Rule 125:  QVTKeyWord ::= o r d e r e d
        //
		keywordKind[125] = (TK_ordered);
	  
	
        //
        // Rule 126:  QVTKeyWord ::= p r i m i t i v e
        //
		keywordKind[126] = (TK_primitive);
	  
	
        //
        // Rule 127:  QVTKeyWord ::= r a i s e
        //
		keywordKind[127] = (TK_raise);
	  
	
        //
        // Rule 128:  QVTKeyWord ::= r e a d o n l y
        //
		keywordKind[128] = (TK_readonly);
	  
	
        //
        // Rule 129:  QVTKeyWord ::= r e f e r e n c e s
        //
		keywordKind[129] = (TK_references);
	  
	
        //
        // Rule 130:  QVTKeyWord ::= t a g
        //
		keywordKind[130] = (TK_tag);
	  
	
        //
        // Rule 131:  QVTKeyWord ::= t r y
        //
		keywordKind[131] = (TK_try);
	  
	
        //
        // Rule 132:  QVTKeyWord ::= t y p e d e f
        //
		keywordKind[132] = (TK_typedef);
	  
	
        //
        // Rule 133:  QVTKeyWord ::= u n l i m i t e d
        //
		keywordKind[133] = (TK_unlimited);
	  
	

        for (int i = 0; i < keywordKind.length; i++)
        {
            if (keywordKind[i] == 0)
                keywordKind[i] = identifierKind;
        }
    }
}

