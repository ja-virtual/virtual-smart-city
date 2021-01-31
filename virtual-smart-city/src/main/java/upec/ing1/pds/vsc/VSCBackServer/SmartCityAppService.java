package upec.ing1.pds.vsc.backendserver;

import org.apache.commons.cli.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

		public class SmartCityAppService {
			private final static Logger logger = LoggerFactory.getLogger(SmartCityAppService.class.getName());
			public static void main(String[] args) throws Exception {


				final Options opts = new Options();

				final Option connexionLimit = Option.builder().longOpt("connexionLimit").hasArg().build();
				opts.addOption(connexionLimit);

				final Option workingTrial = Option.builder().longOpt("workingTrial").build();
				opts.addOption(workingTrial);

				final CommandLineParser parser = new DefaultParser();
				final CommandLine commandLine = parser.parse(opts, args);

				int connectionLimit_i = 40;
				if (commandLine.hasOption("connexionLimit"))
					connectionLimit_i = Integer.parseInt(commandLine.getOptionValue("connexionLimit"));

				boolean workingTrial_i = false;
				if (commandLine.hasOption("workingTrial"))
					workingTrial_i = true;

				logger.info("VSC Application is running, the workingTrial = "+ workingTrial_i +" & connectionLimit = " +connectionLimit_i+".");

			}
		}

