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
package org.eclipse.m2m.qvt.oml.ocl.completion;

import java.util.Collections;
import java.util.Map;

public class CompletionData {

	public static final CompletionData EMPTY = new CompletionData();

	protected CompletionData() {
		this(Collections.EMPTY_MAP, Collections.EMPTY_MAP,
				Collections.EMPTY_MAP);
	}

	public CompletionData(final Map syntaxToSemanticMap,
			final Map syntaxToEnvironmentMap, final Map semanticToEnvironmentMap) {
		mySyntaxToSemanticMap = syntaxToSemanticMap;
		mySyntaxToEnvironmentMap = syntaxToEnvironmentMap;
		mySemanticToEnvironmentMap = semanticToEnvironmentMap;
	}

	public Map getSyntaxToSemanticMap() {
		return mySyntaxToSemanticMap;
	}

	public Map getSyntaxToEnvironmentMap() {
		return mySyntaxToEnvironmentMap;
	}

	public Map getSemanticToEnvironmentMap() {
		return mySemanticToEnvironmentMap;
	}

	private final Map mySyntaxToSemanticMap;

	private final Map mySyntaxToEnvironmentMap;

	private final Map mySemanticToEnvironmentMap;
}
