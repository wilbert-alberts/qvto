package org.eclipse.qvto.examples.build.codegen;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.ImportUtils;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;


public class ContextualizedOCLExpressionCodeGenerator extends JavaCodeGenerator {

	CodeGenAnalyzer cgAnalyzer;
	OCLExpression oclExp;
	Variable context;
	
	public ContextualizedOCLExpressionCodeGenerator(MetaModelManager metaModelManager, OCLExpression expression, Variable contextVariable) {
		super(metaModelManager);
		this.cgAnalyzer = new CodeGenAnalyzer(this);
		this.oclExp = expression;
		this.context = contextVariable;
	}

	@NonNull
	public CodeGenAnalyzer getAnalyzer() {
		return cgAnalyzer;
	}
	
	
	protected @NonNull CGPackage createCGPackage(@NonNull OCLExpression oclExp, @NonNull Variable selfVariable,
			@NonNull String packageName, @NonNull String className) {
		CGPackage cgPackage = CGModelFactory.eINSTANCE.createCGPackage();
		cgPackage.setName(packageName);
		
		CGClass cgClass = CGModelFactory.eINSTANCE.createCGClass();
		cgClass.setName(className);
		cgPackage.getClasses().add(cgClass);
				
		AS2CGVisitor pivot2CGVisitor = new AS2CGVisitor(cgAnalyzer);
		// CGParameter contextVariable = (CGParameter) selfVariable.accept(pivot2CGVisitor);
		CGParameter contextParameter = pivot2CGVisitor.getParameter(selfVariable); 	// FIXME Smell. I would expect the visitor to do this.
		contextParameter.setTypeId(cgAnalyzer.getTypeId(selfVariable.getTypeId())); // FIXME this should be done by the visitor
		CGValuedElement cgBody = (CGValuedElement) DomainUtil.nonNullState(oclExp.accept(pivot2CGVisitor));
		CGOperation cgOperation = CGModelFactory.eINSTANCE.createCGEcoreOperation();
		cgOperation.getParameters().add(contextParameter);
		cgOperation.setAst(oclExp);
		cgOperation.setTypeId(cgAnalyzer.getTypeId(oclExp.getTypeId()));
		cgOperation.setName(getGlobalContext().getEvaluateName());
		cgOperation.setBody(cgBody);
		cgClass.getOperations().add(cgOperation);
		return cgPackage;
	}
	
	public @NonNull String generateClassFile(@NonNull String packageName, @NonNull String className) {
		CGPackage cgPackage = createCGPackage(oclExp, context, packageName, className);
		// optimize(cgPackage);
		List<CGValuedElement> sortedGlobals = prepareGlobals();
		ContextualizedOCLExpressionCG2JavaClassVisitor cg2JavaClassVisitor = new ContextualizedOCLExpressionCG2JavaClassVisitor(this, oclExp, sortedGlobals);
		cgPackage.accept(cg2JavaClassVisitor);
		Set<String> allImports = cg2JavaClassVisitor.getAllImports();
		Map<String, String> long2ShortImportNames = ImportUtils.getLong2ShortImportNames(allImports);
		return ImportUtils.resolveImports(cg2JavaClassVisitor.toString(), long2ShortImportNames);
	}		
}
