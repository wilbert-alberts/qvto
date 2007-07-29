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
package org.eclipse.m2m.qvt.oml.internal.cst.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.m2m.qvt.oml.internal.cst.*;

import org.eclipse.ocl.internal.cst.CSTNode;
import org.eclipse.ocl.internal.cst.CallExpCS;
import org.eclipse.ocl.internal.cst.FeatureCallExpCS;
import org.eclipse.ocl.internal.cst.OCLExpressionCS;
import org.eclipse.ocl.internal.cst.OperationCallExpCS;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage
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
	 * The switch the delegates to the <code>createXXX</code> methods.
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
			public Adapter caseMappingDeclarationCS(MappingDeclarationCS object) {
				return createMappingDeclarationCSAdapter();
			}
			@Override
			public Adapter caseParameterDeclarationCS(ParameterDeclarationCS object) {
				return createParameterDeclarationCSAdapter();
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
			public Adapter casePatternPropertyExpCS(PatternPropertyExpCS object) {
				return createPatternPropertyExpCSAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS <em>Mapping Module CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS
	 * @generated
	 */
	public Adapter createMappingModuleCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.LibraryCS <em>Library CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.LibraryCS
	 * @generated
	 */
	public Adapter createLibraryCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ImportCS <em>Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.ImportCS
	 * @generated
	 */
	public Adapter createImportCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModuleImportCS <em>Module Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.ModuleImportCS
	 * @generated
	 */
	public Adapter createModuleImportCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.LibraryImportCS <em>Library Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.LibraryImportCS
	 * @generated
	 */
	public Adapter createLibraryImportCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.RenameCS <em>Rename CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.RenameCS
	 * @generated
	 */
	public Adapter createRenameCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModulePropertyCS <em>Module Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.ModulePropertyCS
	 * @generated
	 */
	public Adapter createModulePropertyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ConfigPropertyCS <em>Config Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.ConfigPropertyCS
	 * @generated
	 */
	public Adapter createConfigPropertyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.LocalPropertyCS <em>Local Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.LocalPropertyCS
	 * @generated
	 */
	public Adapter createLocalPropertyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS <em>Mapping Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS
	 * @generated
	 */
	public Adapter createMappingDeclarationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ParameterDeclarationCS <em>Parameter Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.ParameterDeclarationCS
	 * @generated
	 */
	public Adapter createParameterDeclarationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingMethodCS <em>Mapping Method CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingMethodCS
	 * @generated
	 */
	public Adapter createMappingMethodCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingRuleCS <em>Mapping Rule CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingRuleCS
	 * @generated
	 */
	public Adapter createMappingRuleCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingQueryCS <em>Mapping Query CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingQueryCS
	 * @generated
	 */
	public Adapter createMappingQueryCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingSectionCS <em>Mapping Section CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingSectionCS
	 * @generated
	 */
	public Adapter createMappingSectionCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingInitCS <em>Mapping Init CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingInitCS
	 * @generated
	 */
	public Adapter createMappingInitCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingEndCS <em>Mapping End CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingEndCS
	 * @generated
	 */
	public Adapter createMappingEndCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.StatementCS <em>Statement CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.StatementCS
	 * @generated
	 */
	public Adapter createStatementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.AssignStatementCS <em>Assign Statement CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.AssignStatementCS
	 * @generated
	 */
	public Adapter createAssignStatementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ExpressionStatementCS <em>Expression Statement CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.ExpressionStatementCS
	 * @generated
	 */
	public Adapter createExpressionStatementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.VariableInitializationCS <em>Variable Initialization CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.VariableInitializationCS
	 * @generated
	 */
	public Adapter createVariableInitializationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS <em>Mapping Body CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS
	 * @generated
	 */
	public Adapter createMappingBodyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.OutExpCS <em>Out Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.OutExpCS
	 * @generated
	 */
	public Adapter createOutExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS <em>Pattern Property Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS
	 * @generated
	 */
	public Adapter createPatternPropertyExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingCallExpCS <em>Mapping Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.MappingCallExpCS
	 * @generated
	 */
	public Adapter createMappingCallExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.WhileExpCS <em>While Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.WhileExpCS
	 * @generated
	 */
	public Adapter createWhileExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindCS <em>Direction Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindCS
	 * @generated
	 */
	public Adapter createDirectionKindCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ElementWithBody <em>Element With Body</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.ElementWithBody
	 * @generated
	 */
	public Adapter createElementWithBodyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ResolveExpCS <em>Resolve Exp CS</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.ResolveExpCS
	 * @generated
	 */
    public Adapter createResolveExpCSAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ResolveInExpCS <em>Resolve In Exp CS</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.ResolveInExpCS
	 * @generated
	 */
    public Adapter createResolveInExpCSAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS <em>Model Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS
	 * @generated
	 */
	public Adapter createModelTypeCSAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.PackageRefCS <em>Package Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.PackageRefCS
	 * @generated
	 */
	public Adapter createPackageRefCSAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS <em>Transformation Header CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.TransformationHeaderCS
	 * @generated
	 */
	public Adapter createTransformationHeaderCSAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModuleKindCS <em>Module Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.ModuleKindCS
	 * @generated
	 */
	public Adapter createModuleKindCSAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModuleRefCS <em>Module Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.ModuleRefCS
	 * @generated
	 */
	public Adapter createModuleRefCSAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.ModuleUsageCS <em>Module Usage CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.ModuleUsageCS
	 * @generated
	 */
	public Adapter createModuleUsageCSAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.TransformationRefineCS <em>Transformation Refine CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.TransformationRefineCS
	 * @generated
	 */
	public Adapter createTransformationRefineCSAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.m2m.qvt.oml.internal.cst.TypeSpecCS <em>Type Spec CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.TypeSpecCS
	 * @generated
	 */
	public Adapter createTypeSpecCSAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.internal.cst.CSTNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.internal.cst.CSTNode
	 * @generated
	 */
	public Adapter createCSTNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.internal.cst.OCLExpressionCS <em>OCL Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.internal.cst.OCLExpressionCS
	 * @generated
	 */
	public Adapter createOCLExpressionCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.internal.cst.CallExpCS <em>Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.internal.cst.CallExpCS
	 * @generated
	 */
	public Adapter createCallExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.internal.cst.FeatureCallExpCS <em>Feature Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.internal.cst.FeatureCallExpCS
	 * @generated
	 */
	public Adapter createFeatureCallExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.internal.cst.OperationCallExpCS <em>Operation Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.internal.cst.OperationCallExpCS
	 * @generated
	 */
	public Adapter createOperationCallExpCSAdapter() {
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
