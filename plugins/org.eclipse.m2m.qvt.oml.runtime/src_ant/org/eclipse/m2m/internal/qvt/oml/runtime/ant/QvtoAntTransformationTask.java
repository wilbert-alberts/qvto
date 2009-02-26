/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.ant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ShallowProcess;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchConfigurationDelegateBase;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtValidator;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.osgi.util.NLS;

/**
 *  NOTE: all the URIs are workspace-relative
 */
public class QvtoAntTransformationTask extends Task {
	
	public static interface ModelParameter {
	}
	
	/**
	 *  ModelParameter of [in] type for the transformation 
	 */
	public static class In implements ModelParameter {
	    
	    public In() {
	    }
	    
	    public URI getURI() {
	        return toUri(myUri);
	    }
	    
	    public void setUri(String uri) {
	        myUri = uri;
	    }
	    
	    private String myUri;
	}
	
	/**
	 *  ModelParameter of [inout] type for the transformation 
	 */
	public static class Inout implements ModelParameter {
	    
	    public Inout() {
	    }
	    
	    public URI getURI() {
	        return toUri(myUri);
	    }
	    
	    public void setUri(String uri) {
	        myUri = uri;
	    }
	    
	    public URI getOutURI() {
	        return toUri(myOutUri);
	    }
	    
	    public void setOuturi(String uri) {
	    	myOutUri = uri;
	    }
	    
	    TargetUriData getTargetUriData() {
	        String outUriString = myOutUri != null && myOutUri.trim().length() > 0 ? myOutUri : myUri;
	        return new TargetUriData(outUriString);
	    }
	    
	    private String myUri;
	    private String myOutUri;
	}
	
	/**
	 *  ModelParameter of [out] type for the transformation 
	 */
	public static class Out implements ModelParameter {
	    
	    public Out() {
	    }
	    
	    public URI getURI() {
	        return toUri(myUri);
	    }
	    
	    public void setUri(String uri) {
	        myUri = uri;
	    }
	    
	    TargetUriData getTargetUriData() {
	        return new TargetUriData(myUri);
	    }
	    
	    private String myUri;
	}
	
	/**
	 *  Trace element - specifies a trace definition 
	 *  for the transformation 
	 */
	public static class Trace {
	    
	    public Trace() {
	    }
	    
	    public URI getURI() {
	        return toUri(myUri);
	    }
	    
	    public String getOriginalUri() {
	        return myUri;
	    }
	    
	    public void setUri(String uri) {
	        myUri = uri;
	    }
	    
	    private String myUri;
	}
	
	/**
	 *  Configuration property element - specifies a configuration property value 
	 *  for the transformation 
	 */
	public static class ConfigProperty {
	    
	    public ConfigProperty() {
	    }
	    
	    public String getName() {
	        return name;
	    }
	    
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public String getValue() {
	        return value;
	    }
	    
	    public void setValue(String value) {
	        this.value = value;
	    }
	    
	    private String name;
	    private String value;
	}

	public URI getModuleURI() {
	    return toUri(myModuleUri);
	}
	
	public void setUri(String moduleUri) {
	    myModuleUri = moduleUri;
	}
	
	public void addConfiguredIn(In parameter) {
	   	myModelParameters.add(parameter);
	}
	
	public void addConfiguredInout(Inout parameter) {
	   	myModelParameters.add(parameter);
	}
	
	public void addConfiguredOut(Out parameter) {
	   	myModelParameters.add(parameter);
	}
	
	public void addConfiguredTrace(Trace trace) {
		myTrace = trace;
	}
	
