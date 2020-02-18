package com.team3.routemapping.domain.Models;

import com.team3.routemapping.domain.Models.Product;

import java.util.List;

public class Order implements Vertice{

    private String orderID;
    private String motoboyID;
    private String restaurantID;
    private String userID;
    private Double latitude;
    private Double longitude;
    private List<Product> items;
    private Boolean close;

    @Override
    public void close() {
        this.close = true;
    }

    @Override
    public void open() {
        this.close = false;
    }

    @Override
    public boolean isClosed() {
        return this.close;
    }
}
