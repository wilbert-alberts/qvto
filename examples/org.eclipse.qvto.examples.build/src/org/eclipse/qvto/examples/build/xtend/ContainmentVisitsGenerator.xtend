package org.eclipse.qvto.examples.build.xtend;

import org.eclipse.ocl.examples.pivot.ConstructorExp
import org.eclipse.ocl.examples.pivot.ConstructorPart
import org.eclipse.ocl.examples.pivot.Property
import org.eclipse.ocl.examples.pivot.Type
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor
import org.eclipse.ocl.examples.pivot.util.Visitable
import org.eclipse.qvto.examples.build.utlities.IContainmentVisitsGeneratorCtx
import org.eclipse.qvto.examples.build.utlities.QVToGenModelHelper
import org.eclipse.ocl.examples.pivot.OCLExpression
import org.eclipse.ocl.examples.pivot.PropertyCallExp
import org.eclipse.ocl.examples.pivot.VariableExp
import org.eclipse.ocl.examples.pivot.Variable

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
		
		// TODO any heuristic to include comment update ?
		result.append('''
			// AS element comments update
			context.refreshComments(asElement, csElement);
			''');
			
		result.append('''
			return null;''');
		return result.toString();
	}
	
	override String visitConstructorPart(ConstructorPart object) {
		var StringBuilder result = new StringBuilder();		
		var Property astProperty = object.referredProperty;
		var OCLExpression initExp = object.initExpression;
				
		if (astProperty.many) {
			// TODO
		} else {
			result.append(createMonovaluedPropertyStub(astProperty, initExp));	
		}		
		return result.toString;
	}
		
	override visitPropertyCallExp(PropertyCallExp object) {
		var StringBuilder result = new StringBuilder();	
		var Property csProperty = object.referredProperty;
		var String propertyName = csProperty.name.toFirstUpper;
		
		// FIXME study boxing/unboxing value problem
		result.append('''«object.source.accept(this)».get«propertyName»()''');
		return result.toString; 
	}
	
	override visitVariableExp(VariableExp object) {		
		return object.referredVariable.accept(this);
	}
	
	override visitVariable(Variable object) {
		return if ("self".equals(object.name)) "csElement" else object.name; 
	}

	def private String getFactoryInstanceName(Type astType) {
		return genModelHelper.getQualifiedFactoryInstanceAccessor(astType);		
	}
	
	def private String getTypeQualifiedName(Type astType) {
		return genModelHelper.getQualifiedInterfaceName(astType);
	}
	
	// SHARED Functionality
	def private String createMonovaluedPropertyStub(Property astProperty, OCLExpression initExp) {
		var StringBuilder result = new StringBuilder();
		var String propertyName = astProperty.name.toFirstUpper;
		var String propertyType = astProperty.type.name;
		
		// We compute the new value from CS element (initExp)
		result.append('''
			// AS «propertyName» property update
			«propertyType» new«propertyName» = «initExp.accept(this)»;
			''');
		
		// We process the as element update
		result.append('''
			«propertyType» old«propertyName» = asElement.get«propertyName»();
			if ((new«propertyName» != old«propertyName») && ((new«propertyName» == null) || !new«propertyName».equals(old«propertyName»))) {
				asElement.set«propertyName»(new«propertyName»);
			}
			''');
		return result.toString;
	}
	

	
}