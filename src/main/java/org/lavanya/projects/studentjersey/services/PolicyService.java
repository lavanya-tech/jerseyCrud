package org.lavanya.projects.studentjersey.services;

import org.lavanya.projects.studentjersey.models.Assignment;
import org.lavanya.projects.studentjersey.models.Node;
import org.lavanya.projects.studentjersey.models.Policy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class PolicyService {

	// private static final ObjectReader reader = new
	// ObjectMapper().readerFor(Policy.class);

	public void importPolicy(Policy p) throws JsonMappingException, JsonProcessingException {
		// Policy p = reader.readValue(policy);
		for (Node n : p.getNodes()) {
			System.out.println(n.getType());
			System.out.println(n.getUsers());
			System.out.println(n.getNodeID());
			System.out.println(n.getNodeType());
			System.out.println(n.getUniqueID());
			System.out.println(n.getAttribute());
			System.out.println(n.getThreshold());
		}
		for (Assignment a : p.getAssignments()) {
			System.out.println(a.getSourceID());
			System.out.println(a.getTargetID());
		}
	}
}
