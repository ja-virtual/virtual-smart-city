package edu.si.ing1.pds.vsc.connectionPool;


import java.io.*;
import java.sql.Driver;

import java.util.Properties;
import java.sql.*;

public class ConnectionDB {
	//attribute
	private String Driver;
	private String URL;
	private String username;
	private String password;

	private String create;
	private String read;
	private String update;
	private String delete;
	
	//who have acces read only
	
public String getDriver() {
		return Driver;
	}
	public String getURL() {
		return URL;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	Connection connection=null;
	//the builder
public ConnectionDB() 
{
	Properties props = new Properties();
	InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
	try {
		props.load(inStream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	read=props.getProperty("personne.read");
	create=props.getProperty("personne.create");
	update=props.getProperty("personne.update");
	delete=props.getProperty("personne.delete");
	Driver=props.getProperty("database.driverClassName");
    URL=props.getProperty("database.url");
	username=props.getProperty("database.username");
    password=props.getProperty("database.password");

		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.connection = DriverManager.getConnection(URL, 
					username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}
	
	public String info()
	{
		if(connection != null)
		return "connection succed!";
		else
			return "error !";
	}


	public String createPerson(String name, int age)
	{
		try {
			PreparedStatement pc = connection.prepareStatement(create);
			pc.setString(1, name);
			pc.setInt(2, age);
			int nb = 0;
			nb = pc.executeUpdate();
			if(nb!=0)
				return "The person with the name "+name + " is added with success!!";
		}catch(SQLException ex)
		{
			return "failed!!";
		}
			return "failed!!";
	}
	public String updatePerson(int id,String name) throws Exception
	{
		int age=0;
		try {
			ResultSet result=listPerson();
			while(result.next())
			{
				age=3;
				if(result.getInt(1)==id)
					age=result.getInt(3);
				break;
			}
			result.close();
			PreparedStatement pc = connection.prepareStatement(update);
			pc.setString(1, name);
			pc.setInt(2, age);
			pc.setInt(3, id);
			int nb = 0;
			nb = pc.executeUpdate();
			if(nb!=0)
				return "The person with the name "+name + " is modified with success!!";
		}catch(SQLException ex)
		{
			return "failed with error !!";
		}
		return "failed!!";
	}
	public String updatePerson(int id,int age)throws Exception
	{
		String name="";
		try {
			ResultSet result=listPerson();
			while(result.next())
			{
				if(result.getInt(1)==id)
					name=result.getString(2);
				break;

			}
			result.close();
			PreparedStatement pc = connection.prepareStatement(update);
			pc.setString(1, name);
			pc.setInt(2, age);
			pc.setInt(3, id);
			int nb = 0;
			nb = pc.executeUpdate();
			if(nb!=0)
				return "The person with the name "+name + " is modified with success!!";
		}catch(SQLException ex)
		{
			return "failed with error !!";
		}
		return "failed!!";
	}
	public String updatePerson(int id,String name, int age)
	{
		try {
			PreparedStatement pc = connection.prepareStatement(update);
			pc.setString(1, name);
			pc.setInt(2, age);
			pc.setInt(3, id);
			int nb = 0;
			nb = pc.executeUpdate();
			if(nb!=0)
				return "The person with the name "+name + " is modified with success!!";
		}catch(SQLException ex)
		{
			return "failed with error !!";
		}
		return "failed!!";
	}
	public String deletePerson(int id)
	{
		try {
			PreparedStatement pc = connection.prepareStatement(delete);
			pc.setInt(1,id);
			int nb = 0;
			nb = pc.executeUpdate();
			if(nb!=0)
				return "The person with the id "+id+" is deleted with success!!";
		}catch(SQLException ex)
		{
			return "failed!!";
		}
		return "failed!!";
	}
	public ResultSet listPerson() throws Exception
	{
			Statement request=connection.createStatement();
			ResultSet result=null;
			result=request.executeQuery(read);
			return result;
	}



}
