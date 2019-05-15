package com.endava.tema4.service;

import com.endava.tema4.model.Movie;
import com.endava.tema4.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public void add(String title, String genre, int rating, HttpServletResponse response) {
        if(!title.equals("") && !genre.equals("") && rating > 0 && rating <= 10) {
            Movie movie = new Movie(title, genre, rating);
            movieRepository.addMovie(movie);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            System.out.println("Input parameters don't match!");

        }
    }

    public List<Movie> getAll() {
        return movieRepository.getAllMovies();
    }

    public Movie getById(int id, HttpServletResponse response) {
        if(id > 0) {
            return movieRepository.getById(id);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            System.out.println("Input parameters don't match!");
            return null;
        }
    }

    public void update(int id, int rating, HttpServletResponse response) {
        if(id > 0 && rating > 0 && rating <= 10) {
            movieRepository.updateMovie(id, rating);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            System.out.println("Input parameters don't match!");
        }
    }

    public void deleteAll() {
        movieRepository.deleteAllMovies();
    }
}
