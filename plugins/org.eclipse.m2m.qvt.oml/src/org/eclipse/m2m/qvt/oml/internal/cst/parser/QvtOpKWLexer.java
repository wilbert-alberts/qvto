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
* $Id: QvtOpKWLexer.java,v 1.11 2007/09/12 12:58:31 sboyko Exp $
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
* $Id: QvtOpKWLexer.java,v 1.11 2007/09/12 12:58:31 sboyko Exp $
*/

package org.eclipse.m2m.qvt.oml.internal.cst.parser;

import lpg.lpgjavaruntime.*;


public class QvtOpKWLexer extends QvtOpKWLexerprs implements QvtOpLPGParsersym
{
    private char[] inputChars;
    private final int keywordKind[] = new int[93 + 1];

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
        // Rule 2:  KeyWord ::= p a c k a g e
        //
		keywordKind[2] = (TK_package);
	  
	
        //
        // Rule 3:  KeyWord ::= i n i t
        //
		keywordKind[3] = (TK_init);
	  
	
        //
        // Rule 4:  KeyWord ::= i f
        //
		keywordKind[4] = (TK_if);
	  
	
        //
        // Rule 5:  KeyWord ::= t h e n
        //
		keywordKind[5] = (TK_then);
	  
	
        //
        // Rule 6:  KeyWord ::= e l s e
        //
		keywordKind[6] = (TK_else);
	  
	
        //
        // Rule 7:  KeyWord ::= e n d i f
        //
		keywordKind[7] = (TK_endif);
	  
	
        //
        // Rule 8:  KeyWord ::= a n d
        //
		keywordKind[8] = (TK_and);
	  
	
        //
        // Rule 9:  KeyWord ::= o r
        //
		keywordKind[9] = (TK_or);
	  
	
        //
        // Rule 10:  KeyWord ::= x o r
        //
		keywordKind[10] = (TK_xor);
	  
	
        //
        // Rule 11:  KeyWord ::= n o t
        //
		keywordKind[11] = (TK_not);
	  
	
        //
        // Rule 12:  KeyWord ::= i m p l i e s
        //
		keywordKind[12] = (TK_implies);
	  
	
        //
        // Rule 13:  KeyWord ::= l e t
        //
		keywordKind[13] = (TK_let);
	  
	
        //
        // Rule 14:  KeyWord ::= i n
        //
		keywordKind[14] = (TK_in);
	  
	
        //
        // Rule 15:  KeyWord ::= t r u e
        //
		keywordKind[15] = (TK_true);
	  
	
        //
        // Rule 16:  KeyWord ::= f a l s e
        //
		keywordKind[16] = (TK_false);
	  
	
        //
        // Rule 17:  KeyWord ::= S e t
        //
		keywordKind[17] = (TK_Set);
	  
	
        //
        // Rule 18:  KeyWord ::= B a g
        //
		keywordKind[18] = (TK_Bag);
	  
	
        //
        // Rule 19:  KeyWord ::= S e q u e n c e
        //
		keywordKind[19] = (TK_Sequence);
	  
	
        //
        // Rule 20:  KeyWord ::= C o l l e c t i o n
        //
		keywordKind[20] = (TK_Collection);
	  
	
        //
        // Rule 21:  KeyWord ::= O r d e r e d S e t
        //
		keywordKind[21] = (TK_OrderedSet);
	  
	
        //
        // Rule 22:  KeyWord ::= i t e r a t e
        //
		keywordKind[22] = (TK_iterate);
	  
	
        //
        // Rule 23:  KeyWord ::= f o r A l l
        //
		keywordKind[23] = (TK_forAll);
	  
	
        //
        // Rule 24:  KeyWord ::= e x i s t s
        //
		keywordKind[24] = (TK_exists);
	  
	
        //
        // Rule 25:  KeyWord ::= i s U n i q u e
        //
		keywordKind[25] = (TK_isUnique);
	  
	
        //
        // Rule 26:  KeyWord ::= a n y
        //
		keywordKind[26] = (TK_any);
	  
	
        //
        // Rule 27:  KeyWord ::= o n e
        //
		keywordKind[27] = (TK_one);
	  
	
        //
        // Rule 28:  KeyWord ::= c o l l e c t
        //
		keywordKind[28] = (TK_collect);
	  
	
        //
        // Rule 29:  KeyWord ::= s e l e c t
        //
		keywordKind[29] = (TK_select);
	  
	
        //
        // Rule 30:  KeyWord ::= r e j e c t
        //
		keywordKind[30] = (TK_reject);
	  
	
        //
        // Rule 31:  KeyWord ::= c o l l e c t N e s t e d
        //
		keywordKind[31] = (TK_collectNested);
	  
	
        //
        // Rule 32:  KeyWord ::= s o r t e d B y
        //
		keywordKind[32] = (TK_sortedBy);
	  
	
        //
        // Rule 33:  KeyWord ::= c l o s u r e
        //
		keywordKind[33] = (TK_closure);
	  
	
        //
        // Rule 34:  KeyWord ::= o c l I s K i n d O f
        //
		keywordKind[34] = (TK_oclIsKindOf);
	  
	
        //
        // Rule 35:  KeyWord ::= o c l I s T y p e O f
        //
		keywordKind[35] = (TK_oclIsTypeOf);
	  
	
        //
        // Rule 36:  KeyWord ::= o c l A s T y p e
        //
		keywordKind[36] = (TK_oclAsType);
	  
	
        //
        // Rule 37:  KeyWord ::= o c l I s N e w
        //
		keywordKind[37] = (TK_oclIsNew);
	  
	
        //
        // Rule 38:  KeyWord ::= o c l I s U n d e f i n e d
        //
		keywordKind[38] = (TK_oclIsUndefined);
	  
	
        //
        // Rule 39:  KeyWord ::= o c l I s I n v a l i d
        //
		keywordKind[39] = (TK_oclIsInvalid);
	  
	
        //
        // Rule 40:  KeyWord ::= o c l I s I n S t a t e
        //
		keywordKind[40] = (TK_oclIsInState);
	  
	
        //
        // Rule 41:  KeyWord ::= a l l I n s t a n c e s
        //
		keywordKind[41] = (TK_allInstances);
	  
	
        //
        // Rule 42:  KeyWord ::= S t r i n g
        //
		keywordKind[42] = (TK_String);
	  
	
        //
        // Rule 43:  KeyWord ::= I n t e g e r
        //
		keywordKind[43] = (TK_Integer);
	  
	
        //
        // Rule 44:  KeyWord ::= U n l i m i t e d N a t u r a l
        //
		keywordKind[44] = (TK_UnlimitedNatural);
	  
	
        //
        // Rule 45:  KeyWord ::= R e a l
        //
		keywordKind[45] = (TK_Real);
	  
	
        //
        // Rule 46:  KeyWord ::= B o o l e a n
        //
		keywordKind[46] = (TK_Boolean);
	  
	
        //
        // Rule 47:  KeyWord ::= T u p l e
        //
		keywordKind[47] = (TK_Tuple);
	  
	
        //
        // Rule 48:  KeyWord ::= O c l A n y
        //
		keywordKind[48] = (TK_OclAny);
	  
	
        //
        // Rule 49:  KeyWord ::= O c l V o i d
        //
		keywordKind[49] = (TK_OclVoid);
	  
	
        //
        // Rule 50:  KeyWord ::= I n v a l i d
        //
		keywordKind[50] = (TK_Invalid);
	  
	
        //
        // Rule 51:  KeyWord ::= O c l M e s s a g e
        //
		keywordKind[51] = (TK_OclMessage);
	  
	
        //
        // Rule 52:  KeyWord ::= n u l l
        //
		keywordKind[52] = (TK_null);
	  
	
        //
        // Rule 53:  KeyWord ::= O c l I n v a l i d
        //
		keywordKind[53] = (TK_OclInvalid);
	  
	
        //
        // Rule 55:  QVTKeyWord ::= e n d
        //
		keywordKind[55] = (TK_end);
	  
	
        //
        // Rule 56:  QVTKeyWord ::= w h i l e
        //
		keywordKind[56] = (TK_while);
	  
	
        //
        // Rule 57:  QVTKeyWord ::= o u t
        //
		keywordKind[57] = (TK_out);
	  
	
        //
        // Rule 58:  QVTKeyWord ::= o b j e c t
        //
		keywordKind[58] = (TK_object);
	  
	
        //
        // Rule 59:  QVTKeyWord ::= t r a n s f o r m a t i o n
        //
		keywordKind[59] = (TK_transformation);
	  
	
        //
        // Rule 60:  QVTKeyWord ::= i m p o r t
        //
		keywordKind[60] = (TK_import);
	  
	
        //
        // Rule 61:  QVTKeyWord ::= l i b r a r y
        //
		keywordKind[61] = (TK_library);
	  
	
        //
        // Rule 62:  QVTKeyWord ::= m e t a m o d e l
        //
		keywordKind[62] = (TK_metamodel);
	  
	
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
        // Rule 66:  QVTKeyWord ::= i n o u t
        //
		keywordKind[66] = (TK_inout);
	  
	
        //
        // Rule 67:  QVTKeyWord ::= w h e n
        //
		keywordKind[67] = (TK_when);
	  
	
        //
        // Rule 68:  QVTKeyWord ::= v a r
        //
		keywordKind[68] = (TK_var);
	  
	
        //
        // Rule 69:  QVTKeyWord ::= c o n f i g u r a t i o n
        //
		keywordKind[69] = (TK_configuration);
	  
	
        //
        // Rule 70:  QVTKeyWord ::= p r o p e r t y
        //
		keywordKind[70] = (TK_property);
	  
	
        //
        // Rule 71:  QVTKeyWord ::= m a p
        //
		keywordKind[71] = (TK_map);
	  
	
        //
        // Rule 72:  QVTKeyWord ::= x m a p
        //
		keywordKind[72] = (TK_xmap);
	  
	
        //
        // Rule 73:  QVTKeyWord ::= l a t e
        //
		keywordKind[73] = (TK_late);
	  
	
        //
        // Rule 74:  QVTKeyWord ::= r e s o l v e
        //
		keywordKind[74] = (TK_resolve);
	  
	
        //
        // Rule 75:  QVTKeyWord ::= r e s o l v e o n e
        //
		keywordKind[75] = (TK_resolveone);
	  
	
        //
        // Rule 76:  QVTKeyWord ::= r e s o l v e I n
        //
		keywordKind[76] = (TK_resolveIn);
	  
	
        //
        // Rule 77:  QVTKeyWord ::= r e s o l v e o n e I n
        //
		keywordKind[77] = (TK_resolveoneIn);
	  
	
        //
        // Rule 78:  QVTKeyWord ::= i n v r e s o l v e
        //
		keywordKind[78] = (TK_invresolve);
	  
	
        //
        // Rule 79:  QVTKeyWord ::= i n v r e s o l v e o n e
        //
		keywordKind[79] = (TK_invresolveone);
	  
	
        //
        // Rule 80:  QVTKeyWord ::= i n v r e s o l v e I n
        //
		keywordKind[80] = (TK_invresolveIn);
	  
	
        //
        // Rule 81:  QVTKeyWord ::= i n v r e s o l v e o n e I n
        //
		keywordKind[81] = (TK_invresolveoneIn);
	  
	
        //
        // Rule 82:  QVTKeyWord ::= m o d e l t y p e
        //
		keywordKind[82] = (TK_modeltype);
	  
	
        //
        // Rule 83:  QVTKeyWord ::= u s e s
        //
		keywordKind[83] = (TK_uses);
	  
	
        //
        // Rule 84:  QVTKeyWord ::= w h e r e
        //
		keywordKind[84] = (TK_where);
	  
	
        //
        // Rule 85:  QVTKeyWord ::= r e f i n e s
        //
		keywordKind[85] = (TK_refines);
	  
	
        //
        // Rule 86:  QVTKeyWord ::= e n f o r c i n g
        //
		keywordKind[86] = (TK_enforcing);
	  
	
        //
        // Rule 87:  QVTKeyWord ::= a c c e s s
        //
		keywordKind[87] = (TK_access);
	  
	
        //
        // Rule 88:  QVTKeyWord ::= e x t e n d s
        //
		keywordKind[88] = (TK_extends);
	  
	
        //
        // Rule 89:  QVTKeyWord ::= b l a c k b o x
        //
		keywordKind[89] = (TK_blackbox);
	  
	
        //
        // Rule 90:  QVTKeyWord ::= a b s t r a c t
        //
		keywordKind[90] = (TK_abstract);
	  
	
        //
        // Rule 91:  QVTKeyWord ::= s t a t i c
        //
		keywordKind[91] = (TK_static);
	  
	
        //
        // Rule 92:  QVTKeyWord ::= r e s u l t
        //
		keywordKind[92] = (TK_result);
	  
	
        //
        // Rule 93:  QVTKeyWord ::= m a i n
        //
		keywordKind[93] = (TK_main);
	  
	

        for (int i = 0; i < keywordKind.length; i++)
        {
            if (keywordKind[i] == 0)
                keywordKind[i] = identifierKind;
        }
    }
}

