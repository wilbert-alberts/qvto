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
* $Id: LightweightParser.java,v 1.2.2.7 2008/01/07 11:03:26 radvorak Exp $
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
* $Id: LightweightParser.java,v 1.2.2.7 2008/01/07 11:03:26 radvorak Exp $
*/

package org.eclipse.m2m.qvt.oml.editor.ui.completion.cst.parser;


import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.internal.cst.BooleanLiteralExpCS;
import org.eclipse.ocl.internal.cst.CSTFactory;
import org.eclipse.ocl.internal.cst.CSTNode;
import org.eclipse.ocl.internal.cst.CallExpCS;
import org.eclipse.ocl.internal.cst.ClassifierContextDeclCS;
import org.eclipse.ocl.internal.cst.CollectionLiteralExpCS;
import org.eclipse.ocl.internal.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.internal.cst.CollectionRangeCS;
import org.eclipse.ocl.internal.cst.CollectionTypeCS;
import org.eclipse.ocl.internal.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.internal.cst.DefCS;
import org.eclipse.ocl.internal.cst.DefExpressionCS;
import org.eclipse.ocl.internal.cst.DerValueCS;
import org.eclipse.ocl.internal.cst.DotOrArrowEnum;
import org.eclipse.ocl.internal.cst.EnumLiteralExpCS;
import org.eclipse.ocl.internal.cst.FeatureCallExpCS;
import org.eclipse.ocl.internal.cst.IfExpCS;
import org.eclipse.ocl.internal.cst.InitOrDerValueCS;
import org.eclipse.ocl.internal.cst.InitValueCS;
import org.eclipse.ocl.internal.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.internal.cst.InvCS;
import org.eclipse.ocl.internal.cst.InvOrDefCS;
import org.eclipse.ocl.internal.cst.InvalidLiteralExpCS;
import org.eclipse.ocl.internal.cst.IsMarkedPreCS;
import org.eclipse.ocl.internal.cst.IterateExpCS;
import org.eclipse.ocl.internal.cst.IteratorExpCS;
import org.eclipse.ocl.internal.cst.LetExpCS;
import org.eclipse.ocl.internal.cst.MessageExpCS;
import org.eclipse.ocl.internal.cst.MessageExpKind;
import org.eclipse.ocl.internal.cst.NullLiteralExpCS;
import org.eclipse.ocl.internal.cst.OCLExpressionCS;
import org.eclipse.ocl.internal.cst.OCLMessageArgCS;
import org.eclipse.ocl.internal.cst.OperationCS;
import org.eclipse.ocl.internal.cst.OperationCallExpCS;
import org.eclipse.ocl.internal.cst.OperationContextDeclCS;
import org.eclipse.ocl.internal.cst.PackageDeclarationCS;
import org.eclipse.ocl.internal.cst.PathNameCS;
import org.eclipse.ocl.internal.cst.PrePostOrBodyDeclCS;
import org.eclipse.ocl.internal.cst.PrePostOrBodyEnum;
import org.eclipse.ocl.internal.cst.PrimitiveTypeCS;
import org.eclipse.ocl.internal.cst.PropertyContextCS;
import org.eclipse.ocl.internal.cst.RealLiteralExpCS;
import org.eclipse.ocl.internal.cst.SimpleNameCS;
import org.eclipse.ocl.internal.cst.SimpleTypeEnum;
import org.eclipse.ocl.internal.cst.StateExpCS;
import org.eclipse.ocl.internal.cst.StringLiteralExpCS;
import org.eclipse.ocl.internal.cst.TupleLiteralExpCS;
import org.eclipse.ocl.internal.cst.TupleTypeCS;
import org.eclipse.ocl.internal.cst.TypeCS;
import org.eclipse.ocl.internal.cst.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.internal.cst.VariableCS;
import org.eclipse.ocl.internal.cst.VariableExpCS;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;

import lpg.lpgjavaruntime.BadParseException;
import lpg.lpgjavaruntime.BadParseSymFileException;
import lpg.lpgjavaruntime.DeterministicParser;
import lpg.lpgjavaruntime.DiagnoseParser;
import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.LexStream;
import lpg.lpgjavaruntime.Monitor;
import lpg.lpgjavaruntime.NotDeterministicParseTableException;
import lpg.lpgjavaruntime.NullExportedSymbolsException;
import lpg.lpgjavaruntime.NullTerminalSymbolsException;
import lpg.lpgjavaruntime.ParseTable;
import lpg.lpgjavaruntime.PrsStream;
import lpg.lpgjavaruntime.RuleAction;
import lpg.lpgjavaruntime.UndefinedEofSymbolException;
import lpg.lpgjavaruntime.UnimplementedTerminalsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lpg.lpgjavaruntime.Token;
import lpg.lpgjavaruntime.BacktrackingParser;
import lpg.lpgjavaruntime.NotBacktrackParseTableException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.qvt.oml.QvtPlugin;
import org.eclipse.m2m.qvt.oml.internal.cst.AssertExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.LogExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.AssignStatementCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ConfigPropertyCS;
import org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindCS;
import org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindEnum;
import org.eclipse.m2m.qvt.oml.internal.cst.ExpressionStatementCS;
import org.eclipse.m2m.qvt.oml.internal.cst.LibraryCS;
import org.eclipse.m2m.qvt.oml.internal.cst.LibraryImportCS;
import org.eclipse.m2m.qvt.oml.internal.cst.LocalPropertyCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingCallExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingEndCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingInitCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingQueryCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingRuleCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingSectionCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ModuleImportCS;
import org.eclipse.m2m.qvt.oml.internal.cst.OutExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ParameterDeclarationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.RenameCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ResolveExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ResolveInExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.VariableInitializationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.SwitchAltExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.SwitchExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.WhileExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.BlockExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS;
import org.eclipse.m2m.qvt.oml.internal.cst.PackageRefCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ElementWithBody;
import org.eclipse.m2m.qvt.oml.internal.cst.temp.ErrorOutExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.temp.ResolveOpArgsExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.temp.ScopedNameCS;
import org.eclipse.m2m.qvt.oml.internal.cst.temp.TempFactory;
import org.eclipse.m2m.qvt.oml.internal.cst.ModuleKindEnum;
import org.eclipse.m2m.qvt.oml.internal.cst.ModuleKindCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ModuleRefCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ImportKindEnum;
import org.eclipse.m2m.qvt.oml.internal.cst.ModuleUsageCS;
import org.eclipse.m2m.qvt.oml.internal.cst.TransformationRefineCS;
import org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS;
import org.eclipse.m2m.qvt.oml.internal.cst.TypeSpecCS;

import org.eclipse.m2m.qvt.oml.internal.cst.parser.QvtOpLPGParserprs;
import org.eclipse.m2m.qvt.oml.internal.cst.parser.QvtOpLPGParsersym;

public class LightweightParser extends PrsStream implements RuleAction {
	protected static ParseTable prs = new LightweightParserprs();
	private BacktrackingParser dtParser;
	private static Map<Integer, String> ruleTexts;

	public LightweightParser(LexStream lexStream) {
		super(lexStream);

		try {
			super.remapTerminalSymbols(orderedTerminalSymbols(), LightweightParserprs.EOFT_SYMBOL);
		}
		catch(NullExportedSymbolsException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		}
		catch(NullTerminalSymbolsException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		}
		catch(UnimplementedTerminalsException e) {
			java.util.ArrayList unimplemented_symbols = e.getSymbols();
			String error = "The Lexer will not scan the following token(s):";
			for (int i = 0; i < unimplemented_symbols.size(); i++) {
				Integer id = (Integer) unimplemented_symbols.get(i);
				error += "\t" + LightweightParsersym.orderedTerminalSymbols[id.intValue()];			   
			}
			throw new RuntimeException(error + "\n");						
		}
		catch(UndefinedEofSymbolException e) {
			throw new RuntimeException("The Lexer does not implement the Eof symbol " +
				 LightweightParsersym.orderedTerminalSymbols[LightweightParserprs.EOFT_SYMBOL]);
		} 
	}

	public String[] orderedTerminalSymbols() { return LightweightParsersym.orderedTerminalSymbols; }
	public String getTokenKindName(int kind) { return LightweightParsersym.orderedTerminalSymbols[kind]; }			
	public int getEOFTokenKind() { return LightweightParserprs.EOFT_SYMBOL; }
	public PrsStream getParseStream() { return this; }

	protected EObject parser() throws ParserException {
		return parser(null, 0);
	}
		
	protected EObject parser(Monitor monitor) throws ParserException {
		return parser(monitor, 0);
	}
		
	protected EObject parser(int error_repair_count) throws ParserException {
		return parser(null, error_repair_count);
	}
		
