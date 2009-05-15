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

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLPGParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CompletionProposalUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.LightweightParserUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;

/**
 * @author aigdalov
 */

public class OclExpressionStartCollector extends AbstractCollector {
    private static final int[] INAPPLICABLE_BRACING_EXPRESSIONS = {
        QvtOpLPGParsersym.TK_switch,
        QvtOpLPGParsersym.TK_Tuple
    };
        
    @Override
    protected boolean isApplicableInternal(QvtCompletionData data) {
    	IToken leftToken = data.getLeftToken();
		if (QvtCompletionData.isKindOf(leftToken, QvtOpLPGParsersym.TK_LPAREN)) {
		    if (TypeStartCollector.isCollectorApplicable(data)) {
		        return false;
		    }
		    IToken previousToken = data.getLeftToken(1);
		    if ((previousToken != null) 
		            && QvtCompletionData.isKindOf(previousToken, LightweightParserUtil.RESOLVE_FAMILY_TERMINALS)) {
                return false; 
		    }
		}
		if (QvtCompletionData.isKindOf(leftToken, QvtOpLPGParsersym.TK_SEMICOLON, QvtOpLPGParsersym.TK_LBRACE)) {
		    IToken parentBracingExpression = data.getParentBracingExpression(INAPPLICABLE_BRACING_EXPRESSIONS, QvtOpLPGParsersym.TK_LBRACE, QvtOpLPGParsersym.TK_RBRACE, 1, null, null, null);
		    if ((parentBracingExpression != null) 
		            && QvtCompletionData.isKindOf(parentBracingExpression, INAPPLICABLE_BRACING_EXPRESSIONS)) {
		        return false;
		    }
		}
		if (data.getParentBracingExpression(LightweightParserUtil.IMPERATIVE_OPERATION_TOKENS, QvtOpLPGParsersym.TK_LBRACE, QvtOpLPGParsersym.TK_RBRACE, Integer.MAX_VALUE, null, null, LightweightParserUtil.MAPPING_CLAUSE_TOKENS) != null) {
		    if (ResolveTypeCollector.isCollectorApplicable(data)) {
		        return false;
		    }
		    if (QvtCompletionData.isKindOf(leftToken, QvtOpLPGParsersym.TK_RPAREN)) {
		        // check for switch ... { case(...) /*@*/
	            IToken bracingSwitch = data.getParentBracingExpression(new int[] {QvtOpLPGParsersym.TK_switch}, QvtOpLPGParsersym.TK_LBRACE, QvtOpLPGParsersym.TK_RBRACE, 1, null, null, null);
	            if (bracingSwitch != null) {
	                IToken caseToken = LightweightParserUtil.getPreviousTokenByKind(leftToken, QvtOpLPGParsersym.TK_case);
	                return (caseToken != null) && (bracingSwitch.getEndOffset() < caseToken.getStartOffset());
	            }
		    }
	        return QvtCompletionData.isKindOf(leftToken, LightweightParserUtil.OCLEXPRESSION_START_TOKENS);
		}
		return false;
	}

	public void addPropoposals(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
		CompletionProposalUtil.addRValues(proposals, data);
	}
}