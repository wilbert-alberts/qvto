/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Model Type CS</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS#getIdentifierCS <em>Identifier CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS#getComplianceKindCS <em>Compliance Kind CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS#getPackageRefs <em>Package Refs</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS#getWhereStatements <em>Where Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getModelTypeCS()
 * @model
 * @generated
 */
public interface ModelTypeCS
		extends ElementCS, ElementWithBody {

	/**
	 * Returns the value of the '<em><b>Identifier CS</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier CS</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Identifier CS</em>' attribute.
	 * @see #setIdentifierCS(String)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getModelTypeCS_IdentifierCS()
	 * @model required="true"
	 * @generated
	 */
	String getIdentifierCS();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS#getIdentifierCS <em>Identifier CS</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Identifier CS</em>' attribute.
	 * @see #getIdentifierCS()
	 * @generated
	 */
	void setIdentifierCS(String value);

	/**
	 * Returns the value of the '<em><b>Compliance Kind CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compliance Kind CS</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compliance Kind CS</em>' containment reference.
	 * @see #setComplianceKindCS(StringLiteralExpCS)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getModelTypeCS_ComplianceKindCS()
	 * @model containment="true"
	 * @generated
	 */
	StringLiteralExpCS getComplianceKindCS();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS#getComplianceKindCS <em>Compliance Kind CS</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compliance Kind CS</em>' containment reference.
	 * @see #getComplianceKindCS()
	 * @generated
	 */
	void setComplianceKindCS(StringLiteralExpCS value);

	/**
	 * Returns the value of the '<em><b>Package Refs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PackageRefCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Refs</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Refs</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getModelTypeCS_PackageRefs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<PackageRefCS> getPackageRefs();

	/**
	 * Returns the value of the '<em><b>Where Statements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Where Statements</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Where Statements</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getModelTypeCS_WhereStatements()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExpCS> getWhereStatements();

} // ModelTypeCS
