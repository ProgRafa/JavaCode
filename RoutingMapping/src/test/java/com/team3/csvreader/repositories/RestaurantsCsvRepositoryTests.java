package com.team3.csvreader.repositories;

import com.team3.csvreader.DataIncorrectException;
import com.team3.routemapping.domain.Models.Restaurant;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class RestaurantsCsvRepositoryTests {

    @Test
    public void RestaurantsCsvRepositoryTests() throws DataIncorrectException {
        RestaurantsCsvRepository repository = new RestaurantsCsvRepository();
        List<Restaurant> products = repository.getAll();
        assertNotNull(products);
    }
}
