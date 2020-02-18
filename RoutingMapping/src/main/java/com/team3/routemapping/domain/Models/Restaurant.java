package com.team3.routemapping.domain.Models;

import com.team3.csvreader.CsvAttributeSetter;

public class Restaurant {

    String name;
    double latitude;
    double longitude;
    boolean allowsMultipleOrders;

    public Restaurant(){
    }

    @CsvAttributeSetter(attributeName = "restaurant")
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @CsvAttributeSetter(attributeName = "latitude")
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLatitude() {
        return latitude;
    }

    @CsvAttributeSetter(attributeName = "longitude")
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getLongitude() {
        return longitude;
    }

    public boolean allowsMultipleOrders() {
        return allowsMultipleOrders;
    }
}