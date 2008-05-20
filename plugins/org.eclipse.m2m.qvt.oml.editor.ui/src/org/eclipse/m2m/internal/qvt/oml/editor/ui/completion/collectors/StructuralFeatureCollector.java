/*******************************************************************************
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.collectors;

import java.util.Collection;

import lpg.lpgjavaruntime.IToken;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLPGParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CompletionProposalUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.LightweightParserUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;

/**
 * @author aigdalov
 */

public class StructuralFeatureCollector extends AbstractCollector {
	private static final String SCTRUCTURALFEATURE_CONTAINER_FLAG = StructuralFeatureCollector.class + "SCTRUCTURALFEATURE_CONTAINER_FLAG"; //$NON-NLS-1$

    private static final int[] SCTRUCTURALFEATURE_CONTAINER_TERMINALS = {
        QvtOpLPGParsersym.TK_object,
        QvtOpLPGParsersym.TK_mapping
    };
    
    private static final int[] SCTRUCTURALFEATURE_CONTAINER_TERMINALS_WITH_MAPPING_CLAUSES = 
        LightweightParserUtil.uniteIntArrays(SCTRUCTURALFEATURE_CONTAINER_TERMINALS, 
                LightweightParserUtil.MAPPING_CLAUSE_TOKENS);
    
    @Override
    protected boolean isApplicableInternal(QvtCompletionData data) {
    	IToken leftToken = data.getLeftToken();
        if ((leftToken.getKind() == QvtOpLPGParsersym.TK_SEMICOLON) 
                || (leftToken.getKind() == QvtOpLPGParsersym.TK_LBRACE)
                || (leftToken.getKind() == QvtOpLPGParsersym.TK_RBRACE)
                ) {
            IToken structuralFeatureContainerToken = data.getParentBracingExpression(SCTRUCTURALFEATURE_CONTAINER_TERMINALS_WITH_MAPPING_CLAUSES, 
                    QvtOpLPGParsersym.TK_LBRACE, QvtOpLPGParsersym.TK_RBRACE, 
                    1, null, null, LightweightParserUtil.MAPPING_CLAUSE_TOKENS);
            if ((structuralFeatureContainerToken != null)
                    && QvtCompletionData.isKindOf(structuralFeatureContainerToken, SCTRUCTURALFEATURE_CONTAINER_TERMINALS)) {
                data.getUserData().put(SCTRUCTURALFEATURE_CONTAINER_FLAG, structuralFeatureContainerToken);
                return true;
            }
        }
        return false;
	}

    public void addPropoposals(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        IToken structuralFeatureContainerToken = (IToken) data.getUserData().get(SCTRUCTURALFEATURE_CONTAINER_FLAG);
        IToken[] typeTokens = null;
        EClassifier objectExpType = null;
    	if (structuralFeatureContainerToken.getKind() == QvtOpLPGParsersym.TK_mapping) {
    	    typeTokens = extractMappingType(structuralFeatureContainerToken);
    	} else {
            IToken firstTypeToken = LightweightParserUtil.getNextToken(structuralFeatureContainerToken);
            if (firstTypeToken != null) {
                if (QvtCompletionData.isKindOf(firstTypeToken, QvtOpLPGParsersym.TK_LBRACE)) { // type not specified
                    // use type in mapping declaration
                    IToken mappingToken = data.getParentBracingExpression(new int[] {QvtOpLPGParsersym.TK_mapping}, 
                            QvtOpLPGParsersym.TK_LBRACE, QvtOpLPGParsersym.TK_RBRACE, 
                            2, null, null, LightweightParserUtil.MAPPING_CLAUSE_TOKENS);          
                    if (mappingToken != null) {
                        typeTokens = extractMappingType(mappingToken);
                    }
                } else {
                    IToken[] tokens = QvtCompletionData.extractTokens(firstTypeToken, QvtOpLPGParsersym.TK_LBRACE);
                    if ((tokens != null) && (tokens.length >= 2)
                            && QvtCompletionData.isKindOf(tokens[1], QvtOpLPGParsersym.TK_COLON)) {
                        if (tokens.length == 2) { // varName ':'
                            Variable<EClassifier, EParameter> variable = data.getEnvironment().lookup(tokens[0].toString());
                            objectExpType = variable.getType();
                        } else { // varName ':' TypeCS
                            typeTokens = new IToken[tokens.length - 2];
                            System.arraycopy(tokens, 2, typeTokens, 0, typeTokens.length);
                        }
                    } else {
                        typeTokens = tokens;
                    }
                }
            }
    	}
    	if (typeTokens != null) {
    	    OCLExpression<EClassifier> oclExpression = LightweightParserUtil.getOclExpression(typeTokens, data, LightweightParserUtil.ParserTypeEnum.LIGHTWEIGHT_TYPE_PARSER);
    	    if (oclExpression instanceof TypeExp) {
    	        TypeExp typeExp = (TypeExp) oclExpression;
                objectExpType = typeExp.getReferredType();
    	    }
    	}
    	if (objectExpType != null) {
            CompletionProposalUtil.addStructuralFeatures(proposals, objectExpType, data);
    	}
        if (QvtCompletionData.isKindOf(structuralFeatureContainerToken,QvtOpLPGParsersym.TK_mapping)) {
            CompletionProposalUtil.addKeywords(proposals, new int[] {
                    QvtOpLPGParsersym.TK_init, 
                    QvtOpLPGParsersym.TK_object, 
                    QvtOpLPGParsersym.TK_end
                    }, data);
        }
    }
    
    private static IToken[] extractMappingType(IToken mappingToken) {
        IToken rParen = LightweightParserUtil.getNextTokenByKind(mappingToken, QvtOpLPGParsersym.TK_RPAREN);
        if (rParen != null) {
            IToken colon = LightweightParserUtil.getNextToken(rParen);
            if ((colon != null) && (colon.getKind() == QvtOpLPGParsersym.TK_COLON)) {
                IToken firstTypeToken = LightweightParserUtil.getNextToken(colon);
                if (firstTypeToken != null) {
                    return QvtCompletionData.extractTokens(firstTypeToken, 
                            QvtCompletionData.MAPPING_DECLARATION_TRAILING_TOKEN_KINDS);
                }
            }
        }
        return null;
        
    }
}