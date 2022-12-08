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
	@Path("prohibiton")
	public void add(Prohibition prohibition) throws PMException {
		System.out.println("entered resource");
			service.add(prohibition);
	}
	
	@GET
	@Path("name/{prohibitionName}")
	public Prohibition get(@PathParam("prohibitionName") String prohibitionName) throws PMException {
		return service.get(prohibitionName);
	}

	@GET
	@Path("subject/{subject}")
	public List<Prohibition> getProhibitionsFor(@PathParam("subject") String subject) throws PMException {
		return service.getProhibitionsFor(subject);
	}

	@PUT
	@Path("prohibiton/{prohibitionName}")
	public void update(@PathParam("ProhibitionName") String prohibitionName, Prohibition prohibition) throws PMException {
		service.update(prohibitionName, prohibition);
		
	}

	@DELETE
	@Path("prohibiton/{prohibitionName}")
	public void delete(@PathParam("prohibitionName") String prohibitionName) throws PMException {
		service.delete(prohibitionName);
	}
}
