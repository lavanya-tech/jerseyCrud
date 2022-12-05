package org.lavanya.projects.studentjersey;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {
	
	StudentRepository repo = new StudentRepository();
	@GET
    public List<Student> getStudents() {
		return repo.getStudents();
	}
	
	@GET
	@Path("student/{rollno}")
	public Student getStudent(@PathParam("rollno") int rollno) {
		return repo.getStudent(rollno);
	}
	
	@POST
	@Path("student")
	public void createStudent(Student s){
		repo.createStudent(s);
	}
	
	@PUT
	@Path("student")
	public void updateStudent(Student s){
		Student st = repo.getStudent(s.getRollno());
		if(st.getRollno() != 0)
			repo.updateStudent(s);
	}
	
	@DELETE
	@Path("student/{rollno}")
	public void deleteStudent(@PathParam("rollno") int rollno) {
		Student s = repo.getStudent(rollno);
		if(s.getRollno() != 0)
			repo.deleteStudent(rollno);
	}
}
