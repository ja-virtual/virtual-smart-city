package edu.si.ing1.pds.vsc.connectionPool;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {
	//les attributs
	private String Driver;
	private String URL;
	private String username;
	private String password;
	
	//les accesseurs en mode lecture
	
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
	//le constructeur
public ConnectionDB() 
{
	Properties props = new Properties();
	Driver=props.getProperty("database.driverClassName");
    URL=props.getProperty("database.url");
	username=props.getProperty("database.username");
    password=props.getProperty("database.password");
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
		if(connection!=null)
		return "connection reussie!";
		else
			return "erreur!!";	
	}


}
