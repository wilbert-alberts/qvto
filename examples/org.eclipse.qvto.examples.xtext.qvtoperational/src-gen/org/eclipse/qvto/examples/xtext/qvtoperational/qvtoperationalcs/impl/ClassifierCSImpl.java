/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;

import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierFeatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierKind;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.Qualifier;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierCSImpl#isIntermediate <em>Intermediate</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierCSImpl#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierCSImpl#getKeyword <em>Keyword</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierCSImpl#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierCSImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierCSImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassifierCSImpl extends MetamodelElementCSImpl implements ClassifierCS
{
  /**
	 * The default value of the '{@link #isIntermediate() <em>Intermediate</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isIntermediate()
	 * @generated
	 * @ordered
	 */
  protected static final boolean INTERMEDIATE_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isIntermediate() <em>Intermediate</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isIntermediate()
	 * @generated
	 * @ordered
	 */
  protected boolean intermediate = INTERMEDIATE_EDEFAULT;

  /**
	 * The cached value of the '{@link #getQualifier() <em>Qualifier</em>}' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getQualifier()
	 * @generated
	 * @ordered
	 */
  protected EList<Qualifier> qualifier;

  /**
	 * The default value of the '{@link #getKeyword() <em>Keyword</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getKeyword()
	 * @generated
	 * @ordered
	 */
  protected static final ClassifierKind KEYWORD_EDEFAULT = ClassifierKind.DATATYPE;

  /**
	 * The cached value of the '{@link #getKeyword() <em>Keyword</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getKeyword()
	 * @generated
	 * @ordered
	 */
  protected ClassifierKind keyword = KEYWORD_EDEFAULT;

  /**
	 * The cached value of the '{@link #getPathName() <em>Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPathName()
	 * @generated
	 * @ordered
	 */
  protected PathNameCS pathName;

  /**
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
  protected EList<PathNameCS> extends_;

  /**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
  protected EList<ClassifierFeatureCS> feature;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ClassifierCSImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass()
  {
		return QvtoperationalcsPackage.Literals.CLASSIFIER_CS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isIntermediate()
  {
		return intermediate;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setIntermediate(boolean newIntermediate)
  {
		boolean oldIntermediate = intermediate;
		intermediate = newIntermediate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_CS__INTERMEDIATE, oldIntermediate, intermediate));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Qualifier> getQualifier()
  {
		if (qualifier == null) {
			qualifier = new EDataTypeEList<Qualifier>(Qualifier.class, this, QvtoperationalcsPackage.CLASSIFIER_CS__QUALIFIER);
		}
		return qualifier;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ClassifierKind getKeyword()
  {
		return keyword;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setKeyword(ClassifierKind newKeyword)
  {
		ClassifierKind oldKeyword = keyword;
		keyword = newKeyword == null ? KEYWORD_EDEFAULT : newKeyword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_CS__KEYWORD, oldKeyword, keyword));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PathNameCS getPathName()
  {
		return pathName;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetPathName(PathNameCS newPathName, NotificationChain msgs)
  {
		PathNameCS oldPathName = pathName;
		pathName = newPathName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_CS__PATH_NAME, oldPathName, newPathName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setPathName(PathNameCS newPathName)
  {
		if (newPathName != pathName) {
			NotificationChain msgs = null;
			if (pathName != null)
				msgs = ((InternalEObject)pathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.CLASSIFIER_CS__PATH_NAME, null, msgs);
			if (newPathName != null)
				msgs = ((InternalEObject)newPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.CLASSIFIER_CS__PATH_NAME, null, msgs);
			msgs = basicSetPathName(newPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_CS__PATH_NAME, newPathName, newPathName));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<PathNameCS> getExtends()
  {
		if (extends_ == null) {
			extends_ = new EObjectContainmentEList<PathNameCS>(PathNameCS.class, this, QvtoperationalcsPackage.CLASSIFIER_CS__EXTENDS);
		}
		return extends_;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<ClassifierFeatureCS> getFeature()
  {
		if (feature == null) {
			feature = new EObjectContainmentEList<ClassifierFeatureCS>(ClassifierFeatureCS.class, this, QvtoperationalcsPackage.CLASSIFIER_CS__FEATURE);
		}
		return feature;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R> R accept(final QVTOperationalCSVisitor<R> v) {
		return v.visitClassifierCS(this);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R> R accept(final BaseCSVisitor<R> v) {
		return ((QVTOperationalCSVisitor<R>)v).visitClassifierCS(this);
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case QvtoperationalcsPackage.CLASSIFIER_CS__PATH_NAME:
				return basicSetPathName(null, msgs);
			case QvtoperationalcsPackage.CLASSIFIER_CS__EXTENDS:
				return ((InternalEList<?>)getExtends()).basicRemove(otherEnd, msgs);
			case QvtoperationalcsPackage.CLASSIFIER_CS__FEATURE:
				return ((InternalEList<?>)getFeature()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case QvtoperationalcsPackage.CLASSIFIER_CS__INTERMEDIATE:
				return isIntermediate();
			case QvtoperationalcsPackage.CLASSIFIER_CS__QUALIFIER:
				return getQualifier();
			case QvtoperationalcsPackage.CLASSIFIER_CS__KEYWORD:
				return getKeyword();
			case QvtoperationalcsPackage.CLASSIFIER_CS__PATH_NAME:
				return getPathName();
			case QvtoperationalcsPackage.CLASSIFIER_CS__EXTENDS:
				return getExtends();
			case QvtoperationalcsPackage.CLASSIFIER_CS__FEATURE:
				return getFeature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case QvtoperationalcsPackage.CLASSIFIER_CS__INTERMEDIATE:
				setIntermediate((Boolean)newValue);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_CS__QUALIFIER:
				getQualifier().clear();
				getQualifier().addAll((Collection<? extends Qualifier>)newValue);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_CS__KEYWORD:
				setKeyword((ClassifierKind)newValue);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_CS__PATH_NAME:
				setPathName((PathNameCS)newValue);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_CS__EXTENDS:
				getExtends().clear();
				getExtends().addAll((Collection<? extends PathNameCS>)newValue);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_CS__FEATURE:
				getFeature().clear();
				getFeature().addAll((Collection<? extends ClassifierFeatureCS>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eUnset(int featureID)
  {
		switch (featureID) {
			case QvtoperationalcsPackage.CLASSIFIER_CS__INTERMEDIATE:
				setIntermediate(INTERMEDIATE_EDEFAULT);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_CS__QUALIFIER:
				getQualifier().clear();
				return;
			case QvtoperationalcsPackage.CLASSIFIER_CS__KEYWORD:
				setKeyword(KEYWORD_EDEFAULT);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_CS__PATH_NAME:
				setPathName((PathNameCS)null);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_CS__EXTENDS:
				getExtends().clear();
				return;
			case QvtoperationalcsPackage.CLASSIFIER_CS__FEATURE:
				getFeature().clear();
				return;
		}
		super.eUnset(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public boolean eIsSet(int featureID)
  {
		switch (featureID) {
			case QvtoperationalcsPackage.CLASSIFIER_CS__INTERMEDIATE:
				return intermediate != INTERMEDIATE_EDEFAULT;
			case QvtoperationalcsPackage.CLASSIFIER_CS__QUALIFIER:
				return qualifier != null && !qualifier.isEmpty();
			case QvtoperationalcsPackage.CLASSIFIER_CS__KEYWORD:
				return keyword != KEYWORD_EDEFAULT;
			case QvtoperationalcsPackage.CLASSIFIER_CS__PATH_NAME:
				return pathName != null;
			case QvtoperationalcsPackage.CLASSIFIER_CS__EXTENDS:
				return extends_ != null && !extends_.isEmpty();
			case QvtoperationalcsPackage.CLASSIFIER_CS__FEATURE:
				return feature != null && !feature.isEmpty();
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString()
  {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (intermediate: ");
		result.append(intermediate);
		result.append(", qualifier: ");
		result.append(qualifier);
		result.append(", keyword: ");
		result.append(keyword);
		result.append(')');
		return result.toString();
	}

} //ClassifierCSImpl
