package com.taskombank.gerasimenko.service;

import com.taskombank.gerasimenko.config.JpaIntegrationConfig;
import com.taskombank.gerasimenko.entity.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JpaIntegrationConfig.class)
public class ClientServiceDAOTest {
    private ClientServiceDAO clientService;

    @Autowired
    public void setclientService(ClientServiceDAO clientService) {
        this.clientService = clientService;
    }

    @Test
    public void testList() throws Exception {
        List<Client> clients = clientService.listAll();

        assert clients.size() == 2;
    }

    @Test
    public void testSaveAndDelete() throws Exception{
        List<Client> clients = clientService.listAll();
        assert clients.size() == 2;

        Client newClient = new Client("tesname", "tesemail@mail.com", "+333 09322");
        clientService.saveOrUpdate(newClient);
        clients = clientService.listAll();
        assert clients.size() == 3;

        clientService.delete(clients.get(1).getId());
        clients = clientService.listAll();

        assert clients.size() == 2;
    }

}
