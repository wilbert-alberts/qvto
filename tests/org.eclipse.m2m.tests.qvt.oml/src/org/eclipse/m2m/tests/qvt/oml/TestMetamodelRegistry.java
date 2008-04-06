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
package org.eclipse.m2m.tests.qvt.oml;

import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.common.io.CResourceRepositoryContext;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.WorkspaceMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.common.nature.TransformationNature;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelDesc;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MModelURIMapFactory;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MappingContainer;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MetamodelURIMappingHelper;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.URIMapping;


public class TestMetamodelRegistry extends TestCase {
	private static final String METAMODEL_ID = "qvt.tests.metamodelID"; //$NON-NLS-1$
	private static final URI platformTestModelURI = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/models/javaless.ecore", false); //$NON-NLS-1$
	
	private TestProject myProject;
    private URI testEcoreFileURI;
    private MetamodelRegistry metamodelRegistry;
	
	@Override
	public void setUp() throws Exception {
		myProject = new TestProject("MModelREgistryTest", new String[] {TransformationNature.ID}); //$NON-NLS-1$
        
		Resource mappingResource = MetamodelURIMappingHelper.createMappingResource(myProject.getProject());
        MappingContainer allMappings = MetamodelURIMappingHelper.createNewMappings(mappingResource);
        
        URIMapping uriMapping = MModelURIMapFactory.eINSTANCE.createURIMapping();
        uriMapping.setSourceURI(METAMODEL_ID);
        
        testEcoreFileURI = prepareTestMetamodel();
        uriMapping.setTargetURI(testEcoreFileURI.toString());
        
        allMappings.getMapping().add(uriMapping);
        
        mappingResource.save(null);
        // TODO - sould rather be MetamodelURIMappingHelper operation
        // refresh .settings folder structure        
        myProject.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
        
        assertTrue(MetamodelURIMappingHelper.hasMappingResource(myProject.getProject()));  
        
        IMetamodelRegistryProvider.IRepositoryContext ctx = new CResourceRepositoryContext(new EclipseFile(myProject.getProject().getFile(".project"))); //$NON-NLS-1$
        metamodelRegistry = new WorkspaceMetamodelRegistryProvider().getRegistry(ctx);
	}
	
	@Override
	public void tearDown() throws Exception {
        myProject.delete();
	}
		
	public void testProjectContextRegistration() throws Exception {
        IMetamodelRegistryProvider.IRepositoryContext ctx = new CResourceRepositoryContext(
        		new EclipseFile(myProject.getProject().getFile(".project"))); //$NON-NLS-1$

        IMetamodelDesc metamodelDesc = new WorkspaceMetamodelRegistryProvider()
        	.getRegistry(ctx).getMetamodelDesc(METAMODEL_ID);
        assertNotNull(metamodelDesc);
        
        EPackage ePackage = metamodelDesc.getModel();
        assertEquals(ePackage.eResource().getURI(), testEcoreFileURI);
    }

	public void testGlobalContextRegistration() throws Exception {
		String knownID = EcorePackage.eINSTANCE.getNsURI();
        IMetamodelDesc metamodelDesc = metamodelRegistry.getMetamodelDesc(knownID);
        assertNotNull(metamodelDesc);
        assertSame(EcorePackage.eINSTANCE, metamodelDesc.getModel());
    }
	
	private URI prepareTestMetamodel() throws IOException {
		IFile ecoreFile = myProject.project.getFile("javaless.ecore"); //$NON-NLS-1$
        URI uri = URI.createPlatformResourceURI(ecoreFile.getFullPath().toString(), false);
		
        Resource testMetamodelUri = new ResourceSetImpl().getResource(platformTestModelURI, true);
		testMetamodelUri.setURI(uri);
		testMetamodelUri.save(null);
		
		return uri;
	}	
}
