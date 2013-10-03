/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Module Usage CS</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS#getImportKind <em>Import Kind</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS#getModuleKindCS <em>Module Kind CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS#getModuleRefs <em>Module Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getModuleUsageCS()
 * @model
 * @generated
 */
public interface ModuleUsageCS
		extends ElementCS {

	/**
	 * Returns the value of the '<em><b>Import Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportKindEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Kind</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Kind</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportKindEnum
	 * @see #setImportKind(ImportKindEnum)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getModuleUsageCS_ImportKind()
	 * @model
	 * @generated
	 */
	ImportKindEnum getImportKind();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS#getImportKind <em>Import Kind</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Import Kind</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportKindEnum
	 * @see #getImportKind()
	 * @generated
	 */
	void setImportKind(ImportKindEnum value);

	/**
	 * Returns the value of the '<em><b>Module Kind CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module Kind CS</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module Kind CS</em>' containment reference.
	 * @see #setModuleKindCS(ModuleKindCS)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getModuleUsageCS_ModuleKindCS()
	 * @model containment="true"
	 * @generated
	 */
	ModuleKindCS getModuleKindCS();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS#getModuleKindCS <em>Module Kind CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module Kind CS</em>' containment reference.
	 * @see #getModuleKindCS()
	 * @generated
	 */
	void setModuleKindCS(ModuleKindCS value);

	/**
	 * Returns the value of the '<em><b>Module Refs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleRefCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module Refs</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module Refs</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getModuleUsageCS_ModuleRefs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ModuleRefCS> getModuleRefs();

} // ModuleUsageCS
