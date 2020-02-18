package com.team3.routemapping.domain.Models;

import com.team3.csvreader.CsvAttributeSetter;

public class Client {

    int id;
    double longitude;
    double latitude;

    @CsvAttributeSetter(attributeName = "ID Cliente")
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

}
