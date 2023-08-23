package com.example.api.controllers;

import com.example.api.entities.User;
import com.example.api.dto.UserRegistration;
import com.example.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRegistration user) {
        return userService.registerUser(user);
    }
}