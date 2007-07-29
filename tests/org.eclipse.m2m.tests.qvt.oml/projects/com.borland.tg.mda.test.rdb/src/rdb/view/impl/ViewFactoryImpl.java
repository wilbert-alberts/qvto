/**
 * <copyright>
 * </copyright>
 *
 * $Id: ViewFactoryImpl.java,v 1.1 2007/07/29 21:25:32 radvorak Exp $
 */
package rdb.view.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import rdb.view.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ViewFactoryImpl extends EFactoryImpl implements ViewFactory {
	/**
	 * Creates and instance of the factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ViewFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ViewPackage.VIEW: return createView();
			case ViewPackage.VIEW_ALIAS: return createViewAlias();
			case ViewPackage.VIEW_EXPRESSION_COLUMN: return createViewExpressionColumn();
			case ViewPackage.REFERENCED_VIEW_COLUMN: return createReferencedViewColumn();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public View createView() {
		ViewImpl view = new ViewImpl();
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ViewAlias createViewAlias() {
		ViewAliasImpl viewAlias = new ViewAliasImpl();
		return viewAlias;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ViewExpressionColumn createViewExpressionColumn() {
		ViewExpressionColumnImpl viewExpressionColumn = new ViewExpressionColumnImpl();
		return viewExpressionColumn;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ReferencedViewColumn createReferencedViewColumn() {
		ReferencedViewColumnImpl referencedViewColumn = new ReferencedViewColumnImpl();
		return referencedViewColumn;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ViewPackage getViewPackage() {
		return (ViewPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
    public static ViewPackage getPackage() {
		return ViewPackage.eINSTANCE;
	}

} //ViewFactoryImpl
