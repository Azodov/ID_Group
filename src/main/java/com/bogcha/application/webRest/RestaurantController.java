package com.bogcha.application.webRest;

import com.bogcha.application.domain.Restaurant;
import com.bogcha.application.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllRestaurants(Principal principal) {
        return ResponseEntity.ok(restaurantService.getAllRestaurants(principal));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Restaurant restaurant, Principal principal) {
        boolean isCreated = restaurantService.createRestaurant(restaurant, principal);
        if (isCreated){
            return ResponseEntity.ok("Yaratildi");
        } else {
            return ResponseEntity.badRequest().body("Yaratilmadi\n" +
                    "Sabab: Ushbu restoran avvaldan mavjud yoki Sizning restoraningiz 1 tadan ko'p");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Restaurant restaurant, Principal principal) {
        boolean isUpdated = restaurantService.updateRestaurant(restaurant, principal);
        if (isUpdated){
            return ResponseEntity.ok("Yangilandi");
        } else {
            return ResponseEntity.badRequest().body("Yangilanmadi\n" +
                    "Sabab: ID Raqam bo'sh bo'lmasligi kerak");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Restaurant restaurant, Principal principal) {
        boolean isDeleted = restaurantService.deleteRestaurant(restaurant, principal);
        if (isDeleted){
            return ResponseEntity.ok("O'chirildi");
        } else {
            return ResponseEntity.badRequest().body("O'chirilmadi\n" +
                    "Sabab: Ushbu restoran avvaldan mavjud yoki Sizning restoraningiz 1 tadan ko'p");
        }
    }
}
