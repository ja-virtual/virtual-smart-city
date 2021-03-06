package edu.si.ing1.pds.vsc.connectionPool;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
class JDBCConnectionPool
{
   private ArrayList<Connection>Collection=new ArrayList<Connection>();
   public JDBCConnectionPool () {}
    public synchronized void feed(Collection<Connection> con)
    {
    	Collection.addAll(con);
    }

    public synchronized Connection connectionEntity()
    {
    	Random indice=new Random();
    	Connection con=Collection.get(indice.nextInt(Collection.size()));
    	Collection.remove(con);
    	return con;
    }
    public synchronized void returnCon(Connection con)
    {
    	Collection.add(con);
    }
    public synchronized void Close()
    {
    	for(Connection c: Collection)
    	{try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}}
    }
}