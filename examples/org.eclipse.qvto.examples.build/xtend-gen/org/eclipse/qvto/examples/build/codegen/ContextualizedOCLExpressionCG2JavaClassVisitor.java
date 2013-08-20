/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvto.examples.build.codegen;

import com.google.common.base.Objects;
import java.util.List;
import java.util.Set;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * A CG2JavaClassVisitor supports generation of an OCL expression as the LibraryOperation INSTANCE of a Java Class.
 */
@SuppressWarnings("all")
public class ContextualizedOCLExpressionCG2JavaClassVisitor extends CG2JavaVisitor {
  @NonNull
  protected final OCLExpression oclExp;
  
  @Nullable
  protected final List<CGValuedElement> sortedGlobals;
  
  public ContextualizedOCLExpressionCG2JavaClassVisitor(@NonNull final JavaCodeGenerator codeGenerator, @NonNull final OCLExpression expInOcl, @Nullable final List<CGValuedElement> sortedGlobals) {
    super(codeGenerator);
    this.oclExp = expInOcl;
    this.sortedGlobals = sortedGlobals;
  }
  
  @NonNull
  public Set<String> getAllImports() {
    return this.globalContext.getImports();
  }
  
  @Nullable
  public Object visitCGClass(@NonNull final CGClass cgClass) {
    String className = cgClass.getName();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@SuppressWarnings(\"nls\")");
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(className, "");
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    this.js.append(_builder.toString());
    this.js.pushIndentation(null);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("public static final");
    this.js.append(_builder_1.toString());
    this.js.appendIsRequired(true);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append(" ");
    _builder_2.append(className, " ");
    _builder_2.append(" ");
    String _instanceName = this.globalContext.getInstanceName();
    _builder_2.append(_instanceName, " ");
    _builder_2.append(" = new ");
    _builder_2.append(className, " ");
    _builder_2.append("();");
    _builder_2.newLineIfNotEmpty();
    this.js.append(_builder_2.toString());
    boolean _notEquals = (!Objects.equal(this.sortedGlobals, null));
    if (_notEquals) {
      this.generateGlobals(this.sortedGlobals);
    }
    this.js.append("\n");
    List<CGOperation> _operations = cgClass.getOperations();
    for (final CGOperation cgOperation : _operations) {
      cgOperation.<Object>accept(this);
    }
    this.js.popIndentation();
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("}");
    _builder_3.newLine();
    this.js.append(_builder_3.toString());
    return null;
  }
  
  @Nullable
  public Object visitCGOperation(@NonNull final CGOperation cgOperation) {
    JavaLocalContext localContext2 = this.globalContext.getLocalContext(cgOperation);
    boolean _notEquals = (!Objects.equal(localContext2, null));
    if (_notEquals) {
      this.localContext = localContext2;
      try {
        List<CGParameter> cgParameters = cgOperation.getParameters();
        CGValuedElement _body = cgOperation.getBody();
        CGValuedElement body = this.getExpression(_body);
        this.js.append("public ");
        boolean _isNull = cgOperation.isNull();
        if (_isNull) {
          this.js.append("/*@Null*/");
        } else {
          boolean _isRequired = cgOperation.isRequired();
          this.js.appendIsRequired(_isRequired);
        }
        this.js.append(" ");
        boolean _isInvalid = cgOperation.isInvalid();
        boolean _not = (!_isInvalid);
        boolean _isInvalid_1 = cgOperation.isInvalid();
        this.js.appendIsCaught(_not, _isInvalid_1);
        this.js.append(" ");
        this.js.appendClassReference(cgOperation);
        this.js.append(" ");
        String _name = cgOperation.getName();
        this.js.append(_name);
        this.js.append("(");
        boolean isFirst = true;
        for (final CGParameter cgParameter : cgParameters) {
          {
            boolean _not_1 = (!isFirst);
            if (_not_1) {
              this.js.append(", ");
            }
            this.js.appendDeclaration(cgParameter);
            isFirst = false;
          }
        }
        this.js.append(") {\n");
        this.js.pushIndentation(null);
        this.appendReturn(body);
        this.js.popIndentation();
        this.js.append("}\n");
      } finally {
        this.localContext = null;
      }
    }
    return null;
  }
}
