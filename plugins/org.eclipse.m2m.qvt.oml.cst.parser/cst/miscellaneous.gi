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
-- *   See Notice Declaration below
-- *
-- * </copyright>
-- *
-- * $Id: miscellaneous.gi,v 1.6 2010/01/27 17:21:47 sboyko Exp $ 
-- */
--
-- The QVTo Parser
--

%Import
	EssentialOCL.gi

%DropRules
	-- Dropped due to 13.2 (OCL spec) and 6.4 (QVTo spec). These rules conflict with imperative iterator shorthands
	AssociationClassCallExpCS ::= simpleNameCS '[' argumentsCS ']' isMarkedPreCSopt
	AssociationClassCallExpCS ::= primaryExpCS '.' simpleNameCS '[' argumentsCS ']' isMarkedPreCSopt
	PropertyCallExpCS ::= primaryExpCS '.' pathNameCS '[' argumentsCS ']' isMarkedPreCSopt

	-- Error in OCL grammar
	CollectionLiteralExpCS ::= collectionTypeCS '{' CollectionLiteralPartsCSopt '}'

%End

%Define
	-- Definition of macros used in the parser template
	--
	$super_parser_class /.AbstractQVTParser./
	$super_lexer_class /.QVTOLexer./
	$environment_class /.Environment<?,?,?,?,?,?,?,?,?,?,?,?>./

	$EMPTY_ELIST /.ourEmptyEList./

	-- copied from OCLLPGParser.g
	-- modified to include throwing exceptions
	$parserCore
	/.
		public class $action_class extends $prs_stream_class implements RuleAction$additional_interfaces {
		protected static ParseTable prs = new $prs_type();
		private BacktrackingParser dtParser;
		// (to be uncommented for use in DEBUG mode)
		//private static Map<Integer, String> ruleTexts;

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
				if (error_repair_count > 0) {
					return ($ast_type) dtParser.fuzzyParse(error_repair_count);
				}
				else {
					return ($ast_type) dtParser.parse(error_repair_count);
				}
			}
			catch (BadParseException e) {
				OnParseError(e);

				prsStream.reset(e.error_token); // point to error token
				DiagnoseParser diagnoseParser = new DiagnoseParser(prsStream, prsTable);
				diagnoseParser.diagnose(e.error_token);
			}

			return null;
		}

	    private void workaroundEOFErrors() {
    	    IToken lastT = (IToken) getTokens().get((getTokens().size() - 1));
        	int trailingEOFsAmount = 100;
        	int someHugeOffset = 100000;
        	for (int i  = 0; i < trailingEOFsAmount; i++) {
	            makeToken(lastT.getEndOffset() + i + someHugeOffset, lastT.getEndOffset() + i + someHugeOffset + 1, $sym_type.TK_EOF_TOKEN);
        	}
    	}

		protected void OnParseError(BadParseException e) {
			//System.err.println(getFileName());
			//java.util.ArrayList<?> tokens = getTokens();
			//String result = getName(e.error_token) + " ~~ "; 
			//for (int i = Math.max(0, e.error_token-5), n = Math.min(tokens.size(), e.error_token+5); i < n; ++i) {
			//	result += tokens.get(i).toString();
			//	result += " "; 
			//}
			//System.err.println(result);
		}
	./

	----- QVTO Debugging facility (start) -----
	$DebugMode /../

	-- (to be uncommented for use in DEBUG mode)
	--$DebugMode /.private static final boolean DEBUG = true;
	--		static {
	--			if (DEBUG) {
	--				ruleTexts = Collections.synchronizedMap(new HashMap<Integer, String>());
	--				try {
	--					InputStream inputStream = FileLocator.openStream(QvtPlugin.getDefault().getBundle(),
	--									new Path("cst/QVTOParser.l"), false); 
	--					BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	--					String line;
	--					while ((line = reader.readLine()) != null) {
	--						if ("Rules:".equals(line)) {
	--							reader.readLine();
	--							break;
	--						}
	--					}
	--					while ((line = reader.readLine()) != null) {
	--						if (line.trim().length() == 0) {
	--							break;
	--						}
	--						int wsIndex = line.indexOf(' ');
	--						String ruleNumberText = line.substring(0, wsIndex);
	--						Integer ruleNumber = new Integer(ruleNumberText);
	--						String ruleText = line.substring(wsIndex).trim();
	--						ruleTexts.put(ruleNumber, ruleText);
	--					}
	--				} catch (IOException e) {
	--					throw new RuntimeException(e);
	--				}
	--			}
	--		}
	--
	--./
	--
	--$BeginActions    
	--/.
	--	@SuppressWarnings("unchecked")	
        --public void ruleAction(int ruleNumber)
        --{
        --    if (DEBUG) {
        --       System.out.println("RULE[" + ruleNumber + "]:   " + ruleTexts.get(ruleNumber)); 
        --    }
        --    switch(ruleNumber)
        --    {./
	----- QVTO Debugging facility (end) -----

%End

%Globals
	/.	
	./
%End


%Headers
	/.
		/**
		 * 
		 * QVTo specific part
		 *
		 */
		$DebugMode
		
		@SuppressWarnings("unchecked")
		private static final EList ourEmptyEList = new BasicEList.UnmodifiableEList(0, new Object[0]);								
								
		
		private void diagnozeErrorToken(int token_index) {
			//IToken token = getIToken(token_index);
			//if (token instanceof lpg.runtime.ErrorToken) {
			//	token = ((lpg.runtime.ErrorToken) token).getErrorToken();
			//}			
			//reportError(lpg.runtime.ParseErrorCodes.MISPLACED_CODE, token.getTokenIndex(), token.getTokenIndex(),  
			//		"'" + 
			//		token.toString() + "'");

			prsStream.reset(token_index); // point to error token
			DiagnoseParser diagnoseParser = new DiagnoseParser(prsStream, prsTable);
			diagnoseParser.diagnose(token_index);
			setResult(null);
		}
	./
%End

%Rules
	--=== // general purpose grammar rules (start) ===--

	qualifierList ::= %empty
		/.$EmptyListAction./
	qualifierList ::= qualifierList qualifier
		/.$BeginCode
					EList result = (EList) getRhsSym(1);
					result.add(getRhsSym(2));
					setResult(result);
		  $EndCode
		./		
		
	qualifier ::= blackbox
		/.$NewCase./
	qualifier ::= abstract
		/.$NewCase./
	qualifier ::= static
		/.$BeginCode
					CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getRhsIToken(1));
					setOffsets(result, getRhsIToken(1));
					setResult(result);
		  $EndCode
		./

	colon_param_listOpt ::= %empty	 
		/.$EmptyListAction./
	colon_param_listOpt ::= ':' param_list
		/.$BeginCode
					setResult(getRhsSym(2));
		  $EndCode
		./

	complete_signature ::= simple_signature colon_param_listOpt
		/.$BeginCode
					SimpleSignatureCS simpleSignatureCS = (SimpleSignatureCS)getRhsSym(1);
					EList<ParameterDeclarationCS> resultList = (EList<ParameterDeclarationCS>)getRhsSym(2);
					CSTNode result = createCompleteSignatureCS(simpleSignatureCS, resultList);
					result.setStartOffset(simpleSignatureCS.getStartOffset());
					result.setEndOffset(getEndOffset(simpleSignatureCS.getEndOffset(), resultList));
					setResult(result);
		  $EndCode
		./

	simple_signatureOpt ::= %empty
		/.$NullAction./
	simple_signatureOpt -> simple_signature

	simple_signature ::= '(' param_listOpt ')' 
		/.$BeginCode
					CSTNode result = createSimpleSignatureCS((EList<ParameterDeclarationCS>)getRhsSym(2));
					setOffsets(result, getRhsIToken(1), getRhsIToken(3));
					setResult(result);
		  $EndCode
		./

	param_listOpt ::= %empty
		/.$EmptyListAction./
	param_listOpt -> param_list

	param_list ::= param_list ',' param
		/.$BeginCode
					EList result = (EList)getRhsSym(1);
					result.add(getRhsSym(3));
					setResult(result);
		  $EndCode
		./
	param_list ::= param_list ',' qvtErrorToken
		/.$BeginCode
					EList result = (EList)getRhsSym(1);
					setResult(result);
		  $EndCode
		./
	param_list ::= param
		/.$BeginCode
					EList result = new BasicEList();
					result.add(getRhsSym(1));
					setResult(result);
		  $EndCode
		./
	param_list ::= qvtErrorToken
		/.$BeginCode
					EList result = new BasicEList();
					setResult(result);
		  $EndCode
		./

	param ::= param_directionOpt IDENTIFIER ':' typespec
		/.$BeginCode
					DirectionKindCS paramDirectionCS = (DirectionKindCS) getRhsSym(1);
					CSTNode result = createParameterDeclarationCS(
							paramDirectionCS,
							getRhsIToken(2),
							(TypeSpecCS)getRhsSym(4)
						);
					
					result.setStartOffset(paramDirectionCS != null ? paramDirectionCS.getStartOffset() : getRhsIToken(2).getStartOffset());
					result.setEndOffset(((CSTNode)getRhsSym(4)).getEndOffset());
					
					setResult(result);
		  $EndCode
		./
		
	param ::= param_directionOpt typespec
		/.$BeginCode
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
		  $EndCode
		./

	param_directionOpt ::= %empty
		/.$NullAction./
	param_directionOpt -> param_direction
	
	param_direction ::= in
		/.$BeginCode
					CSTNode result = createDirectionKindCS(
							DirectionKindEnum.IN
						);
					setOffsets(result, getRhsIToken(1));
					setResult(result);
		  $EndCode
		./

	param_direction ::= out
		/.$BeginCode
					CSTNode result = createDirectionKindCS(
							DirectionKindEnum.OUT
						);
					setOffsets(result, getRhsIToken(1));
					setResult(result);
		  $EndCode
		./
	
	param_direction ::= inout
		/.$BeginCode
					CSTNode result = createDirectionKindCS(
							DirectionKindEnum.INOUT
						);
					setOffsets(result, getRhsIToken(1));
					setResult(result);
		  $EndCode
		./

	declarator -> declarator1
	declarator -> declarator2

	declarator1 ::= IDENTIFIER ':' typeCS
		/.$BeginCode
					CSTNode result = createVariableCS(
							getRhsIToken(1),
							(TypeCS)getRhsSym(3),
							null
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
					setResult(result);
		  $EndCode
		./
	
	declarator1 ::= IDENTIFIER ':' typeCS '=' OclExpressionCS
		/.$BeginCode
					CSTNode result = createVariableCS(
							getRhsIToken(1),
							(TypeCS)getRhsSym(3),
							(OCLExpressionCS)getRhsSym(5)
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
					setResult(result);
		  $EndCode
		./

	declarator1 ::= IDENTIFIER ':' typeCS ':=' OclExpressionCS
		/.$BeginCode
					CSTNode result = createVariableCS(
							getRhsIToken(1),
							(TypeCS)getRhsSym(3),
							(OCLExpressionCS)getRhsSym(5)
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
					setResult(result);
		  $EndCode
		./
		
	declarator2 ::= IDENTIFIER ':=' OclExpressionCS
		/.$BeginCode
					CSTNode result = createVariableCS(
							getRhsIToken(1),
							null,
							(OCLExpressionCS)getRhsSym(3)
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
					setResult(result);
		  $EndCode
		./

	typespec ::= typeCS
		/.$BeginCode
					CSTNode result = createTypeSpecCS(
						(TypeCS)getRhsSym(1),
						null
						);
					setResult(result);
		  $EndCode
		./
	
	typespec ::= typeCS '@' IDENTIFIER
		/.$BeginCode
					CSTNode result = createTypeSpecCS(
						(TypeCS)getRhsSym(1),
						getRhsIToken(3)
						);
					setResult(result);
		  $EndCode
		./

	typeCS2 -> primitiveTypeCS
	typeCS2 -> tupleTypeCS
	typeCS2 -> collectionTypeCS
	
	scoped_identifier ::= typeCS2 '::' IDENTIFIER
		/.$BeginCode
					ScopedNameCS result = createScopedNameCS((TypeCS)getRhsSym(1), getRhsTokenText(3));		
					setOffsets(result, (CSTNode) getRhsSym(1), getRhsIToken(3));
					setResult(result);
		  $EndCode
		./
	scoped_identifier ::= typeCS2 '::' qvtErrorToken
		/.$BeginCode
					ScopedNameCS result = createScopedNameCS((TypeCS)getRhsSym(1), ""); 		
					setOffsets(result, (CSTNode) getRhsSym(1), getRhsIToken(2));
					setResult(result);
		  $EndCode
		./
	scoped_identifier ::= scoped_identifier2
		/.$BeginCode
					PathNameCS pathNameCS = (PathNameCS)getRhsSym(1);
					String name = pathNameCS.getSimpleNames().remove(pathNameCS.getSimpleNames().size() - 1).getValue();
					TypeCS typeCS = pathNameCS.getSimpleNames().isEmpty() ? null : pathNameCS;

					ScopedNameCS result = createScopedNameCS(typeCS, name);		

					setOffsets(result, pathNameCS);

                                        // reduce the region by the removed name element
					pathNameCS.setEndOffset(pathNameCS.getEndOffset() - (name != null ? name.length() : 0) - 2);
					
					setResult(result);
		  $EndCode
		./
	scoped_identifier2 ::= IDENTIFIER
		/.$BeginCode
					CSTNode result = createPathNameCS(getRhsIToken(1));
					setOffsets(result, getRhsIToken(1));
					setResult(result);
		  $EndCode
		./
	scoped_identifier2 ::= main
		/.$BeginCode
					CSTNode result = createPathNameCS(getRhsIToken(1));
					setOffsets(result, getRhsIToken(1));
					setResult(result);
		  $EndCode
		./
	scoped_identifier2 ::= scoped_identifier2 '::' IDENTIFIER
		/.$BeginCode
					PathNameCS result = (PathNameCS)getRhsSym(1);
					result = extendPathNameCS(result, getRhsIToken(3));
					setOffsets(result, result, getRhsIToken(3));
					setResult(result);
		  $EndCode
		./
	scoped_identifier2 ::= scoped_identifier2 '::' qvtErrorToken
		/.$BeginCode
					PathNameCS result = (PathNameCS)getRhsSym(1);
					result = extendPathNameCS(result, (IToken) null);
					setOffsets(result, result, getRhsIToken(2));
					setResult(result);
		  $EndCode
		./
	scoped_identifier_list ::= scoped_identifier
		/.$BeginCode
					EList result = new BasicEList();
					result.add(getRhsSym(1));
					setResult(result);
		  $EndCode
		./
	scoped_identifier_list ::= scoped_identifier_list ',' scoped_identifier
		/.$BeginCode
					EList result = (EList)getRhsSym(1);
					result.add(getRhsSym(3));
					setResult(result);
		  $EndCode
		./
	scoped_identifier_list ::= scoped_identifier_list qvtErrorToken
		/.$BeginCode
					EList result = (EList)getRhsSym(1);
					setResult(result);
		  $EndCode
		./

	semicolonOpt -> ';'
	semicolonOpt -> %empty

	expression_listOpt ::= %empty
		/.$EmptyListAction./
	expression_listOpt -> expression_list

	expression_list -> expression_semi_list semicolonOpt

	expression_semi_list_element -> OclExpressionCS
	expression_semi_list ::= expression_semi_list_element
		/.$BeginCode
					EList result = new BasicEList();
					Object element = getRhsSym(1);
					if (element instanceof EList) {
						result.addAll((EList) element);
					} else {
						result.add(element);
					}
					setResult(result);
		  $EndCode
		./
	expression_semi_list ::= expression_semi_list ';' expression_semi_list_element 
		/.$BeginCode
					EList result = (EList)getRhsSym(1);
					Object element = getRhsSym(3);
					if (element instanceof EList) {
						result.addAll((EList) element);
					} else {
						result.add(element);
					}
					setResult(result);
		  $EndCode
		./
	expression_semi_list ::= expression_semi_list qvtErrorToken 
		/.$BeginCode
					EList result = (EList)getRhsSym(1);
					setResult(result);
		  $EndCode
		./

	expression_block ::= '{' expression_listOpt '}'
		/.$BeginCode
				EList bodyList = (EList) getRhsSym(2);
				CSTNode result = createBlockExpCS(
					bodyList
				);
				
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	          $EndCode
		./

	expression_block ::= '{' qvtErrorToken
		/.$BeginCode
				CSTNode result = createBlockExpCS(
					$EMPTY_ELIST
				);
				
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	          $EndCode
		./

	expression_statement -> OclExpressionCS ';'
	expression_statement -> expression_block semicolonOpt
	
	qualifiedNameCS ::= qvtIdentifierCS
		/.$BeginCode
					CSTNode result = createPathNameCS(getRhsIToken(1));
					setOffsets(result, getRhsIToken(1));
					setResult(result);
		  $EndCode
		./
	qualifiedNameCS ::= qualifiedNameCS '.' qvtIdentifierCS
		/.$BeginCode
					PathNameCS result = (PathNameCS)getRhsSym(1);
					result = extendPathNameCS(result, getRhsIToken(3));
					setOffsets(result, result, getRhsIToken(3));
					setResult(result);
		  $EndCode
		./
	qualifiedNameCS ::= qualifiedNameCS '.' qvtErrorToken
		/.$BeginCode
					PathNameCS result = (PathNameCS)getRhsSym(1);
					result = extendPathNameCS(result, (IToken) null);
					setOffsets(result, result, getRhsIToken(2));
					setResult(result);
		  $EndCode
		./
	qualifiedNameCS ::= qualifiedNameCS qvtErrorToken
		/.$BeginCode
					PathNameCS result = (PathNameCS)getRhsSym(1);
					setResult(result);
		  $EndCode	
		./	
	--=== // general purpose grammar rules (end) ===--
	
	--=== // Expressions (start) ===--
	oclExpressionCSOpt -> OclExpressionCS 
	oclExpressionCSOpt ::= %empty
		/.$NullAction./

	-- 'let' extension in QVT
	-- in OCL variable has to define type
	letExpSubCS3 ::= untypedInitializedVariableCS
		/.$BeginCode
					EList result = new BasicEList();
					result.add(getRhsSym(1));
					setResult(result);
		  $EndCode
		./

	letExpSubCS3 ::= letExpSubCS3 ',' untypedInitializedVariableCS 
		/.$BeginCode
					EList result = (EList)getRhsSym(1);
					result.add(getRhsSym(3));
					setResult(result);
		  $EndCode
		./
			
	LetExpCS ::= let letExpSubCS3 in OclExpressionCS
		/.$BeginCode
					EList variables = (EList)getRhsSym(2);
					CSTNode result = createLetExpCS(
							variables,
							(OCLExpressionCS)getRhsSym(4)
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(4));
					setResult(result);
		  $EndCode
		./
	LetExpCS ::= let letExpSubCS3 in qvtErrorToken
		/.$BeginCode
					EList variables = (EList)getRhsSym(2);
					CSTNode result = createLetExpCS(
							variables,
							createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, (IToken) null)
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(3));
					setResult(result);
		  $EndCode
		./

	--=== // Expressions (end) ===--
		
	--=== OCL grammar error recovery extensions (start) ===--
	CallExpCS ::= primaryExpCS '.' qvtErrorToken
		/.$BeginCode
					CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
		 			result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
					setOffsets(result, (CSTNode)getRhsSym(1), getRhsIToken(2));
					setResult(result);
		  $EndCode
		./
	CallExpCS ::= primaryExpCS '->' qvtErrorToken
		/.$BeginCode
					CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
		 			result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
					setOffsets(result, (CSTNode)getRhsSym(1), getRhsIToken(2));
					setResult(result);
		  $EndCode
		./
	argumentsCS ::= qvtErrorToken
		/.$EmptyListAction./	
	argumentsCS -> argumentsCS ',' qvtErrorToken


	IteratorExpCS ::= primaryExpCS '->' simpleNameCS '(' qvtErrorToken
		/.$BeginCode
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
		  $EndCode
		./
	--=== OCL grammar error recovery extensions (end) ===--

		
	--=== Miscellaneous QVTO grammar rules (start) ===--
	qvtIdentifierCS -> simpleNameCS
	--qvtIdentifierCS -> CollectionTypeIdentifierCS
	
	qvtErrorToken ::= ERROR_TOKEN
		/.$BeginCode
					diagnozeErrorToken(getRhsTokenIndex(1));
		  $EndCode
		./


        ----- '!=' - a synonym of '<>' -----
	equalityNotNameNotLetCS ::= equalityNotLetCS '!=' relationalNotLetCS
		/.$NewCase./
	equalityWithLetCS ::= equalityNotLetCS '!=' relationalWithLetCS
		/.$BeginCode
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
		  $EndCode
		./

	--=== Miscellaneous QVTO grammar rules (end) ===--	

%End
