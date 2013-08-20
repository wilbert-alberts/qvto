package org.eclipse.qvto.examples.build.utlities;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;


/**
 * FIXME [MERGE] Merge these methods into AbstractGenModelHelper
 * 
 * @author asbh
 */
public class QVToGenModelHelper extends AbstractGenModelHelper {

	public QVToGenModelHelper(MetaModelManager metaModelManager) {
		super(metaModelManager);
	}
	
	public @Nullable String getQualifiedInterfaceName(@NonNull Type type) {
		GenClassifier genClassifier = getGenClassifier(type);
		return genClassifier instanceof GenDataType  
				? ((GenDataType) genClassifier).getQualifiedInstanceClassName()
				: ((GenClass) genClassifier).getQualifiedInterfaceName();
	}
	
	public @Nullable String getQualifiedClassName(@NonNull Type type) {
		GenClassifier genClassifier = getGenClassifier(type);
		return genClassifier instanceof GenDataType  
				? ((GenDataType) genClassifier).getQualifiedInstanceClassName()
				: ((GenClass) genClassifier).getQualifiedClassName();
	}
	
	public @Nullable String getQualifiedFactoryInstanceAccessor(@NonNull Type astType) {
		GenPackage genPackage = getGenPackage(astType);
		if (genPackage == null) {
			return null;
		}
		return genPackage.getQualifiedFactoryInstanceAccessor();
	}
		
	/**
	 * 
	 * @param type a type
	 * @return the name of the java package name of the java interface 
	 * corresponding to the given Type
	 */
	public @Nullable String getInterfacePackageName(Type type) {
		GenPackage genPackage = getGenPackage(type);
		return genPackage.getClassPackageName(); 
	}
}