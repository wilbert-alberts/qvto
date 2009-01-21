/**
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 * 
 * 
 *
 * $Id: CSTAdapterFactory.java,v 1.14 2009/01/21 10:14:29 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.cst.*;
import org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ComputeExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ConfigPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralPartCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DictionaryTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ElementWithBody;
import org.eclipse.m2m.internal.qvt.oml.cst.ExpressionStatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ForExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeIterateExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeLoopExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LibraryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LibraryImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ListTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LocalPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LogExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingCallExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingEndCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingInitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.NewRuleCallExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.OppositePropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.OutExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.PackageRefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.RenameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveInExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ReturnExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS;
import org.eclipse.m2m.internal.qvt.oml.cst.StatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SwitchExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS;
import org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.FeatureCallExpCS;
import org.eclipse.ocl.cst.LiteralExpCS;
import org.eclipse.ocl.cst.LoopExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.TypeCS;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage
 * @generated
 */
public class CSTAdapterFactory extends AdapterFactoryImpl {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CSTPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSTAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CSTPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CSTSwitch<Adapter> modelSwitch =
		new CSTSwitch<Adapter>() {
			@Override
			public Adapter caseMappingModuleCS(MappingModuleCS object) {
				return createMappingModuleCSAdapter();
			}
			@Override
			public Adapter caseLibraryCS(LibraryCS object) {
				return createLibraryCSAdapter();
			}
			@Override
			public Adapter caseImportCS(ImportCS object) {
				return createImportCSAdapter();
			}
			@Override
			public Adapter caseModuleImportCS(ModuleImportCS object) {
				return createModuleImportCSAdapter();
			}
			@Override
			public Adapter caseLibraryImportCS(LibraryImportCS object) {
				return createLibraryImportCSAdapter();
			}
			@Override
			public Adapter caseRenameCS(RenameCS object) {
				return createRenameCSAdapter();
			}
			@Override
			public Adapter caseModulePropertyCS(ModulePropertyCS object) {
				return createModulePropertyCSAdapter();
			}
			@Override
			public Adapter caseConfigPropertyCS(ConfigPropertyCS object) {
				return createConfigPropertyCSAdapter();
			}
			@Override
			public Adapter caseLocalPropertyCS(LocalPropertyCS object) {
				return createLocalPropertyCSAdapter();
			}
			@Override
			public Adapter caseContextualPropertyCS(ContextualPropertyCS object) {
				return createContextualPropertyCSAdapter();
			}
			@Override
			public Adapter caseClassifierDefCS(ClassifierDefCS object) {
				return createClassifierDefCSAdapter();
			}
			@Override
			public Adapter caseClassifierPropertyCS(ClassifierPropertyCS object) {
				return createClassifierPropertyCSAdapter();
			}
			@Override
			public Adapter caseOppositePropertyCS(OppositePropertyCS object) {
				return createOppositePropertyCSAdapter();
			}
			@Override
			public Adapter caseMultiplicityDefCS(MultiplicityDefCS object) {
				return createMultiplicityDefCSAdapter();
			}
			@Override
			public Adapter caseMappingDeclarationCS(MappingDeclarationCS object) {
				return createMappingDeclarationCSAdapter();
			}
			@Override
			public Adapter caseParameterDeclarationCS(ParameterDeclarationCS object) {
				return createParameterDeclarationCSAdapter();
			}
			@Override
			public Adapter caseSimpleSignatureCS(SimpleSignatureCS object) {
				return createSimpleSignatureCSAdapter();
			}
			@Override
			public Adapter caseCompleteSignatureCS(CompleteSignatureCS object) {
				return createCompleteSignatureCSAdapter();
			}
			@Override
			public Adapter caseMappingMethodCS(MappingMethodCS object) {
				return createMappingMethodCSAdapter();
			}
			@Override
			public Adapter caseMappingRuleCS(MappingRuleCS object) {
				return createMappingRuleCSAdapter();
			}
			@Override
			public Adapter caseMappingQueryCS(MappingQueryCS object) {
				return createMappingQueryCSAdapter();
			}
			@Override
			public Adapter caseMappingSectionCS(MappingSectionCS object) {
				return createMappingSectionCSAdapter();
			}
			@Override
			public Adapter caseMappingInitCS(MappingInitCS object) {
				return createMappingInitCSAdapter();
			}
			@Override
			public Adapter caseMappingEndCS(MappingEndCS object) {
				return createMappingEndCSAdapter();
			}
			@Override
			public Adapter caseMappingSectionsCS(MappingSectionsCS object) {
				return createMappingSectionsCSAdapter();
			}
			@Override
			public Adapter caseStatementCS(StatementCS object) {
				return createStatementCSAdapter();
			}
			@Override
			public Adapter caseAssignStatementCS(AssignStatementCS object) {
				return createAssignStatementCSAdapter();
			}
			@Override
			public Adapter caseExpressionStatementCS(ExpressionStatementCS object) {
				return createExpressionStatementCSAdapter();
			}
			@Override
			public Adapter caseVariableInitializationCS(VariableInitializationCS object) {
				return createVariableInitializationCSAdapter();
			}
			@Override
			public Adapter caseMappingBodyCS(MappingBodyCS object) {
				return createMappingBodyCSAdapter();
			}
			@Override
			public Adapter caseOutExpCS(OutExpCS object) {
				return createOutExpCSAdapter();
			}
			@Override
			public Adapter caseMappingCallExpCS(MappingCallExpCS object) {
				return createMappingCallExpCSAdapter();
			}
			@Override
			public Adapter caseWhileExpCS(WhileExpCS object) {
				return createWhileExpCSAdapter();
			}
			@Override
			public Adapter caseSwitchExpCS(SwitchExpCS object) {
				return createSwitchExpCSAdapter();
			}
			@Override
			public Adapter caseSwitchAltExpCS(SwitchAltExpCS object) {
				return createSwitchAltExpCSAdapter();
			}
			@Override
			public Adapter caseBlockExpCS(BlockExpCS object) {
				return createBlockExpCSAdapter();
			}
			@Override
			public Adapter caseComputeExpCS(ComputeExpCS object) {
				return createComputeExpCSAdapter();
			}
			@Override
			public Adapter caseDirectionKindCS(DirectionKindCS object) {
				return createDirectionKindCSAdapter();
			}
			@Override
			public Adapter caseElementWithBody(ElementWithBody object) {
				return createElementWithBodyAdapter();
			}
			@Override
			public Adapter caseResolveExpCS(ResolveExpCS object) {
				return createResolveExpCSAdapter();
			}
			@Override
			public Adapter caseResolveInExpCS(ResolveInExpCS object) {
				return createResolveInExpCSAdapter();
			}
			@Override
			public Adapter caseModelTypeCS(ModelTypeCS object) {
				return createModelTypeCSAdapter();
			}
			@Override
			public Adapter casePackageRefCS(PackageRefCS object) {
				return createPackageRefCSAdapter();
			}
			@Override
			public Adapter caseTransformationHeaderCS(TransformationHeaderCS object) {
				return createTransformationHeaderCSAdapter();
			}
			@Override
			public Adapter caseModuleKindCS(ModuleKindCS object) {
				return createModuleKindCSAdapter();
			}
			@Override
			public Adapter caseModuleRefCS(ModuleRefCS object) {
				return createModuleRefCSAdapter();
			}
			@Override
			public Adapter caseModuleUsageCS(ModuleUsageCS object) {
				return createModuleUsageCSAdapter();
			}
			@Override
			public Adapter caseTransformationRefineCS(TransformationRefineCS object) {
				return createTransformationRefineCSAdapter();
			}
			@Override
			public Adapter caseTypeSpecCS(TypeSpecCS object) {
				return createTypeSpecCSAdapter();
			}
			@Override
			public Adapter caseLogExpCS(LogExpCS object) {
				return createLogExpCSAdapter();
			}
			@Override
			public Adapter caseAssertExpCS(AssertExpCS object) {
				return createAssertExpCSAdapter();
			}
			@Override
			public Adapter caseImperativeLoopExpCS(ImperativeLoopExpCS object) {
				return createImperativeLoopExpCSAdapter();
			}
			@Override
			public Adapter caseForExpCS(ForExpCS object) {
				return createForExpCSAdapter();
			}
			@Override
			public Adapter caseImperativeIterateExpCS(ImperativeIterateExpCS object) {
				return createImperativeIterateExpCSAdapter();
			}
			@Override
			public Adapter caseReturnExpCS(ReturnExpCS object) {
				return createReturnExpCSAdapter();
			}
			@Override
			public Adapter caseMappingExtensionCS(MappingExtensionCS object) {
				return createMappingExtensionCSAdapter();
			}
			@Override
			public Adapter caseNewRuleCallExpCS(NewRuleCallExpCS object) {
				return createNewRuleCallExpCSAdapter();
			}
			@Override
			public Adapter caseListTypeCS(ListTypeCS object) {
				return createListTypeCSAdapter();
			}
			@Override
			public Adapter caseDictionaryTypeCS(DictionaryTypeCS object) {
				return createDictionaryTypeCSAdapter();
			}
			@Override
			public Adapter caseDictLiteralExpCS(DictLiteralExpCS object) {
				return createDictLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseDictLiteralPartCS(DictLiteralPartCS object) {
				return createDictLiteralPartCSAdapter();
			}
			@Override
			public Adapter caseTagCS(TagCS object) {
				return createTagCSAdapter();
			}
			@Override
			public Adapter caseCSTNode(CSTNode object) {
				return createCSTNodeAdapter();
			}
			@Override
			public Adapter caseOCLExpressionCS(OCLExpressionCS object) {
				return createOCLExpressionCSAdapter();
			}
			@Override
			public Adapter caseCallExpCS(CallExpCS object) {
				return createCallExpCSAdapter();
			}
			@Override
			public Adapter caseFeatureCallExpCS(FeatureCallExpCS object) {
				return createFeatureCallExpCSAdapter();
			}
			@Override
			public Adapter caseOperationCallExpCS(OperationCallExpCS object) {
				return createOperationCallExpCSAdapter();
			}
			@Override
			public Adapter caseLoopExpCS(LoopExpCS object) {
				return createLoopExpCSAdapter();
			}
			@Override
			public Adapter caseTypeCS(TypeCS object) {
				return createTypeCSAdapter();
			}
			@Override
			public Adapter caseLiteralExpCS(LiteralExpCS object) {
				return createLiteralExpCSAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS <em>Mapping Module CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS
	 * @generated
	 */
	public Adapter createMappingModuleCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.LibraryCS <em>Library CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.LibraryCS
	 * @generated
	 */
	public Adapter createLibraryCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ImportCS <em>Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ImportCS
	 * @generated
	 */
	public Adapter createImportCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleImportCS <em>Module Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModuleImportCS
	 * @generated
	 */
	public Adapter createModuleImportCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.LibraryImportCS <em>Library Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.LibraryImportCS
	 * @generated
	 */
	public Adapter createLibraryImportCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.RenameCS <em>Rename CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.RenameCS
	 * @generated
	 */
	public Adapter createRenameCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS <em>Module Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS
	 * @generated
	 */
	public Adapter createModulePropertyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ConfigPropertyCS <em>Config Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ConfigPropertyCS
	 * @generated
	 */
	public Adapter createConfigPropertyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.LocalPropertyCS <em>Local Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.LocalPropertyCS
	 * @generated
	 */
	public Adapter createLocalPropertyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS <em>Contextual Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS
	 * @generated
	 */
	public Adapter createContextualPropertyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS <em>Classifier Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS
	 * @generated
	 */
	public Adapter createClassifierDefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS <em>Classifier Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS
	 * @generated
	 */
	public Adapter createClassifierPropertyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.OppositePropertyCS <em>Opposite Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.OppositePropertyCS
	 * @generated
	 */
	public Adapter createOppositePropertyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS <em>Multiplicity Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS
	 * @generated
	 */
	public Adapter createMultiplicityDefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS <em>Mapping Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS
	 * @generated
	 */
	public Adapter createMappingDeclarationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS <em>Parameter Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS
	 * @generated
	 */
	public Adapter createParameterDeclarationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS <em>Simple Signature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS
	 * @generated
	 */
	public Adapter createSimpleSignatureCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS <em>Complete Signature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS
	 * @generated
	 */
	public Adapter createCompleteSignatureCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS <em>Mapping Method CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS
	 * @generated
	 */
	public Adapter createMappingMethodCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS <em>Mapping Rule CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS
	 * @generated
	 */
	public Adapter createMappingRuleCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS <em>Mapping Query CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS
	 * @generated
	 */
	public Adapter createMappingQueryCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionCS <em>Mapping Section CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionCS
	 * @generated
	 */
	public Adapter createMappingSectionCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingInitCS <em>Mapping Init CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingInitCS
	 * @generated
	 */
	public Adapter createMappingInitCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingEndCS <em>Mapping End CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingEndCS
	 * @generated
	 */
	public Adapter createMappingEndCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS <em>Mapping Sections CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS
	 * @generated
	 */
	public Adapter createMappingSectionsCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.StatementCS <em>Statement CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.StatementCS
	 * @generated
	 */
	public Adapter createStatementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS <em>Assign Statement CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS
	 * @generated
	 */
	public Adapter createAssignStatementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ExpressionStatementCS <em>Expression Statement CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ExpressionStatementCS
	 * @generated
	 */
	public Adapter createExpressionStatementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS <em>Variable Initialization CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS
	 * @generated
	 */
	public Adapter createVariableInitializationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS <em>Mapping Body CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS
	 * @generated
	 */
	public Adapter createMappingBodyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.OutExpCS <em>Out Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.OutExpCS
	 * @generated
	 */
	public Adapter createOutExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingCallExpCS <em>Mapping Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingCallExpCS
	 * @generated
	 */
	public Adapter createMappingCallExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS <em>While Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS
	 * @generated
	 */
	public Adapter createWhileExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.SwitchExpCS <em>Switch Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.SwitchExpCS
	 * @generated
	 */
	public Adapter createSwitchExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS <em>Switch Alt Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS
	 * @generated
	 */
	public Adapter createSwitchAltExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS <em>Block Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS
	 * @generated
	 */
	public Adapter createBlockExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ComputeExpCS <em>Compute Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ComputeExpCS
	 * @generated
	 */
	public Adapter createComputeExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS <em>Direction Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS
	 * @generated
	 */
	public Adapter createDirectionKindCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ElementWithBody <em>Element With Body</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ElementWithBody
	 * @generated
	 */
	public Adapter createElementWithBodyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS <em>Resolve Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS
	 * @generated
	 */
	public Adapter createResolveExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ResolveInExpCS <em>Resolve In Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ResolveInExpCS
	 * @generated
	 */
	public Adapter createResolveInExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS <em>Model Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS
	 * @generated
	 */
	public Adapter createModelTypeCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.PackageRefCS <em>Package Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.PackageRefCS
	 * @generated
	 */
	public Adapter createPackageRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS <em>Transformation Header CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS
	 * @generated
	 */
	public Adapter createTransformationHeaderCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindCS <em>Module Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindCS
	 * @generated
	 */
	public Adapter createModuleKindCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS <em>Module Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS
	 * @generated
	 */
	public Adapter createModuleRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS <em>Module Usage CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS
	 * @generated
	 */
	public Adapter createModuleUsageCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS <em>Transformation Refine CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS
	 * @generated
	 */
	public Adapter createTransformationRefineCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS <em>Type Spec CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS
	 * @generated
	 */
	public Adapter createTypeSpecCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.LogExpCS <em>Log Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.LogExpCS
	 * @generated
	 */
	public Adapter createLogExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS <em>Assert Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS
	 * @generated
	 */
	public Adapter createAssertExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ImperativeLoopExpCS <em>Imperative Loop Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ImperativeLoopExpCS
	 * @generated
	 */
	public Adapter createImperativeLoopExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ForExpCS <em>For Exp CS</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ForExpCS
	 * @generated
	 */
    public Adapter createForExpCSAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ImperativeIterateExpCS <em>Imperative Iterate Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ImperativeIterateExpCS
	 * @generated
	 */
	public Adapter createImperativeIterateExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ReturnExpCS <em>Return Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ReturnExpCS
	 * @generated
	 */
	public Adapter createReturnExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS <em>Mapping Extension CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS
	 * @generated
	 */
	public Adapter createMappingExtensionCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.NewRuleCallExpCS <em>New Rule Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.NewRuleCallExpCS
	 * @generated
	 */
	public Adapter createNewRuleCallExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.ListTypeCS <em>List Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.ListTypeCS
	 * @generated
	 */
	public Adapter createListTypeCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.DictionaryTypeCS <em>Dictionary Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.DictionaryTypeCS
	 * @generated
	 */
	public Adapter createDictionaryTypeCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralExpCS <em>Dict Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralExpCS
	 * @generated
	 */
	public Adapter createDictLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralPartCS <em>Dict Literal Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralPartCS
	 * @generated
	 */
	public Adapter createDictLiteralPartCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.internal.qvt.oml.cst.TagCS <em>Tag CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.TagCS
	 * @generated
	 */
	public Adapter createTagCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.CSTNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.cst.CSTNode
	 * @generated
	 */
	public Adapter createCSTNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.OCLExpressionCS <em>OCL Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.cst.OCLExpressionCS
	 * @generated
	 */
	public Adapter createOCLExpressionCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.CallExpCS <em>Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.cst.CallExpCS
	 * @generated
	 */
	public Adapter createCallExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.FeatureCallExpCS <em>Feature Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.cst.FeatureCallExpCS
	 * @generated
	 */
	public Adapter createFeatureCallExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.OperationCallExpCS <em>Operation Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.cst.OperationCallExpCS
	 * @generated
	 */
	public Adapter createOperationCallExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.LoopExpCS <em>Loop Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.cst.LoopExpCS
	 * @generated
	 */
	public Adapter createLoopExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.TypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.cst.TypeCS
	 * @generated
	 */
	public Adapter createTypeCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.LiteralExpCS <em>Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.cst.LiteralExpCS
	 * @generated
	 */
	public Adapter createLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CSTAdapterFactory
