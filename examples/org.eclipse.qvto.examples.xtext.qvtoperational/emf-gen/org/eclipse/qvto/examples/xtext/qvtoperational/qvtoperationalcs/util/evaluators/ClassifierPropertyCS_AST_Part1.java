/*
 * «codeGenHelper.getCopyright(' * ')»
 *************************************************************************
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 */

package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.evaluators;

import java.util.Iterator;
import java.util.List;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage;

@SuppressWarnings("nls")
public class ClassifierPropertyCS_AST_Part1
{
    public static final/*@NonNull*/ ClassifierPropertyCS_AST_Part1 INSTANCE = new ClassifierPropertyCS_AST_Part1();
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/pivot/1.0/QVTOperationalCS", QVTOperationalCSPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ClassifierPropertyCS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS.getClassId("ClassifierPropertyCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_PRIMid_String = TypeId.ORDERED_SET.getSpecializedId(TypeId.STRING);
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_composite = "composite";
    
    public /*@Nullable*/ /*@NonInvalid*/ Boolean evaluate(final /*@NonNull*/ /*@NonInvalid*/ DomainEvaluator evaluator, final /*@NonNull*/ /*@NonInvalid*/ TypeId typeId, final /*@NonNull*/ /*@NonInvalid*/ ClassifierPropertyCS self) {
        final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final /*@NonNull*/ /*@Thrown*/ List<? extends Object> qualifier = self.getQualifier();
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_qualifier = idResolver.createOrderedSetOfAll(ORD_PRIMid_String, qualifier);
        /*@Nullable*/ Iterator<?> ITERATOR_x = BOXED_qualifier.iterator();
        /*@NonNull*/ /*@Thrown*/ Boolean exists;
        while (true) {
            if (!ITERATOR_x.hasNext()) {
                exists = ValuesUtil.FALSE_VALUE;
                break;
            }
            /*@Nullable*/ /*@NonInvalid*/ String x = (String)ITERATOR_x.next();
            /**
             * x = 'composite'
             */
            final /*@NonNull*/ /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(x, STR_composite);
            //
            if (eq != ValuesUtil.FALSE_VALUE) {			// Carry on till something found
                exists = ValuesUtil.TRUE_VALUE;			// Abort after a find
                break;
            }
        }
        return exists;
    }
}
