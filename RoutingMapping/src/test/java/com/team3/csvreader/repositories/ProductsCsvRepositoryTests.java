package com.team3.csvreader.repositories;

import com.team3.csvreader.DataIncorrectException;
import com.team3.routemapping.domain.Models.Product;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class ProductsCsvRepositoryTests {
    @Test
    public void ProductsGetAllSholdReturn1000Motoboys() throws DataIncorrectException {
        ProductsCsvRepository repository = new ProductsCsvRepository();
        List<Product> products = repository.getAll();
        assertNotNull(products);
    }
}