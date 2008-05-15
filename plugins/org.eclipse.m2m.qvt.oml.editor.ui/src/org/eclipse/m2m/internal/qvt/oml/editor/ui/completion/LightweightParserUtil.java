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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion;

import java.util.ArrayList;
import java.util.List;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalVisitorCS;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLPGParsersym;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLexer;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.cst.parser.LightweightParser;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.cst.parser.LightweightTypeParser;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.parser.OCLLexer;

/**
 * @author aigdalov
 * Created on Oct 26, 2007
 */
public class LightweightParserUtil {
    public enum ParserTypeEnum {
        LIGHTWEIGHT_PARSER, LIGHTWEIGHT_TYPE_PARSER
    }
    
    public static final int[] IMPERATIVE_OPERATION_TOKENS = {
        QvtOpLPGParsersym.TK_mapping, 
        QvtOpLPGParsersym.TK_helper,
        QvtOpLPGParsersym.TK_query,
        QvtOpLPGParsersym.TK_main
    };
    
    public static final int[] OCLEXPRESSION_START_TOKENS = {
        QvtOpLPGParsersym.TK_RESET_ASSIGN, QvtOpLPGParsersym.TK_ADD_ASSIGN,
        QvtOpLPGParsersym.TK_EQUAL, QvtOpLPGParsersym.TK_NOT_EQUAL, QvtOpLPGParsersym.TK_NOT_EQUAL_EXEQ,
        QvtOpLPGParsersym.TK_GREATER, QvtOpLPGParsersym.TK_LESS,
        QvtOpLPGParsersym.TK_GREATER_EQUAL, QvtOpLPGParsersym.TK_LESS_EQUAL,
        QvtOpLPGParsersym.TK_and, QvtOpLPGParsersym.TK_or,
        QvtOpLPGParsersym.TK_xor, QvtOpLPGParsersym.TK_implies,
        QvtOpLPGParsersym.TK_not,
        QvtOpLPGParsersym.TK_PLUS, QvtOpLPGParsersym.TK_MINUS,
        QvtOpLPGParsersym.TK_MULTIPLY, QvtOpLPGParsersym.TK_DIVIDE,
        QvtOpLPGParsersym.TK_BAR, QvtOpLPGParsersym.TK_QUESTIONMARK,
        QvtOpLPGParsersym.TK_COMMA, QvtOpLPGParsersym.TK_SEMICOLON,
        QvtOpLPGParsersym.TK_DOTDOT,
        QvtOpLPGParsersym.TK_if, QvtOpLPGParsersym.TK_then, QvtOpLPGParsersym.TK_else,
        QvtOpLPGParsersym.TK_LBRACE, QvtOpLPGParsersym.TK_LBRACKET, QvtOpLPGParsersym.TK_LPAREN,
        QvtOpLPGParsersym.TK_in,
        QvtOpLPGParsersym.TK_when,
        QvtOpLPGParsersym.TK_return
    };
    
    public static final int[] OCLEXPRESSION_END_TOKENS = {
        QvtOpLPGParsersym.TK_BAR, QvtOpLPGParsersym.TK_QUESTIONMARK,
        QvtOpLPGParsersym.TK_COMMA, QvtOpLPGParsersym.TK_SEMICOLON,
        QvtOpLPGParsersym.TK_DOTDOT,
        QvtOpLPGParsersym.TK_then, QvtOpLPGParsersym.TK_else, QvtOpLPGParsersym.TK_endif,
        QvtOpLPGParsersym.TK_RBRACE, QvtOpLPGParsersym.TK_RBRACKET, QvtOpLPGParsersym.TK_RPAREN,
        QvtOpLPGParsersym.TK_in,
    };
    
    public static final int[] OCLEXPRESSION_MANDATORY_TERMINATION_TOKENS = 
        uniteIntArrays(IMPERATIVE_OPERATION_TOKENS, new int[] {
                QvtOpLPGParsersym.TK_init, QvtOpLPGParsersym.TK_end,
                QvtOpLPGParsersym.TK_transformation, QvtOpLPGParsersym.TK_modeltype,
                QvtOpLPGParsersym.TK_uses, QvtOpLPGParsersym.TK_metamodel,
                QvtOpLPGParsersym.TK_import, QvtOpLPGParsersym.TK_library
        });

    public static final int[][] BRACING_PAIRS = {
        {QvtOpLPGParsersym.TK_if, QvtOpLPGParsersym.TK_endif},
        {QvtOpLPGParsersym.TK_LPAREN, QvtOpLPGParsersym.TK_RPAREN},
        {QvtOpLPGParsersym.TK_LBRACE, QvtOpLPGParsersym.TK_RBRACE},
        {QvtOpLPGParsersym.TK_LBRACKET, QvtOpLPGParsersym.TK_RBRACKET},
    };
    
