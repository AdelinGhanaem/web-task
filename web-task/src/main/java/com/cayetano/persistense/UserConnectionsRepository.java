package com.cayetano.persistense;

import com.cayetano.core.ClientConnection;
import com.cayetano.persistense.entities.ClientConnectionEntity;

import java.util.List;

/**
 * Created by adelin.ghanayem@gmail.com
 */
public interface UserConnectionsRepository {





    void saveConnection(ClientConnectionEntity entity);


    List<ClientConnectionEntity> getConnectionsPage(int pageNumber);
}
