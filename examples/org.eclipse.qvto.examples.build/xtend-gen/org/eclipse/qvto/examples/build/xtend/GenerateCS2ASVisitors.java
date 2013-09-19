/**
 * <copyright>
 * 
 * Copyright (c) 2013 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvto.examples.build.xtend;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.autogen.java.AutoCodeGenerator;
import org.eclipse.ocl.examples.build.xtend.GenerateVisitors;
import org.eclipse.ocl.examples.build.xtend.MergeWriter;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCLStandaloneSetup;
import org.eclipse.qvto.examples.build.utlities.CS2ASGeneratorUtil;
import org.eclipse.qvto.examples.build.utlities.ContainmentVisitsGeneratorCtx;
import org.eclipse.qvto.examples.build.xtend.ContainmentVisitsGenerator;
import org.eclipse.qvto.examples.xtext.imperativeocl.ImperativeOCLStandaloneSetup;
import org.eclipse.qvto.examples.xtext.qvtoperational.QVTOperationalStandaloneSetup;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class GenerateCS2ASVisitors extends org.eclipse.ocl.examples.build.xtend.GenerateCS2ASVisitors {
  @Override
  protected void doSetup() {
    EssentialOCLStandaloneSetup.doSetup();
    ImperativeOCLStandaloneSetup.doSetup();
    QVTOperationalStandaloneSetup.doSetup();
    OCLstdlib.install();
  }
  
  public void generateVisitors(final GenPackage genPackage) {
    super.generateVisitors(genPackage);
    EPackage csPackage = genPackage.getEcorePackage();
    this.generateAbstractExtendingDelegatingVisitor(csPackage);
  }
  
  public void generateContainmentVisitor(@NonNull final GenPackage genPackage) {
    boolean _isDerived = this.isDerived();
    if (_isDerived) {
      AutoCodeGenerator.generate(genPackage, this.projectPrefix, this.visitorPackageName, this.visitorClassName, 
        this.superProjectPrefix, this.superVisitorPackageName, this.superVisitorClassName);
    } else {
      AutoCodeGenerator.generate(genPackage, this.projectPrefix, this.visitorPackageName, this.visitorClassName, 
        null, null, null);
    }
  }
  
  /**
   * TODO When fully generation is achieved, visitAbstractConcept method needs to be qualified as follows:
   *     visitAbstractElement(Abstract object) {
   *       throw new UnsupportedOperationException();
   *     }
   */
  protected void generateContainmentVisitor(@NonNull final EPackage ePackage, @NonNull final String className, @NonNull final String extendedClassName, @NonNull final String interfaceName, @NonNull final String resultTypeName, @NonNull final List<String> additionalImports) {
    try {
      String _plus = (this.outputFolder + className);
      String _plus_1 = (_plus + ".java");
      MergeWriter _mergeWriter = new MergeWriter(_plus_1);
      MergeWriter writer = _mergeWriter;
      StringConcatenation _builder = new StringConcatenation();
      String _generateHeader = this.generateHeader(ePackage, this.visitorPackageName);
      _builder.append(_generateHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import java.util.ArrayList;");
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.Nullable;");
      _builder.newLine();
      _builder.append("import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;");
      _builder.newLine();
      _builder.append("import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;");
      _builder.newLine();
      _builder.append("import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;");
      _builder.newLine();
      _builder.append("import ");
      _builder.append(this.superProjectName, "");
      _builder.append(".cs2as.");
      _builder.append(extendedClassName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      {
        for(final String additionalImport : additionalImports) {
          _builder.append("import ");
          _builder.append(additionalImport, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(className, "");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("extends ");
      _builder.append(extendedClassName, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("implements ");
      _builder.append(interfaceName, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* Initializes me with an initial value for my result.");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* ");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param context my initial result value");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(className, "	");
      _builder.append("(@NonNull CS2PivotConversion context) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(context);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      {
        List<EClass> _sortedEClasses = GenerateVisitors.getSortedEClasses(ePackage);
        for(final EClass eClass : _sortedEClasses) {
          _builder.append("\t");
          _builder.append("public @Nullable ");
          _builder.append(resultTypeName, "	");
          _builder.append(" visit");
          String _name = eClass.getName();
          _builder.append(_name, "	");
          _builder.append("(@NonNull ");
          _builder.append(this.modelPackageName, "	");
          _builder.append(".");
          String _name_1 = eClass.getName();
          _builder.append(_name_1, "	");
          _builder.append(" csElement) {");
          _builder.newLineIfNotEmpty();
          {
            boolean _hasAstOperation = this.hasAstOperation(eClass);
            if (_hasAstOperation) {
              _builder.append("\t");
              _builder.append("\t");
              String _generateContainmentVisit = this.generateContainmentVisit(eClass);
              _builder.append(_generateContainmentVisit, "		");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("throw new UnsupportedOperationException(\"visit");
              String _name_2 = eClass.getName();
              _builder.append(_name_2, "		");
              _builder.append(" not supported in ");
              _builder.append(className, "		");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      writer.append(_builder.toString());
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private boolean hasAstOperation(final EClass eclass) {
    EList<EOperation> _eOperations = eclass.getEOperations();
    for (final EOperation operation : _eOperations) {
      boolean _isAstOperation = CS2ASGeneratorUtil.isAstOperation(operation);
      if (_isAstOperation) {
        return true;
      }
    }
    return false;
  }
  
  protected String generateContainmentVisit(final EClass eClass) {
    MetaModelManager metaModelManager = MetaModelManager.getAdapter(this.resourceSet);
    Resource ecoreResource = eClass.eResource();
    Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreResource, metaModelManager);
    org.eclipse.ocl.examples.pivot.Class pClass = ecore2Pivot.<org.eclipse.ocl.examples.pivot.Class>getPivotElement(org.eclipse.ocl.examples.pivot.Class.class, eClass);
    boolean _notEquals = (!Objects.equal(pClass, null));
    if (_notEquals) {
      List<Operation> _ownedOperation = pClass.getOwnedOperation();
      for (final Operation operation : _ownedOperation) {
        {
          EObject target = operation.getETarget();
          boolean _and = false;
          if (!(target instanceof EOperation)) {
            _and = false;
          } else {
            boolean _isAstOperation = CS2ASGeneratorUtil.isAstOperation(((EOperation) target));
            _and = ((target instanceof EOperation) && _isAstOperation);
          }
          if (_and) {
            OpaqueExpression opaqueExp = operation.getBodyExpression();
            ExpressionInOCL expInOcl = PivotUtil.getExpressionInOCL(operation, opaqueExp);
            OCLExpression _bodyExpression = expInOcl.getBodyExpression();
            ContainmentVisitsGeneratorCtx _containmentVisitsGeneratorCtx = new ContainmentVisitsGeneratorCtx(metaModelManager, this.outputFolder, this.visitorPackageName);
            ContainmentVisitsGenerator _containmentVisitsGenerator = new ContainmentVisitsGenerator(_containmentVisitsGeneratorCtx);
            return _bodyExpression.<String>accept(_containmentVisitsGenerator);
          }
        }
      }
    }
    return "return null;";
  }
}
