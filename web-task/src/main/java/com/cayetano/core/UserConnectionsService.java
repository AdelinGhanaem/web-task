package com.cayetano.core;

import java.util.List;

/**
 * Created by adelin.ghanayem@gmail.com
 */
public interface UserConnectionsService {


    List<ClientConnection> getConnectionsByPage(int pageNumber);
}
