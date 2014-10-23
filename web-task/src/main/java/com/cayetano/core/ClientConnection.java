package com.cayetano.core;

import java.util.Date;

/**
 * This class represents a client connection to the web server
 * Created by adelin.ghanayem@gmail.com
 */
public final class ClientConnection {

    private String connectionSource;
    private Date connectionTime;
    private String clientAgent;

    public ClientConnection(String connectionSource, Date connectionTime, String clientAgent) {
        this.connectionSource = connectionSource;
        this.connectionTime = connectionTime;
        this.clientAgent = clientAgent;
    }


    public String getConnectionSource() {
        return connectionSource;
    }

    public Date getConnectionTime() {
        return connectionTime;
    }

    public String getClientAgent() {
        return clientAgent;
    }

    @Override
    public String toString() {
        return "ClientConnection{" +
                "connectionSource='" + connectionSource + '\'' +
                ", connectionTime=" + connectionTime +
                ", clientAgent='" + clientAgent + '\'' +
                '}';
    }
}
