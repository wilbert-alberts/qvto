/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation
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

import org.eclipse.core.resources.IFile;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.InstantiationExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.tests.qvt.oml.transform.FileToFileData;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;
import org.eclipse.m2m.tests.qvt.oml.transform.TestQvtInterpreter;
import org.eclipse.m2m.tests.qvt.oml.transform.TestTransformation;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.VariableExp;


/**
 * TODO - this class is a temporary test case for composite transformation
 * until CST gets ready
 */
public class CompositeTransformationTest extends TestQvtInterpreter {
	
	private ITransformer fTranformer;	
	
	public CompositeTransformationTest(ModelTestData data) {
		super(data);
	}

	public CompositeTransformationTest(String testName) {
		this(createTestData(getActualTestName(testName)));
	}

	public static FileToFileData createTestData(String testName) {
		return new FileToFileData(testName);
	}
	
	@Override
	protected ITransformer getTransformer() {	
		return fTranformer;
	}	
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		
		IFile file = TestTransformation.getIFile(getData().getTransformation(getProject()));		
		final QvtInterpretedTransformation transformation = new QvtInterpretedTransformation(file);
		
		fTranformer = new DefaultTransformer() {
			@Override
			protected QvtInterpretedTransformation getTransformation(IFile transformationFile) {
				return transformation;
			}
		};

		Module module = transformation.getModule().getModule().getModule(); // TODO - somethis smells here ??? ;-)
		OperationBody body = module.getEntry().getBody();
		// Inject another transformation call
		// inserts after between the initial code
		body.getContent().add(1, createInstantiation((OperationalTransformation)module));
	}
		
	private OperationCallExp createInstantiation(OperationalTransformation mainModule) {
		OperationalTransformation importedModule = (OperationalTransformation)mainModule.getModuleImport().get(0).getImportedModule();

		ModelParameter modelParameter = mainModule.getModelParameter().get(0); 
		
		VariableExp modelReference = EcoreFactory.eINSTANCE.createVariableExp();
		//importedModule.getEntry().getBody().getVariable().add(modelReference);
		
		modelReference.setEType(modelParameter.getEType());
		modelReference.setReferredVariable(modelParameter);

		InstantiationExp instantiationExp = ExpressionsFactory.eINSTANCE.createInstantiationExp();
		instantiationExp.getArgument().add(modelReference);
		instantiationExp.setInstantiatedClass(importedModule);
		instantiationExp.setName(mainModule.getName());
		instantiationExp.setType(importedModule);

		OperationCallExp call = EcoreFactory.eINSTANCE.createOperationCallExp();
		call.setEType(instantiationExp.getType());
		
		call.setReferredOperation(QvtOperationalStdLibrary.INSTANCE.getTransformOperation());
		call.setSource(instantiationExp);
		call.getArgument().add(modelReference);
		return call;
	}
		   
	@Override
	public void tearDown() throws Exception {
		super.tearDown();
	}
}
