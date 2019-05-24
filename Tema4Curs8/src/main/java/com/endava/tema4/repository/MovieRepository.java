package com.endava.tema4.repository;

import com.endava.tema4.jms.sender.Sender;
import com.endava.tema4.model.Movie;
import com.endava.tema4.model.MovieMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {

    @Autowired
    private Sender sender;

    @Autowired
    private MovieMessage movieMessage;

    public void addMovie(Movie movie) {
        movie.setId(getMaxId() + 1);
        sender.send(movie);
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = movieMessage.getMovies();
        return movies;
    }

    public Movie getById(int id) {
        for(Movie movie : movieMessage.getMovies()) {
            if (movie.getId() == id) {
                return movie;
            }
        }

        return null;
    }

    public void updateMovie(Movie movie) {
        for(Movie m : movieMessage.getMovies()) {
            if(m.getId() == movie.getId()) {
                m.setTitle(movie.getTitle());
                m.setGenre(movie.getGenre());
                m.setRating(movie.getRating());
            }
        }
    }

    public void deleteAllMovies() {
        movieMessage.clearMovies();
    }

    private int getMaxId() {
        int maxId;

        if(movieMessage.getMovies().isEmpty()) {
            maxId = 0;
        } else {
            maxId = getIdList().get(0);
            for(int i = 1; i < getIdList().size(); i++) {
                if(getIdList().get(i) > maxId) {
                    maxId = getIdList().get(i);
                }
            }
        }

        return maxId;
    }

    private List<Integer> getIdList() {
        List<Integer> idList = new ArrayList<>();

        if(!movieMessage.getMovies().isEmpty()) {
            for(Movie movie : movieMessage.getMovies()) {
                idList.add(movie.getId());
            }
        }

        return idList;
    }
}
