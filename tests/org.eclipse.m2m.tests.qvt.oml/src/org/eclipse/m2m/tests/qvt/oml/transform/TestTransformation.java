/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.transform;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelExtentContents;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.emf.ExtendedEmfUtil;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.internal.qvt.oml.common.io.IOFile;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.m2m.internal.qvt.oml.project.QVTOProjectPlugin;
import org.eclipse.m2m.internal.qvt.oml.project.builder.QVTOBuilder;
import org.eclipse.m2m.internal.qvt.oml.project.builder.QVTOBuilderConfig;
import org.eclipse.m2m.internal.qvt.oml.project.nature.NatureUtils;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TraceSerializer;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.tests.qvt.oml.TestProject;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;


public abstract class TestTransformation extends TestCase {
    private ModelTestData myData;
    private TestProject myProject;
    private File myDestFolder;

    public TestTransformation(ModelTestData data) {
        super(data.getName());
        
        myData = data;
        myProject = null;
    }
    
    public IProject getProject() {
        return myProject.getProject();
    }
    
    public TestProject getTestProject() {
        return myProject;
    }
    
    public ModelTestData getData() {
    	return myData;
    }
    
    @Override
	public void setUp() throws Exception {
        TestUtil.turnOffAutoBuilding();     
        
        String name = "TransformationTest"; //$NON-NLS-1$
        myProject = TestProject.getExistingProject(name);
        if(myProject == null) {
            myProject = new TestProject(name, new String[] {}, 0); 
            myProject.getProject().setDefaultCharset(ModelTestData.ENCODING, null);
            
    		NatureUtils.addNature(getProject(), QVTOProjectPlugin.NATURE_ID);
    		
    		IProjectDescription description = getProject().getDescription();
    		ICommand[] buildSpec = description.getBuildSpec();
    		ICommand buildCommand = NatureUtils.findCommand(buildSpec, QVTOProjectPlugin.BUILDER_ID);
    		
    		assertNotNull(buildCommand);		
    		@SuppressWarnings("unchecked")
    		Map<String, String> arguments = buildCommand.getArguments();
    		// Remark: internal option for saving xmi, used for testing at the moment		
    		//arguments.put(QVTOBuilder.SAVE_AST_XMI, "true"); //$NON-NLS-1$
    		
    		buildCommand.setArguments(arguments);
    		description.setBuildSpec(buildSpec);
    		getProject().setDescription(description, null);
    		
    		QVTOBuilderConfig.getConfig(getProject()).setSourceContainer(getProject());    		
        }
        
        copyModelData(); 		       
        myData.prepare(myProject);
    }
    
	protected void buildTestProject() throws Exception { 
		getProject().build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
		assertBuildOK(getProject());
    }
	
