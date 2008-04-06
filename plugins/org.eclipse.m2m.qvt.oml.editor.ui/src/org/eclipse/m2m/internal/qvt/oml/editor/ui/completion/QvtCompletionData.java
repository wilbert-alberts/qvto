package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolverFactory;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLPGParsersym;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLexer;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.ui.part.FileEditorInput;

/**
 * @author Aleksandr Igdalov
 * Created on Jul 5, 2007
 */

public class QvtCompletionData {
    public static final int[] MAPPING_DECLARATION_TRAILING_TOKEN_KINDS = new int[] {QvtOpLPGParsersym.TK_LBRACE,
        QvtOpLPGParsersym.TK_SEMICOLON,
        QvtOpLPGParsersym.TK_when
    };

    private final QvtEditor myEditor;
    private final ITextViewer myViewer;
    private final IDocument myDocument;
    private final int myOffset;
    private final Map<String, Object> myUserData = new HashMap<String, Object>();
    private IToken myLeftToken;
    private IToken myCurrentToken;
    private QvtOpLexer myLexer;
    private PrsStream myPrsStream;
    private Exception myException;
    private IFile myIFile;
    private EclipseFile myCFile;
    private QvtCompletionCompiler myQvtCompiler;

    private IToken myParentImperativeOperation;

    public QvtCompletionData(QvtEditor editor, ITextViewer viewer, int offset) {
        myEditor = editor;
        myViewer = viewer;
        myDocument = viewer.getDocument();
        myOffset = offset;
        try {
            myIFile = ((FileEditorInput) myEditor.getEditorInput()).getFile();
            myCFile = new EclipseFile(myIFile);
            myQvtCompiler = createQvtCompiler();
            myLexer = myQvtCompiler.createLexer(myCFile);
            myPrsStream = myLexer.getPrsStream();
            getLeftTokenAndCurrentToken();
        } catch (Exception ex) {
            myException = ex;
            Activator.log(ex);
        }
    }

    public QvtEditor getEditor() {
        return myEditor;
    }

    public ITextViewer getViewer() {
        return myViewer;
    }
    
    public IDocument getDocument() {
        return myDocument;
    }

    public int getOffset() {
        return myOffset;
    }

    public IToken getLeftToken() {
        return myLeftToken;
    }

    public IToken getCurrentToken() {
        return myCurrentToken;
    }

    public QvtOpLexer getLexer() {
        return myLexer;
    }

    public PrsStream getPrsStream() {
        return myPrsStream;
    }

    public Map<String, Object> getUserData() {
        return myUserData;
    }
    
    public IFile getIFile() {
        return myIFile;
    }

    public EclipseFile getCFile() {
        return myCFile;
    }

    public QvtOperationalEnv getEnvironment() {
        return myQvtCompiler.compileAll();
    }

    public QvtCompletionCompiler getQvtCompiler() {
        return myQvtCompiler;
    }

    public IToken getLeftToken(int leftOffsetIndex) {
        int leftTokenIndex = myLeftToken.getTokenIndex();
        int targetTokenIndex = leftTokenIndex - leftOffsetIndex; 
        if (targetTokenIndex >= 1) {
            return myPrsStream.getTokenAt(targetTokenIndex);
        } 
        return null;
    }
    
    public boolean isValid() {
        return (myEditor != null) && (myViewer != null) 
        && (myOffset >= 0)
        && (myLexer != null) && (myPrsStream != null)
        && (myException == null);
    }

    public void showError(String message) {
        ErrorDialog.openError(myViewer.getTextWidget().getShell(),
                Messages.QvtCompletionData_ErrorPerformingCodeCompletion, null,
                new Status(IStatus.ERROR, Activator.PLUGIN_ID, message)); 
    }

    private void getLeftTokenAndCurrentToken() throws BadLocationException {
        if ((myOffset == 0) || (myPrsStream.getTokens().isEmpty())) {
            return;
        }

        // We might be at the end of some identifier
        char previousChar = myViewer.getDocument().getChar(myOffset - 1);
        if (Character.isJavaIdentifierPart(previousChar)) { 
            int tokenIndex = myPrsStream.getTokenIndexAtCharacter(myOffset - 1);
            // getTokenIndexAtCharacter() may produce wrong results on first tokens
            myLeftToken = (tokenIndex == 1) ? null : myPrsStream.getTokenAt(tokenIndex - 1);
            myCurrentToken = myPrsStream.getTokenAt(tokenIndex);
        } else {
            int tokenIndex = myPrsStream.getTokenIndexAtCharacter(myOffset);
            int leftTokenIndex = (tokenIndex <= 0)  ? -tokenIndex : tokenIndex - 1;
            if (leftTokenIndex != 0) {
                myLeftToken = myPrsStream.getTokenAt(leftTokenIndex);
            }
            if (myPrsStream.getTokens().size() >= leftTokenIndex + 2) {
                IToken next = myPrsStream.getTokenAt(leftTokenIndex + 1);
                myCurrentToken = (next.getStartOffset() < myOffset) ? next : null;
            }
        }
    }
    
    /* Completion performed */
    public MappingModuleCS[] getAllMappingModulesCS() {
        myQvtCompiler.compileAll();
        List<MappingModuleCS> modules = new ArrayList<MappingModuleCS>();
        for (CFileData cFileData : myQvtCompiler.getCFileDataMap().values()) {
            MappingModuleCS mappingModuleCS = cFileData.getMappingModuleCS();
            if (mappingModuleCS != null) {
                modules.add(mappingModuleCS);
            }
        }
        return modules.toArray(new MappingModuleCS[modules.size()]);
    }
    