	public void addConfiguredConfigProperty(ConfigProperty configProperty) {
		myConfigProperties.put(configProperty.getName(), configProperty.getValue());
	}
	
	
	/**
	 * Checks up parameters validity and calls doExecute()
	 */
	@Override
	public void execute() throws BuildException {
	
	    final QvtTransformation transformation = getTransformationObject();
	    
	    try {
	        ShallowProcess.IRunnable r = new ShallowProcess.IRunnable() {
	            public void run() throws Exception {
	            	List<ModelContent> inObjects = new ArrayList<ModelContent>();
	            	List<TargetUriData> targetData = new ArrayList<TargetUriData>();
	            	
	        		loadTransformationParams(transformation, inObjects, targetData);
	
	                IStatus status = QvtValidator.validateTransformation(transformation, inObjects);                    
	                if (status.getSeverity() > IStatus.WARNING) {
	                	throw new MdaException(status);
	                }      	
	        		
	        		QvtLaunchConfigurationDelegateBase.doLaunch(transformation,
	        				inObjects, targetData, getConfiguration(), getTraceUri());
	        		
	        		transformation.cleanup();
	            }

	        };
	        
	        r = QvtLaunchConfigurationDelegateBase.getSafeRunnable(transformation, r);
	        r.run();
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	        throw new BuildException(StatusUtil.getExceptionMessages(e), e);
	    }
	
	    System.out.println(NLS.bind(Messages.TransformationExecuted, getModuleURI()));   
	}    
	
	/**
	 * @return a transformation to be executed
	 */
	private QvtTransformation getTransformationObject() {
        try {
			return new QvtInterpretedTransformation(TransformationUtil.getQvtModule(getModuleURI()));
		} catch (Exception e) {
            throw new BuildException(
                    NLS.bind(
                            Messages.AbstractApplyTransformationTask_File_not_found, 
                            getModuleURI()
                        ),
                    e
                    );
		}
	}

	private void loadTransformationParams(QvtTransformation transformation,
			List<ModelContent> inObjects, List<TargetUriData> targetData) throws MdaException {
		
		Iterator<ModelParameter> itrModelParam = myModelParameters.iterator();
		for (TransformationParameter transfParam : transformation.getParameters()) {
			if (!itrModelParam.hasNext()) {
	            throw new BuildException(NLS.bind(Messages.AbstractApplyTransformationTask_Required_attribute_is_not_specified,
	            		transfParam.getName()));
			}
			ModelParameter modelParam = itrModelParam.next();
			if (transfParam.getDirectionKind() == DirectionKind.IN) {
				if (false == modelParam instanceof In) {
    	            throw new BuildException(NLS.bind(Messages.ModelParameterTypeMismatch,
    	            		transfParam.getName(), DirectionKind.IN.name().toLowerCase()));
				}
				In inParam = (In) modelParam;
				
		        ModelContent inModel = transformation.loadInput(inParam.getURI());
		        inObjects.add(inModel);
			}
			if (transfParam.getDirectionKind() == DirectionKind.INOUT) {
				if (false == modelParam instanceof Inout) {
    	            throw new BuildException(NLS.bind(Messages.ModelParameterTypeMismatch,
    	            		transfParam.getName(), DirectionKind.INOUT.name().toLowerCase()));
				}
				Inout inoutParam = (Inout) modelParam;
				
		        ModelContent inModel = transformation.loadInput(inoutParam.getURI());
		        inObjects.add(inModel);

		        targetData.add(inoutParam.getTargetUriData());
			}
			if (transfParam.getDirectionKind() == DirectionKind.OUT) {
				if (false == modelParam instanceof Out) {
    	            throw new BuildException(NLS.bind(Messages.ModelParameterTypeMismatch,
    	            		transfParam.getName(), DirectionKind.OUT.name().toLowerCase()));
				}
				Out outParam = (Out) modelParam;

				targetData.add(outParam.getTargetUriData());
			}
		}
	}

	private String getTraceUri() {
		if (myTrace == null) {
			return null;
		}
		return myTrace.getOriginalUri();
	}
	
	private Map<String, Object> getConfiguration() {
	    return myConfigProperties;
	}
	
	private static URI toUri(String uriString) throws BuildException {
	    try {
	    	URI uri = URI.createURI(uriString);
	    	if(uri == null) {
	    		throw new BuildException(NLS.bind(Messages.AbstractApplyTransformationTask_File_not_found, uriString));
	    	}
//			if (uri.isRelative()) {
//				URI baseUri = URI.createFileURI(getProject().getBaseDir().getAbsolutePath());
//				uri = baseUri.appendSegments(uri.segments());
//			}
	    	return uri;
	    }
	    catch(Exception e) {
	    	throw new BuildException(e);
	    }
	}
	
	    
	private String myModuleUri;
	private Trace myTrace;
	
	private final List<ModelParameter> myModelParameters = new ArrayList<ModelParameter>(3);
	private final Map<String, Object> myConfigProperties = new LinkedHashMap<String, Object>(3);
}
