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
-- * $Id: ImperativeOCL.g,v 1.9 2008/11/28 14:36:54 aigdalov Exp $ 
-- */
--
-- The QVT Operational Parser
--
$Import
	miscellaneous.g

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
	import org.eclipse.m2m.internal.qvt.oml.cst.LogExpCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS;	
	import org.eclipse.m2m.internal.qvt.oml.cst.ReturnExpCS;	
	import org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.temp.ScopedNameCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.temp.TempFactory;
	./
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
 * $Id: ImperativeOCL.g,v 1.9 2008/11/28 14:36:54 aigdalov Exp $
 */
	./
$End

$Rules

	-- opt = optional
	-- m = multiple

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
	 
	statementCS -> assignStatementCS
	statementCS -> variableInitializationCS

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
	newExpCS ::= new pathNameCS '(' argumentsCSopt ')' 
		/.$BeginJava
				OCLExpressionCS result = createNewRuleCallExpCS((PathNameCS)dtParser.getSym(2),(EList)dtParser.getSym(4));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
		  $EndJava
		./	
$End

	