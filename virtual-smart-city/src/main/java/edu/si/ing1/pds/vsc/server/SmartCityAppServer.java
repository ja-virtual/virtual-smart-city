package edu.si.ing1.pds.vsc.server;


import java.io.IOException;
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

import edu.si.ing1.pds.vsc.connectionPool.DataSource;


public class SmartCityAppServer {


    private final static Logger logger = LoggerFactory.getLogger(SmartCityAppServer.class.getName());

    public static DataSource ds=null;
    ServerSocket server;
    public static ServerConfig serverConfig;

    public SmartCityAppServer(final ServerConfig config) {
        try {
            server = new ServerSocket(config.getConfig().getListenPort());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void serve() {
        try {
            Socket client = server.accept();
            logger.debug("a client has been detected !!");
            final ClientRequestManager clientRequestManager = new ClientRequestManager(client);
        } catch (Exception ex) {
            logger.info("no service available!!");
        }
    }

    public static void main(String[] args) throws Exception {
        serverConfig = new ServerConfig();
        Options options = new Options();
        Option max_connection = new Option("mc", "maxConnection", true, "the number of connections that we could possibly create to be used");
        Option available_connection = new Option("ac", "availableConnection", true, "the number of connection that are available to be used at the moment");
        Option connection_duration = new Option("cd", "connectionDuration", true, "the duration accorded to the user to connect to the database");
        options.addOption(max_connection);
        options.addOption(available_connection);
        options.addOption(connection_duration);
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine commandLine;
        commandLine = parser.parse(options, args);
        int max_connection_i = 0;
        if (commandLine.hasOption("maxConnection"))
            max_connection_i = Integer.parseInt(commandLine.getOptionValue("maxConnection"));

        int available_connection_i = 0;
        if (commandLine.hasOption("availableConnection"))
            available_connection_i = Integer.parseInt(commandLine.getOptionValue("availableConnection"));
        int connection_duration_i = 0;
        if (commandLine.hasOption("connectionDuration"))
            connection_duration_i = Integer.parseInt(commandLine.getOptionValue("connectionDuration"));
        logger.info("VSC Application is running, maximal_connection= " + max_connection_i + " & available_connection = " + available_connection_i + " & connection_duration = " + connection_duration_i + ".");
        	ds = new DataSource(max_connection_i, available_connection_i, connection_duration_i);
        new SmartCityAppServer(serverConfig).serve();
        logger.info("server here");
    }
}
