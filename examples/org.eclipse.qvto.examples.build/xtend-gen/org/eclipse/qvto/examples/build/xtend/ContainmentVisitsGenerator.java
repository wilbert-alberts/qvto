package org.eclipse.qvto.examples.build.xtend;

import com.google.common.base.Objects;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.qvto.examples.build.codegen.ContextualizedOCLExpressionCodeGenerator;
import org.eclipse.qvto.examples.build.utlities.IContainmentVisitsGeneratorCtx;
import org.eclipse.qvto.examples.build.utlities.QVToGenModelHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ContainmentVisitsGenerator extends AbstractExtendingVisitor<String,IContainmentVisitsGeneratorCtx> {
  private final static String IS_PREFIX = "is";
  
  private final static String GET_PREFIX = "get";
  
  private final static String EVALUATORS_SUBPACKAGE = "evaluators";
  
  private QVToGenModelHelper genModelHelper;
  
  private OCL ocl;
  
  public ContainmentVisitsGenerator(final IContainmentVisitsGeneratorCtx context) {
    super(context);
    MetaModelManager _metamodelManager = context.getMetamodelManager();
    QVToGenModelHelper _qVToGenModelHelper = new QVToGenModelHelper(_metamodelManager);
    this.genModelHelper = _qVToGenModelHelper;
    OCL _newInstance = OCL.newInstance();
    this.ocl = _newInstance;
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
    String _factoryInstanceAccessor = this.getFactoryInstanceAccessor(astType);
    _builder.append(_factoryInstanceAccessor, "	");
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
    StringConcatenation _builder = new StringConcatenation();
    String _visitorsPackageName = this.context.getVisitorsPackageName();
    _builder.append(_visitorsPackageName, "");
    _builder.append(".");
    _builder.append(ContainmentVisitsGenerator.EVALUATORS_SUBPACKAGE, "");
    _builder.append(".");
    String _rightHandSideEvaluatorName = this.getRightHandSideEvaluatorName(object);
    _builder.append(_rightHandSideEvaluatorName, "");
    String rhsEvaluatorQName = _builder.toString();
    Type _type = astProperty.getType();
    boolean _isMany = this.isMany(_type);
    if (_isMany) {
      String _createMultivaluedPropertyStub = this.createMultivaluedPropertyStub(astProperty, initExp, rhsEvaluatorQName);
      result.append(_createMultivaluedPropertyStub);
    } else {
      String _createMonovaluedPropertyStub = this.createMonovaluedPropertyStub(astProperty, initExp, rhsEvaluatorQName);
      result.append(_createMonovaluedPropertyStub);
    }
    this.generateRightHandSideEvaluator(object);
    return result.toString();
  }
  
  private String getFactoryInstanceAccessor(final Type astType) {
    String _name = astType.getName();
    boolean _equals = Objects.equal(_name, "Class");
    if (_equals) {
      return "org.eclipse.ocl.examples.pivot.PivotFactory.eINSTANCE";
    }
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
    String _name_2 = astType.getName();
    boolean _equals_2 = Objects.equal(_name_2, "Class");
    if (_equals_2) {
      return "org.eclipse.ocl.examples.pivot.Class";
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
  
  private String getAccessorName(final Property property) {
    String propertyName = property.getName();
    MetaModelManager mm = this.context.getMetamodelManager();
    String _xifexpression = null;
    Type _type = property.getType();
    PrimitiveType _booleanType = mm.getBooleanType();
    boolean _conformsTo = mm.conformsTo(_type, _booleanType, null);
    if (_conformsTo) {
      String _xifexpression_1 = null;
      boolean _startsWith = propertyName.startsWith(ContainmentVisitsGenerator.IS_PREFIX);
      if (_startsWith) {
        _xifexpression_1 = propertyName;
      } else {
        String _firstUpper = StringExtensions.toFirstUpper(propertyName);
        String _plus = (ContainmentVisitsGenerator.IS_PREFIX + _firstUpper);
        _xifexpression_1 = _plus;
      }
      _xifexpression = _xifexpression_1;
    } else {
      String _firstUpper_1 = StringExtensions.toFirstUpper(propertyName);
      String _plus_1 = (ContainmentVisitsGenerator.GET_PREFIX + _firstUpper_1);
      _xifexpression = _plus_1;
    }
    return _xifexpression;
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
  
  private String createMonovaluedPropertyStub(final Property astProperty, final OCLExpression initExp, final String rhsEvaluatorQName) {
    StringBuilder _stringBuilder = new StringBuilder();
    StringBuilder result = _stringBuilder;
    String _name = astProperty.getName();
    String propertyName = StringExtensions.toFirstUpper(_name);
    Type _type = astProperty.getType();
    String propertyTypeQName = this.getTypeQualifiedName(_type);
    Type _type_1 = initExp.getType();
    String initExpTypeQName = this.getTypeQualifiedName(_type_1);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// AS ");
    _builder.append(propertyName, "");
    _builder.append(" property update");
    _builder.newLineIfNotEmpty();
    _builder.append("org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator newCS");
    _builder.append(propertyName, "");
    _builder.append("Evaluator = new org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager(csElement, org.eclipse.ocl.examples.pivot.PivotTables.LIBRARY);");
    _builder.newLineIfNotEmpty();
    _builder.append("org.eclipse.ocl.examples.domain.elements.DomainType newCS");
    _builder.append(propertyName, "");
    _builder.append("Type = context.getMetaModelManager().getIdResolver().getStaticTypeOf(csElement);");
    _builder.newLineIfNotEmpty();
    _builder.append(initExpTypeQName, "");
    _builder.append(" newCs");
    _builder.append(propertyName, "");
    _builder.append(" = ");
    _builder.append(rhsEvaluatorQName, "");
    _builder.append(".INSTANCE.evaluate(newCS");
    _builder.append(propertyName, "");
    _builder.append("Evaluator, newCS");
    _builder.append(propertyName, "");
    _builder.append("Type.getTypeId(), csElement);");
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
    _builder_1.append(" = asElement.");
    String _accessorName = this.getAccessorName(astProperty);
    _builder_1.append(_accessorName, "");
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
  
  private String createMultivaluedPropertyStub(final Property astProperty, final OCLExpression initExp, final String rhsEvaluatorQName) {
    StringBuilder _stringBuilder = new StringBuilder();
    StringBuilder result = _stringBuilder;
    String _name = astProperty.getName();
    String propertyName = StringExtensions.toFirstUpper(_name);
    Type _type = astProperty.getType();
    String propertyTypeQName = this.getTypeQualifiedName(_type);
    Type _type_1 = astProperty.getType();
    String propertyTypeImplQName = this.getTypeImplQualifiedName(_type_1);
    Type _type_2 = initExp.getType();
    String initExpTypeQName = this.getTypeQualifiedName(_type_2);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// AS ");
    _builder.append(propertyName, "");
    _builder.append(" property update");
    _builder.newLineIfNotEmpty();
    _builder.append("org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator newCS");
    _builder.append(propertyName, "");
    _builder.append("sEvaluator = new org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager(csElement, org.eclipse.ocl.examples.pivot.PivotTables.LIBRARY);");
    _builder.newLineIfNotEmpty();
    _builder.append("org.eclipse.ocl.examples.domain.elements.DomainType newCS");
    _builder.append(propertyName, "");
    _builder.append("sType = context.getMetaModelManager().getIdResolver().getStaticTypeOf(csElement);");
    _builder.newLineIfNotEmpty();
    _builder.append(initExpTypeQName, "");
    _builder.append(" newCs");
    _builder.append(propertyName, "");
    _builder.append("s = ");
    _builder.append(rhsEvaluatorQName, "");
    _builder.append(".INSTANCE.evaluate(newCS");
    _builder.append(propertyName, "");
    _builder.append("sEvaluator, newCS");
    _builder.append(propertyName, "");
    _builder.append("sType.getTypeId(), csElement);\t\t\t");
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
    Type _type_3 = initExp.getType();
    boolean _isMany = this.isMany(_type_3);
    if (_isMany) {
      Type _type_4 = initExp.getType();
      Type _elementType = ((CollectionType) _type_4).getElementType();
      String csTypeQName = this.getTypeQualifiedName(_elementType);
      Type _type_5 = astProperty.getType();
      Type _elementType_1 = ((CollectionType) _type_5).getElementType();
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
  
  private String getRightHandSideEvaluatorName(final ConstructorPart constructorPart) {
    EObject _eContainer = constructorPart.eContainer();
    ConstructorExp constructor = ((ConstructorExp) _eContainer);
    List<ConstructorPart> _part = constructor.getPart();
    int partNumber = _part.indexOf(constructorPart);
    Variable contextVariable = this.getContextVariable(constructor);
    Type csType = contextVariable.getType();
    String _name = csType.getName();
    String _plus = (_name + "_AST_Part");
    return (_plus + Integer.valueOf(partNumber));
  }
  
  private void generateRightHandSideEvaluator(final ConstructorPart constructorPart) {
    try {
      MetaModelManager mManager = this.context.getMetamodelManager();
      Variable contextVariable = this.getContextVariable(constructorPart);
      StringConcatenation _builder = new StringConcatenation();
      String _visitorsPackageName = this.context.getVisitorsPackageName();
      _builder.append(_visitorsPackageName, "");
      _builder.append(".");
      _builder.append(ContainmentVisitsGenerator.EVALUATORS_SUBPACKAGE, "");
      String packageName = _builder.toString();
      String className = this.getRightHandSideEvaluatorName(constructorPart);
      OCLExpression _initExpression = constructorPart.getInitExpression();
      ContextualizedOCLExpressionCodeGenerator _contextualizedOCLExpressionCodeGenerator = new ContextualizedOCLExpressionCodeGenerator(mManager, _initExpression, contextVariable);
      ContextualizedOCLExpressionCodeGenerator generator = _contextualizedOCLExpressionCodeGenerator;
      String javaCodeSource = generator.generateClassFile(packageName, className);
      StringConcatenation _builder_1 = new StringConcatenation();
      String _outputFolder = this.context.getOutputFolder();
      _builder_1.append(_outputFolder, "");
      _builder_1.append("/");
      _builder_1.append(ContainmentVisitsGenerator.EVALUATORS_SUBPACKAGE, "");
      _builder_1.append("/");
      _builder_1.append(className, "");
      _builder_1.append(".java");
      String fileName = _builder_1.toString();
      FileWriter _fileWriter = new FileWriter(fileName);
      Writer writer = _fileWriter;
      writer.append(javaCodeSource);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private boolean isMany(final Type type) {
    return (type instanceof CollectionType);
  }
  
  private String getASfromCSStub(final Property astProperty, final OCLExpression initExp) {
    String _name = astProperty.getName();
    String propertyName = StringExtensions.toFirstUpper(_name);
    MetaModelManager mm = this.context.getMetamodelManager();
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
    String csStub = null;
    Iterable<? extends DomainType> _allSuperClasses = mm.getAllSuperClasses(csType);
    final Function1<DomainType,Boolean> _function = new Function1<DomainType,Boolean>() {
        public Boolean apply(final DomainType it) {
          String _name = it.getName();
          boolean _equals = Objects.equal(_name, "Pivotable");
          return Boolean.valueOf(_equals);
        }
      };
    boolean _exists = IterableExtensions.exists(_allSuperClasses, _function);
    if (_exists) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PivotUtil.getPivot(");
      String _typeQualifiedName = this.getTypeQualifiedName(asType);
      _builder.append(_typeQualifiedName, "");
      _builder.append(".class, newCs");
      _builder.append(propertyName, "");
      _builder.append(")");
      csStub = _builder.toString();
    } else {
      if ((csType instanceof Enumeration)) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("newCs");
        _builder_1.append(propertyName, "");
        _builder_1.append(".getLiteral()");
        csStub = _builder_1.toString();
      } else {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("newCs");
        _builder_2.append(propertyName, "");
        csStub = _builder_2.toString();
      }
    }
    if ((asType instanceof Enumeration)) {
      StringConcatenation _builder_3 = new StringConcatenation();
      String _typeQualifiedName_1 = this.getTypeQualifiedName(asType);
      _builder_3.append(_typeQualifiedName_1, "");
      _builder_3.append(".valueOf(");
      _builder_3.append(csStub, "");
      _builder_3.append(")");
      return _builder_3.toString();
    } else {
      return csStub;
    }
  }
  
  private Variable getContextVariable(final Element oclExpression) {
    boolean _equals = Objects.equal(oclExpression, null);
    if (_equals) {
      return null;
    }
    if ((oclExpression instanceof ExpressionInOCL)) {
      return ((ExpressionInOCL) oclExpression).getContextVariable();
    }
    EObject container = oclExpression.eContainer();
    Variable _xifexpression = null;
    if ((container instanceof Element)) {
      EObject _eContainer = oclExpression.eContainer();
      Variable _contextVariable = this.getContextVariable(((Element) _eContainer));
      _xifexpression = _contextVariable;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
}
