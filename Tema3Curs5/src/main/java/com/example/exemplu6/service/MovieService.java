package com.example.exemplu6.service;

import com.example.exemplu6.model.Movie;
import com.example.exemplu6.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public int add(String title, String genre, int rating, HttpServletResponse response) {
        if(!title.equals("") && !genre.equals("") && rating > 0 && rating <= 10) {
            Movie movie = new Movie(title, genre, rating);
            return movieRepository.addMovie(movie);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            System.out.println("Input parameters don't match!");
        }

        return 0;
    }

    public List<Movie> getAll() {
        return movieRepository.getAllMovies();
    }

    public Movie getById(int id, HttpServletResponse response) {
        if(id > 0) {
            return movieRepository.getById(id);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        return null;
    }

    public int update(int id, int rating, HttpServletResponse response) {
        if(id > 0 && rating > 0 && rating <= 10) {
            return movieRepository.updateMovie(id, rating);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            System.out.println("Input data doesn't match!");
        }
        return 0;
    }

    public int delete(int id, HttpServletResponse response) {
        if(id > 0) {
            return movieRepository.deleteMovie(id);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            System.out.println("Input variable doesn't match!");
        }
        return 0;
    }
}
