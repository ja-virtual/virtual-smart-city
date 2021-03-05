package edu.si.ing1.pds.vsc.server;

import org.apache.commons.cli.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

		public class SmartCityAppService {
			private final static Logger logger = LoggerFactory.getLogger(SmartCityAppService.class.getName());
			public static void main(String[] args) throws Exception {

				Options options = new Options();
				Option connectionLimit  = new Option("connectionLimit", "connectionLimit", true, "connectionLimit variable");
				Option workingTrial  = new Option("workingTrial", "workingTrial", true, "workingTrial variable");
				options.addOption(connectionLimit);
				options.addOption(workingTrial);
				CommandLineParser parser = new DefaultParser();
				HelpFormatter formatter = new HelpFormatter();
				CommandLine commandLine;
				commandLine = parser.parse(options, args);
				int connectionLimit_i = 40;
				if (commandLine.hasOption("connectionLimit"))
					connectionLimit_i = Integer.parseInt(commandLine.getOptionValue("connectionLimit"));

				boolean workingTrial_i = false;
				if (commandLine.hasOption("workingTrial"))
					workingTrial_i = true;

				logger.info("VSC Application is running, the workingTrial = "+ workingTrial_i +" & connectionLimit = " +connectionLimit_i+".");

			}
		}

