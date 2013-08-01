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
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
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
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCLStandaloneSetup;
import org.eclipse.qvto.examples.build.utlities.ContainmentVisitsGeneratorCtx;
import org.eclipse.qvto.examples.build.xtend.ContainmentVisitsGenerator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class GenerateCS2ASVisitors extends org.eclipse.ocl.examples.build.xtend.GenerateCS2ASVisitors {
  private String asGenModelURI;
  
  public void generateVisitors(final EPackage csPackage) {
    super.generateVisitors(csPackage);
    boolean _isDerived = this.isDerived();
    if (_isDerived) {
      this.generateContainmentVisitor(csPackage);
      this.generatePreOrderVisitor(csPackage);
      this.generatePostOrderVisitor(csPackage);
      this.generateLeft2RightVisitor(csPackage);
    }
  }
  
  public void generateContainmentVisitor(@NonNull final EPackage csPackage) {
    String visitorVariantName = "Containment";
    String resultTypeName = "Continuation<?>";
    String _plus = (this.projectPrefix + visitorVariantName);
    String visitorVariantClassName = (_plus + "Visitor");
    String _plus_1 = (this.superProjectPrefix + visitorVariantName);
    String variantExtendedClass = (_plus_1 + "Visitor");
    String _plus_2 = (this.visitorClassName + "<");
    String _plus_3 = (_plus_2 + resultTypeName);
    String interfaceName = (_plus_3 + ">");
    List<String> additionalImports = null;
    ArrayList<String> _arrayList = new ArrayList<String>();
    additionalImports = _arrayList;
    String _name = Continuation.class.getName();
    additionalImports.add(_name);
    this.generateContainmentVisitor(csPackage, visitorVariantClassName, variantExtendedClass, interfaceName, resultTypeName, additionalImports);
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
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.Nullable;");
      _builder.newLine();
      _builder.append("import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;");
      _builder.newLine();
      _builder.append("import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;");
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
              String _generateContainmentVisit = this.generateContainmentVisit(eClass);
              _builder.append(_generateContainmentVisit, "	");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t");
              _builder.append("throw new UnsupportedOperationException(\"visit");
              String _name_2 = eClass.getName();
              _builder.append(_name_2, "	");
              _builder.append(" not supported in ");
              _builder.append(className, "	");
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
      String _name = operation.getName();
      boolean _equals = Objects.equal(_name, "ast");
      if (_equals) {
        return true;
      }
    }
    return false;
  }
  
  private String generateContainmentVisit(final EClass eClass) {
    OCLstdlib.install();
    EssentialOCLStandaloneSetup.doSetup();
    MetaModelManager metaModelManager = MetaModelManager.getAdapter(this.resourceSet);
    Resource ecoreResource = eClass.eResource();
    Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreResource, metaModelManager);
    org.eclipse.ocl.examples.pivot.Class pClass = ecore2Pivot.<org.eclipse.ocl.examples.pivot.Class>getPivotElement(org.eclipse.ocl.examples.pivot.Class.class, eClass);
    boolean _notEquals = (!Objects.equal(pClass, null));
    if (_notEquals) {
      List<Operation> _ownedOperation = pClass.getOwnedOperation();
      for (final Operation operation : _ownedOperation) {
        String _name = operation.getName();
        boolean _equals = "ast".equals(_name);
        if (_equals) {
          OpaqueExpression opaqueExp = operation.getBodyExpression();
          ExpressionInOCL expInOcl = PivotUtil.getExpressionInOCL(operation, opaqueExp);
          String _plus = ("/" + this.projectName);
          String _plus_1 = (_plus + "/");
          URI projectResourceURI = URI.createPlatformResourceURI(_plus_1, true);
          URI _createURI = URI.createURI(this.genModelFile);
          URI genModelURI = _createURI.resolve(projectResourceURI);
          GenModel sourceGenModel = this.getGenModel(genModelURI, this.resourceSet);
          String _aSGenModelURI = this.getASGenModelURI();
          URI _createURI_1 = URI.createURI(_aSGenModelURI);
          GenModel targetGenModel = this.getGenModel(_createURI_1, this.resourceSet);
          OCLExpression _bodyExpression = expInOcl.getBodyExpression();
          ContainmentVisitsGeneratorCtx _containmentVisitsGeneratorCtx = new ContainmentVisitsGeneratorCtx(sourceGenModel, targetGenModel);
          ContainmentVisitsGenerator _containmentVisitsGenerator = new ContainmentVisitsGenerator(_containmentVisitsGeneratorCtx);
          return _bodyExpression.<String>accept(_containmentVisitsGenerator);
        }
      }
    }
    return "return null;";
  }
  
  private GenModel getGenModel(final URI genModelURI, final ResourceSet rSet) {
    Resource genModelResource = this.resourceSet.getResource(genModelURI, true);
    EList<EObject> _contents = genModelResource.getContents();
    EObject _get = _contents.get(0);
    return ((GenModel) _get);
  }
  
  public String setASGenModelURI(final String asGenModelURI) {
    String _asGenModelURI = this.asGenModelURI = asGenModelURI;
    return _asGenModelURI;
  }
  
  protected String getASGenModelURI() {
    return this.asGenModelURI;
  }
}
