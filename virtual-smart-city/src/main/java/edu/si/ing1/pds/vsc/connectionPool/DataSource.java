package edu.si.ing1.pds.vsc.connectionPool;

import java.sql.Connection;
import java.util.ArrayList;
import edu.si.ing1.pds.vsc.connectionPool.*;
public class DataSource extends Thread {

    //attributs
	static JDBCConnectionPool conPool=new JDBCConnectionPool ();
    private int connection_interval;

	public int getMaxConnection()
	{
		return conPool.getMax_connection();
	}
	public int getAvailableConnection()
	{
		return conPool.getAvailable_connection();
	}
	public int getUsedConnection()
	{
		return conPool.getUsed_connection();
	}
	public void setMaxConnection(int max_con)
	{
		conPool.setMax_connection(max_con);
	}
	public void setAvailableConnection(int available_con)
	{
		conPool.setAvailable_connection(available_con);
	}
	public void settUsedConnection(int used_con)
	{
		 conPool.setUsed_connection(used_con);
	}
	
	//constructor
	public DataSource(int max_con, int av_con, int con_interv) {
		setAvailableConnection(av_con);
		setMaxConnection(max_con);
		connection_interval=con_interv;
		ArrayList<ConnectionDB> cons=new ArrayList<ConnectionDB>();
		for(int i=0;i<av_con;i++)
		{
			ConnectionDB c=new ConnectionDB();
			cons.add(c);
		}
		conPool.feed(cons);

	}
	
	// run method
   public void run()
   {
	ConnectionDB condb=new ConnectionDB();
	conPool.returnCon(condb);
	try {
		sleep(connection_interval);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
	
	//methods
	public static ConnectionDB takeCon()
	{
		return conPool.connectionEntity();
	}
	public static void returnCon(ConnectionDB con)
	{
		conPool.returnCon(con);
	}
	public static void closure()
	{
		conPool.Close();
	}

}
