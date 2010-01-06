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
-- * $Id: ImperativeOCL.gi,v 1.1 2010/01/06 18:56:13 sboyko Exp $ 
-- */
--
-- The Imperative OCL Parser
--

%Import
	miscellaneous.gi


%DropRules
	-- 'if' extension in QVTo
	IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS endif

%End

%Globals
	/.	
	import org.eclipse.ocl.ParserException;
	import lpg.runtime.Token;
	import lpg.runtime.BacktrackingParser;
	import lpg.runtime.PrsStream;
	import lpg.runtime.NotBacktrackParseTableException;
	import lpg.runtime.NullExportedSymbolsException;
	import lpg.runtime.NullTerminalSymbolsException;
	import lpg.runtime.UndefinedEofSymbolException;
	import lpg.runtime.UnimplementedTerminalsException;
	import org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS;	
	import org.eclipse.m2m.internal.qvt.oml.cst.LogExpCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS;	
	import org.eclipse.m2m.internal.qvt.oml.cst.ReturnExpCS;	
	import org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.temp.ScopedNameCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.temp.TempFactory;
	import org.eclipse.m2m.internal.qvt.oml.cst.ForExpCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeIterateExpCS;
	./
%End


%Notice
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
 *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (297966)
 *
 * </copyright>
 *
 */
	./
%End


%KeyWords
	Dict
	List
	break
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
	var
	while
	continue
	log
	assert
	with
	compute
	new

%End

%Terminals
	RESET_ASSIGN      ::= ':='
	ADD_ASSIGN        ::= '+='
	EXCLAMATION_MARK  ::= '!'
	NOT_EQUAL_EXEQ    ::= '!='
	AT_SIGN           ::= '@'
	COLONCOLONEQUAL   ::= '::='
	QUESTIONMARK      ::= '?'

	SINGLE_LINE_COMMENT MULTI_LINE_COMMENT
%End

