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
package org.eclipse.m2m.qvt.oml.common.io;

import java.io.IOException;
import java.io.InputStream;

public interface CFile extends CResource {
	InputStream getContents() throws IOException;
	String getUnitName();
	long getTimeStamp();
	CFolder getParent();
	void create(InputStream contents) throws IOException;
	void setContents(InputStream contents) throws IOException;
	String getCharset() throws IOException;
}
