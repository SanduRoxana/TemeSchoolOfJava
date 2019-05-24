package com.endava.Tema6Curs11.service;

import com.endava.Tema6Curs11.model.Cast;
import com.endava.Tema6Curs11.repository.CastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CastService {

    @Autowired
    private CastRepository castRepository;

    public Cast addCast(Cast cast) {
        return castRepository.save(cast);
    }
}
