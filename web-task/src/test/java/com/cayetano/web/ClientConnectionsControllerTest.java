package com.cayetano.web;

import com.cayetano.core.ClientConnection;
import com.cayetano.core.ClientConnectionsService;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ClientConnectionsControllerTest {


    private Mockery context = new Mockery();

    private ClientConnectionsService service;
    private ClientConnectionsController controller;

    @Before
    public void setUp() throws Exception {
        service            = context.mock(ClientConnectionsService.class);
        controller = new ClientConnectionsController(service);

    }

    @Test
    public void shouldPopulateTheModeAndNavigateToConnectionsList() {
        final int pageNumber = 1;
        final List<ClientConnection> expectedConnections = new ArrayList<>();
        context.checking(new Expectations() {{
//            oneOf(service).getAllConnections(pageNumber);
            will(returnValue(expectedConnections));
        }});

//       controller.getUserConnections();


    }

}