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
-- * $Id: QvtOpLPGParser.g,v 1.2 2007/11/27 20:33:22 radvorak Exp $
-- */
--
-- The QVT Operational Parser
--

%options escape=$
%options la=20
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
	
	-- 'if' extension in QVT
	ifExpCSPrec -> ifExpCS

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
	
$End


$Define

	-- Definition of macros used in the parser template
	--
	$EMPTY_ELIST /.new BasicEList()./

	-- copied from OCLLPGParser.g
	--
	-- modified to include throwing exceptions
	$parserCore
	/.
	public class $action_class extends PrsStream implements RuleAction$additional_interfaces {
		protected static ParseTable prs = new $prs_type();
		private DeterministicParser dtParser;

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
				dtParser = new DeterministicParser(monitor, this, prsTable, this);
			}
			catch (NotDeterministicParseTableException e) {
				throw new RuntimeException("****Error: Regenerate $prs_type.java with -NOBACKTRACK option");
			}
			catch (BadParseSymFileException e) {
				throw new RuntimeException("****Error: Bad Parser Symbol File -- $sym_type.java. Regenerate $prs_type.java");
			}

			try {
				return ($ast_type) dtParser.parse();
			}
			catch (BadParseException e) {
				OnParseError(e);

				reset(e.error_token); // point to error token
				DiagnoseParser diagnoseParser = new DiagnoseParser(this, prsTable);
				diagnoseParser.diagnose(e.error_token);
			}

			return null;
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
	import org.eclipse.m2m.qvt.oml.internal.cst.VariableInitializationCS;
	import org.eclipse.m2m.qvt.oml.internal.cst.WhileExpCS;
	./
$End

