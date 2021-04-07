package edu.ing1.pds.vsc.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientCoreConfig {

    private int listenPort;
    private int soTimeout;

    public String getIp() {
        return ip;
    }

    private String ip;
    public ClientCoreConfig() {

    }

    public int getListenPort() {
        return listenPort;
    }

    public void setListenPort(int listenPort) {
        this.listenPort = listenPort;
    }

    public int getSoTimeout() {
        return soTimeout;
    }

    public void setSoTimeout(int soTimeout) {
        this.soTimeout = soTimeout;
    }

    @Override
    public String toString() {
        return "ServerCoreConfig [listenPort=" + listenPort + ", soTimeout=" + soTimeout + "]";
    }


}
