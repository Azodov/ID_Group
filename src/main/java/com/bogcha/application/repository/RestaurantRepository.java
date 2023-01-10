package com.bogcha.application.repository;

import com.bogcha.application.domain.Restaurant;
import com.bogcha.application.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    boolean existsByName(String name);
    int countByUser(User user);

    List<Restaurant> findAllByUserId(Long user_id);

}

