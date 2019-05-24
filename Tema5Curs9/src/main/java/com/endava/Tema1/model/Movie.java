package com.endava.Tema1.model;

import org.springframework.data.annotation.Id;

public class Movie {

    @Id
    private String id;

    private String title;
    private String genre;
    private double rating;

    public Movie() {
    }

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
        this.rating = 0.0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
