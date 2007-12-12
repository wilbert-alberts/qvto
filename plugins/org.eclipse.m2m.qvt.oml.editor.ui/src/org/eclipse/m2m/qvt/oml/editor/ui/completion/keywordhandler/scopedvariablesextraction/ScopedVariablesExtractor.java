package org.eclipse.m2m.qvt.oml.editor.ui.completion.keywordhandler.scopedvariablesextraction;


import lpg.lpgjavaruntime.IToken;

import org.eclipse.m2m.qvt.oml.editor.ui.completion.LightweightParserUtil;
import org.eclipse.m2m.qvt.oml.editor.ui.completion.QvtCompletionData;
import org.eclipse.m2m.qvt.oml.internal.cst.parser.QvtOpLPGParsersym;

/**
 * @author aigdalov
 * Created on Nov 21, 2007
 */
public class ScopedVariablesExtractor {
    private static final int NOT_A_TOKEN = -1;
    
    // starting from ')'
    public String extractVariables(IToken startToken, QvtCompletionData data) {
        Scope scope = new Scope(null);
        IToken currentToken = startToken;
        if (!QvtCompletionData.isKindOf(data.getParentImperativeOperation(), QvtOpLPGParsersym.TK_main)) {
            while ((currentToken = getNextToken(currentToken, data)) != null) {
                if (QvtCompletionData.isKindOf(currentToken, QvtOpLPGParsersym.TK_LBRACE)) {
                    break;
                }
            }
        }
        if (currentToken != null) {
            while ((currentToken = getNextToken(currentToken, data)) != null) {
                Result innerScopeResult = null;
                if (QvtCompletionData.isKindOf(currentToken, QvtOpLPGParsersym.TK_init, QvtOpLPGParsersym.TK_end)) {
                    currentToken = LightweightParserUtil.getNextToken(currentToken);
                    if (currentToken == null) {
                        break;
                    }
                    if (QvtCompletionData.isKindOf(currentToken, QvtOpLPGParsersym.TK_LBRACE)) {
                        innerScopeResult = analyseScopedVarVariables(currentToken, data, scope, true);
                    }
                } else {
                    innerScopeResult = analyseVariableDeclaringExpressions(currentToken, data, scope);
                }
                if (innerScopeResult != null) {
                    scope = innerScopeResult.getScope();
                    currentToken = innerScopeResult.getEndToken();
                }
            }
        }
        return scope.toString();
    }
    
    // starting from '{'
    private Result analyseScopedVarVariables(IToken startToken, QvtCompletionData data, Scope scope, boolean isMandatoryScope) {
        IToken currentToken = startToken;
        Scope varScope = new Scope(scope);
        IToken nextToken;
        while ((nextToken = getNextToken(currentToken, data)) != null) {
            if (QvtCompletionData.isKindOf(nextToken, QvtOpLPGParsersym.TK_RBRACE)) {
                if (isMandatoryScope) {
                    return new Result(startToken, nextToken, null, varScope);
                }
                return new Result(startToken, nextToken, null, scope);
            }
            if (QvtCompletionData.isKindOf(nextToken, QvtOpLPGParsersym.TK_var)) {
                nextToken = getNextToken(nextToken, data);
                if (nextToken == null) {
                    break;
                }
                Result extractVarVariableResult = extractVariable(nextToken, null, data, varScope, 
                        QvtOpLPGParsersym.TK_RESET_ASSIGN, NOT_A_TOKEN, QvtOpLPGParsersym.TK_SEMICOLON, QvtOpLPGParsersym.TK_RBRACE);
                if (extractVarVariableResult.getScope() != varScope) {
                    return extractVarVariableResult;
                }
                nextToken = extractVarVariableResult.getEndToken();
                varScope.addVariable(extractVarVariableResult.getString());
            } else {
                Result innerScopeResult = analyseVariableDeclaringExpressions(nextToken, data, varScope);
                if (innerScopeResult != null) {
                    if (innerScopeResult.getScope() != varScope) {
                        return innerScopeResult;
                    }
                    nextToken = innerScopeResult.getEndToken();
                }
            }
            currentToken = nextToken;
        }
        return new Result(startToken, currentToken, null, varScope);
    }
    