	protected EObject parser(Monitor monitor, int error_repair_count) throws ParserException {
		ParseTable prsTable = new LightweightParserprs();

		try {
			dtParser = new BacktrackingParser(monitor, this, prsTable, this);
		}
		catch (NotBacktrackParseTableException e) {
			throw new RuntimeException("****Error: Regenerate LightweightParserprs.java with -NOBACKTRACK option");
		}
		catch (BadParseSymFileException e) {
			throw new RuntimeException("****Error: Bad Parser Symbol File -- LightweightParsersym.java. Regenerate LightweightParserprs.java");
		}

		try {
		    workaroundEOFErrors();
			return (EObject) dtParser.parse(error_repair_count);
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
		java.util.ArrayList tokens = getTokens();
		String result = getName(e.error_token) + " ~~ ";
		for (int i = Math.max(0, e.error_token-5), n = Math.min(tokens.size(), e.error_token+5); i < n; ++i) {
			result += tokens.get(i).toString();
			result += " ";
		}
		System.err.println(result);
	}


	protected PackageDeclarationCS createPackageDeclarationCS(
			PathNameCS pathNameCS,
			EList contextDecls) {
		PackageDeclarationCS result = CSTFactory.eINSTANCE.createPackageDeclarationCS();
		result.setPathNameCS(pathNameCS);
		if (contextDecls != null && !contextDecls.isEmpty())
			result.getContextDecls().addAll(contextDecls);
		return result;
	}
	
	protected PropertyContextCS createPropertyContextCS(
			PathNameCS pathNameCS,
			SimpleNameCS simpleNameCS,
			TypeCS typeCS,
			InitOrDerValueCS initOrDerValueCS) {
		PropertyContextCS result = CSTFactory.eINSTANCE.createPropertyContextCS();
		result.setPathNameCS(pathNameCS);
		result.setSimpleNameCS(simpleNameCS);
		result.setTypeCS(typeCS);
		result.setInitOrDerValueCS(initOrDerValueCS);
		return result;
	}
	
	protected DerValueCS createDerValueCS(
			InitOrDerValueCS initOrDerValueCS,
			OCLExpressionCS oclExpressionCS) {
		DerValueCS result = CSTFactory.eINSTANCE.createDerValueCS();
		result.setInitOrDerValueCS(initOrDerValueCS);
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	protected InitValueCS createInitValueCS(
			InitOrDerValueCS initOrDerValueCS,
			OCLExpressionCS oclExpressionCS) {
		InitValueCS result = CSTFactory.eINSTANCE.createInitValueCS();
		result.setInitOrDerValueCS(initOrDerValueCS);
		result.setExpressionCS(oclExpressionCS);
		return result;
	}
	
	protected ClassifierContextDeclCS createClassifierContextDeclCS(
			PathNameCS pathNameCS,
			InvOrDefCS invOrDefCS) {
		ClassifierContextDeclCS result = CSTFactory.eINSTANCE.createClassifierContextDeclCS();
		result.setPathNameCS(pathNameCS);
		result.setInvOrDefCS(invOrDefCS);
		return result;
	}
	
	protected InvCS createInvCS(
			InvOrDefCS invOrDefCS,
			SimpleNameCS simpleNameCS,
			OCLExpressionCS oclExpressionCS) {
		InvCS result = CSTFactory.eINSTANCE.createInvCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setExpressionCS(oclExpressionCS);
		result.setInvOrDefCS(invOrDefCS);
		return result;
	}
	
	protected DefCS createDefCS(
			InvOrDefCS invOrDefCS,
			SimpleNameCS simpleNameCS,
			DefExpressionCS defExpressionCS) {
		DefCS result = CSTFactory.eINSTANCE.createDefCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setDefExpressionCS(defExpressionCS);
		result.setInvOrDefCS(invOrDefCS);
		return result;
	}
	
	protected DefExpressionCS createDefExpressionCS(
			VariableCS variableCS,
			OperationCS operationCS,
			OCLExpressionCS oclExpressionCS) {
		DefExpressionCS result = CSTFactory.eINSTANCE.createDefExpressionCS();
		result.setVariableCS(variableCS);
		result.setOperationCS(operationCS);
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	protected OperationContextDeclCS createOperationContextDeclCS(
			OperationCS operationCS,
			EList prePostOrBodyDecls) {
		OperationContextDeclCS result = CSTFactory.eINSTANCE.createOperationContextDeclCS();
		result.setOperationCS(operationCS);
		result.getPrePostOrBodyDecls().addAll(prePostOrBodyDecls);
		return result;
	}

	protected PrePostOrBodyDeclCS createPrePostOrBodyDeclCS(
			PrePostOrBodyEnum kind,
			SimpleNameCS simpleNameCS,
			OCLExpressionCS oclExpressionCS) {
		PrePostOrBodyDeclCS result = CSTFactory.eINSTANCE.createPrePostOrBodyDeclCS();
		result.setKind(kind);
		result.setSimpleNameCS(simpleNameCS);
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	protected OperationCS createOperationCS(
			PathNameCS pathNameCS,
			SimpleNameCS simpleNameCS,
			EList list,
			TypeCS typeCS) {
		OperationCS result = CSTFactory.eINSTANCE.createOperationCS();
		result.setPathNameCS(pathNameCS);
		result.setSimpleNameCS(simpleNameCS);
		result.getParameters().addAll(list);
		result.setTypeCS(typeCS);
		return result;
	}

	protected OperationCS createOperationCS(
			String simpleName,
			EList list,
			TypeCS typeCS) {
		return createOperationCS(
				null,
				createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, simpleName),
				list,
				typeCS);
	}

	protected OperationCallExpCS createOperationCallExpCS(
			OCLExpressionCS oclExpressionCS,
			SimpleNameCS simpleNameCS,
			IsMarkedPreCS isMarkedPreCS,
			EList arguments) {
		OperationCallExpCS result = CSTFactory.eINSTANCE.createOperationCallExpCS();
		result.setSource(oclExpressionCS);
		result.setSimpleNameCS(simpleNameCS);
		result.setIsMarkedPreCS(isMarkedPreCS);
		result.getArguments().addAll(arguments);
		return result;
	}

	protected OperationCallExpCS createOperationCallExpCS(
			OCLExpressionCS oclExpressionCS,
			SimpleNameCS simpleNameCS,
			EList arguments) {
		return createOperationCallExpCS(oclExpressionCS, simpleNameCS,
				createIsMarkedPreCS(false), arguments);
	}

	protected OperationCallExpCS createOperationCallExpCS(
			SimpleNameCS simpleNameCS,
			IsMarkedPreCS isMarkedPreCS,
			EList arguments) {
		return createOperationCallExpCS(null, simpleNameCS, isMarkedPreCS, arguments);
	}

	protected OperationCallExpCS createOperationCallExpCS(
			SimpleNameCS simpleNameCS,
			IsMarkedPreCS isMarkedPreCS,
			StateExpCS stateExpCS) {
		OperationCallExpCS result = CSTFactory.eINSTANCE.createOperationCallExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setIsMarkedPreCS(isMarkedPreCS);
		result.getArguments().add(stateExpCS);
		return result;
	}
	
	private StateExpCS createStateExpCS(PathNameCS pathName) {
		StateExpCS result = CSTFactory.eINSTANCE.createStateExpCS();
		result.getSequenceOfNames().addAll(pathName.getSequenceOfNames());
		return result;
	}

	protected VariableExpCS createVariableExpCS(
			SimpleNameCS simpleNameCS,
			EList arguments,
			IsMarkedPreCS isMarkedPreCS) {
		VariableExpCS result = CSTFactory.eINSTANCE.createVariableExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.getArguments().addAll(arguments);
		result.setIsMarkedPreCS(isMarkedPreCS);
		return result;
	}

	protected SimpleNameCS createSimpleNameCS(
			SimpleTypeEnum type,
			String value) {
		SimpleNameCS result = CSTFactory.eINSTANCE.createSimpleNameCS();
		result.setType(type);
		result.setValue(unquote(value));
		return result;
	}

	protected PrimitiveTypeCS createPrimitiveTypeCS(
			SimpleTypeEnum type,
			String value) {
		PrimitiveTypeCS result = CSTFactory.eINSTANCE.createPrimitiveTypeCS();
		result.setType(type);
		result.setValue(value);
		return result;
	}

	/**
	 * Removes the "s surrounding a quoted string, if any.
	 * 
	 * @param quoted a possibly quoted string
	 * @return <code>quoted</code> without the surrounding quotes, or just
	 *	 <code>quoted</code> verbatim if there were none
	 */
	protected String unquote(String quoted) {
		String result = quoted;
	
		if ((result != null) && (result.length() > 1)) {
			int max = result.length() - 1;
	
			if ((result.charAt(0) == '"') && (quoted.charAt(max) == '"')) {
				result = result.substring(1, max);
			}
			
			// this is a regexp, so the backslash needs to be
			//   re-escaped, thus "\\" is rendered in a Java
			//   string literal as "\\\\"
			result = result.replaceAll("\\\\\"", "\"");  //$NON-NLS-2$//$NON-NLS-1$
		}
	
		return result;
	}

	private PathNameCS createPathNameCS(String pathName) {
		PathNameCS result = CSTFactory.eINSTANCE.createPathNameCS();
		result.getSequenceOfNames().add(unquote(pathName));
		return result;
	}
	
	private PathNameCS extendPathNameCS(PathNameCS path, String name) {
		path.getSequenceOfNames().add(unquote(name));
		return path;
	}

	private PathNameCS createPathNameCS() {
		return CSTFactory.eINSTANCE.createPathNameCS();
	}

	protected EnumLiteralExpCS createEnumLiteralExpCS(
			PathNameCS pathNameCS,
			SimpleNameCS simpleNameCS) {
		EnumLiteralExpCS result = CSTFactory.eINSTANCE.createEnumLiteralExpCS();
		result.setPathNameCS(pathNameCS);
		result.setSimpleNameCS(simpleNameCS);
		return result;
	}

	protected EnumLiteralExpCS createEnumLiteralExpCS(
			PathNameCS pathNameCS,
			String simpleName) {
		return createEnumLiteralExpCS(pathNameCS,
			createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, simpleName));
	}

	protected CollectionLiteralExpCS createCollectionLiteralExpCS(
			CollectionTypeIdentifierEnum type,
			EList collectionLiteralParts) {
		CollectionLiteralExpCS result = CSTFactory.eINSTANCE.createCollectionLiteralExpCS();
		result.setCollectionType(type);
		result.getCollectionLiteralParts().addAll(collectionLiteralParts);
		return result;
	}

	protected CollectionLiteralPartCS createCollectionLiteralPartCS(OCLExpressionCS oclExpressionCS) {
		CollectionLiteralPartCS result = CSTFactory.eINSTANCE.createCollectionLiteralPartCS();
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	protected CollectionRangeCS createCollectionRangeCS(
			OCLExpressionCS oclExpressionCS,
			OCLExpressionCS lastOCLExpressionCS) {
		CollectionRangeCS result = CSTFactory.eINSTANCE.createCollectionRangeCS();
		result.setExpressionCS(oclExpressionCS);
		result.setLastExpressionCS(lastOCLExpressionCS);
		return result;
	}

	protected IntegerLiteralExpCS createRangeStart(
			String integerDotDot,
			boolean isNegative) {
		String intToken = integerDotDot.substring(0, integerDotDot.indexOf('.'));
		int intValue = Integer.parseInt(intToken);
		if (isNegative) {
			intValue = -intValue;
		}
		
		IntegerLiteralExpCS result = CSTFactory.eINSTANCE.createIntegerLiteralExpCS();
		result.setIntegerSymbol(new Integer(intValue));
		result.setSymbol(Integer.toString(intValue));
		
		return result;
	}

	protected TupleLiteralExpCS createTupleLiteralExpCS(EList variables) {
		TupleLiteralExpCS result = CSTFactory.eINSTANCE.createTupleLiteralExpCS();
		result.getVariables().addAll(variables);
		return result;
	}

	protected IntegerLiteralExpCS createIntegerLiteralExpCS(String string) {
		IntegerLiteralExpCS result = CSTFactory.eINSTANCE.createIntegerLiteralExpCS();
		result.setSymbol(string);
		result.setIntegerSymbol(Integer.valueOf(string));
		return result;
	}

	protected UnlimitedNaturalLiteralExpCS createUnlimitedNaturalLiteralExpCS(String string) {
		UnlimitedNaturalLiteralExpCS result = CSTFactory.eINSTANCE.createUnlimitedNaturalLiteralExpCS();
		result.setSymbol(string);
		if ("*".equals(string)) {
			result.setIntegerSymbol(-1);
		} else {
			result.setIntegerSymbol(Integer.valueOf(string));
		}
		return result;
	}

	protected RealLiteralExpCS createRealLiteralExpCS(String string) {
		RealLiteralExpCS result = CSTFactory.eINSTANCE.createRealLiteralExpCS();
		result.setSymbol(string);
		result.setRealSymbol(Double.valueOf(string));
		return result;
	}

	protected StringLiteralExpCS createStringLiteralExpCS(String string) {
		StringLiteralExpCS result = CSTFactory.eINSTANCE.createStringLiteralExpCS();
		result.setSymbol(string);
		result.setStringSymbol(string);
		return result;
	}

	protected BooleanLiteralExpCS createBooleanLiteralExpCS(String string) {
		BooleanLiteralExpCS result = CSTFactory.eINSTANCE.createBooleanLiteralExpCS();
		result.setSymbol(string);
		result.setBooleanSymbol(Boolean.valueOf(string));
		return result;
	}

	protected NullLiteralExpCS createNullLiteralExpCS(String string) {
		NullLiteralExpCS result = CSTFactory.eINSTANCE.createNullLiteralExpCS();
		result.setSymbol(string);
		return result;
	}

	protected InvalidLiteralExpCS createInvalidLiteralExpCS(String string) {
		InvalidLiteralExpCS result = CSTFactory.eINSTANCE.createInvalidLiteralExpCS();
		result.setSymbol(string);
		return result;
	}

	protected IteratorExpCS createIteratorExpCS(
			SimpleNameCS simpleNameCS,
			VariableCS variable1,
			VariableCS variable2,
			OCLExpressionCS oclExpressionCS) {
		IteratorExpCS result = CSTFactory.eINSTANCE.createIteratorExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setVariable1(variable1);
		result.setVariable2(variable2);
		result.setBody(oclExpressionCS);
		return result;
	}

	protected IterateExpCS createIterateExpCS(
			SimpleNameCS simpleNameCS,
			VariableCS variable1,
			VariableCS variable2,
			OCLExpressionCS oclExpressionCS) {
		IterateExpCS result = CSTFactory.eINSTANCE.createIterateExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setVariable1(variable1);
		result.setVariable2(variable2);
		result.setBody(oclExpressionCS);
		return result;
	}

	protected VariableCS createVariableCS(
			String varName,
			TypeCS typeCS,
			OCLExpressionCS oclExpressionCS) {
		VariableCS result = CSTFactory.eINSTANCE.createVariableCS();
		result.setName(unquote(varName));
		result.setTypeCS(typeCS);
		result.setInitExpression(oclExpressionCS);
		return result;
	}

	protected CollectionTypeCS createCollectionTypeCS(
			CollectionTypeIdentifierEnum collectionType,
			TypeCS typeCS) {
		CollectionTypeCS result = CSTFactory.eINSTANCE.createCollectionTypeCS();
		result.setCollectionTypeIdentifier(collectionType);
		result.setTypeCS(typeCS);
		return result;
	}

	protected TupleTypeCS createTupleTypeCS(EList variables) {
		TupleTypeCS result = CSTFactory.eINSTANCE.createTupleTypeCS();
		result.getVariables().addAll(variables);
		return result;
	}

	protected FeatureCallExpCS createFeatureCallExpCS(
			SimpleNameCS simpleNameCS,
			EList arguments,
			IsMarkedPreCS isMarkedPreCS) {
		FeatureCallExpCS result = CSTFactory.eINSTANCE.createFeatureCallExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.getArguments().addAll(arguments);
		result.setIsMarkedPreCS(isMarkedPreCS);
		return result;
	}

	protected IsMarkedPreCS createIsMarkedPreCS(boolean isMarkedPre) {
		IsMarkedPreCS result = CSTFactory.eINSTANCE.createIsMarkedPreCS();
		result.setPre(isMarkedPre);
		return result;
	}

	protected LetExpCS createLetExpCS(
			EList variables,
			OCLExpressionCS oclExpressionCS) {
		LetExpCS result = CSTFactory.eINSTANCE.createLetExpCS();
		result.getVariables().addAll(variables);
		result.setInExpression(oclExpressionCS);
		return result;
	}

	protected IfExpCS createIfExpCS(
			OCLExpressionCS condition,
			OCLExpressionCS thenExpression,
			OCLExpressionCS elseExpression) {
		IfExpCS result = CSTFactory.eINSTANCE.createIfExpCS();
		result.setCondition(condition);
		result.setThenExpression(thenExpression);
		result.setElseExpression(elseExpression);
		return result;
	}

	protected MessageExpCS createMessageExpCS(
			int kind,
			SimpleNameCS simpleNameCS,
			EList oclMessageArgs) {
		MessageExpCS result = CSTFactory.eINSTANCE.createMessageExpCS();
		result.setKind((kind == QvtOpLPGParsersym.TK_CARET)?
				MessageExpKind.HAS_SENT_LITERAL : MessageExpKind.SENT_LITERAL);
		result.setSimpleNameCS(simpleNameCS);
		result.getArguments().addAll(oclMessageArgs);
		return result;
	}

	protected OCLMessageArgCS createOCLMessageArgCS(
			TypeCS typeCS,
			OCLExpressionCS oclExpressionCS) {
		OCLMessageArgCS result = CSTFactory.eINSTANCE.createOCLMessageArgCS();
		result.setTypeCS(typeCS);
		result.setExpression(oclExpressionCS);
		return result;
	}
	
	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start and end offsets of the given <code>IToken</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param startEnd <code>IToken</code> to retrieve offsets from
	 */
	protected void setOffsets(CSTNode cstNode, IToken startEnd) {
		cstNode.setStartOffset(startEnd.getStartOffset());
		cstNode.setEndOffset(startEnd.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start and end offsets of the 2nd given <code>CSTNode</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param startEnd <code>CSTNode</code> to retrieve offsets from
	 */
	protected void setOffsets(CSTNode cstNode, CSTNode startEnd) {
		cstNode.setStartOffset(startEnd.getStartOffset());
		cstNode.setEndOffset(startEnd.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start offset of the 2nd given <code>CSTNode</code> and the
	 * end offset of the 3rd given <code>CSTNode</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param start <code>CSTNode</code> to retrieve start offset from
	 * @param end <code>CSTNode</code> to retrieve end offset from
	 */
	protected void setOffsets(CSTNode cstNode, CSTNode start, CSTNode end) {
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start offset of the 2nd given <code>CSTNode</code> and the
	 * end offset of the given <code>IToken</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param start <code>CSTNode</code> to retrieve start offset from
	 * @param end <code>IToken</code> to retrieve end offset from
	 */
	protected void setOffsets(CSTNode cstNode, CSTNode start, IToken end) {
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start offset of the given <code>IToken</code> and the
	 * end offset of the 2nd given <code>CSTNode</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param start <code>IToken</code> to retrieve start offset from
	 * @param end <code>CSTNode</code> to retrieve end offset from
	 */
	protected void setOffsets(CSTNode cstNode, IToken start, CSTNode end) {
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start offset of the 1std given <code>IToken</code> and the
	 * end offset of the 2nd given <code>IToken</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param start <code>IToken</code> to retrieve start offset from
	 * @param end <code>IToken</code> to retrieve end offset from
	 */
	protected void setOffsets(CSTNode cstNode, IToken start, IToken end) {
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	/**
	 * 
	 * QVT Operational specific part
	 *
	 */
	private static final boolean DEBUG = false;
	private static final EList ourEmptyEList = new BasicEList.UnmodifiableEList(0, new Object[0]);
	
	protected void setBodyOffsets(ElementWithBody element, CSTNode start, IToken end) {
		element.setBodyStartLocation(start.getEndOffset());
		element.setBodyEndLocation(end.getStartOffset());
	}
	
	protected CSTNode createLocalPropertyCS(IToken tokenText, TypeCS sym,
			OCLExpressionCS sym2) {
		LocalPropertyCS prop = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createLocalPropertyCS();
		SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, tokenText.toString());
		setOffsets(nameCS, tokenText);
		prop.setSimpleNameCS(nameCS);
		prop.setTypeCS(sym);
		prop.setOclExpressionCS(sym2);
		return prop;
	}

	protected CSTNode createConfigPropertyCS(IToken tokenText, TypeCS sym) {
		ConfigPropertyCS prop = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createConfigPropertyCS();
		SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, tokenText.toString());
		setOffsets(nameCS, tokenText);
		prop.setSimpleNameCS(nameCS);
		prop.setTypeCS(sym);
		return prop;
	}

	protected CSTNode createRenameCS(TypeCS sym, IToken tokenText,
			StringLiteralExpCS sym2) {
		RenameCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createRenameCS();
		SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, tokenText.toString());
		setOffsets(nameCS, tokenText);
		result.setSimpleNameCS(nameCS);
		result.setTypeCS(sym);
		result.setOriginalName(sym2);
		return result;
	}

	protected CSTNode createModuleImportCS(PathNameCS sym) {
		ModuleImportCS imp = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createModuleImportCS();
		imp.setPathNameCS(sym);
		return imp;
	}

	protected CSTNode createLibraryCS(PathNameCS name, EList imports, EList metamodels,
			EList renamings, EList properties, EList methods) {
		LibraryCS imp = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createLibraryCS();
		TransformationHeaderCS headerCS = createTransformationHeaderCS(ourEmptyEList, name, ourEmptyEList, ourEmptyEList, null);
		setOffsets(headerCS, name);
		initializeModule(imp, headerCS, imports, metamodels, renamings, properties, methods);
		return imp;
	}

	protected CSTNode createMappingModuleCS(PathNameCS name, EList imports, EList metamodels,
			EList renamings, EList properties, EList methods) {
		MappingModuleCS imp = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createMappingModuleCS();
		TransformationHeaderCS headerCS = createTransformationHeaderCS(ourEmptyEList, name, ourEmptyEList, ourEmptyEList, null);
		setOffsets(headerCS, name);
		initializeModule(imp, headerCS, imports, metamodels, renamings, properties, methods);
		return imp;
	}

	protected CSTNode createMappingModuleCS(TransformationHeaderCS header, EList imports, EList metamodels,
			EList renamings, EList properties, EList methods) {
		MappingModuleCS imp = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createMappingModuleCS();
		initializeModule(imp, header, imports, metamodels, renamings, properties, methods);
		return imp;
	}

	private void initializeModule(MappingModuleCS result, TransformationHeaderCS header, EList imports,
			EList metamodels, EList renamings, EList properties, EList methods) {
		result.setHeaderCS(header);
		result.getImports().addAll(imports);
		result.getMetamodels().addAll(metamodels);
		result.getRenamings().addAll(renamings);
		result.getProperties().addAll(properties);
		result.getMethods().addAll(methods);
	}
	
	protected MappingQueryCS createMappingQueryCS(MappingDeclarationCS sym, EList sym2) {
		MappingQueryCS query = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createMappingQueryCS();
		query.setMappingDeclarationCS(sym);
		query.getExpressions().addAll(sym2);
		return query;
	}

	protected CSTNode createMappingRuleCS(MappingDeclarationCS mappingDecl,
			OCLExpressionCS guard, MappingInitCS mappingInit, MappingBodyCS mappingBody, MappingEndCS mappingEnd) {
		MappingRuleCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createMappingRuleCS();
		result.setMappingDeclarationCS(mappingDecl);
		result.setGuard(guard);
		result.setMappingInitCS(mappingInit);
		if (mappingInit != null) {
			mappingInit.setMappingRuleCS(result);
		}
		result.setMappingBodyCS(mappingBody);
		result.setMappingEndCS(mappingEnd);
		if (mappingEnd != null) {
			mappingEnd.setMappingRuleCS(result);
		}
		return result;
	}

	protected CSTNode createLibraryImportCS(PathNameCS sym) {
		LibraryImportCS imp = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createLibraryImportCS();
		imp.setPathNameCS(sym);
		return imp;
	}

	protected CSTNode createVariableInitializationCS(IToken tokenText,
			TypeCS sym, OCLExpressionCS sym2) {
		VariableInitializationCS result = (tokenText.getKind() == QvtOpLPGParsersym.TK_ERROR_TOKEN)
			? TempFactory.eINSTANCE.createErrorVariableInitializationCS()
			: org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createVariableInitializationCS();
		SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, tokenText.toString());
		setOffsets(nameCS, tokenText);
		result.setSimpleNameCS(nameCS);
		result.setTypeCS(sym);
		result.setOclExpressionCS(sym2);
		return result;
	}

	protected CSTNode createExpressionStatementCS(OCLExpressionCS sym) {
		ExpressionStatementCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createExpressionStatementCS();
		result.setOclExpressionCS(sym);
		return result;
	}

	protected CSTNode createMappingEndCS(EList sym, int endOffset, int startOffset) {
		MappingEndCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createMappingEndCS();
		initializeMappingSection(result, sym, endOffset, startOffset);		
		return result;
	}

	protected CSTNode createMappingInitCS(EList sym, int endOffset, int startOffset) {
		MappingInitCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createMappingInitCS();
		initializeMappingSection(result, sym, endOffset, startOffset);		
		return result;
	}

	private void initializeMappingSection(MappingSectionCS section, EList statements, int endOffset, int startOffset) {
		section.getStatements().addAll(statements);
		section.setBodyStartLocation(startOffset);
		section.setBodyEndLocation(endOffset);
	}
	
	protected CSTNode createParameterDeclarationCS(DirectionKindCS sym,
			IToken tokenText, TypeSpecCS typeSpecCS) {
		ParameterDeclarationCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createParameterDeclarationCS();
		SimpleNameCS nameCS;
		if (tokenText != null) {
			nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, tokenText.toString());
			setOffsets(nameCS, tokenText);
		}
		else {
			nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "");
		}
		result.setSimpleNameCS(nameCS);
		result.setTypeSpecCS(typeSpecCS);
		if (sym != null) {
			result.setDirectionKind(sym.getDirectionKind());
		}
		return result;
	}

	protected TypeSpecCS createTypeSpecCS(TypeCS typeCS, IToken extentLocation) {
		TypeSpecCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createTypeSpecCS();
		result.setTypeCS(typeCS);
		setOffsets(result, typeCS);
		if (extentLocation != null) {
			SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, extentLocation.toString());
			setOffsets(nameCS, extentLocation);
			result.setSimpleNameCS(nameCS);
			result.setEndOffset(extentLocation.getEndOffset());
		}
		return result;
	}

	protected CSTNode createDirectionKindCS(DirectionKindEnum kind) {
		DirectionKindCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createDirectionKindCS();
		result.setDirectionKind(kind);
		return result;
	}

	protected CSTNode createMappingDeclarationCS(DirectionKindCS directionKindCS,
	        ScopedNameCS scopedNameCS, EList parameters, TypeSpecCS returnType) {
		MappingDeclarationCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createMappingDeclarationCS();
		result.setDirectionKindCS(directionKindCS);
		result.setReturnType(returnType);
		result.getParameters().addAll(parameters);
		result.setSimpleNameCS(createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, scopedNameCS.getName()));

		SimpleNameCS name = result.getSimpleNameCS();
		if(name != null) {
			int endOffset = scopedNameCS.getEndOffset();
			int length = (name.getValue() != null) ?  name.getValue().length() : 0;			
			name.setStartOffset(endOffset - (length > 0 ? length-1 : 0));
			name.setEndOffset(endOffset);
		}		

		result.setContextType(scopedNameCS.getTypeCS());
		return result;
	}

	private PathNameCS createParentPath(PathNameCS pathNameCS) {
		PathNameCS result = CSTFactory.eINSTANCE.createPathNameCS();
		result.getSequenceOfNames().addAll(pathNameCS.getSequenceOfNames());
		result.setStartOffset(pathNameCS.getStartOffset());
		if (result.getSequenceOfNames().size() > 0) {
			String lastSegment = result.getSequenceOfNames().remove(result.getSequenceOfNames().size()-1);
			result.setEndOffset(pathNameCS.getEndOffset()-lastSegment.length());
		}
		else {
			result.setEndOffset(pathNameCS.getEndOffset());
		}
		return result;
	}

	protected CSTNode createPatternPropertyCS(IToken tokenText, OCLExpressionCS sym, boolean b) {
		PatternPropertyExpCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createPatternPropertyExpCS();
		SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, tokenText.toString());
		setOffsets(nameCS, tokenText);
		result.setSimpleNameCS(nameCS);
		result.setOclExpressionCS(sym);
		result.setIncremental(b);
		return result;
	}

	protected CSTNode createAssignStatementCS(OCLExpressionCS sym,
			OCLExpressionCS sym2, boolean b) {
		AssignStatementCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createAssignStatementCS();
		result.setLValueCS(sym);
		result.setOclExpressionCS(sym2);
		result.setIncremental(b);
		return result;
	}
	
	protected void updateMappingBodyPositions(MappingBodyCS mappingBody,
			int bodyLeft, int bodyRight, int outBodyLeft, int outBodyRight) {
		if (mappingBody != null && mappingBody.isShort() && mappingBody.getOutExpCS() != null) {
			OutExpCS outExp = mappingBody.getOutExpCS();
			outExp.setStartOffset(bodyLeft);
			outExp.setEndOffset(bodyRight);
			outExp.setBodyStartLocation(outBodyLeft);
			outExp.setBodyEndLocation(outBodyRight);
			mappingBody.setStartOffset(bodyLeft);
			mappingBody.setEndOffset(bodyRight);
		}
	}

	protected OutExpCS createOutExpCS(OutExpCS result, EList expressions, TypeSpecCS typeSpecCS, int startOffset,
			int endOffset) {
		result.setTypeSpecCS(typeSpecCS);
		result.getExpressions().addAll(expressions);
		result.setBodyStartLocation(startOffset);
		result.setBodyEndLocation(endOffset);
		return result;
	}

	protected OutExpCS createOutExpCS(EList expressions, TypeSpecCS typeSpecCS, int startOffset,
			int endOffset) {
		OutExpCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createOutExpCS();
		return createOutExpCS(result, expressions, typeSpecCS, startOffset, endOffset);
	}

	protected OutExpCS createErrorOutExpCS(EList expressions, TypeSpecCS typeSpecCS, int startOffset,
			int endOffset, int fullStartOffset, int fullEndOffset) {
		ErrorOutExpCS result = TempFactory.eINSTANCE.createErrorOutExpCS();
		result.setFullStartOffset(fullStartOffset);
		result.setFullEndOffset(fullEndOffset);
		return createOutExpCS(result, expressions, typeSpecCS, startOffset, endOffset);
	}

	protected MappingBodyCS createMappingBodyCS(OutExpCS sym, boolean b) {
		MappingBodyCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createMappingBodyCS();
		result.setOutExpCS(sym);
		result.setShort(b);
		return result;
	}

	protected CSTNode createMappingCallExpCS(SimpleNameCS sym, EList arguments, boolean b) {
		MappingCallExpCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createMappingCallExpCS();
		result.setSimpleNameCS(sym);
		result.getArguments().addAll(arguments);
		result.setStrict(b);
		result.setIsMarkedPreCS(CSTFactory.eINSTANCE.createIsMarkedPreCS());
		return result;
	}

	protected CSTNode createMappingCallExpCS(PathNameCS sym, EList arguments, boolean b) {
		MappingCallExpCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createMappingCallExpCS();
		if (sym.getSequenceOfNames().size() > 1) {
			result.setSource(createParentPath(sym));
		}
		if (sym.getSequenceOfNames().size() > 0) {
			String lastSegment = sym.getSequenceOfNames().get(sym.getSequenceOfNames().size()-1);
			SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, lastSegment);
			nameCS.setStartOffset(sym.getEndOffset()-lastSegment.length() + 1);
			nameCS.setEndOffset(sym.getEndOffset());
			result.setSimpleNameCS(nameCS);
		}		
		result.getArguments().addAll(arguments);
		result.setStrict(b);
		result.setIsMarkedPreCS(CSTFactory.eINSTANCE.createIsMarkedPreCS());
		return result;
	}
	
	private CSTNode createResolveOpArgsExpCS(IToken target, TypeCS typeCS, OCLExpressionCS condition) {
	    ResolveOpArgsExpCS resolveOpArgsExpCS = TempFactory.eINSTANCE.createResolveOpArgsExpCS();
	    VariableCS variableCS = CSTFactory.eINSTANCE.createVariableCS();
	    variableCS.setTypeCS(typeCS);
	    if (target == null) {
			setOffsets(variableCS, typeCS);
	    } else {
	        variableCS.setName(target.toString());
			setOffsets(variableCS, target, typeCS);
	    }
	    resolveOpArgsExpCS.setTarget(variableCS);
	    resolveOpArgsExpCS.setCondition(condition);
	    return resolveOpArgsExpCS;
	}
	
	protected CSTNode createResolveExpCS(IToken lateToken, IToken opCode, ResolveOpArgsExpCS resolveOpArgsExpCS) {
	    return populateResolveExpCS(org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createResolveExpCS(), 
	            lateToken, opCode, resolveOpArgsExpCS);
	}
	
	protected CSTNode createResolveInExpCS(IToken lateToken, IToken opCode, ScopedNameCS mapping, ResolveOpArgsExpCS resolveOpArgsExpCS) {
		ResolveInExpCS resolveInExpCS = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createResolveInExpCS();
		resolveInExpCS.setInMappingType(mapping.getTypeCS());
		resolveInExpCS.setInMappingName(mapping.getName());
		return populateResolveExpCS(resolveInExpCS, lateToken, opCode, resolveOpArgsExpCS);
	}
	
	protected CSTNode populateResolveExpCS(ResolveExpCS resolveExpCS, IToken lateToken,
	        IToken opCode, ResolveOpArgsExpCS resolveOpArgsExpCS) {
	    resolveExpCS.setIsDeferred((lateToken != null) && getTokenKindName(QvtOpLPGParsersym.TK_late).equals(lateToken.toString()));
	    String opCodeText = opCode.toString();
	    resolveExpCS.setOne(opCodeText.indexOf("one") > 0); //$NON-NLS-1$
	    resolveExpCS.setIsInverse(opCodeText.indexOf("inv") == 0); //$NON-NLS-1$
	    if (resolveOpArgsExpCS != null) {
	        resolveExpCS.setTarget(resolveOpArgsExpCS.getTarget());
	        resolveExpCS.setCondition(resolveOpArgsExpCS.getCondition());
	    }
	    return resolveExpCS;
	}

	protected ScopedNameCS createScopedNameCS(TypeCS typeCS, String name) {
		ScopedNameCS result = TempFactory.eINSTANCE.createScopedNameCS();
		result.setTypeCS(typeCS);
		result.setName(name);
		return result;
	}
	
	protected CSTNode createWhileExpCS(OCLExpressionCS cond, OCLExpressionCS res, EList expressions) {
		WhileExpCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createWhileExpCS();
		result.setCondition(cond);
		result.setResult(res);
		result.getBodyExpressions().addAll(expressions);
		return result;
	}

	protected CSTNode createSwitchExpCS(EList<SwitchAltExpCS> altExps, OCLExpressionCS elseExp) {
		SwitchExpCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createSwitchExpCS();
		result.getAlternativePart().addAll(altExps);
		result.setElsePart(elseExp);
		return result;
	}

	protected CSTNode createSwitchAltExpCS(OCLExpressionCS cond, OCLExpressionCS body) {
		SwitchAltExpCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createSwitchAltExpCS();
		result.setCondition(cond);
		result.setBody(body);
		return result;
	}

	private CSTNode createBlockExpCS(EList expressions) {
		BlockExpCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createBlockExpCS();
		result.getBodyExpressions().addAll(expressions);
		return result;
	}

	protected ModelTypeCS createModelTypeCS(IToken identifier, StringLiteralExpCS complianceKind,
			EList packageRefList, EList whereList) {
		ModelTypeCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createModelTypeCS();
		SimpleNameCS identifierCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL,
					(identifier.getPrsStream() == null ? "" : identifier.toString()));
		identifierCS.setStartOffset(identifier.getStartOffset());
		identifierCS.setEndOffset(identifier.getEndOffset());
		result.setIdentifierCS(identifierCS);
		result.setComplianceKindCS(complianceKind);
		result.getPackageRefs().addAll(packageRefList);
		result.getWhereStatements().addAll(whereList);		
		return result;
	}

