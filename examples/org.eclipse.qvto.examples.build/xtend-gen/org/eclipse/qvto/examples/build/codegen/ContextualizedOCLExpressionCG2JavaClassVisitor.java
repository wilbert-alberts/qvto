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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager.Context;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBuiltInIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.qvto.examples.build.utlities.CS2ASGeneratorUtil;
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
  
  @Nullable
  public Object visitCGBuiltInIterationCallExp(final CGBuiltInIterationCallExp cgIterationCallExp) {
    super.visitCGBuiltInIterationCallExp(cgIterationCallExp);
    CGValuedElement body = cgIterationCallExp.getBody();
    boolean _and = false;
    if (!(body instanceof CGEcoreOperationCallExp)) {
      _and = false;
    } else {
      boolean _isASTCallExp = this.isASTCallExp(((CGEcoreOperationCallExp) body));
      _and = ((body instanceof CGEcoreOperationCallExp) && _isASTCallExp);
    }
    if (_and) {
      this.interceptCollectASTCallExp(cgIterationCallExp);
    }
    return null;
  }
  
  @Nullable
  public Object visitCGEcoreOperationCallExp(final CGEcoreOperationCallExp cgOperationCallExp) {
    boolean _isASTCallExp = this.isASTCallExp(cgOperationCallExp);
    if (_isASTCallExp) {
      this.interceptASTCallExp(cgOperationCallExp);
    } else {
      super.visitCGEcoreOperationCallExp(cgOperationCallExp);
    }
    return null;
  }
  
  private Object interceptASTCallExp(final CGEcoreOperationCallExp cgOperationCallExp) {
    Operation pOperation = cgOperationCallExp.getReferredOperation();
    Type _owningType = pOperation.getOwningType();
    TypeId _typeId = _owningType.getTypeId();
    CGTypeId cgTypeId = this.analyzer.getTypeId(_typeId);
    ElementId _elementId = cgTypeId.getElementId();
    ElementId _nonNullState = DomainUtil.<ElementId>nonNullState(_elementId);
    TypeDescriptor requiredTypeDescriptor = this.context.getTypeDescriptor(_nonNullState, false);
    CGValuedElement _source = cgOperationCallExp.getSource();
    CGValuedElement source = this.getExpression(_source);
    this.js.appendLocalStatements(source);
    this.js.appendDeclaration(cgOperationCallExp);
    this.js.append(" = ");
    this.js.appendClassReference(PivotUtil.class);
    this.js.append(".getPivot(");
    this.js.appendClassReference(cgOperationCallExp);
    this.js.append(".class, ");
    this.js.appendAtomicReferenceTo(requiredTypeDescriptor, source);
    this.js.append(");\n");
    return null;
  }
  
  private Object interceptCollectASTCallExp(final CGBuiltInIterationCallExp cgIterationCallExp) {
    CGValuedElement _body = cgIterationCallExp.getBody();
    CGEcoreOperationCallExp body = ((CGEcoreOperationCallExp) _body);
    Operation pOperation = body.getReferredOperation();
    TypeId _typeId = pOperation.getTypeId();
    CGTypeId cgTypeId = this.analyzer.getTypeId(_typeId);
    ElementId _elementId = cgTypeId.getElementId();
    ElementId _nonNullState = DomainUtil.<ElementId>nonNullState(_elementId);
    TypeDescriptor requiredTypeDescriptor = this.context.getTypeDescriptor(_nonNullState, false);
    Context _nameManagerContext = this.localContext.getNameManagerContext();
    String _valueName = cgIterationCallExp.getValueName();
    String _plus = ("UNBOXED_" + _valueName);
    String newCollectionName = _nameManagerContext.getSymbolName(null, _plus);
    Context _nameManagerContext_1 = this.localContext.getNameManagerContext();
    String _valueName_1 = cgIterationCallExp.getValueName();
    String _plus_1 = ("UNBOXED_" + _valueName_1);
    String _plus_2 = (_plus_1 + "_element");
    String newCollectionElementName = _nameManagerContext_1.getSymbolName(null, _plus_2);
    this.js.appendClassReference(List.class, false, requiredTypeDescriptor);
    this.js.append(" ");
    this.js.append(newCollectionName);
    this.js.append(" = new ");
    this.js.appendClassReference(ArrayList.class, false, requiredTypeDescriptor);
    this.js.append("();\n");
    this.js.append("for (Object ");
    this.js.append(newCollectionElementName);
    this.js.append(" : ");
    this.js.appendValueName(cgIterationCallExp);
    this.js.append(")\n");
    this.js.pushIndentation(null);
    this.js.append(newCollectionName);
    this.js.append(".add((");
    this.js.appendClassReference(body);
    this.js.append(")");
    this.js.append(newCollectionElementName);
    this.js.append(");\n");
    this.js.popIndentation();
    this.js.append("}\n");
    cgIterationCallExp.setValueName(newCollectionName);
    return null;
  }
  
  private boolean isASTCallExp(final CGEcoreOperationCallExp cgOperationCallExp) {
    EOperation op = cgOperationCallExp.getEOperation();
    boolean _isAstOperation = CS2ASGeneratorUtil.isAstOperation(op);
    if (_isAstOperation) {
      return true;
    }
    return false;
  }
}
