/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimpleumlAdapterFactory.java,v 1.1 2007/07/29 21:25:31 radvorak Exp $
 */
package simpleuml.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import simpleuml.Association;
import simpleuml.Classifier;
import simpleuml.DataType;
import simpleuml.Enumeration;
import simpleuml.EnumerationLiteral;
import simpleuml.Generalization;
import simpleuml.Model;
import simpleuml.ModelElement;
import simpleuml.Packageable;
import simpleuml.PrimitiveType;
import simpleuml.Property;
import simpleuml.SimpleumlPackage;
import simpleuml.TaggedValue;
import simpleuml.Type;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see simpleuml.SimpleumlPackage
 * @generated
 */
public class SimpleumlAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static SimpleumlPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SimpleumlAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = SimpleumlPackage.eINSTANCE;
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
	protected SimpleumlSwitch modelSwitch =
        new SimpleumlSwitch() {
            public Object caseModel(Model object) {
                return createModelAdapter();
            }
            public Object casePackage(simpleuml.Package object) {
                return createPackageAdapter();
            }
            public Object caseClass(simpleuml.Class object) {
                return createClassAdapter();
            }
            public Object caseProperty(Property object) {
                return createPropertyAdapter();
            }
            public Object caseAssociation(Association object) {
                return createAssociationAdapter();
            }
            public Object casePrimitiveType(PrimitiveType object) {
                return createPrimitiveTypeAdapter();
            }
            public Object caseDataType(DataType object) {
                return createDataTypeAdapter();
            }
            public Object caseEnumeration(Enumeration object) {
                return createEnumerationAdapter();
            }
            public Object caseEnumerationLiteral(EnumerationLiteral object) {
                return createEnumerationLiteralAdapter();
            }
            public Object caseClassifier(Classifier object) {
                return createClassifierAdapter();
            }
            public Object caseModelElement(ModelElement object) {
                return createModelElementAdapter();
            }
            public Object caseGeneralization(Generalization object) {
                return createGeneralizationAdapter();
            }
            public Object caseTaggedValue(TaggedValue object) {
                return createTaggedValueAdapter();
            }
            public Object caseType(Type object) {
                return createTypeAdapter();
            }
            public Object casePackageable(Packageable object) {
                return createPackageableAdapter();
            }
            public Object defaultCase(EObject object) {
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
	public Adapter createAdapter(Notifier target) {
        return (Adapter)modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link simpleuml.Model <em>Model</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see simpleuml.Model
     * @generated
     */
	public Adapter createModelAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link simpleuml.Package <em>Package</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see simpleuml.Package
     * @generated
     */
	public Adapter createPackageAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link simpleuml.Class <em>Class</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see simpleuml.Class
     * @generated
     */
	public Adapter createClassAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link simpleuml.Property <em>Property</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see simpleuml.Property
     * @generated
     */
	public Adapter createPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link simpleuml.Association <em>Association</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see simpleuml.Association
     * @generated
     */
	public Adapter createAssociationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link simpleuml.PrimitiveType <em>Primitive Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see simpleuml.PrimitiveType
     * @generated
     */
	public Adapter createPrimitiveTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link simpleuml.DataType <em>Data Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see simpleuml.DataType
     * @generated
     */
	public Adapter createDataTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link simpleuml.Enumeration <em>Enumeration</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see simpleuml.Enumeration
     * @generated
     */
	public Adapter createEnumerationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link simpleuml.EnumerationLiteral <em>Enumeration Literal</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see simpleuml.EnumerationLiteral
     * @generated
     */
	public Adapter createEnumerationLiteralAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link simpleuml.Classifier <em>Classifier</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see simpleuml.Classifier
     * @generated
     */
	public Adapter createClassifierAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link simpleuml.ModelElement <em>Model Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see simpleuml.ModelElement
     * @generated
     */
	public Adapter createModelElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link simpleuml.Generalization <em>Generalization</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see simpleuml.Generalization
     * @generated
     */
	public Adapter createGeneralizationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link simpleuml.TaggedValue <em>Tagged Value</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see simpleuml.TaggedValue
     * @generated
     */
	public Adapter createTaggedValueAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link simpleuml.Type <em>Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see simpleuml.Type
     * @generated
     */
	public Adapter createTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link simpleuml.Packageable <em>Packageable</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see simpleuml.Packageable
     * @generated
     */
	public Adapter createPackageableAdapter() {
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

} //SimpleumlAdapterFactory
