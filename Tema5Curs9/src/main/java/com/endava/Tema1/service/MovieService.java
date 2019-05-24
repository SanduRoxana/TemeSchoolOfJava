package com.endava.Tema1.service;

import com.endava.Tema1.model.Movie;
import com.endava.Tema1.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public void addMovie(String title, String genre) {
        Movie movie = new Movie(title, genre);
        movieRepository.insert(movie);
    }

    public void insertMovies() {
        movieRepository.deleteAll();
        movieRepository.insert(new Movie("Avengers: Endgame", "action"));
        movieRepository.insert(new Movie("The Greatest Showman", "musical"));
        movieRepository.insert(new Movie("Logan", "action"));
        movieRepository.insert(new Movie("Beauty and the Beast", "fantasy"));
        movieRepository.insert(new Movie("Baywatch", "comedy"));
        movieRepository.insert(new Movie("Downsizing", "action"));
        movieRepository.insert(new Movie("Deadpool", "comedy"));
        movieRepository.insert(new Movie("The Founder", "biography"));
        movieRepository.insert(new Movie("Titanic", "drama"));
        movieRepository.insert(new Movie("Coco before Chanel", "biography"));
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public void deleteAllMovies() {
        movieRepository.deleteAll();
    }
}