    public MappingMethodCS[] getAllImperativeOperationsCS() {
        MappingModuleCS[] allMappingModulesCS = getAllMappingModulesCS();
        List<MappingMethodCS> methods = new ArrayList<MappingMethodCS>();
        for (MappingModuleCS mappingModuleCS : allMappingModulesCS) {
            methods.addAll(mappingModuleCS.getMethods());
        }
        return methods.toArray(new MappingMethodCS[methods.size()]);
    }
    
    public boolean isWithin(int[] keywordTokenKinds, int[] unexpectedTokenKinds) {
        for (int i = myLeftToken.getTokenIndex(); i >= 0; i--) {
            IToken token = myPrsStream.getTokenAt(i);
            if (QvtCompletionData.isKindOf(token, keywordTokenKinds)) {
                return true;
            }
            for (int unexpectedTokenKind : unexpectedTokenKinds) {
                if (token.getKind() == unexpectedTokenKind) {
                    return false;
                }
            }
        }
        return false;
    }

    public IToken getParentBracingExpression(int[] keywordTokenKinds, int leftBraceKind, int rightBraceKind,
            int maxDepth, int[] zeroDepthTerminatorKinds, int[] unexpectedTokenKinds) {
        int depth = 0;
        int maxCurrentDepth = Integer.MIN_VALUE;
        for (int i = myLeftToken.getTokenIndex(); i >= 0; i--) {
            IToken token = myPrsStream.getTokenAt(i);
            if (QvtCompletionData.isKindOf(token, keywordTokenKinds)) {
                if ((depth >= 1) && (depth > maxCurrentDepth)) {
                    return token;
                }
            } else if (token.getKind() == leftBraceKind) {
                depth++;
                if (depth > maxDepth) {
                    return null;
                }
            } else if (token.getKind() == rightBraceKind) {
                if (depth > maxCurrentDepth) {
                    maxCurrentDepth = depth;
                }
                depth--;
            } else {
                if ((depth == 0) && QvtCompletionData.isKindOf(token, zeroDepthTerminatorKinds)) {
                    return null;
                }
                if (QvtCompletionData.isKindOf(token, unexpectedTokenKinds)) {
                    return null;
                }
            }
        }
        return null;
    }
    
    public boolean isWithinBracingExpression(int[] keywordTokenKinds, int leftBraceKind, int rightBraceKind, int maxDepth) {
        return getParentBracingExpression(keywordTokenKinds, leftBraceKind, rightBraceKind, maxDepth, null, null) != null;
    }
    
    private QvtCompletionCompiler createQvtCompiler() {
        IProject project = myIFile.getProject();
        IImportResolverFactory resolverFactory = IImportResolverFactory.Registry.INSTANCE.getFactory(project);        
        IImportResolver importResolver = resolverFactory.createResolver(project);
        QvtCompletionCompiler qvtCompiler = new QvtCompletionCompiler(importResolver, this);
        return qvtCompiler;
    }
    
    // utility methods
    public static final boolean isKindOf(IToken token, int... tokenKinds) {
        if (tokenKinds != null) {
            for (int tokenKind : tokenKinds) {
                if (token.getKind() == tokenKind) {
                    return true;
                }
            }
        }
        return false;
    }    
    
    public static final IToken[] extractTokens(IToken startToken, int... endTokenKinds) {
        List<IToken> tokens = new ArrayList<IToken>();
        IToken currentToken = startToken;
        PrsStream prsStream = startToken.getPrsStream();
        while (true) {
            if (QvtCompletionData.isKindOf(currentToken, endTokenKinds)) {
                return tokens.toArray(new IToken[tokens.size()]);
            }
            tokens.add(currentToken);
            int currentTokenIndex = currentToken.getTokenIndex();
            int nextTokenIndex = currentTokenIndex + 1;
            if (nextTokenIndex < prsStream.getSize()) {
                currentToken = prsStream.getTokenAt(nextTokenIndex);
            } else {
                return null;
            }
        }
    }
    
    public IToken getParentImperativeOperation() {
        if (myParentImperativeOperation == null) {
            myParentImperativeOperation = getParentBracingExpression(LightweightParserUtil.IMPERATIVE_OPERATION_TOKENS,
                    QvtOpLPGParsersym.TK_LBRACE, QvtOpLPGParsersym.TK_RBRACE, Integer.MAX_VALUE, null, null);
            if (myParentImperativeOperation != null) {
                if (QvtCompletionData.isKindOf(myParentImperativeOperation, QvtOpLPGParsersym.TK_main)) {
                    IToken previousToken = LightweightParserUtil.getPreviousToken(myParentImperativeOperation);
                    if ((previousToken != null)
                            && QvtCompletionData.isKindOf(previousToken, 
                                    QvtOpLPGParsersym.TK_mapping, QvtOpLPGParsersym.TK_query)) {
                        // The "mapping main" or "query main" cases - backward compatibility
                        myParentImperativeOperation = previousToken;
                    }
                }
            }
        }
        return myParentImperativeOperation;
    }

    public void setParentImperativeOperation(IToken parentImperativeOperation) {
        myParentImperativeOperation = parentImperativeOperation;
    }
}