package com.endava.Tema1.service;

import com.endava.Tema1.model.Movie;
import com.endava.Tema1.model.User;
import com.endava.Tema1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(String name) {
        User user = new User(name);
        userRepository.insert(user);
    }

    public void insertUsers() {
        userRepository.deleteAll();
        userRepository.insert(new User("Ion"));
        userRepository.insert(new User("Vasile"));
        userRepository.insert(new User("Mircea"));
        userRepository.insert(new User("Ionut"));
        userRepository.insert(new User("Alex"));
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
