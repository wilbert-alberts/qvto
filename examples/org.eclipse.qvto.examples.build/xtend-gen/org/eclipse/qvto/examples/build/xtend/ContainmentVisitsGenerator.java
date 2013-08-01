package org.eclipse.qvto.examples.build.xtend;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.qvto.examples.build.utlities.IContainmentVisitsGeneratorCtx;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ContainmentVisitsGenerator extends AbstractExtendingVisitor<String,IContainmentVisitsGeneratorCtx> {
  public ContainmentVisitsGenerator(final IContainmentVisitsGeneratorCtx context) {
    super(context);
  }
  
  public String visiting(final Visitable visitable) {
    return "return null;";
  }
  
  public String visitConstructorExp(final ConstructorExp object) {
    StringBuilder _stringBuilder = new StringBuilder();
    StringBuilder result = _stringBuilder;
    Type astType = object.getType();
    GenModel targetGM = this.context.getTargetGenModel();
    String typeQN = this.getTypeQualifiedName(astType, targetGM);
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
    String _factoryInstanceName = this.getFactoryInstanceName(targetGM);
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
    _builder_1.append("return null;");
    result.append(_builder_1);
    return result.toString();
  }
  
  public String visitConstructorPart(final ConstructorPart object) {
    return "";
  }
  
  private String getFactoryInstanceName(final GenModel genModel) {
    GenPackage genPackage = this.getGenPackage(genModel);
    String modelPackageName = this.getModelPackage(genPackage);
    String _plus = (modelPackageName + ".");
    String _factoryInterfaceName = genPackage.getFactoryInterfaceName();
    String _plus_1 = (_plus + _factoryInterfaceName);
    String _plus_2 = (_plus_1 + ".");
    String _factoryInstanceName = genPackage.getFactoryInstanceName();
    return (_plus_2 + _factoryInstanceName);
  }
  
  private String getTypeQualifiedName(final Type astType, final GenModel genModel) {
    GenPackage genPackage = this.getGenPackage(genModel);
    String modelPackageName = this.getModelPackage(genPackage);
    String _plus = (modelPackageName + ".");
    String _name = astType.getName();
    return (_plus + _name);
  }
  
  private GenPackage getGenPackage(final GenModel genModel) {
    EList<GenPackage> _genPackages = genModel.getGenPackages();
    return _genPackages.get(0);
  }
  
  private String getModelPackage(final GenPackage genPackage) {
    String basePackage = genPackage.getBasePackage();
    String _xifexpression = null;
    boolean _equals = Objects.equal(basePackage, null);
    if (_equals) {
      String _nSName = genPackage.getNSName();
      _xifexpression = _nSName;
    } else {
      String _plus = (basePackage + ".");
      String _nSName_1 = genPackage.getNSName();
      String _plus_1 = (_plus + _nSName_1);
      _xifexpression = _plus_1;
    }
    return _xifexpression;
  }
}
