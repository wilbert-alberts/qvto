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
package org.eclipse.m2m.internal.qvt.oml.runtime.generator;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.emf.ExtendedEmfUtil;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.trace.EValue;
import org.eclipse.m2m.qvt.oml.trace.Trace;
import org.eclipse.m2m.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.qvt.oml.trace.VarParameterValue;


public class TraceSerializer {
    private TraceSerializer() {}

    public static final void saveTraceModel(Trace trace, CFile file) throws MdaException {
        Map<String, String> options = new HashMap<String, String>();
        options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
        ExtendedEmfUtil.saveModel(patch(trace), file, options);
    }

    private static Trace patch(Trace trace) {
        for (TraceRecord traceRecord : trace.getTraceRecords()) {
            VarParameterValue context = traceRecord.getContext().getContext();
            if (context != null) {
    			patch(context.getValue());
            }
            for (VarParameterValue param : traceRecord.getParameters().getParameters()) {
                patch(param.getValue());
            }
            for (VarParameterValue result : traceRecord.getResult().getResult()) {
                patch(result.getValue());
            }
        }
        return trace;
    }

    private static void patch(EValue eValue) {
        if (eValue != null) {
            EObject modelElement = eValue.getModelElement();
            if (modelElement != null) {
                if (modelElement.eResource() == null) {
                    if (modelElement.eContainer() == null) {
                    	eValue.setIntermediateElement(modelElement);
                    }
                }
            } else {
            	EList<EValue> collection = eValue.getCollection();
            	if (!collection.isEmpty()) {
            		for (EValue collectionElement : collection) {
						patch(collectionElement);
					}
            	}
            }
        }
    }
}