	protected CSTNode createPackageRefCS(PathNameCS scopedIdentifierCS, StringLiteralExpCS uriCS) {
		PackageRefCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createPackageRefCS();
		result.setPathNameCS(scopedIdentifierCS);
		result.setUriCS(uriCS);
		return result;
	}

	protected CSTNode createModuleKindCS(ModuleKindEnum moduleKind) {
		ModuleKindCS moduleKindCS = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createModuleKindCS();
		moduleKindCS.setModuleKind(moduleKind);
		return moduleKindCS;
	}
	
	protected CSTNode createModuleRefCS(PathNameCS pathNameCS, EList params) {
		ModuleRefCS moduleRefCS = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createModuleRefCS();
		moduleRefCS.setPathNameCS(pathNameCS);
		moduleRefCS.getParameters().addAll(params);
		return moduleRefCS;
	}

	protected CSTNode createModuleUsageCS(ImportKindEnum importKind,
			ModuleKindCS moduleKindCS, EList moduleRefs) {
		ModuleUsageCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createModuleUsageCS();
		result.setImportKind(importKind);
		result.setModuleKindCS(moduleKindCS);
		result.getModuleRefs().addAll(moduleRefs);
		return result;
	}
	
	protected CSTNode createTransformationRefineCS(ModuleRefCS moduleRefCS, IToken token) {
		TransformationRefineCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createTransformationRefineCS();
		result.setModuleRefCS(moduleRefCS);
		result.setSimpleNameCS(createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, token.toString()));
		return result;
	}

	protected TransformationHeaderCS createTransformationHeaderCS(EList qualifiers,
			PathNameCS pathNameCS, EList params, EList transfUsages, TransformationRefineCS transfRefineCS) {
		TransformationHeaderCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createTransformationHeaderCS();
		result.getQualifiers().addAll(qualifiers);
		result.getParameters().addAll(params);
		result.getModuleUsages().addAll(transfUsages);
		result.setTransformationRefineCS(transfRefineCS);
		result.setPathNameCS(pathNameCS);
		return result;
	}
	
	protected final CSTNode createLogExpCS(EList<OCLExpressionCS> args, OCLExpressionCS condition) {
		LogExpCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createLogExpCS();
		String name = getTokenKindName(QvtOpLPGParsersym.TK_log);
		result.setSimpleNameCS(createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, name));

		result.getArguments().addAll(args);		
		result.setCondition(condition);		
		return result;
	}
    
    protected final CSTNode createAssertExpCS(OCLExpressionCS assertCondition, SimpleNameCS severityIdentifier, LogExpCS logExpCS) {
		AssertExpCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createAssertExpCS();
		result.setAssertion(assertCondition);
		result.setSeverity(severityIdentifier);
		result.setLog(logExpCS);
		return result;
	}		
	
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

	private int getEndOffset(IToken token, EList... listOpt) {
		int offset = token.getEndOffset();
		for (EList list : listOpt) {
			if (list.size() == 0) {
				continue;
			}
			CSTNode node = (CSTNode) list.get(list.size()-1);
			offset = node.getEndOffset();
		}
		return offset;
	}

    public void ruleAction(int ruleNumber)
    {
        if (DEBUG) {
           System.out.println("RULE[" + ruleNumber + "]:   " + ruleTexts.get(ruleNumber)); //$NON-NLS-1$
        }
        switch(ruleNumber)
        {
 
			//
			// Rule 26:  parametersCSopt ::= $Empty
			//
			case 26:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 27:  simpleNameCSopt ::= $Empty
			//
			case 27:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 33:  impliesExpCS ::= impliesExpCS implies andOrXorExpCS
			//
			case 33:
 
			//
			// Rule 34:  impliesWithLet ::= impliesExpCS implies andOrXorWithLet
			//
			case 34:
 
			//
			// Rule 37:  andOrXorExpCS ::= andOrXorExpCS and equalityExpCS
			//
			case 37:
 
			//
			// Rule 38:  andOrXorExpCS ::= andOrXorExpCS or equalityExpCS
			//
			case 38:
 
			//
			// Rule 39:  andOrXorExpCS ::= andOrXorExpCS xor equalityExpCS
			//
			case 39:
 
			//
			// Rule 40:  andOrXorWithLet ::= andOrXorExpCS and equalityWithLet
			//
			case 40:
 
			//
			// Rule 41:  andOrXorWithLet ::= andOrXorExpCS or equalityWithLet
			//
			case 41:
 
			//
			// Rule 42:  andOrXorWithLet ::= andOrXorExpCS xor equalityWithLet
			//
			case 42: {
				
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
			// Rule 45:  equalityExpCS ::= equalityExpCS = relationalExpCS
			//
			case 45:
 
			//
			// Rule 46:  equalityWithLet ::= equalityExpCS = relationalWithLet
			//
			case 46: {
				
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
			// Rule 47:  equalityExpCS ::= equalityExpCS <> relationalExpCS
			//
			case 47:
 
			//
			// Rule 48:  equalityWithLet ::= equalityExpCS <> relationalWithLet
			//
			case 48: {
				
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
			// Rule 51:  relationalExpCS ::= relationalExpCS > ifExpCSPrec
			//
			case 51:
 
			//
			// Rule 52:  relationalWithLet ::= relationalExpCS > additiveWithLet
			//
			case 52: {
				
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
			// Rule 53:  relationalExpCS ::= relationalExpCS < ifExpCSPrec
			//
			case 53:
 
			//
			// Rule 54:  relationalWithLet ::= relationalExpCS < additiveWithLet
			//
			case 54: {
				
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
			// Rule 55:  relationalExpCS ::= relationalExpCS >= ifExpCSPrec
			//
			case 55:
 
			//
			// Rule 56:  relationalWithLet ::= relationalExpCS >= additiveWithLet
			//
			case 56: {
				
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
			// Rule 57:  relationalExpCS ::= relationalExpCS <= ifExpCSPrec
			//
			case 57:
 
			//
			// Rule 58:  relationalWithLet ::= relationalExpCS <= additiveWithLet
			//
			case 58: {
				
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
			// Rule 62:  additiveExpCS ::= additiveExpCS + multiplicativeExpCS
			//
			case 62:
 
			//
			// Rule 63:  additiveWithLet ::= additiveExpCS + multiplicativeWithLet
			//
			case 63: {
				
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
			// Rule 64:  additiveExpCS ::= additiveExpCS - multiplicativeExpCS
			//
			case 64:
 
			//
			// Rule 65:  additiveWithLet ::= additiveExpCS - multiplicativeWithLet
			//
			case 65: {
				
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
			// Rule 68:  multiplicativeExpCS ::= multiplicativeExpCS * unaryExpCS
			//
			case 68:
 
			//
			// Rule 69:  multiplicativeWithLet ::= multiplicativeExpCS * unaryWithLet
			//
			case 69: {
				
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
			// Rule 70:  multiplicativeExpCS ::= multiplicativeExpCS / unaryExpCS
			//
			case 70:
 
			//
			// Rule 71:  multiplicativeWithLet ::= multiplicativeExpCS / unaryWithLet
			//
			case 71: {
				
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
			// Rule 74:  unaryExpCS ::= - unaryExpCS
			//
			case 74: {
				
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
			// Rule 75:  unaryExpCS ::= not unaryExpCS
			//
			case 75: {
				
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
			// Rule 77:  dotArrowExpCS ::= dotArrowExpCS callExpCS
			//
			case 77: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setSource((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, (CSTNode)dtParser.getSym(1), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 78:  dotArrowExpCS ::= dotArrowExpCS messageExpCS
			//
			case 78: {
				
				MessageExpCS result = (MessageExpCS)dtParser.getSym(2);
				result.setTarget((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 79:  dotArrowExpCS ::= NUMERIC_OPERATION ( argumentsCSopt )
			//
			case 79: {
				
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
			// Rule 80:  dotArrowExpCS ::= pathNameCS :: simpleNameCS ( argumentsCSopt )
			//
			case 80: {
				
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
			// Rule 85:  oclExpCS ::= ( oclExpressionCS )
			//
			case 85: {
				
				CSTNode result = (CSTNode)dtParser.getSym(2);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 86:  variableExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 86: {
				
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
			// Rule 87:  variableExpCS ::= keywordAsIdentifier1 isMarkedPreCS
			//
			case 87: {
				
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
			// Rule 88:  variableExpCS ::= simpleNameCS [ argumentsCS ] isMarkedPreCS
			//
			case 88: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(5);
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(5));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 89:  variableExpCS ::= keywordAsIdentifier1 [ argumentsCS ] isMarkedPreCS
			//
			case 89: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(5);
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(5));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 91:  simpleNameCS ::= self
			//
			case 91: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.SELF_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 92:  simpleNameCS ::= IDENTIFIER
			//
			case 92: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 93:  primitiveTypeCS ::= Integer
			//
			case 93: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INTEGER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 94:  primitiveTypeCS ::= UnlimitedNatural
			//
			case 94: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 95:  primitiveTypeCS ::= String
			//
			case 95: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.STRING_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 96:  primitiveTypeCS ::= Real
			//
			case 96: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.REAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 97:  primitiveTypeCS ::= Boolean
			//
			case 97: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.BOOLEAN_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 98:  primitiveTypeCS ::= OclAny
			//
			case 98: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_ANY_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 99:  primitiveTypeCS ::= OclVoid
			//
			case 99: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_VOID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 100:  primitiveTypeCS ::= Invalid
			//
			case 100: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INVALID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 101:  primitiveTypeCS ::= OclMessage
			//
			case 101: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_MESSAGE_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 102:  pathNameCS ::= IDENTIFIER
			//
			case 102: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 103:  pathNameCS ::= pathNameCS :: simpleNameCS
			//
			case 103: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 104:  pathNameCSOpt ::= $Empty
			//
			case 104: {
				
				CSTNode result = createPathNameCS();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 112:  enumLiteralExpCS ::= pathNameCS :: keywordAsIdentifier
			//
			case 112: {
				
				CSTNode result = createEnumLiteralExpCS(
						(PathNameCS)dtParser.getSym(1),
						getTokenText(dtParser.getToken(3))
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 113:  enumLiteralExpCS ::= pathNameCS :: simpleNameCS
			//
			case 113: {
				
				CSTNode result = createEnumLiteralExpCS(
						(PathNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 114:  collectionLiteralExpCS ::= collectionTypeIdentifierCS { collectionLiteralPartsCSopt }
			//
			case 114: {
				
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
			// Rule 115:  collectionTypeIdentifierCS ::= Set
			//
			case 115: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.SET_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 116:  collectionTypeIdentifierCS ::= Bag
			//
			case 116: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.BAG_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 117:  collectionTypeIdentifierCS ::= Sequence
			//
			case 117: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.SEQUENCE_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 118:  collectionTypeIdentifierCS ::= Collection
			//
			case 118: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.COLLECTION_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 119:  collectionTypeIdentifierCS ::= OrderedSet
			//
			case 119: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 120:  collectionLiteralPartsCSopt ::= $Empty
			//
			case 120:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 122:  collectionLiteralPartsCS ::= collectionLiteralPartCS
			//
			case 122: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 123:  collectionLiteralPartsCS ::= collectionLiteralPartsCS , collectionLiteralPartCS
			//
			case 123: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 125:  collectionLiteralPartCS ::= oclExpressionCS
			//
			case 125: {
				
				CSTNode result = createCollectionLiteralPartCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 126:  collectionRangeCS ::= - INTEGER_RANGE_START oclExpressionCS
			//
			case 126: {
				
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
			// Rule 127:  collectionRangeCS ::= INTEGER_RANGE_START oclExpressionCS
			//
			case 127: {
				
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
			// Rule 128:  collectionRangeCS ::= oclExpressionCS .. oclExpressionCS
			//
			case 128: {
				
				CSTNode result = createCollectionRangeCS(
						(OCLExpressionCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 134:  tupleLiteralExpCS ::= Tuple { variableListCS2 }
			//
			case 134: {
				
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 135:  integerLiteralExpCS ::= INTEGER_LITERAL
			//
			case 135: {
				
				CSTNode result = createIntegerLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 136:  unlimitedNaturalLiteralExpCS ::= *
			//
			case 136: {
				
				CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 137:  realLiteralExpCS ::= REAL_LITERAL
			//
			case 137: {
				
				CSTNode result = createRealLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 138:  stringLiteralExpCS ::= STRING_LITERAL
			//
			case 138: {
				
				CSTNode result = createStringLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 139:  booleanLiteralExpCS ::= true
			//
			case 139: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 140:  booleanLiteralExpCS ::= false
			//
			case 140: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 141:  nullLiteralExpCS ::= null
			//
			case 141: {
				
				CSTNode result = createNullLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 142:  invalidLiteralExpCS ::= OclInvalid
			//
			case 142: {
				
				CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 143:  callExpCS ::= -> featureCallExpCS
			//
			case 143:
 
			//
			// Rule 144:  callExpCS ::= -> loopExpCS
			//
			case 144: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 145:  callExpCS ::= . keywordOperationCallExpCS
			//
			case 145:
 
			//
			// Rule 146:  callExpCS ::= . featureCallExpCS
			//
			case 146: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 149:  iterContents ::= oclExpressionCS
			//
			case 149: {
				
				dtParser.setSym1(new Object[] {
						null,
						null,
						dtParser.getSym(1)
					});
	  		  break;
			}
	 
			//
			// Rule 150:  iterContents ::= variableCS | oclExpressionCS
			//
			case 150: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						null,
						dtParser.getSym(3)
					});
	  		  break;
			}
	 
			//
			// Rule 151:  iterContents ::= variableCS , variableCS | oclExpressionCS
			//
			case 151: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						dtParser.getSym(3),
						dtParser.getSym(5)
					});
	  		  break;
			}
	 
			//
			// Rule 152:  iterateExpCS ::= iterate ( variableCS | oclExpressionCS )
			//
			case 152: {
				
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
			// Rule 153:  iterateExpCS ::= iterate ( variableCS ; variableCS | oclExpressionCS )
			//
			case 153: {
				
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
			// Rule 154:  variableCS ::= IDENTIFIER
			//
			case 154: {
				
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
			// Rule 155:  variableCS ::= IDENTIFIER : typeCS
			//
			case 155: {
				
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
			// Rule 156:  variableCS ::= IDENTIFIER : typeCS = oclExpressionCS
			//
			case 156: {
				
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
			// Rule 157:  variableCS2 ::= IDENTIFIER = oclExpressionCS
			//
			case 157: {
				
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
			// Rule 158:  typeCSopt ::= $Empty
			//
			case 158:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 164:  collectionTypeCS ::= collectionTypeIdentifierCS ( typeCS )
			//
			case 164: {
				
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
			// Rule 165:  tupleTypeCS ::= Tuple ( variableListCSopt )
			//
			case 165: {
				
				CSTNode result = createTupleTypeCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 166:  variableListCSopt ::= $Empty
			//
			case 166:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 168:  variableListCS ::= variableCS
			//
			case 168: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 169:  variableListCS ::= variableListCS , variableCS
			//
			case 169: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 170:  variableListCS2 ::= variableCS2
			//
			case 170:
 
			//
			// Rule 171:  variableListCS2 ::= variableCS
			//
			case 171: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 172:  variableListCS2 ::= variableListCS2 , variableCS2
			//
			case 172:
 
			//
			// Rule 173:  variableListCS2 ::= variableListCS2 , variableCS
			//
			case 173: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 176:  featureCallExpCS ::= MINUS isMarkedPreCS ( argumentsCSopt )
			//
			case 176:
 
			//
			// Rule 177:  featureCallExpCS ::= not isMarkedPreCS ( argumentsCSopt )
			//
			case 177: {
				
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
			// Rule 178:  operationCallExpCS ::= simpleNameCS isMarkedPreCS ( argumentsCSopt )
			//
			case 178: {
				
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
			// Rule 179:  operationCallExpCS ::= oclIsUndefined isMarkedPreCS ( argumentsCSopt )
			//
			case 179:
 
			//
			// Rule 180:  operationCallExpCS ::= oclIsInvalid isMarkedPreCS ( argumentsCSopt )
			//
			case 180:
 
			//
			// Rule 181:  operationCallExpCS ::= oclIsNew isMarkedPreCS ( argumentsCSopt )
			//
			case 181:
 
			//
			// Rule 182:  operationCallExpCS ::= EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 182:
 
			//
			// Rule 183:  operationCallExpCS ::= NOT_EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 183:
 
			//
			// Rule 184:  operationCallExpCS ::= PLUS isMarkedPreCS ( argumentsCSopt )
			//
			case 184:
 
			//
			// Rule 185:  operationCallExpCS ::= MULTIPLY isMarkedPreCS ( argumentsCSopt )
			//
			case 185:
 
			//
			// Rule 186:  operationCallExpCS ::= DIVIDE isMarkedPreCS ( argumentsCSopt )
			//
			case 186:
 
			//
			// Rule 187:  operationCallExpCS ::= GREATER isMarkedPreCS ( argumentsCSopt )
			//
			case 187:
 
			//
			// Rule 188:  operationCallExpCS ::= LESS isMarkedPreCS ( argumentsCSopt )
			//
			case 188:
 
			//
			// Rule 189:  operationCallExpCS ::= GREATER_EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 189:
 
			//
			// Rule 190:  operationCallExpCS ::= LESS_EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 190:
 
			//
			// Rule 191:  operationCallExpCS ::= and isMarkedPreCS ( argumentsCSopt )
			//
			case 191:
 
			//
			// Rule 192:  operationCallExpCS ::= or isMarkedPreCS ( argumentsCSopt )
			//
			case 192:
 
			//
			// Rule 193:  operationCallExpCS ::= xor isMarkedPreCS ( argumentsCSopt )
			//
			case 193:
 
			//
			// Rule 194:  keywordOperationCallExpCS ::= keywordAsIdentifier isMarkedPreCS ( argumentsCSopt )
			//
			case 194: {
				
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
			// Rule 195:  operationCallExpCS ::= oclIsInState isMarkedPreCS ( pathNameCSOpt )
			//
			case 195: {
				
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
			// Rule 196:  attrOrNavCallExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 196: {
				
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
			// Rule 197:  attrOrNavCallExpCS ::= keywordAsIdentifier isMarkedPreCS
			//
			case 197: {
				
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
			// Rule 198:  attrOrNavCallExpCS ::= simpleNameCS [ argumentsCS ] isMarkedPreCS
			//
			case 198: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(5);
				CSTNode result = createFeatureCallExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(5));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
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
						getIToken(dtParser.getToken(1)).getKind(),
						(SimpleNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4)
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
			// Rule 221:  mappingModuleCS ::= moduleImportListOpt metamodelListOpt transformationCS moduleImportListOpt metamodelListOpt renamingListOpt propertyListOpt mappingRuleListOpt
			//
			case 221: {
				
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
			// Rule 222:  mappingModuleCS ::= moduleImportListOpt metamodelListOpt transformationCS qvtErrorToken
			//
			case 222: {
				
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
			// Rule 223:  mappingModuleCS ::= moduleImportListOpt metamodelListOpt qualifierListOpt transformation qvtErrorToken
			//
			case 223: {
				
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
			// Rule 224:  transformationCS ::= transformationHeaderCS ;
			//
			case 224: {
				
				TransformationHeaderCS result = (TransformationHeaderCS) dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 225:  transformationHeaderCS ::= qualifierListOpt transformation qualifiedNameCS
			//
			case 225: {
				
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
			// Rule 226:  transformationHeaderCS ::= qualifierListOpt transformation qualifiedNameCS ( transfParamListOpt ) moduleUsageListOpt transformationRefineCSOpt
			//
			case 226: {
				
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
			// Rule 227:  transformationRefineCSOpt ::= $Empty
			//
			case 227:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 228:  transformationRefineCSOpt ::= refines moduleRefCS enforcing IDENTIFIER
			//
			case 228: {
				
				CSTNode result = createTransformationRefineCS(
						(ModuleRefCS)dtParser.getSym(2),
						getIToken(dtParser.getToken(4))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 229:  moduleUsageListOpt ::= $Empty
			//
			case 229:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 231:  moduleUsageList ::= moduleUsageCS
			//
			case 231: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 232:  moduleUsageList ::= moduleUsageList moduleUsageCS
			//
			case 232: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 233:  moduleUsageCS ::= access moduleKindOpt moduleRefList
			//
			case 233: {
				
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
			// Rule 234:  moduleUsageCS ::= extends moduleKindOpt moduleRefList
			//
			case 234: {
				
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
			// Rule 235:  moduleKindOpt ::= $Empty
			//
			case 235:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 237:  moduleKindCS ::= transformation
			//
			case 237: {
				
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.TRANSFORMATION
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 238:  moduleKindCS ::= library
			//
			case 238: {
				
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.LIBRARY
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 239:  moduleRefList ::= moduleRefCS
			//
			case 239: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 240:  moduleRefList ::= moduleRefList , moduleRefCS
			//
			case 240: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 241:  moduleRefList ::= moduleRefList qvtErrorToken
			//
			case 241: {
				
				EList result = (EList) dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 242:  moduleRefCS ::= pathNameCS
			//
			case 242: {
				
				CSTNode result = createModuleRefCS(
						(PathNameCS)dtParser.getSym(1),
						ourEmptyEList
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 243:  moduleRefCS ::= pathNameCS ( transfParamListOpt )
			//
			case 243: {
				
				CSTNode result = createModuleRefCS(
						(PathNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 244:  qualifierListOpt ::= $Empty
			//
			case 244:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 246:  qualifierList ::= qualifierCS
			//
			case 246: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 247:  qualifierList ::= qualifierList qualifierCS
			//
			case 247: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 248:  qualifierCS ::= blackbox
			//
			case 248:
 
			//
			// Rule 249:  qualifierCS ::= abstract
			//
			case 249:
 
			//
			// Rule 250:  qualifierCS ::= static
			//
			case 250: {
				
				CSTNode result = createStringLiteralExpCS("'" + getTokenText(dtParser.getToken(1)) + "'"); //$NON-NLS-1$ //$NON-NLS-2$
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 251:  transfParamListOpt ::= $Empty
			//
			case 251:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 253:  transfParamList ::= transfParamCS
			//
			case 253: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 254:  transfParamList ::= transfParamList , transfParamCS
			//
			case 254: {
				
				EList result = (EList) dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 255:  transfParamList ::= transfParamList qvtErrorToken
			//
			case 255: {
				
				EList result = (EList) dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 256:  transfParamCS ::= directionKindOpt pathNameCS
			//
			case 256: {
				
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
			// Rule 257:  transfParamCS ::= directionKindOpt IDENTIFIER : pathNameCS
			//
			case 257: {
				
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
			// Rule 258:  libraryCS ::= moduleImportListOpt metamodelListOpt library qualifiedNameCS ; moduleImportListOpt metamodelListOpt renamingListOpt propertyListOpt mappingRuleListOpt
			//
			case 258: {
				
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
			// Rule 259:  libraryCS ::= moduleImportListOpt metamodelListOpt library qualifiedNameCS ; qvtErrorToken
			//
			case 259: {
				
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
			// Rule 260:  libraryCS ::= moduleImportListOpt metamodelListOpt library qualifiedNameCS qvtErrorToken
			//
			case 260: {
				
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
			// Rule 261:  libraryCS ::= moduleImportListOpt metamodelListOpt library qvtErrorToken
			//
			case 261: {
				
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
			// Rule 262:  qualifiedNameCS ::= qvtIdentifierCS
			//
			case 262: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 263:  qualifiedNameCS ::= qualifiedNameCS . qvtIdentifierCS
			//
			case 263: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 264:  qualifiedNameCS ::= qualifiedNameCS . qvtErrorToken
			//
			case 264: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, "");
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 265:  qualifiedNameCS ::= qualifiedNameCS qvtErrorToken
			//
			case 265: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}	
	 
			//
			// Rule 269:  scopedNameCS ::= typeCS2 :: IDENTIFIER
			//
			case 269: {
				
				ScopedNameCS result = createScopedNameCS((TypeCS)dtParser.getSym(1), 
															getTokenText(dtParser.getToken(3)));		
				setOffsets(result, (CSTNode) dtParser.getSym(1), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 270:  scopedNameCS ::= typeCS2 :: qvtErrorToken
			//
			case 270: {
				
				ScopedNameCS result = createScopedNameCS((TypeCS)dtParser.getSym(1), 
															""); //$NON-NLS-1$		
				setOffsets(result, (CSTNode) dtParser.getSym(1), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 271:  scopedNameCS ::= scopedNameCS2
			//
			case 271: {
				
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
			// Rule 272:  scopedNameCS2 ::= IDENTIFIER
			//
			case 272: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 273:  scopedNameCS2 ::= main
			//
			case 273: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 274:  scopedNameCS2 ::= scopedNameCS2 :: IDENTIFIER
			//
			case 274: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 275:  scopedNameCS2 ::= scopedNameCS2 :: qvtErrorToken
			//
			case 275: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, "");
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 276:  moduleImportListOpt ::= $Empty
			//
			case 276:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 278:  moduleImportList ::= importCS
			//
			case 278: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 279:  moduleImportList ::= moduleImportList importCS
			//
			case 279: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 280:  moduleImportList ::= moduleImportList qvtErrorToken
			//
			case 280: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 281:  importCS ::= import qualifiedNameCS ;
			//
			case 281: {
				
				CSTNode result = createModuleImportCS(
						(PathNameCS)dtParser.getSym(2)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 282:  importCS ::= import library qualifiedNameCS ;
			//
			case 282: {
				
				CSTNode result = createLibraryImportCS(
						(PathNameCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 283:  importCS ::= import qvtErrorToken
			//
			case 283: {
				
				CSTNode result = createLibraryImportCS(
						createPathNameCS()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 284:  importCS ::= import library qvtErrorToken
			//
			case 284: {
				
				CSTNode result = createLibraryImportCS(
						createPathNameCS()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 285:  metamodelListOpt ::= $Empty
			//
			case 285:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 287:  metamodelList ::= metamodelCS
			//
			case 287: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 288:  metamodelList ::= metamodelList metamodelCS
			//
			case 288: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 289:  metamodelList ::= metamodelList qvtErrorToken
			//
			case 289: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 291:  metamodelCS ::= metamodel stringLiteralExpCS ;
			//
			case 291: {
				
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
			// Rule 292:  metamodelCS ::= metamodel qvtErrorToken
			//
			case 292: {
				
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
			// Rule 293:  renamingListOpt ::= $Empty
			//
			case 293:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 295:  renamingList ::= renamingCS
			//
			case 295: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 296:  renamingList ::= renamingList renamingCS
			//
			case 296: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 297:  renamingList ::= renamingList qvtErrorToken
			//
			case 297: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 298:  renamingCS ::= rename typeCS . qvtIdentifierCS = stringLiteralExpCS ;
			//
			case 298: {
				
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
			// Rule 299:  propertyListOpt ::= $Empty
			//
			case 299:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 301:  propertyList ::= modulePropertyCS
			//
			case 301: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 302:  propertyList ::= propertyList modulePropertyCS
			//
			case 302: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 303:  propertyList ::= propertyList qvtErrorToken
			//
			case 303: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 304:  modulePropertyCS ::= configuration property qvtIdentifierCS : typeCS ;
			//
			case 304: {
				
				CSTNode result = createConfigPropertyCS(
						getIToken(dtParser.getToken(3)),
						(TypeCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 305:  modulePropertyCS ::= configuration property qvtIdentifierCS : typeCS qvtErrorToken
			//
			case 305: {
				
				CSTNode result = createConfigPropertyCS(
						getIToken(dtParser.getToken(3)),
						(TypeCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 306:  modulePropertyCS ::= property qvtIdentifierCS : typeCS = oclExpressionCS ;
			//
			case 306: {
				
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
			// Rule 307:  modulePropertyCS ::= property qvtIdentifierCS = oclExpressionCS ;
			//
			case 307: {
				
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
			// Rule 308:  mappingRuleListOpt ::= $Empty
			//
			case 308:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 310:  mappingRuleList ::= mappingRuleCS
			//
			case 310: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 311:  mappingRuleList ::= mappingRuleList mappingRuleCS
			//
			case 311: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 312:  mappingRuleList ::= mappingQueryCS
			//
			case 312: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 313:  mappingRuleList ::= mappingRuleList mappingQueryCS
			//
			case 313: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 314:  mappingRuleList ::= mappingRuleList qvtErrorToken
			//
			case 314: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 315:  mappingRuleCS ::= entryDeclarationCS { statementListOpt }
			//
			case 315: {
				
				MappingQueryCS result = createMappingQueryCS(
						(MappingDeclarationCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 316:  mappingRuleCS ::= mapping mappingDeclarationCS mappingGuardOpt { mappingInitOpt mappingBodyOpt mappingEndOpt }
			//
			case 316: {
				
				MappingInitCS mappingInit = (MappingInitCS)dtParser.getSym(5);
				MappingBodyCS mappingBody = (MappingBodyCS)dtParser.getSym(6);
				MappingEndCS mappingEnd = (MappingEndCS)dtParser.getSym(7);
				int bodyLeft = (mappingInit == null ?  getIToken(dtParser.getToken(4)).getEndOffset() : mappingInit.getEndOffset());
				int bodyRight = (mappingEnd == null ?  getIToken(dtParser.getToken(8)).getEndOffset() : mappingEnd.getStartOffset());
				int outBodyRight = (mappingEnd == null ?  getIToken(dtParser.getToken(8)).getStartOffset() : mappingEnd.getStartOffset());
				if (mappingBody != null) {
					bodyLeft = mappingBody.getStartOffset();
					bodyRight = mappingBody.getEndOffset();
				}

				updateMappingBodyPositions(mappingBody, bodyLeft, bodyRight, bodyLeft, outBodyRight);
				CSTNode result = createMappingRuleCS(
						(MappingDeclarationCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(3),
						mappingInit,
						mappingBody,
						mappingEnd
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(8)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 317:  mappingRuleCS ::= mapping mappingDeclarationCS ;
			//
			case 317: {
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)dtParser.getSym(2);
				CSTNode result = createMappingRuleCS(
						mappingDecl,
						null,
						null,
						null,
						null
					);
				mappingDecl.setBlackBox(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 318:  mappingRuleCS ::= mapping mappingDeclarationCS qvtErrorToken
			//
			case 318: {
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)dtParser.getSym(2);
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
			// Rule 319:  mappingRuleCS ::= mapping qvtErrorToken
			//
			case 319: {
				
				MappingDeclarationCS mappingDecl = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createMappingDeclarationCS();
				mappingDecl.setSimpleNameCS(createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "")); //$NON-NLS-1$
				CSTNode result = createMappingRuleCS(
						mappingDecl,
						null,
						null,
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 320:  mappingQueryCS ::= query mappingDeclarationCS { statementListOpt }
			//
			case 320: {
				
				CSTNode result = createMappingQueryCS(
						(MappingDeclarationCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 321:  mappingQueryCS ::= query mappingDeclarationCS ;
			//
			case 321: {
				
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
			// Rule 322:  mappingQueryCS ::= query mappingDeclarationCS qvtErrorToken
			//
			case 322: {
				
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
			// Rule 323:  mappingQueryCS ::= query qvtErrorToken
			//
			case 323: {
				
				CSTNode result = createMappingQueryCS(
						null,
						ourEmptyEList
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 324:  entryDeclarationCS ::= main ( parameterListOpt )
			//
			case 324: {
				
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
			// Rule 325:  entryDeclarationCS ::= main qvtErrorToken
			//
			case 325: {
				
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
			// Rule 326:  mappingDeclarationCS ::= directionKindOpt scopedNameCS ( parameterListOpt ) : typeSpecCS
			//
			case 326: {
				
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
			// Rule 327:  mappingDeclarationCS ::= directionKindOpt scopedNameCS ( parameterListOpt )
			//
			case 327: {
				
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
			// Rule 328:  mappingDeclarationCS ::= directionKindOpt scopedNameCS qvtErrorToken
			//
			case 328: {
				
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
			// Rule 329:  expressionListOpt ::= $Empty
			//
			case 329:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 331:  expressionList ::= oclExpressionCS
			//
			case 331: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 332:  expressionList ::= expressionList ; oclExpressionCS
			//
			case 332: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 335:  expressionList ::= qvtErrorToken
			//
			case 335:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 336:  directionKindOpt ::= $Empty
			//
			case 336:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 338:  directionKindCS ::= in
			//
			case 338: {
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.IN
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 339:  directionKindCS ::= out
			//
			case 339: {
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.OUT
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 340:  directionKindCS ::= inout
			//
			case 340: {
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.INOUT
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 341:  parameterListOpt ::= $Empty
			//
			case 341:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 343:  parameterList ::= qvtErrorToken
			//
			case 343: {
				
				EList result = new BasicEList();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 344:  parameterList ::= parameterDeclarationCS
			//
			case 344: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 345:  parameterList ::= parameterList , parameterDeclarationCS
			//
			case 345: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 346:  parameterList ::= parameterList qvtErrorToken
			//
			case 346: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 347:  parameterDeclarationCS ::= directionKindOpt IDENTIFIER : typeSpecCS
			//
			case 347: {
				
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
			// Rule 348:  typeSpecCS ::= typeCS
			//
			case 348: {
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)dtParser.getSym(1),
					null
					);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 349:  typeSpecCS ::= typeCS @ IDENTIFIER
			//
			case 349: {
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)dtParser.getSym(1),
					getIToken(dtParser.getToken(3))
					);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 350:  mappingGuardOpt ::= $Empty
			//
			case 350:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 352:  mappingGuardCS ::= when { oclExpressionCS }
			//
			case 352: {
				
				OCLExpressionCS result = (OCLExpressionCS)dtParser.getSym(3);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 353:  mappingGuardCS ::= when { oclExpressionCS } qvtErrorToken
			//
			case 353: {
				
				OCLExpressionCS result = (OCLExpressionCS)dtParser.getSym(3);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 354:  mappingGuardCS ::= when qvtErrorToken
			//
			case 354: {
				
				dtParser.setSym1(null);
	  		  break;
			}
	 
			//
			// Rule 355:  mappingInitOpt ::= $Empty
			//
			case 355:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 357:  mappingInitCS ::= init { statementListOpt }
			//
			case 357: {
				
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
			// Rule 358:  mappingInitCS ::= init qvtErrorToken
			//
			case 358: {
				
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
			// Rule 359:  mappingEndOpt ::= $Empty
			//
			case 359:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 361:  mappingEndCS ::= end { statementListOpt }
			//
			case 361: {
				
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
			// Rule 362:  mappingEndCS ::= end qvtErrorToken
			//
			case 362: {
				
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
			// Rule 363:  statementListOpt ::= $Empty
			//
			case 363:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 365:  statementList ::= qvtErrorToken
			//
			case 365: {
				
				EList result = new BasicEList();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 368:  statementInnerList ::= statementCS
			//
			case 368: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 369:  statementInnerList ::= statementInnerList ; statementCS
			//
			case 369: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 370:  statementInnerList ::= statementInnerList qvtErrorToken
			//
			case 370: {
				
				EList result = (EList)dtParser.getSym(1);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 373:  statementCS ::= oclExpressionCS
			//
			case 373: {
				
				CSTNode result = createExpressionStatementCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 374:  statementCS ::= primaryOCLExpressionCS
			//
			case 374: {
				
				CSTNode result = createExpressionStatementCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 376:  variableInitializationCSCorrect ::= var IDENTIFIER : typeCS := oclExpressionCS
			//
			case 376: {
				
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
			// Rule 377:  variableInitializationCS ::= var IDENTIFIER : typeCS := qvtErrorToken
			//
			case 377: {
				
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
			// Rule 378:  variableInitializationCSCorrect ::= var IDENTIFIER := oclExpressionCS
			//
			case 378: {
				
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
			// Rule 379:  variableInitializationCS ::= var IDENTIFIER := qvtErrorToken
			//
			case 379: {
				
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
			// Rule 380:  variableInitializationCS ::= var IDENTIFIER : typeCS
			//
			case 380: {
				
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
			// Rule 381:  variableInitializationCS ::= var IDENTIFIER : qvtErrorToken
			//
			case 381: {
				
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
			// Rule 382:  variableInitializationCS ::= var IDENTIFIER
			//
			case 382: {
				
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
			// Rule 383:  variableInitializationCS ::= var qvtErrorToken
			//
			case 383: {
				
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
			// Rule 384:  assignStatementCS ::= oclExpressionCS := oclExpressionCS
			//
			case 384: {
				
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
			// Rule 385:  assignStatementCS ::= oclExpressionCS := qvtErrorToken
			//
			case 385: {
				
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
			// Rule 386:  assignStatementCS ::= oclExpressionCS += oclExpressionCS
			//
			case 386: {
				
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
			// Rule 387:  assignStatementCS ::= oclExpressionCS += qvtErrorToken
			//
			case 387: {
				
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
			// Rule 388:  mappingBodyOpt ::= outExpCS
			//
			case 388: {
				
				MappingBodyCS result = createMappingBodyCS(
						(OutExpCS)dtParser.getSym(1),
						false
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 389:  mappingBodyOpt ::= patternPropertyOrAdditionList
			//
			case 389: {
				
				EList props = (EList)dtParser.getSym(1);
				OutExpCS outExp = createOutExpCS(props, null, getIToken(dtParser.getToken(1)).getStartOffset(), getIToken(dtParser.getToken(1)).getEndOffset());
				if (!props.isEmpty()) {
					CSTNode head = (CSTNode) props.get(0);
					CSTNode tail = (CSTNode) props.get(props.size()-1);
					setOffsets(outExp, head, tail);
				}
				MappingBodyCS result = createMappingBodyCS(
						outExp,
						true
					);
				setOffsets(result, outExp);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 390:  patternPropertyOrAdditionList ::= $Empty
			//
			case 390:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 393:  patternPropertyOrAdditionInnerList ::= patternPropertyOrAddition2
			//
			case 393: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 394:  patternPropertyOrAdditionInnerList ::= patternPropertyOrAdditionList ; patternPropertyOrAddition2
			//
			case 394: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 396:  patternPropertyOrAddition2 ::= qvtErrorToken patternPropertyOrAddition
			//
			case 396: {
				
				dtParser.setSym1(dtParser.getSym(2));
	  		  break;
			}
	 
			//
			// Rule 397:  patternPropertyOrAddition ::= IDENTIFIER := oclExpressionCS
			//
			case 397: {
				
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
			// Rule 398:  patternPropertyOrAddition ::= IDENTIFIER := qvtErrorToken
			//
			case 398: {
				
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
			// Rule 399:  patternPropertyOrAddition ::= IDENTIFIER += oclExpressionCS
			//
			case 399: {
				
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
			// Rule 400:  patternPropertyOrAddition ::= IDENTIFIER += qvtErrorToken
			//
			case 400: {
				
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
			// Rule 401:  patternPropertyOrAddition ::= IDENTIFIER qvtErrorToken
			//
			case 401: {
				
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
			// Rule 402:  typeSpecCSOpt ::= $Empty
			//
			case 402:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 404:  outExpCS ::= object typeSpecCSOpt { patternPropertyOrAdditionList }
			//
			case 404: {
				
				CSTNode result = createOutExpCS(
						(EList)dtParser.getSym(4),
						(TypeSpecCS)dtParser.getSym(2),
						getIToken(dtParser.getToken(3)).getEndOffset(),
						getIToken(dtParser.getToken(5)).getStartOffset()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 405:  outExpCS ::= object typeSpecCSOpt { patternPropertyOrAdditionList qvtErrorToken
			//
			case 405: {
				
				EList<CSTNode> patternPropertyOrAdditionList = (EList<CSTNode>)dtParser.getSym(4);
				CSTNode result = createErrorOutExpCS(
						(EList)dtParser.getSym(4),
						(TypeSpecCS)dtParser.getSym(2),
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
			// Rule 406:  outExpCS ::= object typeSpecCSOpt qvtErrorToken
			//
			case 406: {
				
	                        TypeSpecCS typeSpecCS = (TypeSpecCS)dtParser.getSym(2);  
				CSTNode result = createErrorOutExpCS(
						ourEmptyEList,
						typeSpecCS,
						getIToken(dtParser.getToken(1)).getEndOffset(),
						getIToken(dtParser.getToken(1)).getStartOffset(),
						getIToken(dtParser.getToken(1)).getStartOffset(),
						getIToken(dtParser.getToken(3)).getStartOffset()
					);
				if (typeSpecCS  == null) {
				    setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				} else {
				    setOffsets(result, getIToken(dtParser.getToken(1)), typeSpecCS);
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 407:  featureMappingCallExpCS ::= map simpleNameCS ( argumentsCSopt )
			//
			case 407: {
				
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
			// Rule 408:  featureMappingCallExpCS ::= xmap simpleNameCS ( argumentsCSopt )
			//
			case 408: {
				
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
			// Rule 409:  mappingCallExpCS ::= map pathNameCS ( argumentsCSopt )
			//
			case 409: {
				
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
			// Rule 410:  mappingCallExpCS ::= xmap pathNameCS ( argumentsCSopt )
			//
			case 410: {
				
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
			// Rule 411:  resolveConditionOpt ::= $Empty
			//
			case 411:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 412:  resolveConditionOpt ::= | oclExpressionCS
			//
			case 412: {
				
                dtParser.setSym1((OCLExpressionCS)dtParser.getSym(2));
      		  break;
			}
     
			//
			// Rule 413:  resolveConditionOpt ::= | qvtErrorToken
			//
			case 413:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 414:  IDENTIFIEROpt ::= $Empty
			//
			case 414:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 415:  IDENTIFIEROpt ::= IDENTIFIER :
			//
			case 415: {
				
                dtParser.setSym1(getIToken(dtParser.getToken(1)));
      		  break;
			}
     
			//
			// Rule 416:  resolveOpArgsExpCS ::= $Empty
			//
			case 416:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 417:  resolveOpArgsExpCS ::= IDENTIFIEROpt typeCS resolveConditionOpt
			//
			case 417: {
				
                CSTNode result = createResolveOpArgsExpCS(
                        getIToken(dtParser.getToken(1)),      // target_type_variable?
                        (TypeCS)dtParser.getSym(2),           // type?
                        (OCLExpressionCS)dtParser.getSym(3)); // condition?
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 422:  lateOpt ::= $Empty
			//
			case 422:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 424:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCS )
			//
			case 424: {
				
                CSTNode result = createResolveExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        (ResolveOpArgsExpCS)dtParser.getSym(4));
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 425:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCS qvtErrorToken
			//
			case 425: {
				
                CSTNode result = createResolveExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        (ResolveOpArgsExpCS)dtParser.getSym(4));
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 426:  resolveExpCS ::= lateOpt resolveOp qvtErrorToken
			//
			case 426: {
				
                CSTNode result = createResolveExpCS(
                        getIToken(dtParser.getToken(1)),
                        getIToken(dtParser.getToken(2)),
                        null);
                        setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
                dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 427:  resolveExpCS ::= late qvtErrorToken
			//
			case 427: {
				
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
			// Rule 432:  resolveInExpCS ::= lateOpt resolveInOp ( scopedNameCS , resolveOpArgsExpCS )
			//
			case 432: {
				
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
			// Rule 433:  resolveInExpCS ::= lateOpt resolveInOp ( scopedNameCS , resolveOpArgsExpCS qvtErrorToken
			//
			case 433: {
				
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
			// Rule 434:  resolveInExpCS ::= lateOpt resolveInOp ( scopedNameCS qvtErrorToken
			//
			case 434: {
				
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
			// Rule 435:  resolveInExpCS ::= lateOpt resolveInOp ( qvtErrorToken
			//
			case 435: {
				
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
			// Rule 436:  resolveInExpCS ::= lateOpt resolveInOp qvtErrorToken
			//
			case 436: {
				
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
			// Rule 439:  callExpCS ::= . resolveResolveInExpCS
			//
			case 439: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 441:  whileExpCS ::= while ( oclExpressionCS ; oclExpressionCS ) { statementListOpt }
			//
			case 441: {
				
				CSTNode result = createWhileExpCS(
						(OCLExpressionCS)dtParser.getSym(3),
						(OCLExpressionCS)dtParser.getSym(5),
						(EList)dtParser.getSym(8)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(9)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 447:  letExpSubCS3 ::= variableCS2
			//
			case 447: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 448:  letExpSubCS3 ::= letExpSubCS3 , variableCS2
			//
			case 448: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 449:  letExpCS ::= let letExpSubCS3 in oclExpressionCS
			//
			case 449: {
				
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
			// Rule 450:  letExpCS ::= let letExpSubCS3 in qvtErrorToken
			//
			case 450: {
				
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
			// Rule 451:  simpleNameCS ::= this
			//
			case 451:
 
			//
			// Rule 452:  simpleNameCS ::= result
			//
			case 452: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 453:  modelTypeExpCS ::= modeltype IDENTIFIER complianceKindCSOpt uses packageRefList modelTypeWhereCSOpt ;
			//
			case 453: {
				
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
			// Rule 454:  modelTypeExpCS ::= modeltype qvtErrorToken
			//
			case 454: {
				
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
			// Rule 455:  complianceKindCSOpt ::= $Empty
			//
			case 455: {
				
				CSTNode result = createStringLiteralExpCS("''");
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 457:  packageRefList ::= packageRefCS
			//
			case 457: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 458:  packageRefList ::= packageRefList , packageRefCS
			//
			case 458: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 459:  packageRefCS ::= pathNameCS
			//
			case 459: {
				
				CSTNode result = createPackageRefCS(
						(PathNameCS)dtParser.getSym(1),
						null
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 460:  packageRefCS ::= pathNameCS ( qvtStringLiteralExpCS )
			//
			case 460: {
				
				CSTNode result = createPackageRefCS(
						(PathNameCS)dtParser.getSym(1),
						(StringLiteralExpCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 461:  packageRefCS ::= qvtStringLiteralExpCS
			//
			case 461: {
				
				CSTNode result = createPackageRefCS(
						null,
						(StringLiteralExpCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 463:  qvtStringLiteralExpCS ::= QUOTE_STRING_LITERAL
			//
			case 463: {
				
				CSTNode result = createStringLiteralExpCS("'" + unquote(getTokenText(dtParser.getToken(1))) + "'"); //$NON-NLS-1$ //$NON-NLS-2$
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 464:  modelTypeWhereCSOpt ::= $Empty
			//
			case 464:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 465:  modelTypeWhereCSOpt ::= where { statementListOpt }
			//
			case 465: {
				
				EList result = (EList)dtParser.getSym(3);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 468:  qvtErrorToken ::= ERROR_TOKEN
			//
			case 468: {
				
				diagnozeErrorToken(dtParser.getToken(1));
	  		  break;
			}
	 
			//
			// Rule 469:  iterContents ::= variableCS | qvtErrorToken
			//
			case 469: {
				
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
			// Rule 470:  callExpCS ::= . qvtErrorToken
			//
			case 470: {
				
				CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
	 			result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 471:  callExpCS ::= -> qvtErrorToken
			//
			case 471: {
				
				CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
	 			result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 472:  argumentsCS ::= qvtErrorToken
			//
			case 472:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 475:  ifExpBodyCS ::= { statementListOpt }
			//
			case 475: {
				
				EList bodyList = (EList) dtParser.getSym(2);
				CSTNode result = createBlockExpCS(
						bodyList
					);
				if (bodyList.isEmpty()) {
					setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				}
				else {
					setOffsets(result, (CSTNode) bodyList.get(0), (CSTNode) bodyList.get(bodyList.size()-1));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 476:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS else ifExpBodyCS endif
			//
			case 476: {
				
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
			// Rule 477:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS endif
			//
			case 477: {
				
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
			// Rule 478:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS else ifExpBodyCS qvtErrorToken
			//
			case 478: {
				
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
			// Rule 479:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS else qvtErrorToken
			//
			case 479: {
				
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
			// Rule 480:  ifExpCS ::= if oclExpressionCS then ifExpBodyCS qvtErrorToken
			//
			case 480: {
				
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
			// Rule 481:  ifExpCS ::= if oclExpressionCS then qvtErrorToken
			//
			case 481: {
				
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
			// Rule 482:  ifExpCS ::= if oclExpressionCS qvtErrorToken
			//
			case 482: {
				
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
			// Rule 483:  ifExpCS ::= if qvtErrorToken
			//
			case 483: {
				
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
			// Rule 485:  switchExpCS ::= switch switchBodyExpCS
			//
			case 485: {
				
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
			// Rule 486:  switchExpCS ::= switch qvtErrorToken
			//
			case 486: {
				
				CSTNode result = createSwitchExpCS(
						new BasicEList(),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 487:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt }
			//
			case 487: {
				
				Object[] result = new Object[] {dtParser.getSym(2), dtParser.getSym(3), getIToken(dtParser.getToken(4))};
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 488:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt qvtErrorToken
			//
			case 488: {
				
				Object[] result = new Object[] {dtParser.getSym(2), dtParser.getSym(3), dtParser.getSym(3)};
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 489:  switchBodyExpCS ::= { qvtErrorToken
			//
			case 489: {
				
				Object[] result = new Object[] {new BasicEList(), null, getIToken(dtParser.getToken(1))};
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 490:  switchAltExpCSList ::= switchAltExpCS
			//
			case 490: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 491:  switchAltExpCSList ::= switchAltExpCSList switchAltExpCS
			//
			case 491: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 492:  switchAltExpCS ::= ( oclExpressionCS ) ? statementCS ;
			//
			case 492: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(2),
						(OCLExpressionCS) dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 493:  switchAltExpCS ::= ( oclExpressionCS ) ? statementCS qvtErrorToken
			//
			case 493: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(2),
						(OCLExpressionCS) dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode) dtParser.getSym(5));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 494:  switchAltExpCS ::= ( oclExpressionCS ) qvtErrorToken
			//
			case 494: {
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) dtParser.getSym(2),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 495:  switchAltExpCS ::= ( qvtErrorToken
			//
			case 495: {
				
				CSTNode result = createSwitchAltExpCS(
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 496:  switchElseExpCSOpt ::= $Empty
			//
			case 496:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 498:  switchElseExpCS ::= else ? statementCS ;
			//
			case 498: {
				
				dtParser.setSym1((CSTNode)dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 499:  switchElseExpCS ::= else ? statementCS qvtErrorToken
			//
			case 499: {
				
				dtParser.setSym1((CSTNode)dtParser.getSym(3));
	  		  break;
			}
	 
			//
			// Rule 500:  switchElseExpCS ::= else qvtErrorToken
			//
			case 500: {
				
				dtParser.setSym1(null);
	  		  break;
			}
	 
			//
			// Rule 512:  iteratorExpCS ::= iteratorExpCSToken ( iterContents )
			//
			case 512: {
				
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
			// Rule 513:  iteratorExpCS ::= iteratorExpCSToken ( iterContents qvtErrorToken
			//
			case 513: {
				
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
				if ((iterContents != null) || (iterContents.length == 0)) {
				        for (int i = iterContents.length - 1; i >= 0; i--) {
				        	if (iterContents[i] instanceof CSTNode) {
				        		setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode) iterContents[i]);
				        		break;
				        	}
				        }
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 514:  iteratorExpCS ::= iteratorExpCSToken ( qvtErrorToken
			//
			case 514: {
				
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
			// Rule 515:  operationCallExpCS ::= oclAsType isMarkedPreCS ( typeCS )
			//
			case 515:
 
			//
			// Rule 516:  operationCallExpCS ::= oclIsKindOf isMarkedPreCS ( typeCS )
			//
			case 516:
 
			//
			// Rule 517:  operationCallExpCS ::= oclIsTypeOf isMarkedPreCS ( typeCS )
			//
			case 517: {
				
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
			// Rule 519:  logWhenExp ::= when oclExpressionCS
			//
			case 519: {
				
			OCLExpressionCS condition = (OCLExpressionCS) dtParser.getSym(2);
			dtParser.setSym1(condition);
      		  break;
			}
     
			//
			// Rule 521:  logWhenExpOpt ::= $Empty
			//
			case 521:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 522:  logExpCS ::= log ( argumentsCSopt ) logWhenExpOpt
			//
			case 522: {
				
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
			// Rule 524:  severityKindCS ::= simpleNameCS
			//
			case 524: {
				
			dtParser.setSym1(dtParser.getSym(1));
	  		  break;
			}
	 
			//
			// Rule 526:  severityKindCSOpt ::= $Empty
			//
			case 526:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 527:  assertWithLogExp ::= with logExpCS
			//
			case 527: {
				
			LogExpCS logExp = (LogExpCS) dtParser.getSym(2);
			setOffsets(logExp, getIToken(dtParser.getToken(2)), logExp);
			dtParser.setSym1(logExp);
      		  break;
			}
     
			//
			// Rule 529:  assertWithLogExpOpt ::= $Empty
			//
			case 529:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 530:  assertExpCS ::= assert severityKindCSOpt ( oclExpressionCS ) assertWithLogExpOpt
			//
			case 530: {
				
			LogExpCS logExpCS = (LogExpCS)dtParser.getSym(6);
			OCLExpressionCS condition = (OCLExpressionCS)dtParser.getSym(4);
			AssertExpCS result = (AssertExpCS)createAssertExpCS(condition, (SimpleNameCS)dtParser.getSym(2), logExpCS);
	
			CSTNode end = logExpCS != null ? logExpCS : condition; 
			setOffsets(result, getIToken(dtParser.getToken(1)), end);
			dtParser.setSym1(result);
      		  break;
			}
     
			//
			// Rule 533:  mappingRuleCS ::= entryDeclarationCS ;
			//
			case 533: {
				
				MappingQueryCS result = createMappingQueryCS(
						(MappingDeclarationCS)dtParser.getSym(1),
						ourEmptyEList
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	
	
			default:
				break;
		}
		return;
	}
}

