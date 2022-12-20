package org.lavanya.projects.studentjersey.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.lavanya.projects.studentjersey.models.Policy;
import org.lavanya.projects.studentjersey.services.PolicyService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Path("importpolicy")
@Consumes(MediaType.APPLICATION_JSON)
public class PolicyResource {

	PolicyService ps = new PolicyService();

	@POST
	public void importPolicy(Policy policy) throws JsonMappingException, JsonProcessingException {
		ps.importPolicy(policy);
	}
}
