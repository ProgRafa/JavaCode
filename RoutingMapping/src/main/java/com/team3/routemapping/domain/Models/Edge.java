package com.team3.routemapping.domain.Models;

public interface Edge {
    Vertice getArrival();
    void setArrival(Vertice arrival);

    Vertice getDeparture();
    void setDeparture(Vertice departure);

    Double getHeuristic();
    Boolean contains(Vertice v);
}