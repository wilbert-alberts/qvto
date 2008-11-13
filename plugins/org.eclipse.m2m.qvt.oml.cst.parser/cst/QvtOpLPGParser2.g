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
-- * $Id: QvtOpLPGParser2.g,v 1.1 2008/11/13 15:22:02 aigdalov Exp $ 
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
--%options template=dtParserTemplateD.g
%options import_terminals=QvtOpLexer.g
%options ast_type=CSTNode
%options programming_language=java
%options action=("*.java", "/.", "./")
%options ParseTable=lpg.lpgjavaruntime.ParseTable
%options include_directory=".;../lpg"

$Start
    QVTgoal
$End

$Import
	ImperativeOCL.g

$Globals
	/.	
	import org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingEndCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingInitCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS;	
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;	
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.OutExpCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.temp.ResolveOpArgsExpCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.temp.ScopedNameCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindEnum;
	import org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.ImportKindEnum;
	import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS;
	./
$End

$KeyWords
	end
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
	configuration
	intermediate
	property
	population
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
	rename
	inherits
	merges
	disjuncts
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
 * $Id: QvtOpLPGParser2.g,v 1.1 2008/11/13 15:22:02 aigdalov Exp $
 */
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
	mappingModuleCS ::= moduleImportListOpt metamodelListOpt qualifierList transformation qvtErrorToken
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

	transformationHeaderCS ::= qualifierList transformation qualifiedNameCS
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
	transformationHeaderCS ::= qualifierList transformation qualifiedNameCS '(' transfParamListOpt ')' moduleUsageListOpt transformationRefineCSOpt
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
		
	transfParamCS ::= param_directionOpt pathNameCS
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
	transfParamCS ::= param_directionOpt IDENTIFIER ':' pathNameCS 
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
	modulePropertyCS ::= intermediate property scoped_identifier : typeCS ';' 
		/.$BeginJava
					CSTNode result = createContextualPropertyCS(
							(ScopedNameCS)$getSym(3),
							(TypeCS)$getSym(5),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(6)));
					$setResult(result);
		  $EndJava
		./
	modulePropertyCS ::= intermediate property scoped_identifier : typeCS '=' oclExpressionCS ';' 
		/.$BeginJava
					CSTNode result = createContextualPropertyCS(
							(ScopedNameCS)$getSym(3),
							(TypeCS)$getSym(5),
							(OCLExpressionCS)$getSym(7)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(8)));
					$setResult(result);
		  $EndJava
		./
	-- // general purpose grammar rules (start)

	qualifierList ::= $empty
		/.$EmptyListAction./
	qualifierList ::= qualifierList qualifier
		/.$BeginJava
					EList result = (EList) $getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndJava
		./
		
	qualifier ::= blackbox
		/.$NewCase./
	qualifier ::= abstract
		/.$NewCase./
	qualifier ::= static
		/.$BeginJava
					CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getTokenText(dtParser.getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	colon_param_listOpt ::= $empty	 
		/.$EmptyListAction./
	colon_param_listOpt ::= ':' param_list
		/.$BeginJava
					$setResult($getSym(2));
		  $EndJava
		./

	complete_signature ::= simple_signature colon_param_listOpt
		/.$BeginJava
					SimpleSignatureCS simpleSignatureCS = (SimpleSignatureCS)$getSym(1);
					EList<ParameterDeclarationCS> resultList = (EList<ParameterDeclarationCS>)$getSym(2);
					CSTNode result = createCompleteSignatureCS(simpleSignatureCS, resultList);
					result.setStartOffset(simpleSignatureCS.getStartOffset());
					result.setEndOffset(getEndOffset(simpleSignatureCS.getEndOffset(), resultList));
					$setResult(result);
		  $EndJava
		./

	simple_signature ::= '(' param_listOpt ')' 
		/.$BeginJava
					CSTNode result = createSimpleSignatureCS((EList<ParameterDeclarationCS>)$getSym(2));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./

	param_listOpt ::= $empty
		/.$EmptyListAction./
	param_listOpt -> param_list

	param_list ::= param_list ',' param
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
	param_list ::= param
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./

	param ::= param_directionOpt IDENTIFIER ':' typespec
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
		
	param ::= typespec
		/.$BeginJava
					CSTNode result = createParameterDeclarationCS(
							null, null, (TypeSpecCS)$getSym(1)
						);
					setOffsets(result, (CSTNode)$getSym(1));
					$setResult(result);
		  $EndJava
		./

	typespec ::= typeCS
		/.$BeginJava
					CSTNode result = createTypeSpecCS(
						(TypeCS)$getSym(1),
						null
						);
					$setResult(result);
		  $EndJava
		./
	typespec ::= typeCS '@' IDENTIFIER
		/.$BeginJava
					CSTNode result = createTypeSpecCS(
						(TypeCS)$getSym(1),
						getIToken($getToken(3))
						);
					$setResult(result);
		  $EndJava
		./

	param_directionOpt ::= $empty
		/.$NullAction./
	param_directionOpt -> param_direction
	
	param_direction ::= in
		/.$BeginJava
					CSTNode result = createDirectionKindCS(
							DirectionKindEnum.IN
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	param_direction ::= out
		/.$BeginJava
					CSTNode result = createDirectionKindCS(
							DirectionKindEnum.OUT
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	param_direction ::= inout
		/.$BeginJava
					CSTNode result = createDirectionKindCS(
							DirectionKindEnum.INOUT
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./


	typeCS2 -> primitiveTypeCS
	typeCS2 -> tupleTypeCS
	typeCS2 -> collectionTypeCS
	
	scoped_identifier ::= typeCS2 '::' IDENTIFIER
		/.$BeginJava
					ScopedNameCS result = createScopedNameCS((TypeCS)$getSym(1), getTokenText($getToken(3)));		
					setOffsets(result, (CSTNode) $getSym(1), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	scoped_identifier ::= typeCS2 '::' qvtErrorToken
		/.$BeginJava
					ScopedNameCS result = createScopedNameCS((TypeCS)$getSym(1), ""); //$NON-NLS-1$		
					setOffsets(result, (CSTNode) $getSym(1), getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	scoped_identifier ::= scoped_identifier2
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
	scoped_identifier2 ::= IDENTIFIER
		/.$BeginJava
					CSTNode result = createPathNameCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	scoped_identifier2 ::= main
		/.$BeginJava
					CSTNode result = createPathNameCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	scoped_identifier2 ::= scoped_identifier2 '::' IDENTIFIER
		/.$BeginJava
					PathNameCS result = (PathNameCS)$getSym(1);
					result = extendPathNameCS(result, getTokenText($getToken(3)));
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	scoped_identifier2 ::= scoped_identifier2 '::' qvtErrorToken
		/.$BeginJava
					PathNameCS result = (PathNameCS)$getSym(1);
					result = extendPathNameCS(result, "");
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	scoped_identifier_list ::= scoped_identifier
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	scoped_identifier_list ::= scoped_identifier_list ',' scoped_identifier
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./

	-- // general purpose grammar rules (end)

	-- // syntax for helper operations (start)

	-- // syntax for helper operations (end)

	_helper -> helper_decl
	_helper -> helper_simple_def
	_helper -> helper_compound_def

	helper_header ::= helper_info scoped_identifier complete_signature 
		/.$BeginJava
					CompleteSignatureCS completeSignature = (CompleteSignatureCS)$getSym(3);
					Object[] helperInfo = (Object[])$getSym(1);
					MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
						null,
						(ScopedNameCS)$getSym(2),
						completeSignature.getSimpleSignature().getParams(),
						completeSignature.getResultParams()
					);
					setOffsets(mappingDeclarationCS, (CSTNode)$getSym(2), (CSTNode)$getSym(3));

					EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>) helperInfo[0];
					if(!qualifiers.isEmpty()) {
						mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
					}

					IToken helperKind = (IToken) helperInfo[1];
					mappingDeclarationCS.setIsQuery(helperKind.getKind() == $sym_type.TK_query);

					$setResult(mappingDeclarationCS);
		  $EndJava
		./

	helper_header ::= helper_info qvtErrorToken
		/.$BeginJava
					Object[] helperInfo = (Object[])$getSym(1);
					MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
						null,
						createScopedNameCS(null, ""), //$NON-NLS-1$
						$EMPTY_ELIST,
						$EMPTY_ELIST
					);
					setOffsets(mappingDeclarationCS, (IToken) helperInfo[1]);

					EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>) helperInfo[0];
					if(!qualifiers.isEmpty()) {
						mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
					}

					IToken helperKind = (IToken) helperInfo[1];
					mappingDeclarationCS.setIsQuery(helperKind.getKind() == $sym_type.TK_query);

					$setResult(mappingDeclarationCS);
		  $EndJava
		./

	helper_info ::= qualifierList helper_kind
		/.$BeginJava
					$setResult(new Object[] {$getSym(1), getIToken($getToken(2))});
		  $EndJava
		./

	helper_kind -> helper
	helper_kind -> query

	helper_decl ::= helper_header ';' 
		/.$BeginJava
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS)$getSym(1);
					MappingQueryCS result = createMappingQueryCS(
							mappingDecl,
							$EMPTY_ELIST
						);
					result.setBlackBox(true);
					setOffsets(result, mappingDecl, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./

	helper_decl ::= helper_header qvtErrorToken 
		/.$BeginJava
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS)$getSym(1);
					MappingQueryCS result = createMappingQueryCS(
							mappingDecl,
							$EMPTY_ELIST
						);
					result.setBlackBox(true);
					setOffsets(result, mappingDecl);
					$setResult(result);
		  $EndJava
		./

	helper_simple_def ::= helper_header '=' statementCS ';' 
		/.$BeginJava
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS)$getSym(1);
					OCLExpressionCS expression = (OCLExpressionCS)$getSym(3);
					EList<OCLExpressionCS> expressionList = new BasicEList();
					expressionList.add(expression);
					MappingQueryCS result = createMappingQueryCS(
							mappingDecl,
							expressionList
						);
					result.setIsSimpleDefinition(true);
					setOffsets(result, mappingDecl, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

	helper_compound_def ::= helper_header expression_block semicolonOpt
		/.$BeginJava
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS)$getSym(1);
					BlockExpCS blockExpCS = (BlockExpCS)$getSym(2);
					CSTNode result = createMappingQueryCS(
							mappingDecl,
							blockExpCS.getBodyExpressions()
						);
					setOffsets(result, mappingDecl, blockExpCS);
					$setResult(result);
		  $EndJava
		./


	-- // syntax for mapping operations (start)

	_mapping -> mapping_decl
	_mapping -> mapping_def

	mapping_decl ::= mapping_full_header ';'
		/.$BeginJava
		                        Object[] mappingFullHeader = (Object[])$getSym(1);
					MappingRuleCS result = createMappingRuleCS(
							(MappingDeclarationCS)mappingFullHeader[0],
							(OCLExpressionCS)mappingFullHeader[1],
							null
						);
					result.setBlackBox(true);
					setOffsets(result, (MappingDeclarationCS)mappingFullHeader[0], getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./

	semicolonOpt -> ';'
	semicolonOpt -> $empty

	mapping_def ::= mapping_full_header '{' mapping_body '}' semicolonOpt
		/.$BeginJava
					MappingSectionsCS mappingSections = (MappingSectionsCS)$getSym(3);
					MappingInitCS mappingInit = mappingSections.getMappingInitCS();
					MappingBodyCS mappingBody = mappingSections.getMappingBodyCS();
					MappingEndCS mappingEnd = mappingSections.getMappingEndCS();
					int bodyLeft = (mappingInit == null ?  getIToken($getToken(2)).getEndOffset() : mappingInit.getEndOffset());
					int bodyRight = (mappingEnd == null ?  getIToken($getToken(4)).getEndOffset() : mappingEnd.getStartOffset());
					int outBodyRight = (mappingEnd == null ?  getIToken($getToken(4)).getStartOffset() : mappingEnd.getStartOffset());
					if (mappingBody != null) {
						bodyLeft = mappingBody.getStartOffset();
						bodyRight = mappingBody.getEndOffset();
					}

					updateMappingBodyPositions(mappingBody, bodyLeft, bodyRight, bodyLeft, outBodyRight);

		                        Object[] mappingFullHeader = (Object[])$getSym(1);
					MappingRuleCS result = createMappingRuleCS(
							(MappingDeclarationCS)mappingFullHeader[0],
							(OCLExpressionCS)mappingFullHeader[1],
							mappingSections
						);
					result.setBlackBox(false);
					setOffsets(result, (MappingDeclarationCS)mappingFullHeader[0], getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

	mapping_def ::= mapping_full_header '{' qvtErrorToken
		/.$BeginJava
		                        Object[] mappingFullHeader = (Object[])$getSym(1);
					MappingRuleCS result = createMappingRuleCS(
							(MappingDeclarationCS)mappingFullHeader[0],
							null,
							null
						);
					setOffsets(result, (MappingDeclarationCS)mappingFullHeader[0], getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./

	mapping_full_header ::= mapping_header _whenOpt
		/.$BeginJava
					$setResult(new Object[] {$getSym(1), $getSym(2)});
		  $EndJava
		./

	mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier complete_signature mapping_extraList
		/.$BeginJava
					DirectionKindCS directionKind = (DirectionKindCS)$getSym(3);
					CompleteSignatureCS completeSignature = (CompleteSignatureCS)$getSym(5);
					MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
						directionKind,
						(ScopedNameCS)$getSym(4),
						completeSignature.getSimpleSignature().getParams(),
						completeSignature.getResultParams()
					);
					mappingDeclarationCS.setStartOffset((directionKind == null ? (CSTNode)$getSym(4) : directionKind).getStartOffset());

					mappingDeclarationCS.setEndOffset(completeSignature.getEndOffset());

					EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)$getSym(1);
					if(!qualifiers.isEmpty()) {
						mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
					}

					mappingDeclarationCS.getMappingExtension().addAll(((EList<MappingExtensionCS>)$getSym(6)));

					$setResult(mappingDeclarationCS);
		  $EndJava
		./

	mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier qvtErrorToken
		/.$BeginJava
					DirectionKindCS directionKind = (DirectionKindCS)$getSym(3);
					MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
						directionKind,
						(ScopedNameCS)$getSym(4),
						$EMPTY_ELIST,
						$EMPTY_ELIST
					);
					mappingDeclarationCS.setStartOffset((directionKind == null ? (CSTNode)$getSym(4) : directionKind).getStartOffset());

					mappingDeclarationCS.setEndOffset(((CSTNode)$getSym(4)).getEndOffset());

					EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)$getSym(1);
					if(!qualifiers.isEmpty()) {
						mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
					}

					$setResult(mappingDeclarationCS);
		  $EndJava
		./

	mapping_header ::= qualifierList mapping qvtErrorToken
		/.$BeginJava
					MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
						null,
						createScopedNameCS(null, ""), //$NON-NLS-1$
						$EMPTY_ELIST,
						$EMPTY_ELIST
					);
					setOffsets(mappingDeclarationCS, getIToken($getToken(2)), getIToken($getToken(2)));

					EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)$getSym(1);
					if(!qualifiers.isEmpty()) {
						mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
					}

					$setResult(mappingDeclarationCS);
		  $EndJava
		./


	mapping_extraList ::= mapping_extraList mapping_extra
		/.$BeginJava
					EList<MappingExtensionCS> extensionList = (EList<MappingExtensionCS>)$getSym(1);
					extensionList.add((MappingExtensionCS)$getSym(2));
					$setResult(extensionList);
		  $EndJava
		./

	mapping_extraList ::= $empty
		/.$EmptyListAction./

	mapping_extra -> mapping_extension

	mapping_extension ::= mapping_extension_key scoped_identifier_list
		/.$BeginJava
					MappingExtensionCS result = createMappingExtension(getTokenText($getToken(1)), (EList<ScopedNameCS>)$getSym(2));

					result.setStartOffset(getIToken($getToken(1)).getStartOffset());
					result.setEndOffset(getEndOffset(getIToken($getToken(1)), (EList<ScopedNameCS>)$getSym(2)));
				
					$setResult(result);
		  $EndJava
		./

	mapping_extension_key -> inherits
	mapping_extension_key -> merges
	mapping_extension_key -> disjuncts

	_whenOpt -> _when
	_whenOpt ::= $empty	 
		/.$NullAction./

	_when ::= when '{' oclExpressionCS '}'
		/.$BeginJava
					OCLExpressionCS result = (OCLExpressionCS)$getSym(3);
					$setResult(result);
		  $EndJava
		./
	_when ::= when qvtErrorToken
		/.$NullAction./

	mapping_body ::= init_sectionOpt population_sectionOpt end_sectionOpt
		/.$BeginJava
					CSTNode result = createMappingSectionsCS(
							(MappingInitCS)$getSym(1),
							(MappingBodyCS)$getSym(2),
							(MappingEndCS)$getSym(3)
						);
					$setResult(result);
		  $EndJava
		./

	init_sectionOpt ::= $empty
		/.$NullAction./
	init_sectionOpt -> init_section

	init_section ::= init expression_block
		/.$BeginJava
					BlockExpCS blockExpCS = (BlockExpCS) $getSym(2);
					CSTNode result = createMappingInitCS(
							blockExpCS.getBodyExpressions(),
							blockExpCS.getStartOffset(),
							blockExpCS.getEndOffset()
						);
					setOffsets(result, getIToken($getToken(1)), blockExpCS);
					$setResult(result);
		  $EndJava
		./

	init_section ::= init qvtErrorToken
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

	
	population_sectionOpt -> mappingBodyOpt

	
	end_sectionOpt ::= $empty
		/.$NullAction./
	end_sectionOpt -> end_section

	end_section ::= end expression_block
		/.$BeginJava
					BlockExpCS blockExpCS = (BlockExpCS) $getSym(2);
					CSTNode result = createMappingEndCS(
							blockExpCS.getBodyExpressions(),
							blockExpCS.getStartOffset(),
							blockExpCS.getEndOffset()
						);
					setOffsets(result, getIToken($getToken(1)), blockExpCS);
					$setResult(result);
		  $EndJava
		./

	end_section ::= end qvtErrorToken
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


	-- // syntax for mapping operations (end)

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
	mappingRuleList ::= _helper
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	mappingRuleList ::= mappingRuleList _helper
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

	-- TODO: Change to module_element
	mappingRuleCS -> _mapping
	
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
		
			
	entryDeclarationCS ::= main '(' param_listOpt ')'
		/.$BeginJava
					IToken nameToken = getIToken(dtParser.getToken(1));				
					ScopedNameCS nameCS = createScopedNameCS(null, getTokenText(dtParser.getToken(1)));								
					nameCS.setStartOffset(nameToken.getStartOffset());
					nameCS.setEndOffset(nameToken.getEndOffset());
		
					CSTNode result = createMappingDeclarationCS(
							null,
							nameCS,
							(EList)$getSym(3),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

	entryDeclarationCS ::= main qvtErrorToken
		/.$BeginJava
					CSTNode result = createMappingDeclarationCS(
							null,
							createScopedNameCS(null, getTokenText($getToken(1))),
							$EMPTY_ELIST,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
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
		
		
	mappingBodyOpt ::= population '{' expressionListOpt '}'
		/.$BeginJava
				MappingBodyCS result = createMappingBodyCS(
						(EList<OCLExpressionCS>)dtParser.getSym(3),
						false, true
					);
				setOffsets(result, getIToken(dtParser.getToken(2)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
		  $EndJava
		./
		
	mappingBodyOpt ::= outExpCS
		/.$BeginJava
					MappingBodyCS result = createMappingBodyCS(
							(OutExpCS)dtParser.getSym(1),
							false, false
						);
					setOffsets(result, (CSTNode)$getSym(1));
					$setResult(result);
		  $EndJava
		./
	mappingBodyOpt ::= patternPropertyOrAdditionList
		/.$BeginJava
					EList props = (EList)$getSym(1);
					OutExpCS outExp = createOutExpCS(props, getIToken($getToken(1)).getStartOffset(), getIToken($getToken(1)).getEndOffset());
					if (!props.isEmpty()) {
						CSTNode head = (CSTNode) props.get(0);
						CSTNode tail = (CSTNode) props.get(props.size()-1);
						setOffsets(outExp, head, tail);
					}
					MappingBodyCS result = createMappingBodyCS(
							outExp,
							true, false
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
	
	typespecOpt ::= $empty
		/.$NullAction./
	typespecOpt -> typespec

	objectDeclCS ::= typespec
		/.$BeginJava
					CSTNode result = createOutExpCS(null, (TypeSpecCS)$getSym(1));
					$setResult(result);
		  $EndJava
		./

	objectIdentifierCS -> result
	objectIdentifierCS -> self
	objectIdentifierCS -> IDENTIFIER	
	
	objectDeclCS ::= objectIdentifierCS ':' typespecOpt
		/.$BeginJava
				SimpleNameCS varName = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(dtParser.getToken(1)));
				setOffsets(varName, getIToken(dtParser.getToken(1)));
				CSTNode result = createOutExpCS(varName,(TypeSpecCS)dtParser.getSym(3));					
				$setResult(result);
		  $EndJava
		./
	
	outExpCS ::= object objectDeclCS '{' patternPropertyOrAdditionList '}' 
		/.$BeginJava
					CSTNode result = setupOutExpCS(
							(OutExpCS)$getSym(2),					
							(EList)$getSym(4),
							// passing body positions
							getIToken($getToken(3)).getEndOffset(),
							getIToken($getToken(5)).getStartOffset()
						); 
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	outExpCS ::= object objectDeclCS '{' patternPropertyOrAdditionList qvtErrorToken
		/.$BeginJava
					OutExpCS outExpCS = ((OutExpCS)dtParser.getSym(2));
					EList<CSTNode> patternPropertyOrAdditionList = (EList<CSTNode>)$getSym(4);
					CSTNode result = createErrorOutExpCS(
							outExpCS.getSimpleNameCS(),						
							outExpCS.getTypeSpecCS(),
							(EList)dtParser.getSym(4),						
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
	outExpCS ::= object objectDeclCS qvtErrorToken
		/.$BeginJava
					OutExpCS objectDeclCS = ((OutExpCS)dtParser.getSym(2));  
					CSTNode result = createErrorOutExpCS(
							objectDeclCS.getSimpleNameCS(),						
							objectDeclCS.getTypeSpecCS(),
							$EMPTY_ELIST,
							getIToken($getToken(1)).getEndOffset(),
							getIToken($getToken(1)).getStartOffset(),
							getIToken($getToken(1)).getStartOffset(),
							getIToken($getToken(3)).getStartOffset()
						);
					if (objectDeclCS  == null) {
					    setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					} else {
					    setOffsets(result, getIToken($getToken(1)), objectDeclCS);
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

    resolveOpArgsExpCSOpt ::= $empty
        /.$NullAction./
        
    resolveOpArgsExpCSOpt -> resolveOpArgsExpCS
        
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
    
    resolveExpCS ::= lateOpt resolveOp '(' resolveOpArgsExpCSOpt ')'
        /.$BeginJava
                    CSTNode result = createResolveExpCS(
                            getIToken($getToken(1)),
                            getIToken($getToken(2)),
                            (ResolveOpArgsExpCS)$getSym(4));
                            setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
                    $setResult(result);
          $EndJava
        ./
        
    resolveExpCS ::= lateOpt resolveOp '(' resolveOpArgsExpCSOpt qvtErrorToken
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
                            new Token(lateToken.getEndOffset(), lateToken.getEndOffset(), $sym_type.TK_resolve),
                            null);
                            setOffsets(result, getIToken($getToken(1)));
                    $setResult(result);
          $EndJava
        ./

    resolveInOp -> resolveIn
    resolveInOp -> invresolveIn
    resolveInOp -> resolveoneIn
    resolveInOp -> invresolveoneIn
    
    resolveInExpCS ::= lateOpt resolveInOp '(' scoped_identifier ',' resolveOpArgsExpCS ')'
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
        
    resolveInExpCS ::= lateOpt resolveInOp '(' scoped_identifier ')'
        /.$BeginJava
                    CSTNode result = createResolveInExpCS(
                            getIToken($getToken(1)),
                            getIToken($getToken(2)),
                            (ScopedNameCS)$getSym(4),
                            null);
                            setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
                    $setResult(result);
          $EndJava
        ./
        
        
    resolveInExpCS ::= lateOpt resolveInOp '(' scoped_identifier ',' resolveOpArgsExpCSOpt qvtErrorToken
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
        
    resolveInExpCS ::= lateOpt resolveInOp '(' scoped_identifier qvtErrorToken
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
	oclExpCS -> resolveResolveInExpCS

	-- operation call and expression extension in QVT
	featureCallExpCS -> featureMappingCallExpCS
	oclExpCS -> mappingCallExpCS

	oclExpCS -> outExpCS 



    -- Resolve family ends here
		
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
		

    modelTypeWhereCSOpt ::= $empty
		/.$EmptyListAction./
    modelTypeWhereCSOpt ::= where '{' statementListOpt '}'
		/.$BeginJava
					EList result = (EList)$getSym(3);
					$setResult(result);
		  $EndJava
		./

$End

	