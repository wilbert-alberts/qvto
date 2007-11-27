package org.eclipse.m2m.qvt.oml.editor.ui.completion;

import org.eclipse.m2m.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalFileEnv;
import org.eclipse.m2m.qvt.oml.compiler.ParsedModuleCS;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.QvtOperationalVisitorCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingMethodCS;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.parser.OCLLexer;
import org.eclipse.ocl.utilities.ASTNode;

/**
 * @author aigdalov
 * Created on Nov 7, 2007
 */
public class QvtCompletionVisitorCS extends QvtOperationalVisitorCS {
    private final QvtCompletionData myData;
    private QvtOperationalEnv myEnv; 

    public QvtCompletionVisitorCS(
            OCLLexer lexStream,
            QvtOperationalFileEnv environment,
            QvtCompilerOptions options,
            QvtCompletionData data) {
        super(lexStream, environment, options);
        myData = data;
        myEnv = environment;
    }

    public QvtOperationalEnv getEnv() {
        return myEnv;
    }
    
    @Override
    public Module visitMappingModule(ParsedModuleCS parsedModuleCS, QvtOperationalFileEnv env, QvtCompiler compiler) throws SemanticException {
        myEnv = env;
        return super.visitMappingModule(parsedModuleCS, env, compiler);
    }

    @Override
    protected void visitMappingMethodCS(MappingMethodCS methodCS, QvtOperationalEnv env, ImperativeOperation operation) throws SemanticException {
        if ((methodCS.getMappingDeclarationCS() != null) && !methodCS.getMappingDeclarationCS().isBlackBox()) {
            super.visitMappingMethodCS(methodCS, env, operation);
            ASTNode astNode = ASTBindingHelper.resolveASTNode(methodCS);
            if (astNode != null) {
                EcoreEnvironment resolvedEnvironment = ASTBindingHelper.resolveEnvironment(astNode);
                if (resolvedEnvironment instanceof QvtOperationalEnv) {
                    myEnv = (QvtOperationalEnv) resolvedEnvironment;
                }
            }
        }
    }
}