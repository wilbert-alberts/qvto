package org.eclipse.m2m.qvt.oml.util;

import java.io.StringWriter;

/**
 * A convenience implementation of a String content based log, mainly
 * suitable for testing and debugging purposes.
 * 
 * @author dvorak
 */
public class StringBufferLog extends WriterLog {

	/**
	 * Constructs a default log object.
	 */
	public StringBufferLog() {
		this(1024);
	}

	/**
	 * Constructs a log object of the given initialize size.
	 * 
	 * @param initialsize
	 *            the initial size of the string buffer associated with this log
	 */	
	public StringBufferLog(int initialsize) {
		super(new StringWriter(initialsize));
	}
}
