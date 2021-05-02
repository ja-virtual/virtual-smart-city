package edu.ing1.pds.vsc.client.analyzeIndicatorsManagement;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {


	public static void main(String[] args) {
	
		ConnectDB obj_ConnectDB = new ConnectDB();
		System.out.println( obj_ConnectDB.get_connection() );
	}
	public Connection get_connection() {
	  Connection connection = null;
    String host="localhost";
    String port="5435";
    String db_name="postgres";
    String username="postgres";
    String password="root";
    try {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://"+host+":"+port+"/"+db_name;
        connection = DriverManager.getConnection(url, username, password);
        if (connection != null) {
            System.out.println("Connection OK");
        } else {
            System.out.println("Connection Failed");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return connection;
}
}