/**
* Essential OCL Grammar
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
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - Bugs 184048, 225493, 243976, 259818, 282882, 287993, 288040, 292112
*   Borland - Bug 242880
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Introducing new LPG templates (299396)
*
* </copyright>
*
* $Id: QVTOParser.java,v 1.6 2010/01/24 13:58:43 sboyko Exp $
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
*
* </copyright>
*
*/

package org.eclipse.m2m.internal.qvt.oml.cst.parser;

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
import org.eclipse.m2m.internal.qvt.oml.cst.temp.ScopedNameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.temp.TempFactory;
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
import org.eclipse.m2m.internal.qvt.oml.cst.temp.ResolveOpArgsExpCS;
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
import org.eclipse.ocl.cst.BooleanLiteralExpCS;
import org.eclipse.ocl.cst.LiteralExpCS;	
import org.eclipse.ocl.cst.DotOrArrowEnum;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.Environment;

public class QVTOParser extends AbstractQVTParser implements RuleAction
{
    private DerivedPrsStream prsStream = null;
    
    private boolean unimplementedSymbolsWarning = false;

    private static ParseTable prsTable = new QVTOParserprs();
    public ParseTable getParseTable() { return prsTable; }

    private BacktrackingParser btParser = null;
    public BacktrackingParser getParser() { return btParser; }

    protected void setResult(Object object) { btParser.setSym1(object); }
    protected Object getRhsSym(int i) { return btParser.getSym(i); }

    protected int getRhsTokenIndex(int i) { return btParser.getToken(i); }
    protected IToken getRhsIToken(int i) { return prsStream.getIToken(getRhsTokenIndex(i)); }
    
    protected int getRhsFirstTokenIndex(int i) { return btParser.getFirstToken(i); }
    protected IToken getRhsFirstIToken(int i) { return prsStream.getIToken(getRhsFirstTokenIndex(i)); }

    protected int getRhsLastTokenIndex(int i) { return btParser.getLastToken(i); }
    protected IToken getRhsLastIToken(int i) { return prsStream.getIToken(getRhsLastTokenIndex(i)); }

    protected int getLeftSpan() { return btParser.getFirstToken(); }
    protected IToken getLeftIToken()  { return prsStream.getIToken(getLeftSpan()); }

    protected int getRightSpan() { return btParser.getLastToken(); }
    protected IToken getRightIToken() { return prsStream.getIToken(getRightSpan()); }

    protected int getRhsErrorTokenIndex(int i)
    {
        int index = btParser.getToken(i);
        IToken err = prsStream.getIToken(index);
        return (err instanceof ErrorToken ? index : 0);
    }
    protected ErrorToken getRhsErrorIToken(int i)
    {
        int index = btParser.getToken(i);
        IToken err = prsStream.getIToken(index);
        return (ErrorToken) (err instanceof ErrorToken ? err : null);
    }

	@SuppressWarnings("nls") //$NON-NLS-1$
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
                    System.out.println("    " + QVTOParsersym.orderedTerminalSymbols[id.intValue()]);                //$NON-NLS-1$
                }
                System.out.println();
            }
        }
        catch(UndefinedEofSymbolException e)
        {
            throw new Error(new UndefinedEofSymbolException
                                ("The Lexer does not implement the Eof symbol " + //$NON-NLS-1$
                                 QVTOParsersym.orderedTerminalSymbols[prsTable.getEoftSymbol()]));
        } 
    }
    
    @SuppressWarnings("nls") //$NON-NLS-1$
    public QVTOParser(QVTOLexer lexer)        
    {
    		super(lexer);
        try
        {
            btParser = new BacktrackingParser(prsStream, prsTable, this);
        }
        catch (NotBacktrackParseTableException e)
        {
            throw new Error(new NotBacktrackParseTableException
                                ("Regenerate QVTOParserprs.java with -BACKTRACK option")); //$NON-NLS-1$
        }
        catch (BadParseSymFileException e)
        {
            throw new Error(new BadParseSymFileException("Bad Parser Symbol File -- QVTOParsersym.java")); //$NON-NLS-1$
        }
        
        ILexStream lexStream = lexer.getILexStream();
        if (lexStream != null) {
        	reset(lexStream);
        }
    }
    
    public int numTokenKinds() { return QVTOParsersym.numTokenKinds; }
    public String[] orderedTerminalSymbols() { return QVTOParsersym.orderedTerminalSymbols; }
    public String getTokenKindName(int kind) { return QVTOParsersym.orderedTerminalSymbols[kind]; }
    public int getEOFTokenKind() { return prsTable.getEoftSymbol(); }
    public DerivedPrsStream getIPrsStream() { return prsStream; }

    public CSTNode parser()
    {
        return parser(null, getDefaultRepairCount());
    }
    
    public CSTNode parser(Monitor monitor)
    {
        return parser(monitor, getDefaultRepairCount());
    }
    
    public CSTNode parser(int error_repair_count)
    {
        return parser(null, error_repair_count);
    }

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
* @since 3.0
*/
protected IToken getIToken(int i) {
	return prsStream.getIToken(i);
}
	
