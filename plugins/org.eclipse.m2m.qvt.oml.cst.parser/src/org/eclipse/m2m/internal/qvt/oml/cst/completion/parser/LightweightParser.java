/**
* Essential OCL Grammar
* <copyright>
*
* Copyright (c) 2005, 2010 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - Bugs 184048, 225493, 243976, 259818, 282882, 287993, 288040, 292112, 295166
*   Borland - Bug 242880
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias):
*        - 242153: LPG v 2.0.17 adoption.
*        - 299396: Introducing new LPG templates
*        - 300534: Removing the use of deprecated macros.
* </copyright>
*
* $Id: EssentialOCL.gi,v 1.5 2010/02/11 15:40:41 sboyko Exp $
*/
/**
* <copyright>
*
* Copyright (c) 2006, 2013 Borland Inc.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   Borland - Initial API and implementation
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (297966)
*   Alex Paperno - bugs 314443
*
* </copyright>
*
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
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (297966)
*   Alex Paperno - bugs 392429
*
* </copyright>
*
*/

package org.eclipse.m2m.internal.qvt.oml.cst.completion.parser;

import lpg.runtime.*;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.BooleanLiteralExpCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.CollectionLiteralExpCS;
import org.eclipse.ocl.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.cst.FeatureCallExpCS;
import org.eclipse.ocl.cst.IfExpCS;
import org.eclipse.ocl.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.cst.InvalidLiteralExpCS;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.IterateExpCS;
import org.eclipse.ocl.cst.IteratorExpCS;
import org.eclipse.ocl.cst.LetExpCS;
import org.eclipse.ocl.cst.NullLiteralExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.cst.RealLiteralExpCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TupleLiteralExpCS;
import org.eclipse.ocl.cst.TupleTypeCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.cst.VariableExpCS;	
import org.eclipse.ocl.lpg.DerivedPrsStream;

import lpg.runtime.BadParseException;
import lpg.runtime.BadParseSymFileException;
import lpg.runtime.DiagnoseParser;
import lpg.runtime.ErrorToken;
import lpg.runtime.IToken;
import lpg.runtime.ILexStream;
import lpg.runtime.Monitor;
import lpg.runtime.NullExportedSymbolsException;
import lpg.runtime.NullTerminalSymbolsException;
import lpg.runtime.ParseTable;
import lpg.runtime.RuleAction;
import lpg.runtime.UndefinedEofSymbolException;
import lpg.runtime.UnimplementedTerminalsException;	
	
import org.eclipse.ocl.ParserException;
import lpg.runtime.Token;
import lpg.runtime.BacktrackingParser;
import lpg.runtime.PrsStream;
import lpg.runtime.NotBacktrackParseTableException;
import lpg.runtime.NullExportedSymbolsException;
import lpg.runtime.NullTerminalSymbolsException;
import lpg.runtime.UndefinedEofSymbolException;
import lpg.runtime.UnimplementedTerminalsException;
import org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.LogExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.ReturnExpCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ScopedNameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ForExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeIterateExpCS;
	
import org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralPartCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingEndCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingInitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ConstructorCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ObjectExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveOpArgsExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.OppositePropertyCS;
import org.eclipse.ocl.cst.PrimitiveLiteralExpCS;
import org.eclipse.ocl.cst.LiteralExpCS;	
import org.eclipse.ocl.cst.DotOrArrowEnum;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.Environment;

import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParserprs;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOLexer;	
import org.eclipse.m2m.internal.qvt.oml.cst.parser.AbstractQVTParser;	

public class LightweightParser extends AbstractQVTParser implements RuleAction
{
    private DerivedPrsStream prsStream = null;
    
    private boolean unimplementedSymbolsWarning = false;

    private static ParseTable prsTable = new LightweightParserprs();
    @Override
    public ParseTable getParseTable() { return prsTable; }

    private BacktrackingParser btParser = null;
    public BacktrackingParser getParser() { return btParser; }

    @Override
    protected void setResult(Object object) { btParser.setSym1(object); }
    @Override
    protected Object getRhsSym(int i) { return btParser.getSym(i); }

    @Override
    protected int getRhsTokenIndex(int i) { return btParser.getToken(i); }
    @Override
    protected IToken getRhsIToken(int i) { return prsStream.getIToken(getRhsTokenIndex(i)); }
    
    @Override
    protected int getRhsFirstTokenIndex(int i) { return btParser.getFirstToken(i); }
    @Override
    protected IToken getRhsFirstIToken(int i) { return prsStream.getIToken(getRhsFirstTokenIndex(i)); }

    @Override
    protected int getRhsLastTokenIndex(int i) { return btParser.getLastToken(i); }
    @Override
    protected IToken getRhsLastIToken(int i) { return prsStream.getIToken(getRhsLastTokenIndex(i)); }

    @Override
    protected int getLeftSpan() { return btParser.getFirstToken(); }
    @Override
    protected IToken getLeftIToken()  { return prsStream.getIToken(getLeftSpan()); }

    @Override
    protected int getRightSpan() { return btParser.getLastToken(); }
    @Override
    protected IToken getRightIToken() { return prsStream.getIToken(getRightSpan()); }

    @Override
    protected int getRhsErrorTokenIndex(int i)
    {
        int index = btParser.getToken(i);
        IToken err = prsStream.getIToken(index);
        return (err instanceof ErrorToken ? index : 0);
    }
    @Override
    protected ErrorToken getRhsErrorIToken(int i)
    {
        int index = btParser.getToken(i);
        IToken err = prsStream.getIToken(index);
        return (ErrorToken) (err instanceof ErrorToken ? err : null);
    }

	@SuppressWarnings("nls") //$NON-NLS-1$
    @Override
    public void reset(ILexStream lexStream)
    {
        prsStream = new DerivedPrsStream(getEnvironment(), lexStream);
        btParser.reset(prsStream);

        try
        {
            prsStream.remapTerminalSymbols(orderedTerminalSymbols(), prsTable.getEoftSymbol());
        }
        catch(NullExportedSymbolsException e) {
        }
        catch(NullTerminalSymbolsException e) {
        }
        catch(UnimplementedTerminalsException e)
        {
            if (unimplementedSymbolsWarning) {
                java.util.ArrayList<?> unimplemented_symbols = e.getSymbols();
                System.out.println("The Lexer will not scan the following token(s):"); //$NON-NLS-1$
                for (int i = 0; i < unimplemented_symbols.size(); i++)
                {
                    Integer id = (Integer) unimplemented_symbols.get(i);
                    System.out.println("    " + LightweightParsersym.orderedTerminalSymbols[id.intValue()]);                //$NON-NLS-1$
                }
                System.out.println();
            }
        }
        catch(UndefinedEofSymbolException e)
        {
            throw new Error(new UndefinedEofSymbolException
                                ("The Lexer does not implement the Eof symbol " + //$NON-NLS-1$
                                 LightweightParsersym.orderedTerminalSymbols[prsTable.getEoftSymbol()]));
        } 
    }
    
    @SuppressWarnings("nls") //$NON-NLS-1$
    public LightweightParser(QVTOLexer lexer)        
    {
    		super(lexer);
        try
        {
            btParser = new BacktrackingParser(prsStream, prsTable, this);
        }
        catch (NotBacktrackParseTableException e)
        {
            throw new Error(new NotBacktrackParseTableException
                                ("Regenerate LightweightParserprs.java with -BACKTRACK option")); //$NON-NLS-1$
        }
        catch (BadParseSymFileException e)
        {
            throw new Error(new BadParseSymFileException("Bad Parser Symbol File -- LightweightParsersym.java")); //$NON-NLS-1$
        }
        
        ILexStream lexStream = lexer.getILexStream();
        if (lexStream != null) {
        	reset(lexStream);
        }
    }
    
    @Override
    public int numTokenKinds() { return LightweightParsersym.numTokenKinds; }
    @Override
    public String[] orderedTerminalSymbols() { return LightweightParsersym.orderedTerminalSymbols; }
    public String getTokenKindName(int kind) { return LightweightParsersym.orderedTerminalSymbols[kind]; }
    public int getEOFTokenKind() { return prsTable.getEoftSymbol(); }
    @Override
    public DerivedPrsStream getIPrsStream() { return prsStream; }

    @Override
    public CSTNode parser()
    {
        return parser(null, getDefaultRepairCount());
    }
    
    @Override
    public CSTNode parser(Monitor monitor)
    {
        return parser(monitor, getDefaultRepairCount());
    }
    
    @Override
    public CSTNode parser(int error_repair_count)
    {
        return parser(null, error_repair_count);
    }

    @Override
    public CSTNode parser(Monitor monitor, int error_repair_count)
    {
        btParser.setMonitor(monitor);
        
        try
        {
        	if (error_repair_count > 0)
            	return (CSTNode) btParser.fuzzyParse(error_repair_count);
            else
            	return (CSTNode) btParser.parse(error_repair_count);
        }
        catch (BadParseException e)
        {
            prsStream.reset(e.error_token); // point to error token

            DiagnoseParser diagnoseParser = new DiagnoseParser(prsStream, prsTable);
            diagnoseParser.diagnose(e.error_token);
        }

        return null;
    }

    //
    // Additional entry points, if any
    //
    


public Environment<?,?,?,?,?,?,?,?,?,?,?,?> getOCLEnvironment() {
	return getLexer().getOCLEnvironment();
}
	
@Override
public QVTOLexer getLexer() {
	return (QVTOLexer) super.getLexer();
}



// Some methods for backwards compatibility 
/**
* <p>
* Before 3.0, this method was used with the now-deprecated  "dollar"getToken macro (which //$NON-NLS-1$
* provided token index in the prsStream) to obtain an IToken f a rule given the index of the
* right hand side token in the said rule. In 3.0 a convenience method has been introduced
* in order to directly return the IToken, given the index of the right hand side token in the rule.
* </p> 
*
* <p>
* In an action-block of a rule, instead of doing <code>getIToken("dollar"getToken(i))</code>  //$NON-NLS-1$
* you should do <code>getRhsTokenText(i)</code>
* </p>
* @param i the right hand side token index
* @return the correspondent IToken.
*
* @since 3.0	
*/
@Deprecated
protected IToken getIToken(int i) {
	return prsStream.getIToken(i);
}

/**
* <p>
* Before 3.0, this method was used with the now-deprecated "dollar"getToken macro (which //$NON-NLS-1$
* provided token index in the prsStream) to obtain an IToken f a rule given the index of the
* right hand side token in the said rule. In 3.0 a convenience method has been introduced
* in order to directly return the IToken, given the index of the right hand side token in the rule.
* </p> 
* 
* <p>
* In an action-block of a rule, instead of doing <code>getTokenText("dollar"getToken(i))</code>  //$NON-NLS-1$
* you should do <code>getRhsTokenText(i)</code>
* </p>
* @param i the right hand side token index
* @result the text of the correspondent right hand side IToken.
*/
@Deprecated
protected String getTokenText(int i) {
	return prsStream.getTokenText(i);
}

/**
* A convenience method to obtain the text of a right hand side IToken.
*  
* @param i the right hand side token index
* @result the text of the correspondent right hand side IToken.
*
* @since 3.0
*/
protected String getRhsTokenText(int i) { 
	return prsStream.getTokenText(getRhsTokenIndex(i));
}

	@SuppressWarnings("unchecked")
	private static final EList ourEmptyEList = new BasicEList.UnmodifiableEList(0, new Object[0]);								
							
	
	private void diagnozeErrorToken(int token_index) {
		//IToken token = getIToken(token_index);
		//if (token instanceof lpg.runtime.ErrorToken) {
		//	token = ((lpg.runtime.ErrorToken) token).getErrorToken();
		//}			
		//reportError(lpg.runtime.ParseErrorCodes.MISPLACED_CODE, token.getTokenIndex(), token.getTokenIndex(),  
		//		"'" +  //$NON-NLS-1$
		//		token.toString() + "'"); //$NON-NLS-1$

		prsStream.reset(token_index); // point to error token
		DiagnoseParser diagnoseParser = new DiagnoseParser(prsStream, prsTable);
		diagnoseParser.diagnose(token_index);
		setResult(null);
	}

