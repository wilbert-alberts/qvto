/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalFileEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalVisitorCS;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.ExternalUnitElementsProvider;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.AbstractQVTParser;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.utilities.ASTNode;

/**
 * @author aigdalov
 * Created on Nov 7, 2007
 */
public class QvtCompletionVisitorCS extends QvtOperationalVisitorCS {
    private QvtOperationalEnv myEnv; 

    public QvtCompletionVisitorCS(
            AbstractQVTParser parser,
            QvtCompilerOptions options) {
        super(parser, options);
        myEnv = (QvtOperationalEnv) parser.getEnvironment();
    }

    protected void setEnv(QvtOperationalEnv env) {
    	myEnv = env;
    }
    
    public QvtOperationalEnv getEnv() {
        return myEnv;
    }
    
    @Override
    public Module visitMappingModule(MappingModuleCS moduleCS, URI unitURI, QvtOperationalFileEnv env, ExternalUnitElementsProvider importResolver, ResourceSet resSet) throws SemanticException {
        setEnv(env);
        return super.visitMappingModule(moduleCS, unitURI, env, importResolver, resSet);
    }

    @Override
    protected void visitMappingMethodCS(MappingMethodCS methodCS, QvtOperationalEnv env, ImperativeOperation operation) throws SemanticException {
        if ((methodCS.getMappingDeclarationCS() != null) && !methodCS.isBlackBox()) {
            super.visitMappingMethodCS(methodCS, env, operation);
            ASTNode astNode = ASTBindingHelper.resolveASTNode(methodCS);
            if (astNode != null) {
                EcoreEnvironment resolvedEnvironment = ASTBindingHelper.resolveEnvironment(astNode);
                if (resolvedEnvironment instanceof QvtOperationalEnv) {
                    setEnv((QvtOperationalEnv) resolvedEnvironment);
                }
            }
        }
    }
}