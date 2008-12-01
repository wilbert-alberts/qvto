/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.cst.parser;

import java.util.ArrayList;
import java.util.List;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.ParseErrorCodes;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ComputeExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ConfigPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.ElementWithBody;
import org.eclipse.m2m.internal.qvt.oml.cst.ExpressionStatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ForExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeIterateExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.LibraryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LibraryImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LocalPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LogExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingCallExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingEndCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingInitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS;
import org.eclipse.m2m.internal.qvt.oml.cst.NewRuleCallExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.OutExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.PackageRefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.RenameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveInExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ReturnExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS;
import org.eclipse.m2m.internal.qvt.oml.cst.StatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SwitchExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS;
import org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.temp.ResolveOpArgsExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.temp.ScopedNameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.temp.TempFactory;
import org.eclipse.ocl.cst.CSTFactory;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.parser.AbstractOCLParser;

public abstract class AbstractQVTParser extends AbstractOCLParser {

	protected static class Empty {		
		private static final EList<?> EMPTY_LIST_INSTANCE = new BasicEList.UnmodifiableEList<Object>(0, new Object[0]);
		
		@SuppressWarnings("unchecked")
		static final <T> EList<T> list() { 
			return (EList<T>)EMPTY_LIST_INSTANCE;	
		}
	}
		
	protected AbstractQVTParser(BasicEnvironment environment) {
		super(environment);
	}

	protected AbstractQVTParser(QvtOpLexer lexStream) {
		super(lexStream);
	}
	
	@Override
	public QvtOpLexer getLexer() {
		return (QvtOpLexer) super.getLexStream();
	} 
	
	
	public abstract String getTokenKindName(int kind);
	
	protected final void setBodyOffsets(ElementWithBody element, CSTNode start, IToken end) {
		element.setBodyStartLocation(start.getEndOffset());
		element.setBodyEndLocation(end.getStartOffset());
	}
	
	protected final Object createTopLevel(EList<CSTNode> unitElements) {
	    List<TransformationHeaderCS> transformationHeaders = new ArrayList<TransformationHeaderCS>();
	    List<LibraryCS> libraries = new ArrayList<LibraryCS>();
	    List<ModelTypeCS> modeltypes = new ArrayList<ModelTypeCS>();
	    List<ClassifierDefCS> classifiers = new ArrayList<ClassifierDefCS>();
	    List<ModulePropertyCS> properties = new ArrayList<ModulePropertyCS>();
	    List<MappingQueryCS> helpers = new ArrayList<MappingQueryCS>();
	    List<MappingRuleCS> mappings = new ArrayList<MappingRuleCS>();
	    List<RenameCS> renamings = new ArrayList<RenameCS>();
	    List<ImportCS> imports = new ArrayList<ImportCS>();


	    for (CSTNode unitElement : unitElements) {
	        if (unitElement instanceof TransformationHeaderCS) {
	            transformationHeaders.add((TransformationHeaderCS) unitElement);
	        } else if (unitElement instanceof LibraryCS) {
	            libraries.add((LibraryCS) unitElement);
	        } else if (unitElement instanceof ModelTypeCS) {
	            modeltypes.add((ModelTypeCS) unitElement);
	        } else if (unitElement instanceof ClassifierDefCS) {
	            classifiers.add((ClassifierDefCS) unitElement);
	        } else if (unitElement instanceof ModulePropertyCS) {
	            properties.add((ModulePropertyCS) unitElement);
	        } else if (unitElement instanceof MappingQueryCS) {
	            helpers.add((MappingQueryCS) unitElement);
	        } else if (unitElement instanceof MappingRuleCS) {
	            mappings.add((MappingRuleCS) unitElement);
	        } else if (unitElement instanceof RenameCS) {
	            renamings.add((RenameCS) unitElement);
	        } else if (unitElement instanceof ImportCS) {
	            imports.add((ImportCS) unitElement);
	        } else {
	            throw new RuntimeException("Unknown unit_element: " + unitElement);
	        }
	    }
	    MappingModuleCS moduleCS = null;
	    if (((transformationHeaders.size() > 1) && (unitElements.size() != transformationHeaders.size()))
	            || ((libraries.size() > 1) && (unitElements.size() != libraries.size()))) {
	        reportError(ParseErrorCodes.INVALID_CODE, "",  //$NON-NLS-1$
	                Messages.QvtOpLPGParser_MultipleModulesExtraUnitElements);
	        moduleCS = createMappingModuleCS(
	                transformationHeaders.get(0)
	        );
	    } else if ((transformationHeaders.size() == 1) && (libraries.size() == 1)) {
	        moduleCS = null;
	    } else if (transformationHeaders.size() == 1) {
	        moduleCS = createMappingModuleCS(
	                transformationHeaders.get(0)
	        );
	    } else if (libraries.size() == 1) {
	        moduleCS = libraries.get(0);
	    }
	    if (moduleCS != null) {
	        moduleCS.getImports().addAll(imports);
	        moduleCS.getMetamodels().addAll(modeltypes);
	        moduleCS.getProperties().addAll(properties);
	        moduleCS.getMethods().addAll(helpers);
	        moduleCS.getMethods().addAll(mappings);
	        moduleCS.getRenamings().addAll(renamings);
	        moduleCS.getClassifierDefCS().addAll(classifiers);

	        setOffsets(moduleCS, unitElements.get(0), unitElements.get(unitElements.size() - 1));
	        return moduleCS;
	    }
	    reportError(ParseErrorCodes.INVALID_CODE, "",  //$NON-NLS-1$
	            "Multiple modules are unsupported yet!"); //$NON-NLS-1$
	            return null;
	}
	
