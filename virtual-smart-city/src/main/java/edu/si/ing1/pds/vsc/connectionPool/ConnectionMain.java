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
		Option nom = new Option("nom", "nom", true, "le nom de la personne");
		Option age = new Option("age", "age", true, "l'age de la personne");
		nom.setRequired(true);
		age.setRequired(true);
		options.addOption(nom);
		options.addOption(age);
		CommandLineParser parser = new DefaultParser();
		HelpFormatter formatter = new HelpFormatter();
		CommandLine commandLine;
		commandLine = parser.parse(options, args);
		String nom_test="";
		int age_test=0;
		ConnectionDB c= new  ConnectionDB();
		logger.info(c.Info());
		Statement request;
		try {
			c.connection.setAutoCommit(false);
			request = c.connection.createStatement();
			//Opertaion Create
			System.out.println(commandLine.getOptions().length);
			if (commandLine.hasOption("nom")) {
				nom_test = commandLine.getOptionValue("nom");
			}
			if (commandLine.hasOption("age")) {
				age_test = Integer.parseInt(commandLine.getOptionValue("age"));
			}
            System.out.println(c.CreatePersonne(nom_test,age_test));
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
			ResultSet result=request.executeQuery("select * from personne");
			while(result.next())
			{
				String nom_=result.getString(2);
				int age_=result.getInt(3);
				System.out.println("Name : "+nom_+"  et age : "+age_);
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
