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
-- * $Id: QvtOpLPGParser.g,v 1.31 2008/12/29 19:08:02 aigdalov Exp $ 
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
    topLevel
$End

$Import
	ImperativeOCL.g

$Globals
	/.	
	import org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum;
	import org.eclipse.m2m.internal.qvt.oml.cst.ImportCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingEndCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingInitCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;	
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS;
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
	import org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.OppositePropertyCS;
	import org.eclipse.ocl.cst.PrimitiveLiteralExpCS;
	import org.eclipse.ocl.cst.BooleanLiteralExpCS;
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
	opposites
	class
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

$Terminals

	STEREOTYPE_QUALIFIER_OPEN
	STEREOTYPE_QUALIFIER_CLOSE
	MULTIPLICITY_RANGE
	TILDE_SIGN

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
 * $Id: QvtOpLPGParser.g,v 1.31 2008/12/29 19:08:02 aigdalov Exp $
 */
	./
$End

$Rules

	-- opt = optional
	-- m = multiple
	
	--=== // start rule (start) ===--
	-- to support legacy usage of imports after transformation header
	topLevel ::= unit_elementList
		/.$BeginJava
					EList<CSTNode> unitElements = (EList<CSTNode>)$getSym(1);
					$setResult(setupTopLevel(unitElements));
		  $EndJava
		./

	unit_element -> _import

	_import ::= import unit ';'
		/.$BeginJava
					CSTNode result = createModuleImportCS(
							(PathNameCS)$getSym(2)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./

	_import ::= import qvtErrorToken
		/.$BeginJava
					CSTNode result = createLibraryImportCS(
							createPathNameCS()
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	unit -> qualifiedNameCS
		
	--=== // start rule (end) ===--

	--=== // definitions in a compilation unit (start) ===--
	unit_elementList ::= unit_elementList unit_element
		/.$BeginJava
					EList list = (EList)$getSym(1);
					list.add($getSym(2));
					$setResult(list);
		  $EndJava
		./

	unit_elementList ::= $empty
		/.$EmptyListAction./

	unit_element -> _transformation
        unit_element -> _library
        unit_element -> _modeltype
        unit_element -> classifier
        unit_element -> _property
        unit_element -> _helper
        unit_element -> entry
        unit_element -> _mapping

	--=== // definitions in a compilation unit (end) ===--

	--=== // Transformation and library definitions (start) ===--
	_transformation -> transformation_decl
	_transformation -> transformation_def 
	
	transformation_decl ::= transformation_h ';' 
		/.$BeginJava
					TransformationHeaderCS headerCS = (TransformationHeaderCS) $getSym(1);
					setOffsets(headerCS, headerCS, getIToken($getToken(2)));
					MappingModuleCS moduleCS = createMappingModuleCS(headerCS, $EMPTY_ELIST);
					setOffsets(moduleCS, headerCS);
					$setResult(moduleCS);
		  $EndJava
		./

	transformation_def ::= transformation_h '{' module_elementList '}' semicolonOpt
		/.$BeginJava
					TransformationHeaderCS headerCS = (TransformationHeaderCS) $getSym(1);
					MappingModuleCS moduleCS = createMappingModuleCS(headerCS, (EList) $getSym(3));
					setOffsets(moduleCS, headerCS, getIToken($getToken(4)));
					$setResult(moduleCS);
		  $EndJava
		./
	 
	_library -> library_decl
	_library -> library_def

	library_decl ::= library_h ';'
		/.$BeginJava
					TransformationHeaderCS headerCS = (TransformationHeaderCS) $getSym(1);
					setOffsets(headerCS, headerCS, getIToken($getToken(2)));
					MappingModuleCS moduleCS = createLibraryCS(headerCS, $EMPTY_ELIST);
					setOffsets(moduleCS, headerCS);
					$setResult(moduleCS);
		  $EndJava
		./

	library_def ::= library_h '{' module_elementList '}' semicolonOpt
		/.$BeginJava
					TransformationHeaderCS headerCS = (TransformationHeaderCS) $getSym(1);
					MappingModuleCS moduleCS = createLibraryCS(headerCS, (EList) $getSym(3));
					setOffsets(moduleCS, headerCS, getIToken($getToken(4)));
					$setResult(moduleCS);
		  $EndJava
		./


	--=== // Transformation and library definitions (end) ===--


	--=== // Transformation header (start) ===--
	transformation_h ::= qualifierList transformation qualifiedNameCS transformation_signature transformation_usage_refineOpt
		/.$BeginJava
					EList qualifierList = (EList) $getSym(1);
					EList transfUsages = $EMPTY_ELIST;
					TransformationRefineCS transfRefine = null;
					Object transformation_usage_refineOpt = $getSym(5);
					if (transformation_usage_refineOpt instanceof TransformationRefineCS) {
						transfRefine = (TransformationRefineCS) transformation_usage_refineOpt;
					} else if (transformation_usage_refineOpt instanceof EList) {
						transfUsages = (EList) transformation_usage_refineOpt;
					}
					CSTNode result = createTransformationHeaderCS(
							qualifierList,
							(PathNameCS)$getSym(3),
							(SimpleSignatureCS)$getSym(4),
							transfUsages,
							transfRefine
						);
					if (qualifierList.isEmpty()) {
						setOffsets(result, getIToken($getToken(2)));
					} else {
						setOffsets(result, (CSTNode) qualifierList.get(0));
					}
					if (transfRefine == null) {
						if (transfUsages.isEmpty()) {
							setOffsets(result, result, (SimpleSignatureCS)$getSym(4));
						}
						else {
							setOffsets(result, result, (CSTNode) transfUsages.get(transfUsages.size()-1));
						}
					} else {
						setOffsets(result, result, transfRefine);
					}
					$setResult(result);
		  $EndJava
		./


	transformation_usage_refineOpt ::= $empty
		/.$NullAction./
	transformation_usage_refineOpt -> transformation_usage_refine

	transformation_usage_refine -> module_usageList
	transformation_usage_refine -> transformation_refine

	transformation_signature -> simple_signature

	transformation_refine ::= refines moduleref
		/.$BeginJava
					CSTNode result = createTransformationRefineCS(
							(ModuleRefCS)$getSym(2)
						);
					setOffsets(result, (ModuleRefCS)$getSym(2));
					$setResult(result);
		  $EndJava
		./
	--=== // Transformation header (end) ===--


	--=== // Library header (start) ===--

	library_h ::= library qualifiedNameCS library_signatureOpt module_usageListOpt
		/.$BeginJava
					PathNameCS name = (PathNameCS)$getSym(2);
					SimpleSignatureCS signature = ($getSym(3) == null) ? createSimpleSignatureCS($EMPTY_ELIST) : (SimpleSignatureCS)$getSym(3);
					EList<ModuleUsageCS> moduleUsages = (EList<ModuleUsageCS>)$getSym(4);
					CSTNode result = createTransformationHeaderCS(
							$EMPTY_ELIST,
							name,
							signature,
							moduleUsages,
							null
						);
					CSTNode rightNode = name;
					if (!moduleUsages.isEmpty()) {
						rightNode = moduleUsages.get(moduleUsages.size() - 1);
					} else if ($getSym(3) != null) {
						rightNode = signature;
					}
					setOffsets(result, getIToken($getToken(1)), rightNode);
					$setResult(result);
		  $EndJava
		./
	library_h ::= library qvtErrorToken
		/.$BeginJava
					CSTNode result = createTransformationHeaderCS(
							$EMPTY_ELIST,
							createPathNameCS(),
							createSimpleSignatureCS($EMPTY_ELIST),
							$EMPTY_ELIST,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	library_signatureOpt ::= $empty
		/.$NullAction./
	library_signatureOpt -> library_signature

	library_signature -> simple_signature

	--=== // Library header (end) ===--
	
	--=== // import of transformation and library (start) ===--
	module_usageList ::= module_usage
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	module_usageList ::= module_usageList module_usage
		/.$BeginJava
					EList result = (EList) $getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndJava
		./

	module_usageListOpt ::= $empty
		/.$EmptyListAction./
	module_usageListOpt -> module_usageList

	module_usage -> access_usage
	module_usage -> extends_usage
	
	access_usage ::= access module_kindOpt moduleref_list
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
	extends_usage ::= extends module_kindOpt moduleref_list
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
	
	module_kindOpt ::= $empty
		/.$NullAction./
	module_kindOpt -> module_kind
	
	module_kind ::= transformation
		/.$BeginJava
					CSTNode result = createModuleKindCS(
							ModuleKindEnum.TRANSFORMATION
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	module_kind ::= library
		/.$BeginJava
					CSTNode result = createModuleKindCS(
							ModuleKindEnum.LIBRARY
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	
	moduleref_list ::= moduleref
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	moduleref_list ::= moduleref_list ',' moduleref
		/.$BeginJava
					EList result = (EList) $getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
	moduleref_list ::= moduleref_list qvtErrorToken
		/.$BeginJava
					EList result = (EList) $getSym(1);
					$setResult(result);
		  $EndJava
		./
	
	moduleref ::= pathNameCS simple_signatureOpt
		/.$BeginJava
					SimpleSignatureCS signature = (SimpleSignatureCS)$getSym(2);
					CSTNode result = createModuleRefCS(
							(PathNameCS)$getSym(1),
							signature 
						);
					CSTNode rightNode = (signature == null) ? (CSTNode)$getSym(1) : signature;
					setOffsets(result, (CSTNode)$getSym(1), rightNode);
					$setResult(result);
		  $EndJava
		./
	--=== // import of transformation and library (end) ===--
	
	--=== // module definitions (start) ===--

	module_elementList ::= module_elementList module_element
		/.$BeginJava
					EList list = (EList)$getSym(1);
					list.add($getSym(2));
					$setResult(list);
		  $EndJava
		./

	module_elementList ::= $empty
		/.$EmptyListAction./

	module_element -> classifier
	module_element -> _property
	module_element -> _helper
	module_element -> entry
	module_element -> _mapping

	--=== // module definitions (end) ===--
	
	--=== // model types compliance and metamodel declarations (start) ===--
	_modeltype -> modelTypeExpCS
	_modeltype ::= metamodel stringLiteralExpCS ';'
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
	_modeltype ::= metamodel qvtErrorToken
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

	complianceKindCSOpt ::= $empty
		/.$BeginJava
					CSTNode result = createStringLiteralExpCS("''");
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	complianceKindCSOpt -> qvtStringLiteralExpCS
    
	
	qvtStringLiteralExpCS -> stringLiteralExpCS
	qvtStringLiteralExpCS ::= QUOTE_STRING_LITERAL
		/.$BeginJava
					CSTNode result = createStringLiteralExpCS("'" + unquote(getTokenText($getToken(1))) + "'"); //$NON-NLS-1$ //$NON-NLS-2$
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

	--=== // model types compliance and metamodel declarations (start) ===--

	classifier ->  classifierDefCS

	classifierDefCS ::= intermediate class qvtIdentifierCS classifierExtensionOpt '{' classifierFeatureListOpt '}' semicolonOpt 
		/.$BeginJava
					CSTNode result = createClassifierDefCS(
							getIToken($getToken(3)),
							(EList) $getSym(4),
							(EList) $getSym(6)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
					$setResult(result);
		  $EndJava
		./

	classifierExtensionOpt ::= $empty
		/.$EmptyListAction./
	classifierExtensionOpt ::= extends type_list
		/.$BeginJava
					EList result = (EList)$getSym(2);
					$setResult(result);
		  $EndJava
		./	
	type_list ::= typeCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	type_list ::= type_list ',' typeCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
	type_list ::= type_list qvtErrorToken
		/.$BeginJava
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndJava
		./
	
	classifierFeatureListOpt ::= $empty
		/.$EmptyListAction./
	classifierFeatureListOpt -> classifierFeatureList semicolonOpt
	
	classifierFeatureList ::= classifierFeatureCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	classifierFeatureList ::= classifierFeatureList ';' classifierFeatureCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndJava
		./
	classifierFeatureList ::= classifierFeatureList qvtErrorToken
		/.$BeginJava
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndJava
		./

	classifierFeatureCS ::= stereotype_qualifier_list feature_key_list qvtIdentifierCS ':' typeCS multiplicityOpt ordered_prop opposite_propertyOpt init_partOpt
		/.$BeginJava
					EList stereotypeQualifiers = (EList) $getSym(1);
					EList featureKeys = (EList) $getSym(2);
					MultiplicityDefCS multiplicityDef = (MultiplicityDefCS) $getSym(6);
					OppositePropertyCS oppositeProperty = (OppositePropertyCS) $getSym(8);
					OCLExpressionCS initExpression = (OCLExpressionCS) $getSym(9);
					CSTNode result = createClassifierPropertyCS(
							stereotypeQualifiers,
							featureKeys,
							getIToken($getToken(3)),
							(TypeCS) $getSym(5),
							((BooleanLiteralExpCS) $getSym(7)).getBooleanSymbol().booleanValue(),
							initExpression,
							multiplicityDef,
							oppositeProperty
						);
					
					int startOffset = getIToken($getToken(3)).getStartOffset();
					if (!featureKeys.isEmpty()) {
						startOffset = ((CSTNode) featureKeys.get(0)).getStartOffset();
					}
					if (!stereotypeQualifiers.isEmpty()) {
						startOffset = ((IToken) stereotypeQualifiers.get(0)).getStartOffset();
					}
					
					CSTNode lastToken = (CSTNode) $getSym(5);
					if (initExpression != null) {
						lastToken = initExpression;
					}
					if (multiplicityDef != null) {
						lastToken = multiplicityDef;
					}
					if (oppositeProperty != null) {
						lastToken = oppositeProperty;
					}
					
					setOffsets(result, lastToken);
					result.setStartOffset(startOffset);
					$setResult(result);
		  $EndJava
		./

	init_partOpt ::= $empty
		/.$NullAction./
	init_partOpt ::= '=' oclExpressionCS
		/.$BeginJava
					CSTNode result = (CSTNode) $getSym(2);
					$setResult(result);
		  $EndJava
		./

	stereotype_qualifier_list ::= $empty
		/.$EmptyListAction./
	stereotype_qualifier_list ::= STEREOTYPE_QUALIFIER_OPEN identifier_list STEREOTYPE_QUALIFIER_CLOSE
		/.$BeginJava
					EList result = (EList)$getSym(2);
					$setResult(result);
		  $EndJava
		./

	identifier_list ::= qvtIdentifierCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add(getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	identifier_list ::= identifier_list ',' qvtIdentifierCS
		/.$BeginJava
					EList result = (EList) $getSym(1);
					result.add(getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	identifier_list ::= identifier_list qvtErrorToken
		/.$BeginJava
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndJava
		./

	feature_key_list ::= $empty
		/.$EmptyListAction./
	feature_key_list ::= feature_key_list feature_key
		/.$BeginJava
					EList result = (EList) $getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndJava
		./
	feature_key_list ::= feature_key_list qvtErrorToken
		/.$BeginJava
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndJava
		./
		
	feature_key ::= composes
		/.$NewCase./
	feature_key ::= references
		/.$NewCase./
	feature_key ::= readonly
		/.$NewCase./
	feature_key ::= derived
		/.$NewCase./
	feature_key ::= static
		/.$BeginJava
					CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
		
	multiplicityOpt ::= $empty
		/.$NullAction./
	multiplicityOpt ::= LBRACKET multiplicity_range RBRACKET
		/.$BeginJava
					CSTNode result = (CSTNode) $getSym(2);
					$setResult(result);
		  $EndJava
		./
		
	multiplicity_range ::= integerLiteralExpCS
		/.$BeginJava
					CSTNode result = createMultiplicityDefCS(
							(PrimitiveLiteralExpCS) $getSym(1),
							(PrimitiveLiteralExpCS) $getSym(1)
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	multiplicity_range ::= unlimitedNaturalLiteralExpCS
		/.$BeginJava
					PrimitiveLiteralExpCS lowerBound = createIntegerLiteralExpCS(Integer.toString(0));
					setOffsets(lowerBound, getIToken($getToken(1)));
					CSTNode result = createMultiplicityDefCS(
							lowerBound, 
							(PrimitiveLiteralExpCS) $getSym(1)
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	multiplicity_range ::= integerLiteralExpCS MULTIPLICITY_RANGE integerLiteralExpCS
		/.$NewCase./
	multiplicity_range ::= integerLiteralExpCS DOTDOT integerLiteralExpCS
		/.$NewCase./
	multiplicity_range ::= integerLiteralExpCS MULTIPLICITY_RANGE unlimitedNaturalLiteralExpCS
		/.$NewCase./
	multiplicity_range ::= integerLiteralExpCS DOTDOT unlimitedNaturalLiteralExpCS
		/.$BeginJava
					CSTNode result = createMultiplicityDefCS(
							(PrimitiveLiteralExpCS) $getSym(1),
							(PrimitiveLiteralExpCS) $getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./

	ordered_prop ::= ordered
		/.$BeginJava
					CSTNode result = createBooleanLiteralExpCS(Boolean.TRUE.toString());
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	ordered_prop ::= $empty
		/.$BeginJava
					CSTNode result = createBooleanLiteralExpCS(Boolean.FALSE.toString());
					$setResult(result);
		  $EndJava
		./
		
	opposite_propertyOpt ::= $empty
		/.$NullAction./
	opposite_propertyOpt ::= opposites navigable_prop qvtIdentifierCS multiplicityOpt
		/.$BeginJava
					MultiplicityDefCS multiplicityDef = (MultiplicityDefCS) $getSym(4);
					CSTNode result = createOppositePropertyCS(
							getIToken($getToken(3)),
							((BooleanLiteralExpCS) $getSym(2)).getBooleanSymbol().booleanValue(),
							multiplicityDef
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					if (multiplicityDef != null) {
						result.setEndOffset(multiplicityDef.getEndOffset());
					}
					$setResult(result);
		  $EndJava
		./

	navigable_prop ::= TILDE_SIGN
		/.$BeginJava
					CSTNode result = createBooleanLiteralExpCS(Boolean.FALSE.toString());
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	navigable_prop ::= $empty
		/.$BeginJava
					CSTNode result = createBooleanLiteralExpCS(Boolean.TRUE.toString());
					$setResult(result);
		  $EndJava
		./

		
	_property -> modulePropertyCS
	
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

	-- // syntax for helper operations (start)

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

	-- // syntax for helper operations (end)


	--=== // Syntax for entries (start) ===--

	entry -> entry_decl
	entry -> entry_def

	entry_header ::= main simple_signature
		/.$BeginJava
					IToken nameToken = getIToken($getToken(1));				
					ScopedNameCS nameCS = createScopedNameCS(null, getTokenText($getToken(1)));								
					nameCS.setStartOffset(nameToken.getStartOffset());
					nameCS.setEndOffset(nameToken.getEndOffset());
		
		                        SimpleSignatureCS signature = (SimpleSignatureCS)$getSym(2);
					CSTNode result = createMappingDeclarationCS(
							null,
							nameCS,
							signature.getParams(),
							null
						);
					setOffsets(result, getIToken($getToken(1)), signature);
					$setResult(result);
		  $EndJava
		./

	entry_header ::= main qvtErrorToken
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

	entry_decl ::= entry_header ';'
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

	entry_def ::= entry_header expression_block semicolonOpt 
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

	--=== // Syntax for entries (end) ===--

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

	mapping_def ::= mapping_full_header '{' mapping_body '}' semicolonOpt
		/.$BeginJava
					MappingSectionsCS mappingSections = (MappingSectionsCS)$getSym(3);
					setOffsets(mappingSections, getIToken($getToken(2)), getIToken($getToken(4)));

					MappingBodyCS mappingBodyCS = mappingSections.getMappingBodyCS();
					if (mappingBodyCS != null) {
						if (mappingBodyCS.getStartOffset() < 0) {
							mappingBodyCS.setStartOffset(mappingSections.getStartOffset());
						}
						if (mappingBodyCS.getEndOffset() < 0) {
							mappingBodyCS.setEndOffset(mappingSections.getEndOffset());
						}
					}

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

	_when ::= when '{' oclExpressionCS semicolonOpt '}'
		/.$BeginJava
					OCLExpressionCS result = (OCLExpressionCS)$getSym(3);
					$setResult(result);
		  $EndJava
		./
	_when ::= when qvtErrorToken
		/.$NullAction./

	mapping_body ::= init_sectionOpt population_sectionOpt end_sectionOpt
		/.$BeginJava
		                        MappingInitCS mappingInitCS = (MappingInitCS)$getSym(1);
					MappingBodyCS mappingBodyCS = (MappingBodyCS)$getSym(2);
					MappingEndCS mappingEndCS = (MappingEndCS)$getSym(3);

					if (mappingBodyCS != null) {
						if ((mappingBodyCS.getStartOffset() < 0) && (mappingInitCS != null)) {
							mappingBodyCS.setStartOffset(mappingInitCS.getEndOffset() + 1);
						}
						if ((mappingBodyCS.getEndOffset() < 0) && (mappingEndCS != null)) {
							mappingBodyCS.setEndOffset(mappingEndCS.getStartOffset() - 1);
						}
						if (mappingBodyCS.getStartOffset() > mappingBodyCS.getEndOffset()) {
							mappingBodyCS.setEndOffset(mappingBodyCS.getStartOffset());
						}
					}
					
					CSTNode result = createMappingSectionsCS(
							mappingInitCS,
							mappingBodyCS,
							mappingEndCS
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

	
	population_sectionOpt ::= $empty
		/.$BeginJava
					MappingBodyCS result = createMappingBodyCS(
							$EMPTY_ELIST,
							false
						);
					// offsets will be updated further in parent non-terminals
					result.setStartOffset(-1); 
					result.setEndOffset(-1);
					$setResult(result);
		  $EndJava
		./
	population_sectionOpt -> population_section

	population_section ::= expression_list 
		/.$BeginJava
					EList<OCLExpressionCS> expressionList = (EList<OCLExpressionCS>) $getSym(1);
					MappingBodyCS result = createMappingBodyCS(
							expressionList,
							false
						);
					CSTNode startExp = expressionList.get(0);
					CSTNode endExp = expressionList.get(expressionList.size() - 1);
					setOffsets(result, startExp, endExp);
					$setResult(result);
		  $EndJava
		./

	population_section ::= population expression_block 
		/.$BeginJava
					BlockExpCS blockExpCS = (BlockExpCS) $getSym(2);
					MappingBodyCS result = createMappingBodyCS(
							blockExpCS.getBodyExpressions(),
							true
						);
					setOffsets(result, getIToken($getToken(1)), blockExpCS);
					$setResult(result);
		  $EndJava
		./
	
	population_section ::= population qvtErrorToken
		/.$BeginJava
					CSTNode result = createMappingBodyCS(
							$EMPTY_ELIST,
							true
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

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
				SimpleNameCS varName = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText($getToken(1)));
				setOffsets(varName, getIToken($getToken(1)));
				CSTNode result = createOutExpCS(varName,(TypeSpecCS)$getSym(3));					
				$setResult(result);
		  $EndJava
		./
	
	outExpCS ::= object objectDeclCS expression_block
		/.$BeginJava
					BlockExpCS blockExpCS = (BlockExpCS) $getSym(3);
					CSTNode result = setupOutExpCS(
							(OutExpCS)$getSym(2),					
							blockExpCS.getBodyExpressions(),
							// passing body positions
							blockExpCS.getStartOffset(),
							blockExpCS.getEndOffset()
						); 
					setOffsets(result, getIToken($getToken(1)), blockExpCS);
					$setResult(result);
		  $EndJava
		./
	outExpCS ::= object objectDeclCS qvtErrorToken
		/.$BeginJava
					OutExpCS objectDeclCS = ((OutExpCS)$getSym(2));  
					CSTNode result = createOutExpCS(
							objectDeclCS.getSimpleNameCS(),						
							objectDeclCS.getTypeSpecCS()
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
		
$End

	