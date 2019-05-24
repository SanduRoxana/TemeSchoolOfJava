package com.endava.Tema1.service;

import com.endava.Tema1.model.Movie;
import com.endava.Tema1.model.Rating;
import com.endava.Tema1.model.User;
import com.endava.Tema1.repository.MovieRepository;
import com.endava.Tema1.repository.RatingRepository;
import com.endava.Tema1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    public void addRating(String userName, String movieTitle, double movieRating) {
        if(findUserIdByName(userName).isEmpty() || findMovieIdByTitle(movieTitle).isEmpty()) {
            System.out.println("User or Movie doesn't exist in database!");
        } else {
            Rating rating = new Rating();

            rating.setUserId(findUserIdByName(userName));
            rating.setMovieId(findMovieIdByTitle(movieTitle));
            rating.setRating(movieRating);

            ratingRepository.insert(rating);
            updateRatingMovies();
        }
    }

    public List<Rating> findAllRating() {
        return ratingRepository.findAll();
    }

    public void deleteAllRating() {
        ratingRepository.deleteAll();
    }

    public String findUserIdByName(String name) {
        for(User user : userRepository.findAll()) {
            if(name.equals(user.getName())) {
                return user.getId();
            }
        }
        return "";
    }

    public String findMovieIdByTitle(String title) {
        for(Movie movie : movieRepository.findAll()) {
            if(title.equals(movie.getTitle())) {
                return movie.getId();
            }
        }
        return "";
    }

    public void updateRatingMovies() {
        for(Movie movie : movieRepository.findAll()) {
            double sumRating = 0;
            double count = 0;
            double avgRating;

            for(Rating rating : ratingRepository.findAll()) {
                if(movie.getId().equals(rating.getMovieId())) {
                    sumRating += rating.getRating();
                    count++;
                }
            }

            try {
                avgRating = sumRating / count;
            } catch (ArithmeticException e) {
                avgRating = 0.0;
            }
            avgRating = Math.round(avgRating * 10.0) / 10.0;

            movie.setRating(avgRating);

            movieRepository.save(movie);
        }
    }
}
