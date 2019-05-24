package com.endava.Tema6Curs11.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Genre {

    @Id
    private String id;

    private List<String> genres;

    public Genre() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id='" + id + '\'' +
                ", genres=" + genres +
                '}';
    }
}
