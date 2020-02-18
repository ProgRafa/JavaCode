package com.team3.csvreader.repositories;

import com.team3.csvreader.DataIncorrectException;
import com.team3.csvreader.repositories.base.CsvRepositoryBase;
import com.team3.routemapping.domain.Models.Motoboy;
import com.team3.routemapping.domain.Repositories.MotoboysRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MotoboysCsvRepository extends CsvRepositoryBase<Motoboy> implements MotoboysRepository {

    public MotoboysCsvRepository() throws DataIncorrectException {
        super(Motoboy.class, "motoboys.csv");
    }

    @Override
    public List<Motoboy> getAllWithOrdersEmptyInRail(double latitude, double longitude, double rail){
        return data.stream()
                .filter(d->!d.hasOrder())
                .filter(p-> betwen(latitude - rail, rail + latitude, p.getLatitude()) &&
                        betwen(longitude - rail, rail + longitude, p.getLongitude()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Motoboy> getAllWithLesserThanFiveOrders(double latitude, double longitude, double rail){
        return data.stream().filter(d->d.canAddOrder())
                .filter(p-> betwen(latitude - rail, rail + latitude, p.getLatitude()) &&
                betwen(longitude - rail, rail + longitude, p.getLongitude()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Motoboy> getAllInRail(double latitude, double longitude, double rail) {
        return data.stream().filter
                (p-> betwen(latitude - rail, rail + latitude, p.getLatitude()) &&
                        betwen(longitude - rail, rail + longitude, p.getLongitude()))
                .collect(Collectors.toList());
    }

    private boolean betwen(double minValue, double maxValue, double value){
        return value <= maxValue && value >= minValue;

    }
}
