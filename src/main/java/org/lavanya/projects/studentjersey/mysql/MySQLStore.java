package org.lavanya.projects.studentjersey.mysql;

import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.lavanya.projects.studentjersey.exceptions.PMException;
import org.lavanya.projects.studentjersey.models.Prohibition;
import org.lavanya.projects.studentjersey.operations.OperationSet;
import org.lavanya.projects.studentjersey.prohibitionPAP.ProhibitionMachine;

public class MySQLStore implements ProhibitionMachine{
	Connection con = null;
	private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ObjectReader reader2 = new ObjectMapper().readerFor(OperationSet.class);
    
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
	public int add(Prohibition prohibition) throws PMException {
		String sql = "insert into prohibitions(name,subject,operations,status) values(?,?,?,?)";
		int last_id = 0;
		try(PreparedStatement st = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);)
		{
			st.setString(1,prohibition.getName());
			st.setString(2, prohibition.getSubject());
			st.setObject(3, hashSetToJSON(prohibition.getOperations()));
			st.setBoolean(4, true);
			st.executeUpdate();
		    try (ResultSet keys = st.getGeneratedKeys()) 
		    {
		    	if(keys.next())
		    		last_id = keys.getInt(1);
		    }
		    catch(Exception e)
			{
				System.out.println(e);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return last_id;
	}
	
	public static String hashSetToJSON(Set<String> set) throws JsonProcessingException {
        return objectMapper.writeValueAsString(set);
    }
	
	@Override
	public List<Prohibition> getAll() throws PMException {
		List<Prohibition> prohibitions = new ArrayList<>();
		String sql = "select * from prohibitions";
		try(Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);)
		{
			while(rs.next())
			{
				OperationSet os= reader2.readValue(rs.getString(4));
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
	public Prohibition get(int prohibitionId) throws PMException {
		String sql = "select * from prohibitions where id="+prohibitionId;
		Prohibition p = null;
		try(Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);)
		{
			if(rs.next())
			{
				OperationSet os= reader2.readValue(rs.getString(4));
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
	public List<Prohibition> getProhibitionsFor(String prohibitionSubject) throws PMException {
		String sql = "select * from prohibitions where subject=?";
		List<Prohibition> prohibitions = new ArrayList<>();
		try(PreparedStatement st = con.prepareStatement(sql);)
		{
			st.setString(1,prohibitionSubject);	
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				OperationSet os= reader2.readValue(rs.getString(4));
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
	public void update(int prohibitionId, Prohibition prohibition) throws PMException {
		String sql = "update prohibitions set name=?, subject=?, operations=? where id="+prohibitionId;
		try(PreparedStatement st = con.prepareStatement(sql);)
		{
			st.setString(1,prohibition.getName());
			st.setString(2, prohibition.getSubject());
			st.setObject(3, hashSetToJSON(prohibition.getOperations()));
			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	@Override
	public void delete(int prohibitionId) throws PMException {
		String sql = "update prohibitions set status=? where id="+prohibitionId;
		try(PreparedStatement st = con.prepareStatement(sql);)
		{
			st.setBoolean(1, false);
			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
