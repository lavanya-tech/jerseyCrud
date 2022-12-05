package org.lavanya.projects.studentjersey;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class StudentRepository {

	Connection con = null;
	
	public StudentRepository() {
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String username = "root";
		String password = "Lavanya@2002#";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);  
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		String sql = "select * from students";
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Student s = new Student();
				s.setRollno(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setBranch(rs.getString(3));
				students.add(s);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return students;
	}
	
	public Student getStudent(int rollno) {
		String sql = "select * from students where rollno="+rollno;
		Student s = new Student();
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				s.setRollno(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setBranch(rs.getString(3));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return s;
	}

	public void createStudent(Student s) {
		String sql = "insert into students values (?,?,?)";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, s.getRollno());
			st.setString(2, s.getName());
			st.setString(3, s.getBranch());
			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void updateStudent(Student s) {
		String sql = "update students set name=?, branch=? where rollno=?";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(3, s.getRollno());
			st.setString(1, s.getName());
			st.setString(2, s.getBranch());
			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void deleteStudent(int rollno) {
		String sql = "delete from students where rollno = ?";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, rollno);
			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
