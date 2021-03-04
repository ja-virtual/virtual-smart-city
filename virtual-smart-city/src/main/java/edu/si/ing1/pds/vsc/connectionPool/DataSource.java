package edu.si.ing1.pds.vsc.connectionPool;

import java.sql.Connection;

public class DataSource {

	static JDBCConnectionPool conPool=new JDBCConnectionPool ();
	public static Connection ReturnCon()
	{
		return conPool.ConnectionEntity();
	}
	public static void ReturnCon(Connection con)
	{
		conPool.Return(con);
	}
	public static void Cloture()
	{
		conPool.Close();
	}
}
