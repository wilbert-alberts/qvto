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
-- * $Id: QvtOpLexer.g,v 1.2 2007/11/27 15:43:20 radvorak Exp $
-- */
--
-- The QVT Lexer
--

%options escape=$
%options la=2
%options fp=QvtOpLexer,prefix=Char_
%options single-productions
%options noserialize
%options package=org.eclipse.m2m.qvt.oml.internal.cst.parser
%options template=LexerTemplateD.g
%options filter=QvtOpKWLexer.g
%options export_terminals=("QVTParsersym.java", "TK_")

$Define

	--
	-- Definition of macro used in the included file OCLLexer.g
	--
	$OCLKWLexer /.QvtOpKWLexer./

$End

$Include
	LexerBasicMap.g
$End

$Headers
	/.
		/*
	./
$End

$Import
	OCLLexer.g

$DropRules

	Identifier -> QuotedName

$End

$Headers
	/.
		*/
	./
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
 * $Id: QvtOpLexer.g,v 1.2 2007/11/27 15:43:20 radvorak Exp $
 */
	./
$End

$Export

	QUOTE_STRING_LITERAL
	ADD_ASSIGN
	RESET_ASSIGN
	AT_SIGN
	
$End

$Rules

	Token ::= QuotedName
		/.$BeginAction
					makeToken($_QUOTE_STRING_LITERAL);
		  $EndAction
		./

	Token ::= ':' '='
		/.$BeginAction
					makeToken($_RESET_ASSIGN);
		  $EndAction
		./

	Token ::= '+' '='
		/.$BeginAction
					makeToken($_ADD_ASSIGN);
		  $EndAction
		./

	Token ::= '@'
		/.$BeginAction
					makeToken($_AT_SIGN);
		  $EndAction
		./

	NotSQ -> HT
	NotSQ -> LF
	NotSQ -> CR
	
$End
