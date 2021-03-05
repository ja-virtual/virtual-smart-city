package edu.si.ing1.pds.vsc.connectionPool;

import java.sql.Connection;

public class DataSource {

	static JDBCConnectionPool conPool=new JDBCConnectionPool ();
	public static Connection takeCon()
	{
		return conPool.connectionEntity();
	}
	public static void returnCon(Connection con)
	{
		conPool.returnCon(con);
	}
	public static void closure()
	{
		conPool.Close();
	}
}
