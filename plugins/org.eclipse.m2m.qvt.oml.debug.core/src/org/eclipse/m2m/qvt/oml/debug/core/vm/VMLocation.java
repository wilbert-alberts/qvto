package org.eclipse.m2m.qvt.oml.debug.core.vm;

import java.io.Serializable;

public interface VMLocation extends Serializable {

	int getLineNum();

	String getURI();

	String getModule();

	String getOperationSignature();

}