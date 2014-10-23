package com.cayetano.web;

import com.cayetano.core.ClientConnection;
import com.cayetano.core.ClientConnectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by adelin.ghanayem@gmail.com
 */
@Controller
@RequestMapping("/connections-list")
public class ClientConnectionsController {


    private ClientConnectionsService service;
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    private Object lock = new Object();
    private static final String DATE_PARSE_ERROR_MESSAGE = "An error occurred while trying to read provided start and end dates.\n Please provide dates in this format  dd.MM.YYYY";

    @Autowired
    public ClientConnectionsController(ClientConnectionsService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getUserConnections(Model model) {

        List<ClientConnection> list = service.getAllConnections();

        model.addAttribute("connections", list);

        return "connections-list";

    }


    @RequestMapping(value = "/between", method = RequestMethod.GET)
    public String getConnectionInTimeInterval(@RequestParam String startDate,@RequestParam String endDate, Model model) {
        try {
            Date start = formate(startDate);

            Date end = formate(endDate);

            List<ClientConnection> connections = service.getConnectionBetween(start, end);

            model.addAttribute("connections", connections);

        } catch (ParseException e) {
            model.addAttribute("message", DATE_PARSE_ERROR_MESSAGE);
            return "connections-list";
        }
        return "connections-list";
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "connections-list";
    }

    private Date formate(String s) throws ParseException {
        synchronized (lock) {
            return SIMPLE_DATE_FORMAT.parse(s); // SimpleDateFormat is not thread safe !
        }
    }

}
