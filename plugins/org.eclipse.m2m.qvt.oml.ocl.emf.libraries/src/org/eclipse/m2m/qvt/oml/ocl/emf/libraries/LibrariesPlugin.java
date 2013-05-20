/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.ocl.emf.libraries;

import java.io.ByteArrayOutputStream;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.osgi.framework.BundleContext;

public class LibrariesPlugin extends Plugin {
	
	public static final String OCL_LIBRARY_PACKAGE =
		EPackage.Registry.INSTANCE.get(EcoreEnvironment.OCL_STANDARD_LIBRARY_NS_URI) instanceof EPackage ?
				((EPackage) EPackage.Registry.INSTANCE.get(EcoreEnvironment.OCL_STANDARD_LIBRARY_NS_URI)).getName() : "oclstdlib"; //$NON-NLS-1$

    private static final String LOGLEVEL_OPTION = "/loglevel"; //$NON-NLS-1$

    @Override
	public void start(BundleContext context) throws Exception {
        super.start(context);
        String logLevelString = Platform.getDebugOption(getBundle()
                .getSymbolicName()
                + LOGLEVEL_OPTION);
        java.util.logging.Logger.getLogger(Logger.LOGGER_NAME).setLevel(
                getLogLevel(logLevelString, Level.SEVERE));
        java.util.logging.Logger.getLogger(Logger.LOGGER_NAME).addHandler(
                new PluginLogHandler());
    }

    private Level getLogLevel(String level, Level def) {
        if (level == null || level.trim().equals("")) { //$NON-NLS-1$
            return def;
        }
        level = level.trim().toUpperCase();
        try {
            return Level.parse(level);
        } catch (IllegalArgumentException ie) {
            return def;
        }
    }
    
    private class PluginLogHandler extends StreamHandler {

        @Override
		public void publish(LogRecord record) {
            int severity = IStatus.OK;
            if (record.getLevel() == Level.SEVERE) {
                severity = IStatus.ERROR;
            } else if (record.getLevel() == Level.WARNING) {
                severity = IStatus.WARNING;
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            setOutputStream(outputStream);
            super.publish(record);
            super.close();
            getLog().log(
                    new Status(severity, getBundle().getSymbolicName(), 0,
                            outputStream.toString(), record.getThrown()));
        }

        @Override
		public void flush() {
        }

        @Override
		public void close() throws SecurityException {
        }
    }

}
