package com.team3.routemapping.domain;

import com.team3.routemapping.domain.Models.Motoboy;
import com.team3.routemapping.domain.Models.Order;
import com.team3.routemapping.domain.Models.Restaurant;

import java.util.List;

public class MotoboyRequest {

    private List<Order> order;
    private Restaurant restaurant;
    MotoboySearch motoboySearch;

    public MotoboyRequest(List<Order> order) {
        this.order = order;
    }

    public MotoboyResponse getResponse() {
        List<Motoboy> possibleMotoboysList;

        if (!restaurant.allowsMultipleOrders())
            possibleMotoboysList = motoboySearch
                    .possiblesMotoboysNearWithoutOrder(restaurant.getLatitude(),
                            restaurant.getLongitude());
        else
            possibleMotoboysList = motoboySearch
                    .possiblesMotoboysWithLessThanFiveOrders(restaurant.getLatitude(),
                            restaurant.getLongitude());

        MotoboyResponse motoboyResponse = new MotoboyResponse(possibleMotoboysList, order);

        return motoboyResponse;
    }

}