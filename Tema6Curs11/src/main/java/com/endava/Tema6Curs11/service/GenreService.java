package com.endava.Tema6Curs11.service;

import com.endava.Tema6Curs11.model.Genre;
import com.endava.Tema6Curs11.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public Genre addGenre(Genre genre) {
        return genreRepository.save(genre);
    }
}
