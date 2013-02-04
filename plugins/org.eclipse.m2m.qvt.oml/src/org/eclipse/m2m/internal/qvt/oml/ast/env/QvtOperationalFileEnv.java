/*******************************************************************************
 * Copyright (c) 2007,2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - bugs 302594, 310991
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.ast.env;

import java.util.ArrayList;
import java.util.List;

import lpg.runtime.ParseErrorCodes;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImportKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport;

public class QvtOperationalFileEnv extends QvtOperationalModuleEnv {

	private final URI myFile;    
	
	protected QvtOperationalFileEnv(final URI uri, EPackage.Registry registry) {
		// TODO - revisit the null resource passed
		super(new EPackageRegistryImpl(registry), null);

		if(uri == null) {
			throw new IllegalArgumentException("Non-null uri required"); //$NON-NLS-1$
		}
		
		myFile = uri;
		
    	QvtOperationalStdLibrary.INSTANCE.importTo(this);        
	}

	public URI getFile() {
        return myFile;
    }
	    	    
    @Override
    public String toString() {    
    	return  "QVTOEnv:" + myFile.toString(); //$NON-NLS-1$
    }
    
    @Override
    public void parserError(int errorCode, int leftToken, int rightToken, String tokenText) {
    	if (tokenText.equals("\"qvtErrorToken\"")) { //$NON-NLS-1$
    		if (errorCode == ParseErrorCodes.SUBSTITUTION_CODE) {
    			errorCode = ParseErrorCodes.INVALID_TOKEN_CODE;
    		}
    	}
    	super.parserError(errorCode, leftToken, rightToken, tokenText);
    }
    
    @Override
    public List<EStructuralFeature> getAdditionalAttributes(EClassifier classifier) {
    	
    	List<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
    	
    	result.addAll(super.getAdditionalAttributes(classifier));
    	
    	
    	// extract features of extended modules, which are no explicit supertypes (fixed by bugs 302594/310991)
    	
    	if (classifier instanceof Module) {
    		
    		Module module = (Module) classifier;
    	
	    	for (ModuleImport imp : module.getModuleImport()) {
				
				if (imp.getKind() == ImportKind.EXTENSION || imp.getImportedModule() instanceof Library) {
					
					Module extendedModule = imp.getImportedModule();
					
					List<EStructuralFeature> attributes = getUMLReflection().getAttributes(extendedModule);
					List<EStructuralFeature> additionalAttributes = getAdditionalAttributes(extendedModule);
									
					//attributes.removeAll(result);
					result.addAll(attributes);
					result.addAll(additionalAttributes);
					
				}
				
			}
    	
    	}
    	
    	return result;

    }
    
}