    public static final int[] RESOLVE_FAMILY_TERMINALS = {
        QvtOpLPGParsersym.TK_resolve,
        QvtOpLPGParsersym.TK_resolveone,
        QvtOpLPGParsersym.TK_resolveIn,
        QvtOpLPGParsersym.TK_resolveoneIn,
        QvtOpLPGParsersym.TK_invresolve,
        QvtOpLPGParsersym.TK_invresolveone,
        QvtOpLPGParsersym.TK_invresolveIn,
        QvtOpLPGParsersym.TK_invresolveoneIn
    };
    
    public static final int[] RESOLVEIN_FAMILY_TERMINALS = {
        QvtOpLPGParsersym.TK_resolveIn,
        QvtOpLPGParsersym.TK_resolveoneIn,
        QvtOpLPGParsersym.TK_invresolveIn,
        QvtOpLPGParsersym.TK_invresolveoneIn
    };
    
    public static final int[] ITERATOR_TERMINALS_WITH_IMPLICIT_ITERATOR = {
        QvtOpLPGParsersym.TK_select,
        QvtOpLPGParsersym.TK_reject,
        QvtOpLPGParsersym.TK_collect,
        QvtOpLPGParsersym.TK_forAll,
        QvtOpLPGParsersym.TK_exists,
        QvtOpLPGParsersym.TK_isUnique,
        QvtOpLPGParsersym.TK_one,
        QvtOpLPGParsersym.TK_any,
        QvtOpLPGParsersym.TK_collectNested,
        QvtOpLPGParsersym.TK_sortedBy,
        QvtOpLPGParsersym.TK_closure,
        QvtOpLPGParsersym.TK_xselect,
        QvtOpLPGParsersym.TK_xcollect,
        QvtOpLPGParsersym.TK_selectOne,
        QvtOpLPGParsersym.TK_collectOne,
    };
    
    public static final int[] ITERATOR_TERMINALS = 
        uniteIntArrays(ITERATOR_TERMINALS_WITH_IMPLICIT_ITERATOR,  new int[] {
                QvtOpLPGParsersym.TK_collectselect,
                QvtOpLPGParsersym.TK_collectselectOne
        });
    
    public static final int[] MAPPING_CLAUSE_TOKENS = {
        QvtOpLPGParsersym.TK_when, 
        QvtOpLPGParsersym.TK_where
    };
    
