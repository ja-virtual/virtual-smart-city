package edu.si.ing1.pds.vsc.connectionPool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Logger;

public class EssaiMain {
static Logger logger=Logger.getLogger("test");
	public static void main(String[] args) {
	//	ArrayList<Connection>con=new ArrayList<Connection>();
		ConnectionDB c= new  ConnectionDB();
		logger.info(c.Info());
	 /*   con.add(new ConnectionDB().connection);
	    con.add(new ConnectionDB().connection);*/


	}

}
