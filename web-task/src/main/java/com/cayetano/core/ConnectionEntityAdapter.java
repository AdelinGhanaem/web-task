package com.cayetano.core;

import com.cayetano.persistense.entities.ClientConnectionEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adelin.ghanayem@gmail.com
 */
@Component
public class ConnectionEntityAdapter implements Adapter<ClientConnection, ClientConnectionEntity> {


    @Override
    public List<ClientConnection> to(List<ClientConnectionEntity> entities) {
        List<ClientConnection> connections = new ArrayList<>();

        for (ClientConnectionEntity entity : entities) {
            ClientConnection clientConnection = new ClientConnection(
                    entity.getConnectionSource(),
                    entity.getConnectionTime(),
                    entity.getClientBrowser());
            connections.add(clientConnection);
        }
        return connections;
    }
}
