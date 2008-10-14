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
-- * $Id: QvtOpKWLexer.g,v 1.6 2008/10/14 11:46:37 radvorak Exp $ 
-- */
--
-- The QVT KeyWord Lexer
--

%Options slr
%Options fp=QvtOpKWLexer,prefix=Char_
%options noserialize
%options template=../lpg/KeywordTemplateD.g
%options export_terminals=("QVTParsersym.java", "TK_")
%options include_directory=".;../lpg"


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
 * $Id: QvtOpKWLexer.g,v 1.6 2008/10/14 11:46:37 radvorak Exp $
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
	helper
	inout
	when
	var
	configuration
	intermediate
	property
	population	
	map
	new
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
	disjuncts
	merges
	inherits	
	forEach
	forOne
	compute
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
		
		| d i s j u n c t s
		/.$BeginAction
			$setResult($_disjuncts);
		  $EndAction
		./
		
		| m e r g e s
		/.$BeginAction
			$setResult($_merges);
		  $EndAction
		./
		
		| i n h e r i t s
		/.$BeginAction
			$setResult($_inherits);
		  $EndAction
		./		

		| r e t u r n
		/.$BeginAction
			$setResult($_return);
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
		
		| h e l p e r
		/.$BeginAction
			$setResult($_helper);
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
		
		| p o p u l a  t i o n		
		/.$BeginAction
			$setResult($_population);
		  $EndAction
		./
		
		| i n t e r m e d i a t e
		/.$BeginAction
			$setResult($_intermediate);
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

		| n e w
		/.$BeginAction
			$setResult($_new);
		  $EndAction
		./
		
		| l a t e
		/.$BeginAction
			$setResult($_late);
		  $EndAction
		./

		| l o g
		/.$BeginAction
			$setResult($_log);
		  $EndAction
		./
		
		| a s s e r t
		/.$BeginAction
			$setResult($_assert);
		  $EndAction
		./

		| w i t h
		/.$BeginAction
			$setResult($_with);
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
		
		| c a s e
		/.$BeginAction
			$setResult($_case);
		  $EndAction
		./
		
		| x s e l e c t
		/.$BeginAction
			$setResult($_xselect);
		  $EndAction
		./
		
		| x c o l l e c t
		/.$BeginAction
			$setResult($_xcollect);
		  $EndAction
		./
		
		| s e l e c t O n e
		/.$BeginAction
			$setResult($_selectOne);
		  $EndAction
		./
		
		| c o l l e c t O n e
		/.$BeginAction
			$setResult($_collectOne);
		  $EndAction
		./
		
		| c o l l e c t s e l e c t
		/.$BeginAction
			$setResult($_collectselect);
		  $EndAction
		./
		
		| c o l l e c t s e l e c t O n e
		/.$BeginAction
			$setResult($_collectselectOne);
		  $EndAction
		./

		| f o r E a c h
		/.$BeginAction
			$setResult($_forEach);
		  $EndAction
		./
		
		| f o r O n e
		/.$BeginAction
			$setResult($_forOne);
		  $EndAction
		./
		
		| c o m p u t e
		/.$BeginAction
			$setResult($_compute);
		  $EndAction
		./
		
$End

