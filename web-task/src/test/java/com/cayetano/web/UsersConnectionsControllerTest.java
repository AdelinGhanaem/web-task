package com.cayetano.web;

import com.cayetano.core.ClientConnection;
import com.cayetano.core.UserConnectionsService;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UsersConnectionsControllerTest {


    private Mockery context = new Mockery();

    private UserConnectionsService service;
    private UsersConnectionsController controller;

    @Before
    public void setUp() throws Exception {
        service            = context.mock(UserConnectionsService.class);
        controller = new UsersConnectionsController(service);

    }

    @Test
    public void shouldPopulateTheModeAndNavigateToConnectionsList() {
        final int pageNumber = 1;
        final List<ClientConnection> expectedConnections = new ArrayList<>();
        context.checking(new Expectations() {{
            oneOf(service).getConnectionsByPage(pageNumber);
            will(returnValue(expectedConnections));
        }});

//       controller.getUserConnections();


    }

}