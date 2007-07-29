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
package org.eclipse.m2m.qvt.oml.common;

import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.m2m.internal.qvt.oml.common.CommonPlugin;


/**
 * @author pkobiakov
 */
public class Logger {
	public static final Level INFO = Level.INFO;
	public static final Level WARNING = Level.WARNING;
	public static final Level SEVERE = Level.SEVERE;

	private Logger() {
	}
	
	public static java.util.logging.Logger getLogger() {
        return new java.util.logging.Logger ("org.eclipse.m2m.qvt.oml.common", null) { //$NON-NLS-1$
            @Override
			public void log(LogRecord record) {
                ILog pluginLog = CommonPlugin.getDefault().getLog();
                IStatus status = new Status(getStatusSeverity(record.getLevel()), CommonPlugin.ID, 1, record.getMessage(), record.getThrown());
                pluginLog.log(status);
            }
        };
	}
    
    private static int getStatusSeverity(Level level) {
        if(level == INFO) {
            return IStatus.INFO;
        }
        else if(level == WARNING) {
            return IStatus.WARNING;
        }
        else if(level == SEVERE) {
            return IStatus.ERROR;
        }
        else {
            return IStatus.ERROR;
        }
    }
}
