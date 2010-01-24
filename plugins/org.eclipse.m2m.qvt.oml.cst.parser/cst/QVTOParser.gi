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
-- * $Id: QVTOParser.gi,v 1.3 2010/01/24 13:59:56 sboyko Exp $ 
-- */
--
-- The QVTo Parser
--

%options escape=$
%options la=2
%options fp=QVTOParser,prefix=TK_
%options noserialize
%options import_terminals=QVTOLexer.gi
%options ast_type=CSTNode
%options template=btParserTemplateF.gi
%options include_directory=".;../lpg"


%Import
	ImperativeOCL.gi
%End

%Globals
	/.	
	import org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralPartCS;	
	import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingEndCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingInitCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;	
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.ConstructorCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.ObjectExpCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.temp.ResolveOpArgsExpCS;
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
	import org.eclipse.ocl.cst.LiteralExpCS;	
	import org.eclipse.ocl.cst.DotOrArrowEnum;
	import org.eclipse.ocl.util.OCLStandardLibraryUtil;
	import org.eclipse.ocl.utilities.PredefinedType;
	import org.eclipse.ocl.Environment;
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
	init
	static
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
	when
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
	result
	main
	this
	rename
	disjuncts
	merges
	inherits
	composes
	constructor
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

%End

%Terminals
	STEREOTYPE_QUALIFIER_OPEN  ::= '<<'
	STEREOTYPE_QUALIFIER_CLOSE ::= '>>'
	MULTIPLICITY_RANGE         ::= '...'
	TILDE_SIGN                 ::= '~'

%End

%Start
	topLevel
%End

