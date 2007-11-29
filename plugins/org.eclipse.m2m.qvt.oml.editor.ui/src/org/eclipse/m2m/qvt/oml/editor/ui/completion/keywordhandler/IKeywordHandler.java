package org.eclipse.m2m.qvt.oml.editor.ui.completion.keywordhandler;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.m2m.qvt.oml.editor.ui.completion.CFileData;
import org.eclipse.m2m.qvt.oml.editor.ui.completion.QvtCompletionData;

/**
 * @author Aleksandr Igdalov
 * Created on Oct 23, 2007
 */
public interface IKeywordHandler {
    public String handle(IToken keyword, PrsStream prsStream, QvtCompletionData data, CFileData cFileData);
}