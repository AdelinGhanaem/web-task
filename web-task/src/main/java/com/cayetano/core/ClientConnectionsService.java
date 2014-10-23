package com.cayetano.core;

import java.util.Date;
import java.util.List;

/**
 * Created by adelin.ghanayem@gmail.com
 */
public interface ClientConnectionsService {

    /**
     *
     * @return
     */
    List<ClientConnection> getAllConnections();

    /**
     *
     * @param clientConnection
     */
    void saveClientConnection(ClientConnection clientConnection);

    List<ClientConnection> getConnectionBetween(Date start, Date end);
}
