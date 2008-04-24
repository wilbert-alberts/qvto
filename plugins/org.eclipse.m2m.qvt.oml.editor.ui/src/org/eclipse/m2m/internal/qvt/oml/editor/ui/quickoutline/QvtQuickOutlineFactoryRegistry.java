/*******************************************************************************
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.quickoutline;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionDelta;
import org.eclipse.core.runtime.IRegistryChangeEvent;
import org.eclipse.core.runtime.IRegistryChangeListener;
import org.eclipse.core.runtime.Platform;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;
import org.eclipse.ui.IPluginContribution;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.activities.ActivityManagerEvent;
import org.eclipse.ui.activities.IActivityManagerListener;
import org.eclipse.ui.activities.WorkbenchActivityHelper;

/**
 * @author aigdalov
 * Created on Apr 23, 2008
 */
public class QvtQuickOutlineFactoryRegistry {
    public static final String EXT_POINT_ID = "quickOutlineFactory"; //$NON-NLS-1$
    
    public static final String ELEMENT_QUICK_OUTLINE = "quickOutline"; //$NON-NLS-1$
    public static final String ATTRIBUTE_CLASS = "class"; //$NON-NLS-1$

    private static IQvtQuickOutlineFactory ourQvtQuickOutlineFactory;
    
    
    private static IRegistryChangeListener ourRegistryChangeListener = new IRegistryChangeListener() {
        public void registryChanged(IRegistryChangeEvent event) {
            IExtensionDelta[] extensionDeltas = event.getExtensionDeltas(Activator.PLUGIN_ID, EXT_POINT_ID);
            if (extensionDeltas.length != 0) {
                refresh();
            }
        }
    };
    
    private static IActivityManagerListener ourActivityChangeListener = new IActivityManagerListener() {
        public void activityManagerChanged(ActivityManagerEvent event) {
            if(event.haveEnabledActivityIdsChanged()) {
                refresh();
            }
        }
    };

    static {
        refresh();
        Platform.getExtensionRegistry().addRegistryChangeListener(ourRegistryChangeListener, Activator.PLUGIN_ID);
        PlatformUI.getWorkbench().getActivitySupport().getActivityManager().addActivityManagerListener(ourActivityChangeListener);
    }
    
    public static final IQvtQuickOutlineFactory  getQvtQuickOutlineFactory() {
        return ourQvtQuickOutlineFactory;
    }

    private static IQvtQuickOutlineFactory initFactory() {
        IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(Activator.PLUGIN_ID, EXT_POINT_ID);
        for (IConfigurationElement configurationElement : configurationElements) {
            if(isFiltered(configurationElement)) {
                continue;
            }
            if (ELEMENT_QUICK_OUTLINE.equals(configurationElement.getName())) {
                try {
                    return (IQvtQuickOutlineFactory) configurationElement.createExecutableExtension(ATTRIBUTE_CLASS);
                } catch (CoreException ex) {
                    Activator.log(ex);
                }
            }
        }
        return null;
    }
    
    public static final void refresh() {
        ourQvtQuickOutlineFactory = initFactory();
    }
    
    private static boolean isFiltered(IConfigurationElement configurationElement) {
        final IExtension extension = configurationElement.getDeclaringExtension();
        IPluginContribution contribution = new IPluginContribution() {
            public String getLocalId() {                
                return extension.getSimpleIdentifier();
            }
            public String getPluginId() {
                return extension.getContributor().getName();
            }
        };
        return WorkbenchActivityHelper.filterItem(contribution);
    }
}
