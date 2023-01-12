package com.bogcha.application.webRest;

import com.bogcha.application.domain.restaurant.Restaurant;
import com.bogcha.application.domain.user.User;
import com.bogcha.application.service.RestaurantService;
import com.bogcha.application.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    private final UserService userService;
    private final RestaurantService restaurantService;

    public RestaurantController(UserService userService, RestaurantService restaurantService) {
        this.userService = userService;
        this.restaurantService = restaurantService;
    }

    @PostMapping("/restaurant")
    public ResponseEntity<?> save(@RequestBody Restaurant restaurant, Principal principal){
        if (principal == null){
            Restaurant restaurant1 = restaurantService.save(restaurant);
            return new ResponseEntity<>(restaurant1, null, 201);
        } else {
            User user = userService.findByUserName(principal.getName());
            restaurant.setUser(user);
            Restaurant restaurant1 = restaurantService.save(restaurant);
            return new ResponseEntity<>(restaurant1, null, 201);
        }
    }
}
