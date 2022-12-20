package org.lavanya.projects.studentjersey.models;

import java.util.List;

public class Policy {
	private List<Node> nodes;
	private List<Assignment> assignments;

	public Policy(List<Node> nodes, List<Assignment> assignments) {
		super();
		this.nodes = nodes;
		this.assignments = assignments;
	}

	public Policy() {
		super();
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}
}
