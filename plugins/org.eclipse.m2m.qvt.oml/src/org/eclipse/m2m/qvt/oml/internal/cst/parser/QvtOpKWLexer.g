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
-- * $Id: QvtOpKWLexer.g,v 1.6 2007/11/27 20:33:22 radvorak Exp $
-- */
--
-- The QVT KeyWord Lexer
--

%Options slr
%Options fp=QvtOpKWLexer,prefix=Char_
%options noserialize
%options package=org.eclipse.m2m.qvt.oml.internal.cst.parser
%options template=KeywordTemplateD.g
%options export_terminals=("QVTParsersym.java", "TK_")

$Start
	QVTKeyWord
$End

$Import
	OCLKWLexer.g

$DropRules

	KeyWord ::= i n v
	KeyWord ::= p r e
	KeyWord ::= p o s t
	KeyWord ::= b o d y
	KeyWord ::= c o n t e x t
	KeyWord ::= p a c k a g e
	KeyWord ::= e n d p a c k a g e
	KeyWord ::= d e f
	KeyWord ::= a t t r
	KeyWord ::= o p e r
	KeyWord ::= d e r i v e
	
$DropSymbols
	
	inv
	pre
	post
	context
	package
	endpackage
	def
	attr
	oper
	derive
	
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
 * $Id: QvtOpKWLexer.g,v 1.6 2007/11/27 20:33:22 radvorak Exp $
 */
	./
$End

$Export
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

$Rules

-- The Goal for the parser is a single Keyword

	QVTKeyWord ::=
		KeyWord
		
		| e n d
		/.$BeginAction
			$setResult($_end);
		  $EndAction
		./
		
		| w h i l e
		/.$BeginAction
			$setResult($_while);
		  $EndAction
		./
		
		| o u t
		/.$BeginAction
			$setResult($_out);
		  $EndAction
		./
		
		| o  b j e c t
		/.$BeginAction
			$setResult($_object);
		  $EndAction
		./
		
		| t r a n s f o r m a t i o n
		/.$BeginAction
			$setResult($_transformation);
		  $EndAction
		./
		
		| i m p o r t
		/.$BeginAction
			$setResult($_import);
		  $EndAction
		./
		
		| l i b r a r y
		/.$BeginAction
			$setResult($_library);
		  $EndAction
		./
		
		| m e t a m o d e l
		/.$BeginAction
			$setResult($_metamodel);
		  $EndAction
		./
		
		| r e n a m e
		/.$BeginAction
			$setResult($_rename);
		  $EndAction
		./
		
		| m a p p i n g
		/.$BeginAction
			$setResult($_mapping);
		  $EndAction
		./
		
		| q u e r y
		/.$BeginAction
			$setResult($_query);
		  $EndAction
		./
		
		| i n o u t
		/.$BeginAction
			$setResult($_inout);
		  $EndAction
		./
		
		| w h e n
		/.$BeginAction
			$setResult($_when);
		  $EndAction
		./
		
		| v a r
		/.$BeginAction
			$setResult($_var);
		  $EndAction
		./
		
		| c o n f i g u r a t i o n
		/.$BeginAction
			$setResult($_configuration);
		  $EndAction
		./
		
		| p r o p e r t y
		/.$BeginAction
			$setResult($_property);
		  $EndAction
		./
		
		| m a p
		/.$BeginAction
			$setResult($_map);
		  $EndAction
		./
		
		| x m a p
		/.$BeginAction
			$setResult($_xmap);
		  $EndAction
		./
		
		| l a t e
		/.$BeginAction
			$setResult($_late);
		  $EndAction
		./
		
		| r e s o l v e
		/.$BeginAction
			$setResult($_resolve);
		  $EndAction
		./
		
		| r e s o l v e o n e
		/.$BeginAction
			$setResult($_resolveone);
		  $EndAction
		./
		
		| r e s o l v e I n
		/.$BeginAction
			$setResult($_resolveIn);
		  $EndAction
		./
		
		| r e s o l v e o n e I n
		/.$BeginAction
			$setResult($_resolveoneIn);
		  $EndAction
		./
		
		| i n v r e s o l v e
		/.$BeginAction
			$setResult($_invresolve);
		  $EndAction
		./
		
		| i n v r e s o l v e o n e
		/.$BeginAction
			$setResult($_invresolveone);
		  $EndAction
		./
		
		| i n v r e s o l v e I n
		/.$BeginAction
			$setResult($_invresolveIn);
		  $EndAction
		./
		
		| i n v r e s o l v e o n e I n
		/.$BeginAction
			$setResult($_invresolveoneIn);
		  $EndAction
		./

		| m o d e l t y p e
		/.$BeginAction
			$setResult($_modeltype);
		  $EndAction
		./
		
		| u s e s
		/.$BeginAction
			$setResult($_uses);
		  $EndAction
		./
		
		| w h e r e
		/.$BeginAction
			$setResult($_where);
		  $EndAction
		./
		
		| r e f i n e s
		/.$BeginAction
			$setResult($_refines);
		  $EndAction
		./
		
		| e n f o r c i n g
		/.$BeginAction
			$setResult($_enforcing);
		  $EndAction
		./
		
		| a c c e s s
		/.$BeginAction
			$setResult($_access);
		  $EndAction
		./
		
		| e x t e n d s
		/.$BeginAction
			$setResult($_extends);
		  $EndAction
		./
		
		| b l a c k b o x
		/.$BeginAction
			$setResult($_blackbox);
		  $EndAction
		./
		
		| a b s t r a c t
		/.$BeginAction
			$setResult($_abstract);
		  $EndAction
		./
		
		| s t a t i c
		/.$BeginAction
			$setResult($_static);
		  $EndAction
		./
		
		| r e s u l t
		/.$BeginAction
			$setResult($_result);
		  $EndAction
		./
		
		| m a i n
		/.$BeginAction
			$setResult($_main);
		  $EndAction
		./
		
		| t h i s
		/.$BeginAction
			$setResult($_this);
		  $EndAction
		./
		
		| s w i t c h
		/.$BeginAction
			$setResult($_switch);
		  $EndAction
		./
		
$End

