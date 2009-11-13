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
* $Id: QVTOKWLexer.java,v 1.1 2009/11/13 22:09:03 sboyko Exp $
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
* $Id: QVTOKWLexer.java,v 1.1 2009/11/13 22:09:03 sboyko Exp $
*/

package org.eclipse.m2m.internal.qvt.oml.cst.parser;




public class QVTOKWLexer extends QVTOKWLexerprs implements QVTOParsersym
{
    private char[] inputChars;
    private final int keywordKind[] = new int[121 + 1];

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


    public QVTOKWLexer(char[] inputChars, int identifierKind)
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
        // Rule 20:  KeyWord ::= S t r i n g
        //
		keywordKind[20] = (TK_String);
	  
	
        //
        // Rule 21:  KeyWord ::= I n t e g e r
        //
		keywordKind[21] = (TK_Integer);
	  
	
        //
        // Rule 22:  KeyWord ::= U n l i m i t e d N a t u r a l
        //
		keywordKind[22] = (TK_UnlimitedNatural);
	  
	
        //
        // Rule 23:  KeyWord ::= R e a l
        //
		keywordKind[23] = (TK_Real);
	  
	
        //
        // Rule 24:  KeyWord ::= B o o l e a n
        //
		keywordKind[24] = (TK_Boolean);
	  
	
        //
        // Rule 25:  KeyWord ::= T u p l e
        //
		keywordKind[25] = (TK_Tuple);
	  
	
        //
        // Rule 26:  KeyWord ::= O c l A n y
        //
		keywordKind[26] = (TK_OclAny);
	  
	
        //
        // Rule 27:  KeyWord ::= O c l V o i d
        //
		keywordKind[27] = (TK_OclVoid);
	  
	
        //
        // Rule 28:  KeyWord ::= O c l I n v a l i d
        //
		keywordKind[28] = (TK_OclInvalid);
	  
	
        //
        // Rule 29:  KeyWord ::= n u l l
        //
		keywordKind[29] = (TK_null);
	  
	
        //
        // Rule 30:  KeyWord ::= i n v a l i d
        //
		keywordKind[30] = (TK_invalid);
	  
	
        //
        // Rule 31:  KeyWord ::= i n i t
        //
		keywordKind[31] = (TK_init);
	  
	
        //
        // Rule 32:  KeyWord ::= O c l M e s s a g e
        //
		keywordKind[32] = (TK_OclMessage);
	  
	
        //
        // Rule 33:  KeyWord ::= s t a t i c
        //
		keywordKind[33] = (TK_static);
	  
	
        //
        // Rule 35:  QVTKeyWord ::= e n d
        //
		keywordKind[35] = (TK_end);
	  
	
        //
        // Rule 36:  QVTKeyWord ::= w h i l e
        //
		keywordKind[36] = (TK_while);
	  
	
        //
        // Rule 37:  QVTKeyWord ::= o u t
        //
		keywordKind[37] = (TK_out);
	  
	
        //
        // Rule 38:  QVTKeyWord ::= o b j e c t
        //
		keywordKind[38] = (TK_object);
	  
	
        //
        // Rule 39:  QVTKeyWord ::= t r a n s f o r m a t i o n
        //
		keywordKind[39] = (TK_transformation);
	  
	
        //
        // Rule 40:  QVTKeyWord ::= i m p o r t
        //
		keywordKind[40] = (TK_import);
	  
	
        //
        // Rule 41:  QVTKeyWord ::= l i b r a r y
        //
		keywordKind[41] = (TK_library);
	  
	
        //
        // Rule 42:  QVTKeyWord ::= m e t a m o d e l
        //
		keywordKind[42] = (TK_metamodel);
	  
	
        //
        // Rule 43:  QVTKeyWord ::= d i s j u n c t s
        //
		keywordKind[43] = (TK_disjuncts);
	  
	
        //
        // Rule 44:  QVTKeyWord ::= m e r g e s
        //
		keywordKind[44] = (TK_merges);
	  
	
        //
        // Rule 45:  QVTKeyWord ::= i n h e r i t s
        //
		keywordKind[45] = (TK_inherits);
	  
	
        //
        // Rule 46:  QVTKeyWord ::= r e t u r n
        //
		keywordKind[46] = (TK_return);
	  
	
        //
        // Rule 47:  QVTKeyWord ::= r e n a m e
        //
		keywordKind[47] = (TK_rename);
	  
	
        //
        // Rule 48:  QVTKeyWord ::= m a p p i n g
        //
		keywordKind[48] = (TK_mapping);
	  
	
        //
        // Rule 49:  QVTKeyWord ::= q u e r y
        //
		keywordKind[49] = (TK_query);
	  
	
        //
        // Rule 50:  QVTKeyWord ::= h e l p e r
        //
		keywordKind[50] = (TK_helper);
	  
	
        //
        // Rule 51:  QVTKeyWord ::= i n o u t
        //
		keywordKind[51] = (TK_inout);
	  
	
        //
        // Rule 52:  QVTKeyWord ::= w h e n
        //
		keywordKind[52] = (TK_when);
	  
	
        //
        // Rule 53:  QVTKeyWord ::= v a r
        //
		keywordKind[53] = (TK_var);
	  
	
        //
        // Rule 54:  QVTKeyWord ::= c o n f i g u r a t i o n
        //
		keywordKind[54] = (TK_configuration);
	  
	
        //
        // Rule 55:  QVTKeyWord ::= p o p u l a t i o n
        //
		keywordKind[55] = (TK_population);
	  
	
        //
        // Rule 56:  QVTKeyWord ::= i n t e r m e d i a t e
        //
		keywordKind[56] = (TK_intermediate);
	  
	
        //
        // Rule 57:  QVTKeyWord ::= p r o p e r t y
        //
		keywordKind[57] = (TK_property);
	  
	
        //
        // Rule 58:  QVTKeyWord ::= o p p o s i t e s
        //
		keywordKind[58] = (TK_opposites);
	  
	
        //
        // Rule 59:  QVTKeyWord ::= c l a s s
        //
		keywordKind[59] = (TK_class);
	  
	
        //
        // Rule 60:  QVTKeyWord ::= m a p
        //
		keywordKind[60] = (TK_map);
	  
	
        //
        // Rule 61:  QVTKeyWord ::= x m a p
        //
		keywordKind[61] = (TK_xmap);
	  
	
        //
        // Rule 62:  QVTKeyWord ::= n e w
        //
		keywordKind[62] = (TK_new);
	  
	
        //
        // Rule 63:  QVTKeyWord ::= l a t e
        //
		keywordKind[63] = (TK_late);
	  
	
        //
        // Rule 64:  QVTKeyWord ::= l o g
        //
		keywordKind[64] = (TK_log);
	  
	
        //
        // Rule 65:  QVTKeyWord ::= a s s e r t
        //
		keywordKind[65] = (TK_assert);
	  
	
        //
        // Rule 66:  QVTKeyWord ::= w i t h
        //
		keywordKind[66] = (TK_with);
	  
	
        //
        // Rule 67:  QVTKeyWord ::= r e s o l v e
        //
		keywordKind[67] = (TK_resolve);
	  
	
        //
        // Rule 68:  QVTKeyWord ::= r e s o l v e o n e
        //
		keywordKind[68] = (TK_resolveone);
	  
	
        //
        // Rule 69:  QVTKeyWord ::= r e s o l v e I n
        //
		keywordKind[69] = (TK_resolveIn);
	  
	
        //
        // Rule 70:  QVTKeyWord ::= r e s o l v e o n e I n
        //
		keywordKind[70] = (TK_resolveoneIn);
	  
	
        //
        // Rule 71:  QVTKeyWord ::= i n v r e s o l v e
        //
		keywordKind[71] = (TK_invresolve);
	  
	
        //
        // Rule 72:  QVTKeyWord ::= i n v r e s o l v e o n e
        //
		keywordKind[72] = (TK_invresolveone);
	  
	
        //
        // Rule 73:  QVTKeyWord ::= i n v r e s o l v e I n
        //
		keywordKind[73] = (TK_invresolveIn);
	  
	
        //
        // Rule 74:  QVTKeyWord ::= i n v r e s o l v e o n e I n
        //
		keywordKind[74] = (TK_invresolveoneIn);
	  
	
        //
        // Rule 75:  QVTKeyWord ::= m o d e l t y p e
        //
		keywordKind[75] = (TK_modeltype);
	  
	
        //
        // Rule 76:  QVTKeyWord ::= u s e s
        //
		keywordKind[76] = (TK_uses);
	  
	
        //
        // Rule 77:  QVTKeyWord ::= w h e r e
        //
		keywordKind[77] = (TK_where);
	  
	
        //
        // Rule 78:  QVTKeyWord ::= r e f i n e s
        //
		keywordKind[78] = (TK_refines);
	  
	
        //
        // Rule 79:  QVTKeyWord ::= a c c e s s
        //
		keywordKind[79] = (TK_access);
	  
	
        //
        // Rule 80:  QVTKeyWord ::= e x t e n d s
        //
		keywordKind[80] = (TK_extends);
	  
	
        //
        // Rule 81:  QVTKeyWord ::= b l a c k b o x
        //
		keywordKind[81] = (TK_blackbox);
	  
	
        //
        // Rule 82:  QVTKeyWord ::= a b s t r a c t
        //
		keywordKind[82] = (TK_abstract);
	  
	
        //
        // Rule 83:  QVTKeyWord ::= r e s u l t
        //
		keywordKind[83] = (TK_result);
	  
	
        //
        // Rule 84:  QVTKeyWord ::= m a i n
        //
		keywordKind[84] = (TK_main);
	  
	
        //
        // Rule 85:  QVTKeyWord ::= t h i s
        //
		keywordKind[85] = (TK_this);
	  
	
        //
        // Rule 86:  QVTKeyWord ::= s w i t c h
        //
		keywordKind[86] = (TK_switch);
	  
	
        //
        // Rule 87:  QVTKeyWord ::= c a s e
        //
		keywordKind[87] = (TK_case);
	  
	
        //
        // Rule 88:  QVTKeyWord ::= x s e l e c t
        //
		keywordKind[88] = (TK_xselect);
	  
	
        //
        // Rule 89:  QVTKeyWord ::= x c o l l e c t
        //
		keywordKind[89] = (TK_xcollect);
	  
	
        //
        // Rule 90:  QVTKeyWord ::= s e l e c t O n e
        //
		keywordKind[90] = (TK_selectOne);
	  
	
        //
        // Rule 91:  QVTKeyWord ::= c o l l e c t O n e
        //
		keywordKind[91] = (TK_collectOne);
	  
	
        //
        // Rule 92:  QVTKeyWord ::= c o l l e c t s e l e c t
        //
		keywordKind[92] = (TK_collectselect);
	  
	
        //
        // Rule 93:  QVTKeyWord ::= c o l l e c t s e l e c t O n e
        //
		keywordKind[93] = (TK_collectselectOne);
	  
	
        //
        // Rule 94:  QVTKeyWord ::= f o r E a c h
        //
		keywordKind[94] = (TK_forEach);
	  
	
        //
        // Rule 95:  QVTKeyWord ::= f o r O n e
        //
		keywordKind[95] = (TK_forOne);
	  
	
        //
        // Rule 96:  QVTKeyWord ::= c o m p u t e
        //
		keywordKind[96] = (TK_compute);
	  
	
        //
        // Rule 97:  QVTKeyWord ::= D i c t
        //
		keywordKind[97] = (TK_Dict);
	  
	
        //
        // Rule 98:  QVTKeyWord ::= L i s t
        //
		keywordKind[98] = (TK_List);
	  
	
        //
        // Rule 99:  QVTKeyWord ::= b r e a k
        //
		keywordKind[99] = (TK_break);
	  
	
        //
        // Rule 100:  QVTKeyWord ::= c o m p o s e s
        //
		keywordKind[100] = (TK_composes);
	  
	
        //
        // Rule 101:  QVTKeyWord ::= c o n s t r u c t o r
        //
		keywordKind[101] = (TK_constructor);
	  
	
        //
        // Rule 102:  QVTKeyWord ::= c o n t i n u e
        //
		keywordKind[102] = (TK_continue);
	  
	
        //
        // Rule 103:  QVTKeyWord ::= d a t a t y p e
        //
		keywordKind[103] = (TK_datatype);
	  
	
        //
        // Rule 104:  QVTKeyWord ::= d e f a u l t
        //
		keywordKind[104] = (TK_default);
	  
	
        //
        // Rule 105:  QVTKeyWord ::= d e r i v e d
        //
		keywordKind[105] = (TK_derived);
	  
	
        //
        // Rule 106:  QVTKeyWord ::= d o
        //
		keywordKind[106] = (TK_do);
	  
	
        //
        // Rule 107:  QVTKeyWord ::= e l i f
        //
		keywordKind[107] = (TK_elif);
	  
	
        //
        // Rule 108:  QVTKeyWord ::= e n u m
        //
		keywordKind[108] = (TK_enum);
	  
	
        //
        // Rule 109:  QVTKeyWord ::= e x c e p t
        //
		keywordKind[109] = (TK_except);
	  
	
        //
        // Rule 110:  QVTKeyWord ::= e x c e p t i o n
        //
		keywordKind[110] = (TK_exception);
	  
	
        //
        // Rule 111:  QVTKeyWord ::= f r o m
        //
		keywordKind[111] = (TK_from);
	  
	
        //
        // Rule 112:  QVTKeyWord ::= l i t e r a l
        //
		keywordKind[112] = (TK_literal);
	  
	
        //
        // Rule 113:  QVTKeyWord ::= o r d e r e d
        //
		keywordKind[113] = (TK_ordered);
	  
	
        //
        // Rule 114:  QVTKeyWord ::= p r i m i t i v e
        //
		keywordKind[114] = (TK_primitive);
	  
	
        //
        // Rule 115:  QVTKeyWord ::= r a i s e
        //
		keywordKind[115] = (TK_raise);
	  
	
        //
        // Rule 116:  QVTKeyWord ::= r e a d o n l y
        //
		keywordKind[116] = (TK_readonly);
	  
	
        //
        // Rule 117:  QVTKeyWord ::= r e f e r e n c e s
        //
		keywordKind[117] = (TK_references);
	  
	
        //
        // Rule 118:  QVTKeyWord ::= t a g
        //
		keywordKind[118] = (TK_tag);
	  
	
        //
        // Rule 119:  QVTKeyWord ::= t r y
        //
		keywordKind[119] = (TK_try);
	  
	
        //
        // Rule 120:  QVTKeyWord ::= t y p e d e f
        //
		keywordKind[120] = (TK_typedef);
	  
	
        //
        // Rule 121:  QVTKeyWord ::= u n l i m i t e d
        //
		keywordKind[121] = (TK_unlimited);
	  
	

        for (int i = 0; i < keywordKind.length; i++)
        {
            if (keywordKind[i] == 0)
                keywordKind[i] = identifierKind;
        }
    }
}

