package challenge;

import challenge.service.NeighborhoodService;
import challenge.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

	@Autowired
	private RestaurantService service;
	@Autowired
	private NeighborhoodService neighborhood;


	@GetMapping("/restaurants/findInNeighborhood")
	public ResponseEntity<?> findInNeighborhood(@RequestParam("x") Double x, @RequestParam("y") Double y) {
		return ResponseEntity.ok(service.findInNeighborhood(x, y));
	}

	@GetMapping("/neighborhood")
	public ResponseEntity<?> findNeighborhood() {
		return ResponseEntity.ok(neighborhood.getAll());
	}

	@GetMapping("/restaurants")
	public ResponseEntity<?> findRestaurants() {
		return ResponseEntity.ok(service.restaurants());
	}

	@GetMapping("/restaurants/near")
	public ResponseEntity<?> findRestaurantsNear(@RequestParam("x") Double x, @RequestParam("y") Double y) {
		return ResponseEntity.ok(service.restaurantsNear(x, y));
	}
}
