package com.cayetano.core;

import java.util.Date;

/**
 * Created by adelin.ghanayem@gmail.com
 */
public final class ClientConnection {

    private String connectionSource;
    private Date connectionTime;
    private String clientBrowser;

    public ClientConnection(String connectionSource, Date connectionTime, String clientBrowser) {
        this.connectionSource = connectionSource;
        this.connectionTime = connectionTime;
        this.clientBrowser = clientBrowser;
    }


    public String getConnectionSource() {
        return connectionSource;
    }

    public Date getConnectionTime() {
        return connectionTime;
    }

    public String getClientBrowser() {
        return clientBrowser;
    }
}
