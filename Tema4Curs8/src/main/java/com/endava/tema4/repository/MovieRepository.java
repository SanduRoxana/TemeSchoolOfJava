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
        if(existId(id).equals("Yes")) {
            for(Movie movie : movieMessage.getMovies()) {
                if(movie.getId() == id) {
                    return movie;
                }
            }
        } else {
            System.out.println("Movie with id = " + id + " doesn't exist!");
        }

        return null;
    }

    public void updateMovie(int id, int rating) {
        if(existId(id).equals("Yes")) {
            for(Movie movie : movieMessage.getMovies()) {
                if(movie.getId() == id) {
                    movie.setRating(rating);
                }
            }
        } else {
            System.out.println("Movie with id = " + id + " doesn't exist!");
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

    private String existId(int id) {
        String exist = "No";

        for(int i : getIdList()) {
            if(i == id) {
                exist = "Yes";
            }
        }

        return exist;
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