%Rules
	-- opt = optional
	-- m = multiple

	typeCS -> listTypeCS
	listTypeCS ::= List '(' typeCS ')'
		/.$BeginCode
					CSTNode result = createListTypeCS(
							(TypeCS)$getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./

	listLiteralCS ::= List '{' CollectionLiteralPartsCSopt '}'
		/.$BeginCode
					CSTNode result = createListLiteralExpCS((EList)$getSym(3));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./ 
	
	typeCS -> dictTypeCS
	dictTypeCS ::= Dict '(' typeCS ',' typeCS ')'
		/.$BeginCode
					CSTNode result = createDictTypeCS((TypeCS)$getSym(3), (TypeCS)$getSym(5));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(6)));
					$setResult(result);
		  $EndCode
		./	

	dictLiteralCS ::= Dict '{' dictLiteralPartListCSopt '}'
		/.$BeginCode
					CSTNode result = createDictLiteralExpCS((EList<DictLiteralPartCS>)$getSym(3));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./ 
	
	literalSimpleCS -> PrimitiveLiteralExpCS
	LiteralExpCS -> listLiteralCS
	LiteralExpCS -> dictLiteralCS
	
	dictLiteralPartCS ::= literalSimpleCS '=' OclExpressionCS
		/.$BeginCode
					CSTNode result = createDictLiteralPartCS((LiteralExpCS)$getSym(1), (OCLExpressionCS)$getSym(3));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./
	
	dictLiteralPartListCSopt -> dictLiteralPartListCS	
	dictLiteralPartListCSopt ::= %empty
		/.$EmptyListAction./
		
	dictLiteralPartListCS ::= dictLiteralPartCS
		/.$BeginCode
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndCode
		./
	dictLiteralPartListCS ::= dictLiteralPartListCS ',' dictLiteralPartCS
		/.$BeginCode
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndCode
		./
	dictLiteralPartListCS ::= dictLiteralPartListCS qvtErrorToken
		/.$BeginCode
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndCode
		./

	OclExpressionCS -> returnExpCS 	
	returnExpCS ::= return oclExpressionCSOpt
		/.$BeginCode
				ReturnExpCS returnExpCS = createReturnExpCS((OCLExpressionCS)$getSym(2));
				CSTNode result = createExpressionStatementCS(returnExpCS);
				if(returnExpCS.getValue() != null) {
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(2));			
				} else {
					setOffsets(result, getIToken($getToken(1)));
				}
				setOffsets(returnExpCS, result);
				$setSym1(result);
		  $EndCode
		./
	 
	expression_semi_list_element -> var_init_group_exp

	var_init_group_exp ::= var var_init_declarator_list
		/.$BeginCode
					$setResult($getSym(2));
		  $EndCode
		./

	var_init_group_exp ::= var '(' var_init_declarator_list ')'
		/.$BeginCode
					$setResult($getSym(3));
		  $EndCode
		./

	var_init_group_exp ::= var '(' var_init_declarator_list qvtErrorToken
		/.$BeginCode
					$setResult($getSym(3));
		  $EndCode
		./

	OclExpressionCS -> var_init_exp

	var_init_exp ::= var var_init_declarator
		/.$BeginCode
					$setResult($getSym(2));
		  $EndCode
		./

	var_init_exp ::= var '(' var_init_declarator ')'
		/.$BeginCode
					$setResult($getSym(3));
		  $EndCode
		./

	var_init_exp ::= var '(' var_init_declarator qvtErrorToken
		/.$BeginCode
					$setResult($getSym(3));
		  $EndCode
		./

	var_init_exp ::= var qvtErrorToken
		/.$BeginCode
					$setResult($EMPTY_ELIST);
		  $EndCode
		./

	var_init_declarator_list ::= var_init_declarator ',' var_init_declarator
		/.$BeginCode
					EList result = new BasicEList();
					result.add($getSym(1));
					result.add($getSym(3));
					$setResult(result);
		  $EndCode
		./
	var_init_declarator_list ::= var_init_declarator_list ',' var_init_declarator
		/.$BeginCode
					EList result = (EList) $getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndCode
		./


	var_init_declarator ::= IDENTIFIER ':' typeCS var_init_op OclExpressionCS
		/.$BeginCode
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(1)),
							(TypeCS)$getSym(3),
							(OCLExpressionCS)$getSym(5),
							(Boolean)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(5));
					$setResult(result);
		  $EndCode
		./
	var_init_declarator ::= IDENTIFIER ':' typeCS var_init_op qvtErrorToken
		/.$BeginCode
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(1)),
							(TypeCS)$getSym(3),
							null,
							(Boolean)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./
	var_init_declarator ::= IDENTIFIER var_init_op OclExpressionCS
		/.$BeginCode
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(1)),
							null,
							(OCLExpressionCS)$getSym(3),
							(Boolean)$getSym(2)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndCode
		./
	var_init_declarator ::= IDENTIFIER var_init_op qvtErrorToken
		/.$BeginCode
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(1)),
							null,
							null,
							(Boolean)$getSym(2)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./
	var_init_declarator ::= IDENTIFIER ':' typeCS
		/.$BeginCode
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(1)),
							(TypeCS)$getSym(3),
							null,
							false
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndCode
		./
	var_init_declarator ::= IDENTIFIER ':' qvtErrorToken
		/.$BeginCode
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(1)),
							null,
							null,
							false
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./
		
	var_init_op ::= '='
		/.$NewCase./
	var_init_op ::= ':='
		/.$BeginCode
					$setResult(false);
		  $EndCode
		./
	var_init_op ::= '::='
		/.$BeginCode
					$setResult(true);
		  $EndCode
		./

	OclExpressionCS -> assignStatementCS

	assignStatementCS ::= primaryExpCS ':=' OclExpressionCS
		/.$BeginCode
					CSTNode result = createAssignStatementCS(
							(OCLExpressionCS)$getSym(1),
							(OCLExpressionCS)$getSym(3),
							false
						);
					setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndCode
		./
	assignStatementCS ::= primaryExpCS ':=' qvtErrorToken
		/.$BeginCode
					CSTNode result = createAssignStatementCS(
							(OCLExpressionCS)$getSym(1),
							createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, (IToken) null),
							false
						);
					setOffsets(result, (CSTNode)$getSym(1), getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./

	assignStatementCS ::= primaryExpCS '+=' OclExpressionCS
		/.$BeginCode
					CSTNode result = createAssignStatementCS(
							(OCLExpressionCS)$getSym(1),
							(OCLExpressionCS)$getSym(3),
							true
						);
					setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndCode
		./
	assignStatementCS ::= primaryExpCS '+=' qvtErrorToken
		/.$BeginCode
					CSTNode result = createAssignStatementCS(
							(OCLExpressionCS)$getSym(1),
							createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, (IToken) null),
							true
						);
					setOffsets(result, (CSTNode)$getSym(1), getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./


	whileBodyCS -> expression_block


	whileExpCS ::= while '(' declarator1 ';' OclExpressionCS ')' whileBodyCS
		/.$BeginCode
					CSTNode result = createWhileExpCS(
							(VariableCS)$getSym(3),
							(OCLExpressionCS)$getSym(5),
							(BlockExpCS)$getSym(7)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(7));
					$setResult(result);
		  $EndCode
		./

	whileExpCS ::= while '(' assignStatementCS ';' OclExpressionCS ')' whileBodyCS
		/.$BeginCode
					AssignStatementCS assignment = (AssignStatementCS)$getSym(3);
					CSTNode result = createWhileExpCS(
							getVariableFromAssignment(assignment),
							(OCLExpressionCS)$getSym(5),
							(BlockExpCS)$getSym(7)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(7));
					$setResult(result);
		  $EndCode
		./

	whileExpCS ::= while '(' OclExpressionCS ')' whileBodyCS
		/.$BeginCode
					CSTNode result = createWhileExpCS(
							null,
							(OCLExpressionCS)$getSym(3),
							(BlockExpCS)$getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(5));
					$setResult(result);
		  $EndCode
		./
	
	-- ForExp begin

	IteratorExpCS ::= primaryExpCS '->' forExpCS
		/.$BeginCode
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					ForExpCS forExpCS = (ForExpCS)$getSym(3);
					forExpCS.setSource(source);
					setOffsets(forExpCS, source, forExpCS);
					$setResult(forExpCS);
		  $EndCode
		./

	forOpCode -> forEach
	forOpCode -> forOne

	forExpDeclaratorList ::= IDENTIFIER
        	/.$BeginCode
			EList result = new BasicEList();
			result.add(getIToken($getToken(1)));
			$setResult(result);
	          $EndCode
        	./
	forExpDeclaratorList ::= forExpDeclaratorList ',' IDENTIFIER
        	/.$BeginCode
			EList result = (EList)$getSym(1);
			result.add(getIToken($getToken(3)));
			$setResult(result);
	          $EndCode
        	./


	forExpConditionOpt ::= %empty
        	/.$NullAction./
        
	forExpConditionOpt ::= '|' OclExpressionCS
        	/.$BeginCode
                	    $setResult((OCLExpressionCS)$getSym(2));
	          $EndCode
        	./

	forExpConditionOpt ::= '|' qvtErrorToken
        	/.$NullAction./

	forExpCS ::= forOpCode '(' forExpDeclaratorList forExpConditionOpt ')' expression_block
		/.$BeginCode
					CSTNode result = createForExpCS(
							getIToken($getToken(1)),
							(EList)$getSym(3),
							(OCLExpressionCS)$getSym(4),
							(BlockExpCS)$getSym(6)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(6));
					$setResult(result);
		  $EndCode
		./

	forExpCS ::= forOpCode qvtErrorToken
		/.$BeginCode
					CSTNode result = createForExpCS(
							getIToken($getToken(1)),
							null,
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./

	-- ForExp end

	-- operation call and expression extension in QVT

	primaryNotNameCS -> whileExpCS
	

	----- ifExp (start) -----
	ifExpBodyCS -> OclExpressionCS
	ifExpBodyCS -> expression_block

	IfExpCS ::= if OclExpressionCS then ifExpBodyCS else ifExpBodyCS endif
		/.$BeginCode
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							(OCLExpressionCS)$getSym(4),
							(OCLExpressionCS)$getSym(6)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
					$setResult(result);
		  $EndCode
		./

	IfExpCS ::= if OclExpressionCS then ifExpBodyCS endif
		/.$BeginCode
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							(OCLExpressionCS)$getSym(4),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndCode
		./

	IfExpCS ::= if OclExpressionCS then ifExpBodyCS else ifExpBodyCS qvtErrorToken
		/.$BeginCode
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							(OCLExpressionCS)$getSym(4),
							(OCLExpressionCS)$getSym(6)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(6));
					$setResult(result);
		  $EndCode
		./

	IfExpCS ::= if OclExpressionCS then ifExpBodyCS else qvtErrorToken
		/.$BeginCode
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							(OCLExpressionCS)$getSym(4),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndCode
		./

	IfExpCS ::= if OclExpressionCS then ifExpBodyCS qvtErrorToken
		/.$BeginCode
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							(OCLExpressionCS)$getSym(4),
							null
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
					$setResult(result);
		  $EndCode
		./

	IfExpCS ::= if OclExpressionCS then qvtErrorToken
		/.$BeginCode
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./

	IfExpCS ::= if OclExpressionCS qvtErrorToken
		/.$BeginCode
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(2));
					$setResult(result);
		  $EndCode
		./


	IfExpCS ::= if qvtErrorToken
		/.$BeginCode
					OCLExpressionCS invalidCondition = createInvalidLiteralExpCS("");
					invalidCondition.setStartOffset(getIToken($getToken(1)).getEndOffset());
					invalidCondition.setEndOffset(getIToken($getToken(1)).getEndOffset());
					CSTNode result = createIfExpCS(
							invalidCondition,
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./

	----- ifExp (end) -----

	----- switch -----

	primaryNotNameCS -> switchExpCS

	switchExpCS ::= switch switchBodyExpCS
		/.$BeginCode
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
		  $EndCode
		./

	switchDeclaratorCS -> declarator

	switchDeclaratorCS ::= IDENTIFIER
		/.$BeginCode
					CSTNode result = createVariableCS(
							getIToken($getToken(1)),
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./

	switchDeclaratorCS ::= IDENTIFIER '=' OclExpressionCS
		/.$BeginCode
					CSTNode result = createVariableCS(
							getIToken($getToken(1)),
							null,
							(OCLExpressionCS)$getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndCode
		./

	-- 'collect' shorthand for switch keyword 
	IterateExpCS ::= primaryExpCS '->' switch '(' switchDeclaratorCS ')' switchBodyExpCS
		/.$BeginCode
					Object[] switchBody = (Object[]) $getSym(7);

					OCLExpressionCS switchExpCS = (OCLExpressionCS) createSwitchExpCS(
							(EList<SwitchAltExpCS>) switchBody[0],
							(OCLExpressionCS) switchBody[1]							
						);
					if (switchBody[2] instanceof IToken) { // In case of correct and incorrect syntax
						setOffsets(switchExpCS, getIToken($getToken(3)), (IToken) switchBody[2]);
					} else if (switchBody[2] instanceof CSTNode) { // In case of errors in switchBody
						setOffsets(switchExpCS, getIToken($getToken(3)), (CSTNode) switchBody[2]);
					} else { // In case of errors in switchBody
						setOffsets(switchExpCS, getIToken($getToken(3)), getIToken($getToken(6)));
					}

					EList<VariableCS> iterators = new BasicEList<VariableCS>();
					iterators.add((VariableCS) $getSym(5));
					CallExpCS result = createImperativeIterateExpCS(
							createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "xcollect"), 
							iterators,
							null,
							switchExpCS,
							null
						);
						
					result.setSource((OCLExpressionCS) $getSym(1));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
					
					$setResult(result);
		  $EndCode
		./

	switchExpCS ::= switch qvtErrorToken
		/.$BeginCode
					CSTNode result = createSwitchExpCS(
							new BasicEList(),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./

	switchBodyExpCS ::= '{' switchAltExpCSList switchElseExpCSOpt '}'
		/.$BeginCode
					Object[] result = new Object[] {$getSym(2), $getSym(3), getIToken($getToken(4))};
					$setResult(result);
		  $EndCode
		./

	switchBodyExpCS ::= '{' switchAltExpCSList switchElseExpCSOpt qvtErrorToken
		/.$BeginCode
					Object[] result = new Object[] {$getSym(2), $getSym(3), $getSym(3)};
					$setResult(result);
		  $EndCode
		./

	switchBodyExpCS ::= '{' qvtErrorToken
		/.$BeginCode
					Object[] result = new Object[] {new BasicEList(), null, getIToken($getToken(1))};
					$setResult(result);
		  $EndCode
		./

	switchAltExpCSList ::= switchAltExpCS
		/.$BeginCode
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndCode
		./
	switchAltExpCSList ::= switchAltExpCSList switchAltExpCS
		/.$BeginCode
					EList result = (EList)$getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndCode
		./

	switchAltExpCS ::= case '(' OclExpressionCS ')' expression_statement
		/.$BeginCode
					CSTNode result = createSwitchAltExpCS(
							(OCLExpressionCS) $getSym(3),
							(OCLExpressionCS) $getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndCode
		./
	switchAltExpCS ::= case '(' OclExpressionCS ')' qvtErrorToken
		/.$BeginCode
					CSTNode result = createSwitchAltExpCS(
							(OCLExpressionCS) $getSym(3),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./
	
	switchElseExpCSOpt ::= %empty
		/.$NullAction./
	switchElseExpCSOpt -> switchElseExpCS

	switchElseExpCS ::= else expression_statement
		/.$BeginCode
					$setResult((CSTNode)$getSym(2));
		  $EndCode
		./
	switchElseExpCS ::= else qvtErrorToken
		/.$BeginCode
					$setResult(null);
		  $EndCode
		./

	----- switch -----

	OclExpressionCS ::= primaryOCLExpressionCS 
		/.$BeginCode
					CSTNode result = createExpressionStatementCS(
							(OCLExpressionCS)$getSym(1)
						);
					setOffsets(result, (CSTNode)$getSym(1));
					$setResult(result);
		  $EndCode
		./

	-- log expression call
	primaryOCLExpressionCS -> logExpCS
	
		
	logWhenExp ::= when OclExpressionCS
        /.$BeginCode
				OCLExpressionCS condition = (OCLExpressionCS) $getSym(2);
				$setResult(condition);
          $EndCode
        ./	
	
	logWhenExpOpt -> logWhenExp			
	logWhenExpOpt ::= %empty
	/.$NullAction./		
		
	logExpCS ::= log '(' argumentsCSopt ')' logWhenExpOpt
        /.$BeginCode
				OCLExpressionCS condition = (OCLExpressionCS) $getSym(5);
				LogExpCS result = (LogExpCS)createLogExpCS((EList<OCLExpressionCS>)$getSym(3), condition);
				if(condition != null) {
					setOffsets(result, getIToken($getToken(1)), condition);
				} else {
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
				}
				$setResult(result);
          $EndCode
        ./

	-- assertion support	
	primaryOCLExpressionCS -> assertExpCS

	severityKindCS ::= simpleNameCS
		/.$BeginCode
				$setResult($getSym(1));
		  $EndCode
		./
		
	
	severityKindCSOpt -> severityKindCS
	
	severityKindCSOpt ::= %empty
	/.$NullAction./
	
	assertWithLogExp ::= with logExpCS
        /.$BeginCode
				LogExpCS logExp = (LogExpCS) $getSym(2);
				setOffsets(logExp, getIToken($getToken(2)), logExp);
				$setResult(logExp);
          $EndCode
        ./	
	
	assertWithLogExpOpt -> assertWithLogExp
	assertWithLogExpOpt ::= %empty
	/.$NullAction./
		        
	assertExpCS ::= assert severityKindCSOpt '(' OclExpressionCS ')' assertWithLogExpOpt
        /.$BeginCode
				LogExpCS logExpCS = (LogExpCS)$getSym(6);
				OCLExpressionCS condition = (OCLExpressionCS)$getSym(4);
				AssertExpCS result = (AssertExpCS)createAssertExpCS(condition, (SimpleNameCS)$getSym(2), logExpCS);
		
				CSTNode end = logExpCS != null ? logExpCS : condition; 
				setOffsets(result, getIToken($getToken(1)), end);
				$setResult(result);
          $EndCode
        ./


	-- ComputeExp start --

	computeExpCS ::= compute '(' declarator ')' expression_block
		/.$BeginCode
					CSTNode result = createComputeExpCS(
						(VariableCS) $getSym(3),
						(OCLExpressionCS) $getSym(5)
					);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndCode
		./


	primaryNotNameCS -> computeExpCS

	-- ComputeExp end --

	-- imperative iterators

	IterateExpCS ::= primaryExpCS '->' imperativeIterateExpCS
		/.$BeginCode
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					ImperativeIterateExpCS iterateExpCS = (ImperativeIterateExpCS) $getSym(3);
					iterateExpCS.setSource(source);
					setOffsets(iterateExpCS, source, iterateExpCS);
					$setResult(iterateExpCS);
		  $EndCode
		./
	--LoopExpCS -> imperativeIterateExpCS

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
		/.$BeginCode
					String opCode = getTokenText($getToken(1));
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.KEYWORD_LITERAL,
								getIToken($getToken(1))
							);
					setOffsets(simpleNameCS, getIToken($getToken(1)));
					Object[] iterContents = (Object[]) $getSym(3);
					OCLExpressionCS bodyCS = null;
					OCLExpressionCS conditionCS = null;
					if ("xcollect".equals(opCode) 
						|| "collectOne".equals(opCode)) { 
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
		  $EndCode
		./

	imperativeIterateExpCS ::= imperativeIteratorExpCSToken qvtErrorToken
		/.$BeginCode
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.KEYWORD_LITERAL,
								getIToken($getToken(1))
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
		  $EndCode
		./
		

	imperativeIterContents12 ::= OclExpressionCS
		/.$BeginCode
					$setResult(new Object[] {
							$EMPTY_ELIST,
							null,
							$getSym(1)
						});
		  $EndCode
		./
	
	imperativeIterContents12 ::= uninitializedVariableCS '|' OclExpressionCS
		/.$BeginCode
					EList iters = new BasicEList();
					iters.add($getSym(1));
					
					$setResult(new Object[] {
							iters,
							null,
							$getSym(3)
						});
		  $EndCode
		./

	imperativeIterContents12 ::= simpleNameCS ',' variableDeclarationListCS '|' OclExpressionCS
		/.$BeginCode
                    SimpleNameCS name = (SimpleNameCS)$getSym(1);
                    CSTNode variableCS = createVariableCS(name, null, null);
                    setOffsets(variableCS, name);

					EList iters = (EList) $getSym(3);
					iters.add(0, variableCS);
					
					$setResult(new Object[] {
							iters,
							null,
							$getSym(5)
						});
		  $EndCode
		./

	imperativeIterContents3 ::= variableDeclarationListCS ';' initializedVariableCS '|' OclExpressionCS
		/.$BeginCode
					$setResult(new Object[] {
							$getSym(1),
							$getSym(3),
							$getSym(5)
						});
		  $EndCode
		./

	variableDeclarationListCS ::= uninitializedVariableCS
		/.$BeginCode
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndCode
		./
	variableDeclarationListCS ::= variableDeclarationListCS ',' uninitializedVariableCS
		/.$BeginCode
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndCode
		./

	-- imperative iterators shorthand notation

	exclamationOpt ::= %empty
	        /.$NullAction./
	exclamationOpt -> '!'

	
	-- collectselect shorthand
	declarator_vsep ::= IDENTIFIER '|'
        	/.$BeginCode
			CSTNode result = createVariableCS(
						getIToken($getToken(1)),
                                                null,
						null
						);
                        setOffsets(result, getIToken($getToken(1)));
                        $setResult(result);
	          $EndCode
        	./

	declarator_vsepOpt ::= %empty
	        /.$NullAction./
	declarator_vsepOpt -> declarator_vsep

	-- xselect/collectselect shorthand
	IterateExpCS ::= primaryExpCS exclamationOpt '[' declarator_vsepOpt OclExpressionCS ']'
		/.$BeginCode
			OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
			if (source instanceof ImperativeIterateExpCS) {
				String opCode = isTokenOfType(getIToken($getToken(2)), $sym_type.TK_EXCLAMATION_MARK) 
					?  "collectselectOne" 
					: "collectselect"; 
				SimpleNameCS simpleNameCS = createSimpleNameCS(
						SimpleTypeEnum.KEYWORD_LITERAL,
						opCode
						);
				setOffsets(simpleNameCS, getIToken($getToken(3)), getIToken($getToken(6)));

				ImperativeIterateExpCS result = (ImperativeIterateExpCS) source;
				result.setSimpleNameCS(simpleNameCS);
				
				VariableCS variableCS = (VariableCS) $getSym(4);
		        if (variableCS != null) {
		            result.setTarget(variableCS);
		        }
		        result.setCondition((OCLExpressionCS) $getSym(5));
				
				setOffsets(result, getIToken($getToken(1)), getIToken($getToken(6)));
				$setResult(result);
			}
			else {
				String opCode = isTokenOfType(getIToken($getToken(2)), $sym_type.TK_EXCLAMATION_MARK) 
					?  "selectOne" 
					: "xselect"; 
				SimpleNameCS simpleNameCS = createSimpleNameCS(
						SimpleTypeEnum.KEYWORD_LITERAL,
						opCode
						);
				setOffsets(simpleNameCS, getIToken($getToken(3)), getIToken($getToken(6)));
				
				CallExpCS result = createImperativeIterateExpCS(
						simpleNameCS,
						$EMPTY_ELIST,
						(VariableCS) $getSym(4),
						null,
						(OCLExpressionCS) $getSym(5)
						);
				result.setSource(source);
				setOffsets(result, getIToken($getToken(1)), getIToken($getToken(6)));
				$setResult(result);
			}
		  $EndCode
		./

	-- xcollect shorthand
	IterateExpCS ::= primaryExpCS '->' simpleNameCS
		/.$BeginCode
			String opCode = "xcollect"; 
			SimpleNameCS simpleNameCS = createSimpleNameCS(
					SimpleTypeEnum.KEYWORD_LITERAL,
					opCode
					);

			OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
			SimpleNameCS featureNameCS = (SimpleNameCS)$getSym(3);
			OCLExpressionCS featureCallExpCS = createFeatureCallExpCS(
					source,
					null,
					featureNameCS,
					new BasicEList(),
					null
					);
			setOffsets(featureCallExpCS, source, featureNameCS);

			ImperativeIterateExpCS result = createImperativeIterateExpCS(
					simpleNameCS,
					$EMPTY_ELIST,
					null,
					null,
					null
					);
			result.setSource(featureCallExpCS);
			setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
			$setResult(result);
		  $EndCode
		./

	--primaryExpCS ::= primaryExpCS '.' FeatureCallExpCS exclamationOpt '[' OclExpressionCS ']'
	--	/.$BeginCode
	--				CallExpCS callExpCS = (CallExpCS)$getSym(3);
	--				callExpCS.setSource((OCLExpressionCS)$getSym(1));
	--				callExpCS.setAccessor(DotOrArrowEnum.DOT_LITERAL);
	--				setOffsets(callExpCS, (CSTNode)$getSym(1), callExpCS);
	--  
	--
	--			        String opCode = isTokenOfType(getIToken($getToken(4)), $sym_type.TK_EXCLAMATION_MARK)
	-- 	 					?  "selectOne" 
	--						: "xselect"; 
	--				SimpleNameCS simpleNameCS = createSimpleNameCS(
	--							SimpleTypeEnum.KEYWORD_LITERAL,
	--							opCode
	--						);
	--				setOffsets(simpleNameCS, getIToken($getToken(5)), getIToken($getToken(7)));
	--				CallExpCS result = createImperativeIterateExpCS(
	--						simpleNameCS,
	--						$EMPTY_ELIST,
	--						null,
	--						null,
	--						(OCLExpressionCS) $getSym(6)
	--					);
	--				result.setSource(callExpCS);
	--				setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
	--				$setResult(result);
	--	  $EndCode
	--	./

	primaryNotNameCS -> newExpCS
	newExpCS ::= new newTypespecCS '(' argumentsCSopt ')' 
		/.$BeginCode
				OCLExpressionCS result = createNewRuleCallExpCS((TypeSpecCS) $getSym(2), (EList) $getSym(4));
				setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
				$setResult(result);
		  $EndCode
		./	

	newTypespecCS ::= pathNameCS
		/.$BeginCode
					CSTNode result = createTypeSpecCS(
						(TypeCS)$getSym(1),
						null
						);
					$setResult(result);
		  $EndCode
		./
	
	newTypespecCS ::= pathNameCS '@' IDENTIFIER
		/.$BeginCode
					CSTNode result = createTypeSpecCS(
						(TypeCS)$getSym(1),
						getIToken($getToken(3))
						);
					$setResult(result);
		  $EndCode
		./

		
	-- imperative BreakExp and ContinueExp registration
		
	primaryNotNameCS ::= break
		/.$BeginCode
				OCLExpressionCS result = createBreakCS();
				setOffsets(result, getIToken($getToken(1)));
				$setResult(result);
		  $EndCode
		./	
	
	primaryNotNameCS ::= continue
		/.$BeginCode
				OCLExpressionCS result = createContinueCS();
				setOffsets(result, getIToken($getToken(1)));
				$setResult(result);
		  $EndCode
		./	

	--=== Non-standard extensions and legacy support (start) ===--
	switchAltExpCS ::= '(' OclExpressionCS ')' '?' OclExpressionCS ';'
		/.$BeginCode
					CSTNode result = createSwitchAltExpCSDeprecated(
							(OCLExpressionCS) $getSym(2),
							(OCLExpressionCS) $getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(6)));
					$setResult(result);
		  $EndCode
		./
	switchAltExpCS ::= '(' OclExpressionCS ')' qvtErrorToken
		/.$BeginCode
					CSTNode result = createSwitchAltExpCSDeprecated(
							(OCLExpressionCS) $getSym(2),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./
	switchAltExpCS ::= '(' qvtErrorToken
		/.$BeginCode
					CSTNode result = createSwitchAltExpCSDeprecated(
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./

	switchElseExpCS ::= else '?' OclExpressionCS ';'
		/.$BeginCode
			    	int startOffset = getIToken($getToken(1)).getStartOffset();
			    	int endOffset = getIToken($getToken(4)).getEndOffset();
					reportWarning(org.eclipse.m2m.internal.qvt.oml.cst.parser.NLS.bind(org.eclipse.m2m.internal.qvt.oml.cst.parser.Messages.AbstractQVTParser_DeprecatedSwitchElseExp, null), startOffset, endOffset);
					
					$setResult((CSTNode)$getSym(3));
		  $EndCode
		./
	switchElseExpCS ::= else '?' OclExpressionCS qvtErrorToken
		/.$BeginCode
			    	int startOffset = getIToken($getToken(1)).getStartOffset();
			    	int endOffset = getIToken($getToken(3)).getEndOffset();
					reportWarning(org.eclipse.m2m.internal.qvt.oml.cst.parser.NLS.bind(org.eclipse.m2m.internal.qvt.oml.cst.parser.Messages.AbstractQVTParser_DeprecatedSwitchElseExp, null), startOffset, endOffset);
					
					$setResult((CSTNode)$getSym(3));
		  $EndCode
		./
	--=== Non-standard extensions and legacy support (end) ===--

%End
