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
package org.eclipse.m2m.tests.qvt.oml;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.m2m.qvt.oml.common.parser.Node;
import org.eclipse.m2m.qvt.oml.common.parser.ParameterizedStringParser;

public class TestStringParser extends TestCase {
    public void testParser() throws Exception {
        String[][] data = new String[][] {
                new String[] {"", ""}, //$NON-NLS-1$ //$NON-NLS-2$
                new String[] {"c:\\", "c:\\"}, //$NON-NLS-1$ //$NON-NLS-2$
                new String[] {"c:\\${foo}", "c:\\bar"}, //$NON-NLS-1$ //$NON-NLS-2$
                new String[] {"c:\\${foo}\\", "c:\\bar\\"}, //$NON-NLS-1$ //$NON-NLS-2$
                new String[] {"c:\\${bar}\\", "c:\\${bar}\\"}, //$NON-NLS-1$ //$NON-NLS-2$
        };
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("foo", "bar"); //$NON-NLS-1$ //$NON-NLS-2$
        
        for (int i = 0; i < data.length; i++) {
            String[] pair = data[i];
            String s = pair[0];
            String expectedResolved = pair[1];
            
            Node[] nodes = new ParameterizedStringParser(s).parse();
            assertNotNull(nodes);
            
            String printed = ParameterizedStringParser.toString(nodes);
            assertEquals("Failed to print, s=" + s + " p=" + printed, s, printed); //$NON-NLS-1$ //$NON-NLS-2$
            
            String actualResolved = ParameterizedStringParser.resolve(nodes, params);
            assertEquals("Failed to resolve", expectedResolved, actualResolved); //$NON-NLS-1$
        }
        
    }
}
