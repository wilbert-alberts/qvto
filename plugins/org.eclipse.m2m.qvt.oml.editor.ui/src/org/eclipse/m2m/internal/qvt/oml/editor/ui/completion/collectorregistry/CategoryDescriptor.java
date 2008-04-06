package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.collectorregistry;

public class CategoryDescriptor {
	private final String myId;
	private final String myLabel;
	private final int myPriority;
	
	public CategoryDescriptor(String id, String label, int priority) {
		myId = id;
		myLabel = label;
		myPriority = priority;
	}

	public String getId() {
		return myId;
	}

	public String getLabel() {
		return myLabel;
	}

	public int getPriority() {
		return myPriority;
	}
}