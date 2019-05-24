package com.endava.Tema6Curs11.service;

import com.endava.Tema6Curs11.model.Cast;
import com.endava.Tema6Curs11.model.Genre;
import com.endava.Tema6Curs11.model.Movie;
import com.endava.Tema6Curs11.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CastService castService;

    @Autowired
    private GenreService genreService;

    public Movie addMovie(Movie movie) {
        Cast cast = castService.addCast(movie.getCast());
        Genre genre = genreService.addGenre(movie.getGenre());
        movie.setCast(cast);
        movie.setGenre(genre);
        return movieRepository.save(movie);
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }
}
