/**
 * <copyright>
 * </copyright>
 *
 * $Id: ColumnRefConstraint.java,v 1.1 2007/07/29 21:25:27 radvorak Exp $
 */
package rdb.constraints;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column Ref Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rdb.constraints.ColumnRefConstraint#getIncludedColumns <em>Included Columns</em>}</li>
 * </ul>
 * </p>
 *
 * @see rdb.constraints.ConstraintsPackage#getColumnRefConstraint()
 * @model abstract="true"
 * @generated
 */
public interface ColumnRefConstraint extends Constraint{
	/**
	 * Returns the value of the '<em><b>Included Columns</b></em>' reference list.
	 * The list contents are of type {@link rdb.TableColumn}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Included Columns</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Included Columns</em>' reference list.
	 * @see rdb.constraints.ConstraintsPackage#getColumnRefConstraint_IncludedColumns()
	 * @model type="rdb.TableColumn" required="true"
	 * @generated
	 */
    EList getIncludedColumns();

} // ColumnRefConstraint