	protected void assertBuildOK(IProject project) throws Exception {
		IMarker[] problems = project.findMarkers(QVTOProjectPlugin.PROBLEM_MARKER, true, IResource.DEPTH_INFINITE);
		StringBuilder buf = new StringBuilder();
		IMarker firstError = null;
		try {			
			for (IMarker next : problems) {
				if(Integer.valueOf(IMarker.SEVERITY_ERROR).equals(next.getAttribute(IMarker.SEVERITY))) {
					firstError = next;
					break;
				}
			}
			
			if(firstError == null) {
				return;
			}
			
			IMarker marker = firstError;
			buf.append(marker.getAttribute(IMarker.MESSAGE));
			buf.append(", line:").append(marker.getAttribute(IMarker.LINE_NUMBER)); //$NON-NLS-1$
			buf.append(", path:").append(marker.getResource().getProjectRelativePath()); //$NON-NLS-1$
						
		} finally {
			try {
				// do clean even if we have failed
				if(firstError != null) {
					tearDown();
					getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}					
		
		fail(buf.toString());
	}
    
    @Override
	public void tearDown() throws Exception {
    	getData().dispose();
        if (myDestFolder.exists()) {
            delete(myDestFolder);
        }
        getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
    	myData = null;
    }
    
    public static void delete(File file) {
        if(file.isDirectory()) {
            File[] children = file.listFiles();
            for(int i = 0; i < children.length; i++) {
                delete(children[i]);
            }
        }
        
        file.delete();
    }
    
    public static interface IChecker {
        void check(ModelTestData data, IProject project) throws Exception;
    }
    
    public static class TransformationChecker implements IChecker {
        public TransformationChecker(ITransformer transformer) {
            myTransformer = transformer;
        }
        
        public void check(ModelTestData data, IProject project) throws Exception {
            IFile transformation = getIFile(data.getTransformation(project));
            
            LinkedHashMap<ModelExtentContents, URI> transfResult = myTransformer.transform(transformation, data.getIn(project), data.getContext());
        	List<URI> expectedResultURIs = data.getExpected(project);
        	
        	ResourceSetImpl rs = new ResourceSetImpl();
        	rs.setPackageRegistry(data.getMetamodelResolutionRegistry(project, rs));
        	int i = 0;
        	for (ModelExtentContents nextExtent : transfResult.keySet()) {
        		URI uri = expectedResultURIs.get(i++);
        		Resource expectedResource = rs.getResource(uri, true);
        		List<EObject> actualExtentObjects = nextExtent.getAllRootElements();
        		
        		URI actualResultURI = transfResult.get(nextExtent);
        		// reload in the same resource set
        		actualExtentObjects = rs.getResource(actualResultURI, true).getContents();
        		data.compareWithExpected(expectedResource.getContents(), actualExtentObjects);
			}        	
        }
        
        private final ITransformer  myTransformer;
    };
    
    public static interface ITransformer {
    	LinkedHashMap<ModelExtentContents, URI> transform(IFile transformation, List<URI> inUris, IContext context) throws Exception;
    }	

    protected void checkTransformation(IChecker checker) throws Exception {
        checker.check(myData, getProject());
        getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
    }
    
    private void copyModelData() throws Exception {
        File srcFolder = TestUtil.getPluginRelativeFolder("parserTestData/models/" + myData.getName()); //$NON-NLS-1$
        myDestFolder = new File(getProject().getLocation().toString() + "/models/" + myData.getName()); //$NON-NLS-1$
        myDestFolder.mkdirs();
        FileUtil.copyFolder(srcFolder, myDestFolder);
        getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
    }
    
    public static IFile getIFile(File fileUnderWorkspace) {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IPath location = new Path(fileUnderWorkspace.getAbsolutePath());
        IFile ifile = workspace.getRoot().getFileForLocation(location);
        if(ifile == null) {
            throw new RuntimeException("File not found: " + fileUnderWorkspace); //$NON-NLS-1$
        }
        
        return ifile;
    }
        
    public static CFile getTraceFile(CFile qvtFile) throws MdaException {
        String fileName = qvtFile.getUnitName() + MDAConstants.QVTO_TRACEFILE_EXTENSION_WITH_DOT;
        CFile traceFile = qvtFile.getParent().getFile(fileName);
        return traceFile;
    }
    
    public static void saveTraceData(Trace trace, CFile qvtFile) throws MdaException {
        new TraceSerializer(trace).saveTraceModel(getTraceFile(qvtFile));
    }
    
    public static EObject saveLoad(IFile transformation, EObject out) throws Exception {
        String baseName = transformation.getName();
        baseName = baseName.substring(0, baseName.length() - transformation.getFileExtension().length());
        File file = new File(transformation.getParent().getLocation().toFile(), baseName + getExtensionForEObject(out));
        ExtendedEmfUtil.saveModel(out, new IOFile(file));
        ModelContent loadModel = ExtendedEmfUtil.loadModel(new IOFile(file));
        if (loadModel != null && !loadModel.getContent().isEmpty()) {
        	return loadModel.getContent().get(0);
        }
        return null;
    }

    
    public static URI saveModel(String extentName, ModelExtentContents extent, CFile qvtFile) throws MdaException {
        String fileName = qvtFile.getUnitName() + "." + extentName + "." + getExtensionForResult(extent); //$NON-NLS-1$ //$NON-NLS-2$
        CFile outFile = qvtFile.getParent().getFile(fileName);

    	URI uri;
		try {
			uri = URI.createURI(outFile.getFileStore().toURI().toString());
		} catch (IOException e) {
			throw new MdaException(e);
		}
		
		Resource resource = EmfUtil.createResource(uri, new ResourceSetImpl());
    	resource.getContents().addAll(extent.getAllRootElements());
        ExtendedEmfUtil.saveModel(resource, outFile);
        return uri;
    }

    public static String getExtensionForResult(ModelExtentContents extent) {
    	EObject eObject = null;
    	for (EObject nextObject : extent.getAllRootElements()) {
			eObject = nextObject;
			break;
		}
    	
    	if(eObject == null || eObject.eClass() == null || eObject.eClass().getEPackage() == null) {
            return "xmi"; //$NON-NLS-1$
        }
        
        EPackage root = EmfUtil.getRootPackage(eObject.eClass().getEPackage());
        return root.getName();
    }
    
    
    private static String getExtensionForEObject(EObject eObject) {
    	EPackage ePackage = eObject.eClass().getEPackage();
    	if (ePackage == null) {
    		return TransformationUtil.DEFAULT_RESULT_EXTENSION;
    	}
    	return EmfUtil.getRootPackage(ePackage).getName();
    }
}