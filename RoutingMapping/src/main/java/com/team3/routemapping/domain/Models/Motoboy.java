package com.team3.routemapping.domain.Models;

import com.team3.csvreader.CsvAttributeSetter;

import java.util.ArrayList;
import java.util.List;

public class Motoboy implements Vertice{

    private int id;
    private double longitude;
    private double latitude;
    private  List<Order> orders;
    private Boolean closed;

    public Motoboy(){
        orders = new ArrayList<Order>();
    }

    @CsvAttributeSetter(attributeName = "ID Motoboy")
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    @CsvAttributeSetter(attributeName = "Longitude")
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getLongitude() {
        return longitude;
    }

    @CsvAttributeSetter(attributeName = "Latitude")
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLatitude() {
        return latitude;
    }

    public boolean hasOrder() {
        return !this.orders
               .isEmpty();
    }

    public boolean canAddOrder() {
        return orders.size() < 5;
    }

    @Override
    public void close() {
        this.closed = true;
    }

    @Override
    public void open() {
        this.closed = false;
    }

    @Override
    public boolean isClosed() {
        return this.closed;
    }
}
