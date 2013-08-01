package org.eclipse.qvto.examples.build.xtend;

import java.util.List;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.qvto.examples.build.utlities.IContainmentVisitsGeneratorCtx;
import org.eclipse.qvto.examples.build.utlities.QVToGenModelHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ContainmentVisitsGenerator extends AbstractExtendingVisitor<String,IContainmentVisitsGeneratorCtx> {
  private QVToGenModelHelper genModelHelper;
  
  public ContainmentVisitsGenerator(final IContainmentVisitsGeneratorCtx context) {
    super(context);
    MetaModelManager _metamodelManager = context.getMetamodelManager();
    QVToGenModelHelper _qVToGenModelHelper = new QVToGenModelHelper(_metamodelManager);
    this.genModelHelper = _qVToGenModelHelper;
  }
  
  public String visiting(final Visitable visitable) {
    return "return null;";
  }
  
  public String visitConstructorExp(final ConstructorExp object) {
    StringBuilder _stringBuilder = new StringBuilder();
    StringBuilder result = _stringBuilder;
    Type astType = object.getType();
    String typeQN = this.getTypeQualifiedName(astType);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("CS2Pivot converter = context.getConverter();");
    _builder.newLine();
    _builder.append("// AS element creation");
    _builder.newLine();
    _builder.append(typeQN, "");
    _builder.append(" asElement = csElement != null ? (");
    _builder.append(typeQN, "");
    _builder.append(") converter.getPivotElement(csElement) : null;");
    _builder.newLineIfNotEmpty();
    _builder.append("if (asElement == null) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("asElement = ");
    String _factoryInstanceName = this.getFactoryInstanceName(astType);
    _builder.append(_factoryInstanceName, "	");
    _builder.append(".create");
    String _name = astType.getName();
    _builder.append(_name, "	");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("converter.installPivotDefinition(csElement, asElement);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    result.append(_builder);
    List<ConstructorPart> _part = object.getPart();
    for (final ConstructorPart part : _part) {
      String _accept = part.<String>accept(this);
      result.append(_accept);
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("// AS element comments update");
    _builder_1.newLine();
    _builder_1.append("context.refreshComments(asElement, csElement);");
    _builder_1.newLine();
    result.append(_builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("return null;");
    result.append(_builder_2);
    return result.toString();
  }
  
  public String visitConstructorPart(final ConstructorPart object) {
    StringBuilder _stringBuilder = new StringBuilder();
    StringBuilder result = _stringBuilder;
    Property astProperty = object.getReferredProperty();
    OCLExpression initExp = object.getInitExpression();
    boolean _isMany = astProperty.isMany();
    if (_isMany) {
    } else {
      String _createMonovaluedPropertyStub = this.createMonovaluedPropertyStub(astProperty, initExp);
      result.append(_createMonovaluedPropertyStub);
    }
    return result.toString();
  }
  
  public String visitPropertyCallExp(final PropertyCallExp object) {
    StringBuilder _stringBuilder = new StringBuilder();
    StringBuilder result = _stringBuilder;
    Property csProperty = object.getReferredProperty();
    String _name = csProperty.getName();
    String propertyName = StringExtensions.toFirstUpper(_name);
    StringConcatenation _builder = new StringConcatenation();
    OCLExpression _source = object.getSource();
    String _accept = _source.<String>accept(this);
    _builder.append(_accept, "");
    _builder.append(".get");
    _builder.append(propertyName, "");
    _builder.append("()");
    result.append(_builder);
    return result.toString();
  }
  
  public String visitVariableExp(final VariableExp object) {
    VariableDeclaration _referredVariable = object.getReferredVariable();
    return _referredVariable.<String>accept(this);
  }
  
  public String visitVariable(final Variable object) {
    String _xifexpression = null;
    String _name = object.getName();
    boolean _equals = "self".equals(_name);
    if (_equals) {
      _xifexpression = "csElement";
    } else {
      String _name_1 = object.getName();
      _xifexpression = _name_1;
    }
    return _xifexpression;
  }
  
  private String getFactoryInstanceName(final Type astType) {
    return this.genModelHelper.getQualifiedFactoryInstanceAccessor(astType);
  }
  
  private String getTypeQualifiedName(final Type astType) {
    return this.genModelHelper.getQualifiedInterfaceName(astType);
  }
  
  private String createMonovaluedPropertyStub(final Property astProperty, final OCLExpression initExp) {
    StringBuilder _stringBuilder = new StringBuilder();
    StringBuilder result = _stringBuilder;
    String _name = astProperty.getName();
    String propertyName = StringExtensions.toFirstUpper(_name);
    Type _type = astProperty.getType();
    String propertyType = _type.getName();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// AS ");
    _builder.append(propertyName, "");
    _builder.append(" property update");
    _builder.newLineIfNotEmpty();
    _builder.append(propertyType, "");
    _builder.append(" new");
    _builder.append(propertyName, "");
    _builder.append(" = ");
    String _accept = initExp.<String>accept(this);
    _builder.append(_accept, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    result.append(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(propertyType, "");
    _builder_1.append(" old");
    _builder_1.append(propertyName, "");
    _builder_1.append(" = asElement.get");
    _builder_1.append(propertyName, "");
    _builder_1.append("();");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("if ((new");
    _builder_1.append(propertyName, "");
    _builder_1.append(" != old");
    _builder_1.append(propertyName, "");
    _builder_1.append(") && ((new");
    _builder_1.append(propertyName, "");
    _builder_1.append(" == null) || !new");
    _builder_1.append(propertyName, "");
    _builder_1.append(".equals(old");
    _builder_1.append(propertyName, "");
    _builder_1.append("))) {");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("asElement.set");
    _builder_1.append(propertyName, "	");
    _builder_1.append("(new");
    _builder_1.append(propertyName, "	");
    _builder_1.append(");");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("}");
    _builder_1.newLine();
    result.append(_builder_1);
    return result.toString();
  }
}
