package com.team3.csvreader;

import com.team3.routemapping.domain.Models.Client;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class CsvReaderNewFeaturesTests{
    @Test
    public void fixUnformatedLinesShouldFormatLine() throws DataIncorrectException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String line = "\"1,000\",-51.15231602,-30.0416058";
        CsvReader<Client> clientCsvReader = new CsvReader<Client>(Client.class, null);
        Method formatLine = CsvReader.class.getDeclaredMethod("fixUnformatedLines", String.class);
        formatLine.setAccessible(true);
        String formatedLine = (String) formatLine.invoke(clientCsvReader, line);
        assertEquals("1000,-51.15231602,-30.0416058", formatedLine);
    }

    @Test
    public void fixUnformatedLinesShouldFormatSecoundLine() throws DataIncorrectException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String line = "Galinhada executivo, ,3848076bc47f22e56d585493e80f8563872b5f6912e7647d346c51096bfb56be,Mineiro Delivery - Boa Viagem,\"Almoço por até R$ 13,90\",13.9,RECIFE";

        CsvReader<Client> clientCsvReader = new CsvReader<Client>(Client.class, null);
        Method formatLine = CsvReader.class.getDeclaredMethod("fixUnformatedLines", String.class);
        formatLine.setAccessible(true);
        String formatedLine = (String) formatLine.invoke(clientCsvReader, line);
        assertEquals("Galinhada executivo, ,3848076bc47f22e56d585493e80f8563872b5f6912e7647d346c51096bfb56be,Mineiro Delivery - Boa Viagem,Almoço por até R$ 13,90,13.9,RECIFE", formatedLine);
    }
}