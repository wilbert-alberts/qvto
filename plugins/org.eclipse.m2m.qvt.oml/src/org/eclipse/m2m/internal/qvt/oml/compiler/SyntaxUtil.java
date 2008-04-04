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
package org.eclipse.m2m.internal.qvt.oml.compiler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.m2m.internal.qvt.oml.evaluator.GraphWalker;
import org.eclipse.m2m.internal.qvt.oml.evaluator.GraphWalker.NodeProvider;


public class SyntaxUtil {
    public static Object[] findFirstImportCycle(ParsedModuleCS mappingModule) {
        return new GraphWalker(IMPORT_NODE_PROVIDER).findFirstCycle(mappingModule);
    }

    public static final NodeProvider IMPORT_NODE_PROVIDER = new NodeProvider()  {
        public Object[] getLinkedNodes(Object node) {
            ParsedModuleCS module = (ParsedModuleCS) node;
            if (module.getParsedImports().isEmpty()) {
            	return new ParsedModuleCS[0];
            }
            
            List<ParsedModuleCS> importedModules = new ArrayList<ParsedModuleCS>();
            ParsedModuleCS[] parsedModules = module.getParsedImports().toArray(new ParsedModuleCS[module.getParsedImports().size()]);
            for (int i = parsedModules.length-1; i >= 0; --i) {
                importedModules.add(parsedModules[i]);
            }

            return importedModules.toArray(new ParsedModuleCS[importedModules.size()]);
        }
    };
}
