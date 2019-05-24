package com.endava.tema4.service;

import com.endava.tema4.model.Movie;
import com.endava.tema4.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public void add(String title, String genre, int rating) {
        if(title.isEmpty() || genre.isEmpty() || rating < 0 || rating > 10) {
            System.out.println("Input parameters don't match!");
        } else {
            Movie movie = new Movie(title, genre, rating);
            movieRepository.addMovie(movie);
        }
    }

    public List<Movie> getAll() {
        return movieRepository.getAllMovies();
    }

    public Movie getById(int id) {
        if(id <= 0) {
            System.out.println("Input parameters don't match!");
            return null;
        } else {
            Movie movie = movieRepository.getById(id);
            if(movie == null) {
                System.out.println("Movie with id = " + id + " doesn't exist!");
                return null;
            } else {
                return movie;
            }
        }
    }

    public void update(Movie movie) {
        if(movie.getTitle().isEmpty() || movie.getGenre().isEmpty() || movie.getRating() < 0 || movie.getRating() > 10) {
            System.out.println("Input parameters don't match!");
        } else {
            movieRepository.updateMovie(movie);
        }
    }

    public void deleteAll() {
        movieRepository.deleteAllMovies();
    }
}