    private Result analyseVariableDeclaringExpressions(IToken currentToken, QvtCompletionData data, Scope scope) {
        if (QvtCompletionData.isKindOf(currentToken, QvtOpLPGParsersym.TK_let)) {
            return analyseLetExpression(currentToken, data, scope);
        } else if (QvtCompletionData.isKindOf(currentToken, LightweightParserUtil.ITERATOR_TERMINALS)
                || QvtCompletionData.isKindOf(currentToken, QvtOpLPGParsersym.TK_iterate)) {
            return analyseIteratorExpression(currentToken, data, scope);
        } else if (QvtCompletionData.isKindOf(currentToken, LightweightParserUtil.RESOLVE_FAMILY_TERMINALS)) {
            return analyseResolveExpression(currentToken, data, scope);
        } else if (QvtCompletionData.isKindOf(currentToken, QvtOpLPGParsersym.TK_LBRACE)) {
            return analyseScopedVarVariables(currentToken, data, scope, false);
        }
        return null;
    }

    // starting from 'let'
    private Result analyseLetExpression(IToken startToken, QvtCompletionData data, Scope scope) {
        return analyseLetLikeExpression(startToken, null, data, scope, QvtOpLPGParsersym.TK_in, NOT_A_TOKEN,
                QvtOpLPGParsersym.TK_COMMA, QvtOpLPGParsersym.TK_in);
    }
    
    // starting from 'iteratorExpCSToken' or 'iterate'
    private Result analyseIteratorExpression(IToken startToken, QvtCompletionData data, Scope scope) {
        IToken nextToken = getNextToken(startToken, data);
        if (nextToken == null) {
            return new Result(startToken, startToken, null, new Scope(null));
        }
        if  (!QvtCompletionData.isKindOf(nextToken, QvtOpLPGParsersym.TK_LPAREN)) {
            return null;
        }
        Result letLikeExpressionResult = analyseLetLikeExpression(nextToken, startToken, data, scope,
                QvtOpLPGParsersym.TK_BAR, NOT_A_TOKEN, QvtOpLPGParsersym.TK_COMMA,
                QvtOpLPGParsersym.TK_SEMICOLON, QvtOpLPGParsersym.TK_BAR);
        if (letLikeExpressionResult.getScope() != scope) {
            return letLikeExpressionResult;
        }
        nextToken = getNextToken(letLikeExpressionResult.getEndToken(), data);
        if (nextToken == null) {
            return new Result(startToken, letLikeExpressionResult.getEndToken(), null, new Scope(null));
        }
        if  (!QvtCompletionData.isKindOf(nextToken, QvtOpLPGParsersym.TK_RPAREN)) {
            return new Result(startToken, letLikeExpressionResult.getEndToken(), null, scope);
        }        
        return new Result(startToken, nextToken, null, scope);
    }

    // starting from 'resolveOp' or 'resolveInOp'
    private Result analyseResolveExpression(IToken startToken, QvtCompletionData data, Scope scope) {
        IToken nextToken = getNextToken(startToken, data);
        if (nextToken == null) {
            return new Result(startToken, startToken, null, new Scope(null));
        }
        if  (!QvtCompletionData.isKindOf(nextToken, QvtOpLPGParsersym.TK_LPAREN)) {
            return null;
        }
        if (QvtCompletionData.isKindOf(startToken, LightweightParserUtil.RESOLVEIN_FAMILY_TERMINALS)) {
            while ((nextToken = getNextToken(nextToken, data)) != null) {
                if (QvtCompletionData.isKindOf(nextToken, QvtOpLPGParsersym.TK_COMMA)) {
                    break;
                }
            }
        }
        if (nextToken == null) {
            return null;
        }
        Result letLikeExpressionResult = analyseLetLikeExpression(nextToken, null, data, scope,
                QvtOpLPGParsersym.TK_BAR, QvtOpLPGParsersym.TK_RPAREN, QvtOpLPGParsersym.TK_BAR);
        if (letLikeExpressionResult.getScope() != scope) {
            return letLikeExpressionResult;
        }
        nextToken = getNextToken(letLikeExpressionResult.getEndToken(), data);
        if (nextToken == null) {
            return new Result(startToken, letLikeExpressionResult.getEndToken(), null, new Scope(scope));
        }
        if  (!QvtCompletionData.isKindOf(nextToken, QvtOpLPGParsersym.TK_RPAREN)) {
            return new Result(startToken, letLikeExpressionResult.getEndToken(), null, scope);
        }        
        return new Result(startToken, nextToken, null, scope);
    }

