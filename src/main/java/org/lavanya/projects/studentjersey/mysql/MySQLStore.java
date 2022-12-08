package org.lavanya.projects.studentjersey.mysql;

import java.sql.Connection;
import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.lavanya.projects.studentjersey.exceptions.PMException;
import org.lavanya.projects.studentjersey.models.Prohibition;
import org.lavanya.projects.studentjersey.operations.OperationSet;
import org.lavanya.projects.studentjersey.prohibitionPAP.ProhibitionMachine;

public class MySQLStore implements ProhibitionMachine{
	Connection con = null;
	
	public MySQLStore() {
		String url = "jdbc:mysql://localhost:3306/ProhibitionDB";
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

	@Override
	public void add(Prohibition prohibition) throws PMException {
		String sql = "insert into prohibitions(name,subject,operations,status) values(?,?,?,?)";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,prohibition.getName() );
			st.setString(2, prohibition.getSubject());
			st.setObject(3, prohibition.getOperations());
			st.setBoolean(4, true);
			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	public OperationSet jsontohashset(Object object) {
		GsonBuilder builder = new GsonBuilder(); 
	    builder.setPrettyPrinting();   
	    Gson gson = builder.create();
		OperationSet os = gson.toJson(object);;
		return os;
	}
	@Override
	public List<Prohibition> getAll() throws PMException {
		List<Prohibition> prohibitions = new ArrayList<>();
		String sql = "select * from prohibitions";
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getObject(4));
				//OperationSet os = new OperationSet(gson.fromJson(rs.getObject(4)));
				//OperationSet os = new OperationSet((HashSet<String>) rs.getObject(4));
				Prohibition p = new Prohibition(rs.getInt(1),rs.getString(2),rs.getString(3),jsontohashset(rs.getObject(4)),rs.getDate(5),rs.getBoolean(6));
				prohibitions.add(p);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return prohibitions;
	}

	@Override
	public Prohibition get(String prohibitionName) throws PMException {
		String sql = "select * from prohibitions where name="+prohibitionName;
		Prohibition p = null;
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				OperationSet os = new OperationSet((String[]) rs.getObject(4));
				p = new Prohibition(rs.getInt(1),rs.getString(2),rs.getString(3),os,rs.getDate(5),rs.getBoolean(6));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return p;
	}

	@Override
	public List<Prohibition> getProhibitionsFor(String subject) throws PMException {
		String sql = "select * from prohibitions where subject="+subject;
		List<Prohibition> prohibitions = new ArrayList<>();
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				OperationSet os = new OperationSet((String[]) rs.getObject(4));
				Prohibition p = new Prohibition(rs.getInt(1),rs.getString(2),rs.getString(3),os,rs.getDate(5),rs.getBoolean(6));
				prohibitions.add(p);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return prohibitions;
	}

	@Override
	public void update(String prohibitionName, Prohibition prohibition) throws PMException {
		String sql = "update prohibitions set id=?, name=?, subject=? perations=?, status=? where name=?";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, prohibition.getId());
			st.setString(2,prohibition.getName() );
			st.setString(3, prohibition.getSubject());
			st.setObject(4, prohibition.getOperations());
			st.setBoolean(4, true);
			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	@Override
	public void delete(String prohibitionName) throws PMException {
		String sql = "update prohibitions set status=? where name=?";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setBoolean(1, false);
			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	
}
