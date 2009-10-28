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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelExtentContents;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelParameterExtent;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolverFactory;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.WorkspaceQvtModule;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;

public class TestQvtInterpreter extends TestTransformation {
	
	static final String PREFIX = "interpret_"; //$NON-NLS-1$
	
	public TestQvtInterpreter(String testName) {
		this(TestDataMapper.getTestDataByTestNameWithPrefix(PREFIX, testName));
	}
	
    public TestQvtInterpreter(ModelTestData data) {
        super(data);        
		setName(PREFIX + data.getName()); //$NON-NLS-1$
    }
    
    protected static String getActualTestName(String executedTestName) {
    	return TestDataMapper.getActualTestName(PREFIX, executedTestName);
    }
    
    protected ITransformer getTransformer() {
    	// execute compiled XMI
    	final ResourceSetImpl resSet = new ResourceSetImpl();
		Registry metamodelRegistry = getData().getMetamodelResolutionRegistry(getProject(), resSet);
		resSet.setPackageRegistry(metamodelRegistry);
		return new DefaultTransformer(true, metamodelRegistry) {
			public ResourceSetImpl createInputResourceSet() {
				return resSet;
			}
		};
    }
       
	@Override
    public void setUp() throws Exception {   
    	super.setUp();
    	
    	buildTestProject();
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
			this(false, null);
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
													        
					//temporarily commented out for [290002] "Adopt QVT CST to latest OCL 3.0.0 CST "
			        //URI binURI = ExeXMISerializer.toXMIUnitURI(resourceURI); //$NON-NLS-1$		
			        //assertTrue("Requires serialized AST for execution", URIConverter.INSTANCE.exists(binURI, null)); //$NON-NLS-1$
			    		
			        ResourceSetImpl resSet = CompiledUnit.createResourceSet();     			
			        if(fRegistry != null) {
				        EPackageRegistryImpl root = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
						root.putAll(fRegistry);
				        resSet.setPackageRegistry(root);
			        }
			        
			        //temporarily commented out for [290002] "Adopt QVT CST to latest OCL 3.0.0 CST "
					//myCompiler = CompilerUtils.createCompiler(resolver);
        			//return new CompiledUnit(binURI, resSet);
        			
					myCompiler = QVTOCompiler.createCompiler(resolver, resSet.getPackageRegistry());     
					// TODO - why not calling the compiler instance directly here?
					return QVTOCompiler.compile(new HashSet<URI>(Collections.singletonList(resourceURI)), resSet.getPackageRegistry())[0];        			
				}
			};

			return new QvtInterpretedTransformation(qvtModule); 
		}
		
		public ResourceSetImpl createInputResourceSet() {
			return new ResourceSetImpl();
		}
				
		public LinkedHashMap<ModelExtentContents, URI> transform(IFile transformation, List<URI> inUris, IContext qvtContext) throws Exception {
        	QvtInterpretedTransformation trans = getTransformation(transformation);
  
        	//TestUtil.assertAllPersistableAST(trans.getModule().getUnit());
        	ResourceSetImpl inputResourceSet = createInputResourceSet();
        	List<ModelContent> inputs = new ArrayList<ModelContent>(inUris.size());
        	for (URI uri : inUris) {        		
				ModelContent in = EmfUtil.loadModel(uri, inputResourceSet);
        		inputs.add(in);
        	}
            TransformationRunner.In input = new TransformationRunner.In(inputs.toArray(new ModelContent[inputs.size()]), qvtContext);
            TransformationRunner.Out output = null;
            try {
            	output = trans.run(input);
            } catch (QvtRuntimeException e) {            	
            	TestUtil.logQVTStackTrace(e);
				throw e;
			}

            //OperationalTransformation transformationModule = (OperationalTransformation) trans.getModule().getUnit();            
            LinkedHashMap<ModelExtentContents, URI> result = new LinkedHashMap<ModelExtentContents, URI>();            
            if(output.getOutParamValues().isEmpty() || !returnMainOperationOutput()) {            
            	List<ModelExtentContents> extents = output.getExtents(); 
            	int i = 0;
            	for (ModelExtentContents outExtent : extents) {
            		URI extentURI = saveModel("extent" + (++i), outExtent, new EclipseFile(transformation));
            		result.put(outExtent, extentURI);
            	}            
            } else {
            	int i = 0;            	
            	for (Object object : output.getOutParamValues()) {
            		ModelExtentContents outExtent = new ModelParameterExtent(
            				Collections.singletonList((EObject) object), null, null).getContents();            		
            		URI extentURI = saveModel("extent.param" + (++i), outExtent, new EclipseFile(transformation));            		
					result.put(outExtent, extentURI);
            	}
            }
            saveTraceData(output.getTrace(), new EclipseFile(transformation));
            return result;
		}
		
		protected boolean returnMainOperationOutput() {
			return true;
		}
	}
}