	protected final CSTNode createLocalPropertyCS(IToken tokenText, TypeCS sym, OCLExpressionCS sym2) {
		LocalPropertyCS prop = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createLocalPropertyCS();
		SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, tokenText.toString());
		setOffsets(nameCS, tokenText);
		prop.setSimpleNameCS(nameCS);
		prop.setTypeCS(sym);
		prop.setOclExpressionCS(sym2);
		return prop;
	}

	protected final CSTNode createConfigPropertyCS(IToken tokenText, TypeCS sym) {
		ConfigPropertyCS prop = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createConfigPropertyCS();
		SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, tokenText.toString());
		setOffsets(nameCS, tokenText);
		prop.setSimpleNameCS(nameCS);
		prop.setTypeCS(sym);
		return prop;
	}

	protected final CSTNode createContextualPropertyCS(ScopedNameCS scopedNameCS, TypeCS typeCS, OCLExpressionCS oclExpressionCS) {
		ContextualPropertyCS prop = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createContextualPropertyCS();
		prop.setSimpleNameCS(createSimpleNameCS(scopedNameCS));
		prop.setScopedNameCS(scopedNameCS);
		prop.setTypeCS(typeCS);
		prop.setOclExpressionCS(oclExpressionCS);
		return prop;
	}

	protected final CSTNode createRenameCS(TypeCS sym, IToken tokenText, StringLiteralExpCS sym2) {
		RenameCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createRenameCS();
		SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, tokenText.toString());
		setOffsets(nameCS, tokenText);
		result.setSimpleNameCS(nameCS);
		result.setTypeCS(sym);
		result.setOriginalName(sym2);
		return result;
	}

	protected final CSTNode createModuleImportCS(PathNameCS sym) {
		ModuleImportCS imp = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createModuleImportCS();
		imp.setPathNameCS(sym);
		return imp;
	}

	protected final LibraryCS createLibraryCS(PathNameCS name, EList<ImportCS> imports, EList<ModelTypeCS> metamodels,
			EList<RenameCS> renamings, EList<ModulePropertyCS> properties, EList<MappingMethodCS> methods) {
				LibraryCS imp = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createLibraryCS();
				TransformationHeaderCS headerCS = createTransformationHeaderCS(
						Empty.<StringLiteralExpCS>list(), name, 
						Empty.<ParameterDeclarationCS>list(), 
						Empty.<ModuleUsageCS>list(), null);
				setOffsets(headerCS, name);
				initializeModule(imp, headerCS, imports, metamodels, renamings, properties, methods);
				return imp;
			}

	protected final MappingModuleCS createMappingModuleCS(TransformationHeaderCS header) {
	    MappingModuleCS moduleCS = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingModuleCS();
	    moduleCS.setHeaderCS(header);
        return moduleCS;
	}

	private void initializeModule(MappingModuleCS result, TransformationHeaderCS header, EList<ImportCS> imports,
			EList<ModelTypeCS> metamodels, EList<RenameCS> renamings, EList<ModulePropertyCS> properties, 
			EList<MappingMethodCS> methods) {
				result.setHeaderCS(header);
				result.getImports().addAll(imports);
				result.getMetamodels().addAll(metamodels);
				result.getRenamings().addAll(renamings);
				result.getProperties().addAll(properties);
				result.getMethods().addAll(methods);
			}

	protected final MappingQueryCS createMappingQueryCS(MappingDeclarationCS sym, EList<OCLExpressionCS> sym2) {
		MappingQueryCS query = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingQueryCS();
		query.setMappingDeclarationCS(sym);
		query.getExpressions().addAll(sym2);
		return query;
	}

	protected final MappingRuleCS createMappingRuleCS(MappingDeclarationCS mappingDecl, OCLExpressionCS guard,
			MappingSectionsCS mappingBody) {
				MappingRuleCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingRuleCS();
				result.setMappingDeclarationCS(mappingDecl);
				result.setGuard(guard);
				result.setMappingBody(mappingBody);
				return result;
			}

	protected final CSTNode createLibraryImportCS(PathNameCS sym) {
		LibraryImportCS imp = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createLibraryImportCS();
		imp.setPathNameCS(sym);
		return imp;
	}

	protected final CSTNode createVariableInitializationCS(IToken identifier, TypeCS typeCS, OCLExpressionCS initExpressionCS) {
				VariableInitializationCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createVariableInitializationCS();
				SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, identifier.toString());
				setOffsets(nameCS, identifier);
				result.setSimpleNameCS(nameCS);
				result.setTypeCS(typeCS);
				result.setOclExpressionCS(initExpressionCS);
				return result;
			}

	protected final CSTNode createExpressionStatementCS(OCLExpressionCS sym) {
		ExpressionStatementCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createExpressionStatementCS();
		result.setOclExpressionCS(sym);
		return result;
	}

	protected final CSTNode createMappingEndCS(EList<OCLExpressionCS> statements, int endOffset, int startOffset) {
		MappingEndCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingEndCS();
		initializeMappingSection(result, statements, endOffset, startOffset);		
		return result;
	}

	protected final CSTNode createMappingInitCS(EList<OCLExpressionCS> statements, int endOffset, int startOffset) {
		MappingInitCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingInitCS();
		initializeMappingSection(result, statements, endOffset, startOffset);		
		return result;
	}
	
	protected final CSTNode createMappingSectionsCS(MappingInitCS mappingInitCS, MappingBodyCS mappingPopulationCS, MappingEndCS mappingEndCS) {
	    if ((mappingInitCS == null) && (mappingPopulationCS == null) && (mappingEndCS == null)) {
	        return null;
	    }
	    MappingSectionsCS mappingSectionsCS = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingSectionsCS();
	    mappingSectionsCS.setMappingInitCS(mappingInitCS);
	    mappingSectionsCS.setMappingBodyCS(mappingPopulationCS);
	    mappingSectionsCS.setMappingEndCS(mappingEndCS);
	    setOffsetsForComplexNode(mappingSectionsCS, mappingInitCS, mappingPopulationCS, mappingEndCS);
	    return mappingSectionsCS;
    }
	
	private final void setOffsetsForComplexNode(CSTNode complexNode, CSTNode... cstParts) {
	    for (CSTNode cstPart : cstParts) {
	        if (cstPart != null) {
	            complexNode.setStartOffset(cstPart.getStartOffset());
	            break;
	        }
	    }
	    for (int i = cstParts.length - 1; i >= 0; i--) {
            if (cstParts[i] != null) {
                complexNode.setEndOffset(cstParts[i].getEndOffset());
                break;
            }
	    }
	}
	
	private void initializeMappingSection(MappingSectionCS section, EList<OCLExpressionCS> statements,
			int endOffset, int startOffset) {
				section.getStatements().addAll(statements);
				section.setBodyStartLocation(startOffset);
				section.setBodyEndLocation(endOffset);
			}

	protected final ParameterDeclarationCS createResultParameterDeclarationCS(TypeSpecCS typeSpecCS) {
		DirectionKindCS directionKindCS = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createDirectionKindCS();
		directionKindCS.setDirectionKind(DirectionKindEnum.OUT);
		return createParameterDeclarationCS(directionKindCS, null, typeSpecCS);
	}
	
	protected final ParameterDeclarationCS createParameterDeclarationCS(DirectionKindCS sym, IToken tokenText,
			TypeSpecCS typeSpecCS) {
				ParameterDeclarationCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createParameterDeclarationCS();
				SimpleNameCS nameCS = null;
				if (tokenText != null) {
					nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, tokenText.toString());
					setOffsets(nameCS, tokenText);
				}
				else {
					//nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, ""); //$NON-NLS-1$
				}
				result.setSimpleNameCS(nameCS);
				result.setTypeSpecCS(typeSpecCS);
				if (sym != null) {
					result.setDirectionKind(sym.getDirectionKind());
				}
				return result;
			}

	protected final TypeSpecCS createTypeSpecCS(TypeCS typeCS, IToken extentLocation) {
		TypeSpecCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createTypeSpecCS();
		result.setTypeCS(typeCS);
		setOffsets(result, typeCS);
		if (extentLocation != null) {
			SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, extentLocation.toString());
			setOffsets(nameCS, extentLocation);
			result.setSimpleNameCS(nameCS);
			result.setEndOffset(extentLocation.getEndOffset());
		}
		return result;
	}

	protected final CSTNode createDirectionKindCS(DirectionKindEnum kind) {
		DirectionKindCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createDirectionKindCS();
		result.setDirectionKind(kind);
		return result;
	}

	protected final CSTNode createCompleteSignatureCS(SimpleSignatureCS simpleSignatureCS, EList<ParameterDeclarationCS> resultList) {
	    CompleteSignatureCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createCompleteSignatureCS();
	    result.setSimpleSignature(simpleSignatureCS);
	    result.getResultParams().addAll(resultList);
        return result;
    }

    protected final CSTNode createSimpleSignatureCS(EList<ParameterDeclarationCS> paramsCS) {
        SimpleSignatureCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createSimpleSignatureCS();
        result.getParams().addAll(paramsCS);
        return result;
    }

    protected final MappingDeclarationCS createMappingDeclarationCS(DirectionKindCS directionKindCS, ScopedNameCS scopedNameCS,
			EList<ParameterDeclarationCS> parameters, EList<ParameterDeclarationCS> resultParameters) {
		MappingDeclarationCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingDeclarationCS();
		result.setDirectionKindCS(directionKindCS);
		if(resultParameters != null) {
			result.getResult().addAll(resultParameters);
		}
		result.getParameters().addAll(parameters);
		result.setSimpleNameCS(createSimpleNameCS(scopedNameCS));

		result.setContextType(scopedNameCS.getTypeCS());
		return result;
	}
	
	private SimpleNameCS createSimpleNameCS(ScopedNameCS scopedNameCS) {
		SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, scopedNameCS.getName());
		
		int endOffset = scopedNameCS.getEndOffset();
		int length = (simpleNameCS.getValue() != null) ?  simpleNameCS.getValue().length() : 0;			
		simpleNameCS.setStartOffset(endOffset - (length > 0 ? length-1 : 0));
		simpleNameCS.setEndOffset(endOffset);

		return simpleNameCS;
	}
	
	private PathNameCS createParentPath(PathNameCS pathNameCS) {
		PathNameCS result = CSTFactory.eINSTANCE.createPathNameCS();
		result.getSequenceOfNames().addAll(pathNameCS.getSequenceOfNames());
		result.setStartOffset(pathNameCS.getStartOffset());
		if (result.getSequenceOfNames().size() > 0) {
			String lastSegment = result.getSequenceOfNames().remove(result.getSequenceOfNames().size()-1);
			result.setEndOffset(pathNameCS.getEndOffset()-lastSegment.length());
		}
		else {
			result.setEndOffset(pathNameCS.getEndOffset());
		}
		return result;
	}

	protected final CSTNode createAssignStatementCS(OCLExpressionCS sym, OCLExpressionCS sym2,
			boolean b) {
				AssignStatementCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createAssignStatementCS();
				result.setLValueCS(sym);
				result.setOclExpressionCS(sym2);
				result.setIncremental(b);
				return result;
			}
	
	protected final OutExpCS setupOutExpCS(OutExpCS result, EList<OCLExpressionCS> expressions, int startOffset, int endOffset) {
				result.getExpressions().addAll(expressions);
				result.setBodyStartLocation(startOffset);
				result.setBodyEndLocation(endOffset);
				if(result.getStartOffset() <= 0) {
					result.setStartOffset(startOffset);
				}
				if(result.getEndOffset() <= 0) {
					result.setEndOffset(endOffset);
				}
				return result;
	}

	protected final OutExpCS createOutExpCS(SimpleNameCS optVarNameCS, TypeSpecCS optTypeSpecCS) {
		OutExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createOutExpCS();		
		result.setSimpleNameCS(optVarNameCS);
		result.setTypeSpecCS(optTypeSpecCS);

		assert optVarNameCS != null || optTypeSpecCS != null;
		CSTNode posNodeCS = optVarNameCS == null ? optTypeSpecCS : optVarNameCS;
		result.setStartOffset(posNodeCS.getStartOffset());
		result.setEndOffset(posNodeCS.getEndOffset());
		return result;
	}

	protected final MappingBodyCS createMappingBodyCS(List<? extends OCLExpressionCS> expCS, boolean hasPopulationKeyword) {
		MappingBodyCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingBodyCS();
		result.getStatements().addAll(expCS);
		result.setHasPopulationKeyword(hasPopulationKeyword);
		return result;
	}
	
	protected final CSTNode createMappingCallExpCS(SimpleNameCS sym, EList<OCLExpressionCS> arguments,
			boolean b) {
				MappingCallExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingCallExpCS();
				result.setSimpleNameCS(sym);
				result.getArguments().addAll(arguments);
				result.setStrict(b);
				result.setIsMarkedPreCS(CSTFactory.eINSTANCE.createIsMarkedPreCS());
				return result;
			}

	protected final CSTNode createMappingCallExpCS(PathNameCS sym, EList<OCLExpressionCS> arguments,
			boolean b) {
				MappingCallExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingCallExpCS();
				if (sym.getSequenceOfNames().size() > 1) {
					result.setSource(createParentPath(sym));
				}
				if (sym.getSequenceOfNames().size() > 0) {
					String lastSegment = sym.getSequenceOfNames().get(sym.getSequenceOfNames().size()-1);
					SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, lastSegment);
					nameCS.setStartOffset(sym.getEndOffset()-lastSegment.length() + 1);
					nameCS.setEndOffset(sym.getEndOffset());
					result.setSimpleNameCS(nameCS);
				}		
				result.getArguments().addAll(arguments);
				result.setStrict(b);
				result.setIsMarkedPreCS(CSTFactory.eINSTANCE.createIsMarkedPreCS());
				return result;
			}

	protected final CSTNode createResolveOpArgsExpCS(IToken target, TypeCS typeCS,
			OCLExpressionCS condition) {
			    ResolveOpArgsExpCS resolveOpArgsExpCS = TempFactory.eINSTANCE.createResolveOpArgsExpCS();
			    VariableCS variableCS = CSTFactory.eINSTANCE.createVariableCS();
			    variableCS.setTypeCS(typeCS);
			    if (target == null) {
					setOffsets(variableCS, typeCS);
			    } else {
			        variableCS.setName(target.toString());
					setOffsets(variableCS, target, typeCS);
			    }
			    resolveOpArgsExpCS.setTarget(variableCS);
			    resolveOpArgsExpCS.setCondition(condition);
			    return resolveOpArgsExpCS;
			}

	protected final CSTNode createResolveExpCS(IToken lateToken, IToken opCode, ResolveOpArgsExpCS resolveOpArgsExpCS) {
	    return populateResolveExpCS(org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createResolveExpCS(), 
	            lateToken, opCode, resolveOpArgsExpCS);
	}

	protected final CSTNode createResolveInExpCS(IToken lateToken, IToken opCode,
			ScopedNameCS mapping, ResolveOpArgsExpCS resolveOpArgsExpCS) {
				ResolveInExpCS resolveInExpCS = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createResolveInExpCS();
				resolveInExpCS.setInMappingType(mapping.getTypeCS());
				
				SimpleNameCS mappingNameCS = CSTFactory.eINSTANCE.createSimpleNameCS();
				mappingNameCS.setValue(mapping.getName());
				
				mappingNameCS.setStartOffset(mapping.getStartOffset());
				if(mapping.getName() != null) {
					mappingNameCS.setStartOffset(mapping.getEndOffset() - mapping.getName().length() + 1);
				}
				mappingNameCS.setEndOffset(mapping.getEndOffset());
				
				resolveInExpCS.setInMappingName(mappingNameCS);
				return populateResolveExpCS(resolveInExpCS, lateToken, opCode, resolveOpArgsExpCS);
			}

	protected final CSTNode populateResolveExpCS(ResolveExpCS resolveExpCS, IToken lateToken,
			IToken opCode, ResolveOpArgsExpCS resolveOpArgsExpCS) {
			    resolveExpCS.setIsDeferred((lateToken != null) && getTokenKindName(QvtOpLPGParsersym.TK_late).equals(lateToken.toString()));
			    String opCodeText = opCode.toString();
			    resolveExpCS.setOne(opCodeText.indexOf("one") > 0); //$NON-NLS-1$
			    resolveExpCS.setIsInverse(opCodeText.indexOf("inv") == 0); //$NON-NLS-1$
			    if (resolveOpArgsExpCS != null) {
			        resolveExpCS.setTarget(resolveOpArgsExpCS.getTarget());
			        resolveExpCS.setCondition(resolveOpArgsExpCS.getCondition());
			    }
			    
			    SimpleNameCS operCodeSimpleName = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, opCodeText);
			    operCodeSimpleName.setStartOffset(opCode.getStartOffset());
			    operCodeSimpleName.setEndOffset(opCode.getEndOffset());
			    resolveExpCS.setSimpleNameCS(operCodeSimpleName);		    
			    
			    return resolveExpCS;
			}

	protected final ScopedNameCS createScopedNameCS(TypeCS typeCS, String name) {
		ScopedNameCS result = TempFactory.eINSTANCE.createScopedNameCS();
		result.setTypeCS(typeCS);
		result.setName(name);
		if(typeCS != null) {
			result.setStartOffset(typeCS.getStartOffset());
			result.setEndOffset(typeCS.getEndOffset());
			if(name != null) {
				result.setEndOffset(result.getEndOffset() + name.length());
			}
		}
		return result;
	}

	protected CSTNode createLegacyWhileExpCS(OCLExpressionCS cond, OCLExpressionCS res, BlockExpCS body) {
		WhileExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createWhileExpCS();
		result.setCondition(cond);
		result.setResult(res);
		result.setBody(body);
		return result;
	}
	
	protected CSTNode createWhileExpCS(VariableCS resultVar, OCLExpressionCS cond, BlockExpCS body) {
		WhileExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createWhileExpCS();
		result.setCondition(cond);
		result.setResultVar(resultVar);
		result.setBody(body);
		return result;
	}		
	
	protected final CSTNode createLogExpCS(EList<OCLExpressionCS> args, OCLExpressionCS condition) {
		LogExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createLogExpCS();
		String name = getTokenKindName(QvtOpLPGParsersym.TK_log);
		result.setSimpleNameCS(createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, name));

		result.getArguments().addAll(args);		
		result.setCondition(condition);		
		return result;
	}
	
	protected final CSTNode createAssertExpCS(OCLExpressionCS assertCondition, SimpleNameCS severityIdentifier, LogExpCS logExpCS) {
		AssertExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createAssertExpCS();
		result.setAssertion(assertCondition);
		result.setSeverity(severityIdentifier);
		result.setLog(logExpCS);
		return result;
	}
	

	protected final CSTNode createForExpCS(IToken opCode, EList<IToken> iterators, OCLExpressionCS condition, BlockExpCS body) {
	    ForExpCS forExpCS = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createForExpCS();

	    SimpleNameCS operCodeSimpleName = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, opCode.toString());
        operCodeSimpleName.setStartOffset(opCode.getStartOffset());
        operCodeSimpleName.setEndOffset(opCode.getEndOffset());
        forExpCS.setSimpleNameCS(operCodeSimpleName);

        if ((iterators != null) && !iterators.isEmpty()) {
            VariableCS[] iterVars = new VariableCS[iterators.size()];
            for (int i = 0, n = iterVars.length; i < n; i++) {
                iterVars[i] = createVariableCS(iterators.get(i).toString(), null, null);
            }
            forExpCS.setVariable1(iterVars[0]);
            if (iterVars.length > 1) {
                forExpCS.setVariable2(iterVars[1]);
            }
        }
        
        forExpCS.setCondition(condition);
        forExpCS.setBody(body);
        
        return forExpCS;
    }

    protected final CSTNode createSwitchExpCS(EList<SwitchAltExpCS> altExps, OCLExpressionCS elseExp) {
		SwitchExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createSwitchExpCS();
		result.getAlternativePart().addAll(altExps);
		result.setElsePart(elseExp);
		return result;
	}

	protected final CSTNode createSwitchAltExpCS(OCLExpressionCS cond, OCLExpressionCS body) {
		SwitchAltExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createSwitchAltExpCS();
		result.setCondition(cond);
		result.setBody(body);
		return result;
	}

    protected final CSTNode createBlockExpCS(EList<OCLExpressionCS> expressions) {
        BlockExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createBlockExpCS();
        result.getBodyExpressions().addAll(expressions);
        return result;
    }

    protected final CSTNode createComputeExpCS(VariableCS declarator, OCLExpressionCS body) {
        ComputeExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createComputeExpCS();
        result.setReturnedElement(declarator);
        result.setBody(body);
        return result;
    }

	protected final ModelTypeCS createModelTypeCS(IToken identifier, StringLiteralExpCS complianceKind, 
			EList<PackageRefCS> packageRefList, EList<StatementCS> whereList) {
				ModelTypeCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createModelTypeCS();
				SimpleNameCS identifierCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL,
							(identifier.getPrsStream() == null ? "" : identifier.toString())); //$NON-NLS-1$
				identifierCS.setStartOffset(identifier.getStartOffset());
				identifierCS.setEndOffset(identifier.getEndOffset());
				result.setIdentifierCS(identifierCS);
				result.setComplianceKindCS(complianceKind);
				result.getPackageRefs().addAll(packageRefList);
				result.getWhereStatements().addAll(whereList);		
				return result;
			}

	protected final CSTNode createPackageRefCS(PathNameCS scopedIdentifierCS, StringLiteralExpCS uriCS) {
		PackageRefCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createPackageRefCS();
		result.setPathNameCS(scopedIdentifierCS);
		result.setUriCS(uriCS);
		return result;
	}

	protected final CSTNode createModuleKindCS(ModuleKindEnum moduleKind) {
		ModuleKindCS moduleKindCS = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createModuleKindCS();
		moduleKindCS.setModuleKind(moduleKind);
		return moduleKindCS;
	}

	protected final CSTNode createModuleRefCS(PathNameCS pathNameCS, EList<ParameterDeclarationCS> params) {
		ModuleRefCS moduleRefCS = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createModuleRefCS();
		moduleRefCS.setPathNameCS(pathNameCS);
		moduleRefCS.getParameters().addAll(params);
		return moduleRefCS;
	}

	protected final CSTNode createModuleUsageCS(ImportKindEnum importKind, ModuleKindCS moduleKindCS, EList<ModuleRefCS> moduleRefs) {
		ModuleUsageCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createModuleUsageCS();
		result.setImportKind(importKind);
		result.setModuleKindCS(moduleKindCS);
		result.getModuleRefs().addAll(moduleRefs);
		return result;
	}

	protected final CSTNode createTransformationRefineCS(ModuleRefCS moduleRefCS, IToken token) {
		TransformationRefineCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createTransformationRefineCS();
		result.setModuleRefCS(moduleRefCS);
		result.setSimpleNameCS(createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, token.toString()));
		return result;
	}

	protected final TransformationHeaderCS createTransformationHeaderCS(EList<StringLiteralExpCS> qualifiers, 
			PathNameCS pathNameCS, EList<ParameterDeclarationCS> params, EList<ModuleUsageCS> transfUsages, 
			TransformationRefineCS transfRefineCS) {
				TransformationHeaderCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createTransformationHeaderCS();
				result.getQualifiers().addAll(qualifiers);
				result.getParameters().addAll(params);
				result.getModuleUsages().addAll(transfUsages);
				result.setTransformationRefineCS(transfRefineCS);
				result.setPathNameCS(pathNameCS);
				return result;
	}
	
    protected ImperativeIterateExpCS createImperativeIterateExpCS(
            SimpleNameCS simpleNameCS,
            EList<VariableCS> iterators,
            VariableCS target,
            OCLExpressionCS body,
            OCLExpressionCS condition) {
        ImperativeIterateExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createImperativeIterateExpCS();
        result.setSimpleNameCS(simpleNameCS);
        if (iterators.size() > 0) {
            result.setVariable1(iterators.get(0));
            if (iterators.size() > 1) {
                result.setVariable2(iterators.get(1));
            }
        }
        if (target != null) {
            result.setTarget(target);
        }
        result.setBody(body);
        result.setCondition(condition);
        return result;
    }
    
    protected NewRuleCallExpCS createNewRuleCallExpCS(PathNameCS pathNameCS, List<OCLExpressionCS> arguments) {
    	NewRuleCallExpCS call = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createNewRuleCallExpCS();
		call.setScopedIdentifier(pathNameCS);
		call.getArguments().addAll(arguments);
    	return call;
    }
    
    protected ReturnExpCS createReturnExpCS(OCLExpressionCS value) {
    	ReturnExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createReturnExpCS();
    	result.setValue(value);
    	return result;
    }

    protected MappingExtensionCS createMappingExtension(String extensionKindLiteral, EList<ScopedNameCS> identifierList) {
    	MappingExtensionKindCS kind = MappingExtensionKindCS.getByName(extensionKindLiteral);
    	assert kind != null;
    	
    	MappingExtensionCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingExtensionCS();
    	result.setKind(kind);
    	if(identifierList != null) {
    		result.getMappingIdentifiers().addAll(identifierList);
    	}
    	
    	return result;
    }

    protected final int getEndOffset(int ensuredOffset, EList<? extends CSTNode>... listOpt) {
        int offset = ensuredOffset;
        for (EList<? extends CSTNode> list : listOpt) {
            if (list.size() == 0) {
                continue;
            }
            CSTNode node = list.get(list.size()-1);
            offset = node.getEndOffset();
        }
        return offset;
    }
    
	protected final int getEndOffset(IToken token, EList<? extends CSTNode>... listOpt) {
		int offset = token.getEndOffset();
		for (EList<? extends CSTNode> list : listOpt) {
			if (list.size() == 0) {
				continue;
			}
			CSTNode node = list.get(list.size()-1);
			offset = node.getEndOffset();
		}
		return offset;
	}
	
	protected boolean isTokenOfType(IToken token, int kind) {
	    return (token != null) && (token.getKind() == kind);
	}
	
	protected EList<QualifierKindCS> createQualifiersListCS(EList<SimpleNameCS> qualifiersNames) {
		EList<QualifierKindCS> result = new BasicEList<QualifierKindCS>();
		
		for (SimpleNameCS nextQualifier : qualifiersNames) {
			QualifierKindCS nameCS = QualifierKindCS.getByName(nextQualifier.getValue());
			assert nameCS != null;
			result.add(nameCS);
		}
		return result;
	}

	protected CSTNode createClassifierDefCS(SimpleNameCS classifierName, EList<TypeCS> extentionList, EList<LocalPropertyCS> featureList) {
		ClassifierDefCS classifierDef = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createClassifierDefCS();
		classifierDef.setSimpleNameCS(classifierName);
		classifierDef.getExtends().addAll(extentionList);
		classifierDef.getProperties().addAll(featureList);
		return classifierDef;
	}

}
