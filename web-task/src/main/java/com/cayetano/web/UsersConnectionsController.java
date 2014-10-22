package com.cayetano.web;

import com.cayetano.core.ClientConnection;
import com.cayetano.core.UserConnectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by adelin.ghanayem@gmail.com
 */
@Controller
@RequestMapping("/connections-list")
public class UsersConnectionsController {


    private UserConnectionsService service;

    @Autowired
    public UsersConnectionsController(UserConnectionsService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getUserConnections(@RequestParam int pageNumber, Model model) {

        List<ClientConnection> list = service.getConnectionsByPage(pageNumber);

        model.addAttribute("connections", list);

        return "connections-list";

    }

}
