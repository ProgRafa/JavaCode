package challenge.repository;

import challenge.model.NeighborhoodMongo;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NeighborhoodRepository extends MongoRepository<NeighborhoodMongo, String> {
    List<NeighborhoodMongo> findAll();

    List<NeighborhoodMongo> findByGeometryNear(Point point);
}
