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
import java.sql.*;

import edu.si.ing1.pds.vsc.connectionPool.*;
import edu.si.ing1.pds.vsc.server.*;

public class SmartCityAppServer {


    private final static Logger logger = LoggerFactory.getLogger(SmartCityAppServer.class.getName());

    public static DataSource ds=new DataSource(10,5,5);
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
        Option operation = new Option("o", "operation", true, "operation done in the database");
        options.addOption(operation);
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
        operation.setRequired(true);
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
        String name_test = "";
        String operation_name = "";
        int age_test = 0;
        int id_test = 0;
        ConnectionDB c = ds.takeCon();
        if(c==null)
            logger.info("null ici");
        Statement request=null;
        try {
            //     request = c.connection.createStatement();
            //Opertaion Create
            if (commandLine.hasOption("operation")) {
                operation_name = commandLine.getOptionValue("operation");
                switch (operation_name) {
                    case "add":
                       /* if (commandLine.hasOption("name") && commandLine.hasOption("age")) {
                            name_test = commandLine.getOptionValue("name");
                            age_test = Integer.parseInt(commandLine.getOptionValue("age"));
                           // System.out.println(c.createPerson(name_test, age_test));
                            System.out.println(c.createPerson());
                        } else
                            System.out.println("the add operation is missing some settings");*/
                        System.out.println(c.createPerson());
                        break;
                    case "update":
                        // Update operation
                     /*   if (commandLine.hasOption("id") ) {
                            if (commandLine.hasOption("name") && commandLine.hasOption("age")) {
                                id_test = Integer.parseInt(commandLine.getOptionValue("id"));
                                name_test = commandLine.getOptionValue("name");
                                age_test = Integer.parseInt(commandLine.getOptionValue("age"));
                           //     System.out.println(c.updatePerson(id_test, name_test, age_test));

                            }
                            else  if (commandLine.hasOption("name"))
                            {
                                id_test = Integer.parseInt(commandLine.getOptionValue("id"));
                                name_test = commandLine.getOptionValue("name");
                             //   System.out.println(c.updatePerson(id_test, name_test));
                            }
                            else  if (commandLine.hasOption("age"))
                            {
                                id_test = Integer.parseInt(commandLine.getOptionValue("id"));
                                age_test = Integer.parseInt(commandLine.getOptionValue("age"));
                            //    System.out.println(c.updatePerson(id_test, age_test));
                            }

                        }
                        else
                            System.out.println("the update operation is missing some settings");*/
                        System.out.println(c.updatePerson());
                        break;
                    case "delete":
                        //Delete operation
                       /* if (commandLine.hasOption("id")) {
                            id_test = Integer.parseInt(commandLine.getOptionValue("id"));
                        //    System.out.println(c.deletePerson(id_test));
                            System.out.println(c.deletePerson());
                        } else
                            System.out.println("the delete operation is missing some settings");*/
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
            }


        } catch (SQLException e1) {

            e1.printStackTrace();
        } finally {
            //request.close();
            c.connection.close();
        }
        new SmartCityAppServer(serverConfig).serve();
        logger.info("server here");

    }
}
