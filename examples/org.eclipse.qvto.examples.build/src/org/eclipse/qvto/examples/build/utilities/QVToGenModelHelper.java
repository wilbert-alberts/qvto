package org.eclipse.qvto.examples.build.utilities;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
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