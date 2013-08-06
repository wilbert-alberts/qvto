package org.eclipse.qvto.examples.build.xtend;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.pivot.CollectionType;
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
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.qvto.examples.build.utlities.IContainmentVisitsGeneratorCtx;
import org.eclipse.qvto.examples.build.utlities.QVToGenModelHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
    Type _type = astProperty.getType();
    boolean _isMany = this.isMany(_type);
    if (_isMany) {
      String _createMultivaluedPropertyStub = this.createMultivaluedPropertyStub(astProperty, initExp);
      result.append(_createMultivaluedPropertyStub);
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
    String _name = astType.getName();
    boolean _equals = Objects.equal(_name, "String");
    if (_equals) {
      return "String";
    }
    Type type = null;
    if ((astType instanceof CollectionType)) {
      Type _elementType = ((CollectionType) astType).getElementType();
      type = _elementType;
    } else {
      type = astType;
    }
    Type _type = PivotUtil.getType(type);
    return this.genModelHelper.getQualifiedInterfaceName(_type);
  }
  
  private String createMonovaluedPropertyStub(final Property astProperty, final OCLExpression initExp) {
    StringBuilder _stringBuilder = new StringBuilder();
    StringBuilder result = _stringBuilder;
    String _name = astProperty.getName();
    String propertyName = StringExtensions.toFirstUpper(_name);
    Type _type = astProperty.getType();
    String propertyTypeName = _type.getName();
    Type _type_1 = astProperty.getType();
    String propertyTypeQName = this.getTypeQualifiedName(_type_1);
    Type _type_2 = initExp.getType();
    String initExpTypeName = _type_2.getName();
    Type _type_3 = initExp.getType();
    String initExpTypeQName = this.getTypeQualifiedName(_type_3);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// AS ");
    _builder.append(propertyName, "");
    _builder.append(" property update");
    _builder.newLineIfNotEmpty();
    _builder.append(initExpTypeQName, "");
    _builder.append(" newCs");
    _builder.append(initExpTypeName, "");
    _builder.append(" = ");
    String _accept = initExp.<String>accept(this);
    _builder.append(_accept, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append(propertyTypeQName, "");
    _builder.append(" new");
    _builder.append(propertyName, "");
    _builder.append(" = ");
    String _aSfromCSStub = this.getASfromCSStub(astProperty, initExp);
    _builder.append(_aSfromCSStub, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    result.append(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(propertyTypeQName, "");
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
  
  private String createMultivaluedPropertyStub(final Property astProperty, final OCLExpression initExp) {
    StringBuilder _stringBuilder = new StringBuilder();
    StringBuilder result = _stringBuilder;
    String _name = astProperty.getName();
    String propertyName = StringExtensions.toFirstUpper(_name);
    Type _type = astProperty.getType();
    String propertyTypeName = _type.getName();
    Type _type_1 = astProperty.getType();
    String propertyTypeQName = this.getTypeQualifiedName(_type_1);
    Type _type_2 = initExp.getType();
    String initExpTypeName = _type_2.getName();
    Type _type_3 = initExp.getType();
    String initExpTypeQName = this.getTypeQualifiedName(_type_3);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// AS ");
    _builder.append(propertyName, "");
    _builder.append(" property update");
    _builder.newLineIfNotEmpty();
    result.append(_builder);
    Type _type_4 = initExp.getType();
    boolean _isMany = this.isMany(_type_4);
    if (_isMany) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("List<");
      _builder_1.append(initExpTypeQName, "");
      _builder_1.append("> newCs");
      _builder_1.append(initExpTypeName, "");
      _builder_1.append("s = ");
      String _accept = initExp.<String>accept(this);
      _builder_1.append(_accept, "");
      _builder_1.append(";");
      _builder_1.newLineIfNotEmpty();
      result.append(_builder_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("List<");
      _builder_2.append(propertyTypeQName, "");
      _builder_2.append("> new");
      _builder_2.append(propertyName, "");
      _builder_2.append("s= new ArrayList<");
      _builder_2.append(propertyTypeQName, "");
      _builder_2.append(">();");
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("for (");
      _builder_2.append(initExpTypeQName, "");
      _builder_2.append(" newCs");
      _builder_2.append(initExpTypeName, "");
      _builder_2.append(" : newCs");
      _builder_2.append(initExpTypeName, "");
      _builder_2.append("s) {");
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("\t");
      _builder_2.append(propertyTypeQName, "	");
      _builder_2.append(" new");
      _builder_2.append(propertyName, "	");
      _builder_2.append(" = ");
      String _aSfromCSStub = this.getASfromCSStub(astProperty, initExp);
      _builder_2.append(_aSfromCSStub, "	");
      _builder_2.append(";");
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("\t");
      _builder_2.append("if (new");
      _builder_2.append(propertyName, "	");
      _builder_2.append(" != null) {");
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("\t\t");
      _builder_2.append("new");
      _builder_2.append(propertyName, "		");
      _builder_2.append("s.add(new");
      _builder_2.append(propertyName, "		");
      _builder_2.append(");");
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      result.append(_builder_2);
    } else {
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append(initExpTypeQName, "");
      _builder_3.append(" newCs");
      _builder_3.append(initExpTypeName, "");
      _builder_3.append(" = ");
      String _accept_1 = initExp.<String>accept(this);
      _builder_3.append(_accept_1, "");
      _builder_3.append(";");
      _builder_3.newLineIfNotEmpty();
      _builder_3.append(propertyTypeQName, "");
      _builder_3.append(" new");
      _builder_3.append(propertyName, "");
      _builder_3.append("s = new ArrayList<");
      _builder_3.append(propertyTypeQName, "");
      _builder_3.append(">();");
      _builder_3.newLineIfNotEmpty();
      _builder_3.append(propertyTypeQName, "");
      _builder_3.append(" new");
      _builder_3.append(propertyName, "");
      _builder_3.append("s.add(");
      String _aSfromCSStub_1 = this.getASfromCSStub(astProperty, initExp);
      _builder_3.append(_aSfromCSStub_1, "");
      _builder_3.append(");");
      _builder_3.newLineIfNotEmpty();
      result.append(_builder_3);
    }
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("List<");
    _builder_4.append(propertyTypeQName, "");
    _builder_4.append("> old");
    _builder_4.append(propertyName, "");
    _builder_4.append("s = asElement.get");
    _builder_4.append(propertyName, "");
    _builder_4.append("();");
    _builder_4.newLineIfNotEmpty();
    result.append(_builder_4);
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("PivotUtil.refreshList(old");
    _builder_5.append(propertyName, "");
    _builder_5.append("s, new");
    _builder_5.append(propertyName, "");
    _builder_5.append("s);");
    _builder_5.newLineIfNotEmpty();
    result.append(_builder_5);
    return result.toString();
  }
  
  private boolean isMany(final Type type) {
    if ((type instanceof CollectionType)) {
      return true;
    } else {
      return false;
    }
  }
  
  private String getASfromCSStub(final Property astProperty, final OCLExpression initExp) {
    Type _type = astProperty.getType();
    String propertyTypeQName = this.getTypeQualifiedName(_type);
    Type _type_1 = initExp.getType();
    String initExpType = _type_1.getName();
    Type type = initExp.getType();
    if ((type instanceof CollectionType)) {
      Type _elementType = ((CollectionType) type).getElementType();
      type = _elementType;
    }
    MetaModelManager _metamodelManager = this.context.getMetamodelManager();
    Iterable<? extends DomainType> _allSuperClasses = _metamodelManager.getAllSuperClasses(type);
    final Function1<DomainType,Boolean> _function = new Function1<DomainType,Boolean>() {
        public Boolean apply(final DomainType it) {
          String _name = it.getName();
          boolean _equals = Objects.equal(_name, "Pivotable");
          return Boolean.valueOf(_equals);
        }
      };
    boolean isPivotable = IterableExtensions.exists(_allSuperClasses, _function);
    if (isPivotable) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PivotUtil.getPivot(");
      _builder.append(propertyTypeQName, "");
      _builder.append(".class, newCs");
      _builder.append(initExpType, "");
      return _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("newCs");
      _builder_1.append(initExpType, "");
      return _builder_1.toString();
    }
  }
}
