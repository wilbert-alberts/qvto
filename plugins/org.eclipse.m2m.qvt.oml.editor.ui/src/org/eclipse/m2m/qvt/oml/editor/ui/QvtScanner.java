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
package org.eclipse.m2m.qvt.oml.editor.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;

public class QvtScanner extends RuleBasedScanner {

    public QvtScanner(ColorManager manager) {
        IToken keyWord =
            new Token(
                new TextAttribute(manager.getColor(IQvtColorConstants.TAG), null, SWT.BOLD));
        IToken oclKeyWord =
            new Token(
                new TextAttribute(manager.getColor(IQvtColorConstants.OCL_TAG), null, SWT.BOLD));
        IToken defaultToken =
            new Token(
                new TextAttribute(manager.getColor(IQvtColorConstants.DEFAULT)));

        List<IRule> rules = new ArrayList<IRule>();
        rules.add(new WhitespaceRule(new QvtWhitespaceDetector()));

        WordRule wordRule = new WordRule(new IWordDetector() {
            public boolean isWordPart(char character) {
                return Character.isJavaIdentifierPart(character);
            }

            public boolean isWordStart(char character) {
                return Character.isJavaIdentifierStart(character);
            }
        }, defaultToken); 
        addKeywords(wordRule, KEYWORDS, keyWord);
        addKeywords(wordRule, OCL_KEYWORDS, oclKeyWord);
        rules.add(wordRule);
        
        setRules(rules.toArray(new IRule[rules.size()]));
    }

    private void addKeywords(WordRule wordRule, String[] strings, IToken keyWord) {
        for (int i = 0; i < strings.length; i++) {
            wordRule.addWord(strings[i], keyWord);
        }
    }
    
    private static final String[] KEYWORDS = {"metamodel", "main", "transformation", "query", "in", "out", "inout", "init", "end", "literal", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
            "mapping", "when", "var", "import", "library", "rename", "configuration", "property", "object", "while", "map", "xmap", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
            "modeltype", "uses", "where" }; //$NON-NLS-1$ //$NON-NLS-2$
    private static final String[] OCL_KEYWORDS = {"implies", "and", "or", "xor", "div", "mod", "Set", "Bag", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-N$
        "Sequence", "Collection", "OrderedSet", "TupleType", "Tuple", "Real", "Integer", "String", "Boolean", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-N$  
        "iterate", "union", "collect", "select", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ 
        "intersection", "asSequence", "asSet", "asBag", "asOrderedSet", "size", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
        "append", "prepend", "subSequence", "at", "first", "last", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
        "symmetricDifference", "flatten",  //$NON-NLS-1$  //$NON-NLS-2$
        "oclIsKindOf", "oclAsType", "including", "excluding", "includes", "excludes", "oclIsTypeOf", "oclIsNew", "oclIsUndefined", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$  
        "if", "then", "else", "endif", "not", "true", "false", "undefined", "let", "init", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
        "in", "allInstances",  //$NON-NLS-1$ //$NON-NLS-2$
        "result", "self", "null", //$NON-NLS-1$  //$NON-NLS-2$ //$NON-NLS-3$
        "reject", "exists", "forAll", "any", //$NON-NLS-1$  //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        };  
}
