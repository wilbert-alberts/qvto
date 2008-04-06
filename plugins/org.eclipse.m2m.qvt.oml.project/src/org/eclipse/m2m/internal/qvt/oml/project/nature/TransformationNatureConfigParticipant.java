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
package org.eclipse.m2m.internal.qvt.oml.project.nature;

import org.eclipse.core.resources.IProjectDescription;

/**
 * Interface allowing other interested parties to participate in 
 * configuration of <code>TransformationNature</code>.
 * 
 * @see TransformationNature
 */
public interface TransformationNatureConfigParticipant {

	/** 
	 * Configures the given project description with informations
	 * specific to this participant.
	 * 
	 * @param projectDesc the project description to be configured
	 */	
	void configure(IProjectDescription projectDesc);

	/** 
	 * Removes information specific to this participant previously 
	 * configured by this participant
	 * 
	 * @param projectDesc the project description to be de-configured
	 */		
	void deconfigure(IProjectDescription projectDesc);
}
