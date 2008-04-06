package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion;

import java.util.Collection;

import org.eclipse.jface.text.contentassist.ICompletionProposal;

/**
 * @author aigdalov
 */

public interface ICollector {
	public boolean isApplicable(QvtCompletionData data);
    public void addPropoposals(Collection<ICompletionProposal> proposals, QvtCompletionData data);
}