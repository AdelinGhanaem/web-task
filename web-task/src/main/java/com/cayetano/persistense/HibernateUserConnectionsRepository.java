package com.cayetano.persistense;

import com.cayetano.persistense.entities.ClientConnectionEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by adelin.ghanayem@gmail.com
 */
@Component
class HibernateUserConnectionsRepository implements UserConnectionsRepository {


    @Override
    public void saveConnection(ClientConnectionEntity entity) {

    }

    @Override
    public List<ClientConnectionEntity> getConnectionsPage(int pageNumber) {
        return new ArrayList<ClientConnectionEntity>() {{

            add(new ClientConnectionEntity("con1", new Date(), "browser"));
            add(new ClientConnectionEntity("con2", new Date(), "browser"));
            add(new ClientConnectionEntity("con3", new Date(), "browser"));
            add(new ClientConnectionEntity("con4", new Date(), "browser"));
            add(new ClientConnectionEntity("con5", new Date(), "browser"));
            add(new ClientConnectionEntity("con6", new Date(), "browser"));
        }};
    }
}
