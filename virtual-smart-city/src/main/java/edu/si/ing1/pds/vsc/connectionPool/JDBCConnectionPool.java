package edu.si.ing1.pds.vsc.connectionPool;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
public class JDBCConnectionPool
{
    //les attributs
   private ArrayList<ConnectionDB> collection=new ArrayList<ConnectionDB>();

    private static int max_connection;
    private static int available_connection;
    private static int used_connection=0;

    //les accesseurs
    public static int getMax_connection() {
        return max_connection;
    }

    public static void setMax_connection(int max_con) {
        max_connection = max_con;
    }

    public static int getAvailable_connection() {
        return available_connection;
    }

    public static void setAvailable_connection(int av_connection) {
         available_connection = av_connection;
    }

    public static int getUsed_connection() {
        return used_connection;
    }

    public static void setUsed_connection(int used_connection) {
        used_connection = used_connection;
    }

    //le constructeur
   public JDBCConnectionPool () {}
   
   //les methodes
    public synchronized void feed(Collection<ConnectionDB> con)
    {
        //the estimated size of the collection after the addition of the new connections
        int size = used_connection+available_connection+con.size();

        if(size <= max_connection)
    	    collection.addAll(con);
        else
            System.out.println("Maximal number of connection reached!!!");

    }

    public synchronized ConnectionDB connectionEntity()
    {

        if(available_connection>0) {
            Random indice = new Random();
            ConnectionDB con = collection.get(indice.nextInt(collection.size()));
            collection.remove(con);
            return con;
        }
        else
            return  null;
    }
    public synchronized void returnCon(ConnectionDB con)
    {
    	collection.add(con);
    }
    public synchronized void Close()
    {
    	for(ConnectionDB c: collection)
    	{try {
			c.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}}
    }
}