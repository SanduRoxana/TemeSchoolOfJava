package com.example.exemplu6.service;

import com.example.exemplu6.model.Movie;
import com.example.exemplu6.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public int add(String title, String genre, int rating) {
        if(title.isEmpty() || genre.isEmpty() || rating < 0 || rating > 10) {
            System.out.println("Input parameters don't match!");
            return 0;
        } else {
            Movie movie = new Movie(title, genre, rating);
            return movieRepository.addMovie(movie);
        }
    }

    public List<Movie> getAll() {
        return movieRepository.getAllMovies();
    }

    public Movie getById(int id) {
        if(id <= 0) {
            System.out.println("Input data doesn't match!");
            return null;
        } else {
            try {
                return movieRepository.getById(id);
            } catch (Exception e) {
                System.out.println("Movie with id = " + id + " doesn't exist in database!");
                return null;
            }
        }
    }

    public int update(Movie movie) {
        if(movie.getTitle().isEmpty() || movie.getGenre().isEmpty() || movie.getRating() < 0 || movie.getRating() > 10) {
            System.out.println("Input data doesn't match!");
            return 0;
        } else {
            int rsp = movieRepository.updateMovie(movie);
            if(rsp == 0) {
                System.out.println("Movie with id = " + movie.getId() + " doesn't exist in database!");
                return 0;
            } else {
                System.out.println("Movie updated!");
                return rsp;
            }
        }
    }

    public int delete(int id) {
        if(id <= 0) {
            System.out.println("Input variable doesn't match!");
            return 0;
        } else {
            int rsp = movieRepository.deleteMovie(id);
            if(rsp == 0) {
                System.out.println("Movie with id = " + id + " doesn't exist in database!");
                return 0;
            } else {
                System.out.println("Movie with id = " + id + " deleted!");
                return rsp;
            }
        }
    }
}
