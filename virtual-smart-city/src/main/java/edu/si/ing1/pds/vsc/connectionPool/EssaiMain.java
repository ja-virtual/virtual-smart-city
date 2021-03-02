package edu.si.ing1.pds.vsc.connectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

public class EssaiMain {
static Logger logger=Logger.getLogger("test");
	public static void main(String[] args) {
	//	ArrayList<Connection>con=new ArrayList<Connection>();
		ConnectionDB c= new  ConnectionDB();
		logger.info(c.Info());
	 /*  con.add(new ConnectionDB().connection);
	    con.add(new ConnectionDB().connection);*/
		Statement requet;
		
		try {
			c.connection.setAutoCommit(false);
			requet = c.connection.createStatement();
			//Opertaion Create
			/*int nb=requet.executeUpdate("insert into personne (nom, age) values('Inès',22)");
			System.out.println(nb);
			*/
			//Opertaion Update
			/*int nb=0;
			nb=requet.executeUpdate("update personne set age=40 where nom='Inès'");
			System.out.println(nb);*/
			//Opertaion Delete
		/*	int nb=requet.executeUpdate("delete from personne where age<15");
			System.out.println(nb);*/
			//operation de lecture READ
			ResultSet result=requet.executeQuery("select * from personne");
			while(result.next())
			{
				String nom=result.getString(2);
				int age=result.getInt(3);
				System.out.println("Nom : "+nom+"  et age : "+age);
			}
			 c.connection.commit();
			 result.close();
			 requet.close();
			 c.connection.close();
			

		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}

		


	}

}
