package com.team3.csvreader.repositories;

import com.team3.csvreader.DataIncorrectException;
import com.team3.csvreader.repositories.base.CsvRepositoryBase;
import com.team3.routemapping.domain.Models.Client;
import com.team3.routemapping.domain.Repositories.ClientsRepository;

public class ClientsCsvRepository extends CsvRepositoryBase<Client> implements ClientsRepository {

    public ClientsCsvRepository() throws DataIncorrectException {
        super(Client.class,"clientes.csv" );
    }
}
