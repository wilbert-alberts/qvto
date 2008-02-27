--/**
-- * <copyright>
-- *
-- * Copyright (c) 2006, 2007 Borland Inc.
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
-- * $Id: QvtOpLPGParser.backtrack.g,v 1.42 2008/02/27 14:29:58 sboyko Exp $ 
-- */
--
-- The QVT Operational Parser
--

%options escape=$
%options la=2
%options table=java
%options fp=QvtOpLPGParser,prefix=TK_
%options error-maps
%options scopes
%options margin=4
%options noserialize
%options package=org.eclipse.m2m.qvt.oml.internal.cst.parser
--%options template=dtParserTemplateD.g
%options import_terminals=QvtOpLexer.g
%options ast_type=CSTNode
%options programming_language=java
%options action=("*.java", "/.", "./")
%options ParseTable=lpg.lpgjavaruntime.ParseTable

$Start
    QVTgoal
$End

$Import
	OCLLPGParser.g

$DropRules
		
	operationCS -> operationCS1
	operationCS -> operationCS2
	operationCS1 ::= IDENTIFIER '(' parametersCSopt ')' ':' typeCSopt
	operationCS2 ::= pathNameCS '::' simpleNameCS '(' parametersCSopt ')' ':' typeCSopt

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
										new Path("src/org/eclipse/m2m/qvt/oml/internal/cst/parser/QvtOpLPGParser.l"), false); //$NON-NLS-1$
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
	import lpg.lpgjavaruntime.NotBacktrackParseTableException;
	import org.eclipse.m2m.qvt.oml.internal.cst.AssertExpCS;	
	import org.eclipse.m2m.qvt.oml.internal.cst.LogExpCS;
	import org.eclipse.m2m.qvt.oml.internal.cst.BlockExpCS;	
	import org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindCS;
	import org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindEnum;
	import org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS;
	import org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS;
	import org.eclipse.m2m.qvt.oml.internal.cst.MappingEndCS;
	import org.eclipse.m2m.qvt.oml.internal.cst.MappingInitCS;
	import org.eclipse.m2m.qvt.oml.internal.cst.MappingExtensionCS;	
	import org.eclipse.m2m.qvt.oml.internal.cst.MappingRuleCS;	
	import org.eclipse.m2m.qvt.oml.internal.cst.MappingQueryCS;
	import org.eclipse.m2m.qvt.oml.internal.cst.OutExpCS;
	import org.eclipse.m2m.qvt.oml.internal.cst.ReturnExpCS;	
	import org.eclipse.m2m.qvt.oml.internal.cst.SwitchAltExpCS;
	import org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS;
	import org.eclipse.m2m.qvt.oml.internal.cst.temp.ResolveOpArgsExpCS;
	import org.eclipse.m2m.qvt.oml.internal.cst.temp.ScopedNameCS;
	import org.eclipse.m2m.qvt.oml.internal.cst.temp.TempFactory;
	import org.eclipse.m2m.qvt.oml.internal.cst.ModuleKindEnum;
	import org.eclipse.m2m.qvt.oml.internal.cst.ModuleKindCS;
	import org.eclipse.m2m.qvt.oml.internal.cst.ModuleRefCS;
	import org.eclipse.m2m.qvt.oml.internal.cst.ImportKindEnum;
	import org.eclipse.m2m.qvt.oml.internal.cst.TransformationRefineCS;
	import org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS;
	import org.eclipse.m2m.qvt.oml.internal.cst.TypeSpecCS;
	./
$End

$Terminals

	QUOTE_STRING_LITERAL
	ADD_ASSIGN    ::= '+='
	RESET_ASSIGN  ::= ':='
	AT_SIGN       ::= '@'
	EXCLAMATION_MARK ::= '!'
	NOT_EQUAL_EXEQ   ::= '!='
	
$End

