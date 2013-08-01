package org.eclipse.qvto.examples.build.xtend;

import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.qvto.examples.build.utlities.IContainmentVisitsGeneratorCtx
import org.eclipse.ocl.examples.pivot.ConstructorPart
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage

public class ContainmentVisitsGenerator extends AbstractExtendingVisitor<String, IContainmentVisitsGeneratorCtx> {
	
	public new(IContainmentVisitsGeneratorCtx context) {
		super(context)
	}
	
	override String visiting(Visitable visitable) {
		return "return null;";
	}	
	
	override String visitConstructorExp(ConstructorExp object) {
		
		var StringBuilder result = new StringBuilder();	
		var Type astType = object.getType();		
		var GenModel targetGM = context.targetGenModel;
		var typeQN = getTypeQualifiedName(astType,targetGM);
		
		result.append('''
			CS2Pivot converter = context.getConverter();
			// AS element creation
			«typeQN» asElement = csElement != null ? («typeQN») converter.getPivotElement(csElement) : null;
			if (asElement == null) {
				asElement = «getFactoryInstanceName(targetGM)».create«astType.name»();
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

	// FIXME move to context 
	def private String getFactoryInstanceName(GenModel genModel) {
		var GenPackage genPackage = getGenPackage(genModel);
		var String modelPackageName = getModelPackage(genPackage);
		return modelPackageName + "." + genPackage.factoryInterfaceName+ "." + genPackage.factoryInstanceName;
	}
	
	def private String getTypeQualifiedName(Type astType, GenModel genModel) {
		var GenPackage genPackage = getGenPackage(genModel);
		var String modelPackageName = getModelPackage(genPackage);
		return modelPackageName + "." + astType.name;
	}
	
	def private GenPackage getGenPackage(GenModel genModel) {
		return  genModel.genPackages.get(0); // FIXME assumption	
	}
	
	def private String getModelPackage(GenPackage genPackage) {
		var String basePackage = genPackage.basePackage;
		return if (basePackage == null) genPackage.NSName else basePackage+"."+genPackage.NSName;
	}
}