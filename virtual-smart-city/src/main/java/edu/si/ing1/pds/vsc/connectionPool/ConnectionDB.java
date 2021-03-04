package edu.si.ing1.pds.vsc.connectionPool;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.PreparedStatement;

public class ConnectionDB {
	//attribute
	private String Driver;
	private String URL;
	private String username;
	private String password;
	//provisoire
	private String create;
	private String update;
	
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
	create=props.getProperty("personne.create");
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
	
	public String Info()
	{
		if(connection != null)
		return "connection succed!";
		else
			return "error !";
	}


	public String CreatePersonne(String nom, int age)
	{
		try {
			PreparedStatement pc = connection.prepareStatement(create);
			pc.setString(1, nom);
			pc.setInt(2, age);
			int nb = 0;
			nb = pc.executeUpdate();
			if(nb!=0)
				return nom + " added with success!!";
		}catch(SQLException ex)
		{
			return "failed!!";
		}
			return "failed!!";
	}


}
