package com.team3.csvreader.repositories;

import com.team3.csvreader.DataIncorrectException;
import com.team3.routemapping.domain.Models.Client;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ClientsCsvRepositoryTests {

    @Test
    public void ClientsGetAllSholdReturn1000Clients() throws DataIncorrectException {
        ClientsCsvRepository repository = new ClientsCsvRepository();
        List<Client> clients = repository.getAll();
        assertEquals(1000, clients.size());
    }
}
