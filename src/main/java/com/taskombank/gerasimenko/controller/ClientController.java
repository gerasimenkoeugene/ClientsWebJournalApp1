package com.taskombank.gerasimenko.controller;

import com.taskombank.gerasimenko.entity.Client;
import com.taskombank.gerasimenko.service.ClientServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private ClientServiceDAO clientService;

    @Autowired
    public void setClientService(ClientServiceDAO clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Client> getAllClients(){
        return clientService.listAll();
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public Client getClientById(@PathVariable Integer id){
        return clientService.getById(id);
    }

    @RequestMapping(value = "",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Client saveClient(@RequestBody Client client){
        return clientService.saveOrUpdate(client);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void deleteClient(@PathVariable Integer id){
        clientService.delete(id);
    }
}
