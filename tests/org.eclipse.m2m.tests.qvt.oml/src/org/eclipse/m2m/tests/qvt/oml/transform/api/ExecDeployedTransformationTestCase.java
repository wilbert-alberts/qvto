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
package org.eclipse.m2m.tests.qvt.oml.transform.api;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;

/**
 * @author sboyko
 */
public class ExecDeployedTransformationTestCase extends ExecTransformationTestCase {
	
    public ExecDeployedTransformationTestCase(boolean useFilename, ModelTestData data) {
        super(data);
        myUseFilename = useFilename;
        setName("deployed: " + data.getName()); //$NON-NLS-1$
    }
    
    @Override
	protected URI createScriptUri(String scriptName) {
    	if (myUseFilename) {
			return URI.createPlatformPluginURI("/" + TestUtil.BUNDLE + "/" + ROOT_DIR_NAME //$NON-NLS-1$ //$NON-NLS-2$
					+ "/" + scriptName + "/" + scriptName + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT, false); //$NON-NLS-1$ //$NON-NLS-2$
    	} else {
			return URI.createPlatformPluginURI("/" + ROOT_DIR_NAME //$NON-NLS-1$
					+ "." + scriptName + "." + scriptName, false); //$NON-NLS-1$ //$NON-NLS-2$
    	}
	}
    
    private final boolean myUseFilename;
}
