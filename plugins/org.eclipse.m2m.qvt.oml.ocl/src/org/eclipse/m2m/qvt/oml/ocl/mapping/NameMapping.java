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
/*
 * Created on Apr 7, 2005
 */
package org.eclipse.m2m.qvt.oml.ocl.mapping;

import org.eclipse.m2m.qvt.oml.ocl.preferences.RegistryElement;

public interface NameMapping extends RegistryElement {
    
    String getPattern();
    
    void setPattern(String pattern);
    
    String getReplaceBy();
    
    void setReplaceBy(String replaceBy);
    
    boolean isWholeWords();
    
    void setWholeWords(boolean wholeWords);
    
    String map(String name);

}
