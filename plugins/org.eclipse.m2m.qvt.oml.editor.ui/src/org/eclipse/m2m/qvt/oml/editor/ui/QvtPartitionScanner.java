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

import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

public class QvtPartitionScanner extends RuleBasedPartitionScanner {

	public final static String QVT_PARTITIONING = "__qvt_partitioning"; //$NON-NLS-1$
	
    public final static String QVT_COMMENT = "__qvt_comment"; //$NON-NLS-1$
    public final static String QVT_STRING = "__qvt_string"; //$NON-NLS-1$
    
    private static final char ESCAPE_CHAR = '\\';

    public QvtPartitionScanner() {

        IToken qvtComment = new Token(QVT_COMMENT);
        IToken qvtString = new Token(QVT_STRING);

        IPredicateRule[] rules = new IPredicateRule[] {
            new MultiLineRule("/*", "*/", qvtComment, (char) 0, true), //$NON-NLS-1$ //$NON-NLS-2$
            new EndOfLineRule("--", qvtComment), //$NON-NLS-1$
            new MultiLineRule("'", "'", qvtString, ESCAPE_CHAR, true), //$NON-NLS-1$ //$NON-NLS-2$
            new MultiLineRule("\"", "\"", qvtString, ESCAPE_CHAR, true) //$NON-NLS-1$ //$NON-NLS-2$
        };
        setPredicateRules(rules);
    }   
}
