/**
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvto.examples.xtext.qvtoperational/model/QVTOperationalCS.genmodel
 *
 * Do not edit it.
 */
package	org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.qvto.examples.xtext.imperativeocl.cs2as.ImperativeOCLCSContainmentVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;

/**
 *
 */
public class QVTOperationalCSContainmentVisitor
	extends ImperativeOCLCSContainmentVisitor
	implements QVTOperationalCSVisitor<Continuation<?>>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	public QVTOperationalCSContainmentVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}
	public @Nullable Continuation<?> visitClassifierDefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS csElement) {
		throw new UnsupportedOperationException("visitClassifierDefCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitClassifierProperty2CS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS csElement) {
		throw new UnsupportedOperationException("visitClassifierProperty2CS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitClassifierPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS csElement) {
		CS2Pivot converter = context.getConverter();
		// AS element creation
		org.eclipse.ocl.examples.pivot.Property asElement = csElement != null ? (org.eclipse.ocl.examples.pivot.Property) converter.getPivotElement(csElement) : null;
		if (asElement == null) {
			asElement = org.eclipse.ocl.examples.pivot.PivotFactory.eINSTANCE.createProperty();
			converter.installPivotDefinition(csElement, asElement);
		}
		
		// AS Name property update
		java.lang.String newCsName = csElement.getName();
		java.lang.String newName = newCsName;
		java.lang.String oldName = asElement.getName();
		if ((newName != oldName) && ((newName == null) || !newName.equals(oldName))) {
			asElement.setName(newName);
		}
		// AS IsComposite property update
		java.lang.Boolean newCsIsComposite = csElement.getQualifier().contains("composite");
		java.lang.Boolean newIsComposite = newCsIsComposite;
		java.lang.Boolean oldIsComposite = asElement.isComposite();
		if ((newIsComposite != oldIsComposite) && ((newIsComposite == null) || !newIsComposite.equals(oldIsComposite))) {
			asElement.setIsComposite(newIsComposite);
		}
		// AS element comments update
		context.refreshComments(asElement, csElement);
		return null;
	}
	
	public @Nullable Continuation<?> visitCompleteSignatureCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS csElement) {
		throw new UnsupportedOperationException("visitCompleteSignatureCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitConfigPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConfigPropertyCS csElement) {
		throw new UnsupportedOperationException("visitConfigPropertyCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitConstructorCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConstructorCS csElement) {
		throw new UnsupportedOperationException("visitConstructorCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitContextualPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ContextualPropertyCS csElement) {
		throw new UnsupportedOperationException("visitContextualPropertyCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitElementWithBody(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody csElement) {
		throw new UnsupportedOperationException("visitElementWithBody not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitExceptionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ExceptionCS csElement) {
		throw new UnsupportedOperationException("visitExceptionCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitImperativeOperationCallExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImperativeOperationCallExpCS csElement) {
		throw new UnsupportedOperationException("visitImperativeOperationCallExpCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitInitPartCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS csElement) {
		throw new UnsupportedOperationException("visitInitPartCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitLibraryImportCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LibraryImportCS csElement) {
		throw new UnsupportedOperationException("visitLibraryImportCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitLocalPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LocalPropertyCS csElement) {
		throw new UnsupportedOperationException("visitLocalPropertyCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitMappingBodyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingBodyCS csElement) {
		throw new UnsupportedOperationException("visitMappingBodyCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitMappingCallExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingCallExpCS csElement) {
		throw new UnsupportedOperationException("visitMappingCallExpCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitMappingEndCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingEndCS csElement) {
		throw new UnsupportedOperationException("visitMappingEndCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitMappingExtensionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionCS csElement) {
		throw new UnsupportedOperationException("visitMappingExtensionCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitMappingInitCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingInitCS csElement) {
		throw new UnsupportedOperationException("visitMappingInitCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitMappingMethodCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingMethodCS csElement) {
		throw new UnsupportedOperationException("visitMappingMethodCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitMappingModuleCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS csElement) {
		throw new UnsupportedOperationException("visitMappingModuleCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitMappingOperationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS csElement) {
		CS2Pivot converter = context.getConverter();
		// AS element creation
		org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation asElement = csElement != null ? (org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation) converter.getPivotElement(csElement) : null;
		if (asElement == null) {
			asElement = org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalFactory.eINSTANCE.createMappingOperation();
			converter.installPivotDefinition(csElement, asElement);
		}
		
		// AS Name property update
		java.lang.String newCsName = csElement.getName();
		java.lang.String newName = newCsName;
		java.lang.String oldName = asElement.getName();
		if ((newName != oldName) && ((newName == null) || !newName.equals(oldName))) {
			asElement.setName(newName);
		}
		// AS element comments update
		context.refreshComments(asElement, csElement);
		return null;
	}
	
	public @Nullable Continuation<?> visitMappingQueryCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingQueryCS csElement) {
		throw new UnsupportedOperationException("visitMappingQueryCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitMappingRuleCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingRuleCS csElement) {
		throw new UnsupportedOperationException("visitMappingRuleCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitMappingSectionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionCS csElement) {
		throw new UnsupportedOperationException("visitMappingSectionCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitMappingSectionsCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionsCS csElement) {
		throw new UnsupportedOperationException("visitMappingSectionsCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitMetamodelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS csElement) {
		CS2Pivot converter = context.getConverter();
		// AS element creation
		org.eclipse.ocl.examples.pivot.Package asElement = csElement != null ? (org.eclipse.ocl.examples.pivot.Package) converter.getPivotElement(csElement) : null;
		if (asElement == null) {
			asElement = org.eclipse.ocl.examples.pivot.PivotFactory.eINSTANCE.createPackage();
			converter.installPivotDefinition(csElement, asElement);
		}
		
		// AS Name property update
		java.lang.String newCsName = csElement.getName();
		java.lang.String newName = newCsName;
		java.lang.String oldName = asElement.getName();
		if ((newName != oldName) && ((newName == null) || !newName.equals(oldName))) {
			asElement.setName(newName);
		}
		// AS NsPrefix property update
		java.lang.String newCsNsPrefix = csElement.getName();
		java.lang.String newNsPrefix = newCsNsPrefix;
		java.lang.String oldNsPrefix = asElement.getNsPrefix();
		if ((newNsPrefix != oldNsPrefix) && ((newNsPrefix == null) || !newNsPrefix.equals(oldNsPrefix))) {
			asElement.setNsPrefix(newNsPrefix);
		}
		// AS NsURI property update
		java.lang.String newCsNsURI = csElement.getName();
		java.lang.String newNsURI = newCsNsURI;
		java.lang.String oldNsURI = asElement.getNsURI();
		if ((newNsURI != oldNsURI) && ((newNsURI == null) || !newNsURI.equals(oldNsURI))) {
			asElement.setNsURI(newNsURI);
		}
		// AS OwnedType property update
		java.util.List<org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS> newCsOwnedTypes = csElement.getOwnedType();
		java.util.List<org.eclipse.ocl.examples.pivot.Type> newOwnedTypes = new java.util.ArrayList<org.eclipse.ocl.examples.pivot.Type>();
		
		for (org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS newCsOwnedType : newCsOwnedTypes) {
			org.eclipse.ocl.examples.pivot.Type newOwnedType = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Type.class, newCsOwnedType);
			if (newOwnedType != null) {
				newOwnedTypes.add(newOwnedType);
			}
		}
		java.util.List<org.eclipse.ocl.examples.pivot.Type> oldOwnedTypes = asElement.getOwnedType();
		PivotUtil.refreshList(oldOwnedTypes, newOwnedTypes);
		// AS element comments update
		context.refreshComments(asElement, csElement);
		return null;
	}
	
	public @Nullable Continuation<?> visitModelTypeCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS csElement) {
		throw new UnsupportedOperationException("visitModelTypeCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitModuleKindCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindCS csElement) {
		throw new UnsupportedOperationException("visitModuleKindCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitModulePropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModulePropertyCS csElement) {
		throw new UnsupportedOperationException("visitModulePropertyCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitModuleRefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleRefCS csElement) {
		throw new UnsupportedOperationException("visitModuleRefCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitModuleUsageCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS csElement) {
		throw new UnsupportedOperationException("visitModuleUsageCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitMultiplicityDefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityDefCS csElement) {
		throw new UnsupportedOperationException("visitMultiplicityDefCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitObjectExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ObjectExpCS csElement) {
		throw new UnsupportedOperationException("visitObjectExpCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitOperationParameterDeclarationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS csElement) {
		throw new UnsupportedOperationException("visitOperationParameterDeclarationCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitOperationSimpleSignatureCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationSimpleSignatureCS csElement) {
		throw new UnsupportedOperationException("visitOperationSimpleSignatureCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitOppositePropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OppositePropertyCS csElement) {
		throw new UnsupportedOperationException("visitOppositePropertyCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitPackageRefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PackageRefCS csElement) {
		throw new UnsupportedOperationException("visitPackageRefCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitParameterDeclarationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS csElement) {
		throw new UnsupportedOperationException("visitParameterDeclarationCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitPrimitiveTypeCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PrimitiveTypeCS csElement) {
		throw new UnsupportedOperationException("visitPrimitiveTypeCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitQVToClassCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToClassCS csElement) {
		CS2Pivot converter = context.getConverter();
		// AS element creation
		org.eclipse.ocl.examples.pivot.Class asElement = csElement != null ? (org.eclipse.ocl.examples.pivot.Class) converter.getPivotElement(csElement) : null;
		if (asElement == null) {
			asElement = org.eclipse.ocl.examples.pivot.PivotFactory.eINSTANCE.createClass();
			converter.installPivotDefinition(csElement, asElement);
		}
		
		// AS Name property update
		java.lang.String newCsName = csElement.getName();
		java.lang.String newName = newCsName;
		java.lang.String oldName = asElement.getName();
		if ((newName != oldName) && ((newName == null) || !newName.equals(oldName))) {
			asElement.setName(newName);
		}
		// AS OwnedAttribute property update
		java.util.List<org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS> newCsOwnedAttributes = csElement.getOwnedProperty();
		java.util.List<org.eclipse.ocl.examples.pivot.Property> newOwnedAttributes = new java.util.ArrayList<org.eclipse.ocl.examples.pivot.Property>();
		
		for (org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS newCsOwnedAttribute : newCsOwnedAttributes) {
			org.eclipse.ocl.examples.pivot.Property newOwnedAttribute = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Property.class, newCsOwnedAttribute);
			if (newOwnedAttribute != null) {
				newOwnedAttributes.add(newOwnedAttribute);
			}
		}
		java.util.List<org.eclipse.ocl.examples.pivot.Property> oldOwnedAttributes = asElement.getOwnedAttribute();
		PivotUtil.refreshList(oldOwnedAttributes, newOwnedAttributes);
		// AS OwnedOperation property update
		java.util.List<org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS> newCsOwnedOperations = csElement.getOwnedOperation();
		java.util.List<org.eclipse.ocl.examples.pivot.Operation> newOwnedOperations = new java.util.ArrayList<org.eclipse.ocl.examples.pivot.Operation>();
		
		for (org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS newCsOwnedOperation : newCsOwnedOperations) {
			org.eclipse.ocl.examples.pivot.Operation newOwnedOperation = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Operation.class, newCsOwnedOperation);
			if (newOwnedOperation != null) {
				newOwnedOperations.add(newOwnedOperation);
			}
		}
		java.util.List<org.eclipse.ocl.examples.pivot.Operation> oldOwnedOperations = asElement.getOwnedOperation();
		PivotUtil.refreshList(oldOwnedOperations, newOwnedOperations);
		// AS element comments update
		context.refreshComments(asElement, csElement);
		return null;
	}
	
	public @Nullable Continuation<?> visitQVToImportCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToImportCS csElement) {
		throw new UnsupportedOperationException("visitQVToImportCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitQVToLibraryCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToLibraryCS csElement) {
		throw new UnsupportedOperationException("visitQVToLibraryCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitQVToOperationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToOperationCS csElement) {
		throw new UnsupportedOperationException("visitQVToOperationCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitRenameCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.RenameCS csElement) {
		throw new UnsupportedOperationException("visitRenameCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitResolveExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS csElement) {
		throw new UnsupportedOperationException("visitResolveExpCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitResolveInExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS csElement) {
		throw new UnsupportedOperationException("visitResolveInExpCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitResolveOpArgsExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveOpArgsExpCS csElement) {
		throw new UnsupportedOperationException("visitResolveOpArgsExpCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitScopedNameCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ScopedNameCS csElement) {
		throw new UnsupportedOperationException("visitScopedNameCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitSimpleSignatureCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS csElement) {
		throw new UnsupportedOperationException("visitSimpleSignatureCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitStereotypeQualifierCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.StereotypeQualifierCS csElement) {
		throw new UnsupportedOperationException("visitStereotypeQualifierCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitTagCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS csElement) {
		throw new UnsupportedOperationException("visitTagCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitTopLevelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS csElement) {
		CS2Pivot converter = context.getConverter();
		// AS element creation
		org.eclipse.ocl.examples.pivot.Root asElement = csElement != null ? (org.eclipse.ocl.examples.pivot.Root) converter.getPivotElement(csElement) : null;
		if (asElement == null) {
			asElement = org.eclipse.ocl.examples.pivot.PivotFactory.eINSTANCE.createRoot();
			converter.installPivotDefinition(csElement, asElement);
		}
		
		// AS NestedPackage property update
		java.util.List<org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS> newCsNestedPackages = csElement.getOwnedNestedPackage();
		java.util.List<org.eclipse.ocl.examples.pivot.Package> newNestedPackages = new java.util.ArrayList<org.eclipse.ocl.examples.pivot.Package>();
		
		for (org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS newCsNestedPackage : newCsNestedPackages) {
			org.eclipse.ocl.examples.pivot.Package newNestedPackage = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Package.class, newCsNestedPackage);
			if (newNestedPackage != null) {
				newNestedPackages.add(newNestedPackage);
			}
		}
		java.util.List<org.eclipse.ocl.examples.pivot.Package> oldNestedPackages = asElement.getNestedPackage();
		PivotUtil.refreshList(oldNestedPackages, newNestedPackages);
		// AS element comments update
		context.refreshComments(asElement, csElement);
		return null;
	}
	
	public @Nullable Continuation<?> visitTransformationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS csElement) {
		CS2Pivot converter = context.getConverter();
		// AS element creation
		org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation asElement = csElement != null ? (org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation) converter.getPivotElement(csElement) : null;
		if (asElement == null) {
			asElement = org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalFactory.eINSTANCE.createOperationalTransformation();
			converter.installPivotDefinition(csElement, asElement);
		}
		
		// AS Name property update
		java.lang.String newCsName = csElement.getName();
		java.lang.String newName = newCsName;
		java.lang.String oldName = asElement.getName();
		if ((newName != oldName) && ((newName == null) || !newName.equals(oldName))) {
			asElement.setName(newName);
		}
		// AS NsPrefix property update
		java.lang.String newCsNsPrefix = csElement.getName();
		java.lang.String newNsPrefix = newCsNsPrefix;
		java.lang.String oldNsPrefix = asElement.getNsPrefix();
		if ((newNsPrefix != oldNsPrefix) && ((newNsPrefix == null) || !newNsPrefix.equals(oldNsPrefix))) {
			asElement.setNsPrefix(newNsPrefix);
		}
		// AS NsURI property update
		java.lang.String newCsNsURI = csElement.getName();
		java.lang.String newNsURI = newCsNsURI;
		java.lang.String oldNsURI = asElement.getNsURI();
		if ((newNsURI != oldNsURI) && ((newNsURI == null) || !newNsURI.equals(oldNsURI))) {
			asElement.setNsURI(newNsURI);
		}
		// AS NestedPackage property update
		java.util.List<org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS> newCsNestedPackages = csElement.getOwnedNestedPackage();
		java.util.List<org.eclipse.ocl.examples.pivot.Package> newNestedPackages = new java.util.ArrayList<org.eclipse.ocl.examples.pivot.Package>();
		
		for (org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS newCsNestedPackage : newCsNestedPackages) {
			org.eclipse.ocl.examples.pivot.Package newNestedPackage = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Package.class, newCsNestedPackage);
			if (newNestedPackage != null) {
				newNestedPackages.add(newNestedPackage);
			}
		}
		java.util.List<org.eclipse.ocl.examples.pivot.Package> oldNestedPackages = asElement.getNestedPackage();
		PivotUtil.refreshList(oldNestedPackages, newNestedPackages);
		// AS OwnedType property update
		java.util.List<org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS> newCsOwnedTypes = csElement.getOwnedType();
		java.util.List<org.eclipse.ocl.examples.pivot.Type> newOwnedTypes = new java.util.ArrayList<org.eclipse.ocl.examples.pivot.Type>();
		
		for (org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS newCsOwnedType : newCsOwnedTypes) {
			org.eclipse.ocl.examples.pivot.Type newOwnedType = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Type.class, newCsOwnedType);
			if (newOwnedType != null) {
				newOwnedTypes.add(newOwnedType);
			}
		}
		java.util.List<org.eclipse.ocl.examples.pivot.Type> oldOwnedTypes = asElement.getOwnedType();
		PivotUtil.refreshList(oldOwnedTypes, newOwnedTypes);
		// AS OwnedOperation property update
		java.util.List<org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS> newCsOwnedOperations = csElement.getOwnedOperation();
		java.util.List<org.eclipse.ocl.examples.pivot.Operation> newOwnedOperations = new java.util.ArrayList<org.eclipse.ocl.examples.pivot.Operation>();
		
		for (org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS newCsOwnedOperation : newCsOwnedOperations) {
			org.eclipse.ocl.examples.pivot.Operation newOwnedOperation = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Operation.class, newCsOwnedOperation);
			if (newOwnedOperation != null) {
				newOwnedOperations.add(newOwnedOperation);
			}
		}
		java.util.List<org.eclipse.ocl.examples.pivot.Operation> oldOwnedOperations = asElement.getOwnedOperation();
		PivotUtil.refreshList(oldOwnedOperations, newOwnedOperations);
		// AS element comments update
		context.refreshComments(asElement, csElement);
		return null;
	}
	
	public @Nullable Continuation<?> visitTransformationRefineCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationRefineCS csElement) {
		throw new UnsupportedOperationException("visitTransformationRefineCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitTypeSpecCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS csElement) {
		throw new UnsupportedOperationException("visitTypeSpecCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
	public @Nullable Continuation<?> visitUnitCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS csElement) {
		throw new UnsupportedOperationException("visitUnitCS not supported in QVTOperationalCSContainmentVisitor");
	}
	
}
