package org.eclipse.m2m.qvt.oml.util;

import java.io.IOException;
import java.io.Writer;
import java.text.MessageFormat;

import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;

/**
 * A basic log objects backed-up with {@link Writer}. 
 * 
 * @author dvorak
 */
public class WriterLog implements Log {
	
	private static final String LINE_SEP = System.getProperty("line.separator"); //$NON-NLS-1$
		
	private Writer fWriter;	
	private String fRecordSeparator;	
	private boolean fErrorLogged;
	
	/**
	 * Constructs a log for the given writer object.
	 * 
	 * @param writer
	 *            the writer object to receive the log record data
	 * @throws IllegalArgumentException
	 *             if the passed <code>writer</code> is <code>null</code>
	 */
	public WriterLog(Writer writer) {
		if(writer == null) {
			throw new IllegalArgumentException("null writer"); //$NON-NLS-1$
		}
		
		fWriter = writer; 
		fRecordSeparator = LINE_SEP;
		fErrorLogged = false;
	}
	
	public void log(int level, String message, Object param) {
		String recordStr = MessageFormat.format("Level {0} - {1}, data: {2}", level, message, String.valueOf(param)); //$NON-NLS-1$
		logRecord(recordStr);
	}
	
	public void log(int level, String message) {
		String recordStr = MessageFormat.format("Level {0} - {1}", level, message); //$NON-NLS-1$
		logRecord(recordStr);
	}

	public void log(String message, Object param) {
		String recordStr = MessageFormat.format("{0}, data: {1}", message, String.valueOf(param)); //$NON-NLS-1$
		logRecord(recordStr);
	}		
	
	public void log(String message) {
		logRecord(message);
	}
	
	private void logRecord(String recordStr) {
		try {
			fWriter.write(recordStr);
			fWriter.write(fRecordSeparator);			
		} catch (IOException e) {
			if(!fErrorLogged) {
				QvtPlugin.log(e);
				fErrorLogged = true;
			}
		}
	}	
}
