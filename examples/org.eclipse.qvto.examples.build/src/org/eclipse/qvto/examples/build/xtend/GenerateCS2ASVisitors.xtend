/**
 * <copyright>
 *
 * Copyright (c) 2013 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvto.examples.build.xtend

import java.util.ArrayList
import java.util.List
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.jdt.annotation.NonNull
import org.eclipse.ocl.examples.build.xtend.GenerateCSVisitors
import org.eclipse.ocl.examples.build.xtend.MergeWriter
import org.eclipse.ocl.examples.pivot.Class
import org.eclipse.ocl.examples.pivot.Element
import org.eclipse.ocl.examples.pivot.ExpressionInOCL
import org.eclipse.ocl.examples.pivot.OpaqueExpression
import org.eclipse.ocl.examples.pivot.Operation
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager
import org.eclipse.ocl.examples.pivot.model.OCLstdlib
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation
import org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCLStandaloneSetup
import org.eclipse.qvto.examples.build.utlities.ContainmentVisitsGeneratorCtx

// TODO non-derived visitor is not supported, since currently 
// the root CS2AS are not generated but manually coded. 
public class GenerateCS2ASVisitors extends org.eclipse.ocl.examples.build.xtend.GenerateCS2ASVisitors
{
	private String asGenModelURI;
	 
	override void generateVisitors(EPackage csPackage) {
		super.generateVisitors(csPackage);
		if (isDerived()) {
			generateContainmentVisitor(csPackage);
			generatePreOrderVisitor(csPackage);
			generatePostOrderVisitor(csPackage);
			generateLeft2RightVisitor(csPackage);
		}
	}
	
	override def void generateContainmentVisitor(@NonNull EPackage csPackage) {
		var String visitorVariantName = "Containment";
		var String resultTypeName =  "Continuation<?>";
		var String visitorVariantClassName = projectPrefix + visitorVariantName + "Visitor";
		var String variantExtendedClass = superProjectPrefix + visitorVariantName + "Visitor";
		//		var String extendedClass = if (superVisitorClassName.length() == 0) {
//				"AbstractExtending" + visitableClassName;
//			} else {
//				visitorPrefix + superVisitorClassName;
//			}
		var String interfaceName =  visitorClassName +'<'+resultTypeName+'>';
		var List<String> additionalImports additionalImports = new ArrayList();
		additionalImports.add(typeof(Continuation).name);
		csPackage.generateContainmentVisitor(visitorVariantClassName, variantExtendedClass, interfaceName, resultTypeName, additionalImports);
	}

	

	
	/**
	 * TODO When fully generation is achieved, visitAbstractConcept method needs to be qualified as follows:
	 *     visitAbstractElement(Abstract object) {
	 *       throw new UnsupportedOperationException();
	 *     }  
	 */
	protected def void generateContainmentVisitor(@NonNull EPackage ePackage, 
		@NonNull String className, @NonNull String extendedClassName, @NonNull String interfaceName, @NonNull String resultTypeName, 
		@NonNull List<String> additionalImports) {
		var MergeWriter writer = new MergeWriter(outputFolder + className + ".java");
		writer.append('''
			«ePackage.generateHeader(visitorPackageName)»
			
			import org.eclipse.jdt.annotation.NonNull;
			import org.eclipse.jdt.annotation.Nullable;
			import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
			import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
			import «superProjectName».cs2as.«extendedClassName»;
			«FOR additionalImport : additionalImports»
			import «additionalImport»;
			«ENDFOR»
			
			/**
			 *
			 */
			public class «className»
				extends «extendedClassName»
				implements «interfaceName»
			{
				/**
				 * Initializes me with an initial value for my result.
				 * 
				 * @param context my initial result value
				 */
				public «className»(@NonNull CS2PivotConversion context) {
					super(context);
				}
				«FOR eClass : getSortedEClasses(ePackage)»
				public @Nullable «resultTypeName» visit«eClass.name»(@NonNull «modelPackageName».«eClass.name» csElement) {
				«IF (eClass.hasAstOperation())»
					«eClass.generateContainmentVisit()»
				«ELSE»
						throw new UnsupportedOperationException("visit«eClass.name» not supported in «className»");
				«ENDIF»
				}
				
				«ENDFOR»
			}
		''');
		writer.close();
	}
	
	private def boolean hasAstOperation(EClass eclass)	{
		for (EOperation operation : eclass.EOperations) {
			if (operation.name == "ast") {
				return true;
			}
		}
		return false;
	}
	
	private def String generateContainmentVisit(EClass eClass) {
		
		OCLstdlib.install();
		EssentialOCLStandaloneSetup.doSetup();
		var MetaModelManager metaModelManager = MetaModelManager.getAdapter(resourceSet);
		var Resource ecoreResource = eClass.eResource(); 
		var Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreResource, metaModelManager);
		var Class pClass = ecore2Pivot.getPivotElement(typeof(Class), eClass);
		if (pClass != null) {
			for (Operation operation :  pClass.ownedOperation) {
				if ("ast".equals(operation.name)) {
					// We obtain the expression to visit
					var OpaqueExpression opaqueExp = operation.bodyExpression;
					var ExpressionInOCL expInOcl = PivotUtil.getExpressionInOCL(operation, opaqueExp);
					
					// We compute the context
					var URI projectResourceURI = URI.createPlatformResourceURI("/" + projectName + "/", true);
					var URI genModelURI = URI.createURI(genModelFile).resolve(projectResourceURI);
					var GenModel sourceGenModel = getGenModel(genModelURI, resourceSet);
					var GenModel targetGenModel = getGenModel(URI.createURI(getASGenModelURI), resourceSet) // FIXME
					
					// We visit the expression to generate the containment visit method body
					return expInOcl.bodyExpression.accept(new ContainmentVisitsGenerator(new ContainmentVisitsGeneratorCtx(sourceGenModel, targetGenModel)));
				}
			}
		}
		return "return null;"; // TODO case in which no pClass or no ast operation has been found
	}
	
	def private GenModel getGenModel(URI genModelURI, ResourceSet rSet) {
		var Resource genModelResource = resourceSet.getResource(genModelURI, true);
		return genModelResource.getContents().get(0) as GenModel;
	}
	
	def public setASGenModelURI(String asGenModelURI) {
		this.asGenModelURI = asGenModelURI;
	}
	
	def protected String getASGenModelURI () {
		return asGenModelURI;
	}
}