%Rules
	-- opt = optional
	-- m = multiple
	
	--=== // start rule (start) ===--
	-- to support legacy usage of imports after transformation header
	topLevel ::= unit_elementList
		/.$BeginCode
					EList<CSTNode> unitElements = (EList<CSTNode>)$getSym(1);
					$setResult(setupTopLevel(unitElements));
		  $EndCode
		./

	unit_element -> _import

	_import ::= import unit ';'
		/.$BeginCode
					CSTNode result = createImportCS(
							(PathNameCS)$getSym(2)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./

	_import ::= import qvtErrorToken
		/.$BeginCode
					CSTNode result = createLibraryImportCS(
							createPathNameCS()
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./

	unit -> qualifiedNameCS
	--=== // start rule (end) ===--

	--=== // definitions in a compilation unit (start) ===--
	unit_elementList ::= unit_elementList unit_element
		/.$BeginCode
					EList list = (EList)$getSym(1);
					list.add($getSym(2));
					$setResult(list);
		  $EndCode
		./

	unit_elementList ::= %empty
		/.$EmptyListAction./

	unit_element -> _transformation
	unit_element -> _library
	unit_element -> _modeltype
	unit_element -> classifier
	unit_element -> _property
	unit_element -> _helper
	unit_element -> _constructor
	unit_element -> entry
	unit_element -> _mapping
	unit_element -> _tag ';'
	unit_element ::= qvtErrorToken
		/.$NullAction./
	--=== // definitions in a compilation unit (end) ===--

	--=== // Transformation and library definitions (start) ===--
	_transformation -> transformation_decl
	_transformation -> transformation_def 
	
	transformation_decl ::= transformation_h ';' 
		/.$BeginCode
					TransformationHeaderCS headerCS = (TransformationHeaderCS) $getSym(1);
					setOffsets(headerCS, headerCS, getIToken($getToken(2)));
					MappingModuleCS moduleCS = createMappingModuleCS(headerCS, $EMPTY_ELIST);
					setOffsets(moduleCS, headerCS);
					$setResult(moduleCS);
		  $EndCode
		./

	transformation_def ::= transformation_h '{' module_elementList '}' semicolonOpt
		/.$BeginCode
					TransformationHeaderCS headerCS = (TransformationHeaderCS) $getSym(1);
					MappingModuleCS moduleCS = createMappingModuleCS(headerCS, (EList) $getSym(3));
					setOffsets(moduleCS, headerCS, getIToken($getToken(4)));
					$setResult(moduleCS);
		  $EndCode
		./
	 
	_library -> library_decl
	_library -> library_def

	library_decl ::= library_h ';'
		/.$BeginCode
					TransformationHeaderCS headerCS = (TransformationHeaderCS) $getSym(1);
					setOffsets(headerCS, headerCS, getIToken($getToken(2)));
					MappingModuleCS moduleCS = createLibraryCS(headerCS, $EMPTY_ELIST);
					setOffsets(moduleCS, headerCS);
					$setResult(moduleCS);
		  $EndCode
		./

	library_def ::= library_h '{' module_elementList '}' semicolonOpt
		/.$BeginCode
					TransformationHeaderCS headerCS = (TransformationHeaderCS) $getSym(1);
					MappingModuleCS moduleCS = createLibraryCS(headerCS, (EList) $getSym(3));
					setOffsets(moduleCS, headerCS, getIToken($getToken(4)));
					$setResult(moduleCS);
		  $EndCode
		./
	--=== // Transformation and library definitions (end) ===--


	--=== // Transformation header (start) ===--
	transformation_h ::= qualifierList transformation qualifiedNameCS transformation_signature transformation_usage_refineOpt
		/.$BeginCode
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
		  $EndCode
		./


	transformation_usage_refineOpt ::= %empty
		/.$NullAction./
	transformation_usage_refineOpt -> transformation_usage_refine

	transformation_usage_refine -> module_usageList
	transformation_usage_refine -> transformation_refine

	transformation_signature -> simple_signature

	transformation_refine ::= refines moduleref
		/.$BeginCode
					CSTNode result = createTransformationRefineCS(
							(ModuleRefCS)$getSym(2)
						);
					setOffsets(result, (ModuleRefCS)$getSym(2));
					$setResult(result);
		  $EndCode
		./
	--=== // Transformation header (end) ===--


	--=== // Library header (start) ===--
	library_h ::= library qualifiedNameCS library_signatureOpt module_usageListOpt
		/.$BeginCode
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
		  $EndCode
		./
	library_h ::= library qvtErrorToken
		/.$BeginCode
					CSTNode result = createTransformationHeaderCS(
							$EMPTY_ELIST,
							createPathNameCS(),
							createSimpleSignatureCS($EMPTY_ELIST),
							$EMPTY_ELIST,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./

	library_signatureOpt ::= %empty
		/.$NullAction./
	library_signatureOpt -> library_signature

	library_signature -> simple_signature
	--=== // Library header (end) ===--
	
	--=== // import of transformation and library (start) ===--
	module_usageList ::= module_usage
		/.$BeginCode
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndCode
		./
	module_usageList ::= module_usageList module_usage
		/.$BeginCode
					EList result = (EList) $getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndCode
		./

	module_usageListOpt ::= %empty
		/.$EmptyListAction./
	module_usageListOpt -> module_usageList

	module_usage -> access_usage
	module_usage -> extends_usage
	
	access_usage ::= access module_kindOpt moduleref_list
		/.$BeginCode
					EList moduleRefList = (EList)$getSym(3);
					CSTNode result = createModuleUsageCS(
							ImportKindEnum.ACCESS,
							(ModuleKindCS)$getSym(2),
							moduleRefList
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)moduleRefList.get(moduleRefList.size()-1));
					$setResult(result);
		  $EndCode
		./
	extends_usage ::= extends module_kindOpt moduleref_list
		/.$BeginCode
					EList moduleRefList = (EList)$getSym(3);
					CSTNode result = createModuleUsageCS(
							ImportKindEnum.EXTENSION,
							(ModuleKindCS)$getSym(2),
							moduleRefList
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)moduleRefList.get(moduleRefList.size()-1));
					$setResult(result);
		  $EndCode
		./
	
	module_kindOpt ::= %empty
		/.$NullAction./
	module_kindOpt -> module_kind
	
	module_kind ::= transformation
		/.$BeginCode
					CSTNode result = createModuleKindCS(
							ModuleKindEnum.TRANSFORMATION
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./
	module_kind ::= library
		/.$BeginCode
					CSTNode result = createModuleKindCS(
							ModuleKindEnum.LIBRARY
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./
	
	moduleref_list ::= moduleref
		/.$BeginCode
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndCode
		./
	moduleref_list ::= moduleref_list ',' moduleref
		/.$BeginCode
					EList result = (EList) $getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndCode
		./
	moduleref_list ::= moduleref_list qvtErrorToken
		/.$BeginCode
					EList result = (EList) $getSym(1);
					$setResult(result);
		  $EndCode
		./
	
	moduleref ::= pathNameCS simple_signatureOpt
		/.$BeginCode
					SimpleSignatureCS signature = (SimpleSignatureCS)$getSym(2);
					CSTNode result = createModuleRefCS(
							(PathNameCS)$getSym(1),
							signature 
						);
					CSTNode rightNode = (signature == null) ? (CSTNode)$getSym(1) : signature;
					setOffsets(result, (CSTNode)$getSym(1), rightNode);
					$setResult(result);
		  $EndCode
		./
	--=== // import of transformation and library (end) ===--
	
	--=== // module definitions (start) ===--
	module_elementList ::= module_elementList module_element
		/.$BeginCode
					EList list = (EList)$getSym(1);
					list.add($getSym(2));
					$setResult(list);
		  $EndCode
		./

	module_elementList ::= %empty
		/.$EmptyListAction./

	module_element -> classifier
	module_element -> _property
	module_element -> _helper
	module_element -> _constructor
	module_element -> entry
	module_element -> _mapping
	module_element -> _tag ';'
	module_element ::= qvtErrorToken
		/.$NullAction./
	--=== // module definitions (end) ===--
	
	--=== // model types compliance and metamodel declarations (start) ===--
	_modeltype ::= modeltype IDENTIFIER compliance_kindOpt uses packageref_list modeltype_whereOpt ';'
		/.$BeginCode
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
		  $EndCode
		./
	_modeltype ::= modeltype qvtErrorToken
		/.$BeginCode
					ModelTypeCS result = createModelTypeCS(
							new Token(0, 0, 0),
							null,
							$EMPTY_ELIST,
							$EMPTY_ELIST
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./
		
	modeltype_whereOpt ::= %empty
		/.$EmptyListAction./
	modeltype_whereOpt -> modeltype_where

	modeltype_where ::= where expression_block
		/.$BeginCode
					BlockExpCS blockExpCS = (BlockExpCS) $getSym(2);
					$setResult(blockExpCS.getBodyExpressions());
		  $EndCode
		./

	packageref_list ::= packageref
		/.$BeginCode
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndCode
		./
	packageref_list ::= packageref_list ',' packageref
		/.$BeginCode
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndCode
		./
	packageref_list ::= packageref_list qvtErrorToken
		/.$BeginCode
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndCode
		./

	packageref ::= pathNameCS
		/.$BeginCode
					CSTNode result = createPackageRefCS(
							(PathNameCS)$getSym(1),
							null
						);
					setOffsets(result, (CSTNode)$getSym(1));
					$setResult(result);
		  $EndCode
		./
	packageref ::= pathNameCS '(' uri ')'
		/.$BeginCode
					CSTNode result = createPackageRefCS(
							(PathNameCS)$getSym(1),
							(StringLiteralExpCS)$getSym(3)
						);
					setOffsets(result, (CSTNode)$getSym(1), getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./
	packageref ::= uri
		/.$BeginCode
					CSTNode result = createPackageRefCS(
							null,
							(StringLiteralExpCS)$getSym(1)
						);
					setOffsets(result, (CSTNode)$getSym(1));
					$setResult(result);
		  $EndCode
		./

	compliance_kindOpt ::= %empty
		/.$NullAction./
	compliance_kindOpt -> StringLiteralExpCS
	--=== // model types compliance and metamodel declarations (end) ===--

	--=== // like: "strict" and "effective" (start) ===--
	uri -> StringLiteralExpCS
	--=== // like: "strict" and "effective" (end) ===--

	--=== // Syntax for defining explicitly metamodel contents (start) ===--
	classifier ->  classifierDefCS

	classifierDefCS ::= intermediate class qvtIdentifierCS classifierExtensionOpt '{' classifierFeatureListOpt '}' semicolonOpt 
		/.$BeginCode
					CSTNode result = createClassifierDefCS(
							getIToken($getToken(3)),
							(EList) $getSym(4),
							(EList) $getSym(6)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
					$setResult(result);
		  $EndCode
		./

	classifierExtensionOpt ::= %empty
		/.$EmptyListAction./
	classifierExtensionOpt ::= extends type_list
		/.$BeginCode
					EList result = (EList)$getSym(2);
					$setResult(result);
		  $EndCode
		./	
	type_list ::= typeCS
		/.$BeginCode
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndCode
		./
	type_list ::= type_list ',' typeCS
		/.$BeginCode
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndCode
		./
	type_list ::= type_list qvtErrorToken
		/.$BeginCode
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndCode
		./
	
	classifierFeatureListOpt ::= %empty
		/.$EmptyListAction./
	classifierFeatureListOpt -> classifierFeatureList semicolonOpt
	
	classifierFeatureList ::= classifierFeatureCS
		/.$BeginCode
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndCode
		./
	classifierFeatureList ::= classifierFeatureList ';' classifierFeatureCS
		/.$BeginCode
					EList result = (EList)$getSym(1);
					result.add($getSym(3));
					$setResult(result);
		  $EndCode
		./
	classifierFeatureList ::= classifierFeatureList qvtErrorToken
		/.$BeginCode
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndCode
		./

	classifierFeatureCS ::= stereotype_qualifier_list feature_key_list qvtIdentifierCS ':' typeCS multiplicityOpt ordered_prop opposite_propertyOpt init_partOpt
		/.$BeginCode
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
		  $EndCode
		./
	classifierFeatureCS -> _tag

	init_partOpt ::= %empty
		/.$NullAction./
	init_partOpt ::= '=' OclExpressionCS
		/.$BeginCode
					CSTNode result = (CSTNode) $getSym(2);
					$setResult(result);
		  $EndCode
		./

	stereotype_qualifier_list ::= %empty
		/.$EmptyListAction./
	stereotype_qualifier_list ::= STEREOTYPE_QUALIFIER_OPEN identifier_list STEREOTYPE_QUALIFIER_CLOSE
		/.$BeginCode
					EList result = (EList)$getSym(2);
					$setResult(result);
		  $EndCode
		./

	identifier_list ::= qvtIdentifierCS
		/.$BeginCode
					EList result = new BasicEList();
					result.add(getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./
	identifier_list ::= identifier_list ',' qvtIdentifierCS
		/.$BeginCode
					EList result = (EList) $getSym(1);
					result.add(getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./
	identifier_list ::= identifier_list qvtErrorToken
		/.$BeginCode
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndCode
		./

	feature_key_list ::= %empty
		/.$EmptyListAction./
	feature_key_list ::= feature_key_list feature_key
		/.$BeginCode
					EList result = (EList) $getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndCode
		./
	feature_key_list ::= feature_key_list qvtErrorToken
		/.$BeginCode
					EList result = (EList)$getSym(1);
					$setResult(result);
		  $EndCode
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
		/.$BeginCode
					CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getIToken($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./
		
	multiplicityOpt ::= %empty
		/.$NullAction./
	multiplicityOpt ::= LBRACKET multiplicity_range RBRACKET
		/.$BeginCode
					CSTNode result = (CSTNode) $getSym(2);
					$setResult(result);
		  $EndCode
		./
		
	multiplicity_range ::= IntegerLiteralExpCS
		/.$BeginCode
					CSTNode result = createMultiplicityDefCS(
							(PrimitiveLiteralExpCS) $getSym(1),
							(PrimitiveLiteralExpCS) $getSym(1)
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./
	multiplicity_range ::= UnlimitedNaturalLiteralExpCS
		/.$BeginCode
					PrimitiveLiteralExpCS lowerBound = createIntegerLiteralExpCS(Integer.toString(0));
					setOffsets(lowerBound, getIToken($getToken(1)));
					CSTNode result = createMultiplicityDefCS(
							lowerBound, 
							(PrimitiveLiteralExpCS) $getSym(1)
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./
	multiplicity_range ::= IntegerLiteralExpCS MULTIPLICITY_RANGE IntegerLiteralExpCS
		/.$NewCase./
	multiplicity_range ::= IntegerLiteralExpCS DOTDOT IntegerLiteralExpCS
		/.$NewCase./
	multiplicity_range ::= IntegerLiteralExpCS MULTIPLICITY_RANGE UnlimitedNaturalLiteralExpCS
		/.$NewCase./
	multiplicity_range ::= IntegerLiteralExpCS DOTDOT UnlimitedNaturalLiteralExpCS
		/.$BeginCode
					CSTNode result = createMultiplicityDefCS(
							(PrimitiveLiteralExpCS) $getSym(1),
							(PrimitiveLiteralExpCS) $getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./

	ordered_prop ::= ordered
		/.$BeginCode
					CSTNode result = createBooleanLiteralExpCS(Boolean.TRUE.toString());
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./
	ordered_prop ::= %empty
		/.$BeginCode
					CSTNode result = createBooleanLiteralExpCS(Boolean.FALSE.toString());
					$setResult(result);
		  $EndCode
		./
		
	opposite_propertyOpt ::= %empty
		/.$NullAction./
	opposite_propertyOpt ::= opposites navigable_prop qvtIdentifierCS multiplicityOpt
		/.$BeginCode
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
		  $EndCode
		./

	navigable_prop ::= '~'
		/.$BeginCode
					CSTNode result = createBooleanLiteralExpCS(Boolean.FALSE.toString());
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./
	navigable_prop ::= %empty
		/.$BeginCode
					CSTNode result = createBooleanLiteralExpCS(Boolean.TRUE.toString());
					$setResult(result);
		  $EndCode
		./
	--=== // Syntax for defining explicitly metamodel contents (end) ===--
		
	--=== // Properties in transformation (start) ===--
	_property ::= configuration property qvtIdentifierCS ':' typeCS ';' 
		/.$BeginCode
					CSTNode result = createConfigPropertyCS(
							getIToken($getToken(3)),
							(TypeCS)$getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(6)));
					$setResult(result);
		  $EndCode
		./
	_property ::= configuration property qvtIdentifierCS ':' typeCS qvtErrorToken
		/.$BeginCode
					CSTNode result = createConfigPropertyCS(
							getIToken($getToken(3)),
							(TypeCS)$getSym(5)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndCode
		./
	_property ::= property qvtIdentifierCS ':' typeCS '=' OclExpressionCS ';' 
		/.$BeginCode
					CSTNode result = createLocalPropertyCS(
							getIToken($getToken(2)),
							(TypeCS)$getSym(4),
							(OCLExpressionCS)$getSym(6)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
					$setResult(result);
		  $EndCode
		./
	_property ::= property qvtIdentifierCS '=' OclExpressionCS ';' 
		/.$BeginCode
					CSTNode result = createLocalPropertyCS(
							getIToken($getToken(2)),
							null,
							(OCLExpressionCS)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndCode
		./
	_property ::= intermediate property scoped_identifier : typeCS ';' 
		/.$BeginCode
					CSTNode result = createContextualPropertyCS(
							(ScopedNameCS)$getSym(3),
							(TypeCS)$getSym(5),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(6)));
					$setResult(result);
		  $EndCode
		./
	_property ::= intermediate property scoped_identifier : typeCS '=' OclExpressionCS ';' 
		/.$BeginCode
					CSTNode result = createContextualPropertyCS(
							(ScopedNameCS)$getSym(3),
							(TypeCS)$getSym(5),
							(OCLExpressionCS)$getSym(7)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(8)));
					$setResult(result);
		  $EndCode
		./
	--=== // Properties in transformation (end) ===--

	--=== // Syntax for helper operations (start) ===--
	_helper -> helper_decl
	_helper -> helper_simple_def
	_helper -> helper_compound_def

	helper_header ::= helper_info scoped_identifier complete_signature 
		/.$BeginCode
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
					mappingDeclarationCS.setStartOffset(helperKind.getStartOffset());

					$setResult(mappingDeclarationCS);
		  $EndCode
		./

	helper_header ::= helper_info qvtErrorToken
		/.$BeginCode
					Object[] helperInfo = (Object[])$getSym(1);
					MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
						null,
						createScopedNameCS(null, ""),
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
					mappingDeclarationCS.setStartOffset(helperKind.getStartOffset());
	
					$setResult(mappingDeclarationCS);
		  $EndCode
		./

	helper_info ::= qualifierList helper_kind
		/.$BeginCode
					$setResult(new Object[] {$getSym(1), getIToken($getToken(2))});
		  $EndCode
		./

	helper_kind -> helper
	helper_kind -> query

	helper_decl ::= helper_header ';' 
		/.$BeginCode
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS)$getSym(1);
					MappingQueryCS result = createMappingQueryCS(
							false,
							mappingDecl,
							$EMPTY_ELIST
						);
					result.setBlackBox(true);
					setOffsets(result, mappingDecl, getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./

	helper_decl ::= helper_header qvtErrorToken 
		/.$BeginCode
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS)$getSym(1);
					MappingQueryCS result = createMappingQueryCS(
							false,
							mappingDecl,
							$EMPTY_ELIST
						);
					result.setBlackBox(true);
					setOffsets(result, mappingDecl);
					$setResult(result);
		  $EndCode
		./

	helper_simple_def ::= helper_header '=' OclExpressionCS ';' 
		/.$BeginCode
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS)$getSym(1);
					OCLExpressionCS expression = (OCLExpressionCS)$getSym(3);
					EList<OCLExpressionCS> expressionList = new BasicEList();
					expressionList.add(expression);
					MappingQueryCS result = createMappingQueryCS(
							false,
							mappingDecl,
							expressionList
						);
					result.setIsSimpleDefinition(true);
					setOffsets(result, mappingDecl, getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./

	helper_compound_def ::= helper_header expression_block semicolonOpt
		/.$BeginCode
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS)$getSym(1);
					BlockExpCS blockExpCS = (BlockExpCS)$getSym(2);
					CSTNode result = createMappingQueryCS(
							false,
							mappingDecl,
							blockExpCS.getBodyExpressions()
						);
					setOffsets(result, mappingDecl, blockExpCS);
					$setResult(result);
		  $EndCode
		./
	--=== // Syntax for helper operations (end) ===--

	--=== // Syntax for constructor operations (start) ===--
	_constructor -> constructor_decl
	_constructor -> constructor_def
	
	constructor_header ::= qualifierList constructor scoped_identifier simple_signature 
		/.$BeginCode
					SimpleSignatureCS signature = (SimpleSignatureCS) $getSym(4);					
					MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
						null,
						(ScopedNameCS) $getSym(3),
						signature.getParams(),
						null
					);
					setOffsets(mappingDeclarationCS, getIToken($getToken(2)), signature);

					EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>) $getSym(1);
					if (!qualifiers.isEmpty()) {
						mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
					}

					$setResult(mappingDeclarationCS);
		  $EndCode
		./

	constructor_decl ::= constructor_header ';' 
		/.$BeginCode
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS) $getSym(1);
					ConstructorCS result = createConstructorCS(
							mappingDecl,
							$EMPTY_ELIST
						);
					result.setBlackBox(true);
					setOffsets(result, mappingDecl, getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./

	constructor_decl ::= constructor_header qvtErrorToken 
		/.$BeginCode
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS) $getSym(1);
					ConstructorCS result = createConstructorCS(
							mappingDecl,
							$EMPTY_ELIST
						);
					result.setBlackBox(true);
					setOffsets(result, mappingDecl);
					$setResult(result);
		  $EndCode
		./

	constructor_def ::= constructor_header expression_block semicolonOpt
		/.$BeginCode
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS) $getSym(1);
					BlockExpCS blockExpCS = (BlockExpCS) $getSym(2);
					ConstructorCS result = createConstructorCS(
							mappingDecl,
							blockExpCS.getBodyExpressions()
						);
					setOffsets(result, mappingDecl, blockExpCS);
					$setResult(result);
		  $EndCode
		./

	--=== // Syntax for constructor operations (end) ===--

	--=== // Syntax for entries (start) ===--
	entry -> entry_decl
	entry -> entry_def

	entry_header ::= main simple_signature
		/.$BeginCode
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
		  $EndCode
		./

	entry_header ::= main qvtErrorToken
		/.$BeginCode
					CSTNode result = createMappingDeclarationCS(
							null,
							createScopedNameCS(null, getTokenText($getToken(1))),
							$EMPTY_ELIST,
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./

	entry_decl ::= entry_header ';'
		/.$BeginCode
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS)$getSym(1);
					MappingQueryCS result = createMappingQueryCS(
							true,
							mappingDecl,
							$EMPTY_ELIST
						);
					result.setBlackBox(true);
					setOffsets(result, mappingDecl, getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./

	entry_def ::= entry_header expression_block semicolonOpt 
		/.$BeginCode
					MappingDeclarationCS mappingDecl = (MappingDeclarationCS)$getSym(1);
					BlockExpCS blockExpCS = (BlockExpCS)$getSym(2);
					CSTNode result = createMappingQueryCS(
							true,
							mappingDecl,
							blockExpCS.getBodyExpressions()
						);
					setOffsets(result, mappingDecl, blockExpCS);
					$setResult(result);
		  $EndCode
		./
	--=== // Syntax for entries (end) ===--


	--=== // syntax for tag definition (start) ===--
	
	_tag ::= tag StringLiteralExpCS scoped_identifier tag_valueOpt
		/.$BeginCode
					OCLExpressionCS valueExpression = (OCLExpressionCS) $getSym(4);
					CSTNode result = createTagCS(
							(StringLiteralExpCS) $getSym(2),
							(ScopedNameCS) $getSym(3),
							valueExpression
						);
					setOffsets(result, getIToken($getToken(1)), valueExpression != null ? valueExpression : (CSTNode) $getSym(3));
					$setResult(result);
		  $EndCode
		./

	tag_valueOpt ::= %empty
		/.$NullAction./
	tag_valueOpt ::= '=' OclExpressionCS
		/.$BeginCode
					$setResult($getSym(2));
		  $EndCode
		./

	--=== // syntax for tag definition (end) ===--


	--=== // syntax for mapping operations (start) ===--
	_mapping -> mapping_decl
	_mapping -> mapping_def

	mapping_decl ::= mapping_full_header ';'
		/.$BeginCode
		                        Object[] mappingFullHeader = (Object[])$getSym(1);
					MappingRuleCS result = createMappingRuleCS(
							(MappingDeclarationCS)mappingFullHeader[0],
							(OCLExpressionCS)mappingFullHeader[1],
							null
						);
					result.setBlackBox(true);
					setOffsets(result, (MappingDeclarationCS)mappingFullHeader[0], getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./

	mapping_def ::= mapping_full_header '{' mapping_body '}' semicolonOpt
		/.$BeginCode
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
		  $EndCode
		./

	mapping_def ::= mapping_full_header '{' qvtErrorToken
		/.$BeginCode
		                        Object[] mappingFullHeader = (Object[])$getSym(1);
					MappingRuleCS result = createMappingRuleCS(
							(MappingDeclarationCS)mappingFullHeader[0],
							null,
							null
						);
					setOffsets(result, (MappingDeclarationCS)mappingFullHeader[0], getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./

	mapping_full_header ::= mapping_header _whenOpt
		/.$BeginCode
					$setResult(new Object[] {$getSym(1), $getSym(2)});
		  $EndCode
		./

	mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier complete_signature mapping_extraList
		/.$BeginCode
					DirectionKindCS directionKind = (DirectionKindCS)$getSym(3);
					CompleteSignatureCS completeSignature = (CompleteSignatureCS)$getSym(5);
					MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
						directionKind,
						(ScopedNameCS)$getSym(4),
						completeSignature.getSimpleSignature().getParams(),
						completeSignature.getResultParams()
					);
					
					mappingDeclarationCS.setStartOffset(directionKind == null ? getIToken($getToken(2)).getStartOffset() : directionKind.getStartOffset());
					mappingDeclarationCS.setEndOffset(completeSignature.getEndOffset());

					EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)$getSym(1);
					if(!qualifiers.isEmpty()) {
						mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
					}

					mappingDeclarationCS.getMappingExtension().addAll(((EList<MappingExtensionCS>)$getSym(6)));

					$setResult(mappingDeclarationCS);
		  $EndCode
		./

	mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier qvtErrorToken
		/.$BeginCode
					DirectionKindCS directionKind = (DirectionKindCS)$getSym(3);
					MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
						directionKind,
						(ScopedNameCS)$getSym(4),
						$EMPTY_ELIST,
						$EMPTY_ELIST
					);

					mappingDeclarationCS.setStartOffset(directionKind == null ? getIToken($getToken(2)).getStartOffset() : directionKind.getStartOffset());
					mappingDeclarationCS.setEndOffset(((CSTNode)$getSym(4)).getEndOffset());

					EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)$getSym(1);
					if(!qualifiers.isEmpty()) {
						mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
					}

					$setResult(mappingDeclarationCS);
		  $EndCode
		./

	mapping_header ::= qualifierList mapping qvtErrorToken
		/.$BeginCode
					MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
						null,
						createScopedNameCS(null, ""),
						$EMPTY_ELIST,
						$EMPTY_ELIST
					);
					
					setOffsets(mappingDeclarationCS, getIToken($getToken(2)), getIToken($getToken(2)));

					EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)$getSym(1);
					if(!qualifiers.isEmpty()) {
						mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
					}

					$setResult(mappingDeclarationCS);
		  $EndCode
		./


	mapping_extraList ::= mapping_extraList mapping_extra
		/.$BeginCode
					EList<MappingExtensionCS> extensionList = (EList<MappingExtensionCS>)$getSym(1);
					extensionList.add((MappingExtensionCS)$getSym(2));
					$setResult(extensionList);
		  $EndCode
		./

	mapping_extraList ::= %empty
		/.$EmptyListAction./

	mapping_extra -> mapping_extension

	mapping_extension ::= mapping_extension_key scoped_identifier_list
		/.$BeginCode
					MappingExtensionCS result = createMappingExtension(getTokenText($getToken(1)), (EList<ScopedNameCS>)$getSym(2));

					result.setStartOffset(getIToken($getToken(1)).getStartOffset());
					result.setEndOffset(getEndOffset(getIToken($getToken(1)), (EList<ScopedNameCS>)$getSym(2)));
				
					$setResult(result);
		  $EndCode
		./

	mapping_extension_key -> inherits
	mapping_extension_key -> merges
	mapping_extension_key -> disjuncts

	_whenOpt -> _when
	_whenOpt ::= %empty	 
		/.$NullAction./

	_when ::= when '{' OclExpressionCS semicolonOpt '}'
		/.$BeginCode
					OCLExpressionCS result = (OCLExpressionCS)$getSym(3);
					$setResult(result);
		  $EndCode
		./
	_when ::= when qvtErrorToken
		/.$NullAction./

	mapping_body ::= init_sectionOpt population_sectionOpt end_sectionOpt
		/.$BeginCode
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
		  $EndCode
		./

	init_sectionOpt ::= %empty
		/.$NullAction./
	init_sectionOpt -> init_section

	init_section ::= init expression_block
		/.$BeginCode
					BlockExpCS blockExpCS = (BlockExpCS) $getSym(2);
					CSTNode result = createMappingInitCS(
							blockExpCS.getBodyExpressions(),
							blockExpCS.getStartOffset(),
							blockExpCS.getEndOffset()
						);
					setOffsets(result, getIToken($getToken(1)), blockExpCS);
					$setResult(result);
		  $EndCode
		./

	init_section ::= init qvtErrorToken
		/.$BeginCode
					CSTNode result = createMappingInitCS(
							$EMPTY_ELIST,
							getIToken($getToken(1)).getEndOffset(),
							getIToken($getToken(1)).getStartOffset()
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./

	
	population_sectionOpt ::= %empty
		/.$BeginCode
					MappingBodyCS result = createMappingBodyCS(
							$EMPTY_ELIST,
							false
						);
					// offsets will be updated further in parent non-terminals
					result.setStartOffset(-1); 
					result.setEndOffset(-1);
					$setResult(result);
		  $EndCode
		./
	population_sectionOpt -> population_section

	population_section ::= expression_list 
		/.$BeginCode
					EList<OCLExpressionCS> expressionList = (EList<OCLExpressionCS>) $getSym(1);
					MappingBodyCS result = createMappingBodyCS(
							expressionList,
							false
						);
					if (expressionList.isEmpty()) {
						// offsets will be updated further in parent non-terminals
						result.setStartOffset(-1); 
						result.setEndOffset(-1);
					} else {
						CSTNode startExp = expressionList.get(0);
						CSTNode endExp = expressionList.get(expressionList.size() - 1);
						setOffsets(result, startExp, endExp);
					}
					$setResult(result);
		  $EndCode
		./

	population_section ::= population expression_block 
		/.$BeginCode
					BlockExpCS blockExpCS = (BlockExpCS) $getSym(2);
					MappingBodyCS result = createMappingBodyCS(
							blockExpCS.getBodyExpressions(),
							true
						);
					setOffsets(result, getIToken($getToken(1)), blockExpCS);
					$setResult(result);
		  $EndCode
		./
	
	population_section ::= population qvtErrorToken
		/.$BeginCode
					CSTNode result = createMappingBodyCS(
							$EMPTY_ELIST,
							true
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./

	end_sectionOpt ::= %empty
		/.$NullAction./
	end_sectionOpt -> end_section

	end_section ::= end expression_block
		/.$BeginCode
					BlockExpCS blockExpCS = (BlockExpCS) $getSym(2);
					CSTNode result = createMappingEndCS(
							blockExpCS.getBodyExpressions(),
							blockExpCS.getStartOffset(),
							blockExpCS.getEndOffset()
						);
					setOffsets(result, getIToken($getToken(1)), blockExpCS);
					$setResult(result);
		  $EndCode
		./

	end_section ::= end qvtErrorToken
		/.$BeginCode
					CSTNode result = createMappingEndCS(
							$EMPTY_ELIST,
							getIToken($getToken(1)).getEndOffset(),
							getIToken($getToken(1)).getStartOffset()
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./
	--=== // syntax for mapping operations (end) ===--

	--=== // Expressions (start) ===--
	typespecOpt ::= %empty
		/.$NullAction./
	typespecOpt -> typespec

	objectDeclCS ::= typespec
		/.$BeginCode
					CSTNode result = createOutExpCS(null, (TypeSpecCS)$getSym(1));
					$setResult(result);
		  $EndCode
		./

	objectIdentifierCS -> result
	objectIdentifierCS -> self
	objectIdentifierCS -> IDENTIFIER	
	
	objectDeclCS ::= objectIdentifierCS ':' typespecOpt
		/.$BeginCode
				SimpleNameCS varName = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getIToken($getToken(1)));
				setOffsets(varName, getIToken($getToken(1)));
				CSTNode result = createOutExpCS(varName,(TypeSpecCS)$getSym(3));					
				$setResult(result);
		  $EndCode
		./
	
	outExpCS ::= object objectDeclCS expression_block
		/.$BeginCode
					BlockExpCS blockExpCS = (BlockExpCS) $getSym(3);
					CSTNode result = setupOutExpCS(
							(ObjectExpCS) $getSym(2),					
							blockExpCS.getBodyExpressions(),
							// passing body positions
							blockExpCS.getStartOffset(),
							blockExpCS.getEndOffset()
						); 
					setOffsets(result, getIToken($getToken(1)), blockExpCS);
					$setResult(result);
		  $EndCode
		./
	outExpCS ::= object objectDeclCS qvtErrorToken
		/.$BeginCode
					ObjectExpCS objectDeclCS = ((ObjectExpCS) $getSym(2));  
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
		  $EndCode
		./
		
	featureMappingCallExpCS ::= map simpleNameCS '(' argumentsCSopt ')'
		/.$BeginCode
					CSTNode result = createFeatureMappingCallExpCS(
							null,
							(SimpleNameCS)$getSym(2),
							(EList)$getSym(4),
							false
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndCode
		./
	featureMappingCallExpCS ::= xmap simpleNameCS '(' argumentsCSopt ')'
		/.$BeginCode
					CSTNode result = createFeatureMappingCallExpCS(
							null,
							(SimpleNameCS)$getSym(2),
							(EList)$getSym(4),
							true
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndCode
		./

	featureMappingCallExpCS ::= map simpleNameCS '::' simpleNameCS '(' argumentsCSopt ')'
		/.$BeginCode
					CSTNode result = createFeatureMappingCallExpCS(
							(SimpleNameCS)$getSym(2),
							(SimpleNameCS)$getSym(4),
							(EList)$getSym(6),
							false
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
					$setResult(result);
		  $EndCode
		./
	featureMappingCallExpCS ::= xmap simpleNameCS '::' simpleNameCS '(' argumentsCSopt ')'
		/.$BeginCode
					CSTNode result = createFeatureMappingCallExpCS(
							(SimpleNameCS)$getSym(2),
							(SimpleNameCS)$getSym(4),
							(EList)$getSym(6),
							true
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
					$setResult(result);
		  $EndCode
		./

	mappingCallExpCS ::= map pathNameCS '(' argumentsCSopt ')'
		/.$BeginCode
					CSTNode result = createMappingCallExpCS(
							(PathNameCS)$getSym(2),
							(EList)$getSym(4),
							false
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndCode
		./
	mappingCallExpCS ::= xmap pathNameCS '(' argumentsCSopt ')'
		/.$BeginCode
					CSTNode result = createMappingCallExpCS(
							(PathNameCS)$getSym(2),
							(EList)$getSym(4),
							true
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndCode
		./

	-- Resolve family starts here

	resolveConditionOpt ::= %empty
	    /.$NullAction./
	    
	resolveConditionOpt ::= '|' OclExpressionCS
	    /.$BeginCode
	                $setResult((OCLExpressionCS)$getSym(2));
	      $EndCode
	    ./
	
	resolveConditionOpt ::= '|' qvtErrorToken
	    /.$NullAction./
        
		IDENTIFIEROpt ::= %empty
            /.$NullAction./
	
		IDENTIFIEROpt ::= IDENTIFIER ':'
	    /.$BeginCode
	                $setResult(getIToken($getToken(1)));
	      $EndCode
	    ./
	
	resolveOpArgsExpCSOpt ::= %empty
	    /.$NullAction./
            
	resolveOpArgsExpCSOpt -> resolveOpArgsExpCS
	    
	resolveOpArgsExpCS ::= IDENTIFIEROpt typeCS resolveConditionOpt
	    /.$BeginCode
	                CSTNode result = createResolveOpArgsExpCS(
	                        getIToken($getToken(1)),      // target_type_variable?
	                        (TypeCS)$getSym(2),           // type?
	                        (OCLExpressionCS)$getSym(3)); // condition?
	                        setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
                        $setResult(result);
	      $EndCode
	    ./
	
        resolveOp -> resolve
	resolveOp -> invresolve
	resolveOp -> resolveone
	resolveOp -> invresolveone
	
	lateOpt ::= %empty
	    /.$NullAction./
	lateOpt -> late
	
        resolveExpCS ::= lateOpt resolveOp '(' resolveOpArgsExpCSOpt ')'
	    /.$BeginCode
	                CSTNode result = createResolveExpCS(
                                getIToken($getToken(1)),
	                        getIToken($getToken(2)),
                                (ResolveOpArgsExpCS)$getSym(4));
                                setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
                        $setResult(result);
              $EndCode
            ./
            
        resolveExpCS ::= lateOpt resolveOp '(' resolveOpArgsExpCSOpt qvtErrorToken
            /.$BeginCode
	                CSTNode result = createResolveExpCS(
                                getIToken($getToken(1)),
	                        getIToken($getToken(2)),
	                        (ResolveOpArgsExpCS)$getSym(4));
	                        setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
	                $setResult(result);
	      $EndCode
	    ./
	    
	resolveExpCS ::= lateOpt resolveOp qvtErrorToken
	    /.$BeginCode
	                CSTNode result = createResolveExpCS(
	                        getIToken($getToken(1)),
	                        getIToken($getToken(2)),
	                        null);
                                setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
	                $setResult(result);
	      $EndCode
	    ./
	    
	resolveExpCS ::= late qvtErrorToken    
	    /.$BeginCode
	    			IToken lateToken = getIToken($getToken(1));
	                CSTNode result = createResolveExpCS(
	                        lateToken,
	                        new Token(lateToken.getEndOffset(), lateToken.getEndOffset(), $sym_type.TK_resolve),
	                        null);
                                setOffsets(result, getIToken($getToken(1)));
	                $setResult(result);
	      $EndCode
	    ./
	
	resolveInOp -> resolveIn
	resolveInOp -> invresolveIn
	resolveInOp -> resolveoneIn
	resolveInOp -> invresolveoneIn
	
        resolveInExpCS ::= lateOpt resolveInOp '(' scoped_identifier ',' resolveOpArgsExpCS ')'
	    /.$BeginCode
	                CSTNode result = createResolveInExpCS(
	                        getIToken($getToken(1)),
	                        getIToken($getToken(2)),
	                        (ScopedNameCS)$getSym(4),
	                        (ResolveOpArgsExpCS)$getSym(6));
	                        setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
	                $setResult(result);
              $EndCode
            ./
	    
        resolveInExpCS ::= lateOpt resolveInOp '(' scoped_identifier ')'
            /.$BeginCode
	                CSTNode result = createResolveInExpCS(
	                        getIToken($getToken(1)),
	                        getIToken($getToken(2)),
	                        (ScopedNameCS)$getSym(4),
	                        null);
	                        setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
	                $setResult(result);
	      $EndCode
	    ./
	    
	    
	resolveInExpCS ::= lateOpt resolveInOp '(' scoped_identifier ',' resolveOpArgsExpCSOpt qvtErrorToken
	    /.$BeginCode
	                CSTNode result = createResolveInExpCS(
	                        getIToken($getToken(1)),
	                        getIToken($getToken(2)),
	                        (ScopedNameCS)$getSym(4),
	                        (ResolveOpArgsExpCS)$getSym(6));
	                        setOffsets(result, getIToken($getToken(1)), getIToken($getToken(6)));
	                $setResult(result);
	      $EndCode
	    ./
	    
	resolveInExpCS ::= lateOpt resolveInOp '(' scoped_identifier qvtErrorToken
	    /.$BeginCode
	                CSTNode result = createResolveInExpCS(
	                        getIToken($getToken(1)),
	                        getIToken($getToken(2)),
	                        (ScopedNameCS)$getSym(4),
	                        null);
	                        setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
	                $setResult(result);
	      $EndCode
	    ./
	    
	resolveInExpCS ::= lateOpt resolveInOp '(' qvtErrorToken
	    /.$BeginCode
                        CSTNode result = createResolveInExpCS(
                                getIToken($getToken(1)),
	                        getIToken($getToken(2)),
								createScopedNameCS(null, ""), 
	                        null);
                                setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
	                $setResult(result);
	      $EndCode
            ./
	    
        resolveInExpCS ::= lateOpt resolveInOp qvtErrorToken
	    /.$BeginCode
	                CSTNode result = createResolveInExpCS(
	                        getIToken($getToken(1)),
	                        getIToken($getToken(2)),
								createScopedNameCS(null, ""), 
	                        null);
	                        setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
	                $setResult(result);
	      $EndCode
	    ./
            
        resolveResolveInExpCS -> resolveExpCS
	resolveResolveInExpCS -> resolveInExpCS
            
	-- commented out since the spec is not clear about the return type of this expression       
	OperationCallExpCS ::= primaryExpCS '->' resolveResolveInExpCS
		/.$BeginCode
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					CallExpCS result = (CallExpCS)$getSym(3);
					result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
					result.setSource(source);
					$setResult(result);
		  $EndCode
		./
	OperationCallExpCS ::= primaryExpCS '.' resolveResolveInExpCS
		/.$BeginCode
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					CallExpCS result = (CallExpCS)$getSym(3);
					result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
					result.setSource(source);
					$setResult(result);
		  $EndCode
		./
	        
	-- case with no source of resolveIn
	primaryNotNameCS -> resolveResolveInExpCS
    
	-- Resolve family ends here

	-- operation call and expression extension in QVT

	OperationCallExpCS ::= primaryExpCS '->' featureMappingCallExpCS
		/.$BeginCode
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					CallExpCS result = (CallExpCS)$getSym(3);
					result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
					result.setSource(source);
					$setResult(result);
		  $EndCode
		./
	OperationCallExpCS ::= primaryExpCS '.' featureMappingCallExpCS
		/.$BeginCode
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					CallExpCS result = (CallExpCS)$getSym(3);
					result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
					result.setSource(source);
					$setResult(result);
		  $EndCode
		./

	primaryNotNameCS -> mappingCallExpCS
    
	primaryNotNameCS -> outExpCS 
			
	simpleNameCS ::= this
		/.$NewCase./
	simpleNameCS ::= result
		/.$BeginCode
					CSTNode result = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getIToken($getToken(1))
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./

	--=== // Expressions (end) ===--


	--=== Non-standard extensions and legacy support (start) ===--
	_import ::= import library unit ';'
		/.$BeginCode
					CSTNode result = createLibraryImportCS(
							(PathNameCS)$getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./

	transformation_h ::= qualifierList transformation qualifiedNameCS
		/.$BeginCode
					EList qualifierList = (EList) $getSym(1);
					CSTNode result = createTransformationHeaderCS(
							qualifierList,
							(PathNameCS)$getSym(3),
							createSimpleSignatureCS($EMPTY_ELIST),
							$EMPTY_ELIST,
							null
						);
					if (qualifierList.isEmpty()) {
						setOffsets(result, getIToken($getToken(2)), (PathNameCS)$getSym(3));
					} else {
						setOffsets(result, (CSTNode) qualifierList.get(0), (PathNameCS)$getSym(3));
					}
					$setResult(result);
		  $EndCode
		./

	unit_element -> renaming
	renaming ::= rename typeCS '.' qvtIdentifierCS '=' StringLiteralExpCS ';' 
		/.$BeginCode
					CSTNode result = createRenameCS(
							(TypeCS)$getSym(2),
							getIToken($getToken(4)),
							(StringLiteralExpCS)$getSym(6)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
					$setResult(result);
		  $EndCode
		./
	--=== Non-standard extensions and legacy support (end) ===--

%End
