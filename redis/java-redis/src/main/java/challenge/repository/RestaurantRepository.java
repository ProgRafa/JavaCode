package challenge.repository;

import challenge.model.RestaurantMongo;
import org.springframework.data.mongodb.core.geo.GeoJson;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends MongoRepository<RestaurantMongo, String> {
    List<RestaurantMongo> findAll();

    List<RestaurantMongo> findByLocationWithin(GeoJson polygon);
}
