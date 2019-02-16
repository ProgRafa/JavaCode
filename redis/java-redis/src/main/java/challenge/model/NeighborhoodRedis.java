package challenge.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe para mapear o bairro no Redis
 *
 */
@Cacheable(value = "neighborhood")
public class NeighborhoodRedis implements Serializable {

    private String id;
    private String name;
    private List<RestaurantRedis> restaurants;

    public NeighborhoodRedis() {
        this.restaurants = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RestaurantRedis> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantRedis> restaurants) {
        this.restaurants = restaurants;
    }

    public void addRestaurant(RestaurantRedis rest){
        this.restaurants.add(rest);
    }
}
