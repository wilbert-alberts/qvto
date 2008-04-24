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
* $Id: LightweightTypeParser.java,v 1.3 2008/04/24 12:15:38 sboyko Exp $
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
* $Id: LightweightTypeParser.java,v 1.3 2008/04/24 12:15:38 sboyko Exp $
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

import lpg.lpgjavaruntime.Monitor;
import lpg.lpgjavaruntime.BadParseException;
import lpg.lpgjavaruntime.BadParseSymFileException;
import lpg.lpgjavaruntime.DiagnoseParser;
import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.NullExportedSymbolsException;
import lpg.lpgjavaruntime.NullTerminalSymbolsException;
import lpg.lpgjavaruntime.ParseTable;
import lpg.lpgjavaruntime.PrsStream;
import lpg.lpgjavaruntime.RuleAction;
import lpg.lpgjavaruntime.UndefinedEofSymbolException;
import lpg.lpgjavaruntime.UnimplementedTerminalsException;

import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.ParserException;		
import java.util.Map;
import lpg.lpgjavaruntime.Token;
import lpg.lpgjavaruntime.BacktrackingParser;
import lpg.lpgjavaruntime.NotBacktrackParseTableException;
import org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.LogExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingEndCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingInitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.OutExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ReturnExpCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.temp.ResolveOpArgsExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.temp.ScopedNameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.temp.TempFactory;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS;

