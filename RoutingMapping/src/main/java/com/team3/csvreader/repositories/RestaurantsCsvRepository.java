package com.team3.csvreader.repositories;

import com.team3.csvreader.CsvReader;
import com.team3.csvreader.DataIncorrectException;
import com.team3.csvreader.repositories.base.CsvRepositoryBase;
import com.team3.routemapping.domain.Models.Restaurant;
import com.team3.routemapping.domain.Repositories.RestaurantRepository;

public class RestaurantsCsvRepository extends CsvRepositoryBase<Restaurant> implements RestaurantRepository {
    private CsvReader _csvReader;

    public RestaurantsCsvRepository() throws DataIncorrectException {
        super(Restaurant.class, "estabelecimento-por-municipio.csv");
    }
}