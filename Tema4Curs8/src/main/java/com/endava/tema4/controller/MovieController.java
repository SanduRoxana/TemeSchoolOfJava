package com.endava.tema4.controller;

import com.endava.tema4.model.Movie;
import com.endava.tema4.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping(path = "/addMovie")
    public void add(@RequestParam String title, @RequestParam String genre, @RequestParam int rating,
                    HttpServletResponse response) {
        movieService.add(title, genre, rating, response);
    }

    @GetMapping(path = "/getAllMovies")
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @GetMapping(path = "/getById/{id}")
    public Movie getById(@PathVariable int id, HttpServletResponse response) {
        return movieService.getById(id, response);
    }

    @PutMapping(path = "/update/{id}")
    public void update(@PathVariable int id, @RequestParam int rating, HttpServletResponse response) {
        movieService.update(id, rating, response);
    }

    @DeleteMapping(path = "/deleteAllMovies")
    public void deleteAll() {
        movieService.deleteAll();
    }
}
