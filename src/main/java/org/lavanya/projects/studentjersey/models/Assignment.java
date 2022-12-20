package org.lavanya.projects.studentjersey.models;

public class Assignment {
	private int sourceID;
	private int targetID;

	public int getSourceID() {
		return sourceID;
	}

	public void setSourceID(int sourceID) {
		this.sourceID = sourceID;
	}

	public int getTargetID() {
		return targetID;
	}

	public void setTargetID(int targetID) {
		this.targetID = targetID;
	}

	public Assignment(int sourceID, int targetID) {
		super();
		this.sourceID = sourceID;
		this.targetID = targetID;
	}

	public Assignment() {
		super();
	}
}
