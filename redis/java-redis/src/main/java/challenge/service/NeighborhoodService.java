package challenge.service;

import challenge.model.NeighborhoodMongo;

import java.util.List;

public interface NeighborhoodService {
    List<NeighborhoodMongo> getAll();

    List<NeighborhoodMongo> getNear(Double x, Double y);
}
