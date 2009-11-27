package org.eclipse.m2m.qvt.oml.debug.core.vm;

import java.io.Serializable;

public class VMVariable implements Serializable {
	
	private static final long serialVersionUID = -7174716073141901340L;
	
	public static final int LOCAL = 0;
	public static final int PROPERTY = 1;
	public static final int THIS = 2;
	public static final int MODEL_PARAMETER = 3;
	public static final int INTERM_PROPERTY = 4;
	public static final int COLLECTION_ELEMENT = 5;

	public String name;
	public String variableURI;
	public Value value;
	public Value.Type type;
	public int kind;
	
	public VMVariable() {
		super();
	}
	
	public boolean isRootVariable() {
		return variableURI == null;
	}
}