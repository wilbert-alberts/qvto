package org.eclipse.m2m.qvt.oml.internal.cst.adapters;

import java.text.MessageFormat;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.internal.cst.parser.QvtOpLexer;
import org.eclipse.ocl.internal.cst.CSTNode;

/**
 * @author aigdalov
 */

public class CSTBindingUtil {
    public static final void bindQvtOperationalEnv(CSTNode cstNode, QvtOperationalEnv env) {
        QvtOperationalEnvAdapter qvtOperationalEnvAdapter = new QvtOperationalEnvAdapter();
        qvtOperationalEnvAdapter.setObject(env);
        cstNode.eAdapters().add(qvtOperationalEnvAdapter);
    }
    
    public static final QvtOperationalEnv getQvtOperationalEnv(CSTNode cstNode) {
        EObject tempCSTNode = cstNode;
        while (tempCSTNode != null) {
            QvtOperationalEnv qvtOperationalEnv =  getQvtOperationalEnvInternal(tempCSTNode);
            if (qvtOperationalEnv != null) {
                return qvtOperationalEnv;
            }
            tempCSTNode = tempCSTNode.eContainer();
        }
        return null;
    }
    
    private static QvtOperationalEnv getQvtOperationalEnvInternal(EObject cstNode) {
        for (Adapter adapter : cstNode.eAdapters()) {
            if (adapter instanceof QvtOperationalEnvAdapter) {
                return ((QvtOperationalEnvAdapter) adapter).getObject();
            }
        }
         return null;
    }
    
    public static final void bindQvtOpLexer(CSTNode cstNode, QvtOpLexer qvtOpLexer) {
        QvtOpLexerAdapter qvtOpLexerAdapter = new QvtOpLexerAdapter();
        qvtOpLexerAdapter.setObject(qvtOpLexer);
        cstNode.eAdapters().add(qvtOpLexerAdapter);
    }
    
    public static final QvtOpLexer getQvtOpLexer(CSTNode cstNode) {
        for (Adapter adapter : cstNode.eAdapters()) {
            if (adapter instanceof QvtOpLexerAdapter) {
                return ((QvtOpLexerAdapter) adapter).getObject();
            }
        }
        throw new RuntimeException(MessageFormat.format("QvtOpLexer for CSTNode {0} not found!", new Object[] {cstNode.toString()})); //$NON-NLS-1$
    }
}