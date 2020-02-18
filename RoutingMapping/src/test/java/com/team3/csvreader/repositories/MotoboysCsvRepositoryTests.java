package com.team3.csvreader.repositories;

import com.team3.csvreader.DataIncorrectException;
import com.team3.routemapping.domain.Models.Motoboy;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MotoboysCsvRepositoryTests {

    @Test
    public void MotoboysGetAllSholdReturn1000Motoboys() throws DataIncorrectException {
        MotoboysCsvRepository repository = new MotoboysCsvRepository();
        List<Motoboy> motoboys = repository.getAll();
        assertEquals(1000, motoboys.size());
    }

    @Test
    public void NearestMotoboySearchShouldReturnFirstMotoboy() throws DataIncorrectException {
        MotoboysCsvRepository repository = new MotoboysCsvRepository();
        List<Motoboy> motoboyIList = repository.getAllInRail(-30.07518676, -51.216203, 0.001);

        Motoboy first = motoboyIList.get(0);
        Assert.assertEquals(1, first.getId());
    }

    @Test
    public void MotoboySearchWithNoOrdersShouldReturnAll() throws DataIncorrectException {
        MotoboysCsvRepository repository = new MotoboysCsvRepository();
        List<Motoboy> motoboyIList = repository.getAllWithOrdersEmptyInRail(-30.07518676, -51.216203, 0.001);

        Motoboy first = motoboyIList.get(0);
        Assert.assertEquals(1, first.getId());
    }

    @Test
    public void MotoboySearchWithOrdersLesserThenFiveShouldReturnAll() throws DataIncorrectException {
        MotoboysCsvRepository repository = new MotoboysCsvRepository();
        List<Motoboy> motoboyIList = repository.getAllWithLesserThanFiveOrders(-30.07518676, -51.216203, 0.001);

        Motoboy first = motoboyIList.get(0);
        Assert.assertEquals(1, first.getId());
    }
}
