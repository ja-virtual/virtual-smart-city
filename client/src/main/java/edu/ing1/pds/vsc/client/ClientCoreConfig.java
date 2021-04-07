package edu.ing1.pds.vsc.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientCoreConfig {

    private int listenPort;
    private int soTimeout;


    private String ip;
    public ClientCoreConfig() {

    }
    public String getIp() {
        return ip;
    }

    public int getListenPort() {
        return listenPort;
    }

    public int getSoTimeout() {
        return soTimeout;
    }


    @Override
    public String toString() {
        return "clientCoreConfig [listenPort=" + listenPort + ", soTimeout=" + soTimeout + "]";
    }


}
