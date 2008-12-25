/*******************************************************************************
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.cst.parser;

import org.eclipse.osgi.util.NLS;

/**
 * @author Aleksandr Igdalov
 * Created on Nov 27, 2008
 */

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.cst.parser.messages"; //$NON-NLS-1$
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

    public static String AbstractQVTParser_NoModulesDeclared;
    public static String AbstractQVTParser_MultipleModulesExtraUnitElements;
    public static String AbstractQVTParser_MultiplicityInvalidLowerBound;
    public static String AbstractQVTParser_MultiplicityInvalidRange;
    public static String AbstractQVTParser_MultiplicityEmptyRange;

}
