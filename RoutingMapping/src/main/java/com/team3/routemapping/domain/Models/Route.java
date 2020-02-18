package com.team3.routemapping.domain.Models;

public class Route implements Edge {
    private String id;
    private String location;
    private Double distance;
    private Double minutes;
    private Vertice departure;
    private Vertice arrival;

    public Route(){}

    public Route(String id, Double dist, Double min, Vertice departure, Vertice arrival){
        this.id = id;
        this.distance = dist;
        this.minutes = min;
        this.departure = departure;
        this.arrival = arrival;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getMinutes() {
        return minutes;
    }

    public void setMinutes(Double minutes) {
        this.minutes = minutes;
    }

    @Override
    public Vertice getDeparture() {
        return departure;
    }

    @Override
    public void setDeparture(Vertice departure) {
        this.departure = departure;
    }

    @Override
    public Double getHeuristic() {
        return this.minutes + (0.2 * this.distance);
    }

    @Override
    public Boolean contains(Vertice vertice) {
        if(this.arrival.equals(vertice))
            return true;
        if(this.departure.equals(vertice))
            return true;

        return false;
    }

    @Override
    public Vertice getArrival() {
        return arrival;
    }

    @Override
    public void setArrival(Vertice arrival) {
        this.arrival = arrival;
    }
}
