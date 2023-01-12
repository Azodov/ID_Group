package com.bogcha.application.webRest;

import com.bogcha.application.domain.user.User;
import com.bogcha.application.repository.UserRepository;
import com.bogcha.application.security.JwtTokenProvider;
import com.bogcha.application.service.RestaurantService;
import com.bogcha.application.service.WaiterService;
import com.bogcha.application.webRest.vm.LoginVM;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserJwtController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final WaiterService waiterService;
    private final RestaurantService restaurantService;

    public UserJwtController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserRepository userRepository, WaiterService waiterService, RestaurantService restaurantService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
        this.waiterService = waiterService;
        this.restaurantService = restaurantService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginVM loginVM){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginVM.getUsername(), loginVM.getPassword()));
            User user = userRepository.findByLogin(loginVM.getUsername());
            if (user == null){
                throw new UsernameNotFoundException("Bu foydalanuvch mavjud emas");
            }
            String token = jwtTokenProvider.createToken(user.getUserName(), user.getRoles());
            Map<String, String> map = new HashMap<>();
            map.put("id", String.valueOf(user.getId()));
            map.put("username", user.getUserName());
            map.put("token", token);
            return ResponseEntity.ok(map);
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Login yoki parol xato bo'lishi mumkin\n" +
                    "Yoki sizning obunangiz tugadi");
        }
    }

    @GetMapping("/waiter")
    public ResponseEntity<?> getAll(Principal principal){
        return ResponseEntity.ok(waiterService.findAll());
    }

    @GetMapping("/restaurant")
    public ResponseEntity<?> getAllRestaurants(Principal principal){
        return ResponseEntity.ok(restaurantService.getAll());
    }
}
