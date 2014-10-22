package com.cayetano.persistense.entities;

import java.util.Date;

/**
 * Created by adelin.ghanayem@gmail.com
 */
public class ClientConnectionEntity {


    private String connectionSource;
    private Date connectionTime;
    private String clientBrowser;


    public ClientConnectionEntity(String connectionSource, Date connectionTime, String clientBrowser) {
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
