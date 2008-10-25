--/**
-- * <copyright>
-- *
-- * Copyright (c) 2006-2008 Borland Inc.
-- * All rights reserved.   This program and the accompanying materials
-- * are made available under the terms of the Eclipse Public License v1.0
-- * which accompanies this distribution, and is available at
-- * http://www.eclipse.org/legal/epl-v10.html
-- *
-- * Contributors:
-- *   Borland - Initial API and implementation
-- *
-- * </copyright>
-- *
-- * $Id: ImperativeOCL.g,v 1.5 2008/10/25 10:07:05 aigdalov Exp $ 
-- */
--
-- The QVT Operational Parser
--
$Import
	EssentialOCL.g

$DropRules
		
	operationCS -> operationCS1
	operationCS -> operationCS2
	operationCS1 ::= IDENTIFIER '(' parametersCSopt ')' ':' typeCSopt
	operationCS2 ::= pathNameCS '::' simpleNameCS '(' parametersCSopt ')' ':' typeCSopt

	parametersCSopt ::= $empty
	parametersCSopt -> parametersCS
	parametersCS ::= variableCS
	parametersCS ::= parametersCS ',' variableCS

	-- 'if' extension in QVT
	ifExpCSPrec -> ifExpCS
	ifExpCS ::= if oclExpressionCS then oclExpressionCS else oclExpressionCS endif

	-- error in OCLLPGParser.g in definition of type-argued calls
	operationCallExpCS ::= oclAsType isMarkedPreCS '(' argumentsCSopt ')'
	operationCallExpCS ::= oclIsKindOf isMarkedPreCS '(' argumentsCSopt ')'
	operationCallExpCS ::= oclIsTypeOf isMarkedPreCS '(' argumentsCSopt ')'

	iteratorExpCS ::= forAll '(' iterContents ')'
	iteratorExpCS ::= exists '(' iterContents ')'
	iteratorExpCS ::= isUnique '(' iterContents ')'
	iteratorExpCS ::= one '(' iterContents ')'
	iteratorExpCS ::= any '(' iterContents ')'
	iteratorExpCS ::= collect '(' iterContents ')'
	iteratorExpCS ::= select '(' iterContents ')'
	iteratorExpCS ::= reject '(' iterContents ')'
	iteratorExpCS ::= collectNested '(' iterContents ')'
	iteratorExpCS ::= sortedBy '(' iterContents ')'
	iteratorExpCS ::= closure '(' iterContents ')'

	-- Dropped due to 13.2 (OCL spec) and 6.4 (QVT spec). This rule conflicts with imperative iterator shorthands
	attrOrNavCallExpCS ::= simpleNameCS '[' argumentsCS ']' isMarkedPreCS
	variableExpCS ::= simpleNameCS '[' argumentsCS ']' isMarkedPreCS
	variableExpCS ::= keywordAsIdentifier1 '[' argumentsCS ']' isMarkedPreCS

$DropSymbols
	
	operationCS
	operationCS1
	operationCS2
	
	parametersCS
	simpleNameCSopt
	typeCSopt
$End

