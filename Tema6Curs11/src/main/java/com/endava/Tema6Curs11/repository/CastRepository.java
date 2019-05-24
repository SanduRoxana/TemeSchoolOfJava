package com.endava.Tema6Curs11.repository;

import com.endava.Tema6Curs11.model.Cast;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastRepository extends MongoRepository<Cast, String> {
}
