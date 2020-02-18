package com.team3.csvreader.repositories;

import com.team3.csvreader.CsvReader;
import com.team3.csvreader.DataIncorrectException;
import com.team3.csvreader.repositories.base.CsvRepositoryBase;
import com.team3.routemapping.domain.Models.Product;
import com.team3.routemapping.domain.Repositories.ProductsRepository;

public class ProductsCsvRepository extends CsvRepositoryBase<Product> implements ProductsRepository {

    private CsvReader _csvReader;

    public ProductsCsvRepository() throws DataIncorrectException {

        super(Product.class, "produtos-por-estabelecimento.csv");
    }
}