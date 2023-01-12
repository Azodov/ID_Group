package com.bogcha.application.webRest;


import com.bogcha.application.domain.user.Role;
import com.bogcha.application.domain.user.User;
import com.bogcha.application.repository.UserRepository;
import com.bogcha.application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final UserService userService;
    private final UserRepository userRepository;


    public UserResource(UserService userService,
                        UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody User user){
        if (!checkPasswordLength(user.getPassword())){
            return new ResponseEntity<>("Parol uzuligi 4 dan kam", HttpStatus.BAD_REQUEST);
        }
        if (userService.checkUserName(user.getUserName())){
            return new ResponseEntity<>("Bu user oldin ro'yxatdan o'tgan", HttpStatus.BAD_REQUEST);
        }
        if (user.getRoles().isEmpty()) {
            Set<Role> roles = new HashSet<>();
            roles.add(new Role("ROLE_USER"));
            user.setRoles(roles);
        }
        try{
            return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Bu restoranga user ro'yxatga olingan\nBitta restoranga bitta user!!!", HttpStatus.BAD_REQUEST);
        }
    }

    private Boolean checkPasswordLength(String password){
        return password.length() >= 4;
    }

}
