package com.cayetano.persistense;

import com.cayetano.core.ClientConnection;
import com.cayetano.persistense.entities.ClientConnectionEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by adelin.ghanayem@gmail.com
 */
@Component
class HSQLDBUserConnectionsRepository implements UserConnectionsRepository {

    private SessionFactory sessionFactory;

    @Autowired
    HSQLDBUserConnectionsRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveConnection(ClientConnectionEntity entity) {


        Session session = sessionFactory.openSession();

        try {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);


            transaction.commit();
        } finally {
            session.close();

        }


    }

    @Override
    public List<ClientConnectionEntity> getConnections() {
        Session session = sessionFactory.openSession();
        List<ClientConnectionEntity> entities = session.createQuery("from ClientConnectionEntity").list();
        session.close();
        return entities;
    }

    @Override
    public List<ClientConnectionEntity> getConnectionBetween(long start, long end) {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("FROM com.cayetano.persistense.entities.ClientConnectionEntity c" +
                    " WHERE c.connectionTime between :start and :end ")
                    .setParameter("start", start)
                    .setParameter("end", end);
            List<ClientConnectionEntity> list = query.list();
            return list;

        } finally {

            session.close();
        }


    }
}
