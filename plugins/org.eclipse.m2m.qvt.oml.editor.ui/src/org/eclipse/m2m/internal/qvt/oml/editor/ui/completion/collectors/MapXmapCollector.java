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
 * @author Aleksandr Igdalov
 * Created on Aug 7, 2007
 */

public class MapXmapCollector extends AbstractCallExpSourceCollector {
    public void addPropoposals(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        IToken accessorToken = getAccessorToken(data);
        EClassifier classifier = getCallExpSourceType(accessorToken, data);
        CompletionProposalUtil.addMappingOperations(proposals, classifier, data);
        if (QvtCompletionData.isKindOf(accessorToken, QvtOpLPGParsersym.TK_ARROW)) {
            CollectionType collection = (CollectionType) classifier;
            EClassifier elementType = collection.getElementType();
            CompletionProposalUtil.addMappingOperations(proposals, elementType, data);
        }
    }
    
    protected TypedElement<EClassifier> getCallExpSource(QvtCompletionData data) {
        IToken accessorToken = data.getLeftToken(1);
        if ((accessorToken == null) || (getAccessorToken(data) == null)) {
            return null;
        }
        return getCallExpSource(accessorToken, data);
    }
    
    private static IToken getAccessorToken(QvtCompletionData data) {
        IToken leftToken = data.getLeftToken();
        if ((leftToken.getKind() == QvtOpLPGParsersym.TK_map) 
                || (leftToken.getKind() == QvtOpLPGParsersym.TK_xmap)) {
            return data.getLeftToken(1);
        }
        return null;
    }
}