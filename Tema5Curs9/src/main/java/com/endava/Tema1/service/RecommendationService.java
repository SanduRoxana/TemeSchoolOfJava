package com.endava.Tema1.service;

import com.endava.Tema1.model.Movie;
import com.endava.Tema1.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMostPopularMovies() {
        List<Movie> movieList = movieRepository.findAll();
        List<Movie> popularMovieList = movieList.stream()
                                                .filter(m -> m.getRating() >= 6)
                                                .collect(Collectors.toList());

        popularMovieList.sort(Comparator.comparing(Movie::getRating).reversed());

        return popularMovieList;
    }

    public List<Movie> getMostPopularMoviesByGenre(String genre) {
        List<Movie> movieList = movieRepository.findAll();
        List<Movie> popularMovieList = movieList.stream()
                                                .filter(m -> m.getGenre().equals(genre))
                                                .collect(Collectors.toList());

        popularMovieList.sort(Comparator.comparing(Movie::getRating).reversed());

        return popularMovieList;
    }
}
