package org.eclipse.qvto.examples.build.xtend;

import java.util.List;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.qvto.examples.build.utlities.IContainmentVisitsGeneratorCtx;
import org.eclipse.qvto.examples.build.utlities.QVToGenModelHelper;
import org.eclipse.xtend2.lib.StringConcatenation;

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
    _builder_1.append("return null;");
    result.append(_builder_1);
    return result.toString();
  }
  
  public String visitConstructorPart(final ConstructorPart object) {
    return "";
  }
  
  private String getFactoryInstanceName(final Type astType) {
    return this.genModelHelper.getQualifiedFactoryInstanceAccessor(astType);
  }
  
  private String getTypeQualifiedName(final Type astType) {
    return this.genModelHelper.getQualifiedInterfaceName(astType);
  }
}
