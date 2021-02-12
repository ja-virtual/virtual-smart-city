package edu.si.ing1.pds.vsc.server;

import org.apache.commons.cli.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

		public class SmartCityAppService {
			private final static Logger logger = LoggerFactory.getLogger(SmartCityAppService.class.getName());
			public static void main(String[] args) throws Exception {


				final CommandLineParser parser = new DefaultParser();
				final Options opts = new Options();
				final CommandLine commandLine = parser.parse(opts, args);

				final Option connectionLimit = Option.builder().longOpt("connectionLimit").hasArg().ArgName("connectionLimit").build();
				opts.addOption(connectionLimit);

				final Option workingTrial = Option.builder().longOpt("workingTrial").build();
				opts.addOption(workingTrial);

				int connectionLimit_i = 40;
				if (commandLine.hasOption("connectionLimit"))
					connectionLimit_i = Integer.parseInt(commandLine.getOptionValue("connectionLimit"));

				boolean workingTrial_i = false;
				if (commandLine.hasOption("workingTrial"))
					workingTrial_i = true;

				logger.info("VSC Application is running, the workingTrial = "+ workingTrial_i +" & connectionLimit = " +connectionLimit_i+".");

			}
		}