import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLPGParserprs;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLPGParsersym;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLexer;	
import org.eclipse.m2m.internal.qvt.oml.cst.parser.AbstractQVTParser;	

	public class LightweightTypeParser extends AbstractQVTParser implements RuleAction {
	protected static ParseTable prs = new LightweightTypeParserprs();
	private BacktrackingParser dtParser;
	private static Map<Integer, String> ruleTexts;

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
            makeToken(lastT.getEndOffset() + i + someHugeOffset, lastT.getEndOffset() + i + someHugeOffset + 1, QvtOpLPGParserprs.TK_EOF_TOKEN);
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
			// Rule 24:  parametersCSopt ::= $Empty
			//
			case 24:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 25:  simpleNameCSopt ::= $Empty
			//
			case 25:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 31:  impliesExpCS ::= impliesExpCS implies andOrXorExpCS
			//
			case 31:
 
			//
			// Rule 32:  impliesWithLet ::= impliesExpCS implies andOrXorWithLet
			//
			case 32:
 
			//
			// Rule 35:  andOrXorExpCS ::= andOrXorExpCS and equalityExpCS
			//
			case 35:
 
			//
			// Rule 36:  andOrXorExpCS ::= andOrXorExpCS or equalityExpCS
			//
			case 36:
 
			//
			// Rule 37:  andOrXorExpCS ::= andOrXorExpCS xor equalityExpCS
			//
			case 37:
 
			//
			// Rule 38:  andOrXorWithLet ::= andOrXorExpCS and equalityWithLet
			//
			case 38:
 
			//
			// Rule 39:  andOrXorWithLet ::= andOrXorExpCS or equalityWithLet
			//
			case 39:
 
			//
			// Rule 40:  andOrXorWithLet ::= andOrXorExpCS xor equalityWithLet
			//
			case 40: {
				
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
			// Rule 43:  equalityExpCS ::= equalityExpCS = relationalExpCS
			//
			case 43:
 
			//
			// Rule 44:  equalityWithLet ::= equalityExpCS = relationalWithLet
			//
			case 44: {
				
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
			// Rule 45:  equalityExpCS ::= equalityExpCS <> relationalExpCS
			//
			case 45:
 
			//
			// Rule 46:  equalityWithLet ::= equalityExpCS <> relationalWithLet
			//
			case 46: {
				
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
			// Rule 49:  relationalExpCS ::= relationalExpCS > ifExpCSPrec
			//
			case 49:
 
			//
			// Rule 50:  relationalWithLet ::= relationalExpCS > additiveWithLet
			//
			case 50: {
				
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
			// Rule 51:  relationalExpCS ::= relationalExpCS < ifExpCSPrec
			//
			case 51:
 
			//
			// Rule 52:  relationalWithLet ::= relationalExpCS < additiveWithLet
			//
			case 52: {
				
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
			// Rule 53:  relationalExpCS ::= relationalExpCS >= ifExpCSPrec
			//
			case 53:
 
			//
			// Rule 54:  relationalWithLet ::= relationalExpCS >= additiveWithLet
			//
			case 54: {
				
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
			// Rule 55:  relationalExpCS ::= relationalExpCS <= ifExpCSPrec
			//
			case 55:
 
			//
			// Rule 56:  relationalWithLet ::= relationalExpCS <= additiveWithLet
			//
			case 56: {
				
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
			// Rule 60:  additiveExpCS ::= additiveExpCS + multiplicativeExpCS
			//
			case 60:
 
			//
			// Rule 61:  additiveWithLet ::= additiveExpCS + multiplicativeWithLet
			//
			case 61: {
				
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
			// Rule 62:  additiveExpCS ::= additiveExpCS - multiplicativeExpCS
			//
			case 62:
 
			//
			// Rule 63:  additiveWithLet ::= additiveExpCS - multiplicativeWithLet
			//
			case 63: {
				
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
			// Rule 66:  multiplicativeExpCS ::= multiplicativeExpCS * unaryExpCS
			//
			case 66:
 
			//
			// Rule 67:  multiplicativeWithLet ::= multiplicativeExpCS * unaryWithLet
			//
			case 67: {
				
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
			// Rule 68:  multiplicativeExpCS ::= multiplicativeExpCS / unaryExpCS
			//
			case 68:
 
			//
			// Rule 69:  multiplicativeWithLet ::= multiplicativeExpCS / unaryWithLet
			//
			case 69: {
				
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
			// Rule 72:  unaryExpCS ::= - unaryExpCS
			//
			case 72: {
				
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
			// Rule 73:  unaryExpCS ::= not unaryExpCS
			//
			case 73: {
				
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
			// Rule 75:  dotArrowExpCS ::= dotArrowExpCS callExpCS
			//
			case 75: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setSource((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, (CSTNode)dtParser.getSym(1), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 76:  dotArrowExpCS ::= dotArrowExpCS messageExpCS
			//
			case 76: {
				
				MessageExpCS result = (MessageExpCS)dtParser.getSym(2);
				result.setTarget((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 77:  dotArrowExpCS ::= NUMERIC_OPERATION ( argumentsCSopt )
			//
			case 77: {
				
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
			// Rule 78:  dotArrowExpCS ::= pathNameCS :: simpleNameCS ( argumentsCSopt )
			//
			case 78: {
				
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
			// Rule 83:  oclExpCS ::= ( oclExpressionCS )
			//
			case 83: {
				
				CSTNode result = (CSTNode)dtParser.getSym(2);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 84:  variableExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 84: {
				
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
			// Rule 85:  variableExpCS ::= keywordAsIdentifier1 isMarkedPreCS
			//
			case 85: {
				
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
			// Rule 87:  simpleNameCS ::= self
			//
			case 87: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.SELF_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 88:  simpleNameCS ::= IDENTIFIER
			//
			case 88: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 89:  primitiveTypeCS ::= Integer
			//
			case 89: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INTEGER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 90:  primitiveTypeCS ::= UnlimitedNatural
			//
			case 90: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 91:  primitiveTypeCS ::= String
			//
			case 91: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.STRING_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 92:  primitiveTypeCS ::= Real
			//
			case 92: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.REAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 93:  primitiveTypeCS ::= Boolean
			//
			case 93: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.BOOLEAN_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 94:  primitiveTypeCS ::= OclAny
			//
			case 94: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_ANY_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 95:  primitiveTypeCS ::= OclVoid
			//
			case 95: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_VOID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 96:  primitiveTypeCS ::= Invalid
			//
			case 96: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INVALID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 97:  primitiveTypeCS ::= OclMessage
			//
			case 97: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_MESSAGE_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 98:  pathNameCS ::= IDENTIFIER
			//
			case 98: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 99:  pathNameCS ::= pathNameCS :: simpleNameCS
			//
			case 99: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 100:  pathNameCSOpt ::= $Empty
			//
			case 100: {
				
				CSTNode result = createPathNameCS();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 108:  enumLiteralExpCS ::= pathNameCS :: keywordAsIdentifier
			//
			case 108: {
				
				CSTNode result = createEnumLiteralExpCS(
						(PathNameCS)dtParser.getSym(1),
						getTokenText(dtParser.getToken(3))
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 109:  enumLiteralExpCS ::= pathNameCS :: simpleNameCS
			//
			case 109: {
				
				CSTNode result = createEnumLiteralExpCS(
						(PathNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 110:  collectionLiteralExpCS ::= collectionTypeIdentifierCS { collectionLiteralPartsCSopt }
			//
			case 110: {
				
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
			// Rule 111:  collectionTypeIdentifierCS ::= Set
			//
			case 111: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.SET_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 112:  collectionTypeIdentifierCS ::= Bag
			//
			case 112: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.BAG_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 113:  collectionTypeIdentifierCS ::= Sequence
			//
			case 113: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.SEQUENCE_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 114:  collectionTypeIdentifierCS ::= Collection
			//
			case 114: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.COLLECTION_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 115:  collectionTypeIdentifierCS ::= OrderedSet
			//
			case 115: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 116:  collectionLiteralPartsCSopt ::= $Empty
			//
			case 116:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 118:  collectionLiteralPartsCS ::= collectionLiteralPartCS
			//
			case 118: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 119:  collectionLiteralPartsCS ::= collectionLiteralPartsCS , collectionLiteralPartCS
			//
			case 119: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 121:  collectionLiteralPartCS ::= oclExpressionCS
			//
			case 121: {
				
				CSTNode result = createCollectionLiteralPartCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 122:  collectionRangeCS ::= - INTEGER_RANGE_START oclExpressionCS
			//
			case 122: {
				
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
			// Rule 123:  collectionRangeCS ::= INTEGER_RANGE_START oclExpressionCS
			//
			case 123: {
				
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
			// Rule 124:  collectionRangeCS ::= oclExpressionCS .. oclExpressionCS
			//
			case 124: {
				
				CSTNode result = createCollectionRangeCS(
						(OCLExpressionCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 130:  tupleLiteralExpCS ::= Tuple { variableListCS2 }
			//
			case 130: {
				
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 131:  integerLiteralExpCS ::= INTEGER_LITERAL
			//
			case 131: {
				
				CSTNode result = createIntegerLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 132:  unlimitedNaturalLiteralExpCS ::= *
			//
			case 132: {
				
				CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 133:  realLiteralExpCS ::= REAL_LITERAL
			//
			case 133: {
				
				CSTNode result = createRealLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 134:  stringLiteralExpCS ::= STRING_LITERAL
			//
			case 134: {
				
				CSTNode result = createStringLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 135:  booleanLiteralExpCS ::= true
			//
			case 135: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 136:  booleanLiteralExpCS ::= false
			//
			case 136: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 137:  nullLiteralExpCS ::= null
			//
			case 137: {
				
				CSTNode result = createNullLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 138:  invalidLiteralExpCS ::= OclInvalid
			//
			case 138: {
				
				CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 139:  callExpCS ::= -> featureCallExpCS
			//
			case 139:
 
			//
			// Rule 140:  callExpCS ::= -> loopExpCS
			//
			case 140: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 141:  callExpCS ::= . keywordOperationCallExpCS
			//
			case 141:
 
			//
			// Rule 142:  callExpCS ::= . featureCallExpCS
			//
			case 142: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 145:  iterContents ::= oclExpressionCS
			//
			case 145: {
				
				dtParser.setSym1(new Object[] {
						null,
						null,
						dtParser.getSym(1)
					});
	  		  break;
			}
	 
			//
			// Rule 146:  iterContents ::= variableCS | oclExpressionCS
			//
			case 146: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						null,
						dtParser.getSym(3)
					});
	  		  break;
			}
	 
			//
			// Rule 147:  iterContents ::= variableCS , variableCS | oclExpressionCS
			//
			case 147: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						dtParser.getSym(3),
						dtParser.getSym(5)
					});
	  		  break;
			}
	 
			//
			// Rule 148:  iterateExpCS ::= iterate ( variableCS | oclExpressionCS )
			//
			case 148: {
				
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
			// Rule 149:  iterateExpCS ::= iterate ( variableCS ; variableCS | oclExpressionCS )
			//
			case 149: {
				
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
			// Rule 150:  variableCS ::= IDENTIFIER
			//
			case 150: {
				
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
			// Rule 151:  variableCS ::= IDENTIFIER : typeCS
			//
			case 151: {
				
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
			// Rule 152:  variableCS ::= IDENTIFIER : typeCS = oclExpressionCS
			//
			case 152: {
				
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
			// Rule 153:  variableCS2 ::= IDENTIFIER = oclExpressionCS
			//
			case 153: {
				
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
			// Rule 154:  typeCSopt ::= $Empty
			//
			case 154:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 160:  collectionTypeCS ::= collectionTypeIdentifierCS ( typeCS )
			//
			case 160: {
				
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
			// Rule 161:  tupleTypeCS ::= Tuple ( variableListCSopt )
			//
			case 161: {
				
				CSTNode result = createTupleTypeCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 162:  variableListCSopt ::= $Empty
			//
			case 162:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 164:  variableListCS ::= variableCS
			//
			case 164: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 165:  variableListCS ::= variableListCS , variableCS
			//
			case 165: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 166:  variableListCS2 ::= variableCS2
			//
			case 166:
 
			//
			// Rule 167:  variableListCS2 ::= variableCS
			//
			case 167: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 168:  variableListCS2 ::= variableListCS2 , variableCS2
			//
			case 168:
 
			//
			// Rule 169:  variableListCS2 ::= variableListCS2 , variableCS
			//
			case 169: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 172:  featureCallExpCS ::= MINUS isMarkedPreCS ( argumentsCSopt )
			//
			case 172:
 
			//
			// Rule 173:  featureCallExpCS ::= not isMarkedPreCS ( argumentsCSopt )
			//
			case 173: {
				
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
			// Rule 174:  operationCallExpCS ::= simpleNameCS isMarkedPreCS ( argumentsCSopt )
			//
			case 174: {
				
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
			// Rule 175:  operationCallExpCS ::= oclIsUndefined isMarkedPreCS ( argumentsCSopt )
			//
			case 175:
 
			//
			// Rule 176:  operationCallExpCS ::= oclIsInvalid isMarkedPreCS ( argumentsCSopt )
			//
			case 176:
 
			//
			// Rule 177:  operationCallExpCS ::= oclIsNew isMarkedPreCS ( argumentsCSopt )
			//
			case 177:
 
			//
			// Rule 178:  operationCallExpCS ::= EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 178:
 
			//
			// Rule 179:  operationCallExpCS ::= NOT_EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 179:
 
			//
			// Rule 180:  operationCallExpCS ::= PLUS isMarkedPreCS ( argumentsCSopt )
			//
			case 180:
 
			//
			// Rule 181:  operationCallExpCS ::= MULTIPLY isMarkedPreCS ( argumentsCSopt )
			//
			case 181:
 
			//
			// Rule 182:  operationCallExpCS ::= DIVIDE isMarkedPreCS ( argumentsCSopt )
			//
			case 182:
 
			//
			// Rule 183:  operationCallExpCS ::= GREATER isMarkedPreCS ( argumentsCSopt )
			//
			case 183:
 
			//
			// Rule 184:  operationCallExpCS ::= LESS isMarkedPreCS ( argumentsCSopt )
			//
			case 184:
 
			//
			// Rule 185:  operationCallExpCS ::= GREATER_EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 185:
 
			//
			// Rule 186:  operationCallExpCS ::= LESS_EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 186:
 
			//
			// Rule 187:  operationCallExpCS ::= and isMarkedPreCS ( argumentsCSopt )
			//
			case 187:
 
			//
			// Rule 188:  operationCallExpCS ::= or isMarkedPreCS ( argumentsCSopt )
			//
			case 188:
 
			//
			// Rule 189:  operationCallExpCS ::= xor isMarkedPreCS ( argumentsCSopt )
			//
			case 189:
 
			//
			// Rule 190:  keywordOperationCallExpCS ::= keywordAsIdentifier isMarkedPreCS ( argumentsCSopt )
			//
			case 190: {
				
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
			// Rule 191:  operationCallExpCS ::= oclIsInState isMarkedPreCS ( pathNameCSOpt )
			//
			case 191: {
				
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
			// Rule 192:  attrOrNavCallExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 192: {
				
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
			// Rule 193:  attrOrNavCallExpCS ::= keywordAsIdentifier isMarkedPreCS
			//
			case 193: {
				
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
			// Rule 194:  isMarkedPreCS ::= $Empty
			//
			case 194: {
				
				CSTNode result = createIsMarkedPreCS(false);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 195:  isMarkedPreCS ::= @pre
			//
			case 195: {
				
				CSTNode result = createIsMarkedPreCS(true);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 196:  argumentsCSopt ::= $Empty
			//
			case 196:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 198:  argumentsCS ::= oclExpressionCS
			//
			case 198: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 199:  argumentsCS ::= argumentsCS , oclExpressionCS
			//
			case 199: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 200:  letExpCS ::= let variableCS letExpSubCSopt in oclExpressionCS
			//
			case 200: {
				
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
			// Rule 201:  letExpSubCSopt ::= $Empty
			//
			case 201:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 203:  letExpSubCS ::= , variableCS
			//
			case 203: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 204:  letExpSubCS ::= letExpSubCS , variableCS
			//
			case 204: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 205:  messageExpCS ::= ^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 205:
 
			//
			// Rule 206:  messageExpCS ::= ^^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 206: {
				
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
			// Rule 207:  oclMessageArgumentsCSopt ::= $Empty
			//
			case 207:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 209:  oclMessageArgumentsCS ::= oclMessageArgCS
			//
			case 209: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 210:  oclMessageArgumentsCS ::= oclMessageArgumentsCS , oclMessageArgCS
			//
			case 210: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 211:  oclMessageArgCS ::= oclExpressionCS
			//
			case 211: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 212:  oclMessageArgCS ::= ?
			//
			case 212: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 213:  oclMessageArgCS ::= ? : typeCS
			//
			case 213: {
				
				CSTNode result = createOCLMessageArgCS(
						(TypeCS)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 216:  mappingModuleCS ::= moduleImportListOpt metamodelListOpt transformationCS moduleImportListOpt metamodelListOpt renamingListOpt propertyListOpt mappingRuleListOpt
			//
			case 216: {
				
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
			// Rule 217:  mappingModuleCS ::= moduleImportListOpt metamodelListOpt transformationCS qvtErrorToken
			//
			case 217: {
				
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
			// Rule 218:  mappingModuleCS ::= moduleImportListOpt metamodelListOpt qualifierListOpt transformation qvtErrorToken
			//
			case 218: {
				
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
			// Rule 219:  transformationCS ::= transformationHeaderCS ;
			//
			case 219: {
				
				TransformationHeaderCS result = (TransformationHeaderCS) dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 220:  transformationHeaderCS ::= qualifierListOpt transformation qualifiedNameCS
			//
			case 220: {
				
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
			// Rule 221:  transformationHeaderCS ::= qualifierListOpt transformation qualifiedNameCS ( transfParamListOpt ) moduleUsageListOpt transformationRefineCSOpt
			//
			case 221: {
				
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
			// Rule 222:  transformationRefineCSOpt ::= $Empty
			//
			case 222:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 223:  transformationRefineCSOpt ::= refines moduleRefCS enforcing IDENTIFIER
			//
			case 223: {
				
				CSTNode result = createTransformationRefineCS(
						(ModuleRefCS)dtParser.getSym(2),
						getIToken(dtParser.getToken(4))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 224:  moduleUsageListOpt ::= $Empty
			//
			case 224:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 226:  moduleUsageList ::= moduleUsageCS
			//
			case 226: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 227:  moduleUsageList ::= moduleUsageList moduleUsageCS
			//
			case 227: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 228:  moduleUsageCS ::= access moduleKindOpt moduleRefList
			//
			case 228: {
				
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
			// Rule 229:  moduleUsageCS ::= extends moduleKindOpt moduleRefList
			//
			case 229: {
				
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
			// Rule 230:  moduleKindOpt ::= $Empty
			//
			case 230:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 232:  moduleKindCS ::= transformation
			//
			case 232: {
				
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.TRANSFORMATION
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 233:  moduleKindCS ::= library
			//
			case 233: {
				
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.LIBRARY
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 234:  moduleRefList ::= moduleRefCS
			//
			case 234: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 235:  moduleRefList ::= moduleRefList , moduleRefCS
			//
			case 235: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 236:  moduleRefList ::= moduleRefList qvtErrorToken
			//
			case 236: {
				
				EList result = (EList) dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 237:  moduleRefCS ::= pathNameCS
			//
			case 237: {
				
				CSTNode result = createModuleRefCS(
						(PathNameCS)dtParser.getSym(1),
						ourEmptyEList
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 238:  moduleRefCS ::= pathNameCS ( transfParamListOpt )
			//
			case 238: {
				
				CSTNode result = createModuleRefCS(
						(PathNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 239:  qualifierListOpt ::= $Empty
			//
			case 239:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 241:  qualifierList ::= qualifierCS
			//
			case 241: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 242:  qualifierList ::= qualifierList qualifierCS
			//
			case 242: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 243:  qualifierCS ::= blackbox
			//
			case 243:
 
			//
			// Rule 244:  qualifierCS ::= abstract
			//
			case 244:
 
			//
			// Rule 245:  qualifierCS ::= static
			//
			case 245: {
				
				CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 246:  transfParamListOpt ::= $Empty
			//
			case 246:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 248:  transfParamList ::= transfParamCS
			//
			case 248: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 249:  transfParamList ::= transfParamList , transfParamCS
			//
			case 249: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 250:  transfParamList ::= transfParamList qvtErrorToken
			//
			case 250: {
				
				EList result = (EList) dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 251:  transfParamCS ::= directionKindOpt pathNameCS
			//
			case 251: {
				
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
			// Rule 252:  transfParamCS ::= directionKindOpt IDENTIFIER : pathNameCS
			//
			case 252: {
				
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
			// Rule 253:  libraryCS ::= moduleImportListOpt metamodelListOpt library qualifiedNameCS ; moduleImportListOpt metamodelListOpt renamingListOpt propertyListOpt mappingRuleListOpt
			//
			case 253: {
				
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
			// Rule 254:  libraryCS ::= moduleImportListOpt metamodelListOpt library qualifiedNameCS ; qvtErrorToken
			//
			case 254: {
				
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
			// Rule 255:  libraryCS ::= moduleImportListOpt metamodelListOpt library qualifiedNameCS qvtErrorToken
			//
			case 255: {
				
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
			// Rule 256:  libraryCS ::= moduleImportListOpt metamodelListOpt library qvtErrorToken
			//
			case 256: {
				
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
			// Rule 257:  qualifiedNameCS ::= qvtIdentifierCS
			//
			case 257: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 258:  qualifiedNameCS ::= qualifiedNameCS . qvtIdentifierCS
			//
			case 258: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 259:  qualifiedNameCS ::= qualifiedNameCS . qvtErrorToken
			//
			case 259: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, "");
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 260:  qualifiedNameCS ::= qualifiedNameCS qvtErrorToken
			//
			case 260: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}	
	 
			//
			// Rule 264:  scopedNameCS ::= typeCS2 :: IDENTIFIER
			//
			case 264: {
				
				ScopedNameCS result = createScopedNameCS((TypeCS)dtParser.getSym(1), 
															getTokenText(dtParser.getToken(3)));		
				setOffsets(result, (CSTNode) dtParser.getSym(1), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 265:  scopedNameCS ::= typeCS2 :: qvtErrorToken
			//
			case 265: {
				
				ScopedNameCS result = createScopedNameCS((TypeCS)dtParser.getSym(1), 
															""); //$NON-NLS-1$		
				setOffsets(result, (CSTNode) dtParser.getSym(1), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 266:  scopedNameCS ::= scopedNameCS2
			//
			case 266: {
				
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
			// Rule 267:  scopedNameCS2 ::= IDENTIFIER
			//
			case 267: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 268:  scopedNameCS2 ::= main
			//
			case 268: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 269:  scopedNameCS2 ::= scopedNameCS2 :: IDENTIFIER
			//
			case 269: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 270:  scopedNameCS2 ::= scopedNameCS2 :: qvtErrorToken
			//
			case 270: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, "");
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 271:  moduleImportListOpt ::= $Empty
			//
			case 271:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 273:  moduleImportList ::= importCS
			//
			case 273: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 274:  moduleImportList ::= moduleImportList importCS
			//
			case 274: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 275:  moduleImportList ::= moduleImportList qvtErrorToken
			//
			case 275: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 276:  importCS ::= import qualifiedNameCS ;
			//
			case 276: {
				
				CSTNode result = createModuleImportCS(
						(PathNameCS)dtParser.getSym(2)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 277:  importCS ::= import library qualifiedNameCS ;
			//
			case 277: {
				
				CSTNode result = createLibraryImportCS(
						(PathNameCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 278:  importCS ::= import qvtErrorToken
			//
			case 278: {
				
				CSTNode result = createLibraryImportCS(
						createPathNameCS()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 279:  importCS ::= import library qvtErrorToken
			//
			case 279: {
				
				CSTNode result = createLibraryImportCS(
						createPathNameCS()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 280:  metamodelListOpt ::= $Empty
			//
			case 280:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 282:  metamodelList ::= metamodelCS
			//
			case 282: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 283:  metamodelList ::= metamodelList metamodelCS
			//
			case 283: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 284:  metamodelList ::= metamodelList qvtErrorToken
			//
			case 284: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 286:  metamodelCS ::= metamodel stringLiteralExpCS ;
			//
			case 286: {
				
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
			// Rule 287:  metamodelCS ::= metamodel qvtErrorToken
			//
			case 287: {
				
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
			// Rule 288:  renamingListOpt ::= $Empty
			//
			case 288:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 290:  renamingList ::= renamingCS
			//
			case 290: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 291:  renamingList ::= renamingList renamingCS
			//
			case 291: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 292:  renamingList ::= renamingList qvtErrorToken
			//
			case 292: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 293:  renamingCS ::= rename typeCS . qvtIdentifierCS = stringLiteralExpCS ;
			//
			case 293: {
				
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
			// Rule 294:  propertyListOpt ::= $Empty
			//
			case 294:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 296:  propertyList ::= modulePropertyCS
			//
			case 296: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 297:  propertyList ::= propertyList modulePropertyCS
			//
			case 297: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 298:  propertyList ::= propertyList qvtErrorToken
			//
			case 298: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 299:  modulePropertyCS ::= configuration property qvtIdentifierCS : typeCS ;
			//
			case 299: {
				
				CSTNode result = createConfigPropertyCS(
						getIToken(dtParser.getToken(3)),
						(TypeCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 300:  modulePropertyCS ::= configuration property qvtIdentifierCS : typeCS qvtErrorToken
			//
			case 300: {
				
				CSTNode result = createConfigPropertyCS(
						getIToken(dtParser.getToken(3)),
						(TypeCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 301:  modulePropertyCS ::= property qvtIdentifierCS : typeCS = oclExpressionCS ;
			//
			case 301: {
				
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
			// Rule 302:  modulePropertyCS ::= property qvtIdentifierCS = oclExpressionCS ;
			//
			case 302: {
				
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
			// Rule 303:  modulePropertyCS ::= intermediate property scopedNameCS : typeCS ;
			//
			case 303: {
				
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
			// Rule 304:  modulePropertyCS ::= intermediate property scopedNameCS : typeCS = oclExpressionCS ;
			//
			case 304: {
				
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
			// Rule 305:  mappingRuleListOpt ::= $Empty
			//
			case 305:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 307:  mappingRuleList ::= mappingRuleCS
			//
			case 307: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 308:  mappingRuleList ::= mappingRuleList mappingRuleCS
			//
			case 308: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 309:  mappingRuleList ::= mappingQueryCS
			//
			case 309: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 310:  mappingRuleList ::= mappingRuleList mappingQueryCS
			//
			case 310: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 311:  mappingRuleList ::= mappingRuleList qvtErrorToken
			//
			case 311: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 312:  mappingRuleCS ::= entryDeclarationCS { statementListOpt }
			//
			case 312: {
				
				MappingQueryCS result = createMappingQueryCS(
						(MappingDeclarationCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 313:  mappingRuleCS ::= qualifierListOpt mapping mappingDeclarationCS mappingExtraListCSOpt mappingGuardOpt { mappingInitOpt mappingBodyOpt mappingEndOpt }
			//
			case 313: {
				
				MappingInitCS mappingInit = (MappingInitCS)dtParser.getSym(7);
				MappingBodyCS mappingBody = (MappingBodyCS)dtParser.getSym(8);
				MappingEndCS mappingEnd = (MappingEndCS)dtParser.getSym(9);
				int bodyLeft = (mappingInit == null ?  getIToken(dtParser.getToken(6)).getEndOffset() : mappingInit.getEndOffset());
				int bodyRight = (mappingEnd == null ?  getIToken(dtParser.getToken(10)).getEndOffset() : mappingEnd.getStartOffset());
				int outBodyRight = (mappingEnd == null ?  getIToken(dtParser.getToken(10)).getStartOffset() : mappingEnd.getStartOffset());
				if (mappingBody != null) {
					bodyLeft = mappingBody.getStartOffset();
					bodyRight = mappingBody.getEndOffset();
				}

				updateMappingBodyPositions(mappingBody, bodyLeft, bodyRight, bodyLeft, outBodyRight);
				MappingRuleCS result = createMappingRuleCS(
						(MappingDeclarationCS)dtParser.getSym(3),
						(OCLExpressionCS)dtParser.getSym(5),
						mappingInit,
						mappingBody,
						mappingEnd
					);
					
				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)dtParser.getSym(1);
				if(!qualifiers.isEmpty()) {
					result.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}
					
				result.getMappingExtension().addAll(((EList<MappingExtensionCS>)dtParser.getSym(4)));
				setOffsets(result, getIToken(dtParser.getToken(2)), getIToken(dtParser.getToken(9)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 314:  mappingExtraListCSOpt ::= $Empty
			//
			case 314:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 317:  mappingExtensionCS ::= mappingExtensionKeyCS scopedNameListCS mappingExtensionCS2
			//
			case 317: {
				
			MappingExtensionCS result = createMappingExtension(getTokenText(dtParser.getToken(1)), (EList<ScopedNameCS>)dtParser.getSym(2));
			EList<MappingExtensionCS> extensionList = (EList<MappingExtensionCS>)dtParser.getSym(3);  
			extensionList.add(0, result);
			
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
			dtParser.setSym1(extensionList);
	  		  break;
			}
	 
			//
			// Rule 318:  mappingExtensionCS2 ::= mappingExtensionKeyCS scopedNameListCS mappingExtensionCS
			//
			case 318: {
				
			MappingExtensionCS result = createMappingExtension(getTokenText(dtParser.getToken(1)), (EList<ScopedNameCS>)dtParser.getSym(2));
			EList<MappingExtensionCS> extensionList = (EList<MappingExtensionCS>)dtParser.getSym(3);  
			extensionList.add(0, result);
			
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
			dtParser.setSym1(extensionList);
	  		  break;
			}
	 
			//
			// Rule 319:  mappingExtensionCS2 ::= mappingExtensionKeyCS scopedNameListCS
			//
			case 319: {
				
			MappingExtensionCS result = createMappingExtension(getTokenText(dtParser.getToken(1)), (EList<ScopedNameCS>)dtParser.getSym(2));
			EList<MappingExtensionCS> extensionList = new BasicEList<MappingExtensionCS>();  
			extensionList.add(result);
			
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
			dtParser.setSym1(extensionList);
	  		  break;
			}
	 
			//
			// Rule 320:  mappingExtensionCS2 ::= $Empty
			//
			case 320:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 324:  scopedNameListCS ::= scopedNameCS
			//
			case 324: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 325:  scopedNameListCS ::= scopedNameListCS , scopedNameCS
			//
			case 325: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 326:  mappingRuleCS ::= qualifierListOpt mapping mappingDeclarationCS ;
			//
			case 326: {
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)dtParser.getSym(3);
				CSTNode result = createMappingRuleCS(
						mappingDecl,
						null,
						null,
						null,
						null
					);
				mappingDecl.setBlackBox(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 327:  mappingRuleCS ::= qualifierListOpt mapping mappingDeclarationCS qvtErrorToken
			//
			case 327: {
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)dtParser.getSym(3);
				CSTNode result = createMappingRuleCS(
						mappingDecl,
						null,
						null,
						null,
						null
					);
				mappingDecl.setBlackBox(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), mappingDecl);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 328:  mappingRuleCS ::= qualifierListOpt mapping qvtErrorToken
			//
			case 328: {
				
				MappingDeclarationCS mappingDecl = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingDeclarationCS();
				mappingDecl.setSimpleNameCS(createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "")); //$NON-NLS-1$
				CSTNode result = createMappingRuleCS(
						mappingDecl,
						null,
						null,
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
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
			// Rule 332:  oclExpressionCSOpt ::= $Empty
			//
			case 332:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 335:  mappingQueryCS ::= helperKindCS mappingDeclarationCS { statementListOpt }
			//
			case 335: {
				
				CSTNode result = createMappingQueryCS(
						(MappingDeclarationCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 336:  mappingQueryCS ::= helperKindCS mappingDeclarationCS ;
			//
			case 336: {
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)dtParser.getSym(2);
				CSTNode result = createMappingQueryCS(
						mappingDecl,
						ourEmptyEList
					);
				mappingDecl.setBlackBox(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 337:  mappingQueryCS ::= helperKindCS mappingDeclarationCS qvtErrorToken
			//
			case 337: {
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)dtParser.getSym(2);
				CSTNode result = createMappingQueryCS(
						mappingDecl,
						ourEmptyEList
					);
				mappingDecl.setBlackBox(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), mappingDecl);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 338:  mappingQueryCS ::= helperKindCS qvtErrorToken
			//
			case 338: {
				
				CSTNode result = createMappingQueryCS(
						null,
						ourEmptyEList
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 339:  entryDeclarationCS ::= main ( parameterListOpt )
			//
			case 339: {
				
				CSTNode result = createMappingDeclarationCS(
						null,
						createScopedNameCS(null, getTokenText(dtParser.getToken(1))),
						(EList)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 340:  entryDeclarationCS ::= main qvtErrorToken
			//
			case 340: {
				
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
			// Rule 341:  mappingDeclarationCS ::= directionKindOpt scopedNameCS ( parameterListOpt ) : typeSpecCS
			//
			case 341: {
				
				DirectionKindCS directionKind = (DirectionKindCS)dtParser.getSym(1);
				CSTNode result = createMappingDeclarationCS(
						directionKind,
						(ScopedNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4),
						(TypeSpecCS)dtParser.getSym(7)
					);
				setOffsets(result, (CSTNode)(directionKind == null ? dtParser.getSym(2) : directionKind), (CSTNode)dtParser.getSym(7));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 342:  mappingDeclarationCS ::= directionKindOpt scopedNameCS ( parameterListOpt )
			//
			case 342: {
				
				DirectionKindCS directionKind = (DirectionKindCS)dtParser.getSym(1);
				CSTNode result = createMappingDeclarationCS(
						directionKind,
						(ScopedNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4),
						null
					);
				setOffsets(result, (CSTNode)(directionKind == null ? dtParser.getSym(2) : directionKind), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 343:  mappingDeclarationCS ::= directionKindOpt scopedNameCS qvtErrorToken
			//
			case 343: {
				
				DirectionKindCS directionKind = (DirectionKindCS)dtParser.getSym(1);
				CSTNode result = createMappingDeclarationCS(
						directionKind,
						(ScopedNameCS)dtParser.getSym(2),
						ourEmptyEList,
						null
					);
				setOffsets(result, (CSTNode)(directionKind == null ? dtParser.getSym(2) : directionKind), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 344:  expressionListOpt ::= $Empty
			//
			case 344:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 346:  expressionList ::= oclExpressionCS
			//
			case 346: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 347:  expressionList ::= expressionList ; oclExpressionCS
			//
			case 347: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 350:  expressionList ::= qvtErrorToken
			//
			case 350:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 351:  directionKindOpt ::= $Empty
			//
			case 351:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 353:  directionKindCS ::= in
			//
			case 353: {
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.IN
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 354:  directionKindCS ::= out
			//
			case 354: {
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.OUT
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 355:  directionKindCS ::= inout
			//
			case 355: {
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.INOUT
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 356:  parameterListOpt ::= $Empty
			//
			case 356:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 358:  parameterList ::= qvtErrorToken
			//
			case 358: {
				
				EList result = new BasicEList();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 359:  parameterList ::= parameterDeclarationCS
			//
			case 359: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 360:  parameterList ::= parameterList , parameterDeclarationCS
			//
			case 360: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 361:  parameterList ::= parameterList qvtErrorToken
			//
			case 361: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 362:  parameterDeclarationCS ::= directionKindOpt IDENTIFIER : typeSpecCS
			//
			case 362: {
				
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
			// Rule 363:  typeSpecCS ::= typeCS
			//
			case 363: {
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)dtParser.getSym(1),
					null
					);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 364:  typeSpecCS ::= typeCS @ IDENTIFIER
			//
			case 364: {
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)dtParser.getSym(1),
					getIToken(dtParser.getToken(3))
					);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 365:  mappingGuardOpt ::= $Empty
			//
			case 365:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 367:  mappingGuardCS ::= when { oclExpressionCS }
			//
			case 367: {
				
				OCLExpressionCS result = (OCLExpressionCS)dtParser.getSym(3);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 368:  mappingGuardCS ::= when { oclExpressionCS } qvtErrorToken
			//
			case 368: {
				
				OCLExpressionCS result = (OCLExpressionCS)dtParser.getSym(3);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 369:  mappingGuardCS ::= when qvtErrorToken
			//
			case 369: {
				
				dtParser.setSym1(null);
	  		  break;
			}
	 
			//
			// Rule 370:  mappingInitOpt ::= $Empty
			//
			case 370:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 372:  mappingInitCS ::= init { statementListOpt }
			//
			case 372: {
				
				CSTNode result = createMappingInitCS(
						(EList)dtParser.getSym(3),
						getIToken(dtParser.getToken(2)).getEndOffset(),
						getIToken(dtParser.getToken(4)).getStartOffset()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 373:  mappingInitCS ::= init qvtErrorToken
			//
			case 373: {
				
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
			// Rule 374:  mappingEndOpt ::= $Empty
			//
			case 374:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 376:  mappingEndCS ::= end { statementListOpt }
			//
			case 376: {
				
				CSTNode result = createMappingEndCS(
						(EList)dtParser.getSym(3),
						getIToken(dtParser.getToken(2)).getEndOffset(),
						getIToken(dtParser.getToken(4)).getStartOffset()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 377:  mappingEndCS ::= end qvtErrorToken
			//
			case 377: {
				
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
			// Rule 378:  statementListOpt ::= $Empty
			//
			case 378:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 380:  statementList ::= qvtErrorToken
			//
			case 380: {
				
				EList result = new BasicEList();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 383:  statementInnerList ::= statementCS
			//
			case 383: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 384:  statementInnerList ::= statementInnerList ; statementCS
			//
			case 384: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 385:  statementInnerList ::= statementInnerList qvtErrorToken
			//
			case 385: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 388:  statementCS ::= oclExpressionCS
			//
			case 388: {
				
				CSTNode result = createExpressionStatementCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 389:  statementCS ::= primaryOCLExpressionCS
			//
			case 389: {
				
				CSTNode result = createExpressionStatementCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 391:  variableInitializationCSCorrect ::= var IDENTIFIER : typeCS := oclExpressionCS
			//
			case 391: {
				
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
			// Rule 392:  variableInitializationCS ::= var IDENTIFIER : typeCS := qvtErrorToken
			//
			case 392: {
				
				CSTNode result = createVariableInitializationCS(
						getIToken(dtParser.getToken(2)),
						(TypeCS)dtParser.getSym(4),
						createBooleanLiteralExpCS("null")
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 393:  variableInitializationCSCorrect ::= var IDENTIFIER := oclExpressionCS
			//
			case 393: {
				
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
			// Rule 394:  variableInitializationCS ::= var IDENTIFIER := qvtErrorToken
			//
			case 394: {
				
				CSTNode result = createVariableInitializationCS(
						getIToken(dtParser.getToken(2)),
						null,
						createBooleanLiteralExpCS("null")
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 395:  variableInitializationCS ::= var IDENTIFIER : typeCS
			//
			case 395: {
				
				CSTNode result = createVariableInitializationCS(
						getIToken(dtParser.getToken(2)),
						(TypeCS)dtParser.getSym(4),
						createBooleanLiteralExpCS("null")
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 396:  variableInitializationCS ::= var IDENTIFIER : qvtErrorToken
			//
			case 396: {
				
				CSTNode result = createVariableInitializationCS(
						getIToken(dtParser.getToken(2)),
						null,
						createBooleanLiteralExpCS("null")
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 397:  variableInitializationCS ::= var IDENTIFIER
			//
			case 397: {
				
				CSTNode result = createVariableInitializationCS(
						getIToken(dtParser.getToken(2)),
						null,
						createBooleanLiteralExpCS("null")
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 398:  variableInitializationCS ::= var qvtErrorToken
			//
			case 398: {
				
				IToken errorToken = getIToken(dtParser.getToken(2));
				CSTNode result = createVariableInitializationCS(
						new Token(errorToken.getStartOffset(), errorToken.getEndOffset(), QvtOpLPGParsersym.TK_ERROR_TOKEN),
						null,
						createBooleanLiteralExpCS("null")
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 399:  assignStatementCS ::= oclExpressionCS := oclExpressionCS
			//
			case 399: {
				
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
			// Rule 400:  assignStatementCS ::= oclExpressionCS := qvtErrorToken
			//
			case 400: {
				
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
			// Rule 401:  assignStatementCS ::= oclExpressionCS += oclExpressionCS
			//
			case 401: {
				
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
			// Rule 402:  assignStatementCS ::= oclExpressionCS += qvtErrorToken
			//
			case 402: {
				
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
			// Rule 403:  mappingBodyOpt ::= population { expressionListOpt }
			//
			case 403: {
				
			MappingBodyCS result = createMappingBodyCS(
					(EList<OCLExpressionCS>)dtParser.getSym(3),
					false, true
				);
			setOffsets(result, getIToken(dtParser.getToken(2)), getIToken(dtParser.getToken(4)));
			dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 404:  mappingBodyOpt ::= outExpCS
			//
			case 404: {
				
				MappingBodyCS result = createMappingBodyCS(
						(OutExpCS)dtParser.getSym(1),
						false, false
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 405:  mappingBodyOpt ::= patternPropertyOrAdditionList
			//
			case 405: {
				
				EList props = (EList)dtParser.getSym(1);
				OutExpCS outExp = createOutExpCS(props, getIToken(dtParser.getToken(1)).getStartOffset(), getIToken(dtParser.getToken(1)).getEndOffset());
				if (!props.isEmpty()) {
					CSTNode head = (CSTNode) props.get(0);
					CSTNode tail = (CSTNode) props.get(props.size()-1);
					setOffsets(outExp, head, tail);
				}
				MappingBodyCS result = createMappingBodyCS(
						outExp,
						true, false
					);
				setOffsets(result, outExp);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 406:  patternPropertyOrAdditionList ::= $Empty
			//
			case 406:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 409:  patternPropertyOrAdditionInnerList ::= patternPropertyOrAddition2
			//
			case 409: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 410:  patternPropertyOrAdditionInnerList ::= patternPropertyOrAdditionList ; patternPropertyOrAddition2
			//
			case 410: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 412:  patternPropertyOrAddition2 ::= qvtErrorToken patternPropertyOrAddition
			//
			case 412: {
				
				dtParser.setSym1(dtParser.getSym(2));
	  		  break;
			}
	 
			//
			// Rule 413:  patternPropertyOrAddition ::= IDENTIFIER := oclExpressionCS
			//
			case 413: {
				
				CSTNode result = createPatternPropertyCS(
						getIToken(dtParser.getToken(1)),
						(OCLExpressionCS)dtParser.getSym(3),
						false
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 414:  patternPropertyOrAddition ::= IDENTIFIER := qvtErrorToken
			//
			case 414: {
				
				CSTNode result = createPatternPropertyCS(
						getIToken(dtParser.getToken(1)),
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, ""), //$NON-NLS-1$
						false
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 415:  patternPropertyOrAddition ::= IDENTIFIER += oclExpressionCS
			//
			case 415: {
				
				CSTNode result = createPatternPropertyCS(
						getIToken(dtParser.getToken(1)),
						(OCLExpressionCS)dtParser.getSym(3),
						true
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 416:  patternPropertyOrAddition ::= IDENTIFIER += qvtErrorToken
			//
			case 416: {
				
				CSTNode result = createPatternPropertyCS(
						getIToken(dtParser.getToken(1)),
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, ""), //$NON-NLS-1$
						true
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 417:  patternPropertyOrAddition ::= IDENTIFIER qvtErrorToken
			//
			case 417: {
				
				CSTNode result = createPatternPropertyCS(
						getIToken(dtParser.getToken(1)),
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, ""), //$NON-NLS-1$
						true
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 418:  typeSpecCSOpt ::= $Empty
			//
			case 418:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 420:  objectDeclCS ::= typeSpecCS
			//
			case 420: {
				
				CSTNode result = createOutExpCS(null, (TypeSpecCS)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 424:  objectDeclCS ::= objectIdentifierCS : typeSpecCSOpt
			//
			case 424: {
				
			SimpleNameCS varName = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(varName, getIToken(dtParser.getToken(1)));
			CSTNode result = createOutExpCS(varName,(TypeSpecCS)dtParser.getSym(3));					
			dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 425:  outExpCS ::= object objectDeclCS { patternPropertyOrAdditionList }
			//
			case 425: {
				
				CSTNode result = setupOutExpCS(
						(OutExpCS)dtParser.getSym(2),					
						(EList)dtParser.getSym(4),
						// passing body positions
						getIToken(dtParser.getToken(3)).getEndOffset(),
						getIToken(dtParser.getToken(5)).getStartOffset()
					); 
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 426:  outExpCS ::= object objectDeclCS { patternPropertyOrAdditionList qvtErrorToken
			//
			case 426: {
				
				OutExpCS outExpCS = ((OutExpCS)dtParser.getSym(2));
				EList<CSTNode> patternPropertyOrAdditionList = (EList<CSTNode>)dtParser.getSym(4);
				CSTNode result = createErrorOutExpCS(
						outExpCS.getSimpleNameCS(),						
						outExpCS.getTypeSpecCS(),
						(EList)dtParser.getSym(4),						
						getIToken(dtParser.getToken(3)).getEndOffset(),
						getIToken(dtParser.getToken(5)).getStartOffset(),
						getIToken(dtParser.getToken(1)).getStartOffset(),
						getIToken(dtParser.getToken(5)).getStartOffset()
					);
				if (patternPropertyOrAdditionList.isEmpty()) {
				    setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				} else {
				    CSTNode lastNode = patternPropertyOrAdditionList.get(patternPropertyOrAdditionList.size() - 1);
				    setOffsets(result, getIToken(dtParser.getToken(1)), lastNode);
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 427:  outExpCS ::= object objectDeclCS qvtErrorToken
			//
			case 427: {
				
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
			// Rule 428:  featureMappingCallExpCS ::= map simpleNameCS ( argumentsCSopt )
			//
			case 428: {
				
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
			// Rule 429:  featureMappingCallExpCS ::= xmap simpleNameCS ( argumentsCSopt )
			//
			case 429: {
				
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
			// Rule 430:  mappingCallExpCS ::= map pathNameCS ( argumentsCSopt )
			//
			case 430: {
				
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
			// Rule 431:  mappingCallExpCS ::= xmap pathNameCS ( argumentsCSopt )
			//
			case 431: {
				
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
			// Rule 432:  resolveConditionOpt ::= $Empty
			//
			case 432:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 433:  resolveConditionOpt ::= | oclExpressionCS
			//
			case 433: {
				
                dtParser.setSym1((OCLExpressionCS)dtParser.getSym(2));
      		  break;
			}
     
			//
			// Rule 434:  resolveConditionOpt ::= | qvtErrorToken
			//
			case 434:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 435:  IDENTIFIEROpt ::= $Empty
			//
			case 435:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 436:  IDENTIFIEROpt ::= IDENTIFIER :
			//
			case 436: {
				
                dtParser.setSym1(getIToken(dtParser.getToken(1)));
      		  break;
			}
     
			//
			// Rule 437:  resolveOpArgsExpCS ::= $Empty
			//
			case 437:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 438:  resolveOpArgsExpCS ::= IDENTIFIEROpt typeCS resolveConditionOpt
			//
			case 438: {
				
                CSTNode result = createResolveOpArgsExpCS(
                        getIToken(dtParser.getToken(1)),      // target_type_variable?
                        (TypeCS)dtParser.getSym(2),           // type?
                        (OCLExpressionCS)dtParser.getSym(3)); // condition?
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 443:  lateOpt ::= $Empty
			//
			case 443:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 445:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCS )
			//
			case 445: {
				
                CSTNode result = createResolveExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        (ResolveOpArgsExpCS)dtParser.getSym(4));
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 446:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCS qvtErrorToken
			//
			case 446: {
				
                CSTNode result = createResolveExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        (ResolveOpArgsExpCS)dtParser.getSym(4));
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 447:  resolveExpCS ::= lateOpt resolveOp qvtErrorToken
			//
			case 447: {
				
                CSTNode result = createResolveExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        null);
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 448:  resolveExpCS ::= late qvtErrorToken
			//
			case 448: {
				
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
			// Rule 453:  resolveInExpCS ::= lateOpt resolveInOp ( scopedNameCS , resolveOpArgsExpCS )
			//
			case 453: {
				
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
			// Rule 454:  resolveInExpCS ::= lateOpt resolveInOp ( scopedNameCS , resolveOpArgsExpCS qvtErrorToken
			//
			case 454: {
				
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
			// Rule 455:  resolveInExpCS ::= lateOpt resolveInOp ( scopedNameCS qvtErrorToken
			//
			case 455: {
				
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
			// Rule 456:  resolveInExpCS ::= lateOpt resolveInOp ( qvtErrorToken
			//
			case 456: {
				
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
			// Rule 457:  resolveInExpCS ::= lateOpt resolveInOp qvtErrorToken
			//
			case 457: {
				
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
			// Rule 460:  callExpCS ::= . resolveResolveInExpCS
			//
			case 460: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 463:  legacyWhileExpCS ::= while ( oclExpressionCS ; oclExpressionCS ) whileBodyCS
			//
			case 463: {
				
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
			// Rule 464:  whileDeclaratorCS ::= IDENTIFIER : typeCS
			//
			case 464: {
				
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
			// Rule 465:  whileDeclaratorCS ::= IDENTIFIER : typeCS = oclExpressionCS
			//
			case 465: {
				
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
			// Rule 466:  whileDeclaratorCS ::= IDENTIFIER : typeCS := oclExpressionCS
			//
			case 466: {
				
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
			// Rule 467:  whileDeclaratorCS ::= IDENTIFIER := oclExpressionCS
			//
			case 467: {
				
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
			// Rule 468:  whileExpCS ::= while ( whileDeclaratorCS ; oclExpressionCS ) whileBodyCS
			//
			case 468: {
				
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
			// Rule 469:  whileExpCS ::= while ( oclExpressionCS ) whileBodyCS
			//
			case 469: {
				
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
			// Rule 476:  letExpSubCS3 ::= variableCS2
			//
			case 476: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 477:  letExpSubCS3 ::= letExpSubCS3 , variableCS2
			//
			case 477: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 478:  letExpCS ::= let letExpSubCS3 in oclExpressionCS
			//
			case 478: {
				
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
			// Rule 479:  letExpCS ::= let letExpSubCS3 in qvtErrorToken
			//
			case 479: {
				
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
			// Rule 480:  simpleNameCS ::= this
			//
			case 480:
 
			//
			// Rule 481:  simpleNameCS ::= result
			//
			case 481: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 482:  modelTypeExpCS ::= modeltype IDENTIFIER complianceKindCSOpt uses packageRefList modelTypeWhereCSOpt ;
			//
			case 482: {
				
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
			// Rule 483:  modelTypeExpCS ::= modeltype qvtErrorToken
			//
			case 483: {
				
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
			// Rule 484:  complianceKindCSOpt ::= $Empty
			//
			case 484: {
				
				CSTNode result = createStringLiteralExpCS("''");
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 486:  packageRefList ::= packageRefCS
			//
			case 486: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 487:  packageRefList ::= packageRefList , packageRefCS
			//
			case 487: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 488:  packageRefCS ::= pathNameCS
			//
			case 488: {
				
				CSTNode result = createPackageRefCS(
						(PathNameCS)dtParser.getSym(1),
						null
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 489:  packageRefCS ::= pathNameCS ( qvtStringLiteralExpCS )
			//
			case 489: {
				
				CSTNode result = createPackageRefCS(
						(PathNameCS)dtParser.getSym(1),
						(StringLiteralExpCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 490:  packageRefCS ::= qvtStringLiteralExpCS
			//
			case 490: {
				
				CSTNode result = createPackageRefCS(
						null,
						(StringLiteralExpCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 492:  qvtStringLiteralExpCS ::= QUOTE_STRING_LITERAL
			//
			case 492: {
				
				CSTNode result = createStringLiteralExpCS("'" + unquote(getTokenText(dtParser.getToken(1))) + "'"); //$NON-NLS-1$ //$NON-NLS-2$
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 493:  modelTypeWhereCSOpt ::= $Empty
			//
			case 493:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 494:  modelTypeWhereCSOpt ::= where { statementListOpt }
			//
			case 494: {
				
				EList result = (EList)dtParser.getSym(3);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 497:  qvtErrorToken ::= ERROR_TOKEN
			//
			case 497: {
				
				diagnozeErrorToken(dtParser.getToken(1));
	  		  break;
			}
	 
			//
			// Rule 498:  iterContents ::= variableCS | qvtErrorToken
			//
			case 498: {
				
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
			// Rule 499:  callExpCS ::= . qvtErrorToken
			//
			case 499: {
				
				CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
	 			result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 500:  callExpCS ::= -> qvtErrorToken
			//
			case 500: {
				
				CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
	 			result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 501:  argumentsCS ::= qvtErrorToken
			//
			case 501:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 505:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS else ifExpBodyCS endif
			//
			case 505: {
				
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
			// Rule 506:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS endif
			//
			case 506: {
				
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
			// Rule 507:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS else ifExpBodyCS qvtErrorToken
			//
			case 507: {
				
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
			// Rule 508:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS else qvtErrorToken
			//
			case 508: {
				
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
			// Rule 509:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS qvtErrorToken
			//
			case 509: {
				
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
			// Rule 510:  ifExpCS ::= if oclExpressionCS then qvtErrorToken
			//
			case 510: {
				
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
			// Rule 511:  ifExpCS ::= if oclExpressionCS qvtErrorToken
			//
			case 511: {
				
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
			// Rule 512:  ifExpCS ::= if qvtErrorToken
			//
			case 512: {
				
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
			// Rule 515:  switchExpCS ::= switch switchBodyExpCS
			//
			case 515: {
				
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
			// Rule 517:  switchDeclaratorCS ::= IDENTIFIER
			//
			case 517: {
				
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
			// Rule 518:  switchDeclaratorCS ::= IDENTIFIER = oclExpressionCS
			//
			case 518: {
				
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
			// Rule 519:  iterateSwitchExpCS ::= switch ( switchDeclaratorCS ) switchBodyExpCS
			//
			case 519: {
				
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
			// Rule 520:  switchExpCS ::= switch qvtErrorToken
			//
			case 520: {
				
				CSTNode result = createSwitchExpCS(
						new BasicEList(),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 521:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt }
			//
			case 521: {
				
				Object[] result = new Object[] {dtParser.getSym(2), dtParser.getSym(3), getIToken(dtParser.getToken(4))};
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 522:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt qvtErrorToken
			//
			case 522: {
				
				Object[] result = new Object[] {dtParser.getSym(2), dtParser.getSym(3), dtParser.getSym(3)};
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 523:  switchBodyExpCS ::= { qvtErrorToken
			//
			case 523: {
				
				Object[] result = new Object[] {new BasicEList(), null, getIToken(dtParser.getToken(1))};
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 524:  switchAltExpCSList ::= switchAltExpCS
			//
			case 524: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 525:  switchAltExpCSList ::= switchAltExpCSList switchAltExpCS
			//
			case 525: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 526:  switchAltExpCS ::= ( oclExpressionCS ) ? statementCS ;
			//
			case 526: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(2),
						(OCLExpressionCS) dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 527:  switchAltExpCS ::= case ( oclExpressionCS ) expressionStatementCS
			//
			case 527: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(3),
						(OCLExpressionCS) dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 528:  switchAltExpCS ::= ( oclExpressionCS ) ? statementCS qvtErrorToken
			//
			case 528: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(2),
						(OCLExpressionCS) dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode) dtParser.getSym(5));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 529:  switchAltExpCS ::= ( oclExpressionCS ) qvtErrorToken
			//
			case 529: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(2),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 530:  switchAltExpCS ::= ( qvtErrorToken
			//
			case 530: {
				
				CSTNode result = createSwitchAltExpCS(
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 531:  switchElseExpCSOpt ::= $Empty
			//
			case 531:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 533:  switchElseExpCS ::= else ? statementCS ;
			//
			case 533: {
				
				dtParser.setSym1((CSTNode)dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 534:  switchElseExpCS ::= else expressionStatementCS
			//
			case 534: {
				
				dtParser.setSym1((CSTNode)dtParser.getSym(2));
	  		  break;
			}
	 
			//
			// Rule 535:  switchElseExpCS ::= else ? statementCS qvtErrorToken
			//
			case 535: {
				
				dtParser.setSym1((CSTNode)dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 536:  switchElseExpCS ::= else qvtErrorToken
			//
			case 536: {
				
				dtParser.setSym1(null);
	  		  break;
			}
	 
			//
			// Rule 548:  iteratorExpCS ::= iteratorExpCSToken ( iterContents )
			//
			case 548: {
				
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
			// Rule 549:  iteratorExpCS ::= iteratorExpCSToken ( iterContents qvtErrorToken
			//
			case 549: {
				
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
			// Rule 550:  iteratorExpCS ::= iteratorExpCSToken ( qvtErrorToken
			//
			case 550: {
				
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
			// Rule 551:  operationCallExpCS ::= oclAsType isMarkedPreCS ( typeCS )
			//
			case 551:
 
			//
			// Rule 552:  operationCallExpCS ::= oclIsKindOf isMarkedPreCS ( typeCS )
			//
			case 552:
 
			//
			// Rule 553:  operationCallExpCS ::= oclIsTypeOf isMarkedPreCS ( typeCS )
			//
			case 553: {
				
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
			// Rule 555:  logWhenExp ::= when oclExpressionCS
			//
			case 555: {
				
			OCLExpressionCS condition = (OCLExpressionCS) dtParser.getSym(2);
			dtParser.setSym1(condition);
      		  break;
			}
     
			//
			// Rule 557:  logWhenExpOpt ::= $Empty
			//
			case 557:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 558:  logExpCS ::= log ( argumentsCSopt ) logWhenExpOpt
			//
			case 558: {
				
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
			// Rule 560:  severityKindCS ::= simpleNameCS
			//
			case 560: {
				
			dtParser.setSym1(dtParser.getSym(1));
	  		  break;
			}
	 
			//
			// Rule 562:  severityKindCSOpt ::= $Empty
			//
			case 562:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 563:  assertWithLogExp ::= with logExpCS
			//
			case 563: {
				
			LogExpCS logExp = (LogExpCS) dtParser.getSym(2);
			setOffsets(logExp, getIToken(dtParser.getToken(2)), logExp);
			dtParser.setSym1(logExp);
      		  break;
			}
     
			//
			// Rule 565:  assertWithLogExpOpt ::= $Empty
			//
			case 565:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 566:  assertExpCS ::= assert severityKindCSOpt ( oclExpressionCS ) assertWithLogExpOpt
			//
			case 566: {
				
			LogExpCS logExpCS = (LogExpCS)dtParser.getSym(6);
			OCLExpressionCS condition = (OCLExpressionCS)dtParser.getSym(4);
			AssertExpCS result = (AssertExpCS)createAssertExpCS(condition, (SimpleNameCS)dtParser.getSym(2), logExpCS);
	
			CSTNode end = logExpCS != null ? logExpCS : condition; 
			setOffsets(result, getIToken(dtParser.getToken(1)), end);
			dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 567:  blockExpCS ::= { statementListOpt }
			//
			case 567: {
				
			EList bodyList = (EList) dtParser.getSym(2);
			CSTNode result = createBlockExpCS(
				bodyList
			);
			
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
			dtParser.setSym1(result);
      		  break;
			}
	 
			//
			// Rule 580:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken12 ( imperativeIterContents12 )
			//
			case 580:
 
			//
			// Rule 581:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken3 ( imperativeIterContents3 )
			//
			case 581: {
				
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
			// Rule 582:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken qvtErrorToken
			//
			case 582: {
				
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
			// Rule 583:  imperativeIterContents12 ::= oclExpressionCS
			//
			case 583: {
				
				dtParser.setSym1(new Object[] {
						ourEmptyEList,
						null,
						dtParser.getSym(1)
					});
	  		  break;
			}
	 
			//
			// Rule 584:  imperativeIterContents12 ::= variableListCS | oclExpressionCS
			//
			case 584: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						null,
						dtParser.getSym(3)
					});
	  		  break;
			}
	 
			//
			// Rule 585:  imperativeIterContents3 ::= variableListCS ; variableCS2 | oclExpressionCS
			//
			case 585: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						dtParser.getSym(3),
						dtParser.getSym(5)
					});
	  		  break;
			}
	 
			//
			// Rule 586:  exclamationOpt ::= $Empty
			//
			case 586:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 588:  declarator_vsep ::= IDENTIFIER |
			//
			case 588: {
				
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
			// Rule 589:  declarator_vsepOpt ::= $Empty
			//
			case 589:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 591:  condExpOpt ::= $Empty
			//
			case 591:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 592:  callExpCS ::= -> featureCallExpCS exclamationOpt [ declarator_vsepOpt oclExpressionCS ]
			//
			case 592: {
				
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
			// Rule 593:  oclExpCS ::= oclExpCS exclamationOpt [ oclExpressionCS ]
			//
			case 593: {
				
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
			// Rule 594:  dotArrowExpCS ::= dotArrowExpCS . featureCallExpCS exclamationOpt [ oclExpressionCS ]
			//
			case 594: {
				
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
			// Rule 595:  equalityExpCS ::= equalityExpCS != relationalExpCS
			//
			case 595:
 
			//
			// Rule 596:  equalityWithLet ::= equalityExpCS != relationalWithLet
			//
			case 596: {
				
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
	
	
			default:
				break;
		}
		return;
	}
}

