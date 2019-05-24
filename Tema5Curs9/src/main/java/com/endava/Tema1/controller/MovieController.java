package com.endava.Tema1.controller;

import com.endava.Tema1.model.Movie;
import com.endava.Tema1.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping(path = "/addMovie")
    public void add(@RequestParam String title, String genre) {
        movieService.addMovie(title, genre);
    }

    @PostMapping(path = "/insertMovies")
    public void insertMovies() {
        movieService.insertMovies();
    }

    @GetMapping(path = "/findAllMovies")
    public List<Movie> findAll() {
        return movieService.findAllMovies();
    }

    @DeleteMapping(path = "/deleteAllMovies")
    public void deleteAll() {
        movieService.deleteAllMovies();
    }
}
