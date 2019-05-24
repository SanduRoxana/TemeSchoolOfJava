package com.example.exemplu6.controller;

import com.example.exemplu6.model.Movie;
import com.example.exemplu6.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping(path = "/add")
    public int add(@RequestParam String title, @RequestParam String genre, @RequestParam int rating, HttpServletResponse response) {
        int rsp = movieService.add(title, genre, rating);
        if (rsp == 0) {
             response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return rsp;
    }

    @GetMapping(path = "/getAll")
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @GetMapping(path = "/getById/{id}")
    public Movie getById(@PathVariable int id, HttpServletResponse response) {
        Movie movie = movieService.getById(id);
        if(movie == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return movie;
    }

    @PutMapping(path = "/update")
    public int update(@RequestBody Movie movie, HttpServletResponse response) {
        int rsp = movieService.update(movie);
        if(rsp == 0) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return rsp;
    }

    @DeleteMapping(path = "/delete/{id}")
    public int delete(@PathVariable int id, HttpServletResponse response) {
        int rsp = movieService.delete(id);
        if(rsp == 0) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return rsp;
    }
}
