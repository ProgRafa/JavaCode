package com.team3.csvreader.repositories.base;

import com.team3.csvreader.CsvReader;
import com.team3.csvreader.DataIncorrectException;

import java.io.File;
import java.util.List;

public class CsvRepositoryBase<T> {
    protected CsvReader _csvReader;
    protected List<T> data;

    public CsvRepositoryBase(Class tClass, String resourceFileName) throws DataIncorrectException {
        String fileUrl = ClassLoader.getSystemResource(resourceFileName).getFile();
        File file = new File(fileUrl);
        _csvReader = new CsvReader<T>(tClass, file);
        seed();
    }

    private void seed(){
        data = _csvReader.getData();
    }

    public List<T> getAll(){
        return  data;
    }
}