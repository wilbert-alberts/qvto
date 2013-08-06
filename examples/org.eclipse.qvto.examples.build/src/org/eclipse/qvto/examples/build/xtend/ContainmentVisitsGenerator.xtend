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
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil
import org.eclipse.ocl.examples.pivot.CollectionType

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
				
		if (isMany(astProperty.type)) {
			result.append(createMultivaluedPropertyStub(astProperty, initExp));
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
		// TODO ask Ed for suitable already coded functioality to compute this.
		// FIXME
		// Bad String handling exception. Nasty temporal WORKAROUND to make prototype work
		if (astType.name == "String") { return "String"};
		
		var Type type = null
		if (astType instanceof CollectionType) {
			type = (astType as CollectionType).elementType; // FIXME
		} else {
			type = astType
		}
		
		// FIXME Boxing/Unboxing		
		return genModelHelper.getQualifiedInterfaceName(PivotUtil.getType(type));
	}
	
	// SHARED Functionality
	def private String createMonovaluedPropertyStub(Property astProperty, OCLExpression initExp) {
		var StringBuilder result = new StringBuilder();
		var String propertyName = astProperty.name.toFirstUpper;
		var String propertyTypeName = astProperty.type.name;
		var String propertyTypeQName = getTypeQualifiedName(astProperty.type);
		var String initExpTypeName = initExp.type.name;
		var String initExpTypeQName = getTypeQualifiedName(initExp.type);
		
		// We compute the new value from CS element (initExp)
		// We assume that the initExp is monovalued type compatible expression.
		// This generator should not be responsible of checking this
		result.append('''
			// AS «propertyName» property update
			«initExpTypeQName» newCs«propertyName» = «initExp.accept(this)»;
			«propertyTypeQName» new«propertyName» = «getASfromCSStub(astProperty, initExp)»;
			''');

		// We process the as element update
		result.append('''
			«propertyTypeQName» old«propertyName» = asElement.get«propertyName»();
			if ((new«propertyName» != old«propertyName») && ((new«propertyName» == null) || !new«propertyName».equals(old«propertyName»))) {
				asElement.set«propertyName»(new«propertyName»);
			}
			''');
		return result.toString;
	}
	
	
	def private String createMultivaluedPropertyStub(Property astProperty, OCLExpression initExp) {
		var StringBuilder result = new StringBuilder();
		var String propertyName = astProperty.name.toFirstUpper;
		var String propertyTypeName = astProperty.type.name;
		var String propertyTypeQName = getTypeQualifiedName(astProperty.type);
		var String initExpTypeName = initExp.type.name;
		var String initExpTypeQName = getTypeQualifiedName(initExp.type);
		
		// We compute the new property value from CS element (initExp)
		result.append('''
			// AS «propertyName» property update
			''');
		if (isMany(initExp.type)) {
			result.append('''
				List<«initExpTypeQName»> newCs«propertyName»s = «initExp.accept(this)»;
				''');
			result.append('''
				List<«propertyTypeQName»> new«propertyName»s= new ArrayList<«propertyTypeQName»>();
				for («initExpTypeQName» newCs«propertyName» : newCs«propertyName»s) {
					«propertyTypeQName» new«propertyName» = «getASfromCSStub(astProperty, initExp)»;
					if (new«propertyName» != null) {
						new«propertyName»s.add(new«propertyName»);
					}
				}
			''')
		} else {
			result.append('''
				«initExpTypeQName» newCs«propertyTypeQName» = «initExp.accept(this)»;
				«propertyTypeQName» new«propertyName»s = new ArrayList<«propertyTypeQName»>();
				«propertyTypeQName» new«propertyName»s.add(«getASfromCSStub(astProperty, initExp)»);
				''');
		}
		
		// We compute the old value 
		result.append('''
				List<«propertyTypeQName»> old«propertyName»s = asElement.get«propertyName»();
				''');
				
		// We process the as property values update
		result.append('''
			PivotUtil.refreshList(old«propertyName»s, new«propertyName»s);
			''');
		return result.toString;
	}
	
	def private boolean isMany(Type type) {
		// TODO ask Ed for suitable already coded functioality to compute this.
		
		if (type instanceof CollectionType) {
			return true;
		} else {
			return false;	
		}
	}
	
	def private String getASfromCSStub(Property astProperty, OCLExpression initExp) {
		var String propertyName = astProperty.name.toFirstUpper;
		var String propertyTypeQName = getTypeQualifiedName(astProperty.type);
		var String initExpType = initExp.type.name;
		// FIXME Study boxing/unboxing
		// quick nasty workround to make prototype work
		var Type type = initExp.type; 
		if (type instanceof CollectionType) {
			type = (type as CollectionType).elementType;
		}
		
		//var EClass class = context.metamodelManager.getEcoreOfPivot(typeof(EClass), type);
		var boolean isPivotable = context.metamodelManager.getAllSuperClasses(type).exists[name == "Pivotable"] ;
		
		if (isPivotable) {
			return '''PivotUtil.getPivot(«propertyTypeQName».class, newCs«propertyName»)''';	
		}
		else {
			return '''newCs«propertyName»''';
		}
	}
}