package org.lavanya.projects.studentjersey.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import org.lavanya.projects.studentjersey.exceptions.PMException;
import org.lavanya.projects.studentjersey.models.Prohibition;
import org.lavanya.projects.studentjersey.services.ProhibitionService;

@Path("prohibitions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProhibitionResource {
	ProhibitionService service = new ProhibitionService();

	@GET
	public List<Prohibition> getAll() throws PMException {
		return service.getAll();
	}

	@POST
	@Path("prohibition")
	public int add(Prohibition prohibition) throws PMException {
		return service.add(prohibition.getName(),prohibition.getSubject(),prohibition.getOperations());
	}

	@GET
	@Path("prohibition/id/{prohibitionId}")
	public Prohibition get(@PathParam("prohibitionId") int prohibitionId) throws PMException {
		return service.get(prohibitionId);
	}

	@GET
	@Path("prohibition/subject/{prohibitionSubject}")
	public List<Prohibition> getProhibitionsFor(@PathParam("prohibitionSubject") String prohibitionSubject)
			throws PMException {
		return service.getProhibitionsFor(prohibitionSubject);
	}

	@PUT
	@Path("prohibition/{prohibitionId}")
	public void update(@PathParam("prohibitionId") int prohibitionId, Prohibition prohibition) throws PMException {
		service.update(prohibitionId, prohibition.getName(),prohibition.getSubject(),prohibition.getOperations());

	}

	@DELETE
	@Path("prohibition/{prohibitionId}")
	public void delete(@PathParam("prohibitionId") int prohibitionId) throws PMException {
		service.delete(prohibitionId);
	}
}
