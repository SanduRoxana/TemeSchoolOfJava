package com.endava.tema4.model;

import java.util.ArrayList;
import java.util.List;

public class MovieMessage {
    private List<Movie> movies = new ArrayList<>();

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void clearMovies() {
        movies.clear();
    }
}
