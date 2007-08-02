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
import org.eclipse.m2m.qvt.oml.internal.cst.parser.QvtKeywords;
import org.eclipse.swt.SWT;

public class QvtScanner extends RuleBasedScanner {

    public QvtScanner(ColorManager manager) {
        IToken keyWord =
            new Token(
                new TextAttribute(manager.getColor(IQvtColorConstants.TAG), null, SWT.BOLD));
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
        
        addKeywords(wordRule, keyWord);
        rules.add(wordRule);
        
        setRules(rules.toArray(new IRule[rules.size()]));
    }

    private void addKeywords(WordRule wordRule, IToken keyWord) {
    	for (String string : QvtKeywords.KEYWORDS) {
    		wordRule.addWord(string, keyWord);
		}
    }
}
