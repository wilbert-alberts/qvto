/**
* <copyright>
*
* Copyright (c) 2005, 2008 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - 225493 Need ability to set CSTNode offsets
*
* </copyright>
*
* $Id: LightweightTypeParser.java,v 1.34 2009/01/09 15:59:32 radvorak Exp $
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
* $Id: LightweightTypeParser.java,v 1.34 2009/01/09 15:59:32 radvorak Exp $
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
* $Id: LightweightTypeParser.java,v 1.34 2009/01/09 15:59:32 radvorak Exp $
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
* $Id: LightweightTypeParser.java,v 1.34 2009/01/09 15:59:32 radvorak Exp $
*/

package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.cst.parser;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.cst.DotOrArrowEnum;
import org.eclipse.ocl.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.MessageExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OCLMessageArgCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StateExpCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;

import lpg.lpgjavaruntime.BadParseException;
import lpg.lpgjavaruntime.BadParseSymFileException;
import lpg.lpgjavaruntime.DeterministicParser;
import lpg.lpgjavaruntime.DiagnoseParser;
import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.Monitor;
import lpg.lpgjavaruntime.NotDeterministicParseTableException;
import lpg.lpgjavaruntime.ParseTable;
import lpg.lpgjavaruntime.RuleAction;


import org.eclipse.ocl.cst.StringLiteralExpCS;
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
import org.eclipse.m2m.internal.qvt.oml.cst.LogExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.ReturnExpCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.temp.ScopedNameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.temp.TempFactory;

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
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS;
import org.eclipse.m2m.internal.qvt.oml.cst.OutExpCS;
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
			String error = "The Lexer will not scan the following token(s):";
			for (int i = 0; i < unimplemented_symbols.size(); i++) {
				Integer id = (Integer) unimplemented_symbols.get(i);
				error += "\t" + LightweightTypeParsersym.orderedTerminalSymbols[id.intValue()];			   
			}
			throw new RuntimeException(error + "\n");						
		}
		catch(UndefinedEofSymbolException e) {
			throw new RuntimeException("The Lexer does not implement the Eof symbol " +
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
		
	@SuppressWarnings("nls")
	@Override
	public CSTNode parseTokensToCST(Monitor monitor, int error_repair_count) {
		ParseTable prsTable = new LightweightTypeParserprs();

		try {
			dtParser = new BacktrackingParser(monitor, this, prsTable, this);
		}
		catch (NotBacktrackParseTableException e) {
			throw new RuntimeException("****Error: Regenerate LightweightTypeParserprs.java with -NOBACKTRACK option");
		}
		catch (BadParseSymFileException e) {
			throw new RuntimeException("****Error: Bad Parser Symbol File -- LightweightTypeParsersym.java. Regenerate LightweightTypeParserprs.java");
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
		String result = getName(e.error_token) + " ~~ ";
		for (int i = Math.max(0, e.error_token-5), n = Math.min(tokens.size(), e.error_token+5); i < n; ++i) {
			result += tokens.get(i).toString();
			result += " ";
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
			// Rule 28:  impliesExpCS ::= impliesExpCS implies andOrXorExpCS
			//
			case 28:
 
			//
			// Rule 29:  impliesWithLet ::= impliesExpCS implies andOrXorWithLet
			//
			case 29:
 
			//
			// Rule 32:  andOrXorExpCS ::= andOrXorExpCS and equalityExpCS
			//
			case 32:
 
			//
			// Rule 33:  andOrXorExpCS ::= andOrXorExpCS or equalityExpCS
			//
			case 33:
 
			//
			// Rule 34:  andOrXorExpCS ::= andOrXorExpCS xor equalityExpCS
			//
			case 34:
 
			//
			// Rule 35:  andOrXorWithLet ::= andOrXorExpCS and equalityWithLet
			//
			case 35:
 
			//
			// Rule 36:  andOrXorWithLet ::= andOrXorExpCS or equalityWithLet
			//
			case 36:
 
			//
			// Rule 37:  andOrXorWithLet ::= andOrXorExpCS xor equalityWithLet
			//
			case 37: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							getTokenText(dtParser.getToken(2))
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
			// Rule 40:  equalityExpCS ::= equalityExpCS = relationalExpCS
			//
			case 40:
 
			//
			// Rule 41:  equalityWithLet ::= equalityExpCS = relationalWithLet
			//
			case 41: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.EQUAL)
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
			// Rule 42:  equalityExpCS ::= equalityExpCS <> relationalExpCS
			//
			case 42:
 
			//
			// Rule 43:  equalityWithLet ::= equalityExpCS <> relationalWithLet
			//
			case 43: {
				
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
			// Rule 46:  relationalExpCS ::= relationalExpCS > ifExpCSPrec
			//
			case 46:
 
			//
			// Rule 47:  relationalWithLet ::= relationalExpCS > additiveWithLet
			//
			case 47: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.GREATER_THAN)
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
			// Rule 48:  relationalExpCS ::= relationalExpCS < ifExpCSPrec
			//
			case 48:
 
			//
			// Rule 49:  relationalWithLet ::= relationalExpCS < additiveWithLet
			//
			case 49: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.LESS_THAN)
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
			// Rule 50:  relationalExpCS ::= relationalExpCS >= ifExpCSPrec
			//
			case 50:
 
			//
			// Rule 51:  relationalWithLet ::= relationalExpCS >= additiveWithLet
			//
			case 51: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.GREATER_THAN_EQUAL)
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
			// Rule 52:  relationalExpCS ::= relationalExpCS <= ifExpCSPrec
			//
			case 52:
 
			//
			// Rule 53:  relationalWithLet ::= relationalExpCS <= additiveWithLet
			//
			case 53: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.LESS_THAN_EQUAL)
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
			// Rule 57:  additiveExpCS ::= additiveExpCS + multiplicativeExpCS
			//
			case 57:
 
			//
			// Rule 58:  additiveWithLet ::= additiveExpCS + multiplicativeWithLet
			//
			case 58: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.PLUS)
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
			// Rule 59:  additiveExpCS ::= additiveExpCS - multiplicativeExpCS
			//
			case 59:
 
			//
			// Rule 60:  additiveWithLet ::= additiveExpCS - multiplicativeWithLet
			//
			case 60: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.MINUS)
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
			// Rule 63:  multiplicativeExpCS ::= multiplicativeExpCS * unaryExpCS
			//
			case 63:
 
			//
			// Rule 64:  multiplicativeWithLet ::= multiplicativeExpCS * unaryWithLet
			//
			case 64: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.TIMES)
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
			// Rule 65:  multiplicativeExpCS ::= multiplicativeExpCS / unaryExpCS
			//
			case 65:
 
			//
			// Rule 66:  multiplicativeWithLet ::= multiplicativeExpCS / unaryWithLet
			//
			case 66: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.DIVIDE)
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
			// Rule 69:  unaryExpCS ::= - unaryExpCS
			//
			case 69: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.MINUS)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						simpleNameCS,
						new BasicEList()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 70:  unaryExpCS ::= not unaryExpCS
			//
			case 70: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						simpleNameCS,
						new BasicEList()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 72:  dotArrowExpCS ::= dotArrowExpCS callExpCS
			//
			case 72: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setSource((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, (CSTNode)dtParser.getSym(1), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 73:  dotArrowExpCS ::= dotArrowExpCS messageExpCS
			//
			case 73: {
				
				MessageExpCS result = (MessageExpCS)dtParser.getSym(2);
				result.setTarget((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 74:  dotArrowExpCS ::= NUMERIC_OPERATION ( argumentsCSopt )
			//
			case 74: {
				
				// NUMERIC_OPERATION -> Integer '.' Identifier
				String text = getTokenText(dtParser.getToken(1));
				int index = text.indexOf('.');
				String integer = text.substring(0, index);
				String simpleName = text.substring(index + 1);

				// create the IntegerLiteralExpCS
				int startOffset = getIToken(dtParser.getToken(1)).getStartOffset();
				int endOffset = startOffset + integer.length() - 1; // inclusive

				IntegerLiteralExpCS integerLiteralExpCS = createIntegerLiteralExpCS(integer);
				integerLiteralExpCS.setStartOffset(startOffset);
				integerLiteralExpCS.setEndOffset(endOffset);

				startOffset = endOffset + 2; // end of integerLiteral + 1('.') + 1(start of simpleName)
				endOffset = getIToken(dtParser.getToken(1)).getEndOffset();

				// create the SimpleNameCS
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							simpleName
						);
				simpleNameCS.setStartOffset(startOffset);
				simpleNameCS.setEndOffset(endOffset);

				// create the OperationCallExpCS
				CSTNode result = createOperationCallExpCS(
						integerLiteralExpCS,
						simpleNameCS,
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 75:  dotArrowExpCS ::= pathNameCS :: simpleNameCS ( argumentsCSopt )
			//
			case 75: {
				
				OperationCallExpCS result = createOperationCallExpCS(
						(PathNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3),
						(EList)dtParser.getSym(5)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(6)));
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 80:  oclExpCS ::= ( oclExpressionCS )
			//
			case 80: {
				
				CSTNode result = (CSTNode)dtParser.getSym(2);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 81:  variableExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 81: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 82:  variableExpCS ::= keywordAsIdentifier1 isMarkedPreCS
			//
			case 82: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createVariableExpCS(
						simpleNameCS,
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(2));
				} else {
					setOffsets(result, getIToken(dtParser.getToken(1)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 84:  simpleNameCS ::= self
			//
			case 84: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.SELF_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 85:  simpleNameCS ::= IDENTIFIER
			//
			case 85: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 86:  primitiveTypeCS ::= Integer
			//
			case 86: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INTEGER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 87:  primitiveTypeCS ::= UnlimitedNatural
			//
			case 87: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 88:  primitiveTypeCS ::= String
			//
			case 88: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.STRING_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 89:  primitiveTypeCS ::= Real
			//
			case 89: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.REAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 90:  primitiveTypeCS ::= Boolean
			//
			case 90: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.BOOLEAN_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 91:  primitiveTypeCS ::= OclAny
			//
			case 91: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_ANY_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 92:  primitiveTypeCS ::= OclVoid
			//
			case 92: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_VOID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 93:  primitiveTypeCS ::= Invalid
			//
			case 93: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INVALID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 94:  primitiveTypeCS ::= OclMessage
			//
			case 94: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_MESSAGE_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 95:  pathNameCS ::= IDENTIFIER
			//
			case 95: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 96:  pathNameCS ::= pathNameCS :: simpleNameCS
			//
			case 96: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 97:  pathNameCSOpt ::= $Empty
			//
			case 97: {
				
				CSTNode result = createPathNameCS();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 105:  enumLiteralExpCS ::= pathNameCS :: keywordAsIdentifier
			//
			case 105: {
				
				CSTNode result = createEnumLiteralExpCS(
						(PathNameCS)dtParser.getSym(1),
						getTokenText(dtParser.getToken(3))
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 106:  enumLiteralExpCS ::= pathNameCS :: simpleNameCS
			//
			case 106: {
				
				CSTNode result = createEnumLiteralExpCS(
						(PathNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 107:  collectionLiteralExpCS ::= collectionTypeIdentifierCS { collectionLiteralPartsCSopt }
			//
			case 107: {
				
				Object[] objs = (Object[])dtParser.getSym(1);
				CSTNode result = createCollectionLiteralExpCS(
						(CollectionTypeIdentifierEnum)objs[1],
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, (IToken)objs[0], getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 108:  collectionTypeIdentifierCS ::= Set
			//
			case 108: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.SET_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 109:  collectionTypeIdentifierCS ::= Bag
			//
			case 109: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.BAG_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 110:  collectionTypeIdentifierCS ::= Sequence
			//
			case 110: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.SEQUENCE_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 111:  collectionTypeIdentifierCS ::= Collection
			//
			case 111: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.COLLECTION_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 112:  collectionTypeIdentifierCS ::= OrderedSet
			//
			case 112: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 113:  collectionLiteralPartsCSopt ::= $Empty
			//
			case 113:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 115:  collectionLiteralPartsCS ::= collectionLiteralPartCS
			//
			case 115: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 116:  collectionLiteralPartsCS ::= collectionLiteralPartsCS , collectionLiteralPartCS
			//
			case 116: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 118:  collectionLiteralPartCS ::= oclExpressionCS
			//
			case 118: {
				
				CSTNode result = createCollectionLiteralPartCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 119:  collectionRangeCS ::= - INTEGER_RANGE_START oclExpressionCS
			//
			case 119: {
				
				OCLExpressionCS rangeStart = createRangeStart(
						getTokenText(dtParser.getToken(2)), true);
				CSTNode result = createCollectionRangeCS(
						rangeStart,
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, rangeStart, (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 120:  collectionRangeCS ::= INTEGER_RANGE_START oclExpressionCS
			//
			case 120: {
				
				OCLExpressionCS rangeStart = createRangeStart(
						getTokenText(dtParser.getToken(1)), false);
				CSTNode result = createCollectionRangeCS(
						rangeStart,
						(OCLExpressionCS)dtParser.getSym(2)
					);
				setOffsets(result, rangeStart, (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 121:  collectionRangeCS ::= oclExpressionCS .. oclExpressionCS
			//
			case 121: {
				
				CSTNode result = createCollectionRangeCS(
						(OCLExpressionCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 127:  tupleLiteralExpCS ::= Tuple { variableListCS2 }
			//
			case 127: {
				
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 128:  integerLiteralExpCS ::= INTEGER_LITERAL
			//
			case 128: {
				
				CSTNode result = createIntegerLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 129:  unlimitedNaturalLiteralExpCS ::= *
			//
			case 129: {
				
				CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 130:  realLiteralExpCS ::= REAL_LITERAL
			//
			case 130: {
				
				CSTNode result = createRealLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 131:  stringLiteralExpCS ::= STRING_LITERAL
			//
			case 131: {
				
				CSTNode result = createStringLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 132:  booleanLiteralExpCS ::= true
			//
			case 132: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 133:  booleanLiteralExpCS ::= false
			//
			case 133: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 134:  nullLiteralExpCS ::= null
			//
			case 134: {
				
				CSTNode result = createNullLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 135:  invalidLiteralExpCS ::= OclInvalid
			//
			case 135: {
				
				CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 136:  callExpCS ::= -> featureCallExpCS
			//
			case 136:
 
			//
			// Rule 137:  callExpCS ::= -> loopExpCS
			//
			case 137: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 138:  callExpCS ::= . keywordOperationCallExpCS
			//
			case 138:
 
			//
			// Rule 139:  callExpCS ::= . featureCallExpCS
			//
			case 139: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 142:  iteratorExpCS ::= forAll ( iterContents )
			//
			case 142:
 
			//
			// Rule 143:  iteratorExpCS ::= exists ( iterContents )
			//
			case 143:
 
			//
			// Rule 144:  iteratorExpCS ::= isUnique ( iterContents )
			//
			case 144:
 
			//
			// Rule 145:  iteratorExpCS ::= one ( iterContents )
			//
			case 145:
 
			//
			// Rule 146:  iteratorExpCS ::= any ( iterContents )
			//
			case 146:
 
			//
			// Rule 147:  iteratorExpCS ::= collect ( iterContents )
			//
			case 147:
 
			//
			// Rule 148:  iteratorExpCS ::= select ( iterContents )
			//
			case 148:
 
			//
			// Rule 149:  iteratorExpCS ::= reject ( iterContents )
			//
			case 149:
 
			//
			// Rule 150:  iteratorExpCS ::= collectNested ( iterContents )
			//
			case 150:
 
			//
			// Rule 151:  iteratorExpCS ::= sortedBy ( iterContents )
			//
			case 151:
 
			//
			// Rule 152:  iteratorExpCS ::= closure ( iterContents )
			//
			case 152: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				Object[] iterContents = (Object[])dtParser.getSym(3);
				CSTNode result = createIteratorExpCS(
						simpleNameCS,
						(VariableCS)iterContents[0],
						(VariableCS)iterContents[1],
						(OCLExpressionCS)iterContents[2]
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 153:  iterContents ::= oclExpressionCS
			//
			case 153: {
				
				dtParser.setSym1(new Object[] {
						null,
						null,
						dtParser.getSym(1)
					});
	  		  break;
			}
	 
			//
			// Rule 154:  iterContents ::= variableCS | oclExpressionCS
			//
			case 154: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						null,
						dtParser.getSym(3)
					});
	  		  break;
			}
	 
			//
			// Rule 155:  iterContents ::= variableCS , variableCS | oclExpressionCS
			//
			case 155: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						dtParser.getSym(3),
						dtParser.getSym(5)
					});
	  		  break;
			}
	 
			//
			// Rule 156:  iterateExpCS ::= iterate ( variableCS | oclExpressionCS )
			//
			case 156: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createIterateExpCS(
						simpleNameCS,
						(VariableCS)dtParser.getSym(3),
						null,
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 157:  iterateExpCS ::= iterate ( variableCS ; variableCS | oclExpressionCS )
			//
			case 157: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createIterateExpCS(
						simpleNameCS,
						(VariableCS)dtParser.getSym(3),
						(VariableCS)dtParser.getSym(5),
						(OCLExpressionCS)dtParser.getSym(7)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(8)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 158:  variableCS ::= IDENTIFIER
			//
			case 158: {
				
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
			// Rule 159:  variableCS ::= IDENTIFIER : typeCS
			//
			case 159: {
				
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
			// Rule 160:  variableCS ::= IDENTIFIER : typeCS = oclExpressionCS
			//
			case 160: {
				
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
			// Rule 161:  variableCS2 ::= IDENTIFIER = oclExpressionCS
			//
			case 161: {
				
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
			// Rule 166:  collectionTypeCS ::= collectionTypeIdentifierCS ( typeCS )
			//
			case 166: {
				
				Object[] objs = (Object[])dtParser.getSym(1);
				CSTNode result = createCollectionTypeCS(
						(CollectionTypeIdentifierEnum)objs[1],
						(TypeCS)dtParser.getSym(3)
					);
				setOffsets(result, (IToken)objs[0], getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 167:  tupleTypeCS ::= Tuple ( variableListCSopt )
			//
			case 167: {
				
				CSTNode result = createTupleTypeCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 168:  variableListCSopt ::= $Empty
			//
			case 168:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 170:  variableListCS ::= variableCS
			//
			case 170: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 171:  variableListCS ::= variableListCS , variableCS
			//
			case 171: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 172:  variableListCS2 ::= variableCS2
			//
			case 172:
 
			//
			// Rule 173:  variableListCS2 ::= variableCS
			//
			case 173: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 174:  variableListCS2 ::= variableListCS2 , variableCS2
			//
			case 174:
 
			//
			// Rule 175:  variableListCS2 ::= variableListCS2 , variableCS
			//
			case 175: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 178:  featureCallExpCS ::= MINUS isMarkedPreCS ( argumentsCSopt )
			//
			case 178:
 
			//
			// Rule 179:  featureCallExpCS ::= not isMarkedPreCS ( argumentsCSopt )
			//
			case 179: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createOperationCallExpCS(
						simpleNameCS,
						(IsMarkedPreCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 180:  operationCallExpCS ::= simpleNameCS isMarkedPreCS ( argumentsCSopt )
			//
			case 180: {
				
				CSTNode result = createOperationCallExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(IsMarkedPreCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 181:  operationCallExpCS ::= oclIsUndefined isMarkedPreCS ( argumentsCSopt )
			//
			case 181:
 
			//
			// Rule 182:  operationCallExpCS ::= oclIsInvalid isMarkedPreCS ( argumentsCSopt )
			//
			case 182:
 
			//
			// Rule 183:  operationCallExpCS ::= oclIsNew isMarkedPreCS ( argumentsCSopt )
			//
			case 183:
 
			//
			// Rule 184:  operationCallExpCS ::= EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 184:
 
			//
			// Rule 185:  operationCallExpCS ::= NOT_EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 185:
 
			//
			// Rule 186:  operationCallExpCS ::= PLUS isMarkedPreCS ( argumentsCSopt )
			//
			case 186:
 
			//
			// Rule 187:  operationCallExpCS ::= MULTIPLY isMarkedPreCS ( argumentsCSopt )
			//
			case 187:
 
			//
			// Rule 188:  operationCallExpCS ::= DIVIDE isMarkedPreCS ( argumentsCSopt )
			//
			case 188:
 
			//
			// Rule 189:  operationCallExpCS ::= GREATER isMarkedPreCS ( argumentsCSopt )
			//
			case 189:
 
			//
			// Rule 190:  operationCallExpCS ::= LESS isMarkedPreCS ( argumentsCSopt )
			//
			case 190:
 
			//
			// Rule 191:  operationCallExpCS ::= GREATER_EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 191:
 
			//
			// Rule 192:  operationCallExpCS ::= LESS_EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 192:
 
			//
			// Rule 193:  operationCallExpCS ::= and isMarkedPreCS ( argumentsCSopt )
			//
			case 193:
 
			//
			// Rule 194:  operationCallExpCS ::= or isMarkedPreCS ( argumentsCSopt )
			//
			case 194:
 
			//
			// Rule 195:  operationCallExpCS ::= xor isMarkedPreCS ( argumentsCSopt )
			//
			case 195:
 
			//
			// Rule 196:  keywordOperationCallExpCS ::= keywordAsIdentifier isMarkedPreCS ( argumentsCSopt )
			//
			case 196: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createOperationCallExpCS(
						simpleNameCS,
						(IsMarkedPreCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 197:  operationCallExpCS ::= oclIsInState isMarkedPreCS ( pathNameCSOpt )
			//
			case 197: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));

				PathNameCS pathNameCS = (PathNameCS) dtParser.getSym(4);
				StateExpCS stateExpCS = createStateExpCS(pathNameCS);
				setOffsets(stateExpCS, pathNameCS);
			
				CSTNode result = createOperationCallExpCS(
						simpleNameCS,
						(IsMarkedPreCS)dtParser.getSym(2),
						stateExpCS
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 198:  attrOrNavCallExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 198: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
				CSTNode result = createFeatureCallExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 199:  attrOrNavCallExpCS ::= keywordAsIdentifier isMarkedPreCS
			//
			case 199: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createFeatureCallExpCS(
						simpleNameCS,
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(2));
				} else {
					setOffsets(result, getIToken(dtParser.getToken(1)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 200:  isMarkedPreCS ::= $Empty
			//
			case 200: {
				
				CSTNode result = createIsMarkedPreCS(false);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 201:  isMarkedPreCS ::= @pre
			//
			case 201: {
				
				CSTNode result = createIsMarkedPreCS(true);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 202:  argumentsCSopt ::= $Empty
			//
			case 202:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 204:  argumentsCS ::= oclExpressionCS
			//
			case 204: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 205:  argumentsCS ::= argumentsCS , oclExpressionCS
			//
			case 205: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 206:  letExpCS ::= let variableCS letExpSubCSopt in oclExpressionCS
			//
			case 206: {
				
				EList variables = (EList)dtParser.getSym(3);
				variables.add(0, dtParser.getSym(2));
				CSTNode result = createLetExpCS(
						variables,
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(5));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 207:  letExpSubCSopt ::= $Empty
			//
			case 207:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 209:  letExpSubCS ::= , variableCS
			//
			case 209: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 210:  letExpSubCS ::= letExpSubCS , variableCS
			//
			case 210: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 211:  messageExpCS ::= ^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 211:
 
			//
			// Rule 212:  messageExpCS ::= ^^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 212: {
				
				CSTNode result = createMessageExpCS(
						getIToken(dtParser.getToken(1)).getKind() == LightweightTypeParsersym.TK_CARET,
						(SimpleNameCS)dtParser.getSym(2),
						(EList<OCLMessageArgCS>)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 213:  oclMessageArgumentsCSopt ::= $Empty
			//
			case 213:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 215:  oclMessageArgumentsCS ::= oclMessageArgCS
			//
			case 215: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 216:  oclMessageArgumentsCS ::= oclMessageArgumentsCS , oclMessageArgCS
			//
			case 216: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 217:  oclMessageArgCS ::= oclExpressionCS
			//
			case 217: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 218:  oclMessageArgCS ::= ?
			//
			case 218: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 219:  oclMessageArgCS ::= ? : typeCS
			//
			case 219: {
				
				CSTNode result = createOCLMessageArgCS(
						(TypeCS)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 220:  qualifierList ::= $Empty
			//
			case 220:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 221:  qualifierList ::= qualifierList qualifier
			//
			case 221: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 222:  qualifier ::= blackbox
			//
			case 222:
 
			//
			// Rule 223:  qualifier ::= abstract
			//
			case 223:
 
			//
			// Rule 224:  qualifier ::= static
			//
			case 224: {
				
				CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 225:  colon_param_listOpt ::= $Empty
			//
			case 225:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 226:  colon_param_listOpt ::= : param_list
			//
			case 226: {
				
				dtParser.setSym1(dtParser.getSym(2));
	  		  break;
			}
	 
			//
			// Rule 227:  complete_signature ::= simple_signature colon_param_listOpt
			//
			case 227: {
				
				SimpleSignatureCS simpleSignatureCS = (SimpleSignatureCS)dtParser.getSym(1);
				EList<ParameterDeclarationCS> resultList = (EList<ParameterDeclarationCS>)dtParser.getSym(2);
				CSTNode result = createCompleteSignatureCS(simpleSignatureCS, resultList);
				result.setStartOffset(simpleSignatureCS.getStartOffset());
				result.setEndOffset(getEndOffset(simpleSignatureCS.getEndOffset(), resultList));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 228:  simple_signatureOpt ::= $Empty
			//
			case 228:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 230:  simple_signature ::= ( param_listOpt )
			//
			case 230: {
				
				CSTNode result = createSimpleSignatureCS((EList<ParameterDeclarationCS>)dtParser.getSym(2));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 231:  param_listOpt ::= $Empty
			//
			case 231:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 233:  param_list ::= param_list qvtErrorToken
			//
			case 233: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 234:  param_list ::= param_list , param
			//
			case 234: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 235:  param_list ::= param
			//
			case 235: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 236:  param ::= param_directionOpt IDENTIFIER : typespec
			//
			case 236: {
				
				CSTNode result = createParameterDeclarationCS(
						(DirectionKindCS)dtParser.getSym(1),
						getIToken(dtParser.getToken(2)),
						(TypeSpecCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(2)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 237:  param ::= param_directionOpt typespec
			//
			case 237: {
				
				CSTNode result = createParameterDeclarationCS(
						(DirectionKindCS)dtParser.getSym(1),
						null,
						(TypeSpecCS)dtParser.getSym(2)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 238:  param_directionOpt ::= $Empty
			//
			case 238:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 240:  param_direction ::= in
			//
			case 240: {
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.IN
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 241:  param_direction ::= out
			//
			case 241: {
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.OUT
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 242:  param_direction ::= inout
			//
			case 242: {
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.INOUT
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 243:  declarator ::= IDENTIFIER : typeCS
			//
			case 243: {
				
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
			// Rule 244:  declarator ::= IDENTIFIER : typeCS = oclExpressionCS
			//
			case 244: {
				
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
			// Rule 245:  declarator ::= IDENTIFIER : typeCS := oclExpressionCS
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
			// Rule 246:  declarator ::= IDENTIFIER := oclExpressionCS
			//
			case 246: {
				
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
			// Rule 247:  typespec ::= typeCS
			//
			case 247: {
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)dtParser.getSym(1),
					null
					);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 248:  typespec ::= typeCS @ IDENTIFIER
			//
			case 248: {
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)dtParser.getSym(1),
					getIToken(dtParser.getToken(3))
					);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 250:  listTypeCS ::= List ( typeCS )
			//
			case 250: {
				
				CSTNode result = createListTypeCS(
						(TypeCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 254:  scoped_identifier ::= typeCS2 :: IDENTIFIER
			//
			case 254: {
				
				ScopedNameCS result = createScopedNameCS((TypeCS)dtParser.getSym(1), getTokenText(dtParser.getToken(3)));		
				setOffsets(result, (CSTNode) dtParser.getSym(1), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 255:  scoped_identifier ::= typeCS2 :: qvtErrorToken
			//
			case 255: {
				
				ScopedNameCS result = createScopedNameCS((TypeCS)dtParser.getSym(1), ""); //$NON-NLS-1$		
				setOffsets(result, (CSTNode) dtParser.getSym(1), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 256:  scoped_identifier ::= scoped_identifier2
			//
			case 256: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
                                    String name = pathNameCS.getSequenceOfNames().remove(pathNameCS.getSequenceOfNames().size() - 1);
				TypeCS typeCS = pathNameCS.getSequenceOfNames().isEmpty() ? null : pathNameCS;

				ScopedNameCS result = createScopedNameCS(typeCS, name);		

				setOffsets(result, pathNameCS);

                                    // reduce the region by the removed name element
				pathNameCS.setEndOffset(pathNameCS.getEndOffset() - (name != null ? name.length() : 0) - 2);
				
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 257:  scoped_identifier2 ::= IDENTIFIER
			//
			case 257: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 258:  scoped_identifier2 ::= main
			//
			case 258: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 259:  scoped_identifier2 ::= scoped_identifier2 :: IDENTIFIER
			//
			case 259: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 260:  scoped_identifier2 ::= scoped_identifier2 :: qvtErrorToken
			//
			case 260: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, "");
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 261:  scoped_identifier_list ::= scoped_identifier
			//
			case 261: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 262:  scoped_identifier_list ::= scoped_identifier_list , scoped_identifier
			//
			case 262: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 266:  expression_semi_list ::= statementCS
			//
			case 266: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 267:  expression_semi_list ::= expression_semi_list ; statementCS
			//
			case 267: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 268:  expression_block ::= { statementListOpt }
			//
			case 268: {
				
			EList bodyList = (EList) dtParser.getSym(2);
			CSTNode result = createBlockExpCS(
				bodyList
			);
			
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
			dtParser.setSym1(result);
      		  break;
			}
	 
			//
			// Rule 272:  qualifiedNameCS ::= qvtIdentifierCS
			//
			case 272: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 273:  qualifiedNameCS ::= qualifiedNameCS . qvtIdentifierCS
			//
			case 273: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 274:  qualifiedNameCS ::= qualifiedNameCS . qvtErrorToken
			//
			case 274: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, "");
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 275:  qualifiedNameCS ::= qualifiedNameCS qvtErrorToken
			//
			case 275: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}	
	 
			//
			// Rule 277:  oclExpressionCSOpt ::= $Empty
			//
			case 277:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 278:  statementListOpt ::= $Empty
			//
			case 278:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 280:  statementList ::= qvtErrorToken
			//
			case 280: {
				
				EList result = new BasicEList();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 283:  statementInnerList ::= statementCS
			//
			case 283: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 284:  statementInnerList ::= statementInnerList ; statementCS
			//
			case 284: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 285:  statementInnerList ::= statementInnerList qvtErrorToken
			//
			case 285: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 286:  statementCS ::= oclExpressionCS
			//
			case 286: {
				
				CSTNode result = createExpressionStatementCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 287:  statementCS ::= primaryOCLExpressionCS
			//
			case 287: {
				
				CSTNode result = createExpressionStatementCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 290:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS else ifExpBodyCS endif
			//
			case 290: {
				
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
			// Rule 291:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS endif
			//
			case 291: {
				
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
			// Rule 292:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS else ifExpBodyCS qvtErrorToken
			//
			case 292: {
				
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
			// Rule 293:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS else qvtErrorToken
			//
			case 293: {
				
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
			// Rule 294:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS qvtErrorToken
			//
			case 294: {
				
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
			// Rule 295:  ifExpCS ::= if oclExpressionCS then qvtErrorToken
			//
			case 295: {
				
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
			// Rule 296:  ifExpCS ::= if oclExpressionCS qvtErrorToken
			//
			case 296: {
				
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
			// Rule 297:  ifExpCS ::= if qvtErrorToken
			//
			case 297: {
				
				CSTNode result = createIfExpCS(
						null,
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 299:  letExpSubCS3 ::= variableCS2
			//
			case 299: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 300:  letExpSubCS3 ::= letExpSubCS3 , variableCS2
			//
			case 300: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 301:  letExpCS ::= let letExpSubCS3 in oclExpressionCS
			//
			case 301: {
				
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
			// Rule 302:  letExpCS ::= let letExpSubCS3 in qvtErrorToken
			//
			case 302: {
				
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
			// Rule 303:  iterContents ::= variableCS | qvtErrorToken
			//
			case 303: {
				
				CSTNode fakeCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, ""); //$NON-NLS-1$
				setOffsets(fakeCS, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						null,
						fakeCS
					});
	  		  break;
			}
	 
			//
			// Rule 304:  callExpCS ::= . qvtErrorToken
			//
			case 304: {
				
				CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
	 			result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 305:  callExpCS ::= -> qvtErrorToken
			//
			case 305: {
				
				CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
	 			result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 306:  argumentsCS ::= qvtErrorToken
			//
			case 306:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 319:  iteratorExpCS ::= iteratorExpCSToken ( qvtErrorToken
			//
			case 319: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createIteratorExpCS(
						simpleNameCS,
						null,
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 320:  operationCallExpCS ::= oclAsType isMarkedPreCS ( typeCS )
			//
			case 320:
 
			//
			// Rule 321:  operationCallExpCS ::= oclIsKindOf isMarkedPreCS ( typeCS )
			//
			case 321:
 
			//
			// Rule 322:  operationCallExpCS ::= oclIsTypeOf isMarkedPreCS ( typeCS )
			//
			case 322: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				EList params = new BasicEList();
				params.add(dtParser.getSym(4));
				CSTNode result = createOperationCallExpCS(
						simpleNameCS,
						(IsMarkedPreCS)dtParser.getSym(2),
						params
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 325:  qvtErrorToken ::= ERROR_TOKEN
			//
			case 325: {
				
				diagnozeErrorToken(dtParser.getToken(1));
	  		  break;
			}
	 
			//
			// Rule 326:  equalityExpCS ::= equalityExpCS != relationalExpCS
			//
			case 326:
 
			//
			// Rule 327:  equalityWithLet ::= equalityExpCS != relationalWithLet
			//
			case 327: {
				
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
			// Rule 328:  _import ::= import library unit ;
			//
			case 328: {
				
				CSTNode result = createLibraryImportCS(
						(PathNameCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 329:  transformation_h ::= qualifierList transformation qualifiedNameCS
			//
			case 329: {
				
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
			// Rule 331:  renaming ::= rename typeCS . qvtIdentifierCS = stringLiteralExpCS ;
			//
			case 331: {
				
				CSTNode result = createRenameCS(
						(TypeCS)dtParser.getSym(2),
						getIToken(dtParser.getToken(4)),
						(StringLiteralExpCS)dtParser.getSym(6)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 333:  legacyWhileExpCS ::= while ( oclExpressionCS ; oclExpressionCS ) whileBodyCS
			//
			case 333: {
				
				CSTNode result = createLegacyWhileExpCS(
						(OCLExpressionCS)dtParser.getSym(3),
						(OCLExpressionCS)dtParser.getSym(5),
						(BlockExpCS)dtParser.getSym(7)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(7));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 335:  dictTypeCS ::= Dict ( typeCS , typeCS )
			//
			case 335: {
				
				CSTNode result = createDictTypeCS((TypeCS)dtParser.getSym(3), (TypeCS)dtParser.getSym(5));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 336:  dictLiteralCS ::= Dict { dictLiteralPartListCSopt }
			//
			case 336: {
				
				CSTNode result = createDictLiteralExpCS((EList<DictLiteralPartCS>)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 340:  dictLiteralPartCS ::= literalSimpleCS = oclExpressionCS
			//
			case 340: {
				
				CSTNode result = createDictLiteralPartCS((LiteralExpCS)dtParser.getSym(1), (OCLExpressionCS)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 342:  dictLiteralPartListCSopt ::= $Empty
			//
			case 342:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 343:  dictLiteralPartListCS ::= dictLiteralPartCS
			//
			case 343: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 344:  dictLiteralPartListCS ::= dictLiteralPartListCS , dictLiteralPartCS
			//
			case 344: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 346:  returnExpCS ::= return oclExpressionCSOpt
			//
			case 346: {
				
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
			// Rule 350:  variableInitializationCSCorrect ::= var IDENTIFIER : typeCS := oclExpressionCS
			//
			case 350: {
				
				CSTNode result = createVariableInitializationCS(
						getIToken(dtParser.getToken(2)),
						(TypeCS)dtParser.getSym(4),
						(OCLExpressionCS)dtParser.getSym(6)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(6));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 351:  variableInitializationCS ::= var IDENTIFIER : typeCS := qvtErrorToken
			//
			case 351: {
				
				CSTNode result = createVariableInitializationCS(
						getIToken(dtParser.getToken(2)),
						(TypeCS)dtParser.getSym(4),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 352:  variableInitializationCSCorrect ::= var IDENTIFIER := oclExpressionCS
			//
			case 352: {
				
				CSTNode result = createVariableInitializationCS(
						getIToken(dtParser.getToken(2)),
						null,
						(OCLExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 353:  variableInitializationCS ::= var IDENTIFIER := qvtErrorToken
			//
			case 353: {
				
				CSTNode result = createVariableInitializationCS(
						getIToken(dtParser.getToken(2)),
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 354:  variableInitializationCSCorrect ::= var IDENTIFIER : typeCS
			//
			case 354: {
				
				CSTNode result = createVariableInitializationCS(
						getIToken(dtParser.getToken(2)),
						(TypeCS)dtParser.getSym(4),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 355:  variableInitializationCS ::= var IDENTIFIER : qvtErrorToken
			//
			case 355: {
				
				CSTNode result = createVariableInitializationCS(
						getIToken(dtParser.getToken(2)),
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 356:  assignStatementCS ::= oclExpressionCS := oclExpressionCS
			//
			case 356: {
				
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
			// Rule 357:  assignStatementCS ::= oclExpressionCS := qvtErrorToken
			//
			case 357: {
				
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
			// Rule 358:  assignStatementCS ::= oclExpressionCS += oclExpressionCS
			//
			case 358: {
				
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
			// Rule 359:  assignStatementCS ::= oclExpressionCS += qvtErrorToken
			//
			case 359: {
				
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
			// Rule 361:  whileExpCS ::= while ( declarator ; oclExpressionCS ) whileBodyCS
			//
			case 361: {
				
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
			// Rule 362:  whileExpCS ::= while ( oclExpressionCS ) whileBodyCS
			//
			case 362: {
				
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
			// Rule 366:  forExpDeclaratorList ::= IDENTIFIER
			//
			case 366: {
				
		EList result = new BasicEList();
		result.add(getIToken(dtParser.getToken(1)));
		dtParser.setSym1(result);
          		  break;
			}
    	 
			//
			// Rule 367:  forExpDeclaratorList ::= forExpDeclaratorList , IDENTIFIER
			//
			case 367: {
				
		EList result = (EList)dtParser.getSym(1);
		result.add(getIToken(dtParser.getToken(3)));
		dtParser.setSym1(result);
          		  break;
			}
    	 
			//
			// Rule 368:  forExpConditionOpt ::= $Empty
			//
			case 368:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 369:  forExpConditionOpt ::= | oclExpressionCS
			//
			case 369: {
				
            	    dtParser.setSym1((OCLExpressionCS)dtParser.getSym(2));
          		  break;
			}
    	 
			//
			// Rule 370:  forExpConditionOpt ::= | qvtErrorToken
			//
			case 370:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 371:  forExpCS ::= forOpCode ( forExpDeclaratorList forExpConditionOpt ) expression_block
			//
			case 371: {
				
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
			// Rule 372:  forExpCS ::= forOpCode qvtErrorToken
			//
			case 372: {
				
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
			// Rule 376:  switchExpCS ::= switch switchBodyExpCS
			//
			case 376: {
				
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
			// Rule 378:  switchDeclaratorCS ::= IDENTIFIER
			//
			case 378: {
				
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
			// Rule 379:  switchDeclaratorCS ::= IDENTIFIER = oclExpressionCS
			//
			case 379: {
				
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
			// Rule 380:  iterateSwitchExpCS ::= switch ( switchDeclaratorCS ) switchBodyExpCS
			//
			case 380: {
				
				Object[] switchBody = (Object[]) dtParser.getSym(5);

				OCLExpressionCS switchExpCS = (OCLExpressionCS) createSwitchExpCS(
						(EList<SwitchAltExpCS>) switchBody[0],
						(OCLExpressionCS) switchBody[1]							
					);
				if (switchBody[2] instanceof IToken) { // In case of correct and incorrect syntax
					setOffsets(switchExpCS, getIToken(dtParser.getToken(1)), (IToken) switchBody[2]);
				} else if (switchBody[2] instanceof CSTNode) { // In case of errors in switchBody
					setOffsets(switchExpCS, getIToken(dtParser.getToken(1)), (CSTNode) switchBody[2]);
				} else { // In case of errors in switchBody
					setOffsets(switchExpCS, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				}

				EList<VariableCS> iterators = new BasicEList<VariableCS>();
				iterators.add((VariableCS) dtParser.getSym(3));
				CSTNode result = createImperativeIterateExpCS(
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "xcollect"), //$NON-NLS-1$
						iterators,
						null,
						switchExpCS,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 381:  switchExpCS ::= switch qvtErrorToken
			//
			case 381: {
				
				CSTNode result = createSwitchExpCS(
						new BasicEList(),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 382:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt }
			//
			case 382: {
				
				Object[] result = new Object[] {dtParser.getSym(2), dtParser.getSym(3), getIToken(dtParser.getToken(4))};
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 383:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt qvtErrorToken
			//
			case 383: {
				
				Object[] result = new Object[] {dtParser.getSym(2), dtParser.getSym(3), dtParser.getSym(3)};
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 384:  switchBodyExpCS ::= { qvtErrorToken
			//
			case 384: {
				
				Object[] result = new Object[] {new BasicEList(), null, getIToken(dtParser.getToken(1))};
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 385:  switchAltExpCSList ::= switchAltExpCS
			//
			case 385: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 386:  switchAltExpCSList ::= switchAltExpCSList switchAltExpCS
			//
			case 386: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 387:  switchAltExpCS ::= ( oclExpressionCS ) ? statementCS ;
			//
			case 387: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(2),
						(OCLExpressionCS) dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 388:  switchAltExpCS ::= case ( oclExpressionCS ) expressionStatementCS
			//
			case 388: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(3),
						(OCLExpressionCS) dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 389:  switchAltExpCS ::= ( oclExpressionCS ) ? statementCS qvtErrorToken
			//
			case 389: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(2),
						(OCLExpressionCS) dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode) dtParser.getSym(5));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 390:  switchAltExpCS ::= ( oclExpressionCS ) qvtErrorToken
			//
			case 390: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(2),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 391:  switchAltExpCS ::= ( qvtErrorToken
			//
			case 391: {
				
				CSTNode result = createSwitchAltExpCS(
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 392:  switchElseExpCSOpt ::= $Empty
			//
			case 392:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 394:  switchElseExpCS ::= else ? statementCS ;
			//
			case 394: {
				
				dtParser.setSym1((CSTNode)dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 395:  switchElseExpCS ::= else expressionStatementCS
			//
			case 395: {
				
				dtParser.setSym1((CSTNode)dtParser.getSym(2));
	  		  break;
			}
	 
			//
			// Rule 396:  switchElseExpCS ::= else ? statementCS qvtErrorToken
			//
			case 396: {
				
				dtParser.setSym1((CSTNode)dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 397:  switchElseExpCS ::= else qvtErrorToken
			//
			case 397: {
				
				dtParser.setSym1(null);
	  		  break;
			}
	 
			//
			// Rule 399:  logWhenExp ::= when oclExpressionCS
			//
			case 399: {
				
			OCLExpressionCS condition = (OCLExpressionCS) dtParser.getSym(2);
			dtParser.setSym1(condition);
      		  break;
			}
     
			//
			// Rule 401:  logWhenExpOpt ::= $Empty
			//
			case 401:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 402:  logExpCS ::= log ( argumentsCSopt ) logWhenExpOpt
			//
			case 402: {
				
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
			// Rule 404:  severityKindCS ::= simpleNameCS
			//
			case 404: {
				
			dtParser.setSym1(dtParser.getSym(1));
	  		  break;
			}
	 
			//
			// Rule 406:  severityKindCSOpt ::= $Empty
			//
			case 406:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 407:  assertWithLogExp ::= with logExpCS
			//
			case 407: {
				
			LogExpCS logExp = (LogExpCS) dtParser.getSym(2);
			setOffsets(logExp, getIToken(dtParser.getToken(2)), logExp);
			dtParser.setSym1(logExp);
      		  break;
			}
     
			//
			// Rule 409:  assertWithLogExpOpt ::= $Empty
			//
			case 409:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 410:  assertExpCS ::= assert severityKindCSOpt ( oclExpressionCS ) assertWithLogExpOpt
			//
			case 410: {
				
			LogExpCS logExpCS = (LogExpCS)dtParser.getSym(6);
			OCLExpressionCS condition = (OCLExpressionCS)dtParser.getSym(4);
			AssertExpCS result = (AssertExpCS)createAssertExpCS(condition, (SimpleNameCS)dtParser.getSym(2), logExpCS);
	
			CSTNode end = logExpCS != null ? logExpCS : condition; 
			setOffsets(result, getIToken(dtParser.getToken(1)), end);
			dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 411:  computeExpCS ::= compute ( declarator ) expression_block
			//
			case 411: {
				
				CSTNode result = createComputeExpCS(
					(VariableCS) dtParser.getSym(3),
					(OCLExpressionCS) dtParser.getSym(5)
				);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 422:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken12 ( imperativeIterContents12 )
			//
			case 422:
 
			//
			// Rule 423:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken3 ( imperativeIterContents3 )
			//
			case 423: {
				
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
			// Rule 424:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken qvtErrorToken
			//
			case 424: {
				
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
			// Rule 425:  imperativeIterContents12 ::= oclExpressionCS
			//
			case 425: {
				
				dtParser.setSym1(new Object[] {
						ourEmptyEList,
						null,
						dtParser.getSym(1)
					});
	  		  break;
			}
	 
			//
			// Rule 426:  imperativeIterContents12 ::= variableListCS | oclExpressionCS
			//
			case 426: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						null,
						dtParser.getSym(3)
					});
	  		  break;
			}
	 
			//
			// Rule 427:  imperativeIterContents3 ::= variableListCS ; variableCS2 | oclExpressionCS
			//
			case 427: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						dtParser.getSym(3),
						dtParser.getSym(5)
					});
	  		  break;
			}
	 
			//
			// Rule 428:  exclamationOpt ::= $Empty
			//
			case 428:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 430:  declarator_vsep ::= IDENTIFIER |
			//
			case 430: {
				
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
			// Rule 431:  declarator_vsepOpt ::= $Empty
			//
			case 431:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 433:  callExpCS ::= -> featureCallExpCS exclamationOpt [ declarator_vsepOpt oclExpressionCS ]
			//
			case 433: {
				
	        String opCode = isTokenOfType(getIToken(dtParser.getToken(3)), LightweightTypeParsersym.TK_EXCLAMATION_MARK) ?  "collectselectOne" : "collectselect"; //$NON-NLS-1$ //$NON-NLS-2$ 
		SimpleNameCS simpleNameCS = createSimpleNameCS(
				SimpleTypeEnum.KEYWORD_LITERAL,
				opCode
				);
		setOffsets(simpleNameCS, getIToken(dtParser.getToken(4)), getIToken(dtParser.getToken(7)));
		VariableCS variableCS = (VariableCS) dtParser.getSym(5);
		CSTNode result = createImperativeIterateExpCS(
					simpleNameCS,
					ourEmptyEList,
					variableCS,
					(OCLExpressionCS) dtParser.getSym(2),
					(OCLExpressionCS) dtParser.getSym(6)
				);
		setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
		dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 434:  oclExpCS ::= oclExpCS exclamationOpt [ oclExpressionCS ]
			//
			case 434: {
				
			        String opCode = isTokenOfType(getIToken(dtParser.getToken(2)), LightweightTypeParsersym.TK_EXCLAMATION_MARK) ?  "selectOne" : "xselect"; //$NON-NLS-1$ //$NON-NLS-2$ 
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							opCode
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(3)), getIToken(dtParser.getToken(5)));
				CallExpCS result = createImperativeIterateExpCS(
						simpleNameCS,
						ourEmptyEList,
						null,
						null,
						(OCLExpressionCS) dtParser.getSym(4)
					);
				result.setSource((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 435:  dotArrowExpCS ::= dotArrowExpCS . featureCallExpCS exclamationOpt [ oclExpressionCS ]
			//
			case 435: {
				
				CallExpCS callExpCS = (CallExpCS)dtParser.getSym(3);
				callExpCS.setSource((OCLExpressionCS)dtParser.getSym(1));
				callExpCS.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				setOffsets(callExpCS, (CSTNode)dtParser.getSym(1), callExpCS);


			        String opCode = isTokenOfType(getIToken(dtParser.getToken(4)), LightweightTypeParsersym.TK_EXCLAMATION_MARK) ?  "selectOne" : "xselect"; //$NON-NLS-1$ //$NON-NLS-2$ 
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							opCode
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(5)), getIToken(dtParser.getToken(7)));
				CallExpCS result = createImperativeIterateExpCS(
						simpleNameCS,
						ourEmptyEList,
						null,
						null,
						(OCLExpressionCS) dtParser.getSym(6)
					);
				result.setSource(callExpCS);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 437:  newExpCS ::= new pathNameCS ( argumentsCSopt )
			//
			case 437: {
				
			OCLExpressionCS result = createNewRuleCallExpCS((PathNameCS)dtParser.getSym(2),(EList)dtParser.getSym(4));
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
			dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 438:  topLevel ::= unit_elementList
			//
			case 438: {
				
				EList<CSTNode> unitElements = (EList<CSTNode>)dtParser.getSym(1);
				dtParser.setSym1(setupTopLevel(unitElements));
	  		  break;
			}
	 
			//
			// Rule 440:  _import ::= import unit ;
			//
			case 440: {
				
				CSTNode result = createModuleImportCS(
						(PathNameCS)dtParser.getSym(2)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 441:  _import ::= import qvtErrorToken
			//
			case 441: {
				
				CSTNode result = createLibraryImportCS(
						createPathNameCS()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 443:  unit_elementList ::= unit_elementList unit_element
			//
			case 443: {
				
				EList list = (EList)dtParser.getSym(1);
				list.add(dtParser.getSym(2));
				dtParser.setSym1(list);
	  		  break;
			}
	 
			//
			// Rule 444:  unit_elementList ::= $Empty
			//
			case 444:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 455:  transformation_decl ::= transformation_h ;
			//
			case 455: {
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) dtParser.getSym(1);
				setOffsets(headerCS, headerCS, getIToken(dtParser.getToken(2)));
				MappingModuleCS moduleCS = createMappingModuleCS(headerCS, ourEmptyEList);
				setOffsets(moduleCS, headerCS);
				dtParser.setSym1(moduleCS);
	  		  break;
			}
	 
			//
			// Rule 456:  transformation_def ::= transformation_h { module_elementList } semicolonOpt
			//
			case 456: {
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) dtParser.getSym(1);
				MappingModuleCS moduleCS = createMappingModuleCS(headerCS, (EList) dtParser.getSym(3));
				setOffsets(moduleCS, headerCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(moduleCS);
	  		  break;
			}
	 
			//
			// Rule 459:  library_decl ::= library_h ;
			//
			case 459: {
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) dtParser.getSym(1);
				setOffsets(headerCS, headerCS, getIToken(dtParser.getToken(2)));
				MappingModuleCS moduleCS = createLibraryCS(headerCS, ourEmptyEList);
				setOffsets(moduleCS, headerCS);
				dtParser.setSym1(moduleCS);
	  		  break;
			}
	 
			//
			// Rule 460:  library_def ::= library_h { module_elementList } semicolonOpt
			//
			case 460: {
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) dtParser.getSym(1);
				MappingModuleCS moduleCS = createLibraryCS(headerCS, (EList) dtParser.getSym(3));
				setOffsets(moduleCS, headerCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(moduleCS);
	  		  break;
			}
	 
			//
			// Rule 461:  transformation_h ::= qualifierList transformation qualifiedNameCS transformation_signature transformation_usage_refineOpt
			//
			case 461: {
				
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
			// Rule 462:  transformation_usage_refineOpt ::= $Empty
			//
			case 462:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 467:  transformation_refine ::= refines moduleref
			//
			case 467: {
				
				CSTNode result = createTransformationRefineCS(
						(ModuleRefCS)dtParser.getSym(2)
					);
				setOffsets(result, (ModuleRefCS)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 468:  library_h ::= library qualifiedNameCS library_signatureOpt module_usageListOpt
			//
			case 468: {
				
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
			// Rule 469:  library_h ::= library qvtErrorToken
			//
			case 469: {
				
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
			// Rule 470:  library_signatureOpt ::= $Empty
			//
			case 470:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 473:  module_usageList ::= module_usage
			//
			case 473: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 474:  module_usageList ::= module_usageList module_usage
			//
			case 474: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 475:  module_usageListOpt ::= $Empty
			//
			case 475:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 479:  access_usage ::= access module_kindOpt moduleref_list
			//
			case 479: {
				
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
			// Rule 480:  extends_usage ::= extends module_kindOpt moduleref_list
			//
			case 480: {
				
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
			// Rule 481:  module_kindOpt ::= $Empty
			//
			case 481:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 483:  module_kind ::= transformation
			//
			case 483: {
				
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.TRANSFORMATION
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 484:  module_kind ::= library
			//
			case 484: {
				
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.LIBRARY
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 485:  moduleref_list ::= moduleref
			//
			case 485: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 486:  moduleref_list ::= moduleref_list , moduleref
			//
			case 486: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 487:  moduleref_list ::= moduleref_list qvtErrorToken
			//
			case 487: {
				
				EList result = (EList) dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 488:  moduleref ::= pathNameCS simple_signatureOpt
			//
			case 488: {
				
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
			// Rule 489:  module_elementList ::= module_elementList module_element
			//
			case 489: {
				
				EList list = (EList)dtParser.getSym(1);
				list.add(dtParser.getSym(2));
				dtParser.setSym1(list);
	  		  break;
			}
	 
			//
			// Rule 490:  module_elementList ::= $Empty
			//
			case 490:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 497:  _modeltype ::= metamodel stringLiteralExpCS ;
			//
			case 497: {
				
				CSTNode packageRefCS = createPackageRefCS(
						null,
						(StringLiteralExpCS)dtParser.getSym(2)
					);
				setOffsets(packageRefCS, (CSTNode)dtParser.getSym(2));
				
				EList packageRefList = new BasicEList();
				packageRefList.add(packageRefCS);
				ModelTypeCS result = createModelTypeCS(
						new Token(0, 0, 0),
						createStringLiteralExpCS("'strict'"),
						packageRefList,
						ourEmptyEList
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 498:  _modeltype ::= metamodel qvtErrorToken
			//
			case 498: {
				
				ModelTypeCS result = createModelTypeCS(
						new Token(0, 0, 0),
						createStringLiteralExpCS(""),
						ourEmptyEList,
						ourEmptyEList
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 499:  complianceKindCSOpt ::= $Empty
			//
			case 499: {
				
				CSTNode result = createStringLiteralExpCS("''");
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 502:  qvtStringLiteralExpCS ::= QUOTE_STRING_LITERAL
			//
			case 502: {
				
				CSTNode result = createStringLiteralExpCS("'" + unquote(getTokenText(dtParser.getToken(1))) + "'"); //$NON-NLS-1$ //$NON-NLS-2$
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 503:  modelTypeExpCS ::= modeltype IDENTIFIER complianceKindCSOpt uses packageRefList modelTypeWhereCSOpt ;
			//
			case 503: {
				
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
			// Rule 504:  modelTypeExpCS ::= modeltype qvtErrorToken
			//
			case 504: {
				
				ModelTypeCS result = createModelTypeCS(
						new Token(0, 0, 0),
						createStringLiteralExpCS(""),
						ourEmptyEList,
						ourEmptyEList
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 505:  packageRefList ::= packageRefCS
			//
			case 505: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 506:  packageRefList ::= packageRefList , packageRefCS
			//
			case 506: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 507:  packageRefCS ::= pathNameCS
			//
			case 507: {
				
				CSTNode result = createPackageRefCS(
						(PathNameCS)dtParser.getSym(1),
						null
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 508:  packageRefCS ::= pathNameCS ( qvtStringLiteralExpCS )
			//
			case 508: {
				
				CSTNode result = createPackageRefCS(
						(PathNameCS)dtParser.getSym(1),
						(StringLiteralExpCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 509:  packageRefCS ::= qvtStringLiteralExpCS
			//
			case 509: {
				
				CSTNode result = createPackageRefCS(
						null,
						(StringLiteralExpCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 510:  modelTypeWhereCSOpt ::= $Empty
			//
			case 510:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 511:  modelTypeWhereCSOpt ::= where { statementListOpt }
			//
			case 511: {
				
				EList result = (EList)dtParser.getSym(3);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 513:  classifierDefCS ::= intermediate class qvtIdentifierCS classifierExtensionOpt { classifierFeatureListOpt } semicolonOpt
			//
			case 513: {
				
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
			// Rule 514:  classifierExtensionOpt ::= $Empty
			//
			case 514:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 515:  classifierExtensionOpt ::= extends type_list
			//
			case 515: {
				
				EList result = (EList)dtParser.getSym(2);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 516:  type_list ::= typeCS
			//
			case 516: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 517:  type_list ::= type_list , typeCS
			//
			case 517: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 518:  type_list ::= type_list qvtErrorToken
			//
			case 518: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 519:  classifierFeatureListOpt ::= $Empty
			//
			case 519:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 521:  classifierFeatureList ::= classifierFeatureCS
			//
			case 521: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 522:  classifierFeatureList ::= classifierFeatureList ; classifierFeatureCS
			//
			case 522: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 523:  classifierFeatureList ::= classifierFeatureList qvtErrorToken
			//
			case 523: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 524:  classifierFeatureCS ::= stereotype_qualifier_list feature_key_list qvtIdentifierCS : typeCS multiplicityOpt ordered_prop opposite_propertyOpt init_partOpt
			//
			case 524: {
				
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
			// Rule 525:  init_partOpt ::= $Empty
			//
			case 525:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 526:  init_partOpt ::= = oclExpressionCS
			//
			case 526: {
				
				CSTNode result = (CSTNode) dtParser.getSym(2);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 527:  stereotype_qualifier_list ::= $Empty
			//
			case 527:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 528:  stereotype_qualifier_list ::= STEREOTYPE_QUALIFIER_OPEN identifier_list STEREOTYPE_QUALIFIER_CLOSE
			//
			case 528: {
				
				EList result = (EList)dtParser.getSym(2);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 529:  identifier_list ::= qvtIdentifierCS
			//
			case 529: {
				
				EList result = new BasicEList();
				result.add(getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 530:  identifier_list ::= identifier_list , qvtIdentifierCS
			//
			case 530: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 531:  identifier_list ::= identifier_list qvtErrorToken
			//
			case 531: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 532:  feature_key_list ::= $Empty
			//
			case 532:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 533:  feature_key_list ::= feature_key_list feature_key
			//
			case 533: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 534:  feature_key_list ::= feature_key_list qvtErrorToken
			//
			case 534: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 535:  feature_key ::= composes
			//
			case 535:
 
			//
			// Rule 536:  feature_key ::= references
			//
			case 536:
 
			//
			// Rule 537:  feature_key ::= readonly
			//
			case 537:
 
			//
			// Rule 538:  feature_key ::= derived
			//
			case 538:
 
			//
			// Rule 539:  feature_key ::= static
			//
			case 539: {
				
				CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 540:  multiplicityOpt ::= $Empty
			//
			case 540:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 541:  multiplicityOpt ::= LBRACKET multiplicity_range RBRACKET
			//
			case 541: {
				
				CSTNode result = (CSTNode) dtParser.getSym(2);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 542:  multiplicity_range ::= integerLiteralExpCS
			//
			case 542: {
				
				CSTNode result = createMultiplicityDefCS(
						(PrimitiveLiteralExpCS) dtParser.getSym(1),
						(PrimitiveLiteralExpCS) dtParser.getSym(1)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 543:  multiplicity_range ::= unlimitedNaturalLiteralExpCS
			//
			case 543: {
				
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
			// Rule 544:  multiplicity_range ::= integerLiteralExpCS MULTIPLICITY_RANGE integerLiteralExpCS
			//
			case 544:
 
			//
			// Rule 545:  multiplicity_range ::= integerLiteralExpCS DOTDOT integerLiteralExpCS
			//
			case 545:
 
			//
			// Rule 546:  multiplicity_range ::= integerLiteralExpCS MULTIPLICITY_RANGE unlimitedNaturalLiteralExpCS
			//
			case 546:
 
			//
			// Rule 547:  multiplicity_range ::= integerLiteralExpCS DOTDOT unlimitedNaturalLiteralExpCS
			//
			case 547: {
				
				CSTNode result = createMultiplicityDefCS(
						(PrimitiveLiteralExpCS) dtParser.getSym(1),
						(PrimitiveLiteralExpCS) dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 548:  ordered_prop ::= ordered
			//
			case 548: {
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.TRUE.toString());
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 549:  ordered_prop ::= $Empty
			//
			case 549: {
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.FALSE.toString());
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 550:  opposite_propertyOpt ::= $Empty
			//
			case 550:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 551:  opposite_propertyOpt ::= opposites navigable_prop qvtIdentifierCS multiplicityOpt
			//
			case 551: {
				
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
			// Rule 552:  navigable_prop ::= TILDE_SIGN
			//
			case 552: {
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.FALSE.toString());
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 553:  navigable_prop ::= $Empty
			//
			case 553: {
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.TRUE.toString());
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 555:  modulePropertyCS ::= configuration property qvtIdentifierCS : typeCS ;
			//
			case 555: {
				
				CSTNode result = createConfigPropertyCS(
						getIToken(dtParser.getToken(3)),
						(TypeCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 556:  modulePropertyCS ::= configuration property qvtIdentifierCS : typeCS qvtErrorToken
			//
			case 556: {
				
				CSTNode result = createConfigPropertyCS(
						getIToken(dtParser.getToken(3)),
						(TypeCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 557:  modulePropertyCS ::= property qvtIdentifierCS : typeCS = oclExpressionCS ;
			//
			case 557: {
				
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
			// Rule 558:  modulePropertyCS ::= property qvtIdentifierCS = oclExpressionCS ;
			//
			case 558: {
				
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
			// Rule 559:  modulePropertyCS ::= intermediate property scoped_identifier : typeCS ;
			//
			case 559: {
				
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
			// Rule 560:  modulePropertyCS ::= intermediate property scoped_identifier : typeCS = oclExpressionCS ;
			//
			case 560: {
				
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
			// Rule 564:  helper_header ::= helper_info scoped_identifier complete_signature
			//
			case 564: {
				
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

				dtParser.setSym1(mappingDeclarationCS);
	  		  break;
			}
	 
			//
			// Rule 565:  helper_header ::= helper_info qvtErrorToken
			//
			case 565: {
				
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

				dtParser.setSym1(mappingDeclarationCS);
	  		  break;
			}
	 
			//
			// Rule 566:  helper_info ::= qualifierList helper_kind
			//
			case 566: {
				
				dtParser.setSym1(new Object[] {dtParser.getSym(1), getIToken(dtParser.getToken(2))});
	  		  break;
			}
	 
			//
			// Rule 569:  helper_decl ::= helper_header ;
			//
			case 569: {
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)dtParser.getSym(1);
				MappingQueryCS result = createMappingQueryCS(
						mappingDecl,
						ourEmptyEList
					);
				result.setBlackBox(true);
				setOffsets(result, mappingDecl, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 570:  helper_decl ::= helper_header qvtErrorToken
			//
			case 570: {
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)dtParser.getSym(1);
				MappingQueryCS result = createMappingQueryCS(
						mappingDecl,
						ourEmptyEList
					);
				result.setBlackBox(true);
				setOffsets(result, mappingDecl);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 571:  helper_simple_def ::= helper_header = statementCS ;
			//
			case 571: {
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)dtParser.getSym(1);
				OCLExpressionCS expression = (OCLExpressionCS)dtParser.getSym(3);
				EList<OCLExpressionCS> expressionList = new BasicEList();
				expressionList.add(expression);
				MappingQueryCS result = createMappingQueryCS(
						mappingDecl,
						expressionList
					);
				result.setIsSimpleDefinition(true);
				setOffsets(result, mappingDecl, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 572:  helper_compound_def ::= helper_header expression_block semicolonOpt
			//
			case 572: {
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)dtParser.getSym(1);
				BlockExpCS blockExpCS = (BlockExpCS)dtParser.getSym(2);
				CSTNode result = createMappingQueryCS(
						mappingDecl,
						blockExpCS.getBodyExpressions()
					);
				setOffsets(result, mappingDecl, blockExpCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 575:  entry_header ::= main simple_signature
			//
			case 575: {
				
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
			// Rule 576:  entry_header ::= main qvtErrorToken
			//
			case 576: {
				
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
			// Rule 577:  entry_decl ::= entry_header ;
			//
			case 577: {
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)dtParser.getSym(1);
				MappingQueryCS result = createMappingQueryCS(
						mappingDecl,
						ourEmptyEList
					);
				result.setBlackBox(true);
				setOffsets(result, mappingDecl, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 578:  entry_def ::= entry_header expression_block semicolonOpt
			//
			case 578: {
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)dtParser.getSym(1);
				BlockExpCS blockExpCS = (BlockExpCS)dtParser.getSym(2);
				CSTNode result = createMappingQueryCS(
						mappingDecl,
						blockExpCS.getBodyExpressions()
					);
				setOffsets(result, mappingDecl, blockExpCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 581:  mapping_decl ::= mapping_full_header ;
			//
			case 581: {
				
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
			// Rule 582:  mapping_def ::= mapping_full_header { mapping_body } semicolonOpt
			//
			case 582: {
				
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
			// Rule 583:  mapping_def ::= mapping_full_header { qvtErrorToken
			//
			case 583: {
				
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
			// Rule 584:  mapping_full_header ::= mapping_header _whenOpt
			//
			case 584: {
				
				dtParser.setSym1(new Object[] {dtParser.getSym(1), dtParser.getSym(2)});
	  		  break;
			}
	 
			//
			// Rule 585:  mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier complete_signature mapping_extraList
			//
			case 585: {
				
				DirectionKindCS directionKind = (DirectionKindCS)dtParser.getSym(3);
				CompleteSignatureCS completeSignature = (CompleteSignatureCS)dtParser.getSym(5);
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					directionKind,
					(ScopedNameCS)dtParser.getSym(4),
					completeSignature.getSimpleSignature().getParams(),
					completeSignature.getResultParams()
				);
				mappingDeclarationCS.setStartOffset((directionKind == null ? (CSTNode)dtParser.getSym(4) : directionKind).getStartOffset());

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
			// Rule 586:  mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier qvtErrorToken
			//
			case 586: {
				
				DirectionKindCS directionKind = (DirectionKindCS)dtParser.getSym(3);
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					directionKind,
					(ScopedNameCS)dtParser.getSym(4),
					ourEmptyEList,
					ourEmptyEList
				);
				mappingDeclarationCS.setStartOffset((directionKind == null ? (CSTNode)dtParser.getSym(4) : directionKind).getStartOffset());

				mappingDeclarationCS.setEndOffset(((CSTNode)dtParser.getSym(4)).getEndOffset());

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)dtParser.getSym(1);
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				dtParser.setSym1(mappingDeclarationCS);
	  		  break;
			}
	 
			//
			// Rule 587:  mapping_header ::= qualifierList mapping qvtErrorToken
			//
			case 587: {
				
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
			// Rule 588:  mapping_extraList ::= mapping_extraList mapping_extra
			//
			case 588: {
				
				EList<MappingExtensionCS> extensionList = (EList<MappingExtensionCS>)dtParser.getSym(1);
				extensionList.add((MappingExtensionCS)dtParser.getSym(2));
				dtParser.setSym1(extensionList);
	  		  break;
			}
	 
			//
			// Rule 589:  mapping_extraList ::= $Empty
			//
			case 589:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 591:  mapping_extension ::= mapping_extension_key scoped_identifier_list
			//
			case 591: {
				
				MappingExtensionCS result = createMappingExtension(getTokenText(dtParser.getToken(1)), (EList<ScopedNameCS>)dtParser.getSym(2));

				result.setStartOffset(getIToken(dtParser.getToken(1)).getStartOffset());
				result.setEndOffset(getEndOffset(getIToken(dtParser.getToken(1)), (EList<ScopedNameCS>)dtParser.getSym(2)));
			
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 596:  _whenOpt ::= $Empty
			//
			case 596:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 597:  _when ::= when { oclExpressionCS semicolonOpt }
			//
			case 597: {
				
				OCLExpressionCS result = (OCLExpressionCS)dtParser.getSym(3);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 598:  _when ::= when qvtErrorToken
			//
			case 598:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 599:  mapping_body ::= init_sectionOpt population_sectionOpt end_sectionOpt
			//
			case 599: {
				
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
			// Rule 600:  init_sectionOpt ::= $Empty
			//
			case 600:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 602:  init_section ::= init expression_block
			//
			case 602: {
				
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
			// Rule 603:  init_section ::= init qvtErrorToken
			//
			case 603: {
				
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
			// Rule 604:  population_sectionOpt ::= $Empty
			//
			case 604: {
				
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
			// Rule 606:  population_section ::= expression_list
			//
			case 606: {
				
				EList<OCLExpressionCS> expressionList = (EList<OCLExpressionCS>) dtParser.getSym(1);
				MappingBodyCS result = createMappingBodyCS(
						expressionList,
						false
					);
				CSTNode startExp = expressionList.get(0);
				CSTNode endExp = expressionList.get(expressionList.size() - 1);
				setOffsets(result, startExp, endExp);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 607:  population_section ::= population expression_block
			//
			case 607: {
				
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
			// Rule 608:  population_section ::= population qvtErrorToken
			//
			case 608: {
				
				CSTNode result = createMappingBodyCS(
						ourEmptyEList,
						true
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 609:  end_sectionOpt ::= $Empty
			//
			case 609:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 611:  end_section ::= end expression_block
			//
			case 611: {
				
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
			// Rule 612:  end_section ::= end qvtErrorToken
			//
			case 612: {
				
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
			// Rule 613:  typespecOpt ::= $Empty
			//
			case 613:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 615:  objectDeclCS ::= typespec
			//
			case 615: {
				
				CSTNode result = createOutExpCS(null, (TypeSpecCS)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 619:  objectDeclCS ::= objectIdentifierCS : typespecOpt
			//
			case 619: {
				
			SimpleNameCS varName = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(varName, getIToken(dtParser.getToken(1)));
			CSTNode result = createOutExpCS(varName,(TypeSpecCS)dtParser.getSym(3));					
			dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 620:  outExpCS ::= object objectDeclCS expression_block
			//
			case 620: {
				
				BlockExpCS blockExpCS = (BlockExpCS) dtParser.getSym(3);
				CSTNode result = setupOutExpCS(
						(OutExpCS)dtParser.getSym(2),					
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
			// Rule 621:  outExpCS ::= object objectDeclCS qvtErrorToken
			//
			case 621: {
				
				OutExpCS objectDeclCS = ((OutExpCS)dtParser.getSym(2));  
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
			// Rule 622:  featureMappingCallExpCS ::= map simpleNameCS ( argumentsCSopt )
			//
			case 622: {
				
				CSTNode result = createMappingCallExpCS(
						(SimpleNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4),
						false
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 623:  featureMappingCallExpCS ::= xmap simpleNameCS ( argumentsCSopt )
			//
			case 623: {
				
				CSTNode result = createMappingCallExpCS(
						(SimpleNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4),
						true
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 624:  mappingCallExpCS ::= map pathNameCS ( argumentsCSopt )
			//
			case 624: {
				
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
			// Rule 625:  mappingCallExpCS ::= xmap pathNameCS ( argumentsCSopt )
			//
			case 625: {
				
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
			// Rule 626:  resolveConditionOpt ::= $Empty
			//
			case 626:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 627:  resolveConditionOpt ::= | oclExpressionCS
			//
			case 627: {
				
                dtParser.setSym1((OCLExpressionCS)dtParser.getSym(2));
      		  break;
			}
     
			//
			// Rule 628:  resolveConditionOpt ::= | qvtErrorToken
			//
			case 628:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 629:  IDENTIFIEROpt ::= $Empty
			//
			case 629:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 630:  IDENTIFIEROpt ::= IDENTIFIER :
			//
			case 630: {
				
                dtParser.setSym1(getIToken(dtParser.getToken(1)));
      		  break;
			}
     
			//
			// Rule 631:  resolveOpArgsExpCSOpt ::= $Empty
			//
			case 631:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 633:  resolveOpArgsExpCS ::= IDENTIFIEROpt typeCS resolveConditionOpt
			//
			case 633: {
				
                CSTNode result = createResolveOpArgsExpCS(
                        getIToken(dtParser.getToken(1)),      // target_type_variable?
                        (TypeCS)dtParser.getSym(2),           // type?
                        (OCLExpressionCS)dtParser.getSym(3)); // condition?
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 638:  lateOpt ::= $Empty
			//
			case 638:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 640:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCSOpt )
			//
			case 640: {
				
                CSTNode result = createResolveExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        (ResolveOpArgsExpCS)dtParser.getSym(4));
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 641:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCSOpt qvtErrorToken
			//
			case 641: {
				
                CSTNode result = createResolveExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        (ResolveOpArgsExpCS)dtParser.getSym(4));
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 642:  resolveExpCS ::= lateOpt resolveOp qvtErrorToken
			//
			case 642: {
				
                CSTNode result = createResolveExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        null);
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 643:  resolveExpCS ::= late qvtErrorToken
			//
			case 643: {
				
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
			// Rule 648:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier , resolveOpArgsExpCS )
			//
			case 648: {
				
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
			// Rule 649:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier )
			//
			case 649: {
				
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
			// Rule 650:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier , resolveOpArgsExpCSOpt qvtErrorToken
			//
			case 650: {
				
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
			// Rule 651:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier qvtErrorToken
			//
			case 651: {
				
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
			// Rule 652:  resolveInExpCS ::= lateOpt resolveInOp ( qvtErrorToken
			//
			case 652: {
				
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
			// Rule 653:  resolveInExpCS ::= lateOpt resolveInOp qvtErrorToken
			//
			case 653: {
				
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
			// Rule 656:  callExpCS ::= . resolveResolveInExpCS
			//
			case 656: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 661:  simpleNameCS ::= this
			//
			case 661:
 
			//
			// Rule 662:  simpleNameCS ::= result
			//
			case 662: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	
	
			default:
				break;
		}
		return;
	}
}