protected String getTokenText(int i) {
	return prsStream.getTokenText(i);
}


	/**
	 * 
	 * QVTo specific part
	 *
	 */
	
	
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
		 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(null);
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
               //#line 253 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IToken iToken = getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1));
                SimpleNameCS result = createConceptualOperationNameCS(iToken);
                setOffsets(result, iToken);
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
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
               //#line 276 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IToken iToken = getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1));
                SimpleNameCS result = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            iToken
                        );
                setOffsets(result, iToken);
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 33:  selfKeywordCS ::= self
            //
            case 33: {
               //#line 295 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IToken iToken = getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1));
                SimpleNameCS result = createSimpleNameCS(
                        SimpleTypeEnum.SELF_LITERAL,
                        iToken
                    );
                setOffsets(result, iToken);
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 34:  simpleNameCS ::= IDENTIFIER
            //
            case 34: {
               //#line 307 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IToken iToken = getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1));
                SimpleNameCS result = createSimpleNameCS(
                        SimpleTypeEnum.IDENTIFIER_LITERAL,
                        iToken
                    );
                setOffsets(result, iToken);
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 37:  pathNameCS ::= simpleNameCS
            //
            case 37: {
               //#line 322 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleName = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                PathNameCS result = createPathNameCS(simpleName);
                setOffsets(result, simpleName);
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 38:  pathNameCS ::= pathNameCS :: unreservedSimpleNameCS
            //
            case 38: {
               //#line 330 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PathNameCS result = (PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
                result = extendPathNameCS(result, simpleNameCS);
                setOffsets(result, result, simpleNameCS);
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 39:  primitiveTypeCS ::= Boolean
            //
            case 39: {
               //#line 343 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.BOOLEAN_LITERAL,
                        getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))
                    );
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 40:  primitiveTypeCS ::= Integer
            //
            case 40: {
               //#line 353 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.INTEGER_LITERAL,
                        getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))
                    );
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 41:  primitiveTypeCS ::= Real
            //
            case 41: {
               //#line 363 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.REAL_LITERAL,
                        getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))
                    );
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 42:  primitiveTypeCS ::= String
            //
            case 42: {
               //#line 373 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.STRING_LITERAL,
                        getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))
                    );
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 43:  primitiveTypeCS ::= UnlimitedNatural
            //
            case 43: {
               //#line 383 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
                        getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))
                    );
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 44:  primitiveTypeCS ::= OclAny
            //
            case 44: {
               //#line 394 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_ANY_LITERAL,
                        getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))
                    );
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 45:  primitiveTypeCS ::= OclInvalid
            //
            case 45: {
               //#line 404 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_INVALID_LITERAL,
                        getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))
                    );
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 46:  primitiveTypeCS ::= OclVoid
            //
            case 46: {
               //#line 414 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_VOID_LITERAL,
                        getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))
                    );
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 47:  CollectionTypeIdentifierCS ::= Set
            //
            case 47: {
               //#line 425 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.SET_LITERAL,
                            getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))
                        );
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 48:  CollectionTypeIdentifierCS ::= Bag
            //
            case 48: {
               //#line 435 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.BAG_LITERAL,
                            getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))
                        );
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 49:  CollectionTypeIdentifierCS ::= Sequence
            //
            case 49: {
               //#line 445 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.SEQUENCE_LITERAL,
                            getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))
                        );
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 50:  CollectionTypeIdentifierCS ::= Collection
            //
            case 50: {
               //#line 455 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.COLLECTION_LITERAL,
                            getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))
                        );
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 51:  CollectionTypeIdentifierCS ::= OrderedSet
            //
            case 51: {
               //#line 465 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL,
                            getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))
                        );
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 56:  collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS )
            //
            case 56: {
               //#line 481 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CollectionTypeCS result = (CollectionTypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                result.setTypeCS((TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
                setOffsets(result, result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 57:  tupleTypeCS ::= Tuple ( tupleTypePartsCSopt )
            //
            case 57: {
               //#line 490 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                 TupleTypeCS result = createTupleTypeCS((EList<VariableCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 58:  tupleTypePartsCSopt ::= $Empty
            //
            case 58: {
               //#line 498 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new BasicEList<VariableCS>());
                      break;
            }
    
            //
            // Rule 60:  tupleTypePartsCS ::= typedUninitializedVariableCS
            //
            case 60: {
               //#line 505 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 61:  tupleTypePartsCS ::= tupleTypePartsCS , typedUninitializedVariableCS
            //
            case 61: {
               //#line 512 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<VariableCS> result = (EList<VariableCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                result.add((VariableCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 62:  untypedUninitializedVariableCS ::= simpleNameCS
            //
            case 62: {
               //#line 523 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS name = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                VariableCS result = createVariableCS(name, null, null);
                setOffsets(result, name);
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 63:  typedUninitializedVariableCS ::= simpleNameCS : typeCS
            //
            case 63: {
               //#line 532 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS name = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                TypeCS type = (TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
                VariableCS result = createVariableCS(name, type, null);
                setOffsets(result, name, type);
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 64:  untypedInitializedVariableCS ::= simpleNameCS = OclExpressionCS
            //
            case 64: {
               //#line 542 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS name = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                OCLExpressionCS initExpression = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
                VariableCS result = createVariableCS(name, null, initExpression);
                setOffsets(result, name, initExpression);
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 65:  typedInitializedVariableCS ::= simpleNameCS : typeCS = OclExpressionCS
            //
            case 65: {
               //#line 552 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS name = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                TypeCS type = (TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
                OCLExpressionCS initExpression = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5);
                VariableCS result = createVariableCS(name, type, initExpression);
                setOffsets(result, name, initExpression);
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 78:  CollectionLiteralExpCS ::= CollectionTypeIdentifierCS { CollectionLiteralPartsCSopt }
            //
            case 78: {
               //#line 585 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CollectionTypeCS typeCS = (CollectionTypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                CollectionLiteralExpCS result = createCollectionLiteralExpCS(
                        typeCS,
                        (EList<CollectionLiteralPartCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3)
                    );
                setOffsets(result, typeCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 79:  CollectionLiteralPartsCSopt ::= $Empty
            //
            case 79: {
               //#line 608 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new BasicEList<CollectionLiteralPartCS>());
                      break;
            }
    
            //
            // Rule 81:  CollectionLiteralPartsCS ::= CollectionLiteralPartCS
            //
            case 81: {
               //#line 615 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<CollectionLiteralPartCS> result = new BasicEList<CollectionLiteralPartCS>();
                result.add((CollectionLiteralPartCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 82:  CollectionLiteralPartsCS ::= CollectionLiteralPartsCS , CollectionLiteralPartCS
            //
            case 82: {
               //#line 622 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<CollectionLiteralPartCS> result = (EList<CollectionLiteralPartCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                result.add((CollectionLiteralPartCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 84:  CollectionLiteralPartCS ::= OclExpressionCS
            //
            case 84: {
               //#line 631 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CollectionLiteralPartCS result = createCollectionLiteralPartCS(
                        (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1)
                    );
                setOffsets(result, (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 85:  CollectionRangeCS ::= OclExpressionCS .. OclExpressionCS
            //
            case 85: {
               //#line 641 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CollectionLiteralPartCS result = createCollectionRangeCS(
                        (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1),
                        (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3)
                    );
                setOffsets(result, (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 93:  TupleLiteralExpCS ::= Tuple { TupleLiteralPartsCS }
            //
            case 93: {
               //#line 660 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                TupleLiteralExpCS result = createTupleLiteralExpCS((EList<VariableCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 94:  TupleLiteralPartsCS ::= initializedVariableCS
            //
            case 94: {
               //#line 668 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 95:  TupleLiteralPartsCS ::= TupleLiteralPartsCS , initializedVariableCS
            //
            case 95: {
               //#line 675 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<VariableCS> result = (EList<VariableCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                result.add((VariableCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 96:  IntegerLiteralExpCS ::= INTEGER_LITERAL
            //
            case 96: {
               //#line 683 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IntegerLiteralExpCS result = createIntegerLiteralExpCS(getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 97:  RealLiteralExpCS ::= REAL_LITERAL
            //
            case 97: {
               //#line 691 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                RealLiteralExpCS result = createRealLiteralExpCS(getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 98:  StringLiteralExpCS ::= STRING_LITERAL
            //
            case 98: {
               //#line 699 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IToken literalToken = getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1));
                StringLiteralExpCS result = createStringLiteralExpCS(literalToken);
                setOffsets(result, literalToken);
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 99:  StringLiteralExpCS ::= StringLiteralExpCS STRING_LITERAL
            //
            case 99: {
               //#line 707 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                StringLiteralExpCS string = (StringLiteralExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                IToken literalToken = getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2));
                StringLiteralExpCS result = extendStringLiteralExpCS(string, literalToken);
                setOffsets(result, string, literalToken);
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 100:  BooleanLiteralExpCS ::= true
            //
            case 100: {
               //#line 717 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                BooleanLiteralExpCS result = createBooleanLiteralExpCS(getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 101:  BooleanLiteralExpCS ::= false
            //
            case 101: {
               //#line 724 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                BooleanLiteralExpCS result = createBooleanLiteralExpCS(getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 102:  UnlimitedNaturalLiteralExpCS ::= *
            //
            case 102: {
               //#line 732 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                UnlimitedNaturalLiteralExpCS result = createUnlimitedNaturalLiteralExpCS(getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 103:  InvalidLiteralExpCS ::= invalid
            //
            case 103: {
               //#line 740 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                InvalidLiteralExpCS result = createInvalidLiteralExpCS(getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 104:  NullLiteralExpCS ::= null
            //
            case 104: {
               //#line 748 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                NullLiteralExpCS result = createNullLiteralExpCS(getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
     
            //
            // Rule 105:  TypeLiteralExpCS ::= primitiveTypeCS
            //
            
            case 105:
 
            //
            // Rule 106:  TypeLiteralExpCS ::= collectionTypeCS
            //
            
            case 106:

            //
            // Rule 107:  TypeLiteralExpCS ::= tupleTypeCS
            //
            case 107: {
               //#line 762 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 112:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( uninitializedVariableCS | OclExpressionCS )
            //
            case 112: {
               //#line 787 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
                IteratorExpCS result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5),
                        null,
                        (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(7)
                    );
                setOffsets(result, source, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(8)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 113:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( simpleNameCS , uninitializedVariableCS | OclExpressionCS )
            //
            case 113: {
               //#line 804 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS name = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5);
                VariableCS variableCS = createVariableCS(name, null, null);
                setOffsets(variableCS, name);
                OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
                IteratorExpCS result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        variableCS,
                        (VariableCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(7),
                        (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(9)
                    );
                setOffsets(result, source, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(10)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 114:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( typedUninitializedVariableCS , uninitializedVariableCS | OclExpressionCS )
            //
            case 114: {
               //#line 824 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
                IteratorExpCS result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5),
                        (VariableCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(7),
                        (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(9)
                    );
                setOffsets(result, source, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(10)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 115:  IterateExpCS ::= primaryExpCS -> simpleNameCS ( typedInitializedVariableCS | OclExpressionCS )
            //
            case 115: {
               //#line 845 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
                IterateExpCS result = createIterateExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5),
                        null,
                        (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(7)
                    );
                setOffsets(result, source, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(8)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 116:  IterateExpCS ::= primaryExpCS -> simpleNameCS ( uninitializedVariableCS ; typedInitializedVariableCS | OclExpressionCS )
            //
            case 116: {
               //#line 861 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
                IterateExpCS result = createIterateExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5),
                        (VariableCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(7),
                        (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(9)
                    );
                setOffsets(result, source, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(10)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 120:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( )
            //
            case 120: {
               //#line 883 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                OperationCallExpCS result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
                        null,
                        new BasicEList<OCLExpressionCS>()
                    );
                setOffsets(result, source, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(5)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 121:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( OclExpressionCS )
            //
            case 121: {
               //#line 897 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
                OCLExpressionCS arg = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5);
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
                setOffsets(result, source, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(6)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 122:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( notNameExpressionCS , argumentsCS )
            //
            case 122: {
               //#line 927 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<OCLExpressionCS> args = (EList<OCLExpressionCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(7);
                args.add(0, (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5));
                OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                OperationCallExpCS result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
                        null,
                        args
                    );
                setOffsets(result, source, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(8)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 123:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( simpleNameCS , argumentsCS )
            //
            case 123: {
               //#line 943 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5);
                OCLExpressionCS variableExpCS = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(variableExpCS, simpleNameCS);
                EList<OCLExpressionCS> args = (EList<OCLExpressionCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(7);
                args.add(0, variableExpCS);
                OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                OperationCallExpCS result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
                        null,
                        args
                    );
                setOffsets(result, source, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(8)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
     
            //
            // Rule 124:  OperationCallExpCS ::= primaryExpCS . conceptualOperationNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            
            case 124:

            //
            // Rule 125:  OperationCallExpCS ::= primaryExpCS . simpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 125: {
               //#line 969 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
                OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                CallExpCS result = createDotOperationCallExpCS(
                        source,
                        null,
                        simpleNameCS,
                        (IsMarkedPreCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
                        (EList<OCLExpressionCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6)
                    );
                setOffsets(result, source, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(7)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 126:  OperationCallExpCS ::= simpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 126: {
               //#line 985 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OperationCallExpCS result = createDotOperationCallExpCS(
                        null,
                        null,
                        (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1),
                        (IsMarkedPreCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
                        (EList<OCLExpressionCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4)
                    );
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(5)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 127:  OperationCallExpCS ::= pathNameCS :: unreservedSimpleNameCS ( argumentsCSopt )
            //
            case 127: {
               //#line 999 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PathNameCS pathNameCS = (PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
                OperationCallExpCS result = createDotOperationCallExpCS(
                        null,
                        pathNameCS,
                        simpleNameCS,
                        null,
                        (EList<OCLExpressionCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5)
                    );
                setOffsets(result, pathNameCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(6)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 128:  OperationCallExpCS ::= primaryExpCS . pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 128: {
               //#line 1017 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PathNameCS pathNameCS = (PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
                SimpleNameCS simpleNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5);
                OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                CallExpCS result = createDotOperationCallExpCS(
                        source,
                        pathNameCS,
                        simpleNameCS,
                        (IsMarkedPreCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6),
                        (EList<OCLExpressionCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(8)
                    );
                setOffsets(result, source, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(9)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 130:  PropertyCallExpCS ::= pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt
            //
            case 130: {
               //#line 1041 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PathNameCS pathNameCS = (PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4);
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
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 131:  PropertyCallExpCS ::= primaryExpCS . pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt
            //
            case 131: {
               //#line 1062 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                PathNameCS pathNameCS = (PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
                SimpleNameCS simpleNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6);
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
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 132:  AssociationClassCallExpCS ::= primaryExpCS . simpleNameCS isMarkedPreCSopt
            //
            case 132: {
               //#line 1085 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4);
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
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 133:  isMarkedPreCSopt ::= $Empty
            //
            case 133: {
               //#line 1147 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(null);
                      break;
            }
    
            //
            // Rule 134:  argumentsCSopt ::= $Empty
            //
            case 134: {
               //#line 1153 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new BasicEList<OCLExpressionCS>());
                      break;
            }
    
            //
            // Rule 136:  argumentsCS ::= OclExpressionCS
            //
            case 136: {
               //#line 1160 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<OCLExpressionCS> result = new BasicEList<OCLExpressionCS>();
                result.add((OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 137:  argumentsCS ::= argumentsCS , OclExpressionCS
            //
            case 137: {
               //#line 1167 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<OCLExpressionCS> result = (EList<OCLExpressionCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                result.add((OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 140:  VariableExpCS ::= selfKeywordCS
            //
            case 140: {
               //#line 1192 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 141:  SimpleNameExpCS ::= simpleNameCS
            //
            case 141: {
               //#line 1207 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
     
            //
            // Rule 147:  impliesNotNameNotLetCS ::= impliesNotLetCS implies xorNotLetCS
            //
            
            case 147:
 
            //
            // Rule 149:  impliesWithLetCS ::= impliesNotLetCS implies xorWithLetCS
            //
            
            case 149:
 
            //
            // Rule 153:  xorNotNameNotLetCS ::= xorNotLetCS xor orNotLetCS
            //
            
            case 153:
 
            //
            // Rule 155:  xorWithLetCS ::= xorNotLetCS xor orWithLetCS
            //
            
            case 155:
 
            //
            // Rule 159:  orNotNameNotLetCS ::= orNotLetCS or andNotLetCS
            //
            
            case 159:
 
            //
            // Rule 161:  orWithLetCS ::= orNotLetCS or andWithLetCS
            //
            
            case 161:
 
            //
            // Rule 165:  andNotNameNotLetCS ::= andNotLetCS and equalityNotLetCS
            //
            
            case 165:
 
            //
            // Rule 167:  andWithLetCS ::= andNotLetCS and equalityWithLetCS
            //
            
            case 167:
 
            //
            // Rule 171:  equalityNotNameNotLetCS ::= equalityNotLetCS = relationalNotLetCS
            //
            
            case 171:
 
            //
            // Rule 172:  equalityNotNameNotLetCS ::= equalityNotLetCS <> relationalNotLetCS
            //
            
            case 172:
 
            //
            // Rule 174:  equalityWithLetCS ::= equalityNotLetCS = relationalWithLetCS
            //
            
            case 174:
 
            //
            // Rule 175:  equalityWithLetCS ::= equalityNotLetCS <> relationalWithLetCS
            //
            
            case 175:
 
            //
            // Rule 179:  relationalNotNameNotLetCS ::= relationalNotLetCS > additiveNotLetCS
            //
            
            case 179:
 
            //
            // Rule 180:  relationalNotNameNotLetCS ::= relationalNotLetCS < additiveNotLetCS
            //
            
            case 180:
 
            //
            // Rule 181:  relationalNotNameNotLetCS ::= relationalNotLetCS >= additiveNotLetCS
            //
            
            case 181:
 
            //
            // Rule 182:  relationalNotNameNotLetCS ::= relationalNotLetCS <= additiveNotLetCS
            //
            
            case 182:
 
            //
            // Rule 184:  relationalWithLetCS ::= relationalNotLetCS > additiveWithLetCS
            //
            
            case 184:
 
            //
            // Rule 185:  relationalWithLetCS ::= relationalNotLetCS < additiveWithLetCS
            //
            
            case 185:
 
            //
            // Rule 186:  relationalWithLetCS ::= relationalNotLetCS >= additiveWithLetCS
            //
            
            case 186:
 
            //
            // Rule 187:  relationalWithLetCS ::= relationalNotLetCS <= additiveWithLetCS
            //
            
            case 187:
 
            //
            // Rule 191:  additiveNotNameNotLetCS ::= additiveNotLetCS + multiplicativeNotLetCS
            //
            
            case 191:
 
            //
            // Rule 192:  additiveNotNameNotLetCS ::= additiveNotLetCS - multiplicativeNotLetCS
            //
            
            case 192:
 
            //
            // Rule 194:  additiveWithLetCS ::= additiveNotLetCS + multiplicativeWithLetCS
            //
            
            case 194:
 
            //
            // Rule 195:  additiveWithLetCS ::= additiveNotLetCS - multiplicativeWithLetCS
            //
            
            case 195:
 
            //
            // Rule 199:  multiplicativeNotNameNotLetCS ::= multiplicativeNotLetCS * unaryNotLetCS
            //
            
            case 199:
 
            //
            // Rule 200:  multiplicativeNotNameNotLetCS ::= multiplicativeNotLetCS / unaryNotLetCS
            //
            
            case 200:
 
            //
            // Rule 202:  multiplicativeWithLetCS ::= multiplicativeNotLetCS * unaryWithLetCS
            //
            
            case 202:

            //
            // Rule 203:  multiplicativeWithLetCS ::= multiplicativeNotLetCS / unaryWithLetCS
            //
            case 203: {
               //#line 1316 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2))
                        );
                setOffsets(simpleNameCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
                OCLExpressionCS left = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                OCLExpressionCS right = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
                EList<OCLExpressionCS> args = new BasicEList<OCLExpressionCS>();
                args.add(right);
                OperationCallExpCS result = createOperationCallExpCS(
                        left,
                        simpleNameCS,
                        args
                    );
                setOffsets(result, left, right);
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
     
            //
            // Rule 207:  unaryNotNameNotLetCS ::= - unaryNotLetCS
            //
            
            case 207:
 
            //
            // Rule 208:  unaryNotNameNotLetCS ::= not unaryNotLetCS
            //
            
            case 208:
 
            //
            // Rule 210:  unaryWithLetCS ::= - unaryWithLetCS
            //
            
            case 210:

            //
            // Rule 211:  unaryWithLetCS ::= not unaryWithLetCS
            //
            case 211: {
               //#line 1347 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))
                        );
                setOffsets(simpleNameCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                OCLExpressionCS expr = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
                OperationCallExpCS result = createOperationCallExpCS(
                        expr,
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>()
                    );
                setOffsets(result, simpleNameCS, expr);
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 218:  primaryNotNameCS ::= ( OclExpressionCS )
            //
            case 218: {
               //#line 1373 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS result = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
                if (result instanceof OperationCallExpCS) {
                    ((OperationCallExpCS)result).setIsAtomic(true);
                }
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 219:  LetExpCS ::= let letVariablesCS in OclExpressionCS
            //
            case 219: {
               //#line 1396 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS expr = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4);
                LetExpCS result = createLetExpCS(
                        (EList<VariableCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
                        expr
                    );
                setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), expr);
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 220:  letVariablesCS ::= typedInitializedVariableCS
            //
            case 220: {
               //#line 1408 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 221:  letVariablesCS ::= letVariablesCS , typedInitializedVariableCS
            //
            case 221: {
               //#line 1415 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<VariableCS> result = (EList<VariableCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                result.add((VariableCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
     
            //
            // Rule 222:  qualifierList ::= $Empty
            //
            
            case 222:
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new BasicEList<Object>());
                break;

            //
            // Rule 223:  qualifierList ::= qualifierList qualifier
            //
            case 223: {
               //#line 249 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	 
            //
            // Rule 224:  qualifier ::= blackbox
            //
            
            case 224:
 
            //
            // Rule 225:  qualifier ::= abstract
            //
            
            case 225:

            //
            // Rule 226:  qualifier ::= static
            //
            case 226: {
               //#line 261 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	 
            //
            // Rule 227:  colon_param_listOpt ::= $Empty
            //
            
            case 227:
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new BasicEList<Object>());
                break;

            //
            // Rule 228:  colon_param_listOpt ::= : param_list
            //
            case 228: {
               //#line 271 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));
	                  break;
            }
	
            //
            // Rule 229:  complete_signature ::= simple_signature colon_param_listOpt
            //
            case 229: {
               //#line 277 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				SimpleSignatureCS simpleSignatureCS = (SimpleSignatureCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				EList<ParameterDeclarationCS> resultList = (EList<ParameterDeclarationCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				CSTNode result = createCompleteSignatureCS(simpleSignatureCS, resultList);
				result.setStartOffset(simpleSignatureCS.getStartOffset());
				result.setEndOffset(getEndOffset(simpleSignatureCS.getEndOffset(), resultList));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 230:  simple_signatureOpt ::= $Empty
            //
            case 230:
                setResult(null);
                break;

            //
            // Rule 232:  simple_signature ::= ( param_listOpt )
            //
            case 232: {
               //#line 292 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSimpleSignatureCS((EList<ParameterDeclarationCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	 
            //
            // Rule 233:  param_listOpt ::= $Empty
            //
            
            case 233:
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new BasicEList<Object>());
                break;

            //
            // Rule 235:  param_list ::= param_list , param
            //
            case 235: {
               //#line 304 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 236:  param_list ::= param_list , qvtErrorToken
            //
            case 236: {
               //#line 311 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 237:  param_list ::= param
            //
            case 237: {
               //#line 317 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 238:  param_list ::= qvtErrorToken
            //
            case 238: {
               //#line 324 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 239:  param ::= param_directionOpt IDENTIFIER : typespec
            //
            case 239: {
               //#line 331 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				DirectionKindCS paramDirectionCS = (DirectionKindCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				CSTNode result = createParameterDeclarationCS(
						paramDirectionCS,
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)),
						(TypeSpecCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4)
					);
				
				result.setStartOffset(paramDirectionCS != null ? paramDirectionCS.getStartOffset() : getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)).getStartOffset());
				result.setEndOffset(((CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4)).getEndOffset());
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 240:  param ::= param_directionOpt typespec
            //
            case 240: {
               //#line 347 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				DirectionKindCS paramDirectionCS = (DirectionKindCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				TypeSpecCS paramTypeCS = (TypeSpecCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				CSTNode result = createParameterDeclarationCS(
						paramDirectionCS,
						null,
						paramTypeCS
					);

				result.setStartOffset(paramDirectionCS != null ? paramDirectionCS.getStartOffset() : paramTypeCS.getStartOffset());
				result.setEndOffset(paramTypeCS.getEndOffset());
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 241:  param_directionOpt ::= $Empty
            //
            case 241:
                setResult(null);
                break;

            //
            // Rule 243:  param_direction ::= in
            //
            case 243: {
               //#line 368 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.IN
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 244:  param_direction ::= out
            //
            case 244: {
               //#line 378 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.OUT
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 245:  param_direction ::= inout
            //
            case 245: {
               //#line 388 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.INOUT
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 248:  declarator1 ::= IDENTIFIER : typeCS
            //
            case 248: {
               //#line 401 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
						(TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						null
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 249:  declarator1 ::= IDENTIFIER : typeCS = OclExpressionCS
            //
            case 249: {
               //#line 413 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
						(TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 250:  declarator1 ::= IDENTIFIER : typeCS := OclExpressionCS
            //
            case 250: {
               //#line 425 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
						(TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 251:  declarator2 ::= IDENTIFIER := OclExpressionCS
            //
            case 251: {
               //#line 437 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
						null,
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 252:  typespec ::= typeCS
            //
            case 252: {
               //#line 449 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createTypeSpecCS(
					(TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1),
					null
					);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 253:  typespec ::= typeCS @ IDENTIFIER
            //
            case 253: {
               //#line 459 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createTypeSpecCS(
					(TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1),
					getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3))
					);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 257:  scoped_identifier ::= typeCS2 :: IDENTIFIER
            //
            case 257: {
               //#line 473 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				ScopedNameCS result = createScopedNameCS((TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1), getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));		
				setOffsets(result, (CSTNode)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 258:  scoped_identifier ::= typeCS2 :: qvtErrorToken
            //
            case 258: {
               //#line 480 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				ScopedNameCS result = createScopedNameCS((TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1), ""); 		 //$NON-NLS-1$
				setOffsets(result, (CSTNode)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 259:  scoped_identifier ::= scoped_identifier2
            //
            case 259: {
               //#line 487 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS pathNameCS = (PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				String name = pathNameCS.getSimpleNames().remove(pathNameCS.getSimpleNames().size() - 1).getValue();
				TypeCS typeCS = pathNameCS.getSimpleNames().isEmpty() ? null : pathNameCS;

				ScopedNameCS result = createScopedNameCS(typeCS, name);		

				setOffsets(result, pathNameCS);

                                    // reduce the region by the removed name element
				pathNameCS.setEndOffset(pathNameCS.getEndOffset() - (name != null ? name.length() : 0) - 2);
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 260:  scoped_identifier2 ::= IDENTIFIER
            //
            case 260: {
               //#line 503 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createPathNameCS(getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 261:  scoped_identifier2 ::= main
            //
            case 261: {
               //#line 510 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createPathNameCS(getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 262:  scoped_identifier2 ::= scoped_identifier2 :: IDENTIFIER
            //
            case 262: {
               //#line 517 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS result = (PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result = extendPathNameCS(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
				setOffsets(result, result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 263:  scoped_identifier2 ::= scoped_identifier2 :: qvtErrorToken
            //
            case 263: {
               //#line 525 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS result = (PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result = extendPathNameCS(result, (IToken) null);
				setOffsets(result, result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 264:  scoped_identifier_list ::= scoped_identifier
            //
            case 264: {
               //#line 533 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 265:  scoped_identifier_list ::= scoped_identifier_list , scoped_identifier
            //
            case 265: {
               //#line 540 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 266:  scoped_identifier_list ::= scoped_identifier_list qvtErrorToken
            //
            case 266: {
               //#line 547 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	 
            //
            // Rule 269:  expression_listOpt ::= $Empty
            //
            
            case 269:
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new BasicEList<Object>());
                break;

            //
            // Rule 273:  expression_semi_list ::= expression_semi_list_element
            //
            case 273: {
               //#line 564 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				Object element =  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				if (element instanceof EList) {
					result.addAll((EList) element);
				} else {
					result.add(element);
				}
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 274:  expression_semi_list ::= expression_semi_list ; expression_semi_list_element
            //
            case 274: {
               //#line 576 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				Object element =  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				if (element instanceof EList) {
					result.addAll((EList) element);
				} else {
					result.add(element);
				}
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 275:  expression_semi_list ::= expression_semi_list qvtErrorToken
            //
            case 275: {
               //#line 588 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 276:  expression_block ::= { expression_listOpt }
            //
            case 276: {
               //#line 595 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			EList bodyList = (EList)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
			CSTNode result = createBlockExpCS(
				bodyList
			);
			
			setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
			 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                          break;
            }
	
            //
            // Rule 277:  expression_block ::= { qvtErrorToken
            //
            case 277: {
               //#line 607 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			CSTNode result = createBlockExpCS(
				ourEmptyEList
			);
			
			setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
			 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                          break;
            }
	
            //
            // Rule 280:  qualifiedNameCS ::= qvtIdentifierCS
            //
            case 280: {
               //#line 621 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createPathNameCS(getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 281:  qualifiedNameCS ::= qualifiedNameCS . qvtIdentifierCS
            //
            case 281: {
               //#line 628 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS result = (PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result = extendPathNameCS(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
				setOffsets(result, result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 282:  qualifiedNameCS ::= qualifiedNameCS . qvtErrorToken
            //
            case 282: {
               //#line 636 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS result = (PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result = extendPathNameCS(result, (IToken) null);
				setOffsets(result, result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 283:  qualifiedNameCS ::= qualifiedNameCS qvtErrorToken
            //
            case 283: {
               //#line 644 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS result = (PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }	
	
            //
            // Rule 285:  oclExpressionCSOpt ::= $Empty
            //
            case 285:
                setResult(null);
                break;

            //
            // Rule 286:  letExpSubCS3 ::= untypedInitializedVariableCS
            //
            case 286: {
               //#line 659 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 287:  letExpSubCS3 ::= letExpSubCS3 , untypedInitializedVariableCS
            //
            case 287: {
               //#line 667 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 288:  LetExpCS ::= let letExpSubCS3 in OclExpressionCS
            //
            case 288: {
               //#line 675 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList variables = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				CSTNode result = createLetExpCS(
						variables,
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 289:  LetExpCS ::= let letExpSubCS3 in qvtErrorToken
            //
            case 289: {
               //#line 686 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList variables = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				CSTNode result = createLetExpCS(
						variables,
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, (IToken) null)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 290:  CallExpCS ::= primaryExpCS . qvtErrorToken
            //
            case 290: {
               //#line 701 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
	 			result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				setOffsets(result, (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 291:  CallExpCS ::= primaryExpCS -> qvtErrorToken
            //
            case 291: {
               //#line 709 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
	 			result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				setOffsets(result, (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	 
            //
            // Rule 292:  argumentsCS ::= qvtErrorToken
            //
            
            case 292:
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new BasicEList<Object>());
                break;

            //
            // Rule 294:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( qvtErrorToken
            //
            case 294: {
               //#line 722 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				CSTNode result = createIteratorExpCS(
						source,
						simpleNameCS,
						null,
						null,
						null
					);
				setOffsets(result, source, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 296:  qvtErrorToken ::= ERROR_TOKEN
            //
            case 296: {
               //#line 744 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				diagnozeErrorToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1));
	                  break;
            }
	 
            //
            // Rule 297:  equalityNotNameNotLetCS ::= equalityNotLetCS != relationalNotLetCS
            //
            
            case 297:

            //
            // Rule 298:  equalityWithLetCS ::= equalityNotLetCS != relationalWithLetCS
            //
            case 298: {
               //#line 754 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.NOT_EQUAL)
						);
				setOffsets(simpleNameCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
				EList args = new BasicEList();
				args.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 300:  listTypeCS ::= List ( typeCS )
            //
            case 300: {
               //#line 122 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createListTypeCS(
						(TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 301:  listLiteralCS ::= List { CollectionLiteralPartsCSopt }
            //
            case 301: {
               //#line 132 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createListLiteralExpCS((EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 303:  dictTypeCS ::= Dict ( typeCS , typeCS )
            //
            case 303: {
               //#line 141 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createDictTypeCS((TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3), (TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5));
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(6)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 304:  dictLiteralCS ::= Dict { dictLiteralPartListCSopt }
            //
            case 304: {
               //#line 149 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createDictLiteralExpCS((EList<DictLiteralPartCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 308:  dictLiteralPartCS ::= literalSimpleCS = OclExpressionCS
            //
            case 308: {
               //#line 161 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createDictLiteralPartCS((LiteralExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1), (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	 
            //
            // Rule 310:  dictLiteralPartListCSopt ::= $Empty
            //
            
            case 310:
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new BasicEList<Object>());
                break;

            //
            // Rule 311:  dictLiteralPartListCS ::= dictLiteralPartCS
            //
            case 311: {
               //#line 173 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 312:  dictLiteralPartListCS ::= dictLiteralPartListCS , dictLiteralPartCS
            //
            case 312: {
               //#line 180 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 313:  dictLiteralPartListCS ::= dictLiteralPartListCS qvtErrorToken
            //
            case 313: {
               //#line 187 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 315:  returnExpCS ::= return oclExpressionCSOpt
            //
            case 315: {
               //#line 195 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			ReturnExpCS returnExpCS = createReturnExpCS((OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));
			CSTNode result = createExpressionStatementCS(returnExpCS);
			if(returnExpCS.getValue() != null) {
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));			
			} else {
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
			}
			setOffsets(returnExpCS, result);
			 /* macro setSym1 is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 317:  var_init_group_exp ::= var var_init_declarator_list
            //
            case 317: {
               //#line 211 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));
	                  break;
            }
	
            //
            // Rule 318:  var_init_group_exp ::= var ( var_init_declarator_list )
            //
            case 318: {
               //#line 217 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
	                  break;
            }
	
            //
            // Rule 319:  var_init_group_exp ::= var ( var_init_declarator_list qvtErrorToken
            //
            case 319: {
               //#line 223 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
	                  break;
            }
	
            //
            // Rule 321:  var_init_exp ::= var var_init_declarator
            //
            case 321: {
               //#line 231 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));
	                  break;
            }
	
            //
            // Rule 322:  var_init_exp ::= var ( var_init_declarator )
            //
            case 322: {
               //#line 237 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
	                  break;
            }
	
            //
            // Rule 323:  var_init_exp ::= var ( var_init_declarator qvtErrorToken
            //
            case 323: {
               //#line 243 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
	                  break;
            }
	
            //
            // Rule 324:  var_init_exp ::= var qvtErrorToken
            //
            case 324: {
               //#line 249 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(ourEmptyEList);
	                  break;
            }
	
            //
            // Rule 325:  var_init_declarator_list ::= var_init_declarator , var_init_declarator
            //
            case 325: {
               //#line 255 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 326:  var_init_declarator_list ::= var_init_declarator_list , var_init_declarator
            //
            case 326: {
               //#line 263 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 327:  var_init_declarator ::= IDENTIFIER : typeCS var_init_op OclExpressionCS
            //
            case 327: {
               //#line 272 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableInitializationCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
						(TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5),
						(Boolean) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 328:  var_init_declarator ::= IDENTIFIER : typeCS var_init_op qvtErrorToken
            //
            case 328: {
               //#line 284 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableInitializationCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
						(TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						null,
						(Boolean) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 329:  var_init_declarator ::= IDENTIFIER var_init_op OclExpressionCS
            //
            case 329: {
               //#line 296 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableInitializationCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
						null,
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						(Boolean) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 330:  var_init_declarator ::= IDENTIFIER var_init_op qvtErrorToken
            //
            case 330: {
               //#line 308 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableInitializationCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
						null,
						null,
						(Boolean) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 331:  var_init_declarator ::= IDENTIFIER : typeCS
            //
            case 331: {
               //#line 320 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableInitializationCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
						(TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						null,
						false
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 332:  var_init_declarator ::= IDENTIFIER : qvtErrorToken
            //
            case 332: {
               //#line 332 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableInitializationCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
						null,
						null,
						false
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	 
            //
            // Rule 333:  var_init_op ::= =
            //
            
            case 333:

            //
            // Rule 334:  var_init_op ::= :=
            //
            case 334: {
               //#line 347 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(false);
	                  break;
            }
	
            //
            // Rule 335:  var_init_op ::= ::=
            //
            case 335: {
               //#line 352 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(true);
	                  break;
            }
	
            //
            // Rule 337:  assignStatementCS ::= primaryExpCS := OclExpressionCS
            //
            case 337: {
               //#line 360 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createAssignStatementCS(
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1),
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						false
					);
				setOffsets(result, (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 338:  assignStatementCS ::= primaryExpCS := qvtErrorToken
            //
            case 338: {
               //#line 371 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createAssignStatementCS(
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1),
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, (IToken) null),
						false
					);
				setOffsets(result, (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 339:  assignStatementCS ::= primaryExpCS += OclExpressionCS
            //
            case 339: {
               //#line 383 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createAssignStatementCS(
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1),
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						true
					);
				setOffsets(result, (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 340:  assignStatementCS ::= primaryExpCS += qvtErrorToken
            //
            case 340: {
               //#line 394 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createAssignStatementCS(
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1),
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, (IToken) null),
						true
					);
				setOffsets(result, (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 342:  whileExpCS ::= while ( declarator1 ; OclExpressionCS ) whileBodyCS
            //
            case 342: {
               //#line 410 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createWhileExpCS(
						(VariableCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5),
						(BlockExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(7)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(7));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 343:  whileExpCS ::= while ( assignStatementCS ; OclExpressionCS ) whileBodyCS
            //
            case 343: {
               //#line 422 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				AssignStatementCS assignment = (AssignStatementCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				CSTNode result = createWhileExpCS(
						getVariableFromAssignment(assignment),
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5),
						(BlockExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(7)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(7));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 344:  whileExpCS ::= while ( OclExpressionCS ) whileBodyCS
            //
            case 344: {
               //#line 435 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createWhileExpCS(
						null,
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						(BlockExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 345:  IteratorExpCS ::= primaryExpCS -> forExpCS
            //
            case 345: {
               //#line 449 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				ForExpCS forExpCS = (ForExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				forExpCS.setSource(source);
				setOffsets(forExpCS, source, forExpCS);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(forExpCS);
	                  break;
            }
	
            //
            // Rule 348:  forExpDeclaratorList ::= IDENTIFIER
            //
            case 348: {
               //#line 462 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		EList result = new BasicEList();
		result.add(getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
		 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                          break;
            }
    	
            //
            // Rule 349:  forExpDeclaratorList ::= forExpDeclaratorList , IDENTIFIER
            //
            case 349: {
               //#line 469 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
		result.add(getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
		 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                          break;
            }
    	
            //
            // Rule 350:  forExpConditionOpt ::= $Empty
            //
            case 350:
                setResult(null);
                break;

            //
            // Rule 351:  forExpConditionOpt ::= | OclExpressionCS
            //
            case 351: {
               //#line 481 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
            	     /* macro setResult is deprecated. Use function setResult */ getParser().setSym1((OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));
                          break;
            }
    	
            //
            // Rule 352:  forExpConditionOpt ::= | qvtErrorToken
            //
            case 352:
                setResult(null);
                break;

            //
            // Rule 353:  forExpCS ::= forOpCode ( forExpDeclaratorList forExpConditionOpt ) expression_block
            //
            case 353: {
               //#line 490 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createForExpCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
						(EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
						(BlockExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 354:  forExpCS ::= forOpCode qvtErrorToken
            //
            case 354: {
               //#line 503 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createForExpCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
						null,
						null,
						null
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 358:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS else ifExpBodyCS endif
            //
            case 358: {
               //#line 527 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCS(
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(7)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 359:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS endif
            //
            case 359: {
               //#line 539 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCS(
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
						null
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(5)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 360:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS else ifExpBodyCS qvtErrorToken
            //
            case 360: {
               //#line 551 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCS(
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 361:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS else qvtErrorToken
            //
            case 361: {
               //#line 563 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCS(
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
						null
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(5)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 362:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS qvtErrorToken
            //
            case 362: {
               //#line 575 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCS(
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
						null
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 363:  IfExpCS ::= if OclExpressionCS then qvtErrorToken
            //
            case 363: {
               //#line 587 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCS(
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						null,
						null
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 364:  IfExpCS ::= if OclExpressionCS qvtErrorToken
            //
            case 364: {
               //#line 599 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCS(
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						null,
						null
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 365:  IfExpCS ::= if qvtErrorToken
            //
            case 365: {
               //#line 612 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS invalidCondition = createInvalidLiteralExpCS(""); //$NON-NLS-1$
				invalidCondition.setStartOffset(getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)).getEndOffset());
				invalidCondition.setEndOffset(getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)).getEndOffset());
				CSTNode result = createIfExpCS(
						invalidCondition,
						null,
						null
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 367:  switchExpCS ::= switch switchBodyExpCS
            //
            case 367: {
               //#line 633 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] switchBody = (Object[])  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);

				CSTNode result = createSwitchExpCS(
						(EList<SwitchAltExpCS>) switchBody[0],
						(OCLExpressionCS) switchBody[1]
					);
				if (switchBody[2] instanceof IToken) { // In case of correct and incorrect syntax
					setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (IToken) switchBody[2]);
				} else { // In case of errors in switchBody
					setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode) switchBody[2]);
				}
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 369:  switchDeclaratorCS ::= IDENTIFIER
            //
            case 369: {
               //#line 652 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
						null,
						null
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 370:  switchDeclaratorCS ::= IDENTIFIER = OclExpressionCS
            //
            case 370: {
               //#line 664 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
						null,
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 371:  IterateExpCS ::= primaryExpCS -> switch ( switchDeclaratorCS ) switchBodyExpCS
            //
            case 371: {
               //#line 677 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] switchBody = (Object[])  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(7);

				OCLExpressionCS switchExpCS = (OCLExpressionCS) createSwitchExpCS(
						(EList<SwitchAltExpCS>) switchBody[0],
						(OCLExpressionCS) switchBody[1]							
					);
				if (switchBody[2] instanceof IToken) { // In case of correct and incorrect syntax
					setOffsets(switchExpCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)), (IToken) switchBody[2]);
				} else if (switchBody[2] instanceof CSTNode) { // In case of errors in switchBody
					setOffsets(switchExpCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)), (CSTNode) switchBody[2]);
				} else { // In case of errors in switchBody
					setOffsets(switchExpCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(6)));
				}

				EList<VariableCS> iterators = new BasicEList<VariableCS>();
				iterators.add((VariableCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5));
				CallExpCS result = createImperativeIterateExpCS(
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "xcollect"),  //$NON-NLS-1$
						iterators,
						null,
						switchExpCS,
						null
					);
					
				result.setSource((OCLExpressionCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(7)));
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 372:  switchExpCS ::= switch qvtErrorToken
            //
            case 372: {
               //#line 710 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchExpCS(
						new BasicEList(),
						null
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 373:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt }
            //
            case 373: {
               //#line 721 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] result = new Object[] { /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4))};
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 374:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt qvtErrorToken
            //
            case 374: {
               //#line 728 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] result = new Object[] { /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3)};
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 375:  switchBodyExpCS ::= { qvtErrorToken
            //
            case 375: {
               //#line 735 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] result = new Object[] {new BasicEList(), null, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))};
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 376:  switchAltExpCSList ::= switchAltExpCS
            //
            case 376: {
               //#line 742 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 377:  switchAltExpCSList ::= switchAltExpCSList switchAltExpCS
            //
            case 377: {
               //#line 749 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 378:  switchAltExpCS ::= case ( OclExpressionCS ) expression_statement
            //
            case 378: {
               //#line 757 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						(OCLExpressionCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(5)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 379:  switchAltExpCS ::= case ( OclExpressionCS ) qvtErrorToken
            //
            case 379: {
               //#line 767 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						null
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 380:  switchElseExpCSOpt ::= $Empty
            //
            case 380:
                setResult(null);
                break;

            //
            // Rule 382:  switchElseExpCS ::= else expression_statement
            //
            case 382: {
               //#line 782 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1((CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));
	                  break;
            }
	
            //
            // Rule 383:  switchElseExpCS ::= else qvtErrorToken
            //
            case 383: {
               //#line 787 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(null);
	                  break;
            }
	
            //
            // Rule 384:  OclExpressionCS ::= primaryOCLExpressionCS
            //
            case 384: {
               //#line 795 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createExpressionStatementCS(
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1)
					);
				setOffsets(result, (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 386:  logWhenExp ::= when OclExpressionCS
            //
            case 386: {
               //#line 809 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			OCLExpressionCS condition = (OCLExpressionCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
			 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(condition);
                      break;
            }
    
            //
            // Rule 388:  logWhenExpOpt ::= $Empty
            //
            case 388:
                setResult(null);
                break;

            //
            // Rule 389:  logExpCS ::= log ( argumentsCSopt ) logWhenExpOpt
            //
            case 389: {
               //#line 820 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			OCLExpressionCS condition = (OCLExpressionCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5);
			LogExpCS result = (LogExpCS)createLogExpCS((EList<OCLExpressionCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3), condition);
			if(condition != null) {
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), condition);
			} else {
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
			}
			 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 391:  severityKindCS ::= simpleNameCS
            //
            case 391: {
               //#line 836 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
	                  break;
            }
	
            //
            // Rule 393:  severityKindCSOpt ::= $Empty
            //
            case 393:
                setResult(null);
                break;

            //
            // Rule 394:  assertWithLogExp ::= with logExpCS
            //
            case 394: {
               //#line 848 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			LogExpCS logExp = (LogExpCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
			setOffsets(logExp, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)), logExp);
			 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(logExp);
                      break;
            }
    
            //
            // Rule 396:  assertWithLogExpOpt ::= $Empty
            //
            case 396:
                setResult(null);
                break;

            //
            // Rule 397:  assertExpCS ::= assert severityKindCSOpt ( OclExpressionCS ) assertWithLogExpOpt
            //
            case 397: {
               //#line 860 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			LogExpCS logExpCS = (LogExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6);
			OCLExpressionCS condition = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4);
			AssertExpCS result = (AssertExpCS)createAssertExpCS(condition, (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2), logExpCS);
	
			CSTNode end = logExpCS != null ? logExpCS : condition; 
			setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), end);
			 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 398:  computeExpCS ::= compute ( declarator ) expression_block
            //
            case 398: {
               //#line 875 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createComputeExpCS(
					(VariableCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
					(OCLExpressionCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5)
				);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(5)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 400:  IterateExpCS ::= primaryExpCS -> imperativeIterateExpCS
            //
            case 400: {
               //#line 893 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				ImperativeIterateExpCS iterateExpCS = (ImperativeIterateExpCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				iterateExpCS.setSource(source);
				setOffsets(iterateExpCS, source, iterateExpCS);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(iterateExpCS);
	                  break;
            }
	 
            //
            // Rule 409:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken12 ( imperativeIterContents12 )
            //
            
            case 409:

            //
            // Rule 410:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken3 ( imperativeIterContents3 )
            //
            case 410: {
               //#line 922 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				String opCode = getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1));
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))
						);
				setOffsets(simpleNameCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				Object[] iterContents = (Object[])  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
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
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 411:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken qvtErrorToken
            //
            case 411: {
               //#line 951 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))
						);
				setOffsets(simpleNameCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				CSTNode result = createImperativeIterateExpCS(
						simpleNameCS,
						ourEmptyEList,
						null,
						null,
						null
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 412:  imperativeIterContents12 ::= OclExpressionCS
            //
            case 412: {
               //#line 971 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new Object[] {
						ourEmptyEList,
						null,
						 /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1)
					});
	                  break;
            }
	
            //
            // Rule 413:  imperativeIterContents12 ::= uninitializedVariableCS | OclExpressionCS
            //
            case 413: {
               //#line 981 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList iters = new BasicEList();
				iters.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new Object[] {
						iters,
						null,
						 /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3)
					});
	                  break;
            }
	
            //
            // Rule 414:  imperativeIterContents12 ::= simpleNameCS , variableDeclarationListCS | OclExpressionCS
            //
            case 414: {
               //#line 994 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS name = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
                CSTNode variableCS = createVariableCS(name, null, null);
                setOffsets(variableCS, name);

				EList iters = (EList)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				iters.add(0, variableCS);
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new Object[] {
						iters,
						null,
						 /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5)
					});
	                  break;
            }
	
            //
            // Rule 415:  imperativeIterContents3 ::= variableDeclarationListCS ; initializedVariableCS | OclExpressionCS
            //
            case 415: {
               //#line 1011 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new Object[] {
						 /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1),
						 /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						 /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5)
					});
	                  break;
            }
	
            //
            // Rule 416:  variableDeclarationListCS ::= uninitializedVariableCS
            //
            case 416: {
               //#line 1021 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 417:  variableDeclarationListCS ::= variableDeclarationListCS , uninitializedVariableCS
            //
            case 417: {
               //#line 1028 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 418:  exclamationOpt ::= $Empty
            //
            case 418:
                setResult(null);
                break;

            //
            // Rule 420:  declarator_vsep ::= IDENTIFIER |
            //
            case 420: {
               //#line 1044 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		CSTNode result = createVariableCS(
					getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
                                            null,
					null
					);
                    setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                     /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                          break;
            }
    	
            //
            // Rule 421:  declarator_vsepOpt ::= $Empty
            //
            case 421:
                setResult(null);
                break;

            //
            // Rule 423:  IterateExpCS ::= primaryExpCS exclamationOpt [ declarator_vsepOpt OclExpressionCS ]
            //
            case 423: {
               //#line 1061 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
		if (source instanceof ImperativeIterateExpCS) {
			String opCode = isTokenOfType(getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)), QVTOParsersym.TK_EXCLAMATION_MARK) 
				?  "collectselectOne"  //$NON-NLS-1$
				: "collectselect";  //$NON-NLS-1$
			SimpleNameCS simpleNameCS = createSimpleNameCS(
					SimpleTypeEnum.KEYWORD_LITERAL,
					opCode
					);
			setOffsets(simpleNameCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(6)));

			ImperativeIterateExpCS result = (ImperativeIterateExpCS) source;
			result.setSimpleNameCS(simpleNameCS);
			
			VariableCS variableCS = (VariableCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4);
	        if (variableCS != null) {
	            result.setTarget(variableCS);
	        }
	        result.setCondition((OCLExpressionCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5));
			
			setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(6)));
			 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
		}
		else {
			String opCode = isTokenOfType(getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)), QVTOParsersym.TK_EXCLAMATION_MARK) 
				?  "selectOne"  //$NON-NLS-1$
				: "xselect";  //$NON-NLS-1$
			SimpleNameCS simpleNameCS = createSimpleNameCS(
					SimpleTypeEnum.KEYWORD_LITERAL,
					opCode
					);
			setOffsets(simpleNameCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(6)));
			
			CallExpCS result = createImperativeIterateExpCS(
					simpleNameCS,
					ourEmptyEList,
					(VariableCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
					null,
					(OCLExpressionCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5)
					);
			result.setSource(source);
			setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(6)));
			 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
		}
	                  break;
            }
	
            //
            // Rule 424:  IterateExpCS ::= primaryExpCS -> simpleNameCS
            //
            case 424: {
               //#line 1111 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		String opCode = "xcollect";  //$NON-NLS-1$
		SimpleNameCS simpleNameCS = createSimpleNameCS(
				SimpleTypeEnum.KEYWORD_LITERAL,
				opCode
				);

		OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
		SimpleNameCS featureNameCS = (SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
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
		setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
		 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 426:  newExpCS ::= new newTypespecCS ( argumentsCSopt )
            //
            case 426: {
               //#line 1173 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			OCLExpressionCS result = createNewRuleCallExpCS((TypeSpecCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2), (EList)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4));
			setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(5)));
			 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 427:  newTypespecCS ::= pathNameCS
            //
            case 427: {
               //#line 1181 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createTypeSpecCS(
					(TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1),
					null
					);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 428:  newTypespecCS ::= pathNameCS @ IDENTIFIER
            //
            case 428: {
               //#line 1191 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createTypeSpecCS(
					(TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1),
					getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3))
					);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 429:  primaryNotNameCS ::= break
            //
            case 429: {
               //#line 1204 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			OCLExpressionCS result = createBreakCS();
			setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
			 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 430:  primaryNotNameCS ::= continue
            //
            case 430: {
               //#line 1212 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			OCLExpressionCS result = createContinueCS();
			setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
			 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 431:  switchAltExpCS ::= ( OclExpressionCS ) ? OclExpressionCS ;
            //
            case 431: {
               //#line 1221 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchAltExpCSDeprecated(
						(OCLExpressionCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						(OCLExpressionCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(6)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 432:  switchAltExpCS ::= ( OclExpressionCS ) qvtErrorToken
            //
            case 432: {
               //#line 1231 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchAltExpCSDeprecated(
						(OCLExpressionCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						null
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 433:  switchAltExpCS ::= ( qvtErrorToken
            //
            case 433: {
               //#line 1241 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchAltExpCSDeprecated(
						null,
						null
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 434:  switchElseExpCS ::= else ? OclExpressionCS ;
            //
            case 434: {
               //#line 1252 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		    	int startOffset = getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)).getStartOffset();
		    	int endOffset = getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)).getEndOffset();
				reportWarning(org.eclipse.m2m.internal.qvt.oml.cst.parser.NLS.bind(org.eclipse.m2m.internal.qvt.oml.cst.parser.Messages.AbstractQVTParser_DeprecatedSwitchElseExp, null), startOffset, endOffset);
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1((CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
	                  break;
            }
	
            //
            // Rule 435:  switchElseExpCS ::= else ? OclExpressionCS qvtErrorToken
            //
            case 435: {
               //#line 1261 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		    	int startOffset = getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)).getStartOffset();
		    	int endOffset = getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)).getEndOffset();
				reportWarning(org.eclipse.m2m.internal.qvt.oml.cst.parser.NLS.bind(org.eclipse.m2m.internal.qvt.oml.cst.parser.Messages.AbstractQVTParser_DeprecatedSwitchElseExp, null), startOffset, endOffset);
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1((CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
	                  break;
            }
	
            //
            // Rule 436:  topLevel ::= unit_elementList
            //
            case 436: {
               //#line 187 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<CSTNode> unitElements = (EList<CSTNode>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(setupTopLevel(unitElements));
	                  break;
            }
	
            //
            // Rule 438:  _import ::= import unit ;
            //
            case 438: {
               //#line 196 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createImportCS(
						(PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 439:  _import ::= import qvtErrorToken
            //
            case 439: {
               //#line 206 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createLibraryImportCS(
						createPathNameCS()
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 441:  unit_elementList ::= unit_elementList unit_element
            //
            case 441: {
               //#line 220 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList list = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				list.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(list);
	                  break;
            }
	 
            //
            // Rule 442:  unit_elementList ::= $Empty
            //
            
            case 442:
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new BasicEList<Object>());
                break;

            //
            // Rule 453:  unit_element ::= qvtErrorToken
            //
            case 453:
                setResult(null);
                break;

            //
            // Rule 456:  transformation_decl ::= transformation_h ;
            //
            case 456: {
               //#line 249 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				setOffsets(headerCS, headerCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
				MappingModuleCS moduleCS = createMappingModuleCS(headerCS, ourEmptyEList);
				setOffsets(moduleCS, headerCS);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(moduleCS);
	                  break;
            }
	
            //
            // Rule 457:  transformation_def ::= transformation_h { module_elementList } semicolonOpt
            //
            case 457: {
               //#line 259 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				MappingModuleCS moduleCS = createMappingModuleCS(headerCS, (EList)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				setOffsets(moduleCS, headerCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(moduleCS);
	                  break;
            }
	
            //
            // Rule 460:  library_decl ::= library_h ;
            //
            case 460: {
               //#line 271 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				setOffsets(headerCS, headerCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
				MappingModuleCS moduleCS = createLibraryCS(headerCS, ourEmptyEList);
				setOffsets(moduleCS, headerCS);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(moduleCS);
	                  break;
            }
	
            //
            // Rule 461:  library_def ::= library_h { module_elementList } semicolonOpt
            //
            case 461: {
               //#line 281 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				MappingModuleCS moduleCS = createLibraryCS(headerCS, (EList)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				setOffsets(moduleCS, headerCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(moduleCS);
	                  break;
            }
	
            //
            // Rule 462:  transformation_h ::= qualifierList transformation qualifiedNameCS transformation_signature transformation_usage_refineOpt
            //
            case 462: {
               //#line 293 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList qualifierList = (EList)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				EList transfUsages = ourEmptyEList;
				TransformationRefineCS transfRefine = null;
				Object transformation_usage_refineOpt =  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5);
				if (transformation_usage_refineOpt instanceof TransformationRefineCS) {
					transfRefine = (TransformationRefineCS) transformation_usage_refineOpt;
				} else if (transformation_usage_refineOpt instanceof EList) {
					transfUsages = (EList) transformation_usage_refineOpt;
				}
				CSTNode result = createTransformationHeaderCS(
						qualifierList,
						(PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						(SimpleSignatureCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
						transfUsages,
						transfRefine
					);
				if (qualifierList.isEmpty()) {
					setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
				} else {
					setOffsets(result, (CSTNode) qualifierList.get(0));
				}
				if (transfRefine == null) {
					if (transfUsages.isEmpty()) {
						setOffsets(result, result, (SimpleSignatureCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4));
					}
					else {
						setOffsets(result, result, (CSTNode) transfUsages.get(transfUsages.size()-1));
					}
				} else {
					setOffsets(result, result, transfRefine);
				}
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 463:  transformation_usage_refineOpt ::= $Empty
            //
            case 463:
                setResult(null);
                break;

            //
            // Rule 468:  transformation_refine ::= refines moduleref
            //
            case 468: {
               //#line 340 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createTransformationRefineCS(
						(ModuleRefCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2)
					);
				setOffsets(result, (ModuleRefCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 469:  library_h ::= library qualifiedNameCS library_signatureOpt module_usageListOpt
            //
            case 469: {
               //#line 353 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS name = (PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				SimpleSignatureCS signature = ( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3) == null) ? createSimpleSignatureCS(ourEmptyEList) : (SimpleSignatureCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				EList<ModuleUsageCS> moduleUsages = (EList<ModuleUsageCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4);
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
				} else if ( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3) != null) {
					rightNode = signature;
				}
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), rightNode);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 470:  library_h ::= library qvtErrorToken
            //
            case 470: {
               //#line 375 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createTransformationHeaderCS(
						ourEmptyEList,
						createPathNameCS(),
						createSimpleSignatureCS(ourEmptyEList),
						ourEmptyEList,
						null
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 471:  library_signatureOpt ::= $Empty
            //
            case 471:
                setResult(null);
                break;

            //
            // Rule 474:  module_usageList ::= module_usage
            //
            case 474: {
               //#line 397 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 475:  module_usageList ::= module_usageList module_usage
            //
            case 475: {
               //#line 404 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	 
            //
            // Rule 476:  module_usageListOpt ::= $Empty
            //
            
            case 476:
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new BasicEList<Object>());
                break;

            //
            // Rule 480:  access_usage ::= access module_kindOpt moduleref_list
            //
            case 480: {
               //#line 419 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList moduleRefList = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				CSTNode result = createModuleUsageCS(
						ImportKindEnum.ACCESS,
						(ModuleKindCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						moduleRefList
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode)moduleRefList.get(moduleRefList.size()-1));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 481:  extends_usage ::= extends module_kindOpt moduleref_list
            //
            case 481: {
               //#line 431 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList moduleRefList = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				CSTNode result = createModuleUsageCS(
						ImportKindEnum.EXTENSION,
						(ModuleKindCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						moduleRefList
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (CSTNode)moduleRefList.get(moduleRefList.size()-1));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 482:  module_kindOpt ::= $Empty
            //
            case 482:
                setResult(null);
                break;

            //
            // Rule 484:  module_kind ::= transformation
            //
            case 484: {
               //#line 448 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.TRANSFORMATION
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 485:  module_kind ::= library
            //
            case 485: {
               //#line 457 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.LIBRARY
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 486:  moduleref_list ::= moduleref
            //
            case 486: {
               //#line 467 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 487:  moduleref_list ::= moduleref_list , moduleref
            //
            case 487: {
               //#line 474 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 488:  moduleref_list ::= moduleref_list qvtErrorToken
            //
            case 488: {
               //#line 481 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 489:  moduleref ::= pathNameCS simple_signatureOpt
            //
            case 489: {
               //#line 488 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				SimpleSignatureCS signature = (SimpleSignatureCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				CSTNode result = createModuleRefCS(
						(PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1),
						signature 
					);
				CSTNode rightNode = (signature == null) ? (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1) : signature;
				setOffsets(result, (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1), rightNode);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 490:  module_elementList ::= module_elementList module_element
            //
            case 490: {
               //#line 503 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList list = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				list.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(list);
	                  break;
            }
	 
            //
            // Rule 491:  module_elementList ::= $Empty
            //
            
            case 491:
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new BasicEList<Object>());
                break;

            //
            // Rule 499:  module_element ::= qvtErrorToken
            //
            case 499:
                setResult(null);
                break;

            //
            // Rule 500:  _modeltype ::= modeltype IDENTIFIER compliance_kindOpt uses packageref_list modeltype_whereOpt ;
            //
            case 500: {
               //#line 526 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList whereList = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6);
				EList packageRefList = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5);
				ModelTypeCS result = createModelTypeCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)),
						(StringLiteralExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						packageRefList,
						whereList
					);
				if (whereList.isEmpty()) {
					setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(7)));
				}
				else {
					CSTNode lastPackageRefCS = (CSTNode)packageRefList.get(packageRefList.size()-1);
					setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), lastPackageRefCS);
					setBodyOffsets(result, lastPackageRefCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(7)));
				}
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 501:  _modeltype ::= modeltype qvtErrorToken
            //
            case 501: {
               //#line 547 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				ModelTypeCS result = createModelTypeCS(
						new Token(0, 0, 0),
						null,
						ourEmptyEList,
						ourEmptyEList
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	 
            //
            // Rule 502:  modeltype_whereOpt ::= $Empty
            //
            
            case 502:
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new BasicEList<Object>());
                break;

            //
            // Rule 504:  modeltype_where ::= where expression_block
            //
            case 504: {
               //#line 564 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS blockExpCS = (BlockExpCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(blockExpCS.getBodyExpressions());
	                  break;
            }
	
            //
            // Rule 505:  packageref_list ::= packageref
            //
            case 505: {
               //#line 571 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 506:  packageref_list ::= packageref_list , packageref
            //
            case 506: {
               //#line 578 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 507:  packageref_list ::= packageref_list qvtErrorToken
            //
            case 507: {
               //#line 585 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 508:  packageref ::= pathNameCS
            //
            case 508: {
               //#line 592 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createPackageRefCS(
						(PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1),
						null
					);
				setOffsets(result, (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 509:  packageref ::= pathNameCS ( uri )
            //
            case 509: {
               //#line 602 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createPackageRefCS(
						(PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1),
						(StringLiteralExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3)
					);
				setOffsets(result, (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 510:  packageref ::= uri
            //
            case 510: {
               //#line 612 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createPackageRefCS(
						null,
						(StringLiteralExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1)
					);
				setOffsets(result, (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 511:  compliance_kindOpt ::= $Empty
            //
            case 511:
                setResult(null);
                break;

            //
            // Rule 515:  classifierDefCS ::= intermediate class qvtIdentifierCS classifierExtensionOpt { classifierFeatureListOpt } semicolonOpt
            //
            case 515: {
               //#line 635 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createClassifierDefCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)),
						(EList)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
						(EList)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(7)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	 
            //
            // Rule 516:  classifierExtensionOpt ::= $Empty
            //
            
            case 516:
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new BasicEList<Object>());
                break;

            //
            // Rule 517:  classifierExtensionOpt ::= extends type_list
            //
            case 517: {
               //#line 649 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 518:  type_list ::= typeCS
            //
            case 518: {
               //#line 655 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 519:  type_list ::= type_list , typeCS
            //
            case 519: {
               //#line 662 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 520:  type_list ::= type_list qvtErrorToken
            //
            case 520: {
               //#line 669 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	 
            //
            // Rule 521:  classifierFeatureListOpt ::= $Empty
            //
            
            case 521:
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new BasicEList<Object>());
                break;

            //
            // Rule 523:  classifierFeatureList ::= classifierFeatureCS
            //
            case 523: {
               //#line 680 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 524:  classifierFeatureList ::= classifierFeatureList ; classifierFeatureCS
            //
            case 524: {
               //#line 687 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 525:  classifierFeatureList ::= classifierFeatureList qvtErrorToken
            //
            case 525: {
               //#line 694 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 526:  classifierFeatureCS ::= stereotype_qualifier_list feature_key_list qvtIdentifierCS : typeCS multiplicityOpt ordered_prop opposite_propertyOpt init_partOpt
            //
            case 526: {
               //#line 701 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList stereotypeQualifiers = (EList)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				EList featureKeys = (EList)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				MultiplicityDefCS multiplicityDef = (MultiplicityDefCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6);
				OppositePropertyCS oppositeProperty = (OppositePropertyCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(8);
				OCLExpressionCS initExpression = (OCLExpressionCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(9);
				CSTNode result = createClassifierPropertyCS(
						stereotypeQualifiers,
						featureKeys,
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)),
						(TypeCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5),
						((BooleanLiteralExpCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(7)).getBooleanSymbol().booleanValue(),
						initExpression,
						multiplicityDef,
						oppositeProperty
					);
				
				int startOffset = getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)).getStartOffset();
				if (!featureKeys.isEmpty()) {
					startOffset = ((CSTNode) featureKeys.get(0)).getStartOffset();
				}
				if (!stereotypeQualifiers.isEmpty()) {
					startOffset = ((IToken) stereotypeQualifiers.get(0)).getStartOffset();
				}
				
				CSTNode lastToken = (CSTNode)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5);
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
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 528:  init_partOpt ::= $Empty
            //
            case 528:
                setResult(null);
                break;

            //
            // Rule 529:  init_partOpt ::= = OclExpressionCS
            //
            case 529: {
               //#line 747 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = (CSTNode)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	 
            //
            // Rule 530:  stereotype_qualifier_list ::= $Empty
            //
            
            case 530:
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new BasicEList<Object>());
                break;

            //
            // Rule 531:  stereotype_qualifier_list ::= STEREOTYPE_QUALIFIER_OPEN identifier_list STEREOTYPE_QUALIFIER_CLOSE
            //
            case 531: {
               //#line 756 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 532:  identifier_list ::= qvtIdentifierCS
            //
            case 532: {
               //#line 763 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = new BasicEList();
				result.add(getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 533:  identifier_list ::= identifier_list , qvtIdentifierCS
            //
            case 533: {
               //#line 770 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result.add(getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 534:  identifier_list ::= identifier_list qvtErrorToken
            //
            case 534: {
               //#line 777 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	 
            //
            // Rule 535:  feature_key_list ::= $Empty
            //
            
            case 535:
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new BasicEList<Object>());
                break;

            //
            // Rule 536:  feature_key_list ::= feature_key_list feature_key
            //
            case 536: {
               //#line 786 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				result.add( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 537:  feature_key_list ::= feature_key_list qvtErrorToken
            //
            case 537: {
               //#line 793 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	 
            //
            // Rule 538:  feature_key ::= composes
            //
            
            case 538:
 
            //
            // Rule 539:  feature_key ::= references
            //
            
            case 539:
 
            //
            // Rule 540:  feature_key ::= readonly
            //
            
            case 540:
 
            //
            // Rule 541:  feature_key ::= derived
            //
            
            case 541:

            //
            // Rule 542:  feature_key ::= static
            //
            case 542: {
               //#line 808 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 543:  multiplicityOpt ::= $Empty
            //
            case 543:
                setResult(null);
                break;

            //
            // Rule 544:  multiplicityOpt ::= LBRACKET multiplicity_range RBRACKET
            //
            case 544: {
               //#line 818 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = (CSTNode)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 545:  multiplicity_range ::= IntegerLiteralExpCS
            //
            case 545: {
               //#line 825 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMultiplicityDefCS(
						(PrimitiveLiteralExpCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1),
						(PrimitiveLiteralExpCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 546:  multiplicity_range ::= UnlimitedNaturalLiteralExpCS
            //
            case 546: {
               //#line 835 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PrimitiveLiteralExpCS lowerBound = createIntegerLiteralExpCS(Integer.toString(0));
				setOffsets(lowerBound, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				CSTNode result = createMultiplicityDefCS(
						lowerBound, 
						(PrimitiveLiteralExpCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	 
            //
            // Rule 547:  multiplicity_range ::= IntegerLiteralExpCS MULTIPLICITY_RANGE IntegerLiteralExpCS
            //
            
            case 547:
 
            //
            // Rule 548:  multiplicity_range ::= IntegerLiteralExpCS DOTDOT IntegerLiteralExpCS
            //
            
            case 548:
 
            //
            // Rule 549:  multiplicity_range ::= IntegerLiteralExpCS MULTIPLICITY_RANGE UnlimitedNaturalLiteralExpCS
            //
            
            case 549:

            //
            // Rule 550:  multiplicity_range ::= IntegerLiteralExpCS DOTDOT UnlimitedNaturalLiteralExpCS
            //
            case 550: {
               //#line 853 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMultiplicityDefCS(
						(PrimitiveLiteralExpCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1),
						(PrimitiveLiteralExpCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 551:  ordered_prop ::= ordered
            //
            case 551: {
               //#line 864 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.TRUE.toString());
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 552:  ordered_prop ::= $Empty
            //
            case 552: {
               //#line 871 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.FALSE.toString());
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 553:  opposite_propertyOpt ::= $Empty
            //
            case 553:
                setResult(null);
                break;

            //
            // Rule 554:  opposite_propertyOpt ::= opposites navigable_prop qvtIdentifierCS multiplicityOpt
            //
            case 554: {
               //#line 880 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MultiplicityDefCS multiplicityDef = (MultiplicityDefCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4);
				CSTNode result = createOppositePropertyCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)),
						((BooleanLiteralExpCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2)).getBooleanSymbol().booleanValue(),
						multiplicityDef
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
				if (multiplicityDef != null) {
					result.setEndOffset(multiplicityDef.getEndOffset());
				}
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 555:  navigable_prop ::= ~
            //
            case 555: {
               //#line 896 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.FALSE.toString());
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 556:  navigable_prop ::= $Empty
            //
            case 556: {
               //#line 903 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.TRUE.toString());
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 557:  _property ::= configuration property qvtIdentifierCS : typeCS ;
            //
            case 557: {
               //#line 912 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createConfigPropertyCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)),
						(TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(6)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 558:  _property ::= configuration property qvtIdentifierCS : typeCS qvtErrorToken
            //
            case 558: {
               //#line 922 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createConfigPropertyCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)),
						(TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(5)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 559:  _property ::= property qvtIdentifierCS : typeCS = OclExpressionCS ;
            //
            case 559: {
               //#line 932 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createLocalPropertyCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)),
						(TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(7)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 560:  _property ::= property qvtIdentifierCS = OclExpressionCS ;
            //
            case 560: {
               //#line 943 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createLocalPropertyCS(
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)),
						null,
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(5)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 561:  _property ::= intermediate property scoped_identifier : typeCS ;
            //
            case 561: {
               //#line 954 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createContextualPropertyCS(
						(ScopedNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						(TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5),
						null
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(6)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 562:  _property ::= intermediate property scoped_identifier : typeCS = OclExpressionCS ;
            //
            case 562: {
               //#line 965 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createContextualPropertyCS(
						(ScopedNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						(TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5),
						(OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(7)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(8)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 566:  helper_header ::= helper_info scoped_identifier complete_signature
            //
            case 566: {
               //#line 983 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CompleteSignatureCS completeSignature = (CompleteSignatureCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				Object[] helperInfo = (Object[]) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					null,
					(ScopedNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
					completeSignature.getSimpleSignature().getParams(),
					completeSignature.getResultParams()
				);
				setOffsets(mappingDeclarationCS, (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2), (CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>) helperInfo[0];
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				IToken helperKind = (IToken) helperInfo[1];
				mappingDeclarationCS.setIsQuery(helperKind.getKind() == QVTOParsersym.TK_query);
				mappingDeclarationCS.setStartOffset(helperKind.getStartOffset());

				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(mappingDeclarationCS);
	                  break;
            }
	
            //
            // Rule 567:  helper_header ::= helper_info qvtErrorToken
            //
            case 567: {
               //#line 1008 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] helperInfo = (Object[]) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
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
				mappingDeclarationCS.setIsQuery(helperKind.getKind() == QVTOParsersym.TK_query);
				mappingDeclarationCS.setStartOffset(helperKind.getStartOffset());

				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(mappingDeclarationCS);
	                  break;
            }
	
            //
            // Rule 568:  helper_info ::= qualifierList helper_kind
            //
            case 568: {
               //#line 1032 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new Object[] { /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2))});
	                  break;
            }
	
            //
            // Rule 571:  helper_decl ::= helper_header ;
            //
            case 571: {
               //#line 1041 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				MappingQueryCS result = createMappingQueryCS(
						false,
						mappingDecl,
						ourEmptyEList
					);
				result.setBlackBox(true);
				setOffsets(result, mappingDecl, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 572:  helper_decl ::= helper_header qvtErrorToken
            //
            case 572: {
               //#line 1055 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				MappingQueryCS result = createMappingQueryCS(
						false,
						mappingDecl,
						ourEmptyEList
					);
				result.setBlackBox(true);
				setOffsets(result, mappingDecl);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 573:  helper_simple_def ::= helper_header = OclExpressionCS ;
            //
            case 573: {
               //#line 1069 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				OCLExpressionCS expression = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				EList<OCLExpressionCS> expressionList = new BasicEList();
				expressionList.add(expression);
				MappingQueryCS result = createMappingQueryCS(
						false,
						mappingDecl,
						expressionList
					);
				result.setIsSimpleDefinition(true);
				setOffsets(result, mappingDecl, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 574:  helper_compound_def ::= helper_header expression_block semicolonOpt
            //
            case 574: {
               //#line 1086 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				BlockExpCS blockExpCS = (BlockExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				CSTNode result = createMappingQueryCS(
						false,
						mappingDecl,
						blockExpCS.getBodyExpressions()
					);
				setOffsets(result, mappingDecl, blockExpCS);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 577:  constructor_header ::= qualifierList constructor scoped_identifier simple_signature
            //
            case 577: {
               //#line 1105 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				SimpleSignatureCS signature = (SimpleSignatureCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4);					
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					null,
					(ScopedNameCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
					signature.getParams(),
					null
				);
				setOffsets(mappingDeclarationCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)), signature);

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				if (!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(mappingDeclarationCS);
	                  break;
            }
	
            //
            // Rule 578:  constructor_decl ::= constructor_header ;
            //
            case 578: {
               //#line 1125 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				ConstructorCS result = createConstructorCS(
						mappingDecl,
						ourEmptyEList
					);
				result.setBlackBox(true);
				setOffsets(result, mappingDecl, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 579:  constructor_decl ::= constructor_header qvtErrorToken
            //
            case 579: {
               //#line 1138 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				ConstructorCS result = createConstructorCS(
						mappingDecl,
						ourEmptyEList
					);
				result.setBlackBox(true);
				setOffsets(result, mappingDecl);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 580:  constructor_def ::= constructor_header expression_block semicolonOpt
            //
            case 580: {
               //#line 1151 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				BlockExpCS blockExpCS = (BlockExpCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				ConstructorCS result = createConstructorCS(
						mappingDecl,
						blockExpCS.getBodyExpressions()
					);
				setOffsets(result, mappingDecl, blockExpCS);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 583:  entry_header ::= main simple_signature
            //
            case 583: {
               //#line 1170 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				IToken nameToken = getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1));				
				ScopedNameCS nameCS = createScopedNameCS(null, getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));								
				nameCS.setStartOffset(nameToken.getStartOffset());
				nameCS.setEndOffset(nameToken.getEndOffset());
	
				SimpleSignatureCS signature = (SimpleSignatureCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				CSTNode result = createMappingDeclarationCS(
						null,
						nameCS,
						signature.getParams(),
						null
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), signature);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 584:  entry_header ::= main qvtErrorToken
            //
            case 584: {
               //#line 1189 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMappingDeclarationCS(
						null,
						createScopedNameCS(null, getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))),
						ourEmptyEList,
						null
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 585:  entry_decl ::= entry_header ;
            //
            case 585: {
               //#line 1202 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				MappingQueryCS result = createMappingQueryCS(
						true,
						mappingDecl,
						ourEmptyEList
					);
				result.setBlackBox(true);
				setOffsets(result, mappingDecl, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 586:  entry_def ::= entry_header expression_block semicolonOpt
            //
            case 586: {
               //#line 1216 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				BlockExpCS blockExpCS = (BlockExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				CSTNode result = createMappingQueryCS(
						true,
						mappingDecl,
						blockExpCS.getBodyExpressions()
					);
				setOffsets(result, mappingDecl, blockExpCS);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 587:  _tag ::= tag StringLiteralExpCS scoped_identifier tag_valueOpt
            //
            case 587: {
               //#line 1234 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS valueExpression = (OCLExpressionCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4);
				CSTNode result = createTagCS(
						(StringLiteralExpCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						(ScopedNameCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						valueExpression
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), valueExpression != null ? valueExpression : (CSTNode)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 588:  tag_valueOpt ::= $Empty
            //
            case 588:
                setResult(null);
                break;

            //
            // Rule 589:  tag_valueOpt ::= = OclExpressionCS
            //
            case 589: {
               //#line 1249 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1( /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));
	                  break;
            }
	
            //
            // Rule 592:  mapping_decl ::= mapping_full_header ;
            //
            case 592: {
               //#line 1262 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
	                        Object[] mappingFullHeader = (Object[]) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				MappingRuleCS result = createMappingRuleCS(
						(MappingDeclarationCS)mappingFullHeader[0],
						(OCLExpressionCS)mappingFullHeader[1],
						null
					);
				result.setBlackBox(true);
				setOffsets(result, (MappingDeclarationCS)mappingFullHeader[0], getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 593:  mapping_def ::= mapping_full_header { mapping_body } semicolonOpt
            //
            case 593: {
               //#line 1276 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingSectionsCS mappingSections = (MappingSectionsCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				setOffsets(mappingSections, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));

				MappingBodyCS mappingBodyCS = mappingSections.getMappingBodyCS();
				if (mappingBodyCS != null) {
					if (mappingBodyCS.getStartOffset() < 0) {
						mappingBodyCS.setStartOffset(mappingSections.getStartOffset());
					}
					if (mappingBodyCS.getEndOffset() < 0) {
						mappingBodyCS.setEndOffset(mappingSections.getEndOffset());
					}
				}

	                        Object[] mappingFullHeader = (Object[]) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				MappingRuleCS result = createMappingRuleCS(
						(MappingDeclarationCS)mappingFullHeader[0],
						(OCLExpressionCS)mappingFullHeader[1],
						mappingSections
					);
				result.setBlackBox(false);
				setOffsets(result, (MappingDeclarationCS)mappingFullHeader[0], getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 594:  mapping_def ::= mapping_full_header { qvtErrorToken
            //
            case 594: {
               //#line 1303 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
	                        Object[] mappingFullHeader = (Object[]) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				MappingRuleCS result = createMappingRuleCS(
						(MappingDeclarationCS)mappingFullHeader[0],
						null,
						null
					);
				setOffsets(result, (MappingDeclarationCS)mappingFullHeader[0], getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 595:  mapping_full_header ::= mapping_header _whenOpt
            //
            case 595: {
               //#line 1316 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new Object[] { /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1),  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2)});
	                  break;
            }
	
            //
            // Rule 596:  mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier complete_signature mapping_extraList
            //
            case 596: {
               //#line 1322 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				DirectionKindCS directionKind = (DirectionKindCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				CompleteSignatureCS completeSignature = (CompleteSignatureCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(5);
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					directionKind,
					(ScopedNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
					completeSignature.getSimpleSignature().getParams(),
					completeSignature.getResultParams()
				);
				
				mappingDeclarationCS.setStartOffset(directionKind == null ? getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)).getStartOffset() : directionKind.getStartOffset());
				mappingDeclarationCS.setEndOffset(completeSignature.getEndOffset());

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				mappingDeclarationCS.getMappingExtension().addAll(((EList<MappingExtensionCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6)));

				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(mappingDeclarationCS);
	                  break;
            }
	
            //
            // Rule 597:  mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier qvtErrorToken
            //
            case 597: {
               //#line 1347 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				DirectionKindCS directionKind = (DirectionKindCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					directionKind,
					(ScopedNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
					ourEmptyEList,
					ourEmptyEList
				);

				mappingDeclarationCS.setStartOffset(directionKind == null ? getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)).getStartOffset() : directionKind.getStartOffset());
				mappingDeclarationCS.setEndOffset(((CSTNode) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4)).getEndOffset());

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(mappingDeclarationCS);
	                  break;
            }
	
            //
            // Rule 598:  mapping_header ::= qualifierList mapping qvtErrorToken
            //
            case 598: {
               //#line 1369 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					null,
					createScopedNameCS(null, ""), //$NON-NLS-1$
					ourEmptyEList,
					ourEmptyEList
				);
				
				setOffsets(mappingDeclarationCS, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(mappingDeclarationCS);
	                  break;
            }
	
            //
            // Rule 599:  mapping_extraList ::= mapping_extraList mapping_extra
            //
            case 599: {
               //#line 1390 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<MappingExtensionCS> extensionList = (EList<MappingExtensionCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				extensionList.add((MappingExtensionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(extensionList);
	                  break;
            }
	 
            //
            // Rule 600:  mapping_extraList ::= $Empty
            //
            
            case 600:
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(new BasicEList<Object>());
                break;

            //
            // Rule 602:  mapping_extension ::= mapping_extension_key scoped_identifier_list
            //
            case 602: {
               //#line 1403 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingExtensionCS result = createMappingExtension(getTokenText( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (EList<ScopedNameCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));

				result.setStartOffset(getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)).getStartOffset());
				result.setEndOffset(getEndOffset(getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), (EList<ScopedNameCS>) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2)));
			
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 607:  _whenOpt ::= $Empty
            //
            case 607:
                setResult(null);
                break;

            //
            // Rule 608:  _when ::= when { OclExpressionCS semicolonOpt }
            //
            case 608: {
               //#line 1422 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS result = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 609:  _when ::= when qvtErrorToken
            //
            case 609:
                setResult(null);
                break;

            //
            // Rule 610:  mapping_body ::= init_sectionOpt population_sectionOpt end_sectionOpt
            //
            case 610: {
               //#line 1431 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
	                        MappingInitCS mappingInitCS = (MappingInitCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				MappingBodyCS mappingBodyCS = (MappingBodyCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				MappingEndCS mappingEndCS = (MappingEndCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);

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
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 611:  init_sectionOpt ::= $Empty
            //
            case 611:
                setResult(null);
                break;

            //
            // Rule 613:  init_section ::= init expression_block
            //
            case 613: {
               //#line 1462 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS blockExpCS = (BlockExpCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				CSTNode result = createMappingInitCS(
						blockExpCS.getBodyExpressions(),
						blockExpCS.getStartOffset(),
						blockExpCS.getEndOffset()
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), blockExpCS);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 614:  init_section ::= init qvtErrorToken
            //
            case 614: {
               //#line 1475 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMappingInitCS(
						ourEmptyEList,
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)).getEndOffset(),
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)).getStartOffset()
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 615:  population_sectionOpt ::= $Empty
            //
            case 615: {
               //#line 1488 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingBodyCS result = createMappingBodyCS(
						ourEmptyEList,
						false
					);
				// offsets will be updated further in parent non-terminals
				result.setStartOffset(-1); 
				result.setEndOffset(-1);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 617:  population_section ::= expression_list
            //
            case 617: {
               //#line 1502 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<OCLExpressionCS> expressionList = (EList<OCLExpressionCS>)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
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
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 618:  population_section ::= population expression_block
            //
            case 618: {
               //#line 1522 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS blockExpCS = (BlockExpCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				MappingBodyCS result = createMappingBodyCS(
						blockExpCS.getBodyExpressions(),
						true
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), blockExpCS);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 619:  population_section ::= population qvtErrorToken
            //
            case 619: {
               //#line 1534 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMappingBodyCS(
						ourEmptyEList,
						true
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 620:  end_sectionOpt ::= $Empty
            //
            case 620:
                setResult(null);
                break;

            //
            // Rule 622:  end_section ::= end expression_block
            //
            case 622: {
               //#line 1549 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS blockExpCS = (BlockExpCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2);
				CSTNode result = createMappingEndCS(
						blockExpCS.getBodyExpressions(),
						blockExpCS.getStartOffset(),
						blockExpCS.getEndOffset()
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), blockExpCS);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 623:  end_section ::= end qvtErrorToken
            //
            case 623: {
               //#line 1562 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMappingEndCS(
						ourEmptyEList,
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)).getEndOffset(),
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)).getStartOffset()
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 624:  typespecOpt ::= $Empty
            //
            case 624:
                setResult(null);
                break;

            //
            // Rule 626:  objectDeclCS ::= typespec
            //
            case 626: {
               //#line 1580 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createOutExpCS(null, (TypeSpecCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 630:  objectDeclCS ::= objectIdentifierCS : typespecOpt
            //
            case 630: {
               //#line 1591 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			SimpleNameCS varName = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
			setOffsets(varName, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
			CSTNode result = createOutExpCS(varName,(TypeSpecCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));					
			 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 631:  outExpCS ::= object objectDeclCS expression_block
            //
            case 631: {
               //#line 1600 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS blockExpCS = (BlockExpCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				CSTNode result = setupOutExpCS(
						(ObjectExpCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),					
						blockExpCS.getBodyExpressions(),
						// passing body positions
						blockExpCS.getStartOffset(),
						blockExpCS.getEndOffset()
					); 
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), blockExpCS);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 632:  outExpCS ::= object objectDeclCS qvtErrorToken
            //
            case 632: {
               //#line 1614 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				ObjectExpCS objectDeclCS = ((ObjectExpCS)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));  
				CSTNode result = createOutExpCS(
						objectDeclCS.getSimpleNameCS(),						
						objectDeclCS.getTypeSpecCS()
					);
				if (objectDeclCS  == null) {
				    setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				} else {
				    setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), objectDeclCS);
				}
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 633:  featureMappingCallExpCS ::= map simpleNameCS ( argumentsCSopt )
            //
            case 633: {
               //#line 1630 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createFeatureMappingCallExpCS(
						null,
						(SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						(EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
						false
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(5)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 634:  featureMappingCallExpCS ::= xmap simpleNameCS ( argumentsCSopt )
            //
            case 634: {
               //#line 1642 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createFeatureMappingCallExpCS(
						null,
						(SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						(EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
						true
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(5)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 635:  featureMappingCallExpCS ::= map simpleNameCS :: simpleNameCS ( argumentsCSopt )
            //
            case 635: {
               //#line 1655 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createFeatureMappingCallExpCS(
						(SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						(SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
						(EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6),
						false
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(7)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 636:  featureMappingCallExpCS ::= xmap simpleNameCS :: simpleNameCS ( argumentsCSopt )
            //
            case 636: {
               //#line 1667 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createFeatureMappingCallExpCS(
						(SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						(SimpleNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
						(EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6),
						true
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(7)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 637:  mappingCallExpCS ::= map pathNameCS ( argumentsCSopt )
            //
            case 637: {
               //#line 1680 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMappingCallExpCS(
						(PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						(EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
						false
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(5)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 638:  mappingCallExpCS ::= xmap pathNameCS ( argumentsCSopt )
            //
            case 638: {
               //#line 1691 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMappingCallExpCS(
						(PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						(EList) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
						true
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(5)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 639:  resolveConditionOpt ::= $Empty
            //
            case 639:
                setResult(null);
                break;

            //
            // Rule 640:  resolveConditionOpt ::= | OclExpressionCS
            //
            case 640: {
               //#line 1708 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1((OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2));
                      break;
            }
    
            //
            // Rule 641:  resolveConditionOpt ::= | qvtErrorToken
            //
            case 641:
                setResult(null);
                break;

            //
            // Rule 642:  IDENTIFIEROpt ::= $Empty
            //
            case 642:
                setResult(null);
                break;

            //
            // Rule 643:  IDENTIFIEROpt ::= IDENTIFIER :
            //
            case 643: {
               //#line 1720 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                      break;
            }
    
            //
            // Rule 644:  resolveOpArgsExpCSOpt ::= $Empty
            //
            case 644:
                setResult(null);
                break;

            //
            // Rule 646:  resolveOpArgsExpCS ::= IDENTIFIEROpt typeCS resolveConditionOpt
            //
            case 646: {
               //#line 1731 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveOpArgsExpCS(
                        getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),      // target_type_variable?
                        (TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),           // type?
                        (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3)); // condition?
                        setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
                     /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 651:  lateOpt ::= $Empty
            //
            case 651:
                setResult(null);
                break;

            //
            // Rule 653:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCSOpt )
            //
            case 653: {
               //#line 1751 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveExpCS(
                            getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
                        getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)),
                            (ResolveOpArgsExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4));
                            setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(5)));
                     /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                          break;
            }
        
            //
            // Rule 654:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCSOpt qvtErrorToken
            //
            case 654: {
               //#line 1762 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveExpCS(
                            getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
                        getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)),
                        (ResolveOpArgsExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4));
                        setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 655:  resolveExpCS ::= lateOpt resolveOp qvtErrorToken
            //
            case 655: {
               //#line 1773 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveExpCS(
                        getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
                        getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)),
                        null);
                            setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 656:  resolveExpCS ::= late qvtErrorToken
            //
            case 656: {
               //#line 1784 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
    			IToken lateToken = getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1));
                CSTNode result = createResolveExpCS(
                        lateToken,
                        new Token(lateToken.getEndOffset(), lateToken.getEndOffset(), QVTOParsersym.TK_resolve),
                        null);
                            setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 661:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier , resolveOpArgsExpCS )
            //
            case 661: {
               //#line 1801 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveInExpCS(
                        getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
                        getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)),
                        (ScopedNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
                        (ResolveOpArgsExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6));
                        setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(7)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                          break;
            }
        
            //
            // Rule 662:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier )
            //
            case 662: {
               //#line 1813 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveInExpCS(
                        getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
                        getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)),
                        (ScopedNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
                        null);
                        setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(5)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 663:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier , resolveOpArgsExpCSOpt qvtErrorToken
            //
            case 663: {
               //#line 1826 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveInExpCS(
                        getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
                        getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)),
                        (ScopedNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
                        (ResolveOpArgsExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6));
                        setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(6)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 664:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier qvtErrorToken
            //
            case 664: {
               //#line 1838 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveInExpCS(
                        getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
                        getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)),
                        (ScopedNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(4),
                        null);
                        setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 665:  resolveInExpCS ::= lateOpt resolveInOp ( qvtErrorToken
            //
            case 665: {
               //#line 1850 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                    CSTNode result = createResolveInExpCS(
                            getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
                        getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)),
							createScopedNameCS(null, ""),  //$NON-NLS-1$
                        null);
                            setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(3)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
        
            //
            // Rule 666:  resolveInExpCS ::= lateOpt resolveInOp qvtErrorToken
            //
            case 666: {
               //#line 1862 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveInExpCS(
                        getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)),
                        getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)),
							createScopedNameCS(null, ""),  //$NON-NLS-1$
                        null);
                        setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)));
                 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
                      break;
            }
    
            //
            // Rule 669:  OperationCallExpCS ::= primaryExpCS -> resolveResolveInExpCS
            //
            case 669: {
               //#line 1878 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				CallExpCS result = (CallExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				result.setSource(source);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 670:  OperationCallExpCS ::= primaryExpCS . resolveResolveInExpCS
            //
            case 670: {
               //#line 1887 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				CallExpCS result = (CallExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				result.setSource(source);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 672:  OperationCallExpCS ::= primaryExpCS -> featureMappingCallExpCS
            //
            case 672: {
               //#line 1904 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				CallExpCS result = (CallExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				result.setSource(source);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 673:  OperationCallExpCS ::= primaryExpCS . featureMappingCallExpCS
            //
            case 673: {
               //#line 1913 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				CallExpCS result = (CallExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				result.setSource(source);
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	 
            //
            // Rule 676:  simpleNameCS ::= this
            //
            
            case 676:

            //
            // Rule 677:  simpleNameCS ::= result
            //
            case 677: {
               //#line 1929 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1))
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 678:  _import ::= import library unit ;
            //
            case 678: {
               //#line 1944 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createLibraryImportCS(
						(PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 679:  transformation_h ::= qualifierList transformation qualifiedNameCS
            //
            case 679: {
               //#line 1954 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList qualifierList = (EList)  /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(1);
				CSTNode result = createTransformationHeaderCS(
						qualifierList,
						(PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3),
						createSimpleSignatureCS(ourEmptyEList),
						ourEmptyEList,
						null
					);
				if (qualifierList.isEmpty()) {
					setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(2)), (PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				} else {
					setOffsets(result, (CSTNode) qualifierList.get(0), (PathNameCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(3));
				}
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
            //
            // Rule 681:  renaming ::= rename typeCS . qvtIdentifierCS = StringLiteralExpCS ;
            //
            case 681: {
               //#line 1974 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createRenameCS(
						(TypeCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(2),
						getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(4)),
						(StringLiteralExpCS) /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym(6)
					);
				setOffsets(result, getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(1)), getIToken( /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken(7)));
				 /* macro setResult is deprecated. Use function setResult */ getParser().setSym1(result);
	                  break;
            }
	
    
            default:
                break;
        }
        return;
    }
}

