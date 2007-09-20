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
-- * $Id: QvtOpLPGParser.backtrack.g,v 1.18 2007/09/20 10:14:06 aigdalov Exp $
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
%options ast_type=EObject
%options programming_language=java
%options action=("*.java", "/.", "./")
%options ParseTable=lpg.lpgjavaruntime.ParseTable

$Start
    QVTgoal
$End

$Import
	OCLLPGParser.g

$DropRules

	goal -> packageDeclarationCS1
	goal -> packageDeclarationCSm
	packageDeclarationCS1 ::= contextDeclCSm
	packageDeclarationCSm -> packageDeclarationCS
	packageDeclarationCSm ::= packageDeclarationCSm packageDeclarationCS
	packageDeclarationCS ::= package pathNameCS contextDeclCSmopt endpackage
	
	goal -> invOrDefCS
	classifierContextDeclCS ::= context pathNameCS invOrDefCS
	invOrDefCSopt ::= $empty
	invOrDefCSopt -> invOrDefCS
	invOrDefCS ::= invOrDefCSopt inv simpleNameCSopt ':' oclExpressionCS
	invOrDefCS ::= invOrDefCSopt def simpleNameCSopt ':' defExpressionCS
	defExpressionCS ::= IDENTIFIER ':' typeCS '=' oclExpressionCS
	defExpressionCS ::= operationCS1 '=' oclExpressionCS
	contextDeclCS -> classifierContextDeclCS
		
	goal -> prePostOrBodyDeclCS
	prePostOrBodyDeclCSm ::= prePostOrBodyDeclCS
	prePostOrBodyDeclCSm ::= prePostOrBodyDeclCSm prePostOrBodyDeclCS
	prePostOrBodyDeclCS ::= pre simpleNameCSopt ':' oclExpressionCS
	prePostOrBodyDeclCS ::= post simpleNameCSopt ':' oclExpressionCS
	prePostOrBodyDeclCS ::= body simpleNameCSopt ':' oclExpressionCS
	operationContextDeclCS ::= context operationCS2 prePostOrBodyDeclCSm
	contextDeclCS -> operationContextDeclCS
	
	goal -> initOrDerValueCS
	propertyContextCS ::= context pathNameCS '::' simpleNameCS ':' typeCS initOrDerValueCS
	initOrDerValueCS ::= initOrDerValueCSopt init ':' oclExpressionCS
	initOrDerValueCS ::= initOrDerValueCSopt derive ':' oclExpressionCS
	initOrDerValueCSopt ::= $empty
	initOrDerValueCSopt -> initOrDerValueCS
	contextDeclCS -> propertyContextCS
	contextDeclCSmopt ::= $empty
	contextDeclCSmopt -> contextDeclCSm
	contextDeclCSm ::= contextDeclCS
	contextDeclCSm ::= contextDeclCSm contextDeclCS
	
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

$DropSymbols

	packageDeclarationCS1
	packageDeclarationCSm
	packageDeclarationCS
	
	invOrDefCS
	invOrDefCSopt
	defExpressionCS
	classifierContextDeclCS

	prePostOrBodyDeclCS
	prePostOrBodyDeclCSm
	
	initOrDerValueCS
	initOrDerValueCSopt
	propertyContextCS
	contextDeclCSmopt
	
	operationCS
	operationCS1
	operationCS2
	
	parametersCS
	
$End


