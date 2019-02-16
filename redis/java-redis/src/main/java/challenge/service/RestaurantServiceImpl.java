package challenge.service;

import challenge.model.NeighborhoodMongo;
import challenge.model.NeighborhoodRedis;
import challenge.model.RestaurantMongo;
import challenge.model.RestaurantRedis;
import challenge.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository repository;
	@Autowired
	NeighborhoodService service;
	@Autowired
	RedisOperations<String, NeighborhoodRedis> redisOperations;

	@Override
	//@CachePut(cacheNames = "neighborhood", key = "#result.id")
	public NeighborhoodRedis findInNeighborhood(double x, double y) {
		NeighborhoodMongo neighborhood = service.getNear(x, y).get(0);
		NeighborhoodRedis result = this.findNeighborhood(neighborhood);
		return result;
	}

	@Cacheable(value = "neighborhood", key = "#neighborhood.id")
	private NeighborhoodRedis findNeighborhood(NeighborhoodMongo neighborhood){
		NeighborhoodRedis redis = new NeighborhoodRedis();

		redis = redisOperations.opsForValue().get("neighborhood:" + neighborhood.getId());

		if(redis != null)
			return redis;

		redis = new NeighborhoodRedis();
		redis.setId(neighborhood.getId());
		redis.setName(neighborhood.getName());

		List<RestaurantMongo> restaurants = repository.findByLocationWithin(neighborhood.getGeometry());

		for(RestaurantMongo mongo : restaurants){
			RestaurantRedis restRedis = new RestaurantRedis();

			restRedis.setId(mongo.getId());
			restRedis.setName(mongo.getName());
			restRedis.setX(((GeoJsonPoint)mongo.getLocation()).getX());
			restRedis.setY(((GeoJsonPoint)mongo.getLocation()).getY());

			redis.addRestaurant(restRedis);
			redis.getRestaurants().sort(Comparator.comparing(RestaurantRedis::getName));
		}

		redisOperations.opsForValue().set("neighborhood:"+redis.getId(), redis);

		return redis;
	}

	public List<RestaurantMongo> restaurantsNear(double x, double y) {
		NeighborhoodMongo neighborhood = service.getNear(x, y).get(0);

		return repository.findByLocationWithin(neighborhood.getGeometry());
	}

	public List<RestaurantMongo> restaurants() {
		return repository.findAll();
	}
}
