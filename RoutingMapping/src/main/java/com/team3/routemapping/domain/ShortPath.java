package com.team3.routemapping.domain;

import com.team3.routemapping.domain.Models.Edge;
import com.team3.routemapping.domain.Models.Vertice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ShortPath {
    private List<Edge> edges;
    private List<Edge> path;

    public ShortPath(List<Edge> a){
        edges = a;
        path = new ArrayList<>();
        this.sortEdges();
    }

    public void shortPath(){
        Edge menor;
        Vertice v1;
        Vertice v2;

        if(!edges.isEmpty()){
            menor = edges.remove(0);
            v1 = menor.getDeparture();
            v2 = menor.getArrival();

            if(!(v1.isClosed() || v2.isClosed())){
                if(close(v1))
                    v1.close();
                if(close(v2))
                    v2.close();
                path.add(menor);
            }
            shortPath();
        }
    }

    public void shortPath(Vertice root){
        Edge menor;
        Vertice v1;
        Vertice v2;

        if(!edges.isEmpty()){
            menor = edges.remove(0);
            v1 = menor.getDeparture();
            v2 = menor.getArrival();

            if(!(v1.isClosed() || v2.isClosed())){
                if(close(v1) || v1 == root)
                    v1.close();
                if(close(v2) || v2 == root)
                    v2.close();
                path.add(menor);
            }
            shortPath(root);
        }
    }

    public Boolean close(Vertice v){
        for(Edge a : path){
            if(a.contains(v)){
                return true;
            }
        }
        return false;
    }

    public void sortEdges(){
        edges.sort(Comparator.comparingDouble(Edge::getHeuristic));
    }

    public Double getShortPathTotalCost(){
        Double total = 0.0;

        for(Edge a : path){
            total += a.getHeuristic();
        }

        return total;
    }

    public List<Edge> getShortPath(){
        return path;
    }
}