$Terminals

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
	rename
	mapping
	query
	inout
	when
	var
	configuration
	property
	map
	xmap
	undefined
	late
	resolve
	resolveone
	resolveIn
	resolveoneIn
	invresolve
	invresolveone
	invresolveIn
	invresolveoneIn
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
 * $Id: QvtOpLPGParser.g,v 1.2 2007/11/27 20:33:22 radvorak Exp $
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
			initializeModule(imp, name, imports, metamodels, renamings, properties, methods);
			return imp;
		}
	
		protected CSTNode createMappingModuleCS(PathNameCS name, EList imports, EList metamodels,
				EList renamings, EList properties, EList methods) {
			MappingModuleCS imp = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createMappingModuleCS();
			initializeModule(imp, name, imports, metamodels, renamings, properties, methods);
			return imp;
		}
	
		private void initializeModule(MappingModuleCS result, PathNameCS name, EList imports, EList metamodels,
				EList renamings, EList properties, EList methods) {
			result.setPathNameCS(name);
			result.getImports().addAll(imports);
			result.getMetamodels().addAll(metamodels);
			result.getRenamings().addAll(renamings);
			result.getProperties().addAll(properties);
			result.getMethods().addAll(methods);
		}
		
		protected CSTNode createMappingQueryCS(MappingDeclarationCS sym, EList sym2) {
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
			VariableInitializationCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createVariableInitializationCS();
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
				IToken tokenText, TypeCS sym2) {
			ParameterDeclarationCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createParameterDeclarationCS();
			SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, tokenText.toString());
			setOffsets(nameCS, tokenText);
			result.setSimpleNameCS(nameCS);
			result.setTypeCS(sym2);
			if (sym != null) {
				result.setDirectionKind(sym.getDirectionKind());
			}
			return result;
		}
	
		protected CSTNode createDirectionKindCS(DirectionKindEnum kind) {
			DirectionKindCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createDirectionKindCS();
			result.setDirectionKind(kind);
			return result;
		}
	
		protected CSTNode createMappingDeclarationCS(DirectionKindCS directionKind,
				PathNameCS pathNameCS, EList parameters, TypeCS returnType) {
			MappingDeclarationCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createMappingDeclarationCS();
			if (directionKind != null) {
				result.setDirectionKind(directionKind.getDirectionKind());
			}
			result.setContextTypeAndName(pathNameCS);
			result.setReturnType(returnType);
			result.getParameters().addAll(parameters);
			String name = pathNameCS.getSequenceOfNames().get(pathNameCS.getSequenceOfNames().size()-1);
			result.setSimpleNameCS(createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, name));
			PathNameCS type = createParentPath(pathNameCS);
			if (type.getSequenceOfNames().size() > 0) {
				result.setContextType(type);
			}
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
	
		protected CSTNode createPatternPropertyCS(IToken tokenText,
				OCLExpressionCS sym, boolean b) {
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
			result.setPathNameCS(extractQualifiedName(sym));
			result.setOclExpressionCS(sym2);
			result.setIncremental(b);
			return result;
		}
		
	    private PathNameCS extractQualifiedName(OCLExpressionCS qualified) {
	    	if (qualified instanceof PathNameCS) {
	    		return (PathNameCS) qualified;
	    	}
	    	else if (qualified instanceof VariableExpCS) {
	    		PathNameCS result = CSTFactory.eINSTANCE.createPathNameCS();
	    		result.getSequenceOfNames().add(((VariableExpCS) qualified).getSimpleNameCS().getValue());
	    		result.setStartOffset(qualified.getStartOffset());
	    		result.setEndOffset(qualified.getEndOffset());
	    		return result;
	    	}
	    	else if (qualified instanceof FeatureCallExpCS) {
	    		FeatureCallExpCS callExp = (FeatureCallExpCS) qualified;
	    		if (callExp.getSource() == null) {
	    			return null;
	    		}
	    		PathNameCS prefix = extractQualifiedName(callExp.getSource());
	    		if (prefix == null) {
	    			return null;
	    		}
	    		PathNameCS result = CSTFactory.eINSTANCE.createPathNameCS();
	    		result.getSequenceOfNames().addAll(prefix.getSequenceOfNames());
	    		result.getSequenceOfNames().add(callExp.getSimpleNameCS().getValue());
	    		result.setStartOffset(qualified.getStartOffset());
	    		result.setEndOffset(qualified.getEndOffset());
	    		return result;
	    	}
	    	return null;
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
	
		protected OutExpCS createOutExpCS(EList expressions, TypeCS typeCS, int startOffset,
				int endOffset) {
			OutExpCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createOutExpCS();
			result.setTypeCS(typeCS);
			result.getExpressions().addAll(expressions);
			result.setBodyStartLocation(startOffset);
			result.setBodyEndLocation(endOffset);
			return result;
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
	
		protected CSTNode createResolveExpCS(OCLExpressionCS source, OCLExpressionCS condition) {
			ResolveExpCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createResolveExpCS();
			result.setSource(source);
			result.setOne(false);
	    	result.setIsInverse(false);
			result.setCondition(condition);
			return result;
		}
	
		protected CSTNode createWhileExpCS(OCLExpressionCS cond, OCLExpressionCS res, EList expressions) {
			WhileExpCS result = org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createWhileExpCS();
			result.setCondition(cond);
			result.setResult(res);
			result.getBodyExpressions().addAll(expressions);
			return result;
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

	mappingModuleCS ::= transformation qualifiedNameCS ';' 
				moduleImportListOpt metamodelListOpt renamingListOpt
				propertyListOpt mappingRuleListOpt
		/.$BeginJava
					CSTNode result = createMappingModuleCS(
							(PathNameCS)$getSym(2),
							(EList)$getSym(4),
							(EList)$getSym(5),
							(EList)$getSym(6),
							(EList)$getSym(7),
							(EList)$getSym(8)
						);
					int endOffset = getEndOffset(getIToken($getToken(3)), (EList)$getSym(4),
							(EList)$getSym(5), (EList)$getSym(6), (EList)$getSym(7), (EList)$getSym(8)); 
					setOffsets(result, getIToken($getToken(1)), new Token(0, endOffset, 0));
					$setResult(result);
		  $EndJava
		./

	libraryCS ::= library qualifiedNameCS ';' 
				moduleImportListOpt metamodelListOpt renamingListOpt
				propertyListOpt mappingRuleListOpt
		/.$BeginJava
					CSTNode result = createLibraryCS(
							(PathNameCS)$getSym(2),
							(EList)$getSym(4),
							(EList)$getSym(5),
							(EList)$getSym(6),
							(EList)$getSym(7),
							(EList)$getSym(8)
						);
					int endOffset = getEndOffset(getIToken(dtParser.getToken(3)), (EList)dtParser.getSym(4),
							(EList)dtParser.getSym(5), (EList)dtParser.getSym(6), (EList)dtParser.getSym(7), (EList)dtParser.getSym(8)); 
					setOffsets(result, getIToken(dtParser.getToken(1)), new Token(0, endOffset, 0));
					$setResult(result);
		  $EndJava
		./
		
	qualifiedNameCS ::= qvtIndentifierCS
		/.$BeginJava
					CSTNode result = createPathNameCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	qualifiedNameCS ::= qualifiedNameCS '.' qvtIndentifierCS
		/.$BeginJava
					PathNameCS result = (PathNameCS)$getSym(1);
					result = extendPathNameCS(result, getTokenText($getToken(3)));
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	
	scopedNameCS ::= simpleNameCS
		/.$BeginJava
					CSTNode result = createPathNameCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	scopedNameCS ::= scopedNameCS '::' simpleNameCS
		/.$BeginJava
					PathNameCS result = (PathNameCS)$getSym(1);
					result = extendPathNameCS(result, getTokenText($getToken(3)));
					setOffsets(result, result, (CSTNode)$getSym(3));
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
		
	metamodelCS ::= metamodel stringLiteralExpCS ';'
		/.$BeginJava
					CSTNode result = (CSTNode)$getSym(2);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
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

	renamingCS ::= rename typeCS '.' qvtIndentifierCS '=' stringLiteralExpCS ';' 
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
	
	modulePropertyCS ::= configuration property qvtIndentifierCS ':' typeCS ';' 
		/.$BeginJava
					CSTNode result = createConfigPropertyCS(
							getIToken($getToken(3)),
							(TypeCS)$getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(6)));
					$setResult(result);
		  $EndJava
		./
	modulePropertyCS ::= property qvtIndentifierCS ':' typeCS '=' oclExpressionCS ';' 
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
	modulePropertyCS ::= property qvtIndentifierCS '=' oclExpressionCS ';' 
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
	mappingRuleListOpt ::= mappingRuleList
	
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
	
	mappingRuleCS ::= mapping mappingDeclarationCS mappingGuardOpt '{' mappingInitOpt mappingBodyOpt mappingEndOpt '}'  
		/.$BeginJava
					MappingInitCS mappingInit = (MappingInitCS)$getSym(5);
					MappingBodyCS mappingBody = (MappingBodyCS)$getSym(6);
					MappingEndCS mappingEnd = (MappingEndCS)$getSym(7);
					int bodyLeft = (mappingInit == null ?  getIToken($getToken(4)).getEndOffset() : mappingInit.getEndOffset());
					int bodyRight = (mappingEnd == null ?  getIToken($getToken(8)).getEndOffset() : mappingEnd.getStartOffset());
					int outBodyRight = (mappingEnd == null ?  getIToken($getToken(8)).getStartOffset() : mappingEnd.getStartOffset());

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
	mappingRuleCS ::= query mappingDeclarationCS ';'  
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
		
	mappingDeclarationCS ::= directionKindOpt scopedNameCS '(' parameterListOpt ')' ':' typeCS
		/.$BeginJava
					DirectionKindCS directionKind = (DirectionKindCS)$getSym(1);
					CSTNode result = createMappingDeclarationCS(
							directionKind,
							(PathNameCS)$getSym(2),
							(EList)$getSym(4),
							(TypeCS)$getSym(7)
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
							(PathNameCS)$getSym(2),
							(EList)$getSym(4),
							null
						);
					setOffsets(result, (CSTNode)(directionKind == null ? $getSym(2) : directionKind), getIToken($getToken(5)));
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
		
	parameterDeclarationCS ::= directionKindOpt IDENTIFIER ':' typeCS
		/.$BeginJava
					CSTNode result = createParameterDeclarationCS(
							(DirectionKindCS)$getSym(1),
							getIToken($getToken(2)),
							(TypeCS)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(2)), (CSTNode)$getSym(4));
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
		
	statementListOpt ::= $empty
		/.$EmptyListAction./
	statementListOpt -> statementList
	statementListOpt -> statementList ';'
	
	statementList ::= statementCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	statementList ::= statementList ';' statementCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
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
	variableInitializationCS ::= var IDENTIFIER ':' typeCS
		/.$BeginJava
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(2)),
							(TypeCS)$getSym(4),
							createBooleanLiteralExpCS("undefined")
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
					$setResult(result);
		  $EndJava
		./
	variableInitializationCS ::= var IDENTIFIER
		/.$BeginJava
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(2)),
							null,
							createBooleanLiteralExpCS("undefined")
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
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
		
	mappingBodyOpt ::= $empty
		/.$BeginJava
					MappingBodyCS result = createMappingBodyCS(
							org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory.eINSTANCE.createOutExpCS(),
							true
						);
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
					CSTNode head = (CSTNode) props.get(0);
					CSTNode tail = (CSTNode) props.get(props.size()-1);
					OutExpCS outExp = createOutExpCS(props, null, head.getStartOffset(), tail.getEndOffset());
					setOffsets(outExp, head, tail);
					MappingBodyCS result = createMappingBodyCS(
							outExp,
							true
						);
					setOffsets(result, outExp);
					$setResult(result);
		  $EndJava
		./
	
	patternPropertyOrAdditionList -> patternPropertyOrAdditionInnerList
	patternPropertyOrAdditionList -> patternPropertyOrAdditionList ';'
	
	patternPropertyOrAdditionInnerList ::= patternPropertyOrAddition
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	patternPropertyOrAdditionInnerList ::= patternPropertyOrAdditionList ';' patternPropertyOrAddition
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
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
	
	outExpCS ::= object typeCS '{' patternPropertyOrAdditionList '}' 
		/.$BeginJava
					CSTNode result = createOutExpCS(
							(EList)$getSym(4),
							(TypeCS)$getSym(2),
							getIToken($getToken(3)).getEndOffset(),
							getIToken($getToken(5)).getStartOffset()
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	outExpCS ::= object typeCS '{' '}' 
		/.$BeginJava
					CSTNode result = createOutExpCS(
							$EMPTY_ELIST,
							(TypeCS)$getSym(2),
							getIToken($getToken(3)).getEndOffset(),
							getIToken($getToken(4)).getStartOffset()
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	outExpCS ::= object '{' patternPropertyOrAdditionList '}' 
		/.$BeginJava
					CSTNode result = createOutExpCS(
							(EList)$getSym(3),
							null,
							getIToken($getToken(2)).getEndOffset(),
							getIToken($getToken(4)).getStartOffset()
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	outExpCS ::= object '{' '}' 
		/.$BeginJava
					CSTNode result = createOutExpCS(
							$EMPTY_ELIST,
							null,
							getIToken($getToken(2)).getEndOffset(),
							getIToken($getToken(3)).getStartOffset()
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
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
		
	oclExpCS -> resolveExpCS

	resolveExpCS ::= oclExpressionCS '.' resolve '(' typeCS ')'
		/.$BeginJava
					CSTNode result = createResolveExpCS(
							(OCLExpressionCS)$getSym(1),
							(TypeCS)$getSym(4)
						);
						
				if (dtParser.getSym(4) != null) {
				    System.out.println("QvtOpLPGParser.ruleAction()");
				}
						
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./

	whileExpCS ::= while '(' oclExpressionCS ';' oclExpressionCS ')' '{' expressionListOpt '}'
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

		
	-- literal extension in QVT
	literalExpCS -> undefinedLiteralExpCS
	
	undefinedLiteralExpCS ::= undefined
		/.$BeginJava
					CSTNode result = createNullLiteralExpCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./


	-- keyword-as-identifier extension in QVT
	--------
	keywordAsIdentifier -> 	undefined

	-- keywordAsIdentifier2 -> inv
	-- keywordAsIdentifier2 -> pre
	-- keywordAsIdentifier2 -> post
	-- keywordAsIdentifier2 -> context
	-- keywordAsIdentifier2 -> package
	-- keywordAsIdentifier2 -> endpackage
	-- keywordAsIdentifier2 -> def
	-- keywordAsIdentifier2 -> attr
	-- keywordAsIdentifier2 -> oper

	qvtIndentifierCS -> IDENTIFIER
	qvtIndentifierCS -> keywordAsIdentifier1
	qvtIndentifierCS -> keywordAsIdentifier2
	
$End