$Define
	$prs_stream_class /.AbstractQVTParser./
	$lex_stream_class /.QvtOpLexer./

	-- Definition of macros used in the parser template
	--
	$EMPTY_ELIST /.ourEmptyEList./

	$DebugModeOn /.private static final boolean DEBUG = true;
			static {
				if (DEBUG) {
					ruleTexts = Collections.synchronizedMap(new HashMap<Integer, String>());
					try {
						InputStream inputStream = FileLocator.openStream(QvtPlugin.getDefault().getBundle(),
										new Path("cst/QvtOpLPGParser.l"), false); //$NON-NLS-1$
						BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
						String line;
						while ((line = reader.readLine()) != null) {
							if ("Rules:".equals(line)) {
								reader.readLine();
								break;
							}
						}
						while ((line = reader.readLine()) != null) {
							if (line.trim().length() == 0) {
								break;
							}
							int wsIndex = line.indexOf(' ');
							String ruleNumberText = line.substring(0, wsIndex);
							Integer ruleNumber = new Integer(ruleNumberText);
							String ruleText = line.substring(wsIndex).trim();
							ruleTexts.put(ruleNumber, ruleText);
						}
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			}

	./
	$DebugModeOff /.private static final boolean DEBUG = false;./

	$BeginActions    
	/.
		@SuppressWarnings("unchecked")	
        public void ruleAction(int ruleNumber)
        {
            if (DEBUG) {
               System.out.println("RULE[" + ruleNumber + "]:   " + ruleTexts.get(ruleNumber)); //$NON-NLS-1$
            }
            switch(ruleNumber)
            {./


	-- copied from OCLLPGParser.g
	--
	-- modified to include throwing exceptions
	$parserCore
	/.
		public class $action_class extends $prs_stream_class implements RuleAction$additional_interfaces {
		protected static ParseTable prs = new $prs_type();
		private BacktrackingParser dtParser;
		private static Map<Integer, String> ruleTexts;

		public $action_class($lex_stream_class lexer) {
			super(lexer);

			try {
				super.remapTerminalSymbols(orderedTerminalSymbols(), $prs_type.EOFT_SYMBOL);
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
					error += "\t" + $sym_type.orderedTerminalSymbols[id.intValue()];			   
				}
				throw new RuntimeException(error + "\n");						
			}
			catch(UndefinedEofSymbolException e) {
				throw new RuntimeException("The Lexer does not implement the Eof symbol " +
					 $sym_type.orderedTerminalSymbols[$prs_type.EOFT_SYMBOL]);
			} 
		}
		 
 		@Override
		public String[] orderedTerminalSymbols() { return $sym_type.orderedTerminalSymbols; }
		@Override		
		public String getTokenKindName(int kind) { return $sym_type.orderedTerminalSymbols[kind]; }			
		public int getEOFTokenKind() { return $prs_type.EOFT_SYMBOL; }
		public PrsStream getParseStream() { return this; }

		protected $ast_type parser() throws ParserException {
			return parseTokensToCST(null, 0);
		}
			
		protected $ast_type parser(Monitor monitor) throws ParserException {
			return parseTokensToCST(monitor, 0);
		}
			
		protected $ast_type parser(int error_repair_count) throws ParserException {
			return parseTokensToCST(null, error_repair_count);
		}
			
		@SuppressWarnings("nls")
		@Override
		public $ast_type parseTokensToCST(Monitor monitor, int error_repair_count) {
			ParseTable prsTable = new $prs_type();

			try {
				dtParser = new BacktrackingParser(monitor, this, prsTable, this);
			}
			catch (NotBacktrackParseTableException e) {
				throw new RuntimeException("****Error: Regenerate $prs_type.java with -NOBACKTRACK option");
			}
			catch (BadParseSymFileException e) {
				throw new RuntimeException("****Error: Bad Parser Symbol File -- $sym_type.java. Regenerate $prs_type.java");
			}

			try {
			    workaroundEOFErrors();
				return ($ast_type) dtParser.parse(error_repair_count);
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
	./
$End

$Globals
	/.	
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
	./
$End

$Terminals

	QUOTE_STRING_LITERAL
	ADD_ASSIGN    ::= '+='
	RESET_ASSIGN  ::= ':='
	AT_SIGN       ::= '@'
	EXCLAMATION_MARK ::= '!'
	NOT_EQUAL_EXEQ   ::= '!='
	INTEGER_RANGE_START
	
$End

$KeyWords
	end
	while
	when
	var
	log
	assert
	with
	switch
	case	
	xselect         
	xcollect        
	selectOne       
	collectOne      
	collectselect   
	collectselectOne
	return
	forEach
	forOne
	compute
	new
$End

$Notice
	/./**
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
 * $Id: ImperativeOCL.g,v 1.5 2008/10/25 10:07:05 aigdalov Exp $
 */
	./
$End

$Headers
	/.
		/**
		 * 
		 * QVT Operational specific part
		 *
		 */
		$DebugModeOff
		
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
			$setResult(null);
		}
	./
$End

$Rules

	-- opt = optional
	-- m = multiple


	
	-- common part: declarators, etc.

	declarator ::= IDENTIFIER ':' typeCS
		/.$BeginJava
					CSTNode result = createVariableCS(
							getTokenText($getToken(1)),
							(TypeCS)$getSym(3),
							null
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./
	declarator ::= IDENTIFIER ':' typeCS '=' oclExpressionCS
		/.$BeginJava
					CSTNode result = createVariableCS(
							getTokenText($getToken(1)),
							(TypeCS)$getSym(3),
							(OCLExpressionCS)$getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(5));
					$setResult(result);
		  $EndJava
		./

	declarator ::= IDENTIFIER ':' typeCS ':=' oclExpressionCS
		/.$BeginJava
					CSTNode result = createVariableCS(
							getTokenText($getToken(1)),
							(TypeCS)$getSym(3),
							(OCLExpressionCS)$getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(5));
					$setResult(result);
		  $EndJava
		./
		
	declarator ::= IDENTIFIER ':=' oclExpressionCS
		/.$BeginJava
					CSTNode result = createVariableCS(
							getTokenText($getToken(1)),
							null,
							(OCLExpressionCS)$getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./

	-- common part end 
	
	statementCS -> returnExpCS 	
	returnExpCS ::= return oclExpressionCSOpt
		/.$BeginJava
				ReturnExpCS returnExpCS = createReturnExpCS((OCLExpressionCS)dtParser.getSym(2));
				CSTNode result = createExpressionStatementCS(returnExpCS);
				if(returnExpCS.getValue() != null) {
					setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(2));			
				} else {
					setOffsets(result, getIToken(dtParser.getToken(1)));
				}
				setOffsets(returnExpCS, result);
				dtParser.setSym1(result);
		  $EndJava
		./
	 
	oclExpressionCSOpt -> oclExpressionCS 
	oclExpressionCSOpt ::= $empty
		/.$NullAction./
		

	statementListOpt ::= $empty
		/.$EmptyListAction./
	statementListOpt -> statementList
	
	statementList ::= qvtErrorToken
		/.$BeginJava
					EList result = new BasicEList();
					$setResult(result);
		  $EndJava
		./
	statementList -> statementInnerList
	statementList -> statementInnerList ';'

	statementInnerList ::= statementCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	statementInnerList ::= statementInnerList ';' statementCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
	statementInnerList ::= statementInnerList qvtErrorToken
		/.$BeginJava
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndJava
		./
		
	statementCS -> assignStatementCS
	statementCS -> variableInitializationCS
	statementCS ::= oclExpressionCS
		/.$BeginJava
					CSTNode result = createExpressionStatementCS(
							(OCLExpressionCS)$getSym(1)
						);
					setOffsets(result, (CSTNode)$getSym(1));
					$setResult(result);
		  $EndJava
		./
		
	statementCS ::= primaryOCLExpressionCS 
		/.$BeginJava
					CSTNode result = createExpressionStatementCS(
							(OCLExpressionCS)$getSym(1)
						);
					setOffsets(result, (CSTNode)$getSym(1));
					$setResult(result);
		  $EndJava
		./
	variableInitializationCS -> variableInitializationCSCorrect

	variableInitializationCSCorrect ::= var IDENTIFIER ':' typeCS ':=' oclExpressionCS
		/.$BeginJava
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(2)),
							(TypeCS)$getSym(4),
							(OCLExpressionCS)$getSym(6)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(6));
					$setResult(result);
		  $EndJava
		./
	variableInitializationCS ::= var IDENTIFIER ':' typeCS ':=' qvtErrorToken
		/.$BeginJava
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(2)),
							(TypeCS)$getSym(4),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	variableInitializationCSCorrect ::= var IDENTIFIER ':=' oclExpressionCS
		/.$BeginJava
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(2)),
							null,
							(OCLExpressionCS)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
					$setResult(result);
		  $EndJava
		./
	variableInitializationCS ::= var IDENTIFIER ':=' qvtErrorToken
		/.$BeginJava
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(2)),
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	variableInitializationCSCorrect ::= var IDENTIFIER ':' typeCS
		/.$BeginJava
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(2)),
							(TypeCS)$getSym(4),
							null
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
					$setResult(result);
		  $EndJava
		./
	variableInitializationCS ::= var IDENTIFIER ':' qvtErrorToken
		/.$BeginJava
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(2)),
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
		
	assignStatementCS ::= oclExpressionCS ':=' oclExpressionCS
		/.$BeginJava
					CSTNode result = createAssignStatementCS(
							(OCLExpressionCS)$getSym(1),
							(OCLExpressionCS)$getSym(3),
							false
						);
					setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./
	assignStatementCS ::= oclExpressionCS ':=' qvtErrorToken
		/.$BeginJava
					CSTNode result = createAssignStatementCS(
							(OCLExpressionCS)$getSym(1),
							createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, ""), //$NON-NLS-1$
							false
						);
					setOffsets(result, (CSTNode)$getSym(1), getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./

	assignStatementCS ::= oclExpressionCS '+=' oclExpressionCS
		/.$BeginJava
					CSTNode result = createAssignStatementCS(
							(OCLExpressionCS)$getSym(1),
							(OCLExpressionCS)$getSym(3),
							true
						);
					setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./
	assignStatementCS ::= oclExpressionCS '+=' qvtErrorToken
		/.$BeginJava
					CSTNode result = createAssignStatementCS(
							(OCLExpressionCS)$getSym(1),
							createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, ""), //$NON-NLS-1$
							true
						);
					setOffsets(result, (CSTNode)$getSym(1), getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./


	whileBodyCS -> expression_block

	legacyWhileExpCS ::= while '(' oclExpressionCS ';' oclExpressionCS ')' whileBodyCS
		/.$BeginJava
					CSTNode result = createLegacyWhileExpCS(
							(OCLExpressionCS)$getSym(3),
							(OCLExpressionCS)$getSym(5),
							(BlockExpCS)$getSym(7)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(7));
					$setResult(result);
		  $EndJava
		./

		
	whileExpCS ::= while '(' declarator ';' oclExpressionCS ')' whileBodyCS
		/.$BeginJava
					CSTNode result = createWhileExpCS(
							(VariableCS)$getSym(3),
							(OCLExpressionCS)$getSym(5),
							(BlockExpCS)$getSym(7)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(7));
					$setResult(result);
		  $EndJava
		./

	whileExpCS ::= while '(' oclExpressionCS ')' whileBodyCS
		/.$BeginJava
					CSTNode result = createWhileExpCS(
							null,
							(OCLExpressionCS)$getSym(3),
							(BlockExpCS)$getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(5));
					$setResult(result);
		  $EndJava
		./
	
	-- ForExp begin

	loopExpCS -> forExpCS

	forOpCode -> forEach
	forOpCode -> forOne

	forExpDeclaratorList ::= IDENTIFIER
        	/.$BeginJava
			EList result = new BasicEList();
			result.add(getIToken($getToken(1)));
			$setResult(result);
	          $EndJava
        	./
	forExpDeclaratorList ::= forExpDeclaratorList ',' IDENTIFIER
        	/.$BeginJava
			EList result = (EList)$getSym(1);
			result.add(getIToken($getToken(3)));
			$setResult(result);
	          $EndJava
        	./


	forExpConditionOpt ::= $empty
        	/.$NullAction./
        
	forExpConditionOpt ::= '|' oclExpressionCS
        	/.$BeginJava
                	    $setResult((OCLExpressionCS)$getSym(2));
	          $EndJava
        	./

	forExpConditionOpt ::= '|' qvtErrorToken
        	/.$NullAction./

	forExpCS ::= forOpCode '(' forExpDeclaratorList forExpConditionOpt ')' expression_block
		/.$BeginJava
					CSTNode result = createForExpCS(
							getIToken($getToken(1)),
							(EList)$getSym(3),
							(OCLExpressionCS)$getSym(4),
							(BlockExpCS)$getSym(6)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(6));
					$setResult(result);
		  $EndJava
		./

	forExpCS ::= forOpCode qvtErrorToken
		/.$BeginJava
					CSTNode result = createForExpCS(
							getIToken($getToken(1)),
							null,
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	-- ForExp end

	-- operation call and expression extension in QVT

	oclExpCS -> whileExpCS
	oclExpCS -> legacyWhileExpCS
	
	oclExpCS -> ifExpCS


	-- 'let' extension in QVT
	-- in OCL variable has to define type
	letExpSubCS3 ::= variableCS2
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./

	letExpSubCS3 ::= letExpSubCS3 ',' variableCS2 
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
			
	letExpCS ::= let letExpSubCS3 in oclExpressionCS
		/.$BeginJava
					EList variables = (EList)$getSym(2);
					CSTNode result = createLetExpCS(
							variables,
							(OCLExpressionCS)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
					$setResult(result);
		  $EndJava
		./
	letExpCS ::= let letExpSubCS3 in qvtErrorToken
		/.$BeginJava
					EList variables = (EList)$getSym(2);
					CSTNode result = createLetExpCS(
							variables,
							createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "") //$NON-NLS-1$
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./
		

    complianceKindCSOpt ::= $empty
		/.$BeginJava
					CSTNode result = createStringLiteralExpCS("''");
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
    complianceKindCSOpt -> qvtStringLiteralExpCS
    
	
	qvtStringLiteralExpCS -> stringLiteralExpCS
	qvtStringLiteralExpCS ::= QUOTE_STRING_LITERAL
		/.$BeginJava
					CSTNode result = createStringLiteralExpCS("'" + unquote(getTokenText($getToken(1))) + "'"); //$NON-NLS-1$ //$NON-NLS-2$
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./


	qvtIdentifierCS -> IDENTIFIER
	qvtIdentifierCS -> keywordAsIdentifier1
	-- qvtIdentifierCS -> keywordAsIdentifier2
	
	qvtErrorToken ::= ERROR_TOKEN
		/.$BeginJava
					diagnozeErrorToken($getToken(1));
		  $EndJava
		./

	-- error recovery extensions to OCL grammer
	--
	iterContents ::= variableCS '|' qvtErrorToken
		/.$BeginJava
					CSTNode fakeCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, ""); //$NON-NLS-1$
					setOffsets(fakeCS, getIToken($getToken(3)));
					$setResult(new Object[] {
							$getSym(1),
							null,
							fakeCS
						});
		  $EndJava
		./
	callExpCS ::= '.' qvtErrorToken
		/.$BeginJava
					CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
		 			result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	callExpCS ::= '->' qvtErrorToken
		/.$BeginJava
					CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
		 			result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	argumentsCS ::= qvtErrorToken
		/.$EmptyListAction./	
	argumentsCS -> argumentsCS ',' qvtErrorToken
	
	ifExpBodyCS -> oclExpressionCS
	ifExpBodyCS -> expression_block

	ifExpCS ::= if oclExpressionCS then ifExpBodyCS else ifExpBodyCS endif
		/.$BeginJava
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							(OCLExpressionCS)$getSym(4),
							(OCLExpressionCS)$getSym(6)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
					$setResult(result);
		  $EndJava
		./

	ifExpCS ::= if oclExpressionCS then ifExpBodyCS endif
		/.$BeginJava
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							(OCLExpressionCS)$getSym(4),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./

	ifExpCS ::= if oclExpressionCS then ifExpBodyCS else ifExpBodyCS qvtErrorToken
		/.$BeginJava
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							(OCLExpressionCS)$getSym(4),
							(OCLExpressionCS)$getSym(6)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(6));
					$setResult(result);
		  $EndJava
		./

	ifExpCS ::= if oclExpressionCS then ifExpBodyCS else qvtErrorToken
		/.$BeginJava
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							(OCLExpressionCS)$getSym(4),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./

	ifExpCS ::= if oclExpressionCS then ifExpBodyCS qvtErrorToken
		/.$BeginJava
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							(OCLExpressionCS)$getSym(4),
							null
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
					$setResult(result);
		  $EndJava
		./

	ifExpCS ::= if oclExpressionCS then qvtErrorToken
		/.$BeginJava
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./

	ifExpCS ::= if oclExpressionCS qvtErrorToken
		/.$BeginJava
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(2));
					$setResult(result);
		  $EndJava
		./


	ifExpCS ::= if qvtErrorToken
		/.$BeginJava
					CSTNode result = createIfExpCS(
							null,
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	----- switch -----

	oclExpCS -> switchExpCS
	loopExpCS -> iterateSwitchExpCS

	switchExpCS ::= switch switchBodyExpCS
		/.$BeginJava
					Object[] switchBody = (Object[]) $getSym(2);

					CSTNode result = createSwitchExpCS(
							(EList<SwitchAltExpCS>) switchBody[0],
							(OCLExpressionCS) switchBody[1]
						);
					if (switchBody[2] instanceof IToken) { // In case of correct and incorrect syntax
						setOffsets(result, getIToken($getToken(1)), (IToken) switchBody[2]);
					} else { // In case of errors in switchBody
						setOffsets(result, getIToken($getToken(1)), (CSTNode) switchBody[2]);
					}
					$setResult(result);
		  $EndJava
		./

	switchDeclaratorCS -> declarator

	switchDeclaratorCS ::= IDENTIFIER
		/.$BeginJava
					CSTNode result = createVariableCS(
							getTokenText($getToken(1)),
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	switchDeclaratorCS ::= IDENTIFIER '=' oclExpressionCS
		/.$BeginJava
					CSTNode result = createVariableCS(
							getTokenText($getToken(1)),
							null,
							(OCLExpressionCS)$getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./

	iterateSwitchExpCS ::= switch '(' switchDeclaratorCS ')' switchBodyExpCS
		/.$BeginJava
					Object[] switchBody = (Object[]) $getSym(5);

					OCLExpressionCS switchExpCS = (OCLExpressionCS) createSwitchExpCS(
							(EList<SwitchAltExpCS>) switchBody[0],
							(OCLExpressionCS) switchBody[1]							
						);
					if (switchBody[2] instanceof IToken) { // In case of correct and incorrect syntax
						setOffsets(switchExpCS, getIToken($getToken(1)), (IToken) switchBody[2]);
					} else if (switchBody[2] instanceof CSTNode) { // In case of errors in switchBody
						setOffsets(switchExpCS, getIToken($getToken(1)), (CSTNode) switchBody[2]);
					} else { // In case of errors in switchBody
						setOffsets(switchExpCS, getIToken($getToken(1)), getIToken($getToken(4)));
					}

					EList<VariableCS> iterators = new BasicEList<VariableCS>();
					iterators.add((VariableCS) $getSym(3));
					CSTNode result = createImperativeIterateExpCS(
							createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "xcollect"), //$NON-NLS-1$
							iterators,
							null,
							switchExpCS,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					
					$setResult(result);
		  $EndJava
		./

	switchExpCS ::= switch qvtErrorToken
		/.$BeginJava
					CSTNode result = createSwitchExpCS(
							new BasicEList(),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	switchBodyExpCS ::= '{' switchAltExpCSList switchElseExpCSOpt '}'
		/.$BeginJava
					Object[] result = new Object[] {$getSym(2), $getSym(3), getIToken($getToken(4))};
					$setResult(result);
		  $EndJava
		./

	switchBodyExpCS ::= '{' switchAltExpCSList switchElseExpCSOpt qvtErrorToken
		/.$BeginJava
					Object[] result = new Object[] {$getSym(2), $getSym(3), $getSym(3)};
					$setResult(result);
		  $EndJava
		./

	switchBodyExpCS ::= '{' qvtErrorToken
		/.$BeginJava
					Object[] result = new Object[] {new BasicEList(), null, getIToken($getToken(1))};
					$setResult(result);
		  $EndJava
		./

	switchAltExpCSList ::= switchAltExpCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	switchAltExpCSList ::= switchAltExpCSList switchAltExpCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndJava
		./


	switchAltExpCS ::= '(' oclExpressionCS ')' '?' statementCS ';'
		/.$BeginJava
					CSTNode result = createSwitchAltExpCS(
							(OCLExpressionCS) $getSym(2),
							(OCLExpressionCS) $getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(6)));
					$setResult(result);
		  $EndJava
		./
	
	switchAltExpCS ::= case '(' oclExpressionCS ')' expressionStatementCS
		/.$BeginJava
					CSTNode result = createSwitchAltExpCS(
							(OCLExpressionCS) $getSym(3),
							(OCLExpressionCS) $getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	
	switchAltExpCS ::= '(' oclExpressionCS ')' '?' statementCS qvtErrorToken
		/.$BeginJava
					CSTNode result = createSwitchAltExpCS(
							(OCLExpressionCS) $getSym(2),
							(OCLExpressionCS) $getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode) $getSym(5));
					$setResult(result);
		  $EndJava
		./
	
	switchAltExpCS ::= '(' oclExpressionCS ')' qvtErrorToken
		/.$BeginJava
					CSTNode result = createSwitchAltExpCS(
							(OCLExpressionCS) $getSym(2),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	
	
	switchAltExpCS ::= '(' qvtErrorToken
		/.$BeginJava
					CSTNode result = createSwitchAltExpCS(
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	switchElseExpCSOpt ::= $empty
		/.$NullAction./
	switchElseExpCSOpt -> switchElseExpCS

	switchElseExpCS ::= else '?' statementCS ';'
		/.$BeginJava
					$setResult((CSTNode)$getSym(3));
		  $EndJava
		./

	switchElseExpCS ::= else expressionStatementCS
		/.$BeginJava
					$setResult((CSTNode)$getSym(2));
		  $EndJava
		./

	switchElseExpCS ::= else '?' statementCS qvtErrorToken
		/.$BeginJava
					$setResult((CSTNode)$getSym(3));
		  $EndJava
		./

	switchElseExpCS ::= else qvtErrorToken
		/.$BeginJava
					$setResult(null);
		  $EndJava
		./

	----- switch -----


	iteratorExpCSToken -> forAll
	iteratorExpCSToken -> exists
	iteratorExpCSToken -> isUnique
	iteratorExpCSToken -> one
	iteratorExpCSToken -> any
	iteratorExpCSToken -> collect
	iteratorExpCSToken -> select
	iteratorExpCSToken -> reject
	iteratorExpCSToken -> collectNested
	iteratorExpCSToken -> sortedBy
	iteratorExpCSToken -> closure

	iteratorExpCS ::= iteratorExpCSToken '(' iterContents ')'
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.KEYWORD_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(simpleNameCS, getIToken($getToken(1)));
					Object[] iterContents = (Object[])$getSym(3);
					CSTNode result = createIteratorExpCS(
							simpleNameCS,
							(VariableCS)iterContents[0],
							(VariableCS)iterContents[1],
							(OCLExpressionCS)iterContents[2]
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

	iteratorExpCS ::= iteratorExpCSToken '(' iterContents qvtErrorToken
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.KEYWORD_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(simpleNameCS, getIToken($getToken(1)));
					Object[] iterContents = (Object[])$getSym(3);
					CSTNode result = createIteratorExpCS(
							simpleNameCS,
							(VariableCS)iterContents[0],
							(VariableCS)iterContents[1],
							(OCLExpressionCS)iterContents[2]
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
			        for (int i = iterContents.length - 1; i >= 0; i--) {
			        	if (iterContents[i] instanceof CSTNode) {
			        		setOffsets(result, getIToken($getToken(1)), (CSTNode) iterContents[i]);
			        		break;
			        	}
			        }
					$setResult(result);
		  $EndJava
		./
		
	iteratorExpCS ::= iteratorExpCSToken '(' qvtErrorToken
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.KEYWORD_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(simpleNameCS, getIToken($getToken(1)));
					CSTNode result = createIteratorExpCS(
							simpleNameCS,
							null,
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
		
	-- error in OCLLPGParser.g in definition of type-argued calls
	operationCallExpCS ::= oclAsType isMarkedPreCS '(' typeCS ')'
		/.$NewCase./
	operationCallExpCS ::= oclIsKindOf isMarkedPreCS '(' typeCS ')'
		/.$NewCase./
	operationCallExpCS ::= oclIsTypeOf isMarkedPreCS '(' typeCS ')'
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.IDENTIFIER_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(simpleNameCS, getIToken($getToken(1)));
					EList params = new BasicEList();
					params.add($getSym(4));
					CSTNode result = createOperationCallExpCS(
							simpleNameCS,
							(IsMarkedPreCS)$getSym(2),
							params
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	-- log expression call
	primaryOCLExpressionCS -> logExpCS
	
		
	logWhenExp ::= when oclExpressionCS
        /.$BeginJava
				OCLExpressionCS condition = (OCLExpressionCS) dtParser.getSym(2);
				$setResult(condition);
          $EndJava
        ./	
	
	logWhenExpOpt -> logWhenExp			
	logWhenExpOpt ::= $empty
	/.$NullAction./		
		
	logExpCS ::= log '(' argumentsCSopt ')' logWhenExpOpt
        /.$BeginJava
				OCLExpressionCS condition = (OCLExpressionCS) dtParser.getSym(5);
				LogExpCS result = (LogExpCS)createLogExpCS((EList<OCLExpressionCS>)dtParser.getSym(3), condition);
				if(condition != null) {
					setOffsets(result, getIToken(dtParser.getToken(1)), condition);
				} else {
					setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				}
				$setResult(result);
          $EndJava
        ./

	-- assertion support	
	primaryOCLExpressionCS -> assertExpCS

	severityKindCS ::= simpleNameCS
		/.$BeginJava
				$setResult(dtParser.getSym(1));
		  $EndJava
		./
		
	
	severityKindCSOpt -> severityKindCS
	
	severityKindCSOpt ::= $empty
	/.$NullAction./
	
	assertWithLogExp ::= with logExpCS
        /.$BeginJava
				LogExpCS logExp = (LogExpCS) dtParser.getSym(2);
				setOffsets(logExp, getIToken(dtParser.getToken(2)), logExp);
				$setResult(logExp);
          $EndJava
        ./	
	
	assertWithLogExpOpt -> assertWithLogExp
	assertWithLogExpOpt ::= $empty
	/.$NullAction./
		        
	assertExpCS ::= assert severityKindCSOpt '(' oclExpressionCS ')' assertWithLogExpOpt
        /.$BeginJava
				LogExpCS logExpCS = (LogExpCS)dtParser.getSym(6);
				OCLExpressionCS condition = (OCLExpressionCS)dtParser.getSym(4);
				AssertExpCS result = (AssertExpCS)createAssertExpCS(condition, (SimpleNameCS)dtParser.getSym(2), logExpCS);
		
				CSTNode end = logExpCS != null ? logExpCS : condition; 
				setOffsets(result, getIToken(dtParser.getToken(1)), end);
				$setResult(result);
          $EndJava
        ./

	expression_block ::= '{' statementListOpt '}'
		/.$BeginJava
				EList bodyList = (EList) dtParser.getSym(2);
				CSTNode result = createBlockExpCS(
					bodyList
				);
				
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				$setResult(result);
          $EndJava
		./

	expressionStatementCS -> statementCS ';'
	expressionStatementCS -> expression_block
	expressionStatementCS -> expression_block ';'

	-- ComputeExp start --

	computeExpCS ::= compute '(' declarator ')' expression_block
		/.$BeginJava
					CSTNode result = createComputeExpCS(
						(VariableCS) $getSym(3),
						(OCLExpressionCS) $getSym(5)
					);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./


	oclExpCS -> computeExpCS

	-- ComputeExp end --

	-- imperative iterators

	loopExpCS -> imperativeIterateExpCS

        -- here x12 means full notation in the 1 and 2 forms, x3 - in the 3 form
	-- <source> -> <collector-name> (<body_or_condition>) ;                              (1)
	-- <source> -> <collector-name> (<iterator-list> | <body_or_condition>) ;            (2)
	-- <source> -> <collector-name> (<iterator-list>; <target> = <body> | <condition>) ; (3)

	imperativeIteratorExpCSToken12 -> xselect
	imperativeIteratorExpCSToken12 -> xcollect
	imperativeIteratorExpCSToken12 -> selectOne
	imperativeIteratorExpCSToken12 -> collectOne

	imperativeIteratorExpCSToken3 -> collectselect
	imperativeIteratorExpCSToken3 -> collectselectOne

	imperativeIteratorExpCSToken -> imperativeIteratorExpCSToken12
	imperativeIteratorExpCSToken -> imperativeIteratorExpCSToken3


	imperativeIterateExpCS ::= imperativeIteratorExpCSToken12 '(' imperativeIterContents12 ')'
		/.$NewCase./
	imperativeIterateExpCS ::= imperativeIteratorExpCSToken3 '(' imperativeIterContents3 ')'
		/.$BeginJava
					String opCode = getTokenText($getToken(1));
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.KEYWORD_LITERAL,
								opCode
							);
					setOffsets(simpleNameCS, getIToken($getToken(1)));
					Object[] iterContents = (Object[]) $getSym(3);
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
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

	imperativeIterateExpCS ::= imperativeIteratorExpCSToken qvtErrorToken
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.KEYWORD_LITERAL,
								getTokenText($getToken(1))
							);
					setOffsets(simpleNameCS, getIToken($getToken(1)));
					CSTNode result = createImperativeIterateExpCS(
							simpleNameCS,
							$EMPTY_ELIST,
							null,
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
		

	imperativeIterContents12 ::= oclExpressionCS
		/.$BeginJava
					$setResult(new Object[] {
							$EMPTY_ELIST,
							null,
							$getSym(1)
						});
		  $EndJava
		./
	
	imperativeIterContents12 ::= variableListCS '|' oclExpressionCS
		/.$BeginJava
					$setResult(new Object[] {
							$getSym(1),
							null,
							$getSym(3)
						});
		  $EndJava
		./


	imperativeIterContents3 ::= variableListCS ';' variableCS2 '|' oclExpressionCS
		/.$BeginJava
					$setResult(new Object[] {
							$getSym(1),
							$getSym(3),
							$getSym(5)
						});
		  $EndJava
		./

	-- imperative iterators shorthand notation

	exclamationOpt ::= $empty
	        /.$NullAction./
	exclamationOpt -> '!'

	
	-- collectselect shorthand
	declarator_vsep ::= IDENTIFIER '|'
        	/.$BeginJava
			CSTNode result = createVariableCS(
						getTokenText($getToken(1)),
                                                null,
						null
						);
                        setOffsets(result, getIToken($getToken(1)));
                        $setResult(result);
	          $EndJava
        	./

	declarator_vsepOpt ::= $empty
	        /.$NullAction./
	declarator_vsepOpt -> declarator_vsep

	callExpCS ::= '->' featureCallExpCS exclamationOpt '[' declarator_vsepOpt oclExpressionCS ']'
		/.$BeginJava
		        String opCode = isTokenOfType(getIToken($getToken(3)), QvtOpLPGParsersym.TK_EXCLAMATION_MARK) ?  "collectselectOne" : "collectselect"; //$NON-NLS-1$ //$NON-NLS-2$ 
			SimpleNameCS simpleNameCS = createSimpleNameCS(
					SimpleTypeEnum.KEYWORD_LITERAL,
					opCode
					);
			setOffsets(simpleNameCS, getIToken($getToken(4)), getIToken($getToken(7)));
			VariableCS variableCS = (VariableCS) $getSym(5);
			CSTNode result = createImperativeIterateExpCS(
						simpleNameCS,
						$EMPTY_ELIST,
						variableCS,
						(OCLExpressionCS) $getSym(2),
						(OCLExpressionCS) $getSym(6)
					);
			setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
			$setResult(result);
		  $EndJava
		./

	-- xselect shorthand
	oclExpCS ::= oclExpCS exclamationOpt '[' oclExpressionCS ']'
		/.$BeginJava
				        String opCode = isTokenOfType(getIToken($getToken(2)), QvtOpLPGParsersym.TK_EXCLAMATION_MARK) ?  "selectOne" : "xselect"; //$NON-NLS-1$ //$NON-NLS-2$ 
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.KEYWORD_LITERAL,
								opCode
							);
					setOffsets(simpleNameCS, getIToken($getToken(3)), getIToken($getToken(5)));
					CallExpCS result = createImperativeIterateExpCS(
							simpleNameCS,
							$EMPTY_ELIST,
							null,
							null,
							(OCLExpressionCS) $getSym(4)
						);
					result.setSource((OCLExpressionCS)$getSym(1));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./

	dotArrowExpCS ::= dotArrowExpCS '.' featureCallExpCS exclamationOpt '[' oclExpressionCS ']'
		/.$BeginJava
					CallExpCS callExpCS = (CallExpCS)$getSym(3);
					callExpCS.setSource((OCLExpressionCS)$getSym(1));
					callExpCS.setAccessor(DotOrArrowEnum.DOT_LITERAL);
					setOffsets(callExpCS, (CSTNode)$getSym(1), callExpCS);


				        String opCode = isTokenOfType(getIToken($getToken(4)), QvtOpLPGParsersym.TK_EXCLAMATION_MARK) ?  "selectOne" : "xselect"; //$NON-NLS-1$ //$NON-NLS-2$ 
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.KEYWORD_LITERAL,
								opCode
							);
					setOffsets(simpleNameCS, getIToken($getToken(5)), getIToken($getToken(7)));
					CallExpCS result = createImperativeIterateExpCS(
							simpleNameCS,
							$EMPTY_ELIST,
							null,
							null,
							(OCLExpressionCS) $getSym(6)
						);
					result.setSource(callExpCS);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
					$setResult(result);
		  $EndJava
		./

        -- '!=' - a synonym of '<>'
	equalityExpCS ::= equalityExpCS '!=' relationalExpCS
		/.$NewCase./
	equalityWithLet ::= equalityExpCS '!=' relationalWithLet
		/.$BeginJava
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.STRING_LITERAL,
								OCLStandardLibraryUtil.getOperationName(PredefinedType.NOT_EQUAL)
							);
					setOffsets(simpleNameCS, getIToken($getToken(2)));
					EList args = new BasicEList();
					args.add($getSym(3));
					CSTNode result = createOperationCallExpCS(
							(OCLExpressionCS)$getSym(1),
							simpleNameCS,
							args
						);
					setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./

	oclExpCS -> newExpCS
	newExpCS ::= new pathNameCS '(' argumentsCSopt ')' 
		/.$BeginJava
				OCLExpressionCS result = createNewRuleCallExpCS((PathNameCS)dtParser.getSym(2),(EList)dtParser.getSym(4));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
		  $EndJava
		./	
$End

	