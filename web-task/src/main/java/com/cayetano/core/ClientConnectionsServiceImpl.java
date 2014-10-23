package com.cayetano.core;

import com.cayetano.persistense.UserConnectionsRepository;
import com.cayetano.persistense.entities.ClientConnectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by adelin.ghanayem@gmail.com
 */
@Component
class ClientConnectionsServiceImpl implements ClientConnectionsService {

    private UserConnectionsRepository repository;
    private Adapter<ClientConnection, ClientConnectionEntity> adapter;


    @Autowired
    public ClientConnectionsServiceImpl(UserConnectionsRepository repository, Adapter<ClientConnection, ClientConnectionEntity> adapter) {
        this.repository = repository;
        this.adapter = adapter;
    }

    @Override
    public List<ClientConnection> getAllConnections() {
        return adapter.to(repository.getConnections());
    }

    @Override
    public void saveClientConnection(ClientConnection clientConnection) {
        repository.saveConnection(adapter.from(clientConnection));
    }

    @Override
    public List<ClientConnection> getConnectionBetween(Date start, Date end) {
        return adapter.to(repository.getConnectionBetween(start,end));
    }

}
