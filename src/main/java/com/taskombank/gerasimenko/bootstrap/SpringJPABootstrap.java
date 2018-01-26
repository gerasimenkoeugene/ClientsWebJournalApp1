package com.taskombank.gerasimenko.bootstrap;

import com.taskombank.gerasimenko.entity.Client;
import com.taskombank.gerasimenko.service.ClientServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ClientServiceDAO clientService;

    @Autowired
    public void setClientService(ClientServiceDAO clientService) {
        this.clientService = clientService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadClients();
    }

    private void loadClients() {
        Client client1 = new Client("Test client 1","client1@gmail.com", "+38050 111 11 11");
        clientService.saveOrUpdate(client1);

        Client client2 = new Client("Test client 2","client2@gmail.com", "+38050 222 22 22");
        clientService.saveOrUpdate(client2);
    }
}
