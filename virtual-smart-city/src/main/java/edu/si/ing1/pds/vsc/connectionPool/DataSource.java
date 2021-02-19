package edu.si.ing1.pds.vsc.connectionPool;

import java.sql.Connection;

public class DataSource {

	static JDBCConnectionPool conPool=new JDBCConnectionPool ();
	public static Connection RendreCon()
	{
		return conPool.ConnectionEntity();
	}
	public static void RendreCon(Connection con)
	{
		conPool.Rendre(con);
	}
	public static void Cloture()
	{
		conPool.Fermer();
	}
}
