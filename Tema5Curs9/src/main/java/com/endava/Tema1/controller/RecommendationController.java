package com.endava.Tema1.controller;

import com.endava.Tema1.model.Movie;
import com.endava.Tema1.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping(path = "/getMostPopularMovies")
    public List<Movie> getMostPopularMovies() {
        return recommendationService.getMostPopularMovies();
    }

    @GetMapping(path = "getMostPopularMoviesByGenre/{genre}")
    public List<Movie> getMostPopularMoviesByGenre(@PathVariable String genre) {
        return recommendationService.getMostPopularMoviesByGenre(genre);
    }
}
