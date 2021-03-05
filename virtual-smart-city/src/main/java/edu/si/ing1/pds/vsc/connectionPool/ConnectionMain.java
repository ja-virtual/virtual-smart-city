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


		final CommandLineParser parser = new DefaultParser();
		final Options opts = new Options();
		final CommandLine commandLine = parser.parse(opts, args);

		ConnectionDB c= new  ConnectionDB();
		logger.info(c.Info());

		Statement request;

		try {
			c.connection.setAutoCommit(false);
			request = c.connection.createStatement();
			//Opertaion Create
			final Option age= Option.builder().longOpt("age").build();
			opts.addOption(age);
			int age_test=Integer.parseInt(args[1]);
			System.out.println(args[0]);
			if (commandLine.hasOption("age=103")) {
				age_test = 15;
				//age_test = Integer.parseInt(commandLine.getOptionValue("age"));

				System.out.println("ok");
			}
			String nom_test = args[0];
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
				String nom=result.getString(2);
				int age_=result.getInt(3);
				System.out.println("Name : "+nom+"  et age : "+age_);
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
