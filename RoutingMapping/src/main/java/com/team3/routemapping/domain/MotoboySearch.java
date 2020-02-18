package com.team3.routemapping.domain;

import com.team3.routemapping.domain.Models.Motoboy;
import com.team3.routemapping.domain.Repositories.MotoboysRepository;
import java.util.ArrayList;
import java.util.List;

public class MotoboySearch {

    private static double START_RAIL = 0.05;
    private static double STEP = 0.02;
    private static double MAXRAIL = 0.11;

    MotoboysRepository motoboysRepository;

    public List<Motoboy> possiblesMotoboysNearWithoutOrder(double latitude, double longitude){

        List<Motoboy> possibleMotoboys = new ArrayList<>();

        for(Double rail = START_RAIL; rail < MAXRAIL && possibleMotoboys.isEmpty(); rail += STEP)
            possibleMotoboys =  motoboysRepository.getAllWithOrdersEmptyInRail(latitude, longitude, rail);

        return possibleMotoboys;
    }

    public List<Motoboy> possiblesMotoboysWithLessThanFiveOrders(double latitude, double longitude){

        List<Motoboy> possibleMotoboys = new ArrayList<>();

        for(Double rail = START_RAIL; rail < MAXRAIL && possibleMotoboys.isEmpty(); rail += STEP)
            possibleMotoboys =  motoboysRepository.getAllWithLesserThanFiveOrders(latitude, longitude, rail);

        return possibleMotoboys;
    }

    public List<Motoboy> fastersPossiblesMotoboys(double latitude, double longitude){

        List<Motoboy> possibleMotoboys = new ArrayList<>();
        //Point location = new Point();
        //location.setLocation(latitude, longitude);
        //Distance rail = new Distance(5, Metrics.KILOMETERS);
        //possibleMotoboys =  motoboysRepository.getAllByLocationNear(location, rail);

        possibleMotoboys =  motoboysRepository.getAllInRail(latitude, longitude, START_RAIL);

        return possibleMotoboys;
    }
}
