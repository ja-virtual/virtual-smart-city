package edu.si.ing1.pds.vsc.server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.Random;

import edu.si.ing1.pds.vsc.connectionPool.*;
import edu.si.ing1.pds.vsc.server.*;

public class SmartCityAppServer extends Thread {


    private final static Logger logger = LoggerFactory.getLogger(SmartCityAppServer.class.getName());

    public static DataSource ds=new DataSource(5,5);
    ServerSocket server;
    Socket client;
    public static ServerConfig serverConfig;
    public static  int max_connection_i = 0, connection_duration_i = 0;

    public SmartCityAppServer(final ServerConfig config) {
        try {
            server = new ServerSocket(config.getConfig().getListenPort());
        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
   public void run()
   {
	   this.serve();
	   while(ds.getUsedConnection()<max_connection_i )
	   {
		      BufferedReader in=null;
			try {
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				String operation_name=in.readLine();
				if(operation_name!=null)
					{
				CrudOperation(operation_name);
				PrintWriter out = new PrintWriter(client.getOutputStream(),true);
				out.println(CrudOperation(operation_name));
				System.out.println("connexion number "+(ds.getUsedConnection()+1));
				ds.setUsedConnection(ds.getUsedConnection()+1);
				//interval between each connexion
				sleep(connection_duration_i);

					}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	   }
   }
 public String CrudOperation(String operation_name) throws Exception
 {
	 ConnectionDB c = ds.takeCon();
System.out.println(operation_name + " operation :");
String result="";
	  switch (operation_name) {
      case "add":
          //Add operation
        result= c.createPerson();
        break;
      case "update":
          // Update operation
    	result= c.updatePerson();
    	break;
      case "delete":
          //Delete operation
    	  result= c.deletePerson();
    	  break;
      case "read":
          //Read operation
    	 result=c.listPerson();
    	 break;
      default:
result="operation non-existent!!";
break;
  }	
	  c.connection.close();
	  return result;
 }

    public void serve() {
        try {
           client= server.accept();
            logger.debug("a client has been detected !!");
        //    final ClientRequestManager clientRequestManager = new ClientRequestManager(client);
          
        } catch (Exception ex) {
            logger.info("no service available!!");
        }
    }

    public static void main(String[] args) throws Exception {
    	//connection pool configuration
    	
        serverConfig = new ServerConfig();
        Options options = new Options();
        Option max_connection = new Option("mc", "maxConnection", true, "the number of connections that we could possibly create to be used");
        Option connection_duration = new Option("cd", "connectionDuration", true, "the duration accorded to the user to connect to the database");

        Option id = new Option("i", "id", true, "id of the person");
        Option name = new Option("n", "name", true, "name of the person");
        Option age = new Option("a", "age", true, "age of the person");
        options.addOption(id);
        options.addOption(name);
        options.addOption(age);
        options.addOption(max_connection);

        options.addOption(connection_duration);
        max_connection.setRequired(true);
        connection_duration.setRequired(true);
   //     operation.setRequired(true);
        
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine commandLine;
        commandLine = parser.parse(options, args);
        
        
        if (commandLine.hasOption("maxConnection"))
            max_connection_i = Integer.parseInt(commandLine.getOptionValue("maxConnection"));


        
        if (commandLine.hasOption("connectionDuration"))
            connection_duration_i = Integer.parseInt(commandLine.getOptionValue("connectionDuration"));
        
        
        logger.info("VSC Application is running, maximal_connection= " + max_connection_i + " & connection_duration = " + connection_duration_i + ".");
        
        //connection pool created
        ds = new DataSource(max_connection_i, connection_duration_i);

        SmartCityAppServer service=new SmartCityAppServer(serverConfig);
        logger.info("server here");
       service.start();
   
    }
    
}
