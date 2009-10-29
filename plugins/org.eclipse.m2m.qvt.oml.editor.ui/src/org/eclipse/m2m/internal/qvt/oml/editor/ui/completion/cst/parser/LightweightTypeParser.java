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
* $Id: LightweightTypeParser.java,v 1.66.4.4 2009/10/29 21:37:15 sboyko Exp $
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
* $Id: LightweightTypeParser.java,v 1.66.4.4 2009/10/29 21:37:15 sboyko Exp $
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
* $Id: LightweightTypeParser.java,v 1.66.4.4 2009/10/29 21:37:15 sboyko Exp $
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
* $Id: LightweightTypeParser.java,v 1.66.4.4 2009/10/29 21:37:15 sboyko Exp $
*/

package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.cst.parser;

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

import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLPGParserprs;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLPGParsersym;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLexer;	
import org.eclipse.m2m.internal.qvt.oml.cst.parser.AbstractQVTParser;	

	public class LightweightTypeParser extends AbstractQVTParser implements RuleAction {
	protected static ParseTable prs = new LightweightTypeParserprs();
	private BacktrackingParser dtParser;
	// (to be uncommented for use in DEBUG mode)
	//private static Map<Integer, String> ruleTexts;

	public LightweightTypeParser(QvtOpLexer lexer) {
		super(lexer);

		try {
			super.remapTerminalSymbols(orderedTerminalSymbols(), LightweightTypeParserprs.EOFT_SYMBOL);
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
				error += "\t" + LightweightTypeParsersym.orderedTerminalSymbols[id.intValue()]; //$NON-NLS-1$			   
			}
			throw new RuntimeException(error + "\n"); //$NON-NLS-1$
		}
		catch(UndefinedEofSymbolException e) {
			throw new RuntimeException("The Lexer does not implement the Eof symbol " + //$NON-NLS-1$
				 LightweightTypeParsersym.orderedTerminalSymbols[LightweightTypeParserprs.EOFT_SYMBOL]);
		} 
	}
	 
	@Override
	public String[] orderedTerminalSymbols() { return LightweightTypeParsersym.orderedTerminalSymbols; }
	@Override		
	public String getTokenKindName(int kind) { return LightweightTypeParsersym.orderedTerminalSymbols[kind]; }			
	public int getEOFTokenKind() { return LightweightTypeParserprs.EOFT_SYMBOL; }
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
		ParseTable prsTable = new LightweightTypeParserprs();

		try {
			dtParser = new BacktrackingParser(monitor, this, prsTable, this);
		}
		catch (NotBacktrackParseTableException e) {
			throw new RuntimeException("****Error: Regenerate LightweightTypeParserprs.java with -NOBACKTRACK option"); //$NON-NLS-1$
		}
		catch (BadParseSymFileException e) {
			throw new RuntimeException("****Error: Bad Parser Symbol File -- LightweightTypeParsersym.java. Regenerate LightweightTypeParserprs.java"); //$NON-NLS-1$
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
            makeToken(lastT.getEndOffset() + i + someHugeOffset, lastT.getEndOffset() + i + someHugeOffset + 1, LightweightTypeParsersym.TK_EOF_TOKEN);
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
			// Rule 37:  binaryKeywordCS ::= binaryKeyword
			//
			case 37:
 
			//
			// Rule 38:  otherKeywordCS ::= otherKeyword
			//
			case 38:
 
			//
			// Rule 39:  unaryKeywordCS ::= unaryKeyword
			//
			case 39:
 
			//
			// Rule 40:  reservedPunctuationCS ::= reservedPunctuation
			//
			case 40: {
				
				SimpleNameCS result = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 44:  iterateNameCS ::= iterateIdentifier
			//
			case 44:
 
			//
			// Rule 45:  iteratorNameCS ::= iteratorIdentifier
			//
			case 45:
 
			//
			// Rule 46:  simpleIdentifierCS ::= otherIdentifier
			//
			case 46: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 48:  simpleIdentifierCS ::= self
			//
			case 48: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.SELF_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 61:  pathNameCS ::= notReservedSimpleNameCS
			//
			case 61: {
				
				SimpleNameCS simpleName = (SimpleNameCS)dtParser.getSym(1);
				PathNameCS result = createPathNameCS(simpleName);
				setOffsets(result, simpleName);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 63:  qualifiedPathNameCS ::= pathNameCS :: notReservedSimpleNameCS
			//
			case 63: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				SimpleNameCS simpleName = (SimpleNameCS)dtParser.getSym(3);
				result = extendPathNameCS(result, simpleName);
				setOffsets(result, result, simpleName);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 64:  primitiveTypeCS ::= Boolean
			//
			case 64: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.BOOLEAN_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 65:  primitiveTypeCS ::= Integer
			//
			case 65: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INTEGER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 66:  primitiveTypeCS ::= Real
			//
			case 66: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.REAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 67:  primitiveTypeCS ::= String
			//
			case 67: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.STRING_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 68:  primitiveTypeCS ::= UnlimitedNatural
			//
			case 68: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 69:  primitiveTypeCS ::= OclAny
			//
			case 69: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_ANY_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 70:  primitiveTypeCS ::= OclInvalid
			//
			case 70: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_INVALID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 71:  primitiveTypeCS ::= OclVoid
			//
			case 71: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_VOID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 72:  CollectionTypeIdentifierCS ::= Bag
			//
			case 72: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.BAG_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 73:  CollectionTypeIdentifierCS ::= Collection
			//
			case 73: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.COLLECTION_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 74:  CollectionTypeIdentifierCS ::= OrderedSet
			//
			case 74: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 75:  CollectionTypeIdentifierCS ::= Sequence
			//
			case 75: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.SEQUENCE_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 76:  CollectionTypeIdentifierCS ::= Set
			//
			case 76: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.SET_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 77:  collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS )
			//
			case 77: {
				
				CollectionTypeCS result = (CollectionTypeCS)dtParser.getSym(1);
				result.setTypeCS((TypeCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 78:  tupleTypeCS ::= Tuple ( variableDeclarationListCSopt )
			//
			case 78: {
				
				CSTNode result = createTupleTypeCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 79:  typeCS ::= notReservedSimpleNameCS
			//
			case 79: {
				
				CSTNode result = (CSTNode)dtParser.getSym(1);
				if (!(result instanceof TypeCS)) {
					PathNameCS pathNameCS = createPathNameCS((SimpleNameCS)result);
					setOffsets(pathNameCS, result);
					result = pathNameCS;
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 87:  typedVariableCS ::= BooleanLiteralExpCS : typeCS
			//
			case 87:
 
			//
			// Rule 88:  typedVariableCS ::= InvalidLiteralExpCS : typeCS
			//
			case 88:
 
			//
			// Rule 89:  typedVariableCS ::= NullLiteralExpCS : typeCS
			//
			case 89:
 
			//
			// Rule 90:  typedVariableCS ::= notLiteralNorReservedSimpleNameCS : typeCS
			//
			case 90: {
				
				SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
				TypeCS type = (TypeCS)dtParser.getSym(3);
				VariableCS result = createVariableCS(name, type, null);
				setOffsets(result, name, type);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 91:  VariableDeclarationCS ::= variableNameCS
			//
			case 91: {
				
				SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createVariableCS(name, null, null);
				setOffsets(result, name);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 93:  VariableDeclarationCS ::= typedVariableCS = OclExpressionCS
			//
			case 93: {
				
				VariableCS result = (VariableCS)dtParser.getSym(1);
				OCLExpressionCS initExpression = (OCLExpressionCS)dtParser.getSym(3);
				result.setInitExpression(initExpression);
				setOffsets(result, result, initExpression);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 94:  variableDeclarationListCS ::= VariableDeclarationCS
			//
			case 94: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 95:  variableDeclarationListCS ::= variableDeclarationListCS , VariableDeclarationCS
			//
			case 95: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 96:  variableDeclarationListCSopt ::= $Empty
			//
			case 96:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 98:  BooleanLiteralExpCS ::= false
			//
			case 98: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 99:  BooleanLiteralExpCS ::= true
			//
			case 99: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 100:  IntegerLiteralExpCS ::= INTEGER_LITERAL
			//
			case 100: {
				
				CSTNode result = createIntegerLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 101:  InvalidLiteralExpCS ::= invalid
			//
			case 101: {
				
				CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 102:  NullLiteralExpCS ::= null
			//
			case 102: {
				
				CSTNode result = createNullLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 103:  RealLiteralExpCS ::= REAL_LITERAL
			//
			case 103: {
				
				CSTNode result = createRealLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 104:  StringLiteralExpCS ::= STRING_LITERAL
			//
			case 104: {
				
				IToken literalToken = getIToken(dtParser.getToken(1));
				StringLiteralExpCS result = createStringLiteralExpCS(literalToken.toString());
				result.setUnescapedStringSymbol(unescape(literalToken));
				setOffsets(result, literalToken);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 105:  UnlimitedNaturalLiteralExpCS ::= *
			//
			case 105: {
				
				CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 111:  CollectionLiteralExpCS ::= CollectionTypeIdentifierCS { CollectionLiteralPartsCSopt }
			//
			case 111: {
				
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
			// Rule 112:  CollectionRangeCS ::= OclExpressionCS .. OclExpressionCS
			//
			case 112: {
				
				CSTNode result = createCollectionRangeCS(
						(OCLExpressionCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 114:  CollectionLiteralPartCS ::= OclExpressionCS
			//
			case 114: {
				
				CSTNode result = createCollectionLiteralPartCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 115:  CollectionLiteralPartsCS ::= CollectionLiteralPartCS
			//
			case 115: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 116:  CollectionLiteralPartsCS ::= CollectionLiteralPartsCS , CollectionLiteralPartCS
			//
			case 116: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 117:  CollectionLiteralPartsCSopt ::= $Empty
			//
			case 117:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 119:  TupleLiteralExpCS ::= Tuple { TupleLiteralPartsCS }
			//
			case 119: {
				
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 120:  TupleLiteralPartCS ::= variableNameCS = OclExpressionCS
			//
			case 120: {
				
				SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
				OCLExpressionCS initExpression = (OCLExpressionCS)dtParser.getSym(3);
				VariableCS result = createVariableCS(name, null, initExpression);
				setOffsets(result, name, initExpression);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 121:  TupleLiteralPartCS ::= typedVariableCS = OclExpressionCS
			//
			case 121: {
				
				VariableCS result = (VariableCS)dtParser.getSym(1);
				OCLExpressionCS initExpression = (OCLExpressionCS)dtParser.getSym(3);
				result.setInitExpression(initExpression);
				setOffsets(result, result, initExpression);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 122:  TupleLiteralPartsCS ::= TupleLiteralPartCS
			//
			case 122: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 123:  TupleLiteralPartsCS ::= TupleLiteralPartsCS , TupleLiteralPartCS
			//
			case 123: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 129:  OperationCallExpCS ::= primaryExpCS -> notIteratorNorReservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 129: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CSTNode result = createArrowOperationCallExpCS(
						source,
						(SimpleNameCS)dtParser.getSym(3),
						(IsMarkedPreCS)dtParser.getSym(4),
						(EList)dtParser.getSym(6)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 130:  OperationCallExpCS ::= primaryExpCS . binaryKeywordCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 130:
 
			//
			// Rule 131:  OperationCallExpCS ::= primaryExpCS . unaryKeywordCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 131:
 
			//
			// Rule 132:  OperationCallExpCS ::= primaryExpCS . reservedPunctuationCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 132:
 
			//
			// Rule 133:  OperationCallExpCS ::= primaryExpCS . notReservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 133: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CSTNode result = createDotOperationCallExpCS(
						source,
						null,
						(SimpleNameCS)dtParser.getSym(3),
						(IsMarkedPreCS)dtParser.getSym(4),
						(EList)dtParser.getSym(6)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 134:  OperationCallExpCS ::= literalSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 134:
 
			//
			// Rule 135:  OperationCallExpCS ::= notLiteralNorReservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 135: {
				
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
			// Rule 136:  OperationCallExpCS ::= qualifiedPathNameCS ( argumentsCSopt )
			//
			case 136: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
				OperationCallExpCS result = createDotOperationCallExpCS(
						null,
						pathNameCS,
						simpleNameCS,
						null,
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, pathNameCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 137:  OperationCallExpCS ::= primaryExpCS . qualifiedPathNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 137: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(3);
				SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CallExpCS result = createDotOperationCallExpCS(
						source,
						pathNameCS,
						simpleNameCS,
						(IsMarkedPreCS)dtParser.getSym(4),
						(EList)dtParser.getSym(6)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 138:  argumentsCS ::= OclExpressionCS
			//
			case 138: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 139:  argumentsCS ::= argumentsCS , OclExpressionCS
			//
			case 139: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 140:  argumentsCSopt ::= $Empty
			//
			case 140:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 142:  isMarkedPreCSopt ::= $Empty
			//
			case 142: {
				
				dtParser.setSym1(null);
	  		  break;
			}
	 
			//
			// Rule 143:  PropertyCallExpCS ::= primaryExpCS . notReservedSimpleNameCS isMarkedPreCSopt
			//
			case 143: {
				
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
			// Rule 144:  PropertyCallExpCS ::= primaryExpCS . qualifiedPathNameCS isMarkedPreCSopt
			//
			case 144: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(3);
				SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(4);
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
			// Rule 145:  PropertyCallExpCS ::= qualifiedPathNameCS isMarkedPreCSopt
			//
			case 145: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
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
			// Rule 146:  AssociationClassCallExpCS ::= notLiteralNorReservedSimpleNameCS isMarkedPreCSopt
			//
			case 146: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS != null) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 150:  IterateExpCS ::= primaryExpCS -> iterateNameCS ( VariableDeclarationCS | OclExpressionCS )
			//
			case 150: {
				
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
			// Rule 151:  IterateExpCS ::= primaryExpCS -> iterateNameCS ( VariableDeclarationCS ; VariableDeclarationCS | OclExpressionCS )
			//
			case 151: {
				
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
			// Rule 152:  IteratorExpCS ::= primaryExpCS -> iteratorNameCS ( OclExpressionCS )
			//
			case 152: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				CSTNode result = createIteratorExpCS(
						source,
						simpleNameCS,
						null,
						null,
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 153:  IteratorExpCS ::= primaryExpCS -> iteratorNameCS ( VariableDeclarationCS | OclExpressionCS )
			//
			case 153: {
				
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
			// Rule 154:  IteratorExpCS ::= primaryExpCS -> iteratorNameCS ( VariableDeclarationCS , VariableDeclarationCS | OclExpressionCS )
			//
			case 154: {
				
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
			// Rule 159:  LetExpCS ::= let variableDeclarationListCS in OclExpressionCS
			//
			case 159: {
				
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
			// Rule 164:  impliesExpCS ::= impliesExpCS implies xorExpCS
			//
			case 164:
 
			//
			// Rule 165:  impliesLetCS ::= impliesExpCS implies xorLetCS
			//
			case 165:
 
			//
			// Rule 168:  xorExpCS ::= xorExpCS xor orExpCS
			//
			case 168:
 
			//
			// Rule 169:  xorLetCS ::= xorExpCS xor orLetCS
			//
			case 169:
 
			//
			// Rule 172:  orExpCS ::= orExpCS or andExpCS
			//
			case 172:
 
			//
			// Rule 173:  orLetCS ::= orExpCS or andLetCS
			//
			case 173:
 
			//
			// Rule 176:  andExpCS ::= andExpCS and equalityExpCS
			//
			case 176:
 
			//
			// Rule 177:  andLetCS ::= andExpCS and equalityLetCS
			//
			case 177:
 
			//
			// Rule 180:  equalityExpCS ::= equalityExpCS = relationalExpCS
			//
			case 180:
 
			//
			// Rule 181:  equalityLetCS ::= equalityExpCS = relationalLetCS
			//
			case 181:
 
			//
			// Rule 182:  equalityExpCS ::= equalityExpCS <> relationalExpCS
			//
			case 182:
 
			//
			// Rule 183:  equalityLetCS ::= equalityExpCS <> relationalLetCS
			//
			case 183:
 
			//
			// Rule 186:  relationalExpCS ::= relationalExpCS > additiveExpCS
			//
			case 186:
 
			//
			// Rule 187:  relationalLetCS ::= relationalExpCS > additiveLetCS
			//
			case 187:
 
			//
			// Rule 188:  relationalExpCS ::= relationalExpCS < additiveExpCS
			//
			case 188:
 
			//
			// Rule 189:  relationalLetCS ::= relationalExpCS < additiveLetCS
			//
			case 189:
 
			//
			// Rule 190:  relationalExpCS ::= relationalExpCS >= additiveExpCS
			//
			case 190:
 
			//
			// Rule 191:  relationalLetCS ::= relationalExpCS >= additiveLetCS
			//
			case 191:
 
			//
			// Rule 192:  relationalExpCS ::= relationalExpCS <= additiveExpCS
			//
			case 192:
 
			//
			// Rule 193:  relationalLetCS ::= relationalExpCS <= additiveLetCS
			//
			case 193:
 
			//
			// Rule 196:  additiveExpCS ::= additiveExpCS + multiplicativeExpCS
			//
			case 196:
 
			//
			// Rule 197:  additiveLetCS ::= additiveExpCS + multiplicativeLetCS
			//
			case 197:
 
			//
			// Rule 198:  additiveExpCS ::= additiveExpCS - multiplicativeExpCS
			//
			case 198:
 
			//
			// Rule 199:  additiveLetCS ::= additiveExpCS - multiplicativeLetCS
			//
			case 199:
 
			//
			// Rule 202:  multiplicativeExpCS ::= multiplicativeExpCS * unaryExpCS
			//
			case 202:
 
			//
			// Rule 203:  multiplicativeLetCS ::= multiplicativeExpCS * unaryLetCS
			//
			case 203:
 
			//
			// Rule 204:  multiplicativeExpCS ::= multiplicativeExpCS / unaryExpCS
			//
			case 204:
 
			//
			// Rule 205:  multiplicativeLetCS ::= multiplicativeExpCS / unaryLetCS
			//
			case 205: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							getTokenText(dtParser.getToken(2))
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
			// Rule 208:  unaryExpCS ::= - unaryExpCS
			//
			case 208:
 
			//
			// Rule 209:  unaryLetCS ::= - unaryLetCS
			//
			case 209:
 
			//
			// Rule 210:  unaryExpCS ::= not unaryExpCS
			//
			case 210:
 
			//
			// Rule 211:  unaryLetCS ::= not unaryLetCS
			//
			case 211: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							getTokenText(dtParser.getToken(1))
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
			// Rule 215:  primaryExpCS ::= ( OclExpressionCS )
			//
			case 215: {
				
				CSTNode result = (CSTNode)dtParser.getSym(2);
				if (result instanceof OperationCallExpCS) {
					((OperationCallExpCS)result).setIsAtomic(true);
				}
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 218:  qualifierList ::= $Empty
			//
			case 218:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 219:  qualifierList ::= qualifierList qualifier
			//
			case 219: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 220:  qualifier ::= blackbox
			//
			case 220:
 
			//
			// Rule 221:  qualifier ::= abstract
			//
			case 221:
 
			//
			// Rule 222:  qualifier ::= static
			//
			case 222: {
				
				CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 223:  colon_param_listOpt ::= $Empty
			//
			case 223:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 224:  colon_param_listOpt ::= : param_list
			//
			case 224: {
				
				dtParser.setSym1(dtParser.getSym(2));
	  		  break;
			}
	 
			//
			// Rule 225:  complete_signature ::= simple_signature colon_param_listOpt
			//
			case 225: {
				
				SimpleSignatureCS simpleSignatureCS = (SimpleSignatureCS)dtParser.getSym(1);
				EList<ParameterDeclarationCS> resultList = (EList<ParameterDeclarationCS>)dtParser.getSym(2);
				CSTNode result = createCompleteSignatureCS(simpleSignatureCS, resultList);
				result.setStartOffset(simpleSignatureCS.getStartOffset());
				result.setEndOffset(getEndOffset(simpleSignatureCS.getEndOffset(), resultList));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 226:  simple_signatureOpt ::= $Empty
			//
			case 226:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 228:  simple_signature ::= ( param_listOpt )
			//
			case 228: {
				
				CSTNode result = createSimpleSignatureCS((EList<ParameterDeclarationCS>)dtParser.getSym(2));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 229:  param_listOpt ::= $Empty
			//
			case 229:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 231:  param_list ::= param_list , param
			//
			case 231: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 232:  param_list ::= param_list , qvtErrorToken
			//
			case 232: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 233:  param_list ::= param
			//
			case 233: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 234:  param_list ::= qvtErrorToken
			//
			case 234: {
				
				EList result = new BasicEList();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 235:  param ::= param_directionOpt IDENTIFIER : typespec
			//
			case 235: {
				
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
			// Rule 236:  param ::= param_directionOpt typespec
			//
			case 236: {
				
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
			// Rule 237:  param_directionOpt ::= $Empty
			//
			case 237:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 239:  param_direction ::= in
			//
			case 239: {
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.IN
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 240:  param_direction ::= out
			//
			case 240: {
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.OUT
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 241:  param_direction ::= inout
			//
			case 241: {
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.INOUT
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 244:  declarator1 ::= IDENTIFIER : typeCS
			//
			case 244: {
				
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						(TypeCS)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 245:  declarator1 ::= IDENTIFIER : typeCS = OclExpressionCS
			//
			case 245: {
				
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						(TypeCS)dtParser.getSym(3),
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(5));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 246:  declarator1 ::= IDENTIFIER : typeCS := OclExpressionCS
			//
			case 246: {
				
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						(TypeCS)dtParser.getSym(3),
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(5));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 247:  declarator2 ::= IDENTIFIER := OclExpressionCS
			//
			case 247: {
				
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						null,
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 248:  typespec ::= typeCS
			//
			case 248: {
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)dtParser.getSym(1),
					null
					);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 249:  typespec ::= typeCS @ IDENTIFIER
			//
			case 249: {
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)dtParser.getSym(1),
					getIToken(dtParser.getToken(3))
					);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 253:  scoped_identifier ::= typeCS2 :: IDENTIFIER
			//
			case 253: {
				
				ScopedNameCS result = createScopedNameCS((TypeCS)dtParser.getSym(1), getTokenText(dtParser.getToken(3)));		
				setOffsets(result, (CSTNode) dtParser.getSym(1), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 254:  scoped_identifier ::= typeCS2 :: qvtErrorToken
			//
			case 254: {
				
				ScopedNameCS result = createScopedNameCS((TypeCS)dtParser.getSym(1), ""); //$NON-NLS-1$		
				setOffsets(result, (CSTNode) dtParser.getSym(1), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 255:  scoped_identifier ::= scoped_identifier2
			//
			case 255: {
				
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
			// Rule 256:  scoped_identifier2 ::= IDENTIFIER
			//
			case 256: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 257:  scoped_identifier2 ::= main
			//
			case 257: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 258:  scoped_identifier2 ::= scoped_identifier2 :: IDENTIFIER
			//
			case 258: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 259:  scoped_identifier2 ::= scoped_identifier2 :: qvtErrorToken
			//
			case 259: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, ""); //$NON-NLS-1$
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 260:  scoped_identifier_list ::= scoped_identifier
			//
			case 260: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 261:  scoped_identifier_list ::= scoped_identifier_list , scoped_identifier
			//
			case 261: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 262:  scoped_identifier_list ::= scoped_identifier_list qvtErrorToken
			//
			case 262: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 265:  expression_listOpt ::= $Empty
			//
			case 265:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 269:  expression_semi_list ::= expression_semi_list_element
			//
			case 269: {
				
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
			// Rule 270:  expression_semi_list ::= expression_semi_list ; expression_semi_list_element
			//
			case 270: {
				
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
			// Rule 271:  expression_semi_list ::= expression_semi_list qvtErrorToken
			//
			case 271: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 272:  expression_block ::= { expression_listOpt }
			//
			case 272: {
				
			EList bodyList = (EList) dtParser.getSym(2);
			CSTNode result = createBlockExpCS(
				bodyList
			);
			
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
			dtParser.setSym1(result);
          		  break;
			}
	 
			//
			// Rule 273:  expression_block ::= { qvtErrorToken
			//
			case 273: {
				
			CSTNode result = createBlockExpCS(
				ourEmptyEList
			);
			
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
          		  break;
			}
	 
			//
			// Rule 276:  qualifiedNameCS ::= qvtIdentifierCS
			//
			case 276: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 277:  qualifiedNameCS ::= qualifiedNameCS . qvtIdentifierCS
			//
			case 277: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 278:  qualifiedNameCS ::= qualifiedNameCS . qvtErrorToken
			//
			case 278: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, ""); //$NON-NLS-1$
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 279:  qualifiedNameCS ::= qualifiedNameCS qvtErrorToken
			//
			case 279: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}	
	 
			//
			// Rule 281:  oclExpressionCSOpt ::= $Empty
			//
			case 281:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 282:  letExpSubCS3 ::= variableNameCS = OclExpressionCS
			//
			case 282: {
				
				SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
				OCLExpressionCS initExpression = (OCLExpressionCS)dtParser.getSym(3);
				VariableCS variableCS = createVariableCS(name, null, initExpression);
				setOffsets(variableCS, name, initExpression);

				EList result = new BasicEList();
				result.add(variableCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 283:  letExpSubCS3 ::= letExpSubCS3 , TupleLiteralPartCS
			//
			case 283: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 284:  LetExpCS ::= let letExpSubCS3 in OclExpressionCS
			//
			case 284: {
				
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
			// Rule 285:  LetExpCS ::= let letExpSubCS3 in qvtErrorToken
			//
			case 285: {
				
				EList variables = (EList)dtParser.getSym(2);
				CSTNode result = createLetExpCS(
						variables,
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "") //$NON-NLS-1$
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 286:  CallExpCS ::= . qvtErrorToken
			//
			case 286: {
				
				CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
	 			result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 287:  CallExpCS ::= -> qvtErrorToken
			//
			case 287: {
				
				CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
	 			result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 288:  argumentsCS ::= qvtErrorToken
			//
			case 288:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 290:  IteratorExpCS ::= primaryExpCS -> iteratorNameCS ( qvtErrorToken
			//
			case 290: {
				
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
			// Rule 292:  qvtErrorToken ::= ERROR_TOKEN
			//
			case 292: {
				
				diagnozeErrorToken(dtParser.getToken(1));
	  		  break;
			}
	 
			//
			// Rule 293:  equalityExpCS ::= equalityExpCS != relationalExpCS
			//
			case 293:
 
			//
			// Rule 294:  equalityLetCS ::= equalityExpCS != relationalLetCS
			//
			case 294: {
				
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
			// Rule 295:  StringLiteralExpCS ::= StringLiteralExpCS STRING_LITERAL
			//
			case 295: {
				
				IToken literalToken = getIToken(dtParser.getToken(2));
				StringLiteralExpCS result = (StringLiteralExpCS) dtParser.getSym(1);
				result.setSymbol(result.getSymbol() +  literalToken.toString());
				result.setStringSymbol(result.getStringSymbol() + literalToken.toString());
				result.setUnescapedStringSymbol(result.getUnescapedStringSymbol() +  unescape(literalToken));
				int tokenLine = literalToken.getLine();
				setOffsets(result, result, literalToken);
				IToken prevToken = getParseStream().getTokenAt(literalToken.getTokenIndex() - 1);
				int prevTokenLine = prevToken.getLine();
				if (prevTokenLine == tokenLine) {
					reportError(lpg.lpgjavaruntime.ParseErrorCodes.INVALID_CODE, "", prevToken.getTokenIndex(), literalToken.getTokenIndex(), "Multiline string literals must be located in different lines!"); //$NON-NLS-1$ //$NON-NLS-2$
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 297:  listTypeCS ::= List ( typeCS )
			//
			case 297: {
				
				CSTNode result = createListTypeCS(
						(TypeCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 298:  listLiteralCS ::= List { CollectionLiteralPartsCSopt }
			//
			case 298: {
				
				CSTNode result = createListLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 300:  dictTypeCS ::= Dict ( typeCS , typeCS )
			//
			case 300: {
				
				CSTNode result = createDictTypeCS((TypeCS)dtParser.getSym(3), (TypeCS)dtParser.getSym(5));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 301:  dictLiteralCS ::= Dict { dictLiteralPartListCSopt }
			//
			case 301: {
				
				CSTNode result = createDictLiteralExpCS((EList<DictLiteralPartCS>)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 306:  dictLiteralPartCS ::= literalSimpleCS = OclExpressionCS
			//
			case 306: {
				
				CSTNode result = createDictLiteralPartCS((LiteralExpCS)dtParser.getSym(1), (OCLExpressionCS)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 308:  dictLiteralPartListCSopt ::= $Empty
			//
			case 308:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 309:  dictLiteralPartListCS ::= dictLiteralPartCS
			//
			case 309: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 310:  dictLiteralPartListCS ::= dictLiteralPartListCS , dictLiteralPartCS
			//
			case 310: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 311:  dictLiteralPartListCS ::= dictLiteralPartListCS qvtErrorToken
			//
			case 311: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 313:  returnExpCS ::= return oclExpressionCSOpt
			//
			case 313: {
				
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
			// Rule 315:  var_init_group_exp ::= var var_init_declarator_list
			//
			case 315: {
				
				dtParser.setSym1(dtParser.getSym(2));
	  		  break;
			}
	 
			//
			// Rule 316:  var_init_group_exp ::= var ( var_init_declarator_list )
			//
			case 316: {
				
				dtParser.setSym1(dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 317:  var_init_group_exp ::= var ( var_init_declarator_list qvtErrorToken
			//
			case 317: {
				
				dtParser.setSym1(dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 319:  var_init_exp ::= var var_init_declarator
			//
			case 319: {
				
				dtParser.setSym1(dtParser.getSym(2));
	  		  break;
			}
	 
			//
			// Rule 320:  var_init_exp ::= var ( var_init_declarator )
			//
			case 320: {
				
				dtParser.setSym1(dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 321:  var_init_exp ::= var ( var_init_declarator qvtErrorToken
			//
			case 321: {
				
				dtParser.setSym1(dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 322:  var_init_exp ::= var qvtErrorToken
			//
			case 322: {
				
				dtParser.setSym1(ourEmptyEList);
	  		  break;
			}
	 
			//
			// Rule 323:  var_init_declarator_list ::= var_init_declarator , var_init_declarator
			//
			case 323: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 324:  var_init_declarator_list ::= var_init_declarator_list , var_init_declarator
			//
			case 324: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 325:  var_init_declarator ::= IDENTIFIER : typeCS var_init_op OclExpressionCS
			//
			case 325: {
				
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
			// Rule 326:  var_init_declarator ::= IDENTIFIER : typeCS var_init_op qvtErrorToken
			//
			case 326: {
				
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
			// Rule 327:  var_init_declarator ::= IDENTIFIER var_init_op OclExpressionCS
			//
			case 327: {
				
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
			// Rule 328:  var_init_declarator ::= IDENTIFIER var_init_op qvtErrorToken
			//
			case 328: {
				
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
			// Rule 329:  var_init_declarator ::= IDENTIFIER : typeCS
			//
			case 329: {
				
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
			// Rule 330:  var_init_declarator ::= IDENTIFIER : qvtErrorToken
			//
			case 330: {
				
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
			// Rule 331:  var_init_op ::= =
			//
			case 331:
 
			//
			// Rule 332:  var_init_op ::= :=
			//
			case 332: {
				
				dtParser.setSym1(false);
	  		  break;
			}
	 
			//
			// Rule 333:  var_init_op ::= ::=
			//
			case 333: {
				
				dtParser.setSym1(true);
	  		  break;
			}
	 
			//
			// Rule 335:  assignStatementCS ::= primaryExpCS := OclExpressionCS
			//
			case 335: {
				
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
			// Rule 336:  assignStatementCS ::= primaryExpCS := qvtErrorToken
			//
			case 336: {
				
				CSTNode result = createAssignStatementCS(
						(OCLExpressionCS)dtParser.getSym(1),
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, ""), //$NON-NLS-1$
						false
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 337:  assignStatementCS ::= primaryExpCS += OclExpressionCS
			//
			case 337: {
				
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
			// Rule 338:  assignStatementCS ::= primaryExpCS += qvtErrorToken
			//
			case 338: {
				
				CSTNode result = createAssignStatementCS(
						(OCLExpressionCS)dtParser.getSym(1),
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, ""), //$NON-NLS-1$
						true
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 340:  whileExpCS ::= while ( declarator1 ; OclExpressionCS ) whileBodyCS
			//
			case 340: {
				
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
			// Rule 341:  whileExpCS ::= while ( assignStatementCS ; OclExpressionCS ) whileBodyCS
			//
			case 341: {
				
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
			// Rule 342:  whileExpCS ::= while ( OclExpressionCS ) whileBodyCS
			//
			case 342: {
				
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
			// Rule 343:  IteratorExpCS ::= primaryExpCS -> forExpCS
			//
			case 343: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				ForExpCS forExpCS = (ForExpCS)dtParser.getSym(3);
				forExpCS.setSource(source);
				setOffsets(forExpCS, source, forExpCS);
				dtParser.setSym1(forExpCS);
	  		  break;
			}
	 
			//
			// Rule 346:  forExpDeclaratorList ::= IDENTIFIER
			//
			case 346: {
				
		EList result = new BasicEList();
		result.add(getIToken(dtParser.getToken(1)));
		dtParser.setSym1(result);
          		  break;
			}
    	 
			//
			// Rule 347:  forExpDeclaratorList ::= forExpDeclaratorList , IDENTIFIER
			//
			case 347: {
				
		EList result = (EList)dtParser.getSym(1);
		result.add(getIToken(dtParser.getToken(3)));
		dtParser.setSym1(result);
          		  break;
			}
    	 
			//
			// Rule 348:  forExpConditionOpt ::= $Empty
			//
			case 348:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 349:  forExpConditionOpt ::= | OclExpressionCS
			//
			case 349: {
				
            	    dtParser.setSym1((OCLExpressionCS)dtParser.getSym(2));
          		  break;
			}
    	 
			//
			// Rule 350:  forExpConditionOpt ::= | qvtErrorToken
			//
			case 350:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 351:  forExpCS ::= forOpCode ( forExpDeclaratorList forExpConditionOpt ) expression_block
			//
			case 351: {
				
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
			// Rule 352:  forExpCS ::= forOpCode qvtErrorToken
			//
			case 352: {
				
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
			// Rule 356:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS else ifExpBodyCS endif
			//
			case 356: {
				
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
			// Rule 357:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS endif
			//
			case 357: {
				
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
			// Rule 358:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS else ifExpBodyCS qvtErrorToken
			//
			case 358: {
				
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
			// Rule 359:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS else qvtErrorToken
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
			// Rule 360:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS qvtErrorToken
			//
			case 360: {
				
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
			// Rule 361:  IfExpCS ::= if OclExpressionCS then qvtErrorToken
			//
			case 361: {
				
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
			// Rule 362:  IfExpCS ::= if OclExpressionCS qvtErrorToken
			//
			case 362: {
				
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
			// Rule 363:  IfExpCS ::= if qvtErrorToken
			//
			case 363: {
				
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
			// Rule 365:  switchExpCS ::= switch switchBodyExpCS
			//
			case 365: {
				
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
			// Rule 367:  switchDeclaratorCS ::= IDENTIFIER
			//
			case 367: {
				
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 368:  switchDeclaratorCS ::= IDENTIFIER = OclExpressionCS
			//
			case 368: {
				
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						null,
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 369:  IterateExpCS ::= primaryExpCS -> switch ( switchDeclaratorCS ) switchBodyExpCS
			//
			case 369: {
				
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
			// Rule 370:  switchExpCS ::= switch qvtErrorToken
			//
			case 370: {
				
				CSTNode result = createSwitchExpCS(
						new BasicEList(),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 371:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt }
			//
			case 371: {
				
				Object[] result = new Object[] {dtParser.getSym(2), dtParser.getSym(3), getIToken(dtParser.getToken(4))};
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 372:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt qvtErrorToken
			//
			case 372: {
				
				Object[] result = new Object[] {dtParser.getSym(2), dtParser.getSym(3), dtParser.getSym(3)};
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 373:  switchBodyExpCS ::= { qvtErrorToken
			//
			case 373: {
				
				Object[] result = new Object[] {new BasicEList(), null, getIToken(dtParser.getToken(1))};
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 374:  switchAltExpCSList ::= switchAltExpCS
			//
			case 374: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 375:  switchAltExpCSList ::= switchAltExpCSList switchAltExpCS
			//
			case 375: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 376:  switchAltExpCS ::= case ( OclExpressionCS ) expression_statement
			//
			case 376: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(3),
						(OCLExpressionCS) dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 377:  switchAltExpCS ::= case ( OclExpressionCS ) qvtErrorToken
			//
			case 377: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 378:  switchElseExpCSOpt ::= $Empty
			//
			case 378:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 380:  switchElseExpCS ::= else expression_statement
			//
			case 380: {
				
				dtParser.setSym1((CSTNode)dtParser.getSym(2));
	  		  break;
			}
	 
			//
			// Rule 381:  switchElseExpCS ::= else qvtErrorToken
			//
			case 381: {
				
				dtParser.setSym1(null);
	  		  break;
			}
	 
			//
			// Rule 382:  OclExpressionCS ::= primaryOCLExpressionCS
			//
			case 382: {
				
				CSTNode result = createExpressionStatementCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 384:  logWhenExp ::= when OclExpressionCS
			//
			case 384: {
				
			OCLExpressionCS condition = (OCLExpressionCS) dtParser.getSym(2);
			dtParser.setSym1(condition);
      		  break;
			}
     
			//
			// Rule 386:  logWhenExpOpt ::= $Empty
			//
			case 386:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 387:  logExpCS ::= log ( argumentsCSopt ) logWhenExpOpt
			//
			case 387: {
				
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
			// Rule 389:  severityKindCS ::= simpleNameCS
			//
			case 389: {
				
			dtParser.setSym1(dtParser.getSym(1));
	  		  break;
			}
	 
			//
			// Rule 391:  severityKindCSOpt ::= $Empty
			//
			case 391:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 392:  assertWithLogExp ::= with logExpCS
			//
			case 392: {
				
			LogExpCS logExp = (LogExpCS) dtParser.getSym(2);
			setOffsets(logExp, getIToken(dtParser.getToken(2)), logExp);
			dtParser.setSym1(logExp);
      		  break;
			}
     
			//
			// Rule 394:  assertWithLogExpOpt ::= $Empty
			//
			case 394:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 395:  assertExpCS ::= assert severityKindCSOpt ( OclExpressionCS ) assertWithLogExpOpt
			//
			case 395: {
				
			LogExpCS logExpCS = (LogExpCS)dtParser.getSym(6);
			OCLExpressionCS condition = (OCLExpressionCS)dtParser.getSym(4);
			AssertExpCS result = (AssertExpCS)createAssertExpCS(condition, (SimpleNameCS)dtParser.getSym(2), logExpCS);
	
			CSTNode end = logExpCS != null ? logExpCS : condition; 
			setOffsets(result, getIToken(dtParser.getToken(1)), end);
			dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 396:  computeExpCS ::= compute ( declarator ) expression_block
			//
			case 396: {
				
				CSTNode result = createComputeExpCS(
					(VariableCS) dtParser.getSym(3),
					(OCLExpressionCS) dtParser.getSym(5)
				);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 398:  IterateExpCS ::= primaryExpCS -> imperativeIterateExpCS
			//
			case 398: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				ImperativeIterateExpCS iterateExpCS = (ImperativeIterateExpCS) dtParser.getSym(3);
				iterateExpCS.setSource(source);
				setOffsets(iterateExpCS, source, iterateExpCS);
				dtParser.setSym1(iterateExpCS);
	  		  break;
			}
	 
			//
			// Rule 407:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken12 ( imperativeIterContents12 )
			//
			case 407:
 
			//
			// Rule 408:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken3 ( imperativeIterContents3 )
			//
			case 408: {
				
				String opCode = getTokenText(dtParser.getToken(1));
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							opCode
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
			// Rule 409:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken qvtErrorToken
			//
			case 409: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
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
			// Rule 410:  imperativeIterContents12 ::= OclExpressionCS
			//
			case 410: {
				
				dtParser.setSym1(new Object[] {
						ourEmptyEList,
						null,
						dtParser.getSym(1)
					});
	  		  break;
			}
	 
			//
			// Rule 411:  imperativeIterContents12 ::= variableDeclarationListCS | OclExpressionCS
			//
			case 411: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						null,
						dtParser.getSym(3)
					});
	  		  break;
			}
	 
			//
			// Rule 412:  imperativeIterContents3 ::= variableDeclarationListCS ; TupleLiteralPartCS | OclExpressionCS
			//
			case 412: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						dtParser.getSym(3),
						dtParser.getSym(5)
					});
	  		  break;
			}
	 
			//
			// Rule 413:  exclamationOpt ::= $Empty
			//
			case 413:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 415:  declarator_vsep ::= IDENTIFIER |
			//
			case 415: {
				
		CSTNode result = createVariableCS(
					getTokenText(dtParser.getToken(1)),
                                            null,
					null
					);
                    setOffsets(result, getIToken(dtParser.getToken(1)));
                    dtParser.setSym1(result);
          		  break;
			}
    	 
			//
			// Rule 416:  declarator_vsepOpt ::= $Empty
			//
			case 416:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 418:  IterateExpCS ::= primaryExpCS exclamationOpt [ declarator_vsepOpt OclExpressionCS ]
			//
			case 418: {
				
		OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
		if (source instanceof ImperativeIterateExpCS) {
			String opCode = isTokenOfType(getIToken(dtParser.getToken(2)), LightweightTypeParsersym.TK_EXCLAMATION_MARK) ?  "collectselectOne" : "collectselect"; //$NON-NLS-1$ //$NON-NLS-2$ 
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
			String opCode = isTokenOfType(getIToken(dtParser.getToken(2)), LightweightTypeParsersym.TK_EXCLAMATION_MARK) ?  "selectOne" : "xselect"; //$NON-NLS-1$ //$NON-NLS-2$ 
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
			// Rule 419:  IterateExpCS ::= primaryExpCS -> notReservedSimpleNameCS
			//
			case 419: {
				
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
			// Rule 421:  newExpCS ::= new newTypespecCS ( argumentsCSopt )
			//
			case 421: {
				
			OCLExpressionCS result = createNewRuleCallExpCS((TypeSpecCS) dtParser.getSym(2), (EList) dtParser.getSym(4));
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
			dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 422:  newTypespecCS ::= pathNameCS
			//
			case 422: {
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)dtParser.getSym(1),
					null
					);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 423:  newTypespecCS ::= pathNameCS @ IDENTIFIER
			//
			case 423: {
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)dtParser.getSym(1),
					getIToken(dtParser.getToken(3))
					);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 424:  primaryExpCS ::= break
			//
			case 424: {
				
			OCLExpressionCS result = createBreakCS();
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 425:  primaryExpCS ::= continue
			//
			case 425: {
				
			OCLExpressionCS result = createContinueCS();
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 426:  switchAltExpCS ::= ( OclExpressionCS ) ? OclExpressionCS ;
			//
			case 426: {
				
				CSTNode result = createSwitchAltExpCSDeprecated(
						(OCLExpressionCS) dtParser.getSym(2),
						(OCLExpressionCS) dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 427:  switchAltExpCS ::= ( OclExpressionCS ) qvtErrorToken
			//
			case 427: {
				
				CSTNode result = createSwitchAltExpCSDeprecated(
						(OCLExpressionCS) dtParser.getSym(2),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 428:  switchAltExpCS ::= ( qvtErrorToken
			//
			case 428: {
				
				CSTNode result = createSwitchAltExpCSDeprecated(
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 429:  switchElseExpCS ::= else ? OclExpressionCS ;
			//
			case 429: {
				
		    	int startOffset = getIToken(dtParser.getToken(1)).getStartOffset();
		    	int endOffset = getIToken(dtParser.getToken(4)).getEndOffset();
				reportWarning(org.eclipse.m2m.internal.qvt.oml.cst.parser.NLS.bind(org.eclipse.m2m.internal.qvt.oml.cst.parser.Messages.AbstractQVTParser_DeprecatedSwitchElseExp, null), startOffset, endOffset);
				
				dtParser.setSym1((CSTNode)dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 430:  switchElseExpCS ::= else ? OclExpressionCS qvtErrorToken
			//
			case 430: {
				
		    	int startOffset = getIToken(dtParser.getToken(1)).getStartOffset();
		    	int endOffset = getIToken(dtParser.getToken(3)).getEndOffset();
				reportWarning(org.eclipse.m2m.internal.qvt.oml.cst.parser.NLS.bind(org.eclipse.m2m.internal.qvt.oml.cst.parser.Messages.AbstractQVTParser_DeprecatedSwitchElseExp, null), startOffset, endOffset);
				
				dtParser.setSym1((CSTNode)dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 431:  topLevel ::= unit_elementList
			//
			case 431: {
				
				EList<CSTNode> unitElements = (EList<CSTNode>)dtParser.getSym(1);
				dtParser.setSym1(setupTopLevel(unitElements));
	  		  break;
			}
	 
			//
			// Rule 433:  _import ::= import unit ;
			//
			case 433: {
				
				CSTNode result = createImportCS(
						(PathNameCS)dtParser.getSym(2)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 434:  _import ::= import qvtErrorToken
			//
			case 434: {
				
				CSTNode result = createLibraryImportCS(
						createPathNameCS()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 436:  unit_elementList ::= unit_elementList unit_element
			//
			case 436: {
				
				EList list = (EList)dtParser.getSym(1);
				list.add(dtParser.getSym(2));
				dtParser.setSym1(list);
	  		  break;
			}
	 
			//
			// Rule 437:  unit_elementList ::= $Empty
			//
			case 437:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 448:  unit_element ::= qvtErrorToken
			//
			case 448:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 451:  transformation_decl ::= transformation_h ;
			//
			case 451: {
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) dtParser.getSym(1);
				setOffsets(headerCS, headerCS, getIToken(dtParser.getToken(2)));
				MappingModuleCS moduleCS = createMappingModuleCS(headerCS, ourEmptyEList);
				setOffsets(moduleCS, headerCS);
				dtParser.setSym1(moduleCS);
	  		  break;
			}
	 
			//
			// Rule 452:  transformation_def ::= transformation_h { module_elementList } semicolonOpt
			//
			case 452: {
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) dtParser.getSym(1);
				MappingModuleCS moduleCS = createMappingModuleCS(headerCS, (EList) dtParser.getSym(3));
				setOffsets(moduleCS, headerCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(moduleCS);
	  		  break;
			}
	 
			//
			// Rule 455:  library_decl ::= library_h ;
			//
			case 455: {
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) dtParser.getSym(1);
				setOffsets(headerCS, headerCS, getIToken(dtParser.getToken(2)));
				MappingModuleCS moduleCS = createLibraryCS(headerCS, ourEmptyEList);
				setOffsets(moduleCS, headerCS);
				dtParser.setSym1(moduleCS);
	  		  break;
			}
	 
			//
			// Rule 456:  library_def ::= library_h { module_elementList } semicolonOpt
			//
			case 456: {
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) dtParser.getSym(1);
				MappingModuleCS moduleCS = createLibraryCS(headerCS, (EList) dtParser.getSym(3));
				setOffsets(moduleCS, headerCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(moduleCS);
	  		  break;
			}
	 
			//
			// Rule 457:  transformation_h ::= qualifierList transformation qualifiedNameCS transformation_signature transformation_usage_refineOpt
			//
			case 457: {
				
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
			// Rule 458:  transformation_usage_refineOpt ::= $Empty
			//
			case 458:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 463:  transformation_refine ::= refines moduleref
			//
			case 463: {
				
				CSTNode result = createTransformationRefineCS(
						(ModuleRefCS)dtParser.getSym(2)
					);
				setOffsets(result, (ModuleRefCS)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 464:  library_h ::= library qualifiedNameCS library_signatureOpt module_usageListOpt
			//
			case 464: {
				
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
			// Rule 465:  library_h ::= library qvtErrorToken
			//
			case 465: {
				
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
			// Rule 466:  library_signatureOpt ::= $Empty
			//
			case 466:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 469:  module_usageList ::= module_usage
			//
			case 469: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 470:  module_usageList ::= module_usageList module_usage
			//
			case 470: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 471:  module_usageListOpt ::= $Empty
			//
			case 471:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 475:  access_usage ::= access module_kindOpt moduleref_list
			//
			case 475: {
				
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
			// Rule 476:  extends_usage ::= extends module_kindOpt moduleref_list
			//
			case 476: {
				
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
			// Rule 477:  module_kindOpt ::= $Empty
			//
			case 477:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 479:  module_kind ::= transformation
			//
			case 479: {
				
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.TRANSFORMATION
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 480:  module_kind ::= library
			//
			case 480: {
				
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.LIBRARY
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 481:  moduleref_list ::= moduleref
			//
			case 481: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 482:  moduleref_list ::= moduleref_list , moduleref
			//
			case 482: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 483:  moduleref_list ::= moduleref_list qvtErrorToken
			//
			case 483: {
				
				EList result = (EList) dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 484:  moduleref ::= pathNameCS simple_signatureOpt
			//
			case 484: {
				
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
			// Rule 485:  module_elementList ::= module_elementList module_element
			//
			case 485: {
				
				EList list = (EList)dtParser.getSym(1);
				list.add(dtParser.getSym(2));
				dtParser.setSym1(list);
	  		  break;
			}
	 
			//
			// Rule 486:  module_elementList ::= $Empty
			//
			case 486:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 494:  module_element ::= qvtErrorToken
			//
			case 494:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 495:  _modeltype ::= modeltype IDENTIFIER compliance_kindOpt uses packageref_list modeltype_whereOpt ;
			//
			case 495: {
				
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
			// Rule 496:  _modeltype ::= modeltype qvtErrorToken
			//
			case 496: {
				
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
			// Rule 497:  modeltype_whereOpt ::= $Empty
			//
			case 497:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 499:  modeltype_where ::= where expression_block
			//
			case 499: {
				
				BlockExpCS blockExpCS = (BlockExpCS) dtParser.getSym(2);
				dtParser.setSym1(blockExpCS.getBodyExpressions());
	  		  break;
			}
	 
			//
			// Rule 500:  packageref_list ::= packageref
			//
			case 500: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 501:  packageref_list ::= packageref_list , packageref
			//
			case 501: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 502:  packageref_list ::= packageref_list qvtErrorToken
			//
			case 502: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 503:  packageref ::= pathNameCS
			//
			case 503: {
				
				CSTNode result = createPackageRefCS(
						(PathNameCS)dtParser.getSym(1),
						null
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 504:  packageref ::= pathNameCS ( uri )
			//
			case 504: {
				
				CSTNode result = createPackageRefCS(
						(PathNameCS)dtParser.getSym(1),
						(StringLiteralExpCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 505:  packageref ::= uri
			//
			case 505: {
				
				CSTNode result = createPackageRefCS(
						null,
						(StringLiteralExpCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 506:  compliance_kindOpt ::= $Empty
			//
			case 506:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 510:  classifierDefCS ::= intermediate class qvtIdentifierCS classifierExtensionOpt { classifierFeatureListOpt } semicolonOpt
			//
			case 510: {
				
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
			// Rule 511:  classifierExtensionOpt ::= $Empty
			//
			case 511:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 512:  classifierExtensionOpt ::= extends type_list
			//
			case 512: {
				
				EList result = (EList)dtParser.getSym(2);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 513:  type_list ::= typeCS
			//
			case 513: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 514:  type_list ::= type_list , typeCS
			//
			case 514: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 515:  type_list ::= type_list qvtErrorToken
			//
			case 515: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 516:  classifierFeatureListOpt ::= $Empty
			//
			case 516:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 518:  classifierFeatureList ::= classifierFeatureCS
			//
			case 518: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 519:  classifierFeatureList ::= classifierFeatureList ; classifierFeatureCS
			//
			case 519: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 520:  classifierFeatureList ::= classifierFeatureList qvtErrorToken
			//
			case 520: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 521:  classifierFeatureCS ::= stereotype_qualifier_list feature_key_list qvtIdentifierCS : typeCS multiplicityOpt ordered_prop opposite_propertyOpt init_partOpt
			//
			case 521: {
				
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
			// Rule 523:  init_partOpt ::= $Empty
			//
			case 523:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 524:  init_partOpt ::= = OclExpressionCS
			//
			case 524: {
				
				CSTNode result = (CSTNode) dtParser.getSym(2);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 525:  stereotype_qualifier_list ::= $Empty
			//
			case 525:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 526:  stereotype_qualifier_list ::= STEREOTYPE_QUALIFIER_OPEN identifier_list STEREOTYPE_QUALIFIER_CLOSE
			//
			case 526: {
				
				EList result = (EList)dtParser.getSym(2);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 527:  identifier_list ::= qvtIdentifierCS
			//
			case 527: {
				
				EList result = new BasicEList();
				result.add(getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 528:  identifier_list ::= identifier_list , qvtIdentifierCS
			//
			case 528: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 529:  identifier_list ::= identifier_list qvtErrorToken
			//
			case 529: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 530:  feature_key_list ::= $Empty
			//
			case 530:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 531:  feature_key_list ::= feature_key_list feature_key
			//
			case 531: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 532:  feature_key_list ::= feature_key_list qvtErrorToken
			//
			case 532: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 533:  feature_key ::= composes
			//
			case 533:
 
			//
			// Rule 534:  feature_key ::= references
			//
			case 534:
 
			//
			// Rule 535:  feature_key ::= readonly
			//
			case 535:
 
			//
			// Rule 536:  feature_key ::= derived
			//
			case 536:
 
			//
			// Rule 537:  feature_key ::= static
			//
			case 537: {
				
				CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 538:  multiplicityOpt ::= $Empty
			//
			case 538:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 539:  multiplicityOpt ::= LBRACKET multiplicity_range RBRACKET
			//
			case 539: {
				
				CSTNode result = (CSTNode) dtParser.getSym(2);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 540:  multiplicity_range ::= IntegerLiteralExpCS
			//
			case 540: {
				
				CSTNode result = createMultiplicityDefCS(
						(PrimitiveLiteralExpCS) dtParser.getSym(1),
						(PrimitiveLiteralExpCS) dtParser.getSym(1)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 541:  multiplicity_range ::= UnlimitedNaturalLiteralExpCS
			//
			case 541: {
				
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
			// Rule 542:  multiplicity_range ::= IntegerLiteralExpCS MULTIPLICITY_RANGE IntegerLiteralExpCS
			//
			case 542:
 
			//
			// Rule 543:  multiplicity_range ::= IntegerLiteralExpCS DOTDOT IntegerLiteralExpCS
			//
			case 543:
 
			//
			// Rule 544:  multiplicity_range ::= IntegerLiteralExpCS MULTIPLICITY_RANGE UnlimitedNaturalLiteralExpCS
			//
			case 544:
 
			//
			// Rule 545:  multiplicity_range ::= IntegerLiteralExpCS DOTDOT UnlimitedNaturalLiteralExpCS
			//
			case 545: {
				
				CSTNode result = createMultiplicityDefCS(
						(PrimitiveLiteralExpCS) dtParser.getSym(1),
						(PrimitiveLiteralExpCS) dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 546:  ordered_prop ::= ordered
			//
			case 546: {
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.TRUE.toString());
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 547:  ordered_prop ::= $Empty
			//
			case 547: {
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.FALSE.toString());
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 548:  opposite_propertyOpt ::= $Empty
			//
			case 548:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 549:  opposite_propertyOpt ::= opposites navigable_prop qvtIdentifierCS multiplicityOpt
			//
			case 549: {
				
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
			// Rule 550:  navigable_prop ::= TILDE_SIGN
			//
			case 550: {
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.FALSE.toString());
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 551:  navigable_prop ::= $Empty
			//
			case 551: {
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.TRUE.toString());
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 552:  _property ::= configuration property qvtIdentifierCS : typeCS ;
			//
			case 552: {
				
				CSTNode result = createConfigPropertyCS(
						getIToken(dtParser.getToken(3)),
						(TypeCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 553:  _property ::= configuration property qvtIdentifierCS : typeCS qvtErrorToken
			//
			case 553: {
				
				CSTNode result = createConfigPropertyCS(
						getIToken(dtParser.getToken(3)),
						(TypeCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 554:  _property ::= property qvtIdentifierCS : typeCS = OclExpressionCS ;
			//
			case 554: {
				
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
			// Rule 555:  _property ::= property qvtIdentifierCS = OclExpressionCS ;
			//
			case 555: {
				
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
			// Rule 556:  _property ::= intermediate property scoped_identifier : typeCS ;
			//
			case 556: {
				
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
			// Rule 557:  _property ::= intermediate property scoped_identifier : typeCS = OclExpressionCS ;
			//
			case 557: {
				
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
			// Rule 561:  helper_header ::= helper_info scoped_identifier complete_signature
			//
			case 561: {
				
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
				mappingDeclarationCS.setIsQuery(helperKind.getKind() == LightweightTypeParsersym.TK_query);
				mappingDeclarationCS.setStartOffset(helperKind.getStartOffset());

				dtParser.setSym1(mappingDeclarationCS);
	  		  break;
			}
	 
			//
			// Rule 562:  helper_header ::= helper_info qvtErrorToken
			//
			case 562: {
				
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
				mappingDeclarationCS.setIsQuery(helperKind.getKind() == LightweightTypeParsersym.TK_query);
				mappingDeclarationCS.setStartOffset(helperKind.getStartOffset());

				dtParser.setSym1(mappingDeclarationCS);
	  		  break;
			}
	 
			//
			// Rule 563:  helper_info ::= qualifierList helper_kind
			//
			case 563: {
				
				dtParser.setSym1(new Object[] {dtParser.getSym(1), getIToken(dtParser.getToken(2))});
	  		  break;
			}
	 
			//
			// Rule 566:  helper_decl ::= helper_header ;
			//
			case 566: {
				
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
			// Rule 567:  helper_decl ::= helper_header qvtErrorToken
			//
			case 567: {
				
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
			// Rule 568:  helper_simple_def ::= helper_header = OclExpressionCS ;
			//
			case 568: {
				
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
			// Rule 569:  helper_compound_def ::= helper_header expression_block semicolonOpt
			//
			case 569: {
				
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
			// Rule 572:  constructor_header ::= qualifierList constructor scoped_identifier simple_signature
			//
			case 572: {
				
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
			// Rule 573:  constructor_decl ::= constructor_header ;
			//
			case 573: {
				
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
			// Rule 574:  constructor_decl ::= constructor_header qvtErrorToken
			//
			case 574: {
				
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
			// Rule 575:  constructor_def ::= constructor_header expression_block semicolonOpt
			//
			case 575: {
				
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
			// Rule 578:  entry_header ::= main simple_signature
			//
			case 578: {
				
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
			// Rule 579:  entry_header ::= main qvtErrorToken
			//
			case 579: {
				
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
			// Rule 580:  entry_decl ::= entry_header ;
			//
			case 580: {
				
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
			// Rule 581:  entry_def ::= entry_header expression_block semicolonOpt
			//
			case 581: {
				
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
			// Rule 582:  _tag ::= tag StringLiteralExpCS scoped_identifier tag_valueOpt
			//
			case 582: {
				
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
			// Rule 583:  tag_valueOpt ::= $Empty
			//
			case 583:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 584:  tag_valueOpt ::= = OclExpressionCS
			//
			case 584: {
				
				dtParser.setSym1(dtParser.getSym(2));
	  		  break;
			}
	 
			//
			// Rule 587:  mapping_decl ::= mapping_full_header ;
			//
			case 587: {
				
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
			// Rule 588:  mapping_def ::= mapping_full_header { mapping_body } semicolonOpt
			//
			case 588: {
				
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
			// Rule 589:  mapping_def ::= mapping_full_header { qvtErrorToken
			//
			case 589: {
				
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
			// Rule 590:  mapping_full_header ::= mapping_header _whenOpt
			//
			case 590: {
				
				dtParser.setSym1(new Object[] {dtParser.getSym(1), dtParser.getSym(2)});
	  		  break;
			}
	 
			//
			// Rule 591:  mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier complete_signature mapping_extraList
			//
			case 591: {
				
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
			// Rule 592:  mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier qvtErrorToken
			//
			case 592: {
				
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
			// Rule 593:  mapping_header ::= qualifierList mapping qvtErrorToken
			//
			case 593: {
				
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
			// Rule 594:  mapping_extraList ::= mapping_extraList mapping_extra
			//
			case 594: {
				
				EList<MappingExtensionCS> extensionList = (EList<MappingExtensionCS>)dtParser.getSym(1);
				extensionList.add((MappingExtensionCS)dtParser.getSym(2));
				dtParser.setSym1(extensionList);
	  		  break;
			}
	 
			//
			// Rule 595:  mapping_extraList ::= $Empty
			//
			case 595:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 597:  mapping_extension ::= mapping_extension_key scoped_identifier_list
			//
			case 597: {
				
				MappingExtensionCS result = createMappingExtension(getTokenText(dtParser.getToken(1)), (EList<ScopedNameCS>)dtParser.getSym(2));

				result.setStartOffset(getIToken(dtParser.getToken(1)).getStartOffset());
				result.setEndOffset(getEndOffset(getIToken(dtParser.getToken(1)), (EList<ScopedNameCS>)dtParser.getSym(2)));
			
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 602:  _whenOpt ::= $Empty
			//
			case 602:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 603:  _when ::= when { OclExpressionCS semicolonOpt }
			//
			case 603: {
				
				OCLExpressionCS result = (OCLExpressionCS)dtParser.getSym(3);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 604:  _when ::= when qvtErrorToken
			//
			case 604:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 605:  mapping_body ::= init_sectionOpt population_sectionOpt end_sectionOpt
			//
			case 605: {
				
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
			// Rule 606:  init_sectionOpt ::= $Empty
			//
			case 606:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 608:  init_section ::= init expression_block
			//
			case 608: {
				
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
			// Rule 609:  init_section ::= init qvtErrorToken
			//
			case 609: {
				
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
			// Rule 610:  population_sectionOpt ::= $Empty
			//
			case 610: {
				
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
			// Rule 612:  population_section ::= expression_list
			//
			case 612: {
				
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
			// Rule 613:  population_section ::= population expression_block
			//
			case 613: {
				
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
			// Rule 614:  population_section ::= population qvtErrorToken
			//
			case 614: {
				
				CSTNode result = createMappingBodyCS(
						ourEmptyEList,
						true
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 615:  end_sectionOpt ::= $Empty
			//
			case 615:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 617:  end_section ::= end expression_block
			//
			case 617: {
				
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
			// Rule 618:  end_section ::= end qvtErrorToken
			//
			case 618: {
				
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
			// Rule 619:  typespecOpt ::= $Empty
			//
			case 619:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 621:  objectDeclCS ::= typespec
			//
			case 621: {
				
				CSTNode result = createOutExpCS(null, (TypeSpecCS)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 625:  objectDeclCS ::= objectIdentifierCS : typespecOpt
			//
			case 625: {
				
			SimpleNameCS varName = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(varName, getIToken(dtParser.getToken(1)));
			CSTNode result = createOutExpCS(varName,(TypeSpecCS)dtParser.getSym(3));					
			dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 626:  outExpCS ::= object objectDeclCS expression_block
			//
			case 626: {
				
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
			// Rule 627:  outExpCS ::= object objectDeclCS qvtErrorToken
			//
			case 627: {
				
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
			// Rule 628:  featureMappingCallExpCS ::= map simpleNameCS ( argumentsCSopt )
			//
			case 628: {
				
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
			// Rule 629:  featureMappingCallExpCS ::= xmap simpleNameCS ( argumentsCSopt )
			//
			case 629: {
				
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
			// Rule 630:  featureMappingCallExpCS ::= map simpleNameCS :: simpleNameCS ( argumentsCSopt )
			//
			case 630: {
				
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
			// Rule 631:  featureMappingCallExpCS ::= xmap simpleNameCS :: simpleNameCS ( argumentsCSopt )
			//
			case 631: {
				
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
			// Rule 632:  mappingCallExpCS ::= map pathNameCS ( argumentsCSopt )
			//
			case 632: {
				
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
			// Rule 633:  mappingCallExpCS ::= xmap pathNameCS ( argumentsCSopt )
			//
			case 633: {
				
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
			// Rule 634:  resolveConditionOpt ::= $Empty
			//
			case 634:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 635:  resolveConditionOpt ::= | OclExpressionCS
			//
			case 635: {
				
                dtParser.setSym1((OCLExpressionCS)dtParser.getSym(2));
      		  break;
			}
     
			//
			// Rule 636:  resolveConditionOpt ::= | qvtErrorToken
			//
			case 636:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 637:  IDENTIFIEROpt ::= $Empty
			//
			case 637:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 638:  IDENTIFIEROpt ::= IDENTIFIER :
			//
			case 638: {
				
                dtParser.setSym1(getIToken(dtParser.getToken(1)));
      		  break;
			}
     
			//
			// Rule 639:  resolveOpArgsExpCSOpt ::= $Empty
			//
			case 639:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 641:  resolveOpArgsExpCS ::= IDENTIFIEROpt typeCS resolveConditionOpt
			//
			case 641: {
				
                CSTNode result = createResolveOpArgsExpCS(
                        getIToken(dtParser.getToken(1)),      // target_type_variable?
                        (TypeCS)dtParser.getSym(2),           // type?
                        (OCLExpressionCS)dtParser.getSym(3)); // condition?
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
                    dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 646:  lateOpt ::= $Empty
			//
			case 646:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 648:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCSOpt )
			//
			case 648: {
				
                CSTNode result = createResolveExpCS(
                            getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                            (ResolveOpArgsExpCS)dtParser.getSym(4));
                            setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
                    dtParser.setSym1(result);
          		  break;
			}
         
			//
			// Rule 649:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCSOpt qvtErrorToken
			//
			case 649: {
				
                CSTNode result = createResolveExpCS(
                            getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        (ResolveOpArgsExpCS)dtParser.getSym(4));
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 650:  resolveExpCS ::= lateOpt resolveOp qvtErrorToken
			//
			case 650: {
				
                CSTNode result = createResolveExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        null);
                            setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 651:  resolveExpCS ::= late qvtErrorToken
			//
			case 651: {
				
    			IToken lateToken = getIToken(dtParser.getToken(1));
                CSTNode result = createResolveExpCS(
                        lateToken,
                        new Token(lateToken.getEndOffset(), lateToken.getEndOffset(), LightweightTypeParsersym.TK_resolve),
                        null);
                            setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 656:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier , resolveOpArgsExpCS )
			//
			case 656: {
				
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
			// Rule 657:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier )
			//
			case 657: {
				
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
			// Rule 658:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier , resolveOpArgsExpCSOpt qvtErrorToken
			//
			case 658: {
				
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
			// Rule 659:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier qvtErrorToken
			//
			case 659: {
				
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
			// Rule 660:  resolveInExpCS ::= lateOpt resolveInOp ( qvtErrorToken
			//
			case 660: {
				
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
			// Rule 661:  resolveInExpCS ::= lateOpt resolveInOp qvtErrorToken
			//
			case 661: {
				
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
			// Rule 664:  OperationCallExpCS ::= primaryExpCS -> resolveResolveInExpCS
			//
			case 664: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CallExpCS result = (CallExpCS)dtParser.getSym(3);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				result.setSource(source);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 665:  OperationCallExpCS ::= primaryExpCS . resolveResolveInExpCS
			//
			case 665: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CallExpCS result = (CallExpCS)dtParser.getSym(3);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				result.setSource(source);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 667:  OperationCallExpCS ::= primaryExpCS -> featureMappingCallExpCS
			//
			case 667: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CallExpCS result = (CallExpCS)dtParser.getSym(3);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				result.setSource(source);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 668:  OperationCallExpCS ::= primaryExpCS . featureMappingCallExpCS
			//
			case 668: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CallExpCS result = (CallExpCS)dtParser.getSym(3);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				result.setSource(source);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 671:  simpleIdentifierCS ::= this
			//
			case 671:
 
			//
			// Rule 672:  simpleIdentifierCS ::= result
			//
			case 672: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 673:  _import ::= import library unit ;
			//
			case 673: {
				
				CSTNode result = createLibraryImportCS(
						(PathNameCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 674:  transformation_h ::= qualifierList transformation qualifiedNameCS
			//
			case 674: {
				
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
			// Rule 676:  renaming ::= rename typeCS . qvtIdentifierCS = StringLiteralExpCS ;
			//
			case 676: {
				
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

