package com.endava.Tema1.controller;

import com.endava.Tema1.model.User;
import com.endava.Tema1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/addUser")
    public void add(@RequestParam String name) {
        userService.addUser(name);
    }

    @PostMapping(path = "/insertUsers")
    public void insertUsers() {
        userService.insertUsers();
    }

    @GetMapping(path = "/findAllUsers")
    public List<User> findAll() {
        return userService.findAllUsers();
    }

    @DeleteMapping(path = "/deleteAllUsers")
    public void deleteAll() {
        userService.deleteAllUsers();
    }
}
