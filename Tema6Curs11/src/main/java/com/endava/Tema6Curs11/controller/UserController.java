package com.endava.Tema6Curs11.controller;

import com.endava.Tema6Curs11.model.User;
import com.endava.Tema6Curs11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/addUser")
    public User add(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping(path = "/findAllUsers")
    public List<User> findAll() {
        return userService.findAllUsers();
    }
}
