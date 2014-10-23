package com.cayetano.web;

import com.cayetano.core.ClientConnection;
import com.cayetano.core.ClientConnectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by adelin.ghanayem@gmail.com
 */
@Component
public class HttpClientRequestLogInterceptor extends HandlerInterceptorAdapter {

    private ClientConnectionsService connectionsService;

    @Autowired
    public HttpClientRequestLogInterceptor(ClientConnectionsService connectionsService) {
        this.connectionsService = connectionsService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ipAddress = request.getRemoteAddr();
        String clientAgent = request.getHeader("User-Agent");
        Date now = new Date();
        connectionsService.saveClientConnection(new ClientConnection(ipAddress, now, clientAgent));
        return true;
    }

}
