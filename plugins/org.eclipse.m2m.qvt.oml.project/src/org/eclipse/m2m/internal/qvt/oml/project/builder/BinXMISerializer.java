/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.project.builder;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.ExecutableXMIHelper;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.project.QVTOProjectPlugin;

public class BinXMISerializer {

	public static URI toSourceUnitURI(URI uri) {
		return uri.trimFileExtension().appendFileExtension(MDAConstants.QVTO_FILE_EXTENSION);
	}
	
	public static URI toXMIUnitURI(URI uri) {
		return uri.trimFileExtension().appendFileExtension("xmi"); //$NON-NLS-1$
	}	
	
	public static void saveUnitXMI(CompiledUnit[] units) throws IOException {
		ResourceSetImpl rs = new ResourceSetImpl();
		
		for (CompiledUnit nextUnit : units) {
			if(nextUnit.getUnitCST() == null) {
				// loaded from compiled QVT XMI
				continue;
			}

			URI uri = nextUnit.getURI();
			URI xmiUnitURI = toXMIUnitURI(uri);
			
			for (QvtOperationalModuleEnv nextModuleEnv : nextUnit.getModuleEnvironments()) {
				Resource unitResource = nextModuleEnv.getTypeResolver().getResource();				
				unitResource.setURI(xmiUnitURI);
				ExecutableXMIHelper.fixResourceOnSave(unitResource);
				
				rs.getResources().add(unitResource);
			}
		}

		for (Resource next : rs.getResources()) {
			next.save(Collections.EMPTY_MAP);

			URI savedXMIURI = next.getURI();
			URI srcURI = toSourceUnitURI(savedXMIURI);
			Map<Object, Object> options = Collections.emptyMap();
			
	        Map<String, ?> xmiAttrs = URIConverter.INSTANCE.getAttributes(savedXMIURI, options);		        
			Map<String, Object> xmiNewAttributes = new HashMap<String, Object>(xmiAttrs);
			
			Object srcFileTimeStmp = URIConverter.INSTANCE.getAttributes(srcURI, options).get(URIConverter.ATTRIBUTE_TIME_STAMP);
			xmiNewAttributes.put(URIConverter.ATTRIBUTE_TIME_STAMP, srcFileTimeStmp);
			// save identical time stamp to save XMI  
			URIConverter.INSTANCE.setAttributes(savedXMIURI, xmiNewAttributes, options);
			
			if(!next.getErrors().isEmpty()) {
				Diagnostic diagnostic = EcoreUtil.computeDiagnostic(next, false);
				QVTOProjectPlugin.log(BasicDiagnostic.toIStatus(diagnostic));
			}
		}
	}
}
