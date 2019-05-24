package com.endava.tema4.controller;

import com.endava.tema4.model.Movie;
import com.endava.tema4.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping(path = "/addMovie")
    public void add(@RequestParam String title, @RequestParam String genre, @RequestParam int rating) {
        movieService.add(title, genre, rating);
    }

    @GetMapping(path = "/getAllMovies")
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @GetMapping(path = "/getById/{id}")
    public Movie getById(@PathVariable int id) {
        return movieService.getById(id);
    }

    @PutMapping(path = "/updateMovie")
    public void update(@RequestBody Movie movie) {
        movieService.update(movie);
    }

    @DeleteMapping(path = "/deleteAllMovies")
    public void deleteAll() {
        movieService.deleteAll();
    }
}
