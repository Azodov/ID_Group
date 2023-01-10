package com.restaurant.application.webRest;

import com.restaurant.application.domain.User;
import com.restaurant.application.repository.UserRepository;
import com.restaurant.application.security.JwtTokenProvider;
import com.restaurant.application.webRest.vm.LoginVM;
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

    public UserJwtController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
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
            return ResponseEntity.badRequest().body("Login yoki parol xato");
        }
    }

    @GetMapping("/getMe")
    public ResponseEntity<?> getMe(Principal principal){
        if (principal == null){
            return ResponseEntity.status(403).body("Akkauntga kirilmagan");
        }
        User user = userRepository.findByLogin(principal.getName());
        return ResponseEntity.ok(user);
    }
}
