package edu.si.ing1.pds.vsc.connectionPool;


import java.io.*;
import java.util.Properties;
import java.util.Random;
import java.sql.*;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;


import java.io.File;
import java.io.IOException;

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
	private Person person;
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
	public Connection connection=null;
	private static final String data_smart_city_enVar = "CRUD_SCRIPT";

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
	final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
	try {
       person = mapper.readValue(new File(System.getenv(data_smart_city_enVar)), Person.class);
	} catch (JsonParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (JsonMappingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
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
	
public Person RandomPerson()
{
	Random index=new Random();
	int size=person.getList_person().size();
	Person p=person.getList_person().get(index.nextInt(size-1));
	return p;
}
	public int RandomId()
	{
		int[] id_list=new int[100];
		ResultSet result=null;
		try {
			result = this.listPerson();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int i=0;
		try {
			while (result.next()) {
				id_list[i]=result.getInt(1);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Random index=new Random();
		return id_list[index.nextInt(i)];
	}
	public String createPerson()
	{
		try {

			Person p=RandomPerson();
			PreparedStatement pc = connection.prepareStatement(create);
			pc.setString(1,p.getName());
			pc.setInt(2,p.getAge());
			int nb = 0;
			nb = pc.executeUpdate();
			if(nb!=0)
				return "The person with the name "+p.getName()+ " is added with success!!";
		}catch(SQLException ex)
		{
			return "failed with exception !!";
		}
			return "failed!!";
	}
/*	public String updatePerson(int id,String name) throws Exception
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
	}*/
	public String updatePerson()
	{
		try {
			PreparedStatement pc = connection.prepareStatement(update);
			Random age=new Random();
			int id=RandomId();
			pc.setString(1,"name_updated_"+age.nextInt(80));
			pc.setInt(2,age.nextInt(90));
			pc.setInt(3,id);
			int nb = 0;
			nb = pc.executeUpdate();
			if(nb!=0)
				return "The person with the id "+id + " is modified with success!!";
		}catch(SQLException ex)
		{
			return "failed with exception !!";
		}
		return "failed!!";
	}
	public String deletePerson()
	{
		try {
			PreparedStatement pc = connection.prepareStatement(delete);
			int id=RandomId();
			pc.setInt(1,id);
			int nb = 0;
			nb = pc.executeUpdate();
			if(nb!=0)
				return "The person with the id "+id+" is deleted with success!!";
		}catch(SQLException ex)
		{
			return "failed with exception!!";
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
