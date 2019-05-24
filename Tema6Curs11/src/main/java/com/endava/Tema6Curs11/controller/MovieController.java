package com.endava.Tema6Curs11.controller;

import com.endava.Tema6Curs11.model.Movie;
import com.endava.Tema6Curs11.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping(path = "/addMovie")
    public Movie add(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @GetMapping(path = "/findAllMovies")
    public List<Movie> findAll() {
        return movieService.findAllMovies();
    }
}
