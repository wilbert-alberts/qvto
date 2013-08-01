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
	
	public @Nullable String getQualifiedFactoryInstanceAccessor(@NonNull Type astType) {
		GenPackage genPackage = getGenPackage(astType);
		if (genPackage == null) {
			return null;
		}
		return genPackage.getQualifiedFactoryInstanceAccessor();
	}
}