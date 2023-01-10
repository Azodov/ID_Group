package com.bogcha.application.service;

import com.bogcha.application.domain.Restaurant;
import com.bogcha.application.domain.User;
import com.bogcha.application.repository.RestaurantRepository;
import com.bogcha.application.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    public Boolean createRestaurant(Restaurant restaurant, Principal principal) {
        return events(restaurant, principal, "create");
    }

    public Boolean updateRestaurant(Restaurant restaurant, Principal principal) {
        return events(restaurant, principal, "update");
    }

    public Boolean deleteRestaurant(Restaurant restaurant, Principal principal) {
        return events(restaurant, principal, "delete");
    }

    public List<Restaurant> getAllRestaurants(Principal principal) {
        Long user_id = userRepository.findByUserName(principal.getName()).getId();
        List<Restaurant> restaurants = restaurantRepository.findAllByUserId(user_id);
        return restaurants;
    }

    private Boolean events(Restaurant restaurant, Principal principal, String event) {
        User user = userRepository.findByUserName(principal.getName());
        boolean isEvent = false;
        boolean isIdExist = restaurant.getId() != null;

        if (isIdExist){
            try{
                Restaurant restaurant1 = restaurantRepository.findById(restaurant.getId()).get();
                if (restaurant1.getUser().getId().equals(user.getId())){
                    switch (event) {
                        case "update":
                            restaurant.setUser(user);
                            restaurantRepository.save(restaurant);
                            isEvent = true;
                            break;
                        case "delete":
                            restaurantRepository.delete(restaurant);
                            isEvent = true;
                            break;
                    }
                }
            } catch (Exception e){
                System.out.println("ID not found");
            }
        }
        else {
            if (!restaurantRepository.existsByName(restaurant.getName()) && restaurantRepository.countByUser(user) < 1) {
                restaurant.setUser(user);
                restaurantRepository.save(restaurant);
                isEvent = true;
            }
        }
        return isEvent;
    }
}
