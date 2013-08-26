/*
 * «codeGenHelper.getCopyright(' * ')»
 *************************************************************************
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 */

package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.evaluators;

import java.util.List;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationSimpleSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage;

@SuppressWarnings("nls")
public class MappingOperationCS_AST_Part1
{
    public static final/*@NonNull*/ MappingOperationCS_AST_Part1 INSTANCE = new MappingOperationCS_AST_Part1();
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/pivot/1.0/QVTOperationalCS", QVTOperationalCSPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MappingOperationCS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS.getClassId("MappingOperationCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OperationParameterDeclarationCS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS.getClassId("OperationParameterDeclarationCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OperationSimpleSignatureCS = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_pivot_s_1_0_s_QVTOperationalCS.getClassId("OperationSimpleSignatureCS", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_OperationParameterDeclarationCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OperationParameterDeclarationCS);
    
    public /*@Nullable*/ /*@NonInvalid*/ List<OperationParameterDeclarationCS> evaluate(final /*@NonNull*/ /*@NonInvalid*/ DomainEvaluator evaluator, final /*@NonNull*/ /*@NonInvalid*/ TypeId typeId, final /*@NonNull*/ /*@NonInvalid*/ MappingOperationCS self) {
        final /*@NonNull*/ /*@Thrown*/ OperationSimpleSignatureCS signature = self.getSignature();
        final /*@NonNull*/ /*@Thrown*/ List<OperationParameterDeclarationCS> parameter = signature.getParameter();
        return parameter;
    }
}
