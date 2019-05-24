package com.endava.Tema1.controller;

import com.endava.Tema1.model.Rating;
import com.endava.Tema1.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping(path = "/addRating")
    public void add(@RequestParam String userName, @RequestParam String movieTitle, @RequestParam double movieRating) {
        ratingService.addRating(userName, movieTitle, movieRating);
    }

    @GetMapping(path = "/findAllRating")
    public List<Rating> findAll() {
        return ratingService.findAllRating();
    }

    @DeleteMapping(path = "/deleteAllRating")
    public void deleteAll() {
        ratingService.deleteAllRating();
    }
}