    // starting from 'let'-like token
    private Result analyseLetLikeExpression(IToken startToken, IToken iteratorExpressionStart, 
            QvtCompletionData data, Scope scope, int varDeclTerminator, int unexpectedTerminator, int... delimiters) {
        Scope letLikeScope = new Scope(scope);
        IToken nextToken = startToken;
        IToken lastKnownGoodToken = startToken;
        do {
            nextToken = getNextToken(nextToken, data);
            if (nextToken != null) {
                Result variableResult = extractVariable(nextToken, iteratorExpressionStart,
                        data, letLikeScope, QvtOpLPGParsersym.TK_EQUAL, unexpectedTerminator, delimiters);
                if (variableResult == null) {
                    return new Result(startToken, lastKnownGoodToken, null, scope);
                }
                if (variableResult.getScope() != letLikeScope) {
                    return variableResult;
                } else {
                    letLikeScope.addVariable(variableResult.getString());
                    nextToken = variableResult.getEndToken();
                    lastKnownGoodToken = nextToken;
                }
                nextToken = getNextToken(nextToken, data);
            }
        } while ((nextToken != null) && !QvtCompletionData.isKindOf(nextToken, varDeclTerminator) && QvtCompletionData.isKindOf(nextToken, delimiters));
        if ((nextToken != null) && QvtCompletionData.isKindOf(nextToken, varDeclTerminator)) {
            nextToken = getNextToken(nextToken, data);
            if (nextToken != null) {
                Result oclExpressionResult = extractOclExpression(nextToken, data, letLikeScope);
                if (oclExpressionResult.getScope() != letLikeScope) {
                    return oclExpressionResult;
                }
                return new Result(startToken, oclExpressionResult.getEndToken(), null, scope);
            }
        }
        return new Result(startToken, lastKnownGoodToken, null, letLikeScope);
    }
    
    // starting from 'IDENTIFIER'
    private Result extractVariable(IToken startToken, IToken iteratorExpressionStart, QvtCompletionData data,
            Scope scope, int initializer, int  unexpectedTerminator, int... delimiters) {
        boolean isTypeDefined = false;
        IToken currentToken = startToken;
        IToken nextToken;
        while ((nextToken = getNextToken(currentToken, data)) != null) {
            if (QvtCompletionData.isKindOf(nextToken, unexpectedTerminator)) {
                return null;
            }
            if (QvtCompletionData.isKindOf(nextToken, QvtOpLPGParsersym.TK_COLON)) {
                isTypeDefined = true;
            }
            if (QvtCompletionData.isKindOf(nextToken, delimiters)) {
                if (isTypeDefined) {
                    return new Result(startToken, currentToken,
                            "var " + LightweightParserUtil.getText(startToken, currentToken) + ';', scope); //$NON-NLS-1$
                }
                // Implicit types may be in iterator-variables of iterating expressions
                String deducedType = deduceImplicitCollectionElementType(iteratorExpressionStart, data);
                if (deducedType == null) {
                    return new Result(startToken, currentToken, "", scope); //$NON-NLS-1$ 
                }
                String varText = "var " + LightweightParserUtil.getText(startToken, currentToken) //$NON-NLS-1$
                    + " := " + deducedType + ';'; //$NON-NLS-1$
                return new Result(startToken, currentToken, varText, scope); //$NON-NLS-1$ 
            }
            if (QvtCompletionData.isKindOf(currentToken, initializer)) {
                isTypeDefined = true;
                Result oclExpressionResult = extractOclExpression(nextToken, data, scope);
                if (oclExpressionResult.getScope() != scope) {
                    return oclExpressionResult;
                }
                IToken previousToken = LightweightParserUtil.getPreviousToken(currentToken);
                String identifierAndOrType = ((previousToken != null) && (startToken.getTokenIndex() <= previousToken.getTokenIndex())) 
                        ? LightweightParserUtil.getText(startToken, previousToken) : ""; //$NON-NLS-1$
                return new Result(startToken, oclExpressionResult.getEndToken(),
                        "var " + identifierAndOrType //$NON-NLS-1$ 
                        + " := " + oclExpressionResult.getString() + ';', scope); //$NON-NLS-1$
            }
            currentToken = nextToken;
        }
        return new Result(startToken, currentToken, null, new Scope(scope));
    }

