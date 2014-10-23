package com.cayetano.core;

import java.util.Date;
import java.util.List;

/**
 * Created by adelin.ghanayem@gmail.com
 */
public interface ClientConnectionsService {

    /**
     * Returns all {@link com.cayetano.core.ClientConnection}
     *
     * @return A List containing all {@link com.cayetano.core.ClientConnection}s until this moment.
     */
    List<ClientConnection> getAllConnections();

    /**
     * Save a {@link com.cayetano.core.ClientConnection}
     *
     * @param clientConnection
     */
    void saveClientConnection(ClientConnection clientConnection);

    /**
     * Returnes a {@link com.cayetano.core.ClientConnection}
     * @param start start date
     * @param end    end date
     * @return A List containing all {@link com.cayetano.core.ClientConnection} between the provided dates
     */
    List<ClientConnection> getConnectionBetween(Date start, Date end);
}
