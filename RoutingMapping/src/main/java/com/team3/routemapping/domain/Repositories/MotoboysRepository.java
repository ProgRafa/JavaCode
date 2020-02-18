package com.team3.routemapping.domain.Repositories;

import com.team3.routemapping.domain.Models.Motoboy;
import java.util.List;

public interface MotoboysRepository {//extends MongoRepository<Motoboy, String> {
    List<Motoboy> getAllInRail(double latitude, double longitude, double rail);

    List<Motoboy> getAllWithOrdersEmptyInRail(double latitude, double longitude, double rail);

    List<Motoboy> getAllWithLesserThanFiveOrders(double latitude, double longitude, double rail);
    //List<Motoboy> getAllByLocationNear(Point point, Distance dist);
}
