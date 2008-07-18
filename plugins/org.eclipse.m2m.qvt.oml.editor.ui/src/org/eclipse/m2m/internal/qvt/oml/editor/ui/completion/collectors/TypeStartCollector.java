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

public class TypeStartCollector extends AbstractCollector {
    @Override
    protected boolean isApplicableInternal(QvtCompletionData data) {
        return isCollectorApplicable(data);
    }

    public static final boolean isCollectorApplicable(QvtCompletionData data) {
        IToken leftToken = data.getLeftToken();
        if (QvtCompletionData.isKindOf(leftToken, QvtOpLPGParsersym.TK_COLON)
                || QvtCompletionData.isKindOf(leftToken, LightweightParserUtil.IMPERATIVE_OPERATION_TOKENS)) {
            return true;
        }
        if (QvtCompletionData.isKindOf(leftToken, QvtOpLPGParsersym.TK_LPAREN)) {
            IToken collectionTerminal = LightweightParserUtil.getPreviousToken(leftToken);
            if ((collectionTerminal != null) && QvtCompletionData.isKindOf(collectionTerminal, 
                    QvtOpLPGParsersym.TK_Collection, 
                    QvtOpLPGParsersym.TK_Bag,
                    QvtOpLPGParsersym.TK_Sequence, 
                    QvtOpLPGParsersym.TK_Set,
                    QvtOpLPGParsersym.TK_OrderedSet)) {
                return true;
            }
        }
        return false;
    }
    
    public void addPropoposals(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        CompletionProposalUtil.addAllTypes(proposals, data);
    }
}