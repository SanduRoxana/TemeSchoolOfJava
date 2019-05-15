package com.example.exemplu6.controller;

import com.example.exemplu6.model.Movie;
import com.example.exemplu6.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping(path = "/add")
    public int add(@RequestParam String title, @RequestParam String genre, @RequestParam int rating, HttpServletResponse response) {
        return movieService.add(title, genre, rating, response);
    }

    @GetMapping(path = "/getAll")
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @GetMapping(path = "/getById/{id}")
    public Movie getById(@PathVariable int id, HttpServletResponse response) {
        return movieService.getById(id, response);
    }

    @PutMapping(path = "/update/{id}")
    public int update(@PathVariable int id, @RequestParam int rating, HttpServletResponse response) {
        return movieService.update(id, rating, response);
    }

    @DeleteMapping(path = "/delete/{id}")
    public int delete(@PathVariable int id, HttpServletResponse response) {
        return movieService.delete(id, response);
    }
}
