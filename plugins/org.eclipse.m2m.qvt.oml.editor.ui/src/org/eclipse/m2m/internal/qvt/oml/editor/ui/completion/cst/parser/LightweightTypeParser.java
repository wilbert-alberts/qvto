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
* $Id: LightweightTypeParser.java,v 1.61 2009/04/22 10:15:05 aigdalov Exp $
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
* $Id: LightweightTypeParser.java,v 1.61 2009/04/22 10:15:05 aigdalov Exp $
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
* $Id: LightweightTypeParser.java,v 1.61 2009/04/22 10:15:05 aigdalov Exp $
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
* $Id: LightweightTypeParser.java,v 1.61 2009/04/22 10:15:05 aigdalov Exp $
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
import org.eclipse.ocl.cst.StringLiteralExpCS;
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
import org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS;	
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
			// Rule 27:  impliesExpCS ::= impliesExpCS implies andOrXorExpCS
			//
			case 27:
 
			//
			// Rule 28:  impliesWithLet ::= impliesExpCS implies andOrXorWithLet
			//
			case 28:
 
			//
			// Rule 31:  andOrXorExpCS ::= andOrXorExpCS and equalityExpCS
			//
			case 31:
 
			//
			// Rule 32:  andOrXorExpCS ::= andOrXorExpCS or equalityExpCS
			//
			case 32:
 
			//
			// Rule 33:  andOrXorExpCS ::= andOrXorExpCS xor equalityExpCS
			//
			case 33:
 
			//
			// Rule 34:  andOrXorWithLet ::= andOrXorExpCS and equalityWithLet
			//
			case 34:
 
			//
			// Rule 35:  andOrXorWithLet ::= andOrXorExpCS or equalityWithLet
			//
			case 35:
 
			//
			// Rule 36:  andOrXorWithLet ::= andOrXorExpCS xor equalityWithLet
			//
			case 36: {
				
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
			// Rule 39:  equalityExpCS ::= equalityExpCS = relationalExpCS
			//
			case 39:
 
			//
			// Rule 40:  equalityWithLet ::= equalityExpCS = relationalWithLet
			//
			case 40: {
				
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
			// Rule 41:  equalityExpCS ::= equalityExpCS <> relationalExpCS
			//
			case 41:
 
			//
			// Rule 42:  equalityWithLet ::= equalityExpCS <> relationalWithLet
			//
			case 42: {
				
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
			// Rule 45:  relationalExpCS ::= relationalExpCS > ifExpCSPrec
			//
			case 45:
 
			//
			// Rule 46:  relationalWithLet ::= relationalExpCS > additiveWithLet
			//
			case 46: {
				
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
			// Rule 47:  relationalExpCS ::= relationalExpCS < ifExpCSPrec
			//
			case 47:
 
			//
			// Rule 48:  relationalWithLet ::= relationalExpCS < additiveWithLet
			//
			case 48: {
				
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
			// Rule 49:  relationalExpCS ::= relationalExpCS >= ifExpCSPrec
			//
			case 49:
 
			//
			// Rule 50:  relationalWithLet ::= relationalExpCS >= additiveWithLet
			//
			case 50: {
				
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
			// Rule 51:  relationalExpCS ::= relationalExpCS <= ifExpCSPrec
			//
			case 51:
 
			//
			// Rule 52:  relationalWithLet ::= relationalExpCS <= additiveWithLet
			//
			case 52: {
				
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
			// Rule 56:  additiveExpCS ::= additiveExpCS + multiplicativeExpCS
			//
			case 56:
 
			//
			// Rule 57:  additiveWithLet ::= additiveExpCS + multiplicativeWithLet
			//
			case 57: {
				
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
			// Rule 58:  additiveExpCS ::= additiveExpCS - multiplicativeExpCS
			//
			case 58:
 
			//
			// Rule 59:  additiveWithLet ::= additiveExpCS - multiplicativeWithLet
			//
			case 59: {
				
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
			// Rule 62:  multiplicativeExpCS ::= multiplicativeExpCS * unaryExpCS
			//
			case 62:
 
			//
			// Rule 63:  multiplicativeWithLet ::= multiplicativeExpCS * unaryWithLet
			//
			case 63: {
				
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
			// Rule 64:  multiplicativeExpCS ::= multiplicativeExpCS / unaryExpCS
			//
			case 64:
 
			//
			// Rule 65:  multiplicativeWithLet ::= multiplicativeExpCS / unaryWithLet
			//
			case 65: {
				
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
			// Rule 68:  unaryExpCS ::= - unaryExpCS
			//
			case 68: {
				
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
			// Rule 69:  unaryExpCS ::= not unaryExpCS
			//
			case 69: {
				
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
			// Rule 71:  dotArrowExpCS ::= dotArrowExpCS callExpCS
			//
			case 71: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setSource((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, (CSTNode)dtParser.getSym(1), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 72:  dotArrowExpCS ::= dotArrowExpCS messageExpCS
			//
			case 72: {
				
				MessageExpCS result = (MessageExpCS)dtParser.getSym(2);
				result.setTarget((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 73:  dotArrowExpCS ::= NUMERIC_OPERATION ( argumentsCSopt )
			//
			case 73: {
				
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
			// Rule 74:  dotArrowExpCS ::= pathNameCS :: simpleNameCS ( argumentsCSopt )
			//
			case 74: {
				
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
			// Rule 79:  oclExpCS ::= ( oclExpressionCS )
			//
			case 79: {
				
				CSTNode result = (CSTNode)dtParser.getSym(2);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 80:  variableExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 80: {
				
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
			// Rule 81:  variableExpCS ::= keywordAsIdentifier1 isMarkedPreCS
			//
			case 81: {
				
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
			// Rule 83:  simpleNameCS ::= self
			//
			case 83: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.SELF_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 84:  simpleNameCS ::= IDENTIFIER
			//
			case 84: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 85:  primitiveTypeCS ::= Integer
			//
			case 85: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INTEGER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 86:  primitiveTypeCS ::= UnlimitedNatural
			//
			case 86: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 87:  primitiveTypeCS ::= String
			//
			case 87: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.STRING_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 88:  primitiveTypeCS ::= Real
			//
			case 88: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.REAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 89:  primitiveTypeCS ::= Boolean
			//
			case 89: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.BOOLEAN_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 90:  primitiveTypeCS ::= OclAny
			//
			case 90: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_ANY_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 91:  primitiveTypeCS ::= OclVoid
			//
			case 91: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_VOID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 92:  primitiveTypeCS ::= Invalid
			//
			case 92: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INVALID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 93:  primitiveTypeCS ::= OclMessage
			//
			case 93: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_MESSAGE_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 94:  pathNameCS ::= IDENTIFIER
			//
			case 94: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 95:  pathNameCS ::= pathNameCS :: simpleNameCS
			//
			case 95: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 96:  pathNameCSOpt ::= $Empty
			//
			case 96: {
				
				CSTNode result = createPathNameCS();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 104:  enumLiteralExpCS ::= pathNameCS :: keywordAsIdentifier
			//
			case 104: {
				
				CSTNode result = createEnumLiteralExpCS(
						(PathNameCS)dtParser.getSym(1),
						getTokenText(dtParser.getToken(3))
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 105:  enumLiteralExpCS ::= pathNameCS :: simpleNameCS
			//
			case 105: {
				
				CSTNode result = createEnumLiteralExpCS(
						(PathNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 106:  collectionLiteralExpCS ::= collectionTypeIdentifierCS { collectionLiteralPartsCSopt }
			//
			case 106: {
				
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
			// Rule 107:  collectionTypeIdentifierCS ::= Set
			//
			case 107: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.SET_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 108:  collectionTypeIdentifierCS ::= Bag
			//
			case 108: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.BAG_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 109:  collectionTypeIdentifierCS ::= Sequence
			//
			case 109: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.SEQUENCE_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 110:  collectionTypeIdentifierCS ::= Collection
			//
			case 110: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.COLLECTION_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 111:  collectionTypeIdentifierCS ::= OrderedSet
			//
			case 111: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 112:  collectionLiteralPartsCSopt ::= $Empty
			//
			case 112:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 114:  collectionLiteralPartsCS ::= collectionLiteralPartCS
			//
			case 114: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 115:  collectionLiteralPartsCS ::= collectionLiteralPartsCS , collectionLiteralPartCS
			//
			case 115: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 117:  collectionLiteralPartCS ::= oclExpressionCS
			//
			case 117: {
				
				CSTNode result = createCollectionLiteralPartCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 118:  collectionRangeCS ::= - INTEGER_RANGE_START oclExpressionCS
			//
			case 118: {
				
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
			// Rule 119:  collectionRangeCS ::= INTEGER_RANGE_START oclExpressionCS
			//
			case 119: {
				
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
			// Rule 120:  collectionRangeCS ::= oclExpressionCS .. oclExpressionCS
			//
			case 120: {
				
				CSTNode result = createCollectionRangeCS(
						(OCLExpressionCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 126:  tupleLiteralExpCS ::= Tuple { variableListCS2 }
			//
			case 126: {
				
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 127:  integerLiteralExpCS ::= INTEGER_LITERAL
			//
			case 127: {
				
				CSTNode result = createIntegerLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 128:  unlimitedNaturalLiteralExpCS ::= *
			//
			case 128: {
				
				CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 129:  realLiteralExpCS ::= REAL_LITERAL
			//
			case 129: {
				
				CSTNode result = createRealLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 130:  stringLiteralExpCS ::= STRING_LITERAL
			//
			case 130: {
				
				IToken literalToken = getIToken(dtParser.getToken(1));
				StringLiteralExpCS result = createStringLiteralExpCS(literalToken.toString());
				result.setUnescapedStringSymbol(unescape(literalToken));
				setOffsets(result, literalToken);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 131:  booleanLiteralExpCS ::= true
			//
			case 131: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 132:  booleanLiteralExpCS ::= false
			//
			case 132: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 133:  nullLiteralExpCS ::= null
			//
			case 133: {
				
				CSTNode result = createNullLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 134:  invalidLiteralExpCS ::= OclInvalid
			//
			case 134: {
				
				CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 135:  callExpCS ::= -> featureCallExpCS
			//
			case 135:
 
			//
			// Rule 136:  callExpCS ::= -> loopExpCS
			//
			case 136: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 137:  callExpCS ::= . keywordOperationCallExpCS
			//
			case 137:
 
			//
			// Rule 138:  callExpCS ::= . featureCallExpCS
			//
			case 138: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 141:  iteratorExpCS ::= forAll ( iterContents )
			//
			case 141:
 
			//
			// Rule 142:  iteratorExpCS ::= exists ( iterContents )
			//
			case 142:
 
			//
			// Rule 143:  iteratorExpCS ::= isUnique ( iterContents )
			//
			case 143:
 
			//
			// Rule 144:  iteratorExpCS ::= one ( iterContents )
			//
			case 144:
 
			//
			// Rule 145:  iteratorExpCS ::= any ( iterContents )
			//
			case 145:
 
			//
			// Rule 146:  iteratorExpCS ::= collect ( iterContents )
			//
			case 146:
 
			//
			// Rule 147:  iteratorExpCS ::= select ( iterContents )
			//
			case 147:
 
			//
			// Rule 148:  iteratorExpCS ::= reject ( iterContents )
			//
			case 148:
 
			//
			// Rule 149:  iteratorExpCS ::= collectNested ( iterContents )
			//
			case 149:
 
			//
			// Rule 150:  iteratorExpCS ::= sortedBy ( iterContents )
			//
			case 150:
 
			//
			// Rule 151:  iteratorExpCS ::= closure ( iterContents )
			//
			case 151: {
				
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
			// Rule 152:  iterContents ::= oclExpressionCS
			//
			case 152: {
				
				dtParser.setSym1(new Object[] {
						null,
						null,
						dtParser.getSym(1)
					});
	  		  break;
			}
	 
			//
			// Rule 153:  iterContents ::= variableCS | oclExpressionCS
			//
			case 153: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						null,
						dtParser.getSym(3)
					});
	  		  break;
			}
	 
			//
			// Rule 154:  iterContents ::= variableCS , variableCS | oclExpressionCS
			//
			case 154: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						dtParser.getSym(3),
						dtParser.getSym(5)
					});
	  		  break;
			}
	 
			//
			// Rule 155:  iterateExpCS ::= iterate ( variableCS | oclExpressionCS )
			//
			case 155: {
				
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
			// Rule 156:  iterateExpCS ::= iterate ( variableCS ; variableCS | oclExpressionCS )
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
						(VariableCS)dtParser.getSym(5),
						(OCLExpressionCS)dtParser.getSym(7)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(8)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 157:  variableCS ::= IDENTIFIER
			//
			case 157: {
				
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
			// Rule 158:  variableCS ::= IDENTIFIER : typeCS
			//
			case 158: {
				
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
			// Rule 159:  variableCS ::= IDENTIFIER : typeCS = oclExpressionCS
			//
			case 159: {
				
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
			// Rule 160:  variableCS2 ::= IDENTIFIER = oclExpressionCS
			//
			case 160: {
				
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
			// Rule 165:  collectionTypeCS ::= collectionTypeIdentifierCS ( typeCS )
			//
			case 165: {
				
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
			// Rule 166:  tupleTypeCS ::= Tuple ( variableListCSopt )
			//
			case 166: {
				
				CSTNode result = createTupleTypeCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 167:  variableListCSopt ::= $Empty
			//
			case 167:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 169:  variableListCS ::= variableCS
			//
			case 169: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 170:  variableListCS ::= variableListCS , variableCS
			//
			case 170: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 171:  variableListCS2 ::= variableCS2
			//
			case 171:
 
			//
			// Rule 172:  variableListCS2 ::= variableCS
			//
			case 172: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 173:  variableListCS2 ::= variableListCS2 , variableCS2
			//
			case 173:
 
			//
			// Rule 174:  variableListCS2 ::= variableListCS2 , variableCS
			//
			case 174: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 177:  featureCallExpCS ::= MINUS isMarkedPreCS ( argumentsCSopt )
			//
			case 177:
 
			//
			// Rule 178:  featureCallExpCS ::= not isMarkedPreCS ( argumentsCSopt )
			//
			case 178: {
				
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
			// Rule 179:  operationCallExpCS ::= simpleNameCS isMarkedPreCS ( argumentsCSopt )
			//
			case 179: {
				
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
			// Rule 180:  operationCallExpCS ::= oclIsUndefined isMarkedPreCS ( argumentsCSopt )
			//
			case 180:
 
			//
			// Rule 181:  operationCallExpCS ::= oclIsInvalid isMarkedPreCS ( argumentsCSopt )
			//
			case 181:
 
			//
			// Rule 182:  operationCallExpCS ::= oclIsNew isMarkedPreCS ( argumentsCSopt )
			//
			case 182:
 
			//
			// Rule 183:  operationCallExpCS ::= EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 183:
 
			//
			// Rule 184:  operationCallExpCS ::= NOT_EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 184:
 
			//
			// Rule 185:  operationCallExpCS ::= PLUS isMarkedPreCS ( argumentsCSopt )
			//
			case 185:
 
			//
			// Rule 186:  operationCallExpCS ::= MULTIPLY isMarkedPreCS ( argumentsCSopt )
			//
			case 186:
 
			//
			// Rule 187:  operationCallExpCS ::= DIVIDE isMarkedPreCS ( argumentsCSopt )
			//
			case 187:
 
			//
			// Rule 188:  operationCallExpCS ::= GREATER isMarkedPreCS ( argumentsCSopt )
			//
			case 188:
 
			//
			// Rule 189:  operationCallExpCS ::= LESS isMarkedPreCS ( argumentsCSopt )
			//
			case 189:
 
			//
			// Rule 190:  operationCallExpCS ::= GREATER_EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 190:
 
			//
			// Rule 191:  operationCallExpCS ::= LESS_EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 191:
 
			//
			// Rule 192:  operationCallExpCS ::= and isMarkedPreCS ( argumentsCSopt )
			//
			case 192:
 
			//
			// Rule 193:  operationCallExpCS ::= or isMarkedPreCS ( argumentsCSopt )
			//
			case 193:
 
			//
			// Rule 194:  operationCallExpCS ::= xor isMarkedPreCS ( argumentsCSopt )
			//
			case 194:
 
			//
			// Rule 195:  keywordOperationCallExpCS ::= keywordAsIdentifier isMarkedPreCS ( argumentsCSopt )
			//
			case 195: {
				
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
			// Rule 196:  operationCallExpCS ::= oclIsInState isMarkedPreCS ( pathNameCSOpt )
			//
			case 196: {
				
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
			// Rule 197:  attrOrNavCallExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 197: {
				
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
			// Rule 198:  attrOrNavCallExpCS ::= keywordAsIdentifier isMarkedPreCS
			//
			case 198: {
				
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
			// Rule 199:  isMarkedPreCS ::= $Empty
			//
			case 199: {
				
				CSTNode result = createIsMarkedPreCS(false);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 200:  isMarkedPreCS ::= @pre
			//
			case 200: {
				
				CSTNode result = createIsMarkedPreCS(true);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 201:  argumentsCSopt ::= $Empty
			//
			case 201:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 203:  argumentsCS ::= oclExpressionCS
			//
			case 203: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 204:  argumentsCS ::= argumentsCS , oclExpressionCS
			//
			case 204: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 205:  letExpCS ::= let variableCS letExpSubCSopt in oclExpressionCS
			//
			case 205: {
				
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
			// Rule 206:  letExpSubCSopt ::= $Empty
			//
			case 206:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 208:  letExpSubCS ::= , variableCS
			//
			case 208: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 209:  letExpSubCS ::= letExpSubCS , variableCS
			//
			case 209: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 210:  messageExpCS ::= ^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 210:
 
			//
			// Rule 211:  messageExpCS ::= ^^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 211: {
				
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
			// Rule 212:  oclMessageArgumentsCSopt ::= $Empty
			//
			case 212:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 214:  oclMessageArgumentsCS ::= oclMessageArgCS
			//
			case 214: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 215:  oclMessageArgumentsCS ::= oclMessageArgumentsCS , oclMessageArgCS
			//
			case 215: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 216:  oclMessageArgCS ::= oclExpressionCS
			//
			case 216: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 217:  oclMessageArgCS ::= ?
			//
			case 217: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 218:  oclMessageArgCS ::= ? : typeCS
			//
			case 218: {
				
				CSTNode result = createOCLMessageArgCS(
						(TypeCS)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 219:  qualifierList ::= $Empty
			//
			case 219:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 220:  qualifierList ::= qualifierList qualifier
			//
			case 220: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 221:  qualifier ::= blackbox
			//
			case 221:
 
			//
			// Rule 222:  qualifier ::= abstract
			//
			case 222:
 
			//
			// Rule 223:  qualifier ::= static
			//
			case 223: {
				
				CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 224:  colon_param_listOpt ::= $Empty
			//
			case 224:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 225:  colon_param_listOpt ::= : param_list
			//
			case 225: {
				
				dtParser.setSym1(dtParser.getSym(2));
	  		  break;
			}
	 
			//
			// Rule 226:  complete_signature ::= simple_signature colon_param_listOpt
			//
			case 226: {
				
				SimpleSignatureCS simpleSignatureCS = (SimpleSignatureCS)dtParser.getSym(1);
				EList<ParameterDeclarationCS> resultList = (EList<ParameterDeclarationCS>)dtParser.getSym(2);
				CSTNode result = createCompleteSignatureCS(simpleSignatureCS, resultList);
				result.setStartOffset(simpleSignatureCS.getStartOffset());
				result.setEndOffset(getEndOffset(simpleSignatureCS.getEndOffset(), resultList));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 227:  simple_signatureOpt ::= $Empty
			//
			case 227:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 229:  simple_signature ::= ( param_listOpt )
			//
			case 229: {
				
				CSTNode result = createSimpleSignatureCS((EList<ParameterDeclarationCS>)dtParser.getSym(2));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 230:  param_listOpt ::= $Empty
			//
			case 230:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 232:  param_list ::= param_list , param
			//
			case 232: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 233:  param_list ::= param_list , qvtErrorToken
			//
			case 233: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 234:  param_list ::= param
			//
			case 234: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 235:  param_list ::= qvtErrorToken
			//
			case 235: {
				
				EList result = new BasicEList();
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
			// Rule 245:  declarator1 ::= IDENTIFIER : typeCS
			//
			case 245: {
				
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
			// Rule 246:  declarator1 ::= IDENTIFIER : typeCS = oclExpressionCS
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
			// Rule 247:  declarator1 ::= IDENTIFIER : typeCS := oclExpressionCS
			//
			case 247: {
				
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
			// Rule 248:  declarator2 ::= IDENTIFIER := oclExpressionCS
			//
			case 248: {
				
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
			// Rule 249:  typespec ::= typeCS
			//
			case 249: {
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)dtParser.getSym(1),
					null
					);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 250:  typespec ::= typeCS @ IDENTIFIER
			//
			case 250: {
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)dtParser.getSym(1),
					getIToken(dtParser.getToken(3))
					);
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
			// Rule 263:  scoped_identifier_list ::= scoped_identifier_list qvtErrorToken
			//
			case 263: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 266:  expression_listOpt ::= $Empty
			//
			case 266:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 270:  expression_semi_list ::= expression_semi_list_element
			//
			case 270: {
				
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
			// Rule 271:  expression_semi_list ::= expression_semi_list ; expression_semi_list_element
			//
			case 271: {
				
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
			// Rule 272:  expression_semi_list ::= expression_semi_list qvtErrorToken
			//
			case 272: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 273:  expression_block ::= { expression_listOpt }
			//
			case 273: {
				
			EList bodyList = (EList) dtParser.getSym(2);
			CSTNode result = createBlockExpCS(
				bodyList
			);
			
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
			dtParser.setSym1(result);
          		  break;
			}
	 
			//
			// Rule 274:  expression_block ::= { qvtErrorToken
			//
			case 274: {
				
			CSTNode result = createBlockExpCS(
				ourEmptyEList
			);
			
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
          		  break;
			}
	 
			//
			// Rule 277:  qualifiedNameCS ::= qvtIdentifierCS
			//
			case 277: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 278:  qualifiedNameCS ::= qualifiedNameCS . qvtIdentifierCS
			//
			case 278: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 279:  qualifiedNameCS ::= qualifiedNameCS . qvtErrorToken
			//
			case 279: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, "");
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 280:  qualifiedNameCS ::= qualifiedNameCS qvtErrorToken
			//
			case 280: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}	
	 
			//
			// Rule 282:  oclExpressionCSOpt ::= $Empty
			//
			case 282:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 283:  letExpSubCS3 ::= variableCS2
			//
			case 283: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 284:  letExpSubCS3 ::= letExpSubCS3 , variableCS2
			//
			case 284: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 285:  letExpCS ::= let letExpSubCS3 in oclExpressionCS
			//
			case 285: {
				
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
			// Rule 286:  letExpCS ::= let letExpSubCS3 in qvtErrorToken
			//
			case 286: {
				
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
			// Rule 287:  iterContents ::= variableCS | qvtErrorToken
			//
			case 287: {
				
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
			// Rule 288:  callExpCS ::= . qvtErrorToken
			//
			case 288: {
				
				CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
	 			result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 289:  callExpCS ::= -> qvtErrorToken
			//
			case 289: {
				
				CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
	 			result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 290:  argumentsCS ::= qvtErrorToken
			//
			case 290:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 303:  iteratorExpCS ::= iteratorExpCSToken ( qvtErrorToken
			//
			case 303: {
				
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
			// Rule 304:  operationCallExpCS ::= oclAsType isMarkedPreCS ( typeCS )
			//
			case 304:
 
			//
			// Rule 305:  operationCallExpCS ::= oclIsKindOf isMarkedPreCS ( typeCS )
			//
			case 305:
 
			//
			// Rule 306:  operationCallExpCS ::= oclIsTypeOf isMarkedPreCS ( typeCS )
			//
			case 306: {
				
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
			// Rule 309:  qvtErrorToken ::= ERROR_TOKEN
			//
			case 309: {
				
				diagnozeErrorToken(dtParser.getToken(1));
	  		  break;
			}
	 
			//
			// Rule 310:  equalityExpCS ::= equalityExpCS != relationalExpCS
			//
			case 310:
 
			//
			// Rule 311:  equalityWithLet ::= equalityExpCS != relationalWithLet
			//
			case 311: {
				
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
			// Rule 312:  stringLiteralExpCS ::= stringLiteralExpCS STRING_LITERAL
			//
			case 312: {
				
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
			// Rule 314:  listTypeCS ::= List ( typeCS )
			//
			case 314: {
				
				CSTNode result = createListTypeCS(
						(TypeCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 315:  listLiteralCS ::= List { collectionLiteralPartsCSopt }
			//
			case 315: {
				
				CSTNode result = createListLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 317:  dictTypeCS ::= Dict ( typeCS , typeCS )
			//
			case 317: {
				
				CSTNode result = createDictTypeCS((TypeCS)dtParser.getSym(3), (TypeCS)dtParser.getSym(5));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 318:  dictLiteralCS ::= Dict { dictLiteralPartListCSopt }
			//
			case 318: {
				
				CSTNode result = createDictLiteralExpCS((EList<DictLiteralPartCS>)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 323:  dictLiteralPartCS ::= literalSimpleCS = oclExpressionCS
			//
			case 323: {
				
				CSTNode result = createDictLiteralPartCS((LiteralExpCS)dtParser.getSym(1), (OCLExpressionCS)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 325:  dictLiteralPartListCSopt ::= $Empty
			//
			case 325:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 326:  dictLiteralPartListCS ::= dictLiteralPartCS
			//
			case 326: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 327:  dictLiteralPartListCS ::= dictLiteralPartListCS , dictLiteralPartCS
			//
			case 327: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 328:  dictLiteralPartListCS ::= dictLiteralPartListCS qvtErrorToken
			//
			case 328: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 330:  returnExpCS ::= return oclExpressionCSOpt
			//
			case 330: {
				
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
			// Rule 332:  var_init_group_exp ::= var var_init_declarator_list
			//
			case 332: {
				
				dtParser.setSym1(dtParser.getSym(2));
	  		  break;
			}
	 
			//
			// Rule 333:  var_init_group_exp ::= var ( var_init_declarator_list )
			//
			case 333: {
				
				dtParser.setSym1(dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 334:  var_init_group_exp ::= var ( var_init_declarator_list qvtErrorToken
			//
			case 334: {
				
				dtParser.setSym1(dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 336:  var_init_exp ::= var var_init_declarator
			//
			case 336: {
				
				dtParser.setSym1(dtParser.getSym(2));
	  		  break;
			}
	 
			//
			// Rule 337:  var_init_exp ::= var ( var_init_declarator )
			//
			case 337: {
				
				dtParser.setSym1(dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 338:  var_init_exp ::= var ( var_init_declarator qvtErrorToken
			//
			case 338: {
				
				dtParser.setSym1(dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 339:  var_init_exp ::= var qvtErrorToken
			//
			case 339: {
				
				dtParser.setSym1(ourEmptyEList);
	  		  break;
			}
	 
			//
			// Rule 340:  var_init_declarator_list ::= var_init_declarator , var_init_declarator
			//
			case 340: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 341:  var_init_declarator_list ::= var_init_declarator_list , var_init_declarator
			//
			case 341: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 342:  var_init_declarator ::= IDENTIFIER : typeCS var_init_op oclExpressionCS
			//
			case 342: {
				
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
			// Rule 343:  var_init_declarator ::= IDENTIFIER : typeCS var_init_op qvtErrorToken
			//
			case 343: {
				
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
			// Rule 344:  var_init_declarator ::= IDENTIFIER var_init_op oclExpressionCS
			//
			case 344: {
				
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
			// Rule 345:  var_init_declarator ::= IDENTIFIER var_init_op qvtErrorToken
			//
			case 345: {
				
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
			// Rule 346:  var_init_declarator ::= IDENTIFIER : typeCS
			//
			case 346: {
				
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
			// Rule 347:  var_init_declarator ::= IDENTIFIER : qvtErrorToken
			//
			case 347: {
				
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
			// Rule 348:  var_init_op ::= =
			//
			case 348:
 
			//
			// Rule 349:  var_init_op ::= :=
			//
			case 349: {
				
				dtParser.setSym1(false);
	  		  break;
			}
	 
			//
			// Rule 350:  var_init_op ::= ::=
			//
			case 350: {
				
				dtParser.setSym1(true);
	  		  break;
			}
	 
			//
			// Rule 352:  assignStatementCS ::= dotArrowExpCS := oclExpressionCS
			//
			case 352: {
				
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
			// Rule 353:  assignStatementCS ::= dotArrowExpCS := qvtErrorToken
			//
			case 353: {
				
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
			// Rule 354:  assignStatementCS ::= dotArrowExpCS += oclExpressionCS
			//
			case 354: {
				
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
			// Rule 355:  assignStatementCS ::= dotArrowExpCS += qvtErrorToken
			//
			case 355: {
				
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
			// Rule 357:  whileExpCS ::= while ( declarator1 ; oclExpressionCS ) whileBodyCS
			//
			case 357: {
				
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
			// Rule 358:  whileExpCS ::= while ( assignStatementCS ; oclExpressionCS ) whileBodyCS
			//
			case 358: {
				
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
			// Rule 359:  whileExpCS ::= while ( oclExpressionCS ) whileBodyCS
			//
			case 359: {
				
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
			// Rule 363:  forExpDeclaratorList ::= IDENTIFIER
			//
			case 363: {
				
		EList result = new BasicEList();
		result.add(getIToken(dtParser.getToken(1)));
		dtParser.setSym1(result);
          		  break;
			}
    	 
			//
			// Rule 364:  forExpDeclaratorList ::= forExpDeclaratorList , IDENTIFIER
			//
			case 364: {
				
		EList result = (EList)dtParser.getSym(1);
		result.add(getIToken(dtParser.getToken(3)));
		dtParser.setSym1(result);
          		  break;
			}
    	 
			//
			// Rule 365:  forExpConditionOpt ::= $Empty
			//
			case 365:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 366:  forExpConditionOpt ::= | oclExpressionCS
			//
			case 366: {
				
            	    dtParser.setSym1((OCLExpressionCS)dtParser.getSym(2));
          		  break;
			}
    	 
			//
			// Rule 367:  forExpConditionOpt ::= | qvtErrorToken
			//
			case 367:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 368:  forExpCS ::= forOpCode ( forExpDeclaratorList forExpConditionOpt ) expression_block
			//
			case 368: {
				
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
			// Rule 369:  forExpCS ::= forOpCode qvtErrorToken
			//
			case 369: {
				
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
			// Rule 373:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS else ifExpBodyCS endif
			//
			case 373: {
				
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
			// Rule 374:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS endif
			//
			case 374: {
				
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
			// Rule 375:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS else ifExpBodyCS qvtErrorToken
			//
			case 375: {
				
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
			// Rule 376:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS else qvtErrorToken
			//
			case 376: {
				
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
			// Rule 377:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS qvtErrorToken
			//
			case 377: {
				
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
			// Rule 378:  ifExpCS ::= if oclExpressionCS then qvtErrorToken
			//
			case 378: {
				
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
			// Rule 379:  ifExpCS ::= if oclExpressionCS qvtErrorToken
			//
			case 379: {
				
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
			// Rule 380:  ifExpCS ::= if qvtErrorToken
			//
			case 380: {
				
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
			// Rule 384:  switchExpCS ::= switch switchBodyExpCS
			//
			case 384: {
				
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
			// Rule 386:  switchDeclaratorCS ::= IDENTIFIER
			//
			case 386: {
				
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
			// Rule 387:  switchDeclaratorCS ::= IDENTIFIER = oclExpressionCS
			//
			case 387: {
				
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
			// Rule 388:  iterateSwitchExpCS ::= switch ( switchDeclaratorCS ) switchBodyExpCS
			//
			case 388: {
				
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
			// Rule 389:  switchExpCS ::= switch qvtErrorToken
			//
			case 389: {
				
				CSTNode result = createSwitchExpCS(
						new BasicEList(),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 390:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt }
			//
			case 390: {
				
				Object[] result = new Object[] {dtParser.getSym(2), dtParser.getSym(3), getIToken(dtParser.getToken(4))};
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 391:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt qvtErrorToken
			//
			case 391: {
				
				Object[] result = new Object[] {dtParser.getSym(2), dtParser.getSym(3), dtParser.getSym(3)};
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 392:  switchBodyExpCS ::= { qvtErrorToken
			//
			case 392: {
				
				Object[] result = new Object[] {new BasicEList(), null, getIToken(dtParser.getToken(1))};
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 393:  switchAltExpCSList ::= switchAltExpCS
			//
			case 393: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 394:  switchAltExpCSList ::= switchAltExpCSList switchAltExpCS
			//
			case 394: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 395:  switchAltExpCS ::= case ( oclExpressionCS ) expression_statement
			//
			case 395: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(3),
						(OCLExpressionCS) dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 396:  switchAltExpCS ::= case ( oclExpressionCS ) qvtErrorToken
			//
			case 396: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 397:  switchElseExpCSOpt ::= $Empty
			//
			case 397:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 399:  switchElseExpCS ::= else expression_statement
			//
			case 399: {
				
				dtParser.setSym1((CSTNode)dtParser.getSym(2));
	  		  break;
			}
	 
			//
			// Rule 400:  switchElseExpCS ::= else qvtErrorToken
			//
			case 400: {
				
				dtParser.setSym1(null);
	  		  break;
			}
	 
			//
			// Rule 401:  oclExpressionCS ::= primaryOCLExpressionCS
			//
			case 401: {
				
				CSTNode result = createExpressionStatementCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 403:  logWhenExp ::= when oclExpressionCS
			//
			case 403: {
				
			OCLExpressionCS condition = (OCLExpressionCS) dtParser.getSym(2);
			dtParser.setSym1(condition);
      		  break;
			}
     
			//
			// Rule 405:  logWhenExpOpt ::= $Empty
			//
			case 405:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 406:  logExpCS ::= log ( argumentsCSopt ) logWhenExpOpt
			//
			case 406: {
				
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
			// Rule 408:  severityKindCS ::= simpleNameCS
			//
			case 408: {
				
			dtParser.setSym1(dtParser.getSym(1));
	  		  break;
			}
	 
			//
			// Rule 410:  severityKindCSOpt ::= $Empty
			//
			case 410:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 411:  assertWithLogExp ::= with logExpCS
			//
			case 411: {
				
			LogExpCS logExp = (LogExpCS) dtParser.getSym(2);
			setOffsets(logExp, getIToken(dtParser.getToken(2)), logExp);
			dtParser.setSym1(logExp);
      		  break;
			}
     
			//
			// Rule 413:  assertWithLogExpOpt ::= $Empty
			//
			case 413:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 414:  assertExpCS ::= assert severityKindCSOpt ( oclExpressionCS ) assertWithLogExpOpt
			//
			case 414: {
				
			LogExpCS logExpCS = (LogExpCS)dtParser.getSym(6);
			OCLExpressionCS condition = (OCLExpressionCS)dtParser.getSym(4);
			AssertExpCS result = (AssertExpCS)createAssertExpCS(condition, (SimpleNameCS)dtParser.getSym(2), logExpCS);
	
			CSTNode end = logExpCS != null ? logExpCS : condition; 
			setOffsets(result, getIToken(dtParser.getToken(1)), end);
			dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 415:  computeExpCS ::= compute ( declarator ) expression_block
			//
			case 415: {
				
				CSTNode result = createComputeExpCS(
					(VariableCS) dtParser.getSym(3),
					(OCLExpressionCS) dtParser.getSym(5)
				);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 426:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken12 ( imperativeIterContents12 )
			//
			case 426:
 
			//
			// Rule 427:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken3 ( imperativeIterContents3 )
			//
			case 427: {
				
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
			// Rule 428:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken qvtErrorToken
			//
			case 428: {
				
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
			// Rule 429:  imperativeIterContents12 ::= oclExpressionCS
			//
			case 429: {
				
				dtParser.setSym1(new Object[] {
						ourEmptyEList,
						null,
						dtParser.getSym(1)
					});
	  		  break;
			}
	 
			//
			// Rule 430:  imperativeIterContents12 ::= variableListCS | oclExpressionCS
			//
			case 430: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						null,
						dtParser.getSym(3)
					});
	  		  break;
			}
	 
			//
			// Rule 431:  imperativeIterContents3 ::= variableListCS ; variableCS2 | oclExpressionCS
			//
			case 431: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						dtParser.getSym(3),
						dtParser.getSym(5)
					});
	  		  break;
			}
	 
			//
			// Rule 432:  exclamationOpt ::= $Empty
			//
			case 432:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 434:  declarator_vsep ::= IDENTIFIER |
			//
			case 434: {
				
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
			// Rule 435:  declarator_vsepOpt ::= $Empty
			//
			case 435:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 437:  callExpCS ::= -> featureCallExpCS exclamationOpt [ declarator_vsepOpt oclExpressionCS ]
			//
			case 437: {
				
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
			// Rule 438:  oclExpCS ::= oclExpCS exclamationOpt [ oclExpressionCS ]
			//
			case 438: {
				
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
			// Rule 439:  dotArrowExpCS ::= dotArrowExpCS . featureCallExpCS exclamationOpt [ oclExpressionCS ]
			//
			case 439: {
				
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
			// Rule 441:  newExpCS ::= new typespec ( argumentsCSopt )
			//
			case 441: {
				
			OCLExpressionCS result = createNewRuleCallExpCS((TypeSpecCS) dtParser.getSym(2), (EList) dtParser.getSym(4));
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
			dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 442:  oclExpCS ::= break
			//
			case 442: {
				
			OCLExpressionCS result = createBreakCS();
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 443:  oclExpCS ::= continue
			//
			case 443: {
				
			OCLExpressionCS result = createContinueCS();
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 444:  switchAltExpCS ::= ( oclExpressionCS ) ? oclExpressionCS ;
			//
			case 444: {
				
				CSTNode result = createSwitchAltExpCSDeprecated(
						(OCLExpressionCS) dtParser.getSym(2),
						(OCLExpressionCS) dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 445:  switchAltExpCS ::= ( oclExpressionCS ) qvtErrorToken
			//
			case 445: {
				
				CSTNode result = createSwitchAltExpCSDeprecated(
						(OCLExpressionCS) dtParser.getSym(2),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 446:  switchAltExpCS ::= ( qvtErrorToken
			//
			case 446: {
				
				CSTNode result = createSwitchAltExpCSDeprecated(
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 447:  switchElseExpCS ::= else ? oclExpressionCS ;
			//
			case 447: {
				
		    	int startOffset = getIToken(dtParser.getToken(1)).getStartOffset();
		    	int endOffset = getIToken(dtParser.getToken(4)).getEndOffset();
				reportWarning(org.eclipse.osgi.util.NLS.bind(org.eclipse.m2m.internal.qvt.oml.cst.parser.Messages.AbstractQVTParser_DeprecatedSwitchElseExp, null), startOffset, endOffset);
				
				dtParser.setSym1((CSTNode)dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 448:  switchElseExpCS ::= else ? oclExpressionCS qvtErrorToken
			//
			case 448: {
				
		    	int startOffset = getIToken(dtParser.getToken(1)).getStartOffset();
		    	int endOffset = getIToken(dtParser.getToken(3)).getEndOffset();
				reportWarning(org.eclipse.osgi.util.NLS.bind(org.eclipse.m2m.internal.qvt.oml.cst.parser.Messages.AbstractQVTParser_DeprecatedSwitchElseExp, null), startOffset, endOffset);
				
				dtParser.setSym1((CSTNode)dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 449:  topLevel ::= unit_elementList
			//
			case 449: {
				
				EList<CSTNode> unitElements = (EList<CSTNode>)dtParser.getSym(1);
				dtParser.setSym1(setupTopLevel(unitElements));
	  		  break;
			}
	 
			//
			// Rule 451:  _import ::= import unit ;
			//
			case 451: {
				
				CSTNode result = createImportCS(
						(PathNameCS)dtParser.getSym(2)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 452:  _import ::= import qvtErrorToken
			//
			case 452: {
				
				CSTNode result = createLibraryImportCS(
						createPathNameCS()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 454:  unit_elementList ::= unit_elementList unit_element
			//
			case 454: {
				
				EList list = (EList)dtParser.getSym(1);
				list.add(dtParser.getSym(2));
				dtParser.setSym1(list);
	  		  break;
			}
	 
			//
			// Rule 455:  unit_elementList ::= $Empty
			//
			case 455:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 466:  unit_element ::= qvtErrorToken
			//
			case 466:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 469:  transformation_decl ::= transformation_h ;
			//
			case 469: {
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) dtParser.getSym(1);
				setOffsets(headerCS, headerCS, getIToken(dtParser.getToken(2)));
				MappingModuleCS moduleCS = createMappingModuleCS(headerCS, ourEmptyEList);
				setOffsets(moduleCS, headerCS);
				dtParser.setSym1(moduleCS);
	  		  break;
			}
	 
			//
			// Rule 470:  transformation_def ::= transformation_h { module_elementList } semicolonOpt
			//
			case 470: {
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) dtParser.getSym(1);
				MappingModuleCS moduleCS = createMappingModuleCS(headerCS, (EList) dtParser.getSym(3));
				setOffsets(moduleCS, headerCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(moduleCS);
	  		  break;
			}
	 
			//
			// Rule 473:  library_decl ::= library_h ;
			//
			case 473: {
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) dtParser.getSym(1);
				setOffsets(headerCS, headerCS, getIToken(dtParser.getToken(2)));
				MappingModuleCS moduleCS = createLibraryCS(headerCS, ourEmptyEList);
				setOffsets(moduleCS, headerCS);
				dtParser.setSym1(moduleCS);
	  		  break;
			}
	 
			//
			// Rule 474:  library_def ::= library_h { module_elementList } semicolonOpt
			//
			case 474: {
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) dtParser.getSym(1);
				MappingModuleCS moduleCS = createLibraryCS(headerCS, (EList) dtParser.getSym(3));
				setOffsets(moduleCS, headerCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(moduleCS);
	  		  break;
			}
	 
			//
			// Rule 475:  transformation_h ::= qualifierList transformation qualifiedNameCS transformation_signature transformation_usage_refineOpt
			//
			case 475: {
				
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
			// Rule 476:  transformation_usage_refineOpt ::= $Empty
			//
			case 476:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 481:  transformation_refine ::= refines moduleref
			//
			case 481: {
				
				CSTNode result = createTransformationRefineCS(
						(ModuleRefCS)dtParser.getSym(2)
					);
				setOffsets(result, (ModuleRefCS)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 482:  library_h ::= library qualifiedNameCS library_signatureOpt module_usageListOpt
			//
			case 482: {
				
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
			// Rule 483:  library_h ::= library qvtErrorToken
			//
			case 483: {
				
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
			// Rule 484:  library_signatureOpt ::= $Empty
			//
			case 484:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 487:  module_usageList ::= module_usage
			//
			case 487: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 488:  module_usageList ::= module_usageList module_usage
			//
			case 488: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 489:  module_usageListOpt ::= $Empty
			//
			case 489:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 493:  access_usage ::= access module_kindOpt moduleref_list
			//
			case 493: {
				
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
			// Rule 494:  extends_usage ::= extends module_kindOpt moduleref_list
			//
			case 494: {
				
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
			// Rule 495:  module_kindOpt ::= $Empty
			//
			case 495:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 497:  module_kind ::= transformation
			//
			case 497: {
				
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.TRANSFORMATION
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 498:  module_kind ::= library
			//
			case 498: {
				
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.LIBRARY
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 499:  moduleref_list ::= moduleref
			//
			case 499: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 500:  moduleref_list ::= moduleref_list , moduleref
			//
			case 500: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 501:  moduleref_list ::= moduleref_list qvtErrorToken
			//
			case 501: {
				
				EList result = (EList) dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 502:  moduleref ::= pathNameCS simple_signatureOpt
			//
			case 502: {
				
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
			// Rule 503:  module_elementList ::= module_elementList module_element
			//
			case 503: {
				
				EList list = (EList)dtParser.getSym(1);
				list.add(dtParser.getSym(2));
				dtParser.setSym1(list);
	  		  break;
			}
	 
			//
			// Rule 504:  module_elementList ::= $Empty
			//
			case 504:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 512:  module_element ::= qvtErrorToken
			//
			case 512:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 513:  _modeltype ::= modeltype IDENTIFIER compliance_kindOpt uses packageref_list modeltype_whereOpt ;
			//
			case 513: {
				
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
			// Rule 514:  _modeltype ::= modeltype qvtErrorToken
			//
			case 514: {
				
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
			// Rule 515:  modeltype_whereOpt ::= $Empty
			//
			case 515:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 517:  modeltype_where ::= where expression_block
			//
			case 517: {
				
				BlockExpCS blockExpCS = (BlockExpCS) dtParser.getSym(2);
				dtParser.setSym1(blockExpCS.getBodyExpressions());
	  		  break;
			}
	 
			//
			// Rule 518:  packageref_list ::= packageref
			//
			case 518: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 519:  packageref_list ::= packageref_list , packageref
			//
			case 519: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 520:  packageref_list ::= packageref_list qvtErrorToken
			//
			case 520: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 521:  packageref ::= pathNameCS
			//
			case 521: {
				
				CSTNode result = createPackageRefCS(
						(PathNameCS)dtParser.getSym(1),
						null
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 522:  packageref ::= pathNameCS ( uri )
			//
			case 522: {
				
				CSTNode result = createPackageRefCS(
						(PathNameCS)dtParser.getSym(1),
						(StringLiteralExpCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 523:  packageref ::= uri
			//
			case 523: {
				
				CSTNode result = createPackageRefCS(
						null,
						(StringLiteralExpCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 524:  compliance_kindOpt ::= $Empty
			//
			case 524:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 528:  classifierDefCS ::= intermediate class qvtIdentifierCS classifierExtensionOpt { classifierFeatureListOpt } semicolonOpt
			//
			case 528: {
				
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
			// Rule 529:  classifierExtensionOpt ::= $Empty
			//
			case 529:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 530:  classifierExtensionOpt ::= extends type_list
			//
			case 530: {
				
				EList result = (EList)dtParser.getSym(2);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 531:  type_list ::= typeCS
			//
			case 531: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 532:  type_list ::= type_list , typeCS
			//
			case 532: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 533:  type_list ::= type_list qvtErrorToken
			//
			case 533: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 534:  classifierFeatureListOpt ::= $Empty
			//
			case 534:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 536:  classifierFeatureList ::= classifierFeatureCS
			//
			case 536: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 537:  classifierFeatureList ::= classifierFeatureList ; classifierFeatureCS
			//
			case 537: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 538:  classifierFeatureList ::= classifierFeatureList qvtErrorToken
			//
			case 538: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 539:  classifierFeatureCS ::= stereotype_qualifier_list feature_key_list qvtIdentifierCS : typeCS multiplicityOpt ordered_prop opposite_propertyOpt init_partOpt
			//
			case 539: {
				
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
			// Rule 541:  init_partOpt ::= $Empty
			//
			case 541:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 542:  init_partOpt ::= = oclExpressionCS
			//
			case 542: {
				
				CSTNode result = (CSTNode) dtParser.getSym(2);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 543:  stereotype_qualifier_list ::= $Empty
			//
			case 543:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 544:  stereotype_qualifier_list ::= STEREOTYPE_QUALIFIER_OPEN identifier_list STEREOTYPE_QUALIFIER_CLOSE
			//
			case 544: {
				
				EList result = (EList)dtParser.getSym(2);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 545:  identifier_list ::= qvtIdentifierCS
			//
			case 545: {
				
				EList result = new BasicEList();
				result.add(getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 546:  identifier_list ::= identifier_list , qvtIdentifierCS
			//
			case 546: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 547:  identifier_list ::= identifier_list qvtErrorToken
			//
			case 547: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 548:  feature_key_list ::= $Empty
			//
			case 548:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 549:  feature_key_list ::= feature_key_list feature_key
			//
			case 549: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 550:  feature_key_list ::= feature_key_list qvtErrorToken
			//
			case 550: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 551:  feature_key ::= composes
			//
			case 551:
 
			//
			// Rule 552:  feature_key ::= references
			//
			case 552:
 
			//
			// Rule 553:  feature_key ::= readonly
			//
			case 553:
 
			//
			// Rule 554:  feature_key ::= derived
			//
			case 554:
 
			//
			// Rule 555:  feature_key ::= static
			//
			case 555: {
				
				CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 556:  multiplicityOpt ::= $Empty
			//
			case 556:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 557:  multiplicityOpt ::= LBRACKET multiplicity_range RBRACKET
			//
			case 557: {
				
				CSTNode result = (CSTNode) dtParser.getSym(2);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 558:  multiplicity_range ::= integerLiteralExpCS
			//
			case 558: {
				
				CSTNode result = createMultiplicityDefCS(
						(PrimitiveLiteralExpCS) dtParser.getSym(1),
						(PrimitiveLiteralExpCS) dtParser.getSym(1)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 559:  multiplicity_range ::= unlimitedNaturalLiteralExpCS
			//
			case 559: {
				
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
			// Rule 560:  multiplicity_range ::= integerLiteralExpCS MULTIPLICITY_RANGE integerLiteralExpCS
			//
			case 560:
 
			//
			// Rule 561:  multiplicity_range ::= integerLiteralExpCS DOTDOT integerLiteralExpCS
			//
			case 561:
 
			//
			// Rule 562:  multiplicity_range ::= integerLiteralExpCS MULTIPLICITY_RANGE unlimitedNaturalLiteralExpCS
			//
			case 562:
 
			//
			// Rule 563:  multiplicity_range ::= integerLiteralExpCS DOTDOT unlimitedNaturalLiteralExpCS
			//
			case 563: {
				
				CSTNode result = createMultiplicityDefCS(
						(PrimitiveLiteralExpCS) dtParser.getSym(1),
						(PrimitiveLiteralExpCS) dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 564:  ordered_prop ::= ordered
			//
			case 564: {
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.TRUE.toString());
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 565:  ordered_prop ::= $Empty
			//
			case 565: {
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.FALSE.toString());
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 566:  opposite_propertyOpt ::= $Empty
			//
			case 566:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 567:  opposite_propertyOpt ::= opposites navigable_prop qvtIdentifierCS multiplicityOpt
			//
			case 567: {
				
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
			// Rule 568:  navigable_prop ::= TILDE_SIGN
			//
			case 568: {
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.FALSE.toString());
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 569:  navigable_prop ::= $Empty
			//
			case 569: {
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.TRUE.toString());
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 570:  _property ::= configuration property qvtIdentifierCS : typeCS ;
			//
			case 570: {
				
				CSTNode result = createConfigPropertyCS(
						getIToken(dtParser.getToken(3)),
						(TypeCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 571:  _property ::= configuration property qvtIdentifierCS : typeCS qvtErrorToken
			//
			case 571: {
				
				CSTNode result = createConfigPropertyCS(
						getIToken(dtParser.getToken(3)),
						(TypeCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 572:  _property ::= property qvtIdentifierCS : typeCS = oclExpressionCS ;
			//
			case 572: {
				
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
			// Rule 573:  _property ::= property qvtIdentifierCS = oclExpressionCS ;
			//
			case 573: {
				
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
			// Rule 574:  _property ::= intermediate property scoped_identifier : typeCS ;
			//
			case 574: {
				
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
			// Rule 575:  _property ::= intermediate property scoped_identifier : typeCS = oclExpressionCS ;
			//
			case 575: {
				
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
			// Rule 579:  helper_header ::= helper_info scoped_identifier complete_signature
			//
			case 579: {
				
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
			// Rule 580:  helper_header ::= helper_info qvtErrorToken
			//
			case 580: {
				
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
			// Rule 581:  helper_info ::= qualifierList helper_kind
			//
			case 581: {
				
				dtParser.setSym1(new Object[] {dtParser.getSym(1), getIToken(dtParser.getToken(2))});
	  		  break;
			}
	 
			//
			// Rule 584:  helper_decl ::= helper_header ;
			//
			case 584: {
				
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
			// Rule 585:  helper_decl ::= helper_header qvtErrorToken
			//
			case 585: {
				
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
			// Rule 586:  helper_simple_def ::= helper_header = oclExpressionCS ;
			//
			case 586: {
				
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
			// Rule 587:  helper_compound_def ::= helper_header expression_block semicolonOpt
			//
			case 587: {
				
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
			// Rule 590:  constructor_header ::= qualifierList constructor scoped_identifier simple_signature
			//
			case 590: {
				
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
			// Rule 591:  constructor_decl ::= constructor_header ;
			//
			case 591: {
				
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
			// Rule 592:  constructor_decl ::= constructor_header qvtErrorToken
			//
			case 592: {
				
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
			// Rule 593:  constructor_def ::= constructor_header expression_block semicolonOpt
			//
			case 593: {
				
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
			// Rule 596:  entry_header ::= main simple_signature
			//
			case 596: {
				
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
			// Rule 597:  entry_header ::= main qvtErrorToken
			//
			case 597: {
				
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
			// Rule 598:  entry_decl ::= entry_header ;
			//
			case 598: {
				
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
			// Rule 599:  entry_def ::= entry_header expression_block semicolonOpt
			//
			case 599: {
				
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
			// Rule 600:  _tag ::= tag stringLiteralExpCS scoped_identifier tag_valueOpt
			//
			case 600: {
				
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
			// Rule 601:  tag_valueOpt ::= $Empty
			//
			case 601:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 602:  tag_valueOpt ::= = oclExpressionCS
			//
			case 602: {
				
				dtParser.setSym1(dtParser.getSym(2));
	  		  break;
			}
	 
			//
			// Rule 605:  mapping_decl ::= mapping_full_header ;
			//
			case 605: {
				
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
			// Rule 606:  mapping_def ::= mapping_full_header { mapping_body } semicolonOpt
			//
			case 606: {
				
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
			// Rule 607:  mapping_def ::= mapping_full_header { qvtErrorToken
			//
			case 607: {
				
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
			// Rule 608:  mapping_full_header ::= mapping_header _whenOpt
			//
			case 608: {
				
				dtParser.setSym1(new Object[] {dtParser.getSym(1), dtParser.getSym(2)});
	  		  break;
			}
	 
			//
			// Rule 609:  mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier complete_signature mapping_extraList
			//
			case 609: {
				
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
			// Rule 610:  mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier qvtErrorToken
			//
			case 610: {
				
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
			// Rule 611:  mapping_header ::= qualifierList mapping qvtErrorToken
			//
			case 611: {
				
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
			// Rule 612:  mapping_extraList ::= mapping_extraList mapping_extra
			//
			case 612: {
				
				EList<MappingExtensionCS> extensionList = (EList<MappingExtensionCS>)dtParser.getSym(1);
				extensionList.add((MappingExtensionCS)dtParser.getSym(2));
				dtParser.setSym1(extensionList);
	  		  break;
			}
	 
			//
			// Rule 613:  mapping_extraList ::= $Empty
			//
			case 613:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 615:  mapping_extension ::= mapping_extension_key scoped_identifier_list
			//
			case 615: {
				
				MappingExtensionCS result = createMappingExtension(getTokenText(dtParser.getToken(1)), (EList<ScopedNameCS>)dtParser.getSym(2));

				result.setStartOffset(getIToken(dtParser.getToken(1)).getStartOffset());
				result.setEndOffset(getEndOffset(getIToken(dtParser.getToken(1)), (EList<ScopedNameCS>)dtParser.getSym(2)));
			
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 620:  _whenOpt ::= $Empty
			//
			case 620:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 621:  _when ::= when { oclExpressionCS semicolonOpt }
			//
			case 621: {
				
				OCLExpressionCS result = (OCLExpressionCS)dtParser.getSym(3);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 622:  _when ::= when qvtErrorToken
			//
			case 622:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 623:  mapping_body ::= init_sectionOpt population_sectionOpt end_sectionOpt
			//
			case 623: {
				
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
			// Rule 624:  init_sectionOpt ::= $Empty
			//
			case 624:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 626:  init_section ::= init expression_block
			//
			case 626: {
				
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
			// Rule 627:  init_section ::= init qvtErrorToken
			//
			case 627: {
				
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
			// Rule 628:  population_sectionOpt ::= $Empty
			//
			case 628: {
				
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
			// Rule 630:  population_section ::= expression_list
			//
			case 630: {
				
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
			// Rule 631:  population_section ::= population expression_block
			//
			case 631: {
				
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
			// Rule 632:  population_section ::= population qvtErrorToken
			//
			case 632: {
				
				CSTNode result = createMappingBodyCS(
						ourEmptyEList,
						true
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 633:  end_sectionOpt ::= $Empty
			//
			case 633:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 635:  end_section ::= end expression_block
			//
			case 635: {
				
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
			// Rule 636:  end_section ::= end qvtErrorToken
			//
			case 636: {
				
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
			// Rule 637:  typespecOpt ::= $Empty
			//
			case 637:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 639:  objectDeclCS ::= typespec
			//
			case 639: {
				
				CSTNode result = createOutExpCS(null, (TypeSpecCS)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 643:  objectDeclCS ::= objectIdentifierCS : typespecOpt
			//
			case 643: {
				
			SimpleNameCS varName = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(varName, getIToken(dtParser.getToken(1)));
			CSTNode result = createOutExpCS(varName,(TypeSpecCS)dtParser.getSym(3));					
			dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 644:  outExpCS ::= object objectDeclCS expression_block
			//
			case 644: {
				
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
			// Rule 645:  outExpCS ::= object objectDeclCS qvtErrorToken
			//
			case 645: {
				
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
			// Rule 646:  featureMappingCallExpCS ::= map simpleNameCS ( argumentsCSopt )
			//
			case 646: {
				
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
			// Rule 647:  featureMappingCallExpCS ::= xmap simpleNameCS ( argumentsCSopt )
			//
			case 647: {
				
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
			// Rule 648:  featureMappingCallExpCS ::= map simpleNameCS :: simpleNameCS ( argumentsCSopt )
			//
			case 648: {
				
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
			// Rule 649:  featureMappingCallExpCS ::= xmap simpleNameCS :: simpleNameCS ( argumentsCSopt )
			//
			case 649: {
				
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
			// Rule 650:  mappingCallExpCS ::= map pathNameCS ( argumentsCSopt )
			//
			case 650: {
				
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
			// Rule 651:  mappingCallExpCS ::= xmap pathNameCS ( argumentsCSopt )
			//
			case 651: {
				
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
			// Rule 652:  featureCallExpCS ::= simpleNameCS :: simpleNameCS ( argumentsCSopt )
			//
			case 652: {
				
				CSTNode result = createFeatureFQNOperationCallExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3),
						(EList)dtParser.getSym(5)
					);
				setOffsets(result, (SimpleNameCS)dtParser.getSym(1), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 653:  resolveConditionOpt ::= $Empty
			//
			case 653:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 654:  resolveConditionOpt ::= | oclExpressionCS
			//
			case 654: {
				
                dtParser.setSym1((OCLExpressionCS)dtParser.getSym(2));
      		  break;
			}
     
			//
			// Rule 655:  resolveConditionOpt ::= | qvtErrorToken
			//
			case 655:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 656:  IDENTIFIEROpt ::= $Empty
			//
			case 656:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 657:  IDENTIFIEROpt ::= IDENTIFIER :
			//
			case 657: {
				
                dtParser.setSym1(getIToken(dtParser.getToken(1)));
      		  break;
			}
     
			//
			// Rule 658:  resolveOpArgsExpCSOpt ::= $Empty
			//
			case 658:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 660:  resolveOpArgsExpCS ::= IDENTIFIEROpt typeCS resolveConditionOpt
			//
			case 660: {
				
                CSTNode result = createResolveOpArgsExpCS(
                        getIToken(dtParser.getToken(1)),      // target_type_variable?
                        (TypeCS)dtParser.getSym(2),           // type?
                        (OCLExpressionCS)dtParser.getSym(3)); // condition?
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
                    dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 665:  lateOpt ::= $Empty
			//
			case 665:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 667:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCSOpt )
			//
			case 667: {
				
                CSTNode result = createResolveExpCS(
                            getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                            (ResolveOpArgsExpCS)dtParser.getSym(4));
                            setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
                    dtParser.setSym1(result);
          		  break;
			}
         
			//
			// Rule 668:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCSOpt qvtErrorToken
			//
			case 668: {
				
                CSTNode result = createResolveExpCS(
                            getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        (ResolveOpArgsExpCS)dtParser.getSym(4));
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 669:  resolveExpCS ::= lateOpt resolveOp qvtErrorToken
			//
			case 669: {
				
                CSTNode result = createResolveExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        null);
                            setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 670:  resolveExpCS ::= late qvtErrorToken
			//
			case 670: {
				
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
			// Rule 675:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier , resolveOpArgsExpCS )
			//
			case 675: {
				
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
			// Rule 676:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier )
			//
			case 676: {
				
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
			// Rule 677:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier , resolveOpArgsExpCSOpt qvtErrorToken
			//
			case 677: {
				
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
			// Rule 678:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier qvtErrorToken
			//
			case 678: {
				
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
			// Rule 679:  resolveInExpCS ::= lateOpt resolveInOp ( qvtErrorToken
			//
			case 679: {
				
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
			// Rule 680:  resolveInExpCS ::= lateOpt resolveInOp qvtErrorToken
			//
			case 680: {
				
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
			// Rule 683:  callExpCS ::= . resolveResolveInExpCS
			//
			case 683: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 688:  simpleNameCS ::= this
			//
			case 688:
 
			//
			// Rule 689:  simpleNameCS ::= result
			//
			case 689: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
   							getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
   		  		  break;
			}
	 
			//
			// Rule 690:  _import ::= import library unit ;
			//
			case 690: {
				
				CSTNode result = createLibraryImportCS(
						(PathNameCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 691:  transformation_h ::= qualifierList transformation qualifiedNameCS
			//
			case 691: {
				
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
			// Rule 693:  renaming ::= rename typeCS . qvtIdentifierCS = stringLiteralExpCS ;
			//
			case 693: {
				
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