    private String deduceImplicitCollectionElementType(IToken iteratorExpressionStart, QvtCompletionData data) {
        if (iteratorExpressionStart == null) {
            return null;
        }
        IToken accessorToken = LightweightParserUtil.getPreviousToken(iteratorExpressionStart);
        if ((accessorToken != null) && QvtCompletionData.isKindOf(accessorToken, 
                QvtOpLPGParsersym.TK_DOT, QvtOpLPGParsersym.TK_ARROW)) {
            IToken[] oclExpressionCSTokens = LightweightParserUtil.extractOclExpressionCSTokens(accessorToken, data);
            if (oclExpressionCSTokens != null) {
                String collectionType = LightweightParserUtil.getText(oclExpressionCSTokens);
                return collectionType + "->any(true)"; //$NON-NLS-1$
            }
        }
        return null;
    }

    // starting from the first token of the OCL expression
    private Result extractOclExpression(IToken startToken, QvtCompletionData data, Scope scope) {
        IToken currentToken = startToken;
        int bracingMode = -1;
        int depth = 0;
        IToken nextToken; 
        while ((nextToken = getNextToken(currentToken, data)) != null) {
            Result innerScopeResult = analyseVariableDeclaringExpressions(currentToken, data, scope);
            if (innerScopeResult != null) {
                if (innerScopeResult.getScope() != scope) {
                    return innerScopeResult;
                }
                currentToken = innerScopeResult.getEndToken();
                nextToken = getNextToken(currentToken, data);
                if (nextToken == null) {
                    return new Result(startToken, currentToken, null, new Scope(scope));
                }
            } else {
                int bracingPairKind = LightweightParserUtil.getBracingPairKind(currentToken, true);
                if (depth == 0) {
                    if (bracingPairKind >= 0) {
                        bracingMode = bracingPairKind;
                        depth++;
                    }
                } else {
                    if (bracingPairKind == bracingMode) {
                        depth++;
                    } else {
                        if (bracingMode == LightweightParserUtil.getBracingPairKind(currentToken, false)) {
                            depth--;
                        }
                    }
                }
            }
            if ((depth == 0) && QvtCompletionData.isKindOf(nextToken, LightweightParserUtil.OCLEXPRESSION_END_TOKENS)) {
                return new Result(startToken, currentToken, LightweightParserUtil.getText(startToken, currentToken), scope);
            }
            currentToken = nextToken;
        }
        return new Result(startToken, currentToken, null, new Scope(scope));
    }

    private static IToken getNextToken(IToken token, QvtCompletionData data) {
        if (token == null) {
            // we mustn't be here; however, in case we are - that
            // won't be a problem
            return null;
        }
        if (token == data.getLeftToken()) {
            return null;
        }
        IToken nextToken = LightweightParserUtil.getNextToken(token);
        if (nextToken == null) {
            return null;
        }
        return nextToken;
    }
}