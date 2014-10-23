package com.cayetano.persistense;

import com.cayetano.core.ClientConnection;
import com.cayetano.persistense.entities.ClientConnectionEntity;

import java.util.Date;
import java.util.List;

/**
 * Clients Connections repository
 * Created by adelin.ghanayem@gmail.com
 */
public interface ClientConnectionsRepository {


    /**
     * Save a client connection entity
     * @param entity
     */
    void saveConnection(ClientConnectionEntity entity);

    /**
     * Returns all connection in repository
     * @return
     */
    List<ClientConnectionEntity> getConnections();

    /**
     * Returns all connection s between two dates.
     * @param start  start date in milliseconds
     * @param end end date in milliseconds
     * @return
     */
    List<ClientConnectionEntity> getConnectionBetween(long start, long end);
}
