/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Metamodel CS</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS#getMetamodelKind <em>Metamodel Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getMetamodelCS()
 * @model
 * @generated
 */
public interface MetamodelCS
		extends PackageCS {

	/**
	 * Returns the value of the '<em><b>Metamodel Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel Kind</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind
	 * @see #setMetamodelKind(MetamodelKind)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getMetamodelCS_MetamodelKind()
	 * @model
	 * @generated
	 */
	MetamodelKind getMetamodelKind();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS#getMetamodelKind <em>Metamodel Kind</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Metamodel Kind</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind
	 * @see #getMetamodelKind()
	 * @generated
	 */
	void setMetamodelKind(MetamodelKind value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='ocl::Package {\n\t\t\t\tname = name,\n\t\t\t\tnsPrefix = name,\t-- QVTo spec doesn\'t provide concrete syntax for nsPrefix\n\t\t\t\tnsURI = name,\t\t-- QVTo spec doesn\'t provide concrete syntax for nsURI. Build an internal protocol\n\t\t\t\townedType = ownedType.ast()\n\t\t\t\t-- type = TODO\n\t\t\t}'"
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Package ast();

} // MetamodelCS
