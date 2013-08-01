package org.eclipse.qvto.examples.build.xtend;

import org.eclipse.ocl.examples.pivot.ConstructorExp
import org.eclipse.ocl.examples.pivot.ConstructorPart
import org.eclipse.ocl.examples.pivot.Type
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor
import org.eclipse.ocl.examples.pivot.util.Visitable
import org.eclipse.qvto.examples.build.utlities.IContainmentVisitsGeneratorCtx
import org.eclipse.qvto.examples.build.utlities.QVToGenModelHelper

public class ContainmentVisitsGenerator extends AbstractExtendingVisitor<String, IContainmentVisitsGeneratorCtx> {
	
	private QVToGenModelHelper genModelHelper;
	
	public new(IContainmentVisitsGeneratorCtx context) {
		super(context);
		this.genModelHelper = new QVToGenModelHelper(context.metamodelManager);
	}
	
	override String visiting(Visitable visitable) {
		return "return null;";
	}	
	
	override String visitConstructorExp(ConstructorExp object) {
		
		var StringBuilder result = new StringBuilder();
		var Type astType = object.getType();
		// var GenModel targetGM = context.targetGenModel;
		var typeQN = getTypeQualifiedName(astType);
		
		result.append('''
			CS2Pivot converter = context.getConverter();
			// AS element creation
			«typeQN» asElement = csElement != null ? («typeQN») converter.getPivotElement(csElement) : null;
			if (asElement == null) {
				asElement = «getFactoryInstanceName(astType)».create«astType.name»();
				converter.installPivotDefinition(csElement, asElement);
			}
			
		''');
		
		for (ConstructorPart part : object.getPart()) {
			result.append(part.accept(this));
		}
		
		result.append('''
			return null;''');
		return result.toString();
	}
	
	override String visitConstructorPart(ConstructorPart object) {
		return ""; // TODO
	}
 
	def private String getFactoryInstanceName(Type astType) {
		return genModelHelper.getQualifiedFactoryInstanceAccessor(astType);		
	}
	
	def private String getTypeQualifiedName(Type astType) {
		return genModelHelper.getQualifiedInterfaceName(astType);
	}
}