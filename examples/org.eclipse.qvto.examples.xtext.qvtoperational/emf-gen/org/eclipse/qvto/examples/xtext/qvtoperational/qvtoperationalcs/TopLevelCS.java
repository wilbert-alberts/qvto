/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Top Level CS</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS#getImport <em>Import</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getTopLevelCS()
 * @model
 * @generated
 */
public interface TopLevelCS
		extends RootPackageCS {

	/**
	 * Returns the value of the '<em><b>Import</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Import</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getTopLevelCS_Import()
	 * @model containment="true"
	 * @generated
	 */
	EList<ElementCS> getImport();

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getTopLevelCS_Unit()
	 * @model containment="true"
	 * @generated
	 */
	EList<ElementCS> getUnit();

} // TopLevelCS
