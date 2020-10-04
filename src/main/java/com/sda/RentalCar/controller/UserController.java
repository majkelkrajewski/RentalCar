package com.sda.RentalCar.controller;

import com.sda.RentalCar.domain.User;
import com.sda.RentalCar.dto.CreateUserDto;
import com.sda.RentalCar.service.UserService;
import com.sda.RentalCar.view.UserAndCar;
import com.sda.RentalCar.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final RestTemplate restTemplate;
    private final UserService service;

    @Autowired
    public UserController(UserService service, RestTemplate restTemplate) {
        this.service = service;
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto dto) {
        User u = service.save(dto);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserView>> findAll() {
        List<UserView> users = service.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/external/{userId}")
    public UserView findUserById(@PathVariable Long userId) {
        service.findUserById(userId);

    }



    @GetMapping("/{userId}")
    public UserAndCar find(@PathVariable Long userId) {
        //pobrac usera
        //pociagnac od kolezanki liste aut
        //zbudowa obiekt user and car
    }






}
