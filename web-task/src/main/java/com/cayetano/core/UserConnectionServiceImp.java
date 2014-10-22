package com.cayetano.core;

import com.cayetano.persistense.UserConnectionsRepository;
import com.cayetano.persistense.entities.ClientConnectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by adelin.ghanayem@gmail.com
 */
@Component
public class UserConnectionServiceImp implements UserConnectionsService {

    private UserConnectionsRepository repository;
    private Adapter<ClientConnection, ClientConnectionEntity> adapter;


    @Autowired
    public UserConnectionServiceImp(UserConnectionsRepository repository, Adapter<ClientConnection, ClientConnectionEntity> adapter) {
        this.repository = repository;
        this.adapter = adapter;
    }

    @Override
    public List<ClientConnection> getConnectionsByPage(int pageNumber) {
        return adapter.to(repository.getConnectionsPage(pageNumber));
    }

}
