package org.eclipse.qvto.examples.build.xtend;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
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
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("visit");
    Class<? extends Visitable> _class = visitable.getClass();
    String _canonicalName = _class.getCanonicalName();
    _builder.append(_canonicalName, "");
    _builder.append(" not supported in ContainmentVisitsGenerator");
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException(_builder.toString());
    throw _unsupportedOperationException;
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
  
  public String visitIteratorExp(final IteratorExp object) {
    StringBuilder _stringBuilder = new StringBuilder();
    StringBuilder result = _stringBuilder;
    StringConcatenation _builder = new StringConcatenation();
    OCLExpression _source = object.getSource();
    String _accept = _source.<String>accept(this);
    _builder.append(_accept, "");
    _builder.append(".");
    result.append(_builder);
    Iteration iteration = object.getReferredIteration();
    CharSequence _switchResult = null;
    String _name = iteration.getName();
    final String _switchValue = _name;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,"exists")) {
        _matched=true;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("contains(");
        OCLExpression _body = object.getBody();
        String _accept_1 = _body.<String>accept(this);
        _builder_1.append(_accept_1, "");
        _builder_1.append(")");
        _switchResult = _builder_1;
      }
    }
    if (!_matched) {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("iterator \"");
      String _name_1 = iteration.getName();
      _builder_2.append(_name_1, "");
      _builder_2.append("\" not implemented yet in visitIterateExp in ContainmentVisitsGenerator");
      UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException(_builder_2.toString());
      throw _unsupportedOperationException;
    }
    result.append(_switchResult);
    return result.toString();
  }
  
  public String visitStringLiteralExp(final StringLiteralExp object) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"");
    String _stringSymbol = object.getStringSymbol();
    _builder.append(_stringSymbol, "");
    _builder.append("\"");
    return _builder.toString();
  }
  
  public String visitOperationCallExp(final OperationCallExp object) {
    String _xblockexpression = null;
    {
      String _name = object.getName();
      boolean _equals = Objects.equal(_name, "ast");
      if (_equals) {
        return "";
      }
      String _visitOperationCallExp = super.visitOperationCallExp(object);
      _xblockexpression = (_visitOperationCallExp);
    }
    return _xblockexpression;
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
    MetaModelManager mm = this.context.getMetamodelManager();
    String _xifexpression = null;
    Type _type = csProperty.getType();
    PrimitiveType _booleanType = mm.getBooleanType();
    boolean _conformsTo = mm.conformsTo(_type, _booleanType, null);
    if (_conformsTo) {
      String _plus = ("is" + propertyName);
      _xifexpression = _plus;
    } else {
      String _plus_1 = ("get" + propertyName);
      _xifexpression = _plus_1;
    }
    String methodName = _xifexpression;
    StringConcatenation _builder = new StringConcatenation();
    OCLExpression _source = object.getSource();
    String _accept = _source.<String>accept(this);
    _builder.append(_accept, "");
    _builder.append(".");
    _builder.append(methodName, "");
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
    StringBuilder _stringBuilder = new StringBuilder();
    StringBuilder result = _stringBuilder;
    String _name = astType.getName();
    boolean _equals = Objects.equal(_name, "String");
    if (_equals) {
      return "java.lang.String";
    }
    String _name_1 = astType.getName();
    boolean _equals_1 = Objects.equal(_name_1, "Boolean");
    if (_equals_1) {
      return "java.lang.Boolean";
    }
    if ((astType instanceof CollectionType)) {
      result.append("java.util.List<");
      Type _elementType = ((CollectionType) astType).getElementType();
      String _typeQualifiedName = this.getTypeQualifiedName(_elementType);
      result.append(_typeQualifiedName);
      result.append(">");
    } else {
      Type _type = PivotUtil.getType(astType);
      String _qualifiedInterfaceName = this.genModelHelper.getQualifiedInterfaceName(_type);
      result.append(_qualifiedInterfaceName);
    }
    return result.toString();
  }
  
  private String getTypeImplQualifiedName(final Type astType) {
    StringBuilder _stringBuilder = new StringBuilder();
    StringBuilder result = _stringBuilder;
    String _name = astType.getName();
    boolean _equals = Objects.equal(_name, "String");
    if (_equals) {
      return "java.lang.String";
    }
    String _name_1 = astType.getName();
    boolean _equals_1 = Objects.equal(_name_1, "Boolean");
    if (_equals_1) {
      return "java.lang.Boolean";
    }
    if ((astType instanceof CollectionType)) {
      result.append("java.util.ArrayList<");
      Type _elementType = ((CollectionType) astType).getElementType();
      String _typeQualifiedName = this.getTypeQualifiedName(_elementType);
      result.append(_typeQualifiedName);
      result.append(">");
    } else {
      Type _type = PivotUtil.getType(astType);
      String _qualifiedClassName = this.genModelHelper.getQualifiedClassName(_type);
      result.append(_qualifiedClassName);
    }
    return result.toString();
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
    _builder.append(propertyName, "");
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
    Type _type_2 = astProperty.getType();
    String propertyTypeImplQName = this.getTypeImplQualifiedName(_type_2);
    Type _type_3 = initExp.getType();
    String initExpTypeName = _type_3.getName();
    Type _type_4 = initExp.getType();
    String initExpTypeQName = this.getTypeQualifiedName(_type_4);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// AS ");
    _builder.append(propertyName, "");
    _builder.append(" property update");
    _builder.newLineIfNotEmpty();
    _builder.append(initExpTypeQName, "");
    _builder.append(" newCs");
    _builder.append(propertyName, "");
    _builder.append("s = ");
    String _accept = initExp.<String>accept(this);
    _builder.append(_accept, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append(propertyTypeQName, "");
    _builder.append(" new");
    _builder.append(propertyName, "");
    _builder.append("s = new ");
    _builder.append(propertyTypeImplQName, "");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    result.append(_builder);
    Type _type_5 = initExp.getType();
    boolean _isMany = this.isMany(_type_5);
    if (_isMany) {
      Type _type_6 = initExp.getType();
      Type _elementType = ((CollectionType) _type_6).getElementType();
      String csTypeQName = this.getTypeQualifiedName(_elementType);
      Type _type_7 = astProperty.getType();
      Type _elementType_1 = ((CollectionType) _type_7).getElementType();
      String asTypeQName = this.getTypeQualifiedName(_elementType_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("for (");
      _builder_1.append(csTypeQName, "");
      _builder_1.append(" newCs");
      _builder_1.append(propertyName, "");
      _builder_1.append(" : newCs");
      _builder_1.append(propertyName, "");
      _builder_1.append("s) {");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append(asTypeQName, "	");
      _builder_1.append(" new");
      _builder_1.append(propertyName, "	");
      _builder_1.append(" = ");
      String _aSfromCSStub = this.getASfromCSStub(astProperty, initExp);
      _builder_1.append(_aSfromCSStub, "	");
      _builder_1.append(";");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append("if (new");
      _builder_1.append(propertyName, "	");
      _builder_1.append(" != null) {");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t\t");
      _builder_1.append("new");
      _builder_1.append(propertyName, "		");
      _builder_1.append("s.add(new");
      _builder_1.append(propertyName, "		");
      _builder_1.append(");");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      result.append(_builder_1);
    } else {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("new");
      _builder_2.append(propertyName, "");
      _builder_2.append("s.add(");
      String _aSfromCSStub_1 = this.getASfromCSStub(astProperty, initExp);
      _builder_2.append(_aSfromCSStub_1, "");
      _builder_2.append(");");
      _builder_2.newLineIfNotEmpty();
      result.append(_builder_2);
    }
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append(propertyTypeQName, "");
    _builder_3.append(" old");
    _builder_3.append(propertyName, "");
    _builder_3.append("s = asElement.get");
    _builder_3.append(propertyName, "");
    _builder_3.append("();");
    _builder_3.newLineIfNotEmpty();
    result.append(_builder_3);
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("PivotUtil.refreshList(old");
    _builder_4.append(propertyName, "");
    _builder_4.append("s, new");
    _builder_4.append(propertyName, "");
    _builder_4.append("s);");
    _builder_4.newLineIfNotEmpty();
    result.append(_builder_4);
    return result.toString();
  }
  
  private boolean isMany(final Type type) {
    return (type instanceof CollectionType);
  }
  
  private String getASfromCSStub(final Property astProperty, final OCLExpression initExp) {
    String _name = astProperty.getName();
    String propertyName = StringExtensions.toFirstUpper(_name);
    Type csType = initExp.getType();
    if ((csType instanceof CollectionType)) {
      Type _elementType = ((CollectionType) csType).getElementType();
      csType = _elementType;
    }
    Type asType = astProperty.getType();
    if ((asType instanceof CollectionType)) {
      Type _elementType_1 = ((CollectionType) asType).getElementType();
      asType = _elementType_1;
    }
    MetaModelManager _metamodelManager = this.context.getMetamodelManager();
    Iterable<? extends DomainType> _allSuperClasses = _metamodelManager.getAllSuperClasses(csType);
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
      String _typeQualifiedName = this.getTypeQualifiedName(asType);
      _builder.append(_typeQualifiedName, "");
      _builder.append(".class, newCs");
      _builder.append(propertyName, "");
      _builder.append(")");
      return _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("newCs");
      _builder_1.append(propertyName, "");
      return _builder_1.toString();
    }
  }
}
