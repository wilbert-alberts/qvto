/*
 * «codeGenHelper.getCopyright(' * ')»
 *************************************************************************
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 */

package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.evaluators;

import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage;

@SuppressWarnings("nls")
public class MetamodelCS_AST_Part2
{
    public static final/*@NonNull*/ MetamodelCS_AST_Part2 INSTANCE = new MetamodelCS_AST_Part2();
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/pivot/1.0/QVTOperationalCS", QVTOperationalCSPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MetamodelCS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS.getClassId("MetamodelCS", 0);
    
    public /*@Nullable*/ /*@NonInvalid*/ String evaluate(final /*@NonNull*/ /*@NonInvalid*/ DomainEvaluator evaluator, final /*@NonNull*/ /*@NonInvalid*/ TypeId typeId, final /*@NonNull*/ /*@NonInvalid*/ MetamodelCS self) {
        final /*@NonNull*/ /*@Thrown*/ String name = self.getName();
        return name;
    }
}
