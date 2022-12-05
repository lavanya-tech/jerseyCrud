package org.lavanya.projects.studentjersey;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
	List<Student>students;

	public StudentRepository() {
		students = new ArrayList<>();
		Student s1 = new Student();
		s1.setName("lavanya");
		s1.setRollno(1);
	}
	
	public List<Student> getStudents(){
		return students;
	}
	
	public Student getStudent(int r) {
		for(Student i: students)
		{
			if(i.getRollno() == r)
				return i;
		}
		return null;
	}

	public List<Student> createStudent(Student s) {
		students.add(s);
		return students;
	}

}
