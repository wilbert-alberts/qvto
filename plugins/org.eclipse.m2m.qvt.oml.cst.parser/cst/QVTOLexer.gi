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
-- *   See Notice Declaration below
-- *
-- * </copyright>
-- *
-- * $Id: QVTOLexer.gi,v 1.1 2010/01/06 18:56:10 sboyko Exp $
-- */
--
-- The QVTo Lexer
--

%options scopes
%options escape=$
%options la=2
%options fp=QVTOLexer,prefix=Char_
%options single-productions
%options noserialize
%options template=../lpg/LexerTemplateD.gi
%options filter=QVTOKWLexer.gi
%options export_terminals=("QVTOParsersym.java", "TK_")
%options include_directory=".;../lpg"


%Import
	ImperativeOCLLexer.gi
%End

%Define
	$kw_lexer_class /.QVTOKWLexer./

%End


%Notice
	/./**
 * <copyright>
 *
 * Copyright (c) 2006-2008 Borland Inc.
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
 */
	./
%End


%Export
	STEREOTYPE_QUALIFIER_OPEN
	STEREOTYPE_QUALIFIER_CLOSE
	MULTIPLICITY_RANGE
	TILDE_SIGN

%End

%Rules
	Token ::= '<' '<'
		/.$BeginAction
					makeToken($_STEREOTYPE_QUALIFIER_OPEN);
		  $EndAction
		./

	Token ::= '>' '>'
		/.$BeginAction
					makeToken($_STEREOTYPE_QUALIFIER_CLOSE);
		  $EndAction
		./

	Token ::= '.' '.' '.'
		/.$BeginAction
					makeToken($_MULTIPLICITY_RANGE);
		  $EndAction
		./

	Token ::= '~'
		/.$BeginAction
					makeToken($_TILDE_SIGN);
		  $EndAction
		./

%End
