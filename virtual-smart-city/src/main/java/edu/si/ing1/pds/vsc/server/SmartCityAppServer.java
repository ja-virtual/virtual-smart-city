package edu.si.ing1.pds.vsc.server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
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

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.si.ing1.pds.vsc.connectionPool.DataSource;
import edu.si.ing1.pds.vsc.connectionPool.Request;
import edu.si.ing1.pds.vsc.connectionPool.ServerToClient;

import java.sql.*;
import java.util.Random;


public class SmartCityAppServer extends Thread {


	private final static Logger logger = LoggerFactory.getLogger(SmartCityAppServer.class.getName());

	public static DataSource ds=new DataSource(5,5);
	ServerSocket server;
	Socket client;
	public static ServerConfig serverConfig;
	public static  int max_connection_i = 0, connection_duration_i = 0;

	public SmartCityAppServer() {
		try {
			server = new ServerSocket(3344);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void run()
	{
		PrintWriter out=null;
		BufferedReader in=null;
		this.serve();
		while(ds.getUsedConnection()<max_connection_i )
		{

			try {
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				String operation=in.readLine();
				ObjectMapper mapper=new ObjectMapper();
				logger.info(operation);
				Request request=mapper.readValue(operation,Request.class);
				logger.info(request.getName_request());
				ServerToClient connection=new ServerToClient(ds);
				String response=connection.SendResponse(request);
				out=new PrintWriter(client.getOutputStream(),true);
				out.println(response);
				System.out.print("*********************\n ");
			} catch (Exception e1) {

				 this.serve();
			}
		}

		try {
			in.close();
			out.close();
			server.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void serve() {
		try {
			client= server.accept();
			logger.debug("a client has been detected !!");
			//    final ClientRequestManager clientRequestManager = new ClientRequestManager(client);

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.info("no service available!!");
		}
	}

	public static void main(String[] args) throws Exception {
		//connection pool configuration

		//   serverConfig = new ServerConfig();
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

		SmartCityAppServer service=new SmartCityAppServer();
		logger.info("server here");
		service.start();

	}

}