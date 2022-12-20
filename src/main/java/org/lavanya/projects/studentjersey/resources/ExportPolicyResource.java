package org.lavanya.projects.studentjersey.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.lavanya.projects.studentjersey.models.Policy;
import org.lavanya.projects.studentjersey.services.ExportPolicyService;

@Path("exportpolicy")
@Produces(MediaType.APPLICATION_JSON)
public class ExportPolicyResource {
	ExportPolicyService ps = new ExportPolicyService();

	@GET
	public Policy exportPolicy() {
		return ps.exportPolicy();
	}
}
