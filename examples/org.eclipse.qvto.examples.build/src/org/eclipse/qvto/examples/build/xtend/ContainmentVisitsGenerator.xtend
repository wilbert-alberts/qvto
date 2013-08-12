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
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager
import org.eclipse.ocl.examples.pivot.IterateExp
import org.eclipse.ocl.examples.pivot.StringLiteralExp
import org.eclipse.ocl.examples.pivot.IteratorExp
import org.eclipse.ocl.examples.pivot.Iteration
import org.eclipse.ocl.examples.pivot.OperationCallExp

public class ContainmentVisitsGenerator extends AbstractExtendingVisitor<String, IContainmentVisitsGeneratorCtx> {
	
	private final static String IS_PREFIX = "is";
	private final static String GET_PREFIX = "get";
	
	private QVToGenModelHelper genModelHelper;
	
	public new(IContainmentVisitsGeneratorCtx context) {
		super(context);
		this.genModelHelper = new QVToGenModelHelper(context.metamodelManager);
	}
	
	override String visiting(Visitable visitable) {
		throw new UnsupportedOperationException('''visit«visitable.class.canonicalName» not supported in ContainmentVisitsGenerator''');
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
				asElement = «getFactoryInstanceAccessor(astType)».create«astType.name»();
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
	
	override visitIteratorExp(IteratorExp object) {
		var StringBuilder result = new StringBuilder();
			
		// We process
		result.append('''«object.source.accept(this)».''');
		
		// Then the iteration body
		var Iteration iteration = object.referredIteration;
		result.append(
		switch (iteration.name) {
			case "exists":'''contains(«object.body.accept(this)»)'''
			default: throw new UnsupportedOperationException('''iterator "«iteration.name»" not implemented yet in visitIterateExp in ContainmentVisitsGenerator''')
		})
		return result.toString()
	}
	
	override visitStringLiteralExp(StringLiteralExp object) {
		return '''"«object.stringSymbol»"''' 
	}
	
	override visitOperationCallExp(OperationCallExp object) {
		if (object.name == "ast") {
			return "";
		} 
		// FIXME todo  
		 
		super.visitOperationCallExp(object)
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
		return	'''«object.source.accept(this)».«getAccessorName(object.referredProperty)»()'''; 
	}
	
	override visitVariableExp(VariableExp object) {		
		return object.referredVariable.accept(this);
	}
	
	override visitVariable(Variable object) {
		return if ("self".equals(object.name)) "csElement" else object.name; 
	}

	def private String getFactoryInstanceAccessor(Type astType) {
		if (astType.name == "Class") { return "org.eclipse.ocl.examples.pivot.PivotFactory.eINSTANCE"};
		// FIXME HACK for the generator:
		// genModelHelper.getQualifiedInterfaceName is failing because astType it's related to a sort
		// of dummy OCL library package. Two comments:
		//     1. There is a bug around since some pivot classes are associated to this dummy OCL libary package as well.
		// 	   It could be solved if explicitly referring to pivot metamodel however Bug 414855 prevents to import the metamodel 
		return genModelHelper.getQualifiedFactoryInstanceAccessor(astType);		
	}
		
	def private String getTypeQualifiedName(Type astType) {
		var StringBuilder result = new StringBuilder();
		// TODO ask Ed for suitable already coded functioality to compute this.
		// FIXME HACK for the generator:
		// genModelHelper.getQualifiedInterfaceName is failing because astType it's related to a sort
		// of dummy OCL library package. Two comments:
		//     1. For library types could make sense. I should look for a better way to solve this (probably using metamodelManager)
		//     2. There is a bug around since some pivot classes are associated to this dummy OCL libary package as well.
		// 	   It could be solved if explicitly referring to pivot metamodel however Bug 414855 prevents to import the metamodel 
		if (astType.name == "String") { return "java.lang.String"};
		if (astType.name == "Boolean") { return "java.lang.Boolean"};
		if (astType.name == "Class") { return "org.eclipse.ocl.examples.pivot.Class"};
		
		if (astType instanceof CollectionType) {
			result.append("java.util.List<");
			result.append(getTypeQualifiedName((astType as CollectionType).elementType));
			result.append('>');			
		} else {
			result.append(genModelHelper.getQualifiedInterfaceName(PivotUtil.getType(astType)));
		}
		
		// FIXME Boxing/Unboxing		
		return result.toString();
	}
	
	def private String getAccessorName(Property property ) {
		var String propertyName = property.name;
		var MetaModelManager mm = context.metamodelManager;
		return 
			if (mm.conformsTo(property.type, mm.booleanType, null))
				if (propertyName.startsWith(IS_PREFIX)) // FIXME has prefix
					propertyName
				else
					IS_PREFIX + propertyName.toFirstUpper
			else  
				GET_PREFIX + propertyName.toFirstUpper;
	}
	
	def private String getTypeImplQualifiedName(Type astType) {
		var StringBuilder result = new StringBuilder();
		// TODO ask Ed for suitable already coded functioality to compute this.
		// FIXME
		// Bad String handling exception. Nasty temporal WORKAROUND to make prototype work
		if (astType.name == "String") { return "java.lang.String"};
		if (astType.name == "Boolean") { return "java.lang.Boolean"};
		
		if (astType instanceof CollectionType) {
			result.append("java.util.ArrayList<");
			result.append(getTypeQualifiedName((astType as CollectionType).elementType));
			result.append('>');			
		} else {
			result.append(genModelHelper.getQualifiedClassName(PivotUtil.getType(astType)));
		}
		return result.toString();
	}
	
	// SHARED Functionality
	def private String createMonovaluedPropertyStub(Property astProperty, OCLExpression initExp) {
		var StringBuilder result = new StringBuilder();
		var String propertyName = astProperty.name.toFirstUpper;
		//var String propertyTypeName = astProperty.type.name;
		var String propertyTypeQName = getTypeQualifiedName(astProperty.type);
		//var String initExpTypeName = initExp.type.name;
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
			«propertyTypeQName» old«propertyName» = asElement.«getAccessorName(astProperty)»();
			if ((new«propertyName» != old«propertyName») && ((new«propertyName» == null) || !new«propertyName».equals(old«propertyName»))) {
				asElement.set«propertyName»(new«propertyName»);
			}
			''');
		return result.toString;
	}
	
	
	def private String createMultivaluedPropertyStub(Property astProperty, OCLExpression initExp) {
		var StringBuilder result = new StringBuilder();
		var String propertyName = astProperty.name.toFirstUpper;
		//var String propertyTypeName = astProperty.type.name;		
		var String propertyTypeQName = getTypeQualifiedName(astProperty.type);
		var String propertyTypeImplQName = getTypeImplQualifiedName(astProperty.type);
		//var String initExpTypeName = initExp.type.name;
		var String initExpTypeQName = getTypeQualifiedName(initExp.type);
		
		// We compute the new property value from CS element (initExp)
		result.append('''
			// AS «propertyName» property update
			«initExpTypeQName» newCs«propertyName»s = «initExp.accept(this)»;
			«propertyTypeQName» new«propertyName»s = new «propertyTypeImplQName»();
			
			''');
		if (isMany(initExp.type)) {			
			var csTypeQName = getTypeQualifiedName((initExp.type as CollectionType).elementType);
			var asTypeQName = getTypeQualifiedName((astProperty.type as CollectionType).elementType);
			result.append('''
				for («csTypeQName» newCs«propertyName» : newCs«propertyName»s) {
					«asTypeQName» new«propertyName» = «getASfromCSStub(astProperty, initExp)»;
					if (new«propertyName» != null) {
						new«propertyName»s.add(new«propertyName»);
					}
				}
			''')
		} else {
			result.append('''
				new«propertyName»s.add(«getASfromCSStub(astProperty, initExp)»);
				''');
		}
		
		// We compute the old value 
		result.append('''
				«propertyTypeQName» old«propertyName»s = asElement.get«propertyName»();
				''');
				
		// We process the as property values update
		result.append('''
			PivotUtil.refreshList(old«propertyName»s, new«propertyName»s);
			''');
		return result.toString;
	}
	
	def private boolean isMany(Type type) {
		
		// TODO ask Ed for suitable already coded functioality to compute this.
		// Should not metamodel manager have a similar functionality
		return (type instanceof CollectionType);
	}
	
	def private String getASfromCSStub(Property astProperty, OCLExpression initExp) {
		var String propertyName = astProperty.name.toFirstUpper;		

		// FIXME Study boxing/unboxing
		// quick nasty workround to make prototype work
		var Type csType = initExp.type; 
		if (csType instanceof CollectionType) {
			csType = (csType as CollectionType).elementType;
		}
		
		var Type asType = astProperty.type; 
		if (asType instanceof CollectionType) {
			asType = (asType as CollectionType).elementType;
		}		
		
		//var EClass class = context.metamodelManager.getEcoreOfPivot(typeof(EClass), type);
		var boolean isPivotable = context.metamodelManager.getAllSuperClasses(csType).exists[name == "Pivotable"] ;		 
		
		if (isPivotable) {
			return '''PivotUtil.getPivot(«getTypeQualifiedName(asType)».class, newCs«propertyName»)''';	
		}
		else {
			return '''newCs«propertyName»''';
		}
	}
}