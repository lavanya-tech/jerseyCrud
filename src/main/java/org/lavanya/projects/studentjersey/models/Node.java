package org.lavanya.projects.studentjersey.models;

public class Node {
	private String type;
	private int users;
	private int nodeID;
	private Object nodeType;
	private int uniqueID;
	private String attribute;
	private int threshold;

	public Node() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUsers() {
		return users;
	}

	public void setUsers(int users) {
		this.users = users;
	}

	public int getNodeID() {
		return nodeID;
	}

	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}

	public Object getNodeType() {
		return nodeType;
	}

	public void setNodeType(Object nodeType) {
		this.nodeType = nodeType;
	}

	public int getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public Node(String type, int users, int nodeID, Object nodeType, int uniqueID, String attribute, int threshold) {
		super();
		this.type = type;
		this.users = users;
		this.nodeID = nodeID;
		this.nodeType = nodeType;
		this.uniqueID = uniqueID;
		this.attribute = attribute;
		this.threshold = threshold;
	}
}