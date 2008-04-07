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
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLPGParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CompletionProposalUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.utilities.TypedElement;

/**
 * @author aigdalov
 */

public class AccessorCollector extends AbstractCallExpSourceCollector {
    public void addPropoposals(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        IToken leftToken = data.getLeftToken();
        EClassifier classifier = getCallExpSourceType(leftToken, data);
        CompletionProposalUtil.addContextProposals(proposals, classifier, QvtCompletionData.isKindOf(leftToken, QvtOpLPGParsersym.TK_DOT), data);
        if (QvtCompletionData.isKindOf(leftToken, QvtOpLPGParsersym.TK_ARROW)) {
            CollectionType collection = (CollectionType) classifier;
            EClassifier elementType = collection.getElementType();
            CompletionProposalUtil.addContextProposals(proposals, elementType, false, data);
        }
    }

    protected TypedElement<EClassifier> getCallExpSource(QvtCompletionData data) {
        return getCallExpSource(data.getLeftToken(), data);
    }
}