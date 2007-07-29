package org.eclipse.m2m.qvt.oml.ui.wizards;

import java.util.LinkedHashSet;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.common.model.ManyObjectFeature;

public class NewQVTModuleImportData implements INewQVTModuleImportData {

    private ManyObjectFeature<EPackage> myMetamodelIds = new ManyObjectFeature<EPackage>(
            new LinkedHashSet<EPackage>(), EPackage.class);

    private ManyObjectFeature<String> myLibraryIds = new ManyObjectFeature<String>(
            new LinkedHashSet<String>(), String.class);

    private ManyObjectFeature<String> myTransformationIds = new ManyObjectFeature<String>(
            new LinkedHashSet<String>(), String.class);

	
	
    public ManyObjectFeature<String> getTransformationIds() {
        return myTransformationIds;
    }
    
    public ManyObjectFeature<String> getLibraryIds() {
        return myLibraryIds;
    }

    public ManyObjectFeature<EPackage> getMetamodels() {
        return myMetamodelIds;
    }    
}
