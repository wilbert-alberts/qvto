/**
 * <copyright>
 * </copyright>
 *
 * $Id: ViewImpl.java,v 1.1 2007/07/29 21:25:32 radvorak Exp $
 */
package rdb.view.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import rdb.Element;

import rdb.impl.NamedColumnSetImpl;

import rdb.view.View;
import rdb.view.ViewAlias;
import rdb.view.ViewColumn;
import rdb.view.ViewPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.view.impl.ViewImpl#getColumns <em>Columns</em>}</li>
 *   <li>{@link rdb.view.impl.ViewImpl#getReferencedTablesAndViews <em>Referenced Tables And Views</em>}</li>
 *   <li>{@link rdb.view.impl.ViewImpl#getDdl <em>Ddl</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewImpl extends NamedColumnSetImpl implements View {
	/**
	 * The cached value of the '{@link #getColumns() <em>Columns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getColumns()
	 * @generated
	 * @ordered
	 */
    protected EList columns = null;

	/**
	 * The cached value of the '{@link #getReferencedTablesAndViews() <em>Referenced Tables And Views</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getReferencedTablesAndViews()
	 * @generated
	 * @ordered
	 */
    protected EList referencedTablesAndViews = null;

	/**
	 * The default value of the '{@link #getDdl() <em>Ddl</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDdl()
	 * @generated
	 * @ordered
	 */
    protected static final String DDL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDdl() <em>Ddl</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDdl()
	 * @generated
	 * @ordered
	 */
    protected String ddl = DDL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return ViewPackage.eINSTANCE.getView();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList getColumns() {
		if (columns == null) {
			columns = new EObjectContainmentEList(ViewColumn.class, this, ViewPackage.VIEW__COLUMNS);
		}
		return columns;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList getReferencedTablesAndViews() {
		if (referencedTablesAndViews == null) {
			referencedTablesAndViews = new EObjectContainmentEList(ViewAlias.class, this, ViewPackage.VIEW__REFERENCED_TABLES_AND_VIEWS);
		}
		return referencedTablesAndViews;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getDdl() {
		return ddl;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setDdl(String newDdl) {
		String oldDdl = ddl;
		ddl = newDdl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.VIEW__DDL, oldDdl, ddl));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ViewPackage.VIEW__COLUMNS:
					return ((InternalEList)getColumns()).basicRemove(otherEnd, msgs);
				case ViewPackage.VIEW__REFERENCED_TABLES_AND_VIEWS:
					return ((InternalEList)getReferencedTablesAndViews()).basicRemove(otherEnd, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ViewPackage.VIEW__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case ViewPackage.VIEW__NAME:
				return getName();
			case ViewPackage.VIEW__OWNER:
				return getOwner();
			case ViewPackage.VIEW__COLUMNS:
				return getColumns();
			case ViewPackage.VIEW__REFERENCED_TABLES_AND_VIEWS:
				return getReferencedTablesAndViews();
			case ViewPackage.VIEW__DDL:
				return getDdl();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ViewPackage.VIEW__PARENT:
				setParent((Element)newValue);
				return;
			case ViewPackage.VIEW__NAME:
				setName((String)newValue);
				return;
			case ViewPackage.VIEW__OWNER:
				setOwner((String)newValue);
				return;
			case ViewPackage.VIEW__COLUMNS:
				getColumns().clear();
				getColumns().addAll((Collection)newValue);
				return;
			case ViewPackage.VIEW__REFERENCED_TABLES_AND_VIEWS:
				getReferencedTablesAndViews().clear();
				getReferencedTablesAndViews().addAll((Collection)newValue);
				return;
			case ViewPackage.VIEW__DDL:
				setDdl((String)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ViewPackage.VIEW__PARENT:
				setParent((Element)null);
				return;
			case ViewPackage.VIEW__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ViewPackage.VIEW__OWNER:
				setOwner(OWNER_EDEFAULT);
				return;
			case ViewPackage.VIEW__COLUMNS:
				getColumns().clear();
				return;
			case ViewPackage.VIEW__REFERENCED_TABLES_AND_VIEWS:
				getReferencedTablesAndViews().clear();
				return;
			case ViewPackage.VIEW__DDL:
				setDdl(DDL_EDEFAULT);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ViewPackage.VIEW__PARENT:
				return parent != null;
			case ViewPackage.VIEW__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ViewPackage.VIEW__OWNER:
				return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
			case ViewPackage.VIEW__COLUMNS:
				return columns != null && !columns.isEmpty();
			case ViewPackage.VIEW__REFERENCED_TABLES_AND_VIEWS:
				return referencedTablesAndViews != null && !referencedTablesAndViews.isEmpty();
			case ViewPackage.VIEW__DDL:
				return DDL_EDEFAULT == null ? ddl != null : !DDL_EDEFAULT.equals(ddl);
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ddl: ");
		result.append(ddl);
		result.append(')');
		return result.toString();
	}

} //ViewImpl
