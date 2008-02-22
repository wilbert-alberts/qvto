/*******************************************************************************
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.common.io.eclipse;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.EmfMetamodelDesc;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.IMetamodelDesc;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.WorskpaceMetamodelProvider;

/**
 * @author aigdalov
 * Created on Feb 21, 2008
 */
public class InstanceBasedMetamodelRegistryProvider extends WorkspaceMetamodelRegistryProvider {
    private final EObject[] myInObjects;

    public InstanceBasedMetamodelRegistryProvider(EObject[] inObjects) {
        super();
        myInObjects = inObjects;
    }

    public InstanceBasedMetamodelRegistryProvider(EObject[] inObjects, ResourceSet resourceSet) {
        super(resourceSet);
        myInObjects = inObjects;
    }

    @Override
    protected WorskpaceMetamodelProvider createWorskpaceMetamodelProvider() {
        InstanceBasedMetamodelProvider metamodelProvider = new InstanceBasedMetamodelProvider(getResolutionResourceSet());
        if (myInObjects != null) {
            for (EObject inObject : myInObjects) {
                if (inObject != null) {
                    EClass eClass = inObject.eClass();
                    if (eClass != null) {
                        EPackage pack = eClass.getEPackage();
                        while (pack != null) {
                            if (pack.getNsURI() != null) {
                                metamodelProvider.addMetamodel(pack.getNsURI(), pack, null);
                            }
                            pack = pack.getESuperPackage();
                        }
                    }
                }
            }
        }
        return metamodelProvider;
    }
    
    protected class InstanceBasedMetamodelProvider extends WorskpaceMetamodelProvider {
        public InstanceBasedMetamodelProvider(ResourceSet resolutionRSet) {
            super(resolutionRSet);
        }

        public IMetamodelDesc addMetamodel(String metamodelID, EPackage pack, String namespace) {
            if(metamodelID == null) {
                throw new IllegalArgumentException("Null metamodel ID"); //$NON-NLS-1$          
            }
                    
            if(pack == null) {
                throw new IllegalArgumentException("Null package"); //$NON-NLS-1$
            }
                    
            IMetamodelDesc desc = new EmfMetamodelDesc(pack, metamodelID, namespace);
            return addMetamodelDesc(metamodelID, desc);
        }
    }
}