package com.taskombank.gerasimenko.service;


import com.taskombank.gerasimenko.entity.Client;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface ClientServiceDAO {
    List<Client> listAll();

    Client getById(Integer id);

    Client saveOrUpdate(Client domainObject);

    Client getByName(@NotNull final String username);

    void delete(Integer id);
}
