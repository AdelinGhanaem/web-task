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


        Transaction transaction = session.beginTransaction();


        session.persist(entity);


        transaction.commit();

        session.close();
    }

    @Override
    public List<ClientConnectionEntity> getConnections() {
        Session session = sessionFactory.openSession();
        List<ClientConnectionEntity> entities = session.createQuery("from ClientConnectionEntity").list();
        session.close();
        return entities;
    }

    @Override
    public List<ClientConnectionEntity> getConnectionBetween(Date start, Date end) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from ClientConnectionEntity" +
                " where connectionTime between :start  and  :end")
                .setParameter("start", new java.sql.Date(start.getTime()))
                .setParameter("end", new java.sql.Date(end.getTime()));
        List<ClientConnectionEntity> list = query.list();
        session.close();
        return list;
    }
}
