/*******************************************************************************
 * Copyright (c) 2008, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.env;

import junit.framework.TestCase;

import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImportKind;

public class QVTOperationalEnvTest extends TestCase {

	private QvtOperationalEnvFactory factory;
	
	public QVTOperationalEnvTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {	
		super.setUp();
		
		factory = QvtOperationalEnvFactory.INSTANCE;
	}
	
	public void testImportedEnvironments() throws Exception {
		QvtOperationalModuleEnv parentEnv = factory.createModuleEnvironment(QvtOperationalStdLibrary.createLibrary("Foo"));
		QvtOperationalModuleEnv importedEnv = factory.createModuleEnvironment(QvtOperationalStdLibrary.createLibrary("Imported"));		
		
		parentEnv.addImport(ImportKind.EXTENSION, importedEnv);
		assertTrue(parentEnv.getImportsByExtends().contains(importedEnv));		
				
		QvtOperationalEnv childEnv = factory.createEnvironment(parentEnv);
		
		QvtOperationalModuleEnv importedEnv2 = factory.createModuleEnvironment(QvtOperationalStdLibrary.createLibrary("Imported2"));		
		childEnv.addImport(ImportKind.ACCESS, importedEnv2);

		assertEquals(parentEnv.getImportsByAccess(), childEnv.getImportsByAccess());
		assertEquals(parentEnv.getImportsByExtends(), childEnv.getImportsByExtends());		
		assertTrue(childEnv.getImportsByExtends().contains(importedEnv));		
		assertTrue(childEnv.getImportsByAccess().contains(importedEnv2));
		
		assertTrue(parentEnv.getImportsByAccess().contains(importedEnv2));
	}
}
