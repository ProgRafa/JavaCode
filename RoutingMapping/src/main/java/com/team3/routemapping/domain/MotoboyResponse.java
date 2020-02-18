package com.team3.routemapping.domain;

import com.team3.routemapping.domain.Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MotoboyResponse {
    private Motoboy nearest;
    private List<Route> route;
    private List<Order> orders;

    public MotoboyResponse(){}

    public MotoboyResponse(List<Motoboy> motoboys, List<Order> orders){
        this.nearest = nearestMotoboy(motoboys);
        this.orders = orders;
        this.route = getRoute();
    }

    public Motoboy nearestMotoboy(List<Motoboy> motoboysInRail){
        return motoboysInRail
                .stream()
                .sorted((m1, m2)->{
                    //distancia a partir dos pontos x,y
                    Double hipoM1= Math.sqrt(Math.pow(m1.getLongitude(), 2) + Math.pow(m1.getLongitude(), 2));
                    Double hipoM2= Math.sqrt(Math.pow(m1.getLongitude(), 2) + Math.pow(m1.getLongitude(), 2));

                    //compara quem está mais distante
                    return Double.compare(hipoM1, hipoM2);
                }).collect(Collectors.toList()).get(0);
    }

    public List<Route> getRoute(){
        Vertice motoboy = nearest;
        List<Edge> edges = new ArrayList<>();
        Route edge;

        for(int i = -1; i < orders.size(); i++){
            for(int j = i + 1; j < orders.size(); j++){
                if(i == -1)
                    edge = new Route("rota"+i+j, 10.0, 5.0, nearest, orders.get(j));
                else
                    edge = new Route("rota"+i+j, 10.0, 5.0, orders.get(i), orders.get(j));
                edges.add(edge);
            }
        }

        ShortPath  path = new ShortPath(edges);
        path.shortPath(nearest);
        edges = path.getShortPath();

        return edges.stream().map(i->(Route) i).collect(Collectors.toList());
    }

    public List<Route> getRoute(List<Order> orders, Motoboy nearest){
        Vertice motoboy = nearest;
        List<Edge> edges = new ArrayList<>();
        Route edge;

        for(int i = -1; i < orders.size(); i++){
            for(int j = i + 1; j < orders.size(); j++){
                if(i == -1)
                    edge = new Route("rota"+i+j, 10.0, 5.0, nearest, orders.get(j));
                else
                    edge = new Route("rota"+i+j, 10.0, 5.0, orders.get(i), orders.get(j));
                edges.add(edge);
            }
        }

        ShortPath  path = new ShortPath(edges);
        path.shortPath(nearest);
        edges = path.getShortPath();

        return edges.stream().map(i->(Route) i).collect(Collectors.toList());
    }
}
