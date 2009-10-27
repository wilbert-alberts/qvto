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
-- * $Id: QvtOpKWLexer.g,v 1.11.4.1 2009/10/27 09:18:34 sboyko Exp $ 
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
 * $Id: QvtOpKWLexer.g,v 1.11.4.1 2009/10/27 09:18:34 sboyko Exp $
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
	opposites
	class
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
	access
	extends
	blackbox
	abstract
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

	Dict
	List
        break
        composes
        constructor
        continue
        datatype
        default
        derived
        do
        elif
        enum
        except
        exception
        from
        literal
        ordered
        primitive
        raise
        readonly
        references
        tag
        try
        typedef
        unlimited
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
		
		| o p p o s i t e s
		/.$BeginAction
			$setResult($_opposites);
		  $EndAction
		./
		
		| c l a s s
		/.$BeginAction
			$setResult($_class);
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
		
		| D i c t 
		/.$BeginAction
			$setResult($_Dict);
		  $EndAction
		./
		
		| L i s t 
		/.$BeginAction
			$setResult($_List);
		  $EndAction
		./
		
		| b r e a k 
		/.$BeginAction
			$setResult($_break);
		  $EndAction
		./
		
		| c o m p o s e s 
		/.$BeginAction
			$setResult($_composes);
		  $EndAction
		./
		
		| c o n s t r u c t o r 
		/.$BeginAction
			$setResult($_constructor);
		  $EndAction
		./
		
		| c o n t i n u e 
		/.$BeginAction
			$setResult($_continue);
		  $EndAction
		./
		
		| d a t a t y p e 
		/.$BeginAction
			$setResult($_datatype);
		  $EndAction
		./
		
		| d e f a u l t 
		/.$BeginAction
			$setResult($_default);
		  $EndAction
		./
		
		| d e r i v e d 
		/.$BeginAction
			$setResult($_derived);
		  $EndAction
		./
		
		| d o 
		/.$BeginAction
			$setResult($_do);
		  $EndAction
		./
		
		| e l i f 
		/.$BeginAction
			$setResult($_elif);
		  $EndAction
		./
		
		| e n u m 
		/.$BeginAction
			$setResult($_enum);
		  $EndAction
		./
		
		| e x c e p t 
		/.$BeginAction
			$setResult($_except);
		  $EndAction
		./
		
		| e x c e p t i o n 
		/.$BeginAction
			$setResult($_exception);
		  $EndAction
		./
		
		| f r o m 
		/.$BeginAction
			$setResult($_from);
		  $EndAction
		./
		
		| l i t e r a l 
		/.$BeginAction
			$setResult($_literal);
		  $EndAction
		./
		
		| o r d e r e d 
		/.$BeginAction
			$setResult($_ordered);
		  $EndAction
		./
		
		| p r i m i t i v e 
		/.$BeginAction
			$setResult($_primitive);
		  $EndAction
		./
		
		| r a i s e 
		/.$BeginAction
			$setResult($_raise);
		  $EndAction
		./
		
		| r e a d o n l y 
		/.$BeginAction
			$setResult($_readonly);
		  $EndAction
		./
		
		| r e f e r e n c e s 
		/.$BeginAction
			$setResult($_references);
		  $EndAction
		./
		
		| t a g 
		/.$BeginAction
			$setResult($_tag);
		  $EndAction
		./
		
		| t r y 
		/.$BeginAction
			$setResult($_try);
		  $EndAction
		./
		
		| t y p e d e f 
		/.$BeginAction
			$setResult($_typedef);
		  $EndAction
		./
		
		| u n l i m i t e d 
		/.$BeginAction
			$setResult($_unlimited);
		  $EndAction
		./

$End

