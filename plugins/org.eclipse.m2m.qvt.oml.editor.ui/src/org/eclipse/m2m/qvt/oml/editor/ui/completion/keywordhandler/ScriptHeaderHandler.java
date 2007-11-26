package org.eclipse.m2m.qvt.oml.editor.ui.completion.keywordhandler;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.m2m.qvt.oml.editor.ui.completion.CFileData;
import org.eclipse.m2m.qvt.oml.editor.ui.completion.LightweightParserUtil;
import org.eclipse.m2m.qvt.oml.editor.ui.completion.QvtCompletionData;
import org.eclipse.m2m.qvt.oml.internal.cst.parser.QvtOpLPGParsersym;

/**
 * @author aigdalov
 * Created on Nov 6, 2007
 */
public class ScriptHeaderHandler implements IKeywordHandler {
    public String handle(IToken keyword, PrsStream prsStream, QvtCompletionData data, CFileData fileData) {
        if (keyword.getTokenIndex() == 0) {
            IToken[] headerTokens = QvtCompletionData.extractTokens(keyword, QvtOpLPGParsersym.TK_main,
                    QvtOpLPGParsersym.TK_mapping, QvtOpLPGParsersym.TK_query);
            if (headerTokens != null) {
                return LightweightParserUtil.getText(headerTokens);
            }
        }
        return null;
    }
}