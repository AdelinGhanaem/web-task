package com.cayetano.core;

import com.cayetano.persistense.ClientConnectionsRepository;
import com.cayetano.persistense.entities.ClientConnectionEntity;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ClientConnectionsServiceImplTest {


    private Mockery context = new Mockery();

    private ClientConnectionsServiceImpl service;

    private ClientConnectionsRepository clientConnectionsRepository;

    private Adapter<ClientConnection, ClientConnectionEntity> adapter;

    @Before
    public void setUp() throws Exception {
        clientConnectionsRepository = context.mock(ClientConnectionsRepository.class);
        adapter = context.mock(Adapter.class);
        service = new ClientConnectionsServiceImpl(clientConnectionsRepository, adapter);
    }


    @Test
    public void shouldSaveClientConnection() {

        final ClientConnection someConnection = new ClientConnection("someSource", new Date(), "SomeClient");
        final ClientConnectionEntity someEntity = new ClientConnectionEntity();

        context.checking(new Expectations() {{
            oneOf(adapter).from(someConnection);
            will(returnValue(someEntity));
            oneOf(clientConnectionsRepository).saveConnection(someEntity);
        }});

        service.saveClientConnection(someConnection);

    }


    @Test
    public void shouldReturnAllClientsConnection() {

        final List<ClientConnection> expectedList = new ArrayList<ClientConnection>() {{
            add(new ClientConnection("someSource1", new Date(), "SomeClient1"));
        }};

        final List<ClientConnectionEntity> expectedEntitiesList = new ArrayList<ClientConnectionEntity>() {{
            add(new ClientConnectionEntity());
        }};

        context.checking(new Expectations() {{
            oneOf(clientConnectionsRepository).getConnections();
            will(returnValue(expectedEntitiesList));
            oneOf(adapter).to(expectedEntitiesList);
            will(returnValue(expectedList));
        }});

        assertThat(expectedList, is(equalTo(service.getAllConnections())));

    }


    @Test
    public void shouldReturnClientConnectionsBetweenTwoDates() {

        final Date firstDate = new Date();
        final Date second = new Date();

        final List<ClientConnection> expectedList = new ArrayList<ClientConnection>() {{
            add(new ClientConnection("someSource1", new Date(), "SomeClient1"));
        }};

        final List<ClientConnectionEntity> expectedEntitiesList = new ArrayList<ClientConnectionEntity>() {{
            add(new ClientConnectionEntity());
        }};

        context.checking(new Expectations() {{
            oneOf(clientConnectionsRepository).getConnectionBetween(firstDate.getTime(), second.getTime());
            will(returnValue(expectedEntitiesList));
            oneOf(adapter).to(expectedEntitiesList);
            will(returnValue(expectedList));
        }});

        assertThat(expectedList, is(equalTo(service.getConnectionBetween(firstDate, second))));

    }

}

