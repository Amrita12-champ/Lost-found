package com.amrita.lostfoundbackend.controller;

import com.amrita.lostfoundbackend.entity.user;
import com.amrita.lostfoundbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public user register(@RequestBody user user) {
        return userService.registerUser(user);
    }
}