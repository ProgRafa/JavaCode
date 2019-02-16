package challenge.service;

import challenge.model.NeighborhoodRedis;
import challenge.model.RestaurantMongo;

import java.util.List;

public interface RestaurantService {
	
	NeighborhoodRedis findInNeighborhood(double x, double y);

	List<RestaurantMongo> restaurants();

	List<RestaurantMongo> restaurantsNear(double x, double y);
}
