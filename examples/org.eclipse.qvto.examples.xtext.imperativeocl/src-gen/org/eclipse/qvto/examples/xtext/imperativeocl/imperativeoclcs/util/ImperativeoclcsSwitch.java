/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.ocl.examples.pivot.util.Pivotable;

import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PivotableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;

import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;

import org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage
 * @generated
 */
public class ImperativeoclcsSwitch<T> extends Switch<T>
{
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static ImperativeoclcsPackage modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ImperativeoclcsSwitch()
  {
		if (modelPackage == null) {
			modelPackage = ImperativeoclcsPackage.eINSTANCE;
		}
	}

  /**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
		return ePackage == modelPackage;
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
		switch (classifierID) {
			case ImperativeoclcsPackage.LIST_TYPE_CS: {
				ListTypeCS listTypeCS = (ListTypeCS)theEObject;
				T result = caseListTypeCS(listTypeCS);
				if (result == null) result = caseTypedRefCS(listTypeCS);
				if (result == null) result = caseTypeRefCS(listTypeCS);
				if (result == null) result = caseElementRefCS(listTypeCS);
				if (result == null) result = casePivotableElementCS(listTypeCS);
				if (result == null) result = caseElementCS(listTypeCS);
				if (result == null) result = casePivotable(listTypeCS);
				if (result == null) result = caseVisitableCS(listTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclcsPackage.DICT_TYPE_CS: {
				DictTypeCS dictTypeCS = (DictTypeCS)theEObject;
				T result = caseDictTypeCS(dictTypeCS);
				if (result == null) result = caseTypedRefCS(dictTypeCS);
				if (result == null) result = caseTypeRefCS(dictTypeCS);
				if (result == null) result = caseElementRefCS(dictTypeCS);
				if (result == null) result = casePivotableElementCS(dictTypeCS);
				if (result == null) result = caseElementCS(dictTypeCS);
				if (result == null) result = casePivotable(dictTypeCS);
				if (result == null) result = caseVisitableCS(dictTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclcsPackage.LIST_LITERAL_EXP_CS: {
				ListLiteralExpCS listLiteralExpCS = (ListLiteralExpCS)theEObject;
				T result = caseListLiteralExpCS(listLiteralExpCS);
				if (result == null) result = caseExpCS(listLiteralExpCS);
				if (result == null) result = caseModelElementCS(listLiteralExpCS);
				if (result == null) result = casePivotableElementCS(listLiteralExpCS);
				if (result == null) result = caseElementCS(listLiteralExpCS);
				if (result == null) result = casePivotable(listLiteralExpCS);
				if (result == null) result = caseVisitableCS(listLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclcsPackage.DICT_LITERAL_EXP_CS: {
				DictLiteralExpCS dictLiteralExpCS = (DictLiteralExpCS)theEObject;
				T result = caseDictLiteralExpCS(dictLiteralExpCS);
				if (result == null) result = caseExpCS(dictLiteralExpCS);
				if (result == null) result = caseModelElementCS(dictLiteralExpCS);
				if (result == null) result = casePivotableElementCS(dictLiteralExpCS);
				if (result == null) result = caseElementCS(dictLiteralExpCS);
				if (result == null) result = casePivotable(dictLiteralExpCS);
				if (result == null) result = caseVisitableCS(dictLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclcsPackage.DICT_LITERAL_PART_CS: {
				DictLiteralPartCS dictLiteralPartCS = (DictLiteralPartCS)theEObject;
				T result = caseDictLiteralPartCS(dictLiteralPartCS);
				if (result == null) result = caseElementCS(dictLiteralPartCS);
				if (result == null) result = caseVisitableCS(dictLiteralPartCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclcsPackage.RETURN_EXP_CS: {
				ReturnExpCS returnExpCS = (ReturnExpCS)theEObject;
				T result = caseReturnExpCS(returnExpCS);
				if (result == null) result = caseExpCS(returnExpCS);
				if (result == null) result = caseModelElementCS(returnExpCS);
				if (result == null) result = casePivotableElementCS(returnExpCS);
				if (result == null) result = caseElementCS(returnExpCS);
				if (result == null) result = casePivotable(returnExpCS);
				if (result == null) result = caseVisitableCS(returnExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclcsPackage.NAME_EXP_CS: {
				NameExpCS nameExpCS = (NameExpCS)theEObject;
				T result = caseNameExpCS(nameExpCS);
				if (result == null) result = caseExpCS(nameExpCS);
				if (result == null) result = caseModelElementCS(nameExpCS);
				if (result == null) result = casePivotableElementCS(nameExpCS);
				if (result == null) result = caseElementCS(nameExpCS);
				if (result == null) result = casePivotable(nameExpCS);
				if (result == null) result = caseVisitableCS(nameExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclcsPackage.INDEX_EXP_CS: {
				IndexExpCS indexExpCS = (IndexExpCS)theEObject;
				T result = caseIndexExpCS(indexExpCS);
				if (result == null) result = caseExpCS(indexExpCS);
				if (result == null) result = caseModelElementCS(indexExpCS);
				if (result == null) result = casePivotableElementCS(indexExpCS);
				if (result == null) result = caseElementCS(indexExpCS);
				if (result == null) result = casePivotable(indexExpCS);
				if (result == null) result = caseVisitableCS(indexExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS: {
				ConstructorExpCS constructorExpCS = (ConstructorExpCS)theEObject;
				T result = caseConstructorExpCS(constructorExpCS);
				if (result == null) result = caseExpCS(constructorExpCS);
				if (result == null) result = caseModelElementCS(constructorExpCS);
				if (result == null) result = casePivotableElementCS(constructorExpCS);
				if (result == null) result = caseElementCS(constructorExpCS);
				if (result == null) result = casePivotable(constructorExpCS);
				if (result == null) result = caseVisitableCS(constructorExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclcsPackage.INVOCATION_EXP_CS: {
				InvocationExpCS invocationExpCS = (InvocationExpCS)theEObject;
				T result = caseInvocationExpCS(invocationExpCS);
				if (result == null) result = caseExpCS(invocationExpCS);
				if (result == null) result = caseModelElementCS(invocationExpCS);
				if (result == null) result = casePivotableElementCS(invocationExpCS);
				if (result == null) result = caseElementCS(invocationExpCS);
				if (result == null) result = casePivotable(invocationExpCS);
				if (result == null) result = caseVisitableCS(invocationExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImperativeoclcsPackage.IMPERATIVE_OCLCS_VISITOR: {
				ImperativeOCLCSVisitor<?> imperativeOCLCSVisitor = (ImperativeOCLCSVisitor<?>)theEObject;
				T result = caseImperativeOCLCSVisitor(imperativeOCLCSVisitor);
				if (result == null) result = caseEssentialOCLCSVisitor(imperativeOCLCSVisitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>List Type CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseListTypeCS(ListTypeCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Dict Type CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dict Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDictTypeCS(DictTypeCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>List Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseListLiteralExpCS(ListLiteralExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Dict Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dict Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDictLiteralExpCS(DictLiteralExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Dict Literal Part CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dict Literal Part CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDictLiteralPartCS(DictLiteralPartCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Return Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseReturnExpCS(ReturnExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Name Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseNameExpCS(NameExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Index Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIndexExpCS(IndexExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Constructor Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constructor Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseConstructorExpCS(ConstructorExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Invocation Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invocation Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseInvocationExpCS(InvocationExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative OCLCS Visitor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative OCLCS Visitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R> T caseImperativeOCLCSVisitor(ImperativeOCLCSVisitor<R> object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseVisitableCS(VisitableCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseElementCS(ElementCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Pivotable</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pivotable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePivotable(Pivotable object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Pivotable Element CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pivotable Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePivotableElementCS(PivotableElementCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Element Ref CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseElementRefCS(ElementRefCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseTypeRefCS(TypeRefCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Ref CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseTypedRefCS(TypedRefCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseModelElementCS(ModelElementCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseExpCS(ExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Essential OCLCS Visitor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Essential OCLCS Visitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R> T caseEssentialOCLCSVisitor(EssentialOCLCSVisitor<R> object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
  @Override
  public T defaultCase(EObject object)
  {
		return null;
	}

} //ImperativeoclcsSwitch