$KeyWords
	end
	while
	out
	object
	transformation
	import
	library
	metamodel
	mapping
	query
	helper
	inout
	when
	var
	configuration
	property
	population
	map
	xmap
	late
	log
	assert
	with
	resolve
	resolveone
	resolveIn
	resolveoneIn
	invresolve
	invresolveone
	invresolveIn
	invresolveoneIn
	modeltype
	uses
	where
	refines
	enforcing
	access
	extends
	blackbox
	abstract
	static
	result
	main
	this
	switch
	case	
	xselect         
	xcollect        
	selectOne       
	collectOne      
	collectselect   
	collectselectOne
	return
	rename
	inherits
	merges
	disjuncts
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
 * $Id: QvtOpLPGParser.backtrack.g,v 1.42 2008/02/27 14:29:58 sboyko Exp $
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
	
	-- QVTgoal -> goal
	QVTgoal -> mappingModuleCS
	QVTgoal -> libraryCS

	mappingModuleCS ::= moduleImportListOpt metamodelListOpt transformationCS moduleImportListOpt metamodelListOpt renamingListOpt propertyListOpt mappingRuleListOpt
		/.$BeginJava
					EList metamodels = (EList)$getSym(2);
					metamodels.addAll((EList)$getSym(5));
					EList imports = (EList)$getSym(1);
					imports.addAll((EList)$getSym(4));
					CSTNode header = (CSTNode) $getSym(3);
					CSTNode result = createMappingModuleCS(
							(TransformationHeaderCS) header,
							imports,
							metamodels,
							(EList)$getSym(6),
							(EList)$getSym(7),
							(EList)$getSym(8)
						);
					IToken headerToken = new Token(header.getStartOffset(), header.getEndOffset(), 0);
					int endOffset = getEndOffset(headerToken, (EList)$getSym(4),
							(EList)$getSym(5), (EList)$getSym(6), (EList)$getSym(7), (EList)$getSym(8)); 
					setOffsets(result, header);
					result.setEndOffset(endOffset);
					$setResult(result);
		  $EndJava
		./
	mappingModuleCS ::= moduleImportListOpt metamodelListOpt transformationCS qvtErrorToken
		/.$BeginJava
					CSTNode result = createMappingModuleCS(
							(TransformationHeaderCS)$getSym(3),
							$EMPTY_ELIST,
							$EMPTY_ELIST,
							$EMPTY_ELIST,
							$EMPTY_ELIST,
							$EMPTY_ELIST
						);
					setOffsets(result, (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./
	mappingModuleCS ::= moduleImportListOpt metamodelListOpt qualifierListOpt transformation qvtErrorToken
		/.$BeginJava
					CSTNode result = createMappingModuleCS(
							createPathNameCS(),
							$EMPTY_ELIST,
							$EMPTY_ELIST,
							$EMPTY_ELIST,
							$EMPTY_ELIST,
							$EMPTY_ELIST
						);
					setOffsets(result, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
		
	transformationCS ::= transformationHeaderCS ';'
		/.$BeginJava
					TransformationHeaderCS result = (TransformationHeaderCS) $getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	-- transformationCS -> transformationHeaderCS '{' moduleDefinitionCS '}' semicolonOpt

	transformationHeaderCS ::= qualifierListOpt transformation qualifiedNameCS
		/.$BeginJava
					EList qualifierList = (EList) $getSym(1);
					CSTNode result = createTransformationHeaderCS(
							qualifierList,
							(PathNameCS)$getSym(3),
							$EMPTY_ELIST,
							$EMPTY_ELIST,
							null
						);
					if (qualifierList.isEmpty()) {
						setOffsets(result, getIToken($getToken(2)), getIToken($getToken(4)));
					}
					else {
						setOffsets(result, (CSTNode) qualifierList.get(qualifierList.size()-1), getIToken($getToken(4)));
					}
					$setResult(result);
		  $EndJava
		./
	transformationHeaderCS ::= qualifierListOpt transformation qualifiedNameCS '(' transfParamListOpt ')' moduleUsageListOpt transformationRefineCSOpt
		/.$BeginJava
					EList qualifierList = (EList) $getSym(1);
					EList transfUsages = (EList) $getSym(7);
					TransformationRefineCS transfRefine = (TransformationRefineCS) $getSym(8);
					CSTNode result = createTransformationHeaderCS(
							qualifierList,
							(PathNameCS)$getSym(3),
							(EList)$getSym(5),
							transfUsages,
							transfRefine
						);
					if (qualifierList.isEmpty()) {
						setOffsets(result, getIToken($getToken(2)));
					}
					else {
						setOffsets(result, (CSTNode) qualifierList.get(qualifierList.size()-1));
					}
					if (transfRefine == null) {
						if (transfUsages.isEmpty()) {
							setOffsets(result, result, getIToken($getToken(6)));
						}
						else {
							setOffsets(result, result, (CSTNode) transfUsages.get(transfUsages.size()-1));
						}
					}
					else {
						setOffsets(result, result, transfRefine);
					}
					$setResult(result);
		  $EndJava
		./
	
	transformationRefineCSOpt ::= $empty
		/.$NullAction./
	transformationRefineCSOpt ::= refines moduleRefCS enforcing IDENTIFIER
		/.$BeginJava
					CSTNode result = createTransformationRefineCS(
							(ModuleRefCS)$getSym(2),
							getIToken($getToken(4))
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

	moduleUsageListOpt ::= $empty
		/.$EmptyListAction./
	moduleUsageListOpt -> moduleUsageList
	
	moduleUsageList ::= moduleUsageCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	moduleUsageList ::= moduleUsageList moduleUsageCS
		/.$BeginJava
					EList result = (EList) $getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndJava
		./
	
	moduleUsageCS ::= access moduleKindOpt moduleRefList
		/.$BeginJava
					EList moduleRefList = (EList)$getSym(3);
					CSTNode result = createModuleUsageCS(
							ImportKindEnum.ACCESS,
							(ModuleKindCS)$getSym(2),
							moduleRefList
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)moduleRefList.get(moduleRefList.size()-1));
					$setResult(result);
		  $EndJava
		./
	moduleUsageCS ::= extends moduleKindOpt moduleRefList
		/.$BeginJava
					EList moduleRefList = (EList)$getSym(3);
					CSTNode result = createModuleUsageCS(
							ImportKindEnum.EXTENSION,
							(ModuleKindCS)$getSym(2),
							moduleRefList
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)moduleRefList.get(moduleRefList.size()-1));
					$setResult(result);
		  $EndJava
		./
	
	moduleKindOpt ::= $empty
		/.$NullAction./
	moduleKindOpt -> moduleKindCS
	
	moduleKindCS ::= transformation
		/.$BeginJava
					CSTNode result = createModuleKindCS(
							ModuleKindEnum.TRANSFORMATION
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	moduleKindCS ::= library
		/.$BeginJava
					CSTNode result = createModuleKindCS(
							ModuleKindEnum.LIBRARY
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	
	moduleRefList ::= moduleRefCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	moduleRefList ::= moduleRefList ',' moduleRefCS
		/.$BeginJava
					EList result = (EList) $getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
	moduleRefList ::= moduleRefList qvtErrorToken
		/.$BeginJava
					EList result = (EList) $getSym(1);
					$setResult(result);
		  $EndJava
		./
	
	moduleRefCS ::= pathNameCS
		/.$BeginJava
					CSTNode result = createModuleRefCS(
							(PathNameCS)$getSym(1),
							$EMPTY_ELIST
						);
					setOffsets(result, (CSTNode)$getSym(1));
					$setResult(result);
		  $EndJava
		./
	moduleRefCS ::= pathNameCS '(' transfParamListOpt ')'
		/.$BeginJava
					CSTNode result = createModuleRefCS(
							(PathNameCS)$getSym(1),
							(EList)$getSym(3)
						);
					setOffsets(result, (CSTNode)$getSym(1), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	
	qualifierListOpt ::= $empty
		/.$EmptyListAction./
	qualifierListOpt -> qualifierList
		
	qualifierList ::= qualifierCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	qualifierList ::= qualifierList qualifierCS
		/.$BeginJava
					EList result = (EList) $getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndJava
		./
		
	qualifierCS ::= blackbox
		/.$NewCase./
	qualifierCS ::= abstract
		/.$NewCase./
	qualifierCS ::= static
		/.$BeginJava
					CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getTokenText(dtParser.getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	transfParamListOpt ::= $empty
		/.$EmptyListAction./
	transfParamListOpt -> transfParamList
	
	transfParamList ::= transfParamCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	transfParamList ::= transfParamList ',' transfParamCS
		/.$BeginJava
					EList result = (EList) $getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
	transfParamList ::= transfParamList qvtErrorToken
		/.$BeginJava
					EList result = (EList) $getSym(1);
					$setResult(result);
		  $EndJava
		./
		
	transfParamCS ::= directionKindOpt pathNameCS
		/.$BeginJava
					DirectionKindCS directionKind = (DirectionKindCS) $getSym(1);
					TypeSpecCS typeSpecCS = createTypeSpecCS((PathNameCS)$getSym(2), null);
					CSTNode result = createParameterDeclarationCS(
							directionKind,
							null,
							typeSpecCS
						);
					setOffsets(result, directionKind == null ? (CSTNode)$getSym(2) : directionKind, (CSTNode)$getSym(2));
					$setResult(result);
		  $EndJava
		./
	transfParamCS ::= directionKindOpt IDENTIFIER ':' pathNameCS 
		/.$BeginJava
					DirectionKindCS directionKind = (DirectionKindCS) $getSym(1);
					TypeSpecCS typeSpecCS = createTypeSpecCS((PathNameCS)$getSym(4), null);
					CSTNode result = createParameterDeclarationCS(
							directionKind,
							getIToken($getToken(2)),
							typeSpecCS
						);
					if (directionKind == null) {
						setOffsets(result, getIToken($getToken(2)), (CSTNode)$getSym(4));
					}
					else {
						setOffsets(result, directionKind, (CSTNode)$getSym(4));
					}
					$setResult(result);
		  $EndJava
		./
		
	libraryCS ::= moduleImportListOpt metamodelListOpt library qualifiedNameCS ';' 
				moduleImportListOpt metamodelListOpt renamingListOpt
				propertyListOpt mappingRuleListOpt
		/.$BeginJava
					EList metamodels = (EList)$getSym(2);
					metamodels.addAll((EList)$getSym(7));
					EList imports = (EList)$getSym(1);
					imports.addAll((EList)$getSym(6));
					CSTNode result = createLibraryCS(
							(PathNameCS)$getSym(4),
							imports,
							metamodels,
							(EList)$getSym(8),
							(EList)$getSym(9),
							(EList)$getSym(10)
						);
					int endOffset = getEndOffset(getIToken($getToken(5)), (EList)$getSym(6),
							(EList)$getSym(7), (EList)$getSym(8), (EList)$getSym(9), (EList)$getSym(10)); 
					setOffsets(result, getIToken($getToken(3)), new Token(0, endOffset, 0));
					$setResult(result);
		  $EndJava
		./
	libraryCS ::= moduleImportListOpt metamodelListOpt library qualifiedNameCS ';' qvtErrorToken
		/.$BeginJava
					CSTNode result = createLibraryCS(
							createPathNameCS(),
							$EMPTY_ELIST,
							$EMPTY_ELIST,
							$EMPTY_ELIST,
							$EMPTY_ELIST,
							$EMPTY_ELIST
						);
					setOffsets(result, getIToken($getToken(3)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	libraryCS ::= moduleImportListOpt metamodelListOpt library qualifiedNameCS qvtErrorToken
		/.$BeginJava
					CSTNode result = createLibraryCS(
							createPathNameCS(),
							$EMPTY_ELIST,
							$EMPTY_ELIST,
							$EMPTY_ELIST,
							$EMPTY_ELIST,
							$EMPTY_ELIST
						);
					setOffsets(result, getIToken($getToken(3)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	libraryCS ::= moduleImportListOpt metamodelListOpt library qvtErrorToken
		/.$BeginJava
					CSTNode result = createLibraryCS(
							createPathNameCS(),
							$EMPTY_ELIST,
							$EMPTY_ELIST,
							$EMPTY_ELIST,
							$EMPTY_ELIST,
							$EMPTY_ELIST
						);
					setOffsets(result, getIToken($getToken(3)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
		
	qualifiedNameCS ::= qvtIdentifierCS
		/.$BeginJava
					CSTNode result = createPathNameCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	qualifiedNameCS ::= qualifiedNameCS '.' qvtIdentifierCS
		/.$BeginJava
					PathNameCS result = (PathNameCS)$getSym(1);
					result = extendPathNameCS(result, getTokenText($getToken(3)));
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	qualifiedNameCS ::= qualifiedNameCS '.' qvtErrorToken
		/.$BeginJava
					PathNameCS result = (PathNameCS)$getSym(1);
					result = extendPathNameCS(result, "");
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	qualifiedNameCS ::= qualifiedNameCS qvtErrorToken
		/.$BeginJava
					PathNameCS result = (PathNameCS)$getSym(1);
					$setResult(result);
		  $EndJava	
		./

	typeCS2 -> primitiveTypeCS
	typeCS2 -> tupleTypeCS
	typeCS2 -> collectionTypeCS
	
	scopedNameCS ::= typeCS2 '::' IDENTIFIER
		/.$BeginJava
					ScopedNameCS result = createScopedNameCS((TypeCS)$getSym(1), 
																getTokenText($getToken(3)));		
					setOffsets(result, (CSTNode) $getSym(1), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	scopedNameCS ::= typeCS2 '::' qvtErrorToken
		/.$BeginJava
					ScopedNameCS result = createScopedNameCS((TypeCS)$getSym(1), 
																""); //$NON-NLS-1$		
					setOffsets(result, (CSTNode) $getSym(1), getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	scopedNameCS ::= scopedNameCS2
		/.$BeginJava
					PathNameCS pathNameCS = (PathNameCS)$getSym(1);
    	            String name = pathNameCS.getSequenceOfNames().remove(pathNameCS.getSequenceOfNames().size() - 1);
					TypeCS typeCS = pathNameCS.getSequenceOfNames().isEmpty() ? null : pathNameCS;

					ScopedNameCS result = createScopedNameCS(typeCS, name);		

					setOffsets(result, pathNameCS);

        	    	// reduce the region by the removed name element
					pathNameCS.setEndOffset(pathNameCS.getEndOffset() - (name != null ? name.length() : 0) - 2);
					
					$setResult(result);
		  $EndJava
		./
	scopedNameCS2 ::= IDENTIFIER
		/.$BeginJava
					CSTNode result = createPathNameCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	scopedNameCS2 ::= main
		/.$BeginJava
					CSTNode result = createPathNameCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	scopedNameCS2 ::= scopedNameCS2 '::' IDENTIFIER
		/.$BeginJava
					PathNameCS result = (PathNameCS)$getSym(1);
					result = extendPathNameCS(result, getTokenText($getToken(3)));
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	scopedNameCS2 ::= scopedNameCS2 '::' qvtErrorToken
		/.$BeginJava
					PathNameCS result = (PathNameCS)$getSym(1);
					result = extendPathNameCS(result, "");
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	
	moduleImportListOpt ::= $empty
		/.$EmptyListAction./
	moduleImportListOpt -> moduleImportList
	
	moduleImportList ::= importCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	moduleImportList ::= moduleImportList importCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndJava
		./
	moduleImportList ::= moduleImportList qvtErrorToken
		/.$BeginJava
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndJava
		./
	 
	importCS ::= import qualifiedNameCS ';' 
		/.$BeginJava
					CSTNode result = createModuleImportCS(
							(PathNameCS)$getSym(2)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	importCS ::= import library qualifiedNameCS ';'
		/.$BeginJava
					CSTNode result = createLibraryImportCS(
							(PathNameCS)$getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	importCS ::= import qvtErrorToken
		/.$BeginJava
					CSTNode result = createLibraryImportCS(
							createPathNameCS()
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	importCS ::= import library qvtErrorToken
		/.$BeginJava
					CSTNode result = createLibraryImportCS(
							createPathNameCS()
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./

	metamodelListOpt ::= $empty
		/.$EmptyListAction./
	metamodelListOpt -> metamodelList

	metamodelList ::= metamodelCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	metamodelList ::= metamodelList metamodelCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndJava
		./
	metamodelList ::= metamodelList qvtErrorToken
		/.$BeginJava
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndJava
		./
		
	metamodelCS -> modelTypeExpCS
	metamodelCS ::= metamodel stringLiteralExpCS ';'
		/.$BeginJava
					CSTNode packageRefCS = createPackageRefCS(
							null,
							(StringLiteralExpCS)$getSym(2)
						);
					setOffsets(packageRefCS, (CSTNode)$getSym(2));
					
					EList packageRefList = new BasicEList();
					packageRefList.add(packageRefCS);
					ModelTypeCS result = createModelTypeCS(
							new Token(0, 0, 0),
							createStringLiteralExpCS("'strict'"),
							packageRefList,
							$EMPTY_ELIST
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	metamodelCS ::= metamodel qvtErrorToken
		/.$BeginJava
					ModelTypeCS result = createModelTypeCS(
							new Token(0, 0, 0),
							createStringLiteralExpCS(""),
							$EMPTY_ELIST,
							$EMPTY_ELIST
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	
	renamingListOpt ::= $empty
		/.$EmptyListAction./
	renamingListOpt -> renamingList
	
	renamingList ::= renamingCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	renamingList ::= renamingList renamingCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndJava
		./
	renamingList ::= renamingList qvtErrorToken
		/.$BeginJava
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndJava
		./

	renamingCS ::= rename typeCS '.' qvtIdentifierCS '=' stringLiteralExpCS ';' 
		/.$BeginJava
					CSTNode result = createRenameCS(
							(TypeCS)$getSym(2),
							getIToken($getToken(4)),
							(StringLiteralExpCS)$getSym(6)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
					$setResult(result);
		  $EndJava
		./

	propertyListOpt ::= $empty
		/.$EmptyListAction./
	propertyListOpt -> propertyList
	
	propertyList ::= modulePropertyCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	propertyList ::= propertyList modulePropertyCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndJava
		./
	propertyList ::= propertyList qvtErrorToken
		/.$BeginJava
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndJava
		./
	
	modulePropertyCS ::= configuration property qvtIdentifierCS ':' typeCS ';' 
		/.$BeginJava
					CSTNode result = createConfigPropertyCS(
							getIToken($getToken(3)),
							(TypeCS)$getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(6)));
					$setResult(result);
		  $EndJava
		./
	modulePropertyCS ::= configuration property qvtIdentifierCS ':' typeCS qvtErrorToken
		/.$BeginJava
					CSTNode result = createConfigPropertyCS(
							getIToken($getToken(3)),
							(TypeCS)$getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	modulePropertyCS ::= property qvtIdentifierCS ':' typeCS '=' oclExpressionCS ';' 
		/.$BeginJava
					CSTNode result = createLocalPropertyCS(
							getIToken($getToken(2)),
							(TypeCS)$getSym(4),
							(OCLExpressionCS)$getSym(6)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
					$setResult(result);
		  $EndJava
		./
	modulePropertyCS ::= property qvtIdentifierCS '=' oclExpressionCS ';' 
		/.$BeginJava
					CSTNode result = createLocalPropertyCS(
							getIToken($getToken(2)),
							null,
							(OCLExpressionCS)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./

	mappingRuleListOpt ::= $empty
		/.$EmptyListAction./
	mappingRuleListOpt -> mappingRuleList
	
	mappingRuleList ::= mappingRuleCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	mappingRuleList ::= mappingRuleList mappingRuleCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndJava
		./	
	mappingRuleList ::= mappingQueryCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	mappingRuleList ::= mappingRuleList mappingQueryCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndJava
		./
	mappingRuleList ::= mappingRuleList qvtErrorToken
		/.$BeginJava
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndJava
		./
	
	mappingRuleCS ::= entryDeclarationCS '{' statementListOpt '}'
		/.$BeginJava
					MappingQueryCS result = createMappingQueryCS(
							(MappingDeclarationCS)$getSym(1),
							(EList)$getSym(3)
						);
					setOffsets(result, (CSTNode)$getSym(1), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
		
	mappingRuleCS ::= qualifierListOpt mapping mappingDeclarationCS mappingExtraListCSOpt mappingGuardOpt '{' mappingInitOpt mappingBodyOpt mappingEndOpt '}'  
		/.$BeginJava
					MappingInitCS mappingInit = (MappingInitCS)$getSym(7);
					MappingBodyCS mappingBody = (MappingBodyCS)$getSym(8);
					MappingEndCS mappingEnd = (MappingEndCS)$getSym(9);
					int bodyLeft = (mappingInit == null ?  getIToken($getToken(6)).getEndOffset() : mappingInit.getEndOffset());
					int bodyRight = (mappingEnd == null ?  getIToken($getToken(10)).getEndOffset() : mappingEnd.getStartOffset());
					int outBodyRight = (mappingEnd == null ?  getIToken($getToken(10)).getStartOffset() : mappingEnd.getStartOffset());
					if (mappingBody != null) {
						bodyLeft = mappingBody.getStartOffset();
						bodyRight = mappingBody.getEndOffset();
					}

					updateMappingBodyPositions(mappingBody, bodyLeft, bodyRight, bodyLeft, outBodyRight);
					MappingRuleCS result = createMappingRuleCS(
							(MappingDeclarationCS)$getSym(3),
							(OCLExpressionCS)$getSym(5),
							mappingInit,
							mappingBody,
							mappingEnd
						);
						
					EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)dtParser.getSym(1);
					if(!qualifiers.isEmpty()) {
						result.getQualifiers().addAll(createQualifiersListCS(qualifiers));
					}
						
					result.getMappingExtension().addAll(((EList<MappingExtensionCS>)dtParser.getSym(4)));
					setOffsets(result, getIToken($getToken(2)), getIToken($getToken(9)));
					$setResult(result);
		  $EndJava
		./
	
	mappingExtraListCSOpt ::= $empty
		/.$EmptyListAction./
	mappingExtraListCSOpt -> mappingExtraListCS
	mappingExtraListCS -> mappingExtensionCS
						
	mappingExtensionCS ::= mappingExtensionKeyCS scopedNameListCS mappingExtensionCS2
		/.$BeginJava
				MappingExtensionCS result = createMappingExtension(getTokenText(dtParser.getToken(1)), (EList<ScopedNameCS>)dtParser.getSym(2));
				EList<MappingExtensionCS> extensionList = (EList<MappingExtensionCS>)dtParser.getSym(3);  
				extensionList.add(0, result);
				
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(extensionList);
		  $EndJava
		./
-- changing associativity to avoid conflicts with extensionKindCS with scopedNameCS
-- to be eliminate during refactoring for ptc/07-07-07 grammar
	mappingExtensionCS2 ::= mappingExtensionKeyCS scopedNameListCS mappingExtensionCS
		/.$BeginJava
				MappingExtensionCS result = createMappingExtension(getTokenText(dtParser.getToken(1)), (EList<ScopedNameCS>)dtParser.getSym(2));
				EList<MappingExtensionCS> extensionList = (EList<MappingExtensionCS>)dtParser.getSym(3);  
				extensionList.add(0, result);
				
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(extensionList);
		  $EndJava
		./
	mappingExtensionCS2 ::= mappingExtensionKeyCS scopedNameListCS
		/.$BeginJava
				MappingExtensionCS result = createMappingExtension(getTokenText(dtParser.getToken(1)), (EList<ScopedNameCS>)dtParser.getSym(2));
				EList<MappingExtensionCS> extensionList = new BasicEList<MappingExtensionCS>();  
				extensionList.add(result);
				
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(extensionList);
		  $EndJava
		./
		
	mappingExtensionCS2 ::= $empty
		/.$EmptyListAction./
		
	mappingExtensionKeyCS -> inherits	
	mappingExtensionKeyCS -> merges	
	mappingExtensionKeyCS -> disjuncts	
			
	scopedNameListCS ::= scopedNameCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	scopedNameListCS ::= scopedNameListCS ',' scopedNameCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./

	mappingRuleCS ::= qualifierListOpt mapping mappingDeclarationCS ';'  
		/.$BeginJava
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS)$getSym(3);
					CSTNode result = createMappingRuleCS(
							mappingDecl,
							null,
							null,
							null,
							null
						);
					mappingDecl.setBlackBox(true);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	mappingRuleCS ::= qualifierListOpt mapping mappingDeclarationCS qvtErrorToken  
		/.$BeginJava
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS)$getSym(3);
					CSTNode result = createMappingRuleCS(
							mappingDecl,
							null,
							null,
							null,
							null
						);
					mappingDecl.setBlackBox(true);
					setOffsets(result, getIToken($getToken(1)), mappingDecl);
					$setResult(result);
		  $EndJava
		./
	mappingRuleCS ::= qualifierListOpt mapping qvtErrorToken
		/.$BeginJava
					MappingDeclarationCS mappingDecl = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createMappingDeclarationCS();
					mappingDecl.setSimpleNameCS(createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "")); //$NON-NLS-1$
					CSTNode result = createMappingRuleCS(
							mappingDecl,
							null,
							null,
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	
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
		
	helperKindCS -> helper		
	helperKindCS -> query	
		
	mappingQueryCS ::= helperKindCS mappingDeclarationCS '{' statementListOpt '}'  
		/.$BeginJava
					CSTNode result = createMappingQueryCS(
							(MappingDeclarationCS)$getSym(2),
							(EList)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	mappingQueryCS ::= helperKindCS mappingDeclarationCS ';'  
		/.$BeginJava
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS)$getSym(2);
					CSTNode result = createMappingQueryCS(
							mappingDecl,
							$EMPTY_ELIST
						);
					mappingDecl.setBlackBox(true);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	mappingQueryCS ::= helperKindCS mappingDeclarationCS qvtErrorToken  
		/.$BeginJava
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS)$getSym(2);
					CSTNode result = createMappingQueryCS(
							mappingDecl,
							$EMPTY_ELIST
						);
					mappingDecl.setBlackBox(true);
					setOffsets(result, getIToken($getToken(1)), mappingDecl);
					$setResult(result);
		  $EndJava
		./
	mappingQueryCS ::= helperKindCS qvtErrorToken
		/.$BeginJava
					CSTNode result = createMappingQueryCS(
							null,
							$EMPTY_ELIST
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	entryDeclarationCS ::= main '(' parameterListOpt ')'
		/.$BeginJava
					CSTNode result = createMappingDeclarationCS(
							null,
							createScopedNameCS(null, getTokenText($getToken(1))),
							(EList)$getSym(3),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

	entryDeclarationCS ::= main qvtErrorToken
		/.$BeginJava
					CSTNode result = createMappingDeclarationCS(
							null,
							createScopedNameCS(null, getTokenText($getToken(1))),
							$EMPTY_ELIST,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./


	mappingDeclarationCS ::= directionKindOpt scopedNameCS '(' parameterListOpt ')' ':' typeSpecCS
		/.$BeginJava
					DirectionKindCS directionKind = (DirectionKindCS)$getSym(1);
					CSTNode result = createMappingDeclarationCS(
							directionKind,
							(ScopedNameCS)$getSym(2),
							(EList)$getSym(4),
							(TypeSpecCS)$getSym(7)
						);
					setOffsets(result, (CSTNode)(directionKind == null ? $getSym(2) : directionKind), (CSTNode)$getSym(7));
					$setResult(result);
		  $EndJava
		./
	mappingDeclarationCS ::= directionKindOpt scopedNameCS '(' parameterListOpt ')'
		/.$BeginJava
					DirectionKindCS directionKind = (DirectionKindCS)$getSym(1);
					CSTNode result = createMappingDeclarationCS(
							directionKind,
							(ScopedNameCS)$getSym(2),
							(EList)$getSym(4),
							null
						);
					setOffsets(result, (CSTNode)(directionKind == null ? $getSym(2) : directionKind), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	mappingDeclarationCS ::= directionKindOpt scopedNameCS qvtErrorToken
		/.$BeginJava
					DirectionKindCS directionKind = (DirectionKindCS)$getSym(1);
					CSTNode result = createMappingDeclarationCS(
							directionKind,
							(ScopedNameCS)$getSym(2),
							$EMPTY_ELIST,
							null
						);
					setOffsets(result, (CSTNode)(directionKind == null ? $getSym(2) : directionKind), (CSTNode)$getSym(2));
					$setResult(result);
		  $EndJava
		./


	expressionListOpt ::= $empty
		/.$EmptyListAction./
	expressionListOpt -> expressionList
		
	expressionList ::= oclExpressionCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	expressionList ::= expressionList ';' oclExpressionCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
	expressionList -> expressionList ';'
	expressionList -> expressionList qvtErrorToken
	expressionList ::= qvtErrorToken
		/.$EmptyListAction./
		
	directionKindOpt ::= $empty
		/.$NullAction./
	directionKindOpt -> directionKindCS
	
	directionKindCS ::= in
		/.$BeginJava
					CSTNode result = createDirectionKindCS(
							DirectionKindEnum.IN
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	directionKindCS ::= out
		/.$BeginJava
					CSTNode result = createDirectionKindCS(
							DirectionKindEnum.OUT
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	directionKindCS ::= inout
		/.$BeginJava
					CSTNode result = createDirectionKindCS(
							DirectionKindEnum.INOUT
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
		
	parameterListOpt ::= $empty
		/.$EmptyListAction./
	parameterListOpt -> parameterList
	
	parameterList ::= qvtErrorToken
		/.$BeginJava
					EList result = new BasicEList();
					$setResult(result);
		  $EndJava
		./
	parameterList ::= parameterDeclarationCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	parameterList ::= parameterList ',' parameterDeclarationCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
	parameterList ::= parameterList qvtErrorToken
		/.$BeginJava
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndJava
		./
		
	parameterDeclarationCS ::= directionKindOpt IDENTIFIER ':' typeSpecCS
		/.$BeginJava
					CSTNode result = createParameterDeclarationCS(
							(DirectionKindCS)$getSym(1),
							getIToken($getToken(2)),
							(TypeSpecCS)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(2)), (CSTNode)$getSym(4));
					$setResult(result);
		  $EndJava
		./

	typeSpecCS ::= typeCS
		/.$BeginJava
					CSTNode result = createTypeSpecCS(
						(TypeCS)$getSym(1),
						null
						);
					$setResult(result);
		  $EndJava
		./
	typeSpecCS ::= typeCS '@' IDENTIFIER
		/.$BeginJava
					CSTNode result = createTypeSpecCS(
						(TypeCS)$getSym(1),
						getIToken($getToken(3))
						);
					$setResult(result);
		  $EndJava
		./

	mappingGuardOpt ::= $empty	 
		/.$NullAction./
	mappingGuardOpt -> mappingGuardCS
	
	mappingGuardCS ::= when '{' oclExpressionCS '}'
		/.$BeginJava
					OCLExpressionCS result = (OCLExpressionCS)$getSym(3);
					$setResult(result);
		  $EndJava
		./
	mappingGuardCS ::= when '{' oclExpressionCS '}' qvtErrorToken
		/.$BeginJava
					OCLExpressionCS result = (OCLExpressionCS)$getSym(3);
					$setResult(result);
		  $EndJava
		./
	mappingGuardCS ::= when qvtErrorToken
		/.$BeginJava
					$setResult(null);
		  $EndJava
		./
	
	mappingInitOpt ::= $empty
		/.$NullAction./
	mappingInitOpt -> mappingInitCS
	
	mappingInitCS ::= init '{' statementListOpt '}'
		/.$BeginJava
					CSTNode result = createMappingInitCS(
							(EList)$getSym(3),
							getIToken($getToken(2)).getEndOffset(),
							getIToken($getToken(4)).getStartOffset()
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	mappingInitCS ::= init qvtErrorToken
		/.$BeginJava
					CSTNode result = createMappingInitCS(
							$EMPTY_ELIST,
							getIToken($getToken(1)).getEndOffset(),
							getIToken($getToken(1)).getStartOffset()
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	
	mappingEndOpt ::= $empty
		/.$NullAction./
	mappingEndOpt -> mappingEndCS
	
	mappingEndCS ::= end '{' statementListOpt '}'
		/.$BeginJava
					CSTNode result = createMappingEndCS(
							(EList)$getSym(3),
							getIToken($getToken(2)).getEndOffset(),
							getIToken($getToken(4)).getStartOffset()
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	mappingEndCS ::= end qvtErrorToken
		/.$BeginJava
					CSTNode result = createMappingEndCS(
							$EMPTY_ELIST,
							getIToken($getToken(1)).getEndOffset(),
							getIToken($getToken(1)).getStartOffset()
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
		
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
							createBooleanLiteralExpCS("null")
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
							createBooleanLiteralExpCS("null")
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	variableInitializationCS ::= var IDENTIFIER ':' typeCS
		/.$BeginJava
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(2)),
							(TypeCS)$getSym(4),
							createBooleanLiteralExpCS("null")
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
							createBooleanLiteralExpCS("null")
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	variableInitializationCS ::= var IDENTIFIER
		/.$BeginJava
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(2)),
							null,
							createBooleanLiteralExpCS("null")
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	variableInitializationCS ::= var qvtErrorToken
		/.$BeginJava
					IToken errorToken = getIToken($getToken(2));
					CSTNode result = createVariableInitializationCS(
							new Token(errorToken.getStartOffset(), errorToken.getEndOffset(), QvtOpLPGParsersym.TK_ERROR_TOKEN),
							null,
							createBooleanLiteralExpCS("null")
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
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

	mappingBodyOpt ::= population '{' expressionListOpt '}'
		/.$BeginJava
				MappingBodyCS result = createMappingBodyCS(
						(EList<OCLExpressionCS>)dtParser.getSym(3),
						false, true
					);
				setOffsets(result, getIToken(dtParser.getToken(2)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
		  $EndJava
		./
		
	mappingBodyOpt ::= outExpCS
		/.$BeginJava
					MappingBodyCS result = createMappingBodyCS(
							(OutExpCS)dtParser.getSym(1),
							false, false
						);
					setOffsets(result, (CSTNode)$getSym(1));
					$setResult(result);
		  $EndJava
		./
	mappingBodyOpt ::= patternPropertyOrAdditionList
		/.$BeginJava
					EList props = (EList)$getSym(1);
					OutExpCS outExp = createOutExpCS(props, getIToken($getToken(1)).getStartOffset(), getIToken($getToken(1)).getEndOffset());
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
					$setResult(result);
		  $EndJava
		./
	
	patternPropertyOrAdditionList ::= $empty
		/.$EmptyListAction./
	patternPropertyOrAdditionList -> patternPropertyOrAdditionInnerList
	patternPropertyOrAdditionList -> patternPropertyOrAdditionList ';'
	
	patternPropertyOrAdditionInnerList ::= patternPropertyOrAddition2
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	patternPropertyOrAdditionInnerList ::= patternPropertyOrAdditionList ';' patternPropertyOrAddition2
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
	patternPropertyOrAddition2 -> patternPropertyOrAddition
	patternPropertyOrAddition2 ::= qvtErrorToken patternPropertyOrAddition
		/.$BeginJava
					$setResult($getSym(2));
		  $EndJava
		./
	patternPropertyOrAddition ::= IDENTIFIER ':=' oclExpressionCS
		/.$BeginJava
					CSTNode result = createPatternPropertyCS(
							getIToken($getToken(1)),
							(OCLExpressionCS)$getSym(3),
							false
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./
	patternPropertyOrAddition ::= IDENTIFIER ':=' qvtErrorToken
		/.$BeginJava
					CSTNode result = createPatternPropertyCS(
							getIToken($getToken(1)),
							createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, ""), //$NON-NLS-1$
							false
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./

	patternPropertyOrAddition ::= IDENTIFIER '+=' oclExpressionCS
		/.$BeginJava
					CSTNode result = createPatternPropertyCS(
							getIToken($getToken(1)),
							(OCLExpressionCS)$getSym(3),
							true
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./
	patternPropertyOrAddition ::= IDENTIFIER '+=' qvtErrorToken
		/.$BeginJava
					CSTNode result = createPatternPropertyCS(
							getIToken($getToken(1)),
							createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, ""), //$NON-NLS-1$
							true
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	patternPropertyOrAddition ::= IDENTIFIER qvtErrorToken
		/.$BeginJava
					CSTNode result = createPatternPropertyCS(
							getIToken($getToken(1)),
							createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, ""), //$NON-NLS-1$
							true
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	
	typeSpecCSOpt ::= $empty
		/.$NullAction./
	typeSpecCSOpt -> typeSpecCS

	objectDeclCS ::= typeSpecCS
		/.$BeginJava
					CSTNode result = createOutExpCS(null, (TypeSpecCS)$getSym(1));
					$setResult(result);
		  $EndJava
		./

	objectIdentifierCS -> result
	objectIdentifierCS -> self
	objectIdentifierCS -> IDENTIFIER	
	
	objectDeclCS ::= objectIdentifierCS ':' typeSpecCSOpt
		/.$BeginJava
				SimpleNameCS varName = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(dtParser.getToken(1)));
				setOffsets(varName, getIToken(dtParser.getToken(1)));
				CSTNode result = createOutExpCS(varName,(TypeSpecCS)dtParser.getSym(3));					
				$setResult(result);
		  $EndJava
		./
	
	outExpCS ::= object objectDeclCS '{' patternPropertyOrAdditionList '}' 
		/.$BeginJava
					CSTNode result = setupOutExpCS(
							(OutExpCS)$getSym(2),					
							(EList)$getSym(4),
							// passing body positions
							getIToken($getToken(3)).getEndOffset(),
							getIToken($getToken(5)).getStartOffset()
						); 
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	outExpCS ::= object objectDeclCS '{' patternPropertyOrAdditionList qvtErrorToken
		/.$BeginJava
					OutExpCS outExpCS = ((OutExpCS)dtParser.getSym(2));
					EList<CSTNode> patternPropertyOrAdditionList = (EList<CSTNode>)$getSym(4);
					CSTNode result = createErrorOutExpCS(
							outExpCS.getSimpleNameCS(),						
							outExpCS.getTypeSpecCS(),
							(EList)dtParser.getSym(4),						
							getIToken($getToken(3)).getEndOffset(),
							getIToken($getToken(5)).getStartOffset(),
							getIToken($getToken(1)).getStartOffset(),
							getIToken($getToken(5)).getStartOffset()
						);
					if (patternPropertyOrAdditionList.isEmpty()) {
					    setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					} else {
					    CSTNode lastNode = patternPropertyOrAdditionList.get(patternPropertyOrAdditionList.size() - 1);
					    setOffsets(result, getIToken($getToken(1)), lastNode);
					}
					$setResult(result);
		  $EndJava
		./
	outExpCS ::= object objectDeclCS qvtErrorToken
		/.$BeginJava
					OutExpCS objectDeclCS = ((OutExpCS)dtParser.getSym(2));  
					CSTNode result = createErrorOutExpCS(
							objectDeclCS.getSimpleNameCS(),						
							objectDeclCS.getTypeSpecCS(),
							$EMPTY_ELIST,
							getIToken($getToken(1)).getEndOffset(),
							getIToken($getToken(1)).getStartOffset(),
							getIToken($getToken(1)).getStartOffset(),
							getIToken($getToken(3)).getStartOffset()
						);
					if (objectDeclCS  == null) {
					    setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					} else {
					    setOffsets(result, getIToken($getToken(1)), objectDeclCS);
					}
					$setResult(result);
		  $EndJava
		./
		
	featureMappingCallExpCS ::= map simpleNameCS '(' argumentsCSopt ')'
		/.$BeginJava
					CSTNode result = createMappingCallExpCS(
							(SimpleNameCS)$getSym(2),
							(EList)$getSym(4),
							false
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	featureMappingCallExpCS ::= xmap simpleNameCS '(' argumentsCSopt ')'
		/.$BeginJava
					CSTNode result = createMappingCallExpCS(
							(SimpleNameCS)$getSym(2),
							(EList)$getSym(4),
							true
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./

	mappingCallExpCS ::= map pathNameCS '(' argumentsCSopt ')'
		/.$BeginJava
					CSTNode result = createMappingCallExpCS(
							(PathNameCS)$getSym(2),
							(EList)$getSym(4),
							false
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	mappingCallExpCS ::= xmap pathNameCS '(' argumentsCSopt ')'
		/.$BeginJava
					CSTNode result = createMappingCallExpCS(
							(PathNameCS)$getSym(2),
							(EList)$getSym(4),
							true
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./

    -- Resolve family starts here

    resolveConditionOpt ::= $empty
        /.$NullAction./
        
    resolveConditionOpt ::= '|' oclExpressionCS
        /.$BeginJava
                    $setResult((OCLExpressionCS)$getSym(2));
          $EndJava
        ./

    resolveConditionOpt ::= '|' qvtErrorToken
        /.$NullAction./

	IDENTIFIEROpt ::= $empty
        /.$NullAction./

	IDENTIFIEROpt ::= IDENTIFIER ':'
        /.$BeginJava
                    $setResult(getIToken($getToken(1)));
          $EndJava
        ./

    resolveOpArgsExpCS ::= $empty
        /.$NullAction./
        
    resolveOpArgsExpCS ::= IDENTIFIEROpt typeCS resolveConditionOpt
        /.$BeginJava
                    CSTNode result = createResolveOpArgsExpCS(
                            getIToken($getToken(1)),      // target_type_variable?
                            (TypeCS)$getSym(2),           // type?
                            (OCLExpressionCS)$getSym(3)); // condition?
                            setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
                    $setResult(result);
          $EndJava
        ./
    
    resolveOp -> resolve
    resolveOp -> invresolve
    resolveOp -> resolveone
    resolveOp -> invresolveone
    
    lateOpt ::= $empty
        /.$NullAction./
    lateOpt -> late
    
    resolveExpCS ::= lateOpt resolveOp '(' resolveOpArgsExpCS ')'
        /.$BeginJava
                    CSTNode result = createResolveExpCS(
                            getIToken($getToken(1)),
                            getIToken($getToken(2)),
                            (ResolveOpArgsExpCS)$getSym(4));
                            setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
                    $setResult(result);
          $EndJava
        ./
        
    resolveExpCS ::= lateOpt resolveOp '(' resolveOpArgsExpCS qvtErrorToken
        /.$BeginJava
                    CSTNode result = createResolveExpCS(
                            getIToken($getToken(1)),
                            getIToken($getToken(2)),
                            (ResolveOpArgsExpCS)$getSym(4));
                            setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
                    $setResult(result);
          $EndJava
        ./
        
    resolveExpCS ::= lateOpt resolveOp qvtErrorToken
        /.$BeginJava
                    CSTNode result = createResolveExpCS(
                            getIToken($getToken(1)),
                            getIToken($getToken(2)),
                            null);
                            setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
                    $setResult(result);
          $EndJava
        ./
        
    resolveExpCS ::= late qvtErrorToken    
        /.$BeginJava
        			IToken lateToken = getIToken($getToken(1));
                    CSTNode result = createResolveExpCS(
                            lateToken,
                            new Token(lateToken.getEndOffset(), lateToken.getEndOffset(), QvtOpLPGParsersym.TK_resolve),
                            null);
                            setOffsets(result, getIToken($getToken(1)));
                    $setResult(result);
          $EndJava
        ./

    resolveInOp -> resolveIn
    resolveInOp -> invresolveIn
    resolveInOp -> resolveoneIn
    resolveInOp -> invresolveoneIn
    
    resolveInExpCS ::= lateOpt resolveInOp '(' scopedNameCS ',' resolveOpArgsExpCS ')'
        /.$BeginJava
                    CSTNode result = createResolveInExpCS(
                            getIToken($getToken(1)),
                            getIToken($getToken(2)),
                            (ScopedNameCS)$getSym(4),
                            (ResolveOpArgsExpCS)$getSym(6));
                            setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
                    $setResult(result);
          $EndJava
        ./
        
    resolveInExpCS ::= lateOpt resolveInOp '(' scopedNameCS ',' resolveOpArgsExpCS qvtErrorToken
        /.$BeginJava
                    CSTNode result = createResolveInExpCS(
                            getIToken($getToken(1)),
                            getIToken($getToken(2)),
                            (ScopedNameCS)$getSym(4),
                            (ResolveOpArgsExpCS)$getSym(6));
                            setOffsets(result, getIToken($getToken(1)), getIToken($getToken(6)));
                    $setResult(result);
          $EndJava
        ./
        
    resolveInExpCS ::= lateOpt resolveInOp '(' scopedNameCS qvtErrorToken
        /.$BeginJava
                    CSTNode result = createResolveInExpCS(
                            getIToken($getToken(1)),
                            getIToken($getToken(2)),
                            (ScopedNameCS)$getSym(4),
                            null);
                            setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
                    $setResult(result);
          $EndJava
        ./
        
    resolveInExpCS ::= lateOpt resolveInOp '(' qvtErrorToken
        /.$BeginJava
                    CSTNode result = createResolveInExpCS(
                            getIToken($getToken(1)),
                            getIToken($getToken(2)),
							createScopedNameCS(null, ""), //$NON-NLS-1$
                            null);
                            setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
                    $setResult(result);
          $EndJava
        ./
        
    resolveInExpCS ::= lateOpt resolveInOp qvtErrorToken
        /.$BeginJava
                    CSTNode result = createResolveInExpCS(
                            getIToken($getToken(1)),
                            getIToken($getToken(2)),
							createScopedNameCS(null, ""), //$NON-NLS-1$
                            null);
                            setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
                    $setResult(result);
          $EndJava
        ./
        
    resolveResolveInExpCS -> resolveExpCS
    resolveResolveInExpCS -> resolveInExpCS

	-- commented out since the spec is not clear about the return type of this expression       
	-- callExpCS ::= '->' resolveResolveInExpCS
	--	/.$BeginJava
	--				CallExpCS result = (CallExpCS)$getSym(2);
	--				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
	--				$setResult(result);
	--	  $EndJava
	--	./
	callExpCS ::= '.' resolveResolveInExpCS
		/.$BeginJava
					CallExpCS result = (CallExpCS)$getSym(2);
					result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
					$setResult(result);
		  $EndJava
		./
        
    -- case with no source of resolveIn
	oclExpCS -> resolveResolveInExpCS

    -- Resolve family ends here

	whileBodyCS -> blockExpCS

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

	whileDeclaratorCS ::= IDENTIFIER ':' typeCS
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
	whileDeclaratorCS ::= IDENTIFIER ':' typeCS '=' oclExpressionCS
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

	whileDeclaratorCS ::= IDENTIFIER ':' typeCS ':=' oclExpressionCS
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
		
	whileDeclaratorCS ::= IDENTIFIER ':=' oclExpressionCS
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
		
	whileExpCS ::= while '(' whileDeclaratorCS ';' oclExpressionCS ')' whileBodyCS
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

	-- operation call and expression extension in QVT
	featureCallExpCS -> featureMappingCallExpCS
	oclExpCS -> mappingCallExpCS

	oclExpCS -> whileExpCS
	oclExpCS -> legacyWhileExpCS
	oclExpCS -> outExpCS 
	
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
		
	simpleNameCS ::= this
		/.$NewCase./
	simpleNameCS ::= result
		/.$BeginJava
					CSTNode result = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getTokenText($getToken(1))
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
		
	modelTypeExpCS ::= modeltype IDENTIFIER complianceKindCSOpt uses packageRefList modelTypeWhereCSOpt ;
		/.$BeginJava
					EList whereList = (EList)$getSym(6);
					EList packageRefList = (EList)$getSym(5);
					ModelTypeCS result = createModelTypeCS(
							getIToken($getToken(2)),
							(StringLiteralExpCS)$getSym(3),
							packageRefList,
							whereList
						);
					if (whereList.isEmpty()) {
						setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
					}
					else {
						CSTNode lastPackageRefCS = (CSTNode)packageRefList.get(packageRefList.size()-1);
						setOffsets(result, getIToken($getToken(1)), lastPackageRefCS);
						setBodyOffsets(result, lastPackageRefCS, getIToken($getToken(7)));
					}
					$setResult(result);
		  $EndJava
		./
	modelTypeExpCS ::= modeltype qvtErrorToken
		/.$BeginJava
					ModelTypeCS result = createModelTypeCS(
							new Token(0, 0, 0),
							createStringLiteralExpCS(""),
							$EMPTY_ELIST,
							$EMPTY_ELIST
						);
					setOffsets(result, getIToken($getToken(1)));
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
    complianceKindCSOpt -> stringLiteralExpCS
    
	packageRefList ::= packageRefCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	packageRefList ::= packageRefList ',' packageRefCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./

	packageRefCS ::= pathNameCS
		/.$BeginJava
					CSTNode result = createPackageRefCS(
							(PathNameCS)$getSym(1),
							null
						);
					setOffsets(result, (CSTNode)$getSym(1));
					$setResult(result);
		  $EndJava
		./
	packageRefCS ::= pathNameCS '(' qvtStringLiteralExpCS ')'
		/.$BeginJava
					CSTNode result = createPackageRefCS(
							(PathNameCS)$getSym(1),
							(StringLiteralExpCS)$getSym(3)
						);
					setOffsets(result, (CSTNode)$getSym(1), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	packageRefCS ::= qvtStringLiteralExpCS
		/.$BeginJava
					CSTNode result = createPackageRefCS(
							null,
							(StringLiteralExpCS)$getSym(1)
						);
					setOffsets(result, (CSTNode)$getSym(1));
					$setResult(result);
		  $EndJava
		./
		
	qvtStringLiteralExpCS -> stringLiteralExpCS
	qvtStringLiteralExpCS ::= QUOTE_STRING_LITERAL
		/.$BeginJava
					CSTNode result = createStringLiteralExpCS("'" + unquote(getTokenText($getToken(1))) + "'"); //$NON-NLS-1$ //$NON-NLS-2$
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

    modelTypeWhereCSOpt ::= $empty
		/.$EmptyListAction./
    modelTypeWhereCSOpt ::= where '{' statementListOpt '}'
		/.$BeginJava
					EList result = (EList)$getSym(3);
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
	ifExpBodyCS -> blockExpCS

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

	switchDeclaratorCS -> whileDeclaratorCS

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
	
	--switchAltExpCS ::= '(' oclExpressionCS qvtErrorToken
	--	/.$BeginJava
	--				CSTNode result = createSwitchAltExpCS(
	--						(OCLExpressionCS) $getSym(2),
	--						null
	--					);
	--				setOffsets(result, getIToken($getToken(1)), (CSTNode) $getSym(2));
	--				$setResult(result);
	--	  $EndJava
	--	./
	
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
					if ((iterContents != null) || (iterContents.length == 0)) {
					        for (int i = iterContents.length - 1; i >= 0; i--) {
					        	if (iterContents[i] instanceof CSTNode) {
					        		setOffsets(result, getIToken($getToken(1)), (CSTNode) iterContents[i]);
					        		break;
					        	}
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

	blockExpCS ::= '{' statementListOpt '}'
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
	expressionStatementCS -> blockExpCS
	expressionStatementCS -> blockExpCS ';'

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

	condExpOpt ::= $empty
	        /.$NullAction./

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
	
$End

	