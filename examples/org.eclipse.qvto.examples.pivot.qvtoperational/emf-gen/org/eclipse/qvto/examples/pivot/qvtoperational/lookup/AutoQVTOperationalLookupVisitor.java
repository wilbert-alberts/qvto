/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.qvto.examples.pivot.qvtoperational.lookup;

import java.util.Iterator;
import java.util.List;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.RootPackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.examples.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.examples.library.collection.OrderedCollectionIndexOfOperation;
import org.eclipse.ocl.examples.library.numeric.NumericLessThanOperation;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.lookup.Environment;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage;
import org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.lookup.NewImperativeOCLLookupVisitor;
import org.eclipse.qvto.examples.pivot.qvtoperational.Constructor;
import org.eclipse.qvto.examples.pivot.qvtoperational.ConstructorBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty;
import org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.Helper;
import org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeCallExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.Library;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingCallExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelType;
import org.eclipse.qvto.examples.pivot.qvtoperational.Module;
import org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.pivot.qvtoperational.ResolveExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.QVTOperationalVisitor;

public class AutoQVTOperationalLookupVisitor
	extends NewImperativeOCLLookupVisitor
	implements QVTOperationalVisitor<Environment>
{
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/pivot/1.0/ImperativeOCL", null, ImperativeOCLPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/pivot/1.0/QVTOperational", null, QVTOperationalPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_example_org_s_examples_s_env_ecore = IdManager.getNsURIPackageId("http://www.example.org/examples/env.ecore", null, null);
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_java_c_s_s_org_eclipse_qvto_examples_pivot_qvtoperational_lookup = IdManager.getRootPackageId("java://org.eclipse.qvto.examples.pivot.qvtoperational.lookup");
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_examples_domain_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.examples.domain.evaluation");
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_examples_domain_types = IdManager.getRootPackageId("org.eclipse.ocl.examples.domain.types");
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_AutoQVTOperationalLookupVisitor = PACKid_java_c_s_s_org_eclipse_qvto_examples_pivot_qvtoperational_lookup.getClassId("AutoQVTOperationalLookupVisitor", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Constructor = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("Constructor", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ConstructorBody = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ConstructorBody", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ContextualProperty = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ContextualProperty", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_DomainEvaluator = PACKid_org_eclipse_ocl_examples_domain_evaluation.getClassId("DomainEvaluator", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Element = PACKid_$metamodel$.getClassId("Element", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_EntryOperation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("EntryOperation", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Environment = PACKid_http_c_s_s_www_example_org_s_examples_s_env_ecore.getClassId("Environment", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Helper = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("Helper", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_examples_domain_types.getClassId("IdResolver", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ImperativeCallExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ImperativeCallExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ImperativeOperation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ImperativeOperation", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Library = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("Library", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MappingBody = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("MappingBody", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MappingCallExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("MappingCallExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MappingOperation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("MappingOperation", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MappingParameter = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("MappingParameter", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ModelParameter = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ModelParameter", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ModelType = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ModelType", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Module = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("Module", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OCLExpression = PACKid_$metamodel$.getClassId("OCLExpression", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ObjectExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ObjectExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Operation = PACKid_$metamodel$.getClassId("Operation", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OperationBody = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("OperationBody", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OperationalTransformation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("OperationalTransformation", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Package = PACKid_$metamodel$.getClassId("Package", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Parameter = PACKid_$metamodel$.getClassId("Parameter", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Property = PACKid_$metamodel$.getClassId("Property", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ResolveExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ResolveExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ResolveInExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("ResolveInExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Type = PACKid_$metamodel$.getClassId("Type", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_VarParameter = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperational.getClassId("VarParameter", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Variable = PACKid_$metamodel$.getClassId("Variable", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_VariableInitExp = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_ImperativeOCL.getClassId("VariableInitExp", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ MetaclassId METAid_Metaclass = TypeId.METACLASS.getSpecializedId(CLSSid_VariableInitExp);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_ModelParameter = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ModelParameter);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_OCLExpression = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OCLExpression);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Operation = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Operation);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Package = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Package);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Parameter);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Property = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Property);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_VarParameter = TypeId.ORDERED_SET.getSpecializedId(CLSSid_VarParameter);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_VariableInitExp = TypeId.ORDERED_SET.getSpecializedId(CLSSid_VariableInitExp);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Variable = TypeId.SEQUENCE.getSpecializedId(CLSSid_Variable);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(CLSSid_Package);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Type = TypeId.SET.getSpecializedId(CLSSid_Type);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Variable = TypeId.SET.getSpecializedId(CLSSid_Variable);
    
    protected /*@Nullable*/ /*@Thrown*/ Element child;
    protected final /*@NonNull*/ /*@Thrown*/ DomainEvaluator evaluator;
    protected final /*@NonNull*/ /*@Thrown*/ IdResolver idResolver;
    
    public AutoQVTOperationalLookupVisitor(/*@NonNull*/ Environment context) {
        super(context);
        this.evaluator = context.getEvaluator();
        this.idResolver = evaluator.getIdResolver();
    }
    
    /**
     * visitConstructor(element : qvtoperational::Constructor) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitConstructor(final /*@NonNull*/ /*@NonInvalid*/ Constructor element) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element);
        return parentEnv;
    }
    
    /**
     * visitConstructorBody(element : qvtoperational::ConstructorBody) : env::Environment[?]
     * 
     * 
     * if element.content->includes(child)
     * then
     *   let
     *     inner : env::Environment = context.addElements(element.variable)
     *     .addElements(
     *       element.content->select(x |
     *         element.content->indexOf(x) <
     *         element.content->indexOf(child))
     *       ->selectByKind(imperativeocl::VariableInitExp).referredVariable)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else this.parentEnv(element)
     * endif
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitConstructorBody(final /*@NonNull*/ /*@NonInvalid*/ ConstructorBody element_0) {
        final /*@Nullable*/ /*@Thrown*/ List<? extends DomainExpression> content = element_0.getContent();
        assert content != null;
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_content = idResolver.createOrderedSetOfAll(ORD_CLSSid_OCLExpression, content);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_content, child).booleanValue();
        /*@Nullable*/ /*@Thrown*/ Environment symbol_1;
        if (includes) {
            final /*@NonNull*/ /*@NonInvalid*/ DomainType TYP_imperativeocl_c_c_VariableInitExp_0 = idResolver.getType(CLSSid_VariableInitExp, null);
            final /*@Nullable*/ /*@Thrown*/ List<Variable> variable = element_0.getVariable();
            assert variable != null;
            final /*@NonNull*/ /*@Thrown*/ Environment addElements = context.addElements(variable);
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValuesUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_OCLExpression);
            /*@Nullable*/ Iterator<?> ITERATOR_x = BOXED_content.iterator();
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue select;
            while (true) {
                if (!ITERATOR_x.hasNext()) {
                    select = accumulator;
                    break;
                }
                /*@Nullable*/ /*@NonInvalid*/ DomainExpression x = (DomainExpression)ITERATOR_x.next();
                /**
                 * element.content->indexOf(x) < element.content->indexOf(child)
                 */
                final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_content, x);
                final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_content, child);
                final /*@Thrown*/ boolean lt = NumericLessThanOperation.INSTANCE.evaluate(indexOf, indexOf_0).booleanValue();
                //
                if (lt == ValuesUtil.TRUE_VALUE) {
                    accumulator.add(x);
                }
            }
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(evaluator, select, TYP_imperativeocl_c_c_VariableInitExp_0);
            /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValuesUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Variable);
            /*@Nullable*/ Iterator<?> ITERATOR__1 = selectByKind.iterator();
            /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
            while (true) {
                if (!ITERATOR__1.hasNext()) {
                    collect = accumulator_0;
                    break;
                }
                /*@Nullable*/ /*@NonInvalid*/ VariableInitExp _1 = (VariableInitExp)ITERATOR__1.next();
                /**
                 * referredVariable
                 */
                if (_1 == null) {
                    throw new InvalidValueException("Null source for \'imperativeocl::VariableInitExp::referredVariable\'");
                }
                final /*@Nullable*/ /*@Thrown*/ Variable referredVariable = _1.getReferredVariable();
                //
                accumulator_0.add(referredVariable);
            }
            final List<Variable> UNBOXED_collect = collect.asEcoreObjects(idResolver, Variable.class);
            assert UNBOXED_collect != null;
            final /*@NonNull*/ /*@Thrown*/ Environment inner = addElements.addElements(UNBOXED_collect);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ Environment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_0);
                symbol_0 = parentEnv;
            }
            symbol_1 = symbol_0;
        }
        else {
            final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_0 = this.parentEnv(element_0);
            symbol_1 = parentEnv_0;
        }
        return symbol_1;
    }
    
    /**
     * visitContextualProperty(element : qvtoperational::ContextualProperty) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitContextualProperty(final /*@NonNull*/ /*@NonInvalid*/ ContextualProperty element_1) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_1);
        return parentEnv;
    }
    
    /**
     * visitEntryOperation(element : qvtoperational::EntryOperation) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitEntryOperation(final /*@NonNull*/ /*@NonInvalid*/ EntryOperation element_2) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_2);
        return parentEnv;
    }
    
    /**
     * visitHelper(element : qvtoperational::Helper) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitHelper(final /*@NonNull*/ /*@NonInvalid*/ Helper element_3) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_3);
        return parentEnv;
    }
    
    /**
     * visitImperativeCallExp(element : qvtoperational::ImperativeCallExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitImperativeCallExp(final /*@NonNull*/ /*@NonInvalid*/ ImperativeCallExp element_4) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_4);
        return parentEnv;
    }
    
    /**
     * visitImperativeOperation(element : qvtoperational::ImperativeOperation) : env::Environment[?]
     * 
     * 
     * if element.body = child
     * then
     *   let
     *     inner : env::Environment = context.addElement(element.context)
     *     .addElements(element.result)
     *     .addElements(element.ownedParameter)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else this.parentEnv(element)
     * endif
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitImperativeOperation(final /*@NonNull*/ /*@NonInvalid*/ ImperativeOperation element_5) {
        final /*@Nullable*/ /*@Thrown*/ OperationBody body = element_5.getBody();
        final /*@Thrown*/ boolean eq = (body != null) ? body.equals(child) : (child == null);
        /*@Nullable*/ /*@Thrown*/ Environment symbol_1;
        if (eq) {
            final /*@Nullable*/ /*@Thrown*/ VarParameter context = element_5.getContext();
            final /*@NonNull*/ /*@Thrown*/ Environment addElement = context_0.addElement(context);
            final /*@Nullable*/ /*@Thrown*/ List<VarParameter> result = element_5.getResult();
            assert result != null;
            final /*@NonNull*/ /*@Thrown*/ Environment addElements = addElement.addElements(result);
            final /*@NonNull*/ /*@Thrown*/ List<? extends DomainTypedElement> ownedParameter = element_5.getOwnedParameter();
            final /*@NonNull*/ /*@Thrown*/ Environment inner = addElements.addElements(ownedParameter);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ Environment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_5);
                symbol_0 = parentEnv;
            }
            symbol_1 = symbol_0;
        }
        else {
            final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_0 = this.parentEnv(element_5);
            symbol_1 = parentEnv_0;
        }
        return symbol_1;
    }
    
    /**
     * visitLibrary(element : qvtoperational::Library) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitLibrary(final /*@NonNull*/ /*@NonInvalid*/ Library element_6) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_6);
        return parentEnv;
    }
    
    /**
     * visitMappingBody(element : qvtoperational::MappingBody) : env::Environment[?]
     * 
     * 
     * if element.content->includes(child)
     * then
     *   let
     *     inner : env::Environment = context.addElements(element.variable)
     *     .addElements(
     *       element.content->select(x |
     *         element.content->indexOf(x) <
     *         element.content->indexOf(child))
     *       ->selectByKind(imperativeocl::VariableInitExp).referredVariable)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else
     *   if element.initSection->includes(child)
     *   then
     *     let
     *       inner : env::Environment = context.addElements(element.variable)
     *       .addElements(
     *         element.content->select(x |
     *           element.initSection->indexOf(x) <
     *           element.initSection->indexOf(child))
     *         ->selectByKind(imperativeocl::VariableInitExp).referredVariable)
     *     in
     *       if inner.hasFinalResult()
     *       then inner
     *       else this.parentEnv(element)
     *       endif
     *   else
     *     if element.endSection->includes(child)
     *     then
     *       let
     *         inner : env::Environment = context.addElements(element.variable)
     *         .addElements(
     *           element.content->select(x |
     *             element.endSection->indexOf(x) <
     *             element.endSection->indexOf(child))
     *           ->selectByKind(imperativeocl::VariableInitExp).referredVariable)
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
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitMappingBody(final /*@NonNull*/ /*@NonInvalid*/ MappingBody element_7) {
        final /*@Nullable*/ /*@Thrown*/ List<? extends DomainExpression> content = element_7.getContent();
        assert content != null;
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_content = idResolver.createOrderedSetOfAll(ORD_CLSSid_OCLExpression, content);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_content, child).booleanValue();
        /*@Nullable*/ /*@Thrown*/ Environment symbol_5;
        if (includes) {
            final /*@NonNull*/ /*@NonInvalid*/ DomainType TYP_imperativeocl_c_c_VariableInitExp_0 = idResolver.getType(CLSSid_VariableInitExp, null);
            final /*@Nullable*/ /*@Thrown*/ List<Variable> variable = element_7.getVariable();
            assert variable != null;
            final /*@NonNull*/ /*@Thrown*/ Environment addElements = context.addElements(variable);
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValuesUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_OCLExpression);
            /*@Nullable*/ Iterator<?> ITERATOR_x = BOXED_content.iterator();
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue select;
            while (true) {
                if (!ITERATOR_x.hasNext()) {
                    select = accumulator;
                    break;
                }
                /*@Nullable*/ /*@NonInvalid*/ DomainExpression x = (DomainExpression)ITERATOR_x.next();
                /**
                 * element.content->indexOf(x) < element.content->indexOf(child)
                 */
                final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_content, x);
                final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_content, child);
                final /*@Thrown*/ boolean lt = NumericLessThanOperation.INSTANCE.evaluate(indexOf, indexOf_0).booleanValue();
                //
                if (lt == ValuesUtil.TRUE_VALUE) {
                    accumulator.add(x);
                }
            }
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(evaluator, select, TYP_imperativeocl_c_c_VariableInitExp_0);
            /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValuesUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Variable);
            /*@Nullable*/ Iterator<?> ITERATOR__1 = selectByKind.iterator();
            /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
            while (true) {
                if (!ITERATOR__1.hasNext()) {
                    collect = accumulator_0;
                    break;
                }
                /*@Nullable*/ /*@NonInvalid*/ VariableInitExp _1 = (VariableInitExp)ITERATOR__1.next();
                /**
                 * referredVariable
                 */
                if (_1 == null) {
                    throw new InvalidValueException("Null source for \'imperativeocl::VariableInitExp::referredVariable\'");
                }
                final /*@Nullable*/ /*@Thrown*/ Variable referredVariable = _1.getReferredVariable();
                //
                accumulator_0.add(referredVariable);
            }
            final List<Variable> UNBOXED_collect = collect.asEcoreObjects(idResolver, Variable.class);
            assert UNBOXED_collect != null;
            final /*@NonNull*/ /*@Thrown*/ Environment inner = addElements.addElements(UNBOXED_collect);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ Environment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_7);
                symbol_0 = parentEnv;
            }
            symbol_5 = symbol_0;
        }
        else {
            final /*@Nullable*/ /*@Thrown*/ List<? extends DomainExpression> initSection = element_7.getInitSection();
            assert initSection != null;
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_initSection = idResolver.createOrderedSetOfAll(ORD_CLSSid_OCLExpression, initSection);
            final /*@Thrown*/ boolean includes_0 = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_initSection, child).booleanValue();
            /*@Nullable*/ /*@Thrown*/ Environment symbol_4;
            if (includes_0) {
                final /*@NonNull*/ /*@NonInvalid*/ DomainType TYP_imperativeocl_c_c_VariableInitExp_1 = idResolver.getType(CLSSid_VariableInitExp, null);
                final /*@Nullable*/ /*@Thrown*/ List<Variable> variable_0 = element_7.getVariable();
                assert variable_0 != null;
                final /*@NonNull*/ /*@Thrown*/ Environment addElements_0 = context.addElements(variable_0);
                /*@NonNull*/ /*@Thrown*/ OrderedSetValue.Accumulator accumulator_1 = ValuesUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_OCLExpression);
                /*@Nullable*/ Iterator<?> ITERATOR_x_0 = BOXED_content.iterator();
                /*@NonNull*/ /*@Thrown*/ OrderedSetValue select_0;
                while (true) {
                    if (!ITERATOR_x_0.hasNext()) {
                        select_0 = accumulator_1;
                        break;
                    }
                    /*@Nullable*/ /*@NonInvalid*/ DomainExpression x_0 = (DomainExpression)ITERATOR_x_0.next();
                    /**
                     * element.initSection->indexOf(x) < element.initSection->indexOf(child)
                     */
                    final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf_1 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_initSection, x_0);
                    final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf_2 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_initSection, child);
                    final /*@Thrown*/ boolean lt_0 = NumericLessThanOperation.INSTANCE.evaluate(indexOf_1, indexOf_2).booleanValue();
                    //
                    if (lt_0 == ValuesUtil.TRUE_VALUE) {
                        accumulator_1.add(x_0);
                    }
                }
                final /*@NonNull*/ /*@Thrown*/ OrderedSetValue selectByKind_0 = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(evaluator, select_0, TYP_imperativeocl_c_c_VariableInitExp_1);
                /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_2 = ValuesUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Variable);
                /*@Nullable*/ Iterator<?> ITERATOR__1_0 = selectByKind_0.iterator();
                /*@NonNull*/ /*@Thrown*/ SequenceValue collect_0;
                while (true) {
                    if (!ITERATOR__1_0.hasNext()) {
                        collect_0 = accumulator_2;
                        break;
                    }
                    /*@Nullable*/ /*@NonInvalid*/ VariableInitExp _1_0 = (VariableInitExp)ITERATOR__1_0.next();
                    /**
                     * referredVariable
                     */
                    if (_1_0 == null) {
                        throw new InvalidValueException("Null source for \'imperativeocl::VariableInitExp::referredVariable\'");
                    }
                    final /*@Nullable*/ /*@Thrown*/ Variable referredVariable_0 = _1_0.getReferredVariable();
                    //
                    accumulator_2.add(referredVariable_0);
                }
                final List<Variable> UNBOXED_collect_0 = collect_0.asEcoreObjects(idResolver, Variable.class);
                assert UNBOXED_collect_0 != null;
                final /*@NonNull*/ /*@Thrown*/ Environment inner_0 = addElements_0.addElements(UNBOXED_collect_0);
                final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
                /*@Nullable*/ /*@Thrown*/ Environment symbol_1;
                if (hasFinalResult_0) {
                    symbol_1 = inner_0;
                }
                else {
                    final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_0 = this.parentEnv(element_7);
                    symbol_1 = parentEnv_0;
                }
                symbol_4 = symbol_1;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ List<? extends DomainExpression> endSection = element_7.getEndSection();
                assert endSection != null;
                final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_endSection = idResolver.createOrderedSetOfAll(ORD_CLSSid_OCLExpression, endSection);
                final /*@Thrown*/ boolean includes_1 = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_endSection, child).booleanValue();
                /*@Nullable*/ /*@Thrown*/ Environment symbol_3;
                if (includes_1) {
                    final /*@NonNull*/ /*@NonInvalid*/ DomainType TYP_imperativeocl_c_c_VariableInitExp_2 = idResolver.getType(CLSSid_VariableInitExp, null);
                    final /*@Nullable*/ /*@Thrown*/ List<Variable> variable_1 = element_7.getVariable();
                    assert variable_1 != null;
                    final /*@NonNull*/ /*@Thrown*/ Environment addElements_1 = context.addElements(variable_1);
                    /*@NonNull*/ /*@Thrown*/ OrderedSetValue.Accumulator accumulator_3 = ValuesUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_OCLExpression);
                    /*@Nullable*/ Iterator<?> ITERATOR_x_1 = BOXED_content.iterator();
                    /*@NonNull*/ /*@Thrown*/ OrderedSetValue select_1;
                    while (true) {
                        if (!ITERATOR_x_1.hasNext()) {
                            select_1 = accumulator_3;
                            break;
                        }
                        /*@Nullable*/ /*@NonInvalid*/ DomainExpression x_1 = (DomainExpression)ITERATOR_x_1.next();
                        /**
                         * element.endSection->indexOf(x) < element.endSection->indexOf(child)
                         */
                        final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf_3 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_endSection, x_1);
                        final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf_4 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_endSection, child);
                        final /*@Thrown*/ boolean lt_1 = NumericLessThanOperation.INSTANCE.evaluate(indexOf_3, indexOf_4).booleanValue();
                        //
                        if (lt_1 == ValuesUtil.TRUE_VALUE) {
                            accumulator_3.add(x_1);
                        }
                    }
                    final /*@NonNull*/ /*@Thrown*/ OrderedSetValue selectByKind_1 = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(evaluator, select_1, TYP_imperativeocl_c_c_VariableInitExp_2);
                    /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_4 = ValuesUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Variable);
                    /*@Nullable*/ Iterator<?> ITERATOR__1_1 = selectByKind_1.iterator();
                    /*@NonNull*/ /*@Thrown*/ SequenceValue collect_1;
                    while (true) {
                        if (!ITERATOR__1_1.hasNext()) {
                            collect_1 = accumulator_4;
                            break;
                        }
                        /*@Nullable*/ /*@NonInvalid*/ VariableInitExp _1_1 = (VariableInitExp)ITERATOR__1_1.next();
                        /**
                         * referredVariable
                         */
                        if (_1_1 == null) {
                            throw new InvalidValueException("Null source for \'imperativeocl::VariableInitExp::referredVariable\'");
                        }
                        final /*@Nullable*/ /*@Thrown*/ Variable referredVariable_1 = _1_1.getReferredVariable();
                        //
                        accumulator_4.add(referredVariable_1);
                    }
                    final List<Variable> UNBOXED_collect_1 = collect_1.asEcoreObjects(idResolver, Variable.class);
                    assert UNBOXED_collect_1 != null;
                    final /*@NonNull*/ /*@Thrown*/ Environment inner_1 = addElements_1.addElements(UNBOXED_collect_1);
                    final /*@Thrown*/ boolean hasFinalResult_1 = inner_1.hasFinalResult();
                    /*@Nullable*/ /*@Thrown*/ Environment symbol_2;
                    if (hasFinalResult_1) {
                        symbol_2 = inner_1;
                    }
                    else {
                        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_1 = this.parentEnv(element_7);
                        symbol_2 = parentEnv_1;
                    }
                    symbol_3 = symbol_2;
                }
                else {
                    final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_2 = this.parentEnv(element_7);
                    symbol_3 = parentEnv_2;
                }
                symbol_4 = symbol_3;
            }
            symbol_5 = symbol_4;
        }
        return symbol_5;
    }
    
    /**
     * visitMappingCallExp(element : qvtoperational::MappingCallExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitMappingCallExp(final /*@NonNull*/ /*@NonInvalid*/ MappingCallExp element_8) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_8);
        return parentEnv;
    }
    
    /**
     * visitMappingOperation(element : qvtoperational::MappingOperation) : env::Environment[?]
     * 
     * 
     * if element.body = child
     * then
     *   let
     *     inner : env::Environment = context.addElement(element.context)
     *     .addElements(element.result)
     *     .addElements(element.ownedParameter)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else
     *   if element.when = child
     *   then
     *     let
     *       inner : env::Environment = context.addElement(element.context)
     *       .addElements(element.ownedParameter)
     *     in
     *       if inner.hasFinalResult()
     *       then inner
     *       else this.parentEnv(element)
     *       endif
     *   else
     *     if element.where = child
     *     then
     *       let
     *         inner : env::Environment = context.addElement(element.context)
     *         .addElements(element.ownedParameter)
     *         .addElements(element.result)
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
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitMappingOperation(final /*@NonNull*/ /*@NonInvalid*/ MappingOperation element_9) {
        final /*@Nullable*/ /*@Thrown*/ OperationBody body = element_9.getBody();
        final /*@Thrown*/ boolean eq = (body != null) ? body.equals(child) : (child == null);
        /*@Nullable*/ /*@Thrown*/ Environment symbol_5;
        if (eq) {
            final /*@Nullable*/ /*@Thrown*/ VarParameter context = element_9.getContext();
            final /*@NonNull*/ /*@Thrown*/ Environment addElement = context_2.addElement(context);
            final /*@Nullable*/ /*@Thrown*/ List<VarParameter> result = element_9.getResult();
            assert result != null;
            final /*@NonNull*/ /*@Thrown*/ Environment addElements = addElement.addElements(result);
            final /*@NonNull*/ /*@Thrown*/ List<? extends DomainTypedElement> ownedParameter = element_9.getOwnedParameter();
            final /*@NonNull*/ /*@Thrown*/ Environment inner = addElements.addElements(ownedParameter);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ Environment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_9);
                symbol_0 = parentEnv;
            }
            symbol_5 = symbol_0;
        }
        else {
            final /*@Nullable*/ /*@Thrown*/ DomainExpression when = element_9.getWhen();
            final /*@Thrown*/ boolean eq_0 = (when != null) ? when.equals(child) : (child == null);
            /*@Nullable*/ /*@Thrown*/ Environment symbol_4;
            if (eq_0) {
                final /*@Nullable*/ /*@Thrown*/ VarParameter context_0 = element_9.getContext();
                final /*@NonNull*/ /*@Thrown*/ Environment addElement_0 = context_2.addElement(context_0);
                final /*@NonNull*/ /*@Thrown*/ List<? extends DomainTypedElement> ownedParameter_0 = element_9.getOwnedParameter();
                final /*@NonNull*/ /*@Thrown*/ Environment inner_0 = addElement_0.addElements(ownedParameter_0);
                final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
                /*@Nullable*/ /*@Thrown*/ Environment symbol_1;
                if (hasFinalResult_0) {
                    symbol_1 = inner_0;
                }
                else {
                    final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_0 = this.parentEnv(element_9);
                    symbol_1 = parentEnv_0;
                }
                symbol_4 = symbol_1;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ DomainExpression where = element_9.getWhere();
                final /*@Thrown*/ boolean eq_1 = (where != null) ? where.equals(child) : (child == null);
                /*@Nullable*/ /*@Thrown*/ Environment symbol_3;
                if (eq_1) {
                    final /*@Nullable*/ /*@Thrown*/ VarParameter context_1 = element_9.getContext();
                    final /*@NonNull*/ /*@Thrown*/ Environment addElement_1 = context_2.addElement(context_1);
                    final /*@NonNull*/ /*@Thrown*/ List<? extends DomainTypedElement> ownedParameter_1 = element_9.getOwnedParameter();
                    final /*@NonNull*/ /*@Thrown*/ Environment addElements_0 = addElement_1.addElements(ownedParameter_1);
                    final /*@Nullable*/ /*@Thrown*/ List<VarParameter> result_0 = element_9.getResult();
                    assert result_0 != null;
                    final /*@NonNull*/ /*@Thrown*/ Environment inner_1 = addElements_0.addElements(result_0);
                    final /*@Thrown*/ boolean hasFinalResult_1 = inner_1.hasFinalResult();
                    /*@Nullable*/ /*@Thrown*/ Environment symbol_2;
                    if (hasFinalResult_1) {
                        symbol_2 = inner_1;
                    }
                    else {
                        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_1 = this.parentEnv(element_9);
                        symbol_2 = parentEnv_1;
                    }
                    symbol_3 = symbol_2;
                }
                else {
                    final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_2 = this.parentEnv(element_9);
                    symbol_3 = parentEnv_2;
                }
                symbol_4 = symbol_3;
            }
            symbol_5 = symbol_4;
        }
        return symbol_5;
    }
    
    /**
     * visitMappingParameter(element : qvtoperational::MappingParameter) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitMappingParameter(final /*@NonNull*/ /*@NonInvalid*/ MappingParameter element_10) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_10);
        return parentEnv;
    }
    
    /**
     * visitModelType(element : qvtoperational::ModelType) : env::Environment[?]
     * 
     * 
     * if element.additionalCondition->includes(child)
     * then
     *   let
     *     inner : env::Environment = context.addElements(element.metamodel)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else
     *   let
     *     inner : env::Environment = context.addElements(element.metamodel)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * endif
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitModelType(final /*@NonNull*/ /*@NonInvalid*/ ModelType element_11) {
        final /*@Nullable*/ /*@Thrown*/ List<? extends DomainPackage> metamodel_0 = element_11.getMetamodel();
        assert metamodel_0 != null;
        final /*@NonNull*/ /*@Thrown*/ Environment inner_0 = context.addElements(metamodel_0);
        final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
        /*@Nullable*/ /*@Thrown*/ Environment symbol_1;
        if (hasFinalResult_0) {
            symbol_1 = inner_0;
        }
        else {
            final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_0 = this.parentEnv(element_11);
            symbol_1 = parentEnv_0;
        }
        final /*@Nullable*/ /*@Thrown*/ List<? extends DomainExpression> additionalCondition = element_11.getAdditionalCondition();
        assert additionalCondition != null;
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_additionalCondition = idResolver.createOrderedSetOfAll(ORD_CLSSid_OCLExpression, additionalCondition);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_additionalCondition, child).booleanValue();
        /*@Nullable*/ /*@Thrown*/ Environment symbol_2;
        if (includes) {
            symbol_2 = symbol_1;
        }
        else {
            symbol_2 = symbol_1;
        }
        return symbol_2;
    }
    
    /**
     * visitModule(element : qvtoperational::Module) : env::Environment[?]
     * 
     * 
     * let
     *   inner : env::Environment = context.addElements(element.ownedAttribute)
     *   .addElements(element.ownedOperation)
     *   .addElements(element.ownedType)
     *   .addElements(element.nestedPackage)
     *   .addElements(element.ownedVariable)
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else
     *     let
     *       inner : env::Environment = context.addElementsOf(element.moduleImport.module)
     *     in
     *       if inner.hasFinalResult()
     *       then inner
     *       else this.parentEnv(element)
     *       endif
     *   endif
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitModule(final /*@NonNull*/ /*@NonInvalid*/ Module element_12) {
        final /*@NonNull*/ /*@Thrown*/ List<? extends DomainProperty> ownedAttribute = element_12.getOwnedAttribute();
        final /*@NonNull*/ /*@Thrown*/ Environment addElements = context.addElements(ownedAttribute);
        final /*@NonNull*/ /*@Thrown*/ List<? extends DomainOperation> ownedOperation = element_12.getOwnedOperation();
        final /*@NonNull*/ /*@Thrown*/ Environment addElements_0 = addElements.addElements(ownedOperation);
        final /*@Nullable*/ /*@Thrown*/ List<? extends DomainType> ownedType = element_12.getOwnedType();
        assert ownedType != null;
        final /*@NonNull*/ /*@Thrown*/ Environment addElements_1 = addElements_0.addElements(ownedType);
        final /*@Nullable*/ /*@Thrown*/ List<? extends DomainPackage> nestedPackage = element_12.getNestedPackage();
        assert nestedPackage != null;
        final /*@NonNull*/ /*@Thrown*/ Environment addElements_2 = addElements_1.addElements(nestedPackage);
        final /*@Nullable*/ /*@Thrown*/ List<Variable> ownedVariable = element_12.getOwnedVariable();
        assert ownedVariable != null;
        final /*@NonNull*/ /*@Thrown*/ Environment inner = addElements_2.addElements(ownedVariable);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        /*@Nullable*/ /*@Thrown*/ Environment symbol_1;
        if (hasFinalResult) {
            symbol_1 = inner;
        }
        else {
            final /*@Thrown*/ boolean hasFinalResult_0 = throw new InvalidValueException();
            .hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ Environment symbol_0;
            if (hasFinalResult_0) {
                symbol_0 = null;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_12);
                symbol_0 = parentEnv;
            }
            symbol_1 = symbol_0;
        }
        return symbol_1;
    }
    
    /**
     * visitObjectExp(element : qvtoperational::ObjectExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitObjectExp(final /*@NonNull*/ /*@NonInvalid*/ ObjectExp element_13) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_13);
        return parentEnv;
    }
    
    /**
     * visitOperationBody(element : qvtoperational::OperationBody) : env::Environment[?]
     * 
     * 
     * if element.content->includes(child)
     * then
     *   let
     *     inner : env::Environment = context.addElements(element.variable)
     *     .addElements(
     *       element.content->select(x |
     *         element.content->indexOf(x) <
     *         element.content->indexOf(child))
     *       ->selectByKind(imperativeocl::VariableInitExp).referredVariable)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else this.parentEnv(element)
     * endif
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitOperationBody(final /*@NonNull*/ /*@NonInvalid*/ OperationBody element_14) {
        final /*@Nullable*/ /*@Thrown*/ List<? extends DomainExpression> content = element_14.getContent();
        assert content != null;
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_content = idResolver.createOrderedSetOfAll(ORD_CLSSid_OCLExpression, content);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_content, child).booleanValue();
        /*@Nullable*/ /*@Thrown*/ Environment symbol_1;
        if (includes) {
            final /*@NonNull*/ /*@NonInvalid*/ DomainType TYP_imperativeocl_c_c_VariableInitExp_0 = idResolver.getType(CLSSid_VariableInitExp, null);
            final /*@Nullable*/ /*@Thrown*/ List<Variable> variable = element_14.getVariable();
            assert variable != null;
            final /*@NonNull*/ /*@Thrown*/ Environment addElements = context.addElements(variable);
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValuesUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_OCLExpression);
            /*@Nullable*/ Iterator<?> ITERATOR_x = BOXED_content.iterator();
            /*@NonNull*/ /*@Thrown*/ OrderedSetValue select;
            while (true) {
                if (!ITERATOR_x.hasNext()) {
                    select = accumulator;
                    break;
                }
                /*@Nullable*/ /*@NonInvalid*/ DomainExpression x = (DomainExpression)ITERATOR_x.next();
                /**
                 * element.content->indexOf(x) < element.content->indexOf(child)
                 */
                final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_content, x);
                final /*@NonNull*/ /*@Thrown*/ IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_content, child);
                final /*@Thrown*/ boolean lt = NumericLessThanOperation.INSTANCE.evaluate(indexOf, indexOf_0).booleanValue();
                //
                if (lt == ValuesUtil.TRUE_VALUE) {
                    accumulator.add(x);
                }
            }
            final /*@NonNull*/ /*@Thrown*/ OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(evaluator, select, TYP_imperativeocl_c_c_VariableInitExp_0);
            /*@NonNull*/ /*@Thrown*/ SequenceValue.Accumulator accumulator_0 = ValuesUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Variable);
            /*@Nullable*/ Iterator<?> ITERATOR__1 = selectByKind.iterator();
            /*@NonNull*/ /*@Thrown*/ SequenceValue collect;
            while (true) {
                if (!ITERATOR__1.hasNext()) {
                    collect = accumulator_0;
                    break;
                }
                /*@Nullable*/ /*@NonInvalid*/ VariableInitExp _1 = (VariableInitExp)ITERATOR__1.next();
                /**
                 * referredVariable
                 */
                if (_1 == null) {
                    throw new InvalidValueException("Null source for \'imperativeocl::VariableInitExp::referredVariable\'");
                }
                final /*@Nullable*/ /*@Thrown*/ Variable referredVariable = _1.getReferredVariable();
                //
                accumulator_0.add(referredVariable);
            }
            final List<Variable> UNBOXED_collect = collect.asEcoreObjects(idResolver, Variable.class);
            assert UNBOXED_collect != null;
            final /*@NonNull*/ /*@Thrown*/ Environment inner = addElements.addElements(UNBOXED_collect);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ Environment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_14);
                symbol_0 = parentEnv;
            }
            symbol_1 = symbol_0;
        }
        else {
            final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_0 = this.parentEnv(element_14);
            symbol_1 = parentEnv_0;
        }
        return symbol_1;
    }
    
    /**
     * visitOperationalTransformation(element : qvtoperational::OperationalTransformation) : env::Environment[?]
     * 
     * 
     * if element.modelParameter->includes(child)
     * then
     *   let
     *     inner : env::Environment = context.addElements(element.ownedAttribute)
     *     .addElements(element.ownedOperation)
     *     .addElements(element.ownedType)
     *     .addElements(element.nestedPackage)
     *     .addElements(element.ownedVariable)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else
     *       let
     *         inner : env::Environment = context.addElementsOf(element.moduleImport.module)
     *       in
     *         if inner.hasFinalResult()
     *         then inner
     *         else this.parentEnv(element)
     *         endif
     *     endif
     * else
     *   let
     *     inner : env::Environment = context.addElements(element.ownedAttribute)
     *     .addElements(element.ownedOperation)
     *     .addElements(element.ownedType)
     *     .addElements(element.nestedPackage)
     *     .addElements(element.ownedVariable)
     *     .addElements(element.modelParameter)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else
     *       let
     *         inner : env::Environment = context.addElementsOf(element.moduleImport.module)
     *       in
     *         if inner.hasFinalResult()
     *         then inner
     *         else this.parentEnv(element)
     *         endif
     *     endif
     * endif
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitOperationalTransformation(final /*@NonNull*/ /*@NonInvalid*/ OperationalTransformation element_15) {
        final /*@Nullable*/ /*@Thrown*/ List<ModelParameter> modelParameter = element_15.getModelParameter();
        final /*@Nullable*/ /*@Thrown*/ List<? extends DomainPackage> nestedPackage = element_15.getNestedPackage();
        final /*@NonNull*/ /*@Thrown*/ List<? extends DomainProperty> ownedAttribute = element_15.getOwnedAttribute();
        final /*@NonNull*/ /*@Thrown*/ List<? extends DomainOperation> ownedOperation = element_15.getOwnedOperation();
        final /*@Nullable*/ /*@Thrown*/ List<? extends DomainType> ownedType = element_15.getOwnedType();
        final /*@Nullable*/ /*@Thrown*/ List<Variable> ownedVariable = element_15.getOwnedVariable();
        assert modelParameter != null;
        assert nestedPackage != null;
        assert ownedType != null;
        assert ownedVariable != null;
        final /*@NonNull*/ /*@Thrown*/ Environment addElements = context.addElements(ownedAttribute);
        final /*@NonNull*/ /*@Thrown*/ Environment addElements_0 = addElements.addElements(ownedOperation);
        final /*@NonNull*/ /*@Thrown*/ Environment addElements_1 = addElements_0.addElements(ownedType);
        final /*@NonNull*/ /*@Thrown*/ Environment addElements_2 = addElements_1.addElements(nestedPackage);
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_modelParameter = idResolver.createOrderedSetOfAll(ORD_CLSSid_ModelParameter, modelParameter);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_modelParameter, child).booleanValue();
        /*@Nullable*/ /*@Thrown*/ Environment symbol_4;
        if (includes) {
            final /*@NonNull*/ /*@Thrown*/ Environment inner = addElements_2.addElements(ownedVariable);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ Environment symbol_1;
            if (hasFinalResult) {
                symbol_1 = inner;
            }
            else {
                final /*@Thrown*/ boolean hasFinalResult_0 = throw new InvalidValueException();
                .hasFinalResult();
                /*@Nullable*/ /*@Thrown*/ Environment symbol_0;
                if (hasFinalResult_0) {
                    symbol_0 = null;
                }
                else {
                    final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_15);
                    symbol_0 = parentEnv;
                }
                symbol_1 = symbol_0;
            }
            symbol_4 = symbol_1;
        }
        else {
            final /*@NonNull*/ /*@Thrown*/ Environment addElements_7 = addElements_2.addElements(ownedVariable);
            final /*@NonNull*/ /*@Thrown*/ Environment inner_1 = addElements_7.addElements(modelParameter);
            final /*@Thrown*/ boolean hasFinalResult_1 = inner_1.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ Environment symbol_3;
            if (hasFinalResult_1) {
                symbol_3 = inner_1;
            }
            else {
                final /*@Thrown*/ boolean hasFinalResult_2 = throw new InvalidValueException();
                .hasFinalResult();
                /*@Nullable*/ /*@Thrown*/ Environment symbol_2;
                if (hasFinalResult_2) {
                    symbol_2 = null;
                }
                else {
                    final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_0 = this.parentEnv(element_15);
                    symbol_2 = parentEnv_0;
                }
                symbol_3 = symbol_2;
            }
            symbol_4 = symbol_3;
        }
        return symbol_4;
    }
    
    /**
     * visitResolveExp(element : qvtoperational::ResolveExp) : env::Environment[?]
     * 
     * 
     * if element.condition = child
     * then
     *   let
     *     inner : env::Environment = context.addElement(element.target)
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else this.parentEnv(element)
     * endif
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitResolveExp(final /*@NonNull*/ /*@NonInvalid*/ ResolveExp element_16) {
        final /*@Nullable*/ /*@Thrown*/ DomainExpression condition = element_16.getCondition();
        final /*@Thrown*/ boolean eq = (condition != null) ? condition.equals(child) : (child == null);
        /*@Nullable*/ /*@Thrown*/ Environment symbol_1;
        if (eq) {
            final /*@Nullable*/ /*@Thrown*/ Variable target = element_16.getTarget();
            final /*@NonNull*/ /*@Thrown*/ Environment inner = context.addElement(target);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            /*@Nullable*/ /*@Thrown*/ Environment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_16);
                symbol_0 = parentEnv;
            }
            symbol_1 = symbol_0;
        }
        else {
            final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_0 = this.parentEnv(element_16);
            symbol_1 = parentEnv_0;
        }
        return symbol_1;
    }
    
    /**
     * visitResolveInExp(element : qvtoperational::ResolveInExp) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitResolveInExp(final /*@NonNull*/ /*@NonInvalid*/ ResolveInExp element_17) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_17);
        return parentEnv;
    }
    
    /**
     * visitVarParameter(element : qvtoperational::VarParameter) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitVarParameter(final /*@NonNull*/ /*@NonInvalid*/ VarParameter element_18) {
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = this.parentEnv(element_18);
        return parentEnv;
    }
}
