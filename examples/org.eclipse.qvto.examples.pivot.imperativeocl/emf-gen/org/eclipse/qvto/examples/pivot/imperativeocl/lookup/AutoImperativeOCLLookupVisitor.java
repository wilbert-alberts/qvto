/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.qvto.examples.pivot.imperativeocl.lookup;

import java.util.Iterator;
import java.util.List;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.RootPackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation;
import org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.lookup.Environment;
import org.eclipse.ocl.examples.pivot.lookup.NewPivotLookupVisitor;
import org.eclipse.qvto.examples.pivot.imperativeocl.AltExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart;
import org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType;
import org.eclipse.qvto.examples.pivot.imperativeocl.ForExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeExpression;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeLoopExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage;
import org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ListType;
import org.eclipse.qvto.examples.pivot.imperativeocl.LogExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart;
import org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType;
import org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.TryExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.Typedef;
import org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor;

public class AutoImperativeOCLLookupVisitor
	extends NewPivotLookupVisitor
	implements ImperativeOCLVisitor<Environment>
{
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/pivot/1.0/ImperativeOCL", null, ImperativeOCLPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_example_org_s_examples_s_env_ecore = IdManager.getNsURIPackageId("http://www.example.org/examples/env.ecore", null, null);
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_java_c_s_s_org_eclipse_qvto_examples_pivot_imperativeocl_lookup = IdManager.getRootPackageId("java://org.eclipse.qvto.examples.pivot.imperativeocl.lookup");
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_examples_domain_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.examples.domain.evaluation");
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_examples_domain_types = IdManager.getRootPackageId("org.eclipse.ocl.examples.domain.types");
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_AltExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("AltExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_AssertExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("AssertExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_AssignExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("AssignExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_AutoImperativeOCLLookupVisitor = PACKid_java_c_s_s_org_eclipse_qvto_examples_pivot_imperativeocl_lookup.getClassId("AutoImperativeOCLLookupVisitor", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_BlockExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("BlockExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_BreakExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("BreakExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_CatchExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("CatchExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ComputeExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("ComputeExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ContinueExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("ContinueExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_DictLiteralExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("DictLiteralExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_DictLiteralPart = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("DictLiteralPart", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_DictionaryType = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("DictionaryType", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_DomainEvaluator = PACKid_org_eclipse_ocl_examples_domain_evaluation.getClassId("DomainEvaluator", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Element = PACKid_$metamodel$.getClassId("Element", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Environment = PACKid_http_c_s_s_www_example_org_s_examples_s_env_ecore.getClassId("Environment", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ForExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("ForExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_examples_domain_types.getClassId("IdResolver", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ImperativeExpression = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("ImperativeExpression", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ImperativeIterateExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("ImperativeIterateExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ImperativeLoopExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("ImperativeLoopExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_InstantiationExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("InstantiationExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ListLiteralExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("ListLiteralExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ListType = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("ListType", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_LogExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("LogExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OCLExpression = PACKid_$metamodel$.getClassId("OCLExpression", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OrderedTupleLiteralExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("OrderedTupleLiteralExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OrderedTupleLiteralPart = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("OrderedTupleLiteralPart", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OrderedTupleType = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("OrderedTupleType", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_RaiseExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("RaiseExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ReturnExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("ReturnExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_SwitchExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("SwitchExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TryExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("TryExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Typedef = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("Typedef", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_UnlinkExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("UnlinkExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_UnpackExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("UnpackExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Variable = PACKid_$metamodel$.getClassId("Variable", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_VariableInitExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("VariableInitExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_WhileExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("WhileExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_OCLExpression = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OCLExpression);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Variable = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Variable);
    
    protected /*@Nullable*/ /*@Thrown*/ Element child;
    protected final /*@NonNull*/ /*@Thrown*/ DomainEvaluator evaluator;
    protected final /*@NonNull*/ /*@Thrown*/ IdResolver idResolver;
    
    public AutoImperativeOCLLookupVisitor(/*@NonNull*/ Environment context) {
        super(context);
        this.evaluator = context.getEvaluator();
        this.idResolver = evaluator.getIdResolver();
    }
    
    /**
     * visitAltExp(element : imperativeocl::AltExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitAltExp(final /*@NonNull*/ /*@NonInvalid*/ AltExp element) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element);
        return parentEnv;
    }
    
    /**
     * visitAssertExp(element : imperativeocl::AssertExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitAssertExp(final /*@NonNull*/ /*@NonInvalid*/ AssertExp element_0) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_0);
        return parentEnv;
    }
    
    /**
     * visitAssignExp(element : imperativeocl::AssignExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitAssignExp(final /*@NonNull*/ /*@NonInvalid*/ AssignExp element_1) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_1);
        return parentEnv;
    }
    
    /**
     * visitBlockExp(element : imperativeocl::BlockExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitBlockExp(final /*@NonNull*/ /*@NonInvalid*/ BlockExp element_2) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_2);
        return parentEnv;
    }
    
    /**
     * visitBreakExp(element : imperativeocl::BreakExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitBreakExp(final /*@NonNull*/ /*@NonInvalid*/ BreakExp element_3) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_3);
        return parentEnv;
    }
    
    /**
     * visitCatchExp(element : imperativeocl::CatchExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitCatchExp(final /*@NonNull*/ /*@NonInvalid*/ CatchExp element_4) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_4);
        return parentEnv;
    }
    
    /**
     * visitComputeExp(element : imperativeocl::ComputeExp) : env::Environment[?]
     * 
     * 
     * if element.body = child
     * then
     *   this.parentEnv(element)
     *   .addElement(element.returnedElement)
     * else this.parentEnv(element)
     * endif
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitComputeExp(final /*@NonNull*/ /*@NonInvalid*/ ComputeExp element_5) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_0 = this.parentEnv(element_5);
        final /*@Nullable*/ /*@Thrown*/ DomainExpression body = element_5.getBody();
        final /*@Thrown*/ boolean eq = (body != null) ? body.equals(child) : (child == null);
        /*@Nullable*/ /*@Thrown*/ Environment symbol_0;
        if (eq) {
            if (parentEnv_0 == null) {
                throw new InvalidValueException("Null source for \'env::Environment::addElement(pivot::NamedElement) : env::Environment\'");
            }
            final /*@Nullable*/ /*@Thrown*/ Variable returnedElement = element_5.getReturnedElement();
            final /*@NonNull*/ /*@Thrown*/ Environment addElement = parentEnv_0.addElement(returnedElement);
            symbol_0 = addElement;
        }
        else {
            symbol_0 = parentEnv_0;
        }
        return symbol_0;
    }
    
    /**
     * visitContinueExp(element : imperativeocl::ContinueExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitContinueExp(final /*@NonNull*/ /*@NonInvalid*/ ContinueExp element_6) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_6);
        return parentEnv;
    }
    
    /**
     * visitDictLiteralExp(element : imperativeocl::DictLiteralExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitDictLiteralExp(final /*@NonNull*/ /*@NonInvalid*/ DictLiteralExp element_7) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_7);
        return parentEnv;
    }
    
    /**
     * visitDictLiteralPart(element : imperativeocl::DictLiteralPart) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitDictLiteralPart(final /*@NonNull*/ /*@NonInvalid*/ DictLiteralPart element_8) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_8);
        return parentEnv;
    }
    
    /**
     * visitDictionaryType(element : imperativeocl::DictionaryType) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitDictionaryType(final /*@NonNull*/ /*@NonInvalid*/ DictionaryType element_9) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_9);
        return parentEnv;
    }
    
    /**
     * visitForExp(element : imperativeocl::ForExp) : env::Environment[?]
     * 
     * 
     * if element.condition = child
     * then
     *   let
     *     inner : env::Environment = context.addElements(element.iterator)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else
     *   if element.body = child
     *   then
     *     let
     *       inner : env::Environment = context.addElements(element.iterator)
     *     in
     *       if inner.hasFinalResult()
     *       then inner
     *       else this.parentEnv(element)
     *       endif
     *   else
     *     if element.iterator->includes(child)
     *     then
     *       let
     *         inner : env::Environment = context.addElements(
     *           element.iterator->select(x |
     *             element.iterator->indexOf(x) <
     *             element.iterator->indexOf(child)))
     *       in
     *         if inner.hasFinalResult()
     *         then inner
     *         else this.parentEnv(element)
     *         endif
     *     else this.parentEnv(element)
     *     endif
     *   endif
     * endif
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitForExp(final /*@NonNull*/ /*@NonInvalid*/ ForExp element_10) {
        final /*@NonNull*/ /*@Thrown*/ List<Variable> iterator = element_10.getIterator();
        final /*@Nullable*/ /*@Thrown*/ DomainExpression condition = element_10.getCondition();
        final /*@Thrown*/ boolean eq = (condition != null) ? condition.equals(child) : (child == null);
        /*@Nullable*/ /*@Thrown*/ Environment symbol_5;
        if (eq) {
            final /*@NonNull*/ /*@Thrown*/ Environment inner = context.addElements(iterator);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ Environment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_10);
                symbol_0 = parentEnv;
            }
            symbol_5 = symbol_0;
        }
        else {
            final /*@Nullable*/ /*@Thrown*/ DomainExpression body = element_10.getBody();
            final /*@Thrown*/ boolean eq_0 = (body != null) ? body.equals(child) : (child == null);
            /*@Nullable*/ /*@Thrown*/ Environment symbol_4;
            if (eq_0) {
                final /*@NonNull*/ /*@Thrown*/ Environment inner_0 = context.addElements(iterator);
                final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
                /*@Nullable*/ /*@Thrown*/ Environment symbol_1;
                if (hasFinalResult_0) {
                    symbol_1 = inner_0;
                }
                else {
                    final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_0 = this.parentEnv(element_10);
                    symbol_1 = parentEnv_0;
                }
                symbol_4 = symbol_1;
            }
            else {
                final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_iterator_1 = idResolver.createOrderedSetOfAll(ORD_CLSSid_Variable, iterator);
                final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_iterator_1, child).booleanValue();
                /*@Nullable*/ /*@Thrown*/ Environment symbol_3;
                if (includes) {
                    /*@NonNull*/ /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValuesUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Variable);
                    /*@Nullable*/ Iterator<?> ITERATOR_x = BOXED_iterator_1.iterator();
                    /*@NonNull*/ /*@Thrown*/ OrderedSetValue select;
                    while (true) {
                        if (!ITERATOR_x.hasNext()) {
                            select = accumulator;
                            break;
                        }
                        /*@Nullable*/ /*@NonInvalid*/ Variable x = (Variable)ITERATOR_x.next();
                        /**
                         * element.iterator->indexOf(x) < element.iterator->indexOf(child)
                         */
                        final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_iterator_1, x);
                        final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_iterator_1, child);
                        final /*@Thrown*/ boolean lt = NumericLessThanOperation.INSTANCE.evaluate(indexOf, indexOf_0).booleanValue();
                        //
                        if (lt == ValuesUtil.TRUE_VALUE) {
                            accumulator.add(x);
                        }
                    }
                    final List<Variable> UNBOXED_select = select.asEcoreObjects(idResolver, Variable.class);
                    assert UNBOXED_select != null;
                    final /*@NonNull*/ /*@Thrown*/ Environment inner_1 = context.addElements(UNBOXED_select);
                    final /*@Thrown*/ boolean hasFinalResult_1 = inner_1.hasFinalResult();
                    /*@Nullable*/ /*@Thrown*/ Environment symbol_2;
                    if (hasFinalResult_1) {
                        symbol_2 = inner_1;
                    }
                    else {
                        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_1 = this.parentEnv(element_10);
                        symbol_2 = parentEnv_1;
                    }
                    symbol_3 = symbol_2;
                }
                else {
                    final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_2 = this.parentEnv(element_10);
                    symbol_3 = parentEnv_2;
                }
                symbol_4 = symbol_3;
            }
            symbol_5 = symbol_4;
        }
        return symbol_5;
    }
    
    /**
     * visitImperativeExpression(element : imperativeocl::ImperativeExpression) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitImperativeExpression(final /*@NonNull*/ /*@NonInvalid*/ ImperativeExpression element_11) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_11);
        return parentEnv;
    }
    
    /**
     * visitImperativeIterateExp(element : imperativeocl::ImperativeIterateExp) : env::Environment[?]
     * 
     * 
     * if element.condition = child
     * then
     *   let
     *     inner : env::Environment = context.addElements(element.iterator)
     *     .addElement(element.target)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else
     *   if element.body = child
     *   then
     *     let
     *       inner : env::Environment = context.addElements(element.iterator)
     *     in
     *       if inner.hasFinalResult()
     *       then inner
     *       else this.parentEnv(element)
     *       endif
     *   else
     *     if element.iterator->includes(child)
     *     then
     *       let
     *         inner : env::Environment = context.addElements(
     *           element.iterator->select(x |
     *             element.iterator->indexOf(x) <
     *             element.iterator->indexOf(child)))
     *       in
     *         if inner.hasFinalResult()
     *         then inner
     *         else this.parentEnv(element)
     *         endif
     *     else this.parentEnv(element)
     *     endif
     *   endif
     * endif
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitImperativeIterateExp(final /*@NonNull*/ /*@NonInvalid*/ ImperativeIterateExp element_12) {
        final /*@NonNull*/ /*@Thrown*/ List<Variable> iterator_1 = element_12.getIterator();
        final /*@Nullable*/ /*@Thrown*/ DomainExpression condition = element_12.getCondition();
        final /*@Thrown*/ boolean eq = (condition != null) ? condition.equals(child) : (child == null);
        /*@Nullable*/ /*@Thrown*/ Environment symbol_5;
        if (eq) {
            final /*@NonNull*/ /*@Thrown*/ Environment addElements = context.addElements(iterator_1);
            final /*@Nullable*/ /*@Thrown*/ Variable target = element_12.getTarget();
            final /*@NonNull*/ /*@Thrown*/ Environment inner = addElements.addElement(target);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ Environment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_12);
                symbol_0 = parentEnv;
            }
            symbol_5 = symbol_0;
        }
        else {
            final /*@Nullable*/ /*@Thrown*/ DomainExpression body = element_12.getBody();
            final /*@Thrown*/ boolean eq_0 = (body != null) ? body.equals(child) : (child == null);
            /*@Nullable*/ /*@Thrown*/ Environment symbol_4;
            if (eq_0) {
                final /*@NonNull*/ /*@Thrown*/ Environment inner_0 = context.addElements(iterator_1);
                final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
                /*@Nullable*/ /*@Thrown*/ Environment symbol_1;
                if (hasFinalResult_0) {
                    symbol_1 = inner_0;
                }
                else {
                    final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_0 = this.parentEnv(element_12);
                    symbol_1 = parentEnv_0;
                }
                symbol_4 = symbol_1;
            }
            else {
                final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_iterator_1 = idResolver.createOrderedSetOfAll(ORD_CLSSid_Variable, iterator_1);
                final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_iterator_1, child).booleanValue();
                /*@Nullable*/ /*@Thrown*/ Environment symbol_3;
                if (includes) {
                    /*@NonNull*/ /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValuesUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Variable);
                    /*@Nullable*/ Iterator<?> ITERATOR_x = BOXED_iterator_1.iterator();
                    /*@NonNull*/ /*@Thrown*/ OrderedSetValue select;
                    while (true) {
                        if (!ITERATOR_x.hasNext()) {
                            select = accumulator;
                            break;
                        }
                        /*@Nullable*/ /*@NonInvalid*/ Variable x = (Variable)ITERATOR_x.next();
                        /**
                         * element.iterator->indexOf(x) < element.iterator->indexOf(child)
                         */
                        final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_iterator_1, x);
                        final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_iterator_1, child);
                        final /*@Thrown*/ boolean lt = NumericLessThanOperation.INSTANCE.evaluate(indexOf, indexOf_0).booleanValue();
                        //
                        if (lt == ValuesUtil.TRUE_VALUE) {
                            accumulator.add(x);
                        }
                    }
                    final List<Variable> UNBOXED_select = select.asEcoreObjects(idResolver, Variable.class);
                    assert UNBOXED_select != null;
                    final /*@NonNull*/ /*@Thrown*/ Environment inner_1 = context.addElements(UNBOXED_select);
                    final /*@Thrown*/ boolean hasFinalResult_1 = inner_1.hasFinalResult();
                    /*@Nullable*/ /*@Thrown*/ Environment symbol_2;
                    if (hasFinalResult_1) {
                        symbol_2 = inner_1;
                    }
                    else {
                        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_1 = this.parentEnv(element_12);
                        symbol_2 = parentEnv_1;
                    }
                    symbol_3 = symbol_2;
                }
                else {
                    final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_2 = this.parentEnv(element_12);
                    symbol_3 = parentEnv_2;
                }
                symbol_4 = symbol_3;
            }
            symbol_5 = symbol_4;
        }
        return symbol_5;
    }
    
    /**
     * visitImperativeLoopExp(element : imperativeocl::ImperativeLoopExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitImperativeLoopExp(final /*@NonNull*/ /*@NonInvalid*/ ImperativeLoopExp element_13) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_13);
        return parentEnv;
    }
    
    /**
     * visitInstantiationExp(element : imperativeocl::InstantiationExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitInstantiationExp(final /*@NonNull*/ /*@NonInvalid*/ InstantiationExp element_14) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_14);
        return parentEnv;
    }
    
    /**
     * visitListLiteralExp(element : imperativeocl::ListLiteralExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitListLiteralExp(final /*@NonNull*/ /*@NonInvalid*/ ListLiteralExp element_15) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_15);
        return parentEnv;
    }
    
    /**
     * visitListType(element : imperativeocl::ListType) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitListType(final /*@NonNull*/ /*@NonInvalid*/ ListType element_16) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_16);
        return parentEnv;
    }
    
    /**
     * visitLogExp(element : imperativeocl::LogExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitLogExp(final /*@NonNull*/ /*@NonInvalid*/ LogExp element_17) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_17);
        return parentEnv;
    }
    
    /**
     * visitOrderedTupleLiteralExp(element : imperativeocl::OrderedTupleLiteralExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitOrderedTupleLiteralExp(final /*@NonNull*/ /*@NonInvalid*/ OrderedTupleLiteralExp element_18) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_18);
        return parentEnv;
    }
    
    /**
     * visitOrderedTupleLiteralPart(element : imperativeocl::OrderedTupleLiteralPart) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitOrderedTupleLiteralPart(final /*@NonNull*/ /*@NonInvalid*/ OrderedTupleLiteralPart element_19) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_19);
        return parentEnv;
    }
    
    /**
     * visitOrderedTupleType(element : imperativeocl::OrderedTupleType) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitOrderedTupleType(final /*@NonNull*/ /*@NonInvalid*/ OrderedTupleType element_20) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_20);
        return parentEnv;
    }
    
    /**
     * visitRaiseExp(element : imperativeocl::RaiseExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitRaiseExp(final /*@NonNull*/ /*@NonInvalid*/ RaiseExp element_21) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_21);
        return parentEnv;
    }
    
    /**
     * visitReturnExp(element : imperativeocl::ReturnExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitReturnExp(final /*@NonNull*/ /*@NonInvalid*/ ReturnExp element_22) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_22);
        return parentEnv;
    }
    
    /**
     * visitSwitchExp(element : imperativeocl::SwitchExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitSwitchExp(final /*@NonNull*/ /*@NonInvalid*/ SwitchExp element_23) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_23);
        return parentEnv;
    }
    
    /**
     * visitTryExp(element : imperativeocl::TryExp) : env::Environment[?]
     * 
     * 
     * if element.tryBody->includes(child)
     * then this.parentEnv(element)
     * else this.parentEnv(element)
     * endif
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitTryExp(final /*@NonNull*/ /*@NonInvalid*/ TryExp element_24) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_0 = this.parentEnv(element_24);
        final /*@Nullable*/ /*@Thrown*/ List<? extends DomainExpression> tryBody = element_24.getTryBody();
        assert tryBody != null;
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_tryBody = idResolver.createOrderedSetOfAll(ORD_CLSSid_OCLExpression, tryBody);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_tryBody, child).booleanValue();
        /*@Nullable*/ /*@Thrown*/ Environment symbol_0;
        if (includes) {
            symbol_0 = parentEnv_0;
        }
        else {
            symbol_0 = parentEnv_0;
        }
        return symbol_0;
    }
    
    /**
     * visitTypedef(element : imperativeocl::Typedef) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitTypedef(final /*@NonNull*/ /*@NonInvalid*/ Typedef element_25) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_25);
        return parentEnv;
    }
    
    /**
     * visitUnlinkExp(element : imperativeocl::UnlinkExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitUnlinkExp(final /*@NonNull*/ /*@NonInvalid*/ UnlinkExp element_26) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_26);
        return parentEnv;
    }
    
    /**
     * visitUnpackExp(element : imperativeocl::UnpackExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitUnpackExp(final /*@NonNull*/ /*@NonInvalid*/ UnpackExp element_27) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_27);
        return parentEnv;
    }
    
    /**
     * visitVariableInitExp(element : imperativeocl::VariableInitExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitVariableInitExp(final /*@NonNull*/ /*@NonInvalid*/ VariableInitExp element_28) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_28);
        return parentEnv;
    }
    
    /**
     * visitWhileExp(element : imperativeocl::WhileExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitWhileExp(final /*@NonNull*/ /*@NonInvalid*/ WhileExp element_29) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_29);
        return parentEnv;
    }
}
