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
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationSimpleSignatureCS;

@SuppressWarnings("nls")
public class MappingOperationCS_AST_Part1
{
    public static final/*@NonNull*/ MappingOperationCS_AST_Part1 INSTANCE = new MappingOperationCS_AST_Part1();
    
    public /*@Nullable*/ /*@NonInvalid*/ List<OperationParameterDeclarationCS> evaluate(final /*@NonNull*/ /*@NonInvalid*/ MappingOperationCS self) {
        final /*@NonNull*/ /*@Thrown*/ OperationSimpleSignatureCS signature = self.getSignature();
        final /*@NonNull*/ /*@Thrown*/ List<OperationParameterDeclarationCS> parameter = signature.getParameter();
        return parameter;
    }
}
