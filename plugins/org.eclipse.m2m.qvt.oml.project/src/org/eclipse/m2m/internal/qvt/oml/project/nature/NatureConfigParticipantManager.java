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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.m2m.internal.qvt.oml.common.CommonPlugin;


public class NatureConfigParticipantManager {
	
	private static final String POINT_ID = CommonPlugin.ID + ".transformNatureConfigParticipants"; //$NON-NLS-1$
	private static final String CLASS_ATTR = "class"; //$NON-NLS-1$
	private static final String PARTICIPANT_ELEMENT = "configParticipant"; //$NON-NLS-1$	
	
	private static List<TransformationNatureConfigParticipant> participants;
	
	
	private NatureConfigParticipantManager() {
	}
	
	public static synchronized TransformationNatureConfigParticipant[] getParticipants() {
		if(participants == null) {
			participants = loadExtensions();
		}
		return participants.toArray(new TransformationNatureConfigParticipant[participants.size()]);
	}
	
	private static List<TransformationNatureConfigParticipant> loadExtensions() {
		ArrayList<TransformationNatureConfigParticipant> result = new ArrayList<TransformationNatureConfigParticipant>();
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(POINT_ID);
		for (int i = 0; i < configurationElements.length; i++) {
			IConfigurationElement nextElement = configurationElements[i];
			if(PARTICIPANT_ELEMENT.equals(nextElement.getName()) && nextElement.getAttribute(CLASS_ATTR) != null) {
				try {
					Object extensionObj = nextElement.createExecutableExtension(CLASS_ATTR);
					if(extensionObj instanceof TransformationNatureConfigParticipant) {
						result.add((TransformationNatureConfigParticipant)extensionObj);
					}
				} catch (CoreException e) {		
					CommonPlugin.log(e.getStatus());
				}
			}
		}
		
		result.trimToSize();
		return result;
	}
}