    public static int[] uniteIntArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, result, 0, array1.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }
    
    public static final IToken getNextToken(IToken token) {
        PrsStream prsStream = token.getPrsStream();
        int nextTokenIndex = token.getTokenIndex() + 1;
        if (nextTokenIndex < prsStream.getSize()) {
            return prsStream.getTokenAt(nextTokenIndex);
        }
        return null;
    }

    public static final IToken getPreviousToken(IToken token) {
        PrsStream prsStream = token.getPrsStream();
        int nextTokenIndex = token.getTokenIndex() - 1;
        if (nextTokenIndex >= 0) {
            return prsStream.getTokenAt(nextTokenIndex);
        }
        return null;
    }

    public static final IToken getNextTokenByKind(IToken startToken, int kind) {
        return getNextTokenByKind(startToken, new int[] {kind});
    }
    
    public static final IToken getNextTokenByKind(IToken startToken, int[] kinds) {
        PrsStream prsStream = startToken.getPrsStream();
        for (int i = startToken.getTokenIndex(), n = prsStream.getSize(); i < n; i++) {
            IToken token = prsStream.getTokenAt(i);
            if (QvtCompletionData.isKindOf(token, kinds)) {
                return token;
            }
        }
        return null;
    }
    
    public static final String getTokenText(int tokenKind) {
        return QvtOpLPGParsersym.orderedTerminalSymbols[tokenKind];        
    }

    public static final OCLExpression<EClassifier> getOclExpression(IToken trailingToken, QvtCompletionData data, ParserTypeEnum parserType) {
        OCLExpressionCS oclExpressionCS = getOclExpressionCS(trailingToken, data, parserType);
        return getOclExpression(oclExpressionCS, data);
    }

    public static final OCLExpression<EClassifier> getOclExpression(IToken[] tokens, QvtCompletionData data, ParserTypeEnum parserType) {
        OCLExpressionCS oclExpressionCS = getOclExpressionCS(tokens, data, parserType);
        if (oclExpressionCS != null) {
            return getOclExpression(oclExpressionCS, data);
        }
        return null;
    }

    public static final OCLExpression<EClassifier> getOclExpression(OCLExpressionCS oclExpressionCS, QvtCompletionData data) {
        if (oclExpressionCS != null) {
            OCLLexer oclLexer = new OCLLexer(data.getEnvironment());
            try {
                oclLexer.initialize(new OCLInput("").getContent(), data.getCFile().getName()); //$NON-NLS-1$
                QvtCompilerOptions options = new QvtCompilerOptions();
                options.setReportErrors(false);
                options.setShowAnnotations(false);
                options.setSourceLineNumbersEnabled(false);
                QvtOperationalVisitorCS visitor = new QvtOperationalVisitorCS(oclLexer, data.getEnvironment(), options);

				return visitor.analyzeExpressionCS(oclExpressionCS, data.getEnvironment());
            } catch (ParserException e) {
                Activator.log(e);
            }
        }
        return null;
    }

    public static final OCLExpressionCS getOclExpressionCS(IToken[] tokens, QvtCompletionData data, ParserTypeEnum parserType) {
        if (tokens != null) {
            CSTNode cstNode = LightweightParserUtil.parse(tokens, data.getCFile(), parserType);
            if (cstNode instanceof OCLExpressionCS) {
                return (OCLExpressionCS) cstNode;
            }
        }
        return null;
    }
    
    public static final String getText(IToken start, IToken end) {
        int startOffset = start.getStartOffset();
        int endOffset = end.getEndOffset();
        PrsStream prsStream = start.getPrsStream();
        return getText(startOffset, endOffset, prsStream);
    }

    public static final String getText(CSTNode cstNode, PrsStream prsStream) {
        int startOffset = cstNode.getStartOffset();
        int endOffset = cstNode.getEndOffset();
        return getText(startOffset, endOffset, prsStream);
    }

    private static String getText(int startOffset, int endOffset, PrsStream prsStream) {
        return new String(prsStream.getInputChars(), startOffset, endOffset - startOffset + 1);
    }

    public static final String getText(IToken[] tokens) {
        if (tokens.length == 0) {
            return ""; //$NON-NLS-1$
        }
        return LightweightParserUtil.getText(tokens[0], tokens[tokens.length - 1]);
    }
    
    public static final CSTNode parse(IToken[] tokens, CFile cFile, ParserTypeEnum parserType) {
        String script = LightweightParserUtil.getText(tokens);
        return parse(script, cFile, parserType);
    }
    
    public static final CSTNode parse(String script, CFile cFile, ParserTypeEnum parserType) {
        try {
        	QvtOperationalEnv env = new QvtOperationalEnvFactory().createEnvironment(null, null, null);
            QvtOpLexer lexer = new QvtOpLexer(env);
            lexer.initialize(new OCLInput(script).getContent(), cFile.getName());
            PrsStream parser = null;
            switch (parserType) {
                case LIGHTWEIGHT_PARSER: parser = new RunnableLightweightParser(lexer); break;
                case LIGHTWEIGHT_TYPE_PARSER: parser = new RunnableLightweightTypeParser(lexer); break;
                default: throw new RuntimeException("Unknown parserType: " + parserType); //$NON-NLS-1$
            }
            parser.resetTokenStream();
            lexer.lexer(parser);
            return (CSTNode) ((ILightweightParser) parser).runParser();
        } catch (Exception ex) {
            Activator.log(ex);
            return null;
        }
    }

    private static final OCLExpressionCS getOclExpressionCS(IToken trailingToken, QvtCompletionData data, ParserTypeEnum parserType) {
        IToken[] tokens = extractOclExpressionCSTokens(trailingToken, data);
        return getOclExpressionCS(tokens, data, parserType);
    }

    public static final IToken[] extractOclExpressionCSTokens(IToken trailingToken, QvtCompletionData data) {
        List<IToken> tokens = new ArrayList<IToken>();
        PrsStream prsStream = data.getPrsStream();
        int mode = BRACING_PAIRS.length;
        int depth = 0;
        for (int i = trailingToken.getTokenIndex() - 1; i >= 0; i--) {
            IToken token = prsStream.getTokenAt(i);
            if (QvtCompletionData.isKindOf(token, OCLEXPRESSION_MANDATORY_TERMINATION_TOKENS)) {
                return null;
            }
            if (depth == 0) {
                if (QvtCompletionData.isKindOf(token, OCLEXPRESSION_START_TOKENS)) {
                    return tokens.toArray(new IToken[tokens.size()]);
                }
                for (int j = 0; j < BRACING_PAIRS.length; j++) {
                    if (token.getKind() == BRACING_PAIRS[j][1]) {
                        mode = j;
                        depth++;
                        break;
                    }
                }
            } else {
                if (token.getKind() == BRACING_PAIRS[mode][0]) {
                    depth--;
                } else if (token.getKind() == BRACING_PAIRS[mode][1]) {
                    depth++;
                }
            }
            tokens.add(0, token);
        }
        return null;
    }
    
    public static final int getBracingPairKind(IToken token, boolean isStart) {
        for (int i = 0; i < BRACING_PAIRS.length; i++) {
            int kind = isStart ? BRACING_PAIRS[i][0] : BRACING_PAIRS[i][1];
            if (QvtCompletionData.isKindOf(token, kind)) {
                return i;
            }
        }
        return -1;
    }
    
    private static interface ILightweightParser {
        public EObject runParser() throws ParserException;
    }
    
    
    private static class RunnableLightweightParser extends LightweightParser implements ILightweightParser {
        public RunnableLightweightParser(QvtOpLexer lexStream) {
            super(lexStream);
        }
        
        public CSTNode runParser() throws ParserException {
            return parser(10);
        }
    }

    private static class RunnableLightweightTypeParser extends LightweightTypeParser implements ILightweightParser {
        public RunnableLightweightTypeParser(QvtOpLexer lexStream) {
            super(lexStream);
        }
        
        public CSTNode runParser() throws ParserException {
            return parser(10);
        }
    }
}