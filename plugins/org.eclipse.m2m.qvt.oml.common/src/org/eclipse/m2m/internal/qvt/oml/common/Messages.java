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
package org.eclipse.m2m.internal.qvt.oml.common;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.common.messages"; //$NON-NLS-1$

    private Messages() {
    }

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }
    
    public static String Add;
    public static String Composite_transformation_content;
    public static String Default_task_name;
    public static String Delete;
    public static String Down;
    public static String Here_you_can;
    public static String MDA_Composite_transformation;
	public static String MultiplicityValidator_0;
	public static String MultiplicityValidator_1;
    public static String Name;
    //public static String New_Composite_Transformation_Feature;
    public static String New_Composite_Transformation_Wizard;
    public static String Project_name;
    public static String TaskModelFactory_Unsupported_launch_configuration_type;
    public static String ChooseDataSourcePage_Enter_launch_configuration_data;
    public static String ChooseDataSourceTypePage_Choose_data_source_type;
    public static String ChooseDataSourceTypePage_Decide_where_to_get_task_data_from;
    public static String ChooseDataSourceTypePage_Enter_data_manually;
    public static String ChooseDataSourceTypePage_Select_existing_launch_configuration;
    public static String ChooseDataSourcePage_Select_launch_configuration_type;
    public static String ChooseDataSourcePage_select_the_launch_configuration_type;
    public static String ChooseDataSourcePage_Select_launch_configuration;
    public static String ChooseDataSourcePage_select_the_launch_configuration_to_create_a_task_from;
    public static String Up;
    public static String Value;
    public static String ValueRequiredValidator_Value_is_to_be_set;
    public static String FileUtil_CannotDelete;
    public static String ClasspathUtil_FailedToCollectClassPath;
    public static String ClasspathUtil_FailedToGetOutputURL;
    public static String ClasspathUtil_NoBundle;
    public static String ShallowProcess_Label;
    public static String ShallowProcess_InvalidState;
    public static String ClasspathUtil_InvalidJavaOutputPath;  
    public static String ParameterizedStringParser_UnterminatedVariable;
}
