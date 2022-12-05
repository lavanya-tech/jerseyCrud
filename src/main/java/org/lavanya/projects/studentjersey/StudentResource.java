package org.lavanya.projects.studentjersey;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("students")
public class StudentResource {
	
	StudentRepository repo = new StudentRepository();
	@GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Student> getStudents() {
		System.out.println("student called-------------");
		return repo.getStudents();
	}
	
	@POST
	@Path("student")
	public List<Student> createStudent(Student s){
		System.out.println(s);
		return repo.createStudent(s);
	}
}
