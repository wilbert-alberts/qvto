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
package org.eclipse.m2m.tests.qvt.oml.transform;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerUtils;
import org.eclipse.m2m.internal.qvt.oml.compiler.ExeXMISerializer;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolverFactory;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.WorkspaceQvtModule;
import org.eclipse.m2m.qvt.oml.util.IContext;

public class TestQvtInterpreter extends TestTransformation {
	
	static final String PREFIX = "interpret_"; //$NON-NLS-1$
	
	public TestQvtInterpreter(String testName) {
		this(TestDataMapper.getTestDataByTestNameWithPrefix(PREFIX, testName));
	}
	
    public TestQvtInterpreter(ModelTestData data) {
        super(data);        
		setName(PREFIX + data.getName());
    }
    
    protected static String getActualTestName(String executedTestName) {
    	return TestDataMapper.getActualTestName(PREFIX, executedTestName);
    }
    
    protected ITransformer getTransformer() {
    	// execute compiled XMI
    	final ResourceSetImpl resSet = new ResourceSetImpl();
		Registry metamodelRegistry = getData().getMetamodelResolutionRegistry(getProject(), resSet);
		resSet.setPackageRegistry(metamodelRegistry);
		return new DefaultTransformer(true, metamodelRegistry);
    }
       
	@Override
    public void setUp() throws Exception {   
    	super.setUp();
    	
    	try {
    		buildTestProject();
    	}
    	catch (Exception e) {
			tearDown();
			throw e;
		}
    }
    
    @Override
	public void runTest() throws Exception {
        checkTransformation(new TransformationChecker(getTransformer()));
    }
    
    public static final ITransformer TRANSFORMER = new DefaultTransformer();
    
	public static class DefaultTransformer implements ITransformer {
		
		private final boolean fExecuteCompiledAST;
		private final EPackage.Registry fRegistry;
		
		public DefaultTransformer() {
			this(true, null);
		}
		
		public DefaultTransformer(boolean executeCompiledAST, EPackage.Registry registry) {
			fExecuteCompiledAST = executeCompiledAST;
			fRegistry = registry;
		}
		
		protected QvtInterpretedTransformation getTransformation(IFile transformation) {
			if(!fExecuteCompiledAST) {
				return new QvtInterpretedTransformation(transformation);
			}
			
			WorkspaceQvtModule qvtModule = new WorkspaceQvtModule(transformation) {
				@Override
				protected CompiledUnit loadModule() throws MdaException {
			        QvtCompilerOptions options = getQvtCompilerOptions();
			        if (options == null) {
			            options = new QvtCompilerOptions();
			        }            
			    	IFile transformationFile = getTransformationFile();
					UnitResolverFactory factory = UnitResolverFactory.Registry.INSTANCE.getFactory(transformationFile);
					URI resourceURI = URI.createPlatformResourceURI(transformationFile.getFullPath().toString(), true);
					UnitResolver resolver = factory.getResolver(resourceURI);
													        
			        URI binURI = ExeXMISerializer.toXMIUnitURI(resourceURI);		
			        assertTrue("Requires serialized AST for execution", URIConverter.INSTANCE.exists(binURI, null)); //$NON-NLS-1$
			    		
			        ResourceSetImpl resSet = CompiledUnit.createResourceSet();     			
			        if(fRegistry != null) {
				        EPackageRegistryImpl root = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
						root.putAll(fRegistry);
				        resSet.setPackageRegistry(root);
			        }
			        
					myCompiler = CompilerUtils.createCompiler(resolver);
					myCompiler.getResourceSet().setPackageRegistry(resSet.getPackageRegistry());
        			return new CompiledUnit(binURI, resSet);
       			
				}
			};

			return new QvtInterpretedTransformation(qvtModule); 
		}
		
		public List<URI> transform(IFile transformation, List<URI> inUris, IContext qvtContext) throws Exception {
        	QvtInterpretedTransformation transf = getTransformation(transformation);
        	
        	//TestUtil.assertAllPersistableAST(trans.getModule().getUnit());
        	return launchTransform(transformation, inUris, qvtContext, transf);
		}

	}
}
