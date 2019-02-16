package challenge.service;

import challenge.model.NeighborhoodMongo;
import challenge.repository.NeighborhoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NeighborhoodServiceImpl implements NeighborhoodService {
    @Autowired
    NeighborhoodRepository repository;
    @Autowired
    RestaurantService service;

    @Override
    public List<NeighborhoodMongo> getAll() {
        return repository.findAll();
    }

    @Override
    public List<NeighborhoodMongo> getNear(Double x, Double y) {
        return repository.findByGeometryNear(new Point(x, y));
    }
}