$Define

	-- Definition of macros used in the parser template
	--
	$EMPTY_ELIST /.ourEmptyEList./

	-- copied from OCLLPGParser.g
	--
	-- modified to include throwing exceptions
	$parserCore
	/.
	public class $action_class extends PrsStream implements RuleAction$additional_interfaces {
		protected static ParseTable prs = new $prs_type();
		private BacktrackingParser dtParser;

		public $action_class(LexStream lexStream) {
			super(lexStream);

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
				java.util.ArrayList unimplemented_symbols = e.getSymbols();
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
 
		public String[] orderedTerminalSymbols() { return $sym_type.orderedTerminalSymbols; }
		public String getTokenKindName(int kind) { return $sym_type.orderedTerminalSymbols[kind]; }			
		public int getEOFTokenKind() { return $prs_type.EOFT_SYMBOL; }
		public PrsStream getParseStream() { return this; }

		protected $ast_type parser() throws ParserException {
			return parser(null, 0);
		}
			
		protected $ast_type parser(Monitor monitor) throws ParserException {
			return parser(monitor, 0);
		}
			
		protected $ast_type parser(int error_repair_count) throws ParserException {
			return parser(null, error_repair_count);
		}
			
		protected $ast_type parser(Monitor monitor, int error_repair_count) throws ParserException {
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
			java.util.ArrayList tokens = getTokens();
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
	import lpg.lpgjavaruntime.Token;
	import lpg.lpgjavaruntime.BacktrackingParser;
	import lpg.lpgjavaruntime.NotBacktrackParseTableException;
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
	./
$End

$Terminals

	QUOTE_STRING_LITERAL
	ADD_ASSIGN    ::= '+='
	RESET_ASSIGN  ::= ':='
	AT_SIGN       ::= '@'
	
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
	inout
	when
	var
	configuration
	property
	map
	xmap
	late
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
	
	rename
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
 * $Id: QvtOpLPGParser.backtrack.g,v 1.18 2007/09/20 10:14:06 aigdalov Exp $
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
			TransformationHeaderCS headerCS = createTransformationHeaderCS($EMPTY_ELIST, name, $EMPTY_ELIST, $EMPTY_ELIST, null);
			setOffsets(headerCS, name);
			initializeModule(imp, headerCS, imports, metamodels, renamings, properties, methods);
			return imp;
		}
	
		protected CSTNode createMappingModuleCS(PathNameCS name, EList imports, EList metamodels,
				EList renamings, EList properties, EList methods) {
			MappingModuleCS imp = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createMappingModuleCS();
			TransformationHeaderCS headerCS = createTransformationHeaderCS($EMPTY_ELIST, name, $EMPTY_ELIST, $EMPTY_ELIST, null);
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
				nameCS.setStartOffset(sym.getEndOffset()-lastSegment.length());
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
					CSTNode result = createStringLiteralExpCS("'" + getTokenText($getToken(1)) + "'"); //$NON-NLS-1$ //$NON-NLS-2$
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
	mappingRuleCS ::= mapping mappingDeclarationCS mappingGuardOpt '{' mappingInitOpt mappingBodyOpt mappingEndOpt '}'  
		/.$BeginJava
					MappingInitCS mappingInit = (MappingInitCS)$getSym(5);
					MappingBodyCS mappingBody = (MappingBodyCS)$getSym(6);
					MappingEndCS mappingEnd = (MappingEndCS)$getSym(7);
					int bodyLeft = (mappingInit == null ?  getIToken($getToken(4)).getEndOffset() : mappingInit.getEndOffset());
					int bodyRight = (mappingEnd == null ?  getIToken($getToken(8)).getEndOffset() : mappingEnd.getStartOffset());
					int outBodyRight = (mappingEnd == null ?  getIToken($getToken(8)).getStartOffset() : mappingEnd.getStartOffset());
					if (mappingBody != null) {
						bodyLeft = mappingBody.getStartOffset();
						bodyRight = mappingBody.getEndOffset();
					}

					updateMappingBodyPositions(mappingBody, bodyLeft, bodyRight, bodyLeft, outBodyRight);
					CSTNode result = createMappingRuleCS(
							(MappingDeclarationCS)$getSym(2),
							(OCLExpressionCS)$getSym(3),
							mappingInit,
							mappingBody,
							mappingEnd
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(8)));
					$setResult(result);
		  $EndJava
		./
	mappingRuleCS ::= mapping mappingDeclarationCS ';'  
		/.$BeginJava
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS)$getSym(2);
					CSTNode result = createMappingRuleCS(
							mappingDecl,
							null,
							null,
							null,
							null
						);
					mappingDecl.setBlackBox(true);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	mappingRuleCS ::= mapping mappingDeclarationCS qvtErrorToken  
		/.$BeginJava
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS)$getSym(2);
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
	mappingRuleCS ::= mapping qvtErrorToken
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
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	mappingQueryCS ::= query mappingDeclarationCS '{' expressionListOpt '}'  
		/.$BeginJava
					CSTNode result = createMappingQueryCS(
							(MappingDeclarationCS)$getSym(2),
							(EList)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	mappingQueryCS ::= query mappingDeclarationCS ';'  
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
	mappingQueryCS ::= query mappingDeclarationCS qvtErrorToken  
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
	mappingQueryCS ::= query qvtErrorToken
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
	
	variableInitializationCS ::= var IDENTIFIER ':' typeCS ':=' oclExpressionCS
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
	variableInitializationCS ::= var IDENTIFIER ':=' oclExpressionCS
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
		
	mappingBodyOpt ::= outExpCS
		/.$BeginJava
					MappingBodyCS result = createMappingBodyCS(
							(OutExpCS)$getSym(1),
							false
						);
					setOffsets(result, (CSTNode)$getSym(1));
					$setResult(result);
		  $EndJava
		./
	mappingBodyOpt ::= patternPropertyOrAdditionList
		/.$BeginJava
					EList props = (EList)$getSym(1);
					OutExpCS outExp = createOutExpCS(props, null, getIToken($getToken(1)).getStartOffset(), getIToken($getToken(1)).getEndOffset());
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

	outExpCS ::= object typeSpecCSOpt '{' patternPropertyOrAdditionList '}' 
		/.$BeginJava
					CSTNode result = createOutExpCS(
							(EList)$getSym(4),
							(TypeSpecCS)$getSym(2),
							getIToken($getToken(3)).getEndOffset(),
							getIToken($getToken(5)).getStartOffset()
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	outExpCS ::= object typeSpecCSOpt '{' patternPropertyOrAdditionList qvtErrorToken
		/.$BeginJava
					EList<CSTNode> patternPropertyOrAdditionList = (EList<CSTNode>)$getSym(4);
					CSTNode result = createErrorOutExpCS(
							(EList)$getSym(4),
							(TypeSpecCS)$getSym(2),
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
	outExpCS ::= object typeSpecCSOpt qvtErrorToken
		/.$BeginJava
		                        TypeSpecCS typeSpecCS = (TypeSpecCS)$getSym(2);  
					CSTNode result = createErrorOutExpCS(
							$EMPTY_ELIST,
							typeSpecCS,
							getIToken($getToken(1)).getEndOffset(),
							getIToken($getToken(1)).getStartOffset(),
							getIToken($getToken(1)).getStartOffset(),
							getIToken($getToken(3)).getStartOffset()
						);
					if (typeSpecCS  == null) {
					    setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					} else {
					    setOffsets(result, getIToken($getToken(1)), typeSpecCS);
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
	oclExpCS -> resolveInExpCS

    -- Resolve family ends here

	whileExpCS ::= while '(' oclExpressionCS ';' oclExpressionCS ')' '{' statementListOpt '}'
		/.$BeginJava
					CSTNode result = createWhileExpCS(
							(OCLExpressionCS)$getSym(3),
							(OCLExpressionCS)$getSym(5),
							(EList)$getSym(8)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(9)));
					$setResult(result);
		  $EndJava
		./


	-- operation call and expression extension in QVT
	featureCallExpCS -> featureMappingCallExpCS
	oclExpCS -> mappingCallExpCS

	oclExpCS -> whileExpCS 
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
	ifExpBodyCS ::= '{' statementListOpt '}'
		/.$BeginJava
					EList bodyList = (EList) $getSym(2);
					CSTNode result = createBlockExpCS(
							bodyList
						);
					if (bodyList.isEmpty()) {
						setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					}
					else {
						setOffsets(result, (CSTNode) bodyList.get(0), (CSTNode) bodyList.get(bodyList.size()-1));
					}
					$setResult(result);
		  $EndJava
		./

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

	switchExpCS ::= switch switchBodyExpCS
		/.$BeginJava
					Object[] switchBody = (Object[]) $getSym(2);

					CSTNode result = createSwitchExpCS(
							(EList<SwitchAltExpCS>) switchBody[0],
							(OCLExpressionCS) switchBody[1]
						);
					setOffsets(result, getIToken($getToken(1)), (IToken) switchBody[2]);
					$setResult(result);
		  $EndJava
		./

	switchBodyExpCS ::= '{' switchAltExpCSList switchElseExpCSOpt '}'
		/.$BeginJava
					Object[] result = new Object[] {$getSym(2), $getSym(3), getIToken($getToken(4))};
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
	
	switchElseExpCSOpt ::= $empty
		/.$NullAction./
	switchElseExpCSOpt -> switchElseExpCS

	switchElseExpCS ::= else '?' statementCS ';'
		/.$BeginJava
					$setResult((CSTNode)$getSym(3));
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
					Object[] iterContents = (Object[])$getSym(3);
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

$End

