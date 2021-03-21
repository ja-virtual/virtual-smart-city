package edu.si.ing1.pds.vsc.connectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.apache.commons.cli.*;

import edu.si.ing1.pds.vsc.server.SmartCityAppServer;

public class ConnectionMain {

    static Logger logger = Logger.getLogger("test");

    public static void main(String[] args) throws Exception {

        //options creation
  /*     DataSource ds= SmartCityAppServer.ds;
       // DataSource ds= new DataSource(10,3,5);
        Options options = new Options();
        //Add an option that contains a short-name (o) and a long-name (operation).
        Option operation = new Option("o", "operation", true, "operation done in the database");
        operation.setRequired(true);
        options.addOption(operation);
        Option id = new Option("i", "id", true, "id of the person");
        Option name = new Option("n", "name", true, "name of the person");
        Option age = new Option("a", "age", true, "age of the person");
        options.addOption(id);
        options.addOption(name);
        options.addOption(age);
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine commandLine;
        commandLine = parser.parse(options, args);
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
                        if (commandLine.hasOption("name") && commandLine.hasOption("age")) {
                            name_test = commandLine.getOptionValue("name");
                            age_test = Integer.parseInt(commandLine.getOptionValue("age"));
                            System.out.println(c.createPerson(name_test, age_test));
                        } else
                            System.out.println("the add operation is missing some settings");
                        break;
                    case "update":
                        // Update operation
                        if (commandLine.hasOption("id") ) {
                            if (commandLine.hasOption("name") && commandLine.hasOption("age")) {
                                id_test = Integer.parseInt(commandLine.getOptionValue("id"));
                                name_test = commandLine.getOptionValue("name");
                                age_test = Integer.parseInt(commandLine.getOptionValue("age"));
                                System.out.println(c.updatePerson(id_test, name_test, age_test));
                            }
                            else  if (commandLine.hasOption("name"))
                            {
                                id_test = Integer.parseInt(commandLine.getOptionValue("id"));
                                name_test = commandLine.getOptionValue("name");
                                System.out.println(c.updatePerson(id_test, name_test));
                            }
                            else  if (commandLine.hasOption("age"))
                            {
                                id_test = Integer.parseInt(commandLine.getOptionValue("id"));
                                age_test = Integer.parseInt(commandLine.getOptionValue("age"));
                                System.out.println(c.updatePerson(id_test, age_test));
                            }

                        }
                                else
                            System.out.println("the update operation is missing some settings");
                        break;
                    case "delete":
                        //Delete operation
                        if (commandLine.hasOption("id")) {
                            id_test = Integer.parseInt(commandLine.getOptionValue("id"));
                            System.out.println(c.deletePerson(id_test));
                        } else
                            System.out.println("the delete operation is missing some settings");
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

*/
    }

}
