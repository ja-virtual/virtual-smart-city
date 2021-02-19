package edu.si.ing1.pds.vsc.connectionPool;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
class JDBCConnectionPool
{
   private ArrayList<Connection>Collection=new ArrayList<Connection>();
   public JDBCConnectionPool () {}
    public synchronized void Alimenter(Collection<Connection> con)
    {
    	Collection.addAll(con);
    }
    
    public synchronized Connection ConnectionEntity()
    {
    	Random indice=new Random();
    	Connection con=Collection.get(indice.nextInt(Collection.size()));
    	Collection.remove(con);
    	return con;
    }
    public synchronized void Rendre(Connection con)
    {
    	Collection.add(con);
    }
    public synchronized void Fermer()
    {
    	for(Connection c: Collection)
    	{try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}}
    }
}