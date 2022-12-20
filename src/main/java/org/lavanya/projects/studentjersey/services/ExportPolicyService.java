package org.lavanya.projects.studentjersey.services;

import java.util.ArrayList;
import java.util.List;

import org.lavanya.projects.studentjersey.models.Assignment;
import org.lavanya.projects.studentjersey.models.Node;
import org.lavanya.projects.studentjersey.models.Policy;

public class ExportPolicyService {

	public Policy exportPolicy() {

		Node node1 = new Node("ROOT", 2, 1, null, 1, "cbaad3cf4a6507e5d6f98157fa255ca964588c8c30ecf198fb9c98ed97413f59",
				2);
		Node node2 = new Node("NON_LEAF", 2, 2, null, 2,
				"66880d2d8216260d201917a72eb245440ef18ba9b54c070ee39aa4c343ae126f", 2);
		List<Node> nodes = new ArrayList<Node>();
		Assignment assignment1 = new Assignment(2, 1);
		Assignment assignment2 = new Assignment(3, 1);
		List<Assignment> assignments = new ArrayList<Assignment>();
		assignments.add(assignment1);
		assignments.add(assignment2);
		nodes.add(node1);
		nodes.add(node2);
		Policy policy = new Policy(nodes, assignments);
		return policy;
	}
}