	@SuppressWarnings("unchecked")
    public void ruleAction(int ruleNumber)
    {
        switch (ruleNumber)
        {

            //
            // Rule 16:  conceptualOperationNameCS ::= conceptualOperationName
            //
            case 16: {
               //#line 296 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createConceptualOperationNameCS(iToken);
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
     
            //
            // Rule 28:  tupleKeywordCS ::= Tuple
            //
            
            case 28:

            //
            // Rule 29:  reservedKeywordCS ::= reservedKeyword
            //
            case 29: {
               //#line 319 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            iToken
                        );
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 33:  selfKeywordCS ::= self
            //
            case 33: {
               //#line 338 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createSimpleNameCS(
                        SimpleTypeEnum.SELF_LITERAL,
                        iToken
                    );
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 34:  simpleNameCS ::= IDENTIFIER
            //
            case 34: {
               //#line 350 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createSimpleNameCS(
                        SimpleTypeEnum.IDENTIFIER_LITERAL,
                        iToken
                    );
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 36:  QuotedSimpleNameCS ::= QUOTED_IDENTIFIER
            //
            case 36: {
               //#line 362 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createQuotedSimpleNameCS(
                        SimpleTypeEnum.IDENTIFIER_LITERAL,
                        iToken
                    );
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 37:  QuotedSimpleNameCS ::= QuotedSimpleNameCS STRING_LITERAL
            //
            case 37: {
               //#line 373 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS string = (SimpleNameCS)getRhsSym(1);
                IToken literalToken = getRhsIToken(2);
                SimpleNameCS result = extendQuotedSimpleNameCS(string, literalToken);
                setOffsets(result, string, literalToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 40:  pathNameCS ::= simpleNameCS
            //
            case 40: {
               //#line 386 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleName = (SimpleNameCS)getRhsSym(1);
                PathNameCS result = createPathNameCS(simpleName);
                setOffsets(result, simpleName);
                setResult(result);
                      break;
            }
    
            //
            // Rule 41:  pathNameCS ::= pathNameCS :: unreservedSimpleNameCS
            //
            case 41: {
               //#line 394 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PathNameCS result = (PathNameCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                result = extendPathNameCS(result, simpleNameCS);
                setOffsets(result, result, simpleNameCS);
                setResult(result);
                      break;
            }
    
            //
            // Rule 42:  primitiveTypeCS ::= Boolean
            //
            case 42: {
               //#line 407 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.BOOLEAN_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 43:  primitiveTypeCS ::= Integer
            //
            case 43: {
               //#line 417 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.INTEGER_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 44:  primitiveTypeCS ::= Real
            //
            case 44: {
               //#line 427 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.REAL_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 45:  primitiveTypeCS ::= String
            //
            case 45: {
               //#line 437 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.STRING_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 46:  primitiveTypeCS ::= UnlimitedNatural
            //
            case 46: {
               //#line 447 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 47:  primitiveTypeCS ::= OclAny
            //
            case 47: {
               //#line 458 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_ANY_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 48:  primitiveTypeCS ::= OclInvalid
            //
            case 48: {
               //#line 468 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_INVALID_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 49:  primitiveTypeCS ::= OclVoid
            //
            case 49: {
               //#line 478 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_VOID_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 50:  CollectionTypeIdentifierCS ::= Set
            //
            case 50: {
               //#line 489 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.SET_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 51:  CollectionTypeIdentifierCS ::= Bag
            //
            case 51: {
               //#line 499 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.BAG_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 52:  CollectionTypeIdentifierCS ::= Sequence
            //
            case 52: {
               //#line 509 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.SEQUENCE_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 53:  CollectionTypeIdentifierCS ::= Collection
            //
            case 53: {
               //#line 519 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.COLLECTION_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 54:  CollectionTypeIdentifierCS ::= OrderedSet
            //
            case 54: {
               //#line 529 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 59:  collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS )
            //
            case 59: {
               //#line 545 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CollectionTypeCS result = (CollectionTypeCS)getRhsSym(1);
                result.setTypeCS((TypeCS)getRhsSym(3));
                setOffsets(result, result, getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 60:  tupleTypeCS ::= Tuple ( tupleTypePartsCSopt )
            //
            case 60: {
               //#line 554 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                 TupleTypeCS result = createTupleTypeCS((EList<VariableCS>)getRhsSym(3));
                setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 61:  tupleTypePartsCSopt ::= $Empty
            //
            case 61: {
               //#line 562 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                setResult(new BasicEList<VariableCS>());
                      break;
            }
    
            //
            // Rule 63:  tupleTypePartsCS ::= typedUninitializedVariableCS
            //
            case 63: {
               //#line 569 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 64:  tupleTypePartsCS ::= tupleTypePartsCS , typedUninitializedVariableCS
            //
            case 64: {
               //#line 576 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                result.add((VariableCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 65:  untypedUninitializedVariableCS ::= simpleNameCS
            //
            case 65: {
               //#line 587 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                VariableCS result = createVariableCS(name, null, null);
                setOffsets(result, name);
                setResult(result);
                      break;
            }
    
            //
            // Rule 66:  typedUninitializedVariableCS ::= simpleNameCS : typeCS
            //
            case 66: {
               //#line 596 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                TypeCS type = (TypeCS)getRhsSym(3);
                VariableCS result = createVariableCS(name, type, null);
                setOffsets(result, name, type);
                setResult(result);
                      break;
            }
    
            //
            // Rule 67:  untypedInitializedVariableCS ::= simpleNameCS = OclExpressionCS
            //
            case 67: {
               //#line 606 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                OCLExpressionCS initExpression = (OCLExpressionCS)getRhsSym(3);
                VariableCS result = createVariableCS(name, null, initExpression);
                setOffsets(result, name, initExpression);
                setResult(result);
                      break;
            }
    
            //
            // Rule 68:  typedInitializedVariableCS ::= simpleNameCS : typeCS = OclExpressionCS
            //
            case 68: {
               //#line 616 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                TypeCS type = (TypeCS)getRhsSym(3);
                OCLExpressionCS initExpression = (OCLExpressionCS)getRhsSym(5);
                VariableCS result = createVariableCS(name, type, initExpression);
                setOffsets(result, name, initExpression);
                setResult(result);
                      break;
            }
    
            //
            // Rule 80:  CollectionLiteralExpCS ::= CollectionTypeIdentifierCS { CollectionLiteralPartsCSopt }
            //
            case 80: {
               //#line 649 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CollectionTypeCS typeCS = (CollectionTypeCS)getRhsSym(1);
                CollectionLiteralExpCS result = createCollectionLiteralExpCS(
                        typeCS,
                        (EList<CollectionLiteralPartCS>)getRhsSym(3)
                    );
                setOffsets(result, typeCS, getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 81:  CollectionLiteralPartsCSopt ::= $Empty
            //
            case 81: {
               //#line 672 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                setResult(new BasicEList<CollectionLiteralPartCS>());
                      break;
            }
    
            //
            // Rule 83:  CollectionLiteralPartsCS ::= CollectionLiteralPartCS
            //
            case 83: {
               //#line 679 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<CollectionLiteralPartCS> result = new BasicEList<CollectionLiteralPartCS>();
                result.add((CollectionLiteralPartCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 84:  CollectionLiteralPartsCS ::= CollectionLiteralPartsCS , CollectionLiteralPartCS
            //
            case 84: {
               //#line 686 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<CollectionLiteralPartCS> result = (EList<CollectionLiteralPartCS>)getRhsSym(1);
                result.add((CollectionLiteralPartCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 86:  CollectionLiteralPartCS ::= OclExpressionCS
            //
            case 86: {
               //#line 695 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CollectionLiteralPartCS result = createCollectionLiteralPartCS(
                        (OCLExpressionCS)getRhsSym(1)
                    );
                setOffsets(result, (CSTNode)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 87:  CollectionRangeCS ::= OclExpressionCS .. OclExpressionCS
            //
            case 87: {
               //#line 705 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CollectionLiteralPartCS result = createCollectionRangeCS(
                        (OCLExpressionCS)getRhsSym(1),
                        (OCLExpressionCS)getRhsSym(3)
                    );
                setOffsets(result, (CSTNode)getRhsSym(1), (CSTNode)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 95:  TupleLiteralExpCS ::= Tuple { TupleLiteralPartsCS }
            //
            case 95: {
               //#line 724 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                TupleLiteralExpCS result = createTupleLiteralExpCS((EList<VariableCS>)getRhsSym(3));
                setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 96:  TupleLiteralPartsCS ::= initializedVariableCS
            //
            case 96: {
               //#line 732 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 97:  TupleLiteralPartsCS ::= TupleLiteralPartsCS , initializedVariableCS
            //
            case 97: {
               //#line 739 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                result.add((VariableCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 98:  IntegerLiteralExpCS ::= INTEGER_LITERAL
            //
            case 98: {
               //#line 747 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IntegerLiteralExpCS result = createIntegerLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 99:  RealLiteralExpCS ::= REAL_LITERAL
            //
            case 99: {
               //#line 755 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                RealLiteralExpCS result = createRealLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 100:  StringLiteralExpCS ::= STRING_LITERAL
            //
            case 100: {
               //#line 763 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IToken literalToken = getRhsIToken(1);
                StringLiteralExpCS result = createStringLiteralExpCS(literalToken);
                setOffsets(result, literalToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 101:  StringLiteralExpCS ::= StringLiteralExpCS STRING_LITERAL
            //
            case 101: {
               //#line 771 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                StringLiteralExpCS string = (StringLiteralExpCS)getRhsSym(1);
                IToken literalToken = getRhsIToken(2);
                StringLiteralExpCS result = extendStringLiteralExpCS(string, literalToken);
                setOffsets(result, string, literalToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 102:  BooleanLiteralExpCS ::= true
            //
            case 102: {
               //#line 781 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                BooleanLiteralExpCS result = createBooleanLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 103:  BooleanLiteralExpCS ::= false
            //
            case 103: {
               //#line 788 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                BooleanLiteralExpCS result = createBooleanLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 104:  UnlimitedNaturalLiteralExpCS ::= *
            //
            case 104: {
               //#line 796 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                UnlimitedNaturalLiteralExpCS result = createUnlimitedNaturalLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 105:  InvalidLiteralExpCS ::= invalid
            //
            case 105: {
               //#line 804 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                InvalidLiteralExpCS result = createInvalidLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 106:  NullLiteralExpCS ::= null
            //
            case 106: {
               //#line 812 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                NullLiteralExpCS result = createNullLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
     
            //
            // Rule 107:  TypeLiteralExpCS ::= primitiveTypeCS
            //
            
            case 107:
 
            //
            // Rule 108:  TypeLiteralExpCS ::= collectionTypeCS
            //
            
            case 108:

            //
            // Rule 109:  TypeLiteralExpCS ::= tupleTypeCS
            //
            case 109: {
               //#line 826 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                setResult(result);
                      break;
            }
    
            //
            // Rule 114:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( uninitializedVariableCS | OclExpressionCS )
            //
            case 114: {
               //#line 851 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IteratorExpCS result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)getRhsSym(5),
                        null,
                        (OCLExpressionCS)getRhsSym(7)
                    );
                setOffsets(result, source, getRhsIToken(8));
                setResult(result);
                      break;
            }
    
            //
            // Rule 115:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( simpleNameCS , uninitializedVariableCS | OclExpressionCS )
            //
            case 115: {
               //#line 868 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(5);
                VariableCS variableCS = createVariableCS(name, null, null);
                setOffsets(variableCS, name);
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IteratorExpCS result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        variableCS,
                        (VariableCS)getRhsSym(7),
                        (OCLExpressionCS)getRhsSym(9)
                    );
                setOffsets(result, source, getRhsIToken(10));
                setResult(result);
                      break;
            }
    
            //
            // Rule 116:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( typedUninitializedVariableCS , uninitializedVariableCS | OclExpressionCS )
            //
            case 116: {
               //#line 888 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IteratorExpCS result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)getRhsSym(5),
                        (VariableCS)getRhsSym(7),
                        (OCLExpressionCS)getRhsSym(9)
                    );
                setOffsets(result, source, getRhsIToken(10));
                setResult(result);
                      break;
            }
    
            //
            // Rule 117:  IterateExpCS ::= primaryExpCS -> simpleNameCS ( typedInitializedVariableCS | OclExpressionCS )
            //
            case 117: {
               //#line 909 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IterateExpCS result = createIterateExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)getRhsSym(5),
                        null,
                        (OCLExpressionCS)getRhsSym(7)
                    );
                setOffsets(result, source, getRhsIToken(8));
                setResult(result);
                      break;
            }
    
            //
            // Rule 118:  IterateExpCS ::= primaryExpCS -> simpleNameCS ( uninitializedVariableCS ; typedInitializedVariableCS | OclExpressionCS )
            //
            case 118: {
               //#line 925 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IterateExpCS result = createIterateExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)getRhsSym(5),
                        (VariableCS)getRhsSym(7),
                        (OCLExpressionCS)getRhsSym(9)
                    );
                setOffsets(result, source, getRhsIToken(10));
                setResult(result);
                      break;
            }
    
            //
            // Rule 122:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( )
            //
            case 122: {
               //#line 947 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                OperationCallExpCS result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)getRhsSym(3),
                        null,
                        new BasicEList<OCLExpressionCS>()
                    );
                setOffsets(result, source, getRhsIToken(5));
                setResult(result);
                      break;
            }
    
            //
            // Rule 123:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( OclExpressionCS )
            //
            case 123: {
               //#line 961 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                OCLExpressionCS arg = (OCLExpressionCS)getRhsSym(5);
                OCLExpressionCS result;
                if (isIterator(simpleNameCS.getValue())) {
                    result = createIteratorExpCS(
                            source,
                            simpleNameCS,
                            null,
                            null,
                            arg
                        );
                }
                else {
                    EList<OCLExpressionCS> args = new BasicEList<OCLExpressionCS>();
                    args.add(arg);
                    result = createArrowOperationCallExpCS(
                            source,
                            simpleNameCS,
                            null,
                            args
                        );
                }
                setOffsets(result, source, getRhsIToken(6));
                setResult(result);
                      break;
            }
    
            //
            // Rule 124:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( notNameExpressionCS , argumentsCS )
            //
            case 124: {
               //#line 991 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<OCLExpressionCS> args = (EList<OCLExpressionCS>)getRhsSym(7);
                args.add(0, (OCLExpressionCS)getRhsSym(5));
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                OperationCallExpCS result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)getRhsSym(3),
                        null,
                        args
                    );
                setOffsets(result, source, getRhsIToken(8));
                setResult(result);
                      break;
            }
    
            //
            // Rule 125:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( simpleNameCS , argumentsCS )
            //
            case 125: {
               //#line 1007 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(5);
                OCLExpressionCS variableExpCS = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(variableExpCS, simpleNameCS);
                EList<OCLExpressionCS> args = (EList<OCLExpressionCS>)getRhsSym(7);
                args.add(0, variableExpCS);
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                OperationCallExpCS result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)getRhsSym(3),
                        null,
                        args
                    );
                setOffsets(result, source, getRhsIToken(8));
                setResult(result);
                      break;
            }
     
            //
            // Rule 126:  OperationCallExpCS ::= primaryExpCS . conceptualOperationNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            
            case 126:

            //
            // Rule 127:  OperationCallExpCS ::= primaryExpCS . simpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 127: {
               //#line 1033 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                CallExpCS result = createDotOperationCallExpCS(
                        source,
                        null,
                        simpleNameCS,
                        (IsMarkedPreCS)getRhsSym(4),
                        (EList<OCLExpressionCS>)getRhsSym(6)
                    );
                setOffsets(result, source, getRhsIToken(7));
                setResult(result);
                      break;
            }
    
            //
            // Rule 128:  OperationCallExpCS ::= simpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 128: {
               //#line 1049 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OperationCallExpCS result = createDotOperationCallExpCS(
                        null,
                        null,
                        (SimpleNameCS)getRhsSym(1),
                        (IsMarkedPreCS)getRhsSym(2),
                        (EList<OCLExpressionCS>)getRhsSym(4)
                    );
                setOffsets(result, getRhsIToken(1), getRhsIToken(5));
                setResult(result);
                      break;
            }
    
            //
            // Rule 129:  OperationCallExpCS ::= pathNameCS :: unreservedSimpleNameCS ( argumentsCSopt )
            //
            case 129: {
               //#line 1063 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PathNameCS pathNameCS = (PathNameCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                OperationCallExpCS result = createDotOperationCallExpCS(
                        null,
                        pathNameCS,
                        simpleNameCS,
                        null,
                        (EList<OCLExpressionCS>)getRhsSym(5)
                    );
                setOffsets(result, pathNameCS, getRhsIToken(6));
                setResult(result);
                      break;
            }
    
            //
            // Rule 130:  OperationCallExpCS ::= primaryExpCS . pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 130: {
               //#line 1081 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PathNameCS pathNameCS = (PathNameCS)getRhsSym(3);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(5);
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                CallExpCS result = createDotOperationCallExpCS(
                        source,
                        pathNameCS,
                        simpleNameCS,
                        (IsMarkedPreCS)getRhsSym(6),
                        (EList<OCLExpressionCS>)getRhsSym(8)
                    );
                setOffsets(result, source, getRhsIToken(9));
                setResult(result);
                      break;
            }
    
            //
            // Rule 132:  PropertyCallExpCS ::= pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt
            //
            case 132: {
               //#line 1105 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PathNameCS pathNameCS = (PathNameCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(4);
                FeatureCallExpCS result = createFeatureCallExpCS(
                        null,
                        pathNameCS,
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        isMarkedPreCS
                    );
                if (isMarkedPreCS != null) {
                    setOffsets(result, pathNameCS, isMarkedPreCS);
                } else {
                    setOffsets(result, pathNameCS, simpleNameCS);
                }
                setResult(result);
                      break;
            }
    
            //
            // Rule 133:  PropertyCallExpCS ::= primaryExpCS . pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt
            //
            case 133: {
               //#line 1126 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                PathNameCS pathNameCS = (PathNameCS)getRhsSym(3);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(5);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(6);
                FeatureCallExpCS result = createFeatureCallExpCS(
                        source,
                        pathNameCS,
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        isMarkedPreCS
                    );
                if (isMarkedPreCS != null) {
                    setOffsets(result, source, isMarkedPreCS);
                } else {
                    setOffsets(result, source, simpleNameCS);
                }
                setResult(result);
                      break;
            }
    
            //
            // Rule 134:  AssociationClassCallExpCS ::= primaryExpCS . simpleNameCS isMarkedPreCSopt
            //
            case 134: {
               //#line 1149 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(4);
                FeatureCallExpCS result = createFeatureCallExpCS(
                        source,
                        null,
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        isMarkedPreCS
                    );
                if (isMarkedPreCS != null) {
                    setOffsets(result, source, isMarkedPreCS);
                } else {
                    setOffsets(result, source, simpleNameCS);
                }
                setResult(result);
                      break;
            }
    
            //
            // Rule 135:  isMarkedPreCSopt ::= $Empty
            //
            case 135: {
               //#line 1211 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                setResult(null);
                      break;
            }
    
            //
            // Rule 136:  argumentsCSopt ::= $Empty
            //
            case 136: {
               //#line 1217 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                setResult(new BasicEList<OCLExpressionCS>());
                      break;
            }
    
            //
            // Rule 138:  argumentsCS ::= OclExpressionCS
            //
            case 138: {
               //#line 1224 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<OCLExpressionCS> result = new BasicEList<OCLExpressionCS>();
                result.add((OCLExpressionCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 139:  argumentsCS ::= argumentsCS , OclExpressionCS
            //
            case 139: {
               //#line 1231 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<OCLExpressionCS> result = (EList<OCLExpressionCS>)getRhsSym(1);
                result.add((OCLExpressionCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 142:  VariableExpCS ::= selfKeywordCS
            //
            case 142: {
               //#line 1256 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                setResult(result);
                      break;
            }
    
            //
            // Rule 143:  SimpleNameExpCS ::= simpleNameCS
            //
            case 143: {
               //#line 1271 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                setResult(result);
                      break;
            }
     
            //
            // Rule 149:  impliesNotNameNotLetCS ::= impliesNotLetCS implies xorNotLetCS
            //
            
            case 149:
 
            //
            // Rule 151:  impliesWithLetCS ::= impliesNotLetCS implies xorWithLetCS
            //
            
            case 151:
 
            //
            // Rule 155:  xorNotNameNotLetCS ::= xorNotLetCS xor orNotLetCS
            //
            
            case 155:
 
            //
            // Rule 157:  xorWithLetCS ::= xorNotLetCS xor orWithLetCS
            //
            
            case 157:
 
            //
            // Rule 161:  orNotNameNotLetCS ::= orNotLetCS or andNotLetCS
            //
            
            case 161:
 
            //
            // Rule 163:  orWithLetCS ::= orNotLetCS or andWithLetCS
            //
            
            case 163:
 
            //
            // Rule 167:  andNotNameNotLetCS ::= andNotLetCS and equalityNotLetCS
            //
            
            case 167:
 
            //
            // Rule 169:  andWithLetCS ::= andNotLetCS and equalityWithLetCS
            //
            
            case 169:
 
            //
            // Rule 173:  equalityNotNameNotLetCS ::= equalityNotLetCS = relationalNotLetCS
            //
            
            case 173:
 
            //
            // Rule 174:  equalityNotNameNotLetCS ::= equalityNotLetCS <> relationalNotLetCS
            //
            
            case 174:
 
            //
            // Rule 176:  equalityWithLetCS ::= equalityNotLetCS = relationalWithLetCS
            //
            
            case 176:
 
            //
            // Rule 177:  equalityWithLetCS ::= equalityNotLetCS <> relationalWithLetCS
            //
            
            case 177:
 
            //
            // Rule 181:  relationalNotNameNotLetCS ::= relationalNotLetCS > additiveNotLetCS
            //
            
            case 181:
 
            //
            // Rule 182:  relationalNotNameNotLetCS ::= relationalNotLetCS < additiveNotLetCS
            //
            
            case 182:
 
            //
            // Rule 183:  relationalNotNameNotLetCS ::= relationalNotLetCS >= additiveNotLetCS
            //
            
            case 183:
 
            //
            // Rule 184:  relationalNotNameNotLetCS ::= relationalNotLetCS <= additiveNotLetCS
            //
            
            case 184:
 
            //
            // Rule 186:  relationalWithLetCS ::= relationalNotLetCS > additiveWithLetCS
            //
            
            case 186:
 
            //
            // Rule 187:  relationalWithLetCS ::= relationalNotLetCS < additiveWithLetCS
            //
            
            case 187:
 
            //
            // Rule 188:  relationalWithLetCS ::= relationalNotLetCS >= additiveWithLetCS
            //
            
            case 188:
 
            //
            // Rule 189:  relationalWithLetCS ::= relationalNotLetCS <= additiveWithLetCS
            //
            
            case 189:
 
            //
            // Rule 193:  additiveNotNameNotLetCS ::= additiveNotLetCS + multiplicativeNotLetCS
            //
            
            case 193:
 
            //
            // Rule 194:  additiveNotNameNotLetCS ::= additiveNotLetCS - multiplicativeNotLetCS
            //
            
            case 194:
 
            //
            // Rule 196:  additiveWithLetCS ::= additiveNotLetCS + multiplicativeWithLetCS
            //
            
            case 196:
 
            //
            // Rule 197:  additiveWithLetCS ::= additiveNotLetCS - multiplicativeWithLetCS
            //
            
            case 197:
 
            //
            // Rule 201:  multiplicativeNotNameNotLetCS ::= multiplicativeNotLetCS * unaryNotLetCS
            //
            
            case 201:
 
            //
            // Rule 202:  multiplicativeNotNameNotLetCS ::= multiplicativeNotLetCS / unaryNotLetCS
            //
            
            case 202:
 
            //
            // Rule 204:  multiplicativeWithLetCS ::= multiplicativeNotLetCS * unaryWithLetCS
            //
            
            case 204:

            //
            // Rule 205:  multiplicativeWithLetCS ::= multiplicativeNotLetCS / unaryWithLetCS
            //
            case 205: {
               //#line 1380 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            getRhsIToken(2)
                        );
                setOffsets(simpleNameCS, getRhsIToken(2));
                OCLExpressionCS left = (OCLExpressionCS)getRhsSym(1);
                OCLExpressionCS right = (OCLExpressionCS)getRhsSym(3);
                EList<OCLExpressionCS> args = new BasicEList<OCLExpressionCS>();
                args.add(right);
                OperationCallExpCS result = createOperationCallExpCS(
                        left,
                        simpleNameCS,
                        args
                    );
                setOffsets(result, left, right);
                setResult(result);
                      break;
            }
     
            //
            // Rule 209:  unaryNotNameNotLetCS ::= - unaryNotLetCS
            //
            
            case 209:
 
            //
            // Rule 210:  unaryNotNameNotLetCS ::= not unaryNotLetCS
            //
            
            case 210:
 
            //
            // Rule 212:  unaryWithLetCS ::= - unaryWithLetCS
            //
            
            case 212:

            //
            // Rule 213:  unaryWithLetCS ::= not unaryWithLetCS
            //
            case 213: {
               //#line 1411 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            getRhsIToken(1)
                        );
                setOffsets(simpleNameCS, getRhsIToken(1));
                OCLExpressionCS expr = (OCLExpressionCS)getRhsSym(2);
                OperationCallExpCS result = createOperationCallExpCS(
                        expr,
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>()
                    );
                setOffsets(result, simpleNameCS, expr);
                setResult(result);
                      break;
            }
    
            //
            // Rule 220:  primaryNotNameCS ::= ( OclExpressionCS )
            //
            case 220: {
               //#line 1437 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS result = (OCLExpressionCS)getRhsSym(2);
                if (result instanceof OperationCallExpCS) {
                    ((OperationCallExpCS)result).setIsAtomic(true);
                }
                setOffsets(result, getRhsIToken(1), getRhsIToken(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 221:  LetExpCS ::= let letVariablesCS in OclExpressionCS
            //
            case 221: {
               //#line 1460 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS expr = (OCLExpressionCS)getRhsSym(4);
                LetExpCS result = createLetExpCS(
                        (EList<VariableCS>)getRhsSym(2),
                        expr
                    );
                setOffsets(result, getRhsIToken(1), expr);
                setResult(result);
                      break;
            }
    
            //
            // Rule 222:  letVariablesCS ::= typedInitializedVariableCS
            //
            case 222: {
               //#line 1472 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 223:  letVariablesCS ::= letVariablesCS , typedInitializedVariableCS
            //
            case 223: {
               //#line 1479 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                result.add((VariableCS)getRhsSym(3));
                setResult(result);
                      break;
            }
     
            //
            // Rule 224:  LiteralExpCS ::= primitiveTypeCS
            //
            
            case 224:
 
            //
            // Rule 225:  LiteralExpCS ::= collectionTypeCS
            //
            
            case 225:

            //
            // Rule 226:  LiteralExpCS ::= tupleTypeCS
            //
            case 226: {
               //#line 164 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                setResult((TypeCS) getRhsSym(1));
                      break;
            }
    
            //
            // Rule 228:  listTypeCS ::= List ( typeCS )
            //
            case 228: {
               //#line 172 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createListTypeCS(
						(TypeCS)getRhsSym(3)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 229:  listLiteralCS ::= List { CollectionLiteralPartsCSopt }
            //
            case 229: {
               //#line 182 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createListLiteralExpCS((EList)getRhsSym(3));
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 231:  dictTypeCS ::= Dict ( typeCS , typeCS )
            //
            case 231: {
               //#line 191 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createDictTypeCS((TypeCS)getRhsSym(3), (TypeCS)getRhsSym(5));
				setOffsets(result, getRhsIToken(1), getRhsIToken(6));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 232:  dictLiteralCS ::= Dict { dictLiteralPartListCSopt }
            //
            case 232: {
               //#line 199 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createDictLiteralExpCS((EList<DictLiteralPartCS>)getRhsSym(3));
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 236:  dictLiteralPartCS ::= literalSimpleCS = OclExpressionCS
            //
            case 236: {
               //#line 211 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createDictLiteralPartCS((LiteralExpCS)getRhsSym(1), (OCLExpressionCS)getRhsSym(3));
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 238:  dictLiteralPartListCSopt ::= $Empty
            //
            
            case 238:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 239:  dictLiteralPartListCS ::= dictLiteralPartCS
            //
            case 239: {
               //#line 223 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 240:  dictLiteralPartListCS ::= dictLiteralPartListCS , dictLiteralPartCS
            //
            case 240: {
               //#line 230 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 241:  dictLiteralPartListCS ::= dictLiteralPartListCS qvtErrorToken
            //
            case 241: {
               //#line 237 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 243:  returnExpCS ::= return oclExpressionCSOpt
            //
            case 243: {
               //#line 245 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			ReturnExpCS returnExpCS = createReturnExpCS((OCLExpressionCS)getRhsSym(2));
			CSTNode result = createExpressionStatementCS(returnExpCS);
			if(returnExpCS.getValue() != null) {
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(2));			
			} else {
				setOffsets(result, getRhsIToken(1));
			}
			setOffsets(returnExpCS, result);
			setResult(result);
	                  break;
            }
	
            //
            // Rule 245:  oclExpressionCSOpt ::= $Empty
            //
            case 245:
                setResult(null);
                break;

            //
            // Rule 247:  var_init_group_exp ::= var var_init_declarator_list
            //
            case 247: {
               //#line 265 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(getRhsSym(2));
	                  break;
            }
	
            //
            // Rule 248:  var_init_group_exp ::= var ( var_init_declarator_list )
            //
            case 248: {
               //#line 271 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(getRhsSym(3));
	                  break;
            }
	
            //
            // Rule 249:  var_init_group_exp ::= var ( var_init_declarator_list qvtErrorToken
            //
            case 249: {
               //#line 277 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(getRhsSym(3));
	                  break;
            }
	
            //
            // Rule 251:  var_init_exp ::= var var_init_declarator
            //
            case 251: {
               //#line 285 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(getRhsSym(2));
	                  break;
            }
	
            //
            // Rule 252:  var_init_exp ::= var ( var_init_declarator )
            //
            case 252: {
               //#line 291 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(getRhsSym(3));
	                  break;
            }
	
            //
            // Rule 253:  var_init_exp ::= var ( var_init_declarator qvtErrorToken
            //
            case 253: {
               //#line 297 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(getRhsSym(3));
	                  break;
            }
	
            //
            // Rule 254:  var_init_exp ::= var qvtErrorToken
            //
            case 254: {
               //#line 303 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(ourEmptyEList);
	                  break;
            }
	
            //
            // Rule 255:  var_init_declarator_list ::= var_init_declarator , var_init_declarator
            //
            case 255: {
               //#line 309 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add(getRhsSym(1));
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 256:  var_init_declarator_list ::= var_init_declarator_list , var_init_declarator
            //
            case 256: {
               //#line 317 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 257:  var_init_declarator ::= IDENTIFIER : typeCS var_init_op OclExpressionCS
            //
            case 257: {
               //#line 326 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableInitializationCS(
						getRhsIToken(1),
						(TypeCS)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(5),
						(Boolean)getRhsSym(4)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 258:  var_init_declarator ::= IDENTIFIER : typeCS var_init_op qvtErrorToken
            //
            case 258: {
               //#line 338 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableInitializationCS(
						getRhsIToken(1),
						(TypeCS)getRhsSym(3),
						null,
						(Boolean)getRhsSym(4)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 259:  var_init_declarator ::= IDENTIFIER var_init_op OclExpressionCS
            //
            case 259: {
               //#line 350 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableInitializationCS(
						getRhsIToken(1),
						null,
						(OCLExpressionCS)getRhsSym(3),
						(Boolean)getRhsSym(2)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 260:  var_init_declarator ::= IDENTIFIER var_init_op qvtErrorToken
            //
            case 260: {
               //#line 362 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableInitializationCS(
						getRhsIToken(1),
						null,
						null,
						(Boolean)getRhsSym(2)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 261:  var_init_declarator ::= IDENTIFIER : typeCS
            //
            case 261: {
               //#line 374 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableInitializationCS(
						getRhsIToken(1),
						(TypeCS)getRhsSym(3),
						null,
						false
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 262:  var_init_declarator ::= IDENTIFIER : qvtErrorToken
            //
            case 262: {
               //#line 386 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableInitializationCS(
						getRhsIToken(1),
						null,
						null,
						false
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(2));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 263:  var_init_op ::= =
            //
            
            case 263:

            //
            // Rule 264:  var_init_op ::= :=
            //
            case 264: {
               //#line 401 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(false);
	                  break;
            }
	
            //
            // Rule 265:  var_init_op ::= ::=
            //
            case 265: {
               //#line 406 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(true);
	                  break;
            }
	
            //
            // Rule 267:  assignStatementCS ::= primaryExpCS := OclExpressionCS
            //
            case 267: {
               //#line 414 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createAssignStatementCS(
						(OCLExpressionCS)getRhsSym(1),
						(OCLExpressionCS)getRhsSym(3),
						false
					);
				setOffsets(result, (CSTNode)getRhsSym(1), (CSTNode)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 268:  assignStatementCS ::= primaryExpCS := qvtErrorToken
            //
            case 268: {
               //#line 425 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createAssignStatementCS(
						(OCLExpressionCS)getRhsSym(1),
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, (IToken) null),
						false
					);
				setOffsets(result, (CSTNode)getRhsSym(1), getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 269:  assignStatementCS ::= primaryExpCS += OclExpressionCS
            //
            case 269: {
               //#line 437 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createAssignStatementCS(
						(OCLExpressionCS)getRhsSym(1),
						(OCLExpressionCS)getRhsSym(3),
						true
					);
				setOffsets(result, (CSTNode)getRhsSym(1), (CSTNode)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 270:  assignStatementCS ::= primaryExpCS += qvtErrorToken
            //
            case 270: {
               //#line 448 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createAssignStatementCS(
						(OCLExpressionCS)getRhsSym(1),
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, (IToken) null),
						true
					);
				setOffsets(result, (CSTNode)getRhsSym(1), getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 272:  whileExpCS ::= while ( declarator1 ; OclExpressionCS ) whileBodyCS
            //
            case 272: {
               //#line 464 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createWhileExpCS(
						(VariableCS)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(5),
						(BlockExpCS)getRhsSym(7)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 273:  whileExpCS ::= while ( assignStatementCS ; OclExpressionCS ) whileBodyCS
            //
            case 273: {
               //#line 476 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				AssignStatementCS assignment = (AssignStatementCS)getRhsSym(3);
				CSTNode result = createWhileExpCS(
						getVariableFromAssignment(assignment),
						(OCLExpressionCS)getRhsSym(5),
						(BlockExpCS)getRhsSym(7)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 274:  whileExpCS ::= while ( OclExpressionCS ) whileBodyCS
            //
            case 274: {
               //#line 489 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createWhileExpCS(
						null,
						(OCLExpressionCS)getRhsSym(3),
						(BlockExpCS)getRhsSym(5)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 275:  IteratorExpCS ::= primaryExpCS -> forExpCS
            //
            case 275: {
               //#line 503 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
				ForExpCS forExpCS = (ForExpCS)getRhsSym(3);
				forExpCS.setSource(source);
				setOffsets(forExpCS, source, forExpCS);
				setResult(forExpCS);
	                  break;
            }
	
            //
            // Rule 276:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( qvtErrorToken
            //
            case 276: {
               //#line 513 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
				CSTNode result = createIteratorExpCS(
						source,
						simpleNameCS,
						null,
						null,
						null
					);
				setOffsets(result, source, getRhsIToken(4));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 277:  argumentsCS ::= qvtErrorToken
            //
            
            case 277:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 281:  forExpDeclaratorList ::= IDENTIFIER
            //
            case 281: {
               //#line 537 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		EList result = new BasicEList();
		result.add(getRhsIToken(1));
		setResult(result);
                          break;
            }
    	
            //
            // Rule 282:  forExpDeclaratorList ::= forExpDeclaratorList , IDENTIFIER
            //
            case 282: {
               //#line 544 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		EList result = (EList)getRhsSym(1);
		result.add(getRhsIToken(3));
		setResult(result);
                          break;
            }
    	
            //
            // Rule 283:  forExpConditionOpt ::= $Empty
            //
            case 283:
                setResult(null);
                break;

            //
            // Rule 284:  forExpConditionOpt ::= | OclExpressionCS
            //
            case 284: {
               //#line 556 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
            	    setResult((OCLExpressionCS)getRhsSym(2));
                          break;
            }
    	
            //
            // Rule 285:  forExpConditionOpt ::= | qvtErrorToken
            //
            case 285:
                setResult(null);
                break;

            //
            // Rule 286:  forExpCS ::= forOpCode ( forExpDeclaratorList forExpConditionOpt ) expression_block
            //
            case 286: {
               //#line 565 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createForExpCS(
						getRhsIToken(1),
						(EList)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(4),
						(BlockExpCS)getRhsSym(6)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(6));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 287:  forExpCS ::= forOpCode qvtErrorToken
            //
            case 287: {
               //#line 578 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createForExpCS(
						getRhsIToken(1),
						null,
						null,
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 294:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS else ifExpBodyCS endif
            //
            case 294: {
               //#line 606 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)getRhsSym(2),
						(OCLExpressionCS)getRhsSym(4),
						(OCLExpressionCS)getRhsSym(6)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 295:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS endif
            //
            case 295: {
               //#line 618 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)getRhsSym(2),
						(OCLExpressionCS)getRhsSym(4),
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 296:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS else ifElsePart
            //
            case 296: {
               //#line 630 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)getRhsSym(2),
						(OCLExpressionCS)getRhsSym(4),
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 297:  IfExpCS ::= if OclExpressionCS then ifThenPart
            //
            case 297: {
               //#line 642 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)getRhsSym(2),
						null,
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 298:  IfExpCS ::= if ifExpression
            //
            case 298: {
               //#line 654 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS invalidCondition = createInvalidLiteralExpCS(""); //$NON-NLS-1$
				invalidCondition.setStartOffset(getRhsIToken(1).getEndOffset());
				invalidCondition.setEndOffset(getRhsIToken(1).getEndOffset());
				CSTNode result = createIfExpCS(
						invalidCondition,
						null,
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 300:  switchExpCS ::= switch switchBodyExpCS
            //
            case 300: {
               //#line 675 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] switchBody = (Object[]) getRhsSym(2);

				CSTNode result = createSwitchExpCS(
						(EList<SwitchAltExpCS>) switchBody[0],
						(OCLExpressionCS) switchBody[1]
					);
				if (switchBody[2] instanceof IToken) { // In case of correct and incorrect syntax
					setOffsets(result, getRhsIToken(1), (IToken) switchBody[2]);
				} else { // In case of errors in switchBody
					setOffsets(result, getRhsIToken(1), (CSTNode) switchBody[2]);
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 302:  switchDeclaratorCS ::= IDENTIFIER
            //
            case 302: {
               //#line 694 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableCS(
						getRhsIToken(1),
						null,
						null
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 303:  switchDeclaratorCS ::= IDENTIFIER = OclExpressionCS
            //
            case 303: {
               //#line 706 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableCS(
						getRhsIToken(1),
						null,
						(OCLExpressionCS)getRhsSym(3)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 304:  IterateExpCS ::= primaryExpCS -> object ( uninitializedVariableCS ) objectDeclCS expression_block
            //
            case 304: {
               //#line 720 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS  blockExpCS = (BlockExpCS) getRhsSym(8);
				ObjectExpCS objectExpCS = setupOutExpCS(
						(ObjectExpCS) getRhsSym(7),					
						blockExpCS.getBodyExpressions(),
						// passing body positions
						blockExpCS.getStartOffset(),
						blockExpCS.getEndOffset()
					); 
				setOffsets(objectExpCS, getRhsIToken(3), blockExpCS);

				EList<VariableCS> iterators = new BasicEList<VariableCS>();
				iterators.add((VariableCS) getRhsSym(5));
				CallExpCS result = createImperativeIterateExpCS(
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "xcollect"),  //$NON-NLS-1$
						iterators,
						null,
						objectExpCS,
						null
					);
					
				result.setSource((OCLExpressionCS) getRhsSym(1));
				setOffsets(result, getRhsIToken(1), getRhsIToken(8));
				
				setResult(result);
	                  break;
            }
	
            //
            // Rule 305:  IterateExpCS ::= primaryExpCS -> switch ( switchDeclaratorCS ) switchBodyExpCS
            //
            case 305: {
               //#line 752 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] switchBody = (Object[]) getRhsSym(7);

				OCLExpressionCS switchExpCS = (OCLExpressionCS) createSwitchExpCS(
						(EList<SwitchAltExpCS>) switchBody[0],
						(OCLExpressionCS) switchBody[1]							
					);
				if (switchBody[2] instanceof IToken) { // In case of correct and incorrect syntax
					setOffsets(switchExpCS, getRhsIToken(3), (IToken) switchBody[2]);
				} else if (switchBody[2] instanceof CSTNode) { // In case of errors in switchBody
					setOffsets(switchExpCS, getRhsIToken(3), (CSTNode) switchBody[2]);
				} else { // In case of errors in switchBody
					setOffsets(switchExpCS, getRhsIToken(3), getRhsIToken(6));
				}

				EList<VariableCS> iterators = new BasicEList<VariableCS>();
				iterators.add((VariableCS) getRhsSym(5));
				CallExpCS result = createImperativeIterateExpCS(
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "xcollect"),  //$NON-NLS-1$
						iterators,
						null,
						switchExpCS,
						null
					);
					
				result.setSource((OCLExpressionCS) getRhsSym(1));
				setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				
				setResult(result);
	                  break;
            }
	
            //
            // Rule 306:  switchExpCS ::= switch qvtErrorToken
            //
            case 306: {
               //#line 785 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchExpCS(
						new BasicEList(),
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 307:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt }
            //
            case 307: {
               //#line 796 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] result = new Object[] {getRhsSym(2), getRhsSym(3), getRhsIToken(4)};
				setResult(result);
	                  break;
            }
	
            //
            // Rule 308:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt qvtErrorToken
            //
            case 308: {
               //#line 803 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] result = new Object[] {getRhsSym(2), getRhsSym(3), getRhsSym(3)};
				setResult(result);
	                  break;
            }
	
            //
            // Rule 309:  switchBodyExpCS ::= { qvtErrorToken
            //
            case 309: {
               //#line 810 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] result = new Object[] {new BasicEList(), null, getRhsIToken(1)};
				setResult(result);
	                  break;
            }
	
            //
            // Rule 310:  switchAltExpCSList ::= switchAltExpCS
            //
            case 310: {
               //#line 817 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 311:  switchAltExpCSList ::= switchAltExpCSList switchAltExpCS
            //
            case 311: {
               //#line 824 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 312:  switchAltExpCS ::= case ( OclExpressionCS ) expression_statement
            //
            case 312: {
               //#line 832 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) getRhsSym(3),
						(OCLExpressionCS) getRhsSym(5)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 313:  switchAltExpCS ::= case ( OclExpressionCS ) qvtErrorToken
            //
            case 313: {
               //#line 842 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) getRhsSym(3),
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 314:  switchElseExpCSOpt ::= $Empty
            //
            case 314:
                setResult(null);
                break;

            //
            // Rule 316:  switchElseExpCS ::= else expression_statement
            //
            case 316: {
               //#line 857 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult((CSTNode)getRhsSym(2));
	                  break;
            }
	
            //
            // Rule 317:  switchElseExpCS ::= else qvtErrorToken
            //
            case 317: {
               //#line 862 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(null);
	                  break;
            }
	
            //
            // Rule 318:  OclExpressionCS ::= primaryOCLExpressionCS
            //
            case 318: {
               //#line 870 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createExpressionStatementCS(
						(OCLExpressionCS)getRhsSym(1)
					);
				setOffsets(result, (CSTNode)getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 320:  logWhenExp ::= when OclExpressionCS
            //
            case 320: {
               //#line 884 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			OCLExpressionCS condition = (OCLExpressionCS) getRhsSym(2);
			setResult(condition);
                      break;
            }
    
            //
            // Rule 322:  logWhenExpOpt ::= $Empty
            //
            case 322:
                setResult(null);
                break;

            //
            // Rule 323:  logExpCS ::= log ( argumentsCSopt ) logWhenExpOpt
            //
            case 323: {
               //#line 895 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			OCLExpressionCS condition = (OCLExpressionCS) getRhsSym(5);
			LogExpCS result = (LogExpCS)createLogExpCS((EList<OCLExpressionCS>)getRhsSym(3), condition);
			if(condition != null) {
				setOffsets(result, getRhsIToken(1), condition);
			} else {
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
			}
			setResult(result);
                      break;
            }
    
            //
            // Rule 325:  severityKindCS ::= simpleNameCS
            //
            case 325: {
               //#line 911 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			setResult(getRhsSym(1));
	                  break;
            }
	
            //
            // Rule 327:  severityKindCSOpt ::= $Empty
            //
            case 327:
                setResult(null);
                break;

            //
            // Rule 328:  assertWithLogExp ::= with logExpCS
            //
            case 328: {
               //#line 923 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			LogExpCS logExp = (LogExpCS) getRhsSym(2);
			setOffsets(logExp, getRhsIToken(2), logExp);
			setResult(logExp);
                      break;
            }
    
            //
            // Rule 330:  assertWithLogExpOpt ::= $Empty
            //
            case 330:
                setResult(null);
                break;

            //
            // Rule 331:  assertExpCS ::= assert severityKindCSOpt ( OclExpressionCS ) assertWithLogExpOpt
            //
            case 331: {
               //#line 935 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			LogExpCS logExpCS = (LogExpCS)getRhsSym(6);
			OCLExpressionCS condition = (OCLExpressionCS)getRhsSym(4);
			AssertExpCS result = (AssertExpCS)createAssertExpCS(condition, (SimpleNameCS)getRhsSym(2), logExpCS);
	
			CSTNode end = logExpCS != null ? logExpCS : condition; 
			setOffsets(result, getRhsIToken(1), end);
			setResult(result);
                      break;
            }
    
            //
            // Rule 332:  computeExpCS ::= compute ( declarator ) expression_block
            //
            case 332: {
               //#line 950 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createComputeExpCS(
					(VariableCS) getRhsSym(3),
					(OCLExpressionCS) getRhsSym(5)
				);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 334:  IterateExpCS ::= primaryExpCS -> imperativeIterateExpCS
            //
            case 334: {
               //#line 968 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
				ImperativeIterateExpCS iterateExpCS = (ImperativeIterateExpCS) getRhsSym(3);
				iterateExpCS.setSource(source);
				setOffsets(iterateExpCS, source, iterateExpCS);
				setResult(iterateExpCS);
	                  break;
            }
	 
            //
            // Rule 343:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken12 ( imperativeIterContents12 )
            //
            
            case 343:

            //
            // Rule 344:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken3 ( imperativeIterContents3 )
            //
            case 344: {
               //#line 997 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				String opCode = getRhsTokenText(1);
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getRhsIToken(1)
						);
				setOffsets(simpleNameCS, getRhsIToken(1));
				Object[] iterContents = (Object[]) getRhsSym(3);
				OCLExpressionCS bodyCS = null;
				OCLExpressionCS conditionCS = null;
				if ("xcollect".equals(opCode)  //$NON-NLS-1$
					|| "collectOne".equals(opCode)) {  //$NON-NLS-1$
				    bodyCS = (OCLExpressionCS) iterContents[2];
				} else {
				    conditionCS = (OCLExpressionCS) iterContents[2];
				}
				CSTNode result = createImperativeIterateExpCS(
						simpleNameCS,
						(EList<VariableCS>)iterContents[0],
						(VariableCS)iterContents[1],
						bodyCS,
						conditionCS
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 345:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken qvtErrorToken
            //
            case 345: {
               //#line 1026 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getRhsIToken(1)
						);
				setOffsets(simpleNameCS, getRhsIToken(1));
				CSTNode result = createImperativeIterateExpCS(
						simpleNameCS,
						ourEmptyEList,
						null,
						null,
						null
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 346:  imperativeIterContents12 ::= OclExpressionCS
            //
            case 346: {
               //#line 1046 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(new Object[] {
						ourEmptyEList,
						null,
						getRhsSym(1)
					});
	                  break;
            }
	
            //
            // Rule 347:  imperativeIterContents12 ::= uninitializedVariableCS | OclExpressionCS
            //
            case 347: {
               //#line 1056 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList iters = new BasicEList();
				iters.add(getRhsSym(1));
				
				setResult(new Object[] {
						iters,
						null,
						getRhsSym(3)
					});
	                  break;
            }
	
            //
            // Rule 348:  imperativeIterContents12 ::= simpleNameCS , variableDeclarationListCS | OclExpressionCS
            //
            case 348: {
               //#line 1069 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                CSTNode variableCS = createVariableCS(name, null, null);
                setOffsets(variableCS, name);

				EList iters = (EList) getRhsSym(3);
				iters.add(0, variableCS);
				
				setResult(new Object[] {
						iters,
						null,
						getRhsSym(5)
					});
	                  break;
            }
	
            //
            // Rule 349:  imperativeIterContents3 ::= variableDeclarationListCS ; initializedVariableCS | OclExpressionCS
            //
            case 349: {
               //#line 1086 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(new Object[] {
						getRhsSym(1),
						getRhsSym(3),
						getRhsSym(5)
					});
	                  break;
            }
	
            //
            // Rule 350:  variableDeclarationListCS ::= uninitializedVariableCS
            //
            case 350: {
               //#line 1096 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 351:  variableDeclarationListCS ::= variableDeclarationListCS , uninitializedVariableCS
            //
            case 351: {
               //#line 1103 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 352:  exclamationOpt ::= $Empty
            //
            case 352:
                setResult(null);
                break;

            //
            // Rule 354:  declarator_vsep ::= IDENTIFIER |
            //
            case 354: {
               //#line 1119 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		CSTNode result = createVariableCS(
					getRhsIToken(1),
                                            null,
					null
					);
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
                          break;
            }
    	
            //
            // Rule 355:  declarator_vsepOpt ::= $Empty
            //
            case 355:
                setResult(null);
                break;

            //
            // Rule 357:  IterateExpCS ::= primaryExpCS exclamationOpt [ declarator_vsepOpt OclExpressionCS ]
            //
            case 357: {
               //#line 1136 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
		if (source instanceof ImperativeIterateExpCS) {
			String opCode = isTokenOfType(getRhsIToken(2), LightweightParsersym.TK_EXCLAMATION_MARK) 
				?  "collectselectOne"  //$NON-NLS-1$
				: "collectselect";  //$NON-NLS-1$
			SimpleNameCS simpleNameCS = createSimpleNameCS(
					SimpleTypeEnum.KEYWORD_LITERAL,
					opCode
					);
			setOffsets(simpleNameCS, getRhsIToken(3), getRhsIToken(6));

			ImperativeIterateExpCS result = (ImperativeIterateExpCS) source;
			result.setSimpleNameCS(simpleNameCS);
			
			VariableCS variableCS = (VariableCS) getRhsSym(4);
	        if (variableCS != null) {
	            result.setTarget(variableCS);
	        }
	        result.setCondition((OCLExpressionCS) getRhsSym(5));
			
			setOffsets(result, getRhsIToken(1), getRhsIToken(6));
			setResult(result);
		}
		else {
			String opCode = isTokenOfType(getRhsIToken(2), LightweightParsersym.TK_EXCLAMATION_MARK) 
				?  "selectOne"  //$NON-NLS-1$
				: "xselect";  //$NON-NLS-1$
			SimpleNameCS simpleNameCS = createSimpleNameCS(
					SimpleTypeEnum.KEYWORD_LITERAL,
					opCode
					);
			setOffsets(simpleNameCS, getRhsIToken(3), getRhsIToken(6));
			
			CallExpCS result = createImperativeIterateExpCS(
					simpleNameCS,
					ourEmptyEList,
					(VariableCS) getRhsSym(4),
					null,
					(OCLExpressionCS) getRhsSym(5)
					);
			result.setSource(source);
			setOffsets(result, getRhsIToken(1), getRhsIToken(6));
			setResult(result);
		}
	                  break;
            }
	
            //
            // Rule 358:  IterateExpCS ::= primaryExpCS -> simpleNameCS
            //
            case 358: {
               //#line 1186 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		String opCode = "xcollect";  //$NON-NLS-1$
		SimpleNameCS simpleNameCS = createSimpleNameCS(
				SimpleTypeEnum.KEYWORD_LITERAL,
				opCode
				);

		OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
		SimpleNameCS featureNameCS = (SimpleNameCS)getRhsSym(3);
		OCLExpressionCS featureCallExpCS = createFeatureCallExpCS(
				source,
				null,
				featureNameCS,
				new BasicEList(),
				null
				);
		setOffsets(featureCallExpCS, source, featureNameCS);

		ImperativeIterateExpCS result = createImperativeIterateExpCS(
				simpleNameCS,
				ourEmptyEList,
				null,
				null,
				null
				);
		result.setSource(featureCallExpCS);
		setOffsets(result, getRhsIToken(1), getRhsIToken(3));
		setResult(result);
	                  break;
            }
	
            //
            // Rule 360:  newExpCS ::= new newTypespecCS ( argumentsCSopt )
            //
            case 360: {
               //#line 1219 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			OCLExpressionCS result = createNewRuleCallExpCS((TypeSpecCS) getRhsSym(2), (EList) getRhsSym(4));
			setOffsets(result, getRhsIToken(1), getRhsIToken(5));
			setResult(result);
	                  break;
            }
	
            //
            // Rule 361:  newTypespecCS ::= pathNameCS
            //
            case 361: {
               //#line 1227 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)getRhsSym(1),
					null
					);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 362:  primaryNotNameCS ::= break
            //
            case 362: {
               //#line 1240 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			OCLExpressionCS result = createBreakCS();
			setOffsets(result, getRhsIToken(1));
			setResult(result);
	                  break;
            }
	
            //
            // Rule 363:  primaryNotNameCS ::= continue
            //
            case 363: {
               //#line 1248 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			OCLExpressionCS result = createContinueCS();
			setOffsets(result, getRhsIToken(1));
			setResult(result);
	                  break;
            }
	
            //
            // Rule 366:  declarator1 ::= IDENTIFIER : typeCS
            //
            case 366: {
               //#line 1262 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableCS(
						getRhsIToken(1),
						(TypeCS)getRhsSym(3),
						null
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 367:  declarator1 ::= IDENTIFIER : typeCS = OclExpressionCS
            //
            case 367: {
               //#line 1274 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableCS(
						getRhsIToken(1),
						(TypeCS)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(5)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 368:  declarator1 ::= IDENTIFIER : typeCS := OclExpressionCS
            //
            case 368: {
               //#line 1286 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableCS(
						getRhsIToken(1),
						(TypeCS)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(5)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 369:  declarator2 ::= IDENTIFIER := OclExpressionCS
            //
            case 369: {
               //#line 1298 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableCS(
						getRhsIToken(1),
						null,
						(OCLExpressionCS)getRhsSym(3)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 372:  expression_listOpt ::= $Empty
            //
            
            case 372:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 376:  expression_semi_list ::= expression_semi_list_element
            //
            case 376: {
               //#line 1321 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				Object element = getRhsSym(1);
				if (element instanceof EList) {
					result.addAll((EList) element);
				} else {
					result.add(element);
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 377:  expression_semi_list ::= expression_semi_list ; expression_semi_list_element
            //
            case 377: {
               //#line 1333 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				Object element = getRhsSym(3);
				if (element instanceof EList) {
					result.addAll((EList) element);
				} else {
					result.add(element);
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 378:  expression_semi_list ::= expression_semi_list qvtErrorToken
            //
            case 378: {
               //#line 1345 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 379:  expression_block ::= { expression_listOpt }
            //
            case 379: {
               //#line 1352 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			EList bodyList = (EList) getRhsSym(2);
			CSTNode result = createBlockExpCS(
				bodyList
			);
			
			setOffsets(result, getRhsIToken(1), getRhsIToken(3));
			setResult(result);
                          break;
            }
	
            //
            // Rule 380:  expression_block ::= { qvtErrorToken
            //
            case 380: {
               //#line 1363 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			CSTNode result = createBlockExpCS(
				ourEmptyEList
			);
			
			setOffsets(result, getRhsIToken(1));
			setResult(result);
                          break;
            }
	
            //
            // Rule 383:  qvtErrorToken ::= ERROR_TOKEN
            //
            case 383: {
               //#line 1377 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				diagnozeErrorToken(getRhsTokenIndex(1));
	                  break;
            }
	
            //
            // Rule 384:  switchAltExpCS ::= ( OclExpressionCS ) ? OclExpressionCS ;
            //
            case 384: {
               //#line 1387 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchAltExpCSDeprecated(
						(OCLExpressionCS) getRhsSym(2),
						(OCLExpressionCS) getRhsSym(5)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(6));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 385:  switchAltExpCS ::= ( OclExpressionCS ) qvtErrorToken
            //
            case 385: {
               //#line 1397 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchAltExpCSDeprecated(
						(OCLExpressionCS) getRhsSym(2),
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 386:  switchAltExpCS ::= ( qvtErrorToken
            //
            case 386: {
               //#line 1407 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchAltExpCSDeprecated(
						null,
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 387:  switchElseExpCS ::= else ? OclExpressionCS ;
            //
            case 387: {
               //#line 1418 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		    	int startOffset = getRhsIToken(1).getStartOffset();
		    	int endOffset = getRhsIToken(4).getEndOffset();
				reportWarning(org.eclipse.m2m.internal.qvt.oml.cst.parser.NLS.bind(org.eclipse.m2m.internal.qvt.oml.cst.parser.Messages.AbstractQVTParser_DeprecatedSwitchElseExp, null), startOffset, endOffset);
				
				setResult((CSTNode)getRhsSym(3));
	                  break;
            }
	
            //
            // Rule 388:  switchElseExpCS ::= else ? OclExpressionCS qvtErrorToken
            //
            case 388: {
               //#line 1427 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		    	int startOffset = getRhsIToken(1).getStartOffset();
		    	int endOffset = getRhsIToken(3).getEndOffset();
				reportWarning(org.eclipse.m2m.internal.qvt.oml.cst.parser.NLS.bind(org.eclipse.m2m.internal.qvt.oml.cst.parser.Messages.AbstractQVTParser_DeprecatedSwitchElseExp, null), startOffset, endOffset);
				
				setResult((CSTNode)getRhsSym(3));
	                  break;
            }
	
            //
            // Rule 389:  topLevel ::= unit_elementList
            //
            case 389: {
               //#line 189 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<CSTNode> unitElements = (EList<CSTNode>)getRhsSym(1);
				setResult(setupTopLevel(unitElements));
	                  break;
            }
	
            //
            // Rule 391:  _import ::= import unit ;
            //
            case 391: {
               //#line 198 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createImportCS(
						(PathNameCS)getRhsSym(2)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 393:  _import ::= import importDeclaration
            //
            case 393: {
               //#line 210 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createLibraryImportCS(
						createPathNameCS()
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 395:  unit_elementList ::= unit_elementList unit_element
            //
            case 395: {
               //#line 224 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList list = (EList)getRhsSym(1);
				list.add(getRhsSym(2));
				setResult(list);
	                  break;
            }
	 
            //
            // Rule 396:  unit_elementList ::= $Empty
            //
            
            case 396:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 407:  unit_element ::= qvtErrorToken
            //
            case 407:
                setResult(null);
                break;

            //
            // Rule 410:  transformation_decl ::= transformation_h ;
            //
            case 410: {
               //#line 253 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) getRhsSym(1);
				setOffsets(headerCS, headerCS, getRhsIToken(2));
				MappingModuleCS moduleCS = createMappingModuleCS(headerCS, ourEmptyEList);
				setOffsets(moduleCS, headerCS);
				setResult(moduleCS);
	                  break;
            }
	
            //
            // Rule 411:  transformation_def ::= transformation_h { module_elementList } semicolonOpt
            //
            case 411: {
               //#line 263 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) getRhsSym(1);
				MappingModuleCS moduleCS = createMappingModuleCS(headerCS, (EList) getRhsSym(3));
				setOffsets(moduleCS, headerCS, getRhsIToken(4));
				setResult(moduleCS);
	                  break;
            }
	
            //
            // Rule 414:  library_decl ::= library_h ;
            //
            case 414: {
               //#line 275 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) getRhsSym(1);
				setOffsets(headerCS, headerCS, getRhsIToken(2));
				MappingModuleCS moduleCS = createLibraryCS(headerCS, ourEmptyEList);
				setOffsets(moduleCS, headerCS);
				setResult(moduleCS);
	                  break;
            }
	
            //
            // Rule 415:  library_def ::= library_h { module_elementList } semicolonOpt
            //
            case 415: {
               //#line 285 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) getRhsSym(1);
				MappingModuleCS moduleCS = createLibraryCS(headerCS, (EList) getRhsSym(3));
				setOffsets(moduleCS, headerCS, getRhsIToken(4));
				setResult(moduleCS);
	                  break;
            }
	
            //
            // Rule 416:  transformation_h ::= qualifierList transformation qualifiedNameCS transformation_signature transformation_usage_refineOpt
            //
            case 416: {
               //#line 297 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList qualifierList = (EList) getRhsSym(1);
				EList transfUsages = ourEmptyEList;
				TransformationRefineCS transfRefine = null;
				Object transformation_usage_refineOpt = getRhsSym(5);
				if (transformation_usage_refineOpt instanceof TransformationRefineCS) {
					transfRefine = (TransformationRefineCS) transformation_usage_refineOpt;
				} else if (transformation_usage_refineOpt instanceof EList) {
					transfUsages = (EList) transformation_usage_refineOpt;
				}
				CSTNode result = createTransformationHeaderCS(
						qualifierList,
						(PathNameCS)getRhsSym(3),
						(SimpleSignatureCS)getRhsSym(4),
						transfUsages,
						transfRefine
					);
				if (qualifierList.isEmpty()) {
					setOffsets(result, getRhsIToken(2));
				} else {
					setOffsets(result, (CSTNode) qualifierList.get(0));
				}
				if (transfRefine == null) {
					if (transfUsages.isEmpty()) {
						setOffsets(result, result, (SimpleSignatureCS)getRhsSym(4));
					}
					else {
						setOffsets(result, result, (CSTNode) transfUsages.get(transfUsages.size()-1));
					}
				} else {
					setOffsets(result, result, transfRefine);
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 417:  transformation_usage_refineOpt ::= $Empty
            //
            case 417:
                setResult(null);
                break;

            //
            // Rule 422:  transformation_refine ::= refines moduleref
            //
            case 422: {
               //#line 344 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createTransformationRefineCS(
						(ModuleRefCS)getRhsSym(2)
					);
				setOffsets(result, (ModuleRefCS)getRhsSym(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 423:  library_h ::= library qualifiedNameCS library_signatureOpt module_usageListOpt
            //
            case 423: {
               //#line 357 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS name = (PathNameCS)getRhsSym(2);
				SimpleSignatureCS signature = (getRhsSym(3) == null) ? createSimpleSignatureCS(ourEmptyEList) : (SimpleSignatureCS)getRhsSym(3);
				EList<ModuleUsageCS> moduleUsages = (EList<ModuleUsageCS>)getRhsSym(4);
				CSTNode result = createTransformationHeaderCS(
						ourEmptyEList,
						name,
						signature,
						moduleUsages,
						null
					);
				CSTNode rightNode = name;
				if (!moduleUsages.isEmpty()) {
					rightNode = moduleUsages.get(moduleUsages.size() - 1);
				} else if (getRhsSym(3) != null) {
					rightNode = signature;
				}
				setOffsets(result, getRhsIToken(1), rightNode);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 425:  library_h ::= library libraryDeclaration
            //
            case 425: {
               //#line 382 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createTransformationHeaderCS(
						ourEmptyEList,
						createPathNameCS(),
						createSimpleSignatureCS(ourEmptyEList),
						ourEmptyEList,
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 426:  library_signatureOpt ::= $Empty
            //
            case 426:
                setResult(null);
                break;

            //
            // Rule 429:  module_usageList ::= module_usage
            //
            case 429: {
               //#line 404 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 430:  module_usageList ::= module_usageList module_usage
            //
            case 430: {
               //#line 411 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) getRhsSym(1);
				result.add(getRhsSym(2));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 431:  module_usageListOpt ::= $Empty
            //
            
            case 431:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 435:  access_usage ::= access module_kindOpt moduleref_list
            //
            case 435: {
               //#line 426 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList moduleRefList = (EList)getRhsSym(3);
				CSTNode result = createModuleUsageCS(
						ImportKindEnum.ACCESS,
						(ModuleKindCS)getRhsSym(2),
						moduleRefList
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)moduleRefList.get(moduleRefList.size()-1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 436:  extends_usage ::= extends module_kindOpt moduleref_list
            //
            case 436: {
               //#line 438 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList moduleRefList = (EList)getRhsSym(3);
				CSTNode result = createModuleUsageCS(
						ImportKindEnum.EXTENSION,
						(ModuleKindCS)getRhsSym(2),
						moduleRefList
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)moduleRefList.get(moduleRefList.size()-1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 437:  module_kindOpt ::= $Empty
            //
            case 437:
                setResult(null);
                break;

            //
            // Rule 439:  module_kind ::= transformation
            //
            case 439: {
               //#line 455 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.TRANSFORMATION
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 440:  module_kind ::= library
            //
            case 440: {
               //#line 464 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.LIBRARY
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 441:  moduleref_list ::= moduleref
            //
            case 441: {
               //#line 474 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 442:  moduleref_list ::= moduleref_list , moduleref
            //
            case 442: {
               //#line 481 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 443:  moduleref_list ::= moduleref_list qvtErrorToken
            //
            case 443: {
               //#line 488 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) getRhsSym(1);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 444:  moduleref ::= pathNameCS simple_signatureOpt
            //
            case 444: {
               //#line 495 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				SimpleSignatureCS signature = (SimpleSignatureCS)getRhsSym(2);
				CSTNode result = createModuleRefCS(
						(PathNameCS)getRhsSym(1),
						signature 
					);
				CSTNode rightNode = (signature == null) ? (CSTNode)getRhsSym(1) : signature;
				setOffsets(result, (CSTNode)getRhsSym(1), rightNode);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 445:  module_elementList ::= module_elementList module_element
            //
            case 445: {
               //#line 510 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList list = (EList)getRhsSym(1);
				list.add(getRhsSym(2));
				setResult(list);
	                  break;
            }
	 
            //
            // Rule 446:  module_elementList ::= $Empty
            //
            
            case 446:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 454:  module_element ::= qvtErrorToken
            //
            case 454:
                setResult(null);
                break;

            //
            // Rule 455:  _modeltype ::= modeltype IDENTIFIER compliance_kindOpt uses packageref_list modeltype_whereOpt ;
            //
            case 455: {
               //#line 533 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList whereList = (EList)getRhsSym(6);
				EList packageRefList = (EList)getRhsSym(5);
				ModelTypeCS result = createModelTypeCS(
						getRhsIToken(2),
						(StringLiteralExpCS)getRhsSym(3),
						packageRefList,
						whereList
					);
				if (whereList.isEmpty()) {
					setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				}
				else {
					CSTNode lastPackageRefCS = (CSTNode)packageRefList.get(packageRefList.size()-1);
					setOffsets(result, getRhsIToken(1), lastPackageRefCS);
					setBodyOffsets(result, lastPackageRefCS, getRhsIToken(7));
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 457:  _modeltype ::= modeltype modeltypeDeclaration
            //
            case 457: {
               //#line 557 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				ModelTypeCS result = createModelTypeCS(
						new Token(0, 0, 0),
						null,
						ourEmptyEList,
						ourEmptyEList
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 458:  modeltype_whereOpt ::= $Empty
            //
            
            case 458:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 460:  modeltype_where ::= where expression_block
            //
            case 460: {
               //#line 574 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS blockExpCS = (BlockExpCS) getRhsSym(2);
				setResult(blockExpCS.getBodyExpressions());
	                  break;
            }
	
            //
            // Rule 461:  packageref_list ::= packageref
            //
            case 461: {
               //#line 581 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 462:  packageref_list ::= packageref_list , packageref
            //
            case 462: {
               //#line 588 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 463:  packageref_list ::= packageref_list qvtErrorToken
            //
            case 463: {
               //#line 595 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 464:  packageref ::= pathNameCS
            //
            case 464: {
               //#line 602 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createPackageRefCS(
						(PathNameCS)getRhsSym(1),
						null
					);
				setOffsets(result, (CSTNode)getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 465:  packageref ::= pathNameCS ( uri )
            //
            case 465: {
               //#line 612 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createPackageRefCS(
						(PathNameCS)getRhsSym(1),
						(StringLiteralExpCS)getRhsSym(3)
					);
				setOffsets(result, (CSTNode)getRhsSym(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 466:  packageref ::= uri
            //
            case 466: {
               //#line 622 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createPackageRefCS(
						null,
						(StringLiteralExpCS)getRhsSym(1)
					);
				setOffsets(result, (CSTNode)getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 467:  compliance_kindOpt ::= $Empty
            //
            case 467:
                setResult(null);
                break;

            //
            // Rule 471:  classifierDefCS ::= intermediate class qvtIdentifierCS classifierExtensionOpt { classifierFeatureListOpt } semicolonOpt
            //
            case 471: {
               //#line 645 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createClassifierDefCS(
						getRhsIToken(3),
						(EList) getRhsSym(4),
						(EList) getRhsSym(6)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 472:  classifierExtensionOpt ::= $Empty
            //
            
            case 472:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 473:  classifierExtensionOpt ::= extends type_list
            //
            case 473: {
               //#line 659 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(2);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 474:  type_list ::= typeCS
            //
            case 474: {
               //#line 665 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 475:  type_list ::= type_list , typeCS
            //
            case 475: {
               //#line 672 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 476:  type_list ::= type_list qvtErrorToken
            //
            case 476: {
               //#line 679 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 477:  classifierFeatureListOpt ::= $Empty
            //
            
            case 477:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 479:  classifierFeatureList ::= classifierFeatureCS
            //
            case 479: {
               //#line 690 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 480:  classifierFeatureList ::= classifierFeatureList ; classifierFeatureCS
            //
            case 480: {
               //#line 697 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 481:  classifierFeatureList ::= classifierFeatureList qvtErrorToken
            //
            case 481: {
               //#line 704 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 482:  classifierFeatureCS ::= stereotype_qualifier_list feature_key_list qvtIdentifierCS : typeCS multiplicityOpt ordered_prop opposite_propertyOpt init_partOpt
            //
            case 482: {
               //#line 711 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList stereotypeQualifiers = (EList) getRhsSym(1);
				EList featureKeys = (EList) getRhsSym(2);
				MultiplicityDefCS multiplicityDef = (MultiplicityDefCS) getRhsSym(6);
				OppositePropertyCS oppositeProperty = (OppositePropertyCS) getRhsSym(8);
				OCLExpressionCS initExpression = (OCLExpressionCS) getRhsSym(9);
				CSTNode result = createClassifierPropertyCS(
						stereotypeQualifiers,
						featureKeys,
						getRhsIToken(3),
						(TypeCS) getRhsSym(5),
						((BooleanLiteralExpCS) getRhsSym(7)).getBooleanSymbol().booleanValue(),
						initExpression,
						multiplicityDef,
						oppositeProperty
					);
				
				int startOffset = getRhsIToken(3).getStartOffset();
				if (!featureKeys.isEmpty()) {
					startOffset = ((CSTNode) featureKeys.get(0)).getStartOffset();
				}
				if (!stereotypeQualifiers.isEmpty()) {
					startOffset = ((IToken) stereotypeQualifiers.get(0)).getStartOffset();
				}
				
				CSTNode lastToken = (CSTNode) getRhsSym(5);
				if (initExpression != null) {
					lastToken = initExpression;
				}
				if (multiplicityDef != null) {
					lastToken = multiplicityDef;
				}
				if (oppositeProperty != null) {
					lastToken = oppositeProperty;
				}
				
				setOffsets(result, lastToken);
				result.setStartOffset(startOffset);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 484:  init_partOpt ::= $Empty
            //
            case 484:
                setResult(null);
                break;

            //
            // Rule 485:  init_partOpt ::= = OclExpressionCS
            //
            case 485: {
               //#line 757 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = (CSTNode) getRhsSym(2);
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 486:  stereotype_qualifier_list ::= $Empty
            //
            
            case 486:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 487:  stereotype_qualifier_list ::= STEREOTYPE_QUALIFIER_OPEN identifier_list STEREOTYPE_QUALIFIER_CLOSE
            //
            case 487: {
               //#line 766 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(2);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 488:  identifier_list ::= qvtIdentifierCS
            //
            case 488: {
               //#line 773 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add(getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 489:  identifier_list ::= identifier_list , qvtIdentifierCS
            //
            case 489: {
               //#line 780 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) getRhsSym(1);
				result.add(getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 490:  identifier_list ::= identifier_list qvtErrorToken
            //
            case 490: {
               //#line 787 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 491:  feature_key_list ::= $Empty
            //
            
            case 491:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 492:  feature_key_list ::= feature_key_list feature_key
            //
            case 492: {
               //#line 796 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) getRhsSym(1);
				result.add(getRhsSym(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 493:  feature_key_list ::= feature_key_list qvtErrorToken
            //
            case 493: {
               //#line 803 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 494:  feature_key ::= composes
            //
            
            case 494:
 
            //
            // Rule 495:  feature_key ::= references
            //
            
            case 495:
 
            //
            // Rule 496:  feature_key ::= readonly
            //
            
            case 496:
 
            //
            // Rule 497:  feature_key ::= derived
            //
            
            case 497:

            //
            // Rule 498:  feature_key ::= static
            //
            case 498: {
               //#line 818 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getRhsIToken(1));
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 499:  multiplicityOpt ::= $Empty
            //
            case 499:
                setResult(null);
                break;

            //
            // Rule 500:  multiplicityOpt ::= LBRACKET multiplicity_range RBRACKET
            //
            case 500: {
               //#line 828 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = (CSTNode) getRhsSym(2);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 501:  multiplicity_range ::= IntegerLiteralExpCS
            //
            case 501: {
               //#line 835 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMultiplicityDefCS(
						(PrimitiveLiteralExpCS) getRhsSym(1),
						(PrimitiveLiteralExpCS) getRhsSym(1)
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 502:  multiplicity_range ::= UnlimitedNaturalLiteralExpCS
            //
            case 502: {
               //#line 845 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PrimitiveLiteralExpCS lowerBound = createIntegerLiteralExpCS(Integer.toString(0));
				setOffsets(lowerBound, getRhsIToken(1));
				CSTNode result = createMultiplicityDefCS(
						lowerBound, 
						(PrimitiveLiteralExpCS) getRhsSym(1)
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 503:  multiplicity_range ::= IntegerLiteralExpCS MULTIPLICITY_RANGE IntegerLiteralExpCS
            //
            
            case 503:
 
            //
            // Rule 504:  multiplicity_range ::= IntegerLiteralExpCS DOTDOT IntegerLiteralExpCS
            //
            
            case 504:
 
            //
            // Rule 505:  multiplicity_range ::= IntegerLiteralExpCS MULTIPLICITY_RANGE UnlimitedNaturalLiteralExpCS
            //
            
            case 505:

            //
            // Rule 506:  multiplicity_range ::= IntegerLiteralExpCS DOTDOT UnlimitedNaturalLiteralExpCS
            //
            case 506: {
               //#line 863 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMultiplicityDefCS(
						(PrimitiveLiteralExpCS) getRhsSym(1),
						(PrimitiveLiteralExpCS) getRhsSym(3)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 507:  ordered_prop ::= ordered
            //
            case 507: {
               //#line 874 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.TRUE.toString());
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 508:  ordered_prop ::= $Empty
            //
            case 508: {
               //#line 881 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.FALSE.toString());
				setResult(result);
	                  break;
            }
	
            //
            // Rule 509:  opposite_propertyOpt ::= $Empty
            //
            case 509:
                setResult(null);
                break;

            //
            // Rule 510:  opposite_propertyOpt ::= opposites navigable_prop qvtIdentifierCS multiplicityOpt
            //
            case 510: {
               //#line 890 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MultiplicityDefCS multiplicityDef = (MultiplicityDefCS) getRhsSym(4);
				CSTNode result = createOppositePropertyCS(
						getRhsIToken(3),
						((BooleanLiteralExpCS) getRhsSym(2)).getBooleanSymbol().booleanValue(),
						multiplicityDef
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				if (multiplicityDef != null) {
					result.setEndOffset(multiplicityDef.getEndOffset());
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 511:  navigable_prop ::= ~
            //
            case 511: {
               //#line 906 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.FALSE.toString());
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 512:  navigable_prop ::= $Empty
            //
            case 512: {
               //#line 913 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.TRUE.toString());
				setResult(result);
	                  break;
            }
	
            //
            // Rule 513:  _property ::= configuration property qvtIdentifierCS : typeCS ;
            //
            case 513: {
               //#line 922 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createConfigPropertyCS(
						getRhsIToken(3),
						(TypeCS)getRhsSym(5)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(6));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 514:  _property ::= configuration property qvtIdentifierCS : typeCS qvtErrorToken
            //
            case 514: {
               //#line 932 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createConfigPropertyCS(
						getRhsIToken(3),
						(TypeCS)getRhsSym(5)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 515:  _property ::= property qvtIdentifierCS : typeCS = OclExpressionCS ;
            //
            case 515: {
               //#line 942 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createLocalPropertyCS(
						getRhsIToken(2),
						(TypeCS)getRhsSym(4),
						(OCLExpressionCS)getRhsSym(6)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 516:  _property ::= property qvtIdentifierCS = OclExpressionCS ;
            //
            case 516: {
               //#line 953 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createLocalPropertyCS(
						getRhsIToken(2),
						null,
						(OCLExpressionCS)getRhsSym(4)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 517:  _property ::= property qvtIdentifierCS : typeCS ;
            //
            case 517: {
               //#line 964 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createLocalPropertyCS(
						getRhsIToken(2),
						(TypeCS)getRhsSym(4),
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 518:  _property ::= intermediate property scoped_identifier : typeCS ;
            //
            case 518: {
               //#line 975 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createContextualPropertyCS(
						(ScopedNameCS)getRhsSym(3),
						(TypeCS)getRhsSym(5),
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(6));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 519:  _property ::= intermediate property scoped_identifier : typeCS = OclExpressionCS ;
            //
            case 519: {
               //#line 986 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createContextualPropertyCS(
						(ScopedNameCS)getRhsSym(3),
						(TypeCS)getRhsSym(5),
						(OCLExpressionCS)getRhsSym(7)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(8));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 523:  helper_header ::= helper_info scoped_identifier complete_signature
            //
            case 523: {
               //#line 1004 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CompleteSignatureCS completeSignature = (CompleteSignatureCS)getRhsSym(3);
				Object[] helperInfo = (Object[])getRhsSym(1);
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					null,
					(ScopedNameCS)getRhsSym(2),
					completeSignature.getSimpleSignature().getParams(),
					completeSignature.getResultParams()
				);
				setOffsets(mappingDeclarationCS, (CSTNode)getRhsSym(2), (CSTNode)getRhsSym(3));

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>) helperInfo[0];
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				IToken helperKind = (IToken) helperInfo[1];
				mappingDeclarationCS.setIsQuery(helperKind.getKind() == LightweightParsersym.TK_query);
				mappingDeclarationCS.setStartOffset(helperKind.getStartOffset());

				setResult(mappingDeclarationCS);
	                  break;
            }
	
            //
            // Rule 524:  helper_header ::= helper_info qvtErrorToken
            //
            case 524: {
               //#line 1029 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] helperInfo = (Object[])getRhsSym(1);
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					null,
					createScopedNameCS(null, ""), //$NON-NLS-1$
					ourEmptyEList,
					ourEmptyEList
				);
				setOffsets(mappingDeclarationCS, (IToken) helperInfo[1]);

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>) helperInfo[0];
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				IToken helperKind = (IToken) helperInfo[1];
				mappingDeclarationCS.setIsQuery(helperKind.getKind() == LightweightParsersym.TK_query);
				mappingDeclarationCS.setStartOffset(helperKind.getStartOffset());

				setResult(mappingDeclarationCS);
	                  break;
            }
	
            //
            // Rule 525:  helper_info ::= qualifierList helper_kind
            //
            case 525: {
               //#line 1053 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(new Object[] {getRhsSym(1), getRhsIToken(2)});
	                  break;
            }
	
            //
            // Rule 528:  helper_decl ::= helper_header ;
            //
            case 528: {
               //#line 1062 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)getRhsSym(1);
				MappingQueryCS result = createMappingQueryCS(
						false,
						mappingDecl,
						ourEmptyEList
					);
				result.setBlackBox(true);
				setOffsets(result, mappingDecl, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 529:  helper_decl ::= helper_header qvtErrorToken
            //
            case 529: {
               //#line 1076 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)getRhsSym(1);
				MappingQueryCS result = createMappingQueryCS(
						false,
						mappingDecl,
						ourEmptyEList
					);
				result.setBlackBox(true);
				setOffsets(result, mappingDecl);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 530:  helper_simple_def ::= helper_header = OclExpressionCS ;
            //
            case 530: {
               //#line 1090 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)getRhsSym(1);
				OCLExpressionCS expression = (OCLExpressionCS)getRhsSym(3);
				EList<OCLExpressionCS> expressionList = new BasicEList();
				expressionList.add(expression);
				MappingQueryCS result = createMappingQueryCS(
						false,
						mappingDecl,
						expressionList
					);
				result.setIsSimpleDefinition(true);
				setOffsets(result, mappingDecl, getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 531:  helper_compound_def ::= helper_header expression_block semicolonOpt
            //
            case 531: {
               //#line 1107 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)getRhsSym(1);
				BlockExpCS blockExpCS = (BlockExpCS)getRhsSym(2);
				CSTNode result = createMappingQueryCS(
						false,
						mappingDecl,
						blockExpCS.getBodyExpressions()
					);
				setOffsets(result, mappingDecl, blockExpCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 534:  constructor_header ::= qualifierList constructor scoped_identifier simple_signature
            //
            case 534: {
               //#line 1126 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				SimpleSignatureCS signature = (SimpleSignatureCS) getRhsSym(4);					
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					null,
					(ScopedNameCS) getRhsSym(3),
					signature.getParams(),
					null
				);
				setOffsets(mappingDeclarationCS, getRhsIToken(2), signature);

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>) getRhsSym(1);
				if (!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				setResult(mappingDeclarationCS);
	                  break;
            }
	
            //
            // Rule 535:  constructor_decl ::= constructor_header ;
            //
            case 535: {
               //#line 1146 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS) getRhsSym(1);
				ConstructorCS result = createConstructorCS(
						mappingDecl,
						ourEmptyEList
					);
				result.setBlackBox(true);
				setOffsets(result, mappingDecl, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 536:  constructor_decl ::= constructor_header qvtErrorToken
            //
            case 536: {
               //#line 1159 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS) getRhsSym(1);
				ConstructorCS result = createConstructorCS(
						mappingDecl,
						ourEmptyEList
					);
				result.setBlackBox(true);
				setOffsets(result, mappingDecl);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 537:  constructor_def ::= constructor_header expression_block semicolonOpt
            //
            case 537: {
               //#line 1172 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS) getRhsSym(1);
				BlockExpCS blockExpCS = (BlockExpCS) getRhsSym(2);
				ConstructorCS result = createConstructorCS(
						mappingDecl,
						blockExpCS.getBodyExpressions()
					);
				setOffsets(result, mappingDecl, blockExpCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 540:  entry_header ::= main simple_signature
            //
            case 540: {
               //#line 1191 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				IToken nameToken = getRhsIToken(1);				
				ScopedNameCS nameCS = createScopedNameCS(null, getRhsTokenText(1));								
				nameCS.setStartOffset(nameToken.getStartOffset());
				nameCS.setEndOffset(nameToken.getEndOffset());
	
				SimpleSignatureCS signature = (SimpleSignatureCS)getRhsSym(2);
				CSTNode result = createMappingDeclarationCS(
						null,
						nameCS,
						signature.getParams(),
						null
					);
				setOffsets(result, getRhsIToken(1), signature);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 541:  entry_header ::= main qvtErrorToken
            //
            case 541: {
               //#line 1210 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMappingDeclarationCS(
						null,
						createScopedNameCS(null, getRhsTokenText(1)),
						ourEmptyEList,
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 542:  entry_decl ::= entry_header ;
            //
            case 542: {
               //#line 1223 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)getRhsSym(1);
				MappingQueryCS result = createMappingQueryCS(
						true,
						mappingDecl,
						ourEmptyEList
					);
				result.setBlackBox(true);
				setOffsets(result, mappingDecl, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 543:  entry_def ::= entry_header expression_block semicolonOpt
            //
            case 543: {
               //#line 1237 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)getRhsSym(1);
				BlockExpCS blockExpCS = (BlockExpCS)getRhsSym(2);
				CSTNode result = createMappingQueryCS(
						true,
						mappingDecl,
						blockExpCS.getBodyExpressions()
					);
				setOffsets(result, mappingDecl, blockExpCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 544:  _tag ::= tag StringLiteralExpCS scoped_identifier tag_valueOpt
            //
            case 544: {
               //#line 1255 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS valueExpression = (OCLExpressionCS) getRhsSym(4);
				CSTNode result = createTagCS(
						(StringLiteralExpCS) getRhsSym(2),
						(ScopedNameCS) getRhsSym(3),
						valueExpression
					);
				setOffsets(result, getRhsIToken(1), valueExpression != null ? valueExpression : (CSTNode) getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 545:  tag_valueOpt ::= $Empty
            //
            case 545:
                setResult(null);
                break;

            //
            // Rule 546:  tag_valueOpt ::= = OclExpressionCS
            //
            case 546: {
               //#line 1270 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(getRhsSym(2));
	                  break;
            }
	
            //
            // Rule 549:  mapping_decl ::= mapping_full_header ;
            //
            case 549: {
               //#line 1283 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
	                        Object[] mappingFullHeader = (Object[])getRhsSym(1);
				MappingRuleCS result = createMappingRuleCS(
						(MappingDeclarationCS)mappingFullHeader[0],
						(OCLExpressionCS)mappingFullHeader[1],
						null
					);
				result.setBlackBox(true);
				setOffsets(result, (MappingDeclarationCS)mappingFullHeader[0], getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 550:  mapping_def ::= mapping_full_header { mapping_body } semicolonOpt
            //
            case 550: {
               //#line 1297 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingSectionsCS mappingSections = (MappingSectionsCS)getRhsSym(3);
				setOffsets(mappingSections, getRhsIToken(2), getRhsIToken(4));

				MappingBodyCS mappingBodyCS = mappingSections.getMappingBodyCS();
				if (mappingBodyCS != null) {
					if (mappingBodyCS.getStartOffset() < 0) {
						mappingBodyCS.setStartOffset(mappingSections.getStartOffset());
					}
					if (mappingBodyCS.getEndOffset() < 0) {
						mappingBodyCS.setEndOffset(mappingSections.getEndOffset());
					}
				}

	                        Object[] mappingFullHeader = (Object[])getRhsSym(1);
				MappingRuleCS result = createMappingRuleCS(
						(MappingDeclarationCS)mappingFullHeader[0],
						(OCLExpressionCS)mappingFullHeader[1],
						mappingSections
					);
				result.setBlackBox(false);
				setOffsets(result, (MappingDeclarationCS)mappingFullHeader[0], getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 551:  mapping_def ::= mapping_full_header { qvtErrorToken
            //
            case 551: {
               //#line 1324 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
	                        Object[] mappingFullHeader = (Object[])getRhsSym(1);
				MappingRuleCS result = createMappingRuleCS(
						(MappingDeclarationCS)mappingFullHeader[0],
						null,
						null
					);
				setOffsets(result, (MappingDeclarationCS)mappingFullHeader[0], getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 552:  mapping_full_header ::= mapping_header _whenOpt
            //
            case 552: {
               //#line 1337 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(new Object[] {getRhsSym(1), getRhsSym(2)});
	                  break;
            }
	
            //
            // Rule 553:  mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier complete_signature mapping_extraList
            //
            case 553: {
               //#line 1343 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				DirectionKindCS directionKind = (DirectionKindCS)getRhsSym(3);
				CompleteSignatureCS completeSignature = (CompleteSignatureCS)getRhsSym(5);
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					directionKind,
					(ScopedNameCS)getRhsSym(4),
					completeSignature.getSimpleSignature().getParams(),
					completeSignature.getResultParams()
				);
				
				mappingDeclarationCS.setStartOffset(directionKind == null ? getRhsIToken(2).getStartOffset() : directionKind.getStartOffset());
				mappingDeclarationCS.setEndOffset(completeSignature.getEndOffset());

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)getRhsSym(1);
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				mappingDeclarationCS.getMappingExtension().addAll(((EList<MappingExtensionCS>)getRhsSym(6)));

				setResult(mappingDeclarationCS);
	                  break;
            }
	
            //
            // Rule 554:  mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier qvtErrorToken
            //
            case 554: {
               //#line 1368 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				DirectionKindCS directionKind = (DirectionKindCS)getRhsSym(3);
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					directionKind,
					(ScopedNameCS)getRhsSym(4),
					ourEmptyEList,
					ourEmptyEList
				);

				mappingDeclarationCS.setStartOffset(directionKind == null ? getRhsIToken(2).getStartOffset() : directionKind.getStartOffset());
				mappingDeclarationCS.setEndOffset(((CSTNode)getRhsSym(4)).getEndOffset());

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)getRhsSym(1);
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				setResult(mappingDeclarationCS);
	                  break;
            }
	
            //
            // Rule 555:  mapping_header ::= qualifierList mapping qvtErrorToken
            //
            case 555: {
               //#line 1390 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					null,
					createScopedNameCS(null, ""), //$NON-NLS-1$
					ourEmptyEList,
					ourEmptyEList
				);
				
				setOffsets(mappingDeclarationCS, getRhsIToken(2), getRhsIToken(2));

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)getRhsSym(1);
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				setResult(mappingDeclarationCS);
	                  break;
            }
	
            //
            // Rule 556:  mapping_extraList ::= mapping_extraList mapping_extra
            //
            case 556: {
               //#line 1411 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<MappingExtensionCS> extensionList = (EList<MappingExtensionCS>)getRhsSym(1);
				extensionList.add((MappingExtensionCS)getRhsSym(2));
				setResult(extensionList);
	                  break;
            }
	 
            //
            // Rule 557:  mapping_extraList ::= $Empty
            //
            
            case 557:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 559:  mapping_extension ::= mapping_extension_key scoped_identifier_list
            //
            case 559: {
               //#line 1424 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingExtensionCS result = createMappingExtension(getRhsTokenText(1), (EList<ScopedNameCS>)getRhsSym(2));

				result.setStartOffset(getRhsIToken(1).getStartOffset());
				result.setEndOffset(getEndOffset(getRhsIToken(1), (EList<ScopedNameCS>)getRhsSym(2)));
			
				setResult(result);
	                  break;
            }
	
            //
            // Rule 564:  _whenOpt ::= $Empty
            //
            case 564:
                setResult(null);
                break;

            //
            // Rule 565:  _when ::= when { OclExpressionCS semicolonOpt }
            //
            case 565: {
               //#line 1443 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS result = (OCLExpressionCS)getRhsSym(3);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 566:  _when ::= when qvtErrorToken
            //
            case 566:
                setResult(null);
                break;

            //
            // Rule 567:  mapping_body ::= init_sectionOpt population_sectionOpt end_sectionOpt
            //
            case 567: {
               //#line 1452 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
	                        MappingInitCS mappingInitCS = (MappingInitCS)getRhsSym(1);
				MappingBodyCS mappingBodyCS = (MappingBodyCS)getRhsSym(2);
				MappingEndCS mappingEndCS = (MappingEndCS)getRhsSym(3);

				if (mappingBodyCS != null) {
					if ((mappingBodyCS.getStartOffset() < 0) && (mappingInitCS != null)) {
						mappingBodyCS.setStartOffset(mappingInitCS.getEndOffset() + 1);
					}
					if ((mappingBodyCS.getEndOffset() < 0) && (mappingEndCS != null)) {
						mappingBodyCS.setEndOffset(mappingEndCS.getStartOffset() - 1);
					}
					if (mappingBodyCS.getStartOffset() > mappingBodyCS.getEndOffset()) {
						mappingBodyCS.setEndOffset(mappingBodyCS.getStartOffset());
					}
				}
				
				CSTNode result = createMappingSectionsCS(
						mappingInitCS,
						mappingBodyCS,
						mappingEndCS
					);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 568:  init_sectionOpt ::= $Empty
            //
            case 568:
                setResult(null);
                break;

            //
            // Rule 570:  init_section ::= init expression_block
            //
            case 570: {
               //#line 1483 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS blockExpCS = (BlockExpCS) getRhsSym(2);
				CSTNode result = createMappingInitCS(
						blockExpCS.getBodyExpressions(),
						blockExpCS.getStartOffset(),
						blockExpCS.getEndOffset()
					);
				setOffsets(result, getRhsIToken(1), blockExpCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 571:  init_section ::= init qvtErrorToken
            //
            case 571: {
               //#line 1496 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMappingInitCS(
						ourEmptyEList,
						getRhsIToken(1).getEndOffset(),
						getRhsIToken(1).getStartOffset()
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 572:  population_sectionOpt ::= $Empty
            //
            case 572: {
               //#line 1509 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingBodyCS result = createMappingBodyCS(
						ourEmptyEList,
						false
					);
				// offsets will be updated further in parent non-terminals
				result.setStartOffset(-1); 
				result.setEndOffset(-1);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 574:  population_section ::= expression_list
            //
            case 574: {
               //#line 1523 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<OCLExpressionCS> expressionList = (EList<OCLExpressionCS>) getRhsSym(1);
				MappingBodyCS result = createMappingBodyCS(
						expressionList,
						false
					);
				if (expressionList.isEmpty()) {
					// offsets will be updated further in parent non-terminals
					result.setStartOffset(-1); 
					result.setEndOffset(-1);
				} else {
					CSTNode startExp = expressionList.get(0);
					CSTNode endExp = expressionList.get(expressionList.size() - 1);
					setOffsets(result, startExp, endExp);
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 575:  population_section ::= population expression_block
            //
            case 575: {
               //#line 1543 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS blockExpCS = (BlockExpCS) getRhsSym(2);
				MappingBodyCS result = createMappingBodyCS(
						blockExpCS.getBodyExpressions(),
						true
					);
				setOffsets(result, getRhsIToken(1), blockExpCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 576:  population_section ::= population qvtErrorToken
            //
            case 576: {
               //#line 1555 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMappingBodyCS(
						ourEmptyEList,
						true
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 577:  end_sectionOpt ::= $Empty
            //
            case 577:
                setResult(null);
                break;

            //
            // Rule 579:  end_section ::= end expression_block
            //
            case 579: {
               //#line 1570 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS blockExpCS = (BlockExpCS) getRhsSym(2);
				CSTNode result = createMappingEndCS(
						blockExpCS.getBodyExpressions(),
						blockExpCS.getStartOffset(),
						blockExpCS.getEndOffset()
					);
				setOffsets(result, getRhsIToken(1), blockExpCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 580:  end_section ::= end qvtErrorToken
            //
            case 580: {
               //#line 1583 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMappingEndCS(
						ourEmptyEList,
						getRhsIToken(1).getEndOffset(),
						getRhsIToken(1).getStartOffset()
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 581:  typespecOpt ::= $Empty
            //
            case 581:
                setResult(null);
                break;

            //
            // Rule 583:  objectDeclCS ::= typespec
            //
            case 583: {
               //#line 1601 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createOutExpCS(null, (TypeSpecCS)getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 587:  objectDeclCS ::= objectIdentifierCS : typespecOpt
            //
            case 587: {
               //#line 1612 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			SimpleNameCS varName = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getRhsIToken(1));
			setOffsets(varName, getRhsIToken(1));
			CSTNode result = createOutExpCS(varName,(TypeSpecCS)getRhsSym(3));					
			setResult(result);
	                  break;
            }
	
            //
            // Rule 588:  outExpCS ::= object objectDeclCS expression_block
            //
            case 588: {
               //#line 1621 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS blockExpCS = (BlockExpCS) getRhsSym(3);
				CSTNode result = setupOutExpCS(
						(ObjectExpCS) getRhsSym(2),					
						blockExpCS.getBodyExpressions(),
						// passing body positions
						blockExpCS.getStartOffset(),
						blockExpCS.getEndOffset()
					); 
				setOffsets(result, getRhsIToken(1), blockExpCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 589:  outExpCS ::= object objectDeclCS qvtErrorToken
            //
            case 589: {
               //#line 1635 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				ObjectExpCS objectDeclCS = ((ObjectExpCS) getRhsSym(2));  
				CSTNode result = createOutExpCS(
						objectDeclCS.getSimpleNameCS(),						
						objectDeclCS.getTypeSpecCS()
					);
				if (objectDeclCS  == null) {
				    setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				} else {
				    setOffsets(result, getRhsIToken(1), objectDeclCS);
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 590:  featureMappingCallExpCS ::= map simpleNameCS ( argumentsCSopt )
            //
            case 590: {
               //#line 1651 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createFeatureMappingCallExpCS(
						null,
						(SimpleNameCS)getRhsSym(2),
						(EList)getRhsSym(4),
						false
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 591:  featureMappingCallExpCS ::= xmap simpleNameCS ( argumentsCSopt )
            //
            case 591: {
               //#line 1663 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createFeatureMappingCallExpCS(
						null,
						(SimpleNameCS)getRhsSym(2),
						(EList)getRhsSym(4),
						true
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 592:  featureMappingCallExpCS ::= map simpleNameCS :: simpleNameCS ( argumentsCSopt )
            //
            case 592: {
               //#line 1676 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createFeatureMappingCallExpCS(
						(SimpleNameCS)getRhsSym(2),
						(SimpleNameCS)getRhsSym(4),
						(EList)getRhsSym(6),
						false
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 593:  featureMappingCallExpCS ::= xmap simpleNameCS :: simpleNameCS ( argumentsCSopt )
            //
            case 593: {
               //#line 1688 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createFeatureMappingCallExpCS(
						(SimpleNameCS)getRhsSym(2),
						(SimpleNameCS)getRhsSym(4),
						(EList)getRhsSym(6),
						true
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 594:  mappingCallExpCS ::= map pathNameCS ( argumentsCSopt )
            //
            case 594: {
               //#line 1701 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMappingCallExpCS(
						(PathNameCS)getRhsSym(2),
						(EList)getRhsSym(4),
						false
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 595:  mappingCallExpCS ::= xmap pathNameCS ( argumentsCSopt )
            //
            case 595: {
               //#line 1712 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMappingCallExpCS(
						(PathNameCS)getRhsSym(2),
						(EList)getRhsSym(4),
						true
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 596:  resolveConditionOpt ::= $Empty
            //
            case 596:
                setResult(null);
                break;

            //
            // Rule 597:  resolveConditionOpt ::= | OclExpressionCS
            //
            case 597: {
               //#line 1729 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                setResult((OCLExpressionCS)getRhsSym(2));
                      break;
            }
    
            //
            // Rule 598:  resolveConditionOpt ::= | qvtErrorToken
            //
            case 598:
                setResult(null);
                break;

            //
            // Rule 599:  IDENTIFIEROpt ::= $Empty
            //
            case 599:
                setResult(null);
                break;

            //
            // Rule 600:  IDENTIFIEROpt ::= IDENTIFIER :
            //
            case 600: {
               //#line 1741 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                setResult(getRhsIToken(1));
                      break;
            }
    
            //
            // Rule 601:  resolveOpArgsExpCSOpt ::= $Empty
            //
            case 601:
                setResult(null);
                break;

            //
            // Rule 603:  resolveOpArgsExpCS ::= IDENTIFIEROpt typeCS resolveConditionOpt
            //
            case 603: {
               //#line 1752 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveOpArgsExpCS(
                        getRhsIToken(1),      // target_type_variable?
                        (TypeCS)getRhsSym(2),           // type?
                        (OCLExpressionCS)getRhsSym(3)); // condition?
                        setOffsets(result, getRhsIToken(1), getRhsIToken(3));
                    setResult(result);
                      break;
            }
    
            //
            // Rule 608:  lateOpt ::= $Empty
            //
            case 608:
                setResult(null);
                break;

            //
            // Rule 610:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCSOpt )
            //
            case 610: {
               //#line 1772 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveExpCS(
                            getRhsIToken(1),
                        getRhsIToken(2),
                            (ResolveOpArgsExpCS)getRhsSym(4));
                            setOffsets(result, getRhsIToken(1), getRhsIToken(5));
                    setResult(result);
                          break;
            }
        
            //
            // Rule 611:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCSOpt qvtErrorToken
            //
            case 611: {
               //#line 1783 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveExpCS(
                            getRhsIToken(1),
                        getRhsIToken(2),
                        (ResolveOpArgsExpCS)getRhsSym(4));
                        setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 612:  resolveExpCS ::= lateOpt resolveOp qvtErrorToken
            //
            case 612: {
               //#line 1794 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveExpCS(
                        getRhsIToken(1),
                        getRhsIToken(2),
                        null);
                            setOffsets(result, getRhsIToken(1), getRhsIToken(2));
                setResult(result);
                      break;
            }
    
            //
            // Rule 613:  resolveExpCS ::= late qvtErrorToken
            //
            case 613: {
               //#line 1805 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
    			IToken lateToken = getRhsIToken(1);
                CSTNode result = createResolveExpCS(
                        lateToken,
                        new Token(lateToken.getEndOffset(), lateToken.getEndOffset(), LightweightParsersym.TK_resolve),
                        null);
                            setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 618:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier , resolveOpArgsExpCS )
            //
            case 618: {
               //#line 1822 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveInExpCS(
                        getRhsIToken(1),
                        getRhsIToken(2),
                        (ScopedNameCS)getRhsSym(4),
                        (ResolveOpArgsExpCS)getRhsSym(6));
                        setOffsets(result, getRhsIToken(1), getRhsIToken(7));
                setResult(result);
                          break;
            }
        
            //
            // Rule 619:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier )
            //
            case 619: {
               //#line 1834 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveInExpCS(
                        getRhsIToken(1),
                        getRhsIToken(2),
                        (ScopedNameCS)getRhsSym(4),
                        null);
                        setOffsets(result, getRhsIToken(1), getRhsIToken(5));
                setResult(result);
                      break;
            }
    
            //
            // Rule 620:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier , resolveOpArgsExpCSOpt qvtErrorToken
            //
            case 620: {
               //#line 1847 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveInExpCS(
                        getRhsIToken(1),
                        getRhsIToken(2),
                        (ScopedNameCS)getRhsSym(4),
                        (ResolveOpArgsExpCS)getRhsSym(6));
                        setOffsets(result, getRhsIToken(1), getRhsIToken(6));
                setResult(result);
                      break;
            }
    
            //
            // Rule 621:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier qvtErrorToken
            //
            case 621: {
               //#line 1859 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveInExpCS(
                        getRhsIToken(1),
                        getRhsIToken(2),
                        (ScopedNameCS)getRhsSym(4),
                        null);
                        setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 622:  resolveInExpCS ::= lateOpt resolveInOp ( qvtErrorToken
            //
            case 622: {
               //#line 1871 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                    CSTNode result = createResolveInExpCS(
                            getRhsIToken(1),
                        getRhsIToken(2),
							createScopedNameCS(null, ""),  //$NON-NLS-1$
                        null);
                            setOffsets(result, getRhsIToken(1), getRhsIToken(3));
                setResult(result);
                      break;
            }
        
            //
            // Rule 623:  resolveInExpCS ::= lateOpt resolveInOp qvtErrorToken
            //
            case 623: {
               //#line 1883 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveInExpCS(
                        getRhsIToken(1),
                        getRhsIToken(2),
							createScopedNameCS(null, ""),  //$NON-NLS-1$
                        null);
                        setOffsets(result, getRhsIToken(1), getRhsIToken(2));
                setResult(result);
                      break;
            }
    
            //
            // Rule 626:  OperationCallExpCS ::= primaryExpCS -> resolveResolveInExpCS
            //
            case 626: {
               //#line 1899 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
				CallExpCS result = (CallExpCS)getRhsSym(3);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				result.setSource(source);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 627:  OperationCallExpCS ::= primaryExpCS . resolveResolveInExpCS
            //
            case 627: {
               //#line 1908 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
				CallExpCS result = (CallExpCS)getRhsSym(3);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				result.setSource(source);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 629:  OperationCallExpCS ::= primaryExpCS -> featureMappingCallExpCS
            //
            case 629: {
               //#line 1925 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
				CallExpCS result = (CallExpCS)getRhsSym(3);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				result.setSource(source);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 630:  OperationCallExpCS ::= primaryExpCS . featureMappingCallExpCS
            //
            case 630: {
               //#line 1934 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
				CallExpCS result = (CallExpCS)getRhsSym(3);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				result.setSource(source);
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 633:  simpleNameCS ::= this
            //
            
            case 633:

            //
            // Rule 634:  simpleNameCS ::= result
            //
            case 634: {
               //#line 1950 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getRhsIToken(1)
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 635:  letExpSubCS3 ::= untypedInitializedVariableCS
            //
            case 635: {
               //#line 1964 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 636:  letExpSubCS3 ::= letExpSubCS3 , untypedInitializedVariableCS
            //
            case 636: {
               //#line 1971 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 637:  LetExpCS ::= let letExpSubCS3 in OclExpressionCS
            //
            case 637: {
               //#line 1979 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList variables = (EList)getRhsSym(2);
				CSTNode result = createLetExpCS(
						variables,
						(OCLExpressionCS)getRhsSym(4)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 638:  LetExpCS ::= let letExpSubCS3 in qvtErrorToken
            //
            case 638: {
               //#line 1990 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList variables = (EList)getRhsSym(2);
				CSTNode result = createLetExpCS(
						variables,
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, (IToken) null)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 639:  equalityNotNameNotLetCS ::= equalityNotLetCS != relationalNotLetCS
            //
            
            case 639:

            //
            // Rule 640:  equalityWithLetCS ::= equalityNotLetCS != relationalWithLetCS
            //
            case 640: {
               //#line 2007 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.NOT_EQUAL)
						);
				setOffsets(simpleNameCS, getRhsIToken(2));
				EList args = new BasicEList();
				args.add(getRhsSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)getRhsSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)getRhsSym(1), (CSTNode)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 641:  newTypespecCS ::= pathNameCS @ IDENTIFIER
            //
            case 641: {
               //#line 2029 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)getRhsSym(1),
					getRhsIToken(3)
					);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 642:  _import ::= import library unit ;
            //
            case 642: {
               //#line 2043 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createLibraryImportCS(
						(PathNameCS)getRhsSym(3)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 643:  transformation_h ::= qualifierList transformation qualifiedNameCS
            //
            case 643: {
               //#line 2053 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList qualifierList = (EList) getRhsSym(1);
				CSTNode result = createTransformationHeaderCS(
						qualifierList,
						(PathNameCS)getRhsSym(3),
						createSimpleSignatureCS(ourEmptyEList),
						ourEmptyEList,
						null
					);
				if (qualifierList.isEmpty()) {
					setOffsets(result, getRhsIToken(2), (PathNameCS)getRhsSym(3));
				} else {
					setOffsets(result, (CSTNode) qualifierList.get(0), (PathNameCS)getRhsSym(3));
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 645:  renaming ::= rename typeCS . qvtIdentifierCS = StringLiteralExpCS ;
            //
            case 645: {
               //#line 2073 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createRenameCS(
						(TypeCS)getRhsSym(2),
						getRhsIToken(4),
						(StringLiteralExpCS)getRhsSym(6)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 646:  qualifierList ::= $Empty
            //
            
            case 646:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 647:  qualifierList ::= qualifierList qualifier
            //
            case 647: {
               //#line 2093 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) getRhsSym(1);
				result.add(getRhsSym(2));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 648:  qualifier ::= blackbox
            //
            
            case 648:
 
            //
            // Rule 649:  qualifier ::= abstract
            //
            
            case 649:

            //
            // Rule 650:  qualifier ::= static
            //
            case 650: {
               //#line 2105 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getRhsIToken(1));
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 651:  colon_param_listOpt ::= $Empty
            //
            
            case 651:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 652:  colon_param_listOpt ::= : param_list
            //
            case 652: {
               //#line 2116 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(getRhsSym(2));
	                  break;
            }
	
            //
            // Rule 653:  complete_signature ::= simple_signature colon_param_listOpt
            //
            case 653: {
               //#line 2122 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				SimpleSignatureCS simpleSignatureCS = (SimpleSignatureCS)getRhsSym(1);
				EList<ParameterDeclarationCS> resultList = (EList<ParameterDeclarationCS>)getRhsSym(2);
				CSTNode result = createCompleteSignatureCS(simpleSignatureCS, resultList);
				result.setStartOffset(simpleSignatureCS.getStartOffset());
				result.setEndOffset(getEndOffset(simpleSignatureCS.getEndOffset(), resultList));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 654:  simple_signatureOpt ::= $Empty
            //
            case 654:
                setResult(null);
                break;

            //
            // Rule 656:  simple_signature ::= ( param_listOpt )
            //
            case 656: {
               //#line 2137 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSimpleSignatureCS((EList<ParameterDeclarationCS>)getRhsSym(2));
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 657:  param_listOpt ::= $Empty
            //
            
            case 657:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 659:  param_list ::= param_list , param
            //
            case 659: {
               //#line 2149 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 660:  param_list ::= param_list , qvtErrorToken
            //
            case 660: {
               //#line 2156 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 661:  param_list ::= param
            //
            case 661: {
               //#line 2162 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 662:  param_list ::= qvtErrorToken
            //
            case 662: {
               //#line 2169 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				setResult(result);
	                  break;
            }
	
            //
            // Rule 663:  param ::= param_directionOpt IDENTIFIER : typespec
            //
            case 663: {
               //#line 2176 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				DirectionKindCS paramDirectionCS = (DirectionKindCS) getRhsSym(1);
				CSTNode result = createParameterDeclarationCS(
						paramDirectionCS,
						getRhsIToken(2),
						(TypeSpecCS)getRhsSym(4)
					);
				
				result.setStartOffset(paramDirectionCS != null ? paramDirectionCS.getStartOffset() : getRhsIToken(2).getStartOffset());
				result.setEndOffset(((CSTNode)getRhsSym(4)).getEndOffset());
				
				setResult(result);
	                  break;
            }
	
            //
            // Rule 664:  param ::= param_directionOpt typespec
            //
            case 664: {
               //#line 2192 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				DirectionKindCS paramDirectionCS = (DirectionKindCS) getRhsSym(1);
				TypeSpecCS paramTypeCS = (TypeSpecCS) getRhsSym(2);
				CSTNode result = createParameterDeclarationCS(
						paramDirectionCS,
						null,
						paramTypeCS
					);

				result.setStartOffset(paramDirectionCS != null ? paramDirectionCS.getStartOffset() : paramTypeCS.getStartOffset());
				result.setEndOffset(paramTypeCS.getEndOffset());
				
				setResult(result);
	                  break;
            }
	
            //
            // Rule 665:  param_directionOpt ::= $Empty
            //
            case 665:
                setResult(null);
                break;

            //
            // Rule 667:  param_direction ::= in
            //
            case 667: {
               //#line 2213 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.IN
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 668:  param_direction ::= out
            //
            case 668: {
               //#line 2222 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.OUT
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 669:  param_direction ::= inout
            //
            case 669: {
               //#line 2231 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.INOUT
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 670:  typespec ::= typeCS
            //
            case 670: {
               //#line 2242 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)getRhsSym(1),
					null
					);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 671:  typespec ::= typeCS @ IDENTIFIER
            //
            case 671: {
               //#line 2251 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)getRhsSym(1),
					getRhsIToken(3)
					);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 675:  scoped_identifier ::= typeCS2 :: IDENTIFIER
            //
            case 675: {
               //#line 2266 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				ScopedNameCS result = createScopedNameCS((TypeCS)getRhsSym(1), getRhsTokenText(3));		
				setOffsets(result, (CSTNode) getRhsSym(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 676:  scoped_identifier ::= typeCS2 :: qvtErrorToken
            //
            case 676: {
               //#line 2273 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				ScopedNameCS result = createScopedNameCS((TypeCS)getRhsSym(1), ""); 		 //$NON-NLS-1$
				setOffsets(result, (CSTNode) getRhsSym(1), getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 677:  scoped_identifier ::= scoped_identifier2
            //
            case 677: {
               //#line 2280 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS pathNameCS = (PathNameCS)getRhsSym(1);
				String name = pathNameCS.getSimpleNames().remove(pathNameCS.getSimpleNames().size() - 1).getValue();
				TypeCS typeCS = pathNameCS.getSimpleNames().isEmpty() ? null : pathNameCS;

				ScopedNameCS result = createScopedNameCS(typeCS, name);		

				setOffsets(result, pathNameCS);

                                    // reduce the region by the removed name element
				pathNameCS.setEndOffset(pathNameCS.getEndOffset() - (name != null ? name.length() : 0) - 2);
				
				setResult(result);
	                  break;
            }
	
            //
            // Rule 678:  scoped_identifier2 ::= IDENTIFIER
            //
            case 678: {
               //#line 2296 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createPathNameCS(getRhsIToken(1));
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 679:  scoped_identifier2 ::= main
            //
            case 679: {
               //#line 2303 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createPathNameCS(getRhsIToken(1));
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 680:  scoped_identifier2 ::= scoped_identifier2 :: IDENTIFIER
            //
            case 680: {
               //#line 2310 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS result = (PathNameCS)getRhsSym(1);
				result = extendPathNameCS(result, getRhsIToken(3));
				setOffsets(result, result, getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 681:  scoped_identifier2 ::= scoped_identifier2 :: qvtErrorToken
            //
            case 681: {
               //#line 2318 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS result = (PathNameCS)getRhsSym(1);
				result = extendPathNameCS(result, getRhsIToken(3));
				setOffsets(result, result, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 682:  scoped_identifier_list ::= scoped_identifier
            //
            case 682: {
               //#line 2326 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 683:  scoped_identifier_list ::= scoped_identifier_list , scoped_identifier
            //
            case 683: {
               //#line 2333 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 684:  scoped_identifier_list ::= scoped_identifier_list qvtErrorToken
            //
            case 684: {
               //#line 2340 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 685:  qualifiedNameCS ::= qvtIdentifierCS
            //
            case 685: {
               //#line 2347 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createPathNameCS(getRhsIToken(1));
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 686:  qualifiedNameCS ::= qualifiedNameCS . qvtIdentifierCS
            //
            case 686: {
               //#line 2354 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS result = (PathNameCS)getRhsSym(1);
				result = extendPathNameCS(result, getRhsIToken(3));
				setOffsets(result, result, getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 687:  qualifiedNameCS ::= qualifiedNameCS . qvtErrorToken
            //
            case 687: {
               //#line 2362 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS result = (PathNameCS)getRhsSym(1);
				result = extendPathNameCS(result, getRhsIToken(3));
				setOffsets(result, result, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 688:  qualifiedNameCS ::= qualifiedNameCS qvtErrorToken
            //
            case 688: {
               //#line 2370 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS result = (PathNameCS)getRhsSym(1);
				setResult(result);
	                  break;
            }	
	
    
            default:
                break;
        }
        return;
    }
}

