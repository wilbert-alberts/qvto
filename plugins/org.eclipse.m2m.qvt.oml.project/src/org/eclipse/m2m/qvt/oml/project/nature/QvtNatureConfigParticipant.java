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
package org.eclipse.m2m.qvt.oml.project.nature;

import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.m2m.qvt.oml.builder.QvtBuilder;
import org.eclipse.m2m.qvt.oml.common.project.NatureUtils;


/**
 * Adds/removes QVT builder specific settings to transformation project nature.
 */
public class QvtNatureConfigParticipant implements TransformationNatureConfigParticipant {
	
	public QvtNatureConfigParticipant() {
	}
	
	public void configure(IProjectDescription projectDesc) {	
		NatureUtils.addBuilders(projectDesc,
				new String[] { QvtBuilder.ID } ,
				new String[] { } );
	}
	
	public void deconfigure(IProjectDescription projectDesc) {
		NatureUtils.removeBuilders(projectDesc, new String[] { QvtBuilder.ID });
	}
}
