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
-- * $Id: ImperativeOCL.g,v 1.26 2009/05/13 13:48:57 aigdalov Exp $ 
-- */
--
-- The QVT Operational Parser
--
$Import
	miscellaneous.g


$DropRules
	-- 'if' extension in QVT
	ifExpCSPrec -> ifExpCS
	ifExpCS ::= if oclExpressionCS then oclExpressionCS else oclExpressionCS endif
$End

$Globals
	/.	
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
	./
$End

$Terminals

	COLONCOLONEQUAL    ::= '::='

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
	List
	Dict
	break
	continue
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
 * $Id: ImperativeOCL.g,v 1.26 2009/05/13 13:48:57 aigdalov Exp $
 */
	./
$End

$Rules

	-- opt = optional
	-- m = multiple

	typeCS -> listTypeCS
	listTypeCS ::= List '(' typeCS ')'
		/.$BeginJava
					CSTNode result = createListTypeCS(
							(TypeCS)$getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

	listLiteralCS ::= List '{' collectionLiteralPartsCSopt '}'
		/.$BeginJava
					CSTNode result = createListLiteralExpCS((EList)$getSym(3));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./ 
	
	typeCS -> dictTypeCS
	dictTypeCS ::= Dict '(' typeCS ',' typeCS ')'
		/.$BeginJava
					CSTNode result = createDictTypeCS((TypeCS)$getSym(3), (TypeCS)$getSym(5));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(6)));
					$setResult(result);
		  $EndJava
		./	

	dictLiteralCS ::= Dict '{' dictLiteralPartListCSopt '}'
		/.$BeginJava
					CSTNode result = createDictLiteralExpCS((EList<DictLiteralPartCS>)$getSym(3));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./ 
	
	literalSimpleCS -> primitiveLiteralExpCS
	literalSimpleCS -> nullLiteralExpCS	
	literalExpCS -> listLiteralCS
	literalExpCS -> dictLiteralCS
	
	dictLiteralPartCS ::= literalSimpleCS '=' oclExpressionCS
		/.$BeginJava
					CSTNode result = createDictLiteralPartCS((LiteralExpCS)$getSym(1), (OCLExpressionCS)$getSym(3));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	
	dictLiteralPartListCSopt -> dictLiteralPartListCS	
	dictLiteralPartListCSopt ::= $empty
		/.$EmptyListAction./
		
	dictLiteralPartListCS ::= dictLiteralPartCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	dictLiteralPartListCS ::= dictLiteralPartListCS ',' dictLiteralPartCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
	dictLiteralPartListCS ::= dictLiteralPartListCS qvtErrorToken
		/.$BeginJava
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndJava
		./

	oclExpressionCS -> returnExpCS 	
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
	 
	expression_semi_list_element -> var_init_group_exp

	var_init_group_exp ::= var var_init_declarator_list
		/.$BeginJava
					$setResult($getSym(2));
		  $EndJava
		./

	var_init_group_exp ::= var '(' var_init_declarator_list ')'
		/.$BeginJava
					$setResult($getSym(3));
		  $EndJava
		./

	var_init_group_exp ::= var '(' var_init_declarator_list qvtErrorToken
		/.$BeginJava
					$setResult($getSym(3));
		  $EndJava
		./

	oclExpressionCS -> var_init_exp

	var_init_exp ::= var var_init_declarator
		/.$BeginJava
					$setResult($getSym(2));
		  $EndJava
		./

	var_init_exp ::= var '(' var_init_declarator ')'
		/.$BeginJava
					$setResult($getSym(3));
		  $EndJava
		./

	var_init_exp ::= var '(' var_init_declarator qvtErrorToken
		/.$BeginJava
					$setResult($getSym(3));
		  $EndJava
		./

	var_init_exp ::= var qvtErrorToken
		/.$BeginJava
					$setResult($EMPTY_ELIST);
		  $EndJava
		./

	var_init_declarator_list ::= var_init_declarator ',' var_init_declarator
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
	var_init_declarator_list ::= var_init_declarator_list ',' var_init_declarator
		/.$BeginJava
					EList result = (EList) $getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./


	var_init_declarator ::= IDENTIFIER ':' typeCS var_init_op oclExpressionCS
		/.$BeginJava
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(1)),
							(TypeCS)$getSym(3),
							(OCLExpressionCS)$getSym(5),
							(Boolean)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(5));
					$setResult(result);
		  $EndJava
		./
	var_init_declarator ::= IDENTIFIER ':' typeCS var_init_op qvtErrorToken
		/.$BeginJava
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(1)),
							(TypeCS)$getSym(3),
							null,
							(Boolean)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	var_init_declarator ::= IDENTIFIER var_init_op oclExpressionCS
		/.$BeginJava
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(1)),
							null,
							(OCLExpressionCS)$getSym(3),
							(Boolean)$getSym(2)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./
	var_init_declarator ::= IDENTIFIER var_init_op qvtErrorToken
		/.$BeginJava
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(1)),
							null,
							null,
							(Boolean)$getSym(2)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	var_init_declarator ::= IDENTIFIER ':' typeCS
		/.$BeginJava
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(1)),
							(TypeCS)$getSym(3),
							null,
							false
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./
	var_init_declarator ::= IDENTIFIER ':' qvtErrorToken
		/.$BeginJava
					CSTNode result = createVariableInitializationCS(
							getIToken($getToken(1)),
							null,
							null,
							false
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
		
	var_init_op ::= '='
		/.$NewCase./
	var_init_op ::= ':='
		/.$BeginJava
					$setResult(false);
		  $EndJava
		./
	var_init_op ::= '::='
		/.$BeginJava
					$setResult(true);
		  $EndJava
		./

	oclExpressionCS -> assignStatementCS

	assignStatementCS ::= dotArrowExpCS ':=' oclExpressionCS
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
	assignStatementCS ::= dotArrowExpCS ':=' qvtErrorToken
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

	assignStatementCS ::= dotArrowExpCS '+=' oclExpressionCS
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
	assignStatementCS ::= dotArrowExpCS '+=' qvtErrorToken
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


	whileExpCS ::= while '(' declarator1 ';' oclExpressionCS ')' whileBodyCS
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

	whileExpCS ::= while '(' assignStatementCS ';' oclExpressionCS ')' whileBodyCS
		/.$BeginJava
					AssignStatementCS assignment = (AssignStatementCS)$getSym(3);
					CSTNode result = createWhileExpCS(
							getVariableFromAssignment(assignment),
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
	

	----- ifExp (start) -----
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
					OCLExpressionCS invalidCondition = createInvalidLiteralExpCS(""); //$NON-NLS-1$
					invalidCondition.setStartOffset(getIToken($getToken(1)).getEndOffset());
					invalidCondition.setEndOffset(getIToken($getToken(1)).getEndOffset());
					CSTNode result = createIfExpCS(
							invalidCondition,
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	oclExpCS -> ifExpCS
	----- ifExp (end) -----

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

	switchAltExpCS ::= case '(' oclExpressionCS ')' expression_statement
		/.$BeginJava
					CSTNode result = createSwitchAltExpCS(
							(OCLExpressionCS) $getSym(3),
							(OCLExpressionCS) $getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	switchAltExpCS ::= case '(' oclExpressionCS ')' qvtErrorToken
		/.$BeginJava
					CSTNode result = createSwitchAltExpCS(
							(OCLExpressionCS) $getSym(3),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	
	switchElseExpCSOpt ::= $empty
		/.$NullAction./
	switchElseExpCSOpt -> switchElseExpCS

	switchElseExpCS ::= else expression_statement
		/.$BeginJava
					$setResult((CSTNode)$getSym(2));
		  $EndJava
		./
	switchElseExpCS ::= else qvtErrorToken
		/.$BeginJava
					$setResult(null);
		  $EndJava
		./

	----- switch -----

	oclExpressionCS ::= primaryOCLExpressionCS 
		/.$BeginJava
					CSTNode result = createExpressionStatementCS(
							(OCLExpressionCS)$getSym(1)
						);
					setOffsets(result, (CSTNode)$getSym(1));
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
		        String opCode = isTokenOfType(getIToken($getToken(3)), $sym_type.TK_EXCLAMATION_MARK) ?  "collectselectOne" : "collectselect"; //$NON-NLS-1$ //$NON-NLS-2$ 
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
				        String opCode = isTokenOfType(getIToken($getToken(2)), $sym_type.TK_EXCLAMATION_MARK) ?  "selectOne" : "xselect"; //$NON-NLS-1$ //$NON-NLS-2$ 
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


				        String opCode = isTokenOfType(getIToken($getToken(4)), $sym_type.TK_EXCLAMATION_MARK) ?  "selectOne" : "xselect"; //$NON-NLS-1$ //$NON-NLS-2$ 
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

	oclExpCS -> newExpCS
	newExpCS ::= new typespec '(' argumentsCSopt ')' 
		/.$BeginJava
				OCLExpressionCS result = createNewRuleCallExpCS((TypeSpecCS) $getSym(2), (EList) $getSym(4));
				setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
				$setResult(result);
		  $EndJava
		./	

		
	-- imperative BreakExp and ContinueExp registration
		
	oclExpCS ::= break
		/.$BeginJava
				OCLExpressionCS result = createBreakCS();
				setOffsets(result, getIToken($getToken(1)));
				$setResult(result);
		  $EndJava
		./	
	
	oclExpCS ::= continue
		/.$BeginJava
				OCLExpressionCS result = createContinueCS();
				setOffsets(result, getIToken($getToken(1)));
				$setResult(result);
		  $EndJava
		./	

	--=== Non-standard extensions and legacy support (start) ===--
	switchAltExpCS ::= '(' oclExpressionCS ')' '?' oclExpressionCS ';'
		/.$BeginJava
					CSTNode result = createSwitchAltExpCSDeprecated(
							(OCLExpressionCS) $getSym(2),
							(OCLExpressionCS) $getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(6)));
					$setResult(result);
		  $EndJava
		./
	switchAltExpCS ::= '(' oclExpressionCS ')' qvtErrorToken
		/.$BeginJava
					CSTNode result = createSwitchAltExpCSDeprecated(
							(OCLExpressionCS) $getSym(2),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	switchAltExpCS ::= '(' qvtErrorToken
		/.$BeginJava
					CSTNode result = createSwitchAltExpCSDeprecated(
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	switchElseExpCS ::= else '?' oclExpressionCS ';'
		/.$BeginJava
			    	int startOffset = getIToken($getToken(1)).getStartOffset();
			    	int endOffset = getIToken($getToken(4)).getEndOffset();
					reportWarning(org.eclipse.osgi.util.NLS.bind(org.eclipse.m2m.internal.qvt.oml.cst.parser.Messages.AbstractQVTParser_DeprecatedSwitchElseExp, null), startOffset, endOffset);
					
					$setResult((CSTNode)$getSym(3));
		  $EndJava
		./
	switchElseExpCS ::= else '?' oclExpressionCS qvtErrorToken
		/.$BeginJava
			    	int startOffset = getIToken($getToken(1)).getStartOffset();
			    	int endOffset = getIToken($getToken(3)).getEndOffset();
					reportWarning(org.eclipse.osgi.util.NLS.bind(org.eclipse.m2m.internal.qvt.oml.cst.parser.Messages.AbstractQVTParser_DeprecatedSwitchElseExp, null), startOffset, endOffset);
					
					$setResult((CSTNode)$getSym(3));
		  $EndJava
		./
	--=== Non-standard extensions and legacy support (end) ===--
$End