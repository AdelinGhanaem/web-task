package com.cayetano.persistense.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by adelin.ghanayem@gmail.com
 */
@Entity
@Table(name="CLIENT_CONNECTIONS")
public class ClientConnectionEntity {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "connectionSource")
    private String connectionSource;

    @Column(name = "connectionTime")
    private long connectionTime;

    @Column(name = "clientBrowser")
    private String clientBrowser;

    public String getConnectionSource() {
        return connectionSource;
    }

    public long getConnectionTime() {
        return connectionTime;
    }

    public String getClientBrowser() {
        return clientBrowser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setConnectionSource(String connectionSource) {
        this.connectionSource = connectionSource;
    }

    public void setConnectionTime(long connectionTime) {
        this.connectionTime = connectionTime;
    }

    public void setClientBrowser(String clientBrowser) {
        this.clientBrowser = clientBrowser;
    }
}
