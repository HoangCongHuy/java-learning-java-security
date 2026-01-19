package com.examplecodewithhuy.javasecurity.controller;

import com.examplecodewithhuy.javasecurity.model.User;
import com.examplecodewithhuy.javasecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        System.out.println(user);
        if (userService.verify(user)) {
            return "Success";
        }

        return "Fail";
    }
}
