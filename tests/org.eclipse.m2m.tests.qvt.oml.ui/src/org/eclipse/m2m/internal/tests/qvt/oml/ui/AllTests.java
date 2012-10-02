/*******************************************************************************
 * Copyright (c) 2007-2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.tests.qvt.oml.ui;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.m2m.internal.tests.qvt.oml.ui.completion.CompletionTests;
import org.eclipse.m2m.internal.tests.qvt.oml.ui.editor.AllEditorTests;

/**
 * @author sboyko
 */
public class AllTests {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(AllTests.suite());
	}

	public static Test suite() {
		try {				// Workaround BUG 390479
			IPreferenceStore store = org.eclipse.egit.ui.Activator.getDefault().getPreferenceStore();
			store.setValue(org.eclipse.egit.ui.UIPreferences.SHOW_GIT_PREFIX_WARNING, false);
		}
		catch (NoClassDefFoundError e) {}
		TestSuite suite = new TestSuite("Tests for org.eclipse.m2m.tests.qvt.oml.ui"); //$NON-NLS-1$
		//$JUnit-BEGIN$
        suite.addTest(CompletionTests.suite());
		suite.addTest(AllEditorTests.suite());
		//$JUnit-END$
		return suite;
	}
}
