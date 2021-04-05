package edu.ing1.pds.vsc.client;

import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;


import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;


public class ClientConfig {
    private final static Logger logger = LoggerFactory.getLogger(ClientConfig.class.getName());
    private static final String episenClientConfigEnVar = "SMART_CITY";
    private final String episenClientConfigFileLocation;
    private ClientCoreConfig config;


    public ClientCoreConfig getConfig() {
        return config;
    }


    public ClientConfig() throws IOException {
        this.episenClientConfigFileLocation = System.getenv(episenClientConfigEnVar);
        logger.debug("Config file = {} ", episenClientConfigFileLocation);
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        config = mapper.readValue(new File(episenClientConfigFileLocation), ClientCoreConfig.class);
        logger.debug("Config = {}", config.toString());

    }
}