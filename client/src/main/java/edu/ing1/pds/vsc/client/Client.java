package edu.ing1.pds.vsc.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;

import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client
{
	
    private final static Logger logger = LoggerFactory.getLogger(Client.class.getName());
	public static void main(String[] args) throws Exception {
       
  // ConnectionServer con=new ConnectionServer();
		try
		{
			 Options options = new Options();
		    CommandLineParser parser = new DefaultParser();
	        HelpFormatter formatter = new HelpFormatter();
	        CommandLine commandLine;
	        commandLine = parser.parse(options, args);
	        Option operation_name = new Option("op", "operationName", true, "the name of the operation that the client wants to do");
	       
	        options.addOption(operation_name);
            String operation_name_i="";
	        operation_name.setRequired(true);
	        if (commandLine.hasOption("connectionDuration"))
	            operation_name_i = commandLine.getOptionValue("connectionDuration");
	        
	        String msg="";
	        switch(operation_name_i)
	        {
	        	case "add" :
	        		//msg=con.create_person(0);
	        		break;
	        	case "update" :
	        		//msg=con.update_person(0);
	        		break;
	        	case "delete" :
	        		//msg=con.delete_person(0);
	        		break;
	        	case "read" :
	        	//	msg=con.read_person(0);
	        		break;
	        	case "readAll" :
	        	//	msg=con.all_person();
	        		break;
	        	default :
	        		System.exit(0);
	        		break;
	        }
	        logger.info(msg);
		}
		catch (Exception e)
		{
			logger.info("erro from the side of the client");
		}

	}
	private static void Switch(String operation_name_i) {
		// TODO Auto-generated method stub
		
	}

}