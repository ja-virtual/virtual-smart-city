package edu.si.ing1.pds.vsc.connectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;
import org.apache.commons.cli.*;
public class
ConnectionMain {
static Logger logger=Logger.getLogger("test");
	public static void main(String[] args) throws Exception {
		//creation des options
		Options options = new Options();
		Option name = new Option("name", "name", true, "name of the person");
		Option age = new Option("age", "age", true, "age of the person");
		name.setRequired(true);
		age.setRequired(true);
		options.addOption(name);
		options.addOption(age);
		CommandLineParser parser = new DefaultParser();
		HelpFormatter formatter = new HelpFormatter();
		CommandLine commandLine;
		commandLine = parser.parse(options, args);
		String name_test="";
		int age_test=0;
		ConnectionDB c= new  ConnectionDB();
		logger.info(c.Info());
		Statement request;
		try {
			c.connection.setAutoCommit(false);
			request = c.connection.createStatement();
			//Opertaion Create
			System.out.println(commandLine.getOptions().length);
			if (commandLine.hasOption("name")) {
				name_test = commandLine.getOptionValue("name");
			}
			if (commandLine.hasOption("age")) {
				age_test = Integer.parseInt(commandLine.getOptionValue("age"));
			}
            System.out.println(c.CreatePersonne(name_test,age_test));
			/*int nb=request.executeUpdate("insert into personne (nom, age) values('In�s',22)");
			System.out.println(nb);
			*/
			//Opertaion Update
			/*int nb=0;
			nb=request.executeUpdate("update personne set age=40 where nom='In�s'");
			System.out.println(nb);*/
			//Opertaion Delete
		/*	int nb=request.executeUpdate("delete from personne where age<15");
			System.out.println(nb);*/
			//operation READ
			ResultSet result=c.ListPersonne();
			while(result.next())
			{
				String name_=result.getString(2);
				int age_=result.getInt(3);
				System.out.println("Name : "+name_+"  et age : "+age_);
			}
			 c.connection.commit();
			 result.close();
			 request.close();
			 c.connection.close();


		} catch (SQLException e1) {

			e1.printStackTrace();
		}




	}

}
