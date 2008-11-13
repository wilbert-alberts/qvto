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
* $Id: QvtOpLPGParser.java,v 1.18 2008/11/13 15:22:03 aigdalov Exp $
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
* $Id: QvtOpLPGParser.java,v 1.18 2008/11/13 15:22:03 aigdalov Exp $
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
* $Id: QvtOpLPGParser.java,v 1.18 2008/11/13 15:22:03 aigdalov Exp $
*/

package org.eclipse.m2m.internal.qvt.oml.cst.parser;

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
import java.util.Map;
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
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingEndCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingInitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS;
import org.eclipse.m2m.internal.qvt.oml.cst.OutExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS;
import org.eclipse.m2m.internal.qvt.oml.cst.temp.ResolveOpArgsExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.temp.ScopedNameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS;

	public class QvtOpLPGParser extends AbstractQVTParser implements RuleAction {
	protected static ParseTable prs = new QvtOpLPGParserprs();
	private BacktrackingParser dtParser;
	private static Map<Integer, String> ruleTexts;

	public QvtOpLPGParser(QvtOpLexer lexer) {
		super(lexer);

		try {
			super.remapTerminalSymbols(orderedTerminalSymbols(), QvtOpLPGParserprs.EOFT_SYMBOL);
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
				error += "\t" + QvtOpLPGParsersym.orderedTerminalSymbols[id.intValue()];			   
			}
			throw new RuntimeException(error + "\n");						
		}
		catch(UndefinedEofSymbolException e) {
			throw new RuntimeException("The Lexer does not implement the Eof symbol " +
				 QvtOpLPGParsersym.orderedTerminalSymbols[QvtOpLPGParserprs.EOFT_SYMBOL]);
		} 
	}
	 
	@Override
	public String[] orderedTerminalSymbols() { return QvtOpLPGParsersym.orderedTerminalSymbols; }
	@Override		
	public String getTokenKindName(int kind) { return QvtOpLPGParsersym.orderedTerminalSymbols[kind]; }			
	public int getEOFTokenKind() { return QvtOpLPGParserprs.EOFT_SYMBOL; }
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
		ParseTable prsTable = new QvtOpLPGParserprs();

		try {
			dtParser = new BacktrackingParser(monitor, this, prsTable, this);
		}
		catch (NotBacktrackParseTableException e) {
			throw new RuntimeException("****Error: Regenerate QvtOpLPGParserprs.java with -NOBACKTRACK option");
		}
		catch (BadParseSymFileException e) {
			throw new RuntimeException("****Error: Bad Parser Symbol File -- QvtOpLPGParsersym.java. Regenerate QvtOpLPGParserprs.java");
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
            makeToken(lastT.getEndOffset() + i + someHugeOffset, lastT.getEndOffset() + i + someHugeOffset + 1, QvtOpLPGParsersym.TK_EOF_TOKEN);
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
	private static final boolean DEBUG = false;
	
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
        if (DEBUG) {
           System.out.println("RULE[" + ruleNumber + "]:   " + ruleTexts.get(ruleNumber)); //$NON-NLS-1$
        }
        switch(ruleNumber)
        {
 
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
			// Rule 142:  iterContents ::= oclExpressionCS
			//
			case 142: {
				
				dtParser.setSym1(new Object[] {
						null,
						null,
						dtParser.getSym(1)
					});
	  		  break;
			}
	 
			//
			// Rule 143:  iterContents ::= variableCS | oclExpressionCS
			//
			case 143: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						null,
						dtParser.getSym(3)
					});
	  		  break;
			}
	 
			//
			// Rule 144:  iterContents ::= variableCS , variableCS | oclExpressionCS
			//
			case 144: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						dtParser.getSym(3),
						dtParser.getSym(5)
					});
	  		  break;
			}
	 
			//
			// Rule 145:  iterateExpCS ::= iterate ( variableCS | oclExpressionCS )
			//
			case 145: {
				
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
			// Rule 146:  iterateExpCS ::= iterate ( variableCS ; variableCS | oclExpressionCS )
			//
			case 146: {
				
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
			// Rule 147:  variableCS ::= IDENTIFIER
			//
			case 147: {
				
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
			// Rule 148:  variableCS ::= IDENTIFIER : typeCS
			//
			case 148: {
				
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
			// Rule 149:  variableCS ::= IDENTIFIER : typeCS = oclExpressionCS
			//
			case 149: {
				
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
			// Rule 150:  variableCS2 ::= IDENTIFIER = oclExpressionCS
			//
			case 150: {
				
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
			// Rule 155:  collectionTypeCS ::= collectionTypeIdentifierCS ( typeCS )
			//
			case 155: {
				
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
			// Rule 156:  tupleTypeCS ::= Tuple ( variableListCSopt )
			//
			case 156: {
				
				CSTNode result = createTupleTypeCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 157:  variableListCSopt ::= $Empty
			//
			case 157:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 159:  variableListCS ::= variableCS
			//
			case 159: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 160:  variableListCS ::= variableListCS , variableCS
			//
			case 160: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 161:  variableListCS2 ::= variableCS2
			//
			case 161:
 
			//
			// Rule 162:  variableListCS2 ::= variableCS
			//
			case 162: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 163:  variableListCS2 ::= variableListCS2 , variableCS2
			//
			case 163:
 
			//
			// Rule 164:  variableListCS2 ::= variableListCS2 , variableCS
			//
			case 164: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 167:  featureCallExpCS ::= MINUS isMarkedPreCS ( argumentsCSopt )
			//
			case 167:
 
			//
			// Rule 168:  featureCallExpCS ::= not isMarkedPreCS ( argumentsCSopt )
			//
			case 168: {
				
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
			// Rule 169:  operationCallExpCS ::= simpleNameCS isMarkedPreCS ( argumentsCSopt )
			//
			case 169: {
				
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
			// Rule 170:  operationCallExpCS ::= oclIsUndefined isMarkedPreCS ( argumentsCSopt )
			//
			case 170:
 
			//
			// Rule 171:  operationCallExpCS ::= oclIsInvalid isMarkedPreCS ( argumentsCSopt )
			//
			case 171:
 
			//
			// Rule 172:  operationCallExpCS ::= oclIsNew isMarkedPreCS ( argumentsCSopt )
			//
			case 172:
 
			//
			// Rule 173:  operationCallExpCS ::= EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 173:
 
			//
			// Rule 174:  operationCallExpCS ::= NOT_EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 174:
 
			//
			// Rule 175:  operationCallExpCS ::= PLUS isMarkedPreCS ( argumentsCSopt )
			//
			case 175:
 
			//
			// Rule 176:  operationCallExpCS ::= MULTIPLY isMarkedPreCS ( argumentsCSopt )
			//
			case 176:
 
			//
			// Rule 177:  operationCallExpCS ::= DIVIDE isMarkedPreCS ( argumentsCSopt )
			//
			case 177:
 
			//
			// Rule 178:  operationCallExpCS ::= GREATER isMarkedPreCS ( argumentsCSopt )
			//
			case 178:
 
			//
			// Rule 179:  operationCallExpCS ::= LESS isMarkedPreCS ( argumentsCSopt )
			//
			case 179:
 
			//
			// Rule 180:  operationCallExpCS ::= GREATER_EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 180:
 
			//
			// Rule 181:  operationCallExpCS ::= LESS_EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 181:
 
			//
			// Rule 182:  operationCallExpCS ::= and isMarkedPreCS ( argumentsCSopt )
			//
			case 182:
 
			//
			// Rule 183:  operationCallExpCS ::= or isMarkedPreCS ( argumentsCSopt )
			//
			case 183:
 
			//
			// Rule 184:  operationCallExpCS ::= xor isMarkedPreCS ( argumentsCSopt )
			//
			case 184:
 
			//
			// Rule 185:  keywordOperationCallExpCS ::= keywordAsIdentifier isMarkedPreCS ( argumentsCSopt )
			//
			case 185: {
				
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
			// Rule 186:  operationCallExpCS ::= oclIsInState isMarkedPreCS ( pathNameCSOpt )
			//
			case 186: {
				
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
			// Rule 187:  attrOrNavCallExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 187: {
				
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
			// Rule 188:  attrOrNavCallExpCS ::= keywordAsIdentifier isMarkedPreCS
			//
			case 188: {
				
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
			// Rule 189:  isMarkedPreCS ::= $Empty
			//
			case 189: {
				
				CSTNode result = createIsMarkedPreCS(false);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 190:  isMarkedPreCS ::= @pre
			//
			case 190: {
				
				CSTNode result = createIsMarkedPreCS(true);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 191:  argumentsCSopt ::= $Empty
			//
			case 191:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 193:  argumentsCS ::= oclExpressionCS
			//
			case 193: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 194:  argumentsCS ::= argumentsCS , oclExpressionCS
			//
			case 194: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 195:  letExpCS ::= let variableCS letExpSubCSopt in oclExpressionCS
			//
			case 195: {
				
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
			// Rule 196:  letExpSubCSopt ::= $Empty
			//
			case 196:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 198:  letExpSubCS ::= , variableCS
			//
			case 198: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 199:  letExpSubCS ::= letExpSubCS , variableCS
			//
			case 199: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 200:  messageExpCS ::= ^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 200:
 
			//
			// Rule 201:  messageExpCS ::= ^^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 201: {
				
				CSTNode result = createMessageExpCS(
						getIToken(dtParser.getToken(1)).getKind() == QvtOpLPGParsersym.TK_CARET,
						(SimpleNameCS)dtParser.getSym(2),
						(EList<OCLMessageArgCS>)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 202:  oclMessageArgumentsCSopt ::= $Empty
			//
			case 202:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 204:  oclMessageArgumentsCS ::= oclMessageArgCS
			//
			case 204: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 205:  oclMessageArgumentsCS ::= oclMessageArgumentsCS , oclMessageArgCS
			//
			case 205: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 206:  oclMessageArgCS ::= oclExpressionCS
			//
			case 206: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 207:  oclMessageArgCS ::= ?
			//
			case 207: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 208:  oclMessageArgCS ::= ? : typeCS
			//
			case 208: {
				
				CSTNode result = createOCLMessageArgCS(
						(TypeCS)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 209:  declarator ::= IDENTIFIER : typeCS
			//
			case 209: {
				
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
			// Rule 210:  declarator ::= IDENTIFIER : typeCS = oclExpressionCS
			//
			case 210: {
				
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
			// Rule 211:  declarator ::= IDENTIFIER : typeCS := oclExpressionCS
			//
			case 211: {
				
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
			// Rule 212:  declarator ::= IDENTIFIER := oclExpressionCS
			//
			case 212: {
				
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
			// Rule 214:  returnExpCS ::= return oclExpressionCSOpt
			//
			case 214: {
				
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
			// Rule 216:  oclExpressionCSOpt ::= $Empty
			//
			case 216:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 217:  statementListOpt ::= $Empty
			//
			case 217:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 219:  statementList ::= qvtErrorToken
			//
			case 219: {
				
				EList result = new BasicEList();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 222:  statementInnerList ::= statementCS
			//
			case 222: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 223:  statementInnerList ::= statementInnerList ; statementCS
			//
			case 223: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 224:  statementInnerList ::= statementInnerList qvtErrorToken
			//
			case 224: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 227:  statementCS ::= oclExpressionCS
			//
			case 227: {
				
				CSTNode result = createExpressionStatementCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 228:  statementCS ::= primaryOCLExpressionCS
			//
			case 228: {
				
				CSTNode result = createExpressionStatementCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 230:  variableInitializationCSCorrect ::= var IDENTIFIER : typeCS := oclExpressionCS
			//
			case 230: {
				
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
			// Rule 231:  variableInitializationCS ::= var IDENTIFIER : typeCS := qvtErrorToken
			//
			case 231: {
				
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
			// Rule 232:  variableInitializationCSCorrect ::= var IDENTIFIER := oclExpressionCS
			//
			case 232: {
				
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
			// Rule 233:  variableInitializationCS ::= var IDENTIFIER := qvtErrorToken
			//
			case 233: {
				
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
			// Rule 234:  variableInitializationCSCorrect ::= var IDENTIFIER : typeCS
			//
			case 234: {
				
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
			// Rule 235:  variableInitializationCS ::= var IDENTIFIER : qvtErrorToken
			//
			case 235: {
				
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
			// Rule 236:  assignStatementCS ::= oclExpressionCS := oclExpressionCS
			//
			case 236: {
				
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
			// Rule 237:  assignStatementCS ::= oclExpressionCS := qvtErrorToken
			//
			case 237: {
				
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
			// Rule 238:  assignStatementCS ::= oclExpressionCS += oclExpressionCS
			//
			case 238: {
				
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
			// Rule 239:  assignStatementCS ::= oclExpressionCS += qvtErrorToken
			//
			case 239: {
				
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
			// Rule 241:  legacyWhileExpCS ::= while ( oclExpressionCS ; oclExpressionCS ) whileBodyCS
			//
			case 241: {
				
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
			// Rule 242:  whileExpCS ::= while ( declarator ; oclExpressionCS ) whileBodyCS
			//
			case 242: {
				
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
			// Rule 243:  whileExpCS ::= while ( oclExpressionCS ) whileBodyCS
			//
			case 243: {
				
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
			// Rule 247:  forExpDeclaratorList ::= IDENTIFIER
			//
			case 247: {
				
		EList result = new BasicEList();
		result.add(getIToken(dtParser.getToken(1)));
		dtParser.setSym1(result);
          		  break;
			}
    	 
			//
			// Rule 248:  forExpDeclaratorList ::= forExpDeclaratorList , IDENTIFIER
			//
			case 248: {
				
		EList result = (EList)dtParser.getSym(1);
		result.add(getIToken(dtParser.getToken(3)));
		dtParser.setSym1(result);
          		  break;
			}
    	 
			//
			// Rule 249:  forExpConditionOpt ::= $Empty
			//
			case 249:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 250:  forExpConditionOpt ::= | oclExpressionCS
			//
			case 250: {
				
            	    dtParser.setSym1((OCLExpressionCS)dtParser.getSym(2));
          		  break;
			}
    	 
			//
			// Rule 251:  forExpConditionOpt ::= | qvtErrorToken
			//
			case 251:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 252:  forExpCS ::= forOpCode ( forExpDeclaratorList forExpConditionOpt ) expression_block
			//
			case 252: {
				
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
			// Rule 253:  forExpCS ::= forOpCode qvtErrorToken
			//
			case 253: {
				
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
			// Rule 257:  letExpSubCS3 ::= variableCS2
			//
			case 257: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 258:  letExpSubCS3 ::= letExpSubCS3 , variableCS2
			//
			case 258: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 259:  letExpCS ::= let letExpSubCS3 in oclExpressionCS
			//
			case 259: {
				
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
			// Rule 260:  letExpCS ::= let letExpSubCS3 in qvtErrorToken
			//
			case 260: {
				
				EList variables = (EList)dtParser.getSym(2);
				CSTNode result = createLetExpCS(
						variables,
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "") //$NON-NLS-1$
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 261:  complianceKindCSOpt ::= $Empty
			//
			case 261: {
				
				CSTNode result = createStringLiteralExpCS("''");
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 264:  qvtStringLiteralExpCS ::= QUOTE_STRING_LITERAL
			//
			case 264: {
				
				CSTNode result = createStringLiteralExpCS("'" + unquote(getTokenText(dtParser.getToken(1))) + "'"); //$NON-NLS-1$ //$NON-NLS-2$
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 267:  qvtErrorToken ::= ERROR_TOKEN
			//
			case 267: {
				
				diagnozeErrorToken(dtParser.getToken(1));
	  		  break;
			}
	 
			//
			// Rule 268:  iterContents ::= variableCS | qvtErrorToken
			//
			case 268: {
				
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
			// Rule 269:  callExpCS ::= . qvtErrorToken
			//
			case 269: {
				
				CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
	 			result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 270:  callExpCS ::= -> qvtErrorToken
			//
			case 270: {
				
				CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
	 			result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 271:  argumentsCS ::= qvtErrorToken
			//
			case 271:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 275:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS else ifExpBodyCS endif
			//
			case 275: {
				
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
			// Rule 276:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS endif
			//
			case 276: {
				
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
			// Rule 277:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS else ifExpBodyCS qvtErrorToken
			//
			case 277: {
				
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
			// Rule 278:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS else qvtErrorToken
			//
			case 278: {
				
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
			// Rule 279:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS qvtErrorToken
			//
			case 279: {
				
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
			// Rule 280:  ifExpCS ::= if oclExpressionCS then qvtErrorToken
			//
			case 280: {
				
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
			// Rule 281:  ifExpCS ::= if oclExpressionCS qvtErrorToken
			//
			case 281: {
				
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
			// Rule 282:  ifExpCS ::= if qvtErrorToken
			//
			case 282: {
				
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
			// Rule 285:  switchExpCS ::= switch switchBodyExpCS
			//
			case 285: {
				
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
			// Rule 287:  switchDeclaratorCS ::= IDENTIFIER
			//
			case 287: {
				
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
			// Rule 288:  switchDeclaratorCS ::= IDENTIFIER = oclExpressionCS
			//
			case 288: {
				
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
			// Rule 289:  iterateSwitchExpCS ::= switch ( switchDeclaratorCS ) switchBodyExpCS
			//
			case 289: {
				
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
			// Rule 290:  switchExpCS ::= switch qvtErrorToken
			//
			case 290: {
				
				CSTNode result = createSwitchExpCS(
						new BasicEList(),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 291:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt }
			//
			case 291: {
				
				Object[] result = new Object[] {dtParser.getSym(2), dtParser.getSym(3), getIToken(dtParser.getToken(4))};
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 292:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt qvtErrorToken
			//
			case 292: {
				
				Object[] result = new Object[] {dtParser.getSym(2), dtParser.getSym(3), dtParser.getSym(3)};
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 293:  switchBodyExpCS ::= { qvtErrorToken
			//
			case 293: {
				
				Object[] result = new Object[] {new BasicEList(), null, getIToken(dtParser.getToken(1))};
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 294:  switchAltExpCSList ::= switchAltExpCS
			//
			case 294: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 295:  switchAltExpCSList ::= switchAltExpCSList switchAltExpCS
			//
			case 295: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 296:  switchAltExpCS ::= ( oclExpressionCS ) ? statementCS ;
			//
			case 296: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(2),
						(OCLExpressionCS) dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 297:  switchAltExpCS ::= case ( oclExpressionCS ) expressionStatementCS
			//
			case 297: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(3),
						(OCLExpressionCS) dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 298:  switchAltExpCS ::= ( oclExpressionCS ) ? statementCS qvtErrorToken
			//
			case 298: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(2),
						(OCLExpressionCS) dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode) dtParser.getSym(5));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 299:  switchAltExpCS ::= ( oclExpressionCS ) qvtErrorToken
			//
			case 299: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(2),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 300:  switchAltExpCS ::= ( qvtErrorToken
			//
			case 300: {
				
				CSTNode result = createSwitchAltExpCS(
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 301:  switchElseExpCSOpt ::= $Empty
			//
			case 301:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 303:  switchElseExpCS ::= else ? statementCS ;
			//
			case 303: {
				
				dtParser.setSym1((CSTNode)dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 304:  switchElseExpCS ::= else expressionStatementCS
			//
			case 304: {
				
				dtParser.setSym1((CSTNode)dtParser.getSym(2));
	  		  break;
			}
	 
			//
			// Rule 305:  switchElseExpCS ::= else ? statementCS qvtErrorToken
			//
			case 305: {
				
				dtParser.setSym1((CSTNode)dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 306:  switchElseExpCS ::= else qvtErrorToken
			//
			case 306: {
				
				dtParser.setSym1(null);
	  		  break;
			}
	 
			//
			// Rule 318:  iteratorExpCS ::= iteratorExpCSToken ( iterContents )
			//
			case 318: {
				
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
			// Rule 319:  iteratorExpCS ::= iteratorExpCSToken ( iterContents qvtErrorToken
			//
			case 319: {
				
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
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
		        for (int i = iterContents.length - 1; i >= 0; i--) {
		        	if (iterContents[i] instanceof CSTNode) {
		        		setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode) iterContents[i]);
		        		break;
		        	}
		        }
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 320:  iteratorExpCS ::= iteratorExpCSToken ( qvtErrorToken
			//
			case 320: {
				
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
			// Rule 321:  operationCallExpCS ::= oclAsType isMarkedPreCS ( typeCS )
			//
			case 321:
 
			//
			// Rule 322:  operationCallExpCS ::= oclIsKindOf isMarkedPreCS ( typeCS )
			//
			case 322:
 
			//
			// Rule 323:  operationCallExpCS ::= oclIsTypeOf isMarkedPreCS ( typeCS )
			//
			case 323: {
				
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
			// Rule 325:  logWhenExp ::= when oclExpressionCS
			//
			case 325: {
				
			OCLExpressionCS condition = (OCLExpressionCS) dtParser.getSym(2);
			dtParser.setSym1(condition);
      		  break;
			}
     
			//
			// Rule 327:  logWhenExpOpt ::= $Empty
			//
			case 327:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 328:  logExpCS ::= log ( argumentsCSopt ) logWhenExpOpt
			//
			case 328: {
				
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
			// Rule 330:  severityKindCS ::= simpleNameCS
			//
			case 330: {
				
			dtParser.setSym1(dtParser.getSym(1));
	  		  break;
			}
	 
			//
			// Rule 332:  severityKindCSOpt ::= $Empty
			//
			case 332:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 333:  assertWithLogExp ::= with logExpCS
			//
			case 333: {
				
			LogExpCS logExp = (LogExpCS) dtParser.getSym(2);
			setOffsets(logExp, getIToken(dtParser.getToken(2)), logExp);
			dtParser.setSym1(logExp);
      		  break;
			}
     
			//
			// Rule 335:  assertWithLogExpOpt ::= $Empty
			//
			case 335:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 336:  assertExpCS ::= assert severityKindCSOpt ( oclExpressionCS ) assertWithLogExpOpt
			//
			case 336: {
				
			LogExpCS logExpCS = (LogExpCS)dtParser.getSym(6);
			OCLExpressionCS condition = (OCLExpressionCS)dtParser.getSym(4);
			AssertExpCS result = (AssertExpCS)createAssertExpCS(condition, (SimpleNameCS)dtParser.getSym(2), logExpCS);
	
			CSTNode end = logExpCS != null ? logExpCS : condition; 
			setOffsets(result, getIToken(dtParser.getToken(1)), end);
			dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 337:  expression_block ::= { statementListOpt }
			//
			case 337: {
				
			EList bodyList = (EList) dtParser.getSym(2);
			CSTNode result = createBlockExpCS(
				bodyList
			);
			
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
			dtParser.setSym1(result);
      		  break;
			}
	 
			//
			// Rule 341:  computeExpCS ::= compute ( declarator ) expression_block
			//
			case 341: {
				
				CSTNode result = createComputeExpCS(
					(VariableCS) dtParser.getSym(3),
					(OCLExpressionCS) dtParser.getSym(5)
				);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 352:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken12 ( imperativeIterContents12 )
			//
			case 352:
 
			//
			// Rule 353:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken3 ( imperativeIterContents3 )
			//
			case 353: {
				
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
			// Rule 354:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken qvtErrorToken
			//
			case 354: {
				
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
			// Rule 355:  imperativeIterContents12 ::= oclExpressionCS
			//
			case 355: {
				
				dtParser.setSym1(new Object[] {
						ourEmptyEList,
						null,
						dtParser.getSym(1)
					});
	  		  break;
			}
	 
			//
			// Rule 356:  imperativeIterContents12 ::= variableListCS | oclExpressionCS
			//
			case 356: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						null,
						dtParser.getSym(3)
					});
	  		  break;
			}
	 
			//
			// Rule 357:  imperativeIterContents3 ::= variableListCS ; variableCS2 | oclExpressionCS
			//
			case 357: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						dtParser.getSym(3),
						dtParser.getSym(5)
					});
	  		  break;
			}
	 
			//
			// Rule 358:  exclamationOpt ::= $Empty
			//
			case 358:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 360:  declarator_vsep ::= IDENTIFIER |
			//
			case 360: {
				
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
			// Rule 361:  declarator_vsepOpt ::= $Empty
			//
			case 361:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 363:  callExpCS ::= -> featureCallExpCS exclamationOpt [ declarator_vsepOpt oclExpressionCS ]
			//
			case 363: {
				
	        String opCode = isTokenOfType(getIToken(dtParser.getToken(3)), QvtOpLPGParsersym.TK_EXCLAMATION_MARK) ?  "collectselectOne" : "collectselect"; //$NON-NLS-1$ //$NON-NLS-2$ 
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
			// Rule 364:  oclExpCS ::= oclExpCS exclamationOpt [ oclExpressionCS ]
			//
			case 364: {
				
			        String opCode = isTokenOfType(getIToken(dtParser.getToken(2)), QvtOpLPGParsersym.TK_EXCLAMATION_MARK) ?  "selectOne" : "xselect"; //$NON-NLS-1$ //$NON-NLS-2$ 
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
			// Rule 365:  dotArrowExpCS ::= dotArrowExpCS . featureCallExpCS exclamationOpt [ oclExpressionCS ]
			//
			case 365: {
				
				CallExpCS callExpCS = (CallExpCS)dtParser.getSym(3);
				callExpCS.setSource((OCLExpressionCS)dtParser.getSym(1));
				callExpCS.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				setOffsets(callExpCS, (CSTNode)dtParser.getSym(1), callExpCS);


			        String opCode = isTokenOfType(getIToken(dtParser.getToken(4)), QvtOpLPGParsersym.TK_EXCLAMATION_MARK) ?  "selectOne" : "xselect"; //$NON-NLS-1$ //$NON-NLS-2$ 
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
			// Rule 366:  equalityExpCS ::= equalityExpCS != relationalExpCS
			//
			case 366:
 
			//
			// Rule 367:  equalityWithLet ::= equalityExpCS != relationalWithLet
			//
			case 367: {
				
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
			// Rule 369:  newExpCS ::= new pathNameCS ( argumentsCSopt )
			//
			case 369: {
				
			OCLExpressionCS result = createNewRuleCallExpCS((PathNameCS)dtParser.getSym(2),(EList)dtParser.getSym(4));
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
			dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 372:  mappingModuleCS ::= moduleImportListOpt metamodelListOpt transformationCS moduleImportListOpt metamodelListOpt renamingListOpt propertyListOpt mappingRuleListOpt
			//
			case 372: {
				
				EList metamodels = (EList)dtParser.getSym(2);
				metamodels.addAll((EList)dtParser.getSym(5));
				EList imports = (EList)dtParser.getSym(1);
				imports.addAll((EList)dtParser.getSym(4));
				CSTNode header = (CSTNode) dtParser.getSym(3);
				CSTNode result = createMappingModuleCS(
						(TransformationHeaderCS) header,
						imports,
						metamodels,
						(EList)dtParser.getSym(6),
						(EList)dtParser.getSym(7),
						(EList)dtParser.getSym(8)
					);
				IToken headerToken = new Token(header.getStartOffset(), header.getEndOffset(), 0);
				int endOffset = getEndOffset(headerToken, (EList)dtParser.getSym(4),
						(EList)dtParser.getSym(5), (EList)dtParser.getSym(6), (EList)dtParser.getSym(7), (EList)dtParser.getSym(8)); 
				setOffsets(result, header);
				result.setEndOffset(endOffset);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 373:  mappingModuleCS ::= moduleImportListOpt metamodelListOpt transformationCS qvtErrorToken
			//
			case 373: {
				
				CSTNode result = createMappingModuleCS(
						(TransformationHeaderCS)dtParser.getSym(3),
						ourEmptyEList,
						ourEmptyEList,
						ourEmptyEList,
						ourEmptyEList,
						ourEmptyEList
					);
				setOffsets(result, (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 374:  mappingModuleCS ::= moduleImportListOpt metamodelListOpt qualifierList transformation qvtErrorToken
			//
			case 374: {
				
				CSTNode result = createMappingModuleCS(
						createPathNameCS(),
						ourEmptyEList,
						ourEmptyEList,
						ourEmptyEList,
						ourEmptyEList,
						ourEmptyEList
					);
				setOffsets(result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 375:  transformationCS ::= transformationHeaderCS ;
			//
			case 375: {
				
				TransformationHeaderCS result = (TransformationHeaderCS) dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 376:  transformationHeaderCS ::= qualifierList transformation qualifiedNameCS
			//
			case 376: {
				
				EList qualifierList = (EList) dtParser.getSym(1);
				CSTNode result = createTransformationHeaderCS(
						qualifierList,
						(PathNameCS)dtParser.getSym(3),
						ourEmptyEList,
						ourEmptyEList,
						null
					);
				if (qualifierList.isEmpty()) {
					setOffsets(result, getIToken(dtParser.getToken(2)), getIToken(dtParser.getToken(4)));
				}
				else {
					setOffsets(result, (CSTNode) qualifierList.get(qualifierList.size()-1), getIToken(dtParser.getToken(4)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 377:  transformationHeaderCS ::= qualifierList transformation qualifiedNameCS ( transfParamListOpt ) moduleUsageListOpt transformationRefineCSOpt
			//
			case 377: {
				
				EList qualifierList = (EList) dtParser.getSym(1);
				EList transfUsages = (EList) dtParser.getSym(7);
				TransformationRefineCS transfRefine = (TransformationRefineCS) dtParser.getSym(8);
				CSTNode result = createTransformationHeaderCS(
						qualifierList,
						(PathNameCS)dtParser.getSym(3),
						(EList)dtParser.getSym(5),
						transfUsages,
						transfRefine
					);
				if (qualifierList.isEmpty()) {
					setOffsets(result, getIToken(dtParser.getToken(2)));
				}
				else {
					setOffsets(result, (CSTNode) qualifierList.get(qualifierList.size()-1));
				}
				if (transfRefine == null) {
					if (transfUsages.isEmpty()) {
						setOffsets(result, result, getIToken(dtParser.getToken(6)));
					}
					else {
						setOffsets(result, result, (CSTNode) transfUsages.get(transfUsages.size()-1));
					}
				}
				else {
					setOffsets(result, result, transfRefine);
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 378:  transformationRefineCSOpt ::= $Empty
			//
			case 378:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 379:  transformationRefineCSOpt ::= refines moduleRefCS enforcing IDENTIFIER
			//
			case 379: {
				
				CSTNode result = createTransformationRefineCS(
						(ModuleRefCS)dtParser.getSym(2),
						getIToken(dtParser.getToken(4))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 380:  moduleUsageListOpt ::= $Empty
			//
			case 380:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 382:  moduleUsageList ::= moduleUsageCS
			//
			case 382: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 383:  moduleUsageList ::= moduleUsageList moduleUsageCS
			//
			case 383: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 384:  moduleUsageCS ::= access moduleKindOpt moduleRefList
			//
			case 384: {
				
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
			// Rule 385:  moduleUsageCS ::= extends moduleKindOpt moduleRefList
			//
			case 385: {
				
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
			// Rule 386:  moduleKindOpt ::= $Empty
			//
			case 386:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 388:  moduleKindCS ::= transformation
			//
			case 388: {
				
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.TRANSFORMATION
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 389:  moduleKindCS ::= library
			//
			case 389: {
				
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.LIBRARY
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 390:  moduleRefList ::= moduleRefCS
			//
			case 390: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 391:  moduleRefList ::= moduleRefList , moduleRefCS
			//
			case 391: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 392:  moduleRefList ::= moduleRefList qvtErrorToken
			//
			case 392: {
				
				EList result = (EList) dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 393:  moduleRefCS ::= pathNameCS
			//
			case 393: {
				
				CSTNode result = createModuleRefCS(
						(PathNameCS)dtParser.getSym(1),
						ourEmptyEList
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 394:  moduleRefCS ::= pathNameCS ( transfParamListOpt )
			//
			case 394: {
				
				CSTNode result = createModuleRefCS(
						(PathNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 395:  transfParamListOpt ::= $Empty
			//
			case 395:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 397:  transfParamList ::= transfParamCS
			//
			case 397: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 398:  transfParamList ::= transfParamList , transfParamCS
			//
			case 398: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 399:  transfParamList ::= transfParamList qvtErrorToken
			//
			case 399: {
				
				EList result = (EList) dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 400:  transfParamCS ::= param_directionOpt pathNameCS
			//
			case 400: {
				
				DirectionKindCS directionKind = (DirectionKindCS) dtParser.getSym(1);
				TypeSpecCS typeSpecCS = createTypeSpecCS((PathNameCS)dtParser.getSym(2), null);
				CSTNode result = createParameterDeclarationCS(
						directionKind,
						null,
						typeSpecCS
					);
				setOffsets(result, directionKind == null ? (CSTNode)dtParser.getSym(2) : directionKind, (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 401:  transfParamCS ::= param_directionOpt IDENTIFIER : pathNameCS
			//
			case 401: {
				
				DirectionKindCS directionKind = (DirectionKindCS) dtParser.getSym(1);
				TypeSpecCS typeSpecCS = createTypeSpecCS((PathNameCS)dtParser.getSym(4), null);
				CSTNode result = createParameterDeclarationCS(
						directionKind,
						getIToken(dtParser.getToken(2)),
						typeSpecCS
					);
				if (directionKind == null) {
					setOffsets(result, getIToken(dtParser.getToken(2)), (CSTNode)dtParser.getSym(4));
				}
				else {
					setOffsets(result, directionKind, (CSTNode)dtParser.getSym(4));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 402:  libraryCS ::= moduleImportListOpt metamodelListOpt library qualifiedNameCS ; moduleImportListOpt metamodelListOpt renamingListOpt propertyListOpt mappingRuleListOpt
			//
			case 402: {
				
				EList metamodels = (EList)dtParser.getSym(2);
				metamodels.addAll((EList)dtParser.getSym(7));
				EList imports = (EList)dtParser.getSym(1);
				imports.addAll((EList)dtParser.getSym(6));
				CSTNode result = createLibraryCS(
						(PathNameCS)dtParser.getSym(4),
						imports,
						metamodels,
						(EList)dtParser.getSym(8),
						(EList)dtParser.getSym(9),
						(EList)dtParser.getSym(10)
					);
				int endOffset = getEndOffset(getIToken(dtParser.getToken(5)), (EList)dtParser.getSym(6),
						(EList)dtParser.getSym(7), (EList)dtParser.getSym(8), (EList)dtParser.getSym(9), (EList)dtParser.getSym(10)); 
				setOffsets(result, getIToken(dtParser.getToken(3)), new Token(0, endOffset, 0));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 403:  libraryCS ::= moduleImportListOpt metamodelListOpt library qualifiedNameCS ; qvtErrorToken
			//
			case 403: {
				
				CSTNode result = createLibraryCS(
						createPathNameCS(),
						ourEmptyEList,
						ourEmptyEList,
						ourEmptyEList,
						ourEmptyEList,
						ourEmptyEList
					);
				setOffsets(result, getIToken(dtParser.getToken(3)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 404:  libraryCS ::= moduleImportListOpt metamodelListOpt library qualifiedNameCS qvtErrorToken
			//
			case 404: {
				
				CSTNode result = createLibraryCS(
						createPathNameCS(),
						ourEmptyEList,
						ourEmptyEList,
						ourEmptyEList,
						ourEmptyEList,
						ourEmptyEList
					);
				setOffsets(result, getIToken(dtParser.getToken(3)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 405:  libraryCS ::= moduleImportListOpt metamodelListOpt library qvtErrorToken
			//
			case 405: {
				
				CSTNode result = createLibraryCS(
						createPathNameCS(),
						ourEmptyEList,
						ourEmptyEList,
						ourEmptyEList,
						ourEmptyEList,
						ourEmptyEList
					);
				setOffsets(result, getIToken(dtParser.getToken(3)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 406:  qualifiedNameCS ::= qvtIdentifierCS
			//
			case 406: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 407:  qualifiedNameCS ::= qualifiedNameCS . qvtIdentifierCS
			//
			case 407: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 408:  qualifiedNameCS ::= qualifiedNameCS . qvtErrorToken
			//
			case 408: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, "");
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 409:  qualifiedNameCS ::= qualifiedNameCS qvtErrorToken
			//
			case 409: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}	
	 
			//
			// Rule 410:  moduleImportListOpt ::= $Empty
			//
			case 410:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 412:  moduleImportList ::= importCS
			//
			case 412: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 413:  moduleImportList ::= moduleImportList importCS
			//
			case 413: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 414:  moduleImportList ::= moduleImportList qvtErrorToken
			//
			case 414: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 415:  importCS ::= import qualifiedNameCS ;
			//
			case 415: {
				
				CSTNode result = createModuleImportCS(
						(PathNameCS)dtParser.getSym(2)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 416:  importCS ::= import library qualifiedNameCS ;
			//
			case 416: {
				
				CSTNode result = createLibraryImportCS(
						(PathNameCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 417:  importCS ::= import qvtErrorToken
			//
			case 417: {
				
				CSTNode result = createLibraryImportCS(
						createPathNameCS()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 418:  importCS ::= import library qvtErrorToken
			//
			case 418: {
				
				CSTNode result = createLibraryImportCS(
						createPathNameCS()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 419:  metamodelListOpt ::= $Empty
			//
			case 419:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 421:  metamodelList ::= metamodelCS
			//
			case 421: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 422:  metamodelList ::= metamodelList metamodelCS
			//
			case 422: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 423:  metamodelList ::= metamodelList qvtErrorToken
			//
			case 423: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 425:  metamodelCS ::= metamodel stringLiteralExpCS ;
			//
			case 425: {
				
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
			// Rule 426:  metamodelCS ::= metamodel qvtErrorToken
			//
			case 426: {
				
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
			// Rule 427:  renamingListOpt ::= $Empty
			//
			case 427:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 429:  renamingList ::= renamingCS
			//
			case 429: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 430:  renamingList ::= renamingList renamingCS
			//
			case 430: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 431:  renamingList ::= renamingList qvtErrorToken
			//
			case 431: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 432:  renamingCS ::= rename typeCS . qvtIdentifierCS = stringLiteralExpCS ;
			//
			case 432: {
				
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
			// Rule 433:  propertyListOpt ::= $Empty
			//
			case 433:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 435:  propertyList ::= modulePropertyCS
			//
			case 435: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 436:  propertyList ::= propertyList modulePropertyCS
			//
			case 436: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 437:  propertyList ::= propertyList qvtErrorToken
			//
			case 437: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 438:  modulePropertyCS ::= configuration property qvtIdentifierCS : typeCS ;
			//
			case 438: {
				
				CSTNode result = createConfigPropertyCS(
						getIToken(dtParser.getToken(3)),
						(TypeCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 439:  modulePropertyCS ::= configuration property qvtIdentifierCS : typeCS qvtErrorToken
			//
			case 439: {
				
				CSTNode result = createConfigPropertyCS(
						getIToken(dtParser.getToken(3)),
						(TypeCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 440:  modulePropertyCS ::= property qvtIdentifierCS : typeCS = oclExpressionCS ;
			//
			case 440: {
				
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
			// Rule 441:  modulePropertyCS ::= property qvtIdentifierCS = oclExpressionCS ;
			//
			case 441: {
				
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
			// Rule 442:  modulePropertyCS ::= intermediate property scoped_identifier : typeCS ;
			//
			case 442: {
				
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
			// Rule 443:  modulePropertyCS ::= intermediate property scoped_identifier : typeCS = oclExpressionCS ;
			//
			case 443: {
				
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
			// Rule 444:  qualifierList ::= $Empty
			//
			case 444:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 445:  qualifierList ::= qualifierList qualifier
			//
			case 445: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 446:  qualifier ::= blackbox
			//
			case 446:
 
			//
			// Rule 447:  qualifier ::= abstract
			//
			case 447:
 
			//
			// Rule 448:  qualifier ::= static
			//
			case 448: {
				
				CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 449:  colon_param_listOpt ::= $Empty
			//
			case 449:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 450:  colon_param_listOpt ::= : param_list
			//
			case 450: {
				
				dtParser.setSym1(dtParser.getSym(2));
	  		  break;
			}
	 
			//
			// Rule 451:  complete_signature ::= simple_signature colon_param_listOpt
			//
			case 451: {
				
				SimpleSignatureCS simpleSignatureCS = (SimpleSignatureCS)dtParser.getSym(1);
				EList<ParameterDeclarationCS> resultList = (EList<ParameterDeclarationCS>)dtParser.getSym(2);
				CSTNode result = createCompleteSignatureCS(simpleSignatureCS, resultList);
				result.setStartOffset(simpleSignatureCS.getStartOffset());
				result.setEndOffset(getEndOffset(simpleSignatureCS.getEndOffset(), resultList));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 452:  simple_signature ::= ( param_listOpt )
			//
			case 452: {
				
				CSTNode result = createSimpleSignatureCS((EList<ParameterDeclarationCS>)dtParser.getSym(2));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 453:  param_listOpt ::= $Empty
			//
			case 453:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 455:  param_list ::= param_list , param
			//
			case 455: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 456:  param_list ::= param
			//
			case 456: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 457:  param ::= param_directionOpt IDENTIFIER : typespec
			//
			case 457: {
				
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
			// Rule 458:  param ::= typespec
			//
			case 458: {
				
				CSTNode result = createParameterDeclarationCS(
						null, null, (TypeSpecCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 459:  typespec ::= typeCS
			//
			case 459: {
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)dtParser.getSym(1),
					null
					);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 460:  typespec ::= typeCS @ IDENTIFIER
			//
			case 460: {
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)dtParser.getSym(1),
					getIToken(dtParser.getToken(3))
					);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 461:  param_directionOpt ::= $Empty
			//
			case 461:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 463:  param_direction ::= in
			//
			case 463: {
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.IN
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 464:  param_direction ::= out
			//
			case 464: {
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.OUT
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 465:  param_direction ::= inout
			//
			case 465: {
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.INOUT
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 469:  scoped_identifier ::= typeCS2 :: IDENTIFIER
			//
			case 469: {
				
				ScopedNameCS result = createScopedNameCS((TypeCS)dtParser.getSym(1), getTokenText(dtParser.getToken(3)));		
				setOffsets(result, (CSTNode) dtParser.getSym(1), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 470:  scoped_identifier ::= typeCS2 :: qvtErrorToken
			//
			case 470: {
				
				ScopedNameCS result = createScopedNameCS((TypeCS)dtParser.getSym(1), ""); //$NON-NLS-1$		
				setOffsets(result, (CSTNode) dtParser.getSym(1), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 471:  scoped_identifier ::= scoped_identifier2
			//
			case 471: {
				
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
			// Rule 472:  scoped_identifier2 ::= IDENTIFIER
			//
			case 472: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 473:  scoped_identifier2 ::= main
			//
			case 473: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 474:  scoped_identifier2 ::= scoped_identifier2 :: IDENTIFIER
			//
			case 474: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 475:  scoped_identifier2 ::= scoped_identifier2 :: qvtErrorToken
			//
			case 475: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, "");
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 476:  scoped_identifier_list ::= scoped_identifier
			//
			case 476: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 477:  scoped_identifier_list ::= scoped_identifier_list , scoped_identifier
			//
			case 477: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 481:  expression_semi_list ::= statementCS
			//
			case 481: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 482:  expression_semi_list ::= expression_semi_list ; statementCS
			//
			case 482: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 486:  helper_header ::= helper_info scoped_identifier complete_signature
			//
			case 486: {
				
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
				mappingDeclarationCS.setIsQuery(helperKind.getKind() == QvtOpLPGParsersym.TK_query);

				dtParser.setSym1(mappingDeclarationCS);
	  		  break;
			}
	 
			//
			// Rule 487:  helper_header ::= helper_info qvtErrorToken
			//
			case 487: {
				
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
				mappingDeclarationCS.setIsQuery(helperKind.getKind() == QvtOpLPGParsersym.TK_query);

				dtParser.setSym1(mappingDeclarationCS);
	  		  break;
			}
	 
			//
			// Rule 488:  helper_info ::= qualifierList helper_kind
			//
			case 488: {
				
				dtParser.setSym1(new Object[] {dtParser.getSym(1), getIToken(dtParser.getToken(2))});
	  		  break;
			}
	 
			//
			// Rule 491:  helper_decl ::= helper_header ;
			//
			case 491: {
				
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
			// Rule 492:  helper_decl ::= helper_header qvtErrorToken
			//
			case 492: {
				
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
			// Rule 493:  helper_simple_def ::= helper_header = statementCS ;
			//
			case 493: {
				
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
			// Rule 494:  helper_compound_def ::= helper_header expression_block semicolonOpt
			//
			case 494: {
				
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
			// Rule 497:  mapping_decl ::= mapping_full_header ;
			//
			case 497: {
				
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
			// Rule 498:  mapping_def ::= mapping_full_header { mapping_body } semicolonOpt
			//
			case 498: {
				
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
			// Rule 499:  mapping_def ::= mapping_full_header { qvtErrorToken
			//
			case 499: {
				
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
			// Rule 500:  mapping_full_header ::= mapping_header _whenOpt
			//
			case 500: {
				
				dtParser.setSym1(new Object[] {dtParser.getSym(1), dtParser.getSym(2)});
	  		  break;
			}
	 
			//
			// Rule 501:  mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier complete_signature mapping_extraList
			//
			case 501: {
				
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
			// Rule 502:  mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier qvtErrorToken
			//
			case 502: {
				
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
			// Rule 503:  mapping_header ::= qualifierList mapping qvtErrorToken
			//
			case 503: {
				
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
			// Rule 504:  mapping_extraList ::= mapping_extraList mapping_extra
			//
			case 504: {
				
				EList<MappingExtensionCS> extensionList = (EList<MappingExtensionCS>)dtParser.getSym(1);
				extensionList.add((MappingExtensionCS)dtParser.getSym(2));
				dtParser.setSym1(extensionList);
	  		  break;
			}
	 
			//
			// Rule 505:  mapping_extraList ::= $Empty
			//
			case 505:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 507:  mapping_extension ::= mapping_extension_key scoped_identifier_list
			//
			case 507: {
				
				MappingExtensionCS result = createMappingExtension(getTokenText(dtParser.getToken(1)), (EList<ScopedNameCS>)dtParser.getSym(2));

				result.setStartOffset(getIToken(dtParser.getToken(1)).getStartOffset());
				result.setEndOffset(getEndOffset(getIToken(dtParser.getToken(1)), (EList<ScopedNameCS>)dtParser.getSym(2)));
			
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 512:  _whenOpt ::= $Empty
			//
			case 512:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 513:  _when ::= when { oclExpressionCS }
			//
			case 513: {
				
				OCLExpressionCS result = (OCLExpressionCS)dtParser.getSym(3);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 514:  _when ::= when qvtErrorToken
			//
			case 514:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 515:  mapping_body ::= init_sectionOpt population_sectionOpt end_sectionOpt
			//
			case 515: {
				
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
			// Rule 516:  init_sectionOpt ::= $Empty
			//
			case 516:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 518:  init_section ::= init expression_block
			//
			case 518: {
				
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
			// Rule 519:  init_section ::= init qvtErrorToken
			//
			case 519: {
				
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
			// Rule 520:  population_sectionOpt ::= $Empty
			//
			case 520: {
				
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
			// Rule 522:  population_section ::= expression_list
			//
			case 522: {
				
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
			// Rule 523:  population_section ::= population expression_block
			//
			case 523: {
				
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
			// Rule 524:  population_section ::= population qvtErrorToken
			//
			case 524: {
				
				CSTNode result = createMappingBodyCS(
						ourEmptyEList,
						true
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 525:  end_sectionOpt ::= $Empty
			//
			case 525:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 527:  end_section ::= end expression_block
			//
			case 527: {
				
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
			// Rule 528:  end_section ::= end qvtErrorToken
			//
			case 528: {
				
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
			// Rule 529:  mappingRuleListOpt ::= $Empty
			//
			case 529:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 531:  mappingRuleList ::= mappingRuleCS
			//
			case 531: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 532:  mappingRuleList ::= mappingRuleList mappingRuleCS
			//
			case 532: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 533:  mappingRuleList ::= _helper
			//
			case 533: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 534:  mappingRuleList ::= mappingRuleList _helper
			//
			case 534: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 535:  mappingRuleList ::= mappingRuleList qvtErrorToken
			//
			case 535: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 537:  mappingRuleCS ::= entryDeclarationCS { statementListOpt }
			//
			case 537: {
				
				MappingQueryCS result = createMappingQueryCS(
						(MappingDeclarationCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 538:  entryDeclarationCS ::= main ( param_listOpt )
			//
			case 538: {
				
				IToken nameToken = getIToken(dtParser.getToken(1));				
				ScopedNameCS nameCS = createScopedNameCS(null, getTokenText(dtParser.getToken(1)));								
				nameCS.setStartOffset(nameToken.getStartOffset());
				nameCS.setEndOffset(nameToken.getEndOffset());
	
				CSTNode result = createMappingDeclarationCS(
						null,
						nameCS,
						(EList)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 539:  entryDeclarationCS ::= main qvtErrorToken
			//
			case 539: {
				
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
			// Rule 540:  typespecOpt ::= $Empty
			//
			case 540:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 542:  objectDeclCS ::= typespec
			//
			case 542: {
				
				CSTNode result = createOutExpCS(null, (TypeSpecCS)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 546:  objectDeclCS ::= objectIdentifierCS : typespecOpt
			//
			case 546: {
				
			SimpleNameCS varName = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(varName, getIToken(dtParser.getToken(1)));
			CSTNode result = createOutExpCS(varName,(TypeSpecCS)dtParser.getSym(3));					
			dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 547:  outExpCS ::= object objectDeclCS expression_block
			//
			case 547: {
				
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
			// Rule 548:  outExpCS ::= object objectDeclCS qvtErrorToken
			//
			case 548: {
				
				OutExpCS objectDeclCS = ((OutExpCS)dtParser.getSym(2));  
				CSTNode result = createErrorOutExpCS(
						objectDeclCS.getSimpleNameCS(),						
						objectDeclCS.getTypeSpecCS(),
						ourEmptyEList,
						getIToken(dtParser.getToken(1)).getEndOffset(),
						getIToken(dtParser.getToken(1)).getStartOffset(),
						getIToken(dtParser.getToken(1)).getStartOffset(),
						getIToken(dtParser.getToken(3)).getStartOffset()
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
			// Rule 549:  featureMappingCallExpCS ::= map simpleNameCS ( argumentsCSopt )
			//
			case 549: {
				
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
			// Rule 550:  featureMappingCallExpCS ::= xmap simpleNameCS ( argumentsCSopt )
			//
			case 550: {
				
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
			// Rule 551:  mappingCallExpCS ::= map pathNameCS ( argumentsCSopt )
			//
			case 551: {
				
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
			// Rule 552:  mappingCallExpCS ::= xmap pathNameCS ( argumentsCSopt )
			//
			case 552: {
				
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
			// Rule 553:  resolveConditionOpt ::= $Empty
			//
			case 553:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 554:  resolveConditionOpt ::= | oclExpressionCS
			//
			case 554: {
				
                dtParser.setSym1((OCLExpressionCS)dtParser.getSym(2));
      		  break;
			}
     
			//
			// Rule 555:  resolveConditionOpt ::= | qvtErrorToken
			//
			case 555:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 556:  IDENTIFIEROpt ::= $Empty
			//
			case 556:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 557:  IDENTIFIEROpt ::= IDENTIFIER :
			//
			case 557: {
				
                dtParser.setSym1(getIToken(dtParser.getToken(1)));
      		  break;
			}
     
			//
			// Rule 558:  resolveOpArgsExpCSOpt ::= $Empty
			//
			case 558:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 560:  resolveOpArgsExpCS ::= IDENTIFIEROpt typeCS resolveConditionOpt
			//
			case 560: {
				
                CSTNode result = createResolveOpArgsExpCS(
                        getIToken(dtParser.getToken(1)),      // target_type_variable?
                        (TypeCS)dtParser.getSym(2),           // type?
                        (OCLExpressionCS)dtParser.getSym(3)); // condition?
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 565:  lateOpt ::= $Empty
			//
			case 565:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 567:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCSOpt )
			//
			case 567: {
				
                CSTNode result = createResolveExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        (ResolveOpArgsExpCS)dtParser.getSym(4));
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 568:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCSOpt qvtErrorToken
			//
			case 568: {
				
                CSTNode result = createResolveExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        (ResolveOpArgsExpCS)dtParser.getSym(4));
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 569:  resolveExpCS ::= lateOpt resolveOp qvtErrorToken
			//
			case 569: {
				
                CSTNode result = createResolveExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        null);
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 570:  resolveExpCS ::= late qvtErrorToken
			//
			case 570: {
				
    			IToken lateToken = getIToken(dtParser.getToken(1));
                CSTNode result = createResolveExpCS(
                        lateToken,
                        new Token(lateToken.getEndOffset(), lateToken.getEndOffset(), QvtOpLPGParsersym.TK_resolve),
                        null);
                        setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 575:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier , resolveOpArgsExpCS )
			//
			case 575: {
				
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
			// Rule 576:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier )
			//
			case 576: {
				
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
			// Rule 577:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier , resolveOpArgsExpCSOpt qvtErrorToken
			//
			case 577: {
				
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
			// Rule 578:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier qvtErrorToken
			//
			case 578: {
				
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
			// Rule 579:  resolveInExpCS ::= lateOpt resolveInOp ( qvtErrorToken
			//
			case 579: {
				
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
			// Rule 580:  resolveInExpCS ::= lateOpt resolveInOp qvtErrorToken
			//
			case 580: {
				
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
			// Rule 583:  callExpCS ::= . resolveResolveInExpCS
			//
			case 583: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 588:  simpleNameCS ::= this
			//
			case 588:
 
			//
			// Rule 589:  simpleNameCS ::= result
			//
			case 589: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 590:  modelTypeExpCS ::= modeltype IDENTIFIER complianceKindCSOpt uses packageRefList modelTypeWhereCSOpt ;
			//
			case 590: {
				
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
			// Rule 591:  modelTypeExpCS ::= modeltype qvtErrorToken
			//
			case 591: {
				
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
			// Rule 592:  packageRefList ::= packageRefCS
			//
			case 592: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 593:  packageRefList ::= packageRefList , packageRefCS
			//
			case 593: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 594:  packageRefCS ::= pathNameCS
			//
			case 594: {
				
				CSTNode result = createPackageRefCS(
						(PathNameCS)dtParser.getSym(1),
						null
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 595:  packageRefCS ::= pathNameCS ( qvtStringLiteralExpCS )
			//
			case 595: {
				
				CSTNode result = createPackageRefCS(
						(PathNameCS)dtParser.getSym(1),
						(StringLiteralExpCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 596:  packageRefCS ::= qvtStringLiteralExpCS
			//
			case 596: {
				
				CSTNode result = createPackageRefCS(
						null,
						(StringLiteralExpCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 597:  modelTypeWhereCSOpt ::= $Empty
			//
			case 597:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 598:  modelTypeWhereCSOpt ::= where { statementListOpt }
			//
			case 598: {
				
				EList result = (EList)dtParser.getSym(3);
				dtParser.setSym1(result);
	  		  break;
			}
	
	
			default:
				break;
		}
		return;
	}
}

