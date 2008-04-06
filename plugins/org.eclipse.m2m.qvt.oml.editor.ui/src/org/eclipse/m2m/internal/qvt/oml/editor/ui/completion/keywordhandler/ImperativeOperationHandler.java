package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.keywordhandler;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLPGParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CFileData;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.LightweightParserUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.keywordhandler.scopedvariablesextraction.ScopedVariablesExtractor;

/**
 * @author Aleksandr Igdalov
 * Created on Oct 23, 2007
 */
public class ImperativeOperationHandler implements IKeywordHandler {
    private final ScopedVariablesExtractor myScopedVariablesExtractor = new ScopedVariablesExtractor();
    
    public String handle(IToken keyword, PrsStream prsStream, QvtCompletionData data, CFileData cFileData) {
        if (QvtCompletionData.isKindOf(keyword, LightweightParserUtil.IMPERATIVE_OPERATION_TOKENS)) {
            IToken[] tokens = QvtCompletionData.extractTokens(keyword, QvtCompletionData.MAPPING_DECLARATION_TRAILING_TOKEN_KINDS);
            if (tokens != null) {
                String mappingText = '\n' + LightweightParserUtil.getText(tokens); 
                if (keyword == data.getParentImperativeOperation()) {
                    String variables = myScopedVariablesExtractor.extractVariables(tokens[tokens.length - 1], data);
                    String wrappedVars = variables;
                    if (QvtCompletionData.isKindOf(keyword, QvtOpLPGParsersym.TK_mapping)) {
                        wrappedVars = "init {\n" + variables + "\n}"; //$NON-NLS-1$ //$NON-NLS-2$
                    }
                    return mappingText + " {\n " + wrappedVars + "\n}"; //$NON-NLS-1$ //$NON-NLS-2$
                }
                return mappingText + ';'; 
            }
        }
        return null;
    }
}