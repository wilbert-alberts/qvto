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
* $Id: QvtOpKWLexer.java,v 1.37 2008/02/18 15:33:56 aigdalov Exp $
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
* $Id: QvtOpKWLexer.java,v 1.37 2008/02/18 15:33:56 aigdalov Exp $
*/

package org.eclipse.m2m.qvt.oml.internal.cst.parser;



public class QvtOpKWLexer extends QvtOpKWLexerprs implements QvtOpLPGParsersym
{
    private char[] inputChars;
    private final int keywordKind[] = new int[106 + 1];

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
        // Rule 2:  KeyWord ::= i n i t
        //
		keywordKind[2] = (TK_init);
	  
	
        //
        // Rule 3:  KeyWord ::= i f
        //
		keywordKind[3] = (TK_if);
	  
	
        //
        // Rule 4:  KeyWord ::= t h e n
        //
		keywordKind[4] = (TK_then);
	  
	
        //
        // Rule 5:  KeyWord ::= e l s e
        //
		keywordKind[5] = (TK_else);
	  
	
        //
        // Rule 6:  KeyWord ::= e n d i f
        //
		keywordKind[6] = (TK_endif);
	  
	
        //
        // Rule 7:  KeyWord ::= a n d
        //
		keywordKind[7] = (TK_and);
	  
	
        //
        // Rule 8:  KeyWord ::= o r
        //
		keywordKind[8] = (TK_or);
	  
	
        //
        // Rule 9:  KeyWord ::= x o r
        //
		keywordKind[9] = (TK_xor);
	  
	
        //
        // Rule 10:  KeyWord ::= n o t
        //
		keywordKind[10] = (TK_not);
	  
	
        //
        // Rule 11:  KeyWord ::= i m p l i e s
        //
		keywordKind[11] = (TK_implies);
	  
	
        //
        // Rule 12:  KeyWord ::= l e t
        //
		keywordKind[12] = (TK_let);
	  
	
        //
        // Rule 13:  KeyWord ::= i n
        //
		keywordKind[13] = (TK_in);
	  
	
        //
        // Rule 14:  KeyWord ::= t r u e
        //
		keywordKind[14] = (TK_true);
	  
	
        //
        // Rule 15:  KeyWord ::= f a l s e
        //
		keywordKind[15] = (TK_false);
	  
	
        //
        // Rule 16:  KeyWord ::= S e t
        //
		keywordKind[16] = (TK_Set);
	  
	
        //
        // Rule 17:  KeyWord ::= B a g
        //
		keywordKind[17] = (TK_Bag);
	  
	
        //
        // Rule 18:  KeyWord ::= S e q u e n c e
        //
		keywordKind[18] = (TK_Sequence);
	  
	
        //
        // Rule 19:  KeyWord ::= C o l l e c t i o n
        //
		keywordKind[19] = (TK_Collection);
	  
	
        //
        // Rule 20:  KeyWord ::= O r d e r e d S e t
        //
		keywordKind[20] = (TK_OrderedSet);
	  
	
        //
        // Rule 21:  KeyWord ::= i t e r a t e
        //
		keywordKind[21] = (TK_iterate);
	  
	
        //
        // Rule 22:  KeyWord ::= f o r A l l
        //
		keywordKind[22] = (TK_forAll);
	  
	
        //
        // Rule 23:  KeyWord ::= e x i s t s
        //
		keywordKind[23] = (TK_exists);
	  
	
        //
        // Rule 24:  KeyWord ::= i s U n i q u e
        //
		keywordKind[24] = (TK_isUnique);
	  
	
        //
        // Rule 25:  KeyWord ::= a n y
        //
		keywordKind[25] = (TK_any);
	  
	
        //
        // Rule 26:  KeyWord ::= o n e
        //
		keywordKind[26] = (TK_one);
	  
	
        //
        // Rule 27:  KeyWord ::= c o l l e c t
        //
		keywordKind[27] = (TK_collect);
	  
	
        //
        // Rule 28:  KeyWord ::= s e l e c t
        //
		keywordKind[28] = (TK_select);
	  
	
        //
        // Rule 29:  KeyWord ::= r e j e c t
        //
		keywordKind[29] = (TK_reject);
	  
	
        //
        // Rule 30:  KeyWord ::= c o l l e c t N e s t e d
        //
		keywordKind[30] = (TK_collectNested);
	  
	
        //
        // Rule 31:  KeyWord ::= s o r t e d B y
        //
		keywordKind[31] = (TK_sortedBy);
	  
	
        //
        // Rule 32:  KeyWord ::= c l o s u r e
        //
		keywordKind[32] = (TK_closure);
	  
	
        //
        // Rule 33:  KeyWord ::= o c l I s K i n d O f
        //
		keywordKind[33] = (TK_oclIsKindOf);
	  
	
        //
        // Rule 34:  KeyWord ::= o c l I s T y p e O f
        //
		keywordKind[34] = (TK_oclIsTypeOf);
	  
	
        //
        // Rule 35:  KeyWord ::= o c l A s T y p e
        //
		keywordKind[35] = (TK_oclAsType);
	  
	
        //
        // Rule 36:  KeyWord ::= o c l I s N e w
        //
		keywordKind[36] = (TK_oclIsNew);
	  
	
        //
        // Rule 37:  KeyWord ::= o c l I s U n d e f i n e d
        //
		keywordKind[37] = (TK_oclIsUndefined);
	  
	
        //
        // Rule 38:  KeyWord ::= o c l I s I n v a l i d
        //
		keywordKind[38] = (TK_oclIsInvalid);
	  
	
        //
        // Rule 39:  KeyWord ::= o c l I s I n S t a t e
        //
		keywordKind[39] = (TK_oclIsInState);
	  
	
        //
        // Rule 40:  KeyWord ::= a l l I n s t a n c e s
        //
		keywordKind[40] = (TK_allInstances);
	  
	
        //
        // Rule 41:  KeyWord ::= S t r i n g
        //
		keywordKind[41] = (TK_String);
	  
	
        //
        // Rule 42:  KeyWord ::= I n t e g e r
        //
		keywordKind[42] = (TK_Integer);
	  
	
        //
        // Rule 43:  KeyWord ::= U n l i m i t e d N a t u r a l
        //
		keywordKind[43] = (TK_UnlimitedNatural);
	  
	
        //
        // Rule 44:  KeyWord ::= R e a l
        //
		keywordKind[44] = (TK_Real);
	  
	
        //
        // Rule 45:  KeyWord ::= B o o l e a n
        //
		keywordKind[45] = (TK_Boolean);
	  
	
        //
        // Rule 46:  KeyWord ::= T u p l e
        //
		keywordKind[46] = (TK_Tuple);
	  
	
        //
        // Rule 47:  KeyWord ::= O c l A n y
        //
		keywordKind[47] = (TK_OclAny);
	  
	
        //
        // Rule 48:  KeyWord ::= O c l V o i d
        //
		keywordKind[48] = (TK_OclVoid);
	  
	
        //
        // Rule 49:  KeyWord ::= I n v a l i d
        //
		keywordKind[49] = (TK_Invalid);
	  
	
        //
        // Rule 50:  KeyWord ::= O c l M e s s a g e
        //
		keywordKind[50] = (TK_OclMessage);
	  
	
        //
        // Rule 51:  KeyWord ::= n u l l
        //
		keywordKind[51] = (TK_null);
	  
	
        //
        // Rule 52:  KeyWord ::= O c l I n v a l i d
        //
		keywordKind[52] = (TK_OclInvalid);
	  
	
        //
        // Rule 54:  QVTKeyWord ::= e n d
        //
		keywordKind[54] = (TK_end);
	  
	
        //
        // Rule 55:  QVTKeyWord ::= w h i l e
        //
		keywordKind[55] = (TK_while);
	  
	
        //
        // Rule 56:  QVTKeyWord ::= o u t
        //
		keywordKind[56] = (TK_out);
	  
	
        //
        // Rule 57:  QVTKeyWord ::= o b j e c t
        //
		keywordKind[57] = (TK_object);
	  
	
        //
        // Rule 58:  QVTKeyWord ::= t r a n s f o r m a t i o n
        //
		keywordKind[58] = (TK_transformation);
	  
	
        //
        // Rule 59:  QVTKeyWord ::= i m p o r t
        //
		keywordKind[59] = (TK_import);
	  
	
        //
        // Rule 60:  QVTKeyWord ::= l i b r a r y
        //
		keywordKind[60] = (TK_library);
	  
	
        //
        // Rule 61:  QVTKeyWord ::= m e t a m o d e l
        //
		keywordKind[61] = (TK_metamodel);
	  
	
        //
        // Rule 62:  QVTKeyWord ::= r e t u r n
        //
		keywordKind[62] = (TK_return);
	  
	
        //
        // Rule 63:  QVTKeyWord ::= r e n a m e
        //
		keywordKind[63] = (TK_rename);
	  
	
        //
        // Rule 64:  QVTKeyWord ::= m a p p i n g
        //
		keywordKind[64] = (TK_mapping);
	  
	
        //
        // Rule 65:  QVTKeyWord ::= q u e r y
        //
		keywordKind[65] = (TK_query);
	  
	
        //
        // Rule 66:  QVTKeyWord ::= h e l p e r
        //
		keywordKind[66] = (TK_helper);
	  
	
        //
        // Rule 67:  QVTKeyWord ::= i n o u t
        //
		keywordKind[67] = (TK_inout);
	  
	
        //
        // Rule 68:  QVTKeyWord ::= w h e n
        //
		keywordKind[68] = (TK_when);
	  
	
        //
        // Rule 69:  QVTKeyWord ::= v a r
        //
		keywordKind[69] = (TK_var);
	  
	
        //
        // Rule 70:  QVTKeyWord ::= c o n f i g u r a t i o n
        //
		keywordKind[70] = (TK_configuration);
	  
	
        //
        // Rule 71:  QVTKeyWord ::= p o p u l a t i o n
        //
		keywordKind[71] = (TK_population);
	  
	
        //
        // Rule 72:  QVTKeyWord ::= p r o p e r t y
        //
		keywordKind[72] = (TK_property);
	  
	
        //
        // Rule 73:  QVTKeyWord ::= m a p
        //
		keywordKind[73] = (TK_map);
	  
	
        //
        // Rule 74:  QVTKeyWord ::= x m a p
        //
		keywordKind[74] = (TK_xmap);
	  
	
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
        // Rule 91:  QVTKeyWord ::= e n f o r c i n g
        //
		keywordKind[91] = (TK_enforcing);
	  
	
        //
        // Rule 92:  QVTKeyWord ::= a c c e s s
        //
		keywordKind[92] = (TK_access);
	  
	
        //
        // Rule 93:  QVTKeyWord ::= e x t e n d s
        //
		keywordKind[93] = (TK_extends);
	  
	
        //
        // Rule 94:  QVTKeyWord ::= b l a c k b o x
        //
		keywordKind[94] = (TK_blackbox);
	  
	
        //
        // Rule 95:  QVTKeyWord ::= a b s t r a c t
        //
		keywordKind[95] = (TK_abstract);
	  
	
        //
        // Rule 96:  QVTKeyWord ::= s t a t i c
        //
		keywordKind[96] = (TK_static);
	  
	
        //
        // Rule 97:  QVTKeyWord ::= r e s u l t
        //
		keywordKind[97] = (TK_result);
	  
	
        //
        // Rule 98:  QVTKeyWord ::= m a i n
        //
		keywordKind[98] = (TK_main);
	  
	
        //
        // Rule 99:  QVTKeyWord ::= t h i s
        //
		keywordKind[99] = (TK_this);
	  
	
        //
        // Rule 100:  QVTKeyWord ::= s w i t c h
        //
		keywordKind[100] = (TK_switch);
	  
	
        //
        // Rule 101:  QVTKeyWord ::= x s e l e c t
        //
		keywordKind[101] = (TK_xselect);
	  
	
        //
        // Rule 102:  QVTKeyWord ::= x c o l l e c t
        //
		keywordKind[102] = (TK_xcollect);
	  
	
        //
        // Rule 103:  QVTKeyWord ::= s e l e c t O n e
        //
		keywordKind[103] = (TK_selectOne);
	  
	
        //
        // Rule 104:  QVTKeyWord ::= c o l l e c t O n e
        //
		keywordKind[104] = (TK_collectOne);
	  
	
        //
        // Rule 105:  QVTKeyWord ::= c o l l e c t s e l e c t
        //
		keywordKind[105] = (TK_collectselect);
	  
	
        //
        // Rule 106:  QVTKeyWord ::= c o l l e c t s e l e c t O n e
        //
		keywordKind[106] = (TK_collectselectOne);
	  
	

        for (int i = 0; i < keywordKind.length; i++)
        {
            if (keywordKind[i] == 0)
                keywordKind[i] = identifierKind;
        }
    }
}

