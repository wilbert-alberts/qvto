package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.keywordhandler;

/**
 * @author Aleksandr Igdalov
 * Created on Oct 23, 2007
 */
public class KeywordHandlerRegistry {
    private static final KeywordHandlerRegistry ourKeywordHandlerRegistry = new KeywordHandlerRegistry();
    
    private final IKeywordHandler[] myKeywordHandlers = new IKeywordHandler[] {
        new ScriptHeaderHandler(), new ImperativeOperationHandler()
    };
    
    private KeywordHandlerRegistry() {
    }
    
    public static final KeywordHandlerRegistry getInstance() {
        return ourKeywordHandlerRegistry;
    }

    public IKeywordHandler[] getKeywordHandlers() {
        return myKeywordHandlers;
    }
}