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

    public static DataSource ds=new DataSource(10,5,5);
    ServerSocket server;
    Socket client;
    public static ServerConfig serverConfig;
    public static  int max_connection_i = 0, connection_duration_i = 0, available_connection_i = 0;

    public SmartCityAppServer(final ServerConfig config) {
        try {
            server = new ServerSocket(config.getConfig().getListenPort());
            client_test=new Socket("172.31.240.7",config.getConfig().getListenPort());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    Socket client_test;
    String[] operation=new String[] {"add","update","delete","read"};
    int used_connection=0;
    public void run()
    {
    	Random operation_index=new Random();
    	PrintWriter out=null;
		
    	while(used_connection<available_connection_i)
    	{
    		try
    		{
    			
    			try {
    				out = new PrintWriter(client_test.getOutputStream(),true);
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    	    	out.println(operation[operation_index.nextInt(4)]);
    	    	used_connection++;
    	    	System.out.print("client "+(used_connection+1)+"'s ");
    	    	CrudOperation();
    	    	System.out.println("*******************************************");
    			sleep(connection_duration_i*1000);
    		}
    		catch( Exception ex)
    		{
    			ex.printStackTrace();
    		}

    	}
    	logger.info("maximal number of connection is reached!! "+used_connection);
    	try {
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 public void CrudOperation() throws Exception
 {
	  ConnectionDB c = ds.takeCon();
      BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
      String operation_name=in.readLine();
System.out.println(operation_name + " operation :");
	  switch (operation_name) {
      case "add":
          //Add operation
          System.out.println(c.createPerson());
          break;
      case "update":
          // Update operation
          System.out.println(c.updatePerson());
          break;
      case "delete":
          //Delete operation
          System.out.println(c.deletePerson());
          break;
      case "read":
          //Read operation
          ResultSet result = c.listPerson();
          while (result.next()) {
              String name_ = result.getString(2);
              int age_ = result.getInt(3);
              int id_ = result.getInt(1);
              System.out.println("ID : "+id_+"  and name : " + name_ + "  and age : " + age_);
          }
          result.close();
          break;
      default:
          System.out.println("operation non-existent!!");
          break;
  }	
	  c.connection.close();
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
        Option available_connection = new Option("ac", "availableConnection", true, "the number of connection that are available to be used at the moment");
        Option connection_duration = new Option("cd", "connectionDuration", true, "the duration accorded to the user to connect to the database");
     //   Option operation = new Option("o", "operation", true, "operation done in the database");
    //    options.addOption(operation);
        Option id = new Option("i", "id", true, "id of the person");
        Option name = new Option("n", "name", true, "name of the person");
        Option age = new Option("a", "age", true, "age of the person");
        options.addOption(id);
        options.addOption(name);
        options.addOption(age);
        options.addOption(max_connection);
        options.addOption(available_connection);
        options.addOption(connection_duration);
        max_connection.setRequired(true);
        available_connection.setRequired(true);
        connection_duration.setRequired(true);
   //     operation.setRequired(true);
        
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine commandLine;
        commandLine = parser.parse(options, args);
        
        
        if (commandLine.hasOption("maxConnection"))
            max_connection_i = Integer.parseInt(commandLine.getOptionValue("maxConnection"));


        if (commandLine.hasOption("availableConnection"))
            available_connection_i = Integer.parseInt(commandLine.getOptionValue("availableConnection"));

        
        if (commandLine.hasOption("connectionDuration"))
            connection_duration_i = Integer.parseInt(commandLine.getOptionValue("connectionDuration"));
        
        
        logger.info("VSC Application is running, maximal_connection= " + max_connection_i + " & available_connection = " + available_connection_i + " & connection_duration = " + connection_duration_i + ".");
        
        //connection pool created
        ds = new DataSource(max_connection_i, available_connection_i, connection_duration_i);

        SmartCityAppServer service=new SmartCityAppServer(serverConfig);
        logger.info("server here");
        service.start();
       service.serve();
   
      

    }
    
}
