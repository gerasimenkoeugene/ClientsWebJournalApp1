package com.taskombank.gerasimenko.controller;

import com.taskombank.gerasimenko.entity.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private static List<Client> clients = new ArrayList<Client>();

    static {
        clients.add(new Client("Test client 1","client1@gmail.com", "+38050 111 11 11"));
        clients.add(new Client("Test client 2","client2@gmail.com", "+38050 222 22 22"));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Client> getAllClients(){
        return clients;
    }
}
