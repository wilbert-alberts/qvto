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
*
* </copyright>
*
* $Id: QVTOParser.java,v 1.1 2009/11/13 22:09:03 sboyko Exp $
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
* $Id: QVTOParser.java,v 1.1 2009/11/13 22:09:03 sboyko Exp $
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
* $Id: QVTOParser.java,v 1.1 2009/11/13 22:09:03 sboyko Exp $
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
* $Id: QVTOParser.java,v 1.1 2009/11/13 22:09:03 sboyko Exp $
*/

package org.eclipse.m2m.internal.qvt.oml.cst.parser;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.VariableCS;

import lpg.lpgjavaruntime.BadParseException;
import lpg.lpgjavaruntime.BadParseSymFileException;
import lpg.lpgjavaruntime.DeterministicParser;
import lpg.lpgjavaruntime.DiagnoseParser;
import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.Monitor;
import lpg.lpgjavaruntime.NotDeterministicParseTableException;
import lpg.lpgjavaruntime.ParseTable;
import lpg.lpgjavaruntime.RuleAction;


import org.eclipse.ocl.ParserException;		
import lpg.lpgjavaruntime.Token;
import lpg.lpgjavaruntime.BacktrackingParser;
import lpg.lpgjavaruntime.PrsStream;
import lpg.lpgjavaruntime.NotBacktrackParseTableException;
import lpg.lpgjavaruntime.NullExportedSymbolsException;
import lpg.lpgjavaruntime.NullTerminalSymbolsException;
import lpg.lpgjavaruntime.UndefinedEofSymbolException;
import lpg.lpgjavaruntime.UnimplementedTerminalsException;
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

	public class QVTOParser extends AbstractQVTParser implements RuleAction {
	protected static ParseTable prs = new QVTOParserprs();
	private BacktrackingParser dtParser;
	// (to be uncommented for use in DEBUG mode)
	//private static Map<Integer, String> ruleTexts;

	public QVTOParser(QVTOLexer lexer) {
		super(lexer);

		try {
			super.remapTerminalSymbols(orderedTerminalSymbols(), QVTOParserprs.EOFT_SYMBOL);
		}
		catch(NullExportedSymbolsException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		}
		catch(NullTerminalSymbolsException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		}
		catch(UnimplementedTerminalsException e) {
			java.util.ArrayList<?> unimplemented_symbols = e.getSymbols();
			String error = "The Lexer will not scan the following token(s):"; //$NON-NLS-1$
			for (int i = 0; i < unimplemented_symbols.size(); i++) {
				Integer id = (Integer) unimplemented_symbols.get(i);
				error += "\t" + QVTOParsersym.orderedTerminalSymbols[id.intValue()]; //$NON-NLS-1$			   
			}
			throw new RuntimeException(error + "\n"); //$NON-NLS-1$
		}
		catch(UndefinedEofSymbolException e) {
			throw new RuntimeException("The Lexer does not implement the Eof symbol " + //$NON-NLS-1$
				 QVTOParsersym.orderedTerminalSymbols[QVTOParserprs.EOFT_SYMBOL]);
		} 
	}
	 
	@Override
	public String[] orderedTerminalSymbols() { return QVTOParsersym.orderedTerminalSymbols; }
	@Override		
	public String getTokenKindName(int kind) { return QVTOParsersym.orderedTerminalSymbols[kind]; }			
	public int getEOFTokenKind() { return QVTOParserprs.EOFT_SYMBOL; }
	public PrsStream getParseStream() { return this; }

	protected CSTNode parser() throws ParserException {
		return parseTokensToCST(null, 0);
	}
		
	protected CSTNode parser(Monitor monitor) throws ParserException {
		return parseTokensToCST(monitor, 0);
	}
		
	protected CSTNode parser(int error_repair_count) throws ParserException {
		return parseTokensToCST(null, error_repair_count);
	}
		
	@Override
	public CSTNode parseTokensToCST(Monitor monitor, int error_repair_count) {
		ParseTable prsTable = new QVTOParserprs();

		try {
			dtParser = new BacktrackingParser(monitor, this, prsTable, this);
		}
		catch (NotBacktrackParseTableException e) {
			throw new RuntimeException("****Error: Regenerate QVTOParserprs.java with -NOBACKTRACK option"); //$NON-NLS-1$
		}
		catch (BadParseSymFileException e) {
			throw new RuntimeException("****Error: Bad Parser Symbol File -- QVTOParsersym.java. Regenerate QVTOParserprs.java"); //$NON-NLS-1$
		}

		try {
		    workaroundEOFErrors();
			return (CSTNode) dtParser.parse(error_repair_count);
		}
		catch (BadParseException e) {
			OnParseError(e);

			reset(e.error_token); // point to error token
			DiagnoseParser diagnoseParser = new DiagnoseParser(this, prsTable);
			diagnoseParser.diagnose(e.error_token);
		}

		return null;
	}

    private void workaroundEOFErrors() {
	    IToken lastT = (IToken) getTokens().get((getTokens().size() - 1));
    	int trailingEOFsAmount = 100;
    	int someHugeOffset = 100000;
    	for (int i  = 0; i < trailingEOFsAmount; i++) {
            makeToken(lastT.getEndOffset() + i + someHugeOffset, lastT.getEndOffset() + i + someHugeOffset + 1, QVTOParsersym.TK_EOF_TOKEN);
    	}
	}

	protected void OnParseError(BadParseException e) {
		System.err.println(getFileName());
		java.util.ArrayList<?> tokens = getTokens();
		String result = getName(e.error_token) + " ~~ "; //$NON-NLS-1$
		for (int i = Math.max(0, e.error_token-5), n = Math.min(tokens.size(), e.error_token+5); i < n; ++i) {
			result += tokens.get(i).toString();
			result += " "; //$NON-NLS-1$
		}
		System.err.println(result);
	}



	/**
	 * 
	 * QVT Operational specific part
	 *
	 */
	
	
	@SuppressWarnings("unchecked")
	private static final EList ourEmptyEList = new BasicEList.UnmodifiableEList(0, new Object[0]);								
							
	
	private void diagnozeErrorToken(int token_index) {
		IToken token = getIToken(token_index);
		if (token instanceof lpg.lpgjavaruntime.ErrorToken) {
			token = ((lpg.lpgjavaruntime.ErrorToken) token).getErrorToken();
		}
		
		reportError(lpg.lpgjavaruntime.ParseErrorCodes.MISPLACED_CODE, "", token.getTokenIndex(), token.getTokenIndex(), //$NON-NLS-1$ 
				"'" + token.toString() + "'"); //$NON-NLS-1$ //$NON-NLS-2$
		reset(token.getTokenIndex()); // point to error token
		DiagnoseParser diagnoseParser = new DiagnoseParser(this, prs);
		diagnoseParser.diagnose(token.getTokenIndex());
		dtParser.setSym1(null);
	}

    @SuppressWarnings("unchecked")
    public void ruleAction(int ruleNumber)
    {
        switch (ruleNumber) {
        
 
            //
            // Rule 16:  conceptualOperationNameCS ::= conceptualOperationName
            //
            case 16: {
                
                IToken iToken = getIToken(dtParser.getToken(1));
                SimpleNameCS result = createConceptualOperationNameCS(iToken);
                setOffsets(result, iToken);
                dtParser.setSym1(result);
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
                
                IToken iToken = getIToken(dtParser.getToken(1));
                SimpleNameCS result = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            iToken
                        );
                setOffsets(result, iToken);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 33:  selfKeywordCS ::= self
            //
            case 33: {
                
                IToken iToken = getIToken(dtParser.getToken(1));
                CSTNode result = createSimpleNameCS(
                        SimpleTypeEnum.SELF_LITERAL,
                        iToken
                    );
                setOffsets(result, iToken);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 34:  simpleNameCS ::= IDENTIFIER
            //
            case 34: {
                
                IToken iToken = getIToken(dtParser.getToken(1));
                CSTNode result = createSimpleNameCS(
                        SimpleTypeEnum.IDENTIFIER_LITERAL,
                        iToken
                    );
                setOffsets(result, iToken);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 37:  pathNameCS ::= simpleNameCS
            //
            case 37: {
                
                SimpleNameCS simpleName = (SimpleNameCS)dtParser.getSym(1);
                PathNameCS result = createPathNameCS(simpleName);
                setOffsets(result, simpleName);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 38:  pathNameCS ::= pathNameCS :: unreservedSimpleNameCS
            //
            case 38: {
                
                PathNameCS result = (PathNameCS)dtParser.getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
                result = extendPathNameCS(result, simpleNameCS);
                setOffsets(result, result, simpleNameCS);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 39:  primitiveTypeCS ::= Boolean
            //
            case 39: {
                
                CSTNode result = createPrimitiveTypeCS(
                        SimpleTypeEnum.BOOLEAN_LITERAL,
                        getTokenText(dtParser.getToken(1))
                    );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 40:  primitiveTypeCS ::= Integer
            //
            case 40: {
                
                CSTNode result = createPrimitiveTypeCS(
                        SimpleTypeEnum.INTEGER_LITERAL,
                        getTokenText(dtParser.getToken(1))
                    );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 41:  primitiveTypeCS ::= Real
            //
            case 41: {
                
                CSTNode result = createPrimitiveTypeCS(
                        SimpleTypeEnum.REAL_LITERAL,
                        getTokenText(dtParser.getToken(1))
                    );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 42:  primitiveTypeCS ::= String
            //
            case 42: {
                
                CSTNode result = createPrimitiveTypeCS(
                        SimpleTypeEnum.STRING_LITERAL,
                        getTokenText(dtParser.getToken(1))
                    );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 43:  primitiveTypeCS ::= UnlimitedNatural
            //
            case 43: {
                
                CSTNode result = createPrimitiveTypeCS(
                        SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
                        getTokenText(dtParser.getToken(1))
                    );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 44:  primitiveTypeCS ::= OclAny
            //
            case 44: {
                
                CSTNode result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_ANY_LITERAL,
                        getTokenText(dtParser.getToken(1))
                    );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 45:  primitiveTypeCS ::= OclInvalid
            //
            case 45: {
                
                CSTNode result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_INVALID_LITERAL,
                        getTokenText(dtParser.getToken(1))
                    );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 46:  primitiveTypeCS ::= OclVoid
            //
            case 46: {
                
                CSTNode result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_VOID_LITERAL,
                        getTokenText(dtParser.getToken(1))
                    );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 47:  CollectionTypeIdentifierCS ::= Set
            //
            case 47: {
                
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.SET_LITERAL,
                            getTokenText(dtParser.getToken(1))
                        );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 48:  CollectionTypeIdentifierCS ::= Bag
            //
            case 48: {
                
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.BAG_LITERAL,
                            getTokenText(dtParser.getToken(1))
                        );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 49:  CollectionTypeIdentifierCS ::= Sequence
            //
            case 49: {
                
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.SEQUENCE_LITERAL,
                            getTokenText(dtParser.getToken(1))
                        );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 50:  CollectionTypeIdentifierCS ::= Collection
            //
            case 50: {
                
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.COLLECTION_LITERAL,
                            getTokenText(dtParser.getToken(1))
                        );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 51:  CollectionTypeIdentifierCS ::= OrderedSet
            //
            case 51: {
                
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL,
                            getTokenText(dtParser.getToken(1))
                        );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 56:  collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS )
            //
            case 56: {
                
                CollectionTypeCS result = (CollectionTypeCS)dtParser.getSym(1);
                result.setTypeCS((TypeCS)dtParser.getSym(3));
                setOffsets(result, result, getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 57:  tupleTypeCS ::= Tuple ( tupleTypePartsCSopt )
            //
            case 57: {
                
                CSTNode result = createTupleTypeCS((EList)dtParser.getSym(3));
                setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 58:  tupleTypePartsCSopt ::= $Empty
            //
            case 58:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 60:  tupleTypePartsCS ::= typedUninitializedVariableCS
            //
            case 60: {
                
                EList result = new BasicEList();
                result.add(dtParser.getSym(1));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 61:  tupleTypePartsCS ::= tupleTypePartsCS , typedUninitializedVariableCS
            //
            case 61: {
                
                EList result = (EList)dtParser.getSym(1);
                result.add(dtParser.getSym(3));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 62:  untypedUninitializedVariableCS ::= simpleNameCS
            //
            case 62: {
                
                SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
                CSTNode result = createVariableCS(name, null, null);
                setOffsets(result, name);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 63:  typedUninitializedVariableCS ::= simpleNameCS : typeCS
            //
            case 63: {
                
                SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
                TypeCS type = (TypeCS)dtParser.getSym(3);
                CSTNode result = createVariableCS(name, type, null);
                setOffsets(result, name, type);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 64:  untypedInitializedVariableCS ::= simpleNameCS = OclExpressionCS
            //
            case 64: {
                
                SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
                OCLExpressionCS initExpression = (OCLExpressionCS)dtParser.getSym(3);
                CSTNode result = createVariableCS(name, null, initExpression);
                setOffsets(result, name, initExpression);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 65:  typedInitializedVariableCS ::= simpleNameCS : typeCS = OclExpressionCS
            //
            case 65: {
                
                SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
                TypeCS type = (TypeCS)dtParser.getSym(3);
                OCLExpressionCS initExpression = (OCLExpressionCS)dtParser.getSym(5);
                CSTNode result = createVariableCS(name, type, initExpression);
                setOffsets(result, name, initExpression);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 78:  CollectionLiteralExpCS ::= CollectionTypeIdentifierCS { CollectionLiteralPartsCSopt }
            //
            case 78: {
                
                CollectionTypeCS typeCS = (CollectionTypeCS)dtParser.getSym(1);
                CSTNode result = createCollectionLiteralExpCS(
                        typeCS,
                        (EList)dtParser.getSym(3)
                    );
                setOffsets(result, typeCS, getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 79:  CollectionLiteralPartsCSopt ::= $Empty
            //
            case 79:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 81:  CollectionLiteralPartsCS ::= CollectionLiteralPartCS
            //
            case 81: {
                
                EList result = new BasicEList();
                result.add(dtParser.getSym(1));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 82:  CollectionLiteralPartsCS ::= CollectionLiteralPartsCS , CollectionLiteralPartCS
            //
            case 82: {
                
                EList result = (EList)dtParser.getSym(1);
                result.add(dtParser.getSym(3));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 84:  CollectionLiteralPartCS ::= OclExpressionCS
            //
            case 84: {
                
                CSTNode result = createCollectionLiteralPartCS(
                        (OCLExpressionCS)dtParser.getSym(1)
                    );
                setOffsets(result, (CSTNode)dtParser.getSym(1));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 85:  CollectionRangeCS ::= OclExpressionCS .. OclExpressionCS
            //
            case 85: {
                
                CSTNode result = createCollectionRangeCS(
                        (OCLExpressionCS)dtParser.getSym(1),
                        (OCLExpressionCS)dtParser.getSym(3)
                    );
                setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 93:  TupleLiteralExpCS ::= Tuple { TupleLiteralPartsCS }
            //
            case 93: {
                
                CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
                setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 94:  TupleLiteralPartsCS ::= initializedVariableCS
            //
            case 94: {
                
                EList result = new BasicEList();
                result.add(dtParser.getSym(1));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 95:  TupleLiteralPartsCS ::= TupleLiteralPartsCS , initializedVariableCS
            //
            case 95: {
                
                EList result = (EList)dtParser.getSym(1);
                result.add(dtParser.getSym(3));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 96:  IntegerLiteralExpCS ::= INTEGER_LITERAL
            //
            case 96: {
                
                CSTNode result = createIntegerLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 97:  RealLiteralExpCS ::= REAL_LITERAL
            //
            case 97: {
                
                CSTNode result = createRealLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 98:  StringLiteralExpCS ::= STRING_LITERAL
            //
            case 98: {
                
                IToken literalToken = getIToken(dtParser.getToken(1));
                StringLiteralExpCS result = createStringLiteralExpCS(literalToken);
                setOffsets(result, literalToken);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 99:  StringLiteralExpCS ::= StringLiteralExpCS STRING_LITERAL
            //
            case 99: {
                
                StringLiteralExpCS string = (StringLiteralExpCS)dtParser.getSym(1);
                IToken literalToken = getIToken(dtParser.getToken(2));
                StringLiteralExpCS result = extendStringLiteralExpCS(string, literalToken);
                setOffsets(result, string, literalToken);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 100:  BooleanLiteralExpCS ::= true
            //
            case 100: {
                
                CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 101:  BooleanLiteralExpCS ::= false
            //
            case 101: {
                
                CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 102:  UnlimitedNaturalLiteralExpCS ::= *
            //
            case 102: {
                
                CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 103:  InvalidLiteralExpCS ::= invalid
            //
            case 103: {
                
                CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 104:  NullLiteralExpCS ::= null
            //
            case 104: {
                
                CSTNode result = createNullLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
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
                
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
                CSTNode result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 112:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( uninitializedVariableCS | OclExpressionCS )
            //
            case 112: {
                
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
                CSTNode result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)dtParser.getSym(5),
                        null,
                        (OCLExpressionCS)dtParser.getSym(7)
                    );
                setOffsets(result, source, getIToken(dtParser.getToken(8)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 113:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( simpleNameCS , uninitializedVariableCS | OclExpressionCS )
            //
            case 113: {
                
                SimpleNameCS name = (SimpleNameCS)dtParser.getSym(5);
                VariableCS variableCS = createVariableCS(name, null, null);
                setOffsets(variableCS, name);
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
                CSTNode result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        variableCS,
                        (VariableCS)dtParser.getSym(7),
                        (OCLExpressionCS)dtParser.getSym(9)
                    );
                setOffsets(result, source, getIToken(dtParser.getToken(10)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 114:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( typedUninitializedVariableCS , uninitializedVariableCS | OclExpressionCS )
            //
            case 114: {
                
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
                CSTNode result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)dtParser.getSym(5),
                        (VariableCS)dtParser.getSym(7),
                        (OCLExpressionCS)dtParser.getSym(9)
                    );
                setOffsets(result, source, getIToken(dtParser.getToken(10)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 115:  IterateExpCS ::= primaryExpCS -> simpleNameCS ( typedInitializedVariableCS | OclExpressionCS )
            //
            case 115: {
                
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
                CSTNode result = createIterateExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)dtParser.getSym(5),
                        null,
                        (OCLExpressionCS)dtParser.getSym(7)
                    );
                setOffsets(result, source, getIToken(dtParser.getToken(8)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 116:  IterateExpCS ::= primaryExpCS -> simpleNameCS ( uninitializedVariableCS ; typedInitializedVariableCS | OclExpressionCS )
            //
            case 116: {
                
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
                CSTNode result = createIterateExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)dtParser.getSym(5),
                        (VariableCS)dtParser.getSym(7),
                        (OCLExpressionCS)dtParser.getSym(9)
                    );
                setOffsets(result, source, getIToken(dtParser.getToken(10)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 120:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( )
            //
            case 120: {
                
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                CSTNode result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)dtParser.getSym(3),
                        null,
                        new BasicEList()
                    );
                setOffsets(result, source, getIToken(dtParser.getToken(5)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 121:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( OclExpressionCS )
            //
            case 121: {
                
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
                OCLExpressionCS arg = (OCLExpressionCS)dtParser.getSym(5);
                CSTNode result;
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
                    EList args = new BasicEList();
                    args.add(arg);
                    result = createArrowOperationCallExpCS(
                            source,
                            simpleNameCS,
                            null,
                            args
                        );
                }
                setOffsets(result, source, getIToken(dtParser.getToken(6)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 122:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( notNameExpressionCS , argumentsCS )
            //
            case 122: {
                
                EList args = (EList)dtParser.getSym(7);
                args.add(0, dtParser.getSym(5));
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                CSTNode result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)dtParser.getSym(3),
                        null,
                        args
                    );
                setOffsets(result, source, getIToken(dtParser.getToken(8)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 123:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( simpleNameCS , argumentsCS )
            //
            case 123: {
                
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(5);
                OCLExpressionCS variableExpCS = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList(),
                        null
                    );
                setOffsets(variableExpCS, simpleNameCS);
                EList args = (EList)dtParser.getSym(7);
                args.add(0, variableExpCS);
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                CSTNode result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)dtParser.getSym(3),
                        null,
                        args
                    );
                setOffsets(result, source, getIToken(dtParser.getToken(8)));
                dtParser.setSym1(result);
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
                
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                CallExpCS result = createDotOperationCallExpCS(
                        source,
                        null,
                        simpleNameCS,
                        (IsMarkedPreCS)dtParser.getSym(4),
                        (EList)dtParser.getSym(6)
                    );
                setOffsets(result, source, getIToken(dtParser.getToken(7)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 126:  OperationCallExpCS ::= simpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 126: {
                
                CSTNode result = createDotOperationCallExpCS(
                        null,
                        null,
                        (SimpleNameCS)dtParser.getSym(1),
                        (IsMarkedPreCS)dtParser.getSym(2),
                        (EList)dtParser.getSym(4)
                    );
                setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 127:  OperationCallExpCS ::= pathNameCS :: unreservedSimpleNameCS ( argumentsCSopt )
            //
            case 127: {
                
                PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
                OperationCallExpCS result = createDotOperationCallExpCS(
                        null,
                        pathNameCS,
                        simpleNameCS,
                        null,
                        (EList)dtParser.getSym(5)
                    );
                setOffsets(result, pathNameCS, getIToken(dtParser.getToken(6)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 128:  OperationCallExpCS ::= primaryExpCS . pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 128: {
                
                PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(3);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(5);
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                CallExpCS result = createDotOperationCallExpCS(
                        source,
                        pathNameCS,
                        simpleNameCS,
                        (IsMarkedPreCS)dtParser.getSym(6),
                        (EList)dtParser.getSym(8)
                    );
                setOffsets(result, source, getIToken(dtParser.getToken(9)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 130:  PropertyCallExpCS ::= pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt
            //
            case 130: {
                
                PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(4);
                CSTNode result = createFeatureCallExpCS(
                        null,
                        pathNameCS,
                        simpleNameCS,
                        new BasicEList(),
                        isMarkedPreCS
                    );
                if (isMarkedPreCS != null) {
                    setOffsets(result, pathNameCS, isMarkedPreCS);
                } else {
                    setOffsets(result, pathNameCS, simpleNameCS);
                }
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 131:  PropertyCallExpCS ::= primaryExpCS . pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt
            //
            case 131: {
                
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(3);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(5);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(6);
                CSTNode result = createFeatureCallExpCS(
                        source,
                        pathNameCS,
                        simpleNameCS,
                        new BasicEList(),
                        isMarkedPreCS
                    );
                if (isMarkedPreCS != null) {
                    setOffsets(result, source, isMarkedPreCS);
                } else {
                    setOffsets(result, source, simpleNameCS);
                }
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 132:  AssociationClassCallExpCS ::= primaryExpCS . simpleNameCS isMarkedPreCSopt
            //
            case 132: {
                
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(4);
                CSTNode result = createFeatureCallExpCS(
                        source,
                        null,
                        simpleNameCS,
                        new BasicEList(),
                        isMarkedPreCS
                    );
                if (isMarkedPreCS != null) {
                    setOffsets(result, source, isMarkedPreCS);
                } else {
                    setOffsets(result, source, simpleNameCS);
                }
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 133:  isMarkedPreCSopt ::= $Empty
            //
            case 133: {
                
                dtParser.setSym1(null);
              break;
            }
     
            //
            // Rule 134:  argumentsCSopt ::= $Empty
            //
            case 134:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 136:  argumentsCS ::= OclExpressionCS
            //
            case 136: {
                
                EList result = new BasicEList();
                result.add(dtParser.getSym(1));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 137:  argumentsCS ::= argumentsCS , OclExpressionCS
            //
            case 137: {
                
                EList result = (EList)dtParser.getSym(1);
                result.add(dtParser.getSym(3));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 140:  VariableExpCS ::= selfKeywordCS
            //
            case 140: {
                
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
                CSTNode result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 141:  SimpleNameExpCS ::= simpleNameCS
            //
            case 141: {
                
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
                CSTNode result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                dtParser.setSym1(result);
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
                
                SimpleNameCS simpleNameCS = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            getIToken(dtParser.getToken(2))
                        );
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
                OCLExpressionCS left = (OCLExpressionCS)dtParser.getSym(1);
                OCLExpressionCS right = (OCLExpressionCS)dtParser.getSym(3);
                EList args = new BasicEList();
                args.add(right);
                CSTNode result = createOperationCallExpCS(
                        left,
                        simpleNameCS,
                        args
                    );
                setOffsets(result, left, right);
                dtParser.setSym1(result);
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
                
                SimpleNameCS simpleNameCS = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            getIToken(dtParser.getToken(1))
                        );
                setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
                OCLExpressionCS expr = (OCLExpressionCS)dtParser.getSym(2);
                CSTNode result = createOperationCallExpCS(
                        expr,
                        simpleNameCS,
                        new BasicEList()
                    );
                setOffsets(result, simpleNameCS, expr);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 218:  primaryNotNameCS ::= ( OclExpressionCS )
            //
            case 218: {
                
                CSTNode result = (CSTNode)dtParser.getSym(2);
                if (result instanceof OperationCallExpCS) {
                    ((OperationCallExpCS)result).setIsAtomic(true);
                }
                setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 219:  LetExpCS ::= let letVariablesCS in OclExpressionCS
            //
            case 219: {
                
                OCLExpressionCS expr = (OCLExpressionCS)dtParser.getSym(4);
                CSTNode result = createLetExpCS(
                        (EList)dtParser.getSym(2),
                        expr
                    );
                setOffsets(result, getIToken(dtParser.getToken(1)), expr);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 220:  letVariablesCS ::= typedInitializedVariableCS
            //
            case 220: {
                
                EList result = new BasicEList();
                result.add(dtParser.getSym(1));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 221:  letVariablesCS ::= letVariablesCS , typedInitializedVariableCS
            //
            case 221: {
                
                EList result = (EList)dtParser.getSym(1);
                result.add(dtParser.getSym(3));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 222:  qualifierList ::= $Empty
            //
            case 222:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 223:  qualifierList ::= qualifierList qualifier
            //
            case 223: {
                
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
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
                
				CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getIToken(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 227:  colon_param_listOpt ::= $Empty
            //
            case 227:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 228:  colon_param_listOpt ::= : param_list
            //
            case 228: {
                
				dtParser.setSym1(dtParser.getSym(2));
	          break;
            }
	 
            //
            // Rule 229:  complete_signature ::= simple_signature colon_param_listOpt
            //
            case 229: {
                
				SimpleSignatureCS simpleSignatureCS = (SimpleSignatureCS)dtParser.getSym(1);
				EList<ParameterDeclarationCS> resultList = (EList<ParameterDeclarationCS>)dtParser.getSym(2);
				CSTNode result = createCompleteSignatureCS(simpleSignatureCS, resultList);
				result.setStartOffset(simpleSignatureCS.getStartOffset());
				result.setEndOffset(getEndOffset(simpleSignatureCS.getEndOffset(), resultList));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 230:  simple_signatureOpt ::= $Empty
            //
            case 230:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 232:  simple_signature ::= ( param_listOpt )
            //
            case 232: {
                
				CSTNode result = createSimpleSignatureCS((EList<ParameterDeclarationCS>)dtParser.getSym(2));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 233:  param_listOpt ::= $Empty
            //
            case 233:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 235:  param_list ::= param_list , param
            //
            case 235: {
                
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 236:  param_list ::= param_list , qvtErrorToken
            //
            case 236: {
                
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 237:  param_list ::= param
            //
            case 237: {
                
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 238:  param_list ::= qvtErrorToken
            //
            case 238: {
                
				EList result = new BasicEList();
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 239:  param ::= param_directionOpt IDENTIFIER : typespec
            //
            case 239: {
                
				DirectionKindCS paramDirectionCS = (DirectionKindCS) dtParser.getSym(1);
				CSTNode result = createParameterDeclarationCS(
						paramDirectionCS,
						getIToken(dtParser.getToken(2)),
						(TypeSpecCS)dtParser.getSym(4)
					);
				
				result.setStartOffset(paramDirectionCS != null ? paramDirectionCS.getStartOffset() : getIToken(dtParser.getToken(2)).getStartOffset());
				result.setEndOffset(((CSTNode)dtParser.getSym(4)).getEndOffset());
				
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 240:  param ::= param_directionOpt typespec
            //
            case 240: {
                
				DirectionKindCS paramDirectionCS = (DirectionKindCS) dtParser.getSym(1);
				TypeSpecCS paramTypeCS = (TypeSpecCS) dtParser.getSym(2);
				CSTNode result = createParameterDeclarationCS(
						paramDirectionCS,
						null,
						paramTypeCS
					);

				result.setStartOffset(paramDirectionCS != null ? paramDirectionCS.getStartOffset() : paramTypeCS.getStartOffset());
				result.setEndOffset(paramTypeCS.getEndOffset());
				
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 241:  param_directionOpt ::= $Empty
            //
            case 241:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 243:  param_direction ::= in
            //
            case 243: {
                
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.IN
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 244:  param_direction ::= out
            //
            case 244: {
                
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.OUT
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 245:  param_direction ::= inout
            //
            case 245: {
                
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.INOUT
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 248:  declarator1 ::= IDENTIFIER : typeCS
            //
            case 248: {
                
				CSTNode result = createVariableCS(
						getIToken(dtParser.getToken(1)),
						(TypeCS)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 249:  declarator1 ::= IDENTIFIER : typeCS = OclExpressionCS
            //
            case 249: {
                
				CSTNode result = createVariableCS(
						getIToken(dtParser.getToken(1)),
						(TypeCS)dtParser.getSym(3),
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(5));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 250:  declarator1 ::= IDENTIFIER : typeCS := OclExpressionCS
            //
            case 250: {
                
				CSTNode result = createVariableCS(
						getIToken(dtParser.getToken(1)),
						(TypeCS)dtParser.getSym(3),
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(5));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 251:  declarator2 ::= IDENTIFIER := OclExpressionCS
            //
            case 251: {
                
				CSTNode result = createVariableCS(
						getIToken(dtParser.getToken(1)),
						null,
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 252:  typespec ::= typeCS
            //
            case 252: {
                
				CSTNode result = createTypeSpecCS(
					(TypeCS)dtParser.getSym(1),
					null
					);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 253:  typespec ::= typeCS @ IDENTIFIER
            //
            case 253: {
                
				CSTNode result = createTypeSpecCS(
					(TypeCS)dtParser.getSym(1),
					getIToken(dtParser.getToken(3))
					);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 257:  scoped_identifier ::= typeCS2 :: IDENTIFIER
            //
            case 257: {
                
				ScopedNameCS result = createScopedNameCS((TypeCS)dtParser.getSym(1), getTokenText(dtParser.getToken(3)));		
				setOffsets(result, (CSTNode) dtParser.getSym(1), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 258:  scoped_identifier ::= typeCS2 :: qvtErrorToken
            //
            case 258: {
                
				ScopedNameCS result = createScopedNameCS((TypeCS)dtParser.getSym(1), ""); //$NON-NLS-1$		
				setOffsets(result, (CSTNode) dtParser.getSym(1), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 259:  scoped_identifier ::= scoped_identifier2
            //
            case 259: {
                
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				String name = pathNameCS.getSimpleNames().remove(pathNameCS.getSimpleNames().size() - 1).getValue();
				TypeCS typeCS = pathNameCS.getSimpleNames().isEmpty() ? null : pathNameCS;

				ScopedNameCS result = createScopedNameCS(typeCS, name);		

				setOffsets(result, pathNameCS);

                                    // reduce the region by the removed name element
				pathNameCS.setEndOffset(pathNameCS.getEndOffset() - (name != null ? name.length() : 0) - 2);
				
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 260:  scoped_identifier2 ::= IDENTIFIER
            //
            case 260: {
                
				CSTNode result = createPathNameCS(getIToken(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 261:  scoped_identifier2 ::= main
            //
            case 261: {
                
				CSTNode result = createPathNameCS(getIToken(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 262:  scoped_identifier2 ::= scoped_identifier2 :: IDENTIFIER
            //
            case 262: {
                
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getIToken(dtParser.getToken(3)));
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 263:  scoped_identifier2 ::= scoped_identifier2 :: qvtErrorToken
            //
            case 263: {
                
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, (IToken) null);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 264:  scoped_identifier_list ::= scoped_identifier
            //
            case 264: {
                
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 265:  scoped_identifier_list ::= scoped_identifier_list , scoped_identifier
            //
            case 265: {
                
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 266:  scoped_identifier_list ::= scoped_identifier_list qvtErrorToken
            //
            case 266: {
                
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 269:  expression_listOpt ::= $Empty
            //
            case 269:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 273:  expression_semi_list ::= expression_semi_list_element
            //
            case 273: {
                
				EList result = new BasicEList();
				Object element = dtParser.getSym(1);
				if (element instanceof EList) {
					result.addAll((EList) element);
				} else {
					result.add(element);
				}
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 274:  expression_semi_list ::= expression_semi_list ; expression_semi_list_element
            //
            case 274: {
                
				EList result = (EList)dtParser.getSym(1);
				Object element = dtParser.getSym(3);
				if (element instanceof EList) {
					result.addAll((EList) element);
				} else {
					result.add(element);
				}
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 275:  expression_semi_list ::= expression_semi_list qvtErrorToken
            //
            case 275: {
                
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 276:  expression_block ::= { expression_listOpt }
            //
            case 276: {
                
			EList bodyList = (EList) dtParser.getSym(2);
			CSTNode result = createBlockExpCS(
				bodyList
			);
			
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
			dtParser.setSym1(result);
                  break;
            }
	 
            //
            // Rule 277:  expression_block ::= { qvtErrorToken
            //
            case 277: {
                
			CSTNode result = createBlockExpCS(
				ourEmptyEList
			);
			
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
                  break;
            }
	 
            //
            // Rule 280:  qualifiedNameCS ::= qvtIdentifierCS
            //
            case 280: {
                
				CSTNode result = createPathNameCS(getIToken(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 281:  qualifiedNameCS ::= qualifiedNameCS . qvtIdentifierCS
            //
            case 281: {
                
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getIToken(dtParser.getToken(3)));
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 282:  qualifiedNameCS ::= qualifiedNameCS . qvtErrorToken
            //
            case 282: {
                
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, (IToken) null);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 283:  qualifiedNameCS ::= qualifiedNameCS qvtErrorToken
            //
            case 283: {
                
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				dtParser.setSym1(result);
	          break;
            }	
	 
            //
            // Rule 285:  oclExpressionCSOpt ::= $Empty
            //
            case 285:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 286:  letExpSubCS3 ::= untypedInitializedVariableCS
            //
            case 286: {
                
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 287:  letExpSubCS3 ::= letExpSubCS3 , untypedInitializedVariableCS
            //
            case 287: {
                
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 288:  LetExpCS ::= let letExpSubCS3 in OclExpressionCS
            //
            case 288: {
                
				EList variables = (EList)dtParser.getSym(2);
				CSTNode result = createLetExpCS(
						variables,
						(OCLExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 289:  LetExpCS ::= let letExpSubCS3 in qvtErrorToken
            //
            case 289: {
                
				EList variables = (EList)dtParser.getSym(2);
				CSTNode result = createLetExpCS(
						variables,
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, (IToken) null)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 290:  CallExpCS ::= . qvtErrorToken
            //
            case 290: {
                
				CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
	 			result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 291:  CallExpCS ::= -> qvtErrorToken
            //
            case 291: {
                
				CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
	 			result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 292:  argumentsCS ::= qvtErrorToken
            //
            case 292:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 294:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( qvtErrorToken
            //
            case 294: {
                
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				CSTNode result = createIteratorExpCS(
						source,
						simpleNameCS,
						null,
						null,
						null
					);
				setOffsets(result, source, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 296:  qvtErrorToken ::= ERROR_TOKEN
            //
            case 296: {
                
				diagnozeErrorToken(dtParser.getToken(1));
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
                
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.NOT_EQUAL)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 300:  listTypeCS ::= List ( typeCS )
            //
            case 300: {
                
				CSTNode result = createListTypeCS(
						(TypeCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 301:  listLiteralCS ::= List { CollectionLiteralPartsCSopt }
            //
            case 301: {
                
				CSTNode result = createListLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 303:  dictTypeCS ::= Dict ( typeCS , typeCS )
            //
            case 303: {
                
				CSTNode result = createDictTypeCS((TypeCS)dtParser.getSym(3), (TypeCS)dtParser.getSym(5));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 304:  dictLiteralCS ::= Dict { dictLiteralPartListCSopt }
            //
            case 304: {
                
				CSTNode result = createDictLiteralExpCS((EList<DictLiteralPartCS>)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 308:  dictLiteralPartCS ::= literalSimpleCS = OclExpressionCS
            //
            case 308: {
                
				CSTNode result = createDictLiteralPartCS((LiteralExpCS)dtParser.getSym(1), (OCLExpressionCS)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 310:  dictLiteralPartListCSopt ::= $Empty
            //
            case 310:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 311:  dictLiteralPartListCS ::= dictLiteralPartCS
            //
            case 311: {
                
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 312:  dictLiteralPartListCS ::= dictLiteralPartListCS , dictLiteralPartCS
            //
            case 312: {
                
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 313:  dictLiteralPartListCS ::= dictLiteralPartListCS qvtErrorToken
            //
            case 313: {
                
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 315:  returnExpCS ::= return oclExpressionCSOpt
            //
            case 315: {
                
			ReturnExpCS returnExpCS = createReturnExpCS((OCLExpressionCS)dtParser.getSym(2));
			CSTNode result = createExpressionStatementCS(returnExpCS);
			if(returnExpCS.getValue() != null) {
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(2));			
			} else {
				setOffsets(result, getIToken(dtParser.getToken(1)));
			}
			setOffsets(returnExpCS, result);
			dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 317:  var_init_group_exp ::= var var_init_declarator_list
            //
            case 317: {
                
				dtParser.setSym1(dtParser.getSym(2));
	          break;
            }
	 
            //
            // Rule 318:  var_init_group_exp ::= var ( var_init_declarator_list )
            //
            case 318: {
                
				dtParser.setSym1(dtParser.getSym(3));
	          break;
            }
	 
            //
            // Rule 319:  var_init_group_exp ::= var ( var_init_declarator_list qvtErrorToken
            //
            case 319: {
                
				dtParser.setSym1(dtParser.getSym(3));
	          break;
            }
	 
            //
            // Rule 321:  var_init_exp ::= var var_init_declarator
            //
            case 321: {
                
				dtParser.setSym1(dtParser.getSym(2));
	          break;
            }
	 
            //
            // Rule 322:  var_init_exp ::= var ( var_init_declarator )
            //
            case 322: {
                
				dtParser.setSym1(dtParser.getSym(3));
	          break;
            }
	 
            //
            // Rule 323:  var_init_exp ::= var ( var_init_declarator qvtErrorToken
            //
            case 323: {
                
				dtParser.setSym1(dtParser.getSym(3));
	          break;
            }
	 
            //
            // Rule 324:  var_init_exp ::= var qvtErrorToken
            //
            case 324: {
                
				dtParser.setSym1(ourEmptyEList);
	          break;
            }
	 
            //
            // Rule 325:  var_init_declarator_list ::= var_init_declarator , var_init_declarator
            //
            case 325: {
                
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 326:  var_init_declarator_list ::= var_init_declarator_list , var_init_declarator
            //
            case 326: {
                
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 327:  var_init_declarator ::= IDENTIFIER : typeCS var_init_op OclExpressionCS
            //
            case 327: {
                
				CSTNode result = createVariableInitializationCS(
						getIToken(dtParser.getToken(1)),
						(TypeCS)dtParser.getSym(3),
						(OCLExpressionCS)dtParser.getSym(5),
						(Boolean)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(5));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 328:  var_init_declarator ::= IDENTIFIER : typeCS var_init_op qvtErrorToken
            //
            case 328: {
                
				CSTNode result = createVariableInitializationCS(
						getIToken(dtParser.getToken(1)),
						(TypeCS)dtParser.getSym(3),
						null,
						(Boolean)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 329:  var_init_declarator ::= IDENTIFIER var_init_op OclExpressionCS
            //
            case 329: {
                
				CSTNode result = createVariableInitializationCS(
						getIToken(dtParser.getToken(1)),
						null,
						(OCLExpressionCS)dtParser.getSym(3),
						(Boolean)dtParser.getSym(2)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 330:  var_init_declarator ::= IDENTIFIER var_init_op qvtErrorToken
            //
            case 330: {
                
				CSTNode result = createVariableInitializationCS(
						getIToken(dtParser.getToken(1)),
						null,
						null,
						(Boolean)dtParser.getSym(2)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 331:  var_init_declarator ::= IDENTIFIER : typeCS
            //
            case 331: {
                
				CSTNode result = createVariableInitializationCS(
						getIToken(dtParser.getToken(1)),
						(TypeCS)dtParser.getSym(3),
						null,
						false
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 332:  var_init_declarator ::= IDENTIFIER : qvtErrorToken
            //
            case 332: {
                
				CSTNode result = createVariableInitializationCS(
						getIToken(dtParser.getToken(1)),
						null,
						null,
						false
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
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
                
				dtParser.setSym1(false);
	          break;
            }
	 
            //
            // Rule 335:  var_init_op ::= ::=
            //
            case 335: {
                
				dtParser.setSym1(true);
	          break;
            }
	 
            //
            // Rule 337:  assignStatementCS ::= primaryExpCS := OclExpressionCS
            //
            case 337: {
                
				CSTNode result = createAssignStatementCS(
						(OCLExpressionCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(3),
						false
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 338:  assignStatementCS ::= primaryExpCS := qvtErrorToken
            //
            case 338: {
                
				CSTNode result = createAssignStatementCS(
						(OCLExpressionCS)dtParser.getSym(1),
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, (IToken) null),
						false
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 339:  assignStatementCS ::= primaryExpCS += OclExpressionCS
            //
            case 339: {
                
				CSTNode result = createAssignStatementCS(
						(OCLExpressionCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(3),
						true
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 340:  assignStatementCS ::= primaryExpCS += qvtErrorToken
            //
            case 340: {
                
				CSTNode result = createAssignStatementCS(
						(OCLExpressionCS)dtParser.getSym(1),
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, (IToken) null),
						true
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 342:  whileExpCS ::= while ( declarator1 ; OclExpressionCS ) whileBodyCS
            //
            case 342: {
                
				CSTNode result = createWhileExpCS(
						(VariableCS)dtParser.getSym(3),
						(OCLExpressionCS)dtParser.getSym(5),
						(BlockExpCS)dtParser.getSym(7)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(7));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 343:  whileExpCS ::= while ( assignStatementCS ; OclExpressionCS ) whileBodyCS
            //
            case 343: {
                
				AssignStatementCS assignment = (AssignStatementCS)dtParser.getSym(3);
				CSTNode result = createWhileExpCS(
						getVariableFromAssignment(assignment),
						(OCLExpressionCS)dtParser.getSym(5),
						(BlockExpCS)dtParser.getSym(7)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(7));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 344:  whileExpCS ::= while ( OclExpressionCS ) whileBodyCS
            //
            case 344: {
                
				CSTNode result = createWhileExpCS(
						null,
						(OCLExpressionCS)dtParser.getSym(3),
						(BlockExpCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(5));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 345:  IteratorExpCS ::= primaryExpCS -> forExpCS
            //
            case 345: {
                
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				ForExpCS forExpCS = (ForExpCS)dtParser.getSym(3);
				forExpCS.setSource(source);
				setOffsets(forExpCS, source, forExpCS);
				dtParser.setSym1(forExpCS);
	          break;
            }
	 
            //
            // Rule 348:  forExpDeclaratorList ::= IDENTIFIER
            //
            case 348: {
                
		EList result = new BasicEList();
		result.add(getIToken(dtParser.getToken(1)));
		dtParser.setSym1(result);
                  break;
            }
    	 
            //
            // Rule 349:  forExpDeclaratorList ::= forExpDeclaratorList , IDENTIFIER
            //
            case 349: {
                
		EList result = (EList)dtParser.getSym(1);
		result.add(getIToken(dtParser.getToken(3)));
		dtParser.setSym1(result);
                  break;
            }
    	 
            //
            // Rule 350:  forExpConditionOpt ::= $Empty
            //
            case 350:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 351:  forExpConditionOpt ::= | OclExpressionCS
            //
            case 351: {
                
            	    dtParser.setSym1((OCLExpressionCS)dtParser.getSym(2));
                  break;
            }
    	 
            //
            // Rule 352:  forExpConditionOpt ::= | qvtErrorToken
            //
            case 352:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 353:  forExpCS ::= forOpCode ( forExpDeclaratorList forExpConditionOpt ) expression_block
            //
            case 353: {
                
				CSTNode result = createForExpCS(
						getIToken(dtParser.getToken(1)),
						(EList)dtParser.getSym(3),
						(OCLExpressionCS)dtParser.getSym(4),
						(BlockExpCS)dtParser.getSym(6)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(6));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 354:  forExpCS ::= forOpCode qvtErrorToken
            //
            case 354: {
                
				CSTNode result = createForExpCS(
						getIToken(dtParser.getToken(1)),
						null,
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 358:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS else ifExpBodyCS endif
            //
            case 358: {
                
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4),
						(OCLExpressionCS)dtParser.getSym(6)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 359:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS endif
            //
            case 359: {
                
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 360:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS else ifExpBodyCS qvtErrorToken
            //
            case 360: {
                
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4),
						(OCLExpressionCS)dtParser.getSym(6)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(6));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 361:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS else qvtErrorToken
            //
            case 361: {
                
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 362:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS qvtErrorToken
            //
            case 362: {
                
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 363:  IfExpCS ::= if OclExpressionCS then qvtErrorToken
            //
            case 363: {
                
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 364:  IfExpCS ::= if OclExpressionCS qvtErrorToken
            //
            case 364: {
                
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 365:  IfExpCS ::= if qvtErrorToken
            //
            case 365: {
                
				OCLExpressionCS invalidCondition = createInvalidLiteralExpCS(""); //$NON-NLS-1$
				invalidCondition.setStartOffset(getIToken(dtParser.getToken(1)).getEndOffset());
				invalidCondition.setEndOffset(getIToken(dtParser.getToken(1)).getEndOffset());
				CSTNode result = createIfExpCS(
						invalidCondition,
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 367:  switchExpCS ::= switch switchBodyExpCS
            //
            case 367: {
                
				Object[] switchBody = (Object[]) dtParser.getSym(2);

				CSTNode result = createSwitchExpCS(
						(EList<SwitchAltExpCS>) switchBody[0],
						(OCLExpressionCS) switchBody[1]
					);
				if (switchBody[2] instanceof IToken) { // In case of correct and incorrect syntax
					setOffsets(result, getIToken(dtParser.getToken(1)), (IToken) switchBody[2]);
				} else { // In case of errors in switchBody
					setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode) switchBody[2]);
				}
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 369:  switchDeclaratorCS ::= IDENTIFIER
            //
            case 369: {
                
				CSTNode result = createVariableCS(
						getIToken(dtParser.getToken(1)),
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 370:  switchDeclaratorCS ::= IDENTIFIER = OclExpressionCS
            //
            case 370: {
                
				CSTNode result = createVariableCS(
						getIToken(dtParser.getToken(1)),
						null,
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 371:  IterateExpCS ::= primaryExpCS -> switch ( switchDeclaratorCS ) switchBodyExpCS
            //
            case 371: {
                
				Object[] switchBody = (Object[]) dtParser.getSym(7);

				OCLExpressionCS switchExpCS = (OCLExpressionCS) createSwitchExpCS(
						(EList<SwitchAltExpCS>) switchBody[0],
						(OCLExpressionCS) switchBody[1]							
					);
				if (switchBody[2] instanceof IToken) { // In case of correct and incorrect syntax
					setOffsets(switchExpCS, getIToken(dtParser.getToken(3)), (IToken) switchBody[2]);
				} else if (switchBody[2] instanceof CSTNode) { // In case of errors in switchBody
					setOffsets(switchExpCS, getIToken(dtParser.getToken(3)), (CSTNode) switchBody[2]);
				} else { // In case of errors in switchBody
					setOffsets(switchExpCS, getIToken(dtParser.getToken(3)), getIToken(dtParser.getToken(6)));
				}

				EList<VariableCS> iterators = new BasicEList<VariableCS>();
				iterators.add((VariableCS) dtParser.getSym(5));
				CallExpCS result = createImperativeIterateExpCS(
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "xcollect"), //$NON-NLS-1$
						iterators,
						null,
						switchExpCS,
						null
					);
					
				result.setSource((OCLExpressionCS) dtParser.getSym(1));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
				
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 372:  switchExpCS ::= switch qvtErrorToken
            //
            case 372: {
                
				CSTNode result = createSwitchExpCS(
						new BasicEList(),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 373:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt }
            //
            case 373: {
                
				Object[] result = new Object[] {dtParser.getSym(2), dtParser.getSym(3), getIToken(dtParser.getToken(4))};
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 374:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt qvtErrorToken
            //
            case 374: {
                
				Object[] result = new Object[] {dtParser.getSym(2), dtParser.getSym(3), dtParser.getSym(3)};
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 375:  switchBodyExpCS ::= { qvtErrorToken
            //
            case 375: {
                
				Object[] result = new Object[] {new BasicEList(), null, getIToken(dtParser.getToken(1))};
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 376:  switchAltExpCSList ::= switchAltExpCS
            //
            case 376: {
                
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 377:  switchAltExpCSList ::= switchAltExpCSList switchAltExpCS
            //
            case 377: {
                
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 378:  switchAltExpCS ::= case ( OclExpressionCS ) expression_statement
            //
            case 378: {
                
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(3),
						(OCLExpressionCS) dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 379:  switchAltExpCS ::= case ( OclExpressionCS ) qvtErrorToken
            //
            case 379: {
                
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 380:  switchElseExpCSOpt ::= $Empty
            //
            case 380:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 382:  switchElseExpCS ::= else expression_statement
            //
            case 382: {
                
				dtParser.setSym1((CSTNode)dtParser.getSym(2));
	          break;
            }
	 
            //
            // Rule 383:  switchElseExpCS ::= else qvtErrorToken
            //
            case 383: {
                
				dtParser.setSym1(null);
	          break;
            }
	 
            //
            // Rule 384:  OclExpressionCS ::= primaryOCLExpressionCS
            //
            case 384: {
                
				CSTNode result = createExpressionStatementCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 386:  logWhenExp ::= when OclExpressionCS
            //
            case 386: {
                
			OCLExpressionCS condition = (OCLExpressionCS) dtParser.getSym(2);
			dtParser.setSym1(condition);
              break;
            }
     
            //
            // Rule 388:  logWhenExpOpt ::= $Empty
            //
            case 388:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 389:  logExpCS ::= log ( argumentsCSopt ) logWhenExpOpt
            //
            case 389: {
                
			OCLExpressionCS condition = (OCLExpressionCS) dtParser.getSym(5);
			LogExpCS result = (LogExpCS)createLogExpCS((EList<OCLExpressionCS>)dtParser.getSym(3), condition);
			if(condition != null) {
				setOffsets(result, getIToken(dtParser.getToken(1)), condition);
			} else {
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
			}
			dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 391:  severityKindCS ::= simpleNameCS
            //
            case 391: {
                
			dtParser.setSym1(dtParser.getSym(1));
	          break;
            }
	 
            //
            // Rule 393:  severityKindCSOpt ::= $Empty
            //
            case 393:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 394:  assertWithLogExp ::= with logExpCS
            //
            case 394: {
                
			LogExpCS logExp = (LogExpCS) dtParser.getSym(2);
			setOffsets(logExp, getIToken(dtParser.getToken(2)), logExp);
			dtParser.setSym1(logExp);
              break;
            }
     
            //
            // Rule 396:  assertWithLogExpOpt ::= $Empty
            //
            case 396:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 397:  assertExpCS ::= assert severityKindCSOpt ( OclExpressionCS ) assertWithLogExpOpt
            //
            case 397: {
                
			LogExpCS logExpCS = (LogExpCS)dtParser.getSym(6);
			OCLExpressionCS condition = (OCLExpressionCS)dtParser.getSym(4);
			AssertExpCS result = (AssertExpCS)createAssertExpCS(condition, (SimpleNameCS)dtParser.getSym(2), logExpCS);
	
			CSTNode end = logExpCS != null ? logExpCS : condition; 
			setOffsets(result, getIToken(dtParser.getToken(1)), end);
			dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 398:  computeExpCS ::= compute ( declarator ) expression_block
            //
            case 398: {
                
				CSTNode result = createComputeExpCS(
					(VariableCS) dtParser.getSym(3),
					(OCLExpressionCS) dtParser.getSym(5)
				);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 400:  IterateExpCS ::= primaryExpCS -> imperativeIterateExpCS
            //
            case 400: {
                
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				ImperativeIterateExpCS iterateExpCS = (ImperativeIterateExpCS) dtParser.getSym(3);
				iterateExpCS.setSource(source);
				setOffsets(iterateExpCS, source, iterateExpCS);
				dtParser.setSym1(iterateExpCS);
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
                
				String opCode = getTokenText(dtParser.getToken(1));
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getIToken(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				Object[] iterContents = (Object[]) dtParser.getSym(3);
				OCLExpressionCS bodyCS = null;
				OCLExpressionCS conditionCS = null;
				if ("xcollect".equals(opCode) || "collectOne".equals(opCode)) { //$NON-NLS-1$ //$NON-NLS-2$ 
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
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 411:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken qvtErrorToken
            //
            case 411: {
                
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getIToken(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createImperativeIterateExpCS(
						simpleNameCS,
						ourEmptyEList,
						null,
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 412:  imperativeIterContents12 ::= OclExpressionCS
            //
            case 412: {
                
				dtParser.setSym1(new Object[] {
						ourEmptyEList,
						null,
						dtParser.getSym(1)
					});
	          break;
            }
	 
            //
            // Rule 413:  imperativeIterContents12 ::= uninitializedVariableCS | OclExpressionCS
            //
            case 413: {
                
				EList iters = new BasicEList();
				iters.add(dtParser.getSym(1));
				
				dtParser.setSym1(new Object[] {
						iters,
						null,
						dtParser.getSym(3)
					});
	          break;
            }
	 
            //
            // Rule 414:  imperativeIterContents12 ::= simpleNameCS , variableDeclarationListCS | OclExpressionCS
            //
            case 414: {
                
                SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
                CSTNode variableCS = createVariableCS(name, null, null);
                setOffsets(variableCS, name);

				EList iters = (EList) dtParser.getSym(3);
				iters.add(0, variableCS);
				
				dtParser.setSym1(new Object[] {
						iters,
						null,
						dtParser.getSym(5)
					});
	          break;
            }
	 
            //
            // Rule 415:  imperativeIterContents3 ::= variableDeclarationListCS ; initializedVariableCS | OclExpressionCS
            //
            case 415: {
                
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						dtParser.getSym(3),
						dtParser.getSym(5)
					});
	          break;
            }
	 
            //
            // Rule 416:  variableDeclarationListCS ::= uninitializedVariableCS
            //
            case 416: {
                
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 417:  variableDeclarationListCS ::= variableDeclarationListCS , uninitializedVariableCS
            //
            case 417: {
                
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 418:  exclamationOpt ::= $Empty
            //
            case 418:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 420:  declarator_vsep ::= IDENTIFIER |
            //
            case 420: {
                
		CSTNode result = createVariableCS(
					getIToken(dtParser.getToken(1)),
                                            null,
					null
					);
                    setOffsets(result, getIToken(dtParser.getToken(1)));
                    dtParser.setSym1(result);
                  break;
            }
    	 
            //
            // Rule 421:  declarator_vsepOpt ::= $Empty
            //
            case 421:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 423:  IterateExpCS ::= primaryExpCS exclamationOpt [ declarator_vsepOpt OclExpressionCS ]
            //
            case 423: {
                
		OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
		if (source instanceof ImperativeIterateExpCS) {
			String opCode = isTokenOfType(getIToken(dtParser.getToken(2)), QVTOParsersym.TK_EXCLAMATION_MARK) ?  "collectselectOne" : "collectselect"; //$NON-NLS-1$ //$NON-NLS-2$ 
			SimpleNameCS simpleNameCS = createSimpleNameCS(
					SimpleTypeEnum.KEYWORD_LITERAL,
					opCode
					);
			setOffsets(simpleNameCS, getIToken(dtParser.getToken(3)), getIToken(dtParser.getToken(6)));

			ImperativeIterateExpCS result = (ImperativeIterateExpCS) source;
			result.setSimpleNameCS(simpleNameCS);
			
			VariableCS variableCS = (VariableCS) dtParser.getSym(4);
	        if (variableCS != null) {
	            result.setTarget(variableCS);
	        }
	        result.setCondition((OCLExpressionCS) dtParser.getSym(5));
			
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
			dtParser.setSym1(result);
		}
		else {
			String opCode = isTokenOfType(getIToken(dtParser.getToken(2)), QVTOParsersym.TK_EXCLAMATION_MARK) ?  "selectOne" : "xselect"; //$NON-NLS-1$ //$NON-NLS-2$ 
			SimpleNameCS simpleNameCS = createSimpleNameCS(
					SimpleTypeEnum.KEYWORD_LITERAL,
					opCode
					);
			setOffsets(simpleNameCS, getIToken(dtParser.getToken(3)), getIToken(dtParser.getToken(6)));
			
			CallExpCS result = createImperativeIterateExpCS(
					simpleNameCS,
					ourEmptyEList,
					(VariableCS) dtParser.getSym(4),
					null,
					(OCLExpressionCS) dtParser.getSym(5)
					);
			result.setSource(source);
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
			dtParser.setSym1(result);
		}
	          break;
            }
	 
            //
            // Rule 424:  IterateExpCS ::= primaryExpCS -> simpleNameCS
            //
            case 424: {
                
		String opCode = "xcollect"; //$NON-NLS-1$
		SimpleNameCS simpleNameCS = createSimpleNameCS(
				SimpleTypeEnum.KEYWORD_LITERAL,
				opCode
				);

		OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
		SimpleNameCS featureNameCS = (SimpleNameCS)dtParser.getSym(3);
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
		setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
		dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 426:  newExpCS ::= new newTypespecCS ( argumentsCSopt )
            //
            case 426: {
                
			OCLExpressionCS result = createNewRuleCallExpCS((TypeSpecCS) dtParser.getSym(2), (EList) dtParser.getSym(4));
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
			dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 427:  newTypespecCS ::= pathNameCS
            //
            case 427: {
                
				CSTNode result = createTypeSpecCS(
					(TypeCS)dtParser.getSym(1),
					null
					);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 428:  newTypespecCS ::= pathNameCS @ IDENTIFIER
            //
            case 428: {
                
				CSTNode result = createTypeSpecCS(
					(TypeCS)dtParser.getSym(1),
					getIToken(dtParser.getToken(3))
					);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 429:  primaryNotNameCS ::= break
            //
            case 429: {
                
			OCLExpressionCS result = createBreakCS();
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 430:  primaryNotNameCS ::= continue
            //
            case 430: {
                
			OCLExpressionCS result = createContinueCS();
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 431:  switchAltExpCS ::= ( OclExpressionCS ) ? OclExpressionCS ;
            //
            case 431: {
                
				CSTNode result = createSwitchAltExpCSDeprecated(
						(OCLExpressionCS) dtParser.getSym(2),
						(OCLExpressionCS) dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 432:  switchAltExpCS ::= ( OclExpressionCS ) qvtErrorToken
            //
            case 432: {
                
				CSTNode result = createSwitchAltExpCSDeprecated(
						(OCLExpressionCS) dtParser.getSym(2),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 433:  switchAltExpCS ::= ( qvtErrorToken
            //
            case 433: {
                
				CSTNode result = createSwitchAltExpCSDeprecated(
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 434:  switchElseExpCS ::= else ? OclExpressionCS ;
            //
            case 434: {
                
		    	int startOffset = getIToken(dtParser.getToken(1)).getStartOffset();
		    	int endOffset = getIToken(dtParser.getToken(4)).getEndOffset();
				reportWarning(org.eclipse.m2m.internal.qvt.oml.cst.parser.NLS.bind(org.eclipse.m2m.internal.qvt.oml.cst.parser.Messages.AbstractQVTParser_DeprecatedSwitchElseExp, null), startOffset, endOffset);
				
				dtParser.setSym1((CSTNode)dtParser.getSym(3));
	          break;
            }
	 
            //
            // Rule 435:  switchElseExpCS ::= else ? OclExpressionCS qvtErrorToken
            //
            case 435: {
                
		    	int startOffset = getIToken(dtParser.getToken(1)).getStartOffset();
		    	int endOffset = getIToken(dtParser.getToken(3)).getEndOffset();
				reportWarning(org.eclipse.m2m.internal.qvt.oml.cst.parser.NLS.bind(org.eclipse.m2m.internal.qvt.oml.cst.parser.Messages.AbstractQVTParser_DeprecatedSwitchElseExp, null), startOffset, endOffset);
				
				dtParser.setSym1((CSTNode)dtParser.getSym(3));
	          break;
            }
	 
            //
            // Rule 436:  topLevel ::= unit_elementList
            //
            case 436: {
                
				EList<CSTNode> unitElements = (EList<CSTNode>)dtParser.getSym(1);
				dtParser.setSym1(setupTopLevel(unitElements));
	          break;
            }
	 
            //
            // Rule 438:  _import ::= import unit ;
            //
            case 438: {
                
				CSTNode result = createImportCS(
						(PathNameCS)dtParser.getSym(2)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 439:  _import ::= import qvtErrorToken
            //
            case 439: {
                
				CSTNode result = createLibraryImportCS(
						createPathNameCS()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 441:  unit_elementList ::= unit_elementList unit_element
            //
            case 441: {
                
				EList list = (EList)dtParser.getSym(1);
				list.add(dtParser.getSym(2));
				dtParser.setSym1(list);
	          break;
            }
	 
            //
            // Rule 442:  unit_elementList ::= $Empty
            //
            case 442:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 453:  unit_element ::= qvtErrorToken
            //
            case 453:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 456:  transformation_decl ::= transformation_h ;
            //
            case 456: {
                
				TransformationHeaderCS headerCS = (TransformationHeaderCS) dtParser.getSym(1);
				setOffsets(headerCS, headerCS, getIToken(dtParser.getToken(2)));
				MappingModuleCS moduleCS = createMappingModuleCS(headerCS, ourEmptyEList);
				setOffsets(moduleCS, headerCS);
				dtParser.setSym1(moduleCS);
	          break;
            }
	 
            //
            // Rule 457:  transformation_def ::= transformation_h { module_elementList } semicolonOpt
            //
            case 457: {
                
				TransformationHeaderCS headerCS = (TransformationHeaderCS) dtParser.getSym(1);
				MappingModuleCS moduleCS = createMappingModuleCS(headerCS, (EList) dtParser.getSym(3));
				setOffsets(moduleCS, headerCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(moduleCS);
	          break;
            }
	 
            //
            // Rule 460:  library_decl ::= library_h ;
            //
            case 460: {
                
				TransformationHeaderCS headerCS = (TransformationHeaderCS) dtParser.getSym(1);
				setOffsets(headerCS, headerCS, getIToken(dtParser.getToken(2)));
				MappingModuleCS moduleCS = createLibraryCS(headerCS, ourEmptyEList);
				setOffsets(moduleCS, headerCS);
				dtParser.setSym1(moduleCS);
	          break;
            }
	 
            //
            // Rule 461:  library_def ::= library_h { module_elementList } semicolonOpt
            //
            case 461: {
                
				TransformationHeaderCS headerCS = (TransformationHeaderCS) dtParser.getSym(1);
				MappingModuleCS moduleCS = createLibraryCS(headerCS, (EList) dtParser.getSym(3));
				setOffsets(moduleCS, headerCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(moduleCS);
	          break;
            }
	 
            //
            // Rule 462:  transformation_h ::= qualifierList transformation qualifiedNameCS transformation_signature transformation_usage_refineOpt
            //
            case 462: {
                
				EList qualifierList = (EList) dtParser.getSym(1);
				EList transfUsages = ourEmptyEList;
				TransformationRefineCS transfRefine = null;
				Object transformation_usage_refineOpt = dtParser.getSym(5);
				if (transformation_usage_refineOpt instanceof TransformationRefineCS) {
					transfRefine = (TransformationRefineCS) transformation_usage_refineOpt;
				} else if (transformation_usage_refineOpt instanceof EList) {
					transfUsages = (EList) transformation_usage_refineOpt;
				}
				CSTNode result = createTransformationHeaderCS(
						qualifierList,
						(PathNameCS)dtParser.getSym(3),
						(SimpleSignatureCS)dtParser.getSym(4),
						transfUsages,
						transfRefine
					);
				if (qualifierList.isEmpty()) {
					setOffsets(result, getIToken(dtParser.getToken(2)));
				} else {
					setOffsets(result, (CSTNode) qualifierList.get(0));
				}
				if (transfRefine == null) {
					if (transfUsages.isEmpty()) {
						setOffsets(result, result, (SimpleSignatureCS)dtParser.getSym(4));
					}
					else {
						setOffsets(result, result, (CSTNode) transfUsages.get(transfUsages.size()-1));
					}
				} else {
					setOffsets(result, result, transfRefine);
				}
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 463:  transformation_usage_refineOpt ::= $Empty
            //
            case 463:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 468:  transformation_refine ::= refines moduleref
            //
            case 468: {
                
				CSTNode result = createTransformationRefineCS(
						(ModuleRefCS)dtParser.getSym(2)
					);
				setOffsets(result, (ModuleRefCS)dtParser.getSym(2));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 469:  library_h ::= library qualifiedNameCS library_signatureOpt module_usageListOpt
            //
            case 469: {
                
				PathNameCS name = (PathNameCS)dtParser.getSym(2);
				SimpleSignatureCS signature = (dtParser.getSym(3) == null) ? createSimpleSignatureCS(ourEmptyEList) : (SimpleSignatureCS)dtParser.getSym(3);
				EList<ModuleUsageCS> moduleUsages = (EList<ModuleUsageCS>)dtParser.getSym(4);
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
				} else if (dtParser.getSym(3) != null) {
					rightNode = signature;
				}
				setOffsets(result, getIToken(dtParser.getToken(1)), rightNode);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 470:  library_h ::= library qvtErrorToken
            //
            case 470: {
                
				CSTNode result = createTransformationHeaderCS(
						ourEmptyEList,
						createPathNameCS(),
						createSimpleSignatureCS(ourEmptyEList),
						ourEmptyEList,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 471:  library_signatureOpt ::= $Empty
            //
            case 471:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 474:  module_usageList ::= module_usage
            //
            case 474: {
                
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 475:  module_usageList ::= module_usageList module_usage
            //
            case 475: {
                
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 476:  module_usageListOpt ::= $Empty
            //
            case 476:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 480:  access_usage ::= access module_kindOpt moduleref_list
            //
            case 480: {
                
				EList moduleRefList = (EList)dtParser.getSym(3);
				CSTNode result = createModuleUsageCS(
						ImportKindEnum.ACCESS,
						(ModuleKindCS)dtParser.getSym(2),
						moduleRefList
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)moduleRefList.get(moduleRefList.size()-1));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 481:  extends_usage ::= extends module_kindOpt moduleref_list
            //
            case 481: {
                
				EList moduleRefList = (EList)dtParser.getSym(3);
				CSTNode result = createModuleUsageCS(
						ImportKindEnum.EXTENSION,
						(ModuleKindCS)dtParser.getSym(2),
						moduleRefList
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)moduleRefList.get(moduleRefList.size()-1));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 482:  module_kindOpt ::= $Empty
            //
            case 482:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 484:  module_kind ::= transformation
            //
            case 484: {
                
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.TRANSFORMATION
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 485:  module_kind ::= library
            //
            case 485: {
                
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.LIBRARY
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 486:  moduleref_list ::= moduleref
            //
            case 486: {
                
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 487:  moduleref_list ::= moduleref_list , moduleref
            //
            case 487: {
                
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 488:  moduleref_list ::= moduleref_list qvtErrorToken
            //
            case 488: {
                
				EList result = (EList) dtParser.getSym(1);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 489:  moduleref ::= pathNameCS simple_signatureOpt
            //
            case 489: {
                
				SimpleSignatureCS signature = (SimpleSignatureCS)dtParser.getSym(2);
				CSTNode result = createModuleRefCS(
						(PathNameCS)dtParser.getSym(1),
						signature 
					);
				CSTNode rightNode = (signature == null) ? (CSTNode)dtParser.getSym(1) : signature;
				setOffsets(result, (CSTNode)dtParser.getSym(1), rightNode);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 490:  module_elementList ::= module_elementList module_element
            //
            case 490: {
                
				EList list = (EList)dtParser.getSym(1);
				list.add(dtParser.getSym(2));
				dtParser.setSym1(list);
	          break;
            }
	 
            //
            // Rule 491:  module_elementList ::= $Empty
            //
            case 491:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 499:  module_element ::= qvtErrorToken
            //
            case 499:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 500:  _modeltype ::= modeltype IDENTIFIER compliance_kindOpt uses packageref_list modeltype_whereOpt ;
            //
            case 500: {
                
				EList whereList = (EList)dtParser.getSym(6);
				EList packageRefList = (EList)dtParser.getSym(5);
				ModelTypeCS result = createModelTypeCS(
						getIToken(dtParser.getToken(2)),
						(StringLiteralExpCS)dtParser.getSym(3),
						packageRefList,
						whereList
					);
				if (whereList.isEmpty()) {
					setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
				}
				else {
					CSTNode lastPackageRefCS = (CSTNode)packageRefList.get(packageRefList.size()-1);
					setOffsets(result, getIToken(dtParser.getToken(1)), lastPackageRefCS);
					setBodyOffsets(result, lastPackageRefCS, getIToken(dtParser.getToken(7)));
				}
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 501:  _modeltype ::= modeltype qvtErrorToken
            //
            case 501: {
                
				ModelTypeCS result = createModelTypeCS(
						new Token(0, 0, 0),
						null,
						ourEmptyEList,
						ourEmptyEList
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 502:  modeltype_whereOpt ::= $Empty
            //
            case 502:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 504:  modeltype_where ::= where expression_block
            //
            case 504: {
                
				BlockExpCS blockExpCS = (BlockExpCS) dtParser.getSym(2);
				dtParser.setSym1(blockExpCS.getBodyExpressions());
	          break;
            }
	 
            //
            // Rule 505:  packageref_list ::= packageref
            //
            case 505: {
                
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 506:  packageref_list ::= packageref_list , packageref
            //
            case 506: {
                
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 507:  packageref_list ::= packageref_list qvtErrorToken
            //
            case 507: {
                
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 508:  packageref ::= pathNameCS
            //
            case 508: {
                
				CSTNode result = createPackageRefCS(
						(PathNameCS)dtParser.getSym(1),
						null
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 509:  packageref ::= pathNameCS ( uri )
            //
            case 509: {
                
				CSTNode result = createPackageRefCS(
						(PathNameCS)dtParser.getSym(1),
						(StringLiteralExpCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 510:  packageref ::= uri
            //
            case 510: {
                
				CSTNode result = createPackageRefCS(
						null,
						(StringLiteralExpCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 511:  compliance_kindOpt ::= $Empty
            //
            case 511:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 515:  classifierDefCS ::= intermediate class qvtIdentifierCS classifierExtensionOpt { classifierFeatureListOpt } semicolonOpt
            //
            case 515: {
                
				CSTNode result = createClassifierDefCS(
						getIToken(dtParser.getToken(3)),
						(EList) dtParser.getSym(4),
						(EList) dtParser.getSym(6)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 516:  classifierExtensionOpt ::= $Empty
            //
            case 516:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 517:  classifierExtensionOpt ::= extends type_list
            //
            case 517: {
                
				EList result = (EList)dtParser.getSym(2);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 518:  type_list ::= typeCS
            //
            case 518: {
                
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 519:  type_list ::= type_list , typeCS
            //
            case 519: {
                
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 520:  type_list ::= type_list qvtErrorToken
            //
            case 520: {
                
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 521:  classifierFeatureListOpt ::= $Empty
            //
            case 521:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 523:  classifierFeatureList ::= classifierFeatureCS
            //
            case 523: {
                
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 524:  classifierFeatureList ::= classifierFeatureList ; classifierFeatureCS
            //
            case 524: {
                
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 525:  classifierFeatureList ::= classifierFeatureList qvtErrorToken
            //
            case 525: {
                
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 526:  classifierFeatureCS ::= stereotype_qualifier_list feature_key_list qvtIdentifierCS : typeCS multiplicityOpt ordered_prop opposite_propertyOpt init_partOpt
            //
            case 526: {
                
				EList stereotypeQualifiers = (EList) dtParser.getSym(1);
				EList featureKeys = (EList) dtParser.getSym(2);
				MultiplicityDefCS multiplicityDef = (MultiplicityDefCS) dtParser.getSym(6);
				OppositePropertyCS oppositeProperty = (OppositePropertyCS) dtParser.getSym(8);
				OCLExpressionCS initExpression = (OCLExpressionCS) dtParser.getSym(9);
				CSTNode result = createClassifierPropertyCS(
						stereotypeQualifiers,
						featureKeys,
						getIToken(dtParser.getToken(3)),
						(TypeCS) dtParser.getSym(5),
						((BooleanLiteralExpCS) dtParser.getSym(7)).getBooleanSymbol().booleanValue(),
						initExpression,
						multiplicityDef,
						oppositeProperty
					);
				
				int startOffset = getIToken(dtParser.getToken(3)).getStartOffset();
				if (!featureKeys.isEmpty()) {
					startOffset = ((CSTNode) featureKeys.get(0)).getStartOffset();
				}
				if (!stereotypeQualifiers.isEmpty()) {
					startOffset = ((IToken) stereotypeQualifiers.get(0)).getStartOffset();
				}
				
				CSTNode lastToken = (CSTNode) dtParser.getSym(5);
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
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 528:  init_partOpt ::= $Empty
            //
            case 528:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 529:  init_partOpt ::= = OclExpressionCS
            //
            case 529: {
                
				CSTNode result = (CSTNode) dtParser.getSym(2);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 530:  stereotype_qualifier_list ::= $Empty
            //
            case 530:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 531:  stereotype_qualifier_list ::= STEREOTYPE_QUALIFIER_OPEN identifier_list STEREOTYPE_QUALIFIER_CLOSE
            //
            case 531: {
                
				EList result = (EList)dtParser.getSym(2);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 532:  identifier_list ::= qvtIdentifierCS
            //
            case 532: {
                
				EList result = new BasicEList();
				result.add(getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 533:  identifier_list ::= identifier_list , qvtIdentifierCS
            //
            case 533: {
                
				EList result = (EList) dtParser.getSym(1);
				result.add(getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 534:  identifier_list ::= identifier_list qvtErrorToken
            //
            case 534: {
                
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 535:  feature_key_list ::= $Empty
            //
            case 535:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 536:  feature_key_list ::= feature_key_list feature_key
            //
            case 536: {
                
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 537:  feature_key_list ::= feature_key_list qvtErrorToken
            //
            case 537: {
                
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
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
                
				CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getIToken(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 543:  multiplicityOpt ::= $Empty
            //
            case 543:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 544:  multiplicityOpt ::= LBRACKET multiplicity_range RBRACKET
            //
            case 544: {
                
				CSTNode result = (CSTNode) dtParser.getSym(2);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 545:  multiplicity_range ::= IntegerLiteralExpCS
            //
            case 545: {
                
				CSTNode result = createMultiplicityDefCS(
						(PrimitiveLiteralExpCS) dtParser.getSym(1),
						(PrimitiveLiteralExpCS) dtParser.getSym(1)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 546:  multiplicity_range ::= UnlimitedNaturalLiteralExpCS
            //
            case 546: {
                
				PrimitiveLiteralExpCS lowerBound = createIntegerLiteralExpCS(Integer.toString(0));
				setOffsets(lowerBound, getIToken(dtParser.getToken(1)));
				CSTNode result = createMultiplicityDefCS(
						lowerBound, 
						(PrimitiveLiteralExpCS) dtParser.getSym(1)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
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
                
				CSTNode result = createMultiplicityDefCS(
						(PrimitiveLiteralExpCS) dtParser.getSym(1),
						(PrimitiveLiteralExpCS) dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 551:  ordered_prop ::= ordered
            //
            case 551: {
                
				CSTNode result = createBooleanLiteralExpCS(Boolean.TRUE.toString());
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 552:  ordered_prop ::= $Empty
            //
            case 552: {
                
				CSTNode result = createBooleanLiteralExpCS(Boolean.FALSE.toString());
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 553:  opposite_propertyOpt ::= $Empty
            //
            case 553:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 554:  opposite_propertyOpt ::= opposites navigable_prop qvtIdentifierCS multiplicityOpt
            //
            case 554: {
                
				MultiplicityDefCS multiplicityDef = (MultiplicityDefCS) dtParser.getSym(4);
				CSTNode result = createOppositePropertyCS(
						getIToken(dtParser.getToken(3)),
						((BooleanLiteralExpCS) dtParser.getSym(2)).getBooleanSymbol().booleanValue(),
						multiplicityDef
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				if (multiplicityDef != null) {
					result.setEndOffset(multiplicityDef.getEndOffset());
				}
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 555:  navigable_prop ::= TILDE_SIGN
            //
            case 555: {
                
				CSTNode result = createBooleanLiteralExpCS(Boolean.FALSE.toString());
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 556:  navigable_prop ::= $Empty
            //
            case 556: {
                
				CSTNode result = createBooleanLiteralExpCS(Boolean.TRUE.toString());
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 557:  _property ::= configuration property qvtIdentifierCS : typeCS ;
            //
            case 557: {
                
				CSTNode result = createConfigPropertyCS(
						getIToken(dtParser.getToken(3)),
						(TypeCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 558:  _property ::= configuration property qvtIdentifierCS : typeCS qvtErrorToken
            //
            case 558: {
                
				CSTNode result = createConfigPropertyCS(
						getIToken(dtParser.getToken(3)),
						(TypeCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 559:  _property ::= property qvtIdentifierCS : typeCS = OclExpressionCS ;
            //
            case 559: {
                
				CSTNode result = createLocalPropertyCS(
						getIToken(dtParser.getToken(2)),
						(TypeCS)dtParser.getSym(4),
						(OCLExpressionCS)dtParser.getSym(6)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 560:  _property ::= property qvtIdentifierCS = OclExpressionCS ;
            //
            case 560: {
                
				CSTNode result = createLocalPropertyCS(
						getIToken(dtParser.getToken(2)),
						null,
						(OCLExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 561:  _property ::= intermediate property scoped_identifier : typeCS ;
            //
            case 561: {
                
				CSTNode result = createContextualPropertyCS(
						(ScopedNameCS)dtParser.getSym(3),
						(TypeCS)dtParser.getSym(5),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 562:  _property ::= intermediate property scoped_identifier : typeCS = OclExpressionCS ;
            //
            case 562: {
                
				CSTNode result = createContextualPropertyCS(
						(ScopedNameCS)dtParser.getSym(3),
						(TypeCS)dtParser.getSym(5),
						(OCLExpressionCS)dtParser.getSym(7)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(8)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 566:  helper_header ::= helper_info scoped_identifier complete_signature
            //
            case 566: {
                
				CompleteSignatureCS completeSignature = (CompleteSignatureCS)dtParser.getSym(3);
				Object[] helperInfo = (Object[])dtParser.getSym(1);
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					null,
					(ScopedNameCS)dtParser.getSym(2),
					completeSignature.getSimpleSignature().getParams(),
					completeSignature.getResultParams()
				);
				setOffsets(mappingDeclarationCS, (CSTNode)dtParser.getSym(2), (CSTNode)dtParser.getSym(3));

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>) helperInfo[0];
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				IToken helperKind = (IToken) helperInfo[1];
				mappingDeclarationCS.setIsQuery(helperKind.getKind() == QVTOParsersym.TK_query);
				mappingDeclarationCS.setStartOffset(helperKind.getStartOffset());

				dtParser.setSym1(mappingDeclarationCS);
	          break;
            }
	 
            //
            // Rule 567:  helper_header ::= helper_info qvtErrorToken
            //
            case 567: {
                
				Object[] helperInfo = (Object[])dtParser.getSym(1);
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

				dtParser.setSym1(mappingDeclarationCS);
	          break;
            }
	 
            //
            // Rule 568:  helper_info ::= qualifierList helper_kind
            //
            case 568: {
                
				dtParser.setSym1(new Object[] {dtParser.getSym(1), getIToken(dtParser.getToken(2))});
	          break;
            }
	 
            //
            // Rule 571:  helper_decl ::= helper_header ;
            //
            case 571: {
                
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)dtParser.getSym(1);
				MappingQueryCS result = createMappingQueryCS(
						false,
						mappingDecl,
						ourEmptyEList
					);
				result.setBlackBox(true);
				setOffsets(result, mappingDecl, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 572:  helper_decl ::= helper_header qvtErrorToken
            //
            case 572: {
                
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)dtParser.getSym(1);
				MappingQueryCS result = createMappingQueryCS(
						false,
						mappingDecl,
						ourEmptyEList
					);
				result.setBlackBox(true);
				setOffsets(result, mappingDecl);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 573:  helper_simple_def ::= helper_header = OclExpressionCS ;
            //
            case 573: {
                
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)dtParser.getSym(1);
				OCLExpressionCS expression = (OCLExpressionCS)dtParser.getSym(3);
				EList<OCLExpressionCS> expressionList = new BasicEList();
				expressionList.add(expression);
				MappingQueryCS result = createMappingQueryCS(
						false,
						mappingDecl,
						expressionList
					);
				result.setIsSimpleDefinition(true);
				setOffsets(result, mappingDecl, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 574:  helper_compound_def ::= helper_header expression_block semicolonOpt
            //
            case 574: {
                
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)dtParser.getSym(1);
				BlockExpCS blockExpCS = (BlockExpCS)dtParser.getSym(2);
				CSTNode result = createMappingQueryCS(
						false,
						mappingDecl,
						blockExpCS.getBodyExpressions()
					);
				setOffsets(result, mappingDecl, blockExpCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 577:  constructor_header ::= qualifierList constructor scoped_identifier simple_signature
            //
            case 577: {
                
				SimpleSignatureCS signature = (SimpleSignatureCS) dtParser.getSym(4);					
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					null,
					(ScopedNameCS) dtParser.getSym(3),
					signature.getParams(),
					null
				);
				setOffsets(mappingDeclarationCS, getIToken(dtParser.getToken(2)), signature);

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>) dtParser.getSym(1);
				if (!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				dtParser.setSym1(mappingDeclarationCS);
	          break;
            }
	 
            //
            // Rule 578:  constructor_decl ::= constructor_header ;
            //
            case 578: {
                
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS) dtParser.getSym(1);
				ConstructorCS result = createConstructorCS(
						mappingDecl,
						ourEmptyEList
					);
				result.setBlackBox(true);
				setOffsets(result, mappingDecl, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 579:  constructor_decl ::= constructor_header qvtErrorToken
            //
            case 579: {
                
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS) dtParser.getSym(1);
				ConstructorCS result = createConstructorCS(
						mappingDecl,
						ourEmptyEList
					);
				result.setBlackBox(true);
				setOffsets(result, mappingDecl);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 580:  constructor_def ::= constructor_header expression_block semicolonOpt
            //
            case 580: {
                
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS) dtParser.getSym(1);
				BlockExpCS blockExpCS = (BlockExpCS) dtParser.getSym(2);
				ConstructorCS result = createConstructorCS(
						mappingDecl,
						blockExpCS.getBodyExpressions()
					);
				setOffsets(result, mappingDecl, blockExpCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 583:  entry_header ::= main simple_signature
            //
            case 583: {
                
				IToken nameToken = getIToken(dtParser.getToken(1));				
				ScopedNameCS nameCS = createScopedNameCS(null, getTokenText(dtParser.getToken(1)));								
				nameCS.setStartOffset(nameToken.getStartOffset());
				nameCS.setEndOffset(nameToken.getEndOffset());
	
				SimpleSignatureCS signature = (SimpleSignatureCS)dtParser.getSym(2);
				CSTNode result = createMappingDeclarationCS(
						null,
						nameCS,
						signature.getParams(),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), signature);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 584:  entry_header ::= main qvtErrorToken
            //
            case 584: {
                
				CSTNode result = createMappingDeclarationCS(
						null,
						createScopedNameCS(null, getTokenText(dtParser.getToken(1))),
						ourEmptyEList,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 585:  entry_decl ::= entry_header ;
            //
            case 585: {
                
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)dtParser.getSym(1);
				MappingQueryCS result = createMappingQueryCS(
						true,
						mappingDecl,
						ourEmptyEList
					);
				result.setBlackBox(true);
				setOffsets(result, mappingDecl, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 586:  entry_def ::= entry_header expression_block semicolonOpt
            //
            case 586: {
                
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)dtParser.getSym(1);
				BlockExpCS blockExpCS = (BlockExpCS)dtParser.getSym(2);
				CSTNode result = createMappingQueryCS(
						true,
						mappingDecl,
						blockExpCS.getBodyExpressions()
					);
				setOffsets(result, mappingDecl, blockExpCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 587:  _tag ::= tag StringLiteralExpCS scoped_identifier tag_valueOpt
            //
            case 587: {
                
				OCLExpressionCS valueExpression = (OCLExpressionCS) dtParser.getSym(4);
				CSTNode result = createTagCS(
						(StringLiteralExpCS) dtParser.getSym(2),
						(ScopedNameCS) dtParser.getSym(3),
						valueExpression
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), valueExpression != null ? valueExpression : (CSTNode) dtParser.getSym(3));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 588:  tag_valueOpt ::= $Empty
            //
            case 588:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 589:  tag_valueOpt ::= = OclExpressionCS
            //
            case 589: {
                
				dtParser.setSym1(dtParser.getSym(2));
	          break;
            }
	 
            //
            // Rule 592:  mapping_decl ::= mapping_full_header ;
            //
            case 592: {
                
	                        Object[] mappingFullHeader = (Object[])dtParser.getSym(1);
				MappingRuleCS result = createMappingRuleCS(
						(MappingDeclarationCS)mappingFullHeader[0],
						(OCLExpressionCS)mappingFullHeader[1],
						null
					);
				result.setBlackBox(true);
				setOffsets(result, (MappingDeclarationCS)mappingFullHeader[0], getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 593:  mapping_def ::= mapping_full_header { mapping_body } semicolonOpt
            //
            case 593: {
                
				MappingSectionsCS mappingSections = (MappingSectionsCS)dtParser.getSym(3);
				setOffsets(mappingSections, getIToken(dtParser.getToken(2)), getIToken(dtParser.getToken(4)));

				MappingBodyCS mappingBodyCS = mappingSections.getMappingBodyCS();
				if (mappingBodyCS != null) {
					if (mappingBodyCS.getStartOffset() < 0) {
						mappingBodyCS.setStartOffset(mappingSections.getStartOffset());
					}
					if (mappingBodyCS.getEndOffset() < 0) {
						mappingBodyCS.setEndOffset(mappingSections.getEndOffset());
					}
				}

	                        Object[] mappingFullHeader = (Object[])dtParser.getSym(1);
				MappingRuleCS result = createMappingRuleCS(
						(MappingDeclarationCS)mappingFullHeader[0],
						(OCLExpressionCS)mappingFullHeader[1],
						mappingSections
					);
				result.setBlackBox(false);
				setOffsets(result, (MappingDeclarationCS)mappingFullHeader[0], getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 594:  mapping_def ::= mapping_full_header { qvtErrorToken
            //
            case 594: {
                
	                        Object[] mappingFullHeader = (Object[])dtParser.getSym(1);
				MappingRuleCS result = createMappingRuleCS(
						(MappingDeclarationCS)mappingFullHeader[0],
						null,
						null
					);
				setOffsets(result, (MappingDeclarationCS)mappingFullHeader[0], getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 595:  mapping_full_header ::= mapping_header _whenOpt
            //
            case 595: {
                
				dtParser.setSym1(new Object[] {dtParser.getSym(1), dtParser.getSym(2)});
	          break;
            }
	 
            //
            // Rule 596:  mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier complete_signature mapping_extraList
            //
            case 596: {
                
				DirectionKindCS directionKind = (DirectionKindCS)dtParser.getSym(3);
				CompleteSignatureCS completeSignature = (CompleteSignatureCS)dtParser.getSym(5);
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					directionKind,
					(ScopedNameCS)dtParser.getSym(4),
					completeSignature.getSimpleSignature().getParams(),
					completeSignature.getResultParams()
				);
				
				mappingDeclarationCS.setStartOffset(directionKind == null ? getIToken(dtParser.getToken(2)).getStartOffset() : directionKind.getStartOffset());
				mappingDeclarationCS.setEndOffset(completeSignature.getEndOffset());

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)dtParser.getSym(1);
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				mappingDeclarationCS.getMappingExtension().addAll(((EList<MappingExtensionCS>)dtParser.getSym(6)));

				dtParser.setSym1(mappingDeclarationCS);
	          break;
            }
	 
            //
            // Rule 597:  mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier qvtErrorToken
            //
            case 597: {
                
				DirectionKindCS directionKind = (DirectionKindCS)dtParser.getSym(3);
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					directionKind,
					(ScopedNameCS)dtParser.getSym(4),
					ourEmptyEList,
					ourEmptyEList
				);

				mappingDeclarationCS.setStartOffset(directionKind == null ? getIToken(dtParser.getToken(2)).getStartOffset() : directionKind.getStartOffset());
				mappingDeclarationCS.setEndOffset(((CSTNode)dtParser.getSym(4)).getEndOffset());

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)dtParser.getSym(1);
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				dtParser.setSym1(mappingDeclarationCS);
	          break;
            }
	 
            //
            // Rule 598:  mapping_header ::= qualifierList mapping qvtErrorToken
            //
            case 598: {
                
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					null,
					createScopedNameCS(null, ""), //$NON-NLS-1$
					ourEmptyEList,
					ourEmptyEList
				);
				
				setOffsets(mappingDeclarationCS, getIToken(dtParser.getToken(2)), getIToken(dtParser.getToken(2)));

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)dtParser.getSym(1);
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				dtParser.setSym1(mappingDeclarationCS);
	          break;
            }
	 
            //
            // Rule 599:  mapping_extraList ::= mapping_extraList mapping_extra
            //
            case 599: {
                
				EList<MappingExtensionCS> extensionList = (EList<MappingExtensionCS>)dtParser.getSym(1);
				extensionList.add((MappingExtensionCS)dtParser.getSym(2));
				dtParser.setSym1(extensionList);
	          break;
            }
	 
            //
            // Rule 600:  mapping_extraList ::= $Empty
            //
            case 600:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 602:  mapping_extension ::= mapping_extension_key scoped_identifier_list
            //
            case 602: {
                
				MappingExtensionCS result = createMappingExtension(getTokenText(dtParser.getToken(1)), (EList<ScopedNameCS>)dtParser.getSym(2));

				result.setStartOffset(getIToken(dtParser.getToken(1)).getStartOffset());
				result.setEndOffset(getEndOffset(getIToken(dtParser.getToken(1)), (EList<ScopedNameCS>)dtParser.getSym(2)));
			
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 607:  _whenOpt ::= $Empty
            //
            case 607:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 608:  _when ::= when { OclExpressionCS semicolonOpt }
            //
            case 608: {
                
				OCLExpressionCS result = (OCLExpressionCS)dtParser.getSym(3);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 609:  _when ::= when qvtErrorToken
            //
            case 609:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 610:  mapping_body ::= init_sectionOpt population_sectionOpt end_sectionOpt
            //
            case 610: {
                
	                        MappingInitCS mappingInitCS = (MappingInitCS)dtParser.getSym(1);
				MappingBodyCS mappingBodyCS = (MappingBodyCS)dtParser.getSym(2);
				MappingEndCS mappingEndCS = (MappingEndCS)dtParser.getSym(3);

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
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 611:  init_sectionOpt ::= $Empty
            //
            case 611:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 613:  init_section ::= init expression_block
            //
            case 613: {
                
				BlockExpCS blockExpCS = (BlockExpCS) dtParser.getSym(2);
				CSTNode result = createMappingInitCS(
						blockExpCS.getBodyExpressions(),
						blockExpCS.getStartOffset(),
						blockExpCS.getEndOffset()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), blockExpCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 614:  init_section ::= init qvtErrorToken
            //
            case 614: {
                
				CSTNode result = createMappingInitCS(
						ourEmptyEList,
						getIToken(dtParser.getToken(1)).getEndOffset(),
						getIToken(dtParser.getToken(1)).getStartOffset()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 615:  population_sectionOpt ::= $Empty
            //
            case 615: {
                
				MappingBodyCS result = createMappingBodyCS(
						ourEmptyEList,
						false
					);
				// offsets will be updated further in parent non-terminals
				result.setStartOffset(-1); 
				result.setEndOffset(-1);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 617:  population_section ::= expression_list
            //
            case 617: {
                
				EList<OCLExpressionCS> expressionList = (EList<OCLExpressionCS>) dtParser.getSym(1);
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
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 618:  population_section ::= population expression_block
            //
            case 618: {
                
				BlockExpCS blockExpCS = (BlockExpCS) dtParser.getSym(2);
				MappingBodyCS result = createMappingBodyCS(
						blockExpCS.getBodyExpressions(),
						true
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), blockExpCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 619:  population_section ::= population qvtErrorToken
            //
            case 619: {
                
				CSTNode result = createMappingBodyCS(
						ourEmptyEList,
						true
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 620:  end_sectionOpt ::= $Empty
            //
            case 620:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 622:  end_section ::= end expression_block
            //
            case 622: {
                
				BlockExpCS blockExpCS = (BlockExpCS) dtParser.getSym(2);
				CSTNode result = createMappingEndCS(
						blockExpCS.getBodyExpressions(),
						blockExpCS.getStartOffset(),
						blockExpCS.getEndOffset()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), blockExpCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 623:  end_section ::= end qvtErrorToken
            //
            case 623: {
                
				CSTNode result = createMappingEndCS(
						ourEmptyEList,
						getIToken(dtParser.getToken(1)).getEndOffset(),
						getIToken(dtParser.getToken(1)).getStartOffset()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 624:  typespecOpt ::= $Empty
            //
            case 624:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 626:  objectDeclCS ::= typespec
            //
            case 626: {
                
				CSTNode result = createOutExpCS(null, (TypeSpecCS)dtParser.getSym(1));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 630:  objectDeclCS ::= objectIdentifierCS : typespecOpt
            //
            case 630: {
                
			SimpleNameCS varName = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getIToken(dtParser.getToken(1)));
			setOffsets(varName, getIToken(dtParser.getToken(1)));
			CSTNode result = createOutExpCS(varName,(TypeSpecCS)dtParser.getSym(3));					
			dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 631:  outExpCS ::= object objectDeclCS expression_block
            //
            case 631: {
                
				BlockExpCS blockExpCS = (BlockExpCS) dtParser.getSym(3);
				CSTNode result = setupOutExpCS(
						(ObjectExpCS) dtParser.getSym(2),					
						blockExpCS.getBodyExpressions(),
						// passing body positions
						blockExpCS.getStartOffset(),
						blockExpCS.getEndOffset()
					); 
				setOffsets(result, getIToken(dtParser.getToken(1)), blockExpCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 632:  outExpCS ::= object objectDeclCS qvtErrorToken
            //
            case 632: {
                
				ObjectExpCS objectDeclCS = ((ObjectExpCS) dtParser.getSym(2));  
				CSTNode result = createOutExpCS(
						objectDeclCS.getSimpleNameCS(),						
						objectDeclCS.getTypeSpecCS()
					);
				if (objectDeclCS  == null) {
				    setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				} else {
				    setOffsets(result, getIToken(dtParser.getToken(1)), objectDeclCS);
				}
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 633:  featureMappingCallExpCS ::= map simpleNameCS ( argumentsCSopt )
            //
            case 633: {
                
				CSTNode result = createFeatureMappingCallExpCS(
						null,
						(SimpleNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4),
						false
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 634:  featureMappingCallExpCS ::= xmap simpleNameCS ( argumentsCSopt )
            //
            case 634: {
                
				CSTNode result = createFeatureMappingCallExpCS(
						null,
						(SimpleNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4),
						true
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 635:  featureMappingCallExpCS ::= map simpleNameCS :: simpleNameCS ( argumentsCSopt )
            //
            case 635: {
                
				CSTNode result = createFeatureMappingCallExpCS(
						(SimpleNameCS)dtParser.getSym(2),
						(SimpleNameCS)dtParser.getSym(4),
						(EList)dtParser.getSym(6),
						false
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 636:  featureMappingCallExpCS ::= xmap simpleNameCS :: simpleNameCS ( argumentsCSopt )
            //
            case 636: {
                
				CSTNode result = createFeatureMappingCallExpCS(
						(SimpleNameCS)dtParser.getSym(2),
						(SimpleNameCS)dtParser.getSym(4),
						(EList)dtParser.getSym(6),
						true
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 637:  mappingCallExpCS ::= map pathNameCS ( argumentsCSopt )
            //
            case 637: {
                
				CSTNode result = createMappingCallExpCS(
						(PathNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4),
						false
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 638:  mappingCallExpCS ::= xmap pathNameCS ( argumentsCSopt )
            //
            case 638: {
                
				CSTNode result = createMappingCallExpCS(
						(PathNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4),
						true
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 639:  resolveConditionOpt ::= $Empty
            //
            case 639:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 640:  resolveConditionOpt ::= | OclExpressionCS
            //
            case 640: {
                
                dtParser.setSym1((OCLExpressionCS)dtParser.getSym(2));
              break;
            }
     
            //
            // Rule 641:  resolveConditionOpt ::= | qvtErrorToken
            //
            case 641:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 642:  IDENTIFIEROpt ::= $Empty
            //
            case 642:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 643:  IDENTIFIEROpt ::= IDENTIFIER :
            //
            case 643: {
                
                dtParser.setSym1(getIToken(dtParser.getToken(1)));
              break;
            }
     
            //
            // Rule 644:  resolveOpArgsExpCSOpt ::= $Empty
            //
            case 644:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 646:  resolveOpArgsExpCS ::= IDENTIFIEROpt typeCS resolveConditionOpt
            //
            case 646: {
                
                CSTNode result = createResolveOpArgsExpCS(
                        getIToken(dtParser.getToken(1)),      // target_type_variable?
                        (TypeCS)dtParser.getSym(2),           // type?
                        (OCLExpressionCS)dtParser.getSym(3)); // condition?
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
                    dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 651:  lateOpt ::= $Empty
            //
            case 651:
                dtParser.setSym1(null);
                break;
 
            //
            // Rule 653:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCSOpt )
            //
            case 653: {
                
                CSTNode result = createResolveExpCS(
                            getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                            (ResolveOpArgsExpCS)dtParser.getSym(4));
                            setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
                    dtParser.setSym1(result);
                  break;
            }
         
            //
            // Rule 654:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCSOpt qvtErrorToken
            //
            case 654: {
                
                CSTNode result = createResolveExpCS(
                            getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        (ResolveOpArgsExpCS)dtParser.getSym(4));
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 655:  resolveExpCS ::= lateOpt resolveOp qvtErrorToken
            //
            case 655: {
                
                CSTNode result = createResolveExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        null);
                            setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 656:  resolveExpCS ::= late qvtErrorToken
            //
            case 656: {
                
    			IToken lateToken = getIToken(dtParser.getToken(1));
                CSTNode result = createResolveExpCS(
                        lateToken,
                        new Token(lateToken.getEndOffset(), lateToken.getEndOffset(), QVTOParsersym.TK_resolve),
                        null);
                            setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 661:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier , resolveOpArgsExpCS )
            //
            case 661: {
                
                CSTNode result = createResolveInExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        (ScopedNameCS)dtParser.getSym(4),
                        (ResolveOpArgsExpCS)dtParser.getSym(6));
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
                dtParser.setSym1(result);
                  break;
            }
         
            //
            // Rule 662:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier )
            //
            case 662: {
                
                CSTNode result = createResolveInExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        (ScopedNameCS)dtParser.getSym(4),
                        null);
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 663:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier , resolveOpArgsExpCSOpt qvtErrorToken
            //
            case 663: {
                
                CSTNode result = createResolveInExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        (ScopedNameCS)dtParser.getSym(4),
                        (ResolveOpArgsExpCS)dtParser.getSym(6));
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 664:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier qvtErrorToken
            //
            case 664: {
                
                CSTNode result = createResolveInExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        (ScopedNameCS)dtParser.getSym(4),
                        null);
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 665:  resolveInExpCS ::= lateOpt resolveInOp ( qvtErrorToken
            //
            case 665: {
                
                    CSTNode result = createResolveInExpCS(
                            getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
							createScopedNameCS(null, ""), //$NON-NLS-1$
                        null);
                            setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
                dtParser.setSym1(result);
              break;
            }
         
            //
            // Rule 666:  resolveInExpCS ::= lateOpt resolveInOp qvtErrorToken
            //
            case 666: {
                
                CSTNode result = createResolveInExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
							createScopedNameCS(null, ""), //$NON-NLS-1$
                        null);
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 669:  OperationCallExpCS ::= primaryExpCS -> resolveResolveInExpCS
            //
            case 669: {
                
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CallExpCS result = (CallExpCS)dtParser.getSym(3);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				result.setSource(source);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 670:  OperationCallExpCS ::= primaryExpCS . resolveResolveInExpCS
            //
            case 670: {
                
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CallExpCS result = (CallExpCS)dtParser.getSym(3);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				result.setSource(source);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 672:  OperationCallExpCS ::= primaryExpCS -> featureMappingCallExpCS
            //
            case 672: {
                
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CallExpCS result = (CallExpCS)dtParser.getSym(3);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				result.setSource(source);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 673:  OperationCallExpCS ::= primaryExpCS . featureMappingCallExpCS
            //
            case 673: {
                
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CallExpCS result = (CallExpCS)dtParser.getSym(3);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				result.setSource(source);
				dtParser.setSym1(result);
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
                
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getIToken(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 678:  _import ::= import library unit ;
            //
            case 678: {
                
				CSTNode result = createLibraryImportCS(
						(PathNameCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 679:  transformation_h ::= qualifierList transformation qualifiedNameCS
            //
            case 679: {
                
				EList qualifierList = (EList) dtParser.getSym(1);
				CSTNode result = createTransformationHeaderCS(
						qualifierList,
						(PathNameCS)dtParser.getSym(3),
						createSimpleSignatureCS(ourEmptyEList),
						ourEmptyEList,
						null
					);
				if (qualifierList.isEmpty()) {
					setOffsets(result, getIToken(dtParser.getToken(2)), (PathNameCS)dtParser.getSym(3));
				} else {
					setOffsets(result, (CSTNode) qualifierList.get(0), (PathNameCS)dtParser.getSym(3));
				}
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 681:  renaming ::= rename typeCS . qvtIdentifierCS = StringLiteralExpCS ;
            //
            case 681: {
                
				CSTNode result = createRenameCS(
						(TypeCS)dtParser.getSym(2),
						getIToken(dtParser.getToken(4)),
						(StringLiteralExpCS)dtParser.getSym(6)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	          break;
            }
	
    
            default:
                break;
        }
        return;
    }
}

