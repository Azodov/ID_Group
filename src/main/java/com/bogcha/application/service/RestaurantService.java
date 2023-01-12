package com.bogcha.application.service;

import com.bogcha.application.domain.restaurant.Restaurant;
import com.bogcha.application.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant save(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAll(){
        return restaurantRepository.findAll();
    }
}
