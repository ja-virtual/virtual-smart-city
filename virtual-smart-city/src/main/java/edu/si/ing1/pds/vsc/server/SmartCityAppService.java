package edu.si.ing1.pds.vsc.server;

import org.apache.commons.cli.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.si.ing1.pds.vsc.connectionPool.DataSource;

		public class SmartCityAppService {
			public static DataSource ds=null;
			private final static Logger logger = LoggerFactory.getLogger(SmartCityAppService.class.getName());
			public static void main(String[] args) throws Exception {

				Options options = new Options();
				Option max_connection  = new Option("max_con", "maxConnection", true, "the number of connections that we could possibly create to be used");
				Option available_connection  = new Option("av_con", "availableConnection", true, "the number of connection that are available to be used at the moment");
				Option connection_duration  = new Option("con_dur", "connectionDuration", true, "the duration accorded to the user to connect to the database");
				options.addOption(max_connection);
				options.addOption(available_connection);
				options.addOption(connection_duration);
				CommandLineParser parser = new DefaultParser();
				HelpFormatter formatter = new HelpFormatter();
				CommandLine commandLine;
				commandLine = parser.parse(options, args);
				int max_connection_i =0;
				if (commandLine.hasOption("maxConnection"))
					max_connection_i = Integer.parseInt(commandLine.getOptionValue("maxConnection"));

			    int available_connection_i = 0;
				if (commandLine.hasOption("availableConnection"))
					available_connection_i = Integer.parseInt(commandLine.getOptionValue("availableConnection"));
 
				int connection_duration_i =0;
				if (commandLine.hasOption("connectionDuration"))
					connection_duration_i = Integer.parseInt(commandLine.getOptionValue("connectionDuration"));
				logger.info("VSC Application is running, maximal_connection= "+max_connection_i +" & available_connection = " +available_connection_i+" & connection_duration = " +connection_duration_i+".");
				ds = new DataSource(max_connection_i, available_connection_i, connection_duration_i);
				ds.start();
				//ds.setMaxConnection(max_connection_i);
			//	ds.setAvailableConnection(available_connection_i);
			}
		}

