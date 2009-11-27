package org.eclipse.m2m.qvt.oml.debug.core.vm.protocol;


public class NewBreakpointData extends BreakpointData {
	
	private static final long serialVersionUID = -2419723075497828896L;
	
	public long ID;
	public int line = -1;
	public String targetURI;
	
	public NewBreakpointData() {
		super();
	}
	
	public NewBreakpointData(long id, int line, String targetURI, BreakpointData data) {
		super(data);
		this.ID = id;
		this.line = line;
		this.targetURI = targetURI;			
	}
}